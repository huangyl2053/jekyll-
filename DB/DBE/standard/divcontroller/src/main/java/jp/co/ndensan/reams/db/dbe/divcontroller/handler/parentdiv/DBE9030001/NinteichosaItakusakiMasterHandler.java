/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE9030001;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.tyousai.koseishichosonmaster.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbe.business.core.tyousai.ninteichosaitakusakijoho.NinteichosaItakusakiJoho;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Chosa.ChosaItakuKubunCode;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Chosa.ChosaKikanKubun;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.ninteichosaitakusaki.NinteichosaItakusakiKensakuParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9030001.NinteichosaItakusakiJohoCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9030001.NinteichosaItakusakiMasterDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9030001.dgChosainIchiran_Row;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.tyousai.ninteichosaitakusakijoho.NinteichosaItakusakiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.service.core.tyousai.chosainjoho.ChosainJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.tyousai.koseishichosonmaster.KoseiShichosonMasterManager;
import jp.co.ndensan.reams.db.dbe.service.core.tyousai.ninteichosaitakusakijoho.NinteichosaItakusakiJohoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5910NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 認定調査委託先マスタ画面でのバリデーションを管理するハンドラークラスです。
 *
 */
public class NinteichosaItakusakiMasterHandler {

    private final NinteichosaItakusakiMasterDiv div;
    private static final int DROPDOWNLIST_BLANK = 0;
    private final KoseiShichosonMasterManager masterManager;
    private final NinteichosaItakusakiJohoManager johoManager;
    private final ChosainJohoManager chosainJohoManager;
    private static final RString 状況フラグ有効 = new RString("有効");
    private static final RString 状況フラグ無効 = new RString("無効");
    private static final RString 自動割付フラグ有効 = new RString("有効");
    private static final RString 自動割付フラグ無効 = new RString("無効");
    private static final RString 特定調査員表示フラグ表示 = new RString("表示");
    private static final RString 特定調査員表示フラグ非表示 = new RString("非表示");
    private static final CodeShubetsu 割付地区名称コード種別 = new CodeShubetsu("5002");
    private static final RString 追加状態 = new RString("追加");
    private static final RString 修正状態 = new RString("修正");
    private static final RString 削除状態 = new RString("削除");
    private static final RString CSV_WRITER_DELIMITER = new RString(",");
    private static final RString CSVファイル名 = new RString("認定調査委託先情報.csv");
    private final int 追加状態コード = 1;
    private final int 修正状態コード = 2;
    private final int 削除状態コード = 3;
    private final int その他状態コード = 0;

    /**
     * コンストラクタです。
     *
     * @param div 認定調査委託先マスタDiv
     */
    public NinteichosaItakusakiMasterHandler(NinteichosaItakusakiMasterDiv div) {
        this.div = div;
        johoManager = NinteichosaItakusakiJohoManager.createInstance();
        masterManager = KoseiShichosonMasterManager.createInstance();
        chosainJohoManager = ChosainJohoManager.createInstance();
    }

    /**
     * 画面初期化表示、画面項目に設定されている値をクリアする。
     *
     */
    public void onLoad() {

        div.getChosainSearch().getDdlSearchShichoson().getDataSource().clear();
        //TODO 市町村DDLですが保険者DDLに変更します QA71783
        div.getChosainSearch().getRadSearchChosainJokyo().setSelectedKey(new RString("key0"));
        List<KeyValueDataSource> chosaItakuKubunCodes = createListFromChosaItakuKubunCodeASC();
        div.getChosainSearch().getDdlitakukubun().getDataSource().clear();
        div.getChosainSearch().getDdlitakukubun().getDataSource().addAll(chosaItakuKubunCodes);
        List<KeyValueDataSource> chosaKikanKubunCodes = createListFromChosaKikanKubunASC();
        div.getChosainSearch().getDdlkikankubun().getDataSource().clear();
        div.getChosainSearch().getDdlkikankubun().getDataSource().addAll(chosaKikanKubunCodes);
        div.getChosaitakusakiJohoInput().getDdlItakusakikubun().getDataSource().addAll(chosaItakuKubunCodes);
        div.getChosaitakusakiJohoInput().getDdlKikankubun().getDataSource().addAll(chosaKikanKubunCodes);
        div.getChosaitakusakiJohoInput().getDdltokuteichosain().getDataSource().add(
                new KeyValueDataSource(new RString("TRUE"), 特定調査員表示フラグ表示));
        div.getChosaitakusakiJohoInput().getDdltokuteichosain().getDataSource().add(
                new KeyValueDataSource(new RString("FALSE"), 特定調査員表示フラグ非表示));
    }

    /**
     * 検索条件入力項目をクリアする。
     *
     */
    public void clearKensakuJoken() {
        //TODO 市町村DDLですが保険者DDLに変更します QA71783
        div.getChosainSearch().getRadSearchChosainJokyo().setSelectedIndex(DROPDOWNLIST_BLANK);
        div.getChosainSearch().getTxtSearchChosaItakusakiCodeFrom().clearValue();
        div.getChosainSearch().getTxtSearchChosaItakusakiCodeTo().clearValue();
        div.getChosainSearch().getTxtSearchChosaItakusakiMeisho().clearValue();
        div.getChosainSearch().getTxtSearchChosaItakusakiKanaMeisho().clearValue();
        div.getChosainSearch().getDdlitakukubun().setSelectedIndex(DROPDOWNLIST_BLANK);
        div.getChosainSearch().getDdlkikankubun().setSelectedIndex(DROPDOWNLIST_BLANK);

    }

    /**
     * 追加ボタンが押下された場合、明細エリアを空白で表示する
     *
     * @return
     */
    public List<KoseiShichosonMaster> searchShujii() {
        NinteichosaItakusakiKensakuParameter 構成市町村マスタ検索条件 = NinteichosaItakusakiKensakuParameter.createParam(
                状況フラグ有効.equals(div.getChosainSearch().getRadSearchChosainJokyo().getSelectedKey()),
                div.getChosainSearch().getDdlSearchShichoson().getSelectedKey().isEmpty()
                ? null : new LasdecCode(div.getChosainSearch().getDdlSearchShichoson().getSelectedKey()),
                div.getChosainSearch().getTxtSearchChosaItakusakiCodeFrom().getValue().isEmpty()
                ? null : div.getChosainSearch().getTxtSearchChosaItakusakiCodeFrom().getValue(),
                div.getChosainSearch().getTxtSearchChosaItakusakiCodeTo().getValue().isEmpty()
                ? null : div.getChosainSearch().getTxtSearchChosaItakusakiCodeTo().getValue(),
                div.getChosainSearch().getDdlitakukubun().getSelectedKey().isEmpty()
                ? null : div.getChosainSearch().getDdlitakukubun().getSelectedKey(),
                div.getChosainSearch().getTxtSearchChosaItakusakiMeisho().getValue().isEmpty()
                ? null : div.getChosainSearch().getTxtSearchChosaItakusakiMeisho().getValue(),
                div.getChosainSearch().getTxtSearchChosaItakusakiKanaMeisho().getValue().isEmpty()
                ? null : div.getChosainSearch().getTxtSearchChosaItakusakiKanaMeisho().getValue(),
                div.getChosainSearch().getDdlkikankubun().getSelectedKey().isEmpty()
                ? null : div.getChosainSearch().getDdlkikankubun().getSelectedKey(),
                div.getChosainSearch().getTxtSaidaiHyojiKensu().getValue() == null
                ? null : div.getChosainSearch().getTxtSaidaiHyojiKensu().getValue().intValue());
        return masterManager.ninteichosaItakusakiSearch(構成市町村マスタ検索条件);
    }

    /**
     * 検索条件に従い、調査委託先情報を検索する。
     *
     * @param list
     */
    public void setDataSource(List<KoseiShichosonMaster> list) {
        div.getChosaitakusakichiran().getDgChosainIchiran().setDataSource(converterDataSourceFromKoseiShichosonMaster(list));
    }

    /**
     * 追加ボタンが押下された場合、明細エリアを空白で表示する
     *
     */
    public void set追加状態() {
        div.set状態(追加状態コード);
        div.getChosaitakusakiJohoInput().clear();
        setChosaitakusakiJohoInputDisabled(Boolean.FALSE);
        div.getChosaitakusakiJohoInput().getBtnKakutei().setDisabled(Boolean.FALSE);
        div.setHdnInputDiv(div.getChosaitakusakiJohoInput());
    }

    /**
     * 修正アイコンを押下した場合、明細エリアに選択行の内容を表示し、項目を入力可能にする
     *
     */
    public void set修正状態() {
        div.set状態(修正状態コード);
        setChosaitakusakiJohoInputDisabled(Boolean.FALSE);
        div.getChosaitakusakiJohoInput().getTxtShichoson().setDisabled(Boolean.TRUE);
        div.getChosaitakusakiJohoInput().getBtnToSearchShichoson().setDisabled(Boolean.TRUE);
        div.getChosaitakusakiJohoInput().getTxtShichosonmei().setDisabled(Boolean.TRUE);
        div.getChosaitakusakiJohoInput().getTxtChosaItakusaki().setDisabled(Boolean.TRUE);
        setChosaitakusakiJohoInput(div.getChosaitakusakichiran().getDgChosainIchiran().getClickedItem());
        div.getChosaitakusakiJohoInput().getBtnKakutei().setDisabled(Boolean.FALSE);
        div.setHdnInputDiv(div.getChosaitakusakiJohoInput());
    }

    /**
     * 削除アイコンを押下した場合、明細エリアに選択行の内容を表示し、項目を入力不可にする
     *
     */
    public void set削除状態() {
        div.set状態(削除状態コード);
        setChosaitakusakiJohoInputDisabled(Boolean.TRUE);
        setChosaitakusakiJohoInput(div.getChosaitakusakichiran().getDgChosainIchiran().getClickedItem());
        div.getChosaitakusakiJohoInput().getBtnKakutei().setDisabled(Boolean.FALSE);
    }

    /**
     * 選択行の内容を、明細エリアに表示
     *
     */
    public void onSelectByDlbClick_dgChosainIchiran() {
        dgChosainIchiran_Row row = div.getChosaitakusakichiran().getDgChosainIchiran().getClickedItem();
        if (追加状態.equals(row.getJotai())) {
            set追加状態();
        } else if (修正状態.equals(row.getJotai())) {
            set修正状態();
        } else if (削除状態.equals(row.getJotai())) {
            set削除状態();
        } else {
            set明細照会状態();
        }
    }

    /**
     * ＣＳＶを出力する
     *
     */
    public void outputCsv() {
        RString filePath = Path.combinePath(Path.getTmpDirectoryPath(), CSVファイル名);
        CsvWriter<NinteichosaItakusakiJohoCsvEntity> csvWriter = new CsvWriter.InstanceBuilder(filePath).canAppend(true).
                setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.UTF_8).setNewLine(NewLine.CRLF).hasHeader(true).build();
        for (dgChosainIchiran_Row row : div.getChosaitakusakichiran().getDgChosainIchiran().getDataSource()) {
            csvWriter.writeLine(converterDataSourceFromToCsvEntity(row));
        }
        csvWriter.close();
    }

    /**
     * 入力明細エリアの入力内容を調査委託先一覧に反映させる。
     *
     */
    public void onClick_btnKakutei() {
        RString 状態 = RString.EMPTY;
        if (追加状態コード == div.get状態()) {
            状態 = 追加状態;
        } else if (修正状態コード == div.get状態()) {
            if (div.getChosaitakusakichiran().getDgChosainIchiran().getClickedItem().getJotai().equals(追加状態)) {
                状態 = 追加状態;
            } else {
                状態 = 修正状態;
            }
        } else if (削除状態コード == div.get状態()) {
            div.getChosaitakusakichiran().getDgChosainIchiran().getClickedItem().setJotai(削除状態);
            return;
        }
        TextBoxCode 認定調査委託先コード = new TextBoxCode();
        TextBoxNum 割付定員 = new TextBoxNum();
        認定調査委託先コード.setValue(div.getChosaitakusakiJohoInput().getTxtChosaItakusaki().getValue());
        割付定員.setValue(div.getChosaitakusakiJohoInput().getTxtjigyoshano().getValue());
        dgChosainIchiran_Row row = new dgChosainIchiran_Row(
                new LasdecCode(div.getChosaitakusakiJohoInput().getTxtShichoson().getValue()),
                状態,
                div.getChosaitakusakiJohoInput().getTxtShichosonmei().getValue(),
                認定調査委託先コード,
                new RString(div.getChosaitakusakiJohoInput().getTxtjigyoshano().getValue().toString()),
                div.getChosaitakusakiJohoInput().getTxtChosaitakusakiname().getValue(),
                div.getChosaitakusakiJohoInput().getTxtChosaitakusakiKananame().getValue(),
                div.getChosaitakusakiJohoInput().getTxtYubinNo().getValue().getEditedYubinNo(),
                div.getChosaitakusakiJohoInput().getTxtJusho().getDomain().getColumnValue(),
                div.getChosaitakusakiJohoInput().getTxtTelNo().getDomain().getColumnValue(),
                div.getChosaitakusakiJohoInput().getTxtFaxNo().getDomain().getColumnValue(),
                div.getChosaitakusakiJohoInput().getTxtdaihyoshaname().getDomain().getColumnValue(),
                div.getChosaitakusakiJohoInput().getTxtdaihyoshakananame().getDomain().getColumnValue(),
                div.getChosaitakusakiJohoInput().getDdlItakusakikubun().getSelectedValue(),
                div.getChosaitakusakiJohoInput().getDdltokuteichosain().getSelectedValue(),
                割付定員,
                div.getChosaitakusakiJohoInput().getTxtChikuMei().getValue(),
                div.getChosaitakusakiJohoInput().getRadautowatitsuke().getSelectedValue(),
                div.getChosaitakusakiJohoInput().getDdlKikankubun().getSelectedValue(),
                div.getChosaitakusakiJohoInput().getRadChosainJokyo().getSelectedValue());
        int clickedRowId = div.getChosaitakusakichiran().getDgChosainIchiran().getClickedRowId();
        if (clickedRowId != -1) {
            div.getChosaitakusakichiran().getDgChosainIchiran().getDataSource().add(row);
        } else {
            div.getChosaitakusakichiran().getDgChosainIchiran().getDataSource().set(clickedRowId, row);
        }
    }

    /**
     * is調査委託先情報登録エリア編集有り
     *
     * @return is調査委託先情報登録エリア編集有り
     */
    public boolean is調査委託先情報登録エリア編集有り() {
        return div.getHdnInputDiv().equals(div.getChosaitakusakiJohoInput());
    }

    /**
     * 入力データをＤＢに保存する
     *
     */
    public void save調査委託先一覧データ() {
        for (dgChosainIchiran_Row row : div.getChosaitakusakichiran().getDgChosainIchiran().getDataSource()) {
            if (追加状態.equals(row.getJotai())) {
                NinteichosaItakusakiJoho joho = converterDataSourceFromKoseiShichosonMaster(row, EntityDataState.Added);
                johoManager.save(joho);
            } else if (修正状態.equals(row.getJotai())) {
                NinteichosaItakusakiJoho joho = converterDataSourceFromKoseiShichosonMaster(row, EntityDataState.Modified);
                johoManager.save(joho);
            } else if (削除状態.equals(row.getJotai())) {
                NinteichosaItakusakiJoho joho = converterDataSourceFromKoseiShichosonMaster(row, EntityDataState.Deleted);
                johoManager.deletePhysical(joho.toEntity());
            }
        }
    }

    /**
     * 削除行データの整合性チェック
     *
     * @param 市町村コード
     * @param 認定調査委託先コード
     * @return 削除行データの整合性
     */
    public boolean 削除行データの整合性チェック(LasdecCode 市町村コード, RString 認定調査委託先コード) {
        int 件数 = chosainJohoManager.countByShichosonCodeAndNinteichosaItakusakiCode(市町村コード, 認定調査委託先コード);
        return 件数 <= 0;
    }

    private void set明細照会状態() {
        div.set状態(その他状態コード);
        setChosaitakusakiJohoInputDisabled(Boolean.TRUE);
        div.getChosaitakusakiJohoInput().getBtnKakutei().setDisabled(Boolean.TRUE);

    }

    private List<dgChosainIchiran_Row> converterDataSourceFromKoseiShichosonMaster(List<KoseiShichosonMaster> list) {
        List<dgChosainIchiran_Row> dataSources = new ArrayList<>();
        for (KoseiShichosonMaster master : list) {
            for (NinteichosaItakusakiJoho joho : master.getNinteichosaItakusakiJohoiList()) {
                TextBoxCode 認定調査委託先コード = new TextBoxCode();
                TextBoxNum 割付定員 = new TextBoxNum();
                認定調査委託先コード.setValue(joho.get認定調査委託先コード());
                割付定員.setValue(new Decimal(joho.get割付定員()));
                dgChosainIchiran_Row row = new dgChosainIchiran_Row(
                        joho.get市町村コード(),
                        RString.EMPTY,
                        master.get市町村名称(),
                        認定調査委託先コード,
                        joho.get事業者番号().getColumnValue(),
                        joho.get事業者名称(),
                        joho.get事業者カナ名称(),
                        joho.get郵便番号().getEditedYubinNo(),
                        joho.get住所(),
                        joho.get電話番号().getColumnValue(),
                        joho.getFAX番号().getColumnValue(),
                        joho.get代表者氏名(),
                        joho.get代表者カナ氏名(),
                        ChosaItakuKubunCode.toValue(joho.get調査委託区分()).get名称(),
                        joho.get特定調査員表示フラグ() ? 特定調査員表示フラグ表示 : 特定調査員表示フラグ非表示,
                        割付定員,
                        joho.get割付地区().getColumnValue(),
                        joho.get自動割付フラグ() ? 自動割付フラグ有効 : 自動割付フラグ無効,
                        ChosaKikanKubun.toValue(joho.get機関の区分()).get名称(),
                        joho.get状況フラグ() ? 状況フラグ有効 : 状況フラグ無効);
                dataSources.add(row);
            }
        }
        return dataSources;
    }

    private NinteichosaItakusakiJoho converterDataSourceFromKoseiShichosonMaster(dgChosainIchiran_Row row, EntityDataState state) {
        DbT5910NinteichosaItakusakiJohoEntity entity = new DbT5910NinteichosaItakusakiJohoEntity();
        entity.setShichosonCode(row.getShichosonCode());
        entity.setNinteichosaItakusakiCode(row.getChosaItakusakiCode().getValue());
        entity.setState(state);
        if (!state.equals(EntityDataState.Deleted)) {
            entity.setJigyoshaNo(new JigyoshaNo(row.getJigyoshaNo()));
            entity.setJigyoshaMeisho(row.getChosaItakusakiMeisho());
            entity.setJigyoshaMeishoKana(row.getChosaItakusakiKana());
            entity.setYubinNo(new YubinNo(row.getYubinNo()));
            entity.setJusho(row.getJusho());
            entity.setTelNo(new TelNo(row.getTelNo()));
            entity.setFaxNo(new TelNo(row.getFaxNo()));
            entity.setDaihyoshaName(row.getKikanDaihyoshaName());
            entity.setDaihyoshaNameKana(row.getKikanDaihyoshaKanaName());
            entity.setChosaItakuKubun(ChosaItakuKubunCode.valueOf(row.getChosaItakuKubun().toString()).getコード());
            entity.setTokuteiChosainDisplayFlag(特定調査員表示フラグ表示.equals(特定調査員表示フラグ表示));
            entity.setWaritsukeTeiin(row.getWaritsukeTeiin().getValue().intValue());
            entity.setWaritsukeChiku(new ChikuCode(row.getChiku()));
            entity.setAutoWaritsukeFlag(自動割付フラグ有効.equals(row.getAutoWaritsukeFlag()));
            entity.setKikanKubun(ChosaKikanKubun.valueOf(row.getKikanKubun().toString()).getコード());
            entity.setJokyoFlag(状況フラグ有効.equals(row.getJokyoFlag()));
        }
        NinteichosaItakusakiJohoRelateEntity relateEntity = new NinteichosaItakusakiJohoRelateEntity();
        relateEntity.set認定調査委託先情報Entity(entity);
        NinteichosaItakusakiJoho itakusakiJoho = new NinteichosaItakusakiJoho(relateEntity);
        return itakusakiJoho;

    }

    private List<KeyValueDataSource> createListFromChosaItakuKubunCodeASC() {
        List<KeyValueDataSource> list = new ArrayList<>();
        List<RString> codes = new ArrayList<>();
        for (ChosaItakuKubunCode code : ChosaItakuKubunCode.values()) {
            codes.add(code.getコード());
        }
        Collections.sort(codes);
        for (RString code : codes) {
            ChosaItakuKubunCode chosaItakuKubunCode = ChosaItakuKubunCode.toValue(code);
            KeyValueDataSource dataSource = new KeyValueDataSource(chosaItakuKubunCode.getコード(), chosaItakuKubunCode.get名称());
            list.add(dataSource);
        }
        return list;
    }

    private List<KeyValueDataSource> createListFromChosaKikanKubunASC() {
        List<KeyValueDataSource> list = new ArrayList<>();
        List<RString> codes = new ArrayList<>();
        for (ChosaKikanKubun code : ChosaKikanKubun.values()) {
            codes.add(code.getコード());
        }
        Collections.sort(codes);
        for (RString code : codes) {
            ChosaKikanKubun kikanKubun = ChosaKikanKubun.toValue(code);
            KeyValueDataSource dataSource = new KeyValueDataSource(kikanKubun.getコード(), kikanKubun.get名称());
            list.add(dataSource);
        }
        return list;
    }

    private void setChosaitakusakiJohoInput(dgChosainIchiran_Row row) {
        div.getChosaitakusakiJohoInput().getTxtShichoson().setValue(row.getShichoson());
        div.getChosaitakusakiJohoInput().getTxtShichosonmei().setValue(row.getShichosonCode().getColumnValue());
        div.getChosaitakusakiJohoInput().getTxtChosaItakusaki().setValue(row.getChosaItakusakiCode().getValue());
        div.getChosaitakusakiJohoInput().getTxtjigyoshano().setValue(new Decimal(row.getJigyoshaNo().toString()));
        div.getChosaitakusakiJohoInput().getTxtChosaitakusakiname().setValue(row.getChosaItakusakiMeisho());
        div.getChosaitakusakiJohoInput().getTxtChosaitakusakiKananame().setValue(row.getChosaItakusakiKana());
        div.getChosaitakusakiJohoInput().getTxtYubinNo().setValue(new YubinNo(row.getYubinNo()));
        div.getChosaitakusakiJohoInput().getTxtJusho().setDomain(new AtenaJusho(row.getJusho()));
        div.getChosaitakusakiJohoInput().getTxtTelNo().setDomain(new TelNo(row.getTelNo()));
        div.getChosaitakusakiJohoInput().getTxtFaxNo().setDomain(new TelNo(row.getFaxNo()));
        div.getChosaitakusakiJohoInput().getTxtdaihyoshaname().setDomain(new AtenaJusho(row.getKikanDaihyoshaName()));
        div.getChosaitakusakiJohoInput().getTxtdaihyoshakananame().setDomain(new AtenaJusho(row.getKikanDaihyoshaKanaName()));
        div.getChosaitakusakiJohoInput().getDdlItakusakikubun().setSelectedValue(row.getChosaItakuKubun());
        div.getChosaitakusakiJohoInput().getDdltokuteichosain().setSelectedKey(row.getTokuteiChosainDispFlag());
        div.getChosaitakusakiJohoInput().getTxtteiin().setValue(new YubinNo(row.getWaritsukeTeiin().getValue().toString()));
        div.getChosaitakusakiJohoInput().getTxtChiku().setValue(row.getChiku());
        div.getChosaitakusakiJohoInput().getTxtChikuMei().setValue(
                CodeMaster.getCodeMeisho(SubGyomuCode.DBE認定支援, 割付地区名称コード種別, new Code(row.getChiku())));
        div.getChosaitakusakiJohoInput().getRadautowatitsuke().setSelectedValue(row.getAutoWaritsukeFlag());
        div.getChosaitakusakiJohoInput().getDdlKikankubun().setSelectedValue(row.getKikanKubun());
        div.getChosaitakusakiJohoInput().getRadChosainJokyo().setSelectedValue(row.getJokyoFlag());
    }

    private void setChosaitakusakiJohoInputDisabled(Boolean isDisabled) {
        div.getChosaitakusakiJohoInput().getTxtShichoson().setDisabled(isDisabled);
        div.getChosaitakusakiJohoInput().getBtnToSearchShichoson().setDisabled(isDisabled);
        div.getChosaitakusakiJohoInput().getTxtShichosonmei().setDisabled(isDisabled);
        div.getChosaitakusakiJohoInput().getTxtChosaItakusaki().setDisabled(isDisabled);
        div.getChosaitakusakiJohoInput().getTxtjigyoshano().setDisabled(isDisabled);
        div.getChosaitakusakiJohoInput().getBtnToSearchjigyosha().setDisabled(isDisabled);
        div.getChosaitakusakiJohoInput().getTxtChosaitakusakiname().setDisabled(isDisabled);
        div.getChosaitakusakiJohoInput().getTxtChosaitakusakiKananame().setDisabled(isDisabled);
        div.getChosaitakusakiJohoInput().getTxtYubinNo().setDisabled(isDisabled);
        div.getChosaitakusakiJohoInput().getTxtJusho().setDisabled(isDisabled);
        div.getChosaitakusakiJohoInput().getTxtTelNo().setDisabled(isDisabled);
        div.getChosaitakusakiJohoInput().getTxtFaxNo().setDisabled(isDisabled);
        div.getChosaitakusakiJohoInput().getTxtdaihyoshaname().setDisabled(isDisabled);
        div.getChosaitakusakiJohoInput().getTxtdaihyoshakananame().setDisabled(isDisabled);
        div.getChosaitakusakiJohoInput().getDdlItakusakikubun().setDisabled(isDisabled);
        div.getChosaitakusakiJohoInput().getDdltokuteichosain().setDisabled(isDisabled);
        div.getChosaitakusakiJohoInput().getTxtteiin().setDisabled(isDisabled);
        div.getChosaitakusakiJohoInput().getTxtChiku().setDisabled(isDisabled);
        div.getChosaitakusakiJohoInput().getTxtChikuMei().setDisabled(isDisabled);
        div.getChosaitakusakiJohoInput().getBtnToSearchchiku().setDisabled(isDisabled);
        div.getChosaitakusakiJohoInput().getRadautowatitsuke().setDisabled(isDisabled);
        div.getChosaitakusakiJohoInput().getDdlKikankubun().setDisabled(isDisabled);
        div.getChosaitakusakiJohoInput().getRadChosainJokyo().setDisabled(isDisabled);
    }

    private NinteichosaItakusakiJohoCsvEntity converterDataSourceFromToCsvEntity(dgChosainIchiran_Row row) {
        NinteichosaItakusakiJohoCsvEntity csvEntity = new NinteichosaItakusakiJohoCsvEntity();
        csvEntity.set市町村コード(row.getShichosonCode().getColumnValue());
        csvEntity.set市町村(row.getShichoson());
        csvEntity.set調査委託先コード(row.getChosaItakusakiCode().getValue());
        csvEntity.set事業者番号(row.getJigyoshaNo());
        csvEntity.set調査委託先名称(row.getChosaItakusakiMeisho());
        csvEntity.set調査委託先カナ名称(row.getChosaItakusakiKana());
        csvEntity.set郵便番号(row.getYubinNo());
        csvEntity.set住所(row.getJusho());
        csvEntity.set電話番号(row.getTelNo());
        csvEntity.setＦＡＸ番号(row.getFaxNo());
        csvEntity.set機関代表者氏名(row.getKikanDaihyoshaName());
        csvEntity.set機関代表者カナ氏名(row.getKikanDaihyoshaKanaName());
        csvEntity.set調査委託区分(row.getChosaItakuKubun());
        csvEntity.set特定調査員表示フラグ(row.getTokuteiChosainDispFlag());
        csvEntity.set割付定員(new RString(row.getWaritsukeTeiin().getValue().toString()));
        csvEntity.set割付地区コード(row.getChiku());
        csvEntity.set割付地区名称(CodeMaster.getCodeMeisho(SubGyomuCode.DBE認定支援, 割付地区名称コード種別, new Code(row.getChiku())));
        csvEntity.set自動割付フラグ(row.getAutoWaritsukeFlag());
        csvEntity.set機関の区分(row.getKikanKubun());
        csvEntity.set状況フラグ(row.getJokyoFlag());
        return csvEntity;
    }

}
