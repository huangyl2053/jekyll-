/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5910001;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE591001.DBE591001_IryokikanShujiiParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5910001.IkenshoShujiiIchiranDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * IkenshoShujiiIchiran のクラスファイルです。
 *
 * @reamsid_L DBE-0260-010 zuotao
 */
public class IkenshoShujiiIchiran {

    /**
     * 主治医医療機関・主治医一覧表初期化の設定します。
     *
     * @param div IkenshoShujiiIchiranDiv
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
     * @param div IkenshoShujiiIchiranDiv
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
     * @param div IkenshoShujiiIchiranDiv
     * @return ResponseData<IkenshoShujiiIchiranDiv>
     */
    public ResponseData<IkenshoShujiiIchiranDiv> onClick_Check(IkenshoShujiiIchiranDiv div) {
        if (ResponseHolder.isReRequest()) {
            return ResponseData.of(div).respond();
        }
        if ((!div.getTxtIryoKikanCodeTo().getValue().isNull()) && (!div.getTxtIryoKikanCodeTo().getValue().isEmpty())
                && (0 < div.getTxtIryoKikanCodeFrom().getValue().compareTo(div.getTxtIryoKikanCodeTo().getValue()))) {
            throw new ApplicationException(UrErrorMessages.大小関係が不正.getMessage().replace("医療機関コード"));
        }
        if ((!div.getTxtShujiiCodeTo().getValue().isNull()) && (!div.getTxtShujiiCodeTo().getValue().isEmpty())
                && (0 < div.getTxtShujiiCodeFrom().getValue()
                .compareTo(div.getTxtShujiiCodeTo().getValue()))) {
            throw new ApplicationException(UrErrorMessages.大小関係が不正.getMessage().replace("主治医コード"));
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 一覧表を発行するボタンが押下され、バッチパラメータを作成します。
     *
     * @param div IkenshoShujiiIchiranDiv
     * @return ResponseData
     */
    public ResponseData<DBE591001_IryokikanShujiiParameter> onClick_btnReportPublish(IkenshoShujiiIchiranDiv div) {
        return ResponseData.of(createHandlerOf(div).onClick_btnReportPublish()).respond();
    }

    private IkenshoShujiiIchiranHandler createHandlerOf(IkenshoShujiiIchiranDiv requestDiv) {
        return new IkenshoShujiiIchiranHandler(requestDiv);
    }
}
