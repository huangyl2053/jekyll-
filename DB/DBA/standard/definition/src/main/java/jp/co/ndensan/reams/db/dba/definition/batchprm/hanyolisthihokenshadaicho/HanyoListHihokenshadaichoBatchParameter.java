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
    private static final String PSMCHUSHUTSU_JYOUKEN = "psmChushutsuJyouken";
    private static final String SHUTSURYOKUKOMUKU_ID = "shutsuryokuKomuku_Id";
    private static final String PAGESHUTURYOKUJUN_ID = "pageShuturyokujun_Id";
    private static final String CHOHYO_ID = "chohyoId";
    private static final String PSMCHUSHUTSU_KUBUN = "psmChushutsu_Kubun";
    private static final String PSMCHUSHUTSUAGE_START = "psmChushutsuAge_Start";
    private static final String PSMCHUSHUTSUAGE_END = "psmChushutsuAge_End";
    private static final String PSMSEINENGAPPIYMD_START = "psmSeinengappiYMD_Start";
    private static final String PSMSEINENGAPPIYMD_END = "psmSeinengappiYMD_End";
    private static final String PSMAGEKIJUNNI = "psmAgeKijunni";
    private static final String PSMCHIKU_KUBUN = "psmChiku_Kubun";
    private static final String PSMCHIKU_START = "psmChiku_Start";
    private static final String PSMCHIKU_END = "psmChiku_End";

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
    @BatchParameter(key = PSMCHUSHUTSU_JYOUKEN, name = "宛名抽出条件")
    private RString psmChushutsuJyouken;
    @BatchParameter(key = PAGESHUTURYOKUJUN_ID, name = "改頁出力順ID")
    private RString pageShuturyokujun_Id;
    @BatchParameter(key = SHUTSURYOKUKOMUKU_ID, name = "出力項目ID")
    private RString shutsuryokuKomuku_Id;
    @BatchParameter(key = CHOHYO_ID, name = "帳票ID")
    private RString chohyoId;
    @BatchParameter(key = PSMCHUSHUTSU_KUBUN, name = "宛名抽出区分")
    private RString psmChushutsu_Kubun;
    @BatchParameter(key = PSMCHUSHUTSUAGE_START, name = "宛名抽出年齢開始")
    private RString psmChushutsuAge_Start;
    @BatchParameter(key = PSMCHUSHUTSUAGE_END, name = "宛名抽出年齢終了")
    private RString psmChushutsuAge_End;
    @BatchParameter(key = PSMSEINENGAPPIYMD_START, name = "宛名抽出生年月日開始")
    private RString psmSeinengappiYMD_Start;
    @BatchParameter(key = PSMSEINENGAPPIYMD_END, name = "宛名抽出生年月日終了")
    private RString psmSeinengappiYMD_End;
    @BatchParameter(key = PSMAGEKIJUNNI, name = "宛名抽出年齢基準日")
    private FlexibleDate psmAgeKijunni;
    @BatchParameter(key = PSMCHIKU_KUBUN, name = "宛名抽出地区区分")
    private RString psmChiku_Kubun;
    @BatchParameter(key = PSMCHIKU_START, name = "宛名抽出地区開始")
    private RString psmChiku_Start;
    @BatchParameter(key = PSMCHIKU_END, name = "宛名抽出地区終了")
    private RString psmChiku_End;

    /**
     * コンストラクタです。
     */
    public HanyoListHihokenshadaichoBatchParameter() {
    }

    /**
     * 被保険者証発行管理簿_バッチ用のパラメータラス作成
     *
     * @return 被保険者証発行管理簿_バッチ用のパラメータラス
     */
    public HanyoListHihokenshadaichoProcessParameter toHanyoListHihokenshadaichoProcessParameter() {
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
                this.psmChushutsuJyouken,
                this.pageShuturyokujun_Id,
                this.shutsuryokuKomuku_Id,
                this.chohyoId,
                this.psmChushutsu_Kubun,
                this.psmChushutsuAge_Start,
                this.psmChushutsuAge_End,
                this.psmSeinengappiYMD_Start,
                this.psmSeinengappiYMD_End,
                this.psmAgeKijunni,
                this.psmChiku_Kubun,
                this.psmChiku_Start,
                this.psmChiku_End);
    }
}
