package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5120001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.shinsakaikaisaibashojoho.ShinsakaiKaisaiBashoJoho;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5120001.NinteiShinsakaiKaisaibashoTorokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5120001.dgKaisaibashoIchiran_Row;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.CodeInput.ICodeInputDiv;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会開催場所登録画面でのバリデーションを管理するハンドラークラスです。
 *
 */
public class NinteiShinsakaiKaisaibashoTorokuHandler {

    public static final RString 更新モード = new RString("修正");
    public static final RString 追加モード = new RString("追加");
    public static final RString 削除モード = new RString("削除");
    public static final RString 通常 = new RString("通常");
    public static final RString 削除 = new RString("削除");
    public static final RString デフォルト検索条件 = new RString("yuuKo");
    public static final CodeShubetsu コード種別 = new CodeShubetsu("5001");
    public static final boolean 有効 = true;
    public static final boolean 全て = false;

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
        for (ShinsakaiKaisaiBashoJoho shinsakaiKaisaiBashoJoho : shinsakaiKaisaiBashoJohoList) {
            dgKaisaibashoIchiran_Row row = new dgKaisaibashoIchiran_Row(RString.EMPTY,
                    shinsakaiKaisaiBashoJoho.get介護認定審査会開催場所コード(),
                    shinsakaiKaisaiBashoJoho.get介護認定審査会開催場所名称(),
                    shinsakaiKaisaiBashoJoho.get介護認定審査会開催地区コード().value(),
                    shinsakaiKaisaiBashoJoho.get介護認定審査会開催場所住所(),
                    shinsakaiKaisaiBashoJoho.get介護認定審査会開催場所電話番号().value(),
                    RString.EMPTY);
            if (shinsakaiKaisaiBashoJoho.get介護認定審査会開催場所状況()) {
                row.setKaisaibashoJokyo(通常);
            } else {
                row.setKaisaibashoJokyo(削除);
            }
            rowList.add(row);
        }
        div.getDgKaisaibashoIchiran().setDataSource(rowList);
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
        div.getShinakaiKaisaIbashoShosai().setJyotai(追加モード);
    }

    /**
     * 開催場所一覧の削除を設定しました。
     *
     */
    public void set開催場所一覧の削除() {
        List<dgKaisaibashoIchiran_Row> rowList = div.getDgKaisaibashoIchiran().getDataSource();
        dgKaisaibashoIchiran_Row clickedItem = div.getDgKaisaibashoIchiran().getClickedItem();
        if (追加モード.equals(clickedItem.getJyotai())) {
            rowList.remove(div.getDgKaisaibashoIchiran().getClickedRowId());
        } else {
            clickedItem.setJyotai(削除);
            rowList.set(div.getDgKaisaibashoIchiran().getClickedRowId(), clickedItem);
        }
        div.getDgKaisaibashoIchiran().setDataSource(rowList);
    }

    /**
     * 開催場所一覧の参照を設定しました。
     *
     */
    public void set開催場所一覧の参照() {
        dgKaisaibashoIchiran_Row ClickedItem = div.getDgKaisaibashoIchiran().getClickedItem();
        if (!(更新モード.equals(ClickedItem.getJyotai()) || 追加モード.equals(ClickedItem.getJyotai()))) {
            setSelectItem(ClickedItem);
            set開催場所編集エリア非活性();
        }
    }

    /**
     * 新規モード或いは更新モードの場合開催場所編集エリア活性です。
     *
     */
    public void set修正の場合開催場所編集エリア() {
        div.getShinakaiKaisaIbashoShosai().setJyotai(更新モード);
        dgKaisaibashoIchiran_Row ClickedItem = div.getDgKaisaibashoIchiran().getClickedItem();
        setSelectItem(ClickedItem);
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
        div.getTxtKaisaibashoCode().setValue(clickedItem.getKaisaibashoCode());
        div.getTxtKaisaibashoMeisho().setValue(clickedItem.getKaisaibashoMeisho());
        div.getTxtKaisaibashoJusho().setValue(clickedItem.getKaisaibashoJusho());
        div.getTxtTelNumber().setDomain(new TelNo(clickedItem.getKaisaibashoTelNo()));
        div.getTxtKaisaibashoJusho().setValue(clickedItem.getKaisaibashoJusho());
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
        div.getCcdKaisaiChikuCode().load(コード種別);
        div.getCcdKaisaiChikuCode().clearDisplayedValues();
    }

    private void get開催地区内容(dgKaisaibashoIchiran_Row clickedItem) {
        ICodeInputDiv codeInput = div.getShinakaiKaisaIbashoShosai().getCcdKaisaiChikuCode();
        codeInput.load(SubGyomuCode.DBE認定支援, コード種別, new Code(clickedItem.getKaisaiChikuCode()));
    }
}
