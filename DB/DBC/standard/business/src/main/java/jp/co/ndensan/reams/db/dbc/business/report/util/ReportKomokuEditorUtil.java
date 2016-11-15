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
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
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

    private static final RString 年度 = new RString("年度");

    private ReportKomokuEditorUtil() {
    }

    /**
     * 氏名カナの変換のメソッドです。
     *
     * @param 氏名 氏名
     * @return 氏名
     */
    public static RString get氏名カナ(AtenaKanaMeisho 氏名) {
        return 氏名 == null ? RString.EMPTY : 氏名.getColumnValue();
    }

    /**
     * 氏名の変換のメソッドです。
     *
     * @param 氏名 氏名
     * @return 氏名
     */
    public static RString get氏名(AtenaMeisho 氏名) {
        return 氏名 == null ? RString.EMPTY : 氏名.getColumnValue();
    }

    /**
     * 日付の変換のメソッドです。
     *
     * @param ymd 日付
     * @return 日付
     */
    public static RString パターン12(FlexibleDate ymd) {
        return ymd == null ? RString.EMPTY : ymd.wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

    /**
     * 証記載保険者番号の変換のメソッドです。
     *
     * @param hokenshaNo 証記載保険者番号
     * @return 証記載保険者番号
     */
    public static RString get証記載保険者番号(HokenshaNo hokenshaNo) {
        return hokenshaNo == null ? RString.EMPTY : hokenshaNo.getColumnValue();
    }

    /**
     * 被保険者番号の変換のメソッドです。
     *
     * @param hokenshaNo 被保険者番号
     * @return 被保険者番号
     */
    public static RString get被保険者番号(HihokenshaNo hokenshaNo) {
        return hokenshaNo == null ? RString.EMPTY : hokenshaNo.getColumnValue();
    }

    /**
     * 日付の変換のメソッドです。
     *
     * @param ym 日付
     * @return 日付
     */
    public static RString パターン62(FlexibleYearMonth ym) {
        return ym == null ? RString.EMPTY : ym.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

    /**
     * 金額の変換のメソッドです。
     *
     * @param decimal 金額
     * @return 金額
     */
    public static RString 金額1(Decimal decimal) {
        return decimal == null ? RString.EMPTY : DecimalFormatter.toコンマ区切りRString(decimal, 0);
    }

    /**
     * 日付の変換のメソッドです。
     *
     * @param year 年度
     * @return 年度
     */
    public static RString パターン107(FlexibleYear year) {
        return year == null ? RString.EMPTY : year.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                fillType(FillType.BLANK).toDateString().concat(年度);
    }

    /**
     * 金融機関コードを取得します。
     *
     * @param code 金融機関コード
     * @return 金融機関コード
     */
    public static RString get金融機関コード(KinyuKikanCode code) {
        return code == null ? RString.EMPTY : code.getColumnValue();
    }

    /**
     * 金融機関支店コードを取得します。
     *
     * @param code 金融機関支店コード
     * @return 金融機関支店コード
     */
    public static RString get金融機関支店コード(KinyuKikanShitenCode code) {
        return code == null ? RString.EMPTY : code.getColumnValue();
    }

    /**
     * 非空文字列を取得します。
     *
     * @param 文字列 RString
     * @return 非空文字列
     */
    public static RString get非空文字列(RString 文字列) {
        if (RString.isNullOrEmpty(文字列)) {
            return RString.EMPTY;
        }
        return 文字列;
    }

}
