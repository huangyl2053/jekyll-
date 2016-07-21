/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolistseikatsuhogojukyusha;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.processprm.hanyolistroreifukushinenkinjukyusha.HanyoListRoreiFukushiNenkinJukyushaProcessParameter;
import jp.co.ndensan.reams.db.dba.definition.processprm.hanyolistseikatsuhogojukyusha.SeikatsuhogoJukyushaProcessParameter;
import jp.co.ndensan.reams.db.dba.definition.processprm.hanyolisttashichosonjushochitokureisha.HanyoListTaShichosonJushochiTokureishaProcessParameter;
import jp.co.ndensan.reams.db.dba.definition.processprm.hanyolisttekiyojogaisha.HanyoListTekiyoJogaishaProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 汎用リストバッチのパラメータ。
 *
 * @reamsid_L DBA-1580-030 xuyannan
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class HanyoListBatchParameter extends BatchParameterBase {

    private static final String KEY_CHOHYOID = "chohyoId";
    private static final String KEY_SHUTSURYOKUJUNID = "shutsuryokujunId";
    private static final String KEY_SHUTSURYOKUKOMOKUID = "shutsuryokuKomokuId";
    private static final String KEY_KOMOKUMEIFUKA = "komokumeiFuka";
    private static final String KEY_RENBANFUKA = "renbanFuka";
    private static final String KEY_HITSUKEHENSHU = "hitsukeHenshu";
    private static final String KEY_HITSUKECHUSHUTSUKUBUN = "hitsukeChushutsuKubun";
    private static final String KEY_KIJUNYMD = "kijunYMD";
    private static final String KEY_CHUSHUTSUNICHIKUBUN = "chushutsunichiKubun";
    private static final String KEY_CHUSHUTSUNICHIFROM = "chushutsunichiFrom";
    private static final String KEY_CHUSHUTSUNICHITO = "chushutsunichiTo";
    private static final String KEY_JUKYUSHAJOHO_NIHONJIN = "jukyushaJoho_Nihonjin";
    private static final String KEY_JUKYUSHAJOHO_GAIKOKUJIN = "jukyushaJoho_Gaikokujin";
    private static final String KEY_FUJOSHURUI = "fujoShurui";
    private static final String KEY_KIJUNYMDKUBUN = "kijunYMDkubun";
    private static final String KEY_JYUCHUSYUTSUKUBUN = "jyuChusyutsuKubun";
    private static final String KEY_DEKYUJYU = "dekyujyu";
    private static final String KEY_KAIJYOJYU = "kaijyojyu";
    private static final String KEY_SHISETSUHENKOARI = "shisetsuHenkoari";
    private static final String KEY_SHISETSUHENKONASHI = "shisetsuHenkonashi";
    private static final String PSMCHUSHUTSU_KUBUN = "psmChushutsu_Kubun";
    private static final String PSMCHUSHUTSUAGE_START = "psmChushutsuAge_Start";
    private static final String PSMCHUSHUTSUAGE_END = "psmChushutsuAge_End";
    private static final String PSMSEINENGAPPIYMD_START = "psmSeinengappiYMD_Start";
    private static final String PSMSEINENGAPPIYMD_END = "psmSeinengappiYMD_End";
    private static final String PSMAGEKIJUNNI = "psmAgeKijunni";
    private static final String SHICHOSON_CODE = "shichoson_Code";
    private static final String SHICHOSON_NAME = "shichoson_Name";
    private static final String PSMCHIKU_KUBUN = "psmChiku_Kubun";
    private static final String PSMJUSHO_FROM = "psmJusho_From";
    private static final String PSMJUSHO_TO = "psmJusho_To";
    private static final String PSMJUSHO_FROM_NAME = "psmJusho_From_Name";
    private static final String PSMJUSHO_TO_NAME = "psmJusho_To_Name";
    private static final String PSMGYOSEIKU_FROM = "psmGyoseiku_From";
    private static final String PSMGYOSEIKU_TO = "psmGyoseiku_To";
    private static final String PSMGYOSEIKU_FROM_NAME = "psmGyoseiku_From_Name";
    private static final String PSMGYOSEIKU_TO_NAME = "psmGyoseiku_To_Name";
    private static final String PSMCHIKU1_FROM = "psmChiku1_From";
    private static final String PSMCHIKU1_TO = "psmChiku1_To";
    private static final String PSMCHIKU2_FROM = "psmChiku2_From";
    private static final String PSMCHIKU2_TO = "psmChiku2_To";
    private static final String PSMCHIKU3_FROM = "psmChiku3_From";
    private static final String PSMCHIKU3_TO = "psmChiku3_To";
    private static final String PSMCHIKU1_FROM_NAME = "psmChiku1_From_Name";
    private static final String PSMCHIKU1_TO_NAME = "psmChiku1_To_Name";
    private static final String PSMCHIKU2_FROM_NAME = "psmChiku2_From_Name";
    private static final String PSMCHIKU2_TO_NAME = "psmChiku2_To_Name";
    private static final String PSMCHIKU3_FROM_NAME = "psmChiku3_From_Name";
    private static final String PSMCHIKU3_TO_NAME = "psmChiku3_To_Name";

    @BatchParameter(key = KEY_CHOHYOID, name = "帳票ID")
    private RString chohyoId;
    @BatchParameter(key = KEY_SHUTSURYOKUJUNID, name = "出力順ID")
    private Long shutsuryokujunId;
    @BatchParameter(key = KEY_SHUTSURYOKUKOMOKUID, name = "出力項目ID")
    private RString shutsuryokuKomokuId;
    @BatchParameter(key = KEY_KOMOKUMEIFUKA, name = "項目名付加")
    private boolean komokumeiFuka;
    @BatchParameter(key = KEY_RENBANFUKA, name = "連番付加 ")
    private boolean renbanFuka;
    @BatchParameter(key = KEY_HITSUKEHENSHU, name = "日付編集")
    private boolean hitsukeHenshu;
    @BatchParameter(key = KEY_HITSUKECHUSHUTSUKUBUN, name = "日付抽出区分")
    private RString hitsukeChushutsuKubun;
    @BatchParameter(key = KEY_KIJUNYMD, name = "基準日")
    private RString kijunYMD;
    @BatchParameter(key = KEY_CHUSHUTSUNICHIKUBUN, name = "範囲抽出日区分")
    private RString chushutsunichiKubun;
    @BatchParameter(key = KEY_CHUSHUTSUNICHIFROM, name = "範囲抽出日From")
    private RString chushutsunichiFrom;
    @BatchParameter(key = KEY_CHUSHUTSUNICHITO, name = "範囲抽出日To")
    private RString chushutsunichiTo;
    @BatchParameter(key = KEY_JUKYUSHAJOHO_NIHONJIN, name = "生保受給者情報・日本人")
    private boolean jukyushaJoho_Nihonjin;
    @BatchParameter(key = KEY_JUKYUSHAJOHO_GAIKOKUJIN, name = "生保受給者情報・外国人")
    private boolean jukyushaJoho_Gaikokujin;
    @BatchParameter(key = KEY_FUJOSHURUI, name = "扶助種類")
    private List<RString> fujoShurui;
    @BatchParameter(key = KEY_KIJUNYMDKUBUN, name = "基準日区分")
    private RString kijunYMDkubun;
    @BatchParameter(key = KEY_JYUCHUSYUTSUKUBUN, name = "事由抽出区分")
    private RString jyuChusyutsuKubun;
    @BatchParameter(key = KEY_DEKYUJYU, name = "適用事由")
    private List<RString> dekyujyu;
    @BatchParameter(key = KEY_KAIJYOJYU, name = "解除事由")
    private List<RString> kaijyojyu;
    @BatchParameter(key = KEY_SHISETSUHENKOARI, name = "施設変更あり")
    private boolean shisetsuHenkoari;
    @BatchParameter(key = KEY_SHISETSUHENKONASHI, name = "施設変更なし")
    private boolean shisetsuHenkonashi;
    @BatchParameter(key = PSMCHUSHUTSU_KUBUN, name = "年齢層抽出方法")
    private RString psmChushutsu_Kubun;
    @BatchParameter(key = PSMCHUSHUTSUAGE_START, name = "宛名抽出年齢開始")
    private Decimal psmChushutsuAge_Start;
    @BatchParameter(key = PSMCHUSHUTSUAGE_END, name = "宛名抽出年齢終了")
    private Decimal psmChushutsuAge_End;
    @BatchParameter(key = PSMSEINENGAPPIYMD_START, name = "宛名抽出生年月日開始")
    private RDate psmSeinengappiYMD_Start;
    @BatchParameter(key = PSMSEINENGAPPIYMD_END, name = "宛名抽出生年月日終了")
    private RDate psmSeinengappiYMD_End;
    @BatchParameter(key = PSMAGEKIJUNNI, name = "年齢基準日")
    private RDate psmAgeKijunni;
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
    public HanyoListBatchParameter() {
    }

    /**
     * 汎用リスト 生活保護受給者のパラメータを作成します。
     *
     * @return SeikatsuhogoJukyushaProcessParameter
     */
    public SeikatsuhogoJukyushaProcessParameter toSeikatsuhogoJukyushaProcessParameter() {
        return new SeikatsuhogoJukyushaProcessParameter(
                chohyoId,
                shutsuryokujunId,
                shutsuryokuKomokuId,
                komokumeiFuka,
                renbanFuka,
                hitsukeHenshu,
                hitsukeChushutsuKubun,
                kijunYMD,
                chushutsunichiKubun,
                chushutsunichiFrom,
                chushutsunichiTo,
                jukyushaJoho_Nihonjin,
                jukyushaJoho_Gaikokujin,
                fujoShurui,
                psmChushutsu_Kubun,
                psmChushutsuAge_Start,
                psmChushutsuAge_End,
                psmSeinengappiYMD_Start,
                psmSeinengappiYMD_End,
                psmAgeKijunni,
                shichoson_Code,
                shichoson_Name,
                psmChiku_Kubun,
                psmJusho_From,
                psmJusho_From_Name,
                psmJusho_To,
                psmJusho_To_Name,
                psmGyoseiku_From,
                psmGyoseiku_From_Name,
                psmGyoseiku_To,
                psmGyoseiku_To_Name,
                psmChiku1_From,
                psmChiku1_To,
                psmChiku2_From,
                psmChiku2_To,
                psmChiku3_From,
                psmChiku3_To,
                psmChiku1_From_Name,
                psmChiku1_To_Name,
                psmChiku2_From_Name,
                psmChiku2_To_Name,
                psmChiku3_From_Name,
                psmChiku3_To_Name);
    }

    /**
     * 汎用リスト 適用除外者のパラメータを作成します。
     *
     * @return HanyoListTekiyoKaishaProcessParameter
     */
    public HanyoListTekiyoJogaishaProcessParameter toHanyoListTekiyoKaishaProcessParameter() {
        return new HanyoListTekiyoJogaishaProcessParameter(
                chohyoId,
                shutsuryokujunId,
                shutsuryokuKomokuId,
                komokumeiFuka,
                renbanFuka,
                hitsukeHenshu,
                hitsukeChushutsuKubun,
                kijunYMD,
                chushutsunichiKubun,
                chushutsunichiFrom,
                chushutsunichiTo,
                jukyushaJoho_Nihonjin,
                jukyushaJoho_Gaikokujin,
                kijunYMDkubun,
                jyuChusyutsuKubun,
                dekyujyu,
                kaijyojyu,
                shisetsuHenkoari,
                shisetsuHenkonashi,
                psmChushutsu_Kubun,
                psmChushutsuAge_Start,
                psmChushutsuAge_End,
                psmSeinengappiYMD_Start,
                psmSeinengappiYMD_End,
                psmAgeKijunni,
                shichoson_Code,
                shichoson_Name,
                psmChiku_Kubun,
                psmJusho_From,
                psmJusho_From_Name,
                psmJusho_To,
                psmJusho_To_Name,
                psmGyoseiku_From,
                psmGyoseiku_From_Name,
                psmGyoseiku_To,
                psmGyoseiku_To_Name,
                psmChiku1_From,
                psmChiku1_To,
                psmChiku2_From,
                psmChiku2_To,
                psmChiku3_From,
                psmChiku3_To,
                psmChiku1_From_Name,
                psmChiku1_To_Name,
                psmChiku2_From_Name,
                psmChiku2_To_Name,
                psmChiku3_From_Name,
                psmChiku3_To_Name);
    }

    /**
     * 汎用リスト 他市町村住所地特例者のパラメータを作成します。
     *
     * @return HanyoListTaShichosonJushochiTokureishaProcessParameter
     */
    public HanyoListTaShichosonJushochiTokureishaProcessParameter toHanyoListTaShichosonJushochiTokureishaProcessParameter() {
        return new HanyoListTaShichosonJushochiTokureishaProcessParameter(
                chohyoId,
                shutsuryokujunId,
                shutsuryokuKomokuId,
                komokumeiFuka,
                renbanFuka,
                hitsukeHenshu,
                hitsukeChushutsuKubun,
                kijunYMD,
                chushutsunichiKubun,
                chushutsunichiFrom,
                chushutsunichiTo,
                jukyushaJoho_Nihonjin,
                jukyushaJoho_Gaikokujin,
                kijunYMDkubun,
                jyuChusyutsuKubun,
                dekyujyu,
                kaijyojyu,
                shisetsuHenkoari,
                shisetsuHenkonashi,
                psmChushutsu_Kubun,
                psmChushutsuAge_Start,
                psmChushutsuAge_End,
                psmSeinengappiYMD_Start,
                psmSeinengappiYMD_End,
                psmAgeKijunni,
                shichoson_Code,
                shichoson_Name,
                psmChiku_Kubun,
                psmJusho_From,
                psmJusho_From_Name,
                psmJusho_To,
                psmJusho_To_Name,
                psmGyoseiku_From,
                psmGyoseiku_From_Name,
                psmGyoseiku_To,
                psmGyoseiku_To_Name,
                psmChiku1_From,
                psmChiku1_To,
                psmChiku2_From,
                psmChiku2_To,
                psmChiku3_From,
                psmChiku3_To,
                psmChiku1_From_Name,
                psmChiku1_To_Name,
                psmChiku2_From_Name,
                psmChiku2_To_Name,
                psmChiku3_From_Name,
                psmChiku3_To_Name);
    }

    /**
     * 汎用リスト 老齢福祉年金受給者のパラメータを作成します。
     *
     * @return HanyoListRoreiFukushiNenkinJukyushaProcessParameter
     */
    public HanyoListRoreiFukushiNenkinJukyushaProcessParameter toHanyoListRoreiFukushiNenkinJukyushaProcessParameter() {
        return new HanyoListRoreiFukushiNenkinJukyushaProcessParameter(
                chohyoId,
                shutsuryokujunId,
                shutsuryokuKomokuId,
                komokumeiFuka,
                renbanFuka,
                hitsukeHenshu,
                hitsukeChushutsuKubun,
                kijunYMD,
                chushutsunichiKubun,
                chushutsunichiFrom,
                chushutsunichiTo,
                psmChushutsu_Kubun,
                psmChushutsuAge_Start,
                psmChushutsuAge_End,
                psmSeinengappiYMD_Start,
                psmSeinengappiYMD_End,
                psmAgeKijunni,
                shichoson_Code,
                shichoson_Name,
                psmChiku_Kubun,
                psmJusho_From,
                psmJusho_From_Name,
                psmJusho_To,
                psmJusho_To_Name,
                psmGyoseiku_From,
                psmGyoseiku_From_Name,
                psmGyoseiku_To,
                psmGyoseiku_To_Name,
                psmChiku1_From,
                psmChiku1_To,
                psmChiku2_From,
                psmChiku2_To,
                psmChiku3_From,
                psmChiku3_To,
                psmChiku1_From_Name,
                psmChiku1_To_Name,
                psmChiku2_From_Name,
                psmChiku2_To_Name,
                psmChiku3_From_Name,
                psmChiku3_To_Name);
    }
}
