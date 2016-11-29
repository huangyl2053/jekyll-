
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchosoufujohosakusei;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchotaishoshaichiransakusei.UpdateShorikanriMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchosoufujohosakusei.TokuChoSoufuJohoSakuseiEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT1704KaigoTokuchoTorikomiRirekiEntity;

/**
 * DBB-1830-040バッチ設計_DBBBT84001_特徴制度間Ｉ／ＦのMapperクラスです。
 *
 * @reamsid_L DBB-1830-040 liuyang
 */
public interface ITokuChoSoufuJohoSakuseiMapper {

    /**
     * 介護特別徴収情報取込履歴追加する。
     *
     * @param entity UeT1704KaigoTokuchoTorikomiRirekiEntity
     */
    void insertTorikomiRireki(UeT1704KaigoTokuchoTorikomiRirekiEntity entity);

    /**
     * getDbT7022Entitiesのメソッドです。
     *
     * @param param UpdateShorikanriMyBatisParameter
     * @return List<DbT7022ShoriDateKanriEntity>
     */
    List<DbT7022ShoriDateKanriEntity> getDbT7022Entities(UpdateShorikanriMyBatisParameter param);

    /**
     * 処理日付管理マスタ更新のメソッドです。
     *
     * @param parameter UpdateShorikanriMyBatisParameter
     */
    void updateShoriDateKanri(UpdateShorikanriMyBatisParameter parameter);

    /**
     * 介護特別徴収情報取込履歴の最大の連番を取得する。
     *
     * @return Integer
     */
    Integer selectMaxRenbanUeT1704();

    /**
     * 特徴開始月が10月 or 12月 or 2月の場合<br/>
     * 取得された年金特徴回付情報を元に最新の被保険者情報、最新の賦課情報、最新の徴収方法情報を取得する<br/>
     *
     * @return List<ResultEntity>
     */
    List<TokuChoSoufuJohoSakuseiEntity> selectUe10122T0511NenkinTokuchoKaifuJohotemp();

    /**
     * 特徴開始月が翌4月 or 翌6月の場合<br/>
     * 取得された年金特徴回付情報を元に最新の被保険者情報、最新の賦課情報、最新の徴収方法情報を取得する<br/>
     *
     * @return List<ResultEntity>
     */
    List<TokuChoSoufuJohoSakuseiEntity> select46UeT0511NenkinTokuchoKaifuJohotemp();

    /**
     * 特徴開始月が8月の場合<br/>
     * 取得された年金特徴回付情報を元に最新の被保険者情報、最新の賦課情報、最新の徴収方法情報を取得する<br/>
     *
     * @return List<ResultEntity>
     */
    List<TokuChoSoufuJohoSakuseiEntity> select8UeT0511NenkinTokuchoKaifuJohotemp();

    /**
     * 介護保険年金特徴対象者情報(550バイト)を取得する
     *
     * @return List<ResultEntity>
     */
    List<UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity> selectUeT0515KaigohokenNenkinTokuchoTaishoshaJoho550tempAll();
}
