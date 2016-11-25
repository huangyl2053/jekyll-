/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010019;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiJutakuKaishuhi;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiJutakuKaishuhiBusiness;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010019.JyutakuKayisyuHiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010019.dgJutakuKaishuhi_Row;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 画面設計_DBCMN11002_給付実績照会_(DBC0010019)住宅改修費のHandlerです。
 *
 * @reamsid_L DBC-2970-110 lishengli
 */
public class JyutakuKayisyuHiHandler {

    private static final RString ZERO = new RString("0");
    private final JyutakuKayisyuHiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div JyutakuKayisyuHiDiv
     */
    public JyutakuKayisyuHiHandler(JyutakuKayisyuHiDiv div) {
        this.div = div;
    }

    /**
     * ボタン表示制御の設定処理です。
     *
     * @param 識別番号管理 識別番号管理
     */
    public void setボタン状態(ShikibetsuNoKanri 識別番号管理) {
        div.getBtnKihon().setDisabled(false);
        div.getBtnMeisaiShukei().setDisabled(false);
        div.getBtnShokuji().setDisabled(false);
        div.getBtnFukushiYoguKonyu().setDisabled(false);
        div.getBtnTokuteiNyushosha().setDisabled(false);
        div.getBtnKogakuKaigoService().setDisabled(true);
        div.getBtnTokuteiShinryo().setDisabled(false);
        div.getBtnKyotakuServiceKeikaku().setDisabled(false);
        div.getBtnCareManagement().setDisabled(false);
        div.getBtnShafukuKeigen().setDisabled(false);
        if (ZERO.equals(識別番号管理.get基本設定区分())) {
            div.getBtnKihon().setDisabled(true);
        }
        if (ZERO.equals(識別番号管理.get明細設定区分())) {
            div.getBtnMeisaiShukei().setDisabled(true);
        }
        if (ZERO.equals(識別番号管理.get所定疾患施設療養設定区分())) {
            div.getBtnShoteiShikkanShisetsuRyoyo().setDisabled(true);
        }
        if (ZERO.equals(識別番号管理.get食事費用設定区分())) {
            div.getBtnShokuji().setDisabled(true);
        }
        if (ZERO.equals(識別番号管理.get福祉用具購入費設定区分())) {
            div.getBtnFukushiYoguKonyu().setDisabled(true);
        }
        if (ZERO.equals(識別番号管理.get特定入所者設定区分())) {
            div.getBtnTokuteiNyushosha().setDisabled(true);
        }
        if (ZERO.equals(識別番号管理.get特定診療費設定区分())) {
            div.getBtnTokuteiShinryo().setDisabled(true);
        }
        if (ZERO.equals(識別番号管理.get居宅計画費設定区分())) {
            div.getBtnKyotakuServiceKeikaku().setDisabled(true);
        }
        if (ZERO.equals(識別番号管理.getケアマネジメント設定区分())) {
            div.getBtnCareManagement().setDisabled(true);
        }
        if (ZERO.equals(識別番号管理.get社会福祉法人軽減設定区分())) {
            div.getBtnShafukuKeigen().setDisabled(true);
        }
        if (ZERO.equals(識別番号管理.get所定疾患施設療養設定区分())) {

            div.getBtnShoteiShikkanShisetsuRyoyo().setDisabled(true);
        } else {
            div.getBtnShoteiShikkanShisetsuRyoyo().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理.get緊急時施設療養設定区分())) {
            div.getBtnKinkyujiShisetsuRyoyo().setDisabled(true);
        } else {
            div.getBtnKinkyujiShisetsuRyoyo().setDisabled(false);
        }
    }

    /**
     * データグリッドの設定処理です。
     *
     * @param 給付実績住宅改修費List 給付実績住宅改修費List
     */
    public void setデータグリッド(List<KyufujissekiJutakuKaishuhiBusiness> 給付実績住宅改修費List) {
        List<dgJutakuKaishuhi_Row> rowList = new ArrayList<>();
        for (KyufujissekiJutakuKaishuhiBusiness business : 給付実績住宅改修費List) {
            KyufujissekiJutakuKaishuhi kyufujissekiJutakuKaishuhi = business.get給付実績住宅改修費情報();
            dgJutakuKaishuhi_Row row = new dgJutakuKaishuhi_Row();
            row.setTxtService(business.getサービス種類略称());
            row.setTxtChakkoYMD(getパターン1(kyufujissekiJutakuKaishuhi.get住宅改修着工年月日()));
            row.setTxtJigyoshaName(nullToEMPTY(kyufujissekiJutakuKaishuhi.get住宅改修事業者名()));
            row.setTxtJusho(nullToEMPTY(kyufujissekiJutakuKaishuhi.get住宅改修住宅住所()));
            row.setTxtHiyo(DecimalFormatter.toコンマ区切りRString(kyufujissekiJutakuKaishuhi.get改修金額(), 0));
            row.setTxtShinsaYM(getパターン51(kyufujissekiJutakuKaishuhi.get審査年月()));
            rowList.add(row);
        }
        div.getDgJutakuKaishuhi().setDataSource(rowList);
    }

    private RString getパターン1(FlexibleDate 年月日) {
        if (年月日 != null && !年月日.isEmpty()) {
            return 年月日.wareki().toDateString();
        }
        return RString.EMPTY;
    }

    private RString getパターン51(FlexibleYearMonth 年月) {
        if (年月 != null && !年月.isEmpty()) {
            return 年月.wareki().toDateString();
        }
        return RString.EMPTY;
    }

    private RString nullToEMPTY(RString 項目) {
        if (!RString.isNullOrEmpty(項目)) {
            return 項目;
        }
        return RString.EMPTY;
    }
}
