/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.helper;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.JutokuJohoInputDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.ShisetsuJohoInputDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.SochimotoJohoInputDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.TekiyoJiyuInputDiv;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住所地特例情報入力Divの値の初期値を設定、もしくはクリアするためのクラスです。
 *
 * @author n8178 城間篤人
 */
public final class JutokuJohoValueSetter {

    private static final RString DEFALUT_INPUT_DATA_SOURCE = new RString("dba/demoData/DefaultInputData.yml");

    /**
     * インスタンス化防止のためのプライベートコンストラクタです。
     */
    private JutokuJohoValueSetter() {
    }

    /**
     * 住所地特例情報入力Divに、デモ用の初期値を設定します。
     *
     * @param div JutokuJohoInputDiv
     */
    public static void setDefaultValue(JutokuJohoInputDiv div) {
        Map<String, HashMap> defaultDataMap = YamlLoader.loadAsMap(DEFALUT_INPUT_DATA_SOURCE);
        HashMap defaultData = defaultDataMap.get("初期値");
        setValue(div, defaultData);
    }

    /**
     * 住所地特例情報入力Divをクリアします。
     *
     * @param div JutokuJohoInputDiv
     */
    public static void clear(JutokuJohoInputDiv div) {
        Map<String, HashMap> defaultDataMap = YamlLoader.loadAsMap(DEFALUT_INPUT_DATA_SOURCE);
        HashMap defaultData = defaultDataMap.get("クリア");
        setValue(div, defaultData);
    }

    private static void setValue(JutokuJohoInputDiv div, HashMap defaultData) {
        TekiyoJiyuInputDiv tekiyoJiyuInput = div.getTekiyoJiyuInput();
        tekiyoJiyuInput.getTxtTekiyoDate().setValue(new FlexibleDate(defaultData.get("適用日").toString()));
        tekiyoJiyuInput.getTxtTekiyoTodokedeDate().setValue(new FlexibleDate(defaultData.get("適用届出日").toString()));
        tekiyoJiyuInput.getTxtShisetsuNyushoDate().setValue(new FlexibleDate(defaultData.get("入所日").toString()));

        SochimotoJohoInputDiv sochimotoJohoInput = div.getSochimotoJohoInput();
        sochimotoJohoInput.getTxtSochimotoHihokenshaNo().setValue(new RString(defaultData.get("措置元被保険者番号").toString()));
        sochimotoJohoInput.getTxtSochimotoHokenshaNo().setValue(new RString(defaultData.get("措置元保険者番号").toString()));
        sochimotoJohoInput.getTxtSochimotoHokenshaMeisho().setValue(new RString(defaultData.get("措置元保険者名称").toString()));

        ShisetsuJohoInputDiv shisetsuJohoInput = div.getShisetsuJohoInput();
        shisetsuJohoInput.getTxtShisetsuCode().setValue(new RString(defaultData.get("施設コード").toString()));
        shisetsuJohoInput.getTxtShisetsuMeisho().setValue(new RString(defaultData.get("施設名称").toString()));
    }
}
