package jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZA010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShikakuShutokuJogaiSettei のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShikakuShutokuJogaiSetteiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkShutokuJogai")
    private CheckBoxList chkShutokuJogai;
    @JsonProperty("lblShuseiGo04")
    private Label lblShuseiGo04;
    @JsonProperty("txtShutokuJogaiYmd")
    private TextBoxFlexibleDate txtShutokuJogaiYmd;
    @JsonProperty("txtShutokuJogaiRiyu")
    private TextBox txtShutokuJogaiRiyu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkShutokuJogai
     * @return chkShutokuJogai
     */
    @JsonProperty("chkShutokuJogai")
    public CheckBoxList getChkShutokuJogai() {
        return chkShutokuJogai;
    }

    /*
     * setchkShutokuJogai
     * @param chkShutokuJogai chkShutokuJogai
     */
    @JsonProperty("chkShutokuJogai")
    public void setChkShutokuJogai(CheckBoxList chkShutokuJogai) {
        this.chkShutokuJogai = chkShutokuJogai;
    }

    /*
     * getlblShuseiGo04
     * @return lblShuseiGo04
     */
    @JsonProperty("lblShuseiGo04")
    public Label getLblShuseiGo04() {
        return lblShuseiGo04;
    }

    /*
     * setlblShuseiGo04
     * @param lblShuseiGo04 lblShuseiGo04
     */
    @JsonProperty("lblShuseiGo04")
    public void setLblShuseiGo04(Label lblShuseiGo04) {
        this.lblShuseiGo04 = lblShuseiGo04;
    }

    /*
     * gettxtShutokuJogaiYmd
     * @return txtShutokuJogaiYmd
     */
    @JsonProperty("txtShutokuJogaiYmd")
    public TextBoxFlexibleDate getTxtShutokuJogaiYmd() {
        return txtShutokuJogaiYmd;
    }

    /*
     * settxtShutokuJogaiYmd
     * @param txtShutokuJogaiYmd txtShutokuJogaiYmd
     */
    @JsonProperty("txtShutokuJogaiYmd")
    public void setTxtShutokuJogaiYmd(TextBoxFlexibleDate txtShutokuJogaiYmd) {
        this.txtShutokuJogaiYmd = txtShutokuJogaiYmd;
    }

    /*
     * gettxtShutokuJogaiRiyu
     * @return txtShutokuJogaiRiyu
     */
    @JsonProperty("txtShutokuJogaiRiyu")
    public TextBox getTxtShutokuJogaiRiyu() {
        return txtShutokuJogaiRiyu;
    }

    /*
     * settxtShutokuJogaiRiyu
     * @param txtShutokuJogaiRiyu txtShutokuJogaiRiyu
     */
    @JsonProperty("txtShutokuJogaiRiyu")
    public void setTxtShutokuJogaiRiyu(TextBox txtShutokuJogaiRiyu) {
        this.txtShutokuJogaiRiyu = txtShutokuJogaiRiyu;
    }

    // </editor-fold>
}
