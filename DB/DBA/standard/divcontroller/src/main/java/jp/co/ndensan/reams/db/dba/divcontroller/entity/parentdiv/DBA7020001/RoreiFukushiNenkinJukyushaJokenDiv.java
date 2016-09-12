package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA7020001;
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
 * RoreiFukushiNenkinJukyushaJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class RoreiFukushiNenkinJukyushaJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radRoreiFukushiNenkinJukyushaChushutsu")
    private RadioButton radRoreiFukushiNenkinJukyushaChushutsu;
    @JsonProperty("RoreiFukushiNenkinHizukeChushutsu")
    private RoreiFukushiNenkinHizukeChushutsuDiv RoreiFukushiNenkinHizukeChushutsu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradRoreiFukushiNenkinJukyushaChushutsu
     * @return radRoreiFukushiNenkinJukyushaChushutsu
     */
    @JsonProperty("radRoreiFukushiNenkinJukyushaChushutsu")
    public RadioButton getRadRoreiFukushiNenkinJukyushaChushutsu() {
        return radRoreiFukushiNenkinJukyushaChushutsu;
    }

    /*
     * setradRoreiFukushiNenkinJukyushaChushutsu
     * @param radRoreiFukushiNenkinJukyushaChushutsu radRoreiFukushiNenkinJukyushaChushutsu
     */
    @JsonProperty("radRoreiFukushiNenkinJukyushaChushutsu")
    public void setRadRoreiFukushiNenkinJukyushaChushutsu(RadioButton radRoreiFukushiNenkinJukyushaChushutsu) {
        this.radRoreiFukushiNenkinJukyushaChushutsu = radRoreiFukushiNenkinJukyushaChushutsu;
    }

    /*
     * getRoreiFukushiNenkinHizukeChushutsu
     * @return RoreiFukushiNenkinHizukeChushutsu
     */
    @JsonProperty("RoreiFukushiNenkinHizukeChushutsu")
    public RoreiFukushiNenkinHizukeChushutsuDiv getRoreiFukushiNenkinHizukeChushutsu() {
        return RoreiFukushiNenkinHizukeChushutsu;
    }

    /*
     * setRoreiFukushiNenkinHizukeChushutsu
     * @param RoreiFukushiNenkinHizukeChushutsu RoreiFukushiNenkinHizukeChushutsu
     */
    @JsonProperty("RoreiFukushiNenkinHizukeChushutsu")
    public void setRoreiFukushiNenkinHizukeChushutsu(RoreiFukushiNenkinHizukeChushutsuDiv RoreiFukushiNenkinHizukeChushutsu) {
        this.RoreiFukushiNenkinHizukeChushutsu = RoreiFukushiNenkinHizukeChushutsu;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Space getRoreiFukushiNenkinJukyushaYohaku() {
        return this.getRoreiFukushiNenkinHizukeChushutsu().getRoreiFukushiNenkinJukyushaYohaku();
    }

    @JsonIgnore
    public void  setRoreiFukushiNenkinJukyushaYohaku(Space RoreiFukushiNenkinJukyushaYohaku) {
        this.getRoreiFukushiNenkinHizukeChushutsu().setRoreiFukushiNenkinJukyushaYohaku(RoreiFukushiNenkinJukyushaYohaku);
    }

    @JsonIgnore
    public TextBoxDate getTexRoreiFukushiNenkinJukyushaKijyunDate() {
        return this.getRoreiFukushiNenkinHizukeChushutsu().getTexRoreiFukushiNenkinJukyushaKijyunDate();
    }

    @JsonIgnore
    public void  setTexRoreiFukushiNenkinJukyushaKijyunDate(TextBoxDate texRoreiFukushiNenkinJukyushaKijyunDate) {
        this.getRoreiFukushiNenkinHizukeChushutsu().setTexRoreiFukushiNenkinJukyushaKijyunDate(texRoreiFukushiNenkinJukyushaKijyunDate);
    }

    @JsonIgnore
    public RadioButton getRadRoreiFukushiNenkinJukyushaHani() {
        return this.getRoreiFukushiNenkinHizukeChushutsu().getRadRoreiFukushiNenkinJukyushaHani();
    }

    @JsonIgnore
    public void  setRadRoreiFukushiNenkinJukyushaHani(RadioButton radRoreiFukushiNenkinJukyushaHani) {
        this.getRoreiFukushiNenkinHizukeChushutsu().setRadRoreiFukushiNenkinJukyushaHani(radRoreiFukushiNenkinJukyushaHani);
    }

    @JsonIgnore
    public TextBoxDateRange getTexRoreiFukushiNenkinJukyushaDateHani() {
        return this.getRoreiFukushiNenkinHizukeChushutsu().getTexRoreiFukushiNenkinJukyushaDateHani();
    }

    @JsonIgnore
    public void  setTexRoreiFukushiNenkinJukyushaDateHani(TextBoxDateRange texRoreiFukushiNenkinJukyushaDateHani) {
        this.getRoreiFukushiNenkinHizukeChushutsu().setTexRoreiFukushiNenkinJukyushaDateHani(texRoreiFukushiNenkinJukyushaDateHani);
    }

    // </editor-fold>
}
