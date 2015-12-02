/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.JukyuSikakuShomeishoHakko;

import jp.co.ndensan.reams.db.dba.business.core.jukyushikakushomeishohakko.JukyuShikakuShomeishoModel;
import jp.co.ndensan.reams.db.dba.definition.mybatis.param.jukyushikakushomeishohakko.JukyuShikakuShomeishoHakkoParameter;
import jp.co.ndensan.reams.db.dba.service.core.jukyushikakushomeishohakko.JukyuShikakuShomeishoHakkoFinder;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 *
 */
public class JukyuSikakuShomeishoHakkoHandler {

    private JukyuSikakuShomeishoHakkoDiv jukyuSikakuShomeishoHakkoDiv;

    JukyuSikakuShomeishoHakkoHandler(JukyuSikakuShomeishoHakkoDiv div) {
        this.jukyuSikakuShomeishoHakkoDiv = div;
    }

    /**
     * 
     * 共通子DIVを初期化します。
     * @param parameter JukyuShikakuShomeishoHakkoParameter
     */
    public void initialize(JukyuShikakuShomeishoHakkoParameter parameter) {
        setgaMenkomokuEidit(JukyuShikakuShomeishoHakkoFinder.createInstance().getJukyuShikakuShomeishoHakko(parameter));
    }

    private void setgaMenkomokuEidit(JukyuShikakuShomeishoModel jukyuShikakuBusiness) {
        jukyuSikakuShomeishoHakkoDiv.getPnlJukyushaJoho1().getTxtKofubi().setValue(jukyuShikakuBusiness.get交付日());
        jukyuSikakuShomeishoHakkoDiv.getPnlJukyushaJoho1().getTxtIdoYotebi().setValue(jukyuShikakuBusiness.get異動予定日());
        jukyuSikakuShomeishoHakkoDiv.getPnlJukyushaJoho1().getTxtYokaigoJotaiKubun().setValue(jukyuShikakuBusiness.get要介護状態区分());
        jukyuSikakuShomeishoHakkoDiv.getPnlJukyushaJoho1().getTxtShinsebi().setValue(jukyuShikakuBusiness.get受給申請年月日());
        if (!jukyuShikakuBusiness.get有効期間開始日().isEmpty()) {
            jukyuSikakuShomeishoHakkoDiv.getPnlJukyushaJoho1().getTxtdrYukokikan().setFromValue(new RDate(jukyuShikakuBusiness.get有効期間開始日().toString()));
        }
        if(!jukyuShikakuBusiness.get有効期間終了日().isEmpty()) {
            jukyuSikakuShomeishoHakkoDiv.getPnlJukyushaJoho1().getTxtdrYukokikan().setToValue(new RDate(jukyuShikakuBusiness.get有効期間終了日().toString()));
        }
        jukyuSikakuShomeishoHakkoDiv.getTbmShinsakaiYikan().setValue(jukyuShikakuBusiness.get介護認定審査会意見());
        jukyuSikakuShomeishoHakkoDiv.getTbmBiko().setValue(jukyuShikakuBusiness.get介護認定審査会意見());
    }
}
