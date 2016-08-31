/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4220011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyugendogaku.ShikyuGendogakuTableKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4220011.ShokanShikyuGendogakuMainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4220011.dgShikyuGendogaku_Row;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還支給限度額登録のSpecです。
 *
 * @reamsid_L DBC-3460-010 jianglaisheng
 */
public enum ShokanShikyuGendogakuMainSpec implements IPredicate<ShokanShikyuGendogakuMainDiv> {

    /**
     * 適用開始年月のチェックです。
     */
    適用開始年月チェック {
                @Override
                public boolean apply(ShokanShikyuGendogakuMainDiv div) {
                    return SpecHelper.is適用開始年月チェック(div);
                }
            },
    /**
     * 標準適用期間内のチェックです。
     */
    標準適用期間内チェック {
                @Override
                public boolean apply(ShokanShikyuGendogakuMainDiv div) {
                    return SpecHelper.is標準適用期間内チェック(div);
                }
            };

    /**
     * {@link ShokanShikyuGendogakuMainSpec}における判定ロジックのHelperクラスです。
     */
    private static class SpecHelper {

        private static final RString RS_1 = new RString("1");

        public static boolean is適用開始年月チェック(ShokanShikyuGendogakuMainDiv div) {
            RString 入力テーブル区分 = div.getShokanShikyuGendogakuShosai().getRadTableKubun().getSelectedValue();
            RDate 入力適用期間From = div.getShokanShikyuGendogakuShosai().getTxtTekiyoKikanRange().getFromValue();
            List<dgShikyuGendogaku_Row> rowList = div.getShokanShikyuGendogakuIchiran().getDgShikyuGendogaku().getDataSource();
            for (dgShikyuGendogaku_Row row : rowList) {
                if (ShikyuGendogakuTableKubun.標準.get名称().equals(入力テーブル区分)) {
                    if (入力テーブル区分.equals(row.getTableKubun())
                            && RS_1.equals(row.getHdnSaishinFlag())
                            && 入力適用期間From.getYearMonth().isBeforeOrEquals(
                                    row.getTekiyoKaishiYM().getValue().getYearMonth())) {
                        return false;
                    }
                } else {
                    if (入力テーブル区分.equals(row.getTableKubun())
                            && RS_1.equals(row.getHdnSaishinFlag())
                            && row.getTekiyoShuryoYM().getValue() == null
                            && 入力適用期間From.getYearMonth().isBeforeOrEquals(
                                    row.getTekiyoKaishiYM().getValue().getYearMonth())) {
                        return false;
                    }
                    if (入力テーブル区分.equals(row.getTableKubun())
                            && RS_1.equals(row.getHdnSaishinFlag())
                            && row.getTekiyoShuryoYM().getValue() != null
                            && 入力適用期間From.getYearMonth().isBeforeOrEquals(
                                    row.getTekiyoShuryoYM().getValue().getYearMonth())) {
                        return false;
                    }
                }
            }
            return true;
        }

        public static boolean is標準適用期間内チェック(ShokanShikyuGendogakuMainDiv div) {
            RString 入力テーブル区分 = div.getShokanShikyuGendogakuShosai().getRadTableKubun().getSelectedValue();
            RDate 入力適用期間From = div.getShokanShikyuGendogakuShosai().getTxtTekiyoKikanRange().getFromValue();
            List<dgShikyuGendogaku_Row> rowList = div.getShokanShikyuGendogakuIchiran().getDgShikyuGendogaku().getDataSource();
            for (dgShikyuGendogaku_Row row : rowList) {
                if (ShikyuGendogakuTableKubun.上乗せ後.get名称().equals(入力テーブル区分)
                        && ShikyuGendogakuTableKubun.標準.get名称().equals(row.getTableKubun())
                        && RS_1.equals(row.getHdnSaishinFlag())
                        && 入力適用期間From.getYearMonth().isBefore(
                                row.getTekiyoKaishiYM().getValue().getYearMonth())) {
                    return false;
                }
            }
            return true;
        }
    }
}
