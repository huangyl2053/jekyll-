package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * HokenryoRitsuDai4DankaiFrom2008To2010 のクラスファイル
 *
 * @reamsid_L DBB-1770-010 wangkanglei
 */
public class HokenryoRitsuDai4DankaiFrom2008To2010Div extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHokenryoRitsuDai4Dankai")
    private TextBoxNum txtHokenryoRitsuDai4Dankai;
    @JsonProperty("GekihenKanwa")
    private GekihenKanwaDiv GekihenKanwa;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHokenryoRitsuDai4Dankai
     * @return txtHokenryoRitsuDai4Dankai
     */
    @JsonProperty("txtHokenryoRitsuDai4Dankai")
    public TextBoxNum getTxtHokenryoRitsuDai4Dankai() {
        return txtHokenryoRitsuDai4Dankai;
    }

    /*
     * settxtHokenryoRitsuDai4Dankai
     * @param txtHokenryoRitsuDai4Dankai txtHokenryoRitsuDai4Dankai
     */
    @JsonProperty("txtHokenryoRitsuDai4Dankai")
    public void setTxtHokenryoRitsuDai4Dankai(TextBoxNum txtHokenryoRitsuDai4Dankai) {
        this.txtHokenryoRitsuDai4Dankai = txtHokenryoRitsuDai4Dankai;
    }

    /*
     * getGekihenKanwa
     * @return GekihenKanwa
     */
    @JsonProperty("GekihenKanwa")
    public GekihenKanwaDiv getGekihenKanwa() {
        return GekihenKanwa;
    }

    /*
     * setGekihenKanwa
     * @param GekihenKanwa GekihenKanwa
     */
    @JsonProperty("GekihenKanwa")
    public void setGekihenKanwa(GekihenKanwaDiv GekihenKanwa) {
        this.GekihenKanwa = GekihenKanwa;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ButtonDialog getBtnGekihenKanwa() {
        return this.getGekihenKanwa().getBtnGekihenKanwa();
    }

    @JsonIgnore
    public void setBtnGekihenKanwa(ButtonDialog btnGekihenKanwa) {
        this.getGekihenKanwa().setBtnGekihenKanwa(btnGekihenKanwa);
    }

    // </editor-fold>
}
