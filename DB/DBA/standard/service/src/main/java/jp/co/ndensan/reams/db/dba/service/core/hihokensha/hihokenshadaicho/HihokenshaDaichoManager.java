/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.hihokensha.hihokenshadaicho;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dba.business.core.hihokensha.hihokenshadaicho.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dba.business.core.hihokensha.iryohokenkanyujokyo.IryohokenKanyuJokyo;
import jp.co.ndensan.reams.db.dba.business.core.hihokensha.jukyushadaicho.JukyushaDaicho;
import jp.co.ndensan.reams.db.dba.business.core.hihokensha.roreifukushinenkinjukyusha.RoreiFukushiNenkinJukyusha;
import jp.co.ndensan.reams.db.dba.business.core.hihokensha.seikatsuhogojukyusha.SeikatsuHogoJukyusha;
import jp.co.ndensan.reams.db.dba.business.core.hihokensha.shisetsunyutaisho.ShisetsuNyutaisho;
import jp.co.ndensan.reams.db.dba.definition.mybatis.param.hihokensha.hihokenshadaicho.HihokenshaDaichoMapperParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokensha.hihokenshadaicho.HihokenshaDaichoRelateEntity;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.hihokensha.hihokenshadaicho.IHihokenshaDaichoMapper;
import jp.co.ndensan.reams.db.dba.service.core.hihokensha.iryohokenkanyujokyo.IryohokenKanyuJokyoManager;
import jp.co.ndensan.reams.db.dba.service.core.hihokensha.jukyushadaicho.JukyushaDaichoManager;
import jp.co.ndensan.reams.db.dba.service.core.hihokensha.roreifukushinenkinjukyusha.RoreiFukushiNenkinJukyushaManager;
import jp.co.ndensan.reams.db.dba.service.core.hihokensha.seikatsuhogojukyusha.SeikatsuHogoJukyushaManager;
import jp.co.ndensan.reams.db.dba.service.core.hihokensha.shisetsunyutaisho.ShisetsuNyutaishoManager;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 被保険者台帳管理を管理するクラスです。
 */
public class HihokenshaDaichoManager {

    private final MapperProvider mapperProvider;
    private final DbT1001HihokenshaDaichoDac 被保険者台帳管理Dac;
    private final JukyushaDaichoManager 受給者台帳Manager;
    private final ShisetsuNyutaishoManager 介護保険施設入退所Manager;
    private final IryohokenKanyuJokyoManager 介護保険医療保険加入状況Manager;
    private final RoreiFukushiNenkinJukyushaManager 老齢福祉年金受給者Manager;
    private final SeikatsuHogoJukyushaManager 生活保護受給者Manager;

    /**
     * コンストラクタです。
     */
    HihokenshaDaichoManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.被保険者台帳管理Dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
        this.受給者台帳Manager = new JukyushaDaichoManager();
        this.介護保険施設入退所Manager = new ShisetsuNyutaishoManager();
        this.介護保険医療保険加入状況Manager = new IryohokenKanyuJokyoManager();
        this.老齢福祉年金受給者Manager = new RoreiFukushiNenkinJukyushaManager();
        this.生活保護受給者Manager = SeikatsuHogoJukyushaManager.createInstance();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 被保険者台帳管理Dac 被保険者台帳管理Dac
     * @param 受給者台帳Manager 受給者台帳Manager
     * @param 介護保険施設入退所Manager 介護保険施設入退所Manager
     * @param 介護保険医療保険加入状況Manager 介護保険医療保険加入状況Manager
     * @param 老齢福祉年金受給者Manager 老齢福祉年金受給者Manager
     * @param 生活保護受給者Manager 生活保護受給者Manager
     */
    HihokenshaDaichoManager(
            MapperProvider mapperProvider,
            DbT1001HihokenshaDaichoDac 被保険者台帳管理Dac,
            JukyushaDaichoManager 受給者台帳Manager,
            ShisetsuNyutaishoManager 介護保険施設入退所Manager,
            IryohokenKanyuJokyoManager 介護保険医療保険加入状況Manager,
            RoreiFukushiNenkinJukyushaManager 老齢福祉年金受給者Manager,
            SeikatsuHogoJukyushaManager 生活保護受給者Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.被保険者台帳管理Dac = 被保険者台帳管理Dac;
        this.受給者台帳Manager = 受給者台帳Manager;
        this.介護保険施設入退所Manager = 介護保険施設入退所Manager;
        this.介護保険医療保険加入状況Manager = 介護保険医療保険加入状況Manager;
        this.老齢福祉年金受給者Manager = 老齢福祉年金受給者Manager;
        this.生活保護受給者Manager = 生活保護受給者Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link HihokenshaDaichoManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link HihokenshaDaichoManager}のインスタンス
     */
    public static HihokenshaDaichoManager createInstance() {
        return InstanceProvider.create(HihokenshaDaichoManager.class);
    }

    /**
     * 主キーに合致する被保険者台帳管理を返します。
     *
     * @param 被保険者台帳管理検索条件 被保険者台帳管理検索条件
     * @return HihokenshaDaicho nullが返る可能性があります。
     */
    @Transaction
    public HihokenshaDaicho get被保険者台帳管理(HihokenshaDaichoMapperParameter 被保険者台帳管理検索条件) {
        requireNonNull(被保険者台帳管理検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者台帳管理検索条件"));
        IHihokenshaDaichoMapper mapper = mapperProvider.create(IHihokenshaDaichoMapper.class);

        HihokenshaDaichoRelateEntity relateEntity = mapper.select被保険者台帳管理ByKey(被保険者台帳管理検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new HihokenshaDaicho(relateEntity);
    }

    /**
     * 被保険者台帳管理{@link HihokenshaDaicho}を保存します。
     *
     * @param 被保険者台帳管理 被保険者台帳管理
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(HihokenshaDaicho 被保険者台帳管理) {
        requireNonNull(被保険者台帳管理, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者台帳管理"));

        if (!被保険者台帳管理.hasChanged()) {
            return false;
        }
        被保険者台帳管理 = 被保険者台帳管理.modifiedModel();
        save受給者台帳リスト(被保険者台帳管理.getJukyushaDaichoList());
        save介護保険施設入退所リスト(被保険者台帳管理.getShisetsuNyutaishoList());
        save介護保険医療保険加入状況リスト(被保険者台帳管理.getIryohokenKanyuJokyoList());
        save老齢福祉年金受給者リスト(被保険者台帳管理.getRoreiFukushiNenkinJukyushaList());
        save生活保護受給者リスト(被保険者台帳管理.getSeikatsuHogoJukyushaList());
        return 1 == 被保険者台帳管理Dac.save(被保険者台帳管理.toEntity());
    }

    private void save受給者台帳リスト(List<JukyushaDaicho> 受給者台帳List) {
        for (JukyushaDaicho 受給者台帳 : 受給者台帳List) {
            受給者台帳Manager.save受給者台帳(受給者台帳);
        }
    }

    private void save介護保険施設入退所リスト(List<ShisetsuNyutaisho> 介護保険施設入退所List) {
        for (ShisetsuNyutaisho 介護保険施設入退所 : 介護保険施設入退所List) {
            介護保険施設入退所Manager.save介護保険施設入退所(介護保険施設入退所);
        }
    }

    private void save介護保険医療保険加入状況リスト(List<IryohokenKanyuJokyo> 介護保険医療保険加入状況List) {
        for (IryohokenKanyuJokyo 介護保険医療保険加入状況 : 介護保険医療保険加入状況List) {
            介護保険医療保険加入状況Manager.save介護保険医療保険加入状況(介護保険医療保険加入状況);
        }
    }

    private void save老齢福祉年金受給者リスト(List<RoreiFukushiNenkinJukyusha> 老齢福祉年金受給者List) {
        for (RoreiFukushiNenkinJukyusha 老齢福祉年金受給者 : 老齢福祉年金受給者List) {
            老齢福祉年金受給者Manager.save老齢福祉年金受給者(老齢福祉年金受給者);
        }
    }

    private void save生活保護受給者リスト(List<SeikatsuHogoJukyusha> 生活保護受給者List) {
        for (SeikatsuHogoJukyusha 生活保護受給者 : 生活保護受給者List) {
            生活保護受給者Manager.save(生活保護受給者);
        }
    }
}
