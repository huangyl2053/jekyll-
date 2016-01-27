package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput.KihonChosaInput.IKihonChosaInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput.KihonChosaInput.KihonChosaInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;

/**
 * tabKihonChosaShurui のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabKihonChosaShuruiDiv extends TabContainer {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tplIchigun")
    private tplIchigunDiv tplIchigun;
    @JsonProperty("tplNigun")
    private tplNigunDiv tplNigun;
    @JsonProperty("tplSangun")
    private tplSangunDiv tplSangun;
    @JsonProperty("tplYongun")
    private tplYongunDiv tplYongun;
    @JsonProperty("tplGogun")
    private tplGogunDiv tplGogun;
    @JsonProperty("tplTokubetsuIryo")
    private tplTokubetsuIryoDiv tplTokubetsuIryo;
    @JsonProperty("tplSeikatsuJiritsudo")
    private tplSeikatsuJiritsudoDiv tplSeikatsuJiritsudo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettplIchigun
     * @return tplIchigun
     */
    @JsonProperty("tplIchigun")
    public tplIchigunDiv getTplIchigun() {
        return tplIchigun;
    }

    /*
     * settplIchigun
     * @param tplIchigun tplIchigun
     */
    @JsonProperty("tplIchigun")
    public void setTplIchigun(tplIchigunDiv tplIchigun) {
        this.tplIchigun = tplIchigun;
    }

    /*
     * gettplNigun
     * @return tplNigun
     */
    @JsonProperty("tplNigun")
    public tplNigunDiv getTplNigun() {
        return tplNigun;
    }

    /*
     * settplNigun
     * @param tplNigun tplNigun
     */
    @JsonProperty("tplNigun")
    public void setTplNigun(tplNigunDiv tplNigun) {
        this.tplNigun = tplNigun;
    }

    /*
     * gettplSangun
     * @return tplSangun
     */
    @JsonProperty("tplSangun")
    public tplSangunDiv getTplSangun() {
        return tplSangun;
    }

    /*
     * settplSangun
     * @param tplSangun tplSangun
     */
    @JsonProperty("tplSangun")
    public void setTplSangun(tplSangunDiv tplSangun) {
        this.tplSangun = tplSangun;
    }

    /*
     * gettplYongun
     * @return tplYongun
     */
    @JsonProperty("tplYongun")
    public tplYongunDiv getTplYongun() {
        return tplYongun;
    }

    /*
     * settplYongun
     * @param tplYongun tplYongun
     */
    @JsonProperty("tplYongun")
    public void setTplYongun(tplYongunDiv tplYongun) {
        this.tplYongun = tplYongun;
    }

    /*
     * gettplGogun
     * @return tplGogun
     */
    @JsonProperty("tplGogun")
    public tplGogunDiv getTplGogun() {
        return tplGogun;
    }

    /*
     * settplGogun
     * @param tplGogun tplGogun
     */
    @JsonProperty("tplGogun")
    public void setTplGogun(tplGogunDiv tplGogun) {
        this.tplGogun = tplGogun;
    }

    /*
     * gettplTokubetsuIryo
     * @return tplTokubetsuIryo
     */
    @JsonProperty("tplTokubetsuIryo")
    public tplTokubetsuIryoDiv getTplTokubetsuIryo() {
        return tplTokubetsuIryo;
    }

    /*
     * settplTokubetsuIryo
     * @param tplTokubetsuIryo tplTokubetsuIryo
     */
    @JsonProperty("tplTokubetsuIryo")
    public void setTplTokubetsuIryo(tplTokubetsuIryoDiv tplTokubetsuIryo) {
        this.tplTokubetsuIryo = tplTokubetsuIryo;
    }

    /*
     * gettplSeikatsuJiritsudo
     * @return tplSeikatsuJiritsudo
     */
    @JsonProperty("tplSeikatsuJiritsudo")
    public tplSeikatsuJiritsudoDiv getTplSeikatsuJiritsudo() {
        return tplSeikatsuJiritsudo;
    }

    /*
     * settplSeikatsuJiritsudo
     * @param tplSeikatsuJiritsudo tplSeikatsuJiritsudo
     */
    @JsonProperty("tplSeikatsuJiritsudo")
    public void setTplSeikatsuJiritsudo(tplSeikatsuJiritsudoDiv tplSeikatsuJiritsudo) {
        this.tplSeikatsuJiritsudo = tplSeikatsuJiritsudo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IKihonChosaInputDiv getCcdIchigunKihonChosa() {
        return this.getTplIchigun().getCcdIchigunKihonChosa();
    }

    @JsonIgnore
    public IKihonChosaInputDiv getCcdNigunKihonChosa() {
        return this.getTplNigun().getCcdNigunKihonChosa();
    }

    @JsonIgnore
    public IKihonChosaInputDiv getCcdSangunKihonChosa() {
        return this.getTplSangun().getCcdSangunKihonChosa();
    }

    @JsonIgnore
    public IKihonChosaInputDiv getCcdYongunKihonChosa() {
        return this.getTplYongun().getCcdYongunKihonChosa();
    }

    @JsonIgnore
    public IKihonChosaInputDiv getCcdGogun() {
        return this.getTplGogun().getCcdGogun();
    }

    @JsonIgnore
    public IKihonChosaInputDiv getCcdTokubetsuIryoKihonChosa() {
        return this.getTplTokubetsuIryo().getCcdTokubetsuIryoKihonChosa();
    }

    @JsonIgnore
    public IKihonChosaInputDiv getCcdSeikatsuJiritsudoKihonchosa() {
        return this.getTplSeikatsuJiritsudo().getCcdSeikatsuJiritsudoKihonchosa();
    }

    // </editor-fold>
}
