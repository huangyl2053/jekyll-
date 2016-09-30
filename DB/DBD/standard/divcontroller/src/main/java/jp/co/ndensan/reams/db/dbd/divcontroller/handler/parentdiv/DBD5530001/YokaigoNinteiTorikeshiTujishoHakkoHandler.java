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
import jp.co.ndensan.reams.db.dbz.business.core.basic.JukyushaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.JukyushaDaichoBuilder;
import jp.co.ndensan.reams.db.dbz.service.core.basic.JukyushaDaichoManager;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
    private static final RString コード = new RString("2");
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
        LasdecCode 市町村コード;
        RString 介護導入形態;
        if (shichosonSecurityJoho != null) {
            市町村コード = shichosonSecurityJoho.get市町村情報().get市町村コード();
            介護導入形態 = shichosonSecurityJoho.get導入形態コード().getCode();
        } else {
            市町村コード = LasdecCode.EMPTY;
            介護導入形態 = RString.EMPTY;
        }
        div.getTujishoHakkoJoken().getCcdKaigoNinteiAtenaInfo().setShoriType(コード);
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
        div.getTujishoHakkoJoken().getCcdKaigoninteiShikakuInfo().initialize(市町村コード.value(), 被保険者番号);
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

    /**
     * DB出力(受給者台帳)
     *
     * @param daicho JukyushaDaicho
     * @param riYu RString
     * @param 区分コード RString
     * @param fromDate FlexibleDate
     * @param toDate FlexibleDate
     * @param 作成日 FlexibleDate
     */
    public void insert(JukyushaDaicho daicho, RString riYu, RString 区分コード, FlexibleDate fromDate, FlexibleDate toDate, FlexibleDate 作成日) {
        Long 履歴 = Long.parseLong(daicho.get履歴番号().toString()) + 1;
        RString 履歴番号 = new RString(String.format("%04d", 履歴));
        JukyushaDaicho jukyushaDaicho = new JukyushaDaicho(daicho.get市町村コード(),
                daicho.get被保険者番号(), 履歴番号, daicho.get枝番(), daicho.get受給申請事由());
        JukyushaDaichoManager manager = new JukyushaDaichoManager();
        JukyushaDaichoBuilder builder = jukyushaDaicho.createBuilderForEdit();
        builder.set申請書管理番号(daicho.get申請書管理番号())
                .set申請状況区分(daicho.get申請状況区分())
                .set支所コード(daicho.get支所コード())
                .set直近フラグ(daicho.is直近フラグ())
                .set識別コード(daicho.get識別コード())
                .set申請理由(daicho.get申請理由())
                .set届出者_申請者関係コード(daicho.get届出者_申請者関係コード())
                .set届出者_本人との関係(daicho.get届出者_本人との関係())
                .set受給申請年月日(daicho.get受給申請年月日())
                .set２号特定疾病コード(daicho.get２号特定疾病コード())
                .set審査会依頼年月日(daicho.get審査会依頼年月日())
                .set要介護認定状態区分コード(new Code(区分コード))
                .set認定有効期間開始年月日(fromDate)
                .set認定有効期間終了年月日(toDate)
                .set認定年月日(daicho.get認定年月日())
                .setみなし要介護区分コード(daicho.getみなし要介護区分コード())
                .set指定サービス種類01(daicho.get指定サービス種類01())
                .set指定サービス種類02(daicho.get指定サービス種類02())
                .set指定サービス種類03(daicho.get指定サービス種類03())
                .set指定サービス種類04(daicho.get指定サービス種類04())
                .set指定サービス種類05(daicho.get指定サービス種類05())
                .set指定サービス種類06(daicho.get指定サービス種類06())
                .set指定サービス種類07(daicho.get指定サービス種類07())
                .set指定サービス種類08(daicho.get指定サービス種類08())
                .set指定サービス種類09(daicho.get指定サービス種類09())
                .set指定サービス種類10(daicho.get指定サービス種類10())
                .set指定サービス種類11(daicho.get指定サービス種類11())
                .set指定サービス種類12(daicho.get指定サービス種類12())
                .set指定サービス種類13(daicho.get指定サービス種類13())
                .set指定サービス種類14(daicho.get指定サービス種類14())
                .set指定サービス種類15(daicho.get指定サービス種類15())
                .set指定サービス種類16(daicho.get指定サービス種類16())
                .set指定サービス種類17(daicho.get指定サービス種類17())
                .set指定サービス種類18(daicho.get指定サービス種類18())
                .set指定サービス種類19(daicho.get指定サービス種類19())
                .set指定サービス種類20(daicho.get指定サービス種類20())
                .set指定サービス種類21(daicho.get指定サービス種類21())
                .set指定サービス種類22(daicho.get指定サービス種類22())
                .set指定サービス種類23(daicho.get指定サービス種類23())
                .set指定サービス種類24(daicho.get指定サービス種類24())
                .set指定サービス種類25(daicho.get指定サービス種類25())
                .set指定サービス種類26(daicho.get指定サービス種類26())
                .set指定サービス種類27(daicho.get指定サービス種類27())
                .set指定サービス種類28(daicho.get指定サービス種類28())
                .set指定サービス種類29(daicho.get指定サービス種類29())
                .set指定サービス種類30(daicho.get指定サービス種類30())
                .set喪失年月日(daicho.get喪失年月日())
                .set直近異動年月日(daicho.get直近異動年月日())
                .set直近異動事由コード(daicho.get直近異動事由コード())
                .set有効無効区分(daicho.get有効無効区分())
                .setデータ区分(daicho.getデータ区分())
                .set同一連番(daicho.get同一連番())
                .set異動理由(riYu)
                .set申請書区分(daicho.get申請書区分())
                .set削除事由コード(daicho.get削除事由コード())
                .set要支援者認定申請区分(daicho.is要支援者認定申請区分())
                .set支給限度単位数(daicho.get支給限度単位数())
                .set支給限度有効開始年月日(daicho.get支給限度有効開始年月日())
                .set支給限度有効終了年月日(daicho.get支給限度有効終了年月日())
                .set短期入所支給限度日数(daicho.get短期入所支給限度日数())
                .set短期入所支給限度開始年月日(daicho.get短期入所支給限度開始年月日())
                .set短期入所支給限度終了年月日(daicho.get短期入所支給限度終了年月日())
                .set当初認定有効開始年月日(daicho.get当初認定有効開始年月日())
                .set当初認定有効終了年月日(daicho.get当初認定有効終了年月日())
                .set受給資格証明書発行年月日１(daicho.get受給資格証明書発行年月日１())
                .set受給資格証明書発行年月日２(daicho.get受給資格証明書発行年月日２())
                .set診断命令書発行年月日(daicho.get診断命令書発行年月日())
                .set２号申請受理通知書発行年月日(daicho.get２号申請受理通知書発行年月日())
                .set認定結果通知書発行年月日(daicho.get認定結果通知書発行年月日())
                .set区分変更通知書発行年月日(daicho.get区分変更通知書発行年月日())
                .setサービス変更通知書発行年月日(daicho.getサービス変更通知書発行年月日())
                .set認定却下通知書発行年月日(daicho.get認定却下通知書発行年月日())
                .set認定取消通知書発行年月日(作成日)
                .set資格取得前申請フラグ(daicho.is資格取得前申請フラグ())
                .set旧措置者フラグ(daicho.is旧措置者フラグ())
                .set論理削除フラグ(daicho.is論理削除フラグ());
        manager.save受給者台帳(builder.build());

    }
}
