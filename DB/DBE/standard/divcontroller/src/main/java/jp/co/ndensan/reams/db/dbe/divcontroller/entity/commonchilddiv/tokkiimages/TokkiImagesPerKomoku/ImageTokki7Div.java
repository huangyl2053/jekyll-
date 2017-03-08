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
 * ImageTokki7 のクラスファイル 
 * 
 * @author 自動生成
 */
public class ImageTokki7Div extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-23_13-41-30">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("imgTokki7")
    private DynamicImage imgTokki7;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getimgTokki7
     * @return imgTokki7
     */
    @JsonProperty("imgTokki7")
    public DynamicImage getImgTokki7() {
        return imgTokki7;
    }

    /*
     * setimgTokki7
     * @param imgTokki7 imgTokki7
     */
    @JsonProperty("imgTokki7")
    public void setImgTokki7(DynamicImage imgTokki7) {
        this.imgTokki7 = imgTokki7;
    }

    // </editor-fold>
}
