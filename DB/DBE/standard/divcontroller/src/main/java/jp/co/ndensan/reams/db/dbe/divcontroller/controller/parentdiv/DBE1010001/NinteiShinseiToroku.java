/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE1010001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.basic.NinteiKeikakuJoho;
import jp.co.ndensan.reams.db.dbe.business.core.basic.NinteiKeikakuJohoBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShinsakaiIinJogaiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShinsakaiIinJogaiJohoBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.ikenshoirai.shujiiikenshoiraijoho.ShujiiIkenshoIraiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosairaijoho.NinteichosaIraiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseitoroku.NinteiShinseiTorokuResult;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseitoroku.RirekiJohoResult;
import jp.co.ndensan.reams.db.dbe.business.core.seikatsuhogotoroku.Minashi2shisaiJoho;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1010001.DBE1010001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1010001.DBE1010001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1010001.NinteiShinseiTorokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE1010001.NinteiShinseiTorokuHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE1010001.NinteiShinseiTorokuValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.basic.NinteiKanryoJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.ikenshoirai.shujiiikenshoiraijoho.ShujiiIkenshoIraiJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosahyo.ninteichosairaijoho.NinteichosaIraiJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.ninteishinseitoroku.NinteiShinseiTorokuManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.JukyuShinseiJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.ShinseiJokyoKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.KaigoHokensha;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiKekkaJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiKekkaJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiShinseiJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShinseiRirekiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShinseiRirekiJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShinseitodokedeJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShinseitodokedeJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.jogaishinsainjoho.ShinsakaiIinItiran;
import jp.co.ndensan.reams.db.dbz.business.core.jogaishinsainjoho.ShinsakaiIinItiranData;
import jp.co.ndensan.reams.db.dbz.business.core.jogaishinsainjoho.ShinsakaiIinRelateJoho;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseirenrakusakijoho.NinteiShinseiBusinessCollection;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseirenrakusakijoho.RenrakusakiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseirenrakusakijoho.RenrakusakiJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseitodokedesha.NinteiShinseiTodokedeshaDataPassModel;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseitodokedesha.NinteiShinseiTodokedeshaNaiyo;
import jp.co.ndensan.reams.db.dbz.business.core.servicetype.ninteishinsei.NinteiShinseiCodeModel;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SaibanHanyokeyName;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.JidoWariateJyogaishaKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.KoikinaiTenkyoKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiYukoKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShinsakaiYusenWaritsukeKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShinseiTodokedeDaikoKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.TorisageKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzWarningMessages;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiTodokedesha.NinteiShinseiTodokedesha.NinteiShinseiTodokedeshaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ZenkaiNinteiKekkaJoho.ZenkaiNinteiKekkaJoho.ZenkaiNinteiKekkaJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInput.ChosaItakusakiAndChosainInputDiv;
import jp.co.ndensan.reams.db.dbz.service.core.basic.KaigoHokenshaManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShinseiRirekiJohoManager;
import jp.co.ndensan.reams.db.dbz.service.core.jogaishinsainjoho.JogaiShinsainJohoFinder;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.AgeCalculator;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.DateOfBirthFactory;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.IDateOfBirth;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.AgeArrivalDay;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.EdabanCode;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IParentResponse;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.IconName;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.TextKind;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Saiban;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 審査依頼受付／みなし２号審査受付のコントローラです。
 *
 * @reamsid_L DBE-1310-010 chengsanyuan
 */
public class NinteiShinseiToroku {

    private final NinteiShinseiTorokuManager manager;
    private final KaigoHokenshaManager dbt7050Manager;
    private final NinteiKanryoJohoManager dbt5105Manager;
    private final ShinseiRirekiJohoManager dbt5121Manager;
    private static final RString MENUID_DBEMN31001 = new RString("DBEMN31001");
    private static final RString MENUID_DBEMN31003 = new RString("DBEMN31003");
    private static final RString BTNUPDATE_FILENAME = new RString("btnUpdate");
    private static final int INT_0 = 0;
    private static final int ZERO_17 = 17;
    private static final int ZERO_5 = 5;
    private static final RString ZERO_6 = new RString("000000");
    private static final RString 歳 = new RString("歳");
    private static final RString KEY1 = new RString("key1");
    private static final RString サービス削除の旨 = new RString("1010");
    private static final RString みなし２号対象 = new RString("みなし２号");
    private static final RString 作成 = new RString("みなし2号の要介護認定申請情報を作成します。");
    private static final RString 削除 = new RString("表示の要介護認定申請情報を削除します。");
    private static final RString 更新 = new RString("表示の要介護認定申請情報を更新します。");
    private static final RString 完了param = new RString("GoToKiHonUnyo");
    private static final String 重複質問MSG = "同一被保険者番号、申請書区分、申請区分(申請時)、申請区分(法令)のデータが既に登録されています。データの追加";
    private static final RString 所属機関_TMP = new RString("・");
    private boolean ninteiTandokuDounyuFlag;

    /**
     * コンストラクタです。
     *
     */
    public NinteiShinseiToroku() {
        this.manager = NinteiShinseiTorokuManager.createInstance();
        this.dbt7050Manager = KaigoHokenshaManager.createInstance();
        this.dbt5105Manager = NinteiKanryoJohoManager.createInstance();
        this.dbt5121Manager = new ShinseiRirekiJohoManager();
        ninteiTandokuDounyuFlag = Boolean.FALSE;
        ShichosonSecurityJoho security = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (security.get導入形態コード().equals(new Code("111"))) {
            ninteiTandokuDounyuFlag = Boolean.TRUE;
        } else {
            security = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護認定);
            if (security.get導入形態コード().equals(new Code("211"))) {
                ninteiTandokuDounyuFlag = Boolean.TRUE;
            }
        }
    }

    /**
     * 審査依頼受付／みなし２号審査受付初期化の設定します。
     *
     * @param div 審査依頼受付／みなし２号審査受付Div
     * @return ResponseData<NinteiShinseiTorokuDiv>
     */
    public ResponseData<NinteiShinseiTorokuDiv> onLoad(NinteiShinseiTorokuDiv div) {
        RString menuID = ResponseHolder.getMenuID();
        ShichosonSecurityJoho shichosonSecurity = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護認定);
        RString 介護導入形態 = RString.EMPTY;
        if (shichosonSecurity.get導入形態コード().value().equals(new RString("211"))) {
            介護導入形態 = new RString("4");
        }
        if (shichosonSecurity.get導入形態コード().value().equals(new RString("220"))) {
            介護導入形態 = new RString("1");
        }
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (TorisageKubunCode torisageKubunCode : TorisageKubunCode.values()) {
            dataSource.add(new KeyValueDataSource(torisageKubunCode.getコード(), torisageKubunCode.get名称()));
        }
        dataSource.remove(new KeyValueDataSource(TorisageKubunCode.認定申請有効.getコード(), TorisageKubunCode.認定申請有効.get名称()));
        div.getDdlTorisageJiyu().setDataSource(dataSource);
        List<KeyValueDataSource> dataSource2 = new ArrayList<>();
        for (ShinsakaiYusenWaritsukeKubunCode code : ShinsakaiYusenWaritsukeKubunCode.values()) {
            dataSource2.add(new KeyValueDataSource(code.getコード(), code.get名称()));
        }
        div.getDdlShinsakaiYusenKubun().setDataSource(dataSource2);
        List<KeyValueDataSource> dataSource3 = new ArrayList<>();
        for (JidoWariateJyogaishaKubun code : JidoWariateJyogaishaKubun.values()) {
            dataSource3.add(new KeyValueDataSource(code.getコード(), code.get名称()));
        }
        div.getDdlWariateKubun().setDataSource(dataSource3);
        div.getDdlShinsakaiYusenKubun().setSelectedKey(ShinsakaiYusenWaritsukeKubunCode.通常.getコード());
        div.getDdlWariateKubun().setSelectedKey(JidoWariateJyogaishaKubun.除外.getコード());

        if (MENUID_DBEMN31001.equals(menuID)) {
            ShinseishoKanriNo 管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
            RString 被保険者番号 = manager.get被保険者番号(管理番号);

            ViewStateHolder.put(ViewStateKeys.要介護認定申請情報, manager.get要介護認定申請情報(管理番号));
            ViewStateHolder.put(ViewStateKeys.要介護認定申請届出情報, manager.get認定申請届出情報(管理番号));

            NinteiShinseiTorokuResult result = manager.getDataForLoad(管理番号);

            ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();

            if (result != null) {
                validationMessages.add(getValidationHandler(div).審査会割付データ存在チェック(result));
                validationMessages.add(getValidationHandler(div).依頼完了チェック(result));
                getHandler(div).set医療保険(manager.get医療保険履歴(result.get識別コード()));
                div.setHdnShichosonRenrakuJiko(result.get市町村連絡事項());
                getHandler(div).set市町村連絡事項(result.get市町村連絡事項());
                ViewStateHolder.put("送付年月日", result.getIF送付年月日());
                ViewStateHolder.put("センター送信年月日", result.getセンター送信年月日());
                ViewStateHolder.put("認定申請情報登録完了年月日", result.get認定申請情報登録完了年月日());
            } 
            getHandler(div).loadPnl(result, ninteiTandokuDounyuFlag);
            ViewStateHolder.put(ViewStateKeys.台帳種別表示, new RString("台帳種別表示有り"));
            getHandler(div).loadUpdate(result, 管理番号, 被保険者番号, 介護導入形態);
            set連絡先(管理番号, div, false);
            RirekiJohoResult comResult = manager.get共有子データ(被保険者番号);
            div.setHdnKonkai(DataPassingConverter.serialize(comResult.get今回履歴情報()));
            div.setHdnZenkai(DataPassingConverter.serialize(comResult.get前回履歴情報()));
            div.setHdnDisplayModeKey(new RString("1"));
            div.setHdnSubGyomuCd(SubGyomuCode.DBE認定支援.value());

            div.setHdnJogaiMode(new RString("入力"));
            setIconName(div, 管理番号);
            div.setHdnShinseishoKanriNo(管理番号.value());
            ShinsakaiIinItiranData shinsakaiIinItiranData = new ShinsakaiIinItiranData();
            List<ShinsakaiIinItiran> list = new ArrayList();
            for (ShinsakaiIinRelateJoho joho : getService().get審査会委員一覧検索して審査会委員情報(管理番号.value()).records()) {
                RStringBuilder 所属機関 = new RStringBuilder();
                所属機関 = nullToEmpty(所属機関, getService().get医療機関名称(joho.get市町村コード(), new ShujiiIryokikanCode(joho.get主治医医療機関コード())));
                所属機関 = nullToEmpty(所属機関, getService().get事業者名称(joho.get市町村コード(), joho.get認定調査委託先コード()));
                所属機関 = nullToEmpty(所属機関, getService().get機関名称(joho.get証記載保険者番号(), joho.getその他機関コード()));
                ShinsakaiIinItiran shinsakaiIinItiran = new ShinsakaiIinItiran();
                shinsakaiIinItiran.setShimei(joho.get介護認定審査会委員氏名().getColumnValue());
                shinsakaiIinItiran.setShinsakaiIinCode(joho.get介護認定審査会委員コード());
                shinsakaiIinItiran.setShozokuKikan(所属機関.toRString());
                list.add(shinsakaiIinItiran);
            }
            shinsakaiIinItiranData.setShinsakaiIinItiranList(list);
            div.setHdnJogaiShinsainJoho(DataPassingConverter.serialize(shinsakaiIinItiranData));

            if (comResult.get前回履歴情報() != null && comResult.get前回履歴情報().get二次判定認定有効開始年月日() != null
                    && !comResult.get前回履歴情報().get二次判定認定有効開始年月日().isEmpty()) {
                div.getCcdShikakuInfo().getTxtNinteiKaishiYmd().setValue(new RDate(comResult.get前回履歴情報().get二次判定認定有効開始年月日().toString()));
            }
            if (comResult.get前回履歴情報() != null && comResult.get前回履歴情報().get二次判定認定有効終了年月日() != null
                    && !comResult.get前回履歴情報().get二次判定認定有効終了年月日().isEmpty()) {
                div.getCcdShikakuInfo().getTxtNinteiShuryoYmd().setValue(new RDate(comResult.get前回履歴情報().get二次判定認定有効終了年月日().toString()));
            }
            if (comResult.get前回履歴情報() != null && comResult.get前回履歴情報().get二次判定要介護状態区分コード() != null
                    && !comResult.get前回履歴情報().get二次判定要介護状態区分コード().isEmpty()) {
                div.getCcdShikakuInfo().getTxtYokaigodo().setValue(YokaigoJotaiKubunSupport.toValue(FlexibleDate.getNowDate(),
                        new RString(comResult.get前回履歴情報().get二次判定要介護状態区分コード().toString())).getName());
            }

            if (comResult.get今回履歴情報() != null
                    && comResult.get今回履歴情報().get二次判定年月日() != null) {
                div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getTxtShinseiJokyo().setValue(ShinseiJokyoKubun.認定完了.get名称());
            } else {
                div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getTxtShinseiJokyo().setValue(ShinseiJokyoKubun.申請中.get名称());
            }
            div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getChkShikakuShutokuMae().setReadOnly(false);
            div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getTxtServiceSakujo().setTextKind(TextKind.全角のみ);
            div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getTxtNinteiShinseRiyu().setTextKind(TextKind.全角のみ);
            div.getCcdNinteiInput().getTxtShinsakaiIken().setTextKind(TextKind.全角のみ);
            getHandler(div).setCcdShinseiTodokedesha(div, ninteiTandokuDounyuFlag);
            div.getCcdNinteiInput().setDisabled(true);
            div.getRadMode().setVisible(true);
            div.getRadMode().setDisplayNone(false);
            setShinseiJiyu(result, div);
            getHandler(div).loadPnlSinseishaJoho();
            if (validationMessages.iterator().hasNext()) {
                div.setReadOnly(true);
                CommonButtonHolder.setDisabledByCommonButtonFieldName(BTNUPDATE_FILENAME, true);
                return ResponseData.of(div).rootTitle(new RString("審査依頼受付")).addValidationMessages(validationMessages).respond();
            }
            RStringBuilder 前排他制御 = new RStringBuilder();
            前排他制御.append("DBEShinseishoKanriNo");
            前排他制御.append(管理番号.value());
            前排他ロックキー(前排他制御.toRString());
            return ResponseData.of(div).rootTitle(new RString("審査依頼受付")).respond();
        }
        if (MENUID_DBEMN31003.equals(menuID)) {
            Minashi2shisaiJoho business = ViewStateHolder.get(ViewStateKeys.みなし2号登録情報, Minashi2shisaiJoho.class);
            RString 管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class);
            NinteiShinseiTorokuResult result = null;
            if (管理番号 != null) {
                result = manager.getDataForLoad(new ShinseishoKanriNo(管理番号));
            }
            if (business != null) {
                ViewStateHolder.put(ViewStateKeys.台帳種別表示, new RString("台帳種別表示有り"));
                getHandler(div).loadInsert(business, business.get保険者().get市町村コード(), 介護導入形態);
                getHandler(div).set医療保険(manager.get医療保険履歴(business.get識別コード()));
                set連絡先(business.get前回申請書管理番号(), div, true);
                div.setHdnJogaiMode(new RString("入力"));
                div.setHdnShinseishoKanriNo(RString.EMPTY);
            }
            CommonButtonHolder.setVisibleByCommonButtonFieldName(new RString("btnBackToIchiran"), false);
            div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShisho().setDisabled(Boolean.TRUE);
            div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShinseiShubetsu().setReadOnly(false);
            div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShinseiKubunShinseiji().setReadOnly(false);
            div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlHihokenshaKubun().setReadOnly(false);
            div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getChkKyuSochisha().setDisabled(false);
            div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getChkShikakuShutokuMae().setDisabled(false);
            div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getTxtShinseiJokyo().setValue(ShinseiJokyoKubun.申請中.get名称());
            div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getTxtMinasiFlag().setValue(みなし２号対象);
            div.getCcdKaigoNinteiShinseiKihon().setShinseiShubetsu(JukyuShinseiJiyu.初回申請);
            div.getCcdKaigoNinteiShinseiKihon().setShinseiKubunShinseiji(NinteiShinseiShinseijiKubunCode.新規申請);
            div.getCcdKaigoNinteiShinseiKihon().setHihokenshaKubun(HihokenshaKubunCode.生活保護);

            div.getCcdShinseiTodokedesha().initialize(new NinteiShinseiTodokedeshaDataPassModel());
            getHandler(div).setCcdShinseiTodokedesha(div, ninteiTandokuDounyuFlag);
            if (result == null) {
                div.getCcdKaigoNinteiShinseiKihon().setInputMode(new RString("ShinkiShinseiMode"));
                div.getCcdZenkaiNinteiKekkaJoho().getTxtYukoKikanFrom().setDisabled(true);
                div.getCcdZenkaiNinteiKekkaJoho().getTxtYukoKikanTo().setDisabled(true);
                ((ChosaItakusakiAndChosainInputDiv) div.getCcdChodsItakusakiAndChosainInput()).getBtnZenkaiFukusha().setDisabled(true);
                ((ZenkaiNinteiKekkaJohoDiv) div.getCcdZenkaiNinteiKekkaJoho()).getBtnZenkaiShosai().setDisabled(true);
                ((NinteiShinseiTodokedeshaDiv) div.getCcdShinseiTodokedesha()).getBtnZenkaiFukusha().setDisabled(true);
                div.getDdlTorisageJiyu().setSelectedIndex(INT_0);//SelectedKey(TorisageKubunCode.認定申請有効.getコード());
                div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getNinteiShinseiRiyu().setIsOpen(false);
                div.getServiceDel().setIsOpen(false);
                div.getCcdZenkaiNinteiKekkaJoho().setIsOpen(false);
                //div.getSinseiTorisage().setIsOpen(false);
            } 
            getHandler(div).loadPnl(result, ninteiTandokuDounyuFlag);
            
            div.getServiceDel().setReadOnly(true);
            div.getSinseiTorisage().setReadOnly(true);
            setShinseiJiyu(result, div);
            getHandler(div).loadPnlSinseishaJoho();
            RStringBuilder 前排他制御 = new RStringBuilder();
            前排他制御.append("DBEShinseishoKanriNo");
            前排他制御.append(管理番号);
            前排他ロックキー(前排他制御.toRString());
            return ResponseData.of(div).rootTitle(new RString("みなし２号審査受付")).respond();
        }
        div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getTxtServiceSakujo().setTextKind(TextKind.全角のみ);
        div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getTxtNinteiShinseRiyu().setTextKind(TextKind.全角のみ);
        div.getCcdNinteiInput().getTxtShinsakaiIken().setTextKind(TextKind.全角のみ);
        
        return ResponseData.of(div).respond();
    }

    private void setShinseiJiyu(NinteiShinseiTorokuResult result, NinteiShinseiTorokuDiv div) {
        KaigoNinteiShinseiKihonJohoInputDiv inputDiv = div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv();
        RString 介護保険施行日 = DbBusinessConfig.get(ConfigNameDBU.介護保険法情報_介護保険施行日, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        RDate 基準日 = new RDate(介護保険施行日.toString());
        if (result == null) {
            if (inputDiv.getTxtShinseiYMD().getValue() != null && 基準日.isBefore(inputDiv.getTxtShinseiYMD().getValue())) {
                inputDiv.getDdlShinseiShubetsu().setSelectedKey(JukyuShinseiJiyu.初回申請.getコード());
            } else {
                inputDiv.getDdlShinseiShubetsu().setSelectedKey(JukyuShinseiJiyu.申請_法施行前.getコード());
            }
        }

        if (result != null && (result.get前回要介護状態区分コード() == null || result.get前回要介護状態区分コード().isEmpty())) {
            if (inputDiv.getTxtShinseiYMD().getValue() != null && 基準日.isBefore(inputDiv.getTxtShinseiYMD().getValue())) {
                inputDiv.getDdlShinseiShubetsu().setSelectedKey(JukyuShinseiJiyu.初回申請.getコード());
            } else {
                inputDiv.getDdlShinseiShubetsu().setSelectedKey(JukyuShinseiJiyu.申請_法施行前.getコード());
            }
        }

        if (result != null && (result.get前回認定有効期間終了() != null && !result.get前回認定有効期間終了().isEmpty())) {
            FlexibleDate 前回認定有効期間終了 = result.get前回認定有効期間終了();
            FlexibleDate 前回認定期間終了60日前 = 前回認定有効期間終了.minusDay(60);
            if (inputDiv.getTxtShinseiYMD().getValue() != null
                    && 前回認定有効期間終了.isAfter(inputDiv.getTxtShinseiYMD().getValue().toFlexibleDate())
                    && 前回認定期間終了60日前.isBefore(inputDiv.getTxtShinseiYMD().getValue().toFlexibleDate())) {
                inputDiv.getDdlShinseiShubetsu().setSelectedKey(JukyuShinseiJiyu.再申請_有効期限内.getコード());
            } else {
                inputDiv.getDdlShinseiShubetsu().setSelectedKey(JukyuShinseiJiyu.再申請_有効期限外.getコード());
            }
        }

        if (result != null && result.get認定申請区分申請時コード() != null
                && !result.get認定申請区分申請時コード().isEmpty()) {
            if (NinteiShinseiShinseijiKubunCode.区分変更申請.getコード().equals(result.get認定申請区分申請時コード().value())) {
                inputDiv.getDdlShinseiShubetsu().setSelectedKey(JukyuShinseiJiyu.要介護度変更申請.getコード());
            } else {
                inputDiv.getDdlShinseiShubetsu().setSelectedKey(JukyuShinseiJiyu.初回申請.getコード());
            }
        }
    }

    /**
     * 医療保険ダイアログを表示の前の場合、データを設定します。
     *
     * @param div 審査依頼受付／みなし２号審査受付Div
     * @return ResponseData<NinteiShinseiTorokuDiv>
     */
    public ResponseData<NinteiShinseiTorokuDiv> onChange_ddlHihokenshaKubun(NinteiShinseiTorokuDiv div) {
        KaigoNinteiShinseiKihonJohoInputDiv kihonJohoInputDiv = div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv();
        if (HihokenshaKubunCode.第２号被保険者.getコード().equals(kihonJohoInputDiv.getDdlHihokenshaKubun().getSelectedKey())) {
            div.getCcdKaigoNinteiShinseiKihon().setRequiredForDdlTokuteiShippei(true);
        } else {
            div.getCcdKaigoNinteiShinseiKihon().setRequiredForDdlTokuteiShippei(false);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 届出代行区分onChange事件
     *
     * @param div 審査依頼受付／みなし２号審査受付Div
     * @return ResponseData<NinteiShinseiTorokuDiv>
     */
    public ResponseData<NinteiShinseiTorokuDiv> onChange_ddlTodokedeDaikoKubun(NinteiShinseiTorokuDiv div) {
        if (ShinseiTodokedeDaikoKubunCode.本人.getCode().equals(div.getCcdShinseiTodokedesha().getDdlTodokledeDaikoKubun().getSelectedKey())) {
            div.getCcdShinseiTodokedesha().initialize(getHandler(div).set届出情報());
            
        } else {
            div.getCcdShinseiTodokedesha().getCcdZenkokuJushoInput().clear();
            div.getCcdShinseiTodokedesha().getTxtShimei().clearValue();
            div.getCcdShinseiTodokedesha().getTxtKanaShimei().clearValue();
            div.getCcdShinseiTodokedesha().getTxtHonninKankeisei().clearValue();
            div.getCcdShinseiTodokedesha().getTxtTelNo().clearDomain();
            div.getCcdShinseiTodokedesha().getTxtYubinNo().clearValue();
            div.getCcdShinseiTodokedesha().getCcdChoikiInput().clear();
        }
        getHandler(div).setCcdShinseiTodokedesha(div, ninteiTandokuDounyuFlag);
        return ResponseData.of(div).respond();
    }

    /**
     * 取下事由onChange事件
     *
     * @param div 審査依頼受付／みなし２号審査受付Div
     * @return ResponseData<NinteiShinseiTorokuDiv>
     */
    public ResponseData<NinteiShinseiTorokuDiv> onChange_ddlTorisageJiyu(NinteiShinseiTorokuDiv div) {
        if (div.getDdlTorisageJiyu().getIsBlankLine() || 
                TorisageKubunCode.認定申請有効.getコード().equals(div.getDdlTorisageJiyu().getSelectedKey())) {
            div.getTxtTorisageDate().clearValue();
            div.getTxtTorisageJiyu().clearValue();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * radMode onChange事件
     *
     * @param div 審査依頼受付／みなし２号審査受付Div
     * @return ResponseData<NinteiShinseiTorokuDiv>
     */
    public ResponseData<NinteiShinseiTorokuDiv> onChange_radMode(NinteiShinseiTorokuDiv div) {
        //key0 修正　key1削除
        if (div.getRadMode().getSelectedKey().equals(KEY1)) {
            getHandler(div).setDivReadOnly(true);
        } else {
            getHandler(div).setDivReadOnly(false);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 医療保険ダイアログを表示の前の場合、データを設定します。
     *
     * @param div 審査依頼受付／みなし２号審査受付Div
     * @return ResponseData<NinteiShinseiTorokuDiv>
     */
    public ResponseData<NinteiShinseiTorokuDiv> onBefore_btnIryohokenGuide(NinteiShinseiTorokuDiv div) {
        div.setHdnIryoMode(new RString("照会"));
        return ResponseData.of(div).respond();
    }

    /**
     * 入院/施設入所ダイアログを表示の前の場合、データを設定します。
     *
     * @param div 審査依頼受付／みなし２号審査受付Div
     * @return ResponseData<NinteiShinseiTorokuDiv>
     */
    public ResponseData<NinteiShinseiTorokuDiv> onBefore_btnNyuinAndShisetsuNyusho(NinteiShinseiTorokuDiv div) {
        div.setHdnKanriMode(new RString("照会"));
        return ResponseData.of(div).respond();
    }

    /**
     * 定型文から選ぶダイアログを表示の前の場合、データを設定します。
     *
     * @param div 審査依頼受付／みなし２号審査受付Div
     * @return ResponseData<NinteiShinseiTorokuDiv>
     */
    public ResponseData<NinteiShinseiTorokuDiv> onBefore_btnEnkiRiyuTeikeibun(NinteiShinseiTorokuDiv div) {
        div.setHdnSubGyomuCd(GyomuCode.DB介護保険.value());
        div.setHdnGroupCode(new RString("1007"));
        return ResponseData.of(div).respond();
    }

    /**
     * 連絡先ダイアログを閉じるの場合、データを設定します。
     *
     * @param div 審査依頼受付／みなし２号審査受付Div
     * @return ResponseData<NinteiShinseiTorokuDiv>
     */
    public ResponseData<NinteiShinseiTorokuDiv> onOkClose_btnRenrakusaki(NinteiShinseiTorokuDiv div) {
        NinteiShinseiBusinessCollection data = DataPassingConverter.deserialize(div.getHdnRenrakusakiJoho(), NinteiShinseiBusinessCollection.class);
        int delCount = 0;
        for (RenrakusakiJoho joho : data.getDbdBusiness()) {
            if (EntityDataState.Deleted.equals(joho.toEntity().getState())) {
                delCount++;
            }
        }
        if (data.getDbdBusiness() != null && (!data.getDbdBusiness().isEmpty() || delCount != data.getDbdBusiness().size())) {
            div.getBtnRenrakusaki().setIconNameEnum(IconName.Complete);
        } else {
            div.getBtnRenrakusaki().setIconNameEnum(IconName.NONE);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 連絡事項ダイアログを表示の前の場合、データを設定します。
     *
     * @param div 審査依頼受付／みなし２号審査受付Div
     * @return ResponseData<NinteiShinseiTorokuDiv>
     */
    public ResponseData<NinteiShinseiTorokuDiv> onBefore_btnShichosonRenrakuJiko(NinteiShinseiTorokuDiv div) {
        NinteiShinseiCodeModel data = new NinteiShinseiCodeModel();
        data.set連絡事項(div.getHdnShichosonRenrakuJiko());
        data.set表示モード(NinteiShinseiCodeModel.HyojiMode.InputMode);
        ViewStateHolder.put(ViewStateKeys.モード, data);
        return ResponseData.of(div).respond();
    }

    /**
     * 生年月日lostFocus事件
     *
     * @param div 審査依頼受付／みなし２号審査受付Div
     * @return ResponseData<NinteiShinseiTorokuDiv>
     */
    public ResponseData<NinteiShinseiTorokuDiv> onBlur_txtJohoBirthday(NinteiShinseiTorokuDiv div) {
         if (div.getTplShinseishaJoho().getTxtJohoBirthday().getValue() != null && !div.getTplShinseishaJoho().getTxtJohoBirthday().getValue().toDateString().isEmpty()) {
            IDateOfBirth dob = DateOfBirthFactory.createInstance(div.getTplShinseishaJoho().getTxtJohoBirthday().getValue().toFlexibleDate());
            AgeCalculator agecalculator = new AgeCalculator(dob, JuminJotai.住民, FlexibleDate.MAX, AgeArrivalDay.前日);
            div.getTplShinseishaJoho().getTxtJohoNenrei().setValue(agecalculator.get年齢());
            
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 連絡事項ダイアログを閉じるの場合、データを設定します。
     *
     * @param div 審査依頼受付／みなし２号審査受付Div
     * @return ResponseData<NinteiShinseiTorokuDiv>
     */
    public ResponseData<NinteiShinseiTorokuDiv> onOkClose_btnShichosonRenrakuJiko(NinteiShinseiTorokuDiv div) {
        NinteiShinseiCodeModel data = ViewStateHolder.get(ViewStateKeys.モード, NinteiShinseiCodeModel.class);
        if (data != null && !RString.isNullOrEmpty(data.get連絡事項())) {
            div.getBtnShichosonRenrakuJiko().setIconNameEnum(IconName.Complete);
        } else {
            div.getBtnShichosonRenrakuJiko().setIconNameEnum(IconName.NONE );
        }
        div.setHdnShichosonRenrakuJiko(data != null ? data.get連絡事項() : RString.EMPTY);
        return ResponseData.of(div).respond();
    }

    /**
     * 除外委員ダイアログを閉じるの場合、データを設定します。
     *
     * @param div 審査依頼受付／みなし２号審査受付Div
     * @return ResponseData<NinteiShinseiTorokuDiv>
     */
    public ResponseData<NinteiShinseiTorokuDiv> onOkClose_btnJogaiShinsakaiIinGuide(NinteiShinseiTorokuDiv div) {
        ShinsakaiIinItiranData data = DataPassingConverter.deserialize(div.getHdnJogaiShinsainJoho(), ShinsakaiIinItiranData.class);
        if (data != null && data.getShinsakaiIinItiranList() != null && !data.getShinsakaiIinItiranList().isEmpty()) {
            div.getBtnJogaiShinsakaiIinGuide().setIconNameEnum(IconName.Complete);
        } else {
            div.getBtnJogaiShinsakaiIinGuide().setIconNameEnum(IconName.NONE);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * ダイアログ用引数を設定します。
     *
     * @param div 介護認定申請基本情報の入力用DIV
     * @return ResponseData
     */
    public ResponseData onBeforeOpenDialog_btnServiceDelTeikeibunGuide(NinteiShinseiTorokuDiv div) {
        ResponseData<NinteiShinseiTorokuDiv> response = new ResponseData<>();
        div.setHdnSubGyomuCd(ControlDataHolder.getGyomuCD().value());
        div.setHdnGroupCode(サービス削除の旨);
        response.data = div;
        return response;
    }

    /**
     * ダイアログ上で選択したサービス削除の旨定型文情報を取得します。
     *
     * @param div 介護認定申請基本情報の入力用DIV
     * @return ResponseData
     */
    public ResponseData onOkClose_btnServiceDelTeikeibunGuide(NinteiShinseiTorokuDiv div) {
        ResponseData<NinteiShinseiTorokuDiv> response = new ResponseData<>();

        RStringBuilder serviceSakujo = new RStringBuilder(div.getTxtServiceDeleteRiyu().getValue() == null
                ? RString.EMPTY : div.getTxtServiceDeleteRiyu().getValue());
        serviceSakujo.append(div.getHdnTeikeibun());
        div.getTxtServiceDeleteRiyu().setValue(serviceSakujo.toRString());

        response.data = div;
        return response;
    }

    /**
     * 一覧画面に遷移する。
     *
     * @param div 審査依頼受付／みなし２号審査受付Div
     * @return ResponseData<NinteiShinseiTorokuDiv>
     */
    public ResponseData<NinteiShinseiTorokuDiv> onClick_btnBackToIchiran(NinteiShinseiTorokuDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.画面遷移の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        RStringBuilder 前排他制御 = new RStringBuilder();
        前排他制御.append("DBEShinseishoKanriNo");
        前排他制御.append(ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class));
        前排他キーの解除(前排他制御.toRString());
        return ResponseData.of(div).forwardWithEventName(DBE1010001TransitionEventName.一覧に戻る).respond();
    }

    /**
     * 保存する　ボタン
     *
     *
     * @param div 審査依頼受付／みなし２号審査受付Div
     * @return ResponseData<NinteiShinseiTorokuDiv>
     */
    public ResponseData<NinteiShinseiTorokuDiv> onClick_btnUpdate(NinteiShinseiTorokuDiv div) {
        IParentResponse<NinteiShinseiTorokuDiv> response = ResponseData.of(div);
        RString menuID = ResponseHolder.getMenuID();
        ShinsakaiIinItiranData dataList = DataPassingConverter.deserialize(div.getHdnJogaiShinsainJoho(), ShinsakaiIinItiranData.class);
        NinteiShinseiBusinessCollection zenkaiJoho = DataPassingConverter.deserialize(div.getHdnRenrakusakiJoho(), NinteiShinseiBusinessCollection.class);
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
//        NinteiChosaJokyoDataPass zenkai = DataPassingConverter.deserialize(div.getHdnZenkai(), NinteiChosaJokyoDataPass.class);
//        NinteiChosaJokyoDataPass konkai = DataPassingConverter.deserialize(div.getHdnKonkai(), NinteiChosaJokyoDataPass.class);

        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes
                && new RString(UrInformationMessages.正常終了.getMessage().getCode()).equals(ResponseHolder.getMessageCode())) {
            div.getCcdKanryoMessage().setMessage(new RString("要介護認定申請情報の保存処理が完了しました。"),
                    new RString("被保険者番号"), 
                    div.getCcdShikakuInfo().getTxtHihokenshaNo().getValue(), 
                    div.getTplShinseishaJoho().getTxtJohoAtenaMeisho().getDomain().getColumnValue(), true);
            return goToKanryo(response);
        }
        
        validationMessages.add(getValidationHandler(div).取下日理由必須チェック());
        validationMessages.add(getValidationHandler(div).区分変更申請時取下日理由入力チェック());
        validationMessages.add(getValidationHandler(div).申請サービス削除と取下理由存在チェック());
        validationMessages.add(getValidationHandler(div).特定疾病入力必須チェック());

        if (MENUID_DBEMN31003.equals(menuID)) {
            ViewStateHolder.put(ViewStateKeys.処理モード, Boolean.TRUE);
            ShinseishoKanriNo 申請書管理番号 = get申請書管理番号(div);
            NinteiShinseiJoho ninteiShinseiJoho = get要介護認定申請情報(div, 申請書管理番号);
            ShinseitodokedeJoho shinseitodokedeJoho = get認定申請届出者情報(div, true, 申請書管理番号);
            ShinseiRirekiJoho shinseiRirekiJoho = get申請履歴情報(申請書管理番号);
            NinteiKekkaJoho ninteiKekkaJoho = get認定結果情報(申請書管理番号);
            NinteiKeikakuJoho ninteiKeikakuJoho = get申請計画情報(申請書管理番号, div);
            
            if (manager.has要介護認定申請情報(ninteiShinseiJoho.get被保険者番号(), 
                    ninteiShinseiJoho.get認定申請年月日(), 
                    new Code(ninteiShinseiJoho.get要介護申請_要支援申請の区分()), 
                    ninteiShinseiJoho.get認定申請区分_申請時_コード(), 
                    ninteiShinseiJoho.get認定申請区分_法令_コード())) {
                if (!ResponseHolder.isReRequest()) {
                    return ResponseData.of(div).addMessage(DbzWarningMessages.確認.getMessage().replace(重複質問MSG)).respond();
                }
                if (new RString(DbzWarningMessages.確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                        && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                    return ResponseData.of(div).respond();
                }
            }
            validationMessages.add(getValidationHandler(div).被保険者区分チェック());
            validationMessages.add(getValidationHandler(div).有効期間チェック());

            if (validationMessages.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();
            }
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.確認_汎用.getMessage().replace(作成.toString()).getCode(),
                        UrQuestionMessages.確認_汎用.getMessage().replace(作成.toString()).evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.確認_汎用.getMessage().replace(作成.toString()).getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                manager.save要介護認定申請情報(ninteiShinseiJoho);
                manager.save申請届出情報(shinseitodokedeJoho);
                manager.save申請履歴情報(shinseiRirekiJoho);
                for (RenrakusakiJoho renrakusakiJoho : zenkaiJoho.getDbdBusiness()) {
                    manager.save介護連絡先情報(set介護連絡先情報(renrakusakiJoho, true, 申請書管理番号));
                }
                add審査会委員除外情報(申請書管理番号, dataList);
                manager.save認定結果情報(ninteiKekkaJoho);
                manager.save申請計画情報(ninteiKeikakuJoho);
                dbt5105Manager.save要介護認定完了情報(new NinteiKanryoJoho(申請書管理番号));

                RStringBuilder 前排他制御 = new RStringBuilder();
                前排他制御.append("DBEShinseishoKanriNo");
                前排他制御.append(申請書管理番号);
                前排他キーの解除(前排他制御.toRString());
                return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage().replace("みなし２号審査受付")).respond();
            }
            return ResponseData.of(div).respond();
        } else {
            NinteiShinseiJoho shinseiJoho = ViewStateHolder.get(ViewStateKeys.要介護認定申請情報, NinteiShinseiJoho.class);

            if (KEY1.equals(div.getRadMode().getSelectedKey())) {
                return doSakujo(response, div, validationMessages, shinseiJoho);
            } else {
                return doUpdate(response, div, validationMessages, zenkaiJoho, dataList, shinseiJoho);
            }
        }
    }

    private ResponseData<NinteiShinseiTorokuDiv> goToKanryo(IParentResponse<NinteiShinseiTorokuDiv> response) {
        if (ViewStateHolder.get(ViewStateKeys.処理モード, Boolean.class)) {
            return response.setState(DBE1010001StateName.完了遷移有);
        } else {
            return response.setState(DBE1010001StateName.完了);
        }
    }

    private ResponseData<NinteiShinseiTorokuDiv> doUpdate(IParentResponse<NinteiShinseiTorokuDiv> response, NinteiShinseiTorokuDiv div,
            ValidationMessageControlPairs validationMessages, NinteiShinseiBusinessCollection zenkaiJoho, ShinsakaiIinItiranData dataList,
            NinteiShinseiJoho shinseiJoho) {
        KaigoNinteiShinseiKihonJohoInputDiv kihonJohoInputDiv = div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv();
        FlexibleDate IF送付年月日 = ViewStateHolder.get("送付年月日", FlexibleDate.class);
        FlexibleDate センター送信年月日 = ViewStateHolder.get("センター送信年月日", FlexibleDate.class);
        FlexibleDate 認定申請情報登録完了年月日 = ViewStateHolder.get("認定申請情報登録完了年月日", FlexibleDate.class);
        if (認定申請情報登録完了年月日 != null && !認定申請情報登録完了年月日.isEmpty()) {
            ViewStateHolder.put(ViewStateKeys.処理モード, Boolean.FALSE);
        } else {
            ViewStateHolder.put(ViewStateKeys.処理モード, Boolean.TRUE);
        }

        validationMessages.add(getValidationHandler(div).センタ送信データ出力完了更新不可チェック(センター送信年月日));
        validationMessages.add(getValidationHandler(div).認定審査会割当完了更新不可チェック(IF送付年月日));

        Boolean 変更有無フラグ1 = Boolean.FALSE;
        NinteiShinseiJohoBuilder shinseiJohoBuilder = get要介護認定申請情報Com(div, kihonJohoInputDiv, shinseiJoho);

        変更有無フラグ1 = shinseiJohoBuilder.build().toEntity().hasChanged();

        Boolean 変更有無フラグ2 = 介護連絡先情報変更有無フラグ(zenkaiJoho.getDbdBusiness());
        Boolean 変更有無フラグ3 = Boolean.FALSE;

        ShinseitodokedeJoho shinseitodokedeJoho = get認定申請届出者情報(div, false, ShinseishoKanriNo.EMPTY);
        if (shinseitodokedeJoho != null) {
            変更有無フラグ3 = shinseitodokedeJoho.toEntity().hasChanged();
        }
        Boolean 変更有無フラグ4 = Boolean.FALSE;
        if (dataList != null && dataList.getShinsakaiIinItiranList() != null) {
            変更有無フラグ4 = Boolean.TRUE;
        }
        if (!(変更有無フラグ1 || 変更有無フラグ2 || 変更有無フラグ3 || 変更有無フラグ4)) {
            validationMessages.add(getValidationHandler(div).編集なしチェック(Boolean.TRUE));
        } else {
            validationMessages.add(getValidationHandler(div).有効期間チェック());
        }
        if (validationMessages.iterator().hasNext()) {
            return response.addValidationMessages(validationMessages).respond();
        }

        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.確認_汎用.getMessage().replace(更新.toString()).getCode(),
                    UrQuestionMessages.確認_汎用.getMessage().replace(更新.toString()).evaluate());
            return response.addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.確認_汎用.getMessage().replace(更新.toString()).getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            if (NinteiShinseiShinseijiKubunCode.新規申請.getコード().equals(kihonJohoInputDiv.getDdlShinseiKubunShinseiji().getSelectedKey())
                    || NinteiShinseiShinseijiKubunCode.更新申請.getコード().equals(kihonJohoInputDiv.getDdlShinseiKubunShinseiji().getSelectedKey())) {
                manager.save要介護認定申請情報(shinseiJohoBuilder.build().modifiedModel());
            } else if (NinteiShinseiShinseijiKubunCode.区分変更申請.getコード().equals(kihonJohoInputDiv.getDdlShinseiKubunShinseiji().getSelectedKey())) {
                //「編集仕様：区分変更」としてデータを更新する
                shinseiJohoBuilder.set申請サービス削除の理由(div.getServiceDel().getTxtServiceDeleteRiyu().getValue());
                shinseiJohoBuilder.set取下区分コード(new Code(TorisageKubunCode.認定申請有効.getコード()));
                manager.save要介護認定申請情報(shinseiJohoBuilder.build().modifiedModel());
            } else if (div.getTxtTorisageDate().getValue() != null && !div.getTxtTorisageJiyu().getValue().isEmpty()) {
                shinseiJohoBuilder.set取下区分コード(new Code(div.getDdlTorisageJiyu().getSelectedKey()));
                shinseiJohoBuilder.set認定申請有効区分(new Code(NinteiShinseiYukoKubunCode.無効.getコード()));
                shinseiJohoBuilder.set審査継続区分(false);
                shinseiJohoBuilder.set論理削除フラグ(false);
                manager.save要介護認定申請情報(shinseiJohoBuilder.build().modifiedModel());
            } else if (NinteiShinseiShinseijiKubunCode.資格喪失_死亡.getコード().equals(kihonJohoInputDiv.getDdlShinseiKubunShinseiji().getSelectedKey())) {
                //「編集仕様：資格喪失」としてデータを更新する
                shinseiJohoBuilder.set認定申請有効区分(new Code(NinteiShinseiYukoKubunCode.無効.getコード()));
                shinseiJohoBuilder.set審査継続区分(false);
                manager.save要介護認定申請情報(shinseiJohoBuilder.build().modifiedModel());
            } else {
                manager.save要介護認定申請情報(shinseiJohoBuilder.build().modifiedModel());
            }
            save介護連絡先情報(zenkaiJoho.getDbdBusiness());
            ShinseishoKanriNo 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
            del審査会委員除外情報(申請書管理番号, dataList);
            add審査会委員除外情報(申請書管理番号, dataList);
            if (shinseitodokedeJoho != null) {
                manager.save申請届出情報(shinseitodokedeJoho);
            }

            RStringBuilder 前排他制御 = new RStringBuilder();
            前排他制御.append("DBEShinseishoKanriNo");
            前排他制御.append(申請書管理番号.value());
            前排他キーの解除(前排他制御.toRString());
            return response.addMessage(UrInformationMessages.正常終了.getMessage().replace("審査依頼受付")).respond();
        }
        return response.respond();
    }

    private ResponseData<NinteiShinseiTorokuDiv> doSakujo(IParentResponse<NinteiShinseiTorokuDiv> response, NinteiShinseiTorokuDiv div,
            ValidationMessageControlPairs validationMessages, NinteiShinseiJoho shinseiJoho) {
        ViewStateHolder.put(ViewStateKeys.処理モード, Boolean.FALSE);
        ShinseishoKanriNo 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        FlexibleDate 認定申請情報登録完了年月日 = ViewStateHolder.get("認定申請情報登録完了年月日", FlexibleDate.class);

        if (validationMessages.iterator().hasNext()) {
            return response.addValidationMessages(validationMessages).respond();
        }

        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.確認_汎用.getMessage().replace(削除.toString()).getCode(),
                    UrQuestionMessages.確認_汎用.getMessage().replace(削除.toString()).evaluate());
            return response.addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.確認_汎用.getMessage().replace(削除.toString()).getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {

            if (認定申請情報登録完了年月日 != null && !認定申請情報登録完了年月日.isEmpty()) {
                NinteiShinseiJohoBuilder shinseiJohoBuilder = get要介護認定申請情報Com(div, div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv(), shinseiJoho);
                shinseiJohoBuilder.set論理削除フラグ(true);
                manager.save要介護認定申請情報(shinseiJohoBuilder.build().modifiedModel());
                doDel認定調査and主治医意見書作成依頼情報(申請書管理番号);

            } else {
                manager.deleteAllBy申請書管理番号(申請書管理番号.value());
            }
            return response.addMessage(UrInformationMessages.正常終了.getMessage().replace("要介護認定申請削除")).respond();
        }
        return response.respond();
    }

    private void doDel認定調査and主治医意見書作成依頼情報(ShinseishoKanriNo 申請書管理番号) {
        NinteichosaIraiJohoManager ninteichosaIraiJohoManager = NinteichosaIraiJohoManager.createInstance();
        List<NinteichosaIraiJoho> list = ninteichosaIraiJohoManager.get認定調査依頼情報リストBy申請書管理番号(申請書管理番号);
        for (NinteichosaIraiJoho ninteichosaIraiJoho : list) {
            ninteichosaIraiJohoManager.save(ninteichosaIraiJoho.createBuilderForEdit().set論理削除フラグ(true).build());
        }

        ShujiiIkenshoIraiJohoManager shujiiIkenshoIraiJohoManager = ShujiiIkenshoIraiJohoManager.createInstance();
        List<ShujiiIkenshoIraiJoho> shujiiIkenshoIraiJohoList = shujiiIkenshoIraiJohoManager.get主治医意見書作成依頼情報リストBy申請書管理番号(申請書管理番号);
        for (ShujiiIkenshoIraiJoho shujiiIkenshoIraiJoho : shujiiIkenshoIraiJohoList) {
            shujiiIkenshoIraiJohoManager.save主治医意見書作成依頼情報(shujiiIkenshoIraiJoho.createBuilderForEdit().set論理削除フラグ(true).build());
        }

    }

    public ResponseData<NinteiShinseiTorokuDiv> onClick_btnGotoKihonUnyo(NinteiShinseiTorokuDiv div) {

        return ResponseData.of(div).forwardWithEventName(DBE1010001TransitionEventName.完了).parameter(完了param);
    }

    private NinteiShinseiTorokuHandler getHandler(NinteiShinseiTorokuDiv div) {
        return new NinteiShinseiTorokuHandler(div);
    }

    private NinteiShinseiTorokuValidationHandler getValidationHandler(NinteiShinseiTorokuDiv div) {
        return new NinteiShinseiTorokuValidationHandler(div);
    }

    private void setIconName(NinteiShinseiTorokuDiv div, ShinseishoKanriNo 申請書管理番号) {
        if (!manager.get除外審査会委員情報(申請書管理番号).records().isEmpty()) {
            div.getBtnJogaiShinsakaiIinGuide().setIconNameEnum(IconName.Check);
        }
    }

    private void del審査会委員除外情報(ShinseishoKanriNo 申請書管理番号, ShinsakaiIinItiranData dataList) {
        if (dataList != null && dataList.getShinsakaiIinItiranList() != null) {
            for (ShinsakaiIinItiran data : dataList.getShinsakaiIinItiranList()) {
                manager.del除外審査会委員情報(申請書管理番号, data.getShinsakaiIinCode());
            }
        }
    }

    private void add審査会委員除外情報(ShinseishoKanriNo 申請書管理番号, ShinsakaiIinItiranData dataList) {
        if (dataList != null && dataList.getShinsakaiIinItiranList() != null) {
            int reban = 1;
            for (ShinsakaiIinItiran data : dataList.getShinsakaiIinItiranList()) {
                ShinsakaiIinJogaiJoho iinJogaiJoho = new ShinsakaiIinJogaiJoho(申請書管理番号, reban);
                ShinsakaiIinJogaiJohoBuilder builder = iinJogaiJoho.createBuilderForEdit();
                builder.set除外対象審査会委員コード(data.getShinsakaiIinCode());
                manager.save審査会委員除外情報(builder.build());
                reban = reban + 1;
            }
        }
    }

    private boolean 審査会委員除外情報変更有無フラグ(ShinseishoKanriNo 申請書管理番号, ShinsakaiIinItiranData dataList) {
        Boolean flag = Boolean.FALSE;
        if (dataList != null && dataList.getShinsakaiIinItiranList() != null) {
            int reban = 1;
            for (ShinsakaiIinItiran data : dataList.getShinsakaiIinItiranList()) {
                ShinsakaiIinJogaiJoho iinJogaiJoho = new ShinsakaiIinJogaiJoho(申請書管理番号, reban);
                ShinsakaiIinJogaiJohoBuilder builder = iinJogaiJoho.createBuilderForEdit();
                builder.set除外対象審査会委員コード(data.getShinsakaiIinCode());
                flag = builder.build().toEntity().hasChanged();
                if (flag) {
                    break;
                }

                reban = reban + 1;
            }
        }
        return flag;
    }

    private void save介護連絡先情報(List<RenrakusakiJoho> 介護連絡先情報リスト) {
        if (!RString.isNullOrEmpty(ViewStateHolder.get(ViewStateKeys.一覧データ, RString.class))) {
            for (RenrakusakiJoho renrakusakiJoho : 介護連絡先情報リスト) {
                if (renrakusakiJoho.toEntity().getState() == EntityDataState.Added) {
                    manager.save介護連絡先情報(set介護連絡先情報(renrakusakiJoho, false, ShinseishoKanriNo.EMPTY));
                } else if (renrakusakiJoho.toEntity().getState() == EntityDataState.Deleted) {
                    manager.del介護連絡先情報(renrakusakiJoho);
                } else {
                    manager.save介護連絡先情報(renrakusakiJoho);
                }
            }
        } else {
            for (RenrakusakiJoho renrakusakiJoho : 介護連絡先情報リスト) {
                manager.save介護連絡先情報(set介護連絡先情報(renrakusakiJoho, false, ShinseishoKanriNo.EMPTY));
            }
        }
    }

    private boolean 介護連絡先情報変更有無フラグ(List<RenrakusakiJoho> 介護連絡先情報リスト) {
        Boolean flag = Boolean.FALSE;
        if (!RString.isNullOrEmpty(ViewStateHolder.get(ViewStateKeys.一覧データ, RString.class))) {
            for (RenrakusakiJoho renrakusakiJoho : 介護連絡先情報リスト) {
                if (renrakusakiJoho.toEntity().getState() == EntityDataState.Added) {
                    flag = Boolean.TRUE;
                    break;
                } else if (renrakusakiJoho.toEntity().getState() == EntityDataState.Deleted) {
                    flag = Boolean.TRUE;
                    break;
                } else {
                    flag = renrakusakiJoho.toEntity().hasChanged();
                    if (flag) {
                        break;
                    }
                }
            }
        } else {
            for (RenrakusakiJoho renrakusakiJoho : 介護連絡先情報リスト) {
                flag = set介護連絡先情報(renrakusakiJoho, false, ShinseishoKanriNo.EMPTY).toEntity().hasChanged();
                if (flag) {
                    break;
                }
            }
        }
        return flag;
    }

    private RenrakusakiJoho set介護連絡先情報(RenrakusakiJoho renrakusakiJoho, boolean flag, ShinseishoKanriNo 申請書管理番号) {
        RenrakusakiJoho renrakusaki = null;
        if (flag) {
            renrakusaki = new RenrakusakiJoho(申請書管理番号, renrakusakiJoho.get連番());
        } else {
            renrakusaki = new RenrakusakiJoho(ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class), renrakusakiJoho.get連番());
        }
        RenrakusakiJohoBuilder renrakusakiBuilder = renrakusaki.createBuilderForEdit();
        renrakusakiBuilder.set連絡先区分番号(renrakusakiJoho.get連絡先区分番号());
        if (renrakusakiJoho.get支所コード() != null) {
            renrakusakiBuilder.set支所コード(renrakusakiJoho.get支所コード());
        }
        renrakusakiBuilder.set連絡先氏名(renrakusakiJoho.get連絡先氏名());
        renrakusakiBuilder.set連絡先氏名カナ(renrakusakiJoho.get連絡先氏名カナ());
        renrakusakiBuilder.set連絡先続柄(renrakusakiJoho.get連絡先続柄());
        renrakusakiBuilder.set連絡先郵便番号(renrakusakiJoho.get連絡先郵便番号());
        renrakusakiBuilder.set連絡先住所(renrakusakiJoho.get連絡先住所());
        renrakusakiBuilder.set連絡先電話番号(renrakusakiJoho.get連絡先電話番号());
        renrakusakiBuilder.set連絡先携帯番号(renrakusakiJoho.get連絡先携帯番号());
        renrakusakiBuilder.set優先順位(renrakusakiJoho.get優先順位());
        return renrakusakiBuilder.build();
    }

    private NinteiShinseiJohoBuilder get要介護認定申請情報Com(NinteiShinseiTorokuDiv div,
            KaigoNinteiShinseiKihonJohoInputDiv kihonJohoInputDiv, NinteiShinseiJoho shinseiJoho) {
        NinteiShinseiJohoBuilder shinseiJohoBuilder = shinseiJoho.createBuilderForEdit();
        shinseiJohoBuilder.set申請年度(new FlexibleYear(kihonJohoInputDiv
                .getTxtShinseiYMD().getValue().getYear().toDateString()));
        shinseiJohoBuilder.set認定申請年月日(rDateTOFlexDate(kihonJohoInputDiv
                .getTxtShinseiYMD().getValue()));
        shinseiJohoBuilder.set被保険者区分コード(kihonJohoInputDiv.getDdlHihokenshaKubun().getSelectedKey());
        
        shinseiJohoBuilder.set生年月日(rDateTOFlexDate(div.getTplShinseishaJoho().getTxtJohoBirthday().getValue()));
        if (!RString.isNullOrEmpty(div.getTplShinseishaJoho().getRadJohoSeibetsu().getSelectedKey())) {
            shinseiJohoBuilder.set性別(new Code(div.getTplShinseishaJoho().getRadJohoSeibetsu().getSelectedKey()));
        }
        shinseiJohoBuilder.set被保険者氏名カナ(div.getTplShinseishaJoho().getTxtJohoAtenaKanaMeisho().getDomain());
        shinseiJohoBuilder.set被保険者氏名(div.getTplShinseishaJoho().getTxtJohoAtenaMeisho().getDomain());
        shinseiJohoBuilder.set郵便番号(div.getTplShinseishaJoho().getTxtJohoYubinNo().getValue());
        shinseiJohoBuilder.set住所(div.getTplShinseishaJoho().getTxtJohoJusho().getDomain());
        shinseiJohoBuilder.set電話番号(div.getTplShinseishaJoho().getTxtJohoTelNo().getDomain());
        if (!RString.isNullOrEmpty(div.getTplShinseishaJoho().getTxtJohoNenrei().getValue())) {
            shinseiJohoBuilder.set年齢(div.getTplShinseishaJoho().getTxtJohoNenrei().getValue().replace(歳, RString.EMPTY).toInt());
        }
        shinseiJohoBuilder.set認定申請理由(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getTxtNinteiShinseRiyu().getValue());
        shinseiJohoBuilder.set２号特定疾病コード(new Code(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getDdlTokuteiShippei().getSelectedKey()));
        shinseiJohoBuilder.set情報提供への同意有無(div.getChkJohoTeikyoDoi().isAllSelected());
        shinseiJohoBuilder.set認定調査委託先コード(new ChosaItakusakiCode(div.getCcdChodsItakusakiAndChosainInput().getTxtChosaItakusakiCode().getValue()));
        shinseiJohoBuilder.set認定調査員コード(new ChosainCode(div.getCcdChodsItakusakiAndChosainInput().getTxtChosainCode().getValue()));
        shinseiJohoBuilder.set調査員への連絡事項(div.getCcdChodsItakusakiAndChosainInput().getChosainRenrakuJiko());
        shinseiJohoBuilder.set主治医医療機関コード(div.getCcdShujiiIryokikanAndShujiiInput().getIryoKikanCode());
        shinseiJohoBuilder.set主治医コード(div.getCcdShujiiIryokikanAndShujiiInput().getShujiiCode());
        shinseiJohoBuilder.set指定医フラグ(div.getCcdShujiiIryokikanAndShujiiInput().hasShiteii());
        shinseiJohoBuilder.set主治医への連絡事項(div.getCcdShujiiIryokikanAndShujiiInput().getRenrakuJiko());
        shinseiJohoBuilder.set認定延期通知発行しないことに対する同意有無(div.getChkNinteiTsuchishoDoi().isAllSelected());
        if (RString.isNullOrEmpty(div.getShisetsuJoho().getTxtNyushoShisetsu().getValue())) {
            shinseiJohoBuilder.set施設入所の有無(true);
        } else {
            shinseiJohoBuilder.set施設入所の有無(false);
        }
//        if (!RString.isNullOrEmpty(div.getCcdShisetsuJoho().getNyuryokuShisetsuKodo())) {
//            shinseiJohoBuilder.set入所施設コード(new JigyoshaNo(div.getCcdShisetsuJoho().getNyuryokuShisetsuKodo()));
//        }
        shinseiJohoBuilder.set訪問調査先郵便番号(div.getTxtYubinNo().getValue());
        shinseiJohoBuilder.set訪問調査先住所(div.getTxtJusho().getDomain());
        shinseiJohoBuilder.set訪問調査先名称(new AtenaMeisho(div.getTxtChosasakiName().getValue()));
        shinseiJohoBuilder.set訪問調査先電話番号(div.getTxtTelNo().getDomain());
        if (!RString.isNullOrEmpty(div.getHdnShichosonRenrakuJiko())) {
            shinseiJohoBuilder.set市町村連絡事項(div.getHdnShichosonRenrakuJiko());
        }
        shinseiJohoBuilder.set延期決定年月日(rDateTOFlexDate(div.getTxtEnkiKetteiYMD().getValue()));
        shinseiJohoBuilder.set延期理由(div.getTxtEnkiRiyu().getValue());
        shinseiJohoBuilder.set延期通知発行年月日(rDateTOFlexDate(div.getTxtEnkiTsuchiHakkoYMD().getValue()));
        if (div.getTxtEnkiTsuchishoHakkoCount().getValue() != null) {
            shinseiJohoBuilder.set延期通知発行回数(div.getTxtEnkiTsuchishoHakkoCount().getValue().intValue());
        }
        shinseiJohoBuilder.set延期見込期間開始年月日(rDateTOFlexDate(div.getTxtEnkiMikomiKikan().getFromValue()));
        shinseiJohoBuilder.set延期見込期間終了年月日(rDateTOFlexDate(div.getTxtEnkiMikomiKikan().getToValue()));
        shinseiJohoBuilder.set申請サービス削除の理由(div.getServiceDel().getTxtServiceDeleteRiyu().getValue());
        shinseiJohoBuilder.set介護認定審査会優先振分区分コード(new Code(div.getDdlShinsakaiYusenKubun().getSelectedKey()));
        shinseiJohoBuilder.set自動割当除外者区分(div.getDdlWariateKubun().getSelectedKey());
        if (div.getServiceDel().getTxtServiceDeleteRiyu() == null || div.getServiceDel().getTxtServiceDeleteRiyu().getValue().isEmpty()) {
            shinseiJohoBuilder.set認定申請区分_申請時_コード(new Code(kihonJohoInputDiv.getDdlShinseiKubunShinseiji().getSelectedKey()));
        }
        shinseiJohoBuilder.set取下区分コード(new Code(div.getDdlTorisageJiyu().getSelectedKey()));
        if (div.getTxtTorisageDate().getValue() != null && !div.getTxtTorisageDate().getValue().toDateString().isEmpty()) {
            shinseiJohoBuilder.set取下年月日(div.getTxtTorisageDate().getValue().toFlexibleDate());
        }
        shinseiJohoBuilder.set取下理由(div.getTxtTorisageJiyu().getValue());
        //TODO 入所施設名		

        shinseiJohoBuilder.set論理削除フラグ(false);
        return shinseiJohoBuilder;
    }

    private ShinseiRirekiJoho get申請履歴情報(ShinseishoKanriNo 申請書管理番号) {
        ShinseiRirekiJoho shinseiRirekiJoho = new ShinseiRirekiJoho(申請書管理番号);
        ShinseiRirekiJohoBuilder shinseiRirekiJohoBuilder = shinseiRirekiJoho.createBuilderForEdit();
        Minashi2shisaiJoho business = ViewStateHolder.get(ViewStateKeys.みなし2号登録情報, Minashi2shisaiJoho.class);
        if (business != null && business.get前回申請書管理番号() != null && !business.get前回申請書管理番号().isEmpty()) {
            shinseiRirekiJohoBuilder.set前回申請管理番号(business.get前回申請書管理番号());
        } else {
            shinseiRirekiJohoBuilder.set前回申請管理番号(new ShinseishoKanriNo(RString.EMPTY.padZeroToLeft(ZERO_17)));
        }
        return shinseiRirekiJohoBuilder.build();
    }

    private NinteiKekkaJoho get認定結果情報(ShinseishoKanriNo 申請書管理番号) {
        NinteiKekkaJoho ninteiKekkaJoho = new NinteiKekkaJoho(申請書管理番号);
        NinteiKekkaJohoBuilder ninteiKekkaJohoBuilder = ninteiKekkaJoho.createBuilderForEdit();
        ninteiKekkaJohoBuilder.set二次判定年月日(FlexibleDate.EMPTY);
        ninteiKekkaJohoBuilder.set二次判定要介護状態区分コード(Code.EMPTY);
        ninteiKekkaJohoBuilder.set二次判定認定有効期間(0);
        return ninteiKekkaJohoBuilder.build();
    }

    private NinteiKeikakuJoho get申請計画情報(ShinseishoKanriNo 申請書管理番号, NinteiShinseiTorokuDiv div) {
        NinteiKeikakuJoho 認定計画情報 = new NinteiKeikakuJoho(申請書管理番号);
        NinteiKeikakuJohoBuilder ninteiKeikakuJohoBuilder = 認定計画情報.createBuilderForEdit();
        RDate 申請日 = div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getTxtShinseiYMD().getValue();
        if (申請日 != null && !申請日.toDateString().isEmpty()) {
            RDate configDate = RDate.getNowDate();
            int 調査依頼 = DbBusinessConfig.get(ConfigNameDBE.認定調査依頼予定年月日, configDate, SubGyomuCode.DBE認定支援).toInt();
            int 調査予定 = DbBusinessConfig.get(ConfigNameDBE.認定調査予定年月日, configDate, SubGyomuCode.DBE認定支援).toInt();
            int 作成依頼 = DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成依頼予定年月日, configDate, SubGyomuCode.DBE認定支援).toInt();
            int 登録予定 = DbBusinessConfig.get(ConfigNameDBE.主治医意見書登録予定年月日, configDate, SubGyomuCode.DBE認定支援).toInt();
            int 判定予定 = DbBusinessConfig.get(ConfigNameDBE.要介護認定一次判定予定年月日, configDate, SubGyomuCode.DBE認定支援).toInt();
            int 割当予定 = DbBusinessConfig.get(ConfigNameDBE.認定審査会割当予定年月日, configDate, SubGyomuCode.DBE認定支援).toInt();
            int 審査会予定 = DbBusinessConfig.get(ConfigNameDBE.認定審査会予定年月日, configDate, SubGyomuCode.DBE認定支援).toInt();
            int 送信予定 = DbBusinessConfig.get(ConfigNameDBE.センター送信予定年月日, configDate, SubGyomuCode.DBE認定支援).toInt();

            ninteiKeikakuJohoBuilder.set認定調査依頼予定年月日(申請日.toFlexibleDate().plusDay(調査依頼));
            ninteiKeikakuJohoBuilder.set認定調査予定年月日(申請日.toFlexibleDate().plusDay(調査予定));
            ninteiKeikakuJohoBuilder.set主治医意見書作成依頼予定年月日(申請日.toFlexibleDate().plusDay(作成依頼));
            ninteiKeikakuJohoBuilder.set主治医意見書登録予定年月日(申請日.toFlexibleDate().plusDay(登録予定));
            ninteiKeikakuJohoBuilder.set要介護認定一次判定予定年月日(申請日.toFlexibleDate().plusDay(判定予定));
            ninteiKeikakuJohoBuilder.set認定審査会割当予定年月日(申請日.toFlexibleDate().plusDay(割当予定));
            ninteiKeikakuJohoBuilder.set認定審査会予定年月日(申請日.toFlexibleDate().plusDay(審査会予定));
            ninteiKeikakuJohoBuilder.setセンター送信予定年月日(申請日.toFlexibleDate().plusDay(送信予定));
        }
        return ninteiKeikakuJohoBuilder.build();
    }

    private ShinseitodokedeJoho get認定申請届出者情報(NinteiShinseiTorokuDiv div, boolean flag, ShinseishoKanriNo 申請書管理番号) {
        ShinseitodokedeJoho todokedeJoho = null;
        if (flag) {
            todokedeJoho = new ShinseitodokedeJoho(申請書管理番号);
        } else {
            todokedeJoho = ViewStateHolder.get(ViewStateKeys.要介護認定申請届出情報, ShinseitodokedeJoho.class);
        }
        if (todokedeJoho != null) {
            ShinseitodokedeJohoBuilder todokedeJohoBuilder = todokedeJoho.createBuilderForEdit();
            NinteiShinseiTodokedeshaNaiyo todokedeshaNaiyo = div.getCcdShinseiTodokedesha().get一覧内容();
            todokedeJohoBuilder.set申請届出代行区分コード(new Code(todokedeshaNaiyo.get届出代行区分()));
            todokedeJohoBuilder.set申請届出者氏名(todokedeshaNaiyo.get氏名());
            todokedeJohoBuilder.set申請届出者氏名カナ(todokedeshaNaiyo.getカナ氏名());
            todokedeJohoBuilder.set申請届出者続柄コード(todokedeshaNaiyo.get本人との関係性());
            if (!RString.isNullOrEmpty(todokedeshaNaiyo.get事業者コード())) {
                todokedeJohoBuilder.set申請届出代行事業者番号(new JigyoshaNo(todokedeshaNaiyo.get事業者コード()));
            }
            todokedeJohoBuilder.set事業者区分(todokedeshaNaiyo.get申請関係者());
            if (new RString("key0").equals(todokedeshaNaiyo.get管内管外区分())) {
                todokedeJohoBuilder.set申請届出者郵便番号(todokedeshaNaiyo.get郵便番号());
                todokedeJohoBuilder.set申請届出者住所(todokedeshaNaiyo.get町域入力住所名称());
            }
            if (new RString("key1").equals(todokedeshaNaiyo.get管内管外区分())) {
                todokedeJohoBuilder.set申請届出者郵便番号(new YubinNo(todokedeshaNaiyo.get全国郵便番号()));
                todokedeJohoBuilder.set申請届出者住所(todokedeshaNaiyo.get全国住所名称());
            }
            todokedeJohoBuilder.set申請届出者電話番号(new TelNo(todokedeshaNaiyo.get電話番号()));
            return todokedeJohoBuilder.build();
        } else {
            return null;
        }
    }

    private NinteiShinseiJoho get要介護認定申請情報(NinteiShinseiTorokuDiv div, ShinseishoKanriNo 申請書管理番号) {
        NinteiShinseiJoho shinseiJoho = new NinteiShinseiJoho(申請書管理番号);
        NinteiShinseiJohoBuilder shinseiJohoBuilder = shinseiJoho.createBuilderForEdit();
        shinseiJohoBuilder.set厚労省IF識別コード(new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード()));
        shinseiJohoBuilder.set証記載保険者番号(div.getCcdShikakuInfo().getHookenshaCode());
        shinseiJohoBuilder.set申請年度(new FlexibleYear(div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv()
                .getTxtShinseiYMD().getValue().getYear().toDateString()));
        shinseiJohoBuilder.set被保険者番号(div.getCcdShikakuInfo().getTxtHihokenshaNo().getValue());
        shinseiJohoBuilder.set認定申請年月日(rDateTOFlexDate(div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv()
                .getTxtShinseiYMD().getValue()));
        shinseiJohoBuilder.set認定申請枝番コード(new EdabanCode(new RString("000")));
        shinseiJohoBuilder.set認定申請区分_法令_コード(new Code(div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv()
                .getDdlShinseiKubunHorei().getSelectedKey()));
        shinseiJohoBuilder.set認定申請区分_申請時_コード(new Code(div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv()
                .getDdlShinseiKubunShinseiji().getSelectedKey()));
        shinseiJohoBuilder.set取下区分コード(new Code(TorisageKubunCode.認定申請有効.getコード()));
        shinseiJohoBuilder.set被保険者区分コード(div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv()
                .getDdlHihokenshaKubun().getSelectedKey());
        shinseiJohoBuilder.set生年月日(rDateTOFlexDate(div.getTplShinseishaJoho().getTxtJohoBirthday().getValue()));
        if (!RString.isNullOrEmpty(div.getTplShinseishaJoho().getTxtJohoNenrei().getValue())) {
            shinseiJohoBuilder.set年齢(div.getTplShinseishaJoho().getTxtJohoNenrei().getValue().replace(歳, RString.EMPTY).toInt());
        }
        if (!RString.isNullOrEmpty(div.getTplShinseishaJoho().getRadJohoSeibetsu().getSelectedKey())) {
            shinseiJohoBuilder.set性別(new Code(div.getTplShinseishaJoho().getRadJohoSeibetsu().getSelectedKey()));
        }
        shinseiJohoBuilder.set被保険者氏名カナ(div.getTplShinseishaJoho().getTxtJohoAtenaKanaMeisho().getDomain());
        shinseiJohoBuilder.set被保険者氏名(div.getTplShinseishaJoho().getTxtJohoAtenaMeisho().getDomain());
        shinseiJohoBuilder.set郵便番号(div.getTplShinseishaJoho().getTxtJohoYubinNo().getValue());
        shinseiJohoBuilder.set住所(div.getTplShinseishaJoho().getTxtJohoJusho().getDomain());
        shinseiJohoBuilder.set電話番号(div.getTplShinseishaJoho().getTxtJohoTelNo().getDomain());
        shinseiJohoBuilder.set支所コード(div.getHdnShishoCode());
        //shinseiJohoBuilder.set識別コード(new ShikibetsuCode(div.getAtenaInfoToroku().get));
        shinseiJohoBuilder.set申請サービス削除の理由(div.getServiceDel().getTxtServiceDeleteRiyu().getValue());
        shinseiJohoBuilder.setみなし２号等対象フラグ(true);
        shinseiJohoBuilder.set広域内転居区分(new Code(KoikinaiTenkyoKubun.対象外.getコード()));
        shinseiJohoBuilder.set認定申請有効区分(new Code(NinteiShinseiYukoKubunCode.有効.getコード()));
        shinseiJohoBuilder.set要介護申請_要支援申請の区分(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getRadShinseishoKubun().getSelectedKey());
        shinseiJohoBuilder.set認定申請理由(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getTxtNinteiShinseRiyu().getValue());
        shinseiJohoBuilder.set前回要介護状態区分コード(new Code(div.getCcdZenkaiNinteiKekkaJoho().getTxtYokaigodo().getValue()));
        shinseiJohoBuilder.set前回認定年月日(div.getCcdZenkaiNinteiKekkaJoho().getTxtNinteiDay().getValue());
        shinseiJohoBuilder.set前回認定有効期間_開始_(div.getCcdZenkaiNinteiKekkaJoho().getTxtYukoKikanFrom().getValue());
        shinseiJohoBuilder.set前回認定有効期間_終了_(div.getCcdZenkaiNinteiKekkaJoho().getTxtYukoKikanTo().getValue());
        shinseiJohoBuilder.set２号医療保険者名(div.getHdnIryoHokenshaMeisho());
        shinseiJohoBuilder.set２号医療保険記号番号(div.getHdnIryoHokenKigoNo());
        shinseiJohoBuilder.set２号特定疾病コード(new Code(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getDdlTokuteiShippei().getSelectedKey()));
        shinseiJohoBuilder.set自動割当除外者区分(JidoWariateJyogaishaKubun.除外.getコード());
        shinseiJohoBuilder.set主治医医療機関コード(div.getCcdShujiiIryokikanAndShujiiInput().getIryoKikanCode());
        shinseiJohoBuilder.set主治医コード(div.getCcdShujiiIryokikanAndShujiiInput().getShujiiCode());
        shinseiJohoBuilder.set指定医フラグ(div.getCcdShujiiIryokikanAndShujiiInput().hasShiteii());
        shinseiJohoBuilder.set主治医への連絡事項(div.getCcdShujiiIryokikanAndShujiiInput().getRenrakuJiko());
        shinseiJohoBuilder.set情報提供への同意有無(div.getChkJohoTeikyoDoi().isAllSelected());
        shinseiJohoBuilder.set認定延期通知発行しないことに対する同意有無(div.getChkNinteiTsuchishoDoi().isAllSelected());
        if (RString.isNullOrEmpty(div.getShisetsuJoho().getTxtNyushoShisetsu().getValue())) {
            shinseiJohoBuilder.set施設入所の有無(true);
        } else {
            shinseiJohoBuilder.set施設入所の有無(false);
        }
//        if (!RString.isNullOrEmpty(div.getCcdShisetsuJoho().getNyuryokuShisetsuKodo())) {
//            shinseiJohoBuilder.set入所施設コード(new JigyoshaNo(div.getCcdShisetsuJoho().getNyuryokuShisetsuKodo()));
//        }
        shinseiJohoBuilder.set訪問調査先郵便番号(div.getTxtYubinNo().getValue());
        shinseiJohoBuilder.set訪問調査先住所(div.getTxtJusho().getDomain());
        shinseiJohoBuilder.set訪問調査先名称(new AtenaMeisho(div.getTxtChosasakiName().getValue()));
        shinseiJohoBuilder.set訪問調査先電話番号(div.getTxtTelNo().getDomain());
        if (!RString.isNullOrEmpty(div.getHdnShichosonRenrakuJiko())) {
            shinseiJohoBuilder.set市町村連絡事項(div.getHdnShichosonRenrakuJiko());
        }
        shinseiJohoBuilder.set認定申請情報登録年月日(FlexibleDate.getNowDate());
        shinseiJohoBuilder.set処理状態区分(new Code(ShoriJotaiKubun.通常.getコード()));
        shinseiJohoBuilder.set審査継続区分(false);
        shinseiJohoBuilder.set介護認定審査会優先振分区分コード(new Code(ShinsakaiYusenWaritsukeKubunCode.通常.getコード()));
        shinseiJohoBuilder.set論理削除フラグ(false);
        shinseiJohoBuilder.set認定調査委託先コード(new ChosaItakusakiCode(div.getCcdChodsItakusakiAndChosainInput().getTxtChosaItakusakiCode().getValue()));
        shinseiJohoBuilder.set認定調査員コード(new ChosainCode(div.getCcdChodsItakusakiAndChosainInput().getTxtChosainCode().getValue()));
        shinseiJohoBuilder.set調査員への連絡事項(div.getCcdChodsItakusakiAndChosainInput().getChosainRenrakuJiko());

        return shinseiJohoBuilder.build();
    }

    private void set連絡先(ShinseishoKanriNo 申請書管理番号, NinteiShinseiTorokuDiv div, boolean flag) {
        if (flag) {
            if (申請書管理番号 != null) {
                NinteiShinseiBusinessCollection zenkaiJoho = new NinteiShinseiBusinessCollection();
                zenkaiJoho.setDbdBusiness(manager.get介護連絡先情報(申請書管理番号).records());
                div.setHdnZenkaiRenrakusakiJoho(DataPassingConverter.serialize(zenkaiJoho));
            }
            div.setHdnRenrakusakiReadOnly(RString.EMPTY);
            NinteiShinseiBusinessCollection konkaiJoho = new NinteiShinseiBusinessCollection();
            konkaiJoho.setDbdBusiness(new ArrayList<RenrakusakiJoho>());
            div.setHdnRenrakusakiJoho(DataPassingConverter.serialize(konkaiJoho));
        } else {
            ShinseishoKanriNo 前回申請管理番号 = manager.get前回申請管理番号(申請書管理番号);
            if (前回申請管理番号 != null) {
                NinteiShinseiBusinessCollection zenkaiJoho = new NinteiShinseiBusinessCollection();
                zenkaiJoho.setDbdBusiness(manager.get介護連絡先情報(前回申請管理番号).records());
                div.setHdnZenkaiRenrakusakiJoho(DataPassingConverter.serialize(zenkaiJoho));
            }
            NinteiShinseiBusinessCollection konkaiJoho = new NinteiShinseiBusinessCollection();
            if (!manager.get介護連絡先情報(申請書管理番号).records().isEmpty()) {
                div.getBtnRenrakusaki().setIconNameEnum(IconName.Check);
                ViewStateHolder.put(ViewStateKeys.一覧データ, new RString("1"));
            }
            konkaiJoho.setDbdBusiness(manager.get介護連絡先情報(申請書管理番号).records());
            div.setHdnRenrakusakiJoho(DataPassingConverter.serialize(konkaiJoho));
            div.setHdnRenrakusakiReadOnly(RString.EMPTY);
        }

    }

    private FlexibleDate rDateTOFlexDate(RDate fromDate) {
        if (fromDate != null) {
            return new FlexibleDate(fromDate.getYearValue(), fromDate.getMonthValue(), fromDate.getDayValue());
        }
        return FlexibleDate.EMPTY;
    }

    private ShinseishoKanriNo get申請書管理番号(NinteiShinseiTorokuDiv div) {
        KaigoHokensha hokensha = dbt7050Manager.get介護保険者By広域保険者番号(new ShoKisaiHokenshaNo(div.getCcdShikakuInfo().getHookenshaCode()));
        RString 連番 = Saiban.get(SubGyomuCode.DBZ介護共通, SaibanHanyokeyName.市町村コード_西暦_月.getコード()).nextString();
        RStringBuilder rsb = new RStringBuilder();
        if (ZERO_6.equals(div.getCcdShikakuInfo().getHookenshaCode())) {
            rsb.append(ZERO_6);
        } else {
            rsb.append(hokensha.get広域保険者市町村コード().value());
        }
        rsb.append(RDate.getNowDate().getYearMonth().toDateString());
        rsb.append(連番.padZeroToLeft(ZERO_5));
        return new ShinseishoKanriNo(rsb.toRString());
    }
    
    private RStringBuilder nullToEmpty(RStringBuilder 所属機関, RString 名称) {
        if (!RString.isNullOrEmpty(名称)) {
            if (RString.isNullOrEmpty(所属機関.toRString())) {
                所属機関.append(名称);
            } else {
                所属機関.append(所属機関_TMP);
                所属機関.append(名称);
            }
        }
        return 所属機関;
    }
    
    private JogaiShinsainJohoFinder getService() {
        return JogaiShinsainJohoFinder.createInstance();
    }

    private void 前排他ロックキー(RString 排他ロックキー) {
        LockingKey 前排他ロックキー = new LockingKey(排他ロックキー);
        if (!RealInitialLocker.tryGetLock(前排他ロックキー)) {
            throw new PessimisticLockingException();
        }
    }

    private void 前排他キーの解除(RString 排他) {
        LockingKey 排他キー = new LockingKey(排他);
        RealInitialLocker.release(排他キー);
    }

}
