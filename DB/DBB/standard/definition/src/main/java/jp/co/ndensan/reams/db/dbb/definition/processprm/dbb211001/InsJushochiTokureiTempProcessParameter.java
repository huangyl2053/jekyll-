/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.dbb211001;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchosoufujohosakuseibatch.SelectJushochiTempDataMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBBBT82001_特徴送付情報作成の資格喪失等のデータ抽出のProcessParameterです。
 *
 * @reamsid_L DBB-1840-040 xuzhao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class InsJushochiTokureiTempProcessParameter implements IBatchProcessParameter {

    private final RYear 賦課年度;
    private final YMDHMS 処理日時;
    private final RString 処理対象月;

    /**
     * コンストラクタです。
     *
     * @param 賦課年度 RYear
     * @param 処理日時 YMDHMS
     * @param 処理対象月 RString
     */
    public InsJushochiTokureiTempProcessParameter(RYear 賦課年度,
            YMDHMS 処理日時, RString 処理対象月) {
        this.賦課年度 = 賦課年度;
        this.処理日時 = 処理日時;
        this.処理対象月 = 処理対象月;
    }

    /**
     * SelectJushochiTempDataMyBatisParameterの取得です。
     *
     * @return SelectJushochiTempDataMyBatisParameter
     */
    public SelectJushochiTempDataMyBatisParameter toSelectJushochiTempDataMyBatisParameter() {
        return new SelectJushochiTempDataMyBatisParameter(賦課年度, 処理日時.getRDateTime(),
                Integer.parseInt(処理対象月.toString()));
    }
}
