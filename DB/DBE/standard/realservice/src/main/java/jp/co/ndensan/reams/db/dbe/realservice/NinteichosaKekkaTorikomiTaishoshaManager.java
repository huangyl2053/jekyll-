/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.KaigoNinteichosain;
import jp.co.ndensan.reams.db.dbe.business.YokaigoNinteiShinsei;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaIrai;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaKekkaTorikomiTaishosha;
import jp.co.ndensan.reams.db.dbe.business.YokaigoNinteiProgress;
import jp.co.ndensan.reams.db.dbe.business.YokaigoNinteiProgressFactory;
import jp.co.ndensan.reams.db.dbe.business.YokaigoNinteiProgressFactory.ParticularDates;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoNinteichosainNo;
import jp.co.ndensan.reams.db.dbe.entity.mapper.NinteiShinchokuJohoMapper;
import jp.co.ndensan.reams.db.dbe.entity.mapper.YokaigoNinteiShinseiMapper;
import jp.co.ndensan.reams.db.dbe.entity.relate.KaigoNinteiShoriTaishoshaEntity;
import jp.co.ndensan.reams.db.dbe.persistence.relate.NinteichosaKekkaTorikomiTaishoshaDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.ur.urz.realservice.IKojinFinder;
import jp.co.ndensan.reams.ur.urz.realservice.KojinService;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 認定調査結果取込対象者を扱うクラスです。
 *
 * @author N8187 久保田 英男
 */
public class NinteichosaKekkaTorikomiTaishoshaManager {

    private final NinteichosaKekkaTorikomiTaishoshaDac torikomiTaishoshaDac;
    private final NinteichosaIraiManager ninteichosaIraiManager;
    private final KaigoNinteichosainManager kaigoNinteichosainManager;
    private final IKojinFinder kojinFinder;
    private final YokaigoNinteiProgressManager yokaigoninteiProgressManager;

    /**
     * コンストラクタです。
     */
    public NinteichosaKekkaTorikomiTaishoshaManager() {
        torikomiTaishoshaDac = InstanceProvider.create(NinteichosaKekkaTorikomiTaishoshaDac.class);
        ninteichosaIraiManager = new NinteichosaIraiManager();
        kaigoNinteichosainManager = new KaigoNinteichosainManager();
        kojinFinder = KojinService.createKojinFinder();
        yokaigoninteiProgressManager = new YokaigoNinteiProgressManager();
    }

    /**
     * テスト用プライベートコンストラクタです。
     *
     * @param torikomiTaishoshaDac torikomiTaishoshaDac
     * @param ninteichosaIraiManager ninteichosaIraiManager
     * @param kaigoNinteichosainManager kaigoNinteichosainManager
     * @param kojinFinder kojinFinder
     * @param yokaigoninteiProgressManager yokaigoninteiProgressManager
     */
    NinteichosaKekkaTorikomiTaishoshaManager(
            NinteichosaKekkaTorikomiTaishoshaDac torikomiTaishoshaDac,
            NinteichosaIraiManager ninteichosaIraiManager,
            KaigoNinteichosainManager kaigoNinteichosainManager,
            IKojinFinder kojinFinder,
            YokaigoNinteiProgressManager yokaigoninteiProgressManager) {
        this.torikomiTaishoshaDac = torikomiTaishoshaDac;
        this.ninteichosaIraiManager = ninteichosaIraiManager;
        this.kaigoNinteichosainManager = kaigoNinteichosainManager;
        this.kojinFinder = kojinFinder;
        this.yokaigoninteiProgressManager = yokaigoninteiProgressManager;
    }

    /**
     * 認定調査結果取込対象者を取得します。
     *
     * @param 市町村コード 市町村コード
     * @return 認定調査結果取込対象者リスト
     */
    public List<NinteichosaKekkaTorikomiTaishosha> get認定調査結果取込対象者(
            LasdecCode 市町村コード) throws NullPointerException {
        requireNonNull(市町村コード, Messages.E00001.replace("市町村コード").getMessage());
        List<KaigoNinteiShoriTaishoshaEntity> torikomiTaishoshaEntityList = torikomiTaishoshaDac.selectAll();

        return create認定調査結果取込対象者List(市町村コード, torikomiTaishoshaEntityList);
    }

    /**
     * 証記載保険者番号を指定して、認定調査結果取込対象者を取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 証記載保険者番号 証記載保険者番号
     * @return 認定調査結果取込対象者リスト
     * @throws NullPointerException 引数がnullの場合
     */
    public List<NinteichosaKekkaTorikomiTaishosha> get認定調査結果取込対象者(LasdecCode 市町村コード, ShoKisaiHokenshaNo 証記載保険者番号) throws NullPointerException {
        requireNonNull(市町村コード, Messages.E00001.replace("市町村コード").getMessage());
        requireNonNull(証記載保険者番号, Messages.E00001.replace("証記載保険者番号").getMessage());
        List<KaigoNinteiShoriTaishoshaEntity> torikomiTaishoshaEntityList = torikomiTaishoshaDac.select証記載保険者番号(証記載保険者番号);
        return create認定調査結果取込対象者List(市町村コード, torikomiTaishoshaEntityList);
    }

    /**
     * 市町村コードと証記載保険者番号と支所コードを指定して、認定調査結果取込対象者を取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 証記載保険者番号 証記載保険者番号
     * @param 支所コード 支所コード
     * @return 認定調査結果取込対象者リスト
     * @throws NullPointerException 引数がnullの場合
     */
    public List<NinteichosaKekkaTorikomiTaishosha> get認定調査結果取込対象者(
            LasdecCode 市町村コード, ShoKisaiHokenshaNo 証記載保険者番号, RString 支所コード) throws NullPointerException {
        requireNonNull(市町村コード, Messages.E00001.replace("市町村コード").getMessage());
        requireNonNull(証記載保険者番号, Messages.E00001.replace("証記載保険者番号").getMessage());
        requireNonNull(支所コード, Messages.E00001.replace("支所コード").getMessage());
        List<KaigoNinteiShoriTaishoshaEntity> torikomiTaishoshaEntityList = torikomiTaishoshaDac.select証記載保険者番号及び支所コード(証記載保険者番号, 支所コード);
        return create認定調査結果取込対象者List(市町村コード, torikomiTaishoshaEntityList);
    }

    /**
     * 認定調査結果取込対象者の進捗を完了状態にするために、要介護認定進捗情報の認定調査完了年月日を更新します。
     *
     * @param 認定調査結果取込対象者 認定調査結果取込対象者
     * @param 認定調査完了年月日 認定調査完了年月日
     * @return true:更新OK, false:更新NG
     */
    public boolean save認定調査完了年月日(NinteichosaKekkaTorikomiTaishosha 認定調査結果取込対象者, FlexibleDate 認定調査完了年月日) {
        YokaigoNinteiProgressFactory factory = new YokaigoNinteiProgressFactory(認定調査結果取込対象者.get認定進捗情報());
        YokaigoNinteiProgress yokaigoninteiProgress = factory.createYokaigoninteiPorgressWith(
                ParticularDates.認定調査完了年月日, 認定調査完了年月日);
        return yokaigoninteiProgressManager.save(yokaigoninteiProgress);
    }

    private List<NinteichosaKekkaTorikomiTaishosha> create認定調査結果取込対象者List(
            LasdecCode 市町村コード,
            List<KaigoNinteiShoriTaishoshaEntity> entityList) {
        List<NinteichosaKekkaTorikomiTaishosha> list = new ArrayList<>();

        for (KaigoNinteiShoriTaishoshaEntity entity : entityList) {
            list.add(create認定調査結果取込対象者(市町村コード, entity));
        }

        if (list.isEmpty()) {
            return Collections.EMPTY_LIST;
        }

        return list;
    }

    private NinteichosaKekkaTorikomiTaishosha create認定調査結果取込対象者(
            LasdecCode 市町村コード,
            KaigoNinteiShoriTaishoshaEntity entity) {
        YokaigoNinteiProgress 認定進捗情報 = NinteiShinchokuJohoMapper.toNinteiShinchokuJoho(entity.getNinteiShinchokuJohoEntity());
        YokaigoNinteiShinsei 認定申請情報 = YokaigoNinteiShinseiMapper.toYokaigoNinteiShinsei(entity.getNinteiShinseiJohoEntity());
        NinteichosaIrai 認定調査依頼情報 = get認定調査依頼情報(認定進捗情報, 認定申請情報);
        KaigoNinteichosain 介護認定調査員 = get介護認定調査員(市町村コード, 認定調査依頼情報);
        IKojin 個人 = get個人(認定申請情報);
        return new NinteichosaKekkaTorikomiTaishosha(
                認定進捗情報,
                認定申請情報,
                認定調査依頼情報,
                介護認定調査員,
                個人);
    }

    private IKojin get個人(YokaigoNinteiShinsei 認定申請情報) {
        return kojinFinder.get個人(認定申請情報.get識別コード());
    }

    private NinteichosaIrai get認定調査依頼情報(
            YokaigoNinteiProgress yokaigoninteiProgress,
            YokaigoNinteiShinsei shinseiJoho) {
        return ninteichosaIraiManager.get認定調査依頼情報(
                yokaigoninteiProgress.get申請書管理番号(),
                shinseiJoho.get認定調査依頼履歴番号());
    }

    private KaigoNinteichosain get介護認定調査員(
            LasdecCode 市町村コード,
            NinteichosaIrai iraiJoho) {
        return kaigoNinteichosainManager.get介護認定調査員(
                市町村コード,
                iraiJoho.get認定調査委託先コード(),
                new KaigoNinteichosainNo(iraiJoho.get調査員番号コード().value()));
    }
}
