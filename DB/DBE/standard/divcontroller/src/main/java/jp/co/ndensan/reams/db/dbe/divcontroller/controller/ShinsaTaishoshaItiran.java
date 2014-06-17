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
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5030002.ShinsaTaishoshaIchiranDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5030002.dgShinsaTaishoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 審査会審査対象者一覧の情報を編集します。
 *
 * @author N1013 松本直樹
 */
public class ShinsaTaishoshaItiran {

    /**
     * 審査会対象者一覧画面ロード時、一覧DIVの初期値の設定を行います。
     *
     * @param div 審査対象者一覧Div
     * @return ResponseData
     */
    public ResponseData onLoadData(ShinsaTaishoshaIchiranDiv div) {
        ResponseData<ShinsaTaishoshaIchiranDiv> response = new ResponseData<>();

        div.getDgShinsaTaishoshaIchiran().setDataSource(createRowSetaiTestData());
        
        response.data = div;
        return response;
    }

    /**
     * 対象者一覧データグリッド上で、選択行の選択ボタン押下時の設定処理を行います。
     *
     * @param div 審査対象者一覧Div
     * @return ResponseData
     */
    public ResponseData onClickNyuryoku(ShinsaTaishoshaIchiranDiv div) {
        ResponseData<ShinsaTaishoshaIchiranDiv> response = new ResponseData<>();

        response.data = div;
        return response;
    }

    /**
     * 認定審査結果入力Div上の登録ボタン押下時の処理を表します。
     *
     * @param div 審査対象者一覧Div
     * @return ResponseData
     */
    public ResponseData onClick_btnToroku(ShinsaTaishoshaIchiranDiv div) {
        ResponseData<ShinsaTaishoshaIchiranDiv> response = new ResponseData<>();

        RString nijiHantei = (RString) ViewStateHolder.get("二次判定結果", RString.class);
        RString nijiHanteiCd = (RString) ViewStateHolder.get("二次判定コード", RString.class);
        RString yukoTsukisu = (RString) ViewStateHolder.get("認定月数", RString.class);
        RString yukoTsukisuCd = (RString) ViewStateHolder.get("認定月数コード", RString.class);
        FlexibleDate yukoStartDate = (FlexibleDate) ViewStateHolder.get("有効開始日", FlexibleDate.class);
        FlexibleDate yukoEndDate = (FlexibleDate) ViewStateHolder.get("有効終了日", FlexibleDate.class);
        RString hihoNo = (RString) ViewStateHolder.get("被保番号", RString.class);
        RString iken = (RString) ViewStateHolder.get("審査会意見", RString.class);

        List<dgShinsaTaishoshaIchiran_Row> arrayData = div.getDgShinsaTaishoshaIchiran().getSelectedItems();
        for (dgShinsaTaishoshaIchiran_Row list : arrayData) {
            if (list.getHihokenshaNo().equalsIgnoreCase(hihoNo)) {
                list.setNinteiResult(nijiHantei);
                list.setYukoKikan(yukoTsukisu);
                list.getYukoStartDate().setValue(yukoStartDate);
                list.getYukoEndDate().setValue(yukoEndDate);
                list.setYukoKikanItem(yukoTsukisuCd);
                list.setNinteiResultItem(nijiHanteiCd);
                list.setShinsakaiIken(iken);
            }
        }

        response.data = div;
        return response;
    }

    /*
     個人情報の初期値のテストデータです。
     */
    private List<dgShinsaTaishoshaIchiran_Row> createRowSetaiTestData() {
        List<dgShinsaTaishoshaIchiran_Row> arrayData = new ArrayList<>();
        List<HashMap> targetSource = YamlLoader.DBE.loadAsList(new RString("dbe5030002/ShinsaTaishoIchiranList.yml"));
        for (Map info : targetSource) {
            arrayData.add(toDgShinsaTaishoshaIchiran_Row(info));
        }

        return arrayData;
    }

    private dgShinsaTaishoshaIchiran_Row toDgShinsaTaishoshaIchiran_Row(Map map) {
        ControlGenerator cg = new ControlGenerator(map);
        RString no = cg.getAsRString("Ｎｏ");
        RString shichoson = cg.getAsRString("市町村");
        RString hokenshaNo = cg.getAsRString("保険者番号");
        RString hihoban = cg.getAsRString("被保番号");
        RString shimei = cg.getAsRString("氏名");
        RString kanaShimei = cg.getAsRString("カナ氏名");
        RString sex = cg.getAsRString("性別");
        TextBoxFlexibleDate shinseiDate = cg.getAsTextBoxFlexibleDate("申請日");
        RString zenYokaigodo = cg.getAsRString("前回要介護度");
        RString zenYukokikan = cg.getAsRString("前回有効期間");
        TextBoxFlexibleDate zenStartDate = cg.getAsTextBoxFlexibleDate("前回有効期間開始日");
        TextBoxFlexibleDate zenEndDate = cg.getAsTextBoxFlexibleDate("前回有効期間終了日");
        RString ichijiHantei = cg.getAsRString("一次判定結果");
        RString shinseiKubun = cg.getAsRString("申請区分");
        RString seinenGappi = cg.getAsRString("生年月日");
        RString nenrei = cg.getAsRString("年齢");

        TextBoxFlexibleDate startDate = toTextBoxFlexibleDate(new FlexibleDate(RString.EMPTY));
        TextBoxFlexibleDate endDate = toTextBoxFlexibleDate(new FlexibleDate(RString.EMPTY));
        Button btn = new Button();
        dgShinsaTaishoshaIchiran_Row row = new dgShinsaTaishoshaIchiran_Row(btn, no, hokenshaNo, shichoson,
                hihoban, shimei, kanaShimei, sex, shinseiDate, zenYokaigodo, zenYukokikan, zenStartDate, zenEndDate, ichijiHantei,
                RString.EMPTY, RString.EMPTY, startDate, endDate, shinseiKubun, seinenGappi, nenrei, RString.EMPTY,
                RString.EMPTY, RString.EMPTY);
        return row;
    }

    private TextBoxFlexibleDate toTextBoxFlexibleDate(FlexibleDate date) {
        TextBoxFlexibleDate txtBox = new TextBoxFlexibleDate();
        txtBox.setValue(date);
        return txtBox;
    }

}
