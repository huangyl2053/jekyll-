/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatisprm.hanyolisthihokenshadaicho;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.hihokenshadaicho.HaniChushutsuKubun;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.hihokenshadaicho.HihokenshaJoho;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.common.HizukeChushutsuKubun;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.hihokenshadaicho.KijunbiKubun;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.hihokenshadaicho.ShikakuChushutsuKubun;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.Chiku;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.NenreiSoChushutsuHoho;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト_被保険者台帳_マッパー用のパラメータです。
 *
 * @reamsid_L DBA-1610-030 lishengli
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class HanyoListHihokenshadaichoMyBatisParameter implements IMyBatisParameter {

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
    private final RString psmChushutsu_Kubun;
    private final RString psmChushutsuAge_Start;
    private final RString psmChushutsuAge_End;
    private final RString psmSeinengappiYMD_Start;
    private final RString psmSeinengappiYMD_End;
    private final FlexibleDate psmAgeKijunni;
    private final RString shichoson_Code;
    private final RString shichoson_Name;
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
    private final RString psmJusho_From_Name;
    private final RString psmJusho_To_Name;
    private final RString psmGyoseiku_From_Name;
    private final RString psmGyoseiku_To_Name;
    private final RString psmChiku1_From_Name;
    private final RString psmChiku1_To_Name;
    private final RString psmChiku2_From_Name;
    private final RString psmChiku2_To_Name;
    private final RString psmChiku3_From_Name;
    private final RString psmChiku3_To_Name;
    private final RString psmShikibetsuTaisho;
    private final RString psmAtesaki;
    private final boolean is直近;
    private final boolean is基準日;
    private final boolean is範囲;
    private final boolean is資格取得日;
    private final boolean is資格取得届出日;
    private final boolean is取得日;
    private final boolean is取得届出日;
    private final boolean is喪失日;
    private final boolean is喪失届出日;
    private final boolean is1号;
    private final boolean is2号;
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
    private final boolean has取得事由;
    private final boolean has喪失事由;

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
     * @param psmJusho_To 町域To
     * @param psmGyoseiku_From 行政区From
     * @param psmGyoseiku_To 行政区To
     * @param psmChiku1_From 地区１From
     * @param psmChiku1_To 地区１To
     * @param psmChiku2_From 地区２From
     * @param psmChiku2_To 地区２To
     * @param psmChiku3_From 地区３From
     * @param psmChiku3_To 地区３To
     * @param psmJusho_From_Name 町域From名称
     * @param psmJusho_To_Name 町域To名称
     * @param psmGyoseiku_From_Name 行政区From名称
     * @param psmGyoseiku_To_Name 行政区To名称
     * @param psmChiku1_From_Name 地区１From名称
     * @param psmChiku1_To_Name 地区１To名称
     * @param psmChiku2_From_Name 地区２From名称
     * @param psmChiku2_To_Name 地区２To名称
     * @param psmChiku3_From_Name 地区３From名称
     * @param psmChiku3_To_Name 地区３To名称
     * @param is直近 is直近
     * @param is基準日 is基準日
     * @param is範囲 is範囲
     * @param is資格取得日 is資格取得日
     * @param is資格取得届出日 is資格取得届出日
     * @param is取得日 is取得日
     * @param is取得届出日 is取得届出日
     * @param is喪失日 is喪失日
     * @param is喪失届出日 is喪失届出日
     * @param is1号 is1号
     * @param is2号 is2号
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
     * @param has受給者台帳 has受給者台帳
     * @param has取得事由 has取得事由
     * @param has喪失事由 has喪失事由
     * @param psmShikibetsuTaisho psmShikibetsuTaisho
     * @param psmAtesaki psmAtesaki
     */
    private HanyoListHihokenshadaichoMyBatisParameter(
            boolean komukuFukaMeyi, boolean rembanfuka, boolean hidukeHensyu, RString hidukeTyuushutuKubun, RString kijunniKubun,
            FlexibleDate kijunni, boolean kijunNichijiJukyusha, RString rangeChushutsuhiKubun, FlexibleDate rangeChushutsuhiFrom,
            FlexibleDate rangeChushutsuhiTo, List<RString> hiHokenshaJyoho, RString shikakuChushutsuKubun, List<RString> shutokujiyu,
            List<RString> soshitsujiyu, RString psmChushutsu_Kubun, RString psmChushutsuAge_Start, RString psmChushutsuAge_End,
            RString psmSeinengappiYMD_Start, RString psmSeinengappiYMD_End, FlexibleDate psmAgeKijunni, RString shichoson_Code,
            RString shichoson_Name,
            RString psmChiku_Kubun, RString psmJusho_From, RString psmJusho_To, RString psmGyoseiku_From,
            RString psmGyoseiku_To,
            RString psmChiku1_From, RString psmChiku1_To,
            RString psmChiku2_From, RString psmChiku2_To, RString psmChiku3_From, RString psmChiku3_To,
            RString psmJusho_From_Name, RString psmJusho_To_Name, RString psmGyoseiku_From_Name,
            RString psmGyoseiku_To_Name, RString psmChiku1_From_Name, RString psmChiku1_To_Name,
            RString psmChiku2_From_Name, RString psmChiku2_To_Name, RString psmChiku3_From_Name, RString psmChiku3_To_Name,
            boolean is直近, boolean is基準日,
            boolean is範囲, boolean is資格取得日, boolean is資格取得届出日, boolean is取得日, boolean is取得届出日, boolean is喪失日,
            boolean is喪失届出日, boolean is1号, boolean is2号, boolean is日本人, boolean is外国人, boolean is自特例者, boolean is広域住特,
            boolean is資格取得者のみ, boolean is資格喪失者のみ, boolean isEmpty, FlexibleDate 宛名抽出年齢開始, FlexibleDate 宛名抽出年齢終了,
            boolean is年齢, boolean is生年月日, boolean is住所, boolean is行政区, boolean is地区, boolean has年齢開始,
            boolean has年齢終了, boolean has生年月日開始, boolean has生年月日終了, boolean has取得事由,
            boolean has喪失事由, RString psmShikibetsuTaisho, RString psmAtesaki) {
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
        this.psmJusho_To = psmJusho_To;
        this.psmGyoseiku_From = psmGyoseiku_From;
        this.psmGyoseiku_To = psmGyoseiku_To;
        this.psmChiku1_From = psmChiku1_From;
        this.psmChiku1_To = psmChiku1_To;
        this.psmChiku2_From = psmChiku2_From;
        this.psmChiku2_To = psmChiku2_To;
        this.psmChiku3_From = psmChiku3_From;
        this.psmChiku3_To = psmChiku3_To;
        this.psmJusho_From_Name = psmJusho_From_Name;
        this.psmJusho_To_Name = psmJusho_To_Name;
        this.psmGyoseiku_From_Name = psmGyoseiku_From_Name;
        this.psmGyoseiku_To_Name = psmGyoseiku_To_Name;
        this.psmChiku1_From_Name = psmChiku1_From_Name;
        this.psmChiku1_To_Name = psmChiku1_To_Name;
        this.psmChiku2_From_Name = psmChiku2_From_Name;
        this.psmChiku2_To_Name = psmChiku2_To_Name;
        this.psmChiku3_From_Name = psmChiku3_From_Name;
        this.psmChiku3_To_Name = psmChiku3_To_Name;
        this.is直近 = is直近;
        this.is基準日 = is基準日;
        this.is範囲 = is範囲;
        this.is資格取得日 = is資格取得日;
        this.is資格取得届出日 = is資格取得届出日;
        this.is取得日 = is取得日;
        this.is取得届出日 = is取得届出日;
        this.is喪失日 = is喪失日;
        this.is喪失届出日 = is喪失届出日;
        this.is1号 = is1号;
        this.is2号 = is2号;
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
        this.has取得事由 = has取得事由;
        this.has喪失事由 = has喪失事由;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
        this.psmAtesaki = psmAtesaki;
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
     * @param shichoson_Code 市町村コード
     * @param shichoson_Name 市町村名称
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
     * @param psmJusho_From_Name 町域From名称
     * @param psmJusho_To_Name 町域To名称
     * @param psmGyoseiku_From_Name 行政区From名称
     * @param psmGyoseiku_To_Name 行政区To名称
     * @param psmChiku1_From_Name 地区１From名称
     * @param psmChiku1_To_Name 地区１To名称
     * @param psmChiku2_From_Name 地区２From名称
     * @param psmChiku2_To_Name 地区２To名称
     * @param psmChiku3_From_Name 地区３From名称
     * @param psmChiku3_To_Name 地区３To名称
     * @param psmShikibetsuTaisho PSM
     * @param psmAtesaki psmAtesaki
     * @return 汎用リスト_被保険者台帳_マッパー用のパラメータです。
     */
    public static HanyoListHihokenshadaichoMyBatisParameter create_MybatisParameter(
            boolean komukuFukaMeyi, boolean rembanfuka, boolean hidukeHensyu, RString hidukeTyuushutuKubun,
            RString kijunniKubun, FlexibleDate kijunni, boolean kijunNichijiJukyusha, RString rangeChushutsuhiKubun,
            FlexibleDate rangeChushutsuhiFrom, FlexibleDate rangeChushutsuhiTo, List<RString> hiHokenshaJyoho, RString shikakuChushutsuKubun,
            List<RString> shutokujiyu, List<RString> soshitsujiyu, RString psmChushutsu_Kubun, RString psmChushutsuAge_Start,
            RString psmChushutsuAge_End, RString psmSeinengappiYMD_Start, RString psmSeinengappiYMD_End, FlexibleDate psmAgeKijunni,
            RString shichoson_Code, RString shichoson_Name, RString psmChiku_Kubun, RString psmJusho_From, RString psmJusho_To,
            RString psmGyoseiku_From,
            RString psmGyoseiku_To, RString psmChiku1_From, RString psmChiku1_To, RString psmChiku2_From, RString psmChiku2_To,
            RString psmChiku3_From, RString psmChiku3_To, RString psmJusho_From_Name, RString psmJusho_To_Name, RString psmGyoseiku_From_Name,
            RString psmGyoseiku_To_Name, RString psmChiku1_From_Name, RString psmChiku1_To_Name, RString psmChiku2_From_Name,
            RString psmChiku2_To_Name,
            RString psmChiku3_From_Name, RString psmChiku3_To_Name, RString psmShikibetsuTaisho, RString psmAtesaki) {
        FlexibleDate 宛名抽出年齢開始 = FlexibleDate.EMPTY;
        FlexibleDate 宛名抽出年齢終了 = FlexibleDate.EMPTY;
        boolean has年齢開始 = false;
        boolean has年齢終了 = false;
        boolean is1号 = false;
        boolean is2号 = false;
        boolean is日本人 = false;
        boolean is外国人 = false;
        boolean is自特例者 = false;
        boolean is広域住特 = false;
        boolean is直近 = HizukeChushutsuKubun.直近.getコード().equals(hidukeTyuushutuKubun);
        boolean is基準日 = HizukeChushutsuKubun.基準日.getコード().equals(hidukeTyuushutuKubun);
        boolean is範囲 = HizukeChushutsuKubun.範囲.getコード().equals(hidukeTyuushutuKubun);
        boolean is資格取得日 = KijunbiKubun.資格取得日.getコード().equals(kijunniKubun);
        boolean is資格取得届出日 = KijunbiKubun.資格取得届出日.getコード().equals(kijunniKubun);
        boolean is取得日 = HaniChushutsuKubun.取得日.getコード().equals(rangeChushutsuhiKubun);
        boolean is取得届出日 = HaniChushutsuKubun.取得届出日.getコード().equals(rangeChushutsuhiKubun);
        boolean is喪失日 = HaniChushutsuKubun.喪失日.getコード().equals(rangeChushutsuhiKubun);
        boolean is喪失届出日 = HaniChushutsuKubun.喪失届出日.getコード().equals(rangeChushutsuhiKubun);
        for (RString key : hiHokenshaJyoho) {
            if (HihokenshaJoho._１号.getコード().equals(key)) {
                is1号 = true;
            }
            if (HihokenshaJoho._２号.getコード().equals(key)) {
                is2号 = true;
            }
            if (HihokenshaJoho.日本人.getコード().equals(key)) {
                is日本人 = true;
            }
            if (HihokenshaJoho.外国人.getコード().equals(key)) {
                is外国人 = true;
            }
            if (HihokenshaJoho.自住所特例.getコード().equals(key)) {
                is自特例者 = true;
            }
            if (HihokenshaJoho.広域住特者.getコード().equals(key)) {
                is広域住特 = true;
            }
        }
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
        boolean is年齢 = NenreiSoChushutsuHoho.年齢範囲.getコード().equals(psmChushutsu_Kubun);
        boolean is生年月日 = NenreiSoChushutsuHoho.生年月日範囲.getコード().equals(psmChushutsu_Kubun);
        boolean is住所 = Chiku.住所.getコード().equals(psmChiku_Kubun);
        boolean is行政区 = Chiku.行政区.getコード().equals(psmChiku_Kubun);
        boolean is地区 = Chiku.地区.getコード().equals(psmChiku_Kubun);
        boolean has取得事由 = has事由(shutokujiyu);
        boolean has喪失事由 = has事由(soshitsujiyu);
        FlexibleDate 範囲抽出日From = get範囲抽出日From(rangeChushutsuhiFrom);
        FlexibleDate 範囲抽出日To = get範囲抽出日To(rangeChushutsuhiTo);
        return new HanyoListHihokenshadaichoMyBatisParameter(
                komukuFukaMeyi, rembanfuka, hidukeHensyu, hidukeTyuushutuKubun, kijunniKubun, kijunni, kijunNichijiJukyusha, rangeChushutsuhiKubun,
                範囲抽出日From, 範囲抽出日To, hiHokenshaJyoho, shikakuChushutsuKubun, shutokujiyu, soshitsujiyu, psmChushutsu_Kubun,
                psmChushutsuAge_Start, psmChushutsuAge_End, psmSeinengappiYMD_Start, psmSeinengappiYMD_End, psmAgeKijunni, shichoson_Code,
                shichoson_Name, psmChiku_Kubun, psmJusho_From, psmJusho_To, psmGyoseiku_From, psmGyoseiku_To, psmChiku1_From,
                psmChiku1_To,
                psmChiku2_From,
                psmChiku2_To,
                psmChiku3_From, psmChiku3_To,
                psmJusho_From_Name, psmJusho_To_Name, psmGyoseiku_From_Name, psmGyoseiku_To_Name, psmChiku1_From_Name,
                psmChiku1_To_Name,
                psmChiku2_From_Name,
                psmChiku2_To_Name,
                psmChiku3_From_Name,
                psmChiku3_To_Name, is直近, is基準日, is範囲, is資格取得日, is資格取得届出日, is取得日, is取得届出日,
                is喪失日, is喪失届出日, is1号, is2号, is日本人, is外国人, is自特例者, is広域住特,
                is資格取得者のみ, is資格喪失者のみ, isEmpty, 宛名抽出年齢開始, 宛名抽出年齢終了, is年齢, is生年月日, is住所, is行政区, is地区,
                has年齢開始, has年齢終了, has生年月日開始, has生年月日終了, has取得事由, has喪失事由, psmShikibetsuTaisho, psmAtesaki);
    }

    private static FlexibleDate get範囲抽出日From(FlexibleDate 範囲抽出日From) {
        if (範囲抽出日From == null || 範囲抽出日From.isEmpty()) {
            return FlexibleDate.MIN;
        }
        return 範囲抽出日From;
    }

    private static FlexibleDate get範囲抽出日To(FlexibleDate 範囲抽出日To) {
        if (範囲抽出日To == null || 範囲抽出日To.isEmpty()) {
            return FlexibleDate.MAX;
        }
        return 範囲抽出日To;
    }

    private static boolean has事由(List<RString> 事由) {
        return 事由 != null && !事由.isEmpty();
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
