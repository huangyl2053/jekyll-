/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kagoketteikohifutanshain;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kagoketteikohifutanshain.ShichosonHihokenshaParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kagoketteikohifutanshain.KagoKetteiKohifutanshaInEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kagoketteikohifutanshain.KagoketteiMesaiIchijiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kagoketteikohifutanshain.KagoketteiShukeiIchijiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kagoketteikohifutanshain.SinHihokenshaBangoIchijiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;

/**
 * 介護給付費過誤決定通知書情報取込（公費負担者分）DB操作です。
 */
public interface IKagoKetteiKohishaMapper {

    /**
     * 過誤決定集計の登録処理
     */
    void insert過誤決定集計();

    /**
     * 過誤決定明細の登録処理
     */
    void insert過誤決定明細();

    /**
     * 過誤決定明細一時テーブルを作成する。
     */
    void create過誤決定明細一時テーブル();

    /**
     * 過誤決定集計一時テーブルを作成する。
     */
    void create過誤決定集計一時テーブル();

    /**
     * 新被保険者番号一時テーブルを作成する。
     */
    void create新被保険者番号一時テーブル();

    /**
     * 過誤決定明細一時テーブルにデータを登録する。
     *
     * @param entity entity
     */
    void insert過誤決定明細一時テーブル(KagoketteiMesaiIchijiEntity entity);

    /**
     * 過誤決定集計一時テーブルにデータを登録する。
     *
     * @param entity entity
     */
    void insert過誤決定集計一時テーブル(KagoketteiShukeiIchijiEntity entity);

    /**
     * 新被保険者番号一時テーブルにデータを登録する。
     *
     * @param entity entity
     */
    void insert新被保険者番号一時テーブル(SinHihokenshaBangoIchijiEntity entity);

    /**
     * 一時テーブルから被保険者番号を取得する
     *
     * @return List<KagoketteiMesaiIchijiEntity>
     */
    List<KagoketteiMesaiIchijiEntity> select被保険者番号From一時テーブル();

    /**
     * 一時テーブル取得する。
     *
     * @return List<KagoKetteiKohifutanshaInEntity>
     */
    List<KagoKetteiKohifutanshaInEntity> select一時テーブル();

    /**
     * 被保険者台帳管理から市町村コードを取得する。
     *
     * @param parameter parameter
     * @return DbT1001HihokenshaDaichoEntity
     */
    DbT1001HihokenshaDaichoEntity select市町村コードFrom被保険者台帳管理(ShichosonHihokenshaParameter parameter);

    /**
     * 新旧被保険者番号変換から新被保険者番号を取得する。
     *
     * @param parameter parameter
     * @return SinHihokenshaBangoIchijiEntity
     */
    SinHihokenshaBangoIchijiEntity select新被保険者番号From新旧被保険者番号変換(
            ShichosonHihokenshaParameter parameter);

    /**
     * 過誤決定明細一時テーブルの被保険者番号を更新する。
     */
    void update過誤決定明細一時テーブル();
}
