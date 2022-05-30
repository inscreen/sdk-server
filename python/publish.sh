#!/bin/bash

(
    echo '[testpypi]'
    echo '  username = __token__'
    echo "  password = ${TESTPYPI_TOKEN}"
    echo '[pypi]'
    echo '  username = __token__'
    echo "  password = ${PYPI_TOKEN}"
) > ~/.pypirc

rm -fr ./dist
tox -e build,publish
# tox -e publish -- --repository pypi