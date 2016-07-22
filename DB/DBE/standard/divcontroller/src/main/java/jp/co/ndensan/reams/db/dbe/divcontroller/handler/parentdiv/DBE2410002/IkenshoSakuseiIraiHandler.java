/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2410002;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.ninteishinseijoho.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshoiraijoho.ShujiiIkenshoIraiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshoiraijoho.ShujiiIkenshoIraiJohoBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshoiraijoho.ShujiiIkenshoIraiJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.ikenshoirairirekiichiran.IkenshoirairirekiichiranShudou;
import jp.co.ndensan.reams.db.dbe.business.core.ikenshoirairirekiichiran.ShujiiIkenshoTeishutsuIraishoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ikenshokinyuyoshi.IkenshokinyuyoshiBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ikenshoprint.ChosaIraishoAndChosahyoAndIkenshoPrintBusiness;
import jp.co.ndensan.reams.db.dbe.business.report.ikenshosakuseiiraiichiranhyo.IkenshoSakuseiIraiIchiranhyoItem;
import jp.co.ndensan.reams.db.dbe.business.report.kaigohokenshindanmeireisho.KaigohokenShindanMeireishoHeaderItem;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikensho.ShujiiIkenshoSakuseiIraishoItem;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshosakusei.ShujiiIkenshoSakuseiRyoSeikyushoItem;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshoteishutsuiraisho.ShujiiIkenshoTeishutsuIraishoItem;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshoteishutsuiraisho.ShujiiIkenshoTeishutsuIraishoReportJoho;
import jp.co.ndensan.reams.db.dbe.business.report.syujiyikenshosakuseyiraihakou.SyujiyikenshosakuseyiraihakouBodyItem;
import jp.co.ndensan.reams.db.dbe.business.report.syujiyikenshosakuseyiraihakou.SyujiyikenshosakuseyiraihakouHeadItem;
import jp.co.ndensan.reams.db.dbe.business.report.syujiyikenshosakuseyiraihakou.SyujiyikenshosakuseyiraihakouReportJoho;
import jp.co.ndensan.reams.db.dbe.definition.core.IshiKubun;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2410002.IkenshoSakuseiIraiDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.NinteiShinseiKubunShinsei;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.ikenshosakuseiryo.IkenshoSakuseiRyo;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoIraiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoSakuseiKaisuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.ZaitakuShisetsuKubun;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 主治医意見書作成依頼(手動)のHandlerクラスです。
 *
 * @reamsid_L DBE-1590-030 zuotao
 */
public class IkenshoSakuseiIraiHandler {

    private final IkenshoSakuseiIraiDiv div;
    private static final RString 選択 = new RString("1");
    private static final RString SELECTED_KEY0 = new RString("key0");
    private static final RString SELECTED_KEY1 = new RString("key1");
    private static final RString SELECTED_KEY2 = new RString("key2");
    private static final RString SELECTED_KEY3 = new RString("key3");
    private static final RString SELECTED_KEY4 = new RString("key4");
    private static final RString SELECTED_KEY5 = new RString("key5");
    private static final int 初期履歴番号 = 1;
    private static final int 初期作成回数 = 1;
    private static final RString 主治医意見書作成期限設定方法_1 = new RString("1");
    private static final RString 宛先敬称_0 = new RString("0");
    private static final RString 宛先敬称_1 = new RString("1");
    private static final RString 宛先敬称_2 = new RString("2");
    private static final RString 宛先敬称_様 = new RString("様");
    private static final RString 宛先敬称_殿 = new RString("殿");
    private static final int 数字_0 = 0;
    private static final int 数字_1 = 1;
    private static final int 数字_2 = 2;
    private static final int 数字_3 = 3;
    private static final int 数字_4 = 4;
    private static final int 数字_5 = 5;
    private static final int 数字_6 = 6;
    private static final int 数字_7 = 7;
    private static final int 数字_8 = 8;
    private static final int 数字_9 = 9;
    private static final int 数字_10 = 10;
    private static final RString 星 = new RString("＊");
    private static final RString 元号_明治 = new RString("明治");
    private static final RString 元号_大正 = new RString("大正");
    private static final RString 元号_昭和 = new RString("昭和");
    private static final RString 記号_CHECKED = new RString("✔");
    private static final RString 文字列_まで = new RString("まで");
    private static final RString 連結 = new RString("～");
    private static final RString 初期連番 = new RString("*000001#");

    /**
     * コンストラクタです。
     *
     * @param div 主治医意見書作成依頼(手動)Div
     */
    public IkenshoSakuseiIraiHandler(IkenshoSakuseiIraiDiv div) {
        this.div = div;
    }

    /**
     * 主治医意見書作成依頼(手動)の初期化設定します。
     *
     * @param 主治医意見書作成依頼 主治医意見書作成依頼
     */
    public void initialize(IkenshoirairirekiichiranShudou 主治医意見書作成依頼) {
        set依頼区分();
        if (主治医意見書作成依頼 == null) {
            return;
        }
        if (RString.isNullOrEmpty(主治医意見書作成依頼.get主治医意見書作成依頼履歴番号())) {
            div.getDdlIraiKubun().setDisabled(false);
            div.getDdlIraiKubun().setSelectedKey(IkenshoIraiKubun.初回依頼.getコード());
        } else {
            div.getDdlIraiKubun().setDisabled(true);
            div.getDdlIraiKubun().setSelectedKey(主治医意見書作成依頼.get主治医意見書依頼区分());
        }
        div.setIkenshoIraiRirekiNo(主治医意見書作成依頼.get主治医意見書作成依頼履歴番号());
        if (主治医意見書作成依頼.get主治医意見書作成依頼年月日() != null && !主治医意見書作成依頼.get主治医意見書作成依頼年月日().isEmpty()) {
            div.getTxtSakuseiIraiD().setValue(new RDate(主治医意見書作成依頼.get主治医意見書作成依頼年月日().toString()));
        }
        RString 意見書作成依頼書 = getConfigValue(ConfigNameDBE.主治医意見書作成依頼_手動_意見書作成依頼書);
        RString 意見書作成依頼一覧表 = getConfigValue(ConfigNameDBE.主治医意見書作成依頼_手動_意見書作成依頼一覧表);
        RString 主治医意見書作成依頼発行一覧表 = getConfigValue(ConfigNameDBE.主治医意見書作成依頼_手動_依頼書発行履歴一覧表);
        RString 主治医意見書記入用紙 = getConfigValue(ConfigNameDBE.主治医意見書作成依頼_手動_主治医意見書記入用紙);
        RString 主治医意見書記入用紙OCR = getConfigValue(ConfigNameDBE.主治医意見書作成依頼_手動_主治医意見書記入用紙OCR);
        RString 主治医意見書作成料請求書 = getConfigValue(ConfigNameDBE.主治医意見書作成依頼_手動_主治医意見書作成料請求書);
        RString 介護保険診断命令書 = getConfigValue(ConfigNameDBE.主治医意見書作成依頼_手動_介護保険診断命令書);
        RString 介護保険指定医依頼兼主治医意見書提出意見書 = getConfigValue(ConfigNameDBE.主治医意見書作成依頼_手動_介護保険指定医依頼兼主治医意見書提出意見書);
        RString 主治医意見書依頼該当者履歴一覧 = getConfigValue(ConfigNameDBE.主治医意見書作成依頼_手動_主治医意見書依頼該当者履歴一覧);
        List<RString> key = new ArrayList<>();
        if (選択.equals(意見書作成依頼書)) {
            key.add(SELECTED_KEY0);
        }
        if (選択.equals(意見書作成依頼一覧表)) {
            key.add(SELECTED_KEY1);
        }
        if (選択.equals(主治医意見書作成依頼発行一覧表)) {
            key.add(SELECTED_KEY2);
        }
        div.getChkIrai().setSelectedItemsByKey(key);
        key = new ArrayList<>();
        if (選択.equals(主治医意見書記入用紙)) {
            key.add(SELECTED_KEY0);
        }
        if (選択.equals(主治医意見書記入用紙OCR)) {
            key.add(SELECTED_KEY1);
        }
        if (選択.equals(主治医意見書作成料請求書)) {
            key.add(SELECTED_KEY2);
        }
        if (選択.equals(介護保険診断命令書)) {
            key.add(SELECTED_KEY3);
        }
        if (選択.equals(介護保険指定医依頼兼主治医意見書提出意見書)) {
            key.add(SELECTED_KEY4);
        }
        if (選択.equals(主治医意見書依頼該当者履歴一覧)) {
            key.add(SELECTED_KEY5);
        }
        div.getChkPrint().setSelectedItemsByKey(key);
        if (key.contains(SELECTED_KEY3)) {
            div.getMeireishoPanel().setDisplayNone(false);
        } else {
            div.getMeireishoPanel().setDisplayNone(true);
        }
        div.getTxtHakobi().setValue(RDate.getNowDate());
        div.getTxtKigenymd().setValue(RDate.getNowDate());
        if (SELECTED_KEY2.equals(div.getRadKigen().getSelectedKey())) {
            div.getTxtKigenymd().setDisabled(false);
        } else {
            div.getTxtKigenymd().setDisabled(true);
        }
        if (SELECTED_KEY0.equals(div.getRadJyushin().getSelectedKey())) {
            div.getTxtJyushinymd().setDisabled(false);
            div.getTxtJyushintime().setDisabled(false);
            div.getTxtJyushinKikan().setDisabled(true);
        } else {
            div.getTxtJyushinKikan().setDisabled(false);
            div.getTxtJyushinymd().setDisabled(true);
            div.getTxtJyushintime().setDisabled(true);
        }
    }

    private FlexibleDate get主治医意見書作成期限年月日(FlexibleDate 認定申請年月日, IkenshoSakuseiIraiDiv div) {
        RString 認定調査期限設定方法 = DbBusinessConfig.get(ConfigNameDBE.認定調査期限設定方法,
                RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        FlexibleDate 提出期限 = FlexibleDate.EMPTY;
        RString key = div.getRadKigen().getSelectedKey();
        int 期限日数 = Integer.parseInt(DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成期限日数,
                RDate.getNowDate(), SubGyomuCode.DBE認定支援).toString());
        if (主治医意見書作成期限設定方法_1.equals(認定調査期限設定方法)) {
            if (SELECTED_KEY0.equals(key)) {
                提出期限 = new FlexibleDate(div.getTxtSakuseiIraiD().getValue().plusDay(期限日数).toDateString());
            } else if (SELECTED_KEY1.equals(key)) {
                提出期限 = FlexibleDate.EMPTY;
            } else if (SELECTED_KEY2.equals(key) && div.getTxtKigenymd().getValue() != null) {
                提出期限 = new FlexibleDate(div.getTxtKigenymd().getValue().plusDay(期限日数).toDateString());
            }
        } else if (認定申請年月日 != null) {
            提出期限 = 認定申請年月日.plusDay(期限日数);
        }
        return 提出期限;
    }

    /**
     * 主治医意見書作成依頼情報印刷用パラメータを作成します。
     *
     * @param 要介護認定申請情報 要介護認定申請情報
     * @param 申請書管理番号 申請書管理番号
     * @return 主治医意見書作成依頼情報印刷用パラメータ
     */
    public ShujiiIkenshoIraiJoho create主治医意見書作成依頼(NinteiShinseiJoho 要介護認定申請情報, RString 申請書管理番号) {
        ShujiiIkenshoIraiJoho ikenshoIraiJoho;
        ShujiiIkenshoIraiJohoBuilder builder;
        if (RString.isNullOrEmpty(div.getIkenshoIraiRirekiNo())) {
            ikenshoIraiJoho = new ShujiiIkenshoIraiJoho(new ShinseishoKanriNo(申請書管理番号), 初期履歴番号);
            builder = ikenshoIraiJoho.createBuilderForEdit();
            builder.set厚労省IF識別コード(要介護認定申請情報.get厚労省IF識別コード());
            builder.set主治医意見書依頼区分(div.getDdlIraiKubun().getSelectedKey());
            builder.set主治医意見書作成督促回数(初期作成回数);
        } else {
            ikenshoIraiJoho = 要介護認定申請情報.getShujiiIkenshoIraiJoho(
                    new ShujiiIkenshoIraiJohoIdentifier(new ShinseishoKanriNo(申請書管理番号),
                            Integer.parseInt(div.getIkenshoIraiRirekiNo().toString()))).modifiedModel();
            builder = ikenshoIraiJoho.createBuilderForEdit();
        }
        builder.set主治医医療機関コード(div.getCcdShujiiInput().getIryoKikanCode());
        builder.set主治医コード(div.getCcdShujiiInput().getShujiiCode());
        if (div.getCcdShujiiInput().hasShiteii()) {
            builder.set医師区分コード(new Code(IshiKubun.指定医.getCode()));
        } else {
            builder.set医師区分コード(new Code(IshiKubun.主治医.getCode()));
        }
        builder.set主治医意見書作成依頼年月日(new FlexibleDate(div.getTxtSakuseiIraiD().getValue().toDateString()));
        builder.set主治医意見書作成期限年月日(get主治医意見書作成期限年月日(要介護認定申請情報.get認定申請年月日(), div));
        builder.set論理削除フラグ(false);
        return builder.build();
    }

    /**
     * 主治医意見書記入情報1印刷用パラメータを作成します。
     *
     * @param business 主治医意見書記入情報
     * @return 主治医意見書記入情報1
     */
    public List<IkenshokinyuyoshiBusiness> create主治医意見書記入情報1_パラメータ(ChosaIraishoAndChosahyoAndIkenshoPrintBusiness business) {

        List<IkenshokinyuyoshiBusiness> itemList = new ArrayList<>();
        List<RString> 保険者番号リスト = get被保険者番号(business.get保険者番号());
        List<RString> 被保険者番号リスト = get被保険者番号(business.get被保険者番号());
        RString 生年月日 = business.get生年月日();
        RString 年号 = new FlexibleDate(生年月日).wareki().eraType(EraType.KANJI).toDateString();
        IkenshokinyuyoshiBusiness item = new IkenshokinyuyoshiBusiness();
        item.setHokenshaNo1(保険者番号リスト.get(数字_0));
        item.setHokenshaNo2(保険者番号リスト.get(数字_1));
        item.setHokenshaNo3(保険者番号リスト.get(数字_2));
        item.setHokenshaNo4(保険者番号リスト.get(数字_3));
        item.setHokenshaNo5(保険者番号リスト.get(数字_4));
        item.setHokenshaNo6(保険者番号リスト.get(数字_5));
        item.setHihokenshaNo1(被保険者番号リスト.get(数字_0));
        item.setHihokenshaNo2(被保険者番号リスト.get(数字_1));
        item.setHihokenshaNo3(被保険者番号リスト.get(数字_2));
        item.setHihokenshaNo4(被保険者番号リスト.get(数字_3));
        item.setHihokenshaNo5(被保険者番号リスト.get(数字_4));
        item.setHihokenshaNo6(被保険者番号リスト.get(数字_5));
        item.setHihokenshaNo7(被保険者番号リスト.get(数字_6));
        item.setHihokenshaNo8(被保険者番号リスト.get(数字_7));
        item.setHihokenshaNo9(被保険者番号リスト.get(数字_8));
        item.setHihokenshaNo10(被保険者番号リスト.get(数字_9));
        item.setHihokenshaNameKana(business.get被保険者氏名カナ());
        item.setHihokenshaName(business.get被保険者氏名());
        item.setAge(business.get年齢());
        item.setHihokenshaTel(business.get電話番号());
        item.setJusho(business.get住所());
        item.setShujiiName(business.get主治医氏名());
        item.setIryokikanName(business.get医療機関名称());
        item.setIryokikanAdress(business.get医療機関住所());
        item.setIryokikanNameTel(business.get医療機関電話番号());
        item.setIryokikanFax(business.get医療機関FAX番号());
        item.setYubinNo(business.get郵便番号());
        item.setBirthYY(年号.substring(数字_3, 数字_5));
        item.setBirthMM(年号.substring(数字_6, 数字_8));
        item.setBirthDD(年号.substring(数字_9));
        RString ninteiShinseiDay = new FlexibleDate(business.get認定申請年月日()).wareki().eraType(EraType.ALPHABET).firstYear(FirstYear.ICHI_NEN)
                .separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
        item.setShinseiYY1(ninteiShinseiDay.substring(1, 2));
        item.setShinseiYY2(ninteiShinseiDay.substring(2, 数字_3));
        item.setShinseiMM1(ninteiShinseiDay.substring(数字_4, 数字_5));
        item.setShinseiMM2(ninteiShinseiDay.substring(数字_5, 数字_6));
        item.setShinseiDD1(ninteiShinseiDay.substring(数字_7, 数字_8));
        item.setShinseiDD2(ninteiShinseiDay.substring(数字_8));
        item.setSeibetsuMan(Seibetsu.男.get名称().equals(business.get性別()) ? 記号_CHECKED : RString.EMPTY);
        item.setSeibetsuWoman(Seibetsu.女.get名称().equals(business.get性別()) ? 記号_CHECKED : RString.EMPTY);
        item.setBirthGengoMeiji(年号.startsWith(元号_明治) ? 記号_CHECKED : RString.EMPTY);
        item.setBirthGengoTaisho(年号.startsWith(元号_大正) ? 記号_CHECKED : RString.EMPTY);
        item.setBirthGengoShowa(年号.startsWith(元号_昭和) ? 記号_CHECKED : RString.EMPTY);
        itemList.add(item);
        return itemList;
    }

    /**
     * 主治医意見書記入情報2印刷用パラメータを作成します。
     *
     * @param business 主治医意見書記入情報
     * @return 主治医意見書記入情報2
     */
    public List<IkenshokinyuyoshiBusiness> create主治医意見書記入情報2_パラメータ(ChosaIraishoAndChosahyoAndIkenshoPrintBusiness business) {

        List<IkenshokinyuyoshiBusiness> itemList = new ArrayList<>();
        List<RString> 保険者番号リスト = get被保険者番号(business.get保険者番号());
        List<RString> 被保険者番号リスト = get被保険者番号(business.get被保険者番号());
        IkenshokinyuyoshiBusiness item = new IkenshokinyuyoshiBusiness();
        item.setHokenshaNo1(保険者番号リスト.get(数字_0));
        item.setHokenshaNo2(保険者番号リスト.get(数字_1));
        item.setHokenshaNo3(保険者番号リスト.get(数字_2));
        item.setHokenshaNo4(保険者番号リスト.get(数字_3));
        item.setHokenshaNo5(保険者番号リスト.get(数字_4));
        item.setHokenshaNo6(保険者番号リスト.get(数字_5));
        item.setHihokenshaNo1(被保険者番号リスト.get(数字_0));
        item.setHihokenshaNo2(被保険者番号リスト.get(数字_1));
        item.setHihokenshaNo3(被保険者番号リスト.get(数字_2));
        item.setHihokenshaNo4(被保険者番号リスト.get(数字_3));
        item.setHihokenshaNo5(被保険者番号リスト.get(数字_4));
        item.setHihokenshaNo6(被保険者番号リスト.get(数字_5));
        item.setHihokenshaNo7(被保険者番号リスト.get(数字_6));
        item.setHihokenshaNo8(被保険者番号リスト.get(数字_7));
        item.setHihokenshaNo9(被保険者番号リスト.get(数字_8));
        item.setHihokenshaNo10(被保険者番号リスト.get(数字_9));
        RString ninteiShinseiDay = new FlexibleDate(business.get認定申請年月日()).wareki().eraType(EraType.ALPHABET).firstYear(FirstYear.ICHI_NEN)
                .separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
        item.setShinseiYY1(ninteiShinseiDay.substring(数字_1, 数字_2));
        item.setShinseiYY2(ninteiShinseiDay.substring(数字_2, 数字_3));
        item.setShinseiMM1(ninteiShinseiDay.substring(数字_4, 数字_5));
        item.setShinseiMM2(ninteiShinseiDay.substring(数字_5, 数字_6));
        item.setShinseiDD1(ninteiShinseiDay.substring(数字_7, 数字_8));
        item.setShinseiDD2(ninteiShinseiDay.substring(数字_8));
        itemList.add(item);
        return itemList;
    }

    /**
     * 主治医意見書記入情報3印刷用パラメータを作成します。
     *
     * @param business 主治医意見書記入情報
     * @return 主治医意見書記入情報3
     */
    public List<IkenshokinyuyoshiBusiness> create主治医意見書記入情報3_パラメータ(ChosaIraishoAndChosahyoAndIkenshoPrintBusiness business) {

        List<IkenshokinyuyoshiBusiness> itemList = new ArrayList<>();
        List<RString> 保険者番号リスト = get被保険者番号(business.get保険者番号());
        List<RString> 被保険者番号リスト = get被保険者番号(business.get被保険者番号());
        IkenshokinyuyoshiBusiness item = new IkenshokinyuyoshiBusiness();
        item.setHokenshaNo1(保険者番号リスト.get(数字_0));
        item.setHokenshaNo2(保険者番号リスト.get(数字_1));
        item.setHokenshaNo3(保険者番号リスト.get(数字_2));
        item.setHokenshaNo4(保険者番号リスト.get(数字_3));
        item.setHokenshaNo5(保険者番号リスト.get(数字_4));
        item.setHokenshaNo6(保険者番号リスト.get(数字_5));
        item.setHihokenshaNo1(被保険者番号リスト.get(数字_0));
        item.setHihokenshaNo2(被保険者番号リスト.get(数字_1));
        item.setHihokenshaNo3(被保険者番号リスト.get(数字_2));
        item.setHihokenshaNo4(被保険者番号リスト.get(数字_3));
        item.setHihokenshaNo5(被保険者番号リスト.get(数字_4));
        item.setHihokenshaNo6(被保険者番号リスト.get(数字_5));
        item.setHihokenshaNo7(被保険者番号リスト.get(数字_6));
        item.setHihokenshaNo8(被保険者番号リスト.get(数字_7));
        item.setHihokenshaNo9(被保険者番号リスト.get(数字_8));
        item.setHihokenshaNo10(被保険者番号リスト.get(数字_9));
        item.setHihokenshaTel(business.get電話番号());
        RString ninteiShinseiDay = new FlexibleDate(business.get認定申請年月日()).wareki().eraType(EraType.ALPHABET).firstYear(FirstYear.ICHI_NEN)
                .separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
        item.setShinseiYY1(ninteiShinseiDay.substring(数字_1, 数字_2));
        item.setShinseiYY2(ninteiShinseiDay.substring(数字_2, 数字_3));
        item.setShinseiMM1(ninteiShinseiDay.substring(数字_4, 数字_5));
        item.setShinseiMM2(ninteiShinseiDay.substring(数字_5, 数字_6));
        item.setShinseiDD1(ninteiShinseiDay.substring(数字_7, 数字_8));
        item.setShinseiDD2(ninteiShinseiDay.substring(数字_8));
        itemList.add(item);
        return itemList;
    }

    /**
     * 意見書作成依頼書情報印刷用パラメータを作成します。
     *
     * @param 意見書作成依頼書情報 意見書作成依頼書情報
     * @return 意見書作成依頼書情報印刷用パラメータ
     */
    public List<ShujiiIkenshoSakuseiIraishoItem> create意見書作成依頼書(IkenshoirairirekiichiranShudou 意見書作成依頼書情報) {

        ShujiiIkenshoSakuseiIraishoItem item = new ShujiiIkenshoSakuseiIraishoItem();
        item.setBunshoNo(ReportUtil.get文書番号(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE230001.getReportId(), FlexibleDate.getNowDate()));
        RString 医療機関郵便番号 = RString.EMPTY;
        RString 医療機関住所 = RString.EMPTY;
        if (意見書作成依頼書情報.get医療機関郵便番号() != null) {
            医療機関郵便番号 = 意見書作成依頼書情報.get医療機関郵便番号().value();
        }
        if (意見書作成依頼書情報.get医療機関住所() != null) {
            医療機関住所 = 意見書作成依頼書情報.get医療機関住所().value();
        }
        item.setYubinNo(医療機関郵便番号);
        item.setJusho(医療機関住所);
        item.setKikanNameText(意見書作成依頼書情報.get医療機関名称());
        item.setShimeiText(意見書作成依頼書情報.get主治医氏名());
        item.setMeishoFuyo(get名称付与(ConfigNameDBE.主治医意見書作成依頼書_宛先敬称));
        item.setCustomerBarCode(ReportUtil.getCustomerBarCode(医療機関郵便番号, 医療機関住所));
        item.setSonota(意見書作成依頼書情報.get被保険者番号());
        item.setAtenaRenban(初期連番);
        item.setTitle(DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成依頼書, RDate.getNowDate(), SubGyomuCode.DBE認定支援));
        Map<Integer, RString> 通知文 = ReportUtil.get通知文(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE230001.getReportId(), KamokuCode.EMPTY, 数字_1);
        item.setTsuchibun1(通知文.get(数字_1));
        item.setTsuchibun2(通知文.get(数字_2));
        item.setShinseiKubun(new RString(NinteiShinseiKubunShinsei.toValue(
                Integer.parseInt(意見書作成依頼書情報.get認定申請区分申請時コード().toString())).name()));
        RString hihokenshaNo = 意見書作成依頼書情報.get被保険者番号().padRight(RString.HALF_SPACE, 数字_10);
        item.setHihokenshaNo1(hihokenshaNo.substring(数字_0, 数字_1));
        item.setHihokenshaNo2(hihokenshaNo.substring(数字_1, 数字_2));
        item.setHihokenshaNo3(hihokenshaNo.substring(数字_2, 数字_3));
        item.setHihokenshaNo4(hihokenshaNo.substring(数字_3, 数字_4));
        item.setHihokenshaNo5(hihokenshaNo.substring(数字_4, 数字_5));
        item.setHihokenshaNo6(hihokenshaNo.substring(数字_5, 数字_6));
        item.setHihokenshaNo7(hihokenshaNo.substring(数字_6, 数字_7));
        item.setHihokenshaNo8(hihokenshaNo.substring(数字_7, 数字_8));
        item.setHihokenshaNo9(hihokenshaNo.substring(数字_8, 数字_9));
        item.setHihokenshaNo10(hihokenshaNo.substring(数字_9));
        RString hokenshaNo = 意見書作成依頼書情報.get証記載保険者番号().padRight(RString.HALF_SPACE, 数字_6);
        item.setHokenshaNo1(hokenshaNo.substring(数字_0, 数字_1));
        item.setHokenshaNo2(hokenshaNo.substring(数字_1, 数字_2));
        item.setHokenshaNo3(hokenshaNo.substring(数字_2, 数字_3));
        item.setHokenshaNo4(hokenshaNo.substring(数字_3, 数字_4));
        item.setHokenshaNo5(hokenshaNo.substring(数字_4, 数字_5));
        item.setHokenshaNo6(hokenshaNo.substring(数字_5));
        if (意見書作成依頼書情報.get被保険者氏名カナ() != null) {
            item.setHihokenshaNameKana(意見書作成依頼書情報.get被保険者氏名カナ().value());
        }
        if (Seibetsu.男.getコード().equals(意見書作成依頼書情報.get性別().value())) {
            item.setSeibetsuWoman(星);
        } else if (Seibetsu.女.getコード().equals(意見書作成依頼書情報.get性別().value())) {
            item.setSeibetsuMan(星);
        }
        if (意見書作成依頼書情報.get被保険者氏名() != null) {
            item.setHihokenshaName(意見書作成依頼書情報.get被保険者氏名().value());
        }
        item.setHihokenshaName(意見書作成依頼書情報.get被保険者氏名().value());
        FlexibleDate birthYMD = 意見書作成依頼書情報.get生年月日();
        if (birthYMD != null && !FlexibleDate.EMPTY.equals(birthYMD)) {
            item.setBirthYMD(fomartDate12(birthYMD).substring(数字_2));
            if (new RString("明").equals(birthYMD.getYear().wareki().getEra())) {
                item.setBirthGengoShowa(星);
                item.setBirthGengoTaisho(星);
            } else if (new RString("大").equals(birthYMD.getYear().wareki().getEra())) {
                item.setBirthGengoMeiji(星);
                item.setBirthGengoShowa(星);
            } else if (new RString("昭").equals(birthYMD.getYear().wareki().getEra())) {
                item.setBirthGengoTaisho(星);
                item.setBirthGengoMeiji(星);
            }
        }
        if (意見書作成依頼書情報.get郵便番号() != null) {
            item.setYubinNo1(getEditedYubinNo(意見書作成依頼書情報.get郵便番号().value()));
        }
        if (意見書作成依頼書情報.get住所() != null) {
            item.setJushoText(意見書作成依頼書情報.get住所().value());
        }
        item.setShinseiYMD(fomartDate12(意見書作成依頼書情報.get認定申請年月日()));
        FlexibleDate 作成期限 = get主治医意見書作成期限年月日(意見書作成依頼書情報.get認定申請年月日(), div);
        item.setTeishutsuKigen(fomartDate12(作成期限));
        if (!RString.isNullOrEmpty(意見書作成依頼書情報.get主治医意見書依頼区分())) {
            item.setShoriName(IkenshoIraiKubun.toValue(意見書作成依頼書情報.get主治医意見書依頼区分()).get名称());
        }
        List<ShujiiIkenshoSakuseiIraishoItem> 主治医意見書作成依頼情報ItemList = new ArrayList<>();
        主治医意見書作成依頼情報ItemList.add(item);
        return 主治医意見書作成依頼情報ItemList;
    }

    /**
     * 意見書作成依頼一覧表印刷用パラメータを作成します。
     *
     * @param 意見書作成依頼書情報 意見書作成依頼一覧表情報
     * @return 意見書作成依頼一覧表情報印刷用パラメータ
     */
    public List<IkenshoSakuseiIraiIchiranhyoItem> create意見書作成依頼一覧表(IkenshoirairirekiichiranShudou 意見書作成依頼書情報) {

        IkenshoSakuseiIraiIchiranhyoItem item = new IkenshoSakuseiIraiIchiranhyoItem();
        RString 医療機関郵便番号 = RString.EMPTY;
        RString 医療機関住所 = RString.EMPTY;
        if (意見書作成依頼書情報.get医療機関郵便番号() != null) {
            医療機関郵便番号 = 意見書作成依頼書情報.get医療機関郵便番号().value();
        }
        if (意見書作成依頼書情報.get医療機関住所() != null) {
            医療機関住所 = 意見書作成依頼書情報.get医療機関住所().value();
        }
        item.setYubinNo1(医療機関郵便番号);
        item.setJushoText(医療機関住所);
        item.setKikanNameText(意見書作成依頼書情報.get医療機関名称());
        item.setShimeiText(意見書作成依頼書情報.get代表者名());
        item.setMeishoFuyo(get名称付与(ConfigNameDBE.主治医意見書作成依頼書_宛先敬称));
        item.setPrintTimeStamp(get作成年月日時());

        item.setListIchiranhyo_2(意見書作成依頼書情報.get主治医氏名());
        item.setListIchiranhyo_3(意見書作成依頼書情報.get被保険者番号());
        if (意見書作成依頼書情報.get被保険者氏名() != null) {
            item.setListIchiranhyo_4(意見書作成依頼書情報.get被保険者氏名().value());
        }
        if (意見書作成依頼書情報.get被保険者氏名カナ() != null) {
            item.setListIchiranhyo_5(意見書作成依頼書情報.get被保険者氏名カナ().value());
        }
        if (意見書作成依頼書情報.get住所() != null) {
            item.setListIchiranhyo_6(意見書作成依頼書情報.get住所().value());
        }
        item.setListIchiranhyo_7(fomartDate12(意見書作成依頼書情報.get生年月日()));
        item.setListIchiranhyo_8(Seibetsu.toValue(意見書作成依頼書情報.get性別().value()).get名称());
        item.setListIchiranhyo_9(fomartDate12(get主治医意見書作成期限年月日(意見書作成依頼書情報.get主治医意見書作成依頼年月日(), div)));
        item.setTsuchibun1(ReportUtil.get通知文(
                SubGyomuCode.DBE認定支援, ReportIdDBE.DBE230002.getReportId(), KamokuCode.EMPTY, 数字_1).get(数字_1));
        List<IkenshoSakuseiIraiIchiranhyoItem> 意見書作成依頼一覧表ItemList = new ArrayList<>();
        意見書作成依頼一覧表ItemList.add(item);

        return 意見書作成依頼一覧表ItemList;
    }

    /**
     * 介護保険診断命令書印刷用パラメータを作成します。
     *
     * @param business 介護保険診断命令書情報
     * @return 介護保険診断命令書パラメータ
     */
    public List<KaigohokenShindanMeireishoHeaderItem> create介護保険診断命令書(ChosaIraishoAndChosahyoAndIkenshoPrintBusiness business) {
        List<KaigohokenShindanMeireishoHeaderItem> itemList = new ArrayList<>();

        RString 受診場所 = div.getTxtJyushinbasho().getValue();
        RString 文書番号 = ReportUtil.get文書番号(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE235001.getReportId(), FlexibleDate.getNowDate());
        RString customerBarCode = RString.EMPTY;
        if (!RString.isNullOrEmpty(business.get調査委託先郵便番号()) && !RString.isNullOrEmpty(business.get調査委託先住所())) {
            customerBarCode = ReportUtil.getCustomerBarCode(business.get医療機関郵便番号(), business.get医療機関住所());
        }
        Map<Integer, RString> 通知文
                = ReportUtil.get通知文(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE235001.getReportId(), KamokuCode.EMPTY, 1);
        KaigohokenShindanMeireishoHeaderItem item = new KaigohokenShindanMeireishoHeaderItem(
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                文書番号,
                business.get医療機関郵便番号(),
                business.get医療機関住所(),
                business.get被保険者氏名(),
                get名称付与(ConfigNameDBE.介護保険診断命令書_宛先敬称),
                customerBarCode,
                初期連番,
                business.get被保険者番号(),
                通知文.get(1),
                business.get被保険者氏名(),
                business.get被保険者番号(),
                business.get医療機関名称(),
                business.get主治医氏名(),
                business.get医療機関住所(),
                business.get医療機関電話番号(),
                get受診日時または期間(),
                受診場所,
                通知文.get(2));
        itemList.add(item);
        return itemList;
    }

    /**
     * 主治医意見書作成依頼発行一覧表印刷用パラメータを作成します。
     *
     * @param 主治医意見書作成依頼発行一覧表情報 主治医意見書作成依頼発行一覧表情報
     * @return 主治医意見書作成依頼発行一覧表印刷用パラメータ
     */
    public SyujiyikenshosakuseyiraihakouReportJoho create主治医意見書作成依頼発行一覧表(List<IkenshoirairirekiichiranShudou> 主治医意見書作成依頼発行一覧表情報) {

        SyujiyikenshosakuseyiraihakouHeadItem headItem = new SyujiyikenshosakuseyiraihakouHeadItem(RString.EMPTY, RString.EMPTY, new RString("1"));
        List<SyujiyikenshosakuseyiraihakouBodyItem> bodyItemList = new ArrayList<>();
        for (IkenshoirairirekiichiranShudou shudou : 主治医意見書作成依頼発行一覧表情報) {
            RString 被保険者氏名 = RString.EMPTY;
            if (shudou.get被保険者氏名() != null) {
                被保険者氏名 = shudou.get被保険者氏名().value();
            }
            RString 電話番号 = RString.EMPTY;
            if (shudou.get電話番号() != null) {
                電話番号 = shudou.get電話番号().value();
            }
            RString 市町村コード = RString.EMPTY;
            if (shudou.get市町村コード() != null) {
                市町村コード = shudou.get市町村コード().value();
            }
            SyujiyikenshosakuseyiraihakouBodyItem bodyItem = new SyujiyikenshosakuseyiraihakouBodyItem(shudou.get被保険者番号(),
                    被保険者氏名, fomartDate12(shudou.get依頼書出力年月日()), shudou.get医療機関名称(), shudou.get代表者名(),
                    電話番号, shudou.get主治医氏名(), RString.EMPTY, RString.EMPTY, fomartDate12(shudou.get主治医意見書作成依頼年月日()),
                    fomartDate12(shudou.get主治医意見書作成期限年月日()),
                    市町村コード, shudou.get市町村名称());
            bodyItemList.add(bodyItem);
        }
        SyujiyikenshosakuseyiraihakouReportJoho 主治医意見書作成依頼発行一覧表 = new SyujiyikenshosakuseyiraihakouReportJoho(headItem, bodyItemList);

        return 主治医意見書作成依頼発行一覧表;
    }

    /**
     * 主治医意見書作成料請求書印刷用パラメータを作成します。
     *
     * @param business 主治医意見書作成料請求書情報
     * @return 主治医意見書作成料請求書パラメータ
     */
    public List<ShujiiIkenshoSakuseiRyoSeikyushoItem> create主治医意見書作成料請求書(ChosaIraishoAndChosahyoAndIkenshoPrintBusiness business) {

        List<ShujiiIkenshoSakuseiRyoSeikyushoItem> itemList = new ArrayList<>();
        ShujiiIkenshoSakuseiRyoSeikyushoItem item = new ShujiiIkenshoSakuseiRyoSeikyushoItem();
        item.setGengo(RDate.getNowDate().toDateString());
        item.setAtesakiHokenshaName(business.get保険者名());
        item.setShinkiZaitakuKingaku(IkenshoSakuseiRyo.在宅新規.get名称());
        item.setShinkiShisetsuKingaku(IkenshoSakuseiRyo.施設新規.get名称());
        item.setKeizokuZaitakuKingaku(IkenshoSakuseiRyo.在宅継続.get名称());
        item.setKeizokuShisetsuKingaku(IkenshoSakuseiRyo.施設継続.get名称());
        List<RString> 保険者番号リスト = get被保険者番号(business.get被保険者番号());
        item.setHihokenshaNo1(保険者番号リスト.get(数字_0));
        item.setHihokenshaNo2(保険者番号リスト.get(数字_1));
        item.setHihokenshaNo3(保険者番号リスト.get(数字_2));
        item.setHihokenshaNo4(保険者番号リスト.get(数字_3));
        item.setHihokenshaNo5(保険者番号リスト.get(数字_4));
        item.setHihokenshaNo6(保険者番号リスト.get(数字_5));
        item.setHihokenshaNo7(保険者番号リスト.get(数字_6));
        item.setHihokenshaNo8(保険者番号リスト.get(数字_7));
        item.setHihokenshaNo9(保険者番号リスト.get(数字_8));
        item.setHihokenshaNo10(保険者番号リスト.get(数字_9));
        item.setHihokenshaNameKana(business.get被保険者氏名カナ());
        item.setHihokenshaName(business.get被保険者氏名());
        item.setBirthYMD(business.get生年月日());
        item.setSeibetsu(Seibetsu.toValue(business.get性別()).get名称());
        if (ZaitakuShisetsuKubun.在宅.getコード().equals(business.get在宅施設区分())) {
            item.setShubetsuZaitaku(記号_CHECKED);
        } else {
            item.setShubetsuZaitaku(RString.EMPTY);
        }
        if (ZaitakuShisetsuKubun.施設.getコード().equals(business.get在宅施設区分())) {
            item.setShubetsuShisetsu(記号_CHECKED);
        } else {
            item.setShubetsuShisetsu(RString.EMPTY);
        }
        if (IkenshoSakuseiKaisuKubun.初回.getコード().equals(business.get意見書作成回数区分())) {
            item.setShubetsuShinki(記号_CHECKED);
        } else {
            item.setShubetsuShinki(RString.EMPTY);
        }
        if (IkenshoSakuseiKaisuKubun._2回目以降.getコード().equals(business.get意見書作成回数区分())) {
            item.setShubetsuKeizoku(記号_CHECKED);
        } else {
            item.setShubetsuKeizoku(RString.EMPTY);
        }
        item.setSeikyuIryokikanName(business.get医療機関名称());
        item.setSeikyuIryokikanDaihyoName(business.get代表者名());
        item.setSeikyuIryokikanYubinNo(business.get医療機関郵便番号());
        item.setSeikyuIryokikanJusho(business.get医療機関住所());
        item.setSeikyuIryokikanTel(business.get医療機関電話番号());
        set意見書作成料(business, item);
        itemList.add(item);
        return itemList;
    }

    /**
     * 介護保険指定医依頼兼主治医意見書提出意見書印刷用パラメータを作成します。
     *
     * @param 主治医意見書作成依頼発行一覧表情報 主治医意見書作成依頼発行一覧表情報
     * @return 介護保険指定医依頼兼主治医意見書提出意見書印刷用パラメータ
     */
    public ShujiiIkenshoTeishutsuIraishoReportJoho create介護保険指定医依頼兼主治医意見書提出意見書(List<ShujiiIkenshoTeishutsuIraishoBusiness> 主治医意見書作成依頼発行一覧表情報) {

        List<ShujiiIkenshoTeishutsuIraishoItem> itemList = new ArrayList<>();
        RString 文書番号 = ReportUtil.get文書番号(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE236001.getReportId(), FlexibleDate.getNowDate());
        Map<Integer, RString> 通知文 = ReportUtil.get通知文(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE236001.getReportId(), KamokuCode.EMPTY, 数字_1);
        for (ShujiiIkenshoTeishutsuIraishoBusiness business : 主治医意見書作成依頼発行一覧表情報) {
            ShujiiIkenshoTeishutsuIraishoItem item = new ShujiiIkenshoTeishutsuIraishoItem();
            item.setBunshoNo(文書番号);
            RString 医療機関郵便番号 = RString.EMPTY;
            RString 医療機関住所 = RString.EMPTY;
            if (business.get医療機関郵便番号() != null) {
                医療機関郵便番号 = business.get医療機関郵便番号().value();
            }
            if (business.get医療機関住所() != null) {
                医療機関住所 = business.get医療機関住所().value();
            }
            item.setYubinNo1(医療機関郵便番号);
            item.setJushoText(医療機関住所);

            item.setShimeiText(business.get主治医氏名());
            item.setMeishoFuyo(get名称付与(ConfigNameDBE.介護保険指定医依頼兼主治医意見書提出依頼書_宛先敬称));
            item.setCustomerBarCode(ReportUtil.getCustomerBarCode(医療機関郵便番号, 医療機関住所));
            item.setSonota(business.get被保険者番号());
            item.setTitle(getConfigValue(ConfigNameDBE.介護保険指定医依頼兼主治医意見書提出依頼書));
            item.setTsuchibun1(通知文.get(数字_1));
            List<RString> 被保険者番号リスト = get被保険者番号(business.get被保険者番号());
            item.setHihokenshaNo1(被保険者番号リスト.get(数字_0));
            item.setHihokenshaNo2(被保険者番号リスト.get(数字_1));
            item.setHihokenshaNo3(被保険者番号リスト.get(数字_2));
            item.setHihokenshaNo4(被保険者番号リスト.get(数字_3));
            item.setHihokenshaNo5(被保険者番号リスト.get(数字_4));
            item.setHihokenshaNo6(被保険者番号リスト.get(数字_5));
            item.setHihokenshaNo7(被保険者番号リスト.get(数字_6));
            item.setHihokenshaNo8(被保険者番号リスト.get(数字_7));
            item.setHihokenshaNo9(被保険者番号リスト.get(数字_8));
            item.setHihokenshaNo10(被保険者番号リスト.get(数字_9));
            if (business.get被保険者氏名カナ() != null) {
                item.setHihokenshaNameKana(business.get被保険者氏名カナ().value());
            }
            item.setHihokenshaNameKana(business.get被保険者氏名カナ().value());
            if (business.get被保険者氏名() != null) {
                item.setHihokenshaName(business.get被保険者氏名().value());
            }
            item.setHihokenshaName(business.get被保険者氏名().value());

            if (Seibetsu.男.getコード().equals(business.get性別().value())) {
                item.setSeibetsuWoman(星);
            } else if (Seibetsu.女.getコード().equals(business.get性別().value())) {
                item.setSeibetsuMan(星);
            }
            FlexibleDate birthYMD = business.get生年月日();
            if (birthYMD != null && !FlexibleDate.EMPTY.equals(birthYMD)) {
                item.setBirthYMD(fomartDate6(birthYMD).substring(数字_1));
                if (new RString("明").equals(birthYMD.getYear().wareki().getEra())) {
                    item.setBirthGengoShowa(星);
                    item.setBirthGengoTaisho(星);
                } else if (new RString("大").equals(birthYMD.getYear().wareki().getEra())) {
                    item.setBirthGengoMeiji(星);
                    item.setBirthGengoShowa(星);
                } else if (new RString("昭").equals(birthYMD.getYear().wareki().getEra())) {
                    item.setBirthGengoTaisho(星);
                    item.setBirthGengoMeiji(星);
                }
            }
            if (business.get住所() != null) {
                item.setJusho(business.get住所().value());
            }
            if (business.get郵便番号() != null) {
                item.setYubinNo(business.get郵便番号().value());
            }
            item.setTsuchibun1(通知文.get(数字_2));
            itemList.add(item);
        }
        return new ShujiiIkenshoTeishutsuIraishoReportJoho(itemList);
    }

    private RString getEditedYubinNo(RString yubinNo) {
        if (RString.isNullOrEmpty(yubinNo)) {
            return RString.EMPTY;
        }
        if (yubinNo.length() < 数字_5) {
            return yubinNo;
        }
        return yubinNo.insert(yubinNo.length() - 数字_4, "-");
    }

    private RString fomartDate12(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return date.wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString();
    }

    private RString fomartDate6(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return date.wareki().eraType(EraType.KANJI_RYAKU).
                firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

    private RString get名称付与(ConfigNameDBE config) {
        RString 名称付与 = RString.EMPTY;
        RString 宛先敬称 = DbBusinessConfig.get(config, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        if (宛先敬称_0.equals(宛先敬称)) {
            名称付与 = RString.EMPTY;
        } else if (宛先敬称_1.equals(宛先敬称)) {
            名称付与 = 宛先敬称_様;
        } else if (宛先敬称_2.equals(宛先敬称)) {
            名称付与 = 宛先敬称_殿;
        }
        return 名称付与;
    }

    private RString get作成年月日時() {
        RDateTime printdate = RDateTime.now();
        RStringBuilder printTimeStampSb = new RStringBuilder();
        printTimeStampSb.append(printdate.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString());
        printTimeStampSb.append(RString.HALF_SPACE);
        printTimeStampSb.append(String.format("%02d", printdate.getHour()));
        printTimeStampSb.append(new RString("時"));
        printTimeStampSb.append(String.format("%02d", printdate.getMinute()));
        printTimeStampSb.append(new RString("分"));
        printTimeStampSb.append(String.format("%02d", printdate.getSecond()));
        printTimeStampSb.append(new RString("秒"));
        return printTimeStampSb.toRString();
    }

    private void set意見書作成料(ChosaIraishoAndChosahyoAndIkenshoPrintBusiness business, ShujiiIkenshoSakuseiRyoSeikyushoItem item) {
        if (IkenshoIraiKubun.初回依頼.getコード().equals(business.get主治医意見書依頼区分())
                && ZaitakuShisetsuKubun.在宅.getコード().equals(business.get在宅施設区分())) {
            RString shinkiZaitakuKingaku = item.getShinkiZaitakuKingaku();
            item.setIkenshoSakuseiRyo1(shinkiZaitakuKingaku.substring(数字_0, 数字_1));
            item.setIkenshoSakuseiRyo2(shinkiZaitakuKingaku.substring(数字_1, 数字_2));
            item.setIkenshoSakuseiRyo3(shinkiZaitakuKingaku.substring(数字_2, 数字_3));
            item.setIkenshoSakuseiRyo4(shinkiZaitakuKingaku.substring(数字_3, 数字_4));
            item.setSeikyugakuIkenshoSakuseiRyo1(shinkiZaitakuKingaku.substring(数字_0, 数字_1));
            item.setSeikyugakuIkenshoSakuseiRyo2(shinkiZaitakuKingaku.substring(数字_1, 数字_2));
            item.setSeikyugakuIkenshoSakuseiRyo3(shinkiZaitakuKingaku.substring(数字_2, 数字_3));
            item.setSeikyugakuIkenshoSakuseiRyo4(shinkiZaitakuKingaku.substring(数字_3, 数字_4));
        }
        if (IkenshoIraiKubun.初回依頼.getコード().equals(business.get主治医意見書依頼区分())
                && ZaitakuShisetsuKubun.施設.getコード().equals(business.get在宅施設区分())) {
            RString shinkiShisetsuKingaku = item.getShinkiShisetsuKingaku();
            item.setIkenshoSakuseiRyo1(shinkiShisetsuKingaku.substring(数字_0, 数字_1));
            item.setIkenshoSakuseiRyo2(shinkiShisetsuKingaku.substring(数字_1, 数字_2));
            item.setIkenshoSakuseiRyo3(shinkiShisetsuKingaku.substring(数字_2, 数字_3));
            item.setIkenshoSakuseiRyo4(shinkiShisetsuKingaku.substring(数字_3, 数字_4));
            item.setSeikyugakuIkenshoSakuseiRyo1(shinkiShisetsuKingaku.substring(数字_0, 数字_1));
            item.setSeikyugakuIkenshoSakuseiRyo2(shinkiShisetsuKingaku.substring(数字_1, 数字_2));
            item.setSeikyugakuIkenshoSakuseiRyo3(shinkiShisetsuKingaku.substring(数字_2, 数字_3));
            item.setSeikyugakuIkenshoSakuseiRyo4(shinkiShisetsuKingaku.substring(数字_3, 数字_4));

        }
        if (IkenshoIraiKubun.再依頼.getコード().equals(business.get主治医意見書依頼区分())
                && ZaitakuShisetsuKubun.在宅.getコード().equals(business.get在宅施設区分())) {
            RString keizokuZaitakuKingaku = item.getKeizokuZaitakuKingaku();
            item.setIkenshoSakuseiRyo1(keizokuZaitakuKingaku.substring(数字_0, 数字_1));
            item.setIkenshoSakuseiRyo2(keizokuZaitakuKingaku.substring(数字_1, 数字_2));
            item.setIkenshoSakuseiRyo3(keizokuZaitakuKingaku.substring(数字_2, 数字_3));
            item.setIkenshoSakuseiRyo4(keizokuZaitakuKingaku.substring(数字_3, 数字_4));
            item.setSeikyugakuIkenshoSakuseiRyo1(keizokuZaitakuKingaku.substring(数字_0, 数字_1));
            item.setSeikyugakuIkenshoSakuseiRyo2(keizokuZaitakuKingaku.substring(数字_1, 数字_2));
            item.setSeikyugakuIkenshoSakuseiRyo3(keizokuZaitakuKingaku.substring(数字_2, 数字_3));
            item.setSeikyugakuIkenshoSakuseiRyo4(keizokuZaitakuKingaku.substring(数字_3, 数字_4));

        }
        if (IkenshoIraiKubun.再依頼.getコード().equals(business.get主治医意見書依頼区分())
                && ZaitakuShisetsuKubun.施設.getコード().equals(business.get在宅施設区分())) {
            RString keizokuShisetsuKingaku = item.getKeizokuShisetsuKingaku();
            item.setIkenshoSakuseiRyo1(keizokuShisetsuKingaku.substring(数字_0, 数字_1));
            item.setIkenshoSakuseiRyo2(keizokuShisetsuKingaku.substring(数字_1, 数字_2));
            item.setIkenshoSakuseiRyo3(keizokuShisetsuKingaku.substring(数字_2, 数字_3));
            item.setIkenshoSakuseiRyo4(keizokuShisetsuKingaku.substring(数字_3, 数字_4));
            item.setSeikyugakuIkenshoSakuseiRyo1(keizokuShisetsuKingaku.substring(数字_0, 数字_1));
            item.setSeikyugakuIkenshoSakuseiRyo2(keizokuShisetsuKingaku.substring(数字_1, 数字_2));
            item.setSeikyugakuIkenshoSakuseiRyo3(keizokuShisetsuKingaku.substring(数字_2, 数字_3));
            item.setSeikyugakuIkenshoSakuseiRyo4(keizokuShisetsuKingaku.substring(数字_3, 数字_4));
        }
    }

    private void set依頼区分() {
        List<KeyValueDataSource> 依頼区分 = new ArrayList<>();
        依頼区分.add(new KeyValueDataSource(IkenshoIraiKubun.初回依頼.getコード(), IkenshoIraiKubun.初回依頼.get名称()));
        依頼区分.add(new KeyValueDataSource(IkenshoIraiKubun.再依頼.getコード(), IkenshoIraiKubun.再依頼.get名称()));
        依頼区分.add(new KeyValueDataSource(IkenshoIraiKubun.再意見書.getコード(), IkenshoIraiKubun.再意見書.get名称()));
        div.getDdlIraiKubun().setDataSource(依頼区分);
    }

    private List<RString> get被保険者番号(RString 被保険者番号) {
        List<RString> 被保険者番号リスト = new ArrayList<>();
        for (int i = 数字_0; i <= 数字_9; i++) {
            被保険者番号リスト.add(RString.EMPTY);
        }

        if (数字_0 < 被保険者番号.length()) {
            被保険者番号リスト.set(数字_0, 被保険者番号.substring(数字_0, 数字_1));
        }
        if (数字_1 < 被保険者番号.length()) {
            被保険者番号リスト.set(数字_1, 被保険者番号.substring(数字_1, 数字_2));
        }
        if (数字_2 < 被保険者番号.length()) {
            被保険者番号リスト.set(数字_2, 被保険者番号.substring(数字_2, 数字_3));
        }
        if (数字_3 < 被保険者番号.length()) {
            被保険者番号リスト.set(数字_3, 被保険者番号.substring(数字_3, 数字_4));
        }
        if (数字_4 < 被保険者番号.length()) {
            被保険者番号リスト.set(数字_4, 被保険者番号.substring(数字_4, 数字_5));
        }
        if (数字_5 < 被保険者番号.length()) {
            被保険者番号リスト.set(数字_5, 被保険者番号.substring(数字_5, 数字_6));
        }
        if (数字_6 < 被保険者番号.length()) {
            被保険者番号リスト.set(数字_6, 被保険者番号.substring(数字_6, 数字_7));
        }
        if (数字_7 < 被保険者番号.length()) {
            被保険者番号リスト.set(数字_7, 被保険者番号.substring(数字_7, 数字_8));
        }
        if (数字_8 < 被保険者番号.length()) {
            被保険者番号リスト.set(数字_8, 被保険者番号.substring(数字_8, 数字_9));
        }
        if (数字_9 < 被保険者番号.length()) {
            被保険者番号リスト.set(数字_9, 被保険者番号.substring(数字_9));
        }
        return 被保険者番号リスト;
    }

    private RString get受診日時または期間() {
        RStringBuilder 受診日時または期間 = new RStringBuilder();
        RString radJyushinKikan = div.getRadJyushin().getSelectedKey();

        if (SELECTED_KEY0.equals(radJyushinKikan)) {
            RDate ymd = div.getTxtJyushinymd().getValue();
            RTime time = div.getTxtJyushintime().getValue();

            受診日時または期間.append(ymd.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            受診日時または期間.append(time.toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒));
            受診日時または期間.append(文字列_まで);
        } else {
            RDate from = div.getTxtJyushinKikan().getFromValue();
            RDate to = div.getTxtJyushinKikan().getToValue();
            受診日時または期間.append(from.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            受診日時または期間.append(連結);
            受診日時または期間.append(to.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            受診日時または期間.append(文字列_まで);
        }
        return 受診日時または期間.toRString();
    }

    private RString getConfigValue(ConfigNameDBE config) {
        return DbBusinessConfig.get(config, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
    }
}
