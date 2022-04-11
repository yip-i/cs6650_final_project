import express from "express";
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

app.get("/skiers/:resortID/seasons/:seasonsID/days/:dayID/skiers/:skierID", async(req, res) => {
    // const skierID = parseInt(req.params.resortID, 10);
    res.sendStatus(200);
});

app.post("/skiers/:resortID/seasons/:seasonsID/days/:dayID/skiers/:skierID", async(req, res) => {
    res.sendStatus(201);
});