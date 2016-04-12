package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1090001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ZengoRireki のクラスファイル 
 * 
 * @author 自動生成
 */
public class ZengoRirekiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("bttZenRireki")
    private Button bttZenRireki;
    @JsonProperty("bttGoRireki")
    private Button bttGoRireki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbttZenRireki
     * @return bttZenRireki
     */
    @JsonProperty("bttZenRireki")
    public Button getBttZenRireki() {
        return bttZenRireki;
    }

    /*
     * setbttZenRireki
     * @param bttZenRireki bttZenRireki
     */
    @JsonProperty("bttZenRireki")
    public void setBttZenRireki(Button bttZenRireki) {
        this.bttZenRireki = bttZenRireki;
    }

    /*
     * getbttGoRireki
     * @return bttGoRireki
     */
    @JsonProperty("bttGoRireki")
    public Button getBttGoRireki() {
        return bttGoRireki;
    }

    /*
     * setbttGoRireki
     * @param bttGoRireki bttGoRireki
     */
    @JsonProperty("bttGoRireki")
    public void setBttGoRireki(Button bttGoRireki) {
        this.bttGoRireki = bttGoRireki;
    }

    // </editor-fold>
}
