/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.saishinsaketteihokenshainmasutatoroku;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3063SaishinsaKetteiShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3064SaishinsaKetteiMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsaketteihokenshainmasutatoroku.DbWT0001Hihokensha;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsaketteihokenshainmasutatoroku.DbWT3064SaishinsaKetteiMeisai;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsaketteihokenshainmasutatoroku.SaiShinsaKetteiMeisaiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsaketteihokenshainmasutatoroku.SaiShinsaKetteiShukeiTempEntity;

/**
 * 再審査決定通知書情報取込共通処理（マスタ登録）DB操作です。
 *
 * @reamsid_L DBC-2520-011 sunhui
 */
public interface ISaishinsaKetteiHokenshaInMasutaTorokuMapper {

    /**
     * 再審査決定明細一時TBLの全データ
     *
     * @return 再審査決定明細一時テーブルのエンティティ
     */
    List<SaiShinsaKetteiMeisaiTempEntity> getSaiShinsaKetteiMeisaiTempTBLData();

    /**
     * 再審査決定集計一時TBLの全データ
     *
     * @return 再審査決定集計一時テーブルのエンティティ
     */
    List<SaiShinsaKetteiShukeiTempEntity> getSaiShinsaKetteiShukeiTempTBLData();

    /**
     * 再審査決定集計TBLの全データ
     *
     * @return 再審査決定集計テーブルのエンティティ
     */
    List<DbT3063SaishinsaKetteiShukeiEntity> getDbT3063SaishinsaKetteiShukei();

    /**
     * 再審査決定明細TBLの全データ
     *
     * @return 再審査決定明細テーブルのエンティティ
     */
    List<DbT3064SaishinsaKetteiMeisaiEntity> getDbT3064SaishinsaKetteiMeisai();


    /**
     * 再審査決定集計一時テーブルを作成します
     *
     */
    void createTmpDbWT3063SaishinsaKetteiShukei();

    /**
     * 再審査決定明細一時テーブルを作成します
     *
     */
    void createTmpDbWT3064SaishinsaKetteiMeisai();

    /**
     * 被保険者一時テーブルを作成します
     *
     */
    void createTmpDbWT0001Hihokensha();

    /**
     * 再審査決定集計一時テーブルに登録する
     *
     * @param entity SaiShinsaKetteiShukeiTempEntity
     */
    void insertTmpDbWT3063SaishinsaKetteiShukei(SaiShinsaKetteiShukeiTempEntity entity);

    /**
     * 再審査決定明細一時テーブルに登録する
     *
     * @param entity DbWT3064SaishinsaKetteiMeisai
     */
    void insertTmpDbWT3064SaishinsaKetteiMeisai(DbWT3064SaishinsaKetteiMeisai entity);

    /**
     * 被保険者一時テーブルに登録する
     *
     * @param entity DbWT0001Hihokensha
     */
    void insertTmpDbWT0001Hihokensha(DbWT0001Hihokensha entity);
}
