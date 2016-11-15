/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.fukakousei;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ca.cax.business.core.chotei.choteijokyo.ChoteiJokyo;
import jp.co.ndensan.reams.ca.cax.business.core.chotei.choteikyotsu.Chotei;
import jp.co.ndensan.reams.ca.cax.business.core.chotei.choteikyotsu.ChoteiKyotsuBuilder;
import jp.co.ndensan.reams.ca.cax.business.core.shunokanri.shunokanri.ShunoKanri;
import jp.co.ndensan.reams.ca.cax.service.core.shuno.ShunoService;
import jp.co.ndensan.reams.ca.cax.service.core.shuno.shuno.ShunoManager;
import jp.co.ndensan.reams.ca.cax.service.saiban.ChoteiSaiban;
import jp.co.ndensan.reams.ca.cax.service.saiban.ShunoSaiban;
import jp.co.ndensan.reams.db.dbb.business.core.basic.Gemmen;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.choteikyotsu.ChoteiKyotsu;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.choteikyotsu.ChoteiKyotsuIdentifier;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.kibetsu.Kibetsu;
import jp.co.ndensan.reams.db.dbb.business.core.sokujikosei.SokujiFukaKousei;
import jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHohoKibetsu;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2004GemmenDac;
import jp.co.ndensan.reams.db.dbb.service.core.basic.ChoshuHohoManager;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT2002FukaDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT2003KibetsuDac;
import jp.co.ndensan.reams.ur.urc.business.core.shunokamoku.shunokamoku.IShunoKamoku;
import jp.co.ndensan.reams.ur.urc.definition.core.shuno.tsuchishono.TsuchishoNo;
import jp.co.ndensan.reams.ur.urc.definition.core.shunokamoku.shunokamoku.JigyoKubun;
import jp.co.ndensan.reams.ur.urc.definition.core.shunokamoku.shunokamoku.ShunoKamokuShubetsu;
import jp.co.ndensan.reams.ur.urc.entity.db.basic.shuno.shunokanri.UrT0700ShunoKanriEntity;
import jp.co.ndensan.reams.ur.urc.service.core.shunokamoku.kamoku.ShunoKamokuFinder;
import jp.co.ndensan.reams.ur.urz.definition.core.code.RyokinShubetsuCodeValue;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
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
    private static final RString 即時賦課更正ENTITY = new RString("即時賦課更正");

    /**
     * コンストラクタです。
     */
    public SokujiFukaKouseiManager() {
        介護徴収方法manager = InstanceProvider.create(ChoshuHohoManager.class);
        介護賦課Dac = InstanceProvider.create(DbT2002FukaDac.class);
        介護期別Dac = InstanceProvider.create(DbT2003KibetsuDac.class);
        賦課の減免Dac = InstanceProvider.create(DbT2004GemmenDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param 介護徴収方法manager {@link ChoshuHohoManager}
     * @param 介護賦課Dac {@link DbT2002FukaDac}
     * @param 介護期別Dac {@link DbT2003KibetsuDac}
     * @param 賦課の減免Dac {@link DbT2004GemmenDac}
     */
    SokujiFukaKouseiManager(
            ChoshuHohoManager 介護徴収方法manager,
            DbT2002FukaDac 介護賦課Dac,
            DbT2003KibetsuDac 介護期別Dac,
            DbT2004GemmenDac 賦課の減免Dac) {
        this.介護徴収方法manager = 介護徴収方法manager;
        this.介護賦課Dac = 介護賦課Dac;
        this.介護期別Dac = 介護期別Dac;
        this.賦課の減免Dac = 賦課の減免Dac;
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
        ShunoKamokuFinder shunoKamokuManager = ShunoKamokuFinder.createInstance();
        ShunoManager 収納Manager = ShunoService.get収納Manager();
        for (FukaJoho fukaJoho : sokujiFukaKousei.get賦課の情報リスト()) {
            save介護賦課(shunoKamokuManager, 収納Manager, fukaJoho);
        }
        if (sokujiFukaKousei.get更正後徴収方法() != null) {
            介護徴収方法manager.save介護徴収方法(sokujiFukaKousei.get更正後徴収方法());
        }
        for (Gemmen gemmen : sokujiFukaKousei.get減免の情報リスト()) {
            賦課の減免Dac.save(gemmen.toEntity());
        }
    }

    private boolean save介護賦課(ShunoKamokuFinder shunoKamokuManager,
            ShunoManager 収納Manager,
            FukaJoho 介護賦課) {
        requireNonNull(介護賦課, UrSystemErrorMessages.値がnull.getReplacedMessage("介護賦課"));

        if (!介護賦課.hasChanged()) {
            return false;
        }
        save介護期別リスト(shunoKamokuManager, 収納Manager, 介護賦課.modifiedModel(), 介護賦課.getKibetsuList());
        return 1 == 介護賦課Dac.save(介護賦課.toEntity());
    }

    private void save介護期別リスト(ShunoKamokuFinder shunoKamokuManager,
            ShunoManager 収納Manager,
            FukaJoho 介護賦課,
            List<Kibetsu> 介護期別List) {
        for (Kibetsu 介護期別 : 介護期別List) {
            save介護期別(shunoKamokuManager, 収納Manager, 介護賦課, 介護期別);
        }
    }

    private boolean save介護期別(ShunoKamokuFinder shunoKamokuManager,
            ShunoManager 収納Manager,
            FukaJoho 介護賦課, Kibetsu 介護期別) {
        requireNonNull(介護期別, UrSystemErrorMessages.値がnull.getReplacedMessage("介護期別"));

        if (!介護期別.hasChanged()) {
            return false;
        }
        long 調定ID = ChoteiSaiban.getNumbering調定ID();
        long 収納ID = ShunoSaiban.getNumbering収納ID();
        ChoteiKyotsuIdentifier identifier = new ChoteiKyotsuIdentifier(介護期別.get調定ID().longValue());
        ChoteiKyotsu choteiKyotsu = 介護期別.getChoteiKyotsu(identifier);
        choteiKyotsu = choteiKyotsu.createBuilderForEdit().set処理年度(RDate.getNowDate().getNendo()).build();
        IShunoKamoku 科目 = shunoKamokuManager.get科目(介護期別.get徴収方法().equals(ChoshuHohoKibetsu.普通徴収.getコード())
                ? ShunoKamokuShubetsu.介護保険料_普通徴収 : ShunoKamokuShubetsu.介護保険料_特別徴収);
        ShunoKanri 収納管理 = get収納管理(収納ID, 介護賦課, 科目, 介護期別.get期());
        収納Manager.save調定(収納管理, get調定クラス(調定ID, 収納ID, choteiKyotsu, 科目));
        return 1 == 介護期別Dac.save(介護期別.createBuilderForEdit().set調定ID(new Decimal(調定ID)).build().toEntity());
    }

    private Chotei get調定クラス(long 調定ID, long 収納ID, ChoteiKyotsu choteiKyotsu, IShunoKamoku 科目) {
        ChoteiKyotsuBuilder builder = new Chotei(調定ID, 調定ID).createBuilderForEdit();
        ChoteiJokyo choteiJokyo = new ChoteiJokyo(調定ID).createBuilderForEdit().
                set処理年度(choteiKyotsu.get処理年度()).
                set処理番号(0).
                set科目コード(科目.getコード()).
                set科目枝番コード(科目.get枝番コード()).
                set料金種別コード(new RyokinShubetsuCodeValue(RString.EMPTY)).
                set事業区分コード(RString.EMPTY).
                set収納処理状況(false).
                set合計件数(0).
                set合計金額(Decimal.ZERO).
                build();
        builder.set収納ID(収納ID);
        builder.set会計年度(choteiKyotsu.get会計年度());
        builder.set調定年月日(choteiKyotsu.get調定年月日());
        builder.set調定事由コード(choteiKyotsu.get調定事由コード());
        builder.set処理年度(choteiKyotsu.get処理年度());
        builder.set処理番号(0);
        builder.set更正回数(0);
        builder.set調定額(choteiKyotsu.get調定額());
        builder.set消費税額(Decimal.ZERO);
        builder.set納期限(choteiKyotsu.get納期限());
        builder.set賦課処理状況(choteiKyotsu.is賦課処理状況()).setChoteiJokyo(choteiJokyo);
        return builder.build();
    }

    private ShunoKanri get収納管理(long 収納ID, FukaJoho 介護賦課, IShunoKamoku 科目, int 期) {
        UrT0700ShunoKanriEntity entity = new UrT0700ShunoKanriEntity();
        entity.setShunoId(収納ID);
        entity.setKamokuCode(科目.getコード());
        entity.setKamokuEdabanCode(科目.get枝番コード());
        entity.setJigyoKubunCode(JigyoKubun.未使用.getJigyoKubunCd());
        entity.setChoteiNendo(new RYear(介護賦課.get調定年度().getYearValue()));
        entity.setKazeiNendo(new RYear(介護賦課.get賦課年度().getYearValue()));
        entity.setTsuchishoNo(new TsuchishoNo(new Decimal(介護賦課.get通知書番号().toString())));
        entity.setKibetsu(期);
        entity.setRyokinShubetsuCode(new RyokinShubetsuCodeValue(RString.EMPTY));
        entity.setChoshukenUmu(true);
        entity.setChoteiNo(0);
        entity.setShikibetsuCode(介護賦課.get識別コード());
        return new ShunoKanri(entity);
    }
}
