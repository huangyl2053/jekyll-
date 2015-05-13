/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.IShujii;
import jp.co.ndensan.reams.db.dbe.business.KaigoDoctor;
import jp.co.ndensan.reams.db.dbe.business.KaigoDoctorCollection;
import jp.co.ndensan.reams.db.dbe.business.KaigoIryoKikan;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IshiJokyo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoDoctorCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.db.dbe.business.mapper.ShujiiMapper;
import jp.co.ndensan.reams.db.dbe.entity.relate.KaigoDoctorEntity;
import jp.co.ndensan.reams.db.dbe.persistence.relate.KaigoDoctorDac;
//import jp.co.ndensan.reams.ur.urz.business.IDoctor;
//import jp.co.ndensan.reams.ur.urz.business.mapper.DoctorMapper;
//import jp.co.ndensan.reams.ur.urz.realservice.DoctorManagerFactory;
//import jp.co.ndensan.reams.ur.urz.realservice.IDoctorManager;
import jp.co.ndensan.reams.ur.urz.realservice.search.ISearchCondition;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 介護医師情報を管理するクラスです。
 *
 * @author N8156 宮本 康
 */
public class KaigoDoctorManager implements IKaigoDoctorManager {
    //TODO　介護医師はなくなるため、暫定的にコメントアウト。実装作業にはいった差異にこのクラスを削除する。

    private final KaigoDoctorDac kaigoDoctorDac;
//    private final IDoctorManager doctorManager;
    private final IShujiiManager shujiiManager;
    private final IKaigoIryoKikanFinder kaigoIryoKikanFinder;

    /**
     * InstanceCreatorを用いてDacのインスタンスを生成し、メンバ変数に保持します。
     */
    public KaigoDoctorManager() {
        kaigoDoctorDac = InstanceProvider.create(KaigoDoctorDac.class);
//        doctorManager = DoctorManagerFactory.createInstance();
        shujiiManager = new ShujiiManager();
        kaigoIryoKikanFinder = new KaigoIryoKikanFinder();
    }

    /**
     * モックを使用するテスト用コンストラクタです。
     *
     * @param kaigoDoctorDac モック介護医師情報Dac
     * @param doctorManager モック医師情報Manager
     * @param shujiiManager モック主治医情報Manager
     * @param kaigoIryoKikanFinder モック介護医療機関情報Finder
     */
    KaigoDoctorManager(
            KaigoDoctorDac kaigoDoctorDac,
            //            IDoctorManager doctorManager,
            IShujiiManager shujiiManager,
            IKaigoIryoKikanFinder kaigoIryoKikanFinder) {
        this.kaigoDoctorDac = kaigoDoctorDac;
//        this.doctorManager = doctorManager;
        this.shujiiManager = shujiiManager;
        this.kaigoIryoKikanFinder = kaigoIryoKikanFinder;
    }

    @Override
    public KaigoDoctor get介護医師(LasdecCode 市町村コード, KaigoIryoKikanCode 介護医療機関コード, KaigoDoctorCode 介護医師コード) {
        return get介護医師(kaigoDoctorDac.select(市町村コード, 介護医療機関コード, 介護医師コード));
    }

    @Override
    public KaigoDoctor get介護医師(
            LasdecCode 市町村コード, KaigoIryoKikanCode 介護医療機関コード, KaigoDoctorCode 介護医師コード, IshiJokyo 医師の状況) {
        return get介護医師(kaigoDoctorDac.select(市町村コード, 介護医療機関コード, 介護医師コード, 医師の状況));
    }

    @Override
    public KaigoDoctorCollection get介護医師リストOf(LasdecCode 市町村コード, KaigoIryoKikanCode 介護医療機関コード) {
        return get介護医師Collection(kaigoDoctorDac.select(市町村コード, 介護医療機関コード));
    }

    @Override
    public KaigoDoctorCollection get介護医師リストOf(LasdecCode 市町村コード, KaigoIryoKikanCode 介護医療機関コード, IshiJokyo 医師の状況) {
        return get介護医師Collection(kaigoDoctorDac.select(市町村コード, 介護医療機関コード, 医師の状況));
    }

    @Override
    public KaigoDoctorCollection get介護医師リストOf(LasdecCode 市町村コード) {
        return get介護医師Collection(kaigoDoctorDac.select(市町村コード));
    }

    @Override
    public KaigoDoctorCollection get介護医師リストOf(LasdecCode 市町村コード, IshiJokyo 医師の状況) {
        return get介護医師Collection(kaigoDoctorDac.select(市町村コード, 医師の状況));
    }

    @Override
    public KaigoDoctorCollection get介護医師リストOf(ISearchCondition searchCondtion) {
        return get介護医師Collection(kaigoDoctorDac.select(searchCondtion.makeSearchCondition()));
    }

    @Override
    public boolean save(KaigoDoctor 介護医師情報) {
        //TODO KaigoDoctorコメントアウトされている
//        return doctorManager.save(介護医師情報.get医師()) && shujiiManager.save(介護医師情報.get主治医());
        return false;
    }

    @Override
    public boolean remove(KaigoDoctor 介護医師情報) {
        //TODO KaigoDoctorコメントアウトされている
//        return doctorManager.remove(介護医師情報.get医師()) && shujiiManager.remove(介護医師情報.get主治医());
        return false;
    }

    private KaigoDoctorCollection get介護医師Collection(List<KaigoDoctorEntity> entityList) {
        List<KaigoDoctor> list = new ArrayList<>();
        for (KaigoDoctorEntity entity : entityList) {
            list.add(get介護医師(entity));
        }
        return new KaigoDoctorCollection(list);
    }

    private KaigoDoctor get介護医師(KaigoDoctorEntity entity) {
        if (entity == null) {
            return null;
        }
        //TODO n8235船山洋介　IDoctorが存在しないため、コメントアウト
//        IDoctor doctor = DoctorMapper.toDoctor(entity.getDoctorEntity());
//        IShujii shujii = ShujiiMapper.toShujii(entity.getDbT7012ShujiiJohoEntity());
//        KaigoIryoKikan kaigoIryoKikan = kaigoIryoKikanFinder.get介護医療機関(shujii.get市町村コード(), shujii.get介護医療機関コード());
        //TODO KaigoDoctorコメントアウトされている
//        return new KaigoDoctor(doctor, shujii, kaigoIryoKikan);
        return null;
    }
}
