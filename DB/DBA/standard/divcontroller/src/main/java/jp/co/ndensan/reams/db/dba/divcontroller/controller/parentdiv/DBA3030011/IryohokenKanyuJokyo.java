/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA3030011;

import jp.co.ndensan.reams.db.dba.business.core.iryohokenkanyujokyo.IryohokenKanyuJokyoBusiness;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA3030011.DBA3030011StateName;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA3030011.IryohokenKanyuJokyoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA3030011.IryohokenKanyuJokyoHandler;
import jp.co.ndensan.reams.db.dba.service.core.hihokenshashikakuteisei.HihokenshaShikakuTeiseiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 医療保険加入情報管理のクラスです。
 *
 * @reamsid_L DBA-1230-010 yaoyahui
 */
public class IryohokenKanyuJokyo {

    private static final RString チェックNG = new RString("チェックNG");

    /**
     * 画面を初期化します。
     *
     * @param div 画面情報
     * @return ResponseData<IryohokenKanyuJokyoDiv>
     */
    public ResponseData<IryohokenKanyuJokyoDiv> onLoad(IryohokenKanyuJokyoDiv div) {

        IryohokenKanyuJokyoBusiness joho = getHandler(div).onLoad(getKey().get被保険者番号(), getKey().get識別コード());
        ViewStateHolder.put(ViewStateKeys.初期化時医療保険情報, joho);
        return ResponseData.of(div).respond();
    }

    /**
     * 「医療保険情報を保存する」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<IryohokenKanyuJokyoDiv>
     */
    public ResponseData<IryohokenKanyuJokyoDiv> onClick_Save(IryohokenKanyuJokyoDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            IryohokenKanyuJokyoBusiness joho = ViewStateHolder.get(ViewStateKeys.初期化時医療保険情報, IryohokenKanyuJokyoBusiness.class);
            save(getKey().get識別コード(), joho, div);
            div.getKaigoKanryoyoMessage().getCcdKaigoKanryoMessage().setSuccessMessage(new RString(UrInformationMessages.保存終了.getMessage().evaluate()));
            return ResponseData.of(div).setState(DBA3030011StateName.完了状態);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 保存処理します。
     *
     * @param 識別コード 識別コード
     * @param joho 初期化時の医療保険情報
     * @param div 画面情報
     */
    public void save(ShikibetsuCode 識別コード, IryohokenKanyuJokyoBusiness joho, IryohokenKanyuJokyoDiv div) {
        HihokenshaShikakuTeiseiManager service = HihokenshaShikakuTeiseiManager.createInstance();
        if (チェックNG.equals(service.checkIryoHoken(joho.getIryoHokenJohoList(), getHandler(div).get初期化時の医療保険情報()))) {
            throw new ApplicationException(UrErrorMessages.保存データなし.getMessage());
        }
        div.getIryoHokenIchiran().getCcdIryoHokenRireki().save();
    }

    private IryohokenKanyuJokyoHandler getHandler(IryohokenKanyuJokyoDiv div) {
        return new IryohokenKanyuJokyoHandler(div);
    }

    private TaishoshaKey getKey() {
        return ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
    }

}
