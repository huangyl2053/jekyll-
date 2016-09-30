package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD9010003;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.BunshoBangoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.IBunshoBangoInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * panelShosaiEria のクラスファイル 
 * 
 * @author 自動生成
 */
public class panelShosaiEriaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-21_20-30-14">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtCyouhyou")
    private TextBox txtCyouhyou;
    @JsonProperty("txtSakuseiBi")
    private TextBoxDate txtSakuseiBi;
    @JsonProperty("txtZenkaiHakkouBi")
    private TextBoxDate txtZenkaiHakkouBi;
    @JsonProperty("ddlTaishonen")
    private DropDownList ddlTaishonen;
    @JsonProperty("txtShinseiBi")
    private TextBoxDate txtShinseiBi;
    @JsonProperty("txtDateIkensyoSakuseiBi")
    private TextBoxDate txtDateIkensyoSakuseiBi;
    @JsonProperty("txtNinteiKikan")
    private TextBoxDateRange txtNinteiKikan;
    @JsonProperty("txtZiritudo")
    private TextBox txtZiritudo;
    @JsonProperty("txtNyoushikkin")
    private TextBox txtNyoushikkin;
    @JsonProperty("ccdBunshoBangoInput")
    private BunshoBangoInputDiv ccdBunshoBangoInput;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtCyouhyou
     * @return txtCyouhyou
     */
    @JsonProperty("txtCyouhyou")
    public TextBox getTxtCyouhyou() {
        return txtCyouhyou;
    }

    /*
     * settxtCyouhyou
     * @param txtCyouhyou txtCyouhyou
     */
    @JsonProperty("txtCyouhyou")
    public void setTxtCyouhyou(TextBox txtCyouhyou) {
        this.txtCyouhyou = txtCyouhyou;
    }

    /*
     * gettxtSakuseiBi
     * @return txtSakuseiBi
     */
    @JsonProperty("txtSakuseiBi")
    public TextBoxDate getTxtSakuseiBi() {
        return txtSakuseiBi;
    }

    /*
     * settxtSakuseiBi
     * @param txtSakuseiBi txtSakuseiBi
     */
    @JsonProperty("txtSakuseiBi")
    public void setTxtSakuseiBi(TextBoxDate txtSakuseiBi) {
        this.txtSakuseiBi = txtSakuseiBi;
    }

    /*
     * gettxtZenkaiHakkouBi
     * @return txtZenkaiHakkouBi
     */
    @JsonProperty("txtZenkaiHakkouBi")
    public TextBoxDate getTxtZenkaiHakkouBi() {
        return txtZenkaiHakkouBi;
    }

    /*
     * settxtZenkaiHakkouBi
     * @param txtZenkaiHakkouBi txtZenkaiHakkouBi
     */
    @JsonProperty("txtZenkaiHakkouBi")
    public void setTxtZenkaiHakkouBi(TextBoxDate txtZenkaiHakkouBi) {
        this.txtZenkaiHakkouBi = txtZenkaiHakkouBi;
    }

    /*
     * getddlTaishonen
     * @return ddlTaishonen
     */
    @JsonProperty("ddlTaishonen")
    public DropDownList getDdlTaishonen() {
        return ddlTaishonen;
    }

    /*
     * setddlTaishonen
     * @param ddlTaishonen ddlTaishonen
     */
    @JsonProperty("ddlTaishonen")
    public void setDdlTaishonen(DropDownList ddlTaishonen) {
        this.ddlTaishonen = ddlTaishonen;
    }

    /*
     * gettxtShinseiBi
     * @return txtShinseiBi
     */
    @JsonProperty("txtShinseiBi")
    public TextBoxDate getTxtShinseiBi() {
        return txtShinseiBi;
    }

    /*
     * settxtShinseiBi
     * @param txtShinseiBi txtShinseiBi
     */
    @JsonProperty("txtShinseiBi")
    public void setTxtShinseiBi(TextBoxDate txtShinseiBi) {
        this.txtShinseiBi = txtShinseiBi;
    }

    /*
     * gettxtDateIkensyoSakuseiBi
     * @return txtDateIkensyoSakuseiBi
     */
    @JsonProperty("txtDateIkensyoSakuseiBi")
    public TextBoxDate getTxtDateIkensyoSakuseiBi() {
        return txtDateIkensyoSakuseiBi;
    }

    /*
     * settxtDateIkensyoSakuseiBi
     * @param txtDateIkensyoSakuseiBi txtDateIkensyoSakuseiBi
     */
    @JsonProperty("txtDateIkensyoSakuseiBi")
    public void setTxtDateIkensyoSakuseiBi(TextBoxDate txtDateIkensyoSakuseiBi) {
        this.txtDateIkensyoSakuseiBi = txtDateIkensyoSakuseiBi;
    }

    /*
     * gettxtNinteiKikan
     * @return txtNinteiKikan
     */
    @JsonProperty("txtNinteiKikan")
    public TextBoxDateRange getTxtNinteiKikan() {
        return txtNinteiKikan;
    }

    /*
     * settxtNinteiKikan
     * @param txtNinteiKikan txtNinteiKikan
     */
    @JsonProperty("txtNinteiKikan")
    public void setTxtNinteiKikan(TextBoxDateRange txtNinteiKikan) {
        this.txtNinteiKikan = txtNinteiKikan;
    }

    /*
     * gettxtZiritudo
     * @return txtZiritudo
     */
    @JsonProperty("txtZiritudo")
    public TextBox getTxtZiritudo() {
        return txtZiritudo;
    }

    /*
     * settxtZiritudo
     * @param txtZiritudo txtZiritudo
     */
    @JsonProperty("txtZiritudo")
    public void setTxtZiritudo(TextBox txtZiritudo) {
        this.txtZiritudo = txtZiritudo;
    }

    /*
     * gettxtNyoushikkin
     * @return txtNyoushikkin
     */
    @JsonProperty("txtNyoushikkin")
    public TextBox getTxtNyoushikkin() {
        return txtNyoushikkin;
    }

    /*
     * settxtNyoushikkin
     * @param txtNyoushikkin txtNyoushikkin
     */
    @JsonProperty("txtNyoushikkin")
    public void setTxtNyoushikkin(TextBox txtNyoushikkin) {
        this.txtNyoushikkin = txtNyoushikkin;
    }

    /*
     * getccdBunshoBangoInput
     * @return ccdBunshoBangoInput
     */
    @JsonProperty("ccdBunshoBangoInput")
    public IBunshoBangoInputDiv getCcdBunshoBangoInput() {
        return ccdBunshoBangoInput;
    }

    // </editor-fold>
}
