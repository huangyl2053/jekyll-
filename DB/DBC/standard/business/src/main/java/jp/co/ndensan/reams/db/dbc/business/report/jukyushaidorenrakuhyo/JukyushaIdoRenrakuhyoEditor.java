/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jukyushaidorenrakuhyo;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyotoroku.JukyushaIdoRenrakuhyoTorokuEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.jukyushaidorenrakuhyo.JukyushaIdoRenrakuhyoSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 帳票設計_DBCMN81001_受給者異動連絡票（紙媒体) Editor
 *
 * @reamsid_L DBC-2100-040 jiangzongyue
 */
public class JukyushaIdoRenrakuhyoEditor implements IJukyushaIdoRenrakuhyoEditor {

    private final JukyushaIdoRenrakuhyoTorokuEntity entity;
    private static final RString 旧短期入所 = new RString("旧短期入所");
    private static final RString 支給限度基準額 = new RString("支給限度基準額");
    private static final RString 旧訪問通所 = new RString("旧訪問通所");
    private static final RString 区分 = new RString("区分");
    private static final RString BLANK = new RString(" ");
    private static final RString ONE = new RString("1");

    /**
     * コンストラクタです
     *
     * @param entity JukyushaIdoRenrakuhyoTorokuEntity
     */
    public JukyushaIdoRenrakuhyoEditor(
            JukyushaIdoRenrakuhyoTorokuEntity entity
    ) {
        this.entity = entity;
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
            source.sakuseiGG = entity.get作成年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).getEra();
            source.sakuseiYY = entity.get作成年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).getYear();
            source.sakuseiMM = entity.get作成年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).getMonth();
            source.sakuseiDD = entity.get作成年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).getDay();
            //source.hokenshaName = entity.get被保険者番号();
            source.shoHokenshaNo = entity.get証記載保険者番号();
            source.hihokenshaNo = entity.get被保険者番号();
            source.IdoNengo = entity.get異動年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).getEra();
            source.idoYMD = entity.get異動年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString();
            //source.idoKbn1 = entity.get被保険者番号();
            //source.idoKbn2 = entity.get被保険者名();
            //source.idoKbn3 = entity.getエラーコード();
            //source.seibetsu1 = entity.get世帯コード();
            source.idoJiyu = entity.get異動事由();
            if (ONE.equals(entity.get氏名性別生年月日を印字する())) {
                source.birthGengo = entity.get生年月日().wareki()
                        .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                        .separator(Separator.PERIOD).fillType(FillType.ZERO).getEra();
                source.birthYMD = entity.get生年月日().wareki()
                        .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                        .separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString();
                source.hihokenshaNamaKana = entity.get被保険者氏名カナ();
            } else {
                source.birthGengo = BLANK;
                source.birthYMD = BLANK;
                source.hihokenshaNamaKana = BLANK;
            }
            source.shikakuShutokuNengo = entity.get資格取得年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).getEra();
            source.shikakuShutokuYMD = entity.get資格取得年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString();
            source.shikakuSoshitsuNengo = entity.get資格喪失年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).getEra();
            source.shiSoshitsuYMD = entity.get資格喪失年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString();
            //source.seibetsu2 = entity.get被保険者番号();
            source.hyodai1_1 = BLANK;
            source.Hyodai1_2 = 区分;
            source.Hyodai2_1 = 支給限度基準額;
            source.minashiKbn = entity.getみなし区分();
            source.yoKaigoJotaiKbn = entity.get要介護状態区分();
            source.yukoKikanSTNengo = entity.get有効期間開始年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).getEra();
            source.yukoKikanSTYMD = entity.get有効期間開始年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString();
            source.yukoKikanEDNengo = entity.get有効期間終了年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).getEra();
            source.yukoKikanEDYMD = entity.get有効期間終了年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString();
            source.kohiFutanJogenGaku = new RString(entity.get公費負担上限額減額().toString());
            source.sikyuGendoKijunGaKu1 = entity.get支給限度基準額1();
            source.jogenTekiyoSTNengo1 = entity.get上限管理適用開始年月日１().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).getEra();
            source.jogenKaTekiyoSTYMD1 = entity.get上限管理適用開始年月日１().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString();
            source.jogenTekiyoEDNengo1 = entity.get上限管理終了年月日１().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).getEra();
            source.jogenTekiyoEDYMD1 = entity.get上限管理終了年月日１().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString();
            source.Hyodai2_2 = 旧訪問通所;
            source.Hyodai3_1 = 支給限度基準額;
            source.sikyuGendoKijunGaKu2 = entity.get支給限度基準額２();
            source.jogenTekiyoSTNengo2 = entity.get上限管理適用開始年月日２().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).getEra();
            source.jogenKaTekiyoSTYMD2 = entity.get上限管理適用開始年月日２().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString();
            source.jogenTekiyoEDNengo2 = entity.get上限管理終了年月日２().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).getEra();
            source.jogenTekiyoEDYMD2 = entity.get上限管理終了年月日２().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString();
            source.Hyodai3_2 = 旧短期入所;
            source.keikakuSakuseiKbn = entity.get計画作成区分();
            source.kyotakuShienJigyoshaNO = entity.get居宅支援事業者番号();
            source.kyoTekiyoSTNengo = entity.get居宅適用開始年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).getEra();
            source.kyoTekiyoSTYMD = entity.get居宅適用開始年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString();
            source.kyoTekiyoEDNengo = entity.get居宅適用終了年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).getEra();
            source.kyoTekiyoEDYMD = entity.get居宅適用終了年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString();
            source.genShinseichuKbn = entity.get減免申請中区分();
            source.riyoshaFutanKbn = entity.get利用者負担区分();
            source.riyoKyufuRitsu = entity.get利用給付率();
            source.riyoTekiyoSTNengo = entity.get利用適用開始年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).getEra();
            source.riyoTekiyoSTYMD = entity.get利用適用開始年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString();
            source.riyoTekiyoEDNengo = entity.get利用適用終了年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).getEra();
            source.riyoTekiyoEDYMD = entity.get利用適用終了年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString();
            source.hyojunFutanKBN = entity.get標準負担区分();
            source.hyojunFutanGaku = entity.get標準負担額();
            source.hyojunTekiyoSTNengo = entity.get標準適用開始年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).getEra();
            source.hyojunTekiyoSTYMD = entity.get標準適用開始年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString();
            source.hyojunTekiyoEDNengo = entity.get標準適用終了年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).getEra();
            source.hyojunTekiyoEDYMD = entity.get標準適用終了年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString();
            source.shoTekiyoSTNengo = entity.get償還払化適用開始年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).getEra();
            source.ShoTekiyoSTYMD = entity.get償還払化適用開始年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString();
            source.shoTekiyoEDNengo = entity.get償還払化適用終了年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).getEra();
            source.shoTekiyoEDYMD = entity.get償還払化適用終了年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString();
            source.kyuTekiyoSTNengo = entity.get給付率引下げ適用開始年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).getEra();
            source.kyuTekiyoSTYMD = entity.get給付率引下げ適用開始年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString();
            source.kyuTekiyoEDNengo = entity.get給付率引下げ適用終了年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).getEra();
            source.kyuTekiyoEDYMD = entity.get給付率引下げ適用終了年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString();
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
            source.Shin3 = entity.get新３();
            source.tokuTekiyoSTNengo = entity.get特定入所者適用開始年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).getEra();
            source.tokuTekiyoSTYMD = entity.get特定入所者適用開始年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString();
            source.tokuTekiyoEDNengo = entity.get特定入所者適用終了年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).getEra();
            source.tokuTekiyoEDYMD = entity.get特定入所者適用終了年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString();
            source.koikiHokenshaNO = entity.get広域保険者番号();
            source.rokenShichosonNo = entity.get老人保健市町村番号();
            source.rokenJukyushaNO = entity.get老人保健受給者番号();
            source.shaKyufuritsu = entity.get軽減率();
            source.shaTekiyoSTNengo = entity.get軽減率適用開始年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).getEra();
            source.shaTekiyoSTYMD = entity.get軽減率適用開始年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString();
            source.shaTekiyoEDNengo = entity.get軽減率適用終了年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).getEra();
            source.shaTekiyoEDYMD = entity.get軽減率適用終了年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString();
            //source.ShokiboKyotakuUmu = entity.get小規模居宅ｻｰﾋﾞｽ利用();
            source.nijiYoboTaishoKbn = entity.get二次予防事業区分();
            source.nijiYoboSTNengo = entity.get二次予防有効期間開始年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).getEra();
            source.nijiYoboSTYMD = entity.get二次予防有効期間開始年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString();
            source.nijiYoboEDNengo = entity.get二次予防有効期間終了年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).getEra();
            source.nijiYoboEDYMD = entity.get二次予防有効期間終了年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString();
            source.shinseiShubetsu = entity.get申請種別();
            source.henkoShinseiKbn = entity.get変更申請中区分();
            source.shinseiNengo = entity.get申請年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).getEra();
            source.shinseiYMD = entity.get申請年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString();
            source.kokuhoHokenshaNo = entity.get国保保険者番号();
            source.kokuhoHihokenshashoNo = entity.get国保被保険者証番号();
            source.kokuhoKojinNo = entity.get国保個人番号();
            source.kokiHokenshaNo = entity.get後期高齢保険者番号();
            source.kokiHihokenshaNo = entity.get後期高齢被保険者番号();
            source.jutokuTaishoKbn = entity.get住特対象者区分();
            source.jutokuHokenshaNo = entity.get住特施設所在保険者番号();
            source.jutokuTekiyoSTNengo = entity.get住特適用開始年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).getEra();
            source.jutokuTekiyoSTYMD = entity.get住特適用開始年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString();
            source.jutokuTekiyoEDNengo = entity.get住特適用終了年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).getEra();
            source.jutokuTekiyoEDYMD = entity.get住特適用終了年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString();
            source.niFuTekiyoSTNengo = entity.get二割負担適用開始年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).getEra();
            source.niFuTekiyoSTYMD = entity.get二割負担適用開始年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString();
            source.niFuTekiyoEDNengo = entity.get二割負担適用終了年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).getEra();
            source.niFuTekiyoEDYMD = entity.get二割負担適用終了年月日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString();
        }
        return source;
    }

    private boolean isYearMonthNullOrEmpty(FlexibleYearMonth data) {
        return data != null && !RString.EMPTY.equals(data.toDateString());
    }
}
