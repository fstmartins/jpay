echo "*****************"
echo "Starting JPay App"
echo "*****************"
mvn clean install

echo "*****************************"
echo "Building JPay App with Docker"
echo "*****************************"
docker build -t jpay .

echo "*********************************************************"
echo "Starting run process of JPay App with Docker on port ${1:-8080}"
echo "*********************************************************"
docker run -p "${1:-8080}":8080 jpay