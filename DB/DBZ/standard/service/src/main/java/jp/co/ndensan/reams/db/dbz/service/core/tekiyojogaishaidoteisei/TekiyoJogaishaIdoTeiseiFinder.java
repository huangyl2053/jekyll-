/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.tekiyojogaishaidoteisei;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.tekiyojogaishaidoteisei.TekiyoJogaishaIdoTeiseiBusiness;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1004ShisetsuNyutaishoDac;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 適用除外者異動の訂正のクラスです。
 *
 * @reamsid_L DBA-0411-030 wangjie2
 */
public class TekiyoJogaishaIdoTeiseiFinder {

    private static final RString DELETE = new RString("delete");

    /**
     * 適用除外者異動の訂正します。
     *
     * @param informationEntityLst 適用除外情報リスト
     * @return 結果フラグ
     */
    public boolean checkTekiyoJogaiKikanByTeiseiMode(List<TekiyoJogaishaIdoTeiseiBusiness> informationEntityLst) {
        DbT1004ShisetsuNyutaishoDac dbT1004ShisetsuNyutaishoDac = InstanceProvider.create(DbT1004ShisetsuNyutaishoDac.class);
        for (TekiyoJogaishaIdoTeiseiBusiness informationEntity : informationEntityLst) {
            if (DELETE.equals(informationEntity.get状態())) {
                continue;
            }
            List<DbT1004ShisetsuNyutaishoEntity> dbT1004EntityLst
                    = dbT1004ShisetsuNyutaishoDac.selectNyushoymdAndTaishoymd(informationEntity.get適用日(), informationEntity.get解除日());
            if (dbT1004EntityLst.isEmpty()) {
                return false;
            }
            if (getCount(informationEntityLst, dbT1004EntityLst) > 1) {
                return false;
            }
        }
        return true;
    }

    private int getCount(List<TekiyoJogaishaIdoTeiseiBusiness> informationEntityLst, List<DbT1004ShisetsuNyutaishoEntity> dbT1004EntityLst) {
        int count = 0;
        for (DbT1004ShisetsuNyutaishoEntity dbT1004Entity : dbT1004EntityLst) {
            for (TekiyoJogaishaIdoTeiseiBusiness infEntity : informationEntityLst) {
                if (DELETE.equals(infEntity.get状態())) {
                    continue;
                }
                FlexibleDate taishoYMD = dbT1004Entity.getTaishoYMD();
                FlexibleDate nyushoYMD = dbT1004Entity.getNyushoYMD();
                if (is日付空(infEntity.get適用日()) && is日付空(infEntity.get解除日())) {
                    count++;
                } else if (is日付空(infEntity.get適用日())
                        && !(taishoYMD != null && taishoYMD.isBeforeOrEquals(infEntity.get適用日())
                        && taishoYMD.isBefore(infEntity.get解除日()))) {
                    count++;
                } else if (is日付空(infEntity.get解除日())) {
                    count++;
                } else if (!((nyushoYMD != null && infEntity.get適用日().isBefore(nyushoYMD)
                        && infEntity.get解除日().isBeforeOrEquals(nyushoYMD))
                        || (taishoYMD != null && taishoYMD.isBeforeOrEquals(infEntity.get適用日())
                        && taishoYMD.isBefore(infEntity.get解除日())))) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean is日付空(FlexibleDate 日付) {
        return null == 日付 || 日付.isEmpty();

    }

}
