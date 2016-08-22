package io.dubbo.springboot.config;

import java.util.List;
import java.util.Map;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.ModuleConfig;
import com.alibaba.dubbo.config.MonitorConfig;
import com.alibaba.dubbo.config.RegistryConfig;

public class DubboConsumerConfig extends ConsumerConfig {

	private static final long serialVersionUID = -8031045735678301522L;

	@Override
	public void setTimeout(Integer timeout) {
		// TODO Auto-generated method stub
		super.setTimeout(timeout);
	}

	@Override
	public Boolean isDefault() {
		// TODO Auto-generated method stub
		return super.isDefault();
	}

	@Override
	public void setDefault(Boolean isDefault) {
		// TODO Auto-generated method stub
		super.setDefault(isDefault);
	}

	@Override
	public Boolean isCheck() {
		// TODO Auto-generated method stub
		return super.isCheck();
	}

	@Override
	public void setCheck(Boolean check) {
		// TODO Auto-generated method stub
		super.setCheck(check);
	}

	@Override
	public Boolean isInit() {
		// TODO Auto-generated method stub
		return super.isInit();
	}

	@Override
	public void setInit(Boolean init) {
		// TODO Auto-generated method stub
		super.setInit(init);
	}

	@Override
	public Boolean isGeneric() {
		// TODO Auto-generated method stub
		return super.isGeneric();
	}

	@Override
	public void setGeneric(Boolean generic) {
		// TODO Auto-generated method stub
		super.setGeneric(generic);
	}

	@Override
	public void setGeneric(String generic) {
		// TODO Auto-generated method stub
		super.setGeneric(generic);
	}

	@Override
	public String getGeneric() {
		// TODO Auto-generated method stub
		return super.getGeneric();
	}

	@Deprecated
	@Override
	public Boolean isInjvm() {
		// TODO Auto-generated method stub
		return super.isInjvm();
	}

	@Deprecated
	@Override
	public void setInjvm(Boolean injvm) {
		// TODO Auto-generated method stub
		super.setInjvm(injvm);
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
	public Boolean getLazy() {
		// TODO Auto-generated method stub
		return super.getLazy();
	}

	@Override
	public void setLazy(Boolean lazy) {
		// TODO Auto-generated method stub
		super.setLazy(lazy);
	}

	@Override
	public void setOnconnect(String onconnect) {
		// TODO Auto-generated method stub
		super.setOnconnect(onconnect);
	}

	@Override
	public void setOndisconnect(String ondisconnect) {
		// TODO Auto-generated method stub
		super.setOndisconnect(ondisconnect);
	}

	@Override
	public Boolean getStubevent() {
		// TODO Auto-generated method stub
		return super.getStubevent();
	}

	@Override
	public String getReconnect() {
		// TODO Auto-generated method stub
		return super.getReconnect();
	}

	@Override
	public void setReconnect(String reconnect) {
		// TODO Auto-generated method stub
		super.setReconnect(reconnect);
	}

	@Override
	public Boolean getSticky() {
		// TODO Auto-generated method stub
		return super.getSticky();
	}

	@Override
	public void setSticky(Boolean sticky) {
		// TODO Auto-generated method stub
		super.setSticky(sticky);
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
	public String getCluster() {
		// TODO Auto-generated method stub
		return super.getCluster();
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
	public Integer getConnections() {
		// TODO Auto-generated method stub
		return super.getConnections();
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
	public String getOndisconnect() {
		// TODO Auto-generated method stub
		return super.getOndisconnect();
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
	public void setRetries(Integer retries) {
		// TODO Auto-generated method stub
		super.setRetries(retries);
	}

	@Override
	public String getLoadbalance() {
		// TODO Auto-generated method stub
		return super.getLoadbalance();
	}

	@Override
	public void setLoadbalance(String loadbalance) {
		// TODO Auto-generated method stub
		super.setLoadbalance(loadbalance);
	}

	@Override
	public Boolean isAsync() {
		// TODO Auto-generated method stub
		return super.isAsync();
	}

	@Override
	public void setAsync(Boolean async) {
		// TODO Auto-generated method stub
		super.setAsync(async);
	}

	@Override
	public Integer getActives() {
		// TODO Auto-generated method stub
		return super.getActives();
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
