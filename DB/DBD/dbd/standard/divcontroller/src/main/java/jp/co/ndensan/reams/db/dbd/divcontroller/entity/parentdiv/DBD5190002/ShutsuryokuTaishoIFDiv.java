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
 * ShutsuryokuTaishoIF のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShutsuryokuTaishoIFDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShutsuryokuFile")
    private ShutsuryokuFileDiv ShutsuryokuFile;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShutsuryokuFile
     * @return ShutsuryokuFile
     */
    @JsonProperty("ShutsuryokuFile")
    public ShutsuryokuFileDiv getShutsuryokuFile() {
        return ShutsuryokuFile;
    }

    /*
     * setShutsuryokuFile
     * @param ShutsuryokuFile ShutsuryokuFile
     */
    @JsonProperty("ShutsuryokuFile")
    public void setShutsuryokuFile(ShutsuryokuFileDiv ShutsuryokuFile) {
        this.ShutsuryokuFile = ShutsuryokuFile;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadIfShubetu() {
        return this.getShutsuryokuFile().getRadIfShubetu();
    }

    @JsonIgnore
    public void  setRadIfShubetu(RadioButton radIfShubetu) {
        this.getShutsuryokuFile().setRadIfShubetu(radIfShubetu);
    }

    @JsonIgnore
    public DropDownList getDropDownListChosaItakusakiFileName() {
        return this.getShutsuryokuFile().getDropDownListChosaItakusakiFileName();
    }

    @JsonIgnore
    public void  setDropDownListChosaItakusakiFileName(DropDownList DropDownListChosaItakusakiFileName) {
        this.getShutsuryokuFile().setDropDownListChosaItakusakiFileName(DropDownListChosaItakusakiFileName);
    }

    @JsonIgnore
    public DropDownList getDropDownListChosainFileName() {
        return this.getShutsuryokuFile().getDropDownListChosainFileName();
    }

    @JsonIgnore
    public void  setDropDownListChosainFileName(DropDownList DropDownListChosainFileName) {
        this.getShutsuryokuFile().setDropDownListChosainFileName(DropDownListChosainFileName);
    }

    @JsonIgnore
    public DropDownList getDropDownListShujiiIryoKikanFileName() {
        return this.getShutsuryokuFile().getDropDownListShujiiIryoKikanFileName();
    }

    @JsonIgnore
    public void  setDropDownListShujiiIryoKikanFileName(DropDownList DropDownListShujiiIryoKikanFileName) {
        this.getShutsuryokuFile().setDropDownListShujiiIryoKikanFileName(DropDownListShujiiIryoKikanFileName);
    }

    @JsonIgnore
    public DropDownList getDropDownListShujiiFileName() {
        return this.getShutsuryokuFile().getDropDownListShujiiFileName();
    }

    @JsonIgnore
    public void  setDropDownListShujiiFileName(DropDownList DropDownListShujiiFileName) {
        this.getShutsuryokuFile().setDropDownListShujiiFileName(DropDownListShujiiFileName);
    }

    // </editor-fold>
}
