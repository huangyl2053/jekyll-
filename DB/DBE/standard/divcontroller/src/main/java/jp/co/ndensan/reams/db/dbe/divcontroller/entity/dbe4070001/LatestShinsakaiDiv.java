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
 * LatestShinsakai のクラスファイル 
 * 
 * @author 自動生成
 */
public class LatestShinsakaiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtLatestShinsakaiKaisaiNo")
    private TextBoxCode txtLatestShinsakaiKaisaiNo;
    @JsonProperty("txtLatestShinsakaiYoteiDate")
    private TextBoxFlexibleDate txtLatestShinsakaiYoteiDate;
    @JsonProperty("txtLatestShinsakaiKaijo")
    private TextBox txtLatestShinsakaiKaijo;
    @JsonProperty("txtLatestShinsakaiKaishiYoteiTime")
    private TextBoxTime txtLatestShinsakaiKaishiYoteiTime;
    @JsonProperty("txtLatestGogitaiNo")
    private TextBoxCode txtLatestGogitaiNo;
    @JsonProperty("txtLatestGogitaiName")
    private TextBox txtLatestGogitaiName;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtLatestShinsakaiKaisaiNo")
    public TextBoxCode getTxtLatestShinsakaiKaisaiNo() {
        return txtLatestShinsakaiKaisaiNo;
    }

    @JsonProperty("txtLatestShinsakaiKaisaiNo")
    public void setTxtLatestShinsakaiKaisaiNo(TextBoxCode txtLatestShinsakaiKaisaiNo) {
        this.txtLatestShinsakaiKaisaiNo=txtLatestShinsakaiKaisaiNo;
    }

    @JsonProperty("txtLatestShinsakaiYoteiDate")
    public TextBoxFlexibleDate getTxtLatestShinsakaiYoteiDate() {
        return txtLatestShinsakaiYoteiDate;
    }

    @JsonProperty("txtLatestShinsakaiYoteiDate")
    public void setTxtLatestShinsakaiYoteiDate(TextBoxFlexibleDate txtLatestShinsakaiYoteiDate) {
        this.txtLatestShinsakaiYoteiDate=txtLatestShinsakaiYoteiDate;
    }

    @JsonProperty("txtLatestShinsakaiKaijo")
    public TextBox getTxtLatestShinsakaiKaijo() {
        return txtLatestShinsakaiKaijo;
    }

    @JsonProperty("txtLatestShinsakaiKaijo")
    public void setTxtLatestShinsakaiKaijo(TextBox txtLatestShinsakaiKaijo) {
        this.txtLatestShinsakaiKaijo=txtLatestShinsakaiKaijo;
    }

    @JsonProperty("txtLatestShinsakaiKaishiYoteiTime")
    public TextBoxTime getTxtLatestShinsakaiKaishiYoteiTime() {
        return txtLatestShinsakaiKaishiYoteiTime;
    }

    @JsonProperty("txtLatestShinsakaiKaishiYoteiTime")
    public void setTxtLatestShinsakaiKaishiYoteiTime(TextBoxTime txtLatestShinsakaiKaishiYoteiTime) {
        this.txtLatestShinsakaiKaishiYoteiTime=txtLatestShinsakaiKaishiYoteiTime;
    }

    @JsonProperty("txtLatestGogitaiNo")
    public TextBoxCode getTxtLatestGogitaiNo() {
        return txtLatestGogitaiNo;
    }

    @JsonProperty("txtLatestGogitaiNo")
    public void setTxtLatestGogitaiNo(TextBoxCode txtLatestGogitaiNo) {
        this.txtLatestGogitaiNo=txtLatestGogitaiNo;
    }

    @JsonProperty("txtLatestGogitaiName")
    public TextBox getTxtLatestGogitaiName() {
        return txtLatestGogitaiName;
    }

    @JsonProperty("txtLatestGogitaiName")
    public void setTxtLatestGogitaiName(TextBox txtLatestGogitaiName) {
        this.txtLatestGogitaiName=txtLatestGogitaiName;
    }

}
