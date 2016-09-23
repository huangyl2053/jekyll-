/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.Models;

/**
 * 業務概念ServiceShuruiShikyuGendoGakuのHolderクラスです。
 *
 * @reamsid_L DBC-3440-010 lihang
 */
public class ServiceShuruiShikyuGendoGakuHolder implements Serializable {

    private static final long serialVersionUID = -3935825012351482058L;
    private final Models<ServiceShuruiShikyuGendoGakuIdentifier, ServiceShuruiShikyuGendoGaku> serviceGendoGakuList;

    /**
     * ServiceShuruiShikyuGendoGakuHolderのobj作成です。
     */
    public ServiceShuruiShikyuGendoGakuHolder() {
        this.serviceGendoGakuList = Models.create(new ArrayList<ServiceShuruiShikyuGendoGaku>());
    }

    /**
     * ServiceShuruiShikyuGendoGakuHolderのobj作成です。
     *
     * @param serviceGendoGakuList List<ServiceShuruiShikyuGendoGaku>
     */
    public ServiceShuruiShikyuGendoGakuHolder(List<ServiceShuruiShikyuGendoGaku> serviceGendoGakuList) {
        this.serviceGendoGakuList = Models.create(serviceGendoGakuList);
    }

    /**
     * ServiceShuruiShikyuGendoGakuHolderのobj作成です。
     *
     * @param serviceGendoGakuList List<ServiceShuruiShikyuGendoGaku>
     * Models<ServiceShuruiShikyuGendoGakuIdentifier,
     * ServiceShuruiShikyuGendoGaku>
     */
    public ServiceShuruiShikyuGendoGakuHolder(
            Models<ServiceShuruiShikyuGendoGakuIdentifier, ServiceShuruiShikyuGendoGaku> serviceGendoGakuList) {
        this.serviceGendoGakuList = serviceGendoGakuList;
    }

    /**
     * ServiceShuruiShikyuGendoGakuのlistを取得します。
     *
     * @return List<ServiceShuruiShikyuGendoGaku>
     */
    public List<ServiceShuruiShikyuGendoGaku> getServiceShuruiShikyuGendoGakuList() {
        return new ArrayList<>(serviceGendoGakuList.values());
    }

    /**
     * ServiceShuruiShikyuGendoGakuのlistを設定します。
     *
     * @param serviceShuruiShikyuGendoGaku ServiceShuruiShikyuGendoGaku
     */
    public void addServiceShuruiShikyuGendoGaku(ServiceShuruiShikyuGendoGaku serviceShuruiShikyuGendoGaku) {
        serviceGendoGakuList.add(serviceShuruiShikyuGendoGaku);
    }

    /**
     * ServiceShuruiShikyuGendoGakuを取得します。
     *
     * @param id ServiceShuruiShikyuGendoGakuIdentifier
     * @return ServiceShuruiShikyuGendoGaku
     */
    public ServiceShuruiShikyuGendoGaku getServiceShuruiShikyuGendoGaku(ServiceShuruiShikyuGendoGakuIdentifier id) {
        if (serviceGendoGakuList.contains(id)) {
            return serviceGendoGakuList.clone().get(id);
        }
        return null;
    }
}
