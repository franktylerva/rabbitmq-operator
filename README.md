# rabbitmq-operator

Install the RabbitMQ Cluster Operator
```
kubectl apply -f "https://github.com/rabbitmq/cluster-operator/releases/latest/download/cluster-operator.yml"
```

Install Certificate Manager
```
kubectl apply -f https://github.com/jetstack/cert-manager/releases/download/v1.3.1/cert-manager.yaml
```

Install the RabbitMQ Topology Operator
```
kubectl apply -f https://github.com/rabbitmq/messaging-topology-operator/releases/latest/download/messaging-topology-operator-with-certmanager.yaml
```

Install the Producer
```
helm upgrade producer charts/producer --install
```

Install the Consumer
```
helm upgrade consumer charts/consumer --install
```

