package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hihokenshafinder.HihokenshaFinder;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.kaigosaikinshorisharireki.IKaigoSaikinShorishaRirekiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.kaigosaikinshorisharireki.KaigoSaikinShorishaRirekiDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaFinder.AtenaFinderDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaFinder.IAtenaFinderDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.IShikibetsuTaishoSearchKey;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * HihokenshaFinder のクラスファイル
 *
 * @author 自動生成
 */
public class HihokenshaFinderDiv extends Panel implements IHihokenshaFinderDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KaigoFinder")
    private KaigoFinderDiv KaigoFinder;
    @JsonProperty("ccdAtenaFinder")
    private AtenaFinderDiv ccdAtenaFinder;
    @JsonProperty("ButtonsForHihokenshaFinder")
    private ButtonsForHihokenshaFinderDiv ButtonsForHihokenshaFinder;
    @JsonProperty("ccdSaikinShorisha")
    private KaigoSaikinShorishaRirekiDiv ccdSaikinShorisha;
    @JsonProperty("btnHihokenshaFinderHyoji")
    private Button btnHihokenshaFinderHyoji;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("KaigoFinder")
    public KaigoFinderDiv getKaigoFinder() {
        return KaigoFinder;
    }

    @JsonProperty("KaigoFinder")
    public void setKaigoFinder(KaigoFinderDiv KaigoFinder) {
        this.KaigoFinder = KaigoFinder;
    }

    @JsonProperty("ccdAtenaFinder")
    public IAtenaFinderDiv getCcdAtenaFinder() {
        return ccdAtenaFinder;
    }

    @JsonProperty("ButtonsForHihokenshaFinder")
    public ButtonsForHihokenshaFinderDiv getButtonsForHihokenshaFinder() {
        return ButtonsForHihokenshaFinder;
    }

    @JsonProperty("ButtonsForHihokenshaFinder")
    public void setButtonsForHihokenshaFinder(ButtonsForHihokenshaFinderDiv ButtonsForHihokenshaFinder) {
        this.ButtonsForHihokenshaFinder = ButtonsForHihokenshaFinder;
    }

    @JsonProperty("ccdSaikinShorisha")
    public IKaigoSaikinShorishaRirekiDiv getCcdSaikinShorisha() {
        return ccdSaikinShorisha;
    }

    @JsonProperty("btnHihokenshaFinderHyoji")
    public Button getBtnHihokenshaFinderHyoji() {
        return btnHihokenshaFinderHyoji;
    }

    @JsonProperty("btnHihokenshaFinderHyoji")
    public void setBtnHihokenshaFinderHyoji(Button btnHihokenshaFinderHyoji) {
        this.btnHihokenshaFinderHyoji = btnHihokenshaFinderHyoji;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public RString get保険者() {
        return getHandler().get保険者();
    }

    @Override
    public RString get被保険者番号() {
        return getHandler().get被保険者番号();
    }

    @Override
    public RString get通知書番号() {
        return getHandler().get通知書番号();
    }

    @Override
    public FlexibleYear get賦課年度() {
        return getHandler().get賦課年度();
    }

    @Override
    public boolean is被保険者台帳登録者() {
        return getHandler().is被保険者台帳登録者();
    }

    @Override
    public boolean is受給者台帳登録者() {
        return getHandler().is受給者台帳登録者();
    }

    @Override
    public boolean is住所地特例者() {
        return getHandler().is住所地特例者();
    }

    @Override
    public boolean isみなし２号含む() {
        return getHandler().isみなし２号含む();
    }

    @Override
    public int get最大表示件数() {
        return getHandler().get最大表示件数();
    }

    @Override
    public IShikibetsuTaishoSearchKey get宛名条件() {
        return getHandler().get宛名条件();
    }

    @Override
    public void load最近処理者() {
        getHandler().load最近処理者();
    }

    @Override
    public void save最近処理者(ShikibetsuCode 識別コード, AtenaMeisho 名称) {
        getHandler().save最近処理者(識別コード, 名称);
    }

    @Override
    public RString get最近処理者() {
        return getHandler().get最近処理者();
    }

    @JsonIgnore
    private HihokenshaFinderHandler getHandler() {
        return new HihokenshaFinderHandler(this);
    }

}
