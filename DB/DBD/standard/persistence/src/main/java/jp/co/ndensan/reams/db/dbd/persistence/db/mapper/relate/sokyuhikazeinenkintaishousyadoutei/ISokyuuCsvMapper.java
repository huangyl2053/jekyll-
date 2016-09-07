/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.sokyuhikazeinenkintaishousyadoutei;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd8100203.SokyuuFuicchiCsvMybatisParameter;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd8100203.SokyuuGaitouIchirannCsvMybatisParameter;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd8100203.SokyuuSeinenngappiCsvMybatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100202.temptable.HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity;

/**
 * 結果一覧CSV出力のマッパーインタフェースです。
 *
 * @reamsid_L DBD-4910-050 x_lilh
 */
public interface ISokyuuCsvMapper {

    /**
     * 遡及該当一覧情報を取得します．
     *
     * @param parameter パラメター
     * @return 遡及該当一覧情報
     */
    List<HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity> get遡及該当一覧情報(SokyuuGaitouIchirannCsvMybatisParameter parameter);

    /**
     * 遡及不一致情報を取得します．
     *
     * @param parameter パラメター
     * @return 遡及不一致情報
     */
    List<HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity> get遡及不一致情報(SokyuuFuicchiCsvMybatisParameter parameter);

    /**
     * 生年月日情報を取得します．
     *
     * @param parameter パラメター
     * @return 生年月日情報
     */
    List<HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity> get生年月日情報(SokyuuSeinenngappiCsvMybatisParameter parameter);
}
