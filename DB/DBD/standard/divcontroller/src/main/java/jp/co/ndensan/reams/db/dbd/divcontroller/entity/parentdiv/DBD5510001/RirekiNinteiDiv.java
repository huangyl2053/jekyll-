package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5510001;
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
 * RirekiNintei のクラスファイル 
 * 
 * @author 自動生成
 */
public class RirekiNinteiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSoshitsubi")
    private TextBoxDate txtSoshitsubi;
    @JsonProperty("tblRireki")
    private tblRirekiDiv tblRireki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtSoshitsubi
     * @return txtSoshitsubi
     */
    @JsonProperty("txtSoshitsubi")
    public TextBoxDate getTxtSoshitsubi() {
        return txtSoshitsubi;
    }

    /*
     * settxtSoshitsubi
     * @param txtSoshitsubi txtSoshitsubi
     */
    @JsonProperty("txtSoshitsubi")
    public void setTxtSoshitsubi(TextBoxDate txtSoshitsubi) {
        this.txtSoshitsubi = txtSoshitsubi;
    }

    /*
     * gettblRireki
     * @return tblRireki
     */
    @JsonProperty("tblRireki")
    public tblRirekiDiv getTblRireki() {
        return tblRireki;
    }

    /*
     * settblRireki
     * @param tblRireki tblRireki
     */
    @JsonProperty("tblRireki")
    public void setTblRireki(tblRirekiDiv tblRireki) {
        this.tblRireki = tblRireki;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblYokaigodo() {
        return this.getTblRireki().getLblYokaigodo();
    }

    @JsonIgnore
    public Label getLblYukoKaishibi() {
        return this.getTblRireki().getLblYukoKaishibi();
    }

    @JsonIgnore
    public Label getLblYukoShuryobi() {
        return this.getTblRireki().getLblYukoShuryobi();
    }

    @JsonIgnore
    public Label getLblNinteibi() {
        return this.getTblRireki().getLblNinteibi();
    }

    @JsonIgnore
    public Label getLblServiceShurui() {
        return this.getTblRireki().getLblServiceShurui();
    }

    @JsonIgnore
    public Label getLblShinsakaiIken() {
        return this.getTblRireki().getLblShinsakaiIken();
    }

    @JsonIgnore
    public ButtonDialog getBtnZenkaiNinteichi() {
        return this.getTblRireki().getBtnZenkaiNinteichi();
    }

    @JsonIgnore
    public TextBox getTxtKubunZenkai() {
        return this.getTblRireki().getTxtKubunZenkai();
    }

    @JsonIgnore
    public TextBox getTxtYokaigodoZenkai() {
        return this.getTblRireki().getTxtYokaigodoZenkai();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtYukoKaishibiZenkai() {
        return this.getTblRireki().getTxtYukoKaishibiZenkai();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtYukoShuryobiZenkai() {
        return this.getTblRireki().getTxtYukoShuryobiZenkai();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteibiZenkai() {
        return this.getTblRireki().getTxtNinteibiZenkai();
    }

    @JsonIgnore
    public TextBox getTxtServiceShuruiZenkai() {
        return this.getTblRireki().getTxtServiceShuruiZenkai();
    }

    @JsonIgnore
    public TextBox getTxtShinsakaiIkenZenkai() {
        return this.getTblRireki().getTxtShinsakaiIkenZenkai();
    }

    @JsonIgnore
    public ButtonDialog getBtnKonkaiNinteichi() {
        return this.getTblRireki().getBtnKonkaiNinteichi();
    }

    @JsonIgnore
    public TextBox getTxtKubunKonkai() {
        return this.getTblRireki().getTxtKubunKonkai();
    }

    @JsonIgnore
    public TextBox getTxtYokaigodoKonkai() {
        return this.getTblRireki().getTxtYokaigodoKonkai();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtYukoKaishibiKonkai() {
        return this.getTblRireki().getTxtYukoKaishibiKonkai();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtYukoShuryobiKonkai() {
        return this.getTblRireki().getTxtYukoShuryobiKonkai();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteibiKonkai() {
        return this.getTblRireki().getTxtNinteibiKonkai();
    }

    @JsonIgnore
    public TextBox getTxtServiceShuruiKonkai() {
        return this.getTblRireki().getTxtServiceShuruiKonkai();
    }

    @JsonIgnore
    public TextBox getTxtShinsakaiIkenKonkai() {
        return this.getTblRireki().getTxtShinsakaiIkenKonkai();
    }

    // </editor-fold>
}
