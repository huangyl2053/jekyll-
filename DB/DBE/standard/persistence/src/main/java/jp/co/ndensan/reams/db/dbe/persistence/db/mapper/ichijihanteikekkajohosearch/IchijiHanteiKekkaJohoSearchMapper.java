/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.ichijihanteikekkajohosearch;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4203NinteichosahyoKihonChosaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4304ShujiiIkenshoIkenItemEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5211NinteichosahyoChosaItemEntity;

/**
 *
 * 一次判定結果情報取得 Mapper
 */
public interface IchijiHanteiKekkaJohoSearchMapper {

    /**
     * get厚労省IF識別コード
     *
     * @param 申請書管理番号 申請書管理番号
     * @return DbT5101NinteiShinseiJohoEntity
     */
    DbT5101NinteiShinseiJohoEntity get厚労省IF識別コード(ShinseishoKanriNo 申請書管理番号);

    /**
     * get基本調査項目
     *
     * @param 申請書管理番号 申請書管理番号
     * @return List<DbT5211NinteichosahyoChosaItemEntity>
     */
    List<DbT5211NinteichosahyoChosaItemEntity> get基本調査項目(ShinseishoKanriNo 申請書管理番号);

    /**
     * get主治医意見書項目
     *
     * @param 申請書管理番号 申請書管理番号
     * @return List<DbT4304ShujiiIkenshoIkenItemEntity>
     */
    List<DbT4304ShujiiIkenshoIkenItemEntity> get主治医意見書項目(ShinseishoKanriNo 申請書管理番号);

    /**
     * get認定調査票_基本調査
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 認定調査票_基本調査
     */
    List<DbT4203NinteichosahyoKihonChosaEntity> get認定調査票_基本調査(ShinseishoKanriNo 申請書管理番号);

    /**
     * get認知症高齢者自立度_主治医意見書
     *
     * @param 申請書管理番号 申請書管理番号
     * @return List<DbT4304ShujiiIkenshoIkenItemEntity>
     */
    List<DbT4304ShujiiIkenshoIkenItemEntity> get認知症高齢者自立度_主治医意見書(ShinseishoKanriNo 申請書管理番号);

    /**
     * get認定調査票_基本調査件数
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 認定調査票_基本調査件数
     */
    int get認定調査票_基本調査件数(ShinseishoKanriNo 申請書管理番号);

    /**
     * get要介護認定主治医意見書情報件数
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 要介護認定主治医意見書情報件数
     */
    int get要介護認定主治医意見書情報件数(ShinseishoKanriNo 申請書管理番号);

}
