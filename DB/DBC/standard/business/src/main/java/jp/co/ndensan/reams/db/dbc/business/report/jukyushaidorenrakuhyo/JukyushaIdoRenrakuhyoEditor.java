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
    private static final RString 旧短期入所 = new RString("旧短期入所");
    private static final RString 支給限度基準額 = new RString("支給限度基準額");
    private static final RString 旧訪問通所 = new RString("旧訪問通所");
    private static final RString 区分 = new RString("区分");
    private static final RString BLANK = new RString(" ");
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");
    private static final RString THREE = new RString("3");
    private static final RString CIRCLE = new RString("○");

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
            source.sakuseiYY = entity.get作成年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.NONE).fillType(FillType.ZERO).getYear();
            source.sakuseiMM = entity.get作成年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.NONE).fillType(FillType.ZERO).getMonth();
            source.sakuseiDD = entity.get作成年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.NONE).fillType(FillType.ZERO).getDay();
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
                source.hihokenshaNamaKana = entity.get被保険者氏名カナ();
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
            source.yukoKikanEDNengo = commonEra(entity.get有効期間終了年月日());
            source.yukoKikanEDYMD = commonYMD(entity.get有効期間終了年月日());
            Boolean 公費負担限額減額 = entity.get公費負担上限額減額();
            source.kohiFutanJogenGaku = new RString(公費負担限額減額.toString());
            source.sikyuGendoKijunGaKu1 = entity.get支給限度基準額1();
            source.jogenTekiyoSTNengo1 = commonEra(entity.get上限管理適用開始年月日１());
            source.jogenKaTekiyoSTYMD1 = commonYMD(entity.get上限管理適用開始年月日１());
            source.jogenTekiyoEDNengo1 = commonEra(entity.get上限管理終了年月日１());
            source.jogenTekiyoEDYMD1 = commonYMD(entity.get上限管理終了年月日１());
            source.Hyodai2_2 = 旧訪問通所;
            source.Hyodai3_1 = 支給限度基準額;
            source.sikyuGendoKijunGaKu2 = entity.get支給限度基準額２();
            source.jogenTekiyoSTNengo2 = commonEra(entity.get上限管理適用開始年月日２());
            source.jogenKaTekiyoSTYMD2 = commonYMD(entity.get上限管理適用開始年月日２());
            source.jogenTekiyoEDNengo2 = commonEra(entity.get上限管理終了年月日２());
            source.jogenTekiyoEDYMD2 = commonYMD(entity.get上限管理終了年月日２());
            source.Hyodai3_2 = 旧短期入所;
            source.keikakuSakuseiKbn = entity.get計画作成区分();
            source.kyotakuShienJigyoshaNO = entity.get居宅支援事業者番号();
            source.kyoTekiyoSTNengo = commonEra(entity.get居宅適用開始年月日());
            source.kyoTekiyoSTYMD = commonYMD(entity.get居宅適用開始年月日());
            source.kyoTekiyoEDNengo = commonEra(entity.get居宅適用終了年月日());
            source.kyoTekiyoEDYMD = commonYMD(entity.get居宅適用終了年月日());
            source.genShinseichuKbn = entity.get減免申請中区分();
            source.riyoshaFutanKbn = entity.get利用者負担区分();
            source.riyoKyufuRitsu = entity.get利用給付率();
            source.riyoTekiyoSTNengo = commonEra(entity.get利用適用開始年月日());
            source.riyoTekiyoSTYMD = commonYMD(entity.get利用適用開始年月日());
            source.riyoTekiyoEDNengo = commonEra(entity.get利用適用終了年月日());
            source.riyoTekiyoEDYMD = commonYMD(entity.get利用適用終了年月日());
            source.hyojunFutanKBN = entity.get標準負担区分();
            source.hyojunFutanGaku = entity.get標準負担額();
            source.hyojunTekiyoSTNengo = commonEra(entity.get標準適用開始年月日());
            source.hyojunTekiyoSTYMD = commonYMD(entity.get標準適用開始年月日());
            source.hyojunTekiyoEDNengo = commonEra(entity.get標準適用終了年月日());
            source.hyojunTekiyoEDYMD = commonYMD(entity.get標準適用終了年月日());
            source.shoTekiyoSTNengo = commonEra(entity.get償還払化適用開始年月日());
            source.shoTekiyoSTYMD = commonYMD(entity.get償還払化適用開始年月日());
            source.shoTekiyoEDNengo = commonEra(entity.get償還払化適用終了年月日());
            source.shoTekiyoEDYMD = commonYMD(entity.get償還払化適用終了年月日());
            source.kyuTekiyoSTNengo = commonEra(entity.get給付率引下げ適用開始年月日());
            source.kyuTekiyoSTYMD = commonYMD(entity.get給付率引下げ適用開始年月日());
            source.kyuTekiyoEDNengo = commonEra(entity.get給付率引下げ適用終了年月日());
            source.kyuTekiyoEDYMD = commonYMD(entity.get給付率引下げ適用終了年月日());
            source.ninteiShinseiKbn = entity.get認定申請中区分();
            source.serviceKbn = entity.getｻｰﾋﾞｽ区分();
            source.tokuGenTaisho = entity.get特例減額措置対象();
            source.shokuFutanGendoGaKu = entity.get食費負担限度額();
            source.unitKoshitsu = entity.getﾕﾆｯﾄ型個室();
            source.unitJunKoshitsu = entity.getﾕﾆｯﾄ型準個室();
            source.juraiKoshitsuT = entity.get従来型個室特();
            source.juraiKishitsuR = entity.get従来型個室老療();
            source.tashoshitsu = entity.get多床室();
            source.shin1 = entity.get新１();
            source.shin2 = entity.get新２();
            source.shin3 = entity.get新３();
            source.tokuTekiyoSTNengo = commonEra(entity.get特定入所者適用開始年月日());
            source.tokuTekiyoSTYMD = commonYMD(entity.get特定入所者適用開始年月日());
            source.tokuTekiyoEDNengo = commonEra(entity.get特定入所者適用終了年月日());
            source.tokuTekiyoEDYMD = commonYMD(entity.get特定入所者適用終了年月日());
            source.koikiHokenshaNO = entity.get広域保険者番号();
            source.rokenShichosonNo = entity.get老人保健市町村番号();
            source.rokenJukyushaNO = entity.get老人保健受給者番号();
            source.shaKyufuritsu = entity.get軽減率();
            source.shaTekiyoSTNengo = commonEra(entity.get軽減率適用開始年月日());
            source.shaTekiyoSTYMD = commonYMD(entity.get軽減率適用開始年月日());
            source.shaTekiyoEDNengo = commonEra(entity.get軽減率適用終了年月日());
            source.shaTekiyoEDYMD = commonYMD(entity.get軽減率適用終了年月日());
            Boolean 小規模居宅ｻｰﾋﾞｽ = entity.get小規模居宅ｻｰﾋﾞｽ利用();
            source.shokiboKyotakuUmu = new RString(小規模居宅ｻｰﾋﾞｽ.toString());
            source.nijiYoboTaishoKbn = entity.get二次予防事業区分();
            source.nijiYoboSTNengo = commonEra(entity.get二次予防有効期間開始年月日());
            source.nijiYoboSTYMD = commonYMD(entity.get二次予防有効期間開始年月日());
            source.nijiYoboEDNengo = commonEra(entity.get二次予防有効期間終了年月日());
            source.nijiYoboEDYMD = commonYMD(entity.get二次予防有効期間終了年月日());
            source.shinseiShubetsu = entity.get申請種別();
            source.henkoShinseiKbn = entity.get変更申請中区分();
            source.shinseiNengo = commonEra(entity.get申請年月日());
            source.shinseiYMD = commonYMD(entity.get申請年月日());
            source.kokuhoHokenshaNo = entity.get国保保険者番号();
            source.kokuhoHihokenshashoNo = entity.get国保被保険者証番号();
            source.kokuhoKojinNo = entity.get国保個人番号();
            source.kokiHokenshaNo = entity.get後期高齢保険者番号();
            source.kokiHihokenshaNo = entity.get後期高齢被保険者番号();
            source.jutokuTaishoKbn = entity.get住特対象者区分();
            source.jutokuHokenshaNo = entity.get住特施設所在保険者番号();
            source.jutokuTekiyoSTNengo = commonEra(entity.get住特適用開始年月日());
            source.jutokuTekiyoSTYMD = commonYMD(entity.get住特適用開始年月日());
            source.jutokuTekiyoEDNengo = commonEra(entity.get住特適用終了年月日());
            source.jutokuTekiyoEDYMD = commonYMD(entity.get住特適用終了年月日());
            source.niFuTekiyoSTNengo = commonEra(entity.get二割負担適用開始年月日());
            source.niFuTekiyoSTYMD = commonYMD(entity.get二割負担適用開始年月日());
            source.niFuTekiyoEDNengo = commonEra(entity.get二割負担適用終了年月日());
            source.niFuTekiyoEDYMD = commonYMD(entity.get二割負担適用終了年月日());
        }
        return source;
    }

    private RString commonEra(FlexibleDate 年月日) {
        return 年月日.wareki()
                .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.PERIOD).fillType(FillType.ZERO).getEra();
    }

    private RString commonYMD(FlexibleDate 年月日) {
        return 年月日.wareki()
                .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.NONE).fillType(FillType.ZERO).toDateString();
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
