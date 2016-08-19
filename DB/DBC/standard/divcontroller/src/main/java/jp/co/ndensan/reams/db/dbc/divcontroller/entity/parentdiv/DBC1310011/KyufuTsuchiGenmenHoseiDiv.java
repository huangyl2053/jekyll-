package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1310011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KyufuTsuchiGenmenHosei のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyufuTsuchiGenmenHoseiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KyufuTsuchiGenmenHoseiListSakusei")
    private KyufuTsuchiGenmenHoseiListSakuseiDiv KyufuTsuchiGenmenHoseiListSakusei;
    @JsonProperty("KyufuTsuchiGenmenHoseiListSakuseiPrint")
    private KyufuTsuchiGenmenHoseiListSakuseiPrintDiv KyufuTsuchiGenmenHoseiListSakuseiPrint;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKyufuTsuchiGenmenHoseiListSakusei
     * @return KyufuTsuchiGenmenHoseiListSakusei
     */
    @JsonProperty("KyufuTsuchiGenmenHoseiListSakusei")
    public KyufuTsuchiGenmenHoseiListSakuseiDiv getKyufuTsuchiGenmenHoseiListSakusei() {
        return KyufuTsuchiGenmenHoseiListSakusei;
    }

    /*
     * setKyufuTsuchiGenmenHoseiListSakusei
     * @param KyufuTsuchiGenmenHoseiListSakusei KyufuTsuchiGenmenHoseiListSakusei
     */
    @JsonProperty("KyufuTsuchiGenmenHoseiListSakusei")
    public void setKyufuTsuchiGenmenHoseiListSakusei(KyufuTsuchiGenmenHoseiListSakuseiDiv KyufuTsuchiGenmenHoseiListSakusei) {
        this.KyufuTsuchiGenmenHoseiListSakusei = KyufuTsuchiGenmenHoseiListSakusei;
    }

    /*
     * getKyufuTsuchiGenmenHoseiListSakuseiPrint
     * @return KyufuTsuchiGenmenHoseiListSakuseiPrint
     */
    @JsonProperty("KyufuTsuchiGenmenHoseiListSakuseiPrint")
    public KyufuTsuchiGenmenHoseiListSakuseiPrintDiv getKyufuTsuchiGenmenHoseiListSakuseiPrint() {
        return KyufuTsuchiGenmenHoseiListSakuseiPrint;
    }

    /*
     * setKyufuTsuchiGenmenHoseiListSakuseiPrint
     * @param KyufuTsuchiGenmenHoseiListSakuseiPrint KyufuTsuchiGenmenHoseiListSakuseiPrint
     */
    @JsonProperty("KyufuTsuchiGenmenHoseiListSakuseiPrint")
    public void setKyufuTsuchiGenmenHoseiListSakuseiPrint(KyufuTsuchiGenmenHoseiListSakuseiPrintDiv KyufuTsuchiGenmenHoseiListSakuseiPrint) {
        this.KyufuTsuchiGenmenHoseiListSakuseiPrint = KyufuTsuchiGenmenHoseiListSakuseiPrint;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDateRange getTxtServiceYM() {
        return this.getKyufuTsuchiGenmenHoseiListSakusei().getTxtServiceYM();
    }

    @JsonIgnore
    public void  setTxtServiceYM(TextBoxDateRange txtServiceYM) {
        this.getKyufuTsuchiGenmenHoseiListSakusei().setTxtServiceYM(txtServiceYM);
    }

    @JsonIgnore
    public DropDownList getDdlShichoson() {
        return this.getKyufuTsuchiGenmenHoseiListSakusei().getDdlShichoson();
    }

    @JsonIgnore
    public void  setDdlShichoson(DropDownList ddlShichoson) {
        this.getKyufuTsuchiGenmenHoseiListSakusei().setDdlShichoson(ddlShichoson);
    }

    @JsonIgnore
    public IChohyoShutsuryokujunDiv getCcdChohyoShutsuryokujun() {
        return this.getKyufuTsuchiGenmenHoseiListSakuseiPrint().getCcdChohyoShutsuryokujun();
    }

    // </editor-fold>
}
