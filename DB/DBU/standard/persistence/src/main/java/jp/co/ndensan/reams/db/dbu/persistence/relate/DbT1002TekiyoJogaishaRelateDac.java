/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.relate;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbu.definition.core.entity.Idokikan;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1002TekiyoJogaisha;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1002TekiyoJogaisha.shikibetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1002TekiyoJogaishaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 適用除外者のデータアクセスクラスです。
 */
public class DbT1002TekiyoJogaishaRelateDac {

    @InjectSession
    private SqlSession session;

    /**
     * 適用除外者テーブルに適用年月日と解除年月日を取得する
     *
     * @param 識別コード 識別コード
     * @return 適用除外者テーブルに適用年月日と解除年月日のリスト
     * @throws NullPointerException 識別コードがnull
     */
    @Transaction
    public List<Idokikan> selectIdokikanByShikibetsuCode(ShikibetsuCode 識別コード) throws NullPointerException {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        List<DbT1002TekiyoJogaishaEntity> tekiyoJogaishaEntityList = accessor.select().
                table(DbT1002TekiyoJogaisha.class).
                where(eq(shikibetsuCode, 識別コード)).
                toList(DbT1002TekiyoJogaishaEntity.class);
        List<Idokikan> idokikanList = new ArrayList<>();
        for (DbT1002TekiyoJogaishaEntity tekiyoJogaisha : tekiyoJogaishaEntityList) {
            Idokikan idokikan = new Idokikan();
            idokikan.setKaishiYMD(tekiyoJogaisha.getTekiyoYMD());
            idokikan.setShuryoYMD(tekiyoJogaisha.getKaijoYMD());
            idokikan.setEdaNo(tekiyoJogaisha.getEdaNo());
            idokikan.setIdoYMD(tekiyoJogaisha.getIdoYMD());
            idokikanList.add(idokikan);
        }
        return idokikanList;
    }
}
