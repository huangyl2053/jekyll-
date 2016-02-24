/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0820031;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanShakaiFukushiHojinKeigengakuResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820031.ShafukuKeigenGakuPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820031.dgdShafukukeigenngaku_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0820031.ShafukuKeigenGakuParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.syokanbaraihishikyushinseikette.SyokanbaraihishikyushinseiketteParameter;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * @author yebangqiang
 */
public class ShafukuKeigenGakuPanelHandler {

    private final ShafukuKeigenGakuPanelDiv div;
    private static final RString 設定不可 = new RString("0");
    private static final RString 設定可必須 = new RString("1");
    private static final RString 設定可任意 = new RString("1");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");
    private static final RString 単位 = new RString("単位");
    private static final RString 回まで = new RString("回まで");

    private ShafukuKeigenGakuPanelHandler(ShafukuKeigenGakuPanelDiv div) {
        this.div = div;
    }

    public static ShafukuKeigenGakuPanelHandler of(ShafukuKeigenGakuPanelDiv div) {
        return new ShafukuKeigenGakuPanelHandler(div);
    }

    public void initialize(List<ShokanShakaiFukushiHojinKeigengakuResult> hojinKeigengakuEntityList) {
        List<dgdShafukukeigenngaku_Row> rowList = new ArrayList<>();
        for (ShokanShakaiFukushiHojinKeigengakuResult shafukuKeigenGaku : hojinKeigengakuEntityList) {
            dgdShafukukeigenngaku_Row row = new dgdShafukukeigenngaku_Row();
            row.setDefaultDataName1(shafukuKeigenGaku.getShokanShakai().getサービス種類コード().value());
            row.setDefaultDataName2(new RString(shafukuKeigenGaku.getShokanShakai().get軽減率().toString()));
            row.getDefaultDataName3().setValue(new Decimal(shafukuKeigenGaku.getShokanShakai().get受領すべき利用者負担の総額()));
            row.getDefaultDataName4().setValue(new Decimal(shafukuKeigenGaku.getShokanShakai().get軽減額()));
            row.getDefaultDataName5().setValue(new Decimal(shafukuKeigenGaku.getShokanShakai().get軽減後利用者負担額()));
            row.setDefaultDataName6(shafukuKeigenGaku.getShokanShakai().get備考());
            rowList.add(row);
        }
        div.getPanelShafukukenngengaku().getDgdShafukukeigenngaku().setDataSource(rowList);
    }

//    public void getボタンを制御(ShikibetsuNoKanri shikibetsuNoKanri) {
//
//        SyokanbaraihishikyushinseiketteParameter paramter = ViewStateHolder.get(ViewStateKeys.償還払費申請検索キー,
//                SyokanbaraihishikyushinseiketteParameter.class);
//        HihokenshaNo 被保険者番号 = paramter.getHiHokenshaNo();
//        FlexibleYearMonth サービス年月 = paramter.getServiceTeikyoYM();
//        RString 整理番号 = paramter.getSeiriNp();
//        JigyoshaNo 事業者番号 = paramter.getJigyoshaNo();
//        RString 様式番号 = paramter.getYoshikiNo();
//        RString 明細番号 = paramter.getMeisaiNo();
//        // 基本情報
//        if (設定不可.equals(shikibetsuNoKanri.get基本設定区分())) {
//            div.getPanelHead().getBtnKihonInfo().setDisabled(true);
//        } else if (設定可必須.equals(shikibetsuNoKanri.get基本設定区分())) {
//            int count1 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().getShokanKihonCount(被保険者番号,
//                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
//            if (count1 == 1) {
//                div.getPanelHead().getBtnKihonInfo().setIconNameEnum(IconName.Incomplete);
//            } else {
//                div.getPanelHead().getBtnKihonInfo().setIconNameEnum(IconName.Complete);
//            }
//        } else if (設定可任意.equals(shikibetsuNoKanri.get基本設定区分())) {
//            div.getPanelHead().getBtnKihonInfo().setIconNameEnum(IconName.NONE);
//        }
//        // 給付費明細
//        if (設定不可.equals(shikibetsuNoKanri.get明細設定区分())) {
//            div.getPanelHead().getBtnKyufuhiMeisai().setDisabled(true);
//        } else if (設定可必須.equals(shikibetsuNoKanri.get明細設定区分())) {
//            int count2 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().delShokanMeisaiCount(被保険者番号,
//                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
//            if (count2 == 1) {
//                div.getPanelHead().getBtnKyufuhiMeisai().setIconNameEnum(IconName.Incomplete);
//            } else {
//                div.getPanelHead().getBtnKyufuhiMeisai().setIconNameEnum(IconName.Complete);
//            }
//        } else if (設定可任意.equals(shikibetsuNoKanri.get明細設定区分())) {
//            div.getPanelHead().getBtnKyufuhiMeisai  ().setIconNameEnum(IconName.NONE);
//        }
//        // 特定診療費
//        div.getPanelHead().getBtnTokuteiShinryohi().setDisabled(true);
//        if (設定不可.equals(shikibetsuNoKanri.get特定診療費設定区分())) {
//            div.getPanelHead().getBtnTokuteiShinryohi().setDisabled(true);
//        } else if (設定可必須.equals(shikibetsuNoKanri.get特定診療費設定区分())) {
//            int count3 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanTokuteiShinryohi(被保険者番号,
//                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
//            if (count3 == 1) {
//                div.getPanelHead().getBtnTokuteiShinryohi().setIconNameEnum(IconName.Incomplete);
//            } else {
//                div.getPanelHead().getBtnTokuteiShinryohi().setIconNameEnum(IconName.Complete);
//            }
//        } else if (設定可任意.equals(shikibetsuNoKanri.get特定診療費設定区分())) {
//            div.getPanelHead().getBtnTokuteiShinryohi().setIconNameEnum(IconName.NONE);
//        }
//        // サービス計画費
//        if (設定不可.equals(shikibetsuNoKanri.get居宅計画費設定区分())) {
//            div.getPanelHead().getBtnServiceKeikakuhi().setDisabled(true);
//        } else if (設定可必須.equals(shikibetsuNoKanri.get居宅計画費設定区分())) {
//            // TODO サービス計画費情報件数を呼び出す
//            int count4 = 1;
////                    SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanServicePlan(被保険者番号,
////                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
//            if (count4 == 1) {
//                div.getPanelHead().getBtnServiceKeikakuhi().setIconNameEnum(IconName.Incomplete);
//            } else {
//                div.getPanelHead().getBtnServiceKeikakuhi().setIconNameEnum(IconName.Complete);
//            }
//        } else if (設定可任意.equals(shikibetsuNoKanri.get居宅計画費設定区分())) {
//            div.getPanelHead().getBtnServiceKeikakuhi().setIconNameEnum(IconName.NONE);
//        }
//        // 特定入所者費用
//        if (設定不可.equals(shikibetsuNoKanri.get特定入所者設定区分())) {
//            div.getPanelHead().getBtnTokuteiNyushosya().setDisabled(true);
//        } else if (設定可必須.equals(shikibetsuNoKanri.get特定入所者設定区分())) {
//            int count5 = SyokanbaraihiShikyuShinseiKetteManager.createInstance()
//                    .updShokanTokuteiNyushoshaKaigoServiceHiyo(被保険者番号, サービス年月, 整理番号,
//                            事業者番号, 様式番号, 明細番号);
//            if (count5 == 1) {
//                div.getPanelHead().getBtnTokuteiNyushosya().setIconNameEnum(IconName.Incomplete);
//            } else {
//                div.getPanelHead().getBtnTokuteiNyushosya().setIconNameEnum(IconName.Complete);
//            }
//        } else if (設定可任意.equals(shikibetsuNoKanri.get特定入所者設定区分())) {
//            div.getPanelHead().getBtnTokuteiNyushosya().setIconNameEnum(IconName.NONE);
//        }
//        // 合計情報
//        div.getPanelHead().getBtnGoukeiInfo().setDisabled(false);
//        // 給付費明細（住特）
//        if (設定不可.equals(shikibetsuNoKanri.get明細住所地特例設定区分())) {
//            div.getPanelHead().getBtnKyufuhiMeisaiJyuchi().setDisabled(true);
//        } else if (設定可必須.equals(shikibetsuNoKanri.get明細住所地特例設定区分())) {
//            int count6 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().getShokanMeisaiJushochiTokureiCount(
//                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
//            if (count6 == 1) {
//                div.getPanelHead().getBtnKyufuhiMeisaiJyuchi().setIconNameEnum(IconName.Incomplete);
//            } else {
//                div.getPanelHead().getBtnKyufuhiMeisaiJyuchi().setIconNameEnum(IconName.Complete);
//            }
//        } else if (設定可任意.equals(shikibetsuNoKanri.get明細住所地特例設定区分())) {
//            div.getPanelHead().getBtnKyufuhiMeisaiJyuchi().setIconNameEnum(IconName.NONE);
//        }
//        // 緊急時・所定疾患
//        if (設定不可.equals(shikibetsuNoKanri.get特定疾患施設療養設定区分())) {
//            div.getPanelHead().getBtnKinkyujiShotei().setDisabled(true);
//        } else if (設定可必須.equals(shikibetsuNoKanri.get特定疾患施設療養設定区分())) {
//            int count7 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShoteiShikkanShisetsuRyoyo(
//                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
//            if (count7 == 1) {
//                div.getPanelHead().getBtnKinkyujiShotei().setIconNameEnum(IconName.Incomplete);
//            } else {
//                div.getPanelHead().getBtnKinkyujiShotei().setIconNameEnum(IconName.Complete);
//            }
//        } else if (設定可任意.equals(shikibetsuNoKanri.get特定疾患施設療養設定区分())) {
//            div.getPanelHead().getBtnKinkyujiShotei().setIconNameEnum(IconName.NONE);
//        }
//        // 緊急時施設療養費
//        if (設定不可.equals(shikibetsuNoKanri.get緊急時施設療養設定区分())) {
//            div.getPanelHead().getBtnKinkyujiShisetsuRyoyo().setDisabled(true);
//        } else if (設定可必須.equals(shikibetsuNoKanri.get緊急時施設療養設定区分())) {
//            int count8 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanKinkyuShisetsuRyoyo(
//                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
//            if (count8 == 1) {
//                div.getPanelHead().getBtnKinkyujiShisetsuRyoyo().setIconNameEnum(IconName.Incomplete);
//            } else {
//                div.getPanelHead().getBtnKinkyujiShisetsuRyoyo().setIconNameEnum(IconName.Complete);
//            }
//        } else if (設定可任意.equals(shikibetsuNoKanri.get緊急時施設療養設定区分())) {
//            div.getPanelHead().getBtnKinkyujiShisetsuRyoyo().setIconNameEnum(IconName.NONE);
//        }
//        // 食事費用
//        if (設定不可.equals(shikibetsuNoKanri.get食事費用設定区分())) {
//            div.getPanelHead().getBtnShokujiHiyo().setDisabled(true);
//        } else if (設定可必須.equals(shikibetsuNoKanri.get食事費用設定区分())) {
//            int count9 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShokujiHiyo(
//                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
//            if (count9 == 1) {
//                div.getPanelHead().getBtnShokujiHiyo().setIconNameEnum(IconName.Incomplete);
//            } else {
//                div.getPanelHead().getBtnShokujiHiyo().setIconNameEnum(IconName.Complete);
//            }
//        } else if (設定可任意.equals(shikibetsuNoKanri.get食事費用設定区分())) {
//            div.getPanelHead().getBtnShokujiHiyo().setIconNameEnum(IconName.NONE);
//        }
//        // 請求額集計
//        if (設定不可.equals(shikibetsuNoKanri.get集計設定区分())) {
//            div.getPanelHead().getBtnSeikyugakuShukei().setDisabled(true);
//        } else if (設定可必須.equals(shikibetsuNoKanri.get集計設定区分())) {
//            int count10 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShukei(被保険者番号,
//                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
//            if (count10 == 1) {
//                div.getPanelHead().getBtnSeikyugakuShukei().setIconNameEnum(IconName.Incomplete);
//            } else {
//                div.getPanelHead().getBtnSeikyugakuShukei().setIconNameEnum(IconName.Complete);
//            }
//        } else if (設定可任意.equals(shikibetsuNoKanri.get集計設定区分())) {
//            div.getPanelHead().getBtnSeikyugakuShukei().setIconNameEnum(IconName.NONE);
//        }
//        // 社福軽減額
//        if (設定不可.equals(shikibetsuNoKanri.get社会福祉法人軽減設定区分())) {
//            div.getPanelHead().getBtnShafukukeigengaku().setDisabled(true);
//        } else if (設定可必須.equals(shikibetsuNoKanri.get社会福祉法人軽減設定区分())) {
//            int count11 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShakaiFukushiHojinKeigengaku(
//                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
//            if (count11 == 1) {
//                div.getPanelHead().getBtnShafukukeigengaku().setIconNameEnum(IconName.Incomplete);
//            } else {
//                div.getPanelHead().getBtnShafukukeigengaku().setIconNameEnum(IconName.Complete);
//            }
//        } else if (設定可任意.equals(shikibetsuNoKanri.get社会福祉法人軽減設定区分())) {
//            div.getPanelHead().getBtnShafukukeigengaku().setIconNameEnum(IconName.NONE);
//        }
//    }
//    public void initializeByModify() {
//        dgdShafukukeigenngaku_Row row = div.getDgdShafukukeigenngaku().getClickedItem();
//        div.getPanelShakaiFukushiShokai().getDdlServiceShurui().setSelectedValue(row.getDefaultDataName1());
//        div.getPanelShakaiFukushiShokai().getDdlKengenritsu().setSelectedValue(row.getDefaultDataName2());
//        div.getPanelShakaiFukushiShokai().getTxtRiyoshaFutangakuTotal().setValue(row.getDefaultDataName3().getValue());
//        div.getPanelShakaiFukushiShokai().getTxtKengengaku().setValue(row.getDefaultDataName4().getValue());
//        div.getPanelShakaiFukushiShokai().getTxtKeigengoRiyoshaFutangaku().setValue(row.getDefaultDataName5().getValue());
//        div.getPanelShakaiFukushiShokai().getTxtBikou().setValue(row.getDefaultDataName6());
//        div.getRowId().setValue(new Decimal(row.getId()));
//    }
//
//    public void initializeByDelete() {
//        dgdShafukukeigenngaku_Row row = div.getDgdShafukukeigenngaku().getClickedItem();
//        div.getPanelShakaiFukushiShokai().getDdlServiceShurui().setSelectedKey(row.getDefaultDataName1());
//        div.getPanelShakaiFukushiShokai().getDdlKengenritsu().setSelectedKey(row.getDefaultDataName2());
//        div.getPanelShakaiFukushiShokai().getTxtRiyoshaFutangakuTotal().setValue(row.getDefaultDataName3().getValue());
//        div.getPanelShakaiFukushiShokai().getTxtKengengaku().setValue(row.getDefaultDataName4().getValue());
//        div.getPanelShakaiFukushiShokai().getTxtKeigengoRiyoshaFutangaku().setValue(row.getDefaultDataName5().getValue());
//        div.getPanelShakaiFukushiShokai().getTxtBikou().setValue(row.getDefaultDataName6());
//        div.getRowId().setValue(new Decimal(row.getId()));
//    }
//
//    public void initializeByCalculation() {
//        Decimal kengengakuData = new Decimal(div.getPanelShakaiFukushiShokai().getDdlKengenritsu().getSelectedValue().toString())
//                .multiply(div.getPanelShakaiFukushiShokai().getTxtRiyoshaFutangakuTotal().getValue());
//        div.getPanelShakaiFukushiShokai().getTxtKengengaku().setValue(kengengakuData);
//        Decimal keigengoRiyoshaFutangakuData = (div.getPanelShakaiFukushiShokai().getTxtRiyoshaFutangakuTotal().getValue())
//                .subtract(div.getPanelShakaiFukushiShokai().getTxtKengengaku().getValue());
//        div.getPanelShakaiFukushiShokai().getTxtKeigengoRiyoshaFutangaku().setValue(keigengoRiyoshaFutangakuData);
//    }
//
//    public void initializeByClean() {
//        div.getPanelShakaiFukushiShokai().getDdlServiceShurui().setSelectedValue(new RString("empty"));
//        div.getPanelShakaiFukushiShokai().getDdlKengenritsu().setSelectedValue(new RString("empty"));
//        div.getPanelShakaiFukushiShokai().getTxtRiyoshaFutangakuTotal().clearValue();
//        div.getPanelShakaiFukushiShokai().getTxtKengengaku().clearValue();
//        div.getPanelShakaiFukushiShokai().getTxtKeigengoRiyoshaFutangaku().clearValue();
//        div.getPanelShakaiFukushiShokai().getTxtBikou().clearValue();
//    }
//
//    public void initializeByCancel() {
//        div.getPanelShakaiFukushiShokai().getDdlServiceShurui().setSelectedValue(new RString("empty"));
//        div.getPanelShakaiFukushiShokai().getDdlKengenritsu().setSelectedValue(new RString("empty"));
//        div.getPanelShakaiFukushiShokai().getTxtRiyoshaFutangakuTotal().clearValue();
//        div.getPanelShakaiFukushiShokai().getTxtKengengaku().clearValue();
//        div.getPanelShakaiFukushiShokai().getTxtKeigengoRiyoshaFutangaku().clearValue();
//        div.getPanelShakaiFukushiShokai().getTxtBikou().clearValue();
//        div.getPanelShakaiFukushiShokai().setVisible(false);
//    }
//
//    public dgdShafukukeigenngaku_Row getSelectedRow() {
//        return div.getDgdShafukukeigenngaku().getDataSource().get(Integer.parseInt(div.getRowId().getValue().toString()));
//    }
//
//    public void initializeByConfirm() {
//        RString state = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
//        if (修正.equals(state)) {
//            dgdShafukukeigenngaku_Row row = getSelectedRow();
//            row.setRowState(RowState.Modified);
//            row.setDefaultDataName1(div.getPanelShakaiFukushiShokai().getDdlServiceShurui().getSelectedValue());
//            row.setDefaultDataName2(div.getPanelShakaiFukushiShokai().getDdlKengenritsu().getSelectedValue());
//            row.getDefaultDataName3().setValue(div.getPanelShakaiFukushiShokai().getTxtRiyoshaFutangakuTotal().getValue());
//            row.getDefaultDataName4().setValue(div.getPanelShakaiFukushiShokai().getTxtKengengaku().getValue());
//            row.getDefaultDataName5().setValue(div.getPanelShakaiFukushiShokai().getTxtKeigengoRiyoshaFutangaku().getValue());
//            row.setDefaultDataName6(div.getPanelShakaiFukushiShokai().getTxtBikou().getValue());
//            initializeByClean();
//            div.getPanelShakaiFukushiShokai().setVisible(false);
//        } else if (削除.equals(state)) {
//            dgdShafukukeigenngaku_Row row = getSelectedRow();
//            row.setRowState(RowState.Deleted);
//            initializeByClean();
//            div.getPanelShakaiFukushiShokai().setVisible(false);
//        } else if (登録.equals(state)) {
//            dgdShafukukeigenngaku_Row newRow = new dgdShafukukeigenngaku_Row();
//            newRow.setRowState(RowState.Added);
//            newRow.setDefaultDataName1(div.getPanelShakaiFukushiShokai().getDdlServiceShurui().getSelectedValue());
//            newRow.setDefaultDataName2(div.getPanelShakaiFukushiShokai().getDdlKengenritsu().getSelectedValue());
//            newRow.getDefaultDataName3().setValue(div.getPanelShakaiFukushiShokai().getTxtRiyoshaFutangakuTotal().getValue());
//            newRow.getDefaultDataName4().setValue(div.getPanelShakaiFukushiShokai().getTxtKengengaku().getValue());
//            newRow.getDefaultDataName5().setValue(div.getPanelShakaiFukushiShokai().getTxtKeigengoRiyoshaFutangaku().getValue());
//            newRow.setDefaultDataName6(div.getPanelShakaiFukushiShokai().getTxtBikou().getValue());
//            div.getDgdShafukukeigenngaku().getDataSource().add(newRow);
//            initializeByClean();
//            div.getPanelShakaiFukushiShokai().setVisible(false);
//        }
//    }
//
//    public boolean get内容変更状態() {
//        for (dgdShafukukeigenngaku_Row ddgList : div.getDgdShafukukeigenngaku().getDataSource()) {
//                if (RowState.Modified.equals(ddgList.getRowState())
//                        || RowState.Added.equals(ddgList.getRowState())
//                        || RowState.Deleted.equals(ddgList.getRowState())) {
//                    return true;
//                }
//            }
//        return false;
//    }
//
//    public void 内容の破棄() {
//        div.getRowId().setValue(new Decimal("123"));
//        List<ShokanShakaiFukushiHojinKeigengakuResult> list = ViewStateHolder.get(ViewStateKeys.情報, List.class);
//        initialize(list);
////        List<dgdShafukukeigenngaku_Row> ddgList = div.getDgdShafukukeigenngaku().getDataSource();
////        for (dgdShafukukeigenngaku_Row row : ddgList) {
////            if (修正.equals(row.getRowState()) || 登録.equals(row.getRowState())) {
////                div.getDgdShafukukeigenngaku().getDataSource().remove(1);
////            }
////        }
//    }
//
//    public void putViewState() {
//        // TODO 支給申請画面のモード　
//        ViewStateHolder.put(ViewStateKeys.処理モード, "");
//        ViewStateHolder.put(ViewStateKeys.申請日, div.getPanelHead().getTxtShinseiYMD().getValue());
//        SyokanbaraihishikyushinseiketteParameter paramter = new SyokanbaraihishikyushinseiketteParameter(
//                ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class),
//                new FlexibleYearMonth(div.getPanelHead().getTxtServiceTeikyoYM().getDomain().toDateString()),
//                ViewStateHolder.get(ViewStateKeys.整理番号, RString.class),
//                new JigyoshaNo(div.getPanelHead().getTxtJigyoshaBango().getValue()),
//                div.getPanelHead().getTxtShomeisho().getValue(),
//                div.getPanelHead().getTxtMeisaiBango().getValue(),
//                null);
//        ViewStateHolder.put(ViewStateKeys.償還払費申請検索キー, paramter);
//    }
//
    public void putViewStateHolder() {
        RString 被保険者番号 = div.getPanelCcd().getCcdKaigoShikakuKihon().get被保険者番号().value();
        RDate サービス年月 = div.getPanelHead().getTxtShinseiYMD().getValue();
        RString 整理番号 = null;
        RString 事業者番号 = div.getPanelHead().getTxtJigyoshaBango().getValue();
        RString 様式番号 = div.getPanelHead().getTxtShomeisho().getValue();
        RString 明細番号 = div.getPanelHead().getTxtMeisaiBango().getValue();
        ShafukuKeigenGakuParameter parameter = new ShafukuKeigenGakuParameter(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
//        ViewStateHolder.put(ViewStateKeys.償還払費申請検索キー, parameter);
    }

    public void 削除Save() {
        SyokanbaraihishikyushinseiketteParameter paramter = ViewStateHolder.get(ViewStateKeys.償還払費申請検索キー,
                SyokanbaraihishikyushinseiketteParameter.class);
        HihokenshaNo 被保険者番号 = paramter.getHiHokenshaNo();
        FlexibleYearMonth サービス年月 = paramter.getServiceTeikyoYM();
        RString 整理番号 = paramter.getSeiriNp();
        JigyoshaNo 事業者番号 = paramter.getJigyoshaNo();
        RString 様式番号 = paramter.getYoshikiNo();
        RString 明細番号 = paramter.getMeisaiNo();
        SyokanbaraihiShikyuShinseiKetteManager.createInstance().delShokanSyomeisyo(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
    }

//    private int get連番(int i) {
//        for (dgdShafukukeigenngaku_Row row : div.getDgdShafukukeigenngaku().getDataSource()) {
//            if (row.getRenBan().isEmpty()) {
//                continue;
//            }
//            if (Integer.parseInt(row.getRenBan().toString()) == i) {
//                get連番(i + 1);
//            }
//        }
//        return i;
//    }
    public void 登録Save() {
//        SyokanbaraihishikyushinseiketteParameter paramter = ViewStateHolder.get(ViewStateKeys.償還払費申請検索キー,
//                SyokanbaraihishikyushinseiketteParameter.class);
//        HihokenshaNo 被保険者番号 = paramter.getHiHokenshaNo();
//        FlexibleYearMonth サービス年月 = paramter.getServiceTeikyoYM();
//        RString 整理番号 = paramter.getSeiriNp();
//        JigyoshaNo 事業者番号 = paramter.getJigyoshaNo();
//        RString 様式番号 = paramter.getYoshikiNo();
//        RString 明細番号 = paramter.getMeisaiNo();
//        int num = 1;
//        List<dgdShafukukeigenngaku_Row> rows = div.getDgdShafukukeigenngaku().getDataSource();
//        List<ShokanFukushigengakuEntity> list = new ArrayList();
//        for (dgdShafukukeigenngaku_Row row : rows) {
//            if (RowState.Added == row.getRowState()) {
//                ShokanFukushigengakuEntity entity = createEntity(row, null, 登録);
//                list.add(entity);
//            }
//            if (RowState.Modified == row.getRowState()) {
//                ShokanFukushigengakuEntity entity = createEntity(row, row.getRenBan(), 修正);
//                list.add(entity);
//            }
//            if (RowState.Deleted == row.getRowState()) {
//                ShokanFukushigengakuEntity entity = createEntity(row, row.getRenBan(), 削除);
//                list.add(entity);
//            }
//        }
        RString 証明書コード = div.getPanelHead().getTxtShomeisho().getValue();
//        ShokanShakaiFukushiHojinKeigengakuParameter parameter = ShokanShakaiFukushiHojinKeigengakuParameter.createSelectByKeyParam(
//                被保険者番号, サービス年月, 整理番号, 事業者番号, 証明書コード, 明細番号, list);
//        SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShakaiFukushiHojinKeigengaku(parameter);

    }
//
//    public ShokanFukushigengakuEntity createEntity(dgdShafukukeigenngaku_Row row, RString row連番, RString row状態) {
//        RString 連番 = row連番;
//        Decimal 軽減率 = new Decimal(row.getDefaultDataName2().toString());
//        ServiceShuruiCode サービス種類コード = new ServiceShuruiCode(row.getDefaultDataName1().toString());
//        int 受領すべき利用者負担の総額 = row.getDefaultDataName3().getValue().intValue();
//        int 軽減額 = row.getDefaultDataName4().getValue().intValue();
//        int 軽減後利用者負担額 = row.getDefaultDataName5().getValue().intValue();
//        RString 備考 = row.getDefaultDataName6();
//        RString 状態 = row状態;
//        return ShokanFukushigengakuEntity.createSelectByKeyParam(
//                連番, 軽減率, サービス種類コード, 受領すべき利用者負担の総額, 軽減額, 軽減後利用者負担額, 備考, 状態);
//    }
}
