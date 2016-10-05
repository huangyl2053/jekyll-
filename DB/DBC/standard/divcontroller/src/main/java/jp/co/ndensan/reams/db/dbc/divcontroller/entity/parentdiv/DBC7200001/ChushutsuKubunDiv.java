package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7200001;
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
 * ChushutsuKubun のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChushutsuKubunDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("Yohaku1")
    private Space Yohaku1;
    @JsonProperty("radChushutsuKubun")
    private RadioButton radChushutsuKubun;
    @JsonProperty("Kijyunbi")
    private KijyunbiDiv Kijyunbi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getYohaku1
     * @return Yohaku1
     */
    @JsonProperty("Yohaku1")
    public Space getYohaku1() {
        return Yohaku1;
    }

    /*
     * setYohaku1
     * @param Yohaku1 Yohaku1
     */
    @JsonProperty("Yohaku1")
    public void setYohaku1(Space Yohaku1) {
        this.Yohaku1 = Yohaku1;
    }

    /*
     * getradChushutsuKubun
     * @return radChushutsuKubun
     */
    @JsonProperty("radChushutsuKubun")
    public RadioButton getRadChushutsuKubun() {
        return radChushutsuKubun;
    }

    /*
     * setradChushutsuKubun
     * @param radChushutsuKubun radChushutsuKubun
     */
    @JsonProperty("radChushutsuKubun")
    public void setRadChushutsuKubun(RadioButton radChushutsuKubun) {
        this.radChushutsuKubun = radChushutsuKubun;
    }

    /*
     * getKijyunbi
     * @return Kijyunbi
     */
    @JsonProperty("Kijyunbi")
    public KijyunbiDiv getKijyunbi() {
        return Kijyunbi;
    }

    /*
     * setKijyunbi
     * @param Kijyunbi Kijyunbi
     */
    @JsonProperty("Kijyunbi")
    public void setKijyunbi(KijyunbiDiv Kijyunbi) {
        this.Kijyunbi = Kijyunbi;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Space getYohaku2() {
        return this.getKijyunbi().getYohaku2();
    }

    @JsonIgnore
    public void  setYohaku2(Space Yohaku2) {
        this.getKijyunbi().setYohaku2(Yohaku2);
    }

    @JsonIgnore
    public TextBoxDate getTxtKijyunnNengetsu() {
        return this.getKijyunbi().getTxtKijyunnNengetsu();
    }

    @JsonIgnore
    public void  setTxtKijyunnNengetsu(TextBoxDate txtKijyunnNengetsu) {
        this.getKijyunbi().setTxtKijyunnNengetsu(txtKijyunnNengetsu);
    }

    // </editor-fold>
}
