package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE9040001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosainmaster.NinteiChosainMaster;
import jp.co.ndensan.reams.db.dbe.business.core.tyousai.chosainjoho.ChosainJoho;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.Sikaku;
import static jp.co.ndensan.reams.db.dbe.divcontroller.controller.DBE9040001.NinteiChosainMaster.追加;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9040001.NinteiChosainMasterDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9040001.dgChosainIchiran_Row;
import static jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5120001.NinteiShinsakaiKaisaibashoTorokuHandler.削除;
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
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 * 認定調査員マスタ画面のハンドラークラスです。
 */
public class NinteiChosainMasterHandler {

    private final static CodeShubetsu CHIKU_CODE_SHUBETSU = new CodeShubetsu("5002");
    private final static RString 有効 = new RString("有効");
    private final static RString 無効 = new RString("無効");
    public final static RString CODE_有効 = new RString("1");
    public final static RString CODE_無効 = new RString("2");
    private final static RString 男 = new RString("男");
    private final static RString 女 = new RString("女");
    public final static RString MAN = new RString("1");
    public final static RString WOMAN = new RString("2");
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
//        IUrControlData controlData = UrControlDataFactory.createInstance();
//        IAssociationFinder associationFinder = AssociationFinderFactory.createInstance();
//        Association association = associationFinder.getAssociation();
//        ICityAtesakiFinder cityAtesakiFinder = CityAtesakiService.createCityAtesakiFinder();
//        ShichosonAtesaki shichosonAtesaki = cityAtesakiFinder.get市町村宛先(association.get地方公共団体コード());

        List<KeyValueDataSource> shichosonDataSource = new ArrayList<>();
        shichosonDataSource.add(new KeyValueDataSource(new RString("000001"), new RString("市町村一")));
        shichosonDataSource.add(new KeyValueDataSource(new RString("000002"), new RString("市町村二")));
        shichosonDataSource.add(new KeyValueDataSource(new RString("000003"), new RString("市町村三")));
        div.getDdlSearchShichoson().setDataSource(shichosonDataSource);
        List<UzT0007CodeEntity> codeList = CodeMaster.getCodeRireki(SubGyomuCode.DBE認定支援, CHIKU_CODE_SHUBETSU);
        List<KeyValueDataSource> chikuDataSource = new ArrayList<>();
        for (UzT0007CodeEntity codeEntity : codeList) {
            chikuDataSource.add(new KeyValueDataSource(codeEntity.getコード().getKey(), codeEntity.getコード名称()));
        }
//        List<ChosaChikuCode> codeList = CodeMasterNoOptionHelper.getCode(DBECodeShubetsu.調査地区コード);
//        List<KeyValueDataSource> dataSource = new ArrayList<>();
//        for (ChosaChikuCode code : codeList) {
//            dataSource.add(new KeyValueDataSource(code.getColumnValue(), code.getMeisho()));
//        }
        div.getDdlChikuCode().setDataSource(chikuDataSource);
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
            row.setSeibetsu(男);
        } else if (WOMAN.equals(seibetsu)) {
            row.setSeibetsu(女);
        }
        row.setChikuCode(nullToEmpty(chiku));
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
        div.getChosainJohoInput().getTxtChiku().setValue(nullToEmpty(row.getChikuCode()));
        div.getChosainJohoInput().getTxtChikuMei().setValue(nullToEmpty(row.getChiku()));
        setDdlChosainShikaku();
        if (!row.getChosainShikakuCode().isEmpty()) {
            div.getChosainJohoInput().getDdlChosainShikaku().setSelectedKey(row.getChosainShikakuCode());
        }
        div.getChosainJohoInput().getTxtChosaKanoNinzu().setValue(row.getChosaKanoNinzu().getValue());
        div.getChosainJohoInput().getTxtYubinNo().setValue(new YubinNo(row.getYubinNo()));
        div.getChosainJohoInput().getTxtJusho().setDomain(new AtenaJusho(row.getJusho()));
        div.getChosainJohoInput().getTxtTelNo().setDomain(new TelNo(row.getTelNo()));

        div.getChosainJohoInput().getTxtFaxNo().setDomain(new TelNo(row.getFaxNo()));
        div.getChosainJohoInput().getTextBoxShozokuKikan().setDomain(
                new AtenaJusho(RString.isNullOrEmpty(row.getShozokuKikanName()) ? RString.EMPTY : row.getShozokuKikanName()));
        div.getChosainJohoInput().getRadChosainJokyo().setSelectedKey(
                有効.equals(row.getJokyoFlag()) ? CODE_有効 : CODE_無効);
        div.getChosainJohoInput().getRadSeibetsu().setSelectedKey(
                男.equals(row.getSeibetsu()) ? MAN : WOMAN);
    }

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
        if (!追加.equals(eventJotai)) {
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
            row.setSeibetsu(男);
        } else if (WOMAN.equals(seibetsu)) {
            row.setSeibetsu(女);
        }
        row.setChikuCode(nullToEmpty(div.getChosainJohoInput().getTxtChiku().getValue()));
        row.setChiku(nullToEmpty(div.getChosainJohoInput().getTxtChikuMei().getValue()));
        row.setChosainShikakuCode(nullToEmpty(div.getChosainJohoInput().getDdlChosainShikaku().getSelectedKey()));
        row.setChosainShikaku(nullToEmpty(div.getChosainJohoInput().getDdlChosainShikaku().getSelectedValue()));
        row.setChosaKanoNinzu(div.getChosainJohoInput().getTxtChosaKanoNinzu());
        RString jokyoFlag = div.getChosainJohoInput().getRadChosainJokyo().getSelectedKey();
        row.setJokyoFlag(CODE_有効.equals(jokyoFlag) ? 有効 : 無効);
        row.setYubinNo(nullToEmpty(div.getChosainJohoInput().getTxtYubinNo().getValue().value()));
        row.setJusho(nullToEmpty(div.getChosainJohoInput().getTxtJusho().getDomain().value()));
        row.setTelNo(nullToEmpty(div.getChosainJohoInput().getTxtTelNo().getDomain().value()));
        row.setFaxNo(nullToEmpty(div.getChosainJohoInput().getTxtFaxNo().getDomain().value()));
        row.setShozokuKikanName(nullToEmpty(div.getChosainJohoInput().getTextBoxShozokuKikan().getDomain().value()));
        int index = div.getChosainIchiran().getDgChosainIchiran().getClickedRowId();
        if (追加.equals(eventJotai)) {
            row.setJotai(eventJotai);
            div.getChosainIchiran().getDgChosainIchiran().getDataSource().add(row);
        } else if (削除.equals(eventJotai) && 追加.equals(row.getJotai())) {
            div.getChosainIchiran().getDgChosainIchiran().getDataSource().remove(index);
        } else {
            row.setJotai(eventJotai);
            div.getChosainIchiran().getDgChosainIchiran().getDataSource().set(index, row);
        }
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
        return chosainJoho.createBuilderForEdit().set調査員氏名(div.getChosainJohoInput().getTxtChosainShimei().getValue())
                .set調査員氏名カナ(div.getChosainJohoInput().getTxtChosainKanaShimei().getValue())
                .set性別(div.getChosainJohoInput().getRadSeibetsu().getSelectedKey())
                .set調査員資格(div.getChosainJohoInput().getDdlChosainShikaku().getSelectedKey())
                .set地区コード(div.getChosainJohoInput().getTxtChiku().getValue())
                .set調査可能人数_月(調査可能人数_月)
                .set郵便番号(div.getChosainJohoInput().getTxtYubinNo().getValue())
                .set住所(div.getChosainJohoInput().getTxtJusho().getDomain())
                .set電話番号(div.getChosainJohoInput().getTxtTelNo().getDomain())
                .setFAX番号(div.getChosainJohoInput().getTxtFaxNo().getDomain())
                .set所属機関名称(div.getChosainJohoInput().getTextBoxShozokuKikan().getDomain().value())
                .set状況フラグ(CODE_有効.equals(div.getChosainJohoInput().getRadChosainJokyo().getSelectedKey())).build();
    }

    /**
     * 市町村名を設定します。
     */
    public void setTxtShichosonmei() {
        // TODO QA253
//        UzT0007CodeEntity code = CodeMaster.getCode(
//                SubGyomuCode.DBE認定支援, CHIKU_CODE_SHUBETSU, new Code(div.getChosainJohoInput().getTxtShichoson().getValue()));
//        if (code != null) {
//            div.getChosainJohoInput().getTxtShichosonmei().setValue(code.getコード名称());
//        }
        RString shichoson = div.getChosainJohoInput().getTxtShichoson().getValue();
        if (new RString("000001").equals(shichoson)) {
            div.getChosainJohoInput().getTxtShichosonmei().setValue(new RString("市町村一"));
        } else if (new RString("000002").equals(shichoson)) {
            div.getChosainJohoInput().getTxtShichosonmei().setValue(new RString("市町村二"));
        } else if (new RString("000003").equals(shichoson)) {
            div.getChosainJohoInput().getTxtShichosonmei().setValue(new RString("市町村三"));
        } else if (new RString("000004").equals(shichoson)) {
            div.getChosainJohoInput().getTxtShichosonmei().setValue(new RString("市町村四"));
        }
    }

    /**
     * 地区名を設定します。
     */
    public void setTxtChikuMei() {
        UzT0007CodeEntity code = CodeMaster.getCode(
                SubGyomuCode.DBE認定支援, CHIKU_CODE_SHUBETSU, new Code(div.getChosainJohoInput().getTxtChiku().getValue()));
        if (code != null) {
            div.getChosainJohoInput().getTxtChikuMei().setValue(code.getコード名称());
        }
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
        div.getChosainJohoInput().getTxtChiku().setDisabled(false);
        div.getChosainJohoInput().getDdlChosainShikaku().setDisabled(false);
        div.getChosainJohoInput().getTxtChosaKanoNinzu().setDisabled(false);
        div.getChosainJohoInput().getTxtYubinNo().setDisabled(false);
        div.getChosainJohoInput().getTxtJusho().setDisabled(false);
        div.getChosainJohoInput().getTxtTelNo().setDisabled(false);
        div.getChosainJohoInput().getTxtFaxNo().setDisabled(false);
        div.getChosainJohoInput().getTextBoxShozokuKikan().setDisabled(false);
        div.getChosainJohoInput().getRadChosainJokyo().setDisabled(false);
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
        div.getChosainJohoInput().getTxtChiku().clearValue();
        div.getChosainJohoInput().getTxtChikuMei().clearValue();
        setDdlChosainShikaku();
        div.getChosainJohoInput().getDdlChosainShikaku().setSelectedIndex(0);
        div.getChosainJohoInput().getTxtChosaKanoNinzu().clearValue();
        div.getChosainJohoInput().getTxtYubinNo().clearValue();
        div.getChosainJohoInput().getTxtJusho().clearDomain();
        div.getChosainJohoInput().getTxtTelNo().clearDomain();
        div.getChosainJohoInput().getTxtFaxNo().clearDomain();
        div.getChosainJohoInput().getTextBoxShozokuKikan().clearDomain();
        div.getChosainJohoInput().getRadChosainJokyo().setSelectedIndex(0);
    }
}
