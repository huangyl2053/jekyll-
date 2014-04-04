/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.KaigoIryoKikan;
import jp.co.ndensan.reams.db.dbe.business.KaigoIryoKikanCollection;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IryoKikanJokyo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.db.dbe.entity.mapper.KaigoIryoKikanMapper;
import jp.co.ndensan.reams.db.dbe.entity.relate.KaigoIryoKikanEntity;
import jp.co.ndensan.reams.db.dbe.persistence.relate.IKaigoIryoKikanDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.ur.urz.business.IKoza;
import jp.co.ndensan.reams.ur.urz.realservice.IKozaManager;
import jp.co.ndensan.reams.ur.urz.realservice.KozaService;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 介護医療機関の情報を取得するクラスです。
 *
 * @author n8178 城間篤人
 */
public class KaigoIryoKikanFinder implements IKaigoIryoKikanFinder {

    private final IKaigoIryoKikanDac dac;
    private final IKozaManager kozaManager;

    /**
     * デフォルトコンストラクタです。
     */
    public KaigoIryoKikanFinder() {
        dac = InstanceProvider.create(IKaigoIryoKikanDac.class);
        kozaManager = KozaService.createKozaManager();
    }

    /**
     * テスト用パッケージプライベートコンストラクタです。
     */
    KaigoIryoKikanFinder(IKaigoIryoKikanDac dac, IKozaManager kozaManager) {
        this.dac = dac;
        this.kozaManager = kozaManager;
    }

    @Override
    public KaigoIryoKikan get介護医療機関(ShichosonCode 市町村コード, KaigoIryoKikanCode 介護医療機関コード) {
        KaigoIryoKikanEntity entity = dac.select(市町村コード, 介護医療機関コード);
        return create介護医療機関(entity);
    }

    @Override
    public KaigoIryoKikan get介護医療機関(ShichosonCode 市町村コード, KaigoIryoKikanCode 介護医療機関コード, IryoKikanJokyo 医療機関状況) {
        KaigoIryoKikanEntity entity = dac.select(市町村コード, 介護医療機関コード, 医療機関状況);
        return create介護医療機関(entity);
    }

    @Override
    public KaigoIryoKikanCollection get介護医療機関Collection(ShichosonCode 市町村コード) {
        List<KaigoIryoKikanEntity> entities = dac.select(市町村コード);
        return new KaigoIryoKikanCollection(create介護医療機関List(entities));
    }

    @Override
    public KaigoIryoKikanCollection get介護医療機関Collection(ShichosonCode 市町村コード, IryoKikanJokyo 医療機関状況) {
        List<KaigoIryoKikanEntity> entities = dac.select(市町村コード, 医療機関状況);
        return new KaigoIryoKikanCollection(create介護医療機関List(entities));
    }

    private KaigoIryoKikan create介護医療機関(KaigoIryoKikanEntity entity) {
        if (entity == null) {
            return null;
        }

        //TODO n8178 城間篤人 基準日をどうするか確認する。また、これ以外のget口座を利用するのかもしれないため、要検討。 2014年2月末
//        List<IKoza> kozaList = kozaManager.get口座(RDate.MIN, create識別コード(entity));
        List<IKoza> kozaList = kozaManager.get口座(RDate.MIN, entity.getIryoKikanEntity().getShikibetsuCode());
        return KaigoIryoKikanMapper.toKaigoIryoKikan(entity, kozaList);
    }

//    //医療機関Entityが修正され、識別コードを直接とってこれるようになったらこの処理は不要 2014年2月末
//    private ShikibetsuCode create識別コード(KaigoIryoKikanEntity entity) {
//        if (entity == null) {
//            return null;
//        }
//        return new ShikibetsuCode(entity.getIryoKikanEntity().getShikibetsuCode());
//    }
    private List<KaigoIryoKikan> create介護医療機関List(List<KaigoIryoKikanEntity> entities) {
        List<KaigoIryoKikan> iryoKikanList = new ArrayList<>();
        for (KaigoIryoKikanEntity entity : entities) {
            iryoKikanList.add(create介護医療機関(entity));
        }
        return iryoKikanList;
    }
}
