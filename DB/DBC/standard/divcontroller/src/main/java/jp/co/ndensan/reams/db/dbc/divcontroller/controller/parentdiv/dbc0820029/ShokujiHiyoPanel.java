/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0820029;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanMeisai;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShokujiHiyo;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820029.ShokujiHiyoPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820029.dgdShokuji_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0820029.ShokujiHiyoPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.syokanbaraihishikyushinseikette.SikibetuNokennsakuki;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.syokanbaraihishikyushinseikette.SyokanbaraihishikyushinseiketteParameter;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 償還払い費支給申請決定_サービス提供証明書(食事費用）の画面クラスです。
 */
public class ShokujiHiyoPanel {

    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");
    private static final RString 申請を保存する = new RString("Element1");
    private static final FlexibleYearMonth 平成１５年３月 = new FlexibleYearMonth("200303");
    private static final FlexibleYearMonth 平成17年９月 = new FlexibleYearMonth("200509");

    /**
     * onLoad
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onLoad(ShokujiHiyoPanelDiv div) {

        SyokanbaraihishikyushinseiketteParameter par = new SyokanbaraihishikyushinseiketteParameter(
                new HihokenshaNo("000000004"),
                new FlexibleYearMonth(new RString("200401")),
                new RString("0000000003"),
                new JigyoshaNo("0000000003"),
                new RString("0003"),
                new RString("0003"),
                new RString("10"));
        ViewStateHolder.put(ViewStateKeys.償還払費申請明細検索キー, par);
        SyokanbaraihishikyushinseiketteParameter parameter = ViewStateHolder.get(ViewStateKeys.償還払費申請明細検索キー,
                SyokanbaraihishikyushinseiketteParameter.class);
        FlexibleYearMonth サービス提供年月 = parameter.getServiceTeikyoYM();
        HihokenshaNo 被保険者番号 = parameter.getHiHokenshaNo();
        RString 整理番号 = parameter.getSeiriNp();
        RString 様式番号 = parameter.getYoshikiNo();
        RString 明細番号 = parameter.getMeisaiNo();
        JigyoshaNo 事業者番号 = parameter.getJigyoshaNo();
        ViewStateHolder.put(ViewStateKeys.サービス年月, サービス提供年月);
        ViewStateHolder.put(ViewStateKeys.様式番号, 様式番号);
        ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号);
        ViewStateHolder.put(ViewStateKeys.整理番号, 整理番号);
        SikibetuNokennsakuki key = new SikibetuNokennsakuki(new RString("0003"),
                new FlexibleYearMonth(new RString("201501")));
        ViewStateHolder.put(ViewStateKeys.識別番号検索キー, key);

        RString 申請日 = new RString("20151124");
        // TODO「介護宛名情報」共有子Divの初期化
        ViewStateHolder.put(ViewStateKeys.識別コード, new ShikibetsuCode("000000000000010"));
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        div.getPanelCcd().getCcdKaigoAtenaInfo().onLoad(識別コード);
        // TODO 「介護資格系基本情報」共有子Div の初期化
        if (!被保険者番号.isEmpty()) {
            div.getPanelCcd().getCcdKaigoShikakuKihon().onLoad(被保険者番号);
        } else {
            div.getPanelCcd().getCcdKaigoShikakuKihon().setVisible(false);
        }
        getHandler(div).setヘッダーエリア(サービス提供年月, 申請日, 事業者番号, 明細番号, 様式番号);

        if (サービス提供年月.isBeforeOrEquals(平成１５年３月)) {
            div.getPanelShokuji().getPanelShoikujiList().setDisplayNone(true);
            div.getPanelShokuji().getPanelDetailGokei().setDisplayNone(true);
            div.getPanelShokuji().getPanelDetail1().setVisible(true);
            div.getPanelShokuji().getPanelDetail2().setVisible(false);

            List<ShokanShokujiHiyo> shokanShokujiHiyoList = ShokanbaraiJyokyoShokai.createInstance()
                    .getSeikyuShokujiHiyoTanjyunSearch(被保険者番号,
                            サービス提供年月,
                            整理番号,
                            事業者番号,
                            様式番号,
                            明細番号,
                            null);
            if (!shokanShokujiHiyoList.isEmpty()) {
                getHandler(div).set食事費用登録エリア１(shokanShokujiHiyoList.get(0));
            }
            ViewStateHolder.put(ViewStateKeys.償還払請求食事費用データ, (Serializable) shokanShokujiHiyoList);
        }

        if (平成１５年３月.isBefore(サービス提供年月)
                && サービス提供年月.isBeforeOrEquals(平成17年９月)) {

            getデータ(div, 被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        }

        if (平成17年９月.isBefore(サービス提供年月)) {
            div.getPanelShokuji().getPanelShoikujiList().setDisplayNone(true);
            div.getPanelShokuji().getPanelDetailGokei().setVisible(true);
            div.getPanelShokuji().getPanelDetailGokei().getTxtTeikyohiGokei().setReadOnly(false);
            div.getPanelShokuji().getPanelDetail1().setVisible(false);
            div.getPanelShokuji().getPanelDetail2().setVisible(false);
            List<ShokanShokujiHiyo> shokanShokujiHiyoList = ShokanbaraiJyokyoShokai.createInstance()
                    .getSeikyuShokujiHiyoTanjyunSearch(被保険者番号,
                            サービス提供年月,
                            整理番号,
                            事業者番号,
                            様式番号,
                            明細番号,
                            null);
            if (shokanShokujiHiyoList == null || shokanShokujiHiyoList.isEmpty()) {
                throw new ApplicationException(UrErrorMessages.データが存在しない.getMessage());
            }

            getHandler(div).set食事費用合計設定(shokanShokujiHiyoList.get(0));
            ViewStateHolder.put(ViewStateKeys.償還払請求食事費用データ, (Serializable) shokanShokujiHiyoList);
        }

        // 標準負担額（日額）を取得する。
        Decimal 標準負担額_日額 = SyokanbaraihiShikyuShinseiKetteManager.createInstance()
                .getHyojyunfutangaku(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        if (標準負担額_日額 == null) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        ViewStateHolder.put(ViewStateKeys.償還払請求食事費用データ1, 標準負担額_日額);

        // 識別番号管理情報取得
        SikibetuNokennsakuki kennsakuki = ViewStateHolder.get(ViewStateKeys.識別番号検索キー, SikibetuNokennsakuki.class);
        ShikibetsuNoKanri shikibetsuNoKanri = SyokanbaraihiShikyuShinseiKetteManager.createInstance()
                .getShikibetsuNoKanri(kennsakuki.getServiceTeikyoYM(), kennsakuki.getSikibetuNo());
        if (shikibetsuNoKanri == null) {
            throw new ApplicationException(UrErrorMessages.データが存在しない.getMessage());
        } else {
            getHandler(div).getボタンを制御(shikibetsuNoKanri);
        }
        return createResponse(div);
    }

    /**
     * getデータ
     *
     * @param div ShokujiHiyoPanelDiv
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @param 事業者番号 JigyoshaNo
     * @param 様式番号 RString
     * @param 明細番号 RString
     */
    public void getデータ(ShokujiHiyoPanelDiv div,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号) {
        div.getPanelShokuji().getPanelShoikujiList().setVisible(true);
        div.getPanelShokuji().getPanelDetailGokei().setVisible(true);
        div.getPanelShokuji().getPanelDetail1().setDisplayNone(true);
        div.getPanelShokuji().getPanelDetail2().setVisible(false);

        // 明細一覧のデータを取得する。
        List<ShokanMeisai> shokanMeisaiList = ShokanbaraiJyokyoShokai.createInstance()
                .getShokujiHiyoDataList(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号, null);
        if (shokanMeisaiList != null) {
            // 明細情報がある場合、合計情報の取得する
            List<ShokanShokujiHiyo> shokanShokujiHiyoList = ShokanbaraiJyokyoShokai.createInstance()
                    .getSeikyuShokujiHiyoTanjyunSearch(被保険者番号,
                            サービス提供年月,
                            整理番号,
                            事業者番号,
                            様式番号,
                            明細番号,
                            null);
            if (shokanShokujiHiyoList == null || shokanShokujiHiyoList.isEmpty()) {
                throw new ApplicationException(UrErrorMessages.データが存在しない.getMessage());
            }
            getHandler(div).set食事費用一覧グリッド(shokanMeisaiList, shokanShokujiHiyoList.get(0));
            ViewStateHolder.put(ViewStateKeys.償還払請求食事費用, (Serializable) shokanMeisaiList);
            ViewStateHolder.put(ViewStateKeys.償還払請求食事費用データ, (Serializable) shokanShokujiHiyoList);
        }
    }

    /**
     * 取消処理
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnFree(ShokujiHiyoPanelDiv div) {
//        if (削除.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
//            // TODO 償還払支給申請_サービス提供証明書画面へ遷移する。
//            return ResponseData.of(div).forwardWithEventName(DBC0820029TransitionEventName.サービス計画費)
//                    .parameter(new RString("サービス計画費"));
//        }
//        FlexibleYearMonth サービス年月 = new FlexibleYearMonth(new RString("200405"));
//        boolean flag = getHandler(div).get内容変更状態(サービス年月);
//        if (flag) {
//            if (!ResponseHolder.isReRequest()) {
//                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
//                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
//                return ResponseData.of(div).addMessage(message).respond();
//            }
//            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
//                    .equals(ResponseHolder.getMessageCode())
//                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
//                return ResponseData.of(div).forwardWithEventName(DBC0820029TransitionEventName.サービス計画費)
//                        .parameter(new RString("サービス計画費"));
//            } else {
//                ResponseData.of(div).respond();
//            }
//        } else {
//            // TODO 償還払支給申請_サービス提供証明書画面へ遷移する。
//            return ResponseData.of(div).forwardWithEventName(DBC0820023TransitionEventName.サービス計画費)
//                    .parameter(new RString("サービス計画費"));
//        }
        return createResponse(div);
    }

    /**
     * 保存処理
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnSave(ShokujiHiyoPanelDiv div) {
        FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth(new RString("200401"));
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            if (!ResponseHolder.isReRequest()) {
                getHandler(div).保存処理();
                return ResponseData.of(div).addMessage(UrInformationMessages.正常終了
                        .getMessage().replace(削除.toString())).respond();
            }
            if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(申請を保存する, true);
                return createResponse(div);
            }
        } else {
            if (getHandler(div).get内容変更状態(サービス提供年月) && !ResponseHolder.isReRequest()) {
                getHandler(div).保存処理();
                return ResponseData.of(div).addMessage(UrInformationMessages.正常終了
                        .getMessage().replace(登録.toString())).respond();
            } else if (getHandler(div).get内容変更状態(サービス提供年月)
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                return createResponse(div);
            } else if (!getHandler(div).get内容変更状態(サービス提供年月) && !ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(
                        DbzInformationMessages.内容変更なしで保存不可.getMessage()).respond();
            } else {
                return createResponse(div);
            }

        }
        return ResponseData.of(div).addMessage(UrErrorMessages.異常終了.getMessage()).respond();
    }

    /**
     * 「追加する」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnAdd(ShokujiHiyoPanelDiv div) {
        div.getPanelShokuji().getPanelDetail2().setVisible(true);
        ViewStateHolder.put(ViewStateKeys.状態, 登録);
        getHandler(div).clear食事費用登録エリア2();
        return createResponse(div);
    }

    /**
     * 「グリッドの削除」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_ddgDelete(ShokujiHiyoPanelDiv div) {
        div.getPanelShokuji().getPanelDetail2().setVisible(true);
        div.getPanelShokuji().setRowId(new RString(String.valueOf(div.getPanelShokuji().getPanelShoikujiList()
                .getDgdShokuji().getClickedRowId())));
        dgdShokuji_Row row = div.getPanelShokuji().getPanelShoikujiList().getDgdShokuji().getClickedItem();
        getHandler(div).set食事費用登録(row);
        ViewStateHolder.put(ViewStateKeys.状態, 削除);
        return createResponse(div);
    }

    /**
     * 「グリッドの修正」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_ddgModify(ShokujiHiyoPanelDiv div) {
        div.getPanelShokuji().getPanelDetail2().setVisible(true);
        div.getPanelShokuji().setRowId(new RString(String.valueOf(div.getPanelShokuji().getPanelShoikujiList()
                .getDgdShokuji().getClickedRowId())));
        dgdShokuji_Row row = div.getPanelShokuji().getPanelShoikujiList().getDgdShokuji().getClickedItem();
        getHandler(div).set食事費用登録(row);
        ViewStateHolder.put(ViewStateKeys.状態, 修正);
        return createResponse(div);
    }

    /**
     * 食事費用合計設定エリアの「集計する」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnShukei(ShokujiHiyoPanelDiv div) {
        getHandler(div).集計する();
        return createResponse(div);
    }

    /**
     * 食事費用登録エリア１の「計算する」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnCal(ShokujiHiyoPanelDiv div) {
        getHandler(div).計算する();
        return createResponse(div);
    }

    /**
     * 食事費用登録エリア２の「計算する」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnCal2(ShokujiHiyoPanelDiv div) {
        getHandler(div).計算する2();
        return createResponse(div);
    }

    /**
     * 食事費用登録エリア１「クリアする」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnClear(ShokujiHiyoPanelDiv div) {
        getHandler(div).clear食事費用登録エリア１();
        return createResponse(div);
    }

    /**
     * 食事費用登録エリア１「取消する」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnCancel(ShokujiHiyoPanelDiv div) {
        getHandler(div).clear食事費用登録エリア１();
        div.getPanelShokuji().getPanelDetail1().setVisible(false);
        return createResponse(div);
    }

    /**
     * 食事費用登録エリア１「確定する」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnConfirm(ShokujiHiyoPanelDiv div) {
        List<dgdShokuji_Row> list = div.getPanelShokuji().getPanelShoikujiList().getDgdShokuji().getDataSource();
        if (登録.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            dgdShokuji_Row row = new dgdShokuji_Row();
            getHandler(div).confirm(row);
            list.add(row);
        } else {
            dgdShokuji_Row row = getHandler(div).selectRow();
            getHandler(div).confirm(row);
            list.set(Integer.parseInt(div.getPanelShokuji().getRowId().toString()), row);
        }
        div.getPanelShokuji().getPanelShoikujiList().getDgdShokuji().setDataSource(list);
        return createResponse(div);
    }

    /**
     * 食事費用登録エリア２「クリアする」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnClear1(ShokujiHiyoPanelDiv div) {
        getHandler(div).clear食事費用登録エリア2();
        return createResponse(div);
    }

    /**
     * 食事費用登録エリア２「取消する」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnCacel2(ShokujiHiyoPanelDiv div) {
        getHandler(div).clear食事費用登録エリア2();
        div.getPanelShokuji().getPanelDetail2().setVisible(false);
        return createResponse(div);
    }

    /**
     * 食事費用登録エリア２「確定する」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnConfirm2(ShokujiHiyoPanelDiv div) {
        if (登録.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            dgdShokuji_Row row = new dgdShokuji_Row();
            getHandler(div).confirm(row);
        } else {
            dgdShokuji_Row row = getHandler(div).selectRow();
            getHandler(div).confirm(row);
        }
        getHandler(div).clear食事費用登録エリア2();
        div.getPanelShokuji().getPanelDetail2().setVisible(false);
        return createResponse(div);
    }

    /**
     * 「基本情報」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnKihonInfo(ShokujiHiyoPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    /**
     * 「給付費明細」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnKyufuMeisai(ShokujiHiyoPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    /**
     * 「特定診療費」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnTokuteiShinryouhii(ShokujiHiyoPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    /**
     * 「サービス計画費」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnServiceKeikakuhi(ShokujiHiyoPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    /**
     * 「特定入所者費用」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnTokuteiNyushosya(ShokujiHiyoPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    /**
     * 「合計情報」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnGoukeiInfo(ShokujiHiyoPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    /**
     * 「給付費明細(住所地特例)」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnKyufuhiMeisaiJyuchi(
            ShokujiHiyoPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).respond();
    }

    /**
     * 「特定診療費」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnTokuteiShinryohi(ShokujiHiyoPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).respond();
    }

    /**
     * 「給付費明細（住特）」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnKyufuhiMeisaiJutoku(ShokujiHiyoPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    /**
     * 「緊急時・所定疾患」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnKinkyujiShoteiShikan(ShokujiHiyoPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    /**
     * 「緊急時施設療養費」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnKinkyushisetuRyoyouhi(ShokujiHiyoPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    /**
     * 「食事費用」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnShokujihiyo(ShokujiHiyoPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    /**
     * 「請求額集計」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnSeikyugakuShukei(ShokujiHiyoPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    /**
     * 「社福軽減額」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnShafukukeigenGaku(ShokujiHiyoPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    private ShokujiHiyoPanelHandler getHandler(ShokujiHiyoPanelDiv div) {
        return new ShokujiHiyoPanelHandler(div);
    }

    private ResponseData<ShokujiHiyoPanelDiv> createResponse(ShokujiHiyoPanelDiv div) {
        return ResponseData.of(div).respond();
    }
}
