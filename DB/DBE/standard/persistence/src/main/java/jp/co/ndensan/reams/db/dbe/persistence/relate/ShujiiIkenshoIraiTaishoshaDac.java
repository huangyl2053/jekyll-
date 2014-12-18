/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.relate;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.YokaigoNinteiDateConstants;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5005NinteiShinchokuJoho;
import jp.co.ndensan.reams.db.dbe.entity.relate.KaigoNinteiShoriTaishoshaEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 主治医意見書作成依頼対象者を取得するデータアクセスクラスです。
 * 要介護認定進捗情報の、主治医意見書作成依頼完了年月日が"00000000"のデータを取得します。
 *
 * @author N8187 久保田 英男
 */
public class ShujiiIkenshoIraiTaishoshaDac {

    @InjectSession
    private SqlSession session;

    /**
     * 主治医意見書作成依頼対象者を取得します。
     *
     * @return 介護認定処理対象者エンティティのリスト
     */
    @Transaction
    public List<KaigoNinteiShoriTaishoshaEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor
                .select()
                .table(DbT5005NinteiShinchokuJoho.class)
                .leftJoin(DbT5001NinteiShinseiJoho.class, using(DbT5005NinteiShinchokuJoho.shinseishoKanriNo))
                .where(eq(YokaigoNinteiDateConstants.主治医意見書作成依頼未完了年月日, DbT5005NinteiShinchokuJoho.ikenshoSakuseiIraiKanryoYMD))
                .toList(KaigoNinteiShoriTaishoshaEntity.class);
    }

    /**
     * 指定された証記載保険者番号に該当する、主治医意見書作成依頼対象者を取得します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return 介護認定処理対象者エンティティのリスト
     */
    @Transaction
    public List<KaigoNinteiShoriTaishoshaEntity> select証記載保険者番号(ShoKisaiHokenshaNo 証記載保険者番号) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor
                .select()
                .table(DbT5005NinteiShinchokuJoho.class)
                .leftJoin(DbT5001NinteiShinseiJoho.class, using(DbT5005NinteiShinchokuJoho.shinseishoKanriNo))
                .where(and(eq(YokaigoNinteiDateConstants.主治医意見書作成依頼未完了年月日, DbT5005NinteiShinchokuJoho.ikenshoSakuseiIraiKanryoYMD),
                                eq(証記載保険者番号, DbT5001NinteiShinseiJoho.shoKisaiHokenshaNo)))
                .toList(KaigoNinteiShoriTaishoshaEntity.class);
    }

    /**
     * 指定された証記載保険者番号及び支所コードに該当する、主治医意見書作成依頼対象者を取得します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 支所コード 支所コード
     * @return 介護認定処理対象者エンティティのリスト
     */
    @Transaction
    public List<KaigoNinteiShoriTaishoshaEntity> select証記載保険者番号及び支所コード(ShoKisaiHokenshaNo 証記載保険者番号, RString 支所コード) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor
                .select()
                .table(DbT5005NinteiShinchokuJoho.class)
                .leftJoin(DbT5001NinteiShinseiJoho.class, using(DbT5005NinteiShinchokuJoho.shinseishoKanriNo))
                .where(and(eq(YokaigoNinteiDateConstants.主治医意見書作成依頼未完了年月日, DbT5005NinteiShinchokuJoho.ikenshoSakuseiIraiKanryoYMD),
                                eq(証記載保険者番号, DbT5001NinteiShinseiJoho.shoKisaiHokenshaNo),
                                eq(支所コード, DbT5001NinteiShinseiJoho.shishoCode)))
                .toList(KaigoNinteiShoriTaishoshaEntity.class);
    }
}
