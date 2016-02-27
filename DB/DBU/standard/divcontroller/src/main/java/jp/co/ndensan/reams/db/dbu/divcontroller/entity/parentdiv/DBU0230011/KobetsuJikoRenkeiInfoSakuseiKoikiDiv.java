package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0230011;
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
 * KobetsuJikoRenkeiInfoSakuseiKoiki のクラスファイル 
 * 
 * @author 自動生成
 */
public class KobetsuJikoRenkeiInfoSakuseiKoikiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KobetsuJikoRenkeiInfoSakuseiKoikiBP")
    private KobetsuJikoRenkeiInfoSakuseiKoikiBPDiv KobetsuJikoRenkeiInfoSakuseiKoikiBP;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKobetsuJikoRenkeiInfoSakuseiKoikiBP
     * @return KobetsuJikoRenkeiInfoSakuseiKoikiBP
     */
    @JsonProperty("KobetsuJikoRenkeiInfoSakuseiKoikiBP")
    public KobetsuJikoRenkeiInfoSakuseiKoikiBPDiv getKobetsuJikoRenkeiInfoSakuseiKoikiBP() {
        return KobetsuJikoRenkeiInfoSakuseiKoikiBP;
    }

    /*
     * setKobetsuJikoRenkeiInfoSakuseiKoikiBP
     * @param KobetsuJikoRenkeiInfoSakuseiKoikiBP KobetsuJikoRenkeiInfoSakuseiKoikiBP
     */
    @JsonProperty("KobetsuJikoRenkeiInfoSakuseiKoikiBP")
    public void setKobetsuJikoRenkeiInfoSakuseiKoikiBP(KobetsuJikoRenkeiInfoSakuseiKoikiBPDiv KobetsuJikoRenkeiInfoSakuseiKoikiBP) {
        this.KobetsuJikoRenkeiInfoSakuseiKoikiBP = KobetsuJikoRenkeiInfoSakuseiKoikiBP;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DataGrid<dgKobetsuJikoRenkeiInfoSakuseiKoik_Row> getDgKobetsuJikoRenkeiInfoSakuseiKoik() {
        return this.getKobetsuJikoRenkeiInfoSakuseiKoikiBP().getDgKobetsuJikoRenkeiInfoSakuseiKoik();
    }

    @JsonIgnore
    public void  setDgKobetsuJikoRenkeiInfoSakuseiKoik(DataGrid<dgKobetsuJikoRenkeiInfoSakuseiKoik_Row> dgKobetsuJikoRenkeiInfoSakuseiKoik) {
        this.getKobetsuJikoRenkeiInfoSakuseiKoikiBP().setDgKobetsuJikoRenkeiInfoSakuseiKoik(dgKobetsuJikoRenkeiInfoSakuseiKoik);
    }

    @JsonIgnore
    public KonkaiInfoInputDiv getKonkaiInfoInput() {
        return this.getKobetsuJikoRenkeiInfoSakuseiKoikiBP().getKonkaiInfoInput();
    }

    @JsonIgnore
    public void  setKonkaiInfoInput(KonkaiInfoInputDiv KonkaiInfoInput) {
        this.getKobetsuJikoRenkeiInfoSakuseiKoikiBP().setKonkaiInfoInput(KonkaiInfoInput);
    }

    @JsonIgnore
    public TextBox getTxtSofuShichoShon() {
        return this.getKobetsuJikoRenkeiInfoSakuseiKoikiBP().getKonkaiInfoInput().getTxtSofuShichoShon();
    }

    @JsonIgnore
    public void  setTxtSofuShichoShon(TextBox txtSofuShichoShon) {
        this.getKobetsuJikoRenkeiInfoSakuseiKoikiBP().getKonkaiInfoInput().setTxtSofuShichoShon(txtSofuShichoShon);
    }

    @JsonIgnore
    public tblkonkaiInfoInputDiv getTblkonkaiInfoInput() {
        return this.getKobetsuJikoRenkeiInfoSakuseiKoikiBP().getKonkaiInfoInput().getTblkonkaiInfoInput();
    }

    @JsonIgnore
    public void  setTblkonkaiInfoInput(tblkonkaiInfoInputDiv tblkonkaiInfoInput) {
        this.getKobetsuJikoRenkeiInfoSakuseiKoikiBP().getKonkaiInfoInput().setTblkonkaiInfoInput(tblkonkaiInfoInput);
    }

    @JsonIgnore
    public Label getLblStYMD() {
        return this.getKobetsuJikoRenkeiInfoSakuseiKoikiBP().getKonkaiInfoInput().getTblkonkaiInfoInput().getLblStYMD();
    }

    @JsonIgnore
    public Label getLblStTime() {
        return this.getKobetsuJikoRenkeiInfoSakuseiKoikiBP().getKonkaiInfoInput().getTblkonkaiInfoInput().getLblStTime();
    }

    @JsonIgnore
    public Label getLblEdYMD() {
        return this.getKobetsuJikoRenkeiInfoSakuseiKoikiBP().getKonkaiInfoInput().getTblkonkaiInfoInput().getLblEdYMD();
    }

    @JsonIgnore
    public Label getLblEdTime() {
        return this.getKobetsuJikoRenkeiInfoSakuseiKoikiBP().getKonkaiInfoInput().getTblkonkaiInfoInput().getLblEdTime();
    }

    @JsonIgnore
    public ZenkenDiv getZenken() {
        return this.getKobetsuJikoRenkeiInfoSakuseiKoikiBP().getKonkaiInfoInput().getTblkonkaiInfoInput().getZenken();
    }

    @JsonIgnore
    public CheckBoxList getChkZenken() {
        return this.getKobetsuJikoRenkeiInfoSakuseiKoikiBP().getKonkaiInfoInput().getTblkonkaiInfoInput().getZenken().getChkZenken();
    }

    @JsonIgnore
    public void  setChkZenken(CheckBoxList chkZenken) {
        this.getKobetsuJikoRenkeiInfoSakuseiKoikiBP().getKonkaiInfoInput().getTblkonkaiInfoInput().getZenken().setChkZenken(chkZenken);
    }

    @JsonIgnore
    public Label getLblZenkaiChushutsu() {
        return this.getKobetsuJikoRenkeiInfoSakuseiKoikiBP().getKonkaiInfoInput().getTblkonkaiInfoInput().getLblZenkaiChushutsu();
    }

    @JsonIgnore
    public TextBoxDate getTxtZenkaiChushutsuFromYMD() {
        return this.getKobetsuJikoRenkeiInfoSakuseiKoikiBP().getKonkaiInfoInput().getTblkonkaiInfoInput().getTxtZenkaiChushutsuFromYMD();
    }

    @JsonIgnore
    public TextBoxTime getTxtZenkaiChushutsuFromTime() {
        return this.getKobetsuJikoRenkeiInfoSakuseiKoikiBP().getKonkaiInfoInput().getTblkonkaiInfoInput().getTxtZenkaiChushutsuFromTime();
    }

    @JsonIgnore
    public Label getLblKara() {
        return this.getKobetsuJikoRenkeiInfoSakuseiKoikiBP().getKonkaiInfoInput().getTblkonkaiInfoInput().getLblKara();
    }

    @JsonIgnore
    public TextBoxDate getTxtZenkaiChushutsuToYMD() {
        return this.getKobetsuJikoRenkeiInfoSakuseiKoikiBP().getKonkaiInfoInput().getTblkonkaiInfoInput().getTxtZenkaiChushutsuToYMD();
    }

    @JsonIgnore
    public TextBoxTime getTxtZenkaiChushutsuToTime() {
        return this.getKobetsuJikoRenkeiInfoSakuseiKoikiBP().getKonkaiInfoInput().getTblkonkaiInfoInput().getTxtZenkaiChushutsuToTime();
    }

    @JsonIgnore
    public Label getLblKonkaiChushutsu() {
        return this.getKobetsuJikoRenkeiInfoSakuseiKoikiBP().getKonkaiInfoInput().getTblkonkaiInfoInput().getLblKonkaiChushutsu();
    }

    @JsonIgnore
    public TextBoxDate getTxtKonkaiChushutsuFromYMD() {
        return this.getKobetsuJikoRenkeiInfoSakuseiKoikiBP().getKonkaiInfoInput().getTblkonkaiInfoInput().getTxtKonkaiChushutsuFromYMD();
    }

    @JsonIgnore
    public TextBoxTime getTxtKonkaiChushutsuFromTime() {
        return this.getKobetsuJikoRenkeiInfoSakuseiKoikiBP().getKonkaiInfoInput().getTblkonkaiInfoInput().getTxtKonkaiChushutsuFromTime();
    }

    @JsonIgnore
    public Label getLblKara2() {
        return this.getKobetsuJikoRenkeiInfoSakuseiKoikiBP().getKonkaiInfoInput().getTblkonkaiInfoInput().getLblKara2();
    }

    @JsonIgnore
    public Button getBtnKakutei() {
        return this.getKobetsuJikoRenkeiInfoSakuseiKoikiBP().getKonkaiInfoInput().getTblkonkaiInfoInput().getBtnKakutei();
    }

    @JsonIgnore
    public Button getBtnClose() {
        return this.getKobetsuJikoRenkeiInfoSakuseiKoikiBP().getKonkaiInfoInput().getTblkonkaiInfoInput().getBtnClose();
    }

    // </editor-fold>
}
