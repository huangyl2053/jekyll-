/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD6010004;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD6010004.SystemKanriTokubetsuChiikiTotalDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBD;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * システム管理登録（特別地域加算減免確認番号）画面のチェックロジックです。
 *
 * @reamsid_L DBD-3763-010 tz_chengpeng
 */
public enum SystemKanriTokubetsuChiikiTotalSpec implements IPredicate<SystemKanriTokubetsuChiikiTotalDiv> {

    /**
     * 変更有無チェック
     */
    変更有無チェック {
                @Override
                public boolean apply(SystemKanriTokubetsuChiikiTotalDiv div) {
                    RDate 日期 = new RDate(FlexibleDate.getNowDate().toString());
                    if (div.getSystemKanri().getSystemKanriTokubetsuChiiki().getTxtYukoKetasu().getValue() != null
                    && div.getSystemKanri().getSystemKanriTokubetsuChiiki().getTxtGengakuRitsu1().getValue() != null
                    && div.getSystemKanri().getSystemKanriTokubetsuChiiki().getTxtGengakuRitsu2().getValue() != null) {
                        return !(DbBusinessConfig.get(ConfigNameDBD.特別地域加算減免確認番号_使用有無, 日期, SubGyomuCode.DBD介護受給)
                        .equals(div.getSystemKanri().getSystemKanriTokubetsuChiiki().getRadKakuninNo().getSelectedKey())
                        && div.getSystemKanri().getSystemKanriTokubetsuChiiki().getRadSaiban().getSelectedKey()
                        .equals(DbBusinessConfig.get(ConfigNameDBD.特別地域加算減免確認番号_採番基準, 日期, SubGyomuCode.DBD介護受給))
                        && div.getSystemKanri().getSystemKanriTokubetsuChiiki().getRadNoHikitsugi().getSelectedKey()
                        .equals(DbBusinessConfig.get(ConfigNameDBD.特別地域加算減免確認番号_番号引継ぎ, 日期, SubGyomuCode.DBD介護受給))
                        && div.getSystemKanri().getSystemKanriTokubetsuChiiki().getTxtYukoKetasu().getValue()
                        .equals(new Decimal(DbBusinessConfig.get(ConfigNameDBD.特別地域加算減免確認番号_有効桁数, 日期, SubGyomuCode.DBD介護受給).toString()))
                        && div.getSystemKanri().getSystemKanriTokubetsuChiiki().getTxtGengakuRitsu1().getValue()
                        .equals(new Decimal(DbBusinessConfig.get(ConfigNameDBD.特別地域加算減免減額率_分子, 日期, SubGyomuCode.DBD介護受給).toString()))
                        && div.getSystemKanri().getSystemKanriTokubetsuChiiki().getTxtGengakuRitsu2().getValue()
                        .equals(new Decimal(DbBusinessConfig.get(ConfigNameDBD.特別地域加算減免減額率_分母, 日期, SubGyomuCode.DBD介護受給).toString())));
                    }
                    return true;
                }
            },
    /**
     * 有効桁数必須入力チェック
     */
    有効桁数必須入力チェック {
                @Override
                public boolean apply(SystemKanriTokubetsuChiikiTotalDiv div) {
                    return div.getSystemKanri().getSystemKanriTokubetsuChiiki().getTxtYukoKetasu().getValue() != null;
                }
            },
    /**
     * 減額率の分子必須入力チェック
     */
    減額率の分子必須入力チェック {
                @Override
                public boolean apply(SystemKanriTokubetsuChiikiTotalDiv div) {
                    return div.getSystemKanri().getSystemKanriTokubetsuChiiki().getTxtGengakuRitsu1().getValue() != null;
                }
            },
    /**
     * 減額率の分母必須入力チェック
     */
    減額率の分母必須入力チェック {
                @Override
                public boolean apply(SystemKanriTokubetsuChiikiTotalDiv div) {
                    return div.getSystemKanri().getSystemKanriTokubetsuChiiki().getTxtGengakuRitsu2().getValue() != null;
                }
            },
    /**
     * 有効桁数の有効性チェック
     */
    有効桁数の有効性チェック {
                @Override
                public boolean apply(SystemKanriTokubetsuChiikiTotalDiv div) {
                    Decimal 有効桁数 = div.getSystemKanri().getSystemKanriTokubetsuChiiki().getTxtYukoKetasu().getValue();
                    if (有効桁数 != null) {
                        return 有効桁数.compareTo(Decimal.TEN) <= 0 && 有効桁数.compareTo(Decimal.ONE) >= 0;
                    }
                    return true;
                }
            },
    /**
     * 減額率の有効性チェック
     */
    減額率の有効性チェック {
                @Override
                public boolean apply(SystemKanriTokubetsuChiikiTotalDiv div) {
                    Decimal 減額率の分母 = div.getSystemKanri().getSystemKanriTokubetsuChiiki().getTxtGengakuRitsu2().getValue();
                    Decimal 減額率の分子 = div.getSystemKanri().getSystemKanriTokubetsuChiiki().getTxtGengakuRitsu1().getValue();
                    if (減額率の分子 != null && 減額率の分母 != null) {
                        return 減額率の分母.compareTo(減額率の分子) >= 0;
                    }
                    return true;
                }
            },
    /**
     * 減額率の分子の有効性チェック
     */
    減額率の分子の有効性チェック {
                @Override
                public boolean apply(SystemKanriTokubetsuChiikiTotalDiv div) {
                    Decimal 減額率の分子 = div.getSystemKanri().getSystemKanriTokubetsuChiiki().getTxtGengakuRitsu1().getValue();
                    if (減額率の分子 != null) {
                        return 減額率の分子.compareTo(NINETY_NINE) <= 0 && 減額率の分子.compareTo(Decimal.ONE) >= 0;
                    }
                    return true;
                }
            },
    /**
     * 減額率の分母の有効性チェック
     */
    減額率の分母の有効性チェック {
                @Override
                public boolean apply(SystemKanriTokubetsuChiikiTotalDiv div) {
                    Decimal 減額率の分母 = div.getSystemKanri().getSystemKanriTokubetsuChiiki().getTxtGengakuRitsu2().getValue();
                    if (減額率の分母 != null) {
                        return 減額率の分母.compareTo(ONE_HUNDRED) <= 0 && 減額率の分母.compareTo(Decimal.ONE) >= 0;
                    }
                    return true;
                }
            };

    private static final Decimal ONE_HUNDRED = new Decimal(100);
    private static final Decimal NINETY_NINE = new Decimal(99);
}
