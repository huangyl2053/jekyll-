/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.dbc170010;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc170010.ServicecodeIdoRenrakuhyoOutMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
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
public class ServicecodeIdoRenrakuhyoOutProcessParameter implements IBatchProcessParameter {

    private RYearMonth 処理年月;
    private RString 再処理区分;
    private RString 出力順ID;
    private RString 出力順;
    private RString 出力対象区分;
    private RString 処理選択区分;

    /**
     * コンストラクタ
     *
     * @param 処理年月 RYearMonth
     * @param 再処理区分 RString
     * @param 出力順ID RString
     * @param 出力対象区分 RString
     * @param 処理選択区分 RString
     */
    public ServicecodeIdoRenrakuhyoOutProcessParameter(
            RYearMonth 処理年月,
            RString 再処理区分,
            RString 出力順ID,
            RString 出力対象区分,
            RString 処理選択区分) {
        this.処理年月 = 処理年月;
        this.再処理区分 = 再処理区分;
        this.出力順ID = 出力順ID;
        this.出力対象区分 = 出力対象区分;
        this.処理選択区分 = 処理選択区分;
    }

    /**
     * 総合事業分サービスコード異動連絡票作成のMybaticParameter作成する。
     *
     * @return {@link ServicecodeIdoRenrakuhyoOutMybatisParameter}
     */
    public ServicecodeIdoRenrakuhyoOutMybatisParameter toMybatisParameter() {
        return new ServicecodeIdoRenrakuhyoOutMybatisParameter(処理年月, 再処理区分, 出力順, 出力対象区分);
    }
}
