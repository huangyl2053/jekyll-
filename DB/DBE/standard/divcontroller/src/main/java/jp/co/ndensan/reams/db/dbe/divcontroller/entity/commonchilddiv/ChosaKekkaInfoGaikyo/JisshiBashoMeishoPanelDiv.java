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
 * JisshiBashoMeishoPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class JisshiBashoMeishoPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-16_10-13-04">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("imgChosaJisshiBashoMeisho")
    private DynamicImage imgChosaJisshiBashoMeisho;
    @JsonProperty("lblNoImageJisshiBasho")
    private Label lblNoImageJisshiBasho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getimgChosaJisshiBashoMeisho
     * @return imgChosaJisshiBashoMeisho
     */
    @JsonProperty("imgChosaJisshiBashoMeisho")
    public DynamicImage getImgChosaJisshiBashoMeisho() {
        return imgChosaJisshiBashoMeisho;
    }

    /*
     * setimgChosaJisshiBashoMeisho
     * @param imgChosaJisshiBashoMeisho imgChosaJisshiBashoMeisho
     */
    @JsonProperty("imgChosaJisshiBashoMeisho")
    public void setImgChosaJisshiBashoMeisho(DynamicImage imgChosaJisshiBashoMeisho) {
        this.imgChosaJisshiBashoMeisho = imgChosaJisshiBashoMeisho;
    }

    /*
     * getlblNoImageJisshiBasho
     * @return lblNoImageJisshiBasho
     */
    @JsonProperty("lblNoImageJisshiBasho")
    public Label getLblNoImageJisshiBasho() {
        return lblNoImageJisshiBasho;
    }

    /*
     * setlblNoImageJisshiBasho
     * @param lblNoImageJisshiBasho lblNoImageJisshiBasho
     */
    @JsonProperty("lblNoImageJisshiBasho")
    public void setLblNoImageJisshiBasho(Label lblNoImageJisshiBasho) {
        this.lblNoImageJisshiBasho = lblNoImageJisshiBasho;
    }

    // </editor-fold>
}
