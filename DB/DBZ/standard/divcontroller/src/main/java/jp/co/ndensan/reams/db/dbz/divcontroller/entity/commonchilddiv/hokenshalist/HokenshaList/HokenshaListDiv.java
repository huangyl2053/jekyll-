package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonlist.ShichosonCodeNameResult;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HokenshaList のクラスファイル
 *
 * @author 自動生成
 */
public class HokenshaListDiv extends Panel implements IHokenshaListDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlHokenshaList")
    private DropDownList ddlHokenshaList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlHokenshaList
     * @return ddlHokenshaList
     */
    @JsonProperty("ddlHokenshaList")
    public DropDownList getDdlHokenshaList() {
        return ddlHokenshaList;
    }

    /*
     * setddlHokenshaList
     * @param ddlHokenshaList ddlHokenshaList
     */
    @JsonProperty("ddlHokenshaList")
    public void setDdlHokenshaList(DropDownList ddlHokenshaList) {
        this.ddlHokenshaList = ddlHokenshaList;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void loadHokenshaList() {
        this.createHandler().loadAndHoldHokenshaList();
        if (!this.ddlHokenshaList.getDataSource().isEmpty()) {
            this.ddlHokenshaList.setSelectedIndex(0);
        }
    }

    @Override
    public ShichosonCodeNameResult getSelectedItem() {
        return this.createHandler().getSelectedItemAsShichosonCodeNameResult();
    }

    private HokenshaListDivHandler createHandler() {
        return new HokenshaListDivHandler(this);
    }
}
