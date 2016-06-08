package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0150001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;

/**
 * ShoriJokyo のクラスファイル
 *
 * @reamsid_L DBB-0890-010 wangkanglei
 */
public class ShoriJokyoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KarisanteiIdoShoriNaiyo")
    private KarisanteiIdoShoriNaiyoDiv KarisanteiIdoShoriNaiyo;
    @JsonProperty("KarisanteiIdoFukashoriKakunin")
    private KarisanteiIdoFukashoriKakuninDiv KarisanteiIdoFukashoriKakunin;
    @JsonProperty("KanriJohoKakunin")
    private KanriJohoKakuninDiv KanriJohoKakunin;
    @JsonProperty("TokuchoHosoku")
    private TokuchoHosokuDiv TokuchoHosoku;
    @JsonProperty("lblonsanteiShoriKakunin")
    private Label lblonsanteiShoriKakunin;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKarisanteiIdoShoriNaiyo
     * @return KarisanteiIdoShoriNaiyo
     */
    @JsonProperty("KarisanteiIdoShoriNaiyo")
    public KarisanteiIdoShoriNaiyoDiv getKarisanteiIdoShoriNaiyo() {
        return KarisanteiIdoShoriNaiyo;
    }

    /*
     * setKarisanteiIdoShoriNaiyo
     * @param KarisanteiIdoShoriNaiyo KarisanteiIdoShoriNaiyo
     */
    @JsonProperty("KarisanteiIdoShoriNaiyo")
    public void setKarisanteiIdoShoriNaiyo(KarisanteiIdoShoriNaiyoDiv KarisanteiIdoShoriNaiyo) {
        this.KarisanteiIdoShoriNaiyo = KarisanteiIdoShoriNaiyo;
    }

    /*
     * getKarisanteiIdoFukashoriKakunin
     * @return KarisanteiIdoFukashoriKakunin
     */
    @JsonProperty("KarisanteiIdoFukashoriKakunin")
    public KarisanteiIdoFukashoriKakuninDiv getKarisanteiIdoFukashoriKakunin() {
        return KarisanteiIdoFukashoriKakunin;
    }

    /*
     * setKarisanteiIdoFukashoriKakunin
     * @param KarisanteiIdoFukashoriKakunin KarisanteiIdoFukashoriKakunin
     */
    @JsonProperty("KarisanteiIdoFukashoriKakunin")
    public void setKarisanteiIdoFukashoriKakunin(KarisanteiIdoFukashoriKakuninDiv KarisanteiIdoFukashoriKakunin) {
        this.KarisanteiIdoFukashoriKakunin = KarisanteiIdoFukashoriKakunin;
    }

    /*
     * getKanriJohoKakunin
     * @return KanriJohoKakunin
     */
    @JsonProperty("KanriJohoKakunin")
    public KanriJohoKakuninDiv getKanriJohoKakunin() {
        return KanriJohoKakunin;
    }

    /*
     * setKanriJohoKakunin
     * @param KanriJohoKakunin KanriJohoKakunin
     */
    @JsonProperty("KanriJohoKakunin")
    public void setKanriJohoKakunin(KanriJohoKakuninDiv KanriJohoKakunin) {
        this.KanriJohoKakunin = KanriJohoKakunin;
    }

    /*
     * getTokuchoHosoku
     * @return TokuchoHosoku
     */
    @JsonProperty("TokuchoHosoku")
    public TokuchoHosokuDiv getTokuchoHosoku() {
        return TokuchoHosoku;
    }

    /*
     * setTokuchoHosoku
     * @param TokuchoHosoku TokuchoHosoku
     */
    @JsonProperty("TokuchoHosoku")
    public void setTokuchoHosoku(TokuchoHosokuDiv TokuchoHosoku) {
        this.TokuchoHosoku = TokuchoHosoku;
    }

    /*
     * getlblonsanteiShoriKakunin
     * @return lblonsanteiShoriKakunin
     */
    @JsonProperty("lblonsanteiShoriKakunin")
    public Label getLblonsanteiShoriKakunin() {
        return lblonsanteiShoriKakunin;
    }

    /*
     * setlblonsanteiShoriKakunin
     * @param lblonsanteiShoriKakunin lblonsanteiShoriKakunin
     */
    @JsonProperty("lblonsanteiShoriKakunin")
    public void setLblonsanteiShoriKakunin(Label lblonsanteiShoriKakunin) {
        this.lblonsanteiShoriKakunin = lblonsanteiShoriKakunin;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DataGrid<dgHokenryoDankai_Row> getDgHokenryoDankai() {
        return this.getKanriJohoKakunin().getDgHokenryoDankai();
    }

    @JsonIgnore
    public void setDgHokenryoDankai(DataGrid<dgHokenryoDankai_Row> dgHokenryoDankai) {
        this.getKanriJohoKakunin().setDgHokenryoDankai(dgHokenryoDankai);
    }

    @JsonIgnore
    public DataGrid<dgKomokuNaiyo_Row> getDgKomokuNaiyo() {
        return this.getKanriJohoKakunin().getDgKomokuNaiyo();
    }

    @JsonIgnore
    public void setDgKomokuNaiyo(DataGrid<dgKomokuNaiyo_Row> dgKomokuNaiyo) {
        this.getKanriJohoKakunin().setDgKomokuNaiyo(dgKomokuNaiyo);
    }

    @JsonIgnore
    public TextBox getTxtTaishoTokuchoKaishiTsuki() {
        return this.getTokuchoHosoku().getTxtTaishoTokuchoKaishiTsuki();
    }

    @JsonIgnore
    public void setTxtTaishoTokuchoKaishiTsuki(TextBox txtTaishoTokuchoKaishiTsuki) {
        this.getTokuchoHosoku().setTxtTaishoTokuchoKaishiTsuki(txtTaishoTokuchoKaishiTsuki);
    }

    @JsonIgnore
    public RadioButton getRadTokuchoHosokuIraiKingakuKeisan() {
        return this.getTokuchoHosoku().getRadTokuchoHosokuIraiKingakuKeisan();
    }

    @JsonIgnore
    public void setRadTokuchoHosokuIraiKingakuKeisan(RadioButton radTokuchoHosokuIraiKingakuKeisan) {
        this.getTokuchoHosoku().setRadTokuchoHosokuIraiKingakuKeisan(radTokuchoHosokuIraiKingakuKeisan);
    }

    // </editor-fold>
}
