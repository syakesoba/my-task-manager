import React, { useState, useEffect } from "react";
import { getTasks, createTask, deleteTask } from "../services/api";
import "./TaskManager.css";

type Task = {
  id: string;
  title: string;
  description: string;
};

const TaskManager = () => {
  const [tasks, setTasks] = useState<Task[]>([]);
  const [newTask, setNewTask] = useState({ title: "", description: "" });

  useEffect(() => {
    getTasks().then(setTasks).catch((error) => {
        console.error("Failed to fetch tasks:", error);
      });
  }, []);

  const handleCreateTask = async () => {
    const task = await createTask(newTask);
    setTasks([...tasks, task]);
  };

  const handleDeleteTask = async (id: string) => {
    await deleteTask(id);
    setTasks(tasks.filter((task) => task.id !== id));
  };

  return (
    <div className="task-manager">
      <h2>Task Manager</h2>
      <div className="input-container">
        <input
          type="text"
          placeholder="Title"
          onChange={(e) => setNewTask({ ...newTask, title: e.target.value })}
        />
        <input
          type="text"
          placeholder="Description"
          onChange={(e) => setNewTask({ ...newTask, description: e.target.value })}
        />
        <button onClick={handleCreateTask}>Add Task</button>
      </div>
      <ul className="task-list">
        {tasks.map((task) => (
          <li className="task-card" key={task.id}>
            {task.title} - {task.description}
            <button className="delete-button" onClick={() => handleDeleteTask(task.id)}>
              Delete
            </button>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default TaskManager;