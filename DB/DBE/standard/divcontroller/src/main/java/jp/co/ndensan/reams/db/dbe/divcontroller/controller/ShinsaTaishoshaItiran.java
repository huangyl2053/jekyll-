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
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.HihokenshaJohoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.NinteiKekkaNyuryokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.NinteiShinsaKekkaNyuryokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.ShinsaTaishoshaItiranDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.TaishoShinsakaiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgShinsaTaishoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * 審査会審査対象者一覧の情報を編集します。
 *
 * @author N1013 松本直樹
 */
public class ShinsaTaishoshaItiran {

    /**
     *
     * @param div
     * @return
     */
    public ResponseData getOnloadData(ShinsaTaishoshaItiranDiv div) {
        ResponseData<ShinsaTaishoshaItiranDiv> response = new ResponseData<>();

        div.getDgShinsaTaishoshaIchiran().setDataSource(createRowSetaiTestData());

        response.data = div;
        return response;
    }

    public ResponseData onClickNyuryoku(ShinsaTaishoshaItiranDiv taishoshaItiranDiv) {
        ResponseData<ShinsaTaishoshaItiranDiv> response = new ResponseData<>();

        response.data = taishoshaItiranDiv;
        return response;
    }

    /*
     個人情報の初期値のテストデータです。
     */
    private List<dgShinsaTaishoshaIchiran_Row> createRowSetaiTestData() {
        List<dgShinsaTaishoshaIchiran_Row> arrayData = new ArrayList<>();
        List<HashMap> targetSource = YamlLoader.FOR_DBE.loadAsList(new RString("ShinsaTaishoIchiranList.yml"));
        for (Map info : targetSource) {
            arrayData.add(toDgShinsaTaishoshaIchiran_Row(info));
        }

        return arrayData;
    }

    private dgShinsaTaishoshaIchiran_Row toDgShinsaTaishoshaIchiran_Row(Map map) {
        RString shichoson = _toRString(map.get("市町村"));
        RString hokenshaNo = _toRString(map.get("保険者番号"));
        RString hihoban = _toRString(map.get("被保番号"));
        RString shimei = _toRString(map.get("氏名"));
        RString kanaShimei = _toRString(map.get("カナ氏名"));
        RString sex = _toRString(map.get("性別"));
        TextBoxFlexibleDate shinseiDate = toTextBoxFlexibleDate(new FlexibleDate(map.get("申請日").toString()));
        RString zenYokaigodo = _toRString(map.get("前回要介護度"));
        RString zenYukokikan = _toRString(map.get("前回有効期間"));
        TextBoxFlexibleDate zenStartDate = toTextBoxFlexibleDate(new FlexibleDate(map.get("前回有効期間開始日").toString()));
        TextBoxFlexibleDate zenEndDate = toTextBoxFlexibleDate(new FlexibleDate(map.get("前回有効期間終了日").toString()));
        RString ichijiHantei = _toRString(map.get("一次判定結果"));
        RString shinseiKubun = _toRString(map.get("申請区分"));
        RString seinenGappi = _toRString(map.get("生年月日"));
        RString nenrei = _toRString(map.get("年齢"));

        TextBoxFlexibleDate startDate = toTextBoxFlexibleDate(new FlexibleDate("00000000"));
        TextBoxFlexibleDate endDate = toTextBoxFlexibleDate(new FlexibleDate("00000000"));
        Button btn = new Button();
        dgShinsaTaishoshaIchiran_Row row = new dgShinsaTaishoshaIchiran_Row(btn, RString.EMPTY, hokenshaNo, shichoson, hihoban, shimei, kanaShimei,
                sex, shinseiDate, zenYokaigodo, zenYukokikan, zenStartDate, zenEndDate, ichijiHantei, RString.EMPTY, RString.EMPTY, startDate, endDate,
                shinseiKubun, seinenGappi, nenrei);
        return row;
    }

    private RString _toRString(Object obj) {
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
