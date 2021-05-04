const request = require("supertest");
const app = require("../src/app");

describe("DELETE /api/delete/test", () => {
    it("should return 404 BAD REQUEST", async (done) => {
        request(app)
            .post("/api/read/test")
            .expect("Content-Type", /json/)
            .end((err, res) => {
                expect(res.statusCode).toBe(404);
                done();
            });
    });
});
