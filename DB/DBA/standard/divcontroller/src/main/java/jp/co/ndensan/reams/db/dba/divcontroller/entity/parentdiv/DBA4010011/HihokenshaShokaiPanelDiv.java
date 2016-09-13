package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA4010011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.IryoHokenRirekiDialogButton.IIryoHokenRirekiDialogButtonDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.IryoHokenRirekiDialogButton.IryoHokenRirekiDialogButtonDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.RofukuNenkinDialogButton.IRofukuNenkinDialogButtonDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.RofukuNenkinDialogButton.RofukuNenkinDialogButtonDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShisetsuNyutaishoDialogButton.IShisetsuNyutaishoDialogButtonDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShisetsuNyutaishoDialogButton.ShisetsuNyutaishoDialogButtonDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShoKaishuKirokuDialogButton.IShoKaishuKirokuDialogButtonDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShoKaishuKirokuDialogButton.ShoKaishuKirokuDialogButtonDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShotokuShokaiDialogButton.IShotokuShokaiDialogButtonDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShotokuShokaiDialogButton.ShotokuShokaiDialogButtonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShikakuTokusoRireki.IShikakuTokusoRirekiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShikakuTokusoRireki.ShikakuTokusoRirekiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HihokenshaShokaiPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class HihokenshaShokaiPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-06_01-12-04">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdSetaiShotokuButton")
    private ShotokuShokaiDialogButtonDiv ccdSetaiShotokuButton;
    @JsonProperty("ccdIryoHokenButton")
    private IryoHokenRirekiDialogButtonDiv ccdIryoHokenButton;
    @JsonProperty("ccdRofukuNenkinButton")
    private RofukuNenkinDialogButtonDiv ccdRofukuNenkinButton;
    @JsonProperty("ccdShisetsuNyutaishoButton")
    private ShisetsuNyutaishoDialogButtonDiv ccdShisetsuNyutaishoButton;
    @JsonProperty("ccdShoKofuKaishuButton")
    private ShoKaishuKirokuDialogButtonDiv ccdShoKofuKaishuButton;
    @JsonProperty("ccdShisetsuTokusoRireki")
    private ShikakuTokusoRirekiDiv ccdShisetsuTokusoRireki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdSetaiShotokuButton
     * @return ccdSetaiShotokuButton
     */
    @JsonProperty("ccdSetaiShotokuButton")
    public IShotokuShokaiDialogButtonDiv getCcdSetaiShotokuButton() {
        return ccdSetaiShotokuButton;
    }

    /*
     * getccdIryoHokenButton
     * @return ccdIryoHokenButton
     */
    @JsonProperty("ccdIryoHokenButton")
    public IIryoHokenRirekiDialogButtonDiv getCcdIryoHokenButton() {
        return ccdIryoHokenButton;
    }

    /*
     * getccdRofukuNenkinButton
     * @return ccdRofukuNenkinButton
     */
    @JsonProperty("ccdRofukuNenkinButton")
    public IRofukuNenkinDialogButtonDiv getCcdRofukuNenkinButton() {
        return ccdRofukuNenkinButton;
    }

    /*
     * getccdShisetsuNyutaishoButton
     * @return ccdShisetsuNyutaishoButton
     */
    @JsonProperty("ccdShisetsuNyutaishoButton")
    public IShisetsuNyutaishoDialogButtonDiv getCcdShisetsuNyutaishoButton() {
        return ccdShisetsuNyutaishoButton;
    }

    /*
     * getccdShoKofuKaishuButton
     * @return ccdShoKofuKaishuButton
     */
    @JsonProperty("ccdShoKofuKaishuButton")
    public IShoKaishuKirokuDialogButtonDiv getCcdShoKofuKaishuButton() {
        return ccdShoKofuKaishuButton;
    }

    /*
     * getccdShisetsuTokusoRireki
     * @return ccdShisetsuTokusoRireki
     */
    @JsonProperty("ccdShisetsuTokusoRireki")
    public IShikakuTokusoRirekiDiv getCcdShisetsuTokusoRireki() {
        return ccdShisetsuTokusoRireki;
    }

    // </editor-fold>
}
