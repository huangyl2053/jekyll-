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

    private static final RString 更新モード = new RString("更新");
    private static final RString 追加モード = new RString("追加");
    private static final RString 削除モード = new RString("削除");
    private static final RString 通常 = new RString("通常");
    private static final RString 削除 = new RString("削除");

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
     *開催場所編集エリア状態を設定します。
     *
     */
    public void set開催場所一覧の追加() {
       clear開催場所編集エリア();
       set開催場所編集エリア活性();
       div.getBtnTsuika().setDisabled(true);
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
     * 新規モード或いは更新モードの場合開催場所編集エリア非活性です。
     *
     */
    public void set新規モード或いは更新モードの場合開催場所編集エリア非活性() {
        dgKaisaibashoIchiran_Row ClickedItem = div.getDgKaisaibashoIchiran().getClickedItem();
        if (!(更新モード.equals(ClickedItem.getJyotai()) || 追加モード.equals(ClickedItem.getJyotai()))) {
            div.getShinakaiKaisaIbashoShosai().getTxtKaisaibashoCode().setValue(ClickedItem.getKaisaibashoCode()); // 開催場所コード
            div.getShinakaiKaisaIbashoShosai().getTxtKaisaibashoMeisho().setValue(ClickedItem.getKaisaibashoMeisho()); // 開催場所名称
            div.getShinakaiKaisaIbashoShosai().getTxtKaisaibashoJusho().setValue(ClickedItem.getKaisaibashoJusho()); // 開催場所住所
            div.getShinakaiKaisaIbashoShosai().getTxtTelNumber().setDomain(new TelNo(ClickedItem.getKaisaibashoTelNo())); // 電話番号
            if (通常.equals(ClickedItem.getKaisaibashoJokyo())) {
                div.getShinakaiKaisaIbashoShosai().getDdlKaisaiBashoJokyo().setSelectedIndex(0); // 開催場所住所状況
            } else if (削除.equals(ClickedItem.getKaisaibashoJokyo())) {
                div.getShinakaiKaisaIbashoShosai().getDdlKaisaiBashoJokyo().setSelectedIndex(1); // 開催場所住所状況
            }
            // 開催地区コード 開催地区内容
            ICodeInputDiv codeInput = div.getShinakaiKaisaIbashoShosai().getCcdKaisaiChikuCode();
            codeInput.load(SubGyomuCode.DBE認定支援,new CodeShubetsu("5001"), new Code(ClickedItem.getKaisaiChikuCode()));
            set開催場所編集エリア非活性();
        }
    }
    
    /**
     * 新規モード或いは更新モードの場合開催場所編集エリア活性です。
     *
     */
    public void set新規モード或いは更新モードの場合開催場所編集エリア活性() {
        dgKaisaibashoIchiran_Row ClickedItem = div.getDgKaisaibashoIchiran().getClickedItem();
        if (!(更新モード.equals(ClickedItem.getJyotai()) || 追加モード.equals(ClickedItem.getJyotai()))) {
            div.getShinakaiKaisaIbashoShosai().getTxtKaisaibashoCode().setValue(ClickedItem.getKaisaibashoCode()); // 開催場所コード
            div.getShinakaiKaisaIbashoShosai().getTxtKaisaibashoMeisho().setValue(ClickedItem.getKaisaibashoMeisho()); // 開催場所名称
            div.getShinakaiKaisaIbashoShosai().getTxtKaisaibashoJusho().setValue(ClickedItem.getKaisaibashoJusho()); // 開催場所住所
            div.getShinakaiKaisaIbashoShosai().getTxtTelNumber().setDomain(new TelNo(ClickedItem.getKaisaibashoTelNo())); // 電話番号
            if (通常.equals(ClickedItem.getKaisaibashoJokyo())) {
                div.getShinakaiKaisaIbashoShosai().getDdlKaisaiBashoJokyo().setSelectedIndex(0); // 開催場所住所状況
            } else if (削除.equals(ClickedItem.getKaisaibashoJokyo())) {
                div.getShinakaiKaisaIbashoShosai().getDdlKaisaiBashoJokyo().setSelectedIndex(1); // 開催場所住所状況
            }
            // 開催地区コード 開催地区内容
            ICodeInputDiv codeInput = div.getShinakaiKaisaIbashoShosai().getCcdKaisaiChikuCode();
            codeInput.load(SubGyomuCode.DBE認定支援,new CodeShubetsu("5001"), new Code(ClickedItem.getKaisaiChikuCode()));
            set開催場所編集エリア活性();
        }
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
        if (追加モード.equals(clickedItem.getJyotai())) {
             clickedItem.setJyotai(追加モード);
             setSelectItem(clickedItem);
             rowList.set(clickedItemId, clickedItem);
        } else if (更新モード.equals(clickedItem.getJyotai()) || clickedItem.getJyotai().isEmpty()) {
             clickedItem.setJyotai(更新モード);
             setSelectItem(clickedItem);
             rowList.set(clickedItemId, clickedItem);
        } else {
            clickedItem.setJyotai(追加モード);
            dgKaisaibashoIchiran_Row clickedItemNew = new dgKaisaibashoIchiran_Row();
            setSelectItem(clickedItemNew);
            rowList.add(clickedItemNew);
        }
        div.getDgKaisaibashoIchiran().setDataSource(rowList);
        div.getBtnTsuika().setDisabled(false);
        clear開催場所編集エリア();
        set開催場所編集エリア非活性();
    }
    
    
    private void setSelectItem(dgKaisaibashoIchiran_Row clickedItem){
        clickedItem.setKaisaibashoCode(div.getShinakaiKaisaIbashoShosai().getTxtKaisaibashoCode().getValue()); //開催場所コード
        clickedItem.setKaisaibashoMeisho(div.getShinakaiKaisaIbashoShosai().getTxtKaisaibashoMeisho().getValue()); //開催場所名称
        clickedItem.setKaisaibashoJusho(div.getShinakaiKaisaIbashoShosai().getTxtKaisaibashoJusho().getValue()); //開催場所住所
        clickedItem.setKaisaibashoTelNo(div.getShinakaiKaisaIbashoShosai().getTxtTelNumber().getDomain().getColumnValue()); //電話番号
        clickedItem.setKaisaibashoJusho(div.getShinakaiKaisaIbashoShosai().getTxtKaisaibashoJusho().getValue()); //開催場所住所
        div.getShinakaiKaisaIbashoShosai().getCcdKaisaiChikuCode().getCode(); // 開催地区コード
        div.getShinakaiKaisaIbashoShosai().getCcdKaisaiChikuCode().getCodeMeisho(); // 開催地区内容
        // 開催場所住所状況
        if (div.getShinakaiKaisaIbashoShosai().getDdlKaisaiBashoJokyo().getSelectedIndex() == 0) {
            clickedItem.setKaisaibashoJokyo(通常);
        } else if (div.getShinakaiKaisaIbashoShosai().getDdlKaisaiBashoJokyo().getSelectedIndex() ==1) {
            clickedItem.setKaisaibashoJokyo(削除);
        }
    }
    
    private void set開催場所編集エリア非活性(){
        div.getShinakaiKaisaIbashoShosai().getTxtKaisaibashoCode().setReadOnly(true); // 開催場所コード
        div.getShinakaiKaisaIbashoShosai().getTxtKaisaibashoMeisho().setReadOnly(true); // 開催場所名称
        div.getShinakaiKaisaIbashoShosai().getTxtKaisaibashoJusho().setReadOnly(true); // 開催場所住所
        div.getShinakaiKaisaIbashoShosai().getTxtTelNumber().setReadOnly(true);  // 電話番号
        div.getShinakaiKaisaIbashoShosai().getDdlKaisaiBashoJokyo().setReadOnly(true); // 開催場所住所状況
        div.getShinakaiKaisaIbashoShosai().getBtnback().setDisabled(true);
        div.getShinakaiKaisaIbashoShosai().getBtnupdate().setDisabled(true);
    }
    
    private void set開催場所編集エリア活性(){
        div.getShinakaiKaisaIbashoShosai().getTxtKaisaibashoCode().setReadOnly(false); // 開催場所コード
        div.getShinakaiKaisaIbashoShosai().getTxtKaisaibashoMeisho().setReadOnly(false); // 開催場所名称
        div.getShinakaiKaisaIbashoShosai().getTxtKaisaibashoJusho().setReadOnly(false); // 開催場所住所
        div.getShinakaiKaisaIbashoShosai().getTxtTelNumber().setReadOnly(false); // 電話番号
        div.getShinakaiKaisaIbashoShosai().getDdlKaisaiBashoJokyo().setReadOnly(false); // 開催場所住所状況
        div.getShinakaiKaisaIbashoShosai().getBtnback().setDisabled(false);
        div.getShinakaiKaisaIbashoShosai().getBtnupdate().setDisabled(false);
    }
    
    private void clear開催場所編集エリア(){
        div.getShinakaiKaisaIbashoShosai().getTxtKaisaibashoCode().clearValue(); // 開催場所コード
        div.getShinakaiKaisaIbashoShosai().getTxtKaisaibashoMeisho().clearValue(); // 開催場所名称
        div.getShinakaiKaisaIbashoShosai().getTxtKaisaibashoJusho().clearValue(); // 開催場所住所
        div.getShinakaiKaisaIbashoShosai().getTxtTelNumber().clearDomain(); // 電話番号
        div.getShinakaiKaisaIbashoShosai().getDdlKaisaiBashoJokyo().setSelectedIndex(0); // 開催場所住所状況
        div.getShinakaiKaisaIbashoShosai().getCcdKaisaiChikuCode().load(new CodeShubetsu("5001"));
        div.getShinakaiKaisaIbashoShosai().getCcdKaisaiChikuCode().clearDisplayedValues();
    }
}
