package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;

/**
 * panelServiceKikan のクラスファイル
 *
 * @reamsid_L DBC-1030-020 wangkanglei
 */
public class panelServiceKikanDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtServiceKikan")
    private TextBoxDateRange txtServiceKikan;
    @JsonProperty("ddlCyushiRiyu")
    private DropDownList ddlCyushiRiyu;

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
     * getddlCyushiRiyu
     * @return ddlCyushiRiyu
     */
    @JsonProperty("ddlCyushiRiyu")
    public DropDownList getDdlCyushiRiyu() {
        return ddlCyushiRiyu;
    }

    /*
     * setddlCyushiRiyu
     * @param ddlCyushiRiyu ddlCyushiRiyu
     */
    @JsonProperty("ddlCyushiRiyu")
    public void setDdlCyushiRiyu(DropDownList ddlCyushiRiyu) {
        this.ddlCyushiRiyu = ddlCyushiRiyu;
    }

    // </editor-fold>
}
