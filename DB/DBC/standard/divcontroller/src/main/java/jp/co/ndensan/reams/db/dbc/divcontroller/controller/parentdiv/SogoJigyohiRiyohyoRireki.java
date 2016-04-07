/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ServiceRiyohyoRirekiList.ServiceRiyohyoRirekiListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ServiceRiyohyoRirekiList.dgServiceRiyohyoRirekiList_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.SogoJigyohiRiyohyoRirekiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;

/**
 * 総合事業費サービス利用票登録の履歴一覧のコントロールクラスです。
 *
 * @author N8187 久保田 英男
 */
public class SogoJigyohiRiyohyoRireki {

    /**
     * 画面ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData onLoad(SogoJigyohiRiyohyoRirekiDiv panel) {
        ResponseData<SogoJigyohiRiyohyoRirekiDiv> response = new ResponseData<>();
        setRirekiList(panel);
        response.data = panel;
        return response;
    }

    /**
     * 履歴一覧のデータ設定。
     */
    private void setRirekiList(SogoJigyohiRiyohyoRirekiDiv panel) {
        List<HashMap> sourceList = YamlLoader.FOR_DBC.loadAsList(new RString("SogoJigyohiRiyohyoRireki.yml"));
        ServiceRiyohyoRirekiListDiv rirekiList = panel.getSogoJigyohiRiyohyoRirekiList();
        Button btn = new Button();
        for (HashMap source : sourceList) {
            add履歴(rirekiList, create履歴(
                    btn,
                    "",
                    source.get("届出日Inbisivle").toString(),
                    source.get("届出日").toString(),
                    source.get("届出区分").toString(),
                    source.get("計画適用開始日").toString(),
                    source.get("計画適用終了日").toString(),
                    source.get("計画依頼事業者").toString()));
        }
    }

    private void add履歴(ServiceRiyohyoRirekiListDiv rirekiList, dgServiceRiyohyoRirekiList_Row addRow) {
        List<dgServiceRiyohyoRirekiList_Row> dgList = rirekiList.getDgServiceRiyohyoRirekiList().getDataSource();
        dgList.add(addRow);
        Collections.sort(dgList, new DateComparator());
        rirekiList.getDgServiceRiyohyoRirekiList().setDataSource(dgList);
    }

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

    private dgServiceRiyohyoRirekiList_Row create履歴(Button btn, String txtJotai, String txtTodokedeYMDInvisible, String txtTodokedeYMD,
            String txtTodokedeKubun, String txtTekiyoKaishiYMD, String txtTekiyoShuryoYMD, String txtIraiJigyosha) {
        // TODO 未使用のメソッド引数があります。 Checkstyle 対応。
        btn.hashCode();
        txtTodokedeYMDInvisible.hashCode();

//        TextBoxDate txtBoxTodokedeYMDInvisible = new TextBoxDate();
//        txtBoxTodokedeYMDInvisible.setValue(new RDate(txtTodokedeYMDInvisible));
        return new dgServiceRiyohyoRirekiList_Row(
                new RString(txtJotai),
                //                txtBoxTodokedeYMDInvisible,
                new RString(txtTodokedeYMD),
                new RString(txtTodokedeKubun),
                new RString(txtTekiyoKaishiYMD),
                new RString(txtTekiyoShuryoYMD),
                new RString(txtIraiJigyosha)
        );
    }
}
