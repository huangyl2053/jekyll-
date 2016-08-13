/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.NendoKirikae;

import jp.co.ndensan.reams.uz.uza.lang.RDate;
import lombok.Setter;

/**
 * 年度切替バッチのパラメッタ
 *
 * @reamsid_L DBB_9010_002 zhengshenlei
 */
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NendoKirikaeMybatisParameter {

    private final RDate choteiNendo;

    /**
     * コンストラクタ
     *
     * @param moveyear
     */
    public NendoKirikaeMybatisParameter(RDate choteiNendo) {
        this.choteiNendo = choteiNendo;
    }
}
