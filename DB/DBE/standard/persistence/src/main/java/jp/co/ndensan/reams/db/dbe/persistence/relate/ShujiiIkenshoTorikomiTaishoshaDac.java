/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.relate;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.YokaigoninteiDateConstants;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5005NinteiShinchokuJoho;
import jp.co.ndensan.reams.db.dbe.entity.relate.KaigoNinteiShoriTaishoshaEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.lt;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.using;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 主治医意見書取込対象者に該当する介護認定処理対象者を取得するデータアクセスクラスです。
 *
 * @author N8187 久保田 英男
 */
public class ShujiiIkenshoTorikomiTaishoshaDac {

    @InjectSession
    private SqlSession session;

    /**
     * 主治医意見書取込対象者を全件取得します。
     *
     * @return 主治医意見書取込対象者に該当する介護認定処理対象者のエンティティリスト
     */
    @Transaction
    public List<KaigoNinteiShoriTaishoshaEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select()
                .table(DbT5001NinteiShinseiJoho.class)
                .leftJoin(DbT5005NinteiShinchokuJoho.class, using(DbT5001NinteiShinseiJoho.shinseishoKanriNo))
                .where(and(lt(YokaigoninteiDateConstants.主治医意見書作成依頼未完了年月日, DbT5005NinteiShinchokuJoho.ikenshoSakuseiIraiKanryoYMD),
                eq(YokaigoninteiDateConstants.主治医意見書登録未完了年月日, DbT5005NinteiShinchokuJoho.ikenshoTorokuKanryoYMD)))
                .toList(KaigoNinteiShoriTaishoshaEntity.class);
    }

    /**
     * 引数の証記載保険者番号に該当する、主治医意見書取込対象者を全件取得します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return 主治医意見書取込対象者に該当する介護認定処理対象者のエンティティリスト
     */
    @Transaction
    public List<KaigoNinteiShoriTaishoshaEntity> select証記載保険者番号(ShoKisaiHokenshaNo 証記載保険者番号) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select()
                .table(DbT5001NinteiShinseiJoho.class)
                .leftJoin(DbT5005NinteiShinchokuJoho.class, using(DbT5001NinteiShinseiJoho.shinseishoKanriNo))
                .where(and(lt(YokaigoninteiDateConstants.主治医意見書作成依頼未完了年月日, DbT5005NinteiShinchokuJoho.ikenshoSakuseiIraiKanryoYMD),
                eq(YokaigoninteiDateConstants.主治医意見書登録未完了年月日, DbT5005NinteiShinchokuJoho.ikenshoTorokuKanryoYMD),
                eq(DbT5001NinteiShinseiJoho.shoKisaiHokenshaNo, 証記載保険者番号)))
                .toList(KaigoNinteiShoriTaishoshaEntity.class);
    }

    /**
     * 引数の証記載保険者番号、支所コードに該当する、主治医意見書取込対象者を全件取得します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 支所コード 支所コード
     * @return 主治医意見書取込対象者に該当する介護認定処理対象者のエンティティリスト
     */
    @Transaction
    public List<KaigoNinteiShoriTaishoshaEntity> select証記載保険者番号及び支所コード(ShoKisaiHokenshaNo 証記載保険者番号, RString 支所コード) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select()
                .table(DbT5001NinteiShinseiJoho.class)
                .leftJoin(DbT5005NinteiShinchokuJoho.class, using(DbT5001NinteiShinseiJoho.shinseishoKanriNo))
                .where(and(lt(YokaigoninteiDateConstants.主治医意見書作成依頼未完了年月日, DbT5005NinteiShinchokuJoho.ikenshoSakuseiIraiKanryoYMD),
                eq(YokaigoninteiDateConstants.主治医意見書登録未完了年月日, DbT5005NinteiShinchokuJoho.ikenshoTorokuKanryoYMD),
                eq(DbT5001NinteiShinseiJoho.shoKisaiHokenshaNo, 証記載保険者番号),
                eq(DbT5001NinteiShinseiJoho.shishoCode, 支所コード)))
                .toList(KaigoNinteiShoriTaishoshaEntity.class);
    }
}
