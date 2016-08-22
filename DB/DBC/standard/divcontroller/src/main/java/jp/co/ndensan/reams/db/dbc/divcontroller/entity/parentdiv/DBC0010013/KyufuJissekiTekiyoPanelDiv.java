package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010013;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KyufuJissekiTekiyoPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyufuJissekiTekiyoPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTekiyo")
    private TextBoxMultiLine txtTekiyo;
    @JsonProperty("btnKyufuJissekiTekiyoClose")
    private Button btnKyufuJissekiTekiyoClose;

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
     * getbtnKyufuJissekiTekiyoClose
     * @return btnKyufuJissekiTekiyoClose
     */
    @JsonProperty("btnKyufuJissekiTekiyoClose")
    public Button getBtnKyufuJissekiTekiyoClose() {
        return btnKyufuJissekiTekiyoClose;
    }

    /*
     * setbtnKyufuJissekiTekiyoClose
     * @param btnKyufuJissekiTekiyoClose btnKyufuJissekiTekiyoClose
     */
    @JsonProperty("btnKyufuJissekiTekiyoClose")
    public void setBtnKyufuJissekiTekiyoClose(Button btnKyufuJissekiTekiyoClose) {
        this.btnKyufuJissekiTekiyoClose = btnKyufuJissekiTekiyoClose;
    }

    // </editor-fold>
}
