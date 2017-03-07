/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.yokaigoninteishinsakaiichiranlist;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.shinsakaikaisai.ShinsakaiKaisai;
import jp.co.ndensan.reams.db.dbz.business.core.shinsakaikaisai.ShinsakaiKaisaiMode;
import jp.co.ndensan.reams.db.dbz.definition.core.shinsakai.IsShiryoSakuseiZumi;
import jp.co.ndensan.reams.db.dbz.definition.core.shinsakai.ShinsakaiShinchokuJokyo;
import static jp.co.ndensan.reams.db.dbz.definition.message.MessageCreateHelper.toCode;
import static jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.YokaigoNinteiShinsakaiIchiranList.YokaigoNinteiShinsakaiIchiranList.IYokaigoNinteiShinsakaiIchiranListDiv.*;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.YokaigoNinteiShinsakaiIchiranList.YokaigoNinteiShinsakaiIchiranList.YokaigoNinteiShinsakaiIchiranListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.YokaigoNinteiShinsakaiIchiranList.YokaigoNinteiShinsakaiIchiranList.dgShinsakaiIchiran_Row;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridSetting;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * {@link YokaigoNinteiShinsakaiIchiranListDiv}のHandlerクラスです。
 *
 * @reamsid_L DBE-0120-010 lishengli
 */
public class YokaigoNinteiShinsakaiIchiranListHandler {

    private static final RString KEY0 = new RString("key0");
    private static final int LENGTH_4 = 4;
    private final YokaigoNinteiShinsakaiIchiranListDiv div;
    private static final RString メニューID_514 = new RString("DBEMN61004");

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
     * @param モード モード
     */
    public void initialize(RString モード) {
        RString menuID = ResponseHolder.getMenuID();
        ViewStateHolder.put(ViewStateKeys.モード, モード);
        if (モード_開催予定登録.equals(モード)) {
            div.setMode_GridDisplayMode(YokaigoNinteiShinsakaiIchiranListDiv.GridDisplayMode.KaisaiYoteiToroku);
            div.getRadDammyShinsakai().setSelectedKey(KEY0);
        }
        if (モード_対象者割付.equals(モード)) {
            div.setMode_GridDisplayMode(YokaigoNinteiShinsakaiIchiranListDiv.GridDisplayMode.TaishoshaWaritsuke);
            div.getRadDammyShinsakai().setSelectedKey(KEY0);
        }
        if (モード_対象者割付_自動割付使用不可.equals(モード)) {
            div.setMode_GridDisplayMode(YokaigoNinteiShinsakaiIchiranListDiv.GridDisplayMode.TaishoshaWaritsuke_UnUseAutoWaritsuke);
            div.getRadDammyShinsakai().setSelectedKey(KEY0);
        }
        if (モード_審査会資料.equals(モード) || モード_委員割付.equals(モード)) {
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
        if (モード_データ出力.equals(モード) && menuID.equals(メニューID_514)) {
            div.getDgShinsakaiIchiran().getGridSetting().setMultiSelectable(false);
            div.getDgShinsakaiIchiran().getGridSetting().setIsShowSelectButtonColumn(true);
        }
        if (モード_判定結果.equals(モード)) {
            div.setMode_GridDisplayMode(YokaigoNinteiShinsakaiIchiranListDiv.GridDisplayMode.HanteiKekka);
            DataGridSetting dataGridSetting = div.getDgShinsakaiIchiran().getGridSetting();
            dataGridSetting.setMultiSelectable(false);
            dataGridSetting.setIsShowSelectButtonColumn(true);
            div.getDgShinsakaiIchiran().setGridSetting(dataGridSetting);
        }

    }

    /**
     * 「検索する」ボタン押下処理です。
     *
     * @param 審査会一覧 SearchResult<ShinsakaiKaisai>
     * @param 最大表示件数 Decimal
     */
    public void set審査会委員一覧(SearchResult<ShinsakaiKaisai> 審査会一覧, Decimal 最大表示件数) {
        List<dgShinsakaiIchiran_Row> list = new ArrayList<>();
        for (ShinsakaiKaisai shinsakaiKaisai : 審査会一覧.records()) {
            dgShinsakaiIchiran_Row row = new dgShinsakaiIchiran_Row();
            row.setShinsakaiKaisaiNo(shinsakaiKaisai.get審査会開催番号());
            row.getKaisaiYoteiDate().setValue(shinsakaiKaisai.get介護認定審査会開催予定年月日());
            row.getYoteiKaishiTime().setValue(getRStringToRtime(shinsakaiKaisai.get介護認定審査会開始予定時刻()));
            row.getYoteiShuryoTime().setValue(getRStringToRtime(shinsakaiKaisai.get介護認定審査会終了予定時刻()));
            row.setShinsakaiMeisho(shinsakaiKaisai.get編集審査会名称());
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
            row.setShiryoSakuseiKubun(shinsakaiKaisai.get資料作成状況());
            if (!RString.isNullOrEmpty(shinsakaiKaisai.get介護認定審査会進捗状況())) {
                row.setShinchokuJokyo(ShinsakaiShinchokuJokyo.toValue(shinsakaiKaisai.get介護認定審査会進捗状況()).get画面表示名称());
            } else {
                row.setShinchokuJokyo(RString.EMPTY);
            }
            row.setDummyFlag(shinsakaiKaisai.isダミーフラグ());
            row.setGogitaiNo(shinsakaiKaisai.get合議体番号());
            list.add(row);
        }
        div.getDgShinsakaiIchiran().setDataSource(list);
        if (審査会一覧.exceedsLimit()) {
            div.getDgShinsakaiIchiran().getGridSetting().setLimitRowCount(審査会一覧.records().size());
            div.getDgShinsakaiIchiran().getGridSetting().setSelectedRowCount(審査会一覧.totalCount());
        } else {
            div.getDgShinsakaiIchiran().getGridSetting().setLimitRowCount(最大表示件数.intValue());
            div.getDgShinsakaiIchiran().getGridSetting().setSelectedRowCount(審査会一覧.totalCount());
        }
    }

    /**
     * 選択アイコン押下処理です。
     */
    public void get開催番号() {
        RString 開催番号 = div.getDgShinsakaiIchiran().getActiveRow().getShinsakaiKaisaiNo();
        RString 開催年月日 = RString.EMPTY;
        if (!div.getDgShinsakaiIchiran().getActiveRow().getKaisaiYoteiDate().getValue().isEmpty()) {
            開催年月日 = new RString(div.getDgShinsakaiIchiran().getActiveRow().getKaisaiYoteiDate().getValue().toString());
        }
        ViewStateHolder.put(ViewStateKeys.開催番号, 開催番号);
        ViewStateHolder.put(ViewStateKeys.開催年月日, 開催年月日);
        div.setHdnSelectedGridLine(new RString(String.valueOf(div.getDgShinsakaiIchiran().getActiveRow().getId())));
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
            RString 開催番号 = row.getShinsakaiKaisaiNo();
            if (row.getSelected() && !RString.isNullOrEmpty(開催番号)) {
                list.add(開催番号);
            }
        }
        return list;
    }

    /**
     * 一覧グリッドの高さを指定します。
     *
     * @param height 指定する高さ
     */
    public void set一覧グリッド高さ指定(RString height) {
        div.getDgShinsakaiIchiran().setHeight(height);
    }

    /**
     * 最大取得件数を設定します。
     */
    public void set最大取得件数() {
        RString 検索制御_最大取得件数上限 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数上限, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        RString 検索制御_最大取得件数 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        div.getTxtSaidaiHyojiKensu().setMaxValue(new Decimal(検索制御_最大取得件数上限.toString()));
        div.getTxtSaidaiHyojiKensu().setValue(new Decimal(検索制御_最大取得件数.toString()));
    }

    /**
     * SelectedGridLineを取得する。
     */
    public void getSelectedGridLine() {
        ShinsakaiKaisaiMode mode = new ShinsakaiKaisaiMode();
        List<ShinsakaiKaisai> shinsakaiKaisaiList = new ArrayList<>();
        List<dgShinsakaiIchiran_Row> rowList = div.getDgShinsakaiIchiran().getDataSource();
        if (rowList != null && !rowList.isEmpty() && !RString.isNullOrEmpty(div.getHdnSelectedGridLine())) {
            for (dgShinsakaiIchiran_Row row : rowList) {
                if (row.getId() == Integer.valueOf(div.getHdnSelectedGridLine().toString())) {
                    ShinsakaiKaisai shinsakaiKaisai = new ShinsakaiKaisai();
                    shinsakaiKaisai = shinsakaiKaisai.createBuilderForEdit()
                            .set介護認定審査会開催予定年月日(row.getKaisaiYoteiDate().getValue())
                            .set介護認定審査会開始予定時刻(new RString(row.getYoteiKaishiTime().getValue().toString()))
                            .set介護認定審査会終了予定時刻(new RString(row.getYoteiShuryoTime().getValue().toString()))
                            .set編集審査会名称(row.getShinsakaiMeisho())
                            .set合議体名称(row.getGogitaiMeisho())
                            .set種類(row.getShurui())
                            .set介護認定審査会開催場所名称(row.getShinsakaiKaijo())
                            .set介護認定審査会開催年月日(row.getKaisaiDay().getValue())
                            .set介護認定審査会開始時刻(new RString(row.getKaisaiTime().getValue().toString()))
                            .set介護認定審査会終了時刻(new RString(row.getShuryoTime().getValue().toString()))
                            .set介護認定審査会予定定員(row.getYoteiTeiin().getValue())
                            .set介護認定審査会割当済み人数(row.getWariateNinzu().getValue())
                            .set介護認定審査会実施人数(row.getTaishoNinzu().getValue())
                            .set音声記録(row.getOnseiKiroku())
                            .setモバイルデータ出力年月日(row.getDataShutsuryoku().getValue())
                            .set資料作成済フラグ(is資料作成済区分(row))
                            .set介護認定審査会進捗状況(row.getShinchokuJokyo())
                            .setダミーフラグ(row.getDummyFlag())
                            .set審査会開催番号(row.getShinsakaiKaisaiNo())
                            .build();
                    shinsakaiKaisaiList.add(shinsakaiKaisai);
                }
            }
            mode.set審査会一覧Grid(shinsakaiKaisaiList);
            ViewStateHolder.put(ViewStateKeys.選択審査会一覧, mode);
        } else {
            ViewStateHolder.put(ViewStateKeys.選択審査会一覧, null);
        }
    }

    private boolean is資料作成済区分(dgShinsakaiIchiran_Row row) {
        return IsShiryoSakuseiZumi.作成済.get名称().equals(row.getShiryoSakuseiKubun());
    }

    /**
     * 一覧件数を取得する。
     *
     * @return 一覧件数
     */
    public int get一覧件数() {
        return div.getDgShinsakaiIchiran().getDataSource().size();
    }

    /**
     * 表示期間Fromと表示期間Toの前後順チェック処理です。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 表示期間Fromと表示期間Toの前後順チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(new YokaigoNinteiShinsakaiIchiranListMessage(UrErrorMessages.期間が不正_追加メッセージあり１,
                div.getTxtHyojiKikan().getFromText().toString(), div.getTxtHyojiKikan().getToText().toString()), div.getTxtHyojiKikan()));
        return validationMessages;
    }

    /**
     * 最大表示件数チェック処理です。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 最大表示件数チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(
                new YokaigoNinteiShinsakaiIchiranListMessage(YokaigoNinteiShinsakaiIchiranErrorMessage.最大表示件数が0),
                div.getTxtSaidaiHyojiKensu()));
        return validationMessages;
    }

    /**
     * 該当データが存在のチェック処理です。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 該当データが存在のチェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(new YokaigoNinteiShinsakaiIchiranListMessage(UrErrorMessages.該当データなし)));
        return validationMessages;
    }

    private RTime getRStringToRtime(RString time) {
        if (!RString.isNullOrEmpty(time)) {
            time = time.padZeroToLeft(LENGTH_4);
            return RTime.of(Integer.valueOf(time.substring(0, 2).toString()), Integer.valueOf(time.substring(2).toString()));
        }
        return RTime.of(0, 0, 0, 0);
    }

    private static class YokaigoNinteiShinsakaiIchiranListMessage implements IValidationMessage {

        private final Message message;

        private YokaigoNinteiShinsakaiIchiranListMessage(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

    private enum YokaigoNinteiShinsakaiIchiranErrorMessage implements IMessageGettable {

        /**
         * "1以上の値を入力してください。"を定義します。
         */
        最大表示件数が0(1, "1以上の値を入力してください。");
        private final int no;
        private final RString message;

        private YokaigoNinteiShinsakaiIchiranErrorMessage(int no, String message) {
            this.no = no;
            this.message = new RString(message);
        }

        @Override
        public Message getMessage() {
            return new ErrorMessage(toCode("E", no), this.message.toString());
        }
    }
}
