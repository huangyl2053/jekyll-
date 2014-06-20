/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0120000.KyotakuJikoRiyohyoRirekiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceRiyohyoRirekiList.ServiceRiyohyoRirekiListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceRiyohyoRirekiList.dgServiceRiyohyoRirekiList_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;

/**
 * 居宅サービス自己作成サービス利用票登録の履歴一覧をコントロールするクラスです。
 *
 * @author N8187 久保田 英男
 */
public class KyotakuJikoRiyohyoRireki {

    private List<HashMap> getYaml() {
        return YamlLoader.FOR_DBC.loadAsList(new RString("dbc0120000/KyotakuJikoRiyohyoRireki.yml"));
    }

    /**
     * 画面ロード時の処理です。
     *
     * @param panel 履歴一覧
     * @return ResponseData
     */
    public ResponseData onLoad(KyotakuJikoRiyohyoRirekiDiv panel) {
        ResponseData<KyotakuJikoRiyohyoRirekiDiv> response = new ResponseData<>();
        setRirekiList(panel);
        response.data = panel;
        return response;
    }

    /**
     * 履歴一覧のデータ設定
     */
    private void setRirekiList(KyotakuJikoRiyohyoRirekiDiv panel) {
//        Button btn = new Button();
        ServiceRiyohyoRirekiListDiv rirekiList = panel.getKyotakuJikoRiyohyoRirekiList();
//        add履歴(rirekiList, create履歴(btn, "", "20140601", "平26.06.01", "変更", "平26.06.01", "", "1111111111:電算介護調査センター"));
//        add履歴(rirekiList, create履歴(btn, "", "20130501", "平25.05.01", "新規", "平25.05.01", "平26.04.30", "1111111111:電算介護調査センター"));
        List<dgServiceRiyohyoRirekiList_Row> dgList = rirekiList.getDgServiceRiyohyoRirekiList().getDataSource();
        dgList.clear();
        for (int index = 0; index < 2; index++) {
            dgList.add(create履歴(index));
        }
//
//        dgList.add(addRow);
        Collections.sort(dgList, new DateComparator());
        rirekiList.getDgServiceRiyohyoRirekiList().setDataSource(dgList);
    }

//    private void add履歴(ServiceRiyohyoRirekiListDiv rirekiList, dgServiceRiyohyoRirekiList_Row addRow) {
//        List<dgServiceRiyohyoRirekiList_Row> dgList = rirekiList.getDgServiceRiyohyoRirekiList().getDataSource();
//        dgList.add(addRow);
//        Collections.sort(dgList, new DateComparator());
//        rirekiList.getDgServiceRiyohyoRirekiList().setDataSource(dgList);
////        SearchResultOfHihokenshaDiv hihokensha = panel.getKyotakuKeikakuTodokedeHihokenshaList();
////        List<dgSearchResult_Row> dgList = hihokensha.getDgSearchResult().getDataSource();
////        dgList.clear();
////        for (int index = 1; index < 3; index++) {
////            dgList.add(createHihokenshaData(index));
////        }
////        hihokensha.getDgSearchResult().setDataSource(dgList);
//    }
    /**
     * 履歴一覧の届出日を降順でソートするためのクラス。
     */
//    private static class DateComparator implements Comparator<dgServiceRiyohyoRirekiList_Row> {
//
//        @Override
//        public int compare(dgServiceRiyohyoRirekiList_Row o1, dgServiceRiyohyoRirekiList_Row o2) {
//            return o2.getTxtTodokedeYMDInvisible().getValue().compareTo(o1.getTxtTodokedeYMDInvisible().getValue());
//        }
//    }
    private static class DateComparator implements Comparator<dgServiceRiyohyoRirekiList_Row> {

        @Override
        public int compare(dgServiceRiyohyoRirekiList_Row o1, dgServiceRiyohyoRirekiList_Row o2) {
            return new FlexibleDate(o2.getTxtTodokedeYMD().replace(".", "")).
                    compareTo(new FlexibleDate(o1.getTxtTodokedeYMD().replace(".", "")));
        }
    }

//    private dgServiceRiyohyoRirekiList_Row create履歴(Button btn, String txtJotai, String txtTodokedeYMDInvisible, String txtTodokedeYMD,
//            String txtTodokedeKubun, String txtTekiyoKaishiYMD, String txtTekiyoShuryoYMD, String txtIraiJigyosha) {
    private dgServiceRiyohyoRirekiList_Row create履歴(int index) {
        ControlGenerator cg = new ControlGenerator(getYaml().get(index));
//    public dgServiceRiyohyoRirekiList_Row(Button btnSelect, RString txtJotai,
//        RString txtTodokedeYMD, RString txtTodokedeKubun,
//        RString txtTekiyoKaishiYMD, RString txtTekiyoShuryoYMD, RString txtIraiJigyosha) {
        dgServiceRiyohyoRirekiList_Row row = new dgServiceRiyohyoRirekiList_Row(
                new Button(),
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY);
        row.setTxtJotai(cg.getAsRString("状態"));
        row.setTxtTodokedeYMD(cg.getAsRString("届出日"));
        row.setTxtTodokedeKubun(cg.getAsRString("届出区分"));
        row.setTxtTekiyoKaishiYMD(cg.getAsRString("計画適用期間開始日"));
        row.setTxtTekiyoShuryoYMD(cg.getAsRString("計画適用期間終了日"));
//  状態: !!str ""
//  届出日: "平26.06.01"
//  届出区分: !!str "変更"
//  計画適用期間開始日: !!str "平26.06.01"
//  計画適用期間終了日: !!str ""
        return row;

//        TextBoxDate txtBoxTodokedeYMDInvisible = new TextBoxDate();
//        txtBoxTodokedeYMDInvisible.setValue(new RDate(txtTodokedeYMDInvisible));
//        return new dgServiceRiyohyoRirekiList_Row(
//                btn,
//                new RString(txtJotai),
//                //                txtBoxTodokedeYMDInvisible,
//                new RString(txtTodokedeYMD),
//                new RString(txtTodokedeKubun),
//                new RString(txtTekiyoKaishiYMD),
//                new RString(txtTekiyoShuryoYMD),
//                new RString(txtIraiJigyosha)
//        );
    }
}
