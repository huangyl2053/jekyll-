/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.dbc0410012;

import jp.co.ndensan.reams.db.dbc.business.KokuhorenJohoTorikomi;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KokuhorenTorikomiJohoKey;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.KokuhorenJohoTorikomiBatchParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410012.KokuhorenJohoTorikomiBatchKidoDiv;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.viewstate.ViewStateKey;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 *
 * @author N2810 久保 里史
 */
public class KokuhorenJohoTorikomiBatchKido {

    public ResponseData<KokuhorenJohoTorikomiBatchKidoDiv> onLoad(KokuhorenJohoTorikomiBatchKidoDiv panel) {

        KokuhorenTorikomiJohoKey viewState = ViewStateHolder.get(ViewStateKey.国保連取込情報, KokuhorenTorikomiJohoKey.class);
        getHandler(panel).initialize(panel, viewState);
        return ResponseData.of(panel).respond();
    }

    private KokuhorenJohoTorikomiBatchKidoHandler getHandler(KokuhorenJohoTorikomiBatchKidoDiv div) {
        return new KokuhorenJohoTorikomiBatchKidoHandler(div);
    }

    public ResponseData<KokuhorenJohoTorikomiBatchParameter> setBatchParameter(KokuhorenJohoTorikomiBatchKidoDiv panel) {

        KokuhorenJohoTorikomiBatchParameter batchparameter = new KokuhorenJohoTorikomiBatchParameter();
        KokuhorenJohoTorikomi business = new KokuhorenJohoTorikomi();

        batchparameter.setKokanjohoShikibetsuNo(panel.getTxtKokanShikibetsuNo().getValue());
        batchparameter.setSaishoriKubun(business.get再処理フラグコード(panel.getTxtSaishoriKubun().getValue()));
        batchparameter.setShoriYM(panel.getTxtShoriJoken().getValue().seireki().separator(Separator.NONE).getYearMonth());
        batchparameter.setShutsuryokujunID(new RString("1"));
        batchparameter.setHokenshaKoseiKubun(BusinessConfig.get(ConfigNameDBU.保険者情報_保険者構成, SubGyomuCode.DBU介護統計報告));
        batchparameter.setGappeiJohoKubun(BusinessConfig.get(ConfigNameDBU.合併情報管理_合併情報区分, SubGyomuCode.DBU介護統計報告));

        batchparameter.setShoriNichiji(convertYMDHMS(RDate.getNowDateTime()));
        ResponseData<KokuhorenJohoTorikomiBatchParameter> responseData = new ResponseData<>();
        responseData.data = batchparameter;
        return responseData;

    }

    public ResponseData validationCheck(KokuhorenJohoTorikomiBatchKidoDiv panel) {
        ValidationMessageControlPairs pairs = getHandler(panel).validate(panel);
        return ResponseData.of(panel).addValidationMessages(pairs).respond();
    }

    private RString convertYMDHMS(RDateTime datetime) {
        RStringBuilder rsb = new RStringBuilder();

        rsb.append(datetime.getDate().toString());
        rsb.append(String.format("%02d", datetime.getHour()));
        rsb.append(String.format("%02d", datetime.getMinute()));
        rsb.append(String.format("%02d", datetime.getSecond()));

        return rsb.toRString();

    }
}
