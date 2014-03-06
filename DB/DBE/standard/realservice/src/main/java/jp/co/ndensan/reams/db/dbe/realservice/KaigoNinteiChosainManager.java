/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.KaigoNinteiChosain;
import jp.co.ndensan.reams.db.dbe.business.KaigoNinteiChosainCollection;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosainJokyo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoChosainNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoJigyoshaNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7010NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7013ChosainJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.mapper.KaigoNinteiChosainMapper;
import jp.co.ndensan.reams.db.dbe.persistence.INinteichosaItakusakiDac;
import jp.co.ndensan.reams.db.dbe.persistence.basic.IKaigoNinteiChosainDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceCreator;

/**
 * 介護認定調査員情報を扱うクラスです。
 *
 * @author N8187 久保田 英男
 */
public class KaigoNinteiChosainManager {

    private final IKaigoNinteiChosainDac chosainDac;
    private final INinteichosaItakusakiDac itakusakiDac;

    /**
     * デフォルトコンストラクタです。
     */
    public KaigoNinteiChosainManager() {
        chosainDac = InstanceCreator.create(IKaigoNinteiChosainDac.class);
        itakusakiDac = InstanceCreator.create(INinteichosaItakusakiDac.class);
    }

    /**
     * テスト用プライベートコンストラクタです。
     *
     * @param dac テスト用DAC
     */
    KaigoNinteiChosainManager(IKaigoNinteiChosainDac chosainDac, INinteichosaItakusakiDac itakusakiDac) {
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
    public KaigoNinteiChosain get介護認定調査員(ShichosonCode 市町村コード, KaigoJigyoshaNo 介護事業者番号, KaigoChosainNo 介護調査員番号) {
        DbT7013ChosainJohoEntity chosainJohoEntity = chosainDac.select(市町村コード, 介護事業者番号, 介護調査員番号);
        DbT7010NinteichosaItakusakiJohoEntity itakusakiEntity = itakusakiDac.select(市町村コード.getValue(), 介護事業者番号, true);
        return KaigoNinteiChosainMapper.toKaigoNinteiChosain(chosainJohoEntity, itakusakiEntity);
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
    public KaigoNinteiChosain get介護認定調査員(ShichosonCode 市町村コード, KaigoJigyoshaNo 介護事業者番号, KaigoChosainNo 介護調査員番号, ChosainJokyo 調査員の状況) {
        DbT7013ChosainJohoEntity chosainJohoEntity = chosainDac.select(市町村コード, 介護事業者番号, 介護調査員番号, 調査員の状況);
        DbT7010NinteichosaItakusakiJohoEntity itakusakiEntity = itakusakiDac.select(市町村コード.getValue(), 介護事業者番号, true);
        return KaigoNinteiChosainMapper.toKaigoNinteiChosain(chosainJohoEntity, itakusakiEntity);
    }

    /**
     * 引数の条件に該当する介護認定調査員情報のコレクションクラスを取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 介護事業者番号 介護事業者番号
     * @return 介護認定調査員のコレクションクラス
     */
    public KaigoNinteiChosainCollection get介護認定調査員List(ShichosonCode 市町村コード, KaigoJigyoshaNo 介護事業者番号) {
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
    public KaigoNinteiChosainCollection get介護認定調査員List(ShichosonCode 市町村コード, KaigoJigyoshaNo 介護事業者番号, ChosainJokyo 調査員の状況) {
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
    public KaigoNinteiChosainCollection get介護認定調査員List(ShichosonCode 市町村コード, ChosainJokyo 調査員の状況) {
        List<DbT7013ChosainJohoEntity> entityList = chosainDac.selectAll(市町村コード, 調査員の状況);
        return create介護認定調査員List(entityList);
    }

    /**
     * 引数の条件に該当する介護認定調査員情報のコレクションクラスを取得します。
     *
     * @param 市町村コード 市町村コード
     * @return 介護認定調査員のコレクションクラス
     */
    public KaigoNinteiChosainCollection get介護認定調査員List(ShichosonCode 市町村コード) {
        List<DbT7013ChosainJohoEntity> entityList = chosainDac.selectAll(市町村コード);
        return create介護認定調査員List(entityList);
    }

    /**
     * 引数の介護認定調査員情報を新規登録、または更新します。
     *
     * @param 介護認定調査員情報 介護認定調査員情報
     * @return 新規登録、または更新が成功した場合はtrueを返します。
     */
    public boolean save(KaigoNinteiChosain 介護認定調査員情報) {
        DbT7013ChosainJohoEntity entity = KaigoNinteiChosainMapper.toKaigoNinteiChosainEntity(介護認定調査員情報);
        return is更新成功(chosainDac.insertOrUpdate(entity));
    }

    /**
     * 引数の介護認定調査員情報を削除します。
     *
     * @param 介護認定調査員情報 介護認定調査員情報
     * @return 削除が成功した場合はtrueを返します。
     */
    public boolean remove(KaigoNinteiChosain 介護認定調査員情報) {
        DbT7013ChosainJohoEntity entity = KaigoNinteiChosainMapper.toKaigoNinteiChosainEntity(介護認定調査員情報);
        return is更新成功(chosainDac.delete(entity));
    }

    private KaigoNinteiChosainCollection create介護認定調査員List(List<DbT7013ChosainJohoEntity> entityList) {
        List<KaigoNinteiChosain> chosainList = new ArrayList<>();

        for (DbT7013ChosainJohoEntity chosainEntity : entityList) {
            DbT7010NinteichosaItakusakiJohoEntity itakusakiEntity =
                    itakusakiDac.select(chosainEntity.getShichosonCode().getValue(), chosainEntity.getKaigoJigyoshaNo(), true);
            chosainList.add(KaigoNinteiChosainMapper.toKaigoNinteiChosain(chosainEntity, itakusakiEntity));
        }

        return new KaigoNinteiChosainCollection(chosainList);
    }

    private boolean is更新成功(int 更新件数) {
        return 更新件数 != 0 ? true : false;
    }
}
