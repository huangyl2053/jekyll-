/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki2711;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 介護事業状況報告年報（様式2-7）のパラメータクラスです。
 *
 * @reamsid_L DBU-5600-280 guoqilin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyohokokuCompYoshiki2711 {

    private RString 年報月報区分;
    private RDateTime 処理日時;
    private RString 保険者番号;
    private RString 保険者名;
    private FlexibleYear 集計年度;
    private FlexibleYearMonth 集計期間FROM;
    private FlexibleYearMonth 集計期間TO;
    private RString 様式;

    private RString 件数_世帯合算_1;
    private RString 件数_世帯合算_2;
    private RString 件数_世帯合算_3;
    private RString 件数_世帯合算_4;
    private RString 件数_世帯合算_5;
    private RString 件数_世帯合算_6;
    private RString 件数_世帯合算_7;
    private RString 件数_世帯合算_8;

    private RString 件数_その他_1;
    private RString 件数_その他_2;
    private RString 件数_その他_3;
    private RString 件数_その他_4;
    private RString 件数_その他_5;
    private RString 件数_その他_6;
    private RString 件数_その他_7;
    private RString 件数_その他_8;

    private RString 件数_計_1;
    private RString 件数_計_2;
    private RString 件数_計_3;
    private RString 件数_計_4;
    private RString 件数_計_5;
    private RString 件数_計_6;
    private RString 件数_計_7;
    private RString 件数_計_8;

    private RString 給付額_世帯合算_1;
    private RString 給付額_世帯合算_2;
    private RString 給付額_世帯合算_3;
    private RString 給付額_世帯合算_4;
    private RString 給付額_世帯合算_5;
    private RString 給付額_世帯合算_6;
    private RString 給付額_世帯合算_7;
    private RString 給付額_世帯合算_8;

    private RString 給付額_その他_1;
    private RString 給付額_その他_2;
    private RString 給付額_その他_3;
    private RString 給付額_その他_4;
    private RString 給付額_その他_5;
    private RString 給付額_その他_6;
    private RString 給付額_その他_7;
    private RString 給付額_その他_8;

    private RString 給付額_計_1;
    private RString 給付額_計_2;
    private RString 給付額_計_3;
    private RString 給付額_計_4;
    private RString 給付額_計_5;
    private RString 給付額_計_6;
    private RString 給付額_計_7;
    private RString 給付額_計_8;

}
