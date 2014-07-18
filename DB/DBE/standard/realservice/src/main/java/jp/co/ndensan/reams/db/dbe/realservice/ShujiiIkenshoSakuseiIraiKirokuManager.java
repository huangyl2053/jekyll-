/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.KaigoDoctor;
import jp.co.ndensan.reams.db.dbe.business.YokaigoNinteiShinsei;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIkenshoSakuseiIrai;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.IkenshosakuseiIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5011ShujiiIkenshoIraiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.mapper.YokaigoNinteiShinseiMapper;
import jp.co.ndensan.reams.db.dbe.entity.mapper.ShujiiIkenshoSakuseiIraiJohoMapper;
import jp.co.ndensan.reams.db.dbe.persistence.basic.INinteiShinseiJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.basic.IShujiiIkenshoIraiJohoDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoDoctorCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 主治医意見書作成依頼記録を管理するクラスです。
 *
 * @author N8156 宮本 康
 */
public class ShujiiIkenshoSakuseiIraiKirokuManager {

    private final IShujiiIkenshoIraiJohoDac iraiDac;
    private final INinteiShinseiJohoDac shinseiDac;
    private final KaigoDoctorManager kaigoDoctorManager;

    /**
     * InstanceCreatorを用いてDacのインスタンスを生成し、メンバ変数に保持します。
     */
    public ShujiiIkenshoSakuseiIraiKirokuManager() {
        iraiDac = InstanceProvider.create(IShujiiIkenshoIraiJohoDac.class);
        shinseiDac = InstanceProvider.create(INinteiShinseiJohoDac.class);
        kaigoDoctorManager = new KaigoDoctorManager();
    }

    /**
     * モックを使用するテスト用コンストラクタです。
     *
     * @param iraiDac 主治医意見書作成依頼情報Dac
     * @param shinseiDac 認定申請情報Dac
     */
    ShujiiIkenshoSakuseiIraiKirokuManager(
            IShujiiIkenshoIraiJohoDac iraiDac, INinteiShinseiJohoDac shinseiDac, KaigoDoctorManager kaigoDoctorManager) {
        this.iraiDac = iraiDac;
        this.shinseiDac = shinseiDac;
        this.kaigoDoctorManager = kaigoDoctorManager;
    }

    /**
     * 引数の条件に該当する主治医意見書作成依頼情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 意見書作成依頼履歴番号 意見書作成依頼履歴番号
     * @return 主治医意見書作成依頼情報
     */
    public ShujiiIkenshoSakuseiIrai get主治医意見書作成依頼情報(ShinseishoKanriNo 申請書管理番号, IkenshosakuseiIraiRirekiNo 意見書作成依頼履歴番号) {
        return getShujiiIkenshoSakuseiIrai(iraiDac.select(申請書管理番号, 意見書作成依頼履歴番号));
    }

    /**
     * 引数の条件に該当する主治医意見書作成依頼情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 主治医意見書作成依頼情報
     */
    public List<ShujiiIkenshoSakuseiIrai> get主治医意見書作成依頼情報By申請書管理番号(ShinseishoKanriNo 申請書管理番号) {
        return getShujiiIkenshoSakuseiIraiList(iraiDac.selectBy申請書管理番号(申請書管理番号));
    }

    /**
     * 引数の条件に該当する主治医意見書作成依頼情報を取得します。
     *
     * @param 意見書作成依頼年月日 意見書作成依頼年月日
     * @return 主治医意見書作成依頼情報
     */
    public List<ShujiiIkenshoSakuseiIrai> get主治医意見書作成依頼情報By依頼年月日(FlexibleDate 意見書作成依頼年月日) {
        return getShujiiIkenshoSakuseiIraiList(iraiDac.selectBy依頼年月日(意見書作成依頼年月日));
    }

    /**
     * 引数の条件に該当する主治医意見書作成依頼情報を取得します。
     *
     * @param 介護医療機関コード 介護医療機関コード
     * @param 介護医師コード 介護医師コード
     * @return 主治医意見書作成依頼情報
     */
    public List<ShujiiIkenshoSakuseiIrai> get主治医意見書作成依頼情報By主治医情報(KaigoIryoKikanCode 介護医療機関コード, KaigoDoctorCode 介護医師コード) {
        return getShujiiIkenshoSakuseiIraiList(iraiDac.selectBy主治医情報(介護医療機関コード, 介護医師コード));
    }

    /**
     * 引数の条件に該当する主治医意見書作成依頼情報を取得します。
     *
     * @param 意見書作成督促年月日 意見書作成督促年月日
     * @return 主治医意見書作成依頼情報
     */
    public List<ShujiiIkenshoSakuseiIrai> get主治医意見書作成依頼情報By督促年月日(FlexibleDate 意見書作成督促年月日) {
        return getShujiiIkenshoSakuseiIraiList(iraiDac.selectBy督促年月日(意見書作成督促年月日));
    }

    /**
     * 引数の主治医意見書作成依頼情報を追加、または更新します。
     *
     * @param 主治医意見書作成依頼情報 主治医意見書作成依頼情報
     * @return 追加、または更新が成功した場合はtrueを返します。
     */
    public boolean save(ShujiiIkenshoSakuseiIrai 主治医意見書作成依頼情報) {
        return iraiDac.insertOrUpdate(ShujiiIkenshoSakuseiIraiJohoMapper.toDbT5011ShujiiIkenshoIraiJohoEntity(主治医意見書作成依頼情報)) != 0;
    }

    /**
     * 引数の条件に該当する認定申請情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 認定申請情報
     */
    public YokaigoNinteiShinsei get認定申請情報(ShinseishoKanriNo 申請書管理番号) {
        DbT5001NinteiShinseiJohoEntity entity = shinseiDac.select(申請書管理番号);
        return entity == null ? null : YokaigoNinteiShinseiMapper.to認定申請情報(entity);
    }

    /**
     * 引数の認定申請情報を更新します。
     *
     * @param 認定申請情報 認定申請情報
     * @return 更新が成功した場合はtrueを返します。
     */
    public boolean save(YokaigoNinteiShinsei 認定申請情報) {
        return shinseiDac.insert(YokaigoNinteiShinseiMapper.to認定申請情報Entity(認定申請情報)) != 0;
    }

    private ShujiiIkenshoSakuseiIrai getShujiiIkenshoSakuseiIrai(DbT5011ShujiiIkenshoIraiJohoEntity iraiEntity) {
        if (iraiEntity == null) {
            return null;
        }
        DbT5001NinteiShinseiJohoEntity shinseiEntity = shinseiDac.select(iraiEntity.getShinseishoKanriNo());
        if (shinseiEntity == null) {
            return null;
        }
        KaigoDoctor kaigoDoctor = kaigoDoctorManager.get介護医師(shinseiEntity.getShoKisaiHokenshaNo(),
                new KaigoIryoKikanCode(iraiEntity.getKaigoIryokikanCode()), new KaigoDoctorCode(iraiEntity.getKaigoIshiCode()));
        if (kaigoDoctor == null) {
            return null;
        }
        return ShujiiIkenshoSakuseiIraiJohoMapper.toShujiiIkenshoSakuseiIrai(iraiEntity, kaigoDoctor);
    }

    private List<ShujiiIkenshoSakuseiIrai> getShujiiIkenshoSakuseiIraiList(List<DbT5011ShujiiIkenshoIraiJohoEntity> iraiEntityList) {
        List<ShujiiIkenshoSakuseiIrai> list = new ArrayList<>();
        for (DbT5011ShujiiIkenshoIraiJohoEntity entity : iraiEntityList) {
            ShujiiIkenshoSakuseiIrai sakuseiIrai = getShujiiIkenshoSakuseiIrai(entity);
            if (sakuseiIrai != null) {
                list.add(sakuseiIrai);
            }
        }
        return list;
    }
}
