/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ChosaIraishoAndChosahyoAndIkenshoPrint;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.core.ikenshoprint.ChosaIraishoAndChosahyoAndIkenshoPrintBusiness;
import jp.co.ndensan.reams.db.dbe.business.report.chosairaisho.ChosaIraishoHeadItem;
import jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.core.gamensenikbn.GamenSeniKbn;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.ChohyoAtesakiKeisho;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.ikenshoprint.ChosaIraishoAndChosahyoAndIkenshoPrintParameter;
import jp.co.ndensan.reams.db.dbe.service.core.ikenshoprint.ChosaIraishoAndChosahyoAndIkenshoPrintFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.service.util.report.ReportUtil;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 依頼書・認定調査票(OCR)・主治医意見書印刷のハンドラークラスです。
 *
 * @reamsid_L DBE-3000-230 sunhaidi
 */
public class ChosaIraishoAndChosahyoAndIkenshoPrintHandler {

    private static final RString CONFIGVALUE1 = new RString("1");
    private static final RString KEY0 = new RString("0");
    private static final RString KEY1 = new RString("1");
    private static final RString KEY2 = new RString("2");
    private static final RString 元号_明治 = new RString("明治");
    private static final RString 元号_大正 = new RString("大正");
    private static final RString 元号_昭和 = new RString("昭和");
    private static final RString 記号 = new RString("✔");
    private static final RString HOUSI = new RString("*");
    private static final RString ハイフン = new RString("-");
    private static final RString 文字列0 = new RString("0");
    private static final RString 文字列1 = new RString("1");
    private static final RString 文字列2 = new RString("2");
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;
    private static final int INDEX_6 = 6;
    private static final int INDEX_7 = 7;
    private static final int INDEX_8 = 8;
    private static final int INDEX_9 = 9;
    private static final int INDEX_10 = 10;
    private static final int INDEX_11 = 11;
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
        div.getCcdHokenshaList().loadHokenshaList();
        RString 証記載保険者番号 = div.getCcdHokenshaList().getSelectedItem().get証記載保険者番号().value();
        ChosaIraishoAndChosahyoAndIkenshoPrintParameter parameter = ChosaIraishoAndChosahyoAndIkenshoPrintParameter.createParameter(申請書管理番号リスト,
                証記載保険者番号);
        if (GamenSeniKbn.認定調査依頼.equals(遷移元画面区分)) {
            div.getNinteiChosa().setVisible(true);
            div.getShujiiIkensho().setVisible(false);
            List<ChosaIraishoAndChosahyoAndIkenshoPrintBusiness> list = ChosaIraishoAndChosahyoAndIkenshoPrintFinder.createInstance()
                    .get認定調査依頼情報(parameter).records();
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
            div.getNinteiChosa().setVisible(false);
            div.getShujiiIkensho().setVisible(true);
            List<ChosaIraishoAndChosahyoAndIkenshoPrintBusiness> list = ChosaIraishoAndChosahyoAndIkenshoPrintFinder.createInstance()
                    .get主治医意見書依頼情報(parameter).records();
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
                row.setRirekiNo(nullToEmpty(business.get認定調査依頼履歴番号()));
                rowList.add(row);
            }
            div.getDgShujiiIkensho().setDataSource(rowList);
            div.setHiddenData(getInputData());
            setDisableToShujiiIkenshoChk();
        }
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
            div.getShindanMeirei().setVisible(true);
        } else {
            div.getShindanMeirei().setVisible(false);
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
            div.getTxtJyushinymd().setRequired(true);
            div.getTxtJushinKikan().setDisabled(true);
            div.getTxtJushinBasho().setDisabled(false);
            div.getTxtJushinBasho().setRequired(true);
        } else {
            div.getTxtJyushinymd().setDisabled(true);
            div.getTxtJushinTime().setDisabled(true);
            div.getTxtJushinKikan().setDisabled(false);
            div.getTxtJushinKikan().setReadOnly(true);
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
        RString 概況調査_用紙タイプ = BusinessConfig.get(ConfigNameDBE.認定調査票_概況調査_用紙タイプ,
                SubGyomuCode.DBE認定支援, 市町村コード);

        if (CONFIGVALUE1.equals(概況調査_用紙タイプ)) {
            List<RString> keyList = new ArrayList<>();
            keyList.add(KEY0);
            div.getChkChosahyo().setDisabledItemsByKey(keyList);
        } else {
            List<RString> keyList = new ArrayList<>();
            keyList.add(KEY0);
            div.getChkOcrChosahyo().setDisabledItemsByKey(keyList);
        }
        RString 基本調査_用紙タイプ = BusinessConfig.get(ConfigNameDBE.認定調査票_基本調査_用紙タイプ,
                SubGyomuCode.DBE認定支援, 市町村コード);
        if (CONFIGVALUE1.equals(基本調査_用紙タイプ)) {
            List<RString> keyList = new ArrayList<>();
            keyList.add(KEY1);
            div.getChkChosahyo().setDisabledItemsByKey(keyList);
        } else {
            List<RString> keyList = new ArrayList<>();
            keyList.add(KEY1);
            div.getChkOcrChosahyo().setDisabledItemsByKey(keyList);
        }
        RString 特記事項_用紙タイプ = BusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_用紙タイプ,
                SubGyomuCode.DBE認定支援, 市町村コード);
        if (CONFIGVALUE1.equals(特記事項_用紙タイプ)) {
            List<RString> keyList = new ArrayList<>();
            keyList.add(KEY2);
            div.getChkChosahyo().setDisabledItemsByKey(keyList);
        } else {
            List<RString> keyList = new ArrayList<>();
            keyList.add(KEY2);
            div.getChkOcrChosahyo().setDisabledItemsByKey(keyList);
        }
    }

    private void setDisableToShujiiIkenshoChk() {
        LasdecCode 市町村コード = div.getCcdHokenshaList().getSelectedItem().get市町村コード();
        RString 意見書用紙タイプ = BusinessConfig.get(ConfigNameDBE.意見書用紙タイプ,
                SubGyomuCode.DBE認定支援, 市町村コード);

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
        int 宛名連番 = 1;
        RString タイトル = BusinessConfig.get(ConfigNameDBE.認定調査依頼書, SubGyomuCode.DBE認定支援);
        for (dgNinteiChosa_Row row : selectedItems) {

            ChosaIraishoAndChosahyoAndIkenshoPrintParameter parameter
                    = ChosaIraishoAndChosahyoAndIkenshoPrintParameter.createParameter(row.getShinseishoKanriNo());

            List<ChosaIraishoAndChosahyoAndIkenshoPrintBusiness> list = ChosaIraishoAndChosahyoAndIkenshoPrintFinder.createInstance()
                    .get認定調査依頼書(parameter).records();
            if (!list.isEmpty()) {
                ChosaIraishoAndChosahyoAndIkenshoPrintBusiness business = list.get(0);
                List<RString> 被保険者番号リスト = get被保険者番号(business.get被保険者番号());
                RString 文書番号 = ReportUtil.get文書番号(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE220001.getReportId(), FlexibleDate.getNowDate());
                RString customerBarCode = ReportUtil.getCustomerBarCode(business.get調査委託先郵便番号(), business.get調査委託先住所());
                RStringBuilder builder = new RStringBuilder();
                builder.append("*");
                builder.append((new RString(String.valueOf(宛名連番++))).padZeroToLeft(INDEX_6));
                builder.append("#");
                Map<Integer, RString> 通知文
                        = ReportUtil.get通知文(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE220001.getReportId(), KamokuCode.EMPTY, 1);

                RString 誕生日明治 = HOUSI;
                RString 誕生日大正 = HOUSI;
                RString 誕生日昭和 = HOUSI;
                FlexibleDate seinengappiYMD = new FlexibleDate(business.get生年月日());
                RString era = seinengappiYMD.wareki().eraType(EraType.KANJI).getEra();
                RString 誕生日 = seinengappiYMD.wareki()
                        .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                        separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
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

                if (Seibetsu.男.get名称().equals(seibetsu)) {
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
                        builder.toRString(),
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
                        誕生日.substring(2),
                        business.get被保険者氏名(),
                        性別男,
                        性別女,
                        new YubinNo(business.get郵便番号()).getEditedYubinNo(),
                        business.get住所(),
                        business.get郵便番号(),
                        business.get訪問調査先郵便番号(),
                        business.get訪問調査先住所(),
                        business.get訪問調査先名称(),
                        business.get訪問調査先電話番号(),
                        認定申請年月日,
                        set提出期限(business),
                        通知文.get(2)
                );
                chosaIraishoHeadItemList.add(item);
            }
        }
        return chosaIraishoHeadItemList;
    }

    private RString set提出期限(ChosaIraishoAndChosahyoAndIkenshoPrintBusiness business) {
        RString 認定調査期限設定方法 = BusinessConfig.get(ConfigNameDBE.認定調査期限設定方法,
                SubGyomuCode.DBE認定支援,
                div.getCcdHokenshaList().getSelectedItem().get市町村コード());
        RString 提出期限 = RString.EMPTY;
        RString key = div.getRadTeishutsuKigen().getSelectedKey();
        int 期限日数 = Integer.parseInt(BusinessConfig.get(ConfigNameDBE.主治医意見書作成期限日数,
                SubGyomuCode.DBE認定支援).toString());
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
        RString key = BusinessConfig.get(ConfigNameDBE.認定調査依頼書_宛先敬称, SubGyomuCode.DBE認定支援);
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

}
