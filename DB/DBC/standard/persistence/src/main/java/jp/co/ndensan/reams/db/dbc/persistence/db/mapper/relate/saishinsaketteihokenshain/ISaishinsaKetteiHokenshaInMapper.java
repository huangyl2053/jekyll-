/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.saishinsaketteihokenshain;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.saishinsaketteihokenshain.SaishinsaKetteiHokenshaInParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsaketteihokenshain.SaishinsaKetteiHokenshaInGokeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsaketteihokenshain.SaishinsaKetteiHokenshaInMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsaketteihokenshain.SaishinsaMeisaiPsmEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsaketteihokenshain.ShinKyuHihokenshaNoHenkanEntity;

/**
 *
 * 再審査決定通知書情報取込（保険者分）Mapper
 *
 * @reamsid_L DBC-2520-010 chenaoqi
 */
public interface ISaishinsaKetteiHokenshaInMapper {

    /**
     * DB出力(再審査決定集計)
     */
    void insert再審査決定集計();

    /**
     * 新被保険者番号を取得
     *
     * @return List<ShinKyuHihokenshaNoHenkanEntity>
     */
    List<ShinKyuHihokenshaNoHenkanEntity> get新被保険者番号を取得();

    /**
     * 再審査決定通知書情報（明細）一時テーブルの更新
     *
     * @param entity ShinKyuHihokenshaNoHenkanEntity
     */
    void update再審査決定通知書情報明細一時テーブル(ShinKyuHihokenshaNoHenkanEntity entity);

    /**
     * 再審査決定通知書明細情報取得
     *
     * @return SaishinsaKetteiHokenshaInGokeiEntity
     */
    List<SaishinsaKetteiHokenshaInMeisaiEntity> selectAllMeisai();

    /**
     * 再審査決定通知書明細情報リスト取得
     *
     * @param parameter SaishinsaKetteiHokenshaInParameter
     * @return List<SaishinsaMeisaiPsmEntity>
     */
    List<SaishinsaMeisaiPsmEntity> select再審査決定通知書明細情報リスト(SaishinsaKetteiHokenshaInParameter parameter);

    /**
     * 再審査決定通知書集計情報取得
     *
     * @return SaishinsaKetteiHokenshaInGokeiEntity
     */
    SaishinsaKetteiHokenshaInGokeiEntity select再審査決定通知書集計情報();
}
