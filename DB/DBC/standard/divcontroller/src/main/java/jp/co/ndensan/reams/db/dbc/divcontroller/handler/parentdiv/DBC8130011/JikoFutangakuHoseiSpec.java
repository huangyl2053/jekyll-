/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC8130011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8130011.JikoFutangakuHoseiDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 事業分自己負担額情報補正（単）_情報一覧のSpecです。
 *
 * @reamsid_L DBC-4800-010 huzongcheng
 */
public enum JikoFutangakuHoseiSpec implements IPredicate<JikoFutangakuHoseiDiv> {

    /**
     * 被保険者氏名必須入力のチェックです。
     */
    被保険者氏名必須入力チェック {
                @Override
                public boolean apply(JikoFutangakuHoseiDiv div) {
                    return !RString.isNullOrEmpty(div.getTxtHihokenshaName().getValue().trim());
                }
            },
    /**
     * 被保険者氏名全角文字のチェックです。
     */
    被保険者氏名全角文字チェック {
                @Override
                public boolean apply(JikoFutangakuHoseiDiv div) {
                    return SpecHelper.is被保険者氏名全角文字チェック(div);
                }
            },
    /**
     * 郵便番号のチェックです。
     */
    郵便番号チェック {
                @Override
                public boolean apply(JikoFutangakuHoseiDiv div) {
                    return SpecHelper.is郵便番号チェック(div);
                }
            },
    /**
     * 住所のチェックです。
     */
    住所チェック {
                @Override
                public boolean apply(JikoFutangakuHoseiDiv div) {
                    return SpecHelper.is住所チェック(div);
                }
            },
    /**
     * 対象計算期間大小関係のチェックです。
     */
    対象計算期間大小関係チェック {
                @Override
                public boolean apply(JikoFutangakuHoseiDiv div) {
                    return SpecHelper.is対象計算期間大小関係(div);
                }
            },
    /**
     * 被保険者期間大小関係のチェックです。
     */
    被保険者期間大小関係チェック {
                @Override
                public boolean apply(JikoFutangakuHoseiDiv div) {
                    return SpecHelper.is被保険者期間大小関係(div);
                }
            },
    /**
     * 対象計算と被保険者期間（開始）大小関係のチェックです。
     */
    対象計算と被保険者期間大小関係開始チェック {
                @Override
                public boolean apply(JikoFutangakuHoseiDiv div) {
                    return SpecHelper.is対象計算と被保険者期間大小関係開始(div);
                }
            },
    /**
     * 対象計算と被保険者期間（終了）大小関係のチェックです。
     */
    対象計算と被保険者期間大小関係終了チェック {
                @Override
                public boolean apply(JikoFutangakuHoseiDiv div) {
                    return SpecHelper.is対象計算と被保険者期間大小関係終了(div);
                }
            },
    /**
     * 窓口払情報年月日大小関係のチェックです。
     */
    窓口払情報年月日大小関係チェック {
                @Override
                public boolean apply(JikoFutangakuHoseiDiv div) {
                    return SpecHelper.is窓口払情報年月日大小関係(div);
                }
            },
    /**
     * 明細月のチェックです。
     */
    明細月チェック {
                @Override
                public boolean apply(JikoFutangakuHoseiDiv div) {
                    return SpecHelper.is明細月チェック(div);
                }
            },
    /**
     * 対象計算期間（開始）の年度のチェックです。
     */
    対象計算期間開始の年度チェック {
                @Override
                public boolean apply(JikoFutangakuHoseiDiv div) {
                    return SpecHelper.is対象計算期間開始の年度チェック(div);
                }
            },
    /**
     * 対象計算期間（終了）の年度のチェックです。
     */
    対象計算期間終了の年度チェック {
                @Override
                public boolean apply(JikoFutangakuHoseiDiv div) {
                    return SpecHelper.is対象計算期間終了の年度チェック(div);
                }
            },
    /**
     * 開始時間_時間のチェックです。
     */
    開始時間_時間チェック {
                @Override
                public boolean apply(JikoFutangakuHoseiDiv div) {
                    return SpecHelper.is開始時間_時間チェック(div);
                }
            },
    /**
     * 開始時間_分のチェックです。
     */
    開始時間_分チェック {
                @Override
                public boolean apply(JikoFutangakuHoseiDiv div) {
                    return SpecHelper.is開始時間_分チェック(div);
                }
            },
    /**
     * 終了時間_時間のチェックです。
     */
    終了時間_時間チェック {
                @Override
                public boolean apply(JikoFutangakuHoseiDiv div) {
                    return SpecHelper.is終了時間_時間チェック(div);
                }
            },
    /**
     * 終了時間_分のチェックです。
     */
    終了時間_分チェック {
                @Override
                public boolean apply(JikoFutangakuHoseiDiv div) {
                    return SpecHelper.is終了時間_分チェック(div);
                }
            },
    /**
     * 判定コードより支払場所のチェックです。
     */
    判定コードより支払場所チェック {
                @Override
                public boolean apply(JikoFutangakuHoseiDiv div) {
                    return SpecHelper.is判定コードより支払場所チェック(div);
                }
            },
    /**
     * 判定コードより開始日年月日のチェックです。
     */
    判定コードより開始日年月日チェック {
                @Override
                public boolean apply(JikoFutangakuHoseiDiv div) {
                    return SpecHelper.is判定コードより開始日年月日チェック(div);
                }
            },
    /**
     * 判定コードより開始時間のチェックです。
     */
    判定コードより開始時間チェック {
                @Override
                public boolean apply(JikoFutangakuHoseiDiv div) {
                    return SpecHelper.is判定コードより開始時間チェック(div);
                }
            },
    /**
     * 判定コードより終了日年月日のチェックです。
     */
    判定コードより終了日年月日チェック {
                @Override
                public boolean apply(JikoFutangakuHoseiDiv div) {
                    return SpecHelper.is判定コードより終了日年月日チェック(div);
                }
            },
    /**
     * 判定コードより終了時間のチェックです。
     */
    判定コードより終了時間チェック {
                @Override
                public boolean apply(JikoFutangakuHoseiDiv div) {
                    return SpecHelper.is判定コードより終了時間チェック(div);
                }
            };

    /**
     * {@link JikoFutangakuHoseiSpec}における判定ロジックのHelperクラスです。
     */
    private static class SpecHelper {

        private static final int INT_2 = 2;
        private static final int INT_7 = 7;
        private static final Decimal DECIMAL_23 = new Decimal(23);
        private static final Decimal DECIMAL_59 = new Decimal(59);
        private static final RString 該当 = new RString("該当");
        private static final RString MONTH_EIGHT = new RString("08");
        private static final RString MONTH_SEVEN = new RString("07");

        public static boolean is被保険者氏名全角文字チェック(JikoFutangakuHoseiDiv div) {
            return !RString.isNullOrEmpty(div.getTxtHihokenshaName().getValue())
                    && RStringUtil.is全角カナOnly(div.getTxtHihokenshaName().getValue());
        }

        public static boolean is郵便番号チェック(JikoFutangakuHoseiDiv div) {
            return div.getTxtAtesakiYubinNO().getValue() != null
                    && div.getTxtAtesakiYubinNO().getValue().getColumnValue().length() == INT_7;
        }

        public static boolean is住所チェック(JikoFutangakuHoseiDiv div) {
            return !RString.isNullOrEmpty(div.getTxtAtesakiJusho().getValue())
                    && RStringUtil.is全角カナOnly(div.getTxtAtesakiJusho().getValue());
        }

        public static boolean is対象計算期間大小関係(JikoFutangakuHoseiDiv div) {
            return div.getTxtTaishouKeisanKikan().getFromValue().isBeforeOrEquals(
                    div.getTxtTaishouKeisanKikan().getToValue());
        }

        public static boolean is被保険者期間大小関係(JikoFutangakuHoseiDiv div) {
            return div.getTxtHihokenshaKikan().getFromValue().isBeforeOrEquals(
                    div.getTxtHihokenshaKikan().getToValue());
        }

        public static boolean is対象計算と被保険者期間大小関係開始(JikoFutangakuHoseiDiv div) {
            return div.getTxtTaishouKeisanKikan().getFromValue().isBeforeOrEquals(
                    div.getTxtHihokenshaKikan().getFromValue());
        }

        public static boolean is対象計算と被保険者期間大小関係終了(JikoFutangakuHoseiDiv div) {
            return div.getTxtTaishouKeisanKikan().getToValue().isBeforeOrEquals(
                    div.getTxtHihokenshaKikan().getToValue());
        }

        public static boolean is窓口払情報年月日大小関係(JikoFutangakuHoseiDiv div) {
            return div.getTxtMadoguchiKaishiYMD().getValue().isBeforeOrEquals(
                    div.getTxtMadoguchiShuryoYMD().getValue());
        }

        public static boolean is対象計算期間開始の年度チェック(JikoFutangakuHoseiDiv div) {
            RYear 対象計算期間開始 = div.getTxtTaishouKeisanKikan().getFromValue().getNendo();
            RYear 対象年度 = div.getTxtTaishouNendo().getValue().getYear();
            return 対象計算期間開始.equals(対象年度);
        }

        public static boolean is明細月チェック(JikoFutangakuHoseiDiv div) {
            RYear 対象年度 = div.getTxtTaishouNendo().getValue().getYear();
            RYearMonth 被保険者開始年月 = div.getTxtHihokenshaKikan().getFromValue().getYearMonth();
            RYearMonth 被保険者終了年月 = div.getTxtHihokenshaKikan().getToValue().getYearMonth();
            RYearMonth 開始年月 = new RYearMonth(対象年度.toDateString().concat(MONTH_EIGHT));
            RYearMonth 終了年月 = new RYearMonth(対象年度.plusYear(1).toDateString().concat(MONTH_SEVEN));
            return 被保険者開始年月.isBeforeOrEquals(開始年月) && 終了年月.isBeforeOrEquals(被保険者終了年月);
        }

        public static boolean is対象計算期間終了の年度チェック(JikoFutangakuHoseiDiv div) {
            RYear 対象計算期間終了 = div.getTxtTaishouKeisanKikan().getToValue().getNendo();
            RYear 対象年度 = div.getTxtTaishouNendo().getValue().getYear().plusYear(1);
            return 対象計算期間終了.equals(対象年度);
        }

        public static boolean is開始時間_時間チェック(JikoFutangakuHoseiDiv div) {
            Decimal 時間 = div.getTxtMadoguchiKaishiJikan().getValue();
            if (時間 == null) {
                return true;
            } else {
                return 時間.compareTo(Decimal.ZERO) >= 0 && 時間.compareTo(DECIMAL_23) <= 0;
            }
        }

        public static boolean is開始時間_分チェック(JikoFutangakuHoseiDiv div) {
            Decimal 分 = div.getTxtMadoguchiKaishiFun().getValue();
            if (分 == null) {
                return true;
            } else {
                return 分.compareTo(Decimal.ZERO) >= 0 && 分.compareTo(DECIMAL_59) <= 0;
            }
        }

        public static boolean is終了時間_時間チェック(JikoFutangakuHoseiDiv div) {
            Decimal 時間 = div.getTxtMadoguchiShuryoJikan().getValue();
            if (時間 == null) {
                return true;
            } else {
                return 時間.compareTo(Decimal.ZERO) >= 0 && 時間.compareTo(DECIMAL_23) <= 0;
            }
        }

        public static boolean is終了時間_分チェック(JikoFutangakuHoseiDiv div) {
            Decimal 分 = div.getTxtMadoguchiShuryoFun().getValue();
            if (分 == null) {
                return true;
            } else {
                return 分.compareTo(Decimal.ZERO) >= 0 && 分.compareTo(DECIMAL_59) <= 0;
            }
        }

        public static boolean is判定コードより支払場所チェック(JikoFutangakuHoseiDiv div) {
            RString 判定コード = div.getTxtMadoguchiTaishoushaHantei().getValue();
            return !(該当.equals(判定コード) && RString.isNullOrEmpty(
                    div.getTxtMadoguchiShiharaiBasho().getValue()));
        }

        public static boolean is判定コードより開始日年月日チェック(JikoFutangakuHoseiDiv div) {
            RString 判定コード = div.getTxtMadoguchiTaishoushaHantei().getValue();
            return !(該当.equals(判定コード) && div.getTxtMadoguchiKaishiYMD().getValue() == null);
        }

        public static boolean is判定コードより開始時間チェック(JikoFutangakuHoseiDiv div) {
            RString 判定コード = div.getTxtMadoguchiTaishoushaHantei().getValue();
            return !(該当.equals(判定コード) && (div.getTxtMadoguchiKaishiJikan().getValue() == null
                    || div.getTxtMadoguchiKaishiFun().getValue() == null));
        }

        public static boolean is判定コードより終了日年月日チェック(JikoFutangakuHoseiDiv div) {
            RString 判定コード = div.getTxtMadoguchiTaishoushaHantei().getValue();
            return !(該当.equals(判定コード) && div.getTxtMadoguchiShuryoYMD().getValue() == null);
        }

        public static boolean is判定コードより終了時間チェック(JikoFutangakuHoseiDiv div) {
            RString 判定コード = div.getTxtMadoguchiTaishoushaHantei().getValue();
            return !(該当.equals(判定コード) && (div.getTxtMadoguchiShuryoJikan().getValue() == null
                    || div.getTxtMadoguchiShuryoFun().getValue() == null));
        }
    }
}
