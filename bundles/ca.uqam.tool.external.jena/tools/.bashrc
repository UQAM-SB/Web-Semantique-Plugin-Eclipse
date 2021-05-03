export FUSEKI_HOME=
export FUSEKI_BASE=
export JENA_HOME="$( cd "$( dirname "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )"
export PATH=$PATH:$JENA_HOME/bin

export PS2='> '
export PS1="\u/\W[\#]> "
alias jena_cd="cd $JENA_HOME"
alias fuseki_cd="cd $FUSEKI_HOME"
