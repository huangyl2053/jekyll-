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
 * ShisetsuJushoPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShisetsuJushoPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-23_06-32-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("imgRiyoShisetsuJusho")
    private DynamicImage imgRiyoShisetsuJusho;
    @JsonProperty("lblNoImageRiyoShisetsuJusho")
    private Label lblNoImageRiyoShisetsuJusho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getimgRiyoShisetsuJusho
     * @return imgRiyoShisetsuJusho
     */
    @JsonProperty("imgRiyoShisetsuJusho")
    public DynamicImage getImgRiyoShisetsuJusho() {
        return imgRiyoShisetsuJusho;
    }

    /*
     * setimgRiyoShisetsuJusho
     * @param imgRiyoShisetsuJusho imgRiyoShisetsuJusho
     */
    @JsonProperty("imgRiyoShisetsuJusho")
    public void setImgRiyoShisetsuJusho(DynamicImage imgRiyoShisetsuJusho) {
        this.imgRiyoShisetsuJusho = imgRiyoShisetsuJusho;
    }

    /*
     * getlblNoImageRiyoShisetsuJusho
     * @return lblNoImageRiyoShisetsuJusho
     */
    @JsonProperty("lblNoImageRiyoShisetsuJusho")
    public Label getLblNoImageRiyoShisetsuJusho() {
        return lblNoImageRiyoShisetsuJusho;
    }

    /*
     * setlblNoImageRiyoShisetsuJusho
     * @param lblNoImageRiyoShisetsuJusho lblNoImageRiyoShisetsuJusho
     */
    @JsonProperty("lblNoImageRiyoShisetsuJusho")
    public void setLblNoImageRiyoShisetsuJusho(Label lblNoImageRiyoShisetsuJusho) {
        this.lblNoImageRiyoShisetsuJusho = lblNoImageRiyoShisetsuJusho;
    }

    // </editor-fold>
}
