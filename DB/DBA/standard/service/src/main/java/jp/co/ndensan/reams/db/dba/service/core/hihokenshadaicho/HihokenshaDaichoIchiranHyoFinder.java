/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.hihokenshadaicho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.hihokenshadaicho.IkkatsuSakuseiMybatisParameter;
import jp.co.ndensan.reams.db.dba.entity.db.hihokenshadaichosakusei.HihokenshaDaichoSakuseiEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshadaicho.HihokenshaDaichoIchiranHyoRelateEntity;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.hihokenshadaicho.IIkkatsuSakuseiMapper;
import jp.co.ndensan.reams.db.dba.service.core.nyutaishoshakanri.NyutaishoshaKanriFinder;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.AgeCalculator;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.DateOfBirthFactory;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.AgeArrivalDay;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;
import org.codehaus.plexus.util.StringUtils;

/**
 * 被保険者台帳一括作成バッチより、被保険者台帳一覧表帳票用DataEntityを作成します。
 */
public class HihokenshaDaichoIchiranHyoFinder {

    private static final RString MARU = new RString("○");
    private static final RString 被保険者区分コード_1 = new RString("1");
    private static final RString 被保険者区分コード_2 = new RString("2");
    private static final RString 資格区分_1号 = new RString("１号");
    private static final RString 資格区分_2号 = new RString("２号");
    private static final int LENGTH_50 = 50;
    private static final int LENGTH_60 = 60;

    private final MapperProvider mapperProvider;
    private IIkkatsuSakuseiMapper iIkkatsuSakuseiMapper;
    private final DbT1001HihokenshaDaichoDac 被保険者台帳管理Dac;

    /**
     * コンストラクタです。
     */
    public HihokenshaDaichoIchiranHyoFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.被保険者台帳管理Dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NyutaishoshaKanriFinder}のインスタンスを返します。
     *
     * @return NyutaishoshaKanriFinder
     */
    public static HihokenshaDaichoIchiranHyoFinder createInstance() {
        return InstanceProvider.create(HihokenshaDaichoIchiranHyoFinder.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     */
    HihokenshaDaichoIchiranHyoFinder(MapperProvider mapperProvider, DbT1001HihokenshaDaichoDac 被保険者台帳管理Dac) {
        this.mapperProvider = mapperProvider;
        this.被保険者台帳管理Dac = 被保険者台帳管理Dac;
    }

    /**
     * 介護保険施設情報件数を取得する
     *
     * @param hihokenshaList hihokenshaList
     * @return List<HihokenshaDaichoIchiranHyoRelateEntity>
     */
    @Transaction
    public List<HihokenshaDaichoIchiranHyoRelateEntity> getChohyoIchiran(List<HihokenshaDaichoSakuseiEntity> hihokenshaList) {
        int リストNO = 0;
        List<HihokenshaDaichoIchiranHyoRelateEntity> 被保険者台帳一覧表List = new ArrayList<>();
        for (HihokenshaDaichoSakuseiEntity entity : hihokenshaList) {
            HihokenshaDaichoIchiranHyoRelateEntity 被保険者台帳一覧表Entity = new HihokenshaDaichoIchiranHyoRelateEntity();
            UaFt200FindShikibetsuTaishoEntity uaFt200Entity = get宛名識別対象取得(entity);
            IShikibetsuTaisho 識別対象 = ShikibetsuTaishoFactory.createKojin(uaFt200Entity);
            被保険者台帳一覧表Entity.set作成日付(RDate.getNowDate());
            被保険者台帳一覧表Entity.set市町村ID(entity.getShichosonCode());
            被保険者台帳一覧表Entity.set市町村名称(entity.getShichosonMeisho());
            // TODO 段站立　QA#73393
            //被保険者台帳一覧表Entity.set並び順(RString.EMPTY);
            //被保険者台帳一覧表Entity.set改頁(RString.EMPTY);
            被保険者台帳一覧表Entity.set被保険者番号(entity.getHihokenshaNo());
            被保険者台帳一覧表Entity.set氏名カナ(entity.getKanaMeisho());
            被保険者台帳一覧表Entity.set氏名(entity.getMeisho());
            被保険者台帳一覧表Entity.set性別(entity.getSeibetsuCode());
            被保険者台帳一覧表Entity.set年齢(get年齢(entity, 識別対象));
            被保険者台帳一覧表Entity.set生年月日(entity.getSeinengappiYMD());
            被保険者台帳一覧表Entity.set行政区(get行政区(entity));
            被保険者台帳一覧表Entity.set住所(get住所(entity));
            被保険者台帳一覧表Entity.set郵便番号(識別対象.to個人().get住所().get郵便番号());
            被保険者台帳一覧表Entity.set識別コード(entity.getShikibetsuCode());
            被保険者台帳一覧表Entity.set世帯コード(entity.getSetaiCode());
            被保険者台帳一覧表Entity.set状態区分(entity.getState());
            被保険者台帳一覧表Entity.set資格区分(get資格区分(entity));
            被保険者台帳一覧表Entity.set生保(get生保(entity));
            被保険者台帳一覧表Entity.set老福(get老福(entity));
            被保険者台帳一覧表Entity.set備考(RString.EMPTY);
            被保険者台帳一覧表Entity.setリストNO(リストNO++);
            被保険者台帳一覧表List.add(被保険者台帳一覧表Entity);
        }
        return 被保険者台帳一覧表List;
    }

    private RString get住所(HihokenshaDaichoSakuseiEntity entity) {
        RString 住所 = RString.EMPTY;
        if (entity.getJusho() != null && entity.getJusho().toString().length() >= 60) {
            住所 = new RString(StringUtils.substring(entity.getJusho().toString(), 0, LENGTH_60));
        } else {
            住所 = entity.getJusho();
        }
        return 住所;
    }

    private GyoseikuCode get行政区(HihokenshaDaichoSakuseiEntity entity) {
        GyoseikuCode 行政区 = GyoseikuCode.EMPTY;
        if (entity.getGyoseikuCode() != null && entity.getGyoseikuCode().toString().length() >= LENGTH_50) {
            行政区 = new GyoseikuCode(StringUtils.substring(entity.getGyoseikuCode().toString(), 0, 50));
        } else {
            行政区 = entity.getGyoseikuCode();
        }
        return 行政区;
    }

    @Transaction
    private UaFt200FindShikibetsuTaishoEntity get宛名識別対象取得(HihokenshaDaichoSakuseiEntity entity) {
        iIkkatsuSakuseiMapper = mapperProvider.create(IIkkatsuSakuseiMapper.class);
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key.set識別コード(entity.getShikibetsuCode());
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        IkkatsuSakuseiMybatisParameter pram = IkkatsuSakuseiMybatisParameter.
                createSelectByKeyParam(RString.EMPTY, LasdecCode.EMPTY, ShikibetsuCode.EMPTY,
                        new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()));
        return iIkkatsuSakuseiMapper.get識別対象(pram);
    }

    private RString get年齢(HihokenshaDaichoSakuseiEntity entity, IShikibetsuTaisho 識別対象) {
        FlexibleDate 生年月日 = new FlexibleDate(entity.getSeinengappiYMD());
        JuminJotai 住民状態 = 識別対象.to個人().get住民状態();
        FlexibleDate 消除異動年月日 = FlexibleDate.EMPTY;
        if (住民状態.equals(JuminJotai.死亡者)) {
            消除異動年月日 = 識別対象.to個人().get消除異動年月日();
        } else {
            消除異動年月日 = FlexibleDate.MAX;
        }
        AgeCalculator ageCalculator = new AgeCalculator(DateOfBirthFactory.createInstance(生年月日), 住民状態,
                消除異動年月日, AgeArrivalDay.当日, FlexibleDate.getNowDate());
        return ageCalculator.get年齢();
    }

    private RString get生保(HihokenshaDaichoSakuseiEntity entity) {
        List<FlexibleDate> 受給開始日List = entity.get生活保護情報Entity().get受給開始日();
        List<FlexibleDate> 受給廃止日List = entity.get生活保護情報Entity().get受給廃止日();
        RString 生保 = RString.EMPTY;
        int index = 受給開始日List.size() - 1;
        if (受給開始日List.size() > 1 && 受給廃止日List.get(index).equals(FlexibleDate.EMPTY)) {
            生保 = MARU;
        }
        return 生保;
    }

    private RString get老福(HihokenshaDaichoSakuseiEntity entity) {
        List<FlexibleDate> 受給開始日List = entity.get老齢福祉情報Entity().get老齢福祉受給開始日();
        List<FlexibleDate> 受給終了日List = entity.get老齢福祉情報Entity().get老齢福祉受給終了日();
        RString 老福 = RString.EMPTY;
        int index = 受給開始日List.size() - 1;
        if (受給開始日List.size() > 1 && 受給終了日List.get(index).equals(FlexibleDate.EMPTY)) {
            老福 = MARU;
        }
        return 老福;
    }

    private RString get資格区分(HihokenshaDaichoSakuseiEntity entity) {
        RString 資格区分 = RString.EMPTY;
        RString 被保険者区分コード = 被保険者台帳管理Dac.selectByHihokenshaNo(entity.getHihokenshaNo()).getHihokennshaKubunCode();
        if (被保険者区分コード.equals(被保険者区分コード_1)) {
            資格区分 = 資格区分_1号;
        } else if (被保険者区分コード.equals(被保険者区分コード_2)) {
            資格区分 = 資格区分_2号;
        }
        return 資格区分;
    }
}
