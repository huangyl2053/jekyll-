package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KyufuJissekiChushutsuHani のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyufuJissekiChushutsuHaniDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radNendo")
    private RadioButton radNendo;
    @JsonProperty("ddlKyufuJissekiSearchNendo")
    private DropDownList ddlKyufuJissekiSearchNendo;
    @JsonProperty("radKyufuJissekiSearchDateType")
    private RadioButton radKyufuJissekiSearchDateType;
    @JsonProperty("txtKyufuJissekiSearchServiceTeikyoYM")
    private TextBoxDateRange txtKyufuJissekiSearchServiceTeikyoYM;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradNendo
     * @return radNendo
     */
    @JsonProperty("radNendo")
    public RadioButton getRadNendo() {
        return radNendo;
    }

    /*
     * setradNendo
     * @param radNendo radNendo
     */
    @JsonProperty("radNendo")
    public void setRadNendo(RadioButton radNendo) {
        this.radNendo = radNendo;
    }

    /*
     * getddlKyufuJissekiSearchNendo
     * @return ddlKyufuJissekiSearchNendo
     */
    @JsonProperty("ddlKyufuJissekiSearchNendo")
    public DropDownList getDdlKyufuJissekiSearchNendo() {
        return ddlKyufuJissekiSearchNendo;
    }

    /*
     * setddlKyufuJissekiSearchNendo
     * @param ddlKyufuJissekiSearchNendo ddlKyufuJissekiSearchNendo
     */
    @JsonProperty("ddlKyufuJissekiSearchNendo")
    public void setDdlKyufuJissekiSearchNendo(DropDownList ddlKyufuJissekiSearchNendo) {
        this.ddlKyufuJissekiSearchNendo = ddlKyufuJissekiSearchNendo;
    }

    /*
     * getradKyufuJissekiSearchDateType
     * @return radKyufuJissekiSearchDateType
     */
    @JsonProperty("radKyufuJissekiSearchDateType")
    public RadioButton getRadKyufuJissekiSearchDateType() {
        return radKyufuJissekiSearchDateType;
    }

    /*
     * setradKyufuJissekiSearchDateType
     * @param radKyufuJissekiSearchDateType radKyufuJissekiSearchDateType
     */
    @JsonProperty("radKyufuJissekiSearchDateType")
    public void setRadKyufuJissekiSearchDateType(RadioButton radKyufuJissekiSearchDateType) {
        this.radKyufuJissekiSearchDateType = radKyufuJissekiSearchDateType;
    }

    /*
     * gettxtKyufuJissekiSearchServiceTeikyoYM
     * @return txtKyufuJissekiSearchServiceTeikyoYM
     */
    @JsonProperty("txtKyufuJissekiSearchServiceTeikyoYM")
    public TextBoxDateRange getTxtKyufuJissekiSearchServiceTeikyoYM() {
        return txtKyufuJissekiSearchServiceTeikyoYM;
    }

    /*
     * settxtKyufuJissekiSearchServiceTeikyoYM
     * @param txtKyufuJissekiSearchServiceTeikyoYM txtKyufuJissekiSearchServiceTeikyoYM
     */
    @JsonProperty("txtKyufuJissekiSearchServiceTeikyoYM")
    public void setTxtKyufuJissekiSearchServiceTeikyoYM(TextBoxDateRange txtKyufuJissekiSearchServiceTeikyoYM) {
        this.txtKyufuJissekiSearchServiceTeikyoYM = txtKyufuJissekiSearchServiceTeikyoYM;
    }

    // </editor-fold>
}
