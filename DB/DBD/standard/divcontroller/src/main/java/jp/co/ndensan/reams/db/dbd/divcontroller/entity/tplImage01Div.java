package jp.co.ndensan.reams.db.dbd.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tplImage01 のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplImage01Div extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("imgIkenshoTheRight")
    private StaticImage imgIkenshoTheRight;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("imgIkenshoTheRight")
    public StaticImage getImgIkenshoTheRight() {
        return imgIkenshoTheRight;
    }

    @JsonProperty("imgIkenshoTheRight")
    public void setImgIkenshoTheRight(StaticImage imgIkenshoTheRight) {
        this.imgIkenshoTheRight=imgIkenshoTheRight;
    }

}
