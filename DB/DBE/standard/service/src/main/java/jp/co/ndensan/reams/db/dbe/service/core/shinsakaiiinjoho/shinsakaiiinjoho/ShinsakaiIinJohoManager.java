/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.shinsakaiiinjoho.shinsakaiiinjoho;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinjoho.kaigoninteishinsakaiiinshozokukikanjoho.KaigoNinteiShinsakaiIinShozokuKikanJoho;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinjoho.shinsakaiiinjoho.ShinsakaiIinJoho;
import jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.ShinsainYusoKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.Sikaku;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.shinsakaiiinjoho.ShinsakaiIinJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaiiinjoho.shinsakaiiinjoho.ShinsakaiIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5594ShinsakaiIinJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsakaiiinjoho.IShinsakaiIinJohoMapper;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakaiiinjoho.kaigoninteishinsakaiiinshozokukikanjoho.KaigoNinteiShinsakaiIinShozokuKikanJohoManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護認定審査会委員情報を管理するクラスです。
 */
public class ShinsakaiIinJohoManager {

    private final MapperProvider mapperProvider;
    private final DbT5594ShinsakaiIinJohoDac 介護認定審査会委員情報Dac;
    private final KaigoNinteiShinsakaiIinShozokuKikanJohoManager 介護認定審査会委員所属機関情報Manager;

    /**
     * コンストラクタです。
     */
    ShinsakaiIinJohoManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.介護認定審査会委員情報Dac = InstanceProvider.create(DbT5594ShinsakaiIinJohoDac.class);
        this.介護認定審査会委員所属機関情報Manager = new KaigoNinteiShinsakaiIinShozokuKikanJohoManager();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 介護認定審査会委員情報Dac 介護認定審査会委員情報Dac
     * @param 介護認定審査会委員所属機関情報Manager 介護認定審査会委員所属機関情報Manager
     */
    ShinsakaiIinJohoManager(
            MapperProvider mapperProvider,
            DbT5594ShinsakaiIinJohoDac 介護認定審査会委員情報Dac,
            KaigoNinteiShinsakaiIinShozokuKikanJohoManager 介護認定審査会委員所属機関情報Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.介護認定審査会委員情報Dac = 介護認定審査会委員情報Dac;
        this.介護認定審査会委員所属機関情報Manager = 介護認定審査会委員所属機関情報Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShinsakaiIinJohoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShinsakaiIinJohoManager}のインスタンス
     */
    public static ShinsakaiIinJohoManager createInstance() {
        return InstanceProvider.create(ShinsakaiIinJohoManager.class);
    }

    /**
     * 資格コードが資格コードを表す列挙型クラスからコード、名称を取得する。
     *
     * @return List<KeyValueDataSource>
     */
    public List<KeyValueDataSource> get資格コードList() {
        List<KeyValueDataSource> 資格コード = new ArrayList<>();
        資格コード.add(new KeyValueDataSource(Sikaku.医師.getコード(), Sikaku.医師.get名称()));
        資格コード.add(new KeyValueDataSource(Sikaku.歯科医師.getコード(), Sikaku.歯科医師.get名称()));
        資格コード.add(new KeyValueDataSource(Sikaku.薬剤師.getコード(), Sikaku.薬剤師.get名称()));
        資格コード.add(new KeyValueDataSource(Sikaku.保健師.getコード(), Sikaku.保健師.get名称()));
        資格コード.add(new KeyValueDataSource(Sikaku.助産師.getコード(), Sikaku.助産師.get名称()));
        資格コード.add(new KeyValueDataSource(Sikaku._洵_看護師.getコード(), Sikaku._洵_看護師.get名称()));
        資格コード.add(new KeyValueDataSource(Sikaku.理学療法士.getコード(), Sikaku.理学療法士.get名称()));
        資格コード.add(new KeyValueDataSource(Sikaku.作業療法士.getコード(), Sikaku.作業療法士.get名称()));
        資格コード.add(new KeyValueDataSource(Sikaku.社会福祉士.getコード(), Sikaku.社会福祉士.get名称()));
        資格コード.add(new KeyValueDataSource(Sikaku.介護福祉士.getコード(), Sikaku.介護福祉士.get名称()));
        資格コード.add(new KeyValueDataSource(Sikaku.ソーシャルワーカー.getコード(), Sikaku.ソーシャルワーカー.get名称()));
        資格コード.add(new KeyValueDataSource(Sikaku.福祉事務所現業員等.getコード(), Sikaku.福祉事務所現業員等.get名称()));
        資格コード.add(new KeyValueDataSource(Sikaku.ホームヘルパー.getコード(), Sikaku.ホームヘルパー.get名称()));
        資格コード.add(new KeyValueDataSource(Sikaku.介護職員.getコード(), Sikaku.介護職員.get名称()));
        資格コード.add(new KeyValueDataSource(Sikaku.その他福祉関係者.getコード(), Sikaku.その他福祉関係者.get名称()));
        資格コード.add(new KeyValueDataSource(Sikaku.行政関係者.getコード(), Sikaku.行政関係者.get名称()));
        資格コード.add(new KeyValueDataSource(Sikaku.その他.getコード(), Sikaku.その他.get名称()));

        return 資格コード;
    }

    /**
     * 審査員郵送区分が審査員郵送区分を表す列挙型クラスからコード、名称を取得する。
     *
     * @return List<KeyValueDataSource>
     */
    public List<KeyValueDataSource> get審査員郵送区分List() {
        List<KeyValueDataSource> 審査員郵送区分 = new ArrayList<>();
        審査員郵送区分.add(new KeyValueDataSource(ShinsainYusoKubun.自宅.get郵送区分(), new RString(ShinsainYusoKubun.自宅.name())));
        審査員郵送区分.add(new KeyValueDataSource(ShinsainYusoKubun.所属機関.get郵送区分(), new RString(ShinsainYusoKubun.所属機関.name())));

        return 審査員郵送区分;
    }

    /**
     * 審査会委員一覧情報は表示条件で検索を取得する。
     *
     * @param 表示条件 RString
     * @return List<ShinsakaiIinJoho>
     */
    public SearchResult<ShinsakaiIinJoho> get審査会委員一覧(RString 表示条件) {
        List<ShinsakaiIinJoho> 審査会委員一覧 = new ArrayList<>();
        boolean is全ての審査会委員 = false;
        if (new RString("key1").equals(表示条件)) {
            is全ての審査会委員 = true;
        }
        IShinsakaiIinJohoMapper mapper = mapperProvider.create(IShinsakaiIinJohoMapper.class);
        List<ShinsakaiIinJohoEntity> 審査会委員情報 = mapper.get審査会委員情報By表示条件(is全ての審査会委員);
        if (審査会委員情報 == null || 審査会委員情報.isEmpty()) {
            return SearchResult.of(審査会委員一覧, 0, false);
        }
        for (ShinsakaiIinJohoEntity entity : 審査会委員情報) {
            entity.initializeMd5ToEntities();
            審査会委員一覧.add(new ShinsakaiIinJoho(entity));
        }
        return SearchResult.of(審査会委員一覧, 0, false);
    }

    /**
     * 審査会委員カウントを取得する。
     *
     * @param parameter ShinsakaiIinJohoMapperParameter
     * @return int 審査会委員件数
     */
    @Transaction
    public int get審査会委員カウント(ShinsakaiIinJohoMapperParameter parameter) {
        IShinsakaiIinJohoMapper mapper = mapperProvider.create(IShinsakaiIinJohoMapper.class);

        return mapper.get審査会委員カウント(parameter);
    }

    /**
     * 主キーに合致する介護認定審査会委員情報を返します。
     *
     * @param 介護認定審査会委員情報検索条件 介護認定審査会委員情報検索条件
     * @return ShinsakaiIinJoho nullが返る可能性があります。
     */
    @Transaction
    public ShinsakaiIinJoho get介護認定審査会委員情報(ShinsakaiIinJohoMapperParameter 介護認定審査会委員情報検索条件) {
        requireNonNull(介護認定審査会委員情報検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会委員情報検索条件"));
        IShinsakaiIinJohoMapper mapper = mapperProvider.create(IShinsakaiIinJohoMapper.class);

        ShinsakaiIinJohoEntity relateEntity = mapper.getShinsakaiIinJohoEntity(介護認定審査会委員情報検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new ShinsakaiIinJoho(relateEntity);
    }

    /**
     * 介護認定審査会委員情報{@link ShinsakaiIinJoho}を保存します。
     *
     * @param 介護認定審査会委員情報 介護認定審査会委員情報
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(ShinsakaiIinJoho 介護認定審査会委員情報) {
        requireNonNull(介護認定審査会委員情報, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会委員情報"));

        if (!介護認定審査会委員情報.hasChanged()) {
            return false;
        }
        介護認定審査会委員情報 = 介護認定審査会委員情報.modifiedModel();
        save介護認定審査会委員所属機関情報リスト(介護認定審査会委員情報.getKaigoNinteiShinsakaiIinShozokuKikanJohoList());
        return 1 == 介護認定審査会委員情報Dac.save(介護認定審査会委員情報.toEntity());
    }

    /**
     * 介護認定審査会委員所属機関情報{@link KaigoNinteiShinsakaiIinShozokuKikanJoho}を物理削除します。
     *
     * @param 介護認定審査会委員所属機関情報リスト 介護認定審査会委員所属機関情報リスト
     */
    @Transaction
    public void deletePhysical介護認定審査会委員所属機関情報(List<KaigoNinteiShinsakaiIinShozokuKikanJoho> 介護認定審査会委員所属機関情報リスト) {
        requireNonNull(介護認定審査会委員所属機関情報リスト, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会委員情報"));
        for (KaigoNinteiShinsakaiIinShozokuKikanJoho 介護認定審査会委員所属機関情報 : 介護認定審査会委員所属機関情報リスト) {
            介護認定審査会委員所属機関情報Manager.deletePhysical介護認定審査会委員所属機関情報(介護認定審査会委員所属機関情報);
        }
    }

    private void save介護認定審査会委員所属機関情報リスト(List<KaigoNinteiShinsakaiIinShozokuKikanJoho> 介護認定審査会委員所属機関情報List) {
        for (KaigoNinteiShinsakaiIinShozokuKikanJoho 介護認定審査会委員所属機関情報 : 介護認定審査会委員所属機関情報List) {
            介護認定審査会委員所属機関情報Manager.save介護認定審査会委員所属機関情報(介護認定審査会委員所属機関情報);
        }
    }
}
