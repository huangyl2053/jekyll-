package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8110001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * WrapFukadaichoKobetsu のクラスファイル
 *
 * @reamsid_L DBB-0740-010 wangkanglei
 */
public class WrapFukadaichoKobetsuDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkPublishFukadaichoKobetsu")
    private CheckBoxList chkPublishFukadaichoKobetsu;
    @JsonProperty("lblFukadaichoKobetsu")
    private Label lblFukadaichoKobetsu;
    @JsonProperty("FukadaichoKobetsu")
    private FukadaichoKobetsuDiv FukadaichoKobetsu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkPublishFukadaichoKobetsu
     * @return chkPublishFukadaichoKobetsu
     */
    @JsonProperty("chkPublishFukadaichoKobetsu")
    public CheckBoxList getChkPublishFukadaichoKobetsu() {
        return chkPublishFukadaichoKobetsu;
    }

    /*
     * setchkPublishFukadaichoKobetsu
     * @param chkPublishFukadaichoKobetsu chkPublishFukadaichoKobetsu
     */
    @JsonProperty("chkPublishFukadaichoKobetsu")
    public void setChkPublishFukadaichoKobetsu(CheckBoxList chkPublishFukadaichoKobetsu) {
        this.chkPublishFukadaichoKobetsu = chkPublishFukadaichoKobetsu;
    }

    /*
     * getlblFukadaichoKobetsu
     * @return lblFukadaichoKobetsu
     */
    @JsonProperty("lblFukadaichoKobetsu")
    public Label getLblFukadaichoKobetsu() {
        return lblFukadaichoKobetsu;
    }

    /*
     * setlblFukadaichoKobetsu
     * @param lblFukadaichoKobetsu lblFukadaichoKobetsu
     */
    @JsonProperty("lblFukadaichoKobetsu")
    public void setLblFukadaichoKobetsu(Label lblFukadaichoKobetsu) {
        this.lblFukadaichoKobetsu = lblFukadaichoKobetsu;
    }

    /*
     * getFukadaichoKobetsu
     * @return FukadaichoKobetsu
     */
    @JsonProperty("FukadaichoKobetsu")
    public FukadaichoKobetsuDiv getFukadaichoKobetsu() {
        return FukadaichoKobetsu;
    }

    /*
     * setFukadaichoKobetsu
     * @param FukadaichoKobetsu FukadaichoKobetsu
     */
    @JsonProperty("FukadaichoKobetsu")
    public void setFukadaichoKobetsu(FukadaichoKobetsuDiv FukadaichoKobetsu) {
        this.FukadaichoKobetsu = FukadaichoKobetsu;
    }

    // </editor-fold>
}
