/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5130001;

import java.util.Map;
import jp.co.ndensan.reams.db.dbd.business.report.dbd501002.ShinseiShoEntity;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5130001.NinteishinseihakkoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5130001.ShinseihakkoMeiseiDiv;
import jp.co.ndensan.reams.db.dbd.service.core.ninteikanryoninteishinseijoho.NinteiKanryoNinteiShinseiJohoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.NinteiShinseiKubunHorei;
import jp.co.ndensan.reams.db.dbx.definition.core.NinteiShinseiKubunShinsei;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiShinseiJohoChild;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShinseiRirekiJoho;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiAtenaInfo.KaigoNinteiAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoninteiShikakuInfo.KaigoninteiShikakuInfoDiv;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ux.uxx.business.core.tsuchishoteikeibun.TsuchishoTeikeibunInfo;
import jp.co.ndensan.reams.ux.uxx.service.core.tsuchishoteikeibun.TsuchishoTeikeibunManager;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定申請書発行ハンドラクラスです。
 *
 * @reamsid_L DBD-1400-010 tianyh
 */
public class ShinseihakkoMeiseiHandler {

    private final ShinseihakkoMeiseiDiv div;
    private final NinteishinseihakkoDiv ninteishinseihakkodiv;
    private static final RString 識別コード = new RString("000000001011002");
    private static final RString 被保険者番号 = new RString("2190000003");
    private static final RString 画面区分 = new RString("2");
    private static final RString 正 = new RString("○");
    private static final long NO_10 = 10;
    private static final int NO_1 = 1;
    private static final int NO_2 = 2;
    private static final int NO_3 = 3;
    private static final int NO_4 = 4;
    private static final int NO_5 = 5;
    private static final int NO_6 = 6;
    private static final int NO_7 = 7;
    private static final int NO_8 = 8;
    private static final int NO_9 = 9;
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
     * @param div ShinseihakkoMeiseiDiv
     * @param ninteishinseihakkodiv ninteishinseihakkodiv
     */
    public ShinseihakkoMeiseiHandler(ShinseihakkoMeiseiDiv div, NinteishinseihakkoDiv ninteishinseihakkodiv) {
        this.div = div;
        this.ninteishinseihakkodiv = ninteishinseihakkodiv;
    }

    /**
     * 画面初期化
     *
     */
    public void initialize() {
        ShichosonSecurityJoho shichosonSecurityJoho = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        RString 介護導入形態 = shichosonSecurityJoho.get導入形態コード().value();
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
        ShikibetsuCode shikibetsuCode = new ShikibetsuCode(識別コード);
        ninteishinseihakkodiv.getCcdKaigoNinteiAtenaInfo().setKaigoDonyuKeitai(介護導入形態);
        ninteishinseihakkodiv.getCcdKaigoNinteiAtenaInfo().setShoriType(コード);
        ninteishinseihakkodiv.getCcdKaigoNinteiAtenaInfo().setShinseishaJohoByShikibetsuCode(ShinseishoKanriNo.EMPTY, shikibetsuCode);
        ninteishinseihakkodiv.getCcdKaigoNinteiAtenaInfo().initialize();
        ninteishinseihakkodiv.getCcdKaigoninteiShikakuInfo().initialize(shichosonSecurityJoho.get市町村情報().get市町村コード().value(), 被保険者番号);
        NinteiKanryoNinteiShinseiJohoManager manager = NinteiKanryoNinteiShinseiJohoManager.createInstance();
        NinteiShinseiJohoChild entity = manager.get要介護認定申請情報(ninteishinseihakkodiv.getCcdKaigoninteiShikakuInfo().getHookenshaCode(),
                ninteishinseihakkodiv.getCcdKaigoninteiShikakuInfo().getTxtHihokenshaNo().getValue());
        NinteiKanryoJoho ninteiKanryoJoho = manager.selectByShinseishoKanriNo(entity.get申請書管理番号());
        if (ninteiKanryoJoho == null) {
            checkninteiKanryoJoho(entity);
        } else {
            setZenkaiShinseiNaiyoinfo(entity.get認定申請区分_法令_コード().getColumnValue(),
                    entity.get認定申請区分_申請時_コード().getColumnValue(),
                    new RDate(entity.get認定申請年月日().toString()));
        }
        div.getCcdZenkaiNinteiKekkaJoho().onLoad(SubGyomuCode.DBD介護受給, entity.get申請書管理番号(), 画面区分);
        div.getCcdKyotakuServiceKeikakuInfo().initialize(new HihokenshaNo(被保険者番号));
        div.getCcdShusetSunyushoInfo().onLoad(shikibetsuCode);
    }

    /**
     * ShinseiShoEntityを取得します
     *
     * @return ShinseiShoEntity
     */
    public ShinseiShoEntity getShinseiShoEntity() {
        NinteiKanryoNinteiShinseiJohoManager manager = NinteiKanryoNinteiShinseiJohoManager.createInstance();
        ShinseiShoEntity shinseiShoEntity = new ShinseiShoEntity();
        int radPrintMeeisaiSelectIndex = div.getPrintSelect().getRadPrintMeeisaiInfo().getSelectedIndex();
        int radShinseiKubunSelectIndex = div.getPrintSelect().getRadShinseiKubun().getSelectedIndex();
        int radShinseishaKubunSelectIndex = div.getPrintSelect().getRadShinseishaKubun().getSelectedIndex();
        KaigoninteiShikakuInfoDiv kaigoninteiShikakuInfoDiv = (KaigoninteiShikakuInfoDiv) ninteishinseihakkodiv.getCcdKaigoninteiShikakuInfo();
        KaigoNinteiAtenaInfoDiv kaigoNinteiAtenaInfoDiv = (KaigoNinteiAtenaInfoDiv) ninteishinseihakkodiv.getCcdKaigoNinteiAtenaInfo();
        if (radShinseishaKubunSelectIndex == 0) {
            shinseiShoEntity.set被保険者番号(kaigoninteiShikakuInfoDiv.getTxtHihokenshaNo().getText());
            long hihokenshaNo = Long.parseLong(kaigoninteiShikakuInfoDiv.getTxtHihokenshaNo().getValue().toString());
            shinseiShoEntity = set被保険者番号(hihokenshaNo, shinseiShoEntity);
            RString year = kaigoNinteiAtenaInfoDiv.getTxtBirthYMD().getValue().getYear().wareki().getYear();
            if (year.startsWith("明")) {
                shinseiShoEntity.set出生元号明治(正);
            }
            if (year.startsWith("大")) {
                shinseiShoEntity.set出生元号大正(正);
            }
            if (year.startsWith("昭")) {
                shinseiShoEntity.set出生元号昭和(正);
            }
            shinseiShoEntity.set生年月日(kaigoNinteiAtenaInfoDiv.getTxtBirthYMD().getValue().toDateString());
            shinseiShoEntity.set生まれYY(kaigoNinteiAtenaInfoDiv.getTxtBirthYMD().getValue().getYear().toDateString());
            shinseiShoEntity.set出生月MM(new RString(String.valueOf(kaigoNinteiAtenaInfoDiv.getTxtBirthYMD().getValue().getMonthValue())));
            shinseiShoEntity.set出生日DD(new RString(String.valueOf(kaigoNinteiAtenaInfoDiv.getTxtBirthYMD().getValue().getDayValue())));
            shinseiShoEntity.set被保険者名称(kaigoNinteiAtenaInfoDiv.getTxtShimei().getValue());
            RString seibetsuVal = kaigoNinteiAtenaInfoDiv.getTxtSeibetsu().getValue();
            shinseiShoEntity.set性別(seibetsuVal);
            if ("男".equals(seibetsuVal.toString())) {
                shinseiShoEntity.set性別男(正);
            } else {
                shinseiShoEntity.set性別女(正);
            }
            shinseiShoEntity.set被保険者名称カナ(manager.getKanaName(new ShikibetsuCode(kaigoNinteiAtenaInfoDiv.getTxtShikiBetsuCode().getValue())));
            shinseiShoEntity.set郵便番号(kaigoNinteiAtenaInfoDiv.getTxtYubinNo().getValue().value());
            shinseiShoEntity.set電話番号(kaigoNinteiAtenaInfoDiv.getTxtTelNo().getDomain().value());
            shinseiShoEntity.set住所(kaigoNinteiAtenaInfoDiv.getTxtJusho().getDomain().value());
            TsuchishoTeikeibunManager mag = new TsuchishoTeikeibunManager();
            TsuchishoTeikeibunInfo 帳票タイトルInfo = mag.get通知書定型文パターン(ReportIdDBD.DBD501002.getReportId(), SubGyomuCode.DBD介護受給);
            Map<Integer, RString> 通知文
                    = ReportUtil.get通知文(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD501002.getReportId(), KamokuCode.EMPTY, 帳票タイトルInfo.getパターン番号());
            shinseiShoEntity.set通知文(通知文.get(帳票タイトルInfo.get項目番号()));
            if (radShinseiKubunSelectIndex != 0) {
                shinseiShoEntity = set状態区分(radPrintMeeisaiSelectIndex, shinseiShoEntity);
            }
        } else {
            shinseiShoEntity.set市町村名称(kaigoninteiShikakuInfoDiv.getTxtHokensha().getText());
        }
        return shinseiShoEntity;
    }

    private void setZenkaiShinseiNaiyoinfo(RString 認定申請区分法令, RString 認定申請区分申請時, RDate ninteiShinseiYMD) {
        div.getZenkaiShinseiNaiyo().getTxtShinseiKubunShinseiji().setValue(new RString(NinteiShinseiKubunHorei.toValue(
                Integer.parseInt(認定申請区分法令.toString())).name()));
        div.getZenkaiShinseiNaiyo().getTxtShinseiKubunHorei().setValue(new RString(NinteiShinseiKubunShinsei.toValue(
                Integer.parseInt(認定申請区分申請時.toString())).name()));
        div.getZenkaiShinseiNaiyo().getTxtZenkaiShinseiDate().setValue(ninteiShinseiYMD);
    }

    private void checkninteiKanryoJoho(NinteiShinseiJohoChild entity) {
        NinteiKanryoNinteiShinseiJohoManager manager = NinteiKanryoNinteiShinseiJohoManager.createInstance();
        ShinseiRirekiJoho shinseiRirekiJoho = manager.selectByKey(entity.get申請書管理番号());
        if (shinseiRirekiJoho != null) {
            NinteiKanryoJoho ninteiKanryoJohoni = manager.selectByShinseishoKanriNo(shinseiRirekiJoho.get前回申請管理番号());
            if (ninteiKanryoJohoni != null) {
                NinteiShinseiJohoChild ninteiShinseiJohoChildni = manager.selectByZenkaiShinseishoKanriNo(shinseiRirekiJoho.get前回申請管理番号());
                setZenkaiShinseiNaiyoinfo(ninteiShinseiJohoChildni.get認定申請区分_法令_コード().getColumnValue(),
                        ninteiShinseiJohoChildni.get認定申請区分_申請時_コード().getColumnValue(),
                        new RDate(ninteiShinseiJohoChildni.get認定申請年月日().toString()));
            }
        }
    }

    private ShinseiShoEntity set被保険者番号(long hihokenshaNo, ShinseiShoEntity shinseiShoEntity) {
        long num;
        for (int i = 1; i <= shinseiShoEntity.get被保険者番号().length(); i++) {
            num = hihokenshaNo % NO_10;
            hihokenshaNo = hihokenshaNo / NO_10;
            if (i == NO_1) {
                shinseiShoEntity.set被保険者番号第10桁(new RString(String.valueOf(num)));
            }
            if (i == NO_2) {
                shinseiShoEntity.set被保険者番号第9桁(new RString(String.valueOf(num)));
            }
            if (i == NO_3) {
                shinseiShoEntity.set被保険者番号第8桁(new RString(String.valueOf(num)));
            }
            if (i == NO_4) {
                shinseiShoEntity.set被保険者番号第7桁(new RString(String.valueOf(num)));
            }
            if (i == NO_5) {
                shinseiShoEntity.set被保険者番号第6桁(new RString(String.valueOf(num)));
            }
            if (i == NO_6) {
                shinseiShoEntity.set被保険者番号第5桁(new RString(String.valueOf(num)));
            }
            if (i == NO_7) {
                shinseiShoEntity.set被保険者番号第4桁(new RString(String.valueOf(num)));
            }
            if (i == NO_8) {
                shinseiShoEntity.set被保険者番号第3桁(new RString(String.valueOf(num)));
            }
            if (i == NO_9) {
                shinseiShoEntity.set被保険者番号第2桁(new RString(String.valueOf(num)));
            }
            if (i == NO_10) {
                shinseiShoEntity.set被保険者番号第1桁(new RString(String.valueOf(num)));
            }
        }
        return shinseiShoEntity;
    }

    private ShinseiShoEntity set状態区分(int radPrintMeeisaiSelectIndex, ShinseiShoEntity shinseiShoEntity) {
        shinseiShoEntity.set有効期間開始年月日(div.getCcdZenkaiNinteiKekkaJoho().getTxtYukoKikanFrom().getText());
        shinseiShoEntity.set有効開始年YYYY(div.getCcdZenkaiNinteiKekkaJoho().getTxtYukoKikanFrom().getValue().getYear().toDateString());
        shinseiShoEntity.set有効開始月MM(new RString(String.valueOf(
                div.getCcdZenkaiNinteiKekkaJoho().getTxtYukoKikanFrom().getValue().getMonthValue())));
        shinseiShoEntity.set有効開始日DD(new RString(String.valueOf(
                div.getCcdZenkaiNinteiKekkaJoho().getTxtYukoKikanFrom().getValue().getDayValue())));
        shinseiShoEntity.set有効期間終了年月日(div.getCcdZenkaiNinteiKekkaJoho().getTxtYukoKikanTo().getText());
        shinseiShoEntity.set有効終了年YYYY(div.getCcdZenkaiNinteiKekkaJoho().getTxtYukoKikanTo().getValue().getYear().toDateString());
        shinseiShoEntity.set有効終了月MM(new RString(String.valueOf(
                div.getCcdZenkaiNinteiKekkaJoho().getTxtYukoKikanTo().getValue().getMonthValue())));
        shinseiShoEntity.set有効終了日DD(new RString(String.valueOf(
                div.getCcdZenkaiNinteiKekkaJoho().getTxtYukoKikanTo().getValue().getDayValue())));
        if (radPrintMeeisaiSelectIndex == 0) {
            shinseiShoEntity.set要介護状態区分(div.getCcdZenkaiNinteiKekkaJoho().getTxtYokaigodo().getValue());
            if ("要介護1".equals(div.getCcdZenkaiNinteiKekkaJoho().getTxtYokaigodo().getValue().toString())) {
                shinseiShoEntity.set要介護状態区分1(正);
            }
            if ("要介護2".equals(div.getCcdZenkaiNinteiKekkaJoho().getTxtYokaigodo().getValue().toString())) {
                shinseiShoEntity.set要介護状態区分2(正);
            }
            if ("要介護3".equals(div.getCcdZenkaiNinteiKekkaJoho().getTxtYokaigodo().getValue().toString())) {
                shinseiShoEntity.set要介護状態区分3(正);
            }
            if ("要介護4".equals(div.getCcdZenkaiNinteiKekkaJoho().getTxtYokaigodo().getValue().toString())) {
                shinseiShoEntity.set要介護状態区分4(正);
            }
            if ("要介護5".equals(div.getCcdZenkaiNinteiKekkaJoho().getTxtYokaigodo().getValue().toString())) {
                shinseiShoEntity.set要介護状態区分5(正);
            }
        }
        if (radPrintMeeisaiSelectIndex == 1) {
            shinseiShoEntity.set要介護状態区分(div.getCcdZenkaiNinteiKekkaJoho().getTxtYokaigodo().getValue());
            if ("要支援1".equals(div.getCcdZenkaiNinteiKekkaJoho().getTxtYokaigodo().getValue().toString())) {
                shinseiShoEntity.set要支援状態区分1(正);
            }
            if ("要支援2".equals(div.getCcdZenkaiNinteiKekkaJoho().getTxtYokaigodo().getValue().toString())) {
                shinseiShoEntity.set要支援状態区分2(正);
            }
        }
        return shinseiShoEntity;
    }

}
