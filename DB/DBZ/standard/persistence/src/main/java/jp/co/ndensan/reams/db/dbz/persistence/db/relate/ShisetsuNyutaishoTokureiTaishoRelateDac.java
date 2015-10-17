/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.relate;

import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.DaichoType;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1005KaigoJogaiTokureiTaishoShisetsuEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護保険施設入退所・介護除外住所地特例対象施設を管理するクラスです。
 *
 * @author n8223 朴義一
 */
public class ShisetsuNyutaishoTokureiTaishoRelateDac {

    @InjectSession
    private SqlSession session;
    private final ShisetsuNyutaishoDac 介護保険施設入退所Dac = InstanceProvider.create(ShisetsuNyutaishoDac.class);
    private final KaigoJogaiTokureiTaishoShisetsuDac 介護除外住所地特例対象施設Dac = InstanceProvider.create(KaigoJogaiTokureiTaishoShisetsuDac.class);

    /**
     * 識別コードに合致する介護保険施設入退所のリストを返します。
     *
     * @param 識別コード ShikibetsuCode
     * @return IItemList<DbT1004ShisetsuNyutaishoEntity>
     */
    @Transaction
    public IItemList<DbT1004ShisetsuNyutaishoEntity> select介護保険施設入退所一覧By識別コード(ShikibetsuCode 識別コード) {

        IItemList<DbT1004ShisetsuNyutaishoEntity> 介護保険施設入退所一覧 = 介護保険施設入退所Dac.select介護保険施設入退所一覧By識別コード(識別コード);

        return 介護保険施設入退所一覧;
    }

    /**
     * 介護除外住所地特例対象施設情報をキー検索で１件返します。
     *
     * @param 事業者種別 RString
     * @param 事業者番号 RString
     * @param 有効開始年月日 FlexibleDate
     * @return Optional<DbT1004ShisetsuNyutaishoEntity>
     */
    @Transaction
    public Optional<DbT1005KaigoJogaiTokureiTaishoShisetsuEntity> select介護除外住所地特例対象施設ByKey(RString 事業者種別, RString 事業者番号, FlexibleDate 有効開始年月日) {

        return 介護除外住所地特例対象施設Dac.select介護除外住所地特例対象施設ByKey(事業者種別, 事業者番号, 有効開始年月日);
    }

    /**
     * 指定した識別コードと台帳種別に合致する、介護保険施設入退所のリストを返します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 台帳種別 DaichoType
     * @return IItemList<DbT1004ShisetsuNyutaishoEntity>
     */
    @Transaction
    public IItemList<DbT1004ShisetsuNyutaishoEntity> select台帳別施設入退所一覧(ShikibetsuCode 識別コード, DaichoType 台帳種別) {
        return 介護保険施設入退所Dac.select台帳別施設入退所一覧(識別コード, 台帳種別);
    }

}
