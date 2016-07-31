/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.processprm.hanyolisttashichosonjushochitokureisha;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.hanyolisttashichosonjushochitokureisha.HanyoListTaShichosonJushochiTokureishaMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 汎用リスト_他市町村住所地特例者のProcessクラスのパラメータ。
 *
 * @reamsid_L DBA-1590-030 yaodongsheng
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class HanyoListTaShichosonJushochiTokureishaProcessParameter implements IBatchProcessParameter {

    private RString chohyoId;
    private Long shutsuryokujunId;
    private RString shutsuryokuKomokuId;
    private boolean komokumeiFuka;
    private boolean renbanFuka;
    private boolean hitsukeHenshu;
    private RString hitsukeChushutsuKubun;
    private RString kijunYMD;
    private RString chushutsunichiKubun;
    private RString chushutsunichiFrom;
    private RString chushutsunichiTo;
    private boolean jukyushaJoho_Nihonjin;
    private boolean jukyushaJoho_Gaikokujin;
    private RString kijunYMDkubun;
    private RString jyuChusyutsuKubun;
    private List<RString> dekyujyu;
    private List<RString> kaijyojyu;
    private boolean shisetsuHenkoari;
    private boolean shisetsuHenkonashi;
    private RString psmChushutsu_Kubun;
    private Decimal psmChushutsuAge_Start;
    private Decimal psmChushutsuAge_End;
    private RDate psmSeinengappiYMD_Start;
    private RDate psmSeinengappiYMD_End;
    private RDate psmAgeKijunni;
    private RString shichoson_Code;
    private RString shichoson_Name;
    private RString psmChiku_Kubun;
    private RString psmJusho_From;
    private RString psmJusho_From_Name;
    private RString psmJusho_To;
    private RString psmJusho_To_Name;
    private RString psmGyoseiku_From;
    private RString psmGyoseiku_From_Name;
    private RString psmGyoseiku_To;
    private RString psmGyoseiku_To_Name;
    private RString psmChiku1_From;
    private RString psmChiku1_To;
    private RString psmChiku2_From;
    private RString psmChiku2_To;
    private RString psmChiku3_From;
    private RString psmChiku3_To;
    private RString psmChiku1_From_Name;
    private RString psmChiku1_To_Name;
    private RString psmChiku2_From_Name;
    private RString psmChiku2_To_Name;
    private RString psmChiku3_From_Name;
    private RString psmChiku3_To_Name;

    /**
     * コンストラクタです。
     *
     * @param chohyoId 帳票ID
     * @param shutsuryokujunId 出力順ID
     * @param shutsuryokuKomokuId 出力項目ID
     * @param komokumeiFuka 項目名付加
     * @param renbanFuka 連番付加
     * @param hitsukeHenshu 日付編集
     * @param hitsukeChushutsuKubun 日付抽出区分
     * @param kijunYMD 基準日
     * @param chushutsunichiKubun 範囲抽出日区分
     * @param chushutsunichiFrom 範囲抽出日From
     * @param chushutsunichiTo 範囲抽出日To
     * @param jukyushaJoho_Nihonjin 他特例者情報・日本人
     * @param jukyushaJoho_Gaikokujin 他特例者情報・外国人
     * @param kijunYMDkubun 基準日区分
     * @param jyuChusyutsuKubun 事由抽出区分
     * @param dekyujyu 適用事由
     * @param kaijyojyu 解除事由
     * @param shisetsuHenkoari 施設変更あり
     * @param shisetsuHenkonashi 施設変更なし
     * @param psmChushutsu_Kubun 年齢層抽出方法
     * @param psmChushutsuAge_Start 宛名抽出年齢開始
     * @param psmChushutsuAge_End 宛名抽出年齢終了
     * @param psmSeinengappiYMD_Start 宛名抽出生年月日開始
     * @param psmSeinengappiYMD_End 宛名抽出生年月日終了
     * @param psmAgeKijunni 年齢基準日
     * @param shichoson_Code 市町村コード
     * @param shichoson_Name 市町村名称
     * @param psmChiku_Kubun 地区区分
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
    public HanyoListTaShichosonJushochiTokureishaProcessParameter(
            RString chohyoId,
            Long shutsuryokujunId,
            RString shutsuryokuKomokuId,
            boolean komokumeiFuka,
            boolean renbanFuka,
            boolean hitsukeHenshu,
            RString hitsukeChushutsuKubun,
            RString kijunYMD,
            RString chushutsunichiKubun,
            RString chushutsunichiFrom,
            RString chushutsunichiTo,
            boolean jukyushaJoho_Nihonjin,
            boolean jukyushaJoho_Gaikokujin,
            RString kijunYMDkubun,
            RString jyuChusyutsuKubun,
            List<RString> dekyujyu,
            List<RString> kaijyojyu,
            boolean shisetsuHenkoari,
            boolean shisetsuHenkonashi,
            RString psmChushutsu_Kubun,
            Decimal psmChushutsuAge_Start,
            Decimal psmChushutsuAge_End,
            RDate psmSeinengappiYMD_Start,
            RDate psmSeinengappiYMD_End,
            RDate psmAgeKijunni,
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
        this.chohyoId = chohyoId;
        this.shutsuryokujunId = shutsuryokujunId;
        this.shutsuryokuKomokuId = shutsuryokuKomokuId;
        this.komokumeiFuka = komokumeiFuka;
        this.renbanFuka = renbanFuka;
        this.hitsukeHenshu = hitsukeHenshu;
        this.hitsukeChushutsuKubun = hitsukeChushutsuKubun;
        this.kijunYMD = kijunYMD;
        this.chushutsunichiKubun = chushutsunichiKubun;
        this.chushutsunichiFrom = chushutsunichiFrom;
        this.chushutsunichiTo = chushutsunichiTo;
        this.jukyushaJoho_Nihonjin = jukyushaJoho_Nihonjin;
        this.jukyushaJoho_Gaikokujin = jukyushaJoho_Gaikokujin;
        this.kijunYMDkubun = kijunYMDkubun;
        this.jyuChusyutsuKubun = jyuChusyutsuKubun;
        this.dekyujyu = dekyujyu;
        this.kaijyojyu = kaijyojyu;
        this.shisetsuHenkoari = shisetsuHenkoari;
        this.shisetsuHenkonashi = shisetsuHenkonashi;
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
     * Mybatisのパラメータを作成します。
     *
     * @param psmShikibetsuTaisho 宛名識別対象抽出PSM
     * @param psmAtesaki 宛先抽出PSM
     * @return HanyoListTaShichosonJushochiTokureishaMybatisParameter
     */
    public HanyoListTaShichosonJushochiTokureishaMybatisParameter
            toHanyoListTaShichosonJushochiTokureishaMybatisParameter(RString psmShikibetsuTaisho, RString psmAtesaki) {
        return HanyoListTaShichosonJushochiTokureishaMybatisParameter.creatParameter(
                psmChushutsuAge_Start,
                psmChushutsuAge_End,
                psmSeinengappiYMD_Start,
                psmSeinengappiYMD_End,
                psmAgeKijunni,
                psmChushutsu_Kubun,
                chushutsunichiKubun,
                kijunYMDkubun,
                kijunYMD,
                chushutsunichiKubun,
                chushutsunichiFrom,
                chushutsunichiTo,
                jyuChusyutsuKubun,
                dekyujyu,
                kaijyojyu,
                shisetsuHenkoari,
                shisetsuHenkonashi,
                psmShikibetsuTaisho,
                psmAtesaki);
    }
}
