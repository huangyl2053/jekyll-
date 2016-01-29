package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0700011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tabShinseiJyoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabShinseiJyohoDiv extends TabPanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtJutakuOwner")
    private TextBox txtJutakuOwner;
    @JsonProperty("txtRelationWithHihokensha")
    private TextBox txtRelationWithHihokensha;
    @JsonProperty("ShinseishaInfo")
    private ShinseishaInfoDiv ShinseishaInfo;
    @JsonProperty("JutakuKaishuJizenShinseiReason")
    private JutakuKaishuJizenShinseiReasonDiv JutakuKaishuJizenShinseiReason;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtJutakuOwner
     * @return txtJutakuOwner
     */
    @JsonProperty("txtJutakuOwner")
    public TextBox getTxtJutakuOwner() {
        return txtJutakuOwner;
    }

    /*
     * settxtJutakuOwner
     * @param txtJutakuOwner txtJutakuOwner
     */
    @JsonProperty("txtJutakuOwner")
    public void setTxtJutakuOwner(TextBox txtJutakuOwner) {
        this.txtJutakuOwner = txtJutakuOwner;
    }

    /*
     * gettxtRelationWithHihokensha
     * @return txtRelationWithHihokensha
     */
    @JsonProperty("txtRelationWithHihokensha")
    public TextBox getTxtRelationWithHihokensha() {
        return txtRelationWithHihokensha;
    }

    /*
     * settxtRelationWithHihokensha
     * @param txtRelationWithHihokensha txtRelationWithHihokensha
     */
    @JsonProperty("txtRelationWithHihokensha")
    public void setTxtRelationWithHihokensha(TextBox txtRelationWithHihokensha) {
        this.txtRelationWithHihokensha = txtRelationWithHihokensha;
    }

    /*
     * getShinseishaInfo
     * @return ShinseishaInfo
     */
    @JsonProperty("ShinseishaInfo")
    public ShinseishaInfoDiv getShinseishaInfo() {
        return ShinseishaInfo;
    }

    /*
     * setShinseishaInfo
     * @param ShinseishaInfo ShinseishaInfo
     */
    @JsonProperty("ShinseishaInfo")
    public void setShinseishaInfo(ShinseishaInfoDiv ShinseishaInfo) {
        this.ShinseishaInfo = ShinseishaInfo;
    }

    /*
     * getJutakuKaishuJizenShinseiReason
     * @return JutakuKaishuJizenShinseiReason
     */
    @JsonProperty("JutakuKaishuJizenShinseiReason")
    public JutakuKaishuJizenShinseiReasonDiv getJutakuKaishuJizenShinseiReason() {
        return JutakuKaishuJizenShinseiReason;
    }

    /*
     * setJutakuKaishuJizenShinseiReason
     * @param JutakuKaishuJizenShinseiReason JutakuKaishuJizenShinseiReason
     */
    @JsonProperty("JutakuKaishuJizenShinseiReason")
    public void setJutakuKaishuJizenShinseiReason(JutakuKaishuJizenShinseiReasonDiv JutakuKaishuJizenShinseiReason) {
        this.JutakuKaishuJizenShinseiReason = JutakuKaishuJizenShinseiReason;
    }

    // </editor-fold>
}
