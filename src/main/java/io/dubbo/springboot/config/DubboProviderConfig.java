package io.dubbo.springboot.config;

import java.util.List;
import java.util.Map;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ModuleConfig;
import com.alibaba.dubbo.config.MonitorConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ProviderConfig;
import com.alibaba.dubbo.config.RegistryConfig;

public class DubboProviderConfig extends ProviderConfig {

	private static final long serialVersionUID = -6321707693900535511L;

	@Deprecated
	@Override
	public void setProtocol(String protocol) {
		// TODO Auto-generated method stub
		super.setProtocol(protocol);
	}

	@Override
	public Boolean isDefault() {
		// TODO Auto-generated method stub
		return super.isDefault();
	}

	@Deprecated
	@Override
	public void setDefault(Boolean isDefault) {
		// TODO Auto-generated method stub
		super.setDefault(isDefault);
	}

	@Override
	public String getHost() {
		// TODO Auto-generated method stub
		return super.getHost();
	}

	@Override
	public void setHost(String host) {
		// TODO Auto-generated method stub
		super.setHost(host);
	}

	@Override
	public Integer getPort() {
		// TODO Auto-generated method stub
		return super.getPort();
	}

	@Deprecated
	@Override
	public void setPort(Integer port) {
		// TODO Auto-generated method stub
		super.setPort(port);
	}

	@Deprecated
	@Override
	public String getPath() {
		// TODO Auto-generated method stub
		return super.getPath();
	}

	@Deprecated
	@Override
	public void setPath(String path) {
		// TODO Auto-generated method stub
		super.setPath(path);
	}

	@Override
	public String getContextpath() {
		// TODO Auto-generated method stub
		return super.getContextpath();
	}

	@Override
	public void setContextpath(String contextpath) {
		// TODO Auto-generated method stub
		super.setContextpath(contextpath);
	}

	@Override
	public String getThreadpool() {
		// TODO Auto-generated method stub
		return super.getThreadpool();
	}

	@Override
	public void setThreadpool(String threadpool) {
		// TODO Auto-generated method stub
		super.setThreadpool(threadpool);
	}

	@Override
	public Integer getThreads() {
		// TODO Auto-generated method stub
		return super.getThreads();
	}

	@Override
	public void setThreads(Integer threads) {
		// TODO Auto-generated method stub
		super.setThreads(threads);
	}

	@Override
	public Integer getIothreads() {
		// TODO Auto-generated method stub
		return super.getIothreads();
	}

	@Override
	public void setIothreads(Integer iothreads) {
		// TODO Auto-generated method stub
		super.setIothreads(iothreads);
	}

	@Override
	public Integer getQueues() {
		// TODO Auto-generated method stub
		return super.getQueues();
	}

	@Override
	public void setQueues(Integer queues) {
		// TODO Auto-generated method stub
		super.setQueues(queues);
	}

	@Override
	public Integer getAccepts() {
		// TODO Auto-generated method stub
		return super.getAccepts();
	}

	@Override
	public void setAccepts(Integer accepts) {
		// TODO Auto-generated method stub
		super.setAccepts(accepts);
	}

	@Override
	public String getCodec() {
		// TODO Auto-generated method stub
		return super.getCodec();
	}

	@Override
	public void setCodec(String codec) {
		// TODO Auto-generated method stub
		super.setCodec(codec);
	}

	@Override
	public String getSerialization() {
		// TODO Auto-generated method stub
		return super.getSerialization();
	}

	@Override
	public void setSerialization(String serialization) {
		// TODO Auto-generated method stub
		super.setSerialization(serialization);
	}

	@Override
	public String getCharset() {
		// TODO Auto-generated method stub
		return super.getCharset();
	}

	@Override
	public void setCharset(String charset) {
		// TODO Auto-generated method stub
		super.setCharset(charset);
	}

	@Override
	public Integer getPayload() {
		// TODO Auto-generated method stub
		return super.getPayload();
	}

	@Override
	public void setPayload(Integer payload) {
		// TODO Auto-generated method stub
		super.setPayload(payload);
	}

	@Override
	public Integer getBuffer() {
		// TODO Auto-generated method stub
		return super.getBuffer();
	}

	@Override
	public void setBuffer(Integer buffer) {
		// TODO Auto-generated method stub
		super.setBuffer(buffer);
	}

	@Override
	public String getServer() {
		// TODO Auto-generated method stub
		return super.getServer();
	}

	@Override
	public void setServer(String server) {
		// TODO Auto-generated method stub
		super.setServer(server);
	}

	@Override
	public String getClient() {
		// TODO Auto-generated method stub
		return super.getClient();
	}

	@Override
	public void setClient(String client) {
		// TODO Auto-generated method stub
		super.setClient(client);
	}

	@Override
	public String getTelnet() {
		// TODO Auto-generated method stub
		return super.getTelnet();
	}

	@Override
	public void setTelnet(String telnet) {
		// TODO Auto-generated method stub
		super.setTelnet(telnet);
	}

	@Override
	public String getPrompt() {
		// TODO Auto-generated method stub
		return super.getPrompt();
	}

	@Override
	public void setPrompt(String prompt) {
		// TODO Auto-generated method stub
		super.setPrompt(prompt);
	}

	@Override
	public String getStatus() {
		// TODO Auto-generated method stub
		return super.getStatus();
	}

	@Override
	public void setStatus(String status) {
		// TODO Auto-generated method stub
		super.setStatus(status);
	}

	@Override
	public String getCluster() {
		// TODO Auto-generated method stub
		return super.getCluster();
	}

	@Override
	public Integer getConnections() {
		// TODO Auto-generated method stub
		return super.getConnections();
	}

	@Override
	public Integer getTimeout() {
		// TODO Auto-generated method stub
		return super.getTimeout();
	}

	@Override
	public Integer getRetries() {
		// TODO Auto-generated method stub
		return super.getRetries();
	}

	@Override
	public String getLoadbalance() {
		// TODO Auto-generated method stub
		return super.getLoadbalance();
	}

	@Override
	public Boolean isAsync() {
		// TODO Auto-generated method stub
		return super.isAsync();
	}

	@Override
	public Integer getActives() {
		// TODO Auto-generated method stub
		return super.getActives();
	}

	@Override
	public String getTransporter() {
		// TODO Auto-generated method stub
		return super.getTransporter();
	}

	@Override
	public void setTransporter(String transporter) {
		// TODO Auto-generated method stub
		super.setTransporter(transporter);
	}

	@Override
	public String getExchanger() {
		// TODO Auto-generated method stub
		return super.getExchanger();
	}

	@Override
	public void setExchanger(String exchanger) {
		// TODO Auto-generated method stub
		super.setExchanger(exchanger);
	}

	@Deprecated
	@Override
	public String getDispather() {
		// TODO Auto-generated method stub
		return super.getDispather();
	}

	@Deprecated
	@Override
	public void setDispather(String dispather) {
		// TODO Auto-generated method stub
		super.setDispather(dispather);
	}

	@Override
	public String getDispatcher() {
		// TODO Auto-generated method stub
		return super.getDispatcher();
	}

	@Override
	public void setDispatcher(String dispatcher) {
		// TODO Auto-generated method stub
		super.setDispatcher(dispatcher);
	}

	@Override
	public String getNetworker() {
		// TODO Auto-generated method stub
		return super.getNetworker();
	}

	@Override
	public void setNetworker(String networker) {
		// TODO Auto-generated method stub
		super.setNetworker(networker);
	}

	@Override
	public Integer getWait() {
		// TODO Auto-generated method stub
		return super.getWait();
	}

	@Override
	public void setWait(Integer wait) {
		// TODO Auto-generated method stub
		super.setWait(wait);
	}

	@Override
	public String getVersion() {
		// TODO Auto-generated method stub
		return super.getVersion();
	}

	@Override
	public void setVersion(String version) {
		// TODO Auto-generated method stub
		super.setVersion(version);
	}

	@Override
	public String getGroup() {
		// TODO Auto-generated method stub
		return super.getGroup();
	}

	@Override
	public void setGroup(String group) {
		// TODO Auto-generated method stub
		super.setGroup(group);
	}

	@Override
	public Integer getDelay() {
		// TODO Auto-generated method stub
		return super.getDelay();
	}

	@Override
	public void setDelay(Integer delay) {
		// TODO Auto-generated method stub
		super.setDelay(delay);
	}

	@Override
	public Boolean getExport() {
		// TODO Auto-generated method stub
		return super.getExport();
	}

	@Override
	public void setExport(Boolean export) {
		// TODO Auto-generated method stub
		super.setExport(export);
	}

	@Override
	public Integer getWeight() {
		// TODO Auto-generated method stub
		return super.getWeight();
	}

	@Override
	public void setWeight(Integer weight) {
		// TODO Auto-generated method stub
		super.setWeight(weight);
	}

	@Override
	public String getDocument() {
		// TODO Auto-generated method stub
		return super.getDocument();
	}

	@Override
	public void setDocument(String document) {
		// TODO Auto-generated method stub
		super.setDocument(document);
	}

	@Override
	public String getToken() {
		// TODO Auto-generated method stub
		return super.getToken();
	}

	@Override
	public void setToken(String token) {
		// TODO Auto-generated method stub
		super.setToken(token);
	}

	@Override
	public void setToken(Boolean token) {
		// TODO Auto-generated method stub
		super.setToken(token);
	}

	@Override
	public Boolean isDeprecated() {
		// TODO Auto-generated method stub
		return super.isDeprecated();
	}

	@Override
	public void setDeprecated(Boolean deprecated) {
		// TODO Auto-generated method stub
		super.setDeprecated(deprecated);
	}

	@Override
	public Boolean isDynamic() {
		// TODO Auto-generated method stub
		return super.isDynamic();
	}

	@Override
	public void setDynamic(Boolean dynamic) {
		// TODO Auto-generated method stub
		super.setDynamic(dynamic);
	}

	@Override
	public List<ProtocolConfig> getProtocols() {
		// TODO Auto-generated method stub
		return super.getProtocols();
	}

	@Override
	public void setProtocols(List<? extends ProtocolConfig> protocols) {
		// TODO Auto-generated method stub
		super.setProtocols(protocols);
	}

	@Override
	public ProtocolConfig getProtocol() {
		// TODO Auto-generated method stub
		return super.getProtocol();
	}

	@Override
	public void setProtocol(ProtocolConfig protocol) {
		// TODO Auto-generated method stub
		super.setProtocol(protocol);
	}

	@Override
	public String getAccesslog() {
		// TODO Auto-generated method stub
		return super.getAccesslog();
	}

	@Override
	public void setAccesslog(String accesslog) {
		// TODO Auto-generated method stub
		super.setAccesslog(accesslog);
	}

	@Override
	public void setAccesslog(Boolean accesslog) {
		// TODO Auto-generated method stub
		super.setAccesslog(accesslog);
	}

	@Override
	public Integer getExecutes() {
		// TODO Auto-generated method stub
		return super.getExecutes();
	}

	@Override
	public void setExecutes(Integer executes) {
		// TODO Auto-generated method stub
		super.setExecutes(executes);
	}

	@Override
	public String getFilter() {
		// TODO Auto-generated method stub
		return super.getFilter();
	}

	@Override
	public String getListener() {
		// TODO Auto-generated method stub
		return super.getListener();
	}

	@Override
	public void setListener(String listener) {
		// TODO Auto-generated method stub
		super.setListener(listener);
	}

	@Override
	public Boolean isRegister() {
		// TODO Auto-generated method stub
		return super.isRegister();
	}

	@Override
	public void setRegister(Boolean register) {
		// TODO Auto-generated method stub
		super.setRegister(register);
	}

	@Deprecated
	@Override
	public String getLocal() {
		// TODO Auto-generated method stub
		return super.getLocal();
	}

	@Deprecated
	@Override
	public void setLocal(String local) {
		// TODO Auto-generated method stub
		super.setLocal(local);
	}

	@Deprecated
	@Override
	public void setLocal(Boolean local) {
		// TODO Auto-generated method stub
		super.setLocal(local);
	}

	@Override
	public String getStub() {
		// TODO Auto-generated method stub
		return super.getStub();
	}

	@Override
	public void setStub(String stub) {
		// TODO Auto-generated method stub
		super.setStub(stub);
	}

	@Override
	public void setStub(Boolean stub) {
		// TODO Auto-generated method stub
		super.setStub(stub);
	}

	@Override
	public void setCluster(String cluster) {
		// TODO Auto-generated method stub
		super.setCluster(cluster);
	}

	@Override
	public String getProxy() {
		// TODO Auto-generated method stub
		return super.getProxy();
	}

	@Override
	public void setProxy(String proxy) {
		// TODO Auto-generated method stub
		super.setProxy(proxy);
	}

	@Override
	public void setConnections(Integer connections) {
		// TODO Auto-generated method stub
		super.setConnections(connections);
	}

	@Override
	public void setFilter(String filter) {
		// TODO Auto-generated method stub
		super.setFilter(filter);
	}

	@Override
	public String getLayer() {
		// TODO Auto-generated method stub
		return super.getLayer();
	}

	@Override
	public void setLayer(String layer) {
		// TODO Auto-generated method stub
		super.setLayer(layer);
	}

	@Override
	public ApplicationConfig getApplication() {
		// TODO Auto-generated method stub
		return super.getApplication();
	}

	@Override
	public void setApplication(ApplicationConfig application) {
		// TODO Auto-generated method stub
		super.setApplication(application);
	}

	@Override
	public ModuleConfig getModule() {
		// TODO Auto-generated method stub
		return super.getModule();
	}

	@Override
	public void setModule(ModuleConfig module) {
		// TODO Auto-generated method stub
		super.setModule(module);
	}

	@Override
	public RegistryConfig getRegistry() {
		// TODO Auto-generated method stub
		return super.getRegistry();
	}

	@Override
	public void setRegistry(RegistryConfig registry) {
		// TODO Auto-generated method stub
		super.setRegistry(registry);
	}

	@Override
	public List<RegistryConfig> getRegistries() {
		// TODO Auto-generated method stub
		return super.getRegistries();
	}

	@Override
	public void setRegistries(List<? extends RegistryConfig> registries) {
		// TODO Auto-generated method stub
		super.setRegistries(registries);
	}

	@Override
	public MonitorConfig getMonitor() {
		// TODO Auto-generated method stub
		return super.getMonitor();
	}

	@Override
	public void setMonitor(MonitorConfig monitor) {
		// TODO Auto-generated method stub
		super.setMonitor(monitor);
	}

	@Override
	public void setMonitor(String monitor) {
		// TODO Auto-generated method stub
		super.setMonitor(monitor);
	}

	@Override
	public String getOwner() {
		// TODO Auto-generated method stub
		return super.getOwner();
	}

	@Override
	public void setOwner(String owner) {
		// TODO Auto-generated method stub
		super.setOwner(owner);
	}

	@Override
	public void setCallbacks(Integer callbacks) {
		// TODO Auto-generated method stub
		super.setCallbacks(callbacks);
	}

	@Override
	public Integer getCallbacks() {
		// TODO Auto-generated method stub
		return super.getCallbacks();
	}

	@Override
	public String getOnconnect() {
		// TODO Auto-generated method stub
		return super.getOnconnect();
	}

	@Override
	public void setOnconnect(String onconnect) {
		// TODO Auto-generated method stub
		super.setOnconnect(onconnect);
	}

	@Override
	public String getOndisconnect() {
		// TODO Auto-generated method stub
		return super.getOndisconnect();
	}

	@Override
	public void setOndisconnect(String ondisconnect) {
		// TODO Auto-generated method stub
		super.setOndisconnect(ondisconnect);
	}

	@Override
	public String getScope() {
		// TODO Auto-generated method stub
		return super.getScope();
	}

	@Override
	public void setScope(String scope) {
		// TODO Auto-generated method stub
		super.setScope(scope);
	}

	@Override
	public void setTimeout(Integer timeout) {
		// TODO Auto-generated method stub
		super.setTimeout(timeout);
	}

	@Override
	public void setRetries(Integer retries) {
		// TODO Auto-generated method stub
		super.setRetries(retries);
	}

	@Override
	public void setLoadbalance(String loadbalance) {
		// TODO Auto-generated method stub
		super.setLoadbalance(loadbalance);
	}

	@Override
	public void setAsync(Boolean async) {
		// TODO Auto-generated method stub
		super.setAsync(async);
	}

	@Override
	public void setActives(Integer actives) {
		// TODO Auto-generated method stub
		super.setActives(actives);
	}

	@Override
	public Boolean getSent() {
		// TODO Auto-generated method stub
		return super.getSent();
	}

	@Override
	public void setSent(Boolean sent) {
		// TODO Auto-generated method stub
		super.setSent(sent);
	}

	@Override
	public String getMock() {
		// TODO Auto-generated method stub
		return super.getMock();
	}

	@Override
	public void setMock(String mock) {
		// TODO Auto-generated method stub
		super.setMock(mock);
	}

	@Override
	public void setMock(Boolean mock) {
		// TODO Auto-generated method stub
		super.setMock(mock);
	}

	@Override
	public String getMerger() {
		// TODO Auto-generated method stub
		return super.getMerger();
	}

	@Override
	public void setMerger(String merger) {
		// TODO Auto-generated method stub
		super.setMerger(merger);
	}

	@Override
	public String getCache() {
		// TODO Auto-generated method stub
		return super.getCache();
	}

	@Override
	public void setCache(String cache) {
		// TODO Auto-generated method stub
		super.setCache(cache);
	}

	@Override
	public String getValidation() {
		// TODO Auto-generated method stub
		return super.getValidation();
	}

	@Override
	public void setValidation(String validation) {
		// TODO Auto-generated method stub
		super.setValidation(validation);
	}

	@Override
	public Map<String, String> getParameters() {
		// TODO Auto-generated method stub
		return super.getParameters();
	}

	@Override
	public void setParameters(Map<String, String> parameters) {
		// TODO Auto-generated method stub
		super.setParameters(parameters);
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		super.setId(id);
	}

}
