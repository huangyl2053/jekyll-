/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.DataOutputInfomation;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.DataOutputInfomation.DataOutputInfomationDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * データ出力終了メッセージのコントローラです。
 */
public class DataOutputInfomation {

    /**
     * コンストラクタです。
     *
     */
    public DataOutputInfomation() {
    }

    /**
     * データ出力終了メッセージ初期化処理です。
     *
     * @param div 完了ダイアログDiv
     * @return ResponseData<DataOutputInfomationDiv>
     */
    public ResponseData<DataOutputInfomationDiv> onLoad(DataOutputInfomationDiv div) {
        div.getLblMessage().setText(RString.isNullOrEmpty(
                div.getHdnKanryoMsg()) ? new RString("データ出力が終了しました") : div.getHdnKanryoMsg());
        return ResponseData.of(div).respond();
    }

    /**
     * データ出力終了メッセージは閉じです。
     *
     * @param div 完了ダイアログDiv
     * @return ResponseData<DataOutputInfomationDiv>
     */
    public ResponseData<DataOutputInfomationDiv> onClick_btnKakunin(DataOutputInfomationDiv div) {
        return ResponseData.of(div).respond();
    }
}
