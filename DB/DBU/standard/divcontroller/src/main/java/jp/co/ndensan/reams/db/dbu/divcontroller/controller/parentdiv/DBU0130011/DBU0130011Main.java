/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0130011;

import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0130011.DBU0130011MainDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0130011.DBU0130011TransitionEventName;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0130011.DBU0130011MainHandler;
import jp.co.ndensan.reams.db.dbu.service.core.roujinhokenjukyushadaichokanri.RoujinHokenJukyushaDaichoKanriManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.basic.RojinHokenJukyushaJoho;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 老人保健受給者台帳管理Divを制御します。
 *
 * @reamsid_L DBU-1110-010 zuotao
 */
public class DBU0130011Main {

    private static final RString モード_データなし = new RString("0");
    private static final RString モード_データあり = new RString("1");

    /**
     * 老人保健受給者台帳管理画面初期化を処理します。
     *
     * @param div 老人保健受給者台帳管理DIV
     * @return ResponseData<DBU0130011MainDiv>
     */
    public ResponseData<DBU0130011MainDiv> onLoad(DBU0130011MainDiv div) {
        TaishoshaKey key = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        ShikibetsuCode shikibetsuCode = key.get識別コード();
        HihokenshaNo hihokenshaNo = key.get被保険者番号();
        initialize(div, RoujinHokenJukyushaDaichoKanriManager.createInstance().getRoukenJukyuJoho(shikibetsuCode));
        div.getAtenaAreaPanel().getCcdKaigoAtenaInfo().initialize(shikibetsuCode);
        div.getAtenaAreaPanel().getCcdKaigoShikakuKihon().initialize(hihokenshaNo);
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
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes)) {
            TaishoshaKey key = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
            createHandler(div).update老健受給情報(key.get識別コード(), key.get被保険者番号(),
                    ViewStateHolder.get(ViewStateKeys.モード, RString.class),
                    ViewStateHolder.get(ViewStateKeys.老健受給情報, RojinHokenJukyushaJoho.class));
            initialize(div, RoujinHokenJukyushaDaichoKanriManager.createInstance().getRoukenJukyuJoho(key.get識別コード()));
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 検索画面に戻るを処理します。
     *
     * @param div 老人保健受給者台帳管理DIV
     * @return ResponseData<DBU0130011MainDiv>
     */
    public ResponseData<DBU0130011MainDiv> onClick_btnReSearch(DBU0130011MainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBU0130011TransitionEventName.対象者検索に戻る).respond();
    }

    /**
     * 該当者一覧画面に戻るを処理します。
     *
     * @param div 老人保健受給者台帳管理DIV
     * @return ResponseData<DBU0130011MainDiv>
     */
    public ResponseData<DBU0130011MainDiv> onClick_btnBack(DBU0130011MainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBU0130011TransitionEventName.対象者一覧に戻る).respond();
    }

    private DBU0130011MainHandler createHandler(DBU0130011MainDiv div) {
        return new DBU0130011MainHandler(div);
    }

    private void initialize(DBU0130011MainDiv div, RojinHokenJukyushaJoho 老健受給情報) {
        if (老健受給情報 == null) {
            ViewStateHolder.put(ViewStateKeys.モード, モード_データなし);
            div.getMeisaiPanel().getTxtRokenJukyushaNo().setValue(RString.EMPTY);
            div.getMeisaiPanel().getTxtRoukenShichosonNo().setValue(RString.EMPTY);
        } else {
            ViewStateHolder.put(ViewStateKeys.モード, モード_データあり);
            ViewStateHolder.put(ViewStateKeys.老健受給情報, 老健受給情報);
            div.getMeisaiPanel().getTxtRokenJukyushaNo().setValue(老健受給情報.get老人保健受給者番号());
            if (老健受給情報.get老人保健市町村コード() == null) {
                div.getMeisaiPanel().getTxtRoukenShichosonNo().setValue(RString.EMPTY);
            } else {
                div.getMeisaiPanel().getTxtRoukenShichosonNo().setValue(老健受給情報.get老人保健市町村コード().value());
            }
        }
    }
}
