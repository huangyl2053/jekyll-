package jp.co.ndensan.reams.db.dbx.persistence.db.relate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1004HihokenshaShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7062KaigoJigyoshaDaihyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7063KaigoJigyoshaShiteiServiceEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.NyutaishoRelateEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbV1004HihokenshaShisetsuNyutaishoAliveDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7060KaigoJigyoshaDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7062KaigoJigyoshaDaihyoshaDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7063KaigoJigyoshaShiteiServiceDac;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 入退所の関連データアクセスクラスです。
 *
 * @author n8156 宮本 康
 * @jpName 入退所関連Dac
 * @bizDomain 介護
 * @category 施設入退所
 * @subCategory
 * @mainClass
 * @reference
 */
public class NyutaishoRelateDac {

    private final DbV1004HihokenshaShisetsuNyutaishoAliveDac nyutaishoDac;
    private final DbT7060KaigoJigyoshaDac jigyoshaDac;
    private final DbT7062KaigoJigyoshaDaihyoshaDac daihyoshaDac;
    private final DbT7063KaigoJigyoshaShiteiServiceDac shiteiServiceDac;

    /**
     * コンストラクタです。
     */
    public NyutaishoRelateDac() {
        nyutaishoDac = InstanceProvider.create(DbV1004HihokenshaShisetsuNyutaishoAliveDac.class);
        jigyoshaDac = InstanceProvider.create(DbT7060KaigoJigyoshaDac.class);
        daihyoshaDac = InstanceProvider.create(DbT7062KaigoJigyoshaDaihyoshaDac.class);
        shiteiServiceDac = InstanceProvider.create(DbT7063KaigoJigyoshaShiteiServiceDac.class);
    }

    /**
     * 引数の識別コードに該当する入退所関連エンティティのリストを取得します。
     *
     * @param 識別コード 識別コード
     * @return 入退所関連エンティティのリスト
     */
    @Transaction
    public List<NyutaishoRelateEntity> select(ShikibetsuCode 識別コード) {

        List<NyutaishoRelateEntity> list = new ArrayList<>();
        DbT7060KaigoJigyoshaEntity jigyosha;
        List<DbT7063KaigoJigyoshaShiteiServiceEntity> shiteiServiceEntity;
        DbT7062KaigoJigyoshaDaihyoshaEntity daihyoshaEntity;

        List<DbV1004HihokenshaShisetsuNyutaishoEntity> nyutaishoEntityList = nyutaishoDac.selectBy識別コード(識別コード);

        for (DbV1004HihokenshaShisetsuNyutaishoEntity nyutaishoEntity : nyutaishoEntityList) {
            jigyosha = jigyoshaDac.selectByKey(nyutaishoEntity.getNyushoShisetsuCode(), nyutaishoEntity.getNyushoYMD());
            daihyoshaEntity = daihyoshaDac.selectByKey(jigyosha.getJigyoshaNo(), jigyosha.getYukoKaishiYMD());
            shiteiServiceEntity = shiteiServiceDac.selectBy事業者番号(jigyosha.getJigyoshaNo());
            list.add(new NyutaishoRelateEntity(jigyosha, nyutaishoEntity, shiteiServiceEntity, daihyoshaEntity));
        }
        return (!list.isEmpty()) ? list : Collections.EMPTY_LIST;
    }
}
