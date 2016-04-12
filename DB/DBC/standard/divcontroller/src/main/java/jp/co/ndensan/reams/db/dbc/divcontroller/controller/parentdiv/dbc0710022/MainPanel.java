/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShokanbaraiketteiJoho.ShokanbaraiketteiJohoDiv;
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0710022;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShinsei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShukei;
import jp.co.ndensan.reams.db.dbc.business.core.jutakukaishusikyushinsei.UpdSyokanbaraiketeJoho;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShokanbaraiketteiJoho.ShokanbaraiketteiJoho.ShokanbaraiketteiJohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0710022.DBC0710022TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0710022.MainPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0710022.MainPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.service.core.jutakukaishusikyushinsei.JutakukaishuSikyuShinseiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBCMN52002_住宅改修費支給申請_償還払決定情報登録
 *
 * @reamsid_L DBC-992-110 yangchenbing
 */
public class MainPanel {

    private static final RString 照会 = new RString("照会");
    private static final RString 修正 = new RString("修正");
    private static final RString 登録 = new RString("登録");
    private static final RString 審査 = new RString("審査");
    private static final RString モード_修正 = new RString("修正");
    private static final RString モード_照会 = new RString("照会");
    private static final RString oneRS = new RString("01");

    /**
     * 住宅改修費支給申請_償還払決定情報登録のonLoad
     *
     * @param div 画面DIV
     * @return 住宅改修費支給申請_償還払決定情報登録
     */
    public ResponseData<MainPanelDiv> onLoad(MainPanelDiv div) {
        FlexibleYearMonth サービス年月 = ViewStateHolder.get(ViewStateKeys.サービス年月, FlexibleYearMonth.class);
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        RString 整理番号 = ViewStateHolder.get(ViewStateKeys.整理番号, RString.class);
        div.getJutakuKaishuShinseiHihokenshaPanel().getKaigoAtenaInfo().onLoad(ViewStateHolder.get(ViewStateKeys.識別コード,
                ShikibetsuCode.class));
        div.getJutakuKaishuShinseiHihokenshaPanel().getKaigoShikakuKihon().onLoad(ViewStateHolder.
                get(ViewStateKeys.被保険者番号, HihokenshaNo.class));
        JutakukaishuSikyuShinseiManager fu = JutakukaishuSikyuShinseiManager.createInstance();
        List<ShikibetsuNoKanri> 様式名称情報 = fu.getYoshikiName(サービス年月);
        List<KeyValueDataSource> sources = new ArrayList<>();
        if (!様式名称情報.isEmpty()) {
            for (ShikibetsuNoKanri db : 様式名称情報) {
                sources.add(new KeyValueDataSource(db.get識別番号(), db.get名称()));
            }
        }
        div.getDdlSyomeisyo().setDataSource(sources);
        div.getDdlSyomeisyo().setSelectedKey(new RString("21D1".toString()));
        div.getJutakuKaishuShinseiInfoPanel().getCommHeadPanel().getTxtKyufuritsu().setValue(new Decimal(ViewStateHolder.
                get(ViewStateKeys.給付率, Decimal.class).toString()));
        div.getJutakuKaishuShinseiInfoPanel().getCommHeadPanel().getTxtSeiriNo().setValue(ViewStateHolder.
                get(ViewStateKeys.整理番号, RString.class));
        div.getJutakuKaishuShinseiInfoPanel().getCommHeadPanel().getTxtTeikyoYM().setValue(new RDate(ViewStateHolder.
                get(ViewStateKeys.サービス年月, FlexibleYearMonth.class).toString()));
        if (修正.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            div.getJutakuKaishuShinseiInfoPanel().getShokanbaraiKetteiJyohoPanel().getCcdShokanbaraiketteiJoho().
                    loadInitialize(被保険者番号, サービス年月, 整理番号, oneRS, モード_修正);
        } else {
            div.getJutakuKaishuShinseiInfoPanel().getShokanbaraiKetteiJyohoPanel().getCcdShokanbaraiketteiJoho().
                    loadInitialize(被保険者番号, サービス年月, 整理番号, oneRS, モード_照会);
        }
        ShokanbaraiketteiJohoDiv shokanbaraiketteiJohoDiv = (ShokanbaraiketteiJohoDiv) div.getJutakuKaishuShinseiInfoPanel()
                .getShokanbaraiKetteiJyohoPanel().getCcdShokanbaraiketteiJoho();
        ViewStateHolder.put(ViewStateKeys.支払金額合計, shokanbaraiketteiJohoDiv.getTxtShiharaikingakugoke().getValue());
        ViewStateHolder.put(ViewStateKeys.増減理由, shokanbaraiketteiJohoDiv.getTxtZogenriyu().getValue());
        ViewStateHolder.put(ViewStateKeys.増減単位, shokanbaraiketteiJohoDiv.getTxtZogentani().getValue().intValue());
        ViewStateHolder.put(ViewStateKeys.決定日, shokanbaraiketteiJohoDiv.getTxtKetebi().getValue());
        ViewStateHolder.put(ViewStateKeys.支給区分, shokanbaraiketteiJohoDiv.getRdoShikyukubun().getSelectedKey());
        ViewStateHolder.put(ViewStateKeys.fuSyikyuriyu1, shokanbaraiketteiJohoDiv.getTxtFuSyikyuriyu1().getValue());
        ViewStateHolder.put(ViewStateKeys.fuSyikyuriyu2, shokanbaraiketteiJohoDiv.getTxtFushikyuriyu2().getValue());
        return ResponseData.of(div).respond();
    }

    /**
     * 住宅改修費支給申請_償還払決定情報登録の申請情報
     *
     * @param div 画面DIV
     * @return 住宅改修費支給申請_申請情報登録画面へ遷移
     */
    public ResponseData<MainPanelDiv> onClick_btnShinseiJyoho(MainPanelDiv div) {
        HihokenshaNo 被保険者番号1 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        RString 整理番号1 = ViewStateHolder.get(ViewStateKeys.整理番号, RString.class);
        FlexibleYearMonth サービス年月1 = ViewStateHolder.get(ViewStateKeys.サービス年月, FlexibleYearMonth.class);
        if (修正.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))
                || 登録.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                ViewStateHolder.put(ViewStateKeys.識別コード, ViewStateHolder.get(ViewStateKeys.識別コード, RString.class));
                ViewStateHolder.put(ViewStateKeys.サービス年月, サービス年月1);
                ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号1);
                ViewStateHolder.put(ViewStateKeys.整理番号, 整理番号1);
                ViewStateHolder.put(ViewStateKeys.処理モード, ViewStateHolder.get(ViewStateKeys.処理モード, RString.class));
                return ResponseData.of(div).forwardWithEventName(DBC0710022TransitionEventName.申請情報).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 住宅改修費支給申請_償還払決定情報登録の個人検索へ戻る
     *
     * @param div 画面DIV
     * @return 個人検索画面へ遷移
     */
    public ResponseData<MainPanelDiv> onClick_btnBackToSearch(MainPanelDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).forwardWithEventName(DBC0710022TransitionEventName.検索に戻る).respond();
        } else {
            return ResponseData.of(div).respond();
        }

    }

    /**
     * 住宅改修費支給申請_償還払決定情報登録の申請一覧へ戻る
     *
     * @param div 画面DIV
     * @return 償還払い状況照会画面
     */
    public ResponseData<MainPanelDiv> onClick_btnCancel(MainPanelDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            if (照会.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
                return ResponseData.of(div).forwardWithEventName(DBC0710022TransitionEventName.申請情報).respond();
            } else if (審査.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
                return ResponseData.of(div).forwardWithEventName(DBC0710022TransitionEventName.検索に戻る).respond();
            } else {
                return ResponseData.of(div).forwardWithEventName(DBC0710022TransitionEventName.申請情報).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 判断内容が変わるかどうかを判断する
     *
     * @param div 画面DIV
     * @return MainPanelHandler
     */
    public MainPanelHandler getHandler(MainPanelDiv div) {
        return MainPanelHandler.of(div);
    }

    /**
     * 住宅改修費支給申請_償還払決定情報登録の申請を保存する
     *
     * @param div 画面DIV
     * @return 完了
     */
    public ResponseData<MainPanelDiv> onClick_btnAddShikyuShinsei(MainPanelDiv div) {
        ShokanbaraiketteiJohoDiv shokanbaraiketteiJohoDiv = (ShokanbaraiketteiJohoDiv) div.getJutakuKaishuShinseiInfoPanel()
                .getShokanbaraiKetteiJyohoPanel().getCcdShokanbaraiketteiJoho();
        if (shokanbaraiketteiJohoDiv.getTxtKetebi().getValue() == null) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        if (shokanbaraiketteiJohoDiv.getRdoShikyukubun().getSelectedIndex() == 1 && shokanbaraiketteiJohoDiv.
                getTxtFuSyikyuriyu1().getValue().toString().trim().equals("")
                && shokanbaraiketteiJohoDiv.getTxtFushikyuriyu2().getValue().toString().trim().equals("")) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        boolean flag = getHandler(div).is内容変更状態();
        if (flag) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                        UrQuestionMessages.保存の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                KaigoKanryoMessageDiv kaigokanryomessagediv = (KaigoKanryoMessageDiv) div.
                        getJutakuShikyuShinseiKanryoPanel().getKanryoMessage();
                boolean flags = isflags();
                RString r1 = getr1(flags);
                RString r2 = new RString(ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class).toString());
                RString r3 = div.getJutakuKaishuShinseiHihokenshaPanel().getKaigoAtenaInfo().get氏名漢字();
                kaigokanryomessagediv.setMessage(r1, r2, r3, flags);
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 住宅改修費支給申請_償還払決定情報登録の申請を保存する
     *
     * @param div 画面DIV
     * @return 住宅改修費支給申請_償還払決定情報登録
     */
    public ResponseData<MainPanelDiv> onClick_btnComplete(MainPanelDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0710022TransitionEventName.一覧に戻る).respond();
    }

    /**
     * isflags
     *
     * @return flag
     */
    private boolean isflags() {
        RString 整理番号 = ViewStateHolder.get(ViewStateKeys.整理番号, RString.class);
        FlexibleYearMonth サービス年月 = ViewStateHolder.get(ViewStateKeys.サービス年月, FlexibleYearMonth.class);
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        JigyoshaNo 事業者番号 = ViewStateHolder.get(ViewStateKeys.事業者番号, JigyoshaNo.class);
        RString 様式番号 = ViewStateHolder.get(ViewStateKeys.様式番号, RString.class);
        RString 明細番号 = ViewStateHolder.get(ViewStateKeys.明細番号, RString.class);
        RString 連番 = ViewStateHolder.get(ViewStateKeys.連番, RString.class);
        RString 証明書 = ViewStateHolder.get(ViewStateKeys.証明書, RString.class);
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        UpdSyokanbaraiketeJoho updsyokanbaraiketejohos = UpdSyokanbaraiketeJoho.
                createSelectByKeyParam(被保険者番号, サービス年月, 整理番号, 証明書, 識別コード,
                        new HokenshaNo("6".toString()), new FlexibleDate("199003".toString()),
                        new RString("3".toString()), new FlexibleDate("199004".toString()), new RString("32".toString()),
                        new Decimal("3".toString()), new Decimal("3".toString()), new Decimal("3".toString()));
        ShokanShinsei shokanshinseis = new ShokanShinsei(被保険者番号, サービス年月, 整理番号);
        ShokanShukei shokanshukeis = new ShokanShukei(被保険者番号, サービス年月, 整理番号,
                事業者番号, 様式番号, 明細番号, 連番);
        JutakukaishuSikyuShinseiManager j = JutakukaishuSikyuShinseiManager.createInstance();
        return j.updSyokanbaraiketeJoho(updsyokanbaraiketejohos, shokanshinseis, shokanshukeis);
    }

    /**
     * getr1
     *
     * @param flags flags
     * @return RString
     */
    private RString getr1(boolean flags) {
        RString r1;
        if (flags) {
            r1 = new RString(UrInformationMessages.保存終了.toString());
        } else {
            r1 = new RString(UrErrorMessages.異常終了.toString());
        }
        return r1;
    }
}
