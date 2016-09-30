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
 * SakuseiDate5 のクラスファイル 
 * 
 * @author 自動生成
 */
public class SakuseiDate5Div extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSakuseiYMD5")
    private TextBoxFlexibleDate txtSakuseiYMD5;
    @JsonProperty("txtSakuseiTime5")
    private TextBoxTime txtSakuseiTime5;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtSakuseiYMD5
     * @return txtSakuseiYMD5
     */
    @JsonProperty("txtSakuseiYMD5")
    public TextBoxFlexibleDate getTxtSakuseiYMD5() {
        return txtSakuseiYMD5;
    }

    /*
     * settxtSakuseiYMD5
     * @param txtSakuseiYMD5 txtSakuseiYMD5
     */
    @JsonProperty("txtSakuseiYMD5")
    public void setTxtSakuseiYMD5(TextBoxFlexibleDate txtSakuseiYMD5) {
        this.txtSakuseiYMD5 = txtSakuseiYMD5;
    }

    /*
     * gettxtSakuseiTime5
     * @return txtSakuseiTime5
     */
    @JsonProperty("txtSakuseiTime5")
    public TextBoxTime getTxtSakuseiTime5() {
        return txtSakuseiTime5;
    }

    /*
     * settxtSakuseiTime5
     * @param txtSakuseiTime5 txtSakuseiTime5
     */
    @JsonProperty("txtSakuseiTime5")
    public void setTxtSakuseiTime5(TextBoxTime txtSakuseiTime5) {
        this.txtSakuseiTime5 = txtSakuseiTime5;
    }

    // </editor-fold>
}
