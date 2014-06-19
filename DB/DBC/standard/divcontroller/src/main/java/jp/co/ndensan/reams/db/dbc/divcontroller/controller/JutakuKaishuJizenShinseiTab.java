/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuJizenShinseiTabDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgJutakuKaishuJizenShinseiDetail_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.KozaPayment;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.ShinseishaInfo;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ダイアログで住宅改修費事前申請を表示する共有子Divです。
 *
 * @author N3317 塚田 萌
 */
public class JutakuKaishuJizenShinseiTab {

    /**
     * ダイアログボタンを押し、divが読み込まれた時の処理です。
     *
     * @param panel JutakuKaishuJizenShinseiTabDiv
     * @return response
     */
    public ResponseData<JutakuKaishuJizenShinseiTabDiv> onLoad(JutakuKaishuJizenShinseiTabDiv panel) {
        ResponseData<JutakuKaishuJizenShinseiTabDiv> response = new ResponseData<>();

        set住宅改修申請内容(panel);
        set住宅改修申請結果(panel);

        response.data = panel;
        return response;
    }

    private void set住宅改修申請内容(JutakuKaishuJizenShinseiTabDiv panel) {
        int rowId = 0;
        ShinseishaInfo.setData(panel.getTabJizenShinsei().getTplJizenShinseiContents().getJutakuKaishuJizenShinseisha(), rowId);
        KozaPayment.setData(panel.getTabJizenShinsei().getTplJizenShinseiContents().getJutakuKaishuJizenShinseiKoza(), rowId);
        set住宅改修明細List(panel);

        List<HashMap> targetSource = YamlLoader.DBC.loadAsList(new RString("JutakuKaishuShinsei.yml"));
        ControlGenerator cg = new ControlGenerator(targetSource.get(0));

        panel.getTabJizenShinsei().getTplJizenShinseiContents().getTxtJutakuOwner().setValue(cg.getAsRString("jutakuOwner"));
        panel.getTabJizenShinsei().getTplJizenShinseiContents().getTxtRelationWithHihokensha().setValue(cg.getAsRString("relationWithHihokensha"));

        panel.getTabJizenShinsei().getTplJizenShinseiContents().getJutakuKaishuJizenShinseiReason()
                .getTxtCreateDate().setValue(cg.getAsRDate("createDate"));
        panel.getTabJizenShinsei().getTplJizenShinseiContents().getJutakuKaishuJizenShinseiReason()
                .getTxtCreatorKanaName().setValue(cg.getAsRString("creatorKanaName"));
        panel.getTabJizenShinsei().getTplJizenShinseiContents().getJutakuKaishuJizenShinseiReason()
                .getTxtCreatorName().setValue(cg.getAsRString("creatorName"));
        panel.getTabJizenShinsei().getTplJizenShinseiContents().getJutakuKaishuJizenShinseiReason()
                .getTxtCreationJigyoshaNo().setValue(cg.getAsRString("creationJigyoshaNo"));
        panel.getTabJizenShinsei().getTplJizenShinseiContents().getJutakuKaishuJizenShinseiReason()
                .getTxtCreationJigyoshaName().setValue(cg.getAsRString("creationJigyoshaName"));
    }

    private void set住宅改修申請結果(JutakuKaishuJizenShinseiTabDiv panel) {
        List<HashMap> targetSource = YamlLoader.DBC.loadAsList(new RString("JutakuKaishuShinsei.yml"));
        ControlGenerator cg = new ControlGenerator(targetSource.get(0));

        panel.getTabJizenShinsei().getTplJizenShinseiResult().getJutakuKaishuJizenShinseiKyufugakuSummary()
                .getTblSeikyuSummary().getTxtHiyoTotalMae().setValue(cg.getAsDecimal("費用額合計前"));
        panel.getTabJizenShinsei().getTplJizenShinseiResult().getJutakuKaishuJizenShinseiKyufugakuSummary()
                .getTblSeikyuSummary().getTxtHokenTaishoHiyoMae().setValue(cg.getAsDecimal("対象費用額前"));
        panel.getTabJizenShinsei().getTplJizenShinseiResult().getJutakuKaishuJizenShinseiKyufugakuSummary()
                .getTblSeikyuSummary().getTxtHokenKyufuAmountMae().setValue(cg.getAsDecimal("給付額前"));
        panel.getTabJizenShinsei().getTplJizenShinseiResult().getJutakuKaishuJizenShinseiKyufugakuSummary()
                .getTblSeikyuSummary().getTxtRiyoshaFutanAmountMae().setValue(cg.getAsDecimal("利用者負担額前"));

        panel.getTabJizenShinsei().getTplJizenShinseiResult().getJutakuKaishuJizenShinseiKyufugakuSummary()
                .getTblSeikyuSummary().getTxtHiyoTotalNow().setValue(cg.getAsDecimal("費用額合計後"));
        panel.getTabJizenShinsei().getTplJizenShinseiResult().getJutakuKaishuJizenShinseiKyufugakuSummary()
                .getTblSeikyuSummary().getTxtHokenTaishoHiyoNow().setValue(cg.getAsDecimal("対象費用額後"));
        panel.getTabJizenShinsei().getTplJizenShinseiResult().getJutakuKaishuJizenShinseiKyufugakuSummary()
                .getTblSeikyuSummary().getTxtHokenKyufuAmountNow().setValue(cg.getAsDecimal("給付額後"));
        panel.getTabJizenShinsei().getTplJizenShinseiResult().getJutakuKaishuJizenShinseiKyufugakuSummary()
                .getTblSeikyuSummary().getTxtRiyoshaFutanAmountNow().setValue(cg.getAsDecimal("利用者負担額後"));

        panel.getTabJizenShinsei().getTplJizenShinseiResult().getTxtJudgeDate().setValue(cg.getAsRDate("judgeDate"));
        panel.getTabJizenShinsei().getTplJizenShinseiResult().getRadJudgeKubun().setSelectedItem(cg.getAsRString("judgeKubun"));
        panel.getTabJizenShinsei().getTplJizenShinseiResult().getTxtShoninCondition().setValue(cg.getAsRString("shoninCondition"));
    }

    private void set住宅改修明細List(JutakuKaishuJizenShinseiTabDiv panel) {
        panel.getTabJizenShinsei().getTplJizenShinseiContents().getJutakuKaishuZizenShinseiDetail()
                .getDgJutakuKaishuJizenShinseiDetail().setDataSource(get住宅改修明細List());
    }

    private List<dgJutakuKaishuJizenShinseiDetail_Row> get住宅改修明細List() {
        List<dgJutakuKaishuJizenShinseiDetail_Row> list = new ArrayList<>();
        List<HashMap> targetSource = YamlLoader.DBC.loadAsList(new RString("JutakuKaishuDetailList.yml"));
        for (Map info : targetSource) {
            list.add(toDgJutakuKaishuJizenShinseiDetail_Row(info));
        }
        return list;
    }

    private static dgJutakuKaishuJizenShinseiDetail_Row toDgJutakuKaishuJizenShinseiDetail_Row(Map map) {
        ControlGenerator cg = new ControlGenerator(map);

        dgJutakuKaishuJizenShinseiDetail_Row row = new dgJutakuKaishuJizenShinseiDetail_Row(
                cg.getAsTextBoxDate("chakkoDueDate"),
                cg.getAsTextBoxDate("kanseiDueDate"),
                cg.getAsTextBoxNum("estimatedAmount"),
                cg.getAsRString("kaishuJigyoshaName"),
                cg.getAsRString("kaishuTaishoAddress"),
                cg.getAsRString("kaishuContents"));
        return row;
    }
}
