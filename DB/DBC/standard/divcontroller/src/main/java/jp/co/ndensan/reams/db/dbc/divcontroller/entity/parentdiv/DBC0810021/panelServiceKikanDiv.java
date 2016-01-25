package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * panelServiceKikan のクラスファイル 
 * 
 * @author 自動生成
 */
public class panelServiceKikanDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-16_12-38-19">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtServiceKikan")
    private TextBoxDateRange txtServiceKikan;
    @JsonProperty("txtCyushiRiyu")
    private TextBox txtCyushiRiyu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtServiceKikan
     * @return txtServiceKikan
     */
    @JsonProperty("txtServiceKikan")
    public TextBoxDateRange getTxtServiceKikan() {
        return txtServiceKikan;
    }

    /*
     * settxtServiceKikan
     * @param txtServiceKikan txtServiceKikan
     */
    @JsonProperty("txtServiceKikan")
    public void setTxtServiceKikan(TextBoxDateRange txtServiceKikan) {
        this.txtServiceKikan = txtServiceKikan;
    }

    /*
     * gettxtCyushiRiyu
     * @return txtCyushiRiyu
     */
    @JsonProperty("txtCyushiRiyu")
    public TextBox getTxtCyushiRiyu() {
        return txtCyushiRiyu;
    }

    /*
     * settxtCyushiRiyu
     * @param txtCyushiRiyu txtCyushiRiyu
     */
    @JsonProperty("txtCyushiRiyu")
    public void setTxtCyushiRiyu(TextBox txtCyushiRiyu) {
        this.txtCyushiRiyu = txtCyushiRiyu;
    }

    // </editor-fold>
}
