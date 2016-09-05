package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1720011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SogoJigyoTaishoshaToroku のクラスファイル 
 * 
 * @author 自動生成
 */
public class SogoJigyoTaishoshaTorokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("sokouUpdate")
    private sokouUpdateDiv sokouUpdate;
    @JsonProperty("SougouZigyouTaishouItiran")
    private SougouZigyouTaishouItiranDiv SougouZigyouTaishouItiran;
    @JsonProperty("SougouZigyouTaishouShousai")
    private SougouZigyouTaishouShousaiDiv SougouZigyouTaishouShousai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getsokouUpdate
     * @return sokouUpdate
     */
    @JsonProperty("sokouUpdate")
    public sokouUpdateDiv getSokouUpdate() {
        return sokouUpdate;
    }

    /*
     * setsokouUpdate
     * @param sokouUpdate sokouUpdate
     */
    @JsonProperty("sokouUpdate")
    public void setSokouUpdate(sokouUpdateDiv sokouUpdate) {
        this.sokouUpdate = sokouUpdate;
    }

    /*
     * getSougouZigyouTaishouItiran
     * @return SougouZigyouTaishouItiran
     */
    @JsonProperty("SougouZigyouTaishouItiran")
    public SougouZigyouTaishouItiranDiv getSougouZigyouTaishouItiran() {
        return SougouZigyouTaishouItiran;
    }

    /*
     * setSougouZigyouTaishouItiran
     * @param SougouZigyouTaishouItiran SougouZigyouTaishouItiran
     */
    @JsonProperty("SougouZigyouTaishouItiran")
    public void setSougouZigyouTaishouItiran(SougouZigyouTaishouItiranDiv SougouZigyouTaishouItiran) {
        this.SougouZigyouTaishouItiran = SougouZigyouTaishouItiran;
    }

    /*
     * getSougouZigyouTaishouShousai
     * @return SougouZigyouTaishouShousai
     */
    @JsonProperty("SougouZigyouTaishouShousai")
    public SougouZigyouTaishouShousaiDiv getSougouZigyouTaishouShousai() {
        return SougouZigyouTaishouShousai;
    }

    /*
     * setSougouZigyouTaishouShousai
     * @param SougouZigyouTaishouShousai SougouZigyouTaishouShousai
     */
    @JsonProperty("SougouZigyouTaishouShousai")
    public void setSougouZigyouTaishouShousai(SougouZigyouTaishouShousaiDiv SougouZigyouTaishouShousai) {
        this.SougouZigyouTaishouShousai = SougouZigyouTaishouShousai;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IKaigoShikakuKihonDiv getKaiigoShikakCommonChildDiv2() {
        return this.getSokouUpdate().getKaiigoShikakCommonChildDiv2();
    }

    @JsonIgnore
    public IKaigoAtenaInfoDiv getKaigoAtenaInfoChildDiv1() {
        return this.getSokouUpdate().getKaigoAtenaInfoChildDiv1();
    }

    // </editor-fold>
}
