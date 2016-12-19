/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.YokaigoNinteiShinsakaiIchiranList;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.shinsakaikaisai.ShinsakaiKaisai;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.YokaigoNinteiShinsakaiIchiranList.YokaigoNinteiShinsakaiIchiranList.YokaigoNinteiShinsakaiIchiranListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.yokaigoninteishinsakaiichiranlist.YokaigoNinteiShinsakaiIchiranListHandler;
import jp.co.ndensan.reams.db.dbz.service.core.shinsakaikaisai.ShinsakaiKaisaiFinder;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

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
        RString 検索制御_最大取得件数上限 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数上限, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        RString 検索制御_最大取得件数 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        div.getTxtSaidaiHyojiKensu().setMaxValue(new Decimal(検索制御_最大取得件数上限.toString()));
        div.getTxtSaidaiHyojiKensu().setValue(new Decimal(検索制御_最大取得件数.toString()));
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
        モード = ViewStateHolder.get(ViewStateKeys.モード, RString.class);
        RDate 表示期間From = div.getTxtHyojiKikan().getFromValue();
        RDate 表示期間To = div.getTxtHyojiKikan().getToValue();
        ValidationMessageControlPairs validationMessages
                = getHandler(div).表示期間Fromと表示期間Toの前後順チェック();
        if (表示期間From != null && 表示期間To != null && 表示期間To.isBefore(表示期間From)) {
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
        List<ShinsakaiKaisai> 審査会一覧 = ShinsakaiKaisaiFinder.
                createInstance().get審査会一覧(表示期間From, 表示期間To, モード, 表示条件, div.getTxtSaidaiHyojiKensu().getValue(), ダミー審査会).records();
        if (審査会一覧 == null || 審査会一覧.isEmpty()) {
            validationMessages = getHandler(div).該当データが存在のチェック();
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        getHandler(div).set審査会委員一覧(審査会一覧);

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
