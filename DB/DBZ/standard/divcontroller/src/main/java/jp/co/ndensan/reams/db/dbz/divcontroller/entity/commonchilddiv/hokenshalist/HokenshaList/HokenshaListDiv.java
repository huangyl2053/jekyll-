package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaSummary;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;

/**
 * HokenshaList のクラスファイル
 *
 * @author 自動生成
 */
public class HokenshaListDiv extends Panel implements IHokenshaListDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
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
        this.loadHokenshaList(GyomuBunrui.介護事務);
    }

    @Override
    public HokenshaSummary getSelectedItem() {
        return this.createHandler().getSelectedItemAsHokenshaSummary();
    }

    private HokenshaListDivHandler createHandler() {
        return new HokenshaListDivHandler(this);
    }

    @Override
    public void loadHokenshaList(GyomuBunrui 業務分類) {
        this.createHandler().loadAndHoldHokenshaList(Objects.requireNonNull(業務分類));
        if (!this.ddlHokenshaList.getDataSource().isEmpty()) {
            this.ddlHokenshaList.setSelectedIndex(0);
        }
    }

    @Override
    public void setSelectedShichosonIfExist(LasdecCode 市町村コード) {
        this.createHandler().setSelectedShichsonIfExist(市町村コード);
    }
}
