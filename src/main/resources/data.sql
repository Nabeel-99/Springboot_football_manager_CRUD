-- league table
INSERT INTO league (id, name, country, season)
VALUES (3001, 'Ligue 1', 'France', '2023/2024');

INSERT INTO league (id, name, country, season)
VALUES (3002, 'Premier League', 'England', '2023/2024');

INSERT INTO league (id, name, country, season)
VALUES (3003, 'La Liga', 'Spain', '2023/2024');

INSERT INTO league (id, name, country, season)
VALUES (3004, 'Bundesliga', 'Germany', '2023/2024');

INSERT INTO league (id, name, country, season)
VALUES (3005, 'Serie A', 'Italy', '2023/2024');


-- stadium table
INSERT INTO stadium (id, name, location, capacity)
VALUES (4001, 'Parc des Princes', 'Paris', 48712);

INSERT INTO stadium (id, name, location, capacity)
VALUES (4002, 'Old Trafford', 'Manchester', 74879);

INSERT INTO stadium (id, name, location, capacity)
VALUES (4003, 'Santiago Bernabeu', 'Madrid', 81044);

INSERT INTO stadium (id, name, location, capacity)
VALUES (4004, 'Allianz Arena', 'Munich', 75000);

INSERT INTO stadium (id, name, location, capacity)
VALUES (4005, 'Allianz Stadium', 'Turin', 41507);

-- team table
INSERT INTO team (id, name, city, league_id, stadium_id)
VALUES (1001, 'Paris Saint-Germain', 'Paris', 3001, 4001);

INSERT INTO team (id, name, city, league_id, stadium_id)
VALUES (1002, 'Manchester United', 'Manchester', 3002, 4002);

INSERT INTO team (id, name, city, league_id, stadium_id)
VALUES (1003, 'Real Madrid', 'Madrid', 3003, 4003);

INSERT INTO team (id, name, city, league_id, stadium_id)
VALUES (1004, 'FC Bayern Munich', 'Munich', 3004, 4004);

INSERT INTO team (id, name, city, league_id, stadium_id)
VALUES (1005, 'Juventus', 'Turin', 3005, 4005);


-- player table
INSERT INTO player (id, first_name, last_name, position, club, shirt_number, team_id)
VALUES (2001, 'Lionel', 'Messi', 'FORWARD', 'Paris Saint-Germain', 30, 1001);

INSERT INTO player (id, first_name, last_name, position, club, shirt_number, team_id)
VALUES (2002, 'Cristiano', 'Ronaldo', 'FORWARD', 'Manchester United', 7, 1002);

INSERT INTO player (id, first_name, last_name, position, club, shirt_number, team_id)
VALUES (2003, 'Kevin', 'De Bruyne', 'MIDFIELDER', 'Manchester City', 17, 1003);

INSERT INTO player (id, first_name, last_name, position, club, shirt_number, team_id)
VALUES (2004, 'Virgil', 'Van Dijk', 'DEFENDER', 'Liverpool', 4, 1004);

INSERT INTO player (id, first_name, last_name, position, club, shirt_number, team_id)
VALUES (2005, 'Jan', 'Oblak', 'GOALKEEPER', 'Atletico Madrid', 1, 1005);





-- kit table
-- kit table
INSERT INTO kit (id, home_jersey_color, away_jersey_color, kit_manufacturer, team_id)
VALUES (5001, 'Navy Blue', 'White', 'Nike', 1001);

INSERT INTO kit (id, home_jersey_color, away_jersey_color, kit_manufacturer, team_id)
VALUES (5002, 'Red', 'Black', 'Adidas', 1002);

INSERT INTO kit (id, home_jersey_color, away_jersey_color, kit_manufacturer, team_id)
VALUES (5003, 'White', 'Black', 'Adidas', 1003);

INSERT INTO kit (id, home_jersey_color, away_jersey_color, kit_manufacturer, team_id)
VALUES (5004, 'Red', 'White', 'Puma', 1004);

INSERT INTO kit (id, home_jersey_color, away_jersey_color, kit_manufacturer, team_id)
VALUES (5005, 'Black', 'Yellow', 'Puma', 1005);
