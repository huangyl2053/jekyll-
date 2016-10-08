package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hihokenshafinder.HihokenshaFinder;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KaigoFinder のクラスファイル
 *
 * @author 自動生成
 */
public class KaigoFinderDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-06_01-12-04">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlHokensha")
    private DropDownList ddlHokensha;
    @JsonProperty("txtHihokenshaNo")
    private TextBoxCode txtHihokenshaNo;
    @JsonProperty("txtTuchishoNo")
    private TextBoxCode txtTuchishoNo;
    @JsonProperty("ddlFukaNendo")
    private DropDownList ddlFukaNendo;
    @JsonProperty("KaigoFinderDetail")
    private KaigoFinderDetailDiv KaigoFinderDetail;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlHokensha
     * @return ddlHokensha
     */
    @JsonProperty("ddlHokensha")
    public DropDownList getDdlHokensha() {
        return ddlHokensha;
    }

    /*
     * setddlHokensha
     * @param ddlHokensha ddlHokensha
     */
    @JsonProperty("ddlHokensha")
    public void setDdlHokensha(DropDownList ddlHokensha) {
        this.ddlHokensha = ddlHokensha;
    }

    /*
     * gettxtHihokenshaNo
     * @return txtHihokenshaNo
     */
    @JsonProperty("txtHihokenshaNo")
    public TextBoxCode getTxtHihokenshaNo() {
        return txtHihokenshaNo;
    }

    /*
     * settxtHihokenshaNo
     * @param txtHihokenshaNo txtHihokenshaNo
     */
    @JsonProperty("txtHihokenshaNo")
    public void setTxtHihokenshaNo(TextBoxCode txtHihokenshaNo) {
        this.txtHihokenshaNo = txtHihokenshaNo;
    }

    /*
     * gettxtTuchishoNo
     * @return txtTuchishoNo
     */
    @JsonProperty("txtTuchishoNo")
    public TextBoxCode getTxtTuchishoNo() {
        return txtTuchishoNo;
    }

    /*
     * settxtTuchishoNo
     * @param txtTuchishoNo txtTuchishoNo
     */
    @JsonProperty("txtTuchishoNo")
    public void setTxtTuchishoNo(TextBoxCode txtTuchishoNo) {
        this.txtTuchishoNo = txtTuchishoNo;
    }

    /*
     * getddlFukaNendo
     * @return ddlFukaNendo
     */
    @JsonProperty("ddlFukaNendo")
    public DropDownList getDdlFukaNendo() {
        return ddlFukaNendo;
    }

    /*
     * setddlFukaNendo
     * @param ddlFukaNendo ddlFukaNendo
     */
    @JsonProperty("ddlFukaNendo")
    public void setDdlFukaNendo(DropDownList ddlFukaNendo) {
        this.ddlFukaNendo = ddlFukaNendo;
    }

    /*
     * getKaigoFinderDetail
     * @return KaigoFinderDetail
     */
    @JsonProperty("KaigoFinderDetail")
    public KaigoFinderDetailDiv getKaigoFinderDetail() {
        return KaigoFinderDetail;
    }

    /*
     * setKaigoFinderDetail
     * @param KaigoFinderDetail KaigoFinderDetail
     */
    @JsonProperty("KaigoFinderDetail")
    public void setKaigoFinderDetail(KaigoFinderDetailDiv KaigoFinderDetail) {
        this.KaigoFinderDetail = KaigoFinderDetail;
    }

    public void clear() {

        if (this.ddlHokensha.getSelectedIndex() >= 0) {
            this.ddlHokensha.setSelectedIndex(0);
        }

        this.txtHihokenshaNo.clearValue();
        this.txtTuchishoNo.clearValue();

        if (this.ddlFukaNendo.getSelectedIndex() >= 0) {
            this.ddlFukaNendo.setSelectedIndex(0);
        }

        List<KeyValueDataSource> def = new ArrayList();
        this.KaigoFinderDetail.getChkHihokenshaDaicho().setSelectedItems(def);
        this.KaigoFinderDetail.getChkJukyushaDaicho().setSelectedItems(def);
        this.KaigoFinderDetail.getChkJushochiTokureisha().setSelectedItems(def);
    }

    // </editor-fold>
}
