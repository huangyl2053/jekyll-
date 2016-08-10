/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.hihokenshadaichokoshin;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.batchprm.nenreitotatsushikakuido.NenreitotatsuShikakuIdoBatchFlowParameter;
import jp.co.ndensan.reams.db.dba.definition.processprm.nenreitotatsushikakuido.HihokenshaDaichoKoshinProcessParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshadaichokoshin.SaishinIdohiDataEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshadaichokoshin.ShikakuIdoTaishoshaEntity;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.nenreitotatsushikakuido.INenreitotatsuShikakuIdoRelateMapper;
import jp.co.ndensan.reams.db.dba.service.core.hihokenshadaicho.HihokenshaShikakuShutokuManager;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBACodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakukubun.ShikakuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1002TekiyoJogaishaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1003TashichosonJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1009ShikakuShutokuJogaishaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1010TennyushutsuHoryuTaishoshaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1002TekiyoJogaishaDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1003TashichosonJushochiTokureiDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1009ShikakuShutokuJogaishaDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1010TennyushutsuHoryuTaishoshaDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.core.hihokenshanotsukiban.HihokenshanotsukibanFinder;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.AgeCalculator;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth._DateOfBirth;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.AgeArrivalDay;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * ６５歳年齢到達資格異動被保険者台帳更新のビジネスクラスです。
 *
 * @reamsid_L DBA-0330-030 xuyue
 */
public class HihokenshaDaichoKoshin {

    private final MapperProvider mapperProvider;
    private final DbT1010TennyushutsuHoryuTaishoshaDac dac1010Dac;
    private final DbT1003TashichosonJushochiTokureiDac dbt1003;
    private final DbT1002TekiyoJogaishaDac dbt1002Dac;
    private final DbT1009ShikakuShutokuJogaishaDac dbt1009Dac;
    private final DbT1001HihokenshaDaichoDac dbT1001Dac;
    private final DbT7022ShoriDateKanriDac db7022Dac;
    private final HihokenshaShikakuShutokuManager hihokenshaManager;
    private static final LasdecCode 市町村コード = new LasdecCode("000000");
    private static final RString 処理名 = new RString("年齢到達抽出処理");
    private static final RString 処理枝番 = new RString("00");
    private static final FlexibleYear 年度 = new FlexibleYear("0000");
    private static final RString 年度内連番 = new RString("00");
    private RString 枝番;
    private static final int AGE_65 = 65;
    private static final RString 住所地特例フラグ_1 = new RString("1");

    /**
     * コンストラクタです。
     */
    public HihokenshaDaichoKoshin() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dac1010Dac = InstanceProvider.create(DbT1010TennyushutsuHoryuTaishoshaDac.class);
        this.dbt1002Dac = InstanceProvider.create(DbT1002TekiyoJogaishaDac.class);
        this.dbt1003 = InstanceProvider.create(DbT1003TashichosonJushochiTokureiDac.class);
        this.dbt1009Dac = InstanceProvider.create(DbT1009ShikakuShutokuJogaishaDac.class);
        this.dbT1001Dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
        this.db7022Dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
        hihokenshaManager = HihokenshaShikakuShutokuManager.createInstance();
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link HihokenshaDaichoKoshin}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link HihokenshaDaichoKoshin}のインスタンス
     */
    public static HihokenshaDaichoKoshin createInstance() {
        return InstanceProvider.create(HihokenshaDaichoKoshin.class);
    }

    /**
     * 通常運用時（スケジューラ機能による毎朝一日１回の起動）、バッチ内で抽出条件を生成します。
     *
     * @return 処理日付管理マスタ
     */
    public DbT7022ShoriDateKanriEntity selectバッチ内で抽出条件() {
        DbT7022ShoriDateKanriEntity entity = db7022Dac.selectByKey(SubGyomuCode.DBA介護資格, 市町村コード, 処理名, 処理枝番, 年度, 年度内連番);
        return entity;
    }

    /**
     * 資格異動対象者の取得と被保険者台帳の更新を行います。
     *
     * @param parameter 資格異動対象者情報取得のパラメータ
     */
    @Transaction
    public void 資格異動対象者の取得と被保険者台帳の更新(HihokenshaDaichoKoshinProcessParameter parameter) {
        INenreitotatsuShikakuIdoRelateMapper mapper = mapperProvider.create(INenreitotatsuShikakuIdoRelateMapper.class);

        FlexibleDate 年齢到達期間開始日 = parameter.get開始日().minusYear(AGE_65).plusDay(1);
        FlexibleDate 年齢到達期間終了日 = parameter.get終了日().minusYear(AGE_65).plusDay(1);

        ShikibetsuTaishoPSMSearchKeyBuilder key = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        List<JuminShubetsu> juminShubetsuList = new ArrayList<>();
        juminShubetsuList.add(JuminShubetsu.日本人);
        juminShubetsuList.add(JuminShubetsu.外国人);
        juminShubetsuList.add(JuminShubetsu.住登外個人_日本人);
        juminShubetsuList.add(JuminShubetsu.住登外個人_外国人);
        key.set住民種別(juminShubetsuList);
        List<JuminJotai> juminJotaiList = new ArrayList<>();
        juminJotaiList.add(JuminJotai.住民);
        juminJotaiList.add(JuminJotai.住登外);
        juminJotaiList.add(JuminJotai.消除者);
        juminJotaiList.add(JuminJotai.転出者);
        key.set住民状態(juminJotaiList);
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = key.build();

        List<ShikakuIdoTaishoshaEntity> 資格異動対象者List = mapper.select資格異動対象者(parameter
                .toAtenaMybatisParameter(shikibetsuTaishoPSMSearchKey, 年齢到達期間開始日, 年齢到達期間終了日));

        List<DbT1003TashichosonJushochiTokureiEntity> 他市町村住所地特例List;
        List<DbT1002TekiyoJogaishaEntity> 適用除外者List;
        List<DbT1009ShikakuShutokuJogaishaEntity> 資格取得除外者List;
        List<DbT1010TennyushutsuHoryuTaishoshaEntity> 転入保留対象者List;

        for (ShikakuIdoTaishoshaEntity entity : 資格異動対象者List) {

            AgeCalculator ageCalculator = new AgeCalculator(new _DateOfBirth(entity.get生年月日()),
                    JuminJotai.住民, FlexibleDate.MAX, AgeArrivalDay.前日);
            FlexibleDate age = ageCalculator.get年齢到達日(AGE_65);

            他市町村住所地特例List = dbt1003.select他市町村住所地特例(entity.get識別コード(), age, false);
            if (!他市町村住所地特例List.isEmpty()) {
                continue;
            }

            適用除外者List = dbt1002Dac.select適用除外者(entity.get識別コード(), age, false);
            if (!適用除外者List.isEmpty()) {
                continue;
            }

            資格取得除外者List = dbt1009Dac.selectBy識別コード(entity.get識別コード());
            if (!資格取得除外者List.isEmpty()) {
                continue;
            }

            転入保留対象者List = dac1010Dac.selectBy識別コード(entity.get識別コード());
            if (!転入保留対象者List.isEmpty()) {
                continue;
            }
            updHihokenshaDaichoEntity(entity);
        }
    }

    /**
     * 被保険者台帳管理の更新を行います。
     *
     * @param entity 資格異動対象者
     */
    private void updHihokenshaDaichoEntity(ShikakuIdoTaishoshaEntity entity) {

        SaishinIdohiDataEntity saishinIdohiDataEntity = new SaishinIdohiDataEntity();

        AgeCalculator ageCalculator = new AgeCalculator(
                new _DateOfBirth(entity.get生年月日()), JuminJotai.住民, FlexibleDate.MAX, AgeArrivalDay.前日);
        FlexibleDate age = ageCalculator.get年齢到達日(AGE_65);

        DbT1001HihokenshaDaichoEntity dbT1001HihokenshaDaichoEntity = dbT1001Dac
                .select被保険者台帳管理By論理削除フラグAnd識別コード(false, entity.get識別コード().getColumnValue());
        if (dbT1001HihokenshaDaichoEntity != null) {
            saishinIdohiDataEntity = set最新異動日のデータEntity(dbT1001HihokenshaDaichoEntity);
        }

        if (dbT1001HihokenshaDaichoEntity == null && JuminJotai.住民.コード().equals(entity.get住民状態コード())) {
            HihokenshanotsukibanFinder finder = HihokenshanotsukibanFinder.createInstance();
            HihokenshaNo hihokenshaNo = finder.getHihokenshanotsukiban(entity.get識別コード());
            枝番 = hihokenshaManager.getSaidaiEdaban(hihokenshaNo, age);

            DbT1001HihokenshaDaichoEntity insertEn = new DbT1001HihokenshaDaichoEntity();
            insertEn.setHihokenshaNo(hihokenshaNo);
            insertEn.setIdoYMD(age);
            insertEn.setEdaNo(new RString("0001"));
            RString idoJiyuCode = CodeMaster.getCode(SubGyomuCode.DBA介護資格, DBACodeShubetsu.介護資格取得事由_被保険者.getコード(), new Code("02"),
                    new FlexibleDate(RDate.getNowDate().toDateString())).getコード().getColumnValue();
            insertEn.setIdoJiyuCode(idoJiyuCode);
            insertEn.setShichosonCode(entity.get現全国地方公共団体コード());
            insertEn.setShikibetsuCode(entity.get識別コード());
            insertEn.setShikakuShutokuJiyuCode(idoJiyuCode);
            insertEn.setShikakuShutokuYMD(age);
            insertEn.setShikakuShutokuTodokedeYMD(age);
            insertEn.setIchigoShikakuShutokuYMD(age);
            insertEn.setHihokennshaKubunCode(ShikakuKubun._１号.getコード());
            insertEn.setKyuShichosonCode(entity.get旧全国地方公共団体コード());
            insertEn.setLogicalDeletedFlag(false);
            dbT1001Dac.save(insertEn);
        }

        if (dbT1001HihokenshaDaichoEntity != null && JuminJotai.住民.コード().equals(entity.get住民状態コード())) {
            updateHihokenshaDaicho(entity, saishinIdohiDataEntity, age);
        }

        if ((dbT1001HihokenshaDaichoEntity != null && (JuminJotai.住登外.コード().equals(entity.get住民状態コード())
                || JuminJotai.転出者.コード().equals(entity.get住民状態コード())
                || JuminJotai.消除者.コード().equals(entity.get住民状態コード())))
                && (saishinIdohiDataEntity.get資格取得年月日() != null && saishinIdohiDataEntity.get資格喪失年月日() == null
                && saishinIdohiDataEntity.get被保険者区分コード().equals(HihokenshaKubunCode.第２号被保険者.getコード())
                && 住所地特例フラグ_1.equals(saishinIdohiDataEntity.get住所地特例フラグ()))) {

            枝番 = hihokenshaManager.getSaidaiEdaban(saishinIdohiDataEntity.get被保険者番号(), age);
            DbT1001HihokenshaDaichoEntity insertEn = new DbT1001HihokenshaDaichoEntity();
            insertEn.setHihokenshaNo(saishinIdohiDataEntity.get被保険者番号());
            insertEn.setIdoYMD(age);
            insertEn.setEdaNo(枝番);
            RString idoJiyuCode = CodeMaster.getCode(SubGyomuCode.DBA介護資格, DBACodeShubetsu.介護資格変更事由被保険者.getコード(), new Code("31"),
                    new FlexibleDate(RDate.getNowDate().toDateString())).getコード().getColumnValue();
            insertEn.setIdoJiyuCode(idoJiyuCode);
            insertEn.setShichosonCode(entity.get現全国地方公共団体コード());
            insertEn.setShikibetsuCode(entity.get識別コード());
            insertEn.setShikakuShutokuJiyuCode(saishinIdohiDataEntity.get資格取得事由コード());
            insertEn.setShikakuShutokuYMD(saishinIdohiDataEntity.get資格取得年月日());
            insertEn.setShikakuShutokuTodokedeYMD(saishinIdohiDataEntity.get資格取得届出年月日());
            insertEn.setIchigoShikakuShutokuYMD(age);
            insertEn.setHihokennshaKubunCode(ShikakuKubun._１号.getコード());
            insertEn.setShikakuHenkoJiyuCode(idoJiyuCode);
            insertEn.setShikakuHenkoYMD(age);
            insertEn.setShikakuHenkoTodokedeYMD(age);
            insertEn.setJushochitokureiTekiyoJiyuCode(saishinIdohiDataEntity.get住所地特例適用事由コード());
            insertEn.setJushochitokureiTekiyoYMD(saishinIdohiDataEntity.get適用年月日());
            insertEn.setJushochitokureiKaijoTodokedeYMD(saishinIdohiDataEntity.get適用届出年月日());
            insertEn.setJushochitokureiKaijoJiyuCode(saishinIdohiDataEntity.get住所地特例解除事由コード());
            insertEn.setJushochitokureiKaijoYMD(saishinIdohiDataEntity.get解除年月日());
            insertEn.setJushochitokureiKaijoTodokedeYMD(saishinIdohiDataEntity.get解除届出年月日());
            insertEn.setJushochiTokureiFlag(saishinIdohiDataEntity.get住所地特例フラグ());
            insertEn.setKoikinaiJushochiTokureiFlag(saishinIdohiDataEntity.get広域内住所地特例フラグ());
            insertEn.setKoikinaiTokureiSochimotoShichosonCode(saishinIdohiDataEntity.get広住特措置元市町村コード());
            insertEn.setKyuShichosonCode(saishinIdohiDataEntity.get旧市町村コード());
            insertEn.setLogicalDeletedFlag(false);
            dbT1001Dac.save(insertEn);
        }
    }

    /**
     * 年齢到達条件の更新を行います。
     *
     * @param param バッチパラメータ
     */
    @Transaction
    public void updNenreitotatsuJoken(NenreitotatsuShikakuIdoBatchFlowParameter param) {

        DbT7022ShoriDateKanriEntity entity = db7022Dac.selectByKey(SubGyomuCode.DBA介護資格, 市町村コード, 処理名, 処理枝番, 年度, 年度内連番);

        if (entity == null) {
            DbT7022ShoriDateKanriEntity dbt7022 = new DbT7022ShoriDateKanriEntity();
            dbt7022.setSubGyomuCode(SubGyomuCode.DBA介護資格);
            dbt7022.setShichosonCode(市町村コード);
            dbt7022.setShoriName(処理名);
            dbt7022.setShoriEdaban(処理枝番);
            dbt7022.setNendo(年度);
            dbt7022.setNendoNaiRenban(年度内連番);
            dbt7022.setKijunYMD(param.getShuryoYMD().plusDay(1));
            dbt7022.setTaishoKaishiYMD(param.getKaishiYMD());
            dbt7022.setTaishoShuryoYMD(param.getShuryoYMD());
            db7022Dac.save(dbt7022);

        } else {
            entity.setKijunYMD(param.getShuryoYMD().plusDay(1));
            entity.setTaishoKaishiYMD(param.getKaishiYMD());
            entity.setTaishoShuryoYMD(param.getShuryoYMD());
            db7022Dac.save(entity);
        }
    }

    private void updateHihokenshaDaicho(ShikakuIdoTaishoshaEntity entity, SaishinIdohiDataEntity saishinIdohiDataEntity, FlexibleDate age) {
        枝番 = hihokenshaManager.getSaidaiEdaban(saishinIdohiDataEntity.get被保険者番号(), age);
        if (saishinIdohiDataEntity.get資格取得年月日() != null && saishinIdohiDataEntity.get資格喪失年月日() != null
                && saishinIdohiDataEntity.get被保険者区分コード().equals(HihokenshaKubunCode.第２号被保険者.getコード())) {

            DbT1001HihokenshaDaichoEntity insertEn = new DbT1001HihokenshaDaichoEntity();
            insertEn.setHihokenshaNo(saishinIdohiDataEntity.get被保険者番号());
            insertEn.setIdoYMD(age);
            insertEn.setEdaNo(枝番);
            RString idoJiyuCode = CodeMaster.getCode(SubGyomuCode.DBA介護資格, DBACodeShubetsu.介護資格取得事由_被保険者.getコード(), new Code("02"),
                    new FlexibleDate(RDate.getNowDate().toDateString())).getコード().getColumnValue();
            insertEn.setIdoJiyuCode(idoJiyuCode);
            insertEn.setShichosonCode(entity.get現全国地方公共団体コード());
            insertEn.setShikibetsuCode(entity.get識別コード());
            insertEn.setShikakuShutokuJiyuCode(idoJiyuCode);
            insertEn.setShikakuShutokuYMD(age);
            insertEn.setShikakuShutokuTodokedeYMD(age);
            insertEn.setIchigoShikakuShutokuYMD(age);
            insertEn.setHihokennshaKubunCode(ShikakuKubun._１号.getコード());
            insertEn.setKyuShichosonCode(entity.get旧全国地方公共団体コード());
            insertEn.setLogicalDeletedFlag(false);
            dbT1001Dac.save(insertEn);
        } else if (saishinIdohiDataEntity.get資格取得年月日() != null && saishinIdohiDataEntity.get資格喪失年月日() == null
                && saishinIdohiDataEntity.get被保険者区分コード().equals(HihokenshaKubunCode.第２号被保険者.getコード())) {

            DbT1001HihokenshaDaichoEntity insertEn = new DbT1001HihokenshaDaichoEntity();
            insertEn.setHihokenshaNo(saishinIdohiDataEntity.get被保険者番号());
            insertEn.setIdoYMD(age);
            insertEn.setEdaNo(枝番);
            RString idoJiyuCode = CodeMaster.getCode(SubGyomuCode.DBA介護資格, DBACodeShubetsu.介護資格変更事由被保険者.getコード(), new Code("31"),
                    new FlexibleDate(RDate.getNowDate().toDateString())).getコード().getColumnValue();
            insertEn.setIdoJiyuCode(idoJiyuCode);
            insertEn.setShichosonCode(entity.get現全国地方公共団体コード());
            insertEn.setShikibetsuCode(entity.get識別コード());
            insertEn.setShikakuShutokuJiyuCode(saishinIdohiDataEntity.get資格取得事由コード());
            insertEn.setShikakuShutokuYMD(saishinIdohiDataEntity.get資格取得年月日());
            insertEn.setShikakuShutokuTodokedeYMD(saishinIdohiDataEntity.get資格取得届出年月日());
            insertEn.setIchigoShikakuShutokuYMD(age);
            insertEn.setHihokennshaKubunCode(ShikakuKubun._１号.getコード());
            insertEn.setShikakuHenkoJiyuCode(idoJiyuCode);
            insertEn.setShikakuHenkoYMD(age);
            insertEn.setKoikinaiJushochiTokureiFlag(saishinIdohiDataEntity.get広域内住所地特例フラグ());
            insertEn.setKoikinaiTokureiSochimotoShichosonCode(saishinIdohiDataEntity.get広住特措置元市町村コード());
            insertEn.setKyuShichosonCode(saishinIdohiDataEntity.get旧市町村コード());
            insertEn.setLogicalDeletedFlag(false);
            dbT1001Dac.save(insertEn);
        }
    }

    private SaishinIdohiDataEntity set最新異動日のデータEntity(DbT1001HihokenshaDaichoEntity dbT1001HihokenshaDaichoEntity) {
        SaishinIdohiDataEntity saishinIdohiDataEntity = new SaishinIdohiDataEntity();
        saishinIdohiDataEntity.set被保険者番号(dbT1001HihokenshaDaichoEntity.getHihokenshaNo());
        saishinIdohiDataEntity.set異動日(dbT1001HihokenshaDaichoEntity.getIdoYMD());
        saishinIdohiDataEntity.set枝番(dbT1001HihokenshaDaichoEntity.getEdaNo());
        saishinIdohiDataEntity.set異動事由コード(dbT1001HihokenshaDaichoEntity.getIdoJiyuCode());
        saishinIdohiDataEntity.set市町村コード(dbT1001HihokenshaDaichoEntity.getShichosonCode());
        saishinIdohiDataEntity.set識別コード(dbT1001HihokenshaDaichoEntity.getShikibetsuCode());
        saishinIdohiDataEntity.set資格取得事由コード(dbT1001HihokenshaDaichoEntity.getShikakuShutokuJiyuCode());
        saishinIdohiDataEntity.set資格取得年月日(dbT1001HihokenshaDaichoEntity.getShikakuShutokuYMD());
        saishinIdohiDataEntity.set資格取得届出年月日(dbT1001HihokenshaDaichoEntity.getShikakuShutokuTodokedeYMD());
        saishinIdohiDataEntity.set第1号資格取得年月日(dbT1001HihokenshaDaichoEntity.getIchigoShikakuShutokuYMD());
        saishinIdohiDataEntity.set被保険者区分コード(dbT1001HihokenshaDaichoEntity.getHihokennshaKubunCode());
        saishinIdohiDataEntity.set資格喪失事由コード(dbT1001HihokenshaDaichoEntity.getShikakuSoshitsuJiyuCode());
        saishinIdohiDataEntity.set資格喪失年月日(dbT1001HihokenshaDaichoEntity.getShikakuSoshitsuYMD());
        saishinIdohiDataEntity.set資格喪失届出年月日(dbT1001HihokenshaDaichoEntity.getShikakuSoshitsuTodokedeYMD());
        saishinIdohiDataEntity.set資格変更事由コード(dbT1001HihokenshaDaichoEntity.getShikakuHenkoJiyuCode());
        saishinIdohiDataEntity.set資格変更年月日(dbT1001HihokenshaDaichoEntity.getShikakuHenkoYMD());
        saishinIdohiDataEntity.set資格変更届出年月日(dbT1001HihokenshaDaichoEntity.getShikakuHenkoTodokedeYMD());
        saishinIdohiDataEntity.set住所地特例適用事由コード(dbT1001HihokenshaDaichoEntity.getJushochitokureiTekiyoJiyuCode());
        saishinIdohiDataEntity.set適用年月日(dbT1001HihokenshaDaichoEntity.getJushochitokureiTekiyoYMD());
        saishinIdohiDataEntity.set適用届出年月日(dbT1001HihokenshaDaichoEntity.getJushochitokureiTekiyoTodokedeYMD());
        saishinIdohiDataEntity.set住所地特例解除事由コード(dbT1001HihokenshaDaichoEntity.getJushochitokureiKaijoJiyuCode());
        saishinIdohiDataEntity.set解除年月日(dbT1001HihokenshaDaichoEntity.getJushochitokureiKaijoYMD());
        saishinIdohiDataEntity.set解除届出年月日(dbT1001HihokenshaDaichoEntity.getJushochitokureiKaijoTodokedeYMD());
        saishinIdohiDataEntity.set住所地特例フラグ(dbT1001HihokenshaDaichoEntity.getJushochiTokureiFlag());
        saishinIdohiDataEntity.set広域内住所地特例フラグ(dbT1001HihokenshaDaichoEntity.getKoikinaiJushochiTokureiFlag());
        saishinIdohiDataEntity.set広住特措置元市町村コード(dbT1001HihokenshaDaichoEntity.getKoikinaiTokureiSochimotoShichosonCode());
        saishinIdohiDataEntity.set旧市町村コード(dbT1001HihokenshaDaichoEntity.getKyuShichosonCode());

        return saishinIdohiDataEntity;
    }
}
