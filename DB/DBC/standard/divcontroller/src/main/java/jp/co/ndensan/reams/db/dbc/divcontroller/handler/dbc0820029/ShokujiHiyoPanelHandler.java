/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0820029;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanMeisai;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShokujiHiyo;
import jp.co.ndensan.reams.db.dbc.business.core.syokanbaraihishikyushinseikette.ShokanKihonParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820029.ShokujiHiyoPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820029.dgdShokuji_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.syokanbaraihishikyushinseikette.SyokanbaraihishikyushinseiketteParameter;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ServiceCodeInputCommonChildDiv.ServiceCodeInputCommonChildDivDiv;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.IconName;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 償還払い費支給申請決定_サービス提供証明書(食事費用）の画面クラスです。
 */
public class ShokujiHiyoPanelHandler {

    private final ShokujiHiyoPanelDiv div;
    private static final RString 設定不可 = new RString("0");
    private static final RString 設定可必須 = new RString("1");
    private static final RString 設定可任意 = new RString("2");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");
    private static final RString 半角スペース = new RString(" ");
    private static final int ZERO = 0;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int SEVEN = 7;
    private static final FlexibleYearMonth 平成１５年３月 = new FlexibleYearMonth("200303");
    private static final FlexibleYearMonth 平成17年９月 = new FlexibleYearMonth("200509");

    /**
     * ShokujiHiyoHandlerのメソッド
     *
     * @param div ShokujiHiyoPanelDiv
     */
    public ShokujiHiyoPanelHandler(ShokujiHiyoPanelDiv div) {
        this.div = div;
    }

    /**
     * selectRowのメソッド
     *
     * @return dgdShokuji_Row
     */
    public dgdShokuji_Row selectRow() {
        return div.getPanelShokuji().getPanelShoikujiList()
                .getDgdShokuji().getDataSource().get(Integer.parseInt(
                                div.getPanelShokuji().getRowId().toString()));
    }

    /**
     * 保存処理confirmのメソッド
     *
     * @param row dgdShokuji_Row
     */
    public void confirm(dgdShokuji_Row row) {
        RString state = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        if (修正.equals(state)) {
            if (RowState.Added.equals(row.getRowState())) {
                row.setRowState(RowState.Added);
                set食事費用登録グリッド(row);
            } else {
                modifiedConfirm(row);
            }
        } else if (削除.equals(state)) {
            if (RowState.Added.equals(row.getRowState())) {
                div.getPanelShokuji().getPanelShoikujiList().getDgdShokuji().getDataSource().remove(row);
            } else {
                row.setRowState(RowState.Deleted);
                set食事費用登録グリッド(row);
            }
        } else if (登録.equals(state)) {
            List<dgdShokuji_Row> list = div.getPanelShokuji().getPanelShoikujiList().getDgdShokuji().getDataSource();
            row.setRowState(RowState.Added);
            set食事費用登録グリッド(row);
            list.add(row);
        }
    }

    /**
     * modifiedconfirm
     *
     * @param row dgdShokuji_Row
     */
    private void modifiedConfirm(dgdShokuji_Row row) {
        boolean flag = modifiedCheck(row);
        if (flag) {
            row.setRowState(RowState.Modified);
            set食事費用登録グリッド(row);
        }
    }

    /**
     * modifiedCheck
     *
     * @param row dgdShokuji_Row
     * @return boolean
     */
    private boolean modifiedCheck(dgdShokuji_Row row) {
        ServiceCodeInputCommonChildDivDiv serviceCodeInputDiv = (ServiceCodeInputCommonChildDivDiv) div
                .getPanelShokuji().getPanelDetail2().getCcdServiceCodeInput();
        RString サービス種類コード = serviceCodeInputDiv.getTxtServiceCode1().getValue();
        RString サービス項目コード = serviceCodeInputDiv.getTxtServiceCode2().getValue();
        RStringBuilder builder = new RStringBuilder();
        builder.append(サービス種類コード).append(半角スペース).append(サービス項目コード);
        if (!row.getDefaultDataName2().equals(builder.toString())) {
            return true;
        }
        if (!row.getDefaultDataName3().getValue().equals(
                div.getPanelShokuji().getPanelDetail2().getTxtTanyi().getValue())) {
            return true;
        }
        if (!row.getDefaultDataName4().equals(new RString(
                div.getPanelShokuji().getPanelDetail2().getTxtKaisuuNisuu().getValue().toString()))) {
            return true;
        }
        return (row.getDefaultDataName5().getValue().equals(
                div.getPanelShokuji().getPanelDetail2().getBtnKinngaku().getValue()));

    }

    /**
     * set食事費用登録グリッド
     *
     * @param row dgdShokuji_Row
     */
    public void set食事費用登録グリッド(dgdShokuji_Row row) {
        ServiceCodeInputCommonChildDivDiv serviceCodeInputDiv = (ServiceCodeInputCommonChildDivDiv) div
                .getPanelShokuji().getPanelDetail2().getCcdServiceCodeInput();
//        RString サービス種類コード = serviceCodeInputDiv.getTxtServiceCode1().getValue();
//        RString サービス種類コード = new RString("50");
//        RString サービス項目コード = serviceCodeInputDiv.getTxtServiceCode2().getValue();
//        RStringBuilder builder = new RStringBuilder();
//        builder.append(サービス種類コード).append(半角スペース).append(サービス項目コード);
//        row.setDefaultDataName2(builder.toRString());
        RStringBuilder builder = new RStringBuilder();
        builder.append(50);
        builder.append(半角スペース);
        if (serviceCodeInputDiv.getTxtServiceCode2() != null) {
            builder.append(serviceCodeInputDiv.getTxtServiceCode2().getValue());
        }
        row.setDefaultDataName2(builder.toRString());
        if (div.getPanelShokuji().getPanelDetail2().getTxtTanyi().getValue() != null) {
            row.getDefaultDataName3().setValue(div.getPanelShokuji().getPanelDetail2().getTxtTanyi().getValue());
        }
        if (div.getPanelShokuji().getPanelDetail2().getTxtKaisuuNisuu().getValue() != null) {
            row.setDefaultDataName4(new RString(
                    div.getPanelShokuji().getPanelDetail2().getTxtKaisuuNisuu().getValue().toString()));
        }
        if (div.getPanelShokuji().getPanelDetail2().getBtnKinngaku().getValue() != null) {
            row.getDefaultDataName5().setValue(div.getPanelShokuji().getPanelDetail2().getBtnKinngaku().getValue());
        }

    }

    /**
     * 集計するのメソッド
     */
    public void 集計する() {
        Decimal 食事提供延べ日数 = Decimal.ZERO;
        Decimal 食事提供費合計 = Decimal.ZERO;
        List<dgdShokuji_Row> dgrow = div.getPanelShokuji().getPanelShoikujiList().getDgdShokuji().getDataSource();
        for (dgdShokuji_Row row : dgrow) {
            if (!row.getDefaultDataName4().toString().isEmpty()) {
                食事提供延べ日数 = 食事提供延べ日数.add(new Decimal(row.getDefaultDataName4().toString()));
            }
            if (!row.getDefaultDataName5().toString().isEmpty()) {
                食事提供費合計 = 食事提供費合計.add(row.getDefaultDataName5().getValue());
            }
        }
        Decimal 標準負担額_日額 = ViewStateHolder.get(ViewStateKeys.償還払請求食事費用データ1, Decimal.class);
        Decimal 標準負担_月額 = 食事提供延べ日数.multiply(標準負担額_日額);
        Decimal 食事提供費請求額 = 食事提供費合計.subtract(標準負担_月額);
        div.getPanelShokuji().getPanelDetailGokei().getTxtTeikyouHisu().setValue(食事提供延べ日数);
        div.getPanelShokuji().getPanelDetailGokei().getTxtHigaku().setValue(標準負担額_日額);
        div.getPanelShokuji().getPanelDetailGokei().getTxtGetsugaku().setValue(標準負担_月額);
        div.getPanelShokuji().getPanelDetailGokei().getTxtTeikyohiGokei().setValue(食事提供費合計);
        div.getPanelShokuji().getPanelDetailGokei().getTxtShokujiShiseigaku().setValue(食事提供費請求額);
    }

    /**
     * 計算するのメソッド
     */
    public void 計算する() {
        Decimal 基本提供金額, 特別食提供金額, 食事提供延べ日数, 標準負担_月額, 食事提供費合計, 食事提供費請求額;
        基本提供金額 = div.getPanelShokuji().getPanelDetail1().getTxtKihonNissu().getValue().multiply(
                div.getPanelShokuji().getPanelDetail1().getTxtKihonTanka().getValue());
        特別食提供金額 = div.getPanelShokuji().getPanelDetail1().getTxtTokubetuSyokuNissu().getValue().multiply(
                div.getPanelShokuji().getPanelDetail1().getTxtTokubetuSyokuTanka().getValue());
        食事提供延べ日数 = div.getPanelShokuji().getPanelDetail1().getTxtKihonNissu().getValue().add(
                div.getPanelShokuji().getPanelDetail1().getTxtTokubetuSyokuNissu().getValue());
        標準負担_月額 = div.getPanelShokuji().getPanelDetail1().getTxtShokujiTeikyoTotalNissu().getValue().multiply(
                div.getPanelShokuji().getPanelDetail1().getTxtnichigakuHyojunFutangaku().getValue());
        食事提供費合計 = 基本提供金額.add(特別食提供金額);
        食事提供費請求額 = 食事提供費合計.subtract(標準負担_月額);
        div.getPanelShokuji().getPanelDetail1().getTxtKihonKingaku().setValue(基本提供金額);
        div.getPanelShokuji().getPanelDetail1().getTxtTokubetuSyokuKinngaku().setValue(特別食提供金額);
        div.getPanelShokuji().getPanelDetail1().getTxtShokujiTeikyoTotalNissu().setValue(食事提供延べ日数);
        div.getPanelShokuji().getPanelDetail1().getTxtgetsugakuHyojunFutangaku().setValue(標準負担_月額);
        div.getPanelShokuji().getPanelDetail1().getTxtShokujiTeikyohiTotal().setValue(食事提供費合計);
        div.getPanelShokuji().getPanelDetail1().getTxtshokujiTeikyohiSeikyugaku().setValue(食事提供費請求額);
    }

    /**
     * 計算する2のメソッド
     */
    public void 計算する2() {
        Decimal 金額;
        if (div.getPanelShokuji().getPanelDetail2().getTxtTanyi().getValue() != null
                && div.getPanelShokuji().getPanelDetail2().getTxtKaisuuNisuu().getValue() != null) {
            金額 = div.getPanelShokuji().getPanelDetail2().getTxtTanyi().getValue().multiply(
                    div.getPanelShokuji().getPanelDetail2().getTxtKaisuuNisuu().getValue());
            div.getPanelShokuji().getPanelDetail2().getBtnKinngaku().setValue(金額);
        }
    }

    /**
     * clear食事費用登録エリア１のメソッド
     */
    public void clear食事費用登録エリア１() {
        div.getPanelShokuji().getPanelDetail1().getTxtKihonNissu().clearValue();
        div.getPanelShokuji().getPanelDetail1().getTxtKihonTanka().clearValue();
        div.getPanelShokuji().getPanelDetail1().getTxtKihonKingaku().clearValue();
        div.getPanelShokuji().getPanelDetail1().getTxtTokubetuSyokuNissu().clearValue();
        div.getPanelShokuji().getPanelDetail1().getTxtTokubetuSyokuTanka().clearValue();
        div.getPanelShokuji().getPanelDetail1().getTxtTokubetuSyokuKinngaku().clearValue();
        div.getPanelShokuji().getPanelDetail1().getTxtShokujiTeikyoTotalNissu().clearValue();
        div.getPanelShokuji().getPanelDetail1().getTxtShokujiTeikyohiTotal().clearValue();
        div.getPanelShokuji().getPanelDetail1().getTxtnichigakuHyojunFutangaku().clearValue();
        div.getPanelShokuji().getPanelDetail1().getTxtgetsugakuHyojunFutangaku().clearValue();
        div.getPanelShokuji().getPanelDetail1().getTxtshokujiTeikyohiSeikyugaku().clearValue();
    }

    /**
     * putViewStateのメソッド
     */
    public void putViewState() {
        // TODO 支給申請画面のモード　
        ViewStateHolder.put(ViewStateKeys.処理モード, "");
        ViewStateHolder.put(ViewStateKeys.申請日, div.getPanelHead().getTxtShinseiYMD().getValue());
        SyokanbaraihishikyushinseiketteParameter paramter = new SyokanbaraihishikyushinseiketteParameter(
                ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class),
                new FlexibleYearMonth(div.getPanelHead().getTxtServiceTeikyoYM().getValue().toDateString()),
                ViewStateHolder.get(ViewStateKeys.整理番号, RString.class),
                new JigyoshaNo(div.getPanelHead().getTxtJigyoshaBango().getValue()),
                div.getPanelHead().getTxtShomeisho().getValue(),
                div.getPanelHead().getTxtMeisaiBango().getValue(),
                null);
        ViewStateHolder.put(ViewStateKeys.償還払費申請明細検索キー, paramter);
    }

    /**
     * modifyRowのメソッド
     *
     * @param row dgdShokuji_Row
     */
    public void modifyRow(dgdShokuji_Row row) {
        RString state = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        if (修正.equals(state)) {
            row.setRowState(RowState.Modified);
        } else if (削除.equals(state)) {
            row.setRowState(RowState.Deleted);
        } else if (登録.equals(state)) {
            row.setRowState(RowState.Added);
        }
        clear食事費用登録エリア１();
        div.getPanelShokuji().getPanelDetail1().setVisible(false);
    }

    /**
     * clear食事費用登録エリア2のメソッド
     */
    public void clear食事費用登録エリア2() {
        ServiceCodeInputCommonChildDivDiv serviceCodeInputDiv = (ServiceCodeInputCommonChildDivDiv) div
                .getPanelShokuji().getPanelDetail2().getCcdServiceCodeInput();
        serviceCodeInputDiv.getTxtServiceCode1().clearValue();
        serviceCodeInputDiv.getTxtServiceCode2().clearValue();
        div.getPanelShokuji().getPanelDetail2().getTxtTanyi().clearValue();
        div.getPanelShokuji().getPanelDetail2().getTxtKaisuuNisuu().clearValue();
        div.getPanelShokuji().getPanelDetail2().getBtnKinngaku().clearValue();
    }

    /**
     * setヘッダーエリアのメソッド
     *
     * @param サービス提供年月 FlexibleYearMonth
     * @param 申請日 RString
     * @param 事業者番号 JigyoshaNo
     * @param 明細番号 RString
     * @param 証明書 RString
     */
    public void setヘッダーエリア(
            FlexibleYearMonth サービス提供年月,
            RString 申請日,
            JigyoshaNo 事業者番号,
            RString 明細番号,
            RString 証明書) {
        div.getPanelHead().getTxtServiceTeikyoYM().setValue(new RDate(サービス提供年月.toString()));
        div.getPanelHead().getTxtShinseiYMD().setValue(new RDate(申請日.toString()));
        div.getPanelHead().getTxtJigyoshaBango().setValue(事業者番号.getColumnValue());
        div.getPanelHead().getTxtMeisaiBango().setValue(明細番号);
        div.getPanelHead().getTxtShomeisho().setValue(証明書);
    }

    /**
     * set食事費用登録エリア１のメソッド
     *
     * @param entity ShokanShokujiHiyo
     */
    public void set食事費用登録エリア１(ShokanShokujiHiyo entity) {
        div.getPanelShokuji().getPanelDetail1().getTxtKihonNissu().setValue(
                new Decimal(entity.get基本提供日数()));
        div.getPanelShokuji().getPanelDetail1().getTxtKihonTanka().setValue(
                new Decimal(entity.get基本提供単価()));
        div.getPanelShokuji().getPanelDetail1().getTxtKihonKingaku().setValue(
                new Decimal(entity.get基本提供金額()));
        div.getPanelShokuji().getPanelDetail1().getTxtTokubetuSyokuNissu().setValue(
                new Decimal(entity.get特別提供日数()));
        div.getPanelShokuji().getPanelDetail1().getTxtTokubetuSyokuTanka().setValue(
                new Decimal(entity.get特別提供単価()));
        div.getPanelShokuji().getPanelDetail1().getTxtTokubetuSyokuKinngaku().setValue(
                new Decimal(entity.get特別提供金額()));
        div.getPanelShokuji().getPanelDetail1().getTxtShokujiTeikyoTotalNissu().setValue(
                new Decimal(entity.get食事提供延べ日数()));
        div.getPanelShokuji().getPanelDetail1().getTxtShokujiTeikyohiTotal().setValue(
                new Decimal(entity.get食事提供費合計()));
        div.getPanelShokuji().getPanelDetail1().getTxtnichigakuHyojunFutangaku().setValue(
                new Decimal(entity.get標準負担額_日額()));
        div.getPanelShokuji().getPanelDetail1().getTxtgetsugakuHyojunFutangaku().setValue(
                new Decimal(entity.get標準負担額_月額()));
        div.getPanelShokuji().getPanelDetail1().getTxtshokujiTeikyohiSeikyugaku().setValue(
                new Decimal(entity.get食事提供費請求額()));
    }

    /**
     * set食事費用一覧グリッドのメソッド
     *
     * @param list List<ShokanMeisai> list
     * @param shokanShokujiHiyo ShokanShokujiHiyo
     */
    public void set食事費用一覧グリッド(List<ShokanMeisai> list, ShokanShokujiHiyo shokanShokujiHiyo) {
        List<dgdShokuji_Row> dataSource = new ArrayList<>();
        for (ShokanMeisai entity : list) {
            dgdShokuji_Row dgdShokuji_Row = new dgdShokuji_Row();
            RStringBuilder builder = new RStringBuilder();
            if (entity.getサービス種類コード() != null) {
                builder.append(entity.getサービス種類コード().value());
            }
            builder.append(半角スペース);
            if (entity.getサービス項目コード() != null) {
                builder.append(entity.getサービス項目コード().value());
            }
            dgdShokuji_Row.setDefaultDataName2(builder.toRString());
            dgdShokuji_Row.getDefaultDataName3().setValue(new Decimal(entity.get単位数()));
            dgdShokuji_Row.setDefaultDataName4(DecimalFormatter.toコンマ区切りRString(
                    new Decimal(entity.get日数_回数()), 0));
            dgdShokuji_Row.getDefaultDataName5().setValue(new Decimal(entity.getサービス単位数()));
            dgdShokuji_Row.setDefaultDataName6(entity.get連番());
            dataSource.add(dgdShokuji_Row);
        }
        div.getPanelShokuji().getPanelShoikujiList().getDgdShokuji().setDataSource(dataSource);
        set食事費用合計設定(shokanShokujiHiyo);
    }

    /**
     * set食事費用合計設定のメソッド
     *
     * @param entity ShokanShokujiHiyo
     */
    public void set食事費用合計設定(ShokanShokujiHiyo entity) {
        div.getPanelShokuji().getPanelDetailGokei().getTxtTeikyouHisu()
                .setValue(new Decimal(entity.get食事提供延べ日数()));
        div.getPanelShokuji().getPanelDetailGokei().getTxtHigaku()
                .setValue(new Decimal(entity.get標準負担額_日額()));
        div.getPanelShokuji().getPanelDetailGokei().getTxtGetsugaku()
                .setValue(new Decimal(entity.get標準負担額_月額()));
        div.getPanelShokuji().getPanelDetailGokei().getTxtTeikyohiGokei()
                .setValue(new Decimal(entity.get食事提供費合計()));
        div.getPanelShokuji().getPanelDetailGokei().getTxtShokujiShiseigaku()
                .setValue(new Decimal(entity.get食事提供費請求額()));
    }

    /**
     * get内容変更状態のメソッド
     *
     * @param サービス提供年月 FlexibleYearMonth
     * @return boolean
     */
    public boolean get内容変更状態(FlexibleYearMonth サービス提供年月) {
        if (サービス提供年月.isBeforeOrEquals(平成１５年３月)) {
            return get内容変更状態_1503();
        }
        if (平成１５年３月.isBefore(サービス提供年月) && サービス提供年月.isBeforeOrEquals(平成17年９月)) {
            for (dgdShokuji_Row dgdRow : div.getPanelShokuji().getPanelShoikujiList().
                    getDgdShokuji().getDataSource()) {
                if (RowState.Modified.equals(dgdRow.getRowState())
                        || RowState.Added.equals(dgdRow.getRowState())
                        || RowState.Deleted.equals(dgdRow.getRowState())) {
                    return true;
                }
            }
        }
        if (平成17年９月.isBefore(サービス提供年月)) {
            return get内容変更状態_1709();
        }
        return false;
    }

    /**
     * get内容変更状態_1709
     *
     * @return boolean
     */
    public boolean get内容変更状態_1709() {
        List<ShokanShokujiHiyo> shokanShokujiHiyoList = ViewStateHolder.get(
                ViewStateKeys.償還払請求食事費用データ, List.class);
        ShokanShokujiHiyo shokanShokujiHiyo = shokanShokujiHiyoList.get(0);
        if (shokanShokujiHiyo.get食事提供延べ日数()
                != div.getPanelShokuji().getPanelDetailGokei().getTxtTeikyouHisu().getValue().intValue()) {
            return true;
        }
        if (shokanShokujiHiyo.get標準負担額_日額()
                != div.getPanelShokuji().getPanelDetailGokei().getTxtHigaku().getValue().intValue()) {
            return true;
        }
        if (shokanShokujiHiyo.get標準負担額_月額()
                != div.getPanelShokuji().getPanelDetailGokei().getTxtGetsugaku().getValue().intValue()) {
            return true;
        }
        if (shokanShokujiHiyo.get食事提供費合計()
                != div.getPanelShokuji().getPanelDetailGokei().getTxtTeikyohiGokei().getValue().intValue()) {
            return true;
        }
        return (shokanShokujiHiyo.get食事提供費請求額()
                != div.getPanelShokuji().getPanelDetailGokei().getTxtShokujiShiseigaku().getValue().intValue());
    }

    /**
     * get内容変更状態_1503
     *
     * @return boolean
     */
    public boolean get内容変更状態_1503() {
        List<ShokanShokujiHiyo> shokanShokujiHiyoList = ViewStateHolder.get(
                ViewStateKeys.償還払請求食事費用データ, List.class);

        if (shokanShokujiHiyoList != null && !shokanShokujiHiyoList.isEmpty()) {
            ShokanShokujiHiyo shokanShokujiHiyo = shokanShokujiHiyoList.get(0);
            if (shokanShokujiHiyo.get基本提供日数()
                    != div.getPanelShokuji().getPanelDetail1().getTxtKihonNissu().getValue().intValue()) {
                return true;
            }
            if (shokanShokujiHiyo.get基本提供単価()
                    != div.getPanelShokuji().getPanelDetail1().getTxtKihonTanka().getValue().intValue()) {
                return true;
            }
            if (shokanShokujiHiyo.get基本提供金額()
                    != div.getPanelShokuji().getPanelDetail1().getTxtKihonKingaku().getValue().intValue()) {
                return true;
            }
            if (shokanShokujiHiyo.get特別提供日数()
                    != div.getPanelShokuji().getPanelDetail1().getTxtTokubetuSyokuNissu().getValue().intValue()) {
                return true;
            }
            if (shokanShokujiHiyo.get特別提供単価()
                    != div.getPanelShokuji().getPanelDetail1().getTxtTokubetuSyokuKinngaku().getValue().intValue()) {
                return true;
            }
            if (shokanShokujiHiyo.get特別提供金額()
                    != div.getPanelShokuji().getPanelDetail1().getTxtTokubetuSyokuKinngaku().getValue().intValue()) {
                return true;
            }
            if (shokanShokujiHiyo.get食事提供延べ日数()
                    != div.getPanelShokuji().getPanelDetail1().getTxtShokujiTeikyoTotalNissu().getValue().intValue()) {
                return true;
            }
            if (shokanShokujiHiyo.get食事提供費合計()
                    != div.getPanelShokuji().getPanelDetail1().getTxtShokujiTeikyohiTotal().getValue().intValue()) {
                return true;
            }
            if (shokanShokujiHiyo.get標準負担額_日額()
                    != div.getPanelShokuji().getPanelDetail1().getTxtnichigakuHyojunFutangaku().getValue().intValue()) {
                return true;
            }
            if (shokanShokujiHiyo.get標準負担額_月額()
                    != div.getPanelShokuji().getPanelDetail1().getTxtgetsugakuHyojunFutangaku().getValue().intValue()) {
                return true;
            }
            return (shokanShokujiHiyo.get食事提供費請求額()
                    != div.getPanelShokuji().getPanelDetail1().getTxtshokujiTeikyohiSeikyugaku().getValue().intValue());
        } else {
            return true;
        }

    }

    /**
     * ボタン制御
     *
     * @param shikibetsuNoKanri ShikibetsuNoKanri
     */
    public void getボタンを制御(ShikibetsuNoKanri shikibetsuNoKanri) {
        SyokanbaraihishikyushinseiketteParameter paramter = ViewStateHolder.get(ViewStateKeys.償還払費申請明細検索キー,
                SyokanbaraihishikyushinseiketteParameter.class);
        HihokenshaNo 被保険者番号 = paramter.getHiHokenshaNo();
        FlexibleYearMonth サービス年月 = paramter.getServiceTeikyoYM();
        RString 整理番号 = paramter.getSeiriNp();
        JigyoshaNo 事業者番号 = paramter.getJigyoshaNo();
        RString 様式番号 = paramter.getYoshikiNo();
        RString 明細番号 = paramter.getMeisaiNo();
        set基本情報ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set給付費明細ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set特定診療費ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        setサービス計画費ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set特定入所者費用ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        div.getPanelHead().getBtnGoukeiInfo().setDisabled(false);
        set給付費明細_住特ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set緊急時_所定疾患ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set緊急時施設療養費ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set請求額集計ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set社福軽減額ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
    }

    /**
     * 保存処理 のメソッド
     */
    public void 保存処理() {

        SyokanbaraihishikyushinseiketteParameter paramter = ViewStateHolder.get(ViewStateKeys.償還払費申請明細検索キー,
                SyokanbaraihishikyushinseiketteParameter.class);
        HihokenshaNo 被保険者番号 = paramter.getHiHokenshaNo();
        FlexibleYearMonth サービス提供年月 = paramter.getServiceTeikyoYM();
        RString 整理番号 = paramter.getSeiriNp();
        JigyoshaNo 事業者番号 = paramter.getJigyoshaNo();
        RString 様式番号 = paramter.getYoshikiNo();
        RString 明細番号 = paramter.getMeisaiNo();
        ShokanKihonParameter par = ShokanKihonParameter.createSelectByKeyParam(
                被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号, 0);

        if (削除.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            SyokanbaraihiShikyuShinseiKetteManager.createInstance().delShokanSyomeisyo(
                    被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        } else {
            if (サービス提供年月.isBeforeOrEquals(平成１５年３月)) {

                List<ShokanShokujiHiyo> shokanShokujiHiyoList = ViewStateHolder
                        .get(ViewStateKeys.償還払請求食事費用データ, List.class);
                if (!shokanShokujiHiyoList.isEmpty()) {
                    ShokanShokujiHiyo shokanShokujiHiyo = shokanShokujiHiyoList.get(0);
                    shokanShokujiHiyo = build食事費用登録1(shokanShokujiHiyo);
                    SyokanbaraihiShikyuShinseiKetteManager.createInstance()
                            .updShokanShokujiHiyo(shokanShokujiHiyo, null, par);
                } else {
                    ShokanShokujiHiyo shokanShokujiHiyo = build_new_食事費用登録1();
                    SyokanbaraihiShikyuShinseiKetteManager.createInstance()
                            .updShokanShokujiHiyo(shokanShokujiHiyo, null, par);
                }

            } else if (平成１５年３月.isBefore(サービス提供年月)
                    && サービス提供年月.isBeforeOrEquals(平成17年９月)) {
                int max連番 = 0;
                List<ShokanMeisai> shokanMeisaiList = ViewStateHolder.get(
                        ViewStateKeys.償還払請求食事費用, List.class);
                Map<RString, ShokanMeisai> map = new HashMap<>();
                for (ShokanMeisai entity : shokanMeisaiList) {
                    map.put(entity.get連番(), entity);
                    if (max連番 < Integer.valueOf(entity.get連番().toString())) {
                        max連番 = Integer.valueOf(entity.get連番().toString());
                    }
                }
                for (dgdShokuji_Row dgd : div.getPanelShokuji().getPanelShoikujiList().
                        getDgdShokuji().getDataSource()) {
                    if (RowState.Modified.equals(dgd.getRowState())) {
                        ShokanMeisai entityModified = map.get(dgd.getDefaultDataName6());
                        entityModified = entityModified.createBuilderForEdit().build();
                        entityModified = buildShokanMeisai(entityModified, dgd);
                        shokanMeisaiList.add(entityModified);
                    } else if (RowState.Deleted.equals(dgd.getRowState())) {
                        ShokanMeisai entityDeleted = map.get(dgd.getDefaultDataName6());
                        entityDeleted = entityDeleted.deleted();
                        shokanMeisaiList.add(entityDeleted);
                    } else if (RowState.Added.equals(dgd.getRowState())) {
                        max連番 = max連番 + 1;
                        ShokanMeisai entityAdded = new ShokanMeisai(
                                被保険者番号,
                                サービス提供年月,
                                整理番号,
                                事業者番号,
                                様式番号,
                                明細番号,
                                new RString(String.valueOf(max連番))).createBuilderForEdit().build();
                        entityAdded = buildShokanMeisai(entityAdded, dgd);
                        shokanMeisaiList.add(entityAdded);
                    } else {
                        ShokanMeisai entityUnchanged = map.get(dgd.getDefaultDataName6());
                        shokanMeisaiList.add(entityUnchanged);
                    }
                }

                List<ShokanShokujiHiyo> shokanShokujiHiyoList = ViewStateHolder
                        .get(ViewStateKeys.償還払請求食事費用データ, List.class);
                if (!shokanShokujiHiyoList.isEmpty()) {
                    ShokanShokujiHiyo shokanShokujiHiyo = shokanShokujiHiyoList.get(0);
                    shokanShokujiHiyo = build食事費用合計設定(shokanShokujiHiyo);
                    SyokanbaraihiShikyuShinseiKetteManager.createInstance()
                            .updShokanShokujiHiyo(shokanShokujiHiyo, shokanMeisaiList, par);
                } else {
                    ShokanShokujiHiyo shokanShokujiHiyo = build_new_食事費用合計設定();
                    SyokanbaraihiShikyuShinseiKetteManager.createInstance()
                            .updShokanShokujiHiyo(shokanShokujiHiyo, shokanMeisaiList, par);
                }

            } else if (平成17年９月.isBefore(サービス提供年月)) {
                List<ShokanShokujiHiyo> shokanShokujiHiyoList = ViewStateHolder
                        .get(ViewStateKeys.償還払請求食事費用データ, List.class);
                if (!shokanShokujiHiyoList.isEmpty()) {
                    ShokanShokujiHiyo shokanShokujiHiyo = shokanShokujiHiyoList.get(0);
                    shokanShokujiHiyo = build食事費用合計設定(shokanShokujiHiyo);
                    SyokanbaraihiShikyuShinseiKetteManager.createInstance()
                            .updShokanShokujiHiyo(shokanShokujiHiyo, null, par);
                } else {
                    ShokanShokujiHiyo shokanShokujiHiyo = build_new_食事費用合計設定();
                    shokanShokujiHiyo = build食事費用合計設定(shokanShokujiHiyo);
                    SyokanbaraihiShikyuShinseiKetteManager.createInstance()
                            .updShokanShokujiHiyo(shokanShokujiHiyo, null, par);
                }
            }
        }

    }

    /**
     * buildShokanMeisaiのメソッド
     *
     * @param entityModified ShokanMeisai
     * @param dgd dgdShokuji_Row
     * @return ShokanMeisai
     */
    public ShokanMeisai buildShokanMeisai(ShokanMeisai entityModified, dgdShokuji_Row dgd) {

        if (!dgd.getDefaultDataName2().isEmpty()) {
            RString serviceCodeShuruyi = new RString(dgd.getDefaultDataName2().subSequence(ZERO, TWO).toString());
            RString serviceCodeKoumoku = new RString(dgd.getDefaultDataName2().subSequence(THREE, SEVEN).toString());
            ServiceCodeInputCommonChildDivDiv serviceCodeInputDiv = (ServiceCodeInputCommonChildDivDiv) div
                    .getPanelShokuji().getPanelDetail2().getCcdServiceCodeInput();
            serviceCodeInputDiv.getTxtServiceCode1().setValue(serviceCodeShuruyi);
            serviceCodeInputDiv.getTxtServiceCode2().setValue(serviceCodeKoumoku);
            entityModified = entityModified.createBuilderForEdit().setサービス種類コード(
                    new ServiceShuruiCode(serviceCodeShuruyi.toString())).build();
            entityModified = entityModified.createBuilderForEdit().setサービス項目コード(
                    new ServiceKomokuCode(serviceCodeKoumoku.toString())).build();
        }

        if (dgd.getDefaultDataName3().getValue() != null) {
            entityModified = entityModified.createBuilderForEdit().set単位数(
                    dgd.getDefaultDataName3().getValue().intValue()).build();
        }
        if (!dgd.getDefaultDataName4().isEmpty()) {
            entityModified = entityModified.createBuilderForEdit().set日数_回数(
                    Integer.parseInt(dgd.getDefaultDataName4().toString())).build();
        }
        if (dgd.getDefaultDataName5().getValue() != null) {
            entityModified = entityModified.createBuilderForEdit().setサービス単位数(dgd
                    .getDefaultDataName5().getValue().intValue()).build();
        }
        return entityModified;
    }

    /**
     * build_new_食事費用登録1のメソッド
     *
     * @return ShokanShokujiHiyo
     */
    public ShokanShokujiHiyo build_new_食事費用登録1() {
        SyokanbaraihishikyushinseiketteParameter paramter = ViewStateHolder.get(ViewStateKeys.償還払費申請明細検索キー,
                SyokanbaraihishikyushinseiketteParameter.class);
        HihokenshaNo 被保険者番号 = paramter.getHiHokenshaNo();
        FlexibleYearMonth サービス提供年月 = paramter.getServiceTeikyoYM();
        RString 整理番号 = paramter.getSeiriNp();
        JigyoshaNo 事業者番号 = paramter.getJigyoshaNo();
        RString 様式番号 = paramter.getYoshikiNo();
        RString 明細番号 = paramter.getMeisaiNo();
        ShokanShokujiHiyo shokanShokujiHiyo = new ShokanShokujiHiyo(
                被保険者番号,
                サービス提供年月,
                整理番号,
                事業者番号,
                様式番号,
                明細番号,
                new RString("1")).createBuilderForEdit().set基本提供日数(Integer.parseInt(
                                div.getPanelShokuji().getPanelDetail1()
                                .getTxtKihonNissu().getValue().toString()))
                .set基本提供単価(Integer.parseInt(
                                div.getPanelShokuji().getPanelDetail1()
                                .getTxtKihonTanka().getValue().toString()))
                .set基本提供金額(Integer.parseInt(
                                div.getPanelShokuji().getPanelDetail1()
                                .getTxtKihonKingaku().getValue().toString()))
                .set特別提供日数(Integer.parseInt(
                                div.getPanelShokuji().getPanelDetail1()
                                .getTxtTokubetuSyokuNissu().getValue().toString()))
                .set特別提供単価(Integer.parseInt(
                                div.getPanelShokuji().getPanelDetail1()
                                .getTxtTokubetuSyokuTanka().getValue().toString()))
                .set特別提供金額(Integer.parseInt(
                                div.getPanelShokuji().getPanelDetail1()
                                .getTxtTokubetuSyokuKinngaku().getValue().toString()))
                .set食事提供延べ日数(Integer.parseInt(
                                div.getPanelShokuji().getPanelDetail1()
                                .getTxtShokujiTeikyoTotalNissu().getValue().toString()))
                .set食事提供費合計(Integer.parseInt(
                                div.getPanelShokuji().getPanelDetail1()
                                .getTxtShokujiTeikyohiTotal().getValue().toString()))
                .set標準負担額_日額(Integer.parseInt(
                                div.getPanelShokuji().getPanelDetail1()
                                .getTxtnichigakuHyojunFutangaku().getValue().toString()))
                .set標準負担額_月額(Integer.parseInt(
                                div.getPanelShokuji().getPanelDetail1()
                                .getTxtgetsugakuHyojunFutangaku().getValue().toString()))
                .set食事提供費請求額(Integer.parseInt(
                                div.getPanelShokuji().getPanelDetail1()
                                .getTxtshokujiTeikyohiSeikyugaku().getValue().toString()))
                .build();
        return shokanShokujiHiyo;
    }

    /**
     * build食事費用登録1のメソッド
     *
     * @param shokanShokujiHiyo ShokanShokujiHiyo
     * @return ShokanShokujiHiyo
     */
    public ShokanShokujiHiyo build食事費用登録1(ShokanShokujiHiyo shokanShokujiHiyo) {

        if (div.getPanelShokuji().getPanelDetail1().getTxtKihonNissu().getValue() != null) {
            shokanShokujiHiyo = shokanShokujiHiyo.createBuilderForEdit().set基本提供日数(
                    div.getPanelShokuji().getPanelDetail1().getTxtKihonNissu().getValue().intValue()).build();
        }
        if (div.getPanelShokuji().getPanelDetail1().getTxtKihonTanka().getValue() != null) {
            shokanShokujiHiyo = shokanShokujiHiyo.createBuilderForEdit()
                    .set基本提供単価(div.getPanelShokuji().getPanelDetail1().getTxtKihonTanka()
                            .getValue().intValue()).build();
        }
        if (div.getPanelShokuji().getPanelDetail1().getTxtKihonKingaku().getValue() != null) {
            shokanShokujiHiyo = shokanShokujiHiyo.createBuilderForEdit()
                    .set基本提供金額(
                            div.getPanelShokuji().getPanelDetail1().getTxtKihonKingaku()
                            .getValue().intValue()).build();
        }
        if (div.getPanelShokuji().getPanelDetail1().getTxtTokubetuSyokuNissu().getValue() != null) {
            shokanShokujiHiyo = shokanShokujiHiyo.createBuilderForEdit()
                    .set特別提供日数(div.getPanelShokuji().getPanelDetail1().getTxtTokubetuSyokuNissu()
                            .getValue().intValue()).build();
        }
        if (div.getPanelShokuji().getPanelDetail1().getTxtTokubetuSyokuKinngaku().getValue() != null) {
            shokanShokujiHiyo = shokanShokujiHiyo.createBuilderForEdit()
                    .set特別提供単価(div.getPanelShokuji().getPanelDetail1().getTxtTokubetuSyokuKinngaku()
                            .getValue().intValue()).build();
        }
        if (div.getPanelShokuji().getPanelDetail1().getTxtTokubetuSyokuKinngaku().getValue() != null) {
            shokanShokujiHiyo = shokanShokujiHiyo.createBuilderForEdit()
                    .set特別提供金額(div.getPanelShokuji().getPanelDetail1().getTxtTokubetuSyokuKinngaku()
                            .getValue().intValue()).build();
        }
        if (div.getPanelShokuji().getPanelDetail1().getTxtShokujiTeikyoTotalNissu().getValue() != null) {
            shokanShokujiHiyo = shokanShokujiHiyo.createBuilderForEdit()
                    .set食事提供延べ日数(div.getPanelShokuji().getPanelDetail1().getTxtShokujiTeikyoTotalNissu()
                            .getValue().intValue()).build();
        }
        if (div.getPanelShokuji().getPanelDetail1().getTxtShokujiTeikyohiTotal().getValue() != null) {
            shokanShokujiHiyo = shokanShokujiHiyo.createBuilderForEdit()
                    .set食事提供費合計(div.getPanelShokuji().getPanelDetail1().getTxtShokujiTeikyohiTotal()
                            .getValue().intValue()).build();
        }
        if (div.getPanelShokuji().getPanelDetail1().getTxtnichigakuHyojunFutangaku().getValue() != null) {
            shokanShokujiHiyo = shokanShokujiHiyo.createBuilderForEdit()
                    .set標準負担額_日額(div.getPanelShokuji().getPanelDetail1().getTxtnichigakuHyojunFutangaku()
                            .getValue().intValue()).build();
        }
        if (div.getPanelShokuji().getPanelDetail1().getTxtgetsugakuHyojunFutangaku().getValue() != null) {
            shokanShokujiHiyo = shokanShokujiHiyo.createBuilderForEdit()
                    .set標準負担額_月額(div.getPanelShokuji().getPanelDetail1().getTxtgetsugakuHyojunFutangaku()
                            .getValue().intValue()).build();
        }
        if (div.getPanelShokuji().getPanelDetail1().getTxtshokujiTeikyohiSeikyugaku().getValue() != null) {
            shokanShokujiHiyo = shokanShokujiHiyo.createBuilderForEdit()
                    .set食事提供費請求額(div.getPanelShokuji().getPanelDetail1().getTxtshokujiTeikyohiSeikyugaku()
                            .getValue().intValue()).build();

        }
        return shokanShokujiHiyo;

    }

    /**
     * build_new_食事費用合計設定のメソッド
     *
     * @return ShokanShokujiHiyo
     */
    public ShokanShokujiHiyo build_new_食事費用合計設定() {
        SyokanbaraihishikyushinseiketteParameter paramter = ViewStateHolder.get(ViewStateKeys.償還払費申請明細検索キー,
                SyokanbaraihishikyushinseiketteParameter.class);
        HihokenshaNo 被保険者番号 = paramter.getHiHokenshaNo();
        FlexibleYearMonth サービス提供年月 = paramter.getServiceTeikyoYM();
        RString 整理番号 = paramter.getSeiriNp();
        JigyoshaNo 事業者番号 = paramter.getJigyoshaNo();
        RString 様式番号 = paramter.getYoshikiNo();
        RString 明細番号 = paramter.getMeisaiNo();
        ShokanShokujiHiyo shokanShokujiHiyo = new ShokanShokujiHiyo(
                被保険者番号,
                サービス提供年月,
                整理番号,
                事業者番号,
                様式番号,
                明細番号,
                new RString("1")).createBuilderForEdit().set食事提供延べ日数(
                        div.getPanelShokuji().getPanelDetailGokei()
                        .getTxtTeikyouHisu().getValue().intValue())
                .set標準負担額_日額(
                        div.getPanelShokuji().getPanelDetailGokei()
                        .getTxtHigaku().getValue().intValue())
                .set標準負担額_月額(
                        div.getPanelShokuji().getPanelDetailGokei()
                        .getTxtGetsugaku().getValue().intValue())
                .set食事提供費合計(
                        div.getPanelShokuji().getPanelDetailGokei()
                        .getTxtTeikyohiGokei().getValue().intValue())
                .set食事提供費請求額(
                        div.getPanelShokuji().getPanelDetailGokei()
                        .getTxtShokujiShiseigaku().getValue().intValue())
                .build();
        return shokanShokujiHiyo;
    }

    /**
     * build食事費用合計設定のメソッド
     *
     * @param shokanShokujiHiyo ShokanShokujiHiyo
     * @return ShokanShokujiHiyo
     */
    public ShokanShokujiHiyo build食事費用合計設定(ShokanShokujiHiyo shokanShokujiHiyo) {

        if (div.getPanelShokuji().getPanelDetailGokei().getTxtTeikyouHisu().getValue() != null) {
            shokanShokujiHiyo = shokanShokujiHiyo.createBuilderForEdit().set食事提供延べ日数(
                    div.getPanelShokuji().getPanelDetailGokei().getTxtTeikyouHisu()
                    .getValue().intValue()).build();
        }
        if (div.getPanelShokuji().getPanelDetailGokei().getTxtHigaku().getValue() != null) {
            shokanShokujiHiyo = shokanShokujiHiyo.createBuilderForEdit().set標準負担額_日額(
                    div.getPanelShokuji().getPanelDetailGokei().getTxtHigaku()
                    .getValue().intValue()).build();
        }
        if (div.getPanelShokuji().getPanelDetailGokei().getTxtGetsugaku().getValue() != null) {
            shokanShokujiHiyo = shokanShokujiHiyo.createBuilderForEdit().set標準負担額_月額(
                    div.getPanelShokuji().getPanelDetailGokei().getTxtGetsugaku()
                    .getValue().intValue()).build();
        }
        if (div.getPanelShokuji().getPanelDetailGokei().getTxtTeikyohiGokei().getValue() != null) {
            shokanShokujiHiyo = shokanShokujiHiyo.createBuilderForEdit().set食事提供費合計(
                    div.getPanelShokuji().getPanelDetailGokei().getTxtTeikyohiGokei()
                    .getValue().intValue()).build();
        }

        if (div.getPanelShokuji().getPanelDetailGokei().getTxtShokujiShiseigaku().getValue() != null) {
            shokanShokujiHiyo = shokanShokujiHiyo.createBuilderForEdit().set食事提供費請求額(
                    div.getPanelShokuji().getPanelDetailGokei().getTxtShokujiShiseigaku()
                    .getValue().intValue()).build();
        }
        return shokanShokujiHiyo;

    }

    /**
     * set食事費用登録のメソッド
     *
     * @param row dgdShokuji_Row
     */
    public void set食事費用登録(dgdShokuji_Row row) {
        if (row.getDefaultDataName2() != null) {
            RString serviceCodeShuruyi = new RString(row.getDefaultDataName2().subSequence(ZERO, TWO).toString());
            RString serviceCodeKoumoku = new RString(row.getDefaultDataName2().subSequence(THREE, SEVEN).toString());
            ServiceCodeInputCommonChildDivDiv serviceCodeInputDiv
                    = (ServiceCodeInputCommonChildDivDiv) div
                    .getPanelShokuji().getPanelDetail2().getCcdServiceCodeInput();
            serviceCodeInputDiv.getTxtServiceCode1().setValue(serviceCodeShuruyi);
            serviceCodeInputDiv.getTxtServiceCode2().setValue(serviceCodeKoumoku);
        }
        if (row.getDefaultDataName3() != null) {
            div.getPanelShokuji().getPanelDetail2().getTxtTanyi().setValue(
                    row.getDefaultDataName3().getValue());
        }
        if (row.getDefaultDataName4() != null) {
            div.getPanelShokuji().getPanelDetail2().getTxtKaisuuNisuu().setValue(
                    new Decimal(row.getDefaultDataName4().toString()));
        }
        if (row.getDefaultDataName5() != null) {
            div.getPanelShokuji().getPanelDetail2().getBtnKinngaku().setValue(
                    row.getDefaultDataName5().getValue());
        }
    }

    private void set基本情報ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get基本設定区分())) {
            div.getPanelHead().getBtnKihonInfo().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get基本設定区分())) {
            int count1 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().getShokanKihonCount(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count1 == 1) {
                div.getPanelHead().getBtnKihonInfo().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnKihonInfo().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get基本設定区分())) {
            div.getPanelHead().getBtnKihonInfo().setIconNameEnum(IconName.NONE);
        }
    }

    private void set給付費明細ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get明細設定区分())) {
            div.getPanelHead().getBtnKyufuhiMeisai().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get明細設定区分())) {
            int count2 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().delShokanMeisaiCount(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count2 == 1) {
                div.getPanelHead().getBtnKyufuhiMeisai().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnKyufuhiMeisai().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get明細設定区分())) {
            div.getPanelHead().getBtnKyufuhiMeisai().setIconNameEnum(IconName.NONE);
        }
    }

    private void set特定診療費ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get特定診療費設定区分())) {
            div.getPanelHead().getBtnTokuteiShinryohi().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get特定診療費設定区分())) {
            int count2 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().delShokanMeisaiCount(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count2 == 1) {
                div.getPanelHead().getBtnTokuteiShinryohi().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnTokuteiShinryohi().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get特定診療費設定区分())) {
            div.getPanelHead().getBtnTokuteiShinryohi().setIconNameEnum(IconName.NONE);
        }
    }

    private void setサービス計画費ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get食事費用設定区分())) {
            div.getPanelHead().getBtnTokuteiShinryohi().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get食事費用設定区分())) {
            int count2 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().delShokanMeisaiCount(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count2 == 1) {
                div.getPanelHead().getBtnTokuteiShinryohi().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnTokuteiShinryohi().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get食事費用設定区分())) {
            div.getPanelHead().getBtnTokuteiShinryohi().setIconNameEnum(IconName.NONE);
        }
    }

    private void set特定入所者費用ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get特定入所者設定区分())) {
            div.getPanelHead().getBtnTokuteiNyushosya().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get特定入所者設定区分())) {
            int count5 = SyokanbaraihiShikyuShinseiKetteManager.createInstance()
                    .updShokanTokuteiNyushoshaKaigoServiceHiyo(被保険者番号, サービス年月, 整理番号,
                            事業者番号, 様式番号, 明細番号);
            if (count5 == 1) {
                div.getPanelHead().getBtnTokuteiNyushosya().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnTokuteiNyushosya().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get特定入所者設定区分())) {
            div.getPanelHead().getBtnTokuteiNyushosya().setIconNameEnum(IconName.NONE);
        }
    }

    private void set給付費明細_住特ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get明細住所地特例設定区分())) {
            div.getPanelHead().getBtnKyufuhiMeisaiJyuchi().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get明細住所地特例設定区分())) {
            int count6 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().getShokanMeisaiJushochiTokureiCount(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count6 == 1) {
                div.getPanelHead().getBtnKyufuhiMeisaiJyuchi().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnKyufuhiMeisaiJyuchi().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get明細住所地特例設定区分())) {
            div.getPanelHead().getBtnKyufuhiMeisaiJyuchi().setIconNameEnum(IconName.NONE);
        }
    }

    private void set緊急時_所定疾患ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get特定疾患施設療養設定区分())) {
            div.getPanelHead().getBtnKinkyujiShoteiShikan().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get特定疾患施設療養設定区分())) {
            int count7 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShoteiShikkanShisetsuRyoyo(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count7 == 1) {
                div.getPanelHead().getBtnKinkyujiShoteiShikan().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnKinkyujiShoteiShikan().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get特定疾患施設療養設定区分())) {
            div.getPanelHead().getBtnKinkyujiShoteiShikan().setIconNameEnum(IconName.NONE);
        }
    }

    private void set緊急時施設療養費ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get緊急時施設療養設定区分())) {
            div.getPanelHead().getBtnKinkyujiShisetsuRyoyo().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get緊急時施設療養設定区分())) {
            int count8 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanKinkyuShisetsuRyoyo(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count8 == 1) {
                div.getPanelHead().getBtnKinkyujiShisetsuRyoyo().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnKinkyujiShisetsuRyoyo().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get緊急時施設療養設定区分())) {
            div.getPanelHead().getBtnKinkyujiShisetsuRyoyo().setIconNameEnum(IconName.NONE);
        }
    }

    private void set請求額集計ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get集計設定区分())) {
            div.getPanelHead().getBtnSeikyugakuShukei().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get集計設定区分())) {
            int count10 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShukei(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count10 == 1) {
                div.getPanelHead().getBtnSeikyugakuShukei().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnSeikyugakuShukei().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get集計設定区分())) {
            div.getPanelHead().getBtnSeikyugakuShukei().setIconNameEnum(IconName.NONE);
        }
    }

    private void set社福軽減額ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get社会福祉法人軽減設定区分())) {
            div.getPanelHead().getBtnShafukukeigengaku().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get社会福祉法人軽減設定区分())) {
            int count11 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShakaiFukushiHojinKeigengaku(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count11 == 1) {
                div.getPanelHead().getBtnShafukukeigengaku().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnShafukukeigengaku().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get社会福祉法人軽減設定区分())) {
            div.getPanelHead().getBtnShafukukeigengaku().setIconNameEnum(IconName.NONE);
        }
    }

}
