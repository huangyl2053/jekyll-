package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5150011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.Space;

/**
 * ShutsuryokuTaisho のクラスファイル
 *
 * @reamsid_L DBC-3310-010 chenyadong
 */
public class ShutsuryokuTaishoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkShutsuryokuTaisho")
    private CheckBoxList chkShutsuryokuTaisho;
    @JsonProperty("ShutsuryokuTaisoDetail")
    private ShutsuryokuTaisoDetailDiv ShutsuryokuTaisoDetail;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkShutsuryokuTaisho
     * @return chkShutsuryokuTaisho
     */
    @JsonProperty("chkShutsuryokuTaisho")
    public CheckBoxList getChkShutsuryokuTaisho() {
        return chkShutsuryokuTaisho;
    }

    /*
     * setchkShutsuryokuTaisho
     * @param chkShutsuryokuTaisho chkShutsuryokuTaisho
     */
    @JsonProperty("chkShutsuryokuTaisho")
    public void setChkShutsuryokuTaisho(CheckBoxList chkShutsuryokuTaisho) {
        this.chkShutsuryokuTaisho = chkShutsuryokuTaisho;
    }

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
    public Space getSpa1() {
        return this.getShutsuryokuTaisoDetail().getSpa1();
    }

    @JsonIgnore
    public void setSpa1(Space spa1) {
        this.getShutsuryokuTaisoDetail().setSpa1(spa1);
    }

    @JsonIgnore
    public CheckBoxList getChkMeisaiCsvEdit() {
        return this.getShutsuryokuTaisoDetail().getChkMeisaiCsvEdit();
    }

    @JsonIgnore
    public void setChkMeisaiCsvEdit(CheckBoxList chkMeisaiCsvEdit) {
        this.getShutsuryokuTaisoDetail().setChkMeisaiCsvEdit(chkMeisaiCsvEdit);
    }

    // </editor-fold>
}
