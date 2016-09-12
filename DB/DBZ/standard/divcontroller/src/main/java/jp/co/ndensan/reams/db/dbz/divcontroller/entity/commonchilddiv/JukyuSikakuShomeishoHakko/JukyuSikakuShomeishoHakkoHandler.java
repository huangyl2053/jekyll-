/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.JukyuSikakuShomeishoHakko;

import jp.co.ndensan.reams.db.dbz.business.core.jukyushikakushomeishohakko.JukyuShikakuShomeishoModel;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.jukyushikakushomeishohakko.JukyuShikakuShomeishoHakkoParameter;
import jp.co.ndensan.reams.db.dbz.service.core.jukyushikakushomeishohakko.JukyuShikakuShomeishoHakkoFinder;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 受給資格証明書を編集するクラスです。
 *
 * @reamsid_L DBA-1090-010 wangkun
 */
public class JukyuSikakuShomeishoHakkoHandler {

    private final JukyuSikakuShomeishoHakkoDiv jukyuSikakuShomeishoHakkoDiv;

    JukyuSikakuShomeishoHakkoHandler(JukyuSikakuShomeishoHakkoDiv div) {
        this.jukyuSikakuShomeishoHakkoDiv = div;
    }

    /**
     * 共通子DIVの初期化処理です。
     *
     * @param 受給資格証明書発行情報の検索キー 受給資格証明書発行情報の検索キー
     */
    public void initialize(JukyuShikakuShomeishoHakkoParameter 受給資格証明書発行情報の検索キー) {
        editGaMenKoMoku(JukyuShikakuShomeishoHakkoFinder.createInstance()
                .getJukyuShikakuShomeishoHakko(受給資格証明書発行情報の検索キー));
    }

    private void editGaMenKoMoku(JukyuShikakuShomeishoModel jukyuShikakuBusiness) {
        if (jukyuShikakuBusiness != null) {
            jukyuSikakuShomeishoHakkoDiv.getTxtKofubi().setValue(jukyuShikakuBusiness.get交付日());
            jukyuSikakuShomeishoHakkoDiv.getTxtIdoYotebi().setValue(jukyuShikakuBusiness.get異動予定日());
            jukyuSikakuShomeishoHakkoDiv.getTxtYokaigoJotaiKubun().setValue(jukyuShikakuBusiness.get要介護状態区分());
            jukyuSikakuShomeishoHakkoDiv.getTxtShinsebi().setValue(jukyuShikakuBusiness.get受給申請年月日());
            if (!jukyuShikakuBusiness.get有効期間開始日().isEmpty()) {
                jukyuSikakuShomeishoHakkoDiv.getTxtdrYukokikan()
                        .setFromValue(new RDate(jukyuShikakuBusiness.get有効期間開始日().toString()));
            }
            if (!jukyuShikakuBusiness.get有効期間終了日().isEmpty()) {
                jukyuSikakuShomeishoHakkoDiv.getTxtdrYukokikan()
                        .setToValue(new RDate(jukyuShikakuBusiness.get有効期間終了日().toString()));
            }
            jukyuSikakuShomeishoHakkoDiv.getTxtfutanWariaiKubun().setValue(jukyuShikakuBusiness.get負担割合());
            jukyuSikakuShomeishoHakkoDiv.getTxtfutanWariai().setValue(jukyuShikakuBusiness.get負担割該当());
            jukyuSikakuShomeishoHakkoDiv.getTbmShinsakaiYikan().setValue(jukyuShikakuBusiness.get介護認定審査会意見());
            jukyuSikakuShomeishoHakkoDiv.getTbmBiko().setValue(jukyuShikakuBusiness.get備考());
        }
    }
}
