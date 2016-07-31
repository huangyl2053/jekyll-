/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2020002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.chikuninteichosain.ChikuNinteiChosain;
import jp.co.ndensan.reams.db.dbe.business.core.chikuninteichosain.ChikuNinteiKoseiShichoson;
import jp.co.ndensan.reams.db.dbe.business.core.chikuninteichosain.ChikuNinteiNinteichosa;
import jp.co.ndensan.reams.db.dbe.business.core.chikuninteichosain.ChosaChiku;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020002.NinteiChosaScheduleShosaiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020002.dgNinteiChosaSchedule_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 認定調査スケジュール登録2のHanderクラスです。
 *
 * @reamsid_L DBE-0020-020 lishengli
 */
public class NinteiChosaScheduleShosaiHander {

    private final NinteiChosaScheduleShosaiDiv div;
    private static final Code 枠数_1 = new Code("1");
    private static final Code 枠数_2 = new Code("2");
    private static final Code 枠数_3 = new Code("3");
    private static final Code 枠数_4 = new Code("4");
    private static final Code 枠数_5 = new Code("5");
    private static final Code 枠数_6 = new Code("6");
    private static final Code 枠数_7 = new Code("7");
    private static final Code 枠数_8 = new Code("8");
    private static final Code 枠数_9 = new Code("9");
    private static final Code 枠数_10 = new Code("10");
    private static final RString DASH = new RString("-");
    private static final RString 調査員状況_空き = new RString("空き");
    private static final RString メモ情報_通常あり = new RString("通常あり");
    private static final RString メモ情報_重要あり = new RString("重要あり");
    private static final RString 予約可 = new RString("0");
    private static final RString 予約不可 = new RString("1");
    private static final RString モード_1 = new RString("1");
    private static final RString モード_3 = new RString("3");
    private static final boolean 非活性 = true;
    private static final boolean 活性 = false;
    private static final boolean 表示 = true;
    private static final boolean 非表示 = false;
    private static final boolean IS閉じている = false;
    private FlexibleDate 設定日;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public NinteiChosaScheduleShosaiHander(NinteiChosaScheduleShosaiDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     * @param 通常件数 通常件数
     * @param 重要件数 重要件数
     * @param モード モード
     * @param 対象地区List 対象地区List
     * @param 認定調査スケジュールList 認定調査スケジュールList
     * @param 保険者List 保険者List
     * @param viewState_設定日 viewState_設定日
     * @param viewState_地区コード viewState_地区コード
     */
    public void onLoad(
            int 通常件数, int 重要件数, RString モード,
            List<ChosaChiku> 対象地区List,
            List<ChikuNinteiChosain> 認定調査スケジュールList,
            List<ChikuNinteiKoseiShichoson> 保険者List,
            FlexibleDate viewState_設定日,
            RString viewState_地区コード) {
        設定日 = viewState_設定日;
        if (モード_1.equals(モード)) {
            div.getTxtSetteiDate().setDisabled(非活性);
            div.getTxtSetteiDate().setValue(設定日);
            if (通常件数 > 0) {
                div.getTxtTsujoMemo().setDisabled(非活性);
                div.getTxtTsujoMemo().setValue(メモ情報_通常あり);
            }
            if (重要件数 > 0) {
                div.getTxtJuyoMemo().setDisabled(非活性);
                div.getTxtJuyoMemo().setValue(メモ情報_重要あり);
            }
            clear();
            set対象地区DDL(対象地区List, new Code(viewState_地区コード.toString()));
            set保険者DDL(保険者List);
            div.getRadChosainJokyo().setSelectedValue(調査員状況_空き);
            set認定調査スケジュール詳細情報(認定調査スケジュールList);
            div.getNchosainScheduleIchiran().setIsOpen(IS閉じている);
            div.getBtnKensaku().setDisabled(活性);
            if (設定日.getDayValue() == 1) {
                div.getBtnSetteiDateToZenjitsu().setDisabled(非活性);
            }
            if (設定日.getDayValue() == 設定日.getLastDay()) {
                div.getBtnSetteiDateToJijitsu().setDisabled(非活性);
            }
        } else if (モード_3.equals(モード)) {
            RDate 当日 = RDate.getNowDate();
            div.getTxtSetteiDate().setDisabled(非活性);
            div.getTxtSetteiDate().setValue(new FlexibleDate(当日.toString()));
            if (通常件数 > 0) {
                div.getTxtTsujoMemo().setDisabled(非活性);
                div.getTxtTsujoMemo().setValue(メモ情報_通常あり);
            }
            if (重要件数 > 0) {
                div.getTxtJuyoMemo().setDisabled(非活性);
                div.getTxtJuyoMemo().setValue(メモ情報_重要あり);
            }
            clear();
            set対象地区DDL(対象地区List, new Code(viewState_地区コード.toString()));
            set保険者DDL(保険者List);
            div.getRadChosainJokyo().setSelectedValue(調査員状況_空き);
            set認定調査スケジュール詳細情報(認定調査スケジュールList);
            div.getNchosainScheduleIchiran().setIsOpen(IS閉じている);
            div.getBtnKensaku().setDisabled(活性);
            if (当日.getDayValue() == 1) {
                div.getBtnSetteiDateToZenjitsu().setDisabled(非活性);
            }
            if (当日.getDayValue() == 当日.getLastDay()) {
                div.getBtnSetteiDateToJijitsu().setDisabled(非活性);
            }
        }
    }

    /**
     * 対象地区onselect取得処理です。
     *
     * @param 保険者List 保険者List
     * @param 通常件数 通常件数
     * @param 重要件数 重要件数
     */
    public void onselect_保険者名称取得(
            List<ChikuNinteiKoseiShichoson> 保険者List,
            int 通常件数,
            int 重要件数) {
        div.getTxtTsujoMemo().clearValue();
        div.getTxtJuyoMemo().clearValue();
        div.getDdlninteiChosaItakusaki().getDataSource().clear();
        set保険者DDL(保険者List);
        if (通常件数 > 0) {
            div.getTxtTsujoMemo().setValue(メモ情報_通常あり);
        }
        if (重要件数 > 0) {
            div.getTxtJuyoMemo().setValue(メモ情報_重要あり);
        }
    }

    /**
     * 前日へボタン処理です。
     *
     * @param 設定日 設定日
     * @param 通常件数 通常件数
     * @param 重要件数 重要件数
     */
    public void onSelect前日(FlexibleDate 設定日, int 通常件数, int 重要件数) {
        div.getTxtTsujoMemo().clearValue();
        div.getTxtJuyoMemo().clearValue();
        div.getTxtSetteiDate().setValue(設定日);
        if (設定日.getDayValue() == 1) {
            div.getBtnSetteiDateToZenjitsu().setDisabled(非活性);
        } else {
            div.getBtnSetteiDateToZenjitsu().setDisabled(活性);
        }
        if (設定日.getDayValue() == 設定日.getLastDay()) {
            div.getBtnSetteiDateToJijitsu().setDisabled(非活性);
        } else {
            div.getBtnSetteiDateToJijitsu().setDisabled(活性);
        }
        if (通常件数 > 0) {
            div.getTxtTsujoMemo().setValue(メモ情報_通常あり);
        }
        if (重要件数 > 0) {
            div.getTxtJuyoMemo().setValue(メモ情報_重要あり);
        }
    }

    /**
     * 次日へボタン処理です。
     *
     * @param 設定日 設定日
     * @param 通常件数 通常件数
     * @param 重要件数 重要件数
     */
    public void onSelect次日(FlexibleDate 設定日, int 通常件数, int 重要件数) {
        div.getTxtTsujoMemo().clearValue();
        div.getTxtJuyoMemo().clearValue();
        div.getTxtSetteiDate().setValue(設定日);
        if (設定日.getDayValue() == 1) {
            div.getBtnSetteiDateToZenjitsu().setDisabled(非活性);
        } else {
            div.getBtnSetteiDateToZenjitsu().setDisabled(活性);
        }
        if (設定日.getDayValue() == 設定日.getLastDay()) {
            div.getBtnSetteiDateToJijitsu().setDisabled(非活性);
        } else {
            div.getBtnSetteiDateToJijitsu().setDisabled(活性);
        }
        if (通常件数 > 0) {
            div.getTxtTsujoMemo().setValue(メモ情報_通常あり);
        }
        if (重要件数 > 0) {
            div.getTxtJuyoMemo().setValue(メモ情報_重要あり);
        }
    }

    /**
     * 保険者onselectの処理です。
     *
     * @param tayisyouTikuList 対象地区List
     * @param chikuNinteiNinteichosaList 認定調査委託先名List
     * @param tikuCode 地区コード
     */
    public void onSelect_Hokensya(List<ChosaChiku> tayisyouTikuList, List<ChikuNinteiNinteichosa> chikuNinteiNinteichosaList, Code tikuCode) {
        set対象地区DDL(tayisyouTikuList, tikuCode);
        set認定調査委託先DDL(chikuNinteiNinteichosaList);
    }

    /**
     * 認定調査スケジュール詳細情報の設定です。
     *
     * @param list 認定調査スケジュール詳細情報List
     */
    public void set認定調査スケジュール詳細情報(List<ChikuNinteiChosain> list) {
        List<dgNinteiChosaSchedule_Row> rowlist = new ArrayList<>();
        div.getNchosainScheduleIchiran().setIsOpen(true);
        for (ChikuNinteiChosain guide : list) {
            dgNinteiChosaSchedule_Row row = new dgNinteiChosaSchedule_Row();
            編集非表示(row);
            row.setNinteiChosainCode(guide.get認定調査員コード());
            row.setNinteiChosainName(guide.get認定調査員氏名());
            row.setYoyakuJokyo(guide.get予約状況());
            if (guide.is予約可否()) {
                row.setYoyakuKahi(予約可);
            } else {
                row.setYoyakuKahi(予約不可);
            }
            row.setShichosonCode(guide.get市町村コード().value());
            if (guide.get認定調査時間枠数() != null && !guide.get認定調査時間枠数().isEmpty()) {
                set認定調査時間1_2(row, guide);
                set認定調査時間3_4(row, guide);
                set認定調査時間5_6(row, guide);
                set認定調査時間7_8(row, guide);
                set認定調査時間9_10(row, guide);
                setChosaTimeFrameMemoDisabled(row);
            }
            rowlist.add(row);
        }
        div.getDgNinteiChosaSchedule().setDataSource(rowlist);
    }

    private void set認定調査時間1_2(dgNinteiChosaSchedule_Row row, ChikuNinteiChosain guide) {
        switch (guide.get認定調査時間枠数().toString()) {
            case "1":
                if (枠数_1.equals(guide.get認定調査時間枠数())) {
                    row.setChosaTimeFrame1(get予定時間(guide.get認定調査予定開始時間(), guide.get認定調査予定終了時間()));
                    row.getChosaTimeFrameMemo1().setVisible(表示);
                    row.getChosaTimeFrameMemo1().setDisabled(活性);
                }
                break;
            case "2":
                if (枠数_2.equals(guide.get認定調査時間枠数())) {
                    row.setChosaTimeFrame2(get予定時間(guide.get認定調査予定開始時間(), guide.get認定調査予定終了時間()));
                    row.getChosaTimeFrameMemo2().setVisible(表示);
                    row.getChosaTimeFrameMemo2().setDisabled(活性);
                }
                break;
            default:
                break;
        }
    }

    private void set認定調査時間3_4(dgNinteiChosaSchedule_Row row, ChikuNinteiChosain guide) {
        switch (guide.get認定調査時間枠数().toString()) {
            case "3":
                if (枠数_3.equals(guide.get認定調査時間枠数())) {
                    row.setChosaTimeFrame3(get予定時間(guide.get認定調査予定開始時間(), guide.get認定調査予定終了時間()));
                    row.getChosaTimeFrameMemo3().setVisible(表示);
                    row.getChosaTimeFrameMemo3().setDisabled(活性);
                }
                break;
            case "4":
                if (枠数_4.equals(guide.get認定調査時間枠数())) {
                    row.setChosaTimeFrame4(get予定時間(guide.get認定調査予定開始時間(), guide.get認定調査予定終了時間()));
                    row.getChosaTimeFrameMemo4().setVisible(表示);
                    row.getChosaTimeFrameMemo4().setDisabled(活性);
                }
                break;
            default:
                break;
        }
    }

    private void set認定調査時間5_6(dgNinteiChosaSchedule_Row row, ChikuNinteiChosain guide) {
        switch (guide.get認定調査時間枠数().toString()) {
            case "5":
                if (枠数_5.equals(guide.get認定調査時間枠数())) {
                    row.setChosaTimeFrame5(get予定時間(guide.get認定調査予定開始時間(), guide.get認定調査予定終了時間()));
                    row.getChosaTimeFrameMemo5().setVisible(表示);
                    row.getChosaTimeFrameMemo5().setDisabled(活性);
                }
                break;
            case "6":
                if (枠数_6.equals(guide.get認定調査時間枠数())) {
                    row.setChosaTimeFrame6(get予定時間(guide.get認定調査予定開始時間(), guide.get認定調査予定終了時間()));
                    row.getChosaTimeFrameMemo6().setVisible(表示);
                    row.getChosaTimeFrameMemo6().setDisabled(活性);
                }
                break;
            default:
                break;
        }
    }

    private void set認定調査時間7_8(dgNinteiChosaSchedule_Row row, ChikuNinteiChosain guide) {
        switch (guide.get認定調査時間枠数().toString()) {
            case "7":
                if (枠数_7.equals(guide.get認定調査時間枠数())) {
                    row.setChosaTimeFrame7(get予定時間(guide.get認定調査予定開始時間(), guide.get認定調査予定終了時間()));
                    row.getChosaTimeFrameMemo7().setVisible(表示);
                    row.getChosaTimeFrameMemo7().setDisabled(活性);
                }
                break;
            case "8":
                if (枠数_8.equals(guide.get認定調査時間枠数())) {
                    row.setChosaTimeFrame8(get予定時間(guide.get認定調査予定開始時間(), guide.get認定調査予定終了時間()));
                    row.getChosaTimeFrameMemo8().setVisible(表示);
                    row.getChosaTimeFrameMemo8().setDisabled(活性);
                }
                break;
            default:
                break;
        }
    }

    private void set認定調査時間9_10(dgNinteiChosaSchedule_Row row, ChikuNinteiChosain guide) {
        switch (guide.get認定調査時間枠数().toString()) {
            case "9":
                if (枠数_9.equals(guide.get認定調査時間枠数())) {
                    row.setChosaTimeFrame9(get予定時間(guide.get認定調査予定開始時間(), guide.get認定調査予定終了時間()));
                    row.getChosaTimeFrameMemo9().setVisible(表示);
                    row.getChosaTimeFrameMemo9().setDisabled(活性);
                }
                break;
            case "10":
                if (枠数_10.equals(guide.get認定調査時間枠数())) {
                    row.setChosaTimeFrame10(get予定時間(guide.get認定調査予定開始時間(), guide.get認定調査予定終了時間()));
                    row.getChosaTimeFrameMemo10().setVisible(表示);
                    row.getChosaTimeFrameMemo10().setDisabled(活性);
                }
                break;
            default:
                break;
        }
    }

    private RString get予定時間(RString 認定調査予定開始時間, RString 認定調査予定終了時間) {
        StringBuilder 予定時間 = new StringBuilder();
        予定時間.append(認定調査予定開始時間.substring(0, 2));
        予定時間.append(":");
        予定時間.append(認定調査予定開始時間.substring(2));
        予定時間.append(DASH);
        予定時間.append(認定調査予定終了時間.substring(0, 2));
        予定時間.append(":");
        予定時間.append(認定調査予定終了時間.substring(2));
        return new RString(予定時間.toString());
    }

    private void setChosaTimeFrameMemoDisabled(dgNinteiChosaSchedule_Row row) {
        RString 最大時間枠 = DbBusinessConfig.get(ConfigNameDBE.調査スケジュール最大時間枠, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        if (Integer.valueOf(最大時間枠.toString()) < Integer.valueOf(枠数_1.toString()) && row.getChosaTimeFrameMemo1().isVisible()) {
            row.getChosaTimeFrameMemo1().setDisabled(非活性);
        }
        if (Integer.valueOf(最大時間枠.toString()) < Integer.valueOf(枠数_2.toString()) && row.getChosaTimeFrameMemo2().isVisible()) {
            row.getChosaTimeFrameMemo2().setDisabled(非活性);
        }
        if (Integer.valueOf(最大時間枠.toString()) < Integer.valueOf(枠数_3.toString()) && row.getChosaTimeFrameMemo3().isVisible()) {
            row.getChosaTimeFrameMemo3().setDisabled(非活性);
        }
        if (Integer.valueOf(最大時間枠.toString()) < Integer.valueOf(枠数_4.toString()) && row.getChosaTimeFrameMemo4().isVisible()) {
            row.getChosaTimeFrameMemo4().setDisabled(非活性);
        }
        if (Integer.valueOf(最大時間枠.toString()) < Integer.valueOf(枠数_5.toString()) && row.getChosaTimeFrameMemo5().isVisible()) {
            row.getChosaTimeFrameMemo5().setDisabled(非活性);
        }
        setChosaTimeFrameMemoDisabled6_10(row, 最大時間枠);
    }

    private void setChosaTimeFrameMemoDisabled6_10(dgNinteiChosaSchedule_Row row, RString 最大時間枠) {
        if (Integer.valueOf(最大時間枠.toString()) < Integer.valueOf(枠数_6.toString()) && row.getChosaTimeFrameMemo6().isVisible()) {
            row.getChosaTimeFrameMemo6().setDisabled(非活性);
        }
        if (Integer.valueOf(最大時間枠.toString()) < Integer.valueOf(枠数_7.toString()) && row.getChosaTimeFrameMemo7().isVisible()) {
            row.getChosaTimeFrameMemo7().setDisabled(非活性);
        }
        if (Integer.valueOf(最大時間枠.toString()) < Integer.valueOf(枠数_8.toString()) && row.getChosaTimeFrameMemo8().isVisible()) {
            row.getChosaTimeFrameMemo8().setDisabled(非活性);
        }
        if (Integer.valueOf(最大時間枠.toString()) < Integer.valueOf(枠数_9.toString()) && row.getChosaTimeFrameMemo9().isVisible()) {
            row.getChosaTimeFrameMemo9().setDisabled(非活性);
        }
        if (Integer.valueOf(最大時間枠.toString()) < Integer.valueOf(枠数_10.toString()) && row.getChosaTimeFrameMemo10().isVisible()) {
            row.getChosaTimeFrameMemo10().setDisabled(非活性);
        }
    }

    private void set対象地区DDL(List<ChosaChiku> list, Code 地区コード) {
        List<KeyValueDataSource> dataList = new ArrayList<>();
        for (ChosaChiku chosaChiku : list) {
            KeyValueDataSource dataSource = new KeyValueDataSource();
            dataSource.setKey(chosaChiku.get調査地区コード());
            dataSource.setValue(chosaChiku.get調査地区名称());
            dataList.add(dataSource);
        }
        div.getDdlTaishoChiku().setDataSource(dataList);
        for (ChosaChiku chosaChiku : list) {
            if (chosaChiku.get調査地区コード().equals(地区コード.value())) {
                div.getDdlTaishoChiku().setSelectedKey(地区コード.value());
            }
        }
    }

    private void set保険者DDL(List<ChikuNinteiKoseiShichoson> 保険者List) {
        List<KeyValueDataSource> dataList = new ArrayList<>();
        for (ChikuNinteiKoseiShichoson entity : 保険者List) {
            KeyValueDataSource dataSource = new KeyValueDataSource();
            dataSource.setKey(entity.get市町村コード().value());
            if (entity.get市町村名称() == null || entity.get市町村名称().isEmpty()) {
                dataSource.setValue(RString.EMPTY);
            } else {
                dataSource.setValue(entity.get市町村名称());
            }
            dataList.add(dataSource);
        }
        div.getDdlHokensha().setDataSource(dataList);
    }

    private void set認定調査委託先DDL(List<ChikuNinteiNinteichosa> 認定調査委託先名List) {
        List<KeyValueDataSource> dataList = new ArrayList<>();
        for (ChikuNinteiNinteichosa entity : 認定調査委託先名List) {
            KeyValueDataSource dataSource = new KeyValueDataSource();
            dataSource.setKey(entity.get認定調査委託先コード());
            if (entity.get認定調査委託先名称() == null || entity.get認定調査委託先名称().isEmpty()) {
                dataSource.setValue(RString.EMPTY);
            } else {
                dataSource.setValue(entity.get認定調査委託先名称());
            }
            dataList.add(dataSource);
        }
        div.getDdlninteiChosaItakusaki().setDataSource(dataList);
    }

    private void clear() {
        div.getDdlHokensha().getDataSource().clear();
        div.getDdlTaishoChiku().getDataSource().clear();
        div.getDdlninteiChosaItakusaki().getDataSource().clear();
    }

    private void 編集非表示(dgNinteiChosaSchedule_Row row) {
        row.getChosaTimeFrameMemo1().setVisible(非表示);
        row.getChosaTimeFrameMemo2().setVisible(非表示);
        row.getChosaTimeFrameMemo3().setVisible(非表示);
        row.getChosaTimeFrameMemo4().setVisible(非表示);
        row.getChosaTimeFrameMemo5().setVisible(非表示);
        row.getChosaTimeFrameMemo6().setVisible(非表示);
        row.getChosaTimeFrameMemo7().setVisible(非表示);
        row.getChosaTimeFrameMemo8().setVisible(非表示);
        row.getChosaTimeFrameMemo9().setVisible(非表示);
        row.getChosaTimeFrameMemo10().setVisible(非表示);
    }

    /**
     * 認定調査委託先選択されていないのチェックです。
     *
     * @param validationMessages ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 認定調査委託先選択されていないのチェック(ValidationMessageControlPairs validationMessages) {

        validationMessages.add(new ValidationMessageControlPair(
                RRVMessages.Validate認定調査委託先, div.getDdlninteiChosaItakusaki()));
        return validationMessages;
    }

    /**
     * 保険者選択されていないのチェックです。
     *
     * @param validationMessages ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 保険者選択されていないのチェック(ValidationMessageControlPairs validationMessages) {

        validationMessages.add(new ValidationMessageControlPair(
                RRVMessages.Validate保険者, div.getDdlHokensha()));
        return validationMessages;
    }

    private static enum RRVMessages implements IValidationMessage {

        Validate保険者(UrErrorMessages.選択されていない, "保険者"),
        Validate認定調査委託先(UrErrorMessages.選択されていない, "認定調査委託先");

        private final Message message;

        private RRVMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
