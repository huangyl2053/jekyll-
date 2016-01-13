/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.basic.nenreitoutatsuyoteishachecklist;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatis.param.torokunenreitoutatsuyoteishacheck.NenreiToutatsuYoteishaCheckListMybatisParameter;
import jp.co.ndensan.reams.db.dba.entity.db.nenreitoutatsuyoteishachecklist.NenreiToutatsuYoteishaCheckListEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1002TekiyoJogaishaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1003TashichosonJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1009ShikakuShutokuJogaishaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.ur.urd.entity.db.basic.seikatsuhogo.UrT0508SeikatsuHogoJukyushaEntity;

/**
 *
 * 年齢到達予定者チェックリストのマッパーインタフェースです。
 */
public interface INenreiToutatsuYoteishaCheckListMapper {

    /**
     * NenreiToutatsuYoteishaCheckListEntity 登録対象者取得1。
     *
     * @param torokuParameter　torokuParameter
     * @return 年齢到達予定者チェックリスト List<NenreiToutatsuYoteishaCheckListEntity>
     */
    List<NenreiToutatsuYoteishaCheckListEntity> getTorokuNenreiToutatsuYoteishaCheckList(
            NenreiToutatsuYoteishaCheckListMybatisParameter torokuParameter);

    /**
     * NenreiToutatsuYoteishaCheckListEntity 登録対象者取得2。
     *
     * @param torokuParameter　torokuParameter
     * @return 年齢到達予定者チェックリスト List<NenreiToutatsuYoteishaCheckListEntity>
     */
    List<NenreiToutatsuYoteishaCheckListEntity> getTorokuNenreiToutatsuYoteishaCheckList2(
            NenreiToutatsuYoteishaCheckListMybatisParameter torokuParameter);

    /**
     * NenreiToutatsuYoteishaCheckListEntity 全ての対象者取得1。
     *
     * @param znebuParameter　znebuParameter
     * @return 年齢到達予定者チェックリスト List<NenreiToutatsuYoteishaCheckListEntity>
     */
    List<NenreiToutatsuYoteishaCheckListEntity> getZenbuNenreiToutatsuYoteishaCheckList(
            NenreiToutatsuYoteishaCheckListMybatisParameter znebuParameter);

    /**
     * NenreiToutatsuYoteishaCheckListEntity 全ての対象者取得2。
     *
     * @param znebuParameter znebuParameter
     * @return 年齢到達予定者チェックリスト List<NenreiToutatsuYoteishaCheckListEntity>
     */
    List<NenreiToutatsuYoteishaCheckListEntity> getZenbuNenreiToutatsuYoteishaCheckList2(
            NenreiToutatsuYoteishaCheckListMybatisParameter znebuParameter);

    /**
     * DbT1009ShikakuShutokuJogaishaEntity 資格取得除外者リスト取得。
     *
     * @return 資格取得除外者リスト List<DbT1009ShikakuShutokuJogaishaEntity>
     */
    List<DbT1009ShikakuShutokuJogaishaEntity> getShikakuShutokuJogaiList();

    /**
     * DbT1002TekiyoJogaishaEntity 適用除外者リスト取得。
     *
     * @return 適用除外者リスト List<DbT1002TekiyoJogaishaEntity>
     */
    List<DbT1002TekiyoJogaishaEntity> getTekiyoJogaiList();

    /**
     * UrT0508SeikatsuHogoJukyushaEntity 他市町村住所地特例者リスト取得取得。
     *
     * @return 他市町村住所地特例者リストList<UrT0508SeikatsuHogoJukyushaEntity>
     */
    List<DbT1003TashichosonJushochiTokureiEntity> getTashichosonJushochi();

    /**
     * UrT0508SeikatsuHogoJukyushaEntity 生活保護受給者リスト。
     *
     * @return 生活保護受給者リストList<UrT0508SeikatsuHogoJukyushaEntity>
     */
    List<UrT0508SeikatsuHogoJukyushaEntity> getSeikatsuHogojyu();

    int getInsert(DbT7022ShoriDateKanriEntity dbT7022ShoriDateKanriEntity);
}
