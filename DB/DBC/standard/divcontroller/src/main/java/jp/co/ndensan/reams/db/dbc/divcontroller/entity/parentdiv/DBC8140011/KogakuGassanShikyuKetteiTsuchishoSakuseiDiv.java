package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8140011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KogakuGassanShikyuKetteiTsuchishoSakusei のクラスファイル
 *
 * @reamsid_L DBC-4850-010 chenyadong
 */
public class KogakuGassanShikyuKetteiTsuchishoSakuseiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("linLine")
    private HorizontalLine linLine;
    @JsonProperty("ddlTaishoNendo")
    private DropDownList ddlTaishoNendo;
    @JsonProperty("ddlRearakuhyoSeiriNO")
    private DropDownList ddlRearakuhyoSeiriNO;
    @JsonProperty("ddlRirekiNO")
    private DropDownList ddlRirekiNO;
    @JsonProperty("KogakuGassanShikyuKetteiTsuchishoSakuseiKaigoKihon")
    private KaigoShikakuKihonDiv KogakuGassanShikyuKetteiTsuchishoSakuseiKaigoKihon;
    @JsonProperty("KogakuGassanShikyuKetteiTsuchishoSakuseiKihon")
    private KaigoAtenaInfoDiv KogakuGassanShikyuKetteiTsuchishoSakuseiKihon;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlinLine
     * @return linLine
     */
    @JsonProperty("linLine")
    public HorizontalLine getLinLine() {
        return linLine;
    }

    /*
     * setlinLine
     * @param linLine linLine
     */
    @JsonProperty("linLine")
    public void setLinLine(HorizontalLine linLine) {
        this.linLine = linLine;
    }

    /*
     * getddlTaishoNendo
     * @return ddlTaishoNendo
     */
    @JsonProperty("ddlTaishoNendo")
    public DropDownList getDdlTaishoNendo() {
        return ddlTaishoNendo;
    }

    /*
     * setddlTaishoNendo
     * @param ddlTaishoNendo ddlTaishoNendo
     */
    @JsonProperty("ddlTaishoNendo")
    public void setDdlTaishoNendo(DropDownList ddlTaishoNendo) {
        this.ddlTaishoNendo = ddlTaishoNendo;
    }

    /*
     * getddlRearakuhyoSeiriNO
     * @return ddlRearakuhyoSeiriNO
     */
    @JsonProperty("ddlRearakuhyoSeiriNO")
    public DropDownList getDdlRearakuhyoSeiriNO() {
        return ddlRearakuhyoSeiriNO;
    }

    /*
     * setddlRearakuhyoSeiriNO
     * @param ddlRearakuhyoSeiriNO ddlRearakuhyoSeiriNO
     */
    @JsonProperty("ddlRearakuhyoSeiriNO")
    public void setDdlRearakuhyoSeiriNO(DropDownList ddlRearakuhyoSeiriNO) {
        this.ddlRearakuhyoSeiriNO = ddlRearakuhyoSeiriNO;
    }

    /*
     * getddlRirekiNO
     * @return ddlRirekiNO
     */
    @JsonProperty("ddlRirekiNO")
    public DropDownList getDdlRirekiNO() {
        return ddlRirekiNO;
    }

    /*
     * setddlRirekiNO
     * @param ddlRirekiNO ddlRirekiNO
     */
    @JsonProperty("ddlRirekiNO")
    public void setDdlRirekiNO(DropDownList ddlRirekiNO) {
        this.ddlRirekiNO = ddlRirekiNO;
    }

    /*
     * getKogakuGassanShikyuKetteiTsuchishoSakuseiKaigoKihon
     * @return KogakuGassanShikyuKetteiTsuchishoSakuseiKaigoKihon
     */
    @JsonProperty("KogakuGassanShikyuKetteiTsuchishoSakuseiKaigoKihon")
    public IKaigoShikakuKihonDiv getKogakuGassanShikyuKetteiTsuchishoSakuseiKaigoKihon() {
        return KogakuGassanShikyuKetteiTsuchishoSakuseiKaigoKihon;
    }

    /*
     * getKogakuGassanShikyuKetteiTsuchishoSakuseiKihon
     * @return KogakuGassanShikyuKetteiTsuchishoSakuseiKihon
     */
    @JsonProperty("KogakuGassanShikyuKetteiTsuchishoSakuseiKihon")
    public IKaigoAtenaInfoDiv getKogakuGassanShikyuKetteiTsuchishoSakuseiKihon() {
        return KogakuGassanShikyuKetteiTsuchishoSakuseiKihon;
    }

    // </editor-fold>
}
