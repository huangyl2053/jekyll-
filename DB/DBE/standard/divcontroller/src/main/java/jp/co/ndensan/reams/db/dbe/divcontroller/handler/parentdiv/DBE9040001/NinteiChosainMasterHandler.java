package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE9040001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosainmaster.NinteiChosainMaster;
import jp.co.ndensan.reams.db.dbe.business.core.tyousai.chosainjoho.ChosainJoho;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9040001.ChosainJohoInputDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9040001.NinteiChosainMasterDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9040001.dgChosainIchiran_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBECodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.Sikaku;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 * 認定調査員マスタ画面のハンドラークラスです。
 *
 * @reamsid_L DBE-0280-010 sunhaidi
 */
public class NinteiChosainMasterHandler {

    private static final RString 表示値_有効 = new RString("有効");
    private static final RString 表示値_無効 = new RString("無効");
    private static final RString CODE_有効 = new RString("1");
    private static final RString CODE_無効 = new RString("2");
    private static final RString 表示値_男 = new RString("男");
    private static final RString 表示値_女 = new RString("女");
    private static final RString MAN = new RString("1");
    private static final RString WOMAN = new RString("2");
    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_削除 = new RString("削除");
    private static final RString 状態_修正 = new RString("修正");
    private static final RString ハイフン = new RString("-");
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private final NinteiChosainMasterDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 介護認定審査会開催場所情報Div
     */
    public NinteiChosainMasterHandler(NinteiChosainMasterDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     */
    public void load() {

        div.getHokenshaList().loadHokenshaList(GyomuBunrui.介護認定);
        List<UzT0007CodeEntity> codeList = CodeMaster.getCode(SubGyomuCode.DBE認定支援, DBECodeShubetsu.調査地区コード.getコード(),
                FlexibleDate.getNowDate());
        List<KeyValueDataSource> chikuDataSource = new ArrayList<>();
        chikuDataSource.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        for (UzT0007CodeEntity codeEntity : codeList) {
            chikuDataSource.add(new KeyValueDataSource(codeEntity.getコード().getKey(), codeEntity.getコード名称()));
        }
        div.getDdlChikuCode().setDataSource(chikuDataSource);
    }

    /**
     * 検索条件入力項目をクリアします。
     */
    public void clearKensakuJoken() {
        div.getHokenshaList().loadHokenshaList(GyomuBunrui.介護認定);
        div.getTxtSearchChosaItakusakiCodeFrom().clearValue();
        div.getTxtSearchChosaItakusakiCodeTo().clearValue();
        div.getTxtSearchChosaItakusakiMeisho().clearValue();
        div.getTxtSearchChosaItakusakiKanaMeisho().clearValue();
        div.getTxtSearchChosainCodeFrom().clearValue();
        div.getTxtSearchChosainCodeTo().clearValue();
        div.getTxtSearchChosainShimei().clearValue();
        div.getTxtSearchChosainKanaShimei().clearValue();
        div.getDdlChikuCode().setSelectedIndex(0);
        div.getRadSearchChosainJokyo().setSelectedIndex(0);
        div.getTxtSaidaiHyojiKensu().clearValue();
        div.getDdlItakusakiMeisho().setSelectedIndex(0);
        div.getDdlItakusakiKanaMeisho().setSelectedIndex(0);
        div.getDdlChosainMeisho().setSelectedIndex(0);
        div.getDdlChosainKanaMeisho().setSelectedIndex(0);
        div.getTxtSaidaiHyojiKensu().setValue(new Decimal(DbBusinessConfig.get(ConfigNameDBE.データ出力件数閾値, new RDate("20000401"),
                SubGyomuCode.DBE認定支援, new LasdecCode("000000"), new RString("データ出力件数閾値")).toString()));
    }

    /**
     * 調査員一覧へのデータを設定します。
     *
     * @param ninteiChosainMasterList 調査員一覧List
     */
    public void setChosainIchiran(List<NinteiChosainMaster> ninteiChosainMasterList) {
        List<dgChosainIchiran_Row> dataGridList = new ArrayList<>();
        for (NinteiChosainMaster ninteiChosainMaster : ninteiChosainMasterList) {
            dataGridList.add(createDgChosainIchiranRow(
                    RString.EMPTY,
                    ninteiChosainMaster.get市町村コード(),
                    ninteiChosainMaster.get市町村名称(),
                    ninteiChosainMaster.get認定調査員コード(),
                    ninteiChosainMaster.get調査員氏名(),
                    ninteiChosainMaster.get調査員氏名カナ(),
                    ninteiChosainMaster.get認定調査委託先コード(),
                    ninteiChosainMaster.get事業者名称(),
                    ninteiChosainMaster.get性別(),
                    ninteiChosainMaster.get地区コード(),
                    ninteiChosainMaster.get調査員資格(),
                    ninteiChosainMaster.get調査可能人数_月(),
                    ninteiChosainMaster.is状況フラグ(),
                    ninteiChosainMaster.get郵便番号(),
                    ninteiChosainMaster.get住所(),
                    ninteiChosainMaster.get電話番号(),
                    ninteiChosainMaster.getFAX番号(),
                    ninteiChosainMaster.get所属機関名称()));
        }
        div.getChosainIchiran().getDgChosainIchiran().setDataSource(dataGridList);
    }

    private dgChosainIchiran_Row createDgChosainIchiranRow(
            RString jotai,
            LasdecCode shichoson,
            RString shichosonMeisho,
            RString ninteiChosainNo,
            RString chosainShimei,
            RString chosainKanaShimei,
            RString ninteichosaItakusakiCode,
            RString chosaItakusakiMeisho,
            RString seibetsu,
            RString chiku,
            RString chosainShikaku,
            int chosaKanoNinzuPerMonth,
            boolean jokyoFlag,
            YubinNo yubinNo,
            AtenaJusho jusho,
            TelNo telNo,
            TelNo faxNo,
            RString shozokuKikanName) {
        dgChosainIchiran_Row row = new dgChosainIchiran_Row();
        row.setJotai(jotai);
        row.setShichoson(nullToEmpty(shichosonMeisho));
        row.setShichosonCode(nullToEmpty(shichoson.value()));
        TextBoxCode chosainCode = new TextBoxCode();
        chosainCode.setValue(nullToEmpty(ninteiChosainNo));
        row.setChosainCode(chosainCode);
        row.setChosainShimei(nullToEmpty(chosainShimei));
        row.setChosainKanaShimei(nullToEmpty(chosainKanaShimei));
        TextBoxCode chosaItakusakiCode = new TextBoxCode();
        chosaItakusakiCode.setValue(nullToEmpty(ninteichosaItakusakiCode));
        row.setChosaItakusakiCode(chosaItakusakiCode);
        row.setChosaItakusakiMeisho(nullToEmpty(chosaItakusakiMeisho));
        if (MAN.equals(seibetsu)) {
            row.setSeibetsu(表示値_男);
        } else if (WOMAN.equals(seibetsu)) {
            row.setSeibetsu(表示値_女);
        }
        row.setChikuCode(nullToEmpty(chiku));
        RString chikuName = RString.EMPTY;
        if (!RString.isNullOrEmpty(chiku)) {
            chikuName = CodeMaster.getCodeMeisho(SubGyomuCode.DBE認定支援,
                    DBECodeShubetsu.調査地区コード.getコード(),
                    new Code(chiku), FlexibleDate.getNowDate());
        }
        if (!RString.isNullOrEmpty(chikuName)) {
            row.setChiku(chikuName);
        }

        if (!RString.isNullOrEmpty(chosainShikaku)) {
            chosainShikaku = chosainShikaku.trim();
        }
        row.setChosainShikaku(RString.isNullOrEmpty(chosainShikaku) ? RString.EMPTY : Sikaku.toValue(chosainShikaku).get名称());
        row.setChosainShikakuCode(chosainShikaku);
        TextBoxNum chosaKanoNinzu = new TextBoxNum();
        chosaKanoNinzu.setValue(new Decimal(chosaKanoNinzuPerMonth));
        row.setChosaKanoNinzu(chosaKanoNinzu);
        row.setJokyoFlag(jokyoFlag ? 表示値_有効 : 表示値_無効);
        row.setYubinNo(editYubinNoToIchiran(yubinNo != null ? yubinNo.value() : RString.EMPTY));
        row.setJusho(jusho != null ? jusho.value() : RString.EMPTY);
        row.setTelNo(telNo != null ? telNo.value() : RString.EMPTY);
        row.setFaxNo(faxNo != null ? faxNo.value() : RString.EMPTY);
        row.setShozokuKikanName(nullToEmpty(shozokuKikanName));
        return row;
    }

    /**
     * 調査員情報を設定します。
     *
     * @param row 調査員一覧情報
     */
    public void setChosainJohoToMeisai(dgChosainIchiran_Row row) {
        div.getChosainJohoInput().getTxtShichoson().setValue(nullToEmpty(row.getShichosonCode()));
        div.getChosainJohoInput().getTxtShichosonmei().setValue(nullToEmpty(row.getShichoson()));
        div.getChosainJohoInput().getTxtChosaItakusaki().setValue(nullToEmpty(row.getChosaItakusakiCode().getValue()));
        div.getChosainJohoInput().getTxtChosaItakusakiMeisho().setValue(nullToEmpty(row.getChosaItakusakiMeisho()));
        div.getChosainJohoInput().getTxtChosainCode().setValue(nullToEmpty(row.getChosainCode().getValue()));
        div.getChosainJohoInput().getTxtChosainShimei().setValue(nullToEmpty(row.getChosainShimei()));
        div.getChosainJohoInput().getTxtChosainKanaShimei().setValue(nullToEmpty(row.getChosainKanaShimei()));
        div.getChosainJohoInput().getCcdChiku().applyNoOptionCodeMaster().load(SubGyomuCode.DBE認定支援, DBECodeShubetsu.調査地区コード.getコード(),
                new Code(row.getChikuCode()));
        setDdlChosainShikaku();
        if (row.getChosainShikakuCode() != null && !row.getChosainShikakuCode().isNullOrEmpty()) {
            div.getChosainJohoInput().getDdlChosainShikaku().setSelectedKey(row.getChosainShikakuCode());
        } else {
            div.getChosainJohoInput().getDdlChosainShikaku().setSelectedKey(RString.EMPTY);
        }
        div.getChosainJohoInput().getTxtChosaKanoNinzu().setValue(row.getChosaKanoNinzu().getValue());
        div.getChosainJohoInput().getTxtYubinNo().setValue(new YubinNo(editYubinNo(row.getYubinNo())));
        div.getChosainJohoInput().getTxtJusho().setDomain(new AtenaJusho(row.getJusho()));
        div.getChosainJohoInput().getTxtTelNo().setDomain(new TelNo(row.getTelNo()));

        div.getChosainJohoInput().getTxtFaxNo().setDomain(new TelNo(row.getFaxNo()));
        div.getChosainJohoInput().getTextBoxShozokuKikan().setValue(
                (RString.isNullOrEmpty(row.getShozokuKikanName()) ? RString.EMPTY : row.getShozokuKikanName()));
        div.getChosainJohoInput().getRadChosainJokyo().setSelectedKey(
                表示値_有効.equals(row.getJokyoFlag()) ? CODE_有効 : CODE_無効);
        div.getChosainJohoInput().getRadSeibetsu().setSelectedKey(
                表示値_男.equals(row.getSeibetsu()) ? MAN : WOMAN);
    }

    /**
     * 調査員資格ドロップダウンリストを設定します。
     *
     */
    public void setDdlChosainShikaku() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (Sikaku sikaku : Sikaku.values()) {
            dataSource.add(new KeyValueDataSource(sikaku.getコード(), sikaku.get名称()));
        }
        div.getChosainJohoInput().getDdlChosainShikaku().setDataSource(dataSource);
    }

    private RString nullToEmpty(RString obj) {
        if (obj == null) {
            return RString.EMPTY;
        }
        return obj;
    }

    /**
     * 調査員情報を設定します。
     *
     * @param eventJotai 状態
     */
    public void setChosainJohoToIchiran(RString eventJotai) {
        dgChosainIchiran_Row row = new dgChosainIchiran_Row();
        if (!状態_追加.equals(eventJotai)) {
            row = div.getChosainIchiran().getDgChosainIchiran().getActiveRow();
        }

        row.setShichoson(nullToEmpty(div.getChosainJohoInput().getTxtShichosonmei().getValue()));
        row.setShichosonCode(nullToEmpty(div.getChosainJohoInput().getTxtShichoson().getValue()));
        row.setChosainCode(div.getChosainJohoInput().getTxtChosainCode());
        row.setChosainShimei(nullToEmpty(div.getChosainJohoInput().getTxtChosainShimei().getValue()));
        row.setChosainKanaShimei(nullToEmpty(div.getChosainJohoInput().getTxtChosainKanaShimei().getValue()));
        row.setChosaItakusakiCode(div.getChosainJohoInput().getTxtChosaItakusaki());
        row.setChosaItakusakiMeisho(nullToEmpty(div.getChosainJohoInput().getTxtChosaItakusakiMeisho().getValue()));
        RString seibetsu = div.getChosainJohoInput().getRadSeibetsu().getSelectedKey();
        if (MAN.equals(seibetsu)) {
            row.setSeibetsu(表示値_男);
        } else if (WOMAN.equals(seibetsu)) {
            row.setSeibetsu(表示値_女);
        }
        row.setChikuCode(nullToEmpty(div.getChosainJohoInput().getCcdChiku().getCode().value()));
        row.setChiku(nullToEmpty(div.getChosainJohoInput().getCcdChiku().getCodeMeisho()));
        row.setChosainShikakuCode(nullToEmpty(div.getChosainJohoInput().getDdlChosainShikaku().getSelectedKey()));
        row.setChosainShikaku(nullToEmpty(div.getChosainJohoInput().getDdlChosainShikaku().getSelectedValue()));
        row.setChosaKanoNinzu(div.getChosainJohoInput().getTxtChosaKanoNinzu());
        RString jokyoFlag = div.getChosainJohoInput().getRadChosainJokyo().getSelectedKey();
        row.setJokyoFlag(CODE_有効.equals(jokyoFlag) ? 表示値_有効 : 表示値_無効);
        row.setYubinNo(editYubinNoToIchiran(nullToEmpty(div.getChosainJohoInput().getTxtYubinNo().getValue().value())));
        row.setJusho(nullToEmpty(div.getChosainJohoInput().getTxtJusho().getDomain().value()));
        row.setTelNo(nullToEmpty(div.getChosainJohoInput().getTxtTelNo().getDomain().value()));
        row.setFaxNo(nullToEmpty(div.getChosainJohoInput().getTxtFaxNo().getDomain().value()));
        row.setShozokuKikanName(nullToEmpty(div.getChosainJohoInput().getTextBoxShozokuKikan().getValue()));
        int index = div.getChosainIchiran().getDgChosainIchiran().getClickedRowId();
        if (状態_追加.equals(eventJotai)) {
            row.setJotai(eventJotai);
            div.getChosainIchiran().getDgChosainIchiran().getDataSource().add(row);
        } else if (状態_削除.equals(eventJotai) && 状態_追加.equals(row.getJotai())) {
            div.getChosainIchiran().getDgChosainIchiran().getDataSource().remove(index);
        } else if (状態_修正.equals(eventJotai) && 状態_追加.equals(row.getJotai())) {
            div.getChosainIchiran().getDgChosainIchiran().getDataSource().set(index, row);
        } else {
            row.setJotai(eventJotai);
            div.getChosainIchiran().getDgChosainIchiran().getDataSource().set(index, row);
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

    private RString editYubinNo(RString yubinNo) {
        RStringBuilder yubinNoSb = new RStringBuilder();
        if (yubinNo.contains(ハイフン)) {
            yubinNoSb.append(yubinNo.substring(0, INDEX_3));
            yubinNoSb.append(yubinNo.substring(INDEX_4));
        } else {
            yubinNoSb.append(yubinNo);
        }
        return yubinNoSb.toRString();
    }

    /**
     * 調査員情報を設定します。
     *
     * @param chosainJoho 調査員情報
     * @return 調査員情報
     */
    public ChosainJoho editChosainJoho(ChosainJoho chosainJoho) {
        Decimal chosaKanoNinzu = div.getChosainJohoInput().getTxtChosaKanoNinzu().getValue();
        int 調査可能人数_月 = 0;
        if (chosaKanoNinzu != null) {
            調査可能人数_月 = chosaKanoNinzu.intValue();
        }
        RString chosainShikaku = div.getChosainJohoInput().getDdlChosainShikaku().getSelectedKey();
        if (chosainShikaku.isNullOrEmpty()) {
            chosainShikaku = null;
        }
        return chosainJoho.createBuilderForEdit().set調査員氏名(div.getChosainJohoInput().getTxtChosainShimei().getValue())
                .set調査員氏名カナ(div.getChosainJohoInput().getTxtChosainKanaShimei().getValue())
                .set性別(div.getChosainJohoInput().getRadSeibetsu().getSelectedKey())
                .set調査員資格(chosainShikaku)
                .set地区コード(div.getChosainJohoInput().getCcdChiku().getCode().value())
                .set調査可能人数_月(調査可能人数_月)
                .set郵便番号(div.getChosainJohoInput().getTxtYubinNo().getValue())
                .set住所(div.getChosainJohoInput().getTxtJusho().getDomain())
                .set電話番号(div.getChosainJohoInput().getTxtTelNo().getDomain())
                .setFAX番号(div.getChosainJohoInput().getTxtFaxNo().getDomain())
                .set所属機関名称(div.getChosainJohoInput().getTextBoxShozokuKikan().getValue())
                .set状況フラグ(CODE_有効.equals(div.getChosainJohoInput().getRadChosainJokyo().getSelectedKey())).build();
    }

    /**
     * 調査員情報登録エリアが非活性に設定します。
     */
    public void setDisabledTrueToChosainJohoToMeisai() {
        div.getChosainJohoInput().getTxtShichoson().setDisabled(true);
        div.getChosainJohoInput().getTxtChosaItakusaki().setDisabled(true);
        div.getChosainJohoInput().getTxtChosainCode().setDisabled(true);
        div.getChosainJohoInput().getTxtChosainShimei().setDisabled(true);
        div.getChosainJohoInput().getTxtChosainKanaShimei().setDisabled(true);
        div.getChosainJohoInput().getRadSeibetsu().setDisabled(true);
        div.getChosainJohoInput().getCcdChiku().setDisabled(true);
        div.getChosainJohoInput().getDdlChosainShikaku().setDisabled(true);
        div.getChosainJohoInput().getTxtChosaKanoNinzu().setDisabled(true);
        div.getChosainJohoInput().getTxtYubinNo().setDisabled(true);
        div.getChosainJohoInput().getTxtJusho().setDisabled(true);
        div.getChosainJohoInput().getTxtTelNo().setDisabled(true);
        div.getChosainJohoInput().getTxtFaxNo().setDisabled(true);
        div.getChosainJohoInput().getTextBoxShozokuKikan().setDisabled(true);
        div.getChosainJohoInput().getRadChosainJokyo().setDisabled(true);
        div.getChosainJohoInput().getBtnToSearchShichoson().setDisabled(true);
        div.getChosainJohoInput().getBtnToSearchChosaItakusaki().setDisabled(true);
    }

    /**
     * 調査員情報登録エリアが活性に設定します。
     */
    public void setDisabledFalseToChosainJohoToMeisai() {
        div.getChosainJohoInput().getTxtShichoson().setDisabled(false);
        div.getChosainJohoInput().getTxtChosaItakusaki().setDisabled(false);
        div.getChosainJohoInput().getTxtChosainCode().setDisabled(false);
        div.getChosainJohoInput().getTxtChosainShimei().setDisabled(false);
        div.getChosainJohoInput().getTxtChosainKanaShimei().setDisabled(false);
        div.getChosainJohoInput().getRadSeibetsu().setDisabled(false);
        div.getChosainJohoInput().getCcdChiku().setDisabled(false);
        div.getChosainJohoInput().getDdlChosainShikaku().setDisabled(false);
        div.getChosainJohoInput().getTxtChosaKanoNinzu().setDisabled(false);
        div.getChosainJohoInput().getTxtYubinNo().setDisabled(false);
        div.getChosainJohoInput().getTxtJusho().setDisabled(false);
        div.getChosainJohoInput().getTxtTelNo().setDisabled(false);
        div.getChosainJohoInput().getTxtFaxNo().setDisabled(false);
        div.getChosainJohoInput().getTextBoxShozokuKikan().setDisabled(false);
        div.getChosainJohoInput().getRadChosainJokyo().setDisabled(false);
        div.getChosainJohoInput().getBtnKakutei().setDisabled(false);
        div.getChosainJohoInput().getBtnTorikeshi().setDisabled(false);
        div.getChosainJohoInput().getBtnToSearchShichoson().setDisabled(false);
        div.getChosainJohoInput().getBtnToSearchChosaItakusaki().setDisabled(false);
    }

    /**
     * 調査員情報登録エリアをクリアします。
     */
    public void clearChosainJohoToMeisai() {
        div.getChosainJohoInput().getTxtShichoson().clearValue();
        div.getChosainJohoInput().getTxtShichosonmei().clearValue();
        div.getChosainJohoInput().getTxtChosaItakusaki().clearValue();
        div.getChosainJohoInput().getTxtChosaItakusakiMeisho().clearValue();
        div.getChosainJohoInput().getTxtChosainCode().clearValue();
        div.getChosainJohoInput().getTxtChosainShimei().clearValue();
        div.getChosainJohoInput().getTxtChosainKanaShimei().clearValue();
        div.getChosainJohoInput().getRadSeibetsu().setSelectedIndex(0);
        div.getChosainJohoInput().getCcdChiku().clearDisplayedValues();
        setDdlChosainShikaku();
        div.getChosainJohoInput().getDdlChosainShikaku().setSelectedIndex(0);
        div.getChosainJohoInput().getTxtChosaKanoNinzu().clearValue();
        div.getChosainJohoInput().getTxtYubinNo().clearValue();
        div.getChosainJohoInput().getTxtJusho().clearDomain();
        div.getChosainJohoInput().getTxtTelNo().clearDomain();
        div.getChosainJohoInput().getTxtFaxNo().clearDomain();
        div.getChosainJohoInput().getTextBoxShozokuKikan().clearValue();
        div.getChosainJohoInput().getRadChosainJokyo().setSelectedIndex(0);
        div.getChosainJohoInput().getCcdChiku().applyNoOptionCodeMaster().load(SubGyomuCode.DBE認定支援, DBECodeShubetsu.調査地区コード.getコード());
    }

    /**
     * 調査員情報登録エリアを編集します。
     *
     * @return 編集結果
     */
    public RString getInputDiv() {
        RStringBuilder inputDiv = new RStringBuilder();
        ChosainJohoInputDiv chosainJohoInputDiv = div.getChosainJohoInput();
        inputDiv.append(chosainJohoInputDiv.getTxtShichoson().getValue());
        inputDiv.append(chosainJohoInputDiv.getTxtShichosonmei().getValue());
        inputDiv.append(chosainJohoInputDiv.getTxtChosainCode().getValue());
        inputDiv.append(chosainJohoInputDiv.getTxtChosaItakusaki().getValue());
        inputDiv.append(chosainJohoInputDiv.getTxtChosaItakusakiMeisho().getValue());
        inputDiv.append(chosainJohoInputDiv.getTxtChosainShimei().getValue());
        inputDiv.append(chosainJohoInputDiv.getTxtChosainKanaShimei().getValue());
        inputDiv.append(chosainJohoInputDiv.getRadSeibetsu().getSelectedKey());
        inputDiv.append(div.getChosainJohoInput().getCcdChiku().getCode().value());
        inputDiv.append(chosainJohoInputDiv.getDdlChosainShikaku().getSelectedKey());
        Decimal chosaKanoNinzu = chosainJohoInputDiv.getTxtChosaKanoNinzu().getValue();
        inputDiv.append(chosaKanoNinzu == null ? RString.EMPTY : chosaKanoNinzu);
        inputDiv.append(chosainJohoInputDiv.getTxtYubinNo().getValue().value());
        inputDiv.append(chosainJohoInputDiv.getTxtJusho().getDomain().value());
        inputDiv.append(chosainJohoInputDiv.getTxtTelNo().getDomain().value());
        inputDiv.append(chosainJohoInputDiv.getTxtFaxNo().getDomain().value());
        inputDiv.append(chosainJohoInputDiv.getTextBoxShozokuKikan().getValue());
        inputDiv.append((chosainJohoInputDiv.getRadChosainJokyo().getSelectedKey()));
        return inputDiv.toRString();
    }
}
