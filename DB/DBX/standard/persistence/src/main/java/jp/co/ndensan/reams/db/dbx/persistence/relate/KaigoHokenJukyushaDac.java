/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.relate;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.enumeratedtype.YoKaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbx.entity.basic.KaigohokenJukyusha;
import jp.co.ndensan.reams.db.dbx.entity.relate.KaigohokenJukyushaAndKojinEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaisho;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessor;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;

/**
 * 介護保険受給者DACクラスです
 *
 * @author N2806 太田 智之
 * @jpName 介護保険受給者Dac
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護保険受給者
 * @mainClass
 * @reference
 */
public class KaigoHokenJukyushaDac implements IKaigoHokenJukyushaDac {

    @InjectSession
    private SqlSession session;

    @Override
    public List<KaigohokenJukyushaAndKojinEntity> select(RString 識別コード) {
        DbAccessor accessor = new DbAccessor(session);

        return accessor.
                select().
                table(KaigohokenJukyusha.class).
                innerJoin(UaFt200FindShikibetsuTaisho.class, using(UaFt200FindShikibetsuTaisho.shikibetsuCode, KaigohokenJukyusha.識別コード)).
                where(eq(KaigohokenJukyusha.識別コード, 識別コード)).
                order(by(KaigohokenJukyusha.有効開始年月日, Order.DESC)).
                toList(KaigohokenJukyushaAndKojinEntity.class);
    }

    @Override
    public KaigohokenJukyushaAndKojinEntity select(RString 識別コード, RDate 基準日) {
        DbAccessor accessor = new DbAccessor(session);

        List<KaigohokenJukyushaAndKojinEntity> list = accessor.
                select().
                table(KaigohokenJukyusha.class).
                innerJoin(UaFt200FindShikibetsuTaisho.class, using(UaFt200FindShikibetsuTaisho.shikibetsuCode, KaigohokenJukyusha.識別コード)).
                where(and(eq(KaigohokenJukyusha.識別コード, 識別コード), and(
                                        leq(KaigohokenJukyusha.有効開始年月日, 基準日),
                                        leq(基準日, KaigohokenJukyusha.有効終了年月日)))).
                order(by(KaigohokenJukyusha.有効開始年月日, Order.DESC)).
                toList(KaigohokenJukyushaAndKojinEntity.class);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<KaigohokenJukyushaAndKojinEntity> select(
            YoKaigoJotaiKubun from要介護状態区分,
            YoKaigoJotaiKubun to要介護状態区分,
            RDate 基準日) {
        DbAccessor accessor = new DbAccessor(session);
        return accessor.
                select().
                table(KaigohokenJukyusha.class).
                innerJoin(UaFt200FindShikibetsuTaisho.class, using(UaFt200FindShikibetsuTaisho.shikibetsuCode, KaigohokenJukyusha.識別コード)).
                where(and(leq(KaigohokenJukyusha.要介護状態区分, from要介護状態区分.getCode()),
                                leq(to要介護状態区分.getCode(), KaigohokenJukyusha.要介護状態区分),
                                leq(KaigohokenJukyusha.有効開始年月日, 基準日),
                                leq(基準日, KaigohokenJukyusha.有効終了年月日))).
                order(by(KaigohokenJukyusha.有効開始年月日, Order.DESC)).
                toList(KaigohokenJukyushaAndKojinEntity.class);
    }
}
