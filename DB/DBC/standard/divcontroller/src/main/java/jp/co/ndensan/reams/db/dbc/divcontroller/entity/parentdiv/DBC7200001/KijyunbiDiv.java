package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7200001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Kijyunbi のクラスファイル 
 * 
 * @author 自動生成
 */
public class KijyunbiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("Yohaku2")
    private Space Yohaku2;
    @JsonProperty("txtKijyunnNengetsu")
    private TextBoxDate txtKijyunnNengetsu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getYohaku2
     * @return Yohaku2
     */
    @JsonProperty("Yohaku2")
    public Space getYohaku2() {
        return Yohaku2;
    }

    /*
     * setYohaku2
     * @param Yohaku2 Yohaku2
     */
    @JsonProperty("Yohaku2")
    public void setYohaku2(Space Yohaku2) {
        this.Yohaku2 = Yohaku2;
    }

    /*
     * gettxtKijyunnNengetsu
     * @return txtKijyunnNengetsu
     */
    @JsonProperty("txtKijyunnNengetsu")
    public TextBoxDate getTxtKijyunnNengetsu() {
        return txtKijyunnNengetsu;
    }

    /*
     * settxtKijyunnNengetsu
     * @param txtKijyunnNengetsu txtKijyunnNengetsu
     */
    @JsonProperty("txtKijyunnNengetsu")
    public void setTxtKijyunnNengetsu(TextBoxDate txtKijyunnNengetsu) {
        this.txtKijyunnNengetsu = txtKijyunnNengetsu;
    }

    // </editor-fold>
}
