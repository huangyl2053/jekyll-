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
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5010001.ShinsakaiKaisaiKekkaDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5010001.dgShinsakaiIinIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5010001.dgShinsakaiShinsainIchiran_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 審査会開催結果入力用Divの制御を行います。（DBE5010001）
 *
 * @author N1013 松本直樹
 */
public class ShinsakaiKaisaiKekka {

    private static final int CST_ZERO = 0;

    /**
     * 審査会開催結果Divのロード時の処理を表します。
     *
     * @param div 審査会開催結果入力Div
     * @return ResponseData
     */
    public ResponseData onLoadData(ShinsakaiKaisaiKekkaDiv div) {
        ResponseData<ShinsakaiKaisaiKekkaDiv> response = new ResponseData<>();

        response.data = div;
        return response;
    }

    public ResponseData onClick_btnLoadData(ShinsakaiKaisaiKekkaDiv div) {
        ResponseData<ShinsakaiKaisaiKekkaDiv> response = new ResponseData<>();

        div.getDgShinsakaiShinsainIchiran().setDataSource(createRowShinsakaiIchiranTestData());
        div.getShinsakaiIinIchiran().getDgShinsakaiIinIchiran().setDataSource(createRowShinsakaiIinIchiranTestData());

        RString shinsakaiMeisho = (RString) ViewStateHolder.get("審査会番号", RString.class);
        div.getTxtShinsakaiMeisho().setValue(shinsakaiMeisho);

        RString gogitaiMeisho = (RString) ViewStateHolder.get("合議体名", RString.class);
        div.getTxtGogitai().setValue(gogitaiMeisho);
        FlexibleDate kaisaibi = (FlexibleDate) ViewStateHolder.get("開催日", FlexibleDate.class);
        div.getTxtKaisaiYoteibi().setValue(kaisaibi);
        div.getTxtKaisaiBi().setValue(kaisaibi);
        RString kaisaiBasho = (RString) ViewStateHolder.get("開催場所", RString.class);
        div.getTxtYoteiKaijo().setValue(kaisaiBasho);

        List<HashMap> targetSource = YamlLoader.DBE.loadAsList(new RString("dbe5010001/gogitai.yml"));
        Map map = targetSource.get(0);
        div.getTxtYoteiStartTime().setValue(RTime.parse(map.get("予定開始").toString()));
        div.getTxtKaisaiStartTime().setValue(RTime.parse(map.get("予定開始").toString()));
        div.getTxtYoteiEndTime().setValue(RTime.parse(map.get("予定終了").toString()));
        div.getTxtKaisaiEndTime().setValue(RTime.parse(map.get("予定終了").toString()));
        div.getTxtYoteiTeiin().setValue(new Decimal(map.get("予定定員").toString()));
        div.getTxtJissiSu().setValue(new Decimal(map.get("予定定員").toString()));

        response.data = div;
        return response;
    }

    /**
     * 「審査員を追加する」ボタン押下時の処理を表します。
     *
     * @param div 審査会開催結果入力Div
     * @return ResponseData
     */
    public ResponseData onClick_btnAddIin(ShinsakaiKaisaiKekkaDiv div) {
        ResponseData<ShinsakaiKaisaiKekkaDiv> response = new ResponseData<>();

        response.data = div;
        return response;
    }

    /**
     * 「表示内容で更新する」ボタン押下時の処理を表します。
     *
     * @param div 審査会開催結果入力Div
     * @return ResponseData
     */
    public ResponseData onClick_btnUpdate(ShinsakaiKaisaiKekkaDiv div) {
        ResponseData<ShinsakaiKaisaiKekkaDiv> response = new ResponseData<>();

        response.data = div;
        return response;
    }

    /**
     * 「構成審査員に追加する」ボタン押下時の処理を表します。
     *
     * @param div 審査会開催結果入力Div
     * @return ResponseData
     */
    public ResponseData onClick_btnIinRegister(ShinsakaiKaisaiKekkaDiv div) {
        ResponseData<ShinsakaiKaisaiKekkaDiv> response = new ResponseData<>();

        List<dgShinsakaiShinsainIchiran_Row> arrayData = div.getDgShinsakaiShinsainIchiran().getDataSource();
        List<dgShinsakaiIinIchiran_Row> arraySelectData = div.getShinsakaiIinIchiran().getDgShinsakaiIinIchiran().getSelectedItems();

        for (dgShinsakaiShinsainIchiran_Row row : arrayData) {
            if (row.getShinsainNo().equalsIgnoreCase(arraySelectData.get(CST_ZERO).getShinsainNo())) {
                return response;
            }
        }

        for (dgShinsakaiIinIchiran_Row selectRow : arraySelectData) {
            TextBoxNum iinSu = new TextBoxNum();
            iinSu.setValue(new Decimal(arrayData.size() + 1));
            DropDownList ddlGichoKubun = new DropDownList();
            DropDownList ddlSyukketsuKubun = new DropDownList();

            dgShinsakaiShinsainIchiran_Row row = new dgShinsakaiShinsainIchiran_Row(iinSu, selectRow.getShinsainNo(),
                    selectRow.getShinsainShimei(), selectRow.getSex(),
                    selectRow.getShikaku(), selectRow.getShinsainKubun(),
                    ddlGichoKubun, ddlSyukketsuKubun, selectRow.getShozokuKikan());
            arrayData.add(row);
        }

        div.getDgShinsakaiShinsainIchiran().setDataSource(arrayData);

//        TextBoxNum iinSu = new TextBoxNum();
//        iinSu.setValue(new Decimal(arrayData.size() + 1));
//        DropDownList ddlGichoKubun = new DropDownList();
//        DropDownList ddlSyukketsuKubun = new DropDownList();
//
//        dgShinsakaiShinsainIchiran_Row row = new dgShinsakaiShinsainIchiran_Row(iinSu, arraySelectData.get(CST_ZERO).getShinsainNo(),
//                arraySelectData.get(CST_ZERO).getShinsainShimei(), arraySelectData.get(CST_ZERO).getSex(),
//                arraySelectData.get(CST_ZERO).getShikaku(), arraySelectData.get(CST_ZERO).getShinsainKubun(),
//                ddlGichoKubun, ddlSyukketsuKubun, arraySelectData.get(CST_ZERO).getShozokuKikan());
//        arrayData.add(row);
//        div.getDgShinsakaiShinsainIchiran().setDataSource(arrayData);
        List<dgShinsakaiIinIchiran_Row> arrayIinData = div.getShinsakaiIinIchiran().getDgShinsakaiIinIchiran().getDataSource();
        List<dgShinsakaiIinIchiran_Row> arrayNewIinData = new ArrayList<>();
        int cntIinsu = 0;
        for (dgShinsakaiIinIchiran_Row iinRow : arrayIinData) {
            int cntSearch = 0;
            for (dgShinsakaiIinIchiran_Row selectRow : arraySelectData) {

                if (iinRow.getShinsainNo().equalsIgnoreCase(selectRow.getShinsainNo())) {
                    cntSearch = ++cntSearch;
                }
            }
            if (cntSearch != 0) {
                continue;
            }
            TextBoxNum iinNewSu = new TextBoxNum();
            cntIinsu = ++cntIinsu;
            iinNewSu.setValue(new Decimal(cntIinsu));
            iinRow.setNumber(iinNewSu);
            arrayNewIinData.add(iinRow);
        }

        div.getShinsakaiIinIchiran().getDgShinsakaiIinIchiran().setDataSource(arrayNewIinData);

        response.data = div;
        return response;
    }

    /**
     * 「審査員を削除する」ボタン押下時の処理を表します。
     *
     * @param div 審査会開催結果入力Div
     * @return ResponseData
     */
    public ResponseData onClick_btnRemoveIin(ShinsakaiKaisaiKekkaDiv div) {
        ResponseData<ShinsakaiKaisaiKekkaDiv> response = new ResponseData<>();

        List<dgShinsakaiIinIchiran_Row> arrayData = div.getShinsakaiIinIchiran().getDgShinsakaiIinIchiran().getDataSource();
        List<dgShinsakaiShinsainIchiran_Row> arraySelectData = div.getDgShinsakaiShinsainIchiran().getSelectedItems();

        for (dgShinsakaiShinsainIchiran_Row selectRow : arraySelectData) {
            TextBoxNum iinSu = new TextBoxNum();
            iinSu.setValue(new Decimal(arrayData.size() + 1));
            dgShinsakaiIinIchiran_Row row = new dgShinsakaiIinIchiran_Row(iinSu, false, selectRow.getShinsainNo(),
                    selectRow.getShimei(), selectRow.getSex(),
                    selectRow.getShikaku(), selectRow.getShozokuKikan(),
                    selectRow.getShinsainKubun());
            arrayData.add(row);
        }

        div.getShinsakaiIinIchiran().getDgShinsakaiIinIchiran().setDataSource(arrayData);

//        TextBoxNum iinSu = new TextBoxNum();
//        iinSu.setValue(new Decimal(arrayData.size() + 1));
//
//        dgShinsakaiIinIchiran_Row row = new dgShinsakaiIinIchiran_Row(iinSu, false, arraySelectData.get(CST_ZERO).getShinsainNo(),
//                arraySelectData.get(CST_ZERO).getShimei(), arraySelectData.get(CST_ZERO).getSex(),
//                arraySelectData.get(CST_ZERO).getShikaku(), arraySelectData.get(CST_ZERO).getShozokuKikan(),
//                arraySelectData.get(CST_ZERO).getShinsainKubun());
//        arrayData.add(row);
//        div.getShinsakaiIinIchiran().getDgShinsakaiIinIchiran().setDataSource(arrayData);
        List<dgShinsakaiShinsainIchiran_Row> arrayIinData = div.getDgShinsakaiShinsainIchiran().getDataSource();
        List<dgShinsakaiShinsainIchiran_Row> arrayNewIinData = new ArrayList<>();
//        DropDownList ddlGichoKubun = new DropDownList();
//        DropDownList ddlSyukketsuKubun = new DropDownList();
        int cntIinsu = 0;
        for (dgShinsakaiShinsainIchiran_Row iinRow : arrayIinData) {
            int cntSearch = 0;
            for (dgShinsakaiShinsainIchiran_Row selectRow : arraySelectData) {

                if (iinRow.getShinsainNo().equalsIgnoreCase(selectRow.getShinsainNo())) {
                    cntSearch = ++cntSearch;
                }
            }
            if (cntSearch != 0) {
                continue;
            }
            TextBoxNum iinNewSu = new TextBoxNum();
            cntIinsu = ++cntIinsu;
            iinNewSu.setValue(new Decimal(cntIinsu));
            iinRow.setNumber(iinNewSu);
            arrayNewIinData.add(iinRow);
        }

        div.getDgShinsakaiShinsainIchiran().setDataSource(arrayNewIinData);

        response.data = div;
        return response;
    }

    private List<dgShinsakaiShinsainIchiran_Row> createRowShinsakaiIchiranTestData() {
        List<dgShinsakaiShinsainIchiran_Row> arrayData = new ArrayList<>();
        List<HashMap> targetSource = YamlLoader.DBE.loadAsList(new RString("dbe5010001/gogitaiIin.yml"));
        int cntIinsu = 0;
        for (Map info : targetSource) {
            cntIinsu = ++cntIinsu;
            arrayData.add(toDgShinsakaiShinsainIchiran_Row(info, cntIinsu));
        }

        return arrayData;
    }

    private dgShinsakaiShinsainIchiran_Row toDgShinsakaiShinsainIchiran_Row(Map map, Integer cntIinsu) {

        TextBoxNum iinSu = new TextBoxNum();
        iinSu.setValue(new Decimal(cntIinsu));
        RString iinCode = _toRString(map.get("審査会委員番号"));
        RString shimei = _toRString(map.get("氏名"));
        RString sex = _toRString(map.get("性別"));
        RString shozoku = _toRString(map.get("所属機関"));
        RString shikaku = _toRString(map.get("資格"));
        RString iinKubun = _toRString(map.get("審査員区分"));

        DropDownList ddlGichoKubun = new DropDownList();

        DropDownList ddlSyukketsuKubun = new DropDownList();

        dgShinsakaiShinsainIchiran_Row row = new dgShinsakaiShinsainIchiran_Row(iinSu, iinCode,
                shimei, sex, shikaku, iinKubun, ddlGichoKubun, ddlSyukketsuKubun, shozoku);
        return row;
    }

    private List<dgShinsakaiIinIchiran_Row> createRowShinsakaiIinIchiranTestData() {
        List<dgShinsakaiIinIchiran_Row> arrayData = new ArrayList<>();
        List<HashMap> targetSource = YamlLoader.DBE.loadAsList(new RString("dbe5010001/shinsain.yml"));
        int cntIinsu = 0;
        for (Map info : targetSource) {
            cntIinsu = ++cntIinsu;
            arrayData.add(toDgShinsakaiIinIchiran_Row(info, cntIinsu));
        }

        return arrayData;
    }

    private dgShinsakaiIinIchiran_Row toDgShinsakaiIinIchiran_Row(Map map, int cntIinsu) {

        TextBoxNum iinSu = new TextBoxNum();
        iinSu.setValue(new Decimal(cntIinsu));
        Boolean muko = false;
        RString mukoKubun = _toRString(map.get("無効"));
        if (mukoKubun.equalsIgnoreCase(new RString("1"))) {
            muko = true;
        }
        RString iinCode = _toRString(map.get("審査会委員番号"));
        RString shimei = _toRString(map.get("氏名"));
        RString sex = _toRString(map.get("性別"));
        RString shozoku = _toRString(map.get("所属機関"));
        RString shikaku = _toRString(map.get("資格"));
        RString iinKubun = _toRString(map.get("審査員区分"));

        dgShinsakaiIinIchiran_Row row = new dgShinsakaiIinIchiran_Row(iinSu, muko, iinCode,
                shimei, sex, shikaku, shozoku, iinKubun);
        return row;
    }

    private RString _toRString(Object obj) {
        if (obj == null) {
            return RString.EMPTY;
        }
        return new RString(obj.toString());
    }

}
