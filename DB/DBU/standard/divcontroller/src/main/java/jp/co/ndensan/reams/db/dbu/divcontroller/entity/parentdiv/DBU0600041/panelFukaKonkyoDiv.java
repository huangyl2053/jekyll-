package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600041;
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
 * panelFukaKonkyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class panelFukaKonkyoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtChouteiNendo")
    private TextBoxDate txtChouteiNendo;
    @JsonProperty("txtFukaNendo")
    private TextBoxDate txtFukaNendo;
    @JsonProperty("ddlTuutishoBango")
    private DropDownList ddlTuutishoBango;
    @JsonProperty("txtNekinBango")
    private TextBox txtNekinBango;
    @JsonProperty("txtNekinKodo")
    private TextBox txtNekinKodo;
    @JsonProperty("tblFukakonkyoMeisai")
    private tblFukakonkyoMeisaiDiv tblFukakonkyoMeisai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtChouteiNendo
     * @return txtChouteiNendo
     */
    @JsonProperty("txtChouteiNendo")
    public TextBoxDate getTxtChouteiNendo() {
        return txtChouteiNendo;
    }

    /*
     * settxtChouteiNendo
     * @param txtChouteiNendo txtChouteiNendo
     */
    @JsonProperty("txtChouteiNendo")
    public void setTxtChouteiNendo(TextBoxDate txtChouteiNendo) {
        this.txtChouteiNendo = txtChouteiNendo;
    }

    /*
     * gettxtFukaNendo
     * @return txtFukaNendo
     */
    @JsonProperty("txtFukaNendo")
    public TextBoxDate getTxtFukaNendo() {
        return txtFukaNendo;
    }

    /*
     * settxtFukaNendo
     * @param txtFukaNendo txtFukaNendo
     */
    @JsonProperty("txtFukaNendo")
    public void setTxtFukaNendo(TextBoxDate txtFukaNendo) {
        this.txtFukaNendo = txtFukaNendo;
    }

    /*
     * getddlTuutishoBango
     * @return ddlTuutishoBango
     */
    @JsonProperty("ddlTuutishoBango")
    public DropDownList getDdlTuutishoBango() {
        return ddlTuutishoBango;
    }

    /*
     * setddlTuutishoBango
     * @param ddlTuutishoBango ddlTuutishoBango
     */
    @JsonProperty("ddlTuutishoBango")
    public void setDdlTuutishoBango(DropDownList ddlTuutishoBango) {
        this.ddlTuutishoBango = ddlTuutishoBango;
    }

    /*
     * gettxtNekinBango
     * @return txtNekinBango
     */
    @JsonProperty("txtNekinBango")
    public TextBox getTxtNekinBango() {
        return txtNekinBango;
    }

    /*
     * settxtNekinBango
     * @param txtNekinBango txtNekinBango
     */
    @JsonProperty("txtNekinBango")
    public void setTxtNekinBango(TextBox txtNekinBango) {
        this.txtNekinBango = txtNekinBango;
    }

    /*
     * gettxtNekinKodo
     * @return txtNekinKodo
     */
    @JsonProperty("txtNekinKodo")
    public TextBox getTxtNekinKodo() {
        return txtNekinKodo;
    }

    /*
     * settxtNekinKodo
     * @param txtNekinKodo txtNekinKodo
     */
    @JsonProperty("txtNekinKodo")
    public void setTxtNekinKodo(TextBox txtNekinKodo) {
        this.txtNekinKodo = txtNekinKodo;
    }

    /*
     * gettblFukakonkyoMeisai
     * @return tblFukakonkyoMeisai
     */
    @JsonProperty("tblFukakonkyoMeisai")
    public tblFukakonkyoMeisaiDiv getTblFukakonkyoMeisai() {
        return tblFukakonkyoMeisai;
    }

    /*
     * settblFukakonkyoMeisai
     * @param tblFukakonkyoMeisai tblFukakonkyoMeisai
     */
    @JsonProperty("tblFukakonkyoMeisai")
    public void setTblFukakonkyoMeisai(tblFukakonkyoMeisaiDiv tblFukakonkyoMeisai) {
        this.tblFukakonkyoMeisai = tblFukakonkyoMeisai;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblFukakonkyoMidashi() {
        return this.getTblFukakonkyoMeisai().getLblFukakonkyoMidashi();
    }

    @JsonIgnore
    public Label getLblFukaKijunBi() {
        return this.getTblFukakonkyoMeisai().getLblFukaKijunBi();
    }

    @JsonIgnore
    public Label getLblFukakijunYMD() {
        return this.getTblFukakonkyoMeisai().getLblFukakijunYMD();
    }

    @JsonIgnore
    public Label getLblHonninKazei() {
        return this.getTblFukakonkyoMeisai().getLblHonninKazei();
    }

    @JsonIgnore
    public Label getLblZenHokenryoDankai() {
        return this.getTblFukakonkyoMeisai().getLblZenHokenryoDankai();
    }

    @JsonIgnore
    public Label getLblHonninKazeiValue() {
        return this.getTblFukakonkyoMeisai().getLblHonninKazeiValue();
    }

    @JsonIgnore
    public Label getLblZenHokenryoDankaiValue() {
        return this.getTblFukakonkyoMeisai().getLblZenHokenryoDankaiValue();
    }

    @JsonIgnore
    public Label getLblShikakuSyutokubi() {
        return this.getTblFukakonkyoMeisai().getLblShikakuSyutokubi();
    }

    @JsonIgnore
    public Label getLblShikakuShutokuYMD() {
        return this.getTblFukakonkyoMeisai().getLblShikakuShutokuYMD();
    }

    @JsonIgnore
    public Label getLblSetaiKazei() {
        return this.getTblFukakonkyoMeisai().getLblSetaiKazei();
    }

    @JsonIgnore
    public Label getLblZenHokenryoritsu() {
        return this.getTblFukakonkyoMeisai().getLblZenHokenryoritsu();
    }

    @JsonIgnore
    public Label getLblSetaiKazeiValue() {
        return this.getTblFukakonkyoMeisai().getLblSetaiKazeiValue();
    }

    @JsonIgnore
    public Label getLblZenHokenryoritsuValue() {
        return this.getTblFukakonkyoMeisai().getLblZenHokenryoritsuValue();
    }

    @JsonIgnore
    public Label getLblSoushitubi() {
        return this.getTblFukakonkyoMeisai().getLblSoushitubi();
    }

    @JsonIgnore
    public Label getLblShikakuSoshitsuYMD() {
        return this.getTblFukakonkyoMeisai().getLblShikakuSoshitsuYMD();
    }

    @JsonIgnore
    public Label getLblShotokuSum() {
        return this.getTblFukakonkyoMeisai().getLblShotokuSum();
    }

    @JsonIgnore
    public Label getLblZenNengakuHokenryo() {
        return this.getTblFukakonkyoMeisai().getLblZenNengakuHokenryo();
    }

    @JsonIgnore
    public Label getLblShotokuSumValue() {
        return this.getTblFukakonkyoMeisai().getLblShotokuSumValue();
    }

    @JsonIgnore
    public Label getLblZenNengakuHokenryoValue() {
        return this.getTblFukakonkyoMeisai().getLblZenNengakuHokenryoValue();
    }

    @JsonIgnore
    public Label getLblSeihoKaishibi() {
        return this.getTblFukakonkyoMeisai().getLblSeihoKaishibi();
    }

    @JsonIgnore
    public Label getLblSeihoKaishiYMD() {
        return this.getTblFukakonkyoMeisai().getLblSeihoKaishiYMD();
    }

    @JsonIgnore
    public Label getLblNenkinShunyu() {
        return this.getTblFukakonkyoMeisai().getLblNenkinShunyu();
    }

    @JsonIgnore
    public Label getLblNenkinShunyuValue() {
        return this.getTblFukakonkyoMeisai().getLblNenkinShunyuValue();
    }

    @JsonIgnore
    public Label getLblSeihoSyuryobi() {
        return this.getTblFukakonkyoMeisai().getLblSeihoSyuryobi();
    }

    @JsonIgnore
    public Label getLblSeihoShuryoYMD() {
        return this.getTblFukakonkyoMeisai().getLblSeihoShuryoYMD();
    }

    @JsonIgnore
    public Label getLblHokenryoDankai() {
        return this.getTblFukakonkyoMeisai().getLblHokenryoDankai();
    }

    @JsonIgnore
    public Label getLblHokenryoDankaiValue() {
        return this.getTblFukakonkyoMeisai().getLblHokenryoDankaiValue();
    }

    @JsonIgnore
    public Label getLblRounenKaishibi() {
        return this.getTblFukakonkyoMeisai().getLblRounenKaishibi();
    }

    @JsonIgnore
    public Label getLblRonenKaishiYMD() {
        return this.getTblFukakonkyoMeisai().getLblRonenKaishiYMD();
    }

    @JsonIgnore
    public Label getLblRounenSyuryobi() {
        return this.getTblFukakonkyoMeisai().getLblRounenSyuryobi();
    }

    @JsonIgnore
    public Label getLblRonenShuryoYMD() {
        return this.getTblFukakonkyoMeisai().getLblRonenShuryoYMD();
    }

    // </editor-fold>
}
