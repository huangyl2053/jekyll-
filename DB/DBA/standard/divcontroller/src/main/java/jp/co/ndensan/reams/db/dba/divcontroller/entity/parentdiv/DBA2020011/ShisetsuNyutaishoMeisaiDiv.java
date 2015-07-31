package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2020011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.IShisetsuJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.ShisetsuJohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShisetsuNyutaishoMeisai のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShisetsuNyutaishoMeisaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtNyushoDate")
    private TextBoxDate txtNyushoDate;
    @JsonProperty("txtTaishoDate")
    private TextBoxDate txtTaishoDate;
    @JsonProperty("ccdShisetsuJoho")
    private ShisetsuJohoDiv ccdShisetsuJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtNyushoDate")
    public TextBoxDate getTxtNyushoDate() {
        return txtNyushoDate;
    }

    @JsonProperty("txtNyushoDate")
    public void setTxtNyushoDate(TextBoxDate txtNyushoDate) {
        this.txtNyushoDate=txtNyushoDate;
    }

    @JsonProperty("txtTaishoDate")
    public TextBoxDate getTxtTaishoDate() {
        return txtTaishoDate;
    }

    @JsonProperty("txtTaishoDate")
    public void setTxtTaishoDate(TextBoxDate txtTaishoDate) {
        this.txtTaishoDate=txtTaishoDate;
    }

    @JsonProperty("ccdShisetsuJoho")
    public IShisetsuJohoDiv getCcdShisetsuJoho() {
        return ccdShisetsuJoho;
    }

    // </editor-fold>
}
