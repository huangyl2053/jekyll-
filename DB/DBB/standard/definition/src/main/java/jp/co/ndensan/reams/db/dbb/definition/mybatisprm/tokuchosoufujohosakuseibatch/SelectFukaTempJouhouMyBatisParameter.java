/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchosoufujohosakuseibatch;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import lombok.Getter;
import lombok.Setter;

/**
 * DBB-1840-040バッチ設計_DBBBT82001_特徴送付情報作成の最新の賦課の情報を取得する用MybatisParameterクラスです。
 *
 * @reamsid_L DBB-1840-040 xuzhao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class SelectFukaTempJouhouMyBatisParameter implements IMyBatisParameter {

    private RYear 賦課年度;

    /**
     * コンストラクタです。
     *
     * @param 賦課年度 RYear
     */
    public SelectFukaTempJouhouMyBatisParameter(RYear 賦課年度) {
        this.賦課年度 = 賦課年度;
    }

}
