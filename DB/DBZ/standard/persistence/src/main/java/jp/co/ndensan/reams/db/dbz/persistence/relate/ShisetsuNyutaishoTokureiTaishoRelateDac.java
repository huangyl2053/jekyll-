/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.relate;

import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.model.KaigoJogaiTokureiTaishoShisetsu.KaigoJogaiTokureiTaishoShisetsuModel;
import jp.co.ndensan.reams.db.dbz.model.relate.ShisetsuNyutaishoRelateModel;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

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
     * @return IItemList<ShisetsuNyutaishoRelateModel>
     */
    @Transaction
    public IItemList<ShisetsuNyutaishoRelateModel> select介護保険施設入退所一覧By識別コード(ShikibetsuCode 識別コード) {

        IItemList<ShisetsuNyutaishoRelateModel> 介護保険施設入退所一覧;
        介護保険施設入退所一覧 = 介護保険施設入退所Dac.select介護保険施設入退所一覧By識別コード(識別コード);

        return 介護保険施設入退所一覧;
    }

    /**
     * 介護除外住所地特例対象施設情報をキー検索で１件返します。
     *
     * @param 事業者種別 RString
     * @param 事業者番号 RString
     * @param 有効開始年月日 FlexibleDate
     * @return Optional<KaigoJogaiTokureiTaishoShisetsuModel>
     */
    @Transaction
    public Optional<KaigoJogaiTokureiTaishoShisetsuModel> select介護除外住所地特例対象施設ByKey(RString 事業者種別, RString 事業者番号, FlexibleDate 有効開始年月日) {

        return 介護除外住所地特例対象施設Dac.select介護除外住所地特例対象施設ByKey(事業者種別, 事業者番号, 有効開始年月日);
    }

}
