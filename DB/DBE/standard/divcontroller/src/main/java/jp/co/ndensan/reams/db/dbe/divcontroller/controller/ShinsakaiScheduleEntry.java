/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4040001.ShinsakaiScheduleEntryDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4040001.dgShinakaiScheduleList_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4040001.dgShinsakaiIinList_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4040001.dgShinsakaiList_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * 審査会開催予定登録Divの制御を行います。（DBE4040001）
 *
 * @author N1013 松本直樹
 */
public class ShinsakaiScheduleEntry {

    private static final int SELECT_0 = 0;
    private static final int SELECT_1 = 1;
    private static final int SELECT_2 = 2;
    private static final int START_KAISAI_NO = 26;

    /**
     * 審査会予定登録Divのロード時の処理を表します。
     *
     * @param div 審査会開催予定登録Div
     * @return ResponseData
     */
    public ResponseData onLoadData(ShinsakaiScheduleEntryDiv div) {
        ResponseData<ShinsakaiScheduleEntryDiv> response = new ResponseData<>();

        div.getShinakaiScheduleList().getDgShinakaiScheduleList().setDataSource(createRowShinsakaiListTestData());
        div.getShinakaiScheduleList().getDgShinakaiScheduleList().setSortOrder(new RString("shinsakaiNo"));
        div.getShinakaiScheduleList().getDgShinakaiScheduleList().getSortOrder().toUpperCase();

        response.data = div;
        return response;
    }

    /**
     * 審査会スケジュール登録Divの合議体ドロップダウンリストで合議体選択時の処理を表します。
     *
     * @param div 審査会開催予定登録Div
     * @return ResponseData
     */
    public ResponseData onChange_ddlGogitai(ShinsakaiScheduleEntryDiv div) {
        ResponseData<ShinsakaiScheduleEntryDiv> response = new ResponseData<>();

        List<HashMap> targetSource = YamlLoader.DBE.loadAsList(new RString("dbe4040001/gogitai.yml"));
        Map map;
        RString ymlData;
        if (div.getSchedule().getDdlGogitai().getSelectedValue().equalsIgnoreCase(new RString("合議体01"))) {
            map = targetSource.get(SELECT_0);
            ymlData = new RString("dbe4040001/gogitai01.yml");
        } else if (div.getSchedule().getDdlGogitai().getSelectedValue().equalsIgnoreCase(new RString("合議体02"))) {
            map = targetSource.get(SELECT_1);
            ymlData = new RString("dbe4040001/gogitai02.yml");
        } else if (div.getSchedule().getDdlGogitai().getSelectedValue().equalsIgnoreCase(new RString("合議体03"))) {
            map = targetSource.get(SELECT_2);
            ymlData = new RString("dbe4040001/gogitai03.yml");
        } else {
            map = targetSource.get(SELECT_0);
            ymlData = new RString("dbe4040001/gogitai01.yml");
        }

        div.getSchedule().getDdlKaisaiBasho().setSelectedItem(_toRString(map.get("開催場所")));
        int startTimeHour = new Integer(map.get("予定開始時").toString());
        int startTimeMin = new Integer(map.get("予定開始分").toString());
        div.getSchedule().getTxtYoteiTimeFrom().setValue(RTime.of(startTimeHour, startTimeMin));
        int endTimeHour = new Integer(map.get("予定終了時").toString());
        int endTimeMin = new Integer(map.get("予定終了分").toString());
        div.getSchedule().getTxtYoteiTimeTo().setValue(RTime.of(endTimeHour, endTimeMin));
        div.getSchedule().getTxtYoteiTeiin().setValue(new Decimal(map.get("予定定員").toString()));
        div.getSchedule().getTxtMaxTeiin().setValue(new Decimal(map.get("最大定員").toString()));
        div.getSchedule().getTxtAutoBindTeiin().setValue(new Decimal(map.get("自動割当").toString()));
        div.getSchedule().getGogitai().getDgShinsakaiIinList().setDataSource(createRowGogitaiTestData(ymlData));

        response.data = div;
        return response;
    }

    /**
     * スケジュールを登録するボタン押下時の処理を表します。
     *
     * @param div 審査会開催予定登録Div
     * @return ResponseData
     */
    public ResponseData onClick_btnToRegister(ShinsakaiScheduleEntryDiv div) {
        ResponseData<ShinsakaiScheduleEntryDiv> response = new ResponseData<>();

        List<dgShinsakaiList_Row> arrayData = div.getShinsakaiList().getDgShinsakaiList().getDataSource();

        TextBoxFlexibleDate kaisaiDate = toTextBoxFlexibleDate(new FlexibleDate(
                div.getSchedule().getTxtKaisaiDate().getValue().toString()));
        RString startTime = div.getSchedule().getTxtYoteiTimeFrom().getText();
        RString endTime = div.getSchedule().getTxtYoteiTimeTo().getText();
        RString kaisaiBasho = div.getSchedule().getDdlKaisaiBasho().getSelectedValue();
        RString gogitai = div.getSchedule().getDdlGogitai().getSelectedValue();
        RString yoteiTeiin = div.getSchedule().getTxtYoteiTeiin().getText();
        RString maxTeiin = div.getSchedule().getTxtMaxTeiin().getText();
        RString autoTeiin = div.getSchedule().getTxtAutoBindTeiin().getText();

        for (dgShinsakaiList_Row row : arrayData) {
            if (row.getKaisaiBasho().equalsIgnoreCase(kaisaiBasho)
                    && row.getGogitai().equalsIgnoreCase(gogitai)
                    && row.getKaisaiDate().getValue().equals(kaisaiDate.getValue())
                    && row.getStartTime().equalsIgnoreCase(startTime)) {
                return response;
            }
        }

        dgShinsakaiList_Row row = new dgShinsakaiList_Row(RString.EMPTY, kaisaiDate, startTime, endTime, kaisaiBasho,
                gogitai, yoteiTeiin, maxTeiin, autoTeiin);
        arrayData.add(row);

        div.getShinsakaiList().getDgShinsakaiList().setDataSource(arrayData);

        response.data = div;
        return response;
    }

    /**
     * 審査会Divの「審査会予定を登録する」ボタン押下時の処理を表します。
     *
     * @param div 審査会開催予定登録Div
     * @return ResponseData
     */
    public ResponseData onClick_btnShinsakaiYoteiToroku(ShinsakaiScheduleEntryDiv div) {
        ResponseData<ShinsakaiScheduleEntryDiv> response = new ResponseData<>();

        List<dgShinsakaiList_Row> arrayData = div.getShinsakaiList().getDgShinsakaiList().getDataSource();
        List<dgShinakaiScheduleList_Row> arrayScheduleData = div.getShinakaiScheduleList().
                getDgShinakaiScheduleList().getDataSource();

        for (dgShinsakaiList_Row row : arrayData) {
            dgShinakaiScheduleList_Row ichiranRow = new dgShinakaiScheduleList_Row(row.getShinsakaiNo(), row.getKaisaiDate(),
                    row.getStartTime(), row.getEndTime(), row.getKaisaiBasho(), row.getGogitai(), row.getYoteiTeiin(),
                    new RString("0"), row.getMaxTeiin(), row.getAutoBindTeiin());
            arrayScheduleData.add(ichiranRow);
        }

        div.getShinakaiScheduleList().getDgShinakaiScheduleList().setDataSource(arrayScheduleData);

        response.data = div;
        return response;
    }

    /**
     * 開催番号採番ボタン押下時の処理を表します。
     *
     * @param div 審査会開催予定登録Div
     * @return ResponseData
     */
    public ResponseData onClick_btnNumberingKaisaiNo(ShinsakaiScheduleEntryDiv div) {
        ResponseData<ShinsakaiScheduleEntryDiv> response = new ResponseData<>();

        int kaisaiNo = START_KAISAI_NO;
        RString shinsakaiMei;

        List<dgShinsakaiList_Row> arrayData = div.getShinsakaiList().getDgShinsakaiList().getDataSource();
        for (dgShinsakaiList_Row row : arrayData) {
            shinsakaiMei = (new RString("第" + _toRString(kaisaiNo) + "回審査会"));
            row.setShinsakaiNo(shinsakaiMei);
            kaisaiNo = ++kaisaiNo;
        }

        div.getShinsakaiList().getDgShinsakaiList().setDataSource(arrayData);
        response.data = div;
        return response;
    }

    /**
     * 選択した審査会を削除ボタン押下時の処理を表します。
     *
     * @param div 審査会開催予定登録Div
     * @return ResponseData
     */
    public ResponseData onClick_btnToDelete(ShinsakaiScheduleEntryDiv div) {
        ResponseData<ShinsakaiScheduleEntryDiv> response = new ResponseData<>();

        List<dgShinsakaiList_Row> shinsakaiData = div.getShinsakaiList().getDgShinsakaiList().getDataSource();
        List<dgShinsakaiList_Row> selectData = div.getShinsakaiList().getDgShinsakaiList().getSelectedItems();
        for (dgShinsakaiList_Row row : shinsakaiData) {
            for (dgShinsakaiList_Row selectRow : selectData) {
                if (row.toString().equalsIgnoreCase(selectRow.toString())) {
                    row.setGogitai(RString.EMPTY);
                }
            }
        }

        List<dgShinsakaiList_Row> arrayData = new ArrayList<>();
        for (dgShinsakaiList_Row row : shinsakaiData) {
            if (row.getGogitai().equalsIgnoreCase(RString.EMPTY)) {
                continue;
            }
            arrayData.add(row);
        }

        div.getShinsakaiList().getDgShinsakaiList().setDataSource(arrayData);

        response.data = div;
        return response;
    }

    /**
     * 審査会開催予定一覧Divの「審査会予定を削除する」ボタン押下時の処理を表します。
     *
     * @param div 審査会開催予定登録Div
     * @return ResponseData
     */
    public ResponseData onClick_btnRemoveShinsakai(ShinsakaiScheduleEntryDiv div) {
        ResponseData<ShinsakaiScheduleEntryDiv> response = new ResponseData<>();

        List<dgShinakaiScheduleList_Row> shinsakaiData = div.getShinakaiScheduleList().
                getDgShinakaiScheduleList().getDataSource();
        List<dgShinakaiScheduleList_Row> selectData = div.getShinakaiScheduleList().
                getDgShinakaiScheduleList().getSelectedItems();
        for (dgShinakaiScheduleList_Row row : shinsakaiData) {
            for (dgShinakaiScheduleList_Row selectRow : selectData) {
                if (row.toString().equalsIgnoreCase(selectRow.toString())
                        && row.getWariateNinzu().equalsIgnoreCase(new RString("0"))) {
                    row.setShinsakaiNo(RString.EMPTY);
                }
            }
        }

        List<dgShinakaiScheduleList_Row> arrayData = new ArrayList<>();
        for (dgShinakaiScheduleList_Row row : shinsakaiData) {
            if (row.getShinsakaiNo().equalsIgnoreCase(RString.EMPTY)) {
                continue;
            }
            arrayData.add(row);
        }

        div.getShinakaiScheduleList().getDgShinakaiScheduleList().setDataSource(arrayData);

        response.data = div;
        return response;
    }

    private List<dgShinsakaiIinList_Row> createRowGogitaiTestData(RString ymlData) {
        List<dgShinsakaiIinList_Row> arrayData = new ArrayList<>();
        List<HashMap> targetSource = YamlLoader.DBE.loadAsList(ymlData);
        for (Map info : targetSource) {
            arrayData.add(toDgShinsakaiIinList(info));
        }
        return arrayData;

    }

    private dgShinsakaiIinList_Row toDgShinsakaiIinList(Map map) {
        RString iinNo = _toRString(map.get("審査会委員番号"));
        RString shimei = _toRString(map.get("氏名"));
        RString sex = _toRString(map.get("性別"));
        RString kikan = _toRString(map.get("所属機関"));
        RString shikaku = _toRString(map.get("資格"));
        dgShinsakaiIinList_Row row = new dgShinsakaiIinList_Row(iinNo, shimei, shimei, shimei, sex, kikan, shikaku);
        return row;
    }

    private List<dgShinakaiScheduleList_Row> createRowShinsakaiListTestData() {
        List<dgShinakaiScheduleList_Row> arrayData = new ArrayList<>();
        List<HashMap> targetSource = YamlLoader.DBE.loadAsList(new RString("dbe4040001/ShinsakaiList.yml"));
        for (Map info : targetSource) {
            arrayData.add(toDgShinsakaiList(info));
        }
        return arrayData;

    }

    private dgShinakaiScheduleList_Row toDgShinsakaiList(Map map) {
        RString kaisaiNo = _toRString(map.get("開催番号"));
        TextBoxFlexibleDate kaisaiDate = toTextBoxFlexibleDate(new FlexibleDate(map.get("開催日").toString()));
        RString startTime = _toRString(map.get("開始時間"));
        RString endTime = _toRString(map.get("終了時間"));
        RString basho = _toRString(map.get("開催場所"));
        RString gogitai = _toRString(map.get("合議体"));
        RString yoteiTeiin = _toRString(map.get("予定定員"));
        RString wariate = _toRString(map.get("割当人数"));
        RString maxTeiin = _toRString(map.get("最大定員"));
        RString autoTeiin = _toRString(map.get("自動定員"));
        dgShinakaiScheduleList_Row row = new dgShinakaiScheduleList_Row(kaisaiNo, kaisaiDate, startTime, endTime,
                basho, gogitai, yoteiTeiin, wariate, maxTeiin, autoTeiin);
        return row;
    }

    private static RString _toRString(Object obj) {
        if (obj == null) {
            return RString.EMPTY;
        }
        return new RString(obj.toString());
    }

    private TextBoxFlexibleDate toTextBoxFlexibleDate(FlexibleDate date) {
        TextBoxFlexibleDate txtBox = new TextBoxFlexibleDate();
        txtBox.setValue(date);
        return txtBox;
    }

}
