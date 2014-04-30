/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.HihokenshaJohoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.NinteiKekkaNyuryokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.NinteiShinsaKekkaNyuryokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.ShinsaTaishoshaItiranDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.TaishoShinsakaiIchiranDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgShinsaTaishoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgShinsakaiIchiran_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;

/**
 * 審査結果入力を行う対象審査会を一覧で表示します。
 *
 * @author N1013 松本直樹
 */
public class TaishoShinsakaiIchiran {

    public ResponseData getOnloadData(TaishoShinsakaiIchiranDiv div) {
        ResponseData<TaishoShinsakaiIchiranDiv> response = new ResponseData<>();

        div.getDgShinsakaiIchiran().setDataSource(createRowShinsakaiTestData());

        response.data = div;
        return response;
    }

//    public ResponseData onClickNyuryoku(NinteiShinsaKekkaNyuryokuDiv ShinsaKekkaDiv,
//            ShinsaTaishoshaItiranDiv taishoshaItiranDiv,
//            HihokenshaJohoDiv hihokenshaJohoDiv,
//            NinteiKekkaNyuryokuDiv ninteiKekkaNyuryokuDiv) {
//        ResponseData<NinteiShinsaKekkaNyuryokuDiv> response = new ResponseData<>();
//
//        response.data = ShinsaKekkaDiv;
//        return response;
//    }

    /*
     個人情報の初期値のテストデータです。
     */
    private List<dgShinsakaiIchiran_Row> createRowShinsakaiTestData() {
        List<dgShinsakaiIchiran_Row> arrayData = new ArrayList<>();
        dgShinsakaiIchiran_Row item;

        item = createRowShinsakaiData("第10回", "合01", "電算市役所５階", "2014/05/23", "15：00", "16：30",
                "0/40", "開催未");
        arrayData.add(item);
        item = createRowShinsakaiData("第9回", "合03", "電算市役所４階", "2014/05/20", "15：00", "17：00",
                "0/40", "開催未");
        arrayData.add(item);
        item = createRowShinsakaiData("第8回", "合01", "電算市役所５階", "2014/05/16", "15：00", "17：00",
                "35/40", "開催未");
        arrayData.add(item);
        item = createRowShinsakaiData("第7回", "合03", "電算市役所４階", "2014/05/13", "15：00", "17：00",
                "35/40", "開催未");
        arrayData.add(item);
        item = createRowShinsakaiData("第6回", "合01", "電算市役所５階", "2014/05/09", "15：00", "17：00",
                "38/40", "開催未");
        arrayData.add(item);
        item = createRowShinsakaiData("第5回", "合01", "電算市役所５階", "2014/05/02", "15：00", "16：45",
                "39/40", "開催済み");
        arrayData.add(item);

        return arrayData;
    }

    private dgShinsakaiIchiran_Row createRowShinsakaiData(String 審査会名, String 合議体, String 審査会会場, String 審査開催日,
            String 審査開始, String 審査終了, String 対象人数, String 審査会状況) {

        Button btn = new Button();

        dgShinsakaiIchiran_Row rowShinsakaiData = new dgShinsakaiIchiran_Row(btn,
                RString.HALF_SPACE, RString.FULL_SPACE, RString.HALF_SPACE, RString.HALF_SPACE, RString.HALF_SPACE,
                RString.HALF_SPACE, RString.HALF_SPACE, RString.HALF_SPACE);

        rowShinsakaiData.set審査会名(new RString(審査会名));
        rowShinsakaiData.set合議体(new RString(合議体));
        rowShinsakaiData.set審査会会場(new RString(審査会会場));
        rowShinsakaiData.set審査開催日(new RString(審査開催日));
        rowShinsakaiData.set審査開始(new RString(審査開始));
        rowShinsakaiData.set審査終了(new RString(審査終了));
        rowShinsakaiData.set対象人数(new RString(対象人数));
        rowShinsakaiData.set審査会状況(new RString(審査会状況));

        return rowShinsakaiData;
    }

}
