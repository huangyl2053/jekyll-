/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.hokenryodankai.hokenryodankaijoho;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.hokenryodankaijoho.HokenryoDankaiJoho;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.rankjoho.RankJoho;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.hokenryodankai.HokenryoDankaiJohoRelateMapperParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.hokenryodankai.HokenryoDankaiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT2013HokenryoDankaiDac;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.hokenryodankai.IHokenryoDankaiJohoRelateMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbb.service.core.hokenryodankai.rankjoho.RankJohoManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 保険料ランクの情報を管理するクラスです。
 *
 * @reamsid_L DBB-9999-013 huangh
 */
public class HokenryoDankaiJohoManager {

    private final MapperProvider mapperProvider;
    private final DbT2013HokenryoDankaiDac 保険料段階Dac;
    private final RankJohoManager ランク情報Manager;

    /**
     * コンストラクタです。
     */
    HokenryoDankaiJohoManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.保険料段階Dac = InstanceProvider.create(DbT2013HokenryoDankaiDac.class);
        this.ランク情報Manager = RankJohoManager.createInstance();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 保険料段階Dac 保険料段階Dac
     * @param ランク情報Manager ランク情報Manager
     */
    HokenryoDankaiJohoManager(
            MapperProvider mapperProvider,
            DbT2013HokenryoDankaiDac 保険料段階Dac,
            RankJohoManager ランク情報Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.保険料段階Dac = 保険料段階Dac;
        this.ランク情報Manager = ランク情報Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link HokenryoDankaiJohoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link HokenryoDankaiJohoManager}のインスタンス
     */
    public static HokenryoDankaiJohoManager createInstance() {
        return InstanceProvider.create(HokenryoDankaiJohoManager.class);
    }

    /**
     * 主キーに合致する保険料ランクの情報を返します。
     *
     * @param 保険料ランクの情報検索条件 保険料ランクの情報検索条件
     * @return HokenryoDankaiJoho nullが返る可能性があります。
     */
    @Transaction
    public HokenryoDankaiJoho get保険料ランクの情報(HokenryoDankaiJohoRelateMapperParameter 保険料ランクの情報検索条件) {
        requireNonNull(保険料ランクの情報検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("保険料ランクの情報検索条件"));
        IHokenryoDankaiJohoRelateMapper mapper = mapperProvider.create(IHokenryoDankaiJohoRelateMapper.class);

        HokenryoDankaiJohoRelateEntity relateEntity = mapper.select保険料ランクの情報ByKey(保険料ランクの情報検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new HokenryoDankaiJoho(relateEntity);
    }

    /**
     * 保険料段階{@link HokenryoDankaiJoho}を保存します。
     *
     * @param 保険料段階 保険料段階
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(HokenryoDankaiJoho 保険料段階) {
        requireNonNull(保険料段階, UrSystemErrorMessages.値がnull.getReplacedMessage("保険料段階"));

        if (!保険料段階.hasChanged()) {
            return false;
        }
        保険料段階 = 保険料段階.modifiedModel();
        saveランク情報リスト(保険料段階.getRankJohoList());
        return 1 == 保険料段階Dac.save(保険料段階.toEntity());
    }

    private void saveランク情報リスト(List<RankJoho> ランク情報List) {
        for (RankJoho ランク情報 : ランク情報List) {
            ランク情報Manager.saveランク情報(ランク情報);
        }
    }
}
