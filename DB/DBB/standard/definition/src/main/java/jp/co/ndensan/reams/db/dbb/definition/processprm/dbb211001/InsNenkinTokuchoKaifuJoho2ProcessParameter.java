/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.dbb211001;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBBBT82001_特徴送付情報作成の（特徴異動情報）追加用データ作成のProcessParameterです。
 *
 * @reamsid_L DBB-1840-040 xuzhao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class InsNenkinTokuchoKaifuJoho2ProcessParameter implements IBatchProcessParameter {

    private boolean is処理対象月が4月_6月;
    private boolean 処理対象月が5月;
    private boolean 処理対象月が10月_12月_2月;

    /**
     * コンストラクタです。
     *
     * @param is処理対象月が4月_6月 boolean
     * @param 処理対象月が5月 boolean
     * @param 処理対象月が10月_12月_2月 boolean
     */
    public InsNenkinTokuchoKaifuJoho2ProcessParameter(boolean is処理対象月が4月_6月,
            boolean 処理対象月が5月, boolean 処理対象月が10月_12月_2月) {
        this.is処理対象月が4月_6月 = is処理対象月が4月_6月;
        this.処理対象月が5月 = 処理対象月が5月;
        this.処理対象月が10月_12月_2月 = 処理対象月が10月_12月_2月;
    }

}
