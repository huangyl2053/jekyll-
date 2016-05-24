package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatesakijushohenshu.KaigoAtesakiJushoHenshu;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JushoHenshu2 のクラスファイル 
 * 
 * @author 自動生成
 */
public class JushoHenshu2Div extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlChoikiHenshu")
    private DropDownList ddlChoikiHenshu;
    @JsonProperty("radKatagakiHyojiUmu")
    private RadioButton radKatagakiHyojiUmu;
    @JsonProperty("SpaceJusho")
    private Space SpaceJusho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlChoikiHenshu
     * @return ddlChoikiHenshu
     */
    @JsonProperty("ddlChoikiHenshu")
    public DropDownList getDdlChoikiHenshu() {
        return ddlChoikiHenshu;
    }

    /*
     * setddlChoikiHenshu
     * @param ddlChoikiHenshu ddlChoikiHenshu
     */
    @JsonProperty("ddlChoikiHenshu")
    public void setDdlChoikiHenshu(DropDownList ddlChoikiHenshu) {
        this.ddlChoikiHenshu = ddlChoikiHenshu;
    }

    /*
     * getradKatagakiHyojiUmu
     * @return radKatagakiHyojiUmu
     */
    @JsonProperty("radKatagakiHyojiUmu")
    public RadioButton getRadKatagakiHyojiUmu() {
        return radKatagakiHyojiUmu;
    }

    /*
     * setradKatagakiHyojiUmu
     * @param radKatagakiHyojiUmu radKatagakiHyojiUmu
     */
    @JsonProperty("radKatagakiHyojiUmu")
    public void setRadKatagakiHyojiUmu(RadioButton radKatagakiHyojiUmu) {
        this.radKatagakiHyojiUmu = radKatagakiHyojiUmu;
    }

    /*
     * getSpaceJusho
     * @return SpaceJusho
     */
    @JsonProperty("SpaceJusho")
    public Space getSpaceJusho() {
        return SpaceJusho;
    }

    /*
     * setSpaceJusho
     * @param SpaceJusho SpaceJusho
     */
    @JsonProperty("SpaceJusho")
    public void setSpaceJusho(Space SpaceJusho) {
        this.SpaceJusho = SpaceJusho;
    }

    // </editor-fold>
}
