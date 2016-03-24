package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KanryoDialog;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SuccessInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class SuccessInfoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
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
    /*
     * getimgSuccess
     * @return imgSuccess
     */
    @JsonProperty("imgSuccess")
    public StaticImage getImgSuccess() {
        return imgSuccess;
    }

    /*
     * setimgSuccess
     * @param imgSuccess imgSuccess
     */
    @JsonProperty("imgSuccess")
    public void setImgSuccess(StaticImage imgSuccess) {
        this.imgSuccess = imgSuccess;
    }

    /*
     * getWrapMessageMain
     * @return WrapMessageMain
     */
    @JsonProperty("WrapMessageMain")
    public WrapMessageMainDiv getWrapMessageMain() {
        return WrapMessageMain;
    }

    /*
     * setWrapMessageMain
     * @param WrapMessageMain WrapMessageMain
     */
    @JsonProperty("WrapMessageMain")
    public void setWrapMessageMain(WrapMessageMainDiv WrapMessageMain) {
        this.WrapMessageMain = WrapMessageMain;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblMessageMain() {
        return this.getWrapMessageMain().getLblMessageMain();
    }

    @JsonIgnore
    public void  setLblMessageMain(Label lblMessageMain) {
        this.getWrapMessageMain().setLblMessageMain(lblMessageMain);
    }

    // </editor-fold>
}
