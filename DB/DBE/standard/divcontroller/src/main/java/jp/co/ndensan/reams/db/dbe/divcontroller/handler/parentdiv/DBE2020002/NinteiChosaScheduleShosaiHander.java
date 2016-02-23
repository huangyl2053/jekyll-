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
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020002.NinteiChosaScheduleShosaiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020002.dgNinteiChosaSchedule_Row;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChikuShichoson;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 *
 * 認定調査スケジュール登録2のHanderクラスです。
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
     * @param 対象地区List 対象地区List
     * @param 保険者List 保険者List
     */
    public void onLoadモード_1(
            int 通常件数,
            int 重要件数,
            List<ChikuShichoson> 対象地区List,
            List<ChikuNinteiKoseiShichoson> 保険者List) {
        設定日 = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_設定日, FlexibleDate.class);
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
        set対象地区DDL(対象地区List, new Code(ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_地区コード, RString.class).toString()));
        set保険者DDL(保険者List);
        div.getRadChosainJokyo().setSelectedValue(調査員状況_空き);
        div.getNchosainScheduleIchiran().setIsOpen(IS閉じている);
        div.getBtnKensaku().setDisabled(活性);
        if (設定日.getDayValue() == 1) {
            div.getBtnSetteiDateToZenjitsu().setDisabled(非活性);
        }
        if (設定日.getDayValue() == 設定日.getLastDay()) {
            div.getBtnSetteiDateToJijitsu().setDisabled(非活性);
        }
    }

    /**
     * 画面初期化処理です。
     *
     * @param 通常件数 通常件数
     * @param 重要件数 重要件数
     * @param 対象地区List 対象地区List
     * @param 認定調査スケジュールList 認定調査スケジュールList
     * @param 保険者List 保険者List
     */
    public void onLoadモード_3(
            int 通常件数,
            int 重要件数,
            List<ChikuShichoson> 対象地区List,
            List<ChikuNinteiChosain> 認定調査スケジュールList,
            List<ChikuNinteiKoseiShichoson> 保険者List) {
        設定日 = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_設定日, FlexibleDate.class);
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
        set対象地区DDL(対象地区List, new Code(ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_地区コード, RString.class).toString()));
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
    public void onSelect_Hokensya(List<ChikuShichoson> tayisyouTikuList, List<ChikuNinteiNinteichosa> chikuNinteiNinteichosaList, Code tikuCode) {
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
        RString 最大時間枠 = BusinessConfig.get(ConfigNameDBE.調査スケジュール最大時間枠, SubGyomuCode.DBE認定支援);
        for (ChikuNinteiChosain guide : list) {
            dgNinteiChosaSchedule_Row row = new dgNinteiChosaSchedule_Row();
            編集非表示(row);
            row.setNinteiChosainCode(guide.get認定調査員コード());
            row.setNinteiChosainName(guide.get認定調査員氏名());
            if (guide.get認定調査時間枠数() != null && !guide.get認定調査時間枠数().isEmpty()) {
                switch (guide.get認定調査時間枠数().toString()) {
                    case "1":
                        if (枠数_1.equals(guide.get認定調査時間枠数())) {
                            row.setChosaTimeFrame1(new RString(guide.get認定調査予定開始時間() + DASH.toString() + guide.get認定調査予定終了時間()));
                            row.getChosaTimeFrameMemo1().setVisible(表示);
                            row.getChosaTimeFrameMemo1().setDisabled(活性);
                        }
                        break;
                    case "2":
                        if (枠数_2.equals(guide.get認定調査時間枠数())) {
                            row.setChosaTimeFrame2(new RString(guide.get認定調査予定開始時間() + DASH.toString() + guide.get認定調査予定終了時間()));
                            row.getChosaTimeFrameMemo2().setVisible(表示);
                            row.getChosaTimeFrameMemo2().setDisabled(活性);
                        }
                        break;
                    case "3":
                        if (枠数_3.equals(guide.get認定調査時間枠数())) {
                            row.setChosaTimeFrame3(new RString(guide.get認定調査予定開始時間() + DASH.toString() + guide.get認定調査予定終了時間()));
                            row.getChosaTimeFrameMemo3().setVisible(表示);
                            row.getChosaTimeFrameMemo3().setDisabled(活性);
                        }
                        break;
                    case "4":
                        if (枠数_4.equals(guide.get認定調査時間枠数())) {
                            row.setChosaTimeFrame4(new RString(guide.get認定調査予定開始時間() + DASH.toString() + guide.get認定調査予定終了時間()));
                            row.getChosaTimeFrameMemo4().setVisible(表示);
                            row.getChosaTimeFrameMemo4().setDisabled(活性);
                        }
                        break;
                    case "5":
                        if (枠数_5.equals(guide.get認定調査時間枠数())) {
                            row.setChosaTimeFrame5(new RString(guide.get認定調査予定開始時間() + DASH.toString() + guide.get認定調査予定終了時間()));
                            row.getChosaTimeFrameMemo5().setVisible(表示);
                            row.getChosaTimeFrameMemo5().setDisabled(活性);
                        }
                        break;
                    case "6":
                        if (枠数_6.equals(guide.get認定調査時間枠数())) {
                            row.setChosaTimeFrame6(new RString(guide.get認定調査予定開始時間() + DASH.toString() + guide.get認定調査予定終了時間()));
                            row.getChosaTimeFrameMemo6().setVisible(表示);
                            row.getChosaTimeFrameMemo6().setDisabled(活性);
                        }
                        break;
                    case "7":
                        if (枠数_7.equals(guide.get認定調査時間枠数())) {
                            row.setChosaTimeFrame7(new RString(guide.get認定調査予定開始時間() + DASH.toString() + guide.get認定調査予定終了時間()));
                            row.getChosaTimeFrameMemo7().setVisible(表示);
                            row.getChosaTimeFrameMemo7().setDisabled(活性);
                        }
                        break;
                    case "8":
                        if (枠数_8.equals(guide.get認定調査時間枠数())) {
                            row.setChosaTimeFrame8(new RString(guide.get認定調査予定開始時間() + DASH.toString() + guide.get認定調査予定終了時間()));
                            row.getChosaTimeFrameMemo8().setVisible(表示);
                            row.getChosaTimeFrameMemo8().setDisabled(活性);
                        }
                        break;
                    case "9":
                        if (枠数_9.equals(guide.get認定調査時間枠数())) {
                            row.setChosaTimeFrame9(new RString(guide.get認定調査予定開始時間() + DASH.toString() + guide.get認定調査予定終了時間()));
                            row.getChosaTimeFrameMemo9().setVisible(表示);
                            row.getChosaTimeFrameMemo9().setDisabled(活性);
                        }
                        break;
                    case "10":
                        if (枠数_10.equals(guide.get認定調査時間枠数())) {
                            row.setChosaTimeFrame10(new RString(guide.get認定調査予定開始時間() + DASH.toString() + guide.get認定調査予定終了時間()));
                            row.getChosaTimeFrameMemo10().setVisible(表示);
                            row.getChosaTimeFrameMemo10().setDisabled(活性);
                        }
                        break;
                    default:
                        break;
                }
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
            rowlist.add(row);
        }
        div.getDgNinteiChosaSchedule().setDataSource(rowlist);
    }

    private void set対象地区DDL(List<ChikuShichoson> list, Code 地区コード) {
        List<KeyValueDataSource> dataList = new ArrayList<>();
        for (ChikuShichoson chikuShichoson : list) {
            KeyValueDataSource dataSource = new KeyValueDataSource();
            dataSource.setKey(chikuShichoson.get調査地区コード().value());
            dataSource.setValue(chikuShichoson.get調査地区コード().value());
            dataList.add(dataSource);
        }
        div.getDdlTaishoChiku().setDataSource(dataList);
        for (ChikuShichoson chikuShichoson : list) {
            if (chikuShichoson.get調査地区コード().equals(地区コード)) {
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
}
