package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4070001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4070001.LatestShinsakaiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * LatestPublication のクラスファイル 
 * 
 * @author 自動生成
 */
public class LatestPublicationDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtOperationDate")
    private TextBoxFlexibleDate txtOperationDate;
    @JsonProperty("txtShoriKubun")
    private TextBox txtShoriKubun;
    @JsonProperty("LatestShinsakai")
    private LatestShinsakaiDiv LatestShinsakai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtOperationDate")
    public TextBoxFlexibleDate getTxtOperationDate() {
        return txtOperationDate;
    }

    @JsonProperty("txtOperationDate")
    public void setTxtOperationDate(TextBoxFlexibleDate txtOperationDate) {
        this.txtOperationDate=txtOperationDate;
    }

    @JsonProperty("txtShoriKubun")
    public TextBox getTxtShoriKubun() {
        return txtShoriKubun;
    }

    @JsonProperty("txtShoriKubun")
    public void setTxtShoriKubun(TextBox txtShoriKubun) {
        this.txtShoriKubun=txtShoriKubun;
    }

    @JsonProperty("LatestShinsakai")
    public LatestShinsakaiDiv getLatestShinsakai() {
        return LatestShinsakai;
    }

    @JsonProperty("LatestShinsakai")
    public void setLatestShinsakai(LatestShinsakaiDiv LatestShinsakai) {
        this.LatestShinsakai=LatestShinsakai;
    }

}
