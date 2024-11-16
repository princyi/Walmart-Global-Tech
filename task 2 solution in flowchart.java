```plaintext
+-------------------------------------+
|          DataProcessor             |
+-------------------------------------+
| - currentMode: ModeIdentifier      |
| - currentDatabase: DatabaseIdentifier |
+-------------------------------------+
| + configure(mode: ModeIdentifier,  |
|   db: DatabaseIdentifier): void    |
| + process(datapoint: Datapoint): void |
+-------------------------------------+
              /|\
               |
  +------------+-------------+
  |            |             |
+------------+ +-----------+ +----------+
| PostgresDB | | RedisDB   | | ElasticDB|
+------------+ +-----------+ +----------+
| + connect(): void        | | + connect(): void   |
| + insert(dp: Datapoint): void  | | + insert(dp: Datapoint): void |
| + validate(dp: Datapoint): void| | + validate(dp: Datapoint): void|
+--------------------------------+ +-------------------------------+
```

