package jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.NinteiChosaJokyo;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KaigoNinteiShinsakai のクラスファイル 
 * 
 * @author 自動生成
 */
public class KaigoNinteiShinsakaiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinsakaiShiryoSakuseiDay")
    private TextBoxDate txtShinsakaiShiryoSakuseiDay;
    @JsonProperty("txtShinsakaiKaisaiYoteiDay")
    private TextBoxDate txtShinsakaiKaisaiYoteiDay;
    @JsonProperty("txtNijiHanteiDay")
    private TextBoxDate txtNijiHanteiDay;
    @JsonProperty("ddlNijiHanteiKekka")
    private DropDownList ddlNijiHanteiKekka;
    @JsonProperty("txtNijiHanteiYukoKikan")
    private TextBox txtNijiHanteiYukoKikan;
    @JsonProperty("txtNinteiYukoKikanFrom")
    private TextBoxDate txtNinteiYukoKikanFrom;
    @JsonProperty("txtNinteiYukoKikanTo")
    private TextBoxDate txtNinteiYukoKikanTo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShinsakaiShiryoSakuseiDay")
    public TextBoxDate getTxtShinsakaiShiryoSakuseiDay() {
        return txtShinsakaiShiryoSakuseiDay;
    }

    @JsonProperty("txtShinsakaiShiryoSakuseiDay")
    public void setTxtShinsakaiShiryoSakuseiDay(TextBoxDate txtShinsakaiShiryoSakuseiDay) {
        this.txtShinsakaiShiryoSakuseiDay=txtShinsakaiShiryoSakuseiDay;
    }

    @JsonProperty("txtShinsakaiKaisaiYoteiDay")
    public TextBoxDate getTxtShinsakaiKaisaiYoteiDay() {
        return txtShinsakaiKaisaiYoteiDay;
    }

    @JsonProperty("txtShinsakaiKaisaiYoteiDay")
    public void setTxtShinsakaiKaisaiYoteiDay(TextBoxDate txtShinsakaiKaisaiYoteiDay) {
        this.txtShinsakaiKaisaiYoteiDay=txtShinsakaiKaisaiYoteiDay;
    }

    @JsonProperty("txtNijiHanteiDay")
    public TextBoxDate getTxtNijiHanteiDay() {
        return txtNijiHanteiDay;
    }

    @JsonProperty("txtNijiHanteiDay")
    public void setTxtNijiHanteiDay(TextBoxDate txtNijiHanteiDay) {
        this.txtNijiHanteiDay=txtNijiHanteiDay;
    }

    @JsonProperty("ddlNijiHanteiKekka")
    public DropDownList getDdlNijiHanteiKekka() {
        return ddlNijiHanteiKekka;
    }

    @JsonProperty("ddlNijiHanteiKekka")
    public void setDdlNijiHanteiKekka(DropDownList ddlNijiHanteiKekka) {
        this.ddlNijiHanteiKekka=ddlNijiHanteiKekka;
    }

    @JsonProperty("txtNijiHanteiYukoKikan")
    public TextBox getTxtNijiHanteiYukoKikan() {
        return txtNijiHanteiYukoKikan;
    }

    @JsonProperty("txtNijiHanteiYukoKikan")
    public void setTxtNijiHanteiYukoKikan(TextBox txtNijiHanteiYukoKikan) {
        this.txtNijiHanteiYukoKikan=txtNijiHanteiYukoKikan;
    }

    @JsonProperty("txtNinteiYukoKikanFrom")
    public TextBoxDate getTxtNinteiYukoKikanFrom() {
        return txtNinteiYukoKikanFrom;
    }

    @JsonProperty("txtNinteiYukoKikanFrom")
    public void setTxtNinteiYukoKikanFrom(TextBoxDate txtNinteiYukoKikanFrom) {
        this.txtNinteiYukoKikanFrom=txtNinteiYukoKikanFrom;
    }

    @JsonProperty("txtNinteiYukoKikanTo")
    public TextBoxDate getTxtNinteiYukoKikanTo() {
        return txtNinteiYukoKikanTo;
    }

    @JsonProperty("txtNinteiYukoKikanTo")
    public void setTxtNinteiYukoKikanTo(TextBoxDate txtNinteiYukoKikanTo) {
        this.txtNinteiYukoKikanTo=txtNinteiYukoKikanTo;
    }

}
