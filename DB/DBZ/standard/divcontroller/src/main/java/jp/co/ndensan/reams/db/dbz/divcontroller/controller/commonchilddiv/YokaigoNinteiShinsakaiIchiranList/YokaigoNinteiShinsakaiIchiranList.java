/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.YokaigoNinteiShinsakaiIchiranList;

import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.shinsakaikaisai.ShinsakaiKaisai;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.YokaigoNinteiShinsakaiIchiranList.YokaigoNinteiShinsakaiIchiranList.YokaigoNinteiShinsakaiIchiranListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.yokaigoninteishinsakaiichiranlist.YokaigoNinteiShinsakaiIchiranListHandler;
import jp.co.ndensan.reams.db.dbz.service.core.shinsakaikaisai.ShinsakaiKaisaiFinder;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 介護認定審査会共有一覧のDivControllerです。
 *
 * @reamsid_L DBE-0120-010 lishengli
 */
public class YokaigoNinteiShinsakaiIchiranList {

    private static final RString ラジオボタン初期化_key1 = new RString("key1");
    private static final RString ラジオボタン初期化_key0 = new RString("key0");
    private static final RString モード_開催予定登録 = new RString("kaisaiYoteiToroku");
    private static final RString モード_対象者割付 = new RString("taishoshaWaritsuke");
    private static final RString モード_審査会資料 = new RString("shinsakaiShiryoSakusei");
    private static final RString モード_審査結果登録 = new RString("shinsaKekkaToroku");
    private static final RString モード_事前結果登録 = new RString("jizenKekkaToroku");
    private static final RString モード_データ出力 = new RString("dataShutsuryoku");
    private static final RString モード_判定結果 = new RString("hanteiKekka");
    private RString モード;
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
        div.getRadDammyShinsakai().setSelectedKey(ラジオボタン初期化_key1);
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
        div.getDgShinsakaiIchiran().getDataSource().clear();
        div.getDgShinsakaiIchiran().getGridSetting().setLimitRowCount(0);
        div.getDgShinsakaiIchiran().getGridSetting().setSelectedRowCount(0);
        モード = ViewStateHolder.get(ViewStateKeys.モード, RString.class);
        RDate 表示期間From = div.getTxtHyojiKikan().getFromValue();
        RDate 表示期間To = div.getTxtHyojiKikan().getToValue();
        Decimal 最大表示件数 = div.getTxtSaidaiHyojiKensu().getValue();
        ValidationMessageControlPairs validationMessages = getHandler(div).最大表示件数チェック();
        if (最大表示件数 == null || 最大表示件数.intValue() == 0) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        if (モード_開催予定登録.equals(モード) || モード_対象者割付.equals(モード)) {
            ダミー審査会 = div.getRadDammyShinsakai().getSelectedValue();
            表示条件 = div.getRadHyojiJokenWaritsukeMikanryo().getSelectedValue();
        }
        if (モード_審査会資料.equals(モード)) {
            表示条件 = div.getRadHyojiJokenWaritsukeKanryo().getSelectedValue();
        }
        if (モード_審査結果登録.equals(モード) || モード_事前結果登録.equals(モード)
                || モード_データ出力.equals(モード)) {
            表示条件 = div.getRadHyojiJokenShinsakaiMikanryo().getSelectedValue();
        }
        if (モード_判定結果.equals(モード)) {
            表示条件 = div.getRadHyojiJokenShinsakaiKanryo().getSelectedValue();

        }
        SearchResult<ShinsakaiKaisai> 審査会一覧 = ShinsakaiKaisaiFinder.
                createInstance().get審査会一覧(表示期間From, 表示期間To, モード, 表示条件, 最大表示件数, ダミー審査会);
        if (審査会一覧 == null || 審査会一覧.records().isEmpty()) {
            validationMessages = getHandler(div).該当データが存在のチェック();
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        getHandler(div).set審査会委員一覧(審査会一覧, div.getTxtSaidaiHyojiKensu().getValue());

        return ResponseData.of(div).respond();
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
