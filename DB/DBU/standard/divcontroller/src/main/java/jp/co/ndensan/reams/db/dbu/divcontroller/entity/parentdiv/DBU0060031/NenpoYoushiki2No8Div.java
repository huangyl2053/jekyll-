package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0060031;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * NenpoYoushiki2No8 のクラスファイル
 *
 * @reamsid_L DBU-1060-030 zhengshukai
 */
public class NenpoYoushiki2No8Div extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KanryoMsg")
    private KanryoMsgDiv KanryoMsg;
    @JsonProperty("hihokenshabango")
    private hihokenshabangoDiv hihokenshabango;
    @JsonProperty("ShisetsugaigosabisujukyuMeisai")
    private ShisetsugaigosabisujukyuMeisaiDiv ShisetsugaigosabisujukyuMeisai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKanryoMsg
     * @return KanryoMsg
     */
    @JsonProperty("KanryoMsg")
    public KanryoMsgDiv getKanryoMsg() {
        return KanryoMsg;
    }

    /*
     * setKanryoMsg
     * @param KanryoMsg KanryoMsg
     */
    @JsonProperty("KanryoMsg")
    public void setKanryoMsg(KanryoMsgDiv KanryoMsg) {
        this.KanryoMsg = KanryoMsg;
    }

    /*
     * gethihokenshabango
     * @return hihokenshabango
     */
    @JsonProperty("hihokenshabango")
    public hihokenshabangoDiv getHihokenshabango() {
        return hihokenshabango;
    }

    /*
     * sethihokenshabango
     * @param hihokenshabango hihokenshabango
     */
    @JsonProperty("hihokenshabango")
    public void setHihokenshabango(hihokenshabangoDiv hihokenshabango) {
        this.hihokenshabango = hihokenshabango;
    }

    /*
     * getShisetsugaigosabisujukyuMeisai
     * @return ShisetsugaigosabisujukyuMeisai
     */
    @JsonProperty("ShisetsugaigosabisujukyuMeisai")
    public ShisetsugaigosabisujukyuMeisaiDiv getShisetsugaigosabisujukyuMeisai() {
        return ShisetsugaigosabisujukyuMeisai;
    }

    /*
     * setShisetsugaigosabisujukyuMeisai
     * @param ShisetsugaigosabisujukyuMeisai ShisetsugaigosabisujukyuMeisai
     */
    @JsonProperty("ShisetsugaigosabisujukyuMeisai")
    public void setShisetsugaigosabisujukyuMeisai(ShisetsugaigosabisujukyuMeisaiDiv ShisetsugaigosabisujukyuMeisai) {
        this.ShisetsugaigosabisujukyuMeisai = ShisetsugaigosabisujukyuMeisai;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxFlexibleDate getTxthokokuYM() {
        return this.getHihokenshabango().getTxthokokuYM();
    }

    @JsonIgnore
    public void setTxthokokuYM(TextBoxFlexibleDate txthokokuYM) {
        this.getHihokenshabango().setTxthokokuYM(txthokokuYM);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtshukeiY() {
        return this.getHihokenshabango().getTxtshukeiY();
    }

    @JsonIgnore
    public void setTxtshukeiY(TextBoxFlexibleDate txtshukeiY) {
        this.getHihokenshabango().setTxtshukeiY(txtshukeiY);
    }

    @JsonIgnore
    public TextBoxCode getTxtHihokenshabango() {
        return this.getHihokenshabango().getTxtHihokenshabango();
    }

    @JsonIgnore
    public void setTxtHihokenshabango(TextBoxCode txtHihokenshabango) {
        this.getHihokenshabango().setTxtHihokenshabango(txtHihokenshabango);
    }

    @JsonIgnore
    public TextBox getTxthihokenshamei() {
        return this.getHihokenshabango().getTxthihokenshamei();
    }

    @JsonIgnore
    public void setTxthihokenshamei(TextBox txthihokenshamei) {
        this.getHihokenshabango().setTxthihokenshamei(txthihokenshamei);
    }

    // </editor-fold>
}
