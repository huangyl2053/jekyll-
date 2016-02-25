package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0210011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * UmareYMD のクラスファイル 
 * 
 * @author 自動生成
 */
public class UmareYMDDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtUmareSt")
    private TextBoxDate txtUmareSt;
    @JsonProperty("lblKara2")
    private Label lblKara2;
    @JsonProperty("txtUmareEd")
    private TextBoxDate txtUmareEd;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtUmareSt
     * @return txtUmareSt
     */
    @JsonProperty("txtUmareSt")
    public TextBoxDate getTxtUmareSt() {
        return txtUmareSt;
    }

    /*
     * settxtUmareSt
     * @param txtUmareSt txtUmareSt
     */
    @JsonProperty("txtUmareSt")
    public void setTxtUmareSt(TextBoxDate txtUmareSt) {
        this.txtUmareSt = txtUmareSt;
    }

    /*
     * getlblKara2
     * @return lblKara2
     */
    @JsonProperty("lblKara2")
    public Label getLblKara2() {
        return lblKara2;
    }

    /*
     * setlblKara2
     * @param lblKara2 lblKara2
     */
    @JsonProperty("lblKara2")
    public void setLblKara2(Label lblKara2) {
        this.lblKara2 = lblKara2;
    }

    /*
     * gettxtUmareEd
     * @return txtUmareEd
     */
    @JsonProperty("txtUmareEd")
    public TextBoxDate getTxtUmareEd() {
        return txtUmareEd;
    }

    /*
     * settxtUmareEd
     * @param txtUmareEd txtUmareEd
     */
    @JsonProperty("txtUmareEd")
    public void setTxtUmareEd(TextBoxDate txtUmareEd) {
        this.txtUmareEd = txtUmareEd;
    }

    // </editor-fold>
}
