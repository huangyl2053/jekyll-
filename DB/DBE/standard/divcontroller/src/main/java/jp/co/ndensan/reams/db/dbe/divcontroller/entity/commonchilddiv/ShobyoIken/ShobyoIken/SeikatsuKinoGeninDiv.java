package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ShobyoIken.ShobyoIken;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SeikatsuKinoGenin のクラスファイル
 *
 */
public class SeikatsuKinoGeninDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_12-59-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblChiryoNaiyo")
    private Label lblChiryoNaiyo;
    @JsonProperty("txtNaiyo")
    private TextBoxMultiLine txtNaiyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblChiryoNaiyo
     * @return lblChiryoNaiyo
     */
    @JsonProperty("lblChiryoNaiyo")
    public Label getLblChiryoNaiyo() {
        return lblChiryoNaiyo;
    }

    /*
     * setlblChiryoNaiyo
     * @param lblChiryoNaiyo lblChiryoNaiyo
     */
    @JsonProperty("lblChiryoNaiyo")
    public void setLblChiryoNaiyo(Label lblChiryoNaiyo) {
        this.lblChiryoNaiyo = lblChiryoNaiyo;
    }

    /*
     * gettxtNaiyo
     * @return txtNaiyo
     */
    @JsonProperty("txtNaiyo")
    public TextBoxMultiLine getTxtNaiyo() {
        return txtNaiyo;
    }

    /*
     * settxtNaiyo
     * @param txtNaiyo txtNaiyo
     */
    @JsonProperty("txtNaiyo")
    public void setTxtNaiyo(TextBoxMultiLine txtNaiyo) {
        this.txtNaiyo = txtNaiyo;
    }

    // </editor-fold>
}
