package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020041;
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
 * tblGekihen のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblGekihenDiv extends TabPanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-16_12-38-19">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TablePanel4")
    private TablePanel4Div TablePanel4;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getTablePanel4
     * @return TablePanel4
     */
    @JsonProperty("TablePanel4")
    public TablePanel4Div getTablePanel4() {
        return TablePanel4;
    }

    /*
     * setTablePanel4
     * @param TablePanel4 TablePanel4
     */
    @JsonProperty("TablePanel4")
    public void setTablePanel4(TablePanel4Div TablePanel4) {
        this.TablePanel4 = TablePanel4;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblFukushiShisetsu() {
        return this.getTablePanel4().getLblFukushiShisetsu();
    }

    @JsonIgnore
    public Label getLblHokenShisetsu() {
        return this.getTablePanel4().getLblHokenShisetsu();
    }

    @JsonIgnore
    public Label getLblIryoShisetsu() {
        return this.getTablePanel4().getLblIryoShisetsu();
    }

    @JsonIgnore
    public Label getLblSeiKatsuKaigo() {
        return this.getTablePanel4().getLblSeiKatsuKaigo();
    }

    @JsonIgnore
    public Label getLblSonota() {
        return this.getTablePanel4().getLblSonota();
    }

    @JsonIgnore
    public Label getLblKei() {
        return this.getTablePanel4().getLblKei();
    }

    @JsonIgnore
    public Label getLblShinseiSu() {
        return this.getTablePanel4().getLblShinseiSu();
    }

    @JsonIgnore
    public TextBoxNum getTxtFukushiShisetsuShinseiSu() {
        return this.getTablePanel4().getTxtFukushiShisetsuShinseiSu();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenShisetsuShinseiSu() {
        return this.getTablePanel4().getTxtHokenShisetsuShinseiSu();
    }

    @JsonIgnore
    public TextBoxNum getTxtIryoShisetsuShinseiSu() {
        return this.getTablePanel4().getTxtIryoShisetsuShinseiSu();
    }

    @JsonIgnore
    public TextBoxNum getTxtSeiKatsuKaigoShinseiSu() {
        return this.getTablePanel4().getTxtSeiKatsuKaigoShinseiSu();
    }

    @JsonIgnore
    public TextBoxNum getTxtSonotaShinseiSu() {
        return this.getTablePanel4().getTxtSonotaShinseiSu();
    }

    @JsonIgnore
    public TextBoxNum getTxtKeiShinseiSu() {
        return this.getTablePanel4().getTxtKeiShinseiSu();
    }

    @JsonIgnore
    public Label getLblFukushiShisetsuShokuji() {
        return this.getTablePanel4().getLblFukushiShisetsuShokuji();
    }

    @JsonIgnore
    public Label getLblFukushiShisetsuKyojuhi() {
        return this.getTablePanel4().getLblFukushiShisetsuKyojuhi();
    }

    @JsonIgnore
    public Label getLblHokenShisetsuShokuji() {
        return this.getTablePanel4().getLblHokenShisetsuShokuji();
    }

    @JsonIgnore
    public Label getLblHokenShisetsuKyojuhi() {
        return this.getTablePanel4().getLblHokenShisetsuKyojuhi();
    }

    @JsonIgnore
    public Label getLblIryoShisetsuShokuji() {
        return this.getTablePanel4().getLblIryoShisetsuShokuji();
    }

    @JsonIgnore
    public Label getLblIryoShisetsuKyojuhi() {
        return this.getTablePanel4().getLblIryoShisetsuKyojuhi();
    }

    @JsonIgnore
    public Label getLblSeiKatsuKaigoShisetsuShokuji() {
        return this.getTablePanel4().getLblSeiKatsuKaigoShisetsuShokuji();
    }

    @JsonIgnore
    public Label getLblSeikatsuKaigoShisetsuKyojuhi() {
        return this.getTablePanel4().getLblSeikatsuKaigoShisetsuKyojuhi();
    }

    @JsonIgnore
    public Label getLblSonotaShisetsuShokuji() {
        return this.getTablePanel4().getLblSonotaShisetsuShokuji();
    }

    @JsonIgnore
    public Label getLblSonotaShisetsuKyojuhi() {
        return this.getTablePanel4().getLblSonotaShisetsuKyojuhi();
    }

    @JsonIgnore
    public Label getLblKeiShokuji() {
        return this.getTablePanel4().getLblKeiShokuji();
    }

    @JsonIgnore
    public Label getLblKeiKyojuhi() {
        return this.getTablePanel4().getLblKeiKyojuhi();
    }

    @JsonIgnore
    public Label getLblDaisanDankaiSu() {
        return this.getTablePanel4().getLblDaisanDankaiSu();
    }

    @JsonIgnore
    public TextBoxNum getTxtFukushiShisetsuDaisanDankaiShokujihi() {
        return this.getTablePanel4().getTxtFukushiShisetsuDaisanDankaiShokujihi();
    }

    @JsonIgnore
    public TextBoxNum getTxtFukushiShisetsuDaisanDankaiKyojuhi() {
        return this.getTablePanel4().getTxtFukushiShisetsuDaisanDankaiKyojuhi();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenShisetsuDaisanDankaiShokujihi() {
        return this.getTablePanel4().getTxtHokenShisetsuDaisanDankaiShokujihi();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenShisetsuDaisanDankaiKyojuhi() {
        return this.getTablePanel4().getTxtHokenShisetsuDaisanDankaiKyojuhi();
    }

    @JsonIgnore
    public TextBoxNum getTxtIryoShisetsuDaisanDankaiShokujihi() {
        return this.getTablePanel4().getTxtIryoShisetsuDaisanDankaiShokujihi();
    }

    @JsonIgnore
    public TextBoxNum getTxtIryoShisetsuDaisanDankaiKyojuhi() {
        return this.getTablePanel4().getTxtIryoShisetsuDaisanDankaiKyojuhi();
    }

    @JsonIgnore
    public TextBoxNum getTxtSeikatsuKaigoShisetsuDaisanDankaiShokujihi() {
        return this.getTablePanel4().getTxtSeikatsuKaigoShisetsuDaisanDankaiShokujihi();
    }

    @JsonIgnore
    public TextBoxNum getTxtSeikatsuKaigoShisetsuDaisanDankaiKyojuhi() {
        return this.getTablePanel4().getTxtSeikatsuKaigoShisetsuDaisanDankaiKyojuhi();
    }

    @JsonIgnore
    public TextBoxNum getTxtSonotaShisetsuDaisanDankaiShokujihi() {
        return this.getTablePanel4().getTxtSonotaShisetsuDaisanDankaiShokujihi();
    }

    @JsonIgnore
    public TextBoxNum getTxtSonotaShisetsuDaisanDankaiKyojuhi() {
        return this.getTablePanel4().getTxtSonotaShisetsuDaisanDankaiKyojuhi();
    }

    @JsonIgnore
    public TextBoxNum getTxtKeiDaisanDankaiShokujihi() {
        return this.getTablePanel4().getTxtKeiDaisanDankaiShokujihi();
    }

    @JsonIgnore
    public TextBoxNum getTxtKeiDaisanDankaiKyojuhi() {
        return this.getTablePanel4().getTxtKeiDaisanDankaiKyojuhi();
    }

    @JsonIgnore
    public Label getLblDaisanDankaiToGetsumatsuSu() {
        return this.getTablePanel4().getLblDaisanDankaiToGetsumatsuSu();
    }

    @JsonIgnore
    public TextBoxNum getTxtFukushiShisetsuDaisanDankaiToGetsumatsuShokujihi() {
        return this.getTablePanel4().getTxtFukushiShisetsuDaisanDankaiToGetsumatsuShokujihi();
    }

    @JsonIgnore
    public TextBoxNum getTxtFukushiShisetsuDaisanDankaiToGetsumatsuKyojuhi() {
        return this.getTablePanel4().getTxtFukushiShisetsuDaisanDankaiToGetsumatsuKyojuhi();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenShisetsuDaisanDankaiToGetsumatsuShokujihi() {
        return this.getTablePanel4().getTxtHokenShisetsuDaisanDankaiToGetsumatsuShokujihi();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenShisetsuDaisanDankaiToGetsumatsuKyojuhi() {
        return this.getTablePanel4().getTxtHokenShisetsuDaisanDankaiToGetsumatsuKyojuhi();
    }

    @JsonIgnore
    public TextBoxNum getTxtIryoShisetsuDaisanDankaiToGetsumatsuShokujihi() {
        return this.getTablePanel4().getTxtIryoShisetsuDaisanDankaiToGetsumatsuShokujihi();
    }

    @JsonIgnore
    public TextBoxNum getTxtIryoShisetsuDaisanDankaiToGetsumatsuKyojuhi() {
        return this.getTablePanel4().getTxtIryoShisetsuDaisanDankaiToGetsumatsuKyojuhi();
    }

    @JsonIgnore
    public TextBoxNum getTxtSeikatsuKaigoShisetsuDaisanDankaiToGetsumatsuShokujihi() {
        return this.getTablePanel4().getTxtSeikatsuKaigoShisetsuDaisanDankaiToGetsumatsuShokujihi();
    }

    @JsonIgnore
    public TextBoxNum getTxtSeikatsuKaigoShisetsuDaisanDankaiToGetsumatsuKyojuhi() {
        return this.getTablePanel4().getTxtSeikatsuKaigoShisetsuDaisanDankaiToGetsumatsuKyojuhi();
    }

    @JsonIgnore
    public TextBoxNum getTxtSonotaShisetsuDaisanDankaiToGetsumatsuShokujihi() {
        return this.getTablePanel4().getTxtSonotaShisetsuDaisanDankaiToGetsumatsuShokujihi();
    }

    @JsonIgnore
    public TextBoxNum getTxtSonotaShisetsuDaisanDankaiToGetsumatsuKyojuhi() {
        return this.getTablePanel4().getTxtSonotaShisetsuDaisanDankaiToGetsumatsuKyojuhi();
    }

    @JsonIgnore
    public TextBoxNum getTxtKeiDaisanDankaiToGetsumatsuShokujihi() {
        return this.getTablePanel4().getTxtKeiDaisanDankaiToGetsumatsuShokujihi();
    }

    @JsonIgnore
    public TextBoxNum getTxtKeiDaisanDankaiToGetsumatsuKyojuhi() {
        return this.getTablePanel4().getTxtKeiDaisanDankaiToGetsumatsuKyojuhi();
    }

    @JsonIgnore
    public Label getLblDainiDankaiSu() {
        return this.getTablePanel4().getLblDainiDankaiSu();
    }

    @JsonIgnore
    public TextBoxNum getTxtFukushiShisetsuDainiDankaiShokujihi() {
        return this.getTablePanel4().getTxtFukushiShisetsuDainiDankaiShokujihi();
    }

    @JsonIgnore
    public TextBoxNum getTxtFukushiShisetsuDainiDankaiKyojuhi() {
        return this.getTablePanel4().getTxtFukushiShisetsuDainiDankaiKyojuhi();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenShisetsuDainiDankaiShokujihi() {
        return this.getTablePanel4().getTxtHokenShisetsuDainiDankaiShokujihi();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenShisetsuDainiDankaiKyojuhi() {
        return this.getTablePanel4().getTxtHokenShisetsuDainiDankaiKyojuhi();
    }

    @JsonIgnore
    public TextBoxNum getTxtIryoShisetsuDainiDankaiShokujihi() {
        return this.getTablePanel4().getTxtIryoShisetsuDainiDankaiShokujihi();
    }

    @JsonIgnore
    public TextBoxNum getTxtIryoShisetsuDainiDankaiKyojuhi() {
        return this.getTablePanel4().getTxtIryoShisetsuDainiDankaiKyojuhi();
    }

    @JsonIgnore
    public TextBoxNum getTxtSeikatsuKaigoShisetsuDainiDankaiShokujihi() {
        return this.getTablePanel4().getTxtSeikatsuKaigoShisetsuDainiDankaiShokujihi();
    }

    @JsonIgnore
    public TextBoxNum getTxtSeikatsuKaigoShisetsuDainiDankaiKyojuhi() {
        return this.getTablePanel4().getTxtSeikatsuKaigoShisetsuDainiDankaiKyojuhi();
    }

    @JsonIgnore
    public TextBoxNum getTxtSonotaShisetsuDainiDankaiShokujihi() {
        return this.getTablePanel4().getTxtSonotaShisetsuDainiDankaiShokujihi();
    }

    @JsonIgnore
    public TextBoxNum getTxtSonotaShisetsuDainiDankaiKyojuhi() {
        return this.getTablePanel4().getTxtSonotaShisetsuDainiDankaiKyojuhi();
    }

    @JsonIgnore
    public TextBoxNum getTxtKeiDainiDankaiShokujihi() {
        return this.getTablePanel4().getTxtKeiDainiDankaiShokujihi();
    }

    @JsonIgnore
    public TextBoxNum getTxtKeiDainiDankaiKyojuhi() {
        return this.getTablePanel4().getTxtKeiDainiDankaiKyojuhi();
    }

    @JsonIgnore
    public Label getLblDainiDankaiToGetsumatsuSu() {
        return this.getTablePanel4().getLblDainiDankaiToGetsumatsuSu();
    }

    @JsonIgnore
    public TextBoxNum getTextBoxNum31() {
        return this.getTablePanel4().getTextBoxNum31();
    }

    @JsonIgnore
    public TextBoxNum getTxtFukushiShisetsuDainiDankaiToGetsumatsuKyojuhi() {
        return this.getTablePanel4().getTxtFukushiShisetsuDainiDankaiToGetsumatsuKyojuhi();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenShisetsuDainiDankaiToGetsumatsuShokujihi() {
        return this.getTablePanel4().getTxtHokenShisetsuDainiDankaiToGetsumatsuShokujihi();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenShisetsuDainiDankaiToGetsumatsuKyojuhi() {
        return this.getTablePanel4().getTxtHokenShisetsuDainiDankaiToGetsumatsuKyojuhi();
    }

    @JsonIgnore
    public TextBoxNum getTxtIryoShisetsuDainiDankaiToGetsumatsuShokujihi() {
        return this.getTablePanel4().getTxtIryoShisetsuDainiDankaiToGetsumatsuShokujihi();
    }

    @JsonIgnore
    public TextBoxNum getTxtIryoShisetsuDainiDankaiToGetsumatsuKyojuhi() {
        return this.getTablePanel4().getTxtIryoShisetsuDainiDankaiToGetsumatsuKyojuhi();
    }

    @JsonIgnore
    public TextBoxNum getTxtSeikatsuKaigoShisetsuDainiDankaiToGetsumatsuShokujihi() {
        return this.getTablePanel4().getTxtSeikatsuKaigoShisetsuDainiDankaiToGetsumatsuShokujihi();
    }

    @JsonIgnore
    public TextBoxNum getTxtSeikatsuKaigoShisetsuDainiDankaiToGetsumatsuKyojuhi() {
        return this.getTablePanel4().getTxtSeikatsuKaigoShisetsuDainiDankaiToGetsumatsuKyojuhi();
    }

    @JsonIgnore
    public TextBoxNum getTxtSonotaShisetsuDaiichiDankaiToGetsumatsuShokujihi() {
        return this.getTablePanel4().getTxtSonotaShisetsuDaiichiDankaiToGetsumatsuShokujihi();
    }

    @JsonIgnore
    public TextBoxNum getTxtSonotaShisetsuDainiDankaiToGetsumatsuKyojuhi() {
        return this.getTablePanel4().getTxtSonotaShisetsuDainiDankaiToGetsumatsuKyojuhi();
    }

    @JsonIgnore
    public TextBoxNum getTxtKeiDainiDankaiToGetsumatsuShokujihi() {
        return this.getTablePanel4().getTxtKeiDainiDankaiToGetsumatsuShokujihi();
    }

    @JsonIgnore
    public TextBoxNum getTxtKeiDainiDankaiToGetsumatsuKyojuhi() {
        return this.getTablePanel4().getTxtKeiDainiDankaiToGetsumatsuKyojuhi();
    }

    // </editor-fold>
}
