/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0820030;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShukei;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanShukeiResult;
import jp.co.ndensan.reams.db.dbc.definition.core.shinsahoho.ShinsaHohoKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820030.SeikyuGakuShukeiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820030.dgdSeikyugakushukei_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.syokanbaraihishikyushinseikette.SyokanbaraihishikyushinseiketteParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3118ShikibetsuNoKanriEntity;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.IconName;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 償還払い費支給申請決定_サービス提供証明書(請求額集計）
 *
 * @author 瞿暁東
 */
public class SeikyuGakuShukeiPanelHandler {

    private final SeikyuGakuShukeiDiv div;
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");
    private static final RString 設定不可 = new RString("0");
    private static final RString 設定可必須 = new RString("1");
    private static final RString 設定可任意 = new RString("1");
    private static final RString 申請を保存する = new RString("Element3");

    public SeikyuGakuShukeiPanelHandler(SeikyuGakuShukeiDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理します。
     *
     * @param shkanList
     */
    public void initialize(List<ShokanShukeiResult> shkanList) {
        List<dgdSeikyugakushukei_Row> rowList = new ArrayList<>();
        for (ShokanShukeiResult shokanshukei : shkanList) {
            dgdSeikyugakushukei_Row row = new dgdSeikyugakushukei_Row();
            row.setDefaultDataName1(shokanshukei.getShukei().toEntity().getServiceShuruiCode().value());
            row.getDefaultDataName2().setValue(new Decimal(shokanshukei.getShukei().toEntity().getTanisuTotal()));
            row.getDefaultDataName3().setValue(shokanshukei.getShukei().toEntity().getTanisuTanka());
            row.getDefaultDataName4().setValue(shokanshukei.getShukei().toEntity().getSeikyugaku());
            row.getDefaultDataName6().setValue(new Decimal(shokanshukei.getShukei().toEntity().getRiyoshaFutangaku()));
            if (ShinsaHohoKubun.toValue(shokanshukei.getShukei().toEntity().getShinsaHohoKubunCode()) != null) {
                row.setDefaultDataName5(ShinsaHohoKubun.toValue(shokanshukei.getShukei().toEntity().getShinsaHohoKubunCode()).get名称());
            }
            rowList.add(row);
        }
        div.getPanelSeikyugakuShukei().getDgdSeikyugakushukei().setDataSource(rowList);

    }

    public void set申請共通エリア(
            FlexibleYearMonth サービス年月,
            JigyoshaNo 事業者番号,
            RString 申請日,
            RString 明細番号,
            RString 証明書) {
        div.getPanelHead().getTxtServiceTeikyoYM().setDomain(new RYearMonth(サービス年月.toDateString()));
        div.getPanelHead().getTxtShinseiYMD().setValue(new RDate(申請日.toString()));
        div.getPanelHead().getTxtJigyoshaBango().setValue(事業者番号.getColumnValue());
        div.getPanelHead().getTxtMeisaiBango().setValue(明細番号);
        div.getPanelHead().getTxtShomeisho().setValue(証明書);
    }

    public void set請求額集計登録() {
        List<KeyValueDataSource> source = new ArrayList<>();

        dgdSeikyugakushukei_Row row = div.getPanelSeikyugakuShukei().getDgdSeikyugakushukei().getClickedItem();
        ViewStateHolder.put(ViewStateKeys.給付率, div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtKyufuritsu().getValue());
        Decimal 給付率 = ViewStateHolder.get(ViewStateKeys.給付率, Decimal.class);
        source.add(new KeyValueDataSource(new RString(row.getDefaultDataName5().toString()), new RString("審査方法区分")));
        //TODO dbz共同div暂时未写对应地方法（サービスコード入力ガイド）
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTanyigokeiHokenbun().setValue(new Decimal(row.getDefaultDataName2().toString()));
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTanyiTanka().setValue(new Decimal(row.getDefaultDataName3().toString()));
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtSeikyugakuHoken().setValue(new Decimal(row.getDefaultDataName4().toString()));
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtRiyoshaFutanHoken().setValue(new Decimal(row.getDefaultDataName6().toString()));
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getRdoShinsahouhou().setDataSource(source);
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtKeikakuTanyi().setValue(new Decimal(row.getDefaultDataName14().toString()));
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTaishoTanyi().setValue(new Decimal(row.getDefaultDataName7().toString()));
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTaishoGaiTanyi().setValue(new Decimal(row.getDefaultDataName8().toString()));
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtKeikakuNissu().setValue(new Decimal(row.getDefaultDataName9().toString()));
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtJitsuNissuTankinyusho().setValue(new Decimal(row.getDefaultDataName10().toString()));
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTanyigokeiDekikatabun().setValue(new Decimal(row.getDefaultDataName11().toString()));
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtSeikyugakuDekikata().setValue(new Decimal(row.getDefaultDataName12().toString()));
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtRiyoshaFutanDekikata().setValue(new Decimal(row.getDefaultDataName13().toString()));

    }

    public void clear請求額集計登録() {
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
    }

    public void modifyRow(dgdSeikyugakushukei_Row row) {
        List<KeyValueDataSource> source = new ArrayList<>();
        RString state = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        if (修正.equals(state)) {
            row.setRowState(RowState.Modified);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(申請を保存する, false);
        } else if (削除.equals(state)) {
            row.setRowState(RowState.Deleted);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(申請を保存する, false);
        } else if (登録.equals(state)) {
            row.setRowState(RowState.Added);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(申請を保存する, false);
        }
        //TODO dbz暂时没有提供相应的类
        //row.setDefaultDataName1();
        source.add(new KeyValueDataSource(new RString(div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getRdoShinsahouhou().toString()), new RString("審査方法区分")));
        row.setDefaultDataName2(div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTanyigokeiHokenbun());
        row.setDefaultDataName3(div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTanyiTanka());
        row.setDefaultDataName4(div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtSeikyugakuHoken());
        row.setDefaultDataName6(div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtRiyoshaFutanHoken());
        row.setDefaultDataName5(source.get(0).getValue());
        row.setDefaultDataName7(div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTaishoTanyi());
        row.setDefaultDataName8(div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTaishoGaiTanyi());
        row.setDefaultDataName9(div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtKeikakuNissu());
        row.setDefaultDataName10(div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtJitsuNissuTankinyusho());
        row.setDefaultDataName11(div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTanyigokeiDekikatabun());
        row.setDefaultDataName12(div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtSeikyugakuDekikata());
        row.setDefaultDataName13(div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtRiyoshaFutanDekikata());
        row.setDefaultDataName14(div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtKeikakuTanyi());

        clear請求額集計登録();
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().setVisible(false);
    }

    public void 計算する() {
        Decimal data1, data2, data3, data4 = null;
        if (div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTanyigokeiHokenbun().getValue() != null
                || div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTanyiTanka().getValue() != null
                || div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTanyigokeiDekikatabun().getValue() != null) {
            data1 = div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTanyigokeiHokenbun().getValue().multiply(div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
                    getTxtTanyiTanka().getValue()).multiply(div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtKyufuritsu().getValue());
            data2 = div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTanyigokeiHokenbun().getValue().multiply(div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
                    getTxtTanyiTanka().getValue()).subtract(data1);
            data3 = div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTanyigokeiDekikatabun().getValue().multiply(10).
                    multiply(div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtKyufuritsu().getValue());
            data4 = div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTanyigokeiDekikatabun().getValue().multiply(10).subtract(data3);
            div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtSeikyugakuHoken().setValue(data1);
            div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtRiyoshaFutanHoken().setValue(data2);
            div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtSeikyugakuDekikata().setValue(data3);
            div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtRiyoshaFutanDekikata().setValue(data4);
        }

    }

    public dgdSeikyugakushukei_Row selectRow() {
        return div.getPanelSeikyugakuShukei().getDgdSeikyugakushukei().getDataSource().get(Integer.parseInt(div.getPanelSeikyugakuShukei().getRowId().getValue().toString()));

    }

    public void 保存処理() {
        SyokanbaraihishikyushinseiketteParameter par = new SyokanbaraihishikyushinseiketteParameter(
                new HihokenshaNo("0000030"), new FlexibleYearMonth(new RString("201406")),
                new RString("1111"), new JigyoshaNo("3333"), new RString("2222"),
                new RString("4444"), null);
        ViewStateHolder.put(ViewStateKeys.償還払費申請検索キー, par);
        SyokanbaraihishikyushinseiketteParameter parameter = ViewStateHolder.get(ViewStateKeys.償還払費申請検索キー,
                SyokanbaraihishikyushinseiketteParameter.class);
        FlexibleYearMonth サービス年月 = parameter.getServiceTeikyoYM();
        HihokenshaNo 被保険者番号 = parameter.getHiHokenshaNo();
        RString 整理番号 = parameter.getSeiriNp();
        RString 様式番号 = parameter.getYoshikiNo();
        RString 明細番号 = parameter.getMeisaiNo();
        JigyoshaNo 事業者番号 = parameter.getJigyoshaNo();
        List<ShokanShukei> shkonlist = ViewStateHolder.get(ViewStateKeys.給付費明細登録, List.class);
        List<ShokanShukei> entityList = new ArrayList<>();
        List<dgdSeikyugakushukei_Row> dgrow = div.getPanelSeikyugakuShukei().getDgdSeikyugakushukei().getDataSource();
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            SyokanbaraihiShikyuShinseiKetteManager.createInstance().
                    delShokanSyomeisyo(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        } else {
            for (dgdSeikyugakushukei_Row row : dgrow) {
                if (RowState.Modified.equals(row.getRowState())) {
                    for (ShokanShukei entityModified : shkonlist) {
                        if (row.getDefaultDataName15().equals(entityModified.get連番())) {
                            entityModified = entityModified.createBuilderForEdit()
                                    .setサービス種類コード(new ServiceShuruiCode(row.getDefaultDataName1().toString()))
                                    .set単位数合計(Integer.parseInt(row.getDefaultDataName2().toString()))
                                    .set単位数単価(row.getDefaultDataName3().getValue())
                                    .set請求額(row.getDefaultDataName4().getValue())
                                    .set利用者負担額(Integer.parseInt(row.getDefaultDataName6().toString()))
                                    .set審査方法区分コード(row.getDefaultDataName5())
                                    .set限度額管理対象単位数(Integer.valueOf(row.getDefaultDataName7().getValue().toString()))
                                    .set限度額管理対象外単位数(Integer.valueOf(row.getDefaultDataName8().getValue().toString()))
                                    .set短期入所計画日数(Integer.valueOf(row.getDefaultDataName9().getValue().toString()))
                                    .set短期入所実日数(Integer.valueOf(row.getDefaultDataName10().getValue().toString()))
                                    .set出来高医療費単位数合計(Integer.valueOf(row.getDefaultDataName11().getValue().toString()))
                                    .set出来高医療費請求額(row.getDefaultDataName12().getValue())
                                    .set出来高医療費利用者負担額(row.getDefaultDataName13().getValue())
                                    .set計画単位数(Integer.valueOf(row.getDefaultDataName14().getValue().toString()))
                                    .build();
                            entityModified.toEntity().setState(EntityDataState.Modified);
                            entityList.add(entityModified);
                        }
                    }

                } else if (RowState.Deleted.equals(row.getRowState())) {
                    for (ShokanShukei entityDeleted : shkonlist) {
                        if (row.getDefaultDataName15().equals(entityDeleted.get連番())) {
                            entityDeleted.toEntity().setState(EntityDataState.Deleted);
                            entityList.add(entityDeleted);
                        }
                    }
                } else if (RowState.Added.equals(row.getRowState())) {
                    ShokanShukei shme = new ShokanShukei(
                            被保険者番号,
                            サービス年月,
                            整理番号,
                            事業者番号,
                            様式番号,
                            明細番号,
                            row.getDefaultDataName15()).createBuilderForEdit()
                            .setサービス種類コード(new ServiceShuruiCode(row.getDefaultDataName1().toString()))
                            .set単位数合計(Integer.parseInt(row.getDefaultDataName2().toString()))
                            .set単位数単価(row.getDefaultDataName3().getValue())
                            .set請求額(row.getDefaultDataName4().getValue())
                            .set利用者負担額(Integer.parseInt(row.getDefaultDataName6().toString()))
                            .set審査方法区分コード(row.getDefaultDataName5())
                            .set限度額管理対象単位数(Integer.valueOf(row.getDefaultDataName7().getValue().toString()))
                            .set限度額管理対象外単位数(Integer.valueOf(row.getDefaultDataName8().getValue().toString()))
                            .set短期入所計画日数(Integer.valueOf(row.getDefaultDataName9().getValue().toString()))
                            .set短期入所実日数(Integer.valueOf(row.getDefaultDataName10().getValue().toString()))
                            .set出来高医療費単位数合計(Integer.valueOf(row.getDefaultDataName11().getValue().toString()))
                            .set出来高医療費請求額(row.getDefaultDataName12().getValue())
                            .set出来高医療費利用者負担額(row.getDefaultDataName13().getValue())
                            .set計画単位数(Integer.valueOf(row.getDefaultDataName14().getValue().toString()))
                            .build();
                    shme.toEntity().setState(EntityDataState.Added);
                    entityList.add(shme);

                }

            }
        }
//        SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShukei(entityList);
    }

    public boolean get内容変更状態(FlexibleYearMonth サービス年月) {
        if (サービス年月.isBeforeOrEquals(new FlexibleYearMonth("200503"))) {
            for (dgdSeikyugakushukei_Row ddgList : div.getPanelSeikyugakuShukei().getDgdSeikyugakushukei().getDataSource()) {
                if (RowState.Modified.equals(ddgList.getRowState())
                        || RowState.Added.equals(ddgList.getRowState())
                        || RowState.Deleted.equals(ddgList.getRowState())) {
                    return true;
                }
            }
        }
        // 請求額集計一覧
        if (new FlexibleYearMonth("200504").isBeforeOrEquals(サービス年月)) {
            for (dgdSeikyugakushukei_Row dgdRow : div.getPanelSeikyugakuShukei().getDgdSeikyugakushukei().getDataSource()) {
                if (RowState.Modified.equals(dgdRow.getRowState())
                        || RowState.Added.equals(dgdRow.getRowState())
                        || RowState.Deleted.equals(dgdRow.getRowState())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void getボタンを制御(DbT3118ShikibetsuNoKanriEntity entity) {

        SyokanbaraihishikyushinseiketteParameter paramter = ViewStateHolder.get(ViewStateKeys.償還払費申請検索キー,
                SyokanbaraihishikyushinseiketteParameter.class);
        HihokenshaNo 被保険者番号 = paramter.getHiHokenshaNo();
        FlexibleYearMonth サービス年月 = paramter.getServiceTeikyoYM();
        RString 整理番号 = paramter.getSeiriNp();
        JigyoshaNo 事業者番号 = paramter.getJigyoshaNo();
        RString 様式番号 = paramter.getYoshikiNo();
        RString 明細番号 = paramter.getMeisaiNo();
        // 基本情報
        if (設定不可.equals(entity.getKihonSetteiKubun())) {
            div.getPanelHead().getBtnKihonInfo().setDisabled(true);
        } else if (設定可必須.equals(entity.getKihonSetteiKubun())) {
            int count1 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().getShokanKihonCount(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count1 == 1) {
                div.getPanelHead().getBtnKihonInfo().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnKihonInfo().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.getKihonSetteiKubun())) {
            div.getPanelHead().getBtnKihonInfo().setIconNameEnum(IconName.NONE);
        }
        // 給付費明細
        if (設定不可.equals(entity.getMeisaiSetteiKubun())) {
            div.getPanelHead().getBtnKyufuhiMeisai().setDisabled(true);
        } else if (設定可必須.equals(entity.getMeisaiSetteiKubun())) {
            int count2 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().delShokanMeisaiCount(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count2 == 1) {
                div.getPanelHead().getBtnKyufuhiMeisai().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnKyufuhiMeisai().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.getMeisaiSetteiKubun())) {
            div.getPanelHead().getBtnKyufuhiMeisai().setIconNameEnum(IconName.NONE);
        }
        // 特定診療費
        div.getPanelHead().getBtnTokuteiShinryohi().setDisabled(true);
        if (設定不可.equals(entity.getTokuteiShinryoSetteiKubun())) {
            div.getPanelHead().getBtnTokuteiShinryohi().setDisabled(true);
        } else if (設定可必須.equals(entity.getTokuteiShinryoSetteiKubun())) {
            int count3 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanTokuteiShinryohi(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count3 == 1) {
                div.getPanelHead().getBtnTokuteiShinryohi().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnTokuteiShinryohi().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.getTokuteiShinryoSetteiKubun())) {
            div.getPanelHead().getBtnTokuteiShinryohi().setIconNameEnum(IconName.NONE);
        }
        if (設定不可.equals(entity.getKyotakuKeikakuSetteiKubun())) {
            div.getPanelHead().getBtnServiceKeikakuhi().setDisabled(true);
        } else if (設定可必須.equals(entity.getKyotakuKeikakuSetteiKubun())) {
            // TODO サービス計画費情報件数を呼び出す
            int count4 = 1;
//                    SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanServicePlan(被保険者番号,
//                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count4 == 1) {
                div.getPanelHead().getBtnServiceKeikakuhi().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnServiceKeikakuhi().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.getKyotakuKeikakuSetteiKubun())) {
            div.getPanelHead().getBtnServiceKeikakuhi().setIconNameEnum(IconName.NONE);
        }
        // 特定入所者費用
        if (設定不可.equals(entity.getTokuteinyushoshaSetteiKubun())) {
            div.getPanelHead().getBtnTokuteiNyushosya().setDisabled(true);
        } else if (設定可必須.equals(entity.getTokuteinyushoshaSetteiKubun())) {
            int count5 = SyokanbaraihiShikyuShinseiKetteManager.createInstance()
                    .updShokanTokuteiNyushoshaKaigoServiceHiyo(被保険者番号, サービス年月, 整理番号,
                            事業者番号, 様式番号, 明細番号);
            if (count5 == 1) {
                div.getPanelHead().getBtnTokuteiNyushosya().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnTokuteiNyushosya().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.getTokuteinyushoshaSetteiKubun())) {
            div.getPanelHead().getBtnTokuteiNyushosya().setIconNameEnum(IconName.NONE);
        }
        // 合計情報
        div.getPanelHead().getBtnGoukeiInfo().setDisabled(false);
        // 給付費明細（住特）
        if (設定不可.equals(entity.getMeisaiJushochitokureiSetteiKubun())) {
            div.getPanelHead().getBtnKyufuhiMeisaiJyuchi().setDisabled(true);
        } else if (設定可必須.equals(entity.getMeisaiJushochitokureiSetteiKubun())) {
            int count6 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().getShokanMeisaiJushochiTokureiCount(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count6 == 1) {
                div.getPanelHead().getBtnKyufuhiMeisaiJyuchi().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnKyufuhiMeisaiJyuchi().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.getMeisaiJushochitokureiSetteiKubun())) {
            div.getPanelHead().getBtnKyufuhiMeisaiJyuchi().setIconNameEnum(IconName.NONE);
        }
        // 緊急時・所定疾患
        if (設定不可.equals(entity.getTokuteiShikkanSetteiKubun())) {
            div.getPanelHead().getBtnKinkyujiShoteiShikan().setDisabled(true);
        } else if (設定可必須.equals(entity.getTokuteiShikkanSetteiKubun())) {
            int count7 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShoteiShikkanShisetsuRyoyo(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count7 == 1) {
                div.getPanelHead().getBtnKinkyujiShoteiShikan().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnKinkyujiShoteiShikan().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.getTokuteiShikkanSetteiKubun())) {
            div.getPanelHead().getBtnKinkyujiShoteiShikan().setIconNameEnum(IconName.NONE);
        }
        // 緊急時施設療養費
        if (設定不可.equals(entity.getKinkyuShisetsuRyoyoSetteiKubun())) {
            div.getPanelHead().getBtnKinkyujiShisetsuRyoyo().setDisabled(true);
        } else if (設定可必須.equals(entity.getKinkyuShisetsuRyoyoSetteiKubun())) {
            int count8 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanKinkyuShisetsuRyoyo(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count8 == 1) {
                div.getPanelHead().getBtnKinkyujiShisetsuRyoyo().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnKinkyujiShisetsuRyoyo().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.getKinkyuShisetsuRyoyoSetteiKubun())) {
            div.getPanelHead().getBtnKinkyujiShisetsuRyoyo().setIconNameEnum(IconName.NONE);
        }
        // 食事費用
        if (設定不可.equals(entity.getShokujiHiyosetteiKubun())) {
            div.getPanelHead().getBtnShokujiHiyo().setDisabled(true);
        } else if (設定可必須.equals(entity.getShokujiHiyosetteiKubun())) {
            int count9 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShokujiHiyo(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count9 == 1) {
                div.getPanelHead().getBtnShokujiHiyo().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnShokujiHiyo().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.getShokujiHiyosetteiKubun())) {
            div.getPanelHead().getBtnShokujiHiyo().setIconNameEnum(IconName.NONE);
        }
        // 請求額集計
        if (設定不可.equals(entity.getShukeiSetteiKubun())) {
            div.getPanelHead().getBtnSeikyugakuShukei().setDisabled(true);
        } else if (設定可必須.equals(entity.getShukeiSetteiKubun())) {
            int count10 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShukei(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count10 == 1) {
                div.getPanelHead().getBtnSeikyugakuShukei().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnSeikyugakuShukei().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.getShukeiSetteiKubun())) {
            div.getPanelHead().getBtnSeikyugakuShukei().setIconNameEnum(IconName.NONE);
        }
        // 社福軽減額
        if (設定不可.equals(entity.getShakaifukushiKeigenSetteiKubun())) {
            div.getPanelHead().getBtnShafukukeigengaku().setDisabled(true);
        } else if (設定可必須.equals(entity.getShakaifukushiKeigenSetteiKubun())) {
            int count11 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShakaiFukushiHojinKeigengaku(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count11 == 1) {
                div.getPanelHead().getBtnShafukukeigengaku().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnShafukukeigengaku().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.getShakaifukushiKeigenSetteiKubun())) {
            div.getPanelHead().getBtnShafukukeigengaku().setIconNameEnum(IconName.NONE);
        }
    }

    public void putViewState() {
        // TODO 支給申請画面のモード　
        ViewStateHolder.put(ViewStateKeys.処理モード, "");
        ViewStateHolder.put(ViewStateKeys.申請日, div.getPanelHead().getTxtShinseiYMD().getValue());
        SyokanbaraihishikyushinseiketteParameter paramter = new SyokanbaraihishikyushinseiketteParameter(
                ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class),
                new FlexibleYearMonth(div.getPanelHead().getTxtServiceTeikyoYM().getDomain().toDateString()),
                ViewStateHolder.get(ViewStateKeys.整理番号, RString.class),
                new JigyoshaNo(div.getPanelHead().getTxtJigyoshaBango().getValue()),
                div.getPanelHead().getTxtShomeisho().getValue(),
                div.getPanelHead().getTxtMeisaiBango().getValue(),
                null);
        ViewStateHolder.put(ViewStateKeys.償還払費申請検索キー, paramter);
    }

}
