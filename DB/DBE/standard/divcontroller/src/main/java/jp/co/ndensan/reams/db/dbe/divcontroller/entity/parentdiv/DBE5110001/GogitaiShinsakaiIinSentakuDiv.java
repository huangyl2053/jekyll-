package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5110001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * GogitaiShinsakaiIinSentaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class GogitaiShinsakaiIinSentakuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblShinsain")
    private Label lblShinsain;
    @JsonProperty("btnShinsainSelect")
    private ButtonDialog btnShinsainSelect;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblShinsain
     * @return lblShinsain
     */
    @JsonProperty("lblShinsain")
    public Label getLblShinsain() {
        return lblShinsain;
    }

    /*
     * setlblShinsain
     * @param lblShinsain lblShinsain
     */
    @JsonProperty("lblShinsain")
    public void setLblShinsain(Label lblShinsain) {
        this.lblShinsain = lblShinsain;
    }

    /*
     * getbtnShinsainSelect
     * @return btnShinsainSelect
     */
    @JsonProperty("btnShinsainSelect")
    public ButtonDialog getBtnShinsainSelect() {
        return btnShinsainSelect;
    }

    /*
     * setbtnShinsainSelect
     * @param btnShinsainSelect btnShinsainSelect
     */
    @JsonProperty("btnShinsainSelect")
    public void setBtnShinsainSelect(ButtonDialog btnShinsainSelect) {
        this.btnShinsainSelect = btnShinsainSelect;
    }

    // </editor-fold>
}
