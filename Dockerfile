# Use the lightweight Nginx web server image
FROM nginx:alpine

# Copy all your HTML files into the Nginx web root directory
COPY . /usr/share/nginx/html

# Expose port 80 (the default web port)
EXPOSE 80

# Start Nginx
CMD ["nginx", "-g", "daemon off;"]
