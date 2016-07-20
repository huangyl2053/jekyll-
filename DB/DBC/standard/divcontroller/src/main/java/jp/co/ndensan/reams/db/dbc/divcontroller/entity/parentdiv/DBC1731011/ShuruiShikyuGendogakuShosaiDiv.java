package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1731011;
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
 * ShuruiShikyuGendogakuShosai のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShuruiShikyuGendogakuShosaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTekiyoKaishiYM")
    private TextBoxDate txtTekiyoKaishiYM;
    @JsonProperty("txtTekiyoShuryoYM")
    private TextBoxDate txtTekiyoShuryoYM;
    @JsonProperty("ddlServiceShurui")
    private DropDownList ddlServiceShurui;
    @JsonProperty("linShosai")
    private HorizontalLine linShosai;
    @JsonProperty("lblMassage1")
    private Label lblMassage1;
    @JsonProperty("tblGendogaku")
    private tblGendogakuDiv tblGendogaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtTekiyoKaishiYM
     * @return txtTekiyoKaishiYM
     */
    @JsonProperty("txtTekiyoKaishiYM")
    public TextBoxDate getTxtTekiyoKaishiYM() {
        return txtTekiyoKaishiYM;
    }

    /*
     * settxtTekiyoKaishiYM
     * @param txtTekiyoKaishiYM txtTekiyoKaishiYM
     */
    @JsonProperty("txtTekiyoKaishiYM")
    public void setTxtTekiyoKaishiYM(TextBoxDate txtTekiyoKaishiYM) {
        this.txtTekiyoKaishiYM = txtTekiyoKaishiYM;
    }

    /*
     * gettxtTekiyoShuryoYM
     * @return txtTekiyoShuryoYM
     */
    @JsonProperty("txtTekiyoShuryoYM")
    public TextBoxDate getTxtTekiyoShuryoYM() {
        return txtTekiyoShuryoYM;
    }

    /*
     * settxtTekiyoShuryoYM
     * @param txtTekiyoShuryoYM txtTekiyoShuryoYM
     */
    @JsonProperty("txtTekiyoShuryoYM")
    public void setTxtTekiyoShuryoYM(TextBoxDate txtTekiyoShuryoYM) {
        this.txtTekiyoShuryoYM = txtTekiyoShuryoYM;
    }

    /*
     * getddlServiceShurui
     * @return ddlServiceShurui
     */
    @JsonProperty("ddlServiceShurui")
    public DropDownList getDdlServiceShurui() {
        return ddlServiceShurui;
    }

    /*
     * setddlServiceShurui
     * @param ddlServiceShurui ddlServiceShurui
     */
    @JsonProperty("ddlServiceShurui")
    public void setDdlServiceShurui(DropDownList ddlServiceShurui) {
        this.ddlServiceShurui = ddlServiceShurui;
    }

    /*
     * getlinShosai
     * @return linShosai
     */
    @JsonProperty("linShosai")
    public HorizontalLine getLinShosai() {
        return linShosai;
    }

    /*
     * setlinShosai
     * @param linShosai linShosai
     */
    @JsonProperty("linShosai")
    public void setLinShosai(HorizontalLine linShosai) {
        this.linShosai = linShosai;
    }

    /*
     * getlblMassage1
     * @return lblMassage1
     */
    @JsonProperty("lblMassage1")
    public Label getLblMassage1() {
        return lblMassage1;
    }

    /*
     * setlblMassage1
     * @param lblMassage1 lblMassage1
     */
    @JsonProperty("lblMassage1")
    public void setLblMassage1(Label lblMassage1) {
        this.lblMassage1 = lblMassage1;
    }

    /*
     * gettblGendogaku
     * @return tblGendogaku
     */
    @JsonProperty("tblGendogaku")
    public tblGendogakuDiv getTblGendogaku() {
        return tblGendogaku;
    }

    /*
     * settblGendogaku
     * @param tblGendogaku tblGendogaku
     */
    @JsonProperty("tblGendogaku")
    public void setTblGendogaku(tblGendogakuDiv tblGendogaku) {
        this.tblGendogaku = tblGendogaku;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblMidashi5() {
        return this.getTblGendogaku().getLblMidashi5();
    }

    @JsonIgnore
    public Label getLblMidashi1() {
        return this.getTblGendogaku().getLblMidashi1();
    }

    @JsonIgnore
    public Label getLblMidashi2() {
        return this.getTblGendogaku().getLblMidashi2();
    }

    @JsonIgnore
    public TextBoxNum getTxtYoShien1() {
        return this.getTblGendogaku().getTxtYoShien1();
    }

    @JsonIgnore
    public Label getLblMidashi3() {
        return this.getTblGendogaku().getLblMidashi3();
    }

    @JsonIgnore
    public TextBoxNum getTxtYoShien2() {
        return this.getTblGendogaku().getTxtYoShien2();
    }

    @JsonIgnore
    public Label getLblMidashi4() {
        return this.getTblGendogaku().getLblMidashi4();
    }

    @JsonIgnore
    public TextBoxNum getTxtNijiYobo() {
        return this.getTblGendogaku().getTxtNijiYobo();
    }

    // </editor-fold>
}
