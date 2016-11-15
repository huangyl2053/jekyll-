package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shichosonSelector.shichosonSelector;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;

/**
 * ShichosonSelector のクラスファイル
 *
 */
public class ShichosonSelectorDiv extends Panel implements IShichosonSelectorDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radShichosonKubun")
    private RadioButton radShichosonKubun;
    @JsonProperty("dgShichoson")
    private DataGrid<dgShichoson_Row> dgShichoson;
    @JsonProperty("btnReturn")
    private Button btnReturn;
    @JsonProperty("btnDecision")
    private Button btnDecision;
    @JsonProperty("kyuShichoson")
    private RString kyuShichoson;
    @JsonProperty("kijun")
    private RString kijun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradShichosonKubun
     * @return radShichosonKubun
     */
    @JsonProperty("radShichosonKubun")
    public RadioButton getRadShichosonKubun() {
        return radShichosonKubun;
    }

    /*
     * setradShichosonKubun
     * @param radShichosonKubun radShichosonKubun
     */
    @JsonProperty("radShichosonKubun")
    public void setRadShichosonKubun(RadioButton radShichosonKubun) {
        this.radShichosonKubun = radShichosonKubun;
    }

    /*
     * getdgShichoson
     * @return dgShichoson
     */
    @JsonProperty("dgShichoson")
    public DataGrid<dgShichoson_Row> getDgShichoson() {
        return dgShichoson;
    }

    /*
     * setdgShichoson
     * @param dgShichoson dgShichoson
     */
    @JsonProperty("dgShichoson")
    public void setDgShichoson(DataGrid<dgShichoson_Row> dgShichoson) {
        this.dgShichoson = dgShichoson;
    }

    /*
     * getbtnReturn
     * @return btnReturn
     */
    @JsonProperty("btnReturn")
    public Button getBtnReturn() {
        return btnReturn;
    }

    /*
     * setbtnReturn
     * @param btnReturn btnReturn
     */
    @JsonProperty("btnReturn")
    public void setBtnReturn(Button btnReturn) {
        this.btnReturn = btnReturn;
    }

    /*
     * getbtnDecision
     * @return btnDecision
     */
    @JsonProperty("btnDecision")
    public Button getBtnDecision() {
        return btnDecision;
    }

    /*
     * setbtnDecision
     * @param btnDecision btnDecision
     */
    @JsonProperty("btnDecision")
    public void setBtnDecision(Button btnDecision) {
        this.btnDecision = btnDecision;
    }

    /*
     * getkyuShichoson
     * @return kyuShichoson
     */
    @JsonProperty("kyuShichoson")
    public RString getKyuShichoson() {
        return kyuShichoson;
    }

    /*
     * setkyuShichoson
     * @param kyuShichoson kyuShichoson
     */
    @JsonProperty("kyuShichoson")
    public void setKyuShichoson(RString kyuShichoson) {
        this.kyuShichoson = kyuShichoson;
    }

    /*
     * getkijun
     * @return kijun
     */
    @JsonProperty("kijun")
    public RString getKijun() {
        return kijun;
    }

    /*
     * setkijun
     * @param kijun kijun
     */
    @JsonProperty("kijun")
    public void setKijun(RString kijun) {
        this.kijun = kijun;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
