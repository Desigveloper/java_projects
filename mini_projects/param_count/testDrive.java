package param_count;

class TestDrive {
    public static void main(String[] args) {
        ParamCount param = new ParamCount();
        int paramSize  = param.countParam(1, 2, 3, 4, 5, 7, 6);
        System.out.println("Parameters: " + paramSize);


        ArgsCount arg = new ArgsCount();
        int argSize = arg.countArgs(args);
        System.out.println("Arguments: " + argSize);
    }
}

class ParamCount {
    /**
     * paramCount
     */
    public int countParam(int ... params) {
        return params.length;
    }
}

class ArgsCount {
    public int countArgs(String[] args) {
        return args.length;
    }
}
