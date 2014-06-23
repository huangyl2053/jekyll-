/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.helper;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba2050011.JogaishaTekiyoInputDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba2050011.TekiyoJogaiTorokuDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 適用除外情報入力Divの値の初期値を設定、もしくはクリアするためのクラスです。
 *
 * @author n8178 城間篤人
 */
public final class TekiyoJogaiValueSetter {

    private static final RString DEFALUT_INPUT_DATA_SOURCE = new RString("DBA2050011/tekiyoJogaiInputDefaultData.yml");

    /**
     * インスタンス化防止のためのプライベートコンストラクタです。
     */
    private TekiyoJogaiValueSetter() {
    }

    /**
     * 住所地特例情報入力Divに、デモ用の初期値を設定します。
     *
     * @param tekiyoJogaiTorokuDiv tekiyoJogaiTorokuDiv
     */
    public static void setDefaultValue(TekiyoJogaiTorokuDiv tekiyoJogaiTorokuDiv) {
        Map<String, HashMap> defaultDataMap = YamlLoader.DBA.loadAsMap(DEFALUT_INPUT_DATA_SOURCE);
        HashMap defaultData = defaultDataMap.get("初期値");
        setValue(tekiyoJogaiTorokuDiv, defaultData);
    }

    private static void setValue(TekiyoJogaiTorokuDiv tekiyoJogaiTorokuDiv, HashMap defaultData) {
        JogaishaTekiyoInputDiv jogaishaTekiyoInput = tekiyoJogaiTorokuDiv.getJogaishaTekiyoInput();
        jogaishaTekiyoInput.getTxtTekiyoDate().setValue(new FlexibleDate(defaultData.get("適用日").toString()));
        jogaishaTekiyoInput.getTxtTekiyoTodokedeDate().setValue(new FlexibleDate(defaultData.get("適用届出日").toString()));
        jogaishaTekiyoInput.getTxtShisetsuNyushoDate().setValue(new FlexibleDate(defaultData.get("入所日").toString()));
        jogaishaTekiyoInput.getJogaishaTekiyoJogaiShisetsu().getTxtShisetsuCode().setValue(new RString(defaultData.get("施設コード").toString()));
        jogaishaTekiyoInput.getJogaishaTekiyoJogaiShisetsu().getTxtShisetsuMeisho().setValue(new RString(defaultData.get("施設名称").toString()));
    }
}
