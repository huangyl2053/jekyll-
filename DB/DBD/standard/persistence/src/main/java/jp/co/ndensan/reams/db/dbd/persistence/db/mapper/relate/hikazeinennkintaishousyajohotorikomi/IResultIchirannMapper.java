/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.hikazeinennkintaishousyajohotorikomi;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd8100201.FuicchiCsvMybatisParameter;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd8100201.GaitouIchirannCsvMybatisParameter;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd8100201.NennkinnBanngouCsvMybatisParameter;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd8100201.SeinenngappiCsvMybatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100202.temptable.HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity;

/**
 * 結果一覧CSV出力のマッパーインタフェースです。
 *
 * @reamsid_L DBD-4910-030 x_lilh
 */
public interface IResultIchirannMapper {

    /**
     * 該当一覧情報を取得します．
     *
     * @param parameter パラメター
     * @return 該当一覧情報
     */
    List<HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity> get該当一覧情報(GaitouIchirannCsvMybatisParameter parameter);

    /**
     * 不一致情報を取得します．
     *
     * @param parameter パラメター
     * @return 不一致情報
     */
    List<HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity> get不一致情報(FuicchiCsvMybatisParameter parameter);

    /**
     * 生年月日情報を取得します．
     *
     * @param parameter パラメター
     * @return 生年月日情報
     */
    List<HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity> get生年月日情報(SeinenngappiCsvMybatisParameter parameter);

    /**
     * 年金番号情報を取得します．
     *
     * @param parameter パラメター
     * @return 年金番号情報
     */
    List<HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity> get年金番号情報(NennkinnBanngouCsvMybatisParameter parameter);
}
