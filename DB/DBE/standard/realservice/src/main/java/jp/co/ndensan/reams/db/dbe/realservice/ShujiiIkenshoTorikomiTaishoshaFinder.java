/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.KaigoDoctor;
import jp.co.ndensan.reams.db.dbe.business.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIkenshoSakuseiIrai;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIkenshoTorikomiTaishosha;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.IkenshosakuseiIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.mapper.NinteishinseiJohoMapper;
import jp.co.ndensan.reams.db.dbe.persistence.relate.IShujiiIkenshoTorikomiTaishoshaDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;
import jp.co.ndensan.reams.ur.urz.realservice.KojinService;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 主治医意見書取込対象者を扱うクラスです。
 *
 * @author N8187 久保田 英男
 */
public class ShujiiIkenshoTorikomiTaishoshaFinder {

    private final IShujiiIkenshoTorikomiTaishoshaDac torikomiTaishoshaDac;

    /**
     * コンストラクタです。
     */
    public ShujiiIkenshoTorikomiTaishoshaFinder() {
        torikomiTaishoshaDac = InstanceProvider.create(IShujiiIkenshoTorikomiTaishoshaDac.class);
    }

    /**
     * テスト用プライベートコンストラクタです。
     *
     * @param torikomiTaishoshaDac torikomiTaishoshaDac
     */
    ShujiiIkenshoTorikomiTaishoshaFinder(
            IShujiiIkenshoTorikomiTaishoshaDac torikomiTaishoshaDac) {
        this.torikomiTaishoshaDac = torikomiTaishoshaDac;
    }

    /**
     * 主治医意見書取込対象者を全件取得します。
     *
     * @return 主治医意見書取込対象者全件
     */
    public List<ShujiiIkenshoTorikomiTaishosha> get主治医意見書取込対象者全件() {
        List<DbT5001NinteiShinseiJohoEntity> torikomiTaishoshaEntityList = torikomiTaishoshaDac.selectAll();
        return create主治医意見書取込対象者List(torikomiTaishoshaEntityList);
    }

    /**
     * 主治医意見書取込対象者を市町村コードを指定して全件取得します。
     *
     * @param 市町村コード 市町村コード
     * @return 主治医意見書取込対象者全件
     */
    public List<ShujiiIkenshoTorikomiTaishosha> get主治医意見書取込対象者全件(ShichosonCode 市町村コード) {
        List<DbT5001NinteiShinseiJohoEntity> torikomiTaishoshaEntityList = torikomiTaishoshaDac.select市町村コード(市町村コード);
        return create主治医意見書取込対象者List(torikomiTaishoshaEntityList);
    }

    /**
     * 主治医意見書取込対象者を、市町村コードと支所コードを指定して全件取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 支所コード 支所コード
     * @return 主治医意見書取込対象者全件
     */
    public List<ShujiiIkenshoTorikomiTaishosha> get主治医意見書取込対象者全件(ShichosonCode 市町村コード, RString 支所コード) {
        List<DbT5001NinteiShinseiJohoEntity> torikomiTaishoshaEntityList = torikomiTaishoshaDac.select市町村コード及び支所コード(市町村コード, 支所コード);
        return create主治医意見書取込対象者List(torikomiTaishoshaEntityList);
    }

    private List<ShujiiIkenshoTorikomiTaishosha> create主治医意見書取込対象者List(
            List<DbT5001NinteiShinseiJohoEntity> entityList) {
        List<ShujiiIkenshoTorikomiTaishosha> list = new ArrayList<>();

        for (DbT5001NinteiShinseiJohoEntity entity : entityList) {
            list.add(create主治医意見書取込対象者(entity));
        }

        if (list.isEmpty()) {
            return Collections.EMPTY_LIST;
        }

        return list;
    }

    private ShujiiIkenshoTorikomiTaishosha create主治医意見書取込対象者(DbT5001NinteiShinseiJohoEntity shinseiEntity) {
        NinteiShinseiJoho ninteiShinseiJoho = NinteishinseiJohoMapper.to認定申請情報(shinseiEntity);
        ShujiiIkenshoSakuseiIrai shujiiIkenshoIraiJoho = new ShujiiIkenshoSakuseiIraiKirokuManager().get主治医意見書作成依頼情報(
                shinseiEntity.getShinseishoKanriNo(), new IkenshosakuseiIraiRirekiNo(shinseiEntity.getIkenshoIraiRirekiNo()));
        IKojin kojin = KojinService.createKojinFinder().get個人(shinseiEntity.getShikibetsuCode());
        KaigoDoctor doctor = shujiiIkenshoIraiJoho.get介護医師();

        return new ShujiiIkenshoTorikomiTaishosha(
                ninteiShinseiJoho, shujiiIkenshoIraiJoho, kojin, doctor);
    }
}
