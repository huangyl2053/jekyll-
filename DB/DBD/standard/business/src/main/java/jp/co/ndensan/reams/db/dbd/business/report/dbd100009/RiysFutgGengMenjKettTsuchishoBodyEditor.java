/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100009;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengaku;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.KetteiKubun;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100009.RiysFutgGengMenjKettTsuchishoReportSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKojin;
import jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu.TeikeibunMojiSize;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 利用者負担額減額･免除認定決定通知書ボディEditorです。
 *
 * @reamsid_L DBD-3540-070 wangchao
 */
public class RiysFutgGengMenjKettTsuchishoBodyEditor implements IRiysFutgGengMenjKettTsuchishoEditor {

    private static final RString 折り返す符号 = new RString("\n");
    private static final RString マル = new RString("○");
    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;
    private static final int INDEX_6 = 6;
    private static final int INDEX_7 = 7;
    private static final int INDEX_8 = 8;
    private static final int INDEX_9 = 9;
    private static final int INDEX_10 = 10;
    private static final int INDEX_11 = 11;
    private static final int INDEX_12 = 12;
    private static final int INDEX_13 = 13;
    private static final int INDEX_14 = 14;
    private static final int INDEX_15 = 15;
    private static final int INDEX_16 = 16;
    private static final int INDEX_17 = 17;
    private static final int INDEX_18 = 18;
    private static final int INDEX_19 = 19;
    private static final int INDEX_20 = 20;
    private static final int INDEX_21 = 21;

    private final RiyoshaFutangakuGengaku 利用者負担額減額情報;
    private final IKojin iKojin;
    private final IAtesaki iAtesaki;
    private final ChohyoSeigyoKyotsu 帳票制御共通;
    private final List<DbT7067ChohyoSeigyoHanyoEntity> 帳票制御汎用List;
    private final Association 地方公共団体;
    private final RString 文書番号;
    private final List<RString> 通知書定型文List;
    private final NinshoshaSource ninshoshaSource;

    /**
     * インスタンスを生成します。
     *
     * @param 利用者負担額減額情報 利用者負担額減額情報
     * @param iKojin iKojin
     * @param iAtesaki iAtesaki
     * @param 帳票制御共通 帳票制御共通
     * @param 帳票制御汎用List 帳票制御汎用List
     * @param 地方公共団体 地方公共団体
     * @param 文書番号 文書番号
     * @param 通知書定型文List 通知書定型文List
     * @param ninshoshaSource NinshoshaSource
     */
    public RiysFutgGengMenjKettTsuchishoBodyEditor(RiyoshaFutangakuGengaku 利用者負担額減額情報, IKojin iKojin, IAtesaki iAtesaki,
            ChohyoSeigyoKyotsu 帳票制御共通, List<DbT7067ChohyoSeigyoHanyoEntity> 帳票制御汎用List, Association 地方公共団体,
            RString 文書番号, List<RString> 通知書定型文List, NinshoshaSource ninshoshaSource) {
        this.利用者負担額減額情報 = 利用者負担額減額情報;
        this.iKojin = iKojin;
        this.iAtesaki = iAtesaki;
        this.帳票制御共通 = 帳票制御共通;
        this.帳票制御汎用List = 帳票制御汎用List;
        this.地方公共団体 = 地方公共団体;
        this.文書番号 = 文書番号;
        this.通知書定型文List = 通知書定型文List;
        this.ninshoshaSource = ninshoshaSource;
    }

    /**
     * 利用者負担額減額･免除認定決定通知書ボディEditorです。
     *
     * @param source 利用者負担額減額･免除認定決定通知書Source
     * @return 利用者負担額減額･免除認定決定通知書Source
     */
    @Override
    public RiysFutgGengMenjKettTsuchishoReportSource edit(RiysFutgGengMenjKettTsuchishoReportSource source) {
        return bodyEdit(source);
    }

    private RiysFutgGengMenjKettTsuchishoReportSource bodyEdit(RiysFutgGengMenjKettTsuchishoReportSource source) {
        source.bunshoNo = 文書番号;

        setTitle(source);
        set通知文(source);

        EditedKojin 編集後個人 = getEditedKojin(iKojin, 帳票制御共通, 地方公共団体);
        source.hihokenshaName = 編集後個人.get名称().getName().getColumnValue();
        source.hihokenshaNo1 = 利用者負担額減額情報.get被保険者番号().getColumnValue().substring(INDEX_0, INDEX_1);
        source.hihokenshaNo2 = 利用者負担額減額情報.get被保険者番号().getColumnValue().substring(INDEX_1, INDEX_2);
        source.hihokenshaNo3 = 利用者負担額減額情報.get被保険者番号().getColumnValue().substring(INDEX_2, INDEX_3);
        source.hihokenshaNo4 = 利用者負担額減額情報.get被保険者番号().getColumnValue().substring(INDEX_3, INDEX_4);
        source.hihokenshaNo5 = 利用者負担額減額情報.get被保険者番号().getColumnValue().substring(INDEX_4, INDEX_5);
        source.hihokenshaNo6 = 利用者負担額減額情報.get被保険者番号().getColumnValue().substring(INDEX_5, INDEX_6);
        source.hihokenshaNo7 = 利用者負担額減額情報.get被保険者番号().getColumnValue().substring(INDEX_6, INDEX_7);
        source.hihokenshaNo8 = 利用者負担額減額情報.get被保険者番号().getColumnValue().substring(INDEX_7, INDEX_8);
        source.hihokenshaNo9 = 利用者負担額減額情報.get被保険者番号().getColumnValue().substring(INDEX_8, INDEX_9);
        source.hihokenshaNo10 = 利用者負担額減額情報.get被保険者番号().getColumnValue().substring(INDEX_9, INDEX_10);
        source.ketteiYMD = 利用者負担額減額情報.get決定年月日().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();

        if (KetteiKubun.承認する.getコード().equals(利用者負担額減額情報.get決定区分())) {
            source.tekiyoYMD = 利用者負担額減額情報.get適用開始年月日().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            source.ninteiKekka1 = new RString("（承認内容）");
            source.shoninSuru = マル;
            source.yukoYMD = 利用者負担額減額情報.get適用終了年月日().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            source.ninteiKekka3
                    = new RString("　　　給付率　　".concat(利用者負担額減額情報.get給付率().getColumnValue().toString().concat("　/　100")));
            source.shoninShinai = RString.EMPTY;
            source.riyu1 = RString.EMPTY;
            source.riyu2 = RString.EMPTY;
            source.riyu3 = RString.EMPTY;
            source.riyu4 = RString.EMPTY;
            source.riyu5 = RString.EMPTY;
        } else {
            source.tekiyoYMD = RString.EMPTY;
            source.ninteiKekka1 = RString.EMPTY;
            source.shoninSuru = RString.EMPTY;
            source.yukoYMD = RString.EMPTY;
            source.ninteiKekka3 = RString.EMPTY;
            source.shoninShinai = マル;
            List<RString> 非承認理由 = 利用者負担額減額情報.get非承認理由().split(折り返す符号.toString());
            source.riyu1 = get非承認理由List(INDEX_0, 非承認理由);
            source.riyu2 = get非承認理由List(INDEX_1, 非承認理由);
            source.riyu3 = get非承認理由List(INDEX_2, 非承認理由);
            source.riyu4 = get非承認理由List(INDEX_3, 非承認理由);
            source.riyu5 = get非承認理由List(INDEX_4, 非承認理由);

        }

        source.ninteiKekka2 = RString.EMPTY;
        source.ninteiKekka4 = RString.EMPTY;
        source.ninteiKekka5 = RString.EMPTY;
        source.ninteiKekka6 = RString.EMPTY;
        source.ninteiKekka7 = RString.EMPTY;
        source.ninteiKekka8 = RString.EMPTY;
        source.ninteiKekka9 = RString.EMPTY;

        if (TeikeibunMojiSize.フォント小.getコード().equals(帳票制御共通.get定型文文字サイズ())) {
            set連絡先他(source);
        } else if (TeikeibunMojiSize.フォント大.getコード().equals(帳票制御共通.get定型文文字サイズ())) {
            set連絡先他Large(source);
        } else if (TeikeibunMojiSize.フォント上小下大.getコード().equals(帳票制御共通.get定型文文字サイズ())) {
            set連絡先他上段Small(source);
            set連絡先他下段Large(source);
        } else if (TeikeibunMojiSize.フォント上大下小.getコード().equals(帳票制御共通.get定型文文字サイズ())) {
            set連絡先他上段Large(source);
            set連絡先他下段Small(source);
        }
        setCompNinshosha(source);
        setCompSofubutsuAtesaki(source);

        source.shikibetsuCode = iKojin.get識別コード().getColumnValue();
        source.hihokenshaNo = 利用者負担額減額情報.get被保険者番号().getColumnValue();
        return source;
    }

    private RString get非承認理由List(int i, List<RString> 非承認理由) {
        if (非承認理由.size() >= i + 1) {
            return 非承認理由.get(i);
        } else {
            return RString.EMPTY;
        }
    }

    private RiysFutgGengMenjKettTsuchishoReportSource setTitle(RiysFutgGengMenjKettTsuchishoReportSource source) {
        if (利用者負担額減額情報.is旧措置者有無()) {
            for (DbT7067ChohyoSeigyoHanyoEntity entity : 帳票制御汎用List) {
                if (new RString(ChohyoSeigyoHanyoKeysDBD100009.帳票タイトル_上段_旧措置者用.name()).equals(entity.getKomokuName())) {
                    source.title1 = entity.getKomokuValue();
                    break;
                }
            }
            for (DbT7067ChohyoSeigyoHanyoEntity entity : 帳票制御汎用List) {
                if (new RString(ChohyoSeigyoHanyoKeysDBD100009.帳票タイトル__旧措置者用.name()).equals(entity.getKomokuName())) {
                    source.title2 = entity.getKomokuValue();
                    break;
                }
            }

        } else {
            for (DbT7067ChohyoSeigyoHanyoEntity entity : 帳票制御汎用List) {
                if (new RString(ChohyoSeigyoHanyoKeysDBD100009.帳票タイトル_上段.name()).equals(entity.getKomokuName())) {
                    source.title1 = entity.getKomokuValue();
                    break;
                }
            }
            for (DbT7067ChohyoSeigyoHanyoEntity entity : 帳票制御汎用List) {
                if (new RString(ChohyoSeigyoHanyoKeysDBD100009.帳票タイトル_下段.name()).equals(entity.getKomokuName())) {
                    source.title2 = entity.getKomokuValue();
                    break;
                }
            }

        }
        return source;
    }

    private void set通知文(RiysFutgGengMenjKettTsuchishoReportSource source) {
        List<RString> 通知書定型文リスト = 通知書定型文List.get(1).split(折り返す符号.toString());
        source.tsuchibun1 = getLenStr(INDEX_0, 通知書定型文リスト);
        source.tsuchibun2 = getLenStr(INDEX_1, 通知書定型文リスト);
    }

    private void set連絡先他(RiysFutgGengMenjKettTsuchishoReportSource source) {
        List<RString> 通知書定型文リスト = 通知書定型文List.get(2).split(折り返す符号.toString());
        source.tsuchibun3 = getLenStr(INDEX_0, 通知書定型文リスト);
        source.tsuchibun4 = getLenStr(INDEX_1, 通知書定型文リスト);
        source.tsuchibun5 = getLenStr(INDEX_2, 通知書定型文リスト);
        source.tsuchibun6 = getLenStr(INDEX_3, 通知書定型文リスト);
        source.tsuchibun7 = getLenStr(INDEX_4, 通知書定型文リスト);
        source.tsuchibun8 = getLenStr(INDEX_5, 通知書定型文リスト);
        source.tsuchibun9 = getLenStr(INDEX_6, 通知書定型文リスト);
        source.tsuchibun10 = getLenStr(INDEX_7, 通知書定型文リスト);
        source.tsuchibun11 = getLenStr(INDEX_8, 通知書定型文リスト);
        source.tsuchibun12 = getLenStr(INDEX_9, 通知書定型文リスト);
        source.tsuchibun13 = getLenStr(INDEX_10, 通知書定型文リスト);
        source.tsuchibun14 = getLenStr(INDEX_11, 通知書定型文リスト);
        source.tsuchibun15 = getLenStr(INDEX_12, 通知書定型文リスト);
        source.tsuchibun16 = getLenStr(INDEX_13, 通知書定型文リスト);
        source.tsuchibun17 = getLenStr(INDEX_14, 通知書定型文リスト);
        source.tsuchibun18 = getLenStr(INDEX_15, 通知書定型文リスト);
        source.tsuchibun19 = getLenStr(INDEX_16, 通知書定型文リスト);
        source.tsuchibun20 = getLenStr(INDEX_17, 通知書定型文リスト);
        source.tsuchibun21 = getLenStr(INDEX_18, 通知書定型文リスト);
        source.tsuchibun22 = getLenStr(INDEX_19, 通知書定型文リスト);
        source.tsuchibun23 = getLenStr(INDEX_20, 通知書定型文リスト);
        source.tsuchibun24 = getLenStr(INDEX_21, 通知書定型文リスト);
    }

    private void set連絡先他Large(RiysFutgGengMenjKettTsuchishoReportSource source) {
        List<RString> 通知書定型文リスト = 通知書定型文List.get(2).split(折り返す符号.toString());
        source.tsuchibunLarge3 = getLenStr(INDEX_0, 通知書定型文リスト);
        source.tsuchibunLarge4 = getLenStr(INDEX_1, 通知書定型文リスト);
        source.tsuchibunLarge5 = getLenStr(INDEX_2, 通知書定型文リスト);
        source.tsuchibunLarge6 = getLenStr(INDEX_3, 通知書定型文リスト);
        source.tsuchibunLarge7 = getLenStr(INDEX_4, 通知書定型文リスト);
        source.tsuchibunLarge8 = getLenStr(INDEX_5, 通知書定型文リスト);
        source.tsuchibunLarge9 = getLenStr(INDEX_6, 通知書定型文リスト);
        source.tsuchibunLarge10 = getLenStr(INDEX_7, 通知書定型文リスト);
        source.tsuchibunLarge11 = getLenStr(INDEX_8, 通知書定型文リスト);
        source.tsuchibunLarge12 = getLenStr(INDEX_9, 通知書定型文リスト);
        source.tsuchibunLarge13 = getLenStr(INDEX_10, 通知書定型文リスト);
        source.tsuchibunLarge14 = getLenStr(INDEX_11, 通知書定型文リスト);
        source.tsuchibunLarge15 = getLenStr(INDEX_12, 通知書定型文リスト);
        source.tsuchibunLarge16 = getLenStr(INDEX_13, 通知書定型文リスト);
        source.tsuchibunLarge17 = getLenStr(INDEX_14, 通知書定型文リスト);
        source.tsuchibunLarge18 = getLenStr(INDEX_15, 通知書定型文リスト);
        source.tsuchibunLarge19 = getLenStr(INDEX_16, 通知書定型文リスト);
        source.tsuchibunLarge20 = getLenStr(INDEX_17, 通知書定型文リスト);
    }

    private void set連絡先他上段Small(RiysFutgGengMenjKettTsuchishoReportSource source) {
        List<RString> 通知書定型文リスト = 通知書定型文List.get(2).split(折り返す符号.toString());
        source.tsuchibunMix3 = getLenStr(INDEX_0, 通知書定型文リスト);
        source.tsuchibunMix4 = getLenStr(INDEX_1, 通知書定型文リスト);
        source.tsuchibunMix5 = getLenStr(INDEX_2, 通知書定型文リスト);
        source.tsuchibunMix6 = getLenStr(INDEX_3, 通知書定型文リスト);
        source.tsuchibunMix7 = getLenStr(INDEX_4, 通知書定型文リスト);
        source.tsuchibunMix8 = getLenStr(INDEX_5, 通知書定型文リスト);
        source.tsuchibunMix9 = getLenStr(INDEX_6, 通知書定型文リスト);
        source.tsuchibunMix10 = getLenStr(INDEX_7, 通知書定型文リスト);
        source.tsuchibunMix11 = getLenStr(INDEX_8, 通知書定型文リスト);
        source.tsuchibunMix12 = getLenStr(INDEX_9, 通知書定型文リスト);
        source.tsuchibunMix13 = getLenStr(INDEX_10, 通知書定型文リスト);
        source.tsuchibunMix14 = getLenStr(INDEX_11, 通知書定型文リスト);
        source.tsuchibunMix15 = getLenStr(INDEX_12, 通知書定型文リスト);

    }

    private void set連絡先他下段Large(RiysFutgGengMenjKettTsuchishoReportSource source) {
        List<RString> 通知書定型文リスト = 通知書定型文List.get(INDEX_3).split(折り返す符号.toString());
        source.tsuchibunMix16 = getLenStr(INDEX_0, 通知書定型文リスト);
        source.tsuchibunMix17 = getLenStr(INDEX_1, 通知書定型文リスト);
        source.tsuchibunMix18 = getLenStr(INDEX_2, 通知書定型文リスト);
        source.tsuchibunMix19 = getLenStr(INDEX_3, 通知書定型文リスト);
        source.tsuchibunMix20 = getLenStr(INDEX_4, 通知書定型文リスト);
        source.tsuchibunMix21 = getLenStr(INDEX_5, 通知書定型文リスト);
        source.tsuchibunMix22 = getLenStr(INDEX_6, 通知書定型文リスト);
    }

    private void set連絡先他上段Large(RiysFutgGengMenjKettTsuchishoReportSource source) {
        List<RString> 通知書定型文リスト = 通知書定型文List.get(2).split(折り返す符号.toString());
        source.tsuchibunMixtwo3 = getLenStr(INDEX_0, 通知書定型文リスト);
        source.tsuchibunMixtwo4 = getLenStr(INDEX_1, 通知書定型文リスト);
        source.tsuchibunMixtwo5 = getLenStr(INDEX_2, 通知書定型文リスト);
        source.tsuchibunMixtwo6 = getLenStr(INDEX_3, 通知書定型文リスト);
        source.tsuchibunMixtwo7 = getLenStr(INDEX_4, 通知書定型文リスト);
        source.tsuchibunMixtwo8 = getLenStr(INDEX_5, 通知書定型文リスト);
        source.tsuchibunMixtwo9 = getLenStr(INDEX_6, 通知書定型文リスト);

    }

    private void set連絡先他下段Small(RiysFutgGengMenjKettTsuchishoReportSource source) {
        List<RString> 通知書定型文リスト = 通知書定型文List.get(INDEX_3).split(折り返す符号.toString());
        source.tsuchibunMixtwo10 = getLenStr(INDEX_0, 通知書定型文リスト);
        source.tsuchibunMixtwo11 = getLenStr(INDEX_1, 通知書定型文リスト);
        source.tsuchibunMixtwo12 = getLenStr(INDEX_2, 通知書定型文リスト);
        source.tsuchibunMixtwo13 = getLenStr(INDEX_3, 通知書定型文リスト);
        source.tsuchibunMixtwo14 = getLenStr(INDEX_4, 通知書定型文リスト);
        source.tsuchibunMixtwo15 = getLenStr(INDEX_5, 通知書定型文リスト);
        source.tsuchibunMixtwo16 = getLenStr(INDEX_6, 通知書定型文リスト);
        source.tsuchibunMixtwo17 = getLenStr(INDEX_7, 通知書定型文リスト);
        source.tsuchibunMixtwo18 = getLenStr(INDEX_8, 通知書定型文リスト);
        source.tsuchibunMixtwo19 = getLenStr(INDEX_9, 通知書定型文リスト);
        source.tsuchibunMixtwo20 = getLenStr(INDEX_10, 通知書定型文リスト);
        source.tsuchibunMixtwo21 = getLenStr(INDEX_11, 通知書定型文リスト);
        source.tsuchibunMixtwo22 = getLenStr(INDEX_12, 通知書定型文リスト);
    }

    private RString getLenStr(int i, List<RString> 通知書定型文List) {
        if (通知書定型文List.size() >= i + 1) {
            return 通知書定型文List.get(i);
        } else {
            return RString.EMPTY;
        }
    }

    private void setCompNinshosha(RiysFutgGengMenjKettTsuchishoReportSource source) {
        source.denshiKoin = ninshoshaSource.denshiKoin;
        source.hakkoYMD = ninshoshaSource.hakkoYMD;
        source.ninshoshaYakushokuMei1 = ninshoshaSource.ninshoshaYakushokuMei1;
        source.koinMojiretsu = ninshoshaSource.koinMojiretsu;
        source.ninshoshaYakushokuMei2 = ninshoshaSource.ninshoshaYakushokuMei2;
        source.ninshoshaYakushokuMei = ninshoshaSource.ninshoshaYakushokuMei;
        source.ninshoshaShimeiKakenai = ninshoshaSource.ninshoshaShimeiKakenai;
        source.ninshoshaShimeiKakeru = ninshoshaSource.ninshoshaShimeiKakeru;
        source.koinShoryaku = ninshoshaSource.koinShoryaku;
    }

    private void setCompSofubutsuAtesaki(RiysFutgGengMenjKettTsuchishoReportSource source) {
        SofubutsuAtesakiSource sofubutsuAtesakiSource;
        try {
            sofubutsuAtesakiSource = JushoHenshu.create編集後宛先(
                    iAtesaki, 地方公共団体, 帳票制御共通).getSofubutsuAtesakiSource().get送付物宛先ソース();
        } catch (Exception e) {
            sofubutsuAtesakiSource = new SofubutsuAtesakiSource();
        }
        source.yubinNo = sofubutsuAtesakiSource.yubinNo;
        source.gyoseiku1 = sofubutsuAtesakiSource.gyoseiku;
        source.jusho4 = sofubutsuAtesakiSource.jusho1;
        if (sofubutsuAtesakiSource.jushoText == null) {
            RStringBuilder jusho1 = new RStringBuilder(sofubutsuAtesakiSource.jusho1);
            source.jushoText = jusho1.append(sofubutsuAtesakiSource.jusho2).append(sofubutsuAtesakiSource.jusho3).toRString();
        } else {
            source.jushoText = sofubutsuAtesakiSource.jushoText;
        }
        source.jusho5 = sofubutsuAtesakiSource.jusho2;
        source.jusho6 = sofubutsuAtesakiSource.jusho3;
        source.katagakiText = sofubutsuAtesakiSource.katagakiText;
        source.katagaki3 = sofubutsuAtesakiSource.katagaki1;
        source.katagakiSmall2 = sofubutsuAtesakiSource.katagakiSmall2;
        source.katagaki4 = sofubutsuAtesakiSource.katagaki2;
        source.katagakiSmall1 = sofubutsuAtesakiSource.katagakiSmall1;
        source.shimei3 = sofubutsuAtesakiSource.shimei1;
        source.shimeiSmall2 = sofubutsuAtesakiSource.shimeiSmall2;
        source.shimeiText = sofubutsuAtesakiSource.shimeiText;
        source.meishoFuyo2 = sofubutsuAtesakiSource.meishoFuyo2;
        source.shimeiSmall1 = sofubutsuAtesakiSource.shimeiSmall1;
        source.dainoKubunMei = sofubutsuAtesakiSource.dainoKubunMei;
        source.shimei4 = sofubutsuAtesakiSource.shimei2;
        source.meishoFuyo1 = sofubutsuAtesakiSource.meishoFuyo1;
        source.samabunShimeiText = sofubutsuAtesakiSource.samabunShimeiText;
        source.samabunShimeiSmall2 = sofubutsuAtesakiSource.samabunShimeiSmall2;
        source.samaBun2 = sofubutsuAtesakiSource.samaBun2;
        source.kakkoLeft2 = sofubutsuAtesakiSource.kakkoLeft2;
        source.samabunShimei2 = sofubutsuAtesakiSource.samabunShimei2;
        source.kakkoRight2 = sofubutsuAtesakiSource.kakkoRight2;
        source.kakkoLeft1 = sofubutsuAtesakiSource.kakkoLeft1;
        source.samabunShimei1 = sofubutsuAtesakiSource.samabunShimei1;
        source.samaBun1 = sofubutsuAtesakiSource.samaBun1;
        source.kakkoRight1 = sofubutsuAtesakiSource.kakkoRight1;
        source.samabunShimeiSmall1 = sofubutsuAtesakiSource.samabunShimeiSmall1;
        source.customerBarCode = sofubutsuAtesakiSource.customerBarCode;
    }

    private static EditedKojin getEditedKojin(IKojin kojin, ChohyoSeigyoKyotsu 帳票制御共通, Association 地方公共団体) {
        return new EditedKojin(kojin, 帳票制御共通, 地方公共団体);
    }
}
