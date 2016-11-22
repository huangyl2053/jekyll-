/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.yoshikibetsurenkeijoho;

import java.util.LinkedHashMap;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Width;

/**
 * 集計年月取得クラスです。
 *
 * @reamsid_L DBU-4050-010 suguangjun
 */
public class JigyoHokokuTokei {

    private final DbT7021JigyoHokokuTokeiDataEntity entity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7021JigyoHokokuTokeiDataEntity}より{@link JigyoHokokuTokei}を生成します。
     *
     * @param entity DBより取得した{@link DbT7021JigyoHokokuTokeiDataEntity}
     */
    public JigyoHokokuTokei(DbT7021JigyoHokokuTokeiDataEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("集計年月"));
    }

    /**
     * 過去報告年月を返します。
     *
     * @return 過去報告年月
     */
    public LinkedHashMap<RString, RString> get過去報告年月() {
        LinkedHashMap<RString, RString> linkedHashMap = new LinkedHashMap();
        FlexibleYearMonth yearMonth = new FlexibleYearMonth(entity.getHokokuYSeireki().toString() + entity.getHokokuM().toString());
        if (yearMonth.isValid()) {
            RString hashMapValue = yearMonth.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                    fillType(FillType.ZERO).width(Width.HALF).toDateString();
            RString hashMapKey = new RString(entity.getHokokuYSeireki().toString() + entity.getHokokuM().toString());
            linkedHashMap.put(hashMapKey, hashMapValue);
        }

        return linkedHashMap;

    }

    /**
     * 集計年月を返します。
     *
     * @return 集計年月
     */
    public FlexibleYearMonth get集計年月() {
        return new FlexibleYearMonth(entity.getShukeiTaishoYSeireki().toString() + entity.getShukeiTaishoM().toString());
    }
}
