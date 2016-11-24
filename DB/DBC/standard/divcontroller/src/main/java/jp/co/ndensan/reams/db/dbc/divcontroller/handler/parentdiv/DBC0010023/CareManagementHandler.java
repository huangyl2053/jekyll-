/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010023;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufuJissekiCareManagementHi;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiCareManagementHiBusiness;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010023.CareManagementMainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010023.dgCareManagement_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 給付実績照会のケアマネジメント費のhandlerです。
 *
 * @reamsid_L DBC-2970-150 guoqilin
 */
public class CareManagementHandler {

    private final CareManagementMainDiv div;
    private static final RString ZERO = new RString("0");
    private static final RString 後 = new RString("後");

    /**
     * コンストラクタです。
     *
     * @param div KogakuKaigoServiceMainDiv
     */
    public CareManagementHandler(CareManagementMainDiv div) {
        this.div = div;
    }

    /**
     * ケアマネジメント費等選別です。
     *
     * @param 給付実績ケアマネジメント費データリスト 給付実績ケアマネジメント費データリスト
     * @param 識別番号管理データ 識別番号管理データ
     */
    public void set給付実績ケアマネジメント費データ(
            List<KyufuJissekiCareManagementHiBusiness> 給付実績ケアマネジメント費データリスト, ShikibetsuNoKanri 識別番号管理データ) {
        List<dgCareManagement_Row> dataSources = new ArrayList<>();
        for (KyufuJissekiCareManagementHiBusiness 給付実績ケアマネジメント費データ : 給付実績ケアマネジメント費データリスト) {
            dgCareManagement_Row row1 = new dgCareManagement_Row();
            KyufuJissekiCareManagementHi 給付実績ケアマネジメント費基本情報 = 給付実績ケアマネジメント費データ.get給付実績ケアマネジメント費基本情報();
            row1.setTxtShiteiKijunKubun(給付実績ケアマネジメント費基本情報.get指定_基準該当事業所区分コード());
            row1.setTxtIraiTodokedeYMD(to日期変換(給付実績ケアマネジメント費基本情報.get居宅サービス計画作成依頼届出年月日()));
            row1.setTxtService(給付実績ケアマネジメント費データ.getサービス種類略称());
            row1.setTxtTaniTanka(単位数単価変換(給付実績ケアマネジメント費基本情報.get単位数単価()));
            row1.setTxtKettei(RString.EMPTY);
            row1.setTxtTanisu(new RString(給付実績ケアマネジメント費基本情報.get単位数()));
            row1.setTxtKaisu(new RString(給付実績ケアマネジメント費基本情報.get回数()));
            row1.setTxtServiceTanisu(new RString(給付実績ケアマネジメント費基本情報.getサービス単位数()));
            row1.setTxtServiceTanisuGokei(new RString(給付実績ケアマネジメント費基本情報.getサービス単位数合計()));
            row1.setTxtSeikyuKingaku(get金額(給付実績ケアマネジメント費基本情報.get請求金額()));
            row1.setTxtRiyoshaFutangaku(get金額(給付実績ケアマネジメント費基本情報.get利用者負担額()));
            row1.setTxtSenmoninNo(給付実績ケアマネジメント費基本情報.get担当介護支援専門員番号());
            row1.setTxtSaishinsaKaisu(new RString(給付実績ケアマネジメント費基本情報.get再審査回数()));
            row1.setTxtKagoKaisu(new RString(給付実績ケアマネジメント費基本情報.get過誤回数()));
            row1.setTxtShinsaNengetsu(to日期変換(給付実績ケアマネジメント費基本情報.get審査年月()));
            row1.setTxtTekiyo(給付実績ケアマネジメント費基本情報.get摘要());
            dgCareManagement_Row row2 = new dgCareManagement_Row();
            row2.setTxtTaniTanka(単位数単価変換(給付実績ケアマネジメント費基本情報.get単位数単価()));
            row2.setTxtKettei(後);
            row2.setTxtTanisu(new RString(給付実績ケアマネジメント費基本情報.get後_単位数()));
            row2.setTxtKaisu(new RString(給付実績ケアマネジメント費基本情報.get後_回数()));
            row2.setTxtServiceTanisu(new RString(給付実績ケアマネジメント費基本情報.get後_サービス単位数()));
            row2.setTxtServiceTanisuGokei(new RString(給付実績ケアマネジメント費基本情報.get後_サービス単位数合計()));
            row2.setTxtSeikyuKingaku(get金額(給付実績ケアマネジメント費基本情報.get後_請求金額()));
            row2.setTxtRiyoshaFutangaku(get金額(給付実績ケアマネジメント費基本情報.get後_利用者負担額()));
            row2.setTxtSenmoninNo(給付実績ケアマネジメント費基本情報.get担当介護支援専門員番号());
            row2.setTxtSaishinsaKaisu(new RString(給付実績ケアマネジメント費基本情報.get再審査回数()));
            row2.setTxtKagoKaisu(new RString(給付実績ケアマネジメント費基本情報.get過誤回数()));
            row2.setTxtShinsaNengetsu(to日期変換(給付実績ケアマネジメント費基本情報.get審査年月()));
            row2.setTxtTekiyo(給付実績ケアマネジメント費基本情報.get摘要());
            dataSources.add(row1);
            dataSources.add(row2);
        }
        div.getDgCareManagement().setDataSource(dataSources);
        clear制御性(識別番号管理データ);
    }

    /**
     *
     * 制御性設定です。
     *
     * @param 識別番号管理データ 識別番号
     */
    public void clear制御性(ShikibetsuNoKanri 識別番号管理データ) {
        div.getBtnCareManagement().setDisabled(true);
        div.getBtnKogakuKaigoService().setDisabled(true);
        if (ZERO.equals(識別番号管理データ.get基本設定区分())) {
            div.getBtnKihon().setDisabled(true);
        } else {
            div.getBtnKihon().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理データ.get明細設定区分())) {
            div.getBtnMeisaiShukei().setDisabled(true);
        } else {
            div.getBtnMeisaiShukei().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理データ.get食事費用設定区分())) {
            div.getBtnShokuji().setDisabled(true);
        } else {
            div.getBtnShokuji().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理データ.get福祉用具購入費設定区分())) {
            div.getBtnFukushiYoguKonyu().setDisabled(true);
        } else {
            div.getBtnFukushiYoguKonyu().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理データ.get特定入所者設定区分())) {
            div.getBtnTokuteiNyushosha().setDisabled(true);
        } else {
            div.getBtnTokuteiNyushosha().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理データ.get特定診療費設定区分())) {
            div.getBtnTokuteiShinryo().setDisabled(true);
        } else {
            div.getBtnTokuteiShinryo().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理データ.get居宅計画費設定区分())) {
            div.getBtnKyotakuServiceKeikaku().setDisabled(true);
        } else {
            div.getBtnKyotakuServiceKeikaku().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理データ.get住宅改修費設定区分())) {
            div.getBtnJutakuKaishu().setDisabled(true);
        } else {
            div.getBtnJutakuKaishu().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理データ.get社会福祉法人軽減設定区分())) {
            div.getBtnShafukuKeigen().setDisabled(true);
        } else {
            div.getBtnShafukuKeigen().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理データ.get所定疾患施設療養設定区分())) {
            div.getBtnShoteiShikkanShisetsuRyoyo().setDisabled(true);
        } else {
            div.getBtnShoteiShikkanShisetsuRyoyo().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理データ.get緊急時施設療養設定区分())) {
            div.getBtnKinkyujiShisetsuRyoyo().setDisabled(true);
        } else {
            div.getBtnKinkyujiShisetsuRyoyo().setDisabled(false);
        }
    }

    private RString to日期変換(FlexibleYearMonth 日期) {
        if (日期 != null && !日期.isEmpty()) {
            return 日期.wareki().toDateString();
        }
        return RString.EMPTY;
    }

    private RString to変換(FlexibleYearMonth 日期) {
        if (日期 != null && !日期.isEmpty()) {
            return 日期.toDateString();
        }
        return RString.EMPTY;
    }

    private RString to変換(RDate 日期) {
        if (日期 != null) {
            return 日期.getYearMonth().toDateString();
        }
        return RString.EMPTY;
    }

    private RString to事業所番号(JigyoshaNo 事業所番号) {
        if (事業所番号 != null && !事業所番号.isEmpty()) {
            return 事業所番号.value();
        }
        return RString.EMPTY;
    }

    private RString to日期変換(FlexibleDate 日期) {
        if (日期 != null && !日期.isEmpty()) {
            return 日期.wareki().toDateString();
        }
        return RString.EMPTY;
    }

    private RString 単位数単価変換(Decimal 単位数単価変換) {
        RString 単価 = RString.EMPTY;
        if (単位数単価変換 != null) {
            単価 = new RString(単位数単価変換.toString());
        }
        return 単価;
    }

    private RString get金額(int 金額) {
        if (金額 == 0) {
            return RString.EMPTY;
        }
        Decimal 金額変換 = new Decimal(金額);
        return DecimalFormatter.toコンマ区切りRString(金額変換, 0);
    }
}
