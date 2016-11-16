/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jukyushaidorenrakuhyo;

import jp.co.ndensan.reams.db.dbc.business.core.jukyushaidorenrakuhyotoroku.JukyushaIdoRenrakuhyoTorokuEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.jukyushaidorenrakuhyo.JukyushaIdoRenrakuhyoSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 帳票設計_DBCMN81001_受給者異動連絡票（紙媒体) Editor
 *
 * @reamsid_L DBC-2100-040 jiangzongyue
 */
public class JukyushaIdoRenrakuhyoEditor implements IJukyushaIdoRenrakuhyoEditor {

    private final JukyushaIdoRenrakuhyoTorokuEntity entity;
    private final RString 市町村名称;
    private static final RString 旧短期入所 = new RString("(旧短期入所)");
    private static final RString 支給限度基準額 = new RString("支給限度基準額");
    private static final RString 旧訪問通所 = new RString("(旧訪問通所)");
    private static final RString 区分 = new RString("区分");
    private static final RString BLANK = new RString(" ");
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");
    private static final RString THREE = new RString("3");
    private static final RString CIRCLE = new RString("○");
    private static final RString DOT = new RString(".");
    private static final int THREEE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int SIX = 6;
    private static final int TWENTYFIVE = 25;
    private static final RString 半角アスタリスク = new RString("*");
    private static final RString 半角アスタリスクTHREE = new RString("***");
    private static final RString 半角アスタリスクFOUR = new RString("****");
    private static final RString 半角アスタリスクFIVE = new RString("*****");
    private static final RString 半角アスタリスクSIX = new RString("******");
    private static final RString 半角アスタリスクEIGHT = new RString("********");
    private static final RString 半角アスタリスクTEN = new RString("**********");
    private static final RString 半角アスタリスクTWENTY = new RString("********************");

    /**
     * コンストラクタです
     *
     * @param entity JukyushaIdoRenrakuhyoTorokuEntity
     * @param 市町村名称 RString
     */
    public JukyushaIdoRenrakuhyoEditor(
            JukyushaIdoRenrakuhyoTorokuEntity entity,
            RString 市町村名称
    ) {
        this.entity = entity;
        this.市町村名称 = 市町村名称;
    }

    /**
     * 帳票設計_DBCMN81001_受給者異動連絡票（紙媒体)の項目編集です
     *
     * @param source JukyushaIdoRenrakuhyoSource
     * @return JukyushaIdoRenrakuhyoSource
     */
    @Override
    public JukyushaIdoRenrakuhyoSource edit(JukyushaIdoRenrakuhyoSource source) {
        if (entity != null) {
            source.sakuseiGG = commonEra(entity.get作成年月日());
            if (entity.get作成年月日() != null) {
                source.sakuseiYY = entity.get作成年月日().wareki()
                        .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                        .separator(Separator.NONE).fillType(FillType.ZERO).getYear();
                source.sakuseiMM = entity.get作成年月日().wareki()
                        .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                        .separator(Separator.NONE).fillType(FillType.ZERO).getMonth();
                source.sakuseiDD = entity.get作成年月日().wareki()
                        .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                        .separator(Separator.NONE).fillType(FillType.ZERO).getDay();
            }
            source.hokenshaName = 市町村名称;
            source.shoHokenshaNo = entity.get証記載保険者番号();
            source.hihokenshaNo = entity.get被保険者番号();
            source.idoNengo = commonEra(entity.get異動年月日());
            source.idoYMD = commonYMD(entity.get異動年月日());
            if (ONE.equals(entity.get異動区分())) {
                source.idoKbn1 = CIRCLE;
            } else if (TWO.equals(entity.get異動区分())) {
                source.idoKbn2 = CIRCLE;
            } else if (THREE.equals(entity.get異動区分())) {
                source.idoKbn3 = CIRCLE;
            }
            source.idoJiyu = entity.get異動事由();
            if (ONE.equals(entity.get氏名性別生年月日を印字する())) {
                source.seibetsu1 = 性別男の場合();
                source.seibetsu2 = 性別女の場合();
                source.birthGengo = commonEra(entity.get生年月日());
                source.birthYMD = commonYMD(entity.get生年月日());
                source.hihokenshaNamaKana = entity.get被保険者氏名カナ()
                        .padRight(RString.HALF_SPACE, TWENTYFIVE);
            } else {
                source.birthGengo = BLANK;
                source.birthYMD = BLANK;
                source.hihokenshaNamaKana = BLANK;
            }
            source.shikakuShutokuNengo = commonEra(entity.get資格取得年月日());
            source.shikakuShutokuYMD = commonYMD(entity.get資格取得年月日());
            source.shikakuSoshitsuNengo = commonEra(entity.get資格喪失年月日());
            source.shiSoshitsuYMD = commonYMD(entity.get資格喪失年月日());
            source.hyodai1_1 = BLANK;
            source.Hyodai1_2 = 区分;
            source.Hyodai2_1 = 支給限度基準額;
            source.minashiKbn = entity.getみなし区分();
            source.yoKaigoJotaiKbn = entity.get要介護状態区分();
            source.yukoKikanSTNengo = commonEra(entity.get有効期間開始年月日());
            source.yukoKikanSTYMD = commonYMD(entity.get有効期間開始年月日());
            source.yukoKikanEDNengo = commonRStringEra(entity.get有効期間終了年月日());
            source.yukoKikanEDYMD = commonRStringYMD(entity.get有効期間終了年月日());
            RString 公費負担限額減額 = entity.get公費負担上限額減額();
            if (公費負担限額減額 != null) {
                source.kohiFutanJogenGaku = new RString(公費負担限額減額.toString());
            }
            RString 支給限度基準額1 = entity.get支給限度基準額1();
            if (支給限度基準額1 != null) {
                source.sikyuGendoKijunGaKu1 = 支給限度基準額1;
            }
            source.jogenTekiyoSTNengo1 = commonEra(entity.get上限管理適用開始年月日１());
            source.jogenKaTekiyoSTYMD1 = commonYMD(entity.get上限管理適用開始年月日１());
            source.jogenTekiyoEDNengo1 = commonRStringEra(entity.get上限管理終了年月日１());
            source.jogenTekiyoEDYMD1 = commonRStringYMD(entity.get上限管理終了年月日１());
            source.Hyodai2_2 = 旧訪問通所;
            source.Hyodai3_1 = 支給限度基準額;
            RString 支給限度基準額2 = entity.get支給限度基準額２();
            if (支給限度基準額2 != null) {
                source.sikyuGendoKijunGaKu2 = 支給限度基準額2.padLeft(RString.HALF_SPACE, THREEE);
            }
            source.jogenTekiyoSTNengo2 = commonEra(entity.get上限管理適用開始年月日２());
            source.jogenKaTekiyoSTYMD2 = commonYMD(entity.get上限管理適用開始年月日２());
            source.jogenTekiyoEDNengo2 = commonEra(entity.get上限管理終了年月日２());
            source.jogenTekiyoEDYMD2 = commonYMD(entity.get上限管理終了年月日２());
            source.Hyodai3_2 = 旧短期入所;
            source.keikakuSakuseiKbn = entity.get計画作成区分();
            source.kyoTekiyoSTNengo = commonRStringEra(entity.get居宅適用開始年月日());
            source.kyoTekiyoSTYMD = commonRStringYMD(entity.get居宅適用開始年月日());
            source.kyoTekiyoEDNengo = commonRStringEra(entity.get居宅適用終了年月日());
            source.kyoTekiyoEDYMD = commonRStringYMD(entity.get居宅適用終了年月日());
            source.genShinseichuKbn = entity.get減免申請中区分();
            source.riyoshaFutanKbn = entity.get利用者負担区分();
            source.riyoTekiyoSTNengo = commonRStringEra(entity.get利用適用開始年月日());
            source.riyoTekiyoSTYMD = commonRStringYMD(entity.get利用適用開始年月日());
            source.riyoTekiyoEDNengo = commonRStringEra(entity.get利用適用終了年月日());
            source.riyoTekiyoEDYMD = commonRStringYMD(entity.get利用適用終了年月日());
            source.hyojunFutanKBN = entity.get標準負担区分();
            source.hyojunTekiyoSTNengo = commonRStringEra(entity.get標準適用開始年月日());
            source.hyojunTekiyoSTYMD = commonRStringYMD(entity.get標準適用開始年月日());
            source.hyojunTekiyoEDNengo = commonRStringEra(entity.get標準適用終了年月日());
            source.hyojunTekiyoEDYMD = commonRStringYMD(entity.get標準適用終了年月日());
            source.shoTekiyoSTNengo = commonRStringEra(entity.get償還払化適用開始年月日());
            source.shoTekiyoSTYMD = commonRStringYMD(entity.get償還払化適用開始年月日());
            source.shoTekiyoEDNengo = commonRStringEra(entity.get償還払化適用終了年月日());
            source.shoTekiyoEDYMD = commonRStringYMD(entity.get償還払化適用終了年月日());
            source.kyuTekiyoSTNengo = commonRStringEra(entity.get給付率引下げ適用開始年月日());
            source.kyuTekiyoSTYMD = commonRStringYMD(entity.get給付率引下げ適用開始年月日());
            source.kyuTekiyoEDNengo = commonRStringEra(entity.get給付率引下げ適用終了年月日());
            source.kyuTekiyoEDYMD = commonRStringYMD(entity.get給付率引下げ適用終了年月日());
            source.ninteiShinseiKbn = entity.get認定申請中区分();
            source.serviceKbn = entity.getｻｰﾋﾞｽ区分();
            source.tokuGenTaisho = entity.get特例減額措置対象();
            source.tokuTekiyoSTNengo = commonRStringEra(entity.get特定入所者適用開始年月日());
            source.tokuTekiyoSTYMD = commonRStringYMD(entity.get特定入所者適用開始年月日());
            source.tokuTekiyoEDNengo = commonRStringEra(entity.get特定入所者適用終了年月日());
            source.tokuTekiyoEDYMD = commonRStringYMD(entity.get特定入所者適用終了年月日());
            source.shaTekiyoSTNengo = commonRStringEra(entity.get軽減率適用開始年月日());
            source.shaTekiyoSTYMD = commonRStringYMD(entity.get軽減率適用開始年月日());
            source.shaTekiyoEDNengo = commonRStringEra(entity.get軽減率適用終了年月日());
            source.shaTekiyoEDYMD = commonRStringYMD(entity.get軽減率適用終了年月日());
            RString 小規模居宅ｻｰﾋﾞｽ = entity.get小規模居宅ｻｰﾋﾞｽ利用();
            if (小規模居宅ｻｰﾋﾞｽ != null) {
                source.shokiboKyotakuUmu = 小規模居宅ｻｰﾋﾞｽ;
            }
            source.nijiYoboTaishoKbn = entity.get二次予防事業区分();
            source.nijiYoboSTNengo = commonEra(entity.get二次予防有効期間開始年月日());
            source.nijiYoboSTYMD = commonYMD(entity.get二次予防有効期間開始年月日());
            source.nijiYoboEDNengo = commonEra(entity.get二次予防有効期間終了年月日());
            source.nijiYoboEDYMD = commonYMD(entity.get二次予防有効期間終了年月日());
            source.shinseiShubetsu = entity.get申請種別();
            source.henkoShinseiKbn = entity.get変更申請中区分();
            source.shinseiNengo = commonEra(entity.get申請年月日());
            source.shinseiYMD = commonYMD(entity.get申請年月日());
            source.jutokuTekiyoSTNengo = commonRStringEra(entity.get住特適用開始年月日());
            source.jutokuTekiyoSTYMD = commonRStringYMD(entity.get住特適用開始年月日());
            source.jutokuTekiyoEDNengo = commonRStringEra(entity.get住特適用終了年月日());
            source.jutokuTekiyoEDYMD = commonRStringYMD(entity.get住特適用終了年月日());
            source.niFuTekiyoSTNengo = commonRStringEra(entity.get二割負担適用開始年月日());
            source.niFuTekiyoSTYMD = commonRStringYMD(entity.get二割負担適用開始年月日());
            source.niFuTekiyoEDNengo = commonRStringEra(entity.get二割負担適用終了年月日());
            source.niFuTekiyoEDYMD = commonRStringYMD(entity.get二割負担適用終了年月日());
            特定入所者介護サービス(source);
            利用者旧措置利用者負担(source);
            社会福祉法人軽減情報(source);
            標準負担特定標準負担(source);
            居宅サービス計画届出(source);
            後期高齢者医療資格(source);
            国民健康保険資格(source);
            住所地特例(source);
        }
        return source;
    }

    private void 国民健康保険資格(JukyushaIdoRenrakuhyoSource source) {
        RString 国保保険者番号 = entity.get国保保険者番号();
        if (国保保険者番号 != null && !国保保険者番号.isEmpty()) {
            if (国保保険者番号.contains(半角アスタリスク)) {
                source.kokuhoHokenshaNo = 半角アスタリスクEIGHT;
            } else {
                source.kokuhoHokenshaNo = 国保保険者番号;
            }
        }
        RString 国保被保険者証番号 = entity.get国保被保険者証番号();
        if (国保被保険者証番号 != null && !国保被保険者証番号.isEmpty()) {
            if (国保被保険者証番号.contains(半角アスタリスク)) {
                source.kokuhoHihokenshashoNo = 半角アスタリスクTWENTY;
            } else {
                source.kokuhoHihokenshashoNo = 国保被保険者証番号;
            }
        }
        RString 国保個人番号 = entity.get国保個人番号();
        if (国保個人番号 != null && !国保個人番号.isEmpty()) {
            if (国保個人番号.contains(半角アスタリスク)) {
                source.kokuhoKojinNo = 半角アスタリスクTEN;
            } else {
                source.kokuhoKojinNo = 国保個人番号;
            }
        }
    }

    private void 住所地特例(JukyushaIdoRenrakuhyoSource source) {
        RString 住特施設所在保険者番号 = entity.get住特施設所在保険者番号();
        if (住特施設所在保険者番号 != null && !住特施設所在保険者番号.isEmpty()) {
            if (住特施設所在保険者番号.contains(半角アスタリスク)) {
                source.jutokuHokenshaNo = 半角アスタリスクSIX;
            } else {
                source.jutokuHokenshaNo = 住特施設所在保険者番号;
            }
        }
        if (entity.get住特対象者区分() != null) {
            source.jutokuTaishoKbn = entity.get住特対象者区分();
        }
        if (entity.get広域保険者番号() != null) {
            source.koikiHokenshaNO = entity.get広域保険者番号();
        }
        if (entity.get老人保健市町村番号() != null) {
            source.rokenShichosonNo = entity.get老人保健市町村番号();
        }
        if (entity.get老人保健受給者番号() != null) {
            source.rokenJukyushaNO = entity.get老人保健受給者番号();
        }
    }

    private void 後期高齢者医療資格(JukyushaIdoRenrakuhyoSource source) {
        RString 後期高齢保険者番号 = entity.get後期高齢保険者番号();
        if (後期高齢保険者番号 != null && !後期高齢保険者番号.isEmpty()) {
            if (後期高齢保険者番号.contains(半角アスタリスク)) {
                source.kokiHokenshaNo = 半角アスタリスクEIGHT;
            } else {
                source.kokiHokenshaNo = 後期高齢保険者番号;
            }
        }
        RString 後期高齢被保険者番号 = entity.get後期高齢被保険者番号();
        if (後期高齢被保険者番号 != null && !後期高齢被保険者番号.isEmpty()) {
            if (後期高齢被保険者番号.contains(半角アスタリスク)) {
                source.kokiHihokenshaNo = 半角アスタリスクEIGHT;
            } else {
                source.kokiHihokenshaNo = 後期高齢被保険者番号;
            }
        }
    }

    private void 居宅サービス計画届出(JukyushaIdoRenrakuhyoSource source) {
        RString 居宅支援事業者番号 = entity.get居宅支援事業者番号();
        if (居宅支援事業者番号 != null && !居宅支援事業者番号.isEmpty()) {
            if (居宅支援事業者番号.contains(半角アスタリスク)) {
                source.kyotakuShienJigyoshaNO = 半角アスタリスクTEN;
            } else {
                source.kyotakuShienJigyoshaNO = 居宅支援事業者番号;
            }
        }
    }

    private void 標準負担特定標準負担(JukyushaIdoRenrakuhyoSource source) {
        RString 標準負担額 = entity.get標準負担額();
        if (標準負担額 != null && !標準負担額.isEmpty()) {
            if (標準負担額.contains(半角アスタリスク)) {
                source.hyojunFutanGaku = 半角アスタリスクFIVE;
            } else {
                source.hyojunFutanGaku = 標準負担額.padLeft(RString.HALF_SPACE, FIVE);
            }
        }
    }

    private void 社会福祉法人軽減情報(JukyushaIdoRenrakuhyoSource source) {
        RString 軽減率 = entity.get軽減率();
        if (軽減率 != null && !軽減率.isEmpty()) {
            if (軽減率.contains(半角アスタリスク)) {
                source.shaKyufuritsu = 半角アスタリスクFOUR;
            } else {
                source.shaKyufuritsu = 軽減率.padLeft(RString.HALF_SPACE, THREEE);
            }
        }
    }

    private void 利用者旧措置利用者負担(JukyushaIdoRenrakuhyoSource source) {
        RString 給付率 = entity.get利用給付率();
        if (給付率 != null && !給付率.isEmpty()) {
            if (給付率.contains(半角アスタリスク)) {
                source.riyoKyufuRitsu = 半角アスタリスクTHREE;
            } else {
                source.riyoKyufuRitsu = 給付率.padLeft(RString.HALF_SPACE, THREEE);
            }
        }
    }

    private void 特定入所者介護サービス(JukyushaIdoRenrakuhyoSource source) {
        居住費負担限度額(source);
        RString 食費負担限度額 = entity.get食費負担限度額();
        if (食費負担限度額 != null && !食費負担限度額.isEmpty()) {
            if (食費負担限度額.contains(半角アスタリスク)) {
                source.shokuFutanGendoGaKu = 半角アスタリスクFIVE;
            } else {
                source.shokuFutanGendoGaKu = 食費負担限度額.padZeroToLeft(FOUR);
            }
        }
    }

    private void 居住費負担限度額(JukyushaIdoRenrakuhyoSource source) {
        RString ﾕﾆｯﾄ型個室 = entity.getﾕﾆｯﾄ型個室();
        if (ﾕﾆｯﾄ型個室 != null && !ﾕﾆｯﾄ型個室.isEmpty()) {
            if (ﾕﾆｯﾄ型個室.contains(半角アスタリスク)) {
                source.unitKoshitsu = 半角アスタリスクFOUR;
            } else {
                source.unitKoshitsu = ﾕﾆｯﾄ型個室.padZeroToLeft(FOUR);
            }
        }
        RString ﾕﾆｯﾄ型準個室 = entity.getﾕﾆｯﾄ型準個室();
        if (ﾕﾆｯﾄ型準個室 != null && !ﾕﾆｯﾄ型準個室.isEmpty()) {
            if (ﾕﾆｯﾄ型準個室.contains(半角アスタリスク)) {
                source.unitJunKoshitsu = 半角アスタリスクFOUR;
            } else {
                source.unitJunKoshitsu = ﾕﾆｯﾄ型準個室.padZeroToLeft(FOUR);
            }
        }
        RString 従来型個室特 = entity.get従来型個室特();
        if (従来型個室特 != null && !従来型個室特.isEmpty()) {
            if (従来型個室特.contains(半角アスタリスク)) {
                source.juraiKoshitsuT = 半角アスタリスクFOUR;
            } else {
                source.juraiKoshitsuT = 従来型個室特.padZeroToLeft(FOUR);
            }
        }
        RString 従来型個室老療 = entity.get従来型個室老療();
        if (従来型個室老療 != null && !従来型個室老療.isEmpty()) {
            if (従来型個室老療.contains(半角アスタリスク)) {
                source.juraiKishitsuR = 半角アスタリスクFOUR;
            } else {
                source.juraiKishitsuR = 従来型個室老療.padZeroToLeft(FOUR);
            }
        }
        RString 多床室 = entity.get多床室();
        if (多床室 != null && !多床室.isEmpty()) {
            if (多床室.contains(半角アスタリスク)) {
                source.tashoshitsu = 半角アスタリスクFOUR;
            } else {
                source.tashoshitsu = 多床室.padZeroToLeft(FOUR);
            }
        }
        居宅費新負担限度額(source);
    }

    private void 居宅費新負担限度額(JukyushaIdoRenrakuhyoSource source) {
        RString 新１ = entity.get新１();
        if (新１ != null && !新１.isEmpty()) {
            if (新１.contains(半角アスタリスク)) {
                source.shin1 = 半角アスタリスクFOUR;
            } else {
                source.shin1 = 新１.padZeroToLeft(FOUR);
            }
        }
        RString 新２ = entity.get新２();
        if (新２ != null && !新２.isEmpty()) {
            if (新２.contains(半角アスタリスク)) {
                source.shin2 = 半角アスタリスクFOUR;
            } else {
                source.shin2 = 新２.padZeroToLeft(FOUR);
            }
        }
        RString 新３ = entity.get新３();
        if (新３ != null && !新３.isEmpty()) {
            if (新３.contains(半角アスタリスク)) {
                source.shin3 = 半角アスタリスクFOUR;
            } else {
                source.shin3 = 新３.padZeroToLeft(FOUR);
            }
        }
    }

    private RString commonEra(FlexibleDate 年月日) {
        if (年月日 != null && !年月日.isEmpty()) {
            return 年月日.wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).getEra();
        }
        return RString.EMPTY;
    }

    private RString commonRStringEra(RString 年月日) {
        if (年月日 != null && !年月日.isEmpty()) {
            if (年月日.contains(半角アスタリスク)) {
                return 年月日;
            }
            return new FlexibleDate(年月日).wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).getEra();
        }
        return RString.EMPTY;
    }

    private RString commonYMD(FlexibleDate 年月日) {
        if (年月日 != null && !年月日.isEmpty()) {
            return 年月日.wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO)
                    .toDateString().substring(2).replace(DOT, RString.EMPTY);
        }
        return RString.EMPTY;
    }

    private RString commonRStringYMD(RString 年月日) {
        if (年月日 != null && !年月日.isEmpty()) {
            if (年月日.contains(半角アスタリスク)) {
                return 半角アスタリスクSIX;
            }
            return new FlexibleDate(年月日).wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO)
                    .toDateString().substring(2).replace(DOT, RString.EMPTY);
        }
        return RString.EMPTY;
    }

    private RString 性別男の場合() {
        if (ONE.equals(entity.get性別())) {
            return CIRCLE;
        }
        return BLANK;
    }

    private RString 性別女の場合() {
        if (TWO.equals(entity.get性別())) {
            return CIRCLE;
        }
        return BLANK;
    }
}
