package jp.co.ndensan.reams.db.dba.service.core.hihokenshadaichokoshin;

import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshadaichokoshin.SaishinIdohiDataEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshadaichokoshin.ShikakuIdoTaishoshaEntity;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.nenreitotatsushikakuido.INenreitotatsuShikakuIdoRelateMapper;
import jp.co.ndensan.reams.db.dbz.service.core.hihokenshadaicho.HihokenshaShikakuShutokuManager;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBACodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakukubun.ShikakuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.core.hihokenshanotsukiban.HihokenshanotsukibanFinder;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.AgeCalculator;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth._DateOfBirth;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.AgeArrivalDay;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ６５歳年齢到達資格異動被保険者台帳更新のビジネスクラスです。
 *
 * @reamsid_L DBA-0330-030 xuyue
 */
public class HihokenshaDaichoKoshin {

    private final MapperProvider mapperProvider;
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
     * 被保険者台帳管理の更新を行います。
     *
     * @param entity 資格異動対象者
     * @return 被保険者台帳管理テーブルのエンティティ
     */
    public DbT1001HihokenshaDaichoEntity updHihokenshaDaicho(ShikakuIdoTaishoshaEntity entity) {

        SaishinIdohiDataEntity saishinIdohiDataEntity = new SaishinIdohiDataEntity();

        AgeCalculator ageCalculator = new AgeCalculator(
                new _DateOfBirth(entity.get生年月日()), JuminJotai.住民, FlexibleDate.MAX, AgeArrivalDay.前日);
        FlexibleDate age = ageCalculator.get年齢到達日(AGE_65);

        INenreitotatsuShikakuIdoRelateMapper mapper = mapperProvider.create(INenreitotatsuShikakuIdoRelateMapper.class);
        DbT1001HihokenshaDaichoEntity dbT1001HihokenshaDaichoEntity = mapper
                .select被保険者台帳管理By論理削除フラグAnd識別コード(entity.get識別コード());
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
            return insertEn;
        }

        if (dbT1001HihokenshaDaichoEntity != null && JuminJotai.住民.コード().equals(entity.get住民状態コード())) {
            return updateHihokenshaDaicho(entity, saishinIdohiDataEntity, age);
        }

        if ((dbT1001HihokenshaDaichoEntity != null && (JuminJotai.住登外.コード().equals(entity.get住民状態コード())
                || JuminJotai.転出者.コード().equals(entity.get住民状態コード())
                || JuminJotai.消除者.コード().equals(entity.get住民状態コード())))
                && (saishinIdohiDataEntity.get資格取得年月日() != null
                && (saishinIdohiDataEntity.get資格喪失年月日() == null || saishinIdohiDataEntity.get資格喪失年月日().isEmpty())
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
            return insertEn;
        }
        return null;
    }

    /**
     * 年齢到達条件の更新を行います。
     *
     * @param 開始日 入力．バッチパラメータ．開始日
     * @param 終了日 入力．バッチパラメータ．終了日
     * @param entity 処理日付管理マスタ
     * @return DbT7022ShoriDateKanriEntity 処理日付管理マスタ
     */
    public DbT7022ShoriDateKanriEntity updNenreitotatsuJoken(FlexibleDate 開始日, FlexibleDate 終了日, DbT7022ShoriDateKanriEntity entity) {

        if (entity == null) {
            entity = new DbT7022ShoriDateKanriEntity();
            entity.setSubGyomuCode(SubGyomuCode.DBA介護資格);
            entity.setShichosonCode(市町村コード);
            entity.setShoriName(処理名);
            entity.setShoriEdaban(処理枝番);
            entity.setNendo(年度);
            entity.setNendoNaiRenban(年度内連番);
            entity.setKijunYMD(終了日.plusDay(1));
            entity.setTaishoKaishiYMD(開始日);
            entity.setTaishoShuryoYMD(終了日);

        } else {
            entity.setKijunYMD(終了日.plusDay(1));
            entity.setTaishoKaishiYMD(開始日);
            entity.setTaishoShuryoYMD(終了日);
        }
        return entity;
    }

    private DbT1001HihokenshaDaichoEntity updateHihokenshaDaicho(ShikakuIdoTaishoshaEntity entity,
            SaishinIdohiDataEntity saishinIdohiDataEntity, FlexibleDate age) {
        枝番 = hihokenshaManager.getSaidaiEdaban(saishinIdohiDataEntity.get被保険者番号(), age);
        if (saishinIdohiDataEntity.get資格取得年月日() != null
                && saishinIdohiDataEntity.get資格喪失年月日() != null && !saishinIdohiDataEntity.get資格喪失年月日().isEmpty()
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
            return insertEn;
        } else if (saishinIdohiDataEntity.get資格取得年月日() != null
                && (saishinIdohiDataEntity.get資格喪失年月日() == null || saishinIdohiDataEntity.get資格喪失年月日().isEmpty())
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
            insertEn.setShikakuHenkoTodokedeYMD(age);
            insertEn.setKoikinaiJushochiTokureiFlag(saishinIdohiDataEntity.get広域内住所地特例フラグ());
            insertEn.setKoikinaiTokureiSochimotoShichosonCode(saishinIdohiDataEntity.get広住特措置元市町村コード());
            insertEn.setKyuShichosonCode(saishinIdohiDataEntity.get旧市町村コード());
            insertEn.setLogicalDeletedFlag(false);
            return insertEn;
        }
        return null;
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
