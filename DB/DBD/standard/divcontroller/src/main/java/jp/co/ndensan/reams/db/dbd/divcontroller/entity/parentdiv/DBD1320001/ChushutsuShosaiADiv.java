package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1320001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChushutsuShosaiA のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChushutsuShosaiADiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlKijunNendo")
    private DropDownList ddlKijunNendo;
    @JsonProperty("chkChokkinNomiA")
    private CheckBoxList chkChokkinNomiA;
    @JsonProperty("txtKijunDateA")
    private TextBoxDate txtKijunDateA;
    @JsonProperty("lblKijyunDateSetumeiA")
    private Label lblKijyunDateSetumeiA;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlKijunNendo
     * @return ddlKijunNendo
     */
    @JsonProperty("ddlKijunNendo")
    public DropDownList getDdlKijunNendo() {
        return ddlKijunNendo;
    }

    /*
     * setddlKijunNendo
     * @param ddlKijunNendo ddlKijunNendo
     */
    @JsonProperty("ddlKijunNendo")
    public void setDdlKijunNendo(DropDownList ddlKijunNendo) {
        this.ddlKijunNendo = ddlKijunNendo;
    }

    /*
     * getchkChokkinNomiA
     * @return chkChokkinNomiA
     */
    @JsonProperty("chkChokkinNomiA")
    public CheckBoxList getChkChokkinNomiA() {
        return chkChokkinNomiA;
    }

    /*
     * setchkChokkinNomiA
     * @param chkChokkinNomiA chkChokkinNomiA
     */
    @JsonProperty("chkChokkinNomiA")
    public void setChkChokkinNomiA(CheckBoxList chkChokkinNomiA) {
        this.chkChokkinNomiA = chkChokkinNomiA;
    }

    /*
     * gettxtKijunDateA
     * @return txtKijunDateA
     */
    @JsonProperty("txtKijunDateA")
    public TextBoxDate getTxtKijunDateA() {
        return txtKijunDateA;
    }

    /*
     * settxtKijunDateA
     * @param txtKijunDateA txtKijunDateA
     */
    @JsonProperty("txtKijunDateA")
    public void setTxtKijunDateA(TextBoxDate txtKijunDateA) {
        this.txtKijunDateA = txtKijunDateA;
    }

    /*
     * getlblKijyunDateSetumeiA
     * @return lblKijyunDateSetumeiA
     */
    @JsonProperty("lblKijyunDateSetumeiA")
    public Label getLblKijyunDateSetumeiA() {
        return lblKijyunDateSetumeiA;
    }

    /*
     * setlblKijyunDateSetumeiA
     * @param lblKijyunDateSetumeiA lblKijyunDateSetumeiA
     */
    @JsonProperty("lblKijyunDateSetumeiA")
    public void setLblKijyunDateSetumeiA(Label lblKijyunDateSetumeiA) {
        this.lblKijyunDateSetumeiA = lblKijyunDateSetumeiA;
    }

    // </editor-fold>
}
