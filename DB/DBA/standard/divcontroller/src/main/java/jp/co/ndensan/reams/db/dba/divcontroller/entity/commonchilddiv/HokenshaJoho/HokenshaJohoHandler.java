/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.HokenshaJoho;

import jp.co.ndensan.reams.db.dba.business.core.hokensha.Hokensha;
import jp.co.ndensan.reams.db.dba.definition.mybatis.param.hokensha.HokenshaMapperParameter;
import jp.co.ndensan.reams.db.dba.service.core.hokensha.HokenshaNyuryokuHojoFinder;
import jp.co.ndensan.reams.ur.urz.definition.core.hokenja.HokenjaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * {@link HokenshaJohoDiv}のHandlerクラスです。
 */
public class HokenshaJohoHandler {

    public HokenshaJohoHandler(HokenshaJohoDiv div) {
    }

    public void onBlur_txtHokenshaNo(HokenshaJohoDiv div) {
        HokenshaMapperParameter parameter = HokenshaMapperParameter.createHokenjaNoParam(
                new HokenjaNo(div.getTxtHokenshaNo().getValue()));
        Hokensha ent = HokenshaNyuryokuHojoFinder.createInstance().getHokensha(parameter);
        if (ent == null) {
            div.getTxtHokenshaMeisho().setValue(RString.EMPTY);
        } else {
            div.getTxtHokenshaMeisho().setValue(ent.get保険者名());
        }
    }
}
