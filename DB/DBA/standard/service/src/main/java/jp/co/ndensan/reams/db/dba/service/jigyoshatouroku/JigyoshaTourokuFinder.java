/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.jigyoshatouroku;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyosha.KaigoJigyosha;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshadaihyosha.KaigoJigyoshaDaihyosha;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.kaigojigyosha.kaigojigyosha.KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7060KaigoJigyoshaDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7062KaigoJigyoshaDaihyoshaDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護事業者登録です。
 *
 * @reamsid_L DBA-0340-050 lijia
 *
 */
public class JigyoshaTourokuFinder {

    private final DbT7060KaigoJigyoshaDac dbT7060Dac;
    private final DbT7062KaigoJigyoshaDaihyoshaDac dbT7062Dac;
    private static final RString 状態_更新 = new RString("更新");

    /**
     * コンストラクタです。
     */
    JigyoshaTourokuFinder() {
        this.dbT7060Dac = InstanceProvider.create(DbT7060KaigoJigyoshaDac.class);
        this.dbT7062Dac = InstanceProvider.create(DbT7062KaigoJigyoshaDaihyoshaDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param dbT7060Dac 介護事業者Dac
     * @param dbT7062Dac 介護事業者代表者Dac
     */
    JigyoshaTourokuFinder(
            DbT7060KaigoJigyoshaDac dbT7060Dac,
            DbT7062KaigoJigyoshaDaihyoshaDac dbT7062Dac
    ) {
        this.dbT7060Dac = dbT7060Dac;
        this.dbT7062Dac = dbT7062Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link HihokenshaDaichoSakuseiManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link HihokenshaDaichoSakuseiManager}のインスタンス
     */
    public static JigyoshaTourokuFinder createInstance() {
        return InstanceProvider.create(JigyoshaTourokuFinder.class);
    }

    /**
     * 介護事業者{@link KaigoJigyosha}を削除します。
     *
     * @param 介護事業者 介護事業者
     * @return 削除あり:true、削除なし:false <br>
     * いずれかのテーブルに削除があればtrueを返す、いずれのテーブルもunchangedで削除無しの場合falseを返す
     */
    @Transaction
    public boolean saveOrDelete(KaigoJigyosha 介護事業者) {
        requireNonNull(介護事業者, UrSystemErrorMessages.値がnull.getReplacedMessage("介護事業者"));
        if (!介護事業者.hasChanged()) {
            return false;
        }
        介護事業者 = 介護事業者.deleted();
        save介護事業者代表者リスト(介護事業者.getKaigoJigyoshaDaihyoshaList());
        return 1 == dbT7060Dac.saveOrDeletePhysicalBy(介護事業者.toEntity());
    }

    private boolean save介護事業者代表者リスト(List<KaigoJigyoshaDaihyosha> 介護事業者代表者List) {
        return 1 == dbT7062Dac.saveOrDeletePhysicalBy(介護事業者代表者List.get(0).toEntity());
    }

    /**
     * 介護事業者情報の編集します。
     *
     * @param entity 介護事業者
     * @param 状態 処理状態
     * @return KaigoJigyoshaEntity 介護事業者RelateEntity *
     */
    public KaigoJigyoshaEntity 介護事業者情報の編集(DbT7060KaigoJigyoshaEntity entity, RString 状態) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護事業者"));
        KaigoJigyoshaEntity kaigoJigyoshaEntity = new KaigoJigyoshaEntity();
        if (状態_更新.equals(状態)) {
            entity.setState(EntityDataState.Modified);
        } else {
            entity.setState(EntityDataState.Deleted);
        }
        kaigoJigyoshaEntity.set介護事業者Entity(entity);
        return kaigoJigyoshaEntity;
    }
}
