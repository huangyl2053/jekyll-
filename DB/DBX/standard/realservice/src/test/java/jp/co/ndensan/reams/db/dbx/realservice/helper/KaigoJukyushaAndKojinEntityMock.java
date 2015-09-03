package jp.co.ndensan.reams.db.dbx.realservice.helper;

import jp.co.ndensan.reams.db.dbx.entity.basic.KaigohokenJukyushaEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.db.dbx.entity.relate.KaigohokenJukyushaAndKojinEntity;
import static org.mockito.Mockito.*;

/**
 * 介護保険受給者エンティティと個人エンティティの複合エンティティのモッククラスです。
 *
 * @author N2806 太田 智之
 */
public class KaigoJukyushaAndKojinEntityMock {

    public static KaigohokenJukyushaAndKojinEntity getSpiedInstance() {

        KaigohokenJukyushaEntity entity = KaigoHokenJukyuhaEntityMock.getSpiedInstance();
        UaFt200FindShikibetsuTaishoEntity jutogaiYusenCurrentEntity = UaFt200FindShikibetsuTaishoEntityMock.getSpiedInstance();
        KaigohokenJukyushaAndKojinEntity jukyushaAndKojin = new KaigohokenJukyushaAndKojinEntity(entity, jutogaiYusenCurrentEntity);
        return spy(jukyushaAndKojin);
    }
}
