/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0820030;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShukei;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanShukeiResult;
import jp.co.ndensan.reams.db.dbc.business.core.syokanbaraihishikyushinseikette.ShokanKihonParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.shinsahoho.ShinsaHohoKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820030.SeikyuGakuShukeiPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820030.dgdSeikyugakushukei_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.syokanbaraihishikyushinseikette.SyokanbaraihishikyushinseiketteParameter;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ServiceTypeInputCommonChildDiv.ServiceTypeInputCommonChildDivDiv;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.IconName;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 償還払い費支給申請決定_サービス提供証明書(請求額集計）
 *
 *
 */
public class SeikyuGakuShukeiPanelHandler {

    private final SeikyuGakuShukeiPanelDiv div;
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");
    private static final RString 設定不可 = new RString("0");
    private static final RString 設定可必須 = new RString("1");
    private static final RString 設定可任意 = new RString("2");
    private static final int NUM = 10;
    private static final int NUM1 = 100;

    /**
     * 初期化
     *
     * @param div SeikyuGakuShukeiPanelDiv
     */
    public SeikyuGakuShukeiPanelHandler(SeikyuGakuShukeiPanelDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理します。
     *
     * @param shkanList List
     */
    public void initialize(List<ShokanShukeiResult> shkanList) {
        List<dgdSeikyugakushukei_Row> rowList = new ArrayList<>();
        for (ShokanShukeiResult shokanshukei : shkanList) {
            dgdSeikyugakushukei_Row row = new dgdSeikyugakushukei_Row();
            row.setDefaultDataName1(shokanshukei.getServiceShuruiRyakusho());
            row.getDefaultDataName2().setValue(new Decimal(shokanshukei.getShukei().get単位数合計()));
            row.getDefaultDataName3().setValue(shokanshukei.getShukei().get単位数単価());
            row.getDefaultDataName4().setValue(shokanshukei.getShukei().get請求額());
            if (ShinsaHohoKubun.toValue(shokanshukei.getShukei().get審査方法区分コード()) != null) {
                row.setDefaultDataName5(ShinsaHohoKubun.toValue(shokanshukei.getShukei().
                        get審査方法区分コード()).get名称());
            }
            row.getDefaultDataName6().setValue(new Decimal(shokanshukei.getShukei().get利用者負担額()));
            row.getDefaultDataName7().setValue(new Decimal(shokanshukei.getShukei().get限度額管理対象単位数()));
            row.getDefaultDataName8().setValue(new Decimal(shokanshukei.getShukei().get限度額管理対象外単位数()));
            row.getDefaultDataName9().setValue(new Decimal(shokanshukei.getShukei().get短期入所計画日数()));
            row.getDefaultDataName10().setValue(new Decimal(shokanshukei.getShukei().get短期入所実日数()));
            row.getDefaultDataName11().setValue(new Decimal(shokanshukei.getShukei().get出来高医療費単位数合計()));
            row.getDefaultDataName12().setValue(shokanshukei.getShukei().get出来高医療費請求額());
            row.getDefaultDataName13().setValue(shokanshukei.getShukei().get出来高医療費利用者負担額());
            row.getDefaultDataName14().setValue(new Decimal(shokanshukei.getShukei().get計画単位数()));
            row.setDefaultDataName15(shokanshukei.getShukei().get連番());
            row.setDefaultDataName16(shokanshukei.getServiceShuruiRyakusho());
            row.getDefaultDataName17().setValue(new Decimal(shokanshukei.getShukei().getサービス実日数()));
            row.setDefaultDataName18(shokanshukei.getShukei().
                    get審査方法区分コード());

            rowList.add(row);
        }
        div.getPanelSeikyugakuShukei().getDgdSeikyugakushukei().setDataSource(rowList);

    }

    /**
     * set申請共通エリア
     *
     * @param サービス年月 FlexibleYearMonth
     * @param 事業者番号 JigyoshaNo
     * @param 申請日 RString
     * @param 明細番号 RString
     * @param 証明書 RString
     */
    public void set申請共通エリア(
            FlexibleYearMonth サービス年月,
            JigyoshaNo 事業者番号,
            RString 申請日,
            RString 明細番号,
            RString 証明書) {
        div.getPanelHead().getTxtServiceTeikyoYM().setValue(new RDate(サービス年月.toString()));
        div.getPanelHead().getTxtShinseiYMD().setValue(new RDate(申請日.toString()));
        div.getPanelHead().getTxtJigyoshaBango().setValue(事業者番号.getColumnValue());
        div.getPanelHead().getTxtMeisaiBango().setValue(明細番号);
        div.getPanelHead().getTxtShomeisho().setValue(証明書);
    }

    /**
     * set請求額集計登録
     */
    public void set請求額集計登録() {
        ServiceTypeInputCommonChildDivDiv sercode
                = (ServiceTypeInputCommonChildDivDiv) div.getPanelSeikyugakuShukei().
                getPanelSeikyuShokai().getCcdServiceTypeInput();
        dgdSeikyugakushukei_Row row = div.getPanelSeikyugakuShukei().getDgdSeikyugakushukei().getClickedItem();
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtKyufuritsu().setValue(
                ViewStateHolder.get(ViewStateKeys.給付率, Decimal.class));

        if (!row.getDefaultDataName1().isEmpty()) {
            sercode.getTxtServiceType().setValue(row.getDefaultDataName1());

        }
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTanyigokeiHokenbun().setValue(
                row.getDefaultDataName2().getValue());
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTanyiTanka().setValue(
                row.getDefaultDataName3().getValue());
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtSeikyugakuHoken().setValue(
                row.getDefaultDataName4().getValue());
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtRiyoshaFutanHoken().setValue(
                row.getDefaultDataName6().getValue());
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getRdoShinsahouhou().
                setSelectedValue(row.getDefaultDataName5());
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtKeikakuTanyi().setValue(
                row.getDefaultDataName14().getValue());
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTaishoTanyi().setValue(
                row.getDefaultDataName7().getValue());
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTaishoGaiTanyi().setValue(
                row.getDefaultDataName8().getValue());
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtKeikakuNissu().setValue(
                row.getDefaultDataName9().getValue());
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtJitsuNissuTankinyusho().setValue(
                row.getDefaultDataName10().getValue());
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTanyigokeiDekikatabun().setValue(
                row.getDefaultDataName11().getValue());
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtSeikyugakuDekikata().setValue(
                row.getDefaultDataName12().getValue());
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtRiyoshaFutanDekikata().setValue(
                row.getDefaultDataName13().getValue());
        if (!row.getDefaultDataName16().isEmpty()) {
            sercode.getTxtServiceTypeName().setValue(row.getDefaultDataName16());

        }
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtJitsuNissu().setValue(
                row.getDefaultDataName17().getValue());
        div.getPanelSeikyugakuShukei().getRowId().setValue(new Decimal(row.getId()));
    }

    /**
     * clear請求額集計登録
     *
     */
    public void clear請求額集計登録() {
        ServiceTypeInputCommonChildDivDiv sercode
                = (ServiceTypeInputCommonChildDivDiv) div.getPanelSeikyugakuShukei().
                getPanelSeikyuShokai().getCcdServiceTypeInput();
        sercode.getTxtServiceType().clearValue();
        sercode.getTxtServiceTypeName().clearValue();
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtKyufuritsu().clearValue();
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTanyigokeiHokenbun().clearValue();
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTanyiTanka().clearValue();
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtSeikyugakuHoken().clearValue();
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtRiyoshaFutanHoken().clearValue();
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtKeikakuTanyi().clearValue();
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTaishoTanyi().clearValue();
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTaishoGaiTanyi().clearValue();
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtKeikakuNissu().clearValue();
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtJitsuNissuTankinyusho().clearValue();
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTanyigokeiDekikatabun().clearValue();
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtSeikyugakuDekikata().clearValue();
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtRiyoshaFutanDekikata().clearValue();
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtJitsuNissu().clearValue();
    }

    /**
     * modifyRow
     *
     * @param row dgdSeikyugakushukei_Row
     */
    public void modifyRow(dgdSeikyugakushukei_Row row) {

        RString state = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        if (修正.equals(state)) {
            boolean flag = checkState(row);
            if (flag) {
                row.setRowState(RowState.Modified);
                setDgdKyufuhiMeisai(row);
            }
        } else if (削除.equals(state)) {
            if (RowState.Added.equals(row.getRowState())) {
                div.getPanelSeikyugakuShukei().getDgdSeikyugakushukei().getDataSource().remove(
                        Integer.parseInt(div.getPanelSeikyugakuShukei().getRowId().toString()));
                clear請求額集計登録();
                div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().setDisabled(true);
            } else {
                row.setRowState(RowState.Deleted);
                setDgdKyufuhiMeisai(row);
            }
        } else if (登録.equals(state)) {
            row.setRowState(RowState.Added);
            setDgdKyufuhiMeisai(row);
        }

    }

    private boolean checkState(dgdSeikyugakushukei_Row ddgRow) {
        boolean flag = false;
        List<ShokanShukeiResult> shokanShukeiResult = ViewStateHolder.
                get(ViewStateKeys.請求額集計一覧情報, List.class);
        for (ShokanShukeiResult entityModified : shokanShukeiResult) {
            if (!ddgRow.getDefaultDataName15().isEmpty() && entityModified.getShukei().get連番().
                    equals(ddgRow.getDefaultDataName15())) {
                if (entityModified.getShukei().getサービス実日数() != Integer.parseInt(
                        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
                        getTxtJitsuNissu().getValue().toString())) {
                    flag = true;
                    break;
                }
                if (entityModified.getShukei().get計画単位数() != Integer.parseInt(
                        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
                        getTxtKeikakuTanyi().getValue().toString())) {
                    flag = true;
                    break;
                }
                if (entityModified.getShukei().get限度額管理対象単位数() != Integer.parseInt(
                        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
                        getTxtTaishoTanyi().getValue().toString())) {
                    flag = true;
                    break;
                }
                if (entityModified.getShukei().get限度額管理対象外単位数() != Integer.parseInt(
                        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
                        getTxtTaishoGaiTanyi().getValue().toString())) {
                    flag = true;
                    break;
                }
                if (entityModified.getShukei().get短期入所計画日数() != Integer.parseInt(
                        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
                        getTxtKeikakuNissu().getValue().toString())) {
                    flag = true;
                    break;
                }
                if (entityModified.getShukei().get短期入所実日数() != Integer.parseInt(
                        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
                        getTxtJitsuNissuTankinyusho().getValue().toString())) {
                    flag = true;
                    break;
                }
                if (entityModified.getShukei().get単位数合計() != Integer.parseInt(
                        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
                        getTxtTanyigokeiHokenbun().getValue().toString())) {
                    flag = true;
                    break;
                }
                if (entityModified.getShukei().get単位数単価()
                        != div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
                        getTxtTanyiTanka().getValue()) {
                    flag = true;
                    break;
                }
                if (entityModified.getShukei().get請求額()
                        != div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
                        getTxtSeikyugakuHoken().getValue()) {
                    flag = true;
                    break;
                }
                if (entityModified.getShukei().get利用者負担額() != Integer.parseInt(
                        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
                        getTxtRiyoshaFutanHoken().getValue().toString())) {
                    flag = true;
                    break;
                }
                if (entityModified.getShukei().get出来高医療費単位数合計() != Integer.parseInt(
                        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
                        getTxtTanyigokeiDekikatabun().getValue().toString())) {
                    flag = true;
                    break;
                }
                if (entityModified.getShukei().get出来高請求額差額金額() != Integer.parseInt(
                        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
                        getTxtSeikyugakuDekikata().getValue().toString())) {
                    flag = true;
                    break;
                }
                if (entityModified.getShukei().get出来高医療費利用者負担額()
                        != div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
                        getTxtRiyoshaFutanDekikata().getValue()) {
                    flag = true;
                    break;
                }

            }
        }
        return flag;
    }

    /**
     * setDgdKyufuhiMeisai
     *
     * @param ddgRow dgdSeikyugakushukei_Row
     */
    private void setDgdKyufuhiMeisai(dgdSeikyugakushukei_Row ddgRow) {
        //TODO
//        ServiceTypeInputCommonChildDivDiv sercode
//                = (ServiceTypeInputCommonChildDivDiv) div.getPanelSeikyugakuShukei().
//                getPanelSeikyuShokai().getCcdServiceTypeInput();

//        ddgRow.setDefaultDataName1(sercode.getTxtServiceType().getValue());
        if (div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTanyigokeiHokenbun().getValue() != null) {
            ddgRow.getDefaultDataName2().setValue(
                    div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTanyigokeiHokenbun().getValue());
        }
        if (div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTanyiTanka().getValue() != null) {
            ddgRow.getDefaultDataName3().setValue(
                    div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTanyiTanka().getValue());
        }
        if (div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtSeikyugakuHoken().getValue() != null) {
            ddgRow.getDefaultDataName4().setValue(
                    div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtSeikyugakuHoken().getValue());
        }
        if (div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtRiyoshaFutanHoken().getValue() != null) {
            ddgRow.getDefaultDataName6().setValue(
                    div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtRiyoshaFutanHoken().getValue());
        }
        if (div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getRdoShinsahouhou() != null) {
            ddgRow.setDefaultDataName5(div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
                    getRdoShinsahouhou().getSelectedValue());
        }
        if (div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTaishoTanyi().getValue() != null) {
            ddgRow.getDefaultDataName7().setValue(
                    div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTaishoTanyi().getValue());
        }
        if (div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTaishoGaiTanyi().getValue() != null) {
            ddgRow.getDefaultDataName8().setValue(
                    div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTaishoGaiTanyi().getValue());
        }
        if (div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtKeikakuNissu().getValue() != null) {
            ddgRow.getDefaultDataName9().setValue(
                    div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtKeikakuNissu().getValue());
        }
        if (div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtJitsuNissuTankinyusho().getValue() != null) {
            ddgRow.getDefaultDataName10().setValue(
                    div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtJitsuNissuTankinyusho().getValue());
        }
        if (div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTanyigokeiDekikatabun().getValue() != null) {
            ddgRow.getDefaultDataName11().setValue(
                    div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTanyigokeiDekikatabun().getValue());
        }
        if (div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtSeikyugakuDekikata().getValue() != null) {
            ddgRow.getDefaultDataName12().setValue(
                    div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtSeikyugakuDekikata().getValue());
        }
        if (div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtRiyoshaFutanDekikata().getValue() != null) {
            ddgRow.getDefaultDataName13().setValue(
                    div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtRiyoshaFutanDekikata().getValue());
        }
        if (div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtKeikakuTanyi().getValue() != null) {
            ddgRow.getDefaultDataName14().setValue(
                    div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtKeikakuTanyi().getValue());
        }
        if (div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtJitsuNissu().getValue() != null) {
            ddgRow.getDefaultDataName17().setValue(
                    div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtJitsuNissu().getValue());
        }
        if (div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getRdoShinsahouhou() != null) {
            ddgRow.setDefaultDataName18(div.getPanelSeikyugakuShukei().
                    getPanelSeikyuShokai().getRdoShinsahouhou().getSelectedKey());
        }
        if (登録.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            List<dgdSeikyugakushukei_Row> list = div.getPanelSeikyugakuShukei().getDgdSeikyugakushukei().getDataSource();
            list.add(ddgRow);
        }
        clear請求額集計登録();
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().setVisible(false);

    }

    /**
     * 計算する
     */
    public void 計算する() {
        if (div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTanyigokeiHokenbun().getValue() != null
                && div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTanyiTanka().getValue() != null
                && div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTanyigokeiDekikatabun().
                getValue() != null) {
            Decimal data1 = div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTanyigokeiHokenbun().
                    getValue().multiply(
                            div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
                            getTxtTanyiTanka().getValue()).multiply(
                            div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtKyufuritsu().getValue().divide(NUM1));
            Decimal data2 = div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTanyigokeiHokenbun().getValue().
                    multiply(div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
                            getTxtTanyiTanka().getValue()).subtract(data1);
            Decimal data3 = div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTanyigokeiDekikatabun().
                    getValue().multiply(NUM).
                    multiply(div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtKyufuritsu().getValue().divide(NUM1));
            Decimal data4 = div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTanyigokeiDekikatabun().
                    getValue().multiply(NUM).subtract(data3);
            div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtSeikyugakuHoken().setValue(data1);
            div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtRiyoshaFutanHoken().setValue(data2);
            div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtSeikyugakuDekikata().setValue(data3);
            div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtRiyoshaFutanDekikata().setValue(data4);
        }

    }

    /**
     * selectRow
     *
     * @return dgdSeikyugakushukei_Row
     */
    public dgdSeikyugakushukei_Row selectRow() {
        return div.getPanelSeikyugakuShukei().getDgdSeikyugakushukei().getDataSource().get(
                Integer.parseInt(div.getPanelSeikyugakuShukei().getRowId().getValue().toString()));

    }

    /**
     * 保存処理
     */
    public void 保存処理() {
        SyokanbaraihishikyushinseiketteParameter parameter = ViewStateHolder.
                get(ViewStateKeys.償還払費申請検索キー,
                        SyokanbaraihishikyushinseiketteParameter.class);
        FlexibleYearMonth サービス年月 = parameter.getServiceTeikyoYM();
        HihokenshaNo 被保険者番号 = parameter.getHiHokenshaNo();
        RString 整理番号 = parameter.getSeiriNp();
        RString 様式番号 = parameter.getYoshikiNo();
        RString 明細番号 = parameter.getMeisaiNo();
        JigyoshaNo 事業者番号 = parameter.getJigyoshaNo();
        List<ShokanShukei> entityList = new ArrayList<>();
        List<dgdSeikyugakushukei_Row> dgrow = div.getPanelSeikyugakuShukei().getDgdSeikyugakushukei().getDataSource();
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            SyokanbaraihiShikyuShinseiKetteManager.createInstance().
                    delShokanSyomeisyo(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        } else {
            int max連番 = 0;
            List<ShokanShukeiResult> shkonlist = ViewStateHolder.get(ViewStateKeys.請求額集計一覧情報, List.class);
            Map<RString, ShokanShukei> mapList = new HashMap<>();
            for (ShokanShukeiResult shokanShukeiResult : shkonlist) {
                mapList.put(shokanShukeiResult.getShukei().get連番(), shokanShukeiResult.getShukei());
                if (max連番 < Integer.valueOf(shokanShukeiResult.getShukei().get連番().toString())) {
                    max連番 = Integer.valueOf(shokanShukeiResult.getShukei().get連番().toString());
                }
            }
            for (dgdSeikyugakushukei_Row row : dgrow) {
                if (RowState.Modified.equals(row.getRowState())) {
                    //TODO
//                   RString serviceCodeShuruyi = new RString(row.getDefaultDataName1().substring(1, 2).toString());
                    ShokanShukei entityModified = mapList.get(row.getDefaultDataName15());
                    ShokanShukei shokanShukei = entityModified.createBuilderForEdit()
                            .setサービス種類コード(new ServiceShuruiCode(row.getDefaultDataName1()))
                            .set単位数合計(row.getDefaultDataName2().getValue().intValue())
                            .set単位数単価(row.getDefaultDataName3().getValue())
                            .set請求額(row.getDefaultDataName4().getValue())
                            .set利用者負担額(row.getDefaultDataName6().getValue().intValue())
                            .set限度額管理対象単位数(row.getDefaultDataName7().getValue().intValue())
                            .set限度額管理対象外単位数(row.getDefaultDataName8().getValue().intValue())
                            .set短期入所計画日数(row.getDefaultDataName9().getValue().intValue())
                            .set短期入所実日数(row.getDefaultDataName10().getValue().intValue())
                            .set出来高医療費単位数合計(row.getDefaultDataName11().getValue().intValue())
                            .set出来高医療費請求額(row.getDefaultDataName12().getValue())
                            .set出来高医療費利用者負担額(row.getDefaultDataName13().getValue())
                            .set計画単位数(row.getDefaultDataName14().getValue().intValue())
                            .setサービス実日数(row.getDefaultDataName17().getValue().intValue())
                            .set審査方法区分コード(row.getDefaultDataName18())
                            .build();
                    entityList.add(shokanShukei.modified());

                } else if (RowState.Deleted.equals(row.getRowState())) {
                    entityList.add(mapList.get(row.getDefaultDataName15()).deleted());
                } else if (RowState.Added.equals(row.getRowState())) {
                    max連番 = max連番 + 1;
                    ShokanShukei shme = new ShokanShukei(
                            被保険者番号,
                            サービス年月,
                            整理番号,
                            事業者番号,
                            様式番号,
                            明細番号,
                            new RString(String.valueOf(max連番))).createBuilderForEdit()
                            .setサービス種類コード(new ServiceShuruiCode("50"))
                            .set単位数合計(row.getDefaultDataName2().getValue().intValue())
                            .set単位数単価(row.getDefaultDataName3().getValue())
                            .set請求額(row.getDefaultDataName4().getValue())
                            .set利用者負担額(row.getDefaultDataName6().getValue().intValue())
                            .set限度額管理対象単位数(row.getDefaultDataName7().getValue().intValue())
                            .set限度額管理対象外単位数(row.getDefaultDataName8().getValue().intValue())
                            .set短期入所計画日数(row.getDefaultDataName9().getValue().intValue())
                            .set短期入所実日数(row.getDefaultDataName10().getValue().intValue())
                            .set出来高医療費単位数合計(row.getDefaultDataName11().getValue().intValue())
                            .set出来高医療費請求額(row.getDefaultDataName12().getValue())
                            .set出来高医療費利用者負担額(row.getDefaultDataName13().getValue())
                            .set計画単位数(row.getDefaultDataName14().getValue().intValue())
                            .setサービス実日数(row.getDefaultDataName17().getValue().intValue())
                            .set審査方法区分コード(row.getDefaultDataName18())
                            .build();
                    entityList.add(shme);

                } else {
                    ShokanShukei entityUnchanged = mapList.get(row.getDefaultDataName15());
                    entityList.add(entityUnchanged);
                }

            }
        }
        ShokanKihonParameter para = ShokanKihonParameter.createSelectByKeyParam(
                被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, 0);
        SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShukei(entityList, para);
    }

    /**
     * get内容変更状態
     *
     *
     * @return false
     */
    public boolean is内容変更状態() {

        for (dgdSeikyugakushukei_Row ddgList : div.getPanelSeikyugakuShukei().getDgdSeikyugakushukei()
                .getDataSource()) {
            if (RowState.Modified.equals(ddgList.getRowState())
                    || RowState.Added.equals(ddgList.getRowState())
                    || RowState.Deleted.equals(ddgList.getRowState())) {
                return true;
            }
        }

        return false;
    }

    /**
     * get制御
     *
     * @param shikibetsuNoKanri ShikibetsuNoKanri
     */
    public void get制御(ShikibetsuNoKanri shikibetsuNoKanri) {

        SyokanbaraihishikyushinseiketteParameter paramter = ViewStateHolder.
                get(ViewStateKeys.償還払費申請検索キー,
                        SyokanbaraihishikyushinseiketteParameter.class);
        HihokenshaNo 被保険者番号 = paramter.getHiHokenshaNo();
        FlexibleYearMonth サービス年月 = paramter.getServiceTeikyoYM();
        RString 整理番号 = paramter.getSeiriNp();
        JigyoshaNo 事業者番号 = paramter.getJigyoshaNo();
        RString 様式番号 = paramter.getYoshikiNo();
        RString 明細番号 = paramter.getMeisaiNo();
        div.getPanelHead().getBtnSeikyugakuShukei().setDisabled(true);
        div.getPanelHead().getBtnGoukeiInfo().setDisabled(false);
        set基本情報ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set給付費明細ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set特定診療費ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        setサービス計画費ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set特定入所者費用ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set給付費明細_住特ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set緊急時_所定疾患ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set緊急時施設療養費ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set食事費用ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set社福軽減額ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
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
            int count3 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanTokuteiShinryohi(被保険者番号,
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
        if (設定不可.equals(shikibetsuNoKanri.get特定疾患施設療養設定区分())) {
            div.getPanelHead().getBtnKinkyujiShoteiShikan().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get特定疾患施設療養設定区分())) {
            int count7 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShoteiShikkanShisetsuRyoyo(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count7 != 0) {
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
            if (count8 != 0) {
                div.getPanelHead().getBtnKinkyujiShisetsuRyoyo().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnKinkyujiShisetsuRyoyo().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get緊急時施設療養設定区分())) {
            div.getPanelHead().getBtnKinkyujiShisetsuRyoyo().setIconNameEnum(IconName.NONE);
        }
    }

    private void set食事費用ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get食事費用設定区分())) {
            div.getPanelHead().getBtnShokujiHiyo().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get食事費用設定区分())) {
            int count9 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShokujiHiyo(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count9 != 0) {
                div.getPanelHead().getBtnShokujiHiyo().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnShokujiHiyo().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get食事費用設定区分())) {
            div.getPanelHead().getBtnShokujiHiyo().setIconNameEnum(IconName.NONE);
        }
    }

    private void set社福軽減額ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get社会福祉法人軽減設定区分())) {
            div.getPanelHead().getBtnShafukukeigengaku().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get社会福祉法人軽減設定区分())) {
            int count11 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShakaiFukushiHojinKeigengaku(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count11 != 0) {
                div.getPanelHead().getBtnShafukukeigengaku().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnShafukukeigengaku().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get社会福祉法人軽減設定区分())) {
            div.getPanelHead().getBtnShafukukeigengaku().setIconNameEnum(IconName.NONE);
        }
    }

    /**
     * putViewState
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
        ViewStateHolder.put(ViewStateKeys.償還払費申請検索キー, paramter);
    }

    /**
     * readOnly請求額集計登録
     *
     * @param flag boolean
     */
    public void readOnly請求額集計登録(boolean flag) {
        ServiceTypeInputCommonChildDivDiv sercode
                = (ServiceTypeInputCommonChildDivDiv) div.getPanelSeikyugakuShukei().
                getPanelSeikyuShokai().getCcdServiceTypeInput();
        sercode.getTxtServiceType().setReadOnly(flag);
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getBtnCal().setDisabled(flag);
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getRdoShinsahouhou().setReadOnly(flag);
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTanyigokeiHokenbun().setReadOnly(flag);
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTanyiTanka().setReadOnly(flag);
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtKeikakuTanyi().setReadOnly(flag);
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTaishoTanyi().setReadOnly(flag);
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTaishoGaiTanyi().setReadOnly(flag);
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtKeikakuNissu().setReadOnly(flag);
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtJitsuNissuTankinyusho().setReadOnly(flag);
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTanyigokeiDekikatabun().setReadOnly(flag);
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtJitsuNissu().setReadOnly(flag);

    }

}
