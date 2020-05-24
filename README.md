# Crypto To USD

# Usage
    GET /api/crypto/{currency}/usd
        - Supported {currency} types are
            - btc
            - ltc
            - eth

# Response
    - Assuming you're using margin.type flat with a margin.value of 200

    {
        "price": 10000,
        "margin": {
            "buy": 10200, 
            "sell": 9800 
        }
    }
    
    - Assuming you're using margin.type percentage with a margin.value of 10
    
    {
        "price": 10000,
        "margin": {
            "buy": 11000,
            "sell": 9000
        }    
    }
            
# Application Property Values
    xxx.margin.type
        - Supported types are
            - flat
                - This will return a "margin" (or a "fee") which will use the property xxx.margin.value as a **whole** value.
            - percentage
                - This will return a "margin" (or a "fee") which will use the property xxx.margin.value as a percentage.