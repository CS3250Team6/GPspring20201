const request = require("supertest");
const app = require("../src/app");

describe("POST /api/insert", () => {
    it("should return 200 OK", async (done) => {
        const data = {
            productID: "testProductId",
            quantity: 1,
            wholesaleCost: 11.11,
            salePrice: 11.11,
            supplierID: "testSupplierId"
        };

        request(app)
            .post("/api/insert")
            .send(data)
            .expect("Content-Type", /json/)
            .end((err, res) => {
                expect(res.statusCode).toBe(200);
                done();
            });
    });
});
