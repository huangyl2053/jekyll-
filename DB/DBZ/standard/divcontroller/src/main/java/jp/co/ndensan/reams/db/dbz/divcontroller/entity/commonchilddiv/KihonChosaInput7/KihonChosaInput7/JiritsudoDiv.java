package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput7.KihonChosaInput7;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Jiritsudo のクラスファイル
 *
 * @author 自動生成
 */
public class JiritsudoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShogaiKoreisha")
    private ShogaiKoreishaDiv ShogaiKoreisha;
    @JsonProperty("NinchishaJiritsudo")
    private NinchishaJiritsudoDiv NinchishaJiritsudo;
    @JsonProperty("shinseishoKanriNo")
    private RString shinseishoKanriNo;
    @JsonProperty("recordNumber")
    private RString recordNumber;
    @JsonProperty("ninteichosaTokkijikoNoList")
    private RString ninteichosaTokkijikoNoList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShogaiKoreisha
     * @return ShogaiKoreisha
     */
    @JsonProperty("ShogaiKoreisha")
    public ShogaiKoreishaDiv getShogaiKoreisha() {
        return ShogaiKoreisha;
    }

    /*
     * setShogaiKoreisha
     * @param ShogaiKoreisha ShogaiKoreisha
     */
    @JsonProperty("ShogaiKoreisha")
    public void setShogaiKoreisha(ShogaiKoreishaDiv ShogaiKoreisha) {
        this.ShogaiKoreisha = ShogaiKoreisha;
    }

    /*
     * getNinchishaJiritsudo
     * @return NinchishaJiritsudo
     */
    @JsonProperty("NinchishaJiritsudo")
    public NinchishaJiritsudoDiv getNinchishaJiritsudo() {
        return NinchishaJiritsudo;
    }

    /*
     * setNinchishaJiritsudo
     * @param NinchishaJiritsudo NinchishaJiritsudo
     */
    @JsonProperty("NinchishaJiritsudo")
    public void setNinchishaJiritsudo(NinchishaJiritsudoDiv NinchishaJiritsudo) {
        this.NinchishaJiritsudo = NinchishaJiritsudo;
    }

    /*
     * getshinseishoKanriNo
     * @return shinseishoKanriNo
     */
    @JsonProperty("shinseishoKanriNo")
    public RString getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    /*
     * setshinseishoKanriNo
     * @param shinseishoKanriNo shinseishoKanriNo
     */
    @JsonProperty("shinseishoKanriNo")
    public void setShinseishoKanriNo(RString shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    /*
     * getrecordNumber
     * @return recordNumber
     */
    @JsonProperty("recordNumber")
    public RString getRecordNumber() {
        return recordNumber;
    }

    /*
     * setrecordNumber
     * @param recordNumber recordNumber
     */
    @JsonProperty("recordNumber")
    public void setRecordNumber(RString recordNumber) {
        this.recordNumber = recordNumber;
    }

    /*
     * getninteichosaTokkijikoNoList
     * @return ninteichosaTokkijikoNoList
     */
    @JsonProperty("ninteichosaTokkijikoNoList")
    public RString getNinteichosaTokkijikoNoList() {
        return ninteichosaTokkijikoNoList;
    }

    /*
     * setninteichosaTokkijikoNoList
     * @param ninteichosaTokkijikoNoList ninteichosaTokkijikoNoList
     */
    @JsonProperty("ninteichosaTokkijikoNoList")
    public void setNinteichosaTokkijikoNoList(RString ninteichosaTokkijikoNoList) {
        this.ninteichosaTokkijikoNoList = ninteichosaTokkijikoNoList;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ButtonDialog getBtnShogaiKoreisha() {
        return this.getShogaiKoreisha().getBtnShogaiKoreisha();
    }

    @JsonIgnore
    public void  setBtnShogaiKoreisha(ButtonDialog btnShogaiKoreisha) {
        this.getShogaiKoreisha().setBtnShogaiKoreisha(btnShogaiKoreisha);
    }

    @JsonIgnore
    public RadioButton getRadShogaiKoreisha() {
        return this.getShogaiKoreisha().getRadShogaiKoreisha();
    }

    @JsonIgnore
    public void  setRadShogaiKoreisha(RadioButton radShogaiKoreisha) {
        this.getShogaiKoreisha().setRadShogaiKoreisha(radShogaiKoreisha);
    }

    @JsonIgnore
    public ButtonDialog getBtnNinchishaJiritsudo() {
        return this.getNinchishaJiritsudo().getBtnNinchishaJiritsudo();
    }

    @JsonIgnore
    public void  setBtnNinchishaJiritsudo(ButtonDialog btnNinchishaJiritsudo) {
        this.getNinchishaJiritsudo().setBtnNinchishaJiritsudo(btnNinchishaJiritsudo);
    }

    @JsonIgnore
    public RadioButton getRadNinchishaJiritsudo() {
        return this.getNinchishaJiritsudo().getRadNinchishaJiritsudo();
    }

    @JsonIgnore
    public void  setRadNinchishaJiritsudo(RadioButton radNinchishaJiritsudo) {
        this.getNinchishaJiritsudo().setRadNinchishaJiritsudo(radNinchishaJiritsudo);
    }

    // </editor-fold>
}
