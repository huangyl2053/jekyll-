/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.fukakousei;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ca.cax.service.saiban.ChoteiSaiban;
import jp.co.ndensan.reams.ca.cax.service.saiban.ShunoSaiban;
import jp.co.ndensan.reams.db.dbb.business.core.basic.Gemmen;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.choteikyotsu.ChoteiKyotsu;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.choteikyotsu.ChoteiKyotsuIdentifier;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.kibetsu.Kibetsu;
import jp.co.ndensan.reams.db.dbb.business.core.sokujikosei.SokujiFukaKousei;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2004GemmenDac;
import jp.co.ndensan.reams.db.dbb.service.core.basic.ChoshuHohoManager;
import jp.co.ndensan.reams.db.dbb.service.core.fukajoho.fukajoho.FukaJohoManager;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT2002FukaDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT2003KibetsuDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.UrT0705ChoteiKyotsuDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 即時賦課更正を管理するクラスです。
 *
 * @reamsid_L DBB-0660-010 tianshuai
 */
public class SokujiFukaKouseiManager {

    private final ChoshuHohoManager 介護徴収方法manager;
    private final DbT2002FukaDac 介護賦課Dac;
    private final DbT2003KibetsuDac 介護期別Dac;
    private final DbT2004GemmenDac 賦課の減免Dac;
    private final UrT0705ChoteiKyotsuDac 調定共通Dac;
    private static final RString 即時賦課更正ENTITY = new RString("即時賦課更正");
    private static final int INT_1 = 1;

    /**
     * コンストラクタです。
     */
    public SokujiFukaKouseiManager() {
        介護徴収方法manager = InstanceProvider.create(ChoshuHohoManager.class);
        介護賦課Dac = InstanceProvider.create(DbT2002FukaDac.class);
        介護期別Dac = InstanceProvider.create(DbT2003KibetsuDac.class);
        賦課の減免Dac = InstanceProvider.create(DbT2004GemmenDac.class);
        調定共通Dac = InstanceProvider.create(UrT0705ChoteiKyotsuDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param 賦課の減免manager {@link DbT2004GemmenDac}
     * @param 賦課の情報manager {@link FukaJohoManager}
     * @param 介護徴収方法manager {@link ChoshuHohoManager}
     */
    SokujiFukaKouseiManager(
            FukaJohoManager 賦課の情報manager,
            ChoshuHohoManager 介護徴収方法manager,
            DbT2002FukaDac 介護賦課Dac,
            DbT2003KibetsuDac 介護期別Dac,
            DbT2004GemmenDac 賦課の減免Dac,
            UrT0705ChoteiKyotsuDac 調定共通Dac) {
        this.介護徴収方法manager = 介護徴収方法manager;
        this.介護賦課Dac = 介護賦課Dac;
        this.介護期別Dac = 介護期別Dac;
        this.賦課の減免Dac = 賦課の減免Dac;
        this.調定共通Dac = 調定共通Dac;
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
            save介護賦課(fukaJoho);
        }
        if (sokujiFukaKousei.get更正後徴収方法() != null) {
            介護徴収方法manager.save介護徴収方法(sokujiFukaKousei.get更正後徴収方法());
        }
        for (Gemmen gemmen : sokujiFukaKousei.get減免の情報リスト()) {
            賦課の減免Dac.save(gemmen.toEntity());
        }
    }

    private boolean save介護賦課(FukaJoho 介護賦課) {
        requireNonNull(介護賦課, UrSystemErrorMessages.値がnull.getReplacedMessage("介護賦課"));

        if (!介護賦課.hasChanged()) {
            return false;
        }
        介護賦課 = 介護賦課.modifiedModel();
        save介護期別リスト(介護賦課.getKibetsuList());
        return 1 == 介護賦課Dac.save(介護賦課.toEntity());
    }

    private void save介護期別リスト(List<Kibetsu> 介護期別List) {
        for (Kibetsu 介護期別 : 介護期別List) {
            save介護期別(介護期別);
        }
    }

    private boolean save介護期別(Kibetsu 介護期別) {
        requireNonNull(介護期別, UrSystemErrorMessages.値がnull.getReplacedMessage("介護期別"));

        if (!介護期別.hasChanged()) {
            return false;
        }
        介護期別 = 介護期別.modifiedModel();
        long 収納ID = ShunoSaiban.getNumbering収納ID();
        long 調定ID = ChoteiSaiban.getNumbering調定ID();
        ChoteiKyotsuIdentifier identifier = new ChoteiKyotsuIdentifier(介護期別.get調定ID().longValue());
        ChoteiKyotsu choteiKyotsu = 介護期別.getChoteiKyotsu(identifier);
        ChoteiKyotsu 調定共通 = new ChoteiKyotsu(調定ID).createBuilderForEdit().
                set履歴番号(INT_1).
                set収納ID(収納ID).
                set会計年度(choteiKyotsu.get会計年度()).
                set処理年度(choteiKyotsu.get処理年度()).
                set処理番号((int) choteiKyotsu.get処理番号()).
                set更正回数(choteiKyotsu.get更正回数()).
                set調定事由コード(choteiKyotsu.get調定事由コード()).
                set調定年月日(choteiKyotsu.get調定年月日()).
                set調定額(choteiKyotsu.get調定額()).
                set消費税額(choteiKyotsu.get消費税額()).
                set納期限(choteiKyotsu.get納期限()).
                set法定納期限等(choteiKyotsu.get法定納期限等()).
                set賦課処理状況(choteiKyotsu.is賦課処理状況()).build();
        save調定共通(調定共通);
        return 1 == 介護期別Dac.save(介護期別.createBuilderForEdit().set調定ID(new Decimal(調定ID)).build().toEntity());
    }

    private boolean save調定共通(ChoteiKyotsu 調定共通) {
        requireNonNull(調定共通, UrSystemErrorMessages.値がnull.getReplacedMessage("調定共通"));
        if (!調定共通.hasChanged()) {
            return false;
        }
        return 1 == 調定共通Dac.save(調定共通.toEntity());
    }
}
