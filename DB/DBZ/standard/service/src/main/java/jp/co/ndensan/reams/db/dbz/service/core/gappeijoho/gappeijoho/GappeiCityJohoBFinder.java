/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.gappeijoho.gappeijoho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.gappeijoho.gappeijoho.GappeiCityJyoho;
import jp.co.ndensan.reams.db.dbz.business.core.gappeijoho.gappeijoho.KouikiGappeiJyoho;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbz.definition.mybatis.param.gappeijoho.GappeiJyohoSpecificParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.gappeijoho.GappeiCityJyohoRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.gappeijoho.KouikiGappeiJyohoRelateEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7055GappeiJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.gappeijoho.IGappeiCityJyohoMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 合併市町村情報取得のサービスです。
 */
public class GappeiCityJohoBFinder {

    private final MapperProvider mapperProvider;
    private final DbT7055GappeiJohoDac dac;
    private static final RString 広域 = new RString("1");
    private static final RString 単一 = new RString("2");
    private static final RString 合併区分_あり = new RString("1");
    private static final RString 表示有無区分_有 = new RString("1");

    /**
     * コンストラクタです。
     */
    public GappeiCityJohoBFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dac = InstanceProvider.create(DbT7055GappeiJohoDac.class);
    }

    /**
     * 単体テスト用コンストラクタです。
     *
     * @param dac 合併情報のデータアクセス
     * @param mapper Mapper
     */
    GappeiCityJohoBFinder(
            DbT7055GappeiJohoDac dac,
            MapperProvider mapper) {
        this.dac = dac;
        this.mapperProvider = mapper;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link GappeiCityJohoBFinder}のインスタンスを返します。
     *
     * @return　GappeiCityJohoBFinder
     */
    static GappeiCityJohoBFinder createInstance() {
        return InstanceProvider.create(GappeiCityJohoBFinder.class);
    }

    /**
     * 合併情報区分を取得します。
     *
     * @return 合併区分 1:合併あり 0:合併なし
     */
    public RString getGappeijohokubun() {
        return BusinessConfig.get(ConfigNameDBU.合併情報管理_合併情報区分, SubGyomuCode.DBU介護統計報告);
    }

    /**
     * 旧市町村コード付加終了年月日を取得します。
     *
     * @return FlexibleDate 旧市町村情報付与終了年月日
     */
    public FlexibleDate getfukatoYMD() {

        FlexibleDate kyuJohoFuyoToYMD = FlexibleDate.EMPTY;
        if ((合併区分_あり).equals(getGappeijohokubun())) {
            FlexibleDate result = dac.get旧市町村コード付加終了年月日().getKyuJohoFuyoToYMD();
            if (!result.isEmpty()) {
                return result;
            } else {
                return kyuJohoFuyoToYMD;
            }
        }
        return kyuJohoFuyoToYMD;
    }

    /**
     * 単一全合併市町村情報を取得します。
     *
     * @param hyoujiUmu 表示有無区分
     * @return SearchResult<GappeiCityJyoho> 合併市町村情報
     */
    @Transaction
    public SearchResult<GappeiCityJyoho> getTannitsugappeijoho(RString hyoujiUmu) {
        IGappeiCityJyohoMapper gappeiJyohoMapper = this.mapperProvider.create(IGappeiCityJyohoMapper.class);
        GappeiJyohoSpecificParameter params = GappeiJyohoSpecificParameter.createParamForTannitsugappeijoho(hyoujiUmu);
        List<GappeiCityJyohoRelateEntity> 合併情報検索結果Entityリスト = gappeiJyohoMapper.getTannitsugappeijoho(params);
        List<GappeiCityJyoho> gappeiCityJyohoList = new ArrayList<>();
        for (GappeiCityJyohoRelateEntity entity : 合併情報検索結果Entityリスト) {
            gappeiCityJyohoList.add(new GappeiCityJyoho(entity));
        }
        return SearchResult.of(gappeiCityJyohoList, 0, false);
    }

    /**
     * 単一全合併市町村情報検索を取得します。
     *
     * @param hyoujiUmu 表示有無区分
     * @param 旧市町村コード 旧市町村コード
     * @param 旧保険者番号 旧保険者番号
     * @return SearchResult<GappeiJyoho> 合併市町村情報
     */
    @Transaction
    public SearchResult<GappeiCityJyoho> getTannitsugappeijohokensaku(RString hyoujiUmu,
            LasdecCode 旧市町村コード, HokenshaNo 旧保険者番号) {
        if (旧市町村コード.isEmpty() && 旧保険者番号.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.検索キーの誤り.getMessage().toString());
        }
        IGappeiCityJyohoMapper gappeiJyohoMapper = this.mapperProvider.create(IGappeiCityJyohoMapper.class);
        GappeiJyohoSpecificParameter params = GappeiJyohoSpecificParameter.createParamForTannitsugappeijohokensaku(hyoujiUmu,
                旧市町村コード, 旧保険者番号);
        List<GappeiCityJyohoRelateEntity> 合併情報検索結果Entityリスト = gappeiJyohoMapper.getTannitsugappeijohokensaku(params);
        List<GappeiCityJyoho> gappeiCityJyohoList = new ArrayList<>();
        for (GappeiCityJyohoRelateEntity entity : 合併情報検索結果Entityリスト) {
            gappeiCityJyohoList.add(new GappeiCityJyoho(entity));
        }
        return SearchResult.of(gappeiCityJyohoList, 0, false);
    }

    /**
     * 広域全合併市町村情報を取得します。
     *
     * @param hyoujiUmu 表示有無区分
     * @return SearchResult<GappeiCityJyoho> 合併市町村情報
     */
    @Transaction
    public SearchResult<GappeiCityJyoho> getKouikigappeijoho(RString hyoujiUmu) {
        IGappeiCityJyohoMapper gappeiJyohoMapper = this.mapperProvider.create(IGappeiCityJyohoMapper.class);
        GappeiJyohoSpecificParameter params = GappeiJyohoSpecificParameter.createParamForKouikigappeijoho(hyoujiUmu);
        List<GappeiCityJyohoRelateEntity> 合併情報検索結果Entityリスト = gappeiJyohoMapper.getKouikigappeijoho(params);
        List<GappeiCityJyoho> gappeiCityJyohoList = new ArrayList<>();
        for (GappeiCityJyohoRelateEntity entity : 合併情報検索結果Entityリスト) {
            gappeiCityJyohoList.add(new GappeiCityJyoho(entity));
        }
        return SearchResult.of(gappeiCityJyohoList, 0, false);
    }

    /**
     * 広域全合併市町村情報検索を取得します。
     *
     * @param hyoujiUmu 表示有無区分
     * @param 旧市町村コード 旧市町村コード
     * @param 旧保険者番号 旧保険者番号
     * @return SearchResult<GappeiCityJyoho> 合併市町村情報
     */
    @Transaction
    public SearchResult<GappeiCityJyoho> getKouikigappeijohokensaku(RString hyoujiUmu,
            LasdecCode 旧市町村コード, HokenshaNo 旧保険者番号) {
        if (旧市町村コード.isEmpty() && 旧保険者番号.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.検索キーの誤り.getMessage().toString());
        }
        IGappeiCityJyohoMapper gappeiJyohoMapper = this.mapperProvider.create(IGappeiCityJyohoMapper.class);
        GappeiJyohoSpecificParameter params = GappeiJyohoSpecificParameter.createParamForKouikigappeijohokensaku(hyoujiUmu,
                旧市町村コード, 旧保険者番号);
        List<GappeiCityJyohoRelateEntity> 合併情報検索結果Entityリスト = gappeiJyohoMapper.getKouikigappeijohokensaku(params);
        List<GappeiCityJyoho> gappeiCityJyohoList = new ArrayList<>();
        for (GappeiCityJyohoRelateEntity entity : 合併情報検索結果Entityリスト) {
            gappeiCityJyohoList.add(new GappeiCityJyoho(entity));
        }
        return SearchResult.of(gappeiCityJyohoList, 0, false);
    }

    /**
     * 合併市町村情報検索を取得します。
     *
     * @param hyoujiUmu 表示有無区分
     * @param 導入形態コード 導入形態コード
     * @return SearchResult<GappeiCityJyoho> 合併市町村情報
     */
    @Transaction
    public SearchResult<GappeiCityJyoho> getSennyoukouikigappeijohokensaku(RString hyoujiUmu, RString 導入形態コード) {
        List<GappeiCityJyoho> gappeiCityJyohoList = new ArrayList<>();
        if (((合併区分_あり).equals(getGappeijohokubun())) && (!導入形態コード.isEmpty() && 導入形態コード.length() >= 2)) {
            if (単一.equals(導入形態コード.substringEmptyOnError(1, 2))) {
                gappeiCityJyohoList = getTannitsugappeijoho(表示有無区分_有).records();
            } else if (広域.equals(導入形態コード.substringEmptyOnError(1, 2))) {
                gappeiCityJyohoList = getKouikigappeijoho(表示有無区分_有).records();
            }
        }
        return SearchResult.of(gappeiCityJyohoList, 0, false);
    }

    /**
     * 最新単一合併市町村情報を取得します。
     *
     * @param hyoujiUmu 表示有無区分
     * @return SearchResult<GappeiCityJyoho> 合併市町村情報
     */
    @Transaction
    public SearchResult<GappeiCityJyoho> getSaishintannitsugappeijoho(RString hyoujiUmu) {
        IGappeiCityJyohoMapper gappeiJyohoMapper = this.mapperProvider.create(IGappeiCityJyohoMapper.class);
        GappeiJyohoSpecificParameter params = GappeiJyohoSpecificParameter.createParamForSaishintannitsugappeijoho(hyoujiUmu);
        List<GappeiCityJyohoRelateEntity> 合併情報検索結果Entityリスト = gappeiJyohoMapper.getSaishintannitsugappeijoho(params);
        List<GappeiCityJyoho> gappeiCityJyohoList = new ArrayList<>();
        for (GappeiCityJyohoRelateEntity entity : 合併情報検索結果Entityリスト) {
            gappeiCityJyohoList.add(new GappeiCityJyoho(entity));
        }
        return SearchResult.of(gappeiCityJyohoList, 0, false);
    }

    /**
     * 最新広域合併市町村情報を取得します。
     *
     * @param hyoujium 表示有無区分
     * @return SearchResult<GappeiCityJyoho> 合併市町村情報
     */
    @Transaction
    public SearchResult<GappeiCityJyoho> getKouikigappeijohokennsaku(RString hyoujium) {
        IGappeiCityJyohoMapper gappeiJyohoMapper = this.mapperProvider.create(IGappeiCityJyohoMapper.class);
        GappeiJyohoSpecificParameter params = GappeiJyohoSpecificParameter.createParamForKouikigappeijohokennsaku(hyoujium);
        List<GappeiCityJyohoRelateEntity> 合併情報検索結果Entityリスト = gappeiJyohoMapper.getKouikigappeijohokennsaku(params);
        List<GappeiCityJyoho> gappeiCityJyohoList = new ArrayList<>();
        for (GappeiCityJyohoRelateEntity entity : 合併情報検索結果Entityリスト) {
            gappeiCityJyohoList.add(new GappeiCityJyoho(entity));
        }
        return SearchResult.of(gappeiCityJyohoList, 0, false);
    }

    /**
     * 検索キーによる単一合併市町村情報を取得します。
     *
     * @param shichosonCode 市町村コード
     * @param hokenshaNo 保険者番号
     * @return SearchResult<GappeiCityJyoho> 合併市町村情報
     */
    @Transaction
    public SearchResult<GappeiCityJyoho> getKensakukitannitsugappeijoho(LasdecCode shichosonCode, HokenshaNo hokenshaNo) {
        IGappeiCityJyohoMapper gappeiJyohoMapper = this.mapperProvider.create(IGappeiCityJyohoMapper.class);
        GappeiJyohoSpecificParameter params = GappeiJyohoSpecificParameter.createParamForKouikigappeijohokennsaku(shichosonCode, hokenshaNo);
        List<GappeiCityJyohoRelateEntity> 合併情報検索結果Entityリスト = gappeiJyohoMapper.getKensakukitannitsugappeijoho(params);
        List<GappeiCityJyoho> gappeiCityJyohoList = new ArrayList<>();
        for (GappeiCityJyohoRelateEntity entity : 合併情報検索結果Entityリスト) {
            gappeiCityJyohoList.add(new GappeiCityJyoho(entity));
        }
        return SearchResult.of(gappeiCityJyohoList, 0, false);
    }

    /**
     * 検索キーによる広域合併市町村情報を取得します。
     *
     * @param chiikiNo 地域番号
     * @param gappeiShurui 合併種類
     * @param gappeiYMD 合併日
     * @param shichosonCode 市町村コード
     * @param hokenshaNo 保険者番号
     * @param kyuJohoFuyoToYMD 旧CD付加終了年月日
     * @param kokuhorenDataFromYMD 国保連開始日
     * @param kijyuYMD 基準日
     * @return SearchResult<KouikiGappeiJyoho> 広域合併情報
     */
    @Transaction
    public SearchResult<KouikiGappeiJyoho> getKensakukikouikigappeijoho(RString chiikiNo, RString gappeiShurui,
            FlexibleDate gappeiYMD, LasdecCode shichosonCode,
            HokenshaNo hokenshaNo, FlexibleDate kyuJohoFuyoToYMD,
            FlexibleDate kokuhorenDataFromYMD, FlexibleDate kijyuYMD) {
        IGappeiCityJyohoMapper gappeiJyohoMapper = this.mapperProvider.create(IGappeiCityJyohoMapper.class);
        GappeiJyohoSpecificParameter params = GappeiJyohoSpecificParameter.
                createParamForKensakukikouikigappeijoho(chiikiNo, gappeiShurui, gappeiYMD, shichosonCode,
                        hokenshaNo, kyuJohoFuyoToYMD, kokuhorenDataFromYMD, kijyuYMD);
        List<KouikiGappeiJyohoRelateEntity> 合併情報検索結果Entityリスト = gappeiJyohoMapper.getKensakukikouikigappeijoho(params);
        List<KouikiGappeiJyoho> kouikiGappeiJyohoList = new ArrayList<>();
        for (KouikiGappeiJyohoRelateEntity entity : 合併情報検索結果Entityリスト) {
            kouikiGappeiJyohoList.add(new KouikiGappeiJyoho(entity));
        }
        return SearchResult.of(kouikiGappeiJyohoList, 0, false);
    }
}
