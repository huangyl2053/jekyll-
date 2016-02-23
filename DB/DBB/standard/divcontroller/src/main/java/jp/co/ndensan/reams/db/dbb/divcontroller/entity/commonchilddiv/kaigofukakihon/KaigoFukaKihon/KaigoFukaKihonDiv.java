package jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.kaigofukakihon.KaigoFukaKihon;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.business.searchkey.KaigoFukaKihonSearchKey;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KaigoFukaKihon のクラスファイル
 *
 * @author 自動生成
 */
public class KaigoFukaKihonDiv extends Panel implements IKaigoFukaKihonDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-63">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTsuchishoNo")
    private TextBox txtTsuchishoNo;
    @JsonProperty("txtHihokenshaNo")
    private TextBox txtHihokenshaNo;
    @JsonProperty("txtHokenryoDankai")
    private TextBox txtHokenryoDankai;
    @JsonProperty("txtShutokuYmd")
    private TextBoxFlexibleDate txtShutokuYmd;
    @JsonProperty("txtShutokuJiyu")
    private TextBox txtShutokuJiyu;
    @JsonProperty("txtSoshitsuYmd")
    private TextBoxFlexibleDate txtSoshitsuYmd;
    @JsonProperty("txtSoshitsuJiyu")
    private TextBox txtSoshitsuJiyu;
    @JsonProperty("btnHihoRireki")
    private ButtonDialog btnHihoRireki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtTsuchishoNo
     * @return txtTsuchishoNo
     */
    @JsonProperty("txtTsuchishoNo")
    public TextBox getTxtTsuchishoNo() {
        return txtTsuchishoNo;
    }

    /*
     * settxtTsuchishoNo
     * @param txtTsuchishoNo txtTsuchishoNo
     */
    @JsonProperty("txtTsuchishoNo")
    public void setTxtTsuchishoNo(TextBox txtTsuchishoNo) {
        this.txtTsuchishoNo = txtTsuchishoNo;
    }

    /*
     * gettxtHihokenshaNo
     * @return txtHihokenshaNo
     */
    @JsonProperty("txtHihokenshaNo")
    public TextBox getTxtHihokenshaNo() {
        return txtHihokenshaNo;
    }

    /*
     * settxtHihokenshaNo
     * @param txtHihokenshaNo txtHihokenshaNo
     */
    @JsonProperty("txtHihokenshaNo")
    public void setTxtHihokenshaNo(TextBox txtHihokenshaNo) {
        this.txtHihokenshaNo = txtHihokenshaNo;
    }

    /*
     * gettxtHokenryoDankai
     * @return txtHokenryoDankai
     */
    @JsonProperty("txtHokenryoDankai")
    public TextBox getTxtHokenryoDankai() {
        return txtHokenryoDankai;
    }

    /*
     * settxtHokenryoDankai
     * @param txtHokenryoDankai txtHokenryoDankai
     */
    @JsonProperty("txtHokenryoDankai")
    public void setTxtHokenryoDankai(TextBox txtHokenryoDankai) {
        this.txtHokenryoDankai = txtHokenryoDankai;
    }

    /*
     * gettxtShutokuYmd
     * @return txtShutokuYmd
     */
    @JsonProperty("txtShutokuYmd")
    public TextBoxFlexibleDate getTxtShutokuYmd() {
        return txtShutokuYmd;
    }

    /*
     * settxtShutokuYmd
     * @param txtShutokuYmd txtShutokuYmd
     */
    @JsonProperty("txtShutokuYmd")
    public void setTxtShutokuYmd(TextBoxFlexibleDate txtShutokuYmd) {
        this.txtShutokuYmd = txtShutokuYmd;
    }

    /*
     * gettxtShutokuJiyu
     * @return txtShutokuJiyu
     */
    @JsonProperty("txtShutokuJiyu")
    public TextBox getTxtShutokuJiyu() {
        return txtShutokuJiyu;
    }

    /*
     * settxtShutokuJiyu
     * @param txtShutokuJiyu txtShutokuJiyu
     */
    @JsonProperty("txtShutokuJiyu")
    public void setTxtShutokuJiyu(TextBox txtShutokuJiyu) {
        this.txtShutokuJiyu = txtShutokuJiyu;
    }

    /*
     * gettxtSoshitsuYmd
     * @return txtSoshitsuYmd
     */
    @JsonProperty("txtSoshitsuYmd")
    public TextBoxFlexibleDate getTxtSoshitsuYmd() {
        return txtSoshitsuYmd;
    }

    /*
     * settxtSoshitsuYmd
     * @param txtSoshitsuYmd txtSoshitsuYmd
     */
    @JsonProperty("txtSoshitsuYmd")
    public void setTxtSoshitsuYmd(TextBoxFlexibleDate txtSoshitsuYmd) {
        this.txtSoshitsuYmd = txtSoshitsuYmd;
    }

    /*
     * gettxtSoshitsuJiyu
     * @return txtSoshitsuJiyu
     */
    @JsonProperty("txtSoshitsuJiyu")
    public TextBox getTxtSoshitsuJiyu() {
        return txtSoshitsuJiyu;
    }

    /*
     * settxtSoshitsuJiyu
     * @param txtSoshitsuJiyu txtSoshitsuJiyu
     */
    @JsonProperty("txtSoshitsuJiyu")
    public void setTxtSoshitsuJiyu(TextBox txtSoshitsuJiyu) {
        this.txtSoshitsuJiyu = txtSoshitsuJiyu;
    }

    /*
     * getbtnHihoRireki
     * @return btnHihoRireki
     */
    @JsonProperty("btnHihoRireki")
    public ButtonDialog getBtnHihoRireki() {
        return btnHihoRireki;
    }

    /*
     * setbtnHihoRireki
     * @param btnHihoRireki btnHihoRireki
     */
    @JsonProperty("btnHihoRireki")
    public void setBtnHihoRireki(ButtonDialog btnHihoRireki) {
        this.btnHihoRireki = btnHihoRireki;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void load(KaigoFukaKihonSearchKey searchKey) {
        getHandler().load(searchKey);
    }

    @JsonIgnore
    public KaigoFukaKihonHandler getHandler() {
        return new KaigoFukaKihonHandler(this);
    }

}
