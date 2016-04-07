/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridButtonState;

/**
 *
 * @author N2810 久保 里史
 */
public class KokuhorenJohoTorikomi {

    private static final RString 再処理 = new RString("再処理");

    /**
     * 処理状態を返します。
     *
     * @param 処理状態区分 処理状態区分
     * @return 処理状態
     */
    public RString get処理状態(RString 処理状態区分) {

        if (処理状態区分.isEmpty()) {
            return new RString("-");
        }

        switch (処理状態区分.toString()) {
            case "1":
                return new RString("×");
            case "3":
                return new RString("○");
            case "9":
                return new RString("-");
            default:
                return new RString("-");

        }
    }

    /**
     * 再処理可否区分を返します。
     *
     * @param 再処理可否 再処理可否
     * @return 再処理可否区分
     */
    public RString get再処理可否区分(boolean 再処理可否) {
        if (再処理可否) {
            return get再処理フラグコード(再処理);
        } else {
            return new RString("0");
        }
    }

    /**
     * 再処理フラグ名称を返します。
     *
     * @param 再処理フラグコード 再処理フラグコード
     * @return 再処理フラグ名称
     */
    public RString get再処理フラグ名称(RString 再処理フラグコード) {
        if (再処理フラグコード.compareTo("1") == 0) {
            return 再処理;
        } else {
            return RString.EMPTY;
        }
    }

    /**
     * 再処理フラグコードを返します。
     *
     * @param 再処理フラグ名称 再処理フラグ名称
     * @return 再処理フラグコード
     */
    public RString get再処理フラグコード(RString 再処理フラグ名称) {
        if (再処理フラグ名称 == null
                || 再処理フラグ名称.isEmpty()) {
            return new RString("0");
        }
        if (再処理フラグ名称.compareTo(再処理.toString()) == 0) {
            return new RString("1");
        } else {
            return new RString("0");
        }
    }

    /**
     * 取込フラグを返します。
     *
     * @param 取込ファイル名 取込ファイル名
     * @return 取込フラグ
     */
    public RString get取込フラグ(RString 取込ファイル名) {
        if (SharedFile.searchSharedFile(取込ファイル名).isEmpty()) {
            return new RString("*");
        } else {
            return new RString(" ");
        }

    }

    /**
     * 選択ボタン状態を返します。
     *
     * @param 取込フラグ 取込フラグ
     * @param 今月処理状態 今月処理状態
     * @return 選択ボタン状態
     */
    public DataGridButtonState get選択ボタン状態(RString 取込フラグ, RString 今月処理状態) {
        if (取込フラグ.compareTo(" ") == 0 && (今月処理状態.compareTo("未処理") == 0 || 今月処理状態.compareTo(再処理.toString()) == 0 || 今月処理状態.compareTo("処理前") == 0)) {
            return DataGridButtonState.Enabled;
        } else {
            return DataGridButtonState.Disabled;
        }
    }

    /**
     * 帳票IDを返します。
     *
     * @param 交換識別番号 交換識別番号
     * @return 帳票ID
     */
    public ReportId get帳票ID(RString 交換識別番号) {
        switch (交換識別番号.toString()) {
            case "121":
                return new ReportId("DBC100011_ShikakuShogohyo");
            case "122":
                return new ReportId("DBC100012_SogojigyoShikakuShogohyo");
            case "151":
                return new ReportId("DBC100013_SeikyugakuTsuchishoHokenshabun");
            case "152":
                return new ReportId("DBC100014_SogojigyoSeikyugakuTsuchisho");
            case "631":
                return new ReportId("DBC100015_SeikyugakuTsuchishoKohifutanshabun");
            case "161":
                return new ReportId("DBC100016_ShinsaKetteiSeikyumeisaihyo");
            case "162":
                return new ReportId("DBC100017_SogojigyoShinsaKetteiSeikyumeisaihyo");
            case "741":
                return new ReportId("DBC100052_SeikyumeisaiKyufukanrihyoHenreiHoryuIchiran");
            case "534":
                return new ReportId("DBC100067_KokuhorenJukyushaDaichoIchiran");
            case "641":
                return new ReportId("DBC100069_KohijukyushaBetsuIchiran");
            case "112":
                return new ReportId("DBC900001_KyufukanrihyoTorikomiKekkaIchiran");
            case "331":
                return new ReportId("DBC900007_KogakuKyufuTaishoshaIchiran");
            case "111":
                return new ReportId("DBC900008_KyufujissekiTorikomiIchiran");
            case "351":
                return new ReportId("DBC900009_KogakuShikyuFushikyuKetteishaIchiran");
            case "221":
                return new ReportId("DBC900015_ShokanbaraiShikyuKetteishaIchiran");
            case "222":
                return new ReportId("DBC900016_ShokanbaraiFushikyuKetteishaIchiran");
            case "37J":
                return new ReportId("DBC900022_GassanJikofutangakuKakuninTorikomiIchiran");
            default:
                return get帳票Id(交換識別番号);
        }
    }

    private ReportId get帳票Id(RString 交換識別番号) {
        switch (交換識別番号.toString()) {
            case "37H":
                return new ReportId("DBC900028_GassanJikofutangakuShomeishoTorikomiIchiran");
            case "386":
                return new ReportId("DBC900031_GassanShikyugakuKeisankekkaTorikomiIchiran");
            case "38B":
                return new ReportId("DBC900033_GassanShikyuFushikyuKetteiTsuchishoTorikomiIchiran");
            case "38P":
                return new ReportId("DBC900035_GassanKyufujissekiTorikomiIchiran");
            case "172":
                return new ReportId("DBC900042_SaishinsaKetteitsuchishoTorikomiIchiranHokensha");
            case "652":
                return new ReportId("DBC900043_SaishinsaKetteitsuchishoTorikomiIchiranKohifutansha");
            case "171":
                return new ReportId("DBC900044_KagoKetteitsuchishoTorikomiIchiranHokensha");
            case "651":
                return new ReportId("DBC900045_KagoKetteitsuchishoTorikomiIchiranKohifutansha");
            case "175":
                return new ReportId("DBC900046_SogojigyoKagoKetteitsuchishoTorikomiIchiran");
            case "114":
                return new ReportId("DBC900049_KyufujissekiKoshinkekkaIchiran");
            case "533":
                return new ReportId("DBC900050_JukyushaKoshinkekkaIchiran");
            case "5C3":
                return new ReportId("DBC900051_KyodoJukyushaKoshinkekkaIchiran");
            case "5C4":
                return new ReportId("DBC900052_KyodoJukyushaIchiran");
            case "537":
                return new ReportId("DBC900053_JukyushaTotsugokekkaIchiran");
            default:
                return null;
        }
    }
}
