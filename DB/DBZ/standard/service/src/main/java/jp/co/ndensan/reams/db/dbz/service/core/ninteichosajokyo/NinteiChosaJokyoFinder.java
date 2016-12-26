/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.ninteichosajokyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.basic.KaigoJigyosha;
import jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChosainJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiKekkaJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaIraiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaItakusakiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoGaikyoChosa;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShujiiIkenshoIraiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShujiiIkenshoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShujiiIryoKikanJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShujiiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.ninteichosajokyo.NinteiChosaJokyoDataPass;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5102NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5116IchijiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5201NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5202NinteichosahyoGaikyoChosaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5301ShujiiIkenshoIraiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5302ShujiiIkenshoJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5910NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5911ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5912ShujiiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5913ChosainJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5101NinteiShinseiJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5102NinteiKekkaJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5116IchijiHanteiKekkaJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5201NinteichosaIraiJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5202NinteichosahyoGaikyoChosaDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5301ShujiiIkenshoIraiJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5302ShujiiIkenshoJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5910NinteichosaItakusakiJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5911ShujiiIryoKikanJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5912ShujiiJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5913ChosainJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.ninteichosajokyo.INinteiChosaJokyoMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 共有子Div「認定調査状況」のサービスクラスです。
 *
 * @reamsid_L DBZ-1330-020 chengsanyuan
 */
public class NinteiChosaJokyoFinder {

    private final MapperProvider mapperProvider;
    private final DbT5101NinteiShinseiJohoDac dbT5101Dac;
    private final DbT5102NinteiKekkaJohoDac dbt5102dac;
    private final DbT5116IchijiHanteiKekkaJohoDac dbt5116dac;
    private final DbT5201NinteichosaIraiJohoDac dbT5201Dac;
    private final DbT5202NinteichosahyoGaikyoChosaDac dbT5202Dac;
    private final DbT5301ShujiiIkenshoIraiJohoDac dbT5301Dac;
    private final DbT5302ShujiiIkenshoJohoDac dbT5302Dac;
    private final DbT5910NinteichosaItakusakiJohoDac dbT5910Dac;
    private final DbT5911ShujiiIryoKikanJohoDac dbt5911dac;
    private final DbT5912ShujiiJohoDac dbt5912dac;
    private final DbT5913ChosainJohoDac dbT5913Dac;
    private final DbT7051KoseiShichosonMasterDac dbT7051Dac;

    /**
     * コンストラクタです。
     */
    NinteiChosaJokyoFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbT5101Dac = InstanceProvider.create(DbT5101NinteiShinseiJohoDac.class);
        this.dbt5102dac = InstanceProvider.create(DbT5102NinteiKekkaJohoDac.class);
        this.dbt5116dac = InstanceProvider.create(DbT5116IchijiHanteiKekkaJohoDac.class);
        this.dbT5201Dac = InstanceProvider.create(DbT5201NinteichosaIraiJohoDac.class);
        this.dbT5202Dac = InstanceProvider.create(DbT5202NinteichosahyoGaikyoChosaDac.class);
        this.dbT5301Dac = InstanceProvider.create(DbT5301ShujiiIkenshoIraiJohoDac.class);
        this.dbT5302Dac = InstanceProvider.create(DbT5302ShujiiIkenshoJohoDac.class);
        this.dbT5910Dac = InstanceProvider.create(DbT5910NinteichosaItakusakiJohoDac.class);
        this.dbt5911dac = InstanceProvider.create(DbT5911ShujiiIryoKikanJohoDac.class);
        this.dbt5912dac = InstanceProvider.create(DbT5912ShujiiJohoDac.class);
        this.dbT5913Dac = InstanceProvider.create(DbT5913ChosainJohoDac.class);
        this.dbT7051Dac = InstanceProvider.create(DbT7051KoseiShichosonMasterDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param MapperProvider {@link mapperProvider}
     */
    NinteiChosaJokyoFinder(MapperProvider mapperProvider,
            DbT5101NinteiShinseiJohoDac dbT5101Dac,
            DbT5102NinteiKekkaJohoDac dbt5102dac,
            DbT5116IchijiHanteiKekkaJohoDac dbt5116dac,
            DbT5201NinteichosaIraiJohoDac dbT5201Dac,
            DbT5202NinteichosahyoGaikyoChosaDac dbT5202Dac,
            DbT5301ShujiiIkenshoIraiJohoDac dbT5301Dac,
            DbT5302ShujiiIkenshoJohoDac dbT5302Dac,
            DbT5910NinteichosaItakusakiJohoDac dbT5910Dac,
            DbT5911ShujiiIryoKikanJohoDac dbt5911dac,
            DbT5912ShujiiJohoDac dbt5912dac,
            DbT5913ChosainJohoDac dbT5913Dac,
            DbT7051KoseiShichosonMasterDac dbT7051Dac) {
        this.mapperProvider = mapperProvider;
        this.dbT5101Dac = dbT5101Dac;
        this.dbt5102dac = dbt5102dac;
        this.dbt5116dac = dbt5116dac;
        this.dbT5201Dac = dbT5201Dac;
        this.dbT5202Dac = dbT5202Dac;
        this.dbT5301Dac = dbT5301Dac;
        this.dbT5302Dac = dbT5302Dac;
        this.dbT5910Dac = dbT5910Dac;
        this.dbt5911dac = dbt5911dac;
        this.dbt5912dac = dbt5912dac;
        this.dbT5913Dac = dbT5913Dac;
        this.dbT7051Dac = dbT7051Dac;

    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NinteiChosaJokyoFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link NinteiChosaJokyoFinder}のインスタンス
     */
    public static NinteiChosaJokyoFinder createInstance() {
        return InstanceProvider.create(NinteiChosaJokyoFinder.class);
    }

    /**
     * 介護事業者情報を取得します。
     *
     * @param サーブ業務コード サーブ業務コード
     * @return 介護事業者情報
     */
    public KaigoJigyosha get介護事業者情報(SubGyomuCode サーブ業務コード) {
        DbT7060KaigoJigyoshaEntity entity = null;
        if (SubGyomuCode.DBD介護受給.value().equals(サーブ業務コード.value())) {
            entity = mapperProvider.create(INinteiChosaJokyoMapper.class).get介護事業者情報By介護受給(RDate.getNowDate());
        }
        if (SubGyomuCode.DBE認定支援.value().equals(サーブ業務コード.value())) {
            entity = mapperProvider.create(INinteiChosaJokyoMapper.class).get介護事業者情報By介護認定(RDate.getNowDate());
        }
        if (entity == null) {
            return null;
        }
        return new KaigoJigyosha(entity);
    }

    public NinteiChosaJokyoDataPass get認定調査状況DataPass(ShinseishoKanriNo 申請者管理番号) {
        // TODO 本来であれば適切な業務概念を導入するべき
        NinteiChosaJokyoDataPass 認定調査状況 = new NinteiChosaJokyoDataPass();

        NinteiShinseiJoho 認定申請情報 = get要介護認定申請情報(申請者管理番号);
        if (認定申請情報 == null) {
            return 認定調査状況;
        }
        認定調査状況.set認定申請情報(認定申請情報);
        LasdecCode 市町村コード = get市町村コード(new ShoKisaiHokenshaNo(認定申請情報.get証記載保険者番号()));
        if (市町村コード != null) {
            認定調査状況.set市町村コード(市町村コード);
            add認定調査依頼情報(認定調査状況, 認定申請情報, 市町村コード);
            add主治医医療機関(認定調査状況, 認定申請情報, 市町村コード);
        }
        add意見書情報(認定調査状況, 認定申請情報);
        add要介護認定一次判定結果情報(認定調査状況, 認定申請情報);
        add要介護認定申請情報(認定調査状況, 認定申請情報);
        return 認定調査状況;
    }

    private LasdecCode get市町村コード(ShoKisaiHokenshaNo 証記載保険者番号) {
        KoseiShichosonMaster 構成市町村マスタ = get構成市町村マスタ(証記載保険者番号);
        if (構成市町村マスタ == null) {
            return null;
        }
        return 構成市町村マスタ.get市町村コード();
    }

    private void add認定調査依頼情報(NinteiChosaJokyoDataPass 認定調査状況, NinteiShinseiJoho 認定申請情報, LasdecCode 市町村コード) {
        NinteichosaIraiJoho 認定調査依頼情報 = get最新認定調査依頼情報(認定申請情報.get申請書管理番号());
        if (認定調査依頼情報 == null) {
            return;
        }
        認定調査状況.set認定調査依頼情報(認定調査依頼情報);

        NinteichosahyoGaikyoChosa 認定調査票概況調査_子
                = get認定調査票概況調査_子(認定調査依頼情報.get申請書管理番号(), 認定調査依頼情報.get認定調査依頼履歴番号());
        if (認定調査票概況調査_子 != null) {
            認定調査状況.set認定調査票概況調査_子(認定調査票概況調査_子);
        }

        NinteichosaItakusakiJoho 認定調査委託先情報
                = get認定調査委託先情報(市町村コード, 認定調査依頼情報.get認定調査委託先コード().value());
        if (認定調査委託先情報 != null) {
            認定調査状況.set認定調査委託先情報(認定調査委託先情報);
        }

        ChosainJoho 認定調査員情報 = get調査員情報(
                市町村コード,
                認定申請情報.get認定調査委託先コード(),
                認定申請情報.get認定調査員コード());
        if (認定調査員情報 != null) {
            認定調査状況.set認定調査員情報(認定調査員情報);
        }
    }

    private void add主治医医療機関(NinteiChosaJokyoDataPass 認定調査状況, NinteiShinseiJoho 認定申請情報, LasdecCode 市町村コード) {
        ShujiiIryoKikanJoho 主治医医療機関情報 = get主治医医療機関情報(
                市町村コード,
                new ShujiiIryokikanCode(認定申請情報.get主治医医療機関コード()));
        if (主治医医療機関情報 != null) {
            認定調査状況.set主治医医療機関情報(主治医医療機関情報);
        }

        ShujiiJoho 主治医情報 = get主治医情報(市町村コード, 認定申請情報.get主治医医療機関コード(), 認定申請情報.get主治医コード());
        if (主治医情報 != null) {
            認定調査状況.set主治医情報(主治医情報);
        }
    }

    private void add意見書情報(NinteiChosaJokyoDataPass 認定調査状況, NinteiShinseiJoho 認定申請情報) {
        ShujiiIkenshoIraiJoho 主治医意見書作成依頼情報 = get主治医意見書作成依頼情報(認定申請情報.get申請書管理番号());
        if (主治医意見書作成依頼情報 != null) {
            認定調査状況.set主治医意見書作成依頼情報(主治医意見書作成依頼情報);
        }
        ShujiiIkenshoJoho 要介護認定主治医意見書情報 = get要介護認定主治医意見書情報(認定申請情報.get申請書管理番号());
        if (要介護認定主治医意見書情報 != null) {
            認定調査状況.set要介護認定主治医意見書情報(要介護認定主治医意見書情報);
        }
    }

    private void add要介護認定一次判定結果情報(NinteiChosaJokyoDataPass 認定調査状況, NinteiShinseiJoho 認定申請情報) {
        // businessクラスの導入が必要
        DbT5116IchijiHanteiKekkaJohoEntity entity = get要介護認定一次判定結果情報(認定申請情報.get申請書管理番号());
        if (entity != null) {
            認定調査状況.set要介護認定一次判定結果情報(entity);
        }
    }

    private void add要介護認定申請情報(NinteiChosaJokyoDataPass 認定調査状況, NinteiShinseiJoho 認定申請情報) {
        NinteiKekkaJoho 要介護認定申請情報 = get要介護認定結果情報(認定申請情報.get申請書管理番号());
        if (要介護認定申請情報 != null) {
            認定調査状況.set要介護認定結果情報(要介護認定申請情報);
        }
    }

    @Transaction
    private NinteiShinseiJoho get要介護認定申請情報(
            ShinseishoKanriNo 申請書管理番号) {
        if (申請書管理番号 == null) {
            return null;
        }
        DbT5101NinteiShinseiJohoEntity entity = dbT5101Dac.selectByKey(
                申請書管理番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new NinteiShinseiJoho(entity);
    }

    @Transaction
    private KoseiShichosonMaster get構成市町村マスタ(ShoKisaiHokenshaNo 証記載保険者番号) {
        DbT7051KoseiShichosonMasterEntity entity = dbT7051Dac.shichosonCode(証記載保険者番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KoseiShichosonMaster(entity);
    }

    @Transaction
    private NinteichosaIraiJoho get最新認定調査依頼情報(ShinseishoKanriNo 申請書管理番号) {
        if (申請書管理番号 == null) {
            return null;
        }
        List<DbT5201NinteichosaIraiJohoEntity> list = dbT5201Dac.selectBy申請書管理番号(申請書管理番号);
        NinteichosaIraiJoho result = null;
        for (DbT5201NinteichosaIraiJohoEntity entity : list) {
            entity.initializeMd5();
            NinteichosaIraiJoho item = new NinteichosaIraiJoho(entity);
            if (result == null || result.get認定調査依頼履歴番号() < item.get認定調査依頼履歴番号()) {
                result = item;
            }
        }
        return result;
    }

    @Transaction
    private NinteichosahyoGaikyoChosa get認定調査票概況調査_子(ShinseishoKanriNo 申請書管理番号, int 認定調査依頼履歴番号) {
        if (申請書管理番号 == null) {
            return null;
        }
        List<DbT5202NinteichosahyoGaikyoChosaEntity> list = dbT5202Dac.selectByKey(申請書管理番号, 認定調査依頼履歴番号);
        if (list.size() < 1) {
            return null;
        }
        DbT5202NinteichosahyoGaikyoChosaEntity entity = list.get(0);
        entity.initializeMd5();
        return new NinteichosahyoGaikyoChosa(entity);
    }

    @Transaction
    private NinteichosaItakusakiJoho get認定調査委託先情報(
            LasdecCode 市町村コード,
            RString 認定調査委託先コード) {
        if (認定調査委託先コード == null) {
            return null;
        }
        DbT5910NinteichosaItakusakiJohoEntity entity = dbT5910Dac.selectByKey(市町村コード, 認定調査委託先コード);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new NinteichosaItakusakiJoho(entity);
    }

    @Transaction
    private ChosainJoho get調査員情報(
            LasdecCode 市町村コード,
            ChosaItakusakiCode 認定調査委託先コード,
            ChosainCode 認定調査員コード) {
        if (認定調査委託先コード == null || 認定調査員コード == null) {
            return null;
        }
        DbT5913ChosainJohoEntity entity = dbT5913Dac.selectByKey(市町村コード, 認定調査委託先コード, 認定調査員コード);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ChosainJoho(entity);
    }

    @Transaction
    private ShujiiIryoKikanJoho get主治医医療機関情報(
            LasdecCode 市町村コード,
            ShujiiIryokikanCode 主治医医療機関コード) {
        if (主治医医療機関コード == null) {
            return null;
        }
        DbT5911ShujiiIryoKikanJohoEntity entity = dbt5911dac.selectByKey(
                市町村コード,
                主治医医療機関コード);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ShujiiIryoKikanJoho(entity);
    }

    @Transaction
    private ShujiiJoho get主治医情報(
            LasdecCode 市町村コード,
            RString 主治医医療機関コード,
            RString 主治医コード) {
        if (主治医医療機関コード == null || 主治医コード == null) {
            return null;
        }

        DbT5912ShujiiJohoEntity entity = dbt5912dac.selectByKey(
                市町村コード,
                主治医医療機関コード,
                主治医コード);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ShujiiJoho(entity);
    }

    @Transaction
    private ShujiiIkenshoIraiJoho get主治医意見書作成依頼情報(ShinseishoKanriNo 申請書管理番号) {
        if (申請書管理番号 == null) {
            return null;
        }
        List<DbT5301ShujiiIkenshoIraiJohoEntity> list = dbT5301Dac.selectByKey(申請書管理番号);
        ShujiiIkenshoIraiJoho result = null;
        for (DbT5301ShujiiIkenshoIraiJohoEntity entity : list) {
            entity.initializeMd5();
            ShujiiIkenshoIraiJoho item = new ShujiiIkenshoIraiJoho(entity);
            if (result == null || result.get主治医意見書作成依頼履歴番号() < item.get主治医意見書作成依頼履歴番号()) {
                result = item;
            }
        }
        return result;
    }

    @Transaction
    private ShujiiIkenshoJoho get要介護認定主治医意見書情報(ShinseishoKanriNo 申請書管理番号) {
        if (申請書管理番号 == null) {
            return null;
        }
        List<DbT5302ShujiiIkenshoJohoEntity> list = dbT5302Dac.selectBy申請書管理番号(申請書管理番号);
        ShujiiIkenshoJoho result = null;
        for (DbT5302ShujiiIkenshoJohoEntity entity : list) {
            entity.initializeMd5();
            ShujiiIkenshoJoho item = new ShujiiIkenshoJoho(entity);
            if (result == null || result.get主治医意見書作成依頼履歴番号() < item.get主治医意見書作成依頼履歴番号()) {
                result = item;
            }
        }
        return result;
    }

    @Transaction
    private DbT5116IchijiHanteiKekkaJohoEntity get要介護認定一次判定結果情報(ShinseishoKanriNo 申請書管理番号) {

        DbT5116IchijiHanteiKekkaJohoEntity entity = dbt5116dac.selectByKey(
                申請書管理番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return entity;
    }

    @Transaction
    private NinteiKekkaJoho get要介護認定結果情報(ShinseishoKanriNo 申請書管理番号) {

        DbT5102NinteiKekkaJohoEntity entity = dbt5102dac.selectByKey(
                申請書管理番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new NinteiKekkaJoho(entity);
    }

}
