/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.fukakousei;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.business.core.basic.Gemmen;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.business.core.sokujikosei.SokujiFukaKousei;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2004GemmenDac;
import jp.co.ndensan.reams.db.dbb.service.core.basic.ChoshuHohoManager;
import jp.co.ndensan.reams.db.dbb.service.core.fukajoho.fukajoho.FukaJohoManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 即時賦課更正を管理するクラスです。
 *
 * @reamsid_L DBB-0660-010 tianshuai
 */
public class SokujiFukaKouseiManager {

    private final DbT2004GemmenDac 賦課の減免manager;
    private final FukaJohoManager 賦課の情報manager;
    private final ChoshuHohoManager 介護徴収方法manager;
    private static final RString 即時賦課更正ENTITY = new RString("即時賦課更正");

    /**
     * コンストラクタです。
     */
    public SokujiFukaKouseiManager() {
        賦課の減免manager = InstanceProvider.create(DbT2004GemmenDac.class);
        賦課の情報manager = InstanceProvider.create(FukaJohoManager.class);
        介護徴収方法manager = InstanceProvider.create(ChoshuHohoManager.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param 賦課の減免manager {@link DbT2004GemmenDac}
     * @param 賦課の情報manager {@link FukaJohoManager}
     * @param 介護徴収方法manager {@link ChoshuHohoManager}
     */
    SokujiFukaKouseiManager(
            DbT2004GemmenDac 賦課の減免manager,
            FukaJohoManager 賦課の情報manager,
            ChoshuHohoManager 介護徴収方法manager) {
        this.賦課の減免manager = 賦課の減免manager;
        this.賦課の情報manager = 賦課の情報manager;
        this.介護徴収方法manager = 介護徴収方法manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SokujiFukaKouseiManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link SokujiFukaKouseiManager}のインスタンス
     */
    public static SokujiFukaKouseiManager createInstance() {
        return InstanceProvider.create(SokujiFukaKouseiManager.class);
    }

    /**
     * 即時賦課{@link SokujiFukaKousei}を保存します。
     *
     * @param sokujiFukaKousei {@link SokujiFukaKousei}
     */
    @Transaction
    public void do即時賦課更正(SokujiFukaKousei sokujiFukaKousei) {
        requireNonNull(sokujiFukaKousei, UrSystemErrorMessages.値がnull.getReplacedMessage(即時賦課更正ENTITY.toString()));
        for (FukaJoho fukaJoho : sokujiFukaKousei.get賦課の情報リスト()) {
            賦課の情報manager.save(fukaJoho);
        }
        if (sokujiFukaKousei.get更正後徴収方法() != null) {
            介護徴収方法manager.save介護徴収方法(sokujiFukaKousei.get更正後徴収方法());
        }
        for (Gemmen gemmen : sokujiFukaKousei.get減免の情報リスト()) {
            賦課の減免manager.save(gemmen.toEntity());
        }
    }
}
