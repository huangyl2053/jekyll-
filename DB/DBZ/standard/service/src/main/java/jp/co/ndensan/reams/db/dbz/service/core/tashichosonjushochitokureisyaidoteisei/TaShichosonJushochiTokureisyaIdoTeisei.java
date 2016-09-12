/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.tashichosonjushochitokureisyaidoteisei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.TashichosonJushochiTokurei;
import jp.co.ndensan.reams.db.dbz.definition.core.tashichosonjushochitokureisyaidoteisei.ShisetsuNyutaishoData;
import jp.co.ndensan.reams.db.dbz.definition.core.tashichosonjushochitokureisyaidoteisei.TaShichosonJushochiTokureisyaIdoTeiseiParamter;
import jp.co.ndensan.reams.db.dbz.definition.core.tashichosonjushochitokureisyaidoteisei.TekiyouJouhou;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1003TashichosonJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1003TashichosonJushochiTokureiDac;
import jp.co.ndensan.reams.db.dbz.service.core.basic.TashichosonJushochiTokureiManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 他市町村住所地特例者異動の訂正のクラスです。
 *
 * @reamsid_L DBA-0401-010 dongyabin
 */
public class TaShichosonJushochiTokureisyaIdoTeisei {

    private final DbT1003TashichosonJushochiTokureiDac dac;

    /**
     * コンストラクタです。
     */
    public TaShichosonJushochiTokureisyaIdoTeisei() {
        dac = InstanceProvider.create(DbT1003TashichosonJushochiTokureiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT1003TashichosonJushochiTokureiDac}
     */
    TaShichosonJushochiTokureisyaIdoTeisei(DbT1003TashichosonJushochiTokureiDac dac) {
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TaShichosonJushochiTokureisyaIdoTeisei}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link TaShichosonJushochiTokureisyaIdoTeisei}のインスタンス
     */
    public static TaShichosonJushochiTokureisyaIdoTeisei createInstance() {
        return InstanceProvider.create(TaShichosonJushochiTokureisyaIdoTeisei.class);
    }

    /**
     * 適用状態のチェック処理します。
     *
     * @param paramter 他市町村住所地特例者異動の訂正のパラメータ
     */
    public void is適用状態のチェック(TaShichosonJushochiTokureisyaIdoTeiseiParamter paramter) {
        for (ShisetsuNyutaishoData dbT1004 : paramter.get入退所データリスト()) {
            int count = 0;
            if (isNullOrEmpty(dbT1004.get退所日())) {
                continue;
            }
            for (TekiyouJouhou tekiyou : paramter.get適用情報グリッド()) {
                if (解除日_判断(dbT1004.get入所日(), new FlexibleDate(tekiyou.get解除日()))
                        && 適用日_判断(dbT1004.get退所日(), new FlexibleDate(tekiyou.get適用日()))) {
                    count++;
                }
            }
            if (count == 0) {
                throw new ApplicationException(UrErrorMessages.期間が不正.getMessage());
            }
        }
        for (TekiyouJouhou tekiyou : paramter.get適用情報グリッド()) {
            int count = 0;
            for (ShisetsuNyutaishoData dbT1004 : paramter.get入退所データリスト()) {
                if (rStringTOFlexStart(tekiyou.get適用日()).isBeforeOrEquals(dbT1004.get退所日())
                        && dbT1004.get入所日().isBeforeOrEquals(rStringTOFlexEnd(tekiyou.get解除日()))) {
                    count++;
                }
            }
            if (count == 0) {
                throw new ApplicationException(UrErrorMessages.期間が不正.getMessage());
            }
        }
    }

    /**
     * 訂正時の更新処理です。
     *
     * @param 現在の他特の情報 現在の他特の情報
     * @param 修正後の他特の情報 修正後の他特の情報
     * @return 更新件数
     */
    public int save異動訂正(TashichosonJushochiTokurei 現在の他特の情報, TashichosonJushochiTokurei 修正後の他特の情報) {
        return 異動訂正(現在の他特の情報, 修正後の他特の情報);
    }

    private int 異動訂正(TashichosonJushochiTokurei 現在の他特の情報, TashichosonJushochiTokurei 修正後の他特の情報) {
        int 更新件数 = 0;
        if (現在の他特の情報 == null || 修正後の他特の情報 == null) {
            return 更新件数;
        }
        if (現在の他特の情報.get異動日().equals(修正後の他特の情報.get異動日())) {
            if (getService().save他市町村住所地特例(現在の他特の情報.deleted())) {
                更新件数++;
            }
            int tem = Integer.parseInt(現在の他特の情報.get枝番().toString()) + 1;
            修正後の他特の情報 = 修正後の他特の情報.createBuilderForEdit().set枝番(new RString(tem)).build();
            if (getService().save他市町村住所地特例(修正後の他特の情報)) {
                更新件数++;
            }
        } else {
            if (getService().save他市町村住所地特例(現在の他特の情報.deleted())) {
                更新件数++;
            }
            if (getService().save他市町村住所地特例(修正後の他特の情報)) {
                更新件数++;
            }
        }

        if (現在の他特の情報.get適用届出年月日() == null || 現在の他特の情報.get他市町村住所地特例適用事由コード() == null) {
            return 更新件数;
        }
        FlexibleDate 検索用適用年月日 = 現在の他特の情報.get適用年月日();
        List<DbT1003TashichosonJushochiTokureiEntity> クローンList = new ArrayList<>();
        if (!現在の他特の情報.get適用年月日().equals(修正後の他特の情報.get適用年月日())
                || !現在の他特の情報.get適用届出年月日().equals(修正後の他特の情報.get適用届出年月日())
                || !現在の他特の情報.get他市町村住所地特例適用事由コード().equals(修正後の他特の情報.get他市町村住所地特例適用事由コード())) {
            クローンList = dac.get訂正対象の履歴(現在の他特の情報.get識別コード(), 検索用適用年月日);
        }
        for (DbT1003TashichosonJushochiTokureiEntity entity : クローンList) {
            entity.setLogicalDeletedFlag(true);
            dac.save(entity);
            if (entity.getIdoYMD().equals(entity.getTekiyoYMD())) {
                entity.setIdoYMD(修正後の他特の情報.get適用年月日());
                entity.setIdoJiyuCode(修正後の他特の情報.get異動事由コード());
                entity.setTekiyoYMD(修正後の他特の情報.get適用年月日());
                entity.setTekiyoTodokedeYMD(修正後の他特の情報.get適用届出年月日());
                entity.setTekiyoJiyuCode(修正後の他特の情報.get他市町村住所地特例適用事由コード());
                entity.setLogicalDeletedFlag(false);
                entity.setEdaNo(new RString(1));
                dac.save(entity);
            } else {
                entity.setTekiyoYMD(修正後の他特の情報.get適用年月日());
                entity.setTekiyoTodokedeYMD(修正後の他特の情報.get適用届出年月日());
                entity.setTekiyoJiyuCode(修正後の他特の情報.get他市町村住所地特例適用事由コード());
                entity.setLogicalDeletedFlag(false);
                int 枝番Tmp = Integer.parseInt(entity.getEdaNo().toString()) + 1;
                entity.setEdaNo(new RString(枝番Tmp));
                dac.save(entity);
            }
        }
        更新件数 += (クローンList.size() + クローンList.size());
        return 更新件数;
    }

    private FlexibleDate rStringTOFlexStart(RString date) {
        if (!RString.isNullOrEmpty(date)) {
            return new FlexibleDate(date);
        } else {
            return FlexibleDate.MIN;
        }
    }

    private FlexibleDate rStringTOFlexEnd(RString date) {
        if (!RString.isNullOrEmpty(date)) {
            return new FlexibleDate(date);
        } else {
            return FlexibleDate.MAX;
        }
    }

    private boolean isNullOrEmpty(FlexibleDate date) {
        return date == null || date.isEmpty();
    }

    private boolean 適用日_判断(FlexibleDate taishoYMD, FlexibleDate 適用日) {
        return 適用日.isBeforeOrEquals(taishoYMD);
    }

    private boolean 解除日_判断(FlexibleDate nyushoYMD, FlexibleDate 解除日) {
        return nyushoYMD.isBeforeOrEquals(解除日);
    }

    private TashichosonJushochiTokureiManager getService() {
        return TashichosonJushochiTokureiManager.createInstance();
    }
}
