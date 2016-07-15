/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ChosaIraishoAndChosahyoAndIkenshoPrint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.core.ikenshokinyuyoshi.IkenshokinyuyoshiBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ikenshoprint.ChosaIraishoAndChosahyoAndIkenshoPrintBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyotokkijiko.ChosahyoTokkijikoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.ninteishinseijoho.NinteiShinseiJoho2;
import jp.co.ndensan.reams.db.dbe.business.report.chosahyokihonchosakatamen.ChosahyoKihonchosaKatamenItem;
import jp.co.ndensan.reams.db.dbe.business.report.chosairaiichiranhyo.ChosaIraiIchiranhyoBodyItem;
import jp.co.ndensan.reams.db.dbe.business.report.chosairaisho.ChosaIraishoHeadItem;
import jp.co.ndensan.reams.db.dbe.business.report.ikenshosakuseiiraiichiranhyo.IkenshoSakuseiIraiIchiranhyoItem;
import jp.co.ndensan.reams.db.dbe.business.report.kaigohokenshindanmeireisho.KaigohokenShindanMeireishoHeaderItem;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosahyogaikyochosa.ChosahyoGaikyochosaItem;
import jp.co.ndensan.reams.db.dbe.business.report.saichekkuhyo.SaiChekkuhyoItem;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikensho.ShujiiIkenshoSakuseiIraishoItem;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshosakusei.ShujiiIkenshoSakuseiRyoSeikyushoItem;
import jp.co.ndensan.reams.db.dbe.definition.core.chosa.ChohyoAtesakiKeisho;
import jp.co.ndensan.reams.db.dbe.definition.core.gamensenikbn.GamenSeniKbn;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ikenshoprint.ChosaIraishoAndChosahyoAndIkenshoPrintParameter;
import jp.co.ndensan.reams.db.dbe.service.core.ikenshoprint.ChosaIraishoAndChosahyoAndIkenshoPrintFinder;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakai.ninteishinseijoho.NinteiShinseiJohoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaIraiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShujiiIkenshoIraiJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.ikenshosakuseiryo.IkenshoSakuseiRyo;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping09B;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ShogaiNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoIraiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoSakuseiKaisuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.ZaitakuShisetsuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
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
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 依頼書・認定調査票(OCR)・主治医意見書印刷のハンドラークラスです。
 *
 * @reamsid_L DBE-3000-230 sunhaidi
 */
public class ChosaIraishoAndChosahyoAndIkenshoPrintHandler {

    private static final RString CONFIGVALUE1 = new RString("1");
    private static final RString CONFIGVALUE2 = new RString("2");
    private static final RString KEY0 = new RString("0");
    private static final RString KEY1 = new RString("1");
    private static final RString KEY2 = new RString("2");
    private static final RString 元号_明治 = new RString("明治");
    private static final RString 元号_大正 = new RString("大正");
    private static final RString 元号_昭和 = new RString("昭和");
    private static final RString 文字列_まで = new RString("まで");
    private static final RString 連結 = new RString("～");
    private static final RString 記号 = new RString("✔");
    private static final RString HOUSI = new RString("*");
    private static final RString 文字列1 = new RString("1");
    private static final RString 文字列2 = new RString("2");
    private static final RString 文字列3 = new RString("3");
    private static final RString 文字列4 = new RString("4");
    private static final RString 文字列5 = new RString("5");
    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;
    private static final int INDEX_6 = 6;
    private static final int INDEX_7 = 7;
    private static final int INDEX_8 = 8;
    private static final int INDEX_9 = 9;
    private static final int INDEX_10 = 10;
    private static final int INDEX_11 = 11;
    private static final RString IKENSHOSAKUSEIRYO_11 = new RString("11");
    private static final RString IKENSHOSAKUSEIRYO_12 = new RString("12");
    private static final RString IKENSHOSAKUSEIRYO_21 = new RString("21");
    private static final RString IKENSHOSAKUSEIRYO_22 = new RString("22");
    private static final RString YOKAIGOJOTAIKUBUN01 = new RString("01");
    private static final RString YOKAIGOJOTAIKUBUN12 = new RString("12");
    private static final RString YOKAIGOJOTAIKUBUN13 = new RString("13");
    private static final RString YOKAIGOJOTAIKUBUN21 = new RString("21");
    private static final RString YOKAIGOJOTAIKUBUN22 = new RString("22");
    private static final RString YOKAIGOJOTAIKUBUN23 = new RString("23");
    private static final RString YOKAIGOJOTAIKUBUN24 = new RString("24");
    private static final RString YOKAIGOJOTAIKUBUN25 = new RString("25");
    private static final RString IFSHIKIBETSUCODE99A = new RString("99A");
    private static final RString IFSHIKIBETSUCODE02A = new RString("02A");
    private static final RString IFSHIKIBETSUCODE06A = new RString("06A");
    private static final RString IFSHIKIBETSUCODE09A = new RString("09A");
    private final ChosaIraishoAndChosahyoAndIkenshoPrintDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 依頼書・認定調査票(OCR)・主治医意見書印刷Div
     */
    public ChosaIraishoAndChosahyoAndIkenshoPrintHandler(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div) {
        this.div = div;
    }

    /**
     * 依頼書・認定調査票(OCR)・主治医意見書印刷に初期化を設定します。
     *
     * @param 申請書管理番号リスト 申請書管理番号リスト
     * @param 遷移元画面区分 遷移元画面区分
     */
    public void initialize(List<ShinseishoKanriNo> 申請書管理番号リスト, GamenSeniKbn 遷移元画面区分) {
        div.getCcdHokenshaList().loadHokenshaList(GyomuBunrui.介護認定);
        RString 証記載保険者番号 = div.getCcdHokenshaList().getSelectedItem().get証記載保険者番号().value();
        ChosaIraishoAndChosahyoAndIkenshoPrintParameter parameter = ChosaIraishoAndChosahyoAndIkenshoPrintParameter.createParameter(申請書管理番号リスト,
                証記載保険者番号);
        ChosaIraishoAndChosahyoAndIkenshoPrintFinder printFinder = ChosaIraishoAndChosahyoAndIkenshoPrintFinder.createInstance();
        if (GamenSeniKbn.認定調査依頼.equals(遷移元画面区分)) {
            div.getNinteiChosa().setDisplayNone(false);
            div.getShujiiIkensho().setDisplayNone(true);
            List<ChosaIraishoAndChosahyoAndIkenshoPrintBusiness> list = printFinder.get認定調査依頼情報(parameter).records();
            List<NinteichosaIraiJoho> 認定調査依頼情報List = printFinder.get更新用認定調査依頼情報(parameter).records();
            ViewStateHolder.put(ViewStateKeys.認定調査依頼情報, Models.create(認定調査依頼情報List));
            List<dgNinteiChosa_Row> rowList = new ArrayList<>();
            int rowNo = 1;
            for (ChosaIraishoAndChosahyoAndIkenshoPrintBusiness business : list) {
                dgNinteiChosa_Row row = new dgNinteiChosa_Row();
                row.setNo(new RString(String.valueOf(rowNo++)));
                row.setHihokenshaBango(nullToEmpty(business.get被保険者番号()));
                row.setHihokenshaShimei(nullToEmpty(business.get被保険者氏名()));
                if (!RString.isNullOrEmpty(business.get性別())) {
                    row.setSeibetsu(Seibetsu.toValue(business.get性別()).get名称());
                }
                RString 認定申請年月日 = business.get認定申請年月日();
                if (!RString.isNullOrEmpty(認定申請年月日)) {
                    row.setNinteiShinseibi(new FlexibleDate(認定申請年月日).wareki().toDateString());
                }

                row.setChosaItakusakiCode(nullToEmpty(business.get認定調査委託先コード()));
                row.setChosaItakusakiMeisho(nullToEmpty(business.get事業者名称()));
                row.setChosaInCode(nullToEmpty(business.get認定調査員コード()));
                row.setChosaInShimei(nullToEmpty(business.get調査員氏名()));
                row.setShinseishoKanriNo(nullToEmpty(business.get申請書管理番号()));
                row.setRirekiNo(nullToEmpty(business.get認定調査依頼履歴番号()));
                rowList.add(row);
            }
            div.getDgNinteiChosa().setDataSource(rowList);
            setDisableToNinteiChosaChk();
        } else {
            div.getNinteiChosa().setDisplayNone(true);
            div.getShujiiIkensho().setDisplayNone(false);
            List<ChosaIraishoAndChosahyoAndIkenshoPrintBusiness> list = printFinder.get主治医意見書依頼情報(parameter).records();
            List<ShujiiIkenshoIraiJoho> 主治医意見書依頼情報List = printFinder.get更新用主治医意見書依頼情報(parameter).records();
            ViewStateHolder.put(ViewStateKeys.主治医意見書依頼情報, Models.create(主治医意見書依頼情報List));
            List<dgShujiiIkensho_Row> rowList = new ArrayList<>();
            int rowNo = 1;
            for (ChosaIraishoAndChosahyoAndIkenshoPrintBusiness business : list) {
                dgShujiiIkensho_Row row = new dgShujiiIkensho_Row();
                row.setNo(new RString(String.valueOf(rowNo++)));
                row.setHohokenshaBango(nullToEmpty(business.get被保険者番号()));
                row.setHihokenshaShimei(nullToEmpty(business.get被保険者氏名()));
                if (!RString.isNullOrEmpty(business.get性別())) {
                    row.setSeibetsu(Seibetsu.toValue(business.get性別()).get名称());
                }
                RString 認定申請年月日 = business.get認定申請年月日();
                if (!RString.isNullOrEmpty(認定申請年月日)) {
                    row.setNinteiShinseibi(new FlexibleDate(認定申請年月日).wareki().toDateString());
                }

                row.setShujiiIryokikanCode(nullToEmpty(business.get主治医医療機関コード()));
                row.setShujiiIryoKikanMeisho(nullToEmpty(business.get医療機関名称()));
                row.setShujiiCode(nullToEmpty(business.get主治医コード()));
                row.setShujiiShimei(nullToEmpty(business.get主治医氏名()));
                row.setShinseishoKanriNo(nullToEmpty(business.get申請書管理番号()));
                row.setRirekiNo(nullToEmpty(business.get主治医意見書作成依頼履歴番号()));
                rowList.add(row);
            }
            div.getDgShujiiIkensho().setDataSource(rowList);
            setDisableToShujiiIkenshoChk();
        }
        RString 主治医意見書作成期限設定方法 = DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成期限設定方法,
                RDate.getNowDate(), SubGyomuCode.DBE認定支援,
                div.getCcdHokenshaList().getSelectedItem().get市町村コード());
        if (CONFIGVALUE2.equals(主治医意見書作成期限設定方法)) {
            div.getRadTeishutsuKigen().setDisabled(true);
        } else {
            div.getRadTeishutsuKigen().setDisabled(false);
        }
        div.setHiddenData(getInputData());
    }

    /**
     * 画面編集処理判断処理です。
     *
     * @return 判断結果(true:編集あり,false:編集なし)
     */
    public boolean isUpdate() {
        if (div.getHiddenData().equals(getInputData())) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 介護保険診断命令書 チェックボックスの表示制御処理です。
     */
    public void setChkIkenshoSakuseiryoSeikyusho() {
        List<RString> keys = div.getChkIkenshoSakuseiryoSeikyusho().getSelectedKeys();
        if (keys.size() == 1) {
            div.getShindanMeirei().setDisplayNone(false);
        } else {
            div.getShindanMeirei().setDisplayNone(true);
        }
    }

    /**
     * 受診期間ラジオボタンの表示制御処理です。
     */
    public void setRadJyushinKikan() {
        RString key = div.getRadJyushinKikan().getSelectedKey();
        if (KEY0.equals(key)) {
            div.getTxtJyushinymd().setDisabled(false);
            div.getTxtJyushinymd().setRequired(true);
            div.getTxtJushinTime().setDisabled(false);
            div.getTxtJushinTime().setRequired(true);
            div.getTxtJushinKikan().setDisabled(true);
            div.getTxtJushinKikan().setFromRequired(false);
            div.getTxtJushinKikan().setToRequired(false);
            div.getTxtJushinBasho().setDisabled(false);
            div.getTxtJushinBasho().setRequired(true);
        } else {
            div.getTxtJyushinymd().setDisabled(true);
            div.getTxtJyushinymd().setRequired(false);
            div.getTxtJushinTime().setDisabled(true);
            div.getTxtJushinTime().setRequired(false);
            div.getTxtJushinKikan().setDisabled(false);
            div.getTxtJushinKikan().setFromRequired(true);
            div.getTxtJushinKikan().setToRequired(true);
            div.getTxtJushinBasho().setDisabled(false);
            div.getTxtJushinBasho().setRequired(true);
        }
    }

    /**
     * 提出期限ラジオボタンの表示制御処理です。
     */
    public void setRadTeishutsuKigen() {
        RString key = div.getRadTeishutsuKigen().getSelectedKey();
        if (KEY2.equals(key)) {
            div.getTxtKyotsuDay().setReadOnly(false);
            div.getTxtKyotsuDay().setRequired(true);
        } else {
            div.getTxtKyotsuDay().setReadOnly(true);
        }
    }

    private RString getInputData() {
        RStringBuilder inputData = new RStringBuilder();
        inputData.append(div.getCcdHokenshaList().getSelectedItem().get市町村コード().value());
        List<dgNinteiChosa_Row> dgNinteiChosaRowList = div.getDgNinteiChosa().getSelectedItems();
        for (dgNinteiChosa_Row row : dgNinteiChosaRowList) {
            inputData.append(row.getNo());
        }
        List<dgShujiiIkensho_Row> dgShujiiIkenshoList = div.getDgShujiiIkensho().getSelectedItems();
        for (dgShujiiIkensho_Row row : dgShujiiIkenshoList) {
            inputData.append(row.getNo());
        }
        for (RString key : div.getChk().getSelectedKeys()) {
            inputData.append(key);
        }
        for (RString key : div.getChkChosahyo().getSelectedKeys()) {
            inputData.append(key);
        }
        for (RString key : div.getChkOcrChosahyo().getSelectedKeys()) {
            inputData.append(key);
        }
        for (RString key : div.getChkChosahyo2().getSelectedKeys()) {
            inputData.append(key);
        }
        for (RString key : div.getChkInsatsuIkensho().getSelectedKeys()) {
            inputData.append(key);
        }
        for (RString key : div.getChkIkenshoSakuseiIchiran().getSelectedKeys()) {
            inputData.append(key);
        }
        for (RString key : div.getChkIkenshoSakuseiryoSeikyusho().getSelectedKeys()) {
            inputData.append(key);
        }
        inputData.append(div.getRadJyushinKikan().getSelectedKey());
        if (div.getTxtJyushinymd().getValue() != null) {
            inputData.append(div.getTxtJyushinymd().getValue().toDateString());
        }
        if (div.getTxtJushinTime().getValue() != null) {
            inputData.append(div.getTxtJushinTime().getValue().toFormattedTimeString(DisplayTimeFormat.HH_mm));
        }
        if (div.getTxtJushinKikan().getFromValue() != null) {
            inputData.append(div.getTxtJushinKikan().getFromValue().toDateString());
        }
        if (div.getTxtJushinKikan().getToValue() != null) {
            inputData.append(div.getTxtJushinKikan().getToValue().toDateString());
        }
        inputData.append(div.getTxtJushinBasho().getValue());
        inputData.append(div.getRadTeishutsuKigen().getSelectedKey());
        if (div.getTxtKyotsuDay().getValue() != null) {
            inputData.append(div.getTxtKyotsuDay().getValue().toDateString());
        }
        return inputData.toRString();
    }

    private void setDisableToNinteiChosaChk() {
        LasdecCode 市町村コード = div.getCcdHokenshaList().getSelectedItem().get市町村コード();
        RDate 適用基準日 = RDate.getNowDate();
        RString 概況調査_用紙タイプ = DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況調査_用紙タイプ,
                適用基準日, SubGyomuCode.DBE認定支援, 市町村コード);
        List<RString> keyList = new ArrayList<>();
        List<RString> ocrKeyList = new ArrayList<>();
        if (CONFIGVALUE1.equals(概況調査_用紙タイプ)) {
            keyList.add(KEY0);
        } else {
            ocrKeyList.add(KEY0);
        }
        RString 基本調査_用紙タイプ = DbBusinessConfig.get(ConfigNameDBE.認定調査票_基本調査_用紙タイプ,
                適用基準日, SubGyomuCode.DBE認定支援, 市町村コード);
        if (CONFIGVALUE1.equals(基本調査_用紙タイプ)) {
            keyList.add(KEY1);
        } else {
            ocrKeyList.add(KEY1);
        }
        RString 特記事項_用紙タイプ = DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_用紙タイプ,
                適用基準日, SubGyomuCode.DBE認定支援, 市町村コード);
        if (CONFIGVALUE1.equals(特記事項_用紙タイプ)) {
            keyList.add(KEY2);
        } else {
            ocrKeyList.add(KEY2);
        }
        div.getChkChosahyo().setDisabledItemsByKey(keyList);
        div.getChkOcrChosahyo().setDisabledItemsByKey(ocrKeyList);
    }

    private void setDisableToShujiiIkenshoChk() {
        LasdecCode 市町村コード = div.getCcdHokenshaList().getSelectedItem().get市町村コード();
        RString 意見書用紙タイプ = DbBusinessConfig.get(ConfigNameDBE.意見書用紙タイプ,
                RDate.getNowDate(), SubGyomuCode.DBE認定支援, 市町村コード);

        if (CONFIGVALUE1.equals(意見書用紙タイプ)) {
            List<RString> keyList = new ArrayList<>();
            keyList.add(KEY0);
            div.getChkIkenshoSakuseiIchiran().setDisabledItemsByKey(keyList);
        } else {
            List<RString> keyList = new ArrayList<>();
            keyList.add(KEY1);
            div.getChkIkenshoSakuseiIchiran().setDisabledItemsByKey(keyList);
        }
    }

    private RString nullToEmpty(RString obj) {
        if (obj == null) {
            return RString.EMPTY;
        } else {
            return obj;
        }
    }

    /**
     * 認定調査依頼書印刷用パラメータを作成します。
     *
     * @return 認定調査依頼書印刷用パラメータ
     */
    public List<ChosaIraishoHeadItem> create認定調査依頼書印刷用パラメータ() {
        List<dgNinteiChosa_Row> selectedItems = div.getDgNinteiChosa().getSelectedItems();

        List<ChosaIraishoHeadItem> chosaIraishoHeadItemList = new ArrayList<>();
        RString タイトル = DbBusinessConfig.get(ConfigNameDBE.認定調査依頼書, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        for (dgNinteiChosa_Row row : selectedItems) {

            ChosaIraishoAndChosahyoAndIkenshoPrintParameter parameter
                    = ChosaIraishoAndChosahyoAndIkenshoPrintParameter.createParameter(row.getShinseishoKanriNo());

            List<ChosaIraishoAndChosahyoAndIkenshoPrintBusiness> list = ChosaIraishoAndChosahyoAndIkenshoPrintFinder.createInstance()
                    .get認定調査依頼書(parameter).records();
            if (!list.isEmpty()) {
                ChosaIraishoAndChosahyoAndIkenshoPrintBusiness business = list.get(0);
                List<RString> 被保険者番号リスト = get被保険者番号(business.get被保険者番号());
                RString 文書番号 = ReportUtil.get文書番号(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE220001.getReportId(), FlexibleDate.getNowDate());
                RString customerBarCode = RString.EMPTY;
                if (!RString.isNullOrEmpty(business.get調査委託先郵便番号()) && !RString.isNullOrEmpty(business.get調査委託先住所())) {
                    customerBarCode = ReportUtil.getCustomerBarCode(business.get調査委託先郵便番号(), business.get調査委託先住所());
                }
                Map<Integer, RString> 通知文
                        = ReportUtil.get通知文(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE220001.getReportId(), KamokuCode.EMPTY, 1);

                RString 誕生日明治 = HOUSI;
                RString 誕生日大正 = HOUSI;
                RString 誕生日昭和 = HOUSI;
                FlexibleDate seinengappiYMD = new FlexibleDate(business.get生年月日());
                RString era = seinengappiYMD.wareki().eraType(EraType.KANJI).getEra();
                if (元号_明治.equals(era)) {
                    誕生日明治 = RString.EMPTY;
                } else if (元号_大正.equals(era)) {
                    誕生日大正 = RString.EMPTY;
                } else if (元号_昭和.equals(era)) {
                    誕生日昭和 = RString.EMPTY;
                }
                RString seibetsu = business.get性別();
                RString 性別男 = RString.EMPTY;
                RString 性別女 = RString.EMPTY;

                if (Seibetsu.男.getコード().equals(seibetsu)) {
                    性別女 = HOUSI;
                } else {
                    性別男 = HOUSI;
                }
                RString 認定申請年月日 = RString.EMPTY;
                if (!RString.isNullOrEmpty(business.get認定申請年月日())) {
                    認定申請年月日 = new FlexibleDate(business.get認定申請年月日()).wareki()
                            .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                            separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
                }
                ChosaIraishoHeadItem item = new ChosaIraishoHeadItem(
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
                        business.get調査委託先郵便番号(),
                        business.get調査委託先住所(),
                        business.get事業者名称(),
                        business.get調査員氏名(),
                        get名称付与(),
                        customerBarCode,
                        business.get被保険者番号(),
                        タイトル,
                        通知文.get(1),
                        被保険者番号リスト.get(0),
                        被保険者番号リスト.get(1),
                        被保険者番号リスト.get(2),
                        被保険者番号リスト.get(INDEX_3),
                        被保険者番号リスト.get(INDEX_4),
                        被保険者番号リスト.get(INDEX_5),
                        被保険者番号リスト.get(INDEX_6),
                        被保険者番号リスト.get(INDEX_7),
                        被保険者番号リスト.get(INDEX_8),
                        被保険者番号リスト.get(INDEX_9),
                        business.get被保険者氏名カナ(),
                        誕生日明治,
                        誕生日大正,
                        誕生日昭和,
                        business.get生年月日(),
                        business.get被保険者氏名(),
                        性別男,
                        性別女,
                        new YubinNo(business.get郵便番号()).getEditedYubinNo(),
                        business.get住所(),
                        business.get電話番号(),
                        business.get訪問調査先郵便番号(),
                        business.get訪問調査先住所(),
                        business.get訪問調査先名称(),
                        business.get訪問調査先電話番号(),
                        認定申請年月日,
                        set認定調査提出期限(business),
                        通知文.get(2)
                );
                chosaIraishoHeadItemList.add(item);
            }
        }
        return chosaIraishoHeadItemList;
    }

    /**
     * 認定調査依頼一覧表印刷用パラメータを作成します。
     *
     * @return 認定調査依頼一覧表印刷用パラメータ
     */
    public List<ChosaIraiIchiranhyoBodyItem> create認定調査依頼一覧表印刷用パラメータ() {
        List<dgNinteiChosa_Row> selectedItems = div.getDgNinteiChosa().getSelectedItems();
        List<ShinseishoKanriNo> 申請書管理番号リスト = new ArrayList<>();
        for (dgNinteiChosa_Row row : selectedItems) {
            申請書管理番号リスト.add(new ShinseishoKanriNo(row.getShinseishoKanriNo()));
        }
        ChosaIraishoAndChosahyoAndIkenshoPrintParameter parameter
                = ChosaIraishoAndChosahyoAndIkenshoPrintParameter.createParameter(申請書管理番号リスト, RString.EMPTY);

        List<ChosaIraishoAndChosahyoAndIkenshoPrintBusiness> list = ChosaIraishoAndChosahyoAndIkenshoPrintFinder.createInstance()
                .get認定調査依頼一覧表(parameter).records();
        List<ChosaIraiIchiranhyoBodyItem> chosaIraishoHeadItemList = new ArrayList<>();
        int 連番 = 1;
        Map<Integer, RString> 通知文
                = ReportUtil.get通知文(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE220002.getReportId(), KamokuCode.EMPTY, 1);
        for (ChosaIraishoAndChosahyoAndIkenshoPrintBusiness business : list) {
            RString 認定申請区分 = business.get認定申請区分_申請時_コード();
            if (!RString.isNullOrEmpty(認定申請区分)) {
                認定申請区分 = NinteiShinseiShinseijiKubunCode.toValue(認定申請区分).get名称();
            }
            ChosaIraiIchiranhyoBodyItem item = new ChosaIraiIchiranhyoBodyItem(
                    RString.EMPTY,
                    RString.EMPTY,
                    RString.EMPTY,
                    RString.EMPTY,
                    RString.EMPTY,
                    RString.EMPTY,
                    RString.EMPTY,
                    RString.EMPTY,
                    RString.EMPTY,
                    business.get調査委託先郵便番号(),
                    business.get調査委託先住所(),
                    business.get事業者名称(),
                    business.get調査員氏名(),
                    get名称付与(),
                    business.get事業者番号(),
                    通知文.get(1),
                    通知文.get(2),
                    new RString(連番++),
                    business.get調査員氏名(),
                    business.get被保険者番号(),
                    business.get認定申請年月日(),
                    認定申請区分,
                    business.get被保険者氏名(),
                    business.get被保険者氏名カナ(),
                    Seibetsu.toValue(business.get性別()).get名称(),
                    business.get生年月日(),
                    business.get住所(),
                    business.get電話番号(),
                    set認定調査提出期限(business)
            );
            chosaIraishoHeadItemList.add(item);
        }
        return chosaIraishoHeadItemList;
    }

    /**
     * 認定調査票_概況調査印刷用パラメータを作成します。
     *
     * @return 認定調査票_概況調査パラメータ
     */
    public List<ChosahyoGaikyochosaItem> create認定調査票_概況調査パラメータ() {

        List<dgNinteiChosa_Row> selectedItems = div.getDgNinteiChosa().getSelectedItems();

        List<ChosahyoGaikyochosaItem> itemList = new ArrayList<>();
        for (dgNinteiChosa_Row row : selectedItems) {

            ChosaIraishoAndChosahyoAndIkenshoPrintParameter parameter
                    = ChosaIraishoAndChosahyoAndIkenshoPrintParameter.createParameter(row.getShinseishoKanriNo());

            List<ChosaIraishoAndChosahyoAndIkenshoPrintBusiness> list = ChosaIraishoAndChosahyoAndIkenshoPrintFinder.createInstance()
                    .get認定調査票_概況調査(parameter).records();
            for (ChosaIraishoAndChosahyoAndIkenshoPrintBusiness business : list) {
                RString ninteiShinseiDay = new FlexibleDate(business.get認定申請年月日()).wareki().eraType(EraType.ALPHABET).firstYear(FirstYear.ICHI_NEN)
                        .separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
                List<RString> 保険者番号リスト = get被保険者番号(business.get保険者番号());
                List<RString> 被保険者番号リスト = get被保険者番号(business.get被保険者番号());
                List<RString> 認定調査員コードリスト = get認定調査員コード(business.get認定調査員コード());
                List<RString> 認定調査委託先コードリスト = get認定調査委託先コード(business.get認定調査委託先コード());
                RString 生年月日 = business.get生年月日();
                RString 年号 = new FlexibleDate(生年月日).wareki().eraType(EraType.KANJI).toDateString();
                RString 前回認定年月日 = business.get前回認定年月日();
                RString 前回要介護状態区分コード = business.get前回要介護状態区分コード();
                RString 要支援 = RString.EMPTY;
                if (YOKAIGOJOTAIKUBUN12.equals(前回要介護状態区分コード)
                        || YOKAIGOJOTAIKUBUN13.equals(前回要介護状態区分コード)) {
                    要支援 = 記号;
                }
                ChosahyoGaikyochosaItem item = new ChosahyoGaikyochosaItem(
                        保険者番号リスト.get(0),
                        保険者番号リスト.get(1),
                        保険者番号リスト.get(2),
                        保険者番号リスト.get(INDEX_3),
                        保険者番号リスト.get(INDEX_4),
                        保険者番号リスト.get(INDEX_5),
                        ninteiShinseiDay.substring(1, 2),
                        ninteiShinseiDay.substring(2, INDEX_3),
                        ninteiShinseiDay.substring(INDEX_4, INDEX_5),
                        ninteiShinseiDay.substring(INDEX_5, INDEX_6),
                        ninteiShinseiDay.substring(INDEX_7, INDEX_8),
                        ninteiShinseiDay.substring(INDEX_8),
                        被保険者番号リスト.get(0),
                        被保険者番号リスト.get(1),
                        被保険者番号リスト.get(2),
                        被保険者番号リスト.get(INDEX_3),
                        被保険者番号リスト.get(INDEX_4),
                        被保険者番号リスト.get(INDEX_5),
                        被保険者番号リスト.get(INDEX_6),
                        被保険者番号リスト.get(INDEX_7),
                        被保険者番号リスト.get(INDEX_8),
                        被保険者番号リスト.get(INDEX_9),
                        認定調査員コードリスト.get(0),
                        認定調査員コードリスト.get(1),
                        認定調査員コードリスト.get(2),
                        認定調査員コードリスト.get(INDEX_3),
                        認定調査員コードリスト.get(INDEX_4),
                        認定調査員コードリスト.get(INDEX_5),
                        認定調査員コードリスト.get(INDEX_6),
                        認定調査員コードリスト.get(INDEX_7),
                        business.get調査員氏名(),
                        認定調査委託先コードリスト.get(0),
                        認定調査委託先コードリスト.get(1),
                        認定調査委託先コードリスト.get(2),
                        認定調査委託先コードリスト.get(INDEX_3),
                        認定調査委託先コードリスト.get(INDEX_4),
                        認定調査委託先コードリスト.get(INDEX_5),
                        認定調査委託先コードリスト.get(INDEX_6),
                        認定調査委託先コードリスト.get(INDEX_7),
                        認定調査委託先コードリスト.get(INDEX_8),
                        認定調査委託先コードリスト.get(INDEX_9),
                        認定調査委託先コードリスト.get(INDEX_10),
                        認定調査委託先コードリスト.get(INDEX_11),
                        business.get事業者名称(),
                        business.get被保険者氏名カナ(),
                        business.get被保険者氏名(),
                        Seibetsu.男.get名称().equals(row.getSeibetsu()) ? 記号 : RString.EMPTY,
                        Seibetsu.女.get名称().equals(row.getSeibetsu()) ? 記号 : RString.EMPTY,
                        business.get住所(),
                        business.get郵便番号(),
                        business.get電話番号(),
                        年号.startsWith(元号_明治) ? 記号 : RString.EMPTY,
                        年号.startsWith(元号_大正) ? 記号 : RString.EMPTY,
                        年号.startsWith(元号_昭和) ? 記号 : RString.EMPTY,
                        年号.substring(2, INDEX_4),
                        年号.substring(INDEX_5, INDEX_7),
                        年号.substring(INDEX_8),
                        business.get年齢(),
                        business.get連絡先住所(),
                        business.get連絡先郵便番号(),
                        business.get連絡先電話番号(),
                        business.get連絡先携帯番号(),
                        business.get連絡先氏名(),
                        business.get連絡先続柄(),
                        RString.isNullOrEmpty(前回認定年月日) ? 記号 : RString.EMPTY,
                        !RString.isNullOrEmpty(前回認定年月日) ? 記号 : RString.EMPTY,
                        !RString.isNullOrEmpty(前回認定年月日) ? 前回認定年月日.substring(0, INDEX_4) : RString.EMPTY,
                        !RString.isNullOrEmpty(前回認定年月日) ? 前回認定年月日.substring(INDEX_4, INDEX_6) : RString.EMPTY,
                        !RString.isNullOrEmpty(前回認定年月日) ? 前回認定年月日.substring(INDEX_6, INDEX_8) : RString.EMPTY,
                        YOKAIGOJOTAIKUBUN01.equals(前回要介護状態区分コード) ? 記号 : RString.EMPTY,
                        要支援,
                        get要支援詳細(前回要介護状態区分コード),
                        get要介護(前回要介護状態区分コード),
                        get要介護詳細(前回要介護状態区分コード));
                itemList.add(item);
            }
        }
        return itemList;
    }

    /**
     * 認定調査票_基本調査印刷用パラメータを作成します。
     *
     * @return 認定調査票_基本調査パラメータ
     */
    public List<ChosahyoKihonchosaKatamenItem> create認定調査票_基本調査パラメータ() {
        List<ChosahyoKihonchosaKatamenItem> itemList = new ArrayList<>();
        List<dgNinteiChosa_Row> selectedItems = div.getDgNinteiChosa().getSelectedItems();

        for (dgNinteiChosa_Row row : selectedItems) {
            NinteiShinseiJoho2 ninteiShinseiJoho = NinteiShinseiJohoManager.createInstance().get要介護認定申請情報(new ShinseishoKanriNo(row.getShinseishoKanriNo()));
            if (ninteiShinseiJoho != null) {
                RString ninteiShinseiDay = ninteiShinseiJoho.get認定申請年月日().wareki().eraType(EraType.ALPHABET).firstYear(FirstYear.ICHI_NEN)
                        .separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
                List<RString> 証記載保険者番号リスト = get被保険者番号(ninteiShinseiJoho.get証記載保険者番号());
                List<RString> 被保険者番号リスト = get被保険者番号(ninteiShinseiJoho.get被保険者番号());
                ChosahyoKihonchosaKatamenItem item = new ChosahyoKihonchosaKatamenItem(
                        ninteiShinseiDay.substring(1, 2),
                        ninteiShinseiDay.substring(2, INDEX_3),
                        ninteiShinseiDay.substring(INDEX_4, INDEX_5),
                        ninteiShinseiDay.substring(INDEX_5, INDEX_6),
                        ninteiShinseiDay.substring(INDEX_7, INDEX_8),
                        ninteiShinseiDay.substring(INDEX_8),
                        証記載保険者番号リスト.get(0),
                        証記載保険者番号リスト.get(1),
                        証記載保険者番号リスト.get(2),
                        証記載保険者番号リスト.get(INDEX_3),
                        証記載保険者番号リスト.get(INDEX_4),
                        証記載保険者番号リスト.get(INDEX_5),
                        被保険者番号リスト.get(0),
                        被保険者番号リスト.get(1),
                        被保険者番号リスト.get(2),
                        被保険者番号リスト.get(INDEX_3),
                        被保険者番号リスト.get(INDEX_4),
                        被保険者番号リスト.get(INDEX_5),
                        被保険者番号リスト.get(INDEX_6),
                        被保険者番号リスト.get(INDEX_7),
                        被保険者番号リスト.get(INDEX_8),
                        被保険者番号リスト.get(INDEX_9));
                itemList.add(item);
            }
        }
        return itemList;
    }

    /**
     * 認定調査票_特記事項印刷用パラメータを作成します。
     *
     * @return 認定調査票_特記事項パラメータ
     */
    public List<ChosahyoTokkijikoBusiness> create認定調査票_特記事項パラメータ() {
        List<ChosahyoTokkijikoBusiness> itemList = new ArrayList<>();
        List<dgNinteiChosa_Row> selectedItems = div.getDgNinteiChosa().getSelectedItems();

        for (dgNinteiChosa_Row row : selectedItems) {
            NinteiShinseiJoho2 ninteiShinseiJoho = NinteiShinseiJohoManager.createInstance().get要介護認定申請情報(new ShinseishoKanriNo(row.getShinseishoKanriNo()));
            if (ninteiShinseiJoho != null) {
                RString ninteiShinseiDay = ninteiShinseiJoho.get認定申請年月日().wareki().eraType(EraType.ALPHABET).firstYear(FirstYear.ICHI_NEN)
                        .separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
                List<RString> 証記載保険者番号リスト = get被保険者番号(ninteiShinseiJoho.get証記載保険者番号());
                List<RString> 被保険者番号リスト = get被保険者番号(ninteiShinseiJoho.get被保険者番号());
                ChosahyoTokkijikoBusiness item = new ChosahyoTokkijikoBusiness(
                        証記載保険者番号リスト.get(INDEX_3),
                        ninteiShinseiDay.substring(1, 2),
                        ninteiShinseiDay.substring(2, INDEX_3),
                        ninteiShinseiDay.substring(INDEX_4, INDEX_5),
                        ninteiShinseiDay.substring(INDEX_5, INDEX_6),
                        ninteiShinseiDay.substring(INDEX_7, INDEX_8),
                        ninteiShinseiDay.substring(INDEX_8),
                        証記載保険者番号リスト.get(0),
                        証記載保険者番号リスト.get(1),
                        証記載保険者番号リスト.get(2),
                        証記載保険者番号リスト.get(INDEX_4),
                        証記載保険者番号リスト.get(INDEX_5),
                        被保険者番号リスト.get(0),
                        被保険者番号リスト.get(2),
                        被保険者番号リスト.get(INDEX_3),
                        被保険者番号リスト.get(INDEX_4),
                        被保険者番号リスト.get(INDEX_5),
                        被保険者番号リスト.get(INDEX_6),
                        被保険者番号リスト.get(INDEX_7),
                        被保険者番号リスト.get(INDEX_8),
                        被保険者番号リスト.get(INDEX_9),
                        被保険者番号リスト.get(1),
                        ninteiShinseiJoho.get被保険者氏名() == null ? RString.EMPTY : ninteiShinseiJoho.get被保険者氏名().value());
                itemList.add(item);
            }
        }
        return itemList;
    }

    /**
     * 認定調査票_特記事項_フリー様式印刷用パラメータを作成します。
     *
     * @return 認定調査票_特記事項_フリー様式パラメータ
     */
    public List<ChosahyoTokkijikoBusiness> create認定調査票_特記事項_フリー様式パラメータ() {
        List<ChosahyoTokkijikoBusiness> itemList = new ArrayList<>();
        List<dgNinteiChosa_Row> selectedItems = div.getDgNinteiChosa().getSelectedItems();

        for (dgNinteiChosa_Row row : selectedItems) {
            NinteiShinseiJoho2 ninteiShinseiJoho = NinteiShinseiJohoManager.createInstance().get要介護認定申請情報(new ShinseishoKanriNo(row.getShinseishoKanriNo()));
            if (ninteiShinseiJoho != null) {
                RString ninteiShinseiDay = ninteiShinseiJoho.get認定申請年月日().wareki().eraType(EraType.ALPHABET).firstYear(FirstYear.ICHI_NEN)
                        .separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
                List<RString> 保険者番号リスト = get被保険者番号(ninteiShinseiJoho.get証記載保険者番号());
                List<RString> 被保険者番号リスト = get被保険者番号(ninteiShinseiJoho.get被保険者番号());
                ChosahyoTokkijikoBusiness item = new ChosahyoTokkijikoBusiness(
                        保険者番号リスト.get(INDEX_3),
                        ninteiShinseiDay.substring(1, 2),
                        ninteiShinseiDay.substring(2, INDEX_3),
                        ninteiShinseiDay.substring(INDEX_4, INDEX_5),
                        ninteiShinseiDay.substring(INDEX_5, INDEX_6),
                        ninteiShinseiDay.substring(INDEX_7, INDEX_8),
                        ninteiShinseiDay.substring(INDEX_8),
                        保険者番号リスト.get(0),
                        保険者番号リスト.get(1),
                        保険者番号リスト.get(2),
                        保険者番号リスト.get(INDEX_4),
                        保険者番号リスト.get(INDEX_5),
                        被保険者番号リスト.get(0),
                        被保険者番号リスト.get(2),
                        被保険者番号リスト.get(INDEX_3),
                        被保険者番号リスト.get(INDEX_4),
                        被保険者番号リスト.get(INDEX_5),
                        被保険者番号リスト.get(INDEX_6),
                        被保険者番号リスト.get(INDEX_7),
                        被保険者番号リスト.get(INDEX_8),
                        被保険者番号リスト.get(INDEX_9),
                        被保険者番号リスト.get(1),
                        ninteiShinseiJoho.get被保険者氏名() == null ? RString.EMPTY : ninteiShinseiJoho.get被保険者氏名().value());
                itemList.add(item);
            }
        }
        return itemList;
    }

    /**
     * 要介護認定調査票差異チェック票印刷用パラメータを作成します。
     *
     * @return 要介護認定調査票差異チェック票パラメータ
     */
    public List<SaiChekkuhyoItem> create調査票差異チェック票_DBE292004パラメータ() {
        List<SaiChekkuhyoItem> itemList = new ArrayList<>();
        List<dgNinteiChosa_Row> selectedItems = div.getDgNinteiChosa().getSelectedItems();
        Map<RString, RString> 前回連番Map = new HashMap();
        for (dgNinteiChosa_Row row : selectedItems) {
            ChosaIraishoAndChosahyoAndIkenshoPrintParameter parameter
                    = ChosaIraishoAndChosahyoAndIkenshoPrintParameter.createParameter(row.getShinseishoKanriNo());

            List<ChosaIraishoAndChosahyoAndIkenshoPrintBusiness> businessList = ChosaIraishoAndChosahyoAndIkenshoPrintFinder.createInstance()
                    .get認定調査票差異チェック票(parameter).records();
            for (ChosaIraishoAndChosahyoAndIkenshoPrintBusiness business : businessList) {
                前回連番Map.put(business.get連番(), business.get調査項目());
            }
            if (!businessList.isEmpty()) {
                ChosaIraishoAndChosahyoAndIkenshoPrintBusiness business = businessList.get(0);
                itemList.add(new SaiChekkuhyoItem(
                        get判定結果(business.get厚労省IF識別コード(), business.get要介護認定一次判定結果コード()),
                        business.get被保険者番号(),
                        business.get被保険者氏名(),
                        business.get年齢(),
                        get判定結果(business.get厚労省IF識別コード(), business.get二次判定要介護状態区分コード()),
                        business.get二次判定年月日(),
                        business.get生年月日(),
                        前回連番Map.get(NinteichosaKomokuMapping09B.麻痺等_左上肢.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.麻痺等_右上肢.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.麻痺等_左下肢.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.麻痺等_右下肢.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.麻痺等_その他.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.拘縮_肩関節.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.拘縮_股関節.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.拘縮_膝関節.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.拘縮_その他.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.寝返り.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.起き上がり.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.座位保持.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.両足での立位.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.歩行.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.立ち上がり.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.片足での立位.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.洗身.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.つめ切り.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.視力.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.聴力.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.移乗.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.移動.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.えん下.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.食事摂取.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.排尿.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.排便.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.口腔清潔.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.洗顔.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.整髪.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.上衣の着脱.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.ズボン等の着脱.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.外出頻度.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.意思の伝達.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.毎日の日課を理解.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.生年月日をいう.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.短期記憶.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.自分の名前をいう.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.今の季節を理解.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.場所の理解.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.常時の徘徊.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.外出して戻れない.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.被害的.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.作話.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.感情が不安定.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.昼夜逆転.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.同じ話をする.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.大声を出す.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.介護に抵抗.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.落ち着きなし.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.一人で出たがる.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.収集癖.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.物や衣類を壊す.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.ひどい物忘れ.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.独り言_独り笑い.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.自分勝手に行動する.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.話がまとまらない.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.薬の内服.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.金銭の管理.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.日常の意思決定.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.集団への不適応.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.買い物.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.簡単な調理.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.点滴の管理.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.中心静脈栄養.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.透析.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.ストーマの処置.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.酸素療法.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.レスピレーター.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.気管切開の処置.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.疼痛の看護.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.経管栄養.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.モニター測定.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.じょくそうの処置.getコード()),
                        前回連番Map.get(NinteichosaKomokuMapping09B.カテーテル.getコード()),
                        NinchishoNichijoSeikatsuJiritsudoCode.toValue(business.get認知症高齢者自立度コード()).get名称(),
                        ShogaiNichijoSeikatsuJiritsudoCode.toValue(business.get障害高齢者自立度コード()).get名称()
                ));
            }
        }
        return itemList;
    }

    /**
     * 意見書作成依頼書印刷用パラメータを作成します。
     *
     * @return 意見書作成依頼書パラメータ
     */
    public List<ShujiiIkenshoSakuseiIraishoItem> create意見書作成依頼書_パラメータ() {
        List<ShujiiIkenshoSakuseiIraishoItem> itemList = new ArrayList<>();
        List<dgShujiiIkensho_Row> selectedItems = div.getDgShujiiIkensho().getSelectedItems();
        int 宛名連番 = 1;
        int 連番 = 1;
        for (dgShujiiIkensho_Row row : selectedItems) {
            ChosaIraishoAndChosahyoAndIkenshoPrintParameter parameter
                    = ChosaIraishoAndChosahyoAndIkenshoPrintParameter.createParameter(row.getShinseishoKanriNo());

            List<ChosaIraishoAndChosahyoAndIkenshoPrintBusiness> businessList = ChosaIraishoAndChosahyoAndIkenshoPrintFinder.createInstance()
                    .get意見書作成依頼書(parameter).records();
            if (!businessList.isEmpty()) {
                ChosaIraishoAndChosahyoAndIkenshoPrintBusiness business = businessList.get(0);
                ShujiiIkenshoSakuseiIraishoItem item = new ShujiiIkenshoSakuseiIraishoItem();
                item.setBunshoNo(ReportUtil.get文書番号(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE230001.getReportId(), FlexibleDate.getNowDate()));
                item.setYubinNo1(business.get医療機関郵便番号());
                item.setJushoText(business.get医療機関住所());
                item.setKikanNameText(business.get医療機関名称());
                item.setShimeiText(business.get主治医氏名());
                RString key = DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成依頼書_宛先敬称, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
                if (ChohyoAtesakiKeisho.なし.getコード().equals(key)) {
                    item.setMeishoFuyo(RString.EMPTY);
                }
                if (ChohyoAtesakiKeisho.様.getコード().equals(key)) {
                    item.setMeishoFuyo(ChohyoAtesakiKeisho.様.get名称());
                }
                if (ChohyoAtesakiKeisho.殿.getコード().equals(key)) {
                    item.setMeishoFuyo(ChohyoAtesakiKeisho.殿.get名称());
                }
                if (!RString.isNullOrEmpty(business.get調査委託先郵便番号()) && !RString.isNullOrEmpty(business.get調査委託先住所())) {
                    item.setCustomerBarCode(ReportUtil.getCustomerBarCode(business.get調査委託先郵便番号(), business.get調査委託先住所()));
                } else {
                    item.setCustomerBarCode(RString.EMPTY);
                }

                item.setSonota(business.get被保険者番号());
                RStringBuilder builder = new RStringBuilder();
                builder.append("*");
                builder.append((new RString(String.valueOf(宛名連番++))).padZeroToLeft(INDEX_6));
                builder.append("#");
                item.setAtenaRenban(builder.toRString());
                item.setRemban(new RString(String.valueOf(連番++)));
                item.setTitle(ReportIdDBE.DBE230001.getReportName());
                Map<Integer, RString> 通知文Map
                        = ReportUtil.get通知文(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE230001.getReportId(), KamokuCode.EMPTY, 1);
                item.setTsuchibun1(通知文Map.get(1));
                item.setShinseiKubun(NinteiShinseiShinseijiKubunCode.toValue(business.get認定申請区分_申請時_コード()).get名称());

                List<RString> 被保険者番号リスト = get被保険者番号(business.get被保険者番号());
                item.setHihokenshaNo1(被保険者番号リスト.get(0));
                item.setHihokenshaNo2(被保険者番号リスト.get(1));
                item.setHihokenshaNo3(被保険者番号リスト.get(2));
                item.setHihokenshaNo4(被保険者番号リスト.get(INDEX_3));
                item.setHihokenshaNo5(被保険者番号リスト.get(INDEX_4));
                item.setHihokenshaNo6(被保険者番号リスト.get(INDEX_5));
                item.setHihokenshaNo7(被保険者番号リスト.get(INDEX_6));
                item.setHihokenshaNo8(被保険者番号リスト.get(INDEX_7));
                item.setHihokenshaNo9(被保険者番号リスト.get(INDEX_8));
                item.setHihokenshaNo10(被保険者番号リスト.get(INDEX_9));
                List<RString> 保険者番号リスト = get被保険者番号(business.get証記載保険者番号());
                item.setHokenshaNo1(保険者番号リスト.get(0));
                item.setHokenshaNo2(保険者番号リスト.get(1));
                item.setHokenshaNo3(保険者番号リスト.get(2));
                item.setHokenshaNo4(保険者番号リスト.get(INDEX_3));
                item.setHokenshaNo5(保険者番号リスト.get(INDEX_4));
                item.setHokenshaNo6(保険者番号リスト.get(INDEX_5));
                item.setHihokenshaNameKana(business.get被保険者氏名カナ());
                if (Seibetsu.男.getコード().equals(business.get性別())) {
                    item.setSeibetsuWoman(HOUSI);
                }
                if (Seibetsu.女.getコード().equals(business.get性別())) {
                    item.setSeibetsuMan(HOUSI);
                }
                item.setHihokenshaName(business.get被保険者氏名());
                RString 生年月日 = business.get生年月日();
                get年号(new FlexibleDate(生年月日), item);
                item.setBirthYMD(get和暦(生年月日, false));
                RString 郵便番号 = business.get郵便番号();
                if (!RString.isNullOrEmpty(郵便番号)) {
                    item.setYubinNo(new YubinNo(郵便番号).getEditedYubinNo());
                }
                item.setJusho(business.get住所());
                item.setShinseiYMD(get和暦(business.get認定申請年月日(), true));
                RString 提出期限 = set意見書作成提出期限(business);
                if (!RString.isNullOrEmpty(提出期限)) {
                    item.setTeishutsuKigen(new FlexibleDate(提出期限).wareki()
                            .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                            separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
                }
                item.setTsuchibun2(通知文Map.get(2));
                item.setShoriName(IkenshoIraiKubun.toValue(business.get主治医意見書依頼区分()).get名称());
                itemList.add(item);
            }
        }
        return itemList;
    }

    /**
     * 意見書作成依頼一覧表印刷用パラメータを作成します。
     *
     * @return 意見書作成依頼書パラメータ
     */
    public List<IkenshoSakuseiIraiIchiranhyoItem> create意見書作成依頼一覧表_パラメータ() {
        List<IkenshoSakuseiIraiIchiranhyoItem> itemList = new ArrayList<>();
        List<dgShujiiIkensho_Row> selectedItems = div.getDgShujiiIkensho().getSelectedItems();
        List<ShinseishoKanriNo> 申請書管理番号リスト = new ArrayList<>();
        for (dgShujiiIkensho_Row row : selectedItems) {
            申請書管理番号リスト.add(new ShinseishoKanriNo(row.getShinseishoKanriNo()));
        }
        ChosaIraishoAndChosahyoAndIkenshoPrintParameter parameter
                = ChosaIraishoAndChosahyoAndIkenshoPrintParameter.createParameter(申請書管理番号リスト, RString.EMPTY);

        List<ChosaIraishoAndChosahyoAndIkenshoPrintBusiness> businessList = ChosaIraishoAndChosahyoAndIkenshoPrintFinder.createInstance()
                .get意見書作成依頼一覧表(parameter).records();
        for (ChosaIraishoAndChosahyoAndIkenshoPrintBusiness business : businessList) {

            Map<Integer, RString> 通知文Map
                    = ReportUtil.get通知文(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE230002.getReportId(), KamokuCode.EMPTY, 1);
            RString 生年月日 = new FlexibleDate(business.get生年月日()).wareki()
                    .eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                    separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
            RString 意見書作成提出期限 = set意見書作成提出期限(business);
            RString 提出期限 = RString.EMPTY;
            if (!RString.isNullOrEmpty(意見書作成提出期限)) {
                提出期限 = new FlexibleDate(意見書作成提出期限).wareki()
                        .eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                        separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
            }
            IkenshoSakuseiIraiIchiranhyoItem item = new IkenshoSakuseiIraiIchiranhyoItem(
                    RString.EMPTY,
                    RString.EMPTY,
                    RString.EMPTY,
                    RString.EMPTY,
                    RString.EMPTY,
                    RString.EMPTY,
                    RString.EMPTY,
                    RString.EMPTY,
                    RString.EMPTY,
                    business.get医療機関郵便番号(),
                    business.get医療機関住所(),
                    business.get医療機関名称(),
                    business.get代表者名(),
                    get名称付与(),
                    get印刷日時(),
                    通知文Map.get(1),
                    business.get主治医氏名(),
                    business.get被保険者番号(),
                    business.get被保険者氏名(),
                    business.get被保険者氏名カナ(),
                    business.get住所(),
                    生年月日,
                    Seibetsu.toValue(business.get性別()).get名称(),
                    提出期限);
            itemList.add(item);
        }
        return itemList;
    }

    /**
     * 主治医意見書作成料請求書印刷用パラメータを作成します。
     *
     * @return 主治医意見書作成料請求書パラメータ
     */
    public List<ShujiiIkenshoSakuseiRyoSeikyushoItem> create主治医意見書作成料請求書_パラメータ() {
        List<ShujiiIkenshoSakuseiRyoSeikyushoItem> itemList = new ArrayList<>();
        List<dgShujiiIkensho_Row> selectedItems = div.getDgShujiiIkensho().getSelectedItems();
        for (dgShujiiIkensho_Row row : selectedItems) {
            ChosaIraishoAndChosahyoAndIkenshoPrintParameter parameter
                    = ChosaIraishoAndChosahyoAndIkenshoPrintParameter.createParameter(row.getShinseishoKanriNo());

            List<ChosaIraishoAndChosahyoAndIkenshoPrintBusiness> businessList = ChosaIraishoAndChosahyoAndIkenshoPrintFinder.createInstance()
                    .get主治医意見書作成料請求書(parameter).records();
            if (!businessList.isEmpty()) {
                ChosaIraishoAndChosahyoAndIkenshoPrintBusiness business = businessList.get(0);
                ShujiiIkenshoSakuseiRyoSeikyushoItem item = new ShujiiIkenshoSakuseiRyoSeikyushoItem();
                item.setGengo(RDate.getNowDate().toDateString());
                item.setAtesakiHokenshaName(business.get保険者名());
                item.setShinkiZaitakuKingaku(IkenshoSakuseiRyo.toValue(IKENSHOSAKUSEIRYO_11).get名称());
                item.setShinkiShisetsuKingaku(IkenshoSakuseiRyo.toValue(IKENSHOSAKUSEIRYO_12).get名称());
                item.setKeizokuZaitakuKingaku(IkenshoSakuseiRyo.toValue(IKENSHOSAKUSEIRYO_21).get名称());
                item.setKeizokuShisetsuKingaku(IkenshoSakuseiRyo.toValue(IKENSHOSAKUSEIRYO_22).get名称());
                List<RString> 保険者番号リスト = get被保険者番号(business.get被保険者番号());
                item.setHihokenshaNo1(保険者番号リスト.get(0));
                item.setHihokenshaNo2(保険者番号リスト.get(1));
                item.setHihokenshaNo3(保険者番号リスト.get(2));
                item.setHihokenshaNo4(保険者番号リスト.get(INDEX_3));
                item.setHihokenshaNo5(保険者番号リスト.get(INDEX_4));
                item.setHihokenshaNo6(保険者番号リスト.get(INDEX_5));
                item.setHihokenshaNo7(保険者番号リスト.get(INDEX_6));
                item.setHihokenshaNo8(保険者番号リスト.get(INDEX_7));
                item.setHihokenshaNo9(保険者番号リスト.get(INDEX_8));
                item.setHihokenshaNo10(保険者番号リスト.get(INDEX_9));
                item.setHihokenshaNameKana(business.get被保険者氏名カナ());
                item.setHihokenshaName(business.get被保険者氏名());
                item.setBirthYMD(business.get生年月日());
                item.setSeibetsu(Seibetsu.toValue(business.get性別()).get名称());
                if (ZaitakuShisetsuKubun.在宅.getコード().equals(business.get在宅施設区分())) {
                    item.setShubetsuZaitaku(記号);
                } else {
                    item.setShubetsuZaitaku(RString.EMPTY);
                }
                if (ZaitakuShisetsuKubun.施設.getコード().equals(business.get在宅施設区分())) {
                    item.setShubetsuShisetsu(記号);
                } else {
                    item.setShubetsuShisetsu(RString.EMPTY);
                }
                if (IkenshoSakuseiKaisuKubun.初回.getコード().equals(business.get意見書作成回数区分())) {
                    item.setShubetsuShinki(記号);
                } else {
                    item.setShubetsuShinki(RString.EMPTY);
                }
                if (IkenshoSakuseiKaisuKubun._2回目以降.getコード().equals(business.get意見書作成回数区分())) {
                    item.setShubetsuKeizoku(記号);
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
            }
        }
        return itemList;
    }

    /**
     * 主治医意見書記入情報1印刷用パラメータを作成します。
     *
     * @return 主治医意見書記入情報1
     */
    public List<IkenshokinyuyoshiBusiness> create主治医意見書記入情報1_パラメータ() {
        List<IkenshokinyuyoshiBusiness> itemList = new ArrayList<>();
        List<dgShujiiIkensho_Row> selectedItems = div.getDgShujiiIkensho().getSelectedItems();

        for (dgShujiiIkensho_Row row : selectedItems) {
            ChosaIraishoAndChosahyoAndIkenshoPrintParameter parameter
                    = ChosaIraishoAndChosahyoAndIkenshoPrintParameter.createParameter(row.getShinseishoKanriNo());

            List<ChosaIraishoAndChosahyoAndIkenshoPrintBusiness> businessList = ChosaIraishoAndChosahyoAndIkenshoPrintFinder.createInstance()
                    .get主治医意見書記入用紙(parameter).records();
            if (!businessList.isEmpty()) {
                ChosaIraishoAndChosahyoAndIkenshoPrintBusiness business = businessList.get(0);
                List<RString> 保険者番号リスト = get被保険者番号(business.get保険者番号());
                List<RString> 被保険者番号リスト = get被保険者番号(business.get被保険者番号());
                RString 生年月日 = business.get生年月日();
                RString 年号 = new FlexibleDate(生年月日).wareki().eraType(EraType.KANJI).toDateString();
                IkenshokinyuyoshiBusiness item = new IkenshokinyuyoshiBusiness();
                item.setHokenshaNo1(保険者番号リスト.get(0));
                item.setHokenshaNo2(保険者番号リスト.get(1));
                item.setHokenshaNo3(保険者番号リスト.get(2));
                item.setHokenshaNo4(保険者番号リスト.get(INDEX_3));
                item.setHokenshaNo5(保険者番号リスト.get(INDEX_4));
                item.setHokenshaNo6(保険者番号リスト.get(INDEX_5));
                item.setHihokenshaNo1(被保険者番号リスト.get(0));
                item.setHihokenshaNo2(被保険者番号リスト.get(1));
                item.setHihokenshaNo3(被保険者番号リスト.get(2));
                item.setHihokenshaNo4(被保険者番号リスト.get(INDEX_3));
                item.setHihokenshaNo5(被保険者番号リスト.get(INDEX_4));
                item.setHihokenshaNo6(被保険者番号リスト.get(INDEX_5));
                item.setHihokenshaNo7(被保険者番号リスト.get(INDEX_6));
                item.setHihokenshaNo8(被保険者番号リスト.get(INDEX_7));
                item.setHihokenshaNo9(被保険者番号リスト.get(INDEX_8));
                item.setHihokenshaNo10(被保険者番号リスト.get(INDEX_9));
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
                item.setBirthYY(年号.substring(2, INDEX_4));
                item.setBirthMM(年号.substring(INDEX_5, INDEX_7));
                item.setBirthDD(年号.substring(INDEX_8));
                RString ninteiShinseiDay = new FlexibleDate(business.get認定申請年月日()).wareki().eraType(EraType.ALPHABET).firstYear(FirstYear.ICHI_NEN)
                        .separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
                item.setShinseiYY1(ninteiShinseiDay.substring(1, 2));
                item.setShinseiYY2(ninteiShinseiDay.substring(2, INDEX_3));
                item.setShinseiMM1(ninteiShinseiDay.substring(INDEX_4, INDEX_5));
                item.setShinseiMM2(ninteiShinseiDay.substring(INDEX_5, INDEX_6));
                item.setShinseiDD1(ninteiShinseiDay.substring(INDEX_7, INDEX_8));
                item.setShinseiDD2(ninteiShinseiDay.substring(INDEX_8));
                item.setSeibetsuMan(Seibetsu.男.get名称().equals(row.getSeibetsu()) ? RString.EMPTY : HOUSI);
                item.setSeibetsuWoman(Seibetsu.女.get名称().equals(row.getSeibetsu()) ? RString.EMPTY : HOUSI);
                item.setBirthGengoMeiji(年号.startsWith(元号_明治) ? RString.EMPTY : HOUSI);
                item.setBirthGengoTaisho(年号.startsWith(元号_大正) ? RString.EMPTY : HOUSI);
                item.setBirthGengoShowa(年号.startsWith(元号_昭和) ? RString.EMPTY : HOUSI);
                itemList.add(item);
            }
        }
        return itemList;
    }

    /**
     * 主治医意見書記入情報2印刷用パラメータを作成します。
     *
     * @return 主治医意見書記入情報2
     */
    public List<IkenshokinyuyoshiBusiness> create主治医意見書記入情報2_パラメータ() {
        List<IkenshokinyuyoshiBusiness> itemList = new ArrayList<>();
        List<dgShujiiIkensho_Row> selectedItems = div.getDgShujiiIkensho().getSelectedItems();

        for (dgShujiiIkensho_Row row : selectedItems) {
            ChosaIraishoAndChosahyoAndIkenshoPrintParameter parameter
                    = ChosaIraishoAndChosahyoAndIkenshoPrintParameter.createParameter(row.getShinseishoKanriNo());

            List<ChosaIraishoAndChosahyoAndIkenshoPrintBusiness> businessList = ChosaIraishoAndChosahyoAndIkenshoPrintFinder.createInstance()
                    .get主治医意見書記入用紙(parameter).records();
            if (!businessList.isEmpty()) {
                ChosaIraishoAndChosahyoAndIkenshoPrintBusiness business = businessList.get(0);
                List<RString> 保険者番号リスト = get被保険者番号(business.get保険者番号());
                List<RString> 被保険者番号リスト = get被保険者番号(business.get被保険者番号());
                IkenshokinyuyoshiBusiness item = new IkenshokinyuyoshiBusiness();
                item.setHokenshaNo1(保険者番号リスト.get(0));
                item.setHokenshaNo2(保険者番号リスト.get(1));
                item.setHokenshaNo3(保険者番号リスト.get(2));
                item.setHokenshaNo4(保険者番号リスト.get(INDEX_3));
                item.setHokenshaNo5(保険者番号リスト.get(INDEX_4));
                item.setHokenshaNo6(保険者番号リスト.get(INDEX_5));
                item.setHihokenshaNo1(被保険者番号リスト.get(0));
                item.setHihokenshaNo2(被保険者番号リスト.get(1));
                item.setHihokenshaNo3(被保険者番号リスト.get(2));
                item.setHihokenshaNo4(被保険者番号リスト.get(INDEX_3));
                item.setHihokenshaNo5(被保険者番号リスト.get(INDEX_4));
                item.setHihokenshaNo6(被保険者番号リスト.get(INDEX_5));
                item.setHihokenshaNo7(被保険者番号リスト.get(INDEX_6));
                item.setHihokenshaNo8(被保険者番号リスト.get(INDEX_7));
                item.setHihokenshaNo9(被保険者番号リスト.get(INDEX_8));
                item.setHihokenshaNo10(被保険者番号リスト.get(INDEX_9));
                RString ninteiShinseiDay = new FlexibleDate(business.get認定申請年月日()).wareki().eraType(EraType.ALPHABET).firstYear(FirstYear.ICHI_NEN)
                        .separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
                item.setShinseiYY1(ninteiShinseiDay.substring(1, 2));
                item.setShinseiYY2(ninteiShinseiDay.substring(2, INDEX_3));
                item.setShinseiMM1(ninteiShinseiDay.substring(INDEX_4, INDEX_5));
                item.setShinseiMM2(ninteiShinseiDay.substring(INDEX_5, INDEX_6));
                item.setShinseiDD1(ninteiShinseiDay.substring(INDEX_7, INDEX_8));
                item.setShinseiDD2(ninteiShinseiDay.substring(INDEX_8));
                itemList.add(item);
            }
        }
        return itemList;
    }

    /**
     * 主治医意見書記入情報3印刷用パラメータを作成します。
     *
     * @return 主治医意見書記入情報3
     */
    public List<IkenshokinyuyoshiBusiness> create主治医意見書記入情報3_パラメータ() {
        List<IkenshokinyuyoshiBusiness> itemList = new ArrayList<>();
        List<dgShujiiIkensho_Row> selectedItems = div.getDgShujiiIkensho().getSelectedItems();

        for (dgShujiiIkensho_Row row : selectedItems) {
            ChosaIraishoAndChosahyoAndIkenshoPrintParameter parameter
                    = ChosaIraishoAndChosahyoAndIkenshoPrintParameter.createParameter(row.getShinseishoKanriNo());

            List<ChosaIraishoAndChosahyoAndIkenshoPrintBusiness> businessList = ChosaIraishoAndChosahyoAndIkenshoPrintFinder.createInstance()
                    .get主治医意見書記入用紙(parameter).records();
            if (!businessList.isEmpty()) {
                ChosaIraishoAndChosahyoAndIkenshoPrintBusiness business = businessList.get(0);
                List<RString> 保険者番号リスト = get被保険者番号(business.get保険者番号());
                List<RString> 被保険者番号リスト = get被保険者番号(business.get被保険者番号());
                IkenshokinyuyoshiBusiness item = new IkenshokinyuyoshiBusiness();
                item.setHokenshaNo1(保険者番号リスト.get(0));
                item.setHokenshaNo2(保険者番号リスト.get(1));
                item.setHokenshaNo3(保険者番号リスト.get(2));
                item.setHokenshaNo4(保険者番号リスト.get(INDEX_3));
                item.setHokenshaNo5(保険者番号リスト.get(INDEX_4));
                item.setHokenshaNo6(保険者番号リスト.get(INDEX_5));
                item.setHihokenshaNo1(被保険者番号リスト.get(0));
                item.setHihokenshaNo2(被保険者番号リスト.get(1));
                item.setHihokenshaNo3(被保険者番号リスト.get(2));
                item.setHihokenshaNo4(被保険者番号リスト.get(INDEX_3));
                item.setHihokenshaNo5(被保険者番号リスト.get(INDEX_4));
                item.setHihokenshaNo6(被保険者番号リスト.get(INDEX_5));
                item.setHihokenshaNo7(被保険者番号リスト.get(INDEX_6));
                item.setHihokenshaNo8(被保険者番号リスト.get(INDEX_7));
                item.setHihokenshaNo9(被保険者番号リスト.get(INDEX_8));
                item.setHihokenshaNo10(被保険者番号リスト.get(INDEX_9));
                item.setHihokenshaTel(business.get電話番号());
                RString ninteiShinseiDay = new FlexibleDate(business.get認定申請年月日()).wareki().eraType(EraType.ALPHABET).firstYear(FirstYear.ICHI_NEN)
                        .separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
                item.setShinseiYY1(ninteiShinseiDay.substring(1, 2));
                item.setShinseiYY2(ninteiShinseiDay.substring(2, INDEX_3));
                item.setShinseiMM1(ninteiShinseiDay.substring(INDEX_4, INDEX_5));
                item.setShinseiMM2(ninteiShinseiDay.substring(INDEX_5, INDEX_6));
                item.setShinseiDD1(ninteiShinseiDay.substring(INDEX_7, INDEX_8));
                item.setShinseiDD2(ninteiShinseiDay.substring(INDEX_8));
                itemList.add(item);
            }
        }
        return itemList;
    }

    /**
     * 介護保険診断命令書印刷用パラメータを作成します。
     *
     * @return 介護保険診断命令書パラメータ
     */
    public List<KaigohokenShindanMeireishoHeaderItem> create介護保険診断命令書_パラメータ() {
        List<KaigohokenShindanMeireishoHeaderItem> itemList = new ArrayList<>();
        List<dgShujiiIkensho_Row> selectedItems = div.getDgShujiiIkensho().getSelectedItems();
        int 宛名連番 = 1;
        RString 受診場所 = div.getShindanMeirei().getTxtJushinBasho().getValue();
        for (dgShujiiIkensho_Row row : selectedItems) {
            ChosaIraishoAndChosahyoAndIkenshoPrintParameter parameter
                    = ChosaIraishoAndChosahyoAndIkenshoPrintParameter.createParameter(row.getShinseishoKanriNo());

            List<ChosaIraishoAndChosahyoAndIkenshoPrintBusiness> businessList = ChosaIraishoAndChosahyoAndIkenshoPrintFinder.createInstance()
                    .get介護保険診断命令書(parameter).records();
            if (!businessList.isEmpty()) {
                ChosaIraishoAndChosahyoAndIkenshoPrintBusiness business = businessList.get(0);
                RString 文書番号 = ReportUtil.get文書番号(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE235001.getReportId(), FlexibleDate.getNowDate());
                RString customerBarCode = RString.EMPTY;
                if (!RString.isNullOrEmpty(business.get調査委託先郵便番号()) && !RString.isNullOrEmpty(business.get調査委託先住所())) {
                    customerBarCode = ReportUtil.getCustomerBarCode(business.get医療機関郵便番号(), business.get医療機関住所());
                }
                RStringBuilder builder = new RStringBuilder();
                builder.append("*");
                builder.append((new RString(String.valueOf(宛名連番++))).padZeroToLeft(INDEX_6));
                builder.append("#");
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
                        get名称付与(),
                        customerBarCode,
                        builder.toRString(),
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
                        通知文.get(2)
                );
                itemList.add(item);
            }
        }
        return itemList;
    }

    private RString get受診日時または期間() {
        RStringBuilder 受診日時または期間 = new RStringBuilder();
        RString radJyushinKikan = div.getShindanMeirei().getRadJyushinKikan().getSelectedKey();

        if (KEY0.equals(radJyushinKikan)) {
            RDate ymd = div.getShindanMeirei().getTxtJyushinymd().getValue();
            RTime time = div.getShindanMeirei().getTxtJushinTime().getValue();

            受診日時または期間.append(ymd.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            受診日時または期間.append(time.toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒));
            受診日時または期間.append(文字列_まで);
        } else {
            RDate from = div.getShindanMeirei().getTxtJushinKikan().getFromValue();
            RDate to = div.getShindanMeirei().getTxtJushinKikan().getToValue();
            受診日時または期間.append(from.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            受診日時または期間.append(連結);
            受診日時または期間.append(to.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            受診日時または期間.append(文字列_まで);
        }
        return 受診日時または期間.toRString();
    }

    private void set意見書作成料(ChosaIraishoAndChosahyoAndIkenshoPrintBusiness business, ShujiiIkenshoSakuseiRyoSeikyushoItem item) {
        if (IkenshoIraiKubun.初回依頼.getコード().equals(business.get意見書作成回数区分())
                && ZaitakuShisetsuKubun.在宅.getコード().equals(business.get在宅施設区分())) {
            RString shinkiZaitakuKingaku = item.getShinkiZaitakuKingaku();
            item.setIkenshoSakuseiRyo1(shinkiZaitakuKingaku.substring(0, 1));
            item.setIkenshoSakuseiRyo2(shinkiZaitakuKingaku.substring(1, 2));
            item.setIkenshoSakuseiRyo3(shinkiZaitakuKingaku.substring(2, INDEX_3));
            item.setIkenshoSakuseiRyo4(shinkiZaitakuKingaku.substring(INDEX_3, INDEX_4));
            item.setSeikyugakuIkenshoSakuseiRyo1(shinkiZaitakuKingaku.substring(0, 1));
            item.setSeikyugakuIkenshoSakuseiRyo2(shinkiZaitakuKingaku.substring(1, 2));
            item.setSeikyugakuIkenshoSakuseiRyo3(shinkiZaitakuKingaku.substring(2, INDEX_3));
            item.setSeikyugakuIkenshoSakuseiRyo4(shinkiZaitakuKingaku.substring(INDEX_3, INDEX_4));
        }
        if (IkenshoIraiKubun.初回依頼.getコード().equals(business.get意見書作成回数区分())
                && ZaitakuShisetsuKubun.施設.getコード().equals(business.get在宅施設区分())) {
            RString shinkiShisetsuKingaku = item.getShinkiShisetsuKingaku();
            item.setIkenshoSakuseiRyo1(shinkiShisetsuKingaku.substring(0, 1));
            item.setIkenshoSakuseiRyo2(shinkiShisetsuKingaku.substring(1, 2));
            item.setIkenshoSakuseiRyo3(shinkiShisetsuKingaku.substring(2, INDEX_3));
            item.setIkenshoSakuseiRyo4(shinkiShisetsuKingaku.substring(INDEX_3, INDEX_4));
            item.setSeikyugakuIkenshoSakuseiRyo1(shinkiShisetsuKingaku.substring(0, 1));
            item.setSeikyugakuIkenshoSakuseiRyo2(shinkiShisetsuKingaku.substring(1, 2));
            item.setSeikyugakuIkenshoSakuseiRyo3(shinkiShisetsuKingaku.substring(2, INDEX_3));
            item.setSeikyugakuIkenshoSakuseiRyo4(shinkiShisetsuKingaku.substring(INDEX_3, INDEX_4));

        }
        if (IkenshoIraiKubun.再依頼.getコード().equals(business.get意見書作成回数区分())
                && ZaitakuShisetsuKubun.在宅.getコード().equals(business.get在宅施設区分())) {
            RString keizokuZaitakuKingaku = item.getKeizokuZaitakuKingaku();
            item.setIkenshoSakuseiRyo1(keizokuZaitakuKingaku.substring(0, 1));
            item.setIkenshoSakuseiRyo2(keizokuZaitakuKingaku.substring(1, 2));
            item.setIkenshoSakuseiRyo3(keizokuZaitakuKingaku.substring(2, INDEX_3));
            item.setIkenshoSakuseiRyo4(keizokuZaitakuKingaku.substring(INDEX_3, INDEX_4));
            item.setSeikyugakuIkenshoSakuseiRyo1(keizokuZaitakuKingaku.substring(0, 1));
            item.setSeikyugakuIkenshoSakuseiRyo2(keizokuZaitakuKingaku.substring(1, 2));
            item.setSeikyugakuIkenshoSakuseiRyo3(keizokuZaitakuKingaku.substring(2, INDEX_3));
            item.setSeikyugakuIkenshoSakuseiRyo4(keizokuZaitakuKingaku.substring(INDEX_3, INDEX_4));

        }
        if (IkenshoIraiKubun.再依頼.getコード().equals(business.get意見書作成回数区分())
                && ZaitakuShisetsuKubun.施設.getコード().equals(business.get在宅施設区分())) {
            RString keizokuShisetsuKingaku = item.getKeizokuShisetsuKingaku();
            item.setIkenshoSakuseiRyo1(keizokuShisetsuKingaku.substring(0, 1));
            item.setIkenshoSakuseiRyo2(keizokuShisetsuKingaku.substring(1, 2));
            item.setIkenshoSakuseiRyo3(keizokuShisetsuKingaku.substring(2, INDEX_3));
            item.setIkenshoSakuseiRyo4(keizokuShisetsuKingaku.substring(INDEX_3, INDEX_4));
            item.setSeikyugakuIkenshoSakuseiRyo1(keizokuShisetsuKingaku.substring(0, 1));
            item.setSeikyugakuIkenshoSakuseiRyo2(keizokuShisetsuKingaku.substring(1, 2));
            item.setSeikyugakuIkenshoSakuseiRyo3(keizokuShisetsuKingaku.substring(2, INDEX_3));
            item.setSeikyugakuIkenshoSakuseiRyo4(keizokuShisetsuKingaku.substring(INDEX_3, INDEX_4));
        }

    }

    private RString get印刷日時() {
        RDateTime printdate = RDateTime.now();
        RStringBuilder printTimeStampSb = new RStringBuilder();
        printTimeStampSb.append(printdate.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString());
        printTimeStampSb.append(RString.HALF_SPACE);
        printTimeStampSb.append(String.format("%02d", printdate.getHour()));
        printTimeStampSb.append(DATE_時);
        printTimeStampSb.append(String.format("%02d", printdate.getMinute()));
        printTimeStampSb.append(DATE_分);
        printTimeStampSb.append(String.format("%02d", printdate.getSecond()));
        printTimeStampSb.append(DATE_秒);
        printTimeStampSb.append(RString.HALF_SPACE);
        return printTimeStampSb.toRString();
    }

    private RString get和暦(RString 日付, boolean 年号フラグ) {
        RString 和暦 = RString.EMPTY;
        if (!RString.isNullOrEmpty(日付)) {
            FlexibleDate flexibleDate = new FlexibleDate(日付);
            if (年号フラグ) {
                和暦 = flexibleDate.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                        separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            } else {
                和暦 = flexibleDate.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                        separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString().substring(2);
            }
        }
        return 和暦;
    }

    private void get年号(FlexibleDate 生年月日, ShujiiIkenshoSakuseiIraishoItem item) {
        RString 年号 = 生年月日.wareki().eraType(EraType.KANJI).toDateString();
        if (年号.startsWith(元号_明治)) {
            item.setBirthGengoShowa(HOUSI);
            item.setBirthGengoTaisho(HOUSI);
        } else if (年号.startsWith(元号_大正)) {
            item.setBirthGengoMeiji(HOUSI);
            item.setBirthGengoShowa(HOUSI);
        } else if (年号.startsWith(元号_昭和)) {
            item.setBirthGengoMeiji(HOUSI);
            item.setBirthGengoTaisho(HOUSI);
        } else {
            item.setBirthGengoMeiji(HOUSI);
            item.setBirthGengoShowa(HOUSI);
            item.setBirthGengoTaisho(HOUSI);
        }
    }

    private RString get判定結果(RString 厚労省IF識別コード, RString 判定結果コード) {
        RString 判定結果 = RString.EMPTY;
        if (IFSHIKIBETSUCODE99A.equals(厚労省IF識別コード)) {
            判定結果 = IchijiHanteiKekkaCode99.toValue(判定結果コード).get名称();
        } else if (IFSHIKIBETSUCODE09A.equals(厚労省IF識別コード)) {
            判定結果 = IchijiHanteiKekkaCode09.toValue(判定結果コード).get名称();
        } else if (IFSHIKIBETSUCODE06A.equals(厚労省IF識別コード)) {
            判定結果 = IchijiHanteiKekkaCode06.toValue(判定結果コード).get名称();
        } else if (IFSHIKIBETSUCODE02A.equals(厚労省IF識別コード)) {
            判定結果 = IchijiHanteiKekkaCode02.toValue(判定結果コード).get名称();
        }
        return 判定結果;
    }

    private List<RString> get認定調査員コード(RString 認定調査員コード) {
        List<RString> 認定調査員コードリスト = new ArrayList<>();
        for (int i = 0; i <= INDEX_7; i++) {
            認定調査員コードリスト.add(RString.EMPTY);
        }

        if (0 < 認定調査員コード.length()) {
            認定調査員コードリスト.set(0, 認定調査員コード.substring(0, 1));
        }
        if (1 < 認定調査員コード.length()) {
            認定調査員コードリスト.set(1, 認定調査員コード.substring(1, 2));
        }
        if (2 < 認定調査員コード.length()) {
            認定調査員コードリスト.set(2, 認定調査員コード.substring(2, INDEX_3));
        }
        if (INDEX_3 < 認定調査員コード.length()) {
            認定調査員コードリスト.set(INDEX_3, 認定調査員コード.substring(INDEX_3, INDEX_4));
        }
        if (INDEX_4 < 認定調査員コード.length()) {
            認定調査員コードリスト.set(INDEX_4, 認定調査員コード.substring(INDEX_4, INDEX_5));
        }
        if (INDEX_5 < 認定調査員コード.length()) {
            認定調査員コードリスト.set(INDEX_5, 認定調査員コード.substring(INDEX_5, INDEX_6));
        }
        if (INDEX_6 < 認定調査員コード.length()) {
            認定調査員コードリスト.set(INDEX_6, 認定調査員コード.substring(INDEX_6, INDEX_7));
        }
        if (INDEX_7 < 認定調査員コード.length()) {
            認定調査員コードリスト.set(INDEX_7, 認定調査員コード.substring(INDEX_7, INDEX_8));
        }

        return 認定調査員コードリスト;
    }

    private List<RString> get認定調査委託先コード(RString 認定調査委託先コード) {
        List<RString> 認定調査委託先コードリスト = new ArrayList<>();
        for (int i = 0; i <= INDEX_11; i++) {
            認定調査委託先コードリスト.add(RString.EMPTY);
        }

        if (0 < 認定調査委託先コード.length()) {
            認定調査委託先コードリスト.set(0, 認定調査委託先コード.substring(0, 1));
        }
        if (1 < 認定調査委託先コード.length()) {
            認定調査委託先コードリスト.set(1, 認定調査委託先コード.substring(1, 2));
        }
        if (2 < 認定調査委託先コード.length()) {
            認定調査委託先コードリスト.set(2, 認定調査委託先コード.substring(2, INDEX_3));
        }
        if (INDEX_3 < 認定調査委託先コード.length()) {
            認定調査委託先コードリスト.set(INDEX_3, 認定調査委託先コード.substring(INDEX_3, INDEX_4));
        }
        if (INDEX_4 < 認定調査委託先コード.length()) {
            認定調査委託先コードリスト.set(INDEX_4, 認定調査委託先コード.substring(INDEX_4, INDEX_5));
        }
        if (INDEX_5 < 認定調査委託先コード.length()) {
            認定調査委託先コードリスト.set(INDEX_5, 認定調査委託先コード.substring(INDEX_5, INDEX_6));
        }
        if (INDEX_6 < 認定調査委託先コード.length()) {
            認定調査委託先コードリスト.set(INDEX_6, 認定調査委託先コード.substring(INDEX_6, INDEX_7));
        }
        if (INDEX_7 < 認定調査委託先コード.length()) {
            認定調査委託先コードリスト.set(INDEX_7, 認定調査委託先コード.substring(INDEX_7, INDEX_8));
        }
        if (INDEX_8 < 認定調査委託先コード.length()) {
            認定調査委託先コードリスト.set(INDEX_8, 認定調査委託先コード.substring(INDEX_8, INDEX_9));
        }
        if (INDEX_9 < 認定調査委託先コード.length()) {
            認定調査委託先コードリスト.set(INDEX_9, 認定調査委託先コード.substring(INDEX_9, INDEX_10));
        }
        if (INDEX_10 < 認定調査委託先コード.length()) {
            認定調査委託先コードリスト.set(INDEX_10, 認定調査委託先コード.substring(INDEX_10, INDEX_11));
        }
        if (INDEX_11 < 認定調査委託先コード.length()) {
            認定調査委託先コードリスト.set(INDEX_11, 認定調査委託先コード.substring(INDEX_11));
        }

        return 認定調査委託先コードリスト;
    }

    private RString set意見書作成提出期限(ChosaIraishoAndChosahyoAndIkenshoPrintBusiness business) {
        RString 調査期限設定方法 = DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成期限設定方法,
                RDate.getNowDate(), SubGyomuCode.DBE認定支援,
                div.getCcdHokenshaList().getSelectedItem().get市町村コード());
        RString 提出期限 = RString.EMPTY;
        RString key = div.getRadTeishutsuKigen().getSelectedKey();
        int 期限日数 = Integer.parseInt(DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成期限日数,
                RDate.getNowDate(), SubGyomuCode.DBE認定支援).toString());
        if (文字列1.equals(調査期限設定方法)) {
            if (KEY0.equals(key)) {
                提出期限 = !RString.isNullOrEmpty(business.get主治医意見書作成依頼年月日())
                        ? new RString(new FlexibleDate(business.get主治医意見書作成依頼年月日()).plusDay(期限日数).toString()) : RString.EMPTY;
            } else if (KEY1.equals(key)) {
                提出期限 = RString.EMPTY;
            } else if (KEY2.equals(key)) {
                RDate 共通日 = div.getTxtKyotsuDay().getValue();

                提出期限 = (共通日 != null ? new RString(共通日.plusDay(期限日数).toString()) : RString.EMPTY);
            }
        } else {
            提出期限 = !RString.isNullOrEmpty(business.get認定申請年月日())
                    ? new RString(new FlexibleDate(business.get認定申請年月日()).plusDay(期限日数).toString()) : RString.EMPTY;
        }
        return 提出期限;
    }

    private RString set認定調査提出期限(ChosaIraishoAndChosahyoAndIkenshoPrintBusiness business) {
        RString 認定調査期限設定方法 = DbBusinessConfig.get(ConfigNameDBE.認定調査期限設定方法,
                RDate.getNowDate(), SubGyomuCode.DBE認定支援,
                div.getCcdHokenshaList().getSelectedItem().get市町村コード());
        RString 提出期限 = RString.EMPTY;
        RString key = div.getRadTeishutsuKigen().getSelectedKey();
        int 期限日数 = Integer.parseInt(DbBusinessConfig.get(ConfigNameDBE.認定調査期限日数,
                RDate.getNowDate(), SubGyomuCode.DBE認定支援).toString());
        if (文字列1.equals(認定調査期限設定方法)) {
            if (KEY0.equals(key)) {
                提出期限 = !RString.isNullOrEmpty(business.get認定調査依頼年月日())
                        ? new RString(new FlexibleDate(business.get認定調査依頼年月日()).plusDay(期限日数).toString()) : RString.EMPTY;
            } else if (KEY1.equals(key)) {
                提出期限 = RString.EMPTY;
            } else if (KEY2.equals(key)) {
                RDate 共通日 = div.getTxtKyotsuDay().getValue();

                提出期限 = (共通日 != null ? new RString(共通日.plusDay(期限日数).toString()) : RString.EMPTY);
            }
        } else {
            提出期限 = !RString.isNullOrEmpty(business.get認定申請年月日())
                    ? new RString(new FlexibleDate(business.get認定申請年月日()).plusDay(期限日数).toString()) : RString.EMPTY;
        }
        return 提出期限;
    }

    private RString get名称付与() {
        RString key = DbBusinessConfig.get(ConfigNameDBE.認定調査依頼書_宛先敬称, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        RString meishoFuyo = RString.EMPTY;
        if (ChohyoAtesakiKeisho.なし.getコード().equals(key)) {
            meishoFuyo = RString.EMPTY;
        } else if (ChohyoAtesakiKeisho.様.getコード().equals(key)) {
            meishoFuyo = ChohyoAtesakiKeisho.様.get名称();
        } else if (ChohyoAtesakiKeisho.殿.getコード().equals(key)) {
            meishoFuyo = ChohyoAtesakiKeisho.殿.get名称();
        }
        return meishoFuyo;
    }

    private List<RString> get被保険者番号(RString 被保険者番号) {
        List<RString> 被保険者番号リスト = new ArrayList<>();
        for (int i = 0; i <= INDEX_9; i++) {
            被保険者番号リスト.add(RString.EMPTY);
        }

        if (0 < 被保険者番号.length()) {
            被保険者番号リスト.set(0, 被保険者番号.substring(0, 1));
        }
        if (1 < 被保険者番号.length()) {
            被保険者番号リスト.set(1, 被保険者番号.substring(1, 2));
        }
        if (2 < 被保険者番号.length()) {
            被保険者番号リスト.set(2, 被保険者番号.substring(2, INDEX_3));
        }
        if (INDEX_3 < 被保険者番号.length()) {
            被保険者番号リスト.set(INDEX_3, 被保険者番号.substring(INDEX_3, INDEX_4));
        }
        if (INDEX_4 < 被保険者番号.length()) {
            被保険者番号リスト.set(INDEX_4, 被保険者番号.substring(INDEX_4, INDEX_5));
        }
        if (INDEX_5 < 被保険者番号.length()) {
            被保険者番号リスト.set(INDEX_5, 被保険者番号.substring(INDEX_5, INDEX_6));
        }
        if (INDEX_6 < 被保険者番号.length()) {
            被保険者番号リスト.set(INDEX_6, 被保険者番号.substring(INDEX_6, INDEX_7));
        }
        if (INDEX_7 < 被保険者番号.length()) {
            被保険者番号リスト.set(INDEX_7, 被保険者番号.substring(INDEX_7, INDEX_8));
        }
        if (INDEX_8 < 被保険者番号.length()) {
            被保険者番号リスト.set(INDEX_8, 被保険者番号.substring(INDEX_8, INDEX_9));
        }
        if (INDEX_9 < 被保険者番号.length()) {
            被保険者番号リスト.set(INDEX_9, 被保険者番号.substring(INDEX_9));
        }

        return 被保険者番号リスト;
    }

    private RString get要支援詳細(RString yokaigoJotaiKubun) {
        RString 要支援詳細 = RString.EMPTY;
        if (YOKAIGOJOTAIKUBUN12.equals(yokaigoJotaiKubun)) {
            要支援詳細 = 文字列1;
        } else if (YOKAIGOJOTAIKUBUN13.equals(yokaigoJotaiKubun)) {
            要支援詳細 = 文字列2;
        }
        return 要支援詳細;
    }

    private RString get要介護(RString yokaigoJotaiKubun) {
        RString 要介護 = RString.EMPTY;
        if (YOKAIGOJOTAIKUBUN21.equals(yokaigoJotaiKubun)
                || YOKAIGOJOTAIKUBUN22.equals(yokaigoJotaiKubun)
                || YOKAIGOJOTAIKUBUN23.equals(yokaigoJotaiKubun)
                || YOKAIGOJOTAIKUBUN24.equals(yokaigoJotaiKubun)
                || YOKAIGOJOTAIKUBUN25.equals(yokaigoJotaiKubun)) {
            要介護 = 記号;
        }
        return 要介護;
    }

    private RString get要介護詳細(RString yokaigoJotaiKubun) {
        RString 要介護詳細 = RString.EMPTY;
        if (YOKAIGOJOTAIKUBUN21.equals(yokaigoJotaiKubun)) {
            要介護詳細 = 文字列1;
        } else if (YOKAIGOJOTAIKUBUN22.equals(yokaigoJotaiKubun)) {
            要介護詳細 = 文字列2;
        } else if (YOKAIGOJOTAIKUBUN23.equals(yokaigoJotaiKubun)) {
            要介護詳細 = 文字列3;
        } else if (YOKAIGOJOTAIKUBUN24.equals(yokaigoJotaiKubun)) {
            要介護詳細 = 文字列4;
        } else if (YOKAIGOJOTAIKUBUN25.equals(yokaigoJotaiKubun)) {
            要介護詳細 = 文字列5;
        }
        return 要介護詳細;
    }
}
