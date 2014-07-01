package jp.co.ndensan.reams.db.dbe.divcontroller.entity.kanryoDialog;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.kanryoDialog.WrapMessageMainDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SuccessInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class SuccessInfoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("imgSuccess")
    private StaticImage imgSuccess;
    @JsonProperty("WrapMessageMain")
    private WrapMessageMainDiv WrapMessageMain;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("imgSuccess")
    public StaticImage getImgSuccess() {
        return imgSuccess;
    }

    @JsonProperty("imgSuccess")
    public void setImgSuccess(StaticImage imgSuccess) {
        this.imgSuccess=imgSuccess;
    }

    @JsonProperty("WrapMessageMain")
    public WrapMessageMainDiv getWrapMessageMain() {
        return WrapMessageMain;
    }

    @JsonProperty("WrapMessageMain")
    public void setWrapMessageMain(WrapMessageMainDiv WrapMessageMain) {
        this.WrapMessageMain=WrapMessageMain;
    }

}
