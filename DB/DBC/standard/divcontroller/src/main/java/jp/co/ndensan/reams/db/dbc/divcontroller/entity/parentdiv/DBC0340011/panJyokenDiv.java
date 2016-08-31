package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0340011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.BunshoBangoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.IBunshoBangoInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;

/**
 * panJyoken のクラスファイル
 *
 * @reamsid_L DBC-1970-010 wangxingpeng
 */
public class panJyokenDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKeyakuSinseibi")
    private TextBoxDateRange txtKeyakuSinseibi;
    @JsonProperty("txtKeiyakuKeteibi")
    private TextBoxDateRange txtKeiyakuKeteibi;
    @JsonProperty("radHakkouZumi")
    private RadioButton radHakkouZumi;
    @JsonProperty("lin1")
    private HorizontalLine lin1;
    @JsonProperty("lblTuutiSyo")
    private Label lblTuutiSyo;
    @JsonProperty("txtTuutibi")
    private TextBoxDate txtTuutibi;
    @JsonProperty("ccdBunshoBango")
    private BunshoBangoInputDiv ccdBunshoBango;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKeyakuSinseibi
     * @return txtKeyakuSinseibi
     */
    @JsonProperty("txtKeyakuSinseibi")
    public TextBoxDateRange getTxtKeyakuSinseibi() {
        return txtKeyakuSinseibi;
    }

    /*
     * settxtKeyakuSinseibi
     * @param txtKeyakuSinseibi txtKeyakuSinseibi
     */
    @JsonProperty("txtKeyakuSinseibi")
    public void setTxtKeyakuSinseibi(TextBoxDateRange txtKeyakuSinseibi) {
        this.txtKeyakuSinseibi = txtKeyakuSinseibi;
    }

    /*
     * gettxtKeiyakuKeteibi
     * @return txtKeiyakuKeteibi
     */
    @JsonProperty("txtKeiyakuKeteibi")
    public TextBoxDateRange getTxtKeiyakuKeteibi() {
        return txtKeiyakuKeteibi;
    }

    /*
     * settxtKeiyakuKeteibi
     * @param txtKeiyakuKeteibi txtKeiyakuKeteibi
     */
    @JsonProperty("txtKeiyakuKeteibi")
    public void setTxtKeiyakuKeteibi(TextBoxDateRange txtKeiyakuKeteibi) {
        this.txtKeiyakuKeteibi = txtKeiyakuKeteibi;
    }

    /*
     * getradHakkouZumi
     * @return radHakkouZumi
     */
    @JsonProperty("radHakkouZumi")
    public RadioButton getRadHakkouZumi() {
        return radHakkouZumi;
    }

    /*
     * setradHakkouZumi
     * @param radHakkouZumi radHakkouZumi
     */
    @JsonProperty("radHakkouZumi")
    public void setRadHakkouZumi(RadioButton radHakkouZumi) {
        this.radHakkouZumi = radHakkouZumi;
    }

    /*
     * getlin1
     * @return lin1
     */
    @JsonProperty("lin1")
    public HorizontalLine getLin1() {
        return lin1;
    }

    /*
     * setlin1
     * @param lin1 lin1
     */
    @JsonProperty("lin1")
    public void setLin1(HorizontalLine lin1) {
        this.lin1 = lin1;
    }

    /*
     * getlblTuutiSyo
     * @return lblTuutiSyo
     */
    @JsonProperty("lblTuutiSyo")
    public Label getLblTuutiSyo() {
        return lblTuutiSyo;
    }

    /*
     * setlblTuutiSyo
     * @param lblTuutiSyo lblTuutiSyo
     */
    @JsonProperty("lblTuutiSyo")
    public void setLblTuutiSyo(Label lblTuutiSyo) {
        this.lblTuutiSyo = lblTuutiSyo;
    }

    /*
     * gettxtTuutibi
     * @return txtTuutibi
     */
    @JsonProperty("txtTuutibi")
    public TextBoxDate getTxtTuutibi() {
        return txtTuutibi;
    }

    /*
     * settxtTuutibi
     * @param txtTuutibi txtTuutibi
     */
    @JsonProperty("txtTuutibi")
    public void setTxtTuutibi(TextBoxDate txtTuutibi) {
        this.txtTuutibi = txtTuutibi;
    }

    /*
     * getccdBunshoBango
     * @return ccdBunshoBango
     */
    @JsonProperty("ccdBunshoBango")
    public IBunshoBangoInputDiv getCcdBunshoBango() {
        return ccdBunshoBango;
    }

    // </editor-fold>
}
