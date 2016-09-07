package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000023;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * PanelShutsuryokuNaiyo のクラスファイル
 *
 * @reamsid_L DBC-5010-012 lijian
 */
public class PanelShutsuryokuNaiyoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblShutsuryokuNaiyo")
    private tblShutsuryokuNaiyoDiv tblShutsuryokuNaiyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettblShutsuryokuNaiyo
     * @return tblShutsuryokuNaiyo
     */
    @JsonProperty("tblShutsuryokuNaiyo")
    public tblShutsuryokuNaiyoDiv getTblShutsuryokuNaiyo() {
        return tblShutsuryokuNaiyo;
    }

    /*
     * settblShutsuryokuNaiyo
     * @param tblShutsuryokuNaiyo tblShutsuryokuNaiyo
     */
    @JsonProperty("tblShutsuryokuNaiyo")
    public void setTblShutsuryokuNaiyo(tblShutsuryokuNaiyoDiv tblShutsuryokuNaiyo) {
        this.tblShutsuryokuNaiyo = tblShutsuryokuNaiyo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblFutanWariai() {
        return this.getTblShutsuryokuNaiyo().getLblFutanWariai();
    }

    @JsonIgnore
    public Label getLblTekiyoKikan() {
        return this.getTblShutsuryokuNaiyo().getLblTekiyoKikan();
    }

    @JsonIgnore
    public Label getLbl2wari() {
        return this.getTblShutsuryokuNaiyo().getLbl2wari();
    }

    @JsonIgnore
    public Label getLbl2wariKaishibi() {
        return this.getTblShutsuryokuNaiyo().getLbl2wariKaishibi();
    }

    @JsonIgnore
    public Label getLbl2wariKaishiYmd() {
        return this.getTblShutsuryokuNaiyo().getLbl2wariKaishiYmd();
    }

    @JsonIgnore
    public Label getLbl2wariShuryobi() {
        return this.getTblShutsuryokuNaiyo().getLbl2wariShuryobi();
    }

    @JsonIgnore
    public Label getLbl2wariShuryoYmd() {
        return this.getTblShutsuryokuNaiyo().getLbl2wariShuryoYmd();
    }

    @JsonIgnore
    public Label getLbl1wari() {
        return this.getTblShutsuryokuNaiyo().getLbl1wari();
    }

    @JsonIgnore
    public Label getLbl1wariKaishibi() {
        return this.getTblShutsuryokuNaiyo().getLbl1wariKaishibi();
    }

    @JsonIgnore
    public Label getLbl1wariKaishiYmd() {
        return this.getTblShutsuryokuNaiyo().getLbl1wariKaishiYmd();
    }

    @JsonIgnore
    public Label getLbl1wariShuryobi() {
        return this.getTblShutsuryokuNaiyo().getLbl1wariShuryobi();
    }

    @JsonIgnore
    public Label getLbl1wariShuryoYmd() {
        return this.getTblShutsuryokuNaiyo().getLbl1wariShuryoYmd();
    }

    // </editor-fold>
}
