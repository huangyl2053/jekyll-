package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5100011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.IShisetsuJohoCommonChildDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.ShisetsuJohoCommonChildDivDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChushutsuJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChushutsuJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KyufuJissekiJoken")
    private KyufuJissekiJokenDiv KyufuJissekiJoken;
    @JsonProperty("RiyojokyoJoken")
    private RiyojokyoJokenDiv RiyojokyoJoken;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKyufuJissekiJoken
     * @return KyufuJissekiJoken
     */
    @JsonProperty("KyufuJissekiJoken")
    public KyufuJissekiJokenDiv getKyufuJissekiJoken() {
        return KyufuJissekiJoken;
    }

    /*
     * setKyufuJissekiJoken
     * @param KyufuJissekiJoken KyufuJissekiJoken
     */
    @JsonProperty("KyufuJissekiJoken")
    public void setKyufuJissekiJoken(KyufuJissekiJokenDiv KyufuJissekiJoken) {
        this.KyufuJissekiJoken = KyufuJissekiJoken;
    }

    /*
     * getRiyojokyoJoken
     * @return RiyojokyoJoken
     */
    @JsonProperty("RiyojokyoJoken")
    public RiyojokyoJokenDiv getRiyojokyoJoken() {
        return RiyojokyoJoken;
    }

    /*
     * setRiyojokyoJoken
     * @param RiyojokyoJoken RiyojokyoJoken
     */
    @JsonProperty("RiyojokyoJoken")
    public void setRiyojokyoJoken(RiyojokyoJokenDiv RiyojokyoJoken) {
        this.RiyojokyoJoken = RiyojokyoJoken;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadTaishoYM() {
        return this.getKyufuJissekiJoken().getRadTaishoYM();
    }

    @JsonIgnore
    public void  setRadTaishoYM(RadioButton radTaishoYM) {
        this.getKyufuJissekiJoken().setRadTaishoYM(radTaishoYM);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtTaishoYmRange() {
        return this.getKyufuJissekiJoken().getTxtTaishoYmRange();
    }

    @JsonIgnore
    public void  setTxtTaishoYmRange(TextBoxDateRange txtTaishoYmRange) {
        this.getKyufuJissekiJoken().setTxtTaishoYmRange(txtTaishoYmRange);
    }

    @JsonIgnore
    public TextBox getTxtHihokenshaNo() {
        return this.getKyufuJissekiJoken().getTxtHihokenshaNo();
    }

    @JsonIgnore
    public void  setTxtHihokenshaNo(TextBox txtHihokenshaNo) {
        this.getKyufuJissekiJoken().setTxtHihokenshaNo(txtHihokenshaNo);
    }

    @JsonIgnore
    public IShisetsuJohoCommonChildDiv getCcdJigyoshaNo() {
        return this.getKyufuJissekiJoken().getCcdJigyoshaNo();
    }

    @JsonIgnore
    public RadioButton getRadRiyoJisseki() {
        return this.getRiyojokyoJoken().getRadRiyoJisseki();
    }

    @JsonIgnore
    public void  setRadRiyoJisseki(RadioButton radRiyoJisseki) {
        this.getRiyojokyoJoken().setRadRiyoJisseki(radRiyoJisseki);
    }

    @JsonIgnore
    public RadioButton getRadKyotakuRiyoritsu() {
        return this.getRiyojokyoJoken().getRadKyotakuRiyoritsu();
    }

    @JsonIgnore
    public void  setRadKyotakuRiyoritsu(RadioButton radKyotakuRiyoritsu) {
        this.getRiyojokyoJoken().setRadKyotakuRiyoritsu(radKyotakuRiyoritsu);
    }

    @JsonIgnore
    public TextBoxNumRange getTxtKyotakuRiyoritsuRange() {
        return this.getRiyojokyoJoken().getTxtKyotakuRiyoritsuRange();
    }

    @JsonIgnore
    public void  setTxtKyotakuRiyoritsuRange(TextBoxNumRange txtKyotakuRiyoritsuRange) {
        this.getRiyojokyoJoken().setTxtKyotakuRiyoritsuRange(txtKyotakuRiyoritsuRange);
    }

    @JsonIgnore
    public RadioButton getRadHomonRiyoritsu() {
        return this.getRiyojokyoJoken().getRadHomonRiyoritsu();
    }

    @JsonIgnore
    public void  setRadHomonRiyoritsu(RadioButton radHomonRiyoritsu) {
        this.getRiyojokyoJoken().setRadHomonRiyoritsu(radHomonRiyoritsu);
    }

    @JsonIgnore
    public TextBoxNumRange getTxtHomonRiyoritsuRange() {
        return this.getRiyojokyoJoken().getTxtHomonRiyoritsuRange();
    }

    @JsonIgnore
    public void  setTxtHomonRiyoritsuRange(TextBoxNumRange txtHomonRiyoritsuRange) {
        this.getRiyojokyoJoken().setTxtHomonRiyoritsuRange(txtHomonRiyoritsuRange);
    }

    // </editor-fold>
}
