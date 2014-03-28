/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.relate;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.YokaigoninteiDateConstants;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5005NinteiShinchokuJoho;
import jp.co.ndensan.reams.db.dbe.entity.relate.KaigoNinteiTaishoshaEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.lt;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.using;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;

/**
 * 主治医意見書取込対象者を取得するクラスです。
 *
 * @author N8187 久保田 英男
 */
public class ShujiiIkenshoTorikomiTaishoshaDac implements IShujiiIkenshoTorikomiTaishoshaDac {

    @InjectSession
    private SqlSession session;

    @Override
    public List<KaigoNinteiTaishoshaEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        List<KaigoNinteiTaishoshaEntity> list = accessor.select()
                .table(DbT5001NinteiShinseiJoho.class)
                .leftJoin(DbT5001NinteiShinseiJoho.class, using(DbT5005NinteiShinchokuJoho.shinseishoKanriNo))
                .where(and(lt(YokaigoninteiDateConstants.主治医意見書作成依頼未完了年月日, DbT5005NinteiShinchokuJoho.ikenshoSakuseiIraiKanryoYMD),
                eq(YokaigoninteiDateConstants.主治医意見書登録未完了年月日, DbT5005NinteiShinchokuJoho.ikenshoTorokuKanryoYMD)))
                .toList(KaigoNinteiTaishoshaEntity.class);

        return (!list.isEmpty()) ? list : Collections.EMPTY_LIST;
    }

    @Override
    public List<KaigoNinteiTaishoshaEntity> select市町村コード(ShichosonCode 市町村コード) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        List<KaigoNinteiTaishoshaEntity> list = accessor.select()
                .table(DbT5001NinteiShinseiJoho.class)
                .leftJoin(DbT5001NinteiShinseiJoho.class, using(DbT5005NinteiShinchokuJoho.shinseishoKanriNo))
                .where(and(lt(YokaigoninteiDateConstants.主治医意見書作成依頼未完了年月日, DbT5005NinteiShinchokuJoho.ikenshoSakuseiIraiKanryoYMD),
                eq(YokaigoninteiDateConstants.主治医意見書登録未完了年月日, DbT5005NinteiShinchokuJoho.ikenshoTorokuKanryoYMD),
                eq(DbT5001NinteiShinseiJoho.shichosonCode, 市町村コード)))
                .toList(KaigoNinteiTaishoshaEntity.class);

        return (!list.isEmpty()) ? list : Collections.EMPTY_LIST;
    }

    @Override
    public List<KaigoNinteiTaishoshaEntity> select市町村コード及び支所コード(ShichosonCode 市町村コード, RString 支所コード) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        List<KaigoNinteiTaishoshaEntity> list = accessor.select()
                .table(DbT5001NinteiShinseiJoho.class)
                .leftJoin(DbT5001NinteiShinseiJoho.class, using(DbT5005NinteiShinchokuJoho.shinseishoKanriNo))
                .where(and(lt(YokaigoninteiDateConstants.主治医意見書作成依頼未完了年月日, DbT5005NinteiShinchokuJoho.ikenshoSakuseiIraiKanryoYMD),
                eq(YokaigoninteiDateConstants.主治医意見書登録未完了年月日, DbT5005NinteiShinchokuJoho.ikenshoTorokuKanryoYMD),
                eq(DbT5001NinteiShinseiJoho.shichosonCode, 市町村コード),
                eq(DbT5001NinteiShinseiJoho.shishoCode, 支所コード)))
                .toList(KaigoNinteiTaishoshaEntity.class);

        return (!list.isEmpty()) ? list : Collections.EMPTY_LIST;
    }
}
