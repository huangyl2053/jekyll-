/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.kaigoserviceshurui.kaigoservicenaiyou;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoservicenaiyou.KaigoServiceNaiyou;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.mybatisprm.servicecode.SabisuKodoParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7131KaigoServiceNaiyouEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7131KaigoServiceNaiyouDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.mapper.basic.IDbT7131KaigoServiceNaiyouMapper;
import jp.co.ndensan.reams.db.dbx.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護サービス内容を管理するクラスです。
 *
 * @reamsid_L DBA-0060-020 dongyabin
 */
public class KaigoServiceNaiyouManager {

    private static final RString 抽出パターン_1 = new RString("1");
    private static final RString 抽出パターン_2 = new RString("2");
    private static final RString 抽出パターン_3 = new RString("3");
    private static final RString 抽出パターン_4 = new RString("4");
    private static final RString 抽出パターン_5 = new RString("5");
    private static final int 年月_INDEX = 6;
    private final DbT7131KaigoServiceNaiyouDac dac;
    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public KaigoServiceNaiyouManager() {
        dac = InstanceProvider.create(DbT7131KaigoServiceNaiyouDac.class);
        mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7131KaigoServiceNaiyouDac}
     */
    KaigoServiceNaiyouManager(DbT7131KaigoServiceNaiyouDac dac,
            MapperProvider mapperProvider) {
        this.dac = dac;
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KaigoJigyoshaManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KaigoJigyoshaManager}のインスタンス
     */
    public static KaigoServiceNaiyouManager createInstance() {
        return InstanceProvider.create(KaigoServiceNaiyouManager.class);
    }

    /**
     * 介護サービス内容{@link KaigoServiceNaiyou}を保存します。
     *
     * @param 介護サービス内容 {@link KaigoServiceNaiyou}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護サービス内容(KaigoServiceNaiyou 介護サービス内容) {
        requireNonNull(介護サービス内容, UrSystemErrorMessages.値がnull.getReplacedMessage("介護サービス内容"));
        if (!介護サービス内容.hasChanged()) {
            return false;
        }
        return 1 == dac.save(介護サービス内容.toEntity());
    }

    /**
     * サービスコードのフォーカスアウトを取得します。
     *
     * @param parameter SabisuKodoParameter
     * @return List<KaigoServiceNaiyou>
     */
    public List<KaigoServiceNaiyou> getFouceServiceCodeList(SabisuKodoParameter parameter) {
        List<DbT7131KaigoServiceNaiyouEntity> サービスコード情報リスト = dac.getサービス内容(new ServiceShuruiCode(parameter.
                getServiceShuruiCode()),
                parameter.getServiceKoumokuCode(),
                parameter.getHaakuKijunYM());
        List<KaigoServiceNaiyou> サービスコード情報検索リスト = new ArrayList<>();
        for (DbT7131KaigoServiceNaiyouEntity kaigoServiceNaiyouEntity : サービスコード情報リスト) {
            サービスコード情報検索リスト.add(new KaigoServiceNaiyou(kaigoServiceNaiyouEntity));
        }
        return サービスコード情報検索リスト;
    }

    /**
     * サービスコード取得を取得します。
     *
     * @param parameter SabisuKodoParameter
     * @return List<KaigoServiceNaiyou>
     */
    public List<KaigoServiceNaiyou> getServiceCodeList(SabisuKodoParameter parameter) {
        IDbT7131KaigoServiceNaiyouMapper mapper = mapperProvider.create(IDbT7131KaigoServiceNaiyouMapper.class);
        List<DbT7131KaigoServiceNaiyouEntity> サービスコード情報リスト = mapper.getKaigoServiceNaiyou(parameter);
        List<KaigoServiceNaiyou> サービスコード情報検索リスト = new ArrayList<>();
        for (DbT7131KaigoServiceNaiyouEntity kaigoServiceNaiyouEntity : サービスコード情報リスト) {
            サービスコード情報検索リスト.add(new KaigoServiceNaiyou(kaigoServiceNaiyouEntity));
        }
        return サービスコード情報検索リスト;
    }

    /**
     * サービスコード取得２を取得します。
     *
     * @param 基準年月 基準年月
     * @param サービス種類リスト サービス種類リスト
     * @return SearchResult<KaigoServiceNaiyou>
     */
    public SearchResult<KaigoServiceNaiyou> getServiceCodeList2(FlexibleYearMonth 基準年月,
            List<RString> サービス種類リスト) {
        List<KaigoServiceNaiyou> kaigoServiceNaiyouList = new ArrayList<>();
        if (基準年月.isEmpty()) {
            基準年月 = new FlexibleYearMonth(FlexibleDate.getNowDate().toString().substring(0, 年月_INDEX));
        }
        List<DbT7131KaigoServiceNaiyouEntity> entityList = dac.getServiceCodeList2(基準年月, サービス種類リスト);
        for (DbT7131KaigoServiceNaiyouEntity entity : entityList) {
            kaigoServiceNaiyouList.add(new KaigoServiceNaiyou(entity));
        }
        return SearchResult.of(kaigoServiceNaiyouList, 0, false);
    }

    /**
     * サービスコード取得３を取得します。
     *
     * @param 基準年月 基準年月
     * @param 抽出パターン 抽出パターン
     * @return SearchResult<KaigoServiceNaiyou>
     */
    public SearchResult<KaigoServiceNaiyou> getServiceCodeList3(FlexibleYearMonth 基準年月,
            RString 抽出パターン) {
        if (抽出パターン_1.equals(抽出パターン)) {
            基準年月 = new FlexibleYearMonth(DbBusinessConfig.
                    get(ConfigNameDBU.制度改正施行日_支給限度額一本化, RDate.MAX, SubGyomuCode.DBU介護統計報告).substring(0, 年月_INDEX));
        } else if (抽出パターン_2.equals(抽出パターン)
                || 抽出パターン_3.equals(抽出パターン)
                || 抽出パターン_4.equals(抽出パターン)
                || 抽出パターン_5.equals(抽出パターン)) {
            基準年月 = new FlexibleYearMonth(DbBusinessConfig.
                    get(ConfigNameDBU.制度改正施行日_平成１８年０４月改正, RDate.MAX, SubGyomuCode.DBU介護統計報告).substring(0, 年月_INDEX));
        } else {
            if (基準年月.isEmpty()) {
                基準年月 = new FlexibleYearMonth(FlexibleDate.getNowDate().toString().substring(0, 年月_INDEX));
            }
        }
        IDbT7131KaigoServiceNaiyouMapper mapper = mapperProvider.create(IDbT7131KaigoServiceNaiyouMapper.class);
        SabisuKodoParameter param = SabisuKodoParameter.createSearchParam3(基準年月, 抽出パターン);
        List<KaigoServiceNaiyou> kaigoServiceNaiyouList = new ArrayList<>();
        List<DbT7131KaigoServiceNaiyouEntity> entityList = mapper.getServiceCodeList3(param);
        for (DbT7131KaigoServiceNaiyouEntity entity : entityList) {
            kaigoServiceNaiyouList.add(new KaigoServiceNaiyou(entity));
        }
        return SearchResult.of(kaigoServiceNaiyouList, 0, false);
    }

    /**
     * サービスコード取得４を取得します。
     *
     * @param 基準年月 基準年月
     * @param サービス分類リスト サービス分類リスト
     * @return SearchResult<KaigoServiceNaiyou>
     */
    public SearchResult<KaigoServiceNaiyou> getServiceCodeList4(FlexibleYearMonth 基準年月,
            List<RString> サービス分類リスト) {
        IDbT7131KaigoServiceNaiyouMapper mapper = mapperProvider.create(IDbT7131KaigoServiceNaiyouMapper.class);
        if (基準年月.isEmpty()) {
            基準年月 = new FlexibleYearMonth(FlexibleDate.getNowDate().toString().substring(0, 年月_INDEX));
        }

        SabisuKodoParameter param = SabisuKodoParameter.createSearchParam4(基準年月, サービス分類リスト);
        List<KaigoServiceNaiyou> kaigoServiceNaiyouList = new ArrayList<>();
        List<DbT7131KaigoServiceNaiyouEntity> entityList = mapper.getServiceCodeList4(param);
        for (DbT7131KaigoServiceNaiyouEntity entity : entityList) {
            kaigoServiceNaiyouList.add(new KaigoServiceNaiyou(entity));
        }
        return SearchResult.of(kaigoServiceNaiyouList, 0, false);
    }

    /**
     * サービスコード取得を取得します。
     *
     * @param サービス種類コード サービス種類コード
     * @param サービス項目コード サービス項目コード
     * @return List<KaigoServiceNaiyou>
     */
    public List<KaigoServiceNaiyou> getServiceCodeList(RString サービス種類コード,
            RString サービス項目コード) {
        List<DbT7131KaigoServiceNaiyouEntity> サービスコード情報リスト
                = dac.getサービス情報(new ServiceShuruiCode(サービス種類コード),
                        サービス項目コード);
        List<KaigoServiceNaiyou> サービスコード情報検索リスト = new ArrayList<>();
        for (DbT7131KaigoServiceNaiyouEntity kaigoServiceNaiyouEntity : サービスコード情報リスト) {
            サービスコード情報検索リスト.add(new KaigoServiceNaiyou(kaigoServiceNaiyouEntity));
        }
        return サービスコード情報検索リスト;
    }

    /**
     * サービスコードのフォーカスアウトを取得します。
     *
     * @param サービス種類コード サービス種類コード
     * @param サービス項目コード サービス項目コード
     * @param 利用年月 利用年月
     * @return KaigoServiceNaiyou
     */
    public KaigoServiceNaiyou getServiceList(RString サービス種類コード,
            RString サービス項目コード, FlexibleYearMonth 利用年月) {
        DbT7131KaigoServiceNaiyouEntity サービスコード情報 = dac.getサービス内容情報(new ServiceShuruiCode(サービス種類コード),
                サービス項目コード,
                利用年月);
        if (サービスコード情報 == null) {
            return null;
        }
        サービスコード情報.initializeMd5();
        return new KaigoServiceNaiyou(サービスコード情報);
    }

}
