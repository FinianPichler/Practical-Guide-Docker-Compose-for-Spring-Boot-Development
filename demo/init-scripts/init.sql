-- This file is automatically executed when PostgreSQL container starts
-- It can be used to seed initial data

-- Example users (optional)
INSERT INTO users (username, email, created_at) VALUES
    ('john_doe', 'john@example.com', CURRENT_TIMESTAMP),
    ('jane_smith', 'jane@example.com', CURRENT_TIMESTAMP)
ON CONFLICT (username) DO NOTHING;
