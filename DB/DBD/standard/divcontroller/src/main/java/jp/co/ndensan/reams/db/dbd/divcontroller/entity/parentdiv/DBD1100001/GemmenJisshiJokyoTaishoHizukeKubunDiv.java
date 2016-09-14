package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1100001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * GemmenJisshiJokyoTaishoHizukeKubun のクラスファイル 
 * 
 * @author 自動生成
 */
public class GemmenJisshiJokyoTaishoHizukeKubunDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radKijunBi")
    private RadioButton radKijunBi;
    @JsonProperty("txtKijunBi")
    private TextBoxNum txtKijunBi;
    @JsonProperty("radKijunNengetsu")
    private RadioButton radKijunNengetsu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradKijunBi
     * @return radKijunBi
     */
    @JsonProperty("radKijunBi")
    public RadioButton getRadKijunBi() {
        return radKijunBi;
    }

    /*
     * setradKijunBi
     * @param radKijunBi radKijunBi
     */
    @JsonProperty("radKijunBi")
    public void setRadKijunBi(RadioButton radKijunBi) {
        this.radKijunBi = radKijunBi;
    }

    /*
     * gettxtKijunBi
     * @return txtKijunBi
     */
    @JsonProperty("txtKijunBi")
    public TextBoxNum getTxtKijunBi() {
        return txtKijunBi;
    }

    /*
     * settxtKijunBi
     * @param txtKijunBi txtKijunBi
     */
    @JsonProperty("txtKijunBi")
    public void setTxtKijunBi(TextBoxNum txtKijunBi) {
        this.txtKijunBi = txtKijunBi;
    }

    /*
     * getradKijunNengetsu
     * @return radKijunNengetsu
     */
    @JsonProperty("radKijunNengetsu")
    public RadioButton getRadKijunNengetsu() {
        return radKijunNengetsu;
    }

    /*
     * setradKijunNengetsu
     * @param radKijunNengetsu radKijunNengetsu
     */
    @JsonProperty("radKijunNengetsu")
    public void setRadKijunNengetsu(RadioButton radKijunNengetsu) {
        this.radKijunNengetsu = radKijunNengetsu;
    }

    // </editor-fold>
}
