package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1010032;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HyojiTaisho のクラスファイル 
 * 
 * @author 自動生成
 */
public class HyojiTaishoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlBatchShoriNichiji")
    private DropDownList ddlBatchShoriNichiji;
    @JsonProperty("btnSelect")
    private Button btnSelect;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlBatchShoriNichiji
     * @return ddlBatchShoriNichiji
     */
    @JsonProperty("ddlBatchShoriNichiji")
    public DropDownList getDdlBatchShoriNichiji() {
        return ddlBatchShoriNichiji;
    }

    /*
     * setddlBatchShoriNichiji
     * @param ddlBatchShoriNichiji ddlBatchShoriNichiji
     */
    @JsonProperty("ddlBatchShoriNichiji")
    public void setDdlBatchShoriNichiji(DropDownList ddlBatchShoriNichiji) {
        this.ddlBatchShoriNichiji = ddlBatchShoriNichiji;
    }

    /*
     * getbtnSelect
     * @return btnSelect
     */
    @JsonProperty("btnSelect")
    public Button getBtnSelect() {
        return btnSelect;
    }

    /*
     * setbtnSelect
     * @param btnSelect btnSelect
     */
    @JsonProperty("btnSelect")
    public void setBtnSelect(Button btnSelect) {
        this.btnSelect = btnSelect;
    }

    // </editor-fold>
}
