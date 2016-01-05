/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.dbe5910001;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.ikenshoshujiiichiran.IkenshoShujiiIchiranParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5910001.IkenshoShujiiIchiranDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;

/**
 * IkenshoShujiiIchiranHandler のクラスファイル 主治医医療機関・主治医一覧表データ検索印刷機能
 */
public class IkenshoShujiiIchiran {

    /**
     * 主治医医療機関・主治医一覧表初期化の設定します。
     *
     * @param div IchijiHanteiKekkaInfoDiv
     * @return ResponseData
     */
    public ResponseData<IkenshoShujiiIchiranDiv> onLoad(IkenshoShujiiIchiranDiv div) {
        IkenshoShujiiIchiranHandler handler = createHandlerOf(div);
        ResponseData<IkenshoShujiiIchiranDiv> response = new ResponseData<>();
        handler.onLoad();
        response.data = div;
        return response;
    }

    /**
     * 主治医医療機関・主治医一覧表出力順変更の設定します。
     *
     * @param div IchijiHanteiKekkaInfoDiv
     * @return ResponseData
     */
    public ResponseData<IkenshoShujiiIchiranDiv> onChange_ddlOutputSort(IkenshoShujiiIchiranDiv div) {
        IkenshoShujiiIchiranHandler handler = createHandlerOf(div);
        ResponseData<IkenshoShujiiIchiranDiv> response = new ResponseData<>();
        handler.onChange_ddlOutputSort(div.getDdlOutputSort().getSelectedKey());
        response.data = div;
        return response;
    }

    /**
     * 医療機関コードと主治医コードの大小関係を比較です。
     *
     * @param div IchijiHanteiKekkaInfoDiv
     * @return ResponseData<IkenshoShujiiIchiranDiv>
     */
    public ResponseData<IkenshoShujiiIchiranDiv> onClick_Check(IkenshoShujiiIchiranDiv div) {
        if (0 < div.getTxtIryoKikanCodeFrom().getValue()
                .compareTo(div.getTxtIryoKikanCodeTo().getValue())) {
            throw new ApplicationException(
                    UrErrorMessages.大小関係が不正.getMessage().replace("医療機関コード"));
        }

        if (0 < div.getTxtShujiiCodeFrom().getValue()
                .compareTo(div.getTxtShujiiCodeTo().getValue())) {
            throw new ApplicationException(
                    UrErrorMessages.大小関係が不正.getMessage().replace("主治医コード"));
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 一覧表を発行するボタンが押下され、バッチパラメータを作成します。
     *
     * @param div IchijiHanteiKekkaInfoDiv
     * @return ResponseData
     */
    public ResponseData<IkenshoShujiiIchiranParameter> onClick_btnReportPublish(IkenshoShujiiIchiranDiv div) {
        return ResponseData.of(createHandlerOf(div).onClick_btnReportPublish()).respond();
    }

    private IkenshoShujiiIchiranHandler createHandlerOf(IkenshoShujiiIchiranDiv requestDiv) {
        return new IkenshoShujiiIchiranHandler(requestDiv);
    }
}
