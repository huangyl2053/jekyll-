package jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010001.NinteiResultOtherDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010001.ShiteiServiceIchiranDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * NinteiResultDetail のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiResultDetailDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtNinteiYMD")
    private TextBoxDate txtNinteiYMD;
    @JsonProperty("txtYokaigodoCode")
    private TextBoxCode txtYokaigodoCode;
    @JsonProperty("txtYokaigodo")
    private TextBox txtYokaigodo;
    @JsonProperty("txtYukokikanTsukisu")
    private TextBox txtYukokikanTsukisu;
    @JsonProperty("txtNinteiYukoKaishiYMD")
    private TextBoxFlexibleDate txtNinteiYukoKaishiYMD;
    @JsonProperty("txtNinteiYukoShuryoYMD")
    private TextBoxFlexibleDate txtNinteiYukoShuryoYMD;
    @JsonProperty("NinteiResultOther")
    private NinteiResultOtherDiv NinteiResultOther;
    @JsonProperty("ShiteiServiceIchiran")
    private ShiteiServiceIchiranDiv ShiteiServiceIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtNinteiYMD")
    public TextBoxDate getTxtNinteiYMD() {
        return txtNinteiYMD;
    }

    @JsonProperty("txtNinteiYMD")
    public void setTxtNinteiYMD(TextBoxDate txtNinteiYMD) {
        this.txtNinteiYMD=txtNinteiYMD;
    }

    @JsonProperty("txtYokaigodoCode")
    public TextBoxCode getTxtYokaigodoCode() {
        return txtYokaigodoCode;
    }

    @JsonProperty("txtYokaigodoCode")
    public void setTxtYokaigodoCode(TextBoxCode txtYokaigodoCode) {
        this.txtYokaigodoCode=txtYokaigodoCode;
    }

    @JsonProperty("txtYokaigodo")
    public TextBox getTxtYokaigodo() {
        return txtYokaigodo;
    }

    @JsonProperty("txtYokaigodo")
    public void setTxtYokaigodo(TextBox txtYokaigodo) {
        this.txtYokaigodo=txtYokaigodo;
    }

    @JsonProperty("txtYukokikanTsukisu")
    public TextBox getTxtYukokikanTsukisu() {
        return txtYukokikanTsukisu;
    }

    @JsonProperty("txtYukokikanTsukisu")
    public void setTxtYukokikanTsukisu(TextBox txtYukokikanTsukisu) {
        this.txtYukokikanTsukisu=txtYukokikanTsukisu;
    }

    @JsonProperty("txtNinteiYukoKaishiYMD")
    public TextBoxFlexibleDate getTxtNinteiYukoKaishiYMD() {
        return txtNinteiYukoKaishiYMD;
    }

    @JsonProperty("txtNinteiYukoKaishiYMD")
    public void setTxtNinteiYukoKaishiYMD(TextBoxFlexibleDate txtNinteiYukoKaishiYMD) {
        this.txtNinteiYukoKaishiYMD=txtNinteiYukoKaishiYMD;
    }

    @JsonProperty("txtNinteiYukoShuryoYMD")
    public TextBoxFlexibleDate getTxtNinteiYukoShuryoYMD() {
        return txtNinteiYukoShuryoYMD;
    }

    @JsonProperty("txtNinteiYukoShuryoYMD")
    public void setTxtNinteiYukoShuryoYMD(TextBoxFlexibleDate txtNinteiYukoShuryoYMD) {
        this.txtNinteiYukoShuryoYMD=txtNinteiYukoShuryoYMD;
    }

    @JsonProperty("NinteiResultOther")
    public NinteiResultOtherDiv getNinteiResultOther() {
        return NinteiResultOther;
    }

    @JsonProperty("NinteiResultOther")
    public void setNinteiResultOther(NinteiResultOtherDiv NinteiResultOther) {
        this.NinteiResultOther=NinteiResultOther;
    }

    @JsonProperty("ShiteiServiceIchiran")
    public ShiteiServiceIchiranDiv getShiteiServiceIchiran() {
        return ShiteiServiceIchiran;
    }

    @JsonProperty("ShiteiServiceIchiran")
    public void setShiteiServiceIchiran(ShiteiServiceIchiranDiv ShiteiServiceIchiran) {
        this.ShiteiServiceIchiran=ShiteiServiceIchiran;
    }

}
