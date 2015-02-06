/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.iryohokenrireki.IryoHokenRirekiDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 医療保険履歴をグリッドで表示する共有子DivのDivControllerです。
 *
 * @author n8178 城間篤人
 */
public class IryoHokenRireki implements Serializable {

    /**
     * @param requestDiv IryoHokenRirekiDiv
     * @return ResponseData
     */
    public ResponseData<IryoHokenRirekiDiv> onLoad(IryoHokenRirekiDiv requestDiv) {

        //TODO n8178 城間篤人 以前作成されたハンドラを削除したため一時的にコメントアウト。対応するハンドラを新規に作成した後に置き換えが必要 2014年12月
//        Dba3030011IryoHokenRirekiHandler handler = requestDiv.getHandler();
//        handler.initialize();
        return getResponseData(requestDiv);

    }

    /**
     * @param requestDiv IryoHokenRirekiDiv
     * @return ResponseData
     */
    public ResponseData<IryoHokenRirekiDiv> onClick_btnAddIryoHoken(IryoHokenRirekiDiv requestDiv) {

        //TODO n8178 城間篤人 以前作成されたハンドラを削除したため一時的にコメントアウト。対応するハンドラを新規に作成した後に置き換えが必要 2014年12月
//        Dba3030011IryoHokenRirekiHandler handler = requestDiv.getHandler();
//        handler.onClick_btnAddIryoHoken();
        return getResponseData(requestDiv);

    }

    /**
     * @param requestDiv IryoHokenRirekiDiv
     * @return ResponseData
     */
    public ResponseData<IryoHokenRirekiDiv> onClick_btnAddUpdate(IryoHokenRirekiDiv requestDiv) {

        //TODO n8178 城間篤人 以前作成されたハンドラを削除したため一時的にコメントアウト。対応するハンドラを新規に作成した後に置き換えが必要 2014年12月
//        Dba3030011IryoHokenRirekiHandler handler = requestDiv.getHandler();
//        handler.onClick_btnAddUpdate();
        return getResponseData(requestDiv);

    }

    private ResponseData<IryoHokenRirekiDiv> getResponseData(IryoHokenRirekiDiv requestDiv) {
        ResponseData<IryoHokenRirekiDiv> response = new ResponseData();
        response.data = requestDiv;

        return response;
    }

//    private IryoHokenRirekiDiv div;
    /**
     * デフォルトコンストラクタです。
     */
//    public IryoHokenRireki() {
//    }
//    /**
//     * コンストラクタです。
//     *
//     * @param div 全国住所入力Div
//     */
//    public IryoHokenRireki(IIryoHokenRirekiDiv div) {
//        this.div = (IryoHokenRirekiDiv) div;
//    }
    /**
     * 引数から渡されたモードに合わせて、コントロールの表示非表示を切り替えます。<br/>
     * 照会モードが設定されていた場合、グリッド上の修正・削除ボタンが非表示になります。
     *
     * @param rirekiDiv 医療保険履歴Div
     * @param mode モード
     */
//    public static void setMode(IryoHokenRirekiDiv rirekiDiv, ModeType mode) {
//
//        rirekiDiv.setMode(mode.toValue());
//        if (ModeType.SHOKAI_MODE.toValue().equals(rirekiDiv.getMode())) {
//            rirekiDiv.getDgIryoHokenRireki().getGridSetting().setIsShowDeleteButtonColumn(false);
//            rirekiDiv.getDgIryoHokenRireki().getGridSetting().setIsShowModifyButtonColumn(false);
//        } else {
//            rirekiDiv.getDgIryoHokenRireki().getGridSetting().setIsShowDeleteButtonColumn(true);
//            rirekiDiv.getDgIryoHokenRireki().getGridSetting().setIsShowModifyButtonColumn(true);
//        }
//    }
}
