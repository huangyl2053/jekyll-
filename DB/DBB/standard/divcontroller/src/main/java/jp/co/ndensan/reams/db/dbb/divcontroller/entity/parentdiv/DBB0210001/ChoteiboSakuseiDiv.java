package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0210001;
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
 * ChoteiboSakusei のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChoteiboSakuseiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-16_12-38-19">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ChoteiboSakuseiParameter")
    private ChoteiboSakuseiParameterDiv ChoteiboSakuseiParameter;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getChoteiboSakuseiParameter
     * @return ChoteiboSakuseiParameter
     */
    @JsonProperty("ChoteiboSakuseiParameter")
    public ChoteiboSakuseiParameterDiv getChoteiboSakuseiParameter() {
        return ChoteiboSakuseiParameter;
    }

    /*
     * setChoteiboSakuseiParameter
     * @param ChoteiboSakuseiParameter ChoteiboSakuseiParameter
     */
    @JsonProperty("ChoteiboSakuseiParameter")
    public void setChoteiboSakuseiParameter(ChoteiboSakuseiParameterDiv ChoteiboSakuseiParameter) {
        this.ChoteiboSakuseiParameter = ChoteiboSakuseiParameter;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlShoriNendo() {
        return this.getChoteiboSakuseiParameter().getDdlShoriNendo();
    }

    @JsonIgnore
    public void  setDdlShoriNendo(DropDownList ddlShoriNendo) {
        this.getChoteiboSakuseiParameter().setDdlShoriNendo(ddlShoriNendo);
    }

    @JsonIgnore
    public HorizontalLine getLin1() {
        return this.getChoteiboSakuseiParameter().getLin1();
    }

    @JsonIgnore
    public void  setLin1(HorizontalLine lin1) {
        this.getChoteiboSakuseiParameter().setLin1(lin1);
    }

    @JsonIgnore
    public Label getLblChushutsuStYMD() {
        return this.getChoteiboSakuseiParameter().getLblChushutsuStYMD();
    }

    @JsonIgnore
    public void  setLblChushutsuStYMD(Label lblChushutsuStYMD) {
        this.getChoteiboSakuseiParameter().setLblChushutsuStYMD(lblChushutsuStYMD);
    }

    @JsonIgnore
    public Label getLblChushutsuStTime() {
        return this.getChoteiboSakuseiParameter().getLblChushutsuStTime();
    }

    @JsonIgnore
    public void  setLblChushutsuStTime(Label lblChushutsuStTime) {
        this.getChoteiboSakuseiParameter().setLblChushutsuStTime(lblChushutsuStTime);
    }

    @JsonIgnore
    public Label getLblChushutsuEdYMD() {
        return this.getChoteiboSakuseiParameter().getLblChushutsuEdYMD();
    }

    @JsonIgnore
    public void  setLblChushutsuEdYMD(Label lblChushutsuEdYMD) {
        this.getChoteiboSakuseiParameter().setLblChushutsuEdYMD(lblChushutsuEdYMD);
    }

    @JsonIgnore
    public Label getLblChushutsuEdTime() {
        return this.getChoteiboSakuseiParameter().getLblChushutsuEdTime();
    }

    @JsonIgnore
    public void  setLblChushutsuEdTime(Label lblChushutsuEdTime) {
        this.getChoteiboSakuseiParameter().setLblChushutsuEdTime(lblChushutsuEdTime);
    }

    @JsonIgnore
    public TextBoxDate getTxtChushutsuStYMD() {
        return this.getChoteiboSakuseiParameter().getTxtChushutsuStYMD();
    }

    @JsonIgnore
    public void  setTxtChushutsuStYMD(TextBoxDate txtChushutsuStYMD) {
        this.getChoteiboSakuseiParameter().setTxtChushutsuStYMD(txtChushutsuStYMD);
    }

    @JsonIgnore
    public TextBoxTime getTxtChushutsuStTime() {
        return this.getChoteiboSakuseiParameter().getTxtChushutsuStTime();
    }

    @JsonIgnore
    public void  setTxtChushutsuStTime(TextBoxTime txtChushutsuStTime) {
        this.getChoteiboSakuseiParameter().setTxtChushutsuStTime(txtChushutsuStTime);
    }

    @JsonIgnore
    public Label getLblFugou() {
        return this.getChoteiboSakuseiParameter().getLblFugou();
    }

    @JsonIgnore
    public void  setLblFugou(Label lblFugou) {
        this.getChoteiboSakuseiParameter().setLblFugou(lblFugou);
    }

    @JsonIgnore
    public TextBoxDate getTxtChushutsuEdYMD() {
        return this.getChoteiboSakuseiParameter().getTxtChushutsuEdYMD();
    }

    @JsonIgnore
    public void  setTxtChushutsuEdYMD(TextBoxDate txtChushutsuEdYMD) {
        this.getChoteiboSakuseiParameter().setTxtChushutsuEdYMD(txtChushutsuEdYMD);
    }

    @JsonIgnore
    public TextBoxTime getTxtChushutsuEdTime() {
        return this.getChoteiboSakuseiParameter().getTxtChushutsuEdTime();
    }

    @JsonIgnore
    public void  setTxtChushutsuEdTime(TextBoxTime txtChushutsuEdTime) {
        this.getChoteiboSakuseiParameter().setTxtChushutsuEdTime(txtChushutsuEdTime);
    }

    // </editor-fold>
}
