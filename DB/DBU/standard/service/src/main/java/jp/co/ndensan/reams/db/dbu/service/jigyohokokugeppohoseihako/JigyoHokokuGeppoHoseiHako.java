/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.jigyohokokugeppohoseihako;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.basic.JigyoHokokuTokeiData;
import jp.co.ndensan.reams.db.dbu.business.jigyohokokunenpo.ShichosonCodeNameResult;
import jp.co.ndensan.reams.db.dbu.definition.jigyohokokugeppoo.JigyoHokokuGeppoDataDeleteParameter;
import jp.co.ndensan.reams.db.dbu.definition.jigyohokokugeppoo.JigyoHokokuGeppoDetalSearchParameter;
import jp.co.ndensan.reams.db.dbu.definition.jigyohokokugeppoo.JigyoHokokuGeppoSearchParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.jigyohokokugeppohoseihako.JigyoHokokuGeppoHoseiHakoEntity;
import jp.co.ndensan.reams.db.dbu.business.jigyohokokugeppohoseihako.JigyoHokokuGeppoHoseiHakoResult;
import jp.co.ndensan.reams.db.dbu.persistence.db.basic.DbT7021JigyoHokokuTokeiDataDac;
import jp.co.ndensan.reams.db.dbu.persistence.jigyohokokugeppohoseihako.IJigyoHokokuGeppoHoseiHakoMapper;
import jp.co.ndensan.reams.db.dbx.business.shichosonsecurityjoho.KoseiShichosonJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.TokeiTaishoKubun;
import jp.co.ndensan.reams.db.dbz.service.KyuShichosonCode;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.core.basic.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.db.dbz.service.core.gappeijoho.gappeijoho.GappeiCityJohoBFinder;
import jp.co.ndensan.reams.db.dbz.service.kyushichosoncode.KyuShichosonCodeJoho;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.DonyukeitaiCode;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * @author sunhui
 */
public class JigyoHokokuGeppoHoseiHako {

    private final static RString 導入済 = new RString("1");
    private static final RString 合併情報区分_合併なし = new RString("0");
    private static final RString 合併情報区分_合併あり = new RString("1");
    private static final RString 市町村識別ID_00 = new RString("00");
    private static final RString 合併旧市町村区分 = new RString("0");

    public JigyoHokokuGeppoHoseiHako() {
        dac = InstanceProvider.create(DbT7021JigyoHokokuTokeiDataDac.class);
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }
    private final MapperProvider mapperProvider;
    private final DbT7021JigyoHokokuTokeiDataDac dac;

    /**
     *
     * @param provider
     */
    JigyoHokokuGeppoHoseiHako(MapperProvider provider) {
        dac = InstanceProvider.create(DbT7021JigyoHokokuTokeiDataDac.class);
        this.mapperProvider = provider;
    }

    /**
     * 市町村のリスト取得
     *
     * @return 市町村コード、名称リスト
     */
    @Transaction
    public SearchResult<ShichosonCodeNameResult> getShichosonCodeNameList() {
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (!導入済.equals(市町村セキュリティ情報.get介護導入区分())) {
            throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace("市町村セキュリティ情報"));
        }
        Code 導入形態コード = 市町村セキュリティ情報.get導入形態コード();
        KoseiShichosonJoho 市町村情報 = 市町村セキュリティ情報.get市町村情報();
        GappeiCityJohoBFinder gappeiCityJohoBFinder = GappeiCityJohoBFinder.createInstance();
        RString 合併情報区分 = gappeiCityJohoBFinder.getGappeijohokubun();
        if (合併情報区分 == null || 合併情報区分.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace("合併情報区分"));
        }
        List<ShichosonCodeNameResult> 出力市町村情報 = new ArrayList<>();
        if (導入形態コード.value().equals(DonyukeitaiCode.事務広域.getCode())
                || 導入形態コード.value().equals(DonyukeitaiCode.認定広域.getCode())) {
            if (合併情報区分.equals(合併情報区分_合併なし)) {//3.1
                if (市町村識別ID_00.equals(市町村情報.get市町村識別ID())) {
                    出力市町村情報.add(new ShichosonCodeNameResult(市町村情報.get市町村コード(), 市町村情報.get市町村名称(),
                            市町村情報.get証記載保険者番号(), TokeiTaishoKubun.保険者分.getコード()));
                    KoikiShichosonJohoFinder koikiShichosonJohoFinder = KoikiShichosonJohoFinder.createInstance();
                    SearchResult<KoikiZenShichosonJoho> koikiZenShichosonJoho = koikiShichosonJohoFinder.getGenShichosonJoho();
                    if (koikiZenShichosonJoho == null || koikiZenShichosonJoho.totalCount() == 0) {
                        throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace("現市町村情報"));
                    } else {
                        for (int i = 0; i < koikiZenShichosonJoho.totalCount(); i++) {
                            if (合併旧市町村区分.equals(koikiZenShichosonJoho.records().get(i).get合併旧市町村区分())) {

                            }
                            出力市町村情報.add(new ShichosonCodeNameResult(koikiZenShichosonJoho.records().get(i).get市町村コード(),
                                    koikiZenShichosonJoho.records().get(i).get市町村名称(),
                                    koikiZenShichosonJoho.records().get(i).get証記載保険者番号(),
                                    TokeiTaishoKubun.構成市町村分.getコード()));
                        }
                    }

                    return SearchResult.of(出力市町村情報, 0, false);
                } else {
                    throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace("広域構成市町村からの補正処理は行えません"));
                }
            } else {
                if (new RString("00").equals(市町村情報.get市町村識別ID())) {
                    出力市町村情報.add(new ShichosonCodeNameResult(市町村セキュリティ情報.get市町村情報().get市町村コード(), 市町村セキュリティ情報.get市町村情報().get市町村名称(), 市町村セキュリティ情報.get市町村情報().get証記載保険者番号(), TokeiTaishoKubun.保険者分.getコード()));
                    KoikiShichosonJohoFinder koikiShichosonJohoFinder = KoikiShichosonJohoFinder.createInstance();
                    SearchResult<KoikiZenShichosonJoho> koikiZenShichosonJoho = koikiShichosonJohoFinder.getZenShichosonJoho();
                    if ((koikiZenShichosonJoho == null || koikiZenShichosonJoho.totalCount() == 0)) {
                        throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace("全市町村情報が存在しません"));
                    } else {
                        for (int i = 0; i < koikiZenShichosonJoho.totalCount(); i++) {
                            出力市町村情報.add(new ShichosonCodeNameResult(koikiZenShichosonJoho.records().get(i).get市町村コード(),
                                    koikiZenShichosonJoho.records().get(i).get市町村名称(),
                                    koikiZenShichosonJoho.records().get(i).get証記載保険者番号(),
                                    TokeiTaishoKubun.構成市町村分.getコード()));
                        }
                    }
                    return SearchResult.of(出力市町村情報, 0, false);
                }
            }
        } else {
            if (合併情報区分.equals(合併情報区分_合併なし)) {
                出力市町村情報.add(new ShichosonCodeNameResult(市町村セキュリティ情報.get市町村情報().get市町村コード(), 市町村セキュリティ情報.get市町村情報().get市町村名称(), 市町村セキュリティ情報.get市町村情報().get証記載保険者番号(), TokeiTaishoKubun.保険者分.getコード()));
                return SearchResult.of(出力市町村情報, 0, false);
            } else {
                出力市町村情報.add(new ShichosonCodeNameResult(市町村セキュリティ情報.get市町村情報().get市町村コード(), 市町村セキュリティ情報.get市町村情報().get市町村名称(), 市町村セキュリティ情報.get市町村情報().get証記載保険者番号(), TokeiTaishoKubun.保険者分.getコード()));
                KyuShichosonCodeJoho kyuShichosonCodeJoho = KyuShichosonCode.getKyuShichosonCodeJoho(市町村セキュリティ情報.get市町村情報().get市町村コード(), DonyukeitaiCode.toValue(導入形態コード.getKey()));

                if (kyuShichosonCodeJoho.get旧市町村コード情報List().size() < 1) {
                    throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace("旧市町村コード情報が存在しません"));
                } else {
                    for (int i = 0; i < kyuShichosonCodeJoho.get旧市町村コード情報List().size(); i++) {
                        //TODO
                        // 出力市町村情報.add(new ShichosonCodeNameResult(kyuShichosonCodeJoho.get旧市町村コード情報List().get(i).get旧市町村コード(), kyuShichosonCodeJoho.get旧市町村コード情報List().get(i).get旧市町村名称(), kyuShichosonCodeJoho.get旧市町村コード情報List().get(i)., TokeiTaishoKubun.旧市町村分));
                    }

                }

            }
        }
        return SearchResult.of(出力市町村情報, 0, false);
    }

    /**
     * 事業報告集計一覧データの取得
     *
     * @param jigyoHokokuGeppoParameter
     * @return 事業報告集計一覧データ
     */
    @Transaction
    public List<JigyoHokokuGeppoHoseiHakoResult> getJigyoHokokuGeppoList(JigyoHokokuGeppoSearchParameter jigyoHokokuGeppoParameter) {
        List<JigyoHokokuGeppoHoseiHakoResult> businessList = new ArrayList<>();
        IJigyoHokokuGeppoHoseiHakoMapper HoseiHakoMapper = mapperProvider.create(IJigyoHokokuGeppoHoseiHakoMapper.class);
        List<JigyoHokokuGeppoHoseiHakoEntity> 事業報告集計一覧データ = HoseiHakoMapper.select事業報告集計一覧データ(jigyoHokokuGeppoParameter);
        for (JigyoHokokuGeppoHoseiHakoEntity entity : 事業報告集計一覧データ) {
            businessList.add(new JigyoHokokuGeppoHoseiHakoResult(entity));
        }
        return businessList;

    }

    /**
     * 事業報告報詳細データの取得
     *
     * @param jigyoHokokuGeppoDetalParameter
     * @return 報告年度、様式種類より集計データ
     */
    @Transaction
    public List<JigyoHokokuTokeiData> getJigyoHokokuGeppoDetal(JigyoHokokuGeppoDetalSearchParameter jigyoHokokuGeppoDetalParameter) {
        List<JigyoHokokuTokeiData> businessList = new ArrayList<>();
        List<DbT7021JigyoHokokuTokeiDataEntity> 事業報告集計一覧データ = dac.select報告年度様式種類(jigyoHokokuGeppoDetalParameter.get報告年(), jigyoHokokuGeppoDetalParameter.get報告月(), jigyoHokokuGeppoDetalParameter.get集計対象年(), jigyoHokokuGeppoDetalParameter.get集計対象月(), jigyoHokokuGeppoDetalParameter.get統計対象区分(), jigyoHokokuGeppoDetalParameter.get市町村コード(), jigyoHokokuGeppoDetalParameter.get表番号(), jigyoHokokuGeppoDetalParameter.get集計番号());
        for (DbT7021JigyoHokokuTokeiDataEntity entity : 事業報告集計一覧データ) {
            businessList.add(new JigyoHokokuTokeiData(entity));
        }
        return businessList;
    }

    /**
     * 事業報告月報詳細データの更新
     *
     * @param jigyoHokokuNenpoResult
     * @return 更新件数
     */
    @Transaction
    public int updateJigyoHokokuGeppoData(List<JigyoHokokuGeppoHoseiHakoResult> jigyoHokokuNenpoResult) {
        int updateCount = 0;
        DbT7021JigyoHokokuTokeiDataEntity entity;
        for (JigyoHokokuGeppoHoseiHakoResult jigyoHokokuTokeiData : jigyoHokokuNenpoResult) {
            entity = new DbT7021JigyoHokokuTokeiDataEntity();
            entity.setHokokuYSeireki(jigyoHokokuTokeiData.get報告年());
            entity.setHokokuM(jigyoHokokuTokeiData.get報告月());
            entity.setShukeiTaishoYSeireki(jigyoHokokuTokeiData.get集計対象年());
            entity.setShukeiTaishoM(jigyoHokokuTokeiData.get集計対象月());
            entity.setToukeiTaishoKubun(jigyoHokokuTokeiData.get統計対象区分());
            entity.setShichosonCode(jigyoHokokuTokeiData.get市町村コード());
            entity.setHyoNo(jigyoHokokuTokeiData.get表番号());
            entity.setShukeiNo(jigyoHokokuTokeiData.get集計番号());
            entity.setShukeiTani(jigyoHokokuTokeiData.get集計単位());

            entity.setTateNo(jigyoHokokuTokeiData.get縦番号());
            entity.setYokoNo(jigyoHokokuTokeiData.get横番号());
            entity.setShukeiKekkaAtai(jigyoHokokuTokeiData.get集計結果値());
            entity.setState(EntityDataState.Modified);
            updateCount=updateCount+dac.save(entity);
        }
        return updateCount;

    }

    /**
     * 事業報告月報詳細データの削除
     *
     * @param parameterList
     * @return 削除件数
     */
    @Transaction
    public int deleteJigyoHokokuGeppoData(List<JigyoHokokuGeppoDataDeleteParameter> parameterList) {
         int deleteCount = 0;
        DbT7021JigyoHokokuTokeiDataEntity entity;
       for(JigyoHokokuGeppoDataDeleteParameter parameter:parameterList){
           entity = new DbT7021JigyoHokokuTokeiDataEntity();
            entity.setHokokuYSeireki(parameter.get報告年());
            entity.setHokokuM(parameter.get報告月());
            entity.setShukeiTaishoYSeireki(parameter.get集計対象年());
            entity.setShukeiTaishoM(parameter.get集計対象月());
            entity.setToukeiTaishoKubun(parameter.get統計対象区分());
            entity.setShichosonCode(parameter.get市町村コード());
            entity.setHyoNo(parameter.get表番号());
            entity.setShukeiNo(parameter.get集計番号());
            entity.setState(EntityDataState.Deleted);
            deleteCount=deleteCount+dac.save(entity);
       }
       return deleteCount;
    }
}
