/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7302TokuteiKojinJohoKoumokuHanKanri;
import static jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7302TokuteiKojinJohoKoumokuHanKanri.codeRenban;
import static jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7302TokuteiKojinJohoKoumokuHanKanri.tokuteiKojinJohoKomokuCode;
import static jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7302TokuteiKojinJohoKoumokuHanKanri.tokuteiKojinJohoMeiCode;
import static jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7302TokuteiKojinJohoKoumokuHanKanri.versionJoho;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7302TokuteiKojinJohoKoumokuHanKanriEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 特定個人情報項目版管理のデータアクセスクラスです。
 *
 * @reamsid_L DBU-9999-013 wangchao
 */
public class DbT7302TokuteiKojinJohoKoumokuHanKanriDac implements ISaveable<DbT7302TokuteiKojinJohoKoumokuHanKanriEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで特定個人情報項目版管理を取得します。
     *
     * @param 特定個人情報項目コード 特定個人情報項目コード
     * @param 特定個人情報名コード 特定個人情報名コード
     * @param コード連番 コード連番
     * @param バージョン情報 バージョン情報
     * @return DbT7302TokuteiKojinJohoKoumokuHanKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7302TokuteiKojinJohoKoumokuHanKanriEntity selectByKey(
            RString 特定個人情報項目コード,
            RString 特定個人情報名コード,
            RString コード連番,
            RString バージョン情報) throws NullPointerException {
        requireNonNull(特定個人情報項目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("特定個人情報項目コード"));
        requireNonNull(特定個人情報名コード, UrSystemErrorMessages.値がnull.getReplacedMessage("特定個人情報名コード"));
        requireNonNull(コード連番, UrSystemErrorMessages.値がnull.getReplacedMessage("コード連番"));
        requireNonNull(バージョン情報, UrSystemErrorMessages.値がnull.getReplacedMessage("バージョン情報"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7302TokuteiKojinJohoKoumokuHanKanri.class).
                where(and(
                                eq(tokuteiKojinJohoKomokuCode, 特定個人情報項目コード),
                                eq(tokuteiKojinJohoMeiCode, 特定個人情報名コード),
                                eq(codeRenban, コード連番),
                                eq(versionJoho, バージョン情報))).
                toObject(DbT7302TokuteiKojinJohoKoumokuHanKanriEntity.class);
    }

    /**
     * 特定個人情報項目版管理を全件返します。
     *
     * @return DbT7302TokuteiKojinJohoKoumokuHanKanriEntityの{@code list}
     */
    @Transaction
    public List<DbT7302TokuteiKojinJohoKoumokuHanKanriEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7302TokuteiKojinJohoKoumokuHanKanri.class).
                toList(DbT7302TokuteiKojinJohoKoumokuHanKanriEntity.class);
    }

    /**
     * DbT7302TokuteiKojinJohoKoumokuHanKanriEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7302TokuteiKojinJohoKoumokuHanKanriEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("特定個人情報項目版管理エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessors.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
