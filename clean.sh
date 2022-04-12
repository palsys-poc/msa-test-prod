oc delete deploy product
oc delete svc product
oc delete is product
oc delete route product
oc delete bc product
oc delete secret product-generic-webhook-secret
oc delete secret product-github-webhook-secret
oc delete hpa msa-test-git -n nanshan
oc delete hpa product -n nanshan
echo 'status ok'

