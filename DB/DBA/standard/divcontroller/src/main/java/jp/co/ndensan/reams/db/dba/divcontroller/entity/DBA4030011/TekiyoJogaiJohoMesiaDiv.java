package jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA4030011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA4030011.KaijoJiyuInputDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA4030011.TekiyoJiyuInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * TekiyoJogaiJohoMesia のクラスファイル 
 * 
 * @author 自動生成
 */
public class TekiyoJogaiJohoMesiaDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TekiyoJiyuInput")
    private TekiyoJiyuInputDiv TekiyoJiyuInput;
    @JsonProperty("KaijoJiyuInput")
    private KaijoJiyuInputDiv KaijoJiyuInput;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("TekiyoJiyuInput")
    public TekiyoJiyuInputDiv getTekiyoJiyuInput() {
        return TekiyoJiyuInput;
    }

    @JsonProperty("TekiyoJiyuInput")
    public void setTekiyoJiyuInput(TekiyoJiyuInputDiv TekiyoJiyuInput) {
        this.TekiyoJiyuInput=TekiyoJiyuInput;
    }

    @JsonProperty("KaijoJiyuInput")
    public KaijoJiyuInputDiv getKaijoJiyuInput() {
        return KaijoJiyuInput;
    }

    @JsonProperty("KaijoJiyuInput")
    public void setKaijoJiyuInput(KaijoJiyuInputDiv KaijoJiyuInput) {
        this.KaijoJiyuInput=KaijoJiyuInput;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxFlexibleDate getTxtKaijoDate() {
        return this.getKaijoJiyuInput().getTxtKaijoDate();
    }

    @JsonIgnore
    public void  setTxtKaijoDate(TextBoxFlexibleDate txtKaijoDate) {
        this.getKaijoJiyuInput().setTxtKaijoDate(txtKaijoDate);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKaijoTodokedeDate() {
        return this.getKaijoJiyuInput().getTxtKaijoTodokedeDate();
    }

    @JsonIgnore
    public void  setTxtKaijoTodokedeDate(TextBoxFlexibleDate txtKaijoTodokedeDate) {
        this.getKaijoJiyuInput().setTxtKaijoTodokedeDate(txtKaijoTodokedeDate);
    }

    @JsonIgnore
    public DropDownList getDdlKaijoJiyu() {
        return this.getKaijoJiyuInput().getDdlKaijoJiyu();
    }

    @JsonIgnore
    public void  setDdlKaijoJiyu(DropDownList ddlKaijoJiyu) {
        this.getKaijoJiyuInput().setDdlKaijoJiyu(ddlKaijoJiyu);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShisetsuTaishoDate() {
        return this.getKaijoJiyuInput().getTxtShisetsuTaishoDate();
    }

    @JsonIgnore
    public void  setTxtShisetsuTaishoDate(TextBoxFlexibleDate txtShisetsuTaishoDate) {
        this.getKaijoJiyuInput().setTxtShisetsuTaishoDate(txtShisetsuTaishoDate);
    }

}
