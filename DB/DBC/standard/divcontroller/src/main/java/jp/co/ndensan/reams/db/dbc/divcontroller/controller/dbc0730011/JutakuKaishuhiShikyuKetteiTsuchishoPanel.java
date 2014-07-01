/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.dbc0730011;

import static java.lang.Integer.parseInt;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuhiShikyuKetteiTsuchishoPanelDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;

/**
 * 住宅改修費支給申請決定 審査済支給申請検索条件
 *
 * @author n8223
 */
public class JutakuKaishuhiShikyuKetteiTsuchishoPanel {

    public ResponseData<JutakuKaishuhiShikyuKetteiTsuchishoPanelDiv> onClick_btnSearchShinsazumi(
            JutakuKaishuhiShikyuKetteiTsuchishoPanelDiv panel) {
        ResponseData<JutakuKaishuhiShikyuKetteiTsuchishoPanelDiv> response = new ResponseData<>();

        //TO DO ヘッダーに配置された出力チェックボックスが選択されているかどうかの確認や設定が行えます。
        panel.setIsOpen(false);
        panel.setIsPublish(false);

        setPaymentDateOutputOrderForTsuchisho(panel);
        response.data = panel;
        return response;

    }

    private void setPaymentDateOutputOrderForTsuchisho(JutakuKaishuhiShikyuKetteiTsuchishoPanelDiv panel) {

        int yamlNo = 1;
        String ymlDataName = "ReportPublish.yml";
        List<HashMap> ymlData = ymlData(ymlDataName);

        //　発行日の初期値を設定する。
        panel.getJutakuKaishuhiShikyuKetteiTsuchishoHakkoDate().getTxtIssueDate().setValue(RDate.getNowDate());

        //デモでは初期値を表示しない
//        setPaymentInfo(panel);
        //　出力順序・改頁の情の初期値を設定する。
        panel.getJutakuKaishuhiShikyuKetteiTsuchishoOutputOrder().getKaigoChohyoShutsuryokujun().getTxtSortName()
                .setValue(new RString(ymlData.get(yamlNo).get("出力順名").toString()));
        panel.getJutakuKaishuhiShikyuKetteiTsuchishoOutputOrder().getKaigoChohyoShutsuryokujun().getTxtKaiPage()
                .setValue(new RString(ymlData.get(yamlNo).get("改頁").toString()));
        panel.getJutakuKaishuhiShikyuKetteiTsuchishoOutputOrder().getKaigoChohyoShutsuryokujun().getTxtSort()
                .setValue(new RString(ymlData.get(yamlNo).get("出力順").toString()));
    }

    private void setPaymentInfo(JutakuKaishuhiShikyuKetteiTsuchishoPanelDiv panel) {
        List<HashMap> targetSource = YamlLoader.DBC.loadAsList(new RString("TsuchishoPaymentInfo.yml"));
        ControlGenerator cg = new ControlGenerator(targetSource.get(0));

        panel.getJutakuKaishuhiShikyuKetteiTsuchishoPaymentMethod().getPayToKoza().getTxtKozaPaymentDate()
                .setValue(cg.getAsRDate("口座払い日"));

        panel.getJutakuKaishuhiShikyuKetteiTsuchishoPaymentMethod().getPayToMadoguchi().getTxtShiharaiBasho()
                .setValue(cg.getAsRString("窓口払場所"));
        panel.getJutakuKaishuhiShikyuKetteiTsuchishoPaymentMethod().getPayToMadoguchi().getTxtShiharaiDateRange()
                .setFromValue(cg.getAsRDate("窓口払開始日"));
        panel.getJutakuKaishuhiShikyuKetteiTsuchishoPaymentMethod().getPayToMadoguchi().getTxtShiharaiDateRange()
                .setToValue(cg.getAsRDate("窓口払終了日"));

        List<RString> time = cg.getAsRString("窓口払開始時間").split(":");
        int hour = parseInt(time.get(0).toString());
        int minute = parseInt(time.get(1).toString());
        panel.getJutakuKaishuhiShikyuKetteiTsuchishoPaymentMethod().getPayToMadoguchi().getTxtShiharaiKaishiTime()
                .setValue(RTime.of(hour, minute));

        time = cg.getAsRString("窓口払終了時間").split(":");
        hour = parseInt(time.get(0).toString());
        minute = parseInt(time.get(1).toString());
        panel.getJutakuKaishuhiShikyuKetteiTsuchishoPaymentMethod().getPayToMadoguchi().getTxtShiharaiShuryoTime()
                .setValue(RTime.of(hour, minute));
    }

    private List<HashMap> ymlData(String ymlDataName) {
        return YamlLoader.DBZ.loadAsList(new RString(ymlDataName));
    }
}
