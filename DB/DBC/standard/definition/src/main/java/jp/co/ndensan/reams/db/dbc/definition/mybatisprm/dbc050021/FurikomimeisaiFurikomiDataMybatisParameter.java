/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc050021;

import jp.co.ndensan.reams.db.dbc.definition.core.kogakukaigoservice.ShikyuKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shiharaihoho.ShiharaiHohoKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyufushikyukubun.ShikyuFushikyuKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shinsahoho.ShinsaHohoKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.YukoMukoKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 振込明細・振込みデータ作成のMybatisパラメータです。
 *
 * @reamsid_L DBC-4870-030 gongliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FurikomimeisaiFurikomiDataMybatisParameter implements IMyBatisParameter {

    private RString 支給不支給区分_1;
    private RString 支払方法;
    private RString 支払方法区分_2;
    private RString 支払方法区分_1;
    private RString 抽出対象;
    private FlexibleDate 対象作成年月日;
    private boolean 再処理フラグ;
    private FlexibleDate 開始年月日;
    private FlexibleDate 終了年月日;
    private RString 審査方法区分_1;
    private RString 審査方法区分_2;
    private RString 高額介護サービス費支給区分_1;
    private RString 有効無効区分_1;
    private RString 有効無効区分_2;
    private RString 要介護状態区分コード_01;
    private FlexibleYearMonth 開始受取年月;
    private FlexibleYearMonth 終了受取年月;
    private RString 出力順;
    private RString 処理名;

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
     * @param 処理名 RString
     */
    public FurikomimeisaiFurikomiDataMybatisParameter(RString 支払方法, RString 抽出対象, FlexibleDate 対象作成年月日,
            boolean 再処理フラグ, FlexibleDate 開始年月日, FlexibleDate 終了年月日,
            FlexibleYearMonth 開始受取年月, FlexibleYearMonth 終了受取年月, RString 処理名) {
        this.支払方法 = 支払方法;
        this.抽出対象 = 抽出対象;
        this.対象作成年月日 = 対象作成年月日;
        this.再処理フラグ = 再処理フラグ;
        this.開始年月日 = 開始年月日;
        this.終了年月日 = 終了年月日;
        this.開始受取年月 = 開始受取年月;
        this.終了受取年月 = 終了受取年月;
        this.処理名 = 処理名;
        this.支給不支給区分_1 = ShikyuFushikyuKubun.支給.getコード();
        this.支払方法区分_2 = ShiharaiHohoKubun.口座払.getコード();
        this.支払方法区分_1 = ShiharaiHohoKubun.窓口払.getコード();
        this.審査方法区分_1 = ShinsaHohoKubun.審査依頼.getコード();
        this.審査方法区分_2 = ShinsaHohoKubun.審査済み.getコード();
        this.高額介護サービス費支給区分_1 = ShikyuKubun.支給.getコード();
        this.有効無効区分_1 = YukoMukoKubun.有効.getコード();
        this.有効無効区分_2 = YukoMukoKubun.無効.getコード();
        this.要介護状態区分コード_01 = YokaigoJotaiKubun.非該当.getコード();
    }
}
