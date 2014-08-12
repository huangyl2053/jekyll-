/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.KaigoNinteichosain;
import jp.co.ndensan.reams.db.dbe.business.KaigoNinteichosainCollection;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosainJokyo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoNinteichosainNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoJigyoshaNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7010NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7013ChosainJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.mapper.KaigoNinteichosainMapper;
import jp.co.ndensan.reams.db.dbe.persistence.NinteichosaItakusakiDac;
import jp.co.ndensan.reams.db.dbe.persistence.basic.KaigoNinteichosainDac;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 介護認定調査員情報を扱うクラスです。
 *
 * @author N8187 久保田 英男
 */
public class KaigoNinteichosainManager {

    private final KaigoNinteichosainDac chosainDac;
    private final NinteichosaItakusakiDac itakusakiDac;

    /**
     * デフォルトコンストラクタです。
     */
    public KaigoNinteichosainManager() {
        chosainDac = InstanceProvider.create(KaigoNinteichosainDac.class);
        itakusakiDac = InstanceProvider.create(NinteichosaItakusakiDac.class);
    }

    /**
     * テスト用プライベートコンストラクタです。
     *
     * @param dac テスト用DAC
     */
    KaigoNinteichosainManager(KaigoNinteichosainDac chosainDac, NinteichosaItakusakiDac itakusakiDac) {
        this.chosainDac = chosainDac;
        this.itakusakiDac = itakusakiDac;
    }

    /**
     * 引数の条件に該当する介護認定調査員情報を取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 介護事業者番号 介護事業者番号
     * @param 介護調査員番号 介護調査員番号
     * @return 介護認定調査員
     */
    public KaigoNinteichosain get介護認定調査員(LasdecCode 市町村コード, KaigoJigyoshaNo 介護事業者番号, KaigoNinteichosainNo 介護調査員番号) {
        DbT7013ChosainJohoEntity chosainJohoEntity = chosainDac.select(市町村コード, 介護事業者番号, 介護調査員番号);
        DbT7010NinteichosaItakusakiJohoEntity itakusakiEntity = itakusakiDac.select(市町村コード, 介護事業者番号, true);
        return KaigoNinteichosainMapper.toKaigoNinteichosain(chosainJohoEntity, itakusakiEntity);
    }

    /**
     * 引数の条件に該当する介護認定調査員情報を取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 介護事業者番号 介護事業者番号
     * @param 介護調査員番号 介護調査員番号
     * @param 調査員の状況 調査員の状況
     * @return 介護認定調査員
     */
    public KaigoNinteichosain get介護認定調査員(LasdecCode 市町村コード, KaigoJigyoshaNo 介護事業者番号, KaigoNinteichosainNo 介護調査員番号, ChosainJokyo 調査員の状況) {
        DbT7013ChosainJohoEntity chosainJohoEntity = chosainDac.select(市町村コード, 介護事業者番号, 介護調査員番号, 調査員の状況);
        DbT7010NinteichosaItakusakiJohoEntity itakusakiEntity = itakusakiDac.select(市町村コード, 介護事業者番号, true);
        return KaigoNinteichosainMapper.toKaigoNinteichosain(chosainJohoEntity, itakusakiEntity);
    }

    /**
     * 引数の条件に該当する介護認定調査員情報のコレクションクラスを取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 介護事業者番号 介護事業者番号
     * @return 介護認定調査員のコレクションクラス
     */
    public KaigoNinteichosainCollection get介護認定調査員List(LasdecCode 市町村コード, KaigoJigyoshaNo 介護事業者番号) {
        List<DbT7013ChosainJohoEntity> entityList = chosainDac.selectAll(市町村コード, 介護事業者番号);
        return create介護認定調査員List(entityList);
    }

    /**
     * 引数の条件に該当する介護認定調査員情報のコレクションクラスを取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 介護事業者番号 介護事業者番号
     * @param 調査員の状況 調査員の状況
     * @return 介護認定調査員のコレクションクラス
     */
    public KaigoNinteichosainCollection get介護認定調査員List(LasdecCode 市町村コード, KaigoJigyoshaNo 介護事業者番号, ChosainJokyo 調査員の状況) {
        List<DbT7013ChosainJohoEntity> entityList = chosainDac.selectAll(市町村コード, 介護事業者番号, 調査員の状況);
        return create介護認定調査員List(entityList);
    }

    /**
     * 引数の条件に該当する介護認定調査員情報のコレクションクラスを取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 調査員の状況 調査員の状況
     * @return 介護認定調査員のコレクションクラス
     */
    public KaigoNinteichosainCollection get介護認定調査員List(LasdecCode 市町村コード, ChosainJokyo 調査員の状況) {
        List<DbT7013ChosainJohoEntity> entityList = chosainDac.selectAll(市町村コード, 調査員の状況);
        return create介護認定調査員List(entityList);
    }

    /**
     * 引数の条件に該当する介護認定調査員情報のコレクションクラスを取得します。
     *
     * @param 市町村コード 市町村コード
     * @return 介護認定調査員のコレクションクラス
     */
    public KaigoNinteichosainCollection get介護認定調査員List(LasdecCode 市町村コード) {
        List<DbT7013ChosainJohoEntity> entityList = chosainDac.selectAll(市町村コード);
        return create介護認定調査員List(entityList);
    }

    /**
     * 引数の介護認定調査員情報を新規登録、または更新します。
     *
     * @param 介護認定調査員情報 介護認定調査員情報
     * @return 新規登録、または更新が成功した場合はtrueを返します。
     */
    public boolean save(KaigoNinteichosain 介護認定調査員情報) {
        DbT7013ChosainJohoEntity entity = KaigoNinteichosainMapper.toKaigoNinteichosainEntity(介護認定調査員情報);
        return is更新成功(chosainDac.insertOrUpdate(entity));
    }

    /**
     * 引数の介護認定調査員情報を削除します。
     *
     * @param 介護認定調査員情報 介護認定調査員情報
     * @return 削除が成功した場合はtrueを返します。
     */
    public boolean remove(KaigoNinteichosain 介護認定調査員情報) {
        DbT7013ChosainJohoEntity entity = KaigoNinteichosainMapper.toKaigoNinteichosainEntity(介護認定調査員情報);
        return is更新成功(chosainDac.delete(entity));
    }

    private KaigoNinteichosainCollection create介護認定調査員List(List<DbT7013ChosainJohoEntity> entityList) {
        List<KaigoNinteichosain> chosainList = new ArrayList<>();

        for (DbT7013ChosainJohoEntity chosainEntity : entityList) {
            DbT7010NinteichosaItakusakiJohoEntity itakusakiEntity = itakusakiDac.select(
                    chosainEntity.getShichosonCode(), new KaigoJigyoshaNo(chosainEntity.getKaigoJigyoshaNo()), true);
            chosainList.add(KaigoNinteichosainMapper.toKaigoNinteichosain(chosainEntity, itakusakiEntity));
        }

        return new KaigoNinteichosainCollection(chosainList);
    }

    private boolean is更新成功(int 更新件数) {
        return 更新件数 != 0 ? true : false;
    }
}
