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
        return YamlLoader.DBC.loadAsList(new RString("dbc0120000/KyotakuJikoRiyohyoRireki.yml"));
    }

    /**
     * 画面ロード時の処理です。
     *
     * @param panel panel
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
        ServiceRiyohyoRirekiListDiv rirekiList = panel.getKyotakuJikoRiyohyoRirekiList();
        List<dgServiceRiyohyoRirekiList_Row> dgList = rirekiList.getDgServiceRiyohyoRirekiList().getDataSource();
        dgList.clear();
        for (int index = 0; index < 2; index++) {
            dgList.add(create履歴(index));
        }
        Collections.sort(dgList, new DateComparator());
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
        ControlGenerator cg = new ControlGenerator(getYaml().get(index));
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
        return row;
    }
}
