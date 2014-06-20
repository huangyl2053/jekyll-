/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0400011.IkkatsuHakkoTaishoListDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0400011.dgIkkatsuHakkoTaisho_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 * 被保険者証一括発行Divを制御します。
 *
 * @author N9606 漢那 憲作
 */
public class IkkatsuHakkoTaishoList {

    /**
     * 未発行検索条件画面-「一括作成対象を表示する」ボタン押下時の処理を表します。
     *
     * @param panel IkkatsuHakkoTaishoListDiv
     * @return ResponseData
     */
    public ResponseData<IkkatsuHakkoTaishoListDiv> onClick_BtnSearchHakkoTaisho(
            IkkatsuHakkoTaishoListDiv panel) {
        ResponseData<IkkatsuHakkoTaishoListDiv> response = new ResponseData<>();

        setIkkatsuHakkoTaishoData(panel);

        setSortData(panel);

        panel.setIsOpen(true);
        panel.getHihokenshashoIkkatsuHakko().getHihokenshaShoShutsuryokuJun().
                getCcdChohyoShutsuryokujun().setCanOpenAndClose(false);
        panel.getHihokenshashoIkkatsuHakkoList().getHihokenshaShoListShutsuryokuJun().
                getCcdChohyoShutsuryokujun().setCanOpenAndClose(false);
        panel.getHihokenshashoIkkatsuHakko().getHihokenshaShoShutsuryokuJun().
                getCcdChohyoShutsuryokujun().setTitle(RString.EMPTY);
        panel.getHihokenshashoIkkatsuHakkoList().getHihokenshaShoListShutsuryokuJun().
                getCcdChohyoShutsuryokujun().setTitle(RString.EMPTY);

        response.data = panel;
        return response;

    }

    /*
     *一括発行対象者情報を設定します。
     */
    private void setIkkatsuHakkoTaishoData(IkkatsuHakkoTaishoListDiv panel) {

        List<HashMap> IkkatsuHakkoTaishoList = YamlLoader.DBU.loadAsList(
                new RString("dbu0400011/IkkatsuHakkoTaishoList.yml"));

        List<dgIkkatsuHakkoTaisho_Row> arraydata = createRowIkkatsuHakkoTaishoList(IkkatsuHakkoTaishoList);
        for (Iterator<dgIkkatsuHakkoTaisho_Row> it = arraydata.iterator(); it.hasNext();) {

            dgIkkatsuHakkoTaisho_Row ikkatsuHakkoTaisho_Row = it.next();
            ikkatsuHakkoTaisho_Row.setSelected(Boolean.TRUE);
        }
        DataGrid grid = panel.getDgIkkatsuHakkoTaisho();
        grid.setDataSource(arraydata);

        panel.getShutsuryokuJoho().getTxtKofuDate().setValue(FlexibleDate.getNowDate());

    }

    /*
     *一括発行対象者情報の初期値をセットします。
     */
    private List createRowIkkatsuHakkoTaishoList(List<HashMap> IkkatsuHakkoTaishoList) {

        List arrayDataList = new ArrayList();

        for (int i = 0; i < IkkatsuHakkoTaishoList.size(); i++) {
            HashMap hashMap = IkkatsuHakkoTaishoList.get(i);
            ControlGenerator ymlData = new ControlGenerator(hashMap);

            RString rsHihoNo = ymlData.getAsRString("hihoNo");
            RString rsHihokenshaShimei = ymlData.getAsRString("hihokenshaShimei");
            RString rsShutokubi = ymlData.getAsRString("shutokubi");
            RString rsHenkobi = ymlData.getAsRString("henkobi");
            RString rsNinteibi = ymlData.getAsRString("ninteibi");
            RString rsJuminShubetsu = ymlData.getAsRString("juminShubetsu");

            arrayDataList.add(createRowIkkatsuHakkoTaishoList(
                    rsHihoNo,
                    rsHihokenshaShimei,
                    rsShutokubi,
                    rsHenkobi,
                    rsNinteibi,
                    rsJuminShubetsu
            ));
        }
        return arrayDataList;
    }

    /*
     *引数を元にデータグリッド内に挿入する一括発行対象者情報データを作成します。
     */
    private dgIkkatsuHakkoTaisho_Row createRowIkkatsuHakkoTaishoList(
            RString hihoNo,
            RString hihokenshaShimei,
            RString shutokubi,
            RString henkobi,
            RString ninteibi,
            RString strJuminShubetsu
    ) {
        dgIkkatsuHakkoTaisho_Row rowIkkatsuHakkoTaishoList = new dgIkkatsuHakkoTaisho_Row(
                hihoNo,
                hihokenshaShimei,
                shutokubi,
                henkobi,
                ninteibi,
                strJuminShubetsu
        );
        return rowIkkatsuHakkoTaishoList;
    }

    /*
     *出力順情報を設定します。
     */
    private void setSortData(IkkatsuHakkoTaishoListDiv panel) {

        List<HashMap> sortList = YamlLoader.DBU.loadAsList(
                new RString("dbu0400011/Sort.yml"));

        HashMap hashMap = sortList.get(0);
        ControlGenerator ymlData = new ControlGenerator(hashMap);

        panel.getHihokenshashoIkkatsuHakko().getHihokenshaShoShutsuryokuJun().getCcdChohyoShutsuryokujun().getTxtSort().
                setValue(ymlData.getAsRString("sort"));

        panel.getHihokenshashoIkkatsuHakko().getHihokenshaShoShutsuryokuJun().getCcdChohyoShutsuryokujun().getTxtSortName().
                setValue(ymlData.getAsRString("sortname"));

        panel.getHihokenshashoIkkatsuHakko().getHihokenshaShoShutsuryokuJun().getCcdChohyoShutsuryokujun().getTxtKaiPage().
                setValue(ymlData.getAsRString("kaipage"));

        hashMap = sortList.get(1);
        ymlData = new ControlGenerator(hashMap);

        panel.getHihokenshashoIkkatsuHakkoList().getHihokenshaShoListShutsuryokuJun().getCcdChohyoShutsuryokujun().getTxtSort().
                setValue(ymlData.getAsRString("sort"));

        panel.getHihokenshashoIkkatsuHakkoList().getHihokenshaShoListShutsuryokuJun().getCcdChohyoShutsuryokujun().getTxtSortName().
                setValue(ymlData.getAsRString("sortname"));

        panel.getHihokenshashoIkkatsuHakkoList().getHihokenshaShoListShutsuryokuJun().getCcdChohyoShutsuryokujun().getTxtKaiPage().
                setValue(ymlData.getAsRString("kaipage"));
    }

}
