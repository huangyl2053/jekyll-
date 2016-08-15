/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC8120012;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.jigyobunshikyugakukeisankkarenrakuhyopanel.JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelBatchParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jigyobunshikyugakukeisankkarenrakuhyopanel.JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelListParameter;
import static jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8120012.DBC8120012TransitionEventName.対象者検索に戻る;
import static jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8120012.DBC8120012TransitionEventName.検索結果一覧に戻る;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8120012.JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC8120012.JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 事業高額合算・事業分支給額計算結果連絡票（単）のDivControllerです。
 *
 * @reamsid_L DBC-4840-010 lihang
 */
public class JigyobunShikyugakuKeisanKekkaRenrakuhyoPanel {

    /**
     * 画面を初期化します
     *
     * @param div JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv
     *
     * @return ResponseData
     */
    public ResponseData<JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv> onLoad(
            JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv div) {
        TaishoshaKey 引き継ぎ情報 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = 引き継ぎ情報.get被保険者番号();
        ShikibetsuCode 識別コード = 引き継ぎ情報.get識別コード();
        JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelListParameter parameter
                = createHandler(div).setJigyobunShikyugakuKeisanKekkaRenrakuhyoPanelListParameter(被保険者番号, null, null, null);
        createHandler(div).initialize(被保険者番号, 識別コード, parameter);
        return ResponseData.of(div).respond();
    }

    /**
     * 対象年度DDLをチェンジします
     *
     * @param div JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv
     *
     * @return ResponseData
     */
    public ResponseData<JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv> onChange_ddlTaishoNendo(
            JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv div) {
        TaishoshaKey 引き継ぎ情報 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = 引き継ぎ情報.get被保険者番号();
        createHandler(div).onChange対象年度DDL(被保険者番号);
        return ResponseData.of(div).respond();
    }

    /**
     * 連絡票整理番号DDLをチェンジします
     *
     * @param div JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv
     *
     * @return ResponseData
     */
    public ResponseData<JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv> onChange_ddlShikyuShinseishoSeiriNo(
            JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv div) {
        TaishoshaKey 引き継ぎ情報 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = 引き継ぎ情報.get被保険者番号();
        createHandler(div).onChange連絡票整理番号DDL(被保険者番号);
        return ResponseData.of(div).respond();
    }

    /**
     * 証記載保険者番号DDLをチェンジします
     *
     * @param div JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv
     *
     * @return ResponseData
     */
    public ResponseData<JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv> onChange_ddlShoKisaiHokenshaNo(
            JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv div) {
        TaishoshaKey 引き継ぎ情報 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = 引き継ぎ情報.get被保険者番号();
        createHandler(div).onChange証記載保険者番号DDL(被保険者番号);
        return ResponseData.of(div).respond();
    }

    /**
     * バリデーションをチェックします
     *
     * @param div JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv
     *
     * @return ResponseData
     */
    public ResponseData<JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv> onClick_check(
            JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv div) {
        if (!div.getSakuseiPanel().getTxtZenkaiSakuseiYMD().getValue().toString().equals("")) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.確認_汎用.getMessage()).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * バッチ処理をします
     *
     * @param div JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv
     *
     * @return ResponseData
     */
    public ResponseData<JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelBatchParameter> onClick_btnPrint(
            JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv div) {
        if (ResponseHolder.getMessageCode().equals(new RString(UrQuestionMessages.確認_汎用.getMessage().getCode()))
                && MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {
            return ResponseData.of(createHandler(div).onClick発行する(ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class).get被保険者番号())).respond();
        }
        return ResponseData.of(new JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelBatchParameter()).respond();
    }

    /**
     * 「再検索」ボタンをClickします
     *
     * @param div JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv
     *
     * @return ResponseData
     */
    public ResponseData<JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv> onClick_btnReSearch(
            JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv div) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class).get被保険者番号();
        if (!createHandler(div).get前排他(被保険者番号.getColumnValue())) {
            createHandler(div).前排他キーの解除(被保険者番号.getColumnValue());
        }
        return ResponseData.of(div).forwardWithEventName(対象者検索に戻る).respond();
    }

    /**
     * 「検索結果一覧へ」ボタンをClickします
     *
     * @param div JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv
     *
     * @return ResponseData
     */
    public ResponseData<JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv> onClick_btnSerchResult(
            JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv div) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class).get被保険者番号();
        if (!createHandler(div).get前排他(被保険者番号.getColumnValue())) {
            createHandler(div).前排他キーの解除(被保険者番号.getColumnValue());
        }
        return ResponseData.of(div).forwardWithEventName(検索結果一覧に戻る).respond();
    }

    private JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelHandler createHandler(JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv div) {
        return new JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelHandler(div);
    }
}
