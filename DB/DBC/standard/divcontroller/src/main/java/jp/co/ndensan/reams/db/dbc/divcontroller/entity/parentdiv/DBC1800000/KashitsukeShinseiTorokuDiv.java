package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1800000;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KyufuhiKashitsukekinList.IKyufuhiKashitsukekinListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KyufuhiKashitsukekinList.KyufuhiKashitsukekinListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KashitsukeShinseiToroku のクラスファイル 
 * 
 * @author 自動生成
 */
public class KashitsukeShinseiTorokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KashitsukeShinseiList")
    private KashitsukeShinseiListDiv KashitsukeShinseiList;
    @JsonProperty("KashitsukeShinseiInfo")
    private KashitsukeShinseiInfoDiv KashitsukeShinseiInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("KashitsukeShinseiList")
    public KashitsukeShinseiListDiv getKashitsukeShinseiList() {
        return KashitsukeShinseiList;
    }

    @JsonProperty("KashitsukeShinseiList")
    public void setKashitsukeShinseiList(KashitsukeShinseiListDiv KashitsukeShinseiList) {
        this.KashitsukeShinseiList=KashitsukeShinseiList;
    }

    @JsonProperty("KashitsukeShinseiInfo")
    public KashitsukeShinseiInfoDiv getKashitsukeShinseiInfo() {
        return KashitsukeShinseiInfo;
    }

    @JsonProperty("KashitsukeShinseiInfo")
    public void setKashitsukeShinseiInfo(KashitsukeShinseiInfoDiv KashitsukeShinseiInfo) {
        this.KashitsukeShinseiInfo=KashitsukeShinseiInfo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public KashitsukeShinseishoDiv getKashitsukeShinseisho() {
        return this.getKashitsukeShinseiList().getKashitsukeShinseisho();
    }

    @JsonIgnore
    public void  setKashitsukeShinseisho(KashitsukeShinseishoDiv KashitsukeShinseisho) {
        this.getKashitsukeShinseiList().setKashitsukeShinseisho(KashitsukeShinseisho);
    }

    @JsonIgnore
    public IKyufuhiKashitsukekinListDiv getKashitsukeShinseiListInfo() {
        return this.getKashitsukeShinseiList().getKashitsukeShinseiListInfo();
    }

    @JsonIgnore
    public TextBoxDate getTxtUketsukeYMD() {
        return this.getKashitsukeShinseiInfo().getTxtUketsukeYMD();
    }

    @JsonIgnore
    public void  setTxtUketsukeYMD(TextBoxDate txtUketsukeYMD) {
        this.getKashitsukeShinseiInfo().setTxtUketsukeYMD(txtUketsukeYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtShinseiYMD() {
        return this.getKashitsukeShinseiInfo().getTxtShinseiYMD();
    }

    @JsonIgnore
    public void  setTxtShinseiYMD(TextBoxDate txtShinseiYMD) {
        this.getKashitsukeShinseiInfo().setTxtShinseiYMD(txtShinseiYMD);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtRiyoKikan() {
        return this.getKashitsukeShinseiInfo().getTxtRiyoKikan();
    }

    @JsonIgnore
    public void  setTxtRiyoKikan(TextBoxDateRange txtRiyoKikan) {
        this.getKashitsukeShinseiInfo().setTxtRiyoKikan(txtRiyoKikan);
    }

    @JsonIgnore
    public TextBoxNum getTxtSeikyugaku() {
        return this.getKashitsukeShinseiInfo().getTxtSeikyugaku();
    }

    @JsonIgnore
    public void  setTxtSeikyugaku(TextBoxNum txtSeikyugaku) {
        this.getKashitsukeShinseiInfo().setTxtSeikyugaku(txtSeikyugaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtShinseiKingaku() {
        return this.getKashitsukeShinseiInfo().getTxtShinseiKingaku();
    }

    @JsonIgnore
    public void  setTxtShinseiKingaku(TextBoxNum txtShinseiKingaku) {
        this.getKashitsukeShinseiInfo().setTxtShinseiKingaku(txtShinseiKingaku);
    }

    @JsonIgnore
    public KashitsukeShinseiServiceDiv getKashitsukeShinseiService() {
        return this.getKashitsukeShinseiInfo().getKashitsukeShinseiService();
    }

    @JsonIgnore
    public void  setKashitsukeShinseiService(KashitsukeShinseiServiceDiv KashitsukeShinseiService) {
        this.getKashitsukeShinseiInfo().setKashitsukeShinseiService(KashitsukeShinseiService);
    }

    @JsonIgnore
    public KashitsukeShinseishaDiv getKashitsukeShinseisha() {
        return this.getKashitsukeShinseiInfo().getKashitsukeShinseisha();
    }

    @JsonIgnore
    public void  setKashitsukeShinseisha(KashitsukeShinseishaDiv KashitsukeShinseisha) {
        this.getKashitsukeShinseiInfo().setKashitsukeShinseisha(KashitsukeShinseisha);
    }

    @JsonIgnore
    public KashitsukeShinseiHoshoninDiv getKashitsukeShinseiHoshonin() {
        return this.getKashitsukeShinseiInfo().getKashitsukeShinseiHoshonin();
    }

    @JsonIgnore
    public void  setKashitsukeShinseiHoshonin(KashitsukeShinseiHoshoninDiv KashitsukeShinseiHoshonin) {
        this.getKashitsukeShinseiInfo().setKashitsukeShinseiHoshonin(KashitsukeShinseiHoshonin);
    }

    @JsonIgnore
    public KashitsukeShinseiTeishutsuDiv getKashitsukeShinseiTeishutsu() {
        return this.getKashitsukeShinseiInfo().getKashitsukeShinseiTeishutsu();
    }

    @JsonIgnore
    public void  setKashitsukeShinseiTeishutsu(KashitsukeShinseiTeishutsuDiv KashitsukeShinseiTeishutsu) {
        this.getKashitsukeShinseiInfo().setKashitsukeShinseiTeishutsu(KashitsukeShinseiTeishutsu);
    }

    @JsonIgnore
    public TextBox getTxtKashitsukeShinseiListSelectedIndex() {
        return this.getKashitsukeShinseiInfo().getTxtKashitsukeShinseiListSelectedIndex();
    }

    @JsonIgnore
    public void  setTxtKashitsukeShinseiListSelectedIndex(TextBox txtKashitsukeShinseiListSelectedIndex) {
        this.getKashitsukeShinseiInfo().setTxtKashitsukeShinseiListSelectedIndex(txtKashitsukeShinseiListSelectedIndex);
    }

    // </editor-fold>
}
