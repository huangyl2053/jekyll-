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
import jp.co.ndensan.reams.db.dbe.business.YokaigoninteiProgress;
import jp.co.ndensan.reams.db.dbe.business.YokaigoninteiProgressFactory;
import jp.co.ndensan.reams.db.dbe.business.YokaigoninteiProgressFactory.ParticularDates;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoNinteichosainNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5005NinteiShinchokuJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5006NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.mapper.NinteichosaKekkaTorikomiTaishoshaMapper;
import jp.co.ndensan.reams.db.dbe.entity.relate.KaigoNinteiShoriTaishoshaEntity;
import jp.co.ndensan.reams.db.dbe.persistence.basic.INinteiChosaIraiJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.relate.INinteichosaKekkaTorikomiTaishoshaDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;
import jp.co.ndensan.reams.ur.urz.realservice.IShikibetsuTaishoFinder;
import jp.co.ndensan.reams.ur.urz.realservice.ShikibetsuTaishoService;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 認定調査結果取込対象者を扱うクラスです。
 *
 * @author N8187 久保田 英男
 */
public class NinteichosaKekkaTorikomiTaishoshaManager {

    private final INinteiChosaIraiJohoDac chosaIraiJohoDac;
    private final INinteichosaKekkaTorikomiTaishoshaDac torikomiTaishoshaDac;
    private final KaigoNinteichosainManager kaigoNinteichosainManager;
    private final IShikibetsuTaishoFinder shikibetsuTaishoFinder;

    /**
     * コンストラクタです。
     */
    public NinteichosaKekkaTorikomiTaishoshaManager() {
        chosaIraiJohoDac = InstanceProvider.create(INinteiChosaIraiJohoDac.class);
        torikomiTaishoshaDac = InstanceProvider.create(INinteichosaKekkaTorikomiTaishoshaDac.class);
        kaigoNinteichosainManager = new KaigoNinteichosainManager();
        shikibetsuTaishoFinder = ShikibetsuTaishoService.getShikibetsuTaishoFinder();
    }

    /**
     * テスト用プライベートコンストラクタです。
     *
     * @param chosaIraiJohoDac chosaIraiJohoDac
     * @param torikomiTaishoshaDac torikomiTaishoshaDac
     * @param kaigoNinteichosainManager kaigoNinteichosainManager
     * @param shikibetsuTaishoFinder shikibetsuTaishoFinder
     */
    NinteichosaKekkaTorikomiTaishoshaManager(
            INinteiChosaIraiJohoDac chosaIraiJohoDac,
            INinteichosaKekkaTorikomiTaishoshaDac torikomiTaishoshaDac,
            KaigoNinteichosainManager kaigoNinteichosainManager,
            IShikibetsuTaishoFinder shikibetsuTaishoFinder) {
        this.chosaIraiJohoDac = chosaIraiJohoDac;
        this.torikomiTaishoshaDac = torikomiTaishoshaDac;
        this.kaigoNinteichosainManager = kaigoNinteichosainManager;
        this.shikibetsuTaishoFinder = shikibetsuTaishoFinder;
    }

    /**
     * 認定調査結果取込対象者を全件取得します。
     *
     * @return 認定調査結果取込対象者全件
     */
    public List<NinteichosaKekkaTorikomiTaishosha> get認定調査結果取込対象者全件() {

        List<KaigoNinteiShoriTaishoshaEntity> torikomiTaishoshaEntityList = torikomiTaishoshaDac.selectAll();
        return create認定調査結果取込対象者List(torikomiTaishoshaEntityList);
    }

    /**
     * 認定調査結果取込対象者を証記載保険者番号を指定して全件取得します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return 認定調査結果取込対象者全件
     */
    public List<NinteichosaKekkaTorikomiTaishosha> get認定調査結果取込対象者全件(ShoKisaiHokenshaNo 証記載保険者番号) {
        List<KaigoNinteiShoriTaishoshaEntity> torikomiTaishoshaEntityList = torikomiTaishoshaDac.select証記載保険者番号(証記載保険者番号);
        return create認定調査結果取込対象者List(torikomiTaishoshaEntityList);
    }

    /**
     * 認定調査結果取込対象者を、証記載保険者番号と支所コードを指定して全件取得します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 支所コード 支所コード
     * @return 認定調査結果取込対象者全件
     */
    public List<NinteichosaKekkaTorikomiTaishosha> get認定調査結果取込対象者全件(ShoKisaiHokenshaNo 証記載保険者番号, RString 支所コード) {
        List<KaigoNinteiShoriTaishoshaEntity> torikomiTaishoshaEntityList = torikomiTaishoshaDac.select証記載保険者番号及び支所コード(証記載保険者番号, 支所コード);
        return create認定調査結果取込対象者List(torikomiTaishoshaEntityList);
    }

    /**
     * 認定調査結果取込対象者の進捗を完了状態にするために、要介護認定進捗情報の認定調査完了年月日を更新します。
     *
     * @param 認定調査結果取込対象者 認定調査結果取込対象者
     * @param 認定調査完了年月日 認定調査完了年月日
     * @return true:更新OK, false:更新NG
     */
    public boolean save認定調査完了年月日(NinteichosaKekkaTorikomiTaishosha 認定調査結果取込対象者, FlexibleDate 認定調査完了年月日) {
        YokaigoninteiProgressFactory factory = new YokaigoninteiProgressFactory(認定調査結果取込対象者.get認定進捗情報());
        YokaigoninteiProgress yokaigoninteiProgress = factory.createYokaigoninteiPorgressWith(
                ParticularDates.認定調査完了年月日, 認定調査完了年月日);
        return new YokaigoninteiProgressManager().save(yokaigoninteiProgress);
    }

    private List<NinteichosaKekkaTorikomiTaishosha> create認定調査結果取込対象者List(
            List<KaigoNinteiShoriTaishoshaEntity> entityList) {
        List<NinteichosaKekkaTorikomiTaishosha> list = new ArrayList<>();

        for (KaigoNinteiShoriTaishoshaEntity entity : entityList) {
            DbT5005NinteiShinchokuJohoEntity shinchokuEntity = entity.getNinteiShinchokuJohoEntity();
            DbT5001NinteiShinseiJohoEntity shinseiJohoEntity = entity.getNinteiShinseiJohoEntity();
            DbT5006NinteichosaIraiJohoEntity iraiJohoEntity = get認定調査依頼情報Entity(
                    entity.getNinteiShinchokuJohoEntity(),
                    shinseiJohoEntity);
            KaigoNinteichosain kaigoNinteichosain = get介護認定調査員(
                    shinseiJohoEntity,
                    iraiJohoEntity);
            IKojin kojin = shikibetsuTaishoFinder.get識別対象(
                    shinseiJohoEntity.getShikibetsuCode()).to個人();

            list.add(NinteichosaKekkaTorikomiTaishoshaMapper.toNinteichosaKekkaTorikomiTaishosha(
                    shinchokuEntity,
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
        return kaigoNinteichosainManager.get介護認定調査員(
                shinseiJohoEntity.getShoKisaiHokenshaNo(),
                iraiJohoEntity.getNinteichosaItakusakiCode(),
                new KaigoNinteichosainNo(iraiJohoEntity.getChousainCode().value()));
    }
}
