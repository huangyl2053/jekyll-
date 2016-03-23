package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KyotakuServiceKeikakuInfo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KyotakuServiceKeikakuInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyotakuServiceKeikakuInfoDiv extends Panel implements IKyotakuServiceKeikakuInfoDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKyotakujigyoCode")
    private TextBoxCode txtKyotakujigyoCode;
    @JsonProperty("txtKyotakuJigyoName")
    private TextBox txtKyotakuJigyoName;
    @JsonProperty("txtSakuseiKubun")
    private TextBoxCode txtSakuseiKubun;
    @JsonProperty("txtTekiyokaishiDay")
    private TextBoxFlexibleDate txtTekiyokaishiDay;
    @JsonProperty("txtTekiyoshuryoDay")
    private TextBoxFlexibleDate txtTekiyoshuryoDay;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKyotakujigyoCode
     * @return txtKyotakujigyoCode
     */
    @JsonProperty("txtKyotakujigyoCode")
    public TextBoxCode getTxtKyotakujigyoCode() {
        return txtKyotakujigyoCode;
    }

    /*
     * settxtKyotakujigyoCode
     * @param txtKyotakujigyoCode txtKyotakujigyoCode
     */
    @JsonProperty("txtKyotakujigyoCode")
    public void setTxtKyotakujigyoCode(TextBoxCode txtKyotakujigyoCode) {
        this.txtKyotakujigyoCode = txtKyotakujigyoCode;
    }

    /*
     * gettxtKyotakuJigyoName
     * @return txtKyotakuJigyoName
     */
    @JsonProperty("txtKyotakuJigyoName")
    public TextBox getTxtKyotakuJigyoName() {
        return txtKyotakuJigyoName;
    }

    /*
     * settxtKyotakuJigyoName
     * @param txtKyotakuJigyoName txtKyotakuJigyoName
     */
    @JsonProperty("txtKyotakuJigyoName")
    public void setTxtKyotakuJigyoName(TextBox txtKyotakuJigyoName) {
        this.txtKyotakuJigyoName = txtKyotakuJigyoName;
    }

    /*
     * gettxtSakuseiKubun
     * @return txtSakuseiKubun
     */
    @JsonProperty("txtSakuseiKubun")
    public TextBoxCode getTxtSakuseiKubun() {
        return txtSakuseiKubun;
    }

    /*
     * settxtSakuseiKubun
     * @param txtSakuseiKubun txtSakuseiKubun
     */
    @JsonProperty("txtSakuseiKubun")
    public void setTxtSakuseiKubun(TextBoxCode txtSakuseiKubun) {
        this.txtSakuseiKubun = txtSakuseiKubun;
    }

    /*
     * gettxtTekiyokaishiDay
     * @return txtTekiyokaishiDay
     */
    @JsonProperty("txtTekiyokaishiDay")
    public TextBoxFlexibleDate getTxtTekiyokaishiDay() {
        return txtTekiyokaishiDay;
    }

    /*
     * settxtTekiyokaishiDay
     * @param txtTekiyokaishiDay txtTekiyokaishiDay
     */
    @JsonProperty("txtTekiyokaishiDay")
    public void setTxtTekiyokaishiDay(TextBoxFlexibleDate txtTekiyokaishiDay) {
        this.txtTekiyokaishiDay = txtTekiyokaishiDay;
    }

    /*
     * gettxtTekiyoshuryoDay
     * @return txtTekiyoshuryoDay
     */
    @JsonProperty("txtTekiyoshuryoDay")
    public TextBoxFlexibleDate getTxtTekiyoshuryoDay() {
        return txtTekiyoshuryoDay;
    }

    /*
     * settxtTekiyoshuryoDay
     * @param txtTekiyoshuryoDay txtTekiyoshuryoDay
     */
    @JsonProperty("txtTekiyoshuryoDay")
    public void setTxtTekiyoshuryoDay(TextBoxFlexibleDate txtTekiyoshuryoDay) {
        this.txtTekiyoshuryoDay = txtTekiyoshuryoDay;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

 /**
     * 居宅サービス計画情報を初期化します。
     * @param hihokenshano 被保険者番号
     */
    @Override
    public void initialize(HihokenshaNo hihokenshano) {
        createHandler().initialize(hihokenshano);
    }
    
     private KyotakuServiceKeikakuInfoHandler createHandler() {
        return new KyotakuServiceKeikakuInfoHandler(this);
    }    
}
