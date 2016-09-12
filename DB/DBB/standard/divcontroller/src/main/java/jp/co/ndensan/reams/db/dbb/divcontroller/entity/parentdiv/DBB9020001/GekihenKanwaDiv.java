package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * GekihenKanwa のクラスファイル
 *
 * @reamsid_L DBB-1770-010 wangkanglei
 */
public class GekihenKanwaDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnGekihenKanwa")
    private ButtonDialog btnGekihenKanwa;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnGekihenKanwa
     * @return btnGekihenKanwa
     */
    @JsonProperty("btnGekihenKanwa")
    public ButtonDialog getBtnGekihenKanwa() {
        return btnGekihenKanwa;
    }

    /*
     * setbtnGekihenKanwa
     * @param btnGekihenKanwa btnGekihenKanwa
     */
    @JsonProperty("btnGekihenKanwa")
    public void setBtnGekihenKanwa(ButtonDialog btnGekihenKanwa) {
        this.btnGekihenKanwa = btnGekihenKanwa;
    }

    // </editor-fold>
}
