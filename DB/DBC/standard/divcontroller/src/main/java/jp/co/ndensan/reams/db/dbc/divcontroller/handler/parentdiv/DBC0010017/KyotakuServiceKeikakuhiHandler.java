/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010017;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiKyotakuService;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiKyotakuServiceBusiness;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010017.KyotakuServiceKeikakuhiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010017.dgServiceKeikakuhiFromH2104_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010017.dgServiceKeikakuhiToH2103_Row;
import jp.co.ndensan.reams.db.dbz.business.util.DateConverter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 居宅サービス計画費のHandlerです。
 *
 * @reamsid_L DBC-2970-090 wangrenze
 */
public class KyotakuServiceKeikakuhiHandler {

    private final KyotakuServiceKeikakuhiDiv div;
    private static final RString DISABLED = new RString("0");
    private static final FlexibleYearMonth 平成21年3月 = new FlexibleYearMonth("200903");

    /**
     * 画面の初期化です。
     *
     * @param div KyotakuServiceKeikakuhiDiv
     */
    public KyotakuServiceKeikakuhiHandler(KyotakuServiceKeikakuhiDiv div) {
        this.div = div;
    }

    /**
     * 画面のデータを初期化する。
     *
     * @param 特定入所者介護サービス費用list List<KyufujissekiKyotakuServiceBusiness>
     * @param サービス提供年月 FlexibleYearMonth
     */
    public void setDataGrid(List<KyufujissekiKyotakuServiceBusiness> 特定入所者介護サービス費用list, FlexibleYearMonth サービス提供年月) {
        List<dgServiceKeikakuhiToH2103_Row> to2013rowList = new ArrayList<>();
        List<dgServiceKeikakuhiFromH2104_Row> from2014rowList = new ArrayList<>();
        if (サービス提供年月.isBeforeOrEquals(平成21年3月)) {
            for (KyufujissekiKyotakuServiceBusiness 居宅サービス計画費 : 特定入所者介護サービス費用list) {

                to2013rowList.add(get2013データ(居宅サービス計画費));
                to2013rowList.add(get2013後のデータ(居宅サービス計画費));
            }
        } else {
            for (KyufujissekiKyotakuServiceBusiness 居宅サービス計画費 : 特定入所者介護サービス費用list) {

                from2014rowList.add(get2014データ(居宅サービス計画費));
                from2014rowList.add(get2014後のデータ(居宅サービス計画費));
            }
        }
        div.getDgServiceKeikakuhiFromH2104().setDataSource(from2014rowList);
        div.getDgServiceKeikakuhiToH2103().setDataSource(to2013rowList);

    }

    private dgServiceKeikakuhiToH2103_Row get2013データ(KyufujissekiKyotakuServiceBusiness business) {
        dgServiceKeikakuhiToH2103_Row row = new dgServiceKeikakuhiToH2103_Row();
        KyufujissekiKyotakuService 居宅サービス計画費 = business.get居宅サービス計画費();
        if (居宅サービス計画費.get居宅サービス計画作成依頼届出年月日() != null && !居宅サービス計画費.get居宅サービス計画作成依頼届出年月日().isEmpty()) {
            row.setTxtTodokedeYMD(new RString(居宅サービス計画費.get居宅サービス計画作成依頼届出年月日().toString()));
        }
        if (RString.isNullOrEmpty(居宅サービス計画費.getサービスコード().value())) {
            row.setTxtServiceName(business.getサービス種類略称());
        }
        if (居宅サービス計画費.get単位数単価() != null) {
            row.setTxtTaniTanka(new RString(居宅サービス計画費.get単位数単価().toString()));
        }
        row.setTxtKettei(RString.EMPTY);
        if (居宅サービス計画費.get単位数() != null) {
            row.setTxtTanisu(new RString(居宅サービス計画費.get単位数().toString()));
        }
        row.setTxtSeikyuKingaku(get金額(居宅サービス計画費.get請求金額()));
        row.setTxtTantoKaigoShienSenmoninNo(居宅サービス計画費.get担当介護支援専門員番号());
        if (!RString.isNullOrEmpty(居宅サービス計画費.get摘要())) {
            row.setTxtBiko(居宅サービス計画費.get摘要());
        } else {
            row.setTxtBiko(RString.EMPTY);
        }
        row.setTxtSaishinsaKaisu(new RString(居宅サービス計画費.get再審査回数()));
        row.setTxtKagoKaisu(new RString(居宅サービス計画費.get過誤回数()));
        if (居宅サービス計画費.get審査年月() != null && !居宅サービス計画費.get審査年月().isEmpty()) {
            row.setTxtShinsaYM(DateConverter.toWarekiHalf_Zero(new RYearMonth(居宅サービス計画費.get審査年月().toString())));
        }
        return row;
    }

    private dgServiceKeikakuhiFromH2104_Row get2014データ(KyufujissekiKyotakuServiceBusiness business) {
        dgServiceKeikakuhiFromH2104_Row row = new dgServiceKeikakuhiFromH2104_Row();
        KyufujissekiKyotakuService 居宅サービス計画費 = business.get居宅サービス計画費();
        row.setTxtShiteiKijunGaitoJigyoshoKubun(居宅サービス計画費.get指定_基準該当等事業所区分コード());
        row.setTxtIraiTodokedeYMD(DateConverter.toWarekiHalf_Zero(new RDate(居宅サービス計画費.get居宅サービス計画作成依頼届出年月日().toString())));
        if (!RString.isNullOrEmpty(居宅サービス計画費.getサービスコード().value())) {
            row.setTxtService(business.getサービス種類略称());
        } else {
            row.setTxtService(RString.EMPTY);
        }
        if (居宅サービス計画費.get単位数単価() != null) {
            row.setTxtTanisuTanka(new RString(居宅サービス計画費.get単位数単価().toString()));
        } else {
            row.setTxtTanisuTanka(RString.EMPTY);
        }
        row.setTxtKettei(RString.EMPTY);
        if (居宅サービス計画費.get単位数() != null) {
            row.setTxtMeisaiGokei(new RString(居宅サービス計画費.getサービス単位数合計().toString()));
        }
        if (居宅サービス計画費.get単位数() != null) {
            row.setTxtTanisu(new RString(居宅サービス計画費.get単位数().toString()));
        }
        row.setTxtKaisu(new RString(居宅サービス計画費.get回数()));
        if (居宅サービス計画費.getサービス単位数() != null) {
            row.setTxtServiceTanisu(new RString(居宅サービス計画費.getサービス単位数().toString()));
        }
        row.setTxtSeikyuKingaku(get金額(居宅サービス計画費.get請求金額()));
        if (!RString.isNullOrEmpty(居宅サービス計画費.get担当介護支援専門員番号())) {
            row.setTxtTantoKaigoShienSenmoninNo(居宅サービス計画費.get担当介護支援専門員番号());
        }
        row.setTxtSaishinsaKaisu(new RString(居宅サービス計画費.get再審査回数()));
        row.setTxtKagoKaisu(new RString(居宅サービス計画費.get過誤回数()));
        if (居宅サービス計画費.get審査年月() != null && !居宅サービス計画費.get審査年月().isEmpty()) {
            row.setTxtShinsaYM(DateConverter.toWarekiHalf_Zero(new RYearMonth(居宅サービス計画費.get審査年月().toString())));
        } else {
            row.setTxtShinsaYM(RString.EMPTY);
        }
        if (!RString.isNullOrEmpty(居宅サービス計画費.get摘要())) {
            row.setBtnTekiyo(居宅サービス計画費.get摘要());
        } else {
            row.setBtnTekiyo(RString.EMPTY);
        }
        return row;
    }

    private dgServiceKeikakuhiToH2103_Row get2013後のデータ(KyufujissekiKyotakuServiceBusiness business) {
        dgServiceKeikakuhiToH2103_Row row = new dgServiceKeikakuhiToH2103_Row();
        row.setTxtKettei(new RString("後"));
        KyufujissekiKyotakuService 居宅サービス計画費 = business.get居宅サービス計画費();
        if (居宅サービス計画費.get後_単位数() != null) {
            row.setTxtTanisu(new RString(居宅サービス計画費.get後_単位数().toString()));
        }
        row.setTxtSeikyuKingaku(get金額(居宅サービス計画費.get後_請求金額()));
        return row;
    }

    private dgServiceKeikakuhiFromH2104_Row get2014後のデータ(KyufujissekiKyotakuServiceBusiness business) {
        dgServiceKeikakuhiFromH2104_Row row = new dgServiceKeikakuhiFromH2104_Row();
        KyufujissekiKyotakuService 居宅サービス計画費 = business.get居宅サービス計画費();
        row.setTxtKettei(new RString("後"));
        if (居宅サービス計画費.get後_サービス単位数合計() != null) {
            row.setTxtMeisaiGokei(new RString(居宅サービス計画費.get後_サービス単位数合計().toString()));
        }
        if (居宅サービス計画費.get後_単位数() != null) {
            row.setTxtTanisu(new RString(居宅サービス計画費.get後_単位数().toString()));
        }
        row.setTxtKaisu(new RString(居宅サービス計画費.get後_回数()));
        if (居宅サービス計画費.get後_サービス単位数() != null) {
            row.setTxtServiceTanisu(new RString(居宅サービス計画費.get後_サービス単位数().toString()));
        }
        row.setTxtSeikyuKingaku(get金額(居宅サービス計画費.get後_請求金額()));
        return row;
    }

    /**
     * ボタン状態の設定です。
     *
     * @param 識別番号管理 ShikibetsuNoKanri
     */
    public void setButton(ShikibetsuNoKanri 識別番号管理) {

        if (DISABLED.equals(識別番号管理.get基本設定区分())) {
            div.getBtnKihon().setDisabled(true);
        } else {
            div.getBtnKihon().setDisabled(false);
        }
        if (DISABLED.equals(識別番号管理.get明細設定区分())) {
            div.getBtnMeisaiShukei().setDisabled(true);
        } else {
            div.getBtnMeisaiShukei().setDisabled(false);
        }
        if (DISABLED.equals(識別番号管理.get所定疾患施設療養設定区分())) {

            div.getBtnShoteiShikkanShisetsuRyoyo().setDisabled(true);
        } else {
            div.getBtnShoteiShikkanShisetsuRyoyo().setDisabled(false);
        }
        if (DISABLED.equals(識別番号管理.get緊急時施設療養設定区分())) {
            div.getBtnKinkyujiShisetsuRyoyo().setDisabled(true);
        } else {
            div.getBtnKinkyujiShisetsuRyoyo().setDisabled(false);
        }
        if (DISABLED.equals(識別番号管理.get食事費用設定区分())) {
            div.getBtnShokuji().setDisabled(true);
        } else {
            div.getBtnShokuji().setDisabled(false);
        }

        if (DISABLED.equals(識別番号管理.get福祉用具購入費設定区分())) {
            div.getBtnFukushiYoguKonyu().setDisabled(true);
        } else {
            div.getBtnFukushiYoguKonyu().setDisabled(false);
        }

        add(識別番号管理);
    }

    private void add(ShikibetsuNoKanri 識別番号管理) {
        div.getBtnKogakuKaigoService().setDisabled(true);
        if (DISABLED.equals(識別番号管理.get特定入所者設定区分())) {
            div.getBtnTokuteiNyushosha().setDisabled(true);
        } else {
            div.getBtnTokuteiNyushosha().setDisabled(false);
        }
        if (DISABLED.equals(識別番号管理.get特定診療費設定区分())) {
            div.getBtnTokuteiShinryo().setDisabled(true);
        } else {
            div.getBtnTokuteiShinryo().setDisabled(false);
        }
        div.getBtnKyotakuServiceKeikaku().setDisabled(true);
        if (DISABLED.equals(識別番号管理.get住宅改修費設定区分())) {
            div.getBtnJutakuKaishu().setDisabled(true);
        } else {
            div.getBtnJutakuKaishu().setDisabled(false);
        }

        if (DISABLED.equals(識別番号管理.getケアマネジメント設定区分())) {
            div.getBtnCareManagement().setDisabled(true);
        } else {
            div.getBtnCareManagement().setDisabled(false);
        }

        if (DISABLED.equals(識別番号管理.get社会福祉法人軽減設定区分())) {
            div.getBtnShafukuKeigen().setDisabled(true);
        } else {
            div.getBtnShafukuKeigen().setDisabled(false);
        }
    }

    private RString get金額(Decimal 金額) {
        if (金額 != null) {
            return DecimalFormatter.toコンマ区切りRString(金額, 0);
        }
        return new RString(Decimal.ZERO.intValue());
    }
}
