/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.JukyushaIdoRenrakuhyo;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 受給者異動連絡票関連共有子DivのSpecです。
 *
 * @reamsid_L DBC-4350-060 chenhui
 */
public enum JukyushaIdoRenrakuhyoSpec implements IPredicate<JukyushaIdoRenrakuhyoDiv> {

    /**
     * 異動日の必須チェックです。
     */
    異動日の必須チェック {
                @Override
                public boolean apply(JukyushaIdoRenrakuhyoDiv div) {
                    return !SpecHelper.check異動日の必須(div);
                }
            },
    /**
     * 異動区分の必須チェックです。
     */
    異動区分の必須チェック {
                @Override
                public boolean apply(JukyushaIdoRenrakuhyoDiv div) {
                    return !SpecHelper.check異動区分の必須(div);
                }
            },
    /**
     * 異動事由の必須チェックです。
     */
    異動事由の必須チェック {
                @Override
                public boolean apply(JukyushaIdoRenrakuhyoDiv div) {
                    return !SpecHelper.check異動事由の必須(div);
                }
            },
    /**
     * 被保番号の必須チェックです。
     */
    被保番号の必須チェック {
                @Override
                public boolean apply(JukyushaIdoRenrakuhyoDiv div) {
                    return !SpecHelper.check被保番号の必須(div);
                }
            },
    /**
     * 資格取得日の必須チェックです。
     */
    資格取得日の必須チェック {
                @Override
                public boolean apply(JukyushaIdoRenrakuhyoDiv div) {
                    return !SpecHelper.check資格取得日の必須(div);
                }
            },
    /**
     * 証記載保険者番号の必須チェックです。
     */
    証記載保険者番号の必須チェック {
                @Override
                public boolean apply(JukyushaIdoRenrakuhyoDiv div) {
                    return !SpecHelper.check証記載保険者番号の必須(div);
                }
            },
    /**
     * 訂正日の必須チェックです。
     */
    訂正日の必須チェック {
                @Override
                public boolean apply(JukyushaIdoRenrakuhyoDiv div) {
                    return !SpecHelper.check訂正日の必須(div);
                }
            },
    /**
     * 訂正区分の必須チェックです。
     */
    訂正区分の必須チェック {
                @Override
                public boolean apply(JukyushaIdoRenrakuhyoDiv div) {
                    return !SpecHelper.check訂正区分の必須(div);
                }
            },
    /**
     * 状態区分の必須チェックです。
     */
    状態区分の必須チェック {
                @Override
                public boolean apply(JukyushaIdoRenrakuhyoDiv div) {
                    return !SpecHelper.check状態区分の必須(div);
                }
            },
    /**
     * 認定期間　Fromの必須チェックです。
     */
    認定期間_Fromの必須チェック {
                @Override
                public boolean apply(JukyushaIdoRenrakuhyoDiv div) {
                    return !SpecHelper.check認定期間_Fromの必須(div);
                }
            },
    /**
     * 認定期間　Toの必須チェックです。
     */
    認定期間_Toの必須チェック {
                @Override
                public boolean apply(JukyushaIdoRenrakuhyoDiv div) {
                    return !SpecHelper.check認定期間_Toの必須(div);
                }
            },
    /**
     * 申請種別の必須チェックです。
     */
    申請種別の必須チェック {
                @Override
                public boolean apply(JukyushaIdoRenrakuhyoDiv div) {
                    return !SpecHelper.check申請種別の必須(div);
                }
            },
    /**
     * 変更申請中区分の必須チェックです。
     */
    変更申請中区分の必須チェック {
                @Override
                public boolean apply(JukyushaIdoRenrakuhyoDiv div) {
                    return !SpecHelper.check変更申請中区分の必須(div);
                }
            },
    /**
     * みなし区分の必須チェックです。
     */
    みなし区分の必須チェック {
                @Override
                public boolean apply(JukyushaIdoRenrakuhyoDiv div) {
                    return !SpecHelper.checkみなし区分の必須(div);
                }
            },
    /**
     * 計画作成区分の必須チェックです。
     */
    計画作成区分の必須チェック {
                @Override
                public boolean apply(JukyushaIdoRenrakuhyoDiv div) {
                    return !SpecHelper.check計画作成区分の必須(div);
                }
            },
    /**
     * 減免申請中区分の必須チェックです。
     */
    減免申請中区分の必須チェック {
                @Override
                public boolean apply(JukyushaIdoRenrakuhyoDiv div) {
                    return !SpecHelper.check減免申請中区分の必須(div);
                }
            },
    /**
     * 利用者負担区分の必須チェックです。
     */
    利用者負担区分の必須チェック {
                @Override
                public boolean apply(JukyushaIdoRenrakuhyoDiv div) {
                    return !SpecHelper.check利用者負担区分の必須(div);
                }
            },
    /**
     * 標準負担区分の必須チェックです。
     */
    標準負担区分の必須チェック {
                @Override
                public boolean apply(JukyushaIdoRenrakuhyoDiv div) {
                    return !SpecHelper.check標準負担区分の必須(div);
                }
            },
    /**
     * 認定申請中区分の必須チェックです。
     */
    認定申請中区分の必須チェック {
                @Override
                public boolean apply(JukyushaIdoRenrakuhyoDiv div) {
                    return !SpecHelper.check認定申請中区分の必須(div);
                }
            },
    /**
     * サービス区分の必須チェックです。
     */
    サービス区分の必須チェック {
                @Override
                public boolean apply(JukyushaIdoRenrakuhyoDiv div) {
                    return !SpecHelper.checkサービス区分の必須(div);
                }
            },
    /**
     * 特例減額措置対象の必須チェックです。
     */
    特例減額措置対象の必須チェック {
                @Override
                public boolean apply(JukyushaIdoRenrakuhyoDiv div) {
                    return !SpecHelper.check特例減額措置対象の必須(div);
                }
            },
    /**
     * 公費負担上限額減額(生活保護等)の必須チェックです。
     */
    公費負担上限額減額_生活保護等の必須チェック {
                @Override
                public boolean apply(JukyushaIdoRenrakuhyoDiv div) {
                    return !SpecHelper.check公費負担上限額減額_生活保護等の必須(div);
                }
            },
    /**
     * 二次予防事業区分の必須チェックです。
     */
    二次予防事業区分の必須チェック {
                @Override
                public boolean apply(JukyushaIdoRenrakuhyoDiv div) {
                    return !SpecHelper.check二次予防事業区分の必須(div);
                }
            },
    /**
     * (旧訪問通所)　管理適用期間の関連チェックです。
     */
    旧訪問通所_管理適用期間の関連チェック {
                @Override
                public boolean apply(JukyushaIdoRenrakuhyoDiv div) {
                    return !SpecHelper.check旧訪問通所_管理適用期間の関連(div);
                }
            },
    /**
     * (旧短期入所)　管理適用期間の関連チェックです。
     */
    旧短期入所_管理適用期間の関連チェック {
                @Override
                public boolean apply(JukyushaIdoRenrakuhyoDiv div) {
                    return !SpecHelper.check旧短期入所_管理適用期間の関連(div);
                }
            },
    /**
     * 居宅適用期間の関連チェックです。
     */
    居宅適用期間の関連チェック {
                @Override
                public boolean apply(JukyushaIdoRenrakuhyoDiv div) {
                    return !SpecHelper.check居宅適用期間の関連(div);
                }
            },
    /**
     * 住特適用期間の関連チェックです。
     */
    住特適用期間の関連チェック {
                @Override
                public boolean apply(JukyushaIdoRenrakuhyoDiv div) {
                    return !(SpecHelper.check住特適用期間の関連(div) || SpecHelper.check住特適用期間の送付年月関連(div)
                    || SpecHelper.check住特適用期間の異動日関連(div));
                }
            },
    /**
     * 利用者負担適用期間の関連チェックです。
     */
    利用者負担適用期間の関連チェック {
                @Override
                public boolean apply(JukyushaIdoRenrakuhyoDiv div) {
                    return !SpecHelper.check利用者負担適用期間の関連(div);
                }
            },
    /**
     * 社会福祉法人軽減情報適用期間の関連チェックです。
     */
    社会福祉法人軽減情報適用期間の関連チェック {
                @Override
                public boolean apply(JukyushaIdoRenrakuhyoDiv div) {
                    return !(SpecHelper.check社会福祉法人軽減情報適用期間の関連(div)
                    || SpecHelper.check社会福祉法人軽減情報適用期間の送付年月関連(div)
                    || SpecHelper.check社会福祉法人軽減情報適用期間の異動日関連(div));
                }
            },
    /**
     * 標準負担適用期間の関連チェックです。
     */
    標準負担適用期間の関連チェック {
                @Override
                public boolean apply(JukyushaIdoRenrakuhyoDiv div) {
                    return !SpecHelper.check標準負担適用期間の関連(div);
                }
            },
    /**
     * 食費限度額適用期間の関連チェックです。
     */
    食費限度額適用期間の関連チェック {
                @Override
                public boolean apply(JukyushaIdoRenrakuhyoDiv div) {
                    return !(SpecHelper.check食費限度額適用期間の関連(div) || SpecHelper.check食費限度額適用期間の送付年月関連(div)
                    || SpecHelper.check食費限度額適用期間の異動日関連(div));
                }
            },
    /**
     * 償還払化期間の関連チェックです。
     */
    償還払化期間の関連チェック {
                @Override
                public boolean apply(JukyushaIdoRenrakuhyoDiv div) {
                    return !SpecHelper.check償還払化期間の関連(div);
                }
            },
    /**
     * 給付率引下げ期間の関連チェックです。
     */
    給付率引下げ期間の関連チェック {
                @Override
                public boolean apply(JukyushaIdoRenrakuhyoDiv div) {
                    return !SpecHelper.check給付率引下げ期間の関連(div);
                }
            },
    /**
     * 二割負担事業適用期間の関連チェックです。
     */
    二割負担事業適用期間の関連チェック {
                @Override
                public boolean apply(JukyushaIdoRenrakuhyoDiv div) {
                    return !(SpecHelper.check二割負担事業適用期間の関連(div) || SpecHelper.check二割負担事業適用期間の送付年月関連(div)
                    || SpecHelper.check二割負担事業適用期間の異動日関連(div));
                }
            },
    /**
     * 二次予防事業適用期間の関連チェックです。
     */
    二次予防事業適用期間の関連チェック {
                @Override
                public boolean apply(JukyushaIdoRenrakuhyoDiv div) {
                    return !(SpecHelper.check二次予防事業適用期間の関連(div) || SpecHelper.check二次予防事業適用期間の送付年月関連(div)
                    || SpecHelper.check二次予防事業適用期間の異動日関連(div));
                }
            };

    private static class SpecHelper {

        private static final RString 非該当KEY = new RString("higaito");
        //TODO QA
        private static final RString 事業者対象KEY = new RString("yoshienKeikatekiYokaigo");

        private static final RString 空KEY = new RString("space");

        private static final RString 画面ID_DBC0220012 = new RString("DBC0220012");

        /**
         * 異動日の必須チェックです。
         *
         * @param div JukyushaIdoRenrakuhyoDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check異動日の必須(JukyushaIdoRenrakuhyoDiv div) {
            FlexibleDate 異動日 = div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtIdoYMD().getValue();
            return (異動日 == null || 異動日.toString().isEmpty());
        }

        /**
         * 異動区分の必須チェックです。
         *
         * @param div JukyushaIdoRenrakuhyoDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check異動区分の必須(JukyushaIdoRenrakuhyoDiv div) {
            RString 異動区分 = div.getJukyushaIdoRenrakuhyoKihonJoho().getRadIdoKubun().getSelectedKey();
            return RString.isNullOrEmpty(異動区分);
        }

        /**
         * 異動事由の必須チェックです。
         *
         * @param div JukyushaIdoRenrakuhyoDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check異動事由の必須(JukyushaIdoRenrakuhyoDiv div) {
            RString 異動事由 = div.getJukyushaIdoRenrakuhyoKihonJoho().getDdlJukyushaIdoJiyu().getSelectedKey();
            return 空KEY.equals(異動事由);
        }

        /**
         * 被保番号の必須チェックです。
         *
         * @param div JukyushaIdoRenrakuhyoDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check被保番号の必須(JukyushaIdoRenrakuhyoDiv div) {
            RString 被保番号 = div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtHiHokenshaNo().getValue();
            return RString.isNullOrEmpty(被保番号);
        }

        /**
         * 資格取得日の必須チェックです。
         *
         * @param div JukyushaIdoRenrakuhyoDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check資格取得日の必須(JukyushaIdoRenrakuhyoDiv div) {
            FlexibleDate 資格取得日 = div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtShikakuShutokuYMD().getValue();
            return (資格取得日 == null || 資格取得日.toString().isEmpty());
        }

        /**
         * 証記載保険者番号の必須チェックです。
         *
         * @param div JukyushaIdoRenrakuhyoDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check証記載保険者番号の必須(JukyushaIdoRenrakuhyoDiv div) {
            RString 証記載保険者番号 = div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtShoKisaiHokenshaNo().getValue();
            return RString.isNullOrEmpty(証記載保険者番号);
        }

        /**
         * 訂正日の必須です。
         *
         * @param div JukyushaIdoRenrakuhyoDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check訂正日の必須(JukyushaIdoRenrakuhyoDiv div) {
            RDate 訂正日 = div.getJukyushaIdoRenrakuhyoTeisei().getTxtTeiseiYMD().getValue();
            return (div.getJukyushaIdoRenrakuhyoTeisei().getTxtTeiseiYMD().isVisible()
                    && 画面ID_DBC0220012.equals(ResponseHolder.getMenuID())
                    && (訂正日 == null || 訂正日.toString().isEmpty()));
        }

        /**
         * 訂正区分の必須チェックです。
         *
         * @param div JukyushaIdoRenrakuhyoDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check訂正区分の必須(JukyushaIdoRenrakuhyoDiv div) {
            RString 訂正区分 = div.getJukyushaIdoRenrakuhyoTeisei().getRadTeiseiKubunCode().getSelectedKey();
            return (div.getJukyushaIdoRenrakuhyoTeisei().getRadTeiseiKubunCode().isVisible()
                    && 画面ID_DBC0220012.equals(ResponseHolder.getMenuID())
                    && RString.isNullOrEmpty(訂正区分));
        }

        /**
         * 状態区分の必須チェックです。
         *
         * @param div JukyushaIdoRenrakuhyoDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check状態区分の必須(JukyushaIdoRenrakuhyoDiv div) {
            RString 状態区分 = div.getYokaigoNinteiPanel().getDdlYokaigoJotaiKubun().getSelectedKey();
            return RString.isNullOrEmpty(状態区分);
        }

        /**
         * 認定期間_Fromの必須です。
         *
         * @param div JukyushaIdoRenrakuhyoDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check認定期間_Fromの必須(JukyushaIdoRenrakuhyoDiv div) {
            RString 状態区分 = div.getYokaigoNinteiPanel().getDdlYokaigoJotaiKubun().getSelectedKey();
            RDate 認定期間_From = div.getYokaigoNinteiPanel().getTxtNinteiYukoKikanYMD().getFromValue();
            return (!非該当KEY.equals(状態区分) && (認定期間_From == null || 認定期間_From.toString().isEmpty()));
        }

        /**
         * 認定期間_Toの必須です。
         *
         * @param div JukyushaIdoRenrakuhyoDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check認定期間_Toの必須(JukyushaIdoRenrakuhyoDiv div) {
            RString 状態区分 = div.getYokaigoNinteiPanel().getDdlYokaigoJotaiKubun().getSelectedKey();
            RDate 認定期間_To = div.getYokaigoNinteiPanel().getTxtNinteiYukoKikanYMD().getToValue();
            return (!非該当KEY.equals(状態区分) && !事業者対象KEY.equals(状態区分)
                    && (認定期間_To == null || 認定期間_To.toString().isEmpty()));
        }

        /**
         * 申請種別の必須です。
         *
         * @param div JukyushaIdoRenrakuhyoDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check申請種別の必須(JukyushaIdoRenrakuhyoDiv div) {
            RString 申請種別 = div.getYokaigoNinteiPanel().getRadShinseiShubetsu().getSelectedKey();
            return RString.isNullOrEmpty(申請種別);
        }

        /**
         * 変更申請中区分の必須です。
         *
         * @param div JukyushaIdoRenrakuhyoDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check変更申請中区分の必須(JukyushaIdoRenrakuhyoDiv div) {
            RString 変更申請中区分 = div.getYokaigoNinteiPanel().getRadHenkoShinseichuKubun().getSelectedKey();
            return RString.isNullOrEmpty(変更申請中区分);
        }

        /**
         * みなし区分の必須です。
         *
         * @param div JukyushaIdoRenrakuhyoDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean checkみなし区分の必須(JukyushaIdoRenrakuhyoDiv div) {
            RString みなし区分 = div.getYokaigoNinteiPanel().getRadMinashiYokaigoJotaiKubun().getSelectedKey();
            return RString.isNullOrEmpty(みなし区分);
        }

        /**
         * 計画作成区分の必須です。
         *
         * @param div JukyushaIdoRenrakuhyoDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check計画作成区分の必須(JukyushaIdoRenrakuhyoDiv div) {
            RString 計画作成区分 = div.getKyotakuServicePlanPanel().getRadKyotakuServiceSakuseiKubun().getSelectedKey();
            return RString.isNullOrEmpty(計画作成区分);
        }

        /**
         * 減免申請中区分の必須です。
         *
         * @param div JukyushaIdoRenrakuhyoDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check減免申請中区分の必須(JukyushaIdoRenrakuhyoDiv div) {
            RString 減免申請中区分 = div.getGemmenGengakuPanel().getRadGemmenShinseichuKubun().getSelectedKey();
            return RString.isNullOrEmpty(減免申請中区分);
        }

        /**
         * 利用者負担区分の必須です。
         *
         * @param div JukyushaIdoRenrakuhyoDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check利用者負担区分の必須(JukyushaIdoRenrakuhyoDiv div) {
            RString 利用者負担区分 = div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().
                    getJukyushaIdoRenrakuhyoRiyoshaFutan().getRadRiyoshaFutanKubunCode().getSelectedKey();
            return RString.isNullOrEmpty(利用者負担区分);
        }

        /**
         * 標準負担区分の必須です。
         *
         * @param div JukyushaIdoRenrakuhyoDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check標準負担区分の必須(JukyushaIdoRenrakuhyoDiv div) {
            RString 標準負担区分 = div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().getJukyushaIdoRenrakuhyoHyojunFutan().
                    getRadHyojunFutanKubun().getSelectedKey();
            return RString.isNullOrEmpty(標準負担区分);
        }

        /**
         * 認定申請中区分の必須です。
         *
         * @param div JukyushaIdoRenrakuhyoDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check認定申請中区分の必須(JukyushaIdoRenrakuhyoDiv div) {
            RString 認定申請中区分 = div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                    getRadTokuteiNyushoshaNinteiShinseichuKubun().getSelectedKey();
            return RString.isNullOrEmpty(認定申請中区分);
        }

        /**
         * サービス区分の必須です。
         *
         * @param div JukyushaIdoRenrakuhyoDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean checkサービス区分の必須(JukyushaIdoRenrakuhyoDiv div) {
            RString サービス区分 = div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                    getRadTokuteiNyushoshaKaigoServiceKubun().getSelectedKey();
            return RString.isNullOrEmpty(サービス区分);
        }

        /**
         * 特例減額措置対象の必須です。
         *
         * @param div JukyushaIdoRenrakuhyoDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check特例減額措置対象の必須(JukyushaIdoRenrakuhyoDiv div) {
            RString 特例減額措置対象 = div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                    getRadKaizeisoTokureiGengakuSochiTaishoFlag().getSelectedKey();
            return RString.isNullOrEmpty(特例減額措置対象);
        }

        /**
         * 公費負担上限額減額(生活保護等)の必須です。
         *
         * @param div JukyushaIdoRenrakuhyoDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check公費負担上限額減額_生活保護等の必須(JukyushaIdoRenrakuhyoDiv div) {
            RString 公費負担上限額減額_生活保護 = div.getKyufuSeigenPanel().getRadKohiFutanJogenGengakuAriFlag().getSelectedKey();
            return RString.isNullOrEmpty(公費負担上限額減額_生活保護);
        }

        /**
         * 二次予防事業区分の必須です。
         *
         * @param div JukyushaIdoRenrakuhyoDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check二次予防事業区分の必須(JukyushaIdoRenrakuhyoDiv div) {
            RString 二次予防事業区分 = div.getNijiyoboJigyoPanel().getRadNijiyoboJigyoKubun().getSelectedKey();
            return RString.isNullOrEmpty(二次予防事業区分);
        }

        /**
         * (旧訪問通所)　管理適用期間の関連です。
         *
         * @param div JukyushaIdoRenrakuhyoDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check旧訪問通所_管理適用期間の関連(JukyushaIdoRenrakuhyoDiv div) {
            return 期間関連チェック(div.getShikyuGendoKijungakuPanel().getTxtHomonTsushoServiceJogenKanriTekiyoYMD());
        }

        /**
         * (旧短期入所)　管理適用期間の関連です。
         *
         * @param div JukyushaIdoRenrakuhyoDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check旧短期入所_管理適用期間の関連(JukyushaIdoRenrakuhyoDiv div) {
            return 期間関連チェック(div.getShikyuGendoKijungakuPanel().getTxtTankinyushoServiceJogenKanriTekiyoYMD());
        }

        /**
         * 居宅適用期間の関連チェックです。
         *
         * @param div JukyushaIdoRenrakuhyoDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check居宅適用期間の関連(JukyushaIdoRenrakuhyoDiv div) {
            return 期間関連チェック(div.getKyotakuServicePlanPanel().getTxtKyotakuServiceTekiyoYMD());
        }

        /**
         * 住特適用期間の関連チェックです。
         *
         * @param div JukyushaIdoRenrakuhyoDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check住特適用期間の関連(JukyushaIdoRenrakuhyoDiv div) {
            return 期間関連チェック(div.getJushochiTokureiPanel().getTxtJushochiTokureiTekiyoYMD());
        }

        /**
         * 住特適用期間の関連チェック３です。
         *
         * @param div JukyushaIdoRenrakuhyoDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check住特適用期間の送付年月関連(JukyushaIdoRenrakuhyoDiv div) {
            FlexibleDate 送付年月 = div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtSofuYM().getValue();
            FlexibleDate check年月 = new FlexibleDate("平成24年4月");
            return (送付年月 != null && !送付年月.toString().isEmpty() && 送付年月.isBefore(check年月))
                    && 期間いずれか設定チェック(div.getJushochiTokureiPanel().getTxtJushochiTokureiTekiyoYMD());
        }

        /**
         * 住特適用期間の関連チェック４です。
         *
         * @param div JukyushaIdoRenrakuhyoDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check住特適用期間の異動日関連(JukyushaIdoRenrakuhyoDiv div) {
            FlexibleDate 異動日 = div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtIdoYMD().getValue();
            RDate check年月 = new RDate("平成24年3月31日");
            return (異動日 != null && !異動日.toString().isEmpty() && 異動日.isBefore(new FlexibleDate(check年月.toString())))
                    && 期間いずれか設定チェック(div.getJushochiTokureiPanel().getTxtJushochiTokureiTekiyoYMD());
        }

        /**
         * 利用者負担適用期間の関連チェックです。
         *
         * @param div JukyushaIdoRenrakuhyoDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check利用者負担適用期間の関連(JukyushaIdoRenrakuhyoDiv div) {
            return 期間関連チェック(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().getJukyushaIdoRenrakuhyoRiyoshaFutan().
                    getTxtTekiyoYMD());
        }

        /**
         * 社会福祉法人軽減情報適用期間の関連チェックです。
         *
         * @param div JukyushaIdoRenrakuhyoDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check社会福祉法人軽減情報適用期間の関連(JukyushaIdoRenrakuhyoDiv div) {
            return 期間関連チェック(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().
                    getJukyushaIdoRenrakuhyoFukushiHojinKeigen().
                    getTxtKeigenritsuTekiyoYMD());
        }

        /**
         * 社会福祉法人軽減情報適用期間の関連チェック３です。
         *
         * @param div JukyushaIdoRenrakuhyoDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check社会福祉法人軽減情報適用期間の送付年月関連(JukyushaIdoRenrakuhyoDiv div) {
            FlexibleDate 送付年月 = div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtSofuYM().getValue();
            FlexibleDate check年月 = new FlexibleDate("平成17年10月");
            return (送付年月 != null && !送付年月.toString().isEmpty() && 送付年月.isBefore(check年月))
                    && 期間いずれか設定チェック(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().
                            getJukyushaIdoRenrakuhyoFukushiHojinKeigen().getTxtKeigenritsuTekiyoYMD());
        }

        /**
         * 社会福祉法人軽減情報適用期間の関連チェック４です。
         *
         * @param div JukyushaIdoRenrakuhyoDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check社会福祉法人軽減情報適用期間の異動日関連(JukyushaIdoRenrakuhyoDiv div) {
            FlexibleDate 異動日 = div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtIdoYMD().getValue();
            RDate check年月 = new RDate("平成17年9月30日");
            return (異動日 != null && !異動日.toString().isEmpty() && 異動日.isBefore(new FlexibleDate(check年月.toString())))
                    && 期間いずれか設定チェック(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().
                            getJukyushaIdoRenrakuhyoFukushiHojinKeigen().getTxtKeigenritsuTekiyoYMD());
        }

        /**
         * 標準負担適用期間の関連チェックです。
         *
         * @param div JukyushaIdoRenrakuhyoDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check標準負担適用期間の関連(JukyushaIdoRenrakuhyoDiv div) {
            return 期間関連チェック(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().getJukyushaIdoRenrakuhyoHyojunFutan().
                    getTxtFutangakuTekiyoYMD());
        }

        /**
         * 食費限度額適用期間の関連チェックです。
         *
         * @param div JukyushaIdoRenrakuhyoDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check食費限度額適用期間の関連(JukyushaIdoRenrakuhyoDiv div) {
            return 期間関連チェック(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                    getTxtFutanGendogakuTekiyoYMD());
        }

        /**
         * 食費限度額適用期間の関連チェック３です。
         *
         * @param div JukyushaIdoRenrakuhyoDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check食費限度額適用期間の送付年月関連(JukyushaIdoRenrakuhyoDiv div) {
            FlexibleDate 送付年月 = div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtSofuYM().getValue();
            FlexibleDate check年月 = new FlexibleDate("平成17年10月");
            return (送付年月 != null && !送付年月.toString().isEmpty() && 送付年月.isBefore(check年月))
                    && 期間いずれか設定チェック(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                            getTxtFutanGendogakuTekiyoYMD());
        }

        /**
         * 食費限度額適用期間の関連チェック４です。
         *
         * @param div JukyushaIdoRenrakuhyoDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check食費限度額適用期間の異動日関連(JukyushaIdoRenrakuhyoDiv div) {
            FlexibleDate 異動日 = div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtIdoYMD().getValue();
            RDate check年月 = new RDate("平成17年9月30日");
            return (異動日 != null && !異動日.toString().isEmpty() && 異動日.isBefore(new FlexibleDate(check年月.toString())))
                    && 期間いずれか設定チェック(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                            getTxtFutanGendogakuTekiyoYMD());
        }

        /**
         * 償還払化期間の関連チェックです。
         *
         * @param div JukyushaIdoRenrakuhyoDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check償還払化期間の関連(JukyushaIdoRenrakuhyoDiv div) {
            return 期間関連チェック(div.getKyufuSeigenPanel().getTxtKyufuritsuHikisage());
        }

        /**
         * 給付率引下げ期間の関連チェックです。
         *
         * @param div JukyushaIdoRenrakuhyoDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check給付率引下げ期間の関連(JukyushaIdoRenrakuhyoDiv div) {
            return 期間関連チェック(div.getKyufuSeigenPanel().getTxtShokanbaraikaYMD());
        }

        /**
         * 二割負担事業適用期間の関連チェックです。
         *
         * @param div JukyushaIdoRenrakuhyoDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check二割負担事業適用期間の関連(JukyushaIdoRenrakuhyoDiv div) {
            return 期間関連チェック(div.getRiyosyaFutanWariaiPanel().getTxtRiyosyaFutanWariaiYukoYMD());
        }

        /**
         * 二割負担事業適用期間の関連チェック３です。
         *
         * @param div JukyushaIdoRenrakuhyoDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check二割負担事業適用期間の送付年月関連(JukyushaIdoRenrakuhyoDiv div) {
            FlexibleDate 送付年月 = div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtSofuYM().getValue();
            FlexibleDate check年月 = new FlexibleDate("平成27年4月");
            return (送付年月 != null && !送付年月.toString().isEmpty() && 送付年月.isBefore(check年月))
                    && 期間いずれか設定チェック(div.getRiyosyaFutanWariaiPanel().getTxtRiyosyaFutanWariaiYukoYMD());
        }

        /**
         * 二割負担事業適用期間の関連チェック４です。
         *
         * @param div JukyushaIdoRenrakuhyoDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check二割負担事業適用期間の異動日関連(JukyushaIdoRenrakuhyoDiv div) {
            FlexibleDate 異動日 = div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtIdoYMD().getValue();
            RDate check年月 = new RDate("平成27年7月31日");
            return (異動日 != null && !異動日.toString().isEmpty() && 異動日.isBefore(new FlexibleDate(check年月.toString())))
                    && 期間いずれか設定チェック(div.getRiyosyaFutanWariaiPanel().getTxtRiyosyaFutanWariaiYukoYMD());
        }

        /**
         * 二次予防事業適用期間の関連チェックです。
         *
         * @param div JukyushaIdoRenrakuhyoDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check二次予防事業適用期間の関連(JukyushaIdoRenrakuhyoDiv div) {
            return 期間関連チェック(div.getNijiyoboJigyoPanel().getTxtNijiyoboJigyoYukoDateRange());
        }

        /**
         * 二次予防事業適用期間の関連チェック３です。
         *
         * @param div JukyushaIdoRenrakuhyoDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check二次予防事業適用期間の送付年月関連(JukyushaIdoRenrakuhyoDiv div) {
            FlexibleDate 送付年月 = div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtSofuYM().getValue();
            FlexibleDate check年月 = new FlexibleDate("平成24年4月");
            return (送付年月 != null && !送付年月.toString().isEmpty() && 送付年月.isBefore(check年月))
                    && 期間いずれか設定チェック(div.getNijiyoboJigyoPanel().getTxtNijiyoboJigyoYukoDateRange());
        }

        /**
         * 二次予防事業適用期間の関連チェック４です。
         *
         * @param div JukyushaIdoRenrakuhyoDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check二次予防事業適用期間の異動日関連(JukyushaIdoRenrakuhyoDiv div) {
            FlexibleDate 異動日 = div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtIdoYMD().getValue();
            RDate check年月 = new RDate("平成24年3月31日");
            return (異動日 != null && !異動日.toString().isEmpty() && 異動日.isBefore(new FlexibleDate(check年月.toString())))
                    && 期間いずれか設定チェック(div.getNijiyoboJigyoPanel().getTxtNijiyoboJigyoYukoDateRange());
        }

        private static boolean 期間関連チェック(TextBoxDateRange textBoxDateRange) {
            RDate 期間From = textBoxDateRange.getFromValue();
            RDate 期間To = textBoxDateRange.getToValue();
            return (期間From == null && 期間To != null);
        }

        private static boolean 期間いずれか設定チェック(TextBoxDateRange textBoxDateRange) {
            RDate 期間From = textBoxDateRange.getFromValue();
            RDate 期間To = textBoxDateRange.getToValue();
            return (期間From != null || 期間To != null);
        }

    }
}
