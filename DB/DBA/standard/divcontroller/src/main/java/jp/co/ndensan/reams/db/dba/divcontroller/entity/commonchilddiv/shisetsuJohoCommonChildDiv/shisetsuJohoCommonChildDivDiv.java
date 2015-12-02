package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.shisetsuJohoCommonChildDiv;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * shisetsuJohoCommonChildDiv のクラスファイル 
 * 
 * @author 自動生成
 */
public class shisetsuJohoCommonChildDivDiv extends Panel implements IshisetsuJohoCommonChildDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlDaichoShubetsu")
    private DropDownList ddlDaichoShubetsu;
    @JsonProperty("radKaigoHokenShisetsu")
    private RadioButton radKaigoHokenShisetsu;
    @JsonProperty("radOtherTokureiShisetsu")
    private RadioButton radOtherTokureiShisetsu;
    @JsonProperty("radTekiyoJyogaiShisetsu")
    private RadioButton radTekiyoJyogaiShisetsu;
    @JsonProperty("txtNyuryokuShisetsuKodo")
    private TextBox txtNyuryokuShisetsuKodo;
    @JsonProperty("btnJigyoshaKensaku")
    private ButtonDialog btnJigyoshaKensaku;
    @JsonProperty("txtNyuryokuShisetsuMeisho")
    private TextBox txtNyuryokuShisetsuMeisho;
    @JsonProperty("台帳種別")
    private RString 台帳種別;
    @JsonProperty("台帳種別表示")
    private RString 台帳種別表示;
    @JsonProperty("JigyoshaMode")
    private RString JigyoshaMode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlDaichoShubetsu
     * @return ddlDaichoShubetsu
     */
    @JsonProperty("ddlDaichoShubetsu")
    public DropDownList getDdlDaichoShubetsu() {
        return ddlDaichoShubetsu;
    }

    /*
     * setddlDaichoShubetsu
     * @param ddlDaichoShubetsu ddlDaichoShubetsu
     */
    @JsonProperty("ddlDaichoShubetsu")
    public void setDdlDaichoShubetsu(DropDownList ddlDaichoShubetsu) {
        this.ddlDaichoShubetsu = ddlDaichoShubetsu;
    }

    /*
     * getradKaigoHokenShisetsu
     * @return radKaigoHokenShisetsu
     */
    @JsonProperty("radKaigoHokenShisetsu")
    public RadioButton getRadKaigoHokenShisetsu() {
        return radKaigoHokenShisetsu;
    }

    /*
     * setradKaigoHokenShisetsu
     * @param radKaigoHokenShisetsu radKaigoHokenShisetsu
     */
    @JsonProperty("radKaigoHokenShisetsu")
    public void setRadKaigoHokenShisetsu(RadioButton radKaigoHokenShisetsu) {
        this.radKaigoHokenShisetsu = radKaigoHokenShisetsu;
    }

    /*
     * getradOtherTokureiShisetsu
     * @return radOtherTokureiShisetsu
     */
    @JsonProperty("radOtherTokureiShisetsu")
    public RadioButton getRadOtherTokureiShisetsu() {
        return radOtherTokureiShisetsu;
    }

    /*
     * setradOtherTokureiShisetsu
     * @param radOtherTokureiShisetsu radOtherTokureiShisetsu
     */
    @JsonProperty("radOtherTokureiShisetsu")
    public void setRadOtherTokureiShisetsu(RadioButton radOtherTokureiShisetsu) {
        this.radOtherTokureiShisetsu = radOtherTokureiShisetsu;
    }

    /*
     * getradTekiyoJyogaiShisetsu
     * @return radTekiyoJyogaiShisetsu
     */
    @JsonProperty("radTekiyoJyogaiShisetsu")
    public RadioButton getRadTekiyoJyogaiShisetsu() {
        return radTekiyoJyogaiShisetsu;
    }

    /*
     * setradTekiyoJyogaiShisetsu
     * @param radTekiyoJyogaiShisetsu radTekiyoJyogaiShisetsu
     */
    @JsonProperty("radTekiyoJyogaiShisetsu")
    public void setRadTekiyoJyogaiShisetsu(RadioButton radTekiyoJyogaiShisetsu) {
        this.radTekiyoJyogaiShisetsu = radTekiyoJyogaiShisetsu;
    }

    /*
     * gettxtNyuryokuShisetsuKodo
     * @return txtNyuryokuShisetsuKodo
     */
    @JsonProperty("txtNyuryokuShisetsuKodo")
    public TextBox getTxtNyuryokuShisetsuKodo() {
        return txtNyuryokuShisetsuKodo;
    }

    /*
     * settxtNyuryokuShisetsuKodo
     * @param txtNyuryokuShisetsuKodo txtNyuryokuShisetsuKodo
     */
    @JsonProperty("txtNyuryokuShisetsuKodo")
    public void setTxtNyuryokuShisetsuKodo(TextBox txtNyuryokuShisetsuKodo) {
        this.txtNyuryokuShisetsuKodo = txtNyuryokuShisetsuKodo;
    }

    /*
     * getbtnJigyoshaKensaku
     * @return btnJigyoshaKensaku
     */
    @JsonProperty("btnJigyoshaKensaku")
    public ButtonDialog getBtnJigyoshaKensaku() {
        return btnJigyoshaKensaku;
    }

    /*
     * setbtnJigyoshaKensaku
     * @param btnJigyoshaKensaku btnJigyoshaKensaku
     */
    @JsonProperty("btnJigyoshaKensaku")
    public void setBtnJigyoshaKensaku(ButtonDialog btnJigyoshaKensaku) {
        this.btnJigyoshaKensaku = btnJigyoshaKensaku;
    }

    /*
     * gettxtNyuryokuShisetsuMeisho
     * @return txtNyuryokuShisetsuMeisho
     */
    @JsonProperty("txtNyuryokuShisetsuMeisho")
    public TextBox getTxtNyuryokuShisetsuMeisho() {
        return txtNyuryokuShisetsuMeisho;
    }

    /*
     * settxtNyuryokuShisetsuMeisho
     * @param txtNyuryokuShisetsuMeisho txtNyuryokuShisetsuMeisho
     */
    @JsonProperty("txtNyuryokuShisetsuMeisho")
    public void setTxtNyuryokuShisetsuMeisho(TextBox txtNyuryokuShisetsuMeisho) {
        this.txtNyuryokuShisetsuMeisho = txtNyuryokuShisetsuMeisho;
    }

    /*
     * get台帳種別
     * @return 台帳種別
     */
    @JsonProperty("台帳種別")
    public RString get台帳種別() {
        return 台帳種別;
    }

    /*
     * set台帳種別
     * @param 台帳種別 台帳種別
     */
    @JsonProperty("台帳種別")
    public void set台帳種別(RString 台帳種別) {
        this.台帳種別 = 台帳種別;
    }

    /*
     * get台帳種別表示
     * @return 台帳種別表示
     */
    @JsonProperty("台帳種別表示")
    public RString get台帳種別表示() {
        return 台帳種別表示;
    }

    /*
     * set台帳種別表示
     * @param 台帳種別表示 台帳種別表示
     */
    @JsonProperty("台帳種別表示")
    public void set台帳種別表示(RString 台帳種別表示) {
        this.台帳種別表示 = 台帳種別表示;
    }

    /*
     * getJigyoshaMode
     * @return JigyoshaMode
     */
    @JsonProperty("JigyoshaMode")
    public RString getJigyoshaMode() {
        return JigyoshaMode;
    }

    /*
     * setJigyoshaMode
     * @param JigyoshaMode JigyoshaMode
     */
    @JsonProperty("JigyoshaMode")
    public void setJigyoshaMode(RString JigyoshaMode) {
        this.JigyoshaMode = JigyoshaMode;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
