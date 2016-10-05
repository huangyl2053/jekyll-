package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD6010003;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SystemKanri のクラスファイル 
 * 
 * @author 自動生成
 */
public class SystemKanriDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SystemKanriShakaiFukushi")
    private SystemKanriShakaiFukushiDiv SystemKanriShakaiFukushi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getSystemKanriShakaiFukushi
     * @return SystemKanriShakaiFukushi
     */
    @JsonProperty("SystemKanriShakaiFukushi")
    public SystemKanriShakaiFukushiDiv getSystemKanriShakaiFukushi() {
        return SystemKanriShakaiFukushi;
    }

    /*
     * setSystemKanriShakaiFukushi
     * @param SystemKanriShakaiFukushi SystemKanriShakaiFukushi
     */
    @JsonProperty("SystemKanriShakaiFukushi")
    public void setSystemKanriShakaiFukushi(SystemKanriShakaiFukushiDiv SystemKanriShakaiFukushi) {
        this.SystemKanriShakaiFukushi = SystemKanriShakaiFukushi;
    }

    // </editor-fold>
}
