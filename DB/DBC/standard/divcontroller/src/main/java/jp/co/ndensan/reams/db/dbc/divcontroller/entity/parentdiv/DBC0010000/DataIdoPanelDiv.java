package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * DataIdoPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class DataIdoPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnSento")
    private Button btnSento;
    @JsonProperty("btnMae")
    private Button btnMae;
    @JsonProperty("btnTsugi")
    private Button btnTsugi;
    @JsonProperty("btnSaigo")
    private Button btnSaigo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnSento
     * @return btnSento
     */
    @JsonProperty("btnSento")
    public Button getBtnSento() {
        return btnSento;
    }

    /*
     * setbtnSento
     * @param btnSento btnSento
     */
    @JsonProperty("btnSento")
    public void setBtnSento(Button btnSento) {
        this.btnSento = btnSento;
    }

    /*
     * getbtnMae
     * @return btnMae
     */
    @JsonProperty("btnMae")
    public Button getBtnMae() {
        return btnMae;
    }

    /*
     * setbtnMae
     * @param btnMae btnMae
     */
    @JsonProperty("btnMae")
    public void setBtnMae(Button btnMae) {
        this.btnMae = btnMae;
    }

    /*
     * getbtnTsugi
     * @return btnTsugi
     */
    @JsonProperty("btnTsugi")
    public Button getBtnTsugi() {
        return btnTsugi;
    }

    /*
     * setbtnTsugi
     * @param btnTsugi btnTsugi
     */
    @JsonProperty("btnTsugi")
    public void setBtnTsugi(Button btnTsugi) {
        this.btnTsugi = btnTsugi;
    }

    /*
     * getbtnSaigo
     * @return btnSaigo
     */
    @JsonProperty("btnSaigo")
    public Button getBtnSaigo() {
        return btnSaigo;
    }

    /*
     * setbtnSaigo
     * @param btnSaigo btnSaigo
     */
    @JsonProperty("btnSaigo")
    public void setBtnSaigo(Button btnSaigo) {
        this.btnSaigo = btnSaigo;
    }

    // </editor-fold>
}
