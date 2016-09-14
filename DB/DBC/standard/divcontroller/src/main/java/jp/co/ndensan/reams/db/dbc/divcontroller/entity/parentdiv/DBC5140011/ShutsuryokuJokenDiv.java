package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5140011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShutsuryokuJoken のクラスファイル
 *
 * @reamsid_L DBC-3330-010 lihang
 */
public class ShutsuryokuJokenDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShutsuryokuTaisoDetail")
    private ShutsuryokuTaisoDetailDiv ShutsuryokuTaisoDetail;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShutsuryokuTaisoDetail
     * @return ShutsuryokuTaisoDetail
     */
    @JsonProperty("ShutsuryokuTaisoDetail")
    public ShutsuryokuTaisoDetailDiv getShutsuryokuTaisoDetail() {
        return ShutsuryokuTaisoDetail;
    }

    /*
     * setShutsuryokuTaisoDetail
     * @param ShutsuryokuTaisoDetail ShutsuryokuTaisoDetail
     */
    @JsonProperty("ShutsuryokuTaisoDetail")
    public void setShutsuryokuTaisoDetail(ShutsuryokuTaisoDetailDiv ShutsuryokuTaisoDetail) {
        this.ShutsuryokuTaisoDetail = ShutsuryokuTaisoDetail;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public CheckBoxList getChkCsvEdit() {
        return this.getShutsuryokuTaisoDetail().getChkCsvEdit();
    }

    @JsonIgnore
    public void setChkCsvEdit(CheckBoxList chkCsvEdit) {
        this.getShutsuryokuTaisoDetail().setChkCsvEdit(chkCsvEdit);
    }

    // </editor-fold>
}
