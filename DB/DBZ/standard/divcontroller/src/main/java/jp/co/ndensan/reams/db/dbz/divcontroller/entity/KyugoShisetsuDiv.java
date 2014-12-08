package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
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
 * KyugoShisetsu のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyugoShisetsuDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radNyutaishoKubun")
    private RadioButton radNyutaishoKubun;
    @JsonProperty("txtNyushoDate")
    private TextBoxDate txtNyushoDate;
    @JsonProperty("txtTaishoDate")
    private TextBoxDate txtTaishoDate;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("radNyutaishoKubun")
    public RadioButton getRadNyutaishoKubun() {
        return radNyutaishoKubun;
    }

    @JsonProperty("radNyutaishoKubun")
    public void setRadNyutaishoKubun(RadioButton radNyutaishoKubun) {
        this.radNyutaishoKubun=radNyutaishoKubun;
    }

    @JsonProperty("txtNyushoDate")
    public TextBoxDate getTxtNyushoDate() {
        return txtNyushoDate;
    }

    @JsonProperty("txtNyushoDate")
    public void setTxtNyushoDate(TextBoxDate txtNyushoDate) {
        this.txtNyushoDate=txtNyushoDate;
    }

    @JsonProperty("txtTaishoDate")
    public TextBoxDate getTxtTaishoDate() {
        return txtTaishoDate;
    }

    @JsonProperty("txtTaishoDate")
    public void setTxtTaishoDate(TextBoxDate txtTaishoDate) {
        this.txtTaishoDate=txtTaishoDate;
    }

}
