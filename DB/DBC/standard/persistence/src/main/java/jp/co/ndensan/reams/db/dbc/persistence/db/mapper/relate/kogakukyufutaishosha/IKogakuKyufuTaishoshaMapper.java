/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakukyufutaishosha;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0002KokuhorenTorikomiErrorTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kogakukyufutaishosha.DbWT3054KogakuKyufuTaishoshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3054KogakuKyufuTaishoshaMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3055KogakuKyufuTaishoshaGokeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufutaishosha.KyuufuTaishoshaHihokenshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufutaishosha.RirikiNoKanrenEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufutaishosha.SaishoriFukaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufutaishosha.SedaiShuuyakuBangoKanrenEntity;

/**
 * 高額介護サービス費給付対象者取込みのバッチのDB操作です。
 *
 * @reamsid_L DBC-0980-360 chenaoqi
 */
public interface IKogakuKyufuTaishoshaMapper {

    /**
     * 高額介護サービス費給付対象者一時TBLを作成する。
     */
    void create高額介護サービス費給付対象者一時TBL();

    /**
     * 高額介護サービス費給付対象者一時TBLに登録する。
     *
     * @param entity DbWT3054KogakuKyufuTaishoshaTempEntity
     * @return int 登録成功の件数
     */
    int 高額介護サービス費給付対象者一時TBLに登録(DbWT3054KogakuKyufuTaishoshaTempEntity entity);

    /**
     * 被保険者一時TBLに登録する。
     *
     * @param entity DbWT0001HihokenshaTempEntity
     * @return int 登録成功の件数
     */
    int 被保険者一時TBLに登録(DbWT0001HihokenshaTempEntity entity);

    /**
     * 処理結果リスト一時TBLに登録する。
     *
     * @param entity DbWT0002KokuhorenTorikomiErrorTempEntity
     * @return int 登録成功の件数
     */
    int 処理結果リスト一時TBLに登録(DbWT0002KokuhorenTorikomiErrorTempEntity entity);

    /**
     * 取得したの再処理不可データは、再処理不可フラグ＝TRUEにする。
     *
     * @param entity DbWT3054KogakuKyufuTaishoshaTempEntity
     */
    void 高額介護サービス費給付対象者一時TBLに再処理不可登録(DbWT3054KogakuKyufuTaishoshaTempEntity entity);

    /**
     * 登録済の該当被保険者の件数を取ります。
     *
     * @param entity DbWT0002KokuhorenTorikomiErrorTempEntity
     * @return int もう登録済の該当被保険者の件数
     */
    int select被保険者の件数(DbWT0001HihokenshaTempEntity entity);

    /**
     * 高額介護サービス費給付対象者一時TBLの全件を取ります。
     *
     * @return List<Map<String,Object>>
     */
    List<Map<String, Object>> select高額介護サービス費給付対象者一時TBLの全件();

    /**
     * 被保険者一時TBLと共同処理用受給者異動高額送付TBLからデータを取ります。
     *
     * @return List<SedaiShuuyakuBangoKanrenEntity>
     */
    List<SedaiShuuyakuBangoKanrenEntity> select世帯集約番号関連リスト();

    /**
     * 世帯集約番号の登録。
     *
     * @param entity DbWT0001HihokenshaTempEntity
     * @return int 登録成功の件数
     */
    int do世帯集約番号の登録(DbWT0001HihokenshaTempEntity entity);

    /**
     * 高額介護サービス費支給申請データが存在しない、高額介護サービス費給付対象者合計データを取得する。<br>
     * ⇒　再処理可能
     *
     * @param parameter Map<String,Object>
     * @return List<DbT3055KogakuKyufuTaishoshaGokeiEntity>
     */
    List<DbT3055KogakuKyufuTaishoshaGokeiEntity> 合計再処理対象データの取得(Map<String, Object> parameter);

    /**
     * 高額介護サービス費支給申請データが存在しない、高額介護サービス費給付対象者明細データを取得する。<br>
     * ⇒　再処理可能
     *
     * @param parameter Map<String,Object>
     * @return List<DbT3054KogakuKyufuTaishoshaMeisaiEntity>
     */
    List<DbT3054KogakuKyufuTaishoshaMeisaiEntity> 明細再処理対象データの取得(Map<String, Object> parameter);

    /**
     * 削除されなかった再処理対象の高額介護サービス費給付対象者合計データを取得する。
     *
     * @param parameter Map<String,Object>
     * @return List<SaishoriFukaEntity>
     */
    List<SaishoriFukaEntity> 再処理不可データの取得(Map<String, Object> parameter);

    /**
     * 一時TBLと被保険者番号、サービス提供年月が同じ高額介護サービス費給付対象者合計データがあれば、<br>
     * 最大履歴番号を取得する。
     *
     * @return List<RirikiNoKanrenEntity>
     */
    List<RirikiNoKanrenEntity> select履歴番号確認データ();

    /**
     * マスター登録用データを取得する。
     *
     * @param parameter Map<String,Object>
     * @return List<KyuufuTaishoshaHihokenshaEntity>
     */
    List<KyuufuTaishoshaHihokenshaEntity> selectマスタ登録用データ(Map<String, Object> parameter);

    /**
     * 帳票出力対象データを取得する。
     *
     * @param parameter Map<String, Object>
     * @return List<KyuufuTaishoshaHihokenshaEntity>
     */
    List<KyuufuTaishoshaHihokenshaEntity> select帳票出力対象データ(Map<String, Object> parameter);

}
