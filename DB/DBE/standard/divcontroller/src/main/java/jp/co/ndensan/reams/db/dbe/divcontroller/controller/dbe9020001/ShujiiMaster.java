/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.dbe9020001;

import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.dbe9020001.ShujiiMasterHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9020001.ShujiiMasterDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医マスタ処理のクラスです。。
 *
 */
public class ShujiiMaster {

    private static final RString 追加 = new RString("追加");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");

    /**
     * コンストラクタです。
     *
     */
    public ShujiiMaster() {
    }

    /**
     * 画面初期化処理です。
     *
     * @param div ShujiiMasterDiv
     * @return ResponseData<ShujiiMasterDiv>
     */
    public ResponseData<ShujiiMasterDiv> onLoad(ShujiiMasterDiv div) {
	getHandler(div).load();
	getHandler(div).clearKensakuJoken();
	RString 主治医医療機関コード = RString.EMPTY;//ViewStateHolder.get(ViewStateKeys.認定調査委託先コード, RString.class);
	if (主治医医療機関コード != null && !主治医医療機関コード.isEmpty()) {
	    div.getShujiiSearch().getTxtSearchShujiiIryokikanCodeFrom().setValue(主治医医療機関コード);
	    onClick_btnSearchShujii(div);
	}
	return ResponseData.of(div).respond();
    }

    /**
     * 主治医マスタDivの検索を表します。
     *
     * @param div 主治医マスタDiv
     * @return ResponseData
     */
    public ResponseData<ShujiiMasterDiv> onClick_btnSearchShujii(ShujiiMasterDiv div) {
	ResponseData<ShujiiMasterDiv> response = new ResponseData<>();

	getHandler(div).btnSearchShujii(null);
	return ResponseData.of(div).respond();
    }

    private void searchChosainInfo(ShujiiMasterDiv div) {
	boolean JokyoFlag = false;
	if (div.getRadSearchJokyoFlag().getSelectedIndex() == 0) {
	    JokyoFlag = true;
	}
    }

    /**
     * 保存ボタン処理です
     *
     * @param div 主治医マスタDiv
     * @return ResponseData
     */
    public ResponseData onClick_btnSave(ShujiiMasterDiv div) {
	ResponseData<ShujiiMasterDiv> response = new ResponseData<>();

	response.data = div;
	return response;
    }

    private ShujiiMasterHandler getHandler(ShujiiMasterDiv div) {
	return new ShujiiMasterHandler(div);
    }
}
