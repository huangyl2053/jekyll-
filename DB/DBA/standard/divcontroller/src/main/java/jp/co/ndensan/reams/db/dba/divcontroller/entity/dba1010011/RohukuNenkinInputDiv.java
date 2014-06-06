package jp.co.ndensan.reams.db.dba.divcontroller.entity.dba1010011;
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
 * RohukuNenkinInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class RohukuNenkinInputDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtRofukuNenkinKaishiDate")
    private TextBoxFlexibleDate txtRofukuNenkinKaishiDate;
    @JsonProperty("txtRofukuNenkinShuryoDate")
    private TextBoxFlexibleDate txtRofukuNenkinShuryoDate;
    @JsonProperty("txtRofukuNenkinJukyushaNo")
    private TextBoxCode txtRofukuNenkinJukyushaNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtRofukuNenkinKaishiDate")
    public TextBoxFlexibleDate getTxtRofukuNenkinKaishiDate() {
        return txtRofukuNenkinKaishiDate;
    }

    @JsonProperty("txtRofukuNenkinKaishiDate")
    public void setTxtRofukuNenkinKaishiDate(TextBoxFlexibleDate txtRofukuNenkinKaishiDate) {
        this.txtRofukuNenkinKaishiDate=txtRofukuNenkinKaishiDate;
    }

    @JsonProperty("txtRofukuNenkinShuryoDate")
    public TextBoxFlexibleDate getTxtRofukuNenkinShuryoDate() {
        return txtRofukuNenkinShuryoDate;
    }

    @JsonProperty("txtRofukuNenkinShuryoDate")
    public void setTxtRofukuNenkinShuryoDate(TextBoxFlexibleDate txtRofukuNenkinShuryoDate) {
        this.txtRofukuNenkinShuryoDate=txtRofukuNenkinShuryoDate;
    }

    @JsonProperty("txtRofukuNenkinJukyushaNo")
    public TextBoxCode getTxtRofukuNenkinJukyushaNo() {
        return txtRofukuNenkinJukyushaNo;
    }

    @JsonProperty("txtRofukuNenkinJukyushaNo")
    public void setTxtRofukuNenkinJukyushaNo(TextBoxCode txtRofukuNenkinJukyushaNo) {
        this.txtRofukuNenkinJukyushaNo=txtRofukuNenkinJukyushaNo;
    }

}
