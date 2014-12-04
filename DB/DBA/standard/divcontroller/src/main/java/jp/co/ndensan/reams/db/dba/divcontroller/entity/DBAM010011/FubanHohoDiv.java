package jp.co.ndensan.reams.db.dba.divcontroller.entity.DBAM010011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBAM010011.LblTitle1Div;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBAM010011.LblTitle3Div;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBAM010011.LblTitle4Div;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBAM010011.LblTitle6Div;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBAM010011.LblTitleDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * FubanHoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class FubanHohoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("LblTitle")
    private LblTitleDiv LblTitle;
    @JsonProperty("LblTitle1")
    private LblTitle1Div LblTitle1;
    @JsonProperty("Label1")
    private Label Label1;
    @JsonProperty("HorizontalLine1")
    private HorizontalLine HorizontalLine1;
    @JsonProperty("LblTitle3")
    private LblTitle3Div LblTitle3;
    @JsonProperty("LblTitle4")
    private LblTitle4Div LblTitle4;
    @JsonProperty("LblTitle6")
    private LblTitle6Div LblTitle6;
    @JsonProperty("Label3")
    private Label Label3;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("LblTitle")
    public LblTitleDiv getLblTitle() {
        return LblTitle;
    }

    @JsonProperty("LblTitle")
    public void setLblTitle(LblTitleDiv LblTitle) {
        this.LblTitle=LblTitle;
    }

    @JsonProperty("LblTitle1")
    public LblTitle1Div getLblTitle1() {
        return LblTitle1;
    }

    @JsonProperty("LblTitle1")
    public void setLblTitle1(LblTitle1Div LblTitle1) {
        this.LblTitle1=LblTitle1;
    }

    @JsonProperty("Label1")
    public Label getLabel1() {
        return Label1;
    }

    @JsonProperty("Label1")
    public void setLabel1(Label Label1) {
        this.Label1=Label1;
    }

    @JsonProperty("HorizontalLine1")
    public HorizontalLine getHorizontalLine1() {
        return HorizontalLine1;
    }

    @JsonProperty("HorizontalLine1")
    public void setHorizontalLine1(HorizontalLine HorizontalLine1) {
        this.HorizontalLine1=HorizontalLine1;
    }

    @JsonProperty("LblTitle3")
    public LblTitle3Div getLblTitle3() {
        return LblTitle3;
    }

    @JsonProperty("LblTitle3")
    public void setLblTitle3(LblTitle3Div LblTitle3) {
        this.LblTitle3=LblTitle3;
    }

    @JsonProperty("LblTitle4")
    public LblTitle4Div getLblTitle4() {
        return LblTitle4;
    }

    @JsonProperty("LblTitle4")
    public void setLblTitle4(LblTitle4Div LblTitle4) {
        this.LblTitle4=LblTitle4;
    }

    @JsonProperty("LblTitle6")
    public LblTitle6Div getLblTitle6() {
        return LblTitle6;
    }

    @JsonProperty("LblTitle6")
    public void setLblTitle6(LblTitle6Div LblTitle6) {
        this.LblTitle6=LblTitle6;
    }

    @JsonProperty("Label3")
    public Label getLabel3() {
        return Label3;
    }

    @JsonProperty("Label3")
    public void setLabel3(Label Label3) {
        this.Label3=Label3;
    }

}
