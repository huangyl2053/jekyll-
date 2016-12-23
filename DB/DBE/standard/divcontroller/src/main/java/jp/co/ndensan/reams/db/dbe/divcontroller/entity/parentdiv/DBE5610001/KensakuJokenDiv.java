package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5610001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KensakuJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class KensakuJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-29_19-09-25">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radDataShutsuryoku")
    private RadioButton radDataShutsuryoku;
    @JsonProperty("txtNijiHanteibi")
    private TextBoxDateRange txtNijiHanteibi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradDataShutsuryoku
     * @return radDataShutsuryoku
     */
    @JsonProperty("radDataShutsuryoku")
    public RadioButton getRadDataShutsuryoku() {
        return radDataShutsuryoku;
    }

    /*
     * setradDataShutsuryoku
     * @param radDataShutsuryoku radDataShutsuryoku
     */
    @JsonProperty("radDataShutsuryoku")
    public void setRadDataShutsuryoku(RadioButton radDataShutsuryoku) {
        this.radDataShutsuryoku = radDataShutsuryoku;
    }

    /*
     * gettxtNijiHanteibi
     * @return txtNijiHanteibi
     */
    @JsonProperty("txtNijiHanteibi")
    public TextBoxDateRange getTxtNijiHanteibi() {
        return txtNijiHanteibi;
    }

    /*
     * settxtNijiHanteibi
     * @param txtNijiHanteibi txtNijiHanteibi
     */
    @JsonProperty("txtNijiHanteibi")
    public void setTxtNijiHanteibi(TextBoxDateRange txtNijiHanteibi) {
        this.txtNijiHanteibi = txtNijiHanteibi;
    }

    // </editor-fold>
}
