/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.RentaiNofuGimusha.RentaiNofuGimushaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.SupplementInfoPrm;

/**
 *
 * @author N8211 田辺 紘一
 */
public class RentaiNofuGimusha {

    private static final RString RentaiNofuGimusha = new RString("RentaiNofuGimusha/RentaiNofuGimusha.yml");

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
    public ResponseData onActive(RentaiNofuGimushaDiv div, SupplementInfoPrm prm) {

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
    public ResponseData onUpdate(RentaiNofuGimushaDiv div, SupplementInfoPrm prm) {
        return callGyomuMethod(div, prm);
    }

    private ResponseData callGyomuMethod(RentaiNofuGimushaDiv div, SupplementInfoPrm prm) {
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
    public ResponseData gyomuMethod(RentaiNofuGimushaDiv div, String hogeCode1, String hugaCode2, String hogeCode3) {

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

    private void load(RentaiNofuGimushaDiv div) {
        setRentaiNofuGimusha(div);
    }

    private void setRentaiNofuGimusha(RentaiNofuGimushaDiv div) {
        List<HashMap> demoData = YamlLoader.DBB.loadAsList(RentaiNofuGimusha);
        ControlGenerator cg = new ControlGenerator(demoData.get(0));

        div.getTxtShikibetsuCode().setValue(cg.getAsRString("識別コード"));
        div.getTxtShimei().setValue(cg.getAsRString("氏名"));
        div.getTxtKaishiYMD().setValue(cg.getAsRDate("開始日"));
        div.getTxtSyuryoYMD().setValue(cg.getAsRDate("終了日"));
    }

}
