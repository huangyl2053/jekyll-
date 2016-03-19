/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.shokanbaraishikyuketteijoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanshikyuketteiin.ShokanShikyuKetteiInMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraishikyuketteijoho.IShikibetsuTaishoPSMEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraishikyuketteijoho.ShokanBaraShiketteiJohoShuukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraishikyuketteijoho.ShokanBaraShiketteiShuukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraishikyuketteijoho.ShokanBaraiShikyuKetteiJohoItijiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraishikyuketteijoho.SinHiBokenIchijiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;

/**
 * 償還払支給決定情報DB操作です。
 */
public interface IShokanBaraiShikyuKetteiJohoMapper {

    /**
     * 償還払支給決定情報一時TBLを作成する。
     */
    void create償還払支給決定情報一時TBL();

    /**
     * 新被保険者番号一時テーブルを作成する。
     */
    void create新被保険者番号一時テーブル();

    /**
     * 償還払支給決定情報一時TBLにデータを登録する。
     *
     * @param entity 償還払支給決定情報一時TBLのエンティティ
     */
    void insert償還払支給決定情報一時TBL(ShokanBaraiShikyuKetteiJohoItijiEntity entity);

    /**
     * 被保険者番号を取得する。
     *
     * @return 償還払支給決定情報一時TBLのエンティティ
     */
    List<ShokanBaraiShikyuKetteiJohoItijiEntity> select被保険者番号();

    /**
     * 市町村コードを取得する。
     *
     * @param parameter 市町村コードのパラメタ
     * @return 被保険者台帳管理Entity
     */
    DbT1001HihokenshaDaichoEntity select被保険者台帳管理(ShokanShikyuKetteiInMybatisParameter parameter);

    /**
     * 新被保険者番号を取得する。
     *
     * @param parameter 新被保険者番号のパラメタ
     * @return 新番号の取得対するテーブルのエンティティ
     */
    SinHiBokenIchijiEntity select新被保険者番号(ShokanShikyuKetteiInMybatisParameter parameter);

    /**
     * 新被保険者番号一時テーブルに登録する。
     *
     * @param entity 新番号の取得対するテーブルのエンティティ
     */
    void insert新被保険者番号一時テーブル(SinHiBokenIchijiEntity entity);

    /**
     * 新旧被保険者番号変換、償還払支給決定情報一時TBLに更新
     */
    void update償還払支給決定情報一時TBL();

    /**
     * 償還払支給決定情報一時TBLの更新
     *
     * @param entity 被保険者台帳管理テーブル
     */
    void update償還払支給決定情報一時TBL_識別コード(DbT1001HihokenshaDaichoEntity entity);

    /**
     * 一時デーブルから識別コードを取得する
     *
     * @return 償還払支給決定情報一時TBLのエンティティ
     */
    List<ShokanBaraiShikyuKetteiJohoItijiEntity> select識別コード();

    /**
     * 宛名識別対象PSMを呼び出して、宛名情報を取得
     *
     * @param parameter_宛名 宛名取得対するテーブルのエンティティ
     * @return 宛名情報Entity
     */
    List<IShikibetsuTaishoPSMEntity> select宛名情報Entity(ShokanShikyuKetteiInMybatisParameter parameter_宛名);

    /**
     * 償還払支給決定情報一時TBLの更新
     *
     * @param entity_宛名 更新用宛名エンティティ
     */
    void update償還払支給決定情報一時TBL_宛名(IShikibetsuTaishoPSMEntity entity_宛名);

    /**
     * 償還払支給判定結果登録用の集計結果。
     *
     * @return 償還払支給判定結果の登録用集計Entity
     */
    List<ShokanBaraShiketteiJohoShuukeiEntity> select一時TBL4償還払支給判定結果();

    /**
     * @return 償還払請求集計一時テーブルEntity
     */
    List<ShokanBaraShiketteiShuukeiEntity> select一時TBL4集計();

    /**
     * 集計結果を償還払請求集計一時テーブルに登録する。
     *
     * @param entity 償還払請求集計一時テーブルのエンティティ。
     */
    void insert償還払請求集計一時テーブル(ShokanBaraShiketteiShuukeiEntity entity);

    /**
     * 償還払請求集計を更新する
     */
    void update償還払請求集計();

    /**
     * 償還払請求食事費用の更新
     */
    void update償還払請求食事費用();

    /**
     * 償還払請求サービス計画200004を更新する。
     */
    void update償還払請求サービス計画200004();

    /**
     * 償還払請求サービス計画200604を更新する。
     */
    void update償還払請求サービス計画200604();

    /**
     * 償還払請求サービス計画200904を更新する。
     */
    void update償還払請求サービス計画200904();

    /**
     * 償還払請求特定入所者介護サービス費用を更新する。
     */
    void update特定入所者介護サービス費用();
}
