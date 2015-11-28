/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.relate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbu.definition.core.entity.Idokikan;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaicho;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaicho.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaicho.idoYMD;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaicho.shikibetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Order.DESC;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 被保険者台帳管理のデータアクセスクラスです。
 */
public class DbT1001HihokenshaDaichoRelateDac {

    @InjectSession
    private SqlSession session;

    /**
     * 被保険者台帳管理テーブルに資格取得年月日と資格喪失年月日を取得する
     *
     * @param 識別コード 識別コード
     * @return 被保険者台帳管理テーブルに資格取得年月日と資格喪失年月日のリスト
     * @throws NullPointerException 識別コードがnull
     */
    @Transaction
    public List<Idokikan> selectIdokikanByShikibetsuCode(ShikibetsuCode 識別コード) throws NullPointerException {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        List<DbT1001HihokenshaDaichoEntity> entityList = accessor.select().
                table(DbT1001HihokenshaDaicho.class).
                where(eq(shikibetsuCode, 識別コード)).
                order(by(idoYMD, DESC)).
                toList(DbT1001HihokenshaDaichoEntity.class);
        if (entityList.isEmpty()) {
            return Collections.emptyList();
        } else {
            RString 被保険者番号 = entityList.get(0).getHihokenshaNo().getColumnValue();
            List<DbT1001HihokenshaDaichoEntity> hihokenshaDaichoEntityList = accessor.select().
                    table(DbT1001HihokenshaDaicho.class).
                    where(eq(hihokenshaNo, 被保険者番号)).
                    toList(DbT1001HihokenshaDaichoEntity.class);
            List<Idokikan> idokikanList = new ArrayList<>();

            for (DbT1001HihokenshaDaichoEntity hihokenshaDaichoEntity : hihokenshaDaichoEntityList) {
                Idokikan idokikan = new Idokikan();
                idokikan.setKaishiYMD(hihokenshaDaichoEntity.getShikakuShutokuYMD());
                idokikan.setShuryoYMD(hihokenshaDaichoEntity.getShikakuSoshitsuYMD());
                idokikan.setIdoYMD(hihokenshaDaichoEntity.getIdoYMD());
                idokikan.setEdaNo(hihokenshaDaichoEntity.getEdaNo());
                idokikanList.add(idokikan);
            }
            return idokikanList;
        }
    }
}
