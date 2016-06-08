package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3110001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KiwarigakuKanendo2 のクラスファイル 
 * 
 * @author 自動生成
 */
public class KiwarigakuKanendo2Div extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKanendoChoteiYY2")
    private TextBoxDate txtKanendoChoteiYY2;
    @JsonProperty("txtKanendoFukaYY2")
    private TextBoxDate txtKanendoFukaYY2;
    @JsonProperty("KiwarigakuPanel3")
    private KiwarigakuPanel3Div KiwarigakuPanel3;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKanendoChoteiYY2
     * @return txtKanendoChoteiYY2
     */
    @JsonProperty("txtKanendoChoteiYY2")
    public TextBoxDate getTxtKanendoChoteiYY2() {
        return txtKanendoChoteiYY2;
    }

    /*
     * settxtKanendoChoteiYY2
     * @param txtKanendoChoteiYY2 txtKanendoChoteiYY2
     */
    @JsonProperty("txtKanendoChoteiYY2")
    public void setTxtKanendoChoteiYY2(TextBoxDate txtKanendoChoteiYY2) {
        this.txtKanendoChoteiYY2 = txtKanendoChoteiYY2;
    }

    /*
     * gettxtKanendoFukaYY2
     * @return txtKanendoFukaYY2
     */
    @JsonProperty("txtKanendoFukaYY2")
    public TextBoxDate getTxtKanendoFukaYY2() {
        return txtKanendoFukaYY2;
    }

    /*
     * settxtKanendoFukaYY2
     * @param txtKanendoFukaYY2 txtKanendoFukaYY2
     */
    @JsonProperty("txtKanendoFukaYY2")
    public void setTxtKanendoFukaYY2(TextBoxDate txtKanendoFukaYY2) {
        this.txtKanendoFukaYY2 = txtKanendoFukaYY2;
    }

    /*
     * getKiwarigakuPanel3
     * @return KiwarigakuPanel3
     */
    @JsonProperty("KiwarigakuPanel3")
    public KiwarigakuPanel3Div getKiwarigakuPanel3() {
        return KiwarigakuPanel3;
    }

    /*
     * setKiwarigakuPanel3
     * @param KiwarigakuPanel3 KiwarigakuPanel3
     */
    @JsonProperty("KiwarigakuPanel3")
    public void setKiwarigakuPanel3(KiwarigakuPanel3Div KiwarigakuPanel3) {
        this.KiwarigakuPanel3 = KiwarigakuPanel3;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblKiwarigaku3Tsuki() {
        return this.getKiwarigakuPanel3().getLblKiwarigaku3Tsuki();
    }

    @JsonIgnore
    public Label getLblKi3() {
        return this.getKiwarigakuPanel3().getLblKi3();
    }

    @JsonIgnore
    public Label getLblGemmemMae3() {
        return this.getKiwarigakuPanel3().getLblGemmemMae3();
    }

    @JsonIgnore
    public Label getLblGemmemGo3() {
        return this.getKiwarigakuPanel3().getLblGemmemGo3();
    }

    @JsonIgnore
    public Label getLblNokigen3() {
        return this.getKiwarigakuPanel3().getLblNokigen3();
    }

    @JsonIgnore
    public Label getLblKiwarigaku34Gatsu() {
        return this.getKiwarigakuPanel3().getLblKiwarigaku34Gatsu();
    }

    @JsonIgnore
    public Label getLblKiwarigaku3Total() {
        return this.getKiwarigakuPanel3().getLblKiwarigaku3Total();
    }

    // </editor-fold>
}
