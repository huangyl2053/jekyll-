package jp.co.ndensan.reams.db.dba.divcontroller.entity.dba2040011;
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
 * AfterShisetsuJohoInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class AfterShisetsuJohoInputDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtAfterShisetsuNyushoDate")
    private TextBoxFlexibleDate txtAfterShisetsuNyushoDate;
    @JsonProperty("AfterShisetsuJoho")
    private ShisetsuJohoDiv AfterShisetsuJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtAfterShisetsuNyushoDate")
    public TextBoxFlexibleDate getTxtAfterShisetsuNyushoDate() {
        return txtAfterShisetsuNyushoDate;
    }

    @JsonProperty("txtAfterShisetsuNyushoDate")
    public void setTxtAfterShisetsuNyushoDate(TextBoxFlexibleDate txtAfterShisetsuNyushoDate) {
        this.txtAfterShisetsuNyushoDate=txtAfterShisetsuNyushoDate;
    }

    @JsonProperty("AfterShisetsuJoho")
    public ShisetsuJohoDiv getAfterShisetsuJoho() {
        return AfterShisetsuJoho;
    }

    @JsonProperty("AfterShisetsuJoho")
    public void setAfterShisetsuJoho(ShisetsuJohoDiv AfterShisetsuJoho) {
        this.AfterShisetsuJoho=AfterShisetsuJoho;
    }

}
