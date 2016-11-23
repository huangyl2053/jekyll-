package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8110001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * WrapNotsuKobetsu のクラスファイル 
 * 
 * @author 自動生成
 */
public class WrapNotsuKobetsuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkPublishNotsuKobetsu")
    private CheckBoxList chkPublishNotsuKobetsu;
    @JsonProperty("lblNotsuKobetsu")
    private Label lblNotsuKobetsu;
    @JsonProperty("NotsuKobetsu")
    private NotsuKobetsuDiv NotsuKobetsu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkPublishNotsuKobetsu
     * @return chkPublishNotsuKobetsu
     */
    @JsonProperty("chkPublishNotsuKobetsu")
    public CheckBoxList getChkPublishNotsuKobetsu() {
        return chkPublishNotsuKobetsu;
    }

    /*
     * setchkPublishNotsuKobetsu
     * @param chkPublishNotsuKobetsu chkPublishNotsuKobetsu
     */
    @JsonProperty("chkPublishNotsuKobetsu")
    public void setChkPublishNotsuKobetsu(CheckBoxList chkPublishNotsuKobetsu) {
        this.chkPublishNotsuKobetsu = chkPublishNotsuKobetsu;
    }

    /*
     * getlblNotsuKobetsu
     * @return lblNotsuKobetsu
     */
    @JsonProperty("lblNotsuKobetsu")
    public Label getLblNotsuKobetsu() {
        return lblNotsuKobetsu;
    }

    /*
     * setlblNotsuKobetsu
     * @param lblNotsuKobetsu lblNotsuKobetsu
     */
    @JsonProperty("lblNotsuKobetsu")
    public void setLblNotsuKobetsu(Label lblNotsuKobetsu) {
        this.lblNotsuKobetsu = lblNotsuKobetsu;
    }

    /*
     * getNotsuKobetsu
     * @return NotsuKobetsu
     */
    @JsonProperty("NotsuKobetsu")
    public NotsuKobetsuDiv getNotsuKobetsu() {
        return NotsuKobetsu;
    }

    /*
     * setNotsuKobetsu
     * @param NotsuKobetsu NotsuKobetsu
     */
    @JsonProperty("NotsuKobetsu")
    public void setNotsuKobetsu(NotsuKobetsuDiv NotsuKobetsu) {
        this.NotsuKobetsu = NotsuKobetsu;
    }

    // </editor-fold>
}
