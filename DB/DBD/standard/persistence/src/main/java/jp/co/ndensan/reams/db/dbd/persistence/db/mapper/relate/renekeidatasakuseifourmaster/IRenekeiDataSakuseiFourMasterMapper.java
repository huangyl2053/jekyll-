/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.renekeidatasakuseifourmaster;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd519002.RenekeiDataSakuseiMyBatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5190001.DbT7204YokaigoNinteiGaibuDataOutputHistoryEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd519002.ChosainEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd519002.ChosaitakusakiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd519002.ShujiiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd519002.ShujiiIryokikanEntity;

/**
 * 要介護認定関連データ作成 Mapper
 *
 * @reamsid_L DBD-2100-020 liwul
 */
public interface IRenekeiDataSakuseiFourMasterMapper {

    /**
     * 認定調査員情報ＩＦのcsv情報を取得する
     *
     * @param parameter Mybatisパラメター
     * @return 認定調査員情報ＩＦのcsv情報
     */
    List<ChosainEntity> get認定調査員情報ＩＦのcsv情報(RenekeiDataSakuseiMyBatisParameter parameter);

    /**
     * 調査委託先情報ＩＦのcsv情報を取得する
     *
     * @param parameter Mybatisパラメター
     * @return 調査委託先情報ＩＦのcsv情報
     */
    List<ChosaitakusakiEntity> get調査委託先情報ＩＦのcsv情報(RenekeiDataSakuseiMyBatisParameter parameter);

    /**
     * 主治医医療機関情報ＩＦのcsv情報を取得する
     *
     * @param paramter Mybatisパラメター
     * @return 主治医医療機関情報ＩＦのcsv情報
     */
    List<ShujiiIryokikanEntity> get主治医医療機関情報ＩＦのcsv情報(RenekeiDataSakuseiMyBatisParameter paramter);

    /**
     * 主治医情報情報ＩＦのcsv情報を取得する
     *
     * @param paramter Mybatisパラメター
     * @return 主治医情報情報ＩＦのcsv情報
     */
    List<ShujiiEntity> get主治医情報情報ＩＦのcsv情報(RenekeiDataSakuseiMyBatisParameter paramter);

    /**
     * 要介護認定外部データ出力履歴を取得する
     *
     * @param paramter Mybatisパラメター
     * @return 要介護認定外部データ出力履歴
     */
    List<DbT7204YokaigoNinteiGaibuDataOutputHistoryEntity> get要介護認定外部データ出力履歴(RenekeiDataSakuseiMyBatisParameter paramter);
}
