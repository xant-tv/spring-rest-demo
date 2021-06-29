# Crunch Numbers Endpoint
```
POST input
```
Calculates the square root of the sum of squares of the three largest numbers from a list of values.

## Parameters
Field | Data Type | Required | Description
--- | --- | --- | ---
data | array / numeric | Y | List of input numbers for the calculation.

## Example
### Request
```
POST http://localhost:8080/input
```
### Body
```json
{
    "data": [5, 4, 6, 1]
}
```
### Response
```json
{
    "output": 8.774964387392123
}
```
