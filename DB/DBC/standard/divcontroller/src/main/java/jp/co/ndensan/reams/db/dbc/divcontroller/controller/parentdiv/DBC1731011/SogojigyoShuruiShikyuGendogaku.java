/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC1731011;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.sogojigyoshurui.SogojigyoShuruiSearchResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1731011.DBC1731011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1731011.SogojigyoShuruiShikyuGendogakuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1731011.SogojigyoShuruiShikyuGendogakuHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1731011.SogojigyoShuruiShikyuGendogakuValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.basic.SogoJigyoShuruiShikyuGendoGakuManager;
import jp.co.ndensan.reams.db.dbc.service.core.sogojigyoshurui.SogojigyoShuruiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.service.core.kaigoserviceshurui.kaigoserviceshurui.KaigoServiceShuruiManager;
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
 * 総合事業種類支給限度額登録Divを制御します。
 *
 * @reamsid_L DBC-3364-010 xuxin
 */
public class SogojigyoShuruiShikyuGendogaku {

    private static final RString 登録 = new RString("登録モード");
    private static final RString 修正 = new RString("修正モード");
    private static final RString 削除 = new RString("削除モード");
    private static final RString 前排他キー = new RString("DbT7118SogoJigyoShuruiShikyuGendoGaku");

    private SogojigyoShuruiShikyuGendogakuHandler getHandler(SogojigyoShuruiShikyuGendogakuDiv div) {
        return new SogojigyoShuruiShikyuGendogakuHandler(div);
    }

    private SogojigyoShuruiShikyuGendogakuValidationHandler getValidationHandler(SogojigyoShuruiShikyuGendogakuDiv div) {
        return new SogojigyoShuruiShikyuGendogakuValidationHandler(div);
    }

    /**
     * 総合事業種類支給限度額登録作成画面初期化を処理します。
     *
     * @param div SogojigyoShuruiShikyuGendogakuDiv
     * @return ResponseData<SogojigyoShuruiShikyuGendogakuDiv>
     */
    public ResponseData<SogojigyoShuruiShikyuGendogakuDiv> onLoad(SogojigyoShuruiShikyuGendogakuDiv div) {

        LockingKey key = new LockingKey(前排他キー);
        if (!RealInitialLocker.tryGetLock(key)) {
            throw new PessimisticLockingException();
        }
        setGrid一覧表示(div);
        return ResponseData.of(div).setState(DBC1731011StateName.初期状態);
    }

    private void setGrid一覧表示(SogojigyoShuruiShikyuGendogakuDiv div) {
        SogojigyoShuruiFinder finder = SogojigyoShuruiFinder.createInstance();
        List<SogojigyoShuruiSearchResult> resultList = finder.get総合事業種類支給限度額情報().records();
        ViewStateHolder.put(ViewStateKeys.総合事業種類情報, (Serializable) resultList);
        if (resultList.isEmpty()) {
            div.getDgShikyuGendogaku().init();
        } else {
            getHandler(div).initialize(resultList);
        }
    }

    private void setサービス種類DDLのDataSource(SogojigyoShuruiShikyuGendogakuDiv div) {
        KaigoServiceShuruiManager manager = InstanceProvider.create(KaigoServiceShuruiManager.class);
        getHandler(div).setDataSource(manager);
    }

    /**
     * 「追加する」ボタン押下時のイベントメソッドです。
     *
     * @param div SogojigyoShuruiShikyuGendogakuDiv
     * @return ResponseData<SogojigyoShuruiShikyuGendogakuDiv>
     */
    public ResponseData<SogojigyoShuruiShikyuGendogakuDiv> onClick_btnAdd(SogojigyoShuruiShikyuGendogakuDiv div) {

        setサービス種類DDLのDataSource(div);
        getHandler(div).set追加状態();
        ViewStateHolder.put(ViewStateKeys.保存モード, 登録);
        return ResponseData.of(div).setState(DBC1731011StateName.初期状態);
    }

    /**
     * 総合事業種類支給限度額登録一覧DataGrid．「修正」ボタン押下時のイベントメソッドです。
     *
     * @param div SogojigyoShuruiShikyuGendogakuDiv
     * @return ResponseData<SogojigyoShuruiShikyuGendogakuDiv>
     */
    public ResponseData<SogojigyoShuruiShikyuGendogakuDiv> onClick_btnModify(SogojigyoShuruiShikyuGendogakuDiv div) {

        setサービス種類DDLのDataSource(div);
        getHandler(div).set修正状態();
        ViewStateHolder.put(ViewStateKeys.保存モード, 修正);
        return ResponseData.of(div).setState(DBC1731011StateName.初期状態);
    }

    /**
     * 総合事業種類支給限度額登録一覧DataGrid．「削除」ボタン押下時のイベントメソッドです。
     *
     * @param div SogojigyoShuruiShikyuGendogakuDiv
     * @return ResponseData<SogojigyoShuruiShikyuGendogakuDiv>
     */
    public ResponseData<SogojigyoShuruiShikyuGendogakuDiv> onClick_btnDelete(SogojigyoShuruiShikyuGendogakuDiv div) {

        setサービス種類DDLのDataSource(div);
        getHandler(div).set削除状態();
        ViewStateHolder.put(ViewStateKeys.保存モード, 削除);
        return ResponseData.of(div).setState(DBC1731011StateName.初期状態);
    }

    /**
     * 「入力前の状態に戻る」ボタン押下時のイベントメソッドです。
     *
     * @param div SogojigyoShuruiShikyuGendogakuDiv
     * @return ResponseData<SogojigyoShuruiShikyuGendogakuDiv>
     */
    public ResponseData<SogojigyoShuruiShikyuGendogakuDiv> onClick_btnBack(SogojigyoShuruiShikyuGendogakuDiv div) {
        getHandler(div).set入力前状態();
        return ResponseData.of(div).setState(DBC1731011StateName.初期状態);
    }

    /**
     * 「保存する」ボタン押下時のイベントメソッドです。
     *
     * @param div SogojigyoShuruiShikyuGendogakuDiv
     * @return ResponseData<SogojigyoShuruiShikyuGendogakuDiv>
     */
    public ResponseData<SogojigyoShuruiShikyuGendogakuDiv> onClick_btnSave(SogojigyoShuruiShikyuGendogakuDiv div) {

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
            List<SogojigyoShuruiSearchResult> 総合事業種類情報 = ViewStateHolder.get(ViewStateKeys.総合事業種類情報, List.class);
            SogoJigyoShuruiShikyuGendoGakuManager manager = InstanceProvider.create(SogoJigyoShuruiShikyuGendoGakuManager.class);
            getHandler(div).save(総合事業種類情報, 保存モード, manager);
            setGrid一覧表示(div);
        }
        return ResponseData.of(div).setState(DBC1731011StateName.初期状態);
    }

}
