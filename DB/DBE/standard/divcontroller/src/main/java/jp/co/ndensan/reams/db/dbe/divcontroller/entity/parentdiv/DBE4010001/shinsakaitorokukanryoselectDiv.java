package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * shinsakaitorokukanryoselect のクラスファイル 
 * 
 * @author 自動生成
 */
public class shinsakaitorokukanryoselectDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnshinsakekkakanryooutput")
    private Button btnshinsakekkakanryooutput;
    @JsonProperty("hiddenbtnshinsakekkakanryooutput")
    private ButtonDownLoad hiddenbtnshinsakekkakanryooutput;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnshinsakekkakanryooutput
     * @return btnshinsakekkakanryooutput
     */
    @JsonProperty("btnshinsakekkakanryooutput")
    public Button getBtnshinsakekkakanryooutput() {
        return btnshinsakekkakanryooutput;
    }

    /*
     * setbtnshinsakekkakanryooutput
     * @param btnshinsakekkakanryooutput btnshinsakekkakanryooutput
     */
    @JsonProperty("btnshinsakekkakanryooutput")
    public void setBtnshinsakekkakanryooutput(Button btnshinsakekkakanryooutput) {
        this.btnshinsakekkakanryooutput = btnshinsakekkakanryooutput;
    }

    /*
     * gethiddenbtnshinsakekkakanryooutput
     * @return hiddenbtnshinsakekkakanryooutput
     */
    @JsonProperty("hiddenbtnshinsakekkakanryooutput")
    public ButtonDownLoad getHiddenbtnshinsakekkakanryooutput() {
        return hiddenbtnshinsakekkakanryooutput;
    }

    /*
     * sethiddenbtnshinsakekkakanryooutput
     * @param hiddenbtnshinsakekkakanryooutput hiddenbtnshinsakekkakanryooutput
     */
    @JsonProperty("hiddenbtnshinsakekkakanryooutput")
    public void setHiddenbtnshinsakekkakanryooutput(ButtonDownLoad hiddenbtnshinsakekkakanryooutput) {
        this.hiddenbtnshinsakekkakanryooutput = hiddenbtnshinsakekkakanryooutput;
    }

    // </editor-fold>
}
