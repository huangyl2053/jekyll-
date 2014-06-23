package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4050001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4050001.ImageTokkiJiko2Div;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tplImage04 のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplImage04Div extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ImageTokkiJiko2")
    private ImageTokkiJiko2Div ImageTokkiJiko2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ImageTokkiJiko2")
    public ImageTokkiJiko2Div getImageTokkiJiko2() {
        return ImageTokkiJiko2;
    }

    @JsonProperty("ImageTokkiJiko2")
    public void setImageTokkiJiko2(ImageTokkiJiko2Div ImageTokkiJiko2) {
        this.ImageTokkiJiko2=ImageTokkiJiko2;
    }

}
