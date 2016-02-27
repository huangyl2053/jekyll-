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
 * Nenrei のクラスファイル 
 * 
 * @author 自動生成
 */
public class NenreiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtNenreiSt")
    private TextBoxNum txtNenreiSt;
    @JsonProperty("lblKara1")
    private Label lblKara1;
    @JsonProperty("txtNenreiEd")
    private TextBoxNum txtNenreiEd;
    @JsonProperty("txtNenreiKijunYMD")
    private TextBoxDate txtNenreiKijunYMD;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtNenreiSt
     * @return txtNenreiSt
     */
    @JsonProperty("txtNenreiSt")
    public TextBoxNum getTxtNenreiSt() {
        return txtNenreiSt;
    }

    /*
     * settxtNenreiSt
     * @param txtNenreiSt txtNenreiSt
     */
    @JsonProperty("txtNenreiSt")
    public void setTxtNenreiSt(TextBoxNum txtNenreiSt) {
        this.txtNenreiSt = txtNenreiSt;
    }

    /*
     * getlblKara1
     * @return lblKara1
     */
    @JsonProperty("lblKara1")
    public Label getLblKara1() {
        return lblKara1;
    }

    /*
     * setlblKara1
     * @param lblKara1 lblKara1
     */
    @JsonProperty("lblKara1")
    public void setLblKara1(Label lblKara1) {
        this.lblKara1 = lblKara1;
    }

    /*
     * gettxtNenreiEd
     * @return txtNenreiEd
     */
    @JsonProperty("txtNenreiEd")
    public TextBoxNum getTxtNenreiEd() {
        return txtNenreiEd;
    }

    /*
     * settxtNenreiEd
     * @param txtNenreiEd txtNenreiEd
     */
    @JsonProperty("txtNenreiEd")
    public void setTxtNenreiEd(TextBoxNum txtNenreiEd) {
        this.txtNenreiEd = txtNenreiEd;
    }

    /*
     * gettxtNenreiKijunYMD
     * @return txtNenreiKijunYMD
     */
    @JsonProperty("txtNenreiKijunYMD")
    public TextBoxDate getTxtNenreiKijunYMD() {
        return txtNenreiKijunYMD;
    }

    /*
     * settxtNenreiKijunYMD
     * @param txtNenreiKijunYMD txtNenreiKijunYMD
     */
    @JsonProperty("txtNenreiKijunYMD")
    public void setTxtNenreiKijunYMD(TextBoxDate txtNenreiKijunYMD) {
        this.txtNenreiKijunYMD = txtNenreiKijunYMD;
    }

    // </editor-fold>
}
