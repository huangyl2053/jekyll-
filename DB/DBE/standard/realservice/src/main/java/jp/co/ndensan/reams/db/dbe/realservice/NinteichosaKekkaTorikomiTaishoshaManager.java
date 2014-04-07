/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.KaigoNinteichosain;
import jp.co.ndensan.reams.db.dbe.business.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaIrai;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaKekkaTorikomiTaishosha;
import jp.co.ndensan.reams.db.dbe.business.YokaigoninteiProgress;
import jp.co.ndensan.reams.db.dbe.business.YokaigoninteiProgressFactory;
import jp.co.ndensan.reams.db.dbe.business.YokaigoninteiProgressFactory.ParticularDates;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoNinteichosainNo;
import jp.co.ndensan.reams.db.dbe.entity.mapper.NinteiShinchokuJohoMapper;
import jp.co.ndensan.reams.db.dbe.entity.mapper.NinteishinseiJohoMapper;
import jp.co.ndensan.reams.db.dbe.entity.relate.KaigoNinteiShoriTaishoshaEntity;
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

    private final INinteichosaKekkaTorikomiTaishoshaDac torikomiTaishoshaDac;
    private final NinteichosaIraiManager ninteichosaIraiManager;
    private final KaigoNinteichosainManager kaigoNinteichosainManager;
    private final IShikibetsuTaishoFinder shikibetsuTaishoFinder;

    /**
     * コンストラクタです。
     */
    public NinteichosaKekkaTorikomiTaishoshaManager() {
        torikomiTaishoshaDac = InstanceProvider.create(INinteichosaKekkaTorikomiTaishoshaDac.class);
        ninteichosaIraiManager = new NinteichosaIraiManager();
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
            INinteichosaKekkaTorikomiTaishoshaDac torikomiTaishoshaDac,
            NinteichosaIraiManager ninteichosaIraiManager,
            KaigoNinteichosainManager kaigoNinteichosainManager,
            IShikibetsuTaishoFinder shikibetsuTaishoFinder) {
        this.torikomiTaishoshaDac = torikomiTaishoshaDac;
        this.ninteichosaIraiManager = ninteichosaIraiManager;
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
            YokaigoninteiProgress yokaigoninteiProgress = NinteiShinchokuJohoMapper.toNinteiShinchokuJoho(entity.getNinteiShinchokuJohoEntity());
            NinteiShinseiJoho shinseiJoho = NinteishinseiJohoMapper.to認定申請情報(entity.getNinteiShinseiJohoEntity());
            NinteichosaIrai iraiJoho = get認定調査依頼情報(yokaigoninteiProgress, shinseiJoho);
            KaigoNinteichosain kaigoNinteichosain = get介護認定調査員(shinseiJoho, iraiJoho);
            IKojin kojin = shikibetsuTaishoFinder.get識別対象(shinseiJoho.get識別コード()).to個人();

            list.add(new NinteichosaKekkaTorikomiTaishosha(
                    yokaigoninteiProgress, shinseiJoho, iraiJoho,
                    kaigoNinteichosain, kojin));
        }

        if (list.isEmpty()) {
            return Collections.EMPTY_LIST;
        }

        return list;
    }

    private NinteichosaIrai get認定調査依頼情報(
            YokaigoninteiProgress yokaigoninteiProgress,
            NinteiShinseiJoho shinseiJoho) {
        return ninteichosaIraiManager.get認定調査依頼情報(
                yokaigoninteiProgress.get申請書管理番号(),
                shinseiJoho.get認定調査依頼履歴番号());
    }

    private KaigoNinteichosain get介護認定調査員(
            NinteiShinseiJoho shinseiJoho,
            NinteichosaIrai iraiJoho) {
        return kaigoNinteichosainManager.get介護認定調査員(
                shinseiJoho.get証記載保険者番号(),
                iraiJoho.get認定調査委託先コード(),
                new KaigoNinteichosainNo(iraiJoho.get調査員番号コード().value()));
    }
}
