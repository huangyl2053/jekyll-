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
public class KaigoNinteiChosainManager implements IKaigoNinteiChosainManager {

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

    @Override
    public KaigoNinteiChosain get介護認定調査員(ShichosonCode 市町村コード, KaigoJigyoshaNo 介護事業者番号, KaigoChosainNo 介護調査員番号) {
        DbT7013ChosainJohoEntity chosainJohoEntity = chosainDac.select(市町村コード, 介護事業者番号, 介護調査員番号);
        DbT7010NinteichosaItakusakiJohoEntity itakusakiEntity = itakusakiDac.select(市町村コード.getValue(), 介護事業者番号, true);
        return KaigoNinteiChosainMapper.toKaigoNinteiChosain(chosainJohoEntity, itakusakiEntity);
    }

    @Override
    public KaigoNinteiChosain get介護認定調査員(ShichosonCode 市町村コード, KaigoJigyoshaNo 介護事業者番号, KaigoChosainNo 介護調査員番号, ChosainJokyo 調査員の状況) {
        DbT7013ChosainJohoEntity chosainJohoEntity = chosainDac.select(市町村コード, 介護事業者番号, 介護調査員番号, 調査員の状況);
        DbT7010NinteichosaItakusakiJohoEntity itakusakiEntity = itakusakiDac.select(市町村コード.getValue(), 介護事業者番号, true);
        return KaigoNinteiChosainMapper.toKaigoNinteiChosain(chosainJohoEntity, itakusakiEntity);
    }

    @Override
    public KaigoNinteiChosainCollection get介護認定調査員List(ShichosonCode 市町村コード, KaigoJigyoshaNo 介護事業者番号) {
        List<DbT7013ChosainJohoEntity> entityList = chosainDac.selectAll(市町村コード, 介護事業者番号);
        return create介護認定調査員List(entityList);
    }

    @Override
    public KaigoNinteiChosainCollection get介護認定調査員List(ShichosonCode 市町村コード, KaigoJigyoshaNo 介護事業者番号, ChosainJokyo 調査員の状況) {
        List<DbT7013ChosainJohoEntity> entityList = chosainDac.selectAll(市町村コード, 介護事業者番号, 調査員の状況);
        return create介護認定調査員List(entityList);
    }

    @Override
    public KaigoNinteiChosainCollection get介護認定調査員List(ShichosonCode 市町村コード, ChosainJokyo 調査員の状況) {
        List<DbT7013ChosainJohoEntity> entityList = chosainDac.selectAll(市町村コード, 調査員の状況);
        return create介護認定調査員List(entityList);
    }

    @Override
    public KaigoNinteiChosainCollection get介護認定調査員List(ShichosonCode 市町村コード) {
        List<DbT7013ChosainJohoEntity> entityList = chosainDac.selectAll(市町村コード);
        return create介護認定調査員List(entityList);
    }

    @Override
    public boolean save(KaigoNinteiChosain 介護認定調査員情報) {
        DbT7013ChosainJohoEntity entity = KaigoNinteiChosainMapper.toKaigoNinteiChosainEntity(介護認定調査員情報);
        return is更新成功(chosainDac.insertOrUpdate(entity));
    }

    @Override
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
