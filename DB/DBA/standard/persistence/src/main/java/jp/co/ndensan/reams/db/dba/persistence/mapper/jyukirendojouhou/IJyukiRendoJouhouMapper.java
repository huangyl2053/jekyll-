/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.mapper.jyukirendojouhou;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.jyukirendotorokushalistbatch.JyukiRendoTorokushaListBatchMybatisParameter;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.jyukirendotorokushalistbatch.PsmShikibetsuTaishoMybatisParameter;
import jp.co.ndensan.reams.db.dba.entity.jyukirendotorokushalistbatchentity.JyukiRendoJouhouEntity;
import jp.co.ndensan.reams.db.dba.entity.jyukirendotorokushalistbatchentity.TaJushochiTokureiShayouhouEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * 住基連動情報のマッパーインタフェースです。
 */
public interface IJyukiRendoJouhouMapper {

    /**
     * 住基連動情報リストを取得します。
     *
     * @param parameter 住基連動登録者リストのMyBatisパラメータ
     * @return List<JyukiRendoJouhouEntity>
     */
    List<JyukiRendoJouhouEntity> getHiHokenshaDaichoList(JyukiRendoTorokushaListBatchMybatisParameter parameter);

    /**
     * 他市町村住所地特例者を取得します(コード種別：0008)。
     *
     * @param parameter 住基連動登録者リストのMyBatisパラメータ
     * @return List<TaJushochiTokureiShayouhouEntity>
     */
    List<TaJushochiTokureiShayouhouEntity> getTaJushochiTokureiShaKanriList_0008Code(
            JyukiRendoTorokushaListBatchMybatisParameter parameter);

    /**
     * 介護保険施設入退所情報を取得します(台帳種別：2)。
     *
     * @param parameter 住基連動登録者リストのMyBatisパラメータ
     * @return List<TaJushochiTokureiShayouhouEntity>
     */
    List<TaJushochiTokureiShayouhouEntity> getShisetsuNyutaisho_2Code(
            JyukiRendoTorokushaListBatchMybatisParameter parameter);

    /**
     * 他市町村住所地特例者を取得します(コード種別：0011)。
     *
     * @param parameter 住基連動登録者リストのMyBatisパラメータ
     * @return List<TaJushochiTokureiShayouhouEntity>
     */
    List<TaJushochiTokureiShayouhouEntity> getTaJushochiTokureiShaKanriList_0011Code(
            JyukiRendoTorokushaListBatchMybatisParameter parameter);

    /**
     * 適用除外者を取得します(コード種別：0009)。
     *
     * @param parameter 住基連動登録者リストのMyBatisパラメータ
     * @return List<TaJushochiTokureiShayouhouEntity>
     */
    List<TaJushochiTokureiShayouhouEntity> getTekiyoJogaishaDaichoList_0009Code(
            JyukiRendoTorokushaListBatchMybatisParameter parameter);

    /**
     * 介護保険施設入退所情報を取得します(台帳種別：3)。
     *
     * @param parameter 住基連動登録者リストのMyBatisパラメータ
     * @return List<TaJushochiTokureiShayouhouEntity>
     */
    List<TaJushochiTokureiShayouhouEntity> getShisetsuNyutaisho_3Code(
            JyukiRendoTorokushaListBatchMybatisParameter parameter);

    /**
     * 適用除外者を取得します(コード種別：0012)。
     *
     * @param parameter 住基連動登録者リストのMyBatisパラメータ
     * @return List<TaJushochiTokureiShayouhouEntity>
     */
    List<TaJushochiTokureiShayouhouEntity> getTekiyoJogaishaDaichoList_0012Code(
            JyukiRendoTorokushaListBatchMybatisParameter parameter);

    /**
     * 処理日付管理マスタに登録します。
     *
     * @param entity 処理日付管理マスタEntity
     * @return 登録件数
     */
    int insertShoriDateKanri(DbT7022ShoriDateKanriEntity entity);

    /**
     * 処理日付管理マスタに更新します。
     *
     * @param entity 処理日付管理マスタEntity
     * @return 更新件数
     */
    int updateShoriDateKanri(DbT7022ShoriDateKanriEntity entity);

    /**
     * 宛名識別対象を取得します。
     *
     * @param parameter 宛名識別対象PSM用パラメータ
     * @return UaFt200FindShikibetsuTaishoEntity
     */
    UaFt200FindShikibetsuTaishoEntity getPsmShikibetsuTaisho(PsmShikibetsuTaishoMybatisParameter parameter);
}
