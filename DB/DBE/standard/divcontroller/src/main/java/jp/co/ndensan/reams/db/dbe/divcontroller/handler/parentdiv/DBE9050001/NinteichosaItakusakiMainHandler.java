/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE9050001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.basic.SonotaKikanJoho;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9050001.ChosaitakusakiJohoInputDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9050001.NinteichosaItakusakiMainDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9050001.dgSonotaKikanIchiran_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBECodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ChosaKikanKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaItakuKubunCode;
import jp.co.ndensan.reams.ur.urz.definition.core.hokenja.HokenjaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * その他機関マスタ画面のハンドラークラスです。
 *
 * @reamsid_L DBE-1360-010 suguangjun
 */
public class NinteichosaItakusakiMainHandler {

    private static final RString 表示値_有効 = new RString("有効");
    private static final RString 表示値_無効 = new RString("無効");
    private static final RString CODE_有効 = new RString("yuko");
    private static final RString CODE_無効 = new RString("muko");
    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_削除 = new RString("削除");
    private static final RString 状態_修正 = new RString("修正");
    private static final RString ハイフン = new RString("-");
    private static final int INDEX_3 = 3;
    private static final RString 調査委託区分_3 = new RString("3");
    private static final RString 調査委託区分_4 = new RString("4");
    private static final RString 調査委託区分_5 = new RString("5");
    private static final RString 調査委託区分_6 = new RString("6");
    private static final RString 調査委託区分_9 = new RString("9");
    private static final RString KEY0 = new RString("key0");
    private static final RString 保険者_市町村等 = new RString("保険者（市町村等）");
    private static final RString 指定市町村事務受託法人 = new RString("指定市町村事務受託法人");
    private static final RString 指定居宅介護支援事業者 = new RString("指定居宅介護支援事業者");
    private static final RString 介護保険施設 = new RString("介護保険施設");
    private static final RString 介護支援専門員 = new RString("介護支援専門員");
    private static final RString 他市町村 = new RString("他市町村");
    private static final RString その他 = new RString("その他");
    private static final RString 非調査機関 = new RString("非調査機関");
    private static final RString 調査機関 = new RString("調査機関");

    private final NinteichosaItakusakiMainDiv div;

    /**
     * コンストラクタです。
     *
     * @param div その他機関マスタDiv
     */
    public NinteichosaItakusakiMainHandler(NinteichosaItakusakiMainDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     */
    public void load() {
        div.getCcdhokensha().loadHokenshaList(GyomuBunrui.介護認定);
        div.getChosaitakusakiJohoInput().getCcdChiku().load(DBECodeShubetsu.調査地区コード.getコード());
        div.getRadSearchHaisiFlag().setSelectedKey(KEY0);
        div.getTxtSaidaiHyojiKensu().setValue(new Decimal(DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
        div.getDdlitakukubun().setDataSource(setItakukubun());
        div.getDdlkikankubun().setDataSource(setKikankubun());
    }

    /**
     * 調査委託区分を設定します。
     *
     * @return List<KeyValueDataSource>
     */
    public List<KeyValueDataSource> setItakukubun() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (ChosaItakuKubunCode kubunCode : ChosaItakuKubunCode.values()) {
            KeyValueDataSource kukubunDataSource = new KeyValueDataSource(kubunCode.getコード(),
                    kubunCode.get名称());
            dataSource.add(kukubunDataSource);
        }
        return dataSource;
    }

    /**
     * 機関の区分を設定します。
     *
     * @return List<KeyValueDataSource>
     */
    public List<KeyValueDataSource> setKikankubun() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (ChosaKikanKubun kubun : ChosaKikanKubun.values()) {
            KeyValueDataSource kukubunDataSource = new KeyValueDataSource(kubun.getコード(),
                    kubun.get名称());
            dataSource.add(kukubunDataSource);
        }
        return dataSource;
    }

    /**
     * 検索条件入力項目をクリアします。
     */
    public void clearKensakuJoken() {
        div.getCcdhokensha().loadHokenshaList(GyomuBunrui.介護認定);
        div.getRadSearchHaisiFlag().setSelectedKey(KEY0);
        div.getTxtSearchSonotaKikanCodeFrom().clearValue();
        div.getTxtSearchSonotaKikanCodeTo().clearValue();
        div.getTxtSearchSonotaKikanMeisho().clearValue();
        div.getTxtSearchSonotaKikanKanaMeisho().clearValue();
        div.getDdlitakukubun().getDataSource().clear();
        div.getDdlkikankubun().getDataSource().clear();
        div.getTxtSaidaiHyojiKensu().clearValue();
    }

    /**
     * その他機関一覧へのデータを設定します。
     *
     * @param sonotaKikanJohoList その他機関一覧List
     */
    public void setSonotaKikanichiran(List<SonotaKikanJoho> sonotaKikanJohoList) {
        List<dgSonotaKikanIchiran_Row> dataGridList = new ArrayList<>();
        for (SonotaKikanJoho sonotaKikanJoho : sonotaKikanJohoList) {
            dataGridList.add(createDgSonotaKikanichiranRow(
                    RString.EMPTY,
                    sonotaKikanJoho.get証記載保険者番号(),
                    sonotaKikanJoho.getその他機関コード(),
                    sonotaKikanJoho.get機関名称(),
                    sonotaKikanJoho.get機関名称カナ(),
                    sonotaKikanJoho.get郵便番号(),
                    sonotaKikanJoho.get住所(),
                    sonotaKikanJoho.get住所カナ(),
                    sonotaKikanJoho.get電話番号(),
                    sonotaKikanJoho.get調査委託区分(),
                    sonotaKikanJoho.get割付定員(),
                    sonotaKikanJoho.get割付地区(),
                    sonotaKikanJoho.get機関の区分(),
                    sonotaKikanJoho.is廃止フラグ()
            ));
        }
        div.getSonotaKikanichiran().getDgSonotaKikanIchiran().setDataSource(dataGridList);
    }

    private dgSonotaKikanIchiran_Row createDgSonotaKikanichiranRow(
            RString jotai,
            ShoKisaiHokenshaNo hokensha,
            RString sonotaKikanCode,
            RString kikanMeisho,
            RString kikanKana,
            YubinNo yubinNo,
            RString jusho,
            RString jushoKana,
            TelNo telNo,
            RString chosaItakuKubun,
            int waritsukeTeiin,
            ChikuCode chiku,
            RString kikanKubun,
            boolean jokyoFlag
    ) {
        dgSonotaKikanIchiran_Row row = new dgSonotaKikanIchiran_Row();
        row.setJotai(nullToEmpty(jotai));
        if (hokensha != null) {
            row.setHokensha(hokensha.value());
        }
        row.setSonotaKikanCode(sonotaKikanCode);
        row.setKikanMeisho(nullToEmpty(kikanMeisho));
        row.setKikanKana(nullToEmpty(kikanKana));
        if (yubinNo != null) {
            row.setYubinNo(editYubinNoToIchiran(yubinNo.value()));
        }
        row.setJusho(nullToEmpty(jusho));
        row.setJushoKana(nullToEmpty(jushoKana));
        row.setTelNo(telNo.value());
        if (chosaItakuKubun != null) {
            row.setChosaItakuKubun(nullToEmpty(ChosaItakuKubunCode.toValue(chosaItakuKubun).get名称()));
        }
        TextBoxNum num = new TextBoxNum();
        num.setValue(new Decimal(waritsukeTeiin));
        row.setWaritsukeTeiin(num);
        row.setChiku(chiku.value());
        row.setKikanKubun(nullToEmpty(ChosaKikanKubun.toValue(kikanKubun).get名称()));
        if (jokyoFlag) {
            row.setJokyoFlag(表示値_無効);
        } else {
            row.setJokyoFlag(表示値_有効);
        }
        return row;
    }

    /**
     * その他機関詳細情報を設定します。
     *
     * @param row その他機関詳細情報
     */
    public void setChosaitakusakiJohoInput(dgSonotaKikanIchiran_Row row) {
        div.getChosaitakusakiJohoInput().getCcdHokenshaJoho().intialize(new HokenjaNo(row.getHokensha()));
        div.getChosaitakusakiJohoInput().getTxtSonotaKikanCode().setValue(row.getSonotaKikanCode());
        div.getChosaitakusakiJohoInput().getTxtSonotaKikanname().setValue(row.getKikanMeisho());
        div.getChosaitakusakiJohoInput().getTxtSonotaKikanKananame().setValue(row.getKikanKana());
        if (row.getYubinNo() != null) {
            div.getChosaitakusakiJohoInput().getTxtYubinNo().setValue(new YubinNo(row.getYubinNo()));
        }
        if (row.getJusho() != null) {
            div.getChosaitakusakiJohoInput().getTxtJusho().setDomain(new AtenaJusho(row.getJusho()));
        }
        if (row.getJushoKana() != null) {
            div.getChosaitakusakiJohoInput().getTxtJushoKana().setDomain(new AtenaJusho(row.getJushoKana()));
        }
        if (row.getTelNo() != null) {
            div.getChosaitakusakiJohoInput().getTxtTelNo().setDomain(new TelNo(row.getTelNo()));
        }
        if (row.getWaritsukeTeiin().getValue() != null) {
            div.getChosaitakusakiJohoInput().getTxtteiin().setValue(row.getWaritsukeTeiin().getValue());
        }
        div.getChosaitakusakiJohoInput().getCcdChiku().applyNoOptionCodeMaster().load(SubGyomuCode.DBE認定支援, DBECodeShubetsu.調査地区コード.getコード(),
                new Code(row.getChiku()));
        div.getChosaitakusakiJohoInput().getDdlItakusakikubun().setDataSource(setItakukubun());
        if (!RString.isNullOrEmpty(row.getChosaItakuKubun())) {
            div.getChosaitakusakiJohoInput().getDdlItakusakikubun().setSelectedKey(get調査委託区分(row));
        }
        div.getChosaitakusakiJohoInput().getDdlKikankubun().setDataSource(setKikankubun());
        if (!RString.isNullOrEmpty(row.getKikanKubun())) {
            div.getChosaitakusakiJohoInput().getDdlKikankubun().setSelectedKey(get機関の区分(row));
        }
        if (表示値_有効.equals(row.getJokyoFlag())) {
            div.getChosaitakusakiJohoInput().getRadHaishiFlag().setSelectedKey(CODE_有効);
        } else {
            div.getChosaitakusakiJohoInput().getRadHaishiFlag().setSelectedKey(CODE_無効);
        }
    }

    private RString get調査委託区分(dgSonotaKikanIchiran_Row row) {
        RString 調査委託区分 = RString.EMPTY;
        if (保険者_市町村等.equals(row.getChosaItakuKubun())) {
            調査委託区分 = new RString("1");
        } else if (指定市町村事務受託法人.equals(row.getChosaItakuKubun())) {
            調査委託区分 = new RString("2");
        } else if (指定居宅介護支援事業者.equals(row.getChosaItakuKubun())) {
            調査委託区分 = 調査委託区分_3;
        } else if (介護保険施設.equals(row.getChosaItakuKubun())) {
            調査委託区分 = 調査委託区分_4;
        } else if (介護支援専門員.equals(row.getChosaItakuKubun())) {
            調査委託区分 = 調査委託区分_5;
        } else if (他市町村.equals(row.getChosaItakuKubun())) {
            調査委託区分 = 調査委託区分_6;
        } else if (その他.equals(row.getChosaItakuKubun())) {
            調査委託区分 = 調査委託区分_9;
        }
        return 調査委託区分;
    }

    private RString get機関の区分(dgSonotaKikanIchiran_Row row) {
        RString 機関の区分 = RString.EMPTY;
        if (非調査機関.equals(row.getKikanKubun())) {
            機関の区分 = new RString("0");
        } else if (調査機関.equals(row.getKikanKubun())) {
            機関の区分 = new RString("1");
        }
        return 機関の区分;
    }

    private RString nullToEmpty(RString obj) {
        if (obj == null) {
            return RString.EMPTY;
        }
        return obj;
    }

    /**
     * その他機関情報を設定します。
     *
     * @param eventJotai 状態
     */
    public void setSonotaKikanichiran(RString eventJotai) {
        dgSonotaKikanIchiran_Row row = new dgSonotaKikanIchiran_Row();
        if (!状態_追加.equals(eventJotai)) {
            row = div.getSonotaKikanichiran().getDgSonotaKikanIchiran().getActiveRow();
        }
        row.setHokensha(nullToEmpty(div.getChosaitakusakiJohoInput().getCcdHokenshaJoho().getHokenjaNo()));
        row.setSonotaKikanCode(div.getChosaitakusakiJohoInput().getTxtSonotaKikanCode().getValue());
        row.setKikanMeisho(nullToEmpty(div.getChosaitakusakiJohoInput().getTxtSonotaKikanname().getValue()));
        row.setKikanKana(nullToEmpty(div.getChosaitakusakiJohoInput().getTxtSonotaKikanKananame().getValue()));
        row.setYubinNo(editYubinNoToIchiran(div.getChosaitakusakiJohoInput().getTxtYubinNo().getValue().value()));
        row.setJusho(nullToEmpty(div.getChosaitakusakiJohoInput().getTxtJusho().getDomain().value()));
        row.setJushoKana(nullToEmpty(div.getChosaitakusakiJohoInput().getTxtJushoKana().getDomain().value()));
        row.setTelNo(nullToEmpty(div.getChosaitakusakiJohoInput().getTxtTelNo().getDomain().value()));
        row.setChosaItakuKubun(nullToEmpty(div.getChosaitakusakiJohoInput().getDdlItakusakikubun().getSelectedValue()));
        TextBoxNum num = new TextBoxNum();
        if (div.getChosaitakusakiJohoInput().getTxtteiin().getValue() != null) {
            num.setValue(new Decimal(div.getChosaitakusakiJohoInput().getTxtteiin().getValue().toString()));
            row.setWaritsukeTeiin(num);
        }
        if (div.getChosaitakusakiJohoInput().getCcdChiku() != null) {
            row.setChiku(div.getChosaitakusakiJohoInput().getCcdChiku().getCode().value());
        }
        row.setKikanKubun(nullToEmpty(div.getChosaitakusakiJohoInput().getDdlKikankubun().getSelectedValue()));
        if (CODE_有効.equals(div.getChosaitakusakiJohoInput().getRadHaishiFlag().getSelectedKey())) {
            row.setJokyoFlag(表示値_有効);
        } else {
            row.setJokyoFlag(表示値_無効);
        }
        int index = div.getSonotaKikanichiran().getDgSonotaKikanIchiran().getClickedRowId();
        if (状態_追加.equals(eventJotai)) {
            row.setJotai(eventJotai);
            div.getSonotaKikanichiran().getDgSonotaKikanIchiran().getDataSource().add(row);
        } else if (状態_削除.equals(eventJotai) && 状態_追加.equals(row.getJotai())) {
            div.getSonotaKikanichiran().getDgSonotaKikanIchiran().getDataSource().remove(index);
        } else if (状態_修正.equals(eventJotai) && 状態_追加.equals(row.getJotai())) {
            div.getSonotaKikanichiran().getDgSonotaKikanIchiran().getDataSource().set(index, row);
        } else {
            row.setJotai(eventJotai);
            div.getSonotaKikanichiran().getDgSonotaKikanIchiran().getDataSource().set(index, row);
        }
    }

    private RString editYubinNoToIchiran(RString yubinNo) {
        RStringBuilder yubinNoSb = new RStringBuilder();
        if (INDEX_3 <= yubinNo.length()) {
            yubinNoSb.append(yubinNo.substring(0, INDEX_3));
            yubinNoSb.append(ハイフン);
            yubinNoSb.append(yubinNo.substring(INDEX_3));
        } else {
            yubinNoSb.append(yubinNo);
        }
        return yubinNoSb.toRString();
    }

    /**
     * その他機関情報を設定します。
     *
     * @param sonotaKikanJoho その他機関情報
     * @return sonotaKikanJoho その他機関情報
     */
    public SonotaKikanJoho editSonotaKikanJoho(SonotaKikanJoho sonotaKikanJoho) {
        Decimal chosaKanoNinzu = div.getChosaitakusakiJohoInput().getTxtteiin().getValue();
        int 割付定員 = 0;
        if (chosaKanoNinzu != null) {
            割付定員 = chosaKanoNinzu.intValue();
        }
        return sonotaKikanJoho.createBuilderForEdit()
                .set機関名称(div.getChosaitakusakiJohoInput().getTxtSonotaKikanname().getValue())
                .set機関名称カナ(div.getChosaitakusakiJohoInput().getTxtSonotaKikanKananame().getValue())
                .set郵便番号(div.getChosaitakusakiJohoInput().getTxtYubinNo().getValue())
                .set住所(div.getChosaitakusakiJohoInput().getTxtJusho().getDomain().value())
                .set住所カナ(div.getChosaitakusakiJohoInput().getTxtJushoKana().getDomain().value())
                .set電話番号(div.getChosaitakusakiJohoInput().getTxtTelNo().getDomain())
                .set調査委託区分(div.getChosaitakusakiJohoInput().getDdlItakusakikubun().getSelectedKey())
                .set割付定員(割付定員)
                .set割付地区(new ChikuCode(div.getChosaitakusakiJohoInput().getCcdChiku().getCode().value()))
                .set機関の区分(div.getChosaitakusakiJohoInput().getDdlKikankubun().getSelectedKey())
                .set廃止フラグ(CODE_無効.equals(div.getChosaitakusakiJohoInput().getRadHaishiFlag().getSelectedKey())).build();
    }

    /**
     * その他機関情報エリアをクリアします。
     */
    public void clearChosaitakusakiJohoInput() {
        div.getChosaitakusakiJohoInput().getCcdHokenshaJoho().clear();
        div.getChosaitakusakiJohoInput().getTxtSonotaKikanCode().clearValue();
        div.getChosaitakusakiJohoInput().getTxtSonotaKikanname().clearValue();
        div.getChosaitakusakiJohoInput().getTxtSonotaKikanKananame().clearValue();
        div.getChosaitakusakiJohoInput().getTxtYubinNo().clearValue();
        div.getChosaitakusakiJohoInput().getTxtJusho().clearDomain();
        div.getChosaitakusakiJohoInput().getTxtJushoKana().clearDomain();
        div.getChosaitakusakiJohoInput().getTxtTelNo().clearDomain();
        div.getChosaitakusakiJohoInput().getDdlItakusakikubun().setSelectedIndex(0);
        div.getChosaitakusakiJohoInput().getTxtteiin().clearValue();
        div.getChosaitakusakiJohoInput().getCcdChiku().clearDisplayedValues();
        div.getChosaitakusakiJohoInput().getDdlKikankubun().setSelectedIndex(0);
        div.getChosaitakusakiJohoInput().getRadHaishiFlag().setSelectedKey(CODE_有効);
    }

    /**
     * その他機関情報登録エリアが非活性に設定します。
     */
    public void setDisabledTrueToChosaitakusakiJohoInput() {
        div.getChosaitakusakiJohoInput().getCcdHokenshaJoho().setDisabled(true);
        div.getChosaitakusakiJohoInput().getTxtSonotaKikanCode().setDisabled(true);
        div.getChosaitakusakiJohoInput().getTxtSonotaKikanname().setDisabled(true);
        div.getChosaitakusakiJohoInput().getTxtSonotaKikanKananame().setDisabled(true);
        div.getChosaitakusakiJohoInput().getTxtYubinNo().setDisabled(true);
        div.getChosaitakusakiJohoInput().getTxtJusho().setDisabled(true);
        div.getChosaitakusakiJohoInput().getTxtJushoKana().setDisabled(true);
        div.getChosaitakusakiJohoInput().getTxtTelNo().setDisabled(true);
        div.getChosaitakusakiJohoInput().getDdlItakusakikubun().setDisabled(true);
        div.getChosaitakusakiJohoInput().getTxtteiin().setDisabled(true);
        div.getChosaitakusakiJohoInput().getCcdChiku().setDisabled(true);
        div.getChosaitakusakiJohoInput().getDdlKikankubun().setDisabled(true);
        div.getChosaitakusakiJohoInput().getRadHaishiFlag().setDisabled(true);
    }

    /**
     * 主治医情報登録エリアが活性に設定します。
     */
    public void setDisabledFalseToShujiiJohoInputMeisai() {
        div.getChosaitakusakiJohoInput().getCcdHokenshaJoho().setDisabled(false);
        div.getChosaitakusakiJohoInput().getTxtSonotaKikanCode().setDisabled(false);
        div.getChosaitakusakiJohoInput().getTxtSonotaKikanname().setDisabled(false);
        div.getChosaitakusakiJohoInput().getTxtSonotaKikanKananame().setDisabled(false);
        div.getChosaitakusakiJohoInput().getTxtYubinNo().setDisabled(false);
        div.getChosaitakusakiJohoInput().getTxtJusho().setDisabled(false);
        div.getChosaitakusakiJohoInput().getTxtJushoKana().setDisabled(false);
        div.getChosaitakusakiJohoInput().getTxtTelNo().setDisabled(false);
        div.getChosaitakusakiJohoInput().getDdlItakusakikubun().setDisabled(false);
        div.getChosaitakusakiJohoInput().getTxtteiin().setDisabled(false);
        div.getChosaitakusakiJohoInput().getCcdChiku().setDisabled(false);
        div.getChosaitakusakiJohoInput().getDdlKikankubun().setDisabled(false);
        div.getChosaitakusakiJohoInput().getRadHaishiFlag().setDisabled(false);
    }

    /**
     * 主治医情報登録エリアを編集します。
     *
     * @return 編集結果
     */
    public RString getInputDiv() {
        RStringBuilder inputDiv = new RStringBuilder();
        ChosaitakusakiJohoInputDiv shujiiJohoInputDiv = div.getChosaitakusakiJohoInput();
        inputDiv.append(shujiiJohoInputDiv.getTxtSonotaKikanCode().getValue());
        inputDiv.append(shujiiJohoInputDiv.getTxtSonotaKikanname().getValue());
        inputDiv.append(shujiiJohoInputDiv.getTxtSonotaKikanKananame().getValue());
        inputDiv.append(shujiiJohoInputDiv.getTxtYubinNo().getValue().value());
        inputDiv.append(shujiiJohoInputDiv.getTxtJusho().getDomain().value());
        inputDiv.append(shujiiJohoInputDiv.getTxtJushoKana().getDomain().value());
        inputDiv.append(shujiiJohoInputDiv.getTxtTelNo().getDomain().value());
        inputDiv.append(shujiiJohoInputDiv.getDdlItakusakikubun().getSelectedKey());
        Decimal tteiin = shujiiJohoInputDiv.getTxtteiin().getValue();
        if (tteiin == null) {
            inputDiv.append(RString.EMPTY);
        } else {
            inputDiv.append(shujiiJohoInputDiv.getTxtteiin().getValue());
        }
        inputDiv.append(shujiiJohoInputDiv.getCcdChiku().getCode().value());
        inputDiv.append(shujiiJohoInputDiv.getDdlKikankubun().getSelectedKey());
        inputDiv.append((shujiiJohoInputDiv.getRadHaishiFlag().getSelectedKey()));
        return inputDiv.toRString();
    }
}
