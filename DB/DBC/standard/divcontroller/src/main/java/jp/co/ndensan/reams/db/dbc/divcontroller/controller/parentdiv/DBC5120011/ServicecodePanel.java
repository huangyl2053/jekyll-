/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC5120011;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC150030.DBC150030_ServicecodeRiyojokyoParameter;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC150030.KoseiShichosonInfo;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5120011.ServicecodePanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC5120011.ServicecodePanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC5120011.ServicecodePanelValidationHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * サービスコード別利用状況です
 *
 * @reamsid_L DBC-3340-010 lihang
 */
public class ServicecodePanel {

    /**
     * onLoadです。
     *
     * @param div servicecodePanelDiv
     * @return ResponseData
     */
    public ResponseData<ServicecodePanelDiv> onLoad(ServicecodePanelDiv div) {

        getHandler(div).getサービス種類名称();
        div.getCcdChikuShichosonSelect().isVisible();
        div.getCcdChikuShichosonSelect().initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * onBeforeOpenDialog
     *
     * @param div servicecodePanelDiv
     * @return ResponseData
     */
    public ResponseData<ServicecodePanelDiv> onBeforeOpenDialog(ServicecodePanelDiv div) {

        ValidationMessageControlPairs validPairs = getValidationHandler(div).get入力チェック();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(
                    new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                            UrQuestionMessages.処理実行の確認.getMessage().evaluate())).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_btnExcute
     *
     * @param div ServicecodePanelDiv
     * @return ResponseData
     */
    public ResponseData<DBC150030_ServicecodeRiyojokyoParameter> onClick_btnExcute(ServicecodePanelDiv div) {

        DBC150030_ServicecodeRiyojokyoParameter parameter = new DBC150030_ServicecodeRiyojokyoParameter();
        parameter.set対象年月指定(div.getChusyutsuPanel().getRadtaishoYm().getSelectedKey());
        if (null != div.getChusyutsuPanel().getTxthani().getFromValue()) {
            parameter.set年月範囲開始(new FlexibleYearMonth(div.getChusyutsuPanel().getTxthani().getFromValue().getYearMonth().toDateString()));
        }
        if (null != div.getChusyutsuPanel().getTxthani().getToValue()) {
            parameter.set年月範囲終了(new FlexibleYearMonth(div.getChusyutsuPanel().getTxthani().getToValue().getYearMonth().toDateString()));
        }
        parameter.set対象サービス種類(div.getChusyutsuPanel().getDdlshurui().getSelectedKey());
        parameter.setサービス項目コードのまとめ方(div.getSekkeiPanel().getDdlmatome().getSelectedKey());
        parameter.set選択対象(div.getCcdChikuShichosonSelect().get選択対象());
        Map<RString, RString> map = div.getCcdChikuShichosonSelect().get選択結果();
        List<RString> list = new ArrayList<>();
        if (null != map && !map.isEmpty()) {
            for (RString key : map.keySet()) {
                list.add(key);
            }
        }
        parameter.set対象コードリスト(getHandler(div).sort昇順ByKey(list));
        KoseiShichosonInfo 市町村情報 = new KoseiShichosonInfo();
        市町村情報.setコード(div.getCcdChikuShichosonSelect().get市町村コード());
        市町村情報.set名称(div.getCcdChikuShichosonSelect().get市町村名称());
        KoseiShichosonInfo 旧市町村情報 = new KoseiShichosonInfo();
        旧市町村情報.setコード(div.getCcdChikuShichosonSelect().get旧市町村コード());
        旧市町村情報.set名称(div.getCcdChikuShichosonSelect().get旧市町村名称());
        parameter.set市町村情報(市町村情報);
        parameter.set旧市町村情報(旧市町村情報);
        return ResponseData.of(parameter).respond();
    }

    private ServicecodePanelValidationHandler getValidationHandler(ServicecodePanelDiv div) {
        return new ServicecodePanelValidationHandler(div);
    }

    private ServicecodePanelHandler getHandler(ServicecodePanelDiv div) {
        return new ServicecodePanelHandler(div);
    }

}
