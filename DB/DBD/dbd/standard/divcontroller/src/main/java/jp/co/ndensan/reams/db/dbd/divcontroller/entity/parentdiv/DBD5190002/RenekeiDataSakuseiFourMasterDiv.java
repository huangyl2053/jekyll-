package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5190002;
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
 * RenekeiDataSakuseiFourMaster のクラスファイル 
 * 
 * @author 自動生成
 */
public class RenekeiDataSakuseiFourMasterDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ChushutsuJoken")
    private ChushutsuJokenDiv ChushutsuJoken;
    @JsonProperty("ShutsuryokuTaishoIF")
    private ShutsuryokuTaishoIFDiv ShutsuryokuTaishoIF;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getChushutsuJoken
     * @return ChushutsuJoken
     */
    @JsonProperty("ChushutsuJoken")
    public ChushutsuJokenDiv getChushutsuJoken() {
        return ChushutsuJoken;
    }

    /*
     * setChushutsuJoken
     * @param ChushutsuJoken ChushutsuJoken
     */
    @JsonProperty("ChushutsuJoken")
    public void setChushutsuJoken(ChushutsuJokenDiv ChushutsuJoken) {
        this.ChushutsuJoken = ChushutsuJoken;
    }

    /*
     * getShutsuryokuTaishoIF
     * @return ShutsuryokuTaishoIF
     */
    @JsonProperty("ShutsuryokuTaishoIF")
    public ShutsuryokuTaishoIFDiv getShutsuryokuTaishoIF() {
        return ShutsuryokuTaishoIF;
    }

    /*
     * setShutsuryokuTaishoIF
     * @param ShutsuryokuTaishoIF ShutsuryokuTaishoIF
     */
    @JsonProperty("ShutsuryokuTaishoIF")
    public void setShutsuryokuTaishoIF(ShutsuryokuTaishoIFDiv ShutsuryokuTaishoIF) {
        this.ShutsuryokuTaishoIF = ShutsuryokuTaishoIF;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadChushutsuJoken() {
        return this.getChushutsuJoken().getRadChushutsuJoken();
    }

    @JsonIgnore
    public void  setRadChushutsuJoken(RadioButton radChushutsuJoken) {
        this.getChushutsuJoken().setRadChushutsuJoken(radChushutsuJoken);
    }

    @JsonIgnore
    public TextBoxDateTimeRange getTxtzenkaishoriymdtime() {
        return this.getChushutsuJoken().getTxtzenkaishoriymdtime();
    }

    @JsonIgnore
    public void  setTxtzenkaishoriymdtime(TextBoxDateTimeRange txtzenkaishoriymdtime) {
        this.getChushutsuJoken().setTxtzenkaishoriymdtime(txtzenkaishoriymdtime);
    }

    @JsonIgnore
    public TextBoxDateTimeRange getTxtkonkaishoriymdtime() {
        return this.getChushutsuJoken().getTxtkonkaishoriymdtime();
    }

    @JsonIgnore
    public void  setTxtkonkaishoriymdtime(TextBoxDateTimeRange txtkonkaishoriymdtime) {
        this.getChushutsuJoken().setTxtkonkaishoriymdtime(txtkonkaishoriymdtime);
    }

    @JsonIgnore
    public ShutsuryokuFileDiv getShutsuryokuFile() {
        return this.getShutsuryokuTaishoIF().getShutsuryokuFile();
    }

    @JsonIgnore
    public void  setShutsuryokuFile(ShutsuryokuFileDiv ShutsuryokuFile) {
        this.getShutsuryokuTaishoIF().setShutsuryokuFile(ShutsuryokuFile);
    }

    @JsonIgnore
    public RadioButton getRadIfShubetu() {
        return this.getShutsuryokuTaishoIF().getShutsuryokuFile().getRadIfShubetu();
    }

    @JsonIgnore
    public void  setRadIfShubetu(RadioButton radIfShubetu) {
        this.getShutsuryokuTaishoIF().getShutsuryokuFile().setRadIfShubetu(radIfShubetu);
    }

    @JsonIgnore
    public DropDownList getDropDownListChosaItakusakiFileName() {
        return this.getShutsuryokuTaishoIF().getShutsuryokuFile().getDropDownListChosaItakusakiFileName();
    }

    @JsonIgnore
    public void  setDropDownListChosaItakusakiFileName(DropDownList DropDownListChosaItakusakiFileName) {
        this.getShutsuryokuTaishoIF().getShutsuryokuFile().setDropDownListChosaItakusakiFileName(DropDownListChosaItakusakiFileName);
    }

    @JsonIgnore
    public DropDownList getDropDownListChosainFileName() {
        return this.getShutsuryokuTaishoIF().getShutsuryokuFile().getDropDownListChosainFileName();
    }

    @JsonIgnore
    public void  setDropDownListChosainFileName(DropDownList DropDownListChosainFileName) {
        this.getShutsuryokuTaishoIF().getShutsuryokuFile().setDropDownListChosainFileName(DropDownListChosainFileName);
    }

    @JsonIgnore
    public DropDownList getDropDownListShujiiIryoKikanFileName() {
        return this.getShutsuryokuTaishoIF().getShutsuryokuFile().getDropDownListShujiiIryoKikanFileName();
    }

    @JsonIgnore
    public void  setDropDownListShujiiIryoKikanFileName(DropDownList DropDownListShujiiIryoKikanFileName) {
        this.getShutsuryokuTaishoIF().getShutsuryokuFile().setDropDownListShujiiIryoKikanFileName(DropDownListShujiiIryoKikanFileName);
    }

    @JsonIgnore
    public DropDownList getDropDownListShujiiFileName() {
        return this.getShutsuryokuTaishoIF().getShutsuryokuFile().getDropDownListShujiiFileName();
    }

    @JsonIgnore
    public void  setDropDownListShujiiFileName(DropDownList DropDownListShujiiFileName) {
        this.getShutsuryokuTaishoIF().getShutsuryokuFile().setDropDownListShujiiFileName(DropDownListShujiiFileName);
    }

    // </editor-fold>
}
