package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1150001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.kaigofukakihon.KaigoFukaKihon.IKaigoFukaKihonDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.kaigofukakihon.KaigoFukaKihon.KaigoFukaKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NushiJuminJoho のクラスファイル
 *
 * @reamsid_L DBB-1710-010 xuhao
 */
public class NushiJuminJohoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
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
    @JsonProperty("HakkoKakuninPanel")
    private HakkoKakuninPanelDiv HakkoKakuninPanel;
    @JsonProperty("ccdKaigoAtenaInfo")
    private KaigoAtenaInfoDiv ccdKaigoAtenaInfo;
    @JsonProperty("ccdKaigoFukaKihon")
    private KaigoFukaKihonDiv ccdKaigoFukaKihon;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShotokuShokaiHyoHakkoIchiranPanel
     * @return ShotokuShokaiHyoHakkoIchiranPanel
     */
    @JsonProperty("ShotokuShokaiHyoHakkoIchiranPanel")
    public ShotokuShokaiHyoHakkoIchiranPanelDiv getShotokuShokaiHyoHakkoIchiranPanel() {
        return ShotokuShokaiHyoHakkoIchiranPanel;
    }

    /*
     * setShotokuShokaiHyoHakkoIchiranPanel
     * @param ShotokuShokaiHyoHakkoIchiranPanel ShotokuShokaiHyoHakkoIchiranPanel
     */
    @JsonProperty("ShotokuShokaiHyoHakkoIchiranPanel")
    public void setShotokuShokaiHyoHakkoIchiranPanel(ShotokuShokaiHyoHakkoIchiranPanelDiv ShotokuShokaiHyoHakkoIchiranPanel) {
        this.ShotokuShokaiHyoHakkoIchiranPanel = ShotokuShokaiHyoHakkoIchiranPanel;
    }

    /*
     * getShotokuShokaihyoShuseiNyuryokuPanel
     * @return ShotokuShokaihyoShuseiNyuryokuPanel
     */
    @JsonProperty("ShotokuShokaihyoShuseiNyuryokuPanel")
    public ShotokuShokaihyoShuseiNyuryokuPanelDiv getShotokuShokaihyoShuseiNyuryokuPanel() {
        return ShotokuShokaihyoShuseiNyuryokuPanel;
    }

    /*
     * setShotokuShokaihyoShuseiNyuryokuPanel
     * @param ShotokuShokaihyoShuseiNyuryokuPanel ShotokuShokaihyoShuseiNyuryokuPanel
     */
    @JsonProperty("ShotokuShokaihyoShuseiNyuryokuPanel")
    public void setShotokuShokaihyoShuseiNyuryokuPanel(ShotokuShokaihyoShuseiNyuryokuPanelDiv ShotokuShokaihyoShuseiNyuryokuPanel) {
        this.ShotokuShokaihyoShuseiNyuryokuPanel = ShotokuShokaihyoShuseiNyuryokuPanel;
    }

    /*
     * getHakkoKakuninPanel
     * @return HakkoKakuninPanel
     */
    @JsonProperty("HakkoKakuninPanel")
    public HakkoKakuninPanelDiv getHakkoKakuninPanel() {
        return HakkoKakuninPanel;
    }

    /*
     * setHakkoKakuninPanel
     * @param HakkoKakuninPanel HakkoKakuninPanel
     */
    @JsonProperty("HakkoKakuninPanel")
    public void setHakkoKakuninPanel(HakkoKakuninPanelDiv HakkoKakuninPanel) {
        this.HakkoKakuninPanel = HakkoKakuninPanel;
    }

    /*
     * getccdKaigoAtenaInfo
     * @return ccdKaigoAtenaInfo
     */
    @JsonProperty("ccdKaigoAtenaInfo")
    public IKaigoAtenaInfoDiv getCcdKaigoAtenaInfo() {
        return ccdKaigoAtenaInfo;
    }

    /*
     * getccdKaigoFukaKihon
     * @return ccdKaigoFukaKihon
     */
    @JsonProperty("ccdKaigoFukaKihon")
    public IKaigoFukaKihonDiv getCcdKaigoFukaKihon() {
        return ccdKaigoFukaKihon;
    }

    // </editor-fold>
}
