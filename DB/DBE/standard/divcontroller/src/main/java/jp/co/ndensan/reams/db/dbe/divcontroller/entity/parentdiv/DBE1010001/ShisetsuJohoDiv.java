package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;

/**
 * ShisetsuJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShisetsuJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtNyushoShisetsu")
    private TextBox txtNyushoShisetsu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtNyushoShisetsu
     * @return txtNyushoShisetsu
     */
    @JsonProperty("txtNyushoShisetsu")
    public TextBox getTxtNyushoShisetsu() {
        return txtNyushoShisetsu;
    }

    /*
     * settxtNyushoShisetsu
     * @param txtNyushoShisetsu txtNyushoShisetsu
     */
    @JsonProperty("txtNyushoShisetsu")
    public void setTxtNyushoShisetsu(TextBox txtNyushoShisetsu) {
        this.txtNyushoShisetsu = txtNyushoShisetsu;
    }

    // </editor-fold>
}
