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
 * HokenryoRitsuDai3Dankai のクラスファイル
 *
 * @reamsid_L DBB-1770-010 wangkanglei
 */
public class HokenryoRitsuDai3DankaiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHokenryoRitsuDai3Dankai")
    private TextBoxNum txtHokenryoRitsuDai3Dankai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHokenryoRitsuDai3Dankai
     * @return txtHokenryoRitsuDai3Dankai
     */
    @JsonProperty("txtHokenryoRitsuDai3Dankai")
    public TextBoxNum getTxtHokenryoRitsuDai3Dankai() {
        return txtHokenryoRitsuDai3Dankai;
    }

    /*
     * settxtHokenryoRitsuDai3Dankai
     * @param txtHokenryoRitsuDai3Dankai txtHokenryoRitsuDai3Dankai
     */
    @JsonProperty("txtHokenryoRitsuDai3Dankai")
    public void setTxtHokenryoRitsuDai3Dankai(TextBoxNum txtHokenryoRitsuDai3Dankai) {
        this.txtHokenryoRitsuDai3Dankai = txtHokenryoRitsuDai3Dankai;
    }

    // </editor-fold>
}
