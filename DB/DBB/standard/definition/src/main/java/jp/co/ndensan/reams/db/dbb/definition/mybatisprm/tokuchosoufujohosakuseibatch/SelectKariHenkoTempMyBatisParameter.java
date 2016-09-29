/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchosoufujohosakuseibatch;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import lombok.Getter;
import lombok.Setter;

/**
 * DBB-1840-040バッチ設計_DBBBT82001_特徴送付情報作成の仮徴収額変更の賦課情報の取得する用MybatisParameterクラスです。
 *
 * @reamsid_L DBB-1840-040 xuzhao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class SelectKariHenkoTempMyBatisParameter implements IMyBatisParameter {

    private final boolean is処理対象月が5月_6月;

    /**
     * コンストラクタです。
     *
     * @param is処理対象月が5月_6月 boolean
     */
    public SelectKariHenkoTempMyBatisParameter(boolean is処理対象月が5月_6月) {
        this.is処理対象月が5月_6月 = is処理対象月が5月_6月;
    }

}
