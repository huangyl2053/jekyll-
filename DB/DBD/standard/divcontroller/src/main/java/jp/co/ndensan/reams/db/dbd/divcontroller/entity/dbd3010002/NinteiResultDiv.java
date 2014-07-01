package jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010002;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010002.NinteiResultEtceteraDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010002.ShiteiServiceIchiranDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * NinteiResult のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiResultDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtNinteiYMD")
    private TextBoxFlexibleDate txtNinteiYMD;
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
    @JsonProperty("NinteiResultEtcetera")
    private NinteiResultEtceteraDiv NinteiResultEtcetera;
    @JsonProperty("ShiteiServiceIchiran")
    private ShiteiServiceIchiranDiv ShiteiServiceIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtNinteiYMD")
    public TextBoxFlexibleDate getTxtNinteiYMD() {
        return txtNinteiYMD;
    }

    @JsonProperty("txtNinteiYMD")
    public void setTxtNinteiYMD(TextBoxFlexibleDate txtNinteiYMD) {
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

    @JsonProperty("NinteiResultEtcetera")
    public NinteiResultEtceteraDiv getNinteiResultEtcetera() {
        return NinteiResultEtcetera;
    }

    @JsonProperty("NinteiResultEtcetera")
    public void setNinteiResultEtcetera(NinteiResultEtceteraDiv NinteiResultEtcetera) {
        this.NinteiResultEtcetera=NinteiResultEtcetera;
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
