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
import jp.co.ndensan.reams.db.dbe.persistence.basic.INinteiChosaIraiJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.basic.INinteiShinchokuJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.basic.INinteiShinseiJohoDac;
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

    private final INinteiShinchokuJohoDac shinchokuJohoDac;
    private final INinteiShinseiJohoDac shinseiJohoDac;
    private final INinteiChosaIraiJohoDac chosaIraiJohoDac;

    /**
     * デフォルトコンストラクタです。
     */
    public NinteichosaKekkaTorikomiTaishoshaFinder() {
        shinchokuJohoDac = InstanceProvider.create(INinteiShinchokuJohoDac.class);
        shinseiJohoDac = InstanceProvider.create(INinteiShinseiJohoDac.class);
        chosaIraiJohoDac = InstanceProvider.create(INinteiChosaIraiJohoDac.class);
    }

    /**
     * テスト用プライベートコンストラクタです。
     *
     * @param shinchokuJohoDac shinchokuJohoDac
     * @param shinseiJohoDac shinseiJohoDac
     * @param chosaIraiJohoDac chosaIraiJohoDac
     */
    NinteichosaKekkaTorikomiTaishoshaFinder(
            INinteiShinchokuJohoDac shinchokuJohoDac,
            INinteiShinseiJohoDac shinseiJohoDac,
            INinteiChosaIraiJohoDac chosaIraiJohoDac) {
        this.shinchokuJohoDac = shinchokuJohoDac;
        this.shinseiJohoDac = shinseiJohoDac;
        this.chosaIraiJohoDac = chosaIraiJohoDac;
    }

    /**
     * 認定調査結果取込対象者を全件取得します。
     *
     * @param 支所コード 支所コード
     * @return 認定調査結果取込対象者全件
     */
    public List<NinteichosaKekkaTorikomiTaishosha> get認定調査結果取込対象者全件(RString 支所コード) {

        List<DbT5005NinteiShinchokuJohoEntity> shinchokuJohoEntityList = shinchokuJohoDac.select依頼済認定調査未完了();

        return create認定調査結果取込対象者List(shinchokuJohoEntityList, 支所コード);
    }

    private List<NinteichosaKekkaTorikomiTaishosha> create認定調査結果取込対象者List(
            List<DbT5005NinteiShinchokuJohoEntity> entityList, RString 支所コード) {
        List<NinteichosaKekkaTorikomiTaishosha> list = new ArrayList<>();

        for (DbT5005NinteiShinchokuJohoEntity shinchokuJohoEntity : entityList) {
            DbT5001NinteiShinseiJohoEntity shinseiJohoEntity = shinseiJohoDac.select(shinchokuJohoEntity.getShinseishoKanriNo());
            if (!shinseiJohoEntity.getShishoCode().equals(支所コード)) {
                continue;
            }
            DbT5006NinteichosaIraiJohoEntity iraiJohoEntity = get認定調査依頼情報Entity(shinchokuJohoEntity, shinseiJohoEntity);
            KaigoNinteichosain kaigoNinteichosain = get介護認定調査員(shinseiJohoEntity, iraiJohoEntity);
            IKojin kojin = KojinService.createKojinFinder().get個人(shinseiJohoEntity.getShikibetsuCode());

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
