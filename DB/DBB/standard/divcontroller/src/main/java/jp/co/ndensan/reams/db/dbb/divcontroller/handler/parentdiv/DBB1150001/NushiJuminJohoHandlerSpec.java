/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB1150001;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1150001.NushiJuminJohoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1150001.dgHakkoKakunin_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1150001.dgShotokuShokaiHyoHakko_Row;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 *
 */
public enum NushiJuminJohoHandlerSpec implements IPredicate<NushiJuminJohoDiv> {

    /**
     * 世帯員選択
     */
    世帯員選択 {
                @Override
                public boolean apply(NushiJuminJohoDiv div) {
                    return SpecHelper.is世帯員選択(div);
                }
            },
    /**
     * 照会先不正
     */
    照会先不正 {
                @Override
                public boolean apply(NushiJuminJohoDiv div) {
                    return SpecHelper.is照会先不正(div);
                }
            },
    /**
     * 現住所不正
     */
    現住所不正 {
                @Override
                public boolean apply(NushiJuminJohoDiv div) {
                    return SpecHelper.is現住所不正(div);
                }
            };

    private static class SpecHelper {

        private static final int 整数_ZERO = 0;
        private static final int 整数_ONE = 1;

        public static boolean is世帯員選択(NushiJuminJohoDiv div) {
            List<dgShotokuShokaiHyoHakko_Row> rowList = div.getShotokuShokaiHyoHakkoIchiranPanel().getDgShotokuShokaiHyoHakko().getSelectedItems();
            if (rowList == null || rowList.isEmpty()) {
                return false;
            }
            return true;
        }

        public static boolean is照会先不正(NushiJuminJohoDiv div) {
            List<dgHakkoKakunin_Row> rowList = div.getHakkoKakuninPanel().getDgHakkoKakunin().getDataSource();
            boolean flag = true;
            if (rowList.size() > 整数_ONE) {
                dgHakkoKakunin_Row row_最初 = rowList.get(整数_ZERO);
                for (dgHakkoKakunin_Row row : rowList) {
                    flag = row_最初.getTxtSofusaki().equals(row.getTxtSofusaki());
                }
            }
            return flag;
        }

        public static boolean is現住所不正(NushiJuminJohoDiv div) {
            List<dgHakkoKakunin_Row> rowList = div.getHakkoKakuninPanel().getDgHakkoKakunin().getDataSource();
            boolean flag = true;
            if (rowList.size() > 整数_ONE) {
                dgHakkoKakunin_Row row_最初 = rowList.get(整数_ZERO);
                for (dgHakkoKakunin_Row row : rowList) {
                    flag = row_最初.getTxtGenJusho().equals(row.getTxtGenJusho());
                }
            }
            return flag;
        }
    }
}
