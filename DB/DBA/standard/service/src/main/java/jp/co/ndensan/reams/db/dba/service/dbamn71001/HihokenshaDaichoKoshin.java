/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.dbamn71001;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.batchprm.dbamn71001.Dbamn71001BatchFlowParameter;
import jp.co.ndensan.reams.db.dba.definition.core.shikakukubun.ShikakuKubun;
import jp.co.ndensan.reams.db.dba.entity.dbamn71001.SaishinIdohiDataEntity;
import jp.co.ndensan.reams.db.dba.entity.dbamn71001.ShikakuIdoTaishoshaEntity;
import jp.co.ndensan.reams.db.dba.service.core.hihokenshadaicho.HihokenshaShikakuShutokuManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.DBXCodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.db.dbz.service.core.hihokenshanotsukiban.HihokenshanotsukibanFinder;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.AgeCalculator;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth._DateOfBirth;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * ６５歳年齢到達資格異動被保険者台帳更新のビジネスクラスです。
 */
public class HihokenshaDaichoKoshin {

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

    /**
     * コンストラクタです。
     */
    public HihokenshaDaichoKoshin() {
        this.dbT1001Dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
        this.db7022Dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
        hihokenshaManager = HihokenshaShikakuShutokuManager.createInstance();
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link HihokenshaDaichoKoshin}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link HihokenshaDaichoKoshin}のインスタンス
     */
    public static HihokenshaDaichoKoshin createInstance() {
        return InstanceProvider.create(HihokenshaDaichoKoshin.class);

    }

    /**
     * 被保険者台帳管理の更新を行います。
     *
     * @param entityList 資格異動対象者List
     */
    @Transaction
    public void updHihokenshaDaicho(List<ShikakuIdoTaishoshaEntity> entityList) {

        for (ShikakuIdoTaishoshaEntity entity : entityList) {
            updHihokenshaDaichoEntity(entity);
        }
    }

    private void updHihokenshaDaichoEntity(ShikakuIdoTaishoshaEntity entity) {

        SaishinIdohiDataEntity saishinIdohiDataEntity = new SaishinIdohiDataEntity();

        // 65歳年齢到達日の取得  TODO QA コンストラクタと引数を確認  #73116
        AgeCalculator ageCalculator = new AgeCalculator(
                new _DateOfBirth(entity.get生年月日()), JuminJotai.toValue(entity.get住民状態コード()),
                FlexibleDate.MAX);
        FlexibleDate age = ageCalculator.get年齢到達日(AGE_65);

        DbT1001HihokenshaDaichoEntity dbT1001HihokenshaDaichoEntity = dbT1001Dac
                .select被保険者台帳管理By論理削除フラグAnd識別コード(false, entity.get識別コード().getColumnValue());
        if (dbT1001HihokenshaDaichoEntity != null) {
            saishinIdohiDataEntity = set最新異動日のデータEntity(dbT1001HihokenshaDaichoEntity);
        }

        // 検索結果が取得できない場合
        if (dbT1001HihokenshaDaichoEntity == null && JuminJotai.住民.toString().equals(entity.get住民状態コード().toString())) {
            HihokenshanotsukibanFinder finder = HihokenshanotsukibanFinder.createInstance();
            HihokenshaNo hihokenshaNo = finder.getHihokenshanotsukiban(entity.get識別コード());
            DbT1001HihokenshaDaichoEntity insertEn = new DbT1001HihokenshaDaichoEntity();
            insertEn.setHihokenshaNo(hihokenshaNo);
            insertEn.setIdoYMD(age);
            insertEn.setEdaNo(new RString("0001"));
            RString idoJiyuCode = CodeMaster.getCode(new CodeShubetsu(DBXCodeShubetsu.介護資格取得事由.toString()))
                    .get(0).getコード().getColumnValue();
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

        // 検索結果が取得できる場合
        if (dbT1001HihokenshaDaichoEntity != null && JuminJotai.住民.toString().equals(entity.get住民状態コード().toString())) {

            枝番 = hihokenshaManager.getSaidaiEdaban(saishinIdohiDataEntity.get被保険者番号(), age);
            if (saishinIdohiDataEntity.get資格取得年月日() != null && saishinIdohiDataEntity.get資格喪失年月日() != null
                    && saishinIdohiDataEntity.get被保険者区分コード().toString().equals(HihokenshaKubunCode.第２号被保険者.toString())) {

                DbT1001HihokenshaDaichoEntity insertEn = new DbT1001HihokenshaDaichoEntity();
                insertEn.setHihokenshaNo(saishinIdohiDataEntity.get被保険者番号());
                insertEn.setIdoYMD(age);
                insertEn.setEdaNo(枝番);
                RString idoJiyuCode = CodeMaster.getCode(new CodeShubetsu(DBXCodeShubetsu.介護資格取得事由.toString()))
                        .get(0).getコード().getColumnValue();
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
                    && saishinIdohiDataEntity.get被保険者区分コード().toString().equals(HihokenshaKubunCode.第２号被保険者.toString())) {

                DbT1001HihokenshaDaichoEntity insertEn = new DbT1001HihokenshaDaichoEntity();
                insertEn.setHihokenshaNo(saishinIdohiDataEntity.get被保険者番号());
                insertEn.setIdoYMD(age);
                insertEn.setEdaNo(枝番);
                RString idoJiyuCode = CodeMaster.getCode(new CodeShubetsu(DBXCodeShubetsu.介護資格変更事由.toString()))
                        .get(0).getコード().getColumnValue();
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

        if ((dbT1001HihokenshaDaichoEntity != null && (JuminJotai.住登外.toString().equals(entity.get住民状態コード().toString())
                || JuminJotai.転出者.toString().equals(entity.get住民状態コード().toString())
                || JuminJotai.消除者.toString().equals(entity.get住民状態コード().toString())))
                && (saishinIdohiDataEntity.get資格取得年月日() != null && saishinIdohiDataEntity.get資格喪失年月日() == null
                && saishinIdohiDataEntity.get被保険者区分コード().toString().equals(HihokenshaKubunCode.第２号被保険者.toString())
                && "1".equals(saishinIdohiDataEntity.get住所地特例フラグ().toString()))) {

            DbT1001HihokenshaDaichoEntity insertEn = new DbT1001HihokenshaDaichoEntity();
            insertEn.setHihokenshaNo(saishinIdohiDataEntity.get被保険者番号());
            insertEn.setIdoYMD(age);
            insertEn.setEdaNo(枝番);
            RString idoJiyuCode = CodeMaster.getCode(
                    new CodeShubetsu(DBXCodeShubetsu.介護資格変更事由.toString()))
                    .get(0).getコード().getColumnValue();
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
        }
    }

    /**
     * 年齢到達条件の更新を行います。
     *
     * @param param バッチパラメータ
     */
    @Transaction
    public void updNenreitotatsuJoken(Dbamn71001BatchFlowParameter param) {

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
