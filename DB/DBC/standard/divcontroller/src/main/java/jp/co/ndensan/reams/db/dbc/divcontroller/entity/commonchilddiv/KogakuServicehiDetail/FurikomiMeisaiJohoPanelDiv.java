package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuServicehiDetail;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * FurikomiMeisaiJohoPanel のクラスファイル
 *
 * @reamsid_L DBC-4380-010 quxiaodong
 */
public class FurikomiMeisaiJohoPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSakuseiYMD2")
    private TextBoxDate txtSakuseiYMD2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtSakuseiYMD2
     * @return txtSakuseiYMD2
     */
    @JsonProperty("txtSakuseiYMD2")
    public TextBoxDate getTxtSakuseiYMD2() {
        return txtSakuseiYMD2;
    }

    /*
     * settxtSakuseiYMD2
     * @param txtSakuseiYMD2 txtSakuseiYMD2
     */
    @JsonProperty("txtSakuseiYMD2")
    public void setTxtSakuseiYMD2(TextBoxDate txtSakuseiYMD2) {
        this.txtSakuseiYMD2 = txtSakuseiYMD2;
    }

    // </editor-fold>
}
