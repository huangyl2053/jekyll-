package jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0600011;
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
 * SogoShokaiJuminSogoJigyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class SogoShokaiJuminSogoJigyoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtJigyoNijiKikan")
    private TextBoxDateRange txtJigyoNijiKikan;
    @JsonProperty("txtJigyoNijiYoboHanteiYMD")
    private TextBoxDate txtJigyoNijiYoboHanteiYMD;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtJigyoNijiKikan")
    public TextBoxDateRange getTxtJigyoNijiKikan() {
        return txtJigyoNijiKikan;
    }

    @JsonProperty("txtJigyoNijiKikan")
    public void setTxtJigyoNijiKikan(TextBoxDateRange txtJigyoNijiKikan) {
        this.txtJigyoNijiKikan=txtJigyoNijiKikan;
    }

    @JsonProperty("txtJigyoNijiYoboHanteiYMD")
    public TextBoxDate getTxtJigyoNijiYoboHanteiYMD() {
        return txtJigyoNijiYoboHanteiYMD;
    }

    @JsonProperty("txtJigyoNijiYoboHanteiYMD")
    public void setTxtJigyoNijiYoboHanteiYMD(TextBoxDate txtJigyoNijiYoboHanteiYMD) {
        this.txtJigyoNijiYoboHanteiYMD=txtJigyoNijiYoboHanteiYMD;
    }

}
