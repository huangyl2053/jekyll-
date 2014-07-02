/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.ShunoJoho.ShunoJohoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.ShunoJoho.dgFucho_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.ShunoJoho.dgTokucho_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.SupplementInfoPrm;

/**
 *
 * @author N8211 田辺 紘一
 */
public class ShunoJoho {

    private static final RString ShunoInfo = new RString("ShunoJoho/ShunoInfo.yml");
    private static final RString Tokucho = new RString("ShunoJoho/Tokucho.yml");
    private static final RString Fucho = new RString("ShunoJoho/Fucho.yml");

    /**
     * 補足情報パラメータオブジェクトを作成する。 共有子Divが必要とする親Divからのキー情報を返すメソッド
     *
     * @param hogeCode1
     * @param hugaCode2
     * @param hogeCode3
     * @return
     */
    public SupplementInfoPrm buildSendParam(String hogeCode1, String hugaCode2, String hogeCode3) {
        Map<String, String> prm = new HashMap<>();
        prm.put(ShunoJoho.HosokuInfoKey.コード1.name(), hogeCode1);
        prm.put(ShunoJoho.HosokuInfoKey.コード2.name(), hugaCode2);
        prm.put(ShunoJoho.HosokuInfoKey.コード3.name(), hogeCode3);

        return new SupplementInfoPrm(this.getClass(), prm);
    }

    /**
     * タブがクリックされ、この共有子DivがActiveになった際に発火するイベント。 タブがアクティブになったとき自動的にcallされる。メソッド名はonActiveにすること。
     * 第一引数は対象の共有子Divのentityのインスタンス。第二引数は親Divから渡されるSupplementInfoPrmのインスタンス。
     *
     * @param div
     * @param prm
     * @return ResponseData
     */
    public ResponseData onActive(ShunoJohoDiv div, SupplementInfoPrm prm) {

        load(div);

        return callGyomuMethod(div, prm);
    }

    /**
     * この共有子DivがActive（タブが選択されている状態）で、業務画面側でキー情報の変更が発生した際に発火するイベント。 親画面で、sendDataが更新されたとき自動的にcallされる。メソッド名はonUpdateにすること。
     * 第一引数は対象の共有子Divのentityのインスタンス。第二引数は親Divから渡されるSupplementInfoPrmのインスタンス。
     *
     * @param div
     * @param prm
     * @return ResponseData
     */
    public ResponseData onUpdate(ShunoJohoDiv div, SupplementInfoPrm prm) {
        return callGyomuMethod(div, prm);
    }

    private ResponseData callGyomuMethod(ShunoJohoDiv div, SupplementInfoPrm prm) {
//        ResponseData res = gyomuMethod(
//                div,
//                prm.getKeyData().get(HosokuInfoKey.コード1.name()),
//                prm.getKeyData().get(HosokuInfoKey.コード2.name()),
//                prm.getKeyData().get(HosokuInfoKey.コード3.name())
//        );
        ResponseData res = gyomuMethod(
                div,
                null,
                null,
                null
        );

        return res;
    }

    // このメソッドは多業務から呼ばれる場合もあると考え、引数を個別指定するようにしている。
    public ResponseData gyomuMethod(ShunoJohoDiv div, String hogeCode1, String hugaCode2, String hogeCode3) {

        ResponseData res = new ResponseData();

//        System.out.println(HosokuInfoKey.コード1.name() + "：" + hogeCode1);
//        System.out.println(HosokuInfoKey.コード2.name() + "：" + hugaCode2);
//        System.out.println(HosokuInfoKey.コード3.name() + "：" + hogeCode3);
//        div.getTextBoxCode1().setValue(new RString(hogeCode1));
//        div.getTextBoxCode2().setValue(new RString(hugaCode2));
//        div.getTextBoxCode3().setValue(new RString(hogeCode3));
        res.data = div;
        return res;
    }

    /**
     * 補足情報パラメータ列挙体（これは必用に応じて用意する）
     */
    enum HosokuInfoKey {

        コード1,
        コード2,
        コード3
    }

    private void load(ShunoJohoDiv div) {
        setShunoInfo(div);
        setDgTokucho(div);
        setDgFucho(div);
    }

    private void setShunoInfo(ShunoJohoDiv div) {
        div.getTxtTsuchiNo().setFormatLength(16);
        
        List<HashMap> demoData = YamlLoader.DBB.loadAsList(ShunoInfo);
        ControlGenerator cg = new ControlGenerator(demoData.get(0));

        div.getTxtChoteiNendo().setValue(cg.getAsRString("調定年度"));
        div.getTxtFukaNendo().setValue(cg.getAsRString("賦課年度"));
        div.getTxtTsuchiNo().setValue(cg.getAsRString("通知書番号"));

        div.getShunoJohoTokucho().getTxtTokuChoteiGeoukei().setValue(cg.getAsDecimal("特徴調定合計"));
        div.getShunoJohoTokucho().getTxtTokuShunyuGeoukei().setValue(cg.getAsDecimal("特徴収入合計"));
        div.getShunoJohoFucho().getTxtFuChoteiGeoukei().setValue(cg.getAsDecimal("普徴調定合計"));
        div.getShunoJohoFucho().getTxtFuShunyuGeoukei().setValue(cg.getAsDecimal("普徴調定合計"));
    }

    private void setDgTokucho(ShunoJohoDiv div) {
        List<HashMap> demoDataList = YamlLoader.DBB.loadAsList(Tokucho);
        List<dgTokucho_Row> arrayData = new ArrayList<>();

        if (demoDataList != null) {
            for (HashMap demoData : demoDataList) {

                ControlGenerator cg = new ControlGenerator(demoData);

                dgTokucho_Row row = new dgTokucho_Row(RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
                row.setTxtKi(cg.getAsRString("期"));
                row.setTxtChoteiGaku(cg.getAsRString("調定額"));
                row.setTxtShunyuGaku(cg.getAsRString("収入額"));
                row.setTxtShunyuYMD(cg.getAsRString("収入日"));
                row.setTxtRyosyuYMD(cg.getAsRString("領収日"));
                row.setTxtTokusokuTesuryo(cg.getAsRString("督促手数料"));
                row.setTxtEntaikin(cg.getAsRString("延滞金"));
                row.setTxtChoteiYMD(cg.getAsRString("調定日"));
                row.setTxtNokigen(cg.getAsRString("納期限"));

                arrayData.add(row);
            }
        }
        DataGrid<dgTokucho_Row> grid = div.getShunoJohoTokucho().getDgTokucho();
        grid.setDataSource(arrayData);
    }

    private void setDgFucho(ShunoJohoDiv div) {
        List<HashMap> demoDataList = YamlLoader.DBB.loadAsList(Fucho);
        List<dgFucho_Row> arrayData = new ArrayList<>();

        if (demoDataList != null) {
            for (HashMap demoData : demoDataList) {

                ControlGenerator cg = new ControlGenerator(demoData);

                dgFucho_Row row = new dgFucho_Row(RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
                row.setTxtKi(cg.getAsRString("期"));
                row.setTxtChoteiGaku(cg.getAsRString("調定額"));
                row.setTxtShunyuGaku(cg.getAsRString("収入額"));
                row.setTxtShunyuYMD(cg.getAsRString("収入日"));
                row.setTxtRyosyuYMD(cg.getAsRString("領収日"));
                row.setTxtTokusokuTesuryo(cg.getAsRString("督促手数料"));
                row.setTxtEntaikin(cg.getAsRString("延滞金"));
                row.setTxtChoteiYMD(cg.getAsRString("調定日"));
                row.setTxtNokigen(cg.getAsRString("納期限"));

                arrayData.add(row);
            }
        }
        DataGrid<dgFucho_Row> grid = div.getShunoJohoFucho().getDgFucho();
        grid.setDataSource(arrayData);
    }
}
