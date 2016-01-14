/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.dbu0130011;

import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0130011.DBU0130011MainDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0130011.DBU0130011TransitionEventName;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.dbu0130011.DBU0130011MainHandler;
import jp.co.ndensan.reams.db.dbu.service.core.roujinhokenjukyushadaichokanri.RoujinHokenJukyushaDaichoKanriManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 老人保健受給者台帳管理Divを制御します。
 */
public class DBU0130011Main {

    /**
     * 老人保健受給者台帳管理画面初期化を処理します。
     *
     * @param div 老人保健受給者台帳管理DIV
     * @return ResponseData<DBU0130011MainDiv>
     */
    public ResponseData<DBU0130011MainDiv> onLoad(DBU0130011MainDiv div) {

        createHandler(div).initialize(RoujinHokenJukyushaDaichoKanriManager.createInstance().getRoukenJukyuJoho(
                ViewStateHolder.get(ViewStateKeys.老人保健受給者台帳管理_識別コード, ShikibetsuCode.class)));
        // TODO 宛名基本情報実装しない
        //div.getAtenaAreaPanel().getCcdKaigoAtenaInfo().load(ViewStateHolder.get(ViewStateKeys.老人保健受給者台帳管理_識別コード, ShikibetsuCode.class));
        div.getAtenaAreaPanel().getCcdKaigoShikakuKihon().initialize(ViewStateHolder.get(ViewStateKeys.老人保健受給者台帳管理_被保険者番号, HihokenshaNo.class));
        return ResponseData.of(div).respond();
    }

    /**
     * 老人保健受給者台帳管理画面更新を処理します。
     *
     * @param div 老人保健受給者台帳管理DIV
     * @return ResponseData<DBU0130011MainDiv>
     */
    public ResponseData<DBU0130011MainDiv> onClick_btnUpdate(DBU0130011MainDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes)) {
            createHandler(div).update老健受給情報();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 老人保健受給者台帳管理画面更新を処理します。
     *
     * @param div 老人保健受給者台帳管理DIV
     * @return ResponseData<DBU0130011MainDiv>
     */
    public ResponseData<DBU0130011MainDiv> onClick_btnReSearch(DBU0130011MainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBU0130011TransitionEventName.対象者検索に戻る).respond();
    }

    /**
     * 老人保健受給者台帳管理画面更新を処理します。
     *
     * @param div 老人保健受給者台帳管理DIV
     * @return ResponseData<DBU0130011MainDiv>
     */
    public ResponseData<DBU0130011MainDiv> onClick_btnBack(DBU0130011MainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBU0130011TransitionEventName.対象者検索に戻る).respond();
    }

    private DBU0130011MainHandler createHandler(DBU0130011MainDiv div) {
        return new DBU0130011MainHandler(div);
    }
}
