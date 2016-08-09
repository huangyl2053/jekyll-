/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5530001;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5530001.YokaigoNinteiTorikeshiTujishoHakkoDiv;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;

/**
 * 要介護認定取消通知書発行のHandlerクラスです。
 *
 * @reamsid_L DBD-1440-010 liuyl
 */
public class YokaigoNinteiTorikeshiTujishoHakkoHandler {

    private final YokaigoNinteiTorikeshiTujishoHakkoDiv div;
    private final RString 被保番号 = new RString("被保番号");
    private static final RString 市町村コード = new RString("123456");
    private static final RString 識別コード = new RString("000000000000010");
    private static final RString HDN_SETAI_KODO = new RString("1234567");
    private static final RString 被保険者番号 = new RString("0000000001");
    private static final RString コード = new RString("1");

    /**
     * コンストラクタです。
     *
     * @param div YokaigoNinteiTorikeshiTujishoHakkoDiv
     */
    public YokaigoNinteiTorikeshiTujishoHakkoHandler(YokaigoNinteiTorikeshiTujishoHakkoDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     */
    public void onLoad() {
        ShichosonSecurityJoho shichosonSecurityJoho = ShichosonSecurityJohoFinder.createInstance().getShichosonSecurityJoho(GyomuBunrui.介護事務);
        div.getTujishoHakkoJoken().getCcdKaigoNinteiAtenaInfo().setShoriType(コード);
//      TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        div.getTujishoHakkoJoken().getCcdKaigoNinteiAtenaInfo().setKaigoDonyuKeitai(shichosonSecurityJoho.get介護導入区分().code());
        div.getTujishoHakkoJoken().getCcdKaigoNinteiAtenaInfo().setShinseishaJohoByShikibetsuCode(ShinseishoKanriNo.EMPTY, new ShikibetsuCode(識別コード));
        div.getTujishoHakkoJoken().getCcdKaigoNinteiAtenaInfo().initialize();
//        div.getTujishoHakkoJoken().getCcdKaigoninteiShikakuInfo().initialize(市町村コード, 識別コード, HDN_SETAI_KODO, 被保険者番号); TODO
        div.getTujishoHakkoMeisai().getTxtSakuseibi().setValue(RDate.getNowDate());
        div.getTujishoHakkoMeisai().getTxtTorikeshibi().setValue(RDate.getNowDate());
        div.getTujishoHakkoMeisai().getTxtYokaigodo().setValue(div.getCcdKaigoninteiShikakuInfo().getTxtYokaigodo().getValue());
        div.getTujishoHakkoMeisai().getTxtYukoKigen2().setFromValue(div.getCcdKaigoninteiShikakuInfo().getTxtNinteiKaishiYmd().getValue());
        div.getTujishoHakkoMeisai().getTxtYukoKigen2().setToValue(div.getCcdKaigoninteiShikakuInfo().getTxtNinteiShuryoYmd().getValue());
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(被保険者番号), new RString("0001"), 被保番号);
        AccessLogger.log(AccessLogType.照会, PersonalData.withHojinNo(new ShikibetsuCode(識別コード), expandedInfo));

    }

    /**
     * 排他の設定
     *
     * @param 被保険者番号 RString
     */
    public void 排他の設定(RString 被保険者番号) {
        RealInitialLocker.lock(new LockingKey(被保険者番号));
    }

    /**
     * 排他制御の解除
     *
     * @param 被保険者番号 RString
     */
    public void 排他制御の解除(RString 被保険者番号) {
        RealInitialLocker.release(new LockingKey(被保険者番号));
    }
}
