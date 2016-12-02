package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ChosaKekkaInfoGaikyo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TokubetsuKyufuPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokubetsuKyufuPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTokubetsuKyufu")
    private TextBoxMultiLine txtTokubetsuKyufu;
    @JsonProperty("imgTokubetsuKyufu")
    private DynamicImage imgTokubetsuKyufu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtTokubetsuKyufu
     * @return txtTokubetsuKyufu
     */
    @JsonProperty("txtTokubetsuKyufu")
    public TextBoxMultiLine getTxtTokubetsuKyufu() {
        return txtTokubetsuKyufu;
    }

    /*
     * settxtTokubetsuKyufu
     * @param txtTokubetsuKyufu txtTokubetsuKyufu
     */
    @JsonProperty("txtTokubetsuKyufu")
    public void setTxtTokubetsuKyufu(TextBoxMultiLine txtTokubetsuKyufu) {
        this.txtTokubetsuKyufu = txtTokubetsuKyufu;
    }

    /*
     * getimgTokubetsuKyufu
     * @return imgTokubetsuKyufu
     */
    @JsonProperty("imgTokubetsuKyufu")
    public DynamicImage getImgTokubetsuKyufu() {
        return imgTokubetsuKyufu;
    }

    /*
     * setimgTokubetsuKyufu
     * @param imgTokubetsuKyufu imgTokubetsuKyufu
     */
    @JsonProperty("imgTokubetsuKyufu")
    public void setImgTokubetsuKyufu(DynamicImage imgTokubetsuKyufu) {
        this.imgTokubetsuKyufu = imgTokubetsuKyufu;
    }

    // </editor-fold>
}
