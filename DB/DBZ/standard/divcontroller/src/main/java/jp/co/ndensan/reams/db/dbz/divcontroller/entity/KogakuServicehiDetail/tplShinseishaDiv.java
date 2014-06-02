package jp.co.ndensan.reams.db.dbz.divcontroller.entity.KogakuServicehiDetail;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.ShinseishaInfo.ShinseishaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.ShinseishaInfo.ShinseishaInfoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tplShinseisha のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplShinseishaDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("Shinseisha")
    private ShinseishaInfoDiv Shinseisha;
    @JsonProperty("txtShinseiRiyu")
    private TextBoxMultiLine txtShinseiRiyu;
    @JsonProperty("txtShiharaiTotalAmount")
    private TextBoxNum txtShiharaiTotalAmount;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("Shinseisha")
    public ShinseishaInfoDiv getShinseisha() {
        return Shinseisha;
    }

    @JsonProperty("Shinseisha")
    public void setShinseisha(ShinseishaInfoDiv Shinseisha) {
        this.Shinseisha=Shinseisha;
    }

    @JsonProperty("txtShinseiRiyu")
    public TextBoxMultiLine getTxtShinseiRiyu() {
        return txtShinseiRiyu;
    }

    @JsonProperty("txtShinseiRiyu")
    public void setTxtShinseiRiyu(TextBoxMultiLine txtShinseiRiyu) {
        this.txtShinseiRiyu=txtShinseiRiyu;
    }

    @JsonProperty("txtShiharaiTotalAmount")
    public TextBoxNum getTxtShiharaiTotalAmount() {
        return txtShiharaiTotalAmount;
    }

    @JsonProperty("txtShiharaiTotalAmount")
    public void setTxtShiharaiTotalAmount(TextBoxNum txtShiharaiTotalAmount) {
        this.txtShiharaiTotalAmount=txtShiharaiTotalAmount;
    }

}
