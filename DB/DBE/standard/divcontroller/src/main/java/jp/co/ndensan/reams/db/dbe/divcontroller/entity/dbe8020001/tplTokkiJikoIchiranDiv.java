package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tplTokkiJikoIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplTokkiJikoIchiranDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlTokkiJikoKomoku1")
    private DropDownList ddlTokkiJikoKomoku1;
    @JsonProperty("ddlTokkiJikoKomoku2")
    private DropDownList ddlTokkiJikoKomoku2;
    @JsonProperty("txtTokkiJikoKomoku1")
    private TextBoxMultiLine txtTokkiJikoKomoku1;
    @JsonProperty("txtTokkiJikoKomoku2")
    private TextBoxMultiLine txtTokkiJikoKomoku2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ddlTokkiJikoKomoku1")
    public DropDownList getDdlTokkiJikoKomoku1() {
        return ddlTokkiJikoKomoku1;
    }

    @JsonProperty("ddlTokkiJikoKomoku1")
    public void setDdlTokkiJikoKomoku1(DropDownList ddlTokkiJikoKomoku1) {
        this.ddlTokkiJikoKomoku1=ddlTokkiJikoKomoku1;
    }

    @JsonProperty("ddlTokkiJikoKomoku2")
    public DropDownList getDdlTokkiJikoKomoku2() {
        return ddlTokkiJikoKomoku2;
    }

    @JsonProperty("ddlTokkiJikoKomoku2")
    public void setDdlTokkiJikoKomoku2(DropDownList ddlTokkiJikoKomoku2) {
        this.ddlTokkiJikoKomoku2=ddlTokkiJikoKomoku2;
    }

    @JsonProperty("txtTokkiJikoKomoku1")
    public TextBoxMultiLine getTxtTokkiJikoKomoku1() {
        return txtTokkiJikoKomoku1;
    }

    @JsonProperty("txtTokkiJikoKomoku1")
    public void setTxtTokkiJikoKomoku1(TextBoxMultiLine txtTokkiJikoKomoku1) {
        this.txtTokkiJikoKomoku1=txtTokkiJikoKomoku1;
    }

    @JsonProperty("txtTokkiJikoKomoku2")
    public TextBoxMultiLine getTxtTokkiJikoKomoku2() {
        return txtTokkiJikoKomoku2;
    }

    @JsonProperty("txtTokkiJikoKomoku2")
    public void setTxtTokkiJikoKomoku2(TextBoxMultiLine txtTokkiJikoKomoku2) {
        this.txtTokkiJikoKomoku2=txtTokkiJikoKomoku2;
    }

}
