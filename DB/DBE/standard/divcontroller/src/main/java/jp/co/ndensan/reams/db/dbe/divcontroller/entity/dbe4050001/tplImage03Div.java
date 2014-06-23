package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4050001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4050001.ImageTokkiJiko1Div;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tplImage03 のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplImage03Div extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ImageTokkiJiko1")
    private ImageTokkiJiko1Div ImageTokkiJiko1;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ImageTokkiJiko1")
    public ImageTokkiJiko1Div getImageTokkiJiko1() {
        return ImageTokkiJiko1;
    }

    @JsonProperty("ImageTokkiJiko1")
    public void setImageTokkiJiko1(ImageTokkiJiko1Div ImageTokkiJiko1) {
        this.ImageTokkiJiko1=ImageTokkiJiko1;
    }

}
