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
import jp.co.ndensan.reams.db.dbe.business.KaigoIryoKikan;
import jp.co.ndensan.reams.db.dbe.business.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIkenshoIraiTaishosha;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIkenshoSakuseiIrai;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.IkenshosakuseiIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.entity.mapper.NinteishinseiJohoMapper;
import jp.co.ndensan.reams.db.dbe.entity.mapper.ShujiiIkenshoIraiTaishoshaMapper;
import jp.co.ndensan.reams.db.dbe.entity.relate.KaigoNinteiShoriTaishoshaEntity;
import jp.co.ndensan.reams.db.dbe.persistence.relate.ShujiiIkenshoIraiTaishoshaDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.ur.urz.realservice.IKojinFinder;
import jp.co.ndensan.reams.ur.urz.realservice.KojinService;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 主治医意見書依頼対象者の情報を扱うクラスです。
 *
 * @author N8187 久保田 英男
 */
public class ShujiiIkenshoIraiTaishoshaFinder {

    private final ShujiiIkenshoIraiTaishoshaDac shujiiIkenshoIraiTaishoshaDac;
    private final IKojinFinder kojinFinder;
    private final ShujiiIkenshoSakuseiIraiKirokuManager shujiiManager;
    private final KaigoIryoKikanFinder kaigoIryoKikanFinder;

    /**
     * コンストラクタです。
     */
    public ShujiiIkenshoIraiTaishoshaFinder() {
        shujiiIkenshoIraiTaishoshaDac = InstanceProvider.create(ShujiiIkenshoIraiTaishoshaDac.class);
        kojinFinder = KojinService.createKojinFinder();
        shujiiManager = new ShujiiIkenshoSakuseiIraiKirokuManager();
        kaigoIryoKikanFinder = new KaigoIryoKikanFinder();
    }

    /**
     * テスト用パッケージプライベートコンストラクタです。
     *
     * @param shujiiIkenshoIraiTaishoshaDac shujiiIkenshoIraiTaishoshaDac
     * @param kojinFinder kojinFinder
     * @param shujiiManager shujiiManager
     * @param kaigoIryoKikanFinder kaigoIryoKikanFinder
     */
    ShujiiIkenshoIraiTaishoshaFinder(
            ShujiiIkenshoIraiTaishoshaDac shujiiIkenshoIraiTaishoshaDac,
            IKojinFinder kojinFinder,
            ShujiiIkenshoSakuseiIraiKirokuManager shujiiManager,
            KaigoIryoKikanFinder kaigoIryoKikanFinder) {
        this.shujiiIkenshoIraiTaishoshaDac = shujiiIkenshoIraiTaishoshaDac;
        this.kojinFinder = kojinFinder;
        this.shujiiManager = shujiiManager;
        this.kaigoIryoKikanFinder = kaigoIryoKikanFinder;
    }

    /**
     * 主治医意見書作成依頼対象者を取得します。
     *
     * @return 主治医意見書作成依頼対象者リスト
     */
    public List<ShujiiIkenshoIraiTaishosha> get主治医意見書作成依頼対象者() {
        List<KaigoNinteiShoriTaishoshaEntity> iraiTaishoshaEntityList = shujiiIkenshoIraiTaishoshaDac.selectAll();
        return create主治医意見書作成依頼対象者List(iraiTaishoshaEntityList);
    }

    /**
     * 証記載保険者番号を指定して、主治医意見書作成依頼対象者を取得します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return 主治医意見書作成依頼対象者リスト
     * @throws NullPointerException 引数がnullの場合
     */
    public List<ShujiiIkenshoIraiTaishosha> get主治医意見書作成依頼対象者(ShoKisaiHokenshaNo 証記載保険者番号) throws NullPointerException {
        requireNonNull(証記載保険者番号, Messages.E00001.replace("証記載保険者番号").getMessage());
        List<KaigoNinteiShoriTaishoshaEntity> iraiTaishoshaEntityList = shujiiIkenshoIraiTaishoshaDac.select証記載保険者番号(証記載保険者番号);
        return create主治医意見書作成依頼対象者List(iraiTaishoshaEntityList);
    }

    /**
     * 証記載保険者番号と支所コードを指定して、主治医意見書作成依頼対象者を取得します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 支所コード 支所コード
     * @return 主治医意見書作成依頼対象者リスト
     * @throws NullPointerException 引数がnullの場合
     */
    public List<ShujiiIkenshoIraiTaishosha> get主治医意見書作成依頼対象者(ShoKisaiHokenshaNo 証記載保険者番号, RString 支所コード) throws NullPointerException {
        requireNonNull(証記載保険者番号, Messages.E00001.replace("証記載保険者番号").getMessage());
        requireNonNull(支所コード, Messages.E00001.replace("支所コード").getMessage());
        List<KaigoNinteiShoriTaishoshaEntity> iraiTaishoshaEntityList = shujiiIkenshoIraiTaishoshaDac.select証記載保険者番号及び支所コード(証記載保険者番号, 支所コード);
        return create主治医意見書作成依頼対象者List(iraiTaishoshaEntityList);
    }

    private List<ShujiiIkenshoIraiTaishosha> create主治医意見書作成依頼対象者List(
            List<KaigoNinteiShoriTaishoshaEntity> entityList) {
        List<ShujiiIkenshoIraiTaishosha> list = new ArrayList<>();

        for (KaigoNinteiShoriTaishoshaEntity entity : entityList) {
            list.add(create主治医意見書作成依頼対象者(entity));
        }

        if (list.isEmpty()) {
            return Collections.EMPTY_LIST;
        }

        return list;
    }

    private ShujiiIkenshoIraiTaishosha create主治医意見書作成依頼対象者(KaigoNinteiShoriTaishoshaEntity entity) {
        NinteiShinseiJoho 認定申請情報 = NinteishinseiJohoMapper.to認定申請情報(entity.getNinteiShinseiJohoEntity());
        IKojin 個人 = get個人(認定申請情報);
        RString 氏名 = 個人.get氏名().getName().value();
        RString 住所 = 個人.get住所().getValue();
        ShujiiIkenshoSakuseiIrai 主治医意見書作成依頼情報 = get主治医意見書作成依頼情報(認定申請情報);
        KaigoIryoKikan 主治医医療機関情報 = get主治医医療機関情報(認定申請情報, 主治医意見書作成依頼情報);
        KaigoDoctor 主治医情報 = 主治医意見書作成依頼情報.get介護医師();

        return ShujiiIkenshoIraiTaishoshaMapper.toShujiiIkenshoIraiTaishosha(
                認定申請情報,
                個人,
                氏名,
                住所,
                主治医医療機関情報,
                主治医情報);
    }

    private IKojin get個人(NinteiShinseiJoho 認定申請情報) {
        return kojinFinder.get個人(認定申請情報.get識別コード());
    }

    private ShujiiIkenshoSakuseiIrai get主治医意見書作成依頼情報(NinteiShinseiJoho 認定申請情報) {
        return shujiiManager.get主治医意見書作成依頼情報(
                認定申請情報.get申請書管理番号(),
                new IkenshosakuseiIraiRirekiNo(認定申請情報.get意見書依頼履歴番号()));
    }

    private KaigoIryoKikan get主治医医療機関情報(NinteiShinseiJoho 認定申請情報, ShujiiIkenshoSakuseiIrai 主治医意見書作成依頼情報) {
        return kaigoIryoKikanFinder.get介護医療機関(
                認定申請情報.get証記載保険者番号(),
                主治医意見書作成依頼情報.get介護医師().get介護医療機関コード());
    }
}
