package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteSinseJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteSinseJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("NinteSinseJohoSinseiYYMMDD")
    private TextBoxDate NinteSinseJohoSinseiYYMMDD;
    @JsonProperty("NinteSinseJohoSinseiSyubetu")
    private TextBox NinteSinseJohoSinseiSyubetu;
    @JsonProperty("NinteSinseJohoSinseiKubunT")
    private TextBox NinteSinseJohoSinseiKubunT;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getNinteSinseJohoSinseiYYMMDD
     * @return NinteSinseJohoSinseiYYMMDD
     */
    @JsonProperty("NinteSinseJohoSinseiYYMMDD")
    public TextBoxDate getNinteSinseJohoSinseiYYMMDD() {
        return NinteSinseJohoSinseiYYMMDD;
    }

    /*
     * setNinteSinseJohoSinseiYYMMDD
     * @param NinteSinseJohoSinseiYYMMDD NinteSinseJohoSinseiYYMMDD
     */
    @JsonProperty("NinteSinseJohoSinseiYYMMDD")
    public void setNinteSinseJohoSinseiYYMMDD(TextBoxDate NinteSinseJohoSinseiYYMMDD) {
        this.NinteSinseJohoSinseiYYMMDD = NinteSinseJohoSinseiYYMMDD;
    }

    /*
     * getNinteSinseJohoSinseiSyubetu
     * @return NinteSinseJohoSinseiSyubetu
     */
    @JsonProperty("NinteSinseJohoSinseiSyubetu")
    public TextBox getNinteSinseJohoSinseiSyubetu() {
        return NinteSinseJohoSinseiSyubetu;
    }

    /*
     * setNinteSinseJohoSinseiSyubetu
     * @param NinteSinseJohoSinseiSyubetu NinteSinseJohoSinseiSyubetu
     */
    @JsonProperty("NinteSinseJohoSinseiSyubetu")
    public void setNinteSinseJohoSinseiSyubetu(TextBox NinteSinseJohoSinseiSyubetu) {
        this.NinteSinseJohoSinseiSyubetu = NinteSinseJohoSinseiSyubetu;
    }

    /*
     * getNinteSinseJohoSinseiKubunT
     * @return NinteSinseJohoSinseiKubunT
     */
    @JsonProperty("NinteSinseJohoSinseiKubunT")
    public TextBox getNinteSinseJohoSinseiKubunT() {
        return NinteSinseJohoSinseiKubunT;
    }

    /*
     * setNinteSinseJohoSinseiKubunT
     * @param NinteSinseJohoSinseiKubunT NinteSinseJohoSinseiKubunT
     */
    @JsonProperty("NinteSinseJohoSinseiKubunT")
    public void setNinteSinseJohoSinseiKubunT(TextBox NinteSinseJohoSinseiKubunT) {
        this.NinteSinseJohoSinseiKubunT = NinteSinseJohoSinseiKubunT;
    }

    // </editor-fold>
}
