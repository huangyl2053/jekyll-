package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD3020003;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JikoKisaibiFukusha のクラスファイル 
 * 
 * @author 自動生成
 */
public class JikoKisaibiFukushaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTokushuJikoKisambi")
    private TextBoxFlexibleDate txtTokushuJikoKisambi;
    @JsonProperty("ddlFukushaJikoKisambiJiyu")
    private DropDownList ddlFukushaJikoKisambiJiyu;
    @JsonProperty("btnIkkatsuFukusha")
    private Button btnIkkatsuFukusha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtTokushuJikoKisambi
     * @return txtTokushuJikoKisambi
     */
    @JsonProperty("txtTokushuJikoKisambi")
    public TextBoxFlexibleDate getTxtTokushuJikoKisambi() {
        return txtTokushuJikoKisambi;
    }

    /*
     * settxtTokushuJikoKisambi
     * @param txtTokushuJikoKisambi txtTokushuJikoKisambi
     */
    @JsonProperty("txtTokushuJikoKisambi")
    public void setTxtTokushuJikoKisambi(TextBoxFlexibleDate txtTokushuJikoKisambi) {
        this.txtTokushuJikoKisambi = txtTokushuJikoKisambi;
    }

    /*
     * getddlFukushaJikoKisambiJiyu
     * @return ddlFukushaJikoKisambiJiyu
     */
    @JsonProperty("ddlFukushaJikoKisambiJiyu")
    public DropDownList getDdlFukushaJikoKisambiJiyu() {
        return ddlFukushaJikoKisambiJiyu;
    }

    /*
     * setddlFukushaJikoKisambiJiyu
     * @param ddlFukushaJikoKisambiJiyu ddlFukushaJikoKisambiJiyu
     */
    @JsonProperty("ddlFukushaJikoKisambiJiyu")
    public void setDdlFukushaJikoKisambiJiyu(DropDownList ddlFukushaJikoKisambiJiyu) {
        this.ddlFukushaJikoKisambiJiyu = ddlFukushaJikoKisambiJiyu;
    }

    /*
     * getbtnIkkatsuFukusha
     * @return btnIkkatsuFukusha
     */
    @JsonProperty("btnIkkatsuFukusha")
    public Button getBtnIkkatsuFukusha() {
        return btnIkkatsuFukusha;
    }

    /*
     * setbtnIkkatsuFukusha
     * @param btnIkkatsuFukusha btnIkkatsuFukusha
     */
    @JsonProperty("btnIkkatsuFukusha")
    public void setBtnIkkatsuFukusha(Button btnIkkatsuFukusha) {
        this.btnIkkatsuFukusha = btnIkkatsuFukusha;
    }

    // </editor-fold>
}
