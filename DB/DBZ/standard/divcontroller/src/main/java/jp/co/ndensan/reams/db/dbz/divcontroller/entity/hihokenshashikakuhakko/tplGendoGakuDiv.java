package jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshashikakuhakko;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshashikakuhakko.KubunGendoGakuDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshashikakuhakko.ShuruiShikyuGendoKijungakuDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshashikakuhakko.tblGendoGakuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tplGendoGaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplGendoGakuDiv extends TabPanel {
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
    @JsonProperty("tblGendoGaku")
    public tblGendoGakuDiv getTblGendoGaku() {
        return tblGendoGaku;
    }

    @JsonProperty("tblGendoGaku")
    public void setTblGendoGaku(tblGendoGakuDiv tblGendoGaku) {
        this.tblGendoGaku=tblGendoGaku;
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

}
