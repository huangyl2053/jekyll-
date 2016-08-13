/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.NendoKirikae;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.NendoKirikae.NendoKirikaeMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import lombok.Getter;
import lombok.Setter;

/**
 * 年度切替バッチのパラメッタ
 *
 * @reamsid_L DBB_9010_002 zhengshenlei
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NendoKirikaeProcessParameter implements IBatchProcessParameter {

    private RDate choteiNendo;

    /**
     * コンストラクタ
     *
     * @param choteiNendo
     */
    public NendoKirikaeProcessParameter(RDate choteiNendo) {
        this.choteiNendo = choteiNendo;
    }

    public NendoKirikaeMybatisParameter toNendoKirikaeMybatisParameter(RDate choteiNendo) {
        return new NendoKirikaeMybatisParameter(choteiNendo);
    }
}
