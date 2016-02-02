/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.chikuninteichosain;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.chikuninteichosain.ChosainJohoParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.chikuninteichosain.ChikuNinteiKoseiShichosonRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.chikuninteichosain.ChikuNinteiNinteichosaRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.chikuninteichosain.ChosainJohoRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5221NinteichosaScheduleEntity;

/**
 * 地区認定調査員情報のマッパーインタフェースです。
 */
public interface IChosainJohoMapper {

    /**
     * 通常件数取得します。
     *
     * @param 認定調査スケジュール詳細情報検索条件 認定調査スケジュール詳細情報検索条件
     * @return 通常件数
     */
    int get通常件数(ChosainJohoParameter 認定調査スケジュール詳細情報検索条件);

    /**
     * 重要件数取得します。
     *
     * @param 認定調査スケジュール詳細情報検索条件 認定調査スケジュール詳細情報検索条件
     * @return 重要件数
     */
    int get重要件数(ChosainJohoParameter 認定調査スケジュール詳細情報検索条件);

    /**
     * 認定調査スケジュール詳細情報取得します。
     *
     * @param 認定調査スケジュール詳細情報検索条件 認定調査スケジュール詳細情報検索条件
     * @return ChosainJohoRelateEntity
     */
    List<ChosainJohoRelateEntity> getChikuNinteiChosainRelateEntity(ChosainJohoParameter 認定調査スケジュール詳細情報検索条件);

    /**
     * 認定調査スケジュール詳細情報取得します。
     *
     * @param 認定調査スケジュール詳細情報検索条件 認定調査スケジュール詳細情報検索条件
     * @return ChosainJohoRelateEntity
     */
    List<ChosainJohoRelateEntity> getChikuNinteiChosainRelateEntityKensaku(ChosainJohoParameter 認定調査スケジュール詳細情報検索条件);

    /**
     * 保険者名称取得します。
     *
     * @param 保険者名称検索条件 保険者名称検索条件
     * @return ChikuNinteiKoseiShichosonRelateEntity
     */
    List<ChikuNinteiKoseiShichosonRelateEntity> getChikuNinteiKoseiShichosonRelateRelateEntity(ChosainJohoParameter 保険者名称検索条件);

    /**
     * 認定調査委託先名称取得します。
     *
     * @param 認定調査委託先名称検索条件 認定調査委託先名称検索条件
     * @return ChikuNinteiNinteichosaRelateEntity
     */
    List<ChikuNinteiNinteichosaRelateEntity> getChikuNinteiNinteichosaRelateEntity(ChosainJohoParameter 認定調査委託先名称検索条件);

    /**
     * 申請書管理番号取得します。
     *
     * @param 申請書管理番号検索条件 申請書管理番号検索条件
     * @return DbT5221NinteichosaScheduleEntity
     */
    DbT5221NinteichosaScheduleEntity getNinteichosaScheduleEntity(ChosainJohoParameter 申請書管理番号検索条件);

}
