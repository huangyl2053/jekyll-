package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0210011;
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
 * KobetsuJikoRenkeiInfoSakusei のクラスファイル 
 * 
 * @author 自動生成
 */
public class KobetsuJikoRenkeiInfoSakuseiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KobetsuJikoRenkeiInfoSakuseiBP")
    private KobetsuJikoRenkeiInfoSakuseiBPDiv KobetsuJikoRenkeiInfoSakuseiBP;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKobetsuJikoRenkeiInfoSakuseiBP
     * @return KobetsuJikoRenkeiInfoSakuseiBP
     */
    @JsonProperty("KobetsuJikoRenkeiInfoSakuseiBP")
    public KobetsuJikoRenkeiInfoSakuseiBPDiv getKobetsuJikoRenkeiInfoSakuseiBP() {
        return KobetsuJikoRenkeiInfoSakuseiBP;
    }

    /*
     * setKobetsuJikoRenkeiInfoSakuseiBP
     * @param KobetsuJikoRenkeiInfoSakuseiBP KobetsuJikoRenkeiInfoSakuseiBP
     */
    @JsonProperty("KobetsuJikoRenkeiInfoSakuseiBP")
    public void setKobetsuJikoRenkeiInfoSakuseiBP(KobetsuJikoRenkeiInfoSakuseiBPDiv KobetsuJikoRenkeiInfoSakuseiBP) {
        this.KobetsuJikoRenkeiInfoSakuseiBP = KobetsuJikoRenkeiInfoSakuseiBP;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblKikan() {
        return this.getKobetsuJikoRenkeiInfoSakuseiBP().getLblKikan();
    }

    @JsonIgnore
    public void  setLblKikan(Label lblKikan) {
        this.getKobetsuJikoRenkeiInfoSakuseiBP().setLblKikan(lblKikan);
    }

    @JsonIgnore
    public ChushutsuKikanDiv getChushutsuKikan() {
        return this.getKobetsuJikoRenkeiInfoSakuseiBP().getChushutsuKikan();
    }

    @JsonIgnore
    public void  setChushutsuKikan(ChushutsuKikanDiv ChushutsuKikan) {
        this.getKobetsuJikoRenkeiInfoSakuseiBP().setChushutsuKikan(ChushutsuKikan);
    }

    @JsonIgnore
    public tblChushutsuKikanDiv getTblChushutsuKikan() {
        return this.getKobetsuJikoRenkeiInfoSakuseiBP().getChushutsuKikan().getTblChushutsuKikan();
    }

    @JsonIgnore
    public void  setTblChushutsuKikan(tblChushutsuKikanDiv tblChushutsuKikan) {
        this.getKobetsuJikoRenkeiInfoSakuseiBP().getChushutsuKikan().setTblChushutsuKikan(tblChushutsuKikan);
    }

    @JsonIgnore
    public Label getLblStYMD() {
        return this.getKobetsuJikoRenkeiInfoSakuseiBP().getChushutsuKikan().getTblChushutsuKikan().getLblStYMD();
    }

    @JsonIgnore
    public Label getLblStTime() {
        return this.getKobetsuJikoRenkeiInfoSakuseiBP().getChushutsuKikan().getTblChushutsuKikan().getLblStTime();
    }

    @JsonIgnore
    public Label getLblEdYMD() {
        return this.getKobetsuJikoRenkeiInfoSakuseiBP().getChushutsuKikan().getTblChushutsuKikan().getLblEdYMD();
    }

    @JsonIgnore
    public Label getLblEdTime() {
        return this.getKobetsuJikoRenkeiInfoSakuseiBP().getChushutsuKikan().getTblChushutsuKikan().getLblEdTime();
    }

    @JsonIgnore
    public ZenkenDiv getZenken() {
        return this.getKobetsuJikoRenkeiInfoSakuseiBP().getChushutsuKikan().getTblChushutsuKikan().getZenken();
    }

    @JsonIgnore
    public CheckBoxList getChkZenken() {
        return this.getKobetsuJikoRenkeiInfoSakuseiBP().getChushutsuKikan().getTblChushutsuKikan().getZenken().getChkZenken();
    }

    @JsonIgnore
    public void  setChkZenken(CheckBoxList chkZenken) {
        this.getKobetsuJikoRenkeiInfoSakuseiBP().getChushutsuKikan().getTblChushutsuKikan().getZenken().setChkZenken(chkZenken);
    }

    @JsonIgnore
    public Label getLblZenkaiChushutsu() {
        return this.getKobetsuJikoRenkeiInfoSakuseiBP().getChushutsuKikan().getTblChushutsuKikan().getLblZenkaiChushutsu();
    }

    @JsonIgnore
    public TextBoxDate getTxtZenkaiChushutsuFromYMD() {
        return this.getKobetsuJikoRenkeiInfoSakuseiBP().getChushutsuKikan().getTblChushutsuKikan().getTxtZenkaiChushutsuFromYMD();
    }

    @JsonIgnore
    public TextBoxTime getTxtZenkaiChushutsuFromTime() {
        return this.getKobetsuJikoRenkeiInfoSakuseiBP().getChushutsuKikan().getTblChushutsuKikan().getTxtZenkaiChushutsuFromTime();
    }

    @JsonIgnore
    public Label getLblKara1() {
        return this.getKobetsuJikoRenkeiInfoSakuseiBP().getChushutsuKikan().getTblChushutsuKikan().getLblKara1();
    }

    @JsonIgnore
    public TextBoxDate getTxtZenkaiChushutsuToYMD() {
        return this.getKobetsuJikoRenkeiInfoSakuseiBP().getChushutsuKikan().getTblChushutsuKikan().getTxtZenkaiChushutsuToYMD();
    }

    @JsonIgnore
    public TextBoxTime getTxtZenkaiChushutsuToTime() {
        return this.getKobetsuJikoRenkeiInfoSakuseiBP().getChushutsuKikan().getTblChushutsuKikan().getTxtZenkaiChushutsuToTime();
    }

    @JsonIgnore
    public Label getLblKonkaiChushutsu() {
        return this.getKobetsuJikoRenkeiInfoSakuseiBP().getChushutsuKikan().getTblChushutsuKikan().getLblKonkaiChushutsu();
    }

    @JsonIgnore
    public TextBoxDate getTxtKonkaiChushutsuFromYMD() {
        return this.getKobetsuJikoRenkeiInfoSakuseiBP().getChushutsuKikan().getTblChushutsuKikan().getTxtKonkaiChushutsuFromYMD();
    }

    @JsonIgnore
    public TextBoxTime getTxtKonkaiChushutsuFromTime() {
        return this.getKobetsuJikoRenkeiInfoSakuseiBP().getChushutsuKikan().getTblChushutsuKikan().getTxtKonkaiChushutsuFromTime();
    }

    @JsonIgnore
    public Label getLblKara2() {
        return this.getKobetsuJikoRenkeiInfoSakuseiBP().getChushutsuKikan().getTblChushutsuKikan().getLblKara2();
    }

    @JsonIgnore
    public CheckBoxList getChkKikanHenko() {
        return this.getKobetsuJikoRenkeiInfoSakuseiBP().getChushutsuKikan().getTblChushutsuKikan().getChkKikanHenko();
    }

    // </editor-fold>
}
