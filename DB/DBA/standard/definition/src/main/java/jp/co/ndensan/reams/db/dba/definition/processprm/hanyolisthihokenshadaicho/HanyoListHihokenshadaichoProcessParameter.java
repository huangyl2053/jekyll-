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
 *
 * @reamsid_L DBA-1610-030 lishengli
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
    private final RString pageShuturyokujun_Id;
    private final RString shutsuryokuKomuku_Id;
    private final RString chohyoId;
    private final RString psmChushutsu_Kubun;
    private final RString psmChushutsuAge_Start;
    private final RString psmChushutsuAge_End;
    private final RString psmSeinengappiYMD_Start;
    private final RString psmSeinengappiYMD_End;
    private final FlexibleDate psmAgeKijunni;
    private final RString shichoson_Code;
    private final RString psmChiku_Kubun;
    private final RString psmJusho_From;
    private final RString psmJusho_To;
    private final RString psmGyoseiku_From;
    private final RString psmGyoseiku_To;
    private final RString psmChiku1_From;
    private final RString psmChiku1_To;
    private final RString psmChiku2_From;
    private final RString psmChiku2_To;
    private final RString psmChiku3_From;
    private final RString psmChiku3_To;
    private RString psmShikibetsuTaisho;
    private RString psmAtesaki;

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
     * @param pageShuturyokujun_Id 改頁出力順ID
     * @param shutsuryokuKomuku_Id 出力項目ID
     * @param chohyoId 帳票ID
     * @param psmChushutsu_Kubun 宛名抽出区分
     * @param psmChushutsuAge_Start 宛名抽出年齢開始
     * @param psmChushutsuAge_End 宛名抽出年齢終了
     * @param psmSeinengappiYMD_Start 宛名抽出生年月日開始
     * @param psmSeinengappiYMD_End 宛名抽出生年月日終了
     * @param psmAgeKijunni 宛名抽出年齢基準日
     * @param shichoson_Code 市町村コード
     * @param psmChiku_Kubun 宛名抽出地区区分
     * @param psmJusho_From 町域From
     * @param psmJusho_To 町域To
     * @param psmGyoseiku_From 行政区From
     * @param psmGyoseiku_To 行政区To
     * @param psmChiku1_From 地区１From
     * @param psmChiku1_To 地区１To
     * @param psmChiku2_From 地区２From
     * @param psmChiku2_To 地区２To
     * @param psmChiku3_From 地区３From
     * @param psmChiku3_To 地区３To
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
            RString pageShuturyokujun_Id,
            RString shutsuryokuKomuku_Id,
            RString chohyoId,
            RString psmChushutsu_Kubun,
            RString psmChushutsuAge_Start,
            RString psmChushutsuAge_End,
            RString psmSeinengappiYMD_Start,
            RString psmSeinengappiYMD_End,
            FlexibleDate psmAgeKijunni,
            RString shichoson_Code,
            RString psmChiku_Kubun,
            RString psmJusho_From,
            RString psmJusho_To,
            RString psmGyoseiku_From,
            RString psmGyoseiku_To,
            RString psmChiku1_From,
            RString psmChiku1_To,
            RString psmChiku2_From,
            RString psmChiku2_To,
            RString psmChiku3_From,
            RString psmChiku3_To) {
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
        this.pageShuturyokujun_Id = pageShuturyokujun_Id;
        this.shutsuryokuKomuku_Id = shutsuryokuKomuku_Id;
        this.chohyoId = chohyoId;
        this.psmChushutsu_Kubun = psmChushutsu_Kubun;
        this.psmChushutsuAge_Start = psmChushutsuAge_Start;
        this.psmChushutsuAge_End = psmChushutsuAge_End;
        this.psmSeinengappiYMD_Start = psmSeinengappiYMD_Start;
        this.psmSeinengappiYMD_End = psmSeinengappiYMD_End;
        this.psmAgeKijunni = psmAgeKijunni;
        this.shichoson_Code = shichoson_Code;
        this.psmChiku_Kubun = psmChiku_Kubun;
        this.psmJusho_From = psmJusho_From;
        this.psmJusho_To = psmJusho_To;
        this.psmGyoseiku_From = psmGyoseiku_From;
        this.psmGyoseiku_To = psmGyoseiku_To;
        this.psmChiku1_From = psmChiku1_From;
        this.psmChiku1_To = psmChiku1_To;
        this.psmChiku2_From = psmChiku2_From;
        this.psmChiku2_To = psmChiku2_To;
        this.psmChiku3_From = psmChiku3_From;
        this.psmChiku3_To = psmChiku3_To;
    }

    /**
     * 汎用リスト_被保険者台帳バッチ処理パラメータークラス作成。
     *
     * @return 汎用リスト_被保険者台帳バッチ処理パラメータークラス
     */
    public HanyoListHihokenshadaichoMyBatisParameter toMyBatisParameter() {
        return HanyoListHihokenshadaichoMyBatisParameter.create_MybatisParameter(
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
                psmChushutsu_Kubun,
                psmChushutsuAge_Start,
                psmChushutsuAge_End,
                psmSeinengappiYMD_Start,
                psmSeinengappiYMD_End,
                psmAgeKijunni,
                shichoson_Code,
                psmChiku_Kubun,
                psmJusho_From,
                psmJusho_To,
                psmGyoseiku_From,
                psmGyoseiku_To,
                psmChiku1_From,
                psmChiku1_To,
                psmChiku2_From,
                psmChiku2_To,
                psmChiku3_From,
                psmChiku3_To,
                psmShikibetsuTaisho,
                psmAtesaki);
    }
}
