Current State:
all 4 API function properly as requested
error handling:
    restaurant api:
        reject value when posting without name/cuisines
        posting without isKosher is valid and assumed not kosher
        reject DELETE/PUT request if restaurant id doesn't exist (404 not found)
    dishes api:
        reject value when posting without name/description/price/improper price
        reject PUT/DELETE/POST if restaurant/dish doesn't exist (404 not found)
    order api:
        reject value when posting without ids/improper order items list
        reject POST if restaurant doesn't exist/ doesn't have order dishes (404 not found)
    rating api:
        reject value when posting without ids/improper rating (rates are 1 to 5 inclusive)
        reject POST if restaurant doesn't exist (404 not found)
database handling:
    implemented one-to-many (and many-to-one) relationship between restaurant and dishes/orders/ratings,
    so that when a restaurant is deleted all associated entries will be deleted as well
TODO:
    scripted tests that simulate the manual tests i've done:
        full APIs functionality tests and error handling tests
    change projections to DTOs, so that extra fields received on POST will be ignored*
    *this is up to debate, since there's no reason existing restaurants wouldn't be able to be entered
    into the database with prior rating and dishes - API functionality decision