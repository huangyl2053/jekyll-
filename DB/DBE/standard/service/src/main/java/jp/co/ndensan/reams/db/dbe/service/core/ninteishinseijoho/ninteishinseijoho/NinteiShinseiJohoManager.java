/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ninteishinseijoho.ninteishinseijoho;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichigojihanteikekkajoho.IchiGojiHanteiKekkaJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.image.Image;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ninteikanryojoho.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ninteikeikakujoho.NinteiKeikakuJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ninteikekkajoho.NinteiKekkaJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ninteishinseijoho.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.renrakusakijoho.RenrakusakiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.shinsakaiiinjogaijoho.ShinsakaiIinJogaiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.shinseirirekijoho.ShinseiRirekiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.shinseitodokedejoho.ShinseitodokedeJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.tennyushibo.TennyuShibo;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.tsuchishohakkojoho.TsuchishoHakkoJoho;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.ninteikekkajoho.NinteiKekkaJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteishinseijoho.ninteishinseijoho.NinteiShinseiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5101NinteiShinseiJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteikekkajoho.INinteiKekkaJohoMapper;
import jp.co.ndensan.reams.db.dbe.service.core.ninteishinseijoho.ichigojihanteikekkajoho.IchiGojiHanteiKekkaJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.ninteishinseijoho.image.ImageManager;
import jp.co.ndensan.reams.db.dbe.service.core.ninteishinseijoho.ninteikanryojoho.NinteiKanryoJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.ninteishinseijoho.ninteikeikakujoho.NinteiKeikakuJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.ninteishinseijoho.ninteikekkajoho.NinteiKekkaJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.ninteishinseijoho.renrakusakijoho.RenrakusakiJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.ninteishinseijoho.shinsakaiiinjogaijoho.ShinsakaiIinJogaiJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.ninteishinseijoho.shinseirirekijoho.ShinseiRirekiJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.ninteishinseijoho.shinseitodokedejoho.ShinseitodokedeJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.ninteishinseijoho.tennyushibo.TennyuShiboManager;
import jp.co.ndensan.reams.db.dbe.service.core.ninteishinseijoho.tsuchishohakkojoho.TsuchishoHakkoJohoManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定結果情報を管理するクラスです。
 */
public class NinteiShinseiJohoManager {

    private final MapperProvider mapperProvider;
    private final DbT5101NinteiShinseiJohoDac 要介護認定申請情報Dac;
    private final NinteiKekkaJohoManager 要介護認定結果情報Manager;
    private final IchijiHanteiKekkaJohoManager 要介護認定一次判定結果情報Manager;
    private final NinteiKanryoJohoManager 要介護認定完了情報Manager;
    private final ImageManager イメージ情報Manager;
    private final ShinseitodokedeJohoManager 申請届出情報Manager;
    private final ShinseiRirekiJohoManager 申請履歴情報Manager;
    private final TsuchishoHakkoJohoManager 通知書発行情報Manager;
    private final NinteiKeikakuJohoManager 要介護認定計画情報Manager;
    private final TennyuShiboManager 転入_死亡情報Manager;
    private final RenrakusakiJohoManager 介護連絡先情報Manager;
    private final IchiGojiHanteiKekkaJohoManager 要介護認定1_5次判定結果情報Manager;
    private final ShinsakaiIinJogaiJohoManager 審査会委員除外情報Manager;

    /**
     * コンストラクタです。
     */
    NinteiShinseiJohoManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.要介護認定申請情報Dac = InstanceProvider.create(DbT5101NinteiShinseiJohoDac.class);
        this.要介護認定結果情報Manager = new NinteiKekkaJohoManager();
        this.要介護認定一次判定結果情報Manager = new IchijiHanteiKekkaJohoManager();
        this.要介護認定完了情報Manager = new NinteiKanryoJohoManager();
        this.イメージ情報Manager = new ImageManager();
        this.申請届出情報Manager = new ShinseitodokedeJohoManager();
        this.申請履歴情報Manager = new ShinseiRirekiJohoManager();
        this.通知書発行情報Manager = new TsuchishoHakkoJohoManager();
        this.要介護認定計画情報Manager = new NinteiKeikakuJohoManager();
        this.転入_死亡情報Manager = new TennyuShiboManager();
        this.介護連絡先情報Manager = new RenrakusakiJohoManager();
        this.要介護認定1_5次判定結果情報Manager = new IchiGojiHanteiKekkaJohoManager();
        this.審査会委員除外情報Manager = new ShinsakaiIinJogaiJohoManager();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 要介護認定申請情報Dac 要介護認定申請情報Dac
     * @param 要介護認定結果情報Manager 要介護認定結果情報Manager
     * @param 要介護認定一次判定結果情報Manager 要介護認定一次判定結果情報Manager
     * @param 要介護認定完了情報Manager 要介護認定完了情報Manager
     * @param イメージ情報Manager イメージ情報Manager
     * @param 申請届出情報Manager 申請届出情報Manager
     * @param 申請履歴情報Manager 申請履歴情報Manager
     * @param 通知書発行情報Manager 通知書発行情報Manager
     * @param 要介護認定計画情報Manager 要介護認定計画情報Manager
     * @param 転入_死亡情報Manager 転入_死亡情報Manager
     * @param 介護連絡先情報Manager 介護連絡先情報Manager
     * @param 要介護認定1_5次判定結果情報Manager 要介護認定1_5次判定結果情報Manager
     * @param 審査会委員除外情報Manager 審査会委員除外情報Manager
     */
    NinteiShinseiJohoManager(
            MapperProvider mapperProvider,
            DbT5101NinteiShinseiJohoDac 要介護認定申請情報Dac,
            NinteiKekkaJohoManager 要介護認定結果情報Manager,
            IchijiHanteiKekkaJohoManager 要介護認定一次判定結果情報Manager,
            NinteiKanryoJohoManager 要介護認定完了情報Manager,
            ImageManager イメージ情報Manager,
            ShinseitodokedeJohoManager 申請届出情報Manager,
            ShinseiRirekiJohoManager 申請履歴情報Manager,
            TsuchishoHakkoJohoManager 通知書発行情報Manager,
            NinteiKeikakuJohoManager 要介護認定計画情報Manager,
            TennyuShiboManager 転入_死亡情報Manager,
            RenrakusakiJohoManager 介護連絡先情報Manager,
            IchiGojiHanteiKekkaJohoManager 要介護認定1_5次判定結果情報Manager,
            ShinsakaiIinJogaiJohoManager 審査会委員除外情報Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.要介護認定申請情報Dac = 要介護認定申請情報Dac;
        this.要介護認定結果情報Manager = 要介護認定結果情報Manager;
        this.要介護認定一次判定結果情報Manager = 要介護認定一次判定結果情報Manager;
        this.要介護認定完了情報Manager = 要介護認定完了情報Manager;
        this.イメージ情報Manager = イメージ情報Manager;
        this.申請届出情報Manager = 申請届出情報Manager;
        this.申請履歴情報Manager = 申請履歴情報Manager;
        this.通知書発行情報Manager = 通知書発行情報Manager;
        this.要介護認定計画情報Manager = 要介護認定計画情報Manager;
        this.転入_死亡情報Manager = 転入_死亡情報Manager;
        this.介護連絡先情報Manager = 介護連絡先情報Manager;
        this.要介護認定1_5次判定結果情報Manager = 要介護認定1_5次判定結果情報Manager;
        this.審査会委員除外情報Manager = 審査会委員除外情報Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NinteiShinseiJohoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link NinteiShinseiJohoManager}のインスタンス
     */
    public static NinteiShinseiJohoManager createInstance() {
        return InstanceProvider.create(NinteiShinseiJohoManager.class);
    }

    /**
     * 主キーに合致する要介護認定結果情報を返します。
     *
     * @param 要介護認定結果情報検索条件 要介護認定結果情報検索条件
     * @return NinteiShinseiJoho nullが返る可能性があります。
     */
    @Transaction
    public NinteiShinseiJoho get要介護認定結果情報(NinteiKekkaJohoMapperParameter 要介護認定結果情報検索条件) {
        requireNonNull(要介護認定結果情報検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定結果情報検索条件"));
        INinteiKekkaJohoMapper mapper = mapperProvider.create(INinteiKekkaJohoMapper.class);

        NinteiShinseiJohoRelateEntity relateEntity = mapper.getNinteiKekkaJohoEntity(要介護認定結果情報検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new NinteiShinseiJoho(relateEntity);
    }

    /**
     * 要介護認定申請情報{@link NinteiKekkaJoho}を保存します。
     *
     * @param 要介護認定申請情報 要介護認定申請情報
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(NinteiShinseiJoho 要介護認定申請情報) {
        requireNonNull(要介護認定申請情報, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定申請情報"));

        if (!要介護認定申請情報.hasChanged()) {
            return false;
        }
        要介護認定申請情報 = 要介護認定申請情報.modifiedModel();
//        save要介護認定結果情報リスト(要介護認定申請情報.getNinteiKekkaJohoList());
        save要介護認定一次判定結果情報リスト(要介護認定申請情報.getIchijiHanteiKekkaJohoList());
        save要介護認定完了情報リスト(要介護認定申請情報.getNinteiKanryoJohoList());
        saveイメージ情報リスト(要介護認定申請情報.getImageList());
        save申請届出情報リスト(要介護認定申請情報.getShinseitodokedeJohoList());
        save申請履歴情報リスト(要介護認定申請情報.getShinseiRirekiJohoList());
        save通知書発行情報リスト(要介護認定申請情報.getTsuchishoHakkoJohoList());
        save要介護認定計画情報リスト(要介護認定申請情報.getNinteiKeikakuJohoList());
        save転入_死亡情報リスト(要介護認定申請情報.getTennyuShiboList());
        save介護連絡先情報リスト(要介護認定申請情報.getRenrakusakiJohoList());
        save要介護認定1_5次判定結果情報リスト(要介護認定申請情報.getIchiGojiHanteiKekkaJohoList());
        save審査会委員除外情報リスト(要介護認定申請情報.getShinsakaiIinJogaiJohoList());
        return 1 == 要介護認定申請情報Dac.save(要介護認定申請情報.toEntity());
    }

    private void save要介護認定結果情報リスト(List<NinteiKekkaJoho> 要介護認定結果情報List) {
        for (NinteiKekkaJoho 要介護認定結果情報 : 要介護認定結果情報List) {
            要介護認定結果情報Manager.save要介護認定結果情報(要介護認定結果情報);
        }
    }

    private void save要介護認定一次判定結果情報リスト(List<IchijiHanteiKekkaJoho> 要介護認定一次判定結果情報List) {
        for (IchijiHanteiKekkaJoho 要介護認定一次判定結果情報 : 要介護認定一次判定結果情報List) {
            要介護認定一次判定結果情報Manager.save要介護認定一次判定結果情報(要介護認定一次判定結果情報);
        }
    }

    private void save要介護認定完了情報リスト(List<NinteiKanryoJoho> 要介護認定完了情報List) {
        for (NinteiKanryoJoho 要介護認定完了情報 : 要介護認定完了情報List) {
            要介護認定完了情報Manager.save要介護認定完了情報(要介護認定完了情報);
        }
    }

    private void saveイメージ情報リスト(List<Image> イメージ情報List) {
        for (Image イメージ情報 : イメージ情報List) {
            イメージ情報Manager.saveイメージ情報(イメージ情報);
        }
    }

    private void save申請届出情報リスト(List<ShinseitodokedeJoho> 申請届出情報List) {
        for (ShinseitodokedeJoho 申請届出情報 : 申請届出情報List) {
            申請届出情報Manager.save申請届出情報(申請届出情報);
        }
    }

    private void save申請履歴情報リスト(List<ShinseiRirekiJoho> 申請履歴情報List) {
        for (ShinseiRirekiJoho 申請履歴情報 : 申請履歴情報List) {
            申請履歴情報Manager.save申請履歴情報(申請履歴情報);
        }
    }

    private void save通知書発行情報リスト(List<TsuchishoHakkoJoho> 通知書発行情報List) {
        for (TsuchishoHakkoJoho 通知書発行情報 : 通知書発行情報List) {
            通知書発行情報Manager.save通知書発行情報(通知書発行情報);
        }
    }

    private void save要介護認定計画情報リスト(List<NinteiKeikakuJoho> 要介護認定計画情報List) {
        for (NinteiKeikakuJoho 要介護認定計画情報 : 要介護認定計画情報List) {
            要介護認定計画情報Manager.save要介護認定計画情報(要介護認定計画情報);
        }
    }

    private void save転入_死亡情報リスト(List<TennyuShibo> 転入_死亡情報List) {
        for (TennyuShibo 転入_死亡情報 : 転入_死亡情報List) {
            転入_死亡情報Manager.save転入_死亡情報(転入_死亡情報);
        }
    }

    private void save介護連絡先情報リスト(List<RenrakusakiJoho> 介護連絡先情報List) {
        for (RenrakusakiJoho 介護連絡先情報 : 介護連絡先情報List) {
            介護連絡先情報Manager.save介護連絡先情報(介護連絡先情報);
        }
    }

    private void save要介護認定1_5次判定結果情報リスト(List<IchiGojiHanteiKekkaJoho> 要介護認定1_5次判定結果情報List) {
        for (IchiGojiHanteiKekkaJoho 要介護認定1_5次判定結果情報 : 要介護認定1_5次判定結果情報List) {
            要介護認定1_5次判定結果情報Manager.save要介護認定1_5次判定結果情報(要介護認定1_5次判定結果情報);
        }
    }

    private void save審査会委員除外情報リスト(List<ShinsakaiIinJogaiJoho> 審査会委員除外情報List) {
        for (ShinsakaiIinJogaiJoho 審査会委員除外情報 : 審査会委員除外情報List) {
            審査会委員除外情報Manager.save審査会委員除外情報(審査会委員除外情報);
        }
    }
}
