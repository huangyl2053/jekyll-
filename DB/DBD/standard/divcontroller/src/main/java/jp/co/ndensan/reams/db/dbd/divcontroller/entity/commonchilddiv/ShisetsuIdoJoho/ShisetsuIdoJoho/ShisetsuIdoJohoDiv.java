package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.ShisetsuIdoJoho.ShisetsuIdoJoho;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShisetsuIdoJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShisetsuIdoJohoDiv extends Panel implements IShisetsuIdoJohoDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgShisetsuIdoJoho")
    private DataGrid<dgShisetsuIdoJoho_Row> dgShisetsuIdoJoho;
    @JsonProperty("btnClose")
    private Button btnClose;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgShisetsuIdoJoho
     * @return dgShisetsuIdoJoho
     */
    @JsonProperty("dgShisetsuIdoJoho")
    public DataGrid<dgShisetsuIdoJoho_Row> getDgShisetsuIdoJoho() {
        return dgShisetsuIdoJoho;
    }

    /*
     * setdgShisetsuIdoJoho
     * @param dgShisetsuIdoJoho dgShisetsuIdoJoho
     */
    @JsonProperty("dgShisetsuIdoJoho")
    public void setDgShisetsuIdoJoho(DataGrid<dgShisetsuIdoJoho_Row> dgShisetsuIdoJoho) {
        this.dgShisetsuIdoJoho = dgShisetsuIdoJoho;
    }

    /*
     * getbtnClose
     * @return btnClose
     */
    @JsonProperty("btnClose")
    public Button getBtnClose() {
        return btnClose;
    }

    /*
     * setbtnClose
     * @param btnClose btnClose
     */
    @JsonProperty("btnClose")
    public void setBtnClose(Button btnClose) {
        this.btnClose = btnClose;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
