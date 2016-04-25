/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatis.param.hanyolisthihokenshadaicho;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.hihokenshadaicho.HaniChushutsuKubun;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.hihokenshadaicho.HizukeChushutsuKubun;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.hihokenshadaicho.KijunbiKubun;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.hihokenshadaicho.ShikakuChushutsuKubun;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 汎用リスト_被保険者台帳_マッパー用のパラメータです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListHihokenshadaichoMyBatisParameter implements IMyBatisParameter {

    private static final RString 年齢 = new RString("1");
    private static final RString 生年月日 = new RString("2");
    private static final RString 住所 = new RString("1");
    private static final RString 行政区 = new RString("2");
    private static final RString 地区 = new RString("3");
    private static final RString CHECK = new RString("1");
    private static final int INT_3 = 3;
    private static final int INT_4 = 4;
    private static final int INT_5 = 5;
    private final boolean komukuFukaMeyi;
    private final boolean rembanfuka;
    private final boolean hidukeHensyu;
    private final RString hidukeTyuushutuKubun;
    private final RString kijunniKubun;
    private final FlexibleDate kijunni;
    private final boolean kijunNichijiJukyusha;
    private final RString rangeChushutsuhiKubun;
    private final FlexibleDate rangeChushutsuhiFrom;
    private final FlexibleDate rangeChushutsuhiTo;
    private final List<RString> hiHokenshaJyoho;
    private final RString shikakuChushutsuKubun;
    private final List<RString> shutokujiyu;
    private final List<RString> soshitsujiyu;
    private final RString psmChushutsuJyouken;
    private final RString pageShuturyokujun_Id;
    private final RString shutsuryokuKomuku_Id;
    private final RString chohyoId;
    private final RString psmChushutsu_Kubun;
    private final RString psmChushutsuAge_Start;
    private final RString psmChushutsuAge_End;
    private final RString psmSeinengappiYMD_Start;
    private final RString psmSeinengappiYMD_End;
    private final FlexibleDate psmAgeKijunni;
    private final RString psmChiku_Kubun;
    private final RString psmChiku_Start;
    private final RString psmChiku_End;
    private final RString psmShikibetsuTaisho;
    private final boolean is直近;
    private final boolean is基準日;
    private final boolean is範囲;
    private final boolean is資格取得日;
    private final boolean is資格取得届出日;
    private final boolean is取得日;
    private final boolean is取得届出日;
    private final boolean is喪失日;
    private final boolean is喪失届出日;
    private final boolean is１号;
    private final boolean is２号;
    private final boolean is日本人;
    private final boolean is外国人;
    private final boolean is自特例者;
    private final boolean is広域住特;
    private final boolean is資格取得者のみ;
    private final boolean is資格喪失者のみ;
    private final boolean isEmpty;
    private final FlexibleDate 宛名抽出年齢開始;
    private final FlexibleDate 宛名抽出年齢終了;
    private final boolean is年齢;
    private final boolean is生年月日;
    private final boolean is住所;
    private final boolean is行政区;
    private final boolean is地区;
    private final boolean has年齢開始;
    private final boolean has年齢終了;
    private final boolean has生年月日開始;
    private final boolean has生年月日終了;

    /**
     * コンストラクタです。
     *
     * @param komukuFukaMeyi 項目名付加
     * @param rembanfuka 連番付加
     * @param hidukeHensyu 日付編集
     * @param hidukeTyuushutuKubun 日付抽出区分
     * @param kijunniKubun 基準日区分
     * @param kijunni 基準日
     * @param kijunNichijiJukyusha 基準日時点の受給者を除く
     * @param rangeChushutsuhiKubun 範囲抽出日区分
     * @param rangeChushutsuhiFrom 範囲抽出日From
     * @param rangeChushutsuhiTo 範囲抽出日To
     * @param hiHokenshaJyoho 被保険者情報
     * @param shikakuChushutsuKubun 資格抽出区分
     * @param shutokujiyu 取得事由
     * @param soshitsujiyu 喪失事由
     * @param psmChushutsuJyouken 宛名抽出条件
     * @param pageShuturyokujun_Id 改頁出力順ID
     * @param shutsuryokuKomuku_Id 出力項目ID
     * @param chohyoId 帳票ID
     * @param psmChushutsu_Kubun 宛名抽出区分
     * @param psmChushutsuAge_Start 宛名抽出年齢開始
     * @param psmChushutsuAge_End 宛名抽出年齢終了
     * @param psmSeinengappiYMD_Start 宛名抽出生年月日開始
     * @param psmSeinengappiYMD_End 宛名抽出生年月日終了
     * @param psmAgeKijunni 宛名抽出年齢基準日
     * @param psmChiku_Kubun 宛名抽出地区区分
     * @param psmChiku_Start 宛名抽出地区開始
     * @param psmChiku_End 宛名抽出地区終了
     * @param is直近 is直近
     * @param is基準日 is基準日
     * @param is範囲 is範囲
     * @param is資格取得日 is資格取得日
     * @param is資格取得届出日 is資格取得届出日
     * @param is取得日 is取得日
     * @param is取得届出日 is取得届出日
     * @param is喪失日 is喪失日
     * @param is喪失届出日 is喪失届出日
     * @param is１号 is１号
     * @param is２号 is２号
     * @param is日本人 is日本人
     * @param is外国人 is外国人
     * @param is自特例者 is自特例者
     * @param is広域住特 is広域住特
     * @param is資格取得者のみ is資格取得者のみ
     * @param is資格喪失者のみ is資格喪失者のみ
     * @param isEmpty isEmpty
     * @param 宛名抽出年齢開始 宛名抽出年齢開始
     * @param 宛名抽出年齢終了 宛名抽出年齢終了
     * @param is年齢 is年齢
     * @param is生年月日 is生年月日
     * @param is住所 is住所
     * @param is行政区 is行政区
     * @param is地区 is地区
     * @param has年齢開始 has年齢開始
     * @param has年齢終了 has年齢終了
     * @param has生年月日開始 has生年月日開始
     * @param has生年月日終了 has生年月日終了
     * @param psmShikibetsuTaisho psmShikibetsuTaisho
     */
    public HanyoListHihokenshadaichoMyBatisParameter(
            boolean komukuFukaMeyi, boolean rembanfuka, boolean hidukeHensyu, RString hidukeTyuushutuKubun, RString kijunniKubun,
            FlexibleDate kijunni, boolean kijunNichijiJukyusha, RString rangeChushutsuhiKubun, FlexibleDate rangeChushutsuhiFrom,
            FlexibleDate rangeChushutsuhiTo, List<RString> hiHokenshaJyoho, RString shikakuChushutsuKubun, List<RString> shutokujiyu,
            List<RString> soshitsujiyu, RString psmChushutsuJyouken, RString pageShuturyokujun_Id, RString shutsuryokuKomuku_Id,
            RString chohyoId, RString psmChushutsu_Kubun, RString psmChushutsuAge_Start, RString psmChushutsuAge_End,
            RString psmSeinengappiYMD_Start, RString psmSeinengappiYMD_End, FlexibleDate psmAgeKijunni, RString psmChiku_Kubun,
            RString psmChiku_Start, RString psmChiku_End, boolean is直近, boolean is基準日, boolean is範囲, boolean is資格取得日,
            boolean is資格取得届出日, boolean is取得日, boolean is取得届出日, boolean is喪失日, boolean is喪失届出日, boolean is１号, boolean is２号,
            boolean is日本人, boolean is外国人, boolean is自特例者, boolean is広域住特, boolean is資格取得者のみ, boolean is資格喪失者のみ,
            boolean isEmpty, FlexibleDate 宛名抽出年齢開始, FlexibleDate 宛名抽出年齢終了, boolean is年齢, boolean is生年月日, boolean is住所,
            boolean is行政区, boolean is地区, boolean has年齢開始, boolean has年齢終了, boolean has生年月日開始, boolean has生年月日終了,
            RString psmShikibetsuTaisho) {
        this.komukuFukaMeyi = komukuFukaMeyi;
        this.rembanfuka = rembanfuka;
        this.hidukeHensyu = hidukeHensyu;
        this.hidukeTyuushutuKubun = hidukeTyuushutuKubun;
        this.kijunniKubun = kijunniKubun;
        this.kijunni = kijunni;
        this.kijunNichijiJukyusha = kijunNichijiJukyusha;
        this.rangeChushutsuhiKubun = rangeChushutsuhiKubun;
        this.rangeChushutsuhiFrom = rangeChushutsuhiFrom;
        this.rangeChushutsuhiTo = rangeChushutsuhiTo;
        this.hiHokenshaJyoho = hiHokenshaJyoho;
        this.shikakuChushutsuKubun = shikakuChushutsuKubun;
        this.shutokujiyu = shutokujiyu;
        this.soshitsujiyu = soshitsujiyu;
        this.psmChushutsuJyouken = psmChushutsuJyouken;
        this.pageShuturyokujun_Id = pageShuturyokujun_Id;
        this.shutsuryokuKomuku_Id = shutsuryokuKomuku_Id;
        this.chohyoId = chohyoId;
        this.psmChushutsu_Kubun = psmChushutsu_Kubun;
        this.psmChushutsuAge_Start = psmChushutsuAge_Start;
        this.psmChushutsuAge_End = psmChushutsuAge_End;
        this.psmSeinengappiYMD_Start = psmSeinengappiYMD_Start;
        this.psmSeinengappiYMD_End = psmSeinengappiYMD_End;
        this.psmAgeKijunni = psmAgeKijunni;
        this.psmChiku_Kubun = psmChiku_Kubun;
        this.psmChiku_Start = psmChiku_Start;
        this.psmChiku_End = psmChiku_End;
        this.is直近 = is直近;
        this.is基準日 = is基準日;
        this.is範囲 = is範囲;
        this.is資格取得日 = is資格取得日;
        this.is資格取得届出日 = is資格取得届出日;
        this.is取得日 = is取得日;
        this.is取得届出日 = is取得届出日;
        this.is喪失日 = is喪失日;
        this.is喪失届出日 = is喪失届出日;
        this.is１号 = is１号;
        this.is２号 = is２号;
        this.is日本人 = is日本人;
        this.is外国人 = is外国人;
        this.is自特例者 = is自特例者;
        this.is広域住特 = is広域住特;
        this.is資格取得者のみ = is資格取得者のみ;
        this.is資格喪失者のみ = is資格喪失者のみ;
        this.isEmpty = isEmpty;
        this.宛名抽出年齢開始 = 宛名抽出年齢開始;
        this.宛名抽出年齢終了 = 宛名抽出年齢終了;
        this.is年齢 = is年齢;
        this.is生年月日 = is生年月日;
        this.is住所 = is住所;
        this.is行政区 = is行政区;
        this.is地区 = is地区;
        this.has年齢開始 = has年齢開始;
        this.has年齢終了 = has年齢終了;
        this.has生年月日開始 = has生年月日開始;
        this.has生年月日終了 = has生年月日終了;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
    }

    /**
     *
     * @param komukuFukaMeyi 項目名付加
     * @param rembanfuka 連番付加
     * @param hidukeHensyu 日付編集
     * @param hidukeTyuushutuKubun 日付抽出区分
     * @param kijunniKubun 基準日区分
     * @param kijunni 基準日
     * @param kijunNichijiJukyusha 基準日時点の受給者を除く
     * @param rangeChushutsuhiKubun 範囲抽出日区分
     * @param rangeChushutsuhiFrom 範囲抽出日From
     * @param rangeChushutsuhiTo 範囲抽出日To
     * @param hiHokenshaJyoho 被保険者情報
     * @param shikakuChushutsuKubun 資格抽出区分
     * @param shutokujiyu 取得事由
     * @param soshitsujiyu 喪失事由
     * @param psmChushutsu_Kubun 宛名抽出区分
     * @param psmChushutsuAge_Start 宛名抽出年齢開始
     * @param psmChushutsuAge_End 宛名抽出年齢終了
     * @param psmSeinengappiYMD_Start 宛名抽出生年月日開始
     * @param psmSeinengappiYMD_End 宛名抽出生年月日終了
     * @param psmAgeKijunni 宛名抽出年齢基準日
     * @param psmChiku_Kubun 宛名抽出地区区分
     * @param psmChiku_Start 宛名抽出地区開始
     * @param psmChiku_End 宛名抽出地区終了
     * @param psmShikibetsuTaisho PSM
     * @return 汎用リスト_被保険者台帳_マッパー用のパラメータです。
     */
    public static HanyoListHihokenshadaichoMyBatisParameter create_MybatisParameter(
            boolean komukuFukaMeyi, boolean rembanfuka, boolean hidukeHensyu, RString hidukeTyuushutuKubun,
            RString kijunniKubun, FlexibleDate kijunni, boolean kijunNichijiJukyusha, RString rangeChushutsuhiKubun,
            FlexibleDate rangeChushutsuhiFrom, FlexibleDate rangeChushutsuhiTo, List<RString> hiHokenshaJyoho, RString shikakuChushutsuKubun,
            List<RString> shutokujiyu, List<RString> soshitsujiyu, RString psmChushutsu_Kubun, RString psmChushutsuAge_Start,
            RString psmChushutsuAge_End, RString psmSeinengappiYMD_Start, RString psmSeinengappiYMD_End, FlexibleDate psmAgeKijunni,
            RString psmChiku_Kubun, RString psmChiku_Start, RString psmChiku_End, RString psmShikibetsuTaisho) {
        FlexibleDate 宛名抽出年齢開始 = FlexibleDate.EMPTY;
        FlexibleDate 宛名抽出年齢終了 = FlexibleDate.EMPTY;
        boolean has年齢開始 = false;
        boolean has年齢終了 = false;
        boolean is直近 = HizukeChushutsuKubun.直近.getコード().equals(hidukeTyuushutuKubun);
        boolean is基準日 = HizukeChushutsuKubun.範囲.getコード().equals(hidukeTyuushutuKubun);
        boolean is範囲 = HizukeChushutsuKubun.範囲.getコード().equals(hidukeTyuushutuKubun);
        boolean is資格取得日 = KijunbiKubun.資格取得日.getコード().equals(kijunniKubun);
        boolean is資格取得届出日 = KijunbiKubun.資格取得届出日.getコード().equals(kijunniKubun);
        boolean is取得日 = HaniChushutsuKubun.取得日.getコード().equals(rangeChushutsuhiKubun);
        boolean is取得届出日 = HaniChushutsuKubun.取得届出日.getコード().equals(rangeChushutsuhiKubun);
        boolean is喪失日 = HaniChushutsuKubun.喪失日.getコード().equals(rangeChushutsuhiKubun);
        boolean is喪失届出日 = HaniChushutsuKubun.喪失届出日.getコード().equals(rangeChushutsuhiKubun);
        boolean is１号 = CHECK.equals(hiHokenshaJyoho.get(0));
        boolean is２号 = CHECK.equals(hiHokenshaJyoho.get(1));
        boolean is日本人 = CHECK.equals(hiHokenshaJyoho.get(2));
        boolean is外国人 = CHECK.equals(hiHokenshaJyoho.get(INT_3));
        boolean is自特例者 = CHECK.equals(hiHokenshaJyoho.get(INT_4));
        boolean is広域住特 = CHECK.equals(hiHokenshaJyoho.get(INT_5));
        boolean is資格取得者のみ = ShikakuChushutsuKubun.資格取得者のみ.getコード().equals(shikakuChushutsuKubun);
        boolean is資格喪失者のみ = ShikakuChushutsuKubun.資格喪失者のみ.getコード().equals(shikakuChushutsuKubun);
        boolean isEmpty = is基準日 && kijunni != null && !kijunni.isEmpty() && kijunNichijiJukyusha;
        if (!RString.isNullOrEmpty(psmChushutsuAge_Start) && psmAgeKijunni != null && !psmAgeKijunni.isEmpty()) {
            has年齢開始 = true;
            宛名抽出年齢開始 = get宛名抽出年齢開始(psmAgeKijunni, psmChushutsuAge_Start);
        }
        if (!RString.isNullOrEmpty(psmChushutsuAge_End) && psmAgeKijunni != null && !psmAgeKijunni.isEmpty()) {
            has年齢終了 = true;
            宛名抽出年齢終了 = get宛名抽出年齢終了(psmAgeKijunni, psmChushutsuAge_End);
        }
        boolean has生年月日開始 = !RString.isNullOrEmpty(psmSeinengappiYMD_Start);
        boolean has生年月日終了 = !RString.isNullOrEmpty(psmSeinengappiYMD_End);
        boolean is年齢 = 年齢.equals(psmChushutsu_Kubun);
        boolean is生年月日 = 生年月日.equals(psmChushutsu_Kubun);
        boolean is住所 = 住所.equals(psmChiku_Kubun);
        boolean is行政区 = 行政区.equals(psmChiku_Kubun);
        boolean is地区 = 地区.equals(psmChiku_Kubun);
        return new HanyoListHihokenshadaichoMyBatisParameter(
                komukuFukaMeyi, rembanfuka, hidukeHensyu, hidukeTyuushutuKubun, kijunniKubun, kijunni, kijunNichijiJukyusha, rangeChushutsuhiKubun,
                rangeChushutsuhiFrom, rangeChushutsuhiTo, hiHokenshaJyoho, shikakuChushutsuKubun, shutokujiyu, soshitsujiyu, null, null, null,
                null, null, null, null, psmSeinengappiYMD_Start, psmSeinengappiYMD_End, null, null, psmChiku_Start,
                psmChiku_End, is直近, is基準日, is範囲, is資格取得日, is資格取得届出日, is取得日, is取得届出日,
                is喪失日, is喪失届出日, is１号, is２号, is日本人, is外国人, is自特例者, is広域住特,
                is資格取得者のみ, is資格喪失者のみ, isEmpty, 宛名抽出年齢開始, 宛名抽出年齢終了, is年齢, is生年月日,
                has年齢開始, has年齢終了, has生年月日開始, has生年月日終了, is住所, is行政区, is地区, psmShikibetsuTaisho);
    }

    private static FlexibleDate get宛名抽出年齢開始(FlexibleDate psmAgeKijunni, RString psmChushutsuAge_Start) {
        FlexibleDate 基準日 = psmAgeKijunni.minusDay(1);
        return 基準日.minusYear(Integer.valueOf(psmChushutsuAge_Start.toString()));
    }

    private static FlexibleDate get宛名抽出年齢終了(FlexibleDate psmAgeKijunni, RString psmChushutsuAge_End) {
        FlexibleDate 基準日 = psmAgeKijunni.minusDay(1);
        return 基準日.minusYear(Integer.valueOf(psmChushutsuAge_End.toString()));
    }
}
