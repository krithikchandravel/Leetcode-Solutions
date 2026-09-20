SELECT
    ROUND(
        (
            SELECT COUNT(*)
            FROM (
                SELECT DISTINCT a.player_id
                FROM Activity a
                JOIN (
                    SELECT
                        player_id,
                        MIN(event_date) AS first_date
                    FROM Activity
                    GROUP BY player_id
                ) t
                    ON a.player_id = t.player_id
                    AND DATEDIFF(a.event_date, t.first_date) = 1
            ) x
        )
        / COUNT(DISTINCT player_id),
        2
    ) AS fraction
FROM Activity;