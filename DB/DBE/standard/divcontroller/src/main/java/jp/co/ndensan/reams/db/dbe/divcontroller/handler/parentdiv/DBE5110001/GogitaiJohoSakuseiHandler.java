/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5110001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.gogitaijoho.GogitaiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.gogitaiwariateiinjoho.GogitaiWariateIinJoho;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijohosakusei.GogitaiJohoSakuseiRsult;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Hoshu.GogitaichoKubunCode;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsakai.IsGogitaiDummy;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsakai.IsGogitaiSeishinkaSonzai;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5110001.GogitaiJohoSakuseiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5110001.dgGogitaiIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5110001.dgHoketsuShinsainList_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5110001.dgShinsainList_Row;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 合議体情報作成の抽象Handlerクラスです。
 *
 */
public class GogitaiJohoSakuseiHandler {

    private static final RString HYOJI_JOKEN_GENZAI_YUUKOU = new RString("key1");
    private static final RString SEISHINKAI_SONZAI_SURU = new RString("key0");
    private static final RString SEISHINKAI_SONZAI_SHINAI = new RString("key1");
    private static final RString DUMMY_FLAG_TUUJOU = new RString("key0");
    private static final RString DUMMY_FLAG_DAMI = new RString("key1");
    private static final RString JYOTAI_CODE_ADD = new RString("1");
    private static final RString JYOTAI_NAME_ADD = new RString("追加");
    private static final RString JYOTAI_CODE_UPD = new RString("2");
    private static final RString JYOTAI_NAME_UPD = new RString("修正");
    private static final RString JYOTAI_CODE_DEL = new RString("3");
    private static final RString JYOTAI_NAME_DEL = new RString("削除");

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
        this.cleanGogitaiShosai();
        div.getRadHyojiJoken().setSelectedKey(HYOJI_JOKEN_GENZAI_YUUKOU);
        div.getDgGogitaiIchiran().getDataSource().clear();
        div.getRadSeishinkaiSonzai().setSelectedKey(SEISHINKAI_SONZAI_SHINAI);
        div.getRadDummyFlag().setSelectedKey(DUMMY_FLAG_TUUJOU);
        div.getDdlkaisaibasho().setDataSource(resultList);
        this.setDisableByAdd(true);

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
            if (JYOTAI_CODE_ADD.equals(result.getStatus())) {
                row.setJyotai(JYOTAI_NAME_ADD);
            }
            if (JYOTAI_CODE_UPD.equals(result.getStatus())) {
                row.setJyotai(JYOTAI_NAME_UPD);
            }
            if (JYOTAI_CODE_DEL.equals(result.getStatus())) {
                row.setJyotai(JYOTAI_NAME_DEL);
            }
            row.setGogitaiNumber(new RString(String.valueOf(result.get合議体番号())));
            row.setGogitaiName(result.get合議体名称());
            row.getYukoKaishiYMD().setValue(new RDate(result.get合議体有効期間開始年月日().wareki().toDateString().toString()));
            row.getYukoShuryoYMD().setValue(new RDate(result.get合議体有効期間終了年月日().wareki().toDateString().toString()));
            row.getGogitaiKaishiYoteiTime().setValue(RTime.parse(result.get合議体開始予定時刻()));
            row.getGogitaiShuryoYoteiTime().setValue(RTime.parse(result.get合議体終了予定時刻()));
            row.setKaisaiBashoCode(result.get介護認定審査会開催場所コード());
            row.setSeishinkaiSonzai(IsGogitaiSeishinkaSonzai.toValue(result.get合議体精神科医存在フラグ()).getコード());
            row.setGogitaiDummyFlag(IsGogitaiDummy.toValue(result.get合議体ダミーフラグ()).getコード());
            row.getYoteiTeiin().setValue(new Decimal(result.get介護認定審査会予定定員()));
            row.getJidoWariateTeiin().setValue(new Decimal(result.get介護認定審査会自動割当定員()));
            row.getIinTeiin().setValue(new Decimal(result.get介護認定審査会委員定員()));
            rowList.add(row);
        }
        div.getDgGogitaiIchiran().setDataSource(rowList);
        this.cleanGogitaiShosai();
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
        div.getDdlkaisaibasho().setSelectedKey(row.getKaisaiBashoCode());
        div.getTxtYukoShuryoYMD().setValue(row.getYukoShuryoYMD().getValue());
        div.getTxtYukoKaishiYMD().setValue(row.getYukoKaishiYMD().getValue());
        div.getTxtShuryoYoteiTime().setValue(row.getGogitaiShuryoYoteiTime().getValue());
        div.getTxtKaishiYoteiTime().setValue(row.getGogitaiKaishiYoteiTime().getValue());
        div.getTxtYoteiTeiin().setValue(row.getYoteiTeiin().getValue());
        div.getTxtJidoWariateTeiin().setValue(row.getJidoWariateTeiin().getValue());
        div.getTxtIinTeiin().setValue(row.getIinTeiin().getValue());
        if (IsGogitaiSeishinkaSonzai.toValue(row.getSeishinkaiSonzai()).getコード()) {
            div.getRadSeishinkaiSonzai().setSelectedKey(SEISHINKAI_SONZAI_SURU);
        }
        div.getRadSeishinkaiSonzai().setSelectedKey(SEISHINKAI_SONZAI_SHINAI);
        if (IsGogitaiDummy.toValue(row.getGogitaiDummyFlag()).getコード()) {
            div.getRadDummyFlag().setSelectedKey(DUMMY_FLAG_DAMI);
        }
        div.getRadDummyFlag().setSelectedKey(DUMMY_FLAG_TUUJOU);
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
        div.getBtnkosin().setDisabled(false);
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
                && div.getDdlkaisaibasho().getSelectedKey().isEmpty()
                && div.getTxtYukoShuryoYMD().getValue() == null
                && div.getTxtYukoKaishiYMD().getValue() == null
                && div.getTxtShuryoYoteiTime().getValue() == null
                && div.getTxtKaishiYoteiTime().getValue() == null
                && div.getTxtYoteiTeiin().getValue() == null
                && div.getTxtJidoWariateTeiin().getValue() == null
                && div.getTxtIinTeiin().getValue() == null
                && div.getRadSeishinkaiSonzai().getSelectedKey().isEmpty()
                && div.getRadDummyFlag().getSelectedKey().isEmpty()
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
                && RTime.parse(result.get合議体開始予定時刻()).compareTo(div.getTxtKaishiYoteiTime().getValue()) == 0
                && RTime.parse(result.get合議体終了予定時刻()).compareTo(div.getTxtShuryoYoteiTime().getValue()) == 0
                && result.get介護認定審査会予定定員() == div.getTxtYoteiTeiin().getValue().intValue()
                && result.get介護認定審査会自動割当定員() == div.getTxtJidoWariateTeiin().getValue().intValue()
                && result.get介護認定審査会委員定員() == div.getTxtIinTeiin().getValue().intValue()
                && result.get合議体精神科医存在フラグ() == div.getRadSeishinkaiSonzai().getSelectedKey().equals(SEISHINKAI_SONZAI_SURU)
                && result.get合議体ダミーフラグ() == div.getRadDummyFlag().getSelectedKey().equals(DUMMY_FLAG_TUUJOU);

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
            if (gogitaiWariateIinJohoList.get(i).get補欠()) {
                if (!gogitaiWariateIinJohoList.get(i).get介護認定審査会委員コード().equals(hoketsuShinsainList.get(i).getHoketsuShinsakaiIinCode())) {
                    return !flg;
                }
                if (!gogitaiWariateIinJohoList.get(i).getShinsakaiIinJohoList().get(0).get介護認定審査会委員氏名().value().equals(hoketsuShinsainList.get(i).getHoketsuShinsakaiIinShimei())) {
                    return !flg;
                }
            } else {
                if (!gogitaiWariateIinJohoList.get(i).get介護認定審査会委員コード().equals(shinsainList.get(i).getShinsakaiIinCode())) {
                    return !flg;
                }

                if (!gogitaiWariateIinJohoList.get(i).getShinsakaiIinJohoList().get(0).get介護認定審査会委員氏名().value().equals(shinsainList.get(i).getShinsakaiIinShimei())) {
                    return !flg;
                }

                if (GogitaichoKubunCode.副合議体長.getコード().equals(gogitaiWariateIinJohoList.get(i).get合議体長区分コード().value())) {
                    if (!shinsainList.get(i).getFukuGogitaicho()) {
                        return !flg;
                    }
                }

                if (GogitaichoKubunCode.合議体長.getコード().equals(gogitaiWariateIinJohoList.get(i).get合議体長区分コード().value())) {
                    if (!shinsainList.get(i).getGogitaicho()) {
                        return !flg;
                    }
                }

                if (GogitaichoKubunCode.通常.getコード().equals(gogitaiWariateIinJohoList.get(i).get合議体長区分コード().value())) {
                    if (shinsainList.get(i).getGogitaicho() || shinsainList.get(i).getFukuGogitaicho()) {
                        return !flg;
                    }
                }
            }
        }
        return flg;
    }

    private void setShinsaiMeisai(List<GogitaiJohoSakuseiRsult> resultList) {

        List<dgHoketsuShinsainList_Row> hoketsuShinsainList = new ArrayList<>();
        List<dgShinsainList_Row> shinsainList = new ArrayList<>();
        for (GogitaiJohoSakuseiRsult result : resultList) {
            if (result.get補欠()) {
                dgHoketsuShinsainList_Row hoketsuShinsainRow = new dgHoketsuShinsainList_Row();
                hoketsuShinsainRow.setHoketsuShinsakaiIinShimei(result.get審査会委員名称().value());
                hoketsuShinsainRow.setHoketsuShinsakaiIinCode(result.get介護認定審査会委員コード());
                hoketsuShinsainList.add(hoketsuShinsainRow);
                continue;
            }
            dgShinsainList_Row shinsainRow = new dgShinsainList_Row();
            shinsainRow.setShinsakaiIinShimei(result.get審査会委員名称().value());
            shinsainRow.setShinsakaiIinCode(result.get介護認定審査会委員コード());
            if (GogitaichoKubunCode.副合議体長.getコード().equals(result.get合議体長区分コード().value())) {
                shinsainRow.setFukuGogitaicho(Boolean.TRUE);
            }
            if (GogitaichoKubunCode.合議体長.getコード().equals(result.get合議体長区分コード().value())) {
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
        div.getRadSeishinkaiSonzai().setSelectedKey(RString.EMPTY);
        div.getRadDummyFlag().setSelectedKey(RString.EMPTY);
    }

    private void setDisableByAdd(boolean flag) {
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
        div.getBtnIkkatsuToroku().setDisabled(flag);
        div.getBtnShinsainSelect().setDisabled(flag);
        div.getBtnSubShinsainSelect().setDisabled(flag);
        div.getBtnback().setDisabled(flag);
        div.getBtnkosin().setDisabled(flag);
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
        div.getBtnShinsainSelect().setDisabled(false);
        div.getBtnSubShinsainSelect().setDisabled(false);
        div.getBtnback().setDisabled(false);
        div.getBtnkosin().setDisabled(false);
    }

    /**
     *
     * 合議体情報一覧エリアの設定します。
     *
     */
//    public void addGogitaiShosai() {
//        div.getTxtGogitaiNumber().setValue(row.getGogitaiNumber());
//        div.getTxtGogitaiMeisho().setValue(row.getGogitaiName());
//        div.getDdlkaisaibasho().setSelectedKey(row.getKaisaiBashoCode());
//        div.getTxtYukoShuryoYMD().setValue(row.getYukoShuryoYMD().getValue());
//        div.getTxtYukoKaishiYMD().setValue(row.getYukoKaishiYMD().getValue());
//        div.getTxtShuryoYoteiTime().setValue(row.getGogitaiShuryoYoteiTime().getValue());
//        div.getTxtKaishiYoteiTime().setValue(row.getGogitaiKaishiYoteiTime().getValue());
//        div.getTxtYoteiTeiin().setValue(row.getYoteiTeiin().getValue());
//        div.getTxtJidoWariateTeiin().setValue(row.getJidoWariateTeiin().getValue());
//        div.getTxtIinTeiin().setValue(row.getIinTeiin().getValue());
//        if (IsGogitaiSeishinkaSonzai.toValue(row.getSeishinkaiSonzai()).getコード()) {
//            div.getRadSeishinkaiSonzai().setSelectedKey(SEISHINKAI_SONZAI_SURU);
//        }
//        div.getRadSeishinkaiSonzai().setSelectedKey(SEISHINKAI_SONZAI_SHINAI);
//        if (IsGogitaiDummy.toValue(row.getGogitaiDummyFlag()).getコード()) {
//            div.getRadDummyFlag().setSelectedKey(DUMMY_FLAG_DAMI);
//        }
//        div.getRadDummyFlag().setSelectedKey(DUMMY_FLAG_TUUJOU);
//        this.setShinsaiMeisai(resultList);
//    }
}
