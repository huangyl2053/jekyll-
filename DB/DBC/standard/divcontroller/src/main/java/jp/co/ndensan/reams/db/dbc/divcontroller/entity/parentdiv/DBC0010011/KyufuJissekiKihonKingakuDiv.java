package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KyufuJissekiKihonKingaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyufuJissekiKihonKingakuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtServiceTankasu")
    private TextBoxNum txtServiceTankasu;
    @JsonProperty("txtHokenryoSeikyuGaku")
    private TextBoxNum txtHokenryoSeikyuGaku;
    @JsonProperty("txtRiyoshaFutanGaku")
    private TextBoxNum txtRiyoshaFutanGaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtServiceTankasu
     * @return txtServiceTankasu
     */
    @JsonProperty("txtServiceTankasu")
    public TextBoxNum getTxtServiceTankasu() {
        return txtServiceTankasu;
    }

    /*
     * settxtServiceTankasu
     * @param txtServiceTankasu txtServiceTankasu
     */
    @JsonProperty("txtServiceTankasu")
    public void setTxtServiceTankasu(TextBoxNum txtServiceTankasu) {
        this.txtServiceTankasu = txtServiceTankasu;
    }

    /*
     * gettxtHokenryoSeikyuGaku
     * @return txtHokenryoSeikyuGaku
     */
    @JsonProperty("txtHokenryoSeikyuGaku")
    public TextBoxNum getTxtHokenryoSeikyuGaku() {
        return txtHokenryoSeikyuGaku;
    }

    /*
     * settxtHokenryoSeikyuGaku
     * @param txtHokenryoSeikyuGaku txtHokenryoSeikyuGaku
     */
    @JsonProperty("txtHokenryoSeikyuGaku")
    public void setTxtHokenryoSeikyuGaku(TextBoxNum txtHokenryoSeikyuGaku) {
        this.txtHokenryoSeikyuGaku = txtHokenryoSeikyuGaku;
    }

    /*
     * gettxtRiyoshaFutanGaku
     * @return txtRiyoshaFutanGaku
     */
    @JsonProperty("txtRiyoshaFutanGaku")
    public TextBoxNum getTxtRiyoshaFutanGaku() {
        return txtRiyoshaFutanGaku;
    }

    /*
     * settxtRiyoshaFutanGaku
     * @param txtRiyoshaFutanGaku txtRiyoshaFutanGaku
     */
    @JsonProperty("txtRiyoshaFutanGaku")
    public void setTxtRiyoshaFutanGaku(TextBoxNum txtRiyoshaFutanGaku) {
        this.txtRiyoshaFutanGaku = txtRiyoshaFutanGaku;
    }

    // </editor-fold>
}
