package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001.NinteichosaIraiEntryTokusokuPublishDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * NinteichosaIraiEntryTokusokuContent のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteichosaIraiEntryTokusokuContentDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlTokukuHoho")
    private DropDownList ddlTokukuHoho;
    @JsonProperty("txtTokusokuCount")
    private TextBox txtTokusokuCount;
    @JsonProperty("txtTokusokuDate")
    private TextBoxFlexibleDate txtTokusokuDate;
    @JsonProperty("txtTokusokuKigenDate")
    private TextBoxFlexibleDate txtTokusokuKigenDate;
    @JsonProperty("linTokusoku")
    private HorizontalLine linTokusoku;
    @JsonProperty("NinteichosaIraiEntryTokusokuPublish")
    private NinteichosaIraiEntryTokusokuPublishDiv NinteichosaIraiEntryTokusokuPublish;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ddlTokukuHoho")
    public DropDownList getDdlTokukuHoho() {
        return ddlTokukuHoho;
    }

    @JsonProperty("ddlTokukuHoho")
    public void setDdlTokukuHoho(DropDownList ddlTokukuHoho) {
        this.ddlTokukuHoho=ddlTokukuHoho;
    }

    @JsonProperty("txtTokusokuCount")
    public TextBox getTxtTokusokuCount() {
        return txtTokusokuCount;
    }

    @JsonProperty("txtTokusokuCount")
    public void setTxtTokusokuCount(TextBox txtTokusokuCount) {
        this.txtTokusokuCount=txtTokusokuCount;
    }

    @JsonProperty("txtTokusokuDate")
    public TextBoxFlexibleDate getTxtTokusokuDate() {
        return txtTokusokuDate;
    }

    @JsonProperty("txtTokusokuDate")
    public void setTxtTokusokuDate(TextBoxFlexibleDate txtTokusokuDate) {
        this.txtTokusokuDate=txtTokusokuDate;
    }

    @JsonProperty("txtTokusokuKigenDate")
    public TextBoxFlexibleDate getTxtTokusokuKigenDate() {
        return txtTokusokuKigenDate;
    }

    @JsonProperty("txtTokusokuKigenDate")
    public void setTxtTokusokuKigenDate(TextBoxFlexibleDate txtTokusokuKigenDate) {
        this.txtTokusokuKigenDate=txtTokusokuKigenDate;
    }

    @JsonProperty("linTokusoku")
    public HorizontalLine getLinTokusoku() {
        return linTokusoku;
    }

    @JsonProperty("linTokusoku")
    public void setLinTokusoku(HorizontalLine linTokusoku) {
        this.linTokusoku=linTokusoku;
    }

    @JsonProperty("NinteichosaIraiEntryTokusokuPublish")
    public NinteichosaIraiEntryTokusokuPublishDiv getNinteichosaIraiEntryTokusokuPublish() {
        return NinteichosaIraiEntryTokusokuPublish;
    }

    @JsonProperty("NinteichosaIraiEntryTokusokuPublish")
    public void setNinteichosaIraiEntryTokusokuPublish(NinteichosaIraiEntryTokusokuPublishDiv NinteichosaIraiEntryTokusokuPublish) {
        this.NinteichosaIraiEntryTokusokuPublish=NinteichosaIraiEntryTokusokuPublish;
    }

}
