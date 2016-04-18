/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0600031;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanFukushiYoguHanbaihi;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanHanteiKekka;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShukei;
import jp.co.ndensan.reams.db.dbc.business.core.fukushiyogukonyuhishikyushisei.FukushiYoguKonyuhiShikyuShiseiKetteDivEntity;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShokanbaraiketteiJoho.ShokanbaraiketteiJoho.ShokanbaraiketteiJohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShokanbaraiketteiJoho.ShokanbaraiketteiJoho.dgSyokanbaraikete_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0600031.DBC0600031StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0600031.DBC0600031TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0600031.PnlKeteiJohoMsgDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0600031.PnlKeteiJohoMsgHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.service.core.fukushiyogukonyuhishikyushisei.FukushiyoguKonyuhiShikyuShinsei;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
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
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBCMN51001_福祉用具購入費支給申請_決定情報登録
 *
 * @reamsid_L DBC-1020-010 yangchenbing
 */
public class PnlKeteiJohoMsg {

    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");
    private static final RString 修正 = new RString("修正");
    private static final RString 参照 = new RString("参照");
    private static final RString モード_修正 = new RString("修正");
    private static final RString モード_照会 = new RString("照会");
    private static final RString モード_削除 = new RString("削除");
    private static final RString モード_登録 = new RString("登録");
    private static final RString モード_参照 = new RString("参照");
    private static final RString 保存 = new RString("Element10");
    private static final RString 業務区分 = new RString("02");
    private static final RString 連番 = new RString("1");

    /**
     * onLoad事件
     *
     * @param div 画面DIV
     * @return 福祉用具購入費支給申請の決定情報登録
     */
    public ResponseData<PnlKeteiJohoMsgDiv> onLoad(PnlKeteiJohoMsgDiv div) {
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        div.getKaigoCommonPanel().getCcdAtenaInfo().onLoad(識別コード);
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        FlexibleYearMonth サービス年月 = ViewStateHolder.get(ViewStateKeys.サービス年月, FlexibleYearMonth.class);
        RString 整理番号 = ViewStateHolder.get(ViewStateKeys.整理番号, RString.class);
        Decimal 給付率 = ViewStateHolder.get(ViewStateKeys.給付率, Decimal.class);
        JigyoshaNo 事業者番号 = ViewStateHolder.get(ViewStateKeys.事業者番号, JigyoshaNo.class);
        RString 証明書 = ViewStateHolder.get(ViewStateKeys.証明書, RString.class);
        if (モード_参照.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            CommonButtonHolder.setVisibleByCommonButtonFieldName(保存, false);
        }
        div.getKaigoCommonPanel().getCcdShikakuKihon().onLoad(被保険者番号);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtTeikyoYM().setValue(new RDate(サービス年月.toString()));
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtKyufuritsu().setValue(給付率);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtSyomeisyo().setValue(証明書);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtSeiriNo().setValue(整理番号);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtJigyoshaNo().setValue(事業者番号.value());
        if (モード_登録.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class)) || モード_修正.equals(
                ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            div.getCcdKetteiList().loadInitialize(被保険者番号, サービス年月, 整理番号, 業務区分, モード_修正);
        } else {
            div.getCcdKetteiList().loadInitialize(被保険者番号, サービス年月, 整理番号, 業務区分, モード_照会);
        }
        ViewStateHolder.put(ViewStateKeys.支払金額合計, div.getCcdKetteiList().getShokanbaraiketteiJohoDiv()
                .getTxtShiharaikingakugoke().getValue());
        ViewStateHolder.put(ViewStateKeys.増減理由, div.getCcdKetteiList().getShokanbaraiketteiJohoDiv()
                .getTxtZogenriyu().getValue());
        ViewStateHolder.put(ViewStateKeys.増減単位, div.getCcdKetteiList().getShokanbaraiketteiJohoDiv()
                .getTxtZogentani().getValue().intValue());
        ViewStateHolder.put(ViewStateKeys.決定日, div.getCcdKetteiList().getShokanbaraiketteiJohoDiv()
                .getTxtKetebi().getValue());
        ViewStateHolder.put(ViewStateKeys.支給区分, div.getCcdKetteiList().getShokanbaraiketteiJohoDiv().
                getRdoShikyukubun().getSelectedKey());
        ViewStateHolder.put(ViewStateKeys.fuSyikyuriyu1, div.getCcdKetteiList().getShokanbaraiketteiJohoDiv()
                .getTxtFuSyikyuriyu1().getValue());
        ViewStateHolder.put(ViewStateKeys.fuSyikyuriyu2, div.getCcdKetteiList().getShokanbaraiketteiJohoDiv()
                .getTxtFushikyuriyu2().getValue());
        return ResponseData.of(div).respond();
    }

    /**
     * 福祉用具購入費支給申請の取消する
     *
     * @param div 画面DIV
     * @return 福祉用具購入費支給申請一覧画面へ遷移
     */
    public ResponseData<PnlKeteiJohoMsgDiv> onClick_btnFree(PnlKeteiJohoMsgDiv div) {
        if (モード_削除.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            return ResponseData.of(div).forwardWithEventName(DBC0600031TransitionEventName.一覧に戻る).respond();
        }
        boolean flag = getHandler(div).is内容変更状態();
        if (flag && (モード_登録.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))
                || モード_修正.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class)))) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                return ResponseData.of(div).forwardWithEventName(DBC0600031TransitionEventName.一覧に戻る).respond();
            }
        }
        if ((!flag && (モード_登録.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))))
                || (モード_修正.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class)))) {
            return ResponseData.of(div).forwardWithEventName(DBC0600031TransitionEventName.一覧に戻る).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 福祉用具購入費支給申請の決定情報登録保存する」
     *
     * @param div 画面DIV
     * @return 福祉用具購入費支給申請の決定情報登録
     */
    public ResponseData<PnlKeteiJohoMsgDiv> onClick_btnUpdate(PnlKeteiJohoMsgDiv div) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        FlexibleYearMonth サービス年月 = ViewStateHolder.get(ViewStateKeys.サービス年月, FlexibleYearMonth.class);
        RString 整理番号 = ViewStateHolder.get(ViewStateKeys.整理番号, RString.class);
        JigyoshaNo 事業者番号 = ViewStateHolder.get(ViewStateKeys.事業者番号, JigyoshaNo.class);
        RString 様式番号 = ViewStateHolder.get(ViewStateKeys.様式番号, RString.class);
        RString 明細番号 = ViewStateHolder.get(ViewStateKeys.明細番号, RString.class);
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.削除の確認.getMessage()).respond();
            }
            if (new RString(UrQuestionMessages.削除の確認.getMessage().getCode()).equals(ResponseHolder.
                    getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                FukushiyoguKonyuhiShikyuShinsei fukuShinsei = new FukushiyoguKonyuhiShikyuShinsei();
                fukuShinsei.delete(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
                div.getCcdMessage().setMessage(new RString(UrInformationMessages.保存終了.getMessage().evaluate()),
                        RString.EMPTY, RString.EMPTY, true);
                return ResponseData.of(div).setState(DBC0600031StateName.successSaved);
            }
        }
        if (登録.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))
                || モード_修正.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            return 登録修正Update(div);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 判断内容が変わるかどうかを判断する
     *
     * @param div 画面DIV
     * @return PnlKeteiJohoMsgHandler
     */
    private PnlKeteiJohoMsgHandler getHandler(PnlKeteiJohoMsgDiv div) {
        return PnlKeteiJohoMsgHandler.of(div);
    }

    /**
     * 登録修正Update
     *
     * @param div 画面DIV
     * @return 福祉用具購入費支給申請_明細登録へ遷移す
     */
    private ResponseData<PnlKeteiJohoMsgDiv> 登録修正Update(PnlKeteiJohoMsgDiv div) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        FlexibleYearMonth サービス年月 = ViewStateHolder.get(ViewStateKeys.サービス年月, FlexibleYearMonth.class);
        RString 整理番号 = ViewStateHolder.get(ViewStateKeys.整理番号, RString.class);
        JigyoshaNo 事業者番号 = ViewStateHolder.get(ViewStateKeys.事業者番号, JigyoshaNo.class);
        RString 様式番号 = ViewStateHolder.get(ViewStateKeys.様式番号, RString.class);
        RString 明細番号 = ViewStateHolder.get(ViewStateKeys.明細番号, RString.class);
        RString 証明書 = ViewStateHolder.get(ViewStateKeys.証明書, RString.class);
        ShokanbaraiketteiJohoDiv adiv = (ShokanbaraiketteiJohoDiv) div.getCcdKetteiList();
        if (adiv.getTxtKetebi().getValue() == null) {
            //throw new ApplicationException(UrErrorMessages.必須, 決定日.toString());
        }
        boolean flag = getHandler(div).is内容変更状態();
        if (!flag) {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(DbzInformationMessages.内容変更なしで保存不可.getMessage()).respond();
            }
        } else {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
            }
            if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {

                // 3053
                ShokanShukei shokanshukei = new ShokanShukei(被保険者番号, new FlexibleYearMonth(サービス年月.toString()),
                        整理番号, new JigyoshaNo(事業者番号.toString()), 様式番号, 明細番号, 連番)
                        .createBuilderForEdit()
                        .set審査年月(new FlexibleYearMonth(div.getCcdKetteiList().getShokanbaraiketteiJohoDiv()
                                        .getTxtKetebi().getValue().getYearMonth().toString()))
                        .set支給区分コード(div.getCcdKetteiList().getShokanbaraiketteiJohoDiv().
                                getRdoShikyukubun().getSelectedKey())
                        .set支払金額(new Integer(div.getCcdKetteiList().getShokanbaraiketteiJohoDiv()
                                        .getTxtShiharaikingakugoke().getValue().toString()))
                        .set増減点(div.getCcdKetteiList().getShokanbaraiketteiJohoDiv()
                                .getTxtZogentani().getValue().intValue())
                        .set請求額差額金額(new Integer(div.getCcdKetteiList().getShokanbaraiketteiJohoDiv().
                                        getTxtSagakuGoke().getValue().toString()))
                        .set増減理由等(div.getCcdKetteiList().getShokanbaraiketteiJohoDiv()
                                .getTxtZogenriyu().getValue())
                        .set不支給理由等(new RString(div.getCcdKetteiList().getShokanbaraiketteiJohoDiv().getTxtFuSyikyuriyu1().
                                        getValue().toString() + div.getCcdKetteiList().getShokanbaraiketteiJohoDiv()
                                        .getTxtFushikyuriyu2().getValue().toString()))
                        .build();
                System.out.println("増減点====" + div.getCcdKetteiList().getShokanbaraiketteiJohoDiv()
                        .getTxtZogentani().getValue().intValue() + "=====増減理由====" + div.getCcdKetteiList().getShokanbaraiketteiJohoDiv()
                        .getTxtZogenriyu().getValue() + "===不支給理由等===" + new RString(div.getCcdKetteiList().getShokanbaraiketteiJohoDiv().getTxtFuSyikyuriyu1().
                                getValue().toString() + div.getCcdKetteiList().getShokanbaraiketteiJohoDiv()
                                .getTxtFushikyuriyu2().getValue().toString()));

                // 3036
                ShokanHanteiKekka shokanhanteikekka = new ShokanHanteiKekka(被保険者番号, サービス年月, 整理番号)
                        .createBuilderForEdit()
                        //TODO画面の保険者の選択値
                        .set証記載保険者番号(new ShoKisaiHokenshaNo("888888"))
                        .set決定年月日(new FlexibleDate(div.getCcdKetteiList().getShokanbaraiketteiJohoDiv()
                                        .getTxtKetebi().getValue().toString()))
                        .set支給_不支給決定区分(div.getCcdKetteiList().getShokanbaraiketteiJohoDiv().
                                getRdoShikyukubun().getSelectedKey())
                        .set支払金額(div.getCcdKetteiList().getShokanbaraiketteiJohoDiv()
                                .getTxtShiharaikingakugoke().getValue())
                        .build();

                FukushiYoguKonyuhiShikyuShiseiKetteDivEntity entity = FukushiYoguKonyuhiShikyuShiseiKetteDivEntity.createEntity(
                        ViewStateHolder.get(ViewStateKeys.処理モード, RString.class), shokanhanteikekka, shokanshukei);
                entity.set被保険者番号(被保険者番号);
                entity.set事業者番号(事業者番号);
                entity.set提供_購入_年月(サービス年月);
                entity.set整理番号(整理番号);
                entity.set証明書コード(証明書);
                entity.set明細番号(明細番号);
                entity.set識別コード(ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class));
                entity.set画面モード(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class));

                entity.set決定日(new FlexibleDate(div.getCcdKetteiList().getShokanbaraiketteiJohoDiv().
                        getTxtKetebi().getValue().toString()));
                entity.set差額金額登録フラグ(div.getCcdKetteiList().getShokanbaraiketteiJohoDiv().getDgSyokanbaraikete()
                        .getGridSetting().getColumn("sagakuKingaku").getCellDetails().getDisabled());

                // 3048
                List<ShokanFukushiYoguHanbaihi> 福祉用具販売費リスト = new ArrayList<>();
                List<dgSyokanbaraikete_Row> list = div.getCcdKetteiList().getShokanbaraiketteiJohoDiv().
                        getDgSyokanbaraikete().getDataSource();
                for (dgSyokanbaraikete_Row row : list) {
                    ShokanFukushiYoguHanbaihi shokanFukushiYoguHanbaihi = new ShokanFukushiYoguHanbaihi(
                            被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, 連番)
                            .createBuilderForEdit().set差額金額(row.getSagakuKingaku().getValue().intValue()).build();
                    福祉用具販売費リスト.add(shokanFukushiYoguHanbaihi);
                }
                entity.add福祉用具販売費リスト(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class), 福祉用具販売費リスト);
                FukushiyoguKonyuhiShikyuShinsei.createInstance().updKetteJoho(entity);

                div.getCcdMessage().setMessage(new RString(UrInformationMessages.保存終了.getMessage().evaluate()),
                        RString.EMPTY, RString.EMPTY, true);
                div.getPnlButton().setDisplayNone(true);
                div.getCcdKetteiList().setDisplayNone(true);
                return ResponseData.of(div).setState(DBC0600031StateName.successSaved);
            }
        }
        return ResponseData.of(div).respond();
    }
}
