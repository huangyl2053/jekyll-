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
 * TelNoPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class TelNoPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-23_13-41-30">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("imgTelNo")
    private DynamicImage imgTelNo;
    @JsonProperty("lblNoImageTelNo")
    private Label lblNoImageTelNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getimgTelNo
     * @return imgTelNo
     */
    @JsonProperty("imgTelNo")
    public DynamicImage getImgTelNo() {
        return imgTelNo;
    }

    /*
     * setimgTelNo
     * @param imgTelNo imgTelNo
     */
    @JsonProperty("imgTelNo")
    public void setImgTelNo(DynamicImage imgTelNo) {
        this.imgTelNo = imgTelNo;
    }

    /*
     * getlblNoImageTelNo
     * @return lblNoImageTelNo
     */
    @JsonProperty("lblNoImageTelNo")
    public Label getLblNoImageTelNo() {
        return lblNoImageTelNo;
    }

    /*
     * setlblNoImageTelNo
     * @param lblNoImageTelNo lblNoImageTelNo
     */
    @JsonProperty("lblNoImageTelNo")
    public void setLblNoImageTelNo(Label lblNoImageTelNo) {
        this.lblNoImageTelNo = lblNoImageTelNo;
    }

    // </editor-fold>
}
