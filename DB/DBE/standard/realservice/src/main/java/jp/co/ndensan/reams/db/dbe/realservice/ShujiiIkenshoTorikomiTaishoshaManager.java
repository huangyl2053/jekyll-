/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.KaigoDoctor;
import jp.co.ndensan.reams.db.dbe.business.YokaigoNinteiShinsei;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIkenshoSakuseiIrai;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIkenshoTorikomiTaishosha;
import jp.co.ndensan.reams.db.dbe.business.YokaigoNinteiProgress;
import jp.co.ndensan.reams.db.dbe.business.YokaigoNinteiProgressFactory;
import jp.co.ndensan.reams.db.dbe.business.YokaigoNinteiProgressFactory.ParticularDates;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.IkenshosakuseiIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.business.mapper.NinteiShinchokuJohoMapper;
import jp.co.ndensan.reams.db.dbe.business.mapper.YokaigoNinteiShinseiMapper;
import jp.co.ndensan.reams.db.dbe.entity.relate.KaigoNinteiShoriTaishoshaEntity;
import jp.co.ndensan.reams.db.dbe.persistence.relate.ShujiiIkenshoTorikomiTaishoshaDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.ur.urz.realservice.IKojinFinder;
import jp.co.ndensan.reams.ur.urz.realservice.KojinService;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 主治医意見書取込対象者を扱うクラスです。
 *
 * @author N8187 久保田 英男
 */
public class ShujiiIkenshoTorikomiTaishoshaManager {

    private final ShujiiIkenshoTorikomiTaishoshaDac torikomiTaishoshaDac;
    private final ShujiiIkenshoSakuseiIraiKirokuManager shujiiManager;
    private final IKojinFinder kojinFinder;
    private final YokaigoNinteiProgressManager yokaigoninteiProgressManager;

    /**
     * コンストラクタです。
     */
    public ShujiiIkenshoTorikomiTaishoshaManager() {
        torikomiTaishoshaDac = InstanceProvider.create(ShujiiIkenshoTorikomiTaishoshaDac.class);
        shujiiManager = new ShujiiIkenshoSakuseiIraiKirokuManager();
        kojinFinder = KojinService.createKojinFinder();
        yokaigoninteiProgressManager = new YokaigoNinteiProgressManager();
    }

    /**
     * テスト用プライベートコンストラクタです。
     *
     * @param torikomiTaishoshaDac torikomiTaishoshaDac
     * @param shujiiManager shujiiManager
     * @param kojinFinder kojinFinder
     * @param yokaigoninteiProgressManager yokaigoninteiProgressManager
     */
    ShujiiIkenshoTorikomiTaishoshaManager(
            ShujiiIkenshoTorikomiTaishoshaDac torikomiTaishoshaDac,
            ShujiiIkenshoSakuseiIraiKirokuManager shujiiManager,
            IKojinFinder kojinFinder,
            YokaigoNinteiProgressManager yokaigoninteiProgressManager) {
        this.torikomiTaishoshaDac = torikomiTaishoshaDac;
        this.shujiiManager = shujiiManager;
        this.kojinFinder = kojinFinder;
        this.yokaigoninteiProgressManager = yokaigoninteiProgressManager;
    }

    /**
     * 主治医意見書取込対象者を取得します。
     *
     * @param 市町村コード 市町村コード
     * @return 主治医意見書取込対象者リスト
     * @throws NullPointerException 引数がnullの場合
     */
    public List<ShujiiIkenshoTorikomiTaishosha> get主治医意見書取込対象者(LasdecCode 市町村コード) throws NullPointerException {
        requireNonNull(市町村コード, Messages.E00001.replace("市町村コード").getMessage());
        List<KaigoNinteiShoriTaishoshaEntity> torikomiTaishoshaEntityList = torikomiTaishoshaDac.selectAll();
        return create主治医意見書取込対象者List(市町村コード, torikomiTaishoshaEntityList);
    }

    /**
     * 証記載保険者番号を指定して、主治医意見書取込対象者を取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 証記載保険者番号 証記載保険者番号
     * @return 主治医意見書取込対象者リスト
     * @throws NullPointerException 引数がnullの場合
     */
    public List<ShujiiIkenshoTorikomiTaishosha> get主治医意見書取込対象者(
            LasdecCode 市町村コード, ShoKisaiHokenshaNo 証記載保険者番号) throws NullPointerException {
        requireNonNull(市町村コード, Messages.E00001.replace("市町村コード").getMessage());
        requireNonNull(証記載保険者番号, Messages.E00001.replace("証記載保険者番号").getMessage());
        List<KaigoNinteiShoriTaishoshaEntity> torikomiTaishoshaEntityList = torikomiTaishoshaDac.select証記載保険者番号(証記載保険者番号);
        return create主治医意見書取込対象者List(市町村コード, torikomiTaishoshaEntityList);
    }

    /**
     * 証記載保険者番号と支所コードを指定して、主治医意見書取込対象者を取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 証記載保険者番号 証記載保険者番号
     * @param 支所コード 支所コード
     * @return 主治医意見書取込対象者リスト
     * @throws NullPointerException 引数がnullの場合
     */
    public List<ShujiiIkenshoTorikomiTaishosha> get主治医意見書取込対象者(
            LasdecCode 市町村コード, ShoKisaiHokenshaNo 証記載保険者番号, RString 支所コード) throws NullPointerException {
        requireNonNull(市町村コード, Messages.E00001.replace("市町村コード").getMessage());
        requireNonNull(証記載保険者番号, Messages.E00001.replace("証記載保険者番号").getMessage());
        requireNonNull(支所コード, Messages.E00001.replace("支所コード").getMessage());
        List<KaigoNinteiShoriTaishoshaEntity> torikomiTaishoshaEntityList = torikomiTaishoshaDac.select証記載保険者番号及び支所コード(証記載保険者番号, 支所コード);
        return create主治医意見書取込対象者List(市町村コード, torikomiTaishoshaEntityList);
    }

    /**
     * 主治医意見書取込対象者の進捗を完了状態にするために、要介護認定進捗情報の主治医意見書登録完了年月日を更新します。
     *
     * @param 主治医意見書取込対象者 主治医意見書取込対象者
     * @param 主治医意見書登録完了年月日 主治医意見書登録完了年月日
     * @return true:更新OK, false:更新NG
     */
    public boolean save主治医意見書登録完了年月日(ShujiiIkenshoTorikomiTaishosha 主治医意見書取込対象者, FlexibleDate 主治医意見書登録完了年月日) {
        YokaigoNinteiProgressFactory factory = new YokaigoNinteiProgressFactory(主治医意見書取込対象者.get認定進捗情報());
        YokaigoNinteiProgress yokaigoninteiProgress = factory.createYokaigoninteiPorgressWith(
                ParticularDates.主治医意見書登録完了年月日, 主治医意見書登録完了年月日);
        return yokaigoninteiProgressManager.save(yokaigoninteiProgress);
    }

    private List<ShujiiIkenshoTorikomiTaishosha> create主治医意見書取込対象者List(
            LasdecCode 市町村コード,
            List<KaigoNinteiShoriTaishoshaEntity> entityList) {
        List<ShujiiIkenshoTorikomiTaishosha> list = new ArrayList<>();

        for (KaigoNinteiShoriTaishoshaEntity entity : entityList) {
            list.add(create主治医意見書取込対象者(市町村コード, entity));
        }

        if (list.isEmpty()) {
            return Collections.EMPTY_LIST;
        }

        return list;
    }

    private ShujiiIkenshoTorikomiTaishosha create主治医意見書取込対象者(LasdecCode 市町村コード, KaigoNinteiShoriTaishoshaEntity entity) {
        YokaigoNinteiProgress 認定進捗情報 = NinteiShinchokuJohoMapper.toNinteiShinchokuJoho(entity.getNinteiShinchokuJohoEntity());
        YokaigoNinteiShinsei 認定申請情報 = YokaigoNinteiShinseiMapper.toYokaigoNinteiShinsei(entity.getNinteiShinseiJohoEntity());
        ShujiiIkenshoSakuseiIrai 主治医意見書作成依頼情報 = get主治医意見書作成依頼情報(市町村コード, 認定申請情報);
        IKojin 個人 = get個人(認定申請情報);
        KaigoDoctor 介護主治医 = 主治医意見書作成依頼情報.get介護医師();

        return new ShujiiIkenshoTorikomiTaishosha(
                認定進捗情報,
                認定申請情報,
                主治医意見書作成依頼情報,
                個人,
                介護主治医);
    }

    private IKojin get個人(YokaigoNinteiShinsei 認定申請情報) {
        return kojinFinder.get個人(認定申請情報.get識別コード());
    }

    private ShujiiIkenshoSakuseiIrai get主治医意見書作成依頼情報(LasdecCode 市町村コード, YokaigoNinteiShinsei 認定申請情報) {
        return shujiiManager.get主治医意見書作成依頼情報(
                市町村コード,
                認定申請情報.get申請書管理番号(),
                new IkenshosakuseiIraiRirekiNo(認定申請情報.get意見書依頼履歴番号()));
    }
}
