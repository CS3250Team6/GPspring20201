const request = require("supertest");
const app = require("../src/app");

describe("POST /api/read", () => {
    it("should return No product found.", async (done) => {
        const data = {
            productid: "shouldNotFindTest"
        };

        request(app)
            .post("/api/read")
            .send(data)
            .expect("Content-Type", /json/)
            .end((err, res) => {
                expect(res.statusCode).toBe(200);
                expect(res.body).toEqual({ message: "No product found." });
                done();
            });
    });
});
