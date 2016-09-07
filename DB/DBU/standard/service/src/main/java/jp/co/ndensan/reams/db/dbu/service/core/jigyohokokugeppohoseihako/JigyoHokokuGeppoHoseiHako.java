/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.core.jigyohokokugeppohoseihako;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.message.DbaErrorMessages;
import jp.co.ndensan.reams.db.dbu.business.core.basic.JigyoHokokuTokeiData;
import jp.co.ndensan.reams.db.dbu.business.core.jigyohokokugeppohoseihako.JigyoHokokuGeppoHoseiHakoResult;
import jp.co.ndensan.reams.db.dbu.business.core.jigyohokokunenpo.ShichosonCodeNameResult;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokugeppoo.JigyoHokokuGeppoDetalSearchParameter;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokugeppoo.JigyoHokokuGeppoSearchParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppohoseihako.JigyoHokokuGeppoHoseiHakoEntity;
import jp.co.ndensan.reams.db.dbu.persistence.db.basic.DbT7021JigyoHokokuTokeiDataDac;
import jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyohokokugeppohoseihako.IJigyoHokokuGeppoHoseiHakoMapper;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurityjoho.KoseiShichosonJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.TokeiTaishoKubun;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.core.gappeijoho.gappeijoho.GappeiCityJohoBFinder;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.db.dbz.service.core.kyushichosoncode.KyuShichosonCode;
import jp.co.ndensan.reams.db.dbz.service.core.kyushichosoncode.KyuShichosonCodeJoho;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 事業報告（月報）補正発行するクラスです。
 *
 * @reamsid_L DBU-1100-100 cuilin
 */
public class JigyoHokokuGeppoHoseiHako {

    private static final RString 導入済 = new RString("1");
    private static final RString 合併情報区分_合併なし = new RString("0");
    private static final RString 合併情報区分_合併あり = new RString("1");
    private static final RString 市町村識別ID_00 = new RString("00");
    private static final RString 合併旧市町村区分0 = new RString("0");
    private static final RString 合併旧市町村区分1 = new RString("1");
    private static final RString 市町村情報メッセージ = new RString("市町村セキュリティ情報");
    private static final RString 合併情報区分メッセージ = new RString("合併情報区分");
    private static final RString 現市町村情報メッセージ = new RString("現市町村情報");
    private static final RString 全市町村情報メッセージ = new RString("全市町村情報");
    private static final RString 旧市町村コード情報メッセージ = new RString("旧市町村コード情報");
    private final MapperProvider mapperProvider;
    private final DbT7021JigyoHokokuTokeiDataDac dac;

    /**
     * コンストラクタです。
     */
    public JigyoHokokuGeppoHoseiHako() {
        dac = InstanceProvider.create(DbT7021JigyoHokokuTokeiDataDac.class);
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link JigyoHokokuGeppoHoseiHako}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link JigyoHokokuGeppoHoseiHako}のインスタンス
     */
    public static JigyoHokokuGeppoHoseiHako createInstance() {
        return InstanceProvider.create(JigyoHokokuGeppoHoseiHako.class);
    }

    /**
     * コンストラクタです。
     *
     * @param provider
     */
    JigyoHokokuGeppoHoseiHako(MapperProvider provider) {
        dac = InstanceProvider.create(DbT7021JigyoHokokuTokeiDataDac.class);
        this.mapperProvider = provider;
    }

    /**
     * 市町村コード、名称リストを取得するメソッド
     *
     * @return 市町村コード、名称リスト
     */
    @Transaction
    public List<ShichosonCodeNameResult> getShichosonCodeNameList() {
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(
                GyomuBunrui.介護事務);
        if (!導入済.equals(市町村セキュリティ情報.get介護導入区分())) {
            throw new ApplicationException(UrErrorMessages.存在しない.getMessage()
                    .replace(市町村情報メッセージ.toString()));
        }
        Code 導入形態コード = 市町村セキュリティ情報.get導入形態コード();
        KoseiShichosonJoho 市町村情報 = 市町村セキュリティ情報.get市町村情報();
        GappeiCityJohoBFinder gappeiCityJohoBFinder = GappeiCityJohoBFinder.createInstance();
        RString 合併情報区分 = gappeiCityJohoBFinder.getGappeijohokubun();
        if (合併情報区分 == null || 合併情報区分.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.存在しない.getMessage()
                    .replace(合併情報区分メッセージ.toString()));
        }
        List<ShichosonCodeNameResult> 出力市町村情報 = new ArrayList<>();
        if (DonyuKeitaiCode.事務広域.getCode().equals(導入形態コード.getKey())
                || DonyuKeitaiCode.認定広域.getCode().equals(導入形態コード.getKey())) {
            if (!市町村識別ID_00.equals(市町村情報.get市町村識別ID())) {
                throw new ApplicationException(DbaErrorMessages.広域構成市町村からの補正処理.getMessage().evaluate());
            }
            if (合併情報区分_合併なし.equals(合併情報区分)) {
                出力市町村情報.add(new ShichosonCodeNameResult(市町村情報.get市町村コード(), 市町村情報.get市町村名称(),
                        市町村情報.get証記載保険者番号(), TokeiTaishoKubun.保険者分.getコード()));
                get現市町村情報(出力市町村情報);
            } else if (合併情報区分_合併あり.equals(合併情報区分)) {
                出力市町村情報.add(new ShichosonCodeNameResult(市町村情報.get市町村コード(),
                        市町村情報.get市町村名称(),
                        市町村情報.get証記載保険者番号(),
                        TokeiTaishoKubun.保険者分.getコード()));
                get全市町村情報(出力市町村情報);
            }
        } else {
            if (合併情報区分_合併なし.equals(合併情報区分)) {
                出力市町村情報.add(new ShichosonCodeNameResult(市町村情報.get市町村コード(),
                        市町村情報.get市町村名称(),
                        市町村情報.get証記載保険者番号(),
                        TokeiTaishoKubun.保険者分.getコード()));
            } else if (合併情報区分_合併あり.equals(合併情報区分)) {
                出力市町村情報.add(new ShichosonCodeNameResult(市町村情報.get市町村コード(),
                        市町村情報.get市町村名称(),
                        市町村情報.get証記載保険者番号(),
                        TokeiTaishoKubun.保険者分.getコード()));
                get旧市町村コード情報(出力市町村情報, 市町村情報, 導入形態コード);
            }
        }
        return 出力市町村情報;
    }

    /**
     * 現市町村情報の取得するメソッド
     *
     * @param 出力市町村情報
     */
    private void get現市町村情報(List<ShichosonCodeNameResult> 出力市町村情報) {
        KoikiShichosonJohoFinder koikiShichosonJohoFinder = KoikiShichosonJohoFinder.createInstance();
        SearchResult<KoikiZenShichosonJoho> koikiZenShichosonJoho = koikiShichosonJohoFinder.
                getGenShichosonJoho();
        if (koikiZenShichosonJoho == null || koikiZenShichosonJoho.records().isEmpty()) {
            throw new ApplicationException(UrErrorMessages.存在しない.getMessage()
                    .replace(現市町村情報メッセージ.toString()));
        }
        for (int i = 0; i < koikiZenShichosonJoho.records().size(); i++) {
            出力市町村情報.add(new ShichosonCodeNameResult(
                    koikiZenShichosonJoho.records().get(i).get市町村コード(),
                    koikiZenShichosonJoho.records().get(i).get市町村名称(),
                    koikiZenShichosonJoho.records().get(i).get証記載保険者番号(),
                    TokeiTaishoKubun.構成市町村分.getコード()));
        }
    }

    /**
     * 全市町村情報の取得するメソッド
     *
     * @param 出力市町村情報
     */
    private void get全市町村情報(List<ShichosonCodeNameResult> 出力市町村情報) {
        KoikiShichosonJohoFinder koikiShichosonJohoFinder = KoikiShichosonJohoFinder.createInstance();
        SearchResult<KoikiZenShichosonJoho> koikiZenShichosonJoho = koikiShichosonJohoFinder.
                getZenShichosonJoho();
        if ((koikiZenShichosonJoho == null || koikiZenShichosonJoho.records().isEmpty())) {
            throw new ApplicationException(UrErrorMessages.存在しない.getMessage()
                    .replace(全市町村情報メッセージ.toString()));
        }
        for (int i = 0; i < koikiZenShichosonJoho.records().size(); i++) {
            if (合併旧市町村区分0.equals(koikiZenShichosonJoho.records().get(i).get合併旧市町村区分())) {
                出力市町村情報.add(new ShichosonCodeNameResult(
                        koikiZenShichosonJoho.records().get(i).get市町村コード(),
                        koikiZenShichosonJoho.records().get(i).get市町村名称(),
                        koikiZenShichosonJoho.records().get(i).get証記載保険者番号(),
                        TokeiTaishoKubun.構成市町村分.getコード()));
            } else if (合併旧市町村区分1.equals(koikiZenShichosonJoho.records().get(i).get合併旧市町村区分())) {
                出力市町村情報.add(new ShichosonCodeNameResult(
                        koikiZenShichosonJoho.records().get(i).get市町村コード(),
                        koikiZenShichosonJoho.records().get(i).get市町村名称(),
                        koikiZenShichosonJoho.records().get(i).get証記載保険者番号(),
                        TokeiTaishoKubun.旧市町村分.getコード()));
            }
        }
    }

    /**
     * 旧市町村コード情報の取得するメソッド
     *
     * @param 出力市町村情報
     * @param 市町村情報
     * @param 導入形態コード
     */
    private void get旧市町村コード情報(List<ShichosonCodeNameResult> 出力市町村情報,
            KoseiShichosonJoho 市町村情報,
            Code 導入形態コード) {
        KyuShichosonCodeJoho kyuShichosonCodeJoho = KyuShichosonCode.getKyuShichosonCodeJoho(
                市町村情報.get市町村コード(),
                DonyuKeitaiCode.toValue(導入形態コード.getKey()));

        if (kyuShichosonCodeJoho == null || kyuShichosonCodeJoho.get旧市町村コード情報List().isEmpty()) {
            throw new ApplicationException(UrErrorMessages.存在しない.getMessage()
                    .replace(旧市町村コード情報メッセージ.toString()));
        }
        for (KyuShichosonCode kyuShichosonCode : kyuShichosonCodeJoho.get旧市町村コード情報List()) {
            出力市町村情報.add(new ShichosonCodeNameResult(
                    kyuShichosonCode.get旧市町村コード(),
                    kyuShichosonCode.get旧市町村名称(),
                    new ShoKisaiHokenshaNo(kyuShichosonCode.get旧保険者番号().getColumnValue()),
                    TokeiTaishoKubun.旧市町村分.getコード()));
        }

    }

    /**
     * 事業報告集計一覧データの取得するメソッド
     *
     * @param parameter 事業報告集計一覧用パラメータ
     * @return 事業報告集計一覧データ
     */
    @Transaction
    public List<JigyoHokokuGeppoHoseiHakoResult> getJigyoHokokuGeppoList(JigyoHokokuGeppoSearchParameter parameter) {
        List<JigyoHokokuGeppoHoseiHakoResult> businessList = new ArrayList<>();
        IJigyoHokokuGeppoHoseiHakoMapper hoseiHakoMapper
                = mapperProvider.create(IJigyoHokokuGeppoHoseiHakoMapper.class);
        List<JigyoHokokuGeppoHoseiHakoEntity> 事業報告集計一覧データ = hoseiHakoMapper.select事業報告集計一覧データ(
                parameter);
        if (事業報告集計一覧データ != null && !事業報告集計一覧データ.isEmpty()) {
            for (JigyoHokokuGeppoHoseiHakoEntity entity : 事業報告集計一覧データ) {
                businessList.add(new JigyoHokokuGeppoHoseiHakoResult(entity));
            }
        }
        return businessList;
    }

    /**
     * 事業報告報詳細データの取得するメソッド
     *
     * @param parameter 事業報告報詳細用パラメータ
     * @return 報告年度、様式種類より集計データ
     */
    @Transaction
    public List<JigyoHokokuTokeiData> getJigyoHokokuGeppoDetal(
            JigyoHokokuGeppoDetalSearchParameter parameter) {
        List<JigyoHokokuTokeiData> jigyoHokokuTokeiDataList = new ArrayList<>();
        List<DbT7021JigyoHokokuTokeiDataEntity> entityList = dac.select報告年度様式種類(
                parameter.get報告年(),
                parameter.get報告月(),
                parameter.get集計対象年(),
                parameter.get集計対象月(),
                parameter.get統計対象区分(),
                parameter.get市町村コード(),
                parameter.get表番号(),
                parameter.get集計番号());
        for (DbT7021JigyoHokokuTokeiDataEntity entity : entityList) {
            JigyoHokokuTokeiData data = new JigyoHokokuTokeiData(entity);
            jigyoHokokuTokeiDataList.add(data);
        }
        return jigyoHokokuTokeiDataList;
    }

    /**
     * 事業報告月報詳細データの更新するメソッド
     *
     * @param parameterList パラメータList
     * @return 更新件数
     */
    @Transaction
    public int updateJigyoHokokuGeppoData(List<JigyoHokokuTokeiData> parameterList) {
        int updateCount = 0;
        if (parameterList != null && !parameterList.isEmpty()) {
            for (JigyoHokokuTokeiData entity : parameterList) {
                DbT7021JigyoHokokuTokeiDataEntity dataEntity = entity.toEntity();
                dataEntity.setState(EntityDataState.Modified);
                updateCount = updateCount + dac.save(dataEntity);
            }
        }
        return updateCount;
    }

    /**
     * 事業報告月報詳細データの削除するメソッド
     *
     * @param 事業報告月報詳細データリスト List<JigyoHokokuTokeiData>
     * @return 削除件数
     */
    @Transaction
    public int deleteJigyoHokokuGeppoData(List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト) {
        int deletecount = 0;
        if (事業報告月報詳細データリスト != null && !事業報告月報詳細データリスト.isEmpty()) {
            for (JigyoHokokuTokeiData data : 事業報告月報詳細データリスト) {
                DbT7021JigyoHokokuTokeiDataEntity entity = data.toEntity();
                entity.setState(EntityDataState.Deleted);
                deletecount = dac.delete(entity);
            }
        }
        return deletecount;
    }

    /**
     * 事業報告月報詳細データの更新するメソッド
     *
     * @param parameterList パラメータList
     * @return 更新件数
     */
    @Transaction
    public int updateJigyoHokokuGeppoEntity(List<JigyoHokokuTokeiData> parameterList) {
        int updateCount = 0;
        if (parameterList != null && !parameterList.isEmpty()) {
            for (JigyoHokokuTokeiData entity : parameterList) {
                DbT7021JigyoHokokuTokeiDataEntity dataEntity = entity.toEntity();
                updateCount = updateCount + dac.save(dataEntity);
            }
        }
        return updateCount;
    }
}
