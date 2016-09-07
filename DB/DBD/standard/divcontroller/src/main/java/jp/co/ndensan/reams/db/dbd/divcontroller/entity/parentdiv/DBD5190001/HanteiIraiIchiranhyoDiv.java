package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5190001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HanteiIraiIchiranhyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class HanteiIraiIchiranhyoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtInsatsuDay")
    private TextBox txtInsatsuDay;
    @JsonProperty("lblInsatsuDayComment")
    private Label lblInsatsuDayComment;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtInsatsuDay
     * @return txtInsatsuDay
     */
    @JsonProperty("txtInsatsuDay")
    public TextBox getTxtInsatsuDay() {
        return txtInsatsuDay;
    }

    /*
     * settxtInsatsuDay
     * @param txtInsatsuDay txtInsatsuDay
     */
    @JsonProperty("txtInsatsuDay")
    public void setTxtInsatsuDay(TextBox txtInsatsuDay) {
        this.txtInsatsuDay = txtInsatsuDay;
    }

    /*
     * getlblInsatsuDayComment
     * @return lblInsatsuDayComment
     */
    @JsonProperty("lblInsatsuDayComment")
    public Label getLblInsatsuDayComment() {
        return lblInsatsuDayComment;
    }

    /*
     * setlblInsatsuDayComment
     * @param lblInsatsuDayComment lblInsatsuDayComment
     */
    @JsonProperty("lblInsatsuDayComment")
    public void setLblInsatsuDayComment(Label lblInsatsuDayComment) {
        this.lblInsatsuDayComment = lblInsatsuDayComment;
    }

    // </editor-fold>
}
