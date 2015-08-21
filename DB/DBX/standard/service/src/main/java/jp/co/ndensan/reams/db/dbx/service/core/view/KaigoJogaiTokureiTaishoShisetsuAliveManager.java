/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.view;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.view.KaigoJogaiTokureiTaishoShisetsuAlive;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbV1005KaigoJogaiTokureiTaishoShisetsuEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbV1005KaigoJogaiTokureiTaishoShisetsuAliveDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 他市町村住所地特例者台帳管理Aliveを管理するクラスです。
 */
public class KaigoJogaiTokureiTaishoShisetsuAliveManager {

    private final DbV1005KaigoJogaiTokureiTaishoShisetsuAliveDac dac;

    /**
     * コンストラクタです。
     */
    public KaigoJogaiTokureiTaishoShisetsuAliveManager() {
        dac = InstanceProvider.create(DbV1005KaigoJogaiTokureiTaishoShisetsuAliveDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbV1005KaigoJogaiTokureiTaishoShisetsuDac}
     */
    KaigoJogaiTokureiTaishoShisetsuAliveManager(DbV1005KaigoJogaiTokureiTaishoShisetsuAliveDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する他市町村住所地特例者台帳管理Aliveを返します。
     *
     * @param 事業者種別 JigyoshaShubetsu
     * @param 事業者番号 JigyoshaNo
     * @param 有効開始年月日 YukoKaishiYMD
     * @return KaigoJogaiTokureiTaishoShisetsuAlive
     */
    @Transaction
    public KaigoJogaiTokureiTaishoShisetsuAlive get他市町村住所地特例者台帳管理Alive(
            RString 事業者種別,
            RString 事業者番号,
            FlexibleDate 有効開始年月日) {
        requireNonNull(事業者種別, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者種別"));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        requireNonNull(有効開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("有効開始年月日"));

        DbV1005KaigoJogaiTokureiTaishoShisetsuEntity entity = dac.selectByKey(
                事業者種別,
                事業者番号,
                有効開始年月日);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KaigoJogaiTokureiTaishoShisetsuAlive(entity);
    }

    /**
     * 他市町村住所地特例者台帳管理Aliveを全件返します。
     *
     * @return List<KaigoJogaiTokureiTaishoShisetsuAlive>
     */
    @Transaction
    public List<KaigoJogaiTokureiTaishoShisetsuAlive> get他市町村住所地特例者台帳管理Alive一覧() {
        List<KaigoJogaiTokureiTaishoShisetsuAlive> businessList = new ArrayList<>();

        for (DbV1005KaigoJogaiTokureiTaishoShisetsuEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KaigoJogaiTokureiTaishoShisetsuAlive(entity));
        }

        return businessList;
    }

    /**
     * 他市町村住所地特例者台帳管理Alive{@link KaigoJogaiTokureiTaishoShisetsuAlive}を保存します。
     *
     * @param 他市町村住所地特例者台帳管理Alive {@link KaigoJogaiTokureiTaishoShisetsuAlive}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save他市町村住所地特例者台帳管理Alive(KaigoJogaiTokureiTaishoShisetsuAlive 他市町村住所地特例者台帳管理Alive) {
        requireNonNull(他市町村住所地特例者台帳管理Alive, UrSystemErrorMessages.値がnull.getReplacedMessage("他市町村住所地特例者台帳管理Alive"));
        if (!他市町村住所地特例者台帳管理Alive.hasChanged()) {
            return false;
        }
        return 1 == dac.save(他市町村住所地特例者台帳管理Alive.toEntity());
    }
}
