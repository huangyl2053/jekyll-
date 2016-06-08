package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1300001;
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
 * ChushutsuJokenPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChushutsuJokenPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlChushutsuData")
    private DropDownList ddlChushutsuData;
    @JsonProperty("chkTorikeshiSakujo")
    private CheckBoxList chkTorikeshiSakujo;
    @JsonProperty("ddlSoushitsuKubun")
    private DropDownList ddlSoushitsuKubun;
    @JsonProperty("radChushutsuTaisho")
    private RadioButton radChushutsuTaisho;
    @JsonProperty("ChushutsuPanel")
    private ChushutsuPanelDiv ChushutsuPanel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlChushutsuData
     * @return ddlChushutsuData
     */
    @JsonProperty("ddlChushutsuData")
    public DropDownList getDdlChushutsuData() {
        return ddlChushutsuData;
    }

    /*
     * setddlChushutsuData
     * @param ddlChushutsuData ddlChushutsuData
     */
    @JsonProperty("ddlChushutsuData")
    public void setDdlChushutsuData(DropDownList ddlChushutsuData) {
        this.ddlChushutsuData = ddlChushutsuData;
    }

    /*
     * getchkTorikeshiSakujo
     * @return chkTorikeshiSakujo
     */
    @JsonProperty("chkTorikeshiSakujo")
    public CheckBoxList getChkTorikeshiSakujo() {
        return chkTorikeshiSakujo;
    }

    /*
     * setchkTorikeshiSakujo
     * @param chkTorikeshiSakujo chkTorikeshiSakujo
     */
    @JsonProperty("chkTorikeshiSakujo")
    public void setChkTorikeshiSakujo(CheckBoxList chkTorikeshiSakujo) {
        this.chkTorikeshiSakujo = chkTorikeshiSakujo;
    }

    /*
     * getddlSoushitsuKubun
     * @return ddlSoushitsuKubun
     */
    @JsonProperty("ddlSoushitsuKubun")
    public DropDownList getDdlSoushitsuKubun() {
        return ddlSoushitsuKubun;
    }

    /*
     * setddlSoushitsuKubun
     * @param ddlSoushitsuKubun ddlSoushitsuKubun
     */
    @JsonProperty("ddlSoushitsuKubun")
    public void setDdlSoushitsuKubun(DropDownList ddlSoushitsuKubun) {
        this.ddlSoushitsuKubun = ddlSoushitsuKubun;
    }

    /*
     * getradChushutsuTaisho
     * @return radChushutsuTaisho
     */
    @JsonProperty("radChushutsuTaisho")
    public RadioButton getRadChushutsuTaisho() {
        return radChushutsuTaisho;
    }

    /*
     * setradChushutsuTaisho
     * @param radChushutsuTaisho radChushutsuTaisho
     */
    @JsonProperty("radChushutsuTaisho")
    public void setRadChushutsuTaisho(RadioButton radChushutsuTaisho) {
        this.radChushutsuTaisho = radChushutsuTaisho;
    }

    /*
     * getChushutsuPanel
     * @return ChushutsuPanel
     */
    @JsonProperty("ChushutsuPanel")
    public ChushutsuPanelDiv getChushutsuPanel() {
        return ChushutsuPanel;
    }

    /*
     * setChushutsuPanel
     * @param ChushutsuPanel ChushutsuPanel
     */
    @JsonProperty("ChushutsuPanel")
    public void setChushutsuPanel(ChushutsuPanelDiv ChushutsuPanel) {
        this.ChushutsuPanel = ChushutsuPanel;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlChushutsuYmd() {
        return this.getChushutsuPanel().getDdlChushutsuYmd();
    }

    @JsonIgnore
    public void  setDdlChushutsuYmd(DropDownList ddlChushutsuYmd) {
        this.getChushutsuPanel().setDdlChushutsuYmd(ddlChushutsuYmd);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtChushutsuYMD() {
        return this.getChushutsuPanel().getTxtChushutsuYMD();
    }

    @JsonIgnore
    public void  setTxtChushutsuYMD(TextBoxDateRange txtChushutsuYMD) {
        this.getChushutsuPanel().setTxtChushutsuYMD(txtChushutsuYMD);
    }

    @JsonIgnore
    public TextBoxNumRange getTxtIryokikan() {
        return this.getChushutsuPanel().getTxtIryokikan();
    }

    @JsonIgnore
    public void  setTxtIryokikan(TextBoxNumRange txtIryokikan) {
        this.getChushutsuPanel().setTxtIryokikan(txtIryokikan);
    }

    @JsonIgnore
    public TextBoxNumRange getTxtChosaItakusaki() {
        return this.getChushutsuPanel().getTxtChosaItakusaki();
    }

    @JsonIgnore
    public void  setTxtChosaItakusaki(TextBoxNumRange txtChosaItakusaki) {
        this.getChushutsuPanel().setTxtChosaItakusaki(txtChosaItakusaki);
    }

    // </editor-fold>
}
