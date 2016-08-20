/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jukyushateiseirenrakuhyo;

import java.util.regex.Pattern;
import jp.co.ndensan.reams.db.dbc.business.core.jukyushaidorenrakuhyotoroku.JukyushaIdoRenrakuhyoTorokuEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.jukyushateiseirenrakuhyo.JukyushaTeiseiRenrakuhyoSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 帳票設計_DBCMN81002_受給者訂正連絡票（紙媒体）Editorクラスです。
 *
 * @reamsid_L DBC-2101-060 lijian
 */
public class JukyushaTeiseiRenrakuhyoEditor implements IJukyushaTeiseiRenrakuhyoEditor {

    private final JukyushaIdoRenrakuhyoTorokuEntity 出力用受給者訂正情報Entity;
    private final RString 市町村名称;
    private static final RString 区分 = new RString("区分");
    private static final RString 支給限度基準額 = new RString("支給限度基準額");
    private static final RString 旧訪問通所 = new RString("旧訪問通所");
    private static final RString 旧短期入所 = new RString("旧短期入所");
    private static final RString 氏名性別生年月日を印字するONE = new RString("1");
    private static final RString 性別コードONE = new RString("1");
    private static final RString 性別コードTWO = new RString("2");
    private static final RString 訂正まる = new RString("○");
    private static final RString 訂正区分コードTWO = new RString("2");
    private static final RString 訂正区分コードTHREE = new RString("3");
    private static final RString 氏名性別生年月日を印字するZERO = new RString("0");

    /**
     * コンストラクタです。
     *
     * @param 出力用受給者訂正情報Entity JukyushaIdoRenrakuhyoTorokuEntity
     * @param 市町村名称 RString
     */
    public JukyushaTeiseiRenrakuhyoEditor(JukyushaIdoRenrakuhyoTorokuEntity 出力用受給者訂正情報Entity, RString 市町村名称) {
        this.出力用受給者訂正情報Entity = 出力用受給者訂正情報Entity;
        this.市町村名称 = 市町村名称;
    }

    @Override
    public JukyushaTeiseiRenrakuhyoSource edit(JukyushaTeiseiRenrakuhyoSource source) {

        set年月日(source);
        source.hokenshaName = 市町村名称;
        source.shoHokenshaNo = 出力用受給者訂正情報Entity.get証記載保険者番号();
        source.hihokenshaNo = 出力用受給者訂正情報Entity.get被保険者番号();
        source.idoJiyu = 出力用受給者訂正情報Entity.get異動事由();
        source.hyodai1_1 = RString.EMPTY;
        source.Hyodai1_2 = 区分;
        source.Hyodai2_1 = 支給限度基準額;
        source.minashiKbn = 出力用受給者訂正情報Entity.getみなし区分();
        source.yoKaigoJotaiKbn = 出力用受給者訂正情報Entity.get要介護状態区分();
        source.kohiFutanJogenGaku = new RString(出力用受給者訂正情報Entity.get公費負担上限額減額().toString());
        source.sikyuGendoKijunGaKu1 = 出力用受給者訂正情報Entity.get支給限度基準額1();
        source.Hyodai2_2 = 旧訪問通所;
        source.Hyodai3_1 = 支給限度基準額;
        source.sikyuGendoKijunGaKu2 = 出力用受給者訂正情報Entity.get支給限度基準額２();
        source.Hyodai3_2 = 旧短期入所;
        source.keikakuSakuseiKbn = 出力用受給者訂正情報Entity.get計画作成区分();
        source.kyotakuShienJigyoshaNO = 出力用受給者訂正情報Entity.get居宅支援事業者番号();
        source.genShinseichuKbn = 出力用受給者訂正情報Entity.get減免申請中区分();
        source.riyoshaFutanKbn = 出力用受給者訂正情報Entity.get利用者負担区分();
        source.riyoKyufuRitsu = 出力用受給者訂正情報Entity.get利用給付率();
        source.ninteiShinseiKbn = 出力用受給者訂正情報Entity.get認定申請中区分();
        source.serviceKbn = 出力用受給者訂正情報Entity.getｻｰﾋﾞｽ区分();
        source.tokuGenTaisho = 出力用受給者訂正情報Entity.get特例減額措置対象();
        source.shokuFutanGendoGaKu = 出力用受給者訂正情報Entity.get食費負担限度額();
        source.unitKoshitsu = 出力用受給者訂正情報Entity.getﾕﾆｯﾄ型個室();
        source.unitJunKoshitsu = 出力用受給者訂正情報Entity.getﾕﾆｯﾄ型準個室();
        source.juraiKoshitsuT = 出力用受給者訂正情報Entity.get従来型個室特();
        source.juraiKishitsuR = 出力用受給者訂正情報Entity.get従来型個室老療();
        source.tashoshitsu = 出力用受給者訂正情報Entity.get多床室();
        source.shin1 = 出力用受給者訂正情報Entity.get新１();
        source.shin2 = 出力用受給者訂正情報Entity.get新２();
        source.Shin3 = 出力用受給者訂正情報Entity.get新３();
        source.koikiHokenshaNO = 出力用受給者訂正情報Entity.get広域保険者番号();
        source.rokenShichosonNo = 出力用受給者訂正情報Entity.get老人保健市町村番号();
        source.rokenJukyushaNO = 出力用受給者訂正情報Entity.get老人保健受給者番号();
        source.shaKyufuritsu = 出力用受給者訂正情報Entity.get軽減率();
        source.ShokiboKyotakuUmu = new RString(出力用受給者訂正情報Entity.get小規模居宅ｻｰﾋﾞｽ利用().toString());
        source.nijiYoboTaishoKbn = 出力用受給者訂正情報Entity.get二次予防事業区分();
        source.shinseiShubetsu = 出力用受給者訂正情報Entity.get申請種別();
        source.henkoShinseiKbn = 出力用受給者訂正情報Entity.get変更申請中区分();
        source.kokuhoHokenshaNo = 出力用受給者訂正情報Entity.get国保保険者番号();
        source.kokuhoHihokenshashoNo = 出力用受給者訂正情報Entity.get国保被保険者証番号();
        source.kokuhoKojinNo = 出力用受給者訂正情報Entity.get国保個人番号();
        source.kokiHokenshaNo = 出力用受給者訂正情報Entity.get後期高齢保険者番号();
        source.kokiHihokenshaNo = 出力用受給者訂正情報Entity.get後期高齢被保険者番号();
        source.jutokuTaishoKbn = 出力用受給者訂正情報Entity.get住特対象者区分();
        source.jutokuHokenshaNo = 出力用受給者訂正情報Entity.get住特施設所在保険者番号();
        if (訂正区分コードTWO.equals(出力用受給者訂正情報Entity.get訂正区分コード())) {
            source.teiseiKbn1 = 訂正まる;
        } else if (訂正区分コードTHREE.equals(出力用受給者訂正情報Entity.get訂正区分コード())) {
            source.teiseiKbn2 = 訂正まる;
        }

        if (氏名性別生年月日を印字するONE.equals(出力用受給者訂正情報Entity.get氏名性別生年月日を印字する())) {
            if (性別コードONE.equals(出力用受給者訂正情報Entity.get性別コード())) {
                source.seibetsu1 = 訂正まる;
            } else if (性別コードTWO.equals(出力用受給者訂正情報Entity.get性別コード())) {
                source.seibetsu2 = 訂正まる;
            }
        }
        return source;

    }

    private void set年月日(JukyushaTeiseiRenrakuhyoSource source) {
        source.sakuseiGG = get年号(出力用受給者訂正情報Entity.get作成年月日());
        source.sakuseiYY = get年(出力用受給者訂正情報Entity.get作成年月日());
        source.sakuseiMM = get月(出力用受給者訂正情報Entity.get作成年月日());
        source.sakuseiDD = get日(出力用受給者訂正情報Entity.get作成年月日());
        source.IdoNengo = get年号(出力用受給者訂正情報Entity.get異動年月日());
        source.IdoYMD = get年月日(出力用受給者訂正情報Entity.get異動年月日());
        source.teiseiNengo = get年号(出力用受給者訂正情報Entity.get訂正年月日());
        source.teiseiYMD = get年月日(出力用受給者訂正情報Entity.get訂正年月日());

        if (氏名性別生年月日を印字するONE.equals(出力用受給者訂正情報Entity.get氏名性別生年月日を印字する())) {
            source.birthGengo = get年号(出力用受給者訂正情報Entity.get生年月日());
            source.hihokenshaNamaKana = 出力用受給者訂正情報Entity.get被保険者氏名カナ();
            source.birthYMD = get年月日(出力用受給者訂正情報Entity.get生年月日());
        } else if (氏名性別生年月日を印字するZERO.equals(出力用受給者訂正情報Entity.get氏名性別生年月日を印字する())) {
            source.birthGengo = RString.EMPTY;
            source.hihokenshaNamaKana = RString.EMPTY;
            source.birthYMD = RString.EMPTY;
        }

        source.shikakuShutokuNengo = get年号(出力用受給者訂正情報Entity.get資格取得年月日());
        source.shikakuShutokuYMD = get年月日(出力用受給者訂正情報Entity.get資格取得年月日());
        source.shikakuSoshitsuNengo = get年号(出力用受給者訂正情報Entity.get資格喪失年月日());
        source.shiSoshitsuYMD = get年月日(出力用受給者訂正情報Entity.get資格喪失年月日());

        source.yukoKikanSTNengo = get年号(出力用受給者訂正情報Entity.get有効期間開始年月日());
        source.yukoKikanSTYMD = get年月日(出力用受給者訂正情報Entity.get有効期間開始年月日());
        source.yukoKikanEDNengo = get年号(出力用受給者訂正情報Entity.get有効期間終了年月日());
        source.yukoKikanEDYMD = get年月日(出力用受給者訂正情報Entity.get有効期間終了年月日());

        source.jogenTekiyoSTNengo1 = get年号(出力用受給者訂正情報Entity.get上限管理適用開始年月日１());
        source.jogenKaTekiyoSTYMD1 = get年月日(出力用受給者訂正情報Entity.get上限管理適用開始年月日１());
        source.jogenTekiyoEDNengo1 = get年号(出力用受給者訂正情報Entity.get上限管理終了年月日１());
        source.jogenTekiyoEDYMD1 = get年月日(出力用受給者訂正情報Entity.get上限管理終了年月日１());

        source.jogenTekiyoSTNengo2 = get年号(出力用受給者訂正情報Entity.get上限管理適用開始年月日２());
        source.jogenKaTekiyoSTYMD2 = get年月日(出力用受給者訂正情報Entity.get上限管理適用開始年月日２());
        source.jogenTekiyoEDNengo2 = get年号(出力用受給者訂正情報Entity.get上限管理終了年月日２());
        source.jogenTekiyoEDYMD2 = get年月日(出力用受給者訂正情報Entity.get上限管理終了年月日２());

        source.kyoTekiyoSTNengo = get年号(出力用受給者訂正情報Entity.get居宅適用開始年月日());
        source.kyoTekiyoSTYMD = get年月日(出力用受給者訂正情報Entity.get居宅適用開始年月日());
        source.kyoTekiyoEDNengo = get年号(出力用受給者訂正情報Entity.get居宅適用終了年月日());
        source.kyoTekiyoEDYMD = get年月日(出力用受給者訂正情報Entity.get居宅適用終了年月日());

        source.riyoTekiyoSTNengo = get年号(出力用受給者訂正情報Entity.get利用適用開始年月日());
        source.riyoTekiyoSTYMD = get年月日(出力用受給者訂正情報Entity.get利用適用開始年月日());
        source.riyoTekiyoEDNengo = get年号(出力用受給者訂正情報Entity.get利用適用終了年月日());
        source.riyoTekiyoEDYMD = get年月日(出力用受給者訂正情報Entity.get利用適用終了年月日());
        source.hyojunFutanKBN = 出力用受給者訂正情報Entity.get標準負担区分();
        source.hyojunFutanGaku = 出力用受給者訂正情報Entity.get標準負担額();
        source.hyojunTekiyoSTNengo = get年号(出力用受給者訂正情報Entity.get標準適用開始年月日());
        source.hyojunTekiyoSTYMD = get年月日(出力用受給者訂正情報Entity.get標準適用開始年月日());
        source.hyojunTekiyoEDNengo = get年号(出力用受給者訂正情報Entity.get標準適用終了年月日());
        source.hyojunTekiyoEDYMD = get年月日(出力用受給者訂正情報Entity.get標準適用終了年月日());
        source.shoTekiyoSTNengo = get年号(出力用受給者訂正情報Entity.get償還払化適用開始年月日());
        source.ShoTekiyoSTYMD = get年月日(出力用受給者訂正情報Entity.get償還払化適用開始年月日());
        source.shoTekiyoEDNengo = get年号(出力用受給者訂正情報Entity.get償還払化適用終了年月日());
        source.shoTekiyoEDYMD = get年月日(出力用受給者訂正情報Entity.get償還払化適用終了年月日());
        source.kyuTekiyoSTNengo = get年号(出力用受給者訂正情報Entity.get給付率引下げ適用開始年月日());
        source.kyuTekiyoSTYMD = get年月日(出力用受給者訂正情報Entity.get給付率引下げ適用開始年月日());
        source.kyuTekiyoEDNengo = get年号(出力用受給者訂正情報Entity.get給付率引下げ適用終了年月日());
        source.kyuTekiyoEDYMD = get年月日(出力用受給者訂正情報Entity.get給付率引下げ適用終了年月日());
        source.tokuTekiyoSTNengo = get年号(出力用受給者訂正情報Entity.get特定入所者適用開始年月日());
        source.tokuTekiyoSTYMD = get年月日(出力用受給者訂正情報Entity.get特定入所者適用開始年月日());
        source.tokuTekiyoEDNengo = get年号(出力用受給者訂正情報Entity.get特定入所者適用終了年月日());
        source.tokuTekiyoEDYMD = get年月日(出力用受給者訂正情報Entity.get特定入所者適用終了年月日());
        source.shaTekiyoSTNengo = get年号(出力用受給者訂正情報Entity.get軽減率適用開始年月日());
        source.shaTekiyoSTYMD = get年月日(出力用受給者訂正情報Entity.get軽減率適用開始年月日());
        source.shaTekiyoEDNengo = get年号(出力用受給者訂正情報Entity.get軽減率適用終了年月日());
        source.shaTekiyoEDYMD = get年月日(出力用受給者訂正情報Entity.get軽減率適用終了年月日());
        source.nijiYoboSTNengo = get年号(出力用受給者訂正情報Entity.get二次予防有効期間開始年月日());
        source.nijiYoboSTYMD = get年月日(出力用受給者訂正情報Entity.get二次予防有効期間開始年月日());
        source.nijiYoboEDNengo = get年号(出力用受給者訂正情報Entity.get二次予防有効期間終了年月日());
        source.nijiYoboEDYMD = get年月日(出力用受給者訂正情報Entity.get二次予防有効期間終了年月日());
        source.shinseiNengo = get年号(出力用受給者訂正情報Entity.get申請年月日());
        source.shinseiYMD = get年月日(出力用受給者訂正情報Entity.get申請年月日());
        source.jutokuTekiyoSTNengo = get年号(出力用受給者訂正情報Entity.get住特適用開始年月日());
        source.jutokuTekiyoSTYMD = get年月日(出力用受給者訂正情報Entity.get住特適用開始年月日());
        source.jutokuTekiyoEDNengo = get年号(出力用受給者訂正情報Entity.get住特適用終了年月日());
        source.jutokuTekiyoEDYMD = get年月日(出力用受給者訂正情報Entity.get住特適用終了年月日());
        source.niFuTekiyoSTNengo = get年号(出力用受給者訂正情報Entity.get二割負担適用開始年月日());
        source.niFuTekiyoSTYMD = get年月日(出力用受給者訂正情報Entity.get二割負担適用開始年月日());
        source.niFuTekiyoEDNengo = get年号(出力用受給者訂正情報Entity.get二割負担適用終了年月日());
        source.niFuTekiyoEDYMD = get年月日(出力用受給者訂正情報Entity.get二割負担適用終了年月日());

    }

    private RString get年号(FlexibleDate date) {
        if (date != null) {
            RString 年号 = date.wareki().eraType(EraType.KANJI).
                    firstYear(FirstYear.ICHI_NEN).separator(Separator.PERIOD).fillType(FillType.ZERO).getEra();
            return 年号;
        } else {
            return RString.EMPTY;
        }
    }

    private RString get年(FlexibleDate date) {
        if (date != null) {
            RString 年号 = date.wareki().eraType(EraType.KANJI).
                    firstYear(FirstYear.ICHI_NEN).separator(Separator.PERIOD).fillType(FillType.ZERO).getYear();
            RString 年 = new RString(Pattern.compile(new RString("[^0-9]").toString()).matcher(年号).replaceAll("").trim());
            return 年;
        } else {
            return RString.EMPTY;
        }
    }

    private RString get月(FlexibleDate date) {
        if (date != null) {
            RString 月 = date.wareki().eraType(EraType.KANJI).
                    firstYear(FirstYear.ICHI_NEN).separator(Separator.PERIOD).fillType(FillType.ZERO).getMonth();
            return 月;
        } else {
            return RString.EMPTY;
        }
    }

    private RString get日(FlexibleDate date) {
        if (date != null) {
            RString 日 = date.wareki().eraType(EraType.KANJI).
                    firstYear(FirstYear.ICHI_NEN).separator(Separator.PERIOD).fillType(FillType.ZERO).getDay();
            return 日;
        } else {
            return RString.EMPTY;
        }
    }

    private RString get年月日(FlexibleDate date) {
        if (date != null) {
            RString 年号 = date.wareki().eraType(EraType.KANJI).
                    firstYear(FirstYear.ICHI_NEN).separator(Separator.PERIOD).fillType(FillType.ZERO).getYear();
            RString 年 = new RString(Pattern.compile(new RString("[^0-9]").toString()).matcher(年号).replaceAll("").trim());
            RString 月 = date.wareki().eraType(EraType.KANJI).
                    firstYear(FirstYear.ICHI_NEN).separator(Separator.PERIOD).fillType(FillType.ZERO).getMonth();
            RString 日 = date.wareki().eraType(EraType.KANJI).
                    firstYear(FirstYear.ICHI_NEN).separator(Separator.PERIOD).fillType(FillType.ZERO).getDay();
            RString 年月日 = new RString(new StringBuilder(年).append(月).append(日).toString());
            return 年月日;
        } else {
            return RString.EMPTY;
        }

    }

}
