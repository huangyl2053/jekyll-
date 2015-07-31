/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0120000.KyotakuJikoRiyohyoRirekiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ServiceRiyohyoRirekiList.ServiceRiyohyoRirekiListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ServiceRiyohyoRirekiList.dgServiceRiyohyoRirekiList_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0120000.DBC0120000StateName.利用票登録;

/**
 * 居宅サービス自己作成サービス利用票登録の履歴一覧をコントロールするクラスです。
 *
 * @author N8187 久保田 英男
 */
//TODO n3317塚田　Yamlを使わないように変更する
public class KyotakuJikoRiyohyoRireki {

    /**
     * 画面ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData onLoad(KyotakuJikoRiyohyoRirekiDiv panel) {
        setRirekiList(panel);

        return ResponseData.of(panel).respond();
    }

    public ResponseData onClick_dgSelectButton(KyotakuJikoRiyohyoRirekiDiv panel) {
        return ResponseData.of(panel).setState(利用票登録);
    }

    /**
     * 履歴一覧のデータ設定
     */
    private void setRirekiList(KyotakuJikoRiyohyoRirekiDiv panel) {
        ServiceRiyohyoRirekiListDiv rirekiList = panel.getKyotakuJikoRiyohyoRirekiList();
        List<dgServiceRiyohyoRirekiList_Row> dgList = rirekiList.getDgServiceRiyohyoRirekiList().getDataSource();
        dgList.clear();
        //TODO n3317塚田　遷移させるために空にリストを作成
        dgList.add(new dgServiceRiyohyoRirekiList_Row());
//        for (int index = 0; index < 2; index++) {
//            dgList.add(create履歴(index));
//        }
//        Collections.sort(dgList, new DateComparator());
        rirekiList.getDgServiceRiyohyoRirekiList().setDataSource(dgList);
    }

    /**
     * 履歴一覧の届出日を降順でソートするためのクラス。
     */
    private static class DateComparator implements Comparator<dgServiceRiyohyoRirekiList_Row> {

        @Override
        public int compare(dgServiceRiyohyoRirekiList_Row o1, dgServiceRiyohyoRirekiList_Row o2) {
            return new FlexibleDate(o2.getTxtTodokedeYMD().replace(".", "")).
                    compareTo(new FlexibleDate(o1.getTxtTodokedeYMD().replace(".", "")));
        }
    }

    private dgServiceRiyohyoRirekiList_Row create履歴(int index) {
//        ControlGenerator cg = new ControlGenerator(getYaml().get(index));
        dgServiceRiyohyoRirekiList_Row row = new dgServiceRiyohyoRirekiList_Row(
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY);
//        row.setTxtJotai(cg.getAsRString("状態"));
//        row.setTxtTodokedeYMD(cg.getAsRString("届出日"));
//        row.setTxtTodokedeKubun(cg.getAsRString("届出区分"));
//        row.setTxtTekiyoKaishiYMD(cg.getAsRString("計画適用期間開始日"));
//        row.setTxtTekiyoShuryoYMD(cg.getAsRString("計画適用期間終了日"));
        return row;
    }
}
