package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1080001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * ShinseishoHakkoTaishoshaHaakuParameterMain のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinseishoHakkoTaishoshaHaakuParameterMainDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("Parameters")
    private ParametersDiv Parameters;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getParameters
     * @return Parameters
     */
    @JsonProperty("Parameters")
    public ParametersDiv getParameters() {
        return Parameters;
    }

    /*
     * setParameters
     * @param Parameters Parameters
     */
    @JsonProperty("Parameters")
    public void setParameters(ParametersDiv Parameters) {
        this.Parameters = Parameters;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlKyushochishaKubun1() {
        return this.getParameters().getFutanGendogakuNinteiParameter().getDdlKyushochishaKubun1();
    }

    @JsonIgnore
    public void  setDdlKyushochishaKubun1(DropDownList ddlKyushochishaKubun1) {
        this.getParameters().getFutanGendogakuNinteiParameter().setDdlKyushochishaKubun1(ddlKyushochishaKubun1);
    }

    @JsonIgnore
    public RadioButton getRadShisetsuNyushoKubun1() {
        return this.getParameters().getFutanGendogakuNinteiParameter().getRadShisetsuNyushoKubun1();
    }

    @JsonIgnore
    public void  setRadShisetsuNyushoKubun1(RadioButton radShisetsuNyushoKubun1) {
        this.getParameters().getFutanGendogakuNinteiParameter().setRadShisetsuNyushoKubun1(radShisetsuNyushoKubun1);
    }

    @JsonIgnore
    public DropDownList getDdlRiyoshaFutanDankai() {
        return this.getParameters().getFutanGendogakuNinteiParameter().getDdlRiyoshaFutanDankai();
    }

    @JsonIgnore
    public void  setDdlRiyoshaFutanDankai(DropDownList ddlRiyoshaFutanDankai) {
        this.getParameters().getFutanGendogakuNinteiParameter().setDdlRiyoshaFutanDankai(ddlRiyoshaFutanDankai);
    }

    @JsonIgnore
    public DropDownList getDdlKyushochishaKubun2() {
        return this.getParameters().getOtherParameter().getDdlKyushochishaKubun2();
    }

    @JsonIgnore
    public void  setDdlKyushochishaKubun2(DropDownList ddlKyushochishaKubun2) {
        this.getParameters().getOtherParameter().setDdlKyushochishaKubun2(ddlKyushochishaKubun2);
    }

    @JsonIgnore
    public RadioButton getDdlShinsetsuNyushoKubun2() {
        return this.getParameters().getOtherParameter().getDdlShinsetsuNyushoKubun2();
    }

    @JsonIgnore
    public void  setDdlShinsetsuNyushoKubun2(RadioButton ddlShinsetsuNyushoKubun2) {
        this.getParameters().getOtherParameter().setDdlShinsetsuNyushoKubun2(ddlShinsetsuNyushoKubun2);
    }

    @JsonIgnore
    public CheckBoxList getChkIsHikazeiSetai() {
        return this.getParameters().getOtherParameter().getChkIsHikazeiSetai();
    }

    @JsonIgnore
    public void  setChkIsHikazeiSetai(CheckBoxList chkIsHikazeiSetai) {
        this.getParameters().getOtherParameter().setChkIsHikazeiSetai(chkIsHikazeiSetai);
    }

    @JsonIgnore
    public CheckBoxList getChkIsHikazei() {
        return this.getParameters().getOtherParameter().getChkIsHikazei();
    }

    @JsonIgnore
    public void  setChkIsHikazei(CheckBoxList chkIsHikazei) {
        this.getParameters().getOtherParameter().setChkIsHikazei(chkIsHikazei);
    }

    @JsonIgnore
    public CheckBoxList getChkIsRoreiJukyusha() {
        return this.getParameters().getOtherParameter().getChkIsRoreiJukyusha();
    }

    @JsonIgnore
    public void  setChkIsRoreiJukyusha(CheckBoxList chkIsRoreiJukyusha) {
        this.getParameters().getOtherParameter().setChkIsRoreiJukyusha(chkIsRoreiJukyusha);
    }

    @JsonIgnore
    public CheckBoxList getChkIsSeihoJukyusha() {
        return this.getParameters().getOtherParameter().getChkIsSeihoJukyusha();
    }

    @JsonIgnore
    public void  setChkIsSeihoJukyusha(CheckBoxList chkIsSeihoJukyusha) {
        this.getParameters().getOtherParameter().setChkIsSeihoJukyusha(chkIsSeihoJukyusha);
    }

    // </editor-fold>
}
