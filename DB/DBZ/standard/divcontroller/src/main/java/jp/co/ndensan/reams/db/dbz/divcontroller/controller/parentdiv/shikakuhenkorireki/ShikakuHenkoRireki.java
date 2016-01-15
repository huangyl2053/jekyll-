/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.parentdiv.shikakuhenkorireki;

import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.ViewExecutionStatus;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shikakuhenkorireki.ShikakuHenkoRireki.ShikakuHenkoRirekiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shikakuhenkorireki.ShikakuHenkoRireki.ShikakuHenkoRirekiHandler;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 共有子Div「資格変更履歴」のイベントを定義したDivControllerです。
 *
 * @author n8235 船山洋介
 */
public class ShikakuHenkoRireki {

    private static final Code 広域 = new Code("111");
    private static final RString 合併有り = new RString("1");

    /**
     * 追加ボタンを押下した際に実行します。<br/>
     * 追加処理のための前準備を行います。
     *
     * @param div {@link ShikakuHenkoRirekiDiv 資格変更履歴Div}
     * @return 資格変更履歴Divを持つResponseData
     */
    public ResponseData<ShikakuHenkoRirekiDiv> onClick_btnAdd(ShikakuHenkoRirekiDiv div) {
        div.setMode_MeisaiMode(ShikakuHenkoRirekiDiv.MeisaiMode.toroku);
        div.setInputMode(ViewExecutionStatus.Add.getValue());
        return createSettingData(div);
    }

    /**
     * 資格変更履歴上の修正アイコンが押下された際に実行します。<br/>
     * 修正・変更処理のための前準備を行います。
     *
     * @param henkoRirekiDiv {@link ShikakuHenkoRirekiDiv 資格変更履歴Div}
     * @return 資格変更履歴Divを持つResponseData
     */
    public ResponseData<ShikakuHenkoRirekiDiv> onSelectByModifyButton_dgHenko(ShikakuHenkoRirekiDiv henkoRirekiDiv) {
        if (!(henkoRirekiDiv.getMode_DisplayType().equals(ShikakuHenkoRirekiDiv.DisplayType.toroku)
                && !henkoRirekiDiv.getDgHenko().getClickedItem().getState().equals(new RString("追加")))) {
            ShikakuHenkoRirekiHandler handler = getHandler(henkoRirekiDiv);
            henkoRirekiDiv.getBtnAdd().setDisabled(true);
            henkoRirekiDiv.getDgHenko().setReadOnly(true);
            handler.set資格変更入力Panel();
            henkoRirekiDiv.setMode_MeisaiMode(ShikakuHenkoRirekiDiv.MeisaiMode.toroku);
            henkoRirekiDiv.setInputMode(ViewExecutionStatus.Modify.getValue());
        }
        return createSettingData(henkoRirekiDiv);

    }

    /**
     * 資格変更履歴上の削除アイコンが押下された際に実行します。<br/>
     * 削除処理のための前準備を行います。
     *
     * @param henkoRirekiDiv {@link ShikakuHenkoRirekiDiv 資格変更履歴Div}
     * @return 資格変更履歴Divを持つResponseData
     */
    public ResponseData<ShikakuHenkoRirekiDiv> onSelectByDeleteButton_dgHenko(ShikakuHenkoRirekiDiv henkoRirekiDiv) {
        if (!(henkoRirekiDiv.getMode_DisplayType().equals(ShikakuHenkoRirekiDiv.DisplayType.toroku)
                && !henkoRirekiDiv.getDgHenko().getClickedItem().getState().equals(new RString("追加")))) {
            ShikakuHenkoRirekiHandler handler = getHandler(henkoRirekiDiv);
            handler.set資格変更入力Panel();
            henkoRirekiDiv.setMode_MeisaiMode(ShikakuHenkoRirekiDiv.MeisaiMode.sakujo);
            henkoRirekiDiv.setInputMode(ViewExecutionStatus.Delete.getValue());
            henkoRirekiDiv.setExecutionStatus(ViewExecutionStatus.Delete.getValue());
            henkoRirekiDiv.getHenkoHokenshaJoho().setReadOnly(true);
        }
        return createSettingData(henkoRirekiDiv);
    }

    /**
     * 明細エリアの取消ボタンが押下された際に実行します。<br/>
     * 入力した情報を破棄してもよいかの確認メッセージを表示します。
     *
     * @param henkoRirekiDiv {@link ShikakuHenkoRirekiDiv 資格変更履歴Div}
     * @return 資格変更履歴Divを持つResponseData
     */
    public ResponseData<ShikakuHenkoRirekiDiv> onClick_btnHenkoTorikeshi(ShikakuHenkoRirekiDiv henkoRirekiDiv) {
        getHandler(henkoRirekiDiv).clear資格変更入力Panel();
        henkoRirekiDiv.setMode_MeisaiMode(ShikakuHenkoRirekiDiv.MeisaiMode.shokai);
        return createSettingData(henkoRirekiDiv);
    }

    /**
     * 確定ボタンを押下した時に実行されます。<br/>
     * 明細エリアの入力内容を資格変更履歴一覧に反映します。
     *
     * @param henkoRirekiDiv {@link ShikakuHenkoRirekiDiv 資格変更履歴Div}
     * @return 資格変更履歴Divを持つResponseData
     */
    public ResponseData<ShikakuHenkoRirekiDiv> onClick_btnHenkoKakutei(ShikakuHenkoRirekiDiv henkoRirekiDiv) {
        ShikakuHenkoRirekiHandler handler = getHandler(henkoRirekiDiv);
        handler.updateEntryData();
        handler.clear資格変更入力Panel();
        henkoRirekiDiv.setExecutionStatus(ViewExecutionStatus.None.getValue());
        return createSettingData(henkoRirekiDiv);
    }

    private <T> ResponseData<T> createSettingData(T settingData) {
        ResponseData<T> response = new ResponseData<>();
        response.data = settingData;
        return response;
    }

    private ShikakuHenkoRirekiHandler getHandler(ShikakuHenkoRirekiDiv requestDiv) {
        return new ShikakuHenkoRirekiHandler(requestDiv);
    }
}
