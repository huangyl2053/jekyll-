/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaKekkaTorikomiTaishosha;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoNinteichosainNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5005NinteiShinchokuJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5006NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7010NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7013ChosainJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.mapper.NinteichosaKekkaTorikomiTaishoshaMapper;
import jp.co.ndensan.reams.db.dbe.persistence.INinteichosaItakusakiDac;
import jp.co.ndensan.reams.db.dbe.persistence.basic.IKaigoNinteichosainDac;
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
public class NinteichosaKekkaTorikomiTaishoshaManager {

    private final INinteiShinchokuJohoDac shinchokuJohoDac;
    private final INinteiShinseiJohoDac shinseiJohoDac;
    private final INinteiChosaIraiJohoDac chosaIraiJohoDac;
    private final IKaigoNinteichosainDac ninteichosainDac;
    private final INinteichosaItakusakiDac ninteichosaItakusakiDac;

    /**
     * デフォルトコンストラクタです。
     */
    public NinteichosaKekkaTorikomiTaishoshaManager() {
        shinchokuJohoDac = InstanceProvider.create(INinteiShinchokuJohoDac.class);
        shinseiJohoDac = InstanceProvider.create(INinteiShinseiJohoDac.class);
        chosaIraiJohoDac = InstanceProvider.create(INinteiChosaIraiJohoDac.class);
        ninteichosainDac = InstanceProvider.create(IKaigoNinteichosainDac.class);
        ninteichosaItakusakiDac = InstanceProvider.create(INinteichosaItakusakiDac.class);
    }

    /**
     * テスト用プライベートコンストラクタです。
     *
     * @param shinchokuJohoDac shinchokuJohoDac
     * @param shinseiJohoDac shinseiJohoDac
     * @param chosaIraiJohoDac chosaIraiJohoDac
     */
    NinteichosaKekkaTorikomiTaishoshaManager(
            INinteiShinchokuJohoDac shinchokuJohoDac,
            INinteiShinseiJohoDac shinseiJohoDac,
            INinteiChosaIraiJohoDac chosaIraiJohoDac,
            IKaigoNinteichosainDac ninteichosainDac,
            INinteichosaItakusakiDac ninteichosaItakusakiDac) {
        this.shinchokuJohoDac = shinchokuJohoDac;
        this.shinseiJohoDac = shinseiJohoDac;
        this.chosaIraiJohoDac = chosaIraiJohoDac;
        this.ninteichosainDac = ninteichosainDac;
        this.ninteichosaItakusakiDac = ninteichosaItakusakiDac;
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
            DbT7013ChosainJohoEntity chosainJohoEntity = get調査員情報Entity(shinseiJohoEntity, iraiJohoEntity);
            DbT7010NinteichosaItakusakiJohoEntity itakusakiJohoEntity = get認定調査委託先情報Entity(chosainJohoEntity);
            IKojin kojin = KojinService.createKojinFinder().get個人(shinseiJohoEntity.getShikibetsuCode());

            list.add(NinteichosaKekkaTorikomiTaishoshaMapper.toNinteichosaKekkaTorikomiTaishosha(
                    shinseiJohoEntity,
                    iraiJohoEntity,
                    chosainJohoEntity,
                    itakusakiJohoEntity,
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

    private DbT7013ChosainJohoEntity get調査員情報Entity(
            DbT5001NinteiShinseiJohoEntity shinseiJohoEntity,
            DbT5006NinteichosaIraiJohoEntity iraiJohoEntity) {
        return ninteichosainDac.select(
                shinseiJohoEntity.getShichosonCode(),
                iraiJohoEntity.getNinteichosaItakusakiCode(),
                new KaigoNinteichosainNo(iraiJohoEntity.getChousainCode().value()));
    }

    private DbT7010NinteichosaItakusakiJohoEntity get認定調査委託先情報Entity(
            DbT7013ChosainJohoEntity chosainJohoEntity) {
        return ninteichosaItakusakiDac.select(
                chosainJohoEntity.getShichosonCode().getValue(),
                chosainJohoEntity.getKaigoJigyoshaNo(), true);
    }
}
