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

    // </editor-fold>
}
