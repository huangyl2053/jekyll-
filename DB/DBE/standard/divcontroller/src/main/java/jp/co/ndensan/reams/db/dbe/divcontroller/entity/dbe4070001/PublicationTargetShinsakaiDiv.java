package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4070001;
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
 * PublicationTargetShinsakai のクラスファイル 
 * 
 * @author 自動生成
 */
public class PublicationTargetShinsakaiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinsakaiKaisaiNo")
    private TextBoxCode txtShinsakaiKaisaiNo;
    @JsonProperty("txtShinsakaiYoteiDate")
    private TextBoxFlexibleDate txtShinsakaiYoteiDate;
    @JsonProperty("txtShinsakaiKaijo")
    private TextBox txtShinsakaiKaijo;
    @JsonProperty("txtShinsakaiKaishiYoteiTime")
    private TextBoxTime txtShinsakaiKaishiYoteiTime;
    @JsonProperty("txtShiryoSakusei")
    private TextBox txtShiryoSakusei;
    @JsonProperty("txtGogitaiNo")
    private TextBoxCode txtGogitaiNo;
    @JsonProperty("txtGogitaiName")
    private TextBox txtGogitaiName;
    @JsonProperty("txtYoteiTeiin")
    private TextBoxNum txtYoteiTeiin;
    @JsonProperty("txtWariateNinzu")
    private TextBoxNum txtWariateNinzu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShinsakaiKaisaiNo")
    public TextBoxCode getTxtShinsakaiKaisaiNo() {
        return txtShinsakaiKaisaiNo;
    }

    @JsonProperty("txtShinsakaiKaisaiNo")
    public void setTxtShinsakaiKaisaiNo(TextBoxCode txtShinsakaiKaisaiNo) {
        this.txtShinsakaiKaisaiNo=txtShinsakaiKaisaiNo;
    }

    @JsonProperty("txtShinsakaiYoteiDate")
    public TextBoxFlexibleDate getTxtShinsakaiYoteiDate() {
        return txtShinsakaiYoteiDate;
    }

    @JsonProperty("txtShinsakaiYoteiDate")
    public void setTxtShinsakaiYoteiDate(TextBoxFlexibleDate txtShinsakaiYoteiDate) {
        this.txtShinsakaiYoteiDate=txtShinsakaiYoteiDate;
    }

    @JsonProperty("txtShinsakaiKaijo")
    public TextBox getTxtShinsakaiKaijo() {
        return txtShinsakaiKaijo;
    }

    @JsonProperty("txtShinsakaiKaijo")
    public void setTxtShinsakaiKaijo(TextBox txtShinsakaiKaijo) {
        this.txtShinsakaiKaijo=txtShinsakaiKaijo;
    }

    @JsonProperty("txtShinsakaiKaishiYoteiTime")
    public TextBoxTime getTxtShinsakaiKaishiYoteiTime() {
        return txtShinsakaiKaishiYoteiTime;
    }

    @JsonProperty("txtShinsakaiKaishiYoteiTime")
    public void setTxtShinsakaiKaishiYoteiTime(TextBoxTime txtShinsakaiKaishiYoteiTime) {
        this.txtShinsakaiKaishiYoteiTime=txtShinsakaiKaishiYoteiTime;
    }

    @JsonProperty("txtShiryoSakusei")
    public TextBox getTxtShiryoSakusei() {
        return txtShiryoSakusei;
    }

    @JsonProperty("txtShiryoSakusei")
    public void setTxtShiryoSakusei(TextBox txtShiryoSakusei) {
        this.txtShiryoSakusei=txtShiryoSakusei;
    }

    @JsonProperty("txtGogitaiNo")
    public TextBoxCode getTxtGogitaiNo() {
        return txtGogitaiNo;
    }

    @JsonProperty("txtGogitaiNo")
    public void setTxtGogitaiNo(TextBoxCode txtGogitaiNo) {
        this.txtGogitaiNo=txtGogitaiNo;
    }

    @JsonProperty("txtGogitaiName")
    public TextBox getTxtGogitaiName() {
        return txtGogitaiName;
    }

    @JsonProperty("txtGogitaiName")
    public void setTxtGogitaiName(TextBox txtGogitaiName) {
        this.txtGogitaiName=txtGogitaiName;
    }

    @JsonProperty("txtYoteiTeiin")
    public TextBoxNum getTxtYoteiTeiin() {
        return txtYoteiTeiin;
    }

    @JsonProperty("txtYoteiTeiin")
    public void setTxtYoteiTeiin(TextBoxNum txtYoteiTeiin) {
        this.txtYoteiTeiin=txtYoteiTeiin;
    }

    @JsonProperty("txtWariateNinzu")
    public TextBoxNum getTxtWariateNinzu() {
        return txtWariateNinzu;
    }

    @JsonProperty("txtWariateNinzu")
    public void setTxtWariateNinzu(TextBoxNum txtWariateNinzu) {
        this.txtWariateNinzu=txtWariateNinzu;
    }

}
