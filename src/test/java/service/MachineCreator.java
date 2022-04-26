package service;

import model.VirtualMachine;

public class MachineCreator {
    private static final String NUMBER_OF_INSTANCES = "testdata.virtual-machine.number-of-instances";
    private static final String OPERATING_SYSTEM = "testdata.virtual-machine.operating-system";
    private static final String MACHINE_CLASS = "testdata.virtual-machine.machine-class";
    private static final String MACHINE_SERIES = "testdata.virtual-machine.machine-series";
    private static final String MACHINE_TYPE = "testdata.virtual-machine.machine-type";
    private static final String GPU_TYPE = "testdata.virtual-machine.gpu-type";
    private static final String NUMBER_OF_GPUS = "testdata.virtual-machine.number-of-gpus";
    private static final String LOCAL_SSD = "testdata.virtual-machine.local-ssd";
    private static final String DATACENTER_LOCATION = "testdata.virtual-machine.datacenter-location";
    private static final String COMMITTED_USAGE = "testdata.virtual-machine.committed-usage";

    public static VirtualMachine createVirtualMachine() {
        return new VirtualMachine(TestDataReader.getTestData(NUMBER_OF_INSTANCES), TestDataReader.getTestData(OPERATING_SYSTEM),
                TestDataReader.getTestData(MACHINE_CLASS), TestDataReader.getTestData(MACHINE_SERIES),
                TestDataReader.getTestData(MACHINE_TYPE), TestDataReader.getTestData(GPU_TYPE),
                TestDataReader.getTestData(NUMBER_OF_GPUS), TestDataReader.getTestData(LOCAL_SSD),
                TestDataReader.getTestData(DATACENTER_LOCATION), TestDataReader.getTestData(COMMITTED_USAGE));
    }
}
