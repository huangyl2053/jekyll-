/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchosoufujohosakuseibatch;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import lombok.Getter;
import lombok.Setter;

/**
 * DBB-1840-040バッチ設計_DBBBT82001_特徴送付情報作成の年金特徴回付情報の削除する用MybatisParameterクラスです。
 *
 * @reamsid_L DBB-1840-040 chenxt
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class DeleteTokuchoKaifuJohoMyBatisParameter {

    private final FlexibleYearMonth 処理対象年月;

    /**
     * コンストラクタです。
     *
     * @param 賦課年度 RYear
     * @param 処理対象月 RString
     */
    public DeleteTokuchoKaifuJohoMyBatisParameter(RYear 賦課年度, RString 処理対象月) {
        this.処理対象年月 = new FlexibleYearMonth(賦課年度.toDateString().concat(処理対象月));
    }
}
