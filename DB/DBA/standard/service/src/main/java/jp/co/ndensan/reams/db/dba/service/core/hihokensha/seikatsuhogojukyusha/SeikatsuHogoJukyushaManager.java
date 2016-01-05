/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.hihokensha.seikatsuhogojukyusha;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dba.business.core.hihokensha.seikatsuhogofujoshurui.SeikatsuHogoFujoShurui;
import jp.co.ndensan.reams.db.dba.business.core.hihokensha.seikatsuhogojukyusha.SeikatsuHogoJukyusha;
import jp.co.ndensan.reams.db.dba.business.core.hihokensha.seikatsuhogoteishikikan.SeikatsuHogoTeishikikan;
import jp.co.ndensan.reams.db.dba.definition.mybatis.param.hihokensha.seikatsuhogojukyusha.SeikatsuHogoJukyushaMapperParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokensha.seikatsuhogojukyusha.SeikatsuHogoJukyushaRelateEntity;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.hihokensha.seikatsuhogojukyusha.ISeikatsuHogoJukyushaMapper;
import jp.co.ndensan.reams.db.dba.service.core.hihokensha.seikatsuhogoteishikikan.SeikatsuHogoTeishikikanManager;
import jp.co.ndensan.reams.db.dba.service.core.hihokensha.seikatsuhogofujoshurui.SeikatsuHogoFujoShuruiManager;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urd.persistence.db.basic.seikatsuhogo.UrT0508SeikatsuhogoJukyushaDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 生活保護受給者を管理するクラスです。
 */
public class SeikatsuHogoJukyushaManager {

    private final MapperProvider mapperProvider;
    private final UrT0508SeikatsuhogoJukyushaDac 生活保護受給者Dac;
    private final SeikatsuHogoFujoShuruiManager 生活保護扶助種類Manager;
    private final SeikatsuHogoTeishikikanManager 生活保護停止期間Manager;

    /**
     * コンストラクタです。
     */
    SeikatsuHogoJukyushaManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.生活保護受給者Dac = InstanceProvider.create(UrT0508SeikatsuhogoJukyushaDac.class);
        this.生活保護扶助種類Manager = new SeikatsuHogoFujoShuruiManager();
        this.生活保護停止期間Manager = new SeikatsuHogoTeishikikanManager();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 生活保護受給者Dac 生活保護受給者Dac
     * @param 生活保護扶助種類Manager 生活保護扶助種類Manager
     * @param 生活保護停止期間Manager 生活保護停止期間Manager
     */
    SeikatsuHogoJukyushaManager(
            MapperProvider mapperProvider,
            UrT0508SeikatsuhogoJukyushaDac 生活保護受給者Dac,
            SeikatsuHogoFujoShuruiManager 生活保護扶助種類Manager,
            SeikatsuHogoTeishikikanManager 生活保護停止期間Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.生活保護受給者Dac = 生活保護受給者Dac;
        this.生活保護扶助種類Manager = 生活保護扶助種類Manager;
        this.生活保護停止期間Manager = 生活保護停止期間Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SeikatsuHogoJukyushaManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link SeikatsuHogoJukyushaManager}のインスタンス
     */
    public static SeikatsuHogoJukyushaManager createInstance() {
        return InstanceProvider.create(SeikatsuHogoJukyushaManager.class);
    }

    /**
     * 主キーに合致する生活保護受給者を返します。
     *
     * @param 生活保護受給者検索条件 生活保護受給者検索条件
     * @return SeikatsuHogoJukyusha nullが返る可能性があります。
     */
    @Transaction
    public SeikatsuHogoJukyusha get生活保護受給者(SeikatsuHogoJukyushaMapperParameter 生活保護受給者検索条件) {
        requireNonNull(生活保護受給者検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("生活保護受給者検索条件"));
        ISeikatsuHogoJukyushaMapper mapper = mapperProvider.create(ISeikatsuHogoJukyushaMapper.class);

        SeikatsuHogoJukyushaRelateEntity relateEntity = mapper.select生活保護受給者ByKey(生活保護受給者検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new SeikatsuHogoJukyusha(relateEntity);
    }

    /**
     * 生活保護受給者{@link SeikatsuHogoJukyusha}を保存します。
     *
     * @param 生活保護受給者 生活保護受給者
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(SeikatsuHogoJukyusha 生活保護受給者) {
        requireNonNull(生活保護受給者, UrSystemErrorMessages.値がnull.getReplacedMessage("生活保護受給者"));

        if (!生活保護受給者.hasChanged()) {
            return false;
        }
        生活保護受給者 = 生活保護受給者.modifiedModel();
        save生活保護扶助種類リスト(生活保護受給者.getSeikatsuHogoFujoShuruiList());
        save生活保護停止期間リスト(生活保護受給者.getSeikatsuHogoTeishikikanList());
        return 1 == 生活保護受給者Dac.save(生活保護受給者.toEntity());
    }

    private void save生活保護扶助種類リスト(List<SeikatsuHogoFujoShurui> 生活保護扶助種類List) {
        for (SeikatsuHogoFujoShurui 生活保護扶助種類 : 生活保護扶助種類List) {
            生活保護扶助種類Manager.save生活保護扶助種類(生活保護扶助種類);
        }
    }

    private void save生活保護停止期間リスト(List<SeikatsuHogoTeishikikan> 生活保護停止期間List) {
        for (SeikatsuHogoTeishikikan 生活保護停止期間 : 生活保護停止期間List) {
            生活保護停止期間Manager.save生活保護停止期間(生活保護停止期間);
        }
    }
}
