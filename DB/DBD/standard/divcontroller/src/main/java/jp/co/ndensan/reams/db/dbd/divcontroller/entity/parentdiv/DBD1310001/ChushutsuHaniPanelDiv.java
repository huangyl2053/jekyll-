package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1310001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChushutsuHaniPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChushutsuHaniPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkSaisin")
    private CheckBoxList chkSaisin;
    @JsonProperty("txtKijyunYmd")
    private TextBoxDate txtKijyunYmd;
    @JsonProperty("lblNinteiYmdHani")
    private Label lblNinteiYmdHani;
    @JsonProperty("txtNinteiYmdHani")
    private TextBoxDateRange txtNinteiYmdHani;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkSaisin
     * @return chkSaisin
     */
    @JsonProperty("chkSaisin")
    public CheckBoxList getChkSaisin() {
        return chkSaisin;
    }

    /*
     * setchkSaisin
     * @param chkSaisin chkSaisin
     */
    @JsonProperty("chkSaisin")
    public void setChkSaisin(CheckBoxList chkSaisin) {
        this.chkSaisin = chkSaisin;
    }

    /*
     * gettxtKijyunYmd
     * @return txtKijyunYmd
     */
    @JsonProperty("txtKijyunYmd")
    public TextBoxDate getTxtKijyunYmd() {
        return txtKijyunYmd;
    }

    /*
     * settxtKijyunYmd
     * @param txtKijyunYmd txtKijyunYmd
     */
    @JsonProperty("txtKijyunYmd")
    public void setTxtKijyunYmd(TextBoxDate txtKijyunYmd) {
        this.txtKijyunYmd = txtKijyunYmd;
    }

    /*
     * getlblNinteiYmdHani
     * @return lblNinteiYmdHani
     */
    @JsonProperty("lblNinteiYmdHani")
    public Label getLblNinteiYmdHani() {
        return lblNinteiYmdHani;
    }

    /*
     * setlblNinteiYmdHani
     * @param lblNinteiYmdHani lblNinteiYmdHani
     */
    @JsonProperty("lblNinteiYmdHani")
    public void setLblNinteiYmdHani(Label lblNinteiYmdHani) {
        this.lblNinteiYmdHani = lblNinteiYmdHani;
    }

    /*
     * gettxtNinteiYmdHani
     * @return txtNinteiYmdHani
     */
    @JsonProperty("txtNinteiYmdHani")
    public TextBoxDateRange getTxtNinteiYmdHani() {
        return txtNinteiYmdHani;
    }

    /*
     * settxtNinteiYmdHani
     * @param txtNinteiYmdHani txtNinteiYmdHani
     */
    @JsonProperty("txtNinteiYmdHani")
    public void setTxtNinteiYmdHani(TextBoxDateRange txtNinteiYmdHani) {
        this.txtNinteiYmdHani = txtNinteiYmdHani;
    }

    // </editor-fold>
}
