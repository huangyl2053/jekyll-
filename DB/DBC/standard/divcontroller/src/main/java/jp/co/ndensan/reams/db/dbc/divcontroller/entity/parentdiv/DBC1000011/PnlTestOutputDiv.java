package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1000011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * PnlTestOutput のクラスファイル 
 * 
 * @author 自動生成
 */
public class PnlTestOutputDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkTestShutsuryoku")
    private CheckBoxList chkTestShutsuryoku;
    @JsonProperty("radKeteibiIkatsuKoushinnKubun")
    private RadioButton radKeteibiIkatsuKoushinnKubun;
    @JsonProperty("txtKeteibiTuchisho")
    private TextBoxDate txtKeteibiTuchisho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkTestShutsuryoku
     * @return chkTestShutsuryoku
     */
    @JsonProperty("chkTestShutsuryoku")
    public CheckBoxList getChkTestShutsuryoku() {
        return chkTestShutsuryoku;
    }

    /*
     * setchkTestShutsuryoku
     * @param chkTestShutsuryoku chkTestShutsuryoku
     */
    @JsonProperty("chkTestShutsuryoku")
    public void setChkTestShutsuryoku(CheckBoxList chkTestShutsuryoku) {
        this.chkTestShutsuryoku = chkTestShutsuryoku;
    }

    /*
     * getradKeteibiIkatsuKoushinnKubun
     * @return radKeteibiIkatsuKoushinnKubun
     */
    @JsonProperty("radKeteibiIkatsuKoushinnKubun")
    public RadioButton getRadKeteibiIkatsuKoushinnKubun() {
        return radKeteibiIkatsuKoushinnKubun;
    }

    /*
     * setradKeteibiIkatsuKoushinnKubun
     * @param radKeteibiIkatsuKoushinnKubun radKeteibiIkatsuKoushinnKubun
     */
    @JsonProperty("radKeteibiIkatsuKoushinnKubun")
    public void setRadKeteibiIkatsuKoushinnKubun(RadioButton radKeteibiIkatsuKoushinnKubun) {
        this.radKeteibiIkatsuKoushinnKubun = radKeteibiIkatsuKoushinnKubun;
    }

    /*
     * gettxtKeteibiTuchisho
     * @return txtKeteibiTuchisho
     */
    @JsonProperty("txtKeteibiTuchisho")
    public TextBoxDate getTxtKeteibiTuchisho() {
        return txtKeteibiTuchisho;
    }

    /*
     * settxtKeteibiTuchisho
     * @param txtKeteibiTuchisho txtKeteibiTuchisho
     */
    @JsonProperty("txtKeteibiTuchisho")
    public void setTxtKeteibiTuchisho(TextBoxDate txtKeteibiTuchisho) {
        this.txtKeteibiTuchisho = txtKeteibiTuchisho;
    }

    // </editor-fold>
}
