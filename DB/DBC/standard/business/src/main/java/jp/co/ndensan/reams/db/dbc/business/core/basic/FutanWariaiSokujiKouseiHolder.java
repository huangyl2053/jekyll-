/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.futanwariai.RiyoshaFutanWariaiMeisai;
import jp.co.ndensan.reams.db.dbd.business.core.futanwariai.RiyoshaFutanWariaiMeisaiIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.Models;

/**
 * 業務概念RiyoshaFutanWariaiMeisaiのHolderクラスです。
 *
 * @reamsid_L DBC-5010-011 zhaowei
 */
public class FutanWariaiSokujiKouseiHolder implements Serializable {

    private static final long serialVersionUID = -3935825012351482058L;
    private final Models<RiyoshaFutanWariaiMeisaiIdentifier, RiyoshaFutanWariaiMeisai> 利用者負担割合明細;

    /**
     * FutanWariaiSokujiKouseiHolderのobj作成です。
     */
    public FutanWariaiSokujiKouseiHolder() {
        this.利用者負担割合明細 = Models.create(new ArrayList<RiyoshaFutanWariaiMeisai>());
    }

    /**
     * FutanWariaiSokujiKouseiHolderのobj作成です。
     *
     * @param 利用者負担割合明細 List<RiyoshaFutanWariaiMeisai>
     */
    public FutanWariaiSokujiKouseiHolder(List<RiyoshaFutanWariaiMeisai> 利用者負担割合明細) {
        this.利用者負担割合明細 = Models.create(利用者負担割合明細);
    }

    /**
     * FutanWariaiSokujiKouseiHolderのobj作成です。
     *
     * @param 利用者負担割合明細 Models<RiyoshaFutanWariaiMeisaiIdentifier, RiyoshaFutanWariaiMeisai>
     */
    public FutanWariaiSokujiKouseiHolder(Models<RiyoshaFutanWariaiMeisaiIdentifier, RiyoshaFutanWariaiMeisai> 利用者負担割合明細) {
        this.利用者負担割合明細 = 利用者負担割合明細;
    }

    /**
     * SogoJigyoKubunShikyuGendoGakuのlistを取得します。
     *
     * @return List<RiyoshaFutanWariaiMeisai>
     */
    public List<RiyoshaFutanWariaiMeisai> get利用者負担割合明細() {
        return new ArrayList<>(利用者負担割合明細.values());
    }

    /**
     * SogoJigyoKubunShikyuGendoGakuのlistを設定します。
     *
     * @param RiyoshaFutanWariaiMeisai RiyoshaFutanWariaiMeisai
     */
    public void addRiyoshaFutanWariaiMeisai(RiyoshaFutanWariaiMeisai RiyoshaFutanWariaiMeisai) {
        利用者負担割合明細.add(RiyoshaFutanWariaiMeisai);
    }

    /**
     * RiyoshaFutanWariaiMeisaiを取得します。
     *
     * @param id RiyoshaFutanWariaiMeisaiIdentifier
     * @return RiyoshaFutanWariaiMeisai
     */
    public RiyoshaFutanWariaiMeisai getRiyoshaFutanWariaiMeisai(RiyoshaFutanWariaiMeisaiIdentifier id) {
        if (利用者負担割合明細.contains(id)) {
            return 利用者負担割合明細.clone().get(id);
        }
        return null;
    }

}
