package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxYear;

/**
 * ShinNendoKanriJohoSakusei のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinNendoKanriJohoSakuseiDiv extends Panel {
     
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShinNendoKanriJohoSakuseiBatchParameter")
    private ShinNendoKanriJohoSakuseiBatchParameterDiv ShinNendoKanriJohoSakuseiBatchParameter;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShinNendoKanriJohoSakuseiBatchParameter
     * @return ShinNendoKanriJohoSakuseiBatchParameter
     */
    @JsonProperty("ShinNendoKanriJohoSakuseiBatchParameter")
    public ShinNendoKanriJohoSakuseiBatchParameterDiv getShinNendoKanriJohoSakuseiBatchParameter() {
        return ShinNendoKanriJohoSakuseiBatchParameter;
    }

    /*
     * setShinNendoKanriJohoSakuseiBatchParameter
     * @param ShinNendoKanriJohoSakuseiBatchParameter ShinNendoKanriJohoSakuseiBatchParameter
     */
    @JsonProperty("ShinNendoKanriJohoSakuseiBatchParameter")
    public void setShinNendoKanriJohoSakuseiBatchParameter(ShinNendoKanriJohoSakuseiBatchParameterDiv ShinNendoKanriJohoSakuseiBatchParameter) {
        this.ShinNendoKanriJohoSakuseiBatchParameter = ShinNendoKanriJohoSakuseiBatchParameter;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblMessage() {
        return this.getShinNendoKanriJohoSakuseiBatchParameter().getLblMessage();
    }

    @JsonIgnore
    public void  setLblMessage(Label lblMessage) {
        this.getShinNendoKanriJohoSakuseiBatchParameter().setLblMessage(lblMessage);
    }

    @JsonIgnore
    public HorizontalLine getLin1() {
        return this.getShinNendoKanriJohoSakuseiBatchParameter().getLin1();
    }

    @JsonIgnore
    public void  setLin1(HorizontalLine lin1) {
        this.getShinNendoKanriJohoSakuseiBatchParameter().setLin1(lin1);
    }

   

    @JsonIgnore
    public Label getLblYajirushi() {
        return this.getShinNendoKanriJohoSakuseiBatchParameter().getLblYajirushi();
    }

    @JsonIgnore
    public void  setLblYajirushi(Label lblYajirushi) {
        this.getShinNendoKanriJohoSakuseiBatchParameter().setLblYajirushi(lblYajirushi);
    }

    @JsonIgnore
    public TextBox getTxtShiNendo() {
        return this.getShinNendoKanriJohoSakuseiBatchParameter().getTxtShiNendo();
    }

    @JsonIgnore
    public void  setTxtShiNendo(TextBox txtShiNendo) {
        this.getShinNendoKanriJohoSakuseiBatchParameter().setTxtShiNendo(txtShiNendo);
    }

    // </editor-fold>

    public Object getShinNendoKanriJohoSakuseiShoriNaiyo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
