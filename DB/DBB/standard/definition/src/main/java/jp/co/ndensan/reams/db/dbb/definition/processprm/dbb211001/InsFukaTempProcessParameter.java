/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.dbb211001;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchosoufujohosakuseibatch.SelectFukaTempJouhouMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBBBT82001_特徴送付情報作成の最新の賦課の情報を取得のProcessParameterです。
 *
 * @reamsid_L DBB-1840-040 xuzhao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class InsFukaTempProcessParameter implements IBatchProcessParameter {

    private final RYear 賦課年度;

    /**
     * コンストラクタです。
     *
     * @param 賦課年度 RYear
     */
    public InsFukaTempProcessParameter(RYear 賦課年度) {
        this.賦課年度 = 賦課年度;
    }

    /**
     * SelectFukaTempJouhouMyBatisParameterを取得する。
     *
     * @return SelectFukaTempJouhouMyBatisParameter
     */
    public SelectFukaTempJouhouMyBatisParameter toSelectFukaTempJouhouMyBatisParameter() {
        return new SelectFukaTempJouhouMyBatisParameter(賦課年度);
    }
}
