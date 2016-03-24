/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0310012;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanJuryoininKeiyakusha;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanJuryoininKeiyakushaBuilder;
import jp.co.ndensan.reams.db.dbc.definition.core.keiyakuservice.KeiyakuServiceShurui;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyushinseishoumu.ShikyushinseishoUmuKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shoninkubun.ShoninKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0310012.PnlTotalPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.service.core.shokanjuryoininkeiyakusha.ShokanJuryoininKeiyakushaFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 受領委任契約（福祉用具購入費・住宅改修費）登録・追加・修正・照会_登録画面のHandlerクラス
 */
public class PnlTotalPanelHandler {

    private final PnlTotalPanelDiv div;
    private static final RString 参照 = new RString("参照");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");
    private static final RString 保存する = new RString("btnUpdate");
    private static final RYear 過年度 = new RYear(2000);
    private static final int 四 = 4;
    private static final int 五 = 5;
    private static final int 八 = 8;

    /**
     * 初期化
     *
     * @param div PnlTotalPanelDiv
     */
    public PnlTotalPanelHandler(PnlTotalPanelDiv div) {
        this.div = div;
    }

    /**
     * 初期化メソッド
     *
     * @param div PnlTotalPanelDiv
     * @return PnlTotalPanelHandler
     */
    public static PnlTotalPanelHandler of(PnlTotalPanelDiv div) {
        return new PnlTotalPanelHandler(div);
    }

    /**
     * 初期データ状態の設定する。
     *
     * @param 状態 状態
     * @param 受付年月日 受付年月日
     */
    public void set初期データ状態(RString 状態, FlexibleDate 受付年月日) {
        if (修正.equals(状態)) {
            div.getPnlCommon().getCcdAtena().setDisabled(true);
            if (受付年月日.isEmpty()) {
                div.getPnlCommon().getPnlDetail().getRdoKettekubun().setDisabled(true);
                div.getPnlCommon().getPnlDetail().getTxtFusyoninriyu().setDisabled(true);
                div.getPnlCommon().getPnlDetail().getPnlHidari().getDdlYear().setDisabled(true);
                div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtBango1().setDisabled(true);
                div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtBango2().setDisabled(true);
                div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtSyoninkikan().setDisabled(true);
                div.getPnlCommon().getPnlDetail().getPnlHidari().getChkSaihakoukubun().setDisabled(true);
            }
        } else {
            if (参照.equals(状態)) {
                CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(保存する, true);
            }
            div.getPnlCommon().getPnlDetail().getTxtKeyakushinseuketukebi().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getTxtKeyakushinseibi().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getTxtKeyakujigyosyaNo().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getBtnKeiyakuJigyoshaNoIcon().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getTxtKeyakujigyosyaName().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getDdlKeiyakuServiceType().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getTxtKeyakukettebi().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getRdoKettekubun().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getTxtFusyoninriyu().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlHidari().getDdlYear().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtBango1().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtBango2().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtSyoninkikan().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlHidari().getChkSaihakoukubun().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlFoot().getTxtBikou().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHiyogakugokei().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtRiyosyajikofutangaku().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokentaisyohiyogaku().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokenkyufuhiyogaku().setDisabled(true);
        }
        div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtSyoninchutisyosakuseibi().setDisabled(true);

    }

    /**
     * 初期データの設定する
     *
     * @param shokanData ShokanJuryoininKeiyakusha
     */
    public void set初期データ(ShokanJuryoininKeiyakusha shokanData) {
        div.getPnlCommon().getPnlDetail().getTxtKeyakushinseuketukebi()
                .setValue(new RDate(shokanData.get受付年月日().toString()));
        div.getPnlCommon().getPnlDetail().getTxtKeyakushinseibi()
                .setValue(new RDate(shokanData.get申請年月日().toString()));
        div.getPnlCommon().getPnlDetail().getTxtKeyakujigyosyaNo()
                .setValue(shokanData.get契約事業者番号());
        // TODO QA.378(Redmine#:78539)
        div.getPnlCommon().getPnlDetail().getTxtKeyakujigyosyaName().setValue(new RString("契約事業者名称"));
        div.getPnlCommon().getPnlDetail().getDdlKeiyakuServiceType().setSelectedKey(shokanData.get契約サービス種類());
        if (shokanData.get決定年月日() != null && !shokanData.get決定年月日().isEmpty()) {
            div.getPnlCommon().getPnlDetail().getTxtKeyakukettebi()
                    .setValue(new RDate(shokanData.get決定年月日().toString()));
        }
        if (ShoninKubun.承認する.getコード().equals(shokanData.get承認結果区分())) {
            div.getPnlCommon().getPnlDetail().getRdoKettekubun().setSelectedKey(ShoninKubun.承認する.getコード());
        } else if (ShoninKubun.承認しない.getコード().equals(shokanData.get承認結果区分())) {
            div.getPnlCommon().getPnlDetail().getRdoKettekubun().setSelectedKey(ShoninKubun.承認しない.getコード());
        }
        div.getPnlCommon().getPnlDetail().getTxtFusyoninriyu().setValue(shokanData.get不承認理由());
        if (!shokanData.get契約番号().isNullOrEmpty()) {
            div.getPnlCommon().getPnlDetail().getPnlHidari()
                    .getDdlYear().setSelectedKey(shokanData.get契約番号().substring(0, 四));
            div.getPnlCommon().getPnlDetail().getPnlHidari()
                    .getTxtBango1().setValue(new Decimal(shokanData.get契約番号().substring(四, 五).toString()));
            div.getPnlCommon().getPnlDetail().getPnlHidari()
                    .getTxtBango2().setValue(shokanData.get契約番号().substring(五, 八));
        }
        if (shokanData.get受領委任払適用開始年月日() != null && !shokanData.get受領委任払適用開始年月日().isEmpty()) {
            div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtSyoninkikan()
                    .setFromValue(new RDate(shokanData.get受領委任払適用開始年月日().toString()));
        }
        if (shokanData.get受領委任払適用終了年月日() != null && !shokanData.get受領委任払適用終了年月日().isEmpty()) {
            div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtSyoninkikan()
                    .setToValue(new RDate(shokanData.get受領委任払適用終了年月日().toString()));
        }
        if (shokanData.get承認結果通知書作成日() != null && !shokanData.get承認結果通知書作成日().isEmpty()) {
            div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtSyoninchutisyosakuseibi()
                    .setValue(new RDate(shokanData.get承認結果通知書作成日().toString()));
        }
        if (new RString("1").equals(shokanData.get承認結果通知書再発行区分())) {
            List<RString> list = new ArrayList<>();
            list.add(new RString("1"));
            div.getPnlCommon().getPnlDetail().getPnlHidari().getChkSaihakoukubun().setSelectedItemsByKey(list);
        } else if (new RString("0").equals(shokanData.get承認結果通知書再発行区分())) {
            div.getPnlCommon().getPnlDetail().getPnlHidari().getChkSaihakoukubun()
                    .setSelectedItemsByKey(new ArrayList<RString>());
        }
        if (ShikyushinseishoUmuKubun.申請有り.getコード().equals(shokanData.get支給申請書有無区分())) {
            div.getPnlCommon().getPnlDetail().getPnlFoot()
                    .getTxtShikyuumukubun().setValue(ShikyushinseishoUmuKubun.申請有り.get名称());
        } else if (ShikyushinseishoUmuKubun.申請無し.getコード().equals(shokanData.get支給申請書有無区分())) {
            div.getPnlCommon().getPnlDetail().getPnlFoot()
                    .getTxtShikyuumukubun().setValue(ShikyushinseishoUmuKubun.申請無し.get名称());
        }
        div.getPnlCommon().getPnlDetail().getPnlFoot().getTxtShikyuumukubun().setDisabled(true);
        if (shokanData.get支給申請サービス提供年月() != null && !shokanData.get支給申請サービス提供年月().isEmpty()) {
            div.getPnlCommon().getPnlDetail().getPnlFoot().getTxtServiceYM()
                    .setDomain(new RYearMonth(shokanData.get支給申請サービス提供年月().toDateString()));
        }
        div.getPnlCommon().getPnlDetail().getPnlFoot().getTxtServiceYM().setDisabled(true);
        div.getPnlCommon().getPnlDetail().getPnlFoot()
                .getTxtSyokanseriNo().setValue(shokanData.get支給申請償還整理番号());
        div.getPnlCommon().getPnlDetail().getPnlFoot().getTxtSyokanseriNo().setDisabled(true);
        div.getPnlCommon().getPnlDetail().getPnlFoot().getTxtBikou().setValue(shokanData.get備考());
        div.getPnlCommon().getPnlDetail().getPnlKyufuhi()
                .getTxtHiyogakugokei().setValue(shokanData.get費用額合計());
        div.getPnlCommon().getPnlDetail().getPnlKyufuhi()
                .getTxtRiyosyajikofutangaku().setValue(shokanData.get利用者自己負担額());
        div.getPnlCommon().getPnlDetail().getPnlKyufuhi()
                .getTxtHokentaisyohiyogaku().setValue(shokanData.get保険対象費用額());
        div.getPnlCommon().getPnlDetail().getPnlKyufuhi()
                .getTxtHokenkyufuhiyogaku().setValue(shokanData.get保険給付費額());
    }

    /**
     * DropDownListを作成します。
     */
    public void createDropDownList() {
        List<KeyValueDataSource> keiyakuServiceTypeList = new ArrayList<>();
        keiyakuServiceTypeList.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        keiyakuServiceTypeList.add(new KeyValueDataSource(
                KeiyakuServiceShurui.福祉用具.getコード(), KeiyakuServiceShurui.福祉用具.get名称()));
        keiyakuServiceTypeList.add(new KeyValueDataSource(
                KeiyakuServiceShurui.住宅改修.getコード(), KeiyakuServiceShurui.住宅改修.get名称()));
        keiyakuServiceTypeList.add(new KeyValueDataSource(
                KeiyakuServiceShurui.予防福祉用具.getコード(), KeiyakuServiceShurui.予防福祉用具.get名称()));
        keiyakuServiceTypeList.add(new KeyValueDataSource(
                KeiyakuServiceShurui.予防住宅改修.getコード(), KeiyakuServiceShurui.予防住宅改修.get名称()));
        keiyakuServiceTypeList.add(new KeyValueDataSource(
                KeiyakuServiceShurui.償還払支給.getコード(), KeiyakuServiceShurui.償還払支給.get名称()));
        keiyakuServiceTypeList.add(new KeyValueDataSource(
                KeiyakuServiceShurui.高額給付支給.getコード(), KeiyakuServiceShurui.高額給付支給.get名称()));
        div.getPnlCommon().getPnlDetail().getDdlKeiyakuServiceType().setDataSource(keiyakuServiceTypeList);

        List<KeyValueDataSource> rdoList = new ArrayList<>();
        rdoList.add(new KeyValueDataSource(ShoninKubun.承認する.getコード(), ShoninKubun.承認する.get名称()));
        rdoList.add(new KeyValueDataSource(ShoninKubun.承認しない.getコード(), ShoninKubun.承認しない.get名称()));
        div.getPnlCommon().getPnlDetail().getRdoKettekubun().setDataSource(rdoList);

        List<KeyValueDataSource> yearList = new ArrayList<>();
        yearList.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        RYear 現年度 = RDate.getNowDate().getYear();
        while (過年度.isBeforeOrEquals(現年度)) {
            KeyValueDataSource kv = new KeyValueDataSource(現年度.toDateString(), 現年度.toDateString());
            yearList.add(kv);
            現年度 = 現年度.minusYear(1);
        }
        div.getPnlCommon().getPnlDetail().getPnlHidari().getDdlYear().setDataSource(yearList);

        List<KeyValueDataSource> checkBoxList = new ArrayList<>();
        checkBoxList.add(new KeyValueDataSource(new RString("1"), new RString("承認通知書再発行区分")));
        div.getPnlCommon().getPnlDetail().getPnlHidari().getChkSaihakoukubun().setDataSource(checkBoxList);
    }

    /**
     * 保存処理メソッド
     *
     * @param 状態 状態
     */
    public void 保存処理(RString 状態) {
        ShokanJuryoininKeiyakushaFinder finder = ShokanJuryoininKeiyakushaFinder.createInstance();
        ShokanJuryoininKeiyakusha shokan;
        if (登録.equals(状態)) {
//            KaigoShikakuKihonDiv kaigoDiv = (KaigoShikakuKihonDiv) div.getPnlCommon().getCcdKaigoShikakuKihon();
            shokan = new ShokanJuryoininKeiyakusha(
                    // TODO QA No.431(Redmine#:79680)
                    // new HihokenshaNo(kaigoDiv.getTxtHihokenshaNo().getValue()),
                    new HihokenshaNo("000000003"),
                    new FlexibleDate(div.getPnlCommon().getPnlDetail().getTxtKeyakushinseibi().getValue().toDateString()),
                    div.getPnlCommon().getPnlDetail().getTxtKeyakujigyosyaNo().getValue(),
                    div.getPnlCommon().getPnlDetail().getDdlKeiyakuServiceType().getSelectedKey());
            shokan = build契約者情報(shokan);
            finder.insShokanJuryoininKeiyakusha(shokan);
        } else {
            shokan = ViewStateHolder.
                    get(ViewStateKeys.契約者一覧情報, ShokanJuryoininKeiyakusha.class);
            if (修正.equals(状態)) {
                finder.updShokanJuryoininKeiyakusha(build契約者情報(shokan));
            } else if (削除.equals(状態)) {
                finder.delShokanJuryoininKeiyakusha(shokan);
            }
        }
    }

    /**
     * 契約者情報build
     *
     * @param shokan
     * @return ShokanJuryoininKeiyakusha
     */
    private ShokanJuryoininKeiyakusha build契約者情報(ShokanJuryoininKeiyakusha shokan) {
        ShokanJuryoininKeiyakushaBuilder builder = shokan.createBuilderForEdit();
        builder.set受付年月日(new FlexibleDate(div.getPnlCommon().getPnlDetail().getTxtKeyakushinseuketukebi()
                .getValue().toDateString()));
        if (div.getPnlCommon().getPnlDetail().getTxtKeyakukettebi().getValue() != null) {
            builder.set決定年月日(new FlexibleDate(div.getPnlCommon().getPnlDetail()
                    .getTxtKeyakukettebi().getValue().toDateString()));
        }
        if (ShoninKubun.承認する.getコード().equals(div.getPnlCommon().getPnlDetail()
                .getRdoKettekubun().getSelectedKey())) {
            builder.set承認結果区分(ShoninKubun.承認する.getコード());
        } else if (ShoninKubun.承認しない.getコード().equals(div.getPnlCommon().getPnlDetail()
                .getRdoKettekubun().getSelectedKey())) {
            builder.set承認結果区分(ShoninKubun.承認しない.getコード());
        }
        if (div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtSyoninkikan().getFromValue() != null) {
            builder.set受領委任払適用開始年月日(new FlexibleDate(div.getPnlCommon().getPnlDetail().getPnlHidari()
                    .getTxtSyoninkikan().getFromValue().toDateString()));
        }
        if (div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtSyoninkikan().getToValue() != null) {
            builder.set受領委任払適用終了年月日(new FlexibleDate(div.getPnlCommon().getPnlDetail().getPnlHidari()
                    .getTxtSyoninkikan().getToValue().toDateString()));
        }
        if (ShoninKubun.承認する.getコード().equals(div.getPnlCommon().getPnlDetail()
                .getRdoKettekubun().getSelectedKey())) {
            RStringBuilder rsb = new RStringBuilder();
            rsb.append(div.getPnlCommon().getPnlDetail().getPnlHidari().getDdlYear().getSelectedValue());
            rsb.append(div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtBango1().getValue());
            rsb.append(div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtBango2().getValue());
            builder.set契約番号(rsb.toRString());
        }
        if (!div.getPnlCommon().getPnlDetail().getTxtFusyoninriyu().getValue().isNullOrEmpty()) {
            builder.set不承認理由(div.getPnlCommon().getPnlDetail().getTxtFusyoninriyu().getValue());
        }
        if (div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHiyogakugokei().getValue() != null) {
            builder.set費用額合計(div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHiyogakugokei().getValue());
        }
        if (div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokentaisyohiyogaku().getValue() != null) {
            builder.set保険対象費用額(div.getPnlCommon().getPnlDetail().getPnlKyufuhi()
                    .getTxtHokentaisyohiyogaku().getValue());
        }
        if (div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtRiyosyajikofutangaku().getValue() != null) {
            builder.set利用者自己負担額(div.getPnlCommon().getPnlDetail().getPnlKyufuhi()
                    .getTxtRiyosyajikofutangaku().getValue());
        }
        if (div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokenkyufuhiyogaku().getValue() != null) {
            builder.set保険給付費額(div.getPnlCommon().getPnlDetail().getPnlKyufuhi()
                    .getTxtHokenkyufuhiyogaku().getValue());
        }
        if (div.getPnlCommon().getPnlDetail().getPnlHidari().getChkSaihakoukubun().isAllSelected()) {
            builder.set承認結果通知書再発行区分(new RString("1"));
        } else {
            builder.set承認結果通知書再発行区分(new RString("0"));
        }
        if (!div.getPnlCommon().getPnlDetail().getPnlFoot().getTxtBikou().getValue().isNullOrEmpty()) {
            builder.set備考(div.getPnlCommon().getPnlDetail().getPnlFoot().getTxtBikou().getValue());
        }
        return builder.build();
    }
}
