package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5120011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * sekkeiPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class sekkeiPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblmatome")
    private Label lblmatome;
    @JsonProperty("ddlmatome")
    private DropDownList ddlmatome;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblmatome
     * @return lblmatome
     */
    @JsonProperty("lblmatome")
    public Label getLblmatome() {
        return lblmatome;
    }

    /*
     * setlblmatome
     * @param lblmatome lblmatome
     */
    @JsonProperty("lblmatome")
    public void setLblmatome(Label lblmatome) {
        this.lblmatome = lblmatome;
    }

    /*
     * getddlmatome
     * @return ddlmatome
     */
    @JsonProperty("ddlmatome")
    public DropDownList getDdlmatome() {
        return ddlmatome;
    }

    /*
     * setddlmatome
     * @param ddlmatome ddlmatome
     */
    @JsonProperty("ddlmatome")
    public void setDdlmatome(DropDownList ddlmatome) {
        this.ddlmatome = ddlmatome;
    }

    // </editor-fold>
}
