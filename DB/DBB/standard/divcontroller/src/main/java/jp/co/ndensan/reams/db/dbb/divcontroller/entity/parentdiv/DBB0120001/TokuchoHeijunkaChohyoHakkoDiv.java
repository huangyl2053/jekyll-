package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0120001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.OutputChohyoIchiran.IOutputChohyoIchiranDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.OutputChohyoIchiran.OutputChohyoIchiranDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TokuchoHeijunkaChohyoHakko のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokuchoHeijunkaChohyoHakkoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblHeijunkaHenkoTsuchi")
    private Label lblHeijunkaHenkoTsuchi;
    @JsonProperty("txtHeijunkaHenkoTsuchiHakkoYMD")
    private TextBoxDate txtHeijunkaHenkoTsuchiHakkoYMD;
    @JsonProperty("radHeijunkaHenkoTsuchi")
    private RadioButton radHeijunkaHenkoTsuchi;
    @JsonProperty("txtHeijunkaHenkoTsuchishoBunshoNo")
    private TextBox txtHeijunkaHenkoTsuchishoBunshoNo;
    @JsonProperty("ccdChohyoIchiran")
    private OutputChohyoIchiranDiv ccdChohyoIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblHeijunkaHenkoTsuchi
     * @return lblHeijunkaHenkoTsuchi
     */
    @JsonProperty("lblHeijunkaHenkoTsuchi")
    public Label getLblHeijunkaHenkoTsuchi() {
        return lblHeijunkaHenkoTsuchi;
    }

    /*
     * setlblHeijunkaHenkoTsuchi
     * @param lblHeijunkaHenkoTsuchi lblHeijunkaHenkoTsuchi
     */
    @JsonProperty("lblHeijunkaHenkoTsuchi")
    public void setLblHeijunkaHenkoTsuchi(Label lblHeijunkaHenkoTsuchi) {
        this.lblHeijunkaHenkoTsuchi = lblHeijunkaHenkoTsuchi;
    }

    /*
     * gettxtHeijunkaHenkoTsuchiHakkoYMD
     * @return txtHeijunkaHenkoTsuchiHakkoYMD
     */
    @JsonProperty("txtHeijunkaHenkoTsuchiHakkoYMD")
    public TextBoxDate getTxtHeijunkaHenkoTsuchiHakkoYMD() {
        return txtHeijunkaHenkoTsuchiHakkoYMD;
    }

    /*
     * settxtHeijunkaHenkoTsuchiHakkoYMD
     * @param txtHeijunkaHenkoTsuchiHakkoYMD txtHeijunkaHenkoTsuchiHakkoYMD
     */
    @JsonProperty("txtHeijunkaHenkoTsuchiHakkoYMD")
    public void setTxtHeijunkaHenkoTsuchiHakkoYMD(TextBoxDate txtHeijunkaHenkoTsuchiHakkoYMD) {
        this.txtHeijunkaHenkoTsuchiHakkoYMD = txtHeijunkaHenkoTsuchiHakkoYMD;
    }

    /*
     * getradHeijunkaHenkoTsuchi
     * @return radHeijunkaHenkoTsuchi
     */
    @JsonProperty("radHeijunkaHenkoTsuchi")
    public RadioButton getRadHeijunkaHenkoTsuchi() {
        return radHeijunkaHenkoTsuchi;
    }

    /*
     * setradHeijunkaHenkoTsuchi
     * @param radHeijunkaHenkoTsuchi radHeijunkaHenkoTsuchi
     */
    @JsonProperty("radHeijunkaHenkoTsuchi")
    public void setRadHeijunkaHenkoTsuchi(RadioButton radHeijunkaHenkoTsuchi) {
        this.radHeijunkaHenkoTsuchi = radHeijunkaHenkoTsuchi;
    }

    /*
     * gettxtHeijunkaHenkoTsuchishoBunshoNo
     * @return txtHeijunkaHenkoTsuchishoBunshoNo
     */
    @JsonProperty("txtHeijunkaHenkoTsuchishoBunshoNo")
    public TextBox getTxtHeijunkaHenkoTsuchishoBunshoNo() {
        return txtHeijunkaHenkoTsuchishoBunshoNo;
    }

    /*
     * settxtHeijunkaHenkoTsuchishoBunshoNo
     * @param txtHeijunkaHenkoTsuchishoBunshoNo txtHeijunkaHenkoTsuchishoBunshoNo
     */
    @JsonProperty("txtHeijunkaHenkoTsuchishoBunshoNo")
    public void setTxtHeijunkaHenkoTsuchishoBunshoNo(TextBox txtHeijunkaHenkoTsuchishoBunshoNo) {
        this.txtHeijunkaHenkoTsuchishoBunshoNo = txtHeijunkaHenkoTsuchishoBunshoNo;
    }

    /*
     * getccdChohyoIchiran
     * @return ccdChohyoIchiran
     */
    @JsonProperty("ccdChohyoIchiran")
    public IOutputChohyoIchiranDiv getCcdChohyoIchiran() {
        return ccdChohyoIchiran;
    }

    // </editor-fold>
}
