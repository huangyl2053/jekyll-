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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * データ取得MybatisParameterクラスです。
 *
 * @reamsid_L DBC-2180-030 x_miaocl
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShoukanFurikomiMybatisParameter implements IMyBatisParameter {

    private Furikomi_ShihraiHohoShitei 支払方法;
    private Furikomi_MeisaiIchiranChushutsuTaisho 抽出対象;
    private boolean 再処理フラグ;
    private FlexibleDate 開始年月日;
    private FlexibleDate 終了年月日;
    private FlexibleDate 対象作成年月日;
    private boolean 口座の場合;
    private boolean 窓口の場合;
    private boolean 振込データ作成済を除く;
    private boolean 振込データ作成済のみ;
    private boolean 再処理フラグT;
    private boolean 開始年月日T;
    private boolean 終了年月日T;
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
     */
    public ShoukanFurikomiMybatisParameter(Furikomi_ShihraiHohoShitei 支払方法, Furikomi_MeisaiIchiranChushutsuTaisho 抽出対象,
            boolean 再処理フラグ, FlexibleDate 開始年月日, FlexibleDate 終了年月日, FlexibleDate 対象作成年月日) {
        zijie(支払方法);
        cohucuh(抽出対象, 対象作成年月日);
        ziaculi(再処理フラグ);
        dentifiers(開始年月日);
        zonlianyr(終了年月日);
        this.終了年月日 = 終了年月日;
        this.開始年月日 = 開始年月日;
        this.対象作成年月日 = 対象作成年月日;

    }

    private void zijie(Furikomi_ShihraiHohoShitei 支払方法) {
        if (ONE.equals(支払方法.getコード())) {
            口座の場合 = true;
        } else if (TWO.equals(支払方法.getコード())) {
            窓口の場合 = true;
        }
    }

    private void cohucuh(Furikomi_MeisaiIchiranChushutsuTaisho 抽出対象, FlexibleDate 対象作成年月日) {
        if (抽出対象 != null && ONE.equals(抽出対象.getコード())) {
            振込データ作成済を除く = true;
        } else if (抽出対象 != null && 対象作成年月日 == null && TWO.equals(抽出対象.getコード())) {
            振込データ作成済のみ = true;
        } else if (抽出対象 != null && 対象作成年月日 != null && TWO.equals(抽出対象.getコード())) {
            全て = true;
        } else {
            振込データ作成済を除く = false;
            振込データ作成済のみ = false;
            全て = false;
        }
    }

    private void ziaculi(boolean 再処理フラグ) {
        if (再処理フラグ) {
            再処理フラグT = true;
        } else {
            再処理フラグT = false;
        }
    }

    private void dentifiers(FlexibleDate 開始年月日) {
        開始年月日T = 開始年月日 != null && !開始年月日.isEmpty();
    }

    private void zonlianyr(FlexibleDate 終了年月日) {
        終了年月日T = 終了年月日 != null && !終了年月日.isEmpty();
    }
}
