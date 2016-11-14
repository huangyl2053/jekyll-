/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.dbb211001;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBBBT82001_特徴送付情報作成の特徴依頼のデータ抽出のProcessParameterです。
 *
 * @reamsid_L DBB-1840-040 xuzhao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class InsTokuchoIraiTempProcessParameter implements IBatchProcessParameter {

    private RYear 賦課年度;

    /**
     * コンストラクタです。
     *
     * @param 賦課年度 RYear
     */
    public InsTokuchoIraiTempProcessParameter(RYear 賦課年度) {
        this.賦課年度 = 賦課年度;
    }
}
