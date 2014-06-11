/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0410011.HihokenshashoHakkoJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.dgShuruiShikyuGendoKijunGaku_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 被保険者証発行情報Divを制御します。
 *
 * @author N9606 漢那 憲作
 */
public class HihokenshashoHakkoJoho {

    /**
     * 被保険者証発行該当者一覧画面-「選択」ボタン押下時の処理を表します。
     *
     * @param panel HihokenshashoHakkoJohoDiv
     * @return ResponseData
     */
    public ResponseData<HihokenshashoHakkoJohoDiv> dispHihokenshashoJoho(
            HihokenshashoHakkoJohoDiv panel) {
        ResponseData<HihokenshashoHakkoJohoDiv> response = new ResponseData<>();

        List<HashMap> hihokenshashoHakkoJohoList = YamlLoader.FOR_DBU.loadAsList(
                new RString("dbu0410011/HihokenshashoHakkoJoho.yml"));

        HashMap hashMap = hihokenshashoHakkoJohoList.get(0);
        ControlGenerator ymlData = new ControlGenerator(hashMap);

        //被保険者証発行情報
        panel.getHihokenshashoHakkoShosaiJoho().getTxtKofuDate().setValue(FlexibleDate.getNowDate());
        panel.getHihokenshashoHakkoShosaiJoho().getDdlKofuJiyu().setSelectedItem(ymlData.getAsRString("kofujiyu"));
        panel.getHihokenshashoHakkoShosaiJoho().getTxtHokensha().setValue(ymlData.getAsRString("hokensha"));
        panel.getHihokenshashoHakkoShosaiJoho().getTxtYokaigodo().setValue(ymlData.getAsRString("yokaigodo"));
        panel.getHihokenshashoHakkoShosaiJoho().getTxtYukoKigen().setValue(
                ymlData.getAsTextBoxFlexibleDate("yukokigen").getValue());

        panel.getHihokenshashoHakkoShosaiJoho().getTxtNinteiYukoKikan().setFromValue(
                ymlData.getAsTextBoxDate("yukokikanfrom").getValue());

        panel.getHihokenshashoHakkoShosaiJoho().getTxtNinteiYukoKikan().setToValue(
                ymlData.getAsTextBoxDate("yukokikanto").getValue());

        panel.getHihokenshashoHakkoShosaiJoho().getTxtShinseiDate().setValue(
                ymlData.getAsTextBoxFlexibleDate("shinseibi").getValue());

        //限度額タブ内情報
        hashMap = hihokenshashoHakkoJohoList.get(1);
        ymlData = new ControlGenerator(hashMap);

        panel.getHihokenshashoHakkoShosaiJoho().getTabHihokenshaShikakuShosai().getTplGendoGaku().
                getTxtKubunShikyuGendoKijunGaku().setValue(ymlData.getAsTextBoxNum("kijungaku").getValue());

        panel.getHihokenshashoHakkoShosaiJoho().getTabHihokenshaShikakuShosai().getTplGendoGaku().
                getTxtKyuhuYukoKikan().setFromValue(ymlData.getAsTextBoxDate("yukokikanfrom").getValue());

        panel.getHihokenshashoHakkoShosaiJoho().getTabHihokenshaShikakuShosai().getTplGendoGaku().
                getTxtKyuhuYukoKikan().setToValue(ymlData.getAsTextBoxDate("yukokikanto").getValue());

        List<dgShuruiShikyuGendoKijunGaku_Row> arraydata = new ArrayList<>();
        if (!ymlData.getAsRString("shuruishikyusu").toString().equals("0")) {
            arraydata = createRowShuruiShikyuGendoKijunGaku(ymlData, Integer.parseInt(ymlData.getAsRString("shuruishikyusu").toString()));
        }
        panel.getHihokenshashoHakkoShosaiJoho().getTabHihokenshaShikakuShosai().getTplGendoGaku().
                getShuruiShikyuGendoKijungaku().getDgShuruiShikyuGendoKijunGaku().
                setDataSource(arraydata);

        //審査会意見情報
        hashMap = hihokenshashoHakkoJohoList.get(2);
        ymlData = new ControlGenerator(hashMap);

        panel.getHihokenshashoHakkoShosaiJoho().getTabHihokenshaShikakuShosai().
                getTplShinsakaiIken().getTxtShinsakaiIken().
                setValue(ymlData.getAsRString("shinsakaiiken"));

        //給付制限情報
        hashMap = hihokenshashoHakkoJohoList.get(3);
        ymlData = new ControlGenerator(hashMap);

        panel.getHihokenshashoHakkoShosaiJoho().getTabHihokenshaShikakuShosai().
                getTplKyufuSeigen().getTblKyuhuSeigen().getTxtKyufuSeigenNaiyo1().
                setValue(ymlData.getAsRString("seigennaiyo1"));

        panel.getHihokenshashoHakkoShosaiJoho().getTabHihokenshaShikakuShosai().
                getTplKyufuSeigen().getTblKyuhuSeigen().getTxtKyufuSeigenNaiyo2().
                setValue(ymlData.getAsRString("seigennaiyo2"));

        panel.getHihokenshashoHakkoShosaiJoho().getTabHihokenshaShikakuShosai().
                getTplKyufuSeigen().getTblKyuhuSeigen().getTxtKyufuSeigenNaiyo3().
                setValue(ymlData.getAsRString("seigennaiyo3"));

        panel.getHihokenshashoHakkoShosaiJoho().getTabHihokenshaShikakuShosai().
                getTplKyufuSeigen().getTblKyuhuSeigen().getTxtKyufuSeigenKikan1().
                setFromValue(ymlData.getAsTextBoxDate("seigenkikanfrom1").getValue());

        panel.getHihokenshashoHakkoShosaiJoho().getTabHihokenshaShikakuShosai().
                getTplKyufuSeigen().getTblKyuhuSeigen().getTxtKyufuSeigenKikan2().
                setFromValue(ymlData.getAsTextBoxDate("seigenkikanfrom2").getValue());

        panel.getHihokenshashoHakkoShosaiJoho().getTabHihokenshaShikakuShosai().
                getTplKyufuSeigen().getTblKyuhuSeigen().getTxtKyufuSeigenKikan3().
                setFromValue(ymlData.getAsTextBoxDate("seigenkikanfrom3").getValue());

        panel.getHihokenshashoHakkoShosaiJoho().getTabHihokenshaShikakuShosai().
                getTplKyufuSeigen().getTblKyuhuSeigen().getTxtKyufuSeigenKikan1().
                setToValue(ymlData.getAsTextBoxDate("seigenkikanto1").getValue());

        panel.getHihokenshashoHakkoShosaiJoho().getTabHihokenshaShikakuShosai().
                getTplKyufuSeigen().getTblKyuhuSeigen().getTxtKyufuSeigenKikan2().
                setToValue(ymlData.getAsTextBoxDate("seigenkikanto2").getValue());

        panel.getHihokenshashoHakkoShosaiJoho().getTabHihokenshaShikakuShosai().
                getTplKyufuSeigen().getTblKyuhuSeigen().getTxtKyufuSeigenKikan3().
                setToValue(ymlData.getAsTextBoxDate("seigenkikanto3").getValue());

        //支援事業者情報
        hashMap = hihokenshashoHakkoJohoList.get(4);
        ymlData = new ControlGenerator(hashMap);

        panel.getHihokenshashoHakkoShosaiJoho().getTabHihokenshaShikakuShosai().
                getTplShienJigyosha().getTblJigyosha().getTxtJigyosha1().
                setValue(ymlData.getAsRString("jigyoshamei1"));

        panel.getHihokenshashoHakkoShosaiJoho().getTabHihokenshaShikakuShosai().
                getTplShienJigyosha().getTblJigyosha().getTxtJigyosha2().
                setValue(ymlData.getAsRString("jigyoshamei2"));

        panel.getHihokenshashoHakkoShosaiJoho().getTabHihokenshaShikakuShosai().
                getTplShienJigyosha().getTblJigyosha().getTxtJigyosha3().
                setValue(ymlData.getAsRString("jigyoshamei3"));

        panel.getHihokenshashoHakkoShosaiJoho().getTabHihokenshaShikakuShosai().
                getTplShienJigyosha().getTblJigyosha().getTxtTodokedeDate1().
                setValue(ymlData.getAsTextBoxFlexibleDate("todokedebi1").getValue());

        panel.getHihokenshashoHakkoShosaiJoho().getTabHihokenshaShikakuShosai().
                getTplShienJigyosha().getTblJigyosha().getTxtTodokedeDate2().
                setValue(ymlData.getAsTextBoxFlexibleDate("todokedebi2").getValue());

        panel.getHihokenshashoHakkoShosaiJoho().getTabHihokenshaShikakuShosai().
                getTplShienJigyosha().getTblJigyosha().getTxtTodokedeDate3().
                setValue(ymlData.getAsTextBoxFlexibleDate("todokedebi3").getValue());

        //施設入退所情報
        hashMap = hihokenshashoHakkoJohoList.get(5);
        ymlData = new ControlGenerator(hashMap);

        panel.getHihokenshashoHakkoShosaiJoho().getTabHihokenshaShikakuShosai().
                getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getTxtShisetsuShurui1().
                setValue(ymlData.getAsRString("shisetsushurui1"));

        panel.getHihokenshashoHakkoShosaiJoho().getTabHihokenshaShikakuShosai().
                getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getTxtShisetsuShurui2().
                setValue(ymlData.getAsRString("shisetsushurui2"));

        panel.getHihokenshashoHakkoShosaiJoho().getTabHihokenshaShikakuShosai().
                getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getTxtShisetsuShurui3().
                setValue(ymlData.getAsRString("shisetsushurui3"));

        panel.getHihokenshashoHakkoShosaiJoho().getTabHihokenshaShikakuShosai().
                getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getTxtNyushoShisetsu1().
                setValue(ymlData.getAsRString("shisetsumei1"));

        panel.getHihokenshashoHakkoShosaiJoho().getTabHihokenshaShikakuShosai().
                getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getTxtNyushoShisetsu2().
                setValue(ymlData.getAsRString("shisetsumei2"));

        panel.getHihokenshashoHakkoShosaiJoho().getTabHihokenshaShikakuShosai().
                getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getTxtNyushoShisetsu3().
                setValue(ymlData.getAsRString("shisetsumei3"));

        panel.getHihokenshashoHakkoShosaiJoho().getTabHihokenshaShikakuShosai().
                getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getTxtShisetsuNyushoDate1().
                setValue(ymlData.getAsTextBoxFlexibleDate("nyushobi1").getValue());

        panel.getHihokenshashoHakkoShosaiJoho().getTabHihokenshaShikakuShosai().
                getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getTxtShisetsuNyushoDate2().
                setValue(ymlData.getAsTextBoxFlexibleDate("nyushobi2").getValue());

        panel.getHihokenshashoHakkoShosaiJoho().getTabHihokenshaShikakuShosai().
                getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getTxtShisetsuNyushoDate3().
                setValue(ymlData.getAsTextBoxFlexibleDate("nyushobi3").getValue());

        panel.getHihokenshashoHakkoShosaiJoho().getTabHihokenshaShikakuShosai().
                getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getTxtShisetsuTaishoDate1().
                setValue(ymlData.getAsTextBoxFlexibleDate("taishobi1").getValue());

        panel.getHihokenshashoHakkoShosaiJoho().getTabHihokenshaShikakuShosai().
                getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getTxtShisetsuTaishoDate2().
                setValue(ymlData.getAsTextBoxFlexibleDate("taishobi2").getValue());

        panel.getHihokenshashoHakkoShosaiJoho().getTabHihokenshaShikakuShosai().
                getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getTxtShisetsuTaishoDate3().
                setValue(ymlData.getAsTextBoxFlexibleDate("taishobi3").getValue());

        response.data = panel;
        return response;
    }

    /*
     *種類支給限度基準額データグリッド情報を設定します。
     */
    private List createRowShuruiShikyuGendoKijunGaku(ControlGenerator ymlData, int iShuruiShikyuSu) {

        List<dgShuruiShikyuGendoKijunGaku_Row> arrayDataList = new ArrayList();

        for (int i = 1; i <= iShuruiShikyuSu; i++) {

            RString rsShurui = ymlData.getAsRString("shurui" + i);
            RString rsShuruiKijungaku = ymlData.getAsRString("shuruikijungaku" + i);

            arrayDataList.add(createRowShuruiShikyuGendoKijunGaku(rsShurui, rsShuruiKijungaku));
        }
        return arrayDataList;
    }

    private dgShuruiShikyuGendoKijunGaku_Row createRowShuruiShikyuGendoKijunGaku(
            RString shurui,
            RString shuruiKijungaku
    ) {

        dgShuruiShikyuGendoKijunGaku_Row rowShuruiShikyuGendoKijunGaku = new dgShuruiShikyuGendoKijunGaku_Row(
                shurui,
                shuruiKijungaku
        );
        return rowShuruiShikyuGendoKijunGaku;
    }

}
