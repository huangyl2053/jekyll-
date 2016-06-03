package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.JukyushaIdoRenrakuhyo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JukyushaIdoRenrakuhyoTeisei のクラスファイル 
 * 
 * @author 自動生成
 */
public class JukyushaIdoRenrakuhyoTeiseiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTeiseiYMD")
    private TextBoxDate txtTeiseiYMD;
    @JsonProperty("radTeiseiKubunCode")
    private RadioButton radTeiseiKubunCode;
    @JsonProperty("lin3")
    private HorizontalLine lin3;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtTeiseiYMD
     * @return txtTeiseiYMD
     */
    @JsonProperty("txtTeiseiYMD")
    public TextBoxDate getTxtTeiseiYMD() {
        return txtTeiseiYMD;
    }

    /*
     * settxtTeiseiYMD
     * @param txtTeiseiYMD txtTeiseiYMD
     */
    @JsonProperty("txtTeiseiYMD")
    public void setTxtTeiseiYMD(TextBoxDate txtTeiseiYMD) {
        this.txtTeiseiYMD = txtTeiseiYMD;
    }

    /*
     * getradTeiseiKubunCode
     * @return radTeiseiKubunCode
     */
    @JsonProperty("radTeiseiKubunCode")
    public RadioButton getRadTeiseiKubunCode() {
        return radTeiseiKubunCode;
    }

    /*
     * setradTeiseiKubunCode
     * @param radTeiseiKubunCode radTeiseiKubunCode
     */
    @JsonProperty("radTeiseiKubunCode")
    public void setRadTeiseiKubunCode(RadioButton radTeiseiKubunCode) {
        this.radTeiseiKubunCode = radTeiseiKubunCode;
    }

    /*
     * getlin3
     * @return lin3
     */
    @JsonProperty("lin3")
    public HorizontalLine getLin3() {
        return lin3;
    }

    /*
     * setlin3
     * @param lin3 lin3
     */
    @JsonProperty("lin3")
    public void setLin3(HorizontalLine lin3) {
        this.lin3 = lin3;
    }

    // </editor-fold>
}
