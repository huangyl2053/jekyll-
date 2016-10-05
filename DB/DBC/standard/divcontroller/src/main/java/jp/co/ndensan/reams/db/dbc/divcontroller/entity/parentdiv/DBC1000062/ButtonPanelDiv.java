package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1000062;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ButtonPanel のクラスファイル
 *
 * @reamsid_L DBC-4620-010 wangkanglei
 */
public class ButtonPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnSetaiSaiSanshutsu")
    private Button btnSetaiSaiSanshutsu;
    @JsonProperty("btnKojoSaiSanshutsu")
    private Button btnKojoSaiSanshutsu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnSetaiSaiSanshutsu
     * @return btnSetaiSaiSanshutsu
     */
    @JsonProperty("btnSetaiSaiSanshutsu")
    public Button getBtnSetaiSaiSanshutsu() {
        return btnSetaiSaiSanshutsu;
    }

    /*
     * setbtnSetaiSaiSanshutsu
     * @param btnSetaiSaiSanshutsu btnSetaiSaiSanshutsu
     */
    @JsonProperty("btnSetaiSaiSanshutsu")
    public void setBtnSetaiSaiSanshutsu(Button btnSetaiSaiSanshutsu) {
        this.btnSetaiSaiSanshutsu = btnSetaiSaiSanshutsu;
    }

    /*
     * getbtnKojoSaiSanshutsu
     * @return btnKojoSaiSanshutsu
     */
    @JsonProperty("btnKojoSaiSanshutsu")
    public Button getBtnKojoSaiSanshutsu() {
        return btnKojoSaiSanshutsu;
    }

    /*
     * setbtnKojoSaiSanshutsu
     * @param btnKojoSaiSanshutsu btnKojoSaiSanshutsu
     */
    @JsonProperty("btnKojoSaiSanshutsu")
    public void setBtnKojoSaiSanshutsu(Button btnKojoSaiSanshutsu) {
        this.btnKojoSaiSanshutsu = btnKojoSaiSanshutsu;
    }

    // </editor-fold>
}
