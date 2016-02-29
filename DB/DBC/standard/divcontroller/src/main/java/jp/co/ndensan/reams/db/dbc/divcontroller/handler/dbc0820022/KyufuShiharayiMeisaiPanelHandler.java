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
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanMeisai;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanMeisaiResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820022.KyufuShiharayiMeisaiPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820022.dgdKyufuhiMeisai_Row;
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
    private static final RString 設定不可 = new RString("0");
    private static final RString 設定可必須 = new RString("1");
    private static final RString 設定可任意 = new RString("1");
    private static final RString 申請を保存する = new RString("Element3");
    private static final int NUM = 6;

    /**
     * 初期化
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     */
    public KyufuShiharayiMeisaiPanelHandler(KyufuShiharayiMeisaiPanelDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理します。
     *
     * @param shList List
     */
    public void initialize(List<ShokanMeisaiResult> shList) {
        List<dgdKyufuhiMeisai_Row> rowList = new ArrayList<>();
        for (ShokanMeisaiResult shokan : shList) {
            dgdKyufuhiMeisai_Row row = new dgdKyufuhiMeisai_Row();
            RStringBuilder builder = new RStringBuilder();
            if (shokan.getEntity().getサービス種類コード() != null) {
                builder.append(shokan.getEntity().getサービス種類コード().value());
            }
            if (shokan.getEntity().getサービス項目コード() != null) {
                builder.append(shokan.getEntity().getサービス項目コード().value());
            }
            row.setDefaultDataName1(builder.toRString());
            row.setDefaultDataName2(new RString(String.valueOf(shokan.getEntity().get単位数())));
            row.setDefaultDataName3(new RString(String.valueOf(shokan.getEntity().get日数_回数())));
            row.setDefaultDataName4(new RString(String.valueOf(shokan.getEntity().getサービス単位数())));
            row.setDefaultDataName5(shokan.getEntity().get摘要());
            row.setDefaultDataName6(shokan.getEntity().get連番());
            row.setDefaultDataName7(shokan.getServiceName());
            rowList.add(row);

        }
        div.getPanelThree().getDgdKyufuhiMeisai().setDataSource(rowList);

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
        div.getPanelTwo().getTxtServiceTeikyoYM().setValue(new RDate(サービス年月.toString()));
        div.getPanelTwo().getTxtShinseiYMD().setValue(new RDate(申請日.toString()));
        div.getPanelTwo().getTxtJigyoshaBango().setValue(事業者番号.getColumnValue());
        div.getPanelTwo().getTxtMeisaiBango().setValue(明細番号);
        div.getPanelTwo().getTxtShomeisho().setValue(証明書);
    }

    /**
     * set給付費明細登録
     */
    public void set給付費明細登録() {
        dgdKyufuhiMeisai_Row row = div.getPanelThree().getDgdKyufuhiMeisai().getClickedItem();
        ServiceCodeInputCommonChildDivDiv sercode
                = (ServiceCodeInputCommonChildDivDiv) div.getPanelThree().getPanelFour().getCcdServiceCodeInput();
        if (!row.getDefaultDataName1().isEmpty()) {
            RString serviceCodeShuruyi = new RString(row.getDefaultDataName1().subSequence(0, 2).toString());
            RString serviceCodeKoumoku = new RString(row.getDefaultDataName1().subSequence(2, NUM).toString());
            sercode.getTxtServiceCode1().setValue(serviceCodeShuruyi);
            sercode.getTxtServiceCode2().setValue(serviceCodeKoumoku);

        }
        div.getPanelThree().getPanelFour().getTxtTanyi().setValue(new Decimal(row.getDefaultDataName2().toString()));
        div.getPanelThree().getPanelFour().getTxtKaisu().setValue(new Decimal(row.getDefaultDataName3().toString()));
        div.getPanelThree().getPanelFour().getTxtServiceTanyi().setValue(new Decimal(
                row.getDefaultDataName4().toString()));
        div.getPanelThree().getPanelFour().getTxtTeikiyo().setValue(row.getDefaultDataName5());
        sercode.getTxtServiceCodeName().setValue(row.getDefaultDataName7());
        div.getPanelThree().getRowId().setValue(new Decimal(row.getId()));
    }

    /**
     * clear給付費明細登録
     */
    public void clear給付費明細登録() {
        ServiceCodeInputCommonChildDivDiv sercode
                = (ServiceCodeInputCommonChildDivDiv) div.getPanelThree().getPanelFour().getCcdServiceCodeInput();
        sercode.getTxtServiceCode1().clearValue();
        sercode.getTxtServiceCode2().clearValue();
        div.getPanelThree().getPanelFour().getTxtTanyi().clearValue();
        div.getPanelThree().getPanelFour().getTxtKaisu().clearValue();
        div.getPanelThree().getPanelFour().getTxtServiceTanyi().clearValue();
        div.getPanelThree().getPanelFour().getTxtTeikiyo().clearValue();

    }

    /**
     * click計算する
     */
    public void click計算する() {
        Decimal data = null;
        if (div.getPanelThree().getPanelFour().getTxtTanyi().getValue() != null
                || div.getPanelThree().getPanelFour().getTxtKaisu().getValue() != null) {
            data = div.getPanelThree().getPanelFour().getTxtTanyi().getValue().multiply(
                    div.getPanelThree().getPanelFour().getTxtKaisu().getValue());
            div.getPanelThree().getPanelFour().getTxtServiceTanyi().setValue(data);

        }

    }

    /**
     * modifyRow
     *
     * @param row dgdKyufuhiMeisai_Row
     */
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
        }
    }

    private boolean 変更チェック１(dgdKyufuhiMeisai_Row ddgRow) {
        ServiceCodeInputCommonChildDivDiv sercode
                = (ServiceCodeInputCommonChildDivDiv) div.getPanelThree().getPanelFour().getCcdServiceCodeInput();
        RString サービス種類コード = sercode.getTxtServiceCode1().getValue();
        RString サービス項目コード = sercode.getTxtServiceCode2().getValue();
        RStringBuilder builder = new RStringBuilder();
        builder.append(サービス種類コード).append(サービス項目コード);
        if (!ddgRow.getDefaultDataName1().equals(builder.toString())) {
            return true;
        }
        if (!ddgRow.getDefaultDataName2().equals(Integer.parseInt(
                div.getPanelThree().getPanelFour().getTxtTanyi().getValue().toString()))) {
            return true;
        }
        if (!ddgRow.getDefaultDataName3().equals(Integer.parseInt(
                div.getPanelThree().getPanelFour().getTxtKaisu().getValue().toString()))) {
            return true;
        }
        if (!ddgRow.getDefaultDataName4().equals(Integer.parseInt(
                div.getPanelThree().getPanelFour().getTxtServiceTanyi().getValue().toString()))) {
            return true;
        }
        if (!ddgRow.getDefaultDataName5().equals(Integer.parseInt(
                div.getPanelThree().getPanelFour().getTxtTeikiyo().getValue().toString()))) {
            return true;
        }
        return true;
    }

    private void setDgdKyufuhiMeisai(dgdKyufuhiMeisai_Row ddgRow) {
        ServiceCodeInputCommonChildDivDiv serviceCodeInputDiv
                = (ServiceCodeInputCommonChildDivDiv) div.getPanelThree().getPanelFour().getCcdServiceCodeInput();
        RStringBuilder builder = new RStringBuilder();
        if (serviceCodeInputDiv.getTxtServiceCode1() != null) {
            builder.append(serviceCodeInputDiv.getTxtServiceCode1().getValue());
        }
        if (serviceCodeInputDiv.getTxtServiceCode2() != null) {
            builder.append(serviceCodeInputDiv.getTxtServiceCode2().getValue());
        }
        ddgRow.setDefaultDataName1(builder.toRString());

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

    /**
     * selectRow
     *
     * @return dgdKyufuhiMeisai_Row
     */
    public dgdKyufuhiMeisai_Row selectRow() {
        return div.getPanelThree().getDgdKyufuhiMeisai().getDataSource().get(
                Integer.parseInt(div.getPanelThree().getRowId().getValue().toString()));

    }

    /**
     * get内容変更状態
     *
     * @param サービス年月 FlexibleYearMonth
     * @return true
     */
    public boolean is内容変更状態(FlexibleYearMonth サービス年月) {

        for (dgdKyufuhiMeisai_Row ddgList : div.getPanelThree().getDgdKyufuhiMeisai().getDataSource()) {
            if (RowState.Modified.equals(ddgList.getRowState())
                    || RowState.Added.equals(ddgList.getRowState())
                    || RowState.Deleted.equals(ddgList.getRowState())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 保存処理
     */
    public void 保存処理() {
        SyokanbaraihishikyushinseiketteParameter par = new SyokanbaraihishikyushinseiketteParameter(
                new HihokenshaNo("0000030"), new FlexibleYearMonth(new RString("201406")),
                new RString("1111"), new JigyoshaNo("3333"), new RString("2222"),
                new RString("4444"), null);
        ViewStateHolder.put(ViewStateKeys.償還払費申請検索キー, par);
        SyokanbaraihishikyushinseiketteParameter parameter = ViewStateHolder.
                get(ViewStateKeys.償還払費申請検索キー,
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
                if (max連番 < Integer.parseInt(shokanMeisaiResult.getEntity().get連番().toString())) {
                    max連番 = Integer.parseInt(shokanMeisaiResult.getEntity().get連番().toString());
                }
            }
            for (dgdKyufuhiMeisai_Row row : dgrow) {
                if (RowState.Modified.equals(row.getRowState())) {
                    RString serviceCodeShuruyi = new RString(row.getDefaultDataName1().subSequence(0, 2).toString());
                    RString serviceCodeKoumoku = new RString(row.getDefaultDataName1().subSequence(2, NUM).toString());
                    ShokanMeisai entityModified = mapList.get(row.getDefaultDataName6());
                    ShokanMeisai shokanMeisai = entityModified.createBuilderForEdit()
                            .setサービス種類コード(new ServiceShuruiCode(serviceCodeShuruyi))
                            .setサービス項目コード(new ServiceKomokuCode(serviceCodeKoumoku))
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

    /**
     * get制御
     *
     * @param shikibetsuNoKanri ShikibetsuNoKanri
     */
    public void getボタンを制御(ShikibetsuNoKanri shikibetsuNoKanri) {
        SyokanbaraihishikyushinseiketteParameter paramter
                = ViewStateHolder.get(ViewStateKeys.償還払費申請検索キー,
                        SyokanbaraihishikyushinseiketteParameter.class);
        HihokenshaNo 被保険者番号 = paramter.getHiHokenshaNo();
        FlexibleYearMonth サービス年月 = paramter.getServiceTeikyoYM();
        RString 整理番号 = paramter.getSeiriNp();
        JigyoshaNo 事業者番号 = paramter.getJigyoshaNo();
        RString 様式番号 = paramter.getYoshikiNo();
        RString 明細番号 = paramter.getMeisaiNo();
        set基本情報ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        div.getPanelTwo().getBtnKyufuMeisai().setDisabled(false);
        set特定診療費ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set計画費情報(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set特定入所者費用ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set給付費明細_住特ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set緊急時_所定疾患ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set緊急時施設療養費ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set食事費用ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set請求額集計ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set社福軽減額ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
    }

    private void set基本情報ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get基本設定区分())) {
            div.getPanelTwo().getBtnKihonInfo().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get基本設定区分())) {
            int count1 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().getShokanKihonCount(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count1 == 1) {
                div.getPanelTwo().getBtnKihonInfo().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelTwo().getBtnKihonInfo().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get基本設定区分())) {
            div.getPanelTwo().getBtnKihonInfo().setIconNameEnum(IconName.NONE);
        }
    }

    private void set特定診療費ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get特定診療費設定区分())) {
            div.getPanelTwo().getBtnTokuteiShinryouhi().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get特定診療費設定区分())) {
            int count2 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().delShokanMeisaiCount(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count2 == 1) {
                div.getPanelTwo().getBtnTokuteiShinryouhi().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelTwo().getBtnTokuteiShinryouhi().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get特定診療費設定区分())) {
            div.getPanelTwo().getBtnTokuteiShinryouhi().setIconNameEnum(IconName.NONE);
        }
    }

    private void set計画費情報(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定可必須.equals(shikibetsuNoKanri.get居宅計画費設定区分())) {
            int count4 = SyokanbaraihiShikyuShinseiKetteManager.
                    createInstance().updShokanServicePlan(被保険者番号,
                            サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count4 == 1) {
                div.getPanelTwo().getBtnServiceKeikakuhi().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelTwo().getBtnServiceKeikakuhi().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get居宅計画費設定区分())) {
            div.getPanelTwo().getBtnServiceKeikakuhi().setIconNameEnum(IconName.NONE);
        }
    }

    private void set特定入所者費用ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get特定入所者設定区分())) {
            div.getPanelTwo().getBtnTokuteiNyushosya().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get特定入所者設定区分())) {
            int count5 = SyokanbaraihiShikyuShinseiKetteManager.createInstance()
                    .updShokanTokuteiNyushoshaKaigoServiceHiyo(被保険者番号, サービス年月, 整理番号,
                            事業者番号, 様式番号, 明細番号);
            if (count5 == 1) {
                div.getPanelTwo().getBtnTokuteiNyushosya().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelTwo().getBtnTokuteiNyushosya().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get特定入所者設定区分())) {
            div.getPanelTwo().getBtnTokuteiNyushosya().setIconNameEnum(IconName.NONE);
        }
    }

    private void set給付費明細_住特ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get明細住所地特例設定区分())) {
            div.getPanelTwo().getBtnKyufuhiMeisaiJutoku().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get明細住所地特例設定区分())) {
            int count6 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().getShokanMeisaiJushochiTokureiCount(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count6 == 1) {
                div.getPanelTwo().getBtnKyufuhiMeisaiJutoku().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelTwo().getBtnKyufuhiMeisaiJutoku().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get明細住所地特例設定区分())) {
            div.getPanelTwo().getBtnKyufuhiMeisaiJutoku().setIconNameEnum(IconName.NONE);
        }
    }

    private void set緊急時_所定疾患ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get特定疾患施設療養設定区分())) {
            div.getPanelTwo().getBtnKinkyujiShoteiShikan().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get特定疾患施設療養設定区分())) {
            int count7 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShoteiShikkanShisetsuRyoyo(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count7 == 1) {
                div.getPanelTwo().getBtnKinkyujiShoteiShikan().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelTwo().getBtnKinkyujiShoteiShikan().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get特定疾患施設療養設定区分())) {
            div.getPanelTwo().getBtnKinkyujiShoteiShikan().setIconNameEnum(IconName.NONE);
        }
    }

    private void set緊急時施設療養費ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get緊急時施設療養設定区分())) {
            div.getPanelTwo().getBtnKinkyushisetuRyoyouhi().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get緊急時施設療養設定区分())) {
            int count8 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanKinkyuShisetsuRyoyo(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count8 == 1) {
                div.getPanelTwo().getBtnKinkyushisetuRyoyouhi().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelTwo().getBtnKinkyushisetuRyoyouhi().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get緊急時施設療養設定区分())) {
            div.getPanelTwo().getBtnKinkyushisetuRyoyouhi().setIconNameEnum(IconName.NONE);
        }
    }

    private void set食事費用ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get食事費用設定区分())) {
            div.getPanelTwo().getBtnShokujihiyo().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get食事費用設定区分())) {
            int count9 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShokujiHiyo(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count9 == 1) {
                div.getPanelTwo().getBtnShokujihiyo().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelTwo().getBtnShokujihiyo().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get食事費用設定区分())) {
            div.getPanelTwo().getBtnShokujihiyo().setIconNameEnum(IconName.NONE);
        }
    }

    private void set請求額集計ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get集計設定区分())) {
            div.getPanelTwo().getBtnSeikyugakuShukei().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get集計設定区分())) {
            int count10 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShukei(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count10 == 1) {
                div.getPanelTwo().getBtnSeikyugakuShukei().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelTwo().getBtnSeikyugakuShukei().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get集計設定区分())) {
            div.getPanelTwo().getBtnSeikyugakuShukei().setIconNameEnum(IconName.NONE);
        }
    }

    private void set社福軽減額ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get社会福祉法人軽減設定区分())) {
            div.getPanelTwo().getBtnShafukukeigenGaku().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get社会福祉法人軽減設定区分())) {
            int count11 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShakaiFukushiHojinKeigengaku(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count11 == 1) {
                div.getPanelTwo().getBtnShafukukeigenGaku().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelTwo().getBtnShafukukeigenGaku().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get社会福祉法人軽減設定区分())) {
            div.getPanelTwo().getBtnShafukukeigenGaku().setIconNameEnum(IconName.NONE);
        }
    }

    /**
     * putViewState
     */
    public void putViewState() {
        // TODO 支給申請画面のモード　
        ViewStateHolder.put(ViewStateKeys.処理モード, "");
        ViewStateHolder.put(ViewStateKeys.申請日, div.getPanelTwo().getTxtShinseiYMD().getValue());
        SyokanbaraihishikyushinseiketteParameter paramter = new SyokanbaraihishikyushinseiketteParameter(
                ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class),
                new FlexibleYearMonth(div.getPanelTwo().getTxtServiceTeikyoYM().getValue().toDateString()),
                ViewStateHolder.get(ViewStateKeys.整理番号, RString.class),
                new JigyoshaNo(div.getPanelTwo().getTxtJigyoshaBango().getValue()),
                div.getPanelTwo().getTxtShomeisho().getValue(),
                div.getPanelTwo().getTxtMeisaiBango().getValue(),
                null);
        ViewStateHolder.put(ViewStateKeys.償還払費申請検索キー, paramter);
    }

}
