/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB9020003;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020003.DBB9020003StateName;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020003.FutsuChoshuTotalDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020003.dgGenNendoKibetsuJoho_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020003.dgKaNendoKibetsuJoho_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB9020003.FutsuChoshuTotalHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 画面設計_DBB9020003_システム管理情報（普通徴収）
 *
 * @reamsid_L DBB-1770-050 xupeng
 */
public class FutsuChoshuTotal {

    private static final RString メッセージ = new RString("システム管理登録_普通徴収保存処理は正常に行われました");
    private static final RString MSG = new RString("調定年度：");
    private static final RString MSG_NENNDO = new RString("年度");
    private static final RString 現年度 = new RString("現年度");

    /**
     * システム管理情報（普通徴収）画面初期化する
     *
     * @param div FutsuChoshuTotalDiv
     * @return ResponseData<FutsuChoshuTotalDiv>
     */
    public ResponseData<FutsuChoshuTotalDiv> onLoad(FutsuChoshuTotalDiv div) {
        boolean gotLock = getHandler(div).前排他キーのセット();
        if (!gotLock) {
            throw new PessimisticLockingException();
        }
        div.getFutsuChoshu().getDgGenNendoKibetsuJoho().getGridSetting().getColumns().get(2).setVisible(true);
        div.getFutsuChoshu().getDgKaNendoKibetsuJoho().getGridSetting().getColumns().get(2).setVisible(true);
        getHandler(div).set調定年度DDL();
        getHandler(div).set市町村指定();
        getHandler(div).set初期値();
        return ResponseData.of(div).respond();
    }

    /**
     * 調定年度変化
     *
     * @param div FutsuChoshuTotalDiv
     * @return ResponseData<FutsuChoshuTotalDiv>
     */
    public ResponseData<FutsuChoshuTotalDiv> onChange_ddlChoteiNendo(FutsuChoshuTotalDiv div) {
        getHandler(div).set市町村指定();
        getHandler(div).set初期値();
        return ResponseData.of(div).respond();
    }

    /**
     * 市町村変化
     *
     * @param div FutsuChoshuTotalDiv
     * @return ResponseData<FutsuChoshuTotalDiv>
     */
    public ResponseData<FutsuChoshuTotalDiv> onChange_ddlShichosonSelect(FutsuChoshuTotalDiv div) {
        getHandler(div).set初期値();
        return ResponseData.of(div).respond();
    }

    /**
     * 現年度期別情報Gridの「納付書の型」変更
     *
     * @param div FutsuChoshuTotalDiv
     * @return ResponseData<FutsuChoshuTotalDiv>
     */
    public ResponseData<FutsuChoshuTotalDiv> onChange_ddlNofushoKata(FutsuChoshuTotalDiv div) {
        List<dgGenNendoKibetsuJoho_Row> list = div.getFutsuChoshu().getDgGenNendoKibetsuJoho().getDataSource();
        dgGenNendoKibetsuJoho_Row row = div.getFutsuChoshu().getDgGenNendoKibetsuJoho().getClickedItem();
        list.set(div.getFutsuChoshu().getDgGenNendoKibetsuJoho().getClickedRowId(), getHandler(div).set納付書の型変更(row));
        div.getFutsuChoshu().getDgGenNendoKibetsuJoho().setDataSource(list);
        return ResponseData.of(div).respond();
    }

    /**
     * 過年度期別情報Gridの「納付書の型」変更
     *
     * @param div FutsuChoshuTotalDiv
     * @return ResponseData<FutsuChoshuTotalDiv>
     */
    public ResponseData<FutsuChoshuTotalDiv> onChange_ddlNofushoKata2(FutsuChoshuTotalDiv div) {
        List<dgKaNendoKibetsuJoho_Row> list = div.getFutsuChoshu().getDgKaNendoKibetsuJoho().getDataSource();
        dgKaNendoKibetsuJoho_Row row = div.getFutsuChoshu().getDgKaNendoKibetsuJoho().getClickedItem();
        list.set(div.getFutsuChoshu().getDgKaNendoKibetsuJoho().getClickedRowId(), getHandler(div).set納付書の型変更_過年度(row));
        div.getFutsuChoshu().getDgKaNendoKibetsuJoho().setDataSource(list);
        return ResponseData.of(div).respond();
    }

    /**
     * 暫定計算方法の「賦課方法」変更
     *
     * @param div FutsuChoshuTotalDiv
     * @return ResponseData<FutsuChoshuTotalDiv>
     */
    public ResponseData<FutsuChoshuTotalDiv> onChange_ddlFukaHoho(FutsuChoshuTotalDiv div) {
        getHandler(div).set賦課方法変更();
        return ResponseData.of(div).respond();
    }

    /**
     * 現年度Gridの選択変更
     *
     * @param div FutsuChoshuTotalDiv
     * @return ResponseData<FutsuChoshuTotalDiv>
     */
    public ResponseData<FutsuChoshuTotalDiv> onSelectChange_dgGenNendoKibetsuJoho(FutsuChoshuTotalDiv div) {
        getHandler(div).set現年度Grid制御(div.getFutsuChoshu().getDgGenNendoKibetsuJoho().getDataSource());
        return ResponseData.of(div).respond();
    }

    /**
     * 過年度Gridの選択変更
     *
     * @param div FutsuChoshuTotalDiv
     * @return ResponseData<FutsuChoshuTotalDiv>
     */
    public ResponseData<FutsuChoshuTotalDiv> onSelectChange_dgKaNendoKibetsuJoho(FutsuChoshuTotalDiv div) {
        getHandler(div).set過年度Grid制御(div.getFutsuChoshu().getDgKaNendoKibetsuJoho().getDataSource());
        return ResponseData.of(div).respond();
    }

    /**
     * 「保存する」ボタン
     *
     * @param div FutsuChoshuTotalDiv
     * @return ResponseData<FutsuChoshuTotalDiv>
     */
    public ResponseData<FutsuChoshuTotalDiv> onClick_btnFuchoKibetsuUpdate(FutsuChoshuTotalDiv div) {
        if (現年度.equals(div.getFutsuChoshu().getTabFuCho().getSelectedItem().getTitle())) {
            getHandler(div).現年度入力チェック();
            getHandler(div).過年度入力チェック();
        } else {
            getHandler(div).過年度入力チェック();
            getHandler(div).現年度入力チェック();
        }

        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).set保存処理();
        } else {
            return ResponseData.of(div).respond();
        }
        RStringBuilder message = new RStringBuilder(MSG);
        message.append(div.getKonkaiShoriNaiyo().getDdlChoteiNendo().getSelectedValue()).append(MSG_NENNDO);
        div.getKanryoMessage().getCcdKaigoKanryoMessage().setMessage(message.toRString(), メッセージ, RString.EMPTY, true);
        return ResponseData.of(div).setState(DBB9020003StateName.完了);
    }

    /**
     * 「完了する」ボタン
     *
     * @param div FutsuChoshuTotalDiv
     * @return ResponseData<FutsuChoshuTotalDiv>
     */
    public ResponseData<FutsuChoshuTotalDiv> onClick_btnKanryo(FutsuChoshuTotalDiv div) {
        getHandler(div).前排他キーの解除();
        return ResponseData.of(div).respond();
    }

    private FutsuChoshuTotalHandler getHandler(FutsuChoshuTotalDiv div) {
        return FutsuChoshuTotalHandler.of(div);
    }

}
