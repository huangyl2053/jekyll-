/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.JogaishaTekiyoInputDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.TekiyoJogaiTorokuDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * 適用除外の情報を入力するDivに対応したControllerです。
 *
 * @author n8178 城間篤人
 */
public class TekiyoJogaiToroku {

    private static final RString TEKIYO_JOGAI_SHISETSU = new RString("TekiyoJogaiShisetsuData.yml");

    /**
     * 施設入所日を入力してフォーカスが外れた時に、適用日と適用届け日が空白だった場合、施設入所日と同じ値を代入します。
     *
     * @param tekiyoJogaiTorokuDiv 適用除外登録Div
     * @return レスポンス
     */
    public ResponseData onBlur_txtShisetsuNyushoDate(TekiyoJogaiTorokuDiv tekiyoJogaiTorokuDiv) {
        ResponseData<TekiyoJogaiTorokuDiv> response = new ResponseData<>();

        TextBoxFlexibleDate tekiyoDate = tekiyoJogaiTorokuDiv.getJogaishaTekiyoInput().getTxtTekiyoDate();
        TextBoxFlexibleDate tekiyoTodokedeDate = tekiyoJogaiTorokuDiv.getJogaishaTekiyoInput().getTxtTekiyoTodokedeDate();
        TextBoxFlexibleDate nyushoDate = tekiyoJogaiTorokuDiv.getJogaishaTekiyoInput().getTxtShisetsuNyushoDate();
        if (!nyushoDate.getText().equals(RString.EMPTY)) {
            if (tekiyoDate.getText().equals(RString.EMPTY)) {
                tekiyoDate.setValue(nyushoDate.getValue());
            }
            if (tekiyoTodokedeDate.getText().equals(RString.EMPTY)) {
                tekiyoTodokedeDate.setValue(nyushoDate.getValue());
            }
        }

        response.data = tekiyoJogaiTorokuDiv;
        return response;
    }

    /**
     * 入力した施設コードに対応する施設が既に存在している場合に、施設コードからフォーカスが外れた際に対応する施設名称を自動で入力します。
     *
     * @param tekiyoJogaiTorokuDiv 適用除外登録Div
     * @return レスポンス
     */
    public ResponseData onBlur_txtNyushoShisetsuCode(TekiyoJogaiTorokuDiv tekiyoJogaiTorokuDiv) {
        ResponseData<TekiyoJogaiTorokuDiv> response = new ResponseData<>();

        setShisetsuMeisho(tekiyoJogaiTorokuDiv.getJogaishaTekiyoInput());

        response.data = tekiyoJogaiTorokuDiv;
        return response;
    }

    private void setShisetsuMeisho(JogaishaTekiyoInputDiv jogaishaTekiyoInput) {
        List<HashMap> shisetsuList = YamlLoader.FOR_DBZ.loadAsList(TEKIYO_JOGAI_SHISETSU);
        RString jigyoshaCode = jogaishaTekiyoInput.getTxtNyushoShisetsuCode().getValue();
        for (HashMap shisetsuJoho : shisetsuList) {
            if (jigyoshaCode.toString().equals(shisetsuJoho.get("事業者コード").toString())) {
                jogaishaTekiyoInput.getTxtNyushoShisetsuMeisho().setValue(new RString(shisetsuJoho.get("事業者名称").toString()));
            }
        }
    }

}
