/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE9030001;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.NinteichosaItakusaki;
import jp.co.ndensan.reams.db.dbe.business.core.NinteichosaItakusakiJohoRelate;
import jp.co.ndensan.reams.db.dbe.business.core.tyousai.koseishichosonmaster.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbe.business.core.tyousai.ninteichosaitakusakijoho.NinteichosaItakusakiJoho;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.chosa.ChosaItakuKubunCode;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.chosa.ChosaKikanKubun;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.ninteichosaitakusaki.NinteichosaItakusakiKensakuParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9030001.NinteichosaItakusakiMasterDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9030001.dgChosainIchiran_Row;
import jp.co.ndensan.reams.db.dbe.service.core.tyousai.koseishichosonmaster.KoseiShichosonMasterManager;
import jp.co.ndensan.reams.db.dbe.service.core.tyousai.ninteichosaitakusakijoho.NinteichosaItakusakiJohoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
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
    private static final RString 状況フラグ有効 = new RString("有効");
    private static final RString 状況フラグ無効 = new RString("無効");
    private static final RString 自動割付フラグ有効 = new RString("有効");
    private static final RString 自動割付フラグ無効 = new RString("無効");
    private static final RString 特定調査員表示フラグ表示 = new RString("表示");
    private static final RString 特定調査員表示フラグ非表示 = new RString("非表示");
    private static final CodeShubetsu 割付地区名称コード種別 = new CodeShubetsu("5002");
    private static final RString CSV_WRITER_DELIMITER = new RString(",");
    private static final RString SELECTKEY_空白 = new RString("blank");
    private static final RString 追加状態コード = new RString("追加");
    private static final RString 修正状態コード = new RString("修正");
    private static final RString 削除状態コード = new RString("削除");
    private static final RString その他状態コード = new RString("その他");
    private static final RString BOOLEAN_TRUE = new RString("TRUE");
    private static final RString BOOLEAN_FALSE = new RString("FALSE");

    /**
     * コンストラクタです。
     *
     * @param div 認定調査委託先マスタDiv
     */
    public NinteichosaItakusakiMasterHandler(NinteichosaItakusakiMasterDiv div) {
        this.div = div;
        johoManager = NinteichosaItakusakiJohoManager.createInstance();
        masterManager = KoseiShichosonMasterManager.createInstance();
    }

    /**
     * 画面初期化表示、画面項目に設定されている値をクリアする。
     *
     */
    public void onLoad() {
        div.getChosainSearch().getCcdHokenshaList().loadHokenshaList();
        div.getChosainSearch().getRadSearchChosainJokyo().setSelectedKey(new RString("key0"));
        List<KeyValueDataSource> chosaItakuKubunCodes = new ArrayList<>();
        chosaItakuKubunCodes.add(new KeyValueDataSource(SELECTKEY_空白, RString.EMPTY));
        chosaItakuKubunCodes.addAll(createListFromChosaItakuKubunCodeASC());
        div.getChosainSearch().getDdlitakukubun().getDataSource().clear();
        div.getChosainSearch().getDdlitakukubun().getDataSource().addAll(chosaItakuKubunCodes);
        List<KeyValueDataSource> chosaKikanKubunCodes = new ArrayList<>();
        chosaKikanKubunCodes.add(new KeyValueDataSource(SELECTKEY_空白, RString.EMPTY));
        chosaKikanKubunCodes.addAll(createListFromChosaKikanKubunASC());
        div.getChosainSearch().getDdlkikankubun().getDataSource().clear();
        div.getChosainSearch().getDdlkikankubun().getDataSource().addAll(chosaKikanKubunCodes);
        div.getChosainSearch().clear();
    }

    /**
     * 検索条件入力項目をクリアする。
     *
     */
    public void clearKensakuJoken() {
        div.getChosainSearch().getRadSearchChosainJokyo().setSelectedIndex(DROPDOWNLIST_BLANK);
        div.getChosainSearch().getTxtSearchChosaItakusakiCodeFrom().clearValue();
        div.getChosainSearch().getTxtSearchChosaItakusakiCodeTo().clearValue();
        div.getChosainSearch().getTxtSearchChosaItakusakiMeisho().clearValue();
        div.getChosainSearch().getTxtSearchChosaItakusakiKanaMeisho().clearValue();
        div.getChosainSearch().getDdlitakukubun().setSelectedIndex(DROPDOWNLIST_BLANK);
        div.getChosainSearch().getDdlkikankubun().setSelectedIndex(DROPDOWNLIST_BLANK);
        div.getChosainSearch().getTxtSaidaiHyojiKensu().clearValue();
    }

    /**
     * 追加ボタンが押下された場合、明細エリアを空白で表示する
     *
     * @return List<KoseiShichosonMaster>
     */
    public List<KoseiShichosonMaster> searchShujii() {
        NinteichosaItakusakiKensakuParameter 構成市町村マスタ検索条件 = NinteichosaItakusakiKensakuParameter.createParam(
                状況フラグ有効.equals(div.getChosainSearch().getRadSearchChosainJokyo().getSelectedValue()),
                div.getChosainSearch().getCcdHokenshaList().getSelectedItem() == null
                || div.getChosainSearch().getCcdHokenshaList().getSelectedItem().get市町村コード().isEmpty()
                ? null : div.getChosainSearch().getCcdHokenshaList().getSelectedItem().get市町村コード(),
                div.getChosainSearch().getTxtSearchChosaItakusakiCodeFrom().getValue().isEmpty()
                ? null : div.getChosainSearch().getTxtSearchChosaItakusakiCodeFrom().getValue(),
                div.getChosainSearch().getTxtSearchChosaItakusakiCodeTo().getValue().isEmpty()
                ? null : div.getChosainSearch().getTxtSearchChosaItakusakiCodeTo().getValue(),
                div.getChosainSearch().getTxtSearchChosaItakusakiMeisho().getValue().isEmpty()
                ? null : div.getChosainSearch().getTxtSearchChosaItakusakiMeisho().getValue(),
                div.getChosainSearch().getTxtSearchChosaItakusakiKanaMeisho().getValue().isEmpty()
                ? null : div.getChosainSearch().getTxtSearchChosaItakusakiKanaMeisho().getValue(),
                div.getChosainSearch().getDdlitakukubun().getSelectedKey().equals(SELECTKEY_空白)
                ? null : div.getChosainSearch().getDdlitakukubun().getSelectedKey(),
                div.getChosainSearch().getDdlkikankubun().getSelectedKey().equals(SELECTKEY_空白)
                ? null : div.getChosainSearch().getDdlkikankubun().getSelectedKey(),
                div.getChosainSearch().getTxtSaidaiHyojiKensu().getValue() == null
                ? null : div.getChosainSearch().getTxtSaidaiHyojiKensu().getValue().intValue()
        );
        return masterManager.ninteichosaItakusakiSearch(構成市町村マスタ検索条件);
    }

    /**
     * 検索条件に従い、調査委託先情報を検索する。
     *
     * @param list KoseiShichosonMaster
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
        setChosaitakusakiJohoInputDisabled(Boolean.FALSE);
        div.setHdnSelectID(RString.EMPTY);
        div.getChosaitakusakiJohoInput().getBtnKakutei().setDisabled(Boolean.FALSE);
        div.getChosaitakusakiJohoInput().getDdlItakusakikubun().getDataSource().clear();
        div.getChosaitakusakiJohoInput().getDdlItakusakikubun().getDataSource().addAll(createListFromChosaItakuKubunCodeASC());
        div.getChosaitakusakiJohoInput().getDdlKikankubun().getDataSource().clear();
        div.getChosaitakusakiJohoInput().getDdlKikankubun().getDataSource().addAll(createListFromChosaKikanKubunASC());
        div.getChosaitakusakiJohoInput().getDdltokuteichosain().getDataSource().clear();
        div.getChosaitakusakiJohoInput().getDdltokuteichosain().getDataSource().add(
                new KeyValueDataSource(BOOLEAN_TRUE, 特定調査員表示フラグ表示));
        div.getChosaitakusakiJohoInput().getDdltokuteichosain().getDataSource().add(
                new KeyValueDataSource(BOOLEAN_FALSE, 特定調査員表示フラグ非表示));
        div.getChosaitakusakiJohoInput().clear();
        div.setHdnInputDiv(getChosaitakusakiJohoInputValue());
    }

    /**
     * 修正アイコンを押下した場合、明細エリアに選択行の内容を表示し、項目を入力可能にする
     *
     */
    public void set修正状態() {
        div.set状態(修正状態コード);
        div.getChosaitakusakiJohoInput().getDdlItakusakikubun().getDataSource().clear();
        div.getChosaitakusakiJohoInput().getDdlItakusakikubun().getDataSource().addAll(createListFromChosaItakuKubunCodeASC());
        div.getChosaitakusakiJohoInput().getDdlKikankubun().getDataSource().clear();
        div.getChosaitakusakiJohoInput().getDdlKikankubun().getDataSource().addAll(createListFromChosaKikanKubunASC());
        div.getChosaitakusakiJohoInput().getDdltokuteichosain().getDataSource().clear();
        div.getChosaitakusakiJohoInput().getDdltokuteichosain().getDataSource().add(
                new KeyValueDataSource(BOOLEAN_TRUE, 特定調査員表示フラグ表示));
        div.getChosaitakusakiJohoInput().getDdltokuteichosain().getDataSource().add(
                new KeyValueDataSource(BOOLEAN_FALSE, 特定調査員表示フラグ非表示));
        div.setHdnSelectID(new RString(String.valueOf(div.getChosaitakusakichiran().getDgChosainIchiran().getClickedRowId())));
        setChosaitakusakiJohoInputDisabled(Boolean.FALSE);
        div.getChosaitakusakiJohoInput().getTxtShichoson().setDisabled(Boolean.TRUE);
        div.getChosaitakusakiJohoInput().getBtnToSearchShichoson().setDisabled(Boolean.TRUE);
        div.getChosaitakusakiJohoInput().getTxtShichosonmei().setDisabled(Boolean.TRUE);
        div.getChosaitakusakiJohoInput().getTxtChosaItakusaki().setDisabled(Boolean.TRUE);
        setChosaitakusakiJohoInput(div.getChosaitakusakichiran().getDgChosainIchiran().getClickedItem());
        div.getChosaitakusakiJohoInput().getBtnKakutei().setDisabled(Boolean.FALSE);
        div.setHdnInputDiv(getChosaitakusakiJohoInputValue());
    }

    /**
     * 削除アイコンを押下した場合、明細エリアに選択行の内容を表示し、項目を入力不可にする
     *
     */
    public void set削除状態() {
        div.set状態(削除状態コード);
        div.getChosaitakusakiJohoInput().getDdlItakusakikubun().getDataSource().clear();
        div.getChosaitakusakiJohoInput().getDdlItakusakikubun().getDataSource().addAll(createListFromChosaItakuKubunCodeASC());
        div.getChosaitakusakiJohoInput().getDdlKikankubun().getDataSource().clear();
        div.getChosaitakusakiJohoInput().getDdlKikankubun().getDataSource().addAll(createListFromChosaKikanKubunASC());
        div.getChosaitakusakiJohoInput().getDdltokuteichosain().getDataSource().clear();
        div.getChosaitakusakiJohoInput().getDdltokuteichosain().getDataSource().add(
                new KeyValueDataSource(BOOLEAN_TRUE, 特定調査員表示フラグ表示));
        div.getChosaitakusakiJohoInput().getDdltokuteichosain().getDataSource().add(
                new KeyValueDataSource(BOOLEAN_FALSE, 特定調査員表示フラグ非表示));
        div.setHdnSelectID(new RString(String.valueOf(div.getChosaitakusakichiran().getDgChosainIchiran().getClickedRowId())));
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
        if (追加状態コード.equals(row.getJotai())) {
            set追加状態();
        } else if (修正状態コード.equals(row.getJotai())) {
            set修正状態();
        } else if (削除状態コード.equals(row.getJotai())) {
            set削除状態();
        } else {
            set明細照会状態();
        }
    }

    /**
     * 入力明細エリアの入力内容を調査委託先一覧に反映させる。
     *
     */
    public void onClick_btnKakutei() {
        RString 状態 = RString.EMPTY;
        int selectID = -1;
        if (!RString.isNullOrEmpty(div.getHdnSelectID())) {
            selectID = Integer.valueOf(div.getHdnSelectID().toString());
        }
        if (追加状態コード.equals(div.get状態())) {
            状態 = 追加状態コード;
        } else if (修正状態コード.equals(div.get状態())) {
            if (div.getChosaitakusakichiran().getDgChosainIchiran().getDataSource().get(selectID).getJotai().equals(追加状態コード)) {
                状態 = 追加状態コード;
            } else {
                状態 = 修正状態コード;
            }
        } else if (削除状態コード.equals(div.get状態())) {
            if (div.getChosaitakusakichiran().getDgChosainIchiran().getDataSource().get(selectID).getJotai().equals(追加状態コード)) {
                div.getChosaitakusakichiran().getDgChosainIchiran().getDataSource().remove(selectID);
                return;
            }
            div.getChosaitakusakichiran().getDgChosainIchiran().getDataSource().get(selectID).setJotai(削除状態コード);
            return;
        }
        TextBoxCode 認定調査委託先コード = new TextBoxCode();
        TextBoxNum 割付定員 = new TextBoxNum();
        認定調査委託先コード.setValue(div.getChosaitakusakiJohoInput().getTxtChosaItakusaki().getValue());
        //TODO 割付定員 TextBoxYubinNo?
        割付定員.setValue(Decimal.ZERO);
        dgChosainIchiran_Row row = new dgChosainIchiran_Row(
                状態,
                div.getChosaitakusakiJohoInput().getTxtShichosonmei().getValue(),
                認定調査委託先コード,
                div.getChosaitakusakiJohoInput().getTxtjigyoshano().getValue() == null
                ? RString.EMPTY : new RString(div.getChosaitakusakiJohoInput().getTxtjigyoshano().getValue().toString()),
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
                div.getChosaitakusakiJohoInput().getTxtChiku().getValue(),
                div.getChosaitakusakiJohoInput().getRadautowatitsuke().getSelectedValue(),
                div.getChosaitakusakiJohoInput().getDdlKikankubun().getSelectedValue(),
                div.getChosaitakusakiJohoInput().getRadChosainJokyo().getSelectedValue());
        if (selectID == -1) {
            div.setHdnShichosonCodeList(div.getHdnShichosonCodeList().concat(
                    div.getChosaitakusakiJohoInput().getTxtShichoson().getValue()).concat(CSV_WRITER_DELIMITER));
            div.getChosaitakusakichiran().getDgChosainIchiran().getDataSource().add(row);
        } else {
            div.getChosaitakusakichiran().getDgChosainIchiran().getDataSource().set(selectID, row);
        }
    }

    /**
     * is調査委託先情報登録エリア編集有り
     *
     * @return is調査委託先情報登録エリア編集有り
     */
    public boolean is調査委託先情報登録エリア編集有り() {
        if (div.getHdnInputDiv() == null) {
            return true;
        }
        return !getChosaitakusakiJohoInputValue().equals(div.getHdnInputDiv());
    }

    /**
     * 入力データをＤＢに保存する
     *
     */
    public void save調査委託先一覧データ() {
        int rowIndex = 0;
        for (dgChosainIchiran_Row row : div.getChosaitakusakichiran().getDgChosainIchiran().getDataSource()) {
            if (追加状態コード.equals(row.getJotai())) {
                NinteichosaItakusakiJoho joho = converterDataSourceFromKoseiShichosonMaster(row, EntityDataState.Added, rowIndex);
                johoManager.save(joho);
            } else if (修正状態コード.equals(row.getJotai())) {
                NinteichosaItakusakiJoho joho = converterDataSourceFromKoseiShichosonMaster(row, EntityDataState.Modified, rowIndex);
                johoManager.save(joho);
            } else if (削除状態コード.equals(row.getJotai())) {
                NinteichosaItakusakiJoho joho = converterDataSourceFromKoseiShichosonMaster(row, EntityDataState.Deleted, rowIndex);
                johoManager.deletePhysical(joho.toEntity());
            }
            rowIndex++;
        }
    }

    /**
     * 削除行データの整合性チェック
     *
     * @param 市町村コード 市町村コード
     * @param 認定調査委託先コード 認定調査委託先コード
     * @return 削除行データの整合性
     */
    public boolean 削除行データの整合性チェック(LasdecCode 市町村コード, RString 認定調査委託先コード) {
        return false;
//        int 件数 = chosainJohoManager.countByShichosonCodeAndNinteichosaItakusakiCode(市町村コード, 認定調査委託先コード);
//        return 件数 <= 0;
    }

    private void set明細照会状態() {
        div.set状態(その他状態コード);
        div.getChosaitakusakiJohoInput().getDdlItakusakikubun().getDataSource().clear();
        div.getChosaitakusakiJohoInput().getDdlItakusakikubun().getDataSource().addAll(createListFromChosaItakuKubunCodeASC());
        div.getChosaitakusakiJohoInput().getDdlKikankubun().getDataSource().clear();
        div.getChosaitakusakiJohoInput().getDdlKikankubun().getDataSource().addAll(createListFromChosaKikanKubunASC());
        div.getChosaitakusakiJohoInput().getDdltokuteichosain().getDataSource().clear();
        div.getChosaitakusakiJohoInput().getDdltokuteichosain().getDataSource().add(
                new KeyValueDataSource(BOOLEAN_TRUE, 特定調査員表示フラグ表示));
        div.getChosaitakusakiJohoInput().getDdltokuteichosain().getDataSource().add(
                new KeyValueDataSource(BOOLEAN_FALSE, 特定調査員表示フラグ非表示));
        div.setHdnSelectID(new RString(String.valueOf(div.getChosaitakusakichiran().getDgChosainIchiran().getClickedRowId())));
        setChosaitakusakiJohoInputDisabled(Boolean.TRUE);
        setChosaitakusakiJohoInput(div.getChosaitakusakichiran().getDgChosainIchiran().getClickedItem());
        div.getChosaitakusakiJohoInput().getBtnKakutei().setDisabled(Boolean.TRUE);

    }

    private List<dgChosainIchiran_Row> converterDataSourceFromKoseiShichosonMaster(List<KoseiShichosonMaster> list) {
        div.setHdnShichosonCodeList(RString.EMPTY);
        List<dgChosainIchiran_Row> dataSources = new ArrayList<>();
        for (KoseiShichosonMaster master : list) {
            for (NinteichosaItakusakiJoho joho : master.getNinteichosaItakusakiJohoiList()) {
                TextBoxCode 認定調査委託先コード = new TextBoxCode();
                TextBoxNum 割付定員 = new TextBoxNum();
                認定調査委託先コード.setValue(joho.get認定調査委託先コード());
                割付定員.setValue(new Decimal(joho.get割付定員()));
                RString chosaItakuKubunCode;
                try {
                    chosaItakuKubunCode = ChosaItakuKubunCode.toValue(joho.get調査委託区分()).get名称();
                } catch (IllegalArgumentException e) {
                    chosaItakuKubunCode = RString.EMPTY;
                }
                RString chosaKikanKubun;
                try {
                    chosaKikanKubun = ChosaKikanKubun.toValue(joho.get機関の区分()).get名称();
                } catch (IllegalArgumentException e) {
                    chosaKikanKubun = RString.EMPTY;
                }
                RString 特定調査員表示フラグ = get特定調査員表示フラグ(joho);
                dgChosainIchiran_Row row = new dgChosainIchiran_Row(
                        RString.EMPTY,
                        master.get市町村名称() == null ? RString.EMPTY : master.get市町村名称(),
                        認定調査委託先コード,
                        joho.get事業者番号() == null ? RString.EMPTY : joho.get事業者番号().getColumnValue(),
                        joho.get事業者名称() == null ? RString.EMPTY : joho.get事業者名称(),
                        joho.get事業者カナ名称() == null ? RString.EMPTY : joho.get事業者カナ名称(),
                        joho.get郵便番号() == null ? RString.EMPTY : joho.get郵便番号().getEditedYubinNo(),
                        joho.get住所() == null ? RString.EMPTY : joho.get住所(),
                        joho.get電話番号() == null ? RString.EMPTY : joho.get電話番号().getColumnValue(),
                        joho.getFAX番号() == null ? RString.EMPTY : joho.getFAX番号().getColumnValue(),
                        joho.get代表者氏名() == null ? RString.EMPTY : joho.get代表者氏名(),
                        joho.get代表者カナ氏名() == null ? RString.EMPTY : joho.get代表者カナ氏名(),
                        chosaItakuKubunCode,
                        特定調査員表示フラグ,
                        割付定員,
                        joho.get割付地区() == null ? RString.EMPTY : joho.get割付地区().getColumnValue(),
                        joho.is自動割付フラグTrue() ? 自動割付フラグ有効 : 自動割付フラグ無効,
                        chosaKikanKubun,
                        joho.get状況フラグ() ? 状況フラグ有効 : 状況フラグ無効);
                dataSources.add(row);
                div.setHdnShichosonCodeList(div.getHdnShichosonCodeList().concat(joho.get市町村コード().toString()).concat(CSV_WRITER_DELIMITER));
            }
        }
        return dataSources;
    }

    private RString get特定調査員表示フラグ(NinteichosaItakusakiJoho joho) {
        if (joho.get特定調査員表示フラグ() != null) {
            return joho.get特定調査員表示フラグ() ? 特定調査員表示フラグ表示 : 特定調査員表示フラグ非表示;
        }
        return RString.EMPTY;
    }

    private NinteichosaItakusakiJoho converterDataSourceFromKoseiShichosonMaster(dgChosainIchiran_Row row, EntityDataState state, int rowIndex) {
        LasdecCode shichosonCode = new LasdecCode(div.getHdnShichosonCodeList().split(CSV_WRITER_DELIMITER.toString()).get(rowIndex));
        NinteichosaItakusaki ninteichosaItakusaki = johoManager.selectByKey(shichosonCode, row.getChosaItakusakiCode().getValue());
        if (ninteichosaItakusaki == null || ninteichosaItakusaki.getEntity() == null) {
            ninteichosaItakusaki = new NinteichosaItakusaki();
        }
        ninteichosaItakusaki.getEntity().setShichosonCode(shichosonCode);
        ninteichosaItakusaki.getEntity().setNinteichosaItakusakiCode(row.getChosaItakusakiCode().getValue());
        ninteichosaItakusaki.getEntity().setState(state);
        RString chosaItakuKubunCode;
        try {
            chosaItakuKubunCode = ChosaItakuKubunCode.toValueFrom名称(row.getChosaItakuKubun()).getコード();
        } catch (IllegalArgumentException e) {
            chosaItakuKubunCode = RString.EMPTY;
        }
        RString chosaKikanKubun;
        try {
            chosaKikanKubun = ChosaKikanKubun.valueOf(row.getKikanKubun().toString()).getコード();
        } catch (IllegalArgumentException e) {
            chosaKikanKubun = RString.EMPTY;
        }
        if (!state.equals(EntityDataState.Deleted)) {
            ninteichosaItakusaki.getEntity().setJigyoshaNo(new JigyoshaNo(row.getJigyoshaNo()));
            ninteichosaItakusaki.getEntity().setJigyoshaMeisho(row.getChosaItakusakiMeisho());
            ninteichosaItakusaki.getEntity().setJigyoshaMeishoKana(row.getChosaItakusakiKana());
            ninteichosaItakusaki.getEntity().setYubinNo(new YubinNo(row.getYubinNo()));
            ninteichosaItakusaki.getEntity().setJusho(row.getJusho());
            ninteichosaItakusaki.getEntity().setTelNo(new TelNo(row.getTelNo()));
            ninteichosaItakusaki.getEntity().setFaxNo(new TelNo(row.getFaxNo()));
            ninteichosaItakusaki.getEntity().setDaihyoshaName(row.getKikanDaihyoshaName());
            ninteichosaItakusaki.getEntity().setDaihyoshaNameKana(row.getKikanDaihyoshaKanaName());
            ninteichosaItakusaki.getEntity().setChosaItakuKubun(chosaItakuKubunCode);
            ninteichosaItakusaki.getEntity().setTokuteiChosainDisplayFlag(row.getTokuteiChosainDispFlag().equals(特定調査員表示フラグ表示));
            ninteichosaItakusaki.getEntity().setWaritsukeTeiin(row.getWaritsukeTeiin().getValue().intValue());
            ninteichosaItakusaki.getEntity().setWaritsukeChiku(new ChikuCode(row.getChiku()));
            ninteichosaItakusaki.getEntity().setAutoWaritsukeFlag(自動割付フラグ有効.equals(row.getAutoWaritsukeFlag()));
            ninteichosaItakusaki.getEntity().setKikanKubun(chosaKikanKubun);
            ninteichosaItakusaki.getEntity().setJokyoFlag(状況フラグ有効.equals(row.getJokyoFlag()));
        }
        NinteichosaItakusakiJohoRelate johoRelate = new NinteichosaItakusakiJohoRelate();
        johoRelate.getEntity().set認定調査委託先情報Entity(ninteichosaItakusaki.getEntity());
        return new NinteichosaItakusakiJoho(johoRelate.getEntity());

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
        div.getChosaitakusakiJohoInput().getDdlItakusakikubun().getDataSource().clear();
        div.getChosaitakusakiJohoInput().getDdlItakusakikubun().getDataSource().addAll(createListFromChosaItakuKubunCodeASC());
        div.getChosaitakusakiJohoInput().getDdlKikankubun().getDataSource().clear();
        div.getChosaitakusakiJohoInput().getDdlKikankubun().getDataSource().addAll(createListFromChosaKikanKubunASC());
        div.getChosaitakusakiJohoInput().getDdltokuteichosain().getDataSource().clear();
        div.getChosaitakusakiJohoInput().getDdltokuteichosain().getDataSource().add(
                new KeyValueDataSource(BOOLEAN_TRUE, 特定調査員表示フラグ表示));
        div.getChosaitakusakiJohoInput().getDdltokuteichosain().getDataSource().add(
                new KeyValueDataSource(BOOLEAN_FALSE, 特定調査員表示フラグ非表示));
        RString shichosonCode = div.getHdnShichosonCodeList().split(CSV_WRITER_DELIMITER.toString())
                .get(Integer.valueOf(div.getHdnSelectID().toString()));
        div.getChosaitakusakiJohoInput().getTxtShichoson().setValue(shichosonCode == null
                ? RString.EMPTY : shichosonCode);
        div.getChosaitakusakiJohoInput().getTxtShichosonmei().setValue(row.getShichoson());
        div.getChosaitakusakiJohoInput().getTxtChosaItakusaki().setValue(row.getChosaItakusakiCode() == null
                ? RString.EMPTY : row.getChosaItakusakiCode().getValue());
        div.getChosaitakusakiJohoInput().getTxtjigyoshano().setValue(
                new Decimal(row.getJigyoshaNo() == null || row.getJigyoshaNo().isEmpty()
                        ? new RString("0").toString() : row.getJigyoshaNo().toString()));
        div.getChosaitakusakiJohoInput().getTxtChosaitakusakiname().setValue(row.getChosaItakusakiMeisho() == null
                ? RString.EMPTY : row.getChosaItakusakiMeisho());
        div.getChosaitakusakiJohoInput().getTxtChosaitakusakiKananame().setValue(row.getChosaItakusakiKana());
        div.getChosaitakusakiJohoInput().getTxtYubinNo().setValue(new YubinNo(row.getYubinNo()));
        div.getChosaitakusakiJohoInput().getTxtJusho().setDomain(new AtenaJusho(
                row.getJusho() == null ? RString.EMPTY : row.getJusho()));
        div.getChosaitakusakiJohoInput().getTxtTelNo().setDomain(new TelNo(row.getTelNo()));
        div.getChosaitakusakiJohoInput().getTxtFaxNo().setDomain(new TelNo(row.getFaxNo()));
        div.getChosaitakusakiJohoInput().getTxtdaihyoshaname().setDomain(new AtenaJusho(
                row.getKikanDaihyoshaName() == null ? RString.EMPTY : row.getKikanDaihyoshaName()));
        div.getChosaitakusakiJohoInput().getTxtdaihyoshakananame().setDomain(new AtenaJusho(
                row.getKikanDaihyoshaKanaName() == null ? RString.EMPTY : row.getKikanDaihyoshaKanaName()));
        if (!RString.isNullOrEmpty(row.getChosaItakuKubun())) {
            div.getChosaitakusakiJohoInput().getDdlItakusakikubun().setSelectedValue(row.getChosaItakuKubun());
        }
        if (!RString.isNullOrEmpty(row.getTokuteiChosainDispFlag())) {
            div.getChosaitakusakiJohoInput().getDdltokuteichosain().setSelectedValue(row.getTokuteiChosainDispFlag());
        }
        //TODO 割付定員 TextBoxYubinNo?
        div.getChosaitakusakiJohoInput().getTxtteiin().setValue(YubinNo.EMPTY);
//        div.getChosaitakusakiJohoInput().getTxtteiin().setValue(new YubinNo(row.getWaritsukeTeiin() == null
//                ? RString.EMPTY.padRight(RString.HALF_SPACE.toString(), 7).toString() : row.getWaritsukeTeiin().getValue().toString()));
        div.getChosaitakusakiJohoInput().getTxtChiku().setValue(row.getChiku());
        div.getChosaitakusakiJohoInput().getTxtChikuMei().setValue(
                CodeMaster.getCodeMeisho(SubGyomuCode.DBE認定支援, 割付地区名称コード種別, new Code(row.getChiku())));
        div.getChosaitakusakiJohoInput().getRadautowatitsuke().setSelectedValue(row.getAutoWaritsukeFlag());
        if (!RString.isNullOrEmpty(row.getKikanKubun())) {
            div.getChosaitakusakiJohoInput().getDdlKikankubun().setSelectedValue(row.getKikanKubun());
        }
        div.getChosaitakusakiJohoInput().getRadChosainJokyo().setSelectedValue(row.getJokyoFlag());
    }

    private void setChosaitakusakiJohoInputDisabled(Boolean isDisabled) {
        div.getChosaitakusakiJohoInput().getTxtShichoson().setDisabled(isDisabled);
        div.getChosaitakusakiJohoInput().getBtnToSearchShichoson().setDisabled(isDisabled);
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
        div.getChosaitakusakiJohoInput().getBtnToSearchchiku().setDisabled(isDisabled);
        div.getChosaitakusakiJohoInput().getRadautowatitsuke().setDisabled(isDisabled);
        div.getChosaitakusakiJohoInput().getDdlKikankubun().setDisabled(isDisabled);
        div.getChosaitakusakiJohoInput().getRadChosainJokyo().setDisabled(isDisabled);
    }

    private RString getChosaitakusakiJohoInputValue() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(div.getChosaitakusakiJohoInput().getTxtShichoson().getValue() == null
                ? RString.EMPTY : div.getChosaitakusakiJohoInput().getTxtShichoson().getValue());
        builder.append(div.getChosaitakusakiJohoInput().getTxtShichosonmei().getValue() == null
                ? RString.EMPTY : div.getChosaitakusakiJohoInput().getTxtShichosonmei().getValue());
        builder.append(div.getChosaitakusakiJohoInput().getTxtChosaItakusaki().getValue() == null
                ? RString.EMPTY : div.getChosaitakusakiJohoInput().getTxtChosaItakusaki().getValue());
        builder.append(div.getChosaitakusakiJohoInput().getTxtjigyoshano().getValue() == null
                ? RString.EMPTY : div.getChosaitakusakiJohoInput().getTxtjigyoshano().getValue());
        builder.append(div.getChosaitakusakiJohoInput().getTxtChosaitakusakiname().getValue() == null
                ? RString.EMPTY : div.getChosaitakusakiJohoInput().getTxtChosaitakusakiname().getValue());
        builder.append(div.getChosaitakusakiJohoInput().getTxtChosaitakusakiKananame().getValue() == null
                ? RString.EMPTY : div.getChosaitakusakiJohoInput().getTxtChosaitakusakiKananame().getValue());
        builder.append(div.getChosaitakusakiJohoInput().getTxtYubinNo().getValue() == null
                ? RString.EMPTY : div.getChosaitakusakiJohoInput().getTxtYubinNo().getValue().getYubinNo());
        builder.append(div.getChosaitakusakiJohoInput().getTxtJusho().getDomain() == null
                ? RString.EMPTY : div.getChosaitakusakiJohoInput().getTxtJusho().getDomain().getColumnValue());
        builder.append(div.getChosaitakusakiJohoInput().getTxtTelNo().getDomain() == null
                ? RString.EMPTY : div.getChosaitakusakiJohoInput().getTxtTelNo().getDomain().getColumnValue());
        builder.append(div.getChosaitakusakiJohoInput().getTxtFaxNo().getDomain() == null
                ? RString.EMPTY : div.getChosaitakusakiJohoInput().getTxtFaxNo().getDomain().getColumnValue());
        return getInputValue(builder);
    }

    private RString getInputValue(RStringBuilder builder) {
        builder.append(div.getChosaitakusakiJohoInput().getTxtdaihyoshaname().getDomain() == null
                ? RString.EMPTY : div.getChosaitakusakiJohoInput().getTxtdaihyoshaname().getDomain().getColumnValue());
        builder.append(div.getChosaitakusakiJohoInput().getTxtdaihyoshakananame().getDomain() == null
                ? RString.EMPTY : div.getChosaitakusakiJohoInput().getTxtdaihyoshakananame().getDomain().getColumnValue());
        builder.append(RString.isNullOrEmpty(div.getChosaitakusakiJohoInput().getDdlItakusakikubun().getSelectedKey())
                ? RString.EMPTY : div.getChosaitakusakiJohoInput().getDdlItakusakikubun().getSelectedValue());
        builder.append(RString.isNullOrEmpty(div.getChosaitakusakiJohoInput().getDdltokuteichosain().getSelectedKey())
                ? RString.EMPTY : div.getChosaitakusakiJohoInput().getDdltokuteichosain().getSelectedValue());
        builder.append(div.getChosaitakusakiJohoInput().getTxtteiin().getValue() == null
                ? RString.EMPTY : div.getChosaitakusakiJohoInput().getTxtteiin().getValue().getYubinNo());
        builder.append(div.getChosaitakusakiJohoInput().getTxtChiku().getValue() == null
                ? RString.EMPTY : div.getChosaitakusakiJohoInput().getTxtChiku().getValue());
        builder.append(div.getChosaitakusakiJohoInput().getTxtChikuMei().getValue() == null
                ? RString.EMPTY : div.getChosaitakusakiJohoInput().getTxtChikuMei().getValue());
        builder.append(div.getChosaitakusakiJohoInput().getRadautowatitsuke().getSelectedValue() == null
                ? RString.EMPTY : div.getChosaitakusakiJohoInput().getRadautowatitsuke().getSelectedValue());
        builder.append(RString.isNullOrEmpty(div.getChosaitakusakiJohoInput().getDdlKikankubun().getSelectedKey())
                ? RString.EMPTY : div.getChosaitakusakiJohoInput().getDdlKikankubun().getSelectedValue());
        builder.append(div.getChosaitakusakiJohoInput().getRadChosainJokyo().getSelectedValue() == null
                ? RString.EMPTY : div.getChosaitakusakiJohoInput().getRadChosainJokyo().getSelectedValue());
        return builder.toRString();
    }

    private enum ViewStateHolderEnum {

        listHold;

    }
}
