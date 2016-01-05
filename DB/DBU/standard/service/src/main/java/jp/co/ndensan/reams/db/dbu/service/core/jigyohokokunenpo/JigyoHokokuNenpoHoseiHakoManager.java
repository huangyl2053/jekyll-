package jp.co.ndensan.reams.db.dbu.service.core.jigyohokokunenpo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.jigyohokokunenpo.JigyoHokokuNenpoResult;
import jp.co.ndensan.reams.db.dbu.business.jigyohokokunenpo.ShichosonCodeNameResult;
import jp.co.ndensan.reams.db.dbu.definition.jigyohokokunenpo.DeleteJigyoHokokuNenpo;
import jp.co.ndensan.reams.db.dbu.definition.jigyohokokunenpo.JigyoHokokuNenpoDeleteParameter;
import jp.co.ndensan.reams.db.dbu.definition.jigyohokokunenpo.JigyoHokokuNenpoDetalParameter;
import jp.co.ndensan.reams.db.dbu.definition.jigyohokokunenpo.JigyoHokokuNenpoParameter;
import jp.co.ndensan.reams.db.dbu.definition.jigyohokokunenpo.JigyoHokokuNenpoUpdateParameter;
import jp.co.ndensan.reams.db.dbu.definition.jigyohokokunenpo.SearchJigyoHokokuNenpo;
import jp.co.ndensan.reams.db.dbu.definition.jigyohokokunenpo.ShukeiInfo;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntity;
import jp.co.ndensan.reams.db.dbu.persistence.jigyohokokunenpo.IJigyoHokokuNenpoMapper;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.KoseiShichosonJohoEntity;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.DonyukeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7056GappeiShichosonEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.gappeijoho.KyuShichosonCodeJohoRelateEntity;
import jp.co.ndensan.reams.db.dbx.service.core.gappeijoho.KyuShichosonCodeFinder;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.TokeiTaishoKubun;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.core.basic.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.db.dbz.service.core.gappeijoho.gappeijoho.GappeiCityJohoBFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 事業報告（年報）補正、発行のManagerクラスです。
 *
 */
public class JigyoHokokuNenpoHoseiHakoManager {

    private static final RString 合併情報区分_合併なし = new RString("0");
    private static final RString 合併情報区分_合併あり = new RString("1");
    private static final RString 市町村識別ID_00 = new RString("00");
    private static final RString 合併旧市町村区分_最新の広域構成市町村である = new RString("0");
    private static final RString 合併旧市町村区分_合併前の旧市町村である = new RString("1");
    private final MapperProvider mapperProvider;
    private final GappeiCityJohoBFinder gappeiCityJohoBFinder;
    private final ShichosonSecurityJohoFinder shichosonSecurityJoho;
    private final KoikiShichosonJohoFinder koikiShichosonJoho;
    private final KyuShichosonCodeFinder kyuShichosonCodeFinder;

    /**
     * コンストラクタです。
     */
    public JigyoHokokuNenpoHoseiHakoManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        gappeiCityJohoBFinder = InstanceProvider.create(GappeiCityJohoBFinder.class);
        shichosonSecurityJoho = InstanceProvider.create(ShichosonSecurityJohoFinder.class);
        koikiShichosonJoho = InstanceProvider.create(KoikiShichosonJohoFinder.class);
        kyuShichosonCodeFinder = InstanceProvider.create(KyuShichosonCodeFinder.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param gappeiCityJohoBFinder
     * @param shichosonSecurityJoho
     * @param koikiShichosonJoho
     * @param kyuShichosonCodeFinder
     */
    JigyoHokokuNenpoHoseiHakoManager(GappeiCityJohoBFinder gappeiCityJohoBFinder,
            ShichosonSecurityJohoFinder shichosonSecurityJoho,
            KoikiShichosonJohoFinder koikiShichosonJoho,
            KyuShichosonCodeFinder kyuShichosonCodeFinder) {
        this.gappeiCityJohoBFinder = gappeiCityJohoBFinder;
        this.shichosonSecurityJoho = shichosonSecurityJoho;
        this.koikiShichosonJoho = koikiShichosonJoho;
        this.kyuShichosonCodeFinder = kyuShichosonCodeFinder;
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 市町村コード、名称リストを取得します。
     *
     * @return 市町村Entiyリスト
     */
    public SearchResult<ShichosonCodeNameResult> getShichosonCodeNameList() {
        RString 導入形態コード;
        KoseiShichosonJohoEntity 市町村情報;
        ShichosonSecurityJoho shichosonJoho = shichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (shichosonJoho != null) {
            導入形態コード = shichosonJoho.get導入形態コード();
            市町村情報 = shichosonJoho.get市町村情報();
        } else {
            throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace("市町村セキュリティ情報"));
        }
        RString 合併情報区分 = gappeiCityJohoBFinder.getGappeijohokubun();
        if (合併情報区分 == null || 合併情報区分.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace("合併情報区分"));
        }
        if (DonyukeitaiCode.事務広域.getCode().equals(導入形態コード) || DonyukeitaiCode.認定広域.getCode().equals(導入形態コード)) {
            return get市町村情報リストBy導入形態コードは事務広域と認定広域の場合(合併情報区分, 市町村情報);
        } else {
            return get市町村情報リストBy導入形態コード以外の場合(合併情報区分, 市町村情報, 導入形態コード);
        }
    }

    private SearchResult<ShichosonCodeNameResult> get市町村情報リストBy導入形態コードは事務広域と認定広域の場合(RString 合併情報区分, KoseiShichosonJohoEntity 市町村情報) {
        if (合併情報区分_合併なし.equals(合併情報区分)) {
            return get市町村情報リストBy合併情報区分は合併なしの場合(市町村情報);
        } else if (合併情報区分_合併あり.equals(合併情報区分)) {
            return get市町村情報リストBy合併情報区分は合併ありの場合(市町村情報);
        }
        return null;
    }

    private SearchResult<ShichosonCodeNameResult> get市町村情報リストBy導入形態コード以外の場合(RString 合併情報区分, KoseiShichosonJohoEntity 市町村情報, RString 導入形態コード) {
        List<ShichosonCodeNameResult> 出力市町村情報リスト = new ArrayList<>();
        if (合併情報区分_合併なし.equals(合併情報区分)) {
            LasdecCode 市町村コード;
            RString 市町村名称;
            ShoKisaiHokenshaNo 保険者コード;
            RString 保険者区分;
            市町村コード = 市町村情報.getShichosonCode();
            市町村名称 = 市町村情報.getShichosonMeisho();
            保険者コード = 市町村情報.getShoKisaiHokenshaNo();
            保険者区分 = TokeiTaishoKubun.保険者分.getコード();
            出力市町村情報リスト.add(new ShichosonCodeNameResult(市町村コード, 市町村名称, 保険者コード, 保険者区分));
        } else if (合併情報区分_合併あり.equals(合併情報区分)) {
            return get市町村情報リストBy導入形態コード以外と合併あり(市町村情報, 導入形態コード);
        }
        return SearchResult.of(出力市町村情報リスト, 0, false);
    }

    private SearchResult<ShichosonCodeNameResult> get市町村情報リストBy合併情報区分は合併ありの場合(KoseiShichosonJohoEntity 市町村情報) {
        if (市町村識別ID_00.equals(市町村情報.getShichosonShokibetsuID())) {
            return get市町村情報リストBy合併ありと市町村識別IDは00の場合(市町村情報);
        } else {
            //TODO エラーマッセージが存在しない。 2016/01/04
//            throw new ApplicationException(DbaErrorMessages);
            return null;
        }
    }

    private SearchResult<ShichosonCodeNameResult> get市町村情報リストBy合併情報区分は合併なしの場合(KoseiShichosonJohoEntity 市町村情報) {
        if (市町村識別ID_00.equals(市町村情報.getShichosonShokibetsuID())) {
            return get市町村情報リストBy合併なしと市町村識別IDは00の場合(市町村情報);
        } else {
            //TODO エラーマッセージが存在しない。 2016/01/04
//            throw new ApplicationException(DbaErrorMessages.補正処理は行えません.getMessage());
            return null;
        }
    }

    @SuppressWarnings("null")
    @edu.umd.cs.findbugs.annotations.SuppressWarnings("NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE")
    private SearchResult<ShichosonCodeNameResult> get市町村情報リストBy導入形態コード以外と合併あり(KoseiShichosonJohoEntity 市町村情報, RString 導入形態コード) {
        List<ShichosonCodeNameResult> 出力市町村情報リスト = new ArrayList<>();
        LasdecCode 市町村コード;
        RString 市町村名称;
        ShoKisaiHokenshaNo 保険者コード;
        RString 保険者区分;
        市町村コード = 市町村情報.getShichosonCode();
        市町村名称 = 市町村情報.getShichosonMeisho();
        保険者コード = 市町村情報.getShoKisaiHokenshaNo();
        保険者区分 = TokeiTaishoKubun.保険者分.getコード();
        出力市町村情報リスト.add(new ShichosonCodeNameResult(市町村コード, 市町村名称, 保険者コード, 保険者区分));
        KyuShichosonCodeJohoRelateEntity relateEntity = new KyuShichosonCodeJohoRelateEntity();
        if (DonyukeitaiCode.事務単一.getCode().equals(導入形態コード)) {
            relateEntity = kyuShichosonCodeFinder.getKyuShichosonCodeJoho(市町村コード, DonyukeitaiCode.事務単一);
        } else if (DonyukeitaiCode.事務広域.getCode().equals(導入形態コード)) {
            relateEntity = kyuShichosonCodeFinder.getKyuShichosonCodeJoho(市町村コード, DonyukeitaiCode.事務広域);
        } else if (DonyukeitaiCode.事務構成市町村.getCode().equals(導入形態コード)) {
            relateEntity = kyuShichosonCodeFinder.getKyuShichosonCodeJoho(市町村コード, DonyukeitaiCode.事務構成市町村);
        } else if (DonyukeitaiCode.認定単一.getCode().equals(導入形態コード)) {
            relateEntity = kyuShichosonCodeFinder.getKyuShichosonCodeJoho(市町村コード, DonyukeitaiCode.認定単一);
        } else if (DonyukeitaiCode.認定広域.getCode().equals(導入形態コード)) {
            relateEntity = kyuShichosonCodeFinder.getKyuShichosonCodeJoho(市町村コード, DonyukeitaiCode.認定広域);
        }
        List<DbT7056GappeiShichosonEntity> gappeiShichosonEntityList = null;
        if (relateEntity != null) {
            gappeiShichosonEntityList = relateEntity.getEntitys();
        }
        if (gappeiShichosonEntityList == null || gappeiShichosonEntityList.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace("旧市町村コード情報"));
        }
        for (DbT7056GappeiShichosonEntity gappeiShichosonEntity : gappeiShichosonEntityList) {
            市町村コード = gappeiShichosonEntity.getKyuShichosonCode();
            市町村名称 = gappeiShichosonEntity.getKyuShichosonMeisho();
            if (gappeiShichosonEntity.getKyuHokenshaNo() == null) {
                保険者コード = ShoKisaiHokenshaNo.EMPTY;
            } else {
                保険者コード = new ShoKisaiHokenshaNo(gappeiShichosonEntity.getKyuHokenshaNo().value());
            }
            保険者区分 = TokeiTaishoKubun.旧市町村分.getコード();
            出力市町村情報リスト.add(new ShichosonCodeNameResult(市町村コード, 市町村名称, 保険者コード, 保険者区分));
        }
        return SearchResult.of(出力市町村情報リスト, 0, false);
    }

    private SearchResult<ShichosonCodeNameResult> get市町村情報リストBy合併ありと市町村識別IDは00の場合(KoseiShichosonJohoEntity 市町村情報) {
        List<ShichosonCodeNameResult> 出力市町村情報リスト = new ArrayList<>();
        LasdecCode 市町村コード;
        RString 市町村名称;
        ShoKisaiHokenshaNo 保険者コード;
        RString 保険者区分;
        市町村コード = 市町村情報.getShichosonCode();
        市町村名称 = 市町村情報.getShichosonMeisho();
        保険者コード = 市町村情報.getShoKisaiHokenshaNo();
        保険者区分 = TokeiTaishoKubun.保険者分.getコード();
        出力市町村情報リスト.add(new ShichosonCodeNameResult(市町村コード, 市町村名称, 保険者コード, 保険者区分));
        List<KoikiZenShichosonJoho> zenShichosonJohoList = koikiShichosonJoho.getZenShichosonJoho().records();
        if (zenShichosonJohoList == null || zenShichosonJohoList.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace("全市町村情報"));
        }
        for (KoikiZenShichosonJoho genShichosonJoho : zenShichosonJohoList) {
            市町村コード = genShichosonJoho.get市町村コード();
            市町村名称 = genShichosonJoho.get市町村名称();
            保険者コード = genShichosonJoho.get証記載保険者番号();
            RString 合併旧市町村区分 = genShichosonJoho.get合併旧市町村区分();
            if (合併旧市町村区分_最新の広域構成市町村である.equals(合併旧市町村区分)) {
                保険者区分 = TokeiTaishoKubun.構成市町村分.getコード();
            } else if (合併旧市町村区分_合併前の旧市町村である.equals(合併旧市町村区分)) {
                保険者区分 = TokeiTaishoKubun.旧市町村分.getコード();
            }
            出力市町村情報リスト.add(new ShichosonCodeNameResult(市町村コード, 市町村名称, 保険者コード, 保険者区分));
        }
        return SearchResult.of(出力市町村情報リスト, 0, false);
    }

    private SearchResult<ShichosonCodeNameResult> get市町村情報リストBy合併なしと市町村識別IDは00の場合(KoseiShichosonJohoEntity 市町村情報) {
        List<ShichosonCodeNameResult> 出力市町村情報リスト = new ArrayList<>();
        LasdecCode 市町村コード;
        RString 市町村名称;
        ShoKisaiHokenshaNo 保険者コード;
        RString 保険者区分;
        市町村コード = 市町村情報.getShichosonCode();
        市町村名称 = 市町村情報.getShichosonMeisho();
        保険者コード = 市町村情報.getShoKisaiHokenshaNo();
        保険者区分 = TokeiTaishoKubun.保険者分.getコード();
        出力市町村情報リスト.add(new ShichosonCodeNameResult(市町村コード, 市町村名称, 保険者コード, 保険者区分));
        List<KoikiZenShichosonJoho> genShichosonJohoList = koikiShichosonJoho.getGenShichosonJoho().records();
        if (genShichosonJohoList == null || genShichosonJohoList.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace("現市町村情報"));
        }
        for (KoikiZenShichosonJoho genShichosonJoho : genShichosonJohoList) {
            市町村コード = genShichosonJoho.get市町村コード();
            市町村名称 = genShichosonJoho.get市町村名称();
            保険者コード = genShichosonJoho.get証記載保険者番号();
            保険者区分 = TokeiTaishoKubun.構成市町村分.getコード();
            出力市町村情報リスト.add(new ShichosonCodeNameResult(市町村コード, 市町村名称, 保険者コード, 保険者区分));
        }
        return SearchResult.of(出力市町村情報リスト, 0, false);
    }

    /**
     * 画面入力した条件より　事業報告年報集計データ一覧を取得します。
     *
     * @param 年度 年度
     * @param 市町村コード 市町村コード
     * @param 保険者区分 保険者区分
     * @return 事業報告集計一覧データリスト
     */
    @Transaction
    public SearchResult<JigyoHokokuNenpoResult> getJigyoHokokuNenpoList(FlexibleYear 年度, LasdecCode 市町村コード, RString 保険者区分) {
        List<JigyoHokokuNenpoResult> 事業報告集計一覧データリスト = new ArrayList<>();
        IJigyoHokokuNenpoMapper jigyoHokokuNenpoMapper = mapperProvider.create(IJigyoHokokuNenpoMapper.class);
        List<DbT7021JigyoHokokuTokeiDataEntity> 事業報告集計一覧データEntityリスト
                = jigyoHokokuNenpoMapper.getJigyoHokokuNenpoList(JigyoHokokuNenpoParameter.createParameterForJigyoHokokuNenpo(年度, 市町村コード, 保険者区分));
        for (DbT7021JigyoHokokuTokeiDataEntity entity : 事業報告集計一覧データEntityリスト) {
            事業報告集計一覧データリスト.add(new JigyoHokokuNenpoResult(entity));
        }
        if (事業報告集計一覧データリスト.isEmpty()) {
            return SearchResult.of(Collections.<JigyoHokokuNenpoResult>emptyList(), 0, false);
        }
        return SearchResult.of(事業報告集計一覧データリスト, 0, false);
    }

    /**
     * 集計番号より　詳細データを取得します。
     *
     * @param jigyoHokokuNenpoSearch 事業報告集計一覧データ
     * @return 事業報告集計一覧データリスト
     */
    @Transaction
    public SearchResult<JigyoHokokuNenpoResult> getJigyoHokokuNenpoDetal(SearchJigyoHokokuNenpo jigyoHokokuNenpoSearch) {
        List<JigyoHokokuNenpoResult> 事業報告集計一覧データリスト = new ArrayList<>();
        IJigyoHokokuNenpoMapper jigyoHokokuNenpoMapper = mapperProvider.create(IJigyoHokokuNenpoMapper.class);
        List<DbT7021JigyoHokokuTokeiDataEntity> 事業報告集計一覧データEntityリスト
                = jigyoHokokuNenpoMapper.getJigyoHokokuNenpoDetal(getJigyoHokokuNenpoParameter(jigyoHokokuNenpoSearch));
        for (DbT7021JigyoHokokuTokeiDataEntity entity : 事業報告集計一覧データEntityリスト) {
            事業報告集計一覧データリスト.add(new JigyoHokokuNenpoResult(entity));
        }
        if (事業報告集計一覧データリスト.isEmpty()) {
            return SearchResult.of(Collections.<JigyoHokokuNenpoResult>emptyList(), 0, false);
        }
        return SearchResult.of(事業報告集計一覧データリスト, 0, false);
    }

    private JigyoHokokuNenpoDetalParameter getJigyoHokokuNenpoParameter(SearchJigyoHokokuNenpo jigyoHokokuNenpoSearch) {
        RString 様式種類コード = jigyoHokokuNenpoSearch.get様式種類コード();
        RString 統計対象区分 = ShukeiInfo.getToukeiTaishoKubun(様式種類コード);
        Code 表番号 = ShukeiInfo.getHyoNo(様式種類コード);
        List<Code> 集計番号リスト = ShukeiInfo.getShukeiNo(様式種類コード);
        return JigyoHokokuNenpoDetalParameter.createParameterForJigyoHokokuNenpoDetal(
                jigyoHokokuNenpoSearch.get報告年(),
                jigyoHokokuNenpoSearch.get集計対象年(),
                統計対象区分,
                jigyoHokokuNenpoSearch.get市町村コード(),
                表番号, jigyoHokokuNenpoSearch.get集計番号(), 集計番号リスト);
    }

    /**
     * 集計番号より　詳細データを更新します。
     *
     * @param 事業報告集計一覧データリスト 事業報告集計一覧データリスト
     * @return 更新件数
     */
    @Transaction
    public int updateJigyoHokokuNenpoData(List<JigyoHokokuNenpoResult> 事業報告集計一覧データリスト) {
        int updateCount = 0;
        IJigyoHokokuNenpoMapper jigyoHokokuNenpoMapper = mapperProvider.create(IJigyoHokokuNenpoMapper.class);
        for (JigyoHokokuNenpoResult jigyoHokokuNenpo : 事業報告集計一覧データリスト) {
            JigyoHokokuNenpoUpdateParameter parameter = JigyoHokokuNenpoUpdateParameter.createParameterForJigyoHokokuNenpo(
                    jigyoHokokuNenpo.get報告年(), jigyoHokokuNenpo.get報告月(),
                    jigyoHokokuNenpo.get集計対象年(), jigyoHokokuNenpo.get集計対象月(),
                    jigyoHokokuNenpo.get統計対象区分(), jigyoHokokuNenpo.get市町村コード(),
                    jigyoHokokuNenpo.get表番号(), jigyoHokokuNenpo.get集計番号(),
                    jigyoHokokuNenpo.get集計単位(), jigyoHokokuNenpo.get縦番号(),
                    jigyoHokokuNenpo.get横番号(), jigyoHokokuNenpo.get集計結果値());
            updateCount = jigyoHokokuNenpoMapper.updateJigyoHokokuNenpoData(parameter);
        }
        return updateCount;
    }

    /**
     * 集計番号より　詳細データを削除します。
     *
     * @param jigyoHokokuNenpoDelete 事業報告年報詳細データ
     * @return 削除件数
     */
    @Transaction
    public int deleteJigyoHokokuNenpoData(DeleteJigyoHokokuNenpo jigyoHokokuNenpoDelete) {
        RString 様式種類コード = jigyoHokokuNenpoDelete.get様式種類コード();
        RString 統計対象区分 = ShukeiInfo.getToukeiTaishoKubun(様式種類コード);
        Code 表番号 = ShukeiInfo.getHyoNo(様式種類コード);
        List<Code> 集計番号リスト = ShukeiInfo.getShukeiNo(jigyoHokokuNenpoDelete.get様式種類コード());
        IJigyoHokokuNenpoMapper jigyoHokokuNenpoMapper = mapperProvider.create(IJigyoHokokuNenpoMapper.class);
        JigyoHokokuNenpoDeleteParameter jigyoHokokuNenpoParameter
                = JigyoHokokuNenpoDeleteParameter.createParameterForJigyoHokokuNenpo(
                        jigyoHokokuNenpoDelete.get報告年(),
                        jigyoHokokuNenpoDelete.get集計対象年(),
                        統計対象区分,
                        jigyoHokokuNenpoDelete.get市町村コード(),
                        表番号, 集計番号リスト);
        return jigyoHokokuNenpoMapper.deleteJigyoHokokuNenpoData(jigyoHokokuNenpoParameter);
    }
}
