package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ShobyoIken.ShobyoIken;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.CodeInput.CodeInputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.CodeInput.ICodeInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * geninShikkanPanel のクラスファイル
 *
 */
public class geninShikkanPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-15_08-21-11">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnAdd")
    private Button btnAdd;
    @JsonProperty("dgGenyin")
    private DataGrid<dgGenyin_Row> dgGenyin;
    @JsonProperty("geninShikkanShosai")
    private geninShikkanShosaiDiv geninShikkanShosai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnAdd
     * @return btnAdd
     */
    @JsonProperty("btnAdd")
    public Button getBtnAdd() {
        return btnAdd;
    }

    /*
     * setbtnAdd
     * @param btnAdd btnAdd
     */
    @JsonProperty("btnAdd")
    public void setBtnAdd(Button btnAdd) {
        this.btnAdd = btnAdd;
    }

    /*
     * getdgGenyin
     * @return dgGenyin
     */
    @JsonProperty("dgGenyin")
    public DataGrid<dgGenyin_Row> getDgGenyin() {
        return dgGenyin;
    }

    /*
     * setdgGenyin
     * @param dgGenyin dgGenyin
     */
    @JsonProperty("dgGenyin")
    public void setDgGenyin(DataGrid<dgGenyin_Row> dgGenyin) {
        this.dgGenyin = dgGenyin;
    }

    /*
     * getgeninShikkanShosai
     * @return geninShikkanShosai
     */
    @JsonProperty("geninShikkanShosai")
    public geninShikkanShosaiDiv getGeninShikkanShosai() {
        return geninShikkanShosai;
    }

    /*
     * setgeninShikkanShosai
     * @param geninShikkanShosai geninShikkanShosai
     */
    @JsonProperty("geninShikkanShosai")
    public void setGeninShikkanShosai(geninShikkanShosaiDiv geninShikkanShosai) {
        this.geninShikkanShosai = geninShikkanShosai;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ICodeInputDiv getCcdCodeInputGeninShikkan() {
        return this.getGeninShikkanShosai().getCcdCodeInputGeninShikkan();
    }

    @JsonIgnore
    public RadioButton getRadIsShutaruGeninShikkan() {
        return this.getGeninShikkanShosai().getRadIsShutaruGeninShikkan();
    }

    @JsonIgnore
    public void  setRadIsShutaruGeninShikkan(RadioButton radIsShutaruGeninShikkan) {
        this.getGeninShikkanShosai().setRadIsShutaruGeninShikkan(radIsShutaruGeninShikkan);
    }

    @JsonIgnore
    public Button getBtnNo() {
        return this.getGeninShikkanShosai().getBtnNo();
    }

    @JsonIgnore
    public void  setBtnNo(Button btnNo) {
        this.getGeninShikkanShosai().setBtnNo(btnNo);
    }

    @JsonIgnore
    public Button getBtnOK() {
        return this.getGeninShikkanShosai().getBtnOK();
    }

    @JsonIgnore
    public void  setBtnOK(Button btnOK) {
        this.getGeninShikkanShosai().setBtnOK(btnOK);
    }

    // </editor-fold>
}
