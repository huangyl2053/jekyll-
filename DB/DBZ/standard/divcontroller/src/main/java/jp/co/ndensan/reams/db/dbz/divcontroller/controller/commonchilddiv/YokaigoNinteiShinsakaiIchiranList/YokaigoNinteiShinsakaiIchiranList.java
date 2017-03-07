/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.YokaigoNinteiShinsakaiIchiranList;

import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.shinsakaikaisai.ShinsakaiKaisai;
import jp.co.ndensan.reams.db.dbz.definition.core.shinsakaikaisai.ShinsakaiKaisaiParameter;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.YokaigoNinteiShinsakaiIchiranList.YokaigoNinteiShinsakaiIchiranList.YokaigoNinteiShinsakaiIchiranListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.yokaigoninteishinsakaiichiranlist.YokaigoNinteiShinsakaiIchiranListHandler;
import static jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.YokaigoNinteiShinsakaiIchiranList.YokaigoNinteiShinsakaiIchiranList.IYokaigoNinteiShinsakaiIchiranListDiv.*;
import jp.co.ndensan.reams.db.dbz.service.core.shinsakaikaisai.ShinsakaiKaisaiFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 介護認定審査会共有一覧のDivControllerです。
 *
 * @reamsid_L DBE-0120-010 lishengli
 */
public class YokaigoNinteiShinsakaiIchiranList {

    private static final RString ラジオボタン初期化_key0 = new RString("key0");
    private static final RString UI_CONTAINER_ID_審査会審査結果登録 = new RString("DBEUC52301");
    private RString 表示条件;
    private RString ダミー審査会;

    /**
     * 画面初期化処理です。
     *
     * @param div YokaigoNinteiShinsakaiIchiranListDiv
     * @return ResponseData<YokaigoNinteiShinsakaiIchiranListDiv>
     */
    public ResponseData<YokaigoNinteiShinsakaiIchiranListDiv> onLoad(YokaigoNinteiShinsakaiIchiranListDiv div) {
        getHandler(div).set最大取得件数();
        return ResponseData.of(div).respond();
    }

    /**
     * 「条件をクリアする」ボタン押下時のイベント
     *
     * @param div 画面情報
     * @return 各入力値クリア後の画面情報
     */
    public ResponseData<YokaigoNinteiShinsakaiIchiranListDiv> onClick_btnClear(YokaigoNinteiShinsakaiIchiranListDiv div) {
        div.getTxtHyojiKikan().clearFromValue();
        div.getTxtHyojiKikan().clearToValue();
        div.getRadHyojiJokenWaritsukeMikanryo().setSelectedKey(ラジオボタン初期化_key0);
        div.getRadHyojiJokenWaritsukeKanryo().setSelectedKey(ラジオボタン初期化_key0);
        div.getRadHyojiJokenShinsakaiMikanryo().setSelectedKey(ラジオボタン初期化_key0);
        div.getRadHyojiJokenShinsakaiKanryo().setSelectedKey(ラジオボタン初期化_key0);
        div.getRadDammyShinsakai().setSelectedKey(ラジオボタン初期化_key0);
        getHandler(div).set最大取得件数();
        return ResponseData.of(div).respond();
    }

    /**
     * 検索するの処理です。
     *
     * @param div YokaigoNinteiShinsakaiIchiranListDiv
     * @return 介護認定審査会共有一覧Divを持つResponseData
     */
    public ResponseData<YokaigoNinteiShinsakaiIchiranListDiv> onClick_BtnKensaku(YokaigoNinteiShinsakaiIchiranListDiv div) {
        if (ResponseHolder.isReRequest()) {
            return ResponseData.of(div).respond();
        }
        div.getDgShinsakaiIchiran().getDataSource().clear();
        div.getDgShinsakaiIchiran().getGridSetting().setLimitRowCount(0);
        div.getDgShinsakaiIchiran().getGridSetting().setSelectedRowCount(0);
        Decimal 最大表示件数 = div.getTxtSaidaiHyojiKensu().getValue();
        ValidationMessageControlPairs validationMessages = getHandler(div).最大表示件数チェック();
        if (最大表示件数 == null || 最大表示件数.intValue() == 0) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }

        final RString モード = ViewStateHolder.get(ViewStateKeys.モード, RString.class);
        if (モード_開催予定登録.equals(モード) || モード_対象者割付.equals(モード) || モード_対象者割付_自動割付使用不可.equals(モード)) {
            ダミー審査会 = div.getRadDammyShinsakai().getSelectedValue();
            表示条件 = div.getRadHyojiJokenWaritsukeMikanryo().getSelectedValue();
        }
        if (モード_審査会資料.equals(モード)) {
            表示条件 = div.getRadHyojiJokenWaritsukeKanryo().getSelectedValue();
        }
        if (モード_審査結果登録.equals(モード) || モード_事前結果登録.equals(モード) || モード_データ出力.equals(モード)) {
            表示条件 = div.getRadHyojiJokenShinsakaiMikanryo().getSelectedValue();
        }
        if (モード_判定結果.equals(モード)) {
            表示条件 = div.getRadHyojiJokenShinsakaiKanryo().getSelectedValue();
        }

        RDate 表示期間From = div.getTxtHyojiKikan().getFromValue();
        RDate 表示期間To = div.getTxtHyojiKikan().getToValue();
        RString 期間From;
        RString 期間To;
        if (表示期間From != null && 表示期間To != null) {
            期間From = 表示期間From.toDateString();
            期間To = 表示期間To.toDateString();
        } else if (表示期間From != null && 表示期間To == null) {
            期間From = 表示期間From.toDateString();
            期間To = RDate.MAX.toDateString();
        } else if (表示期間From == null && 表示期間To != null) {
            期間From = RDate.MIN.toDateString();
            期間To = 表示期間To.toDateString();
        } else {
            期間From = RDate.MIN.toDateString();
            期間To = RDate.MAX.toDateString();
        }
        ShinsakaiKaisaiParameter parameter = createParam(
                期間From, 期間To, モード, 表示条件, 最大表示件数, ダミー審査会);
        SearchResult<ShinsakaiKaisai> 審査会一覧 = ShinsakaiKaisaiFinder.createInstance().get審査会一覧(parameter);
        if (審査会一覧 == null || 審査会一覧.records().isEmpty()) {
            validationMessages = getHandler(div).該当データが存在のチェック();
            if (validationMessages.iterator().hasNext()) {
                return ResponseData.of(div).addMessage(UrInformationMessages.該当データなし.getMessage()).respond();
            }
        }
        getHandler(div).set審査会委員一覧(審査会一覧, div.getTxtSaidaiHyojiKensu().getValue());
        return ResponseData.of(div).respond();
    }

    private static ShinsakaiKaisaiParameter createParam(RString 期間From, RString 期間To,
            RString モード, RString 表示条件, Decimal 最大表示件数, RString ダミー審査会) {
        if (UI_CONTAINER_ID_審査会審査結果登録.equals(ResponseHolder.getUIContainerId())) {
            return ShinsakaiKaisaiParameter.create審査結果登録Param(期間From, 期間To, 表示条件, 最大表示件数);
        }
        return ShinsakaiKaisaiParameter.createParam(
                期間From, 期間To, モード, 表示条件, 最大表示件数, ダミー審査会);
    }

    /**
     * 選択ボタンの処理です。
     *
     * @param div YokaigoNinteiShinsakaiIchiranListDiv
     * @return 介護認定審査会共有一覧Divを持つResponseData
     */
    public ResponseData<YokaigoNinteiShinsakaiIchiranListDiv> onClick_btnSelect(YokaigoNinteiShinsakaiIchiranListDiv div) {
        getHandler(div).get開催番号();
        return ResponseData.of(div).respond();
    }

    private YokaigoNinteiShinsakaiIchiranListHandler getHandler(YokaigoNinteiShinsakaiIchiranListDiv div) {
        return new YokaigoNinteiShinsakaiIchiranListHandler(div);
    }
}
