/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.shotokudankaibetsushunoritsuichiran;

import jp.co.ndensan.reams.db.dbb.entity.db.relate.dankaibetsushunoritsu.DankaibetsuShunoritsuIchiran;
import jp.co.ndensan.reams.db.dbb.entity.report.dankaibetsushunoritsu.ShotokuDankaiBetsuShunoritsuIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.lang.Width;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 帳票Editorクラスです。
 *
 * @reamsid_L DBB-1630-040 tianshuai
 */
public class ShotokuDankaiBetsuShunoritsuIchiranEditor implements IShotokuDankaiBetsuShunoritsuIchiranEditor {

    private final DankaibetsuShunoritsuIchiran パラメータ;
    private static final RString 時 = new RString("時");
    private static final RString 分 = new RString("分");
    private static final RString 秒 = new RString("秒");
    private static final RString FULLMONTH = new RString("00");
    private static final RString 作成 = new RString("作成");
    private static final RString ONE = new RString("0");
    private static final int INT_0 = 0;
    private static final RString 記号 = new RString("*");
    private static final RString TEXT_過年度 = new RString("*過年度*");
    private static final RString TEXT_総過年度 = new RString("*総過年度*");
    private static final RString 記号_TWO = new RString("**");

    /**
     * コンストラクタです
     *
     * @param パラメータ ShotokuDankaiBetsuShunoritsuIchiranEditor
     */
    protected ShotokuDankaiBetsuShunoritsuIchiranEditor(
            DankaibetsuShunoritsuIchiran パラメータ) {
        this.パラメータ = パラメータ;
    }

    @Override
    public ShotokuDankaiBetsuShunoritsuIchiranSource edit(ShotokuDankaiBetsuShunoritsuIchiranSource source) {
        source.choshu = パラメータ.get帳票タイトル();
        source.printTimeStamp = getSakuseiYmdhm().concat(RString.HALF_SPACE).concat(作成);
        source.hokenshaNo = パラメータ.get被保険者番号();
        source.hokenshaName = パラメータ.get被保険者名();
        if (パラメータ.get市町村コード() != null) {
            source.shichosonCode = パラメータ.get市町村コード().value();
        }
        source.shichosonName = パラメータ.get市町村名();
        source.list_1 = パラメータ.get年度();
        source.hdn_list_1 = パラメータ.getHdn年度();
        if (RString.isNullOrEmpty(パラメータ.get年度())
                || パラメータ.get年度().startsWith(記号)) {
            source.list_2 = RString.EMPTY;
        } else if (記号_TWO.equals(パラメータ.get保険料段階())) {
            source.list_2 = 記号_TWO;
        } else {
            source.list_2 = new RString(パラメータ.get期());
        }
        if (パラメータ.get年度().startsWith(記号)) {
            source.list_3 = RString.EMPTY;
        } else {
            source.list_3 = パラメータ.get保険料段階();
        }
        source.list_4 = new RString(パラメータ.get調定額_件数());
        source.list_5 = get金額Formatter(パラメータ.get調定額());
        source.list_6 = new RString(パラメータ.get収入額_件数());
        source.list_7 = get金額Formatter(パラメータ.get収入額());
        source.list_8 = get金額Formatter(パラメータ.get未納額());
        source.list_9 = new RString(パラメータ.get還付額_件数());
        source.list_10 = get金額Formatter(パラメータ.get還付額());
        source.list_11 = new RString(パラメータ.get充当額負_件数());
        source.list_12 = get金額Formatter(パラメータ.get充当額負());
        source.list_13 = new RString(パラメータ.get充当額_件数());
        source.list_14 = get金額Formatter(パラメータ.get充当額());
        source.list_15 = new RString(パラメータ.get不納欠損額_件数());
        source.list_16 = get金額Formatter(パラメータ.get不納欠損額());
        source.list_17 = パラメータ.get収納率();
        source.kamokuCode = パラメータ.get科目コード() == null ? RString.EMPTY
                : パラメータ.get科目コード().getColumnValue();
        source.isPageBreaker = getIsPageBreaker(パラメータ);
        setPageBreakEmpty(source);
        return source;
    }

    private void setPageBreakEmpty(ShotokuDankaiBetsuShunoritsuIchiranSource source) {
        if (source.list_1 == null) {
            source.list_1 = RString.EMPTY;
        }
        if (source.hdn_list_1 == null) {
            source.hdn_list_1 = RString.EMPTY;
        }
        if (source.kamokuCode == null) {
            source.kamokuCode = RString.EMPTY;
        }
        if (source.shichosonCode == null) {
            source.shichosonCode = RString.EMPTY;
        }
        if (source.choshu == null) {
            source.choshu = RString.EMPTY;
        }
    }

    private static RString getIsPageBreaker(DankaibetsuShunoritsuIchiran data) {
        if (RString.isNullOrEmpty(data.get年度())) {
            return RString.HALF_SPACE;
        }
        if (data.get年度().startsWith(記号)
                && !TEXT_過年度.equals(data.get年度())
                && !TEXT_総過年度.equals(data.get年度())) {
            return RString.HALF_SPACE;
        }
        return RString.EMPTY;
    }

    private static RString getSakuseiYmdhm() {
        RStringBuilder sakuseiYMD = new RStringBuilder();
        RDateTime datetime = RDate.getNowDateTime();
        sakuseiYMD.append(datetime.getDate().wareki().
                eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.ZERO).
                width(Width.HALF).toDateString());
        sakuseiYMD.append(RString.HALF_SPACE);
        sakuseiYMD.append(new RString(new Decimal(datetime.getHour()).toString(FULLMONTH.toString())));
        sakuseiYMD.append(時);
        sakuseiYMD.append(new RString(new Decimal(datetime.getMinute()).toString(FULLMONTH.toString())));
        sakuseiYMD.append(分);
        sakuseiYMD.append(new RString(new Decimal(datetime.getSecond()).toString(FULLMONTH.toString())));
        sakuseiYMD.append(秒);
        return sakuseiYMD.toRString();
    }

    private RString get金額Formatter(Decimal 金額) {
        if (金額 == null) {
            return ONE;
        }
        return DecimalFormatter.toコンマ区切りRString(金額, INT_0);
    }
}
