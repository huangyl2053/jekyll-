/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.nofugakuichirancodefumei;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.nofugakuichirandaihyo.NofugakuIchiranSource;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.nofugakudatasakuseitandokushichoson.DbT2016NofugakuJohoTemp;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.business.core.jusho.IJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 *
 * 帳票設計_DBBRP91003-2_納付額一覧表（識別コード不明分）のEditorrクラスです。
 *
 * @reamsid_L DBB-1890-050 qinzhen
 */
public class NofugakuIchiranCodeFumeiEditor implements
        INofugakuIchiranCodeFumeiEditor {

    private static final int NUM_0 = 0;
    private static final int NUM_1 = 1;
    private static final int NUM_2 = 2;
    private static final int NUM_3 = 3;
    private static final int NUM_4 = 4;
    private static final int NUM_6 = 6;
    private static final int NUM_7 = 7;

    private static final RString 前正符号 = new RString("+");
    private static final RString 前符号 = new RString("-");
    private static final RString VALUE_0 = new RString("+0000000");
    private static final RString 年分タイトル = new RString("年分");
    private static final RString 識別コード不明分タイトル = new RString("識別コード不明分");
    private static final RString 欄外文 = new RString("※収納データに誤った通知書番号で登録されている可能性があります。必要に応じて収納データの修正を行い、納付額データ作成の再処理を行って下さい。");

    private static final RString 特別徴収タイトル = new RString("特別徴収");
    private static final RString 普通徴収タイトル = new RString("普通徴収");
    private static final RString 併徴タイトル = new RString("併徴");
    private static final RString 男_1 = new RString("1");
    private static final RString 男 = new RString("男");
    private static final RString 女 = new RString("女");
    private static final RString 日時作成 = new RString("作成");
    private static final RString 特別徴収期別調定額 = new RString("+000000");
    private static final RString 通知書番号タイトル = new RString("通知書番号");

    private final RString 市町村名称;
    private final List<RString> 改頁項目リスト;
    private final RYear 対象年;
    private final DbT2016NofugakuJohoTemp 納付額情報;
    private final UaFt200FindShikibetsuTaishoEntity 宛名Entity;

    /**
     * コンストラクタです
     *
     * @param 市町村名称 RString
     * @param 改頁項目リスト List<RString>
     * @param 対象年 RYear
     * @param 納付額情報 DbT2016NofugakuJohoTemp
     * @param 宛名Entity UaFt200FindShikibetsuTaishoEntity
     *
     */
    public NofugakuIchiranCodeFumeiEditor(RString 市町村名称, List<RString> 改頁項目リスト,
            RYear 対象年, DbT2016NofugakuJohoTemp 納付額情報, UaFt200FindShikibetsuTaishoEntity 宛名Entity) {
        this.市町村名称 = 市町村名称;
        this.改頁項目リスト = 改頁項目リスト;
        this.対象年 = 対象年;
        this.納付額情報 = 納付額情報;
        this.宛名Entity = 宛名Entity;
    }

    @Override
    public NofugakuIchiranSource edit(NofugakuIchiranSource source) {

        if (納付額情報 != null) {
            if (納付額情報.get賦課市町村コード() != null) {
                source.cityCd = 納付額情報.get賦課市町村コード().value();
            }

            if (納付額情報.get被保険者番号() != null) {
                source.list1_1 = 納付額情報.get被保険者番号().value();
            }
            if (納付額情報.get識別コード() != null) {
                source.list2_1 = 納付額情報.get識別コード().value();
            }

            if (納付額情報.get通知書番号() != null) {
                source.list11_15 = 納付額情報.get通知書番号().value();
            }
            Decimal middle1 = getDecimalNum(納付額情報.get特徴調定額06(), 納付額情報.get特徴調定額01(), 納付額情報.get特徴調定額02(),
                    納付額情報.get特徴調定額03(), 納付額情報.get特徴調定額04(), 納付額情報.get特徴調定額05());
            Decimal middle2 = getDecimalNum(納付額情報.get特徴収入額06(), 納付額情報.get特徴収入額01(), 納付額情報.get特徴収入額02(),
                    納付額情報.get特徴収入額03(), 納付額情報.get特徴収入額04(), 納付額情報.get特徴収入額05());
            Decimal middle3 = getDecimalNum(納付額情報.get普徴調定額10(), 納付額情報.get普徴調定額11(), 納付額情報.get普徴調定額12(),
                    納付額情報.get普徴調定額01(), 納付額情報.get普徴調定額02(), 納付額情報.get普徴調定額03());
            Decimal middle4 = getDecimalNum(納付額情報.get普徴調定額04(), 納付額情報.get普徴調定額05(), 納付額情報.get普徴調定額06(),
                    納付額情報.get普徴調定額07(), 納付額情報.get普徴調定額08(), 納付額情報.get普徴調定額09());
            Decimal middle5 = getDecimalNum(納付額情報.get普徴収入額01(), 納付額情報.get普徴収入額02(), 納付額情報.get普徴収入額03(),
                    納付額情報.get普徴収入額04(), 納付額情報.get普徴収入額05(), 納付額情報.get普徴収入額06());
            Decimal middle6 = getDecimalNum(納付額情報.get普徴収入額07(), 納付額情報.get普徴収入額08(), 納付額情報.get普徴収入額09(),
                    納付額情報.get普徴収入額10(), 納付額情報.get普徴収入額11(), 納付額情報.get普徴収入額12());

            get期別額(source);
            get収入額以外分(source, middle2, middle5, middle6);
            getlist6_4(source, middle1, middle2, middle3, middle4, middle5, middle6);

            source.list10_1 = doカンマ編集(middle1, NUM_7);
            source.list11_1 = doカンマ編集(middle2, NUM_7);
            source.list12_1 = doカンマ編集(middle3.add(middle4), NUM_7);
            source.list13_1 = doカンマ編集(middle5.add(middle6), NUM_7);
            source.list8_1 = doカンマ編集(middle1.add(middle3).add(middle4), NUM_7);
            source.list9_1 = doカンマ編集(middle2.add(middle5).add(middle6), NUM_7);

        }

        source.cityMei = 市町村名称;
        source.data1 = 識別コード不明分タイトル;
        source.data2 = 欄外文;
        source.nen = 対象年.toDateString().substring(NUM_0, NUM_4).concat(年分タイトル);
        source.printTimeStamp = getSakuseiYmhm(RDateTime.now());

        source.kaiPageArea1 = get改頁(NUM_0);
        source.kaiPageArea2 = get改頁(NUM_1);
        source.kaiPageArea3 = get改頁(NUM_2);
        source.kaiPageArea4 = get改頁(NUM_3);
        source.kaiPageArea5 = get改頁(NUM_4);

        IKojin 宛名psm = ShikibetsuTaishoFactory.createKojin(宛名Entity);
        if (宛名psm.get世帯コード() != null) {
            source.list3_1 = 宛名psm.get世帯コード().value();
        }

        ChoikiCode 町域コード = 宛名Entity.getChoikiCode();
        if (町域コード != null) {
            source.list4_1 = 町域コード.value();
            source.choikiCode = 町域コード.value();
        }

        AtenaKanaMeisho 氏名５０音カナ = 宛名Entity.getKanaMeisho();
        if (氏名５０音カナ != null) {
            source.kanaMeisho = 氏名５０音カナ.value();
        }

        GyoseikuCode 行政区コード = 宛名Entity.getGyoseikuCode();
        if (行政区コード != null) {
            source.list5_1 = 行政区コード.value();
        }

        AtenaMeisho 氏名 = 宛名Entity.getMeisho();
        if (氏名 != null) {
            source.list6_1 = 氏名.value();
        }

        if (男_1.equals(宛名psm.get性別().getCode())) {
            source.list6_2 = 男;
        } else {
            source.list6_2 = 女;
        }

        if (宛名psm.get生年月日() != null) {

            if (宛名psm.is外国人()) {
                source.list6_3 = 宛名psm.get生年月日().toFlexibleDate().seireki().toDateString();
            } else {
                source.list6_3 = 宛名psm.get生年月日().toFlexibleDate().wareki().toDateString();
            }
        }

        source.list7_1 = getlist7_1(宛名psm.get住所(), 宛名Entity.getBanchi(), 宛名Entity.getKatagaki());

        source.list10_2 = 特別徴収期別調定額;
        source.list10_4 = 特別徴収期別調定額;
        source.list10_6 = 特別徴収期別調定額;
        source.list10_8 = 特別徴収期別調定額;
        source.list10_10 = 特別徴収期別調定額;
        source.list10_12 = 特別徴収期別調定額;
        source.list10_14 = 特別徴収期別調定額;

        source.list10_15 = 通知書番号タイトル;

        source.list11_2 = 特別徴収期別調定額;
        source.list11_4 = 特別徴収期別調定額;
        source.list11_6 = 特別徴収期別調定額;
        source.list11_8 = 特別徴収期別調定額;
        source.list11_10 = 特別徴収期別調定額;
        source.list11_12 = 特別徴収期別調定額;

        source.list12_14 = 特別徴収期別調定額;
        source.list12_15 = RString.EMPTY;

        source.list13_15 = RString.EMPTY;
        return source;

    }

    private RString getSakuseiYmhm(RDateTime datetime) {

        RStringBuilder sakuseiYMD = new RStringBuilder();

        sakuseiYMD.append(datetime.getDate().wareki().
                eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString());
        sakuseiYMD.append(datetime.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒));
        sakuseiYMD.append(日時作成);
        return sakuseiYMD.toRString();
    }

    private void getlist6_4(NofugakuIchiranSource source, Decimal middle1, Decimal middle2, Decimal middle3,
            Decimal middle4, Decimal middle5, Decimal middle6) {
        if (middle1.compareTo(Decimal.ZERO) != NUM_0 || middle2.compareTo(Decimal.ZERO) != NUM_0) {
            if (middle3.add(middle4).compareTo(Decimal.ZERO) == NUM_0 && middle5.add(middle6).compareTo(Decimal.ZERO) == NUM_0) {
                source.list6_4 = 特別徴収タイトル;
            }
            if (middle3.add(middle4).compareTo(Decimal.ZERO) != NUM_0 || middle5.add(middle6).compareTo(Decimal.ZERO) != NUM_0) {
                source.list6_4 = 併徴タイトル;
            }
        } else if (middle1.compareTo(Decimal.ZERO) == NUM_0 && middle2.compareTo(Decimal.ZERO) == NUM_0
                && (middle3.add(middle4).compareTo(Decimal.ZERO) != NUM_0 || middle5.add(middle6).compareTo(Decimal.ZERO) != NUM_0)) {

            source.list6_4 = 普通徴収タイトル;

        }
    }

    private RString getlist7_1(IJusho ijusho, AtenaBanchi banchi, Katagaki katagaki) {

        RStringBuilder sakuseiYMD = new RStringBuilder();
        if (ijusho != null) {
            sakuseiYMD.append(ijusho.get住所());
        }
        if (banchi != null) {
            sakuseiYMD.append(banchi.value());
        }
        if (katagaki != null) {
            sakuseiYMD.append(katagaki.value());
        }

        return sakuseiYMD.toRString();
    }

    private RString doカンマ編集(Decimal decimal, int num) {

        if (null != decimal) {
            RString string = DecimalFormatter.toRString(decimal, NUM_0);
            if (Decimal.ZERO.compareTo(decimal) <= 0) {
                return 前正符号.concat(string.padZeroToLeft(num));
            } else {
                return 前符号.concat(string.substring(NUM_1).padZeroToLeft(num));
            }

        }
        if (NUM_7 == num) {
            return VALUE_0;
        }
        return 特別徴収期別調定額;
    }

    private Decimal getDecimalNum(Decimal decimal, Decimal decimal2, Decimal decimal3, Decimal decimal4, Decimal decimal5, Decimal decimal6) {
        return doNullDecimal(decimal).add(doNullDecimal(decimal2)).add(doNullDecimal(decimal3))
                .add(doNullDecimal(decimal4)).add(doNullDecimal(decimal5)).add(doNullDecimal(decimal6));
    }

    private Decimal doNullDecimal(Decimal decimal6) {
        if (null == decimal6) {
            return Decimal.ZERO;
        }
        return decimal6;
    }

    private RString get改頁(int index) {
        return index < 改頁項目リスト.size() ? 改頁項目リスト.get(index) : RString.EMPTY;
    }

    private void get収入額以外分(NofugakuIchiranSource source, Decimal middle2, Decimal middle5, Decimal middle6) {
        if (納付額情報.get調定年度().compareTo(new FlexibleYear(対象年.toDateString().substring(NUM_0, NUM_4)).minusYear(NUM_1)) == NUM_0) {
            if (納付額情報.get賦課年度().compareTo(new FlexibleYear(対象年.toDateString().substring(NUM_0, NUM_4)).minusYear(NUM_1)) == NUM_0) {
                source.list11_14 = doカンマ編集(middle2.divide(doNullDecimal(納付額情報.get特徴収入額06())), NUM_7);
            }
            if ((納付額情報.get調定年度() != null)
                    && (!new FlexibleYear(対象年.toDateString().substring(NUM_0, NUM_4)).minusYear(NUM_1).isBefore(納付額情報.get賦課年度()))) {
                source.list13_14 = doカンマ編集(middle5.add(doNullDecimal(納付額情報.get普徴収入額07()))
                        .add(doNullDecimal(納付額情報.get普徴収入額08()))
                        .add(doNullDecimal(納付額情報.get普徴収入額09())), NUM_7);
            }
        } else if (納付額情報.get調定年度().compareTo(new FlexibleYear(対象年.toDateString().substring(NUM_0, NUM_4))) == NUM_0) {
            if (納付額情報.get賦課年度().compareTo(new FlexibleYear(対象年.toDateString().substring(NUM_0, NUM_4))) == NUM_0) {
                source.list11_14 = doカンマ編集(納付額情報.get特徴収入額06(), NUM_7);
                source.list13_14 = doカンマ編集(doNullDecimal(納付額情報.get普徴収入額10())
                        .add(doNullDecimal(納付額情報.get普徴収入額11()))
                        .add(doNullDecimal(納付額情報.get普徴収入額12())), NUM_7);
            }
            if ((納付額情報.get調定年度() != null)
                    && (納付額情報.get賦課年度().isBefore(new FlexibleYear(対象年.toDateString().substring(NUM_0, NUM_4))))) {
                source.list11_14 = doカンマ編集(middle2, NUM_7);
                source.list13_14 = doカンマ編集(doNullDecimal(納付額情報.get普徴収入額10())
                        .add(doNullDecimal(納付額情報.get普徴収入額11()))
                        .add(doNullDecimal(納付額情報.get普徴収入額12())), NUM_7);
            }
        } else {
            source.list11_14 = doカンマ編集(middle2, NUM_7);
            source.list13_14 = doカンマ編集(middle5.add(middle6), NUM_7);
        }
    }

    private void get期別額(NofugakuIchiranSource source) {
        source.list10_3 = doカンマ編集(納付額情報.get特徴調定額06(), NUM_6);
        source.list10_5 = doカンマ編集(納付額情報.get特徴調定額01(), NUM_6);
        source.list10_7 = doカンマ編集(納付額情報.get特徴調定額02(), NUM_6);
        source.list10_9 = doカンマ編集(納付額情報.get特徴調定額03(), NUM_6);
        source.list10_11 = doカンマ編集(納付額情報.get特徴調定額04(), NUM_6);
        source.list10_13 = doカンマ編集(納付額情報.get特徴調定額05(), NUM_6);

        source.list11_3 = doカンマ編集(納付額情報.get特徴収入額06(), NUM_6);
        source.list11_5 = doカンマ編集(納付額情報.get特徴収入額01(), NUM_6);
        source.list11_7 = doカンマ編集(納付額情報.get特徴収入額02(), NUM_6);
        source.list11_9 = doカンマ編集(納付額情報.get特徴収入額03(), NUM_6);
        source.list11_11 = doカンマ編集(納付額情報.get特徴収入額04(), NUM_6);
        source.list11_13 = doカンマ編集(納付額情報.get特徴収入額05(), NUM_6);

        source.list12_2 = doカンマ編集(納付額情報.get普徴調定額10(), NUM_6);
        source.list12_3 = doカンマ編集(納付額情報.get普徴調定額11(), NUM_6);
        source.list12_4 = doカンマ編集(納付額情報.get普徴調定額12(), NUM_6);
        source.list12_5 = doカンマ編集(納付額情報.get普徴調定額01(), NUM_6);
        source.list12_6 = doカンマ編集(納付額情報.get普徴調定額02(), NUM_6);
        source.list12_7 = doカンマ編集(納付額情報.get普徴調定額03(), NUM_6);
        source.list12_8 = doカンマ編集(納付額情報.get普徴調定額04(), NUM_6);
        source.list12_9 = doカンマ編集(納付額情報.get普徴調定額05(), NUM_6);
        source.list12_10 = doカンマ編集(納付額情報.get普徴調定額06(), NUM_6);
        source.list12_11 = doカンマ編集(納付額情報.get普徴調定額07(), NUM_6);
        source.list12_12 = doカンマ編集(納付額情報.get普徴調定額08(), NUM_6);
        source.list12_13 = doカンマ編集(納付額情報.get普徴調定額09(), NUM_6);

        source.list13_2 = doカンマ編集(納付額情報.get普徴収入額10(), NUM_6);
        source.list13_3 = doカンマ編集(納付額情報.get普徴収入額11(), NUM_6);
        source.list13_4 = doカンマ編集(納付額情報.get普徴収入額12(), NUM_6);
        source.list13_5 = doカンマ編集(納付額情報.get普徴収入額01(), NUM_6);
        source.list13_6 = doカンマ編集(納付額情報.get普徴収入額02(), NUM_6);
        source.list13_7 = doカンマ編集(納付額情報.get普徴収入額03(), NUM_6);
        source.list13_8 = doカンマ編集(納付額情報.get普徴収入額04(), NUM_6);
        source.list13_9 = doカンマ編集(納付額情報.get普徴収入額05(), NUM_6);
        source.list13_10 = doカンマ編集(納付額情報.get普徴収入額06(), NUM_6);
        source.list13_11 = doカンマ編集(納付額情報.get普徴収入額07(), NUM_6);
        source.list13_12 = doカンマ編集(納付額情報.get普徴収入額08(), NUM_6);
        source.list13_13 = doカンマ編集(納付額情報.get普徴収入額09(), NUM_6);
    }
}
