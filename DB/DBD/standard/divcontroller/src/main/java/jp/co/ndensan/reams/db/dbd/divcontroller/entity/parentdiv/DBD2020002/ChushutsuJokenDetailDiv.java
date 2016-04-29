package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2020002;
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
 * ChushutsuJokenDetail のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChushutsuJokenDetailDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radTorokusha")
    private RadioButton radTorokusha;
    @JsonProperty("TorokushaJoken")
    private TorokushaJokenDiv TorokushaJoken;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradTorokusha
     * @return radTorokusha
     */
    @JsonProperty("radTorokusha")
    public RadioButton getRadTorokusha() {
        return radTorokusha;
    }

    /*
     * setradTorokusha
     * @param radTorokusha radTorokusha
     */
    @JsonProperty("radTorokusha")
    public void setRadTorokusha(RadioButton radTorokusha) {
        this.radTorokusha = radTorokusha;
    }

    /*
     * getTorokushaJoken
     * @return TorokushaJoken
     */
    @JsonProperty("TorokushaJoken")
    public TorokushaJokenDiv getTorokushaJoken() {
        return TorokushaJoken;
    }

    /*
     * setTorokushaJoken
     * @param TorokushaJoken TorokushaJoken
     */
    @JsonProperty("TorokushaJoken")
    public void setTorokushaJoken(TorokushaJokenDiv TorokushaJoken) {
        this.TorokushaJoken = TorokushaJoken;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdl2GoSashitomeYokoku() {
        return this.getTorokushaJoken().getDdl2GoSashitomeYokoku();
    }

    @JsonIgnore
    public void  setDdl2GoSashitomeYokoku(DropDownList ddl2GoSashitomeYokoku) {
        this.getTorokushaJoken().setDdl2GoSashitomeYokoku(ddl2GoSashitomeYokoku);
    }

    @JsonIgnore
    public DropDownList getDdlGoSashitomeToroku() {
        return this.getTorokushaJoken().getDdlGoSashitomeToroku();
    }

    @JsonIgnore
    public void  setDdlGoSashitomeToroku(DropDownList ddlGoSashitomeToroku) {
        this.getTorokushaJoken().setDdlGoSashitomeToroku(ddlGoSashitomeToroku);
    }

    @JsonIgnore
    public DropDownList getDdl2GoShokanYokoku() {
        return this.getTorokushaJoken().getDdl2GoShokanYokoku();
    }

    @JsonIgnore
    public void  setDdl2GoShokanYokoku(DropDownList ddl2GoShokanYokoku) {
        this.getTorokushaJoken().setDdl2GoShokanYokoku(ddl2GoShokanYokoku);
    }

    @JsonIgnore
    public DropDownList getDdl1GoShokanKettei() {
        return this.getTorokushaJoken().getDdl1GoShokanKettei();
    }

    @JsonIgnore
    public void  setDdl1GoShokanKettei(DropDownList ddl1GoShokanKettei) {
        this.getTorokushaJoken().setDdl1GoShokanKettei(ddl1GoShokanKettei);
    }

    @JsonIgnore
    public DropDownList getDdl1GoShokanKetteiSashitomeAriOnly() {
        return this.getTorokushaJoken().getDdl1GoShokanKetteiSashitomeAriOnly();
    }

    @JsonIgnore
    public void  setDdl1GoShokanKetteiSashitomeAriOnly(DropDownList ddl1GoShokanKetteiSashitomeAriOnly) {
        this.getTorokushaJoken().setDdl1GoShokanKetteiSashitomeAriOnly(ddl1GoShokanKetteiSashitomeAriOnly);
    }

    @JsonIgnore
    public DropDownList getDdl1GoShokanKetteiKojoAriOnly() {
        return this.getTorokushaJoken().getDdl1GoShokanKetteiKojoAriOnly();
    }

    @JsonIgnore
    public void  setDdl1GoShokanKetteiKojoAriOnly(DropDownList ddl1GoShokanKetteiKojoAriOnly) {
        this.getTorokushaJoken().setDdl1GoShokanKetteiKojoAriOnly(ddl1GoShokanKetteiKojoAriOnly);
    }

    // </editor-fold>
}
