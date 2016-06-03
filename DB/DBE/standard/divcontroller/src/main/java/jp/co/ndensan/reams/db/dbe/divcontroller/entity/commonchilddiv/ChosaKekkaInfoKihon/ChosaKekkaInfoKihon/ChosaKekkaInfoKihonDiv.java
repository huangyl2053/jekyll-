package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ChosaKekkaInfoKihon.ChosaKekkaInfoKihon;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChosaKekkaInfoKihon のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChosaKekkaInfoKihonDiv extends Panel implements IChosaKekkaInfoKihonDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtNinteichosaJisshiYMD")
    private TextBoxDate txtNinteichosaJisshiYMD;
    @JsonProperty("txtChosaJisshiBashoMeisho")
    private TextBox txtChosaJisshiBashoMeisho;
    @JsonProperty("KihonChosaPanel")
    private KihonChosaPanelDiv KihonChosaPanel;
    @JsonProperty("Button1")
    private Button Button1;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtNinteichosaJisshiYMD
     * @return txtNinteichosaJisshiYMD
     */
    @JsonProperty("txtNinteichosaJisshiYMD")
    public TextBoxDate getTxtNinteichosaJisshiYMD() {
        return txtNinteichosaJisshiYMD;
    }

    /*
     * settxtNinteichosaJisshiYMD
     * @param txtNinteichosaJisshiYMD txtNinteichosaJisshiYMD
     */
    @JsonProperty("txtNinteichosaJisshiYMD")
    public void setTxtNinteichosaJisshiYMD(TextBoxDate txtNinteichosaJisshiYMD) {
        this.txtNinteichosaJisshiYMD = txtNinteichosaJisshiYMD;
    }

    /*
     * gettxtChosaJisshiBashoMeisho
     * @return txtChosaJisshiBashoMeisho
     */
    @JsonProperty("txtChosaJisshiBashoMeisho")
    public TextBox getTxtChosaJisshiBashoMeisho() {
        return txtChosaJisshiBashoMeisho;
    }

    /*
     * settxtChosaJisshiBashoMeisho
     * @param txtChosaJisshiBashoMeisho txtChosaJisshiBashoMeisho
     */
    @JsonProperty("txtChosaJisshiBashoMeisho")
    public void setTxtChosaJisshiBashoMeisho(TextBox txtChosaJisshiBashoMeisho) {
        this.txtChosaJisshiBashoMeisho = txtChosaJisshiBashoMeisho;
    }

    /*
     * getKihonChosaPanel
     * @return KihonChosaPanel
     */
    @JsonProperty("KihonChosaPanel")
    public KihonChosaPanelDiv getKihonChosaPanel() {
        return KihonChosaPanel;
    }

    /*
     * setKihonChosaPanel
     * @param KihonChosaPanel KihonChosaPanel
     */
    @JsonProperty("KihonChosaPanel")
    public void setKihonChosaPanel(KihonChosaPanelDiv KihonChosaPanel) {
        this.KihonChosaPanel = KihonChosaPanel;
    }

    /*
     * getButton1
     * @return Button1
     */
    @JsonProperty("Button1")
    public Button getButton1() {
        return Button1;
    }

    /*
     * setButton1
     * @param Button1 Button1
     */
    @JsonProperty("Button1")
    public void setButton1(Button Button1) {
        this.Button1 = Button1;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
