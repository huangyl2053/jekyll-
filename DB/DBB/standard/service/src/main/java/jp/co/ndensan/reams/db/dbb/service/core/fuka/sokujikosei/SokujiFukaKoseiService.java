/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.fuka.sokujikosei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.fukakeisan.CalculateChoteiParameter;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.fukakeisan.FukaKokyoParameter;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.fukakeisan.KoseiShoriParameter;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.fukakeisan.KoseiShoriResult;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.fukakeisan.KoseiShorikoaResult;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.fukakeisan.KoseiZengoChoshuHoho;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.fukakeisan.KoseiZengoFuka;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.fukakeisan.NendobunFukaList;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJohoBuilder;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankaiList;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.MonthShichoson;
import jp.co.ndensan.reams.db.dbb.business.core.sokujikosei.SokujiFukaKoseiParameter;
import jp.co.ndensan.reams.db.dbb.business.core.sokujikosei.SokujiFukaKoseiResult;
import jp.co.ndensan.reams.db.dbb.business.core.sokujikosei.YokunenFukaKoseiResult;
import jp.co.ndensan.reams.db.dbb.definition.core.choteijiyu.ChoteiJiyuCode;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.KozaKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.ShokkenKubun;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.fukajoho.FukaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.sokujikosei.ISokujiFukaKoseiMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbb.service.core.fuka.fukakeisan.FukaKeisan;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HokenryoDankaiSettings;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HokenryoRank;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT2001ChoshuHohoDac;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.RoreiFukushiNenkinJukyusha;
import jp.co.ndensan.reams.db.dbz.business.core.basic.SetaiinShotoku;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.seikatsuhogojukyusha.SeikatsuHogoJukyusha;
import jp.co.ndensan.reams.db.dbz.business.core.kyokaisogaitosha.kyokaisogaitosha.KyokaisoGaitosha;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.hihokensha.seikatsuhogojukyusha.SeikatsuHogoJukyushaRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.kyokaisogaitosha.KyokaisoGaitoshaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7006RoreiFukushiNenkinJukyushaDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.db.dbz.service.core.setaiinshotokujoho.SetaiinShotokuJohoFinder;
import jp.co.ndensan.reams.ua.uax.business.core.koza.Koza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ua.uax.service.core.koza.KozaManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.CountedItem;
import jp.co.ndensan.reams.uz.uza.util.Saiban;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 即時賦課更正のビジネスクラスです。
 *
 * @reamsid_L DBB-0660-020 cuilin
 */
public class SokujiFukaKoseiService {

    private final MapperProvider mapperProvider;
    private final DbT7022ShoriDateKanriDac 処理状況Dac;
    private final DbT2001ChoshuHohoDac 介護徴収方法Dac;
    private final DbT1001HihokenshaDaichoDac 被保険者台帳管理Dac;
    private final DbT7006RoreiFukushiNenkinJukyushaDac 老齢福祉年金受給者Dac;
    private static final RString MSG_1 = new RString("徴収方法の情報　");
    private static final RString MSG_2 = new RString("賦課年度：");
    private static final RString MSG_3 = new RString("　被保険者番号：");
    private static final RString MSG_4 = new RString("被保険者の資格情報");
    private static final RString KEY_FUKANENDO = new RString("fukaNendo");
    private static final RString KEY_MAXCHOTEINENDO = new RString("choteiNendo");
    private static final RString KEY_TSUCHISHONO = new RString("tsuchishoNo");
    private static final RString KEY_SHIKIBETSUCODE = new RString("shikibetsuCode");
    private static final RString KEY_HIHOKENSHANO = new RString("hihokenshaNo");
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_3 = 3;
    private static final int INT_4 = 4;
    private static final int INT_5 = 5;
    private static final RString 汎用キー_通知書番号 = new RString("通知書番号");
    private static final RString ゼロ_0000 = new RString("0000");

    /**
     * コンストラクタです
     */
    public SokujiFukaKoseiService() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.処理状況Dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
        this.介護徴収方法Dac = InstanceProvider.create(DbT2001ChoshuHohoDac.class);
        this.被保険者台帳管理Dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
        this.老齢福祉年金受給者Dac = InstanceProvider.create(DbT7006RoreiFukushiNenkinJukyushaDac.class);
    }

    /**
     * コンストラクタです。
     *
     * @param mapperProvider MapperProvider
     * @param 処理状況Dac DbT7022ShoriDateKanriDac
     * @param 介護徴収方法Dac DbT2001ChoshuHohoDac
     * @param 被保険者台帳管理Dac DbT1001HihokenshaDaichoDac
     * @param 老齢福祉年金受給者Dac DbT7006RoreiFukushiNenkinJukyushaDac
     */
    SokujiFukaKoseiService(MapperProvider mapperProvider,
            DbT7022ShoriDateKanriDac 処理状況Dac,
            DbT2001ChoshuHohoDac 介護徴収方法Dac,
            DbT1001HihokenshaDaichoDac 被保険者台帳管理Dac,
            DbT7006RoreiFukushiNenkinJukyushaDac 老齢福祉年金受給者Dac) {
        this.mapperProvider = mapperProvider;
        this.処理状況Dac = 処理状況Dac;
        this.介護徴収方法Dac = 介護徴収方法Dac;
        this.被保険者台帳管理Dac = 被保険者台帳管理Dac;
        this.老齢福祉年金受給者Dac = 老齢福祉年金受給者Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SokujiFukaKoseiService}のインスタンスを返します。
     *
     * @return SokujiFukaKoseiService
     */
    public static SokujiFukaKoseiService createInstance() {
        return InstanceProvider.create(SokujiFukaKoseiService.class);
    }

    /**
     * 即時賦課更正処理メソッド
     *
     * @param param SokujiFukaKoseiParameter
     * @return SokujiFukaKoseiResult
     */
    public SokujiFukaKoseiResult do更正(SokujiFukaKoseiParameter param) {
        SokujiFukaKoseiResult result = new SokujiFukaKoseiResult();
        DbT7022ShoriDateKanriEntity entity = 処理状況Dac
                .selectKaijun(param.get賦課年度(), ShoriName.本算定賦課.get名称());
        if (entity == null || entity.getKijunTimestamp() == null || entity.getKijunTimestamp().isEmpty()) {
            KoseiShoriResult 仮算定の更正 = get仮算定の更正(param);
            result.set更正前後賦課のリスト(仮算定の更正.get更正前後賦課のリスト());
            result.set更正前後徴収方法(仮算定の更正.get更正前後徴収方法());
            result.set資格の情報(仮算定の更正.get資格の情報());
            result.set本算定処理済フラグ(false);
        } else {
            KoseiShoriResult 本算定の更正 = get本算定の更正(param);
            result.set更正前後賦課のリスト(本算定の更正.get更正前後賦課のリスト());
            result.set更正前後徴収方法(本算定の更正.get更正前後徴収方法());
            result.set資格の情報(本算定の更正.get資格の情報());
            result.set本算定処理済フラグ(true);
        }
        return result;
    }

    /**
     * 翌年度賦課更正処理メソッド
     *
     * @param 賦課年度 FlexibleYear
     * @param 被保険者番号 HihokenshaNo
     * @return YokunenFukaKoseiResult
     */
    public YokunenFukaKoseiResult do翌年度更正(FlexibleYear 賦課年度, HihokenshaNo 被保険者番号) {
        ISokujiFukaKoseiMapper mapper = mapperProvider.create(ISokujiFukaKoseiMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put(KEY_FUKANENDO.toString(), 賦課年度);
        map.put(KEY_HIHOKENSHANO.toString(), 被保険者番号);
        FukaJohoRelateEntity fukaEntity = mapper.get賦課の情報(map);
        List<KoseiZengoFuka> 更正前後賦課のリスト = new ArrayList<>();
        YokunenFukaKoseiResult result = new YokunenFukaKoseiResult();
        FukaJoho 賦課の情報;
        ChoshuHoho 徴収方法の情報 = null;
        if (fukaEntity != null) {
            賦課の情報 = new FukaJoho(fukaEntity);
            徴収方法の情報 = get徴収方法(賦課年度, 被保険者番号);
        } else {
            HihokenshaDaicho 資格の情報 = get資格の情報(被保険者番号);

            FlexibleYear 調定年度 = new FlexibleYear(DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度,
                    RDate.getNowDate(), SubGyomuCode.DBB介護賦課));
            CountedItem saiban = Saiban.get(SubGyomuCode.DBB介護賦課, 汎用キー_通知書番号, FlexibleDate.getNowDate().getNendo());
            TsuchishoNo 通知書番号 = create通知書番号(被保険者番号.getColumnValue(), saiban.nextString().trim());
            FukaJoho fukaJoho = new FukaJoho(調定年度, 賦課年度, 通知書番号, 0);
            賦課の情報 = get根拠反映後賦課の情報(fukaJoho, 資格の情報, 賦課年度);
            FukaJohoBuilder builder = 賦課の情報.createBuilderForEdit();
            builder.set調定事由1(ChoteiJiyuCode.仮徴収額の変更.getコード())
                    .set調定事由2(RString.EMPTY)
                    .set調定事由3(RString.EMPTY)
                    .set調定事由4(RString.EMPTY);
            賦課の情報 = builder.build();
            DbT2001ChoshuHohoEntity choshuHohoEntity = 介護徴収方法Dac.select(賦課年度, 被保険者番号);
            if (choshuHohoEntity != null) {
                徴収方法の情報 = new ChoshuHoho(choshuHohoEntity);
            }
        }
        NendobunFukaList 年度分賦課リスト = new NendobunFukaList();
        年度分賦課リスト.set賦課年度(賦課年度);
        年度分賦課リスト.set通知書番号(賦課の情報.get通知書番号());
        年度分賦課リスト.set賦課期日(賦課の情報.get賦課期日());
        年度分賦課リスト.set現年度(賦課の情報);
        年度分賦課リスト.set最新賦課の情報(賦課の情報);
        年度分賦課リスト.setHas過年度賦課(false);

        KoseiZengoFuka 更正前後賦課 = new KoseiZengoFuka();
        更正前後賦課.set更正前(年度分賦課リスト);
        更正前後賦課.set更正後(年度分賦課リスト);
        更正前後賦課のリスト.add(更正前後賦課);

        KoseiZengoChoshuHoho 更正前後徴収方法 = new KoseiZengoChoshuHoho();
        更正前後徴収方法.set賦課年度(賦課年度);
        更正前後徴収方法.set被保険者番号(被保険者番号);
        更正前後徴収方法.set更正前(徴収方法の情報);
        更正前後徴収方法.set更正後(徴収方法の情報);
        更正前後徴収方法.setHasChanged(false);

        result.set更正前後賦課のリスト(更正前後賦課のリスト);
        result.set更正前後徴収方法(更正前後徴収方法);
        return result;
    }

    private TsuchishoNo create通知書番号(RString 被保険者番号, RString 枝番号) {
        RStringBuilder rst = new RStringBuilder();
        rst.append(ゼロ_0000);
        rst.append(被保険者番号);
        rst.append(枝番号.padZeroToLeft(INT_2));
        return new TsuchishoNo(rst.toRString());
    }

    private KoseiShoriResult get本算定の更正(SokujiFukaKoseiParameter param) {
        ISokujiFukaKoseiMapper mapper = mapperProvider.create(ISokujiFukaKoseiMapper.class);
        Map<String, Object> mapParam = new HashMap<>();
        mapParam.put(KEY_FUKANENDO.toString(), param.get賦課年度());
        mapParam.put(KEY_MAXCHOTEINENDO.toString(), param.get賦課年度().plusYear(INT_5));
        mapParam.put(KEY_HIHOKENSHANO.toString(), param.get被保険者番号());
        List<FukaJohoRelateEntity> 賦課の情報 = mapper.get賦課の情報By被保険者番号(mapParam);
        List<NendobunFukaList> 年度分賦課リストList = create年度分賦課リストコレクション(賦課の情報, param.get賦課年度());

        ChoshuHoho 徴収方法の情報 = get徴収方法(param.get賦課年度(), param.get被保険者番号());

        if (param.get更正後減免額() == null) {
            KoseiShoriParameter koseiParam = new KoseiShoriParameter();
            koseiParam.set賦課年度(param.get賦課年度());
            koseiParam.set通知書番号(param.get通知書番号());
            koseiParam.set年度分賦課リスト(年度分賦課リストList);
            koseiParam.set徴収方法の情報(徴収方法の情報);
            List<DbT1001HihokenshaDaichoEntity> daichoEntity = 被保険者台帳管理Dac.get被保険者台帳管理情報(param.get被保険者番号());
            List<HihokenshaDaicho> 資格の情報 = new ArrayList<>();
            for (int i = 0; i < daichoEntity.size(); i++) {
                資格の情報.add(new HihokenshaDaicho(daichoEntity.get(i)));
            }
            koseiParam.set資格の情報リスト(資格の情報);

            ShikibetsuCode 識別コード = 資格の情報.get(0).get識別コード();
            Map<String, Object> map = new HashMap<>();
            map.put(KEY_SHIKIBETSUCODE.toString(), 識別コード);
            SetaiinShotokuJohoFinder setai = SetaiinShotokuJohoFinder.createInstance();
            List<SetaiinShotoku> 世帯員所得情報list
                    = setai.get世帯員所得情報(識別コード, param.get賦課年度(), null);
            koseiParam.set世帯員所得情報List(世帯員所得情報list);

            List<SeikatsuHogoJukyushaRelateEntity> 生保の情報リスト = mapper.get生保の情報(map);
            List<SeikatsuHogoJukyusha> 生保の情報 = new ArrayList<>();
            for (SeikatsuHogoJukyushaRelateEntity entity : 生保の情報リスト) {
                生保の情報.add(new SeikatsuHogoJukyusha(entity));
            }
            koseiParam.set生保の情報のリスト(生保の情報);

            List<DbT7006RoreiFukushiNenkinJukyushaEntity> 老福の情報のリスト
                    = 老齢福祉年金受給者Dac.selectByShikibetsuCode(識別コード);
            List<RoreiFukushiNenkinJukyusha> 老福の情報 = new ArrayList<>();
            for (DbT7006RoreiFukushiNenkinJukyushaEntity entity : 老福の情報のリスト) {
                老福の情報.add(new RoreiFukushiNenkinJukyusha(entity));
            }
            koseiParam.set老福の情報のリスト(老福の情報);

            map.put(KEY_HIHOKENSHANO.toString(), 資格の情報.get(0).get被保険者番号());
            List<KyokaisoGaitoshaEntity> 境界層の情報リスト = mapper.get境界層の情報(map);
            List<KyokaisoGaitosha> 境界層の情報 = new ArrayList<>();
            for (KyokaisoGaitoshaEntity entity : 境界層の情報リスト) {
                境界層の情報.add(new KyokaisoGaitosha(entity));
            }
            koseiParam.set境界層の情報のリスト(境界層の情報);

            KozaManager manager = KozaManager.createInstance();
            IKozaSearchKey searchKey = new KozaSearchKeyBuilder().setサブ業務コード(SubGyomuCode.DBB介護賦課)
                    .set基準日(FlexibleDate.getNowDate()).set識別コード(識別コード).build();
            List<Koza> 口座の情報 = manager.get口座(searchKey);
            koseiParam.set口座のリスト(口座の情報);

            HokenryoDankaiList 保険料段階List = HokenryoDankaiSettings.createInstance().get保険料段階ListIn(param.get賦課年度());
            koseiParam.set保険料段階リスト(保険料段階List);

            FukaKeisan fukaKeisan = FukaKeisan.createInstance();
            return fukaKeisan.do全履歴更正計算(koseiParam);
        } else {
            Decimal 減免前介護保険料_年額 = param.get更正後年度分賦課リスト().get最新賦課の情報().get減免前介護保険料_年額();
            Decimal 年額保険料 = (減免前介護保険料_年額 == null ? Decimal.ZERO : 減免前介護保険料_年額)
                    .subtract(param.get更正後減免額());
            CalculateChoteiParameter calParam = new CalculateChoteiParameter();
            calParam.set賦課年度(param.get賦課年度());
            calParam.set調定日時(YMDHMS.now());
            calParam.set年度分賦課リスト_更正前(param.get更正後年度分賦課リスト());
            calParam.set徴収方法の情報_更正前(param.get更正後徴収方法());
            calParam.set年額保険料(年額保険料);
            calParam.set資格の情報(param.get資格の情報());

            FukaKeisan fukaKeisan = FukaKeisan.createInstance();
            KoseiShorikoaResult 調定計算 = fukaKeisan.do調定計算(calParam);

            List<KoseiZengoFuka> 更正前後賦課リスト = new ArrayList<>();
            KoseiZengoFuka 更正前後賦課 = new KoseiZengoFuka();
            更正前後賦課.set賦課年度(param.get賦課年度());
            更正前後賦課.set通知書番号(param.get通知書番号());
            更正前後賦課.set更正前(param.get更正後年度分賦課リスト());
            更正前後賦課.set更正後(調定計算.get年度分賦課リスト_更正後());
            更正前後賦課リスト.add(更正前後賦課);

            KoseiZengoChoshuHoho 更正前後徴収方法 = new KoseiZengoChoshuHoho();
            更正前後徴収方法.set賦課年度(param.get賦課年度());
            更正前後徴収方法.set被保険者番号(param.get被保険者番号());
            更正前後徴収方法.set更正前(param.get更正後徴収方法());
            更正前後徴収方法.set更正後(調定計算.get徴収方法の情報_更正後());

            KoseiShoriResult result = new KoseiShoriResult();
            result.set更正前後賦課のリスト(更正前後賦課リスト);
            result.set更正前後徴収方法(更正前後徴収方法);
            List<HihokenshaDaicho> 資格の情報リスト = new ArrayList<>();
            資格の情報リスト.add(調定計算.get資格の情報());
            result.set資格の情報(資格の情報リスト);
            return result;
        }
    }

    private KoseiShoriResult get仮算定の更正(SokujiFukaKoseiParameter param) {
        HihokenshaDaicho 資格の情報 = get資格の情報(param.get被保険者番号());
        ChoshuHoho 徴収方法の情報 = get徴収方法(param.get賦課年度(), param.get被保険者番号());

        ISokujiFukaKoseiMapper mapper = mapperProvider.create(ISokujiFukaKoseiMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put(KEY_FUKANENDO.toString(), param.get賦課年度());
        map.put(KEY_TSUCHISHONO.toString(), param.get通知書番号());
        FukaJohoRelateEntity 賦課の情報 = mapper.get賦課の情報By通知書番号(map);
        FukaJoho 更正前賦課の情報 = new FukaJoho(賦課の情報);
        FukaJoho 根拠反映後賦課の情報 = get根拠反映後賦課の情報(更正前賦課の情報, 資格の情報, param.get賦課年度());

        KoseiZengoFuka 更正前後賦課 = new KoseiZengoFuka();
        更正前後賦課.set更正前(create年度分賦課リスト(更正前賦課の情報));
        更正前後賦課.set賦課年度(param.get賦課年度());
        更正前後賦課.set通知書番号(param.get通知書番号());
        if (is変化有り(更正前賦課の情報, 根拠反映後賦課の情報)) {
            FukaJohoBuilder builder = 根拠反映後賦課の情報.createBuilderForEdit();
            builder.set履歴番号(更正前賦課の情報.get履歴番号() + INT_1)
                    .set調定事由1(ChoteiJiyuCode.仮徴収額の変更.getコード())
                    .set調定事由2(RString.EMPTY)
                    .set調定事由3(RString.EMPTY)
                    .set調定事由4(RString.EMPTY);
            根拠反映後賦課の情報 = builder.build();
            更正前後賦課.set更正後(create年度分賦課リスト(根拠反映後賦課の情報));
            更正前後賦課.setHasChanged(true);
        } else {
            更正前後賦課.set更正後(create年度分賦課リスト(根拠反映後賦課の情報));
            更正前後賦課.setHasChanged(false);
        }
        List<KoseiZengoFuka> 更正前後賦課のリスト = new ArrayList<>();
        更正前後賦課のリスト.add(更正前後賦課);
        KoseiZengoChoshuHoho 更正前後徴収方法 = new KoseiZengoChoshuHoho();
        更正前後徴収方法.set賦課年度(param.get賦課年度());
        更正前後徴収方法.set被保険者番号(param.get被保険者番号());

        更正前後徴収方法.set更正前(徴収方法の情報);

        KoseiShoriResult result = new KoseiShoriResult();
        result.set更正前後賦課のリスト(更正前後賦課のリスト);
        result.set更正前後徴収方法(更正前後徴収方法);
        List<HihokenshaDaicho> 資格の情報リスト = new ArrayList<>();
        資格の情報リスト.add(資格の情報);
        result.set資格の情報(資格の情報リスト);
        return result;
    }

    private List<NendobunFukaList> create年度分賦課リストコレクション(List<FukaJohoRelateEntity> 賦課の情報,
            FlexibleYear 賦課年度) {
        List<NendobunFukaList> 年度分賦課リスト = new ArrayList<>();
        List<TsuchishoNo> 通知書番号リスト = new ArrayList<>();
        for (FukaJohoRelateEntity entity : 賦課の情報) {
            通知書番号リスト.add(entity.get介護賦課Entity().getTsuchishoNo());
        }
        Set<TsuchishoNo> 重複排除セット = new HashSet<>(通知書番号リスト);
        List<TsuchishoNo> 重複排除リスト = new ArrayList<>(重複排除セット);
        for (TsuchishoNo 番号 : 重複排除リスト) {
            NendobunFukaList fukaList = new NendobunFukaList();
            fukaList.set賦課年度(賦課年度);
            fukaList.set通知書番号(番号);
            boolean flg = false;
            for (FukaJohoRelateEntity entity : 賦課の情報) {
                if (番号.equals(entity.get介護賦課Entity().getTsuchishoNo())) {
                    if (entity.get介護賦課Entity().getChoteiNendo().equals(賦課年度)) {
                        fukaList.set現年度(new FukaJoho(entity));
                    } else if (entity.get介護賦課Entity().getChoteiNendo().equals(賦課年度.plusYear(INT_1))) {
                        fukaList.set過年度1(new FukaJoho(entity));
                        flg = true;
                    } else if (entity.get介護賦課Entity().getChoteiNendo().equals(賦課年度.plusYear(INT_2))) {
                        fukaList.set過年度2(new FukaJoho(entity));
                        flg = true;
                    } else if (entity.get介護賦課Entity().getChoteiNendo().equals(賦課年度.plusYear(INT_3))) {
                        fukaList.set過年度3(new FukaJoho(entity));
                        flg = true;
                    } else if (entity.get介護賦課Entity().getChoteiNendo().equals(賦課年度.plusYear(INT_4))) {
                        fukaList.set過年度4(new FukaJoho(entity));
                        flg = true;
                    } else if (entity.get介護賦課Entity().getChoteiNendo().equals(賦課年度.plusYear(INT_5))) {
                        fukaList.set過年度5(new FukaJoho(entity));
                        flg = true;
                    }
                }
            }
            fukaList.set最新賦課の情報(get最新の賦課(fukaList));
            fukaList.set賦課期日(fukaList.get現年度().get賦課期日());
            fukaList.setHas過年度賦課(flg);
            年度分賦課リスト.add(fukaList);
        }
        return 年度分賦課リスト;

    }

    private FukaJoho get最新の賦課(NendobunFukaList 年度分賦課リスト) {
        if (年度分賦課リスト.get過年度5() != null) {
            return 年度分賦課リスト.get過年度5();
        } else if (年度分賦課リスト.get過年度4() != null) {
            return 年度分賦課リスト.get過年度4();
        } else if (年度分賦課リスト.get過年度3() != null) {
            return 年度分賦課リスト.get過年度3();
        } else if (年度分賦課リスト.get過年度2() != null) {
            return 年度分賦課リスト.get過年度2();
        } else if (年度分賦課リスト.get過年度1() != null) {
            return 年度分賦課リスト.get過年度1();
        } else if (年度分賦課リスト.get現年度() != null) {
            return 年度分賦課リスト.get現年度();
        }
        return null;
    }

    private ChoshuHoho get徴収方法(FlexibleYear 賦課年度, HihokenshaNo 被保険者番号) {
        DbT2001ChoshuHohoEntity 徴収方法の情報 = 介護徴収方法Dac.select(賦課年度, 被保険者番号);
        if (徴収方法の情報 == null) {
            RStringBuilder rsb = new RStringBuilder();
            rsb.append(MSG_1).append(MSG_2).append(賦課年度).append(MSG_3).append(被保険者番号.getColumnValue());
            throw new ApplicationException(UrErrorMessages.対象データなし_追加メッセージあり.getMessage()
                    .replace(rsb.toString()).evaluate());
        }
        return new ChoshuHoho(徴収方法の情報);
    }

    private HihokenshaDaicho get資格の情報(HihokenshaNo 被保険者番号) {
        DbT1001HihokenshaDaichoEntity 資格の情報 = 被保険者台帳管理Dac.get被保険者証資格証発行情報(被保険者番号);
        if (資格の情報 == null) {
            RStringBuilder rsb = new RStringBuilder();
            rsb.append(MSG_4).append(MSG_3).append(被保険者番号.getColumnValue());
            throw new ApplicationException(UrErrorMessages.対象データなし_追加メッセージあり.getMessage()
                    .replace(rsb.toString()).evaluate());
        }
        return new HihokenshaDaicho(資格の情報);
    }

    private FukaJoho get根拠反映後賦課の情報(FukaJoho 更正前賦課の情報, HihokenshaDaicho 資格の情報, FlexibleYear 賦課年度) {
        Map<String, Object> map = new HashMap<>();
        FukaKokyoParameter kokyoParam = new FukaKokyoParameter();
        kokyoParam.set賦課の情報_設定前(更正前賦課の情報);
        kokyoParam.set資格の情報(資格の情報);

        ShikibetsuCode 識別コード = 資格の情報.get識別コード();
        map.put(KEY_SHIKIBETSUCODE.toString(), 識別コード);
        ISokujiFukaKoseiMapper mapper = mapperProvider.create(ISokujiFukaKoseiMapper.class);
        List<SeikatsuHogoJukyushaRelateEntity> 生保の情報リスト = mapper.get生保の情報(map);
        List<SeikatsuHogoJukyusha> 生保の情報 = new ArrayList<>();
        for (SeikatsuHogoJukyushaRelateEntity entity : 生保の情報リスト) {
            生保の情報.add(new SeikatsuHogoJukyusha(entity));
        }
        kokyoParam.set生保の情報のリスト(生保の情報);

        List<DbT7006RoreiFukushiNenkinJukyushaEntity> 老福の情報のリスト
                = 老齢福祉年金受給者Dac.selectByShikibetsuCode(識別コード);
        List<RoreiFukushiNenkinJukyusha> 老福の情報 = new ArrayList<>();
        for (DbT7006RoreiFukushiNenkinJukyushaEntity entity : 老福の情報のリスト) {
            老福の情報.add(new RoreiFukushiNenkinJukyusha(entity));
        }
        kokyoParam.set老福の情報のリスト(老福の情報);
        map.put(KEY_HIHOKENSHANO.toString(), 資格の情報.get被保険者番号());
        List<KyokaisoGaitoshaEntity> 境界層の情報リスト = mapper.get境界層の情報(map);
        List<KyokaisoGaitosha> 境界層の情報 = new ArrayList<>();
        for (KyokaisoGaitoshaEntity entity : 境界層の情報リスト) {
            境界層の情報.add(new KyokaisoGaitosha(entity));
        }
        kokyoParam.set境界層の情報のリスト(境界層の情報);
        kokyoParam.set調定日時(YMDHMS.now());
        FukaKeisan fukaKeisan = FukaKeisan.createInstance();
        FukaJoho 根拠反映後賦課の情報 = fukaKeisan.reflect賦課根拠(kokyoParam);

        FukaJohoBuilder builder = 根拠反映後賦課の情報.createBuilderForEdit();
        if (!is普徴期別金額あり(根拠反映後賦課の情報)) {
            builder.set口座区分(KozaKubun.現金納付.getコード());
        } else {
            if (!get口座の情報(識別コード).isEmpty()) {
                builder.set口座区分(KozaKubun.口座振替.getコード());
            } else {
                builder.set口座区分(KozaKubun.現金納付.getコード());
            }
        }
        builder.set職権区分(ShokkenKubun.非該当.getコード());
        HokenryoRank rank = InstanceProvider.create(HokenryoRank.class);
        List<HihokenshaDaicho> 資格 = new ArrayList<>();
        資格.add(資格の情報);
        List<MonthShichoson> 月別ランク情報 = rank.get月別ランク情報(資格, 賦課年度);
        builder.set賦課市町村コード(get最終月の市町村コード(月別ランク情報));

        根拠反映後賦課の情報 = builder.build();
        return 根拠反映後賦課の情報;
    }

    private List<Koza> get口座の情報(ShikibetsuCode 識別コード) {
        KozaManager manager = KozaManager.createInstance();
        IKozaSearchKey searchKey = new KozaSearchKeyBuilder().setサブ業務コード(SubGyomuCode.DBB介護賦課)
                .set基準日(FlexibleDate.getNowDate()).set識別コード(識別コード).build();
        List<Koza> 口座の情報 = manager.get口座(searchKey);
        if (口座の情報 == null) {
            return Collections.emptyList();
        }
        return 口座の情報;
    }

    private boolean is普徴期別金額あり(FukaJoho 賦課の情報) {
        return is金額あり(賦課の情報.get普徴期別金額01())
                || is金額あり(賦課の情報.get普徴期別金額02())
                || is金額あり(賦課の情報.get普徴期別金額03())
                || is金額あり(賦課の情報.get普徴期別金額04())
                || is金額あり(賦課の情報.get普徴期別金額05())
                || is金額あり(賦課の情報.get普徴期別金額06())
                || is金額あり(賦課の情報.get普徴期別金額07())
                || is金額あり(賦課の情報.get普徴期別金額08())
                || is金額あり(賦課の情報.get普徴期別金額09())
                || is金額あり(賦課の情報.get普徴期別金額10())
                || is金額あり(賦課の情報.get普徴期別金額11())
                || is金額あり(賦課の情報.get普徴期別金額12())
                || is金額あり(賦課の情報.get普徴期別金額13())
                || is金額あり(賦課の情報.get普徴期別金額14());
    }

    private boolean is金額あり(Decimal 金額) {
        return 金額 != null && !Decimal.ZERO.equals(金額);
    }

    private LasdecCode get最終月の市町村コード(List<MonthShichoson> 月別ランク情報) {
        LasdecCode 市町村コード_3月 = get市町村コード(月別ランク情報, Tsuki._3月.getコード());
        if (市町村コード_3月 != null) {
            return 市町村コード_3月;
        }
        LasdecCode 市町村コード_2月 = get市町村コード(月別ランク情報, Tsuki._2月.getコード());
        if (市町村コード_2月 != null) {
            return 市町村コード_2月;
        }
        LasdecCode 市町村コード_1月 = get市町村コード(月別ランク情報, Tsuki._1月.getコード());
        if (市町村コード_1月 != null) {
            return 市町村コード_1月;
        }
        LasdecCode 市町村コード_12月 = get市町村コード(月別ランク情報, Tsuki._12月.getコード());
        if (市町村コード_12月 != null) {
            return 市町村コード_12月;
        }
        LasdecCode 市町村コード_11月 = get市町村コード(月別ランク情報, Tsuki._11月.getコード());
        if (市町村コード_11月 != null) {
            return 市町村コード_11月;
        }
        LasdecCode 市町村コード_10月 = get市町村コード(月別ランク情報, Tsuki._10月.getコード());
        if (市町村コード_10月 != null) {
            return 市町村コード_10月;
        }
        LasdecCode 市町村コード_9月 = get市町村コード(月別ランク情報, Tsuki._9月.getコード());
        if (市町村コード_9月 != null) {
            return 市町村コード_9月;
        }
        LasdecCode 市町村コード_8月 = get市町村コード(月別ランク情報, Tsuki._8月.getコード());
        if (市町村コード_8月 != null) {
            return 市町村コード_8月;
        }
        LasdecCode 市町村コード_7月 = get市町村コード(月別ランク情報, Tsuki._7月.getコード());
        if (市町村コード_7月 != null) {
            return 市町村コード_7月;
        }
        LasdecCode 市町村コード_6月 = get市町村コード(月別ランク情報, Tsuki._6月.getコード());
        if (市町村コード_6月 != null) {
            return 市町村コード_6月;
        }
        LasdecCode 市町村コード_5月 = get市町村コード(月別ランク情報, Tsuki._5月.getコード());
        if (市町村コード_5月 != null) {
            return 市町村コード_5月;
        }
        LasdecCode 市町村コード_4月 = get市町村コード(月別ランク情報, Tsuki._4月.getコード());
        if (市町村コード_4月 != null) {
            return 市町村コード_4月;
        }
        return null;
    }

    private LasdecCode get市町村コード(List<MonthShichoson> 月別ランク情報, RString 月) {
        for (MonthShichoson choson : 月別ランク情報) {
            if (choson.get市町村コード() != null && !choson.get市町村コード().getColumnValue().isEmpty()
                    && 月.equals(choson.get月().getコード())) {
                return choson.get市町村コード();
            }
        }
        return null;
    }

    private NendobunFukaList create年度分賦課リスト(FukaJoho 賦課の情報) {
        NendobunFukaList 年度分賦課リスト = new NendobunFukaList();
        年度分賦課リスト.set賦課年度(賦課の情報.get賦課年度());
        年度分賦課リスト.set通知書番号(賦課の情報.get通知書番号());
        年度分賦課リスト.set賦課期日(賦課の情報.get賦課期日());
        年度分賦課リスト.set現年度(賦課の情報);
        年度分賦課リスト.set最新賦課の情報(賦課の情報);
        年度分賦課リスト.setHas過年度賦課(false);
        return 年度分賦課リスト;

    }

    private boolean is変化有り(FukaJoho 更正前, FukaJoho 更正後) {
        return is変化有り1(更正前, 更正後)
                || is変化有り2(更正前, 更正後)
                || is変化有り3(更正前, 更正後)
                || is変化有り4(更正前, 更正後);
    }

    private boolean is変化有り1(FukaJoho 更正前, FukaJoho 更正後) {
        return isTsuchishoNo変更(更正前.get通知書番号(), 更正後.get通知書番号())
                || isHihokenshaNo変更(更正前.get被保険者番号(), 更正後.get被保険者番号())
                || isShikibetsuCode変更(更正前.get識別コード(), 更正後.get識別コード())
                || isSetaiCode変更(更正前.get世帯コード(), 更正後.get世帯コード())
                || isInt変更(更正前.get世帯員数(), 更正後.get世帯員数())
                || isFlexibleDate変更(更正前.get資格取得日(), 更正後.get資格取得日())
                || isRString変更(更正前.get資格取得事由(), 更正後.get資格取得事由())
                || isFlexibleDate変更(更正前.get資格喪失日(), 更正後.get資格喪失日())
                || isRString変更(更正前.get資格喪失事由(), 更正後.get資格喪失事由())
                || isRString変更(更正前.get生活保護扶助種類(), 更正後.get生活保護扶助種類())
                || isFlexibleDate変更(更正前.get生保開始日(), 更正後.get生保開始日())
                || isFlexibleDate変更(更正前.get生保廃止日(), 更正後.get生保廃止日())
                || isFlexibleDate変更(更正前.get老年開始日(), 更正後.get老年開始日())
                || isFlexibleDate変更(更正前.get老年廃止日(), 更正後.get老年廃止日())
                || isFlexibleDate変更(更正前.get賦課期日(), 更正後.get賦課期日())
                || isRString変更(更正前.get課税区分(), 更正後.get課税区分())
                || isRString変更(更正前.get世帯課税区分(), 更正後.get世帯課税区分())
                || isDecimal変更(更正前.get合計所得金額(), 更正後.get合計所得金額());
    }

    private boolean is変化有り2(FukaJoho 更正前, FukaJoho 更正後) {
        return isDecimal変更(更正前.get公的年金収入額(), 更正後.get公的年金収入額())
                || isRString変更(更正前.get保険料段階(), 更正後.get保険料段階())
                || isRString変更(更正前.get保険料算定段階1(), 更正後.get保険料算定段階1())
                || isDecimal変更(更正前.get算定年額保険料1(), 更正後.get算定年額保険料1())
                || isFlexibleYearMonth変更(更正前.get月割開始年月1(), 更正後.get月割開始年月1())
                || isFlexibleYearMonth変更(更正前.get月割終了年月1(), 更正後.get月割終了年月1())
                || isRString変更(更正前.get保険料算定段階2(), 更正後.get保険料算定段階2())
                || isDecimal変更(更正前.get算定年額保険料2(), 更正後.get算定年額保険料2())
                || isFlexibleYearMonth変更(更正前.get月割開始年月2(), 更正後.get月割開始年月2())
                || isFlexibleYearMonth変更(更正前.get月割終了年月2(), 更正後.get月割終了年月2())
                || isDecimal変更(更正前.get減免前介護保険料_年額(), 更正後.get減免前介護保険料_年額())
                || isDecimal変更(更正前.get減免額(), 更正後.get減免額())
                || isDecimal変更(更正前.get確定介護保険料_年額(), 更正後.get確定介護保険料_年額())
                || isRString変更(更正前.get保険料段階_仮算定時(), 更正後.get保険料段階_仮算定時())
                || isRString変更(更正前.get口座区分(), 更正後.get口座区分());
    }

    private boolean is変化有り3(FukaJoho 更正前, FukaJoho 更正後) {
        return isRString変更(更正前.get境界層区分(), 更正後.get境界層区分())
                || isRString変更(更正前.get職権区分(), 更正後.get職権区分())
                || isLasdecCode変更(更正前.get賦課市町村コード(), 更正後.get賦課市町村コード())
                || isDecimal変更(更正前.get特徴歳出還付額(), 更正後.get特徴歳出還付額())
                || isDecimal変更(更正前.get普徴歳出還付額(), 更正後.get普徴歳出還付額())
                || isDecimal変更(更正前.get特徴期別金額01(), 更正後.get特徴期別金額01())
                || isDecimal変更(更正前.get特徴期別金額02(), 更正後.get特徴期別金額02())
                || isDecimal変更(更正前.get特徴期別金額03(), 更正後.get特徴期別金額03())
                || isDecimal変更(更正前.get特徴期別金額04(), 更正後.get特徴期別金額04())
                || isDecimal変更(更正前.get特徴期別金額05(), 更正後.get特徴期別金額05())
                || isDecimal変更(更正前.get特徴期別金額06(), 更正後.get特徴期別金額06());
    }

    private boolean is変化有り4(FukaJoho 更正前, FukaJoho 更正後) {
        return isDecimal変更(更正前.get普徴期別金額01(), 更正後.get普徴期別金額01())
                || isDecimal変更(更正前.get普徴期別金額02(), 更正後.get普徴期別金額02())
                || isDecimal変更(更正前.get普徴期別金額03(), 更正後.get普徴期別金額03())
                || isDecimal変更(更正前.get普徴期別金額04(), 更正後.get普徴期別金額04())
                || isDecimal変更(更正前.get普徴期別金額05(), 更正後.get普徴期別金額05())
                || isDecimal変更(更正前.get普徴期別金額06(), 更正後.get普徴期別金額06())
                || isDecimal変更(更正前.get普徴期別金額07(), 更正後.get普徴期別金額07())
                || isDecimal変更(更正前.get普徴期別金額08(), 更正後.get普徴期別金額08())
                || isDecimal変更(更正前.get普徴期別金額09(), 更正後.get普徴期別金額09())
                || isDecimal変更(更正前.get普徴期別金額10(), 更正後.get普徴期別金額10())
                || isDecimal変更(更正前.get普徴期別金額11(), 更正後.get普徴期別金額11())
                || isDecimal変更(更正前.get普徴期別金額12(), 更正後.get普徴期別金額12())
                || isDecimal変更(更正前.get普徴期別金額13(), 更正後.get普徴期別金額13())
                || isDecimal変更(更正前.get普徴期別金額14(), 更正後.get普徴期別金額14());
    }

    private boolean isTsuchishoNo変更(TsuchishoNo 更正前, TsuchishoNo 更正後) {
        if (更正前 == null) {
            更正前 = TsuchishoNo.EMPTY;
        }
        if (更正後 == null) {
            更正後 = TsuchishoNo.EMPTY;
        }
        return !更正後.equals(更正前);
    }

    private boolean isHihokenshaNo変更(HihokenshaNo 更正前, HihokenshaNo 更正後) {
        if (更正前 == null) {
            更正前 = HihokenshaNo.EMPTY;
        }
        if (更正後 == null) {
            更正後 = HihokenshaNo.EMPTY;
        }
        return !更正後.equals(更正前);
    }

    private boolean isShikibetsuCode変更(ShikibetsuCode 更正前, ShikibetsuCode 更正後) {
        if (更正前 == null) {
            更正前 = ShikibetsuCode.EMPTY;
        }
        if (更正後 == null) {
            更正後 = ShikibetsuCode.EMPTY;
        }
        return !更正後.equals(更正前);
    }

    private boolean isSetaiCode変更(SetaiCode 更正前, SetaiCode 更正後) {
        if (更正前 == null) {
            更正前 = SetaiCode.EMPTY;
        }
        if (更正後 == null) {
            更正後 = SetaiCode.EMPTY;
        }
        return !更正後.equals(更正前);
    }

    private boolean isInt変更(int 更正前, int 更正後) {
        return 更正前 != 更正後;
    }

    private boolean isFlexibleDate変更(FlexibleDate 更正前, FlexibleDate 更正後) {
        if (更正前 == null) {
            更正前 = FlexibleDate.EMPTY;
        }
        if (更正後 == null) {
            更正後 = FlexibleDate.EMPTY;
        }
        return !更正後.equals(更正前);
    }

    private boolean isRString変更(RString 更正前, RString 更正後) {
        if (更正前 == null) {
            更正前 = RString.EMPTY;
        }
        if (更正後 == null) {
            更正後 = RString.EMPTY;
        }
        return !更正後.equals(更正前);
    }

    private boolean isFlexibleYearMonth変更(FlexibleYearMonth 更正前, FlexibleYearMonth 更正後) {
        if (更正前 == null) {
            更正前 = FlexibleYearMonth.EMPTY;
        }
        if (更正後 == null) {
            更正後 = FlexibleYearMonth.EMPTY;
        }
        return !更正後.equals(更正前);
    }

    private boolean isLasdecCode変更(LasdecCode 更正前, LasdecCode 更正後) {
        if (更正前 == null) {
            更正前 = LasdecCode.EMPTY;
        }
        if (更正後 == null) {
            更正後 = LasdecCode.EMPTY;
        }
        return !更正後.equals(更正前);
    }

    private boolean isDecimal変更(Decimal 更正前, Decimal 更正後) {
        if (更正前 == null) {
            更正前 = Decimal.ZERO;
        }
        if (更正後 == null) {
            更正後 = Decimal.ZERO;
        }
        return !更正後.equals(更正前);
    }
}
