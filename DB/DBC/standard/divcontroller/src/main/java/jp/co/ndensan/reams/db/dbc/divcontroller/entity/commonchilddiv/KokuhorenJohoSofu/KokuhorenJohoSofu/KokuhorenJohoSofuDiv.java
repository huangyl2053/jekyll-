package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KokuhorenJohoSofu.KokuhorenJohoSofu;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * KokuhorenJohoSofu のクラスファイル
 *
 * @reamsid_L DBC-3300-030 wangxingpeng
 */
public class KokuhorenJohoSofuDiv extends Panel implements IKokuhorenJohoSofuDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblChushutsuJoken")
    private Label lblChushutsuJoken;
    @JsonProperty("txtShoriSaikuruKubun")
    private TextBox txtShoriSaikuruKubun;
    @JsonProperty("txtShoritaishoNengetsu")
    private TextBoxDate txtShoritaishoNengetsu;
    @JsonProperty("txtsaishoriKubun")
    private TextBox txtsaishoriKubun;
    @JsonProperty("txtFileName")
    private TextBox txtFileName;
    @JsonProperty("ddlSofuTaishojoho")
    private DropDownList ddlSofuTaishojoho;
    @JsonProperty("ShoriJikkoMaekakuninJiko")
    private ShoriJikkoMaekakuninJikoDiv ShoriJikkoMaekakuninJiko;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblChushutsuJoken
     * @return lblChushutsuJoken
     */
    @JsonProperty("lblChushutsuJoken")
    public Label getLblChushutsuJoken() {
        return lblChushutsuJoken;
    }

    /*
     * setlblChushutsuJoken
     * @param lblChushutsuJoken lblChushutsuJoken
     */
    @JsonProperty("lblChushutsuJoken")
    public void setLblChushutsuJoken(Label lblChushutsuJoken) {
        this.lblChushutsuJoken = lblChushutsuJoken;
    }

    /*
     * gettxtShoriSaikuruKubun
     * @return txtShoriSaikuruKubun
     */
    @JsonProperty("txtShoriSaikuruKubun")
    public TextBox getTxtShoriSaikuruKubun() {
        return txtShoriSaikuruKubun;
    }

    /*
     * settxtShoriSaikuruKubun
     * @param txtShoriSaikuruKubun txtShoriSaikuruKubun
     */
    @JsonProperty("txtShoriSaikuruKubun")
    public void setTxtShoriSaikuruKubun(TextBox txtShoriSaikuruKubun) {
        this.txtShoriSaikuruKubun = txtShoriSaikuruKubun;
    }

    /*
     * gettxtShoritaishoNengetsu
     * @return txtShoritaishoNengetsu
     */
    @JsonProperty("txtShoritaishoNengetsu")
    public TextBoxDate getTxtShoritaishoNengetsu() {
        return txtShoritaishoNengetsu;
    }

    /*
     * settxtShoritaishoNengetsu
     * @param txtShoritaishoNengetsu txtShoritaishoNengetsu
     */
    @JsonProperty("txtShoritaishoNengetsu")
    public void setTxtShoritaishoNengetsu(TextBoxDate txtShoritaishoNengetsu) {
        this.txtShoritaishoNengetsu = txtShoritaishoNengetsu;
    }

    /*
     * gettxtsaishoriKubun
     * @return txtsaishoriKubun
     */
    @JsonProperty("txtsaishoriKubun")
    public TextBox getTxtsaishoriKubun() {
        return txtsaishoriKubun;
    }

    /*
     * settxtsaishoriKubun
     * @param txtsaishoriKubun txtsaishoriKubun
     */
    @JsonProperty("txtsaishoriKubun")
    public void setTxtsaishoriKubun(TextBox txtsaishoriKubun) {
        this.txtsaishoriKubun = txtsaishoriKubun;
    }

    /*
     * gettxtFileName
     * @return txtFileName
     */
    @JsonProperty("txtFileName")
    public TextBox getTxtFileName() {
        return txtFileName;
    }

    /*
     * settxtFileName
     * @param txtFileName txtFileName
     */
    @JsonProperty("txtFileName")
    public void setTxtFileName(TextBox txtFileName) {
        this.txtFileName = txtFileName;
    }

    /*
     * getddlSofuTaishojoho
     * @return ddlSofuTaishojoho
     */
    @JsonProperty("ddlSofuTaishojoho")
    public DropDownList getDdlSofuTaishojoho() {
        return ddlSofuTaishojoho;
    }

    /*
     * setddlSofuTaishojoho
     * @param ddlSofuTaishojoho ddlSofuTaishojoho
     */
    @JsonProperty("ddlSofuTaishojoho")
    public void setDdlSofuTaishojoho(DropDownList ddlSofuTaishojoho) {
        this.ddlSofuTaishojoho = ddlSofuTaishojoho;
    }

    /*
     * getShoriJikkoMaekakuninJiko
     * @return ShoriJikkoMaekakuninJiko
     */
    @JsonProperty("ShoriJikkoMaekakuninJiko")
    public ShoriJikkoMaekakuninJikoDiv getShoriJikkoMaekakuninJiko() {
        return ShoriJikkoMaekakuninJiko;
    }

    /*
     * setShoriJikkoMaekakuninJiko
     * @param ShoriJikkoMaekakuninJiko ShoriJikkoMaekakuninJiko
     */
    @JsonProperty("ShoriJikkoMaekakuninJiko")
    public void setShoriJikkoMaekakuninJiko(ShoriJikkoMaekakuninJikoDiv ShoriJikkoMaekakuninJiko) {
        this.ShoriJikkoMaekakuninJiko = ShoriJikkoMaekakuninJiko;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblKakuninJiko1() {
        return this.getShoriJikkoMaekakuninJiko().getLblKakuninJiko1();
    }

    @JsonIgnore
    public void setLblKakuninJiko1(Label lblKakuninJiko1) {
        this.getShoriJikkoMaekakuninJiko().setLblKakuninJiko1(lblKakuninJiko1);
    }

    @JsonIgnore
    public Label getLblKakuninJiko2() {
        return this.getShoriJikkoMaekakuninJiko().getLblKakuninJiko2();
    }

    @JsonIgnore
    public void setLblKakuninJiko2(Label lblKakuninJiko2) {
        this.getShoriJikkoMaekakuninJiko().setLblKakuninJiko2(lblKakuninJiko2);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void initialize(RYearMonth 処理年月, RString 再処理区分, RString 外部ＣＳＶファイル名, RString 状態パターン) {
        if (状態パターン.equals(new RString("1"))) {
            KokuhorenJohoSofuHandler.of(this).onLoadMode1(処理年月, 再処理区分, 外部ＣＳＶファイル名);
        }
        if (状態パターン.equals(new RString("2"))) {
            KokuhorenJohoSofuHandler.of(this).onLoadMode2(処理年月, 再処理区分, 外部ＣＳＶファイル名);
        }
    }

    @Override
    public void initialize(RYearMonth 処理年月, RString 再処理区分, RString 外部ＣＳＶファイル名, RString サイクル区分, RString 状態パターン) {
        if (状態パターン.equals(new RString("3"))) {
            KokuhorenJohoSofuHandler.of(this).onLoadMode3(処理年月, 再処理区分, 外部ＣＳＶファイル名, サイクル区分);
        }
        if (状態パターン.equals(new RString("4"))) {
            KokuhorenJohoSofuHandler.of(this).onLoadMode4(処理年月, 再処理区分, 外部ＣＳＶファイル名, サイクル区分);
        }
    }

    @Override
    public RString get送付対象情報のkey() {
        return KokuhorenJohoSofuHandler.of(this).get送付対象情報のkey();
    }

    @Override
    public RString get送付対象情報のValue() {
        return KokuhorenJohoSofuHandler.of(this).get送付対象情報のValue();
    }

    @Override
    public RDate get処理年月のValue() {
        return KokuhorenJohoSofuHandler.of(this).get処理年月のValue();
    }

    @Override
    public RString get再処理区分のValue() {
        return KokuhorenJohoSofuHandler.of(this).get再処理区分のValue();
    }
}
