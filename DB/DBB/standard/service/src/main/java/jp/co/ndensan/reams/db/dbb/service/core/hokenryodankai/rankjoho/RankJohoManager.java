/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.hokenryodankai.rankjoho;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.hokenryorank.HokenryoRank;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.rankjoho.RankJoho;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.hokenryodankai.RankJohoMapperParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.hokenryodankai.RankJohoEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.hokenryodankai.IRankJohoMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbb.service.core.hokenryodankai.hokenryorank.HokenryoRankManager;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT2011RankJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * ランク情報を管理するクラスです。
 *
 * @reamsid_L DBB-9999-013 huangh
 */
public class RankJohoManager {

    private final MapperProvider mapperProvider;
    private final DbT2011RankJohoDac ランク情報Dac;
    private final HokenryoRankManager 保険料ランクManager;

    /**
     * コンストラクタです。
     */
    RankJohoManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.ランク情報Dac = InstanceProvider.create(DbT2011RankJohoDac.class);
        this.保険料ランクManager = new HokenryoRankManager();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param ランク情報Dac ランク情報Dac
     * @param 保険料ランクManager 保険料ランクManager
     */
    RankJohoManager(
            MapperProvider mapperProvider,
            DbT2011RankJohoDac ランク情報Dac,
            HokenryoRankManager 保険料ランクManager
    ) {
        this.mapperProvider = mapperProvider;
        this.ランク情報Dac = ランク情報Dac;
        this.保険料ランクManager = 保険料ランクManager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link RankJohoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link RankJohoManager}のインスタンス
     */
    public static RankJohoManager createInstance() {
        return InstanceProvider.create(RankJohoManager.class);
    }

    /**
     * 主キーに合致するランク情報を返します。
     *
     * @param ランク情報検索条件 ランク情報検索条件
     * @return RankJoho 【　※ツールの都合上、このカッコ部は手動で削除して下さい ランク情報】 nullが返る可能性があります。
     */
    @Transaction
    public RankJoho getランク情報(RankJohoMapperParameter ランク情報検索条件) {
        requireNonNull(ランク情報検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("ランク情報検索条件"));
        IRankJohoMapper mapper = mapperProvider.create(IRankJohoMapper.class);

        RankJohoEntity relateEntity = mapper.selectランク情報ByKey(ランク情報検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new RankJoho(relateEntity);
    }

    /**
     * ランク情報{@link RankJoho}を保存します。
     *
     * @param ランク情報 ランク情報
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean saveランク情報(RankJoho ランク情報) {
        requireNonNull(ランク情報, UrSystemErrorMessages.値がnull.getReplacedMessage("ランク情報"));

        if (!ランク情報.hasChanged()) {
            return false;
        }
        ランク情報 = ランク情報.modifiedModel();
        save保険料ランクリスト(ランク情報.getHokenryoRankList());
        return 1 == ランク情報Dac.save(ランク情報.toEntity());
    }

    private void save保険料ランクリスト(List<HokenryoRank> 保険料ランクList) {
        for (HokenryoRank 保険料ランク : 保険料ランクList) {
            保険料ランクManager.save保険料ランク(保険料ランク);
        }
    }
}
