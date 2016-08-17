/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ServiceRiyohyoInfo;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * サービス利用票情報のSpecです。
 *
 * @reamsid_L DBC-1930-050 cuilin
 */
public enum ServiceRiyohyoInfoDivSpec implements IPredicate<ServiceRiyohyoInfoDiv> {

    /**
     * サービスコード必須入力のチェックです。
     */
    サービスコード必須入力チェック {
                @Override
                public boolean apply(ServiceRiyohyoInfoDiv div) {
                    return !RString.isNullOrEmpty(div.getCcdServiceCodeInput().getサービスコード1())
                    && !RString.isNullOrEmpty(div.getCcdServiceCodeInput().getサービスコード2());
                }
            },
    /**
     * 単位必須入力のチェックです。
     */
    単位必須入力チェック {
                @Override
                public boolean apply(ServiceRiyohyoInfoDiv div) {
                    return !RString.isNullOrEmpty(div.getServiceRiyohyoBeppyoMeisai().getTxtTani().getText());
                }
            },
    /**
     * 回数必須入力のチェックです。
     */
    回数必須入力チェック {
                @Override
                public boolean apply(ServiceRiyohyoInfoDiv div) {
                    return !RString.isNullOrEmpty(div.getServiceRiyohyoBeppyoMeisai().getTxtKaisu().getText());
                }
            },
    /**
     * サービス単位必須入力のチェックです。
     */
    サービス単位必須入力チェック {
                @Override
                public boolean apply(ServiceRiyohyoInfoDiv div) {
                    return !RString.isNullOrEmpty(div.getServiceRiyohyoBeppyoMeisai().getTxtServiceTani().getText());
                }
            },
    /**
     * 割引適用後率入力値が不正のチェックです。
     */
    割引適用後率入力値が不正チェック {
                @Override
                public boolean apply(ServiceRiyohyoInfoDiv div) {
                    Decimal 割引適用後率 = div.getServiceRiyohyoBeppyoMeisai().getTxtWaribikigoRitsu().getValue();
                    return Decimal.ONE.compareTo(割引適用後率) >= 0;
                }
            },
    /**
     * 回数入力値が不正のチェックです。
     */
    回数入力値が不正チェック {
                @Override
                public boolean apply(ServiceRiyohyoInfoDiv div) {
                    Decimal 回数 = div.getServiceRiyohyoBeppyoMeisai().getTxtKaisu().getValue();
                    return Decimal.ZERO.compareTo(回数) >= 0;
                }
            },
    /**
     * 単位数単価入力値が不正のチェックです。
     */
    単位数単価力値が不正チェック {
                @Override
                public boolean apply(ServiceRiyohyoInfoDiv div) {
                    Decimal 単位数単価 = div.getServiceRiyohyoBeppyoGokei().getTxtTanisuTanka().getValue();
                    return Decimal.ONE.compareTo(単位数単価) < 0;
                }
            },
    /**
     * 給付率入力値が不正のチェックです。
     */
    給付率入力値が不正チェック {
                @Override
                public boolean apply(ServiceRiyohyoInfoDiv div) {
                    Decimal 給付率 = div.getServiceRiyohyoBeppyoGokei().getTxtKyufuritsu().getValue();
                    return Decimal.ONE.compareTo(給付率) < 0;
                }
            },
    /**
     * 単位数単価必須入力のチェックです。
     */
    単位数単価必須入力チェック {
                @Override
                public boolean apply(ServiceRiyohyoInfoDiv div) {
                    return !RString.isNullOrEmpty(div.getServiceRiyohyoBeppyoGokei().getTxtTanisuTanka().getText());
                }
            },
    /**
     * 区分限度内単位必須入力のチェックです。
     */
    区分限度内単位必須入力チェック {
                @Override
                public boolean apply(ServiceRiyohyoInfoDiv div) {
                    return !RString.isNullOrEmpty(div.getServiceRiyohyoBeppyoGokei().getTxtKubunGendonaiTani().getText());
                }
            },
    /**
     * 給付率必須入力のチェックです。
     */
    給付率必須入力チェック {
                @Override
                public boolean apply(ServiceRiyohyoInfoDiv div) {
                    return !RString.isNullOrEmpty(div.getServiceRiyohyoBeppyoGokei().getTxtKyufuritsu().getText());
                }
            };
}
