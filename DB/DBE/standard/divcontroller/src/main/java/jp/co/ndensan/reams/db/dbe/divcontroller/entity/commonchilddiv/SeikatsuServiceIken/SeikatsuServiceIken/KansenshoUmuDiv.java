package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.SeikatsuServiceIken.SeikatsuServiceIken;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KansenshoUmu のクラスファイル 
 * 
 */
public class KansenshoUmuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-16_10-13-04">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radKansenshoUmu")
    private RadioButton radKansenshoUmu;
    @JsonProperty("spSpace1")
    private Space spSpace1;
    @JsonProperty("txtKansenshoShosai")
    private TextBox txtKansenshoShosai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradKansenshoUmu
     * @return radKansenshoUmu
     */
    @JsonProperty("radKansenshoUmu")
    public RadioButton getRadKansenshoUmu() {
        return radKansenshoUmu;
    }

    /*
     * setradKansenshoUmu
     * @param radKansenshoUmu radKansenshoUmu
     */
    @JsonProperty("radKansenshoUmu")
    public void setRadKansenshoUmu(RadioButton radKansenshoUmu) {
        this.radKansenshoUmu = radKansenshoUmu;
    }

    /*
     * getspSpace1
     * @return spSpace1
     */
    @JsonProperty("spSpace1")
    public Space getSpSpace1() {
        return spSpace1;
    }

    /*
     * setspSpace1
     * @param spSpace1 spSpace1
     */
    @JsonProperty("spSpace1")
    public void setSpSpace1(Space spSpace1) {
        this.spSpace1 = spSpace1;
    }

    /*
     * gettxtKansenshoShosai
     * @return txtKansenshoShosai
     */
    @JsonProperty("txtKansenshoShosai")
    public TextBox getTxtKansenshoShosai() {
        return txtKansenshoShosai;
    }

    /*
     * settxtKansenshoShosai
     * @param txtKansenshoShosai txtKansenshoShosai
     */
    @JsonProperty("txtKansenshoShosai")
    public void setTxtKansenshoShosai(TextBox txtKansenshoShosai) {
        this.txtKansenshoShosai = txtKansenshoShosai;
    }

    // </editor-fold>
}
