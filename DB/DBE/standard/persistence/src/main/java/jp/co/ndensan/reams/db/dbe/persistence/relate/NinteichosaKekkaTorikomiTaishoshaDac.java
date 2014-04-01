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
 * 認定調査結果取込対象者を取得するクラスです。
 *
 * @author N8187 久保田 英男
 */
public class NinteichosaKekkaTorikomiTaishoshaDac implements INinteichosaKekkaTorikomiTaishoshaDac {

    @InjectSession
    private SqlSession session;

    @Override
    @Transaction
    public List<KaigoNinteiShoriTaishoshaEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        List<KaigoNinteiShoriTaishoshaEntity> list = accessor.select()
                .table(DbT5005NinteiShinchokuJoho.class)
                .leftJoin(DbT5001NinteiShinseiJoho.class, using(DbT5005NinteiShinchokuJoho.shinseishoKanriNo))
                .where(and(lt(YokaigoninteiDateConstants.認定調査依頼未完了年月日, DbT5005NinteiShinchokuJoho.ninteichosaIraiKanryoYMD),
                eq(YokaigoninteiDateConstants.認定調査未完了年月日, DbT5005NinteiShinchokuJoho.ninteichosaKanryoYMD)))
                .toList(KaigoNinteiShoriTaishoshaEntity.class);

        return (!list.isEmpty()) ? list : Collections.EMPTY_LIST;
    }

    @Override
    @Transaction
    public List<KaigoNinteiShoriTaishoshaEntity> select証記載保険者番号(ShoKisaiHokenshaNo 証記載保険者番号) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        List<KaigoNinteiShoriTaishoshaEntity> list = accessor.select()
                .table(DbT5005NinteiShinchokuJoho.class)
                .leftJoin(DbT5001NinteiShinseiJoho.class, using(DbT5005NinteiShinchokuJoho.shinseishoKanriNo))
                .where(and(lt(YokaigoninteiDateConstants.認定調査依頼未完了年月日, DbT5005NinteiShinchokuJoho.ninteichosaIraiKanryoYMD),
                eq(YokaigoninteiDateConstants.認定調査未完了年月日, DbT5005NinteiShinchokuJoho.ninteichosaKanryoYMD),
                eq(DbT5001NinteiShinseiJoho.shoKisaiHokenshaNo, 証記載保険者番号)))
                .toList(KaigoNinteiShoriTaishoshaEntity.class);

        return (!list.isEmpty()) ? list : Collections.EMPTY_LIST;
    }

    @Override
    @Transaction
    public List<KaigoNinteiShoriTaishoshaEntity> select証記載保険者番号及び支所コード(ShoKisaiHokenshaNo 証記載保険者番号, RString 支所コード) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        List<KaigoNinteiShoriTaishoshaEntity> list = accessor.select()
                .table(DbT5005NinteiShinchokuJoho.class)
                .leftJoin(DbT5001NinteiShinseiJoho.class, using(DbT5005NinteiShinchokuJoho.shinseishoKanriNo))
                .where(and(lt(YokaigoninteiDateConstants.認定調査依頼未完了年月日, DbT5005NinteiShinchokuJoho.ninteichosaIraiKanryoYMD),
                eq(YokaigoninteiDateConstants.認定調査未完了年月日, DbT5005NinteiShinchokuJoho.ninteichosaKanryoYMD),
                eq(DbT5001NinteiShinseiJoho.shoKisaiHokenshaNo, 証記載保険者番号),
                eq(DbT5001NinteiShinseiJoho.shishoCode, 支所コード)))
                .toList(KaigoNinteiShoriTaishoshaEntity.class);

        return (!list.isEmpty()) ? list : Collections.EMPTY_LIST;
    }
}
