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
 * ChushutsuKikan のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChushutsuKikanDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblChushutsuKikan")
    private tblChushutsuKikanDiv tblChushutsuKikan;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettblChushutsuKikan
     * @return tblChushutsuKikan
     */
    @JsonProperty("tblChushutsuKikan")
    public tblChushutsuKikanDiv getTblChushutsuKikan() {
        return tblChushutsuKikan;
    }

    /*
     * settblChushutsuKikan
     * @param tblChushutsuKikan tblChushutsuKikan
     */
    @JsonProperty("tblChushutsuKikan")
    public void setTblChushutsuKikan(tblChushutsuKikanDiv tblChushutsuKikan) {
        this.tblChushutsuKikan = tblChushutsuKikan;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblStYMD() {
        return this.getTblChushutsuKikan().getLblStYMD();
    }

    @JsonIgnore
    public Label getLblStTime() {
        return this.getTblChushutsuKikan().getLblStTime();
    }

    @JsonIgnore
    public Label getLblEdYMD() {
        return this.getTblChushutsuKikan().getLblEdYMD();
    }

    @JsonIgnore
    public Label getLblEdTime() {
        return this.getTblChushutsuKikan().getLblEdTime();
    }

    @JsonIgnore
    public ZenkenDiv getZenken() {
        return this.getTblChushutsuKikan().getZenken();
    }

    @JsonIgnore
    public CheckBoxList getChkZenken() {
        return this.getTblChushutsuKikan().getZenken().getChkZenken();
    }

    @JsonIgnore
    public void  setChkZenken(CheckBoxList chkZenken) {
        this.getTblChushutsuKikan().getZenken().setChkZenken(chkZenken);
    }

    @JsonIgnore
    public Label getLblZenkaiChushutsu() {
        return this.getTblChushutsuKikan().getLblZenkaiChushutsu();
    }

    @JsonIgnore
    public TextBoxDate getTxtZenkaiChushutsuFromYMD() {
        return this.getTblChushutsuKikan().getTxtZenkaiChushutsuFromYMD();
    }

    @JsonIgnore
    public TextBoxTime getTxtZenkaiChushutsuFromTime() {
        return this.getTblChushutsuKikan().getTxtZenkaiChushutsuFromTime();
    }

    @JsonIgnore
    public Label getLblKara1() {
        return this.getTblChushutsuKikan().getLblKara1();
    }

    @JsonIgnore
    public TextBoxDate getTxtZenkaiChushutsuToYMD() {
        return this.getTblChushutsuKikan().getTxtZenkaiChushutsuToYMD();
    }

    @JsonIgnore
    public TextBoxTime getTxtZenkaiChushutsuToTime() {
        return this.getTblChushutsuKikan().getTxtZenkaiChushutsuToTime();
    }

    @JsonIgnore
    public Label getLblKonkaiChushutsu() {
        return this.getTblChushutsuKikan().getLblKonkaiChushutsu();
    }

    @JsonIgnore
    public TextBoxDate getTxtKonkaiChushutsuFromYMD() {
        return this.getTblChushutsuKikan().getTxtKonkaiChushutsuFromYMD();
    }

    @JsonIgnore
    public TextBoxTime getTxtKonkaiChushutsuFromTime() {
        return this.getTblChushutsuKikan().getTxtKonkaiChushutsuFromTime();
    }

    @JsonIgnore
    public Label getLblKara2() {
        return this.getTblChushutsuKikan().getLblKara2();
    }

    @JsonIgnore
    public CheckBoxList getChkKikanHenko() {
        return this.getTblChushutsuKikan().getChkKikanHenko();
    }

    // </editor-fold>
}
