# Crypto To USD

# Usages
    GET /api/crypto/{currency}/usd
    
    GET /api/crypto/{currency}/usd/{amount}
        - {amount} being the USD value, decimals allowed.
        
    Supported {currency} macros are
        - btc
        - ltc
        - eth

# Response
    - Assuming you're using margin.type flat with a margin.value of 200
    
    GET /api/crypto/{currency}/usd
    {
        "price": 10000,
        "margin": {
            "buy": 10200, 
            "sell": 9800 
        }
    }
    
    - Assuming you're using margin.type percentage with a margin.value of 10
    
    GET /api/crypto/{currency}/usd
    {
        "price": 10000,
        "margin": {
            "buy": 11000,
            "sell": 9000
        }    
    }
    
    - Assuming you set {amount} as 100 and BitCoin is worth 9,488.34 USD
    
    GET /api/crypto/{currency}/usd/{amount}
    {
        "amount": 0.01054741
    }
            
# Application Property Values
    xxx.margin.type
        - Supported types are
            - flat
                - This will return a "margin" (or a "fee") which will use the property xxx.margin.value as a **whole** value.
            - percentage
                - This will return a "margin" (or a "fee") which will use the property xxx.margin.value as a percentage.