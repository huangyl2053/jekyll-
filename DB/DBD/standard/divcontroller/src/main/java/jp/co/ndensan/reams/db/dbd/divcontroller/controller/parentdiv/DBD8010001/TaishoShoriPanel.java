/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD8010001;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.core.shorijotaikubun.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdQuestionMessages;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010001.DBD8010001StateName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010001.TaishoShoriPanelDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010001.dgShoriSettei_Row;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD8010001.TaishoShoriHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD8010001.TaishoShoriValidationHandler;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.FileData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 非課税年金対象者情報アップロード画面のDivControllerです。
 *
 * @reamsid_L DBD-4920-010 lit
 */
public class TaishoShoriPanel {

    /**
     * 画面用のEnum
     */
    private enum 画面キー {

        /**
         * 画面更新用情報
         */
        画面更新用情報;
    }

    /**
     * 画面初期化
     *
     * @param div TaishoShoriPanelDiv
     * @return ResponseData
     */
    public ResponseData<TaishoShoriPanelDiv> onLoad(TaishoShoriPanelDiv div) {
        ValidationMessageControlPairs pairs = getValidationHandler(div).validate調定年度();
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }

        List<ShoriDateKanri> 画面情報 = getHandler(div).onLoad();

        ViewStateHolder.put(画面キー.画面更新用情報, (Serializable) 画面情報);
        setDisplayOrOpen(div, false);
        return ResponseData.of(div).setState(DBD8010001StateName.アップロード画面);
    }

    /**
     * 年度DDLの選択変更の処理です。
     *
     * @param div TaishoShoriPanelDiv
     * @return ResponseData
     */
    public ResponseData<TaishoShoriPanelDiv> onChange_ddlShoriNendo(TaishoShoriPanelDiv div) {
        div.setHdnNendo(div.getDdlShoriNendo().getSelectedKey());
        return ResponseData.of(div).respond();
    }

    /**
     * 市町村指定DDLの選択変更の処理です。
     *
     * @param div TaishoShoriPanelDiv
     * @return ResponseData
     */
    public ResponseData<TaishoShoriPanelDiv> onChange_ddlShichosonshitei(TaishoShoriPanelDiv div) {

        div.setHdnShichosonCode(div.getDdlShichosonshitei().getSelectedKey());
        List<ShoriDateKanri> 画面情報 = getHandler(div).changeShichosonshitei();

        ViewStateHolder.put(画面キー.画面更新用情報, (Serializable) 画面情報);
        setDisplayOrOpen(div, false);
        return ResponseData.of(div).setState(DBD8010001StateName.アップロード画面);
    }

    /**
     * 「処理設定」ボタンの処理です。
     *
     * @param div TaishoShoriPanelDiv
     * @return ResponseData
     */
    public ResponseData<TaishoShoriPanelDiv> onClick_btnShoriSettei(TaishoShoriPanelDiv div) {
        getHandler(div).moveShoriSettei();
        return ResponseData.of(div).setState(DBD8010001StateName.処理設定画面);
    }

    /**
     * 検索結果一覧選択
     *
     * @param div TaishoShoriPanelDiv
     * @return ResponseData
     */
    public ResponseData<TaishoShoriPanelDiv> onSelectBySelectButton(TaishoShoriPanelDiv div) {
        setDisplayOrOpen(div, true);
        return ResponseData.of(div).respond();
    }

    /**
     * 「アップロード」ボタンの処理です。
     *
     * @param div TaishoShoriPanelDiv
     * @param files FileData[]
     * @return 引数のDivを持つResponseData型
     */
    @SuppressWarnings("checkstyle:illegaltoken")
    public ResponseData<TaishoShoriPanelDiv> onClick_btnUpload(TaishoShoriPanelDiv div, FileData[] files) {
        if (files.length > 0) {
            ValidationMessageControlPairs pairs = getValidationHandler(div).validateファイル値();
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }

            div.setHdnFilePath(files[0].getFilePath());

            getHandler(div).readFile();

            pairs = getValidationHandler(div).validateファイル内容();
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }

            Message message = getValidationHandler(div).validate作成年月日();
            if (null != message) {
                return ResponseData.of(div).addMessage(message).respond();
            }
        }

        List<ShoriDateKanri> 画面更新用情報 = ViewStateHolder.get(画面キー.画面更新用情報, List.class);
        getHandler(div).upload(画面更新用情報);

        List<ShoriDateKanri> 画面情報 = getHandler(div).change対象処理一覧(div.getDgTaishoShoriItchiran().getDataSource());
        ViewStateHolder.put(画面キー.画面更新用情報, (Serializable) 画面情報);
        setDisplayOrOpen(div, false);

        div.getCcdKaigoKanryoMessage().setSuccessMessage(
                new RString(UrInformationMessages.正常終了.getMessage().replace("アップロード処理").evaluate()));
        return ResponseData.of(div).setState(DBD8010001StateName.処理完了);
    }

    /**
     * 「戻る」ボタンの処理です。
     *
     * @param div TaishoShoriPanelDiv
     * @return ResponseData
     */
    public ResponseData<TaishoShoriPanelDiv> onClick_btnBack(TaishoShoriPanelDiv div) {

        return ResponseData.of(div).setState(DBD8010001StateName.アップロード画面);
    }

    /**
     * 「保存する」ボタンの処理です。
     *
     * @param div TaishoShoriPanelDiv
     * @return ResponseData
     */
    public ResponseData<TaishoShoriPanelDiv> onClick_btnUpdate(TaishoShoriPanelDiv div) {
        ValidationMessageControlPairs pairs = getValidationHandler(div).validate();
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }

        if (!ResponseHolder.isReRequest() && is再処理(div)) {
            return ResponseData.of(div).addMessage(DbdQuestionMessages.非課税年金再処理確認.getMessage()).respond();
        }

        if (!ResponseHolder.isReRequest() || ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            List<ShoriDateKanri> 画面更新用情報 = ViewStateHolder.get(画面キー.画面更新用情報, List.class);
            getHandler(div).save(画面更新用情報);

            div.getCcdKaigoKanryoMessage().setSuccessMessage(new RString("更新処理が正常に終了しました。"));
            return ResponseData.of(div).setState(DBD8010001StateName.処理完了);
        }

        return ResponseData.of(div).respond();
    }

    private TaishoShoriHandler getHandler(TaishoShoriPanelDiv div) {
        return new TaishoShoriHandler(div);
    }

    private TaishoShoriValidationHandler getValidationHandler(TaishoShoriPanelDiv div) {
        return new TaishoShoriValidationHandler(div);
    }

    private void setDisplayOrOpen(TaishoShoriPanelDiv div, boolean flg) {
        div.getFuairuAppurodo().setCanOpenAndClose(flg);
        div.getFuairuAppurodo().setIsOpen(flg);
        div.getUplTaishoFuairu().setDisplayNone(!flg);
        div.getBtnAppurodo().setDisplayNone(!flg);
    }

    private boolean is再処理(TaishoShoriPanelDiv div) {
        for (dgShoriSettei_Row 処理設定 : div.getDgShoriSettei().getDataSource()) {
            if (処理設定.getTxtShoriJotai().getSelectedKey().equals(ShoriJotaiKubun.再処理前.getコード())
                    && 処理設定.getTxtShoriJotai().getSelectedIndex() != 0) {
                return true;
            }
        }
        return false;
    }
}
