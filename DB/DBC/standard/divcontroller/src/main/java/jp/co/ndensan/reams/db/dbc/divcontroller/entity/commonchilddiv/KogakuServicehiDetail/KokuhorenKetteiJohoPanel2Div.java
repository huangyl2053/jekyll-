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
 * KokuhorenKetteiJohoPanel2 のクラスファイル
 *
 * @reamsid_L DBC-4380-010 quxiaodong
 */
public class KokuhorenKetteiJohoPanel2Div extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSakuseiYMD1")
    private TextBoxDate txtSakuseiYMD1;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtSakuseiYMD1
     * @return txtSakuseiYMD1
     */
    @JsonProperty("txtSakuseiYMD1")
    public TextBoxDate getTxtSakuseiYMD1() {
        return txtSakuseiYMD1;
    }

    /*
     * settxtSakuseiYMD1
     * @param txtSakuseiYMD1 txtSakuseiYMD1
     */
    @JsonProperty("txtSakuseiYMD1")
    public void setTxtSakuseiYMD1(TextBoxDate txtSakuseiYMD1) {
        this.txtSakuseiYMD1 = txtSakuseiYMD1;
    }

    // </editor-fold>
}
