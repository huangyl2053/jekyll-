/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.dbc050021;

import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.FurikomiGyomunaiKubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc050021.FurikomimeisaiFurikomiDataMybatisParameter;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 振込明細・振込みデータ作成のProcessパラメータです。
 *
 * @reamsid_L DBC-4870-030 gongliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FurikomimeisaiFurikomiDataProcessParameter implements IBatchProcessParameter {

    private RString 支払方法;
    private RString 抽出対象;
    private FlexibleDate 対象作成年月日;
    private boolean 再処理フラグ;
    private FlexibleDate 開始年月日;
    private FlexibleDate 終了年月日;
    private FlexibleYearMonth 開始受取年月;
    private FlexibleYearMonth 終了受取年月;
    private RDate 振込指定年月日;
    private FurikomiGyomunaiKubun 振込業務内区分;
    private ShoriName 処理名;
    private IOutputOrder 出力順情報;
    private RString batchKunbun;
    private RString 処理区分;

    /**
     * コンストラクタ。
     *
     * @param 支払方法 RString
     * @param 抽出対象 RString
     * @param 対象作成年月日 FlexibleDate
     * @param 再処理フラグ boolean
     * @param 開始年月日 FlexibleDate
     * @param 終了年月日 FlexibleDate
     * @param 開始受取年月 FlexibleYearMonth
     * @param 終了受取年月 FlexibleYearMonth
     * @param 振込指定年月日 RDate
     * @param 処理区分 RString
     */
    public FurikomimeisaiFurikomiDataProcessParameter(RString 支払方法, RString 抽出対象, FlexibleDate 対象作成年月日,
            boolean 再処理フラグ, FlexibleDate 開始年月日, FlexibleDate 終了年月日, FlexibleYearMonth 開始受取年月,
            FlexibleYearMonth 終了受取年月, RDate 振込指定年月日, RString 処理区分) {
        this.支払方法 = 支払方法;
        this.抽出対象 = 抽出対象;
        this.対象作成年月日 = 対象作成年月日;
        this.再処理フラグ = 再処理フラグ;
        this.開始年月日 = 開始年月日;
        this.終了年月日 = 終了年月日;
        this.開始受取年月 = 開始受取年月;
        this.終了受取年月 = 終了受取年月;
        this.振込指定年月日 = 振込指定年月日;
        this.処理区分 = 処理区分;
    }

    /**
     * mybatisParameterを取得する。
     *
     * @return mybatisParameter FurikomimeisaiFurikomiDataMybatisParameter
     */
    public FurikomimeisaiFurikomiDataMybatisParameter toMybatisParameter() {
        return new FurikomimeisaiFurikomiDataMybatisParameter(
                支払方法, 抽出対象, 対象作成年月日, 再処理フラグ, 開始年月日, 終了年月日, 開始受取年月, 終了受取年月);
    }
}
