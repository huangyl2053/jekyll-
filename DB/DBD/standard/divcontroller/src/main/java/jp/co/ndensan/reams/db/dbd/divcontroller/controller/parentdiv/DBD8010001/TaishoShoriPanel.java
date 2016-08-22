/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD8010001;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010001.DBD8010001StateName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010001.TaishoShoriPanelDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD8010001.TaishoShoriHandler;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
        List<ShoriDateKanri> 画面情報 = getHandler(div).onLoad();

        ViewStateHolder.put(画面キー.画面更新用情報, (Serializable) 画面情報);
        div.getFuairuAppurodo().setDisplayNone(true);
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
        div.getFuairuAppurodo().setDisplayNone(true);
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
        div.getFuairuAppurodo().setDisplayNone(false);
        // TODO. URL設定処理が必要があると思ます。
        return ResponseData.of(div).respond();
    }

    /**
     * 「アップロード」ボタンの処理です。
     *
     * @param div TaishoShoriPanelDiv
     * @return ResponseData
     */
    public ResponseData<TaishoShoriPanelDiv> onClick_btnUpload(TaishoShoriPanelDiv div) {
        // TODO. upload処理

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

        List<ShoriDateKanri> 画面情報 = getHandler(div).onLoad();

        ViewStateHolder.put(画面キー.画面更新用情報, (Serializable) 画面情報);
        div.getFuairuAppurodo().setDisplayNone(true);
        return ResponseData.of(div).setState(DBD8010001StateName.アップロード画面);
    }

    /**
     * 「保存する」ボタンの処理です。
     *
     * @param div TaishoShoriPanelDiv
     * @return ResponseData
     */
    public ResponseData<TaishoShoriPanelDiv> onClick_btnUpdate(TaishoShoriPanelDiv div) {
        // TODO. check処理
        List<ShoriDateKanri> 画面更新用情報 = ViewStateHolder.get(画面キー.画面更新用情報, List.class);
        getHandler(div).save(画面更新用情報);

        div.getCcdKaigoKanryoMessage().setSuccessMessage(new RString("更新処理が正常に終了しました。"));
        return ResponseData.of(div).setState(DBD8010001StateName.処理完了);
    }

    private TaishoShoriHandler getHandler(TaishoShoriPanelDiv div) {
        return new TaishoShoriHandler(div);
    }
}
