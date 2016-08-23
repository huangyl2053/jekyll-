package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA8010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShikakuShutokushaFuseigouList のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShikakuShutokushaFuseigouListDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SerachJouken")
    private Label SerachJouken;
    @JsonProperty("Space1")
    private Space Space1;
    @JsonProperty("AllTaishou")
    private RadioButton AllTaishou;
    @JsonProperty("ShikakuTyofukusha")
    private RadioButton ShikakuTyofukusha;
    @JsonProperty("Fuseigou")
    private RadioButton Fuseigou;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getSerachJouken
     * @return SerachJouken
     */
    @JsonProperty("SerachJouken")
    public Label getSerachJouken() {
        return SerachJouken;
    }

    /*
     * setSerachJouken
     * @param SerachJouken SerachJouken
     */
    @JsonProperty("SerachJouken")
    public void setSerachJouken(Label SerachJouken) {
        this.SerachJouken = SerachJouken;
    }

    /*
     * getSpace1
     * @return Space1
     */
    @JsonProperty("Space1")
    public Space getSpace1() {
        return Space1;
    }

    /*
     * setSpace1
     * @param Space1 Space1
     */
    @JsonProperty("Space1")
    public void setSpace1(Space Space1) {
        this.Space1 = Space1;
    }

    /*
     * getAllTaishou
     * @return AllTaishou
     */
    @JsonProperty("AllTaishou")
    public RadioButton getAllTaishou() {
        return AllTaishou;
    }

    /*
     * setAllTaishou
     * @param AllTaishou AllTaishou
     */
    @JsonProperty("AllTaishou")
    public void setAllTaishou(RadioButton AllTaishou) {
        this.AllTaishou = AllTaishou;
    }

    /*
     * getShikakuTyofukusha
     * @return ShikakuTyofukusha
     */
    @JsonProperty("ShikakuTyofukusha")
    public RadioButton getShikakuTyofukusha() {
        return ShikakuTyofukusha;
    }

    /*
     * setShikakuTyofukusha
     * @param ShikakuTyofukusha ShikakuTyofukusha
     */
    @JsonProperty("ShikakuTyofukusha")
    public void setShikakuTyofukusha(RadioButton ShikakuTyofukusha) {
        this.ShikakuTyofukusha = ShikakuTyofukusha;
    }

    /*
     * getFuseigou
     * @return Fuseigou
     */
    @JsonProperty("Fuseigou")
    public RadioButton getFuseigou() {
        return Fuseigou;
    }

    /*
     * setFuseigou
     * @param Fuseigou Fuseigou
     */
    @JsonProperty("Fuseigou")
    public void setFuseigou(RadioButton Fuseigou) {
        this.Fuseigou = Fuseigou;
    }

    // </editor-fold>
}
