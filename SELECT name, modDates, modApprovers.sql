SELECT 
    u.name Name,
    a.mod1,
    a.mod2,
    a.mod3,
    a.mod4,
    a.mod5,
    a.mod6,
    a.mod7,
    a.mod8,
    a.mod9,
    a.mod10,
    a.mod11,
    a.mod12,
    a.mod13,
    a.mod14,
    a.mod1Approver,
    a.mod2Approver,
    a.mod3Approver,
    a.mod4Approver,
    a.mod5Approver,
    a.mod6Approver,
    a.mod7Approver,
    a.mod8Approver,
    a.mod9Approver,
    a.mod10Approver,
    a.mod11Approver,
    a.mod12Approver,
    a.mod13Approver,
    a.mod14Approver
FROM
    approvals a
        INNER JOIN
    user u ON a.studentID = u.userID;