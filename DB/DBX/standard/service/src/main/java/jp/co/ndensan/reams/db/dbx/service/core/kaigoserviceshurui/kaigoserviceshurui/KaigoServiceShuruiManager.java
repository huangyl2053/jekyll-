/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.kaigoserviceshurui.kaigoserviceshurui;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoservicenaiyou.KaigoServiceNaiyou;
import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoserviceshurui.KaigoServiceShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.mybatisprm.kaigoserviceshurui.KaigoServiceShuruiMapperParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7130KaigoServiceShurui;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7130KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.kaigoserviceshurui.KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7130KaigoServiceShuruiDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.mapper.relate.kaigoserviceshurui.IKaigoServiceShuruiMapper;
import jp.co.ndensan.reams.db.dbx.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.service.core.kaigoserviceshurui.kaigoservicenaiyou.KaigoServiceNaiyouManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.leq;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護サービス種類を管理するクラスです。
 *
 * @reamsid_L DBC-3364-010 xuxin
 */
public class KaigoServiceShuruiManager {

    private static final RString 符号 = new RString(":");

    private final MapperProvider mapperProvider;
    private final DbT7130KaigoServiceShuruiDac 介護サービス種類Dac;
    private final KaigoServiceNaiyouManager 介護サービス内容Manager;

    /**
     * コンストラクタです。
     */
    KaigoServiceShuruiManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.介護サービス種類Dac = InstanceProvider.create(DbT7130KaigoServiceShuruiDac.class);
        this.介護サービス内容Manager = new KaigoServiceNaiyouManager();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 介護サービス種類Dac 介護サービス種類Dac
     * @param 介護サービス内容Manager 介護サービス内容Manager
     */
    KaigoServiceShuruiManager(
            MapperProvider mapperProvider,
            DbT7130KaigoServiceShuruiDac 介護サービス種類Dac,
            KaigoServiceNaiyouManager 介護サービス内容Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.介護サービス種類Dac = 介護サービス種類Dac;
        this.介護サービス内容Manager = 介護サービス内容Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KaigoServiceShuruiManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link KaigoServiceShuruiManager}のインスタンス
     */
    public static KaigoServiceShuruiManager createInstance() {
        return InstanceProvider.create(KaigoServiceShuruiManager.class);
    }

    /**
     * 主キーに合致する介護サービス種類を返します。
     *
     * @param 介護サービス種類検索条件 介護サービス種類検索条件
     * @return KaigoServiceShurui nullが返る可能性があります。
     */
    @Transaction
    public KaigoServiceShurui get介護サービス種類(KaigoServiceShuruiMapperParameter 介護サービス種類検索条件) {
        requireNonNull(介護サービス種類検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("介護サービス種類検索条件"));
        IKaigoServiceShuruiMapper mapper = mapperProvider.create(IKaigoServiceShuruiMapper.class);

        KaigoServiceShuruiEntity relateEntity = mapper.getKaigoServiceEntity(介護サービス種類検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new KaigoServiceShurui(relateEntity);
    }

    /**
     * 介護サービス種類{@link KaigoServiceShurui}を保存します。
     *
     * @param 介護サービス種類 介護サービス種類
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(KaigoServiceShurui 介護サービス種類) {
        requireNonNull(介護サービス種類, UrSystemErrorMessages.値がnull.getReplacedMessage("介護サービス種類"));

        if (!介護サービス種類.hasChanged()) {
            return false;
        }
        介護サービス種類 = 介護サービス種類.modifiedModel();
        save介護サービス内容リスト(介護サービス種類.getKaigoServiceNaiyouList());
        return 1 == 介護サービス種類Dac.save(介護サービス種類.toEntity());
    }

    private void save介護サービス内容リスト(List<KaigoServiceNaiyou> 介護サービス内容List) {
        for (KaigoServiceNaiyou 介護サービス内容 : 介護サービス内容List) {
            介護サービス内容Manager.save介護サービス内容(介護サービス内容);
        }
    }

    /**
     * サービス種類コードより、サービス種類取得のリストを返します。
     *
     * @param 介護サービス種類検索条件 介護サービス種類検索条件
     * @return KaigoServiceShuruiの{@code list}
     */
    @Transaction
    public SearchResult<KaigoServiceShurui> getServiceTypeList(KaigoServiceShuruiMapperParameter 介護サービス種類検索条件) {
        ITrueFalseCriteria makeShuruiConditions;
        if (介護サービス種類検索条件.getServiceShuruiCd() == null || 介護サービス種類検索条件.getServiceShuruiCd().isEmpty()) {
            makeShuruiConditions = and(
                    leq(DbT7130KaigoServiceShurui.teikyoKaishiYM, 介護サービス種類検索条件.getTeikyoKaishiYM()),
                    leq(介護サービス種類検索条件.getTeikyoKaishiYM(), DbT7130KaigoServiceShurui.teikyoshuryoYM));
        } else {
            makeShuruiConditions = and(
                    eq(DbT7130KaigoServiceShurui.serviceShuruiCd, 介護サービス種類検索条件.getServiceShuruiCd()),
                    leq(DbT7130KaigoServiceShurui.teikyoKaishiYM, 介護サービス種類検索条件.getTeikyoKaishiYM()),
                    leq(介護サービス種類検索条件.getTeikyoKaishiYM(), DbT7130KaigoServiceShurui.teikyoshuryoYM));
        }
        List<DbT7130KaigoServiceShuruiEntity> サービス種類情報リスト = 介護サービス種類Dac.select(makeShuruiConditions);
        ArrayList<KaigoServiceShurui> 介護サービス種類List = new ArrayList<>();
        for (DbT7130KaigoServiceShuruiEntity entity : サービス種類情報リスト) {
            KaigoServiceShuruiEntity kaigoServiceShuruiEntity = new KaigoServiceShuruiEntity();
            kaigoServiceShuruiEntity.set介護サービス種類Entity(entity);
            介護サービス種類List.add(new KaigoServiceShurui(kaigoServiceShuruiEntity));
        }
        return SearchResult.of(介護サービス種類List, 0, false);
    }

    /**
     * サービス種類コードより、フォーカスアウトのサービス種類取得のリストを返します。
     *
     * @param サービス種類コード サービス種類コード
     * @return KaigoServiceShuruiの{@code list}
     */
    @Transaction
    public SearchResult<KaigoServiceShurui> getFocusServiceTypeList(RString サービス種類コード) {
        List<DbT7130KaigoServiceShuruiEntity> サービス種類情報リスト = 介護サービス種類Dac.selectByShuruiCode(
                new ServiceShuruiCode(サービス種類コード));
        ArrayList<KaigoServiceShurui> 介護サービス種類List = new ArrayList<>();
        for (DbT7130KaigoServiceShuruiEntity entity : サービス種類情報リスト) {
            KaigoServiceShuruiEntity kaigoServiceShuruiEntity = new KaigoServiceShuruiEntity();
            kaigoServiceShuruiEntity.set介護サービス種類Entity(entity);
            介護サービス種類List.add(new KaigoServiceShurui(kaigoServiceShuruiEntity));
        }
        return SearchResult.of(介護サービス種類List, 0, false);
    }

    /**
     * サービス種類コードより、フォーカスアウトのサービス種類取得のリストを返します。
     *
     * @param 介護サービス種類検索条件 介護サービス種類検索条件
     * @return KaigoServiceShuruiの{@code list}
     */
    @Transaction
    public SearchResult<KaigoServiceShurui> getFocusServiceTypeList(KaigoServiceShuruiMapperParameter 介護サービス種類検索条件) {
        List<DbT7130KaigoServiceShuruiEntity> サービス種類情報リスト = 介護サービス種類Dac.selectByDate(
                介護サービス種類検索条件.getServiceShuruiCd(),
                介護サービス種類検索条件.getTeikyoKaishiYM());
        ArrayList<KaigoServiceShurui> 介護サービス種類List = new ArrayList<>();
        for (DbT7130KaigoServiceShuruiEntity entity : サービス種類情報リスト) {
            KaigoServiceShuruiEntity kaigoServiceShuruiEntity = new KaigoServiceShuruiEntity();
            kaigoServiceShuruiEntity.set介護サービス種類Entity(entity);
            介護サービス種類List.add(new KaigoServiceShurui(kaigoServiceShuruiEntity));
        }
        return SearchResult.of(介護サービス種類List, 0, false);
    }

    /**
     * サービス種類DDLのDataSourceを返します。
     *
     * @return List<KeyValueDataSource>
     */
    @Transaction
    public List<KeyValueDataSource> getサービス種類DDLのDataSource() {

        List<DbT7130KaigoServiceShuruiEntity> サービス種類情報リスト = 介護サービス種類Dac.getサービス種類コードと名称();
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (DbT7130KaigoServiceShuruiEntity entity : サービス種類情報リスト) {
            dataSource.add(new KeyValueDataSource(entity.getServiceShuruiCd().value(),
                    entity.getServiceShuruiCd().value().concat(符号).concat(entity.getServiceShuruiMeisho())));
        }
        return dataSource;
    }

}
