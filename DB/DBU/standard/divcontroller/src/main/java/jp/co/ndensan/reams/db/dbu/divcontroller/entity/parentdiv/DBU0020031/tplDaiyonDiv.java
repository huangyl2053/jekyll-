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
 * tplDaiyon のクラスファイル
 *
 * @reamsid_L DBU-1100-030 wangkanglei
 */
public class tplDaiyonDiv extends TablePanel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("cel211")
    private cel211AttplDaiyon cel211;
    @JsonProperty("cel222")
    private cel222AttplDaiyon cel222;
    @JsonProperty("cel232")
    private cel232AttplDaiyon cel232;
    @JsonProperty("cel242")
    private cel242AttplDaiyon cel242;
    @JsonProperty("cel252")
    private cel252AttplDaiyon cel252;
    @JsonProperty("cel262")
    private cel262AttplDaiyon cel262;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public TextBox getTxtShinseiKensuRiyosha() {
        return this.cel222.getTxtShinseiKensuRiyosha();
    }

    @JsonIgnore
    public TextBox getTxtGengakuNinteiKensuRiyosha() {
        return this.cel232.getTxtGengakuNinteiKensuRiyosha();
    }

    @JsonIgnore
    public TextBox getTxtNinteiKensuGenzaiGengakuRiyosha() {
        return this.cel242.getTxtNinteiKensuGenzaiGengakuRiyosha();
    }

    @JsonIgnore
    public TextBox getTxtMenjoNinteiKensuRiyosha() {
        return this.cel252.getTxtMenjoNinteiKensuRiyosha();
    }

    @JsonIgnore
    public TextBox getTxtNinteiKensuGenzaiMenjoRiyosha() {
        return this.cel262.getTxtNinteiKensuGenzaiMenjoRiyosha();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcel211
     * @return cel211
     */
    @JsonProperty("cel211")
    private cel211AttplDaiyon getCel211() {
        return cel211;
    }

    /*
     * setcel211
     * @param cel211 cel211
     */
    @JsonProperty("cel211")
    private void setCel211(cel211AttplDaiyon cel211) {
        this.cel211 = cel211;
    }

    /*
     * getcel222
     * @return cel222
     */
    @JsonProperty("cel222")
    private cel222AttplDaiyon getCel222() {
        return cel222;
    }

    /*
     * setcel222
     * @param cel222 cel222
     */
    @JsonProperty("cel222")
    private void setCel222(cel222AttplDaiyon cel222) {
        this.cel222 = cel222;
    }

    /*
     * getcel232
     * @return cel232
     */
    @JsonProperty("cel232")
    private cel232AttplDaiyon getCel232() {
        return cel232;
    }

    /*
     * setcel232
     * @param cel232 cel232
     */
    @JsonProperty("cel232")
    private void setCel232(cel232AttplDaiyon cel232) {
        this.cel232 = cel232;
    }

    /*
     * getcel242
     * @return cel242
     */
    @JsonProperty("cel242")
    private cel242AttplDaiyon getCel242() {
        return cel242;
    }

    /*
     * setcel242
     * @param cel242 cel242
     */
    @JsonProperty("cel242")
    private void setCel242(cel242AttplDaiyon cel242) {
        this.cel242 = cel242;
    }

    /*
     * getcel252
     * @return cel252
     */
    @JsonProperty("cel252")
    private cel252AttplDaiyon getCel252() {
        return cel252;
    }

    /*
     * setcel252
     * @param cel252 cel252
     */
    @JsonProperty("cel252")
    private void setCel252(cel252AttplDaiyon cel252) {
        this.cel252 = cel252;
    }

    /*
     * getcel262
     * @return cel262
     */
    @JsonProperty("cel262")
    private cel262AttplDaiyon getCel262() {
        return cel262;
    }

    /*
     * setcel262
     * @param cel262 cel262
     */
    @JsonProperty("cel262")
    private void setCel262(cel262AttplDaiyon cel262) {
        this.cel262 = cel262;
    }

    // </editor-fold>
}

/**
 * cel211 のクラスファイル
 *
 * @author 自動生成
 */
class cel211AttplDaiyon extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">

    // </editor-fold>
}

/**
 * cel222 のクラスファイル
 *
 * @author 自動生成
 */
class cel222AttplDaiyon extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    @JsonProperty("txtShinseiKensuRiyosha")
    private TextBox txtShinseiKensuRiyosha;

    /*
     * gettxtShinseiKensuRiyosha
     * @return txtShinseiKensuRiyosha
     */
    @JsonProperty("txtShinseiKensuRiyosha")
    public TextBox getTxtShinseiKensuRiyosha() {
        return txtShinseiKensuRiyosha;
    }

    /*
     * settxtShinseiKensuRiyosha
     * @param txtShinseiKensuRiyosha txtShinseiKensuRiyosha
     */
    @JsonProperty("txtShinseiKensuRiyosha")
    public void setTxtShinseiKensuRiyosha(TextBox txtShinseiKensuRiyosha) {
        this.txtShinseiKensuRiyosha = txtShinseiKensuRiyosha;
    }

    // </editor-fold>
}

/**
 * cel232 のクラスファイル
 *
 * @author 自動生成
 */
class cel232AttplDaiyon extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    @JsonProperty("txtGengakuNinteiKensuRiyosha")
    private TextBox txtGengakuNinteiKensuRiyosha;

    /*
     * gettxtGengakuNinteiKensuRiyosha
     * @return txtGengakuNinteiKensuRiyosha
     */
    @JsonProperty("txtGengakuNinteiKensuRiyosha")
    public TextBox getTxtGengakuNinteiKensuRiyosha() {
        return txtGengakuNinteiKensuRiyosha;
    }

    /*
     * settxtGengakuNinteiKensuRiyosha
     * @param txtGengakuNinteiKensuRiyosha txtGengakuNinteiKensuRiyosha
     */
    @JsonProperty("txtGengakuNinteiKensuRiyosha")
    public void setTxtGengakuNinteiKensuRiyosha(TextBox txtGengakuNinteiKensuRiyosha) {
        this.txtGengakuNinteiKensuRiyosha = txtGengakuNinteiKensuRiyosha;
    }

    // </editor-fold>
}

/**
 * cel242 のクラスファイル
 *
 * @author 自動生成
 */
class cel242AttplDaiyon extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    @JsonProperty("txtNinteiKensuGenzaiGengakuRiyosha")
    private TextBox txtNinteiKensuGenzaiGengakuRiyosha;

    /*
     * gettxtNinteiKensuGenzaiGengakuRiyosha
     * @return txtNinteiKensuGenzaiGengakuRiyosha
     */
    @JsonProperty("txtNinteiKensuGenzaiGengakuRiyosha")
    public TextBox getTxtNinteiKensuGenzaiGengakuRiyosha() {
        return txtNinteiKensuGenzaiGengakuRiyosha;
    }

    /*
     * settxtNinteiKensuGenzaiGengakuRiyosha
     * @param txtNinteiKensuGenzaiGengakuRiyosha txtNinteiKensuGenzaiGengakuRiyosha
     */
    @JsonProperty("txtNinteiKensuGenzaiGengakuRiyosha")
    public void setTxtNinteiKensuGenzaiGengakuRiyosha(TextBox txtNinteiKensuGenzaiGengakuRiyosha) {
        this.txtNinteiKensuGenzaiGengakuRiyosha = txtNinteiKensuGenzaiGengakuRiyosha;
    }

    // </editor-fold>
}

/**
 * cel252 のクラスファイル
 *
 * @author 自動生成
 */
class cel252AttplDaiyon extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    @JsonProperty("txtMenjoNinteiKensuRiyosha")
    private TextBox txtMenjoNinteiKensuRiyosha;

    /*
     * gettxtMenjoNinteiKensuRiyosha
     * @return txtMenjoNinteiKensuRiyosha
     */
    @JsonProperty("txtMenjoNinteiKensuRiyosha")
    public TextBox getTxtMenjoNinteiKensuRiyosha() {
        return txtMenjoNinteiKensuRiyosha;
    }

    /*
     * settxtMenjoNinteiKensuRiyosha
     * @param txtMenjoNinteiKensuRiyosha txtMenjoNinteiKensuRiyosha
     */
    @JsonProperty("txtMenjoNinteiKensuRiyosha")
    public void setTxtMenjoNinteiKensuRiyosha(TextBox txtMenjoNinteiKensuRiyosha) {
        this.txtMenjoNinteiKensuRiyosha = txtMenjoNinteiKensuRiyosha;
    }

    // </editor-fold>
}

/**
 * cel262 のクラスファイル
 *
 * @author 自動生成
 */
class cel262AttplDaiyon extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    @JsonProperty("txtNinteiKensuGenzaiMenjoRiyosha")
    private TextBox txtNinteiKensuGenzaiMenjoRiyosha;

    /*
     * gettxtNinteiKensuGenzaiMenjoRiyosha
     * @return txtNinteiKensuGenzaiMenjoRiyosha
     */
    @JsonProperty("txtNinteiKensuGenzaiMenjoRiyosha")
    public TextBox getTxtNinteiKensuGenzaiMenjoRiyosha() {
        return txtNinteiKensuGenzaiMenjoRiyosha;
    }

    /*
     * settxtNinteiKensuGenzaiMenjoRiyosha
     * @param txtNinteiKensuGenzaiMenjoRiyosha txtNinteiKensuGenzaiMenjoRiyosha
     */
    @JsonProperty("txtNinteiKensuGenzaiMenjoRiyosha")
    public void setTxtNinteiKensuGenzaiMenjoRiyosha(TextBox txtNinteiKensuGenzaiMenjoRiyosha) {
        this.txtNinteiKensuGenzaiMenjoRiyosha = txtNinteiKensuGenzaiMenjoRiyosha;
    }

    // </editor-fold>
}
