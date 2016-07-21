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
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("rdoIkenshoHyo")
    private RadioButton rdoIkenshoHyo;
    @JsonProperty("rdoIkenshoUra")
    private RadioButton rdoIkenshoUra;
    @JsonProperty("ddlMaskKubun")
    private DropDownList ddlMaskKubun;
    @JsonProperty("btnMasking")
    private Button btnMasking;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getrdoIkenshoHyo
     * @return rdoIkenshoHyo
     */
    @JsonProperty("rdoIkenshoHyo")
    public RadioButton getRdoIkenshoHyo() {
        return rdoIkenshoHyo;
    }

    /*
     * setrdoIkenshoHyo
     * @param rdoIkenshoHyo rdoIkenshoHyo
     */
    @JsonProperty("rdoIkenshoHyo")
    public void setRdoIkenshoHyo(RadioButton rdoIkenshoHyo) {
        this.rdoIkenshoHyo = rdoIkenshoHyo;
    }

    /*
     * getrdoIkenshoUra
     * @return rdoIkenshoUra
     */
    @JsonProperty("rdoIkenshoUra")
    public RadioButton getRdoIkenshoUra() {
        return rdoIkenshoUra;
    }

    /*
     * setrdoIkenshoUra
     * @param rdoIkenshoUra rdoIkenshoUra
     */
    @JsonProperty("rdoIkenshoUra")
    public void setRdoIkenshoUra(RadioButton rdoIkenshoUra) {
        this.rdoIkenshoUra = rdoIkenshoUra;
    }

    /*
     * getddlMaskKubun
     * @return ddlMaskKubun
     */
    @JsonProperty("ddlMaskKubun")
    public DropDownList getDdlMaskKubun() {
        return ddlMaskKubun;
    }

    /*
     * setddlMaskKubun
     * @param ddlMaskKubun ddlMaskKubun
     */
    @JsonProperty("ddlMaskKubun")
    public void setDdlMaskKubun(DropDownList ddlMaskKubun) {
        this.ddlMaskKubun = ddlMaskKubun;
    }

    /*
     * getbtnMasking
     * @return btnMasking
     */
    @JsonProperty("btnMasking")
    public Button getBtnMasking() {
        return btnMasking;
    }

    /*
     * setbtnMasking
     * @param btnMasking btnMasking
     */
    @JsonProperty("btnMasking")
    public void setBtnMasking(Button btnMasking) {
        this.btnMasking = btnMasking;
    }

    // </editor-fold>
}
