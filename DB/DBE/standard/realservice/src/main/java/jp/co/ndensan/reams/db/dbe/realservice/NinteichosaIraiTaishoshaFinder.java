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
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoJigyoshaNo;
import jp.co.ndensan.reams.db.dbe.persistence.relate.IGetNinteiChosaIraiTaishoshaDac;
import jp.co.ndensan.reams.ur.urf.entity.basic.ChosainJohoEntity;
import jp.co.ndensan.reams.ur.urf.entity.basic.KaigoJigyoshaEntity;
import jp.co.ndensan.reams.ur.urf.persistence.basic.IChosainJohoDac;
import jp.co.ndensan.reams.ur.urf.persistence.basic.IKaigoJigyoshaDac;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.ur.urz.entity.basic.KojinEntity;
import jp.co.ndensan.reams.ur.urz.persistence.basic.IKojinDac;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceCreator;

/**
 * 認定調査依頼対象者情報を管理するクラスです
 *
 * @author N8187 久保田 英男
 */
public class NinteichosaIraiTaishoshaFinder {

    private final INinteiShinchokuJohoDac shinchokuJohoDac;
    private final INinteiShinseiJohoDac shinseiJohoDac;
    private final INinteichosaItakusakiDac itakusakiDac;
    private final INinteiChosaIraiJohoDac iraiJohoDac;
    private final IGetNinteiChosaIraiTaishoshaDac iraiTaishoshaDac;
    private final IKojinDac kojinDac;
    private final IKaigoJigyoshaDac kaigoJigyoshaDac;
    private final IChosainJohoDac chosainJohoDac;

    /**
     * コンストラクタクラスです
     *
     */
    public NinteichosaIraiTaishoshaFinder() {
        shinchokuJohoDac = InstanceCreator.create(INinteiShinchokuJohoDac.class);
        shinseiJohoDac = InstanceCreator.create(INinteiShinseiJohoDac.class);
        itakusakiDac = InstanceCreator.create(INinteichosaItakusakiDac.class);
        iraiJohoDac = InstanceCreator.create(INinteiChosaIraiJohoDac.class);
        iraiTaishoshaDac = InstanceCreator.create(IGetNinteiChosaIraiTaishoshaDac.class);
        kojinDac = InstanceCreator.create(IKojinDac.class);
        kaigoJigyoshaDac = InstanceCreator.create(IKaigoJigyoshaDac.class);
        chosainJohoDac = InstanceCreator.create(IChosainJohoDac.class);
    }

    /**
     * テスト用のコンストラクタクラスです
     *
     * @param shinchokuJohoDac 進捗情報DAC
     * @param shinseiJohoDac 申請情報DAC
     * @param itakusakiDac 委託先DAC
     * @param iraiJohoDac 依頼情報DAC
     * @param kojinDac 個人DAC
     * @param kaigoJigyoshaDac 介護事業者DAC
     * @param chosainJohoDac 調査員情報DAC
     */
    NinteichosaIraiTaishoshaFinder(
            INinteiShinchokuJohoDac shinchokuJohoDac,
            INinteiShinseiJohoDac shinseiJohoDac,
            INinteichosaItakusakiDac itakusakiDac,
            INinteiChosaIraiJohoDac iraiJohoDac,
            IGetNinteiChosaIraiTaishoshaDac iraiTaishoshaDac,
            IKojinDac kojinDac,
            IKaigoJigyoshaDac kaigoJigyoshaDac,
            IChosainJohoDac chosainJohoDac) {
        this.shinchokuJohoDac = shinchokuJohoDac;
        this.shinseiJohoDac = shinseiJohoDac;
        this.itakusakiDac = itakusakiDac;
        this.iraiJohoDac = iraiJohoDac;
        this.iraiTaishoshaDac = iraiTaishoshaDac;
        this.kojinDac = kojinDac;
        this.kaigoJigyoshaDac = kaigoJigyoshaDac;
        this.chosainJohoDac = chosainJohoDac;
    }

    /**
     * 市町村コードを指定して、認定調査依頼が未完了の認定調査依頼対象者を取得します
     *
     * @param 市町村コード 市町村コード
     * @return NinteichosaIraiTaishoshaのList
     * @throws NullPointerException {@code 市町村コード}がnullの場合
     */
    public List<NinteichosaIraiTaishosha> get認定調査依頼対象者市町村指定(ShichosonCode 市町村コード) throws NullPointerException {
        requireNonNull(市町村コード, Messages.E00001.replace("市町村コード").getMessage());

        List<DbT5005NinteiShinchokuJohoEntity> 要介護認定進捗情報EntityList = iraiTaishoshaDac.select(市町村コード);
        if (要介護認定進捗情報EntityList.isEmpty()) {
            return Collections.EMPTY_LIST;
        }

        return create認定調査依頼対象者List(要介護認定進捗情報EntityList);
    }

    /**
     * 認定調査依頼が未完了の認定調査依頼対象者を取得します
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

    private List<NinteichosaIraiTaishosha> create認定調査依頼対象者List(List<DbT5005NinteiShinchokuJohoEntity> 要介護認定進捗情報EntityList) throws NullPointerException {
        List<NinteichosaIraiTaishosha> list = new ArrayList<>();
        DbT7010NinteichosaItakusakiJohoEntity 認定委託先情報Entity;
        KaigoJigyoshaEntity 介護事業者Entity;
        ChosainJohoEntity 調査員情報Entity;

        for (DbT5005NinteiShinchokuJohoEntity entity : 要介護認定進捗情報EntityList) {
            DbT5001NinteiShinseiJohoEntity 認定申請情報Entity = shinseiJohoDac.select(entity.getShinseishoKanriNo());
            KojinEntity 個人Enity = kojinDac.select最新(認定申請情報Entity.getShichosonCode().getValue());
            DbT5006NinteichosaIraiJohoEntity 認定調査依頼情報Entity = iraiJohoDac.select(
                    認定申請情報Entity.getShinseishoKanriNo().getColumnValue(),
                    認定申請情報Entity.getNinteichosaIraiRirekiNo());

            if (認定調査依頼情報Entity != null) {
                認定委託先情報Entity = itakusakiDac.select(認定申請情報Entity.getShichosonCode().getValue(),
                        new KaigoJigyoshaNo(認定調査依頼情報Entity.get認定調査委託先コード()), true);
                介護事業者Entity = kaigoJigyoshaDac.select特定の事業者番号の事業者(認定調査依頼情報Entity.get認定調査委託先コード()).get(0);
                調査員情報Entity = chosainJohoDac.selectByAllKey(認定申請情報Entity.getShichosonCode().getValue(),
                        認定調査依頼情報Entity.get認定調査委託先コード(),
                        認定調査依頼情報Entity.get調査員番号コード());
            } else {
                認定委託先情報Entity = null;
                介護事業者Entity = null;
                調査員情報Entity = null;
            }

            list.add(NinteichosaIraiTaishoshaMapper.toNinteichosaIraiTaishosha(認定申請情報Entity, 個人Enity,
                    認定委託先情報Entity, 介護事業者Entity, 調査員情報Entity));
        }
        return list;
    }
}
