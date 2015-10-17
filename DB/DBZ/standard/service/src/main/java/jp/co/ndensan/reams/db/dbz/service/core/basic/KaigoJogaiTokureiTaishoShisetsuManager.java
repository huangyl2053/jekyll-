/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.KaigoJogaiTokureiTaishoShisetsu;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1005KaigoJogaiTokureiTaishoShisetsuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1005KaigoJogaiTokureiTaishoShisetsuDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護除外住所地特例対象施設を管理するクラスです。
 */
public class KaigoJogaiTokureiTaishoShisetsuManager {

    private final DbT1005KaigoJogaiTokureiTaishoShisetsuDac dac;

    /**
     * コンストラクタです。
     */
    public KaigoJogaiTokureiTaishoShisetsuManager() {
        dac = InstanceProvider.create(DbT1005KaigoJogaiTokureiTaishoShisetsuDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT1005KaigoJogaiTokureiTaishoShisetsuDac}
     */
    KaigoJogaiTokureiTaishoShisetsuManager(DbT1005KaigoJogaiTokureiTaishoShisetsuDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する介護除外住所地特例対象施設を返します。
     *
     * @param 事業者種別 JigyoshaShubetsu
     * @param 事業者番号 JigyoshaNo
     * @param 有効開始年月日 YukoKaishiYMD
     * @return KaigoJogaiTokureiTaishoShisetsu
     */
    @Transaction
    public KaigoJogaiTokureiTaishoShisetsu get介護除外住所地特例対象施設(
            RString 事業者種別,
            RString 事業者番号,
            FlexibleDate 有効開始年月日) {
        requireNonNull(事業者種別, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者種別"));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        requireNonNull(有効開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("有効開始年月日"));

        DbT1005KaigoJogaiTokureiTaishoShisetsuEntity entity = dac.selectByKey(
                事業者種別,
                事業者番号,
                有効開始年月日);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KaigoJogaiTokureiTaishoShisetsu(entity);
    }

    /**
     * 介護除外住所地特例対象施設を全件返します。
     *
     * @return List<KaigoJogaiTokureiTaishoShisetsu>
     */
    @Transaction
    public List<KaigoJogaiTokureiTaishoShisetsu> get介護除外住所地特例対象施設一覧() {
        List<KaigoJogaiTokureiTaishoShisetsu> businessList = new ArrayList<>();

        for (DbT1005KaigoJogaiTokureiTaishoShisetsuEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KaigoJogaiTokureiTaishoShisetsu(entity));
        }

        return businessList;
    }

    /**
     * 介護除外住所地特例対象施設{@link KaigoJogaiTokureiTaishoShisetsu}を保存します。
     *
     * @param 介護除外住所地特例対象施設 {@link KaigoJogaiTokureiTaishoShisetsu}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護除外住所地特例対象施設(KaigoJogaiTokureiTaishoShisetsu 介護除外住所地特例対象施設) {
        requireNonNull(介護除外住所地特例対象施設, UrSystemErrorMessages.値がnull.getReplacedMessage("介護除外住所地特例対象施設"));
        if (!介護除外住所地特例対象施設.hasChanged()) {
            return false;
        }
        return 1 == dac.save(介護除外住所地特例対象施設.toEntity());
    }
}
