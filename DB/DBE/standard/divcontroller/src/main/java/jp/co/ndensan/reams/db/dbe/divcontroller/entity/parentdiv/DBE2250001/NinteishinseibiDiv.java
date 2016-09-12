package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2250001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Ninteishinseibi のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteishinseibiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtNinteishinseibi")
    private TextBoxDateRange txtNinteishinseibi;
    @JsonProperty("txtiraibi")
    private TextBoxDateRange txtiraibi;
    @JsonProperty("txtMaxKensu")
    private TextBoxNum txtMaxKensu;
    @JsonProperty("btnKensaku")
    private Button btnKensaku;
    @JsonProperty("btnKensakuClear")
    private Button btnKensakuClear;
    @JsonProperty("NinteiIchiran")
    private NinteiIchiranDiv NinteiIchiran;
    @JsonProperty("ccdKanryoMessage")
    private KaigoKanryoMessageDiv ccdKanryoMessage;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtNinteishinseibi
     * @return txtNinteishinseibi
     */
    @JsonProperty("txtNinteishinseibi")
    public TextBoxDateRange getTxtNinteishinseibi() {
        return txtNinteishinseibi;
    }

    /*
     * settxtNinteishinseibi
     * @param txtNinteishinseibi txtNinteishinseibi
     */
    @JsonProperty("txtNinteishinseibi")
    public void setTxtNinteishinseibi(TextBoxDateRange txtNinteishinseibi) {
        this.txtNinteishinseibi = txtNinteishinseibi;
    }

    /*
     * gettxtiraibi
     * @return txtiraibi
     */
    @JsonProperty("txtiraibi")
    public TextBoxDateRange getTxtiraibi() {
        return txtiraibi;
    }

    /*
     * settxtiraibi
     * @param txtiraibi txtiraibi
     */
    @JsonProperty("txtiraibi")
    public void setTxtiraibi(TextBoxDateRange txtiraibi) {
        this.txtiraibi = txtiraibi;
    }

    /*
     * gettxtMaxKensu
     * @return txtMaxKensu
     */
    @JsonProperty("txtMaxKensu")
    public TextBoxNum getTxtMaxKensu() {
        return txtMaxKensu;
    }

    /*
     * settxtMaxKensu
     * @param txtMaxKensu txtMaxKensu
     */
    @JsonProperty("txtMaxKensu")
    public void setTxtMaxKensu(TextBoxNum txtMaxKensu) {
        this.txtMaxKensu = txtMaxKensu;
    }

    /*
     * getbtnKensaku
     * @return btnKensaku
     */
    @JsonProperty("btnKensaku")
    public Button getBtnKensaku() {
        return btnKensaku;
    }

    /*
     * setbtnKensaku
     * @param btnKensaku btnKensaku
     */
    @JsonProperty("btnKensaku")
    public void setBtnKensaku(Button btnKensaku) {
        this.btnKensaku = btnKensaku;
    }

    /*
     * getbtnKensakuClear
     * @return btnKensakuClear
     */
    @JsonProperty("btnKensakuClear")
    public Button getBtnKensakuClear() {
        return btnKensakuClear;
    }

    /*
     * setbtnKensakuClear
     * @param btnKensakuClear btnKensakuClear
     */
    @JsonProperty("btnKensakuClear")
    public void setBtnKensakuClear(Button btnKensakuClear) {
        this.btnKensakuClear = btnKensakuClear;
    }

    /*
     * getNinteiIchiran
     * @return NinteiIchiran
     */
    @JsonProperty("NinteiIchiran")
    public NinteiIchiranDiv getNinteiIchiran() {
        return NinteiIchiran;
    }

    /*
     * setNinteiIchiran
     * @param NinteiIchiran NinteiIchiran
     */
    @JsonProperty("NinteiIchiran")
    public void setNinteiIchiran(NinteiIchiranDiv NinteiIchiran) {
        this.NinteiIchiran = NinteiIchiran;
    }

    /*
     * getccdKanryoMessage
     * @return ccdKanryoMessage
     */
    @JsonProperty("ccdKanryoMessage")
    public IKaigoKanryoMessageDiv getCcdKanryoMessage() {
        return ccdKanryoMessage;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtNinzu() {
        return this.getNinteiIchiran().getTxtNinzu();
    }

    @JsonIgnore
    public void  setTxtNinzu(TextBox txtNinzu) {
        this.getNinteiIchiran().setTxtNinzu(txtNinzu);
    }

    @JsonIgnore
    public DataGrid<dgNinteiChosaData_Row> getDgNinteiChosaData() {
        return this.getNinteiIchiran().getDgNinteiChosaData();
    }

    @JsonIgnore
    public void  setDgNinteiChosaData(DataGrid<dgNinteiChosaData_Row> dgNinteiChosaData) {
        this.getNinteiIchiran().setDgNinteiChosaData(dgNinteiChosaData);
    }

    // </editor-fold>
}
