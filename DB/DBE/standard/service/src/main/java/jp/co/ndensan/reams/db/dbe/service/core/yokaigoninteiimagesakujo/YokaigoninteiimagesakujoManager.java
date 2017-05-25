/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.yokaigoninteiimagesakujo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteiimagekanri.ImagekanriJoho;
import jp.co.ndensan.reams.db.dbe.definition.core.util.accesslog.ExpandedInformations;
import jp.co.ndensan.reams.db.dbe.definition.core.yokaigoninteiimagekanri.DeletionMethod;
import jp.co.ndensan.reams.db.dbe.definition.core.yokaigoninteiimagekanri.OperationTarget;
import jp.co.ndensan.reams.db.dbe.definition.core.yokaigoninteiimagekanri.OperationTargets;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.yokaigoninteiimagesakujo.YokaigoninteiimagesakujoMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5601NinteiChosaHoshuJissekiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5602ShujiiIkenshoHoshuJissekiJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5601NinteiChosaHoshuJissekiJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5602ShujiiIkenshoHoshuJissekiJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.yokaigoninteiimagesakujo.IYokaigoninteiimagesakujoMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.GenponMaskKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5105NinteiKanryoJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5105NinteiKanryoJohoDac;
import jp.co.ndensan.reams.db.dbz.service.core.DbAccessLogger;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.entity.SharedFileEntryInfoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
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
     * {@link InstanceProvider#create}にて生成した{@link YokaigoninteiimagesakujoManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link YokaigoninteiimagesakujoManager}のインスタンス
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
            if (info.getFilesEntity() == null) {
                continue;
            }
            RString pathName = info.getFilesEntity().getPathname();
            if (pathName == null) {
                continue;
            }
            存在したイメージファイル名.add(pathName);
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
     * @param イメージ管理情報 イメージ管理情報
     * @param 処理対象s 全削除対象
     */
    @Transaction
    public void updateOrDelete(ImagekanriJoho イメージ管理情報, OperationTargets 処理対象s) {
        for (OperationTarget t : 処理対象s) {
            _updateOrDelete(イメージ管理情報, t);
        }
//2017/5/25 削除するイメージの種類による完了情報の更新については、方針決定を見送る。
//        update完了情報(イメージ管理情報.get申請書管理番号(), 処理対象s);
        DbAccessLogger accessLogger = new DbAccessLogger();
        accessLogger.store(new ShoKisaiHokenshaNo(イメージ管理情報.get証記載保険者番号()), イメージ管理情報.get被保険者番号(),
                ExpandedInformations.fromShinseishoKanriNo(イメージ管理情報.get申請書管理番号()));
        accessLogger.flushBy(AccessLogType.更新);
    }

    private void _updateOrDelete(ImagekanriJoho imageKanriInfo, OperationTarget target) {
        switch (target.type()) {
            case 調査票:
                update調査票特記(imageKanriInfo.get申請書管理番号(), imageKanriInfo.get認定調査依頼履歴番号(), target.deletionMethod());
                return;
            case 概況特記:
                update調査票概況(imageKanriInfo.get申請書管理番号(), imageKanriInfo.get認定調査依頼履歴番号(), target.deletionMethod());
                return;
            case 意見書:
                update主治医意見書(imageKanriInfo.get申請書管理番号(), imageKanriInfo.get主治医意見書作成依頼履歴番号(), target.deletionMethod());
            default:
        }
    }

    private void update調査票特記(ShinseishoKanriNo 申請書管理番号, int 認定調査依頼履歴番号, DeletionMethod 削除対象区分) {
        IYokaigoninteiimagesakujoMapper mapper = mapperProvider.create(IYokaigoninteiimagesakujoMapper.class);
        switch (削除対象区分) {
            case 原本マスクを削除:
                mapper.deleteDbT5202PhysicalBy(YokaigoninteiimagesakujoMapperParameter.createDeleteByKeyParam_認定調査票(
                        申請書管理番号, 認定調査依頼履歴番号, TokkijikoTextImageKubun.イメージ.getコード(), RString.EMPTY, false));
                mapper.deleteDbT5203PhysicalBy(YokaigoninteiimagesakujoMapperParameter.createDeleteByKeyParam_認定調査票(
                        申請書管理番号, 認定調査依頼履歴番号, RString.EMPTY, RString.EMPTY, false));
                mapper.deleteDbT5204PhysicalBy(YokaigoninteiimagesakujoMapperParameter.createDeleteByKeyParam_認定調査票(
                        申請書管理番号, 認定調査依頼履歴番号, RString.EMPTY, RString.EMPTY, false));
                mapper.deleteDbT5205PhysicalBy(YokaigoninteiimagesakujoMapperParameter.createDeleteByKeyParam_認定調査票(
                        申請書管理番号, 認定調査依頼履歴番号, TokkijikoTextImageKubun.イメージ.getコード(),
                        RString.EMPTY, false));
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
                break;
            case マスクのみを削除:
                mapper.deleteDbT5205PhysicalBy(YokaigoninteiimagesakujoMapperParameter.createDeleteByKeyParam_認定調査票(
                        申請書管理番号, 認定調査依頼履歴番号, TokkijikoTextImageKubun.イメージ.getコード(),
                        GenponMaskKubun.マスク.getコード(), true));
                break;
            default:
                break;
        }
        mapper.deleteDbT5213PhysicalBy(YokaigoninteiimagesakujoMapperParameter.createDeleteByKeyParam_認定調査票(
                申請書管理番号, 認定調査依頼履歴番号, TokkijikoTextImageKubun.イメージ.getコード(),
                RString.EMPTY, false));
    }

    private void update調査票概況(ShinseishoKanriNo 申請書管理番号, int 認定調査依頼履歴番号, DeletionMethod 削除対象区分) {
        IYokaigoninteiimagesakujoMapper mapper = mapperProvider.create(IYokaigoninteiimagesakujoMapper.class);
        if (削除対象区分 == DeletionMethod.原本マスクを削除) {
            mapper.deleteDbT5206PhysicalBy(YokaigoninteiimagesakujoMapperParameter.createDeleteByKeyParam_認定調査票(
                    申請書管理番号, 認定調査依頼履歴番号, TokkijikoTextImageKubun.イメージ.getコード(), RString.EMPTY, false));
        }
    }

    private void update主治医意見書(ShinseishoKanriNo 申請書管理番号, int 主治医意見書作成依頼履歴番号, DeletionMethod 削除対象区分) {
        IYokaigoninteiimagesakujoMapper mapper = mapperProvider.create(IYokaigoninteiimagesakujoMapper.class);
        switch (削除対象区分) {
            case 原本マスクを削除:
                mapper.deleteDbT5302PhysicalBy(YokaigoninteiimagesakujoMapperParameter.createDeleteByKeyParam_主治医意見書(
                        申請書管理番号, 主治医意見書作成依頼履歴番号, RString.EMPTY, false));
                mapper.deleteDbT5303PhysicalBy(YokaigoninteiimagesakujoMapperParameter.createDeleteByKeyParam_主治医意見書(
                        申請書管理番号, 主治医意見書作成依頼履歴番号, RString.EMPTY, false));
                mapper.deleteDbT5304PhysicalBy(YokaigoninteiimagesakujoMapperParameter.createDeleteByKeyParam_主治医意見書(
                        申請書管理番号, 主治医意見書作成依頼履歴番号, RString.EMPTY, false));
                mapper.deleteDbT5305PhysicalBy(YokaigoninteiimagesakujoMapperParameter.createDeleteByKeyParam_主治医意見書(
                        申請書管理番号, 主治医意見書作成依頼履歴番号, RString.EMPTY, false));
                return;
            case マスクのみを削除:
                mapper.deleteDbT5305PhysicalBy(YokaigoninteiimagesakujoMapperParameter.createDeleteByKeyParam_主治医意見書(
                        申請書管理番号, 主治医意見書作成依頼履歴番号, GenponMaskKubun.マスク.getコード(), true));
            default:
        }
    }

    private void update完了情報(ShinseishoKanriNo 申請書管理番号, OperationTargets 処理対象s) {
        DbT5105NinteiKanryoJohoEntity e = this.dbT5105Dac.selectByKey(申請書管理番号);
        for (OperationTarget o : 処理対象s) {
            switch (o.type()) {
                case その他資料:
                    continue;
                case 意見書:
                    e.setMaskingKanryoYMD(null);
                    if (o.deletionMethod().isMaskedOnly()) {
                        continue;
                    }
                    e.setIkenshoTorokuKanryoYMD(null);
                    e.setIchijiHanteiKanryoYMD(null);
                    continue;
                case 調査票:
                    e.setMaskingKanryoYMD(null);
                    if (o.deletionMethod().isMaskedOnly()) {
                        continue;
                    }
                    e.setNinteichosaKanryoYMD(null);
                    e.setIchijiHanteiKanryoYMD(null);
                    continue;
                case 概況特記:
                    e.setMaskingKanryoYMD(null);
                    if (o.deletionMethod().isMaskedOnly()) {
                        continue;
                    }
                    e.setNinteichosaKanryoYMD(null);
            }
        }
        this.dbT5105Dac.save(e);
    }

}
