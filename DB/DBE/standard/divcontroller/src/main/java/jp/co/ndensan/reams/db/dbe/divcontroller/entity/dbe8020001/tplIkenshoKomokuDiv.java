package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001.Ikensho5KomokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001.IkenshoTokkiJikoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001.SeikatsuKinoServiceDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001.ShinshinJotaiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001.ShobyoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001.TokubetsuIryoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tplIkenshoKomoku のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplIkenshoKomokuDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("Shobyo")
    private ShobyoDiv Shobyo;
    @JsonProperty("TokubetsuIryo")
    private TokubetsuIryoDiv TokubetsuIryo;
    @JsonProperty("ShinshinJotai")
    private ShinshinJotaiDiv ShinshinJotai;
    @JsonProperty("SeikatsuKinoService")
    private SeikatsuKinoServiceDiv SeikatsuKinoService;
    @JsonProperty("IkenshoTokkiJiko")
    private IkenshoTokkiJikoDiv IkenshoTokkiJiko;
    @JsonProperty("Ikensho5Komoku")
    private Ikensho5KomokuDiv Ikensho5Komoku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("Shobyo")
    public ShobyoDiv getShobyo() {
        return Shobyo;
    }

    @JsonProperty("Shobyo")
    public void setShobyo(ShobyoDiv Shobyo) {
        this.Shobyo=Shobyo;
    }

    @JsonProperty("TokubetsuIryo")
    public TokubetsuIryoDiv getTokubetsuIryo() {
        return TokubetsuIryo;
    }

    @JsonProperty("TokubetsuIryo")
    public void setTokubetsuIryo(TokubetsuIryoDiv TokubetsuIryo) {
        this.TokubetsuIryo=TokubetsuIryo;
    }

    @JsonProperty("ShinshinJotai")
    public ShinshinJotaiDiv getShinshinJotai() {
        return ShinshinJotai;
    }

    @JsonProperty("ShinshinJotai")
    public void setShinshinJotai(ShinshinJotaiDiv ShinshinJotai) {
        this.ShinshinJotai=ShinshinJotai;
    }

    @JsonProperty("SeikatsuKinoService")
    public SeikatsuKinoServiceDiv getSeikatsuKinoService() {
        return SeikatsuKinoService;
    }

    @JsonProperty("SeikatsuKinoService")
    public void setSeikatsuKinoService(SeikatsuKinoServiceDiv SeikatsuKinoService) {
        this.SeikatsuKinoService=SeikatsuKinoService;
    }

    @JsonProperty("IkenshoTokkiJiko")
    public IkenshoTokkiJikoDiv getIkenshoTokkiJiko() {
        return IkenshoTokkiJiko;
    }

    @JsonProperty("IkenshoTokkiJiko")
    public void setIkenshoTokkiJiko(IkenshoTokkiJikoDiv IkenshoTokkiJiko) {
        this.IkenshoTokkiJiko=IkenshoTokkiJiko;
    }

    @JsonProperty("Ikensho5Komoku")
    public Ikensho5KomokuDiv getIkensho5Komoku() {
        return Ikensho5Komoku;
    }

    @JsonProperty("Ikensho5Komoku")
    public void setIkensho5Komoku(Ikensho5KomokuDiv Ikensho5Komoku) {
        this.Ikensho5Komoku=Ikensho5Komoku;
    }

}
