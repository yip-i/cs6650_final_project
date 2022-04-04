import express from "express";
import pkg from "@prisma/client";
import morgan from "morgan";
import cors from "cors";

const PORT = parseInt(process.env.PORT) || 8080;

const app = express();

app.use(cors());
app.use(express.urlencoded({ extended: true }));
app.use(express.json());
app.use(morgan("dev"));

app.listen(PORT, () => {
    console.log(`Server running on http://localhost:${PORT} 🎉 🚀`);
})

app.get("/skiers/", async(req, res) => {

});

app.post("/skiers/", async(req, res) => {

});