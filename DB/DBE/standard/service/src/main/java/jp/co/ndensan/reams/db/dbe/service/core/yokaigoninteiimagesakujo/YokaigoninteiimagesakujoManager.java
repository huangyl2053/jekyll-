/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.yokaigoninteiimagesakujo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteiimagekanri.ImagekanriJoho;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.yokaigoninteiimagesakujo.YokaigoninteiimagesakujoMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5601NinteiChosaHoshuJissekiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5602ShujiiIkenshoHoshuJissekiJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5601NinteiChosaHoshuJissekiJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5602ShujiiIkenshoHoshuJissekiJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.yokaigoninteiimagesakujo.IYokaigoninteiimagesakujoMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.GenponMaskKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5105NinteiKanryoJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5105NinteiKanryoJohoDac;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.entity.SharedFileEntryInfoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定イメージ情報削除を管理するクラスです。
 *
 * @reamsid_L DBE-1670-012 dingyi
 */
public class YokaigoninteiimagesakujoManager {

    private final DbT5601NinteiChosaHoshuJissekiJohoDac dbT5601Dac;
    private final DbT5602ShujiiIkenshoHoshuJissekiJohoDac dbT5602Dac;
    private final DbT5105NinteiKanryoJohoDac dbT5105Dac;
    private final MapperProvider mapperProvider;
    private static final RString 原本を削除 = new RString("1");
    private static final RString マスキングを削除 = new RString("2");
    private static final RString 両方を削除 = new RString("3");
    private static final RString KEY_調査票特記 = new RString("1");
    private static final RString KEY_調査票概況 = new RString("2");
    private static final RString KEY_主治医意見書 = new RString("3");

    /**
     * コンストラクタです。
     */
    YokaigoninteiimagesakujoManager() {
        dbT5601Dac = InstanceProvider.create(DbT5601NinteiChosaHoshuJissekiJohoDac.class);
        dbT5602Dac = InstanceProvider.create(DbT5602ShujiiIkenshoHoshuJissekiJohoDac.class);
        dbT5105Dac = InstanceProvider.create(DbT5105NinteiKanryoJohoDac.class);
        mapperProvider = InstanceProvider.create(MapperProvider.class);

    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dbT5601Dac {@link DbT5601NinteiChosaHoshuJissekiJohoDac}
     * @param dbT5602Dac {@link DbT5602ShujiiIkenshoHoshuJissekiJohoDac}
     * @param dbT5105Dac {@link DbT5105NinteiKanryoJohoDac}
     * @param mapperProvider {@link MapperProvider}
     */
    YokaigoninteiimagesakujoManager(DbT5601NinteiChosaHoshuJissekiJohoDac dbT5601Dac,
            DbT5602ShujiiIkenshoHoshuJissekiJohoDac dbT5602Dac,
            DbT5105NinteiKanryoJohoDac dbT5105Dac,
            MapperProvider mapperProvider) {
        this.dbT5601Dac = dbT5601Dac;
        this.dbT5602Dac = dbT5602Dac;
        this.dbT5105Dac = dbT5105Dac;
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link YokaigoninteiimagesakujoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link YokaigoninteiimagesakujoManager}のインスタンス
     */
    public static YokaigoninteiimagesakujoManager createInstance() {
        return InstanceProvider.create(YokaigoninteiimagesakujoManager.class);
    }

    /**
     * 認定調査報酬実績情報の認定調査委託料支払年月日を取得します。
     *
     * @param 認定調査委託先コード 認定調査委託先コード
     * @param 認定調査員コード 認定調査員コード
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @return 認定調査委託料支払年月日
     */
    @Transaction
    public FlexibleDate getChosaItakuryoShiharaiYMD(RString 認定調査委託先コード, RString 認定調査員コード, ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号) {
        DbT5601NinteiChosaHoshuJissekiJohoEntity dbT5601Entity = dbT5601Dac.selectByKey(
                認定調査委託先コード, 認定調査員コード, 申請書管理番号, 認定調査依頼履歴番号);
        if (dbT5601Entity != null) {
            return dbT5601Entity.getChosaItakuryoShiharaiYMD();
        } else {
            return FlexibleDate.EMPTY;
        }
    }

    /**
     * 存在したイメージファイル名を取得します。
     *
     * @param descriptor 共有ファイル
     * @return 存在したイメージファイル名
     */
    @Transaction
    public List<RString> get存在したイメージファイル名(ReadOnlySharedFileEntryDescriptor descriptor) {
        List<RString> 存在したイメージファイル名 = new ArrayList<>();
        List<SharedFileEntryInfoEntity> sharedFileEntryInfoEntity = SharedFile.getEntryInfo(descriptor);
        for (SharedFileEntryInfoEntity info : sharedFileEntryInfoEntity) {
            if (info.getFilesEntity() != null) {
                存在したイメージファイル名.add(info.getFilesEntity().getPathname().split("\\.").get(0));
            }
        }
        return 存在したイメージファイル名;
    }

    /**
     * 主治医意見書作成報酬実績情報の主治医意見書報酬支払年月日を取得します。
     *
     * @param 主治医医療機関コード 主治医医療機関コード
     * @param 主治医コード 主治医コード
     * @param 申請書管理番号 申請書管理番号
     * @param 主治医意見書作成依頼履歴番号 主治医意見書作成依頼履歴番号
     * @return 主治医意見書報酬支払年月日
     */
    @Transaction
    public FlexibleDate getHoshuShiharaiYMD(RString 主治医医療機関コード, RString 主治医コード, ShinseishoKanriNo 申請書管理番号,
            int 主治医意見書作成依頼履歴番号) {
        DbT5602ShujiiIkenshoHoshuJissekiJohoEntity dbT5602Entity = dbT5602Dac.selectByKey(
                主治医医療機関コード, 主治医コード, 申請書管理番号, 主治医意見書作成依頼履歴番号);
        if (dbT5602Entity != null) {
            return dbT5602Entity.getHoshuShiharaiYMD();
        } else {
            return FlexibleDate.EMPTY;
        }
    }

    /**
     * 「削除」ボタンを押下する場合、イメージを削除して、DBを更新します。
     *
     * @param イメージ管理情報 イメージ管理情報
     * @param 選択されたイメージ対象 選択されたイメージ対象
     * @param 削除対象 削除対象
     */
    @Transaction
    public void updateOrDelete(ImagekanriJoho イメージ管理情報, List<RString> 選択されたイメージ対象, RString 削除対象) {
        for (RString key : 選択されたイメージ対象) {
            if (KEY_調査票特記.equals(key)) {
                update調査票特記(
                        イメージ管理情報.get申請書管理番号(),
                        イメージ管理情報.get認定調査依頼履歴番号(),
                        削除対象);
            } else if (KEY_調査票概況.equals(key)) {
                update調査票概況(
                        イメージ管理情報.get申請書管理番号(),
                        イメージ管理情報.get認定調査依頼履歴番号(),
                        削除対象);
            } else if (KEY_主治医意見書.equals(key)) {
                update主治医意見書(
                        イメージ管理情報.get申請書管理番号(),
                        イメージ管理情報.get主治医意見書作成依頼履歴番号(),
                        削除対象);
            }
        }
    }

    @Transaction
    private void update調査票特記(ShinseishoKanriNo 申請書管理番号, int 認定調査依頼履歴番号, RString 削除対象区分) {
        IYokaigoninteiimagesakujoMapper mapper = mapperProvider.create(IYokaigoninteiimagesakujoMapper.class);
        DbT5105NinteiKanryoJohoEntity 要介護認定完了情報 = dbT5105Dac.selectByKey(申請書管理番号);
        if (原本を削除.equals(削除対象区分)) {
            要介護認定完了情報.setNinteichosaKanryoYMD(FlexibleDate.EMPTY);
            要介護認定完了情報.setState(EntityDataState.Modified);
            mapper.deleteDbT5205PhysicalBy(YokaigoninteiimagesakujoMapperParameter.createDeleteByKeyParam_認定調査票(
                    申請書管理番号, 認定調査依頼履歴番号, TokkijikoTextImageKubun.イメージ.getコード(),
                    GenponMaskKubun.原本.getコード(), true));
        } else if (マスキングを削除.equals(削除対象区分)) {
            要介護認定完了情報.setMaskingKanryoYMD(FlexibleDate.EMPTY);
            要介護認定完了情報.setState(EntityDataState.Modified);
            mapper.deleteDbT5205PhysicalBy(YokaigoninteiimagesakujoMapperParameter.createDeleteByKeyParam_認定調査票(
                    申請書管理番号, 認定調査依頼履歴番号, TokkijikoTextImageKubun.イメージ.getコード(),
                    GenponMaskKubun.マスク.getコード(), true));
        } else if (両方を削除.equals(削除対象区分)) {
            要介護認定完了情報.setNinteichosaKanryoYMD(FlexibleDate.EMPTY);
            要介護認定完了情報.setMaskingKanryoYMD(FlexibleDate.EMPTY);
            要介護認定完了情報.setState(EntityDataState.Modified);
            mapper.deleteDbT5205PhysicalBy(YokaigoninteiimagesakujoMapperParameter.createDeleteByKeyParam_認定調査票(
                    申請書管理番号, 認定調査依頼履歴番号, TokkijikoTextImageKubun.イメージ.getコード(),
                    RString.EMPTY, false));
        }
        dbT5105Dac.save(要介護認定完了情報);
        if (原本を削除.equals(削除対象区分) || 両方を削除.equals(削除対象区分)) {
            mapper.deleteDbT5202PhysicalBy(YokaigoninteiimagesakujoMapperParameter.createDeleteByKeyParam_認定調査票(
                    申請書管理番号, 認定調査依頼履歴番号, TokkijikoTextImageKubun.イメージ.getコード(), RString.EMPTY, false));
            mapper.deleteDbT5203PhysicalBy(YokaigoninteiimagesakujoMapperParameter.createDeleteByKeyParam_認定調査票(
                    申請書管理番号, 認定調査依頼履歴番号, RString.EMPTY, RString.EMPTY, false));
            mapper.deleteDbT5204PhysicalBy(YokaigoninteiimagesakujoMapperParameter.createDeleteByKeyParam_認定調査票(
                    申請書管理番号, 認定調査依頼履歴番号, RString.EMPTY, RString.EMPTY, false));
            mapper.deleteDbT5207PhysicalBy(YokaigoninteiimagesakujoMapperParameter.createDeleteByKeyParam_認定調査票(
                    申請書管理番号, 認定調査依頼履歴番号, RString.EMPTY, RString.EMPTY, false));
            mapper.deleteDbT5208PhysicalBy(YokaigoninteiimagesakujoMapperParameter.createDeleteByKeyParam_認定調査票(
                    申請書管理番号, 認定調査依頼履歴番号, RString.EMPTY, RString.EMPTY, false));
            mapper.deleteDbT5209PhysicalBy(YokaigoninteiimagesakujoMapperParameter.createDeleteByKeyParam_認定調査票(
                    申請書管理番号, 認定調査依頼履歴番号, RString.EMPTY, RString.EMPTY, false));
            mapper.deleteDbT5210PhysicalBy(YokaigoninteiimagesakujoMapperParameter.createDeleteByKeyParam_認定調査票(
                    申請書管理番号, 認定調査依頼履歴番号, RString.EMPTY, RString.EMPTY, false));
            mapper.deleteDbT5211PhysicalBy(YokaigoninteiimagesakujoMapperParameter.createDeleteByKeyParam_認定調査票(
                    申請書管理番号, 認定調査依頼履歴番号, RString.EMPTY, RString.EMPTY, false));
            mapper.deleteDbT5212PhysicalBy(YokaigoninteiimagesakujoMapperParameter.createDeleteByKeyParam_認定調査票(
                    申請書管理番号, 認定調査依頼履歴番号, RString.EMPTY, RString.EMPTY, false));
        }
    }

    @Transaction
    private void update調査票概況(ShinseishoKanriNo 申請書管理番号, int 認定調査依頼履歴番号, RString 削除対象区分) {
        IYokaigoninteiimagesakujoMapper mapper = mapperProvider.create(IYokaigoninteiimagesakujoMapper.class);
        DbT5105NinteiKanryoJohoEntity 要介護認定完了情報 = dbT5105Dac.selectByKey(申請書管理番号);
        if (原本を削除.equals(削除対象区分)) {
            要介護認定完了情報.setNinteichosaKanryoYMD(FlexibleDate.EMPTY);
            要介護認定完了情報.setState(EntityDataState.Modified);
        } else if (マスキングを削除.equals(削除対象区分)) {
            要介護認定完了情報.setMaskingKanryoYMD(FlexibleDate.EMPTY);
            要介護認定完了情報.setState(EntityDataState.Modified);
        } else if (両方を削除.equals(削除対象区分)) {
            要介護認定完了情報.setNinteichosaKanryoYMD(FlexibleDate.EMPTY);
            要介護認定完了情報.setMaskingKanryoYMD(FlexibleDate.EMPTY);
            要介護認定完了情報.setState(EntityDataState.Modified);
        }
        dbT5105Dac.save(要介護認定完了情報);
        if (原本を削除.equals(削除対象区分) || 両方を削除.equals(削除対象区分)) {
            mapper.deleteDbT5206PhysicalBy(YokaigoninteiimagesakujoMapperParameter.createDeleteByKeyParam_認定調査票(
                    申請書管理番号, 認定調査依頼履歴番号, TokkijikoTextImageKubun.イメージ.getコード(), RString.EMPTY, false));
        }
    }

    @Transaction
    private void update主治医意見書(ShinseishoKanriNo 申請書管理番号, int 主治医意見書作成依頼履歴番号, RString 削除対象区分) {
        IYokaigoninteiimagesakujoMapper mapper = mapperProvider.create(IYokaigoninteiimagesakujoMapper.class);
        DbT5105NinteiKanryoJohoEntity 要介護認定完了情報 = dbT5105Dac.selectByKey(申請書管理番号);
        if (原本を削除.equals(削除対象区分)) {
            要介護認定完了情報.setIkenshoTorokuKanryoYMD(FlexibleDate.EMPTY);
            要介護認定完了情報.setState(EntityDataState.Modified);
            mapper.deleteDbT5305PhysicalBy(YokaigoninteiimagesakujoMapperParameter.createDeleteByKeyParam_主治医意見書(
                    申請書管理番号, 主治医意見書作成依頼履歴番号, TokkijikoTextImageKubun.テキスト.getコード(), true));
        } else if (マスキングを削除.equals(削除対象区分)) {
            要介護認定完了情報.setMaskingKanryoYMD(FlexibleDate.EMPTY);
            要介護認定完了情報.setState(EntityDataState.Modified);
            mapper.deleteDbT5305PhysicalBy(YokaigoninteiimagesakujoMapperParameter.createDeleteByKeyParam_主治医意見書(
                    申請書管理番号, 主治医意見書作成依頼履歴番号, TokkijikoTextImageKubun.イメージ.getコード(), true));
        } else if (両方を削除.equals(削除対象区分)) {
            要介護認定完了情報.setIkenshoTorokuKanryoYMD(FlexibleDate.EMPTY);
            要介護認定完了情報.setMaskingKanryoYMD(FlexibleDate.EMPTY);
            要介護認定完了情報.setState(EntityDataState.Modified);
            mapper.deleteDbT5305PhysicalBy(YokaigoninteiimagesakujoMapperParameter.createDeleteByKeyParam_主治医意見書(
                    申請書管理番号, 主治医意見書作成依頼履歴番号, RString.EMPTY, false));
        }
        dbT5105Dac.save(要介護認定完了情報);
        if (原本を削除.equals(削除対象区分) || 両方を削除.equals(削除対象区分)) {
            mapper.deleteDbT5302PhysicalBy(YokaigoninteiimagesakujoMapperParameter.createDeleteByKeyParam_主治医意見書(
                    申請書管理番号, 主治医意見書作成依頼履歴番号, RString.EMPTY, false));
            mapper.deleteDbT5303PhysicalBy(YokaigoninteiimagesakujoMapperParameter.createDeleteByKeyParam_主治医意見書(
                    申請書管理番号, 主治医意見書作成依頼履歴番号, RString.EMPTY, false));
            mapper.deleteDbT5304PhysicalBy(YokaigoninteiimagesakujoMapperParameter.createDeleteByKeyParam_主治医意見書(
                    申請書管理番号, 主治医意見書作成依頼履歴番号, RString.EMPTY, false));
        }
    }

}
