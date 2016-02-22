/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0820022;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanMeisai;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanMeisaiResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820022.KyufuShiharayiMeisaiPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820022.dgdKyufuhiMeisai_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.syokanbaraihishikyushinseikette.SyokanbaraihishikyushinseiketteParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3118ShikibetsuNoKanriEntity;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.IconName;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 償還払い費支給申請決定_サービス提供証明書(給付費明細）
 *
 *
 */
public class KyufuShiharayiMeisaiPanelHandler {

    private final KyufuShiharayiMeisaiPanelDiv div;
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");
    private static final RString 登録_削除 = new RString("登録_削除");
    private static final RString 設定不可 = new RString("0");
    private static final RString 設定可必須 = new RString("1");
    private static final RString 設定可任意 = new RString("1");
    private static final RString 申請を保存する = new RString("Element3");

    public KyufuShiharayiMeisaiPanelHandler(KyufuShiharayiMeisaiPanelDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理します。
     *
     * @param ShokanMeisaiList
     */
    public void initialize(List<ShokanMeisaiResult> ShokanMeisaiList) {
        List<dgdKyufuhiMeisai_Row> rowList = new ArrayList<>();
        for (ShokanMeisaiResult Shokan : ShokanMeisaiList) {
            dgdKyufuhiMeisai_Row row = new dgdKyufuhiMeisai_Row();
            row.setDefaultDataName1(Shokan.getEntity().toEntity().getServiceKomokuCode().value());
            row.setDefaultDataName2(new RString(String.valueOf(Shokan.getEntity().get単位数())));
            row.setDefaultDataName3(new RString(String.valueOf(Shokan.getEntity().get日数_回数())));
            row.setDefaultDataName4(new RString(String.valueOf(Shokan.getEntity().getサービス単位数())));
            row.setDefaultDataName5(Shokan.getEntity().get摘要());
            row.setDefaultDataName6(Shokan.getEntity().get連番());
            rowList.add(row);

        }
        div.getPanelThree().getDgdKyufuhiMeisai().setDataSource(rowList);

    }

    public void set申請共通エリア(
            FlexibleYearMonth サービス年月,
            JigyoshaNo 事業者番号,
            RString 申請日,
            RString 明細番号,
            RString 証明書) {
        div.getPanelTwo().getTxtServiceTeikyoYM().setDomain(new RYearMonth(サービス年月.toDateString()));
        div.getPanelTwo().getTxtShinseiYMD().setValue(new RDate(申請日.toString()));
        div.getPanelTwo().getTxtJigyoshaBango().setValue(事業者番号.getColumnValue());
        div.getPanelTwo().getTxtMeisaiBango().setValue(明細番号);
        div.getPanelTwo().getTxtShomeisho().setValue(証明書);
    }

    public void set給付費明細登録() {
        dgdKyufuhiMeisai_Row row = div.getPanelThree().getDgdKyufuhiMeisai().getClickedItem();
        //TODO dbz共同div暂时未写对应地方法（サービスコード入力ガイド）
        div.getPanelThree().getPanelFour().getTxtTanyi().setValue(new Decimal(row.getDefaultDataName2().toString()));
        div.getPanelThree().getPanelFour().getTxtKaisu().setValue(new Decimal(row.getDefaultDataName3().toString()));
        div.getPanelThree().getPanelFour().getTxtServiceTanyi().setValue(new Decimal(row.getDefaultDataName4().toString()));
        div.getPanelThree().getPanelFour().getTxtTeikiyo().setValue(row.getDefaultDataName5());
        div.getPanelThree().getRowId().setValue(new Decimal(row.getId()));
    }

    public void clear給付費明細登録() {
        //TODO dbz共同div暂时未写对应地方法（サービスコード入力ガイド）
        div.getPanelThree().getPanelFour().getTxtTanyi().clearValue();
        div.getPanelThree().getPanelFour().getTxtKaisu().clearValue();
        div.getPanelThree().getPanelFour().getTxtServiceTanyi().clearValue();
        div.getPanelThree().getPanelFour().getTxtTeikiyo().clearValue();

    }

    public void click計算する() {
        Decimal data = null;
        if (div.getPanelThree().getPanelFour().getTxtTanyi().getValue() != null || div.getPanelThree().getPanelFour().getTxtKaisu().getValue() != null) {
            data = div.getPanelThree().getPanelFour().getTxtTanyi().getValue().multiply(div.getPanelThree().getPanelFour().getTxtKaisu().getValue());
            div.getPanelThree().getPanelFour().getTxtServiceTanyi().setValue(data);

        }

    }

    public void modifyRow(dgdKyufuhiMeisai_Row row) {
        RString state = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        if (修正.equals(state)) {
            boolean flag = 変更チェック１(row);
            if (flag) {
                row.setRowState(RowState.Modified);
                setDgdKyufuhiMeisai(row);
            }
            CommonButtonHolder.setDisabledByCommonButtonFieldName(申請を保存する, false);
        } else if (削除.equals(state)) {
            row.setRowState(RowState.Deleted);
            setDgdKyufuhiMeisai(row);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(申請を保存する, false);
        } else if (登録.equals(state)) {
            row.setRowState(RowState.Added);
            setDgdKyufuhiMeisai(row);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(申請を保存する, false);
        } else if (登録_削除.equals(state)) {
            div.getPanelThree().getDgdKyufuhiMeisai().getDataSource().remove(Integer.parseInt(
                    div.getPanelThree().getRowId().getValue().toString()));
        }
        //TODO dbz暂时没有提供相应的类
        //row.setDefaultDataName1();
//        row.setDefaultDataName2(new RString(div.getPanelThree().getPanelFour().getTxtTanyi().getValue().toString()));
//        row.setDefaultDataName3(new RString(div.getPanelThree().getPanelFour().getTxtKaisu().getValue().toString()));
//        row.setDefaultDataName4(new RString(div.getPanelThree().getPanelFour().getTxtServiceTanyi().getValue().toString()));
//        row.setDefaultDataName5(div.getPanelThree().getPanelFour().getTxtTeikiyo().getValue());
//        div.getPanelThree().getPanelFour().setVisible(false);
    }

    private boolean 変更チェック１(dgdKyufuhiMeisai_Row ddgRow) {
        boolean flag = false;
        List<ShokanMeisaiResult> shkonlist = ViewStateHolder.get(ViewStateKeys.給付費明細登録, List.class);
        for (ShokanMeisaiResult entityModified : shkonlist) {
            if (!ddgRow.getDefaultDataName6().isEmpty() && entityModified.getEntity().get連番().equals(ddgRow.getDefaultDataName6())) {
                if (entityModified.getEntity().get単位数() != Integer.parseInt(
                        div.getPanelThree().getPanelFour().getTxtTanyi().getValue().toString())) {
                    flag = true;
                    break;
                }
                if (entityModified.getEntity().get日数_回数() != Integer.parseInt(
                        div.getPanelThree().getPanelFour().getTxtKaisu().getValue().toString())) {
                    flag = true;
                    break;
                }
                if (entityModified.getEntity().getサービス単位数() != Integer.parseInt(
                        div.getPanelThree().getPanelFour().getTxtServiceTanyi().getValue().toString())) {
                    flag = true;
                    break;
                }
                if (entityModified.getEntity().get摘要()
                        != div.getPanelThree().getPanelFour().getTxtTeikiyo().getValue()) {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }

    private void setDgdKyufuhiMeisai(dgdKyufuhiMeisai_Row ddgRow) {

        if (div.getPanelThree().getPanelFour().getTxtTanyi().getValue() != null) {
            ddgRow.setDefaultDataName2(DecimalFormatter.toコンマ区切りRString(
                    div.getPanelThree().getPanelFour().getTxtTanyi().getValue(), 0));
        }
        if (div.getPanelThree().getPanelFour().getTxtKaisu().getValue() != null) {
            ddgRow.setDefaultDataName3(new RString(
                    div.getPanelThree().getPanelFour().getTxtKaisu().getValue().toString()));
        }
        if (div.getPanelThree().getPanelFour().getTxtServiceTanyi().getValue() != null) {
            ddgRow.setDefaultDataName4(DecimalFormatter.toコンマ区切りRString(
                    div.getPanelThree().getPanelFour().getTxtServiceTanyi().getValue(), 0));
        }
        if (div.getPanelThree().getPanelFour().getTxtTeikiyo().getValue() != null) {
            ddgRow.setDefaultDataName5(div.getPanelThree().getPanelFour().getTxtTeikiyo().getValue());
        }
        if (登録.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            List<dgdKyufuhiMeisai_Row> list = div.getPanelThree().getDgdKyufuhiMeisai().getDataSource();
            list.add(ddgRow);
        }
        clear給付費明細登録();
        div.getPanelThree().getPanelFour().setVisible(false);
    }

    public dgdKyufuhiMeisai_Row selectRow() {
        return div.getPanelThree().getDgdKyufuhiMeisai().getDataSource().get(Integer.parseInt(div.getPanelThree().getRowId().getValue().toString()));

    }

    public boolean get内容変更状態(FlexibleYearMonth サービス年月) {
        if (サービス年月.isBeforeOrEquals(new FlexibleYearMonth("200503"))) {
            for (dgdKyufuhiMeisai_Row ddgList : div.getPanelThree().getDgdKyufuhiMeisai().getDataSource()) {
                if (RowState.Modified.equals(ddgList.getRowState())
                        || RowState.Added.equals(ddgList.getRowState())
                        || RowState.Deleted.equals(ddgList.getRowState())) {
                    return true;
                }
            }
        }
        // 給付費明細
        if (new FlexibleYearMonth("200504").isBeforeOrEquals(サービス年月)) {
            for (dgdKyufuhiMeisai_Row dgdRow : div.getPanelThree().getDgdKyufuhiMeisai().getDataSource()) {
                if (RowState.Modified.equals(dgdRow.getRowState())
                        || RowState.Added.equals(dgdRow.getRowState())
                        || RowState.Deleted.equals(dgdRow.getRowState())) {
                    return true;
                }
            }
        }
        return false;
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
        List<ShokanMeisai> entityList = new ArrayList<>();
        List<dgdKyufuhiMeisai_Row> dgrow = div.getPanelThree().getDgdKyufuhiMeisai().getDataSource();
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            SyokanbaraihiShikyuShinseiKetteManager.createInstance().
                    delShokanSyomeisyo(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        } else {
            int max連番 = 0;
            List<ShokanMeisaiResult> shkonlist = ViewStateHolder.get(ViewStateKeys.給付費明細登録, List.class);
            Map<RString, ShokanMeisai> mapList = new HashMap<>();
            for (ShokanMeisaiResult shokanMeisaiResult : shkonlist) {
                mapList.put(shokanMeisaiResult.getEntity().get連番(), shokanMeisaiResult.getEntity());
                if (max連番 < Integer.valueOf(shokanMeisaiResult.getEntity().get連番().toString())) {
                    max連番 = Integer.valueOf(shokanMeisaiResult.getEntity().get連番().toString());
                }
            }
            for (dgdKyufuhiMeisai_Row row : dgrow) {
                if (RowState.Modified.equals(row.getRowState())) {
                    ShokanMeisai entityModified = mapList.get(row.getDefaultDataName6());
                    ShokanMeisai shokanMeisai = entityModified.createBuilderForEdit()
                            .set単位数(Integer.parseInt(row.getDefaultDataName2().toString()))
                            .set日数_回数(Integer.parseInt(row.getDefaultDataName3().toString()))
                            .setサービス単位数(Integer.parseInt(row.getDefaultDataName4().toString()))
                            .set摘要(row.getDefaultDataName5())
                            .build();
                    entityList.add(shokanMeisai.modified());
                } else if (RowState.Deleted.equals(row.getRowState())) {
                    entityList.add(mapList.get(row.getDefaultDataName6()).deleted());
                } else if (RowState.Added.equals(row.getRowState())) {
                    max連番 = max連番 + 1;
                    ShokanMeisai shokanMeisai = new ShokanMeisai(
                            被保険者番号,
                            サービス年月,
                            整理番号,
                            事業者番号,
                            様式番号,
                            明細番号,
                            new RString(String.valueOf(max連番))).createBuilderForEdit()
                            .set単位数(Integer.parseInt(row.getDefaultDataName2().toString()))
                            .set日数_回数(Integer.parseInt(row.getDefaultDataName3().toString()))
                            .setサービス単位数(Integer.parseInt(row.getDefaultDataName4().toString()))
                            .set摘要(row.getDefaultDataName5())
                            .build();
                    entityList.add(shokanMeisai);
                }

            }
        }
        SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanMeisai(entityList);

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
            div.getPanelTwo().getBtnKihonInfo().setDisabled(true);
        } else if (設定可必須.equals(entity.getKihonSetteiKubun())) {
            int count1 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().getShokanKihonCount(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count1 == 1) {
                div.getPanelTwo().getBtnKihonInfo().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelTwo().getBtnKihonInfo().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.getKihonSetteiKubun())) {
            div.getPanelTwo().getBtnKihonInfo().setIconNameEnum(IconName.NONE);
        }
        // 給付費明細
        if (設定不可.equals(entity.getMeisaiSetteiKubun())) {
            div.getPanelTwo().getBtnKyufuMeisai().setDisabled(true);
        } else if (設定可必須.equals(entity.getMeisaiSetteiKubun())) {
            int count2 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().delShokanMeisaiCount(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count2 == 1) {
                div.getPanelTwo().getBtnKyufuMeisai().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelTwo().getBtnKyufuMeisai().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.getMeisaiSetteiKubun())) {
            div.getPanelTwo().getBtnKyufuMeisai().setIconNameEnum(IconName.NONE);
        }
        // 特定診療費
        div.getPanelTwo().getBtnTokuteiShinryouhi().setDisabled(true);
        if (設定不可.equals(entity.getTokuteiShinryoSetteiKubun())) {
            div.getPanelTwo().getBtnTokuteiShinryouhi().setDisabled(true);
        } else if (設定可必須.equals(entity.getTokuteiShinryoSetteiKubun())) {
            int count3 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanTokuteiShinryohi(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count3 == 1) {
                div.getPanelTwo().getBtnTokuteiShinryouhi().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelTwo().getBtnTokuteiShinryouhi().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.getTokuteiShinryoSetteiKubun())) {
            div.getPanelTwo().getBtnTokuteiShinryouhi().setIconNameEnum(IconName.NONE);
        }
        if (設定不可.equals(entity.getKyotakuKeikakuSetteiKubun())) {
            div.getPanelTwo().getBtnServiceKeikakuhi().setDisabled(true);
        } else if (設定可必須.equals(entity.getKyotakuKeikakuSetteiKubun())) {
            // TODO サービス計画費情報件数を呼び出す
            int count4 = SyokanbaraihiShikyuShinseiKetteManager.
                    createInstance().updShokanServicePlan(被保険者番号,
                            サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count4 == 1) {
                div.getPanelTwo().getBtnServiceKeikakuhi().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelTwo().getBtnServiceKeikakuhi().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.getKyotakuKeikakuSetteiKubun())) {
            div.getPanelTwo().getBtnServiceKeikakuhi().setIconNameEnum(IconName.NONE);
        }
        // 特定入所者費用
        if (設定不可.equals(entity.getTokuteinyushoshaSetteiKubun())) {
            div.getPanelTwo().getBtnTokuteiNyushosya().setDisabled(true);
        } else if (設定可必須.equals(entity.getTokuteinyushoshaSetteiKubun())) {
            int count5 = SyokanbaraihiShikyuShinseiKetteManager.createInstance()
                    .updShokanTokuteiNyushoshaKaigoServiceHiyo(被保険者番号, サービス年月, 整理番号,
                            事業者番号, 様式番号, 明細番号);
            if (count5 == 1) {
                div.getPanelTwo().getBtnTokuteiNyushosya().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelTwo().getBtnTokuteiNyushosya().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.getTokuteinyushoshaSetteiKubun())) {
            div.getPanelTwo().getBtnTokuteiNyushosya().setIconNameEnum(IconName.NONE);
        }
        // 合計情報
        div.getPanelTwo().getBtnGoukeiInfo().setDisabled(false);
        // 緊急時・所定疾患
        if (設定不可.equals(entity.getTokuteiShikkanSetteiKubun())) {
            div.getPanelTwo().getBtnKinkyujiShoteiShikan().setDisabled(true);
        } else if (設定可必須.equals(entity.getTokuteiShikkanSetteiKubun())) {
            int count7 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShoteiShikkanShisetsuRyoyo(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count7 == 1) {
                div.getPanelTwo().getBtnKinkyujiShoteiShikan().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelTwo().getBtnKinkyujiShoteiShikan().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.getTokuteiShikkanSetteiKubun())) {
            div.getPanelTwo().getBtnKinkyujiShoteiShikan().setIconNameEnum(IconName.NONE);
        }
        // 緊急時施設療養費
        if (設定不可.equals(entity.getKinkyuShisetsuRyoyoSetteiKubun())) {
            div.getPanelTwo().getBtnKinkyushisetuRyoyouhi().setDisabled(true);
        } else if (設定可必須.equals(entity.getKinkyuShisetsuRyoyoSetteiKubun())) {
            int count8 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanKinkyuShisetsuRyoyo(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count8 == 1) {
                div.getPanelTwo().getBtnKinkyushisetuRyoyouhi().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelTwo().getBtnKinkyushisetuRyoyouhi().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.getKinkyuShisetsuRyoyoSetteiKubun())) {
            div.getPanelTwo().getBtnKinkyushisetuRyoyouhi().setIconNameEnum(IconName.NONE);
        }
        // 食事費用
        if (設定不可.equals(entity.getShokujiHiyosetteiKubun())) {
            div.getPanelTwo().getBtnShokujihiyo().setDisabled(true);
        } else if (設定可必須.equals(entity.getShokujiHiyosetteiKubun())) {
            int count9 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShokujiHiyo(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count9 == 1) {
                div.getPanelTwo().getBtnShokujihiyo().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelTwo().getBtnShokujihiyo().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.getShokujiHiyosetteiKubun())) {
            div.getPanelTwo().getBtnShokujihiyo().setIconNameEnum(IconName.NONE);
        }
        // 請求額集計
        if (設定不可.equals(entity.getShukeiSetteiKubun())) {
            div.getPanelTwo().getBtnSeikyugakuShukei().setDisabled(true);
        } else if (設定可必須.equals(entity.getShukeiSetteiKubun())) {
            int count10 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShukei(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count10 == 1) {
                div.getPanelTwo().getBtnSeikyugakuShukei().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelTwo().getBtnSeikyugakuShukei().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.getShukeiSetteiKubun())) {
            div.getPanelTwo().getBtnSeikyugakuShukei().setIconNameEnum(IconName.NONE);
        }
        // 社福軽減額
        if (設定不可.equals(entity.getShakaifukushiKeigenSetteiKubun())) {
            div.getPanelTwo().getBtnShafukukeigenGaku().setDisabled(true);
        } else if (設定可必須.equals(entity.getShakaifukushiKeigenSetteiKubun())) {
            int count11 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShakaiFukushiHojinKeigengaku(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count11 == 1) {
                div.getPanelTwo().getBtnShafukukeigenGaku().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelTwo().getBtnShafukukeigenGaku().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.getShakaifukushiKeigenSetteiKubun())) {
            div.getPanelTwo().getBtnShafukukeigenGaku().setIconNameEnum(IconName.NONE);
        }
    }

    public void putViewState() {
        // TODO 支給申請画面のモード　
        ViewStateHolder.put(ViewStateKeys.処理モード, "");
        ViewStateHolder.put(ViewStateKeys.申請日, div.getPanelTwo().getTxtShinseiYMD().getValue());
        SyokanbaraihishikyushinseiketteParameter paramter = new SyokanbaraihishikyushinseiketteParameter(
                ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class),
                new FlexibleYearMonth(div.getPanelTwo().getTxtServiceTeikyoYM().getDomain().toDateString()),
                ViewStateHolder.get(ViewStateKeys.整理番号, RString.class),
                new JigyoshaNo(div.getPanelTwo().getTxtJigyoshaBango().getValue()),
                div.getPanelTwo().getTxtShomeisho().getValue(),
                div.getPanelTwo().getTxtMeisaiBango().getValue(),
                null);
        ViewStateHolder.put(ViewStateKeys.償還払費申請検索キー, paramter);
    }

}
