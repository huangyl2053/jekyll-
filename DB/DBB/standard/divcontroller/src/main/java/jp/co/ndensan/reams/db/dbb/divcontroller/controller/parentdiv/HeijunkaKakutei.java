/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0130002.HeijunkaKakuteiDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.dgHeijunkaKakutei_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 *
 * @author n3336
 */
public class HeijunkaKakutei {

    private static final RString HEIJUNKA_KAKITEI_1000 = new RString("DBB0130002/dgHeijunkaKakutei1000.yml");
    private static final RString HEIJUNKA_KAKITEI_1000_UNDER = new RString("DBB0130002/dgHeijunkaKakutei1000under.yml");
    private static final RString HEIJUNKA_KAKITEI_1000_OVER = new RString("DBB0130002/dgHeijunkaKakutei1000over.yml");
    private static final RString SHORI_NAIYO = new RString("DBB0130002/ShoriNaiyo.yml");
    private static final Decimal SAGAKU_1000 = new Decimal("1000");

    /**
     * 画面の初期化メソッドです。
     *
     * @param panel HeijunkaKakuteiDiv
     * @return 画面のResponseData
     */
    public ResponseData<HeijunkaKakuteiDiv> onLoad_HeijunkaKakutei(HeijunkaKakuteiDiv panel) {

        List<HashMap> demoData = YamlLoader.DBB.loadAsList(SHORI_NAIYO);
        ControlGenerator cg = new ControlGenerator(demoData.get(0));

        panel.getHeijunkaKakuteiShoriNaiyo().getTxtFukaNendo().setValue(cg.getAsRString("賦課年度"));
        panel.getHeijunkaKakuteiShoriNaiyo().getTxtShoriNichiji().setValue(cg.getAsRString("処理日時"));

        panel.getHeijunkaSagakuKakunin().getTxtSagaku().setValue(SAGAKU_1000);

        TextBoxNum sagaku = panel.getHeijunkaSagakuKakunin().getTxtSagaku();

        List<dgHeijunkaKakutei_Row> arrayData = createSagakuData(sagaku);
        DataGrid<dgHeijunkaKakutei_Row> grid = panel.getHeijunkaSagakuKakunin().getDgHeijunkaKakutei();
        grid.setDataSource(arrayData);

        ResponseData<HeijunkaKakuteiDiv> response = new ResponseData<>();
        response.data = panel;
        return response;
    }

    /**
     * btnSagakuSetteiボタンのonClick事件です。
     *
     * @param panel HeijunkaKakuteiDiv
     * @return 画面のResponseData
     */
    public ResponseData<HeijunkaKakuteiDiv> onClick_btnSagakuSettei(HeijunkaKakuteiDiv panel) {
        ResponseData<HeijunkaKakuteiDiv> response = new ResponseData<>();
        TextBoxNum sagaku = panel.getHeijunkaSagakuKakunin().getTxtSagaku();

        List<dgHeijunkaKakutei_Row> arrayData = createSagakuData(sagaku);
        DataGrid<dgHeijunkaKakutei_Row> grid = panel.getHeijunkaSagakuKakunin().getDgHeijunkaKakutei();
        grid.setDataSource(arrayData);
        response.data = panel;
        return response;
    }

    private List<dgHeijunkaKakutei_Row> createSagakuData(TextBoxNum sagaku) {
        List<dgHeijunkaKakutei_Row> arrayData = new ArrayList<>();
        List<HashMap> demoDataList = new ArrayList<>();

        if (SAGAKU_1000.equals(sagaku.getValue())) {
            demoDataList = YamlLoader.DBB.loadAsList(HEIJUNKA_KAKITEI_1000);
        } else if (SAGAKU_1000.compareTo(sagaku.getValue()) > 0) {
            demoDataList = YamlLoader.DBB.loadAsList(HEIJUNKA_KAKITEI_1000_UNDER);
        } else if (SAGAKU_1000.compareTo(sagaku.getValue()) < 0) {
            demoDataList = YamlLoader.DBB.loadAsList(HEIJUNKA_KAKITEI_1000_OVER);
        }
        for (HashMap demoData : demoDataList) {
            // コンストラクタにMapを渡して生成。
            ControlGenerator cg = new ControlGenerator(demoData);
            dgHeijunkaKakutei_Row row = new dgHeijunkaKakutei_Row(RString.EMPTY, sagaku, RString.EMPTY, RString.EMPTY, RString.EMPTY);

            row.setTxtHokenryoDankai(cg.getAsRString("保険料段階"));
            row.setTxtSagaku(sagaku);
            row.setTxtHeijunkaKensu(cg.getAsRString("平準化対象件数"));
            row.setTxtKakuteiKensu(cg.getAsRString("確定対象件数"));
            row.setTxtTaishogaiKensu(cg.getAsRString("差額設定による対象外件数"));

            arrayData.add(row);
        }
        return arrayData;
    }

}
