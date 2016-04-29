package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2020002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * ShiharaiHohoKanriListMain のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShiharaiHohoKanriListMainDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ChushutsuJoken")
    private ChushutsuJokenDiv ChushutsuJoken;
    @JsonProperty("ccdChohyoShutsuryokujun")
    private ChohyoShutsuryokujunDiv ccdChohyoShutsuryokujun;

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
     * getccdChohyoShutsuryokujun
     * @return ccdChohyoShutsuryokujun
     */
    @JsonProperty("ccdChohyoShutsuryokujun")
    public IChohyoShutsuryokujunDiv getCcdChohyoShutsuryokujun() {
        return ccdChohyoShutsuryokujun;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadTorokusha() {
        return this.getChushutsuJoken().getChushutsuJokenDetail().getRadTorokusha();
    }

    @JsonIgnore
    public void  setRadTorokusha(RadioButton radTorokusha) {
        this.getChushutsuJoken().getChushutsuJokenDetail().setRadTorokusha(radTorokusha);
    }

    @JsonIgnore
    public TorokushaJokenDiv getTorokushaJoken() {
        return this.getChushutsuJoken().getChushutsuJokenDetail().getTorokushaJoken();
    }

    @JsonIgnore
    public void  setTorokushaJoken(TorokushaJokenDiv TorokushaJoken) {
        this.getChushutsuJoken().getChushutsuJokenDetail().setTorokushaJoken(TorokushaJoken);
    }

    @JsonIgnore
    public DropDownList getDdl2GoSashitomeYokoku() {
        return this.getChushutsuJoken().getChushutsuJokenDetail().getTorokushaJoken().getDdl2GoSashitomeYokoku();
    }

    @JsonIgnore
    public void  setDdl2GoSashitomeYokoku(DropDownList ddl2GoSashitomeYokoku) {
        this.getChushutsuJoken().getChushutsuJokenDetail().getTorokushaJoken().setDdl2GoSashitomeYokoku(ddl2GoSashitomeYokoku);
    }

    @JsonIgnore
    public DropDownList getDdlGoSashitomeToroku() {
        return this.getChushutsuJoken().getChushutsuJokenDetail().getTorokushaJoken().getDdlGoSashitomeToroku();
    }

    @JsonIgnore
    public void  setDdlGoSashitomeToroku(DropDownList ddlGoSashitomeToroku) {
        this.getChushutsuJoken().getChushutsuJokenDetail().getTorokushaJoken().setDdlGoSashitomeToroku(ddlGoSashitomeToroku);
    }

    @JsonIgnore
    public DropDownList getDdl2GoShokanYokoku() {
        return this.getChushutsuJoken().getChushutsuJokenDetail().getTorokushaJoken().getDdl2GoShokanYokoku();
    }

    @JsonIgnore
    public void  setDdl2GoShokanYokoku(DropDownList ddl2GoShokanYokoku) {
        this.getChushutsuJoken().getChushutsuJokenDetail().getTorokushaJoken().setDdl2GoShokanYokoku(ddl2GoShokanYokoku);
    }

    @JsonIgnore
    public DropDownList getDdl1GoShokanKettei() {
        return this.getChushutsuJoken().getChushutsuJokenDetail().getTorokushaJoken().getDdl1GoShokanKettei();
    }

    @JsonIgnore
    public void  setDdl1GoShokanKettei(DropDownList ddl1GoShokanKettei) {
        this.getChushutsuJoken().getChushutsuJokenDetail().getTorokushaJoken().setDdl1GoShokanKettei(ddl1GoShokanKettei);
    }

    @JsonIgnore
    public DropDownList getDdl1GoShokanKetteiSashitomeAriOnly() {
        return this.getChushutsuJoken().getChushutsuJokenDetail().getTorokushaJoken().getDdl1GoShokanKetteiSashitomeAriOnly();
    }

    @JsonIgnore
    public void  setDdl1GoShokanKetteiSashitomeAriOnly(DropDownList ddl1GoShokanKetteiSashitomeAriOnly) {
        this.getChushutsuJoken().getChushutsuJokenDetail().getTorokushaJoken().setDdl1GoShokanKetteiSashitomeAriOnly(ddl1GoShokanKetteiSashitomeAriOnly);
    }

    @JsonIgnore
    public DropDownList getDdl1GoShokanKetteiKojoAriOnly() {
        return this.getChushutsuJoken().getChushutsuJokenDetail().getTorokushaJoken().getDdl1GoShokanKetteiKojoAriOnly();
    }

    @JsonIgnore
    public void  setDdl1GoShokanKetteiKojoAriOnly(DropDownList ddl1GoShokanKetteiKojoAriOnly) {
        this.getChushutsuJoken().getChushutsuJokenDetail().getTorokushaJoken().setDdl1GoShokanKetteiKojoAriOnly(ddl1GoShokanKetteiKojoAriOnly);
    }

    // </editor-fold>
}
