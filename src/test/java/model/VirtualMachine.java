package model;

import java.util.Objects;

public class VirtualMachine {
    private String numberOfInstances;
    private String operatingSystem;
    private String machineClass;
    private String machineSeries;
    private String machineType;
    private String gpuType;
    private String numberOfGpus;
    private String localSsd;
    private String datacenterLocation;
    private String committedUsage;

    public VirtualMachine(String numberOfInstances, String operatingSystem, String machineClass,
                          String machineSeries, String machineType, String gpuType, String numberOfGpus,
                          String localSsd, String datacenterLocation, String committedUsage) {
        this.numberOfInstances = numberOfInstances;
        this.operatingSystem = operatingSystem;
        this.machineClass = machineClass;
        this.machineSeries = machineSeries;
        this.machineType = machineType;
        this.gpuType = gpuType;
        this.numberOfGpus = numberOfGpus;
        this.localSsd = localSsd;
        this.datacenterLocation = datacenterLocation;
        this.committedUsage = committedUsage;
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public void setNumberOfInstances(String numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getMachineClass() {
        return machineClass;
    }

    public void setMachineClass(String machineClass) {
        this.machineClass = machineClass;
    }

    public String getMachineSeries() {
        return machineSeries;
    }

    public void setMachineSeries(String machineSeries) {
        this.machineSeries = machineSeries;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getGpuType() {
        return gpuType;
    }

    public void setGpuType(String gpuType) {
        this.gpuType = gpuType;
    }

    public String getNumberOfGpus() {
        return numberOfGpus;
    }

    public void setNumberOfGpus(String numberOfGpus) {
        this.numberOfGpus = numberOfGpus;
    }

    public String getLocalSsd() {
        return localSsd;
    }

    public void setLocalSsd(String localSsd) {
        this.localSsd = localSsd;
    }

    public String getDatacenterLocation() {
        return datacenterLocation;
    }

    public void setDatacenterLocation(String datacenterLocation) {
        this.datacenterLocation = datacenterLocation;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

    public void setCommittedUsage(String committedUsage) {
        this.committedUsage = committedUsage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VirtualMachine that = (VirtualMachine) o;
        return numberOfInstances == that.numberOfInstances && operatingSystem == that.operatingSystem && numberOfGpus == that.numberOfGpus &&
                Objects.equals(machineClass, that.machineClass) && Objects.equals(machineSeries, that.machineSeries) &&
                Objects.equals(machineType, that.machineType) && Objects.equals(gpuType, that.gpuType) &&
                Objects.equals(localSsd, that.localSsd) && Objects.equals(datacenterLocation, that.datacenterLocation) &&
                Objects.equals(committedUsage, that.committedUsage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfInstances, operatingSystem, machineClass, machineSeries, machineType, gpuType,
                numberOfGpus, localSsd, datacenterLocation, committedUsage);
    }

    @Override
    public String toString() {
        return "VirtualMachine{" +
                "numberOfInstances=" + numberOfInstances +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", machineClass='" + machineClass + '\'' +
                ", machineSeries='" + machineSeries + '\'' +
                ", machineType='" + machineType + '\'' +
                ", gpuType='" + gpuType + '\'' +
                ", numberOfGpus=" + numberOfGpus +
                ", localSsd='" + localSsd + '\'' +
                ", datacenterLocation='" + datacenterLocation + '\'' +
                ", committedUsage='" + committedUsage + '\'' +
                '}';
    }
}
