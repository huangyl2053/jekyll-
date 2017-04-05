package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.SeikatsuHogoJohoCommonDiv;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TableCell;
import jp.co.ndensan.reams.uz.uza.ui.binding.TablePanel;

/**
 * tbPanelHogoMeisai のクラスファイル 
 * 
 * @author 自動生成
 */
public class tbPanelHogoMeisaiDiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-03-27_09-11-55">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tcJyukyuKikan")
    private tcJyukyuKikanAttbPanelHogoMeisai tcJyukyuKikan;
    @JsonProperty("tbSeikatsuHogo")
    private tbSeikatsuHogoAttbPanelHogoMeisai tbSeikatsuHogo;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public panelJyukyuKikanDiv getPanelJyukyuKikan() {
        return this.tcJyukyuKikan.getPanelJyukyuKikan();
    }

    @JsonIgnore
    public panelDairiNoufuDiv getPanelDairiNoufu() {
        return this.tcJyukyuKikan.getPanelDairiNoufu();
    }

    @JsonIgnore
    public panelKugoShisetuDiv getPanelKugoShisetu() {
        return this.tcJyukyuKikan.getPanelKugoShisetu();
    }

    @JsonIgnore
    public panelJyukyuTeishiKikanDiv getPanelJyukyuTeishiKikan() {
        return this.tbSeikatsuHogo.getPanelJyukyuTeishiKikan();
    }

    @JsonIgnore
    public panelFujoSyuruiDiv getPanelFujoSyurui() {
        return this.tbSeikatsuHogo.getPanelFujoSyurui();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettcJyukyuKikan
     * @return tcJyukyuKikan
     */
    @JsonProperty("tcJyukyuKikan")
    private tcJyukyuKikanAttbPanelHogoMeisai getTcJyukyuKikan() {
        return tcJyukyuKikan;
    }

    /*
     * settcJyukyuKikan
     * @param tcJyukyuKikan tcJyukyuKikan
     */
    @JsonProperty("tcJyukyuKikan")
    private void setTcJyukyuKikan(tcJyukyuKikanAttbPanelHogoMeisai tcJyukyuKikan) {
        this.tcJyukyuKikan = tcJyukyuKikan;
    }

    /*
     * gettbSeikatsuHogo
     * @return tbSeikatsuHogo
     */
    @JsonProperty("tbSeikatsuHogo")
    private tbSeikatsuHogoAttbPanelHogoMeisai getTbSeikatsuHogo() {
        return tbSeikatsuHogo;
    }

    /*
     * settbSeikatsuHogo
     * @param tbSeikatsuHogo tbSeikatsuHogo
     */
    @JsonProperty("tbSeikatsuHogo")
    private void setTbSeikatsuHogo(tbSeikatsuHogoAttbPanelHogoMeisai tbSeikatsuHogo) {
        this.tbSeikatsuHogo = tbSeikatsuHogo;
    }

    // </editor-fold>
}
/**
 * tcJyukyuKikan のクラスファイル 
 * 
 * @author 自動生成
 */
class tcJyukyuKikanAttbPanelHogoMeisai extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-03-27_09-11-55">
    @JsonProperty("panelJyukyuKikan")
    private panelJyukyuKikanDiv panelJyukyuKikan;
    @JsonProperty("panelDairiNoufu")
    private panelDairiNoufuDiv panelDairiNoufu;
    @JsonProperty("panelKugoShisetu")
    private panelKugoShisetuDiv panelKugoShisetu;

    /*
     * getpanelJyukyuKikan
     * @return panelJyukyuKikan
     */
    @JsonProperty("panelJyukyuKikan")
    public panelJyukyuKikanDiv getPanelJyukyuKikan() {
        return panelJyukyuKikan;
    }

    /*
     * setpanelJyukyuKikan
     * @param panelJyukyuKikan panelJyukyuKikan
     */
    @JsonProperty("panelJyukyuKikan")
    public void setPanelJyukyuKikan(panelJyukyuKikanDiv panelJyukyuKikan) {
        this.panelJyukyuKikan = panelJyukyuKikan;
    }

    /*
     * getpanelDairiNoufu
     * @return panelDairiNoufu
     */
    @JsonProperty("panelDairiNoufu")
    public panelDairiNoufuDiv getPanelDairiNoufu() {
        return panelDairiNoufu;
    }

    /*
     * setpanelDairiNoufu
     * @param panelDairiNoufu panelDairiNoufu
     */
    @JsonProperty("panelDairiNoufu")
    public void setPanelDairiNoufu(panelDairiNoufuDiv panelDairiNoufu) {
        this.panelDairiNoufu = panelDairiNoufu;
    }

    /*
     * getpanelKugoShisetu
     * @return panelKugoShisetu
     */
    @JsonProperty("panelKugoShisetu")
    public panelKugoShisetuDiv getPanelKugoShisetu() {
        return panelKugoShisetu;
    }

    /*
     * setpanelKugoShisetu
     * @param panelKugoShisetu panelKugoShisetu
     */
    @JsonProperty("panelKugoShisetu")
    public void setPanelKugoShisetu(panelKugoShisetuDiv panelKugoShisetu) {
        this.panelKugoShisetu = panelKugoShisetu;
    }

    // </editor-fold>
}
/**
 * tbSeikatsuHogo のクラスファイル 
 * 
 * @author 自動生成
 */
class tbSeikatsuHogoAttbPanelHogoMeisai extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-03-27_09-11-55">
    @JsonProperty("panelJyukyuTeishiKikan")
    private panelJyukyuTeishiKikanDiv panelJyukyuTeishiKikan;
    @JsonProperty("panelFujoSyurui")
    private panelFujoSyuruiDiv panelFujoSyurui;

    /*
     * getpanelJyukyuTeishiKikan
     * @return panelJyukyuTeishiKikan
     */
    @JsonProperty("panelJyukyuTeishiKikan")
    public panelJyukyuTeishiKikanDiv getPanelJyukyuTeishiKikan() {
        return panelJyukyuTeishiKikan;
    }

    /*
     * setpanelJyukyuTeishiKikan
     * @param panelJyukyuTeishiKikan panelJyukyuTeishiKikan
     */
    @JsonProperty("panelJyukyuTeishiKikan")
    public void setPanelJyukyuTeishiKikan(panelJyukyuTeishiKikanDiv panelJyukyuTeishiKikan) {
        this.panelJyukyuTeishiKikan = panelJyukyuTeishiKikan;
    }

    /*
     * getpanelFujoSyurui
     * @return panelFujoSyurui
     */
    @JsonProperty("panelFujoSyurui")
    public panelFujoSyuruiDiv getPanelFujoSyurui() {
        return panelFujoSyurui;
    }

    /*
     * setpanelFujoSyurui
     * @param panelFujoSyurui panelFujoSyurui
     */
    @JsonProperty("panelFujoSyurui")
    public void setPanelFujoSyurui(panelFujoSyuruiDiv panelFujoSyurui) {
        this.panelFujoSyurui = panelFujoSyurui;
    }

    // </editor-fold>
}
