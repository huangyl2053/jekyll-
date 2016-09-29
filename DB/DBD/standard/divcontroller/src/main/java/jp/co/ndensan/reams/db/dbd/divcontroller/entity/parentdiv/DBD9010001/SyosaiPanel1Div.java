package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD9010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SyosaiPanel1 のクラスファイル 
 * 
 * @author 自動生成
 */
public class SyosaiPanel1Div extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KubunRadioButton")
    private RadioButton KubunRadioButton;
    @JsonProperty("sinseYYMMDD")
    private TextBoxDate sinseYYMMDD;
    @JsonProperty("torokuYYMMDD")
    private TextBoxDate torokuYYMMDD;
    @JsonProperty("TaisyoYY")
    private TextBoxDate TaisyoYY;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKubunRadioButton
     * @return KubunRadioButton
     */
    @JsonProperty("KubunRadioButton")
    public RadioButton getKubunRadioButton() {
        return KubunRadioButton;
    }

    /*
     * setKubunRadioButton
     * @param KubunRadioButton KubunRadioButton
     */
    @JsonProperty("KubunRadioButton")
    public void setKubunRadioButton(RadioButton KubunRadioButton) {
        this.KubunRadioButton = KubunRadioButton;
    }

    /*
     * getsinseYYMMDD
     * @return sinseYYMMDD
     */
    @JsonProperty("sinseYYMMDD")
    public TextBoxDate getSinseYYMMDD() {
        return sinseYYMMDD;
    }

    /*
     * setsinseYYMMDD
     * @param sinseYYMMDD sinseYYMMDD
     */
    @JsonProperty("sinseYYMMDD")
    public void setSinseYYMMDD(TextBoxDate sinseYYMMDD) {
        this.sinseYYMMDD = sinseYYMMDD;
    }

    /*
     * gettorokuYYMMDD
     * @return torokuYYMMDD
     */
    @JsonProperty("torokuYYMMDD")
    public TextBoxDate getTorokuYYMMDD() {
        return torokuYYMMDD;
    }

    /*
     * settorokuYYMMDD
     * @param torokuYYMMDD torokuYYMMDD
     */
    @JsonProperty("torokuYYMMDD")
    public void setTorokuYYMMDD(TextBoxDate torokuYYMMDD) {
        this.torokuYYMMDD = torokuYYMMDD;
    }

    /*
     * getTaisyoYY
     * @return TaisyoYY
     */
    @JsonProperty("TaisyoYY")
    public TextBoxDate getTaisyoYY() {
        return TaisyoYY;
    }

    /*
     * setTaisyoYY
     * @param TaisyoYY TaisyoYY
     */
    @JsonProperty("TaisyoYY")
    public void setTaisyoYY(TextBoxDate TaisyoYY) {
        this.TaisyoYY = TaisyoYY;
    }

    // </editor-fold>
}
