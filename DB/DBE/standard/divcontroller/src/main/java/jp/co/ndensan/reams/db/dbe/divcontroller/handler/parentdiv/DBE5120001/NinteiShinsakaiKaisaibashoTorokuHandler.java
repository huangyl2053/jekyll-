package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5120001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.shinsakaikaisaibashojoho.ShinsakaiKaisaiBashoJoho;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.shinsakaikaisaibashojoho.ShinsakaiKaisaiBashoJohoBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.shinsakaikaisaibashojoho.ShinsakaiKaisaiBashoJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5120001.NinteiShinsakaiKaisaibashoTorokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5120001.dgKaisaibashoIchiran_Row;
import jp.co.ndensan.reams.db.dbe.service.core.gogitaijoho.shinsakaikaisaibashojoho.ShinsakaiKaisaiBashoJohoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBECodeShubetsu;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.CodeInput.ICodeInputDiv;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridButtonState;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 介護認定審査会開催場所登録画面でのバリデーションを管理するハンドラークラスです。
 *
 * @reamsid_L DBE-0100-010 wangkun
 */
public class NinteiShinsakaiKaisaibashoTorokuHandler {

    private static final RString 更新モード = new RString("修正");
    private static final RString 追加モード = new RString("追加");
    private static final RString 削除モード = new RString("削除");
    private static final RString 通常 = new RString("通常");
    private static final RString 削除 = new RString("削除");
    private static final boolean 有効 = true;
    private static final boolean 全て = false;

    private final NinteiShinsakaiKaisaibashoTorokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 介護認定審査会開催場所情報Div
     */
    public NinteiShinsakaiKaisaibashoTorokuHandler(NinteiShinsakaiKaisaibashoTorokuDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです。
     *
     * @param shinsakaiKaisaiBashoJohoList 介護認定審査会開催場所情報ビジネス
     */
    public void set介護認定審査会開催場所一覧(List<ShinsakaiKaisaiBashoJoho> shinsakaiKaisaiBashoJohoList) {
        List<dgKaisaibashoIchiran_Row> rowList = new ArrayList();
        int i = 0;
        for (ShinsakaiKaisaiBashoJoho shinsakaiKaisaiBashoJoho : shinsakaiKaisaiBashoJohoList) {

            if (i < div.getShinsakaiKaisaibashokensaku().getTxtDispMax().getValue().intValue()) {
                RString 開催地区コード = RString.EMPTY;
                if (shinsakaiKaisaiBashoJoho.get介護認定審査会開催地区コード() != null
                        && !shinsakaiKaisaiBashoJoho.get介護認定審査会開催地区コード().isEmpty()) {
                    開催地区コード = shinsakaiKaisaiBashoJoho.get介護認定審査会開催地区コード().value();
                }

                RString 開催場所電話番号 = RString.EMPTY;
                if (shinsakaiKaisaiBashoJoho.get介護認定審査会開催場所電話番号() != null
                        && !shinsakaiKaisaiBashoJoho.get介護認定審査会開催場所電話番号().isEmpty()) {
                    開催場所電話番号 = shinsakaiKaisaiBashoJoho.get介護認定審査会開催場所電話番号().value();
                }
                dgKaisaibashoIchiran_Row row = new dgKaisaibashoIchiran_Row(RString.EMPTY,
                        shinsakaiKaisaiBashoJoho.get介護認定審査会開催場所コード(),
                        shinsakaiKaisaiBashoJoho.get介護認定審査会開催場所名称(),
                        開催地区コード,
                        shinsakaiKaisaiBashoJoho.get介護認定審査会開催場所住所(),
                        開催場所電話番号,
                        RString.EMPTY);
                if (shinsakaiKaisaiBashoJoho.is介護認定審査会開催場所状況()) {
                    row.setKaisaibashoJokyo(通常);
                } else {
                    row.setKaisaibashoJokyo(削除);
                }
                rowList.add(row);
                i++;
            }
        }
        int listsize = shinsakaiKaisaiBashoJohoList.size();
        div.getDgKaisaibashoIchiran().setDataSource(rowList);
        div.getDgKaisaibashoIchiran().getGridSetting().setLimitRowCount(div.getShinsakaiKaisaibashokensaku().getTxtDispMax().getValue().intValue());
        div.getDgKaisaibashoIchiran().getGridSetting().setSelectedRowCount(listsize);
        clear開催場所編集エリア();
        set開催場所編集エリア非活性();
    }

    /**
     * 開催場所編集エリアを設定します。
     *
     */
    public void set開催場所一覧の追加() {
        clear開催場所編集エリア();
        set開催場所編集エリア活性();
        div.getBtnTsuika().setDisabled(true);
        ICodeInputDiv codeInput = div.getShinakaiKaisaIbashoShosai().getCcdKaisaiChikuCode();
        codeInput.applyNoOptionCodeMaster().load(SubGyomuCode.DBE認定支援, DBECodeShubetsu.審査会地区コード.getコード());
        div.getShinakaiKaisaIbashoShosai().setJyotai(追加モード);
    }

    /**
     * 開催場所一覧の削除を設定しました。
     *
     */
    public void set開催場所一覧の削除() {
        List<dgKaisaibashoIchiran_Row> rowList = div.getDgKaisaibashoIchiran().getDataSource();
        dgKaisaibashoIchiran_Row clickedItem = div.getDgKaisaibashoIchiran().getClickedItem();
        if (削除モード.equals(clickedItem.getJyotai())) {
            clear開催場所編集エリア();
            clickedItem.setJyotai(RString.EMPTY);
            clickedItem.setModifyButtonState(DataGridButtonState.Enabled);
            rowList.set(div.getDgKaisaibashoIchiran().getClickedRowId(), clickedItem);
        } else {
            if (追加モード.equals(clickedItem.getJyotai())) {
                rowList.remove(div.getDgKaisaibashoIchiran().getClickedRowId());
            } else {
                clickedItem.setJyotai(削除);
                clear開催場所編集エリア();
                set開催場所編集エリア非活性();
                clickedItem.setModifyButtonState(DataGridButtonState.Disabled);
                rowList.set(div.getDgKaisaibashoIchiran().getClickedRowId(), clickedItem);
            }
        }
        div.getDgKaisaibashoIchiran().setDataSource(rowList);
    }

    /**
     * 開催場所一覧の参照を設定しました。
     *
     */
    public void set開催場所一覧の参照() {
        dgKaisaibashoIchiran_Row clickedItem = div.getDgKaisaibashoIchiran().getClickedItem();
        if (!(更新モード.equals(div.getShinakaiKaisaIbashoShosai().getJyotai())
                || 追加モード.equals(div.getShinakaiKaisaIbashoShosai().getJyotai()))) {
            setSelectItem(clickedItem);
            set開催場所編集エリア非活性();
        }
    }

    /**
     * 新規モード或いは更新モードの場合開催場所編集エリア活性です。
     *
     */
    public void set修正の場合開催場所編集エリア() {
        div.getShinakaiKaisaIbashoShosai().setJyotai(更新モード);
        dgKaisaibashoIchiran_Row clickedItem = div.getDgKaisaibashoIchiran().getClickedItem();
        RStringBuilder selectedItem = new RStringBuilder(clickedItem.getKaisaibashoCode());
        selectedItem.append(clickedItem.getKaisaibashoMeisho())
                .append(clickedItem.getKaisaibashoJusho())
                .append(clickedItem.getKaisaibashoTelNo())
                .append(clickedItem.getKaisaibashoJokyo())
                .append(clickedItem.getKaisaiChikuCode());
        div.getShinakaiKaisaIbashoShosai().setSelectItem(selectedItem.toRString());
        setSelectItem(clickedItem);
        set開催場所編集エリア活性();
    }

    /**
     * 開催場所編集エリア初期化設定します。
     *
     */
    public void set開催場所編集エリアを初期化処理() {
        clear開催場所編集エリア();
        set開催場所編集エリア非活性();
        div.getBtnTsuika().setDisabled(false);
    }

    /**
     * 開催場所一覧の更新を設定します。
     *
     */
    public void 開催場所一覧の更新() {
        List<dgKaisaibashoIchiran_Row> rowList = div.getDgKaisaibashoIchiran().getDataSource();
        dgKaisaibashoIchiran_Row clickedItem = div.getDgKaisaibashoIchiran().getClickedItem();
        int clickedItemId = div.getDgKaisaibashoIchiran().getClickedRowId();
        RString モード = div.getShinakaiKaisaIbashoShosai().getJyotai();
        if (更新モード.equals(モード) && 追加モード.equals(clickedItem.getJyotai())) {
            clickedItem.setJyotai(追加モード);
            setYiChiRanItem(clickedItem);
            rowList.set(clickedItemId, clickedItem);
        } else if (更新モード.equals(モード)
                && (更新モード.equals(clickedItem.getJyotai()) || clickedItem.getJyotai().isEmpty())) {
            clickedItem.setJyotai(更新モード);
            setYiChiRanItem(clickedItem);
            rowList.set(clickedItemId, clickedItem);
        } else if (追加モード.equals(モード)) {
            dgKaisaibashoIchiran_Row clickedItemNew = new dgKaisaibashoIchiran_Row();
            clickedItemNew.setJyotai(追加モード);
            setYiChiRanItem(clickedItemNew);
            rowList.add(clickedItemNew);
        }
        div.getDgKaisaibashoIchiran().setDataSource(rowList);
        clear開催場所編集エリア();
        set開催場所編集エリア非活性();
    }

    /**
     * 介護認定審査会開催場所登録の「保存する」ボタンが押下の場合、状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param shinsakaiKaisaiBashoJohoList shinsakaiKaisaiBashoJohoList
     */
    public void save(Models<ShinsakaiKaisaiBashoJohoIdentifier, ShinsakaiKaisaiBashoJoho> shinsakaiKaisaiBashoJohoList) {
        List<dgKaisaibashoIchiran_Row> rowList = div.getDgKaisaibashoIchiran().getDataSource();
        ShinsakaiKaisaiBashoJohoManager manager = ShinsakaiKaisaiBashoJohoManager.createInstance();
        for (dgKaisaibashoIchiran_Row row : rowList) {
            for (ShinsakaiKaisaiBashoJoho shinsakaiKaisaiBashoJoho : shinsakaiKaisaiBashoJohoList) {
                if (shinsakaiKaisaiBashoJoho.identifier().get介護認定審査会開催場所コード()
                        .equals(row.getKaisaibashoCode())) {
                    shinsakaiKaisaiBashoJoho = edit介護認定審査会開催場所情報(row, shinsakaiKaisaiBashoJoho);
                    if (更新モード.equals(row.getJyotai())) {
                        manager.介護認定審査会開催場所情報の更新(shinsakaiKaisaiBashoJoho);
                        break;
                    } else if (削除モード.equals(row.getJyotai())) {
                        manager.介護認定審査会開催場所情報の削除(shinsakaiKaisaiBashoJoho);
                        break;
                    }
                }
            }
            if (追加モード.equals(row.getJyotai())) {
                manager.介護認定審査会開催場所情報の追加(edit介護認定審査会開催場所情報(row,
                        new ShinsakaiKaisaiBashoJoho(row.getKaisaibashoCode())));
            }
        }
    }

    private ShinsakaiKaisaiBashoJoho edit介護認定審査会開催場所情報(dgKaisaibashoIchiran_Row row,
            ShinsakaiKaisaiBashoJoho shinsakaiKaisaiBashoJoho) {
        ShinsakaiKaisaiBashoJohoBuilder builder = shinsakaiKaisaiBashoJoho.createBuilderForEdit();
        builder.set介護認定審査会開催地区コード(new Code(row.getKaisaiChikuCode()));
        builder.set介護認定審査会開催場所住所(row.getKaisaibashoJusho());
        builder.set介護認定審査会開催場所名称(row.getKaisaibashoMeisho());
        builder.set介護認定審査会開催場所電話番号(new TelNo(row.getKaisaibashoTelNo()));
        if (通常.equals(row.getKaisaibashoJokyo())) {
            builder.set介護認定審査会開催場所状況(有効);
        } else if (削除.equals(row.getKaisaibashoJokyo())) {
            builder.set介護認定審査会開催場所状況(全て);
        }
        return builder.build();
    }

    private void setYiChiRanItem(dgKaisaibashoIchiran_Row clickedItem) {
        clickedItem.setKaisaibashoCode(div.getTxtKaisaibashoCode().getValue());
        clickedItem.setKaisaibashoMeisho(div.getTxtKaisaibashoMeisho().getValue());
        clickedItem.setKaisaibashoJusho(div.getTxtKaisaibashoJusho().getValue());
        clickedItem.setKaisaibashoTelNo(div.getTxtTelNumber().getDomain().getColumnValue());
        clickedItem.setKaisaibashoJusho(div.getTxtKaisaibashoJusho().getValue());
        clickedItem.setKaisaiChikuCode(div.getCcdKaisaiChikuCode().getCode().getColumnValue());
        if (div.getDdlKaisaiBashoJokyo().getSelectedIndex() == 0) {
            clickedItem.setKaisaibashoJokyo(通常);
        } else if (div.getDdlKaisaiBashoJokyo().getSelectedIndex() == 1) {
            clickedItem.setKaisaibashoJokyo(削除);
        }
    }

    private void setSelectItem(dgKaisaibashoIchiran_Row clickedItem) {
        div.getTxtKaisaibashoCode().setValue(RString.isNullOrEmpty(clickedItem.getKaisaibashoCode()) ? RString.EMPTY : clickedItem.getKaisaibashoCode());
        div.getTxtKaisaibashoMeisho().setValue(RString.isNullOrEmpty(clickedItem.getKaisaibashoMeisho()) ? RString.EMPTY : clickedItem.getKaisaibashoMeisho());
        div.getTxtKaisaibashoJusho().setValue(RString.isNullOrEmpty(clickedItem.getKaisaibashoJusho()) ? RString.EMPTY : clickedItem.getKaisaibashoJusho());
        div.getTxtTelNumber().setDomain(new TelNo(RString.isNullOrEmpty(clickedItem.getKaisaibashoTelNo()) ? RString.EMPTY : clickedItem.getKaisaibashoTelNo()));
//        div.getTxtKaisaibashoJusho().setValue(clickedItem.getKaisaibashoJusho());
        if (通常.equals(clickedItem.getKaisaibashoJokyo())) {
            div.getDdlKaisaiBashoJokyo().setSelectedIndex(0);
        } else if (削除.equals(clickedItem.getKaisaibashoJokyo())) {
            div.getDdlKaisaiBashoJokyo().setSelectedIndex(1);
        }
        get開催地区内容(clickedItem);
    }

    private void set開催場所編集エリア非活性() {
        div.getTxtKaisaibashoCode().setReadOnly(true);
        div.getTxtKaisaibashoMeisho().setReadOnly(true);
        div.getTxtKaisaibashoJusho().setReadOnly(true);
        div.getTxtTelNumber().setReadOnly(true);
        div.getDdlKaisaiBashoJokyo().setReadOnly(true);
        div.getCcdKaisaiChikuCode().setReadOnly(true);
        div.getBtnback().setDisabled(true);
        div.getBtnupdate().setDisabled(true);
        div.getBtnTsuika().setDisabled(true);
    }

    private void set開催場所編集エリア活性() {
        div.getTxtKaisaibashoCode().setReadOnly(false);
        div.getTxtKaisaibashoMeisho().setReadOnly(false);
        div.getTxtKaisaibashoJusho().setReadOnly(false);
        div.getTxtTelNumber().setReadOnly(false);
        div.getDdlKaisaiBashoJokyo().setReadOnly(false);
        div.getCcdKaisaiChikuCode().setReadOnly(false);
        div.getBtnback().setDisabled(false);
        div.getBtnupdate().setDisabled(false);
        div.getBtnTsuika().setDisabled(false);
    }

    private void clear開催場所編集エリア() {
        div.getShinakaiKaisaIbashoShosai().setJyotai(RString.EMPTY);
        div.getTxtKaisaibashoCode().clearValue();
        div.getTxtKaisaibashoMeisho().clearValue();
        div.getTxtKaisaibashoJusho().clearValue();
        div.getTxtTelNumber().clearDomain();
        div.getDdlKaisaiBashoJokyo().setSelectedIndex(0);
        div.getCcdKaisaiChikuCode().clearDisplayedValues();
        div.getCcdKaisaiChikuCode().applyNoOptionCodeMaster().load(DBECodeShubetsu.審査会地区コード.getコード());
    }

    private void get開催地区内容(dgKaisaibashoIchiran_Row clickedItem) {
        ICodeInputDiv codeInput = div.getShinakaiKaisaIbashoShosai().getCcdKaisaiChikuCode();
        codeInput.applyNoOptionCodeMaster()
                .load(SubGyomuCode.DBE認定支援, DBECodeShubetsu.審査会地区コード.getコード(), new Code(clickedItem.getKaisaiChikuCode()));
    }
}
