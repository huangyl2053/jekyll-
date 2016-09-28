package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5100011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * RiyojokyoJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class RiyojokyoJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radRiyoJisseki")
    private RadioButton radRiyoJisseki;
    @JsonProperty("radKyotakuRiyoritsu")
    private RadioButton radKyotakuRiyoritsu;
    @JsonProperty("txtKyotakuRiyoritsuRange")
    private TextBoxNumRange txtKyotakuRiyoritsuRange;
    @JsonProperty("radHomonRiyoritsu")
    private RadioButton radHomonRiyoritsu;
    @JsonProperty("txtHomonRiyoritsuRange")
    private TextBoxNumRange txtHomonRiyoritsuRange;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradRiyoJisseki
     * @return radRiyoJisseki
     */
    @JsonProperty("radRiyoJisseki")
    public RadioButton getRadRiyoJisseki() {
        return radRiyoJisseki;
    }

    /*
     * setradRiyoJisseki
     * @param radRiyoJisseki radRiyoJisseki
     */
    @JsonProperty("radRiyoJisseki")
    public void setRadRiyoJisseki(RadioButton radRiyoJisseki) {
        this.radRiyoJisseki = radRiyoJisseki;
    }

    /*
     * getradKyotakuRiyoritsu
     * @return radKyotakuRiyoritsu
     */
    @JsonProperty("radKyotakuRiyoritsu")
    public RadioButton getRadKyotakuRiyoritsu() {
        return radKyotakuRiyoritsu;
    }

    /*
     * setradKyotakuRiyoritsu
     * @param radKyotakuRiyoritsu radKyotakuRiyoritsu
     */
    @JsonProperty("radKyotakuRiyoritsu")
    public void setRadKyotakuRiyoritsu(RadioButton radKyotakuRiyoritsu) {
        this.radKyotakuRiyoritsu = radKyotakuRiyoritsu;
    }

    /*
     * gettxtKyotakuRiyoritsuRange
     * @return txtKyotakuRiyoritsuRange
     */
    @JsonProperty("txtKyotakuRiyoritsuRange")
    public TextBoxNumRange getTxtKyotakuRiyoritsuRange() {
        return txtKyotakuRiyoritsuRange;
    }

    /*
     * settxtKyotakuRiyoritsuRange
     * @param txtKyotakuRiyoritsuRange txtKyotakuRiyoritsuRange
     */
    @JsonProperty("txtKyotakuRiyoritsuRange")
    public void setTxtKyotakuRiyoritsuRange(TextBoxNumRange txtKyotakuRiyoritsuRange) {
        this.txtKyotakuRiyoritsuRange = txtKyotakuRiyoritsuRange;
    }

    /*
     * getradHomonRiyoritsu
     * @return radHomonRiyoritsu
     */
    @JsonProperty("radHomonRiyoritsu")
    public RadioButton getRadHomonRiyoritsu() {
        return radHomonRiyoritsu;
    }

    /*
     * setradHomonRiyoritsu
     * @param radHomonRiyoritsu radHomonRiyoritsu
     */
    @JsonProperty("radHomonRiyoritsu")
    public void setRadHomonRiyoritsu(RadioButton radHomonRiyoritsu) {
        this.radHomonRiyoritsu = radHomonRiyoritsu;
    }

    /*
     * gettxtHomonRiyoritsuRange
     * @return txtHomonRiyoritsuRange
     */
    @JsonProperty("txtHomonRiyoritsuRange")
    public TextBoxNumRange getTxtHomonRiyoritsuRange() {
        return txtHomonRiyoritsuRange;
    }

    /*
     * settxtHomonRiyoritsuRange
     * @param txtHomonRiyoritsuRange txtHomonRiyoritsuRange
     */
    @JsonProperty("txtHomonRiyoritsuRange")
    public void setTxtHomonRiyoritsuRange(TextBoxNumRange txtHomonRiyoritsuRange) {
        this.txtHomonRiyoritsuRange = txtHomonRiyoritsuRange;
    }

    // </editor-fold>
}
