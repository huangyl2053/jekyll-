/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.shotokushokai;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.shotokushokai.ShotokuShokaiTaishosha;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.shotokushokai.ShotokuShokaiTaishoshaIchiranParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokai.ShotokuShokaiTaishoshaEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.shotokushokai.IShotokuShokaiMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 画面設計_DBBGM51001_所得照会状況一覧のビジネスです。<br>
 *
 * @reamsid_L DBB-1700-010 zhangrui
 */
public class ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiranManager {

    private final MapperProvider mapperProvider;
    private final RString 日付_FORMAT = new RString("yyyyMMddHHmmss");

    /**
     * 画面設計_DBBGM51001_所得照会状況一覧のコンストラクタ。
     *
     */
    public ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiranManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 画面設計_DBBGM51001_所得照会状況一覧のコンストラクタ。
     *
     * @return ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiranManager
     */
    public static ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiranManager createInstance() {
        return InstanceProvider.create(ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiranManager.class);
    }

    /**
     * 対象者一覧データを取得
     *
     * @param is住民税減免前後表示 boolean
     * @param 基準年度 RYear
     * @param 抽出期間FROM年月日 RDate
     * @param 抽出期間FROM時分秒 RTime
     * @param 抽出期間TO年月日 RDate
     * @param 抽出期間TO時分秒 RTime
     * @return ShotokuShokaiTaishoshaのList
     */
    public List<ShotokuShokaiTaishosha> get対象者一覧データ(boolean is住民税減免前後表示, RYear 基準年度,
            RDate 抽出期間FROM年月日, RTime 抽出期間FROM時分秒, RDate 抽出期間TO年月日, RTime 抽出期間TO時分秒) {
        IShotokuShokaiMapper mapper = mapperProvider.create(IShotokuShokaiMapper.class);
        RString システム日付 = YMDHMS.now().getDate().toDateString();
        RDateTime from = RDateTime.of(抽出期間FROM年月日.getYearValue(), 抽出期間FROM年月日.getMonthValue(), 抽出期間FROM年月日.getDayValue(),
                抽出期間FROM時分秒.getHour(), 抽出期間FROM時分秒.getMinute(), 抽出期間FROM時分秒.getHour());
        RDateTime to = RDateTime.of(抽出期間TO年月日.getYearValue(), 抽出期間TO年月日.getMonthValue(), 抽出期間TO年月日.getDayValue(),
                抽出期間TO時分秒.getHour(), 抽出期間TO時分秒.getMinute(), 抽出期間TO時分秒.getHour());
        ShotokuShokaiTaishoshaIchiranParameter parameter = new ShotokuShokaiTaishoshaIchiranParameter(is住民税減免前後表示,
                基準年度, from.format西暦(日付_FORMAT.toString()), to.format西暦(日付_FORMAT.toString()), システム日付);
        List<ShotokuShokaiTaishoshaEntity> list = mapper.get対象者一覧データ(parameter);
        List<ShotokuShokaiTaishosha> returnList = new ArrayList<>();
        if (null != list) {
            for (ShotokuShokaiTaishoshaEntity entity : list) {
                ShotokuShokaiTaishosha taishosha = new ShotokuShokaiTaishosha();
                taishosha.setEntity(entity);
                returnList.add(taishosha);
            }
        }
        return returnList;
    }

}
