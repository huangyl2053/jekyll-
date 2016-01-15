/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.parentdiv;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者証一括発行Divを制御します。
 *
 * @author N9606 漢那 憲作
 */
public class IkkatsuHakkoTaishoList {

    private static final RString BTN_HAKKO = new RString("btnHakko");

//    /**
//     * 未発行検索条件画面-「一括作成対象を表示する」ボタン押下時の処理を表します。
//     *
//     * @param panel IkkatsuHakkoTaishoListDiv
//     * @return ResponseData
//     */
//    public ResponseData<IkkatsuHakkoTaishoListDiv> onClick_BtnSearchHakkoTaisho(
//            IkkatsuHakkoTaishoListDiv panel) {
//        ResponseData<IkkatsuHakkoTaishoListDiv> response = new ResponseData<>();
//
//        setIkkatsuHakkoTaishoData(panel);
//
//        setSortData(panel);
//
//        panel.setIsOpen(true);
//        panel.getHihokenshashoIkkatsuHakko().getHihokenshaShoShutsuryokuJun().getKaigoChohyoShutsuryokujun()
//                .setCanOpenAndClose(false);
//        panel.getHihokenshashoIkkatsuHakkoList().getHihokenshaShoListShutsuryokuJun().getKaigoChohyoShutsuryokujun().
//                setCanOpenAndClose(false);
//        panel.getHihokenshashoIkkatsuHakko().getHihokenshaShoShutsuryokuJun().
//                getKaigoChohyoShutsuryokujun().setTitle(RString.EMPTY);
//        panel.getHihokenshashoIkkatsuHakkoList().getHihokenshaShoListShutsuryokuJun().
//                getKaigoChohyoShutsuryokujun().setTitle(RString.EMPTY);
//        panel.getHihokenshashoIkkatsuHakko().getHihokenshaShoShutsuryokuJun().
//                getKaigoChohyoShutsuryokujun().setEraseBorder(true);
//        panel.getHihokenshashoIkkatsuHakkoList().getHihokenshaShoListShutsuryokuJun().
//                getKaigoChohyoShutsuryokujun().setEraseBorder(true);
//
//        //「被保険者証を発行する」ボタンを活性化
//        CommonButtonHolder.setDisabledByCommonButtonFieldName(BTN_HAKKO, false);
//
//        response.data = panel;
//        return response;
//
//    }
//
//    /**
//     * 被保険者証一括発行情報画面-「交付日」ロストフォーカス時の処理を表します。
//     *
//     * @param panel IkkatsuHakkoTaishoListDiv
//     * @return ResponseData
//     */
//    public ResponseData<IkkatsuHakkoTaishoListDiv> onBlur_txtKofuDate(IkkatsuHakkoTaishoListDiv panel) {
//        ResponseData<IkkatsuHakkoTaishoListDiv> response = new ResponseData<>();
//
//        if (panel.getDgIkkatsuHakkoTaisho().getSelectedItems().isEmpty()) {
//            CommonButtonHolder.setDisabledByCommonButtonFieldName(BTN_HAKKO, true);
//        } else {
//            if (!panel.getShutsuryokuJoho().getTxtKofuDate().getText().isEmpty()) {
//                CommonButtonHolder.setDisabledByCommonButtonFieldName(BTN_HAKKO, false);
//            } else {
//                CommonButtonHolder.setDisabledByCommonButtonFieldName(BTN_HAKKO, true);
//            }
//        }
//
//        response.data = panel;
//        return response;
//    }
//
//    /**
//     * 被保険者証一括発行情報画面-「一括発行対象者一覧」選択時の処理を表します。
//     *
//     * @param panel IkkatsuHakkoTaishoListDiv
//     * @return ResponseData
//     */
//    public ResponseData<IkkatsuHakkoTaishoListDiv> onSelect_dgIkkatsuHakkoTaisho(IkkatsuHakkoTaishoListDiv panel) {
//        ResponseData<IkkatsuHakkoTaishoListDiv> response = new ResponseData<>();
//
//        if (!panel.getShutsuryokuJoho().getTxtKofuDate().getText().isEmpty()) {
//            CommonButtonHolder.setDisabledByCommonButtonFieldName(BTN_HAKKO, false);
//        } else {
//            CommonButtonHolder.setDisabledByCommonButtonFieldName(BTN_HAKKO, true);
//        }
//
//        response.data = panel;
//        return response;
//    }
//
//    /*
//     *一括発行対象者情報を設定します。
//     */
//    private void setIkkatsuHakkoTaishoData(IkkatsuHakkoTaishoListDiv panel) {
//
//        List<HashMap> ikkatsuHakkoTaishoList = YamlLoader.DBU.loadAsList(
//                new RString("dbu0400011/IkkatsuHakkoTaishoList.yml"));
//
//        List<dgIkkatsuHakkoTaisho_Row> arraydata = createRowIkkatsuHakkoTaishoList(ikkatsuHakkoTaishoList);
//        for (Iterator<dgIkkatsuHakkoTaisho_Row> it = arraydata.iterator(); it.hasNext();) {
//
//            dgIkkatsuHakkoTaisho_Row ikkatsuHakkoTaisho_Row = it.next();
//            ikkatsuHakkoTaisho_Row.setSelected(Boolean.TRUE);
//        }
//        DataGrid grid = panel.getDgIkkatsuHakkoTaisho();
//        grid.setDataSource(arraydata);
//
//        panel.getShutsuryokuJoho().getTxtKofuDate().setValue(FlexibleDate.getNowDate());
//
//    }
//
//    /*
//     *一括発行対象者情報の初期値をセットします。
//     */
//    private List createRowIkkatsuHakkoTaishoList(List<HashMap> ikkatsuHakkoTaishoList) {
//
//        List arrayDataList = new ArrayList();
//
//        for (int i = 0; i < ikkatsuHakkoTaishoList.size(); i++) {
//            HashMap hashMap = ikkatsuHakkoTaishoList.get(i);
//            ControlGenerator ymlData = new ControlGenerator(hashMap);
//
//            RString rsHihoNo = ymlData.getAsRString("hihoNo");
//            RString rsHihokenshaShimei = ymlData.getAsRString("hihokenshaShimei");
//            RString rsShutokubi = ymlData.getAsRString("shutokubi");
//            RString rsHenkobi = ymlData.getAsRString("henkobi");
//            RString rsNinteibi = ymlData.getAsRString("ninteibi");
//            RString rsJuminShubetsu = ymlData.getAsRString("juminShubetsu");
//
//            arrayDataList.add(createRowIkkatsuHakkoTaishoList(
//                    rsHihoNo,
//                    rsHihokenshaShimei,
//                    rsShutokubi,
//                    rsHenkobi,
//                    rsNinteibi,
//                    rsJuminShubetsu
//            ));
//        }
//        return arrayDataList;
//    }
//
//    /*
//     *引数を元にデータグリッド内に挿入する一括発行対象者情報データを作成します。
//     */
//    private dgIkkatsuHakkoTaisho_Row createRowIkkatsuHakkoTaishoList(
//            RString hihoNo,
//            RString hihokenshaShimei,
//            RString shutokubi,
//            RString henkobi,
//            RString ninteibi,
//            RString strJuminShubetsu
//    ) {
//        dgIkkatsuHakkoTaisho_Row rowIkkatsuHakkoTaishoList = new dgIkkatsuHakkoTaisho_Row(
//                hihoNo,
//                hihokenshaShimei,
//                shutokubi,
//                henkobi,
//                ninteibi,
//                strJuminShubetsu
//        );
//        return rowIkkatsuHakkoTaishoList;
//    }
//
//    /*
//     *出力順情報を設定します。
//     */
//    private void setSortData(IkkatsuHakkoTaishoListDiv panel) {
//
//        List<HashMap> sortList = YamlLoader.DBU.loadAsList(
//                new RString("dbu0400011/Sort.yml"));
//
//        HashMap hashMap = sortList.get(0);
//        ControlGenerator ymlData = new ControlGenerator(hashMap);
//
//        panel.getHihokenshashoIkkatsuHakko().getHihokenshaShoShutsuryokuJun().getKaigoChohyoShutsuryokujun().
//                getTxtSort().setValue(ymlData.getAsRString("sort"));
//
////        panel.getHihokenshashoIkkatsuHakko().getHihokenshaShoShutsuryokuJun().getKaigoChohyoShutsuryokujun()
////                .getTxtSortName().setValue(ymlData.getAsRString("sortname"));
////
//        panel.getHihokenshashoIkkatsuHakko().getHihokenshaShoShutsuryokuJun().getKaigoChohyoShutsuryokujun()
//                .getTxtKaiPage().setValue(ymlData.getAsRString("kaipage"));
//
//        hashMap = sortList.get(1);
//        ymlData = new ControlGenerator(hashMap);
//
//        panel.getHihokenshashoIkkatsuHakkoList().getHihokenshaShoListShutsuryokuJun().getKaigoChohyoShutsuryokujun()
//                .getTxtSort().setValue(ymlData.getAsRString("sort"));
//
////        panel.getHihokenshashoIkkatsuHakkoList().getHihokenshaShoListShutsuryokuJun().getKaigoChohyoShutsuryokujun()
////                .getTxtSortName().setValue(ymlData.getAsRString("sortname"));
////
//        panel.getHihokenshashoIkkatsuHakkoList().getHihokenshaShoListShutsuryokuJun().getKaigoChohyoShutsuryokujun()
//                .getTxtKaiPage().setValue(ymlData.getAsRString("kaipage"));
//    }
//
}
