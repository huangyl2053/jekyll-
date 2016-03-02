/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.yokaigoninteishinsakaiichiranlist;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.shinsakaikaisai.ShinsakaiKaisai;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.YokaigoNinteiShinsakaiIchiranList.YokaigoNinteiShinsakaiIchiranList.YokaigoNinteiShinsakaiIchiranListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.YokaigoNinteiShinsakaiIchiranList.YokaigoNinteiShinsakaiIchiranList.dgShinsakaiIchiran_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * {@link YokaigoNinteiShinsakaiIchiranListDiv}のHandlerクラスです。
 */
public class YokaigoNinteiShinsakaiIchiranListHandler {

    private static final RString 介護認定審査会進捗状況_0 = new RString("0");
    private static final RString 介護認定審査会進捗状況_1 = new RString("1");
    private static final RString 介護認定審査会進捗状況_9 = new RString("9");
    private static final RString 介護認定審査会進捗状況_開催済 = new RString("開催済");
    private static final RString 介護認定審査会進捗状況_中止 = new RString("開催済");
    private static final RString 資料作成済区分_作成済 = new RString("作成済");
    private static final RString モード_開催予定登録 = new RString("開催予定登録");
    private static final RString モード_対象者割付 = new RString("対象者割付");
    private static final RString モード_審査会資料 = new RString("審査会資料");
    private static final RString モード_審査結果登録 = new RString("審査結果登録");
    private static final RString モード_事前結果登録 = new RString("事前結果登録");
    private static final RString モード_データ出力 = new RString("データ出力");
    private static final RString モード_判定結果 = new RString("判定結果");
    private static final int LENGTH_4 = 4;
    private RString モード;
    private final YokaigoNinteiShinsakaiIchiranListDiv div;

    /**
     * コンストラクタです。
     *
     * @param div YokaigoNinteiShinsakaiIchiranListDiv
     */
    public YokaigoNinteiShinsakaiIchiranListHandler(YokaigoNinteiShinsakaiIchiranListDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     */
    public void initialize() {
        モード = ViewStateHolder.get(ViewStateKeys.モード, RString.class);
        if (モード_開催予定登録.equals(モード)) {
            div.setMode_GridDisplayMode(YokaigoNinteiShinsakaiIchiranListDiv.GridDisplayMode.KaisaiYoteiToroku);
        }
        if (モード_対象者割付.equals(モード)) {
            div.setMode_GridDisplayMode(YokaigoNinteiShinsakaiIchiranListDiv.GridDisplayMode.TaishoshaWaritsuke);
        }
        if (モード_審査会資料.equals(モード)) {
            div.setMode_GridDisplayMode(YokaigoNinteiShinsakaiIchiranListDiv.GridDisplayMode.ShinsakaiShiryoSakusei);
        }
        if (モード_審査結果登録.equals(モード)) {
            div.setMode_GridDisplayMode(YokaigoNinteiShinsakaiIchiranListDiv.GridDisplayMode.ShinsaKekkaToroku);
        }
        if (モード_事前結果登録.equals(モード)) {
            div.setMode_GridDisplayMode(YokaigoNinteiShinsakaiIchiranListDiv.GridDisplayMode.JizenKekkaToroku);
        }
        if (モード_データ出力.equals(モード)) {
            div.setMode_GridDisplayMode(YokaigoNinteiShinsakaiIchiranListDiv.GridDisplayMode.DataShutsuryoku);
        }
        if (モード_判定結果.equals(モード)) {
            div.setMode_GridDisplayMode(YokaigoNinteiShinsakaiIchiranListDiv.GridDisplayMode.HanteiKekka);
        }
    }

    /**
     * 「検索する」ボタン押下処理です。
     *
     * @param 審査会一覧 List<ShinsakaiKaisai>
     */
    public void set審査会委員一覧(List<ShinsakaiKaisai> 審査会一覧) {
        List<dgShinsakaiIchiran_Row> list = new ArrayList<>();
        for (ShinsakaiKaisai shinsakaiKaisai : 審査会一覧) {
            dgShinsakaiIchiran_Row row = new dgShinsakaiIchiran_Row();
            row.getKaisaiYoteiDate().setValue(shinsakaiKaisai.get介護認定審査会開催予定年月日());
            row.getYoteiKaishiTime().setValue(getRStringToRtime(shinsakaiKaisai.get介護認定審査会開始予定時刻()));
            row.getYoteiShuryoTime().setValue(getRStringToRtime(shinsakaiKaisai.get介護認定審査会終了予定時刻()));
            row.setShinsakaiMeisho(shinsakaiKaisai.get編集合議体名称());
            row.setGogitaiMeisho(shinsakaiKaisai.get合議体名称());
            row.setShurui(shinsakaiKaisai.get種類());
            row.setShinsakaiKaijo(shinsakaiKaisai.get介護認定審査会開催場所名称());
            row.getKaisaiDay().setValue(shinsakaiKaisai.get介護認定審査会開催年月日());
            row.getKaisaiTime().setValue(getRStringToRtime(shinsakaiKaisai.get介護認定審査会開始時刻()));
            row.getShuryoTime().setValue(getRStringToRtime(shinsakaiKaisai.get介護認定審査会終了時刻()));
            row.getYoteiTeiin().setValue(shinsakaiKaisai.get介護認定審査会予定定員());
            row.getWariateNinzu().setValue(shinsakaiKaisai.get介護認定審査会割当済み人数());
            row.getTaishoNinzu().setValue(shinsakaiKaisai.get介護認定審査会実施人数());
            row.setOnseiKiroku(shinsakaiKaisai.get音声記録());
            row.getDataShutsuryoku().setValue(shinsakaiKaisai.getモバイルデータ出力年月日());
            if (shinsakaiKaisai.is資料作成済フラグ()) {
                row.setShiryoSakuseiKubun(資料作成済区分_作成済);
            } else {
                row.setShiryoSakuseiKubun(RString.EMPTY);
            }
            if (介護認定審査会進捗状況_0.equals(shinsakaiKaisai.get介護認定審査会進捗状況())) {
                row.setShinchokuJokyo(RString.EMPTY);
            }
            if (介護認定審査会進捗状況_1.equals(shinsakaiKaisai.get介護認定審査会進捗状況())) {
                row.setShinchokuJokyo(介護認定審査会進捗状況_開催済);
            }
            if (介護認定審査会進捗状況_9.equals(shinsakaiKaisai.get介護認定審査会進捗状況())) {
                row.setShinchokuJokyo(介護認定審査会進捗状況_中止);
            }
            row.setDummyFlag(shinsakaiKaisai.isダミーフラグ());
            list.add(row);
        }
        div.getDgShinsakaiIchiran().setDataSource(list);
    }

    /**
     * 選択アイコン押下処理です。
     *
     * @return 開催番号
     */
    public RString get開催番号() {
        RString 合議体名称 = div.getDgShinsakaiIchiran().getActiveRow().getShinsakaiMeisho();
        RString 開催番号 = RString.EMPTY;
        if (!合議体名称.isNullOrEmpty()) {
            開催番号 = 合議体名称.substring(1, 合議体名称.length() - LENGTH_4);
        }
        return 開催番号;
    }

    /**
     * 選択チェックBOX押下処理です。
     *
     * @return List<開催番号>
     */
    public List<RString> get開催番号List() {
        List<dgShinsakaiIchiran_Row> rowList = div.getDgShinsakaiIchiran().getDataSource();
        List<RString> list = new ArrayList<>();
        for (dgShinsakaiIchiran_Row row : rowList) {
            RString 合議体名称 = row.getShinsakaiMeisho();
            if (row.getSelected() && !合議体名称.isNullOrEmpty()) {
                list.add(合議体名称.substring(1, 合議体名称.length() - LENGTH_4));
            }
        }
        return list;
    }

    /**
     * 表示期間Fromと表示期間Toの前後順チェック処理です。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 表示期間Fromと表示期間Toの前後順チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(YokaigoNinteiShinsakaiIchiranListMessage.終了日が開始日以前));
        return validationMessages;
    }

    private RTime getRStringToRtime(RString time) {
        return RTime.of(Long.valueOf(time.toString()));
    }

    private enum YokaigoNinteiShinsakaiIchiranListMessage implements IValidationMessage {

        終了日が開始日以前(UrErrorMessages.終了日が開始日以前);

        private final Message message;

        private YokaigoNinteiShinsakaiIchiranListMessage(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
