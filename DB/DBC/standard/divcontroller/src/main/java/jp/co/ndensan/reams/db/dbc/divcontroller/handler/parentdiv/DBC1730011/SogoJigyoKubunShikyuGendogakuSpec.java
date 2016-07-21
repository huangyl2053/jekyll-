/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1730011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1730011.SogoJigyoKubunShikyuGendogakuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1730011.dgShikyuGendogaku_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
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
            if (登録.equals(保存モード)) {
                List<dgShikyuGendogaku_Row> dataSource = div.getDgShikyuGendogaku().getDataSource();
                dgShikyuGendogaku_Row 首行 = dataSource.get(0);
                int 末行数 = dataSource.size() - 1;
                dgShikyuGendogaku_Row 末行 = dataSource.get(末行数);
                if (!dataSource.isEmpty() && 首行.getTekiyoShuryo().getText().isNullOrEmpty()) {
                    return !(div.getTxtTekiyoShuryoYM().getDomain() == null
                            || 末行.getTekiyoKaishi().getValue().getYearMonth().isBeforeOrEquals(div.getTxtTekiyoShuryoYM().getDomain()));
                }
                if (!dataSource.isEmpty() && !首行.getTekiyoShuryo().getText().isNullOrEmpty()) {
                    return (div.getTxtTekiyoShuryoYM().getDomain() == null ? RDate.MAX.getYearMonth() : div.getTxtTekiyoShuryoYM().getDomain()).isBefore(末行.getTekiyoKaishi().getValue().getYearMonth())
                            || 首行.getTekiyoShuryo().getValue().getYearMonth().isBefore(div.getTxtTekiyoKaishiYM().getDomain() == null ? RDate.MIN.getYearMonth() : div.getTxtTekiyoKaishiYM().getDomain());
                }
            }
            return Boolean.TRUE;
        }

    }

}
