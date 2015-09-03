/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbu.business.core.basic.JigyoHokokuTokeiData;
import jp.co.ndensan.reams.db.dbu.entity.basic.DbT7021JigyoHokokuTokeiDataEntity;
import jp.co.ndensan.reams.db.dbu.persistence.basic.DbT7021JigyoHokokuTokeiDataDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 事業報告統計データを管理するクラスです。
 */
public class JigyoHokokuTokeiDataManager {

    private final DbT7021JigyoHokokuTokeiDataDac dac;

    /**
     * コンストラクタです。
     */
    public JigyoHokokuTokeiDataManager() {
        dac = InstanceProvider.create(DbT7021JigyoHokokuTokeiDataDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7021JigyoHokokuTokeiDataDac}
     */
    JigyoHokokuTokeiDataManager(DbT7021JigyoHokokuTokeiDataDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する事業報告統計データを返します。
     *
     * @param 報告年 HokokuYSeireki
     * @param 報告月 HokokuM
     * @param 集計対象年 ShukeiTaishoYSeireki
     * @param 集計対象月 ShukeiTaishoM
     * @param 統計対象区分 ToukeiTaishoKubun
     * @param 市町村コード ShichosonCode
     * @param 表番号 HyoNo
     * @param 集計番号 ShukeiNo
     * @param 集計単位 ShukeiTani
     * @param 縦番号 TateNo
     * @param 横番号 YokoNo
     * @return JigyoHokokuTokeiData
     */
    @Transaction
    public JigyoHokokuTokeiData get事業報告統計データ(
            FlexibleYear 報告年,
            RString 報告月,
            FlexibleYear 集計対象年,
            RString 集計対象月,
            RString 統計対象区分,
            LasdecCode 市町村コード,
            Code 表番号,
            Code 集計番号,
            Code 集計単位,
            Decimal 縦番号,
            Decimal 横番号) {
        requireNonNull(報告年, UrSystemErrorMessages.値がnull.getReplacedMessage("報告年"));
        requireNonNull(報告月, UrSystemErrorMessages.値がnull.getReplacedMessage("報告月"));
        requireNonNull(集計対象年, UrSystemErrorMessages.値がnull.getReplacedMessage("集計対象年"));
        requireNonNull(集計対象月, UrSystemErrorMessages.値がnull.getReplacedMessage("集計対象月"));
        requireNonNull(統計対象区分, UrSystemErrorMessages.値がnull.getReplacedMessage("統計対象区分"));
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(表番号, UrSystemErrorMessages.値がnull.getReplacedMessage("表番号"));
        requireNonNull(集計番号, UrSystemErrorMessages.値がnull.getReplacedMessage("集計番号"));
        requireNonNull(集計単位, UrSystemErrorMessages.値がnull.getReplacedMessage("集計単位"));
        requireNonNull(縦番号, UrSystemErrorMessages.値がnull.getReplacedMessage("縦番号"));
        requireNonNull(横番号, UrSystemErrorMessages.値がnull.getReplacedMessage("横番号"));

        DbT7021JigyoHokokuTokeiDataEntity entity = dac.selectByKey(
                報告年,
                報告月,
                集計対象年,
                集計対象月,
                統計対象区分,
                市町村コード,
                表番号,
                集計番号,
                集計単位,
                縦番号,
                横番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new JigyoHokokuTokeiData(entity);
    }

    /**
     * 事業報告統計データを全件返します。
     *
     * @return List<JigyoHokokuTokeiData>
     */
    @Transaction
    public List<JigyoHokokuTokeiData> get事業報告統計データ一覧() {
        List<JigyoHokokuTokeiData> businessList = new ArrayList<>();

        for (DbT7021JigyoHokokuTokeiDataEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new JigyoHokokuTokeiData(entity));
        }

        return businessList;
    }

    /**
     * 事業報告統計データ{@link JigyoHokokuTokeiData}を保存します。
     *
     * @param 事業報告統計データ {@link JigyoHokokuTokeiData}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save事業報告統計データ(JigyoHokokuTokeiData 事業報告統計データ) {
        requireNonNull(事業報告統計データ, UrSystemErrorMessages.値がnull.getReplacedMessage("事業報告統計データ"));
        if (!事業報告統計データ.hasChanged()) {
            return false;
        }
        return 1 == dac.save(事業報告統計データ.toEntity());
    }
}
