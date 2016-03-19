/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0720011;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanJutakuKaishu;
import jp.co.ndensan.reams.db.dbc.business.core.jutakukaishusikyushinseiikkatushinsa.MiShinsaSikyuShinsei;
import jp.co.ndensan.reams.db.dbc.business.core.jutakukaishusikyushinseiikkatushinsa.SaveIkkatuShinsaDate;
import jp.co.ndensan.reams.db.dbc.definition.core.jutakukaishuhishikyushinsei.JutakuKaishuhiShikyuShinseiKeys;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyufushikyukubun.ShikyuFushikyuKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyushinseishinsa.ShikyushinseiShinsaKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shinnsanaiyo.ShinsaNaiyoKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0720011.DBC0720011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0720011.DBC0720011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0720011.JutakuKaishuhiShikyuShinseiPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0720011.JutakuKaishuhiShikyuShinseiPanelVlaidationHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0720011.dgMishinsaShikyuShinsei_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.dbc0720011.MishinsaShikyuShinseiListHandler;
import jp.co.ndensan.reams.db.dbc.service.core.jutakukaishujyusyo.JutakuKaishuJyusyoChofukuHanntei;
import jp.co.ndensan.reams.db.dbc.service.core.jutakukaishusikyushinsei.JutakuKaishuShikyuGendogakuHantei;
import jp.co.ndensan.reams.db.dbc.service.core.jutakukaishusikyushinseiikkatushinsa.JutakukaishuSikyuShinseiIkkatuShinsaManager;
import jp.co.ndensan.reams.db.dbc.service.core.jutakukaishuyaokaigojyotaisandannkaihantei.JutakuKaishuYaokaigoJyotaiSandannkaiHanteiManager;
import jp.co.ndensan.reams.db.dbc.service.jutakukaishujizenshinsei.JutakuKaishuJizenShinsei;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計　住宅改修費支給申請一括審査・決定
 */
public class JutakuKaishuhiShikyuShinseiPanel {

    private static final RString 検索 = new RString("検索");
    private static final RString 保存パターン = new RString("btnSave");
    private static final RString 却下する = new RString("却下する");
    private static final RString 承認する = new RString("承認する");
    private static final int LENGTH = 6;

    /**
     * onLoadメソッド
     *
     * @param div JutakuKaishuhiShikyuShinseiPanelDiv
     * @return ResponseData<JutakuKaishuhiShikyuShinseiPanelDiv>
     */
    public ResponseData<JutakuKaishuhiShikyuShinseiPanelDiv> onLoad(JutakuKaishuhiShikyuShinseiPanelDiv div) {
        if (検索.equals(ViewStateHolder.get(JutakuKaishuhiShikyuShinseiKeys.状態, RString.class))) {
            div.getMishinsaShikyuShinseiListPanel().getTxtKetteiYMD().setValue(RDate.getNowDate());
            RDate 支給申請日開始 = ViewStateHolder.get(JutakuKaishuhiShikyuShinseiKeys.支給申請日From, RDate.class);
            RDate 支給申請日終了 = ViewStateHolder.get(JutakuKaishuhiShikyuShinseiKeys.支給申請日To, RDate.class);
            JutakukaishuSikyuShinseiIkkatuShinsaManager manager = JutakukaishuSikyuShinseiIkkatuShinsaManager.createInstance();
            List<MiShinsaSikyuShinsei> resultList = manager.getMiShinasaShikyuShinseiList(new FlexibleDate(支給申請日開始.toDateString()),
                    new FlexibleDate(支給申請日終了.toDateString()));
            List<MiShinsaSikyuShinsei> viewStateList = ViewStateHolder.get(JutakuKaishuhiShikyuShinseiKeys.申請一覧GridEntity, List.class);
            if (!resultList.isEmpty() && !viewStateList.isEmpty()) {
                審査結果の再設定(viewStateList, resultList);
            }
            申請一覧の表示順(viewStateList);
            MishinsaShikyuShinseiListHandler handler = MishinsaShikyuShinseiListHandler.of(div.getMishinsaShikyuShinseiListPanel());
            handler.initializeDropDownList(viewStateList);
            if (viewStateList.isEmpty()) {
                div.getMishinsaShikyuShinseiListPanel().getShinsaButton().getBtnShinsa().setDisabled(Boolean.TRUE);
            }
            div.getSearchConditionToMishinsaShikyuShinseiPanel().getTxtShikyuShinseiDate().setFromValue(支給申請日開始);
            div.getSearchConditionToMishinsaShikyuShinseiPanel().getTxtShikyuShinseiDate().setToValue(支給申請日終了);
            div.getSearchConditionToMishinsaShikyuShinseiPanel().setIsOpen(Boolean.TRUE);
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 申請一覧の表示順
     *
     * @param viewStateList List<MiShinsaSikyuShinsei>
     */
    private void 申請一覧の表示順(List<MiShinsaSikyuShinsei> viewStateList) {
        Collections.sort(viewStateList, new Comparator<MiShinsaSikyuShinsei>() {
            @Override
            public int compare(MiShinsaSikyuShinsei o1, MiShinsaSikyuShinsei o2) {
                FlexibleDate shinseiYMD1 = o1.getEntity().get申請年月日();
                FlexibleDate shinseiYMD2 = o2.getEntity().get申請年月日();
                int flag = 0;
                if (shinseiYMD1 != null && shinseiYMD2 != null) {
                    flag = shinseiYMD1.compareTo(shinseiYMD2);
                    if (0 == flag) {
                        flag = o1.getEntity().getサービス提供年月().compareTo(o2.getEntity().getサービス提供年月());
                    }
                }
                return flag;
            }
        });
    }

    /**
     * 審査結果の再設定
     *
     * @param viewStateList List<MiShinsaSikyuShinsei>
     * @param resultList List<MiShinsaSikyuShinsei>
     */
    private void 審査結果の再設定(List<MiShinsaSikyuShinsei> viewStateList, List<MiShinsaSikyuShinsei> resultList) {
        for (MiShinsaSikyuShinsei viewState : viewStateList) {
            for (MiShinsaSikyuShinsei data : resultList) {
                if (viewState.getEntity().get被保険者番号().equals(data.getEntity().get被保険者番号())
                        && viewState.getEntity().getサービス提供年月().equals(data.getEntity().getサービス提供年月())
                        && viewState.getEntity().get整理番号().equals(data.getEntity().get整理番号())) {
                    viewState.getEntity().createBuilderForEdit().set住宅住所変更(data.getEntity().get住宅住所変更())
                            .set要介護状態３段階変更(data.getEntity().get要介護状態３段階変更())
                            .set審査結果(data.getEntity().get審査結果());
                }
            }
        }
    }

    /**
     * 「未審査分を検索する」ボタンメソッド
     *
     * @param div JutakuKaishuhiShikyuShinseiPanelDiv
     * @return ResponseData<JutakuKaishuhiShikyuShinseiPanelDiv>
     */
    public ResponseData<JutakuKaishuhiShikyuShinseiPanelDiv> onClick_btnSearchMishinsa(JutakuKaishuhiShikyuShinseiPanelDiv div) {
        ValidationMessageControlPairs validationMessages = new JutakuKaishuhiShikyuShinseiPanelVlaidationHandler(div).volidate支給申請日();
        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        RDate 支給申請日開始 = div.getSearchConditionToMishinsaShikyuShinseiPanel().getTxtShikyuShinseiDate().getFromValue();
        RDate 支給申請日終了 = div.getSearchConditionToMishinsaShikyuShinseiPanel().getTxtShikyuShinseiDate().getToValue();
        JutakukaishuSikyuShinseiIkkatuShinsaManager manager = JutakukaishuSikyuShinseiIkkatuShinsaManager.createInstance();
        List<MiShinsaSikyuShinsei> resultList = manager.getMiShinasaShikyuShinseiList(new FlexibleDate(支給申請日開始.toDateString()),
                new FlexibleDate(支給申請日終了.toDateString()));
        ViewStateHolder.put(JutakuKaishuhiShikyuShinseiKeys.未審査支給申請一覧, (Serializable) resultList);
        MishinsaShikyuShinseiListHandler handler = MishinsaShikyuShinseiListHandler.of(div.getMishinsaShikyuShinseiListPanel());
        handler.initializeDropDownList(resultList);
        div.getMishinsaShikyuShinseiListPanel().getTxtKetteiYMD().setValue(RDate.getNowDate());
        if (resultList.isEmpty()) {
            div.getMishinsaShikyuShinseiListPanel().getShinsaButton().getBtnShinsa().setDisabled(Boolean.TRUE);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(保存パターン, Boolean.TRUE);
        } else {
            div.getMishinsaShikyuShinseiListPanel().getShinsaButton().getBtnShinsa().setDisabled(Boolean.FALSE);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(保存パターン, Boolean.FALSE);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「支給申請内容を一括審査・決定する」ボタンメソッド
     *
     * @param div JutakuKaishuhiShikyuShinseiPanelDiv
     * @return ResponseData<JutakuKaishuhiShikyuShinseiPanelDiv>
     */
    public ResponseData<JutakuKaishuhiShikyuShinseiPanelDiv> onClick_btnShinsa(JutakuKaishuhiShikyuShinseiPanelDiv div) {
        ValidationMessageControlPairs validationMessages = new JutakuKaishuhiShikyuShinseiPanelVlaidationHandler(div).volidateデータ選択();
        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        List<dgMishinsaShikyuShinsei_Row> list = div.getMishinsaShikyuShinseiListPanel().getDgMishinsaShikyuShinsei().getSelectedItems();
        boolean 改修住所重複判定;
        boolean 要介護状態３段階変更判定;
        boolean 限度額判定;
        for (dgMishinsaShikyuShinsei_Row row : list) {
            if (row.getTxtShinsaResult().isEmpty()) {
                HihokenshaNo 被保険者番号 = new HihokenshaNo(row.getTxtHihoNo());
                FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth(row.getTxtTeikyoYM().getValue().toDateString().substring(0, LENGTH));
                RString 整理番号 = row.getTxtSeiriNo().getValue();
                boolean 限度リセットフラグ = false;
                if (row.getTxtTenkyoReset() && row.getTxt3DankaiReset()) {
                    限度リセットフラグ = true;
                }
                Decimal 保険対象費用額 = new Decimal(row.getTxtHokenTaishoHiyogaku().toString());
                改修住所重複判定 = 改修住所変更チェック(被保険者番号, サービス提供年月, 整理番号);
                要介護状態３段階変更判定 = 要介護状態３段階変更チェック(被保険者番号, サービス提供年月);
                限度額判定 = 限度額チェック(被保険者番号, サービス提供年月, 整理番号, 限度リセットフラグ, 保険対象費用額);
                if (限度額判定) {
                    row.setTxtShinsaResult(承認する);
                } else {
                    row.setTxtShinsaResult(却下する);
                }
                if (改修住所重複判定) {
                    row.setTxtTenkyoReset(Boolean.TRUE);
                }
                if (要介護状態３段階変更判定) {
                    row.setTxt3DankaiReset(Boolean.TRUE);
                }
            }
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 「修正」ボタンメソッド
     *
     * @param div JutakuKaishuhiShikyuShinseiPanelDiv
     * @return ResponseData<JutakuKaishuhiShikyuShinseiPanelDiv>
     */
    public ResponseData<JutakuKaishuhiShikyuShinseiPanelDiv> onSelectByModifyButton(JutakuKaishuhiShikyuShinseiPanelDiv div) {
        RDate 支給申請日開始 = div.getSearchConditionToMishinsaShikyuShinseiPanel().getTxtShikyuShinseiDate().getFromValue();
        RDate 支給申請日終了 = div.getSearchConditionToMishinsaShikyuShinseiPanel().getTxtShikyuShinseiDate().getToValue();
        List<dgMishinsaShikyuShinsei_Row> list = div.getMishinsaShikyuShinseiListPanel().getDgMishinsaShikyuShinsei().getDataSource();
        dgMishinsaShikyuShinsei_Row row = div.getMishinsaShikyuShinseiListPanel().getDgMishinsaShikyuShinsei().getClickedItem();
        HihokenshaNo 被保険者番号 = new HihokenshaNo(row.getTxtHihoNo());
        FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth(row.getTxtTeikyoYM().getValue().toDateString().substring(0, LENGTH));
        RString 整理番号 = row.getTxtSeiriNo().getValue();
        ViewStateHolder.put(JutakuKaishuhiShikyuShinseiKeys.支給申請日From, 支給申請日開始);
        ViewStateHolder.put(JutakuKaishuhiShikyuShinseiKeys.支給申請日To, 支給申請日終了);
        ViewStateHolder.put(JutakuKaishuhiShikyuShinseiKeys.申請一覧GridEntity, (Serializable) list);
        ViewStateHolder.put(JutakuKaishuhiShikyuShinseiKeys.被保険者番号, 被保険者番号);
        ViewStateHolder.put(JutakuKaishuhiShikyuShinseiKeys.サービス提供年月, サービス提供年月);
        ViewStateHolder.put(JutakuKaishuhiShikyuShinseiKeys.整理番号, 整理番号);
        return ResponseData.of(div).forwardWithEventName(DBC0720011TransitionEventName.申請修正).respond();
    }

    /**
     * 「保存」ボタンメソッド
     *
     * @param div JutakuKaishuhiShikyuShinseiPanelDiv
     * @return ResponseData<JutakuKaishuhiShikyuShinseiPanelDiv>
     */
    public ResponseData<JutakuKaishuhiShikyuShinseiPanelDiv> onClick_btnSave(JutakuKaishuhiShikyuShinseiPanelDiv div) {
        ValidationMessageControlPairs validationMessages = new JutakuKaishuhiShikyuShinseiPanelVlaidationHandler(div).volidateデータ選択と未審査();
        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(保存パターン, Boolean.FALSE);
            return ResponseData.of(div).respond();
        }
        FlexibleDate 決定年月日 = new FlexibleDate(div.getMishinsaShikyuShinseiListPanel().getTxtKetteiYMD().getValue().toDateString());
        JutakukaishuSikyuShinseiIkkatuShinsaManager manager = JutakukaishuSikyuShinseiIkkatuShinsaManager.createInstance();
        boolean is正常終了 = manager.saveDBDate(データ保存(div.getMishinsaShikyuShinseiListPanel().getDgMishinsaShikyuShinsei().getSelectedItems(), 決定年月日));
        if (is正常終了) {
            div.getKansyoMessagePanel().getCcdKansyoMessage().setMessage(UrInformationMessages.保存終了, RString.EMPTY, RString.EMPTY, is正常終了);
        } else {
            div.getKansyoMessagePanel().getCcdKansyoMessage().setMessage(UrErrorMessages.異常終了, RString.EMPTY, RString.EMPTY, is正常終了);
        }
        CommonButtonHolder.setDisabledByCommonButtonFieldName(保存パターン, Boolean.FALSE);
        return ResponseData.of(div).setState(DBC0720011StateName.完了);
    }

    /**
     * 改修住所変更チェック
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @return 改修住所重複判定 boolean
     */
    private boolean 改修住所変更チェック(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月, RString 整理番号) {
        boolean 改修住所重複判定 = Boolean.FALSE;
        JutakukaishuSikyuShinseiIkkatuShinsaManager shinsaManager = JutakukaishuSikyuShinseiIkkatuShinsaManager.createInstance();
        List<ShokanJutakuKaishu> 住宅改修List = shinsaManager.getShokanJutakuKaishuList(被保険者番号, サービス提供年月, 整理番号);
        if (!住宅改修List.isEmpty()) {
            for (ShokanJutakuKaishu shokanJutakuKaishu : 住宅改修List) {
                JutakuKaishuJyusyoChofukuHanntei chofukuHanntei = JutakuKaishuJyusyoChofukuHanntei.createInstance();
                改修住所重複判定 = chofukuHanntei.checkKaishuJyusyoChofukuToroku(被保険者番号, サービス提供年月, shokanJutakuKaishu.get住宅改修住宅住所());
            }
        }
        return 改修住所重複判定;
    }

    /**
     * 要介護状態３段階変更チェック
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @return boolean
     */
    private boolean 要介護状態３段階変更チェック(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月) {
        JutakuKaishuYaokaigoJyotaiSandannkaiHanteiManager hanteiManager = JutakuKaishuYaokaigoJyotaiSandannkaiHanteiManager.createInstance();
        return hanteiManager.checkYaokaigoJyotaiSandannkai(被保険者番号, サービス提供年月);
    }

    /**
     * 限度額チェック
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @param 限度リセットフラグ boolean
     * @param 保険対象費用額 Decimal
     * @return boolean
     */
    private boolean 限度額チェック(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月, RString 整理番号,
            boolean 限度リセットフラグ, Decimal 保険対象費用額) {
        JutakuKaishuShikyuGendogakuHantei gendogakuHantei = new JutakuKaishuShikyuGendogakuHantei(JutakuKaishuJizenShinsei.createInstance());
        return gendogakuHantei.checkJutakukaishuShikyuGendogaku(被保険者番号, サービス提供年月, 整理番号, 限度リセットフラグ, 保険対象費用額);
    }

    /**
     * 申請一覧Gridの内容がデータへ保存
     *
     * @param list List<dgMishinsaShikyuShinsei_Row>
     * @param 決定年月日 FlexibleDate
     * @return List<SaveIkkatuShinsaDate>
     */
    private List<SaveIkkatuShinsaDate> データ保存(List<dgMishinsaShikyuShinsei_Row> list, FlexibleDate 決定年月日) {
        List<MiShinsaSikyuShinsei> viewStateList = ViewStateHolder.get(JutakuKaishuhiShikyuShinseiKeys.未審査支給申請一覧, List.class);
        List<SaveIkkatuShinsaDate> parameterList = new ArrayList<>();
        for (dgMishinsaShikyuShinsei_Row row : list) {
            HihokenshaNo 被保険者番号 = new HihokenshaNo(row.getTxtHihoNo());
            FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth(row.getTxtTeikyoYM().getValue().toDateString().substring(0, LENGTH));
            RString 整理番号 = row.getTxtSeiriNo().getValue();
            HokenshaNo 証記載保険者番号 = new HokenshaNo(row.getTxtShokisaiHokenshaNo());
            RString 支給決定区分 = RString.EMPTY;
            if (却下する.equals(row.getTxtShinsaResult())) {
                支給決定区分 = ShikyuFushikyuKubun.不支給.getコード();
            } else if (承認する.equals(row.getTxtShinsaResult())) {
                支給決定区分 = ShikyuFushikyuKubun.支給.getコード();
            }
            Decimal 支払金額 = row.getTxtHokenKyufuAmount().getValue();
            for (MiShinsaSikyuShinsei miShinsaSikyuShinsei : viewStateList) {
                if (miShinsaSikyuShinsei.getEntity().get被保険者番号().equals(被保険者番号)
                        && miShinsaSikyuShinsei.getEntity().getサービス提供年月().equals(サービス提供年月)
                        && miShinsaSikyuShinsei.getEntity().get整理番号().equals(整理番号)) {
                    boolean 要介護状態３段階変更;
                    boolean 住宅住所変更;
                    RString 審査結果 = RString.EMPTY;
                    if (row.getTxt3DankaiReset()) {
                        要介護状態３段階変更 = Boolean.TRUE;
                    } else {
                        要介護状態３段階変更 = Boolean.FALSE;
                    }
                    if (row.getTxtTenkyoReset()) {
                        住宅住所変更 = Boolean.TRUE;
                    } else {
                        住宅住所変更 = Boolean.FALSE;
                    }
                    if (却下する.equals(row.getTxtShinsaResult())) {
                        審査結果 = ShinsaNaiyoKubun.却下する.getコード();
                    } else if (承認する.equals(row.getTxtShinsaResult())) {
                        審査結果 = ShinsaNaiyoKubun.承認する.getコード();
                    }
                    miShinsaSikyuShinsei.getEntity().createBuilderForEdit().set住宅住所変更(row.getTxtTenkyoReset())
                            .set要介護状態３段階変更(row.getTxt3DankaiReset())
                            .set審査結果(row.getTxtShinsaResult())
                            .set支給申請審査区分(ShikyushinseiShinsaKubun.審査済.getコード())
                            .set要介護状態３段階変更(要介護状態３段階変更)
                            .set住宅住所変更(住宅住所変更)
                            .set審査年月日(FlexibleDate.getNowDate())
                            .set審査結果(審査結果);
                }
                SaveIkkatuShinsaDate date = new SaveIkkatuShinsaDate(
                        miShinsaSikyuShinsei.getEntity(),
                        被保険者番号,
                        サービス提供年月,
                        整理番号,
                        証記載保険者番号,
                        決定年月日,
                        ShikibetsuCode.EMPTY,
                        支給決定区分,
                        支払金額);
                parameterList.add(date);
            }
        }
        return parameterList;
    }
}
