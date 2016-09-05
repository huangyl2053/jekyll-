/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMaster;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMaster.gappeiKyuShichosonKubun;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMaster.kanyuYMD;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMaster.ridatsuYMD;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMaster.shichosonCode;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMaster.shichosonShokibetsuID;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMaster.shoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.mapper.basic.IDbT7051KoseiShichosonMasterMapper;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.isNULL;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.leq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.or;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.substr;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 構成市町村マスタのデータアクセスクラスです。
 *
 * @reamsid_L DBX-9999-020 suguangjun
 */
public class DbT7051KoseiShichosonMasterDac {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで構成市町村マスタを取得します。
     *
     * @param 市町村識別ID 市町村識別ID
     * @return DbT7051KoseiShichosonMasterEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7051KoseiShichosonMasterEntity selectByKey(
            RString 市町村識別ID) throws NullPointerException {
        requireNonNull(市町村識別ID, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村識別ID"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7051KoseiShichosonMaster.class).
                where(
                        eq(shichosonShokibetsuID, 市町村識別ID)).
                toObject(DbT7051KoseiShichosonMasterEntity.class);
    }

    /**
     * 市町村識別IDで構成市町村マスタを取得します。
     *
     * @param shichosonShokibetsuID 市町村識別ID
     * @return DbT7051KoseiShichosonMasterEntityのlist
     */
    @Transaction
    public List<DbT7051KoseiShichosonMasterEntity> selectBy市町村識別ID(RString shichosonShokibetsuID) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7051KoseiShichosonMaster.class).
                where(
                        and(eq(DbT7051KoseiShichosonMaster.shichosonShokibetsuID, shichosonShokibetsuID),
                                eq(DbT7051KoseiShichosonMaster.isDeleted, false))).
                toList(DbT7051KoseiShichosonMasterEntity.class);
    }

    /**
     * 構成市町村マスタを全件返します。
     *
     * @return DbT7051KoseiShichosonMasterEntityの{@code list}
     */
    @Transaction
    public List<DbT7051KoseiShichosonMasterEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7051KoseiShichosonMaster.class).
                where(
                        eq(gappeiKyuShichosonKubun, '0') //TODO enumを使用する。
                ).
                toList(DbT7051KoseiShichosonMasterEntity.class);
    }

    /**
     * 構成市町村マスタを返します。 合併旧市町村区分='1' 合併情報地域番号の一桁目＝上記①で取得された地域番号の一桁目
     *
     * @param 地域番号 RString
     * @return List<DbT7051KoseiShichosonMasterEntity>
     */
    @Transaction
    public List<DbT7051KoseiShichosonMasterEntity> selectByKbnAndChikiNo(RString 地域番号) {
        requireNonNull(地域番号, UrSystemErrorMessages.値がnull.getReplacedMessage("地域番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7051KoseiShichosonMaster.class).
                where(and(eq(DbT7051KoseiShichosonMaster.gappeiKyuShichosonKubun, new RString("1")),
                                eq(substr(DbT7051KoseiShichosonMaster.gappeiChiikiNo, 1, 1), 地域番号.substring(0, 1)))).
                order(by(DbT7051KoseiShichosonMaster.gappeiChiikiNo, Order.DESC)).
                toList(DbT7051KoseiShichosonMasterEntity.class);
    }

    /**
     * 合併前の旧市町村と最新の広域構成市町村を含む全部市町村情報を取得します
     *
     * @return List<DbT7051KoseiShichosonMasterEntity> 全部市町村情報
     */
    @Transaction
    public List<DbT7051KoseiShichosonMasterEntity> zenShichosonJoho() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(DbT7051KoseiShichosonMaster.class).
                where(or(
                                eq(gappeiKyuShichosonKubun, '0'), //TODO enumを使用する。
                                eq(gappeiKyuShichosonKubun, '1')) //TODO enumを使用する。
                ).
                toList(DbT7051KoseiShichosonMasterEntity.class);
    }

    /**
     * 最新の広域構成市町村を含む現市町村情報を取得します
     *
     * @return List<DbT7051KoseiShichosonMasterEntity> 現市町村情報
     */
    @Transaction
    public List<DbT7051KoseiShichosonMasterEntity> genShichosonJoho() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(DbT7051KoseiShichosonMaster.class).
                where(
                        eq(gappeiKyuShichosonKubun, '0') //TODO enumを使用する。
                ).
                toList(DbT7051KoseiShichosonMasterEntity.class);
    }

    /**
     * 構成市町村ユーザ判定のエンティティを取得します。
     *
     *
     * @param 識別ID 市町村識別ID
     * @return DbT7051KoseiShichosonMasterEntity 構成市町村マスタテーブルのエンティティ
     */
    @Transaction
    public DbT7051KoseiShichosonMasterEntity shichosonUserHandan(RString 識別ID) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        DbT7051KoseiShichosonMasterEntity entity = accessor.
                select().
                table(DbT7051KoseiShichosonMaster.class).
                where(eq(shichosonShokibetsuID, 識別ID)).
                toObject(DbT7051KoseiShichosonMasterEntity.class);
        return entity;
    }

    /**
     * 指定された市町村コードの市町村が広域内の構成市町村エンティティを取得します。
     *
     * @param 市町村コード 市町村コード
     * @return entity 構成市町村マスタテーブルのエンティティ
     */
    @Transaction
    public DbT7051KoseiShichosonMasterEntity shichosonSonzaiHandan(RString 市町村コード) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        DbT7051KoseiShichosonMasterEntity entity = accessor.
                select().
                table(DbT7051KoseiShichosonMaster.class).
                where(and(
                                eq(shichosonShokibetsuID, 市町村コード),
                                eq(gappeiKyuShichosonKubun, "0"))).
                toObject(DbT7051KoseiShichosonMasterEntity.class);
        return entity;

    }

    /**
     * 市町村コードによる市町村情報の検索します
     *
     * @param 市町村コード 市町村コード
     * @return List<DbT7051KoseiShichosonMasterEntity> 市町村コードによる市町村Entityのリスと
     */
    @Transaction
    public List<DbT7051KoseiShichosonMasterEntity> shichosonCodeYoriShichosonJoho(LasdecCode 市町村コード) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(DbT7051KoseiShichosonMaster.class).
                where(and(
                                eq(shichosonCode, 市町村コード),
                                eq(gappeiKyuShichosonKubun, "0"))).
                toList(DbT7051KoseiShichosonMasterEntity.class);
    }

    /**
     * ログインユーザーの属する市町村情報を取得します
     *
     * @param 識別ID 市町村識別ID
     * @return List<DbT7051KoseiShichosonMasterEntity> ログインユーザーの属する市町村のリスと
     */
    @Transaction
    public List<DbT7051KoseiShichosonMasterEntity> loginUserShichosonJoho(RString 識別ID) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(DbT7051KoseiShichosonMaster.class).
                where(or(
                                eq(shichosonCode, "00"), //TODO 定数を使う（業務内で一つに定義すること）。
                                (and(
                                        eq(shichosonShokibetsuID, 識別ID),
                                        eq(gappeiKyuShichosonKubun, "0") //TODO enumを使う。
                                )))).
                toList(DbT7051KoseiShichosonMasterEntity.class);
    }

    /**
     * DbT7051KoseiShichosonMasterEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    public int save(DbT7051KoseiShichosonMasterEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("構成市町村マスタエンティティ"));

        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 旧市町村コード情報Listを取得する。
     *
     * @param 地域番号の一桁目 地域番号の一桁目
     * @return 旧市町村コード情報List
     */
    @Transaction
    public List<DbT7051KoseiShichosonMasterEntity> getKouikiKyuShichosonCodeJohoList(RString 地域番号の一桁目) {
        requireNonNull(地域番号の一桁目, UrSystemErrorMessages.値がnull.getReplacedMessage("地域番号の一桁目"));
        IDbT7051KoseiShichosonMasterMapper mapper = session.getMapper(IDbT7051KoseiShichosonMasterMapper.class);
        return mapper.getKouikiKyuShichosonCodeJohoList(地域番号の一桁目);
    }

    /**
     * 所在保険者リスト情報取得を取得.
     *
     * @return DbT7051KoseiShichosonMasterEntityの{@code list}
     */
    @Transaction
    public List<DbT7051KoseiShichosonMasterEntity> selectByKoseiShichosonMasterList() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7051KoseiShichosonMaster.class).
                where(and(
                                eq(gappeiKyuShichosonKubun, '0'),
                                leq(kanyuYMD, RDate.getNowDate()),
                                isNULL(ridatsuYMD))).
                toList(DbT7051KoseiShichosonMasterEntity.class);
    }

    /**
     * 構成市町村リスト情報を取得します。
     *
     * @return List<DbT7051KoseiShichosonMasterEntity> 構成市町村情報のリスト
     */
    @Transaction
    public List<DbT7051KoseiShichosonMasterEntity> koseiShichosonList() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(DbT7051KoseiShichosonMaster.class).
                where(
                        eq(gappeiKyuShichosonKubun, '0')).
                toList(DbT7051KoseiShichosonMasterEntity.class);
    }

    /**
     * 所在保険者リスト情報取得。
     *
     * @return List<DbT7051KoseiShichosonMasterEntity> 市町村コードによる市町村Entityのリスト
     */
    @Transaction
    public List<DbT7051KoseiShichosonMasterEntity> selectByGappeiKyuShichosonKubun() {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().table(DbT7051KoseiShichosonMaster.class).
                where(and(eq(gappeiKyuShichosonKubun, "0"),
                                leq(kanyuYMD, RDate.getNowDate()),
                                leq(RDate.getNowDate(), ridatsuYMD))).
                toList(DbT7051KoseiShichosonMasterEntity.class);
    }

    /**
     * 証記載保険者番号による市町村情報の検索します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return DbT7051KoseiShichosonMasterEntity 市町村情報
     */
    @Transaction
    public DbT7051KoseiShichosonMasterEntity shichosonCode(ShoKisaiHokenshaNo 証記載保険者番号) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(DbT7051KoseiShichosonMaster.class).
                where(and(eq(shoKisaiHokenshaNo, 証記載保険者番号),
                                eq(gappeiKyuShichosonKubun, "0")))
                .limit(1).
                toObject(DbT7051KoseiShichosonMasterEntity.class);
    }

    /**
     * 証記載保険者番号による市町村情報の検索します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return List<DbT7051KoseiShichosonMasterEntity> 市町村情報
     */
    @Transaction
    public List<DbT7051KoseiShichosonMasterEntity> getshichosonMeisho(ShoKisaiHokenshaNo 証記載保険者番号) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(DbT7051KoseiShichosonMaster.class).
                where(eq(shoKisaiHokenshaNo, 証記載保険者番号)).
                toList(DbT7051KoseiShichosonMasterEntity.class);
    }

    /**
     * 市町村コードによる市町村情報の検索します。
     *
     * @param 市町村コード 市町村コード
     * @return List<DbT7051KoseiShichosonMasterEntity> 市町村コードによる市町村Entityのリスト
     */
    @Transaction
    public List<DbT7051KoseiShichosonMasterEntity> selectByshichosonCode(LasdecCode 市町村コード) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(DbT7051KoseiShichosonMaster.class).
                where(eq(shichosonCode, 市町村コード)).order(by(DbT7051KoseiShichosonMaster.kanyuYMD, Order.DESC))
                .toList(DbT7051KoseiShichosonMasterEntity.class);
    }

    /**
     * 指定された市町村コードのの構成市町村エンティティを取得します。
     *
     * @param 市町村コード 市町村コード
     * @return entity 構成市町村マスタテーブルのエンティティ
     */
    @Transaction
    public DbT7051KoseiShichosonMasterEntity selectByShichosonCode(LasdecCode 市町村コード) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        DbT7051KoseiShichosonMasterEntity entity = accessor.
                select().
                table(DbT7051KoseiShichosonMaster.class).
                where(eq(shichosonCode, 市町村コード)).
                toObject(DbT7051KoseiShichosonMasterEntity.class);
        return entity;

    }

    /**
     * 市町村情報の検索します。
     *
     * @return List<DbT7051KoseiShichosonMasterEntity> 市町村コードによる市町村Entityのリスト
     */
    @Transaction
    public List<DbT7051KoseiShichosonMasterEntity> select広域市町村一覧() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(DbT7051KoseiShichosonMaster.class).
                order(by(DbT7051KoseiShichosonMaster.shichosonShokibetsuID, Order.ASC))
                .toList(DbT7051KoseiShichosonMasterEntity.class);
    }

    /**
     * 証記載保険者番号、市町村名称を検索します。
     *
     * @return List<DbT7051KoseiShichosonMasterEntity> 市町村名称による市町村Entityのリスト
     */
    @Transaction
    public List<DbT7051KoseiShichosonMasterEntity> select市町村名称() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(DbT7051KoseiShichosonMaster.class).
                order(by(DbT7051KoseiShichosonMaster.shoKisaiHokenshaNo, Order.DESC))
                .toList(DbT7051KoseiShichosonMasterEntity.class);
    }

    /**
     * 証記載保険者番号による市町村情報の検索します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return List<DbT7051KoseiShichosonMasterEntity> 市町村情報
     */
    @Transaction
    public List<DbT7051KoseiShichosonMasterEntity> get市町村名称(RString 証記載保険者番号) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(DbT7051KoseiShichosonMaster.class).
                where(eq(shoKisaiHokenshaNo, 証記載保険者番号)).
                order(by(gappeiKyuShichosonKubun, Order.ASC),
                        by(kanyuYMD, Order.DESC)).
                toList(DbT7051KoseiShichosonMasterEntity.class);
    }
}
