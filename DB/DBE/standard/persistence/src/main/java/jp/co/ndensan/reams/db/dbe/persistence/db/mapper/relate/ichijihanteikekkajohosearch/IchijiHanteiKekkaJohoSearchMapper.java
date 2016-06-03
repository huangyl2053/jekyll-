/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ichijihanteikekkajohosearch;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4203NinteichosahyoKihonChosaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4304ShujiiIkenshoIkenItemEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5211NinteichosahyoChosaItemEntity;

/**
 *
 * 一次判定結果情報取得 Mapper
 *
 * @reamsid_L DBE-3000-240 wangjie2
 */
public interface IchijiHanteiKekkaJohoSearchMapper {

    /**
     * 基本調査項目を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return List<DbT5211NinteichosahyoChosaItemEntity>
     */
    List<DbT5211NinteichosahyoChosaItemEntity> get基本調査項目(ShinseishoKanriNo 申請書管理番号);

    /**
     * 主治医意見書項目を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return List<DbT4304ShujiiIkenshoIkenItemEntity>
     */
    List<DbT4304ShujiiIkenshoIkenItemEntity> get主治医意見書項目(ShinseishoKanriNo 申請書管理番号);

    /**
     * 認定調査票_基本調査を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 認定調査票_基本調査
     */
    List<DbT4203NinteichosahyoKihonChosaEntity> get認定調査票_基本調査(ShinseishoKanriNo 申請書管理番号);

    /**
     * 認知症高齢者自立度_主治医意見書を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return List<DbT4304ShujiiIkenshoIkenItemEntity>
     */
    List<DbT4304ShujiiIkenshoIkenItemEntity> get認知症高齢者自立度_主治医意見書(ShinseishoKanriNo 申請書管理番号);

    /**
     * 認定調査票_基本調査件数を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 認定調査票_基本調査件数
     */
    int get認定調査票_基本調査件数(ShinseishoKanriNo 申請書管理番号);

    /**
     * 要介護認定主治医意見書情報件数を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 要介護認定主治医意見書情報件数
     */
    int get要介護認定主治医意見書情報件数(ShinseishoKanriNo 申請書管理番号);

}
