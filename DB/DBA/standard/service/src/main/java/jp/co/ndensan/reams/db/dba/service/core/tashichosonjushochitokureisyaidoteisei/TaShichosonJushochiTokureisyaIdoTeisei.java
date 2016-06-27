/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.tashichosonjushochitokureisyaidoteisei;

import jp.co.ndensan.reams.db.dba.definition.core.tashichosonjushochitokureisyaidoteisei.ShisetsuNyutaishoData;
import jp.co.ndensan.reams.db.dba.definition.core.tashichosonjushochitokureisyaidoteisei.TaShichosonJushochiTokureisyaIdoTeiseiParamter;
import jp.co.ndensan.reams.db.dba.definition.core.tashichosonjushochitokureisyaidoteisei.TekiyouJouhou;
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
}
