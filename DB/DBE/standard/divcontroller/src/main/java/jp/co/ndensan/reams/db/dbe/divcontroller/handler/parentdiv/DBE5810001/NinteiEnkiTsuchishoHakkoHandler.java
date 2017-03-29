/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5810001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninteienkitsuchishohakko.DgHakkotaishoshaRow;
import jp.co.ndensan.reams.db.dbe.business.core.ninteienkitsuchishohakko.NinteiEnkiTsuchishoHakkoBusiness;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE581001.DBE581001_EnkitsuchiParameter;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import static jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5810001.DBE5810001StateName.検索;
import static jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5810001.DBE5810001StateName.通知書;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5810001.NinteiEnkiTsuchishoHakkoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5810001.dgHakkotaishosha_Row;
import jp.co.ndensan.reams.db.dbe.service.core.ninteienkitsuchishohakko.NinteiEnkiTsuchishoHakkoManager;
import jp.co.ndensan.reams.db.dbx.business.core.basic.KaigoDonyuKeitai;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiShinseiJohoDbT5101Child;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.service.core.kaigiatesakijushosettei.KaigoAtesakiJushoSetteiFinder;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 認定延期通知発行画面のHandlerクラスです。
 *
 * @reamsid_L DBD-1410-010 wangjie2
 */
public class NinteiEnkiTsuchishoHakkoHandler {

    private final RString 含む_key = new RString("key0");
    private final RString 印刷する_key = new RString("key0");
    private final RString 印刷しない_key = new RString("key1");
    private final RString 変更フラグ_変更 = new RString("1");
    private final RString 一覧表を発行する_FileName = new RString("btnPrint1");
    private final RString 保存処理完了Message = new RString("認定延期通知発行の保存処理が完了しました。");
    private final RString 画面モード_1 = new RString("1");
    private final RString 画面モード_2 = new RString("2");
    private static final Code CODE_0003 = new Code("0003");
    private static final RString NAME_被保険者番号 = new RString("被保険者番号");
    private static final RString 帳票分類ID = new RString("DBE581001_YokaigoNinteiEnkiTshuchisho");

    private final NinteiEnkiTsuchishoHakkoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 認定延期通知発行のコントロールdiv
     */
    public NinteiEnkiTsuchishoHakkoHandler(NinteiEnkiTsuchishoHakkoDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     */
    public void onLoad() {
        clear検索条件();
        RString 経過日数 = DbBusinessConfig.get(ConfigNameDBE.経過日数, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        if (!経過日数.isNullOrEmpty()) {
            div.getTxtKeikaNissu().setValue(new Decimal(経過日数.toString()));
        }
        List<RString> 延期の理由 = NinteiEnkiTsuchishoHakkoManager.createInstance().get延期の理由();
        List<KeyValueDataSource> 延期の理由DataSource = new ArrayList<>();
        int key = 1;
        for (RString 延期理由 : 延期の理由) {
            延期の理由DataSource.add(new KeyValueDataSource(new RString(key), 延期理由));
            key++;
        }
        div.getDdlEnkiRiyu().setDataSource(延期の理由DataSource);
        div.getDdlEnkiRiyuInput().setDataSource(延期の理由DataSource);
        if (!延期の理由DataSource.isEmpty()) {
            div.getDdlEnkiRiyu().setSelectedIndex(0);
            div.getDdlEnkiRiyuInput().setSelectedIndex(0);
        }
        RString 最大表示件数 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        if (!最大表示件数.isNullOrEmpty()) {
            div.getTxtMaxDisp().setValue(new Decimal(最大表示件数.toString()));
            div.getDgHakkotaishosha().getGridSetting().setLimitRowCount(div.getTxtMaxDisp().getValue().intValue());
        }
        div.getCcdHokenshaList().loadHokenshaList(GyomuBunrui.介護認定);
        div.getTxtInsatsuDate().setValue(RDate.getNowDate());
        CommonButtonHolder.setDisabledByCommonButtonFieldName(一覧表を発行する_FileName, true);

        KaigoAtesakiJushoSetteiFinder finader = KaigoAtesakiJushoSetteiFinder.createInstance();
        List<KaigoDonyuKeitai> 介護導入形態 = finader.select介護導入形態().records();
        ReportId 帳票ID = ReportIdDBE.DBE581001.getReportId();
        RString 証記載保険者番号 = div.getCcdHokenshaList().getSelectedItem().get証記載保険者番号().value();
        for (KaigoDonyuKeitai item : 介護導入形態) {
            if (GyomuBunrui.介護認定.equals(item.get業務分類()) && DonyuKeitaiCode.認定広域.equals(item.get導入形態コード())
                    && 証記載保険者番号 != null && !証記載保険者番号.isEmpty()) {
                RStringBuilder 帳票IDBuilder = new RStringBuilder();
                帳票IDBuilder.append(帳票ID.value()).append(new RString("_")).append(証記載保険者番号);
                帳票ID = new ReportId(帳票IDBuilder.toRString());
            }
        }

        div.getCcdNinteiEnkiTsuchishoBunshoBango().initialize(帳票ID);

//        div.getCcdNinteiEnkiTsuchishoBunshoBango().initialize(new ReportId(帳票分類ID));
    }

    private void clear検索条件() {
        List<RString> emptyKeys = new ArrayList<>();
        div.getCblShinseiKubun().setSelectedItemsByKey(emptyKeys);
        div.getCblHakkoUmu().setSelectedItemsByKey(emptyKeys);
        div.getRadMinashiNigo().setSelectedKey(含む_key);
        div.getTxtKeikaNissu().clearValue();
        div.getTxtMikomiDate().clearFromValue();
        div.getTxtMikomiDate().clearToValue();
        List<KeyValueDataSource> emptyDataSource = new ArrayList<>();
        div.getDdlEnkiRiyu().setDataSource(emptyDataSource);
        div.getCblNinteiChosa().setSelectedItemsByKey(emptyKeys);
        div.getCblIkenshoJyuryo().setSelectedItemsByKey(emptyKeys);
        div.getCblIchijiHantei().setSelectedItemsByKey(emptyKeys);
        div.getCblShinsakaiWaritsuke().setSelectedItemsByKey(emptyKeys);
        div.getTxtMaxDisp().clearValue();
        div.getRadEnkiTsuchiHakkoIchiranhyo().setSelectedKey(印刷しない_key);
        div.getTxtMikomiDateIchiran().clearFromValue();
        div.getTxtMikomiDateIchiran().clearToValue();
        div.getTxtInsatsuDate().clearValue();
        div.getDdlEnkiRiyuInput().setDataSource(emptyDataSource);
    }

    /**
     * 発行対象者一覧情報取得です。
     *
     * @return 発行対象者一覧情報
     */
    public List<NinteiEnkiTsuchishoHakkoBusiness> 発行対象者一覧情報取得() {
        int 経過日数 = 0;
        if (div.getTxtKeikaNissu().getValue() != null) {
            経過日数 = div.getTxtKeikaNissu().getValue().intValue();
        }
        List<RString> 申請区分KeyList = div.getCblShinseiKubun().getSelectedKeys();
        List<RString> 発行有無KeyList = div.getCblHakkoUmu().getSelectedKeys();
        RString みなし２号Key = div.getRadMinashiNigo().getSelectedKey();
        RDate 処理見込み日From = div.getTxtMikomiDate().getFromValue();
        RDate 処理見込み日To = div.getTxtMikomiDate().getToValue();
        RString 延期の理由 = div.getDdlEnkiRiyu().getSelectedValue();
        LasdecCode 市町村コード = null;
        if (div.getCcdHokenshaList().getSelectedItem() != null) {
            市町村コード = div.getCcdHokenshaList().getSelectedItem().get市町村コード();
        }
        List<RString> 認定調査KeyList = div.getCblNinteiChosa().getSelectedKeys();
        List<RString> 意見書受領KeyList = div.getCblIkenshoJyuryo().getSelectedKeys();
        List<RString> 一次判定KeyList = div.getCblIchijiHantei().getSelectedKeys();
        List<RString> 審査会割付KeyList = div.getCblShinsakaiWaritsuke().getSelectedKeys();
        return NinteiEnkiTsuchishoHakkoManager.createInstance().get発行対象者一覧情報(経過日数,
                申請区分KeyList, 発行有無KeyList, みなし２号Key, 処理見込み日From, 処理見込み日To, 延期の理由,
                市町村コード, 認定調査KeyList, 意見書受領KeyList, 一次判定KeyList, 審査会割付KeyList);
    }

    /**
     * 発行対象者一覧情報より通知書モード表示します。
     *
     * @param 発行対象者一覧情報 発行対象者一覧情報
     */
    public void 通知書モード表示(List<NinteiEnkiTsuchishoHakkoBusiness> 発行対象者一覧情報) {
        List<dgHakkotaishosha_Row> dataSourceList = new ArrayList<>();
        List<RString> 被保番号List = new ArrayList<>();
        int maxSearchRowCnt = 0 ;
        for (NinteiEnkiTsuchishoHakkoBusiness 発行対象者情報 : 発行対象者一覧情報) {
            if (maxSearchRowCnt >= div.getTxtMaxDisp().getValue().intValue()){
                break;
            }
            dataSourceList.add(getDataSource(発行対象者情報));
            被保番号List.add(発行対象者情報.get被保番号());
            maxSearchRowCnt++;
        }
        if (div.getTxtMaxDisp().getValue() != null) {
            div.getDgHakkotaishosha().getGridSetting().setLimitRowCount(div.getTxtMaxDisp().getValue().intValue());
            div.getDgHakkotaishosha().getGridSetting().setSelectedRowCount(発行対象者一覧情報.size());
        }
        div.getDgHakkotaishosha().setDataSource(dataSourceList);
        div.getTxtnkiKetteiDate().setValue(RDate.getNowDate());
        div.getTxtTsuchishoHakkoDate().setValue(RDate.getNowDate());
        div.getTxtMikomiDateTsuchisho().clearFromValue();
        div.getTxtMikomiDateTsuchisho().clearToValue();
    }

    private dgHakkotaishosha_Row getDataSource(NinteiEnkiTsuchishoHakkoBusiness 発行対象者情報) {
        dgHakkotaishosha_Row dataSource = new dgHakkotaishosha_Row();
        dataSource.setShinseishokanrino(発行対象者情報.get申請書管理番号());
        dataSource.setHokensha(発行対象者情報.get保険者名());
        dataSource.setHihokenshano(発行対象者情報.get被保番号());
        dataSource.setHihokenshaname(発行対象者情報.get氏名());
        dataSource.setNinteishinseiymd(getTextBoxDate(発行対象者情報.get認定申請年月日()));
        if (発行対象者情報.get申請区分_申請時_コード() != null && !発行対象者情報.get申請区分_申請時_コード().isEmpty()) {
            dataSource.setShinseikubun(NinteiShinseiShinseijiKubunCode
                    .toValue(発行対象者情報.get申請区分_申請時_コード().getColumnValue()).get名称());
        }
        dataSource.setEnkiketteidate(getTextBoxDate(発行対象者情報.get延期決定日()));
        dataSource.setHiddenenKiketteidate(flexibleDateToRString(発行対象者情報.get延期決定日()));
        dataSource.setEnkiriyu(発行対象者情報.get延期理由());
        dataSource.setHiddenEnkiriyu(発行対象者情報.get延期理由());
        if (発行対象者情報.get通知書発行日() != null) {
            dataSource.setTsuchishohakkoymd(getTextBoxDate(発行対象者情報.get通知書発行日()));
            dataSource.setHiddenTsuchishohakkoymd(flexibleDateToRString(発行対象者情報.get通知書発行日()));
        }
        dataSource.setEnkikaisu(new RString(発行対象者情報.get延期回数()));
        dataSource.setMikomishorikikanfrom(getTextBoxDate(発行対象者情報.get延期見込み期間開始日()));
        dataSource.setHiddenMikomishorikikanfrom(flexibleDateToRString(発行対象者情報.get延期見込み期間開始日()));
        dataSource.setMikomishorikikanto(getTextBoxDate(発行対象者情報.get延期見込み期間終了日()));
        dataSource.setHiddenMikomishorikikanto(flexibleDateToRString(発行対象者情報.get延期見込み期間終了日()));
        if (発行対象者情報.get調査実施日() != null) {
            dataSource.setChosajissiymd(getTextBoxDate(発行対象者情報.get調査実施日()));
        }
        if (発行対象者情報.get意見書受領日() != null) {
            dataSource.setIkenshojyuryoymd(getTextBoxDate(発行対象者情報.get意見書受領日()));
        }
        if (発行対象者情報.get一次判定日() != null) {
            dataSource.setIchijihanteiymd(getTextBoxDate(発行対象者情報.get一次判定日()));
        }
        if (発行対象者情報.get審査会予定日() != null) {
            dataSource.setShinsakaiyoteiymd(getTextBoxDate(発行対象者情報.get審査会予定日()));
        }
        return dataSource;
    }

    /**
     * 発行対象者一覧情報より要介護認定申請情報情報を取得します。
     *
     * @param 発行対象者一覧情報 発行対象者一覧情報
     * @return 要介護認定申請情報
     */
    public List<NinteiShinseiJohoDbT5101Child> get要介護認定申請情報(List<NinteiEnkiTsuchishoHakkoBusiness> 発行対象者一覧情報) {

        List<RString> 申請書管理番号List = new ArrayList<>();
        for (NinteiEnkiTsuchishoHakkoBusiness 発行対象者情報 : 発行対象者一覧情報) {
            申請書管理番号List.add(発行対象者情報.get申請書管理番号());
        }
        return NinteiEnkiTsuchishoHakkoManager.createInstance().get要介護認定申請情報(申請書管理番号List);
    }

    /**
     * 対象行延期理由をセットします。
     *
     */
    public void 対象行延期理由のセット() {
        RString 延期理由 = div.getDdlEnkiRiyuInput().getSelectedValue();
        List<dgHakkotaishosha_Row> rowList = div.getDgHakkotaishosha().getDataSource();
        List<dgHakkotaishosha_Row> selectedRowList = div.getDgHakkotaishosha().getSelectedItems();
        for (int index = 0; index < rowList.size(); index++) {
            if (selectedRowList.contains(rowList.get(index))) {
                rowList.get(index).setEnkiriyu(延期理由);
                if (is変更(延期理由, rowList.get(index))) {
                    rowList.get(index).setChangeflag(変更フラグ_変更);
                } else {
                    rowList.get(index).setChangeflag(RString.EMPTY);
                }
            }
        }
        for (int index = 0; index < selectedRowList.size(); index++) {
            selectedRowList.get(index).setEnkiriyu(延期理由);
            if (is変更(延期理由, selectedRowList.get(index))) {
                selectedRowList.get(index).setChangeflag(変更フラグ_変更);
            } else {
                selectedRowList.get(index).setChangeflag(RString.EMPTY);
            }
        }
        div.getDgHakkotaishosha().setDataSource(rowList);
        div.getDgHakkotaishosha().setSelectedItems(selectedRowList);
    }

    private boolean is変更(RString 延期理由, dgHakkotaishosha_Row row) {
        return !isEquals(延期理由, row.getHiddenEnkiriyu())
                || !isEquals(row.getHiddenenKiketteidate(), row.getEnkiketteidate().getValue())
                || !isEquals(row.getHiddenTsuchishohakkoymd(), row.getTsuchishohakkoymd().getValue())
                || !isEquals(row.getHiddenMikomishorikikanfrom(), row.getMikomishorikikanfrom().getValue())
                || !isEquals(row.getHiddenMikomishorikikanto(), row.getMikomishorikikanto().getValue());
    }

    private boolean isEquals(RString value1, RString value2) {
        if (null == value1 || value1.isEmpty()) {
            return null == value2 || value2.isEmpty();
        }
        return value1.equals(value2);
    }

    /**
     * 発行対象者一覧に戻るを表示します。
     *
     * @return 要介護認定申請情報
     */
    public List<NinteiShinseiJohoDbT5101Child> 発行対象者一覧に戻るを表示() {
        List<RString> 申請書管理番号List = new ArrayList<>();
        List<dgHakkotaishosha_Row> selectedRowList = div.getDgHakkotaishosha().getSelectedItems();
        List<dgHakkotaishosha_Row> rowList = div.getDgHakkotaishosha().getDataSource();
        getRowListByChangeflag(rowList, 申請書管理番号List);
        getRowListByChangeflag(selectedRowList);
        div.getDgHakkotaishosha().setDataSource(rowList);
        div.getDgHakkotaishosha().setSelectedItems(selectedRowList);
        return NinteiEnkiTsuchishoHakkoManager.createInstance().get要介護認定申請情報(申請書管理番号List);
    }

    private void getRowListByChangeflag(List<dgHakkotaishosha_Row> rowList, List<RString> 申請書管理番号List) {
        for (int index = 0; index < rowList.size(); index++) {
            申請書管理番号List.add(rowList.get(index).getShinseishokanrino());
            rowList.get(index).setChangeflag(RString.EMPTY);
        }
    }

    private void getRowListByChangeflag(List<dgHakkotaishosha_Row> rowList) {
        for (int index = 0; index < rowList.size(); index++) {
            rowList.get(index).setChangeflag(RString.EMPTY);
        }
    }

    /**
     * 選択状態を制御します。
     *
     */
    public void 選択状態の制御() {
        dgHakkotaishosha_Row row = div.getDgHakkotaishosha().getActiveRow();
        List<dgHakkotaishosha_Row> rowList = div.getDgHakkotaishosha().getSelectedItems();
        if (div.getDgHakkotaishosha().getActiveRow().getSelected()) {
            rowList.remove(row);
        } else {
            rowList.add(row);
        }
        div.getDgHakkotaishosha().setSelectedItems(rowList);
    }

    /**
     * 延期内容をクリアします。
     *
     */
    public void 延期内容クリア() {
        div.getTxtMikomiDateTsuchisho().clearFromValue();
        div.getTxtMikomiDateTsuchisho().clearToValue();
        div.getTxtnkiKetteiDate().setValue(RDate.getNowDate());
        div.getTxtTsuchishoHakkoDate().setValue(RDate.getNowDate());
    }

    private TextBoxDate getTextBoxDate(FlexibleDate date) {
        TextBoxDate textBoxDate = new TextBoxDate();
        if (date != null && !date.isEmpty()) {
            textBoxDate.setValue(new RDate(date.toString()));
        }
        return textBoxDate;
    }

    private RString flexibleDateToRString(FlexibleDate date) {
        if (date != null && !date.isEmpty()) {
            return new RString(date.toString());
        }
        return RString.EMPTY;
    }

    private TextBoxDate getTextBoxDate(RDate date) {
        TextBoxDate textBoxDate = new TextBoxDate();
        if (date != null) {
            textBoxDate.setValue(date);
        }
        return textBoxDate;
    }

    /**
     * 対象行延期内容を更新します。
     *
     */
    public void 対象行延期内容の更新() {
        List<dgHakkotaishosha_Row> rowList = div.getDgHakkotaishosha().getDataSource();
        List<dgHakkotaishosha_Row> selectedRowList = div.getDgHakkotaishosha().getSelectedItems();
        List<dgHakkotaishosha_Row> newRowList = new ArrayList<>();
        List<dgHakkotaishosha_Row> newSelectedRowList = new ArrayList<>();
        for (dgHakkotaishosha_Row row : rowList) {
            if (is対象行Selected(row, selectedRowList)) {
                dgHakkotaishosha_Row newRow = get延期内容の更新(row);
                newSelectedRowList.add(newRow);
                newRowList.add(newRow);
            } else {
                newRowList.add(row);
            }
        }
        div.getDgHakkotaishosha().setDataSource(newRowList);
        div.getDgHakkotaishosha().setSelectedItems(newSelectedRowList);
    }

    private dgHakkotaishosha_Row get延期内容の更新(dgHakkotaishosha_Row row) {
        RString 変更フラグ = RString.EMPTY;
        if (is延期内容更新(row)) {
            変更フラグ = 変更フラグ_変更;
        }
        return new dgHakkotaishosha_Row(row.getRiyuselect(), row.getHokenshano(), row.getHokensha(), row.getHihokenshano(),
                row.getHihokenshaname(), row.getNinteishinseiymd(), row.getShinseikubun(), div.getTxtnkiKetteiDate(), row.getEnkiriyu(),
                div.getTxtTsuchishoHakkoDate(), row.getEnkikaisu(), getTextBoxDate(div.getTxtMikomiDateTsuchisho().getFromValue()),
                getTextBoxDate(div.getTxtMikomiDateTsuchisho().getToValue()), row.getChosajissiymd(), row.getIkenshojyuryoymd(),
                row.getIchijihanteiymd(), row.getShinsakaiyoteiymd(), row.getShinseishokanrino(), 変更フラグ, row.getHiddenEnkiriyu(),
                row.getHiddenenKiketteidate(), row.getHiddenTsuchishohakkoymd(), row.getHiddenMikomishorikikanfrom(), row.getHiddenMikomishorikikanto());
    }

    private boolean is延期内容更新(dgHakkotaishosha_Row row) {
        return !isEquals(row.getHiddenEnkiriyu(), row.getEnkiriyu())
                || !isEquals(row.getHiddenenKiketteidate(), div.getTxtnkiKetteiDate().getValue())
                || !isEquals(row.getHiddenTsuchishohakkoymd(), div.getTxtTsuchishoHakkoDate().getValue())
                || !isEquals(row.getHiddenMikomishorikikanfrom(), div.getTxtMikomiDateTsuchisho().getFromValue())
                || !isEquals(row.getHiddenMikomishorikikanto(), div.getTxtMikomiDateTsuchisho().getToValue());
    }

    private boolean isEquals(RString value1, RDate value2) {
        if (null == value2) {
            return null == value1 || value1.isEmpty();
        }
        return value2.toDateString().equals(value1);
    }

    private boolean is対象行Selected(dgHakkotaishosha_Row row, List<dgHakkotaishosha_Row> selectedRowList) {
        for (dgHakkotaishosha_Row selectedRow : selectedRowList) {
            if (row.getShinseishokanrino().equals(selectedRow.getShinseishokanrino())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 対象行延期内容を更新します。
     *
     */
    public void 一覧表を発行するボタンの制御() {
        CommonButtonHolder.setDisabledByCommonButtonFieldName(一覧表を発行する_FileName,
                !印刷する_key.equals(div.getRadEnkiTsuchiHakkoIchiranhyo().getSelectedKey()));
    }

    /**
     * 更新処理します。
     *
     * @param 要介護認定申請情報List 要介護認定申請情報List
     */
    public void 更新処理(List<NinteiShinseiJohoDbT5101Child> 要介護認定申請情報List) {
        List<dgHakkotaishosha_Row> rowList = div.getDgHakkotaishosha().getSelectedItems();
        List<DgHakkotaishoshaRow> rowEntityList = new ArrayList<>();
        for (dgHakkotaishosha_Row row : rowList) {
            DgHakkotaishoshaRow rowEntity = getRowEntity(row);
            if (rowEntity != null) {
                rowEntityList.add(rowEntity);
            }
        }
        NinteiEnkiTsuchishoHakkoManager.createInstance().更新処理(要介護認定申請情報List, rowEntityList);
        div.getCcdKanryoMessage().setMessage(保存処理完了Message, RString.EMPTY, RString.EMPTY, RString.EMPTY, true);
    }

    private DgHakkotaishoshaRow getRowEntity(dgHakkotaishosha_Row row) {
        if (!変更フラグ_変更.equals(row.getChangeflag())) {
            return null;
        }
        DgHakkotaishoshaRow rowEntity = new DgHakkotaishoshaRow();
        rowEntity.set申請書管理番号(row.getShinseishokanrino());
        rowEntity.set延期決定日(row.getEnkiketteidate().getValue());
        rowEntity.set延期理由(row.getEnkiriyu());
        rowEntity.set見込処理期間_終了(row.getMikomishorikikanto().getValue());
        rowEntity.set見込処理期間_開始(row.getMikomishorikikanfrom().getValue());
        rowEntity.set通知書発行日(row.getTsuchishohakkoymd().getValue());
        return rowEntity;

    }

    /**
     * バッチパラメータを設定します。
     *
     * @return バッチパラメータ
     */
    public DBE581001_EnkitsuchiParameter getバッチパラメータ() {
        DBE581001_EnkitsuchiParameter parameter = new DBE581001_EnkitsuchiParameter();
        List<FlexibleDate> 通知書発行日List = new ArrayList<>();
        if (検索.getName().equals(ResponseHolder.getState())) {
            parameter.set画面モード(画面モード_1);
            if (div.getTxtMikomiDateIchiran().getFromValue() != null) {
                parameter.set処理見込み日From(new FlexibleDate(div.getTxtMikomiDateIchiran().getFromValue().toDateString()));
            }
            if (div.getTxtMikomiDateIchiran().getToValue() != null) {
                parameter.set処理見込み日To(new FlexibleDate(div.getTxtMikomiDateIchiran().getToValue().toDateString()));
            }
            if (div.getTxtInsatsuDate().getValue() != null) {
                通知書発行日List.add(new FlexibleDate(div.getTxtInsatsuDate().getValue().toDateString()));
                parameter.set通知書発行日(通知書発行日List);
            }
            RString 文書番号 = div.getCcdNinteiEnkiTsuchishoBunshoBango().get文書番号();
            if (!文書番号.equals(RString.EMPTY)){
                parameter.set文書番号(文書番号);
            }else{
                parameter.set文書番号(RString.EMPTY);
            }
            
        } else if (通知書.getName().equals(ResponseHolder.getState())) {
            parameter.set画面モード(画面モード_2);
            parameter.set申請書管理番号リスト(get申請書管理番号リスト(通知書発行日List));
            parameter.set処理見込み日From(FlexibleDate.EMPTY);
            parameter.set処理見込み日To(FlexibleDate.EMPTY);
            parameter.set通知書発行日(通知書発行日List);
            RString 文書番号 = div.getCcdNinteiEnkiTsuchishoBunshoBango().get文書番号();
            if (!文書番号.equals(RString.EMPTY)){
                parameter.set文書番号(文書番号);
            }else{
                parameter.set文書番号(RString.EMPTY);
            }
        }
        return parameter;
    }

    private List<RString> get申請書管理番号リスト(List<FlexibleDate> 通知書発行日List) {
        List<RString> 申請書管理番号リスト = new ArrayList<>();
        List<dgHakkotaishosha_Row> rowList = div.getDgHakkotaishosha().getSelectedItems();
        for (dgHakkotaishosha_Row row : rowList) {
            申請書管理番号リスト.add(row.getShinseishokanrino());
            通知書発行日List.add(new FlexibleDate(row.getTsuchishohakkoymd().getValue().toDateString()));
        }
        return 申請書管理番号リスト;
    }

    /**
     * 選択した理由を該当行の延期理由へセットする処理です。
     *
     * @param サンプル文書 サンプル文書
     */
    public void onOkClose_riyuselect(RString サンプル文書) {
        List<dgHakkotaishosha_Row> rowList = div.getDgHakkotaishosha().getDataSource();
        List<dgHakkotaishosha_Row> selectedRowList = div.getDgHakkotaishosha().getSelectedItems();
        dgHakkotaishosha_Row clickRow = div.getDgHakkotaishosha().getActiveRow();
        for (int index = 0; index < rowList.size(); index++) {
            dgHakkotaishosha_Row row = rowList.get(index);
            if (clickRow.equals(row)) {
                row.setEnkiriyu(サンプル文書);
                if (is変更(サンプル文書, row)) {
                    row.setChangeflag(変更フラグ_変更);
                } else {
                    row.setChangeflag(RString.EMPTY);
                }
            }
        }
        for (int index = 0; index < selectedRowList.size(); index++) {
            dgHakkotaishosha_Row row = selectedRowList.get(index);
            if (clickRow.equals(row)) {
                row.setEnkiriyu(サンプル文書);
                if (is変更(サンプル文書, row)) {
                    row.setChangeflag(変更フラグ_変更);
                } else {
                    row.setChangeflag(RString.EMPTY);
                }
            }
        }
        div.getDgHakkotaishosha().setDataSource(rowList);
        div.getDgHakkotaishosha().setSelectedItems(selectedRowList);
    }

}
