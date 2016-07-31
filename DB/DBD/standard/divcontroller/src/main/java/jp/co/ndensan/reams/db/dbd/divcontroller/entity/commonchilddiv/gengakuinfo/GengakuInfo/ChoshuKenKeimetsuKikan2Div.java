package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.gengakuinfo.GengakuInfo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChoshuKenKeimetsuKikan2 のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChoshuKenKeimetsuKikan2Div extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ChoshuKenKeimetsuKikan3")
    private ChoshuKenKeimetsuKikan3Div ChoshuKenKeimetsuKikan3;
    @JsonProperty("ChoshuKenKeimetsuKikan4")
    private ChoshuKenKeimetsuKikan4Div ChoshuKenKeimetsuKikan4;
    @JsonProperty("Kasan")
    private KasanDiv Kasan;
    @JsonProperty("NofuZumiKikan")
    private NofuZumiKikanDiv NofuZumiKikan;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getChoshuKenKeimetsuKikan3
     * @return ChoshuKenKeimetsuKikan3
     */
    @JsonProperty("ChoshuKenKeimetsuKikan3")
    public ChoshuKenKeimetsuKikan3Div getChoshuKenKeimetsuKikan3() {
        return ChoshuKenKeimetsuKikan3;
    }

    /*
     * setChoshuKenKeimetsuKikan3
     * @param ChoshuKenKeimetsuKikan3 ChoshuKenKeimetsuKikan3
     */
    @JsonProperty("ChoshuKenKeimetsuKikan3")
    public void setChoshuKenKeimetsuKikan3(ChoshuKenKeimetsuKikan3Div ChoshuKenKeimetsuKikan3) {
        this.ChoshuKenKeimetsuKikan3 = ChoshuKenKeimetsuKikan3;
    }

    /*
     * getChoshuKenKeimetsuKikan4
     * @return ChoshuKenKeimetsuKikan4
     */
    @JsonProperty("ChoshuKenKeimetsuKikan4")
    public ChoshuKenKeimetsuKikan4Div getChoshuKenKeimetsuKikan4() {
        return ChoshuKenKeimetsuKikan4;
    }

    /*
     * setChoshuKenKeimetsuKikan4
     * @param ChoshuKenKeimetsuKikan4 ChoshuKenKeimetsuKikan4
     */
    @JsonProperty("ChoshuKenKeimetsuKikan4")
    public void setChoshuKenKeimetsuKikan4(ChoshuKenKeimetsuKikan4Div ChoshuKenKeimetsuKikan4) {
        this.ChoshuKenKeimetsuKikan4 = ChoshuKenKeimetsuKikan4;
    }

    /*
     * getKasan
     * @return Kasan
     */
    @JsonProperty("Kasan")
    public KasanDiv getKasan() {
        return Kasan;
    }

    /*
     * setKasan
     * @param Kasan Kasan
     */
    @JsonProperty("Kasan")
    public void setKasan(KasanDiv Kasan) {
        this.Kasan = Kasan;
    }

    /*
     * getNofuZumiKikan
     * @return NofuZumiKikan
     */
    @JsonProperty("NofuZumiKikan")
    public NofuZumiKikanDiv getNofuZumiKikan() {
        return NofuZumiKikan;
    }

    /*
     * setNofuZumiKikan
     * @param NofuZumiKikan NofuZumiKikan
     */
    @JsonProperty("NofuZumiKikan")
    public void setNofuZumiKikan(NofuZumiKikanDiv NofuZumiKikan) {
        this.NofuZumiKikan = NofuZumiKikan;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblChoShushometsu2() {
        return this.getChoshuKenKeimetsuKikan3().getLblChoShushometsu2();
    }

    @JsonIgnore
    public void  setLblChoShushometsu2(Label lblChoShushometsu2) {
        this.getChoshuKenKeimetsuKikan3().setLblChoShushometsu2(lblChoShushometsu2);
    }

    @JsonIgnore
    public TextBoxNum getTxtChoShushometsu2() {
        return this.getChoshuKenKeimetsuKikan3().getTxtChoShushometsu2();
    }

    @JsonIgnore
    public void  setTxtChoShushometsu2(TextBoxNum txtChoShushometsu2) {
        this.getChoshuKenKeimetsuKikan3().setTxtChoShushometsu2(txtChoShushometsu2);
    }

    @JsonIgnore
    public Label getLblLine() {
        return this.getChoshuKenKeimetsuKikan3().getLblLine();
    }

    @JsonIgnore
    public void  setLblLine(Label lblLine) {
        this.getChoshuKenKeimetsuKikan3().setLblLine(lblLine);
    }

    @JsonIgnore
    public Label getLblChoShushometsu3() {
        return this.getChoshuKenKeimetsuKikan4().getLblChoShushometsu3();
    }

    @JsonIgnore
    public void  setLblChoShushometsu3(Label lblChoShushometsu3) {
        this.getChoshuKenKeimetsuKikan4().setLblChoShushometsu3(lblChoShushometsu3);
    }

    @JsonIgnore
    public TextBoxNum getTxtChoShushometsu3() {
        return this.getChoshuKenKeimetsuKikan4().getTxtChoShushometsu3();
    }

    @JsonIgnore
    public void  setTxtChoShushometsu3(TextBoxNum txtChoShushometsu3) {
        this.getChoshuKenKeimetsuKikan4().setTxtChoShushometsu3(txtChoShushometsu3);
    }

    @JsonIgnore
    public Label getLblKasan() {
        return this.getKasan().getLblKasan();
    }

    @JsonIgnore
    public void  setLblKasan(Label lblKasan) {
        this.getKasan().setLblKasan(lblKasan);
    }

    @JsonIgnore
    public Label getLblNofuZumiKikan() {
        return this.getNofuZumiKikan().getLblNofuZumiKikan();
    }

    @JsonIgnore
    public void  setLblNofuZumiKikan(Label lblNofuZumiKikan) {
        this.getNofuZumiKikan().setLblNofuZumiKikan(lblNofuZumiKikan);
    }

    @JsonIgnore
    public TextBoxNum getTxtNofuZumiKikan() {
        return this.getNofuZumiKikan().getTxtNofuZumiKikan();
    }

    @JsonIgnore
    public void  setTxtNofuZumiKikan(TextBoxNum txtNofuZumiKikan) {
        this.getNofuZumiKikan().setTxtNofuZumiKikan(txtNofuZumiKikan);
    }

    // </editor-fold>
}
