/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.shujiiikenshosakuseiryonyuryoku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshohoshujissekijoho.ShujiiIkenshoHoshuJissekiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshohoshujissekijoho.ShujiiIkenshoHoshuJissekiJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshosakuseiryonyuryoku.ShujiiJissekiIchiranBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshosakuseiryonyuryoku.ShujiiJohoBusiness;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shujiiikenshosakuseiryonyuryoku.ShujiiIkenshoSakuseiryoNyuryokuParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5032ShujiiIkenshoHoshuTankaEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5602ShujiiIkenshoHoshuJissekiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshosakuseiryonyuryoku.ShujiiJissekiIchiranRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshosakuseiryonyuryoku.ShujiiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5032ShujiiIkenshoHoshuTankaDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5602ShujiiIkenshoHoshuJissekiJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shujiiikenshosakuseiryonyuryoku.IShujiiIkenshoSakuseiryoNyuryokuMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoSakuseiKaisuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.ZaitakuShisetsuKubun;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 主治医意見書作成料入力を管理クラスです。
 *
 * @reamsid_L DBE-1960-010 xuyannan
 */
public class ShujiiIkenshoSakuseiryoNyuryokuFinder {

    private static final RString アンダーライン_2回目以降 = new RString("_2回目以降");
    private static final RString 意見書作成回数区分_2回目以降 = new RString("2回目以降");
    private final MapperProvider mapperProvider;
    private final DbT5032ShujiiIkenshoHoshuTankaDac dbT5032dac;
    private final DbT5602ShujiiIkenshoHoshuJissekiJohoDac dbT5602dac;

    /**
     * コンストラクタです。
     */
    public ShujiiIkenshoSakuseiryoNyuryokuFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbT5032dac = InstanceProvider.create(DbT5032ShujiiIkenshoHoshuTankaDac.class);
        this.dbT5602dac = InstanceProvider.create(DbT5602ShujiiIkenshoHoshuJissekiJohoDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param dbT5032dac 意見書作成報酬単価のデータアクセス
     * @param dbT5602dac 主治医意見書作成報酬実績情報のデータアクセス
     */
    public ShujiiIkenshoSakuseiryoNyuryokuFinder(
            MapperProvider mapperProvider,
            DbT5032ShujiiIkenshoHoshuTankaDac dbT5032dac,
            DbT5602ShujiiIkenshoHoshuJissekiJohoDac dbT5602dac) {
        this.mapperProvider = mapperProvider;
        this.dbT5032dac = dbT5032dac;
        this.dbT5602dac = dbT5602dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShujiiIkenshoSakuseiryoNyuryokuFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShujiiIkenshoSakuseiryoNyuryokuFinder}のインスタンス
     */
    public static ShujiiIkenshoSakuseiryoNyuryokuFinder createInstance() {
        return InstanceProvider.create(ShujiiIkenshoSakuseiryoNyuryokuFinder.class);
    }

    /**
     * 主治医情報を取得します。
     *
     * @param parameter ShujiiIkenshoSakuseiryoNyuryokuParameter
     * @return SearchResult<ShujiiJohoBusiness>
     */
    @Transaction
    public SearchResult<ShujiiJohoBusiness> getShujiiJohoList(ShujiiIkenshoSakuseiryoNyuryokuParameter parameter) {
        List<ShujiiJohoBusiness> resultList = new ArrayList<>();
        List<ShujiiJohoRelateEntity> relateList
                = mapperProvider.create(IShujiiIkenshoSakuseiryoNyuryokuMapper.class).select主治医情報(parameter);
        if (relateList == null || relateList.isEmpty()) {
            return SearchResult.of(Collections.<ShujiiJohoBusiness>emptyList(), 0, false);
        }
        for (ShujiiJohoRelateEntity entity : relateList) {
            resultList.add(new ShujiiJohoBusiness(entity));
        }
        return SearchResult.of(resultList, 0, false);
    }

    /**
     * 主治医実績一覧を取得します。
     *
     * @param parameter ShujiiIkenshoSakuseiryoNyuryokuParameter
     * @return SearchResult<ShujiiJissekiIchiranBusiness>
     */
    @Transaction
    public SearchResult<ShujiiJissekiIchiranBusiness> getShujiiJissekiIchiranList(ShujiiIkenshoSakuseiryoNyuryokuParameter parameter) {
        List<ShujiiJissekiIchiranBusiness> resultList = new ArrayList<>();
        List<ShujiiJissekiIchiranRelateEntity> relateList
                = mapperProvider.create(IShujiiIkenshoSakuseiryoNyuryokuMapper.class).select主治医実績一覧(parameter);
        if (relateList == null || relateList.isEmpty()) {
            return SearchResult.of(Collections.<ShujiiJissekiIchiranBusiness>emptyList(), 0, false);
        }
        for (ShujiiJissekiIchiranRelateEntity entity : relateList) {
            resultList.add(new ShujiiJissekiIchiranBusiness(entity));
        }
        return SearchResult.of(resultList, 0, false);
    }

    /**
     * 意見書作成料を取得します。
     *
     * @param 在宅施設区分 在宅施設区分
     * @param 意見書作成回数区分 意見書作成回数区分
     * @param 意見書記入年月 意見書記入年月
     * @param 意見書受領年月 意見書受領年月
     * @return 単価
     */
    @Transaction
    public Decimal getTanka(
            RString 在宅施設区分,
            RString 意見書作成回数区分,
            FlexibleDate 意見書記入年月,
            FlexibleDate 意見書受領年月) {
        RString 区分;
        if (意見書作成回数区分_2回目以降.equals(意見書作成回数区分)) {
            区分 = アンダーライン_2回目以降;
        } else {
            区分 = 意見書作成回数区分;
        }
        DbT5032ShujiiIkenshoHoshuTankaEntity entity = dbT5032dac.selectTanka(
                new Code(ZaitakuShisetsuKubun.valueOf(在宅施設区分.toString()).getコード()),
                new Code(IkenshoSakuseiKaisuKubun.valueOf(区分.toString()).getコード()),
                意見書記入年月.getYearMonth(),
                意見書受領年月.getYearMonth());
        if (entity != null) {
            return entity.getTanka();
        }
        return Decimal.ZERO;
    }

    /**
     * 報酬実績情報{@link ShujiiIkenshoHoshuJissekiJoho}を登録/更新します。
     *
     * @param 報酬実績情報 {@link ShujiiIkenshoHoshuJissekiJoho}
     * @return 登録/登録件数 更新/更新件数 の件数を返します。
     */
    public int insertOrUpdate(ShujiiIkenshoHoshuJissekiJoho 報酬実績情報) {
        if (!報酬実績情報.hasChanged()) {
            return 0;
        }
        return dbT5602dac.save(報酬実績情報.toEntity());
    }

    /**
     * 報酬実績情報{@link ShujiiIkenshoHoshuJissekiJoho}を物理削除します。
     *
     * @param models 報酬実績情報
     * @param key 報酬実績情報の識別子
     * @return 物理削除件数 物理削除結果の件数を返します。
     */
    public boolean delete(Models<ShujiiIkenshoHoshuJissekiJohoIdentifier, ShujiiIkenshoHoshuJissekiJoho> models,
            ShujiiIkenshoHoshuJissekiJohoIdentifier key) {
        ShujiiIkenshoHoshuJissekiJoho 報酬実績情報 = models.get(key);
        if (報酬実績情報 != null) {
            return 1 == dbT5602dac.delete(報酬実績情報.toEntity());
        }
        return false;
    }

    /**
     * 主治医意見書作成報酬実績情報を取得します。
     *
     * @param 主治医医療機関コード 主治医医療機関コード
     * @param 主治医コード 主治医コード
     * @return SearchResult<ChikuShichoson>
     */
    @Transaction
    public SearchResult<ShujiiIkenshoHoshuJissekiJoho> get報酬実績情報(
            RString 主治医医療機関コード,
            RString 主治医コード) {
        List<ShujiiIkenshoHoshuJissekiJoho> resultList = new ArrayList<>();
        List<DbT5602ShujiiIkenshoHoshuJissekiJohoEntity> chikuShichosonList = dbT5602dac.select報酬実績情報(主治医医療機関コード, 主治医コード);
        if (chikuShichosonList == null || chikuShichosonList.isEmpty()) {
            return SearchResult.of(Collections.<ShujiiIkenshoHoshuJissekiJoho>emptyList(), 0, false);
        }
        for (DbT5602ShujiiIkenshoHoshuJissekiJohoEntity entity : chikuShichosonList) {
            entity.initializeMd5();
            resultList.add(new ShujiiIkenshoHoshuJissekiJoho(entity));
        }
        return SearchResult.of(resultList, 0, false);
    }
}
