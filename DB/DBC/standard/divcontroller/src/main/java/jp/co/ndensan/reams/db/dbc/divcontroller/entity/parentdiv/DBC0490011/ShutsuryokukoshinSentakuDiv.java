package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0490011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShutsuryokukoshinSentaku のクラスファイル 
 * 
 * @reamsid_L DBC-2000-010 chenhui
 */
public class ShutsuryokukoshinSentakuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkTesutoShuturyoku")
    private CheckBoxList chkTesutoShuturyoku;
    @JsonProperty("radKetteibiIkkatsuKoshinKubun")
    private RadioButton radKetteibiIkkatsuKoshinKubun;
    @JsonProperty("txtketteibi2")
    private TextBoxDate txtketteibi2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkTesutoShuturyoku
     * @return chkTesutoShuturyoku
     */
    @JsonProperty("chkTesutoShuturyoku")
    public CheckBoxList getChkTesutoShuturyoku() {
        return chkTesutoShuturyoku;
    }

    /*
     * setchkTesutoShuturyoku
     * @param chkTesutoShuturyoku chkTesutoShuturyoku
     */
    @JsonProperty("chkTesutoShuturyoku")
    public void setChkTesutoShuturyoku(CheckBoxList chkTesutoShuturyoku) {
        this.chkTesutoShuturyoku = chkTesutoShuturyoku;
    }

    /*
     * getradKetteibiIkkatsuKoshinKubun
     * @return radKetteibiIkkatsuKoshinKubun
     */
    @JsonProperty("radKetteibiIkkatsuKoshinKubun")
    public RadioButton getRadKetteibiIkkatsuKoshinKubun() {
        return radKetteibiIkkatsuKoshinKubun;
    }

    /*
     * setradKetteibiIkkatsuKoshinKubun
     * @param radKetteibiIkkatsuKoshinKubun radKetteibiIkkatsuKoshinKubun
     */
    @JsonProperty("radKetteibiIkkatsuKoshinKubun")
    public void setRadKetteibiIkkatsuKoshinKubun(RadioButton radKetteibiIkkatsuKoshinKubun) {
        this.radKetteibiIkkatsuKoshinKubun = radKetteibiIkkatsuKoshinKubun;
    }

    /*
     * gettxtketteibi2
     * @return txtketteibi2
     */
    @JsonProperty("txtketteibi2")
    public TextBoxDate getTxtketteibi2() {
        return txtketteibi2;
    }

    /*
     * settxtketteibi2
     * @param txtketteibi2 txtketteibi2
     */
    @JsonProperty("txtketteibi2")
    public void setTxtketteibi2(TextBoxDate txtketteibi2) {
        this.txtketteibi2 = txtketteibi2;
    }

    // </editor-fold>
}
