package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020031;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.TableCell;
import jp.co.ndensan.reams.uz.uza.ui.binding.TablePanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;

/**
 * tplDaigoNi のクラスファイル
 *
 * @reamsid_L DBU-1100-030 wangkanglei
 */
public class tplDaigoNiDiv extends TablePanel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("cel411")
    private cel411AttplDaigoNi cel411;
    @JsonProperty("TableCell1")
    private TableCell1AttplDaigoNi TableCell1;
    @JsonProperty("TableCell2")
    private TableCell2AttplDaigoNi TableCell2;
    @JsonProperty("TableCell3")
    private TableCell3AttplDaigoNi TableCell3;
    @JsonProperty("TableCell4")
    private TableCell4AttplDaigoNi TableCell4;
    @JsonProperty("TableCell5")
    private TableCell5AttplDaigoNi TableCell5;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public TextBox getTxtShinseiKensu() {
        return this.TableCell1.getTxtShinseiKensu();
    }

    @JsonIgnore
    public TextBox getTxtGengakuNinteiKensu() {
        return this.TableCell2.getTxtGengakuNinteiKensu();
    }

    @JsonIgnore
    public TextBox getTxtNinteiKensuGenzaiGengaku() {
        return this.TableCell3.getTxtNinteiKensuGenzaiGengaku();
    }

    @JsonIgnore
    public TextBox getTxtMenjoNinteiKensu() {
        return this.TableCell4.getTxtMenjoNinteiKensu();
    }

    @JsonIgnore
    public TextBox getTxtNinteiKensuGenzaiMenjo() {
        return this.TableCell5.getTxtNinteiKensuGenzaiMenjo();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcel411
     * @return cel411
     */
    @JsonProperty("cel411")
    private cel411AttplDaigoNi getCel411() {
        return cel411;
    }

    /*
     * setcel411
     * @param cel411 cel411
     */
    @JsonProperty("cel411")
    private void setCel411(cel411AttplDaigoNi cel411) {
        this.cel411 = cel411;
    }

    /*
     * getTableCell1
     * @return TableCell1
     */
    @JsonProperty("TableCell1")
    private TableCell1AttplDaigoNi getTableCell1() {
        return TableCell1;
    }

    /*
     * setTableCell1
     * @param TableCell1 TableCell1
     */
    @JsonProperty("TableCell1")
    private void setTableCell1(TableCell1AttplDaigoNi TableCell1) {
        this.TableCell1 = TableCell1;
    }

    /*
     * getTableCell2
     * @return TableCell2
     */
    @JsonProperty("TableCell2")
    private TableCell2AttplDaigoNi getTableCell2() {
        return TableCell2;
    }

    /*
     * setTableCell2
     * @param TableCell2 TableCell2
     */
    @JsonProperty("TableCell2")
    private void setTableCell2(TableCell2AttplDaigoNi TableCell2) {
        this.TableCell2 = TableCell2;
    }

    /*
     * getTableCell3
     * @return TableCell3
     */
    @JsonProperty("TableCell3")
    private TableCell3AttplDaigoNi getTableCell3() {
        return TableCell3;
    }

    /*
     * setTableCell3
     * @param TableCell3 TableCell3
     */
    @JsonProperty("TableCell3")
    private void setTableCell3(TableCell3AttplDaigoNi TableCell3) {
        this.TableCell3 = TableCell3;
    }

    /*
     * getTableCell4
     * @return TableCell4
     */
    @JsonProperty("TableCell4")
    private TableCell4AttplDaigoNi getTableCell4() {
        return TableCell4;
    }

    /*
     * setTableCell4
     * @param TableCell4 TableCell4
     */
    @JsonProperty("TableCell4")
    private void setTableCell4(TableCell4AttplDaigoNi TableCell4) {
        this.TableCell4 = TableCell4;
    }

    /*
     * getTableCell5
     * @return TableCell5
     */
    @JsonProperty("TableCell5")
    private TableCell5AttplDaigoNi getTableCell5() {
        return TableCell5;
    }

    /*
     * setTableCell5
     * @param TableCell5 TableCell5
     */
    @JsonProperty("TableCell5")
    private void setTableCell5(TableCell5AttplDaigoNi TableCell5) {
        this.TableCell5 = TableCell5;
    }

    // </editor-fold>
}

/**
 * cel411 のクラスファイル
 *
 * @author 自動生成
 */
class cel411AttplDaigoNi extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">

    // </editor-fold>
}

/**
 * TableCell1 のクラスファイル
 *
 * @author 自動生成
 */
class TableCell1AttplDaigoNi extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    @JsonProperty("txtShinseiKensu")
    private TextBox txtShinseiKensu;

    /*
     * gettxtShinseiKensu
     * @return txtShinseiKensu
     */
    @JsonProperty("txtShinseiKensu")
    public TextBox getTxtShinseiKensu() {
        return txtShinseiKensu;
    }

    /*
     * settxtShinseiKensu
     * @param txtShinseiKensu txtShinseiKensu
     */
    @JsonProperty("txtShinseiKensu")
    public void setTxtShinseiKensu(TextBox txtShinseiKensu) {
        this.txtShinseiKensu = txtShinseiKensu;
    }

    // </editor-fold>
}

/**
 * TableCell2 のクラスファイル
 *
 * @author 自動生成
 */
class TableCell2AttplDaigoNi extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    @JsonProperty("txtGengakuNinteiKensu")
    private TextBox txtGengakuNinteiKensu;

    /*
     * gettxtGengakuNinteiKensu
     * @return txtGengakuNinteiKensu
     */
    @JsonProperty("txtGengakuNinteiKensu")
    public TextBox getTxtGengakuNinteiKensu() {
        return txtGengakuNinteiKensu;
    }

    /*
     * settxtGengakuNinteiKensu
     * @param txtGengakuNinteiKensu txtGengakuNinteiKensu
     */
    @JsonProperty("txtGengakuNinteiKensu")
    public void setTxtGengakuNinteiKensu(TextBox txtGengakuNinteiKensu) {
        this.txtGengakuNinteiKensu = txtGengakuNinteiKensu;
    }

    // </editor-fold>
}

/**
 * TableCell3 のクラスファイル
 *
 * @author 自動生成
 */
class TableCell3AttplDaigoNi extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    @JsonProperty("txtNinteiKensuGenzaiGengaku")
    private TextBox txtNinteiKensuGenzaiGengaku;

    /*
     * gettxtNinteiKensuGenzaiGengaku
     * @return txtNinteiKensuGenzaiGengaku
     */
    @JsonProperty("txtNinteiKensuGenzaiGengaku")
    public TextBox getTxtNinteiKensuGenzaiGengaku() {
        return txtNinteiKensuGenzaiGengaku;
    }

    /*
     * settxtNinteiKensuGenzaiGengaku
     * @param txtNinteiKensuGenzaiGengaku txtNinteiKensuGenzaiGengaku
     */
    @JsonProperty("txtNinteiKensuGenzaiGengaku")
    public void setTxtNinteiKensuGenzaiGengaku(TextBox txtNinteiKensuGenzaiGengaku) {
        this.txtNinteiKensuGenzaiGengaku = txtNinteiKensuGenzaiGengaku;
    }

    // </editor-fold>
}

/**
 * TableCell4 のクラスファイル
 *
 * @author 自動生成
 */
class TableCell4AttplDaigoNi extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    @JsonProperty("txtMenjoNinteiKensu")
    private TextBox txtMenjoNinteiKensu;

    /*
     * gettxtMenjoNinteiKensu
     * @return txtMenjoNinteiKensu
     */
    @JsonProperty("txtMenjoNinteiKensu")
    public TextBox getTxtMenjoNinteiKensu() {
        return txtMenjoNinteiKensu;
    }

    /*
     * settxtMenjoNinteiKensu
     * @param txtMenjoNinteiKensu txtMenjoNinteiKensu
     */
    @JsonProperty("txtMenjoNinteiKensu")
    public void setTxtMenjoNinteiKensu(TextBox txtMenjoNinteiKensu) {
        this.txtMenjoNinteiKensu = txtMenjoNinteiKensu;
    }

    // </editor-fold>
}

/**
 * TableCell5 のクラスファイル
 *
 * @author 自動生成
 */
class TableCell5AttplDaigoNi extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    @JsonProperty("txtNinteiKensuGenzaiMenjo")
    private TextBox txtNinteiKensuGenzaiMenjo;

    /*
     * gettxtNinteiKensuGenzaiMenjo
     * @return txtNinteiKensuGenzaiMenjo
     */
    @JsonProperty("txtNinteiKensuGenzaiMenjo")
    public TextBox getTxtNinteiKensuGenzaiMenjo() {
        return txtNinteiKensuGenzaiMenjo;
    }

    /*
     * settxtNinteiKensuGenzaiMenjo
     * @param txtNinteiKensuGenzaiMenjo txtNinteiKensuGenzaiMenjo
     */
    @JsonProperty("txtNinteiKensuGenzaiMenjo")
    public void setTxtNinteiKensuGenzaiMenjo(TextBox txtNinteiKensuGenzaiMenjo) {
        this.txtNinteiKensuGenzaiMenjo = txtNinteiKensuGenzaiMenjo;
    }

    // </editor-fold>
}
