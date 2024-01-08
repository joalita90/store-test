set PATH_ROOT=%CD%

CD store-backend
docker build -t ms-store:latest .
docker run --name ms-store -p 8080:8080 -d ms-store:latest
docker tag ms-store:latest joallyzg/ms-store:latest
docker push joallyzg/ms-store:latest
docker stop ms-store
docker rm ms-store
docker rmi ms-store
docker stop joallyzg/ms-store
docker rm joallyzg/ms-store
docker rmi joallyzg/ms-store

CD %PATH_ROOT%
CD store-frontend
docker build -t app-store:latest .
docker run --name app-store -p 3000:3000 -d app-store:latest
docker tag app-store:latest joallyzg/app-store:latest
docker push joallyzg/app-store:latest
docker stop app-store
docker rm app-store
docker rmi app-store
docker stop joallyzg/app-store
docker rm joallyzg/app-store
docker rmi joallyzg/app-store

CD %PATH_ROOT%
docker-compose up -d