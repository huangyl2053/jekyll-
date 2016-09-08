package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1050021;
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
 * ChutsutsuJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChutsutsuJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKijunYMD")
    private TextBoxDate txtKijunYMD;
    @JsonProperty("radShikakuSoshitsuChushutsu")
    private RadioButton radShikakuSoshitsuChushutsu;
    @JsonProperty("radJigyoshaSentaku")
    private RadioButton radJigyoshaSentaku;
    @JsonProperty("ccdShisetsuJohoCommonChildDiv")
    private ShisetsuJohoCommonChildDivDiv ccdShisetsuJohoCommonChildDiv;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKijunYMD
     * @return txtKijunYMD
     */
    @JsonProperty("txtKijunYMD")
    public TextBoxDate getTxtKijunYMD() {
        return txtKijunYMD;
    }

    /*
     * settxtKijunYMD
     * @param txtKijunYMD txtKijunYMD
     */
    @JsonProperty("txtKijunYMD")
    public void setTxtKijunYMD(TextBoxDate txtKijunYMD) {
        this.txtKijunYMD = txtKijunYMD;
    }

    /*
     * getradShikakuSoshitsuChushutsu
     * @return radShikakuSoshitsuChushutsu
     */
    @JsonProperty("radShikakuSoshitsuChushutsu")
    public RadioButton getRadShikakuSoshitsuChushutsu() {
        return radShikakuSoshitsuChushutsu;
    }

    /*
     * setradShikakuSoshitsuChushutsu
     * @param radShikakuSoshitsuChushutsu radShikakuSoshitsuChushutsu
     */
    @JsonProperty("radShikakuSoshitsuChushutsu")
    public void setRadShikakuSoshitsuChushutsu(RadioButton radShikakuSoshitsuChushutsu) {
        this.radShikakuSoshitsuChushutsu = radShikakuSoshitsuChushutsu;
    }

    /*
     * getradJigyoshaSentaku
     * @return radJigyoshaSentaku
     */
    @JsonProperty("radJigyoshaSentaku")
    public RadioButton getRadJigyoshaSentaku() {
        return radJigyoshaSentaku;
    }

    /*
     * setradJigyoshaSentaku
     * @param radJigyoshaSentaku radJigyoshaSentaku
     */
    @JsonProperty("radJigyoshaSentaku")
    public void setRadJigyoshaSentaku(RadioButton radJigyoshaSentaku) {
        this.radJigyoshaSentaku = radJigyoshaSentaku;
    }

    /*
     * getccdShisetsuJohoCommonChildDiv
     * @return ccdShisetsuJohoCommonChildDiv
     */
    @JsonProperty("ccdShisetsuJohoCommonChildDiv")
    public IShisetsuJohoCommonChildDiv getCcdShisetsuJohoCommonChildDiv() {
        return ccdShisetsuJohoCommonChildDiv;
    }

    // </editor-fold>
}
