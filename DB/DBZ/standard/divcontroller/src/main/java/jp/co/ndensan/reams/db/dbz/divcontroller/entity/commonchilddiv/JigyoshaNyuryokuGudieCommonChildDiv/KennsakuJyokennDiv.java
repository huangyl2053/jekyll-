package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.JigyoshaNyuryokuGudieCommonChildDiv;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KennsakuJyokenn のクラスファイル 
 * 
 * @author 自動生成
 */
public class KennsakuJyokennDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtJIgyoshaNo")
    private TextBox txtJIgyoshaNo;
    @JsonProperty("txtYukouKaishibi")
    private TextBoxDateRange txtYukouKaishibi;
    @JsonProperty("txtJigyoshamei")
    private TextBox txtJigyoshamei;
    @JsonProperty("ddlKennsakuKubun")
    private DropDownList ddlKennsakuKubun;
    @JsonProperty("txtYubinNo")
    private TextBoxYubinNo txtYubinNo;
    @JsonProperty("txtJusho")
    private TextBoxJusho txtJusho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtJIgyoshaNo
     * @return txtJIgyoshaNo
     */
    @JsonProperty("txtJIgyoshaNo")
    public TextBox getTxtJIgyoshaNo() {
        return txtJIgyoshaNo;
    }

    /*
     * settxtJIgyoshaNo
     * @param txtJIgyoshaNo txtJIgyoshaNo
     */
    @JsonProperty("txtJIgyoshaNo")
    public void setTxtJIgyoshaNo(TextBox txtJIgyoshaNo) {
        this.txtJIgyoshaNo = txtJIgyoshaNo;
    }

    /*
     * gettxtYukouKaishibi
     * @return txtYukouKaishibi
     */
    @JsonProperty("txtYukouKaishibi")
    public TextBoxDateRange getTxtYukouKaishibi() {
        return txtYukouKaishibi;
    }

    /*
     * settxtYukouKaishibi
     * @param txtYukouKaishibi txtYukouKaishibi
     */
    @JsonProperty("txtYukouKaishibi")
    public void setTxtYukouKaishibi(TextBoxDateRange txtYukouKaishibi) {
        this.txtYukouKaishibi = txtYukouKaishibi;
    }

    /*
     * gettxtJigyoshamei
     * @return txtJigyoshamei
     */
    @JsonProperty("txtJigyoshamei")
    public TextBox getTxtJigyoshamei() {
        return txtJigyoshamei;
    }

    /*
     * settxtJigyoshamei
     * @param txtJigyoshamei txtJigyoshamei
     */
    @JsonProperty("txtJigyoshamei")
    public void setTxtJigyoshamei(TextBox txtJigyoshamei) {
        this.txtJigyoshamei = txtJigyoshamei;
    }

    /*
     * getddlKennsakuKubun
     * @return ddlKennsakuKubun
     */
    @JsonProperty("ddlKennsakuKubun")
    public DropDownList getDdlKennsakuKubun() {
        return ddlKennsakuKubun;
    }

    /*
     * setddlKennsakuKubun
     * @param ddlKennsakuKubun ddlKennsakuKubun
     */
    @JsonProperty("ddlKennsakuKubun")
    public void setDdlKennsakuKubun(DropDownList ddlKennsakuKubun) {
        this.ddlKennsakuKubun = ddlKennsakuKubun;
    }

    /*
     * gettxtYubinNo
     * @return txtYubinNo
     */
    @JsonProperty("txtYubinNo")
    public TextBoxYubinNo getTxtYubinNo() {
        return txtYubinNo;
    }

    /*
     * settxtYubinNo
     * @param txtYubinNo txtYubinNo
     */
    @JsonProperty("txtYubinNo")
    public void setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.txtYubinNo = txtYubinNo;
    }

    /*
     * gettxtJusho
     * @return txtJusho
     */
    @JsonProperty("txtJusho")
    public TextBoxJusho getTxtJusho() {
        return txtJusho;
    }

    /*
     * settxtJusho
     * @param txtJusho txtJusho
     */
    @JsonProperty("txtJusho")
    public void setTxtJusho(TextBoxJusho txtJusho) {
        this.txtJusho = txtJusho;
    }

    // </editor-fold>
}
