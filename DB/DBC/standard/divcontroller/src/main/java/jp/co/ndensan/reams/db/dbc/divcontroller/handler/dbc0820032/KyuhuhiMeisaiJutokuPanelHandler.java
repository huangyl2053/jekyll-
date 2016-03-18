/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0820032;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanMeisaiJushochiTokurei;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanMeisaiJushochiTokureiResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820032.KyuhuhiMeisaiJutokuPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820032.dgJushochiTokutei_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.syokanbaraihishikyushinseikette.SyokanbaraihishikyushinseiketteParameter;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.HokenshaJoho.HokenshaJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ServiceCodeInputCommonChildDiv.ServiceCodeInputCommonChildDivDiv;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.IconName;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * 償還払い費支給申請決定_サービス提供証明書(給付費明細(住特））
 */
public class KyuhuhiMeisaiJutokuPanelHandler {

    private final KyuhuhiMeisaiJutokuPanelDiv div;
    private static final int NUM = 6;
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");
    private static final RString 設定不可 = new RString("0");
    private static final RString 設定可必須 = new RString("1");
    private static final RString 設定可任意 = new RString("2");
    private static final int NUM1 = 50;

    /**
     * 初期化
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     */
    public KyuhuhiMeisaiJutokuPanelHandler(KyuhuhiMeisaiJutokuPanelDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理します。
     *
     * @param shList List
     */
    public void initialize(List<ShokanMeisaiJushochiTokureiResult> shList) {
        List<dgJushochiTokutei_Row> rowList = new ArrayList<>();
        for (ShokanMeisaiJushochiTokureiResult shokan : shList) {
            dgJushochiTokutei_Row row = new dgJushochiTokutei_Row();
            RStringBuilder builder = new RStringBuilder();
            if (shokan.getEntity().getサービス種類コード() != null) {
                builder.append(shokan.getEntity().getサービス種類コード().value());
            }
            if (shokan.getEntity().getサービス項目コード() != null) {
                builder.append(shokan.getEntity().getサービス項目コード().value());
            }
            row.setDefaultDataName1(builder.toRString());
            row.getDefaultDataName2().setValue(new Decimal(shokan.getEntity().get単位数()));
            row.setDefaultDataName3(new RString(String.valueOf(shokan.getEntity().get日数_回数())));
            row.getDefaultDataName4().setValue(new Decimal(shokan.getEntity().getサービス単位数()));
            row.setDefaultDataName5(shokan.getEntity().get摘要());
            if (shokan.getEntity().get施設所在保険者番号() != null && !shokan.getEntity().get施設所在保険者番号().isEmpty()) {
                row.setDefaultDataName6(shokan.getEntity().get施設所在保険者番号().value());
            }
            row.setDefaultDataName7(shokan.getEntity().get連番());
            row.setDefaultDataName8(shokan.getServiceName());
            row.setDefaultDataName9(shokan.getHokenshaName());
            rowList.add(row);
        }
        div.getPnlBtnDetail().getPnlKyufuhiMeisai().getDgJushochiTokutei().setDataSource(rowList);
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
        div.getPnlBtnDetail().getTxtServiceTeikyoYM().setValue(new RDate(サービス年月.toString()));
        div.getPnlBtnDetail().getTxtShinseibi().setValue(new RDate(申請日.toString()));
        div.getPnlBtnDetail().getTxtJigyoshaNo().setValue(事業者番号.getColumnValue());
        div.getPnlBtnDetail().getTxtMeisaiNo().setValue(明細番号);
        div.getPnlBtnDetail().getTxtShomeisho().setValue(証明書);
    }

    /**
     * set給付費明細
     */
    public void set給付費明細() {
        dgJushochiTokutei_Row row = div.getPnlBtnDetail().getPnlKyufuhiMeisai().getDgJushochiTokutei().getClickedItem();
        ServiceCodeInputCommonChildDivDiv sercode
                = (ServiceCodeInputCommonChildDivDiv) div.getPnlBtnDetail().getPnlKyufuhiMeisai().
                getPnlKyufuhiMeisaiTouroku().getCcdServiceCodeInput();
        HokenshaJohoDiv hojo = (HokenshaJohoDiv) div.getPnlBtnDetail().getPnlKyufuhiMeisai().
                getPnlKyufuhiMeisaiTouroku().getCcdHokenshaJoho();
        if (row.getDefaultDataName1() != null && !row.getDefaultDataName1().isEmpty()) {
            RString serviceCodeShuruyi = new RString(row.getDefaultDataName1().substring(0, 2).toString());
            RString serviceCodeKoumoku = new RString(row.getDefaultDataName1().substring(2, NUM).toString());
            sercode.getTxtServiceCode1().setValue(serviceCodeShuruyi);
            sercode.getTxtServiceCode2().setValue(serviceCodeKoumoku);
        }
        div.getPnlBtnDetail().getPnlKyufuhiMeisai().getPnlKyufuhiMeisaiTouroku().getTxtTanyi().
                setValue(row.getDefaultDataName2().getValue());
        div.getPnlBtnDetail().getPnlKyufuhiMeisai().getPnlKyufuhiMeisaiTouroku().getTxtKaisu().
                setValue(new Decimal(row.getDefaultDataName3().toString()));
        div.getPnlBtnDetail().getPnlKyufuhiMeisai().getPnlKyufuhiMeisaiTouroku().getTxtServiceTani().
                setValue(row.getDefaultDataName4().getValue());
        div.getPnlBtnDetail().getPnlKyufuhiMeisai().getPnlKyufuhiMeisaiTouroku().getTxtTekiyo().
                setValue(row.getDefaultDataName5());
        div.getPnlBtnDetail().getPnlKyufuhiMeisai().getRowId().setValue(new Decimal(row.getId()));
        if (!row.getDefaultDataName6().isNullOrEmpty()) {
            hojo.getTxtHokenshaNo().setValue(row.getDefaultDataName6());
        }
        if (row.getDefaultDataName8() != null && !row.getDefaultDataName8().isEmpty()) {
            sercode.getTxtServiceCodeName().setValue(row.getDefaultDataName8());
        }
        if (row.getDefaultDataName9() != null) {
            hojo.getTxtHokenshaNo().setValue(row.getDefaultDataName9());
        }

    }

    /**
     * clear給付費明細登録
     */
    public void clear給付費明細登録() {
        ServiceCodeInputCommonChildDivDiv sercode
                = (ServiceCodeInputCommonChildDivDiv) div.getPnlBtnDetail().getPnlKyufuhiMeisai().
                getPnlKyufuhiMeisaiTouroku().getCcdServiceCodeInput();
        HokenshaJohoDiv hojo = (HokenshaJohoDiv) div.getPnlBtnDetail().getPnlKyufuhiMeisai().
                getPnlKyufuhiMeisaiTouroku().getCcdHokenshaJoho();
        sercode.getTxtServiceCode1().clearValue();
        sercode.getTxtServiceCode2().clearValue();
        sercode.getTxtServiceCodeName().clearValue();
        hojo.clear();
        div.getPnlBtnDetail().getPnlKyufuhiMeisai().getPnlKyufuhiMeisaiTouroku().getTxtTanyi().clearValue();
        div.getPnlBtnDetail().getPnlKyufuhiMeisai().getPnlKyufuhiMeisaiTouroku().getTxtKaisu().clearValue();
        div.getPnlBtnDetail().getPnlKyufuhiMeisai().getPnlKyufuhiMeisaiTouroku().getTxtServiceTani().clearValue();
        div.getPnlBtnDetail().getPnlKyufuhiMeisai().getPnlKyufuhiMeisaiTouroku().getTxtTekiyo().clearValue();
    }

    /**
     * click計算する
     */
    public void click計算する() {
        if (div.getPnlBtnDetail().getPnlKyufuhiMeisai().getPnlKyufuhiMeisaiTouroku().getTxtTanyi().getValue() != null
                || div.getPnlBtnDetail().getPnlKyufuhiMeisai().getPnlKyufuhiMeisaiTouroku().getTxtKaisu().
                getValue() != null) {
            Decimal data = div.getPnlBtnDetail().getPnlKyufuhiMeisai().getPnlKyufuhiMeisaiTouroku().getTxtTanyi().
                    getValue().multiply(div.getPnlBtnDetail().getPnlKyufuhiMeisai().
                            getPnlKyufuhiMeisaiTouroku().getTxtKaisu().getValue());
            div.getPnlBtnDetail().getPnlKyufuhiMeisai().getPnlKyufuhiMeisaiTouroku().getTxtServiceTani().setValue(data);
        }
    }

    /**
     * modifyRow
     *
     * @param row dgdKyufuhiMeisai_Row
     */
    public void modifyRow(dgJushochiTokutei_Row row) {
        RString state = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        if (修正.equals(state)) {
            boolean flag = checkState(row);
            if (flag) {
                row.setRowState(RowState.Modified);
                setDgJushochiTokutei(row);
            }
        } else if (削除.equals(state)) {
            if (RowState.Added.equals(row.getRowState())) {
                div.getPnlBtnDetail().getPnlKyufuhiMeisai().getDgJushochiTokutei().getDataSource().remove(
                        Integer.parseInt(div.getPnlBtnDetail().getPnlKyufuhiMeisai().getRowId().toString()));
                clear給付費明細登録();
                div.getPnlBtnDetail().getPnlKyufuhiMeisai().getPnlKyufuhiMeisaiTouroku().setVisible(true);
            } else {
                row.setRowState(RowState.Deleted);
                setDgJushochiTokutei(row);
            }
        } else if (登録.equals(state)) {
            row.setRowState(RowState.Added);
            setDgJushochiTokutei(row);
        }
    }

    private boolean checkState(dgJushochiTokutei_Row ddgRow) {
        ServiceCodeInputCommonChildDivDiv sercode
                = (ServiceCodeInputCommonChildDivDiv) div.getPnlBtnDetail().getPnlKyufuhiMeisai().
                getPnlKyufuhiMeisaiTouroku().getCcdServiceCodeInput();
        HokenshaJohoDiv hojo = (HokenshaJohoDiv) div.getPnlBtnDetail().getPnlKyufuhiMeisai().
                getPnlKyufuhiMeisaiTouroku().getCcdHokenshaJoho();
        RString サービス種類コード = sercode.getTxtServiceCode1().getValue();
        RString サービス項目コード = sercode.getTxtServiceCode2().getValue();
        RStringBuilder builder = new RStringBuilder();
        builder.append(サービス種類コード).append(サービス項目コード);
        if (!ddgRow.getDefaultDataName1().equals(builder.toRString())) {
            return true;
        }
        if (!ddgRow.getDefaultDataName2().getValue().equals(div.getPnlBtnDetail().getPnlKyufuhiMeisai().
                getPnlKyufuhiMeisaiTouroku().getTxtTanyi().getValue())) {
            return true;
        }
        if (!ddgRow.getDefaultDataName3().equals(
                new RString(div.getPnlBtnDetail().getPnlKyufuhiMeisai().
                        getPnlKyufuhiMeisaiTouroku().getTxtKaisu().getValue().toString()))) {
            return true;
        }
        if (!ddgRow.getDefaultDataName4().getValue().equals(div.getPnlBtnDetail().getPnlKyufuhiMeisai().
                getPnlKyufuhiMeisaiTouroku().getTxtServiceTani().getValue())) {
            return true;
        }
        if (!ddgRow.getDefaultDataName5().equals(
                div.getPnlBtnDetail().getPnlKyufuhiMeisai().getPnlKyufuhiMeisaiTouroku().getTxtTekiyo().getValue())) {
            return true;
        }
        if (!ddgRow.getDefaultDataName6().equals(hojo.getTxtHokenshaMeisho().getValue())) {
            return true;
        }
        return true;
    }

    private void setDgJushochiTokutei(dgJushochiTokutei_Row ddgRow) {
        ServiceCodeInputCommonChildDivDiv sercode
                = (ServiceCodeInputCommonChildDivDiv) div.getPnlBtnDetail().getPnlKyufuhiMeisai().
                getPnlKyufuhiMeisaiTouroku().getCcdServiceCodeInput();
        RStringBuilder builder = new RStringBuilder();
        builder.append(NUM1);
//TODO   QA399
//        if (serviceCodeInputDiv.getTxtServiceCode1() != null) {
//            builder.append(serviceCodeInputDiv.getTxtServiceCode1().getValue());
//        }
        if (sercode.getTxtServiceCode2() != null) {
            builder.append(sercode.getTxtServiceCode2().getValue());
        }
        ddgRow.setDefaultDataName1(builder.toRString());
        if (div.getPnlBtnDetail().getPnlKyufuhiMeisai().
                getPnlKyufuhiMeisaiTouroku().getTxtTanyi().getValue() != null) {
            ddgRow.getDefaultDataName2().setValue(
                    div.getPnlBtnDetail().getPnlKyufuhiMeisai().
                    getPnlKyufuhiMeisaiTouroku().getTxtTanyi().getValue());
        }
        if (div.getPnlBtnDetail().getPnlKyufuhiMeisai().
                getPnlKyufuhiMeisaiTouroku().getTxtKaisu().getValue() != null) {
            ddgRow.setDefaultDataName3(new RString(
                    div.getPnlBtnDetail().getPnlKyufuhiMeisai().
                    getPnlKyufuhiMeisaiTouroku().getTxtKaisu().getValue().toString()));
        }
        if (div.getPnlBtnDetail().getPnlKyufuhiMeisai().
                getPnlKyufuhiMeisaiTouroku().getTxtServiceTani().getValue() != null) {
            ddgRow.getDefaultDataName4().setValue(div.getPnlBtnDetail().getPnlKyufuhiMeisai().
                    getPnlKyufuhiMeisaiTouroku().getTxtServiceTani().getValue());
        }
        if (div.getPnlBtnDetail().getPnlKyufuhiMeisai().getPnlKyufuhiMeisaiTouroku().getTxtTekiyo().getValue() != null) {
            ddgRow.setDefaultDataName5(div.getPnlBtnDetail().
                    getPnlKyufuhiMeisai().getPnlKyufuhiMeisaiTouroku().getTxtTekiyo().getValue());
        }
        if (div.getPnlBtnDetail().getPnlKyufuhiMeisai().
                getPnlKyufuhiMeisaiTouroku().getCcdHokenshaJoho() != null) {
            ddgRow.setDefaultDataName6(div.getPnlBtnDetail().getPnlKyufuhiMeisai().
                    getPnlKyufuhiMeisaiTouroku().getCcdHokenshaJoho().getHokenjaNo());
        }
        if (登録.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {

            List<dgJushochiTokutei_Row> list = div.getPnlBtnDetail().
                    getPnlKyufuhiMeisai().getDgJushochiTokutei().getDataSource();
            list.add(ddgRow);
        }
        clear給付費明細登録();
        div.getPnlBtnDetail().getPnlKyufuhiMeisai().getPnlKyufuhiMeisaiTouroku().setVisible(false);
    }

    /**
     * selectRow
     *
     * @return dgdKyufuhiMeisai_Row
     */
    public dgJushochiTokutei_Row selectRow() {
        return div.getPnlBtnDetail().getPnlKyufuhiMeisai().getDgJushochiTokutei().getDataSource().get(
                Integer.parseInt(div.getPnlBtnDetail().getPnlKyufuhiMeisai().getRowId().getValue().toString()));
    }

    /**
     * is内容変更状態
     *
     *
     * @return true
     */
    public boolean is内容変更状態() {
        for (dgJushochiTokutei_Row ddgList : div.getPnlBtnDetail().getPnlKyufuhiMeisai().
                getDgJushochiTokutei().getDataSource()) {
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
        SyokanbaraihishikyushinseiketteParameter parameter = ViewStateHolder.
                get(ViewStateKeys.償還払費申請検索キー,
                        SyokanbaraihishikyushinseiketteParameter.class);
        FlexibleYearMonth サービス年月 = parameter.getServiceTeikyoYM();
        HihokenshaNo 被保険者番号 = parameter.getHiHokenshaNo();
        RString 整理番号 = parameter.getSeiriNp();
        RString 様式番号 = parameter.getYoshikiNo();
        RString 明細番号 = parameter.getMeisaiNo();
        JigyoshaNo 事業者番号 = parameter.getJigyoshaNo();
        List<ShokanMeisaiJushochiTokurei> entityList = new ArrayList<>();
        List<dgJushochiTokutei_Row> dgrow = div.getPnlBtnDetail().getPnlKyufuhiMeisai().
                getDgJushochiTokutei().getDataSource();
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            SyokanbaraihiShikyuShinseiKetteManager.createInstance().
                    delShokanSyomeisyo(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        } else {
            int max連番 = 0;
            List<ShokanMeisaiJushochiTokureiResult> shkonlist = ViewStateHolder.get(ViewStateKeys.給付費明細住特, List.class);
            Map<RString, ShokanMeisaiJushochiTokurei> mapList = new HashMap<>();
            for (ShokanMeisaiJushochiTokureiResult shokanMeisaiResult : shkonlist) {
                mapList.put(shokanMeisaiResult.getEntity().get連番(), shokanMeisaiResult.getEntity());
                if (max連番 < Integer.parseInt(shokanMeisaiResult.getEntity().get連番().toString())) {
                    max連番 = Integer.parseInt(shokanMeisaiResult.getEntity().get連番().toString());
                }
            }
            for (dgJushochiTokutei_Row row : dgrow) {
                if (RowState.Modified.equals(row.getRowState())) {
                    ShokanMeisaiJushochiTokurei entityModified = mapList.get(row.getDefaultDataName7());
                    entityModified = buildshokanMeisai(entityModified, row);
                    entityList.add(entityModified.modified());
                } else if (RowState.Deleted.equals(row.getRowState())) {
                    entityList.add(mapList.get(row.getDefaultDataName7()).deleted());
                } else if (RowState.Added.equals(row.getRowState())) {
                    max連番 = max連番 + 1;
                    ShokanMeisaiJushochiTokurei entityAdded = new ShokanMeisaiJushochiTokurei(
                            被保険者番号,
                            サービス年月,
                            整理番号,
                            事業者番号,
                            様式番号,
                            明細番号,
                            new RString(String.valueOf(max連番))).createBuilderForEdit().build();
                    entityAdded = buildshokanMeisai(entityAdded, row);
                    entityList.add(entityAdded.added());
                }
            }
        }
        SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanMeisaiJushochiTokurei(entityList);

    }

    private ShokanMeisaiJushochiTokurei buildshokanMeisai(ShokanMeisaiJushochiTokurei entity, dgJushochiTokutei_Row row) {
        RString serviceCodeShuruyi = new RString(row.getDefaultDataName1().substring(0, 2).toString());
        RString serviceCodeKoumoku = new RString(row.getDefaultDataName1().substring(2, NUM).toString());
        entity = entity.createBuilderForEdit().setサービス種類コード(
                new ServiceShuruiCode(serviceCodeShuruyi)).build();
        entity = entity.createBuilderForEdit().setサービス項目コード(
                new ServiceKomokuCode(serviceCodeKoumoku)).build();
        if (row.getDefaultDataName2().getValue() != null) {
            entity = entity.createBuilderForEdit().set単位数(Integer.parseInt(
                    row.getDefaultDataName2().toString())).build();
        }
        if (row.getDefaultDataName3() != null) {
            entity = entity.createBuilderForEdit().set日数_回数(Integer.parseInt(
                    row.getDefaultDataName3().toString())).build();
        }
        if (row.getDefaultDataName4().getValue() != null) {
            entity = entity.createBuilderForEdit().setサービス単位数(
                    row.getDefaultDataName4().getValue().intValue()).build();
        }
        if (row.getDefaultDataName5() != null) {
            entity = entity.createBuilderForEdit().set摘要(row.getDefaultDataName5()).build();
        }
        if (row.getDefaultDataName6() != null) {
            entity = entity.createBuilderForEdit().set施設所在保険者番号(
                    new ShoKisaiHokenshaNo(row.getDefaultDataName6())).build();
        }

        return entity;

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
        set給付費明細ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set特定診療費ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        setサービス計画費ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set特定入所者費用ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set緊急時_所定疾患ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set緊急時施設療養費ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set食事費用ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set請求額集計ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set社福軽減額ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        div.getPnlBtnDetail().getBtnJuToku().setDisabled(true);
        div.getPnlBtnDetail().getBtnGokeiJoho().setDisabled(false);
    }

    private void set基本情報ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get基本設定区分())) {
            div.getPnlBtnDetail().getBtnKihonJoho().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get基本設定区分())) {
            int count1 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().getShokanKihonCount(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count1 != 0) {
                div.getPnlBtnDetail().getBtnKihonJoho().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPnlBtnDetail().getBtnKihonJoho().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get基本設定区分())) {
            div.getPnlBtnDetail().getBtnKihonJoho().setIconNameEnum(IconName.NONE);
        }
    }

    private void set給付費明細ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get明細設定区分())) {
            div.getPnlBtnDetail().getBtnKyufuhiMeisai().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get明細設定区分())) {
            int count2 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().delShokanMeisaiCount(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count2 != 0) {
                div.getPnlBtnDetail().getBtnKyufuhiMeisai().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPnlBtnDetail().getBtnKyufuhiMeisai().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get明細設定区分())) {
            div.getPnlBtnDetail().getBtnKyufuhiMeisai().setIconNameEnum(IconName.NONE);
        }
    }

    private void set特定診療費ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get特定診療費設定区分())) {
            div.getPnlBtnDetail().getBtnTokuteiShiryohi().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get特定診療費設定区分())) {
            int count2 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanTokuteiShinryohi(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count2 != 0) {
                div.getPnlBtnDetail().getBtnTokuteiShiryohi().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPnlBtnDetail().getBtnTokuteiShiryohi().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get特定診療費設定区分())) {
            div.getPnlBtnDetail().getBtnTokuteiShiryohi().setIconNameEnum(IconName.NONE);
        }
    }

    private void setサービス計画費ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get居宅計画費設定区分())) {
            div.getPnlBtnDetail().getBtnServicePlanhi().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get居宅計画費設定区分())) {
            int count4 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanServicePlan(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count4 != 0) {
                div.getPnlBtnDetail().getBtnServicePlanhi().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPnlBtnDetail().getBtnServicePlanhi().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get居宅計画費設定区分())) {
            div.getPnlBtnDetail().getBtnServicePlanhi().setIconNameEnum(IconName.NONE);
        }
    }

    private void set特定入所者費用ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get特定入所者設定区分())) {
            div.getPnlBtnDetail().getBtnTokuteiNyushoshaHi().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get特定入所者設定区分())) {
            int count5 = SyokanbaraihiShikyuShinseiKetteManager.createInstance()
                    .updShokanTokuteiNyushoshaKaigoServiceHiyo(被保険者番号, サービス年月, 整理番号,
                            事業者番号, 様式番号, 明細番号);
            if (count5 != 0) {
                div.getPnlBtnDetail().getBtnTokuteiNyushoshaHi().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPnlBtnDetail().getBtnTokuteiNyushoshaHi().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get特定入所者設定区分())) {
            div.getPnlBtnDetail().getBtnTokuteiNyushoshaHi().setIconNameEnum(IconName.NONE);
        }
    }

    private void set緊急時_所定疾患ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get特定疾患施設療養設定区分())) {
            div.getPnlBtnDetail().getBtnKinkyujiShoteiShikan().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get特定疾患施設療養設定区分())) {
            int count7 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShoteiShikkanShisetsuRyoyo(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count7 != 0) {
                div.getPnlBtnDetail().getBtnKinkyujiShoteiShikan().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPnlBtnDetail().getBtnKinkyujiShoteiShikan().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get特定疾患施設療養設定区分())) {
            div.getPnlBtnDetail().getBtnKinkyujiShoteiShikan().setIconNameEnum(IconName.NONE);
        }
    }

    private void set緊急時施設療養費ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get緊急時施設療養設定区分())) {
            div.getPnlBtnDetail().getBtnKinkyuShisetsuRyoyouhi().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get緊急時施設療養設定区分())) {
            int count8 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanKinkyuShisetsuRyoyo(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count8 != 0) {
                div.getPnlBtnDetail().getBtnKinkyuShisetsuRyoyouhi().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPnlBtnDetail().getBtnKinkyuShisetsuRyoyouhi().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get緊急時施設療養設定区分())) {
            div.getPnlBtnDetail().getBtnKinkyuShisetsuRyoyouhi().setIconNameEnum(IconName.NONE);
        }
    }

    private void set食事費用ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get食事費用設定区分())) {
            div.getPnlBtnDetail().getBtnShokujiHi().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get食事費用設定区分())) {
            int count9 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShokujiHiyo(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count9 != 0) {
                div.getPnlBtnDetail().getBtnShokujiHi().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPnlBtnDetail().getBtnShokujiHi().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get食事費用設定区分())) {
            div.getPnlBtnDetail().getBtnShokujiHi().setIconNameEnum(IconName.NONE);
        }
    }

    private void set請求額集計ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get集計設定区分())) {
            div.getPnlBtnDetail().getBtnShiseigakuShukei().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get集計設定区分())) {
            int count10 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShukei(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count10 != 0) {
                div.getPnlBtnDetail().getBtnShiseigakuShukei().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPnlBtnDetail().getBtnShiseigakuShukei().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get集計設定区分())) {
            div.getPnlBtnDetail().getBtnShiseigakuShukei().setIconNameEnum(IconName.NONE);
        }
    }

    private void set社福軽減額ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get社会福祉法人軽減設定区分())) {
            div.getPnlBtnDetail().getBtnShafukuGahenGaku().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get社会福祉法人軽減設定区分())) {
            int count11 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShakaiFukushiHojinKeigengaku(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count11 != 0) {
                div.getPnlBtnDetail().getBtnShafukuGahenGaku().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPnlBtnDetail().getBtnShafukuGahenGaku().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get社会福祉法人軽減設定区分())) {
            div.getPnlBtnDetail().getBtnShafukuGahenGaku().setIconNameEnum(IconName.NONE);
        }
    }

    /**
     * putViewState
     */
    public void putViewState() {
        ViewStateHolder.put(ViewStateKeys.処理モード, RString.EMPTY);
        ViewStateHolder.put(ViewStateKeys.申請日, div.getPnlBtnDetail().getTxtShinseibi().getValue());
        SyokanbaraihishikyushinseiketteParameter paramter = new SyokanbaraihishikyushinseiketteParameter(
                ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class),
                new FlexibleYearMonth(div.getPnlBtnDetail().getTxtServiceTeikyoYM().getValue().toDateString()),
                ViewStateHolder.get(ViewStateKeys.整理番号, RString.class),
                new JigyoshaNo(div.getPnlBtnDetail().getTxtJigyoshaNo().getValue()),
                div.getPnlBtnDetail().getTxtShomeisho().getValue(),
                div.getPnlBtnDetail().getTxtMeisaiNo().getValue(),
                null);
        ViewStateHolder.put(ViewStateKeys.償還払費申請検索キー, paramter);
    }

    /**
     * readOnly給付費明細登録
     *
     * @param flag boolean
     */
    public void readOnly給付費明細登録(boolean flag) {
        ServiceCodeInputCommonChildDivDiv sercode
                = (ServiceCodeInputCommonChildDivDiv) div.getPnlBtnDetail().getPnlKyufuhiMeisai().
                getPnlKyufuhiMeisaiTouroku().getCcdServiceCodeInput();
        HokenshaJohoDiv hojo = (HokenshaJohoDiv) div.getPnlBtnDetail().getPnlKyufuhiMeisai().
                getPnlKyufuhiMeisaiTouroku().getCcdHokenshaJoho();
        sercode.getTxtServiceCode2().setReadOnly(flag);
        div.getPnlBtnDetail().getPnlKyufuhiMeisai().getPnlKyufuhiMeisaiTouroku().getTxtTanyi().setReadOnly(flag);
        div.getPnlBtnDetail().getPnlKyufuhiMeisai().getPnlKyufuhiMeisaiTouroku().getTxtKaisu().setReadOnly(flag);
        div.getPnlBtnDetail().getPnlKyufuhiMeisai().getPnlKyufuhiMeisaiTouroku().getTxtServiceTani().setReadOnly(flag);
        div.getPnlBtnDetail().getPnlKyufuhiMeisai().getPnlKyufuhiMeisaiTouroku().getTxtTekiyo().setReadOnly(flag);
        hojo.getTxtHokenshaMeisho().setReadOnly(flag);

    }

}
