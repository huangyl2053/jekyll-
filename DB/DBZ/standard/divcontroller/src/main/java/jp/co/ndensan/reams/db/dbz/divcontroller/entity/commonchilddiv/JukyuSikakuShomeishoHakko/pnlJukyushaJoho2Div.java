package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.JukyuSikakuShomeishoHakko;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * pnlJukyushaJoho2 のクラスファイル
 *
 */
public class pnlJukyushaJoho2Div extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblShinsakaiYikan")
    private Label lblShinsakaiYikan;
    @JsonProperty("tbmShinsakaiYikan")
    private TextBoxMultiLine tbmShinsakaiYikan;
    @JsonProperty("lblBiko")
    private Label lblBiko;
    @JsonProperty("tbmBiko")
    private TextBoxMultiLine tbmBiko;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblShinsakaiYikan
     * @return lblShinsakaiYikan
     */
    @JsonProperty("lblShinsakaiYikan")
    public Label getLblShinsakaiYikan() {
        return lblShinsakaiYikan;
    }

    /*
     * setlblShinsakaiYikan
     * @param lblShinsakaiYikan lblShinsakaiYikan
     */
    @JsonProperty("lblShinsakaiYikan")
    public void setLblShinsakaiYikan(Label lblShinsakaiYikan) {
        this.lblShinsakaiYikan = lblShinsakaiYikan;
    }

    /*
     * gettbmShinsakaiYikan
     * @return tbmShinsakaiYikan
     */
    @JsonProperty("tbmShinsakaiYikan")
    public TextBoxMultiLine getTbmShinsakaiYikan() {
        return tbmShinsakaiYikan;
    }

    /*
     * settbmShinsakaiYikan
     * @param tbmShinsakaiYikan tbmShinsakaiYikan
     */
    @JsonProperty("tbmShinsakaiYikan")
    public void setTbmShinsakaiYikan(TextBoxMultiLine tbmShinsakaiYikan) {
        this.tbmShinsakaiYikan = tbmShinsakaiYikan;
    }

    /*
     * getlblBiko
     * @return lblBiko
     */
    @JsonProperty("lblBiko")
    public Label getLblBiko() {
        return lblBiko;
    }

    /*
     * setlblBiko
     * @param lblBiko lblBiko
     */
    @JsonProperty("lblBiko")
    public void setLblBiko(Label lblBiko) {
        this.lblBiko = lblBiko;
    }

    /*
     * gettbmBiko
     * @return tbmBiko
     */
    @JsonProperty("tbmBiko")
    public TextBoxMultiLine getTbmBiko() {
        return tbmBiko;
    }

    /*
     * settbmBiko
     * @param tbmBiko tbmBiko
     */
    @JsonProperty("tbmBiko")
    public void setTbmBiko(TextBoxMultiLine tbmBiko) {
        this.tbmBiko = tbmBiko;
    }

    // </editor-fold>
}
