/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE1010001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseitoroku.NinteiShinseiTorokuResult;
import jp.co.ndensan.reams.db.dbe.business.core.seikatsuhogotoroku.Minashi2shisaiJoho;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1010001.AtenaInfoTorokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1010001.NinteiShinseiTorokuDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.HokenshaDDLPattem;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.db.dbz.business.config.FourMasterConfig;
import jp.co.ndensan.reams.db.dbz.business.core.basic.IryohokenKanyuJokyo;
import jp.co.ndensan.reams.db.dbz.business.core.ninteiinput.NinteiInputDataPassModel;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseitodokedesha.NinteiShinseiTodokedeshaDataPassModel;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.tokuteishippei.TokuteiShippei;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShienShinseiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShinseiTodokedeDaikoKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.TorisageKubunCode;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiTodokedesha.NinteiShinseiTodokedesha.NinteiShinseiTodokedeshaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInput.ChosaItakusakiAndChosainInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.ShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.AgeCalculator;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.DateOfBirthFactory;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.IDateOfBirth;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.ChoikiInput.ChoikiInputDiv;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.ZenkokuJushoInput.ZenkokuJushoInputDiv;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.IconName;

/**
 * 審査依頼受付／みなし２号審査受付の抽象Handlerクラスです。
 *
 * @reamsid_L DBE-1310-010 chengsanyuan
 */
public class NinteiShinseiTorokuHandler {

    private final NinteiShinseiTorokuDiv div;
    private static final int ZERO_10 = 10;
    private static final RString ZERO_6 = new RString("000000");
    private static final RString 歳 = new RString("歳");
    private static final RString みなし２号対象 = new RString("みなし２号");
    private static final RString KEY1 = new RString("key1");
    private static final RString 四マスタ管理方法_構成市町村 = new RString("1");
    private static final RString 照会状態 = new RString("ShokaiMode");
    /**
     * コンストラクタです。
     *
     * @param div 審査依頼受付／みなし２号審査受付Div
     */
    public NinteiShinseiTorokuHandler(NinteiShinseiTorokuDiv div) {
        this.div = div;

    }

    /**
     * 画面は審査依頼受付の場合、画面の初期化です
     *
     * @param result 申請情報
     * @param 管理番号 申請書管理番号
     * @param 被保険者番号 被保険者番号
     * @param 介護導入形態 介護導入形態
     * @param 市町村コード 市町村コード
     */
    public void loadUpdate(NinteiShinseiTorokuResult result, ShinseishoKanriNo 管理番号,
            RString 被保険者番号, RString 介護導入形態, LasdecCode 市町村コード) {
        div.getBtnIryohokenGuide().setDisabled(true);
        div.getBtnNyuinAndShisetsuNyusho().setDisabled(true);
        div.getCcdKaigoNinteiShinseiKihon().initialize();
        div.getCcdZenkaiNinteiKekkaJoho().onLoad(SubGyomuCode.DBE認定支援, 管理番号, new RString("1"));
        div.getCcdShinseiSonotaJohoInput().initialize();

        if (市町村コード != null) {
            div.getCcdShikakuInfo().initialize(市町村コード.value(), 被保険者番号);
        }
        if (result != null) {
            setCommonDiv(result, 管理番号);
        } else {
            div.getCcdShujiiIryokikanAndShujiiInput().initialize(LasdecCode.EMPTY,
                    管理番号, SubGyomuCode.DBE認定支援,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
            div.getCcdChodsItakusakiAndChosainInput().initialize(new RString("InputMode"),
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
            NinteiInputDataPassModel ninteiInput = new NinteiInputDataPassModel();
            ninteiInput.setSubGyomuCode(SubGyomuCode.DBE認定支援.value());
            ninteiInput.set申請書管理番号(管理番号);
//            div.getCcdShisetsuJoho().initialize();
            div.getCcdNinteiInput().initialize(ninteiInput);
            NinteiShinseiTodokedeshaDataPassModel dataPass = set届出情報();
            dataPass.set申請書管理番号(管理番号.value());
            div.getCcdShinseiTodokedesha().initialize(dataPass);
        }
    }

    /**
     * 画面はみなし２号審査受付の場合、画面の初期化です
     *
     * @param business 被保険者情報
     * @param 市町村コード 市町村コード
     * @param 介護導入形態 介護導入形態
     */
    public void loadInsert(Minashi2shisaiJoho business, LasdecCode 市町村コード, RString 介護導入形態) {
        div.getBtnIryohokenGuide().setDisabled(true);
        div.getBtnNyuinAndShisetsuNyusho().setDisabled(true);
        div.getBtnChosaJokyo().setDisabled(true);
        div.getTxtEnkiKetteiYMD().setDisabled(true);
        div.getTxtEnkiMikomiKikan().setDisabled(true);
        div.getBtnEnkiRiyuTeikeibun().setDisabled(true);
        div.getTxtEnkiRiyu().setDisabled(true);
        div.getTxtEnkiTsuchiHakkoYMD().setDisabled(true);
        div.getTxtEnkiTsuchishoHakkoCount().setDisabled(true);

        if (business.getカナ氏名() != null) {
            div.setHdnShimeiKana(business.getカナ氏名().value());
            div.getAtenaInfoToroku().getTxtKanaMeisho().setDomain(business.getカナ氏名());
        }
        div.getAtenaInfoToroku().getMeisho().setDomain(business.get氏名());
        if (business.get生年月日() != null && !business.get生年月日().toDateString().isEmpty()) {
            div.getAtenaInfoToroku().getSeinengabi().setValue(business.get生年月日());
            IDateOfBirth dob = DateOfBirthFactory.createInstance(business.get生年月日().toFlexibleDate());
            AgeCalculator agecalculator = new AgeCalculator(dob, JuminJotai.住民, FlexibleDate.MAX);
            RString 年齢 = agecalculator.get年齢();
            div.getAtenaInfoToroku().getNenrei().setValue(年齢.concat("歳"));
        }

        if (!business.get性別コード().isNullOrEmpty()) {
            div.getAtenaInfoToroku().getSeibetsu().setValue(Seibetsu.toValue(business.get性別コード()).get名称());
        }
        div.getAtenaInfoToroku().getYubinNo().setValue(business.get郵便番号());
        div.getAtenaInfoToroku().getJusho().setDomain(new AtenaJusho(business.get住所名称()));
        div.getAtenaInfoToroku().getTelNo().setDomain(business.get電話番号());
        div.setHdnShishoCode(business.get支所コード());

        if (市町村コード.isEmpty()) {
            市町村コード = AssociationFinderFactory.createInstance().getAssociation().get地方公共団体コード();
        }
        div.getCcdShikakuInfo().initialize(市町村コード.value(), business.get被保険者番号().value().padZeroToLeft(ZERO_10));
        div.getCcdKaigoNinteiShinseiKihon().initialize();
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (HihokenshaKubunCode hihokenshaKubun : HihokenshaKubunCode.values()) {
            dataSource.add(new KeyValueDataSource(hihokenshaKubun.getコード(), hihokenshaKubun.get名称()));
        }
        //dataSource.remove(new KeyValueDataSource(HihokenshaKubunCode.生活保護.getコード(), HihokenshaKubunCode.生活保護.get名称()));
        ((KaigoNinteiShinseiKihonJohoInputDiv) div.getCcdKaigoNinteiShinseiKihon()).getDdlHihokenshaKubun().setDataSource(dataSource);
        if (!RString.isNullOrEmpty(business.get支所コード())) {
            div.getCcdKaigoNinteiShinseiKihon().setShisho(new ShishoCode(business.get支所コード()));
        }
        div.getCcdShujiiIryokikanAndShujiiInput().initialize(business.get申請者所属市町村コード(),
                ShinseishoKanriNo.EMPTY, SubGyomuCode.DBE認定支援,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
        div.getCcdChodsItakusakiAndChosainInput().initialize(new RString("InputMode"),
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
        div.getCcdChodsItakusakiAndChosainInput().setHdnShinseishoKanriNo(RString.EMPTY);
        div.getCcdChodsItakusakiAndChosainInput().setHdnShichosonCode(business.get申請者所属市町村コード().value());
        //2 set今回情報
        if (business.get前回申請書管理番号() != null) {
            div.getCcdZenkaiNinteiKekkaJoho().onLoad(SubGyomuCode.DBE認定支援, business.get前回申請書管理番号(), new RString("1"));
        }
        NinteiInputDataPassModel ninteiInput = new NinteiInputDataPassModel();
        ninteiInput.setSubGyomuCode(SubGyomuCode.DBE認定支援.value());
        ninteiInput.set申請書管理番号(ShinseishoKanriNo.EMPTY);
        div.getCcdNinteiInput().initialize(ninteiInput);
        div.getCcdShinseiSonotaJohoInput().initialize();
//        div.getCcdShisetsuJoho().initialize();
    }

    /**
     * パネルの初期化です
     *
     * @param result 申請情報
     * @param ninteiTandokuDounyuFlag boolean
     */
    public void loadPnl(NinteiShinseiTorokuResult result, boolean ninteiTandokuDounyuFlag) {
        if (result != null) {
            div.getTxtServiceDeleteRiyu().setValue(result.get申請サービス削除の理由());

            if (result.get取下年月日() != null && !result.get取下年月日().isEmpty()) {
                div.getTxtTorisageDate().setValue(new RDate(result.get取下年月日().toString()));
            }
            if (result.get却下年月日() != null && !result.get却下年月日().isEmpty()) {
                div.getTxtTorisageDate().setValue(new RDate(result.get却下年月日().toString()));
            }
            if (result.get取下理由() != null && !result.get取下理由().isEmpty()) {
                div.getTxtTorisageJiyu().setValue(result.get取下理由());
            }
            if (result.get却下理由() != null && !result.get却下理由().isEmpty()) {
                div.getTxtTorisageJiyu().setValue(result.get却下理由());
            }
            if (result.get取下区分コード() != null && !TorisageKubunCode.認定申請有効.getコード().equals(result.get取下区分コード().value())) {
                div.getDdlTorisageJiyu().setSelectedKey(result.get取下区分コード().value());
            }
            if (result.get認定申請理由() == null || result.get認定申請理由().isEmpty()) {
                div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getNinteiShinseiRiyu().setIsOpen(false);
            }
            if (result.get申請サービス削除の理由() == null || result.get申請サービス削除の理由().isEmpty()) {
                div.getServiceDel().setIsOpen(false);
            }
            if (result.get取下区分コード() == null
                    || TorisageKubunCode.認定申請有効.getコード().equals(result.get取下区分コード().value())
                    || result.get取下区分コード().isEmpty()) {
                div.getSinseiTorisage().setIsOpen(false);
            }
            if (RString.isNullOrEmpty(result.get主治医医療機関コード()) && RString.isNullOrEmpty(result.get主治医コード())) {
                div.getShujiiAndShujiiIryoKikan().setIsOpen(false);
            }
            if (RString.isNullOrEmpty(result.get認定調査委託先コード()) && RString.isNullOrEmpty(result.get認定調査員コード())) {
                div.getChosainAndChosainInput().setIsOpen(false);
            }
            if (result.get訪問調査先名称() == null || RString.isNullOrEmpty(result.get訪問調査先名称().getColumnValue())) {
                div.getHomonSaki().setIsOpen(false);
            }
            if (result.get入所施設名称() == null
                    || RString.isNullOrEmpty(result.get入所施設名称().getColumnValue())) {
                div.getShisetsuJoho().setIsOpen(false);
            }

            if (result.isみなし２号等対象フラグ()) {
                div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getTxtMinasiFlag().setVisible(true);
                div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getTxtMinasiFlag().setValue(みなし２号対象);
            }
        } else {
            closePanle();
        }
        ((ZenkokuJushoInputDiv) div.getCcdShinseiTodokedesha().getCcdZenkokuJushoInput()).getTxtZenkokuJushoCode().setDisplayNone(ninteiTandokuDounyuFlag);
        ((ZenkokuJushoInputDiv) div.getCcdShinseiTodokedesha().getCcdZenkokuJushoInput()).getBtnZenkokuJushoGuide().setDisplayNone(ninteiTandokuDounyuFlag);
        ((ZenkokuJushoInputDiv) div.getCcdShinseiTodokedesha().getCcdZenkokuJushoInput()).getTxtJusho().setReadOnly(!ninteiTandokuDounyuFlag);
        div.getCcdShinseiTodokedesha().getTxtTelNo().setLabelLWidth(new RString("S"));
        div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getServiceSakujo().setDisplayNone(true);
        if (div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShisho().getDataSource().isEmpty()
                || div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShisho().getDataSource().size() < 2) {
            div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShisho().setDisplayNone(Boolean.TRUE);
        }
        div.getBtnTainoJokyo().setDisplayNone(ninteiTandokuDounyuFlag);
        div.getCcdNinteiInput().setDisplayNone(true);
        div.getCcdShinseiSonotaJohoInput().setDisplayNone(true);
    }

    /**
     * パネルを閉じる
     *
     */
    public void closePanle() {
        div.getSinseiTorisage().setIsOpen(false);
        div.getShujiiAndShujiiIryoKikan().setIsOpen(false);
        div.getChosainAndChosainInput().setIsOpen(false);
        div.getHomonSaki().setIsOpen(false);
        div.getShisetsuJoho().setIsOpen(false);
        div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getNinteiShinseiRiyu().setIsOpen(false);
        div.getServiceDel().setIsOpen(false);
    }

    /**
     * 申請者情報パネルの初期化です
     *
     * @param 所属市町村コード 所属市町村コード
     * @param isみなし2号登録 みなし2号登録ならTrue
     */
    public void loadPnlSinseishaJoho(LasdecCode 所属市町村コード, boolean isみなし2号登録) {
        AtenaInfoTorokuDiv atenaDiv = div.getHeadPanel().getAtenaInfoToroku();
        div.getTplShinseishaJoho().getTxtJohoAtenaMeisho().setDomain(atenaDiv.getMeisho().getDomain());
        div.getTplShinseishaJoho().getTxtJohoAtenaKanaMeisho().setDomain(atenaDiv.getTxtKanaMeisho().getDomain());
        div.getTplShinseishaJoho().getTxtJohoBirthday().setValue(atenaDiv.getSeinengabi().getValue());
        div.getTplShinseishaJoho().getRadJohoSeibetsu().setSelectedKey(Seibetsu.男.get名称().equals(atenaDiv.getSeibetsu().getValue())
                ? Seibetsu.男.getコード() : Seibetsu.女.getコード());
        div.getTplShinseishaJoho().getTxtJohoYubinNo().setValue(atenaDiv.getYubinNo().getValue());
        div.getTplShinseishaJoho().getTxtJohoJusho().setDomain(atenaDiv.getJusho().getDomain());
        div.getTplShinseishaJoho().getTxtJohoTelNo().setDomain(atenaDiv.getTelNo().getDomain());
        div.getTplShinseishaJoho().getTxtJohoNenrei().setValue(atenaDiv.getNenrei().getValue());
        if (四マスタ管理方法_構成市町村.equals(new FourMasterConfig().get四マスタ管理方法())) {
            div.getTplShinseishaJoho().getCcdShozokuShichoson().loadHokenshaList(GyomuBunrui.介護認定, HokenshaDDLPattem.構成市町村全て_市町村コード);
            div.getTplShinseishaJoho().getCcdShozokuShichoson().setSelectedShichosonIfExist(所属市町村コード);
        } else {
            div.getTplShinseishaJoho().getCcdShozokuShichoson().loadHokenshaList(GyomuBunrui.介護認定, HokenshaDDLPattem.広域保険者のみ);
        }
        div.getTplShinseishaJoho().getCcdShozokuShichoson().setLabelLText(new RString("市町村"));
        div.getTplShinseishaJoho().getCcdShozokuShichoson().setRequired(true);
        div.getTplShinseishaJoho().getCcdShozokuShichoson().setDdlDisabled(!isみなし2号登録);
    }

    /**
     * 届出情報の氏名・カナ氏名・続柄・郵便番号・住所・電話番号を設定します
     *
     * @return 介護認定申請届出者情報
     */
    public NinteiShinseiTodokedeshaDataPassModel set届出情報() {
        NinteiShinseiTodokedeshaDataPassModel datapass = new NinteiShinseiTodokedeshaDataPassModel();

        if (div.getAtenaInfoToroku().getTxtKanaMeisho() != null && div.getAtenaInfoToroku().getTxtKanaMeisho().getDomain() != null) {
            datapass.setカナ氏名(div.getAtenaInfoToroku().getTxtKanaMeisho().getDomain().getColumnValue());
        }
        if (div.getAtenaInfoToroku().getMeisho() != null && div.getAtenaInfoToroku().getMeisho().getDomain() != null) {
            datapass.set氏名(div.getAtenaInfoToroku().getMeisho().getDomain().getColumnValue());
        }
        if (div.getAtenaInfoToroku().getYubinNo() != null && !div.getAtenaInfoToroku().getYubinNo().getValue().isEmpty()) {
            datapass.set郵便番号(div.getAtenaInfoToroku().getYubinNo().getValue().getYubinNo());
        }
        if (div.getAtenaInfoToroku().getTelNo() != null && div.getAtenaInfoToroku().getTelNo().getDomain() != null) {
            datapass.set電話番号(div.getAtenaInfoToroku().getTelNo().getDomain().getColumnValue());
        }
        if (div.getAtenaInfoToroku().getJusho() != null && div.getAtenaInfoToroku().getJusho().getDomain() != null) {
            datapass.set住所(div.getAtenaInfoToroku().getJusho().getDomain().getColumnValue());
        }
        datapass.set申請届出代行区分コード(ShinseiTodokedeDaikoKubunCode.本人.getCode());
        datapass.set続柄(new RString("本人"));
        return datapass;
    }

    /**
     * 医療保険者名称、医療保険記号番号の設定
     *
     * @param iryohokenKanyuJokyo 医療保険履歴
     */
    public void set医療保険(IryohokenKanyuJokyo iryohokenKanyuJokyo) {
        if (iryohokenKanyuJokyo != null) {
            div.setHdnIryoHokenKigoNo(iryohokenKanyuJokyo.get医療保険記号番号());
            div.setHdnIryoHokenshaMeisho(iryohokenKanyuJokyo.get医療保険者名称());
            div.getBtnIryohokenGuide().setDisabled(false);
        } else {
            div.setHdnIryoHokenKigoNo(RString.EMPTY);
            div.setHdnIryoHokenshaMeisho(RString.EMPTY);
            div.getBtnIryohokenGuide().setDisabled(true);
        }
    }

    /**
     * 市町村連絡事項の設定
     *
     * @param 市町村連絡事項 市町村連絡事項
     */
    public void set市町村連絡事項(RString 市町村連絡事項) {
        if (!RString.isNullOrEmpty(市町村連絡事項)) {
            div.getBtnShichosonRenrakuJiko().setIconNameEnum(IconName.Check);
        }
    }

    public void setSinseiTorisageOnlyUsed(NinteiShinseiTorokuDiv div) {
        div.getCcdKaigoNinteiShinseiKihon().setReadOnly(true);
        div.getCcdShinseiTodokedesha().setReadOnly(true);
        div.getServiceDel().setReadOnly(true);
        div.getCcdZenkaiNinteiKekkaJoho().setReadOnly(true);
        div.getShujiiAndShujiiIryoKikan().setReadOnly(true);
        div.getChosainAndChosainInput().setReadOnly(true);
        div.getCcdNinteiInput().setReadOnly(true);
        div.getCcdShinseiSonotaJohoInput().setReadOnly(true);
        div.getHomonSaki().setReadOnly(true);
        div.getShisetsuJoho().setReadOnly(true);
        div.getPnlEnki().setReadOnly(true);
        div.getPnlShinseishaJoho().setReadOnly(true);

        div.getSinseiTorisage().setReadOnly(false);
    }

    public void setSinseiTorisageOnlyRequired(NinteiShinseiTorokuDiv div) {
        if (RString.isNullOrEmpty(div.getSinseiTorisage().getDdlTorisageJiyu().getSelectedKey())) {
            div.getSinseiTorisage().getDdlTorisageJiyu().setRequired(true);
            div.getSinseiTorisage().getTxtTorisageDate().setRequired(true);
            div.getSinseiTorisage().getTxtTorisageJiyu().setRequired(true);
        } else {
            div.getSinseiTorisage().getDdlTorisageJiyu().setRequired(false);
            div.getSinseiTorisage().getTxtTorisageDate().setRequired(false);
            div.getSinseiTorisage().getTxtTorisageJiyu().setRequired(false);
        }
    }

    public void setSinseiTorisageOnlyOpen(NinteiShinseiTorokuDiv div) {
        div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getServiceSakujo().setIsOpen(false);
        div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getNinteiShinseiRiyu().setIsOpen(false);
        div.getCcdShinseiTodokedesha().setIsOpen(false);
        div.getServiceDel().setIsOpen(false);
        div.getCcdZenkaiNinteiKekkaJoho().setIsOpen(false);
        div.getShujiiAndShujiiIryoKikan().setIsOpen(false);
        div.getChosainAndChosainInput().setIsOpen(false);
        div.getHomonSaki().setIsOpen(false);
        div.getShisetsuJoho().setIsOpen(false);

        div.getSinseiTorisage().setIsOpen(true);
    }

    private void setCommonDiv(NinteiShinseiTorokuResult result, ShinseishoKanriNo 管理番号) {
//        if (result.is旧措置者フラグ()) {
//            List<RString> keyList = new ArrayList<>();
//            keyList.add(new RString("key0"));
//            div.getCcdKaigoNinteiShinseiKihon().setKyuSochisha(keyList);
//        }

//        if (result.is資格取得前申請フラグ()) {
//            List<RString> keyList = new ArrayList<>();
//            keyList.add(new RString("key0"));
//            div.getCcdKaigoNinteiShinseiKihon().setChkShikakuShutokuMae(keyList);
//        }
        setCcdKaigoNinteiShinseiKihon(result);
        div.getCcdShujiiIryokikanAndShujiiInput().initialize(result.get市町村コード(),
                管理番号, SubGyomuCode.DBE認定支援,
                result.get主治医医療機関コード(), result.get医療機関名称(), result.get主治医コード(), result.get主治医氏名());
        div.getCcdShujiiIryokikanAndShujiiInput().setRenrakuJiko(result.get主治医への連絡事項());
        div.getCcdShujiiIryokikanAndShujiiInput().setShiteii(result.is指定医フラグ());
        if (result.get訪問調査先名称() != null) {
            div.getTxtChosasakiName().setValue(result.get訪問調査先名称().value());
        }
        div.getTxtYubinNo().setValue(result.get訪問調査先郵便番号());
        div.getTxtJusho().setDomain(result.get訪問調査先住所());
        div.getTxtTelNo().setDomain(result.get訪問調査先電話番号());
        div.getCcdChodsItakusakiAndChosainInput().initialize(new RString("InputMode"),
                result.get認定調査委託先コード(), result.get事業者名称(), result.get認定調査員コード(), result.get調査員氏名());
        div.getCcdChodsItakusakiAndChosainInput().setHdnShinseishoKanriNo(管理番号.value());
        div.getCcdChodsItakusakiAndChosainInput().setHdnShichosonCode(result.get市町村コード().value());
        div.getCcdChodsItakusakiAndChosainInput().setChosainRenrakuJiko(result.get調査員への連絡事項());

//        div.getCcdShisetsuJoho().initialize();
//        if (result.get入所施設コード() != null) {
//            div.getCcdShisetsuJoho().setNyuryokuShisetsuKodo(result.get入所施設コード().value());
//        }
        div.setHdnShichosonCode(result.get市町村コード().value());

        NinteiInputDataPassModel ninteiInput = new NinteiInputDataPassModel();
        ninteiInput.setSubGyomuCode(SubGyomuCode.DBE認定支援.value());
        ninteiInput.set申請書管理番号(管理番号);
        div.getCcdNinteiInput().initialize(ninteiInput);

        if (result.get延期決定年月日() != null && !result.get延期決定年月日().isEmpty()) {
            div.getTxtEnkiKetteiYMD().setValue(flexibleDateToRDate(result.get延期決定年月日()));
        }
        if (result.get延期見込期間開始年月日() != null && !result.get延期見込期間開始年月日().isEmpty()) {
            div.getTxtEnkiMikomiKikan().setFromValue(flexibleDateToRDate(result.get延期見込期間開始年月日()));
        }
        if (result.get延期見込期間終了年月日() != null && !result.get延期見込期間終了年月日().isEmpty()) {
            div.getTxtEnkiMikomiKikan().setToValue(flexibleDateToRDate(result.get延期見込期間終了年月日()));
        }
        if (result.get延期通知発行年月日() != null && !result.get延期通知発行年月日().isEmpty()) {
            div.getTxtEnkiTsuchiHakkoYMD().setValue(flexibleDateToRDate(result.get延期通知発行年月日()));
        }
        div.getTxtEnkiRiyu().setValue(result.get延期理由());
        div.getTxtEnkiTsuchishoHakkoCount().setValue(new Decimal(result.get延期通知発行回数()));

        if (result.get被保険者氏名カナ() != null) {
            div.setHdnShimeiKana(result.get被保険者氏名カナ().value());
            div.getAtenaInfoToroku().getTxtKanaMeisho().setDomain(result.get被保険者氏名カナ());
        }
        div.getAtenaInfoToroku().getMeisho().setDomain(result.get被保険者氏名());
        if (result.get生年月日() != null && !result.get生年月日().isEmpty()) {
            div.getAtenaInfoToroku().getSeinengabi().setValue(result.get生年月日().toRDate());
        }
        if (result.get性別() != null && !result.get性別().isEmpty()) {
            div.getAtenaInfoToroku().getSeibetsu().setValue(Seibetsu.toValue(result.get性別().getColumnValue()).get名称());
        }
        div.getAtenaInfoToroku().getNenrei().setValue(new RString(result.get年齢()).concat(歳));
        div.getAtenaInfoToroku().getYubinNo().setValue(result.get郵便番号());
        div.getAtenaInfoToroku().getJusho().setDomain(result.get住所());
        div.getAtenaInfoToroku().getTelNo().setDomain(result.get電話番号());

        setCcdShinseiTodokedesha(result, 管理番号);
        if (result.get介護認定審査会優先振分区分コード() != null && !result.get介護認定審査会優先振分区分コード().value().isEmpty()) {
            div.getDdlShinsakaiYusenKubun().setSelectedKey(result.get介護認定審査会優先振分区分コード().value());
        }
        if (result.get自動割当除外者区分() != null && !result.get自動割当除外者区分().value().isEmpty()) {
            div.getDdlWariateKubun().setSelectedKey(result.get自動割当除外者区分().value());
        }

        if (result.is情報提供フラグ()) {
            List<RString> keys = new ArrayList<>();
            keys.add(new RString("key0"));
            div.getChkJohoTeikyoDoi().setSelectedItemsByKey(keys);
        }
        if (result.is認定延期通知発行しないことに対する同意有無フラグ()) {
            List<RString> keys = new ArrayList<>();
            keys.add(new RString("key0"));
            div.getChkNinteiTsuchishoDoi().setSelectedItemsByKey(keys);
        }
        if (result.get入所施設名称() != null && !RString.isNullOrEmpty(result.get入所施設名称().getColumnValue())) {
            div.getTxtNyushoShisetsu().setValue(result.get入所施設名称().getColumnValue());
        }
    }

    private void setCcdKaigoNinteiShinseiKihon(NinteiShinseiTorokuResult result) {
        if (result.get申請日() != null && !result.get申請日().isEmpty()) {
            div.getCcdKaigoNinteiShinseiKihon().setTxtShinseiYMD(new RDate(result.get申請日().getYearValue(),
                    result.get申請日().getMonthValue(), result.get申請日().getDayValue()));
        }
        if (result.get申請書区分() != null && !ShienShinseiKubun.不明.getコード().equals(result.get申請書区分())) {
            div.getCcdKaigoNinteiShinseiKihon().setRadShinseishoKubun(result.get申請書区分());
        } else {
            div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getRadShinseishoKubun().clearSelectedItem();
        }
        if (result.get認定申請区分申請時コード() != null) {
            div.getCcdKaigoNinteiShinseiKihon().setShinseiKubunShinseiji(NinteiShinseiShinseijiKubunCode.toValue(result.get認定申請区分申請時コード().value()));
        }
        if (result.get認定申請区分法令コード() != null && !result.get認定申請区分法令コード().isEmpty()) {
            div.getCcdKaigoNinteiShinseiKihon().setShinseiKubunHorei(NinteiShinseiHoreiCode.toValue(result.get認定申請区分法令コード().value()));
        }
        if (result.get被保険者区分コード() != null && !result.get被保険者区分コード().isEmpty()) {
            div.getCcdKaigoNinteiShinseiKihon().setHihokenshaKubun(HihokenshaKubunCode.toValue(result.get被保険者区分コード()));
        }
        if (result.get二号特定疾病コード() != null && !result.get二号特定疾病コード().isEmpty()) {
            div.getCcdKaigoNinteiShinseiKihon().setTokuteiShippei(TokuteiShippei.toValue(result.get二号特定疾病コード().value()));
        }
        if (HihokenshaKubunCode.第２号被保険者.getコード().equals(result.get被保険者区分コード()) 
                || HihokenshaKubunCode.生活保護.getコード().equals(result.get被保険者区分コード())) {
            div.getCcdKaigoNinteiShinseiKihon().setRequiredForDdlTokuteiShippei(true);
        } else {
            div.getCcdKaigoNinteiShinseiKihon().setRequiredForDdlTokuteiShippei(false);
        }
        div.getCcdKaigoNinteiShinseiKihon().setServiceSakujoTeikeibun(result.get申請サービス削除の理由());
        div.getCcdKaigoNinteiShinseiKihon().setNinteiShinseRiyuTeikeibun(result.get認定申請理由());
    }

    private void setCcdShinseiTodokedesha(NinteiShinseiTorokuResult result, ShinseishoKanriNo 管理番号) {
        NinteiShinseiTodokedeshaDataPassModel datapass = new NinteiShinseiTodokedeshaDataPassModel();
        datapass.setカナ氏名(result.get申請届出者氏名カナ());
        if (!RString.isNullOrEmpty(result.get事業者区分())
                && !result.get事業者区分().trim().isEmpty()) {
            datapass.set事業者区分(result.get事業者区分());
        }
        datapass.set住所(result.get申請届出者住所());
        datapass.set氏名(result.get申請届出者氏名());
        if (result.get申請届出代行事業者番号() != null
                && !RString.isNullOrEmpty(result.get申請届出代行事業者番号().value())) {
            datapass.set申請届出代行事業者番号(result.get申請届出代行事業者番号().value());
        }
        if (result.get申請届出代行区分コード() != null
                && !RString.isNullOrEmpty(result.get申請届出代行区分コード().value())) {
            datapass.set申請届出代行区分コード(result.get申請届出代行区分コード().value());
        }
        datapass.set続柄(result.get申請届出者続柄());
        //datapass.set識別コード(result.get識別コード().value());
        if (result.get申請届出者郵便番号() != null) {
            datapass.set郵便番号(result.get申請届出者郵便番号().getYubinNo());
        }
        if (result.get申請届出者電話番号() != null
                && !RString.isNullOrEmpty(result.get申請届出者電話番号().value())) {
            datapass.set電話番号(result.get申請届出者電話番号().value());
        }
        datapass.set申請書管理番号(管理番号.value());
        div.getCcdShinseiTodokedesha().initialize(datapass);
    }

    /**
     * DivReadOnlyの設定
     *
     * @param flag boolean
     */
    public void setDivReadOnly(boolean flag) {
        div.getCcdChodsItakusakiAndChosainInput().setReadOnly(flag);
        div.getCcdKaigoNinteiShinseiKihon().setReadOnly(flag);
        div.getCcdNinteiInput().setReadOnly(flag);
        div.getCcdShikakuInfo().setReadOnly(flag);
        div.getCcdShinseiSonotaJohoInput().setReadOnly(flag);
        div.getCcdShinseiTodokedesha().setReadOnly(flag);
//        div.getCcdShisetsuJoho().setReadOnly(flag);
        div.getCcdShujiiIryokikanAndShujiiInput().setReadOnly(flag);
        div.getCcdZenkaiNinteiKekkaJoho().setReadOnly(flag);
        div.getServiceDel().setReadOnly(flag);
        div.getSinseiTorisage().setReadOnly(flag);
        div.getShujiiAndShujiiIryoKikan().setReadOnly(flag);
        div.getChosainAndChosainInput().setReadOnly(flag);
        div.getHomonSaki().setReadOnly(flag);
        div.getShisetsuJoho().setReadOnly(flag);
        div.getChkNinteiTsuchishoDoi().setReadOnly(flag);
        div.getChkJohoTeikyoDoi().setReadOnly(flag);
        div.getDdlShinsakaiYusenKubun().setReadOnly(flag);
        div.getDdlWariateKubun().setReadOnly(flag);
        div.getTxtEnkiKetteiYMD().setReadOnly(flag);
        div.getTxtEnkiMikomiKikan().setReadOnly(flag);
        div.getBtnEnkiRiyuTeikeibun().setDisabled(flag);
        div.getTxtEnkiRiyu().setReadOnly(flag);
        div.getTplShinseishaJoho().setDisabled(flag);
    }

    /**
     * 申請届出者の設定
     *
     * @param div 審査依頼受付／みなし２号審査受付Div
     * @param ninteiTandokuDounyuFlag boolean
     *
     */
    public void setCcdShinseiTodokedesha(NinteiShinseiTorokuDiv div, boolean ninteiTandokuDounyuFlag) {
        if (ninteiTandokuDounyuFlag) {
            ((NinteiShinseiTodokedeshaDiv) div.getCcdShinseiTodokedesha()).getBtnSetaiIchiran().setDisplayNone(ninteiTandokuDounyuFlag);
            ((NinteiShinseiTodokedeshaDiv) div.getCcdShinseiTodokedesha()).getBtnAtenaKensaku().setDisplayNone(ninteiTandokuDounyuFlag);
            div.getCcdShinseiTodokedesha().getRadKannaiKangai().setSelectedKey(KEY1);
            div.getCcdShinseiTodokedesha().getRadKannaiKangai().setDisplayNone(ninteiTandokuDounyuFlag);
            ((ChoikiInputDiv) div.getCcdShinseiTodokedesha().getCcdChoikiInput()).setDisplayNone(ninteiTandokuDounyuFlag);
            div.getCcdShinseiTodokedesha().set状態(new RString(NinteiShinseiTodokedeshaDiv.DisplayType.管外.toString()));
        }
    }
    
    /**
     * 照会状態を設定します。
     * 
     */
    public void setShokai() {
        div.getRadMode().setDisabled(true);
        div.getPnlShinseishaJoho().setReadOnly(true);
        div.getPnlEnki().setReadOnly(true);
        div.getPnlNinteiShinseiDetail().getCcdKaigoNinteiShinseiKihon().setDisabled(true);
        div.getPnlNinteiShinseiDetail().getCcdShinseiTodokedesha().setDisabled(true);
        div.getPnlNinteiShinseiDetail().getServiceDel().setReadOnly(true);
        div.getPnlNinteiShinseiDetail().getSinseiTorisage().setDisabled(true);
        div.getPnlNinteiShinseiDetail().getCcdZenkaiNinteiKekkaJoho().setReadOnly(true);
        div.getPnlNinteiShinseiDetail().getCcdNinteiInput().setReadOnly(true);
        div.getPnlNinteiShinseiDetail().getCcdShinseiSonotaJohoInput().setReadOnly(true);
        div.getPnlNinteiShinseiDetail().getHomonSaki().setReadOnly(true);
        div.getPnlNinteiShinseiDetail().getShisetsuJoho().setReadOnly(true);
        div.getPnlNinteiShinseiDetail().getChkNinteiTsuchishoDoi().setReadOnly(true);
        div.getPnlNinteiShinseiDetail().getChkJohoTeikyoDoi().setReadOnly(true);
        div.getPnlNinteiShinseiDetail().getDdlShinsakaiYusenKubun().setDisabled(true);
        div.getPnlNinteiShinseiDetail().getDdlWariateKubun().setDisabled(true);
        div.getPnlNinteiShinseiDetail().getCcdShujiiIryokikanAndShujiiInput().getBtnIryokikanGuide().setDisabled(true);
        div.getPnlNinteiShinseiDetail().getCcdShujiiIryokikanAndShujiiInput().getBtnShujiiGuide().setDisabled(true);
        div.getPnlNinteiShinseiDetail().getCcdShujiiIryokikanAndShujiiInput().getTxtIryoKikanCode().setDisabled(true);
        div.getPnlNinteiShinseiDetail().getCcdShujiiIryokikanAndShujiiInput().getTxtIryoKikanName().setDisabled(true);
        div.getPnlNinteiShinseiDetail().getCcdShujiiIryokikanAndShujiiInput().getTxtShujiiCode().setDisabled(true);
        div.getPnlNinteiShinseiDetail().getCcdShujiiIryokikanAndShujiiInput().getTxtShujiiName().setDisabled(true);
        ((ShujiiIryokikanAndShujiiInputDiv) div.getPnlNinteiShinseiDetail().getCcdShujiiIryokikanAndShujiiInput()).getBtnZenkaiIrokikanJoho().setDisabled(true);
        ((ShujiiIryokikanAndShujiiInputDiv) div.getPnlNinteiShinseiDetail().getCcdShujiiIryokikanAndShujiiInput()).getBtnClear().setDisabled(true);
        ((ShujiiIryokikanAndShujiiInputDiv) div.getPnlNinteiShinseiDetail().getCcdShujiiIryokikanAndShujiiInput()).getBtnShujiiRenrakuJiko().setDisabled(false);
        ((ShujiiIryokikanAndShujiiInputDiv) div.getPnlNinteiShinseiDetail().getCcdShujiiIryokikanAndShujiiInput()).getChkShiteii().setDisabled(true);
        if (RString.isNullOrEmpty(div.getPnlNinteiShinseiDetail().getCcdShujiiIryokikanAndShujiiInput().getRenrakuJiko())) {
            ((ShujiiIryokikanAndShujiiInputDiv) div.getPnlNinteiShinseiDetail().getCcdShujiiIryokikanAndShujiiInput()).getBtnShujiiRenrakuJiko().setDisabled(true);
        }
        div.getPnlNinteiShinseiDetail().getCcdChodsItakusakiAndChosainInput().initialize(照会状態);
        ((ChosaItakusakiAndChosainInputDiv) div.getPnlNinteiShinseiDetail().getCcdChodsItakusakiAndChosainInput()).getBtnChosainRenrakuJiko().setDisabled(false);
        if (RString.isNullOrEmpty(div.getPnlNinteiShinseiDetail().getCcdChodsItakusakiAndChosainInput().getChosainRenrakuJiko())) {
            ((ChosaItakusakiAndChosainInputDiv) div.getPnlNinteiShinseiDetail().getCcdChodsItakusakiAndChosainInput()).getBtnChosainRenrakuJiko().setDisabled(true);
        }
        div.setHdnRenrakusakiReadOnly(new RString("1"));
        div.setHdnJogaiMode(RString.EMPTY);
    }

    private RDate flexibleDateToRDate(FlexibleDate date) {
        if (date == null || FlexibleDate.EMPTY.equals(date)) {
            return RDate.MIN;
        }
        return new RDate(date.wareki().eraType(EraType.ALPHABET)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD)
                .fillType(FillType.ZERO).toDateString().toString());
    }

}
