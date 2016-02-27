/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.gogitaijohosakusei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.gogitaijoho.GogitaiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijohosakusei.GogitaiJohoSakuseiRsult;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.gogitaijohosakusei.GogitaiJohoSakuseiParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.gogitaijoho.gogitaijoho.GogitaiJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5592ShinsakaiKaisaiBashoJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.gogitaijoho.gogitaijoho.GogitaiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.gogitaijohosakusei.GogitaiJohoSakuseiRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5501ShinsakaiKaisaiYoteiJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5591GogitaiJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5592ShinsakaiKaisaiBashoJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5593GogitaiWariateIinJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.gogitaijoho.gogitaijoho.IGogitaiJohoMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.gogitaijohosakusei.IGogitaiJohoSakuseiMapper;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 合議体情報作成のサービスクラスです。
 */
public class GogitaiJohoSakuseiFinder {

    private static final RString KAISAI_BASHO_CODE_EMPTY = new RString("empty");
    private final MapperProvider mapperProvider;
    private final DbT5592ShinsakaiKaisaiBashoJohoDac dbt5592dac;
    private final DbT5591GogitaiJohoDac dbt5591dac;
    private final DbT5593GogitaiWariateIinJohoDac dbt5593dac;
    private final DbT5501ShinsakaiKaisaiYoteiJohoDac dbt5501dac;

    /**
     * コンストラクタです。
     */
    GogitaiJohoSakuseiFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbt5592dac = InstanceProvider.create(DbT5592ShinsakaiKaisaiBashoJohoDac.class);
        this.dbt5591dac = InstanceProvider.create(DbT5591GogitaiJohoDac.class);
        this.dbt5593dac = InstanceProvider.create(DbT5593GogitaiWariateIinJohoDac.class);
        this.dbt5501dac = InstanceProvider.create(DbT5501ShinsakaiKaisaiYoteiJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param MapperProvider {@link mapperProvider}
     */
    GogitaiJohoSakuseiFinder(MapperProvider mapperProvider,
            DbT5592ShinsakaiKaisaiBashoJohoDac dbt5592dac,
            DbT5591GogitaiJohoDac dbt5591dac,
            DbT5593GogitaiWariateIinJohoDac dbt5593dac,
            DbT5501ShinsakaiKaisaiYoteiJohoDac dbt5501dac) {
        this.mapperProvider = mapperProvider;
        this.dbt5592dac = dbt5592dac;
        this.dbt5591dac = dbt5591dac;
        this.dbt5593dac = dbt5593dac;
        this.dbt5501dac = dbt5501dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link GogitaiJohoSakuseiFinder}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link GogitaiJohoSakuseiFinder}のインスタンス
     */
    public static GogitaiJohoSakuseiFinder createInstance() {
        return InstanceProvider.create(GogitaiJohoSakuseiFinder.class);
    }

    /**
     * 合議体情報一覧のデータを取得します。
     *
     * @param param 合議体情報作成のパラメータ
     * @return SearchResult<GogitaiJohoSakuseiRsult>
     */
    public SearchResult<GogitaiJohoSakuseiRsult> getDateGridList(GogitaiJohoSakuseiParameter param) {

        List<GogitaiJohoSakuseiRsult> resultList = new ArrayList<>();
        List<GogitaiJohoSakuseiRelateEntity> gogitaiRelateEntityList
                = mapperProvider.create(IGogitaiJohoSakuseiMapper.class).getGogitaiJohoSakuseiGridList(param);
        if (gogitaiRelateEntityList.isEmpty()) {
            return SearchResult.of(Collections.<GogitaiJohoSakuseiRsult>emptyList(), 0, false);
        }
        for (GogitaiJohoSakuseiRelateEntity entity : gogitaiRelateEntityList) {
            resultList.add(new GogitaiJohoSakuseiRsult(entity));
        }
        return SearchResult.of(resultList, 0, false);
    }

    /**
     * 合議体情報作成のデータを取得します。
     *
     * @param is現在有効な合議体のみ 現在有効な合議体のみ
     * @return SearchResult<GogitaiJoho>
     */
    public SearchResult<GogitaiJoho> getGogitaiJohoSakusei(boolean is現在有効な合議体のみ) {

        List<GogitaiJoho> resultList = new ArrayList<>();
        GogitaiJohoMapperParameter param = GogitaiJohoMapperParameter.createSelectBy合議体情報作成(is現在有効な合議体のみ);
        List<GogitaiJohoRelateEntity> gogitaiRelateEntityList
                = mapperProvider.create(IGogitaiJohoMapper.class).selectGogitaiJohoSakusei(param);
        if (gogitaiRelateEntityList.isEmpty()) {
            return SearchResult.of(Collections.<GogitaiJohoSakuseiRsult>emptyList(), 0, false);
        }
        for (GogitaiJohoRelateEntity entity : gogitaiRelateEntityList) {
            entity.initializeMd5ToEntities();
            resultList.add(new GogitaiJoho(entity));
        }
        return SearchResult.of(resultList, 0, false);
    }

    /**
     * 開催場所コードドロップリストを取得します。
     *
     * @return SearchResult<KeyValueDataSource>
     */
    public SearchResult<KeyValueDataSource> getKaisaiBashoList() {

        List<KeyValueDataSource> resultList = new ArrayList<>();
        List<DbT5592ShinsakaiKaisaiBashoJohoEntity> kaisaiBashoJohoList = dbt5592dac.selectKaisaiBashoList();
        if (kaisaiBashoJohoList.isEmpty()) {
            return SearchResult.of(Collections.<KeyValueDataSource>emptyList(), 0, false);
        }
        resultList.add(new KeyValueDataSource(KAISAI_BASHO_CODE_EMPTY, RString.EMPTY));
        for (DbT5592ShinsakaiKaisaiBashoJohoEntity entity : kaisaiBashoJohoList) {
            resultList.add(new KeyValueDataSource(entity.getShinsakaiKaisaiBashoCode(), entity.getShinsakaiKaisaiBashoName()));
        }
        return SearchResult.of(resultList, 0, false);
    }

    /**
     * 審査員一覧のデータを取得します。
     *
     * @param param 合議体情報作成のパラメータ
     * @return SearchResult<GogitaiJohoSakuseiRsult>
     */
    public SearchResult<GogitaiJohoSakuseiRsult> getShinsainList(GogitaiJohoSakuseiParameter param) {

        List<GogitaiJohoSakuseiRsult> resultList = new ArrayList<>();
        List<GogitaiJohoSakuseiRelateEntity> shinsainList
                = mapperProvider.create(IGogitaiJohoSakuseiMapper.class).getShinsainList(param);
        if (shinsainList.isEmpty()) {
            return SearchResult.of(Collections.<GogitaiJohoSakuseiRsult>emptyList(), 0, false);
        }
        for (GogitaiJohoSakuseiRelateEntity entity : shinsainList) {
            resultList.add(new GogitaiJohoSakuseiRsult(entity));
        }
        return SearchResult.of(resultList, 0, false);
    }

    /**
     * 合議体番号を取得します。
     *
     * @param 合議体番号 合議体番号
     * @return int
     */
    public int getGogitaiNoJuuhuku(int 合議体番号) {
        return dbt5591dac.selectgogitaiNoJuuhukuByKey(合議体番号);
    }

    /**
     * 開催場所コードの存在をチェックします。
     *
     * @param 開催場所コード 開催場所コード
     * @return true:存在 false:存在しない
     */
    public boolean getKaisaiBashoCode(RString 開催場所コード) {
        UzT0007CodeEntity entity = CodeMaster.getCode(
                SubGyomuCode.DBE認定支援,
                new CodeShubetsu(new RString("5001")),
                new Code(開催場所コード));
        return entity != null;
    }

    /**
     * CSV出力内容を取得します。
     *
     * @param param 合議体情報作成のパラメータ
     * @return SearchResult<GogitaiJohoSakuseiRsult>
     */
    public SearchResult<GogitaiJohoSakuseiRsult> getGogitaiJohoForCSV(GogitaiJohoSakuseiParameter param) {
        List<GogitaiJohoSakuseiRsult> resultList = new ArrayList<>();
        List<GogitaiJohoSakuseiRelateEntity> gogitaiJohoForCSVList
                = mapperProvider.create(IGogitaiJohoSakuseiMapper.class).getGogitaiJohoForCSV(param);
        if (gogitaiJohoForCSVList.isEmpty()) {
            return SearchResult.of(Collections.<GogitaiJohoSakuseiRsult>emptyList(), 0, false);
        }
        for (GogitaiJohoSakuseiRelateEntity entity : gogitaiJohoForCSVList) {
            resultList.add(new GogitaiJohoSakuseiRsult(entity));
        }
        return SearchResult.of(resultList, 0, false);
    }

    /**
     * 合議体割当委員情報が存在しているをチェックします。
     *
     * @param 合議体番号 合議体番号
     * @return true:存在 false:存在しない
     */
    public boolean getGogitaiWariateIinJohoCount(int 合議体番号) {
        return 0 != dbt5593dac.selectByGogitaiNO(合議体番号);
    }

    /**
     * 介護認定審査会開催予定情報が存在しているをチェックします。
     *
     * @param 合議体番号 合議体番号
     * @return true:存在 false:存在しない
     */
    public boolean getShinsakaiKaisaiYoteiJohoCount(int 合議体番号) {
        return 0 != dbt5501dac.selectByGogitaiNO(合議体番号);
    }
}
