/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolisthihokenshadaicho;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.processprm.hanyolisthihokenshadaicho.HanyoListHihokenshadaichoProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 汎用リスト_被保険者台帳_バッチ用のパラメータです。
 *
 * @reamsid_L DBA-1610-030 lishengli
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListHihokenshadaichoBatchParameter extends BatchParameterBase {

    private static final String KOMUKUFUKAMEYI = "komukuFukaMeyi";
    private static final String REMBANFUKA = "rembanfuka";
    private static final String HIDUKEHENSYU = "hidukeHensyu";
    private static final String HIDUKETYUUSHUTUKUBUN = "hidukeTyuushutuKubun";
    private static final String KIJUNNIKUBUN = "kijunniKubun";
    private static final String KIJUNNI = "kijunni";
    private static final String KIJUNNICHIJI_JUKYUSHA = "kijunNichijiJukyusha";
    private static final String RANGECHUSHUTSUHI_KUBUN = "rangeChushutsuhiKubun";
    private static final String RANGECHUSHUTSUHI_FROM = "rangeChushutsuhiFrom";
    private static final String RANGECHUSHUTSUHI_TO = "rangeChushutsuhiTo";
    private static final String HIHOKENSHA_JYOHO = "hiHokenshaJyoho";
    private static final String SHIKAKUCHUSHUTSU_KUBUN = "shikakuChushutsuKubun";
    private static final String SHUTOKUJIYU = "shutokujiyu";
    private static final String SOSHITSUJIYU = "soshitsujiyu";
    private static final String SHUTSURYOKUKOMUKU_ID = "shutsuryokuKomuku_Id";
    private static final String PAGESHUTURYOKUJUN_ID = "pageShuturyokujun_Id";
    private static final String CHOHYO_ID = "chohyoId";
    private static final String PSMCHUSHUTSU_KUBUN = "psmChushutsu_Kubun";
    private static final String PSMCHUSHUTSUAGE_START = "psmChushutsuAge_Start";
    private static final String PSMCHUSHUTSUAGE_END = "psmChushutsuAge_End";
    private static final String PSMSEINENGAPPIYMD_START = "psmSeinengappiYMD_Start";
    private static final String PSMSEINENGAPPIYMD_END = "psmSeinengappiYMD_End";
    private static final String PSMAGEKIJUNNI = "psmAgeKijunni";
    private static final String SHICHOSON_CODE = "shichoson_Code";
    private static final String PSMCHIKU_KUBUN = "psmChiku_Kubun";
    private static final String PSMJUSHO_FROM = "psmJusho_From";
    private static final String PSMJUSHO_TO = "psmJusho_To";
    private static final String PSMGYOSEIKU_FROM = "psmGyoseiku_From";
    private static final String PSMGYOSEIKU_TO = "psmGyoseiku_To";
    private static final String PSMCHIKU1_FROM = "psmChiku1_From";
    private static final String PSMCHIKU1_TO = "psmChiku1_To";
    private static final String PSMCHIKU2_FROM = "psmChiku2_From";
    private static final String PSMCHIKU2_TO = "psmChiku2_To";
    private static final String PSMCHIKU3_FROM = "psmChiku3_From";
    private static final String PSMCHIKU3_TO = "psmChiku3_To";
    private static final String SHICHOSON_NAME = "shichoson_Name";
    private static final String PSMJUSHO_FROM_NAME = "psmJusho_From_Name";
    private static final String PSMJUSHO_TO_NAME = "psmJusho_To_Name";
    private static final String PSMGYOSEIKU_FROM_NAME = "psmGyoseiku_From_Name";
    private static final String PSMGYOSEIKU_TO_NAME = "psmGyoseiku_To_Name";
    private static final String PSMCHIKU1_FROM_NAME = "psmChiku1_From_Name";
    private static final String PSMCHIKU1_TO_NAME = "psmChiku1_To_Name";
    private static final String PSMCHIKU2_FROM_NAME = "psmChiku2_From_Name";
    private static final String PSMCHIKU2_TO_NAME = "psmChiku2_To_Name";
    private static final String PSMCHIKU3_FROM_NAME = "psmChiku3_From_Name";
    private static final String PSMCHIKU3_TO_NAME = "psmChiku3_To_Name";

    @BatchParameter(key = KOMUKUFUKAMEYI, name = "項目名付加")
    private boolean komukuFukaMeyi;
    @BatchParameter(key = REMBANFUKA, name = "連番付加")
    private boolean rembanfuka;
    @BatchParameter(key = HIDUKEHENSYU, name = "日付編集")
    private boolean hidukeHensyu;
    @BatchParameter(key = HIDUKETYUUSHUTUKUBUN, name = "日付抽出区分")
    private RString hidukeTyuushutuKubun;
    @BatchParameter(key = KIJUNNIKUBUN, name = "基準日区分")
    private RString kijunniKubun;
    @BatchParameter(key = KIJUNNI, name = "基準日")
    private FlexibleDate kijunni;
    @BatchParameter(key = KIJUNNICHIJI_JUKYUSHA, name = "基準日時点の受給者を除く")
    private boolean kijunNichijiJukyusha;
    @BatchParameter(key = RANGECHUSHUTSUHI_KUBUN, name = "範囲抽出日区分")
    private RString rangeChushutsuhiKubun;
    @BatchParameter(key = RANGECHUSHUTSUHI_FROM, name = "範囲抽出日From")
    private FlexibleDate rangeChushutsuhiFrom;
    @BatchParameter(key = RANGECHUSHUTSUHI_TO, name = "範囲抽出日To")
    private FlexibleDate rangeChushutsuhiTo;
    @BatchParameter(key = HIHOKENSHA_JYOHO, name = "被保険者情報")
    private List<RString> hiHokenshaJyoho;
    @BatchParameter(key = SHIKAKUCHUSHUTSU_KUBUN, name = "資格抽出区分")
    private RString shikakuChushutsuKubun;
    @BatchParameter(key = SHUTOKUJIYU, name = "取得事由")
    private List<RString> shutokujiyu;
    @BatchParameter(key = SOSHITSUJIYU, name = "喪失事由")
    private List<RString> soshitsujiyu;
    @BatchParameter(key = PAGESHUTURYOKUJUN_ID, name = "改頁出力順ID")
    private RString pageShuturyokujun_Id;
    @BatchParameter(key = SHUTSURYOKUKOMUKU_ID, name = "出力項目ID")
    private RString shutsuryokuKomuku_Id;
    @BatchParameter(key = CHOHYO_ID, name = "帳票ID")
    private RString chohyoId;
    @BatchParameter(key = PSMCHUSHUTSU_KUBUN, name = "年齢層抽出方法")
    private RString psmChushutsu_Kubun;
    @BatchParameter(key = PSMCHUSHUTSUAGE_START, name = "宛名抽出年齢開始")
    private RString psmChushutsuAge_Start;
    @BatchParameter(key = PSMCHUSHUTSUAGE_END, name = "宛名抽出年齢終了")
    private RString psmChushutsuAge_End;
    @BatchParameter(key = PSMSEINENGAPPIYMD_START, name = "宛名抽出生年月日開始")
    private RString psmSeinengappiYMD_Start;
    @BatchParameter(key = PSMSEINENGAPPIYMD_END, name = "宛名抽出生年月日終了")
    private RString psmSeinengappiYMD_End;
    @BatchParameter(key = PSMAGEKIJUNNI, name = "年齢基準日")
    private FlexibleDate psmAgeKijunni;
    @BatchParameter(key = SHICHOSON_CODE, name = "市町村コード")
    private RString shichoson_Code;
    @BatchParameter(key = SHICHOSON_NAME, name = "市町村名称")
    private RString shichoson_Name;
    @BatchParameter(key = PSMCHIKU_KUBUN, name = "地区区分")
    private RString psmChiku_Kubun;
    @BatchParameter(key = PSMJUSHO_FROM, name = "町域From")
    private RString psmJusho_From;
    @BatchParameter(key = PSMJUSHO_FROM_NAME, name = "町域From名称")
    private RString psmJusho_From_Name;
    @BatchParameter(key = PSMJUSHO_TO, name = "町域To")
    private RString psmJusho_To;
    @BatchParameter(key = PSMJUSHO_TO_NAME, name = "町域To名称")
    private RString psmJusho_To_Name;
    @BatchParameter(key = PSMGYOSEIKU_FROM, name = "行政区From")
    private RString psmGyoseiku_From;
    @BatchParameter(key = PSMGYOSEIKU_FROM_NAME, name = "行政区From名称")
    private RString psmGyoseiku_From_Name;
    @BatchParameter(key = PSMGYOSEIKU_TO, name = "行政区To")
    private RString psmGyoseiku_To;
    @BatchParameter(key = PSMGYOSEIKU_TO_NAME, name = "行政区To名称")
    private RString psmGyoseiku_To_Name;
    @BatchParameter(key = PSMCHIKU1_FROM, name = "地区１From")
    private RString psmChiku1_From;
    @BatchParameter(key = PSMCHIKU1_TO, name = "地区１To")
    private RString psmChiku1_To;
    @BatchParameter(key = PSMCHIKU2_FROM, name = "地区２From")
    private RString psmChiku2_From;
    @BatchParameter(key = PSMCHIKU2_TO, name = "地区２To")
    private RString psmChiku2_To;
    @BatchParameter(key = PSMCHIKU3_FROM, name = "地区３From")
    private RString psmChiku3_From;
    @BatchParameter(key = PSMCHIKU3_TO, name = "地区３To")
    private RString psmChiku3_To;
    @BatchParameter(key = PSMCHIKU1_FROM_NAME, name = "地区１From名称")
    private RString psmChiku1_From_Name;
    @BatchParameter(key = PSMCHIKU1_TO_NAME, name = "地区１To名称")
    private RString psmChiku1_To_Name;
    @BatchParameter(key = PSMCHIKU2_FROM_NAME, name = "地区２From名称")
    private RString psmChiku2_From_Name;
    @BatchParameter(key = PSMCHIKU2_TO_NAME, name = "地区２To名称")
    private RString psmChiku2_To_Name;
    @BatchParameter(key = PSMCHIKU3_FROM_NAME, name = "地区３From名称")
    private RString psmChiku3_From_Name;
    @BatchParameter(key = PSMCHIKU3_TO_NAME, name = "地区３To名称")
    private RString psmChiku3_To_Name;

    /**
     * コンストラクタです。
     */
    public HanyoListHihokenshadaichoBatchParameter() {
    }

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
     * @param shichoson_Name 市町村名称
     * @param psmChiku_Kubun 宛名抽出地区区分
     * @param psmJusho_From 町域From
     * @param psmJusho_From_Name 町域From名称
     * @param psmJusho_To 町域To
     * @param psmJusho_To_Name 町域To名称
     * @param psmGyoseiku_From 行政区From
     * @param psmGyoseiku_From_Name 行政区From名称
     * @param psmGyoseiku_To 行政区To
     * @param psmGyoseiku_To_Name 行政区To名称
     * @param psmChiku1_From 地区１From
     * @param psmChiku1_To 地区１To
     * @param psmChiku2_From 地区２From
     * @param psmChiku2_To 地区２To
     * @param psmChiku3_From 地区３From
     * @param psmChiku3_To 地区３To
     * @param psmChiku1_From_Name 地区１From名称
     * @param psmChiku1_To_Name 地区１To名称
     * @param psmChiku2_From_Name 地区２From名称
     * @param psmChiku2_To_Name 地区２To名称
     * @param psmChiku3_From_Name 地区３From名称
     * @param psmChiku3_To_Name 地区３To名称
     */
    public HanyoListHihokenshadaichoBatchParameter(
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
            RString shichoson_Name,
            RString psmChiku_Kubun,
            RString psmJusho_From,
            RString psmJusho_From_Name,
            RString psmJusho_To,
            RString psmJusho_To_Name,
            RString psmGyoseiku_From,
            RString psmGyoseiku_From_Name,
            RString psmGyoseiku_To,
            RString psmGyoseiku_To_Name,
            RString psmChiku1_From,
            RString psmChiku1_To,
            RString psmChiku2_From,
            RString psmChiku2_To,
            RString psmChiku3_From,
            RString psmChiku3_To,
            RString psmChiku1_From_Name,
            RString psmChiku1_To_Name,
            RString psmChiku2_From_Name,
            RString psmChiku2_To_Name,
            RString psmChiku3_From_Name,
            RString psmChiku3_To_Name) {
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
        this.shichoson_Name = shichoson_Name;
        this.psmChiku_Kubun = psmChiku_Kubun;
        this.psmJusho_From = psmJusho_From;
        this.psmJusho_From_Name = psmJusho_From_Name;
        this.psmJusho_To = psmJusho_To;
        this.psmJusho_To_Name = psmJusho_To_Name;
        this.psmGyoseiku_From = psmGyoseiku_From;
        this.psmGyoseiku_From_Name = psmGyoseiku_From_Name;
        this.psmGyoseiku_To = psmGyoseiku_To;
        this.psmGyoseiku_To_Name = psmGyoseiku_To_Name;
        this.psmChiku1_From = psmChiku1_From;
        this.psmChiku1_To = psmChiku1_To;
        this.psmChiku2_From = psmChiku2_From;
        this.psmChiku2_To = psmChiku2_To;
        this.psmChiku3_From = psmChiku3_From;
        this.psmChiku3_To = psmChiku3_To;
        this.psmChiku1_From_Name = psmChiku1_From_Name;
        this.psmChiku1_To_Name = psmChiku1_To_Name;
        this.psmChiku2_From_Name = psmChiku2_From_Name;
        this.psmChiku2_To_Name = psmChiku2_To_Name;
        this.psmChiku3_From_Name = psmChiku3_From_Name;
        this.psmChiku3_To_Name = psmChiku3_To_Name;
    }

    /**
     * 汎用リスト_被保険者台帳_バッチ用のパラメータラス作成
     *
     * @return 汎用リスト_被保険者台帳_バッチ用のパラメータラス
     */
    public HanyoListHihokenshadaichoProcessParameter toHanyoListHihokenshadaichoProcessParameter(long jobId) {
        return new HanyoListHihokenshadaichoProcessParameter(
                this.komukuFukaMeyi,
                this.rembanfuka,
                this.hidukeHensyu,
                this.hidukeTyuushutuKubun,
                this.kijunniKubun,
                this.kijunni,
                this.kijunNichijiJukyusha,
                this.rangeChushutsuhiKubun,
                this.rangeChushutsuhiFrom,
                this.rangeChushutsuhiTo,
                this.hiHokenshaJyoho,
                this.shikakuChushutsuKubun,
                this.shutokujiyu,
                this.soshitsujiyu,
                this.pageShuturyokujun_Id,
                this.shutsuryokuKomuku_Id,
                this.chohyoId,
                this.psmChushutsu_Kubun,
                this.psmChushutsuAge_Start,
                this.psmChushutsuAge_End,
                this.psmSeinengappiYMD_Start,
                this.psmSeinengappiYMD_End,
                this.psmAgeKijunni,
                this.shichoson_Code,
                this.shichoson_Name,
                this.psmChiku_Kubun,
                this.psmJusho_From,
                this.psmJusho_From_Name,
                this.psmJusho_To,
                this.psmJusho_To_Name,
                this.psmGyoseiku_From,
                this.psmGyoseiku_From_Name,
                this.psmGyoseiku_To,
                this.psmGyoseiku_To_Name,
                this.psmChiku1_From,
                this.psmChiku1_To,
                this.psmChiku2_From,
                this.psmChiku2_To,
                this.psmChiku3_From,
                this.psmChiku3_To,
                this.psmChiku1_From_Name,
                this.psmChiku1_To_Name,
                this.psmChiku2_From_Name,
                this.psmChiku2_To_Name,
                this.psmChiku3_From_Name,
                this.psmChiku3_To_Name,
                jobId
        );
    }
}
