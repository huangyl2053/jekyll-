/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD8010002;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD301010.DBD301010_HikazeiNenkinTaishoshaJohoTorikomiParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD301020.DBD301020_SokyuHikazeiNenkinTaishoshaDoteiParameter;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdErrorMessages;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdQuestionMessages;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010002.DBD8010002StateName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010002.HikazeiNenkinTaishoshaJohoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD8010002.HikazeiNenkinTaishoshaJohoHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD8010002.HikazeiNenkinTaishoshaJohoValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.FileData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 非課税年金対象者情報取込画面のDivControllerです。
 *
 * @reamsid_L DBD-4910-010 huangh
 */
public class HikazeiNenkinTaishoshaJoho {

    private static final RString DBDMN81002 = new RString("DBDMN81002");
    private final RString 単一保険者 = new RString("2");
    private final RString 非課税年金対象者情報取込 = new RString("非課税年金対象者情報取込");
    private final RString 遡及非課税年金対象者同定 = new RString("遡及非課税年金対象者同定");

    /**
     * 画面初期化処理です。
     *
     * @param div JissiJyokyohyoDiv
     * @return ResponseData<HikazeiNenkinTaishoshaJohoDiv>
     */
    public ResponseData<HikazeiNenkinTaishoshaJohoDiv> onLoad(HikazeiNenkinTaishoshaJohoDiv div) {
        List<RString> 取込対象市町村コードリスト = getHandler(div).onLoad(div);
        ViewStateHolder.put(ViewStateKeys.取込対象市町村コードリスト, new ArrayList<>(取込対象市町村コードリスト));

        setDisplayOrOpen(div, false);
        if (DBD8010002StateName.非課税年金対象者情報_単一用.getName().equals(div.getHdnState())) {
            return ResponseData.of(div).setState(DBD8010002StateName.非課税年金対象者情報_単一用);
        } else if (DBD8010002StateName.非課税年金対象者情報_広域用.getName().equals(div.getHdnState())) {
            return ResponseData.of(div).setState(DBD8010002StateName.非課税年金対象者情報_広域用);
        } else if (DBD8010002StateName.遡及非課税年金対象者同定.getName().equals(div.getHdnState())) {
            return ResponseData.of(div).setState(DBD8010002StateName.遡及非課税年金対象者同定);

        }
        return ResponseData.of(div).respond();
    }

    /**
     * 画面初期化処理です。
     *
     * @param div JissiJyokyohyoDiv
     * @return ResponseData<HikazeiNenkinTaishoshaJohoDiv>
     */
    public ResponseData<HikazeiNenkinTaishoshaJohoDiv> onStateTransition(HikazeiNenkinTaishoshaJohoDiv div) {
        if (DBD8010002StateName.非課税年金対象者情報_単一用.getName().equals(div.getHdnState())) {
            return ResponseData.of(div).rootTitle(非課税年金対象者情報取込).respond();
        } else if (DBD8010002StateName.非課税年金対象者情報_広域用.getName().equals(div.getHdnState())) {
            return ResponseData.of(div).rootTitle(非課税年金対象者情報取込).respond();
        } else if (DBD8010002StateName.遡及非課税年金対象者同定.getName().equals(div.getHdnState())) {
            return ResponseData.of(div).rootTitle(遡及非課税年金対象者同定).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 年度DDLの選択処理です。
     *
     * @param div JissiJyokyohyoDiv
     * @return ResponseData<HikazeiNenkinTaishoshaJohoDiv>
     */
    public ResponseData<HikazeiNenkinTaishoshaJohoDiv> onChange_ddlShoriNendo(HikazeiNenkinTaishoshaJohoDiv div) {
        List<RString> 取込対象市町村コードリスト = getHandler(div).onChange_ddlShoriNendo(div);
        ViewStateHolder.put(ViewStateKeys.取込対象市町村コードリスト, new ArrayList<>(取込対象市町村コードリスト));

        return ResponseData.of(div).respond();
    }

    /**
     * 月DDLの選択処理です。
     *
     * @param div JissiJyokyohyoDiv
     * @return ResponseData<HikazeiNenkinTaishoshaJohoDiv>
     */
    public ResponseData<HikazeiNenkinTaishoshaJohoDiv> onChange_ddlTuki(HikazeiNenkinTaishoshaJohoDiv div) {
        List<RString> 取込対象市町村コードリスト = getHandler(div).onChange_ddlTuki(div);
        ViewStateHolder.put(ViewStateKeys.取込対象市町村コードリスト, new ArrayList<>(取込対象市町村コードリスト));

        return ResponseData.of(div).respond();
    }

    /**
     * 処理設定のクリンク処理です。
     *
     * @param div JissiJyokyohyoDiv
     * @return ResponseData<HikazeiNenkinTaishoshaJohoDiv>
     */
    public ResponseData<HikazeiNenkinTaishoshaJohoDiv> onClick_btnShoriSettei(HikazeiNenkinTaishoshaJohoDiv div) {

        List<ShoriDateKanri> 更新用List = getHandler(div).onClick_btnShoriSettei(div);
        ViewStateHolder.put(ViewStateKeys.非課税年金対象者情報取込初期情報, (Serializable) 更新用List);

        return ResponseData.of(div).setState(DBD8010002StateName.処理設定);
    }

    /**
     * 処理設定のクリンク処理です。
     *
     * @param div JissiJyokyohyoDiv
     * @return ResponseData<HikazeiNenkinTaishoshaJohoDiv>
     */
    public ResponseData<HikazeiNenkinTaishoshaJohoDiv> onClick_btnBatchRegister(HikazeiNenkinTaishoshaJohoDiv div) {

        if (DBDMN81002.equals(ResponseHolder.getMenuID())) {
            ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();

            if (単一保険者.equals(getHandler(div).広域と市町村判断())) {
                getValidationHandler(div).validateFor処理状態単一(pairs);
                getValidationHandler(div).validateForアップロード済みファイル名(pairs);
            }
            if (!単一保険者.equals(getHandler(div).広域と市町村判断())) {
                checkempty();
                getValidationHandler(div).validateFor処理状態広域(pairs);
                getValidationHandler(div).validateFor取込チェックボックス(pairs);
            }
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
        }
        getHandler(div).onClick_btnBatchRegister(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 処理設定のクリンク処理です。
     *
     * @param div JissiJyokyohyoDiv
     * @return HikazeiNennkinTaishouSyaJohoTorikomiBatchParameter
     */
    public ResponseData<DBD301010_HikazeiNenkinTaishoshaJohoTorikomiParameter> createDBD301010BatchParamter(HikazeiNenkinTaishoshaJohoDiv div) {

        List<RString> 構成市町村コードリスト = ViewStateHolder.
                get(ViewStateKeys.取込対象市町村コードリスト, new ArrayList<>().getClass());

        return ResponseData.of(getHandler(div).createDBD301010BatchParamter(div, 構成市町村コードリスト)).respond();
    }

    /**
     * 処理設定のクリンク処理です。
     *
     * @param div JissiJyokyohyoDiv
     * @return SokyuHikazeiNenkinBatchParameter
     */
    public ResponseData<DBD301020_SokyuHikazeiNenkinTaishoshaDoteiParameter> createDBD301020BatchParamter(HikazeiNenkinTaishoshaJohoDiv div) {

        return ResponseData.of(getHandler(div).createDBD301020BatchParamter(div)).respond();
    }

    /**
     * 「保存する」ボタンのクリンク処理です。
     *
     * @param div JissiJyokyohyoDiv
     * @return SokyuHikazeiNenkinBatchParameter
     */
    public ResponseData<HikazeiNenkinTaishoshaJohoDiv> onClick_btnUpdate(HikazeiNenkinTaishoshaJohoDiv div) {

        List<ShoriDateKanri> 画面更新用情報
                = ViewStateHolder.get(ViewStateKeys.非課税年金対象者情報取込初期情報, new ArrayList<>().getClass());
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        getValidationHandler(div).validateFor編集なし(pairs);

        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }

        if (!ResponseHolder.isReRequest()
                && getValidationHandler(div).validateFor再処理確認()) {
            QuestionMessage message = new QuestionMessage(DbdQuestionMessages.非課税年金再処理確認.getMessage().getCode(),
                    DbdQuestionMessages.非課税年金再処理確認.getMessage().evaluate());

            return ResponseData.of(div).addMessage(message).respond();
        }

        if (new RString(DbdQuestionMessages.非課税年金再処理確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.No)) {
            return ResponseData.of(div).respond();
        }

        getHandler(div).onClick_btnUpdate(画面更新用情報);
        return onLoad(div);

    }

    /**
     * 「戻る」ボタンのクリンク処理です。
     *
     * @param div JissiJyokyohyoDiv
     * @return SokyuHikazeiNenkinBatchParameter
     */
    public ResponseData<HikazeiNenkinTaishoshaJohoDiv> onClick_btnBack(HikazeiNenkinTaishoshaJohoDiv div) {

        return onLoad(div);
    }

    /**
     * 検索結果一覧選択
     *
     * @param div HikazeiNenkinTaishoshaJohoDiv
     * @return ResponseData
     */
    public ResponseData<HikazeiNenkinTaishoshaJohoDiv> onSelectBySelectButton(HikazeiNenkinTaishoshaJohoDiv div) {

        div.getTxtShoriNendo().clearValue();
        div.getTxtTuki().clearValue();
        div.getTxtShori().clearValue();
        div.getTxtFuairuMei().clearValue();

        setDisplayOrOpen(div, true);
        return ResponseData.of(div).respond();
    }

    /**
     * 「アップロード」ボタンの処理です。
     *
     * @param div HikazeiNenkinTaishoshaJohoDiv
     * @param files FileData[]
     * @return 引数のDivを持つResponseData型
     */
    @SuppressWarnings("checkstyle:illegaltoken")
    public ResponseData<HikazeiNenkinTaishoshaJohoDiv> onClick_btnUpload(HikazeiNenkinTaishoshaJohoDiv div, FileData[] files) {

        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        if (files.length > 0) {
            getValidationHandler(div).validateFor処理状態単一(pairs);
            getValidationHandler(div).validateForアップロードファイル未指定(pairs);
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
            div.setHdnFilePath(files[0].getFilePath());
            div.getTanitsuTaishoShoriIchiran().setHdnLocalFileName(files[0].getFileName());

            getHandler(div).readFile();

            ValidationMessageControlPairs newPairs = new ValidationMessageControlPairs();
            getValidationHandler(div).validateFor年次ファイル通知内容(newPairs);
            getValidationHandler(div).validateFor月次ファイル通知内容(newPairs);
            if (newPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(newPairs).respond();
            }

            Message message = getValidationHandler(div).validate作成年月日();
            if (null != message) {
                return ResponseData.of(div).addMessage(message).respond();
            }
        }

        getHandler(div).upload(div.getTanitsuTaishoShoriIchiran().getHdnLocalFileName());
        setDisplayOrOpen(div, false);
        return ResponseData.of(div).respond();
    }

    private HikazeiNenkinTaishoshaJohoHandler getHandler(HikazeiNenkinTaishoshaJohoDiv div) {
        return new HikazeiNenkinTaishoshaJohoHandler(div);
    }

    private HikazeiNenkinTaishoshaJohoValidationHandler getValidationHandler(HikazeiNenkinTaishoshaJohoDiv div) {
        return new HikazeiNenkinTaishoshaJohoValidationHandler(div);
    }

    private void setDisplayOrOpen(HikazeiNenkinTaishoshaJohoDiv div, boolean flg) {
        div.getFuairuAppurodo().setCanOpenAndClose(flg);
        div.getFuairuAppurodo().setIsOpen(flg);
        div.getFuairuAppurodo().getUplTaishoFuairu().setDisplayNone(!flg);
        div.getFuairuAppurodo().getBtnAppurodo().setDisplayNone(!flg);
    }

    private void checkempty() {
        List<RString> 構成市町村コードリスト = ViewStateHolder.
                get(ViewStateKeys.取込対象市町村コードリスト, new ArrayList<>().getClass());
        if (構成市町村コードリスト == null || 構成市町村コードリスト.isEmpty()) {
            throw new ApplicationException(DbdErrorMessages.処理なし.getMessage());
        }
    }
}
