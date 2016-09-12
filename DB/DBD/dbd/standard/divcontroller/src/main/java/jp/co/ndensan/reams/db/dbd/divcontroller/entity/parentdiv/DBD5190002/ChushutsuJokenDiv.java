package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5190002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChushutsuJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChushutsuJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radChushutsuJoken")
    private RadioButton radChushutsuJoken;
    @JsonProperty("txtzenkaishoriymdtime")
    private TextBoxDateTimeRange txtzenkaishoriymdtime;
    @JsonProperty("txtkonkaishoriymdtime")
    private TextBoxDateTimeRange txtkonkaishoriymdtime;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradChushutsuJoken
     * @return radChushutsuJoken
     */
    @JsonProperty("radChushutsuJoken")
    public RadioButton getRadChushutsuJoken() {
        return radChushutsuJoken;
    }

    /*
     * setradChushutsuJoken
     * @param radChushutsuJoken radChushutsuJoken
     */
    @JsonProperty("radChushutsuJoken")
    public void setRadChushutsuJoken(RadioButton radChushutsuJoken) {
        this.radChushutsuJoken = radChushutsuJoken;
    }

    /*
     * gettxtzenkaishoriymdtime
     * @return txtzenkaishoriymdtime
     */
    @JsonProperty("txtzenkaishoriymdtime")
    public TextBoxDateTimeRange getTxtzenkaishoriymdtime() {
        return txtzenkaishoriymdtime;
    }

    /*
     * settxtzenkaishoriymdtime
     * @param txtzenkaishoriymdtime txtzenkaishoriymdtime
     */
    @JsonProperty("txtzenkaishoriymdtime")
    public void setTxtzenkaishoriymdtime(TextBoxDateTimeRange txtzenkaishoriymdtime) {
        this.txtzenkaishoriymdtime = txtzenkaishoriymdtime;
    }

    /*
     * gettxtkonkaishoriymdtime
     * @return txtkonkaishoriymdtime
     */
    @JsonProperty("txtkonkaishoriymdtime")
    public TextBoxDateTimeRange getTxtkonkaishoriymdtime() {
        return txtkonkaishoriymdtime;
    }

    /*
     * settxtkonkaishoriymdtime
     * @param txtkonkaishoriymdtime txtkonkaishoriymdtime
     */
    @JsonProperty("txtkonkaishoriymdtime")
    public void setTxtkonkaishoriymdtime(TextBoxDateTimeRange txtkonkaishoriymdtime) {
        this.txtkonkaishoriymdtime = txtkonkaishoriymdtime;
    }

    // </editor-fold>
}
