/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka;

import jp.co.ndensan.reams.ur.urz.business.lib.lang.IKingakuFormatter;
import jp.co.ndensan.reams.ur.urz.business.lib.lang.KingakuFormatter;
import jp.co.ndensan.reams.ur.urz.definition.lib.lang.enumeratedtype.KingakuUnit;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 賦課照会で使用するマッパークラスです。
 *
 * @author N3317 塚田 萌
 */
public final class FukaMapper {

    /**
     * プライベートコンストラクタです。
     */
    private FukaMapper() {

    }

    /**
     * 数値にコンマを付けて文字列形式で返します。
     *
     * @param target 数値
     * @return コンマ付与文字列
     */
    public static RString addComma(Decimal target) {
        IKingakuFormatter formatter = KingakuFormatter.create(target);

        return new RString(formatter.format(KingakuUnit.円).setCommaSeparated().toString());
    }

    /**
     * FlexibleYear型をRYear型にして返します。
     *
     * @param target FlexibleYear型の年
     * @return RYear型の年
     */
    public static RYear toRYear(FlexibleYear target) {
        if (!target.isValid()) {
            return null;
        }
        return new RYear(target.toString());
    }

    /**
     * 文字列をRYearMonth型にして返します。
     *
     * @param target 対象文字列
     * @return RYearMonth型の年月
     */
    public static RYearMonth toRYearMonth(RString target) {
        if (target.isEmpty()) {
            return null;
        }
        return new RYearMonth(target.toString());
    }

    /**
     * FlexibleDate型をRDate型にして返します。
     *
     * @param target FlexibleDate型の年月日
     * @return RDate型の年月日
     */
    public static RDate toRDate(FlexibleDate target) {
        if (!target.isValid()) {
            return null;
        }
        return new RDate(target.toString());
    }

    /**
     * int型を文字列にして返します。
     *
     * @param target int型の値
     * @return 文字列の値
     */
    public static RString toRString(int target) {
        return new RString(String.valueOf(target));
    }

    /**
     * Decimal型を文字列にして返します。
     *
     * @param target Decimal型の値
     * @return 文字列の値
     */
    public static RString toRString(Decimal target) {
        return new RString(String.valueOf(target));
    }

    /**
     * RDateTime型を画面表示形式にして返します。
     *
     * @param target RDateTime型の値
     * @return 画面表示形式の文字列
     */
    public static RString toDisplayForm(RDateTime target) {

        RStringBuilder source = new RStringBuilder();
        source.append(target.getDate().wareki().toDateString())
                .append(" ")
                .append(target.getTime().getHour())
                .append(":")
                .append(target.getTime().getMinute());

        return source.toRString();
    }
}
