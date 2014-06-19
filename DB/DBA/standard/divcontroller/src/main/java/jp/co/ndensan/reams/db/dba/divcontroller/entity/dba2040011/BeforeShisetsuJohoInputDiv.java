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
 * BeforeShisetsuJohoInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class BeforeShisetsuJohoInputDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtBeforeShisetsuTaishoDate")
    private TextBoxFlexibleDate txtBeforeShisetsuTaishoDate;
    @JsonProperty("BeforeShisetsuJoho")
    private ShisetsuJohoDiv BeforeShisetsuJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtBeforeShisetsuTaishoDate")
    public TextBoxFlexibleDate getTxtBeforeShisetsuTaishoDate() {
        return txtBeforeShisetsuTaishoDate;
    }

    @JsonProperty("txtBeforeShisetsuTaishoDate")
    public void setTxtBeforeShisetsuTaishoDate(TextBoxFlexibleDate txtBeforeShisetsuTaishoDate) {
        this.txtBeforeShisetsuTaishoDate=txtBeforeShisetsuTaishoDate;
    }

    @JsonProperty("BeforeShisetsuJoho")
    public ShisetsuJohoDiv getBeforeShisetsuJoho() {
        return BeforeShisetsuJoho;
    }

    @JsonProperty("BeforeShisetsuJoho")
    public void setBeforeShisetsuJoho(ShisetsuJohoDiv BeforeShisetsuJoho) {
        this.BeforeShisetsuJoho=BeforeShisetsuJoho;
    }

}
