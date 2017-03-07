package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4050001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ImageMaskTaishoShiji のクラスファイル 
 * 
 * @author 自動生成
 */
public class ImageMaskTaishoShijiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-23_06-32-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgImageMaskingTaisho")
    private DataGrid<dgImageMaskingTaisho_Row> dgImageMaskingTaisho;
    @JsonProperty("btnMaskingGenpon")
    private ButtonDialog btnMaskingGenpon;
    @JsonProperty("btnMaskingMask")
    private ButtonDialog btnMaskingMask;
    @JsonProperty("btnMaskingGenponText")
    private ButtonDialog btnMaskingGenponText;
    @JsonProperty("btnMaskingMaskText")
    private ButtonDialog btnMaskingMaskText;
    @JsonProperty("btnSakujo")
    private Button btnSakujo;
    @JsonProperty("btnTorikeshi")
    private Button btnTorikeshi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgImageMaskingTaisho
     * @return dgImageMaskingTaisho
     */
    @JsonProperty("dgImageMaskingTaisho")
    public DataGrid<dgImageMaskingTaisho_Row> getDgImageMaskingTaisho() {
        return dgImageMaskingTaisho;
    }

    /*
     * setdgImageMaskingTaisho
     * @param dgImageMaskingTaisho dgImageMaskingTaisho
     */
    @JsonProperty("dgImageMaskingTaisho")
    public void setDgImageMaskingTaisho(DataGrid<dgImageMaskingTaisho_Row> dgImageMaskingTaisho) {
        this.dgImageMaskingTaisho = dgImageMaskingTaisho;
    }

    /*
     * getbtnMaskingGenpon
     * @return btnMaskingGenpon
     */
    @JsonProperty("btnMaskingGenpon")
    public ButtonDialog getBtnMaskingGenpon() {
        return btnMaskingGenpon;
    }

    /*
     * setbtnMaskingGenpon
     * @param btnMaskingGenpon btnMaskingGenpon
     */
    @JsonProperty("btnMaskingGenpon")
    public void setBtnMaskingGenpon(ButtonDialog btnMaskingGenpon) {
        this.btnMaskingGenpon = btnMaskingGenpon;
    }

    /*
     * getbtnMaskingMask
     * @return btnMaskingMask
     */
    @JsonProperty("btnMaskingMask")
    public ButtonDialog getBtnMaskingMask() {
        return btnMaskingMask;
    }

    /*
     * setbtnMaskingMask
     * @param btnMaskingMask btnMaskingMask
     */
    @JsonProperty("btnMaskingMask")
    public void setBtnMaskingMask(ButtonDialog btnMaskingMask) {
        this.btnMaskingMask = btnMaskingMask;
    }

    /*
     * getbtnMaskingGenponText
     * @return btnMaskingGenponText
     */
    @JsonProperty("btnMaskingGenponText")
    public ButtonDialog getBtnMaskingGenponText() {
        return btnMaskingGenponText;
    }

    /*
     * setbtnMaskingGenponText
     * @param btnMaskingGenponText btnMaskingGenponText
     */
    @JsonProperty("btnMaskingGenponText")
    public void setBtnMaskingGenponText(ButtonDialog btnMaskingGenponText) {
        this.btnMaskingGenponText = btnMaskingGenponText;
    }

    /*
     * getbtnMaskingMaskText
     * @return btnMaskingMaskText
     */
    @JsonProperty("btnMaskingMaskText")
    public ButtonDialog getBtnMaskingMaskText() {
        return btnMaskingMaskText;
    }

    /*
     * setbtnMaskingMaskText
     * @param btnMaskingMaskText btnMaskingMaskText
     */
    @JsonProperty("btnMaskingMaskText")
    public void setBtnMaskingMaskText(ButtonDialog btnMaskingMaskText) {
        this.btnMaskingMaskText = btnMaskingMaskText;
    }

    /*
     * getbtnSakujo
     * @return btnSakujo
     */
    @JsonProperty("btnSakujo")
    public Button getBtnSakujo() {
        return btnSakujo;
    }

    /*
     * setbtnSakujo
     * @param btnSakujo btnSakujo
     */
    @JsonProperty("btnSakujo")
    public void setBtnSakujo(Button btnSakujo) {
        this.btnSakujo = btnSakujo;
    }

    /*
     * getbtnTorikeshi
     * @return btnTorikeshi
     */
    @JsonProperty("btnTorikeshi")
    public Button getBtnTorikeshi() {
        return btnTorikeshi;
    }

    /*
     * setbtnTorikeshi
     * @param btnTorikeshi btnTorikeshi
     */
    @JsonProperty("btnTorikeshi")
    public void setBtnTorikeshi(Button btnTorikeshi) {
        this.btnTorikeshi = btnTorikeshi;
    }

    // </editor-fold>
}
