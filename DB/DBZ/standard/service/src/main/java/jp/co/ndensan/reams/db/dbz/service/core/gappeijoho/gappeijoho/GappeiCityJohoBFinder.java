/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.gappeijoho.gappeijoho;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7055GappeiJohoDac;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.db.dbz.business.core.gappeijoho.gappeijoho.GappeiCityJyoho;
import jp.co.ndensan.reams.db.dbz.business.core.gappeijoho.gappeijoho.KouikiGappeiJyoho;
import jp.co.ndensan.reams.db.dbz.definition.core.sortjun.GappeiJohoSortOrder;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.gappeijoho.GappeiJyohoSpecificParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.gappeijoho.GappeiCityJyohoRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.gappeijoho.KouikiGappeiJyohoRelateEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.gappeicityjoho.IGappeiCityJyohoMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 合併市町村情報取得のサービスです。
 *
 * @reamsid_L DBU-0090-010 linghuhang
 */
public class GappeiCityJohoBFinder {

    private static final RString 広域 = new RString("1");
    private static final RString 単一 = new RString("2");
    private static final RString 合併区分_なし = new RString("0");
    private static final RString 合併区分_あり = new RString("1");
    private static final RString メッセージ_表示有無区分 = new RString("表示有無区分");
    private static final RString メッセージ_合併情報ソート順 = new RString("合併情報ソート順");
    private static final RString RS_合併市町村情報検索キー = new RString("合併市町村情報検索キー");
    private static final RString 業務分類 = new RString("業務分類");
    private static final RString 導入形態コード = new RString("導入形態コード");
    private static final RString 表示有無区分_有 = new RString("1");
    private final MapperProvider mapperProvider;
    private final DbT7055GappeiJohoDac dac;

    /**
     * コンストラクタです。
     */
    GappeiCityJohoBFinder() {
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
     * @return GappeiCityJohoBFinder GappeiCityJohoBFinder
     */
    public static GappeiCityJohoBFinder createInstance() {
        return InstanceProvider.create(GappeiCityJohoBFinder.class);
    }

    /**
     * 合併情報区分を取得します。
     *
     * @return 合併区分 1:合併あり 0:合併なし
     */
    public RString getGappeijohokubun() {
        RDate 適用基準日 = RDate.getNowDate();
        return DbBusinessConfig.get(ConfigNameDBU.合併情報管理_合併情報区分, 適用基準日, SubGyomuCode.DBU介護統計報告);
    }

    /**
     * 旧市町村コード付加終了年月日を取得します。
     *
     * @return FlexibleDate 旧市町村情報付与終了年月日
     */
    public FlexibleDate getfukatoYMD() {

        FlexibleDate kyuJohoFuyoToYMD = FlexibleDate.EMPTY;
        if ((合併区分_あり).equals(getGappeijohokubun()) && dac.get旧市町村コード付加終了年月日() != null) {
            kyuJohoFuyoToYMD = dac.get旧市町村コード付加終了年月日().getKyuJohoFuyoToYMD();
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
        requireNonNull(hyoujiUmu, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ_表示有無区分.toString()));
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
        requireNonNull(hyoujiUmu, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ_表示有無区分.toString()));
        if ((旧市町村コード == null || 旧市町村コード.isEmpty()) && (旧保険者番号 == null || 旧保険者番号.isEmpty())) {
            throw new ApplicationException(UrErrorMessages.検索キーの誤り.getMessage());
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
        requireNonNull(hyoujiUmu, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ_表示有無区分.toString()));
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
        requireNonNull(hyoujiUmu, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ_表示有無区分.toString()));
        if ((旧市町村コード == null || 旧市町村コード.isEmpty()) && (旧保険者番号 == null || 旧保険者番号.isEmpty())) {
            throw new ApplicationException(UrErrorMessages.検索キーの誤り.getMessage());
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
        requireNonNull(hyoujiUmu, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ_表示有無区分.toString()));
        requireNonNull(導入形態コード, UrSystemErrorMessages.値がnull.getReplacedMessage("導入形態コード"));
        IGappeiCityJyohoMapper gappeiJyohoMapper = this.mapperProvider.create(IGappeiCityJyohoMapper.class);
        GappeiJyohoSpecificParameter params = GappeiJyohoSpecificParameter.createParamForTannitsugappeijoho(hyoujiUmu);
        List<GappeiCityJyoho> gappeiCityJyohoList = new ArrayList<>();
        List<GappeiCityJyohoRelateEntity> 合併情報検索結果Entityリスト = new ArrayList<>();
        if (((合併区分_あり).equals(getGappeijohokubun())) && (!導入形態コード.isEmpty() && 導入形態コード.length() >= 2)) {
            if (単一.equals(導入形態コード.substringEmptyOnError(1, 2))) {
                合併情報検索結果Entityリスト = gappeiJyohoMapper.getSennyoukouikigappeijohokensaku単一(params);
            } else if (広域.equals(導入形態コード.substringEmptyOnError(1, 2))) {
                合併情報検索結果Entityリスト = gappeiJyohoMapper.getSennyoukouikigappeijohokensaku広域(params);
            }
        }
        for (GappeiCityJyohoRelateEntity entity : 合併情報検索結果Entityリスト) {
            gappeiCityJyohoList.add(new GappeiCityJyoho(entity));
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
        requireNonNull(hyoujiUmu, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ_表示有無区分.toString()));
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
        requireNonNull(hyoujium, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ_表示有無区分.toString()));
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
        requireNonNull(shichosonCode, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(hokenshaNo, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者番号"));
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
        requireNonNull(chiikiNo, UrSystemErrorMessages.値がnull.getReplacedMessage("地域番号"));
        requireNonNull(gappeiShurui, UrSystemErrorMessages.値がnull.getReplacedMessage("合併種類"));
        requireNonNull(gappeiYMD, UrSystemErrorMessages.値がnull.getReplacedMessage("合併年月日"));
        requireNonNull(shichosonCode, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(hokenshaNo, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者番号"));
        requireNonNull(kyuJohoFuyoToYMD, UrSystemErrorMessages.値がnull.getReplacedMessage("旧市町村情報付与終了年月日"));
        requireNonNull(kokuhorenDataFromYMD, UrSystemErrorMessages.値がnull.getReplacedMessage("国保連データ連携開始年月日"));
        requireNonNull(kijyuYMD, UrSystemErrorMessages.値がnull.getReplacedMessage("基準日"));
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

    /**
     * start被保険者番号の変換対象を特定するための基準日を取得します。
     *
     * @param gyomubunrui GyomuBunrui
     * @return FlexibleDate
     */
    public FlexibleDate getHihokenshaBangoHenkanKijunbi(GyomuBunrui gyomubunrui) {
        requireNonNull(gyomubunrui, UrSystemErrorMessages.値がnull.getReplacedMessage(業務分類.toString()));
        ShichosonSecurityJoho shichosonsecurityjoho = ShichosonSecurityJohoFinder.createInstance().getShichosonSecurityJoho(gyomubunrui);
        if (shichosonsecurityjoho == null) {
            return null;
        }
        DonyuKeitaiCode donyukeitaicode = shichosonsecurityjoho.get導入形態コード();
        RDate nowDate = RDate.getNowDate();
        if (donyukeitaicode.is単一()) {
            if (合併区分_なし.equals(DbBusinessConfig.get(ConfigNameDBU.合併情報管理_合併情報区分, nowDate, SubGyomuCode.DBU介護統計報告))) {
                return FlexibleDate.EMPTY;
            } else if (合併区分_あり.equals(DbBusinessConfig.get(ConfigNameDBU.合併情報管理_合併情報区分, nowDate, SubGyomuCode.DBU介護統計報告))) {
                GappeiCityJohoBFinder finder = new GappeiCityJohoBFinder();
                SearchResult<GappeiCityJyoho> result = finder.getSaishintannitsugappeijoho(表示有無区分_有);
                return result == null || result.records() == null || result.records().isEmpty() ? null : result.records().get(0).get国保連データ連携開始年月日();
            }
        } else {
            return new FlexibleDate(DbBusinessConfig.get(ConfigNameDBU.保険者発足情報_広域保険者_合併保険者_発足日, nowDate, SubGyomuCode.DBU介護統計報告));
        }
        return FlexibleDate.EMPTY;
    }

    /**
     * 導入形態コード渡して、被保険者番号の変換対象を特定するための基準日を取得します。
     *
     * @param gyomubunrui GyomuBunrui
     * @param donyukeitaicode DonyukeitaiCode
     * @return FlexibleDate
     */
    public FlexibleDate getHihokenshaBangoHenkanKijunbi(GyomuBunrui gyomubunrui, DonyuKeitaiCode donyukeitaicode) {
        requireNonNull(gyomubunrui, UrSystemErrorMessages.値がnull.getReplacedMessage(業務分類.toString()));
        requireNonNull(donyukeitaicode, UrSystemErrorMessages.値がnull.getReplacedMessage(導入形態コード.toString()));
        RDate nowDate = RDate.getNowDate();
        if (donyukeitaicode.is単一()) {
            if (合併区分_なし.equals(DbBusinessConfig.get(ConfigNameDBU.合併情報管理_合併情報区分, nowDate, SubGyomuCode.DBU介護統計報告))) {
                return FlexibleDate.EMPTY;
            } else if (合併区分_あり.equals(DbBusinessConfig.get(ConfigNameDBU.合併情報管理_合併情報区分, nowDate, SubGyomuCode.DBU介護統計報告))) {
                GappeiCityJohoBFinder finder = new GappeiCityJohoBFinder();
                SearchResult<GappeiCityJyoho> result = finder.getSaishintannitsugappeijoho(表示有無区分_有);
                return result == null || result.records() == null || result.records().isEmpty() ? null : result.records().get(0).get国保連データ連携開始年月日();
            }
        } else {
            return new FlexibleDate(DbBusinessConfig.get(ConfigNameDBU.保険者発足情報_広域保険者_合併保険者_発足日, nowDate, SubGyomuCode.DBU介護統計報告));
        }
        return FlexibleDate.EMPTY;
    }

    /**
     * 合併市町村情報検索キーより合併市町村情報を検索して、全合併市町村情報を取得します。
     *
     * @param 表示有無区分 RString
     * @param 合併市町村情報検索キー GappeiJyohoSpecificParameter
     * @param gyomubunrui GyomuBunrui
     * @return SearchResult<GappeiCityJyoho>
     */
    public SearchResult<GappeiCityJyoho> getGappeijohokensaku(RString 表示有無区分, GappeiJyohoSpecificParameter 合併市町村情報検索キー, GyomuBunrui gyomubunrui) {
        requireNonNull(合併市町村情報検索キー, UrSystemErrorMessages.値がnull.getReplacedMessage(RS_合併市町村情報検索キー.toString()));
        requireNonNull(gyomubunrui, UrSystemErrorMessages.値がnull.getReplacedMessage(業務分類.toString()));
        ShichosonSecurityJoho shichosonsecurityjoho = ShichosonSecurityJohoFinder.createInstance().getShichosonSecurityJoho(gyomubunrui);
        if (shichosonsecurityjoho == null) {
            return null;
        }
        DonyuKeitaiCode donyukeitaicode = shichosonsecurityjoho.get導入形態コード();
        GappeiCityJohoBFinder finder = new GappeiCityJohoBFinder();
        if (donyukeitaicode.is単一()) {
            return finder.getTannitsugappeijohokensaku(表示有無区分, 合併市町村情報検索キー.getShichosonCode(), 合併市町村情報検索キー.getHokenshaNo());
        } else {
            return finder.getKouikigappeijohokensaku(表示有無区分, 合併市町村情報検索キー.getShichosonCode(), 合併市町村情報検索キー.getHokenshaNo());
        }
    }

    /**
     * 最新の合併市町村情報を取得します。
     *
     * @param 表示有無区分 RString
     * @param gyomubunrui GyomuBunrui
     * @return SearchResult<GappeiCityJyoho>
     */
    public SearchResult<GappeiCityJyoho> getSaishingappeijoho(RString 表示有無区分, GyomuBunrui gyomubunrui) {
        requireNonNull(gyomubunrui, UrSystemErrorMessages.値がnull.getReplacedMessage(業務分類.toString()));
        ShichosonSecurityJoho shichosonsecurityjoho = ShichosonSecurityJohoFinder.createInstance().getShichosonSecurityJoho(gyomubunrui);
        if (shichosonsecurityjoho == null) {
            return null;
        }
        DonyuKeitaiCode donyukeitaicode = shichosonsecurityjoho.get導入形態コード();
        GappeiCityJohoBFinder finder = new GappeiCityJohoBFinder();
        if (donyukeitaicode.is単一()) {
            return finder.getSaishintannitsugappeijoho(表示有無区分);
        } else {
            return finder.getKouikigappeijohokennsaku(表示有無区分);
        }
    }

    /**
     * ソート順を指定して全合併旧市町村情報を取得します（広域内合併に対応する）。
     *
     * @param 表示有無区分 RString
     * @param 合併情報ソート順 GappeiJohoSortOrder
     * @return SearchResult<GappeiCityJyoho> 合併市町村情報
     */
    @Transaction
    public SearchResult<GappeiCityJyoho> getKouikigappeijoho(RString 表示有無区分, GappeiJohoSortOrder 合併情報ソート順) {
        requireNonNull(表示有無区分, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ_表示有無区分.toString()));
        requireNonNull(合併情報ソート順, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ_合併情報ソート順.toString()));
        IGappeiCityJyohoMapper gappeiJyohoMapper = this.mapperProvider.create(IGappeiCityJyohoMapper.class);
        GappeiJyohoSpecificParameter params = GappeiJyohoSpecificParameter
                .createParamForKouikigappeijohoWithSort(表示有無区分, 合併情報ソート順);
        List<GappeiCityJyohoRelateEntity> 合併情報検索結果Entityリスト = gappeiJyohoMapper.getKouikigappeijohoWithSort(params);
        List<GappeiCityJyoho> gappeiCityJyohoList = new ArrayList<>();
        for (GappeiCityJyohoRelateEntity entity : 合併情報検索結果Entityリスト) {
            gappeiCityJyohoList.add(new GappeiCityJyoho(entity));
        }
        return SearchResult.of(gappeiCityJyohoList, 0, false);
    }
}
