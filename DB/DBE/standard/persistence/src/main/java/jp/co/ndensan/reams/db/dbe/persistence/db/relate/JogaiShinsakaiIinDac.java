/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.relate;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5014ShinsakaiIinJogaiJoho;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5014ShinsakaiIinJogaiJoho.*;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5102ShinsakaiIinJoho;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.JogaiShinsakaiIinEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;
import static jp.co.ndensan.reams.uz.uza.util.db.Order.*;

/**
 * 審査会委員とその除外情報を取得するDacです。
 *
 * @author n8178 城間篤人
 */
public class JogaiShinsakaiIinDac {

    @InjectSession
    private SqlSession session;

    /**
     * 証記載保険者番号と介護被保険者番号を指定し、該当する審査会委員除外情報を取得します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @return 除外審査会委員EntityList
     */
    @Transaction
    public List<JogaiShinsakaiIinEntity> select(ShoKisaiHokenshaNo 証記載保険者番号, HihokenshaNo 被保険者番号) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().table(DbT5014ShinsakaiIinJogaiJoho.class)
                .leftJoin(DbT5102ShinsakaiIinJoho.class,
                        on(eq(DbT5014ShinsakaiIinJogaiJoho.jogaiTaishoShinsakaiIinCode, DbT5102ShinsakaiIinJoho.shinsakaiIinCode)))
                .where(and(eq(証記載保険者番号, shoKisaiHokenshaNo), eq(被保険者番号, hihokenshaNo)))
                .order(by(kanriNo, ASC))
                .toList(JogaiShinsakaiIinEntity.class);
    }
}
