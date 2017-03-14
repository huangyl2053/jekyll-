package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ChosaKekkaInfoGaikyo.ChosaKekkaInfoGaikyo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ZaitakuServiceSmallPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class ZaitakuServiceSmallPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-23_13-41-30">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("imgZaitakuServiceSmall")
    private DynamicImage imgZaitakuServiceSmall;
    @JsonProperty("lblImgZaitakuServiceSmall")
    private Label lblImgZaitakuServiceSmall;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getimgZaitakuServiceSmall
     * @return imgZaitakuServiceSmall
     */
    @JsonProperty("imgZaitakuServiceSmall")
    public DynamicImage getImgZaitakuServiceSmall() {
        return imgZaitakuServiceSmall;
    }

    /*
     * setimgZaitakuServiceSmall
     * @param imgZaitakuServiceSmall imgZaitakuServiceSmall
     */
    @JsonProperty("imgZaitakuServiceSmall")
    public void setImgZaitakuServiceSmall(DynamicImage imgZaitakuServiceSmall) {
        this.imgZaitakuServiceSmall = imgZaitakuServiceSmall;
    }

    /*
     * getlblImgZaitakuServiceSmall
     * @return lblImgZaitakuServiceSmall
     */
    @JsonProperty("lblImgZaitakuServiceSmall")
    public Label getLblImgZaitakuServiceSmall() {
        return lblImgZaitakuServiceSmall;
    }

    /*
     * setlblImgZaitakuServiceSmall
     * @param lblImgZaitakuServiceSmall lblImgZaitakuServiceSmall
     */
    @JsonProperty("lblImgZaitakuServiceSmall")
    public void setLblImgZaitakuServiceSmall(Label lblImgZaitakuServiceSmall) {
        this.lblImgZaitakuServiceSmall = lblImgZaitakuServiceSmall;
    }

    // </editor-fold>
}
