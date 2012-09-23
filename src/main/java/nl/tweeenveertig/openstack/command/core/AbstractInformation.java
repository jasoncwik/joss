package nl.tweeenveertig.openstack.command.core;

import nl.tweeenveertig.openstack.headers.Header;
import nl.tweeenveertig.openstack.headers.Metadata;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public abstract class AbstractInformation {

    private Map<String, Metadata> metadataHeaders = new TreeMap<String, Metadata>();

    public void clear() {
        metadataHeaders.clear();
    }

    public void addMetadata(Metadata metadata) {
        metadataHeaders.put(metadata.getName(), metadata);
    }

    public String getMetadata(String name) {
        return this.metadataHeaders.get(name) != null ? this.metadataHeaders.get(name).getHeaderValue() : null;
    }

    public Collection<Metadata> getMetadata() {
        return this.metadataHeaders.values();
    }

    public void setMetadata(Map<String, Metadata> metadataHeaders) {
        this.metadataHeaders = metadataHeaders;
    }

}
