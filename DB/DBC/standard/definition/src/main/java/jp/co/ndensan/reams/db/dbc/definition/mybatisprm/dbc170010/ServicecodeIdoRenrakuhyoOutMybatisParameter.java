/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc170010;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;

/**
 * 総合事業分サービスコード異動連絡票作成のパラメータクラスです。
 *
 * @reamsid_L DBC-4740-030 zhaowei
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ServicecodeIdoRenrakuhyoOutMybatisParameter implements IMyBatisParameter {

    private final RYearMonth 処理年月;
    private final RString 再処理区分;
    private final RString 出力順;
    private final RString 出力対象区分;

    /**
     * コンストラクタです。
     *
     * @param 処理年月 RYearMonth
     * @param 再処理区分 RString
     * @param 出力順 RString
     * @param 出力対象区分 RString
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    public ServicecodeIdoRenrakuhyoOutMybatisParameter(
            RYearMonth 処理年月,
            RString 再処理区分,
            RString 出力順,
            RString 出力対象区分) {
        this.処理年月 = 処理年月;
        this.再処理区分 = 再処理区分;
        this.出力順 = 出力順;
        this.出力対象区分 = 出力対象区分;
    }
}
