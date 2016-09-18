package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA4010011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HihokenshaShokaiTotal のクラスファイル 
 * 
 * @author 自動生成
 */
public class HihokenshaShokaiTotalDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-06_01-12-04">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KihonJoho")
    private KihonJohoDiv KihonJoho;
    @JsonProperty("HihokenshaShokaiPanel")
    private HihokenshaShokaiPanelDiv HihokenshaShokaiPanel;
    @JsonProperty("hihokenshaRirekiFlag")
    private RString hihokenshaRirekiFlag;
    @JsonProperty("setaiShokaiFlag")
    private RString setaiShokaiFlag;
    @JsonProperty("iryoHokenFlag")
    private RString iryoHokenFlag;
    @JsonProperty("rofukuNenkinFlag")
    private RString rofukuNenkinFlag;
    @JsonProperty("shisetsuNyutaishoFlag")
    private RString shisetsuNyutaishoFlag;
    @JsonProperty("shoKofuKaishuFlag")
    private RString shoKofuKaishuFlag;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKihonJoho
     * @return KihonJoho
     */
    @JsonProperty("KihonJoho")
    public KihonJohoDiv getKihonJoho() {
        return KihonJoho;
    }

    /*
     * setKihonJoho
     * @param KihonJoho KihonJoho
     */
    @JsonProperty("KihonJoho")
    public void setKihonJoho(KihonJohoDiv KihonJoho) {
        this.KihonJoho = KihonJoho;
    }

    /*
     * getHihokenshaShokaiPanel
     * @return HihokenshaShokaiPanel
     */
    @JsonProperty("HihokenshaShokaiPanel")
    public HihokenshaShokaiPanelDiv getHihokenshaShokaiPanel() {
        return HihokenshaShokaiPanel;
    }

    /*
     * setHihokenshaShokaiPanel
     * @param HihokenshaShokaiPanel HihokenshaShokaiPanel
     */
    @JsonProperty("HihokenshaShokaiPanel")
    public void setHihokenshaShokaiPanel(HihokenshaShokaiPanelDiv HihokenshaShokaiPanel) {
        this.HihokenshaShokaiPanel = HihokenshaShokaiPanel;
    }

    /*
     * gethihokenshaRirekiFlag
     * @return hihokenshaRirekiFlag
     */
    @JsonProperty("hihokenshaRirekiFlag")
    public RString getHihokenshaRirekiFlag() {
        return hihokenshaRirekiFlag;
    }

    /*
     * sethihokenshaRirekiFlag
     * @param hihokenshaRirekiFlag hihokenshaRirekiFlag
     */
    @JsonProperty("hihokenshaRirekiFlag")
    public void setHihokenshaRirekiFlag(RString hihokenshaRirekiFlag) {
        this.hihokenshaRirekiFlag = hihokenshaRirekiFlag;
    }

    /*
     * getsetaiShokaiFlag
     * @return setaiShokaiFlag
     */
    @JsonProperty("setaiShokaiFlag")
    public RString getSetaiShokaiFlag() {
        return setaiShokaiFlag;
    }

    /*
     * setsetaiShokaiFlag
     * @param setaiShokaiFlag setaiShokaiFlag
     */
    @JsonProperty("setaiShokaiFlag")
    public void setSetaiShokaiFlag(RString setaiShokaiFlag) {
        this.setaiShokaiFlag = setaiShokaiFlag;
    }

    /*
     * getiryoHokenFlag
     * @return iryoHokenFlag
     */
    @JsonProperty("iryoHokenFlag")
    public RString getIryoHokenFlag() {
        return iryoHokenFlag;
    }

    /*
     * setiryoHokenFlag
     * @param iryoHokenFlag iryoHokenFlag
     */
    @JsonProperty("iryoHokenFlag")
    public void setIryoHokenFlag(RString iryoHokenFlag) {
        this.iryoHokenFlag = iryoHokenFlag;
    }

    /*
     * getrofukuNenkinFlag
     * @return rofukuNenkinFlag
     */
    @JsonProperty("rofukuNenkinFlag")
    public RString getRofukuNenkinFlag() {
        return rofukuNenkinFlag;
    }

    /*
     * setrofukuNenkinFlag
     * @param rofukuNenkinFlag rofukuNenkinFlag
     */
    @JsonProperty("rofukuNenkinFlag")
    public void setRofukuNenkinFlag(RString rofukuNenkinFlag) {
        this.rofukuNenkinFlag = rofukuNenkinFlag;
    }

    /*
     * getshisetsuNyutaishoFlag
     * @return shisetsuNyutaishoFlag
     */
    @JsonProperty("shisetsuNyutaishoFlag")
    public RString getShisetsuNyutaishoFlag() {
        return shisetsuNyutaishoFlag;
    }

    /*
     * setshisetsuNyutaishoFlag
     * @param shisetsuNyutaishoFlag shisetsuNyutaishoFlag
     */
    @JsonProperty("shisetsuNyutaishoFlag")
    public void setShisetsuNyutaishoFlag(RString shisetsuNyutaishoFlag) {
        this.shisetsuNyutaishoFlag = shisetsuNyutaishoFlag;
    }

    /*
     * getshoKofuKaishuFlag
     * @return shoKofuKaishuFlag
     */
    @JsonProperty("shoKofuKaishuFlag")
    public RString getShoKofuKaishuFlag() {
        return shoKofuKaishuFlag;
    }

    /*
     * setshoKofuKaishuFlag
     * @param shoKofuKaishuFlag shoKofuKaishuFlag
     */
    @JsonProperty("shoKofuKaishuFlag")
    public void setShoKofuKaishuFlag(RString shoKofuKaishuFlag) {
        this.shoKofuKaishuFlag = shoKofuKaishuFlag;
    }

    // </editor-fold>
}
