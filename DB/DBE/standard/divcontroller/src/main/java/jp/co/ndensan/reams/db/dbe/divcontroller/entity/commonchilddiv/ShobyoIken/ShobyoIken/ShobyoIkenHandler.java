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
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.ninteishinseijoho.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshoiraijoho.ShujiiIkenshoIraiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshoiraijoho.ShujiiIkenshoIraiJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshojoho.ShujiiIkenshoJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshojoho.ShujiiIkenshoJohoBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshojoho.ShujiiIkenshoJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.Anteisei;
import jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 *
 * 傷病の意見入力のHandlerクラスです。
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
        NinteiShinseiJoho 意見書情報 = ViewStateHolder.get(ViewStateKeys.主治医意見書登録_意見書情報, NinteiShinseiJoho.class);
        ShinseishoKanriNo 管理番号 = new ShinseishoKanriNo(ViewStateHolder.get(ViewStateKeys.要介護認定申請検索_申請書管理番号, RString.class));
        int 履歴番号 = Integer.valueOf(ViewStateHolder.get(ViewStateKeys.要介護認定申請検索_主治医意見書作成依頼履歴番号, RString.class).toString());
        if (意見書情報 != null && new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード()).equals(意見書情報.get厚労省IF識別コード())
                && 意見書情報.getShujiiIkenshoIraiJoho(new ShujiiIkenshoIraiJohoIdentifier(管理番号, 履歴番号)) != null
                && 意見書情報.getShujiiIkenshoIraiJoho(new ShujiiIkenshoIraiJohoIdentifier(管理番号, 履歴番号)).
                getSeishinTechoNini(new ShujiiIkenshoJohoIdentifier(管理番号, 履歴番号)) != null) {
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
            div.getTxtShindanName3().setValue(要介護認定主治医意見書情報.get意見書_診断名3());
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

    private void 初期化() {
        div.getTxtShindanName1().setValue(RString.EMPTY);
        div.getTxtShindanName2().setValue(RString.EMPTY);
        div.getTxtShindanName3().setValue(RString.EMPTY);
        div.setName1(RString.EMPTY);
        div.setYMD1(RString.EMPTY);
        div.setName2(RString.EMPTY);
        div.setYMD2(RString.EMPTY);
        div.setName3(RString.EMPTY);
        div.setYMD3(RString.EMPTY);
        div.getGeninShikkanPanel().getGeninShikkanShosai().setVisible(false);
        List<KeyValueDataSource> 症状安定性 = new ArrayList<>();
        for (Anteisei 安定性 : Anteisei.values()) {
            KeyValueDataSource datasource = new KeyValueDataSource();
            datasource.setKey(安定性.getコード());
            datasource.setValue(安定性.get名称());
            症状安定性.add(datasource);
        }
        div.getShojoAnteisei().getRadShojoAnteisei().setDataSource(症状安定性);
        div.getShojoAnteisei().getRadShojoAnteisei().setSelectedKey(new RString("3"));
        div.getShojoAnteisei().getTxtFuanteiShosaiJokyo().setReadOnly(true);
        div.getShojoAnteisei().getTxtFuanteiShosaiJokyo().setValue(RString.EMPTY);
        div.setRadantei(new RString("3"));
        div.setFuantei(RString.EMPTY);

    }

    private void 原因疾患一覧を設定(NinteiShinseiJoho 意見書情報) {
        List<dgGenyin_Row> 原因疾患一覧 = new ArrayList<>();
        int index = 1;
        for (GeninShikkan 原因疾患 : 意見書情報.getGeninShikkanList()) {
            dgGenyin_Row dgGenyin_row = new dgGenyin_Row();
            dgGenyin_row.getGeninShikkanCode().setValue(new RString(原因疾患.get原因疾患コード().toString()));
            dgGenyin_row.setMeiSho(CodeMaster.getCodeMeisho(SubGyomuCode.DBE認定支援, new CodeShubetsu("5003"), 原因疾患.get原因疾患コード()));
            if (原因疾患.get主たる原因疾患フラグ()) {
                dgGenyin_row.setIsShutaruGeninShikkan(Boolean.TRUE);
            } else {
                dgGenyin_row.setIsShutaruGeninShikkan(Boolean.FALSE);
            }
            dgGenyin_row.getRenBan().setValue(new Decimal(index));
            index++;
            原因疾患一覧.add(dgGenyin_row);
        }
        div.getGeninShikkanPanel().getDgGenyin().setDataSource(原因疾患一覧);
        div.getGeninShikkanPanel().getGeninShikkanShosai().getTxtGeninShikkanCode().setDisabled(true);
        div.getGeninShikkanPanel().getGeninShikkanShosai().getTxtMeisho().setDisabled(true);
    }

    private void 症状としての安定性エリアを設定(ShujiiIkenshoJoho 要介護認定主治医意見書情報) {
        if (要介護認定主治医意見書情報.get意見書_症状としての安定性() != null && !要介護認定主治医意見書情報.get意見書_症状としての安定性().isEmpty()) {
            div.getShojoAnteisei().getRadShojoAnteisei().setSelectedKey(要介護認定主治医意見書情報.get意見書_症状としての安定性());
            div.setRadantei(要介護認定主治医意見書情報.get意見書_症状としての安定性());
        }
        div.getShojoAnteisei().getTxtFuanteiShosaiJokyo().setDisabled(true);
        if (要介護認定主治医意見書情報.get意見書_症状としての安定性_不安定状況() != null
                && !要介護認定主治医意見書情報.get意見書_症状としての安定性_不安定状況().isEmpty()) {
            div.getShojoAnteisei().getTxtFuanteiShosaiJokyo().setValue(要介護認定主治医意見書情報.get意見書_症状としての安定性_不安定状況());
            div.setFuantei(要介護認定主治医意見書情報.get意見書_症状としての安定性_不安定状況());
        }
    }

    /**
     * 「原因疾患を追加する」を押下の処理です。
     *
     */
    public void onClick_tsuika() {
        div.getGeninShikkanPanel().getGeninShikkanShosai().setVisible(true);
        div.getGeninShikkanPanel().getGeninShikkanShosai().getTxtGeninShikkanCode().setDisabled(true);
        div.getGeninShikkanPanel().getGeninShikkanShosai().getTxtMeisho().setDisabled(true);
        div.getGeninShikkanPanel().getGeninShikkanShosai().getBtnToSearch().setDisabled(false);
        div.getGeninShikkanPanel().getGeninShikkanShosai().getRadIsShutaruGeninShikkan().setRequired(false);
        div.getGeninShikkanPanel().getGeninShikkanShosai().setJotai(追加);
    }

    /**
     * 「原因疾患一覧 修正　アイコン」を押下の処理です。
     *
     */
    public void onClick_syusei() {
        div.getGeninShikkanPanel().getGeninShikkanShosai().setVisible(true);
        div.getGeninShikkanPanel().getGeninShikkanShosai().getTxtGeninShikkanCode().setDisabled(true);
        div.getGeninShikkanPanel().getGeninShikkanShosai().getTxtMeisho().setDisabled(true);
        div.getGeninShikkanPanel().getGeninShikkanShosai().getBtnToSearch().setDisabled(false);
        div.getGeninShikkanPanel().getGeninShikkanShosai().getRadIsShutaruGeninShikkan().setRequired(false);
        dgGenyin_Row row = div.getGeninShikkanPanel().getDgGenyin().getClickedItem();
        div.getGeninShikkanPanel().getGeninShikkanShosai().getTxtGeninShikkanCode().setValue(row.getGeninShikkanCode().getValue());
        div.getGeninShikkanPanel().getGeninShikkanShosai().getTxtMeisho().setValue(row.getMeiSho());
        if (row.getIsShutaruGeninShikkan()) {
            div.getGeninShikkanPanel().getGeninShikkanShosai().getRadIsShutaruGeninShikkan().setSelectedKey(安定性_True);
        } else {
            div.getGeninShikkanPanel().getGeninShikkanShosai().getRadIsShutaruGeninShikkan().setSelectedKey(安定性_False);
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
        div.getGeninShikkanPanel().getGeninShikkanShosai().setVisible(true);
        div.getGeninShikkanPanel().getGeninShikkanShosai().getBtnToSearch().setDisabled(true);
        div.getGeninShikkanPanel().getGeninShikkanShosai().getRadIsShutaruGeninShikkan().setRequired(true);
        dgGenyin_Row row = div.getGeninShikkanPanel().getDgGenyin().getClickedItem();
        div.getGeninShikkanPanel().getGeninShikkanShosai().getTxtGeninShikkanCode().setValue(row.getGeninShikkanCode().getValue());
        div.getGeninShikkanPanel().getGeninShikkanShosai().getTxtMeisho().setValue(row.getMeiSho());
        if (row.getIsShutaruGeninShikkan()) {
            div.getGeninShikkanPanel().getGeninShikkanShosai().getRadIsShutaruGeninShikkan().setSelectedKey(安定性_True);
        } else {
            div.getGeninShikkanPanel().getGeninShikkanShosai().getRadIsShutaruGeninShikkan().setSelectedKey(安定性_False);
        }
        div.getGeninShikkanPanel().getGeninShikkanShosai().setJotai(削除);
    }

    private void 追加状態() {
        div.getGeninShikkanPanel().getGeninShikkanShosai().setVisible(true);
        div.getGeninShikkanPanel().getGeninShikkanShosai().getTxtGeninShikkanCode().setDisabled(true);
        div.getGeninShikkanPanel().getGeninShikkanShosai().getTxtMeisho().setDisabled(true);
        dgGenyin_Row row = div.getGeninShikkanPanel().getDgGenyin().getClickedItem();
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
        div.getGeninShikkanPanel().getGeninShikkanShosai().getTxtGeninShikkanCode().setDisabled(true);
        div.getGeninShikkanPanel().getGeninShikkanShosai().getBtnToSearch().setDisabled(true);
        div.getGeninShikkanPanel().getGeninShikkanShosai().getTxtMeisho().setDisabled(true);
        div.getGeninShikkanPanel().getGeninShikkanShosai().getRadIsShutaruGeninShikkan().setRequired(true);
        div.getGeninShikkanPanel().getGeninShikkanShosai().getBtnNo().setDisabled(true);
        div.getGeninShikkanPanel().getGeninShikkanShosai().getBtnOK().setDisabled(true);
        div.getGeninShikkanPanel().getGeninShikkanShosai().setJotai(RString.EMPTY);
    }

    /**
     * 原因疾患一覧 行ダブルクリック押下します。
     *
     */
    public void onClick_double() {
        dgGenyin_Row row = div.getGeninShikkanPanel().getDgGenyin().getSelectedItems().get(0);
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
        if (div.getGeninShikkanPanel().getGeninShikkanShosai().getTxtGeninShikkanCode().getValue().
                equals(div.getGeninShikkanPanel().getGeninShikkanShosai().getShikkanCode())) {
            return true;
        }
        if (div.getGeninShikkanPanel().getGeninShikkanShosai().getTxtMeisho().getValue().
                equals(div.getGeninShikkanPanel().getGeninShikkanShosai().getMeisho())) {
            return true;
        }
        if (div.getGeninShikkanPanel().getGeninShikkanShosai().getRadIsShutaruGeninShikkan().getSelectedKey().
                equals(div.getGeninShikkanPanel().getGeninShikkanShosai().getIsShutaru())) {
            return true;
        }
        return false;
    }

    /**
     * 原因疾患詳細エリア 取消する　ボタン押下します。
     */
    public void clearValue() {
        div.getGeninShikkanPanel().getGeninShikkanShosai().getTxtGeninShikkanCode().clearValue();
        div.getGeninShikkanPanel().getGeninShikkanShosai().getTxtMeisho().clearValue();
        div.getGeninShikkanPanel().getGeninShikkanShosai().setIsShutaru(安定性_False);
        div.getGeninShikkanPanel().getGeninShikkanShosai().setShikkanCode(RString.EMPTY);
        div.getGeninShikkanPanel().getGeninShikkanShosai().setMeisho(RString.EMPTY);
        div.getGeninShikkanPanel().getGeninShikkanShosai().setIsShutaru(RString.EMPTY);
        div.getGeninShikkanPanel().getGeninShikkanShosai().setVisible(false);
    }

    /**
     * 原因疾患詳細エリア 確定する　ボタン押下します。
     *
     */
    public void onClick_btnOK() {
        List<dgGenyin_Row> rowlist = div.getGeninShikkanPanel().getDgGenyin().getDataSource();
        int rowcount = 0;
        if (!追加.equals(div.getGeninShikkanPanel().getGeninShikkanShosai().getJotai())) {
            rowcount = div.getGeninShikkanPanel().getDgGenyin().getClickedItem().getId();
        }
        dgGenyin_Row row;
        if (追加.equals(div.getGeninShikkanPanel().getGeninShikkanShosai().getJotai())) {
            row = new dgGenyin_Row();
            row.setJotai(追加);
            row.setGeninShikkanCode(div.getGeninShikkanPanel().getGeninShikkanShosai().getTxtGeninShikkanCode());
            row.setMeiSho(div.getGeninShikkanPanel().getGeninShikkanShosai().getTxtMeisho().getValue());
            if (安定性_True.equals(div.getGeninShikkanPanel().getGeninShikkanShosai().getRadIsShutaruGeninShikkan().getSelectedKey())) {
                row.setIsShutaruGeninShikkan(Boolean.TRUE);
            } else {
                row.setIsShutaruGeninShikkan(Boolean.FALSE);
            }
            rowlist.add(row);
            clearValue();
        }
        if (修正.equals(div.getGeninShikkanPanel().getGeninShikkanShosai().getJotai())) {
            row = rowlist.get(rowcount);
            row.setGeninShikkanCode(div.getGeninShikkanPanel().getGeninShikkanShosai().getTxtGeninShikkanCode());
            row.setMeiSho(div.getGeninShikkanPanel().getGeninShikkanShosai().getTxtMeisho().getValue());
            if (安定性_True.equals(div.getGeninShikkanPanel().getGeninShikkanShosai().getRadIsShutaruGeninShikkan().getSelectedKey())) {
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
        if (削除.equals(div.getGeninShikkanPanel().getGeninShikkanShosai().getJotai())) {
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
        if (div.getTxtShindanYMD1().getValue() != null && !div.getTxtShindanYMD1().getValue().toDateString().equals(div.getYMD1())) {
            return true;
        }
        if (!div.getTxtShindanName2().getValue().equals(div.getName2())) {
            return true;
        }
        if (div.getTxtShindanYMD2().getValue() != null && !div.getTxtShindanYMD2().getValue().toDateString().equals(div.getYMD2())) {
            return true;
        }
        if (!div.getTxtShindanName3().getValue().equals(div.getName3())) {
            return true;
        }
        if (div.getTxtShindanYMD3().getValue() != null && !div.getTxtShindanYMD3().getValue().toDateString().equals(div.getYMD3())) {
            return true;
        }
        List<dgGenyin_Row> rowlist = div.getGeninShikkanPanel().getDgGenyin().getDataSource();
        for (dgGenyin_Row row : rowlist) {
            if (RString.EMPTY.equals(row.getJotai())) {
                return true;
            }
        }
        if (!div.getShojoAnteisei().getRadShojoAnteisei().getSelectedKey().equals(div.getRadantei())) {
            return true;
        }
        if (!div.getShojoAnteisei().getTxtFuanteiShosaiJokyo().getValue().equals(div.getFuantei())) {
            return true;
        }
        return !div.getTxtNaiyo().getValue().equals(div.getNaiyo());
    }

    /**
     * 記載する項目を呼び出し元画面に戻す。
     */
    public void 呼び出し元画面への戻り値() {
        NinteiShinseiJoho 主治医意見書登録_意見書情報 = ViewStateHolder.get(ViewStateKeys.主治医意見書登録_意見書情報, NinteiShinseiJoho.class);
        ShinseishoKanriNo 管理番号 = new ShinseishoKanriNo(ViewStateHolder.get(ViewStateKeys.要介護認定申請検索_申請書管理番号, RString.class));
        int 履歴番号 = Integer.valueOf(ViewStateHolder.get(ViewStateKeys.要介護認定申請検索_主治医意見書作成依頼履歴番号, RString.class).toString());
        if (主治医意見書登録_意見書情報 != null && new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード()).equals(主治医意見書登録_意見書情報.
                get厚労省IF識別コード())) {
            if (主治医意見書登録_意見書情報.getShujiiIkenshoIraiJoho(new ShujiiIkenshoIraiJohoIdentifier(管理番号, 履歴番号)) != null) {
                if (主治医意見書登録_意見書情報.getShujiiIkenshoIraiJoho(new ShujiiIkenshoIraiJohoIdentifier(管理番号, 履歴番号)).
                        getSeishinTechoNini(new ShujiiIkenshoJohoIdentifier(管理番号, 履歴番号)) != null) {
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
            } else {
                ShujiiIkenshoJoho 要介護認定主治医意見書情報 = new ShujiiIkenshoJoho(管理番号, 履歴番号);
                ShujiiIkenshoIraiJoho 主治医意見書作成依頼情報 = 要介護認定主治医意見書情報に関する情報2(管理番号, 履歴番号,
                        要介護認定主治医意見書情報);
                主治医意見書登録_意見書情報 = 主治医意見書登録_意見書情報.createBuilderForEdit().
                        setShujiiIkenshoIraiJoho(主治医意見書作成依頼情報).build();
            }
            for (GeninShikkan geninShikkan : 原因疾患に関する情報(主治医意見書登録_意見書情報, 管理番号)) {
                主治医意見書登録_意見書情報 = 主治医意見書登録_意見書情報.createBuilderForEdit().setGeninShikkan(geninShikkan).build();
            }
            主治医意見書登録_意見書情報 = 主治医意見書登録_意見書情報.createBuilderForEdit().
                    set厚労省IF識別コード(new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build();
            ViewStateHolder.put(ViewStateKeys.主治医意見書登録_意見書情報, 主治医意見書登録_意見書情報);
        } else {
            NinteiShinseiJoho 意見書情報2 = new NinteiShinseiJoho(管理番号);
            ShujiiIkenshoJoho 要介護認定主治医意見書情報 = new ShujiiIkenshoJoho(管理番号, 履歴番号);
            ShujiiIkenshoIraiJoho 主治医意見書作成依頼情報 = 要介護認定主治医意見書情報に関する情報2(管理番号, 履歴番号, 要介護認定主治医意見書情報);
            意見書情報2 = 意見書情報2.createBuilderForEdit().setShujiiIkenshoIraiJoho(主治医意見書作成依頼情報).build();
            for (GeninShikkan geninShikkan : 原因疾患に関する情報(意見書情報2, 管理番号)) {
                意見書情報2 = 意見書情報2.createBuilderForEdit().setGeninShikkan(geninShikkan).build();
            }
            意見書情報2 = 意見書情報2.createBuilderForEdit().
                    set厚労省IF識別コード(new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build();
            ViewStateHolder.put(ViewStateKeys.主治医意見書登録_意見書情報, 意見書情報2);
        }
    }

    private ShujiiIkenshoIraiJoho 要介護認定主治医意見書情報に関する情報(NinteiShinseiJoho 主治医意見書登録_意見書情報,
            ShinseishoKanriNo 管理番号, int 履歴番号, ShujiiIkenshoJoho 要介護認定主治医意見書情報) {
        ShujiiIkenshoJohoBuilder 要介護認定主治医builder = 要介護認定主治医意見書情報.createBuilderForEdit();
        要介護認定主治医builder.set意見書_診断名1(div.getTxtShindanName1().getValue());
        if (div.getTxtShindanYMD1().getValue() != null) {
            要介護認定主治医builder.set意見書_発症年月日1(div.getTxtShindanYMD1().getValue().toDateString());
        }
        要介護認定主治医builder.set意見書_診断名2(div.getTxtShindanName2().getValue());
        if (div.getTxtShindanYMD2().getValue() != null) {
            要介護認定主治医builder.set意見書_発症年月日2(div.getTxtShindanYMD2().getValue().toDateString());
        }
        要介護認定主治医builder.set意見書_診断名3(div.getTxtShindanName3().getValue());
        if (div.getTxtShindanYMD3().getValue() != null) {
            要介護認定主治医builder.set意見書_発症年月日3(div.getTxtShindanYMD3().getValue().toDateString());
        }
        要介護認定主治医builder.set意見書_症状としての安定性(div.getShojoAnteisei().getRadShojoAnteisei().getSelectedKey());
        要介護認定主治医builder.set意見書_症状としての安定性_不安定状況(div.getShojoAnteisei().getTxtFuanteiShosaiJokyo().getValue());
        要介護認定主治医builder.set治療内容(div.getSeikatsuKinoGenin().getTxtNaiyo().getValue());
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
        要介護認定主治医builder.set意見書_診断名3(div.getTxtShindanName3().getValue());
        if (div.getTxtShindanYMD3().getValue() != null) {
            要介護認定主治医builder.set意見書_発症年月日3(div.getTxtShindanYMD3().getValue().toDateString());
        }
        要介護認定主治医builder.set意見書_症状としての安定性(div.getShojoAnteisei().getRadShojoAnteisei().getSelectedKey());
        要介護認定主治医builder.set意見書_症状としての安定性_不安定状況(div.getShojoAnteisei().getTxtFuanteiShosaiJokyo().getValue());
        要介護認定主治医builder.set治療内容(div.getSeikatsuKinoGenin().getTxtNaiyo().getValue());
        要介護認定主治医意見書情報 = 要介護認定主治医builder.build().modifiedModel();
        ShujiiIkenshoIraiJoho 主治医意見書作成依頼情報 = new ShujiiIkenshoIraiJoho(管理番号, 履歴番号);
        主治医意見書作成依頼情報 = 主治医意見書作成依頼情報.createBuilderForEdit().setShujiiIkenshoJoho(要介護認定主治医意見書情報).build();
        return 主治医意見書作成依頼情報;
    }

    private List<GeninShikkan> 原因疾患に関する情報(NinteiShinseiJoho 意見書情報, ShinseishoKanriNo 管理番号) {
        List<GeninShikkan> 原因疾患リスト = 意見書情報.getGeninShikkanList();
        List<GeninShikkan> list = new ArrayList<>();
        List<dgGenyin_Row> rowlist = div.getGeninShikkanPanel().getDgGenyin().getDataSource();
        for (dgGenyin_Row row : rowlist) {
            if (原因疾患リスト != null && !原因疾患リスト.isEmpty()) {
                for (GeninShikkan 原因疾患 : 原因疾患リスト) {
                    GeninShikkan geninShikkan = new GeninShikkan(原因疾患.identifier().get申請書管理番号(), 原因疾患.identifier().get連番());
                    if (修正.equals(row.getJotai())) {
                        GeninShikkanBuilder builder = geninShikkan.createBuilderForEdit();
                        if (row.getRenBan().getValue().intValue() == 原因疾患.identifier().get連番()
                                && 管理番号.equals(原因疾患.identifier().get申請書管理番号())) {
                            builder.set原因疾患コード(new Code(row.getGeninShikkanCode().getValue()));
                            builder.set主たる原因疾患フラグ(false);
                            if (row.getIsShutaruGeninShikkan()) {
                                builder.set主たる原因疾患フラグ(true);
                            }
                            geninShikkan = builder.build().modifiedModel();
                            list.add(geninShikkan);
                        }
                    }
                    if (追加.equals(row.getJotai())) {
                        GeninShikkan 原因疾患2 = new GeninShikkan(管理番号, row.getRenBan().getValue().intValue());
                        GeninShikkanBuilder builder2 = 原因疾患2.createBuilderForEdit();
                        builder2.set原因疾患コード(new Code(row.getGeninShikkanCode().getValue()));
                        if (row.getIsShutaruGeninShikkan()) {
                            builder2.set主たる原因疾患フラグ(true);
                        } else {
                            builder2.set主たる原因疾患フラグ(false);
                        }
                        原因疾患2 = builder2.build().modifiedModel();
                        list.add(原因疾患2);
                    }
                }
            } else {
                GeninShikkan 原因疾患2 = new GeninShikkan(管理番号, row.getRenBan().getValue().intValue());
                GeninShikkanBuilder builder2 = 原因疾患2.createBuilderForEdit();
                builder2.set原因疾患コード(new Code(row.getGeninShikkanCode().getValue()));
                if (row.getIsShutaruGeninShikkan()) {
                    builder2.set主たる原因疾患フラグ(true);
                } else {
                    builder2.set主たる原因疾患フラグ(false);
                }
                原因疾患2 = builder2.build().modifiedModel();
                list.add(原因疾患2);
            }
        }
        return list;
    }

}
