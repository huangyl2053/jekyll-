package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.tokkiimages.TokkiImagesPerChosa;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TokkiJikoSelecting のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokkiJikoSelectingDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-23_13-41-30">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlTokkiJikoNos")
    private DropDownList ddlTokkiJikoNos;
    @JsonProperty("btnToDisplay")
    private Button btnToDisplay;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlTokkiJikoNos
     * @return ddlTokkiJikoNos
     */
    @JsonProperty("ddlTokkiJikoNos")
    public DropDownList getDdlTokkiJikoNos() {
        return ddlTokkiJikoNos;
    }

    /*
     * setddlTokkiJikoNos
     * @param ddlTokkiJikoNos ddlTokkiJikoNos
     */
    @JsonProperty("ddlTokkiJikoNos")
    public void setDdlTokkiJikoNos(DropDownList ddlTokkiJikoNos) {
        this.ddlTokkiJikoNos = ddlTokkiJikoNos;
    }

    /*
     * getbtnToDisplay
     * @return btnToDisplay
     */
    @JsonProperty("btnToDisplay")
    public Button getBtnToDisplay() {
        return btnToDisplay;
    }

    /*
     * setbtnToDisplay
     * @param btnToDisplay btnToDisplay
     */
    @JsonProperty("btnToDisplay")
    public void setBtnToDisplay(Button btnToDisplay) {
        this.btnToDisplay = btnToDisplay;
    }

    // </editor-fold>
}
