/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4003YokaigoNinteiInterface;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4003YokaigoNinteiInterface.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4003YokaigoNinteiInterface.ichijiHanteiKekkaCode;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4003YokaigoNinteiInterface.ichijiHanteiYMD;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4003YokaigoNinteiInterface.nijiHanteiKekkaCode;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4003YokaigoNinteiInterface.nijiHanteiYMD;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4003YokaigoNinteiInterface.ninteiYukoKikanEnd;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4003YokaigoNinteiInterface.ninteiYukoKikanStart;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4003YokaigoNinteiInterface.shinseiShubetsuCode;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4003YokaigoNinteiInterface.shinseiYMD;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4003YokaigoNinteiInterface.shinseishoKanriNo;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4003YokaigoNinteiInterface.torikomiTimestamp;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4003YokaigoNinteiInterface.torisageKubunCode;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4003YokaigoNinteiInterface.yobiKomoku4;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4003YokaigoNinteiInterfaceEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.in;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定インターフェース情報のデータアクセスクラスです。
 *
 * @reamsid_L DBD-9999-013 wangjie2
 */
public class DbT4003YokaigoNinteiInterfaceDac implements ISaveable<DbT4003YokaigoNinteiInterfaceEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * DbT4003YokaigoNinteiInterfaceEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT4003YokaigoNinteiInterfaceEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定インターフェース情報エンティティ"));
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 主キーで要介護認定インターフェース情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 被保険者番号 被保険者番号
     * @param 取込日時 取込日時
     * @param 申請種別コード 申請種別コード
     * @param 取下区分コード 取下区分コード
     * @param 認定申請日 認定申請日
     * @param 一次判定日 一次判定日
     * @param 一次判定結果 一次判定結果
     * @param 二次判定日 二次判定日
     * @param 二次判定結果 二次判定結果
     * @param 認定有効開始年月日 認定有効開始年月日
     * @param 認定有効終了年月日 認定有効終了年月日
     * @param 予備区分４ 申請区分（法令）コード 予備区分４ 申請区分（法令）コード
     * @return DbT4003YokaigoNinteiInterfaceEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT4003YokaigoNinteiInterfaceEntity selectByKey(
            ShinseishoKanriNo 申請書管理番号,
            HihokenshaNo 被保険者番号,
            RString 取込日時,
            RString 申請種別コード,
            RString 取下区分コード,
            FlexibleDate 認定申請日,
            FlexibleDate 一次判定日,
            RString 一次判定結果,
            FlexibleDate 二次判定日,
            RString 二次判定結果,
            FlexibleDate 認定有効開始年月日,
            FlexibleDate 認定有効終了年月日,
            RString 予備区分４) throws NullPointerException {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(取込日時, UrSystemErrorMessages.値がnull.getReplacedMessage("取込日時"));
        requireNonNull(申請種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("申請種別コード"));
        requireNonNull(取下区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("取下区分コード"));
        requireNonNull(認定申請日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定申請日"));
        requireNonNull(一次判定日, UrSystemErrorMessages.値がnull.getReplacedMessage("一次判定日"));
        requireNonNull(一次判定結果, UrSystemErrorMessages.値がnull.getReplacedMessage("一次判定結果"));
        requireNonNull(二次判定日, UrSystemErrorMessages.値がnull.getReplacedMessage("二次判定日"));
        requireNonNull(二次判定結果, UrSystemErrorMessages.値がnull.getReplacedMessage("二次判定結果"));
        requireNonNull(認定有効開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定有効開始年月日"));
        requireNonNull(認定有効終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定有効終了年月日"));
        requireNonNull(予備区分４, UrSystemErrorMessages.値がnull.getReplacedMessage("予備区分４"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4003YokaigoNinteiInterface.class).
                where(and(
                                eq(shinseishoKanriNo, 申請書管理番号),
                                eq(hihokenshaNo, 被保険者番号),
                                eq(torikomiTimestamp, 取込日時),
                                eq(shinseiShubetsuCode, 申請種別コード),
                                eq(torisageKubunCode, 取下区分コード),
                                eq(shinseiYMD, 認定申請日),
                                eq(ichijiHanteiYMD, 一次判定日),
                                eq(ichijiHanteiKekkaCode, 一次判定結果),
                                eq(nijiHanteiYMD, 二次判定日),
                                eq(nijiHanteiKekkaCode, 二次判定結果),
                                eq(ninteiYukoKikanStart, 認定有効開始年月日),
                                eq(ninteiYukoKikanEnd, 認定有効終了年月日),
                                eq(yobiKomoku4, 予備区分４
                                ))).
                toObject(DbT4003YokaigoNinteiInterfaceEntity.class);
    }

    /**
     * 申請書管理番号リストにより、要介護認定インターフェース情報を全件返します。
     *
     * @param 申請書管理番号リスト List<RString>
     * @return DbT4003YokaigoNinteiInterfaceEntityの{@code list}
     */
    @Transaction
    public List<DbT4003YokaigoNinteiInterfaceEntity> select申請書管理番号リスト(List<RString> 申請書管理番号リスト) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT4003YokaigoNinteiInterface.class).
                where(in(shinseishoKanriNo, 申請書管理番号リスト)).
                toList(DbT4003YokaigoNinteiInterfaceEntity.class);
    }
}
