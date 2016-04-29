/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.shokanfushikyuketteiin;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanfushikyuketteiin.ShokanFushikyuKetteiInMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanfushikyuketteiin.ShokanFushikyuKetteiInPSMParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanfushikyuketteiin.ShokanFushikyuKetteiInParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanfushikyuketteiin.ShikibetsuTaishoPSMEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanfushikyuketteiin.ShokanFushikyuKetteiInEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanfushikyuketteiin.ShokanShukeiKetteiInEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanfushikyuketteiin.SinHihokenshaBangoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;

/**
 * 償還払不支給決定情報取込データ編集 DB操作です。
 *
 * @reamsid_L DBC-2590-030 xuhao
 */
public interface IShokanFushikyuKetteiInMapper {

    /**
     * 被保険者番号を取得する。
     *
     * @return 償還払不支給決定情報一時テーブルのエンティティ
     */
    List<ShokanFushikyuKetteiInEntity> select被保険者番号();

    /**
     * 市町村コードを取得する。
     *
     * @param parameter 市町村コードのパラメタ
     * @return 被保険者台帳管理Entity
     */
    DbT1001HihokenshaDaichoEntity select市町村コードFrom被保険者台帳管理(ShokanFushikyuKetteiInParameter parameter);

    /**
     * 新被保険者番号を取得する
     *
     * @param parameter ShokanFushikyuKetteiInParameter
     * @return SinHihokenshaBangoEntity
     */
    SinHihokenshaBangoEntity select新被保険者番号From新旧被保険者番号変換(ShokanFushikyuKetteiInParameter parameter);

    /**
     * 新被保険者番号一時テーブルを作成する。
     */
    void create新被保険者番号一時テーブル();

    /**
     * 新被保険者番号一時テーブルに登録する
     *
     * @param entity 新番号の取得対するテーブルのエンティティ
     */
    void insert新被保険者番号一時テーブル(SinHihokenshaBangoEntity entity);

    /**
     * 新旧被保険者番号変換、償還払支給決定情報一時TBLに更新
     */
    void update償還払不支給決定情報一時テーブル();

    /**
     * 被保険者台帳管理テーブルにデータを一時テーブルに更新する
     *
     * @param entity DbT1001HihokenshaDaichoEntity
     */
    void update償還払不支給決定情報一時テーブル_被保険者番号(DbT1001HihokenshaDaichoEntity entity);

    /**
     * 一時デーブルから識別コードを取得する
     *
     * @return 償還払不支給決定情報一時テーブルのエンティティ
     */
    List<ShokanFushikyuKetteiInEntity> select識別コード();

    /**
     * 宛名識別対象PSMを呼び出して、宛名情報を取得
     *
     * @param parameter_宛名 宛名取得対するテーブルのエンティティ
     * @return 宛名情報Entity
     */
    ShikibetsuTaishoPSMEntity select宛名情報Entity(ShokanFushikyuKetteiInPSMParameter parameter_宛名);

    /**
     * 償還払不支給決定情報一時TBLの更新
     *
     * @param entity IShikibetsuTaishoPSMEntity
     */
    void update償還払不支給決定情報一時テーブル_識別コード(ShikibetsuTaishoPSMEntity entity);

    /**
     * 償還払請求集計一時テーブルを作成する。
     */
    void create償還払請求集計一時テーブル();

    /**
     * 償還払不支給決定情報一時取得する
     *
     * @return List<ShokanFushikyuKetteiInEntity>
     */
    List<ShokanFushikyuKetteiInEntity> select償還払不支給決定情報一時テーブル();

    /**
     * 償還払不支給決定情報一時を取得する
     *
     * @return List<ShokanFushikyuKetteiInEntity>
     */
    List<ShokanFushikyuKetteiInEntity> select償還払不支給決定情報一時();

    /**
     * 備考を取得する
     *
     * @param entity 償還払不支給決定情報
     * @return ShokanFushikyuKetteiInEntity
     */
    ShokanFushikyuKetteiInEntity select備考(ShokanFushikyuKetteiInEntity entity);

    /**
     * 償還払請求集計一時テーブルを作成する。
     *
     * @param entity ShokanShukeiKetteiInEntity
     */
    void insert償還払請求集計一時テーブル(ShokanShukeiKetteiInEntity entity);

    /**
     * 償還払請求集計の更新
     */
    void update償還払請求集計();

    /**
     * update償還払請求食事費用
     */
    void update償還払請求食事費用();

    /**
     * update償還払請求サービス計画200004
     */
    void update償還払請求サービス計画200004();

    /**
     * update償還払請求サービス計画200604
     */
    void update償還払請求サービス計画200604();

    /**
     * update償還払請求サービス計画200904
     */
    void update償還払請求サービス計画200904();

    /**
     * update償還払請求特定入所者介護サービス費用
     */
    void update償還払請求特定入所者介護サービス費用();

    /**
     * 一時テーブル取得する。
     *
     * @param paramter ShokanFushikyuKetteiInMybatisParameter
     * @return List<ShokanFushikyuKetteiInEntity>
     */
    List<ShokanFushikyuKetteiInEntity> select一時テーブル(ShokanFushikyuKetteiInMybatisParameter paramter);

}
