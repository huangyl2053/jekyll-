package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.tokkiimages.TokkiImagesPerKomoku;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ImageTokki5 のクラスファイル 
 * 
 * @author 自動生成
 */
public class ImageTokki5Div extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-23_13-41-30">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("imgTokki5")
    private DynamicImage imgTokki5;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getimgTokki5
     * @return imgTokki5
     */
    @JsonProperty("imgTokki5")
    public DynamicImage getImgTokki5() {
        return imgTokki5;
    }

    /*
     * setimgTokki5
     * @param imgTokki5 imgTokki5
     */
    @JsonProperty("imgTokki5")
    public void setImgTokki5(DynamicImage imgTokki5) {
        this.imgTokki5 = imgTokki5;
    }

    // </editor-fold>
}
