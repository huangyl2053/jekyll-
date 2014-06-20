package jp.co.ndensan.reams.db.dbz.divcontroller.entity.SeikatsuhogoDetail;
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
 * HokenryoDairinofu のクラスファイル 
 * 
 * @author 自動生成
 */
public class HokenryoDairinofuDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radDairinofuKubun")
    private RadioButton radDairinofuKubun;
    @JsonProperty("txtNofuYM")
    private TextBoxDate txtNofuYM;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("radDairinofuKubun")
    public RadioButton getRadDairinofuKubun() {
        return radDairinofuKubun;
    }

    @JsonProperty("radDairinofuKubun")
    public void setRadDairinofuKubun(RadioButton radDairinofuKubun) {
        this.radDairinofuKubun=radDairinofuKubun;
    }

    @JsonProperty("txtNofuYM")
    public TextBoxDate getTxtNofuYM() {
        return txtNofuYM;
    }

    @JsonProperty("txtNofuYM")
    public void setTxtNofuYM(TextBoxDate txtNofuYM) {
        this.txtNofuYM=txtNofuYM;
    }

}
