/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.KaigoNinteichosain;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaKekkaTorikomiTaishosha;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoNinteichosainNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5005NinteiShinchokuJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5006NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.mapper.NinteichosaKekkaTorikomiTaishoshaMapper;
import jp.co.ndensan.reams.db.dbe.entity.relate.KaigoNinteiTaishoshaEntity;
import jp.co.ndensan.reams.db.dbe.persistence.basic.INinteiChosaIraiJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.relate.INinteichosaKekkaTorikomiTaishoshaDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;
import jp.co.ndensan.reams.ur.urz.realservice.KojinService;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 認定調査結果取込対象者を扱うクラスです。
 *
 * @author N8187 久保田 英男
 */
public class NinteichosaKekkaTorikomiTaishoshaFinder {

    private final INinteiChosaIraiJohoDac chosaIraiJohoDac;
    private final INinteichosaKekkaTorikomiTaishoshaDac torikomiTaishoshaDac;

    /**
     * コンストラクタです。
     */
    public NinteichosaKekkaTorikomiTaishoshaFinder() {
        chosaIraiJohoDac = InstanceProvider.create(INinteiChosaIraiJohoDac.class);
        torikomiTaishoshaDac = InstanceProvider.create(INinteichosaKekkaTorikomiTaishoshaDac.class);
    }

    /**
     * テスト用プライベートコンストラクタです。
     *
     * @param chosaIraiJohoDac chosaIraiJohoDac
     * @param torikomiTaishoshaDac torikomiTaishoshaDac
     */
    NinteichosaKekkaTorikomiTaishoshaFinder(
            INinteiChosaIraiJohoDac chosaIraiJohoDac,
            INinteichosaKekkaTorikomiTaishoshaDac torikomiTaishoshaDac) {
        this.chosaIraiJohoDac = chosaIraiJohoDac;
        this.torikomiTaishoshaDac = torikomiTaishoshaDac;
    }

    /**
     * 認定調査結果取込対象者を全件取得します。
     *
     * @return 認定調査結果取込対象者全件
     */
    public List<NinteichosaKekkaTorikomiTaishosha> get認定調査結果取込対象者全件() {

        List<KaigoNinteiTaishoshaEntity> torikomiTaishoshaEntityList = torikomiTaishoshaDac.selectAll();
        return create認定調査結果取込対象者List(torikomiTaishoshaEntityList);
    }

    /**
     * 認定調査結果取込対象者を市町村コードを指定して全件取得します。
     *
     * @param 市町村コード 市町村コード
     * @return 認定調査結果取込対象者全件
     */
    public List<NinteichosaKekkaTorikomiTaishosha> get認定調査結果取込対象者全件(ShichosonCode 市町村コード) {
        List<KaigoNinteiTaishoshaEntity> torikomiTaishoshaEntityList = torikomiTaishoshaDac.select市町村コード(市町村コード);
        return create認定調査結果取込対象者List(torikomiTaishoshaEntityList);
    }

    /**
     * 認定調査結果取込対象者を、市町村コードと支所コードを指定して全件取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 支所コード 支所コード
     * @return 認定調査結果取込対象者全件
     */
    public List<NinteichosaKekkaTorikomiTaishosha> get認定調査結果取込対象者全件(ShichosonCode 市町村コード, RString 支所コード) {
        List<KaigoNinteiTaishoshaEntity> torikomiTaishoshaEntityList = torikomiTaishoshaDac.select市町村コード及び支所コード(市町村コード, 支所コード);
        return create認定調査結果取込対象者List(torikomiTaishoshaEntityList);
    }

    private List<NinteichosaKekkaTorikomiTaishosha> create認定調査結果取込対象者List(
            List<KaigoNinteiTaishoshaEntity> entityList) {
        List<NinteichosaKekkaTorikomiTaishosha> list = new ArrayList<>();

        for (KaigoNinteiTaishoshaEntity entity : entityList) {
            DbT5001NinteiShinseiJohoEntity shinseiJohoEntity = entity.getNinteiShinseiJohoEntity();
            DbT5006NinteichosaIraiJohoEntity iraiJohoEntity = get認定調査依頼情報Entity(
                    entity.getNinteiShinchokuJohoEntity(),
                    shinseiJohoEntity);
            KaigoNinteichosain kaigoNinteichosain = get介護認定調査員(
                    shinseiJohoEntity,
                    iraiJohoEntity);
            IKojin kojin = KojinService.createKojinFinder().get個人(
                    shinseiJohoEntity.getShikibetsuCode());

            list.add(NinteichosaKekkaTorikomiTaishoshaMapper.toNinteichosaKekkaTorikomiTaishosha(
                    shinseiJohoEntity,
                    iraiJohoEntity,
                    kaigoNinteichosain,
                    kojin));
        }

        if (list.isEmpty()) {
            return Collections.EMPTY_LIST;
        }

        return list;
    }

    private DbT5006NinteichosaIraiJohoEntity get認定調査依頼情報Entity(
            DbT5005NinteiShinchokuJohoEntity shinchokuJohoEntity,
            DbT5001NinteiShinseiJohoEntity shinseiJohoEntity) {
        return chosaIraiJohoDac.select(
                shinchokuJohoEntity.getShinseishoKanriNo().value(),
                new NinteichosaIraiRirekiNo(shinseiJohoEntity.getNinteichosaIraiRirekiNo()));
    }

    private KaigoNinteichosain get介護認定調査員(
            DbT5001NinteiShinseiJohoEntity shinseiJohoEntity,
            DbT5006NinteichosaIraiJohoEntity iraiJohoEntity) {
        return new KaigoNinteichosainManager().get介護認定調査員(
                shinseiJohoEntity.getShichosonCode(),
                iraiJohoEntity.getNinteichosaItakusakiCode(),
                new KaigoNinteichosainNo(iraiJohoEntity.getChousainCode().value()));
    }
}
