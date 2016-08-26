/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.futanngenndogakuninntei;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd1200902.ShakaiFukushiHoujinnKeigenListMybatisParameter;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd1200902.ShakaiFukushiHoujinnKeigenParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd1200902.ShakaiFukushiHoujinnKeigenListEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd1200902.temptable.ShafukuKeigenKetteiTempTableEntity;

/**
 * 社会福祉法人軽減確認証・決定通知書発行一覧表発行のMapperクラスです。
 *
 * @reamsid_L DBD-3981-050 x_lilh
 */
public interface IShakaiFukushiHoujinnKeigenListMapper {

    /**
     * 社会福祉法人軽減確認証_決定通知書発行一覧表発行情報を取得します．
     *
     * @param parameter パラメター
     * @return 社会福祉法人軽減確認証_決定通知書発行一覧表発行情報
     */
    List<ShakaiFukushiHoujinnKeigenListEntity> get社会福祉法人軽減確認証_決定通知書発行一覧表発行情報(ShakaiFukushiHoujinnKeigenListMybatisParameter parameter);

    /**
     * 社会福祉法人等軽減の通知書発行の一時テーブルEntityを取得します．
     *
     * @param parameter ShakaiFukushiHoujinnKeigenParameter
     * @return ShafukuKeigenKetteiTempTableEntity
     */
    ShafukuKeigenKetteiTempTableEntity get社会福祉法人等軽減の通知書発行の一時テーブルEntity(ShakaiFukushiHoujinnKeigenParameter parameter);
}
