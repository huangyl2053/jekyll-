package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0700011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * BatchParamterInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class BatchParamterInfoDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-16_12-38-19">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlshichosonshitei")
    private DropDownList ddlshichosonshitei;
    @JsonProperty("HLine1")
    private HorizontalLine HLine1;
    @JsonProperty("lblkasi")
    private Label lblkasi;
    @JsonProperty("lblsyo")
    private Label lblsyo;
    @JsonProperty("lblshutchutsu")
    private Label lblshutchutsu;
    @JsonProperty("txtkaishihi")
    private TextBoxFlexibleDate txtkaishihi;
    @JsonProperty("lblkara")
    private Label lblkara;
    @JsonProperty("txtshohi")
    private TextBoxFlexibleDate txtshohi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlshichosonshitei
     * @return ddlshichosonshitei
     */
    @JsonProperty("ddlshichosonshitei")
    public DropDownList getDdlshichosonshitei() {
        return ddlshichosonshitei;
    }

    /*
     * setddlshichosonshitei
     * @param ddlshichosonshitei ddlshichosonshitei
     */
    @JsonProperty("ddlshichosonshitei")
    public void setDdlshichosonshitei(DropDownList ddlshichosonshitei) {
        this.ddlshichosonshitei = ddlshichosonshitei;
    }

    /*
     * getHLine1
     * @return HLine1
     */
    @JsonProperty("HLine1")
    public HorizontalLine getHLine1() {
        return HLine1;
    }

    /*
     * setHLine1
     * @param HLine1 HLine1
     */
    @JsonProperty("HLine1")
    public void setHLine1(HorizontalLine HLine1) {
        this.HLine1 = HLine1;
    }

    /*
     * getlblkasi
     * @return lblkasi
     */
    @JsonProperty("lblkasi")
    public Label getLblkasi() {
        return lblkasi;
    }

    /*
     * setlblkasi
     * @param lblkasi lblkasi
     */
    @JsonProperty("lblkasi")
    public void setLblkasi(Label lblkasi) {
        this.lblkasi = lblkasi;
    }

    /*
     * getlblsyo
     * @return lblsyo
     */
    @JsonProperty("lblsyo")
    public Label getLblsyo() {
        return lblsyo;
    }

    /*
     * setlblsyo
     * @param lblsyo lblsyo
     */
    @JsonProperty("lblsyo")
    public void setLblsyo(Label lblsyo) {
        this.lblsyo = lblsyo;
    }

    /*
     * getlblshutchutsu
     * @return lblshutchutsu
     */
    @JsonProperty("lblshutchutsu")
    public Label getLblshutchutsu() {
        return lblshutchutsu;
    }

    /*
     * setlblshutchutsu
     * @param lblshutchutsu lblshutchutsu
     */
    @JsonProperty("lblshutchutsu")
    public void setLblshutchutsu(Label lblshutchutsu) {
        this.lblshutchutsu = lblshutchutsu;
    }

    /*
     * gettxtkaishihi
     * @return txtkaishihi
     */
    @JsonProperty("txtkaishihi")
    public TextBoxFlexibleDate getTxtkaishihi() {
        return txtkaishihi;
    }

    /*
     * settxtkaishihi
     * @param txtkaishihi txtkaishihi
     */
    @JsonProperty("txtkaishihi")
    public void setTxtkaishihi(TextBoxFlexibleDate txtkaishihi) {
        this.txtkaishihi = txtkaishihi;
    }

    /*
     * getlblkara
     * @return lblkara
     */
    @JsonProperty("lblkara")
    public Label getLblkara() {
        return lblkara;
    }

    /*
     * setlblkara
     * @param lblkara lblkara
     */
    @JsonProperty("lblkara")
    public void setLblkara(Label lblkara) {
        this.lblkara = lblkara;
    }

    /*
     * gettxtshohi
     * @return txtshohi
     */
    @JsonProperty("txtshohi")
    public TextBoxFlexibleDate getTxtshohi() {
        return txtshohi;
    }

    /*
     * settxtshohi
     * @param txtshohi txtshohi
     */
    @JsonProperty("txtshohi")
    public void setTxtshohi(TextBoxFlexibleDate txtshohi) {
        this.txtshohi = txtshohi;
    }

    // </editor-fold>
}
