/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0600051;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankai;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankaiList;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.KyoshitsuShubetsu;
import jp.co.ndensan.reams.db.dbu.business.core.jyumikonyujyoho.JyuMiKoNyuJyoHoBusiness;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600051.PanelAtenaDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.KyokaisoGaitosha;
import jp.co.ndensan.reams.db.dbz.business.core.basic.RoreiFukushiNenkinJukyusha;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 画面設計_DBU0600051_総合照会_住民固有情報クラスです。
 *
 * @reamsid_L DBU-4100-060 houtianpeng
 */
public class PanelAtenaHandler {

    private final PanelAtenaDiv div;
    private final RString 該当 = new RString("key0");
    private final RString 非該当 = new RString("key1");
    private final RString trueFlg = new RString("1");
    private final RString falseFlg = new RString("0");
    private static final int 三月 = 3;
    private static final int 一月 = 1;

    /**
     * コンストラクタです。
     *
     * @param div PanelAtenaDiv
     */
    public PanelAtenaHandler(PanelAtenaDiv div) {
        this.div = div;
    }

    /**
     * 画面の初期化。
     *
     * @param 識別コード ShikibetsuCode
     * @param 被保険者番号 HihokenshaNo
     */
    public void initializtion(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        div.getCcdKaigoAtenaInfo().initialize(識別コード);
        div.getCcdKaigoShikakuKihon().initialize(被保険者番号);
    }

    /**
     * 画面の編集処理。
     *
     * @param 老齢福祉年金受給者情報 老齢福祉年金受給者情報
     * @param 生保受給者情報 生保受給者情報
     * @param 生活保護扶助種類 生活保護扶助種類
     * @param 境界層管理情報取得 境界層管理情報取得
     * @param 保険料段階リスト 保険料段階リスト
     */
    public void editSyori(List<RoreiFukushiNenkinJukyusha> 老齢福祉年金受給者情報,
            List<JyuMiKoNyuJyoHoBusiness> 生保受給者情報,
            RString 生活保護扶助種類,
            List<JyuMiKoNyuJyoHoBusiness> 境界層管理情報取得,
            HokenryoDankaiList 保険料段階リスト) {

        if (!老齢福祉年金受給者情報.isEmpty()) {

            RoreiFukushiNenkinJukyusha kyusha = 老齢福祉年金受給者情報.get(0);
            div.getTxtRoureiJyukyuKaishibi().setValue(flexToRstr(kyusha.get受給開始年月日()));
            div.getTxtRoureiJukyuuHaishibi().setValue(flexToRstr(kyusha.get受給終了年月日()));
        }
        if (!生保受給者情報.isEmpty()) {

            JyuMiKoNyuJyoHoBusiness business = 生保受給者情報.get(0);
            div.getTxtSeikatuHogoJyukyuKaishibi().setValue(flexToRstr(business.get受給開始日()));
            div.getTxtSeikatuHogoJukyuuHaishibi().setValue(flexToRstr(business.get受給廃止日()));
            div.getTxtHujoShubetu().setValue(生活保護扶助種類);
            div.getTxtSeikatuHogoJyukyuTeishiKaishibi().setValue(flexToRstr(business.get受給停止開始日()));
            div.getTxtSeikatuHogoJukyuuHaishiSyuryobi().setValue(flexToRstr(business.get受給停止終了日()));
        }
        if (!境界層管理情報取得.isEmpty()) {
            JyuMiKoNyuJyoHoBusiness business = 境界層管理情報取得.get(0);
            if (business.get境界層該当者() != null) {
                KyokaisoGaitosha tosha = business.get境界層該当者();
                RString 保険料納付減額後保険料段階 = business.get保険料納付減額後保険料段階();
                edit境界層管理情報エリア(tosha, 保険料納付減額後保険料段階, 保険料段階リスト);
            }
        }
    }

    /**
     * 仮の賦課年度の取得。
     *
     * @param 境界層管理情報取得 境界層管理情報取得
     * @return 仮の賦課年度
     */
    public FlexibleYear get仮の賦課年度(List<JyuMiKoNyuJyoHoBusiness> 境界層管理情報取得) {

        if (!境界層管理情報取得.isEmpty()) {
            JyuMiKoNyuJyoHoBusiness business = 境界層管理情報取得.get(0);

            return get仮の賦課年度(business);
        }
        return FlexibleYear.EMPTY;
    }

    private void edit境界層管理情報エリア(KyokaisoGaitosha tosha,
            RString 保険料納付減額後保険料段階, HokenryoDankaiList 保険料段階リスト) {
        div.getRadKyuhuGengakuKisaiKaijo().setSelectedKey(getKey(tosha.get給付額減額記載解除フラグ()));
        if (!RString.isNullOrEmpty(tosha.get標準負担額額該当フラグ())) {
            div.getRadHyoujunHutanGengaku().setSelectedKey(getKey(tosha.get標準負担額額該当フラグ()));
        }
        if (tosha.get標準負担軽減後負担額() != null) {
            div.getTxtHyoujunHutanGengaku().setValue(tosha.get標準負担軽減後負担額());
        }
        div.getRadKyojuuHinadoHutanGakuGengaku().setSelectedKey(getKey(tosha.get居住費等負担額減額該当フラグ()));
        if (!RString.isNullOrEmpty(tosha.get居住費軽減後居室種類コード())) {
            div.getKyojuuHinadoShurui().setValue(KyoshitsuShubetsu.
                    toValue(tosha.get居住費軽減後居室種類コード()).get名称());
        }
        if (tosha.get居住費軽減後負担額() != null) {
            div.getTxtKyojuuHinadoHutanGakuGengaku().setValue(tosha.get居住費軽減後負担額());
        }
        div.getRadShokuhiHutanGengaku().setSelectedKey(getKey(tosha.get食費負担額減額該当フラグ()));
        if (tosha.get食費軽減後負担額() != null) {
            div.getTxtShokuhiHutanGengaku().setValue(tosha.get食費軽減後負担額());
        }
        div.getRadKougakuSabisuhiJougengakuGengaku().setSelectedKey(getKey(tosha.get高額ｻｰﾋﾞｽ費上限額減額該当フラグ()));
        if (tosha.get高額ｻｰﾋﾞｽ費減額後上限額() != null) {
            div.getTxtJougengaku().setValue(tosha.get高額ｻｰﾋﾞｽ費減額後上限額());
        }
        div.getRdoHokenryouNouhugakuGengaku().setSelectedKey(getKey(tosha.get保険料納付減額フラグ()));
        div.getTxtTekiyouSuruShotokuDankai().setValue(get保険料納付減額後保険料段階の名称(保険料段階リスト,
                保険料納付減額後保険料段階));
    }

    private RString getKey(RString value) {
        if (trueFlg.equals(value)) {

            return 該当;
        }
        if (falseFlg.equals(value)) {

            return 非該当;
        }
        return RString.EMPTY;
    }

    private RString flexToRstr(FlexibleDate date) {
        if (date != null && !date.isEmpty()) {
            return date.wareki().toDateString();
        }
        return RString.EMPTY;
    }

    private FlexibleYear get仮の賦課年度(JyuMiKoNyuJyoHoBusiness business) {
        FlexibleYear 仮の賦課年度 = FlexibleYear.EMPTY;
        if (business.get適用開始年月() != null && !business.get適用開始年月().isEmpty()) {
            if (一月 <= business.get適用開始年月().getMonthValue()
                    && business.get適用開始年月().getMonthValue() <= 三月) {

                仮の賦課年度 = business.get適用開始年月().getYear().minusYear(1);
            } else {

                仮の賦課年度 = business.get適用開始年月().getYear();
            }
        }
        return 仮の賦課年度;
    }

    private RString get保険料納付減額後保険料段階の名称(HokenryoDankaiList 保険料段階リスト, RString 保険料納付減額後保険料段階) {

        if (保険料段階リスト != null && 保険料段階リスト.asList() != null && !保険料段階リスト.asList().isEmpty()) {
            List<HokenryoDankai> 所得段階List = 保険料段階リスト.asList();
            保険料納付減額後保険料段階 = get保険料納付減額後保険料段階(保険料納付減額後保険料段階);
            for (HokenryoDankai 所得段階 : 所得段階List) {
                if (保険料納付減額後保険料段階.equals(所得段階.get段階区分())) {

                    return 所得段階.get表記();
                }
            }
        }
        return RString.EMPTY;
    }

    private RString get保険料納付減額後保険料段階(RString 保険料納付減額後保険料段階) {
        if (!RString.isNullOrEmpty(保険料納付減額後保険料段階)) {

            return new RString(String.format("%03d", Integer.valueOf(保険料納付減額後保険料段階.toString())));
        }
        return RString.EMPTY;
    }
}
