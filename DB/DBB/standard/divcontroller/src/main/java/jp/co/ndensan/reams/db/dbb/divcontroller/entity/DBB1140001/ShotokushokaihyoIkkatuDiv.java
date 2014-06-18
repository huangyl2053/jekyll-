package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB1140001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB1140001.dgSaihakko_Row;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShotokushokaihyoIkkatu のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShotokushokaihyoIkkatuDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlShoriNendo")
    private DropDownList ddlShoriNendo;
    @JsonProperty("linShotokushokai1")
    private HorizontalLine linShotokushokai1;
    @JsonProperty("chkShuturyokuTaisho")
    private CheckBoxList chkShuturyokuTaisho;
    @JsonProperty("ShotokushokaihyoShutsuryokuJun")
    private ChohyoShutsuryokujunDiv ShotokushokaihyoShutsuryokuJun;
    @JsonProperty("chkSaihakko")
    private CheckBoxList chkSaihakko;
    @JsonProperty("dgSaihakko")
    private DataGrid<dgSaihakko_Row> dgSaihakko;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ddlShoriNendo")
    public DropDownList getDdlShoriNendo() {
        return ddlShoriNendo;
    }

    @JsonProperty("ddlShoriNendo")
    public void setDdlShoriNendo(DropDownList ddlShoriNendo) {
        this.ddlShoriNendo=ddlShoriNendo;
    }

    @JsonProperty("linShotokushokai1")
    public HorizontalLine getLinShotokushokai1() {
        return linShotokushokai1;
    }

    @JsonProperty("linShotokushokai1")
    public void setLinShotokushokai1(HorizontalLine linShotokushokai1) {
        this.linShotokushokai1=linShotokushokai1;
    }

    @JsonProperty("chkShuturyokuTaisho")
    public CheckBoxList getChkShuturyokuTaisho() {
        return chkShuturyokuTaisho;
    }

    @JsonProperty("chkShuturyokuTaisho")
    public void setChkShuturyokuTaisho(CheckBoxList chkShuturyokuTaisho) {
        this.chkShuturyokuTaisho=chkShuturyokuTaisho;
    }

    @JsonProperty("ShotokushokaihyoShutsuryokuJun")
    public ChohyoShutsuryokujunDiv getShotokushokaihyoShutsuryokuJun() {
        return ShotokushokaihyoShutsuryokuJun;
    }

    @JsonProperty("ShotokushokaihyoShutsuryokuJun")
    public void setShotokushokaihyoShutsuryokuJun(ChohyoShutsuryokujunDiv ShotokushokaihyoShutsuryokuJun) {
        this.ShotokushokaihyoShutsuryokuJun=ShotokushokaihyoShutsuryokuJun;
    }

    @JsonProperty("chkSaihakko")
    public CheckBoxList getChkSaihakko() {
        return chkSaihakko;
    }

    @JsonProperty("chkSaihakko")
    public void setChkSaihakko(CheckBoxList chkSaihakko) {
        this.chkSaihakko=chkSaihakko;
    }

    @JsonProperty("dgSaihakko")
    public DataGrid<dgSaihakko_Row> getDgSaihakko() {
        return dgSaihakko;
    }

    @JsonProperty("dgSaihakko")
    public void setDgSaihakko(DataGrid<dgSaihakko_Row> dgSaihakko) {
        this.dgSaihakko=dgSaihakko;
    }

}
