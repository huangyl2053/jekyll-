/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5120001;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定申請受付バリデーションクラスです。
 *
 * @reamsid_L DBD-1300-010 huangh
 */
public enum NinteiShinseiTorokuUketsukeDivSpec implements IPredicate<NinteiShinseiTorokuUketsukeDiv> {

    開始日が未入力チェック {
        /**
         * 開始日が未入力チェックです。
         *
         * @param div 要介護認定申請受付Div
         * @return true:開始日が非空です、false:開始日が空です。
         */
        @Override
        public boolean apply(NinteiShinseiTorokuUketsukeDiv div) {
            return div.getCcdNinteiInput().getNinteiJoho().getTxtYukoKaishiYMD().getValue() != null
                    && !div.getCcdNinteiInput().getNinteiJoho().getTxtYukoKaishiYMD().getValue().isEmpty()
                    && div.getCcdNinteiInput().getNinteiJoho().getTxtYukoKaishiYMD().isValid();
        }
    },
    終了日が未入力チェック {
        /**
         * 終了日が未入力チェックです。
         *
         * @param div 要介護認定申請受付Div
         * @return true:終了日が非空です、false:終了日が空です。
         */
        @Override
        public boolean apply(NinteiShinseiTorokuUketsukeDiv div) {
            return div.getCcdNinteiInput().getNinteiJoho().getTxtYukoShuryoYMD().getValue() != null
                    && !div.getCcdNinteiInput().getNinteiJoho().getTxtYukoShuryoYMD().getValue().isEmpty()
                    && div.getCcdNinteiInput().getNinteiJoho().getTxtYukoShuryoYMD().isValid();
        }
    },
    申請日が未入力チェック {
        /**
         * 申請日が未入力チェックです。
         *
         * @param div 要介護認定申請受付Div
         * @return true:申請日が非空です、false:申請日が空です。
         */
        @Override
        public boolean apply(NinteiShinseiTorokuUketsukeDiv div) {
            return div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getTxtShinseiYMD().getValue() != null
                    && !div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getTxtShinseiYMD().getText().isEmpty()
                    && div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getTxtShinseiYMD().isValid();
        }
    },
    要介護度が未入力チェック {
        /**
         * 申請日が未入力チェックです。
         *
         * @param div 要介護認定申請受付Div
         * @return true:要介護度が非空です、false:要介護度が空です。
         */
        @Override
        public boolean apply(NinteiShinseiTorokuUketsukeDiv div) {
            return div.getCcdNinteiInput().getNinteiJoho().getTxtYokaigodoCode().getValue() != null
                    && !div.getCcdNinteiInput().getNinteiJoho().getTxtYokaigodoCode().getValue().isEmpty()
                    && div.getCcdNinteiInput().getNinteiJoho().getTxtYokaigodoCode().isValid();
        }
    },
    喪失日が未入力チェック {
        /**
         * 申請日が未入力チェックです。
         *
         * @param div 要介護認定申請受付Div
         * @return true:喪失日が非空です、false:喪失日が空です。
         */
        @Override
        public boolean apply(NinteiShinseiTorokuUketsukeDiv div) {
            return div.getCcdShinseiSonotaJohoInput().get喪失日() != null
                    && !div.getCcdShinseiSonotaJohoInput().get喪失日().isEmpty()
                    && div.getCcdShinseiSonotaJohoInput().get喪失日().isValid();
        }
    },
    被保険者台帳に該当なしチェック {
        /**
         * 被保険者台帳に該当なしチェックです。
         *
         * @param div 要介護認定申請受付Div
         * @return true:被保険者台帳に該当ありです、false:被保険者台帳に該当なしです。
         */
        @Override
        public boolean apply(NinteiShinseiTorokuUketsukeDiv div) {

            //TODO
            return true;
        }
    },
    開始日と終了日の前後順チェック {
        /**
         * 開始日と終了日の前後順チェックです。
         *
         * @param div 要介護認定申請受付Div
         * @return true:開始日＜＝終了日、false:開始日＞終了日。
         */
        @Override
        public boolean apply(NinteiShinseiTorokuUketsukeDiv div) {

            FlexibleDate 開始日 = div.getCcdNinteiInput().getNinteiJoho().getTxtYukoKaishiYMD().getValue();
            FlexibleDate 終了日 = div.getCcdNinteiInput().getNinteiJoho().getTxtYukoShuryoYMD().getValue();
            if (!終了日.isBeforeOrEquals(開始日)) {
                return false;
            }
            return true;
        }
    },
    有効期間が重複チェック {
        /**
         * 有効期間が重複チェックです。
         *
         * @param div 要介護認定申請受付Div
         * @return true:前回有効終了日＜今回有効開始日です、false:前回有効終了日≧今回有効開始日です。
         */
        @Override
        public boolean apply(NinteiShinseiTorokuUketsukeDiv div) {

            FlexibleDate 今回有効開始日 = div.getCcdNinteiInput().getNinteiJoho().getTxtYukoKaishiYMD().getValue();
            FlexibleDate 前回有効終了日 = div.getCcdZenkaiNinteiKekkaJoho().getTxtYukoKikanTo().getValue();
            if (今回有効開始日.isBeforeOrEquals(前回有効終了日)) {
                return false;
            }
            return true;
        }
    },
    _６０日以前の申請チェック {
        /**
         * _６０日以前の申請チェックです。
         *
         * @param div 要介護認定申請受付Div
         * @return true:今回申請日が前回有効期限終了日の61日以前でない、false:今回申請日が前回有効期限終了日の61日以前です。
         */
        @Override
        public boolean apply(NinteiShinseiTorokuUketsukeDiv div) {

            RString 今回申請日 = div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getTxtShinseiYMD().getText();
            FlexibleDate 前回有効終了日 = div.getCcdZenkaiNinteiKekkaJoho().getTxtYukoKikanTo().getValue();
            if (new FlexibleDate(今回申請日).isBeforeOrEquals(前回有効終了日.minusDay(61))) {
                return false;
            }
            return true;
        }
    },
    変更元が_要支援チェック {
        /**
         * 変更元が_要支援チェックです。
         *
         * @param div 要介護認定申請受付Div
         * @return true:今回申請日が前回有効期限終了日の61日以前でない、false:今回申請日が前回有効期限終了日の61日以前です。
         */
        @Override
        public boolean apply(NinteiShinseiTorokuUketsukeDiv div) {

            //TODO
            return true;
        }
    },
    変更元が_自立チェック {
        /**
         * 変更元が_要支援チェックです。
         *
         * @param div 要介護認定申請受付Div
         * @return true:今回申請日が前回有効期限終了日の61日以前でない、false:今回申請日が前回有効期限終了日の61日以前です。
         */
        @Override
        public boolean apply(NinteiShinseiTorokuUketsukeDiv div) {

            //TODO
            return true;
        }
    },
}
