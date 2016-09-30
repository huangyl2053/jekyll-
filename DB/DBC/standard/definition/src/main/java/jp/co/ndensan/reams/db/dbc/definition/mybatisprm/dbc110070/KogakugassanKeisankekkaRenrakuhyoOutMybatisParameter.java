/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc110070;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;

/**
 * 高額合算計算結果連絡票情報作成のパラメータクラスです。
 *
 * @reamsid_L DBC-2670-030 zhaowei
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakugassanKeisankekkaRenrakuhyoOutMybatisParameter implements IMyBatisParameter {

    private final RYearMonth 処理年月;
    private final RString 再処理区分;
    private final RString 出力順;

    /**
     * コンストラクタです。
     *
     * @param 処理年月 RYearMonth
     * @param 再処理区分 RString
     * @param 出力順 RString
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    public KogakugassanKeisankekkaRenrakuhyoOutMybatisParameter(
            RYearMonth 処理年月,
            RString 再処理区分,
            RString 出力順) {
        this.処理年月 = 処理年月;
        this.再処理区分 = 再処理区分;
        this.出力順 = 出力順;
    }
}
