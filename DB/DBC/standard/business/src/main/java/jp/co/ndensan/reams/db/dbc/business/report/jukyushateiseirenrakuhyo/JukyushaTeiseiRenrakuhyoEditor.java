/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jukyushateiseirenrakuhyo;

import java.util.regex.Pattern;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyotoroku.JukyushaIdoRenrakuhyoTorokuEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.jukyushateiseirenrakuhyo.JukyushaTeiseiRenrakuhyoSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 *
 * @author lijian
 */
public class JukyushaTeiseiRenrakuhyoEditor implements IJukyushaTeiseiRenrakuhyoEditor {

    private JukyushaIdoRenrakuhyoTorokuEntity 出力用受給者訂正情報Entity;
    private static final RString 区分 = new RString("区分");
    private static final RString 支給限度基準額 = new RString("支給限度基準額");
    private static final RString 旧訪問通所 = new RString("旧訪問通所");
    private static final RString 旧短期入所 = new RString("旧短期入所");

    /**
     * コンストラクタです。
     *
     * @param 出力用受給者訂正情報Entity JukyushaIdoRenrakuhyoTorokuEntity
     */
    public JukyushaTeiseiRenrakuhyoEditor(JukyushaIdoRenrakuhyoTorokuEntity 出力用受給者訂正情報Entity) {
        this.出力用受給者訂正情報Entity = 出力用受給者訂正情報Entity;
    }

    @Override
    public JukyushaTeiseiRenrakuhyoSource edit(JukyushaTeiseiRenrakuhyoSource source) {

        set年月日(source);
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

        return source;
    }

    private void set年月日(JukyushaTeiseiRenrakuhyoSource source) {
        source.sakuseiGG = get年号(出力用受給者訂正情報Entity.get作成年月日());
        source.sakuseiYY = get年(出力用受給者訂正情報Entity.get作成年月日());
        source.sakuseiMM = get月(出力用受給者訂正情報Entity.get作成年月日());
        source.sakuseiDD = get日(出力用受給者訂正情報Entity.get作成年月日());
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
            RString 年号 = date.wareki().eraType(EraType.KANJI).
                    firstYear(FirstYear.ICHI_NEN).separator(Separator.PERIOD).fillType(FillType.ZERO).getMonth();
            return 年号;
        } else {
            return RString.EMPTY;
        }
    }

    private RString get日(FlexibleDate date) {
        if (date != null) {
            RString 年号 = date.wareki().eraType(EraType.KANJI).
                    firstYear(FirstYear.ICHI_NEN).separator(Separator.PERIOD).fillType(FillType.ZERO).getDay();
            return 年号;
        } else {
            return RString.EMPTY;
        }
    }

}
