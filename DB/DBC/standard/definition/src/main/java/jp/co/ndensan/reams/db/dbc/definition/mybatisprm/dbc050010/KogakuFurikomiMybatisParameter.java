/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc050010;

import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.Furikomi_MeisaiIchiranChushutsuTaisho;
import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.Furikomi_ShihraiHohoShitei;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 高額データ取得MybatisParameterクラスです。
 *
 * @reamsid_L DBC-2180-030 x_miaocl
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuFurikomiMybatisParameter implements IMyBatisParameter {

    private Furikomi_MeisaiIchiranChushutsuTaisho 抽出対象;
    private boolean 再処理フラグ;
    private FlexibleDate 開始年月日;
    private FlexibleDate 終了年月日;
    private FlexibleDate 対象作成年月日;
    private FlexibleYearMonth 開始受取年月;
    private FlexibleYearMonth 終了受取年月;
    private boolean 口座の場合;
    private boolean 窓口の場合;
    private boolean 振込データ作成済を除く;
    private boolean 振込データ作成済のみ;
    private boolean 再処理フラグT;
    private boolean 開始年月日T;
    private boolean 終了年月日T;
    private boolean 開始受取年月T;
    private boolean 終了受取年月T;
    private boolean 全て = false;
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");

    /**
     * コンストラクタです
     *
     * @param 支払方法 支払方法
     * @param 抽出対象 抽出対象
     * @param 再処理フラグ 再処理フラグ
     * @param 開始年月日 開始年月日
     * @param 終了年月日 終了年月日
     * @param 対象作成年月日 対象作成年月日
     * @param 開始受取年月 開始受取年月
     * @param 終了受取年月 終了受取年月
     */
    public KogakuFurikomiMybatisParameter(Furikomi_ShihraiHohoShitei 支払方法, Furikomi_MeisaiIchiranChushutsuTaisho 抽出対象,
            boolean 再処理フラグ, FlexibleDate 開始年月日, FlexibleDate 終了年月日, FlexibleDate 対象作成年月日,
            FlexibleYearMonth 開始受取年月, FlexibleYearMonth 終了受取年月) {
        set支払方法(支払方法);
        set抽出対象(抽出対象, 対象作成年月日);
        set再処理フラグ(再処理フラグ);
        set開始年月日(開始年月日);
        set終了年月日(終了年月日);
        set開始受取年月(開始受取年月);
        set終了受取年月(終了受取年月);
        this.終了年月日 = 終了年月日;
        this.開始年月日 = 開始年月日;
        this.対象作成年月日 = 対象作成年月日;
        this.開始受取年月 = 開始受取年月;
        this.終了受取年月 = 終了受取年月;

    }

    private void set支払方法(Furikomi_ShihraiHohoShitei 支払方法) {
        if (ONE.equals(支払方法.getコード())) {
            口座の場合 = true;
        } else if (TWO.equals(支払方法.getコード())) {
            窓口の場合 = true;
        }
    }

    private void set抽出対象(Furikomi_MeisaiIchiranChushutsuTaisho 抽出対象, FlexibleDate 対象作成年月日) {
        if (抽出対象 != null && ONE.equals(抽出対象.getコード())) {
            振込データ作成済を除く = true;
        } else if (抽出対象 != null && 対象作成年月日 != null && TWO.equals(抽出対象.getコード())) {
            振込データ作成済のみ = true;
        } else if (抽出対象 != null && 対象作成年月日 == null && TWO.equals(抽出対象.getコード())) {
            全て = true;
        } else {
            振込データ作成済を除く = false;
            振込データ作成済のみ = false;
            全て = false;
        }
    }

    private void set再処理フラグ(boolean 再処理フラグ) {
        再処理フラグT = 再処理フラグ;
    }

    private void set開始年月日(FlexibleDate 開始年月日) {
        開始年月日T = 開始年月日 != null && !開始年月日.isEmpty();
    }

    private void set終了年月日(FlexibleDate 終了年月日) {
        終了年月日T = 終了年月日 != null && !終了年月日.isEmpty();
    }

    private void set開始受取年月(FlexibleYearMonth 開始受取年月) {
        開始受取年月T = 開始受取年月 != null && !開始受取年月.isEmpty();
    }

    private void set終了受取年月(FlexibleYearMonth 終了受取年月) {
        終了受取年月T = 終了受取年月 != null && !終了受取年月.isEmpty();
    }
}
