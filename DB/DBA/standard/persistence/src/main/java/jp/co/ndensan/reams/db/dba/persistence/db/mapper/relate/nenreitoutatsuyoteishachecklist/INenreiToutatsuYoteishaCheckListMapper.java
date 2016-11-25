/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.nenreitoutatsuyoteishachecklist;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.torokunenreitoutatsuyoteishacheck.NenreiToutatsuYoteishaCheckListMybatisParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.nenreitoutatsuyoteishachecklist.NenreiToutatsuYoteishaCheckListEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1002TekiyoJogaishaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1003TashichosonJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1009ShikakuShutokuJogaishaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1010TennyushutsuHoryuTaishoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.ur.urd.entity.db.basic.seikatsuhogo.UrT0508SeikatsuHogoJukyushaEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 *
 * 年齢到達予定者チェックリストのマッパーインタフェースです。
 *
 * @reamsid_L DBA-0580-020 yaodongsheng
 */
public interface INenreiToutatsuYoteishaCheckListMapper {

    /**
     * NenreiToutatsuYoteishaCheckListEntity 登録対象者取得1。
     *
     * @param torokuParameter torokuParameter
     * @return 年齢到達予定者チェックリスト List<NenreiToutatsuYoteishaCheckListEntity>
     */
    List<NenreiToutatsuYoteishaCheckListEntity> getTorokuNenreiToutatsuYoteishaCheckList(
            NenreiToutatsuYoteishaCheckListMybatisParameter torokuParameter);

    /**
     * NenreiToutatsuYoteishaCheckListEntity 登録対象者取得2。
     *
     * @param torokuParameter torokuParameter
     * @return 年齢到達予定者チェックリスト List<NenreiToutatsuYoteishaCheckListEntity>
     */
    List<NenreiToutatsuYoteishaCheckListEntity> getTorokuNenreiToutatsuYoteishaCheckList2(
            NenreiToutatsuYoteishaCheckListMybatisParameter torokuParameter);

    /**
     * NenreiToutatsuYoteishaCheckListEntity 全ての対象者取得1。
     *
     * @param zenbuParameter zenbuParameter
     * @return 年齢到達予定者チェックリスト List<NenreiToutatsuYoteishaCheckListEntity>
     */
    List<NenreiToutatsuYoteishaCheckListEntity> getZenbuNenreiToutatsuYoteishaCheckList(
            NenreiToutatsuYoteishaCheckListMybatisParameter zenbuParameter);

    /**
     * NenreiToutatsuYoteishaCheckListEntity 全ての対象者取得2。
     *
     * @param zenbuParameter zenbuParameter
     * @return 年齢到達予定者チェックリスト List<NenreiToutatsuYoteishaCheckListEntity>
     */
    List<NenreiToutatsuYoteishaCheckListEntity> getZenbuNenreiToutatsuYoteishaCheckList2(
            NenreiToutatsuYoteishaCheckListMybatisParameter zenbuParameter);

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
     * UrT0508SeikatsuHogoJukyushaEntity 他市町村住所地特例者リスト取得。
     *
     * @return 他市町村住所地特例者リストList<UrT0508SeikatsuHogoJukyushaEntity>
     */
    List<DbT1003TashichosonJushochiTokureiEntity> getTashichosonJushochi();

    /**
     * DbT1010TennyushutsuHoryuTaishoshaEntity 転入保留対象者リスト取得。
     *
     * @return 転入保留対象者リスト取得List<DbT1010TennyushutsuHoryuTaishoshaEntity>
     */
    List<DbT1010TennyushutsuHoryuTaishoshaEntity> getTennyushutsuHoryuTaishosha();

    /**
     * UrT0508SeikatsuHogoJukyushaEntity 生活保護受給者リスト。
     *
     * @param shikibetsuCode 識別コード
     * @return 生活保護受給者リストList<UrT0508SeikatsuHogoJukyushaEntity>
     */
    List<UrT0508SeikatsuHogoJukyushaEntity> getSeikatsuHogojyu(ShikibetsuCode shikibetsuCode);

    /**
     * 処理日付管理マスタのデータ挿入
     *
     * @param dbT7022ShoriDateKanriEntity dbT7022ShoriDateKanriEntity
     * @return 挿入件数
     */
    int getInsert(DbT7022ShoriDateKanriEntity dbT7022ShoriDateKanriEntity);
}
