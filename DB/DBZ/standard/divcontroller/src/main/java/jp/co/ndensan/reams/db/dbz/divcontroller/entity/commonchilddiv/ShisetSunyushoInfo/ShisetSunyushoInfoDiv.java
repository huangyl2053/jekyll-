package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetSunyushoInfo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.parentdiv.ShisetSunyushoInfo.ShisetSunyushoInfoHandler;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * ShisetSunyushoInfoHandler のクラスファイル
 *
 * @author 自動生成
 */
public class ShisetSunyushoInfoDiv extends Panel implements IShisetSunyushoInfoDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtNyushoShisetsuCode")
    private TextBoxCode txtNyushoShisetsuCode;
    @JsonProperty("txtNyushoShisetsuName")
    private TextBox txtNyushoShisetsuName;
    @JsonProperty("txtShisetsunyuShoDay")
    private TextBoxFlexibleDate txtShisetsunyuShoDay;
    @JsonProperty("txtShisetsuTaishoDay")
    private TextBoxFlexibleDate txtShisetsuTaishoDay;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtNyushoShisetsuCode
     * @return txtNyushoShisetsuCode
     */
    @JsonProperty("txtNyushoShisetsuCode")
    public TextBoxCode getTxtNyushoShisetsuCode() {
        return txtNyushoShisetsuCode;
    }

    /*
     * settxtNyushoShisetsuCode
     * @param txtNyushoShisetsuCode txtNyushoShisetsuCode
     */
    @JsonProperty("txtNyushoShisetsuCode")
    public void setTxtNyushoShisetsuCode(TextBoxCode txtNyushoShisetsuCode) {
        this.txtNyushoShisetsuCode = txtNyushoShisetsuCode;
    }

    /*
     * gettxtNyushoShisetsuName
     * @return txtNyushoShisetsuName
     */
    @JsonProperty("txtNyushoShisetsuName")
    public TextBox getTxtNyushoShisetsuName() {
        return txtNyushoShisetsuName;
    }

    /*
     * settxtNyushoShisetsuName
     * @param txtNyushoShisetsuName txtNyushoShisetsuName
     */
    @JsonProperty("txtNyushoShisetsuName")
    public void setTxtNyushoShisetsuName(TextBox txtNyushoShisetsuName) {
        this.txtNyushoShisetsuName = txtNyushoShisetsuName;
    }

    /*
     * gettxtShisetsunyuShoDay
     * @return txtShisetsunyuShoDay
     */
    @JsonProperty("txtShisetsunyuShoDay")
    public TextBoxFlexibleDate getTxtShisetsunyuShoDay() {
        return txtShisetsunyuShoDay;
    }

    /*
     * settxtShisetsunyuShoDay
     * @param txtShisetsunyuShoDay txtShisetsunyuShoDay
     */
    @JsonProperty("txtShisetsunyuShoDay")
    public void setTxtShisetsunyuShoDay(TextBoxFlexibleDate txtShisetsunyuShoDay) {
        this.txtShisetsunyuShoDay = txtShisetsunyuShoDay;
    }

    /*
     * gettxtShisetsuTaishoDay
     * @return txtShisetsuTaishoDay
     */
    @JsonProperty("txtShisetsuTaishoDay")
    public TextBoxFlexibleDate getTxtShisetsuTaishoDay() {
        return txtShisetsuTaishoDay;
    }

    /*
     * settxtShisetsuTaishoDay
     * @param txtShisetsuTaishoDay txtShisetsuTaishoDay
     */
    @JsonProperty("txtShisetsuTaishoDay")
    public void setTxtShisetsuTaishoDay(TextBoxFlexibleDate txtShisetsuTaishoDay) {
        this.txtShisetsuTaishoDay = txtShisetsuTaishoDay;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    private ShisetSunyushoInfoHandler getHandler() {
        return new ShisetSunyushoInfoHandler(this);
    }

    @Override
    public void onLoad(ShikibetsuCode 識別コード) {
        getHandler().initialize(識別コード);
    }

}
