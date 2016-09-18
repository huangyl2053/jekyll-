/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.tekiyojogaishaidoteisei;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.TekiyoJogaisha;
import jp.co.ndensan.reams.db.dbz.business.core.TekiyoJogaishaBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.tekiyojogaishaidoteisei.TekiyoJogaishaIdoTeiseiBusiness;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1002TekiyoJogaishaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1002TekiyoJogaishaDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1004ShisetsuNyutaishoDac;
import jp.co.ndensan.reams.db.dbz.service.core.basic.TekiyoJogaishaManager;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 適用除外者異動の訂正のクラスです。
 *
 * @reamsid_L DBA-0411-030 wangjie2
 */
public class TekiyoJogaishaIdoTeiseiFinder {

    private static final RString DELETE = new RString("delete");
    private static final RString Modified = new RString("Modified");
    private static final RString 枝番_1 = new RString("0001");
    private static final int 枝番_桁 = 4;

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
             if (Modified.equals(informationEntity.get状態())&&informationEntity.get解除日().isEmpty()) {
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

    /**
     * 訂正時の更新処理します。
     *
     * @param 現在の除外の情報 現在の除外の情報
     * @param 修正後の除外の情報 修正後の除外の情報
     * @return 更新件数
     */
    @Transaction
    public int save異動訂正(TekiyoJogaisha 現在の除外の情報, TekiyoJogaisha 修正後の除外の情報) {
        TekiyoJogaishaManager manager = TekiyoJogaishaManager.createInstance();
        int 更新件数;
        if (is年月日が一致(現在の除外の情報.get異動日(), 修正後の除外の情報.get異動日())) {
            manager.save適用除外者(現在の除外の情報.createBuilderForEdit().set論理削除フラグ(true).build());
            int 枝番 = Integer.parseInt(現在の除外の情報.get枝番().toString()) + 1;
            manager.save適用除外者(get追加適用除外者(修正後の除外の情報
                    .createBuilderForEdit().set枝番(new RString(String.valueOf(枝番)).padLeft("0", 枝番_桁)).build()));
        } else {
            manager.save適用除外者(現在の除外の情報.createBuilderForEdit().set論理削除フラグ(true).build());
            manager.save適用除外者(get追加適用除外者(修正後の除外の情報));
        }
        更新件数 = 2;
        if (is年月日が一致(現在の除外の情報.get適用年月日(), 修正後の除外の情報.get適用年月日())
                && is年月日が一致(現在の除外の情報.get適用届出年月日(), 修正後の除外の情報.get適用届出年月日())
                && is適用除外適用事由コードが一致(現在の除外の情報.get適用除外適用事由コード(), 修正後の除外の情報.get適用除外適用事由コード())) {
            return 更新件数;
        }
        FlexibleDate 検索用適用年月日 = 現在の除外の情報.get適用年月日();
        ShikibetsuCode 識別コード = 現在の除外の情報.get識別コード();
        DbT1002TekiyoJogaishaDac dbT1002Dac = InstanceProvider.create(DbT1002TekiyoJogaishaDac.class);
        List<DbT1002TekiyoJogaishaEntity> dbT1002EntityList = dbT1002Dac.selectBy識別コードAnd適用年月日(検索用適用年月日, 識別コード);
        if (null == dbT1002EntityList || dbT1002EntityList.isEmpty()) {
            return 更新件数;
        }
        for (DbT1002TekiyoJogaishaEntity dbT1002Entity : dbT1002EntityList) {
            DbT1002TekiyoJogaishaEntity dbT1002Entityクローン = dbT1002Entity.clone();
            if (dbT1002Entityクローン.getIdoYMD().equals(dbT1002Entityクローン.getTekiyoYMD())) {
                dbT1002Entityクローン.setIdoYMD(修正後の除外の情報.get適用年月日());
                dbT1002Entityクローン.setIdoJiyuCode(修正後の除外の情報.get異動事由コード());
                dbT1002Entityクローン.setTekiyoYMD(修正後の除外の情報.get適用年月日());
                dbT1002Entityクローン.setTekiyoTodokedeYMD(修正後の除外の情報.get適用届出年月日());
                dbT1002Entityクローン.setTekiyoJogaiTekiyoJiyuCode(修正後の除外の情報.get適用除外適用事由コード());
                dbT1002Entityクローン.setEdaNo(枝番_1);
            } else {
                dbT1002Entityクローン.setIdoYMD(修正後の除外の情報.get適用年月日());
                dbT1002Entityクローン.setTekiyoTodokedeYMD(修正後の除外の情報.get適用届出年月日());
                dbT1002Entityクローン.setTekiyoJogaiTekiyoJiyuCode(修正後の除外の情報.get適用除外適用事由コード());
                dbT1002Entityクローン.setEdaNo(new RString(Integer.parseInt(dbT1002Entity.getEdaNo().toString()) + 1).padLeft("0", 枝番_桁));
            }
            dbT1002Entity.setLogicalDeletedFlag(true);
            TekiyoJogaisha 更新適用除外者 = new TekiyoJogaisha(dbT1002Entity);
            manager.save適用除外者(更新適用除外者);
            TekiyoJogaisha 更新適用除外者クローン = new TekiyoJogaisha(dbT1002Entityクローン);
            manager.save適用除外者(get追加適用除外者(更新適用除外者クローン));
        }
        return 更新件数 + dbT1002EntityList.size() * 2;
    }

    private TekiyoJogaisha get追加適用除外者(TekiyoJogaisha 適用除外者) {
        TekiyoJogaisha new適用除外者 = new TekiyoJogaisha(適用除外者.get識別コード(), 適用除外者.get異動日(), 適用除外者.get枝番());
        TekiyoJogaishaBuilder builder = new適用除外者.createBuilderForEdit();
        if (適用除外者.get入所通知発行日() != null) {
            builder.set入所通知発行日(適用除外者.get入所通知発行日());
        }
        if (適用除外者.get変更通知発行日() != null) {
            builder.set変更通知発行日(適用除外者.get変更通知発行日());
        }
        if (適用除外者.get市町村コード() != null) {
            builder.set市町村コード(適用除外者.get市町村コード());
        }
        if (適用除外者.get異動事由コード() != null) {
            builder.set異動事由コード(適用除外者.get異動事由コード());
        }
        if (適用除外者.get異動日() != null) {
            builder.set異動日(適用除外者.get異動日());
        }
        if (適用除外者.get解除受付年月日() != null) {
            builder.set解除受付年月日(適用除外者.get解除受付年月日());
        }
        if (適用除外者.get解除届出年月日() != null) {
            builder.set解除届出年月日(適用除外者.get解除届出年月日());
        }
        if (適用除外者.get解除年月日() != null) {
            builder.set解除年月日(適用除外者.get解除年月日());
        }
        builder.set論理削除フラグ(適用除外者.is論理削除フラグ());
        if (適用除外者.get退所通知発行日() != null) {
            builder.set退所通知発行日(適用除外者.get退所通知発行日());
        }
        if (適用除外者.get適用受付年月日() != null) {
            builder.set適用受付年月日(適用除外者.get適用受付年月日());
        }
        if (適用除外者.get適用届出年月日() != null) {
            builder.set適用届出年月日(適用除外者.get適用届出年月日());
        }
        if (適用除外者.get適用年月日() != null) {
            builder.set適用年月日(適用除外者.get適用年月日());
        }
        if (適用除外者.get適用除外解除事由コード() != null) {
            builder.set適用除外解除事由コード(適用除外者.get適用除外解除事由コード());
        }
        if (適用除外者.get適用除外適用事由コード() != null) {
            builder.set適用除外適用事由コード(適用除外者.get適用除外適用事由コード());
        }
        return builder.build();
    }

    private boolean is年月日が一致(FlexibleDate 現在の年月日, FlexibleDate 修正後の年月日) {
        if (null == 現在の年月日) {
            return null == 修正後の年月日;
        } else {
            return 現在の年月日.equals(修正後の年月日);
        }
    }

    private boolean is適用除外適用事由コードが一致(RString 現在の適用除外適用事由コード, RString 修正後の適用除外適用事由コード) {
        if (null == 現在の適用除外適用事由コード) {
            return null == 修正後の適用除外適用事由コード;
        } else {
            return 現在の適用除外適用事由コード.equals(修正後の適用除外適用事由コード);
        }
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
                if (is日付空(nyushoYMD)) {
                    continue;
                }
                if (is日付空(infEntity.get適用日())) {
                    continue;
                }
                if (is日付空(taishoYMD)) {
                    if (is日付空(infEntity.get適用日())) {
                        continue;
                    }
                    if (is日付空(infEntity.get解除日())) {
                        count++;
                    } else if (!(infEntity.get適用日().isBefore(nyushoYMD) && infEntity.get解除日().isBeforeOrEquals(nyushoYMD))) {
                        count++;
                    }
                } else if (is日付空(infEntity.get解除日())) {
                    if (taishoYMD.isBeforeOrEquals(infEntity.get適用日())) {
                        count++;
                    }
                } else if (!(infEntity.get適用日().isBefore(nyushoYMD) && infEntity.get解除日().isBeforeOrEquals(nyushoYMD))
                        && !(taishoYMD.isBeforeOrEquals(infEntity.get適用日()) && taishoYMD.isBefore(infEntity.get解除日()))) {
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
