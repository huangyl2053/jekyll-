package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.HokenshaJoho;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.ur.urz.definition.core.hokenja.HokenjaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;

/**
 * HokenshaJoho のクラスファイル
 *
 * @reamsid_L DBA-0180-010 lishengli
 */
public class HokenshaJohoDiv extends Panel implements IHokenshaJohoDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHokenshaNo")
    private TextBoxCode txtHokenshaNo;
    @JsonProperty("btnHokenshaSelect")
    private ButtonDialog btnHokenshaSelect;
    @JsonProperty("txtHokenshaMeisho")
    private TextBox txtHokenshaMeisho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHokenshaNo
     * @return txtHokenshaNo
     */
    @JsonProperty("txtHokenshaNo")
    public TextBoxCode getTxtHokenshaNo() {
        return txtHokenshaNo;
    }

    /*
     * settxtHokenshaNo
     * @param txtHokenshaNo txtHokenshaNo
     */
    @JsonProperty("txtHokenshaNo")
    public void setTxtHokenshaNo(TextBoxCode txtHokenshaNo) {
        this.txtHokenshaNo = txtHokenshaNo;
    }

    /*
     * getbtnHokenshaSelect
     * @return btnHokenshaSelect
     */
    @JsonProperty("btnHokenshaSelect")
    public ButtonDialog getBtnHokenshaSelect() {
        return btnHokenshaSelect;
    }

    /*
     * setbtnHokenshaSelect
     * @param btnHokenshaSelect btnHokenshaSelect
     */
    @JsonProperty("btnHokenshaSelect")
    public void setBtnHokenshaSelect(ButtonDialog btnHokenshaSelect) {
        this.btnHokenshaSelect = btnHokenshaSelect;
    }

    /*
     * gettxtHokenshaMeisho
     * @return txtHokenshaMeisho
     */
    @JsonProperty("txtHokenshaMeisho")
    public TextBox getTxtHokenshaMeisho() {
        return txtHokenshaMeisho;
    }

    /*
     * settxtHokenshaMeisho
     * @param txtHokenshaMeisho txtHokenshaMeisho
     */
    @JsonProperty("txtHokenshaMeisho")
    public void setTxtHokenshaMeisho(TextBox txtHokenshaMeisho) {
        this.txtHokenshaMeisho = txtHokenshaMeisho;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    private HokenshaJohoHandler getHandler() {
        return new HokenshaJohoHandler(this);
    }

    /**
     * 共通子DIVの初期化です。
     *
     * @param 保険者番号 保険者番号
     */
    @Override
    public void intialize(HokenjaNo 保険者番号) {
        getHandler().intialize(保険者番号);
    }

    /**
     * 共通子DIVのクリアです。
     *
     */
    @Override
    public void clear() {
        getHandler().clear();
    }

    /**
     * 共通子DIVのget保険者番号です。
     *
     * @return 保険者番号
     */
    @Override
    public RString getHokenjaNo() {
        return getHandler().getHokenjaNo();
    }

    /**
     * 共通子DIVのget保険者名です。
     *
     * @return 保険者名
     */
    @Override
    public RString getHokenjaName() {
        return getHandler().getHokenjaName();
    }

    /**
     * 保険者番号を設定する。
     *
     * @param 保険者番号 HokenjaNo
     */
    @Override
    public void setHokenjaNo(RString 保険者番号) {
        getHandler().setHokenjaNo(保険者番号);
    }

    /**
     * 保険者名を設定する。
     *
     * @param 保険者名 HokenjaName
     */
    @Override
    public void setHokenjaName(RString 保険者名) {
        getHandler().setHokenjaName(保険者名);
    }
}
