/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.KaigoNinteichosain;
import jp.co.ndensan.reams.db.dbe.business.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaIrai;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaIraiTaishosha;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaItakusaki;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoNinteichosainNo;
import jp.co.ndensan.reams.db.dbe.entity.mapper.NinteichosaIraiTaishoshaMapper;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbe.entity.mapper.NinteishinseiJohoMapper;
import jp.co.ndensan.reams.db.dbe.entity.relate.KaigoNinteiShoriTaishoshaEntity;
import jp.co.ndensan.reams.db.dbe.persistence.relate.NinteichosaIraiTaishoshaDac;
import jp.co.ndensan.reams.ur.urf.business.IKaigoJigyosha;
import jp.co.ndensan.reams.ur.urf.business.INinteiChosain;
import jp.co.ndensan.reams.ur.urf.definition.KaigoJigyoshaShubetsu;
import jp.co.ndensan.reams.ur.urf.realservice.IKaigoJigyoshaFinder;
import jp.co.ndensan.reams.ur.urf.realservice.INinteiChosainFinder;
import jp.co.ndensan.reams.ur.urf.realservice.KaigoJigyoshaFinderFactory;
import jp.co.ndensan.reams.ur.urf.realservice.NinteiChosainFinderFactory;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.ur.urz.realservice.IKojinFinder;
import jp.co.ndensan.reams.ur.urz.realservice.KojinService;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 認定調査依頼対象者を管理するクラスです。
 *
 * @author N8187 久保田 英男
 */
public class NinteichosaIraiTaishoshaFinder {

    private final NinteichosaIraiTaishoshaDac iraiTaishoshaDac;
    private final IKojinFinder kojinFinder;
    private final NinteichosaIraiManager ninteichosaIraiManager;
    private final NinteichosaItakusakiManager ninteichosaItakusakiManager;
    private final IKaigoJigyoshaFinder kaigoJigyoshaFinder;
    private final KaigoNinteichosainManager kaigoNinteichosainManager;
    private final INinteiChosainFinder ninteiChosainFinder;

    /**
     * コンストラクタです。
     *
     */
    public NinteichosaIraiTaishoshaFinder() {
        iraiTaishoshaDac = InstanceProvider.create(NinteichosaIraiTaishoshaDac.class);
        kojinFinder = KojinService.createKojinFinder();
        ninteichosaIraiManager = new NinteichosaIraiManager();
        ninteichosaItakusakiManager = new NinteichosaItakusakiManager();
        kaigoJigyoshaFinder = KaigoJigyoshaFinderFactory.getInstance();
        kaigoNinteichosainManager = new KaigoNinteichosainManager();
        ninteiChosainFinder = NinteiChosainFinderFactory.getInstance();
    }

    /**
     * テスト用のコンストラクタです。
     *
     * @param iraiTaishoshaDac iraiTaishoshaDac
     * @param kojinFinder kojinFinder
     * @param ninteichosaIraiManager ninteichosaIraiManager
     * @param ninteichosaItakusakiManager ninteichosaItakusakiManager
     * @param kaigoJigyoshaFinder kaigoJigyoshaFinder
     * @param kaigoNinteichosainManager kaigoNinteichosainManager
     * @param ninteiChosainFinder ninteiChosainFinder
     */
    NinteichosaIraiTaishoshaFinder(
            NinteichosaIraiTaishoshaDac iraiTaishoshaDac,
            IKojinFinder kojinFinder,
            NinteichosaIraiManager ninteichosaIraiManager,
            NinteichosaItakusakiManager ninteichosaItakusakiManager,
            IKaigoJigyoshaFinder kaigoJigyoshaFinder,
            KaigoNinteichosainManager kaigoNinteichosainManager,
            INinteiChosainFinder ninteiChosainFinder) {
        this.iraiTaishoshaDac = iraiTaishoshaDac;
        this.kojinFinder = kojinFinder;
        this.ninteichosaIraiManager = ninteichosaIraiManager;
        this.ninteichosaItakusakiManager = ninteichosaItakusakiManager;
        this.kaigoJigyoshaFinder = kaigoJigyoshaFinder;
        this.kaigoNinteichosainManager = kaigoNinteichosainManager;
        this.ninteiChosainFinder = ninteiChosainFinder;
    }

    /**
     * 認定調査依頼対象者を取得します。
     *
     * @return 認定調査依頼対象者リスト
     */
    public List<NinteichosaIraiTaishosha> get認定調査依頼対象者() {
        return create認定調査依頼対象者List(iraiTaishoshaDac.selectAll());
    }

    /**
     * 証記載保険者番号を指定して、認定調査依頼対象者を取得します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return 認定調査依頼対象者リスト
     * @throws NullPointerException 引数がnullの場合
     */
    public List<NinteichosaIraiTaishosha> get認定調査依頼対象者(ShoKisaiHokenshaNo 証記載保険者番号) throws NullPointerException {
        requireNonNull(証記載保険者番号, Messages.E00001.replace("証記載保険者番号").getMessage());
        return create認定調査依頼対象者List(iraiTaishoshaDac.select証記載保険者番号(証記載保険者番号));
    }

    /**
     * 証記載保険者番号と支所コードを指定して、認定調査依頼対象者を取得します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 支所コード 支所コード
     * @return 認定調査依頼対象者リスト
     * @throws NullPointerException 引数がnullの場合
     */
    public List<NinteichosaIraiTaishosha> get認定調査依頼対象者(ShoKisaiHokenshaNo 証記載保険者番号, RString 支所コード) throws NullPointerException {
        requireNonNull(証記載保険者番号, Messages.E00001.replace("証記載保険者番号").getMessage());
        requireNonNull(支所コード, Messages.E00001.replace("支所コード").getMessage());
        return create認定調査依頼対象者List(iraiTaishoshaDac.select証記載保険者番号及び支所コード(証記載保険者番号, 支所コード));
    }

    private List<NinteichosaIraiTaishosha> create認定調査依頼対象者List(List<KaigoNinteiShoriTaishoshaEntity> entityList)
            throws NullPointerException {
        List<NinteichosaIraiTaishosha> list = new ArrayList<>();

        for (KaigoNinteiShoriTaishoshaEntity entity : entityList) {
            NinteiShinseiJoho 認定申請情報 = NinteishinseiJohoMapper.to認定申請情報(entity.getNinteiShinseiJohoEntity());
            IKojin 個人 = get個人(認定申請情報);
            NinteichosaIrai 認定調査依頼情報 = get認定調査依頼情報(認定申請情報);
            NinteichosaItakusaki 認定調査委託先情報 = get認定調査委託先情報(認定申請情報, 認定調査依頼情報);
            IKaigoJigyosha 介護事業者 = get介護事業者(認定調査依頼情報);
            KaigoNinteichosain 介護認定調査員 = get介護認定調査員(認定申請情報, 認定調査依頼情報);
            INinteiChosain 認定調査員情報 = get認定調査員情報(介護認定調査員);

            list.add(NinteichosaIraiTaishoshaMapper.toNinteichosaIraiTaishosha(
                    認定申請情報,
                    個人,
                    認定調査委託先情報,
                    介護事業者,
                    認定調査員情報));
        }

        return list;
    }

    private IKojin get個人(NinteiShinseiJoho 認定申請情報) {
        return kojinFinder.get個人(認定申請情報.get識別コード());
    }

    private NinteichosaIrai get認定調査依頼情報(NinteiShinseiJoho 認定申請情報) {
        return ninteichosaIraiManager.get認定調査依頼情報(
                認定申請情報.get申請書管理番号(),
                認定申請情報.get認定調査依頼履歴番号());
    }

    private NinteichosaItakusaki get認定調査委託先情報(NinteiShinseiJoho 認定申請情報, NinteichosaIrai 認定調査依頼情報) {
        return ninteichosaItakusakiManager.get認定調査委託先介護事業者番号指定(
                認定申請情報.get証記載保険者番号(),
                認定調査依頼情報.get認定調査委託先コード(),
                true);
    }

    private IKaigoJigyosha get介護事業者(NinteichosaIrai 認定調査依頼情報) {
        return kaigoJigyoshaFinder.get特定の事業者種別かつ事業者番号の介護事業者(
                KaigoJigyoshaShubetsu.サービス事業者,
                認定調査依頼情報.get認定調査委託先コード().value());
    }

    private KaigoNinteichosain get介護認定調査員(NinteiShinseiJoho 認定申請情報, NinteichosaIrai 認定調査依頼情報) {
        return kaigoNinteichosainManager.get介護認定調査員(
                認定申請情報.get証記載保険者番号(),
                認定調査依頼情報.get認定調査委託先コード(),
                new KaigoNinteichosainNo(認定調査依頼情報.get調査員番号コード().value()));
    }

    private INinteiChosain get認定調査員情報(KaigoNinteichosain 介護認定調査員) {
        return ninteiChosainFinder.get認定調査員(介護認定調査員.get介護調査員番号().value());
    }
}
