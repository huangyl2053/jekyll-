package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB8110001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.ChoshuYuyoTsuchiKobetsuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.ChoshuYuyoTsuchiKobetsuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.FukadaichoKobetsuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.FukadaichoKobetsuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.GemmenTsuchiKobetsuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.GemmenTsuchiKobetsuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.HenkoTsuchiKobetsuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.HenkoTsuchiKobetsuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.KetteiTsuchiKobetsuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.KetteiTsuchiKobetsuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.NotsuKobetsuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.NotsuKobetsuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.TokuKaishiTsuchiKobetsuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.TokuKaishiTsuchiKobetsuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.YufuriKobetsuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.YufuriKobetsuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.dgChohyoSentaku_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.dgChohyoSentaku_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * TsuchishoSakuseiKobetsu のクラスファイル 
 * 
 * @author 自動生成
 */
public class TsuchishoSakuseiKobetsuDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgChohyoSentaku")
    private DataGrid<dgChohyoSentaku_Row> dgChohyoSentaku;
    @JsonProperty("TokuKaishiTsuchiKobetsu")
    private TokuKaishiTsuchiKobetsuDiv TokuKaishiTsuchiKobetsu;
    @JsonProperty("KetteiTsuchiKobetsu")
    private KetteiTsuchiKobetsuDiv KetteiTsuchiKobetsu;
    @JsonProperty("HenkoTsuchiKobetsu")
    private HenkoTsuchiKobetsuDiv HenkoTsuchiKobetsu;
    @JsonProperty("NotsuKobetsu")
    private NotsuKobetsuDiv NotsuKobetsu;
    @JsonProperty("GemmenTsuchiKobetsu")
    private GemmenTsuchiKobetsuDiv GemmenTsuchiKobetsu;
    @JsonProperty("ChoshuYuyoTsuchiKobetsu")
    private ChoshuYuyoTsuchiKobetsuDiv ChoshuYuyoTsuchiKobetsu;
    @JsonProperty("YufuriKobetsu")
    private YufuriKobetsuDiv YufuriKobetsu;
    @JsonProperty("FukadaichoKobetsu")
    private FukadaichoKobetsuDiv FukadaichoKobetsu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgChohyoSentaku")
    public DataGrid<dgChohyoSentaku_Row> getDgChohyoSentaku() {
        return dgChohyoSentaku;
    }

    @JsonProperty("dgChohyoSentaku")
    public void setDgChohyoSentaku(DataGrid<dgChohyoSentaku_Row> dgChohyoSentaku) {
        this.dgChohyoSentaku=dgChohyoSentaku;
    }

    @JsonProperty("TokuKaishiTsuchiKobetsu")
    public TokuKaishiTsuchiKobetsuDiv getTokuKaishiTsuchiKobetsu() {
        return TokuKaishiTsuchiKobetsu;
    }

    @JsonProperty("TokuKaishiTsuchiKobetsu")
    public void setTokuKaishiTsuchiKobetsu(TokuKaishiTsuchiKobetsuDiv TokuKaishiTsuchiKobetsu) {
        this.TokuKaishiTsuchiKobetsu=TokuKaishiTsuchiKobetsu;
    }

    @JsonProperty("KetteiTsuchiKobetsu")
    public KetteiTsuchiKobetsuDiv getKetteiTsuchiKobetsu() {
        return KetteiTsuchiKobetsu;
    }

    @JsonProperty("KetteiTsuchiKobetsu")
    public void setKetteiTsuchiKobetsu(KetteiTsuchiKobetsuDiv KetteiTsuchiKobetsu) {
        this.KetteiTsuchiKobetsu=KetteiTsuchiKobetsu;
    }

    @JsonProperty("HenkoTsuchiKobetsu")
    public HenkoTsuchiKobetsuDiv getHenkoTsuchiKobetsu() {
        return HenkoTsuchiKobetsu;
    }

    @JsonProperty("HenkoTsuchiKobetsu")
    public void setHenkoTsuchiKobetsu(HenkoTsuchiKobetsuDiv HenkoTsuchiKobetsu) {
        this.HenkoTsuchiKobetsu=HenkoTsuchiKobetsu;
    }

    @JsonProperty("NotsuKobetsu")
    public NotsuKobetsuDiv getNotsuKobetsu() {
        return NotsuKobetsu;
    }

    @JsonProperty("NotsuKobetsu")
    public void setNotsuKobetsu(NotsuKobetsuDiv NotsuKobetsu) {
        this.NotsuKobetsu=NotsuKobetsu;
    }

    @JsonProperty("GemmenTsuchiKobetsu")
    public GemmenTsuchiKobetsuDiv getGemmenTsuchiKobetsu() {
        return GemmenTsuchiKobetsu;
    }

    @JsonProperty("GemmenTsuchiKobetsu")
    public void setGemmenTsuchiKobetsu(GemmenTsuchiKobetsuDiv GemmenTsuchiKobetsu) {
        this.GemmenTsuchiKobetsu=GemmenTsuchiKobetsu;
    }

    @JsonProperty("ChoshuYuyoTsuchiKobetsu")
    public ChoshuYuyoTsuchiKobetsuDiv getChoshuYuyoTsuchiKobetsu() {
        return ChoshuYuyoTsuchiKobetsu;
    }

    @JsonProperty("ChoshuYuyoTsuchiKobetsu")
    public void setChoshuYuyoTsuchiKobetsu(ChoshuYuyoTsuchiKobetsuDiv ChoshuYuyoTsuchiKobetsu) {
        this.ChoshuYuyoTsuchiKobetsu=ChoshuYuyoTsuchiKobetsu;
    }

    @JsonProperty("YufuriKobetsu")
    public YufuriKobetsuDiv getYufuriKobetsu() {
        return YufuriKobetsu;
    }

    @JsonProperty("YufuriKobetsu")
    public void setYufuriKobetsu(YufuriKobetsuDiv YufuriKobetsu) {
        this.YufuriKobetsu=YufuriKobetsu;
    }

    @JsonProperty("FukadaichoKobetsu")
    public FukadaichoKobetsuDiv getFukadaichoKobetsu() {
        return FukadaichoKobetsu;
    }

    @JsonProperty("FukadaichoKobetsu")
    public void setFukadaichoKobetsu(FukadaichoKobetsuDiv FukadaichoKobetsu) {
        this.FukadaichoKobetsu=FukadaichoKobetsu;
    }

}
