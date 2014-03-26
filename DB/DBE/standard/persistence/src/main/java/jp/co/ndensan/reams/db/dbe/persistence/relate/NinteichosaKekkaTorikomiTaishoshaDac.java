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
import jp.co.ndensan.reams.db.dbe.entity.relate.NinteichosaKekkaTorikomiTaishoshaEntity;
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
 * 認定調査結果取込対象者を取得するクラスです。
 *
 * @author N8187 久保田 英男
 */
public class NinteichosaKekkaTorikomiTaishoshaDac implements INinteichosaKekkaTorikomiTaishoshaDac {

    @InjectSession
    private SqlSession session;

    @Override
    public List<NinteichosaKekkaTorikomiTaishoshaEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        List<NinteichosaKekkaTorikomiTaishoshaEntity> list = accessor.select()
                .table(DbT5005NinteiShinchokuJoho.class)
                .leftJoin(DbT5001NinteiShinseiJoho.class, using(DbT5005NinteiShinchokuJoho.shinseishoKanriNo))
                .where(and(lt(YokaigoninteiDateConstants.認定調査依頼未完了年月日, DbT5005NinteiShinchokuJoho.ninteichosaIraiKanryoYMD),
                                eq(YokaigoninteiDateConstants.認定調査未完了年月日, DbT5005NinteiShinchokuJoho.ninteichosaKanryoYMD)))
                .toList(NinteichosaKekkaTorikomiTaishoshaEntity.class);

        return (!list.isEmpty()) ? list : Collections.EMPTY_LIST;
    }

    @Override
    public List<NinteichosaKekkaTorikomiTaishoshaEntity> select市町村コード(ShichosonCode 市町村コード) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        List<NinteichosaKekkaTorikomiTaishoshaEntity> list = accessor.select()
                .table(DbT5005NinteiShinchokuJoho.class)
                .leftJoin(DbT5001NinteiShinseiJoho.class, using(DbT5005NinteiShinchokuJoho.shinseishoKanriNo))
                .where(and(lt(YokaigoninteiDateConstants.認定調査依頼未完了年月日, DbT5005NinteiShinchokuJoho.ninteichosaIraiKanryoYMD),
                                eq(YokaigoninteiDateConstants.認定調査未完了年月日, DbT5005NinteiShinchokuJoho.ninteichosaKanryoYMD),
                                eq(DbT5001NinteiShinseiJoho.shichosonCode, 市町村コード)))
                .toList(NinteichosaKekkaTorikomiTaishoshaEntity.class);

        return (!list.isEmpty()) ? list : Collections.EMPTY_LIST;
    }

    @Override
    public List<NinteichosaKekkaTorikomiTaishoshaEntity> select市町村コード及び支所コード(ShichosonCode 市町村コード, RString 支所コード) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        List<NinteichosaKekkaTorikomiTaishoshaEntity> list = accessor.select()
                .table(DbT5005NinteiShinchokuJoho.class)
                .leftJoin(DbT5001NinteiShinseiJoho.class, using(DbT5005NinteiShinchokuJoho.shinseishoKanriNo))
                .where(and(lt(YokaigoninteiDateConstants.認定調査依頼未完了年月日, DbT5005NinteiShinchokuJoho.ninteichosaIraiKanryoYMD),
                                eq(YokaigoninteiDateConstants.認定調査未完了年月日, DbT5005NinteiShinchokuJoho.ninteichosaKanryoYMD),
                                eq(DbT5001NinteiShinseiJoho.shichosonCode, 市町村コード),
                                eq(DbT5001NinteiShinseiJoho.shishoCode, 支所コード)))
                .toList(NinteichosaKekkaTorikomiTaishoshaEntity.class);

        return (!list.isEmpty()) ? list : Collections.EMPTY_LIST;
    }
}
