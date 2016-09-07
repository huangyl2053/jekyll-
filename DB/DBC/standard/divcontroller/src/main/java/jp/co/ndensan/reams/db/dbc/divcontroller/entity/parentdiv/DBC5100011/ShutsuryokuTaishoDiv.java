package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5100011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShutsuryokuTaisho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShutsuryokuTaishoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
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
    public Space getSpc01() {
        return this.getShutsuryokuTaisoDetail().getSpc01();
    }

    @JsonIgnore
    public void  setSpc01(Space spc01) {
        this.getShutsuryokuTaisoDetail().setSpc01(spc01);
    }

    @JsonIgnore
    public RadioButton getRadMeisaiGokeiOut() {
        return this.getShutsuryokuTaisoDetail().getRadMeisaiGokeiOut();
    }

    @JsonIgnore
    public void  setRadMeisaiGokeiOut(RadioButton radMeisaiGokeiOut) {
        this.getShutsuryokuTaisoDetail().setRadMeisaiGokeiOut(radMeisaiGokeiOut);
    }

    @JsonIgnore
    public CheckBoxList getChkMeisaiCsvEdit() {
        return this.getShutsuryokuTaisoDetail().getChkMeisaiCsvEdit();
    }

    @JsonIgnore
    public void  setChkMeisaiCsvEdit(CheckBoxList chkMeisaiCsvEdit) {
        this.getShutsuryokuTaisoDetail().setChkMeisaiCsvEdit(chkMeisaiCsvEdit);
    }

    // </editor-fold>
}
