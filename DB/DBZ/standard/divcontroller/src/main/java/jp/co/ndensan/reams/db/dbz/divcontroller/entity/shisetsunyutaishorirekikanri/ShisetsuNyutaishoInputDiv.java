package jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsunyutaishorirekikanri;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsujoho.ShisetsuJohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShisetsuNyutaishoInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShisetsuNyutaishoInputDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlTaishoJoho")
    private DropDownList ddlTaishoJoho;
    @JsonProperty("txtNyushoDate")
    private TextBoxFlexibleDate txtNyushoDate;
    @JsonProperty("txtTaishoDate")
    private TextBoxFlexibleDate txtTaishoDate;
    @JsonProperty("ShisetsuJoho")
    private ShisetsuJohoDiv ShisetsuJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ddlTaishoJoho")
    public DropDownList getDdlTaishoJoho() {
        return ddlTaishoJoho;
    }

    @JsonProperty("ddlTaishoJoho")
    public void setDdlTaishoJoho(DropDownList ddlTaishoJoho) {
        this.ddlTaishoJoho=ddlTaishoJoho;
    }

    @JsonProperty("txtNyushoDate")
    public TextBoxFlexibleDate getTxtNyushoDate() {
        return txtNyushoDate;
    }

    @JsonProperty("txtNyushoDate")
    public void setTxtNyushoDate(TextBoxFlexibleDate txtNyushoDate) {
        this.txtNyushoDate=txtNyushoDate;
    }

    @JsonProperty("txtTaishoDate")
    public TextBoxFlexibleDate getTxtTaishoDate() {
        return txtTaishoDate;
    }

    @JsonProperty("txtTaishoDate")
    public void setTxtTaishoDate(TextBoxFlexibleDate txtTaishoDate) {
        this.txtTaishoDate=txtTaishoDate;
    }

    @JsonProperty("ShisetsuJoho")
    public ShisetsuJohoDiv getShisetsuJoho() {
        return ShisetsuJoho;
    }

    @JsonProperty("ShisetsuJoho")
    public void setShisetsuJoho(ShisetsuJohoDiv ShisetsuJoho) {
        this.ShisetsuJoho=ShisetsuJoho;
    }

}
