package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0320011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.BunshoBangoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.IBunshoBangoInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JuryoininChushutsuJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class JuryoininChushutsuJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKeiyakuShinseiYMD")
    private TextBoxDateRange txtKeiyakuShinseiYMD;
    @JsonProperty("txtKeiyakuKetteiYMD")
    private TextBoxDateRange txtKeiyakuKetteiYMD;
    @JsonProperty("radHakkoSumi")
    private RadioButton radHakkoSumi;
    @JsonProperty("linLine1")
    private HorizontalLine linLine1;
    @JsonProperty("lblTsuchishoJoho")
    private Label lblTsuchishoJoho;
    @JsonProperty("txtTsuchiYMD")
    private TextBoxDate txtTsuchiYMD;
    @JsonProperty("ccdBunshoBangoInput")
    private BunshoBangoInputDiv ccdBunshoBangoInput;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKeiyakuShinseiYMD
     * @return txtKeiyakuShinseiYMD
     */
    @JsonProperty("txtKeiyakuShinseiYMD")
    public TextBoxDateRange getTxtKeiyakuShinseiYMD() {
        return txtKeiyakuShinseiYMD;
    }

    /*
     * settxtKeiyakuShinseiYMD
     * @param txtKeiyakuShinseiYMD txtKeiyakuShinseiYMD
     */
    @JsonProperty("txtKeiyakuShinseiYMD")
    public void setTxtKeiyakuShinseiYMD(TextBoxDateRange txtKeiyakuShinseiYMD) {
        this.txtKeiyakuShinseiYMD = txtKeiyakuShinseiYMD;
    }

    /*
     * gettxtKeiyakuKetteiYMD
     * @return txtKeiyakuKetteiYMD
     */
    @JsonProperty("txtKeiyakuKetteiYMD")
    public TextBoxDateRange getTxtKeiyakuKetteiYMD() {
        return txtKeiyakuKetteiYMD;
    }

    /*
     * settxtKeiyakuKetteiYMD
     * @param txtKeiyakuKetteiYMD txtKeiyakuKetteiYMD
     */
    @JsonProperty("txtKeiyakuKetteiYMD")
    public void setTxtKeiyakuKetteiYMD(TextBoxDateRange txtKeiyakuKetteiYMD) {
        this.txtKeiyakuKetteiYMD = txtKeiyakuKetteiYMD;
    }

    /*
     * getradHakkoSumi
     * @return radHakkoSumi
     */
    @JsonProperty("radHakkoSumi")
    public RadioButton getRadHakkoSumi() {
        return radHakkoSumi;
    }

    /*
     * setradHakkoSumi
     * @param radHakkoSumi radHakkoSumi
     */
    @JsonProperty("radHakkoSumi")
    public void setRadHakkoSumi(RadioButton radHakkoSumi) {
        this.radHakkoSumi = radHakkoSumi;
    }

    /*
     * getlinLine1
     * @return linLine1
     */
    @JsonProperty("linLine1")
    public HorizontalLine getLinLine1() {
        return linLine1;
    }

    /*
     * setlinLine1
     * @param linLine1 linLine1
     */
    @JsonProperty("linLine1")
    public void setLinLine1(HorizontalLine linLine1) {
        this.linLine1 = linLine1;
    }

    /*
     * getlblTsuchishoJoho
     * @return lblTsuchishoJoho
     */
    @JsonProperty("lblTsuchishoJoho")
    public Label getLblTsuchishoJoho() {
        return lblTsuchishoJoho;
    }

    /*
     * setlblTsuchishoJoho
     * @param lblTsuchishoJoho lblTsuchishoJoho
     */
    @JsonProperty("lblTsuchishoJoho")
    public void setLblTsuchishoJoho(Label lblTsuchishoJoho) {
        this.lblTsuchishoJoho = lblTsuchishoJoho;
    }

    /*
     * gettxtTsuchiYMD
     * @return txtTsuchiYMD
     */
    @JsonProperty("txtTsuchiYMD")
    public TextBoxDate getTxtTsuchiYMD() {
        return txtTsuchiYMD;
    }

    /*
     * settxtTsuchiYMD
     * @param txtTsuchiYMD txtTsuchiYMD
     */
    @JsonProperty("txtTsuchiYMD")
    public void setTxtTsuchiYMD(TextBoxDate txtTsuchiYMD) {
        this.txtTsuchiYMD = txtTsuchiYMD;
    }

    /*
     * getccdBunshoBangoInput
     * @return ccdBunshoBangoInput
     */
    @JsonProperty("ccdBunshoBangoInput")
    public IBunshoBangoInputDiv getCcdBunshoBangoInput() {
        return ccdBunshoBangoInput;
    }

    // </editor-fold>
}
