/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0350011;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC010030.DBC010030_JuryoinbinKeiyakuJigyoshaIchiranParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0350011.DBC0350011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0350011.JuryoIninKeiyakuJigyoshaIchiranhyoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0350011.JuryoIninKeiyakuJigyoshaIchiranhyoValidationHandler;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 受領委任契約事業者一覧表です。
 *
 * @reamsid_L DBC-2110-010 lihang
 */
public class JuryoIninKeiyakuJigyoshaIchiranhyo {

    /**
     * onLoad
     *
     * @param div JuryoIninKeiyakuJigyoshaIchiranhyoDiv
     * @return ResponseData
     */
    public ResponseData<JuryoIninKeiyakuJigyoshaIchiranhyoDiv> onLoad(JuryoIninKeiyakuJigyoshaIchiranhyoDiv div) {

        div.getCcdChohyoShutsuryokujun().load(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200012.getReportId());
        return ResponseData.of(div).setState(DBC0350011StateName.受領委任契約事業者一覧表作成);
    }

    /**
     * 「印刷する」ボタンのメソッドです。
     *
     * @param div JuryoIninKeiyakuJigyoshaIchiranhyoDiv
     * @return ResponseData
     */
    public ResponseData<JuryoIninKeiyakuJigyoshaIchiranhyoDiv> onClick_beforPrint(
            JuryoIninKeiyakuJigyoshaIchiranhyoDiv div) {
        ValidationMessageControlPairs validPairs = getCheckHandler(div).get入力チェック();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「印刷する」ボタンを押下します。
     *
     * @param div NenjiRiyoshaFutanWariaiHanteiDiv
     * @return ResponseData
     */
    public ResponseData<DBC010030_JuryoinbinKeiyakuJigyoshaIchiranParameter> onClick_BtnPrint(JuryoIninKeiyakuJigyoshaIchiranhyoDiv div) {
        DBC010030_JuryoinbinKeiyakuJigyoshaIchiranParameter parameter = new DBC010030_JuryoinbinKeiyakuJigyoshaIchiranParameter();

        parameter.set契約事業者番号FROM(div.getJuryoininbaraiChushutsuJoken().getTxtKeiyakuBangoFrom().getValue());
        parameter.set契約事業者番号TO(div.getJuryoininbaraiChushutsuJoken().getTxtKeiyakuBangoTo().getValue());
        if (div.getJuryoininbaraiChushutsuJoken().getTxtKeiyakuYMD().getFromValue() != null) {
            parameter.set契約日FROM(new FlexibleDate(div.getJuryoininbaraiChushutsuJoken().getTxtKeiyakuYMD().getFromValue().toDateString()));
        }
        if (div.getJuryoininbaraiChushutsuJoken().getTxtKeiyakuYMD().getToValue() != null) {
            parameter.set契約日TO(new FlexibleDate(div.getJuryoininbaraiChushutsuJoken().getTxtKeiyakuYMD().getToValue().toDateString()));
        }
        parameter.set契約種別(div.getJuryoininbaraiChushutsuJoken().getRadKeiyakuShubetsu().getSelectedKey());
        parameter.set契約期間終了事業者(div.getJuryoininbaraiChushutsuJoken().getRadKeiyakuKikanShuryoGyosha().getSelectedKey());
        if (div.getCcdChohyoShutsuryokujun().getSelected出力順() != null) {
            parameter.set改頁出力順ID(new RString(div.getCcdChohyoShutsuryokujun().getSelected出力順().get出力順ID()));
        }
        parameter.set市町村コード(AssociationFinderFactory.createInstance().getAssociation().get地方公共団体コード());
        parameter.set処理日時(RDateTime.now());
        return ResponseData.of(parameter).respond();
    }

    private JuryoIninKeiyakuJigyoshaIchiranhyoValidationHandler
            getCheckHandler(JuryoIninKeiyakuJigyoshaIchiranhyoDiv div) {
        return new JuryoIninKeiyakuJigyoshaIchiranhyoValidationHandler(div);
    }
}
