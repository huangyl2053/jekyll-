/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.gappeijoho;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.config.kyotsu.gappeijohokanri.GappeiJohoKanriConfig;
import jp.co.ndensan.reams.db.dbx.business.core.gappeijoho.GappeiJyoho;
import jp.co.ndensan.reams.db.dbx.business.core.gappeijoho.KouikiGappeiJyoho;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.mybatisprm.gappeijoho.GappeiJyohoSpecificParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.gappeijoho.GappeiJyohoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.gappeijoho.KouikiGappeiJyohoEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7055GappeiJohoDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.mapper.relate.gappeijoho.IGappeiJyohoMapper;
import jp.co.ndensan.reams.db.dbx.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 合併市町村情報取得のサービスです。
 */
public class GappeiCityJohoFinder {

    private final MapperProvider mapperProvider;
    private final DbT7055GappeiJohoDac gappeiJohoDac;
    private GappeiJohoKanriConfig gappeiJohoKanri;
    private static final RString 広域 = new RString("1");
    private static final RString 単一 = new RString("2");
    private static final RString 表示有無区分_有 = new RString("1");

    /**
     * コンストラクタです。
     */
    protected GappeiCityJohoFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.gappeiJohoDac = InstanceProvider.create(DbT7055GappeiJohoDac.class);
    }

    /**
     * 単体テスト用コンストラクタです。
     *
     * @param dac
     * @param mapper
     */
    GappeiCityJohoFinder(
            DbT7055GappeiJohoDac dac,
            MapperProvider mapper) {
        this.gappeiJohoDac = dac;
        this.mapperProvider = mapper;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link GappeiCityJohoFinder}のインスタンスを返します。
     *
     * @return GappeiCityJohoFinder
     */
    public static GappeiCityJohoFinder createInstance() {
        return InstanceProvider.create(GappeiCityJohoFinder.class);
    }

    private boolean has合併() {
        if (this.gappeiJohoKanri == null) {
            this.gappeiJohoKanri = new GappeiJohoKanriConfig();
        }
        return this.gappeiJohoKanri.has合併();
    }

    /**
     * 旧市町村コード付加終了年月日を取得します。
     *
     * @return 旧市町村情報付与終了年月日
     */
    public FlexibleDate getfukatoYMD() {
        if (!this.has合併()) {
            return FlexibleDate.EMPTY;
        }
        // 旧市町村情報付与終了年月日検索処理実施
        FlexibleDate result = gappeiJohoDac.get旧市町村コード付加終了年月日().getKyuJohoFuyoToYMD();
        return result == null ? FlexibleDate.EMPTY : result;
    }

    /**
     * 単一全合併市町村情報を取得します。
     *
     * @param hyoujiUmu 表示有無区分
     * @return List<GappeiJyoho> 合併市町村情報Entityリスト
     */
    @Transaction
    public List<GappeiJyoho> getTannitsugappeijoho(RString hyoujiUmu) {
        IGappeiJyohoMapper gappeiJyohoMapper = this.mapperProvider.create(IGappeiJyohoMapper.class);
        // 検索パラメーター作成。
        GappeiJyohoSpecificParameter params = GappeiJyohoSpecificParameter.createParamForTannitsugappeijoho(hyoujiUmu);
        // 検索処理実施
        List<GappeiJyohoEntity> 合併情報検索結果Entityリスト = gappeiJyohoMapper.getTannitsugappeijoho(params);
        // BusinessClass生成
        List<GappeiJyoho> businessList = new ArrayList<>();
        for (GappeiJyohoEntity entity : 合併情報検索結果Entityリスト) {
            businessList.add(new GappeiJyoho(entity));
        }
        return businessList;
    }

    /**
     * 単一全合併市町村情報検索を取得します。
     *
     * @param hyoujiUmu 表示有無区分
     * @param 旧市町村コード 旧市町村コード
     * @param 旧保険者番号 旧保険者番号
     * @return List<GappeiJyoho> 合併市町村情報Entityリスト
     */
    public List<GappeiJyoho> getTannitsugappeijohokensaku(RString hyoujiUmu,
                                                          LasdecCode 旧市町村コード, HokenshaNo 旧保険者番号) {
        if (旧市町村コード.isEmpty() && 旧保険者番号.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.検索キーの誤り.getMessage().toString());
        }
        IGappeiJyohoMapper gappeiJyohoMapper = this.mapperProvider.create(IGappeiJyohoMapper.class);
        // 検索パラメーター作成
        GappeiJyohoSpecificParameter params = GappeiJyohoSpecificParameter.createParamForTannitsugappeijohokensaku(hyoujiUmu,
                                                                                                                   旧市町村コード, 旧保険者番号);
        // 検索処理実施
        List<GappeiJyohoEntity> 合併情報検索結果Entityリスト = gappeiJyohoMapper.getTannitsugappeijohokensaku(params);
        // BusinessClass生成
        List<GappeiJyoho> businessList = new ArrayList<>();
        for (GappeiJyohoEntity entity : 合併情報検索結果Entityリスト) {
            businessList.add(new GappeiJyoho(entity));
        }
        return businessList;
    }

    /**
     * 広域全合併市町村情報を取得します。
     *
     * @param hyoujiUmu 表示有無区分
     * @return List<GappeiJyoho> 合併市町村情報Entityリスト
     */
    public List<GappeiJyoho> getKouikigappeijoho(RString hyoujiUmu) {
        IGappeiJyohoMapper gappeiJyohoMapper = this.mapperProvider.create(IGappeiJyohoMapper.class);
        // 検索パラメーター作成
        GappeiJyohoSpecificParameter params = GappeiJyohoSpecificParameter.createParamForKouikigappeijoho(hyoujiUmu);
        // 検索処理実施
        List<GappeiJyohoEntity> 合併情報検索結果Entityリスト = gappeiJyohoMapper.getKouikigappeijoho(params);
        // BusinessClass生成
        List<GappeiJyoho> businessList = new ArrayList<>();
        for (GappeiJyohoEntity entity : 合併情報検索結果Entityリスト) {
            businessList.add(new GappeiJyoho(entity));
        }
        return businessList;
    }

    /**
     * 広域全合併市町村情報検索を取得します。
     *
     * @param hyoujiUmu 表示有無区分
     * @param 旧市町村コード 旧市町村コード
     * @param 旧保険者番号 旧保険者番号
     * @return List<GappeiJyoho> 合併市町村情報Entityリスト
     */
    public List<GappeiJyoho> getKouikigappeijohokensaku(RString hyoujiUmu,
                                                        LasdecCode 旧市町村コード, HokenshaNo 旧保険者番号) {
        if (旧市町村コード.isEmpty() && 旧保険者番号.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.検索キーの誤り.getMessage().toString());
        }
        IGappeiJyohoMapper gappeiJyohoMapper = this.mapperProvider.create(IGappeiJyohoMapper.class);
        // 検索パラメーター作成
        GappeiJyohoSpecificParameter params = GappeiJyohoSpecificParameter.createParamForKouikigappeijohokensaku(hyoujiUmu,
                                                                                                                 旧市町村コード, 旧保険者番号);
        // 検索処理実施
        List<GappeiJyohoEntity> 合併情報検索結果Entityリスト = gappeiJyohoMapper.getKouikigappeijohokensaku(params);
        // BusinessClass生成
        List<GappeiJyoho> businessList = new ArrayList<>();
        for (GappeiJyohoEntity entity : 合併情報検索結果Entityリスト) {
            businessList.add(new GappeiJyoho(entity));
        }
        return businessList;
    }

    /**
     * 合併市町村情報検索を取得します。
     *
     * @param hyoujiUmu 表示有無区分
     * @param 導入形態コード 導入形態コード
     * @return List<GappeiJyoho> 合併市町村情報Entityリスト
     */
    public List<GappeiJyoho> getSennyoukouikigappeijohokensaku(RString hyoujiUmu, RString 導入形態コード) {
        if (!this.has合併()) {
            return Collections.emptyList();
        }

        // 合併区分が'1'の場合
        if (!導入形態コード.isEmpty() && 導入形態コード.length() >= 2) {
            if (単一.equals(導入形態コード.substringEmptyOnError(1, 2))) {
                return getTannitsugappeijoho(表示有無区分_有);
            } else if (広域.equals(導入形態コード.substringEmptyOnError(1, 2))) {
                return getKouikigappeijoho(表示有無区分_有);
            }
        }
        return Collections.emptyList();
    }

    /**
     * 最新単一合併市町村情報を取得します。
     *
     * @param hyoujiUmu 表示有無区分
     * @return List<GappeiJyoho> 合併市町村情報Entityリスト
     */
    public List<GappeiJyoho> getSaishintannitsugappeijoho(RString hyoujiUmu) {
        IGappeiJyohoMapper gappeiJyohoMapper = this.mapperProvider.create(IGappeiJyohoMapper.class
        );
        // 検索パラメーター作成
        GappeiJyohoSpecificParameter params = GappeiJyohoSpecificParameter.createParamForSaishintannitsugappeijoho(hyoujiUmu);
        // 検索処理実施
        List<GappeiJyohoEntity> 合併情報検索結果Entityリスト = gappeiJyohoMapper.getSaishintannitsugappeijoho(params);
        // BusinessClass生成
        List<GappeiJyoho> businessList = new ArrayList<>();
        for (GappeiJyohoEntity entity : 合併情報検索結果Entityリスト) {
            GappeiJyoho gappeiJyohoResult = new GappeiJyoho(entity);
            businessList.add(gappeiJyohoResult);
        }
        return businessList;
    }

    /**
     * 最新広域合併市町村情報を取得します。
     *
     * @param hyoujium 表示有無区分
     * @return List<GappeiJyoho> 合併市町村情報Entityリスト
     */
    public List<GappeiJyoho> getKouikigappeijohokennsaku(RString hyoujium) {
        IGappeiJyohoMapper gappeiJyohoMapper = this.mapperProvider.create(IGappeiJyohoMapper.class
        );
        // 検索パラメーター作成
        GappeiJyohoSpecificParameter params = GappeiJyohoSpecificParameter.createParamForKouikigappeijohokennsaku(hyoujium);
        // 検索処理実施
        List<GappeiJyohoEntity> 合併情報検索結果Entityリスト = gappeiJyohoMapper.getKouikigappeijohokennsaku(params);
        // BusinessClass生成
        List<GappeiJyoho> businessList = new ArrayList<>();
        for (GappeiJyohoEntity entity : 合併情報検索結果Entityリスト) {
            businessList.add(new GappeiJyoho(entity));
        }
        return businessList;
    }

    /**
     * 検索キーによる単一合併市町村情報を取得します。
     *
     * @param shichosonCode 市町村コード
     * @param hokenshaNo 保険者番号
     * @return List<GappeiJyoho> 合併市町村情報Entityリスト
     */
    public List<GappeiJyoho> getKensakukitannitsugappeijoho(LasdecCode shichosonCode, HokenshaNo hokenshaNo) {

        IGappeiJyohoMapper gappeiJyohoMapper = this.mapperProvider.create(IGappeiJyohoMapper.class
        );
        // 検索パラメーター作成
        GappeiJyohoSpecificParameter params = GappeiJyohoSpecificParameter.createParamForKouikigappeijohokennsaku(shichosonCode, hokenshaNo);
        // 検索処理実施
        List<GappeiJyohoEntity> 合併情報検索結果Entityリスト = gappeiJyohoMapper.getKensakukitannitsugappeijoho(params);
        // BusinessClass生成
        List<GappeiJyoho> businessList = new ArrayList<>();
        for (GappeiJyohoEntity entity : 合併情報検索結果Entityリスト) {
            businessList.add(new GappeiJyoho(entity));
        }
        return businessList;
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
     * @return List<KouikiGappeiJyoho> 広域合併情報リスト
     */
    public List<KouikiGappeiJyoho> getKensakukikouikigappeijoho(RString chiikiNo, RString gappeiShurui,
                                                                FlexibleDate gappeiYMD, LasdecCode shichosonCode,
                                                                HokenshaNo hokenshaNo, FlexibleDate kyuJohoFuyoToYMD,
                                                                FlexibleDate kokuhorenDataFromYMD, FlexibleDate kijyuYMD) {

        IGappeiJyohoMapper gappeiJyohoMapper = this.mapperProvider.create(IGappeiJyohoMapper.class
        );
        // 検索パラメーター作成
        GappeiJyohoSpecificParameter params = GappeiJyohoSpecificParameter.
                createParamForKensakukikouikigappeijoho(chiikiNo, gappeiShurui, gappeiYMD, shichosonCode,
                                                        hokenshaNo, kyuJohoFuyoToYMD, kokuhorenDataFromYMD, kijyuYMD);
        // 検索処理実施
        List<KouikiGappeiJyohoEntity> 合併情報検索結果Entityリスト = gappeiJyohoMapper.getKensakukikouikigappeijoho(params);
        // BusinessClass生成
        List<KouikiGappeiJyoho> businessList = new ArrayList<>();
        for (KouikiGappeiJyohoEntity entity : 合併情報検索結果Entityリスト) {
            businessList.add(new KouikiGappeiJyoho(entity));
        }
        return businessList;
    }
}
