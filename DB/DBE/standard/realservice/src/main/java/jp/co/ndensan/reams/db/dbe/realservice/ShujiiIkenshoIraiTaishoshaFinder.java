/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.KaigoIryoKikan;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIkenshoIraiTaishosha;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5005NinteiShinchokuJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5011ShujiiIkenshoIraiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7012ShujiiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.mapper.ShujiiIkenshoIraiTaishoshaMapper;
import jp.co.ndensan.reams.db.dbe.persistence.basic.INinteiShinchokuJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.basic.INinteiShinseiJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.basic.IShujiiIkenshoIraiJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.basic.IShujiiJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.relate.IShujiiIkenshoIraiTaishoshaDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoDoctorCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.ur.urz.business.IDoctor;
import jp.co.ndensan.reams.ur.urz.business.JushoEditor;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.JushoEditPattern;
import jp.co.ndensan.reams.ur.urz.realservice.DoctorManagerFactory;
import jp.co.ndensan.reams.ur.urz.realservice.KojinService;
import jp.co.ndensan.reams.ur.urz.realservice.ShikibetsuTaishoService;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceCreator;

/**
 * 主治医意見書依頼対象者の情報を扱うクラスです。
 *
 * @author N8187 久保田 英男
 */
public class ShujiiIkenshoIraiTaishoshaFinder {

    private final INinteiShinchokuJohoDac ninteiShinchokuJohoDac;
    private final IShujiiIkenshoIraiTaishoshaDac shujiiIkenshoIraiTaishoshaDac;
    private final INinteiShinseiJohoDac ninteiShinseiJohoDac;
    private final IShujiiJohoDac shujiiJohoDac;
    private final IShujiiIkenshoIraiJohoDac shujiiIkenshoIraiJohoDac;

    /**
     * コンストラクタです。
     */
    public ShujiiIkenshoIraiTaishoshaFinder() {
        ninteiShinchokuJohoDac = InstanceCreator.create(INinteiShinchokuJohoDac.class);
        shujiiIkenshoIraiTaishoshaDac = InstanceCreator.create(IShujiiIkenshoIraiTaishoshaDac.class);
        ninteiShinseiJohoDac = InstanceCreator.create(INinteiShinseiJohoDac.class);
        shujiiJohoDac = InstanceCreator.create(IShujiiJohoDac.class);
        shujiiIkenshoIraiJohoDac = InstanceCreator.create(IShujiiIkenshoIraiJohoDac.class);
    }

    /**
     * テスト用パッケージプライベートコンストラクタです。
     *
     * @param ninteiShinchokuJohoDac INinteiShinchokuJohoDac
     * @param shujiiIkenshoIraiTaishoshaDac IShujiiIkenshoIraiTaishoshaDac
     * @param ninteiShinseiJohoDac INinteiShinseiJohoDac
     * @param shujiiJohoDac IShujiiJohoDac
     * @param shujiiIkenshoIraiJohoDac IShujiiIkenshoIraiJohoDac
     */
    ShujiiIkenshoIraiTaishoshaFinder(INinteiShinchokuJohoDac ninteiShinchokuJohoDac,
            IShujiiIkenshoIraiTaishoshaDac shujiiIkenshoIraiTaishoshaDac,
            INinteiShinseiJohoDac ninteiShinseiJohoDac,
            IShujiiJohoDac shujiiJohoDac,
            IShujiiIkenshoIraiJohoDac shujiiIkenshoIraiJohoDac) {
        this.ninteiShinchokuJohoDac = ninteiShinchokuJohoDac;
        this.shujiiIkenshoIraiTaishoshaDac = shujiiIkenshoIraiTaishoshaDac;
        this.ninteiShinseiJohoDac = ninteiShinseiJohoDac;
        this.shujiiJohoDac = shujiiJohoDac;
        this.shujiiIkenshoIraiJohoDac = shujiiIkenshoIraiJohoDac;
    }

    /**
     * 主治医意見書作成が未完了の主治医意見書作成依頼対象者を取得します。
     *
     * @return ShujiiIkenshoIraiTaishoshaのList
     */
    public List<ShujiiIkenshoIraiTaishosha> get主治医意見書作成依頼対象者() {
        List<DbT5005NinteiShinchokuJohoEntity> 認定進捗情報EntityList = ninteiShinchokuJohoDac.select主治医意見書作成依頼未完了();
        return create主治医意見書作成依頼対象者List(認定進捗情報EntityList);
    }

    /**
     * 市町村コードを指定して、主治医意見書作成が未完了の主治医意見書作成依頼対象者を取得します。
     *
     * @param 市町村コード 市町村コード
     * @return ShujiiIkenshoIraiTaishoshaのList
     * @throws NullPointerException {@code 市町村コード}がnullの場合
     */
    public List<ShujiiIkenshoIraiTaishosha> get主治医意見書作成依頼対象者(ShichosonCode 市町村コード) throws NullPointerException {
        requireNonNull(市町村コード, Messages.E00001.replace("市町村コード").getMessage());

        List<DbT5005NinteiShinchokuJohoEntity> 認定進捗情報EntityList = shujiiIkenshoIraiTaishoshaDac.select主治医意見書作成依頼対象者(市町村コード);
        return create主治医意見書作成依頼対象者List(認定進捗情報EntityList);
    }

    /**
     * 市町村コード、支所コードを指定して、主治医意見書作成が未完了の主治医意見書作成依頼対象者を取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 支所コード 支所コード
     * @return ShujiiIkenshoIraiTaishoshaのList
     * @throws NullPointerException 引数がnullの場合
     */
    public List<ShujiiIkenshoIraiTaishosha> get主治医意見書作成依頼対象者(ShichosonCode 市町村コード, RString 支所コード) throws NullPointerException {
        requireNonNull(市町村コード, Messages.E00001.replace("市町村コード").getMessage());
        requireNonNull(支所コード, Messages.E00001.replace("支所コード").getMessage());

        List<DbT5005NinteiShinchokuJohoEntity> 認定進捗情報EntityList = shujiiIkenshoIraiTaishoshaDac.select主治医意見書作成依頼対象者(市町村コード, 支所コード);
        return create主治医意見書作成依頼対象者List(認定進捗情報EntityList);
    }

    private List<ShujiiIkenshoIraiTaishosha> create主治医意見書作成依頼対象者List(List<DbT5005NinteiShinchokuJohoEntity> 認定進捗情報EntityList) {

        if (認定進捗情報EntityList.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        List<ShujiiIkenshoIraiTaishosha> list = new ArrayList<>();

        for (DbT5005NinteiShinchokuJohoEntity entity : 認定進捗情報EntityList) {
            DbT5001NinteiShinseiJohoEntity 認定申請情報Entity = create認定申請情報Entity(entity);
            DbT5011ShujiiIkenshoIraiJohoEntity 主治医意見書作成依頼情報Entity = create主治医意見書作成依頼情報Entity(認定申請情報Entity);
            IKojin 個人 = create個人(認定申請情報Entity);
            IShikibetsuTaisho 識別対象 = create識別対象(認定申請情報Entity);
            RString 氏名 = create氏名(識別対象);
            RString 住所 = create住所(識別対象);
            DbT7012ShujiiJohoEntity 主治医情報Entity = create主治医情報Entity(認定申請情報Entity, 主治医意見書作成依頼情報Entity);
            KaigoIryoKikan 主治医医療機関情報 = create主治医医療機関情報(認定申請情報Entity, 主治医情報Entity);
            IDoctor 主治医 = create主治医(主治医情報Entity);
            list.add(ShujiiIkenshoIraiTaishoshaMapper.toShujiiIkenshoIraiTaishosha(
                    認定申請情報Entity,
                    個人,
                    氏名,
                    住所,
                    主治医医療機関情報,
                    主治医));
        }

        return list;
    }

    private DbT5001NinteiShinseiJohoEntity create認定申請情報Entity(DbT5005NinteiShinchokuJohoEntity entity) {
        return ninteiShinseiJohoDac.select(entity.getShinseishoKanriNo());
    }

    private DbT5011ShujiiIkenshoIraiJohoEntity create主治医意見書作成依頼情報Entity(DbT5001NinteiShinseiJohoEntity 認定申請情報Entity) {
        return shujiiIkenshoIraiJohoDac.select(
                認定申請情報Entity.getShinseishoKanriNo(),
                認定申請情報Entity.getIkenshoIraiRirekiNo());
    }

    private DbT7012ShujiiJohoEntity create主治医情報Entity(DbT5001NinteiShinseiJohoEntity 認定申請情報Entity,
            DbT5011ShujiiIkenshoIraiJohoEntity 主治医意見書作成依頼情報Entity) {
        return shujiiJohoDac.select(
                認定申請情報Entity.getShichosonCode(),
                new KaigoIryoKikanCode(主治医意見書作成依頼情報Entity.getKaigoIryokikanCode()),
                new KaigoDoctorCode(主治医意見書作成依頼情報Entity.getKaigoIshiCode()));
    }

    private IKojin create個人(DbT5001NinteiShinseiJohoEntity 認定申請情報Entity) {
        return KojinService.createKojinFinder().get個人(
                new ShikibetsuCode(認定申請情報Entity.getShikibetsuCode().getColumnValue()));
    }

    private IShikibetsuTaisho create識別対象(DbT5001NinteiShinseiJohoEntity 認定申請情報Entity) {
        return ShikibetsuTaishoService.getShikibetsuTaishoFinder().get識別対象(
                new ShikibetsuCode(認定申請情報Entity.getShikibetsuCode().getColumnValue()));
    }

    private RString create氏名(IShikibetsuTaisho 識別対象) {
        return 識別対象.get氏名().getName();
    }

    private RString create住所(IShikibetsuTaisho 識別対象) {
        return JushoEditor.editJusho(識別対象.get住所(), JushoEditPattern.町域番地);
    }

    private IDoctor create主治医(DbT7012ShujiiJohoEntity 主治医情報Entity) {
        return DoctorManagerFactory.createInstance().get医師(主治医情報Entity.getShujiiCode());
    }

    private KaigoIryoKikan create主治医医療機関情報(DbT5001NinteiShinseiJohoEntity 認定申請情報Entity, DbT7012ShujiiJohoEntity 主治医情報Entity) {
        return new KaigoIryoKikanFinder().get介護医療機関(
                認定申請情報Entity.getShichosonCode(),
                主治医情報Entity.getKaigoIryokikanCode());
    }
}
