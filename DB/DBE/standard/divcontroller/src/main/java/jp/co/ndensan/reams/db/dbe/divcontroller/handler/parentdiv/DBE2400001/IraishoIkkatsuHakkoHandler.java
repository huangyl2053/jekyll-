/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2400001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.iraisho.IraishoIkkatsuHakkoResult;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE220010.DBE220010_IraishoIkkatuParameter;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE220010.GridParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2400001.IraishoIkkatsuHakkoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2400001.dgNinteiChosaIraiTaishoIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2400001.dgShujiiIkenshoSakuseiIraiTaishoIchiran_Row;
import jp.co.ndensan.reams.db.dbx.business.core.basic.KaigoDonyuKeitai;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbz.definition.reportid.ReportIdDBZ;
import jp.co.ndensan.reams.db.dbz.service.core.kaigiatesakijushosettei.KaigoAtesakiJushoSetteiFinder;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * 依頼書一括発行の抽象Handlerクラスです。
 *
 * @reamsid_L DBE-0080-010 duanzhanli
 */
public class IraishoIkkatsuHakkoHandler {

    private static final RString STATE_NINTEI = new RString("1");
    private static final RString STATE_SHUJII = new RString("2");
    private static final RString COMMON_SELECTED = new RString("key0");
    private static final RString SHUTSU_CHECKED = new RString("key2");
    private static final RString SELECTED_NOPRINT = new RString("key0");
    private static final RString SELECTED_PRINT = new RString("key1");
    private static final RString SHINSEI_KASAN = new RString("2");
    private static final RString NO_PRINT = new RString("1");
    private static final RString PRINT = new RString("2");
    private static final RString PRINT_AND_NOPRINT = new RString("3");
    private static final RString 出力する = new RString("1");
    private static final RString 選択 = new RString("1");
    private static final RString 依頼書選択_単票 = new RString("1");
    private static final RString 依頼書選択_一覧 = new RString("2");
    private static final RString 片面印刷 = new RString("1");
    private static final RString 依頼書チェックボックス_単票 = new RString("0");
    private static final RString 依頼書チェックボックス_一覧 = new RString("1");
    private static final RString 調査票チェックボックス_概況調査 = new RString("0");
    private static final RString 調査票チェックボックス_基本調査 = new RString("1");
    private static final RString 調査票チェックボックス_特記事項 = new RString("2");
    private static final RString 調査票チェックボックス_概況特記 = new RString("0");
    private static final RString 調査票チェックボックス_差異 = new RString("0");
    private static final RString 調査票チェックボックス_特記事項_調査群 = new RString("0");
    private static final RString 調査票チェックボックス_特記事項_フリー = new RString("1");
    private static final RString 調査票チェックボックス_発行一覧 = new RString("0");
    private static final RString 調査票チェックボックス_履歴一覧 = new RString("0");
    private static final RString 意見書チェックボックス_記入用紙 = new RString("0");
    private static final RString 意見書チェックボックス_請求書 = new RString("0");
    private static final RString 意見書チェックボックス_請求一覧 = new RString("0");
    private static final RString 意見書チェックボックス_発行一覧 = new RString("0");
    private static final RString 意見書チェックボックス_履歴一覧 = new RString("0");
    private static final RString 依頼書期限設定_自動 = new RString("1");
    private static final RString 依頼書期限設定_空欄 = new RString("2");
    private static final RString 依頼書期限設定_共通 = new RString("3");
    private static final RString 依頼書期限ラジオボタン_自動 = new RString("key0");
    private static final RString 依頼書期限ラジオボタン_空欄 = new RString("key1");
    private static final RString 依頼書期限ラジオボタン_共通 = new RString("key2");
    private static final RString CONFIGVALUE1 = new RString("1");

    private static final RString SELECTED_NINTEI_CHOSA = new RString("key0");
    private static final RString SELECTED_SHUJII_IKENSHO = new RString("key1");

    private final IraishoIkkatsuHakkoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 依頼書一括発行Div
     */
    public IraishoIkkatsuHakkoHandler(IraishoIkkatsuHakkoDiv div) {
        this.div = div;
    }

    /**
     *
     * 依頼書一括発行初期化の設定します。
     */
    public void load() {
        div.getRadTaishoSentaku().setSelectedKey(COMMON_SELECTED);
        div.getTxtChosaDispMax().setMaxValue(new Decimal(DbBusinessConfig
                .get(ConfigNameDBU.検索制御_最大取得件数上限, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
        div.getTxtIkenshoDispMax().setMaxValue(new Decimal(DbBusinessConfig
                .get(ConfigNameDBU.検索制御_最大取得件数上限, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
        div.getCcdNinteiChosaHokensha().loadHokenshaList(GyomuBunrui.介護認定);
        div.getCcdShujiiIkenshoHokensha().loadHokenshaList(GyomuBunrui.介護認定);
    }

    /**
     *
     * 依頼書一括発行初期化の設定します。
     */
    public void loadNinteiChosa() {
        div.getTxtNinteiChosaIraibi().clearFromValue();
        div.getTxtNinteiChosaIraibi().clearToValue();
        div.getTxtChosaDispMax().setValue(new Decimal(DbBusinessConfig
                .get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
        div.getDgNinteiChosaIraiTaishoIchiran().getDataSource().clear();
        List<RString> selectKeys = new ArrayList<>();
        selectKeys.add(COMMON_SELECTED);
        div.getChkNinteiChosaIraisho().setSelectedItemsByKey(selectKeys);
        div.getChkNinteiChosahyo().setSelectedItemsByKey(selectKeys);
        div.setState(STATE_NINTEI);
    }

    /**
     *
     * 主治医意見書Divの設定します。
     */
    public void loadShuJiiIKensho() {
        div.getTxtShujiiIkenshoSakuseiIraibi().clearFromValue();
        div.getTxtShujiiIkenshoSakuseiIraibi().clearToValue();
        div.getTxtIkenshoDispMax().setValue(new Decimal(DbBusinessConfig
                .get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
        div.getDgShujiiIkenshoSakuseiIraiTaishoIchiran().getDataSource().clear();
        List<RString> selectKeys = new ArrayList<>();
        selectKeys.add(COMMON_SELECTED);
        div.getChkShujiiikenshoSakuseiIrai().setSelectedItemsByKey(selectKeys);
        div.getChkShujiiIkensho().setSelectedItemsByKey(selectKeys);
        div.setState(STATE_SHUJII);
    }

    /**
     *
     * 依頼書一括発行初期化の設定します。
     */
    public void setNinteiChosa() {
        initializeNinteiChkShinseiTani();
        setNinteiChkShinseiTani();
        setHakkobiAndTeishutsuKigen();
        RString 証記載保険者番号 = div.getCcdNinteiChosaHokensha().getSelectedItem().get証記載保険者番号().value();
        KaigoAtesakiJushoSetteiFinder finader = KaigoAtesakiJushoSetteiFinder.createInstance();
        List<KaigoDonyuKeitai> 介護導入形態 = finader.select介護導入形態().records();
        ReportId 帳票ID = ReportIdDBZ.DBE220001.getReportId();
        for (KaigoDonyuKeitai item : 介護導入形態) {
            if (GyomuBunrui.介護認定.equals(item.get業務分類()) && DonyuKeitaiCode.認定広域.equals(item.get導入形態コード())
                    && 証記載保険者番号 != null && !証記載保険者番号.isEmpty()) {
                RStringBuilder 帳票IDBuilder = new RStringBuilder();
                帳票IDBuilder.append(帳票ID.value()).append(new RString("_")).append(証記載保険者番号);
                帳票ID = new ReportId(帳票IDBuilder.toRString());
            }
        }
        div.getCcdBunshoNo().initialize(帳票ID);
    }

    /**
     *
     * 主治医意見書Divの設定します。
     */
    public void setShuJiiIKensho() {
        initializeShujiiChkShinseiTani();
        setShujiiChkShinseiTani();
        setHakkobiAndTeishutsuKigen();
        RString 証記載保険者番号 = div.getCcdNinteiChosaHokensha().getSelectedItem().get証記載保険者番号().value();
        KaigoAtesakiJushoSetteiFinder finader = KaigoAtesakiJushoSetteiFinder.createInstance();
        List<KaigoDonyuKeitai> 介護導入形態 = finader.select介護導入形態().records();
        ReportId 帳票ID = ReportIdDBZ.DBE230001.getReportId();
        for (KaigoDonyuKeitai item : 介護導入形態) {
            if (GyomuBunrui.介護認定.equals(item.get業務分類()) && DonyuKeitaiCode.認定広域.equals(item.get導入形態コード())
                    && 証記載保険者番号 != null && !証記載保険者番号.isEmpty()) {
                RStringBuilder 帳票IDBuilder = new RStringBuilder();
                帳票IDBuilder.append(帳票ID.value()).append(new RString("_")).append(証記載保険者番号);
                帳票ID = new ReportId(帳票IDBuilder.toRString());
            }
        }
        div.getCcdBunshoNo().initialize(帳票ID);
    }

    /**
     * 対象調査員一覧Gridを設定します。
     *
     * @param resultList 対象調査員一覧データ
     */
    public void setDataGrid(List<IraishoIkkatsuHakkoResult> resultList) {
        if (STATE_NINTEI.equals(div.getState())) {
            List<dgNinteiChosaIraiTaishoIchiran_Row> rowList = new ArrayList<>();
            div.getDgNinteiChosaIraiTaishoIchiran().getGridSetting().setSelectedRowCount(resultList.size());
            int count = 1;
            for (IraishoIkkatsuHakkoResult result : resultList) {
                dgNinteiChosaIraiTaishoIchiran_Row row = new dgNinteiChosaIraiTaishoIchiran_Row();
                row.setNinteiChosaitakusaki(result.get認定調査委託先コード() == null
                        ? RString.EMPTY : result.get認定調査委託先コード().value());
                row.setNinteiChosaItakusakiMeisho(result.get事業者名称());
                row.setNinteiChosainNo(result.get認定調査員コード());
                row.setNinteiChosainShimei(result.get調査員氏名());
                row.getShinseishaNinzu().setValue(new Decimal(result.get申請者人数()));
                row.setShoKisaiHokenshaNo(result.get証記載保険者番号());
                rowList.add(row);
                if (count == div.getTxtChosaDispMax().getValue().intValue()) {
                    break;
                }
                count++;
            }
            div.getDgNinteiChosaIraiTaishoIchiran().getGridSetting().setLimitRowCount(div.getTxtChosaDispMax().getValue().intValue());
            div.getDgNinteiChosaIraiTaishoIchiran().setDataSource(rowList);
        }
        if (STATE_SHUJII.equals(div.getState())) {
            List<dgShujiiIkenshoSakuseiIraiTaishoIchiran_Row> rowList = new ArrayList<>();
            div.getDgShujiiIkenshoSakuseiIraiTaishoIchiran().getGridSetting().setSelectedRowCount(resultList.size());
            int count = 1;
            for (IraishoIkkatsuHakkoResult result : resultList) {
                dgShujiiIkenshoSakuseiIraiTaishoIchiran_Row row = new dgShujiiIkenshoSakuseiIraiTaishoIchiran_Row();
                row.setShujiiIryoKikanCode(result.get主治医医療機関コード());
                row.setShujiiIryoKikanMeisho(result.get医療機関名称());
                row.setIshiNo(result.get主治医コード());
                row.setIshiShimei(result.get主治医氏名() == null ? RString.EMPTY : result.get主治医氏名().value());
                row.getShinseishaNinzu().setValue(new Decimal(result.get申請者人数()));
                row.setShoKisaiHokenshaNo(result.get証記載保険者番号());
                rowList.add(row);
                if (count == div.getTxtIkenshoDispMax().getValue().intValue()) {
                    break;
                }
                count++;
            }
            div.getDgShujiiIkenshoSakuseiIraiTaishoIchiran().getGridSetting().setLimitRowCount(div.getTxtIkenshoDispMax().getValue().intValue());
            div.getDgShujiiIkenshoSakuseiIraiTaishoIchiran().setDataSource(rowList);
        }
    }

    /**
     * 共通日付txtの使用可否などを設定します。
     */
    public void setTxtKyotsuHizuke() {
        boolean is共通日付 = 依頼書期限ラジオボタン_共通.equals(div.getRadTeishutsuKigen().getSelectedKey());
        if (is共通日付) {
            RDate systemDate = RDate.getNowDate();
            RString 加算日数 = new RString("0");
            if (SELECTED_NINTEI_CHOSA.equals(div.getRadTaishoSentaku().getSelectedKey())) {
                加算日数 = DbBusinessConfig.get(ConfigNameDBE.認定調査期限日数, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
            } else if (SELECTED_SHUJII_IKENSHO.equals(div.getRadTaishoSentaku().getSelectedKey())) {
                加算日数 = DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成期限日数, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
            }
            systemDate = systemDate.plusDay(Integer.parseInt(加算日数.toString()));
            div.getTxtKyotsuHizuke().setValue(systemDate);
        } else {
            div.getTxtKyotsuHizuke().clearValue();
        }
        div.getTxtKyotsuHizuke().setReadOnly(!is共通日付);
    }

    /**
     * 条件をクリアするボタンの押す処理です。
     */
    public void clearJoken() {
        if (STATE_NINTEI.equals(div.getState())) {
            div.getTxtNinteiChosaIraibi().clearFromValue();
            div.getTxtNinteiChosaIraibi().clearToValue();
            List<RString> selectKeys = new ArrayList<>();
            selectKeys.add(COMMON_SELECTED);
            div.getChkNinteiChosaIraisho().setSelectedItemsByKey(selectKeys);
            div.getCcdNinteiChosaHokensha().loadHokenshaList(GyomuBunrui.介護認定);
            div.getChkNinteiChosahyo().setSelectedItemsByKey(selectKeys);
            div.getTxtChosaDispMax().clearValue();
            div.getTxtChosaDispMax().setValue(new Decimal(DbBusinessConfig
                    .get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
        }
        if (STATE_SHUJII.equals(div.getState())) {
            div.getTxtShujiiIkenshoSakuseiIraibi().clearFromValue();
            div.getTxtShujiiIkenshoSakuseiIraibi().clearToValue();
            List<RString> selectKeys = new ArrayList<>();
            selectKeys.add(COMMON_SELECTED);
            div.getChkShujiiikenshoSakuseiIrai().setSelectedItemsByKey(selectKeys);
            div.getCcdShujiiIkenshoHokensha().loadHokenshaList(GyomuBunrui.介護認定);
            div.getChkShujiiIkensho().setSelectedItemsByKey(selectKeys);
            div.getTxtIkenshoDispMax().clearValue();
            div.getTxtIkenshoDispMax().setValue(new Decimal(DbBusinessConfig
                    .get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
        }
    }

    private void initializeShujiiChkShinseiTani() {
        boolean is意見書依頼書出力 = is使用ByConfig(ConfigNameDBE.主治医意見書作成依頼_一括_作成依頼書_出力有無);
        boolean is記入用紙出力 = is使用ByConfig(ConfigNameDBE.主治医意見書作成依頼_一括_記入用紙_出力有無);
        boolean is請求書出力 = is使用ByConfig(ConfigNameDBE.主治医意見書作成依頼_一括_請求書_出力有無);
        boolean is連動印刷 = is使用ByConfig(ConfigNameDBE.主治医意見書作成請求書連動印刷);

        div.getChkIkenshoIraisho().setDisplayNone(!is意見書依頼書出力);
        div.getChkIkensho().setDisplayNone(!is記入用紙出力);
        div.getChkIkenshoSeikyusho().setDisplayNone(!is意見書依頼書出力);
        if (!is連動印刷) {
            div.getChkIkenshoSeikyusho().setDisplayNone(!is請求書出力);
        }
        if (div.getChkIkenshoSeikyusho().isDisplayNone()) {
            div.getChkIkenshoSeikyuIchiran().setLabelLText(div.getChkIkenshoSeikyusho().getLabelLText());
        }
    }

    private void setShujiiChkShinseiTani() {

        RDate 基準日 = RDate.getNowDate();
        RString 保険者市町村コード = div.getCcdShujiiIkenshoHokensha().getSelectedItem().get市町村コード().value();

        List<RString> 請求書選択selectedKeys = new ArrayList<>();
        RString 連動印刷 = DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成請求書連動印刷, 基準日, SubGyomuCode.DBE認定支援, 保険者市町村コード);
        if (!div.getChkIkenshoIraisho().isDisplayNone()) {
            List<RString> 意見書依頼書選択selectedKeys = new ArrayList<>();
            RString 初期選択_作成依頼書 = DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成依頼_初期選択_作成依頼書, 基準日, SubGyomuCode.DBE認定支援, 保険者市町村コード);
            if (依頼書選択_単票.equals(初期選択_作成依頼書)) {
                意見書依頼書選択selectedKeys.add(依頼書チェックボックス_単票);
                if (選択.equals(連動印刷)) {
                    請求書選択selectedKeys.add(意見書チェックボックス_請求書);
                }
            } else if (依頼書選択_一覧.equals(初期選択_作成依頼書)) {
                意見書依頼書選択selectedKeys.add(依頼書チェックボックス_一覧);
                if (選択.equals(連動印刷)) {
                    請求書選択selectedKeys.add(意見書チェックボックス_請求書);
                }
            }
            div.getChkIkenshoIraisho().setSelectedItemsByKey(意見書依頼書選択selectedKeys);
        }

        if (!div.getChkIkensho().isDisplayNone()) {
            List<RString> 意見書選択selectedKeys = new ArrayList<>();
            RString 初期選択_記入用紙 = DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成依頼_初期選択_記入用紙, 基準日, SubGyomuCode.DBE認定支援, 保険者市町村コード);
            if (選択.equals(初期選択_記入用紙)) {
                意見書選択selectedKeys.add(意見書チェックボックス_記入用紙);
            }
            div.getChkIkensho().setSelectedItemsByKey(意見書選択selectedKeys);
        }

        if (!div.getChkIkenshoSeikyusho().isDisplayNone()) {
            RString 初期選択_請求書 = DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成依頼_初期選択_請求書, 基準日, SubGyomuCode.DBE認定支援, 保険者市町村コード);
            if (選択.equals(初期選択_請求書)) {
                請求書選択selectedKeys.add(意見書チェックボックス_請求書);
            }
        }
        div.getChkIkenshoSeikyusho().setSelectedItemsByKey(請求書選択selectedKeys);

        List<RString> 請求一覧選択selectedKeys = new ArrayList<>();
        RString 初期選択_請求一覧表 = DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成依頼_初期選択_請求一覧表, 基準日, SubGyomuCode.DBE認定支援, 保険者市町村コード);
        if (選択.equals(初期選択_請求一覧表)) {
            請求一覧選択selectedKeys.add(意見書チェックボックス_請求一覧);
        }
        div.getChkIkenshoSeikyuIchiran().setSelectedItemsByKey(請求一覧選択selectedKeys);

        List<RString> 発行一覧選択selectedKeys = new ArrayList<>();
        RString 初期選択_発行一覧表 = DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成依頼_初期選択_発行一覧表, 基準日, SubGyomuCode.DBE認定支援, 保険者市町村コード);
        if (選択.equals(初期選択_発行一覧表)) {
            発行一覧選択selectedKeys.add(意見書チェックボックス_発行一覧);
        }
        div.getChkIkenshoHakkoIchiran().setSelectedItemsByKey(発行一覧選択selectedKeys);

        List<RString> 履歴一覧選択selectedKeys = new ArrayList<>();
        RString 初期選択_履歴一覧表 = DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成依頼_初期選択_履歴一覧表, 基準日, SubGyomuCode.DBE認定支援, 保険者市町村コード);
        if (選択.equals(初期選択_履歴一覧表)) {
            履歴一覧選択selectedKeys.add(意見書チェックボックス_履歴一覧);
        }
        div.getChkIkenshoRirekiIchiran().setSelectedItemsByKey(履歴一覧選択selectedKeys);
    }

    private void initializeNinteiChkShinseiTani() {
        boolean is依頼書出力 = is使用ByConfig(ConfigNameDBE.認定調査依頼_一括_調査依頼書_出力有無);
        boolean is概況基本出力 = is使用ByConfig(ConfigNameDBE.認定調査依頼_一括_認定調査票_概況基本_出力有無);
        boolean is特記事項出力 = is使用ByConfig(ConfigNameDBE.認定調査依頼_一括_認定調査票_特記事項_出力有無);
        boolean is差異チェック票出力 = is使用ByConfig(ConfigNameDBE.認定調査依頼_一括_差異チェック票_出力有無);
        boolean is委託等特記出力 = is使用ByConfig(ConfigNameDBE.認定調査依頼_一括_特記事項_出力有無);
        boolean is概要特記出力 = is使用ByConfig(ConfigNameDBE.認定調査票_概況特記_出力有無);
        RString 保険者市町村コード = div.getCcdShujiiIkenshoHokensha().getSelectedItem().get市町村コード().value();
        RString 印刷タイプ = DbBusinessConfig.get(ConfigNameDBE.認定調査票_印刷タイプ, RDate.getNowDate(), SubGyomuCode.DBE認定支援, 保険者市町村コード);

        div.getChkChosahyoIraisho().setDisplayNone(!is依頼書出力);
        List<RString> disableList = new ArrayList<>();
        if (片面印刷.equals(印刷タイプ)) {
            if (!is概況基本出力) {
                disableList.add(調査票チェックボックス_概況調査);
                disableList.add(調査票チェックボックス_基本調査);
            }
            if (!is特記事項出力) {
                disableList.add(調査票チェックボックス_特記事項);
            }
            if (disableList.size() == 3) {
                div.getChkChosahyoGaikyo().setLabelLText(div.getChkChosahyoKatamen().getLabelLText());
                div.getChkChosahyoKatamen().setDisplayNone(true);
            } else {
                div.getChkChosahyoKatamen().setDisabledItemsByKey(disableList);
            }
            div.getChkChosahyoRyomen().setDisplayNone(true);
        } else {
            if (!is概況基本出力) {
                disableList.add(調査票チェックボックス_概況調査);
            }
            if (!is特記事項出力) {
                disableList.add(調査票チェックボックス_特記事項);
            }
            div.getChkChosahyoKatamen().setDisplayNone(true);
            if (disableList.size() == 2) {
                div.getChkChosahyoGaikyo().setLabelLText(div.getChkChosahyoRyomen().getLabelLText());
                div.getChkChosahyoRyomen().setDisplayNone(true);
            } else {
                div.getChkChosahyoRyomen().setDisabledItemsByKey(disableList);
            }
        }
        div.getChkChosahyoGaikyo().setDisplayNone(!is概要特記出力);
        if (div.getChkChosahyoGaikyo().isDisplayNone()) {
            div.getChkChosahyoSai().setLabelLText(div.getChkChosahyoGaikyo().getLabelLText());
        }
        div.getChkChosahyoSai().setDisplayNone(!is差異チェック票出力);
        div.getChkChosahyoTokki().setDisplayNone(!is委託等特記出力);
    }

    private void setNinteiChkShinseiTani() {
        RDate 基準日 = RDate.getNowDate();
        RString 保険者市町村コード = div.getCcdShujiiIkenshoHokensha().getSelectedItem().get市町村コード().value();

        if (!div.getChkChosahyoIraisho().isDisplayNone()) {
            List<RString> 依頼書選択selectedKeys = new ArrayList<>();
            RString 初期選択_調査依頼書 = DbBusinessConfig.get(ConfigNameDBE.認定調査依頼_初期選択_調査依頼書, 基準日, SubGyomuCode.DBE認定支援, 保険者市町村コード);
            if (依頼書選択_単票.equals(初期選択_調査依頼書)) {
                依頼書選択selectedKeys.add(依頼書チェックボックス_単票);
            } else if (依頼書選択_一覧.equals(初期選択_調査依頼書)) {
                依頼書選択selectedKeys.add(依頼書チェックボックス_一覧);
            }
            div.getChkChosahyoIraisho().setSelectedItemsByKey(依頼書選択selectedKeys);
        }

        List<RString> 調査票選択selectedKeys = new ArrayList<>();
        boolean is概況基本出力 = is使用ByConfig(ConfigNameDBE.認定調査依頼_一括_認定調査票_概況基本_出力有無);
        boolean is特記事項出力 = is使用ByConfig(ConfigNameDBE.認定調査依頼_一括_認定調査票_特記事項_出力有無);
        RString 初期選択_概況基本 = DbBusinessConfig.get(ConfigNameDBE.認定調査依頼_初期選択_認定調査票_概況基本, 基準日, SubGyomuCode.DBE認定支援, 保険者市町村コード);
        RString 初期選択_特記事項 = DbBusinessConfig.get(ConfigNameDBE.認定調査依頼_初期選択_認定調査票_特記事項, 基準日, SubGyomuCode.DBE認定支援, 保険者市町村コード);
        if (!div.getChkChosahyoKatamen().isDisplayNone()) {
            if (is概況基本出力 && 選択.equals(初期選択_概況基本)) {
                調査票選択selectedKeys.add(調査票チェックボックス_概況調査);
                調査票選択selectedKeys.add(調査票チェックボックス_基本調査);
            }
            if (is特記事項出力 && 選択.equals(初期選択_特記事項)) {
                調査票選択selectedKeys.add(調査票チェックボックス_特記事項);
            }
            div.getChkChosahyoKatamen().setSelectedItemsByKey(調査票選択selectedKeys);
        } else if (!div.getChkChosahyoRyomen().isDisplayNone()) {
            if (is概況基本出力 && 選択.equals(初期選択_概況基本)) {
                調査票選択selectedKeys.add(調査票チェックボックス_概況調査);
            }
            if (is特記事項出力 && 選択.equals(初期選択_特記事項)) {
                調査票選択selectedKeys.add(調査票チェックボックス_特記事項);
            }
            div.getChkChosahyoRyomen().setSelectedItemsByKey(調査票選択selectedKeys);
        }

        if (!div.getChkChosahyoGaikyo().isDisplayNone()) {
            List<RString> 概況特記選択selectedKeys = new ArrayList<>();
            RString 初期選択_概況特記 = DbBusinessConfig.get(ConfigNameDBE.認定調査依頼_初期選択_概況特記, 基準日, SubGyomuCode.DBE認定支援, 保険者市町村コード);
            if (選択.equals(初期選択_概況特記)) {
                概況特記選択selectedKeys.add(調査票チェックボックス_概況特記);
            }
            div.getChkChosahyoGaikyo().setSelectedItemsByKey(概況特記選択selectedKeys);
        }

        if (!div.getChkChosahyoSai().isDisplayNone()) {
            List<RString> 差異チェック票選択selectedKeys = new ArrayList<>();
            RString 初期選択_差異チェック票 = DbBusinessConfig.get(ConfigNameDBE.認定調査依頼_初期選択_差異チェック票, 基準日, SubGyomuCode.DBE認定支援, 保険者市町村コード);
            if (選択.equals(初期選択_差異チェック票)) {
                差異チェック票選択selectedKeys.add(調査票チェックボックス_差異);
            }
            div.getChkChosahyoSai().setSelectedItemsByKey(差異チェック票選択selectedKeys);
        }

        List<RString> 発行一覧選択selectedKeys = new ArrayList<>();
        RString 初期選択_発行一覧 = DbBusinessConfig.get(ConfigNameDBE.認定調査依頼_初期選択_発行一覧表, 基準日, SubGyomuCode.DBE認定支援, 保険者市町村コード);
        if (選択.equals(初期選択_発行一覧)) {
            発行一覧選択selectedKeys.add(調査票チェックボックス_発行一覧);
        }
        div.getChkChosaIraiHakko().setSelectedItemsByKey(発行一覧選択selectedKeys);

        List<RString> 履歴一覧選択selectedKeys = new ArrayList<>();
        RString 初期選択_履歴一覧 = DbBusinessConfig.get(ConfigNameDBE.認定調査依頼_初期選択_履歴一覧表, 基準日, SubGyomuCode.DBE認定支援, 保険者市町村コード);
        if (選択.equals(初期選択_履歴一覧)) {
            履歴一覧選択selectedKeys.add(調査票チェックボックス_履歴一覧);
        }
        div.getChkChosaIraiRireki().setSelectedItemsByKey(履歴一覧選択selectedKeys);
    }

    private boolean is使用ByConfig(ConfigNameDBE key) {
        RDate 基準日 = RDate.getNowDate();
        RString 保険者市町村コード = div.getCcdShujiiIkenshoHokensha().getSelectedItem().get市町村コード().value();
        return DbBusinessConfig.get(key, 基準日, SubGyomuCode.DBE認定支援, 保険者市町村コード).equals(出力する);
    }

    private void setHakkobiAndTeishutsuKigen() {
        div.getTxtHakkobi().setValue(RDate.getNowDate());
        RString 依頼書期限設定 = DbBusinessConfig.get(ConfigNameDBE.依頼書期限設定, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        DbBusinessConfig.get(ConfigNameDBE.認定調査期限設定方法, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        if (依頼書期限設定.equals(依頼書期限設定_自動)) {
            div.getRadTeishutsuKigen().setSelectedKey(依頼書期限ラジオボタン_自動);
        } else if (依頼書期限設定.equals(依頼書期限設定_空欄)) {
            div.getRadTeishutsuKigen().setSelectedKey(依頼書期限ラジオボタン_空欄);
        } else if (依頼書期限設定.equals(依頼書期限設定_共通)) {
            div.getRadTeishutsuKigen().setSelectedKey(依頼書期限ラジオボタン_共通);
        } else {
            div.getRadTeishutsuKigen().setSelectedKey(COMMON_SELECTED);
        }
        div.getRadTeishutsuKigen().setDisabled(true);
        setTxtKyotsuHizuke();
    }

    public void setNinteParam(DBE220010_IraishoIkkatuParameter param) {

        if (div.getChkNinteiChosaIraisho().getSelectedKeys().size() == 2) {
            param.setNinteioChosaIraisho(PRINT_AND_NOPRINT);
        } else {
            if (div.getChkNinteiChosaIraisho().getSelectedKeys().contains(SELECTED_NOPRINT)) {
                param.setNinteioChosaIraisho(NO_PRINT);
            }
            if (div.getChkNinteiChosaIraisho().getSelectedKeys().contains(SELECTED_PRINT)) {
                param.setNinteioChosaIraisho(PRINT);
            }
        }

        if (div.getChkNinteiChosahyo().getSelectedKeys().size() == 2) {
            param.setNinteiChosahyo(PRINT_AND_NOPRINT);
        } else {
            if (div.getChkNinteiChosahyo().getSelectedKeys().contains(SELECTED_NOPRINT)) {
                param.setNinteiChosahyo(NO_PRINT);
            }
            if (div.getChkNinteiChosahyo().getSelectedKeys().contains(SELECTED_PRINT)) {
                param.setNinteiChosahyo(PRINT);
            }
        }

        List<GridParameter> ninteiChosaIraiList = new ArrayList<>();
        for (dgNinteiChosaIraiTaishoIchiran_Row row : div.getDgNinteiChosaIraiTaishoIchiran().getSelectedItems()) {
            GridParameter gridParameter = new GridParameter();
            gridParameter.setNinteichosaItakusakiCode(row.getNinteiChosaitakusaki());
            gridParameter.setNinteiChosainCode(row.getNinteiChosainNo());
            gridParameter.setShoKisaiHokenshaNo(row.getShoKisaiHokenshaNo());
            ninteiChosaIraiList.add(gridParameter);
        }
        param.setNinteiChosaIraiList(ninteiChosaIraiList);

        if (!div.getChkChosahyoIraisho().isDisplayNone()) {
            List<RString> 依頼書選択selectedKeys = div.getChkChosahyoIraisho().getSelectedKeys();
            param.set認定調査依頼書(依頼書選択selectedKeys.contains(依頼書チェックボックス_単票));
            param.set認定調査依頼一覧(依頼書選択selectedKeys.contains(依頼書チェックボックス_一覧));
        } else {
            param.set認定調査依頼一覧(false);
            param.set認定調査依頼書(false);
        }

        List<RString> 調査票選択selectedKeys;
        if (!div.getChkChosahyoKatamen().isDisplayNone()) {
            調査票選択selectedKeys = div.getChkChosahyoKatamen().getSelectedKeys();
            param.set認定調査票_概況調査(調査票選択selectedKeys.contains(調査票チェックボックス_概況調査));
            param.set認定調査票_基本調査(調査票選択selectedKeys.contains(調査票チェックボックス_基本調査));
            param.set認定調査票_特記事項(調査票選択selectedKeys.contains(調査票チェックボックス_特記事項));
            param.set認定調査票_概況基本(false);
        } else if (!div.getChkChosahyoRyomen().isDisplayNone()) {
            調査票選択selectedKeys = div.getChkChosahyoRyomen().getSelectedKeys();
            param.set認定調査票_概況調査(false);
            param.set認定調査票_基本調査(false);
            param.set認定調査票_概況基本(調査票選択selectedKeys.contains(調査票チェックボックス_概況調査));
            param.set認定調査票_特記事項(調査票選択selectedKeys.contains(調査票チェックボックス_特記事項));
        } else {
            param.set認定調査票_概況調査(false);
            param.set認定調査票_基本調査(false);
            param.set認定調査票_概況基本(false);
            param.set認定調査票_特記事項(false);
        }

        if (!div.getChkChosahyoGaikyo().isDisplayNone()) {
            List<RString> 概況特記選択selectedKeys = div.getChkChosahyoGaikyo().getSelectedKeys();
            param.set認定調査票_概況特記(概況特記選択selectedKeys.contains(調査票チェックボックス_概況特記));
        } else {
            param.set認定調査票_概況特記(false);
        }

        if (!div.getChkChosahyoSai().isDisplayNone()) {
            List<RString> 差異チェック票選択selectedKeys = div.getChkChosahyoSai().getSelectedKeys();
            param.set認定調査差異チェック票(差異チェック票選択selectedKeys.contains(調査票チェックボックス_差異));
        } else {
            param.set認定調査差異チェック票(false);
        }

        if (!div.getChkChosahyoTokki().isDisplayNone()) {
            List<RString> 委託特記事項選択selectedKeys = div.getChkChosahyoTokki().getSelectedKeys();
            param.set特記事項_調査群(委託特記事項選択selectedKeys.contains(調査票チェックボックス_特記事項_調査群));
            param.set特記事項_フリータイプ(委託特記事項選択selectedKeys.contains(調査票チェックボックス_特記事項_フリー));
        } else {
            param.set特記事項_調査群(false);
            param.set特記事項_フリータイプ(false);
        }

        List<RString> 発行一覧選択selectedKeys = div.getChkChosaIraiHakko().getSelectedKeys();
        param.set認定調査依頼発行一覧(発行一覧選択selectedKeys.contains(調査票チェックボックス_発行一覧));

        List<RString> 履歴一覧選択selectedKeys = div.getChkChosaIraiRireki().getSelectedKeys();
        param.set認定調査依頼履歴一覧(履歴一覧選択selectedKeys.contains(調査票チェックボックス_履歴一覧));
    }

    public void setShujiiParam(DBE220010_IraishoIkkatuParameter param) {

        if (div.getChkShujiiikenshoSakuseiIrai().getSelectedKeys().size() == 2) {
            param.setShujiiikenshoSakuseiIrai(PRINT_AND_NOPRINT);
        } else {
            if (div.getChkShujiiikenshoSakuseiIrai().getSelectedKeys().contains(SELECTED_NOPRINT)) {
                param.setShujiiikenshoSakuseiIrai(NO_PRINT);
            }
            if (div.getChkShujiiikenshoSakuseiIrai().getSelectedKeys().contains(SELECTED_PRINT)) {
                param.setShujiiikenshoSakuseiIrai(PRINT);
            }
        }

        if (div.getChkShujiiIkensho().getSelectedKeys().size() == 2) {
            param.setShujiiIkensho(PRINT_AND_NOPRINT);
        } else {
            if (div.getChkShujiiIkensho().getSelectedKeys().contains(SELECTED_NOPRINT)) {
                param.setShujiiIkensho(NO_PRINT);
            }
            if (div.getChkShujiiIkensho().getSelectedKeys().contains(SELECTED_PRINT)) {
                param.setShujiiIkensho(PRINT);
            }
        }

        List<GridParameter> shujiiIkenshoSakuseiIraiList = new ArrayList<>();
        for (dgShujiiIkenshoSakuseiIraiTaishoIchiran_Row row : div.getDgShujiiIkenshoSakuseiIraiTaishoIchiran().getSelectedItems()) {
            GridParameter gridParameter = new GridParameter();
            gridParameter.setShujiiIryoKikanCode(row.getShujiiIryoKikanCode());
            gridParameter.setIshiNo(row.getIshiNo());
            gridParameter.setShoKisaiHokenshaNo(row.getShoKisaiHokenshaNo());
            shujiiIkenshoSakuseiIraiList.add(gridParameter);
        }
        param.setShujiiIkenshoSakuseiIraiList(shujiiIkenshoSakuseiIraiList);

        if (!div.getChkIkenshoIraisho().isDisplayNone()) {
            List<RString> 依頼書選択selectedKeys = div.getChkIkenshoIraisho().getSelectedKeys();
            param.setShujiiIkenshoSakuseiIraisho(依頼書選択selectedKeys.contains(依頼書チェックボックス_単票));
            param.setIkenshoSakuseiIraiIchiran(依頼書選択selectedKeys.contains(依頼書チェックボックス_一覧));
        } else {
            param.set認定調査依頼一覧(false);
            param.set認定調査依頼書(false);
        }

        if (!div.getChkIkensho().isDisplayNone()) {
            List<RString> 意見書選択selectedKeys = div.getChkIkensho().getSelectedKeys();
            param.setIkenshoKinyu(意見書選択selectedKeys.contains(意見書チェックボックス_記入用紙));
        } else {
            param.setIkenshoKinyu(false);
        }

        if (!div.getChkIkenshoSeikyusho().isDisplayNone()) {
            List<RString> 請求書選択selectedKeys = div.getChkIkenshoSeikyusho().getSelectedKeys();
            param.setIkenshoSakuseiSeikyusho(請求書選択selectedKeys.contains(意見書チェックボックス_請求書));
        } else {
            param.setIkenshoSakuseiSeikyusho(false);
        }

        List<RString> 請求一覧選択selectedKeys = div.getChkIkenshoSeikyuIchiran().getSelectedKeys();
        param.setIkenshoSakuseiSeikyuIchiran(請求一覧選択selectedKeys.contains(意見書チェックボックス_請求一覧));

        List<RString> 発行一覧選択selectedKeys = div.getChkIkenshoHakkoIchiran().getSelectedKeys();
        param.setIkenshoSakuseiHakkoIchiran(発行一覧選択selectedKeys.contains(意見書チェックボックス_発行一覧));

        List<RString> 履歴一覧選択selectedKeys = div.getChkIkenshoRirekiIchiran().getSelectedKeys();
        param.setIkenshoSakuseiRirekiIchiran(履歴一覧選択selectedKeys.contains(意見書チェックボックス_履歴一覧));
    }

    /**
     * 介護保険診断命令書 チェックボックスの表示制御処理です。
     */
    public void setChkIkenshoIraisho() {
        RString 請求書連動印刷 = DbBusinessConfig.get(
                ConfigNameDBE.主治医意見書作成請求書連動印刷, RDate.getNowDate(), SubGyomuCode.DBE認定支援, div.getCcdShujiiIkenshoHokensha().getSelectedItem().get市町村コード().value());
        if (CONFIGVALUE1.equals(請求書連動印刷)) {
            List<RString> 意見書依頼書選択selectedKeys = new ArrayList<>();
            div.getChkIkenshoIraisho().setSelectedItemsByKey(意見書依頼書選択selectedKeys);
        }
    }

    /**
     * 介護保険診断命令書 チェックボックスの表示制御処理です。
     */
    public void setChkIkenshoSeikyusho() {
        List<RString> 請求書選択selectedKeys = new ArrayList<>();
        RString 請求書連動印刷 = DbBusinessConfig.get(
                ConfigNameDBE.主治医意見書作成請求書連動印刷, RDate.getNowDate(), SubGyomuCode.DBE認定支援, div.getCcdShujiiIkenshoHokensha().getSelectedItem().get市町村コード().value());
        if (CONFIGVALUE1.equals(請求書連動印刷)) {
            if (!div.getChkIkenshoIraisho().getSelectedKeys().isEmpty()) {
                請求書選択selectedKeys.add(意見書チェックボックス_請求書);
            }
            div.getChkIkenshoSeikyusho().setSelectedItemsByKey(請求書選択selectedKeys);
        }
    }
}
