package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hihokenshashikakuhakko.HihokenshaShikakuHakko;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tplGendoGaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplGendoGakuDiv extends TabPanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblGendoGaku")
    private tblGendoGakuDiv tblGendoGaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettblGendoGaku
     * @return tblGendoGaku
     */
    @JsonProperty("tblGendoGaku")
    public tblGendoGakuDiv getTblGendoGaku() {
        return tblGendoGaku;
    }

    /*
     * settblGendoGaku
     * @param tblGendoGaku tblGendoGaku
     */
    @JsonProperty("tblGendoGaku")
    public void setTblGendoGaku(tblGendoGakuDiv tblGendoGaku) {
        this.tblGendoGaku = tblGendoGaku;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public KubunGendoGakuDiv getKubunGendoGaku() {
        return this.getTblGendoGaku().getKubunGendoGaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtKubunShikyuGendoKijunGaku() {
        return this.getTblGendoGaku().getKubunGendoGaku().getTxtKubunShikyuGendoKijunGaku();
    }

    @JsonIgnore
    public void  setTxtKubunShikyuGendoKijunGaku(TextBoxNum txtKubunShikyuGendoKijunGaku) {
        this.getTblGendoGaku().getKubunGendoGaku().setTxtKubunShikyuGendoKijunGaku(txtKubunShikyuGendoKijunGaku);
    }

    @JsonIgnore
    public TextBoxDate getTxtYukoFromYMD() {
        return this.getTblGendoGaku().getKubunGendoGaku().getTxtYukoFromYMD();
    }

    @JsonIgnore
    public void  setTxtYukoFromYMD(TextBoxDate txtYukoFromYMD) {
        this.getTblGendoGaku().getKubunGendoGaku().setTxtYukoFromYMD(txtYukoFromYMD);
    }

    @JsonIgnore
    public Label getLblKara() {
        return this.getTblGendoGaku().getKubunGendoGaku().getLblKara();
    }

    @JsonIgnore
    public void  setLblKara(Label lblKara) {
        this.getTblGendoGaku().getKubunGendoGaku().setLblKara(lblKara);
    }

    @JsonIgnore
    public TextBoxDate getTxtYukoToYMD() {
        return this.getTblGendoGaku().getKubunGendoGaku().getTxtYukoToYMD();
    }

    @JsonIgnore
    public void  setTxtYukoToYMD(TextBoxDate txtYukoToYMD) {
        this.getTblGendoGaku().getKubunGendoGaku().setTxtYukoToYMD(txtYukoToYMD);
    }

    @JsonIgnore
    public ShuruiShikyuGendoKijungakuDiv getShuruiShikyuGendoKijungaku() {
        return this.getTblGendoGaku().getShuruiShikyuGendoKijungaku();
    }

    // </editor-fold>
}
