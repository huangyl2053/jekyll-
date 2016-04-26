/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.tashichosonjushochitokureisyaidoteisei;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.core.tashichosonjushochitokureisyaidoteisei.TaShichosonJushochiTokureisyaIdoTeiseiParamter;
import jp.co.ndensan.reams.db.dba.definition.core.tashichosonjushochitokureisyaidoteisei.TekiyouJouhou;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1004ShisetsuNyutaishoDac;
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

    private final DbT1004ShisetsuNyutaishoDac dac;

    /**
     * コンストラクタです。
     */
    public TaShichosonJushochiTokureisyaIdoTeisei() {
        dac = InstanceProvider.create(DbT1004ShisetsuNyutaishoDac.class);
    }

    TaShichosonJushochiTokureisyaIdoTeisei(DbT1004ShisetsuNyutaishoDac dac) {
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
        List<DbT1004ShisetsuNyutaishoEntity> dbT1004List = dac.get入退所日(paramter.get識別コード(), new RString("2"));
        for (DbT1004ShisetsuNyutaishoEntity dbT1004 : dbT1004List) {
            int count = 0;
            if (isNullOrEmpty(dbT1004.getTaishoYMD())) {
                continue;
            }
            for (TekiyouJouhou tekiyou : paramter.get適用情報グリッド()) {
                if (解除日_判断(dbT1004.getNyushoYMD(), new FlexibleDate(tekiyou.get解除日()))
                        && 適用日_判断(dbT1004.getTaishoYMD(), new FlexibleDate(tekiyou.get適用日()))) {
                    count++;
                }
            }
            if (count == 0) {
                throw new ApplicationException(UrErrorMessages.期間が重複.getMessage());
            }
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
}
