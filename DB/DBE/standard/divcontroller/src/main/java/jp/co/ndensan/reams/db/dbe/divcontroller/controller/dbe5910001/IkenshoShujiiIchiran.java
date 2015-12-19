/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.dbe5910001;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.ikenshoshujiiichiran.IkenshoShujiiIchiranParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5910001.IkenshoShujiiIchiranDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.db.dbx.service.ShichosonSecurityJoho;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;

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
//        ShichosonSecurityJoho 市町村セキュリティ情報
//                = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護認定);
        handler.onLoad(new RString("1"));
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
     * 一覧表を発行するボタンが押下され、バッチパラメータを作成します。
     *
     * @param div IchijiHanteiKekkaInfoDiv
     * @return ResponseData
     */
    public ResponseData<IkenshoShujiiIchiranParameter> onClick_btnReportPublish(IkenshoShujiiIchiranDiv div) {

        RString iryoKikanCodeFrom = div.getTxtIryoKikanCodeFrom().getValue();
        RString iryoKikanCodeTo = div.getTxtIryoKikanCodeTo().getValue();
        if (0 < iryoKikanCodeFrom.compareTo(iryoKikanCodeTo)) {
            throw new ApplicationException(
                    UrErrorMessages.大小関係が不正.getMessage().replace("医療機関コード"));
        }

        RString shujiiCodeFrom = div.getTxtShujiiCodeFrom().getValue();
        RString shujiiCodeTo = div.getTxtShujiiCodeTo().getValue();
        if (0 < shujiiCodeFrom.compareTo(shujiiCodeTo)) {
            throw new ApplicationException(
                    UrErrorMessages.大小関係が不正.getMessage().replace("主治医コード"));
        }

        return ResponseData.of(createHandlerOf(div).onClick_btnReportPublish()).respond();
    }

    private IkenshoShujiiIchiranHandler createHandlerOf(IkenshoShujiiIchiranDiv requestDiv) {
        return new IkenshoShujiiIchiranHandler(requestDiv);
    }
}
