package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2070001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2070001.ImageIkensho2Div;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tplIkensho2 のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplIkensho2Div extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ImageIkensho2")
    private ImageIkensho2Div ImageIkensho2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ImageIkensho2")
    public ImageIkensho2Div getImageIkensho2() {
        return ImageIkensho2;
    }

    @JsonProperty("ImageIkensho2")
    public void setImageIkensho2(ImageIkensho2Div ImageIkensho2) {
        this.ImageIkensho2=ImageIkensho2;
    }

}
