package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0700011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JutakuKaishuJizenShinseiToroku のクラスファイル 
 * 
 * @author 自動生成
 */
public class JutakuKaishuJizenShinseiTorokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KaigoShikakuKihonShaPanel")
    private KaigoShikakuKihonShaPanelDiv KaigoShikakuKihonShaPanel;
    @JsonProperty("JutakuJizenKanryo")
    private JutakuJizenKanryoDiv JutakuJizenKanryo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKaigoShikakuKihonShaPanel
     * @return KaigoShikakuKihonShaPanel
     */
    @JsonProperty("KaigoShikakuKihonShaPanel")
    public KaigoShikakuKihonShaPanelDiv getKaigoShikakuKihonShaPanel() {
        return KaigoShikakuKihonShaPanel;
    }

    /*
     * setKaigoShikakuKihonShaPanel
     * @param KaigoShikakuKihonShaPanel KaigoShikakuKihonShaPanel
     */
    @JsonProperty("KaigoShikakuKihonShaPanel")
    public void setKaigoShikakuKihonShaPanel(KaigoShikakuKihonShaPanelDiv KaigoShikakuKihonShaPanel) {
        this.KaigoShikakuKihonShaPanel = KaigoShikakuKihonShaPanel;
    }

    /*
     * getJutakuJizenKanryo
     * @return JutakuJizenKanryo
     */
    @JsonProperty("JutakuJizenKanryo")
    public JutakuJizenKanryoDiv getJutakuJizenKanryo() {
        return JutakuJizenKanryo;
    }

    /*
     * setJutakuJizenKanryo
     * @param JutakuJizenKanryo JutakuJizenKanryo
     */
    @JsonProperty("JutakuJizenKanryo")
    public void setJutakuJizenKanryo(JutakuJizenKanryoDiv JutakuJizenKanryo) {
        this.JutakuJizenKanryo = JutakuJizenKanryo;
    }

    // </editor-fold>
}
