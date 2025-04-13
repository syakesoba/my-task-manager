const API_URL = "http://localhost:8080/api/tasks";

export const getTasks = async () => {
  const response = await fetch(API_URL);
  const data = await response.json();
  console.log("Fetched data:", data);
  return Array.isArray(data) ? data : [];
};

export const createTask = async (task: { title: string; description: string }) => {
  const response = await fetch(API_URL, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(task),
  });
  return response.json();
};

export const updateTask = async (id: string, task: { title: string; description: string }) => {
  const response = await fetch(`${API_URL}/${id}`, {
    method: "PUT",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(task),
  });
  return response.json();
};

export const deleteTask = async (id: string) => {
  await fetch(`${API_URL}/${id}`, { method: "DELETE" });
};