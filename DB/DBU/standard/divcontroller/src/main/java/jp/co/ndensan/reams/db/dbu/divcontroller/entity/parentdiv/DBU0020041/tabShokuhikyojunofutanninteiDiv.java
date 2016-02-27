package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020041;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;

/**
 * tabShokuhikyojunofutannintei のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabShokuhikyojunofutanninteiDiv extends TabContainer {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-16_12-38-19">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblGekihen")
    private tblGekihenDiv tblGekihen;
    @JsonProperty("tblDaiyonDankai")
    private tblDaiyonDankaiDiv tblDaiyonDankai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettblGekihen
     * @return tblGekihen
     */
    @JsonProperty("tblGekihen")
    public tblGekihenDiv getTblGekihen() {
        return tblGekihen;
    }

    /*
     * settblGekihen
     * @param tblGekihen tblGekihen
     */
    @JsonProperty("tblGekihen")
    public void setTblGekihen(tblGekihenDiv tblGekihen) {
        this.tblGekihen = tblGekihen;
    }

    /*
     * gettblDaiyonDankai
     * @return tblDaiyonDankai
     */
    @JsonProperty("tblDaiyonDankai")
    public tblDaiyonDankaiDiv getTblDaiyonDankai() {
        return tblDaiyonDankai;
    }

    /*
     * settblDaiyonDankai
     * @param tblDaiyonDankai tblDaiyonDankai
     */
    @JsonProperty("tblDaiyonDankai")
    public void setTblDaiyonDankai(tblDaiyonDankaiDiv tblDaiyonDankai) {
        this.tblDaiyonDankai = tblDaiyonDankai;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TablePanel4Div getTablePanel4() {
        return this.getTblGekihen().getTablePanel4();
    }

    @JsonIgnore
    public void  setTablePanel4(TablePanel4Div TablePanel4) {
        this.getTblGekihen().setTablePanel4(TablePanel4);
    }

    @JsonIgnore
    public Label getLblFukushiShisetsu() {
        return this.getTblGekihen().getTablePanel4().getLblFukushiShisetsu();
    }

    @JsonIgnore
    public Label getLblHokenShisetsu() {
        return this.getTblGekihen().getTablePanel4().getLblHokenShisetsu();
    }

    @JsonIgnore
    public Label getLblIryoShisetsu() {
        return this.getTblGekihen().getTablePanel4().getLblIryoShisetsu();
    }

    @JsonIgnore
    public Label getLblSeiKatsuKaigo() {
        return this.getTblGekihen().getTablePanel4().getLblSeiKatsuKaigo();
    }

    @JsonIgnore
    public Label getLblSonota() {
        return this.getTblGekihen().getTablePanel4().getLblSonota();
    }

    @JsonIgnore
    public Label getLblKei() {
        return this.getTblGekihen().getTablePanel4().getLblKei();
    }

    @JsonIgnore
    public Label getLblShinseiSu() {
        return this.getTblGekihen().getTablePanel4().getLblShinseiSu();
    }

    @JsonIgnore
    public TextBoxNum getTxtFukushiShisetsuShinseiSu() {
        return this.getTblGekihen().getTablePanel4().getTxtFukushiShisetsuShinseiSu();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenShisetsuShinseiSu() {
        return this.getTblGekihen().getTablePanel4().getTxtHokenShisetsuShinseiSu();
    }

    @JsonIgnore
    public TextBoxNum getTxtIryoShisetsuShinseiSu() {
        return this.getTblGekihen().getTablePanel4().getTxtIryoShisetsuShinseiSu();
    }

    @JsonIgnore
    public TextBoxNum getTxtSeiKatsuKaigoShinseiSu() {
        return this.getTblGekihen().getTablePanel4().getTxtSeiKatsuKaigoShinseiSu();
    }

    @JsonIgnore
    public TextBoxNum getTxtSonotaShinseiSu() {
        return this.getTblGekihen().getTablePanel4().getTxtSonotaShinseiSu();
    }

    @JsonIgnore
    public TextBoxNum getTxtKeiShinseiSu() {
        return this.getTblGekihen().getTablePanel4().getTxtKeiShinseiSu();
    }

    @JsonIgnore
    public Label getLblFukushiShisetsuShokuji() {
        return this.getTblGekihen().getTablePanel4().getLblFukushiShisetsuShokuji();
    }

    @JsonIgnore
    public Label getLblFukushiShisetsuKyojuhi() {
        return this.getTblGekihen().getTablePanel4().getLblFukushiShisetsuKyojuhi();
    }

    @JsonIgnore
    public Label getLblHokenShisetsuShokuji() {
        return this.getTblGekihen().getTablePanel4().getLblHokenShisetsuShokuji();
    }

    @JsonIgnore
    public Label getLblHokenShisetsuKyojuhi() {
        return this.getTblGekihen().getTablePanel4().getLblHokenShisetsuKyojuhi();
    }

    @JsonIgnore
    public Label getLblIryoShisetsuShokuji() {
        return this.getTblGekihen().getTablePanel4().getLblIryoShisetsuShokuji();
    }

    @JsonIgnore
    public Label getLblIryoShisetsuKyojuhi() {
        return this.getTblGekihen().getTablePanel4().getLblIryoShisetsuKyojuhi();
    }

    @JsonIgnore
    public Label getLblSeiKatsuKaigoShisetsuShokuji() {
        return this.getTblGekihen().getTablePanel4().getLblSeiKatsuKaigoShisetsuShokuji();
    }

    @JsonIgnore
    public Label getLblSeikatsuKaigoShisetsuKyojuhi() {
        return this.getTblGekihen().getTablePanel4().getLblSeikatsuKaigoShisetsuKyojuhi();
    }

    @JsonIgnore
    public Label getLblSonotaShisetsuShokuji() {
        return this.getTblGekihen().getTablePanel4().getLblSonotaShisetsuShokuji();
    }

    @JsonIgnore
    public Label getLblSonotaShisetsuKyojuhi() {
        return this.getTblGekihen().getTablePanel4().getLblSonotaShisetsuKyojuhi();
    }

    @JsonIgnore
    public Label getLblKeiShokuji() {
        return this.getTblGekihen().getTablePanel4().getLblKeiShokuji();
    }

    @JsonIgnore
    public Label getLblKeiKyojuhi() {
        return this.getTblGekihen().getTablePanel4().getLblKeiKyojuhi();
    }

    @JsonIgnore
    public Label getLblDaisanDankaiSu() {
        return this.getTblGekihen().getTablePanel4().getLblDaisanDankaiSu();
    }

    @JsonIgnore
    public TextBoxNum getTxtFukushiShisetsuDaisanDankaiShokujihi() {
        return this.getTblGekihen().getTablePanel4().getTxtFukushiShisetsuDaisanDankaiShokujihi();
    }

    @JsonIgnore
    public TextBoxNum getTxtFukushiShisetsuDaisanDankaiKyojuhi() {
        return this.getTblGekihen().getTablePanel4().getTxtFukushiShisetsuDaisanDankaiKyojuhi();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenShisetsuDaisanDankaiShokujihi() {
        return this.getTblGekihen().getTablePanel4().getTxtHokenShisetsuDaisanDankaiShokujihi();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenShisetsuDaisanDankaiKyojuhi() {
        return this.getTblGekihen().getTablePanel4().getTxtHokenShisetsuDaisanDankaiKyojuhi();
    }

    @JsonIgnore
    public TextBoxNum getTxtIryoShisetsuDaisanDankaiShokujihi() {
        return this.getTblGekihen().getTablePanel4().getTxtIryoShisetsuDaisanDankaiShokujihi();
    }

    @JsonIgnore
    public TextBoxNum getTxtIryoShisetsuDaisanDankaiKyojuhi() {
        return this.getTblGekihen().getTablePanel4().getTxtIryoShisetsuDaisanDankaiKyojuhi();
    }

    @JsonIgnore
    public TextBoxNum getTxtSeikatsuKaigoShisetsuDaisanDankaiShokujihi() {
        return this.getTblGekihen().getTablePanel4().getTxtSeikatsuKaigoShisetsuDaisanDankaiShokujihi();
    }

    @JsonIgnore
    public TextBoxNum getTxtSeikatsuKaigoShisetsuDaisanDankaiKyojuhi() {
        return this.getTblGekihen().getTablePanel4().getTxtSeikatsuKaigoShisetsuDaisanDankaiKyojuhi();
    }

    @JsonIgnore
    public TextBoxNum getTxtSonotaShisetsuDaisanDankaiShokujihi() {
        return this.getTblGekihen().getTablePanel4().getTxtSonotaShisetsuDaisanDankaiShokujihi();
    }

    @JsonIgnore
    public TextBoxNum getTxtSonotaShisetsuDaisanDankaiKyojuhi() {
        return this.getTblGekihen().getTablePanel4().getTxtSonotaShisetsuDaisanDankaiKyojuhi();
    }

    @JsonIgnore
    public TextBoxNum getTxtKeiDaisanDankaiShokujihi() {
        return this.getTblGekihen().getTablePanel4().getTxtKeiDaisanDankaiShokujihi();
    }

    @JsonIgnore
    public TextBoxNum getTxtKeiDaisanDankaiKyojuhi() {
        return this.getTblGekihen().getTablePanel4().getTxtKeiDaisanDankaiKyojuhi();
    }

    @JsonIgnore
    public Label getLblDaisanDankaiToGetsumatsuSu() {
        return this.getTblGekihen().getTablePanel4().getLblDaisanDankaiToGetsumatsuSu();
    }

    @JsonIgnore
    public TextBoxNum getTxtFukushiShisetsuDaisanDankaiToGetsumatsuShokujihi() {
        return this.getTblGekihen().getTablePanel4().getTxtFukushiShisetsuDaisanDankaiToGetsumatsuShokujihi();
    }

    @JsonIgnore
    public TextBoxNum getTxtFukushiShisetsuDaisanDankaiToGetsumatsuKyojuhi() {
        return this.getTblGekihen().getTablePanel4().getTxtFukushiShisetsuDaisanDankaiToGetsumatsuKyojuhi();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenShisetsuDaisanDankaiToGetsumatsuShokujihi() {
        return this.getTblGekihen().getTablePanel4().getTxtHokenShisetsuDaisanDankaiToGetsumatsuShokujihi();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenShisetsuDaisanDankaiToGetsumatsuKyojuhi() {
        return this.getTblGekihen().getTablePanel4().getTxtHokenShisetsuDaisanDankaiToGetsumatsuKyojuhi();
    }

    @JsonIgnore
    public TextBoxNum getTxtIryoShisetsuDaisanDankaiToGetsumatsuShokujihi() {
        return this.getTblGekihen().getTablePanel4().getTxtIryoShisetsuDaisanDankaiToGetsumatsuShokujihi();
    }

    @JsonIgnore
    public TextBoxNum getTxtIryoShisetsuDaisanDankaiToGetsumatsuKyojuhi() {
        return this.getTblGekihen().getTablePanel4().getTxtIryoShisetsuDaisanDankaiToGetsumatsuKyojuhi();
    }

    @JsonIgnore
    public TextBoxNum getTxtSeikatsuKaigoShisetsuDaisanDankaiToGetsumatsuShokujihi() {
        return this.getTblGekihen().getTablePanel4().getTxtSeikatsuKaigoShisetsuDaisanDankaiToGetsumatsuShokujihi();
    }

    @JsonIgnore
    public TextBoxNum getTxtSeikatsuKaigoShisetsuDaisanDankaiToGetsumatsuKyojuhi() {
        return this.getTblGekihen().getTablePanel4().getTxtSeikatsuKaigoShisetsuDaisanDankaiToGetsumatsuKyojuhi();
    }

    @JsonIgnore
    public TextBoxNum getTxtSonotaShisetsuDaisanDankaiToGetsumatsuShokujihi() {
        return this.getTblGekihen().getTablePanel4().getTxtSonotaShisetsuDaisanDankaiToGetsumatsuShokujihi();
    }

    @JsonIgnore
    public TextBoxNum getTxtSonotaShisetsuDaisanDankaiToGetsumatsuKyojuhi() {
        return this.getTblGekihen().getTablePanel4().getTxtSonotaShisetsuDaisanDankaiToGetsumatsuKyojuhi();
    }

    @JsonIgnore
    public TextBoxNum getTxtKeiDaisanDankaiToGetsumatsuShokujihi() {
        return this.getTblGekihen().getTablePanel4().getTxtKeiDaisanDankaiToGetsumatsuShokujihi();
    }

    @JsonIgnore
    public TextBoxNum getTxtKeiDaisanDankaiToGetsumatsuKyojuhi() {
        return this.getTblGekihen().getTablePanel4().getTxtKeiDaisanDankaiToGetsumatsuKyojuhi();
    }

    @JsonIgnore
    public Label getLblDainiDankaiSu() {
        return this.getTblGekihen().getTablePanel4().getLblDainiDankaiSu();
    }

    @JsonIgnore
    public TextBoxNum getTxtFukushiShisetsuDainiDankaiShokujihi() {
        return this.getTblGekihen().getTablePanel4().getTxtFukushiShisetsuDainiDankaiShokujihi();
    }

    @JsonIgnore
    public TextBoxNum getTxtFukushiShisetsuDainiDankaiKyojuhi() {
        return this.getTblGekihen().getTablePanel4().getTxtFukushiShisetsuDainiDankaiKyojuhi();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenShisetsuDainiDankaiShokujihi() {
        return this.getTblGekihen().getTablePanel4().getTxtHokenShisetsuDainiDankaiShokujihi();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenShisetsuDainiDankaiKyojuhi() {
        return this.getTblGekihen().getTablePanel4().getTxtHokenShisetsuDainiDankaiKyojuhi();
    }

    @JsonIgnore
    public TextBoxNum getTxtIryoShisetsuDainiDankaiShokujihi() {
        return this.getTblGekihen().getTablePanel4().getTxtIryoShisetsuDainiDankaiShokujihi();
    }

    @JsonIgnore
    public TextBoxNum getTxtIryoShisetsuDainiDankaiKyojuhi() {
        return this.getTblGekihen().getTablePanel4().getTxtIryoShisetsuDainiDankaiKyojuhi();
    }

    @JsonIgnore
    public TextBoxNum getTxtSeikatsuKaigoShisetsuDainiDankaiShokujihi() {
        return this.getTblGekihen().getTablePanel4().getTxtSeikatsuKaigoShisetsuDainiDankaiShokujihi();
    }

    @JsonIgnore
    public TextBoxNum getTxtSeikatsuKaigoShisetsuDainiDankaiKyojuhi() {
        return this.getTblGekihen().getTablePanel4().getTxtSeikatsuKaigoShisetsuDainiDankaiKyojuhi();
    }

    @JsonIgnore
    public TextBoxNum getTxtSonotaShisetsuDainiDankaiShokujihi() {
        return this.getTblGekihen().getTablePanel4().getTxtSonotaShisetsuDainiDankaiShokujihi();
    }

    @JsonIgnore
    public TextBoxNum getTxtSonotaShisetsuDainiDankaiKyojuhi() {
        return this.getTblGekihen().getTablePanel4().getTxtSonotaShisetsuDainiDankaiKyojuhi();
    }

    @JsonIgnore
    public TextBoxNum getTxtKeiDainiDankaiShokujihi() {
        return this.getTblGekihen().getTablePanel4().getTxtKeiDainiDankaiShokujihi();
    }

    @JsonIgnore
    public TextBoxNum getTxtKeiDainiDankaiKyojuhi() {
        return this.getTblGekihen().getTablePanel4().getTxtKeiDainiDankaiKyojuhi();
    }

    @JsonIgnore
    public Label getLblDainiDankaiToGetsumatsuSu() {
        return this.getTblGekihen().getTablePanel4().getLblDainiDankaiToGetsumatsuSu();
    }

    @JsonIgnore
    public TextBoxNum getTextBoxNum31() {
        return this.getTblGekihen().getTablePanel4().getTextBoxNum31();
    }

    @JsonIgnore
    public TextBoxNum getTxtFukushiShisetsuDainiDankaiToGetsumatsuKyojuhi() {
        return this.getTblGekihen().getTablePanel4().getTxtFukushiShisetsuDainiDankaiToGetsumatsuKyojuhi();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenShisetsuDainiDankaiToGetsumatsuShokujihi() {
        return this.getTblGekihen().getTablePanel4().getTxtHokenShisetsuDainiDankaiToGetsumatsuShokujihi();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenShisetsuDainiDankaiToGetsumatsuKyojuhi() {
        return this.getTblGekihen().getTablePanel4().getTxtHokenShisetsuDainiDankaiToGetsumatsuKyojuhi();
    }

    @JsonIgnore
    public TextBoxNum getTxtIryoShisetsuDainiDankaiToGetsumatsuShokujihi() {
        return this.getTblGekihen().getTablePanel4().getTxtIryoShisetsuDainiDankaiToGetsumatsuShokujihi();
    }

    @JsonIgnore
    public TextBoxNum getTxtIryoShisetsuDainiDankaiToGetsumatsuKyojuhi() {
        return this.getTblGekihen().getTablePanel4().getTxtIryoShisetsuDainiDankaiToGetsumatsuKyojuhi();
    }

    @JsonIgnore
    public TextBoxNum getTxtSeikatsuKaigoShisetsuDainiDankaiToGetsumatsuShokujihi() {
        return this.getTblGekihen().getTablePanel4().getTxtSeikatsuKaigoShisetsuDainiDankaiToGetsumatsuShokujihi();
    }

    @JsonIgnore
    public TextBoxNum getTxtSeikatsuKaigoShisetsuDainiDankaiToGetsumatsuKyojuhi() {
        return this.getTblGekihen().getTablePanel4().getTxtSeikatsuKaigoShisetsuDainiDankaiToGetsumatsuKyojuhi();
    }

    @JsonIgnore
    public TextBoxNum getTxtSonotaShisetsuDaiichiDankaiToGetsumatsuShokujihi() {
        return this.getTblGekihen().getTablePanel4().getTxtSonotaShisetsuDaiichiDankaiToGetsumatsuShokujihi();
    }

    @JsonIgnore
    public TextBoxNum getTxtSonotaShisetsuDainiDankaiToGetsumatsuKyojuhi() {
        return this.getTblGekihen().getTablePanel4().getTxtSonotaShisetsuDainiDankaiToGetsumatsuKyojuhi();
    }

    @JsonIgnore
    public TextBoxNum getTxtKeiDainiDankaiToGetsumatsuShokujihi() {
        return this.getTblGekihen().getTablePanel4().getTxtKeiDainiDankaiToGetsumatsuShokujihi();
    }

    @JsonIgnore
    public TextBoxNum getTxtKeiDainiDankaiToGetsumatsuKyojuhi() {
        return this.getTblGekihen().getTablePanel4().getTxtKeiDainiDankaiToGetsumatsuKyojuhi();
    }

    @JsonIgnore
    public TablePanel3Div getTablePanel3() {
        return this.getTblDaiyonDankai().getTablePanel3();
    }

    @JsonIgnore
    public void  setTablePanel3(TablePanel3Div TablePanel3) {
        this.getTblDaiyonDankai().setTablePanel3(TablePanel3);
    }

    @JsonIgnore
    public Label getLblDanichigouHihokensha() {
        return this.getTblDaiyonDankai().getTablePanel3().getLblDanichigouHihokensha();
    }

    @JsonIgnore
    public Label getLblDannigouHihokensha() {
        return this.getTblDaiyonDankai().getTablePanel3().getLblDannigouHihokensha();
    }

    @JsonIgnore
    public Label getLblGokei() {
        return this.getTblDaiyonDankai().getTablePanel3().getLblGokei();
    }

    @JsonIgnore
    public Label getLblDaiyonDankaiShinseiSu() {
        return this.getTblDaiyonDankai().getTablePanel3().getLblDaiyonDankaiShinseiSu();
    }

    @JsonIgnore
    public TextBoxNum getTxtDanichigouShinseiSu() {
        return this.getTblDaiyonDankai().getTablePanel3().getTxtDanichigouShinseiSu();
    }

    @JsonIgnore
    public TextBoxNum getTxtDannigouShinseiSu() {
        return this.getTblDaiyonDankai().getTablePanel3().getTxtDannigouShinseiSu();
    }

    @JsonIgnore
    public TextBoxNum getTxtGokeiShinseiSu() {
        return this.getTblDaiyonDankai().getTablePanel3().getTxtGokeiShinseiSu();
    }

    @JsonIgnore
    public Label getLblShokujihiGengakuNinteiSu() {
        return this.getTblDaiyonDankai().getTablePanel3().getLblShokujihiGengakuNinteiSu();
    }

    @JsonIgnore
    public TextBoxNum getTxtDanichigouShokujihiGengakuNinteiSu() {
        return this.getTblDaiyonDankai().getTablePanel3().getTxtDanichigouShokujihiGengakuNinteiSu();
    }

    @JsonIgnore
    public TextBoxNum getTxtDannigouShokujihiGengakuNinteiSu() {
        return this.getTblDaiyonDankai().getTablePanel3().getTxtDannigouShokujihiGengakuNinteiSu();
    }

    @JsonIgnore
    public TextBoxNum getTxtGokeiShokujihiGengakuNinteiSu() {
        return this.getTblDaiyonDankai().getTablePanel3().getTxtGokeiShokujihiGengakuNinteiSu();
    }

    @JsonIgnore
    public Label getLblShokujiGengakuNinteiKei() {
        return this.getTblDaiyonDankai().getTablePanel3().getLblShokujiGengakuNinteiKei();
    }

    @JsonIgnore
    public TextBoxNum getTxtDanichigouShokujiGengakuNinteiKei() {
        return this.getTblDaiyonDankai().getTablePanel3().getTxtDanichigouShokujiGengakuNinteiKei();
    }

    @JsonIgnore
    public TextBoxNum getTxtDannigouShokujiGengakuNinteiKei() {
        return this.getTblDaiyonDankai().getTablePanel3().getTxtDannigouShokujiGengakuNinteiKei();
    }

    @JsonIgnore
    public TextBoxNum getTxtGokeiShokujiGengakuNinteiKei() {
        return this.getTblDaiyonDankai().getTablePanel3().getTxtGokeiShokujiGengakuNinteiKei();
    }

    @JsonIgnore
    public Label getLblKyojuhiGengakuNinteiSu() {
        return this.getTblDaiyonDankai().getTablePanel3().getLblKyojuhiGengakuNinteiSu();
    }

    @JsonIgnore
    public TextBoxNum getTxtDanichigouKyojuhiGengakuNinteiSu() {
        return this.getTblDaiyonDankai().getTablePanel3().getTxtDanichigouKyojuhiGengakuNinteiSu();
    }

    @JsonIgnore
    public TextBoxNum getTxtDannigouKyojuhiGengakuNinteiSu() {
        return this.getTblDaiyonDankai().getTablePanel3().getTxtDannigouKyojuhiGengakuNinteiSu();
    }

    @JsonIgnore
    public TextBoxNum getTxtGokeiKyojuhiGengakuNinteiSu() {
        return this.getTblDaiyonDankai().getTablePanel3().getTxtGokeiKyojuhiGengakuNinteiSu();
    }

    @JsonIgnore
    public Label getLblKyojuhiGengakuNinteiKei() {
        return this.getTblDaiyonDankai().getTablePanel3().getLblKyojuhiGengakuNinteiKei();
    }

    @JsonIgnore
    public TextBoxNum getTxtDanichigouKyojuhiGengakuNinteiKei() {
        return this.getTblDaiyonDankai().getTablePanel3().getTxtDanichigouKyojuhiGengakuNinteiKei();
    }

    @JsonIgnore
    public TextBoxNum getTxtDannigouKyojuhiGengakuNinteiKei() {
        return this.getTblDaiyonDankai().getTablePanel3().getTxtDannigouKyojuhiGengakuNinteiKei();
    }

    @JsonIgnore
    public TextBoxNum getTxtGokeiKyojuhiGengakuNinteiKei() {
        return this.getTblDaiyonDankai().getTablePanel3().getTxtGokeiKyojuhiGengakuNinteiKei();
    }

    @JsonIgnore
    public Label getLblSJGengakuNinteiSu() {
        return this.getTblDaiyonDankai().getTablePanel3().getLblSJGengakuNinteiSu();
    }

    @JsonIgnore
    public TextBoxNum getTxtDanichigouSJGengakuNinteiSu() {
        return this.getTblDaiyonDankai().getTablePanel3().getTxtDanichigouSJGengakuNinteiSu();
    }

    @JsonIgnore
    public TextBoxNum getTxtDannigouSJGengakuNinteiSu() {
        return this.getTblDaiyonDankai().getTablePanel3().getTxtDannigouSJGengakuNinteiSu();
    }

    @JsonIgnore
    public TextBoxNum getTxtGokeiSJGengakuNinteiSu() {
        return this.getTblDaiyonDankai().getTablePanel3().getTxtGokeiSJGengakuNinteiSu();
    }

    @JsonIgnore
    public Label getLblSJGengakuNinteiKei() {
        return this.getTblDaiyonDankai().getTablePanel3().getLblSJGengakuNinteiKei();
    }

    @JsonIgnore
    public TextBoxNum getTxtDanichigouSJGengakuNinteiKei() {
        return this.getTblDaiyonDankai().getTablePanel3().getTxtDanichigouSJGengakuNinteiKei();
    }

    @JsonIgnore
    public TextBoxNum getTxtDannigouSJGengakuNinteiKei() {
        return this.getTblDaiyonDankai().getTablePanel3().getTxtDannigouSJGengakuNinteiKei();
    }

    @JsonIgnore
    public TextBoxNum getTxtGokeiSJGengakuNinteiKei() {
        return this.getTblDaiyonDankai().getTablePanel3().getTxtGokeiSJGengakuNinteiKei();
    }

    // </editor-fold>
}
