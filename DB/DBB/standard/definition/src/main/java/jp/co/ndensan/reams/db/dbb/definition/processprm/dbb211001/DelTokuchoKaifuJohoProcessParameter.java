/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.dbb211001;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchosoufujohosakuseibatch.DeleteTokuchoKaifuJohoMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBBBT82001_特徴送付情報作成の年金特徴回付情報の削除のProcessParameterです。
 *
 * @reamsid_L DBB-1840-040 chenxt
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DelTokuchoKaifuJohoProcessParameter implements IBatchProcessParameter {

    private RYear 賦課年度;
    private RString 処理対象月;

    /**
     * コンストラクタです。
     *
     * @param 賦課年度 RYear
     * @param 処理対象月 RString
     */
    public DelTokuchoKaifuJohoProcessParameter(RYear 賦課年度, RString 処理対象月) {
        this.賦課年度 = 賦課年度;
        this.処理対象月 = 処理対象月;
    }

    /**
     * DeleteTokuchoKaifuJohoMyBatisParameterを取得する。
     *
     * @return DeleteTokuchoKaifuJohoMyBatisParameter
     */
    public DeleteTokuchoKaifuJohoMyBatisParameter toDeleteTokuchoKaifuJohoMyBatisParameter() {
        return new DeleteTokuchoKaifuJohoMyBatisParameter(賦課年度, 処理対象月);
    }
}
