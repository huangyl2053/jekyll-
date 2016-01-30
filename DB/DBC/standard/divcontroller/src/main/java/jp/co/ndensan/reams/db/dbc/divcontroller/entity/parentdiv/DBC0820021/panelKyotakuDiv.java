package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.IShisetsuJohoCommonChildDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.ShisetsuJohoCommonChildDivDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * panelKyotaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class panelKyotakuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlKeikakuSakuseiKubun")
    private DropDownList ddlKeikakuSakuseiKubun;
    @JsonProperty("chkKyusochi")
    private CheckBoxList chkKyusochi;
    @JsonProperty("txtHokenKyufuritsu")
    private TextBoxNum txtHokenKyufuritsu;
    @JsonProperty("ccdShisetsuJoho")
    private ShisetsuJohoCommonChildDivDiv ccdShisetsuJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlKeikakuSakuseiKubun
     * @return ddlKeikakuSakuseiKubun
     */
    @JsonProperty("ddlKeikakuSakuseiKubun")
    public DropDownList getDdlKeikakuSakuseiKubun() {
        return ddlKeikakuSakuseiKubun;
    }

    /*
     * setddlKeikakuSakuseiKubun
     * @param ddlKeikakuSakuseiKubun ddlKeikakuSakuseiKubun
     */
    @JsonProperty("ddlKeikakuSakuseiKubun")
    public void setDdlKeikakuSakuseiKubun(DropDownList ddlKeikakuSakuseiKubun) {
        this.ddlKeikakuSakuseiKubun = ddlKeikakuSakuseiKubun;
    }

    /*
     * getchkKyusochi
     * @return chkKyusochi
     */
    @JsonProperty("chkKyusochi")
    public CheckBoxList getChkKyusochi() {
        return chkKyusochi;
    }

    /*
     * setchkKyusochi
     * @param chkKyusochi chkKyusochi
     */
    @JsonProperty("chkKyusochi")
    public void setChkKyusochi(CheckBoxList chkKyusochi) {
        this.chkKyusochi = chkKyusochi;
    }

    /*
     * gettxtHokenKyufuritsu
     * @return txtHokenKyufuritsu
     */
    @JsonProperty("txtHokenKyufuritsu")
    public TextBoxNum getTxtHokenKyufuritsu() {
        return txtHokenKyufuritsu;
    }

    /*
     * settxtHokenKyufuritsu
     * @param txtHokenKyufuritsu txtHokenKyufuritsu
     */
    @JsonProperty("txtHokenKyufuritsu")
    public void setTxtHokenKyufuritsu(TextBoxNum txtHokenKyufuritsu) {
        this.txtHokenKyufuritsu = txtHokenKyufuritsu;
    }

    /*
     * getccdShisetsuJoho
     * @return ccdShisetsuJoho
     */
    @JsonProperty("ccdShisetsuJoho")
    public IShisetsuJohoCommonChildDiv getCcdShisetsuJoho() {
        return ccdShisetsuJoho;
    }

    // </editor-fold>
}
