/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC1730011;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.sogojigyokubun.SogoJigyoKubunEntity;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1730011.DBC1730011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1730011.SogoJigyoKubunShikyuGendogakuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1730011.SogoJigyoKubunShikyuGendogakuHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1730011.SogoJigyoKubunShikyuGendogakuValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.basic.SogoJigyoKubunShikyuGendoGakuManager;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 総合事業区分支給限度額登録Divを制御します。
 *
 * @reamsid_L DBC-3363-010 xuxin
 */
public class SogoJigyoKubunShikyuGendogaku {

    private static final RString 登録 = new RString("登録モード");
    private static final RString 修正 = new RString("修正モード");
    private static final RString 削除 = new RString("削除モード");
    private static final RString 前排他キー = new RString("DbT7117SogoJigyoKubunShikyuGendoGaku");

    private SogoJigyoKubunShikyuGendogakuHandler getHandler(SogoJigyoKubunShikyuGendogakuDiv div) {
        return new SogoJigyoKubunShikyuGendogakuHandler(div);
    }

    private SogoJigyoKubunShikyuGendogakuValidationHandler getValidationHandler(SogoJigyoKubunShikyuGendogakuDiv div) {
        return new SogoJigyoKubunShikyuGendogakuValidationHandler(div);
    }

    /**
     * 総合事業区分支給限度額登録作成画面初期化を処理します。
     *
     * @param div SogoJigyoKubunShikyuGendogakuDiv
     * @return ResponseData<SogoJigyoKubunShikyuGendogakuDiv>
     */
    public ResponseData<SogoJigyoKubunShikyuGendogakuDiv> onLoad(SogoJigyoKubunShikyuGendogakuDiv div) {

        LockingKey key = new LockingKey(前排他キー);
        if (!RealInitialLocker.tryGetLock(key)) {
            throw new PessimisticLockingException();
        }
        SogoJigyoKubunShikyuGendoGakuManager manager = InstanceProvider.create(SogoJigyoKubunShikyuGendoGakuManager.class);
        List<SogoJigyoKubunEntity> businessList = manager.get介護予防_日常生活支援総合事業区分支給限度額_適用開始日の降順一覧();
        ViewStateHolder.put(ViewStateKeys.総合事業区分情報, (Serializable) businessList);
        if (businessList.isEmpty()) {
            div.getDgShikyuGendogaku().init();
        } else {
            getHandler(div).initialize(businessList);
        }
        return ResponseData.of(div).setState(DBC1730011StateName.初期表示);
    }

    /**
     * 「追加する」ボタン押下時のイベントメソッドです。
     *
     * @param div SogoJigyoKubunShikyuGendogakuDiv
     * @return ResponseData<SogoJigyoKubunShikyuGendogakuDiv>
     */
    public ResponseData<SogoJigyoKubunShikyuGendogakuDiv> onClick_btnAdd(SogoJigyoKubunShikyuGendogakuDiv div) {

        getHandler(div).set追加状態();
        ViewStateHolder.put(ViewStateKeys.保存モード, 登録);
        return ResponseData.of(div).setState(DBC1730011StateName.初期表示);
    }

    /**
     * 総合事業区分支給限度額登録一覧DataGrid．「修正」ボタン押下時のイベントメソッドです。
     *
     * @param div SogoJigyoKubunShikyuGendogakuDiv
     * @return ResponseData<SogoJigyoKubunShikyuGendogakuDiv>
     */
    public ResponseData<SogoJigyoKubunShikyuGendogakuDiv> onClick_btnModify(SogoJigyoKubunShikyuGendogakuDiv div) {

        getHandler(div).set修正状態();
        ViewStateHolder.put(ViewStateKeys.保存モード, 修正);
        return ResponseData.of(div).setState(DBC1730011StateName.初期表示);
    }

    /**
     * 総合事業区分支給限度額登録一覧DataGrid．「削除」ボタン押下時のイベントメソッドです。
     *
     * @param div SogoJigyoKubunShikyuGendogakuDiv
     * @return ResponseData<SogoJigyoKubunShikyuGendogakuDiv>
     */
    public ResponseData<SogoJigyoKubunShikyuGendogakuDiv> onClick_btnDelete(SogoJigyoKubunShikyuGendogakuDiv div) {

        getHandler(div).set削除状態();
        ViewStateHolder.put(ViewStateKeys.保存モード, 削除);
        return ResponseData.of(div).setState(DBC1730011StateName.初期表示);
    }

    /**
     * 「入力前の状態に戻る」ボタン押下時のイベントメソッドです。
     *
     * @param div SogoJigyoKubunShikyuGendogakuDiv
     * @return ResponseData<SogoJigyoKubunShikyuGendogakuDiv>
     */
    public ResponseData<SogoJigyoKubunShikyuGendogakuDiv> onClick_btnBack(SogoJigyoKubunShikyuGendogakuDiv div) {
        getHandler(div).set入力前状態();
        return ResponseData.of(div).setState(DBC1730011StateName.初期表示);
    }

    /**
     * 「保存する」ボタン押下時のイベントメソッドです。
     *
     * @param div SogoJigyoKubunShikyuGendogakuDiv
     * @return ResponseData<SogoJigyoKubunShikyuGendogakuDiv>
     */
    public ResponseData<SogoJigyoKubunShikyuGendogakuDiv> onClick_btnSave(SogoJigyoKubunShikyuGendogakuDiv div) {

        ValidationMessageControlPairs valid = getValidationHandler(div).validate();
        if (valid.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(valid).respond();
        }

        RString 保存モード = ViewStateHolder.get(ViewStateKeys.保存モード, RString.class);
        if (登録.equals(保存モード) || 修正.equals(保存モード)) {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
            }
        } else {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.削除の確認.getMessage()).respond();
            }
        }
        if (MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {
            List<SogoJigyoKubunEntity> 総合事業区分情報 = ViewStateHolder.get(ViewStateKeys.総合事業区分情報, List.class);
            SogoJigyoKubunShikyuGendoGakuManager manager = InstanceProvider.create(SogoJigyoKubunShikyuGendoGakuManager.class);
            getHandler(div).save(総合事業区分情報, 保存モード, manager);
            onLoad(div);
        }
        return ResponseData.of(div).setState(DBC1730011StateName.初期表示);
    }

}
