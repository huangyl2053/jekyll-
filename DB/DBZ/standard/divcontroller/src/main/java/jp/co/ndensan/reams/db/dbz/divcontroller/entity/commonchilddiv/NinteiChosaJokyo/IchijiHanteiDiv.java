package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiChosaJokyo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * IchijiHantei のクラスファイル 
 * 
 * @author 自動生成
 */
public class IchijiHanteiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_08-44-29">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlYokaigodo")
    private DropDownList ddlYokaigodo;
    @JsonProperty("txtIchijiHanteiDate")
    private TextBoxFlexibleDate txtIchijiHanteiDate;
    @JsonProperty("ddlNinchishoKasangoYokaigodo")
    private DropDownList ddlNinchishoKasangoYokaigodo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlYokaigodo
     * @return ddlYokaigodo
     */
    @JsonProperty("ddlYokaigodo")
    public DropDownList getDdlYokaigodo() {
        return ddlYokaigodo;
    }

    /*
     * setddlYokaigodo
     * @param ddlYokaigodo ddlYokaigodo
     */
    @JsonProperty("ddlYokaigodo")
    public void setDdlYokaigodo(DropDownList ddlYokaigodo) {
        this.ddlYokaigodo = ddlYokaigodo;
    }

    /*
     * gettxtIchijiHanteiDate
     * @return txtIchijiHanteiDate
     */
    @JsonProperty("txtIchijiHanteiDate")
    public TextBoxFlexibleDate getTxtIchijiHanteiDate() {
        return txtIchijiHanteiDate;
    }

    /*
     * settxtIchijiHanteiDate
     * @param txtIchijiHanteiDate txtIchijiHanteiDate
     */
    @JsonProperty("txtIchijiHanteiDate")
    public void setTxtIchijiHanteiDate(TextBoxFlexibleDate txtIchijiHanteiDate) {
        this.txtIchijiHanteiDate = txtIchijiHanteiDate;
    }

    /*
     * getddlNinchishoKasangoYokaigodo
     * @return ddlNinchishoKasangoYokaigodo
     */
    @JsonProperty("ddlNinchishoKasangoYokaigodo")
    public DropDownList getDdlNinchishoKasangoYokaigodo() {
        return ddlNinchishoKasangoYokaigodo;
    }

    /*
     * setddlNinchishoKasangoYokaigodo
     * @param ddlNinchishoKasangoYokaigodo ddlNinchishoKasangoYokaigodo
     */
    @JsonProperty("ddlNinchishoKasangoYokaigodo")
    public void setDdlNinchishoKasangoYokaigodo(DropDownList ddlNinchishoKasangoYokaigodo) {
        this.ddlNinchishoKasangoYokaigodo = ddlNinchishoKasangoYokaigodo;
    }

    // </editor-fold>
}
