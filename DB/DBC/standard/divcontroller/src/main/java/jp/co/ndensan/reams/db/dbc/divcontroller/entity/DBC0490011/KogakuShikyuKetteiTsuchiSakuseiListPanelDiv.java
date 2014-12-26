package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0490011;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigoChohyoShutsuryokujun.KaigoChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.printcontentssetting.PrintContentsSettingDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;

/**
 * KogakuShikyuKetteiTsuchiSakuseiListPanel のクラスファイル
 *
 * @author 自動生成
 */
public class KogakuShikyuKetteiTsuchiSakuseiListPanelDiv extends PanelPublish {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("KogakuShikyuKetteiTsuchiSakuseiListtHakkoDate")
    private PrintContentsSettingDiv KogakuShikyuKetteiTsuchiSakuseiListtHakkoDate;
    @JsonProperty("CommonKariChildDiv1")
    private KaigoChohyoShutsuryokujunDiv CommonKariChildDiv1;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("KogakuShikyuKetteiTsuchiSakuseiListtHakkoDate")
    public PrintContentsSettingDiv getKogakuShikyuKetteiTsuchiSakuseiListtHakkoDate() {
        return KogakuShikyuKetteiTsuchiSakuseiListtHakkoDate;
    }

    @JsonProperty("KogakuShikyuKetteiTsuchiSakuseiListtHakkoDate")
    public void setKogakuShikyuKetteiTsuchiSakuseiListtHakkoDate(PrintContentsSettingDiv KogakuShikyuKetteiTsuchiSakuseiListtHakkoDate) {
        this.KogakuShikyuKetteiTsuchiSakuseiListtHakkoDate = KogakuShikyuKetteiTsuchiSakuseiListtHakkoDate;
    }

    @JsonProperty("CommonKariChildDiv1")
    public KaigoChohyoShutsuryokujunDiv getCommonKariChildDiv1() {
        return CommonKariChildDiv1;
    }

    @JsonProperty("CommonKariChildDiv1")
    public void setCommonKariChildDiv1(KaigoChohyoShutsuryokujunDiv CommonKariChildDiv1) {
        this.CommonKariChildDiv1 = CommonKariChildDiv1;
    }

}
