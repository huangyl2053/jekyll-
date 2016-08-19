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
    private static final RString コード = new RString("1");
    private static final RString コード111 = new RString("111");
    private static final RString コード112 = new RString("112");
    private static final RString コード120 = new RString("120");
    private static final RString コード211 = new RString("211");
    private static final RString 単一市町村 = new RString("1");
    private static final RString 広域市町村 = new RString("2");
    private static final RString 広域保険者 = new RString("3");
    private static final RString 広域審査会 = new RString("4");

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
     *
     * @param 被保険者番号 RString
     * @param 識別コード RString
     */
    public void onLoad(RString 被保険者番号, RString 識別コード) {
        ShichosonSecurityJoho shichosonSecurityJoho = ShichosonSecurityJohoFinder.createInstance().
                getShichosonSecurityJoho(GyomuBunrui.介護事務);
        div.getTujishoHakkoJoken().getCcdKaigoNinteiAtenaInfo().setShoriType(コード);
        RString 介護導入形態 = shichosonSecurityJoho.get導入形態コード().getCode();
        if (介護導入形態.equals(コード111)) {
            介護導入形態 = 広域保険者;
        }
        if (介護導入形態.equals(コード112)) {
            介護導入形態 = 広域市町村;
        }
        if (介護導入形態.equals(コード120)) {
            介護導入形態 = 単一市町村;
        }
        if (介護導入形態.equals(コード211)) {
            介護導入形態 = 広域審査会;
        }
        div.getTujishoHakkoJoken().getCcdKaigoNinteiAtenaInfo().setKaigoDonyuKeitai(介護導入形態);
        div.getTujishoHakkoJoken().getCcdKaigoNinteiAtenaInfo().setShinseishaJohoByShikibetsuCode(ShinseishoKanriNo.EMPTY,
                new ShikibetsuCode(識別コード));
        div.getTujishoHakkoJoken().getCcdKaigoNinteiAtenaInfo().initialize();
        div.getTujishoHakkoJoken().getCcdKaigoninteiShikakuInfo().initialize(shichosonSecurityJoho.get市町村情報().get市町村コード().
                value(), 被保険者番号);
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
