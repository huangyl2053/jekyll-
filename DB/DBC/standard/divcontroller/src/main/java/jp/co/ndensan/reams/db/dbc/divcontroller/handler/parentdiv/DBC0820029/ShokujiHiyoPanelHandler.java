/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820029;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanMeisai;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShokujiHiyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShokujiHiyoBuilder;
import jp.co.ndensan.reams.db.dbc.business.core.syokanbaraihishikyushinseikette.ShokanKihonParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820029.ShokujiHiyoPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820029.dgdShokuji_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku.ShoukanharaihishinseikensakuParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku.ShoukanharaihishinseimeisaikensakuParameter;
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

/**
 * 償還払い費支給申請決定_サービス提供証明書(食事費用）の画面クラスです。
 *
 * @reamsid_L DBC-1030-090 lijunjun
 */
public class ShokujiHiyoPanelHandler {

    private final ShokujiHiyoPanelDiv div;
    private static final RString 設定不可 = new RString("0");
    private static final RString 設定可必須 = new RString("1");
    private static final RString 設定可任意 = new RString("2");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");
    private static final RString DATA_0001 = new RString("0001");
    private static final int ZERO = 0;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int SEVEN = 7;
    private static final int SIX = 6;
    private static final RString フォーマット = new RString("%02d");
    private static final FlexibleYearMonth 平成１５年３月 = new FlexibleYearMonth("200303");
    private static final FlexibleYearMonth 平成17年９月 = new FlexibleYearMonth("200509");
    private static final FlexibleYearMonth 平成17年１０月 = new FlexibleYearMonth("200510");

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
                                div.getRowId().toString()));
    }

    /**
     * setボタン状態
     *
     * @param サービス提供年月 FlexibleYearMonth
     */
    public void setボタン状態(FlexibleYearMonth サービス提供年月) {
        if (サービス提供年月.isBeforeOrEquals(平成１５年３月)) {
            div.getPanelShokuji().getPanelShoikujiList().setVisible(false);
            div.getPanelShokuji().getPanelDetailGokei().setVisible(false);
            div.getPanelShokuji().getPanelDetail1().setVisible(true);
            div.getPanelShokuji().getPanelDetail1().setReadOnly(true);
            div.getPanelShokuji().getPanelDetail2().setVisible(false);
            div.getPanelShokuji().getPanelDetail1().getBtnCancel1().setVisible(false);
            div.getPanelShokuji().getPanelDetail1().getBtnConfirm1().setVisible(false);
        }
        if (平成１５年３月.isBefore(サービス提供年月)
                && サービス提供年月.isBeforeOrEquals(平成17年９月)) {
            div.getPanelShokuji().getPanelShoikujiList().setVisible(true);
            div.getPanelShokuji().getPanelShoikujiList().setReadOnly(true);
            div.getPanelShokuji().getPanelDetailGokei().setVisible(true);
            div.getPanelShokuji().getPanelDetailGokei().setReadOnly(true);
            div.getPanelShokuji().getPanelDetail1().setVisible(false);
            div.getPanelShokuji().getPanelDetail2().setVisible(false);
        }
        if (平成17年１０月.isBeforeOrEquals(サービス提供年月)) {
            div.getPanelShokuji().getPanelShoikujiList().setVisible(false);
            div.getPanelShokuji().getPanelDetailGokei().setVisible(true);
            div.getPanelShokuji().getPanelDetailGokei().setReadOnly(true);
            div.getPanelShokuji().getPanelDetail1().setVisible(false);
            div.getPanelShokuji().getPanelDetail2().setVisible(false);
        }
    }

    /**
     * set平成１５年３月_平成17年１０月_状態
     */
    public void set平成１５年３月_平成17年１０月_状態() {
        div.getPanelShokuji().getPanelShoikujiList().setVisible(true);
        div.getPanelShokuji().getPanelDetailGokei().setVisible(true);
        div.getPanelShokuji().getPanelDetail1().setDisplayNone(true);
        div.getPanelShokuji().getPanelDetail2().setVisible(false);
    }

    /**
     * set平成17年１０月_状態
     */
    public void set平成17年１０月_状態() {
        div.getPanelShokuji().getPanelShoikujiList().setDisplayNone(true);
        div.getPanelShokuji().getPanelDetailGokei().setVisible(true);
        div.getPanelShokuji().getPanelDetailGokei().getTxtTeikyohiGokei().setReadOnly(false);
        div.getPanelShokuji().getPanelDetail1().setVisible(false);
        div.getPanelShokuji().getPanelDetail2().setVisible(false);
    }

    /**
     * set平成１５年３月_状態
     */
    public void set平成１５年３月_状態() {
        div.getPanelShokuji().getPanelShoikujiList().setDisplayNone(true);
        div.getPanelShokuji().getPanelDetailGokei().setDisplayNone(true);
        div.getPanelShokuji().getPanelDetail1().setVisible(true);
        div.getPanelShokuji().getPanelDetail2().setVisible(false);
        div.getPanelShokuji().getPanelDetail1().getBtnCancel1().setVisible(false);
        div.getPanelShokuji().getPanelDetail1().getBtnConfirm1().setVisible(false);
    }

    /**
     * set標準負担額日額
     *
     * @param 標準負担額日額 Decimal
     */
    public void set標準負担額日額(Decimal 標準負担額日額) {
        div.getPanelShokuji().getPanelDetailGokei().getTxtHigaku().setValue(標準負担額日額);
    }

    /**
     * 保存処理confirmのメソッド
     *
     * @param row dgdShokuji_Row
     * @param 状態 RString
     */
    public void confirm(dgdShokuji_Row row, RString 状態) {
        if (修正.equals(状態)) {
            if (RowState.Added.equals(row.getRowState())) {
                row.setRowState(RowState.Added);
                set食事費用登録グリッド(row);
            } else {
                modifiedConfirm(row);
            }
        } else if (削除.equals(状態)) {
            if (RowState.Added.equals(row.getRowState())) {
                div.getPanelShokuji().getPanelShoikujiList().getDgdShokuji().getDataSource().remove(row);
            } else {
                row.setRowState(RowState.Deleted);
                set食事費用登録グリッド(row);
            }
        } else if (登録.equals(状態)) {
            List<dgdShokuji_Row> list = div.getPanelShokuji().getPanelShoikujiList().getDgdShokuji().getDataSource();
            row.setRowState(RowState.Added);
            set食事費用登録グリッド(row);
            list.add(row);
        }
    }

    private void modifiedConfirm(dgdShokuji_Row row) {
        boolean flag = modifiedCheck(row);
        if (flag) {
            row.setRowState(RowState.Modified);
            set食事費用登録グリッド(row);
        }
    }

    private boolean modifiedCheck(dgdShokuji_Row row) {
        ServiceCodeInputCommonChildDivDiv serviceCodeInputDiv = (ServiceCodeInputCommonChildDivDiv) div
                .getPanelShokuji().getPanelDetail2().getCcdServiceCodeInput();
        RString サービス種類コード = serviceCodeInputDiv.getTxtServiceCode1().getValue();
        RString サービス項目コード = serviceCodeInputDiv.getTxtServiceCode2().getValue();
        RStringBuilder builder = new RStringBuilder();
        builder.append(サービス種類コード).append(RString.HALF_SPACE).append(サービス項目コード);
        if (!row.getDefaultDataName2().equals(builder.toRString())) {
            return true;
        }
        if (!row.getDefaultDataName3().getValue().equals(
                div.getPanelShokuji().getPanelDetail2().getTxtTanyi().getValue())) {
            return true;
        }
        if (div.getPanelShokuji().getPanelDetail2().getTxtKaisuuNisuu().getValue() != null
                && !row.getDefaultDataName4().equals(new RString(
                                div.getPanelShokuji().getPanelDetail2().getTxtKaisuuNisuu().getValue().toString()))) {
            return true;
        } else if (div.getPanelShokuji().getPanelDetail2().getTxtKaisuuNisuu().getValue() == null
                && row.getDefaultDataName4() != null) {
            return true;
        }
        return (!row.getDefaultDataName5().getValue().equals(
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
        RString サービス種類コード = serviceCodeInputDiv.getTxtServiceCode1().getValue();
        RString サービス項目コード = serviceCodeInputDiv.getTxtServiceCode2().getValue();
        RStringBuilder builder = new RStringBuilder();
        builder.append(サービス種類コード);
        builder.append(RString.HALF_SPACE);
        builder.append(サービス項目コード);
        row.setDefaultDataName2(builder.toRString());
        row.getDefaultDataName3().setValue(div.getPanelShokuji().getPanelDetail2().getTxtTanyi().getValue());
        if (div.getPanelShokuji().getPanelDetail2().getTxtKaisuuNisuu().getValue() != null) {
            row.setDefaultDataName4(new RString(
                    div.getPanelShokuji().getPanelDetail2().getTxtKaisuuNisuu().getValue().toString()));
        } else if (div.getPanelShokuji().getPanelDetail2().getTxtKaisuuNisuu().getValue() == null) {
            row.setDefaultDataName4(null);
        }
        row.getDefaultDataName5().setValue(div.getPanelShokuji().getPanelDetail2().getBtnKinngaku().getValue());

    }

    /**
     * 集計するのメソッド
     */
    public void 集計する() {
        Decimal 食事提供延べ日数 = Decimal.ZERO;
        Decimal 食事提供費合計 = Decimal.ZERO;
        List<dgdShokuji_Row> dgrow = div.getPanelShokuji().getPanelShoikujiList().getDgdShokuji().getDataSource();
        if (dgrow.isEmpty()) {
            div.getPanelShokuji().getPanelDetailGokei().getTxtTeikyohiGokei().setValue(new Decimal(0));
        }
        for (dgdShokuji_Row row : dgrow) {
            if (!RowState.Deleted.equals(row.getRowState())) {
                食事提供延べ日数 = 食事提供延べ日数.add(getData1(row));
                食事提供費合計 = 食事提供費合計.add(getData2(row));
            }
            Decimal 標準負担額_日額 = div.getPanelShokuji().getPanelDetailGokei().getTxtHigaku().getValue();
            Decimal 標準負担_月額 = 食事提供延べ日数.multiply(標準負担額_日額);
            Decimal 食事提供費請求額 = 食事提供費合計.subtract(標準負担_月額);
            div.getPanelShokuji().getPanelDetailGokei().getTxtTeikyouHisu().setValue(食事提供延べ日数);
            div.getPanelShokuji().getPanelDetailGokei().getTxtHigaku().setValue(標準負担額_日額);
            div.getPanelShokuji().getPanelDetailGokei().getTxtGetsugaku().setValue(標準負担_月額);
            div.getPanelShokuji().getPanelDetailGokei().getTxtTeikyohiGokei().setValue(食事提供費合計);
            div.getPanelShokuji().getPanelDetailGokei().getTxtShokujiShiseigaku().setValue(食事提供費請求額);
        }

    }

    private Decimal getData1(dgdShokuji_Row row) {
        if (!row.getDefaultDataName4().toString().isEmpty()) {
            return new Decimal(row.getDefaultDataName4().toString().replace(",", ""));
        }
        return Decimal.ZERO;
    }

    private Decimal getData2(dgdShokuji_Row row) {
        if (!row.getDefaultDataName5().toString().isEmpty()) {
            return row.getDefaultDataName5().getValue();
        }
        return Decimal.ZERO;
    }

    /**
     * 計算するのメソッド
     */
    public void 計算する() {
        Decimal 基本金額, 特別食金額, 食事提供延べ日数, 標準負担額月額, 食事提供費合計, 食事提供費請求額;
        Decimal 基本日数 = div.getPanelShokuji().getPanelDetail1().getTxtKihonNissu().getValue();
        Decimal 基本単価 = div.getPanelShokuji().getPanelDetail1().getTxtKihonTanka().getValue();
        Decimal 特別食日数 = div.getPanelShokuji().getPanelDetail1().getTxtTokubetuSyokuNissu().getValue();
        Decimal 特別食単価 = div.getPanelShokuji().getPanelDetail1().getTxtTokubetuSyokuTanka().getValue();
        Decimal 標準負担額日額 = div.getPanelShokuji().getPanelDetail1().getTxtnichigakuHyojunFutangaku().getValue();

        基本日数 = null == 基本日数 ? Decimal.ZERO : 基本日数;
        基本単価 = null == 基本単価 ? Decimal.ZERO : 基本単価;
        特別食日数 = null == 特別食日数 ? Decimal.ZERO : 特別食日数;
        特別食単価 = null == 特別食単価 ? Decimal.ZERO : 特別食単価;
        標準負担額日額 = null == 標準負担額日額 ? Decimal.ZERO : 標準負担額日額;

        基本金額 = 基本日数.multiply(基本単価);
        特別食金額 = 特別食日数.multiply(特別食単価);
        食事提供延べ日数 = 基本日数.add(特別食日数);
        標準負担額月額 = 食事提供延べ日数.multiply(標準負担額日額);
        食事提供費合計 = 基本金額.add(特別食金額);
        食事提供費請求額 = 食事提供費合計.subtract(標準負担額月額);

        div.getPanelShokuji().getPanelDetail1().getTxtKihonNissu().setValue(基本日数);
        div.getPanelShokuji().getPanelDetail1().getTxtKihonTanka().setValue(基本単価);
        div.getPanelShokuji().getPanelDetail1().getTxtKihonKingaku().setValue(基本金額);
        div.getPanelShokuji().getPanelDetail1().getTxtTokubetuSyokuNissu().setValue(特別食日数);
        div.getPanelShokuji().getPanelDetail1().getTxtTokubetuSyokuTanka().setValue(特別食単価);
        div.getPanelShokuji().getPanelDetail1().getTxtTokubetuSyokuKinngaku().setValue(特別食金額);
        div.getPanelShokuji().getPanelDetail1().getTxtShokujiTeikyoTotalNissu().setValue(食事提供延べ日数);
        div.getPanelShokuji().getPanelDetail1().getTxtnichigakuHyojunFutangaku().setValue(標準負担額日額);
        div.getPanelShokuji().getPanelDetail1().getTxtgetsugakuHyojunFutangaku().setValue(標準負担額月額);
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
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 整理番号 RString
     * @return ShoukanharaihishinseikensakuParameter
     */
    public ShoukanharaihishinseikensakuParameter putViewState(HihokenshaNo 被保険者番号,
            RString 整理番号) {
        ShoukanharaihishinseikensakuParameter paramter = new ShoukanharaihishinseikensakuParameter(
                被保険者番号,
                new FlexibleYearMonth(div.getPanelHead().getTxtServiceTeikyoYM().getValue().toDateString()
                        .substring(0, SIX)),
                整理番号,
                new JigyoshaNo(div.getPanelHead().getTxtJigyoshaBango().getValue()),
                div.getPanelHead().getTxtShomeisho().getValue(),
                div.getPanelHead().getTxtMeisaiBango().getValue(),
                null);
        return paramter;
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
     * @param 申請日 RDate
     * @param 事業者番号 JigyoshaNo
     * @param 明細番号 RString
     * @param 証明書 RString
     */
    public void setヘッダーエリア(
            FlexibleYearMonth サービス提供年月,
            RDate 申請日,
            JigyoshaNo 事業者番号,
            RString 明細番号,
            RString 証明書) {
        div.getPanelHead().getTxtServiceTeikyoYM().setValue(new RDate(サービス提供年月.toString()));
        div.getPanelHead().getTxtShinseiYMD().setValue(申請日);
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
    public void set食事費用一覧グリッド(List<ShokanMeisai> list, List<ShokanShokujiHiyo> shokanShokujiHiyo) {
        List<dgdShokuji_Row> dataSource = new ArrayList<>();
        for (ShokanMeisai entity : list) {
            dgdShokuji_Row dgdShokuji_Row = new dgdShokuji_Row();
            RStringBuilder builder = new RStringBuilder();
            if (entity.getサービス種類コード() != null) {
                builder.append(entity.getサービス種類コード().value());
            }
            builder.append(RString.HALF_SPACE);
            if (entity.getサービス項目コード() != null) {
                builder.append(entity.getサービス項目コード().value());
            }
            dgdShokuji_Row.setDefaultDataName2(builder.toRString());
            dgdShokuji_Row.getDefaultDataName3().setValue(new Decimal(entity.get単位数()));
            dgdShokuji_Row.setDefaultDataName4(new RString(String.valueOf(entity.get日数_回数())));
            dgdShokuji_Row.getDefaultDataName5().setValue(new Decimal(entity.getサービス単位数()));
            dgdShokuji_Row.setDefaultDataName6(entity.get連番());
            dataSource.add(dgdShokuji_Row);
        }

        div.getPanelShokuji().getPanelShoikujiList().getDgdShokuji().setDataSource(dataSource);
        if (!shokanShokujiHiyo.isEmpty()) {
            set食事費用合計設定(shokanShokujiHiyo.get(0));
        }
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
     * @param shokanShokujiHiyoList List<ShokanShokujiHiyo>
     * @return boolean
     */
    public boolean get内容変更状態(FlexibleYearMonth サービス提供年月, List<ShokanShokujiHiyo> shokanShokujiHiyoList) {
        if (サービス提供年月.isBeforeOrEquals(平成１５年３月)) {
            return get内容変更状態_1503(shokanShokujiHiyoList);
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
            return get内容変更状態_1709(shokanShokujiHiyoList);
        }
        if (平成17年１０月.isBeforeOrEquals(サービス提供年月)) {
            return get内容変更状態_1709(shokanShokujiHiyoList);
        }
        return false;
    }

    /**
     * get内容変更状態_1709
     *
     * @param shokanShokujiHiyoList List<ShokanShokujiHiyo>
     * @return boolean
     */
    public boolean get内容変更状態_1709(List<ShokanShokujiHiyo> shokanShokujiHiyoList) {
        if (shokanShokujiHiyoList.isEmpty()) {
            return true;
        }
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
     * @param shokanShokujiHiyoList List<ShokanShokujiHiyo>
     * @return boolean
     */
    public boolean get内容変更状態_1503(List<ShokanShokujiHiyo> shokanShokujiHiyoList) {

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
     * @param paramter ShoukanharaihishinseimeisaikensakuParameter
     */
    public void getボタンを制御(ShikibetsuNoKanri shikibetsuNoKanri,
            ShoukanharaihishinseimeisaikensakuParameter paramter) {
        HihokenshaNo 被保険者番号 = paramter.get被保険者番号();
        FlexibleYearMonth サービス年月 = paramter.getサービス年月();
        RString 整理番号 = paramter.get整理番号();
        JigyoshaNo 事業者番号 = paramter.get事業者番号();
        RString 様式番号 = paramter.get様式番号();
        RString 明細番号 = paramter.get明細番号();
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
        div.getPanelHead().getBtnShokujiHiyo().setDisabled(true);
        set社福軽減額ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
    }

    /**
     * 保存処理 のメソッド
     *
     * @param paramter ShoukanharaihishinseimeisaikensakuParameter
     * @param shokanShokujiHiyoList List<ShokanShokujiHiyo>
     * @param shokanMeisaiList List<ShokanMeisai>
     * @param 処理モード RString
     */
    public void 保存処理(ShoukanharaihishinseimeisaikensakuParameter paramter,
            List<ShokanShokujiHiyo> shokanShokujiHiyoList,
            List<ShokanMeisai> shokanMeisaiList,
            RString 処理モード) {

        HihokenshaNo 被保険者番号 = paramter.get被保険者番号();
        FlexibleYearMonth サービス提供年月 = paramter.getサービス年月();
        RString 整理番号 = paramter.get整理番号();
        JigyoshaNo 事業者番号 = paramter.get事業者番号();
        RString 様式番号 = paramter.get様式番号();
        RString 明細番号 = paramter.get明細番号();
        ShokanKihonParameter par = ShokanKihonParameter.createSelectByKeyParam(
                被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号, 0);

        if (削除.equals(処理モード)) {
            SyokanbaraihiShikyuShinseiKetteManager.createInstance().delShokanSyomeisyo(
                    被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        } else {
            if (サービス提供年月.isBeforeOrEquals(平成１５年３月)) {
                if (!shokanShokujiHiyoList.isEmpty()) {
                    ShokanShokujiHiyo shokanShokujiHiyo = shokanShokujiHiyoList.get(0);
                    shokanShokujiHiyo = build食事費用登録1(shokanShokujiHiyo);
                    SyokanbaraihiShikyuShinseiKetteManager.createInstance()
                            .updShokanShokujiHiyo(shokanShokujiHiyo, null, par);
                } else {
                    ShokanShokujiHiyo shokanShokujiHiyo = build_new_食事費用登録1(paramter);
                    SyokanbaraihiShikyuShinseiKetteManager.createInstance()
                            .updShokanShokujiHiyo(shokanShokujiHiyo, null, par);
                }

            } else if (平成１５年３月.isBefore(サービス提供年月)
                    && サービス提供年月.isBeforeOrEquals(平成17年９月)) {
                int max連番 = 0;
                Map<RString, ShokanMeisai> map = new HashMap<>();
                for (ShokanMeisai entity : shokanMeisaiList) {
                    map.put(entity.get連番(), entity);
                    if (max連番 < Integer.valueOf(entity.get連番().toString())) {
                        max連番 = Integer.valueOf(entity.get連番().toString());
                    }
                }
                List<ShokanMeisai> meisaiList = new ArrayList<>();
                for (dgdShokuji_Row dgd : div.getPanelShokuji().getPanelShoikujiList().
                        getDgdShokuji().getDataSource()) {
                    if (RowState.Modified.equals(dgd.getRowState())) {
                        ShokanMeisai entityModified = map.get(dgd.getDefaultDataName6());
                        entityModified = entityModified.createBuilderForEdit().build();
                        entityModified = clearShokanMeisai(entityModified);
                        entityModified = buildShokanMeisai(entityModified, dgd);
                        meisaiList.add(entityModified);
                    } else if (RowState.Deleted.equals(dgd.getRowState())) {
                        ShokanMeisai entityDeleted = map.get(dgd.getDefaultDataName6());
                        entityDeleted = entityDeleted.deleted();
                        meisaiList.add(entityDeleted);
                    } else if (RowState.Added.equals(dgd.getRowState())) {
                        max連番 = max連番 + 1;
                        ShokanMeisai entityAdded = new ShokanMeisai(
                                被保険者番号,
                                サービス提供年月,
                                整理番号,
                                事業者番号,
                                様式番号,
                                明細番号,
                                new RString(String.format(フォーマット.toString(), max連番))).createBuilderForEdit().build();
                        entityAdded = buildShokanMeisai(entityAdded, dgd);
                        meisaiList.add(entityAdded);
                    } else {
                        ShokanMeisai entityUnchanged = map.get(dgd.getDefaultDataName6());
                        meisaiList.add(entityUnchanged);
                    }
                }
                if (!shokanShokujiHiyoList.isEmpty()) {
                    ShokanShokujiHiyo shokanShokujiHiyo = shokanShokujiHiyoList.get(0);
                    shokanShokujiHiyo = build食事費用合計設定(shokanShokujiHiyo);
                    SyokanbaraihiShikyuShinseiKetteManager.createInstance()
                            .updShokanShokujiHiyo(shokanShokujiHiyo, meisaiList, par);
                } else {
                    ShokanShokujiHiyo shokanShokujiHiyo = build_new_食事費用合計設定(paramter);
                    SyokanbaraihiShikyuShinseiKetteManager.createInstance()
                            .updShokanShokujiHiyo(shokanShokujiHiyo, meisaiList, par);
                }

            } else if (平成17年１０月.isBeforeOrEquals(サービス提供年月)) {
                if (!shokanShokujiHiyoList.isEmpty()) {
                    ShokanShokujiHiyo shokanShokujiHiyo = shokanShokujiHiyoList.get(0);
                    shokanShokujiHiyo = build食事費用合計設定(shokanShokujiHiyo);
                    SyokanbaraihiShikyuShinseiKetteManager.createInstance()
                            .updShokanShokujiHiyo(shokanShokujiHiyo, null, par);
                } else {
                    ShokanShokujiHiyo shokanShokujiHiyo = build_new_食事費用合計設定(paramter);
                    shokanShokujiHiyo = build食事費用合計設定(shokanShokujiHiyo);
                    SyokanbaraihiShikyuShinseiKetteManager.createInstance()
                            .updShokanShokujiHiyo(shokanShokujiHiyo, null, par);
                }
            }
        }

    }

    private ShokanMeisai clearShokanMeisai(ShokanMeisai entityModified) {

        entityModified = entityModified.createBuilderForEdit().set単位数(0).build();
        entityModified = entityModified.createBuilderForEdit().set日数_回数(0).build();
        entityModified = entityModified.createBuilderForEdit().setサービス単位数(0).build();
        return entityModified;
    }

    /**
     * buildShokanMeisaiのメソッド
     *
     * @param entityModified ShokanMeisai
     * @param dgd dgdShokuji_Row
     * @return ShokanMeisai
     */
    public ShokanMeisai buildShokanMeisai(ShokanMeisai entityModified, dgdShokuji_Row dgd) {

        if (dgd.getDefaultDataName2() != null) {
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
        if (dgd.getDefaultDataName4() != null) {
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
     * @param paramter ShoukanharaihishinseimeisaikensakuParameter
     * @return ShokanShokujiHiyo
     */
    public ShokanShokujiHiyo build_new_食事費用登録1(ShoukanharaihishinseimeisaikensakuParameter paramter) {
        HihokenshaNo 被保険者番号 = paramter.get被保険者番号();
        FlexibleYearMonth サービス提供年月 = paramter.getサービス年月();
        RString 整理番号 = paramter.get整理番号();
        JigyoshaNo 事業者番号 = paramter.get事業者番号();
        RString 様式番号 = paramter.get様式番号();
        RString 明細番号 = DATA_0001;
        int ii = 1;
        RString 連番 = new RString(String.format("%02d", ii));
        ShokanShokujiHiyo shokanShokujiHiyo = new ShokanShokujiHiyo(
                被保険者番号,
                サービス提供年月,
                整理番号,
                事業者番号,
                様式番号,
                明細番号,
                連番).createBuilderForEdit().set基本提供日数(Integer.parseInt(
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
                    .set特別提供単価(div.getPanelShokuji().getPanelDetail1().getTxtTokubetuSyokuTanka()
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
     * @param paramter ShoukanharaihishinseimeisaikensakuParameter
     * @return ShokanShokujiHiyo
     */
    public ShokanShokujiHiyo build_new_食事費用合計設定(ShoukanharaihishinseimeisaikensakuParameter paramter) {
        HihokenshaNo 被保険者番号 = paramter.get被保険者番号();
        FlexibleYearMonth サービス提供年月 = paramter.getサービス年月();
        RString 整理番号 = paramter.get整理番号();
        JigyoshaNo 事業者番号 = paramter.get事業者番号();
        RString 様式番号 = paramter.get様式番号();
        RString 明細番号 = DATA_0001;
        int ii = 1;
        RString 連番 = new RString(String.format("%02d", ii));
        ShokanShokujiHiyo shokanShokujiHiyo = new ShokanShokujiHiyo(
                被保険者番号,
                サービス提供年月,
                整理番号,
                事業者番号,
                様式番号,
                明細番号,
                連番).createBuilderForEdit().set食事提供延べ日数(
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

        ShokanShokujiHiyoBuilder builder = shokanShokujiHiyo.createBuilderForEdit();
        if (div.getPanelShokuji().getPanelDetailGokei().getTxtTeikyouHisu().getValue() != null) {
            shokanShokujiHiyo = builder.set食事提供延べ日数(
                    div.getPanelShokuji().getPanelDetailGokei().getTxtTeikyouHisu()
                    .getValue().intValue()).build();
        }
        if (div.getPanelShokuji().getPanelDetailGokei().getTxtHigaku().getValue() != null) {
            shokanShokujiHiyo = builder.set標準負担額_日額(
                    div.getPanelShokuji().getPanelDetailGokei().getTxtHigaku()
                    .getValue().intValue()).build();
        }
        if (div.getPanelShokuji().getPanelDetailGokei().getTxtGetsugaku().getValue() != null) {
            shokanShokujiHiyo = builder.set標準負担額_月額(
                    div.getPanelShokuji().getPanelDetailGokei().getTxtGetsugaku()
                    .getValue().intValue()).build();
        }
        if (div.getPanelShokuji().getPanelDetailGokei().getTxtTeikyohiGokei().getValue() != null) {
            shokanShokujiHiyo = builder.set食事提供費合計(
                    div.getPanelShokuji().getPanelDetailGokei().getTxtTeikyohiGokei()
                    .getValue().intValue()).build();
        }

        if (div.getPanelShokuji().getPanelDetailGokei().getTxtShokujiShiseigaku().getValue() != null) {
            shokanShokujiHiyo = builder.set食事提供費請求額(
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
            if (count1 != 0) {
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
            if (count2 != 0) {
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
            int count3 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().delShokanMeisaiCount(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count3 != 0) {
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
        if (設定不可.equals(shikibetsuNoKanri.get居宅計画費設定区分())) {
            div.getPanelHead().getBtnServiceKeikakuhi().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get居宅計画費設定区分())) {
            int count4 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanServicePlan(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count4 != 0) {
                div.getPanelHead().getBtnServiceKeikakuhi().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnServiceKeikakuhi().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get居宅計画費設定区分())) {
            div.getPanelHead().getBtnServiceKeikakuhi().setIconNameEnum(IconName.NONE);
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
            if (count5 != 0) {
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
            if (count6 != 0) {
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
        if (設定不可.equals(shikibetsuNoKanri.get所定疾患施設療養設定区分())) {
            div.getPanelHead().getBtnKinkyujiShoteiShikan().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get所定疾患施設療養設定区分())) {
            int count7 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShoteiShikkanShisetsuRyoyo(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count7 != 0) {
                div.getPanelHead().getBtnKinkyujiShoteiShikan().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnKinkyujiShoteiShikan().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get所定疾患施設療養設定区分())) {
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
            if (count8 != 0) {
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
            int count9 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShukei(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count9 != 0) {
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
            int count10 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShakaiFukushiHojinKeigengaku(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count10 != 0) {
                div.getPanelHead().getBtnShafukukeigengaku().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnShafukukeigengaku().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get社会福祉法人軽減設定区分())) {
            div.getPanelHead().getBtnShafukukeigengaku().setIconNameEnum(IconName.NONE);
        }
    }

    /**
     * readOnly食事費用登録
     *
     * @param flag boolean
     */
    public void readOnly食事費用登録(boolean flag) {
        div.getPanelShokuji().getPanelDetail2().getCcdServiceCodeInput().setReadOnly(flag);
        div.getPanelShokuji().getPanelDetail2().getTxtKaisuuNisuu().setReadOnly(flag);
        div.getPanelShokuji().getPanelDetail2().getTxtTanyi().setReadOnly(flag);
        div.getPanelShokuji().getPanelDetail2().getBtnKinngaku().setReadOnly(flag);
    }

}
