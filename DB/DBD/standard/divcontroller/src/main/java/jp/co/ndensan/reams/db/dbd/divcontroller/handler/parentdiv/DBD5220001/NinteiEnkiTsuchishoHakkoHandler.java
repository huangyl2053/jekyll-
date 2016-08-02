/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5220001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.ninteienkitsuchishohakko.DgHakkotaishoshaRow;
import jp.co.ndensan.reams.db.dbd.business.core.ninteienkitsuchishohakko.NinteiEnkiTsuchishoHakkoBusiness;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd5220001.NinteiEnkiTsuchishoHakkoParameter;
import static jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5220001.DBD5220001StateName.検索;
import static jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5220001.DBD5220001StateName.通知書;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5220001.NinteiEnkiTsuchishoHakkoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5220001.dgHakkotaishosha_Row;
import jp.co.ndensan.reams.db.dbd.service.core.ninteienkitsuchishohakko.NinteiEnkiTsuchishoHakkoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBDCodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBECodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiShinseiJohoChild;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 認定延期通知発行画面のHandlerクラスです。
 *
 * @reamsid_L DBD-1410-010 wangjie2
 */
public class NinteiEnkiTsuchishoHakkoHandler {

    private final RString 含む_key = new RString("key0");
    private final RString 印刷する_key = new RString("key0");
    private final RString 変更フラグ_変更 = new RString("1");
    private final RString 一覧表を発行する_FileName = new RString("btnPrint1");
    private final RString 保存処理完了Message = new RString("認定延期通知発行の保存処理が完了しました。");
    private final RString 画面モード_1 = new RString("1");
    private final RString 画面モード_2 = new RString("2");
    private static final Code CODE_0003 = new Code("0003");
    private static final RString NAME_被保険者番号 = new RString("被保険者番号");

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
        RString 延期理由 = CodeMaster.getCode(SubGyomuCode.DBE認定支援, DBECodeShubetsu.消費税率.getコード(),
                new FlexibleDate(RDate.getNowDate().toDateString())).get(0).getコード名称();
        List<KeyValueDataSource> 延期の理由DataSource = new ArrayList<>();
        延期の理由DataSource.add(new KeyValueDataSource(DBDCodeShubetsu.延期理由.getコード().getColumnValue(), 延期理由));
        div.getDdlEnkiRiyu().setDataSource(延期の理由DataSource);
        RString 最大表示件数 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        if (!最大表示件数.isNullOrEmpty()) {
            div.getTxtMaxDisp().setValue(new Decimal(最大表示件数.toString()));
        }
        div.getCcdHokenshaList().loadHokenshaList();
        div.getTxtInsatsuDate().setValue(RDate.getNowDate());
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
        div.getRadEnkiTsuchiHakkoIchiranhyo().setSelectedKey(印刷する_key);
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
        for (NinteiEnkiTsuchishoHakkoBusiness 発行対象者情報 : 発行対象者一覧情報) {
            dataSourceList.add(getDataSource(発行対象者情報));
            被保番号List.add(発行対象者情報.get被保番号());
        }
        div.getDgHakkotaishosha().setDataSource(dataSourceList);
        div.getTxtnkiKetteiDate().setValue(RDate.getNowDate());
        div.getTxtTsuchishoHakkoDate().setValue(RDate.getNowDate());
        div.getTxtMikomiDateTsuchisho().clearFromValue();
        div.getTxtMikomiDateTsuchisho().clearToValue();
        アクセスログの出力(被保番号List);
    }

    private void アクセスログの出力(List<RString> 被保番号List) {
        List<PersonalData> personalDataList = new ArrayList<>();
        for (RString 被保番号 : 被保番号List) {
            PersonalData personalData = PersonalData.of(ShikibetsuCode.EMPTY,
                    new ExpandedInformation(CODE_0003, NAME_被保険者番号, 被保番号));
            personalDataList.add(personalData);
        }
        AccessLogger.log(AccessLogType.照会, personalDataList);
    }

    private dgHakkotaishosha_Row getDataSource(NinteiEnkiTsuchishoHakkoBusiness 発行対象者情報) {
        dgHakkotaishosha_Row dataSource = new dgHakkotaishosha_Row();
        dataSource.setShinseishokanrino(発行対象者情報.get申請書管理番号());
        dataSource.setHokensha(発行対象者情報.get保険者名());
        dataSource.setHihokenshano(発行対象者情報.get被保番号());
        dataSource.setHihokenshaname(発行対象者情報.get氏名());
        dataSource.setNinteishinseiymd(getTextBoxDate(発行対象者情報.get認定申請年月日()));
        if (発行対象者情報.get申請区分_申請時_コード() != null) {
            dataSource.setShinseikubun(発行対象者情報.get申請区分_申請時_コード().getColumnValue());
        }
        dataSource.setEnkiketteidate(getTextBoxDate(発行対象者情報.get延期決定日()));
        dataSource.setEnkiriyu(発行対象者情報.get延期理由());
        if (発行対象者情報.get通知書発行日() != null) {
            dataSource.setTsuchishohakkoymd(getTextBoxDate(発行対象者情報.get通知書発行日()));
        }
        dataSource.setEnkikaisu(new RString(発行対象者情報.get延期回数()));
        dataSource.setMikomishorikikanfrom(getTextBoxDate(発行対象者情報.get延期見込み期間開始日()));
        dataSource.setMikomishorikikanto(getTextBoxDate(発行対象者情報.get延期見込み期間終了日()));
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
    public List<NinteiShinseiJohoChild> get要介護認定申請情報(List<NinteiEnkiTsuchishoHakkoBusiness> 発行対象者一覧情報) {
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
        List<dgHakkotaishosha_Row> rowList = div.getDgHakkotaishosha().getSelectedItems();
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (dgHakkotaishosha_Row row : rowList) {
            RString enkiriyu = RString.EMPTY;
            if (row.getEnkiriyu() != null) {
                enkiriyu = row.getEnkiriyu();
            }
            if (!isEnkiriyuAri(dataSource, enkiriyu)) {
                dataSource.add(new KeyValueDataSource(row.getShinseishokanrino(), enkiriyu));
            }
        }
        div.getDdlEnkiRiyuInput().setDataSource(dataSource);
    }

    /**
     * 発行対象者一覧に戻るを表示します。
     *
     * @return 要介護認定申請情報
     */
    public List<NinteiShinseiJohoChild> 発行対象者一覧に戻るを表示() {
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

    private boolean isEnkiriyuAri(List<KeyValueDataSource> dataSourceList, RString enkiriyu) {
        if (dataSourceList.isEmpty()) {
            return false;
        }
        for (KeyValueDataSource dataSource : dataSourceList) {
            if (enkiriyu.equals(dataSource.getValue())) {
                return true;
            }
        }
        return false;
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
        return new dgHakkotaishosha_Row(row.getRiyuselect(), row.getHokenshano(), row.getHokensha(), row.getHihokenshano(),
                row.getHihokenshaname(), row.getNinteishinseiymd(), row.getShinseikubun(), div.getTxtnkiKetteiDate(), row.getEnkiriyu(),
                div.getTxtTsuchishoHakkoDate(), row.getEnkikaisu(), getTextBoxDate(div.getTxtMikomiDateTsuchisho().getFromValue()),
                getTextBoxDate(div.getTxtMikomiDateTsuchisho().getToValue()), row.getChosajissiymd(), row.getIkenshojyuryoymd(),
                row.getIchijihanteiymd(), row.getShinsakaiyoteiymd(), row.getShinseishokanrino(), 変更フラグ_変更);
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
    public void 更新処理(List<NinteiShinseiJohoChild> 要介護認定申請情報List) {
        排他制御();
        List<dgHakkotaishosha_Row> rowList = div.getDgHakkotaishosha().getDataSource();
        List<DgHakkotaishoshaRow> rowEntityList = new ArrayList<>();
        for (dgHakkotaishosha_Row row : rowList) {
            DgHakkotaishoshaRow rowEntity = getRowEntity(row);
            if (rowEntity != null) {
                rowEntityList.add(rowEntity);
            }
        }
        NinteiEnkiTsuchishoHakkoManager.createInstance().更新処理(要介護認定申請情報List, rowEntityList);
        排他制御の解除();
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

    private void 排他制御() {
        RealInitialLocker.lock(new LockingKey(new RString("ShinseishoKanriNo")));
    }

    private void 排他制御の解除() {
        RealInitialLocker.release(new LockingKey(new RString("ShinseishoKanriNo")));
    }

    /**
     * バッチパラメータを設定します。
     *
     * @return バッチパラメータ
     */
    public NinteiEnkiTsuchishoHakkoParameter getバッチパラメータ() {
        NinteiEnkiTsuchishoHakkoParameter parameter = new NinteiEnkiTsuchishoHakkoParameter();
        if (検索.getName().equals(ResponseHolder.getState())) {
            parameter.set画面モード(画面モード_1);
            parameter.set処理見込み日From(div.getTxtMikomiDateIchiran().getFromValue());
            parameter.set処理見込み日To(div.getTxtMikomiDateIchiran().getToValue());
            parameter.set通知書発行日(div.getTxtInsatsuDate().getValue());
        } else if (通知書.getName().equals(ResponseHolder.getState())) {
            parameter.set画面モード(画面モード_2);
            parameter.set申請書管理番号リスト(get申請書管理番号リスト());
        }
        return parameter;
    }

    private List<RString> get申請書管理番号リスト() {
        List<RString> 申請書管理番号リスト = new ArrayList<>();
        List<dgHakkotaishosha_Row> rowList = div.getDgHakkotaishosha().getSelectedItems();
        for (dgHakkotaishosha_Row row : rowList) {
            申請書管理番号リスト.add(row.getShinseishokanrino());
        }
        return 申請書管理番号リスト;
    }

}
