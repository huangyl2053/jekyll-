/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.dbb211001;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchosoufujohosakuseibatch.SelectKariHenkoTempMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBBBT82001_特徴送付情報作成の仮徴収額変更の賦課情報の取得のProcessParameterです。
 *
 * @reamsid_L DBB-1840-040 xuzhao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class InsKariHenkoTempProcessParameter implements IBatchProcessParameter {

    private static final RString 処理対象月_05月 = new RString("05");
    private static final RString 処理対象月_06月 = new RString("06");
    private static final RString ZERO = new RString("0");
    private final RString 処理対象月;

    /**
     * コンストラクタです。
     *
     * @param 処理対象月 RString
     */
    public InsKariHenkoTempProcessParameter(RString 処理対象月) {
        if (処理対象月.length() == 1) {
            this.処理対象月 = ZERO.concat(処理対象月);
        } else {
            this.処理対象月 = 処理対象月;
        }
    }

    /**
     * SelectKariHenkoTempMyBatisParameterの取得です。
     *
     * @return SelectKariHenkoTempMyBatisParameter
     */
    public SelectKariHenkoTempMyBatisParameter toSelectKariHenkoTempMyBatisParameter() {
        return new SelectKariHenkoTempMyBatisParameter(is処理対象月が5月_6月());
    }

    private boolean is処理対象月が5月_6月() {
        return 処理対象月_05月.equals(this.処理対象月)
                || 処理対象月_06月.equals(this.処理対象月);
    }
}
