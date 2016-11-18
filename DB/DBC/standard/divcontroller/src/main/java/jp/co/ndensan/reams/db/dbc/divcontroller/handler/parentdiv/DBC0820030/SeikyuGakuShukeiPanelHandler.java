/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820030;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanShukeiResult;
import jp.co.ndensan.reams.db.dbc.definition.core.shinsahoho.ShinsaHohoKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shoukanharaihishinseikensaku.ShoukanharaihishinseimeisaikensakuParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820030.SeikyuGakuShukeiPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820030.dgdSeikyugakushukei_Row;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanKihon;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanKihonBuilder;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShinsei;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShinseiBuilder;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShukei;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShukeiBuilder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.IconName;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 償還払い費支給申請決定_サービス提供証明書(請求額集計）
 *
 * @reamsid_L DBC-1030-100 quxiaodong
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
    private static final RString コロン = new RString(":");
    private static final int NUM = 10;
    private static final int NUM0 = 0;
    private static final int NUM2 = 2;
    private static final int NUM6 = 6;
    private static final int NUM100 = 100;
    private static Decimal 請求額合計 = Decimal.ZERO;
    private static Decimal 利用者負担額合計 = Decimal.ZERO;

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
     * @param shkanList ArrayList
     */
    public void initialize(ArrayList<ShokanShukeiResult> shkanList) {
        List<dgdSeikyugakushukei_Row> rowList = new ArrayList<>();
        for (ShokanShukeiResult shokanshukei : shkanList) {
            dgdSeikyugakushukei_Row row = new dgdSeikyugakushukei_Row();
            RString サービス種類コード = shokanshukei.getShukei().getサービス種類コード().value();
            RString サービス種類略称 = shokanshukei.getServiceShuruiRyakusho();
            RStringBuilder builder = new RStringBuilder();
            builder.append(サービス種類コード);
            if (サービス種類略称 != null) {
                builder.append(コロン);
                builder.append(サービス種類略称);
            }
            row.setDefaultDataName1(builder.toRString());
            row.getDefaultDataName2().setValue(new Decimal(shokanshukei.getShukei().get単位数合計()));
            row.getDefaultDataName3().setValue(shokanshukei.getShukei().get単位数単価());
            row.getDefaultDataName4().setValue(shokanshukei.getShukei().get請求額());
            if (ShinsaHohoKubun.toValue(shokanshukei.getShukei().get審査方法区分コード()) != null) {
                row.setDefaultDataName5(ShinsaHohoKubun.toValue(shokanshukei.getShukei().
                        get審査方法区分コード()).get名称());
            }
            if (EntityDataState.Added.equals(shokanshukei.getShukei().toEntity().getState())) {
                row.setRowState(RowState.Added);
            } else if (EntityDataState.Modified.equals(shokanshukei.getShukei().toEntity().getState())) {
                row.setRowState(RowState.Modified);
            } else if (EntityDataState.Deleted.equals(shokanshukei.getShukei().toEntity().getState())) {
                row.setRowState(RowState.Deleted);
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
            row.setDefaultDataName19(shokanshukei.getShukei().getサービス種類コード().value());
            rowList.add(row);
            Collections.sort(rowList, COMPARABLE);
        }
        div.getPanelSeikyugakuShukei()
                .getDgdSeikyugakushukei().setDataSource(rowList);
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
            RDate 申請日,
            RString 明細番号,
            RString 証明書) {
        div.getPanelHead().getTxtServiceTeikyoYM().setValue(new RDate(サービス年月.toString()));
        div.getPanelHead().getTxtShinseiYMD().setValue(申請日);
        div.getPanelHead().getTxtJigyoshaBango().setValue(事業者番号.getColumnValue());
        div.getPanelHead().getTxtMeisaiBango().setValue(明細番号);
        div.getPanelHead().getTxtShomeisho().setValue(証明書);
    }

    /**
     * set請求額集計登録
     *
     * @param 給付率 Decimal
     */
    public void set請求額集計登録(Decimal 給付率) {
        dgdSeikyugakushukei_Row row = div.getPanelSeikyugakuShukei().getDgdSeikyugakushukei().getClickedItem();
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtKyufuritsu().setValue(給付率);
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
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtJitsuNissu().setValue(
                row.getDefaultDataName17().getValue());
        if (row.getDefaultDataName19() != null && !row.getDefaultDataName19().isEmpty()) {
            div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getCcdServiceTypeInput().initialize(row.getDefaultDataName19());
        }

        div.getPanelSeikyugakuShukei().getRowId().setValue(new Decimal(row.getId()));
    }

    /**
     * clear請求額集計登録
     *
     */
    public void clear請求額集計登録() {
        div.getPanelSeikyugakuShukei().
                getPanelSeikyuShokai().getCcdServiceTypeInput().clear();
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
     * @param state RString
     * @param 一覧情報 ArrayList<ShokanShukeiResult>
     */
    public void modifyRow(dgdSeikyugakushukei_Row row, RString state, ArrayList<ShokanShukeiResult> 一覧情報) {
        ShokanShukeiResult 該当情報 = null;
        for (ShokanShukeiResult 情報 : 一覧情報) {
            if (情報.getShukei().get連番().equals(row.getDefaultDataName15())
                    && 情報.getShukei().get被保険者番号().getColumnValue().equals(div.getPanelCcd().getCcdKaigoShikakuKihon().get被保険者番号())
                    && 情報.getShukei().getサービス提供年月().toDateString().equals(div.getPanelHead().getTxtServiceTeikyoYM().getValue().toDateString().substring(NUM0, NUM6))
                    && 情報.getShukei().get整理番号().equals(div.getSeiriNo())
                    && 情報.getShukei().get事業者番号().getColumnValue().equals(div.getPanelHead().getTxtJigyoshaBango().getValue())
                    && 情報.getShukei().get様式番号().equals(div.getPanelHead().getTxtShomeisho().getValue())
                    && 情報.getShukei().get明細番号().equals(div.getPanelHead().getTxtMeisaiBango().getValue())) {
                該当情報 = 情報;
            }
        }

        if (修正.equals(state)) {
            boolean flag = checkState(row, 該当情報);
            if (flag) {
                row.setRowState(RowState.Modified);
                setDgdKyufuhiMeisai(row, state);
            }
        } else if (登録.equals(state)) {
            row.setRowState(RowState.Added);
            setDgdKyufuhiMeisai(row, state);
        } else if (削除.equals(state)) {
            row.setRowState(RowState.Deleted);
            setDgdKyufuhiMeisai(row, state);
        }
    }

    private boolean checkState(dgdSeikyugakushukei_Row row, ShokanShukeiResult 該当情報) {
        if (RowState.Added.equals(row.getRowState())) {
            return true;
        }
        if (!new Decimal(該当情報.getShukei().get単位数合計()).equals(div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
                getTxtTanyigokeiHokenbun().getValue())) {
            return true;
        }

        if (該当情報.getShukei().get単位数単価() == null) {
            return div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
                    getTxtTanyiTanka().getValue() != null;
        } else if (!該当情報.getShukei().get単位数単価().equals(div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
                getTxtTanyiTanka().getValue())) {
            return true;
        }

        if (該当情報.getShukei().get請求額() == null) {
            return div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
                    getTxtSeikyugakuHoken().getValue() != null;
        } else if (!該当情報.getShukei().get請求額().equals(div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
                getTxtSeikyugakuHoken().getValue())) {
            return true;
        }

        if (!new Decimal(該当情報.getShukei().get利用者負担額()).equals(div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
                getTxtRiyoshaFutanHoken().getValue())) {
            return true;
        }

        if (!new Decimal(該当情報.getShukei().get限度額管理対象単位数()).equals(div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
                getTxtTaishoTanyi().getValue())) {
            return true;
        }

        if (!new Decimal(該当情報.getShukei().get限度額管理対象外単位数()).equals(div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
                getTxtTaishoGaiTanyi().getValue())) {
            return true;
        }

        if (!new Decimal(該当情報.getShukei().get短期入所計画日数()).equals(div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
                getTxtKeikakuNissu().getValue())) {
            return true;
        }

        if (!new Decimal(該当情報.getShukei().get短期入所実日数()).equals(div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
                getTxtJitsuNissuTankinyusho().getValue())) {
            return true;
        }

        if (!new Decimal(該当情報.getShukei().get出来高医療費単位数合計()).equals(div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
                getTxtTanyigokeiDekikatabun().getValue())) {
            return true;
        }

        if (該当情報.getShukei().get出来高医療費請求額() == null) {
            return div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
                    getTxtSeikyugakuDekikata().getValue() != null;
        } else if (!該当情報.getShukei().get出来高医療費請求額().equals(div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
                getTxtSeikyugakuDekikata().getValue())) {
            return true;
        }

        if (該当情報.getShukei().get出来高医療費利用者負担額() == null) {
            return div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
                    getTxtRiyoshaFutanDekikata().getValue() != null;
        } else if (!該当情報.getShukei().get出来高医療費利用者負担額().equals(div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
                getTxtRiyoshaFutanDekikata().getValue())) {
            return true;
        }

        if (!new Decimal(該当情報.getShukei().get利用者負担額()).equals(div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
                getTxtRiyoshaFutanDekikata().getValue())) {
            return true;
        }

        checkStateTwo(該当情報);
        return false;

    }

    private boolean checkStateTwo(ShokanShukeiResult 該当情報) {
        if (!new Decimal(該当情報.getShukei().get計画単位数()).equals(div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
                getTxtKeikakuTanyi().getValue())) {
            return true;
        }

        if (該当情報.getShukei().getサービス種類コード() == null) {
            return div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getCcdServiceTypeInput().getサービス種類コード() != null;
        } else if (!該当情報.getShukei().getサービス種類コード().getColumnValue().equals(div.
                getPanelSeikyugakuShukei().getPanelSeikyuShokai().getCcdServiceTypeInput().getサービス種類コード())) {
            return true;
        }

        if (該当情報.getShukei().get審査方法区分コード() == null) {
            return true;
        } else if (!該当情報.getShukei().get審査方法区分コード().equals(div.
                getPanelSeikyugakuShukei().getPanelSeikyuShokai().getRdoShinsahouhou().getSelectedKey())) {
            return true;
        }

        return (!new Decimal(該当情報.getShukei().getサービス実日数()).equals(div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
                getTxtJitsuNissu().getValue()));
    }

    /**
     * setDgdKyufuhiMeisai
     *
     * @param ddgRow dgdSeikyugakushukei_Row
     * @param state RString
     */
    private void setDgdKyufuhiMeisai(dgdSeikyugakushukei_Row ddgRow, RString state) {
        RStringBuilder builder = new RStringBuilder();
        RString サービス種類コード = div.getPanelSeikyugakuShukei().
                getPanelSeikyuShokai().getCcdServiceTypeInput().getサービス種類コード();
        RString サービス種類略称 = div.getPanelSeikyugakuShukei().
                getPanelSeikyuShokai().getCcdServiceTypeInput().getサービス種類略称();
        builder.append(サービス種類コード);
        builder.append(コロン);
        builder.append(サービス種類略称);
        ddgRow.setDefaultDataName1(builder.toRString());
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
        ddgRow.setDefaultDataName18(div.getPanelSeikyugakuShukei().
                getPanelSeikyuShokai().getRdoShinsahouhou().getSelectedKey());
        if (div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getCcdServiceTypeInput().getサービス種類コード()
                != null && !div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
                getCcdServiceTypeInput().getサービス種類コード().isEmpty()) {
            ddgRow.setDefaultDataName19(div.getPanelSeikyugakuShukei().
                    getPanelSeikyuShokai().getCcdServiceTypeInput().getサービス種類コード());
        }
        if (登録.equals(state)) {
            List<dgdSeikyugakushukei_Row> list = div.getPanelSeikyugakuShukei().getDgdSeikyugakushukei().getDataSource();
            int 連番Num = 0;
            if (!list.isEmpty()) {
                連番Num = Integer.parseInt(list.get(NUM0).getDefaultDataName15().toString()) + 1;
            }
            RString 連番 = new RString(連番Num);
            ddgRow.setDefaultDataName15(連番.padLeft("0", NUM2));
            list.add(ddgRow);
            Collections.sort(list, COMPARABLE);
            div.getPanelSeikyugakuShukei().getDgdSeikyugakushukei().setDataSource(list);
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
                            div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtKyufuritsu().getValue().divide(NUM100));
            Decimal data2 = div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTanyigokeiHokenbun().getValue().
                    multiply(div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
                            getTxtTanyiTanka().getValue()).subtract(data1);
            Decimal data3 = div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTanyigokeiDekikatabun().
                    getValue().multiply(NUM).
                    multiply(div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtKyufuritsu().getValue().divide(NUM100));
            Decimal data4 = div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTanyigokeiDekikatabun().
                    getValue().multiply(NUM).subtract(data3);
            div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtSeikyugakuHoken().setValue(data1);
            div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtRiyoshaFutanHoken().setValue(data2);
            div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtSeikyugakuDekikata().setValue(data3);
            div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtRiyoshaFutanDekikata().setValue(data4);
        }
    }

    /**
     * 償還払請求集計_保存処理
     *
     * @param shkonlist ArrayList<ShokanShukeiResult> shkonlist
     *
     * @return ArrayList<ShokanShukeiResult>
     */
    public ArrayList<ShokanShukeiResult> 償還払請求集計_保存処理(ArrayList<ShokanShukeiResult> shkonlist) {
        List<dgdSeikyugakushukei_Row> rowList = div.getPanelSeikyugakuShukei().getDgdSeikyugakushukei().getDataSource();
        for (dgdSeikyugakushukei_Row row : rowList) {
            if (RowState.Added.equals(row.getRowState())) {
                shkonlist = add請求集計ToViewState(row, shkonlist);
            } else if (RowState.Modified.equals(row.getRowState())) {
                shkonlist = upDate請求集計ToViewState(row, shkonlist);
            } else if (RowState.Deleted.equals(row.getRowState())) {
                shkonlist = delete請求集計ToViewState(row, shkonlist);
            }
        }
        return shkonlist;
    }

    /**
     * 償還払請求基本_保存処理
     *
     * @param shkonlist ArrayList<ShokanKihon> shkonlist
     *
     * @return ArrayList<ShokanKihon>
     */
    public ArrayList<ShokanKihon> 償還払請求基本_保存処理(ArrayList<ShokanKihon> shkonlist) {
        List<dgdSeikyugakushukei_Row> rowList = div.getPanelSeikyugakuShukei().getDgdSeikyugakushukei().getDataSource();
        ShokanKihon 該当情報 = get情報FromViewState1(shkonlist);
        for (dgdSeikyugakushukei_Row row : rowList) {
            if (!RowState.Deleted.equals(row.getRowState())) {
                請求額合計 = 請求額合計.add(row.getDefaultDataName4().getValue());
                利用者負担額合計 = 利用者負担額合計.add(row.getDefaultDataName6().getValue());
            }
        }
        ShokanKihonBuilder 該当情報builder = 該当情報.createBuilderForEdit();
        該当情報builder.set保険請求額(請求額合計);
        該当情報builder.set利用者負担額(利用者負担額合計.intValue());
        set修正後情報_請求基本(shkonlist, 該当情報builder.build());
        return shkonlist;
    }

    /**
     * 償還払申請_保存処理
     *
     * @param shkonlist ShokanShinseit
     *
     * @return ShokanShinsei
     */
    public ShokanShinsei 償還払申請_保存処理(ShokanShinsei shkonlist) {
        ShokanShinseiBuilder 該当情報builder = shkonlist.createBuilderForEdit();
        該当情報builder.set保険給付額(請求額合計.intValue());
        該当情報builder.set利用者負担額(利用者負担額合計.intValue());
        該当情報builder.set支払金額合計(請求額合計.add(請求額合計));
        該当情報builder.set保険対象費用額(請求額合計.add(請求額合計));
        return 該当情報builder.build();
    }

    private ShokanShukei clearshokanShukei(ShokanShukei entity) {
        entity = entity.createBuilderForEdit()
                .set単位数合計(0)
                .set単位数単価(null)
                .set請求額(null)
                .set利用者負担額(0)
                .set限度額管理対象単位数(0)
                .set限度額管理対象外単位数(0)
                .set短期入所計画日数(0)
                .set短期入所実日数(0)
                .set出来高医療費単位数合計(0)
                .set出来高医療費請求額(null)
                .set出来高医療費利用者負担額(null)
                .set計画単位数(0)
                .setサービス実日数(0).build();
        return entity;
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
     * @param meisaiPar ShoukanharaihishinseimeisaikensakuParameter
     */
    public void get制御(ShikibetsuNoKanri shikibetsuNoKanri, ShoukanharaihishinseimeisaikensakuParameter meisaiPar) {
        HihokenshaNo 被保険者番号 = meisaiPar.get被保険者番号();
        FlexibleYearMonth サービス年月 = meisaiPar.getサービス年月();
        RString 整理番号 = meisaiPar.get整理番号();
        JigyoshaNo 事業者番号 = meisaiPar.get事業者番号();
        RString 様式番号 = meisaiPar.get様式番号();
        RString 明細番号 = meisaiPar.get明細番号();
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
     * readOnly請求額集計登録
     *
     * @param flag boolean
     */
    public void readOnly請求額集計登録(boolean flag) {
        div.getPanelSeikyugakuShukei().
                getPanelSeikyuShokai().getCcdServiceTypeInput().setReadOnly(flag);
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

    private ArrayList<ShokanShukeiResult> add請求集計ToViewState(dgdSeikyugakushukei_Row row, ArrayList<ShokanShukeiResult> 情報List) {
        ShokanShukeiResult 修正後情報 = onClick_最終確定_追加情報(row);
        boolean isViewDB存在 = false;
        for (ShokanShukeiResult 情報 : 情報List) {
            if (情報.getShukei().get被保険者番号().getColumnValue().equals(div.getPanelCcd().getCcdKaigoShikakuKihon().get被保険者番号())
                    && 情報.getShukei().getサービス提供年月().toDateString().equals(div.getPanelHead().getTxtServiceTeikyoYM().getValue().toDateString().substring(NUM0, NUM6))
                    && 情報.getShukei().get整理番号().equals(div.getSeiriNo())
                    && 情報.getShukei().get事業者番号().getColumnValue().equals(div.getPanelHead().getTxtJigyoshaBango().getValue())
                    && 情報.getShukei().get様式番号().equals(div.getPanelHead().getTxtShomeisho().getValue())
                    && 情報.getShukei().get明細番号().equals(div.getPanelHead().getTxtMeisaiBango().getValue())
                    && 情報.getShukei().get連番().equals(row.getDefaultDataName15())) {
                isViewDB存在 = true;
                break;
            }
        }
        if (!isViewDB存在) {
            情報List.add(修正後情報);
        }
        return 情報List;
    }

    private ArrayList<ShokanShukeiResult> upDate請求集計ToViewState(dgdSeikyugakushukei_Row row, ArrayList<ShokanShukeiResult> 情報List) {
        ShokanShukeiResult 該当情報 = get情報FromViewState(row, 情報List);
        ShokanShukeiResult 修正後情報 = onClick_最終確定_修正情報(row, 該当情報);
        set修正後情報(情報List, 修正後情報);
        return 情報List;
    }

    private ArrayList<ShokanShukeiResult> delete請求集計ToViewState(dgdSeikyugakushukei_Row row, ArrayList<ShokanShukeiResult> 情報List) {
        ShokanShukeiResult 該当情報 = get情報FromViewState(row, 情報List);
        if (EntityDataState.Added.equals(該当情報.getShukei().toEntity().getState())) {
            情報List.remove(該当情報);
        } else {
            該当情報.getShukei().deleted();
            set修正後情報(情報List, 該当情報);
        }
        return 情報List;
    }

    private ShokanShukeiResult get情報FromViewState(dgdSeikyugakushukei_Row row, List<ShokanShukeiResult> 情報List) {
        for (ShokanShukeiResult 情報 : 情報List) {
            if (情報.getShukei().get連番().equals(row.getDefaultDataName15())
                    && 情報.getShukei().get被保険者番号().getColumnValue().equals(div.getPanelCcd().getCcdKaigoShikakuKihon().get被保険者番号())
                    && 情報.getShukei().getサービス提供年月().toDateString().equals(div.getPanelHead().getTxtServiceTeikyoYM().getValue().toDateString().substring(NUM0, NUM6))
                    && 情報.getShukei().get整理番号().equals(div.getSeiriNo())
                    && 情報.getShukei().get事業者番号().getColumnValue().equals(div.getPanelHead().getTxtJigyoshaBango().getValue())
                    && 情報.getShukei().get様式番号().equals(div.getPanelHead().getTxtShomeisho().getValue())
                    && 情報.getShukei().get明細番号().equals(div.getPanelHead().getTxtMeisaiBango().getValue())) {
                return 情報;
            }
        }
        return null;
    }

    private ShokanKihon get情報FromViewState1(ArrayList<ShokanKihon> 情報List) {
        for (ShokanKihon 情報 : 情報List) {
            if (情報.get被保険者番号().getColumnValue().equals(div.getPanelCcd().getCcdKaigoShikakuKihon().get被保険者番号())
                    && 情報.getサービス提供年月().toDateString().equals(div.getPanelHead().getTxtServiceTeikyoYM().getValue().toDateString().substring(NUM0, NUM6))
                    && 情報.get整理番号().equals(div.getSeiriNo())
                    && 情報.get事業者番号().getColumnValue().equals(div.getPanelHead().getTxtJigyoshaBango().getValue())
                    && 情報.get様式番号().equals(div.getPanelHead().getTxtShomeisho().getValue())
                    && 情報.get明細番号().equals(div.getPanelHead().getTxtMeisaiBango().getValue())) {
                return 情報;
            }
        }
        return null;
    }

    private ShokanShukeiResult onClick_最終確定_修正情報(dgdSeikyugakushukei_Row row, ShokanShukeiResult 該当情報) {
        RString サービス種類略称 = RString.EMPTY;
        if (div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getCcdServiceTypeInput().getサービス種類名称() != null) {
            サービス種類略称 = div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getCcdServiceTypeInput().getサービス種類名称();
        }
        if (!EntityDataState.Added.equals(該当情報.getShukei().toEntity().getState())) {
            ShokanShukei 請求集計情報 = 該当情報.getShukei().modified();
            該当情報 = new ShokanShukeiResult(請求集計情報, サービス種類略称);
        }
        return new ShokanShukeiResult(update償還払請求集計情報(row, 該当情報).build(), サービス種類略称);
    }

    private ShokanShukeiResult onClick_最終確定_追加情報(dgdSeikyugakushukei_Row row) {
        RString サービス種類略称 = RString.EMPTY;
        if (div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getCcdServiceTypeInput().getサービス種類名称() != null) {
            サービス種類略称 = div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getCcdServiceTypeInput().getサービス種類名称();
        }
        RString 連番 = new RString(row.getDefaultDataName2().getValue().toString());
        HihokenshaNo 被保険者番号 = new HihokenshaNo(div.getPanelCcd().getCcdKaigoShikakuKihon().get被保険者番号());
        FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth(div.getPanelHead().getTxtServiceTeikyoYM().getValue().toDateString().substring(NUM0, NUM6));
        RString 整理番号 = div.getSeiriNo();
        JigyoshaNo 事業者番号 = new JigyoshaNo(div.getPanelHead().getTxtJigyoshaBango().getValue());
        RString 様式番号 = div.getPanelHead().getTxtShomeisho().getValue();
        RString 明細番号 = div.getPanelHead().getTxtMeisaiBango().getValue();
        ShokanShukei 該当請求集計情報 = new ShokanShukei(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号, 連番);
        ShokanShukei 請求集計情報 = 該当請求集計情報.added();
        ShokanShukeiResult 該当情報 = new ShokanShukeiResult(請求集計情報, サービス種類略称);
        return new ShokanShukeiResult(update償還払請求集計情報(row, 該当情報).build(), サービス種類略称);
    }

    private ShokanShukeiBuilder update償還払請求集計情報(dgdSeikyugakushukei_Row row, ShokanShukeiResult 該当情報) {
        ShokanShukeiBuilder shokanShukeiBuilder = 該当情報.getShukei().createBuilderForEdit();

        if (row.getDefaultDataName19() != null && !row.getDefaultDataName19().isEmpty()) {
            shokanShukeiBuilder.setサービス種類コード(
                    new ServiceShuruiCode(row.getDefaultDataName19()));
        }
        if (row.getDefaultDataName2() != null) {
            shokanShukeiBuilder.set単位数合計(row.getDefaultDataName2().
                    getValue().intValue());
        }
        if (row.getDefaultDataName3() != null) {
            shokanShukeiBuilder.set単位数単価(row.getDefaultDataName3().
                    getValue());
        }
        if (row.getDefaultDataName4() != null) {
            shokanShukeiBuilder.set請求額(row.getDefaultDataName4().
                    getValue());
        }
        if (row.getDefaultDataName6() != null) {
            shokanShukeiBuilder.set利用者負担額(
                    row.getDefaultDataName6().getValue().intValue());
        }
        if (row.getDefaultDataName7() != null) {
            shokanShukeiBuilder.set限度額管理対象単位数(
                    row.getDefaultDataName7().getValue().intValue());
        }
        if (row.getDefaultDataName8() != null) {
            shokanShukeiBuilder.set限度額管理対象外単位数(
                    row.getDefaultDataName8().getValue().intValue());
        }
        if (row.getDefaultDataName9() != null) {
            shokanShukeiBuilder.set短期入所計画日数(
                    row.getDefaultDataName9().getValue().intValue());
        }
        if (row.getDefaultDataName10() != null) {
            shokanShukeiBuilder.set短期入所実日数(
                    row.getDefaultDataName10().getValue().intValue());
        }
        if (row.getDefaultDataName11() != null) {
            shokanShukeiBuilder.set出来高医療費単位数合計(
                    row.getDefaultDataName11().getValue().intValue());
        }
        if (row.getDefaultDataName12() != null) {
            shokanShukeiBuilder.set出来高医療費請求額(
                    row.getDefaultDataName12().getValue());
        }
        if (row.getDefaultDataName13() != null) {
            shokanShukeiBuilder.set出来高医療費利用者負担額(
                    row.getDefaultDataName13().getValue());
        }
        if (row.getDefaultDataName14() != null) {
            shokanShukeiBuilder.set計画単位数(
                    row.getDefaultDataName14().getValue().intValue());
        }
        if (row.getDefaultDataName17() != null) {
            shokanShukeiBuilder.setサービス実日数(
                    row.getDefaultDataName17().getValue().intValue());
        }
        if (row.getDefaultDataName18() != null) {
            shokanShukeiBuilder.set審査方法区分コード(row.getDefaultDataName18());
        }
        return shokanShukeiBuilder;
    }

    private void set修正後情報(List<ShokanShukeiResult> 情報List, ShokanShukeiResult 修正後情報) {
        for (int index = 0; index < 情報List.size(); index++) {
            if (修正後情報.getShukei().identifier().equals(情報List.get(index).getShukei().identifier())) {
                情報List.add(index, 修正後情報);
                情報List.remove(index + 1);
                return;
            }
        }
    }

    private void set修正後情報_請求基本(List<ShokanKihon> 情報List, ShokanKihon 修正後情報) {
        for (int index = 0; index < 情報List.size(); index++) {
            if (修正後情報.identifier().equals(情報List.get(index).identifier())) {
                情報List.add(index, 修正後情報);
                情報List.remove(index + 1);
                return;
            }
        }
    }

    private static final Comparator COMPARABLE = new Comparator<dgdSeikyugakushukei_Row>() {
        @Override
        public int compare(dgdSeikyugakushukei_Row o1, dgdSeikyugakushukei_Row o2) {
            return -(Integer.parseInt(o1.getDefaultDataName15().toString())
                    - Integer.parseInt(o2.getDefaultDataName15().toString()));
        }
    };
}
