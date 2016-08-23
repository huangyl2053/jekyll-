package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010015;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TekiyoPanelPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class TekiyoPanelPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTekiyo")
    private TextBoxMultiLine txtTekiyo;
    @JsonProperty("btnTekiyoClose")
    private Button btnTekiyoClose;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtTekiyo
     * @return txtTekiyo
     */
    @JsonProperty("txtTekiyo")
    public TextBoxMultiLine getTxtTekiyo() {
        return txtTekiyo;
    }

    /*
     * settxtTekiyo
     * @param txtTekiyo txtTekiyo
     */
    @JsonProperty("txtTekiyo")
    public void setTxtTekiyo(TextBoxMultiLine txtTekiyo) {
        this.txtTekiyo = txtTekiyo;
    }

    /*
     * getbtnTekiyoClose
     * @return btnTekiyoClose
     */
    @JsonProperty("btnTekiyoClose")
    public Button getBtnTekiyoClose() {
        return btnTekiyoClose;
    }

    /*
     * setbtnTekiyoClose
     * @param btnTekiyoClose btnTekiyoClose
     */
    @JsonProperty("btnTekiyoClose")
    public void setBtnTekiyoClose(Button btnTekiyoClose) {
        this.btnTekiyoClose = btnTekiyoClose;
    }

    // </editor-fold>
}
