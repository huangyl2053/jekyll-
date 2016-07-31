/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1730011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.sogojigyokubun.SogoJigyoKubunEntity;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1730011.SogoJigyoKubunShikyuGendogakuDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * {@link SogoJigyoKubunShikyuGendogakuDiv}の仕様クラスです。 <br> {@link SogoJigyoKubunShikyuGendogakuDiv}における画面としての仕様を定義しています。
 *
 * @reamsid_L DBC-3363-010 xuxin
 */
public enum SogoJigyoKubunShikyuGendogakuSpec implements IPredicate<SogoJigyoKubunShikyuGendogakuDiv> {

    /**
     * 各必須入力項目未入力の場合です。
     */
    各必須入力項目未入力の場合 {
                @Override
                public boolean apply(SogoJigyoKubunShikyuGendogakuDiv div) {
                    return SpecHelper.is各必須入力項目未入力(div);
                }
            },
    /**
     * 適用期間重複入力の場合です。
     */
    適用期間重複入力の場合 {
                @Override
                public boolean apply(SogoJigyoKubunShikyuGendogakuDiv div) {
                    return SpecHelper.is適用期間重複入力(div);
                }
            },
    /**
     * 適用期間大小関係不正の場合です。
     */
    適用期間大小関係不正の場合 {
                @Override
                public boolean apply(SogoJigyoKubunShikyuGendogakuDiv div) {
                    return SpecHelper.is適用期間大小関係不正(div);
                }
            };

    /**
     * {@link SogoJigyoKubunShikyuGendogakuSpec}における判定ロジックのHelperクラスです。
     */
    private static class SpecHelper {

        private static final RString 登録 = new RString("登録モード");

        /**
         * *が各項目が未入力の場合、エラーとします。
         *
         * @param div SogoJigyoKubunShikyuGendogakuDiv
         */
        public static boolean is各必須入力項目未入力(SogoJigyoKubunShikyuGendogakuDiv div) {

            return !(div.getTxtTekiyoKaishiYM().getDomain() == null
                    || div.getTxtYoShien1().getText().isNullOrEmpty()
                    || div.getTxtYoShien2().getText().isNullOrEmpty()
                    || div.getTxtNijiYobo().getText().isNullOrEmpty());
        }

        /**
         * 適用期間が一部でも重複する場合はエラーとします。
         *
         * @param div SogoJigyoKubunShikyuGendogakuDiv
         */
        public static boolean is適用期間重複入力(SogoJigyoKubunShikyuGendogakuDiv div) {

            RString 保存モード = ViewStateHolder.get(ViewStateKeys.保存モード, RString.class);
            List<SogoJigyoKubunEntity> 総合事業区分情報 = ViewStateHolder.get(ViewStateKeys.総合事業区分情報, List.class);
            SogoJigyoKubunEntity firstEntity = 総合事業区分情報.get(0);
            SogoJigyoKubunEntity lastEntity = 総合事業区分情報.get(総合事業区分情報.size() - 1);
            FlexibleYearMonth 適用開始年月 = new FlexibleYearMonth(div.getTxtTekiyoKaishiYM().getDomain().toDateString());
            if (登録.equals(保存モード) && div.getTxtTekiyoKaishiYM().getDomain() != null) {
                return !(適用開始年月.isBeforeOrEquals(firstEntity.get要支援1().get適用開始年月())
                        && lastEntity.get要支援1().get適用開始年月().isBeforeOrEquals(適用開始年月));
            }
            return Boolean.TRUE;
        }

        /**
         * 適用終了の入力がある時、適用開始≦適用終了になっていない場合はエラーします。
         *
         * @param div SogoJigyoKubunShikyuGendogakuDiv
         */
        public static boolean is適用期間大小関係不正(SogoJigyoKubunShikyuGendogakuDiv div) {

            if (div.getTxtTekiyoShuryoYM().getDomain() != null) {
                return !(div.getTxtTekiyoShuryoYM().getDomain().isBefore(div.getTxtTekiyoKaishiYM().getDomain()));
            }
            return Boolean.TRUE;
        }

    }

}
