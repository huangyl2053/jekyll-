/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.jigyohokokugeppohoseihako;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.jigyohokokunenpo.JigyoHokokuNenpoResult;
import jp.co.ndensan.reams.db.dbu.business.jigyohokokunenpo.ShichosonCodeNameResult;
import jp.co.ndensan.reams.db.dbu.definition.jigyohokokugeppoo.JigyoHokokuGeppoDataDeleteParameter;
import jp.co.ndensan.reams.db.dbu.definition.jigyohokokugeppoo.JigyoHokokuGeppoDataUpdateParameter;
import jp.co.ndensan.reams.db.dbu.definition.jigyohokokugeppoo.JigyoHokokuGeppoDetalSearchParameter;
import jp.co.ndensan.reams.db.dbu.definition.jigyohokokugeppoo.JigyoHokokuGeppoSearchParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntity;
import jp.co.ndensan.reams.db.dbu.persistence.jigyohokokugeppohoseihako.IJigyoHokokuGeppoHoseiHakoMapper;
import jp.co.ndensan.reams.db.dbx.business.config.kyotsu.gappeijohokanri.GappeiJohoKanriConfig;
import jp.co.ndensan.reams.db.dbx.business.config.kyotsu.gappeijohokanri.GappeiJohoKubun;
import jp.co.ndensan.reams.db.dbx.business.shichosonsecurityjoho.KoseiShichosonJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.DonyukeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7056GappeiShichosonEntity;
import jp.co.ndensan.reams.db.dbx.service.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.TokeiTaishoKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.koseishichoson.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.core.basic.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * @author sunhui
 */
public class JigyoHokokuGeppoHoseiHako {

    public JigyoHokokuGeppoHoseiHako() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }
    private final MapperProvider mapperProvider;

    /**
     *
     * @param provider
     */
    JigyoHokokuGeppoHoseiHako(MapperProvider provider) {
        this.mapperProvider = provider;
    }

    /**
     *
     * @return 市町村コード、名称リスト
     */
    @Transaction
    public SearchResult<ShichosonCodeNameResult> getShichosonCodeNameList() {
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        Code 導入形態コード = new Code("423");
        KoseiShichosonJoho 市町村情報 = null;
//        DbT7056GappeiShichosonEntity gappeiShichosonEntity = new DbT7056GappeiShichosonEntity();
        GappeiJohoKubun 合併情報区分 = GappeiJohoKubun.合併なし;
        KoikiShichosonJohoFinder koikiShichosonJohoFinder = KoikiShichosonJohoFinder.createInstance();
        SearchResult<KoikiZenShichosonJoho> searchResult = koikiShichosonJohoFinder.getGenShichosonJoho();
        List<ShichosonCodeNameResult> 出力市町村情報 = new ArrayList<>();
        LasdecCode 市町村コード;                                    
        RString 市町村名称;
        ShoKisaiHokenshaNo 保険者コード;
        TokeiTaishoKubun 保険者区分;
        if (市町村セキュリティ情報 != null) {
            導入形態コード = 市町村セキュリティ情報.get導入形態コード();
            導入形態コード = new Code("453");
            市町村情報 = 市町村セキュリティ情報.get市町村情報();
        } else {
            return null;
            // throw new IllegalStateException(UrErrorMessages.存在しない.toString());
        }
        if (合併情報区分 == null) {
            return null;
//            throw new IllegalStateException(UrErrorMessages.存在しない.toString());
        }
        if (導入形態コード.equals(DonyukeitaiCode.事務広域) || 導入形態コード.equals(DonyukeitaiCode.認定広域)) {
            if (合併情報区分 == 合併情報区分.合併なし) {//3.1
                if ("00".equals(市町村情報.get市町村識別ID())) {
                    市町村コード = 市町村セキュリティ情報.get市町村情報().get市町村コード();
                    市町村名称 = 市町村セキュリティ情報.get市町村情報().get市町村名称();
                    保険者コード = 市町村セキュリティ情報.get市町村情報().get証記載保険者番号();
                    保険者区分 = TokeiTaishoKubun.保険者分;
                    出力市町村情報.add(new ShichosonCodeNameResult(市町村コード, 市町村名称, 保険者コード, new RString(保険者区分.toString())));
                    if (searchResult == null || searchResult.totalCount() == 0) {
                        return null;
//                        throw new IllegalStateException(UrErrorMessages.存在しない.toString());
                    } else {
                        for (int i = 0; i < searchResult.totalCount(); i++) {
                            市町村コード = searchResult.records().get(i).get市町村コード();
                            市町村名称 = searchResult.records().get(i).get市町村名称();
                            保険者コード = searchResult.records().get(i).get証記載保険者番号();
                            保険者区分 = TokeiTaishoKubun.構成市町村分;
                            出力市町村情報.add(new ShichosonCodeNameResult(市町村コード, 市町村名称, 保険者コード, new RString(保険者区分.toString())));
                        }
                    }
                    return SearchResult.of(出力市町村情報, 0, false);
                } else {
                    return null;
//                    throw new IllegalStateException(UrErrorMessages.存在しない.toString());
                }
            } else {//3.2
                if ("00".equals(市町村情報.get市町村識別ID())) {//3.2.1
                    市町村コード = 市町村セキュリティ情報.get市町村情報().get市町村コード();//3.2.1.1
                    市町村名称 = 市町村セキュリティ情報.get市町村情報().get市町村名称();
                    保険者コード = 市町村セキュリティ情報.get市町村情報().get証記載保険者番号();
                    保険者区分 = TokeiTaishoKubun.保険者分;
                    出力市町村情報.add(new ShichosonCodeNameResult(市町村コード, 市町村名称, 保険者コード, new RString(保険者区分.toString())));
                    searchResult = koikiShichosonJohoFinder.getZenShichosonJoho();//3/2/1.2
                    if (searchResult == null || searchResult.totalCount() == 0) {
                        return null;
//                        throw new IllegalStateException(UrErrorMessages.存在しない.toString());
                    } else {
                        for (int i = 0; i < searchResult.totalCount(); i++) {
                            市町村コード = searchResult.records().get(i).get市町村コード();
                            市町村名称 = searchResult.records().get(i).get市町村名称();
                            保険者コード = searchResult.records().get(i).get証記載保険者番号();
                            if ("0".equals(searchResult.records().get(i).get合併旧市町村区分())) {
                                保険者区分 = TokeiTaishoKubun.構成市町村分;
                            } else {
                                保険者区分 = TokeiTaishoKubun.旧市町村分;
                            }
                            出力市町村情報.add(new ShichosonCodeNameResult(市町村コード, 市町村名称, 保険者コード, new RString(保険者区分.toString())));
                        }
                    }
                    return SearchResult.of(出力市町村情報, 0, false);//3.2.1.3

                } else {
                    return null;
//                    throw new IllegalStateException(UrErrorMessages.存在しない.toString());
                }
            }//3.2
        } else {
            if (合併情報区分 == 合併情報区分.合併あり) {
                市町村コード = 市町村セキュリティ情報.get市町村情報().get市町村コード();
                    市町村名称 = 市町村セキュリティ情報.get市町村情報().get市町村名称();
                    保険者コード = 市町村セキュリティ情報.get市町村情報().get証記載保険者番号();
                    保険者区分 = TokeiTaishoKubun.保険者分;
                出力市町村情報.add(new ShichosonCodeNameResult(市町村コード, 市町村名称, 保険者コード, new RString(保険者区分.toString())));
                return SearchResult.of(出力市町村情報, 0, false);
            } else {
//                市町村セキュリティ情報.
                市町村コード = 市町村セキュリティ情報.get市町村情報().get市町村コード();//3.2.1.1
                    市町村名称 = 市町村セキュリティ情報.get市町村情報().get市町村名称();
                    保険者コード = 市町村セキュリティ情報.get市町村情報().get証記載保険者番号();
                    保険者区分 = TokeiTaishoKubun.保険者分;
                出力市町村情報.add(new ShichosonCodeNameResult(市町村コード, 市町村名称, 保険者コード, new RString(保険者区分.toString())));
                //  KyuShichosonCodeJoho kyuShichosonCodeJoho=KyuShichosonCode.getKyuShichosonCodeJoho(市町村情報.get市町村コード());
                searchResult = koikiShichosonJohoFinder.getZenShichosonJoho();
                if (searchResult == null || searchResult.totalCount() == 0) {
                    return null;
                    //   throw new IllegalStateException(UrErrorMessages.存在しない.toString());
                } else {
                    for (int i = 0; i < searchResult.totalCount(); i++) {
                        市町村コード = searchResult.records().get(i).get市町村コード();
                        市町村名称 = searchResult.records().get(i).get市町村名称();
                        保険者コード = searchResult.records().get(i).get運用保険者番号();
//                            if ("0".equals(searchResult.records().get(i).getGappeiKyuShichosonKubun())) {
//                                保険者区分 = TokeiTaishoKubun.構成市町村分;
//                            } else {
                        保険者区分 = TokeiTaishoKubun.旧市町村分;
//                            }
                        出力市町村情報.add(new ShichosonCodeNameResult(市町村コード, 市町村名称, 保険者コード, new RString(保険者区分.toString())));
                    }

                }
                return SearchResult.of(出力市町村情報, 0, false);
            }
        }
    }

    /**
     *
     * @param jigyoHokokuGeppoParameter
     * @return 事業報告集計一覧データ
     */
    @Transaction
    public List<JigyoHokokuNenpoResult> getJigyoHokokuGeppoList(JigyoHokokuGeppoSearchParameter jigyoHokokuGeppoParameter) {
        List<JigyoHokokuNenpoResult> businessList = new ArrayList<>();
        List<DbT7021JigyoHokokuTokeiDataEntity> 事業報告集計一覧データ = new ArrayList<DbT7021JigyoHokokuTokeiDataEntity>();
        IJigyoHokokuGeppoHoseiHakoMapper HoseiHakoMapper = mapperProvider.create(IJigyoHokokuGeppoHoseiHakoMapper.class);
        事業報告集計一覧データ = HoseiHakoMapper.select事業報告集計一覧データ(jigyoHokokuGeppoParameter);
        for (DbT7021JigyoHokokuTokeiDataEntity entity : 事業報告集計一覧データ) {
            entity.initializeMd5();
            businessList.add(new JigyoHokokuNenpoResult(entity));
        }
        return businessList;

    }

    /**
     *
     * @param jigyoHokokuGeppoDetalParameter
     * @return 報告年度、様式種類より集計データ
     */
    @Transaction
    public List<DbT7021JigyoHokokuTokeiDataEntity> getJigyoHokokuGeppoDetal(JigyoHokokuGeppoDetalSearchParameter jigyoHokokuGeppoDetalParameter) {
        List<DbT7021JigyoHokokuTokeiDataEntity> businessList = new ArrayList<>();
        List<DbT7021JigyoHokokuTokeiDataEntity> 事業報告集計一覧データ = new ArrayList<DbT7021JigyoHokokuTokeiDataEntity>();
        IJigyoHokokuGeppoHoseiHakoMapper hoseiHakoMapper = mapperProvider.create(IJigyoHokokuGeppoHoseiHakoMapper.class);
        事業報告集計一覧データ = hoseiHakoMapper.select報告年度様式種類(jigyoHokokuGeppoDetalParameter);
        for (DbT7021JigyoHokokuTokeiDataEntity entity : 事業報告集計一覧データ) {
            businessList.add(entity);
        }
        return businessList;
    }

    /**
     *
     * @param jigyoHokokuNenpoResult
     * @return 更新件数
     */
    @Transaction
    public int updateJigyoHokokuGeppoData(List<JigyoHokokuNenpoResult> jigyoHokokuNenpoResult) {
        int updateCount = 0;
        IJigyoHokokuGeppoHoseiHakoMapper hoseiHakoMapper = mapperProvider.create(IJigyoHokokuGeppoHoseiHakoMapper.class);
        for (JigyoHokokuNenpoResult jigyoHokokuTokeiData : jigyoHokokuNenpoResult) {
            JigyoHokokuGeppoDataUpdateParameter jigyoHokokuGeppoDataeParameter = JigyoHokokuGeppoDataUpdateParameter.createParameterForJigyoHokokuGeppoData(jigyoHokokuTokeiData.get集計単位(), jigyoHokokuTokeiData.get集計結果値(), jigyoHokokuTokeiData.get報告年(), jigyoHokokuTokeiData.get報告月(), jigyoHokokuTokeiData.get集計対象年(), jigyoHokokuTokeiData.get集計対象月(), jigyoHokokuTokeiData.get統計対象区分(), jigyoHokokuTokeiData.get市町村コード(), jigyoHokokuTokeiData.get表番号(), jigyoHokokuTokeiData.get集計番号(), jigyoHokokuTokeiData.get縦番号(), jigyoHokokuTokeiData.get横番号());
            updateCount = hoseiHakoMapper.update事業報告集計一覧データ(jigyoHokokuGeppoDataeParameter);
        }
        return updateCount;

    }

    /**
     *
     * @param JigyoHokokuGeppoDataParameter
     * @return 削除件数
     */
    @Transaction
    public int deleteJigyoHokokuGeppoData(JigyoHokokuGeppoDataDeleteParameter JigyoHokokuGeppoDataParameter) {
        int deleteCount = 0;
        IJigyoHokokuGeppoHoseiHakoMapper hoseiHakoMapper = mapperProvider.create(IJigyoHokokuGeppoHoseiHakoMapper.class);
        deleteCount = hoseiHakoMapper.delete事業報告年報(JigyoHokokuGeppoDataParameter);
        return deleteCount;
    }
}
