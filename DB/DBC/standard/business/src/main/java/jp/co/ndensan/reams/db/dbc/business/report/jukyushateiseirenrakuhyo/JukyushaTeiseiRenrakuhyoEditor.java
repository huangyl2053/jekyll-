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
import jp.co.ndensan.reams.uz.uza.lang.FillTypeFormatted;
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
    private static final RString 前埋ZERO = new RString("0");
    private static final RString 半角アスタリスク1 = new RString("*");
    private static final RString 半角アスタリスク2 = new RString("**");
    private static final RString 半角アスタリスク4 = new RString("****");
    private static final RString 半角アスタリスク6 = new RString("******");
    private static final RString 半角アスタリスク8 = new RString("********");
    private static final RString 半角アスタリスク10 = new RString("**********");
    private static final RString 半角アスタリスク20 = new RString("********************");
    private static final int LENGTH_ZERO = 0;
    private static final int LENGTH_TWO = 2;
    private static final int LENGTH_THREE = 3;
    private static final int LENGTH_FOUR = 4;
    private static final int LENGTH_FIVE = 5;
    private static final int LENGTH_SIX = 6;
    private static final int LENGTH_TWENTYFIVE = 25;

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
        source.hyodai1_2 = 区分;
        source.hyodai2_1 = 支給限度基準額;
        source.minashiKbn = 出力用受給者訂正情報Entity.getみなし区分();
        source.yoKaigoJotaiKbn = 出力用受給者訂正情報Entity.get要介護状態区分();
        if (出力用受給者訂正情報Entity.get公費負担上限額減額() != null) {
            source.kohiFutanJogenGaku = new RString(出力用受給者訂正情報Entity.get公費負担上限額減額().toString());
        }
        source.sikyuGendoKijunGaKu1 = 前文字数分編集１(出力用受給者訂正情報Entity.get支給限度基準額1());
        source.hyodai2_2 = 旧訪問通所;
        source.hyodai3_1 = 支給限度基準額;
        source.sikyuGendoKijunGaKu2 = 前文字数分編集２(出力用受給者訂正情報Entity.get支給限度基準額２());
        source.hyodai3_2 = 旧短期入所;
        source.keikakuSakuseiKbn = 出力用受給者訂正情報Entity.get計画作成区分();
        source.kyotakuShienJigyoshaNO = 半角アスタリスク1.equals(出力用受給者訂正情報Entity.get居宅支援事業者番号())
                ? 半角アスタリスク10 : 出力用受給者訂正情報Entity.get居宅支援事業者番号();
        source.genShinseichuKbn = 出力用受給者訂正情報Entity.get減免申請中区分();
        source.riyoshaFutanKbn = 出力用受給者訂正情報Entity.get利用者負担区分();
        source.riyoKyufuRitsu = 給付率編集(出力用受給者訂正情報Entity.get利用給付率());
        source.ninteiShinseiKbn = 出力用受給者訂正情報Entity.get認定申請中区分();
        source.serviceKbn = 出力用受給者訂正情報Entity.getｻｰﾋﾞｽ区分();
        source.tokuGenTaisho = 出力用受給者訂正情報Entity.get特例減額措置対象();
        source.shokuFutanGendoGaKu = 文字編集(出力用受給者訂正情報Entity.get食費負担限度額());
        source.unitKoshitsu = 文字編集(出力用受給者訂正情報Entity.getﾕﾆｯﾄ型個室());
        source.unitJunKoshitsu = 文字編集(出力用受給者訂正情報Entity.getﾕﾆｯﾄ型準個室());
        source.juraiKoshitsuT = 文字編集(出力用受給者訂正情報Entity.get従来型個室特());
        source.juraiKishitsuR = 文字編集(出力用受給者訂正情報Entity.get従来型個室老療());
        source.tashoshitsu = 文字編集(出力用受給者訂正情報Entity.get多床室());
        source.shin1 = 文字編集(出力用受給者訂正情報Entity.get新１());
        source.shin2 = 文字編集(出力用受給者訂正情報Entity.get新２());
        source.shin3 = 文字編集(出力用受給者訂正情報Entity.get新３());
        source.koikiHokenshaNO = 出力用受給者訂正情報Entity.get広域保険者番号();
        source.rokenShichosonNo = 出力用受給者訂正情報Entity.get老人保健市町村番号();
        source.rokenJukyushaNO = 出力用受給者訂正情報Entity.get老人保健受給者番号();
        source.shaKyufuritsu = 軽減率編集(出力用受給者訂正情報Entity.get軽減率());
        if (出力用受給者訂正情報Entity.get小規模居宅ｻｰﾋﾞｽ利用() != null) {
            source.shokiboKyotakuUmu = new RString(出力用受給者訂正情報Entity.get小規模居宅ｻｰﾋﾞｽ利用().toString());
        }
        source.nijiYoboTaishoKbn = 出力用受給者訂正情報Entity.get二次予防事業区分();
        source.shinseiShubetsu = 出力用受給者訂正情報Entity.get申請種別();
        source.henkoShinseiKbn = 出力用受給者訂正情報Entity.get変更申請中区分();

        source.kokuhoHokenshaNo = 半角アスタリスク1.equals(出力用受給者訂正情報Entity.get国保保険者番号())
                ? 半角アスタリスク8 : 出力用受給者訂正情報Entity.get国保保険者番号();
        source.kokuhoHihokenshashoNo = 半角アスタリスク1.equals(出力用受給者訂正情報Entity.get国保被保険者証番号())
                ? 半角アスタリスク20 : 出力用受給者訂正情報Entity.get国保被保険者証番号();
        source.kokuhoKojinNo = 半角アスタリスク1.equals(出力用受給者訂正情報Entity.get国保個人番号())
                ? 半角アスタリスク10 : 出力用受給者訂正情報Entity.get国保個人番号();
        source.kokiHokenshaNo = 半角アスタリスク1.equals(出力用受給者訂正情報Entity.get後期高齢保険者番号())
                ? 半角アスタリスク8 : 出力用受給者訂正情報Entity.get後期高齢保険者番号();
        source.kokiHihokenshaNo = 半角アスタリスク1.equals(出力用受給者訂正情報Entity.get後期高齢被保険者番号())
                ? 半角アスタリスク8 : 出力用受給者訂正情報Entity.get後期高齢被保険者番号();
        source.jutokuTaishoKbn = 出力用受給者訂正情報Entity.get住特対象者区分();
        source.jutokuHokenshaNo = 半角アスタリスク1.equals(出力用受給者訂正情報Entity.get住特施設所在保険者番号())
                ? 半角アスタリスク6 : 出力用受給者訂正情報Entity.get住特施設所在保険者番号();
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
        source.idoNengo = get年号(出力用受給者訂正情報Entity.get異動年月日());
        source.idoYMD = get年月日(出力用受給者訂正情報Entity.get異動年月日());
        source.teiseiNengo = get年号(出力用受給者訂正情報Entity.get訂正年月日());
        source.teiseiYMD = get年月日(出力用受給者訂正情報Entity.get訂正年月日());

        if (氏名性別生年月日を印字するONE.equals(出力用受給者訂正情報Entity.get氏名性別生年月日を印字する())) {
            source.birthGengo = get年号(出力用受給者訂正情報Entity.get生年月日());
            source.hihokenshaNamaKana = 後文字数分編集(出力用受給者訂正情報Entity.get被保険者氏名カナ());
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

        source.yukoKikanEDNengo = 年号アスタリスク2(出力用受給者訂正情報Entity.get有効期間終了年月日());
        source.yukoKikanEDYMD = 年月日アスタリスク6(出力用受給者訂正情報Entity.get有効期間終了年月日());

        source.jogenTekiyoSTNengo1 = get年号(出力用受給者訂正情報Entity.get上限管理適用開始年月日１());
        source.jogenKaTekiyoSTYMD1 = get年月日(出力用受給者訂正情報Entity.get上限管理適用開始年月日１());
        source.jogenTekiyoEDNengo1 = 年号アスタリスク2(出力用受給者訂正情報Entity.get上限管理終了年月日１());
        source.jogenTekiyoEDYMD1 = 年月日アスタリスク6(出力用受給者訂正情報Entity.get上限管理終了年月日１());

        source.jogenTekiyoSTNengo2 = get年号(出力用受給者訂正情報Entity.get上限管理適用開始年月日２());
        source.jogenKaTekiyoSTYMD2 = get年月日(出力用受給者訂正情報Entity.get上限管理適用開始年月日２());
        source.jogenTekiyoEDNengo2 = get年号(出力用受給者訂正情報Entity.get上限管理終了年月日２());
        source.jogenTekiyoEDYMD2 = get年月日(出力用受給者訂正情報Entity.get上限管理終了年月日２());

        source.kyoTekiyoSTNengo = 年号アスタリスク2(出力用受給者訂正情報Entity.get居宅適用開始年月日());
        source.kyoTekiyoSTYMD = 年月日アスタリスク6(出力用受給者訂正情報Entity.get居宅適用開始年月日());
        source.kyoTekiyoEDNengo = 年号アスタリスク2(出力用受給者訂正情報Entity.get居宅適用終了年月日());
        source.kyoTekiyoEDYMD = 年月日アスタリスク6(出力用受給者訂正情報Entity.get居宅適用終了年月日());

        source.riyoTekiyoSTNengo = 年号アスタリスク2(出力用受給者訂正情報Entity.get利用適用開始年月日());
        source.riyoTekiyoSTYMD = 年月日アスタリスク6(出力用受給者訂正情報Entity.get利用適用開始年月日());
        source.riyoTekiyoEDNengo = 年号アスタリスク2(出力用受給者訂正情報Entity.get利用適用終了年月日());
        source.riyoTekiyoEDYMD = 年月日アスタリスク6(出力用受給者訂正情報Entity.get利用適用終了年月日());
        source.hyojunFutanKBN = 出力用受給者訂正情報Entity.get標準負担区分();
        source.hyojunFutanGaku = 負担額編集(出力用受給者訂正情報Entity.get標準負担額());
        source.hyojunTekiyoSTNengo = 年号アスタリスク2(出力用受給者訂正情報Entity.get標準適用開始年月日());
        source.hyojunTekiyoSTYMD = 年月日アスタリスク6(出力用受給者訂正情報Entity.get標準適用開始年月日());
        source.hyojunTekiyoEDNengo = 年号アスタリスク2(出力用受給者訂正情報Entity.get標準適用終了年月日());
        source.hyojunTekiyoEDYMD = 年月日アスタリスク6(出力用受給者訂正情報Entity.get標準適用終了年月日());
        source.shoTekiyoSTNengo = 年号アスタリスク2(出力用受給者訂正情報Entity.get償還払化適用開始年月日());
        source.shoTekiyoSTYMD = 年月日アスタリスク6(出力用受給者訂正情報Entity.get償還払化適用開始年月日());
        source.shoTekiyoEDNengo = 年号アスタリスク2(出力用受給者訂正情報Entity.get償還払化適用終了年月日());
        source.shoTekiyoEDYMD = 年月日アスタリスク6(出力用受給者訂正情報Entity.get償還払化適用終了年月日());
        source.kyuTekiyoSTNengo = 年号アスタリスク2(出力用受給者訂正情報Entity.get給付率引下げ適用開始年月日());
        source.kyuTekiyoSTYMD = 年月日アスタリスク6(出力用受給者訂正情報Entity.get給付率引下げ適用開始年月日());
        source.kyuTekiyoEDNengo = 年号アスタリスク2(出力用受給者訂正情報Entity.get給付率引下げ適用終了年月日());
        source.kyuTekiyoEDYMD = 年月日アスタリスク6(出力用受給者訂正情報Entity.get給付率引下げ適用終了年月日());
        source.tokuTekiyoSTNengo = 年号アスタリスク2(出力用受給者訂正情報Entity.get特定入所者適用開始年月日());
        source.tokuTekiyoSTYMD = 年月日アスタリスク6(出力用受給者訂正情報Entity.get特定入所者適用開始年月日());
        source.tokuTekiyoEDNengo = 年号アスタリスク2(出力用受給者訂正情報Entity.get特定入所者適用終了年月日());
        source.tokuTekiyoEDYMD = 年月日アスタリスク6(出力用受給者訂正情報Entity.get特定入所者適用終了年月日());
        source.shaTekiyoSTNengo = 年号アスタリスク2(出力用受給者訂正情報Entity.get軽減率適用開始年月日());
        source.shaTekiyoSTYMD = 年月日アスタリスク6(出力用受給者訂正情報Entity.get軽減率適用開始年月日());
        source.shaTekiyoEDNengo = 年号アスタリスク2(出力用受給者訂正情報Entity.get軽減率適用終了年月日());
        source.shaTekiyoEDYMD = 年月日アスタリスク6(出力用受給者訂正情報Entity.get軽減率適用終了年月日());
        source.nijiYoboSTNengo = get年号(出力用受給者訂正情報Entity.get二次予防有効期間開始年月日());
        source.nijiYoboSTYMD = get年月日(出力用受給者訂正情報Entity.get二次予防有効期間開始年月日());
        source.nijiYoboEDNengo = get年号(出力用受給者訂正情報Entity.get二次予防有効期間終了年月日());
        source.nijiYoboEDYMD = get年月日(出力用受給者訂正情報Entity.get二次予防有効期間終了年月日());
        source.shinseiNengo = get年号(出力用受給者訂正情報Entity.get申請年月日());
        source.shinseiYMD = get年月日(出力用受給者訂正情報Entity.get申請年月日());
        source.jutokuTekiyoSTNengo = 年号アスタリスク2(出力用受給者訂正情報Entity.get住特適用開始年月日());
        source.jutokuTekiyoSTYMD = 年月日アスタリスク6(出力用受給者訂正情報Entity.get住特適用開始年月日());
        source.jutokuTekiyoEDNengo = 年号アスタリスク2(出力用受給者訂正情報Entity.get住特適用終了年月日());
        source.jutokuTekiyoEDYMD = 年月日アスタリスク6(出力用受給者訂正情報Entity.get住特適用終了年月日());
        source.niFuTekiyoSTNengo = 年号アスタリスク2(出力用受給者訂正情報Entity.get二割負担適用開始年月日());
        source.niFuTekiyoSTYMD = 年月日アスタリスク6(出力用受給者訂正情報Entity.get二割負担適用開始年月日());
        source.niFuTekiyoEDNengo = 年号アスタリスク2(出力用受給者訂正情報Entity.get二割負担適用終了年月日());
        source.niFuTekiyoEDYMD = 年月日アスタリスク6(出力用受給者訂正情報Entity.get二割負担適用終了年月日());

    }

    private RString 年号アスタリスク2(RString 年月日) {
        return 半角アスタリスク1.equals(年月日) ? 半角アスタリスク2 : get年号(new FlexibleDate(年月日));
    }

    private RString 年月日アスタリスク6(RString 年月日) {
        return 半角アスタリスク1.equals(年月日) ? 半角アスタリスク6 : get年月日(new FlexibleDate(年月日));
    }

    private RString 後文字数分編集(RString 被保険者氏名カナ) {
        StringBuilder sb = new StringBuilder();
        if (LENGTH_TWENTYFIVE <= 被保険者氏名カナ.length()) {
            return 被保険者氏名カナ.substring(LENGTH_ZERO, LENGTH_TWENTYFIVE);
        } else {
            for (int i = 被保険者氏名カナ.length(); i < LENGTH_TWENTYFIVE; i++) {
                sb.append(RString.HALF_SPACE);
            }
            return 被保険者氏名カナ.concat(sb.toString());
        }
    }

    private RString 前文字数分編集１(RString 支給限度基準額1) {
        StringBuilder sb = new StringBuilder();
        if (支給限度基準額1.length() <= LENGTH_SIX) {
            for (int i = 支給限度基準額1.length(); i < LENGTH_SIX; i++) {
                sb.append(RString.HALF_SPACE);
            }
        }
        return new RString(sb.append(支給限度基準額1).toString());
    }

    private RString 前文字数分編集２(RString 支給限度基準額2) {
        StringBuilder sb = new StringBuilder();
        if (支給限度基準額2.length() <= LENGTH_TWO) {
            for (int i = 支給限度基準額2.length(); i < LENGTH_TWO; i++) {
                sb.append(RString.HALF_SPACE);
            }
        }
        return new RString(sb.append(支給限度基準額2).toString());
    }

    private RString 負担額編集(RString 負担額) {
        StringBuilder sb = new StringBuilder();
        if (負担額.length() <= LENGTH_FIVE) {
            for (int i = 負担額.length(); i < LENGTH_FIVE; i++) {
                sb.append(RString.HALF_SPACE);
            }
        }
        return new RString(sb.append(負担額).toString());
    }

    private RString 給付率編集(RString 給付率) {
        StringBuilder sb = new StringBuilder();
        if (給付率.length() <= LENGTH_THREE) {
            for (int i = 給付率.length(); i < LENGTH_THREE; i++) {
                sb.append(RString.HALF_SPACE);
            }
        }
        return new RString(sb.append(給付率).toString());
    }

    private RString 軽減率編集(RString 軽減率) {
        StringBuilder sb = new StringBuilder();
        if (軽減率.length() <= LENGTH_FOUR) {
            for (int i = 軽減率.length(); i < LENGTH_FOUR; i++) {
                sb.append(RString.HALF_SPACE);
            }
        }
        return new RString(sb.append(軽減率).toString());
    }

    private RString 文字編集(RString 文字) {

        if (半角アスタリスク1.equals(文字)) {
            return 半角アスタリスク4;
        } else {
            StringBuilder sb = new StringBuilder();
            if (文字.length() <= LENGTH_FOUR) {
                for (int i = 文字.length(); i < LENGTH_FOUR; i++) {
                    sb.append(前埋ZERO);
                }
            }
            return new RString(sb.append(文字).toString());
        }

    }

    private RString get年号(FlexibleDate date) {
        if (date != null) {
            return date.wareki().eraType(EraType.KANJI).
                    firstYear(FirstYear.ICHI_NEN).separator(Separator.PERIOD).fillType(FillType.ZERO).getEra();
        }
        return RString.EMPTY;
    }

    private RString get年(FlexibleDate date) {
        if (date != null) {
            RString 年号 = date.wareki().eraType(EraType.KANJI).
                    firstYear(FirstYear.ICHI_NEN).separator(Separator.PERIOD).fillType(FillType.ZERO).getYear();
            return new RString(Pattern.compile(new RString("[^0-9]").toString()).matcher(年号).replaceAll("").trim());
        }
        return RString.EMPTY;

    }

    private RString get月(FlexibleDate date) {
        if (date != null) {
            return date.wareki().eraType(EraType.KANJI).
                    firstYear(FirstYear.ICHI_NEN).separator(Separator.PERIOD).fillType(FillType.ZERO).getMonth();
        }
        return RString.EMPTY;
    }

    private RString get日(FlexibleDate date) {
        if (date != null) {
            return date.wareki().eraType(EraType.KANJI).
                    firstYear(FirstYear.ICHI_NEN).separator(Separator.PERIOD).fillType(FillType.ZERO).getDay();
        }
        return RString.EMPTY;
    }

    private RString get年月日(FlexibleDate date) {
        if (date != null) {
            FillTypeFormatted fillTypeFormatted = date.wareki().eraType(EraType.KANJI).
                    firstYear(FirstYear.ICHI_NEN).separator(Separator.PERIOD).fillType(FillType.ZERO);
            RString 年号 = fillTypeFormatted.getYear();
            RString 年 = new RString(Pattern.compile(new RString("[^0-9]").toString()).matcher(年号).replaceAll("").trim());
            RString 月 = fillTypeFormatted.getMonth();
            RString 日 = fillTypeFormatted.getDay();
            return new RString(new StringBuilder(年).append(月).append(日).toString());
        }
        return RString.EMPTY;

    }

}
