/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.JutokuJohoInputDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.ShisetsuJohoInputDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.SochimotoJohoInputDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.TekiyoJiyuInputDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.helper.JutokuJohoValueSetter;
import jp.co.ndensan.reams.db.dba.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;

/**
 *
 * @author n8178 城間篤人
 */
public class JutokuJohoInput {

    private static final RString HOKENSHA_DATA_SOURCE = new RString("dbz/demoData/HokenshaData.yml");
    private static final RString OTHER_SHISETSU_DATA_SOURCE = new RString("dbz/demoData/OtherShisetsuData.yml");
    private static final RString JIGYOSHA_DATA_SOURCE = new RString("dbz/demoData/ShisetsuData.yml");

    /**
     * パネルが読み込まれた際に、入力項目の初期値を設定します。
     *
     * @param div JutokuJohoInputDiv
     * @return レスポンス
     */
    public ResponseData onLoad(JutokuJohoInputDiv div) {
        ResponseData<JutokuJohoInputDiv> response = new ResponseData<>();

        setSelectShisetsuShurui(div);
        JutokuJohoValueSetter.setDefaultValue(div);

        response.data = div;
        return response;
    }

    /**
     * パネルが呼び出されたときか、施設情報の施設種類が変更された際に実行されるメソッドです。
     * 選択した種類に合わせて、表示するダイアログボタンを決定します。
     *
     * @param div JutokuJohoInputDiv
     * @return レスポンスデータ
     */
    public ResponseData selectShisetsuShurui(JutokuJohoInputDiv div) {
        ResponseData<JutokuJohoInputDiv> response = new ResponseData<>();
        setSelectShisetsuShurui(div);
        response.data = div;
        return response;
    }

    private void setSelectShisetsuShurui(JutokuJohoInputDiv div) {
        ShisetsuJohoInputDiv shisetsuJohoInputDiv = div.getShisetsuJohoInput();

        RadioButton rad = shisetsuJohoInputDiv.getRadShisetsuShurui();
        if (rad.getSelectedItem().equals(new RString("keyKaigoHokenShisetsu"))) {
            shisetsuJohoInputDiv.getBtnShisetsuSelect().setDisplayNone(false);
            shisetsuJohoInputDiv.getBtnShisetsuSelect().setVisible(true);
            shisetsuJohoInputDiv.getBtnOtherShisetsuSelect().setDisplayNone(true);
            shisetsuJohoInputDiv.getBtnOtherShisetsuSelect().setVisible(false);
        } else {
            shisetsuJohoInputDiv.getBtnShisetsuSelect().setDisplayNone(true);
            shisetsuJohoInputDiv.getBtnShisetsuSelect().setVisible(false);
            shisetsuJohoInputDiv.getBtnOtherShisetsuSelect().setDisplayNone(false);
            shisetsuJohoInputDiv.getBtnOtherShisetsuSelect().setVisible(true);
        }
    }

    /**
     * 適用届出日の入力が完了してロスとフォーカスした際、適用日と入所日に値が入っていない場合に、<br/>
     * 適用届出日の情報をそれぞれの初期値として代入します。
     *
     * @param div JutokuJohoInputDiv
     * @return レスポンス
     */
    public ResponseData onBlur_txtTekiyoTodokedeDate(JutokuJohoInputDiv div) {
        ResponseData<JutokuJohoInputDiv> response = new ResponseData<>();

        TekiyoJiyuInputDiv tekiyoJiyuInputDiv = div.getTekiyoJiyuInput();

        if (tekiyoJiyuInputDiv.getTxtTekiyoDate().getText().isEmpty()) {
            tekiyoJiyuInputDiv.getTxtTekiyoDate().setValue(tekiyoJiyuInputDiv.getTxtTekiyoTodokedeDate().getValue());
        }
        if (tekiyoJiyuInputDiv.getTxtShisetsuNyushoDate().getText().isEmpty()) {
            tekiyoJiyuInputDiv.getTxtShisetsuNyushoDate().setValue(tekiyoJiyuInputDiv.getTxtTekiyoTodokedeDate().getValue());
        }

        response.data = div;
        return response;
    }

    /**
     * 措置元保険者番号が入力された際、その情報に一致する保険者が存在した場合に、一致した保険者の名称を表示します。
     *
     * @param div JutokuJohoInputDiv
     * @return レスポンス
     */
    public ResponseData onBlur_txtSochimotoHokenshaNo(JutokuJohoInputDiv div) {
        ResponseData<JutokuJohoInputDiv> response = new ResponseData<>();

        SochimotoJohoInputDiv sochimotoJohoInputDiv = div.getSochimotoJohoInput();
        RString 保険者名称 = getMatchHokensha(sochimotoJohoInputDiv);
        sochimotoJohoInputDiv.getTxtSochimotoHokenshaMeisho().setValue(保険者名称);

        response.data = div;
        return response;
    }

    private RString getMatchHokensha(SochimotoJohoInputDiv sochimotoJohoInputDiv) {
        List<HashMap> kenList = YamlLoader.loadAsList(HOKENSHA_DATA_SOURCE);
        RString 保険者番号 = sochimotoJohoInputDiv.getTxtSochimotoHokenshaNo().getValue();
        RString 保険者名称 = RString.EMPTY;

        for (HashMap kenDetail : kenList) {
            保険者名称 = getMatchHokenshaMeisho(kenDetail, 保険者番号, 保険者名称);
        }

        return 保険者名称;
    }

    private RString getMatchHokenshaMeisho(HashMap kenDetail, RString 保険者番号, RString 保険者名称) {
        List<HashMap> hokenshaList = (List<HashMap>) kenDetail.get("保険者");
        for (HashMap hokenshaDetail : hokenshaList) {
            if (hokenshaDetail.get("保険者番号").toString().equals(保険者番号.toString())) {
                return new RString(hokenshaDetail.get("保険者名称").toString());
            }
        }
        return 保険者名称;
    }

    /**
     * 施設コードが入力された際、その情報に一致する施設が存在した場合に、一致した施設の名称を表示します。
     *
     * @param div JutokuJohoInputDiv
     * @return レスポンス
     */
    public ResponseData onBlur_txtShisetsuCode(JutokuJohoInputDiv div) {
        ResponseData<JutokuJohoInputDiv> response = new ResponseData<>();

        ShisetsuJohoInputDiv shisetsuJohoInputDiv = div.getShisetsuJohoInput();
        if (shisetsuJohoInputDiv.getRadShisetsuShurui().getSelectedItem().equals(new RString("keyKaigoHokenShisetsu"))) {
            shisetsuJohoInputDiv.getTxtShisetsuMeisho().setValue(getJigyoshaMeisho(shisetsuJohoInputDiv));
        } else {
            RString 施設名称 = getMatchOtherShisetsu(shisetsuJohoInputDiv);
            shisetsuJohoInputDiv.getTxtShisetsuMeisho().setValue(施設名称);
        }

        response.data = div;
        return response;
    }

    private RString getMatchOtherShisetsu(ShisetsuJohoInputDiv shisetsuJohoInputDiv) {
        Map<String, List<HashMap>> 全特例施設 = YamlLoader.loadAsMap(OTHER_SHISETSU_DATA_SOURCE);
        List<HashMap> 施設List = new ArrayList<>();
        RString 施設コード = shisetsuJohoInputDiv.getTxtShisetsuCode().getValue();

        for (List<HashMap> 管内管外分け特例施設 : 全特例施設.values()) {
            施設List.addAll(管内管外分け特例施設);
        }

        return getMatchShisetsuMeisho(施設List, 施設コード);
    }

    private RString getMatchShisetsuMeisho(List<HashMap> 施設名称List, RString 施設コード) {
        RString 施設名称 = RString.EMPTY;
        for (HashMap 比較対象 : 施設名称List) {
            RString 比較対象施設コード = new RString(比較対象.get("事業者コード").toString());
            if (比較対象施設コード.equals(施設コード)) {
                施設名称 = new RString(比較対象.get("事業者名称").toString());
            }
        }
        return 施設名称;
    }

    private RString getJigyoshaMeisho(ShisetsuJohoInputDiv shisetsuJohoInputDiv) {
        List<HashMap> jigyoshaList = YamlLoader.loadAsList(JIGYOSHA_DATA_SOURCE);
        RString 施設コード = shisetsuJohoInputDiv.getTxtShisetsuCode().getValue();
        for (HashMap jigyosha : jigyoshaList) {
            if (jigyosha.get("事業者コード").toString().equals(施設コード.toString())) {
                return new RString(jigyosha.get("事業者名称").toString());
            }
        }
        return RString.EMPTY;
    }
}
