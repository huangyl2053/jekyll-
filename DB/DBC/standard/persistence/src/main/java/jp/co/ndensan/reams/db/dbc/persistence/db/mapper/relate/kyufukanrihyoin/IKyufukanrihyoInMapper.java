/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kyufukanrihyoin;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kokuhorenkyoutsuu.KokuhorenIchiranhyoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3014KyufuKanrihyo200004Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3015KyufuKanrihyo200604Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu.DbWT1121KyufuKanrihyoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoin.HihokenshaKanriDataEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoin.HihokenshaKyufukanrihyoEntity;

/**
 * 給付管理票情報取込のMapperです。
 *
 * @reamsid_L DBC-2450-030 zhangrui
 */
public interface IKyufukanrihyoInMapper {

    /**
     * 給付管理票一時TBLを作成する。
     */
    void create給付管理票一時TBL();

    /**
     * 給付管理票一時TBLに登録する。
     *
     * @param entity DbWT1121KyufuKanrihyoTempEntity
     */
    void 給付管理票一時TBLに登録(DbWT1121KyufuKanrihyoTempEntity entity);

    /**
     * 直近の被保険者台帳管理データを取得する。
     *
     * @return List<HihokenshaKanriDataEntity>
     */
    List<HihokenshaKanriDataEntity> get直近の被保険者台帳管理データ();

    /**
     * 被保険者一時データに証記載保険者番号を登録する。
     *
     * @param temp DbWT0001HihokenshaTempEntity
     */
    void 被保険者一時データに証記載保険者番号を登録する(DbWT0001HihokenshaTempEntity temp);

    /**
     * 給付管理票一時データに事業者名称を登録する。
     *
     * @param temp DbWT1121KyufuKanrihyoTempEntity
     */
    void do事業者名称登録(DbWT1121KyufuKanrihyoTempEntity temp);

    /**
     * 給付管理票一時TBL．居宅サービス計画作成区分コード＝1：居宅介護支援事業所作成の場合。
     *
     * @return int 登録成功データ数
     */
    int do事業者名称登録_居宅介護支援事業所作成の場合();

    /**
     * 給付管理票一時TBL．居宅サービス計画作成区分コード＝3：介護予防支援事業所・地域包括支援センター作成の場合。
     *
     * @return int 登録成功データ数
     */
    int do事業者名称登録_介護予防支援事業所地域包括支援センター作成の場合();

    /**
     * 給付管理票一時TBLのデータと被保険者を取ります。
     *
     * @return List<HihokenshaKyufukanrihyoEntity>
     */
    List<HihokenshaKyufukanrihyoEntity> get給付管理票一時と被保険者一時のデータ();

    /**
     * 再処理の場合、前回処理時に取り込んだデータを物理削除する。
     *
     * @return int 削除成功データ数
     */
    int do給付管理票200004TBL処理済のデータの削除();

    /**
     * 再処理の場合、前回処理時に取り込んだデータを物理削除する。
     *
     * @return int 削除成功データ数
     */
    int do給付管理票200604TBL処理済のデータの削除();

    /**
     * 給付管理票200004TBLに登録する。
     *
     * @param entity DbT3014KyufuKanrihyo200004Entity
     * @return int 登録成功データ数
     */
    int 給付管理票200004TBLに登録(DbT3014KyufuKanrihyo200004Entity entity);

    /**
     * 給付管理票200604TBLに登録する。
     *
     * @param entity DbT3015KyufuKanrihyo200604Entity
     * @return int 登録成功データ数
     */
    int 給付管理票200604TBLに登録(DbT3015KyufuKanrihyo200604Entity entity);

    /**
     * 給付管理票一時TBLのデータと被保険者を取ります。
     *
     * @param parameter パラメータ
     * @return List<HihokenshaKyufukanrihyoEntity>
     */
    List<HihokenshaKyufukanrihyoEntity> get帳票出力対象データ(KokuhorenIchiranhyoMybatisParameter parameter);

}
