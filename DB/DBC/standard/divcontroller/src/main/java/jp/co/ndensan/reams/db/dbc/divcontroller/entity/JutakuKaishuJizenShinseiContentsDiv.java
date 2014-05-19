package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuJizenShinseiDateDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuReasonDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuZizenShinseiDetailDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KozaInfoMockDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * JutakuKaishuJizenShinseiContents のクラスファイル 
 * 
 * @author 自動生成
 */
public class JutakuKaishuJizenShinseiContentsDiv extends Panel {
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
    @JsonProperty("JutakuKaishuZizenShinseiDetail")
    private JutakuKaishuZizenShinseiDetailDiv JutakuKaishuZizenShinseiDetail;
    @JsonProperty("JutakuKaishuJizenShinseiDate")
    private JutakuKaishuJizenShinseiDateDiv JutakuKaishuJizenShinseiDate;
    @JsonProperty("KozaInfoMock")
    private KozaInfoMockDiv KozaInfoMock;
    @JsonProperty("JutakuKaishuReason")
    private JutakuKaishuReasonDiv JutakuKaishuReason;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtJutakuOwner")
    public TextBox getTxtJutakuOwner() {
        return txtJutakuOwner;
    }

    @JsonProperty("txtJutakuOwner")
    public void setTxtJutakuOwner(TextBox txtJutakuOwner) {
        this.txtJutakuOwner=txtJutakuOwner;
    }

    @JsonProperty("txtRelationWithHihokensha")
    public TextBox getTxtRelationWithHihokensha() {
        return txtRelationWithHihokensha;
    }

    @JsonProperty("txtRelationWithHihokensha")
    public void setTxtRelationWithHihokensha(TextBox txtRelationWithHihokensha) {
        this.txtRelationWithHihokensha=txtRelationWithHihokensha;
    }

    @JsonProperty("JutakuKaishuZizenShinseiDetail")
    public JutakuKaishuZizenShinseiDetailDiv getJutakuKaishuZizenShinseiDetail() {
        return JutakuKaishuZizenShinseiDetail;
    }

    @JsonProperty("JutakuKaishuZizenShinseiDetail")
    public void setJutakuKaishuZizenShinseiDetail(JutakuKaishuZizenShinseiDetailDiv JutakuKaishuZizenShinseiDetail) {
        this.JutakuKaishuZizenShinseiDetail=JutakuKaishuZizenShinseiDetail;
    }

    @JsonProperty("JutakuKaishuJizenShinseiDate")
    public JutakuKaishuJizenShinseiDateDiv getJutakuKaishuJizenShinseiDate() {
        return JutakuKaishuJizenShinseiDate;
    }

    @JsonProperty("JutakuKaishuJizenShinseiDate")
    public void setJutakuKaishuJizenShinseiDate(JutakuKaishuJizenShinseiDateDiv JutakuKaishuJizenShinseiDate) {
        this.JutakuKaishuJizenShinseiDate=JutakuKaishuJizenShinseiDate;
    }

    @JsonProperty("KozaInfoMock")
    public KozaInfoMockDiv getKozaInfoMock() {
        return KozaInfoMock;
    }

    @JsonProperty("KozaInfoMock")
    public void setKozaInfoMock(KozaInfoMockDiv KozaInfoMock) {
        this.KozaInfoMock=KozaInfoMock;
    }

    @JsonProperty("JutakuKaishuReason")
    public JutakuKaishuReasonDiv getJutakuKaishuReason() {
        return JutakuKaishuReason;
    }

    @JsonProperty("JutakuKaishuReason")
    public void setJutakuKaishuReason(JutakuKaishuReasonDiv JutakuKaishuReason) {
        this.JutakuKaishuReason=JutakuKaishuReason;
    }

}
