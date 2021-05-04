const request = require("supertest");
const app = require("../src/app");

describe("PUT /api/update", () => {
    it("should return 404 BAD REQUEST", async (done) => {
        const data = {
            updateProductid: "test",
            quantity: 1
        };

        request(app)
            .post("/api/update")
            .send(data)
            .expect("Content-Type", /json/)
            .end((err, res) => {
                expect(res.statusCode).toBe(404);
                done();
            });
    });
});
