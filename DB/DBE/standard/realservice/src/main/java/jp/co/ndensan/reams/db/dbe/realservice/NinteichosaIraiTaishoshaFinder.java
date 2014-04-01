/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaIraiTaishosha;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5005NinteiShinchokuJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5006NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7010NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.mapper.NinteichosaIraiTaishoshaMapper;
import jp.co.ndensan.reams.db.dbe.persistence.basic.INinteiShinchokuJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.INinteichosaItakusakiDac;
import jp.co.ndensan.reams.db.dbe.persistence.basic.INinteiChosaIraiJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.basic.INinteiShinseiJohoDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoJigyoshaNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.persistence.relate.INinteiChosaIraiTaishoshaDac;
import jp.co.ndensan.reams.ur.urf.entity.basic.ChosainJohoEntity;
import jp.co.ndensan.reams.ur.urf.entity.basic.KaigoJigyoshaEntity;
import jp.co.ndensan.reams.ur.urf.persistence.basic.IChosainJohoDac;
import jp.co.ndensan.reams.ur.urf.persistence.basic.IKaigoJigyoshaDac;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.ur.urz.realservice.KojinService;
//import jp.co.ndensan.reams.ur.urz.persistence.basic.IKojinDac;
//import jp.co.ndensan.reams.ur.urz.realservice.KojinService;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceCreator;

/**
 * 認定調査依頼対象者情報を管理するクラスです。
 *
 * @author N8187 久保田 英男
 */
public class NinteichosaIraiTaishoshaFinder {

    private final INinteiShinchokuJohoDac shinchokuJohoDac;
    private final INinteiShinseiJohoDac shinseiJohoDac;
    private final INinteichosaItakusakiDac itakusakiDac;
    private final INinteiChosaIraiJohoDac iraiJohoDac;
    private final INinteiChosaIraiTaishoshaDac iraiTaishoshaDac;
//    private final IKojinDac kojinDac;
//    private final KojinService kojinService;
    private final IKaigoJigyoshaDac kaigoJigyoshaDac;
    private final IChosainJohoDac chosainJohoDac;

    /**
     * コンストラクタです。
     *
     */
    public NinteichosaIraiTaishoshaFinder() {
        shinchokuJohoDac = InstanceCreator.create(INinteiShinchokuJohoDac.class);
        shinseiJohoDac = InstanceCreator.create(INinteiShinseiJohoDac.class);
        itakusakiDac = InstanceCreator.create(INinteichosaItakusakiDac.class);
        iraiJohoDac = InstanceCreator.create(INinteiChosaIraiJohoDac.class);
        iraiTaishoshaDac = InstanceCreator.create(INinteiChosaIraiTaishoshaDac.class);
//        kojinDac = InstanceCreator.create(IKojinDac.class);
        kaigoJigyoshaDac = InstanceCreator.create(IKaigoJigyoshaDac.class);
        chosainJohoDac = InstanceCreator.create(IChosainJohoDac.class);
    }

    /**
     * テスト用のコンストラクタです。
     *
     * @param shinchokuJohoDac 進捗情報DAC
     * @param shinseiJohoDac 申請情報DAC
     * @param itakusakiDac 委託先DAC
     * @param iraiJohoDac 依頼情報DAC
     * @param iraiTaishoshaDac 認定調査依頼対象者を取得するDAC
     * @param kojinDac 個人DAC
     * @param kaigoJigyoshaDac 介護事業者DAC
     * @param chosainJohoDac 調査員情報DAC
     */
    NinteichosaIraiTaishoshaFinder(
            INinteiShinchokuJohoDac shinchokuJohoDac,
            INinteiShinseiJohoDac shinseiJohoDac,
            INinteichosaItakusakiDac itakusakiDac,
            INinteiChosaIraiJohoDac iraiJohoDac,
            INinteiChosaIraiTaishoshaDac iraiTaishoshaDac,
            //            IKojinDac kojinDac,
            IKaigoJigyoshaDac kaigoJigyoshaDac,
            IChosainJohoDac chosainJohoDac) {
        this.shinchokuJohoDac = shinchokuJohoDac;
        this.shinseiJohoDac = shinseiJohoDac;
        this.itakusakiDac = itakusakiDac;
        this.iraiJohoDac = iraiJohoDac;
        this.iraiTaishoshaDac = iraiTaishoshaDac;
//        this.kojinDac = kojinDac;
        this.kaigoJigyoshaDac = kaigoJigyoshaDac;
        this.chosainJohoDac = chosainJohoDac;
    }

    /**
     * 証記載保険者番号を指定して、認定調査依頼が未完了の認定調査依頼対象者を取得します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return NinteichosaIraiTaishoshaのList
     * @throws NullPointerException {@code 証記載保険者番号}がnullの場合
     */
    public List<NinteichosaIraiTaishosha> get認定調査依頼対象者証記載保険者番号指定(ShoKisaiHokenshaNo 証記載保険者番号) throws NullPointerException {
        requireNonNull(証記載保険者番号, Messages.E00001.replace("証記載保険者番号").getMessage());

        List<DbT5005NinteiShinchokuJohoEntity> 要介護認定進捗情報EntityList = iraiTaishoshaDac.select(証記載保険者番号);
        if (要介護認定進捗情報EntityList.isEmpty()) {
            return Collections.EMPTY_LIST;
        }

        return create認定調査依頼対象者List(要介護認定進捗情報EntityList);
    }

    /**
     * 認定調査依頼が未完了の認定調査依頼対象者を取得します。
     *
     * @return NinteichosaIraiTaishoshaのList
     */
    public List<NinteichosaIraiTaishosha> get認定調査依頼対象者全件() {
        List<DbT5005NinteiShinchokuJohoEntity> 要介護認定進捗情報EntityList = shinchokuJohoDac.select認定調査未完了();
        if (要介護認定進捗情報EntityList.isEmpty()) {
            return Collections.EMPTY_LIST;
        }

        return create認定調査依頼対象者List(要介護認定進捗情報EntityList);
    }

    private List<NinteichosaIraiTaishosha> create認定調査依頼対象者List(List<DbT5005NinteiShinchokuJohoEntity> 要介護認定進捗情報EntityList)
            throws NullPointerException {
        List<NinteichosaIraiTaishosha> list = new ArrayList<>();

        for (DbT5005NinteiShinchokuJohoEntity entity : 要介護認定進捗情報EntityList) {

            DbT5001NinteiShinseiJohoEntity 認定申請情報Entity = shinseiJohoDac.select(entity.getShinseishoKanriNo());
//            KojinEntity 個人Entity = kojinDac.select最新(認定申請情報Entity.getShoKisaiHokenshaNo().getValue());
//            KojinEntity 個人Entity = KojinService.createKojinFinder().get個人(認定申請情報Entity.getShikibetsuCode());
            IKojin 個人 = KojinService.createKojinFinder().get個人(認定申請情報Entity.getShikibetsuCode());
            NinteichosaIraiRirekiNo ninteichosaIraiRirekiNo = 認定申請情報Entity.getNinteichosaIraiRirekiNo();
            DbT5006NinteichosaIraiJohoEntity 認定調査依頼情報Entity = iraiJohoDac.select(
                    認定申請情報Entity.getShinseishoKanriNo().getColumnValue(),
                    ninteichosaIraiRirekiNo);
            DbT7010NinteichosaItakusakiJohoEntity 認定委託先情報Entity = create認定調査委託先(認定申請情報Entity, 認定調査依頼情報Entity);
            KaigoJigyoshaEntity 介護事業者Entity = create介護事業者(認定調査依頼情報Entity);
            ChosainJohoEntity 調査員情報Entity = create調査員情報(認定申請情報Entity, 認定調査依頼情報Entity);

            list.add(NinteichosaIraiTaishoshaMapper.toNinteichosaIraiTaishosha(
                    認定申請情報Entity, 個人,
                    認定委託先情報Entity, 介護事業者Entity, 調査員情報Entity));
        }
        return list;
    }

    private DbT7010NinteichosaItakusakiJohoEntity create認定調査委託先(
            DbT5001NinteiShinseiJohoEntity shinseiJohoEntity,
            DbT5006NinteichosaIraiJohoEntity chosaIraiJohoEntity) {
        boolean isUncreatable = isNull(shinseiJohoEntity) || isNull(chosaIraiJohoEntity);
        return isUncreatable ? null
                : itakusakiDac.select(
                shinseiJohoEntity.getShoKisaiHokenshaNo().getValue(),
                new KaigoJigyoshaNo(chosaIraiJohoEntity.getNinteichosaItakusakiCode().getColumnValue()),
                true);
    }

    private KaigoJigyoshaEntity create介護事業者(
            DbT5006NinteichosaIraiJohoEntity chosaIraiJohoEntity) {
        return isNull(chosaIraiJohoEntity) ? null
                : kaigoJigyoshaDac.select特定の事業者番号の事業者(
                chosaIraiJohoEntity.getNinteichosaItakusakiCode().getColumnValue()).get(0);
    }

    private ChosainJohoEntity create調査員情報(
            DbT5001NinteiShinseiJohoEntity shinseiJohoEntity,
            DbT5006NinteichosaIraiJohoEntity chosaIraiJohoEntity) {
        boolean isUncreatable = isNull(shinseiJohoEntity) || isNull(chosaIraiJohoEntity);
        return isUncreatable ? null
                : chosainJohoDac.selectByAllKey(
                shinseiJohoEntity.getShoKisaiHokenshaNo().getValue(),
                chosaIraiJohoEntity.getNinteichosaItakusakiCode().getColumnValue(),
                chosaIraiJohoEntity.getChousainCode().getColumnValue());
    }

    private static <T> boolean isNull(T object) {
        return object == null;
    }
}
