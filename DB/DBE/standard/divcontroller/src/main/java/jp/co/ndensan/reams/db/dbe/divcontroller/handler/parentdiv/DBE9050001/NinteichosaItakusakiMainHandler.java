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
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaItakuKubunCode;
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
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
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
    private static final RString KEY0 = new RString("key0");

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
        KeyValueDataSource kukubunDataSource1 = new KeyValueDataSource(ChosaItakuKubunCode.保険者_市町村等.getコード(),
                ChosaItakuKubunCode.保険者_市町村等.get名称());
        KeyValueDataSource kukubunDataSource2 = new KeyValueDataSource(ChosaItakuKubunCode.指定市町村事務受託法人.getコード(),
                ChosaItakuKubunCode.指定市町村事務受託法人.get名称());
        KeyValueDataSource kukubunDataSource3 = new KeyValueDataSource(ChosaItakuKubunCode.指定居宅介護支援事業者.getコード(),
                ChosaItakuKubunCode.指定居宅介護支援事業者.get名称());
        KeyValueDataSource kukubunDataSource4 = new KeyValueDataSource(ChosaItakuKubunCode.介護保険施設.getコード(),
                ChosaItakuKubunCode.介護保険施設.get名称());
        KeyValueDataSource kukubunDataSource5 = new KeyValueDataSource(ChosaItakuKubunCode.介護支援専門員.getコード(),
                ChosaItakuKubunCode.介護支援専門員.get名称());
        KeyValueDataSource kukubunDataSource6 = new KeyValueDataSource(ChosaItakuKubunCode.他市町村.getコード(),
                ChosaItakuKubunCode.他市町村.get名称());
        KeyValueDataSource kukubunDataSource9 = new KeyValueDataSource(ChosaItakuKubunCode.その他.getコード(),
                ChosaItakuKubunCode.その他.get名称());
        dataSource.add(kukubunDataSource1);
        dataSource.add(kukubunDataSource2);
        dataSource.add(kukubunDataSource3);
        dataSource.add(kukubunDataSource4);
        dataSource.add(kukubunDataSource5);
        dataSource.add(kukubunDataSource6);
        dataSource.add(kukubunDataSource9);
        return dataSource;
    }

    /**
     * 機関の区分を設定します。
     *
     * @return List<KeyValueDataSource>
     */
    public List<KeyValueDataSource> setKikankubun() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        KeyValueDataSource kukubunDataSource1 = new KeyValueDataSource(ChosaItakuKubunCode.保険者_市町村等.getコード(),
                ChosaItakuKubunCode.保険者_市町村等.get名称());
        KeyValueDataSource kukubunDataSource2 = new KeyValueDataSource(ChosaItakuKubunCode.指定市町村事務受託法人.getコード(),
                ChosaItakuKubunCode.指定市町村事務受託法人.get名称());
        dataSource.add(kukubunDataSource1);
        dataSource.add(kukubunDataSource2);
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
        div.getDdlitakukubun().setSelectedIndex(1);
        div.getDdlkikankubun().setSelectedIndex(1);
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
        row.setJotai(jotai);
        row.setHokensha(hokensha == null ? RString.EMPTY : hokensha.value());
        TextBoxCode kikanCode = new TextBoxCode();
        kikanCode.setValue(nullToEmpty(sonotaKikanCode));
        row.setSonotaKikanCode(kikanCode);
        row.setKikanMeisho(kikanMeisho);
        row.setKikanKana(kikanKana);
        row.setYubinNo(yubinNo == null ? RString.EMPTY : yubinNo.value());
        row.setJusho(jusho);
        row.setJushoKana(jushoKana);
        row.setTelNo(telNo == null ? RString.EMPTY : telNo.value());
        row.setChosaItakuKubun(chosaItakuKubun);
        TextBoxNum num = new TextBoxNum();
        num.setValue(new Decimal(waritsukeTeiin));
        row.setChiku(chiku == null ? RString.EMPTY : chiku.value());
        row.setKikanKubun(kikanKubun);
        row.setJokyoFlag(jokyoFlag ? 表示値_有効 : 表示値_無効);
        return row;
    }

    /**
     * その他機関詳細情報を設定します。
     *
     * @param row その他機関詳細情報
     */
    public void setChosaitakusakiJohoInput(dgSonotaKikanIchiran_Row row) {
        div.getChosaitakusakiJohoInput().getCcdHokenshaJoho().setHokenjaNo(row.getHokensha());
        div.getChosaitakusakiJohoInput().getTxtSonotaKikanCode().setValue(row.getSonotaKikanCode().getValue());
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
            div.getChosaitakusakiJohoInput().getTxtteiin().setValue(new YubinNo(row.getWaritsukeTeiin().getValue().toString()));
        }
        div.getChosaitakusakiJohoInput().getCcdChiku().applyNoOptionCodeMaster().load(SubGyomuCode.DBE認定支援, DBECodeShubetsu.調査地区コード.getコード(),
                new Code(row.getChiku()));
        div.getChosaitakusakiJohoInput().getDdlItakusakikubun().setDataSource(setItakukubun());
        if (!RString.isNullOrEmpty(row.getChosaItakuKubun())) {
            div.getChosaitakusakiJohoInput().getDdlItakusakikubun().setSelectedKey(row.getChosaItakuKubun());
        }
        div.getChosaitakusakiJohoInput().getDdlKikankubun().setDataSource(setKikankubun());
        if (!RString.isNullOrEmpty(row.getKikanKubun())) {
            div.getChosaitakusakiJohoInput().getDdlKikankubun().setSelectedKey(row.getKikanKubun());
        }
        if (表示値_有効.equals(row.getJokyoFlag())) {
            div.getChosaitakusakiJohoInput().getRadHaishiFlag().setSelectedKey(CODE_有効);
        } else {
            div.getChosaitakusakiJohoInput().getRadHaishiFlag().setSelectedKey(CODE_無効);
        }
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
        row.setSonotaKikanCode(div.getChosaitakusakiJohoInput().getTxtSonotaKikanCode());
        row.setKikanMeisho(nullToEmpty(div.getChosaitakusakiJohoInput().getTxtSonotaKikanname().getValue()));
        row.setKikanKana(nullToEmpty(div.getChosaitakusakiJohoInput().getTxtSonotaKikanKananame().getValue()));
        row.setYubinNo(editYubinNoToIchiran(div.getChosaitakusakiJohoInput().getTxtYubinNo().getValue().value()));
        row.setJusho(nullToEmpty(div.getChosaitakusakiJohoInput().getTxtJusho().getDomain().value()));
        row.setJushoKana(nullToEmpty(div.getChosaitakusakiJohoInput().getTxtJushoKana().getDomain().value()));
        row.setTelNo(nullToEmpty(div.getChosaitakusakiJohoInput().getTxtTelNo().getDomain().value()));
        row.setChosaItakuKubun(nullToEmpty(div.getChosaitakusakiJohoInput().getDdlItakusakikubun().getSelectedKey()));
        TextBoxNum num = new TextBoxNum();
        if (div.getChosaitakusakiJohoInput().getTxtteiin().getValue() != null) {
            num.setValue(new Decimal(div.getChosaitakusakiJohoInput().getTxtteiin().getValue().toString()));
            row.setWaritsukeTeiin(num);
        }
        if (div.getChosaitakusakiJohoInput().getCcdChiku() != null) {
            row.setChiku(div.getChosaitakusakiJohoInput().getCcdChiku().getCode().value());
        }
        row.setKikanKubun(nullToEmpty(div.getChosaitakusakiJohoInput().getDdlKikankubun().getSelectedKey()));
        if (CODE_有効.equals(div.getChosaitakusakiJohoInput().getRadHaishiFlag().getSelectedKey())) {
            row.setJokyoFlag(表示値_有効);
        } else {
            row.setJokyoFlag(表示値_無効);
        }
        row.setJokyoFlag(nullToEmpty(div.getChosaitakusakiJohoInput().getRadHaishiFlag().getSelectedKey()));
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
        RString teiin = RString.EMPTY;
        if (!div.getChosaitakusakiJohoInput().getTxtteiin().getValue().isEmpty()) {
            teiin = div.getChosaitakusakiJohoInput().getTxtteiin().getValue().value();
        }
        return sonotaKikanJoho.createBuilderForEdit()
                .set機関名称(div.getChosaitakusakiJohoInput().getTxtSonotaKikanname().getValue())
                .set機関名称カナ(div.getChosaitakusakiJohoInput().getTxtSonotaKikanKananame().getValue())
                .set郵便番号(div.getChosaitakusakiJohoInput().getTxtYubinNo().getValue())
                .set住所(div.getChosaitakusakiJohoInput().getTxtJusho().getDomain().value())
                .set住所カナ(div.getChosaitakusakiJohoInput().getTxtJushoKana().getDomain().value())
                .set電話番号(div.getChosaitakusakiJohoInput().getTxtTelNo().getDomain())
                .set調査委託区分(div.getChosaitakusakiJohoInput().getDdlItakusakikubun().getSelectedKey())
                .set割付定員(Integer.parseInt(teiin.toString()))
                .set割付地区(new ChikuCode(div.getChosaitakusakiJohoInput().getCcdChiku().getCode().value()))
                .set機関の区分(div.getChosaitakusakiJohoInput().getDdlKikankubun().getSelectedKey())
                .set廃止フラグ(CODE_有効.equals(div.getChosaitakusakiJohoInput().getRadHaishiFlag().getSelectedKey())).build();
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
        inputDiv.append(shujiiJohoInputDiv.getTxtYubinNo().getValue());
        inputDiv.append(shujiiJohoInputDiv.getTxtJusho().getDomain());
        inputDiv.append(shujiiJohoInputDiv.getTxtJushoKana().getDomain());
        inputDiv.append(shujiiJohoInputDiv.getTxtTelNo().getDomain());
        inputDiv.append(shujiiJohoInputDiv.getDdlItakusakikubun().getSelectedKey());
        inputDiv.append(shujiiJohoInputDiv.getTxtteiin().getValue());
        inputDiv.append(shujiiJohoInputDiv.getCcdChiku().getCode().value());
        inputDiv.append(shujiiJohoInputDiv.getDdlKikankubun().getSelectedKey());
        inputDiv.append((shujiiJohoInputDiv.getRadHaishiFlag().getSelectedKey()));
        return inputDiv.toRString();
    }
}
