set PATH_ROOT=%CD%

CD store
docker build -t ms-store:latest .
docker run -p 8080:8080 -d ms-store:latest
docker tag ms-store:latest joallyzg/ms-store:latest
docker push joallyzg/ms-store:latest

CD %PATH_ROOT%
CD store-frontend
docker build -t app-store:latest .
docker run -p 3000:3000 -d app-store:latest
docker tag app-store:latest joallyzg/app-store:latest
docker push joallyzg/app-store:latest

CD %PATH_ROOT%
docker-compose up -d