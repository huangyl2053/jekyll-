package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0040011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SakuseiDate6 のクラスファイル 
 * 
 * @author 自動生成
 */
public class SakuseiDate6Div extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSakuseiYMD6")
    private TextBoxFlexibleDate txtSakuseiYMD6;
    @JsonProperty("txtSakuseiTime6")
    private TextBoxTime txtSakuseiTime6;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtSakuseiYMD6
     * @return txtSakuseiYMD6
     */
    @JsonProperty("txtSakuseiYMD6")
    public TextBoxFlexibleDate getTxtSakuseiYMD6() {
        return txtSakuseiYMD6;
    }

    /*
     * settxtSakuseiYMD6
     * @param txtSakuseiYMD6 txtSakuseiYMD6
     */
    @JsonProperty("txtSakuseiYMD6")
    public void setTxtSakuseiYMD6(TextBoxFlexibleDate txtSakuseiYMD6) {
        this.txtSakuseiYMD6 = txtSakuseiYMD6;
    }

    /*
     * gettxtSakuseiTime6
     * @return txtSakuseiTime6
     */
    @JsonProperty("txtSakuseiTime6")
    public TextBoxTime getTxtSakuseiTime6() {
        return txtSakuseiTime6;
    }

    /*
     * settxtSakuseiTime6
     * @param txtSakuseiTime6 txtSakuseiTime6
     */
    @JsonProperty("txtSakuseiTime6")
    public void setTxtSakuseiTime6(TextBoxTime txtSakuseiTime6) {
        this.txtSakuseiTime6 = txtSakuseiTime6;
    }

    // </editor-fold>
}
