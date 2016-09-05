/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.dbc110070;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc110070.KogakugassanKeisankekkaRenrakuhyoOutMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
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
public class KogakugassanKeisankekkaRenrakuhyoOutProcessParameter implements IBatchProcessParameter {

    private RYearMonth 処理年月;
    private RString 再処理区分;
    private RString 出力順ID;
    private RString 出力順;

    /**
     * コンストラクタ
     *
     * @param 処理年月 RYearMonth
     * @param 再処理区分 RString
     * @param 出力順ID RString
     */
    public KogakugassanKeisankekkaRenrakuhyoOutProcessParameter(
            RYearMonth 処理年月,
            RString 再処理区分,
            RString 出力順ID) {
        this.処理年月 = 処理年月;
        this.再処理区分 = 再処理区分;
        this.出力順ID = 出力順ID;
    }

    /**
     * 高額合算計算結果連絡票情報作成のMybaticParameter作成する。
     *
     * @return {@link KogakugassanKeisankekkaRenrakuhyoOutMybatisParameter}
     */
    public KogakugassanKeisankekkaRenrakuhyoOutMybatisParameter toMybatisParameter() {
        return new KogakugassanKeisankekkaRenrakuhyoOutMybatisParameter(処理年月, 再処理区分, 出力順);
    }
}
