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
 * GogitaiHoketsuIinSentaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class GogitaiHoketsuIinSentakuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-28_12-26-08">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblHoketsuShinsain")
    private Label lblHoketsuShinsain;
    @JsonProperty("btnSubShinsainSelect")
    private ButtonDialog btnSubShinsainSelect;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblHoketsuShinsain
     * @return lblHoketsuShinsain
     */
    @JsonProperty("lblHoketsuShinsain")
    public Label getLblHoketsuShinsain() {
        return lblHoketsuShinsain;
    }

    /*
     * setlblHoketsuShinsain
     * @param lblHoketsuShinsain lblHoketsuShinsain
     */
    @JsonProperty("lblHoketsuShinsain")
    public void setLblHoketsuShinsain(Label lblHoketsuShinsain) {
        this.lblHoketsuShinsain = lblHoketsuShinsain;
    }

    /*
     * getbtnSubShinsainSelect
     * @return btnSubShinsainSelect
     */
    @JsonProperty("btnSubShinsainSelect")
    public ButtonDialog getBtnSubShinsainSelect() {
        return btnSubShinsainSelect;
    }

    /*
     * setbtnSubShinsainSelect
     * @param btnSubShinsainSelect btnSubShinsainSelect
     */
    @JsonProperty("btnSubShinsainSelect")
    public void setBtnSubShinsainSelect(ButtonDialog btnSubShinsainSelect) {
        this.btnSubShinsainSelect = btnSubShinsainSelect;
    }

    // </editor-fold>
}
