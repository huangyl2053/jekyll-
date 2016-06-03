/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.saishinsakohifutansha;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kagoketteikohifutanshain.ShichosonHihokenshaParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsa.SaishinsaMesaiIchijiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsa.SaishinsaShukeiIchijiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsa.SaishisaKohifutanshaInEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;

/**
 * 再審査決定通知書情報取込（公費負担者分）DB操作です。
 *
 * @reamsid_L DBC-2820-010 sunhui
 */
public interface ISaishinsaKohishaMapper {

    /**
     * 再審査決定明細一時テーブルを作成する。
     */
    void create再審査明細一時テーブル();

    /**
     * 再審査決定集計一時テーブルを作成する。
     */
    void create再審査集計一時テーブル();

    /**
     * 再審査決定明細一時テーブルにデータを登録する。
     *
     * @param entity entity
     */
    void insert再審査決定明細一時テーブル(SaishinsaMesaiIchijiEntity entity);

    /**
     * 再審査決定集計一時テーブルにデータを登録する。
     *
     * @param entity entity
     */
    void insert再審査決定集計一時テーブル(SaishinsaShukeiIchijiEntity entity);

    /**
     * 一時テーブルから被保険者番号を取得する
     *
     * @return List<SaishinsaMesaiIchijiEntity>
     */
    List<SaishinsaMesaiIchijiEntity> select被保険者番号From一時テーブル();

    /**
     * 一時テーブル取得する
     *
     * @return List<SaishisaKohifutanshaInEntity>
     */
    List<SaishisaKohifutanshaInEntity> select一時テーブル();

    /**
     * 新被保険者番号一時テーブルを作成する。
     */
    void create新被保険者番号一時テーブル();

    /**
     * 被保険者台帳管理から市町村コードを取得する。
     *
     * @param parameter parameter
     * @return DbT1001HihokenshaDaichoEntity
     */
    DbT1001HihokenshaDaichoEntity select市町村コードFrom被保険者台帳管理(ShichosonHihokenshaParameter parameter);

}
