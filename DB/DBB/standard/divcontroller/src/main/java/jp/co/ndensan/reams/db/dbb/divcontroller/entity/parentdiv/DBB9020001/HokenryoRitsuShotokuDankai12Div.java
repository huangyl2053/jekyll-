package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * HokenryoRitsuShotokuDankai12 のクラスファイル
 *
 * @reamsid_L DBB-1770-010 wangkanglei
 */
public class HokenryoRitsuShotokuDankai12Div extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHokenryoRitsuDai1Dankai")
    private TextBoxNum txtHokenryoRitsuDai1Dankai;
    @JsonProperty("txtHokenryoRitsuDai2Dankai")
    private TextBoxNum txtHokenryoRitsuDai2Dankai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHokenryoRitsuDai1Dankai
     * @return txtHokenryoRitsuDai1Dankai
     */
    @JsonProperty("txtHokenryoRitsuDai1Dankai")
    public TextBoxNum getTxtHokenryoRitsuDai1Dankai() {
        return txtHokenryoRitsuDai1Dankai;
    }

    /*
     * settxtHokenryoRitsuDai1Dankai
     * @param txtHokenryoRitsuDai1Dankai txtHokenryoRitsuDai1Dankai
     */
    @JsonProperty("txtHokenryoRitsuDai1Dankai")
    public void setTxtHokenryoRitsuDai1Dankai(TextBoxNum txtHokenryoRitsuDai1Dankai) {
        this.txtHokenryoRitsuDai1Dankai = txtHokenryoRitsuDai1Dankai;
    }

    /*
     * gettxtHokenryoRitsuDai2Dankai
     * @return txtHokenryoRitsuDai2Dankai
     */
    @JsonProperty("txtHokenryoRitsuDai2Dankai")
    public TextBoxNum getTxtHokenryoRitsuDai2Dankai() {
        return txtHokenryoRitsuDai2Dankai;
    }

    /*
     * settxtHokenryoRitsuDai2Dankai
     * @param txtHokenryoRitsuDai2Dankai txtHokenryoRitsuDai2Dankai
     */
    @JsonProperty("txtHokenryoRitsuDai2Dankai")
    public void setTxtHokenryoRitsuDai2Dankai(TextBoxNum txtHokenryoRitsuDai2Dankai) {
        this.txtHokenryoRitsuDai2Dankai = txtHokenryoRitsuDai2Dankai;
    }

    // </editor-fold>
}
