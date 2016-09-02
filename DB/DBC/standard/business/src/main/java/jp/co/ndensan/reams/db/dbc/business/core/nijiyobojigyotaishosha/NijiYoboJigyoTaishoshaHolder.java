/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.nijiyobojigyotaishosha;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.NijiYoboJigyoTaishosha;
import jp.co.ndensan.reams.db.dbc.business.core.basic.NijiYoboJigyoTaishoshaIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.Models;

/**
 * 業務概念NijiYoboJigyoTaishoshaのHolderクラスです。
 *
 * @reamsid_L DBC-2400-010 yuqingzhang
 */
public class NijiYoboJigyoTaishoshaHolder implements Serializable {

    private static final long serialVersionUID = -3935825012351482058L;
    private final Models<NijiYoboJigyoTaishoshaIdentifier, NijiYoboJigyoTaishosha> careManegerList;

    /**
     * NijiYoboJigyoTaishoshaHolderのobj作成です。
     */
    public NijiYoboJigyoTaishoshaHolder() {
        this.careManegerList = Models.create(new ArrayList<NijiYoboJigyoTaishosha>());
    }

    /**
     * NijiYoboJigyoTaishoshaHolderのobj作成です。
     *
     * @param careManegerList List<NijiYoboJigyoTaishosha>
     */
    public NijiYoboJigyoTaishoshaHolder(List<NijiYoboJigyoTaishosha> careManegerList) {
        this.careManegerList = Models.create(careManegerList);
    }

    /**
     * NijiYoboJigyoTaishoshaHolderのobj作成です。
     *
     * @param careManegerList Models<NijiYoboJigyoTaishoshaIdentifier, NijiYoboJigyoTaishosha>
     */
    public NijiYoboJigyoTaishoshaHolder(Models<NijiYoboJigyoTaishoshaIdentifier, NijiYoboJigyoTaishosha> careManegerList) {
        this.careManegerList = careManegerList;
    }

    /**
     * SogoJigyoKubunShikyuGendoGakuのlistを取得します。
     *
     * @return List<NijiYoboJigyoTaishosha>
     */
    public List<NijiYoboJigyoTaishosha> getNijiYoboJigyoTaishoshaList() {
        return new ArrayList<>(careManegerList.values());
    }

    /**
     * SogoJigyoKubunShikyuGendoGakuのlistを設定します。
     *
     * @param kogakugassanjikofutangaku NijiYoboJigyoTaishosha
     */
    public void addNijiYoboJigyoTaishosha(NijiYoboJigyoTaishosha kogakugassanjikofutangaku) {
        careManegerList.add(kogakugassanjikofutangaku);
    }

    /**
     * NijiYoboJigyoTaishoshaを取得します。
     *
     * @param id NijiYoboJigyoTaishoshaIdentifier
     * @return NijiYoboJigyoTaishosha
     */
    public NijiYoboJigyoTaishosha getNijiYoboJigyoTaishosha(NijiYoboJigyoTaishoshaIdentifier id) {
        if (careManegerList.contains(id)) {
            return careManegerList.clone().get(id);
        }
        return null;
    }
}
