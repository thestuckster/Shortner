# Shorter
The URL shortening system

## Endpoints

### Shorten
request
```
POST /shorten
{
    "url": "www.google.com"
}
```

response
```
{
    "shortId": "abc123"
}
```

### Lengthen

request
```
GET /lengthen/<id> 
/lengthe/abc123

```

response
```
HTTP 302 => www.google.com
```
