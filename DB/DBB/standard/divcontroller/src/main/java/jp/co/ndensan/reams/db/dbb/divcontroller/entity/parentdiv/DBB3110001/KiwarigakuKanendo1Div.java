package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3110001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * KiwarigakuKanendo1 のクラスファイル
 *
 * @reamsid_L DBB-1660-010 gongliang
 */
public class KiwarigakuKanendo1Div extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKanendoChoteiYY1")
    private TextBoxDate txtKanendoChoteiYY1;
    @JsonProperty("txtKanendoFukaYY1")
    private TextBoxDate txtKanendoFukaYY1;
    @JsonProperty("KiwarigakuPanel2")
    private KiwarigakuPanel2Div KiwarigakuPanel2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKanendoChoteiYY1
     * @return txtKanendoChoteiYY1
     */
    @JsonProperty("txtKanendoChoteiYY1")
    public TextBoxDate getTxtKanendoChoteiYY1() {
        return txtKanendoChoteiYY1;
    }

    /*
     * settxtKanendoChoteiYY1
     * @param txtKanendoChoteiYY1 txtKanendoChoteiYY1
     */
    @JsonProperty("txtKanendoChoteiYY1")
    public void setTxtKanendoChoteiYY1(TextBoxDate txtKanendoChoteiYY1) {
        this.txtKanendoChoteiYY1 = txtKanendoChoteiYY1;
    }

    /*
     * gettxtKanendoFukaYY1
     * @return txtKanendoFukaYY1
     */
    @JsonProperty("txtKanendoFukaYY1")
    public TextBoxDate getTxtKanendoFukaYY1() {
        return txtKanendoFukaYY1;
    }

    /*
     * settxtKanendoFukaYY1
     * @param txtKanendoFukaYY1 txtKanendoFukaYY1
     */
    @JsonProperty("txtKanendoFukaYY1")
    public void setTxtKanendoFukaYY1(TextBoxDate txtKanendoFukaYY1) {
        this.txtKanendoFukaYY1 = txtKanendoFukaYY1;
    }

    /*
     * getKiwarigakuPanel2
     * @return KiwarigakuPanel2
     */
    @JsonProperty("KiwarigakuPanel2")
    public KiwarigakuPanel2Div getKiwarigakuPanel2() {
        return KiwarigakuPanel2;
    }

    /*
     * setKiwarigakuPanel2
     * @param KiwarigakuPanel2 KiwarigakuPanel2
     */
    @JsonProperty("KiwarigakuPanel2")
    public void setKiwarigakuPanel2(KiwarigakuPanel2Div KiwarigakuPanel2) {
        this.KiwarigakuPanel2 = KiwarigakuPanel2;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblKiwarigaku2Tsuki() {
        return this.getKiwarigakuPanel2().getLblKiwarigaku2Tsuki();
    }

    @JsonIgnore
    public Label getLblKi2() {
        return this.getKiwarigakuPanel2().getLblKi2();
    }

    @JsonIgnore
    public Label getLblGemmemMae2() {
        return this.getKiwarigakuPanel2().getLblGemmemMae2();
    }

    @JsonIgnore
    public Label getLblGemmemGo2() {
        return this.getKiwarigakuPanel2().getLblGemmemGo2();
    }

    @JsonIgnore
    public Label getLblNokigen2() {
        return this.getKiwarigakuPanel2().getLblNokigen2();
    }

    @JsonIgnore
    public Label getLblKiwarigaku24Gatsu() {
        return this.getKiwarigakuPanel2().getLblKiwarigaku24Gatsu();
    }

    @JsonIgnore
    public Label getKi1() {
        return this.getKiwarigakuPanel2().getKi1();
    }

    @JsonIgnore
    public Label getMae1() {
        return this.getKiwarigakuPanel2().getMae1();
    }

    @JsonIgnore
    public Label getGo1() {
        return this.getKiwarigakuPanel2().getGo1();
    }

    @JsonIgnore
    public Label getNokigen1() {
        return this.getKiwarigakuPanel2().getNokigen1();
    }

    @JsonIgnore
    public Label getLblKiwarigaku2Total() {
        return this.getKiwarigakuPanel2().getLblKiwarigaku2Total();
    }

    @JsonIgnore
    public Label getMaeTotalMae1() {
        return this.getKiwarigakuPanel2().getMaeTotalMae1();
    }

    @JsonIgnore
    public Label getMaeTotalGo1() {
        return this.getKiwarigakuPanel2().getMaeTotalGo1();
    }

    // </editor-fold>
}
