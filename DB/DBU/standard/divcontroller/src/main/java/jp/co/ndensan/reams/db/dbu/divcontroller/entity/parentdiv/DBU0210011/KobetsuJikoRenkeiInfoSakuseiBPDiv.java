package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0210011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * KobetsuJikoRenkeiInfoSakuseiBP のクラスファイル 
 * 
 * @author 自動生成
 */
public class KobetsuJikoRenkeiInfoSakuseiBPDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblKikan")
    private Label lblKikan;
    @JsonProperty("ChushutsuKikan")
    private ChushutsuKikanDiv ChushutsuKikan;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblKikan
     * @return lblKikan
     */
    @JsonProperty("lblKikan")
    public Label getLblKikan() {
        return lblKikan;
    }

    /*
     * setlblKikan
     * @param lblKikan lblKikan
     */
    @JsonProperty("lblKikan")
    public void setLblKikan(Label lblKikan) {
        this.lblKikan = lblKikan;
    }

    /*
     * getChushutsuKikan
     * @return ChushutsuKikan
     */
    @JsonProperty("ChushutsuKikan")
    public ChushutsuKikanDiv getChushutsuKikan() {
        return ChushutsuKikan;
    }

    /*
     * setChushutsuKikan
     * @param ChushutsuKikan ChushutsuKikan
     */
    @JsonProperty("ChushutsuKikan")
    public void setChushutsuKikan(ChushutsuKikanDiv ChushutsuKikan) {
        this.ChushutsuKikan = ChushutsuKikan;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public tblChushutsuKikanDiv getTblChushutsuKikan() {
        return this.getChushutsuKikan().getTblChushutsuKikan();
    }

    @JsonIgnore
    public void  setTblChushutsuKikan(tblChushutsuKikanDiv tblChushutsuKikan) {
        this.getChushutsuKikan().setTblChushutsuKikan(tblChushutsuKikan);
    }

    @JsonIgnore
    public Label getLblStYMD() {
        return this.getChushutsuKikan().getTblChushutsuKikan().getLblStYMD();
    }

    @JsonIgnore
    public Label getLblStTime() {
        return this.getChushutsuKikan().getTblChushutsuKikan().getLblStTime();
    }

    @JsonIgnore
    public Label getLblEdYMD() {
        return this.getChushutsuKikan().getTblChushutsuKikan().getLblEdYMD();
    }

    @JsonIgnore
    public Label getLblEdTime() {
        return this.getChushutsuKikan().getTblChushutsuKikan().getLblEdTime();
    }

    @JsonIgnore
    public ZenkenDiv getZenken() {
        return this.getChushutsuKikan().getTblChushutsuKikan().getZenken();
    }

    @JsonIgnore
    public CheckBoxList getChkZenken() {
        return this.getChushutsuKikan().getTblChushutsuKikan().getZenken().getChkZenken();
    }

    @JsonIgnore
    public void  setChkZenken(CheckBoxList chkZenken) {
        this.getChushutsuKikan().getTblChushutsuKikan().getZenken().setChkZenken(chkZenken);
    }

    @JsonIgnore
    public Label getLblZenkaiChushutsu() {
        return this.getChushutsuKikan().getTblChushutsuKikan().getLblZenkaiChushutsu();
    }

    @JsonIgnore
    public TextBoxDate getTxtZenkaiChushutsuFromYMD() {
        return this.getChushutsuKikan().getTblChushutsuKikan().getTxtZenkaiChushutsuFromYMD();
    }

    @JsonIgnore
    public TextBoxTime getTxtZenkaiChushutsuFromTime() {
        return this.getChushutsuKikan().getTblChushutsuKikan().getTxtZenkaiChushutsuFromTime();
    }

    @JsonIgnore
    public Label getLblKara1() {
        return this.getChushutsuKikan().getTblChushutsuKikan().getLblKara1();
    }

    @JsonIgnore
    public TextBoxDate getTxtZenkaiChushutsuToYMD() {
        return this.getChushutsuKikan().getTblChushutsuKikan().getTxtZenkaiChushutsuToYMD();
    }

    @JsonIgnore
    public TextBoxTime getTxtZenkaiChushutsuToTime() {
        return this.getChushutsuKikan().getTblChushutsuKikan().getTxtZenkaiChushutsuToTime();
    }

    @JsonIgnore
    public Label getLblKonkaiChushutsu() {
        return this.getChushutsuKikan().getTblChushutsuKikan().getLblKonkaiChushutsu();
    }

    @JsonIgnore
    public TextBoxDate getTxtKonkaiChushutsuFromYMD() {
        return this.getChushutsuKikan().getTblChushutsuKikan().getTxtKonkaiChushutsuFromYMD();
    }

    @JsonIgnore
    public TextBoxTime getTxtKonkaiChushutsuFromTime() {
        return this.getChushutsuKikan().getTblChushutsuKikan().getTxtKonkaiChushutsuFromTime();
    }

    @JsonIgnore
    public Label getLblKara2() {
        return this.getChushutsuKikan().getTblChushutsuKikan().getLblKara2();
    }

    @JsonIgnore
    public CheckBoxList getChkKikanHenko() {
        return this.getChushutsuKikan().getTblChushutsuKikan().getChkKikanHenko();
    }

    // </editor-fold>
}
