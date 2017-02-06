/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.shujiiikenshotoroku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshotoroku.ShujiiIkenshoTorokuResult;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteiimagekanri.ImagekanriJoho;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shujiiikenshotoroku.ShujiiIkenshoTorokuMapperParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.yokaigoninteiimagesakujo.YokaigoninteiimagesakujoMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshotoroku.ShujiiIkenshoTorokuRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shujiiikenshotoroku.IShujiiIkenshoTorokuMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.yokaigoninteiimagesakujo.IYokaigoninteiimagesakujoMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.GenponMaskKubun;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 主治医意見書登録のサービスクラスです。
 *
 * @reamsid_L DBE-0070-010 chengsanyuan
 */
public class ShujiiIkenshoTorokuManager {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    ShujiiIkenshoTorokuManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param MapperProvider {@link mapperProvider}
     */
    ShujiiIkenshoTorokuManager(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShujiiIkenshoTorokuManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link ShujiiIkenshoTorokuManager}のインスタンス
     */
    public static ShujiiIkenshoTorokuManager createInstance() {
        return InstanceProvider.create(ShujiiIkenshoTorokuManager.class);
    }

    /**
     * 主治医意見書登録画面初期検索
     *
     * @param param 主治医意見書登録のパラメータ
     * @return SearchResult<ShujiiIkenshoTorokuResult>
     */
    public SearchResult<ShujiiIkenshoTorokuResult> getDataForLoad(ShujiiIkenshoTorokuMapperParameter param) {
        List<ShujiiIkenshoTorokuResult> resultList = new ArrayList<>();
        ShujiiIkenshoTorokuRelateEntity entity
                = mapperProvider.create(IShujiiIkenshoTorokuMapper.class).getShujiiIkenshoForLoad(param);
        if (entity == null) {
            return SearchResult.of(Collections.<ShujiiIkenshoTorokuResult>emptyList(), 0, false);
        }
        resultList.add(new ShujiiIkenshoTorokuResult(entity));
        return SearchResult.of(resultList, 0, false);
    }

    /**
     * 意見書情報件数
     *
     * @param param 主治医意見書登録のパラメータ
     * @return int
     */
    public int getShujiiIkenshoKensu(ShujiiIkenshoTorokuMapperParameter param) {
        return mapperProvider.create(IShujiiIkenshoTorokuMapper.class).getShujiiIkenshoKensu(param);
    }

    /**
     * 一次判定データの件数
     *
     * @param param 主治医意見書登録のパラメータ
     * @return int
     */
    public int getIchijiHantei(ShujiiIkenshoTorokuMapperParameter param) {
        return mapperProvider.create(IShujiiIkenshoTorokuMapper.class).getIchijiHantei(param);
    }

    /**
     * 一次判定完了データ
     *
     * @param param 主治医意見書登録のパラメータ
     * @return int
     */
    public int getIchijiHanteiKanryo(ShujiiIkenshoTorokuMapperParameter param) {
        return mapperProvider.create(IShujiiIkenshoTorokuMapper.class).getIchijiHanteiKanryo(param);
    }

    /**
     * 一次判定未完了データ
     *
     * @param param 主治医意見書登録のパラメータ
     * @return int
     */
    public int getIchijiHanteiMikanryo(ShujiiIkenshoTorokuMapperParameter param) {
        return mapperProvider.create(IShujiiIkenshoTorokuMapper.class).getIchijiHanteiMikanryo(param);
    }

    /**
     * イメージ管理情報の更新
     *
     * @param イメージ管理情報　ImagekanriJoho
     */
    public void updateOrDelete(ImagekanriJoho イメージ管理情報) {
        IYokaigoninteiimagesakujoMapper mapper = mapperProvider.create(IYokaigoninteiimagesakujoMapper.class);

        mapper.deleteDbT5302PhysicalBy(YokaigoninteiimagesakujoMapperParameter.createDeleteByKeyParam_主治医意見書(
                イメージ管理情報.get申請書管理番号(), イメージ管理情報.get主治医意見書作成依頼履歴番号(), RString.EMPTY, false));
        mapper.deleteDbT5303PhysicalBy(YokaigoninteiimagesakujoMapperParameter.createDeleteByKeyParam_主治医意見書(
                イメージ管理情報.get申請書管理番号(), イメージ管理情報.get主治医意見書作成依頼履歴番号(), RString.EMPTY, false));
        mapper.deleteDbT5304PhysicalBy(YokaigoninteiimagesakujoMapperParameter.createDeleteByKeyParam_主治医意見書(
                イメージ管理情報.get申請書管理番号(), イメージ管理情報.get主治医意見書作成依頼履歴番号(), RString.EMPTY, false));
        mapper.deleteDbT5305PhysicalBy(YokaigoninteiimagesakujoMapperParameter.createDeleteByKeyParam_主治医意見書(
                イメージ管理情報.get申請書管理番号(), イメージ管理情報.get主治医意見書作成依頼履歴番号(), RString.EMPTY, false));

        mapper.deleteDbT5305PhysicalBy(YokaigoninteiimagesakujoMapperParameter.createDeleteByKeyParam_主治医意見書(
                イメージ管理情報.get申請書管理番号(), イメージ管理情報.get主治医意見書作成依頼履歴番号(), GenponMaskKubun.マスク.getコード(), true));

    }
}
