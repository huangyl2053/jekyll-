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
 * DBB-1840-040バッチ設計_DBBBT82001_特徴送付情報作成の（特徴追加依頼）追加用データ作成する用MybatisParameterクラスです。
 *
 * @reamsid_L DBB-1840-040 xuzhao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class SelectTokuchoTsuikaIraiTsuikaTempMyBatisParameter implements IMyBatisParameter {

    private final RYear 賦課年度;
    private final boolean is処理対象月が4月_6月;
    private final boolean is処理対象月が2月;

    /**
     * コンストラクタです。
     *
     * @param 賦課年度 RYear
     * @param is処理対象月が4月_6月 boolean
     * @param is処理対象月が2月 boolean
     */
    public SelectTokuchoTsuikaIraiTsuikaTempMyBatisParameter(RYear 賦課年度,
            boolean is処理対象月が4月_6月, boolean is処理対象月が2月) {
        this.賦課年度 = 賦課年度;
        this.is処理対象月が4月_6月 = is処理対象月が4月_6月;
        this.is処理対象月が2月 = is処理対象月が2月;
    }

}
