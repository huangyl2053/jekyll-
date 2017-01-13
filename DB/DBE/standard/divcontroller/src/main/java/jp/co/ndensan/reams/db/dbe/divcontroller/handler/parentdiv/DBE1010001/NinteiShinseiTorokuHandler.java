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
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1010001.NinteiShinseiTorokuDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.db.dbz.business.core.basic.IryohokenKanyuJokyo;
import jp.co.ndensan.reams.db.dbz.business.core.ninteiinput.NinteiInputDataPassModel;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseitodokedesha.NinteiShinseiTodokedeshaDataPassModel;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.tokuteishippei.TokuteiShippei;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShienShinseiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.TorisageKubunCode;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInputDiv;
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
     */
    public void loadUpdate(NinteiShinseiTorokuResult result, ShinseishoKanriNo 管理番号,
            RString 被保険者番号, RString 介護導入形態) {
//        div.getCcdAtenaInfo().setKaigoDonyuKeitai(介護導入形態);
//        div.getCcdAtenaInfo().setShinseishaJohoByShikibetsuCode(管理番号, ShikibetsuCode.EMPTY);
//        div.getCcdAtenaInfo().setShoriType(new RString("2"));
//        div.getCcdAtenaInfo().initialize();
        div.getCcdKaigoNinteiShinseiKihon().initialize();
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        dataSource.add(new KeyValueDataSource(NinteiShinseiShinseijiKubunCode.新規申請.getコード(), NinteiShinseiShinseijiKubunCode.新規申請.get名称()));
        dataSource.add(new KeyValueDataSource(NinteiShinseiShinseijiKubunCode.更新申請.getコード(), NinteiShinseiShinseijiKubunCode.更新申請.get名称()));
        dataSource.add(new KeyValueDataSource(NinteiShinseiShinseijiKubunCode.区分変更申請.getコード(), NinteiShinseiShinseijiKubunCode.区分変更申請.get名称()));
        dataSource.add(new KeyValueDataSource(NinteiShinseiShinseijiKubunCode.職権.getコード(), NinteiShinseiShinseijiKubunCode.職権.get名称()));
        dataSource.add(new KeyValueDataSource(NinteiShinseiShinseijiKubunCode.転入申請.getコード(), NinteiShinseiShinseijiKubunCode.転入申請.get名称()));
        div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShinseiKubunShinseiji().setDataSource(dataSource);
        div.getCcdZenkaiNinteiKekkaJoho().onLoad(SubGyomuCode.DBE認定支援, 管理番号, new RString("1"));
        div.getCcdShinseiSonotaJohoInput().initialize();
        
        if (result != null) {
            if (result.get市町村コード() != null) {
                div.getCcdShikakuInfo().initialize(result.get市町村コード().value(), 被保険者番号);
            }
            setCommonDiv(result, 管理番号);
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
        } else {
            div.getCcdShujiiIryokikanAndShujiiInput().initialize(LasdecCode.EMPTY,
                管理番号, SubGyomuCode.DBE認定支援,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
            div.getCcdChodsItakusakiAndChosainInput().initialize(new RString("InputMode"),
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
            NinteiInputDataPassModel ninteiInput = new NinteiInputDataPassModel();
            ninteiInput.setSubGyomuCode(SubGyomuCode.DBE認定支援.value());
            ninteiInput.set申請書管理番号(管理番号);
            div.getCcdShisetsuJoho().initialize();
            div.getCcdNinteiInput().initialize(ninteiInput);
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
        if (business.get生年月日() != null) {
            div.getAtenaInfoToroku().getSeinengabi().setValue(business.get生年月日());
            int 年齢 = FlexibleDate.getNowDate().getBetweenYears(business.get生年月日().toFlexibleDate());
            div.getAtenaInfoToroku().getNenrei().setValue(new RString(年齢).concat("歳"));
        }
        
        
        if (!business.get性別コード().isNullOrEmpty()) {
            div.getAtenaInfoToroku().getSeibetsu().setValue(Seibetsu.toValue(business.get性別コード()).get名称());
        }
        div.getAtenaInfoToroku().getYubinNo().setValue(business.get郵便番号());
        div.getAtenaInfoToroku().getJusho().setDomain(new AtenaJusho(business.get住所名称()));
        div.getAtenaInfoToroku().getTelNo().setDomain(business.get電話番号());
        div.setHdnShishoCode(business.get支所コード());

        if (市町村コード.isEmpty()) {
            div.getCcdShikakuInfo().initialize(ZERO_6, business.get被保険者番号().value().padZeroToLeft(ZERO_10));
        } else {
            div.getCcdShikakuInfo().initialize(市町村コード.value(), business.get被保険者番号().value().padZeroToLeft(ZERO_10));
        }
        div.getCcdKaigoNinteiShinseiKihon().initialize();
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (HihokenshaKubunCode hihokenshaKubun : HihokenshaKubunCode.values()) {
            dataSource.add(new KeyValueDataSource(hihokenshaKubun.getコード(), hihokenshaKubun.get名称()));
        }
        dataSource.remove(new KeyValueDataSource(HihokenshaKubunCode.生活保護.getコード(), HihokenshaKubunCode.生活保護.get名称()));
        ((KaigoNinteiShinseiKihonJohoInputDiv)div.getCcdKaigoNinteiShinseiKihon()).getDdlHihokenshaKubun().setDataSource(dataSource);
        if (!RString.isNullOrEmpty(business.get支所コード())) {
            div.getCcdKaigoNinteiShinseiKihon().setShisho(new ShishoCode(business.get支所コード()));
        }
        div.getCcdShujiiIryokikanAndShujiiInput().initialize(市町村コード,
                ShinseishoKanriNo.EMPTY, SubGyomuCode.DBE認定支援,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
        div.getCcdChodsItakusakiAndChosainInput().initialize(new RString("InputMode"),
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
        div.getCcdChodsItakusakiAndChosainInput().setHdnShinseishoKanriNo(RString.EMPTY);
        div.getCcdChodsItakusakiAndChosainInput().setHdnShichosonCode(市町村コード.value());
        if (business.get前回申請書管理番号() != null) {
            div.getCcdZenkaiNinteiKekkaJoho().onLoad(SubGyomuCode.DBE認定支援, business.get前回申請書管理番号(), new RString("2"));
        }
        NinteiInputDataPassModel ninteiInput = new NinteiInputDataPassModel();
        ninteiInput.setSubGyomuCode(SubGyomuCode.DBE認定支援.value());
        ninteiInput.set申請書管理番号(ShinseishoKanriNo.EMPTY);
        div.getCcdNinteiInput().initialize(ninteiInput);
        div.getCcdShinseiSonotaJohoInput().initialize();
        div.getCcdShisetsuJoho().initialize();
    }
    
    /**
     * サービス削除と申請取下の初期化です
     *  
     * @param result 申請情報
     */
    public void loadPnl(NinteiShinseiTorokuResult result) {
        div.getTxtServiceDeleteRiyu().setValue(result.get申請サービス削除の理由());
        
        if (result.get取下年月日() != null && !result.get取下年月日().isEmpty()) {
            div.getTxtTorisageDate().setValue(new RDate(result.get取下年月日().toString()));
        }
        div.getTxtTorisageJiyu().setValue(result.get取下理由());
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (TorisageKubunCode torisageKubunCode : TorisageKubunCode.values()) {
            dataSource.add(new KeyValueDataSource(torisageKubunCode.getコード(), torisageKubunCode.get名称()));
        }
        div.getDdlTorisageJiyu().setDataSource(dataSource);
        div.getDdlTorisageJiyu().setSelectedKey(result.get取下区分コード().value());
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
        } else {
            div.setHdnIryoHokenKigoNo(RString.EMPTY);
            div.setHdnIryoHokenshaMeisho(RString.EMPTY);
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

    private void setCommonDiv(NinteiShinseiTorokuResult result, ShinseishoKanriNo 管理番号) {
        
        if (result.get申請日() != null) {
            div.getCcdKaigoNinteiShinseiKihon().setTxtShinseiYMD(new RDate(result.get申請日().getYearValue(),
                    result.get申請日().getMonthValue(), result.get申請日().getDayValue()));
        }
        if (!ShienShinseiKubun.不明.getコード().equals(result.get申請書区分())) {
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
//        if (result.is旧措置者フラグ()) {
//            List<RString> keyList = new ArrayList<>();
//            keyList.add(new RString("key0"));
//            div.getCcdKaigoNinteiShinseiKihon().setKyuSochisha(keyList);
//        }
        div.getCcdKaigoNinteiShinseiKihon().setHihokenshaKubun(HihokenshaKubunCode.toValue(result.get被保険者区分コード()));
//        if (result.is資格取得前申請フラグ()) {
//            List<RString> keyList = new ArrayList<>();
//            keyList.add(new RString("key0"));
//            div.getCcdKaigoNinteiShinseiKihon().setChkShikakuShutokuMae(keyList);
//        }
        if (result.get二号特定疾病コード() != null && !result.get二号特定疾病コード().isEmpty()) {
            div.getCcdKaigoNinteiShinseiKihon().setTokuteiShippei(TokuteiShippei.toValue(result.get二号特定疾病コード().value()));
        }
        div.getCcdKaigoNinteiShinseiKihon().setServiceSakujoTeikeibun(result.get申請サービス削除の理由());
        div.getCcdKaigoNinteiShinseiKihon().setNinteiShinseRiyuTeikeibun(result.get認定申請理由());
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

        div.getCcdShisetsuJoho().initialize();
        if (result.get入所施設コード() != null) {
            div.getCcdShisetsuJoho().setNyuryokuShisetsuKodo(result.get入所施設コード().value());
        }

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
