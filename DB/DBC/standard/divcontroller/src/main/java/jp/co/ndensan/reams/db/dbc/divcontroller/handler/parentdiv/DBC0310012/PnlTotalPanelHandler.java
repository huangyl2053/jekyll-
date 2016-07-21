/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0310012;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanJuryoininKeiyakusha;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanJuryoininKeiyakushaBuilder;
import jp.co.ndensan.reams.db.dbc.business.core.shokanjuryoininkeiyakusha.ChkKeiyakuNoParameter;
import jp.co.ndensan.reams.db.dbc.business.core.shokanjuryoininkeiyakusha.ChkTorokuzumiParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.keiyakuservice.KeiyakuServiceShurui;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyushinseishoumu.ShikyushinseishoUmuKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shoninkubun.ShoninKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0310012.PnlTotalPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0310011.PnlTotalSearchParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0310012.PnlTotalPanelParameter;
import jp.co.ndensan.reams.db.dbc.service.core.shokanjuryoininkeiyakusha.ShokanJuryoininKeiyakushaFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 受領委任契約（福祉用具購入費・住宅改修費）登録・追加・修正・照会_登録画面のHandlerクラスです。
 *
 * @reamsid_L DBC-2130-020 cuilin
 */
public class PnlTotalPanelHandler {

    private final PnlTotalPanelDiv div;
    private static final RString 参照 = new RString("参照");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");
    private static final RString 保存する = new RString("btnUpdate");
    private static final RString 承認通知書再発行区分キー_0 = new RString("0");
    private static final RString 承認通知書再発行区分キー_1 = new RString("1");
    private static final RString 承認通知書再発行区分 = new RString("承認通知書再発行区分");
    private static final RString 契約申請受付日 = new RString("契約申請受付日");
    private static final RString 契約申請日 = new RString("契約申請日");
    private static final RString 契約事業者番号 = new RString("契約事業者番号");
    private static final RString 決定区分 = new RString("決定区分");
    private static final RString 不承認理由 = new RString("不承認理由");
    private static final RString 年度 = new RString("年度");
    private static final RString 番号 = new RString("番号");
    private static final RString 受領委任契約番号 = new RString("受領委任契約番号");
    private static final RString 償還受領委任契約者 = new RString("償還受領委任契約者");
    private static final RYear 過年度 = new RYear(2000);
    private static final Decimal 一割 = new Decimal(0.1);
    private static final Decimal 九割 = new Decimal(0.9);
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
     * @param 画面モード RString
     * @param shokanData ShokanJuryoininKeiyakusha
     */
    public void set初期データ状態(RString 画面モード, ShokanJuryoininKeiyakusha shokanData) {
        if (修正.equals(画面モード)) {
            div.getPnlCommon().getCcdAtena().setDisabled(true);
            div.getPnlCommon().getCcdKaigoShikakuKihon().setDisabled(true);
            if (shokanData.get決定年月日() == null || shokanData.get決定年月日().isEmpty()) {
                div.getPnlCommon().getPnlDetail().getRdoKettekubun().setDisabled(true);
                div.getPnlCommon().getPnlDetail().getTxtFusyoninriyu().setDisabled(true);
                div.getPnlCommon().getPnlDetail().getPnlHidari().getDdlYear().setDisabled(true);
                div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtBango2().setDisabled(true);
                div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtSyoninkikan().setDisabled(true);
                div.getPnlCommon().getPnlDetail().getPnlHidari().getChkSaihakoukubun().setDisabled(true);
                div.getPnlCommon().getPnlDetail().getPnlHidari().getChkSaihakoukubun().setDisabled(true);
                div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHiyogakugokei().setDisabled(true);
                div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtRiyosyajikofutangaku().setDisabled(true);
                div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokentaisyohiyogaku().setDisabled(true);
                div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokenkyufuhiyogaku().setDisabled(true);
            } else if (shokanData.get承認結果区分() == null || shokanData.get承認結果区分().isEmpty()
                    || ShoninKubun.承認しない.getコード().equals(shokanData.get承認結果区分())) {
                div.getPnlCommon().getPnlDetail().getRdoKettekubun().setDisabled(false);
                div.getPnlCommon().getPnlDetail().getTxtFusyoninriyu().setDisabled(false);
                div.getPnlCommon().getPnlDetail().getPnlHidari().getDdlYear().setDisabled(true);
                div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtBango2().setDisabled(true);
                div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtSyoninkikan().setDisabled(true);
                div.getPnlCommon().getPnlDetail().getPnlHidari().getChkSaihakoukubun().setDisabled(true);
                div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHiyogakugokei().setDisabled(true);
                div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtRiyosyajikofutangaku().setDisabled(true);
                div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokentaisyohiyogaku().setDisabled(true);
                div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokenkyufuhiyogaku().setDisabled(true);
            } else if (ShoninKubun.承認する.getコード().equals(shokanData.get承認結果区分())) {
                div.getPnlCommon().getPnlDetail().getRdoKettekubun().setDisabled(false);
                div.getPnlCommon().getPnlDetail().getTxtFusyoninriyu().setDisabled(true);
                div.getPnlCommon().getPnlDetail().getPnlHidari().getDdlYear().setDisabled(false);
                div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtBango2().setDisabled(false);
                div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtSyoninkikan().setDisabled(false);
                div.getPnlCommon().getPnlDetail().getPnlHidari().getChkSaihakoukubun().setDisabled(false);
                div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHiyogakugokei().setDisabled(false);
                div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtRiyosyajikofutangaku().setDisabled(false);
                div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokentaisyohiyogaku().setDisabled(false);
                div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokenkyufuhiyogaku().setDisabled(false);
            }
        } else {
            if (参照.equals(画面モード)) {
                CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(保存する, true);
            }
            div.getPnlCommon().getPnlDetail().getTxtKeyakushinseuketukebi().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getTxtKeyakukettebi().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getRdoKettekubun().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getTxtFusyoninriyu().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlHidari().getDdlYear().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtBango2().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtSyoninkikan().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlHidari().getChkSaihakoukubun().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlFoot().getTxtBikou().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHiyogakugokei().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtRiyosyajikofutangaku().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokentaisyohiyogaku().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokenkyufuhiyogaku().setDisabled(true);
        }
        div.getPnlCommon().getPnlDetail().getTxtKeyakushinseibi().setDisabled(true);
        div.getPnlCommon().getPnlDetail().getTxtKeyakujigyosyaNo().setDisabled(true);
        div.getPnlCommon().getPnlDetail().getTxtKeyakujigyosyaName().setDisabled(true);
        div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtBango1().setDisabled(true);
        div.getPnlCommon().getPnlDetail().getDdlKeiyakuServiceType().setDisabled(true);
        div.getPnlCommon().getPnlDetail().getBtnKeiyakuJigyoshaNoIcon().setDisabled(true);
        div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtSyoninchutisyosakuseibi().setDisabled(true);

    }

    /**
     * 初期データの設定する
     *
     * @param shokanData ShokanJuryoininKeiyakusha
     * @param parameter PnlTotalSearchParameter
     */
    public void set初期データ(ShokanJuryoininKeiyakusha shokanData, PnlTotalSearchParameter parameter) {
        div.getPnlCommon().getPnlDetail().getTxtKeyakushinseuketukebi()
                .setValue(new RDate(shokanData.get受付年月日().toString()));
        div.getPnlCommon().getPnlDetail().getTxtKeyakushinseibi()
                .setValue(new RDate(shokanData.get申請年月日().toString()));
        div.getPnlCommon().getPnlDetail().getTxtKeyakujigyosyaNo()
                .setValue(shokanData.get契約事業者番号());
        div.getPnlCommon().getPnlDetail().getTxtKeyakujigyosyaName().setValue(parameter.get契約事業者名());
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
        if (shokanData.get契約番号() != null && !shokanData.get契約番号().isEmpty()) {
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
        if (承認通知書再発行区分キー_1.equals(shokanData.get承認結果通知書再発行区分())) {
            List<RString> list = new ArrayList<>();
            list.add(承認通知書再発行区分キー_1);
            div.getPnlCommon().getPnlDetail().getPnlHidari().getChkSaihakoukubun().setSelectedItemsByKey(list);
        } else if (承認通知書再発行区分キー_0.equals(shokanData.get承認結果通知書再発行区分())) {
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
     * 登録用パラメータの設定する
     *
     * @param param PnlTotalPanelParameter
     */
    public void set登録データ(PnlTotalPanelParameter param) {
        if (param == null) {
            return;
        }
        div.getPnlCommon().getPnlDetail().getTxtKeyakushinseuketukebi().setValue(param.get契約申請受付日());
        div.getPnlCommon().getPnlDetail().getTxtKeyakushinseibi().setValue(param.get契約申請日());
        div.getPnlCommon().getPnlDetail().getTxtKeyakujigyosyaNo().setValue(param.get契約事業者番号());
        div.getPnlCommon().getPnlDetail().getTxtKeyakujigyosyaName().setValue(param.get契約事業者名称());
        div.getPnlCommon().getPnlDetail().getDdlKeiyakuServiceType().setSelectedKey(param.get契約ｻｰﾋﾞｽ種類());
        div.getPnlCommon().getPnlDetail().getTxtKeyakukettebi().setValue(param.get契約決定日());
        if (param.get決定区分() != null && !param.get決定区分().isEmpty()) {
            div.getPnlCommon().getPnlDetail().getRdoKettekubun().setSelectedKey(param.get決定区分());
        }
        div.getPnlCommon().getPnlDetail().getTxtFusyoninriyu().setValue(param.get承認しない理由());
        div.getPnlCommon().getPnlDetail().getPnlHidari().getDdlYear().setSelectedKey(param.get年度());
        div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtBango1().setValue(param.get番号1());
        div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtBango2().setValue(param.get番号2());
        div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtSyoninkikan().setFromValue(param.get承認期間From());
        div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtSyoninkikan().setToValue(param.get承認期間To());
        div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtSyoninchutisyosakuseibi().setValue(param.get承認通知書作成日());
        if (承認通知書再発行区分キー_1.equals(param.get承認結果通知書再発行区分())) {
            List<RString> list = new ArrayList<>();
            list.add(承認通知書再発行区分キー_1);
            div.getPnlCommon().getPnlDetail().getPnlHidari().getChkSaihakoukubun().setSelectedItemsByKey(list);
        } else if (承認通知書再発行区分キー_0.equals(param.get承認結果通知書再発行区分())) {
            div.getPnlCommon().getPnlDetail().getPnlHidari().getChkSaihakoukubun()
                    .setSelectedItemsByKey(new ArrayList<RString>());
        }
        div.getPnlCommon().getPnlDetail().getPnlFoot().getTxtShikyuumukubun().setValue(param.get支給申請有無区分());
        div.getPnlCommon().getPnlDetail().getPnlFoot().getTxtServiceYM().setDomain(param.getサービス提供年月());
        div.getPnlCommon().getPnlDetail().getPnlFoot().getTxtSyokanseriNo().setValue(param.get償還整理番号());
        div.getPnlCommon().getPnlDetail().getPnlFoot().getTxtBikou().setValue(param.get備考());
        div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHiyogakugokei().setValue(param.get費用額合計());
        div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtRiyosyajikofutangaku().setValue(param.get利用者自己負担額());
        div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokentaisyohiyogaku().setValue(param.get保険対象費用額());
        div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokenkyufuhiyogaku().setValue(param.get保険給付費用額());
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
        checkBoxList.add(new KeyValueDataSource(承認通知書再発行区分キー_1, 承認通知書再発行区分));
        div.getPnlCommon().getPnlDetail().getPnlHidari().getChkSaihakoukubun().setDataSource(checkBoxList);
    }

    /**
     * 決定年月日
     */
    public void onBlur決定年月日() {
        if (div.getPnlCommon().getPnlDetail().getTxtKeyakukettebi().getValue() != null) {
            div.getPnlCommon().getPnlDetail().getRdoKettekubun().setSelectedKey(ShoninKubun.承認する.getコード());
            div.getPnlCommon().getPnlDetail().getRdoKettekubun().setDisabled(false);
            div.getPnlCommon().getPnlDetail().getTxtFusyoninriyu().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getTxtFusyoninriyu().clearValue();
            div.getPnlCommon().getPnlDetail().getPnlHidari().getDdlYear().setDisabled(false);
            div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtBango2().setDisabled(false);
            div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtSyoninkikan().setDisabled(false);
            div.getPnlCommon().getPnlDetail().getPnlHidari().getChkSaihakoukubun().setDisabled(false);
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHiyogakugokei().setDisabled(false);
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtRiyosyajikofutangaku().setDisabled(false);
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokentaisyohiyogaku().setDisabled(false);
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokenkyufuhiyogaku().setDisabled(false);
        } else {
            div.getPnlCommon().getPnlDetail().getRdoKettekubun().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getRdoKettekubun().setSelectedKey(ShoninKubun.承認する.getコード());
            div.getPnlCommon().getPnlDetail().getTxtFusyoninriyu().clearValue();
            div.getPnlCommon().getPnlDetail().getTxtFusyoninriyu().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlHidari().getDdlYear().setSelectedKey(RString.EMPTY);
            div.getPnlCommon().getPnlDetail().getPnlHidari().getDdlYear().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtBango2().clearValue();
            div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtBango2().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtSyoninkikan().clearFromValue();
            div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtSyoninkikan().clearToValue();
            div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtSyoninkikan().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlHidari().getChkSaihakoukubun()
                    .setSelectedItemsByKey(new ArrayList<RString>());
            div.getPnlCommon().getPnlDetail().getPnlHidari().getChkSaihakoukubun().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHiyogakugokei().clearValue();
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHiyogakugokei().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtRiyosyajikofutangaku().clearValue();
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtRiyosyajikofutangaku().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokentaisyohiyogaku().clearValue();
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokentaisyohiyogaku().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokenkyufuhiyogaku().clearValue();
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokenkyufuhiyogaku().setDisabled(true);
        }
    }

    /**
     * click決定区分
     */
    public void click決定区分() {
        if (ShoninKubun.承認する.getコード().equals(div.getPnlCommon().getPnlDetail()
                .getRdoKettekubun().getSelectedKey())) {
            div.getPnlCommon().getPnlDetail().getTxtFusyoninriyu().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getTxtFusyoninriyu().clearValue();
            div.getPnlCommon().getPnlDetail().getPnlHidari().getDdlYear().setDisabled(false);
            div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtBango2().setDisabled(false);
            div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtSyoninkikan().setDisabled(false);
            div.getPnlCommon().getPnlDetail().getPnlHidari().getChkSaihakoukubun().setDisabled(false);
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHiyogakugokei().setDisabled(false);
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtRiyosyajikofutangaku().setDisabled(false);
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokentaisyohiyogaku().setDisabled(false);
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokenkyufuhiyogaku().setDisabled(false);
        } else if (ShoninKubun.承認しない.getコード().equals(div.getPnlCommon().getPnlDetail()
                .getRdoKettekubun().getSelectedKey())) {
            div.getPnlCommon().getPnlDetail().getTxtFusyoninriyu().setDisabled(false);
            div.getPnlCommon().getPnlDetail().getPnlHidari().getDdlYear().setSelectedKey(RString.EMPTY);
            div.getPnlCommon().getPnlDetail().getPnlHidari().getDdlYear().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtBango2().clearValue();
            div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtBango2().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtSyoninkikan().clearFromValue();
            div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtSyoninkikan().clearToValue();
            div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtSyoninkikan().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlHidari().getChkSaihakoukubun()
                    .setSelectedItemsByKey(new ArrayList<RString>());
            div.getPnlCommon().getPnlDetail().getPnlHidari().getChkSaihakoukubun().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHiyogakugokei().clearValue();
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHiyogakugokei().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtRiyosyajikofutangaku().clearValue();
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtRiyosyajikofutangaku().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokentaisyohiyogaku().clearValue();
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokentaisyohiyogaku().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokenkyufuhiyogaku().clearValue();
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokenkyufuhiyogaku().setDisabled(true);
        }
    }

    /**
     * onBlur保険対象費用額
     */
    public void onBlur保険対象費用額() {
        Decimal 保険対象費用額 = div.getPnlCommon().getPnlDetail().getPnlKyufuhi()
                .getTxtHokentaisyohiyogaku().getValue();
        if (保険対象費用額 == null || 保険対象費用額 == Decimal.ZERO) {
            return;
        }
        Decimal 利用者自己負担額 = div.getPnlCommon().getPnlDetail().getPnlKyufuhi()
                .getTxtRiyosyajikofutangaku().getValue();
        Decimal 保険給付費用額 = div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokenkyufuhiyogaku().getValue();
        if (利用者自己負担額 == null && 保険給付費用額 == null) {
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtRiyosyajikofutangaku()
                    .setValue(少数点以下は切れ(保険対象費用額.multiply(一割)));
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokenkyufuhiyogaku()
                    .setValue(少数点以下は切れ(保険対象費用額.multiply(九割)));
            if (少数点以下は切れ(保険対象費用額.multiply(一割)).add(少数点以下は切れ(保険対象費用額.multiply(九割)))
                    .compareTo(保険対象費用額) < 0) {
                div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokenkyufuhiyogaku()
                        .setValue(保険対象費用額.subtract(少数点以下は切れ(保険対象費用額.multiply(一割))));
            }
        } else if (利用者自己負担額 == null && 保険給付費用額 != null) {
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtRiyosyajikofutangaku()
                    .setValue(少数点以下は切れ(保険対象費用額.multiply(一割)));
        } else if (利用者自己負担額 != null && 保険給付費用額 == null) {
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokenkyufuhiyogaku()
                    .setValue(少数点以下は切れ(保険対象費用額.multiply(九割)));
            if (利用者自己負担額.add(少数点以下は切れ(保険対象費用額.multiply(九割))).compareTo(保険対象費用額) < 0) {
                div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokenkyufuhiyogaku()
                        .setValue(保険対象費用額.subtract(少数点以下は切れ(保険対象費用額.multiply(一割))));
            }
        }
    }

    private Decimal 少数点以下は切れ(Decimal decimal) {
        return new Decimal((int) Math.floor(decimal.doubleValue()));
    }

    /**
     * 例外チェック
     *
     * @param 画面モード RString
     * @param キー TaishoshaKey
     * @param shokan ShokanJuryoininKeiyakusha
     */
    public void 例外チェック(RString 画面モード, TaishoshaKey キー, ShokanJuryoininKeiyakusha shokan) {
        if (div.getPnlCommon().getPnlDetail().getTxtKeyakushinseuketukebi().getValue() == null) {
            throw new ApplicationException(UrErrorMessages.必須.getMessage().replace(契約申請受付日.toString()).evaluate());
        }
        if (div.getPnlCommon().getPnlDetail().getTxtKeyakushinseibi().getValue() == null) {
            throw new ApplicationException(UrErrorMessages.必須.getMessage().replace(契約申請日.toString()).evaluate());
        }
        if (div.getPnlCommon().getPnlDetail().getTxtKeyakujigyosyaNo().getValue().isEmpty()) {
            throw new ApplicationException(UrErrorMessages.必須.getMessage().replace(契約事業者番号.toString()).evaluate());
        }
        if (div.getPnlCommon().getPnlDetail().getTxtKeyakukettebi().getValue() != null
                && div.getPnlCommon().getPnlDetail().getRdoKettekubun().getSelectedKey().isEmpty()) {
            throw new ApplicationException(UrErrorMessages.必須.getMessage().replace(決定区分.toString()).evaluate());
        }
        if (ShoninKubun.承認する.getコード().equals(div.getPnlCommon().getPnlDetail()
                .getRdoKettekubun().getSelectedKey())) {
            if (div.getPnlCommon().getPnlDetail().getPnlHidari().getDdlYear().getSelectedKey().isEmpty()) {
                throw new ApplicationException(UrErrorMessages.必須.getMessage().replace(年度.toString()).evaluate());
            }
            if (div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtBango1().getValue() == null
                    || div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtBango1().getValue().toString().isEmpty()
                    || div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtBango2().getValue() == null
                    || div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtBango2().getValue().toString().isEmpty()) {
                throw new ApplicationException(UrErrorMessages.必須.getMessage().replace(番号.toString()).evaluate());
            }
            if (is受領委任契約番号重複(画面モード, キー, shokan)) {
                throw new ApplicationException(UrErrorMessages.既に存在.getMessage()
                        .replace(受領委任契約番号.toString()).evaluate());
            }
        } else if (ShoninKubun.承認しない.getコード().equals(div.getPnlCommon().getPnlDetail()
                .getRdoKettekubun().getSelectedKey())
                && div.getPnlCommon().getPnlDetail().getTxtFusyoninriyu().getValue().isEmpty()) {
            throw new ApplicationException(UrErrorMessages.必須.getMessage().replace(不承認理由.toString()).evaluate());
        }
        if (is存在チェック(画面モード, キー, shokan)) {
            throw new ApplicationException(UrErrorMessages.既に登録済.getMessage()
                    .replace(償還受領委任契約者.toString()).evaluate());
        }
    }

    private boolean is受領委任契約番号重複(RString 画面モード, TaishoshaKey キー, ShokanJuryoininKeiyakusha shokan) {
        ShokanJuryoininKeiyakushaFinder finder = InstanceProvider.create(ShokanJuryoininKeiyakushaFinder.class);
        HihokenshaNo 被保険者番号;
        if (登録.equals(画面モード)) {
            被保険者番号 = キー.get被保険者番号();
        } else {
            被保険者番号 = shokan.get被保険者番号();
        }
        ChkKeiyakuNoParameter parameter = new ChkKeiyakuNoParameter(
                被保険者番号,
                new FlexibleDate(div.getPnlCommon().getPnlDetail()
                        .getTxtKeyakushinseibi().getValue().toDateString()),
                div.getPnlCommon().getPnlDetail().getTxtKeyakujigyosyaNo().getValue(),
                div.getPnlCommon().getPnlDetail().getDdlKeiyakuServiceType().getSelectedKey(),
                new FlexibleYear(div.getPnlCommon().getPnlDetail().getPnlHidari().getDdlYear().getSelectedValue()),
                div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtBango1().getValue() == null ? null
                : new RString(div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtBango1().getValue().toString()),
                div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtBango2().getValue(),
                画面モード);
        return !finder.chkKeiyakuNo(parameter);
    }

    private boolean is存在チェック(RString 画面モード, TaishoshaKey キー, ShokanJuryoininKeiyakusha shokan) {
        ChkTorokuzumiParameter parameter;
        if (div.getPnlCommon().getPnlDetail().getTxtKeyakushinseibi().getValue() == null) {
            return true;
        }
        if (登録.equals(画面モード)) {
            parameter = new ChkTorokuzumiParameter(
                    キー.get被保険者番号(),
                    null,
                    null,
                    null,
                    new FlexibleDate(div.getPnlCommon().getPnlDetail().getTxtKeyakushinseibi().getValue().toDateString()),
                    div.getPnlCommon().getPnlDetail().getTxtKeyakujigyosyaNo().getValue(),
                    div.getPnlCommon().getPnlDetail().getDdlKeiyakuServiceType().getSelectedKey(),
                    画面モード);
        } else {
            parameter = new ChkTorokuzumiParameter(
                    shokan.get被保険者番号(),
                    shokan.get申請年月日(),
                    shokan.get契約事業者番号(),
                    shokan.get契約サービス種類(),
                    new FlexibleDate(div.getPnlCommon().getPnlDetail().getTxtKeyakushinseibi().getValue().toDateString()),
                    div.getPnlCommon().getPnlDetail().getTxtKeyakujigyosyaNo().getValue(),
                    div.getPnlCommon().getPnlDetail().getDdlKeiyakuServiceType().getSelectedKey(),
                    画面モード);
        }
        ShokanJuryoininKeiyakushaFinder finder = InstanceProvider.create(ShokanJuryoininKeiyakushaFinder.class);
        return !finder.chkTorokuzumi(parameter);
    }

    /**
     * パラメータを作成する。
     *
     * @param キー TaishoshaKey
     * @return PnlTotalPanelParameter パラメータ
     */
    public PnlTotalPanelParameter createParameter(TaishoshaKey キー) {
        PnlTotalPanelParameter parameter = new PnlTotalPanelParameter(
                キー.get識別コード(),
                キー.get被保険者番号().getColumnValue(),
                div.getPnlCommon().getPnlDetail().getTxtKeyakushinseuketukebi().getValue(),
                div.getPnlCommon().getPnlDetail().getTxtKeyakushinseibi().getValue(),
                div.getPnlCommon().getPnlDetail().getTxtKeyakujigyosyaNo().getValue(),
                div.getPnlCommon().getPnlDetail().getTxtKeyakujigyosyaName().getValue(),
                div.getPnlCommon().getPnlDetail().getDdlKeiyakuServiceType().getSelectedKey(),
                div.getPnlCommon().getPnlDetail().getTxtKeyakukettebi().getValue(),
                div.getPnlCommon().getPnlDetail().getRdoKettekubun().getSelectedKey(),
                div.getPnlCommon().getPnlDetail().getTxtFusyoninriyu().getValue(),
                div.getPnlCommon().getPnlDetail().getPnlHidari().getDdlYear().getSelectedKey(),
                div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtBango1().getValue(),
                div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtBango2().getValue(),
                div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtSyoninkikan().getFromValue(),
                div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtSyoninkikan().getToValue(),
                div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtSyoninchutisyosakuseibi().getValue(),
                div.getPnlCommon().getPnlDetail().getPnlHidari().getChkSaihakoukubun()
                .isAllSelected() ? 承認通知書再発行区分キー_1 : 承認通知書再発行区分キー_0,
                div.getPnlCommon().getPnlDetail().getPnlFoot().getTxtShikyuumukubun().getValue(),
                div.getPnlCommon().getPnlDetail().getPnlFoot().getTxtServiceYM().getDomain(),
                div.getPnlCommon().getPnlDetail().getPnlFoot().getTxtSyokanseriNo().getValue(),
                div.getPnlCommon().getPnlDetail().getPnlFoot().getTxtBikou().getValue(),
                div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHiyogakugokei().getValue(),
                div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtRiyosyajikofutangaku().getValue(),
                div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokentaisyohiyogaku().getValue(),
                div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokenkyufuhiyogaku().getValue());
        return parameter;
    }

    /**
     * 保存処理メソッド
     *
     * @param 画面モード RString
     * @param キー TaishoshaKey
     * @param shokan ShokanJuryoininKeiyakusha
     */
    public void 保存処理(RString 画面モード, TaishoshaKey キー, ShokanJuryoininKeiyakusha shokan) {
        ShokanJuryoininKeiyakushaFinder finder = ShokanJuryoininKeiyakushaFinder.createInstance();
        if (登録.equals(画面モード)) {
            ShokanJuryoininKeiyakusha newShokan = new ShokanJuryoininKeiyakusha(
                    キー.get被保険者番号(),
                    new FlexibleDate(div.getPnlCommon().getPnlDetail().getTxtKeyakushinseibi().getValue().toDateString()),
                    div.getPnlCommon().getPnlDetail().getTxtKeyakujigyosyaNo().getValue(),
                    div.getPnlCommon().getPnlDetail().getDdlKeiyakuServiceType().getSelectedKey());
            newShokan = build契約者情報(newShokan);
            finder.insShokanJuryoininKeiyakusha(newShokan);
        } else {
            if (修正.equals(画面モード)) {
                finder.updShokanJuryoininKeiyakusha(build契約者情報(shokan));
            } else if (削除.equals(画面モード)) {
                finder.delShokanJuryoininKeiyakusha(shokan);
            }
        }
    }

    /**
     * 契約者情報build
     *
     * @param shokan ShokanJuryoininKeiyakusha
     * @return ShokanJuryoininKeiyakusha
     */
    private ShokanJuryoininKeiyakusha build契約者情報(ShokanJuryoininKeiyakusha shokan) {
        ShokanJuryoininKeiyakushaBuilder builder = shokan.createBuilderForEdit();
        builder.set受付年月日(new FlexibleDate(div.getPnlCommon().getPnlDetail().getTxtKeyakushinseuketukebi()
                .getValue().toDateString()));
        if (div.getPnlCommon().getPnlDetail().getTxtKeyakukettebi().getValue() == null) {
            builder.set決定年月日(null);
            builder.set承認結果区分(null);
            builder.set受領委任払適用開始年月日(null);
            builder.set契約番号(null);
            builder.set不承認理由(null);
            builder.set費用額合計(null);
            builder.set保険対象費用額(null);
            builder.set利用者自己負担額(null);
            builder.set保険給付費額(null);
        } else {
            builder.set決定年月日(new FlexibleDate(div.getPnlCommon().getPnlDetail().getTxtKeyakukettebi()
                    .getValue().toDateString()));
            if (ShoninKubun.承認しない.getコード().equals(div.getPnlCommon().getPnlDetail()
                    .getRdoKettekubun().getSelectedKey())) {
                builder.set承認結果区分(null);
                builder.set受領委任払適用開始年月日(null);
                builder.set契約番号(null);
                builder.set不承認理由(div.getPnlCommon().getPnlDetail().getTxtFusyoninriyu().getValue());
                builder.set費用額合計(null);
                builder.set保険対象費用額(null);
                builder.set利用者自己負担額(null);
                builder.set保険給付費額(null);
            } else if (ShoninKubun.承認する.getコード().equals(div.getPnlCommon().getPnlDetail()
                    .getRdoKettekubun().getSelectedKey())) {
                builder.set承認結果区分(ShoninKubun.承認する.getコード());
                builder.set受領委任払適用開始年月日(div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtSyoninkikan()
                        .getFromValue() == null ? null : new FlexibleDate(div.getPnlCommon().getPnlDetail()
                                .getPnlHidari().getTxtSyoninkikan().getFromValue().toDateString()));
                builder.set受領委任払適用終了年月日(div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtSyoninkikan()
                        .getToValue() == null ? null : new FlexibleDate(div.getPnlCommon().getPnlDetail().getPnlHidari()
                                .getTxtSyoninkikan().getToValue().toDateString()));
                RStringBuilder rsb = new RStringBuilder();
                rsb.append(div.getPnlCommon().getPnlDetail().getPnlHidari().getDdlYear().getSelectedValue());
                rsb.append(div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtBango1().getValue());
                rsb.append(div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtBango2().getValue());
                builder.set契約番号(rsb.toRString());
                builder.set不承認理由(null);
                builder.set承認結果通知書再発行区分(get承認結果通知書再発行区分());
                builder.set費用額合計(div.getPnlCommon().getPnlDetail().getPnlKyufuhi()
                        .getTxtHiyogakugokei().getValue());
                builder.set保険対象費用額(div.getPnlCommon().getPnlDetail().getPnlKyufuhi()
                        .getTxtHokentaisyohiyogaku().getValue());
                builder.set利用者自己負担額(div.getPnlCommon().getPnlDetail().getPnlKyufuhi()
                        .getTxtRiyosyajikofutangaku().getValue());
                builder.set保険給付費額(div.getPnlCommon().getPnlDetail().getPnlKyufuhi()
                        .getTxtHokenkyufuhiyogaku().getValue());
            }
        }
        if (div.getPnlCommon().getPnlDetail().getPnlFoot().getTxtBikou().getValue().isNullOrEmpty()) {
            builder.set備考(null);
        } else {
            builder.set備考(div.getPnlCommon().getPnlDetail().getPnlFoot().getTxtBikou().getValue());
        }
        return builder.build();
    }

    private RString get承認結果通知書再発行区分() {
        if (div.getPnlCommon().getPnlDetail().getPnlHidari().getChkSaihakoukubun().isAllSelected()) {
            return 承認通知書再発行区分キー_1;
        } else {
            return 承認通知書再発行区分キー_0;
        }
    }
}
