package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * AtenaInfoToroku のクラスファイル 
 * 
 * @author 自動生成
 */
public class AtenaInfoTorokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-14_20-51-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("Meisho")
    private TextBoxAtenaMeisho Meisho;
    @JsonProperty("Seinengabi")
    private TextBoxDate Seinengabi;
    @JsonProperty("Nenrei")
    private TextBoxNum Nenrei;
    @JsonProperty("Seibetsu")
    private TextBox Seibetsu;
    @JsonProperty("YubinNo")
    private TextBoxYubinNo YubinNo;
    @JsonProperty("Jusho")
    private TextBoxJusho Jusho;
    @JsonProperty("TelNo")
    private TextBoxTelNo TelNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getMeisho
     * @return Meisho
     */
    @JsonProperty("Meisho")
    public TextBoxAtenaMeisho getMeisho() {
        return Meisho;
    }

    /*
     * setMeisho
     * @param Meisho Meisho
     */
    @JsonProperty("Meisho")
    public void setMeisho(TextBoxAtenaMeisho Meisho) {
        this.Meisho = Meisho;
    }

    /*
     * getSeinengabi
     * @return Seinengabi
     */
    @JsonProperty("Seinengabi")
    public TextBoxDate getSeinengabi() {
        return Seinengabi;
    }

    /*
     * setSeinengabi
     * @param Seinengabi Seinengabi
     */
    @JsonProperty("Seinengabi")
    public void setSeinengabi(TextBoxDate Seinengabi) {
        this.Seinengabi = Seinengabi;
    }

    /*
     * getNenrei
     * @return Nenrei
     */
    @JsonProperty("Nenrei")
    public TextBoxNum getNenrei() {
        return Nenrei;
    }

    /*
     * setNenrei
     * @param Nenrei Nenrei
     */
    @JsonProperty("Nenrei")
    public void setNenrei(TextBoxNum Nenrei) {
        this.Nenrei = Nenrei;
    }

    /*
     * getSeibetsu
     * @return Seibetsu
     */
    @JsonProperty("Seibetsu")
    public TextBox getSeibetsu() {
        return Seibetsu;
    }

    /*
     * setSeibetsu
     * @param Seibetsu Seibetsu
     */
    @JsonProperty("Seibetsu")
    public void setSeibetsu(TextBox Seibetsu) {
        this.Seibetsu = Seibetsu;
    }

    /*
     * getYubinNo
     * @return YubinNo
     */
    @JsonProperty("YubinNo")
    public TextBoxYubinNo getYubinNo() {
        return YubinNo;
    }

    /*
     * setYubinNo
     * @param YubinNo YubinNo
     */
    @JsonProperty("YubinNo")
    public void setYubinNo(TextBoxYubinNo YubinNo) {
        this.YubinNo = YubinNo;
    }

    /*
     * getJusho
     * @return Jusho
     */
    @JsonProperty("Jusho")
    public TextBoxJusho getJusho() {
        return Jusho;
    }

    /*
     * setJusho
     * @param Jusho Jusho
     */
    @JsonProperty("Jusho")
    public void setJusho(TextBoxJusho Jusho) {
        this.Jusho = Jusho;
    }

    /*
     * getTelNo
     * @return TelNo
     */
    @JsonProperty("TelNo")
    public TextBoxTelNo getTelNo() {
        return TelNo;
    }

    /*
     * setTelNo
     * @param TelNo TelNo
     */
    @JsonProperty("TelNo")
    public void setTelNo(TextBoxTelNo TelNo) {
        this.TelNo = TelNo;
    }

    // </editor-fold>
}
