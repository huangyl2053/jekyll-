/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7030001;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7030001.DvShokanbaraiJohoDiv;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 「実行する」ボタンを押下時の入力チェックSpecです。
 *
 * @reamsid_L DBC-3093-010 gongliang
 */
public enum DvShokanbaraiJohoSpec implements IPredicate<DvShokanbaraiJohoDiv> {

    /**
     * 実行するボタンクリック1 様式番号一覧チェックです。
     */
    様式番号一覧チェック {
                @Override
                public boolean apply(DvShokanbaraiJohoDiv div) {
                    return !div.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getDgYoshikiNo().getSelectedItems().isEmpty();
                }
            },
    /**
     * 実行するボタンクリック2 金融機関共有子Divの制御
     */
    金融機関コードチェック {
                @Override
                public boolean apply(DvShokanbaraiJohoDiv div) {
                    RString 支払方法 = div.getDvShokanbaraiParam()
                    .getDvShokanChushutsuJoken().getDvKensakuJoken().getRadKogakuShiharaisaki().getSelectedValue();
                    boolean flag = div.getDvShokanbaraiParam()
                    .getDvShokanChushutsuJoken().getDvKensakuJoken().getCcdKogakuKinyuKikan().get金融機関支店() != null;
                    flag = flag || div.getDvShokanbaraiParam()
                    .getDvShokanChushutsuJoken().getDvKensakuJoken().getCcdKogakuKinyuKikan().get金融機関() != null;
                    KinyuKikanCode kinyuKikanCode = div.getDvShokanbaraiParam()
                    .getDvShokanChushutsuJoken().getDvKensakuJoken().getCcdKogakuKinyuKikan().getKinyuKikanCode();
                    flag = flag || (kinyuKikanCode != null && !kinyuKikanCode.isEmpty());
                    KinyuKikanShitenCode kinyuKikanShitenCode = div.getDvShokanbaraiParam()
                    .getDvShokanChushutsuJoken().getDvKensakuJoken().getCcdKogakuKinyuKikan().getKinyuKikanShitenCode();
                    flag = flag || (kinyuKikanShitenCode != null && !kinyuKikanShitenCode.isEmpty());
                    return !(new RString("窓口払い").equals(支払方法) && flag);
                }
            },
    /**
     * 実行するボタンクリック3 サービス提供年月From、サービス提供年月Toの大小関係チェックです。
     */
    サービス提供年月チェック {
                @Override
                public boolean apply(DvShokanbaraiJohoDiv div) {
                    RDate サービス提供年月From = div.getDvShokanbaraiParam().getDvShokanChushutsuJoken()
                    .getDvKensakuJoken().getTxtShokanServiceTeikyoYM().getFromValue();
                    RDate サービス提供年月To = div.getDvShokanbaraiParam().getDvShokanChushutsuJoken()
                    .getDvKensakuJoken().getTxtShokanServiceTeikyoYM().getToValue();
                    if (サービス提供年月From != null && サービス提供年月To != null) {
                        return サービス提供年月From.isBeforeOrEquals(サービス提供年月To);
                    }
                    return true;
                }
            },
    /**
     * 実行するボタンクリック4 申請日From、申請日Toの大小関係チェックです。
     */
    申請日チェック {
                @Override
                public boolean apply(DvShokanbaraiJohoDiv div) {
                    RDate 申請日From = div.getDvShokanbaraiParam().getDvShokanChushutsuJoken()
                    .getDvKensakuJoken().getTxtShokanShinseiDate().getFromValue();
                    RDate 申請日To = div.getDvShokanbaraiParam().getDvShokanChushutsuJoken()
                    .getDvKensakuJoken().getTxtShokanShinseiDate().getToValue();
                    if (申請日From != null && 申請日To != null) {
                        return 申請日From.isBeforeOrEquals(申請日To);
                    }
                    return true;
                }
            },
    /**
     * 実行するボタンクリック5 住宅改修支給届出日From、住宅改修支給届出日Toの大小関係チェックです。
     */
    住宅改修支給届出日チェック {
                @Override
                public boolean apply(DvShokanbaraiJohoDiv div) {
                    RDate 住宅改修支給届出日From = div.getDvShokanbaraiParam().getDvShokanChushutsuJoken()
                    .getDvKensakuJoken().getTxtShokanHokenshaKetteiDate().getFromValue();
                    RDate 住宅改修支給届出日To = div.getDvShokanbaraiParam().getDvShokanChushutsuJoken()
                    .getDvKensakuJoken().getTxtShokanHokenshaKetteiDate().getToValue();
                    if (住宅改修支給届出日From != null && 住宅改修支給届出日To != null) {
                        return 住宅改修支給届出日From.isBeforeOrEquals(住宅改修支給届出日To);
                    }
                    return true;
                }
            },
    /**
     * 実行するボタンクリック6 決定日From、決定日Toの大小関係チェックです。
     */
    決定日チェック {
                @Override
                public boolean apply(DvShokanbaraiJohoDiv div) {
                    RDate 決定日From = div.getDvShokanbaraiParam().getDvShokanChushutsuJoken()
                    .getDvKensakuJoken().getTxtShokanKetteiDate().getFromValue();
                    RDate 決定日To = div.getDvShokanbaraiParam().getDvShokanChushutsuJoken()
                    .getDvKensakuJoken().getTxtShokanKetteiDate().getToValue();
                    if (決定日From != null && 決定日To != null) {
                        return 決定日From.isBeforeOrEquals(決定日To);
                    }
                    return true;
                }
            },
    /**
     * 実行するボタンクリック7 国保連送付年月From、国保連送付年月Toの大小関係チェックです。
     */
    国保連送付年月チェック {
                @Override
                public boolean apply(DvShokanbaraiJohoDiv div) {
                    RDate 国保連送付年月From = div.getDvShokanbaraiParam().getDvShokanChushutsuJoken()
                    .getDvKensakuJoken().getTxtShokanKokuhorenSofuYM().getFromValue();
                    RDate 国保連送付年月To = div.getDvShokanbaraiParam().getDvShokanChushutsuJoken()
                    .getDvKensakuJoken().getTxtShokanKokuhorenSofuYM().getToValue();
                    if (国保連送付年月From != null && 国保連送付年月To != null) {
                        return 国保連送付年月From.isBeforeOrEquals(国保連送付年月To);
                    }
                    return true;
                }
            },
    /**
     * isCommonButtonVisible
     */
    isCommonButtonVisible {
                @Override
                public boolean apply(DvShokanbaraiJohoDiv div) {
                    return false;
                }
            };
}
