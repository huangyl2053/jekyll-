package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * DoteiMiDoteiShisei のクラスファイル 
 * 
 * @author 自動生成
 */
public class DoteiMiDoteiShiseiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radhyojiTaisho")
    private RadioButton radhyojiTaisho;
    @JsonProperty("KakuninZumiFukumu")
    private KakuninZumiFukumuDiv KakuninZumiFukumu;
    @JsonProperty("txtMaxHyojiKensu")
    private TextBox txtMaxHyojiKensu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradhyojiTaisho
     * @return radhyojiTaisho
     */
    @JsonProperty("radhyojiTaisho")
    public RadioButton getRadhyojiTaisho() {
        return radhyojiTaisho;
    }

    /*
     * setradhyojiTaisho
     * @param radhyojiTaisho radhyojiTaisho
     */
    @JsonProperty("radhyojiTaisho")
    public void setRadhyojiTaisho(RadioButton radhyojiTaisho) {
        this.radhyojiTaisho = radhyojiTaisho;
    }

    /*
     * getKakuninZumiFukumu
     * @return KakuninZumiFukumu
     */
    @JsonProperty("KakuninZumiFukumu")
    public KakuninZumiFukumuDiv getKakuninZumiFukumu() {
        return KakuninZumiFukumu;
    }

    /*
     * setKakuninZumiFukumu
     * @param KakuninZumiFukumu KakuninZumiFukumu
     */
    @JsonProperty("KakuninZumiFukumu")
    public void setKakuninZumiFukumu(KakuninZumiFukumuDiv KakuninZumiFukumu) {
        this.KakuninZumiFukumu = KakuninZumiFukumu;
    }

    /*
     * gettxtMaxHyojiKensu
     * @return txtMaxHyojiKensu
     */
    @JsonProperty("txtMaxHyojiKensu")
    public TextBox getTxtMaxHyojiKensu() {
        return txtMaxHyojiKensu;
    }

    /*
     * settxtMaxHyojiKensu
     * @param txtMaxHyojiKensu txtMaxHyojiKensu
     */
    @JsonProperty("txtMaxHyojiKensu")
    public void setTxtMaxHyojiKensu(TextBox txtMaxHyojiKensu) {
        this.txtMaxHyojiKensu = txtMaxHyojiKensu;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public CheckBoxList getChkKakuninZumiFukumu() {
        return this.getKakuninZumiFukumu().getChkKakuninZumiFukumu();
    }

    @JsonIgnore
    public void  setChkKakuninZumiFukumu(CheckBoxList chkKakuninZumiFukumu) {
        this.getKakuninZumiFukumu().setChkKakuninZumiFukumu(chkKakuninZumiFukumu);
    }

    // </editor-fold>
}
