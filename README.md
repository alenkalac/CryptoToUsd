# Crypto To USD

# Usage
    GET /api/crypto/{currency}/usd
        - Supported {currency} types are
            - btc
            - ltc
            - eth
            
# Application Property Values
    xxx.margin.type
        - Supported types are
            - flat
                - This will return a "margin" (or a "fee") which will use the property xxx.margin.value as a **whole** value.
            - percentage
                - This will return a "margin" (or a "fee") which will use the property xxx.margin.value as a percentage.
