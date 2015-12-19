package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE9040001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosainmaster.NinteiChosainMaster;
import jp.co.ndensan.reams.db.dbe.business.core.tyousai.chosainjoho.ChosainJoho;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.Sikaku;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9040001.NinteiChosainMasterDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9040001.dgChosainIchiran_Row;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxKana;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxYubinNo;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxJusho;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxTelNo;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 * 認定調査員マスタ画面のハンドラークラスです。
 */
public class NinteiChosainMasterHandler {

    private final static CodeShubetsu CHIKU_CODE_SHUBETSU = new CodeShubetsu("5002");
    private final static RString 有効 = new RString("有効");
    private final static RString 無効 = new RString("無効");
    private final static RString CODE_有効 = new RString("1");
    private final static RString CODE_無効 = new RString("2");
    private final static RString 男 = new RString("男");
    private final static RString 女 = new RString("女");
    private final static RString MAN = new RString("1");
    private final static RString WOMAN = new RString("2");
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
        // TODO 市町村　ドロップダウンリスト
        List<UzT0007CodeEntity> codeList = CodeMaster.getCodeRireki(SubGyomuCode.DBE認定支援, CHIKU_CODE_SHUBETSU);
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (UzT0007CodeEntity codeEntity : codeList) {
            dataSource.add(new KeyValueDataSource(codeEntity.getコード().getKey(), codeEntity.getコード名称()));
        }
//        List<ChosaChikuCode> codeList = CodeMasterNoOptionHelper.getCode(DBECodeShubetsu.調査地区コード);
//        List<KeyValueDataSource> dataSource = new ArrayList<>();
//        for (ChosaChikuCode code : codeList) {
//            dataSource.add(new KeyValueDataSource(code.getColumnValue(), code.getMeisho()));
//        }
        div.getDdlChikuCode().setDataSource(dataSource);
    }

    /**
     * 検索条件入力項目をクリアします。
     */
    public void clearKensakuJoken() {
        div.getDdlSearchShichoson().setSelectedIndex(0);
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
        // TODO
        row.setShichoson(new RString("市町村名"));
        row.setShichosonCode(shichoson.value());
        TextBoxCode chosainCode = new TextBoxCode();
        chosainCode.setValue(ninteiChosainNo);
        row.setChosainCode(chosainCode);
        row.setChosainShimei(chosainShimei);
        row.setChosainKanaShimei(chosainKanaShimei);
        TextBoxCode chosaItakusakiCode = new TextBoxCode();
        chosaItakusakiCode.setValue(ninteichosaItakusakiCode);
        row.setChosaItakusakiCode(chosaItakusakiCode);
        row.setChosaItakusakiMeisho(chosaItakusakiMeisho);
        if (MAN.equals(seibetsu)) {
            row.setSeibetsu(男);
        } else if (WOMAN.equals(seibetsu)) {
            row.setSeibetsu(女);
        }
        row.setChikuCode(chiku);
        // TODO
        List<UzT0007CodeEntity> codeList = CodeMaster.getCodeRireki(SubGyomuCode.DBE認定支援, CHIKU_CODE_SHUBETSU, new Code(chiku));
        if (codeList != null && 0 < codeList.size()) {
            row.setChiku(codeList.get(0).getコード名称());
        }
        row.setChosainShikaku(Sikaku.toValue(chosainShikaku).get名称());
        TextBoxNum chosaKanoNinzu = new TextBoxNum();
        chosaKanoNinzu.setValue(new Decimal(chosaKanoNinzuPerMonth));
        row.setChosaKanoNinzu(chosaKanoNinzu);
        row.setJokyoFlag(jokyoFlag ? 有効 : 無効);
        row.setYubinNo(yubinNo != null ? yubinNo.value() : RString.EMPTY);
        row.setJusho(jusho != null ? jusho.value() : RString.EMPTY);
        row.setTelNo(telNo != null ? telNo.value() : RString.EMPTY);
        row.setFaxNo(faxNo != null ? faxNo.value() : RString.EMPTY);
        row.setShozokuKikanName(shozokuKikanName);
        return row;
    }

    public void setChosainJohoToMeisai(dgChosainIchiran_Row row) {
        TextBoxCode shichosonCode = new TextBoxCode();
        shichosonCode.setValue(nullToEmpty(row.getShichosonCode()));
        div.getChosainJohoInput().setTxtShichoson(shichosonCode);
        TextBox shichoson = new TextBox();
        shichoson.setValue(nullToEmpty(row.getShichoson()));
        div.getChosainJohoInput().setTxtShichosonmei(shichoson);
        div.getChosainJohoInput().setTxtChosaItakusaki(row.getChosaItakusakiCode());
        TextBox txtChosaItakusakiMeisho = new TextBox();
        txtChosaItakusakiMeisho.setValue(nullToEmpty(row.getChosaItakusakiMeisho()));
        div.getChosainJohoInput().setTxtChosaItakusakiMeisho(txtChosaItakusakiMeisho);
        div.getChosainJohoInput().setTxtChosainCode(row.getChosainCode());
        TextBox txtChosainShimei = new TextBox();
        txtChosainShimei.setValue(nullToEmpty(row.getChosainShimei()));
        div.getChosainJohoInput().setTxtChosainShimei(txtChosainShimei);
        TextBoxKana txtChosainKanaShimei = new TextBoxKana();
        txtChosainKanaShimei.setValue(nullToEmpty(row.getChosainKanaShimei()));
        div.getChosainJohoInput().setTxtChosainKanaShimei(txtChosainKanaShimei);
        TextBoxCode txtChiku = new TextBoxCode();
        txtChiku.setValue(row.getChikuCode());
        div.getChosainJohoInput().setTxtChiku(txtChiku);
        TextBox txtChikuMei = new TextBox();
        txtChikuMei.setValue(nullToEmpty(row.getChiku()));
        div.getChosainJohoInput().setTxtChikuMei(txtChosainShimei);
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (Sikaku sikaku : Sikaku.values()) {
            dataSource.add(new KeyValueDataSource(sikaku.getコード(), sikaku.get名称()));
        }
        div.getChosainJohoInput().getDdlChosainShikaku().setDataSource(dataSource);
        if (!row.getChosainShikakuCode().isEmpty()) {
            div.getChosainJohoInput().getDdlChosainShikaku().setSelectedKey(row.getChosainShikakuCode());
        }
        div.getChosainJohoInput().setTxtChosaKanoNinzu(row.getChosaKanoNinzu());
        TextBoxYubinNo txtYubinNo = new TextBoxYubinNo();
        txtYubinNo.setValue(new YubinNo(row.getYubinNo()));
        div.getChosainJohoInput().setTxtYubinNo(txtYubinNo);
        TextBoxJusho txtJusho = new TextBoxJusho();
        txtJusho.setDomain(new AtenaJusho(row.getJusho()));
        div.getChosainJohoInput().setTxtJusho(txtJusho);
        TextBoxTelNo txtTelNo = new TextBoxTelNo();
        txtTelNo.setDomain(new TelNo(row.getTelNo()));
        div.getChosainJohoInput().setTxtTelNo(txtTelNo);

        TextBoxTelNo txtFaxNo = new TextBoxTelNo();
        txtFaxNo.setDomain(new TelNo(row.getFaxNo()));
        div.getChosainJohoInput().setTxtFaxNo(txtFaxNo);
        TextBoxJusho textBoxShozokuKikan = new TextBoxJusho();
        textBoxShozokuKikan.setDomain(
                new AtenaJusho(RString.isNullOrEmpty(row.getShozokuKikanName()) ? RString.EMPTY : row.getShozokuKikanName()));
        div.getChosainJohoInput().setTextBoxShozokuKikan(textBoxShozokuKikan);
        div.getChosainJohoInput().getRadChosainJokyo().setSelectedKey(
                有効.equals(row.getJokyoFlag()) ? CODE_有効 : CODE_無効);
        div.getChosainJohoInput().getRadSeibetsu().setSelectedKey(
                男.equals(row.getSeibetsu()) ? MAN : WOMAN);
    }

    private RString nullToEmpty(RString obj) {
        if (obj == null) {
            return RString.EMPTY;
        }
        return obj;
    }

    public dgChosainIchiran_Row setChosainJohoToIchiran(RString jotai) {
        dgChosainIchiran_Row row = new dgChosainIchiran_Row();
        row.setJotai(jotai);
        row.setShichoson(div.getChosainJohoInput().getTxtShichosonmei().getValue());
        row.setShichosonCode(div.getChosainJohoInput().getTxtShichoson().getValue());
        row.setChosainCode(div.getChosainJohoInput().getTxtChosainCode());
        row.setChosainShimei(div.getChosainJohoInput().getTxtChosainShimei().getValue());
        row.setChosainKanaShimei(div.getChosainJohoInput().getTxtChosainKanaShimei().getValue());
        row.setChosaItakusakiCode(div.getChosainJohoInput().getTxtChosaItakusaki());
        row.setChosaItakusakiMeisho(div.getChosainJohoInput().getTxtChosaItakusakiMeisho().getValue());
        RString seibetsu = div.getChosainJohoInput().getRadSeibetsu().getSelectedKey();
        if (MAN.equals(seibetsu)) {
            row.setSeibetsu(男);
        } else if (WOMAN.equals(seibetsu)) {
            row.setSeibetsu(女);
        }
        row.setChikuCode(div.getChosainJohoInput().getTxtChiku().getValue());
        row.setChiku(div.getChosainJohoInput().getTxtChikuMei().getValue());
        row.setChosainShikakuCode(div.getChosainJohoInput().getDdlChosainShikaku().getSelectedKey());
        row.setChosainShikaku(div.getChosainJohoInput().getDdlChosainShikaku().getSelectedValue());
        row.setChosaKanoNinzu(div.getChosainJohoInput().getTxtChosaKanoNinzu());
        RString jokyoFlag = div.getChosainJohoInput().getRadChosainJokyo().getSelectedKey();
        row.setJokyoFlag(CODE_有効.equals(jokyoFlag) ? 有効 : 無効);
        row.setYubinNo(div.getChosainJohoInput().getTxtYubinNo().getValue().value());
        row.setJusho(div.getChosainJohoInput().getTxtJusho().getDomain().value());
        row.setTelNo(div.getChosainJohoInput().getTxtTelNo().getDomain().value());
        row.setFaxNo(div.getChosainJohoInput().getTxtFaxNo().getDomain().value());
        row.setShozokuKikanName(div.getChosainJohoInput().getTextBoxShozokuKikan().getDomain().value());
        return row;
    }

    public ChosainJoho editChosainJoho(ChosainJoho chosainJoho) {
        return chosainJoho.createBuilderForEdit().set調査員氏名(div.getChosainJohoInput().getTxtChosainShimei().getValue())
                .set調査員氏名カナ(div.getChosainJohoInput().getTxtChosainKanaShimei().getValue())
                .set性別(div.getChosainJohoInput().getRadSeibetsu().getSelectedKey())
                .set調査員資格(div.getChosainJohoInput().getDdlChosainShikaku().getSelectedKey())
                .set地区コード(div.getChosainJohoInput().getTxtChiku().getValue())
                .set調査可能人数_月(div.getChosainJohoInput().getTxtChosaKanoNinzu().getValue().intValue())
                .set郵便番号(div.getChosainJohoInput().getTxtYubinNo().getValue())
                .set住所(div.getChosainJohoInput().getTxtJusho().getDomain())
                .set電話番号(div.getChosainJohoInput().getTxtTelNo().getDomain())
                .setFAX番号(div.getChosainJohoInput().getTxtFaxNo().getDomain())
                .set所属機関名称(div.getChosainJohoInput().getTextBoxShozokuKikan().getDomain().value())
                .set状況フラグ(CODE_有効.equals(div.getChosainJohoInput().getRadChosainJokyo().getSelectedKey())).build();
    }

    public void setDisabledChosainJohoToMeisai() {
        div.getChosainJohoInput().getTxtShichoson().setDisabled(true);
        div.getChosainJohoInput().getTxtChosaItakusaki().setDisabled(true);
        div.getChosainJohoInput().getTxtChosainCode().setDisabled(true);
        div.getChosainJohoInput().getTxtChosainShimei().setDisabled(true);
        div.getChosainJohoInput().getTxtChosainKanaShimei().setDisabled(true);
        div.getChosainJohoInput().getTxtChiku().setDisabled(true);
        div.getChosainJohoInput().getDdlChosainShikaku().setDisabled(true);
        div.getChosainJohoInput().getTxtChosaKanoNinzu().setDisabled(true);
        div.getChosainJohoInput().getTxtYubinNo().setDisabled(true);
        div.getChosainJohoInput().getTxtJusho().setDisabled(true);
        div.getChosainJohoInput().getTxtTelNo().setDisabled(true);
        div.getChosainJohoInput().getTxtFaxNo().setDisabled(true);
        div.getChosainJohoInput().getTextBoxShozokuKikan().setDisabled(true);
        div.getChosainJohoInput().getRadChosainJokyo().setDisabled(true);
    }
}
