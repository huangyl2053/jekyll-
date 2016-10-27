/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchosoufujohosakuseibatch;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * DBB-1840-040バッチ設計_DBBBT82001_特徴送付情報作成の（仮徴収額変更）追加用データ作成する用MybatisParameterクラスです。
 *
 * @reamsid_L DBB-1840-040 xuzhao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class SelectTsuikaDataMyBatisParameter implements IMyBatisParameter {

    private final boolean is処理対象月が4月;
    private final boolean is年金特徴回付情報が取得できない;
    private final List<RString> 通知内容コードList;

    /**
     * コンストラクタです。
     *
     * @param is処理対象月が4月 boolean
     * @param is年金特徴回付情報が取得できない boolean
     * @param 通知内容コードList List<RString>
     */
    public SelectTsuikaDataMyBatisParameter(boolean is処理対象月が4月,
            boolean is年金特徴回付情報が取得できない, List<RString> 通知内容コードList) {
        this.is処理対象月が4月 = is処理対象月が4月;
        this.is年金特徴回付情報が取得できない = is年金特徴回付情報が取得できない;
        this.通知内容コードList = 通知内容コードList;
    }

}
