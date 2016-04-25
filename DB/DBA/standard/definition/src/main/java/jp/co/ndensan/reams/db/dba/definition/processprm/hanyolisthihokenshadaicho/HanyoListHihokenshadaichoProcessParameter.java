/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.processprm.hanyolisthihokenshadaicho;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatis.param.hanyolisthihokenshadaicho.HanyoListHihokenshadaichoMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト_被保険者台帳バッチ処理パラメータークラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListHihokenshadaichoProcessParameter implements IBatchProcessParameter {

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
    private RString psmShikibetsuTaisho;
    private boolean is直近;
    private boolean is基準日;
    private boolean is範囲;
    private boolean is資格取得日;
    private boolean is資格取得届出日;
    private boolean is取得日;
    private boolean is取得届出日;
    private boolean is喪失日;
    private boolean is喪失届出日;
    private boolean is１号;
    private boolean is２号;
    private boolean is日本人;
    private boolean is外国人;
    private boolean is自特例者;
    private boolean is広域住特;
    private boolean is資格取得者のみ;
    private boolean is資格喪失者のみ;
    private boolean isEmpty;
    private FlexibleDate 宛名抽出年齢開始;
    private FlexibleDate 宛名抽出年齢終了;
    private boolean is年齢;
    private boolean is生年月日;
    private boolean is全て以外;
    private boolean is住所;
    private boolean is行政区;
    private boolean is地区;
    private boolean has年齢開始;
    private boolean has年齢終了;
    private boolean has生年月日開始;
    private boolean has生年月日終了;

    /**
     * 非公開コンストラクタです。
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
     */
    public HanyoListHihokenshadaichoProcessParameter(
            boolean komukuFukaMeyi,
            boolean rembanfuka,
            boolean hidukeHensyu,
            RString hidukeTyuushutuKubun,
            RString kijunniKubun,
            FlexibleDate kijunni,
            boolean kijunNichijiJukyusha,
            RString rangeChushutsuhiKubun,
            FlexibleDate rangeChushutsuhiFrom,
            FlexibleDate rangeChushutsuhiTo,
            List<RString> hiHokenshaJyoho,
            RString shikakuChushutsuKubun,
            List<RString> shutokujiyu,
            List<RString> soshitsujiyu,
            RString psmChushutsuJyouken,
            RString pageShuturyokujun_Id,
            RString shutsuryokuKomuku_Id,
            RString chohyoId,
            RString psmChushutsu_Kubun,
            RString psmChushutsuAge_Start,
            RString psmChushutsuAge_End,
            RString psmSeinengappiYMD_Start,
            RString psmSeinengappiYMD_End,
            FlexibleDate psmAgeKijunni,
            RString psmChiku_Kubun,
            RString psmChiku_Start,
            RString psmChiku_End) {
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
    }

    /**
     * 汎用リスト_被保険者台帳バッチ処理パラメータークラス作成。
     *
     * @return 汎用リスト_被保険者台帳バッチ処理パラメータークラス
     */
    public HanyoListHihokenshadaichoMyBatisParameter toMyBatisParameter() {
        return new HanyoListHihokenshadaichoMyBatisParameter(
                komukuFukaMeyi,
                rembanfuka,
                hidukeHensyu,
                hidukeTyuushutuKubun,
                kijunniKubun,
                kijunni,
                kijunNichijiJukyusha,
                rangeChushutsuhiKubun,
                rangeChushutsuhiFrom,
                rangeChushutsuhiTo,
                hiHokenshaJyoho,
                shikakuChushutsuKubun,
                shutokujiyu,
                soshitsujiyu,
                psmChushutsuJyouken,
                pageShuturyokujun_Id,
                shutsuryokuKomuku_Id,
                chohyoId,
                psmChushutsu_Kubun,
                psmChushutsuAge_Start,
                psmChushutsuAge_End,
                psmSeinengappiYMD_Start,
                psmSeinengappiYMD_End,
                psmAgeKijunni,
                psmChiku_Kubun,
                psmChiku_Start,
                psmChiku_End,
                is直近,
                is基準日,
                is範囲,
                is資格取得日,
                is資格取得届出日,
                is取得日,
                is取得届出日,
                is喪失日,
                is喪失届出日,
                is１号,
                is２号,
                is日本人,
                is外国人,
                is自特例者,
                is広域住特,
                is資格取得者のみ,
                is資格喪失者のみ,
                isEmpty,
                宛名抽出年齢開始,
                宛名抽出年齢終了,
                is年齢,
                is生年月日,
                has年齢開始,
                has年齢終了,
                has生年月日開始,
                has生年月日終了,
                is住所,
                is行政区,
                is地区,
                psmShikibetsuTaisho);
    }
}
