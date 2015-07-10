/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.IkenshosakuseiIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5011ShujiiIkenshoIraiJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoDoctorCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.persistence.IDeletable;
import jp.co.ndensan.reams.db.dbz.persistence.IReplaceable;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 主治医意見書作成依頼情報のデータアクセスインターフェースです。
 *
 * @author N8156 宮本 康
 */
public interface IShujiiIkenshoIraiJohoDac
        extends IReplaceable<DbT5011ShujiiIkenshoIraiJohoEntity>, IDeletable<DbT5011ShujiiIkenshoIraiJohoEntity> {

    /**
     * 引数の条件に該当する主治医意見書作成依頼情報エンティティを取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 意見書作成依頼履歴番号 意見書作成依頼履歴番号
     * @return 主治医意見書作成依頼情報エンティティ
     */
    @Transaction
    DbT5011ShujiiIkenshoIraiJohoEntity select(ShinseishoKanriNo 申請書管理番号, IkenshosakuseiIraiRirekiNo 意見書作成依頼履歴番号);

    /**
     * 引数の条件に該当する主治医意見書作成依頼情報エンティティを取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 主治医意見書作成依頼情報エンティティ
     */
    @Transaction
    List<DbT5011ShujiiIkenshoIraiJohoEntity> selectBy申請書管理番号(ShinseishoKanriNo 申請書管理番号);

    /**
     * 引数の条件に該当する主治医意見書作成依頼情報エンティティを取得します。
     *
     * @param 意見書作成依頼年月日 意見書作成依頼年月日
     * @return 主治医意見書作成依頼情報エンティティ
     */
    @Transaction
    List<DbT5011ShujiiIkenshoIraiJohoEntity> selectBy依頼年月日(FlexibleDate 意見書作成依頼年月日);

    /**
     * 引数の条件に該当する主治医意見書作成依頼情報エンティティを取得します。
     *
     * @param 介護医療機関コード 介護医療機関コード
     * @param 介護医師コード 介護医師コード
     * @return 主治医意見書作成依頼情報エンティティ
     */
    @Transaction
    List<DbT5011ShujiiIkenshoIraiJohoEntity> selectBy主治医情報(KaigoIryoKikanCode 介護医療機関コード, KaigoDoctorCode 介護医師コード);

    /**
     * 引数の条件に該当する主治医意見書作成依頼情報エンティティを取得します。
     *
     * @param 意見書作成督促年月日 意見書作成督促年月日
     * @return 主治医意見書作成依頼情報エンティティ
     */
    @Transaction
    List<DbT5011ShujiiIkenshoIraiJohoEntity> selectBy督促年月日(FlexibleDate 意見書作成督促年月日);

    @Override
    int insertOrUpdate(DbT5011ShujiiIkenshoIraiJohoEntity entity);

    int insert(DbT5011ShujiiIkenshoIraiJohoEntity entity);

    public int update(DbT5011ShujiiIkenshoIraiJohoEntity entity);
}
