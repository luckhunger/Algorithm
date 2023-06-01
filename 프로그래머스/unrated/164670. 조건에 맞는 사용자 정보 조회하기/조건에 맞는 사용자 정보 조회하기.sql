-- 코드를 입력하세요
SELECT DISTINCT USR.USER_ID
     , USR.NICKNAME
     , USR.CITY || ' ' || USR.STREET_ADDRESS1 || ' ' || USR.STREET_ADDRESS2 AS 전체주소
     , REGEXP_REPLACE(USR.TLNO, '(.{3})(.+)(.{4})', '\1-\2-\3') AS 전화번호
FROM USED_GOODS_BOARD BOD
INNER JOIN USED_GOODS_USER USR
        ON BOD.WRITER_ID = USR.USER_ID
WHERE 1=1
  AND USR.USER_ID IN(
                        SELECT WRITER_ID
                        FROM USED_GOODS_BOARD
                        GROUP BY WRITER_ID
                        HAVING COUNT(WRITER_ID) >= 3
                    )
ORDER BY USR.USER_ID DESC
;