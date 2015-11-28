/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.relate;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbu.definition.core.entity.Idokikan;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1003TashichosonJushochiTokurei;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1003TashichosonJushochiTokurei.shikibetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1003TashichosonJushochiTokureiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;

/**
 * 他市町村住所地特例のデータアクセスクラスです。
 */
public class DbT1003TashichosonJushochiTokureiRelateDac {

    @InjectSession
    private SqlSession session;

    /**
     * 他市町村住所地特例テーブルに適用年月日と解除年月日を取得する
     *
     * @param 識別コード 識別コード
     * @return 他市町村住所地特例テーブルに適用年月日と解除年月日のリスト
     * @throws NullPointerException 識別コードがnull
     */
    public List<Idokikan> selectIdokikanByShikibetsuCode(ShikibetsuCode 識別コード) throws NullPointerException {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        List<DbT1003TashichosonJushochiTokureiEntity> tashichosonJushochiTokureiEntityList = accessor.select().
                table(DbT1003TashichosonJushochiTokurei.class).
                where(eq(shikibetsuCode, 識別コード)).
                toList(DbT1003TashichosonJushochiTokureiEntity.class);

        List<Idokikan> idokikanList = new ArrayList<>();
        for (DbT1003TashichosonJushochiTokureiEntity tashichosonJushochiTokurei : tashichosonJushochiTokureiEntityList) {
            Idokikan idokikan = new Idokikan();
            idokikan.setKaishiYMD(tashichosonJushochiTokurei.getTekiyoYMD());
            idokikan.setShuryoYMD(tashichosonJushochiTokurei.getKaijoYMD());
            idokikan.setIdoYMD(tashichosonJushochiTokurei.getIdoYMD());
            idokikan.setEdaNo(tashichosonJushochiTokurei.getEdaNo());
            idokikanList.add(idokikan);
        }
        return idokikanList;
    }

}
