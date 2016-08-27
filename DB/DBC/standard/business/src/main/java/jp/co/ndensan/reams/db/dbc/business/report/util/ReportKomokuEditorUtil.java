/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.util;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 帳票用項目の編集クラスです。
 *
 * @reamsid_L DBC-4770-040 zhujun
 */
public final class ReportKomokuEditorUtil {

    private ReportKomokuEditorUtil() {
    }

    /**
     * 氏名カナの変換のメソッドです。
     *
     * @param 氏名 氏名
     * @return 氏名
     */
    public static RString get氏名カナ(AtenaKanaMeisho 氏名) {
        if (氏名 == null) {
            return RString.EMPTY;
        }
        return 氏名.getColumnValue();
    }

    /**
     * 氏名の変換のメソッドです。
     *
     * @param 氏名 氏名
     * @return 氏名
     */
    public static RString get氏名(AtenaMeisho 氏名) {
        if (氏名 == null) {
            return RString.EMPTY;
        }
        return 氏名.getColumnValue();
    }

    /**
     * 日付の変換のメソッドです。
     *
     * @param ymd 日付
     * @return 日付
     */
    public static RString パターン12(FlexibleDate ymd) {
        if (ymd == null) {
            return RString.EMPTY;
        }
        return ymd.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

    /**
     * 証記載保険者番号の変換のメソッドです。
     *
     * @param hokenshaNo 証記載保険者番号
     * @return 証記載保険者番号
     */
    public static RString get証記載保険者番号(HokenshaNo hokenshaNo) {
        if (hokenshaNo == null) {
            return RString.EMPTY;
        }
        return hokenshaNo.getColumnValue();
    }

    /**
     * 被保険者番号の変換のメソッドです。
     *
     * @param hokenshaNo 被保険者番号
     * @return 被保険者番号
     */
    public static RString get被保険者番号(HihokenshaNo hokenshaNo) {
        if (hokenshaNo == null) {
            return RString.EMPTY;
        }
        return hokenshaNo.getColumnValue();
    }

    /**
     * 日付の変換のメソッドです。
     *
     * @param ym 日付
     * @return 日付
     */
    public static RString パターン62(FlexibleYearMonth ym) {
        if (ym == null) {
            return RString.EMPTY;
        }
        return ym.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

    /**
     * 金額の変換のメソッドです。
     *
     * @param decimal 金額
     * @return 金額
     */
    public static RString 金額1(Decimal decimal) {
        if (decimal == null) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(decimal, 0);
    }
}
