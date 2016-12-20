/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ShobyoIken.ShobyoIken;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.geninshikkan.GeninShikkan;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.geninshikkan.GeninShikkanBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.geninshikkan.GeninShikkanIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.ninteishinseijoho.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshoiraijoho.ShujiiIkenshoIraiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshoiraijoho.ShujiiIkenshoIraiJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshojoho.ShujiiIkenshoJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshojoho.ShujiiIkenshoJohoBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshojoho.ShujiiIkenshoJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.service.core.shobyoiken.ShobyoIkenFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBECodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.Anteisei;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 傷病の意見入力のHandlerクラスです。
 *
 * @reamsid_L DBE-3000-130 zhengshukai
 */
public class ShobyoIkenHandler {

    private final ShobyoIkenDiv div;
    private static final RString 追加 = new RString("追加");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 安定性_True = new RString("True");
    private static final RString 安定性_False = new RString("False");

    /**
     * コンストラクタです。
     *
     * @param div ShobyoIkenDiv
     */
    public ShobyoIkenHandler(ShobyoIkenDiv div) {
        this.div = div;
    }

    /**
     * 画面の初期化を設定する。 geninShikkanShosai
     */
    public void initialize() {
        初期化();
        NinteiShinseiJoho 意見書情報 = ViewStateHolder.get(ViewStateKeys.意見書情報, NinteiShinseiJoho.class);
        ShinseishoKanriNo 管理番号 = new ShinseishoKanriNo(ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class));
        int 履歴番号 = Integer.valueOf(ViewStateHolder.get(ViewStateKeys.主治医意見書作成依頼履歴番号, RString.class).toString());

        if (意見書情報 != null) {
            if (!意見書情報.getShujiiIkenshoIraiJoho(new ShujiiIkenshoIraiJohoIdentifier(管理番号, 履歴番号)).
                    getShujiiIkenshoJohoList().isEmpty()) {
                ShujiiIkenshoJoho 要介護認定主治医意見書情報 = 意見書情報.
                        getShujiiIkenshoIraiJoho(new ShujiiIkenshoIraiJohoIdentifier(管理番号, 履歴番号)).
                        getSeishinTechoNini(new ShujiiIkenshoJohoIdentifier(管理番号, 履歴番号));
                div.getTxtShindanName1().setValue(要介護認定主治医意見書情報.get意見書_診断名1());
                if (要介護認定主治医意見書情報.get意見書_発症年月日1() != null && !要介護認定主治医意見書情報.get意見書_発症年月日1().isEmpty()) {
                    div.getTxtShindanYMD1().setValue(new RDate(要介護認定主治医意見書情報.get意見書_発症年月日1().toString()));
                }
                div.getTxtShindanName2().setValue(要介護認定主治医意見書情報.get意見書_診断名2());
                if (要介護認定主治医意見書情報.get意見書_発症年月日2() != null && !要介護認定主治医意見書情報.get意見書_発症年月日2().isEmpty()) {
                    div.getTxtShindanYMD2().setValue(new RDate(要介護認定主治医意見書情報.get意見書_発症年月日2().toString()));
                }
                div.getTxtShindanName().setValue(要介護認定主治医意見書情報.get意見書_診断名3());
                if (要介護認定主治医意見書情報.get意見書_発症年月日3() != null && !要介護認定主治医意見書情報.get意見書_発症年月日3().isEmpty()) {
                    div.getTxtShindanYMD3().setValue(new RDate(要介護認定主治医意見書情報.get意見書_発症年月日3().toString()));
                }
                div.setName1(要介護認定主治医意見書情報.get意見書_診断名1());
                div.setYMD1(要介護認定主治医意見書情報.get意見書_発症年月日1());
                div.setName2(要介護認定主治医意見書情報.get意見書_診断名2());
                div.setYMD2(要介護認定主治医意見書情報.get意見書_発症年月日2());
                div.setName3(要介護認定主治医意見書情報.get意見書_診断名3());
                div.setYMD3(要介護認定主治医意見書情報.get意見書_発症年月日3());
                原因疾患一覧を設定(意見書情報);
                症状としての安定性エリアを設定(要介護認定主治医意見書情報);
                div.getSeikatsuKinoGenin().getTxtNaiyo().setValue(要介護認定主治医意見書情報.get治療内容());
                div.setNaiyo(要介護認定主治医意見書情報.get治療内容());
            }
        }
    }

    private void 初期化() {
        div.getTxtShindanName1().setValue(RString.EMPTY);
        div.getTxtShindanName2().setValue(RString.EMPTY);
        div.getTxtShindanName().setValue(RString.EMPTY);
        div.setName1(RString.EMPTY);
        div.setYMD1(RString.EMPTY);
        div.setName2(RString.EMPTY);
        div.setYMD2(RString.EMPTY);
        div.setName3(RString.EMPTY);
        div.setYMD3(RString.EMPTY);
        div.getGeninShikkanShosai().setVisible(false);
        List<KeyValueDataSource> 症状安定性 = new ArrayList<>();
        for (Anteisei 安定性 : Anteisei.values()) {
            KeyValueDataSource datasource = new KeyValueDataSource();
            datasource.setKey(安定性.getコード());
            datasource.setValue(安定性.get名称());
            症状安定性.add(datasource);
        }
        div.getRadShojoAnteisei().setDataSource(症状安定性);
        div.getRadShojoAnteisei().setSelectedKey(new RString("3"));
        div.getTxtFuanteiShosaiJokyo().setDisabled(true);
        div.getTxtFuanteiShosaiJokyo().setValue(RString.EMPTY);
        div.getShojoAnteisei().setRadantei(new RString("3"));
        div.getShojoAnteisei().setFuantei(RString.EMPTY);
    }

    private void 原因疾患一覧を設定(NinteiShinseiJoho 意見書情報) {
        List<dgGenyin_Row> 原因疾患一覧 = new ArrayList<>();
        for (GeninShikkan 原因疾患 : 意見書情報.getGeninShikkanList()) {
            dgGenyin_Row dgGenyin_row = new dgGenyin_Row();
            TextBoxCode 原因疾患コード = new TextBoxCode();
            原因疾患コード.setValue(原因疾患.get原因疾患コード().getColumnValue());
            dgGenyin_row.setGeninShikkanCode(原因疾患コード);
            dgGenyin_row.setMeiSho(CodeMaster.getCodeMeisho(SubGyomuCode.DBE認定支援, DBECodeShubetsu.原因疾患コード.getコード(), 原因疾患.get原因疾患コード()));
            if (原因疾患.is主たる原因疾患フラグ()) {
                dgGenyin_row.setIsShutaruGeninShikkan(Boolean.TRUE);
            } else {
                dgGenyin_row.setIsShutaruGeninShikkan(Boolean.FALSE);
            }
            dgGenyin_row.getRenBan().setValue(new Decimal(原因疾患.identifier().get連番()));
            原因疾患一覧.add(dgGenyin_row);
        }
        div.getDgGenyin().setDataSource(原因疾患一覧);
        div.getGeninShikkanShosai().getCcdCodeInputGeninShikkan().setDisabled(true);
        div.getGeninShikkanShosai().setVisible(false);
    }

    private void 症状としての安定性エリアを設定(ShujiiIkenshoJoho 要介護認定主治医意見書情報) {
        if (要介護認定主治医意見書情報.get意見書_症状としての安定性() != null
                && !要介護認定主治医意見書情報.get意見書_症状としての安定性().trim().isEmpty()) {
            div.getRadShojoAnteisei().setSelectedKey(要介護認定主治医意見書情報.get意見書_症状としての安定性());
            div.getShojoAnteisei().setRadantei(要介護認定主治医意見書情報.get意見書_症状としての安定性());
            if (div.getRadShojoAnteisei().getSelectedKey().equals(Anteisei.不安定.getコード())) {
                div.getTxtFuanteiShosaiJokyo().setDisabled(false);
            }
        }
        if (要介護認定主治医意見書情報.get意見書_症状としての安定性_不安定状況() != null
                && !要介護認定主治医意見書情報.get意見書_症状としての安定性_不安定状況().isEmpty()) {
            div.getTxtFuanteiShosaiJokyo().setValue(要介護認定主治医意見書情報.get意見書_症状としての安定性_不安定状況());
            div.getShojoAnteisei().setFuantei(要介護認定主治医意見書情報.get意見書_症状としての安定性_不安定状況());
        }
    }

    /**
     * 「原因疾患を追加する」を押下の処理です。
     *
     */
    public void onClick_tsuika() {
        div.getGeninShikkanShosai().setVisible(true);
        div.getGeninShikkanShosai().getCcdCodeInputGeninShikkan().setDisabled(false);
        div.getGeninShikkanShosai().getCcdCodeInputGeninShikkan().clearDisplayedValues();
        div.getRadIsShutaruGeninShikkan().setDisabled(false);
        div.getCcdCodeInputGeninShikkan().applyNoOptionCodeMaster().load(SubGyomuCode.DBE認定支援,
                DBECodeShubetsu.原因疾患コード.getコード());
        div.getGeninShikkanPanel().getGeninShikkanShosai().setJotai(追加);
    }

    /**
     * 「原因疾患一覧 修正　アイコン」を押下の処理です。
     *
     */
    public void onClick_syusei() {
        div.getGeninShikkanShosai().setVisible(true);
        div.getGeninShikkanShosai().getCcdCodeInputGeninShikkan().setDisabled(false);
        div.getRadIsShutaruGeninShikkan().setDisabled(false);
        div.getBtnNo().setDisabled(false);
        div.getBtnOK().setDisabled(false);
        dgGenyin_Row row = div.getDgGenyin().getClickedItem();
        div.getCcdCodeInputGeninShikkan().applyNoOptionCodeMaster().load(SubGyomuCode.DBE認定支援,
                DBECodeShubetsu.原因疾患コード.getコード(), new Code(row.getGeninShikkanCode().getValue()));
        if (row.getIsShutaruGeninShikkan()) {
            div.getRadIsShutaruGeninShikkan().setSelectedKey(安定性_True);
        } else {
            div.getRadIsShutaruGeninShikkan().setSelectedKey(安定性_False);
        }
        div.getGeninShikkanPanel().getGeninShikkanShosai().setShikkanCode(row.getGeninShikkanCode().getValue());
        div.getGeninShikkanPanel().getGeninShikkanShosai().setMeisho(row.getMeiSho());
        if (row.getIsShutaruGeninShikkan()) {
            div.getGeninShikkanPanel().getGeninShikkanShosai().setIsShutaru(安定性_True);
        } else {
            div.getGeninShikkanPanel().getGeninShikkanShosai().setIsShutaru(安定性_False);
        }
        div.getGeninShikkanPanel().getGeninShikkanShosai().setJotai(修正);
    }

    /**
     * 「原因疾患一覧 削除　アイコン」を押下の処理です。
     *
     */
    public void onClick_sakujyo() {
        div.getGeninShikkanShosai().setVisible(true);
        div.getGeninShikkanShosai().getCcdCodeInputGeninShikkan().setDisabled(true);
        div.getRadIsShutaruGeninShikkan().setDisabled(true);
        div.getBtnNo().setDisabled(false);
        div.getBtnOK().setDisabled(false);
        dgGenyin_Row row = div.getDgGenyin().getClickedItem();
        div.getCcdCodeInputGeninShikkan().applyNoOptionCodeMaster().load(SubGyomuCode.DBE認定支援, DBECodeShubetsu.原因疾患コード.getコード(),
                new Code(row.getGeninShikkanCode().getValue()));
        if (row.getIsShutaruGeninShikkan()) {
            div.getRadIsShutaruGeninShikkan().setSelectedKey(安定性_True);
        } else {
            div.getRadIsShutaruGeninShikkan().setSelectedKey(安定性_False);
        }
        div.getGeninShikkanPanel().getGeninShikkanShosai().setJotai(削除);
    }

    private void 追加状態() {
        div.getGeninShikkanShosai().setVisible(true);
        div.getGeninShikkanShosai().getCcdCodeInputGeninShikkan().setDisabled(false);
        dgGenyin_Row row = div.getDgGenyin().getClickedItem();
        div.getGeninShikkanPanel().getGeninShikkanShosai().setShikkanCode(row.getGeninShikkanCode().getValue());
        div.getGeninShikkanPanel().getGeninShikkanShosai().setMeisho(row.getMeiSho());
        if (row.getIsShutaruGeninShikkan()) {
            div.getGeninShikkanPanel().getGeninShikkanShosai().setIsShutaru(安定性_True);
        } else {
            div.getGeninShikkanPanel().getGeninShikkanShosai().setIsShutaru(安定性_False);
        }
        div.getGeninShikkanPanel().getGeninShikkanShosai().setJotai(追加);

    }

    private void 空白状態() {
        div.getGeninShikkanPanel().getGeninShikkanShosai().setVisible(true);
        div.getGeninShikkanShosai().getCcdCodeInputGeninShikkan().setDisabled(true);
        div.getRadIsShutaruGeninShikkan().setRequired(true);
        div.getBtnNo().setDisabled(true);
        div.getBtnOK().setDisabled(true);
        dgGenyin_Row row = div.getDgGenyin().getClickedItem();
        div.getCcdCodeInputGeninShikkan().applyNoOptionCodeMaster().load(SubGyomuCode.DBE認定支援, DBECodeShubetsu.原因疾患コード.getコード(),
                new Code(row.getGeninShikkanCode().getValue()));
        if (row.getIsShutaruGeninShikkan()) {
            div.getRadIsShutaruGeninShikkan().setSelectedKey(安定性_True);
        } else {
            div.getRadIsShutaruGeninShikkan().setSelectedKey(安定性_False);
        }
        div.getGeninShikkanPanel().getGeninShikkanShosai().setShikkanCode(row.getGeninShikkanCode().getValue());
        div.getGeninShikkanPanel().getGeninShikkanShosai().setMeisho(row.getMeiSho());
        if (row.getIsShutaruGeninShikkan()) {
            div.getGeninShikkanPanel().getGeninShikkanShosai().setIsShutaru(安定性_True);
        } else {
            div.getGeninShikkanPanel().getGeninShikkanShosai().setIsShutaru(安定性_False);
        }
        div.getGeninShikkanPanel().getGeninShikkanShosai().setJotai(RString.EMPTY);
    }

    /**
     * 原因疾患一覧 行ダブルクリック押下します。
     *
     */
    public void onClick_double() {
        dgGenyin_Row row = div.getDgGenyin().getSelectedItems().get(0);
        if (追加.equals(row.getJotai())) {
            追加状態();
        }
        if (修正.equals(row.getJotai())) {
            onClick_syusei();
        }
        if (削除.equals(row.getJotai())) {
            onClick_sakujyo();
        }
        if (RString.EMPTY.equals(row.getJotai())) {
            空白状態();
        }
    }

    /**
     * 原因疾患詳細エリア、編集チェックです。
     *
     * @return 編集チェック結果
     */
    public boolean 一覧編集がある() {
        if (!div.getCcdCodeInputGeninShikkan().getCode().getColumnValue().equals(div.getGeninShikkanShosai().getShikkanCode())) {
            return true;
        }
        return !div.getRadIsShutaruGeninShikkan().getSelectedKey().equals(div.getGeninShikkanShosai().getIsShutaru());
    }

    /**
     * 原因疾患詳細エリア 取消する　ボタン押下します。
     */
    public void clearValue() {
        div.getGeninShikkanPanel().getGeninShikkanShosai().setVisible(false);
    }

    /**
     * 原因疾患詳細エリア 確定する　ボタン押下します。
     *
     */
    public void onClick_btnOK() {
        List<dgGenyin_Row> rowlist = div.getDgGenyin().getDataSource();
        int rowcount = 0;
        if (!追加.equals(div.getGeninShikkanShosai().getJotai())) {
            rowcount = div.getDgGenyin().getClickedItem().getId();
        }
        dgGenyin_Row row;
        if (追加.equals(div.getGeninShikkanShosai().getJotai())) {
            row = new dgGenyin_Row();
            row.setJotai(追加);
            TextBoxCode 原因疾患コード = new TextBoxCode();
            原因疾患コード.setValue(div.getCcdCodeInputGeninShikkan().getCode().getColumnValue());
            row.setGeninShikkanCode(原因疾患コード);
            row.setMeiSho(div.getCcdCodeInputGeninShikkan().getCodeMeisho());
            if (安定性_True.equals(div.getRadIsShutaruGeninShikkan().getSelectedKey())) {
                row.setIsShutaruGeninShikkan(Boolean.TRUE);
            } else {
                row.setIsShutaruGeninShikkan(Boolean.FALSE);
            }
            rowlist.add(row);
            clearValue();
        }
        if (修正.equals(div.getGeninShikkanShosai().getJotai())) {
            row = rowlist.get(rowcount);
            TextBoxCode 原因疾患コード = new TextBoxCode();
            原因疾患コード.setValue(div.getCcdCodeInputGeninShikkan().getCode().getColumnValue());
            row.setGeninShikkanCode(原因疾患コード);
            row.setMeiSho(div.getCcdCodeInputGeninShikkan().getCodeMeisho());
            if (安定性_True.equals(div.getRadIsShutaruGeninShikkan().getSelectedKey())) {
                row.setIsShutaruGeninShikkan(Boolean.TRUE);
            } else {
                row.setIsShutaruGeninShikkan(Boolean.FALSE);
            }
            if (追加.equals(row.getJotai())) {
                row.setJotai(追加);
            } else {
                row.setJotai(修正);
            }
            rowlist.set(rowcount, row);
            clearValue();
        }
        if (削除.equals(div.getGeninShikkanShosai().getJotai())) {
            row = rowlist.get(rowcount);
            if (追加.equals(row.getJotai())) {
                rowlist.remove(rowcount);
            } else {
                row.setJotai(削除);
                rowlist.set(rowcount, row);
            }
            clearValue();
        }
    }

    /**
     * 画面の編集チェックです。
     *
     * @return 編集チェック結果
     */
    public boolean 編集がある() {
        if (!div.getTxtShindanName1().getValue().equals(div.getName1())) {
            return true;
        }
        if ((div.getTxtShindanYMD1().getValue() == null && !RString.isNullOrEmpty(div.getYMD1()))
                || (div.getTxtShindanYMD1().getValue() != null && !div.getTxtShindanYMD1().getValue().toDateString().equals(div.getYMD1()))) {
            return true;
        }
        if (!div.getTxtShindanName2().getValue().equals(div.getName2())) {
            return true;
        }
        if ((div.getTxtShindanYMD2().getValue() == null && !RString.isNullOrEmpty(div.getYMD2()))
                || (div.getTxtShindanYMD2().getValue() != null && !div.getTxtShindanYMD2().getValue().toDateString().equals(div.getYMD2()))) {
            return true;
        }
        if (!div.getTxtShindanName().getValue().equals(div.getName3())) {
            return true;
        }
        if ((div.getTxtShindanYMD3().getValue() == null && !RString.isNullOrEmpty(div.getYMD3()))
                || (div.getTxtShindanYMD3().getValue() != null && !div.getTxtShindanYMD3().getValue().toDateString().equals(div.getYMD3()))) {
            return true;
        }
        List<dgGenyin_Row> rowlist = div.getDgGenyin().getDataSource();
        for (dgGenyin_Row row : rowlist) {
            if (!RString.EMPTY.equals(row.getJotai())) {
                return true;
            }
        }
        if (!div.getRadShojoAnteisei().getSelectedKey().equals(div.getShojoAnteisei().getRadantei())) {
            return true;
        }
        if (!div.getTxtFuanteiShosaiJokyo().getValue().equals(div.getShojoAnteisei().getFuantei())) {
            return true;
        }
        return !div.getTxtNaiyo().getValue().equals(div.getNaiyo());
    }

    /**
     * 記載する項目を呼び出し元画面に戻す。
     */
    public void 呼び出し元画面への戻り値() {
        NinteiShinseiJoho 主治医意見書登録_意見書情報 = ViewStateHolder.get(ViewStateKeys.意見書情報, NinteiShinseiJoho.class);
        ShinseishoKanriNo 管理番号 = new ShinseishoKanriNo(ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class));
        int 履歴番号 = Integer.valueOf(ViewStateHolder.get(ViewStateKeys.主治医意見書作成依頼履歴番号, RString.class).toString());

        if (主治医意見書登録_意見書情報 != null) {
            if (!主治医意見書登録_意見書情報.getShujiiIkenshoIraiJoho(new ShujiiIkenshoIraiJohoIdentifier(管理番号, 履歴番号)).
                    getShujiiIkenshoJohoList().isEmpty()) {
                ShujiiIkenshoJoho 要介護認定主治医意見書情報 = 主治医意見書登録_意見書情報.
                        getShujiiIkenshoIraiJoho(new ShujiiIkenshoIraiJohoIdentifier(管理番号, 履歴番号)).
                        getSeishinTechoNini(new ShujiiIkenshoJohoIdentifier(管理番号, 履歴番号));
                ShujiiIkenshoIraiJoho 主治医意見書作成依頼情報 = 要介護認定主治医意見書情報に関する情報(主治医意見書登録_意見書情報,
                        管理番号, 履歴番号, 要介護認定主治医意見書情報);
                主治医意見書登録_意見書情報 = 主治医意見書登録_意見書情報.createBuilderForEdit().
                        setShujiiIkenshoIraiJoho(主治医意見書作成依頼情報).build();
            } else {
                ShujiiIkenshoJoho 要介護認定主治医意見書情報 = new ShujiiIkenshoJoho(管理番号, 履歴番号);
                ShujiiIkenshoIraiJoho 主治医意見書作成依頼情報 = 要介護認定主治医意見書情報に関する情報(主治医意見書登録_意見書情報,
                        管理番号, 履歴番号, 要介護認定主治医意見書情報);
                主治医意見書登録_意見書情報 = 主治医意見書登録_意見書情報.createBuilderForEdit().
                        setShujiiIkenshoIraiJoho(主治医意見書作成依頼情報).build();
            }
            主治医意見書登録_意見書情報 = 原因疾患に関する情報(主治医意見書登録_意見書情報, 管理番号);
            主治医意見書登録_意見書情報 = 主治医意見書登録_意見書情報.createBuilderForEdit().
                    set厚労省IF識別コード(new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build();
            ViewStateHolder.put(ViewStateKeys.意見書情報, 主治医意見書登録_意見書情報);
        } else {
            NinteiShinseiJoho 意見書情報2 = new NinteiShinseiJoho(管理番号);
            ShujiiIkenshoJoho 要介護認定主治医意見書情報 = new ShujiiIkenshoJoho(管理番号, 履歴番号);
            ShujiiIkenshoIraiJoho 主治医意見書作成依頼情報 = 要介護認定主治医意見書情報に関する情報2(管理番号, 履歴番号, 要介護認定主治医意見書情報);
            意見書情報2 = 意見書情報2.createBuilderForEdit().setShujiiIkenshoIraiJoho(主治医意見書作成依頼情報).build();
            意見書情報2 = 原因疾患に関する情報(意見書情報2, 管理番号);
            意見書情報2 = 意見書情報2.createBuilderForEdit().
                    set厚労省IF識別コード(new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build();
            ViewStateHolder.put(ViewStateKeys.意見書情報, 意見書情報2);
        }
    }

    private ShujiiIkenshoIraiJoho 要介護認定主治医意見書情報に関する情報(NinteiShinseiJoho 主治医意見書登録_意見書情報,
            ShinseishoKanriNo 管理番号, int 履歴番号, ShujiiIkenshoJoho 要介護認定主治医意見書情報) {
        ShujiiIkenshoJohoBuilder 要介護認定主治医builder = 要介護認定主治医意見書情報.createBuilderForEdit();
        要介護認定主治医builder.set意見書_診断名1(div.getTxtShindanName1().getValue());
        if (div.getTxtShindanYMD1().getValue() != null) {
            要介護認定主治医builder.set意見書_発症年月日1(div.getTxtShindanYMD1().getValue().toDateString());
        } else {
            要介護認定主治医builder.set意見書_発症年月日1(RString.EMPTY);
        }
        要介護認定主治医builder.set意見書_診断名2(div.getTxtShindanName2().getValue());
        if (div.getTxtShindanYMD2().getValue() != null) {
            要介護認定主治医builder.set意見書_発症年月日2(div.getTxtShindanYMD2().getValue().toDateString());
        } else {
            要介護認定主治医builder.set意見書_発症年月日2(RString.EMPTY);
        }
        要介護認定主治医builder.set意見書_診断名3(div.getTxtShindanName().getValue());
        if (div.getTxtShindanYMD3().getValue() != null) {
            要介護認定主治医builder.set意見書_発症年月日3(div.getTxtShindanYMD3().getValue().toDateString());
        } else {
            要介護認定主治医builder.set意見書_発症年月日3(RString.EMPTY);
        }
        要介護認定主治医builder.set意見書_症状としての安定性(div.getRadShojoAnteisei().getSelectedKey());
        要介護認定主治医builder.set意見書_症状としての安定性_不安定状況(div.getTxtFuanteiShosaiJokyo().getValue());
        要介護認定主治医builder.set治療内容(div.getTxtNaiyo().getValue());
        要介護認定主治医意見書情報 = 要介護認定主治医builder.build().modifiedModel();
        ShujiiIkenshoIraiJoho 主治医意見書作成依頼情報 = 主治医意見書登録_意見書情報.
                getShujiiIkenshoIraiJoho(new ShujiiIkenshoIraiJohoIdentifier(管理番号, 履歴番号));
        主治医意見書作成依頼情報 = 主治医意見書作成依頼情報.createBuilderForEdit().setShujiiIkenshoJoho(要介護認定主治医意見書情報).build();
        return 主治医意見書作成依頼情報;
    }

    private ShujiiIkenshoIraiJoho 要介護認定主治医意見書情報に関する情報2(ShinseishoKanriNo 管理番号, int 履歴番号,
            ShujiiIkenshoJoho 要介護認定主治医意見書情報) {
        ShujiiIkenshoJohoBuilder 要介護認定主治医builder = 要介護認定主治医意見書情報.createBuilderForEdit();
        要介護認定主治医builder.set意見書_診断名1(div.getTxtShindanName1().getValue());
        if (div.getTxtShindanYMD1().getValue() != null) {
            要介護認定主治医builder.set意見書_発症年月日1(div.getTxtShindanYMD1().getValue().toDateString());
        }
        要介護認定主治医builder.set意見書_診断名2(div.getTxtShindanName2().getValue());
        if (div.getTxtShindanYMD2().getValue() != null) {
            要介護認定主治医builder.set意見書_発症年月日2(div.getTxtShindanYMD2().getValue().toDateString());
        }
        要介護認定主治医builder.set意見書_診断名3(div.getTxtShindanName().getValue());
        if (div.getTxtShindanYMD3().getValue() != null) {
            要介護認定主治医builder.set意見書_発症年月日3(div.getTxtShindanYMD3().getValue().toDateString());
        }
        要介護認定主治医builder.set意見書_症状としての安定性(div.getRadShojoAnteisei().getSelectedKey());
        要介護認定主治医builder.set意見書_症状としての安定性_不安定状況(div.getTxtFuanteiShosaiJokyo().getValue());
        要介護認定主治医builder.set治療内容(div.getTxtNaiyo().getValue());
        要介護認定主治医意見書情報 = 要介護認定主治医builder.build().modifiedModel();
        ShujiiIkenshoIraiJoho 主治医意見書作成依頼情報 = new ShujiiIkenshoIraiJoho(管理番号, 履歴番号);
        主治医意見書作成依頼情報 = 主治医意見書作成依頼情報.createBuilderForEdit().setShujiiIkenshoJoho(要介護認定主治医意見書情報).build();
        return 主治医意見書作成依頼情報;
    }

    private NinteiShinseiJoho 原因疾患に関する情報(NinteiShinseiJoho 意見書情報, ShinseishoKanriNo 管理番号) {
        List<dgGenyin_Row> rowlist = div.getDgGenyin().getDataSource();
        for (dgGenyin_Row row : rowlist) {
            if (修正.equals(row.getJotai())) {
                GeninShikkan 原因疾患 = 意見書情報.getGeninShikkan(new GeninShikkanIdentifier(管理番号, row.getRenBan().getValue().intValue()));
                GeninShikkanBuilder builder = 原因疾患.createBuilderForEdit();
                builder.set原因疾患コード(new Code(row.getGeninShikkanCode().getValue()));
                builder.set主たる原因疾患フラグ(false);
                if (row.getIsShutaruGeninShikkan()) {
                    builder.set主たる原因疾患フラグ(true);
                } else {
                    builder.set主たる原因疾患フラグ(false);
                }
                原因疾患 = builder.build().modifiedModel();
                意見書情報 = 意見書情報.createBuilderForEdit().setGeninShikkan(原因疾患).build();
            }
            if (追加.equals(row.getJotai())) {
                GeninShikkan geninShikkan = new GeninShikkan(管理番号, get連番(管理番号));
                GeninShikkanBuilder builder2 = geninShikkan.createBuilderForEdit();
                builder2.set原因疾患コード(new Code(row.getGeninShikkanCode().getValue()));
                if (row.getIsShutaruGeninShikkan()) {
                    builder2.set主たる原因疾患フラグ(true);
                } else {
                    builder2.set主たる原因疾患フラグ(false);
                }
                geninShikkan = builder2.build();
                意見書情報 = 意見書情報.createBuilderForEdit().setGeninShikkan(geninShikkan).build();
            }

            if (削除.equals(row.getJotai())) {
                GeninShikkan 原因疾患 = 意見書情報.getGeninShikkan(new GeninShikkanIdentifier(管理番号, row.getRenBan().getValue().intValue()));
                GeninShikkanBuilder builder = 原因疾患.createBuilderForEdit();
                builder.set原因疾患コード(new Code(row.getGeninShikkanCode().getValue()));
                builder.set主たる原因疾患フラグ(false);
                if (row.getIsShutaruGeninShikkan()) {
                    builder.set主たる原因疾患フラグ(true);
                } else {
                    builder.set主たる原因疾患フラグ(false);
                }
                原因疾患 = builder.build().deleted();
                意見書情報 = 意見書情報.createBuilderForEdit().setGeninShikkan(原因疾患).build();
            }
        }
        return 意見書情報;
    }

    private int get連番(ShinseishoKanriNo 管理番号) {
        return ShobyoIkenFinder.createInstance().get連番(管理番号);
    }
}
