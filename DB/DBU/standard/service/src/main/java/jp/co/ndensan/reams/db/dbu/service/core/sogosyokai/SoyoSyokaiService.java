/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.core.sogosyokai;

import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyosha.KaigoJigyosha;
import jp.co.ndensan.reams.db.dbx.business.core.view.HihokenshaDaichoAlive;
import jp.co.ndensan.reams.db.dbx.business.core.view.ShisetsuNyutaishoAlive;
import jp.co.ndensan.reams.db.dbx.business.core.view.TashichosonJushochiTokureiAlive;
import jp.co.ndensan.reams.db.dbx.business.core.view.TekiyoJogaishaAlive;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1002TekiyoJogaishaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1003TashichosonJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.kaigojigyosha.kaigojigyosha.KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7060KaigoJigyoshaDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbV1001HihokenshaDaichoAliveDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbV1002TekiyoJogaishaAliveDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbV1003TashichosonJushochiTokureiAliveDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbV1004ShisetsuNyutaishoAliveDac;
import jp.co.ndensan.reams.db.dbz.business.core.KaigoJogaiTokureiTaishoShisetsu;
import jp.co.ndensan.reams.db.dbz.business.core.ShisetsuNyutaisho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1005KaigoJogaiTokureiTaishoShisetsuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1004ShisetsuNyutaishoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1005KaigoJogaiTokureiTaishoShisetsuDac;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 総合照会_資格得喪情報のServiceです。
 *
 * @reamsid_L DBU-4100-010 wanghuafeng
 */
public class SoyoSyokaiService {

    private final DbV1001HihokenshaDaichoAliveDac dbv1001dac;
    private final DbV1004ShisetsuNyutaishoAliveDac dbv1004dac;
    private final DbV1003TashichosonJushochiTokureiAliveDac dbv1003dac;
    private final DbV1002TekiyoJogaishaAliveDac dbv1002dac;
    private final DbT7060KaigoJigyoshaDac dbt7060dac;
    private final DbT1005KaigoJogaiTokureiTaishoShisetsuDac dbt1005dac;
    private final DbT1004ShisetsuNyutaishoDac dbt1004dac;

    /**
     * インスタンスです。
     *
     */
    public SoyoSyokaiService() {
        this.dbv1001dac = InstanceProvider.create(DbV1001HihokenshaDaichoAliveDac.class);
        this.dbv1004dac = InstanceProvider.create(DbV1004ShisetsuNyutaishoAliveDac.class);
        this.dbv1003dac = InstanceProvider.create(DbV1003TashichosonJushochiTokureiAliveDac.class);
        this.dbv1002dac = InstanceProvider.create(DbV1002TekiyoJogaishaAliveDac.class);
        this.dbt7060dac = InstanceProvider.create(DbT7060KaigoJigyoshaDac.class);
        this.dbt1005dac = InstanceProvider.create(DbT1005KaigoJogaiTokureiTaishoShisetsuDac.class);
        this.dbt1004dac = InstanceProvider.create(DbT1004ShisetsuNyutaishoDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param dbv1001dac DbV1001HihokenshaDaichoAliveDac
     * @param dbv1004dac DbV1004ShisetsuNyutaishoAliveDac
     * @param dbv1003dac DbV1003TashichosonJushochiTokureiAliveDac
     * @param dbv1002dac DbV1002TekiyoJogaishaAliveDac
     * @param dbt7060dac DbT7060KaigoJigyoshaDac
     * @param dbt1005dac DbT1005KaigoJogaiTokureiTaishoShisetsuDac
     */
    SoyoSyokaiService(
            DbV1001HihokenshaDaichoAliveDac dbv1001dac,
            DbV1004ShisetsuNyutaishoAliveDac dbv1004dac,
            DbV1003TashichosonJushochiTokureiAliveDac dbv1003dac,
            DbV1002TekiyoJogaishaAliveDac dbv1002dac,
            DbT7060KaigoJigyoshaDac dbt7060dac,
            DbT1005KaigoJogaiTokureiTaishoShisetsuDac dbt1005dac,
            DbT1004ShisetsuNyutaishoDac dbt1004dac
    ) {
        this.dbv1001dac = dbv1001dac;
        this.dbv1004dac = dbv1004dac;
        this.dbv1003dac = dbv1003dac;
        this.dbv1002dac = dbv1002dac;
        this.dbt7060dac = dbt7060dac;
        this.dbt1005dac = dbt1005dac;
        this.dbt1004dac = dbt1004dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SoyoSyokaiService}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link SoyoSyokaiService}のインスタンス
     */
    public static SoyoSyokaiService createInstance() {
        return InstanceProvider.create(SoyoSyokaiService.class);
    }

    /**
     * 被保険者台帳の取得です。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return HihokenshaDaichoAlive
     */
    @Transaction
    public HihokenshaDaichoAlive get被保険者台帳(HihokenshaNo 被保険者番号) {
        DbV1001HihokenshaDaichoEntity result = dbv1001dac.get被保険者台帳取得(被保険者番号);
        if (result != null) {
            return new HihokenshaDaichoAlive(result);
        }
        return null;
    }

    /**
     * 施設入退所の取得です。
     *
     * @param 識別コード ShikibetsuCode
     * @return ShisetsuNyutaishoAlive
     */
    @Transaction
    public ShisetsuNyutaishoAlive get施設入退所(ShikibetsuCode 識別コード) {
        DbV1004ShisetsuNyutaishoEntity result = dbv1004dac.get施設入退所(識別コード);
        if (result != null) {
            return new ShisetsuNyutaishoAlive(result);
        }
        return null;
    }

    /**
     * 他市町村住所地特例情報の取得です。
     *
     * @param 識別コード ShikibetsuCode
     * @return TashichosonJushochiTokureiAlive
     */
    @Transaction
    public TashichosonJushochiTokureiAlive get他市町村住所地特例情報(ShikibetsuCode 識別コード) {
        DbV1003TashichosonJushochiTokureiEntity result = dbv1003dac.get他市町村住所地特例情報(識別コード);
        if (result != null) {
            return new TashichosonJushochiTokureiAlive(result);
        }
        return null;
    }

    /**
     * 施設入退所Orderの取得です。
     *
     * @param 識別コード ShikibetsuCode
     * @param 台帳種別 DaichoType
     * @return ShisetsuNyutaishoAlive
     */
    @Transaction
    public ShisetsuNyutaisho get施設入退所Order(ShikibetsuCode 識別コード, RString 台帳種別) {
        DbT1004ShisetsuNyutaishoEntity result = dbt1004dac.get施設入退所Order(識別コード, 台帳種別);
        if (result != null) {
            return new ShisetsuNyutaisho(result);
        }
        return null;
    }

    /**
     * 適用除外者情報の取得です。
     *
     * @param 識別コード ShikibetsuCode
     * @return TekiyoJogaishaAlive
     */
    @Transaction
    public TekiyoJogaishaAlive get適用除外者情報(ShikibetsuCode 識別コード) {
        DbV1002TekiyoJogaishaEntity result = dbv1002dac.get適用除外者情報(識別コード);
        if (result != null) {
            return new TekiyoJogaishaAlive(result);
        }
        return null;
    }

    /**
     * 事業者名称_事業者番号の取得です。
     *
     * @param 入所施設コード RString
     * @return KaigoJigyosha
     */
    @Transaction
    public KaigoJigyosha get事業者名称_入所施設コード(RString 入所施設コード) {
        DbT7060KaigoJigyoshaEntity result = dbt7060dac.get事業者名称_入所施設コード(入所施設コード);
        KaigoJigyoshaEntity kaigojigyoshaentity = new KaigoJigyoshaEntity();
        if (result != null) {
            kaigojigyoshaentity.set介護事業者Entity(result);
            return new KaigoJigyosha(kaigojigyoshaentity);
        }
        return null;
    }

    /**
     * 事業者名称_住所地特例対象施設の取得です。
     *
     * @param 入所施設コード RString
     * @param 住所地特例対象施設 RString
     * @return KaigoJogaiTokureiTaishoShisetsu
     */
    @Transaction
    public KaigoJogaiTokureiTaishoShisetsu get事業者名称_住所地特例対象施設(RString 入所施設コード, RString 住所地特例対象施設) {
        DbT1005KaigoJogaiTokureiTaishoShisetsuEntity result = dbt1005dac.get事業者名称_住所地特例対象施設(入所施設コード, 住所地特例対象施設);
        if (result != null) {
            return new KaigoJogaiTokureiTaishoShisetsu(result);
        }
        return null;
    }
}
