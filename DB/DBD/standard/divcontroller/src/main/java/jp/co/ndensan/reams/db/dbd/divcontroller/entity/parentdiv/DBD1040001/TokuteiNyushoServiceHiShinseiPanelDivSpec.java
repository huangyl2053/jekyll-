/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1040001;

import jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.tokubetsuchikikasangemmen.TokubetsuChiikiKasanGemmenService;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.futanwariai.FutanwariaiKubun;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 特別地域加算減免申請バリデーションクラスです。
 *
 * @reamsid_L DBD-3680-010 miaojin
 */
public enum TokuteiNyushoServiceHiShinseiPanelDivSpec implements IPredicate<TokuteiNyushoServiceHiShinseiDiv> {
    申請日の非空チェック {
        /**
         * 申請日の非空チェックです。
         *
         * @param div 特別地域加算減免申請Div
         * @return true:申請日が非空です、false:申請日が空です。
         */
        @Override
        public boolean apply(TokuteiNyushoServiceHiShinseiDiv div) {
            return div.getShinseiDetail().getTxtShinseiYMD().getValue() != null && !div.getShinseiDetail().getTxtShinseiYMD().getValue().isEmpty()
                    && div.getShinseiDetail().getTxtShinseiYMD().getValue().isValid();
        }
    },
    //    決定区分の非空チェック {
    //        /**
    //         * 決定区分の非空チェックです。
    //         *
    //         * @param div 特別地域加算減免申請Div
    //         * @return true:決定区分が非空です、false:決定区分が空です。
    //         */
    //        @Override
    //        public boolean apply(TokuteiNyushoServiceHiShinseiDiv div) {
    //            return div.getShinseiDetail().getRadKettaiKubun().getSelectedKey() != null;
    //        }
    //    },
    //    決定日の非空チェック {
    //        /**
    //         * 決定日の非空チェックです。
    //         *
    //         * @param div 特別地域加算減免申請Div
    //         * @return true:決定日が非空です、false:決定日が空です。
    //         */
    //        @Override
    //        public boolean apply(TokuteiNyushoServiceHiShinseiDiv div) {
    //            return div.getShinseiDetail().getTxtKettaiYMD().getValue() != null && !div.getShinseiDetail().getTxtKettaiYMD().getValue().isEmpty()
    //                    && div.getShinseiDetail().getTxtKettaiYMD().getValue().isValid();
    //        }
    //    },
    //    適用日の非空チェック {
    //        /**
    //         * 適用日の非空チェックです。
    //         *
    //         * @param div 特別地域加算減免申請Div
    //         * @return true:適用日が非空です、false:適用日が空です。
    //         */
    //        @Override
    //        public boolean apply(TokuteiNyushoServiceHiShinseiDiv div) {
    //            return div.getShinseiDetail().getTxtTekiyoYMD().getValue() != null && !div.getShinseiDetail().getTxtTekiyoYMD().getValue().isEmpty()
    //                    && div.getShinseiDetail().getTxtTekiyoYMD().getValue().isValid();
    //        }
    //    },
    //    有効期限の非空チェック {
    //        /**
    //         * 有効期限の非空チェックです。
    //         *
    //         * @param div 特別地域加算減免申請Div
    //         * @return true:有効期限が非空です、false:有効期限が空です。
    //         */
    //        @Override
    //        public boolean apply(TokuteiNyushoServiceHiShinseiDiv div) {
    //            return div.getShinseiDetail().getTxtYukoKigenYMD().getValue() != null && !div.getShinseiDetail().getTxtYukoKigenYMD().getValue().isEmpty()
    //                    && div.getShinseiDetail().getTxtYukoKigenYMD().getValue().isValid();
    //        }
    //    },
    //    軽減率の非空チェック {
    //        /**
    //         * 軽減率の非空チェックです。
    //         *
    //         * @param div 特別地域加算減免申請Div
    //         * @return true:軽減率が非空です、false:軽減率が空です。
    //         */
    //        @Override
    //        public boolean apply(TokuteiNyushoServiceHiShinseiDiv div) {
    //            return div.getShinseiDetail().getTxtKeigenRitsu().getValue() != null;
    //        }
    //    };
    特別地域加算減免_適用日が法施行以前のチェック {
        /**
         * 特別地域加算減免_適用日が法施行以前のチェック。
         *
         * @param div 特別地域加算減免申請Div
         * @return true:特別地域加算減免_適用日が法施行以前ではないです、false:特別地域加算減免_適用開始日が法施行以前です。
         */
        @Override
        public boolean apply(TokuteiNyushoServiceHiShinseiDiv div) {
            FlexibleDate 適用日 = div.getShinseiDetail().getTxtTekiyoYMD().getValue();
            RString 法施行日 = DbBusinessConfig.get(ConfigNameDBU.介護保険法情報_介護保険施行日, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
            return new FlexibleDate(法施行日).isBeforeOrEquals(適用日);
        }
    },
    特別地域加算減免_適用終了日が年度外のチェック {
        /**
         * 特別地域加算減免_適用終了日が年度外のチェック。
         *
         * @param div 特別地域加算減免申請Div
         * @return true:特別地域加算減免_適用終了日が年度外ではないです、false:特別地域加算減免_適用終了日が年度外です。
         */
        @Override
        public boolean apply(TokuteiNyushoServiceHiShinseiDiv div) {
            TokubetsuChiikiKasanGemmenService service = TokubetsuChiikiKasanGemmenService.createIntance();

            FlexibleDate 適用日 = div.getShinseiDetail().getTxtTekiyoYMD().getValue();
            FlexibleDate 標準有効期限 = service.estimate有効期限(適用日);
            FlexibleDate 有効期限 = div.getShinseiDetail().getTxtYukoKigenYMD().getValue();
            return !標準有効期限.isBefore(有効期限);
        }
    },
    特別地域加算減免_適用終了日が開始日以前のチェック {
        /**
         * 特別地域加算減免_適用終了日が開始日以前のチェック。
         *
         * @param div 特別地域加算減免申請Div
         * @return true:特別地域加算減免_適用終了日が開始日以前ではないです、false:特別地域加算減免_適用終了日が開始日以前です。
         */
        @Override
        public boolean apply(TokuteiNyushoServiceHiShinseiDiv div) {

            FlexibleDate 適用日 = div.getShinseiDetail().getTxtTekiyoYMD().getValue();
            FlexibleDate 有効期限 = div.getShinseiDetail().getTxtYukoKigenYMD().getValue();

            return !有効期限.isBeforeOrEquals(適用日);
        }
    },
    減免減額_確認番号が重複のチェック {
        /**
         * 減免減額_確認番号が既に存在のチェックです。
         *
         * @param div 特別地域加算減免申請Div
         * @return true:not減免減額_確認番号が既に存在です、false:減免減額_確認番号が既に存在です。
         */
        @Override
        public boolean apply(TokuteiNyushoServiceHiShinseiDiv div) {
            TokubetsuChiikiKasanGemmenService service = TokubetsuChiikiKasanGemmenService.createIntance();
            return service.exists確認番号In同一年度(div.getShinseiDetail().getTxtTekiyoYMD().getValue(),
                    div.getShinseiDetail().getTxtKakuninNo().getValue());
        }
    },
    特別地域加算減免_軽減率範囲外のチェック {
        /**
         * 特別地域加算減免_軽減率範囲外のチェック。
         *
         * @param div 特別地域加算減免申請Div
         * @return true:特別地域加算減免_軽減率範囲外ではないです、false:特別地域加算減免_軽減率範囲外です。
         */
        @Override
        public boolean apply(TokuteiNyushoServiceHiShinseiDiv div) {
            Decimal 給付率_81 = new Decimal(81);
            Decimal 給付率_91 = new Decimal(91);
            Decimal 給付率_100 = new Decimal(100);

            HihokenshaNo 被保険者番号 = new HihokenshaNo(div.getCcdKaigoKihon().get被保険者番号());
            TokubetsuChiikiKasanGemmenService service = TokubetsuChiikiKasanGemmenService.createIntance();

            FutanwariaiKubun 負担割合区分 = service.get利用者負担割合(被保険者番号, div.getShinseiDetail().getTxtShinseiYMD().getValue());
            Decimal 軽減率 = Decimal.ZERO;
            if (div.getShinseiDetail().getTxtKeigenRitsu() != null && div.getShinseiDetail().getTxtKeigenRitsu().getValue() != null) {
                軽減率 = div.getShinseiDetail().getTxtKeigenRitsu().getValue();
            }
            return !((FutanwariaiKubun._２割.getコード().equals(負担割合区分.getコード())
                    && (軽減率.compareTo(給付率_81) < 0 || 軽減率.compareTo(給付率_100) > 0))
                    || (FutanwariaiKubun._１割.getコード().equals(負担割合区分.getコード())
                    && (軽減率.compareTo(給付率_91) < 0 || 軽減率.compareTo(給付率_100) > 0)));
        }
    },
    受給共通_受給者登録なしのチェック {
        /**
         * 受給共通_受給者登録なしのチェック。
         *
         * @param div 利用者負担額減額申請Div
         * @return true:受給共通_受給者登録なしではないです、false:受給共通_受給者登録なしです。
         */
        @Override
        public boolean apply(TokuteiNyushoServiceHiShinseiDiv div) {
            TokubetsuChiikiKasanGemmenService service = TokubetsuChiikiKasanGemmenService.createIntance();

            HihokenshaNo 被保険者番号 = new HihokenshaNo(div.getCcdKaigoKihon().get被保険者番号());
            FlexibleDate 適用日 = div.getShinseiDetail().getTxtTekiyoYMD().getValue();

            boolean 利用者 = service.canBe利用者(被保険者番号, 適用日);
            return 利用者;
        }
    },
}
