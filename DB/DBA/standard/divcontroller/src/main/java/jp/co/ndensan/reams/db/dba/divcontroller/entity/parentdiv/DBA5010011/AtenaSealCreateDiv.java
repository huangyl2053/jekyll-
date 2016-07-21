package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA5010011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaSealPositionInput.AtenaSealPositionInputDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaSealPositionInput.IAtenaSealPositionInputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * AtenaSealCreate のクラスファイル 
 * 
 * @author 自動生成
 */
public class AtenaSealCreateDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("CyushutsuJoken")
    private CyushutsuJokenDiv CyushutsuJoken;
    @JsonProperty("HensyuHoho")
    private HensyuHohoDiv HensyuHoho;
    @JsonProperty("ccdAtenaSealPosition")
    private AtenaSealPositionInputDiv ccdAtenaSealPosition;
    @JsonProperty("ccdShutsuryokuJun")
    private ChohyoShutsuryokujunDiv ccdShutsuryokuJun;
    @JsonProperty("hidden_shikakuShutoku")
    private RString hidden_shikakuShutoku;
    @JsonProperty("hidden_nenreiTotatsu")
    private RString hidden_nenreiTotatsu;
    @JsonProperty("hidden_jutokuNomi")
    private RString hidden_jutokuNomi;
    @JsonProperty("hidden_jukyuNinteiShinseityuIgai")
    private RString hidden_jukyuNinteiShinseityuIgai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getCyushutsuJoken
     * @return CyushutsuJoken
     */
    @JsonProperty("CyushutsuJoken")
    public CyushutsuJokenDiv getCyushutsuJoken() {
        return CyushutsuJoken;
    }

    /*
     * setCyushutsuJoken
     * @param CyushutsuJoken CyushutsuJoken
     */
    @JsonProperty("CyushutsuJoken")
    public void setCyushutsuJoken(CyushutsuJokenDiv CyushutsuJoken) {
        this.CyushutsuJoken = CyushutsuJoken;
    }

    /*
     * getHensyuHoho
     * @return HensyuHoho
     */
    @JsonProperty("HensyuHoho")
    public HensyuHohoDiv getHensyuHoho() {
        return HensyuHoho;
    }

    /*
     * setHensyuHoho
     * @param HensyuHoho HensyuHoho
     */
    @JsonProperty("HensyuHoho")
    public void setHensyuHoho(HensyuHohoDiv HensyuHoho) {
        this.HensyuHoho = HensyuHoho;
    }

    /*
     * getccdAtenaSealPosition
     * @return ccdAtenaSealPosition
     */
    @JsonProperty("ccdAtenaSealPosition")
    public IAtenaSealPositionInputDiv getCcdAtenaSealPosition() {
        return ccdAtenaSealPosition;
    }

    /*
     * getccdShutsuryokuJun
     * @return ccdShutsuryokuJun
     */
    @JsonProperty("ccdShutsuryokuJun")
    public IChohyoShutsuryokujunDiv getCcdShutsuryokuJun() {
        return ccdShutsuryokuJun;
    }

    /*
     * gethidden_shikakuShutoku
     * @return hidden_shikakuShutoku
     */
    @JsonProperty("hidden_shikakuShutoku")
    public RString getHidden_shikakuShutoku() {
        return hidden_shikakuShutoku;
    }

    /*
     * sethidden_shikakuShutoku
     * @param hidden_shikakuShutoku hidden_shikakuShutoku
     */
    @JsonProperty("hidden_shikakuShutoku")
    public void setHidden_shikakuShutoku(RString hidden_shikakuShutoku) {
        this.hidden_shikakuShutoku = hidden_shikakuShutoku;
    }

    /*
     * gethidden_nenreiTotatsu
     * @return hidden_nenreiTotatsu
     */
    @JsonProperty("hidden_nenreiTotatsu")
    public RString getHidden_nenreiTotatsu() {
        return hidden_nenreiTotatsu;
    }

    /*
     * sethidden_nenreiTotatsu
     * @param hidden_nenreiTotatsu hidden_nenreiTotatsu
     */
    @JsonProperty("hidden_nenreiTotatsu")
    public void setHidden_nenreiTotatsu(RString hidden_nenreiTotatsu) {
        this.hidden_nenreiTotatsu = hidden_nenreiTotatsu;
    }

    /*
     * gethidden_jutokuNomi
     * @return hidden_jutokuNomi
     */
    @JsonProperty("hidden_jutokuNomi")
    public RString getHidden_jutokuNomi() {
        return hidden_jutokuNomi;
    }

    /*
     * sethidden_jutokuNomi
     * @param hidden_jutokuNomi hidden_jutokuNomi
     */
    @JsonProperty("hidden_jutokuNomi")
    public void setHidden_jutokuNomi(RString hidden_jutokuNomi) {
        this.hidden_jutokuNomi = hidden_jutokuNomi;
    }

    /*
     * gethidden_jukyuNinteiShinseityuIgai
     * @return hidden_jukyuNinteiShinseityuIgai
     */
    @JsonProperty("hidden_jukyuNinteiShinseityuIgai")
    public RString getHidden_jukyuNinteiShinseityuIgai() {
        return hidden_jukyuNinteiShinseityuIgai;
    }

    /*
     * sethidden_jukyuNinteiShinseityuIgai
     * @param hidden_jukyuNinteiShinseityuIgai hidden_jukyuNinteiShinseityuIgai
     */
    @JsonProperty("hidden_jukyuNinteiShinseityuIgai")
    public void setHidden_jukyuNinteiShinseityuIgai(RString hidden_jukyuNinteiShinseityuIgai) {
        this.hidden_jukyuNinteiShinseityuIgai = hidden_jukyuNinteiShinseityuIgai;
    }

    // </editor-fold>
}
