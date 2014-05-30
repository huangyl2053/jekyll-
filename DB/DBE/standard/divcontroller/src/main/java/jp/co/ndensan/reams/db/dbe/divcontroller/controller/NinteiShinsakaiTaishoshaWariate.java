/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4060001.NinteiShinsakaiTaishoshaWariateDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4060001.NinteiShinsakaiIchiranDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 審査会対象者個別割当Divを制御します。
 *
 * @author N9606 漢那 憲作
 */
public class NinteiShinsakaiTaishoshaWariate {

    /**
     * 審査会一覧データグリッド上の審査会選択時の処理を表します。
     *
     * @param panel IkenshoShosaiMainDiv
     * @param panel2 ShujiiIkenshoImageTorikomiDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinsakaiTaishoshaWariateDiv> dispNinteiShinsakaiTaishoshaWariate(
            NinteiShinsakaiTaishoshaWariateDiv panel, NinteiShinsakaiIchiranDiv panel2) {
        ResponseData<NinteiShinsakaiTaishoshaWariateDiv> response = new ResponseData<>();
        int iSelectId = panel2.getDgNinteiShinsakaiIchiran().getClickedRowId();
        setNinteiShinsakaiTaishoshaWariateData(panel, panel2, iSelectId);

        response.data = panel;
        return response;

    }

    /*
     *認定審査会対象者割当詳細情報を取得します。
     */
    private void setNinteiShinsakaiTaishoshaWariateData(
            NinteiShinsakaiTaishoshaWariateDiv panel, NinteiShinsakaiIchiranDiv panel2, int iSelectId) {

        //List<HashMap> NinteiShinsakaiTaishoshaWariate = YamlLoader.FOR_DBE.loadAsList(new RString("dbe4060001/NinteiShinsakaiTaishoshaWariate.yml"));
        //HashMap hashMap = NinteiShinsakaiTaishoshaWariate.get(iSelectId);
//        String strHokenshaNo = (String) hashMap.get("hokenshaNo");
        panel.getNinteiShinsakaiJoho().getTxtShinsakaiYoteibi().setValue(new RDate(
                panel2.getDgNinteiShinsakaiIchiran().getActiveRow().getYoteibi().toString()));

        panel.getNinteiShinsakaiJoho().getTxtGogitaiNo().setValue(
                panel2.getDgNinteiShinsakaiIchiran().getActiveRow().getGogitaiNo());

        panel.getNinteiShinsakaiJoho().getTxtGogitaiMeisho().setValue(
                panel2.getDgNinteiShinsakaiIchiran().getActiveRow().getGogitaiMeisho());

        panel.getNinteiShinsakaiJoho().getTxtKaishiYoteiJikan().setValue(
                RTime.parse(panel2.getDgNinteiShinsakaiIchiran().getActiveRow().getKaishiJikan().toString()));

        panel.getNinteiShinsakaiJoho().getTxtShuryoYoteiJikan().setValue(
                RTime.parse(panel2.getDgNinteiShinsakaiIchiran().getActiveRow().getShuryoJikan().toString()));

        panel.getNinteiShinsakaiJoho().getTxtSaidaiTeiin().setValue(new Decimal(50));

        panel.getNinteiShinsakaiJoho().getTxtYoteiTeiin().setValue(
                new Decimal(panel2.getDgNinteiShinsakaiIchiran().getActiveRow().getYoteiTeiin().toString()));

        List<KeyValueDataSource> dataSource = new ArrayList<>();
        dataSource.add(new KeyValueDataSource(new RString("1"), new RString("ダミー区分")));
        panel.getNinteiShinsakaiJoho().getChkDummyKbn().setSelectedItems(dataSource);

        List<KeyValueDataSource> dataSource1 = new ArrayList<>();
        dataSource.add(new KeyValueDataSource(new RString("1"), new RString("休会区分")));
        panel.getNinteiShinsakaiJoho().getChkKyukaiKbn().setSelectedItems(dataSource1);

//        panel.getKihonJoho().getTxtHokenNo().setValue(new RString(strHokenshaNo));
    }

}
