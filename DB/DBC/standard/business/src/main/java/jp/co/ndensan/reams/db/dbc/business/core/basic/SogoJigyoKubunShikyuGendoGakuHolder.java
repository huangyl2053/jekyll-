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
 *
 * 業務概念SogoJigyoKubunShikyuGendoGakuのHolderクラスです。
 *
 * @reamsid_L DBC-3363-010 xuxin
 */
public class SogoJigyoKubunShikyuGendoGakuHolder implements Serializable {

    private static final long serialVersionUID = -3935825012351482058L;
    private final Models<SogoJigyoKubunShikyuGendoGakuIdentifier, SogoJigyoKubunShikyuGendoGaku> sogoJigyoKubunList;

    /**
     * SogoJigyoKubunShikyuGendoGakuHolderのobj作成です。
     */
    public SogoJigyoKubunShikyuGendoGakuHolder() {
        this.sogoJigyoKubunList = Models.create(new ArrayList<SogoJigyoKubunShikyuGendoGaku>());
    }

    /**
     * SogoJigyoKubunShikyuGendoGakuHolderのobj作成です。
     *
     * @param sogoJigyoKubunList List<SogoJigyoKubunShikyuGendoGaku>
     */
    public SogoJigyoKubunShikyuGendoGakuHolder(List<SogoJigyoKubunShikyuGendoGaku> sogoJigyoKubunList) {
        this.sogoJigyoKubunList = Models.create(sogoJigyoKubunList);
    }

    /**
     * SogoJigyoKubunShikyuGendoGakuHolderのobj作成です。
     *
     * @param sogoJigyoKubunList Models<SogoJigyoKubunShikyuGendoGakuIdentifier, SogoJigyoKubunShikyuGendoGaku>
     */
    public SogoJigyoKubunShikyuGendoGakuHolder(Models<SogoJigyoKubunShikyuGendoGakuIdentifier, SogoJigyoKubunShikyuGendoGaku> sogoJigyoKubunList) {
        this.sogoJigyoKubunList = sogoJigyoKubunList;
    }

    /**
     * SogoJigyoKubunShikyuGendoGakuのlistを取得します。
     *
     * @return List<SogoJigyoKubunShikyuGendoGaku>
     */
    public List<SogoJigyoKubunShikyuGendoGaku> getSogoJigyoKubunShikyuGendoGakuList() {
        return new ArrayList<>(sogoJigyoKubunList.values());
    }

    /**
     * SogoJigyoKubunShikyuGendoGakuのlistを設定します。
     *
     * @param sogoJigyoKubunShikyuGendoGaku SogoJigyoKubunShikyuGendoGaku
     */
    public void addSogoJigyoKubunShikyuGendoGaku(SogoJigyoKubunShikyuGendoGaku sogoJigyoKubunShikyuGendoGaku) {
        sogoJigyoKubunList.add(sogoJigyoKubunShikyuGendoGaku);
    }

    /**
     * SogoJigyoKubunShikyuGendoGakuを取得します。
     *
     * @param id SogoJigyoKubunShikyuGendoGakuIdentifier
     * @return SogoJigyoKubunShikyuGendoGaku
     */
    public SogoJigyoKubunShikyuGendoGaku getSogoJigyoKubunShikyuGendoGaku(SogoJigyoKubunShikyuGendoGakuIdentifier id) {
        if (sogoJigyoKubunList.contains(id)) {
            return sogoJigyoKubunList.clone().get(id);
        }
        return null;
    }

}
