package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5220001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteiEnkiTsuchiHakkoJyoken1 のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiEnkiTsuchiHakkoJyoken1Div extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radEnkiTsuchiHakkoIchiranhyo")
    private RadioButton radEnkiTsuchiHakkoIchiranhyo;
    @JsonProperty("txtMikomiDateIchiran")
    private TextBoxDateRange txtMikomiDateIchiran;
    @JsonProperty("txtInsatsuDate")
    private TextBoxDate txtInsatsuDate;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradEnkiTsuchiHakkoIchiranhyo
     * @return radEnkiTsuchiHakkoIchiranhyo
     */
    @JsonProperty("radEnkiTsuchiHakkoIchiranhyo")
    public RadioButton getRadEnkiTsuchiHakkoIchiranhyo() {
        return radEnkiTsuchiHakkoIchiranhyo;
    }

    /*
     * setradEnkiTsuchiHakkoIchiranhyo
     * @param radEnkiTsuchiHakkoIchiranhyo radEnkiTsuchiHakkoIchiranhyo
     */
    @JsonProperty("radEnkiTsuchiHakkoIchiranhyo")
    public void setRadEnkiTsuchiHakkoIchiranhyo(RadioButton radEnkiTsuchiHakkoIchiranhyo) {
        this.radEnkiTsuchiHakkoIchiranhyo = radEnkiTsuchiHakkoIchiranhyo;
    }

    /*
     * gettxtMikomiDateIchiran
     * @return txtMikomiDateIchiran
     */
    @JsonProperty("txtMikomiDateIchiran")
    public TextBoxDateRange getTxtMikomiDateIchiran() {
        return txtMikomiDateIchiran;
    }

    /*
     * settxtMikomiDateIchiran
     * @param txtMikomiDateIchiran txtMikomiDateIchiran
     */
    @JsonProperty("txtMikomiDateIchiran")
    public void setTxtMikomiDateIchiran(TextBoxDateRange txtMikomiDateIchiran) {
        this.txtMikomiDateIchiran = txtMikomiDateIchiran;
    }

    /*
     * gettxtInsatsuDate
     * @return txtInsatsuDate
     */
    @JsonProperty("txtInsatsuDate")
    public TextBoxDate getTxtInsatsuDate() {
        return txtInsatsuDate;
    }

    /*
     * settxtInsatsuDate
     * @param txtInsatsuDate txtInsatsuDate
     */
    @JsonProperty("txtInsatsuDate")
    public void setTxtInsatsuDate(TextBoxDate txtInsatsuDate) {
        this.txtInsatsuDate = txtInsatsuDate;
    }

    // </editor-fold>
}
