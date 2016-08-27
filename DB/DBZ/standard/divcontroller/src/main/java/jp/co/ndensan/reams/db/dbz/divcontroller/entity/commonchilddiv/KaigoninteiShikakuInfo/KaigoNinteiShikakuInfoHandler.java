/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoninteiShikakuInfo;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.kaigoninteishikakuinfo.KaigoNinteiShikakuInfoBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.ShichosonCodeYoriShichoson;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.jushochitokureisha.JushochitokureishaKubun;
import jp.co.ndensan.reams.db.dbz.service.core.kaigoninteishikakuinfo.KaigoNinteiShikakuInfoFinder;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定資格情報の取得するクラスです。
 *
 * @reamsid_L DBZ-1300-060 lizhuoxuan
 */
public class KaigoNinteiShikakuInfoHandler {

    private final KaigoninteiShikakuInfoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 介護認定資格情報
     */
    public KaigoNinteiShikakuInfoHandler(KaigoninteiShikakuInfoDiv div) {
        this.div = div;
    }

    /**
     * 介護認定資格情報初期処理です。
     *
     * @param hdnShinchsonCode RString
     * @param hdnHihokenShaNo RString
     */
    public void initialize(RString hdnShinchsonCode, RString hdnHihokenShaNo) {
        div.getTxtHihokenshaNo().clearValue();
        div.getTxtShutokuYmd().clearValue();
        div.getTxtShutokuJiyu().clearValue();
        div.getTxtSoshitsuYmd().clearValue();
        div.getTxtSoshitsuJiyu().clearValue();
        div.getTxtJutokuKubun().clearValue();
        div.getTxtYokaigoJotaiKubun().clearValue();
        div.getTxtNinteiKaishiYmd().clearValue();
        div.getTxtNinteiShuryoYmd().clearValue();
        div.getTxtHookenshaCode().clearValue();
        div.getTxtHokensha().clearValue();
        div.getHdnHihokenShaNo();
        div.getHdnShinchsonCode();
        set介護認定宛名情報(hdnShinchsonCode, hdnHihokenShaNo);
    }

    private void set介護認定宛名情報(RString hdnShinchsonCode, RString hdnHihokenShaNo) {
        KaigoNinteiShikakuInfoBusiness ninteiShikakuInfoBusiness = KaigoNinteiShikakuInfoFinder.createInstance()
                .getKaigoNinteiShikakuInfo(new HihokenshaNo(hdnHihokenShaNo), new LasdecCode(hdnShinchsonCode));
        List<ShichosonCodeYoriShichoson> codeYoriShichoson = KoikiShichosonJohoFinder.createInstance()
                .shichosonCodeYoriShichosonJoho(new LasdecCode(hdnShinchsonCode)).records();
        div.getTxtHihokenshaNo().setValue(hdnHihokenShaNo);
        if (ninteiShikakuInfoBusiness.get資格取得年月日() != null) {
            div.getTxtShutokuYmd().setValue(ninteiShikakuInfoBusiness.get資格取得年月日());
        }
        if (!RString.isNullOrEmpty(ninteiShikakuInfoBusiness.get資格取得事由コード())) {
            div.getTxtShutokuJiyu().setValue(ShikakuShutokuJiyu.toValue(ninteiShikakuInfoBusiness.get資格取得事由コード()).getName());
        }
        if (ninteiShikakuInfoBusiness.get資格喪失年月日() != null) {
            div.getTxtSoshitsuYmd().setValue(new FlexibleDate(ninteiShikakuInfoBusiness.get資格喪失年月日().toString()));
        }
        if (!RString.isNullOrEmpty(ninteiShikakuInfoBusiness.get資格喪失事由コード())) {
            div.getTxtSoshitsuJiyu().setValue(ShikakuSoshitsuJiyu.toValue(ninteiShikakuInfoBusiness.get資格喪失事由コード()).getName());
        }
        if (new RString("1").equals(ninteiShikakuInfoBusiness.get住所地特例フラグ())) {
            div.getTxtJutokuKubun().setValue(JushochitokureishaKubun.toValue(ninteiShikakuInfoBusiness.get住所地特例フラグ()).get名称());
        } else {
            div.getTxtJutokuKubun().setValue(RString.EMPTY);
        }
        if (ninteiShikakuInfoBusiness.get要介護認定状態区分コード() != null) {
            div.getTxtYokaigoJotaiKubun().setValue(YokaigoJotaiKubunSupport.toValue(FlexibleDate.getNowDate(),
                    new RString(ninteiShikakuInfoBusiness.get要介護認定状態区分コード().toString())).getName());
        }
        if (ninteiShikakuInfoBusiness.get認定有効期間開始年月日() != null) {
            div.getTxtNinteiKaishiYmd().setValue(new RDate(ninteiShikakuInfoBusiness.get認定有効期間開始年月日().toString()));
        }
        if (ninteiShikakuInfoBusiness.get認定有効期間終了年月日() != null) {
            div.getTxtNinteiShuryoYmd().setValue(new RDate(ninteiShikakuInfoBusiness.get認定有効期間終了年月日().toString()));
        }
        div.getTxtHookenshaCode().setValue(codeYoriShichoson.get(0).get証記載保険者番号().getColumnValue());
        div.getTxtHokensha().setValue(new RString(codeYoriShichoson.get(0).get市町村名称().toString()));
        div.setHdnShinchsonCode(hdnShinchsonCode);
        div.setHdnHihokenShaNo(hdnHihokenShaNo);
    }
}
