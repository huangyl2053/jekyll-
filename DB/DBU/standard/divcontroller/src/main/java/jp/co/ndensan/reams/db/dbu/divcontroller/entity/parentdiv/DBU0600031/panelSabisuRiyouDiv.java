package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600031;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * panelSabisuRiyou のクラスファイル 
 * 
 * @author 自動生成
 */
public class panelSabisuRiyouDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSaishinSabisu")
    private TextBox txtSaishinSabisu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtSaishinSabisu
     * @return txtSaishinSabisu
     */
    @JsonProperty("txtSaishinSabisu")
    public TextBox getTxtSaishinSabisu() {
        return txtSaishinSabisu;
    }

    /*
     * settxtSaishinSabisu
     * @param txtSaishinSabisu txtSaishinSabisu
     */
    @JsonProperty("txtSaishinSabisu")
    public void setTxtSaishinSabisu(TextBox txtSaishinSabisu) {
        this.txtSaishinSabisu = txtSaishinSabisu;
    }

    // </editor-fold>
}
