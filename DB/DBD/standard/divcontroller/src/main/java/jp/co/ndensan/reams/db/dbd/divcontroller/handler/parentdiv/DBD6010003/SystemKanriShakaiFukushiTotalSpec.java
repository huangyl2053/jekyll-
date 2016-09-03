/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD6010003;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD6010003.SystemKanriShakaiFukushiTotalDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBD;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * システム管理登録（社会福祉法人確認番号）画面のチェックロジックです。
 *
 * @reamsid_L DBD-3762-010 tz_chengpeng
 */
public enum SystemKanriShakaiFukushiTotalSpec implements IPredicate<SystemKanriShakaiFukushiTotalDiv> {

    /**
     * 変更有無チェック
     */
    変更有無チェック {
                @Override
                public boolean apply(SystemKanriShakaiFukushiTotalDiv div) {
                    if (div.getSystemKanri().getSystemKanriShakaiFukushi().getTxtYukoKetasu().getValue() != null
                    && div.getSystemKanri().getSystemKanriShakaiFukushi().getTxtGenmenRitsu1().getValue() != null
                    && div.getSystemKanri().getSystemKanriShakaiFukushi().getTxtGenmenRitsu2().getValue() != null
                    && div.getSystemKanri().getSystemKanriShakaiFukushi().getTxtKeigenRitsu1().getValue() != null
                    && div.getSystemKanri().getSystemKanriShakaiFukushi().getTxtKeigenRitsu2().getValue() != null) {
                        RDate 日期 = new RDate(FlexibleDate.getNowDate().toString());
                        return !(div.getSystemKanri().getSystemKanriShakaiFukushi().getRadKakuninNo().getSelectedKey()
                        .equals(DbBusinessConfig.get(ConfigNameDBD.社会福祉法人減免確認番号_使用有無, 日期, SubGyomuCode.DBD介護受給))
                        && div.getSystemKanri().getSystemKanriShakaiFukushi().getRadSaiban().getSelectedKey()
                        .equals(DbBusinessConfig.get(ConfigNameDBD.社会福祉法人減免確認番号_採番基準, 日期, SubGyomuCode.DBD介護受給))
                        && div.getSystemKanri().getSystemKanriShakaiFukushi().getRadNoHikitsugi().getSelectedKey()
                        .equals(DbBusinessConfig.get(ConfigNameDBD.社会福祉法人減免確認番号_番号引継ぎ, 日期, SubGyomuCode.DBD介護受給))
                        && div.getSystemKanri().getSystemKanriShakaiFukushi().getTxtYukoKetasu().getValue()
                        .equals(new Decimal(DbBusinessConfig.get(ConfigNameDBD.社会福祉法人減免確認番号_有効桁数, 日期, SubGyomuCode.DBD介護受給).toString()))
                        && div.getSystemKanri().getSystemKanriShakaiFukushi().getTxtGenmenRitsu1().getValue()
                        .equals(new Decimal(DbBusinessConfig.get(ConfigNameDBD.社会福祉法人減免減免率_分子, 日期, SubGyomuCode.DBD介護受給).toString()))
                        && div.getSystemKanri().getSystemKanriShakaiFukushi().getTxtGenmenRitsu2().getValue()
                        .equals(new Decimal(DbBusinessConfig.get(ConfigNameDBD.社会福祉法人減免減免率_分母, 日期, SubGyomuCode.DBD介護受給).toString()))
                        && div.getSystemKanri().getSystemKanriShakaiFukushi().getTxtKeigenRitsu1().getValue()
                        .equals(new Decimal(DbBusinessConfig.get(ConfigNameDBD.社会福祉法人軽減軽減率_分子, 日期, SubGyomuCode.DBD介護受給).toString()))
                        && div.getSystemKanri().getSystemKanriShakaiFukushi().getTxtKeigenRitsu2().getValue()
                        .equals(new Decimal(DbBusinessConfig.get(ConfigNameDBD.社会福祉法人軽減軽減率_分母, 日期, SubGyomuCode.DBD介護受給).toString())));
                    }
                    return true;
                }
            },
    /**
     * 有効桁数必須入力チェック
     */
    有効桁数必須入力チェック {
                @Override
                public boolean apply(SystemKanriShakaiFukushiTotalDiv div) {
                    return div.getSystemKanri().getSystemKanriShakaiFukushi().getTxtYukoKetasu().getValue() != null;
                }
            },
    /**
     * 減免率の分子必須入力チェック
     */
    減免率の分子必須入力チェック {
                @Override
                public boolean apply(SystemKanriShakaiFukushiTotalDiv div) {
                    return div.getSystemKanri().getSystemKanriShakaiFukushi().getTxtGenmenRitsu1().getValue() != null;
                }
            },
    /**
     * 減免率の分母必須入力チェック
     */
    減免率の分母必須入力チェック {
                @Override
                public boolean apply(SystemKanriShakaiFukushiTotalDiv div) {
                    return div.getSystemKanri().getSystemKanriShakaiFukushi().getTxtGenmenRitsu2().getValue() != null;
                }
            },
    /**
     * 軽減率の分子必須入力チェック
     */
    軽減率の分子必須入力チェック {
                @Override
                public boolean apply(SystemKanriShakaiFukushiTotalDiv div) {
                    return div.getSystemKanri().getSystemKanriShakaiFukushi().getTxtKeigenRitsu1().getValue() != null;
                }
            },
    /**
     * 軽減率の分母必須入力チェック
     */
    軽減率の分母必須入力チェック {
                @Override
                public boolean apply(SystemKanriShakaiFukushiTotalDiv div) {
                    return div.getSystemKanri().getSystemKanriShakaiFukushi().getTxtKeigenRitsu2().getValue() != null;
                }
            },
    /**
     * 有効桁数の有効性チェック
     */
    有効桁数の有効性チェック {
                @Override
                public boolean apply(SystemKanriShakaiFukushiTotalDiv div) {
                    Decimal 有効桁数 = div.getSystemKanri().getSystemKanriShakaiFukushi().getTxtYukoKetasu().getValue();
                    if (有効桁数 != null) {
                        return 有効桁数.compareTo(Decimal.TEN) <= 0 && 有効桁数.compareTo(Decimal.ONE) >= 0;
                    }
                    return true;
                }
            },
    /**
     * 減免率の有効性チェック
     */
    減免率の有効性チェック {
                @Override
                public boolean apply(SystemKanriShakaiFukushiTotalDiv div) {
                    Decimal 減免率の分母 = div.getSystemKanri().getSystemKanriShakaiFukushi().getTxtGenmenRitsu2().getValue();
                    Decimal 減免率の分子 = div.getSystemKanri().getSystemKanriShakaiFukushi().getTxtGenmenRitsu1().getValue();
                    if (減免率の分子 != null && 減免率の分母 != null) {
                        return 減免率の分母.compareTo(減免率の分子) >= 0;
                    }
                    return true;
                }
            },
    /**
     * 軽減率の分子の有効性チェック
     */
    軽減率の分子の有効性チェック {
                @Override
                public boolean apply(SystemKanriShakaiFukushiTotalDiv div) {
                    Decimal 軽減率の分子 = div.getSystemKanri().getSystemKanriShakaiFukushi().getTxtKeigenRitsu1().getValue();
                    if (軽減率の分子 != null) {
                        return 軽減率の分子.compareTo(ONE_HUNDRED) <= 0 && 軽減率の分子.compareTo(Decimal.ONE) >= 0;
                    }
                    return true;
                }
            },
    /**
     * 軽減率の分母の有効性チェック
     */
    軽減率の分母の有効性チェック {
                @Override
                public boolean apply(SystemKanriShakaiFukushiTotalDiv div) {
                    Decimal 軽減率の分母 = div.getSystemKanri().getSystemKanriShakaiFukushi().getTxtKeigenRitsu2().getValue();
                    if (軽減率の分母 != null) {
                        return 軽減率の分母.compareTo(ONE_HUNDRED) <= 0 && 軽減率の分母.compareTo(Decimal.ONE) >= 0;
                    }
                    return true;
                }
            };

    private static final Decimal ONE_HUNDRED = new Decimal(100);
}
