package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Tokki のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokkiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-23_13-41-30">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("imgTokkiJiko")
    private DynamicImage imgTokkiJiko;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getimgTokkiJiko
     * @return imgTokkiJiko
     */
    @JsonProperty("imgTokkiJiko")
    public DynamicImage getImgTokkiJiko() {
        return imgTokkiJiko;
    }

    /*
     * setimgTokkiJiko
     * @param imgTokkiJiko imgTokkiJiko
     */
    @JsonProperty("imgTokkiJiko")
    public void setImgTokkiJiko(DynamicImage imgTokkiJiko) {
        this.imgTokkiJiko = imgTokkiJiko;
    }

    // </editor-fold>
}
