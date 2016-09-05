package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2800011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * JukyushaTotsugoIraiJohoSakusei のクラスファイル 
 * 
 * @author 自動生成
 */
public class JukyushaTotsugoIraiJohoSakuseiDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlChushutsuKubun")
    private DropDownList ddlChushutsuKubun;
    @JsonProperty("txtTaishoYM")
    private TextBoxDateRange txtTaishoYM;
    @JsonProperty("txtNinteiYM")
    private TextBoxDate txtNinteiYM;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlChushutsuKubun
     * @return ddlChushutsuKubun
     */
    @JsonProperty("ddlChushutsuKubun")
    public DropDownList getDdlChushutsuKubun() {
        return ddlChushutsuKubun;
    }

    /*
     * setddlChushutsuKubun
     * @param ddlChushutsuKubun ddlChushutsuKubun
     */
    @JsonProperty("ddlChushutsuKubun")
    public void setDdlChushutsuKubun(DropDownList ddlChushutsuKubun) {
        this.ddlChushutsuKubun = ddlChushutsuKubun;
    }

    /*
     * gettxtTaishoYM
     * @return txtTaishoYM
     */
    @JsonProperty("txtTaishoYM")
    public TextBoxDateRange getTxtTaishoYM() {
        return txtTaishoYM;
    }

    /*
     * settxtTaishoYM
     * @param txtTaishoYM txtTaishoYM
     */
    @JsonProperty("txtTaishoYM")
    public void setTxtTaishoYM(TextBoxDateRange txtTaishoYM) {
        this.txtTaishoYM = txtTaishoYM;
    }

    /*
     * gettxtNinteiYM
     * @return txtNinteiYM
     */
    @JsonProperty("txtNinteiYM")
    public TextBoxDate getTxtNinteiYM() {
        return txtNinteiYM;
    }

    /*
     * settxtNinteiYM
     * @param txtNinteiYM txtNinteiYM
     */
    @JsonProperty("txtNinteiYM")
    public void setTxtNinteiYM(TextBoxDate txtNinteiYM) {
        this.txtNinteiYM = txtNinteiYM;
    }

    // </editor-fold>
}
