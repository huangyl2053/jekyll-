/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5110001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.gogitaijoho.GogitaiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.gogitaijoho.GogitaiJohoBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.gogitaiwariateiinjoho.GogitaiWariateIinJoho;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.gogitaiwariateiinjoho.GogitaiWariateIinJohoBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.shinsakaiiinjoho.ShinsakaiIinJoho;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.shinsakaikaisaibashojoho.ShinsakaiKaisaiBashoJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.definition.core.hoshu.GogitaichoKubunCode;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.IsGogitaiSeishinkaSonzai;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5110001.GogitaiJohoSakuseiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5110001.dgGogitaiIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5110001.dgHoketsuShinsainList_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5110001.dgShinsainList_Row;
import jp.co.ndensan.reams.db.dbe.service.core.gogitaijohosakusei.GogitaiJohoSakuseiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.shinsakai.IsGogitaiDummy;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridButtonState;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 合議体情報作成の抽象Handlerクラスです。
 *
 * @reamsid_L DBE-0090-010 chengsanyuan
 */
public class GogitaiJohoSakuseiHandler {

    private static final RString JYOTAI_NAME_ADD = new RString("追加");
    private static final RString JYOTAI_NAME_UPD = new RString("修正");
    private static final RString JYOTAI_NAME_DEL = new RString("削除");
    private static final RString RAD_KEY_0 = new RString("key0");
    private static final RString RAD_KEY_1 = new RString("key1");
    private static final RString KAISAI_BASHO_CODE_EMPTY = new RString("empty");
    private static final RString COMMON_BUTTON_FIELD_NAME = new RString("btnupdate");

    private int hoketsuCount = 0;
    private int shinsainCount = 0;

    private final GogitaiJohoSakuseiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 合議体情報作成Div
     */
    public GogitaiJohoSakuseiHandler(GogitaiJohoSakuseiDiv div) {
        this.div = div;
    }

    /**
     *
     * 合議体情報作成初期化の設定します。
     *
     */
    public void load() {
        GogitaiJohoSakuseiFinder service = GogitaiJohoSakuseiFinder.createInstance();
        SearchResult<KeyValueDataSource> resultList = service.getKaisaiBashoList();
        div.getDdlkaisaibasho().setDataSource(resultList.records());
        div.getRadHyojiJoken().setSelectedKey(RAD_KEY_0);
        div.getDgGogitaiIchiran().getDataSource().clear();
        div.getRadSeishinkaiSonzai().setSelectedKey(RAD_KEY_1);
        div.getRadDummyFlag().setSelectedKey(RAD_KEY_0);
        this.合議体詳細情報初期状態設定();
    }

    /**
     * 最大表示件数の初期値を設定します。
     */
    public void init最大表示件数() {
        div.getTxtDispMax().setValue(new Decimal(DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
    }

    /**
     *
     * 合議体情報一覧の設定します。
     *
     * @param resultList 合議体情報一覧のデータ
     */
    public void 合議体情報一覧初期設定(List<GogitaiJoho> resultList) {
        List<dgGogitaiIchiran_Row> rowList = new ArrayList<>();
        FlexibleDate 現在日付 = FlexibleDate.getNowDate();
        int i = 0;
        for (GogitaiJoho result : resultList) {
            if (i < div.getKensakujyoken().getTxtDispMax().getValue().intValue()) {
                dgGogitaiIchiran_Row row = new dgGogitaiIchiran_Row();
                if (result.get合議体有効期間開始年月日().isBeforeOrEquals(現在日付) && 現在日付.isBeforeOrEquals(result.get合議体有効期間終了年月日())) {
                    row.setModifyButtonState(DataGridButtonState.Enabled);
                    row.setDeleteButtonState(DataGridButtonState.Enabled);
                } else {
                    row.setModifyButtonState(DataGridButtonState.Disabled);
                    row.setDeleteButtonState(DataGridButtonState.Disabled);
                }
                row.setJyotai(RString.EMPTY);
                row.getGogitaiNumber().setValue(new Decimal(result.get合議体番号()));
                row.setGogitaiName(result.get合議体名称());
                row.getYukoKaishiYMD().setValue(new RDate(result.get合議体有効期間開始年月日().wareki().toDateString().toString()));
                row.getYukoShuryoYMD().setValue(new RDate(result.get合議体有効期間終了年月日().wareki().toDateString().toString()));
                row.getGogitaiKaishiYoteiTime().setValue(strToTime(result.get合議体開始予定時刻()));
                row.getGogitaiShuryoYoteiTime().setValue(strToTime(result.get合議体終了予定時刻()));
                row.setKaisaiBashoCode(result.get介護認定審査会開催場所コード());
                row.setKaisaiBasho(result.getShinsakaiKaisaiBashoJoho(new ShinsakaiKaisaiBashoJohoIdentifier(result.get介護認定審査会開催場所コード())).get介護認定審査会開催場所名称());
                row.setSeishinkaiSonzai(result.is合議体精神科医存在フラグ());
                row.setGogitaiDummyFlag(result.is合議体ダミーフラグ());
                row.getYoteiTeiin().setValue(new Decimal(result.get介護認定審査会予定定員()));
                row.getJidoWariateTeiin().setValue(new Decimal(result.get介護認定審査会自動割当定員()));
                row.getIinTeiin().setValue(new Decimal(result.get介護認定審査会委員定員()));
                rowList.add(row);
                i++;
            }
        }
        int listsize = resultList.size();
        div.getDgGogitaiIchiran().setDataSource(rowList);
        div.getDgGogitaiIchiran().getGridSetting().setLimitRowCount(div.getKensakujyoken().getTxtDispMax().getValue().intValue());
        div.getDgGogitaiIchiran().getGridSetting().setSelectedRowCount(listsize);
        合議体詳細情報初期状態設定();
    }

    /**
     *
     * 合議体情報編集エリアの設定します。
     *
     * @param row 合議体情報Gridクリックの行
     * @param resultList 割当審査員一覧
     */
    public void 合議体詳細情報データ設定(dgGogitaiIchiran_Row row, List<GogitaiWariateIinJoho> resultList) {
        div.getTxtGogitaiNumber().setValue(row.getGogitaiNumber().getValue());
        div.getTxtGogitaiMeisho().setValue(row.getGogitaiName());
        div.getDdlkaisaibasho().setSelectedKey(KAISAI_BASHO_CODE_EMPTY);
        for (KeyValueDataSource keyValue : div.getDdlkaisaibasho().getDataSource()) {
            if (keyValue.getKey().equals(row.getKaisaiBashoCode())) {
                div.getDdlkaisaibasho().setSelectedKey(row.getKaisaiBashoCode());
                break;
            }
        }
        div.getTxtYukoShuryoYMD().setValue(row.getYukoShuryoYMD().getValue());
        div.getTxtYukoKaishiYMD().setValue(row.getYukoKaishiYMD().getValue());
        div.getTxtShuryoYoteiTime().setValue(row.getGogitaiShuryoYoteiTime().getValue());
        div.getTxtKaishiYoteiTime().setValue(row.getGogitaiKaishiYoteiTime().getValue());
        div.getTxtYoteiTeiin().setValue(row.getYoteiTeiin().getValue());
        div.getTxtJidoWariateTeiin().setValue(row.getJidoWariateTeiin().getValue());
        div.getTxtIinTeiin().setValue(row.getIinTeiin().getValue());
        if (IsGogitaiSeishinkaSonzai.toValue(row.getSeishinkaiSonzai()).is合議体精神科医存在()) {
            div.getRadSeishinkaiSonzai().setSelectedKey(RAD_KEY_0);
        } else {
            div.getRadSeishinkaiSonzai().setSelectedKey(RAD_KEY_1);
        }
        if (IsGogitaiDummy.toValue(row.getGogitaiDummyFlag()).is合議体ダミーフラグTrue()) {
            div.getRadDummyFlag().setSelectedKey(RAD_KEY_1);
        } else {
            div.getRadDummyFlag().setSelectedKey(RAD_KEY_0);
        }
        this.審査員一覧設定(resultList);
    }

    /**
     * 合議体情報編集エリア各項目の活性・非活性の設定。
     */
    private void 合議体詳細情報項目状態設定(boolean disabledFlag) {
        div.getTxtGogitaiNumber().setDisabled(disabledFlag);
        div.getTxtGogitaiMeisho().setDisabled(disabledFlag);
        div.getTxtYukoKaishiYMD().setDisabled(disabledFlag);
        div.getTxtYukoShuryoYMD().setDisabled(disabledFlag);
        div.getTxtKaishiYoteiTime().setDisabled(disabledFlag);
        div.getTxtShuryoYoteiTime().setDisabled(disabledFlag);
        div.getDdlkaisaibasho().setDisabled(disabledFlag);
        div.getTxtIinTeiin().setDisabled(disabledFlag);
        div.getTxtYoteiTeiin().setDisabled(disabledFlag);
        div.getTxtJidoWariateTeiin().setDisabled(disabledFlag);
        div.getRadSeishinkaiSonzai().setDisabled(disabledFlag);
        div.getRadDummyFlag().setDisabled(disabledFlag);
        div.getBtnShinsainSelect().setDisabled(disabledFlag);
        div.getDgShinsainList().setDisabled(disabledFlag);
        div.getBtnSubShinsainSelect().setDisabled(disabledFlag);
        div.getDgHoketsuShinsainList().setDisabled(disabledFlag);
        div.getBtnback().setDisabled(disabledFlag);
        div.getBtnKosin().setDisabled(disabledFlag);
    }

    /**
     * 合議体情報編集エリアをクリアします。
     */
    private void 合議体詳細情報項目初期値設定() {
        div.getTxtGogitaiNumber().clearValue();
        div.getTxtGogitaiMeisho().clearValue();
        div.getTxtYukoKaishiYMD().clearValue();
        div.getTxtYukoShuryoYMD().clearValue();
        div.getTxtKaishiYoteiTime().clearValue();
        div.getTxtShuryoYoteiTime().clearValue();
        div.getDdlkaisaibasho().setSelectedKey(KAISAI_BASHO_CODE_EMPTY);
        div.getTxtIinTeiin().clearValue();
        div.getTxtYoteiTeiin().clearValue();
        div.getTxtJidoWariateTeiin().clearValue();
        div.getRadSeishinkaiSonzai().setSelectedKey(RAD_KEY_1);
        div.getRadDummyFlag().setSelectedKey(RAD_KEY_0);
        div.getDgHoketsuShinsainList().getDataSource().clear();
        div.getDgShinsainList().getDataSource().clear();
    }

    /**
     *
     * 新規モードの場合、合議体詳細情報の設定します。
     *
     */
    public void 合議体詳細情報新規モード設定() {
        合議体詳細情報項目状態設定(false);
        合議体詳細情報項目初期値設定();
        各ボタン活性設定(Boolean.TRUE);
    }

    /**
     *
     * 修正モードの場合、合議体詳細情報の設定します。
     *
     */
    public void 合議体詳細情報修正モード設定() {
        合議体詳細情報項目状態設定(false);
        div.getTxtGogitaiNumber().setDisabled(true);
        div.getTxtYukoKaishiYMD().setDisabled(true);
        各ボタン活性設定(Boolean.TRUE);

    }

    private void 各ボタン活性設定(boolean flag) {
        div.getBtnTsuika().setDisabled(flag);
        div.getDgGogitaiIchiran().setReadOnly(flag);
        div.getBtnCSVShutsuryoku().setDisabled(flag);
        div.getUploadFileToroku().setDisabled(flag);
        div.getKensakujyoken().setDisabled(flag);
//        CommonButtonHolder.setDisabledByCommonButtonFieldName(COMMON_BUTTON_FIELD_NAME, flag);
    }

    /**
     *
     * 合議体詳細情報の初期状態の設定します。
     *
     */
    public void 合議体詳細情報初期状態設定() {
        合議体詳細情報項目初期値設定();
        合議体詳細情報項目状態設定(true);
        各ボタン活性設定(Boolean.FALSE);
    }

    /**
     *
     * 新規モードの場合、合議体詳細情報の変更有りの判定します。
     *
     * @return true:変更有り false:変更無し
     */
    public boolean 新規モード合議体詳細情報変更有無判定() {
        return !(div.getTxtGogitaiNumber().getValue() == null
                && div.getTxtGogitaiMeisho().getValue().isEmpty()
                && div.getDdlkaisaibasho().getSelectedKey().equals(KAISAI_BASHO_CODE_EMPTY)
                && div.getTxtYukoShuryoYMD().getValue() == null
                && div.getTxtYukoKaishiYMD().getValue() == null
                && div.getTxtShuryoYoteiTime().getValue() == null
                && div.getTxtKaishiYoteiTime().getValue() == null
                && div.getTxtYoteiTeiin().getValue() == null
                && div.getTxtJidoWariateTeiin().getValue() == null
                && div.getTxtIinTeiin().getValue() == null
                && div.getRadSeishinkaiSonzai().getSelectedKey().equals(RAD_KEY_1)
                && div.getRadDummyFlag().getSelectedKey().equals(RAD_KEY_0)
                && div.getDgHoketsuShinsainList().getDataSource().isEmpty()
                && div.getDgShinsainList().getDataSource().isEmpty());
    }

    /**
     *
     * 更新モードの場合、合議体詳細情報の変更有りの判定します。
     *
     * @param result 合議体情報
     * @return true:変更有り false:変更無し
     */
    public boolean 修正モード合議体詳細情報変更有無判定(GogitaiJoho result) {

        boolean flg = !(result.get合議体番号() == Integer.parseInt(div.getTxtGogitaiNumber().getValue().toString())
                && result.get合議体名称().equals(div.getTxtGogitaiMeisho().getValue())
                && result.get介護認定審査会開催場所コード().equals(div.getDdlkaisaibasho().getSelectedKey())
                && result.get合議体有効期間開始年月日().compareTo(new FlexibleDate(div.getTxtYukoKaishiYMD().getValue().toDateString())) == 0
                && result.get合議体有効期間終了年月日().compareTo(new FlexibleDate(div.getTxtYukoShuryoYMD().getValue().toDateString())) == 0
                && strToTime(result.get合議体開始予定時刻()).compareTo(div.getTxtKaishiYoteiTime().getValue()) == 0
                && strToTime(result.get合議体終了予定時刻()).compareTo(div.getTxtShuryoYoteiTime().getValue()) == 0
                && result.get介護認定審査会予定定員() == div.getTxtYoteiTeiin().getValue().intValue()
                && div.getTxtJidoWariateTeiin().getText().equals(new RString(result.get介護認定審査会自動割当定員()))
                && result.get介護認定審査会委員定員() == div.getTxtIinTeiin().getValue().intValue()
                && result.is合議体精神科医存在フラグ() == div.getRadSeishinkaiSonzai().getSelectedKey().equals(RAD_KEY_0)
                && result.is合議体ダミーフラグ() == div.getRadDummyFlag().getSelectedKey().equals(RAD_KEY_1));

        if (flg) {
            return flg;
        }
        List<dgHoketsuShinsainList_Row> hoketsuShinsainList = div.getDgHoketsuShinsainList().getDataSource();
        List<dgShinsainList_Row> shinsainList = div.getDgShinsainList().getDataSource();
        List<GogitaiWariateIinJoho> gogitaiWariateIinJohoList = result.getGogitaiWariateIinJohoList();
        if (gogitaiWariateIinJohoList.size() != hoketsuShinsainList.size() + shinsainList.size()) {
            return !flg;
        }
        for (int i = 0; i < gogitaiWariateIinJohoList.size(); i++) {
            dgHoketsuShinsainList_Row dgHoketsuShinsain = new dgHoketsuShinsainList_Row();
            if (i - shinsainCount < hoketsuShinsainList.size()) {
                dgHoketsuShinsain = hoketsuShinsainList.get(i - shinsainCount);
            }
            dgShinsainList_Row dgShinsain = new dgShinsainList_Row();
            if (i - hoketsuCount < shinsainList.size()) {
                dgShinsain = shinsainList.get(i - hoketsuCount);
            }
            GogitaiWariateIinJoho gogitaiWariateIinJoho = gogitaiWariateIinJohoList.get(i);
            flg = hasChangedByUpdForDataGrid(dgHoketsuShinsain, dgShinsain, gogitaiWariateIinJoho, flg);
            if (!flg) {
                hoketsuCount = 0;
                shinsainCount = 0;
                return flg;
            }
        }
        hoketsuCount = 0;
        shinsainCount = 0;
        return flg;
    }

    private boolean hasChangedByUpdForDataGrid(
            dgHoketsuShinsainList_Row dgHoketsuShinsain,
            dgShinsainList_Row dgShinsain,
            GogitaiWariateIinJoho gogitaiWariateIinJoho,
            boolean flg) {
        if (gogitaiWariateIinJoho.is補欠()) {
            if (!gogitaiWariateIinJoho.get介護認定審査会委員コード().equals(dgHoketsuShinsain.getHoketsuShinsakaiIinCode())) {
                return !flg;
            }
            if (!gogitaiWariateIinJoho.getShinsakaiIinJohoList().isEmpty()
                    && !gogitaiWariateIinJoho.getShinsakaiIinJohoList().get(0).get介護認定審査会委員氏名().value().equals(dgHoketsuShinsain.getHoketsuShinsakaiIinShimei())) {
                return !flg;
            }
            hoketsuCount = hoketsuCount + 1;
        } else {
            if (!gogitaiWariateIinJoho.get介護認定審査会委員コード().equals(dgShinsain.getShinsakaiIinCode())) {
                return !flg;
            }

            if (!gogitaiWariateIinJoho.getShinsakaiIinJohoList().isEmpty()
                    && !gogitaiWariateIinJoho.getShinsakaiIinJohoList().get(0).get介護認定審査会委員氏名().value().equals(dgShinsain.getShinsakaiIinShimei())) {
                return !flg;
            }

            if (GogitaichoKubunCode.副合議体長.getコード().equals(gogitaiWariateIinJoho.get合議体長区分コード().value())
                    && !dgShinsain.getFukuGogitaicho()) {
                return !flg;
            }

            if (GogitaichoKubunCode.合議体長.getコード().equals(gogitaiWariateIinJoho.get合議体長区分コード().value())
                    && !dgShinsain.getGogitaicho()) {
                return !flg;
            }

            if (GogitaichoKubunCode.通常.getコード().equals(gogitaiWariateIinJoho.get合議体長区分コード().value())
                    && (dgShinsain.getGogitaicho() || dgShinsain.getFukuGogitaicho())) {
                return !flg;
            }
            shinsainCount = shinsainCount + 1;
        }
        return flg;
    }

    private void 審査員一覧設定(List<GogitaiWariateIinJoho> resultList) {

        List<dgHoketsuShinsainList_Row> hoketsuShinsainList = new ArrayList<>();
        List<dgShinsainList_Row> shinsainList = new ArrayList<>();
        for (GogitaiWariateIinJoho result : resultList) {
            if (result.is補欠()) {
                dgHoketsuShinsainList_Row hoketsuShinsainRow = new dgHoketsuShinsainList_Row();
                hoketsuShinsainRow.setHoketsuShinsakaiIinShimei(nullToEmpty(result.getShinsakaiIinJohoList().get(0).get介護認定審査会委員氏名()));
                hoketsuShinsainRow.setHoketsuShinsakaiIinCode(result.get介護認定審査会委員コード());
                hoketsuShinsainList.add(hoketsuShinsainRow);
                continue;
            }
            dgShinsainList_Row shinsainRow = new dgShinsainList_Row();
            shinsainRow.setShinsakaiIinShimei(nullToEmpty(result.getShinsakaiIinJohoList().get(0).get介護認定審査会委員氏名()));
            shinsainRow.setShinsakaiIinCode(result.get介護認定審査会委員コード());
            if (GogitaichoKubunCode.副合議体長.getコード().equals(nullToEmpty(result.get合議体長区分コード()))) {
                shinsainRow.setFukuGogitaicho(Boolean.TRUE);
            }
            if (GogitaichoKubunCode.合議体長.getコード().equals(nullToEmpty(result.get合議体長区分コード()))) {
                shinsainRow.setGogitaicho(Boolean.TRUE);
            }
            shinsainList.add(shinsainRow);
        }
        div.getDgHoketsuShinsainList().setDataSource(hoketsuShinsainList);
        div.getDgShinsainList().setDataSource(shinsainList);
    }

    /**
     * 合議体情報一覧を設定します。
     *
     * @param jyotai 状態
     */
    public void 合議体情報一覧更新(RString jyotai) {

        dgGogitaiIchiran_Row row = new dgGogitaiIchiran_Row();
        if (!JYOTAI_NAME_ADD.equals(jyotai)) {
            row = div.getDgGogitaiIchiran().getActiveRow();
        }
        row.getGogitaiNumber().setValue(div.getTxtGogitaiNumber().getValue());
        row.setGogitaiName(div.getTxtGogitaiMeisho().getValue());
        row.getGogitaiKaishiYoteiTime().setValue(div.getTxtKaishiYoteiTime().getValue());
        row.getGogitaiShuryoYoteiTime().setValue(div.getTxtShuryoYoteiTime().getValue());
        row.setKaisaiBashoCode(div.getDdlkaisaibasho().getSelectedKey());
        row.setKaisaiBasho(div.getDdlkaisaibasho().getSelectedValue());
        row.getIinTeiin().setValue(div.getTxtIinTeiin().getValue());
        row.getJidoWariateTeiin().setValue(div.getTxtJidoWariateTeiin().getValue());
        row.getYoteiTeiin().setValue(div.getTxtYoteiTeiin().getValue());
        row.getYukoKaishiYMD().setValue(div.getTxtYukoKaishiYMD().getValue());
        row.getYukoShuryoYMD().setValue(div.getTxtYukoShuryoYMD().getValue());
        row.setGogitaiDummyFlag(RAD_KEY_1.equals(div.getRadDummyFlag().getSelectedKey()));
        row.setSeishinkaiSonzai(RAD_KEY_0.equals(div.getRadSeishinkaiSonzai().getSelectedKey()));

        int index = div.getDgGogitaiIchiran().getClickedRowId();

        if (JYOTAI_NAME_ADD.equals(jyotai)) {
            row.setJyotai(JYOTAI_NAME_ADD);
            div.getDgGogitaiIchiran().getDataSource().add(row);
        } else if (JYOTAI_NAME_DEL.equals(jyotai) && JYOTAI_NAME_ADD.equals(row.getJyotai())) {
            div.getDgGogitaiIchiran().getDataSource().remove(index);
        } else if (JYOTAI_NAME_UPD.equals(jyotai) && JYOTAI_NAME_ADD.equals(row.getJyotai())) {
            div.getDgGogitaiIchiran().getDataSource().set(index, row);
        } else {
            row.setJyotai(jyotai);
            div.getDgGogitaiIchiran().getDataSource().set(index, row);
        }
    }

    /**
     * 合議体情報を編集します。
     *
     * @param gogitaiJoho 合議体情報
     * @return gogitaiJoho 合議体情報
     */
    public GogitaiJoho 合議体情報編集(GogitaiJoho gogitaiJoho) {
        GogitaiJohoBuilder gogitaiJohoBuilder = gogitaiJoho.createBuilderForEdit();
        gogitaiJohoBuilder.set合議体名称(div.getTxtGogitaiMeisho().getValue());
        gogitaiJohoBuilder.set合議体有効期間終了年月日(new FlexibleDate(div.getTxtYukoShuryoYMD().getValue().toDateString()));
        gogitaiJohoBuilder.set合議体開始予定時刻(timeToStr(div.getTxtKaishiYoteiTime().getValue()));
        gogitaiJohoBuilder.set合議体終了予定時刻(timeToStr(div.getTxtShuryoYoteiTime().getValue()));
        gogitaiJohoBuilder.set介護認定審査会開催場所コード(div.getDdlkaisaibasho().getSelectedKey());
        gogitaiJohoBuilder.set介護認定審査会予定定員(div.getTxtYoteiTeiin().getValue().intValue());
        gogitaiJohoBuilder.set介護認定審査会自動割当定員(div.getTxtJidoWariateTeiin().getValue() == null
                ? 0 : div.getTxtJidoWariateTeiin().getValue().intValue());
        gogitaiJohoBuilder.set介護認定審査会委員定員(div.getTxtIinTeiin().getValue().intValue());
        gogitaiJohoBuilder.set合議体ダミーフラグ(RAD_KEY_1.equals(div.getRadDummyFlag().getSelectedKey()));
        gogitaiJohoBuilder.set合議体精神科医存在フラグ(RAD_KEY_0.equals(div.getRadSeishinkaiSonzai().getSelectedKey()));
        gogitaiJohoBuilder = 合議体割当審査員情報編集(gogitaiJohoBuilder);
        return gogitaiJohoBuilder.build();
    }

    private GogitaiJohoBuilder 合議体割当審査員情報編集(GogitaiJohoBuilder gogitaiJohoBuilder) {
        for (dgShinsainList_Row shinsainRow : div.getDgShinsainList().getDataSource()) {
            GogitaiWariateIinJoho gogitaiWariateIinJoho = new GogitaiWariateIinJoho(
                    Integer.parseInt(div.getTxtGogitaiNumber().getValue().toString()),
                    new FlexibleDate(div.getTxtYukoKaishiYMD().getValue().toDateString()),
                    shinsainRow.getShinsakaiIinCode());
            GogitaiWariateIinJohoBuilder gogitaiWariateIinJohoBuilder = gogitaiWariateIinJoho.createBuilderForEdit();
            gogitaiWariateIinJohoBuilder.set補欠(false);
            if (shinsainRow.getGogitaicho()) {
                gogitaiWariateIinJohoBuilder.set合議体長区分コード(new Code(GogitaichoKubunCode.合議体長.getコード()));
            } else if (shinsainRow.getFukuGogitaicho()) {
                gogitaiWariateIinJohoBuilder.set合議体長区分コード(new Code(GogitaichoKubunCode.副合議体長.getコード()));
            } else {
                gogitaiWariateIinJohoBuilder.set合議体長区分コード(new Code(GogitaichoKubunCode.通常.getコード()));
            }
            gogitaiWariateIinJohoBuilder.set合議体有効期間終了年月日(new FlexibleDate(div.getTxtYukoShuryoYMD().getValue().toDateString()));
            ShinsakaiIinJoho shinsakaiIinJoho = new ShinsakaiIinJoho(shinsainRow.getShinsakaiIinCode());
            shinsakaiIinJoho = shinsakaiIinJoho.createBuilderForEdit().set介護認定審査会委員氏名(new AtenaMeisho(shinsainRow.getShinsakaiIinShimei())).build();
            gogitaiWariateIinJohoBuilder.setSeishinTechoNini(shinsakaiIinJoho);
            gogitaiWariateIinJoho = gogitaiWariateIinJohoBuilder.build();
            gogitaiJohoBuilder.setGogitaiWariateIinJoho(gogitaiWariateIinJoho);
        }

        for (dgHoketsuShinsainList_Row hoketsuShinsainRow : div.getDgHoketsuShinsainList().getDataSource()) {
            GogitaiWariateIinJoho gogitaiWariateIinJoho = new GogitaiWariateIinJoho(
                    Integer.parseInt(div.getTxtGogitaiNumber().getValue().toString()),
                    new FlexibleDate(div.getTxtYukoKaishiYMD().getValue().toDateString()),
                    hoketsuShinsainRow.getHoketsuShinsakaiIinCode());
            GogitaiWariateIinJohoBuilder gogitaiWariateIinJohoBuilder = gogitaiWariateIinJoho.createBuilderForEdit();
            gogitaiWariateIinJohoBuilder.set補欠(true);
            gogitaiWariateIinJohoBuilder.set合議体長区分コード(new Code(GogitaichoKubunCode.通常.getコード()));
            gogitaiWariateIinJohoBuilder.set合議体有効期間終了年月日(new FlexibleDate(div.getTxtYukoShuryoYMD().getValue().toDateString()));
            ShinsakaiIinJoho shinsakaiIinJoho = new ShinsakaiIinJoho(hoketsuShinsainRow.getHoketsuShinsakaiIinCode());
            shinsakaiIinJoho = shinsakaiIinJoho.createBuilderForEdit().set介護認定審査会委員氏名(new AtenaMeisho(hoketsuShinsainRow.getHoketsuShinsakaiIinShimei())).build();
            gogitaiWariateIinJohoBuilder.setSeishinTechoNini(shinsakaiIinJoho);
            gogitaiWariateIinJoho = gogitaiWariateIinJohoBuilder.build();
            gogitaiJohoBuilder.setGogitaiWariateIinJoho(gogitaiWariateIinJoho);
        }

        return gogitaiJohoBuilder;
    }

    private RTime strToTime(RString str) {
        if (str == null) {
            return RDateTime.MIN.getTime();
        }
        str = str.insert(2, ":");
        return RTime.parse(str);
    }

    private RString timeToStr(RTime time) {

        if (time == null) {
            return RString.EMPTY;
        }
        int hour = time.getHour();
        int min = time.getMinute();
        return new RString(String.valueOf(hour)).padZeroToLeft(2).concat(new RString(String.valueOf(min)).padZeroToLeft(2));
    }

    private RString nullToEmpty(AtenaMeisho 名称) {
        if (名称 == null || 名称.isEmpty()) {
            return RString.EMPTY;
        }
        return 名称.value();
    }

    private RString nullToEmpty(Code コード) {
        if (コード == null || コード.isEmpty()) {
            return RString.EMPTY;
        }
        return コード.value();
    }
}
