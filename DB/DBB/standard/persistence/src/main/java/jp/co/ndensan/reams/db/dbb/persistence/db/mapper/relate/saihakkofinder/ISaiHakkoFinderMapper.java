/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.saihakkofinder;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.saihakkofinder.SaiHakkoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RYear;

/**
 * ビジネス設計_DBBBZ51001_所得照会票一括発行のMapper
 *
 * @reamsid_L DBB-1720-030 lijunjun
 */
public interface ISaiHakkoFinderMapper {

    /**
     * 再発行対象リストを取得します。
     *
     * @param 処理年度 RYear
     * @return 再発行対象リスト
     */
    List<SaiHakkoEntity> select再発行対象(RYear 処理年度);
}
