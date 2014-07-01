/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.helper;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba2040011.JutokuJohoInputDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba2040011.ShisetsuJohoInputDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba2040011.SochimotoJohoInputDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba2040011.TekiyoJiyuInputDiv;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;

/**
 * 住所地特例情報入力Divの値の初期値を設定するためのクラスです。
 *
 * @author n8178 城間篤人
 */
public final class TajutokuJohoValueSetter {

    private static final RString DEFALUT_INPUT_DATA_SOURCE = new RString("DBA2040011/tajutokuTekiyoInputDefaultValue.yml");

    /**
     * インスタンス化防止のためのプライベートコンストラクタです。
     */
    private TajutokuJohoValueSetter() {
    }

    /**
     * 住所地特例情報入力Divに、デモ用の初期値を設定します。
     *
     * @param div JutokuJohoInputDiv
     */
    public static void setDefaultValue(JutokuJohoInputDiv div) {
        Map defaultData = YamlLoader.DBA.loadAsMap(DEFALUT_INPUT_DATA_SOURCE);
        setValue(div, (HashMap) defaultData);
    }

    private static void setValue(JutokuJohoInputDiv div, HashMap defaultData) {
        TekiyoJiyuInputDiv tekiyoJiyuInput = div.getTekiyoJiyuInput();
        tekiyoJiyuInput.getTxtTekiyoDate().setValue(new FlexibleDate(defaultData.get("適用日").toString()));
        tekiyoJiyuInput.getTxtTekiyoTodokedeDate().setValue(new FlexibleDate(defaultData.get("適用届出日").toString()));
        tekiyoJiyuInput.getTxtShisetsuNyushoDate().setValue(new FlexibleDate(defaultData.get("入所日").toString()));

        SochimotoJohoInputDiv sochimotoJohoInput = div.getSochimotoJohoInput();
        sochimotoJohoInput.getTxtSochimotoHihokenshaNo().setValue(new RString(defaultData.get("措置元被保険者番号").toString()));
        sochimotoJohoInput.getHokenshaJoho().getTxtHokenshaNo().setValue(new RString(defaultData.get("措置元保険者番号").toString()));
        sochimotoJohoInput.getHokenshaJoho().getTxtHokenshaMeisho().setValue(new RString(defaultData.get("措置元保険者名称").toString()));

        ShisetsuJohoInputDiv shisetsuJohoInput = div.getShisetsuJohoInput();
        shisetsuJohoInput.getShisetsuJoho().getTxtShisetsuCode().setValue(new RString(defaultData.get("施設コード").toString()));
        shisetsuJohoInput.getShisetsuJoho().getTxtShisetsuMeisho().setValue(new RString(defaultData.get("施設名称").toString()));
    }
}
