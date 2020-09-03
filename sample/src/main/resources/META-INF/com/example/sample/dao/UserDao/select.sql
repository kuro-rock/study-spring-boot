SELECT
    user_id
    ,name
    ,email
    ,password
    ,createdBy
    ,createdAt
    ,updatedBy
    ,updatedAt
    ,deletedBy
    ,deletedAt
    ,version
FROM
    users
WHERE
    deletedAt IS NULL
/*%if criteria.id != null */
AND user_id = /* criteria.id */1
/*%end*/
/*%if criteria.email != null */
AND email = /* criteria.email */'kuroda@example.com'
/*%end*/