package jp.co.ndensan.reams.db.dbb.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Apr 09 17:14:03 JST 2014 
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.HakkoKakuninPanelDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.SashidashininNyuryokuPanelDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.ShotokuShokaiHyoHakkoIchiranPanelDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.ShotokuShokaihyoShuseiNyuryokuPanelDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShotokuShokaiHakkoKojinMain のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShotokuShokaiHakkoKojinMainDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShotokuShokaiHyoHakkoIchiranPanel")
    private ShotokuShokaiHyoHakkoIchiranPanelDiv ShotokuShokaiHyoHakkoIchiranPanel;
    @JsonProperty("ShotokuShokaihyoShuseiNyuryokuPanel")
    private ShotokuShokaihyoShuseiNyuryokuPanelDiv ShotokuShokaihyoShuseiNyuryokuPanel;
    @JsonProperty("SashidashininNyuryokuPanel")
    private SashidashininNyuryokuPanelDiv SashidashininNyuryokuPanel;
    @JsonProperty("HakkoKakuninPanel")
    private HakkoKakuninPanelDiv HakkoKakuninPanel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShotokuShokaiHyoHakkoIchiranPanel")
    public ShotokuShokaiHyoHakkoIchiranPanelDiv getShotokuShokaiHyoHakkoIchiranPanel() {
        return ShotokuShokaiHyoHakkoIchiranPanel;
    }

    @JsonProperty("ShotokuShokaiHyoHakkoIchiranPanel")
    public void setShotokuShokaiHyoHakkoIchiranPanel(ShotokuShokaiHyoHakkoIchiranPanelDiv ShotokuShokaiHyoHakkoIchiranPanel) {
        this.ShotokuShokaiHyoHakkoIchiranPanel=ShotokuShokaiHyoHakkoIchiranPanel;
    }

    @JsonProperty("ShotokuShokaihyoShuseiNyuryokuPanel")
    public ShotokuShokaihyoShuseiNyuryokuPanelDiv getShotokuShokaihyoShuseiNyuryokuPanel() {
        return ShotokuShokaihyoShuseiNyuryokuPanel;
    }

    @JsonProperty("ShotokuShokaihyoShuseiNyuryokuPanel")
    public void setShotokuShokaihyoShuseiNyuryokuPanel(ShotokuShokaihyoShuseiNyuryokuPanelDiv ShotokuShokaihyoShuseiNyuryokuPanel) {
        this.ShotokuShokaihyoShuseiNyuryokuPanel=ShotokuShokaihyoShuseiNyuryokuPanel;
    }

    @JsonProperty("SashidashininNyuryokuPanel")
    public SashidashininNyuryokuPanelDiv getSashidashininNyuryokuPanel() {
        return SashidashininNyuryokuPanel;
    }

    @JsonProperty("SashidashininNyuryokuPanel")
    public void setSashidashininNyuryokuPanel(SashidashininNyuryokuPanelDiv SashidashininNyuryokuPanel) {
        this.SashidashininNyuryokuPanel=SashidashininNyuryokuPanel;
    }

    @JsonProperty("HakkoKakuninPanel")
    public HakkoKakuninPanelDiv getHakkoKakuninPanel() {
        return HakkoKakuninPanel;
    }

    @JsonProperty("HakkoKakuninPanel")
    public void setHakkoKakuninPanel(HakkoKakuninPanelDiv HakkoKakuninPanel) {
        this.HakkoKakuninPanel=HakkoKakuninPanel;
    }

}
