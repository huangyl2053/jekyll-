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
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijohosakusei.GogitaiJohoSakuseiRsult;
import jp.co.ndensan.reams.db.dbe.definition.core.hoshu.GogitaichoKubunCode;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.IsGogitaiSeishinkaSonzai;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5110001.GogitaiJohoSakuseiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5110001.dgGogitaiIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5110001.dgHoketsuShinsainList_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5110001.dgShinsainList_Row;
import jp.co.ndensan.reams.db.dbz.definition.core.shinsakai.IsGogitaiDummy;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;

/**
 * 合議体情報作成の抽象Handlerクラスです。
 *
 * @reamsid_L DBE-0090-010 chengsanyuan
 */
public class GogitaiJohoSakuseiHandler {

    private static final RString HYOJI_JOKEN_GENZAI_YUUKOU = new RString("key1");
    private static final RString SEISHINKAI_SONZAI_SURU = new RString("key0");
    private static final RString SEISHINKAI_SONZAI_SHINAI = new RString("key1");
    private static final RString DUMMY_FLAG_TUUJOU = new RString("key0");
    private static final RString DUMMY_FLAG_DAMI = new RString("key1");
    private static final RString KAISAI_BASHO_CODE_EMPTY = new RString("empty");

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
     * @param resultList 開催場所コードドロップリスト
     */
    public void load(List<KeyValueDataSource> resultList) {
        div.getDdlkaisaibasho().setDataSource(resultList);
        this.cleanGogitaiShosai();
        div.getRadHyojiJoken().setSelectedKey(HYOJI_JOKEN_GENZAI_YUUKOU);
        div.getDgGogitaiIchiran().getDataSource().clear();
        div.getRadSeishinkaiSonzai().setSelectedKey(SEISHINKAI_SONZAI_SHINAI);
        div.getRadDummyFlag().setSelectedKey(DUMMY_FLAG_TUUJOU);
        this.setDisableByAdd(true);

    }

    /**
     * 最大表示件数の初期値を設定します。
     */
    public void init最大表示件数() {
        div.getTxtDispMax().setValue(Decimal.TEN);
    }

    /**
     *
     * 合議体情報一覧の設定します。
     *
     * @param resultList 合議体情報一覧のデータ
     */
    public void setDgGogitaiIchiran(List<GogitaiJohoSakuseiRsult> resultList) {
        List<dgGogitaiIchiran_Row> rowList = new ArrayList<>();
        for (GogitaiJohoSakuseiRsult result : resultList) {
            dgGogitaiIchiran_Row row = new dgGogitaiIchiran_Row();
            row.setJyotai(RString.EMPTY);
            row.setGogitaiNumber(new RString(String.valueOf(result.get合議体番号())));
            row.setGogitaiName(result.get合議体名称());
            row.getYukoKaishiYMD().setValue(new RDate(result.get合議体有効期間開始年月日().wareki().toDateString().toString()));
            row.getYukoShuryoYMD().setValue(new RDate(result.get合議体有効期間終了年月日().wareki().toDateString().toString()));
            row.getGogitaiKaishiYoteiTime().setValue(strToTime(result.get合議体開始予定時刻()));
            row.getGogitaiShuryoYoteiTime().setValue(strToTime(result.get合議体終了予定時刻()));
            row.setKaisaiBashoCode(result.get介護認定審査会開催場所コード());
            row.setSeishinkaiSonzai(result.is合議体精神科医存在フラグ());
            row.setGogitaiDummyFlag(result.is合議体ダミーフラグ());
            row.getYoteiTeiin().setValue(new Decimal(result.get介護認定審査会予定定員()));
            row.getJidoWariateTeiin().setValue(new Decimal(result.get介護認定審査会自動割当定員()));
            row.getIinTeiin().setValue(new Decimal(result.get介護認定審査会委員定員()));
            rowList.add(row);
        }
        div.getDgGogitaiIchiran().setDataSource(rowList);
        this.cleanGogitaiShosai();
        this.setDisableByAdd(true);
        div.getBtnTsuika().setDisabled(false);
    }

    /**
     *
     * 合議体情報編集エリアの設定します。
     *
     * @param row 合議体情報Gridクリックの行
     * @param resultList 割当審査員一覧
     */
    public void setGogitaiShosai(dgGogitaiIchiran_Row row, List<GogitaiJohoSakuseiRsult> resultList) {
        div.getTxtGogitaiNumber().setValue(row.getGogitaiNumber());
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
            div.getRadSeishinkaiSonzai().setSelectedKey(SEISHINKAI_SONZAI_SURU);
        } else {
            div.getRadSeishinkaiSonzai().setSelectedKey(SEISHINKAI_SONZAI_SHINAI);
        }
        if (IsGogitaiDummy.toValue(row.getGogitaiDummyFlag()).is合議体ダミーフラグTrue()) {
            div.getRadDummyFlag().setSelectedKey(DUMMY_FLAG_DAMI);
        } else {
            div.getRadDummyFlag().setSelectedKey(DUMMY_FLAG_TUUJOU);
        }
        this.setShinsaiMeisai(resultList);
    }

    /**
     *
     * 新規モードの場合、合議体詳細情報の設定します。
     *
     */
    public void setGogitaiShosaiByAdd() {
        div.getDdlkaisaibasho().setDisabled(false);
        div.getTxtYukoShuryoYMD().setDisabled(false);
        div.getTxtYukoKaishiYMD().setDisabled(false);
        div.getTxtYoteiTeiin().setDisabled(false);
        div.getTxtShuryoYoteiTime().setDisabled(false);
        div.getTxtKaishiYoteiTime().setDisabled(false);
        div.getTxtJidoWariateTeiin().setDisabled(false);
        div.getTxtIinTeiin().setDisabled(false);
        div.getTxtGogitaiNumber().setDisabled(false);
        div.getTxtGogitaiMeisho().setDisabled(false);
        div.getRadSeishinkaiSonzai().setDisabled(false);
        div.getRadDummyFlag().setDisabled(false);
        div.getDgShinsainList().setDisabled(false);
        div.getDgHoketsuShinsainList().setDisabled(false);
        div.getBtnShinsainSelect().setDisabled(false);
        div.getBtnSubShinsainSelect().setDisabled(false);
        div.getBtnback().setDisabled(false);
        div.getBtnKosin().setDisabled(false);
        div.getBtnTsuika().setDisabled(true);
        this.cleanGogitaiShosai();

    }

    /**
     *
     * 新規モードの場合、合議体詳細情報の変更有りの判定します。
     *
     * @return true:変更なし false:変更有り
     */
    public boolean hasChangedByAdd() {
        return div.getTxtGogitaiNumber().getValue().isEmpty()
               && div.getTxtGogitaiMeisho().getValue().isEmpty()
               && div.getDdlkaisaibasho().getSelectedKey().equals(KAISAI_BASHO_CODE_EMPTY)
               && div.getTxtYukoShuryoYMD().getValue() == null
               && div.getTxtYukoKaishiYMD().getValue() == null
               && div.getTxtShuryoYoteiTime().getValue() == null
               && div.getTxtKaishiYoteiTime().getValue() == null
               && div.getTxtYoteiTeiin().getValue() == null
               && div.getTxtJidoWariateTeiin().getValue() == null
               && div.getTxtIinTeiin().getValue() == null
               && div.getRadSeishinkaiSonzai().getSelectedKey().equals(SEISHINKAI_SONZAI_SHINAI)
               && div.getRadDummyFlag().getSelectedKey().equals(DUMMY_FLAG_TUUJOU)
               && div.getDgHoketsuShinsainList().getDataSource().isEmpty()
               && div.getDgShinsainList().getDataSource().isEmpty();
    }

    /**
     *
     * 更新モードの場合、合議体詳細情報の変更有りの判定します。
     *
     * @param result 合議体情報
     * @return true:変更なし false:変更有り
     */
    public boolean hasChangedByUpd(GogitaiJoho result) {

        boolean flg = result.get合議体番号() == Integer.parseInt(div.getTxtGogitaiNumber().getValue().toString())
                      && result.get合議体名称().equals(div.getTxtGogitaiMeisho().getValue())
                      && result.get介護認定審査会開催場所コード().equals(div.getDdlkaisaibasho().getSelectedKey())
                      && result.get合議体有効期間開始年月日().compareTo(new FlexibleDate(div.getTxtYukoKaishiYMD().getValue().toDateString())) == 0
                      && result.get合議体有効期間終了年月日().compareTo(new FlexibleDate(div.getTxtYukoShuryoYMD().getValue().toDateString())) == 0
                      && strToTime(result.get合議体開始予定時刻()).compareTo(div.getTxtKaishiYoteiTime().getValue()) == 0
                      && strToTime(result.get合議体終了予定時刻()).compareTo(div.getTxtShuryoYoteiTime().getValue()) == 0
                      && result.get介護認定審査会予定定員() == div.getTxtYoteiTeiin().getValue().intValue()
                      && result.get介護認定審査会自動割当定員() == div.getTxtJidoWariateTeiin().getValue().intValue()
                      && result.get介護認定審査会委員定員() == div.getTxtIinTeiin().getValue().intValue()
                      && result.is合議体精神科医存在フラグ() == div.getRadSeishinkaiSonzai().getSelectedKey().equals(SEISHINKAI_SONZAI_SURU)
                      && result.is合議体ダミーフラグ() == div.getRadDummyFlag().getSelectedKey().equals(DUMMY_FLAG_DAMI);

        if (!flg) {
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

    private void setShinsaiMeisai(List<GogitaiJohoSakuseiRsult> resultList) {

        List<dgHoketsuShinsainList_Row> hoketsuShinsainList = new ArrayList<>();
        List<dgShinsainList_Row> shinsainList = new ArrayList<>();
        for (GogitaiJohoSakuseiRsult result : resultList) {
            if (result.is補欠()) {
                dgHoketsuShinsainList_Row hoketsuShinsainRow = new dgHoketsuShinsainList_Row();
                hoketsuShinsainRow.setHoketsuShinsakaiIinShimei(nullToEmpty(result.get審査会委員名称()));
                hoketsuShinsainRow.setHoketsuShinsakaiIinCode(result.get介護認定審査会委員コード());
                hoketsuShinsainList.add(hoketsuShinsainRow);
                continue;
            }
            dgShinsainList_Row shinsainRow = new dgShinsainList_Row();
            shinsainRow.setShinsakaiIinShimei(nullToEmpty(result.get審査会委員名称()));
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
     * 合議体情報編集エリアをクリアします。
     */
    public void cleanGogitaiShosai() {
        div.getTxtYukoShuryoYMD().clearValue();
        div.getTxtYukoKaishiYMD().clearValue();
        div.getTxtYoteiTeiin().clearValue();
        div.getTxtShuryoYoteiTime().clearValue();
        div.getTxtKaishiYoteiTime().clearValue();
        div.getTxtJidoWariateTeiin().clearValue();
        div.getTxtIinTeiin().clearValue();
        div.getTxtGogitaiNumber().clearValue();
        div.getTxtGogitaiMeisho().clearValue();
        div.getDgHoketsuShinsainList().getDataSource().clear();
        div.getDgShinsainList().getDataSource().clear();
        div.getDdlkaisaibasho().setSelectedKey(KAISAI_BASHO_CODE_EMPTY);
        div.getRadSeishinkaiSonzai().setSelectedKey(SEISHINKAI_SONZAI_SHINAI);
        div.getRadDummyFlag().setSelectedKey(DUMMY_FLAG_TUUJOU);
    }

    /**
     * 合議体情報編集エリアの表示制御を設定します。
     *
     * @param flag 表示制御フラグ
     */
    public void setDisableByAdd(boolean flag) {
        div.getDdlkaisaibasho().setDisabled(flag);
        div.getTxtYukoShuryoYMD().setDisabled(flag);
        div.getTxtYukoKaishiYMD().setDisabled(flag);
        div.getTxtYoteiTeiin().setDisabled(flag);
        div.getTxtShuryoYoteiTime().setDisabled(flag);
        div.getTxtKaishiYoteiTime().setDisabled(flag);
        div.getTxtJidoWariateTeiin().setDisabled(flag);
        div.getTxtIinTeiin().setDisabled(flag);
        div.getTxtGogitaiNumber().setDisabled(flag);
        div.getTxtGogitaiMeisho().setDisabled(flag);
        div.getRadSeishinkaiSonzai().setDisabled(flag);
        div.getRadDummyFlag().setDisabled(flag);
        div.getDgShinsainList().setDisabled(flag);
        div.getDgHoketsuShinsainList().setDisabled(flag);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnBatchRegister"), true);
        div.getBtnShinsainSelect().setDisabled(flag);
        div.getBtnSubShinsainSelect().setDisabled(flag);
        div.getBtnback().setDisabled(flag);
        div.getBtnKosin().setDisabled(flag);
    }

    /**
     * 合議体情報一覧の修正場合、部品活性状態を変化します。
     *
     */
    public void setDisableByUpd() {
        div.getBtnTsuika().setDisabled(false);
        div.getDdlkaisaibasho().setDisabled(false);
        div.getTxtYukoShuryoYMD().setDisabled(false);
        div.getTxtYoteiTeiin().setDisabled(false);
        div.getTxtShuryoYoteiTime().setDisabled(false);
        div.getTxtKaishiYoteiTime().setDisabled(false);
        div.getTxtJidoWariateTeiin().setDisabled(false);
        div.getTxtIinTeiin().setDisabled(false);
        div.getTxtGogitaiMeisho().setDisabled(false);
        div.getRadSeishinkaiSonzai().setDisabled(false);
        div.getRadDummyFlag().setDisabled(false);
        div.getDgShinsainList().setDisabled(false);
        div.getDgHoketsuShinsainList().setDisabled(false);
        div.getDgShinsainList().getGridSetting().getColumn(new RString("gogitaicho")).getCellDetails().setDisabled(false);
        div.getDgShinsainList().getGridSetting().getColumn(new RString("fukuGogitaicho")).getCellDetails().setDisabled(false);
        div.getDgShinsainList().getGridSetting().getColumn(new RString("gogitaicho")).getCellDetails().setReadOnly(false);
        div.getDgShinsainList().getGridSetting().getColumn(new RString("fukuGogitaicho")).getCellDetails().setReadOnly(false);
        div.getBtnShinsainSelect().setDisabled(false);
        div.getBtnSubShinsainSelect().setDisabled(false);
        div.getBtnback().setDisabled(false);
        div.getBtnKosin().setDisabled(false);
    }

    /**
     * 合議体情報を設定します。
     *
     * @param gogitaiJohoBuilder 合議体情報ビルダー
     * @param row 合議体情報一覧grid選択行
     * @return GogitaiJohoBuilder
     */
    public GogitaiJohoBuilder getGogitaiJohoBuilder(GogitaiJohoBuilder gogitaiJohoBuilder, dgGogitaiIchiran_Row row) {
        row.setGogitaiNumber(div.getTxtGogitaiNumber().getValue());
        row.setGogitaiName(div.getTxtGogitaiMeisho().getValue());
        row.getGogitaiKaishiYoteiTime().setValue(div.getTxtKaishiYoteiTime().getValue());
        row.getGogitaiShuryoYoteiTime().setValue(div.getTxtShuryoYoteiTime().getValue());
        row.setKaisaiBashoCode(div.getDdlkaisaibasho().getSelectedKey());
        row.getIinTeiin().setValue(div.getTxtIinTeiin().getValue());
        row.getJidoWariateTeiin().setValue(div.getTxtJidoWariateTeiin().getValue());
        row.getYoteiTeiin().setValue(div.getTxtYoteiTeiin().getValue());
        row.getYukoKaishiYMD().setValue(div.getTxtYukoKaishiYMD().getValue());
        row.getYukoShuryoYMD().setValue(div.getTxtYukoShuryoYMD().getValue());
        if (DUMMY_FLAG_DAMI.equals(div.getRadDummyFlag().getSelectedKey())) {
            row.setGogitaiDummyFlag(true);
            gogitaiJohoBuilder.set合議体ダミーフラグ(true);
        } else {
            row.setGogitaiDummyFlag(false);
            gogitaiJohoBuilder.set合議体ダミーフラグ(false);
        }
        if (SEISHINKAI_SONZAI_SURU.equals(div.getRadSeishinkaiSonzai().getSelectedKey())) {
            row.setSeishinkaiSonzai(true);
            gogitaiJohoBuilder.set合議体精神科医存在フラグ(true);
        } else {
            row.setSeishinkaiSonzai(false);
            gogitaiJohoBuilder.set合議体精神科医存在フラグ(false);
        }
        gogitaiJohoBuilder.set合議体名称(div.getTxtGogitaiMeisho().getValue());
        gogitaiJohoBuilder.set合議体開始予定時刻(timeToStr(div.getTxtKaishiYoteiTime().getValue()));
        gogitaiJohoBuilder.set合議体終了予定時刻(timeToStr(div.getTxtShuryoYoteiTime().getValue()));
        gogitaiJohoBuilder.set合議体有効期間終了年月日(new FlexibleDate(div.getTxtYukoShuryoYMD().getValue().toDateString()));
        gogitaiJohoBuilder.set介護認定審査会開催場所コード(div.getDdlkaisaibasho().getSelectedKey());
        gogitaiJohoBuilder.set介護認定審査会予定定員(div.getTxtYoteiTeiin().getValue().intValue());
        gogitaiJohoBuilder.set介護認定審査会自動割当定員(div.getTxtJidoWariateTeiin().getValue() == null
                                            ? 0 : div.getTxtJidoWariateTeiin().getValue().intValue());
        gogitaiJohoBuilder.set介護認定審査会委員定員(div.getTxtIinTeiin().getValue().intValue());
        return gogitaiJohoBuilder;
    }

    /**
     * 割当審査員を設定します。
     *
     * @param shinsainRow 割当審査員一覧選択行
     * @param gogitaiWariateIinJohoBuilder 割当審査員ビルダー
     * @return GogitaiWariateIinJoho
     */
    public GogitaiWariateIinJoho getGogitaiWariateIinJohoByShinsain(dgShinsainList_Row shinsainRow, GogitaiWariateIinJohoBuilder gogitaiWariateIinJohoBuilder) {
        gogitaiWariateIinJohoBuilder.set補欠(false);
        if (shinsainRow.getGogitaicho()) {
            gogitaiWariateIinJohoBuilder.set合議体長区分コード(new Code(GogitaichoKubunCode.合議体長.getコード()));
        } else if (shinsainRow.getFukuGogitaicho()) {
            gogitaiWariateIinJohoBuilder.set合議体長区分コード(new Code(GogitaichoKubunCode.副合議体長.getコード()));
        } else {
            gogitaiWariateIinJohoBuilder.set合議体長区分コード(new Code(GogitaichoKubunCode.通常.getコード()));
        }
        gogitaiWariateIinJohoBuilder.set合議体有効期間終了年月日(new FlexibleDate(div.getTxtYukoShuryoYMD().getValue().toDateString()));
        return gogitaiWariateIinJohoBuilder.build();
    }

    /**
     * 割当補欠審査員を設定します。
     *
     * @param hoketsuShinsainRow 割当補欠審査会委員情報一覧選択行
     * @param gogitaiWariateIinJohoBuilder 割当審査員ビルダー
     * @return GogitaiWariateIinJoho
     */
    public GogitaiWariateIinJoho getGogitaiWariateIinJohoByHoketsu(dgHoketsuShinsainList_Row hoketsuShinsainRow, GogitaiWariateIinJohoBuilder gogitaiWariateIinJohoBuilder) {
        gogitaiWariateIinJohoBuilder.set補欠(true);
        gogitaiWariateIinJohoBuilder.set合議体長区分コード(new Code(GogitaichoKubunCode.通常.getコード()));
        gogitaiWariateIinJohoBuilder.set合議体有効期間終了年月日(new FlexibleDate(div.getTxtYukoShuryoYMD().getValue().toDateString()));
        return gogitaiWariateIinJohoBuilder.build();
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
