package jp.co.ndensan.reams.db.dbc.divcontroller.entity.dbc0700011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dbc0700011.JutakuKaishuJizenShinseiDetailDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuJizenShinseiReasonDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuJizenShinseiReasonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.PaymentMethod.PaymentMethodDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.ShinseishaInfo.ShinseishaInfoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * JutakuKaishuJizenShinseiContentsPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class JutakuKaishuJizenShinseiContentsPanelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtJutakuOwner")
    private TextBox txtJutakuOwner;
    @JsonProperty("txtRelationWithHihokensha")
    private TextBox txtRelationWithHihokensha;
    @JsonProperty("JutakuKaishuJizenShinseiDetail")
    private JutakuKaishuJizenShinseiDetailDiv JutakuKaishuJizenShinseiDetail;
    @JsonProperty("JutakuKaishuJizenShinseisha")
    private ShinseishaInfoDiv JutakuKaishuJizenShinseisha;
    @JsonProperty("JutakuKaishuJizenShinseiReason")
    private JutakuKaishuJizenShinseiReasonDiv JutakuKaishuJizenShinseiReason;
    @JsonProperty("JutakuKaishuJizenShinseiKoza")
    private PaymentMethodDiv JutakuKaishuJizenShinseiKoza;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtJutakuOwner")
    public TextBox getTxtJutakuOwner() {
        return txtJutakuOwner;
    }

    @JsonProperty("txtJutakuOwner")
    public void setTxtJutakuOwner(TextBox txtJutakuOwner) {
        this.txtJutakuOwner=txtJutakuOwner;
    }

    @JsonProperty("txtRelationWithHihokensha")
    public TextBox getTxtRelationWithHihokensha() {
        return txtRelationWithHihokensha;
    }

    @JsonProperty("txtRelationWithHihokensha")
    public void setTxtRelationWithHihokensha(TextBox txtRelationWithHihokensha) {
        this.txtRelationWithHihokensha=txtRelationWithHihokensha;
    }

    @JsonProperty("JutakuKaishuJizenShinseiDetail")
    public JutakuKaishuJizenShinseiDetailDiv getJutakuKaishuJizenShinseiDetail() {
        return JutakuKaishuJizenShinseiDetail;
    }

    @JsonProperty("JutakuKaishuJizenShinseiDetail")
    public void setJutakuKaishuJizenShinseiDetail(JutakuKaishuJizenShinseiDetailDiv JutakuKaishuJizenShinseiDetail) {
        this.JutakuKaishuJizenShinseiDetail=JutakuKaishuJizenShinseiDetail;
    }

    @JsonProperty("JutakuKaishuJizenShinseisha")
    public ShinseishaInfoDiv getJutakuKaishuJizenShinseisha() {
        return JutakuKaishuJizenShinseisha;
    }

    @JsonProperty("JutakuKaishuJizenShinseisha")
    public void setJutakuKaishuJizenShinseisha(ShinseishaInfoDiv JutakuKaishuJizenShinseisha) {
        this.JutakuKaishuJizenShinseisha=JutakuKaishuJizenShinseisha;
    }

    @JsonProperty("JutakuKaishuJizenShinseiReason")
    public JutakuKaishuJizenShinseiReasonDiv getJutakuKaishuJizenShinseiReason() {
        return JutakuKaishuJizenShinseiReason;
    }

    @JsonProperty("JutakuKaishuJizenShinseiReason")
    public void setJutakuKaishuJizenShinseiReason(JutakuKaishuJizenShinseiReasonDiv JutakuKaishuJizenShinseiReason) {
        this.JutakuKaishuJizenShinseiReason=JutakuKaishuJizenShinseiReason;
    }

    @JsonProperty("JutakuKaishuJizenShinseiKoza")
    public PaymentMethodDiv getJutakuKaishuJizenShinseiKoza() {
        return JutakuKaishuJizenShinseiKoza;
    }

    @JsonProperty("JutakuKaishuJizenShinseiKoza")
    public void setJutakuKaishuJizenShinseiKoza(PaymentMethodDiv JutakuKaishuJizenShinseiKoza) {
        this.JutakuKaishuJizenShinseiKoza=JutakuKaishuJizenShinseiKoza;
    }

}
