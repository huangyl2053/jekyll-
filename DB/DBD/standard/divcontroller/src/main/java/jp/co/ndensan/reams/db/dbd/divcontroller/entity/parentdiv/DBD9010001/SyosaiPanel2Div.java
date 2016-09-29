package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD9010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SyosaiPanel2 のクラスファイル 
 * 
 * @author 自動生成
 */
public class SyosaiPanel2Div extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SakuseYYMMDD")
    private TextBoxDate SakuseYYMMDD;
    @JsonProperty("NinteFromYYMMDD")
    private TextBoxDate NinteFromYYMMDD;
    @JsonProperty("NinnteiTo")
    private Label NinnteiTo;
    @JsonProperty("NinteEndYYMMDD")
    private TextBoxDate NinteEndYYMMDD;
    @JsonProperty("NitijyoSekatuJiritudo")
    private RadioButton NitijyoSekatuJiritudo;
    @JsonProperty("Nyosikin")
    private RadioButton Nyosikin;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getSakuseYYMMDD
     * @return SakuseYYMMDD
     */
    @JsonProperty("SakuseYYMMDD")
    public TextBoxDate getSakuseYYMMDD() {
        return SakuseYYMMDD;
    }

    /*
     * setSakuseYYMMDD
     * @param SakuseYYMMDD SakuseYYMMDD
     */
    @JsonProperty("SakuseYYMMDD")
    public void setSakuseYYMMDD(TextBoxDate SakuseYYMMDD) {
        this.SakuseYYMMDD = SakuseYYMMDD;
    }

    /*
     * getNinteFromYYMMDD
     * @return NinteFromYYMMDD
     */
    @JsonProperty("NinteFromYYMMDD")
    public TextBoxDate getNinteFromYYMMDD() {
        return NinteFromYYMMDD;
    }

    /*
     * setNinteFromYYMMDD
     * @param NinteFromYYMMDD NinteFromYYMMDD
     */
    @JsonProperty("NinteFromYYMMDD")
    public void setNinteFromYYMMDD(TextBoxDate NinteFromYYMMDD) {
        this.NinteFromYYMMDD = NinteFromYYMMDD;
    }

    /*
     * getNinnteiTo
     * @return NinnteiTo
     */
    @JsonProperty("NinnteiTo")
    public Label getNinnteiTo() {
        return NinnteiTo;
    }

    /*
     * setNinnteiTo
     * @param NinnteiTo NinnteiTo
     */
    @JsonProperty("NinnteiTo")
    public void setNinnteiTo(Label NinnteiTo) {
        this.NinnteiTo = NinnteiTo;
    }

    /*
     * getNinteEndYYMMDD
     * @return NinteEndYYMMDD
     */
    @JsonProperty("NinteEndYYMMDD")
    public TextBoxDate getNinteEndYYMMDD() {
        return NinteEndYYMMDD;
    }

    /*
     * setNinteEndYYMMDD
     * @param NinteEndYYMMDD NinteEndYYMMDD
     */
    @JsonProperty("NinteEndYYMMDD")
    public void setNinteEndYYMMDD(TextBoxDate NinteEndYYMMDD) {
        this.NinteEndYYMMDD = NinteEndYYMMDD;
    }

    /*
     * getNitijyoSekatuJiritudo
     * @return NitijyoSekatuJiritudo
     */
    @JsonProperty("NitijyoSekatuJiritudo")
    public RadioButton getNitijyoSekatuJiritudo() {
        return NitijyoSekatuJiritudo;
    }

    /*
     * setNitijyoSekatuJiritudo
     * @param NitijyoSekatuJiritudo NitijyoSekatuJiritudo
     */
    @JsonProperty("NitijyoSekatuJiritudo")
    public void setNitijyoSekatuJiritudo(RadioButton NitijyoSekatuJiritudo) {
        this.NitijyoSekatuJiritudo = NitijyoSekatuJiritudo;
    }

    /*
     * getNyosikin
     * @return Nyosikin
     */
    @JsonProperty("Nyosikin")
    public RadioButton getNyosikin() {
        return Nyosikin;
    }

    /*
     * setNyosikin
     * @param Nyosikin Nyosikin
     */
    @JsonProperty("Nyosikin")
    public void setNyosikin(RadioButton Nyosikin) {
        this.Nyosikin = Nyosikin;
    }

    // </editor-fold>
}
