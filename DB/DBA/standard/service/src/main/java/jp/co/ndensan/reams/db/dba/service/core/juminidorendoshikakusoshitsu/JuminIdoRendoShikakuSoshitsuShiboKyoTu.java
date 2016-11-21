/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.juminidorendoshikakusoshitsu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.hihokenshadaicho.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dba.definition.core.juminidorendoshikakusoshitsu.NaiBushoRyouParamter;
import jp.co.ndensan.reams.db.dba.definition.core.juminidorendoshikakusoshitsu.StoreConfigParamter;
import jp.co.ndensan.reams.db.dba.definition.core.juminidorendoshikakusoshitsu.TemParamter;
import jp.co.ndensan.reams.db.dba.definition.core.juminrendo.JuminRendoFuseigo;
import jp.co.ndensan.reams.db.dba.entity.db.relate.juminidorendoshikakutoroku.JuminIdoRendoShikakuTorokuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaichoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.ShisetsuNyutaisho;
import jp.co.ndensan.reams.db.dbz.business.core.ShisetsuNyutaishoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.TashichosonJushochiTokurei;
import jp.co.ndensan.reams.db.dbz.business.core.TashichosonJushochiTokureiBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.TekiyoJogaisha;
import jp.co.ndensan.reams.db.dbz.business.core.TekiyoJogaishaBuilder;
import jp.co.ndensan.reams.db.dbz.definition.core.daichokubun.DaichoType;
import jp.co.ndensan.reams.db.dbz.definition.core.jogaiidojiyu.JogaiKaijoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuHenkoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakukubun.ShikakuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.tatokureiidojiyu.TatokureiKaijoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1002TekiyoJogaishaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1003TashichosonJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1002TekiyoJogaishaDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1003TashichosonJushochiTokureiDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1004ShisetsuNyutaishoDac;
import jp.co.ndensan.reams.db.dbz.service.core.hihokenshanotsukiban.HihokenshanotsukibanFinder;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.AgeCalculator;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.DateOfBirthFactory;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.IDateOfBirth;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * ビジネス設計_DBAMN00000_住民異動連動資格登録（転出・死亡・転入通知受理）のビジネスクラスです。
 *
 * @reamsid_L DBA-1410-013 houtianpeng
 */
public class JuminIdoRendoShikakuSoshitsuShiboKyoTu {

    private final DbT1002TekiyoJogaishaDac dbT1002Dac;
    private final DbT1003TashichosonJushochiTokureiDac dbT1003Dac;
    private final DbT1004ShisetsuNyutaishoDac dbT1004Dac;
    private final DbT1001HihokenshaDaichoDac dbT1001Dac;
    private final RString 直近 = new RString("1");
    private final RString 転出 = new RString("2");
    private final RString 不整合コード_9999 = new RString("9999");
    private final RString flag_OFF = new RString("0");
    private final RString flag_ON = new RString("1");

    /**
     * コンストラクタです。
     */
    public JuminIdoRendoShikakuSoshitsuShiboKyoTu() {
        this.dbT1002Dac = InstanceProvider.create(DbT1002TekiyoJogaishaDac.class);
        this.dbT1003Dac = InstanceProvider.create(DbT1003TashichosonJushochiTokureiDac.class);
        this.dbT1004Dac = InstanceProvider.create(DbT1004ShisetsuNyutaishoDac.class);
        this.dbT1001Dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param DbT1002TekiyoJogaishaDac dbT1002TDac
     * @param DbT1003TashichosonJushochiTokureiDac dbT1003Dac
     * @param DbT1004ShisetsuNyutaishoDac dbT1004Dac
     * @param DbT1001HihokenshaDaichoDac dbT1001Dac
     */
    JuminIdoRendoShikakuSoshitsuShiboKyoTu(
            DbT1002TekiyoJogaishaDac dbT1002TDac,
            DbT1003TashichosonJushochiTokureiDac dbT1003Dac,
            DbT1004ShisetsuNyutaishoDac dbT1004Dac,
            DbT1001HihokenshaDaichoDac dbT1001Dac) {
        this.dbT1002Dac = dbT1002TDac;
        this.dbT1003Dac = dbT1003Dac;
        this.dbT1004Dac = dbT1004Dac;
        this.dbT1001Dac = dbT1001Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link JuminIdoRendoTennyuManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link JuminIdoRendoShikakuSoshitsuShibo}のインスタンス
     */
    public static JuminIdoRendoShikakuSoshitsuShiboKyoTu createInstance() {
        return InstanceProvider.create(JuminIdoRendoShikakuSoshitsuShiboKyoTu.class);
    }

    /**
     * コンフィグ情報パラメータ格納。
     *
     * @return StoreConfigParamter
     */
    public StoreConfigParamter getStoreConfigParam() {

        StoreConfigParamter paramter = new StoreConfigParamter();
        RString 介護保険法施行日 = DbBusinessConfig.get(ConfigNameDBU.介護保険法情報_介護保険施行日,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        RString 第１号被保険者基準年齢 = DbBusinessConfig.get(ConfigNameDBU.年齢到達基準_第１号被保険者到達基準年齢,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        RString 第２号被保険者基準年齢 = DbBusinessConfig.get(ConfigNameDBU.年齢到達基準_第２号被保険者到達基準年齢,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        RString 合併区分 = DbBusinessConfig.get(ConfigNameDBU.合併情報管理_合併情報区分,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        paramter.set介護保険法施行日(new FlexibleDate(介護保険法施行日));
        paramter.set第１号被保険者基準年齢(第１号被保険者基準年齢);
        paramter.set第２号被保険者基準年齢(第２号被保険者基準年齢);
        paramter.set合併区分(合併区分);
        return paramter;
    }

    /**
     * 関連テーブルの検索。
     *
     * @param 住民異動情報 UaFt200FindShikibetsuTaishoEntity
     * @param 被保険者台帳 DbV1001HihokenshaDaichoEntity
     * @param entity JuminIdoRendoShikakuTorokuEntity
     */
    public void get関連テーブル(UaFt200FindShikibetsuTaishoEntity 住民異動情報, DbV1001HihokenshaDaichoEntity 被保険者台帳,
            JuminIdoRendoShikakuTorokuEntity entity) {

        getJogai(住民異動情報, 被保険者台帳, entity);
        getGetTaTokurei(住民異動情報, 被保険者台帳, entity);
        getGetShisetsu(住民異動情報, 被保険者台帳, entity);
        getHihokensyadaicho(住民異動情報, 被保険者台帳, entity);
    }

    /**
     * 被保台帳データがあり、直近データが取得中の場合の被保台帳の死亡処理を行う。
     *
     * @param naiBushoRyouParamter NaiBushoRyouParamter
     * @param entity JuminIdoRendoShikakuTorokuEntity
     * @param 住民異動情報 UaFt200FindShikibetsuTaishoEntity
     */
    @Transaction
    public void shiboHihodaichoShutokuChu(
            NaiBushoRyouParamter naiBushoRyouParamter,
            JuminIdoRendoShikakuTorokuEntity entity,
            UaFt200FindShikibetsuTaishoEntity 住民異動情報) {
        TemParamter temparamter = new TemParamter();
        List<DbT1001HihokenshaDaichoEntity> entityList = searchHihodaicho(entity, 直近);
        DbT1001HihokenshaDaichoEntity dbT1001Entity = new DbT1001HihokenshaDaichoEntity();
        if (entityList != null && !entityList.isEmpty()) {
            dbT1001Entity = entityList.get(0);
        }
        if (被保台帳取得中死亡処理_65歳未到達者に作成されている(naiBushoRyouParamter, entity, entityList)) {
            return;
        }
        被保台帳取得中死亡処理_２号資格者の年齢到達被保台帳作成(dbT1001Entity, naiBushoRyouParamter, 住民異動情報, entity);
        if (HihokenshaKubunCode.第２号被保険者.getコード().equals(dbT1001Entity.getHihokennshaKubunCode())) {
            temparamter.setTmp1号資格取得日(naiBushoRyouParamter.get到達日_65歳());
            temparamter.setTmp被保険者区分(HihokenshaKubunCode.第１号被保険者.getコード());
        } else {
            temparamter.setTmp1号資格取得日(dbT1001Entity.getIchigoShikakuShutokuYMD());
            temparamter.setTmp被保険者区分(dbT1001Entity.getHihokennshaKubunCode());
        }
        DbT1001HihokenshaDaichoEntity hihokenshaDaicho = 被保台帳取得中死亡処理_喪失_死亡被保取得中(dbT1001Entity, naiBushoRyouParamter, 住民異動情報,
                temparamter, entity);
        if (flag_ON.equals(hihokenshaDaicho.getJushochiTokureiFlag())) {
            戻り値の編集(entity, JuminRendoFuseigo.住特_喪失不能_転出日不整合.getコード(), RString.EMPTY,
                    entityList, entity.get適用除外者台帳EntityList(),
                    entity.get他市町村住所地特例EntityList(), entity.get介護保険施設入退所EntityList());
            return;
        }
        if (nullToMin(hihokenshaDaicho.getShikakuSoshitsuYMD()).isBefore(nullToMin(hihokenshaDaicho.getShikakuShutokuYMD()))) {
            戻り値の編集(entity, JuminRendoFuseigo.転出_喪失不能_資格取得日_資格喪失日_不整合.getコード(), RString.EMPTY,
                    entityList, entity.get適用除外者台帳EntityList(),
                    entity.get他市町村住所地特例EntityList(), entity.get介護保険施設入退所EntityList());
            return;
        }
        dbT1001Dac.save(hihokenshaDaicho);
        戻り値の編集(entity, RString.EMPTY, RString.EMPTY, entity.get被保険者台帳EntityList(),
                entity.get適用除外者台帳EntityList(), entity.get他市町村住所地特例EntityList(),
                entity.get介護保険施設入退所EntityList());
    }

    private DbT1001HihokenshaDaichoEntity 被保台帳取得中死亡処理_喪失_死亡被保取得中(DbT1001HihokenshaDaichoEntity dbT1001Entity,
            NaiBushoRyouParamter naiBushoRyouParamter,
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            TemParamter temparamter,
            JuminIdoRendoShikakuTorokuEntity entity) {
        RString 枝番 = getHihokensyadaichoEdaNo(entity, dbT1001Entity.getShikibetsuCode(), naiBushoRyouParamter.get消除異動日翌日());
        HihokenshaDaicho hihokenshaDaicho = new HihokenshaDaicho(new HihokenshaNo(dbT1001Entity.getShikibetsuCode().value()),
                naiBushoRyouParamter.get消除異動日翌日(),
                枝番);
        HihokenshaDaichoBuilder builder = hihokenshaDaicho.createBuilderForEdit();
        builder.set異動事由コード(ShikakuSoshitsuJiyu.死亡.getコード());
        builder.set市町村コード(dbT1001Entity.getShichosonCode());
        builder.set識別コード(住民異動情報.getShikibetsuCode());
        builder.set資格取得事由コード(dbT1001Entity.getShikakuShutokuJiyuCode());
        builder.set資格取得年月日(dbT1001Entity.getShikakuShutokuYMD());
        builder.set資格取得届出年月日(dbT1001Entity.getShikakuShutokuTodokedeYMD());
        builder.set第1号資格取得年月日(temparamter.getTmp1号資格取得日());
        builder.set被保険者区分コード(temparamter.getTmp被保険者区分());
        builder.set資格喪失事由コード(ShikakuSoshitsuJiyu.死亡.getコード());
        builder.set資格喪失年月日(naiBushoRyouParamter.get消除異動日翌日());
        builder.set資格喪失届出年月日(住民異動情報.getShojoTodokedeYMD());
        builder.set資格変更事由コード(RString.EMPTY);
        builder.set資格変更年月日(FlexibleDate.EMPTY);
        builder.set資格変更届出年月日(FlexibleDate.EMPTY);
        builder.set住所地特例適用事由コード(RString.EMPTY);
        builder.set適用年月日(FlexibleDate.EMPTY);
        builder.set適用届出年月日(FlexibleDate.EMPTY);
        builder.set住所地特例解除事由コード(RString.EMPTY);
        builder.set解除年月日(FlexibleDate.EMPTY);
        builder.set解除届出年月日(FlexibleDate.EMPTY);
        builder.set住所地特例フラグ(flag_OFF);
        builder.set広域内住所地特例フラグ(dbT1001Entity.getKoikinaiJushochiTokureiFlag());
        builder.set広住特措置元市町村コード(dbT1001Entity.getKoikinaiTokureiSochimotoShichosonCode());
        builder.set旧市町村コード(dbT1001Entity.getKyuShichosonCode());
        builder.set論理削除フラグ(false);
        return builder.build().toEntity();
    }

    private RString getHihokensyadaichoEdaNo(JuminIdoRendoShikakuTorokuEntity entity,
            ShikibetsuCode 識別コード,
            FlexibleDate 異動日) {
        RString 枝番;
        List<DbT1001HihokenshaDaichoEntity> 被保険者台帳管理EntityList = entity.get被保険者台帳EntityList();
        List<DbT1001HihokenshaDaichoEntity> listEntity = new ArrayList<>();
        if (被保険者台帳管理EntityList != null) {
            for (DbT1001HihokenshaDaichoEntity entity被保険者台帳管理 : 被保険者台帳管理EntityList) {
                if (識別コード.equals(entity被保険者台帳管理.getShikibetsuCode())
                        && 異動日.equals(entity被保険者台帳管理.getIdoYMD())) {
                    listEntity.add(entity被保険者台帳管理);
                }
            }
        }
        if (listEntity.isEmpty()) {
            枝番 = new RString("0001");
        } else {
            Collections.sort(listEntity, new JuminIdoRendoShikakuSoshitsuShiboKyoTu.ComparatorsEdaNo());
            int edaBan = Integer.parseInt(listEntity.get(0).getEdaNo().toString());
            edaBan = edaBan + 1;
            枝番 = new RString(String.valueOf(String.format("%04d", edaBan)));
        }
        return 枝番;
    }

    @Transaction
    private void 被保台帳取得中死亡処理_２号資格者の年齢到達被保台帳作成(DbT1001HihokenshaDaichoEntity dbT1001Entity,
            NaiBushoRyouParamter naiBushoRyouParamter,
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            JuminIdoRendoShikakuTorokuEntity entity) {
        if (HihokenshaKubunCode.第２号被保険者.getコード().equals(dbT1001Entity.getHihokennshaKubunCode())
                && nullToMin(naiBushoRyouParamter.get補正後65歳到達日()).isBeforeOrEquals(nullToMin(naiBushoRyouParamter.get補正後消除異動日翌日()))) {
            DbT1001HihokenshaDaichoEntity hihokenshaDaicho = 被保台帳取得中死亡処理_年齢到達_死亡被保取得中(dbT1001Entity, naiBushoRyouParamter, 住民異動情報, entity);
            hihokenshaDaicho.setState(EntityDataState.Added);
            dbT1001Dac.save(hihokenshaDaicho);
        }
    }

    private DbT1001HihokenshaDaichoEntity 被保台帳取得中死亡処理_年齢到達_死亡被保取得中(DbT1001HihokenshaDaichoEntity dbT1001Entity,
            NaiBushoRyouParamter naiBushoRyouParamter,
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            JuminIdoRendoShikakuTorokuEntity entity) {
        RString 枝番 = getHihokensyadaichoEdaNo(entity, dbT1001Entity.getShikibetsuCode(), naiBushoRyouParamter.get到達日_65歳());
        HihokenshaDaicho hihokenshaDaicho = new HihokenshaDaicho(new HihokenshaNo(dbT1001Entity.getShikibetsuCode().value()),
                naiBushoRyouParamter.get到達日_65歳(),
                枝番);
        HihokenshaDaichoBuilder builder = hihokenshaDaicho.createBuilderForEdit();
        builder.set異動事由コード(ShikakuHenkoJiyu._１号到達.getコード());
        builder.set市町村コード(dbT1001Entity.getShichosonCode());
        builder.set識別コード(住民異動情報.getShikibetsuCode());
        builder.set資格取得事由コード(dbT1001Entity.getShikakuShutokuJiyuCode());
        builder.set資格取得年月日(dbT1001Entity.getShikakuShutokuYMD());
        builder.set資格取得届出年月日(dbT1001Entity.getShikakuShutokuTodokedeYMD());
        builder.set第1号資格取得年月日(naiBushoRyouParamter.get到達日_65歳());
        builder.set被保険者区分コード(HihokenshaKubunCode.第１号被保険者.getコード());
        builder.set資格喪失事由コード(RString.EMPTY);
        builder.set資格喪失年月日(FlexibleDate.EMPTY);
        builder.set資格喪失届出年月日(FlexibleDate.EMPTY);
        builder.set資格変更事由コード(ShikakuHenkoJiyu._１号到達.getコード());
        builder.set資格変更年月日(naiBushoRyouParamter.get到達日_65歳());
        builder.set資格変更届出年月日(住民異動情報.getTorokuTodokedeYMD());
        builder.set住所地特例適用事由コード(RString.EMPTY);
        builder.set適用年月日(FlexibleDate.EMPTY);
        builder.set適用届出年月日(FlexibleDate.EMPTY);
        builder.set住所地特例解除事由コード(RString.EMPTY);
        builder.set解除年月日(FlexibleDate.EMPTY);
        builder.set解除届出年月日(FlexibleDate.EMPTY);
        builder.set住所地特例フラグ(flag_OFF);
        builder.set広域内住所地特例フラグ(dbT1001Entity.getKoikinaiJushochiTokureiFlag());
        builder.set広住特措置元市町村コード(dbT1001Entity.getKoikinaiTokureiSochimotoShichosonCode());
        builder.set旧市町村コード(dbT1001Entity.getKyuShichosonCode());
        builder.set論理削除フラグ(false);
        return builder.build().toEntity();
    }

    @Transaction
    private boolean 被保台帳取得中死亡処理_65歳未到達者に作成されている(NaiBushoRyouParamter naiBushoRyouParamter,
            JuminIdoRendoShikakuTorokuEntity entity,
            List<DbT1001HihokenshaDaichoEntity> entityList) {
        DbT1001HihokenshaDaichoEntity dbT1001Entity = entityList.get(0);
        if (ShikakuKubun._１号.getコード().equals(dbT1001Entity.getHihokennshaKubunCode())
                && ShikakuShutokuJiyu.年齢到達.getコード().equals(dbT1001Entity.getShikakuShutokuJiyuCode())
                && nullToMin(naiBushoRyouParamter.get補正後消除異動日翌日())
                .isBefore(nullToMin(naiBushoRyouParamter.get補正後65歳到達日()))) {
            Iterator<DbT1001HihokenshaDaichoEntity> iterator = entityList.iterator();
            while (iterator.hasNext()) {
                DbT1001HihokenshaDaichoEntity daichoEntity = iterator.next();
                if (dbT1001Entity.getHihokennshaKubunCode().equals(daichoEntity.getHihokennshaKubunCode())
                        && nullToEmpty(dbT1001Entity.getShikakuShutokuJiyuCode()).equals(nullToEmpty(daichoEntity.getShikakuShutokuJiyuCode()))
                        && nullToEmpty(dbT1001Entity.getShikakuShutokuYMD()).equals(nullToEmpty(daichoEntity.getShikakuShutokuYMD()))) {
                    DbT1001HihokenshaDaichoEntity hihokenshaDaicho = 被保台帳取得中死亡処理_削除_死亡被保取得中(dbT1001Entity);
                    hihokenshaDaicho.setState(EntityDataState.Modified);
                    dbT1001Dac.save(hihokenshaDaicho);
                    iterator.remove();
                }
            }
            List<DbT1001HihokenshaDaichoEntity> dbT1001Entity直近List = searchHihodaicho(entityList, 直近);
            DbT1001HihokenshaDaichoEntity dbT1001 = new DbT1001HihokenshaDaichoEntity();
            if (dbT1001Entity直近List != null && !dbT1001Entity直近List.isEmpty()) {
                dbT1001 = dbT1001Entity直近List.get(0);
            }
            if (dbT1001 != null && !RString.isNullOrEmpty(dbT1001.getShikakuSoshitsuJiyuCode())) {
                戻り値の編集(entity, JuminRendoFuseigo.被保険者台帳_死亡登録不能_資格取得日_資格喪失日_不整合.getコード(), RString.EMPTY,
                        dbT1001Entity直近List, entity.get適用除外者台帳EntityList(),
                        entity.get他市町村住所地特例EntityList(), entity.get介護保険施設入退所EntityList());
                return true;
            }
        }
        return false;
    }

    private List<DbT1001HihokenshaDaichoEntity> searchHihodaicho(List<DbT1001HihokenshaDaichoEntity> dbT1001List, RString データ抽出ＰＴＮ) {

        List<DbT1001HihokenshaDaichoEntity> list = new ArrayList<>();
        HihokenshaNo 被保険者 = HihokenshaNo.EMPTY;

        if (直近.equals(データ抽出ＰＴＮ)) {
            for (DbT1001HihokenshaDaichoEntity dbT1001Entity : dbT1001List) {
                if (!被保険者.equals(dbT1001Entity.getHihokenshaNo())) {
                    list.add(dbT1001Entity);
                    被保険者 = dbT1001Entity.getHihokenshaNo();
                }
            }
        }
        if (転出.equals(データ抽出ＰＴＮ)) {
            for (DbT1001HihokenshaDaichoEntity dbT1001Entity : dbT1001List) {
                if (ShikakuSoshitsuJiyu.転出.getコード().equals(dbT1001Entity.getIdoJiyuCode())
                        && !被保険者.equals(dbT1001Entity.getHihokenshaNo())) {
                    list.add(dbT1001Entity);
                    被保険者 = dbT1001Entity.getHihokenshaNo();
                }
            }
        }
        return list;
    }

    private DbT1001HihokenshaDaichoEntity 被保台帳取得中死亡処理_削除_死亡被保取得中(DbT1001HihokenshaDaichoEntity dbT1001Entity) {
        HihokenshaDaicho hihokenshaDaicho = new HihokenshaDaicho(dbT1001Entity.getHihokenshaNo(),
                dbT1001Entity.getIdoYMD(),
                dbT1001Entity.getEdaNo());
        HihokenshaDaichoBuilder builder = hihokenshaDaicho.createBuilderForEdit();
        builder.set論理削除フラグ(true);
        return builder.build().toEntity();
    }

    /**
     * 被保台帳データがあり、直近データが喪失中の場合の被保台帳の死亡処理を行う。
     *
     * @param naiBushoRyouParamter NaiBushoRyouParamter
     * @param entity JuminIdoRendoShikakuTorokuEntity
     * @param 住民異動情報 UaFt200FindShikibetsuTaishoEntity
     */
    @Transaction
    public void shiboHihodaichoSoshitsuChu(
            NaiBushoRyouParamter naiBushoRyouParamter,
            JuminIdoRendoShikakuTorokuEntity entity,
            UaFt200FindShikibetsuTaishoEntity 住民異動情報) {
        TemParamter temparamter = new TemParamter();
        List<DbT1001HihokenshaDaichoEntity> dbT1001EntityList = searchHihodaicho(entity, 直近);
        DbT1001HihokenshaDaichoEntity dbT1001Entity = dbT1001EntityList.get(0);
        if (ShikakuSoshitsuJiyu.死亡.getコード().equals(dbT1001Entity.getShikakuSoshitsuJiyuCode())
                && nullToMin(dbT1001Entity.getShikakuSoshitsuYMD()).equals(nullToMin(naiBushoRyouParamter.get消除異動日翌日()))
                && nullToMin(dbT1001Entity.getShikakuSoshitsuTodokedeYMD()).equals(nullToMin(住民異動情報.getShojoTodokedeYMD()))) {
            戻り値の編集(entity, RString.EMPTY, RString.EMPTY, entity.get被保険者台帳EntityList(), entity.get適用除外者台帳EntityList(),
                    entity.get他市町村住所地特例EntityList(), entity.get介護保険施設入退所EntityList());
            return;
        }
        JuminIdoRendoShikakuSoshitsu.createInstance().getMaxKaijoYmd(entity, dbT1001Entity.getShikakuSoshitsuYMD(),
                dbT1001Entity.getShikakuSoshitsuTodokedeYMD(), 住民異動情報, temparamter);
        if (temparamter.get登録届出日() != null && !temparamter.get登録届出日().isEmpty()
                && nullToMin(住民異動情報.getTorokuIdoYMD()).isBeforeOrEquals(nullToMin(temparamter.get登録異動日()))) {
            住民異動情報.setTorokuIdoYMD(temparamter.get登録異動日());
            住民異動情報.setTorokuTodokedeYMD(temparamter.get登録届出日());
        }
        if (被保台帳喪失中死亡処理_被保台帳生成用の項目編集(naiBushoRyouParamter, 住民異動情報,
                entity, temparamter)) {
            return;
        }
        if (被保台帳喪失中死亡処理_不整合チェック(naiBushoRyouParamter, entity, temparamter, dbT1001EntityList)) {
            return;
        }
        DbT1001HihokenshaDaichoEntity hihokenshaDaichoShutoku被保台帳生成 = 被保台帳喪失中死亡処理_被保台帳生成(entity, 住民異動情報, temparamter);
        hihokenshaDaichoShutoku被保台帳生成.setState(EntityDataState.Added);
        dbT1001Dac.save(hihokenshaDaichoShutoku被保台帳生成);
        DbT1001HihokenshaDaichoEntity hihokenshaDaichoSoushisu被保台帳喪失中死亡処理
                = 被保台帳喪失中死亡処理_被保台帳喪失中死亡処理(entity, naiBushoRyouParamter, 住民異動情報,
                        temparamter);
        hihokenshaDaichoSoushisu被保台帳喪失中死亡処理.setState(EntityDataState.Added);
        dbT1001Dac.save(hihokenshaDaichoSoushisu被保台帳喪失中死亡処理);
        戻り値の編集(entity, RString.EMPTY, RString.EMPTY, entity.get被保険者台帳EntityList(), entity.get適用除外者台帳EntityList(),
                entity.get他市町村住所地特例EntityList(), entity.get介護保険施設入退所EntityList());
    }

    private DbT1001HihokenshaDaichoEntity 被保台帳喪失中死亡処理_被保台帳喪失中死亡処理(JuminIdoRendoShikakuTorokuEntity entity,
            NaiBushoRyouParamter naiBushoRyouParamter,
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            TemParamter temparamter) {
        List<DbT1001HihokenshaDaichoEntity> dbT1001List = entity.get被保険者台帳EntityList();
        RString 枝番 = getHihokensyadaichoEdaNo(entity,
                dbT1001List.get(0).getShikibetsuCode(), naiBushoRyouParamter.get消除異動日翌日());
        HihokenshaDaicho hihokenshaDaicho = new HihokenshaDaicho(new HihokenshaNo(dbT1001List.get(0).getShikibetsuCode().value()),
                naiBushoRyouParamter.get消除異動日翌日(),
                枝番);
        HihokenshaDaichoBuilder builder = hihokenshaDaicho.createBuilderForEdit();
        builder.set異動事由コード(ShikakuSoshitsuJiyu.死亡.getコード());
        builder.set市町村コード(dbT1001List.get(0).getShichosonCode());
        builder.set識別コード(住民異動情報.getShikibetsuCode());
        builder.set資格取得事由コード(temparamter.getTmp取得事由());
        builder.set資格取得年月日(temparamter.getTmp日付());
        builder.set資格取得届出年月日(住民異動情報.getTorokuTodokedeYMD());
        builder.set第1号資格取得年月日(dbT1001List.get(0).getIchigoShikakuShutokuYMD());
        builder.set被保険者区分コード(HihokenshaKubunCode.第１号被保険者.getコード());
        builder.set資格喪失事由コード(ShikakuSoshitsuJiyu.死亡.getコード());
        builder.set資格喪失年月日(naiBushoRyouParamter.get消除異動日翌日());
        builder.set資格変更届出年月日(住民異動情報.getShojoTodokedeYMD());
        builder.set資格変更事由コード(RString.EMPTY);
        builder.set資格変更年月日(FlexibleDate.EMPTY);
        builder.set資格変更届出年月日(FlexibleDate.EMPTY);
        builder.set住所地特例適用事由コード(RString.EMPTY);
        builder.set適用年月日(FlexibleDate.EMPTY);
        builder.set適用届出年月日(FlexibleDate.EMPTY);
        builder.set住所地特例解除事由コード(RString.EMPTY);
        builder.set解除年月日(FlexibleDate.EMPTY);
        builder.set解除届出年月日(FlexibleDate.EMPTY);
        builder.set住所地特例フラグ(flag_OFF);
        builder.set広域内住所地特例フラグ(flag_OFF);
        builder.set広住特措置元市町村コード(LasdecCode.EMPTY);
        builder.set旧市町村コード(dbT1001List.get(0).getKyuShichosonCode());
        builder.set論理削除フラグ(false);
        return builder.build().toEntity();
    }

    private DbT1001HihokenshaDaichoEntity 被保台帳喪失中死亡処理_被保台帳生成(JuminIdoRendoShikakuTorokuEntity entity,
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            TemParamter temparamter) {
        DbT1001HihokenshaDaichoEntity dbT1001Entity = entity.get被保険者台帳EntityList().get(0);
        RString 枝番 = getHihokensyadaichoEdaNo(entity, dbT1001Entity.getShikibetsuCode(), temparamter.getTmp日付());
        HihokenshaDaicho hihokenshaDaicho = new HihokenshaDaicho(new HihokenshaNo(dbT1001Entity.getShikibetsuCode().value()),
                temparamter.getTmp日付(),
                枝番);
        HihokenshaDaichoBuilder builder = hihokenshaDaicho.createBuilderForEdit();
        builder.set異動事由コード(temparamter.getTmp取得事由());
        builder.set市町村コード(dbT1001Entity.getShichosonCode());
        builder.set識別コード(住民異動情報.getShikibetsuCode());
        builder.set資格取得事由コード(temparamter.getTmp取得事由());
        builder.set資格取得年月日(temparamter.getTmp日付());
        builder.set資格取得届出年月日(住民異動情報.getTorokuTodokedeYMD());
        builder.set第1号資格取得年月日(dbT1001Entity.getIchigoShikakuShutokuYMD());
        builder.set被保険者区分コード(HihokenshaKubunCode.第１号被保険者.getコード());
        builder.set資格喪失事由コード(RString.EMPTY);
        builder.set資格喪失年月日(FlexibleDate.EMPTY);
        builder.set資格喪失届出年月日(FlexibleDate.EMPTY);
        builder.set資格変更事由コード(RString.EMPTY);
        builder.set資格変更年月日(FlexibleDate.EMPTY);
        builder.set資格変更届出年月日(FlexibleDate.EMPTY);
        builder.set住所地特例適用事由コード(RString.EMPTY);
        builder.set適用年月日(FlexibleDate.EMPTY);
        builder.set適用届出年月日(FlexibleDate.EMPTY);
        builder.set住所地特例解除事由コード(RString.EMPTY);
        builder.set解除年月日(FlexibleDate.EMPTY);
        builder.set解除届出年月日(FlexibleDate.EMPTY);
        builder.set住所地特例フラグ(flag_OFF);
        builder.set広域内住所地特例フラグ(flag_OFF);
        builder.set広住特措置元市町村コード(LasdecCode.EMPTY);
        builder.set旧市町村コード(dbT1001Entity.getKyuShichosonCode());
        builder.set論理削除フラグ(false);
        return builder.build().toEntity();
    }

    private boolean 被保台帳喪失中死亡処理_不整合チェック(NaiBushoRyouParamter naiBushoRyouParamter,
            JuminIdoRendoShikakuTorokuEntity entity,
            TemParamter temparamter,
            List<DbT1001HihokenshaDaichoEntity> dbT1001EntityList) {
        if (nullToMin(naiBushoRyouParamter.get消除異動日翌日()).isBefore(nullToMin(temparamter.get登録異動日()))) {
            戻り値の編集(entity, JuminRendoFuseigo.死亡_喪失不能_資格取得日_資格喪失日_不整合.getコード(), RString.EMPTY,
                    dbT1001EntityList, entity.get適用除外者台帳EntityList(),
                    entity.get他市町村住所地特例EntityList(), entity.get介護保険施設入退所EntityList());
            return true;
        }
        return false;
    }

    private boolean 被保台帳喪失中死亡処理_被保台帳生成用の項目編集(NaiBushoRyouParamter naiBushoRyouParamter,
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            JuminIdoRendoShikakuTorokuEntity entity,
            TemParamter temparamter) {
        if (nullToMin(naiBushoRyouParamter.get補正後消除異動日翌日()).isBeforeOrEquals(temparamter.get登録異動日())) {
            if (nullToMin(住民異動情報.getTorokuIdoYMD()).isBeforeOrEquals(naiBushoRyouParamter.get補正後消除異動日翌日())) {
                temparamter.setTmp取得事由(ShikakuShutokuJiyu.その他.getコード());
                temparamter.setTmp日付(住民異動情報.getTorokuIdoYMD());
            } else {
                戻り値の編集(entity, RString.EMPTY, RString.EMPTY, entity.get被保険者台帳EntityList(), entity.get適用除外者台帳EntityList(),
                        entity.get他市町村住所地特例EntityList(), entity.get介護保険施設入退所EntityList());
                return true;
            }
        }
        if (temparamter.get登録異動日().isBefore(naiBushoRyouParamter.get補正後65歳到達日())) {
            if (nullToMin(住民異動情報.getTorokuIdoYMD()).isBeforeOrEquals(naiBushoRyouParamter.get補正後消除異動日翌日())) {
                temparamter.setTmp取得事由(ShikakuShutokuJiyu.年齢到達.getコード());
                temparamter.setTmp日付(naiBushoRyouParamter.get到達日_65歳());
                住民異動情報.setTorokuTodokedeYMD(naiBushoRyouParamter.get補正後65歳到達日());
            } else {
                戻り値の編集(entity, RString.EMPTY, RString.EMPTY, entity.get被保険者台帳EntityList(), entity.get適用除外者台帳EntityList(),
                        entity.get他市町村住所地特例EntityList(), entity.get介護保険施設入退所EntityList());
                return true;
            }
        }
        return false;
    }

    /**
     * 被保台帳データがない場合の被保台帳の死亡処理を行う。
     *
     * @param paramter NaiBushoRyouParamter
     * @param entity JuminIdoRendoShikakuTorokuEntity
     * @param 住民異動情報 UaFt200FindShikibetsuTaishoEntity
     * @param storeConfigParamter StoreConfigParamter
     */
    public void shiboHihodaichoNashi(JuminIdoRendoShikakuTorokuEntity entity,
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            NaiBushoRyouParamter paramter,
            StoreConfigParamter storeConfigParamter) {

        TemParamter temParamter = new TemParamter();
        被保台帳なし死亡処理_判定用日付の編集(entity, 住民異動情報, temParamter);
        if (!被保台帳なし死亡処理_被保台帳生成用の項目編集(entity, 住民異動情報, paramter, temParamter)) {

            return;
        }
        if (!被保台帳なし死亡処理_不整合チェック(entity, paramter, temParamter)) {

            return;
        }
        被保台帳なし死亡処理_被保台帳生成(entity, 住民異動情報, temParamter, storeConfigParamter);
        被保台帳なし死亡処理_被保険者台帳の喪失更新(entity, 住民異動情報, paramter, temParamter, storeConfigParamter);
        戻り値の編集(entity, RString.EMPTY, RString.EMPTY,
                entity.get被保険者台帳EntityList(), entity.get適用除外者台帳EntityList(),
                entity.get他市町村住所地特例EntityList(), entity.get介護保険施設入退所EntityList());
    }

    @Transaction
    private void 被保台帳なし死亡処理_被保険者台帳の喪失更新(JuminIdoRendoShikakuTorokuEntity entity,
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            NaiBushoRyouParamter paramter,
            TemParamter temParamter,
            StoreConfigParamter storeConfigParamter) {
        HihokenshaNo hihokenshaNo = HihokenshanotsukibanFinder.createInstance()
                .getHihokenshanotsukiban(住民異動情報.getShikibetsuCode());
        DbT1001HihokenshaDaichoEntity dbT1001Entity
                = 被保台帳なし死亡処理_喪失_死亡被保なし(entity, 住民異動情報, hihokenshaNo, paramter, temParamter, storeConfigParamter);
        dbT1001Entity.setState(EntityDataState.Added);
        dbT1001Dac.save(dbT1001Entity);
    }

    private DbT1001HihokenshaDaichoEntity 被保台帳なし死亡処理_喪失_死亡被保なし(JuminIdoRendoShikakuTorokuEntity entity,
            UaFt200FindShikibetsuTaishoEntity 住民異動情報, HihokenshaNo hihokenshaNo,
            NaiBushoRyouParamter paramter,
            TemParamter temParamter,
            StoreConfigParamter storeConfigParamter) {

        RString 枝番 = getHihokensyadaichoEdaNo(entity, 住民異動情報.getShikibetsuCode(), paramter.get消除異動日翌日());
        HihokenshaDaicho hihokenshaDaicho = new HihokenshaDaicho(hihokenshaNo,
                paramter.get消除異動日翌日(),
                枝番);
        HihokenshaDaichoBuilder builder = hihokenshaDaicho.createBuilderForEdit();
        builder.set異動事由コード(temParamter.getTmp取得事由());
        builder.set市町村コード(住民異動情報.getGenLasdecCode());
        builder.set識別コード(住民異動情報.getShikibetsuCode());
        builder.set資格取得事由コード(temParamter.getTmp取得事由());
        builder.set資格取得年月日(nullToEmpty(temParamter.getTmp日付()));
        builder.set資格取得届出年月日(nullToEmpty(住民異動情報.getTorokuTodokedeYMD()));
        builder.set第1号資格取得年月日(nullToEmpty(temParamter.getTmp日付()));
        builder.set被保険者区分コード(HihokenshaKubunCode.第１号被保険者.getコード());
        builder.set資格喪失事由コード(ShikakuSoshitsuJiyu.死亡.getコード());
        builder.set資格喪失年月日(nullToEmpty(paramter.get消除異動日翌日()));
        builder.set資格喪失届出年月日(nullToEmpty(住民異動情報.getShojoTodokedeYMD()));
        builder.set資格変更事由コード(RString.EMPTY);
        builder.set資格変更年月日(FlexibleDate.EMPTY);
        builder.set資格変更届出年月日(FlexibleDate.EMPTY);
        builder.set住所地特例適用事由コード(RString.EMPTY);
        builder.set適用年月日(FlexibleDate.EMPTY);
        builder.set適用届出年月日(FlexibleDate.EMPTY);
        builder.set住所地特例解除事由コード(RString.EMPTY);
        builder.set解除年月日(FlexibleDate.EMPTY);
        builder.set解除届出年月日(FlexibleDate.EMPTY);
        builder.set住所地特例フラグ(flag_OFF);
        builder.set広域内住所地特例フラグ(flag_OFF);
        builder.set広住特措置元市町村コード(LasdecCode.EMPTY);
        if (!new RString("0").equals(storeConfigParamter.get合併区分())) {
            builder.set旧市町村コード(住民異動情報.getKyuLasdecCode() == null
                    ? LasdecCode.EMPTY : 住民異動情報.getKyuLasdecCode());
        }
        builder.set論理削除フラグ(false);
        return builder.build().toEntity();
    }

    @Transaction
    private void 被保台帳なし死亡処理_被保台帳生成(
            JuminIdoRendoShikakuTorokuEntity entity,
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            TemParamter temParamter,
            StoreConfigParamter storeConfigParamter) {
        HihokenshaNo hihokenshaNo = HihokenshanotsukibanFinder.createInstance()
                .getHihokenshanotsukiban(住民異動情報.getShikibetsuCode());
        DbT1001HihokenshaDaichoEntity dbT1001Entity
                = 被保台帳なし死亡処理_取得_死亡被保なし(entity, 住民異動情報, hihokenshaNo, temParamter, storeConfigParamter);
        dbT1001Entity.setState(EntityDataState.Added);
        dbT1001Dac.save(dbT1001Entity);
    }

    private DbT1001HihokenshaDaichoEntity 被保台帳なし死亡処理_取得_死亡被保なし(
            JuminIdoRendoShikakuTorokuEntity entity,
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            HihokenshaNo hihokenshaNo,
            TemParamter temParamter,
            StoreConfigParamter storeConfigParamter) {

        RString 枝番 = getHihokensyadaichoEdaNo(entity, 住民異動情報.getShikibetsuCode(), temParamter.getTmp日付());
        HihokenshaDaicho hihokenshaDaicho = new HihokenshaDaicho(
                hihokenshaNo,
                temParamter.getTmp日付(),
                枝番);
        HihokenshaDaichoBuilder builder = hihokenshaDaicho.createBuilderForEdit();
        builder.set異動事由コード(temParamter.getTmp取得事由());
        builder.set市町村コード(住民異動情報.getGenLasdecCode());
        builder.set識別コード(住民異動情報.getShikibetsuCode());
        builder.set資格取得事由コード(temParamter.getTmp取得事由());
        builder.set資格取得年月日(nullToEmpty(temParamter.getTmp日付()));
        builder.set資格取得届出年月日(nullToEmpty(住民異動情報.getTorokuTodokedeYMD()));
        builder.set第1号資格取得年月日(nullToEmpty(temParamter.getTmp日付()));
        builder.set被保険者区分コード(HihokenshaKubunCode.第１号被保険者.getコード());
        builder.set資格喪失事由コード(RString.EMPTY);
        builder.set資格喪失年月日(FlexibleDate.EMPTY);
        builder.set資格喪失届出年月日(FlexibleDate.EMPTY);
        builder.set資格変更事由コード(RString.EMPTY);
        builder.set資格変更年月日(FlexibleDate.EMPTY);
        builder.set資格変更届出年月日(FlexibleDate.EMPTY);
        builder.set住所地特例適用事由コード(RString.EMPTY);
        builder.set適用年月日(FlexibleDate.EMPTY);
        builder.set適用届出年月日(FlexibleDate.EMPTY);
        builder.set住所地特例解除事由コード(RString.EMPTY);
        builder.set解除年月日(FlexibleDate.EMPTY);
        builder.set解除届出年月日(FlexibleDate.EMPTY);
        builder.set住所地特例フラグ(flag_OFF);
        builder.set広域内住所地特例フラグ(flag_OFF);
        builder.set広住特措置元市町村コード(LasdecCode.EMPTY);
        if (!new RString("0").equals(storeConfigParamter.get合併区分())) {
            builder.set旧市町村コード(住民異動情報.getKyuLasdecCode() == null
                    ? LasdecCode.EMPTY : 住民異動情報.getKyuLasdecCode());
        }
        builder.set論理削除フラグ(false);
        return builder.build().toEntity();
    }

    private boolean 被保台帳なし死亡処理_不整合チェック(JuminIdoRendoShikakuTorokuEntity entity,
            NaiBushoRyouParamter paramter, TemParamter temParamter) {
        if (nullToMin(paramter.get消除異動日翌日()).isBefore(nullToMin(temParamter.get登録異動日()))) {
            戻り値の編集(entity, JuminRendoFuseigo.死亡_喪失不能_資格取得日_資格喪失日_不整合.getコード(), RString.EMPTY,
                    entity.get被保険者台帳EntityList(), entity.get適用除外者台帳EntityList(),
                    entity.get他市町村住所地特例EntityList(), entity.get介護保険施設入退所EntityList());
            return false;
        }
        return true;
    }

    private boolean 被保台帳なし死亡処理_被保台帳生成用の項目編集(JuminIdoRendoShikakuTorokuEntity entity,
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            NaiBushoRyouParamter paramter, TemParamter temParamter) {

        if (nullToMin(paramter.get補正後消除異動日翌日()).isBeforeOrEquals(nullToMin(temParamter.get登録異動日()))) {

            if (nullToMin(住民異動情報.getTorokuIdoYMD())
                    .isBeforeOrEquals(nullToMin(paramter.get補正後消除異動日翌日()))) {

                temParamter.setTmp取得事由(ShikakuShutokuJiyu.その他.getコード());
                temParamter.setTmp日付(住民異動情報.getTorokuIdoYMD());
            }
            if (nullToMin(paramter.get補正後消除異動日翌日()).isBefore(nullToMin(temParamter.get登録異動日()))) {

                戻り値の編集(entity, RString.EMPTY, RString.EMPTY, entity.get被保険者台帳EntityList(), entity.get適用除外者台帳EntityList(),
                        entity.get他市町村住所地特例EntityList(), entity.get介護保険施設入退所EntityList());
                return false;
            }
        }
        if (nullToMin(temParamter.get登録異動日()).isBefore(nullToMin(paramter.get補正後65歳到達日()))) {

            if (nullToMin(住民異動情報.getTorokuIdoYMD()).isBeforeOrEquals(nullToMin(paramter.get補正後消除異動日翌日()))) {

                temParamter.setTmp取得事由(ShikakuShutokuJiyu.年齢到達.getコード());
                temParamter.setTmp日付(paramter.get到達日_65歳());
                住民異動情報.setTorokuTodokedeYMD(paramter.get補正後65歳到達日());
            }
            if (nullToMin(paramter.get補正後消除異動日翌日()).isBefore(nullToMin(住民異動情報.getTorokuIdoYMD()))) {

                戻り値の編集(entity, RString.EMPTY, RString.EMPTY, entity.get被保険者台帳EntityList(), entity.get適用除外者台帳EntityList(),
                        entity.get他市町村住所地特例EntityList(), entity.get介護保険施設入退所EntityList());
                return false;
            }
        }
        return true;
    }

    private void 被保台帳なし死亡処理_判定用日付の編集(
            JuminIdoRendoShikakuTorokuEntity entity,
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            TemParamter paramter) {

        JuminIdoRendoShikakuSoshitsu.createInstance().getMaxKaijoYmd(entity, FlexibleDate.EMPTY, FlexibleDate.EMPTY, 住民異動情報, paramter);
        if (paramter.get登録届出日() != null && !paramter.get登録届出日().isEmpty()
                && nullToMin(住民異動情報.getTorokuIdoYMD()).isBeforeOrEquals(nullToMin(paramter.get登録異動日()))) {

            住民異動情報.setTorokuIdoYMD(paramter.get登録異動日());
            住民異動情報.setTorokuTodokedeYMD(paramter.get登録届出日());
        }
    }

    /**
     * 戻り値の編集。
     *
     * @param entity JuminIdoRendoShikakuTorokuEntity
     * @param 不整合コード RString
     * @param 転出保留作成事由コード RString
     * @param 被保険者台帳EntityList List<DbT1001HihokenshaDaichoEntity>
     * @param 適用除外者台帳EntityList List<DbT1002TekiyoJogaishaEntity>
     * @param 他市町村住所地特例EntityList List<DbT1003TashichosonJushochiTokureiEntity>
     * @param 介護保険施設入退所EntityList List<DbT1004ShisetsuNyutaishoEntity>
     */
    public void 戻り値の編集(
            JuminIdoRendoShikakuTorokuEntity entity,
            RString 不整合コード,
            RString 転出保留作成事由コード,
            List<DbT1001HihokenshaDaichoEntity> 被保険者台帳EntityList,
            List<DbT1002TekiyoJogaishaEntity> 適用除外者台帳EntityList,
            List<DbT1003TashichosonJushochiTokureiEntity> 他市町村住所地特例EntityList,
            List<DbT1004ShisetsuNyutaishoEntity> 介護保険施設入退所EntityList) {
        entity.set不整合コード(不整合コード);
        entity.set転出保留作成事由コード(転出保留作成事由コード);
        entity.set介護保険施設入退所EntityList(介護保険施設入退所EntityList);
        entity.set他市町村住所地特例EntityList(他市町村住所地特例EntityList);
        entity.set被保険者台帳EntityList(被保険者台帳EntityList);
        entity.set適用除外者台帳EntityList(適用除外者台帳EntityList);
    }

    /**
     * 取得した被保険者台帳データから、異動日、枝番が最大のデータを取得する
     *
     * @param entity JuminIdoRendoShikakuTorokuEntity
     * @param データ抽出ＰＴＮ RString
     * @return List<DbT1001HihokenshaDaichoEntity>
     */
    public List<DbT1001HihokenshaDaichoEntity> searchHihodaicho(JuminIdoRendoShikakuTorokuEntity entity, RString データ抽出ＰＴＮ) {

        List<DbT1001HihokenshaDaichoEntity> dbT1001List = entity.get被保険者台帳EntityList();
        List<DbT1001HihokenshaDaichoEntity> list = new ArrayList<>();
        HihokenshaNo 被保険者 = HihokenshaNo.EMPTY;

        if (直近.equals(データ抽出ＰＴＮ)) {
            for (DbT1001HihokenshaDaichoEntity dbT1001Entity : dbT1001List) {
                if (!被保険者.equals(dbT1001Entity.getHihokenshaNo())) {
                    list.add(dbT1001Entity);
                    被保険者 = dbT1001Entity.getHihokenshaNo();
                }
            }
        }
        if (転出.equals(データ抽出ＰＴＮ)) {
            for (DbT1001HihokenshaDaichoEntity dbT1001Entity : dbT1001List) {
                if (ShikakuSoshitsuJiyu.転出.getコード().equals(dbT1001Entity.getIdoJiyuCode())
                        && !被保険者.equals(dbT1001Entity.getHihokenshaNo())) {
                    list.add(dbT1001Entity);
                    被保険者 = dbT1001Entity.getHihokenshaNo();
                }
            }
        }
        return list;
    }

    /**
     * 処理対象の識別コードを保有する適用除外者のデータを取得する。
     *
     * @param 住民異動情報 UaFt200FindShikibetsuTaishoEntity
     * @param 被保険者台帳 DbV1001HihokenshaDaichoEntity
     * @param entity JuminIdoRendoShikakuTorokuEntity
     */
    @Transaction
    public void getJogai(UaFt200FindShikibetsuTaishoEntity 住民異動情報, DbV1001HihokenshaDaichoEntity 被保険者台帳,
            JuminIdoRendoShikakuTorokuEntity entity) {

        if (被保険者台帳.getHihokenshaNo() == null || 被保険者台帳.getHihokenshaNo().value().isEmpty()) {

            entity.set適用除外者台帳EntityList(new ArrayList<DbT1002TekiyoJogaishaEntity>());
        } else {
            List<DbT1002TekiyoJogaishaEntity> dbT1002TList = dbT1002Dac.get適用除外者受給者台帳(住民異動情報.getShikibetsuCode());
            entity.set適用除外者台帳EntityList(dbT1002TList);
        }
    }

    /**
     * 基準日時点における年齢を算出する。
     *
     * @param paramter NaiBushoRyouParamter
     * @param 住民異動情報 UaFt200FindShikibetsuTaishoEntity
     * @param 翌日 FlexibleDate
     */
    public void nenreiCalc(UaFt200FindShikibetsuTaishoEntity 住民異動情報, NaiBushoRyouParamter paramter, FlexibleDate 翌日) {
        IDateOfBirth dateofbirth = DateOfBirthFactory.createInstance(住民異動情報.getSeinengappiYMD());
        AgeCalculator agecalculator = new AgeCalculator(dateofbirth, JuminJotai.toValue(住民異動情報.getJuminJotaiCode()),
                住民異動情報.getShojoIdoYMD(), 翌日);
        paramter.set年齢(agecalculator.get年齢());
    }

    /**
     * 65歳（第１号被保険者基準年齢）の到達日を算出する。
     *
     * @param storeConfigParamter StoreConfigParamter
     * @param 住民異動情報 UaFt200FindShikibetsuTaishoEntity
     * @return 到達日
     */
    public FlexibleDate getNenreiTotatsuYmd(UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            StoreConfigParamter storeConfigParamter) {

        IDateOfBirth dateofbirth = DateOfBirthFactory.createInstance(住民異動情報.getSeinengappiYMD());
        AgeCalculator agecalculator = new AgeCalculator(dateofbirth, JuminJotai.toValue(住民異動情報.getJuminJotaiCode()),
                住民異動情報.getShojoIdoYMD());
        return agecalculator.get年齢到達日(Integer.valueOf(storeConfigParamter.get第１号被保険者基準年齢().toString()));
    }

    /**
     * 他特例者の転出、死亡、転入通知受理処理を行う。
     *
     * @param storeConfigParamter StoreConfigParamter
     * @param 住民異動情報 UaFt200FindShikibetsuTaishoEntity
     * @param 資格喪失事由 RString
     * @param entity JuminIdoRendoShikakuTorokuEntity
     */
    public void shikakuSousituTatoku(UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            StoreConfigParamter storeConfigParamter, RString 資格喪失事由, JuminIdoRendoShikakuTorokuEntity entity) {

        TemParamter temparamter = new TemParamter();
        FlexibleDate 介護保険法施行日 = FlexibleDate.EMPTY;

        他特例者喪失処理_引数による事由の設定(資格喪失事由, 住民異動情報, temparamter);
        List<DbT1003TashichosonJushochiTokureiEntity> dbT1003List = new ArrayList<>();
        List<DbT1004ShisetsuNyutaishoEntity> dbT1004List = new ArrayList<>();
        boolean 処理実行フラグ = 他特例者喪失処理_他特例者の検索(entity, dbT1003List, dbT1004List);
        if (処理実行フラグ) {

            if (!他特例者喪失処理_他特例データのチェック(資格喪失事由, entity, storeConfigParamter,
                    介護保険法施行日, 住民異動情報, temparamter, dbT1003List, dbT1004List)) {
                return;
            }
            if (!他特例者喪失処理_施設入退所データのチェック(資格喪失事由, entity, temparamter, dbT1003List, dbT1004List)) {
                return;
            }
            if (!他特例者喪失処理_挿入レコードの編集(資格喪失事由, entity, 住民異動情報, temparamter, dbT1003List, dbT1004List)) {
                return;
            }
        } else {
            return;
        }
        戻り値の編集(entity, RString.EMPTY, RString.EMPTY,
                entity.get被保険者台帳EntityList(), entity.get適用除外者台帳EntityList(),
                entity.get他市町村住所地特例EntityList(), entity.get介護保険施設入退所EntityList());
    }

    @Transaction
    private boolean 他特例者喪失処理_挿入レコードの編集(
            RString 資格喪失事由,
            JuminIdoRendoShikakuTorokuEntity entity,
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            TemParamter temparamter,
            List<DbT1003TashichosonJushochiTokureiEntity> 他市町村住所地特例EntityList,
            List<DbT1004ShisetsuNyutaishoEntity> 介護保険施設入退所EntityList) {
        DbT1003TashichosonJushochiTokureiEntity dbT1003Entity = 他市町村住所地特例EntityList.get(0);
        DbT1004ShisetsuNyutaishoEntity dbT1004Entity = 介護保険施設入退所EntityList.get(0);
        if (ShikakuSoshitsuJiyu.転出.getコード().equals(資格喪失事由)
                || ShikakuSoshitsuJiyu.死亡.getコード().equals(資格喪失事由)) {

            DbT1003TashichosonJushochiTokureiEntity tokureiEntity = 他特例者喪失処理_他特例者_他特転出死亡データの編集(
                    住民異動情報,
                    dbT1003Entity,
                    temparamter,
                    entity);
            DbT1004ShisetsuNyutaishoEntity nyutaishoEntity = 他特例者喪失処理_施設入退所_除外転出死亡データの編集(dbT1004Entity, temparamter);
            if (!他特例者喪失処理_他特例者マスタの更新(tokureiEntity, nyutaishoEntity,
                    entity, 他市町村住所地特例EntityList, 介護保険施設入退所EntityList)) {

                return false;
            }
            戻り値の編集(entity, 不整合コード_9999, RString.EMPTY,
                    entity.get被保険者台帳EntityList(), entity.get適用除外者台帳EntityList(),
                    他市町村住所地特例EntityList, 介護保険施設入退所EntityList);
            return false;
        }
        if (ShikakuSoshitsuJiyu.その他.getコード().equals(資格喪失事由)) {

            if (temparamter.getLc解除事由().equals(dbT1003Entity.getKaijoJiyuCode())) {

                TashichosonJushochiTokurei tokurei = 他特例者喪失処理_適用除外者_他特転入通知受理直近データの編集(dbT1003Entity);
                dbT1003Dac.save(tokurei.modifiedModel().toEntity());
            }
            DbT1003TashichosonJushochiTokureiEntity tokureiEntity = 他特例者喪失処理_他特例者_他特転出死亡データの編集(
                    住民異動情報,
                    dbT1003Entity,
                    temparamter,
                    entity);
            DbT1004ShisetsuNyutaishoEntity nyutaishoEntity = 他特例者喪失処理_施設入退所_除外転出死亡データの編集(dbT1004Entity, temparamter);
            if (!他特例者喪失処理_他特例者マスタの更新(tokureiEntity, nyutaishoEntity,
                    entity, 他市町村住所地特例EntityList, 介護保険施設入退所EntityList)) {
                return false;
            }
            戻り値の編集(entity, 不整合コード_9999, RString.EMPTY,
                    entity.get被保険者台帳EntityList(), entity.get適用除外者台帳EntityList(),
                    他市町村住所地特例EntityList, 介護保険施設入退所EntityList);
            return false;
        }
        return true;
    }

    private TashichosonJushochiTokurei 他特例者喪失処理_適用除外者_他特転入通知受理直近データの編集(
            DbT1003TashichosonJushochiTokureiEntity dbT1003Entity) {
        dbT1003Entity.initializeMd5();
        TashichosonJushochiTokurei tokurei = new TashichosonJushochiTokurei(dbT1003Entity);
        TashichosonJushochiTokureiBuilder builder = tokurei.createBuilderForEdit();
        builder.set論理削除フラグ(true);
        return builder.build();
    }

    @Transaction
    private boolean 他特例者喪失処理_他特例者マスタの更新(
            DbT1003TashichosonJushochiTokureiEntity tokureiEntity,
            DbT1004ShisetsuNyutaishoEntity nyutaishoEntity,
            JuminIdoRendoShikakuTorokuEntity entity,
            List<DbT1003TashichosonJushochiTokureiEntity> 他市町村住所地特例EntityList,
            List<DbT1004ShisetsuNyutaishoEntity> 介護保険施設入退所EntityList) {

        if (tokureiEntity.getTekiyoYMD().isBeforeOrEquals(tokureiEntity.getKaijoYMD())) {

            tokureiEntity.setState(EntityDataState.Added);
            dbT1003Dac.save(tokureiEntity);
            nyutaishoEntity.setState(EntityDataState.Modified);
            dbT1004Dac.save(nyutaishoEntity);
        } else {
            戻り値の編集(entity, JuminRendoFuseigo.他特例者_更新不能_適用日_解除日_不整合.getコード(), RString.EMPTY,
                    entity.get被保険者台帳EntityList(), entity.get適用除外者台帳EntityList(),
                    他市町村住所地特例EntityList, 介護保険施設入退所EntityList);
            return false;
        }
        return true;
    }

    private DbT1004ShisetsuNyutaishoEntity 他特例者喪失処理_施設入退所_除外転出死亡データの編集(
            DbT1004ShisetsuNyutaishoEntity dbT1004Entity,
            TemParamter temparamter) {

        dbT1004Entity.initializeMd5();
        ShisetsuNyutaisho nyutaisho = new ShisetsuNyutaisho(dbT1004Entity);
        ShisetsuNyutaishoBuilder builder = nyutaisho.createBuilderForEdit();
        builder.set退所処理年月日(FlexibleDate.getNowDate());
        builder.set退所年月日(temparamter.getTmp異動日());
        return builder.build().toEntity();
    }

    private DbT1003TashichosonJushochiTokureiEntity 他特例者喪失処理_他特例者_他特転出死亡データの編集(
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            DbT1003TashichosonJushochiTokureiEntity dbT1003Entity,
            TemParamter temparamter,
            JuminIdoRendoShikakuTorokuEntity entity) {
        DbT1003TashichosonJushochiTokureiEntity dbT1003InsterEntity = new DbT1003TashichosonJushochiTokureiEntity();
        dbT1003InsterEntity.initializeMd5();
        TashichosonJushochiTokurei tokurei = new TashichosonJushochiTokurei(dbT1003InsterEntity);
        TashichosonJushochiTokureiBuilder builder = tokurei.createBuilderForEdit();
        builder.set識別コード(住民異動情報.getShikibetsuCode());
        builder.set異動日(temparamter.getTmp異動日());
        builder.set枝番(getTaTokureiEdaNo(entity, 住民異動情報.getShikibetsuCode(), temparamter.getTmp異動日()));
        builder.set異動事由コード(temparamter.getLc解除事由());
        builder.set市町村コード(dbT1003Entity.getShichosonCode());
        builder.set他市町村住所地特例適用事由コード(dbT1003Entity.getTekiyoJiyuCode());
        builder.set適用年月日(nullToEmpty(dbT1003Entity.getTekiyoYMD()));
        builder.set適用届出年月日(nullToEmpty(dbT1003Entity.getTekiyoTodokedeYMD()));
        builder.set適用受付年月日(nullToEmpty(dbT1003Entity.getTekiyoUketsukeYMD()));
        builder.set他市町村住所地特例解除事由コード(temparamter.getLc解除事由());
        builder.set解除年月日(nullToEmpty(temparamter.getTmp異動日()));
        builder.set解除届出年月日(nullToEmpty(temparamter.getTmp届出日()));
        builder.set解除受付年月日(FlexibleDate.getNowDate());
        builder.set措置保険者番号(dbT1003Entity.getSochiHokenshaNo());
        builder.set措置被保険者番号(dbT1003Entity.getSochiHihokenshaNo());
        builder.set他特例連絡票発行年月日(nullToEmpty(dbT1003Entity.getTatokuRenrakuhyoHakkoYMD()));
        builder.set施設退所通知発行年月日(nullToEmpty(dbT1003Entity.getShisetsuTaishoTsuchiHakkoYMD()));
        builder.set施設変更通知発行年月日(nullToEmpty(dbT1003Entity.getShisetsuHenkoTsuchiHakkoYMD()));
        builder.set論理削除フラグ(false);
        return builder.build().toEntity();
    }

    /**
     * 処理対象の識別コードを保有する他特例者のデータを取得する。
     *
     * @param entity JuminIdoRendoShikakuTorokuEntity
     * @param 識別コード ShikibetsuCode
     * @param 異動日 FlexibleDate
     * @return 枝番
     */
    public RString getTaTokureiEdaNo(
            JuminIdoRendoShikakuTorokuEntity entity,
            ShikibetsuCode 識別コード,
            FlexibleDate 異動日) {
        RString 枝番;
        List<DbT1003TashichosonJushochiTokureiEntity> 他市町村住所地特例EntityList = entity.get他市町村住所地特例EntityList();
        List<DbT1003TashichosonJushochiTokureiEntity> listEntity = new ArrayList<>();
        for (DbT1003TashichosonJushochiTokureiEntity entity他市町村住所地特例 : 他市町村住所地特例EntityList) {
            if (識別コード.equals(entity他市町村住所地特例.getShikibetsuCode())
                    && 異動日.equals(entity他市町村住所地特例.getIdoYMD())) {
                listEntity.add(entity他市町村住所地特例);
            }
        }
        if (!listEntity.isEmpty()) {
            Collections.sort(listEntity, new JuminIdoRendoShikakuSoshitsuShiboKyoTu.ComparatorsEdaNoTashichosonJushochiTokurei());
            int edaBan = Integer.parseInt(listEntity.get(0).getEdaNo().toString());
            edaBan = edaBan + 1;
            枝番 = new RString(String.valueOf(String.format("%04d", edaBan)));
            return 枝番;
        } else {
            枝番 = new RString("0001");
            return 枝番;
        }
    }

    private static class ComparatorsEdaNoTashichosonJushochiTokurei implements Comparator<DbT1003TashichosonJushochiTokureiEntity>, Serializable {

        @Override
        public int compare(DbT1003TashichosonJushochiTokureiEntity o1, DbT1003TashichosonJushochiTokureiEntity o2) {
            return o2.getEdaNo().compareTo(o1.getEdaNo());
        }
    }

    private boolean 他特例者喪失処理_施設入退所データのチェック(
            RString 資格喪失事由,
            JuminIdoRendoShikakuTorokuEntity entity,
            TemParamter temparamter,
            List<DbT1003TashichosonJushochiTokureiEntity> 他市町村住所地特例EntityList,
            List<DbT1004ShisetsuNyutaishoEntity> 介護保険施設入退所EntityList) {

        DbT1003TashichosonJushochiTokureiEntity dbT1003Entity = 他市町村住所地特例EntityList.get(0);
        DbT1004ShisetsuNyutaishoEntity dbT1004Entity = 介護保険施設入退所EntityList.get(0);
        FlexibleDate 施設入退所直近_施設退所日 = dbT1004Entity.getTaishoYMD();
        FlexibleDate 施設入退所直近_施設入所日 = dbT1004Entity.getNyushoYMD();
        RString 他特例直近_解除事由 = dbT1003Entity.getKaijoJiyuCode();
        if (ShikakuSoshitsuJiyu.転出.getコード().equals(資格喪失事由)
                || ShikakuSoshitsuJiyu.死亡.getコード().equals(資格喪失事由)) {

            if (!施設退所日がEmpty以外場合(資格喪失事由, entity, 施設入退所直近_施設退所日,
                    temparamter, 他市町村住所地特例EntityList, 介護保険施設入退所EntityList)) {

                return false;
            }
            if (!施設退所日がEmptyの場合(資格喪失事由, entity, 施設入退所直近_施設入所日, 施設入退所直近_施設退所日,
                    temparamter)) {
                return false;
            }
        }
        if (ShikakuSoshitsuJiyu.その他.getコード().equals(資格喪失事由)
                && 他特例直近_解除事由.equals(temparamter.getLc解除事由())
                && temparamter.getLc異動日().equals(施設入退所直近_施設退所日)) {
            戻り値の編集(entity, RString.EMPTY, RString.EMPTY,
                    entity.get被保険者台帳EntityList(), entity.get適用除外者台帳EntityList(),
                    entity.get他市町村住所地特例EntityList(), entity.get介護保険施設入退所EntityList());
        }
        return true;
    }

    private boolean 施設退所日がEmptyの場合(
            RString 資格喪失事由,
            JuminIdoRendoShikakuTorokuEntity entity,
            FlexibleDate 施設入退所直近_施設入所日,
            FlexibleDate 施設入退所直近_施設退所日,
            TemParamter temparamter) {
        if ((施設入退所直近_施設退所日 == null || 施設入退所直近_施設退所日.isEmpty())
                && temparamter.getTmp異動日().isBefore(nullToMin(施設入退所直近_施設入所日))
                && ShikakuSoshitsuJiyu.転出.getコード().equals(資格喪失事由)) {
            戻り値の編集(entity, JuminRendoFuseigo.他特例者_解除日_転出日_不整合.getコード(), RString.EMPTY,
                    entity.get被保険者台帳EntityList(), entity.get適用除外者台帳EntityList(),
                    entity.get他市町村住所地特例EntityList(), entity.get介護保険施設入退所EntityList());
            return false;
        }
        if ((施設入退所直近_施設退所日 == null || 施設入退所直近_施設退所日.isEmpty())
                && temparamter.getTmp異動日().isBefore(nullToMin(施設入退所直近_施設入所日))
                && ShikakuSoshitsuJiyu.死亡.getコード().equals(資格喪失事由)) {
            戻り値の編集(entity, JuminRendoFuseigo.他特例者_解除日_消除異動日_不整合.getコード(), RString.EMPTY,
                    entity.get被保険者台帳EntityList(), entity.get適用除外者台帳EntityList(),
                    entity.get他市町村住所地特例EntityList(), entity.get介護保険施設入退所EntityList());
            return false;
        }
        return true;
    }

    private boolean 施設退所日がEmpty以外場合(
            RString 資格喪失事由,
            JuminIdoRendoShikakuTorokuEntity entity,
            FlexibleDate 施設入退所直近_施設退所日,
            TemParamter temparamter,
            List<DbT1003TashichosonJushochiTokureiEntity> 他市町村住所地特例EntityList,
            List<DbT1004ShisetsuNyutaishoEntity> 介護保険施設入退所EntityList) {
        if (施設入退所直近_施設退所日 != null
                && !施設入退所直近_施設退所日.isEmpty()
                && !施設入退所直近_施設退所日.equals(temparamter.getLc異動日())
                && temparamter.getTmp異動日().isBefore(施設入退所直近_施設退所日)
                && ShikakuSoshitsuJiyu.転出.getコード().equals(資格喪失事由)) {

            戻り値の編集(entity, JuminRendoFuseigo.他特例者_解除日_転出日_不整合.getコード(), RString.EMPTY,
                    entity.get被保険者台帳EntityList(), entity.get適用除外者台帳EntityList(),
                    他市町村住所地特例EntityList, 介護保険施設入退所EntityList);
            return false;
        }
        if (施設入退所直近_施設退所日 != null
                && !施設入退所直近_施設退所日.isEmpty()
                && !施設入退所直近_施設退所日.equals(temparamter.getLc異動日())
                && temparamter.getTmp異動日().isBefore(施設入退所直近_施設退所日)
                && ShikakuSoshitsuJiyu.死亡.getコード().equals(資格喪失事由)) {
            戻り値の編集(entity, JuminRendoFuseigo.他特例者_解除日_消除異動日_不整合.getコード(), RString.EMPTY,
                    entity.get被保険者台帳EntityList(), entity.get適用除外者台帳EntityList(),
                    他市町村住所地特例EntityList, 介護保険施設入退所EntityList);
            return false;
        }
        return true;
    }

    private boolean 他特例者喪失処理_他特例データのチェック(
            RString 資格喪失事由,
            JuminIdoRendoShikakuTorokuEntity entity,
            StoreConfigParamter storeConfigParamter,
            FlexibleDate 介護保険法施行日,
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            TemParamter temparamter,
            List<DbT1003TashichosonJushochiTokureiEntity> 他市町村住所地特例EntityList,
            List<DbT1004ShisetsuNyutaishoEntity> 介護保険施設入退所EntityList) {

        DbT1003TashichosonJushochiTokureiEntity dbT1003Entity = 他市町村住所地特例EntityList.get(0);
        DbT1004ShisetsuNyutaishoEntity dbT1004Entity = 介護保険施設入退所EntityList.get(0);
        RString 他特例直近_解除事由 = dbT1003Entity.getKaijoJiyuCode();
        FlexibleDate 他特例直近_解除年月日 = dbT1003Entity.getKaijoYMD();
        FlexibleDate 他特例直近_解除届出日 = dbT1003Entity.getKaijoTodokedeYMD();
        FlexibleDate 住民異動情報_消除届出日 = 住民異動情報.getShojoTodokedeYMD();
        FlexibleDate 施設入退所直近_施設退所日 = dbT1004Entity.getTaishoYMD();
        if (ShikakuSoshitsuJiyu.転出.getコード().equals(資格喪失事由)
                || ShikakuSoshitsuJiyu.死亡.getコード().equals(資格喪失事由)) {

            if (storeConfigParamter.get介護保険法施行日() != null) {

                介護保険法施行日 = storeConfigParamter.get介護保険法施行日();
            }
            if (!他特例直近_解除事由の判定(
                    資格喪失事由,
                    entity,
                    介護保険法施行日,
                    他特例直近_解除事由,
                    他特例直近_解除年月日,
                    他特例直近_解除届出日,
                    temparamter,
                    住民異動情報_消除届出日,
                    他市町村住所地特例EntityList,
                    介護保険施設入退所EntityList)) {

                return false;
            }
        }
        if (ShikakuSoshitsuJiyu.その他.getコード().equals(資格喪失事由)) {

            if (nullToEmpty(他特例直近_解除事由).equals(temparamter.getLc解除事由())
                    && nullToEmpty(他特例直近_解除年月日).equals(temparamter.getLc異動日())) {
                戻り値の編集(entity, RString.EMPTY, RString.EMPTY,
                        entity.get被保険者台帳EntityList(), entity.get適用除外者台帳EntityList(),
                        entity.get他市町村住所地特例EntityList(), entity.get介護保険施設入退所EntityList());
                return false;
            }
            if (nullToEmpty(他特例直近_解除事由).equals(temparamter.getLc解除事由())
                    && nullToEmpty(他特例直近_解除届出日).equals(temparamter.getTmp届出日())) {
                戻り値の編集(entity, RString.EMPTY, RString.EMPTY,
                        entity.get被保険者台帳EntityList(), entity.get適用除外者台帳EntityList(),
                        entity.get他市町村住所地特例EntityList(), entity.get介護保険施設入退所EntityList());
                return false;
            }
            temparamter.setTmp異動日(temparamter.getLc異動日());
            if (他特例直近_解除届出日 == null || 他特例直近_解除届出日.isEmpty()) {
                temparamter.setTmp届出日(住民異動情報_消除届出日);
            }
            if (他特例直近_解除届出日 != null && !他特例直近_解除届出日.isEmpty()) {
                temparamter.setTmp届出日(他特例直近_解除届出日);
            }
        }

        return 他特例直近_解除年月日の判定(
                資格喪失事由,
                entity,
                他特例直近_解除年月日,
                施設入退所直近_施設退所日,
                他市町村住所地特例EntityList,
                介護保険施設入退所EntityList);
    }

    private boolean 他特例直近_解除年月日の判定(
            RString 資格喪失事由,
            JuminIdoRendoShikakuTorokuEntity entity,
            FlexibleDate 他特例直近_解除年月日,
            FlexibleDate 施設入退所直近_施設退所日,
            List<DbT1003TashichosonJushochiTokureiEntity> 他市町村住所地特例EntityList,
            List<DbT1004ShisetsuNyutaishoEntity> 介護保険施設入退所EntityList) {
        if (他特例直近_解除年月日 != null
                && !他特例直近_解除年月日.isEmpty()
                && 施設入退所直近_施設退所日 != null
                && !施設入退所直近_施設退所日.isEmpty()) {

            if (ShikakuSoshitsuJiyu.転出.getコード().equals(資格喪失事由)) {
                戻り値の編集(entity, JuminRendoFuseigo.転出死亡_他特例者_解除登録_施設入退所情報不整合.getコード(), RString.EMPTY,
                        entity.get被保険者台帳EntityList(), entity.get適用除外者台帳EntityList(),
                        他市町村住所地特例EntityList, 介護保険施設入退所EntityList);
                return false;
            }
            if (ShikakuSoshitsuJiyu.死亡.getコード().equals(資格喪失事由)) {
                戻り値の編集(entity, JuminRendoFuseigo.転出死亡_他特例者_入所中_施設入退所情報不整合.getコード(), RString.EMPTY,
                        entity.get被保険者台帳EntityList(), entity.get適用除外者台帳EntityList(),
                        他市町村住所地特例EntityList, 介護保険施設入退所EntityList);
                return false;
            }
        }
        return true;
    }

    private boolean 他特例直近_解除事由の判定(
            RString 資格喪失事由,
            JuminIdoRendoShikakuTorokuEntity entity,
            FlexibleDate 介護保険法施行日,
            RString 他特例直近_解除事由,
            FlexibleDate 他特例直近_解除年月日,
            FlexibleDate 他特例直近_解除届出日,
            TemParamter temparamter,
            FlexibleDate 住民異動情報_消除届出日,
            List<DbT1003TashichosonJushochiTokureiEntity> 他市町村住所地特例EntityList,
            List<DbT1004ShisetsuNyutaishoEntity> 介護保険施設入退所EntityList) {
        if (!RString.isNullOrEmpty(他特例直近_解除事由)) {

            if (!nullToMin(temparamter.getLc異動日()).isBefore(nullToMin(介護保険法施行日))) {
                temparamter.setTmp異動日(temparamter.getLc異動日().plusDay(1));
            } else {
                temparamter.setTmp異動日(temparamter.getLc異動日());
            }
            temparamter.setTmp届出日(住民異動情報_消除届出日);
            if (他特例直近_解除事由.equals(temparamter.getLc解除事由())
                    && temparamter.getTmp異動日().equals(他特例直近_解除年月日)
                    && 他特例直近_解除届出日.equals(temparamter.getTmp届出日())) {
                戻り値の編集(entity, RString.EMPTY, RString.EMPTY,
                        entity.get被保険者台帳EntityList(), entity.get適用除外者台帳EntityList(),
                        entity.get他市町村住所地特例EntityList(), entity.get介護保険施設入退所EntityList());
                return false;
            }
            if (!(他特例直近_解除事由.equals(temparamter.getLc解除事由())
                    && temparamter.getTmp異動日().equals(他特例直近_解除年月日)
                    && 他特例直近_解除届出日.equals(temparamter.getTmp届出日()))
                    && (nullToMin(temparamter.getTmp異動日()).isBefore(nullToMin(他特例直近_解除年月日))
                    && ShikakuSoshitsuJiyu.転出.getコード().equals(資格喪失事由))) {
                戻り値の編集(entity, JuminRendoFuseigo.他特例者_解除日_転出日_不整合.getコード(), RString.EMPTY,
                        entity.get被保険者台帳EntityList(), entity.get適用除外者台帳EntityList(),
                        他市町村住所地特例EntityList, 介護保険施設入退所EntityList);
                return false;
            }
            if (!(他特例直近_解除事由.equals(temparamter.getLc解除事由())
                    && temparamter.getTmp異動日().equals(他特例直近_解除年月日)
                    && 他特例直近_解除届出日.equals(temparamter.getTmp届出日()))
                    && (nullToMin(temparamter.getTmp異動日()).isBefore(nullToMin(他特例直近_解除年月日))
                    && ShikakuSoshitsuJiyu.死亡.getコード().equals(資格喪失事由))) {
                戻り値の編集(entity, JuminRendoFuseigo.他特例者_解除日_消除異動日_不整合.getコード(), RString.EMPTY,
                        entity.get被保険者台帳EntityList(), entity.get適用除外者台帳EntityList(),
                        他市町村住所地特例EntityList, 介護保険施設入退所EntityList);
                return false;
            }
        }
        return true;
    }

    private boolean 他特例者喪失処理_他特例者の検索(JuminIdoRendoShikakuTorokuEntity entity,
            List<DbT1003TashichosonJushochiTokureiEntity> dbT1003List,
            List<DbT1004ShisetsuNyutaishoEntity> dbT1004List) {

        DbT1004ShisetsuNyutaishoEntity dbT1004Entity
                = searchShisetsu(entity.get介護保険施設入退所EntityList(), DaichoType.他市町村住所地特例者.getコード());
        DbT1003TashichosonJushochiTokureiEntity dbT1003Entity = entity.get他市町村住所地特例EntityList().get(0);
        if (entity.get他市町村住所地特例EntityList() != null && !entity.get他市町村住所地特例EntityList().isEmpty()) {
            if (dbT1004Entity == null) {
                dbT1003List.add(dbT1003Entity);
                戻り値の編集(entity, JuminRendoFuseigo.転出死亡_他特例者_解除登録_施設入退所情報不整合.getコード(),
                        RString.EMPTY, entity.get被保険者台帳EntityList(),
                        entity.get適用除外者台帳EntityList(), dbT1003List, null);
                return false;
            }
        } else {
            if (dbT1004Entity != null) {
                dbT1004List.add(dbT1004Entity);
                戻り値の編集(entity, JuminRendoFuseigo.転出死亡_他特例者_入所中_施設入退所情報不整合.getコード(),
                        RString.EMPTY, entity.get被保険者台帳EntityList(),
                        entity.get適用除外者台帳EntityList(), null, dbT1004List);
                return false;
            }
        }

        if ((entity.get他市町村住所地特例EntityList() == null || entity.get他市町村住所地特例EntityList().isEmpty())
                && dbT1004Entity == null) {

            戻り値の編集(entity, RString.EMPTY, RString.EMPTY, entity.get被保険者台帳EntityList(),
                    entity.get適用除外者台帳EntityList(), entity.get他市町村住所地特例EntityList(),
                    entity.get介護保険施設入退所EntityList());
            return false;
        }
        dbT1003List.add(dbT1003Entity);
        dbT1004List.add(dbT1004Entity);
        return true;
    }

    private void 他特例者喪失処理_引数による事由の設定(RString 資格喪失事由, UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            TemParamter temparamter) {
        if (ShikakuSoshitsuJiyu.転出.getコード().equals(資格喪失事由)) {
            temparamter.setLc解除事由(TatokureiKaijoJiyu.他特例転出.getコード());
            temparamter.setLc異動日(住民異動情報.getTenshutsuYoteiIdoYMD());
        } else if (ShikakuSoshitsuJiyu.死亡.getコード().equals(資格喪失事由)) {
            temparamter.setLc解除事由(TatokureiKaijoJiyu.他特例死亡.getコード());
            temparamter.setLc異動日(住民異動情報.getShojoIdoYMD());
        } else if (ShikakuSoshitsuJiyu.その他.getコード().equals(資格喪失事由)) {
            temparamter.setLc解除事由(TatokureiKaijoJiyu.他特例転出.getコード());
            temparamter.setLc異動日(住民異動情報.getTenshutsuKakuteiIdoYMD());
        }
    }

    /**
     * 取得した施設入退所データから、指定の施設区分である入所日が最大のデータを取得する。
     *
     * @param listDbT1004 List<DbT1004ShisetsuNyutaishoEntity>
     * @param 台帳種別 RString
     * @return DbT1004ShisetsuNyutaishoEntity
     */
    public DbT1004ShisetsuNyutaishoEntity searchShisetsu(List<DbT1004ShisetsuNyutaishoEntity> listDbT1004, RString 台帳種別) {
        if (listDbT1004 != null && !listDbT1004.isEmpty()) {
            Collections.sort(listDbT1004, new JuminIdoRendoShikakuSoshitsuShiboKyoTu.Comparators());
            for (DbT1004ShisetsuNyutaishoEntity entity : listDbT1004) {
                if (台帳種別.equals(entity.getDaichoShubetsu())) {
                    return entity;
                }
            }
        }
        return null;
    }

    /**
     * 処理対象の識別コードを保有する他特例者のデータを取得する。
     *
     * @param 住民異動情報 UaFt200FindShikibetsuTaishoEntity
     * @param 被保険者台帳 DbV1001HihokenshaDaichoEntity
     * @param entity JuminIdoRendoShikakuTorokuEntity
     */
    @Transaction
    public void getGetTaTokurei(UaFt200FindShikibetsuTaishoEntity 住民異動情報, DbV1001HihokenshaDaichoEntity 被保険者台帳,
            JuminIdoRendoShikakuTorokuEntity entity) {

        if (被保険者台帳.getHihokenshaNo() == null || 被保険者台帳.getHihokenshaNo().value().isEmpty()) {

            entity.set他市町村住所地特例EntityList(new ArrayList<DbT1003TashichosonJushochiTokureiEntity>());
        } else {
            List<DbT1003TashichosonJushochiTokureiEntity> dbT1003DacList = dbT1003Dac.get適用除外者受給者台帳(住民異動情報.getShikibetsuCode());
            entity.set他市町村住所地特例EntityList(dbT1003DacList);
        }
    }

    /**
     * 処理対象の識別コードを保有する施設入退所のデータを取得する。
     *
     * @param 住民異動情報 UaFt200FindShikibetsuTaishoEntity
     * @param 被保険者台帳 DbV1001HihokenshaDaichoEntity
     * @param entity JuminIdoRendoShikakuTorokuEntity
     */
    @Transaction
    public void getGetShisetsu(UaFt200FindShikibetsuTaishoEntity 住民異動情報, DbV1001HihokenshaDaichoEntity 被保険者台帳,
            JuminIdoRendoShikakuTorokuEntity entity) {

        if (被保険者台帳.getHihokenshaNo() == null || 被保険者台帳.getHihokenshaNo().value().isEmpty()) {

            entity.set介護保険施設入退所EntityList(new ArrayList<DbT1004ShisetsuNyutaishoEntity>());
        } else {
            List<DbT1004ShisetsuNyutaishoEntity> dbT1004DacList = dbT1004Dac.get介護保険施設入退所(住民異動情報.getShikibetsuCode());
            entity.set介護保険施設入退所EntityList(dbT1004DacList);
        }
    }

    /**
     * 処理対象の識別コードを保有する被保険者台帳のデータを取得する。
     *
     * @param 住民異動情報 UaFt200FindShikibetsuTaishoEntity
     * @param 被保険者台帳 DbV1001HihokenshaDaichoEntity
     * @param entity JuminIdoRendoShikakuTorokuEntity
     */
    @Transaction
    public void getHihokensyadaicho(UaFt200FindShikibetsuTaishoEntity 住民異動情報, DbV1001HihokenshaDaichoEntity 被保険者台帳,
            JuminIdoRendoShikakuTorokuEntity entity) {
        if (被保険者台帳.getHihokenshaNo() == null || 被保険者台帳.getHihokenshaNo().value().isEmpty()) {

            entity.set被保険者台帳EntityList(new ArrayList<DbT1001HihokenshaDaichoEntity>());
        } else {

            List<DbT1001HihokenshaDaichoEntity> dbT1001DacList = dbT1001Dac.get被保険者台帳管理(住民異動情報.getShikibetsuCode());
            entity.set被保険者台帳EntityList(dbT1001DacList);
        }
    }

    /**
     * 適用除外者の転出、死亡、転入通知受理処理を行う。
     *
     * @param 住民異動情報 UaFt200FindShikibetsuTaishoEntity
     * @param pRM StoreConfigParamter
     * @param 資格喪失事由 RString
     * @param entity JuminIdoRendoShikakuTorokuEntity
     */
    public void shiKakuSousituJogai(UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            StoreConfigParamter pRM,
            RString 資格喪失事由,
            JuminIdoRendoShikakuTorokuEntity entity) {
        TemParamter temparamter = new TemParamter();
        List<DbT1002TekiyoJogaishaEntity> list適用除外者台帳 = new ArrayList<>();
        List<DbT1004ShisetsuNyutaishoEntity> list施設入退所 = new ArrayList<>();
        if (ShikakuSoshitsuJiyu.転出.getコード().equals(資格喪失事由)) {
            temparamter.setLc解除事由(JogaiKaijoJiyu.除外者転出.getコード());
            temparamter.setLc異動日(住民異動情報.getTenshutsuYoteiIdoYMD());
        } else if (ShikakuSoshitsuJiyu.死亡.getコード().equals(資格喪失事由)) {
            temparamter.setLc解除事由(JogaiKaijoJiyu.除外者死亡.getコード());
            temparamter.setLc異動日(住民異動情報.getShojoIdoYMD());
        } else if (ShikakuSoshitsuJiyu.その他.getコード().equals(資格喪失事由)) {
            temparamter.setLc解除事由(JogaiKaijoJiyu.除外者転出.getコード());
            temparamter.setLc異動日(住民異動情報.getTenshutsuKakuteiIdoYMD());
        }
        if (適用除外者喪失処理_適用除外者の検索(entity, list適用除外者台帳, list施設入退所)) {
            return;
        }
        if (適用除外者喪失処理_適用除外データ(資格喪失事由, pRM,
                住民異動情報, entity, temparamter,
                list適用除外者台帳, list施設入退所)) {
            return;
        }
        if (適用除外者喪失処理_施設入退所データ(資格喪失事由,
                entity, temparamter, list適用除外者台帳, list施設入退所)) {
            return;
        }
        if (適用除外者喪失処理_挿入レコード(資格喪失事由, 住民異動情報,
                entity, temparamter, list適用除外者台帳, list施設入退所)) {
            return;
        }
        戻り値の編集(entity, RString.EMPTY, RString.EMPTY, entity.get被保険者台帳EntityList(),
                entity.get適用除外者台帳EntityList(), entity.get他市町村住所地特例EntityList(),
                entity.get介護保険施設入退所EntityList());
    }

    @Transaction
    private boolean 適用除外者喪失処理_挿入レコード(RString 資格喪失事由,
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            JuminIdoRendoShikakuTorokuEntity entity,
            TemParamter temparamter,
            List<DbT1002TekiyoJogaishaEntity> 適用除外者台帳EntityList,
            List<DbT1004ShisetsuNyutaishoEntity> 介護保険施設入退所EntityList) {
        DbT1002TekiyoJogaishaEntity 適用除外者台帳Entity = 適用除外者台帳EntityList.get(0);
        DbT1004ShisetsuNyutaishoEntity 施設入退所Entity = 介護保険施設入退所EntityList.get(0);
        if (資格喪失事由.equals(ShikakuSoshitsuJiyu.転出.getコード())
                || 資格喪失事由.equals(ShikakuSoshitsuJiyu.死亡.getコード())) {
            DbT1002TekiyoJogaishaEntity 適用除外者 = 適用除外者_除外転出死亡(住民異動情報, 適用除外者台帳Entity, temparamter, entity);
            DbT1004ShisetsuNyutaishoEntity 施設入退所 = 施設入退所_除外転出死亡(施設入退所Entity, temparamter);
            if (nullToMin(適用除外者.getKaijoYMD()).isBefore(nullToMin(適用除外者.getTekiyoYMD()))) {
                戻り値の編集(entity, JuminRendoFuseigo.適用除外者_更新不能_適用日_解除日_不整合.getコード(),
                        RString.EMPTY, entity.get被保険者台帳EntityList(),
                        適用除外者台帳EntityList, entity.get他市町村住所地特例EntityList(), 介護保険施設入退所EntityList);
                return true;
            } else {
                適用除外者.setState(EntityDataState.Added);
                施設入退所.setState(EntityDataState.Modified);
                dbT1002Dac.save(適用除外者);
                dbT1004Dac.save(施設入退所);
            }
            戻り値の編集(entity, 不整合コード_9999, RString.EMPTY, entity.get被保険者台帳EntityList(),
                    適用除外者台帳EntityList, entity.get他市町村住所地特例EntityList(), 介護保険施設入退所EntityList);
            return true;
        }
        if (資格喪失事由.equals(ShikakuSoshitsuJiyu.その他.getコード())) {
            if (temparamter.getLc解除事由().equals(適用除外者台帳Entity.getTekiyoJogaikaijokaijoJiyuCode())) {
                DbT1002TekiyoJogaishaEntity 適用除外者 = 適用除外者_除外転入通知受理(適用除外者台帳Entity);
                適用除外者.setState(EntityDataState.Modified);
                dbT1002Dac.save(適用除外者);
            }
            DbT1002TekiyoJogaishaEntity 適用除外者 = 適用除外者_除外転入通知受理(住民異動情報,
                    適用除外者台帳Entity,
                    temparamter,
                    entity);
            DbT1004ShisetsuNyutaishoEntity 施設入退所 = 施設入退所_除外転入通知受理(施設入退所Entity, temparamter);
            if (nullToMin(適用除外者.getKaijoYMD()).isBefore(nullToMin(適用除外者.getTekiyoYMD()))) {
                戻り値の編集(entity, JuminRendoFuseigo.適用除外者_更新不能_適用日_解除日_不整合.getコード(), RString.EMPTY,
                        entity.get被保険者台帳EntityList(),
                        適用除外者台帳EntityList, entity.get他市町村住所地特例EntityList(), 介護保険施設入退所EntityList);
                return true;
            } else {
                適用除外者.setState(EntityDataState.Added);
                施設入退所.setState(EntityDataState.Modified);
                dbT1002Dac.save(適用除外者);
                dbT1004Dac.save(施設入退所);
            }
            戻り値の編集(entity, 不整合コード_9999, RString.EMPTY, entity.get被保険者台帳EntityList(),
                    適用除外者台帳EntityList, entity.get他市町村住所地特例EntityList(), 介護保険施設入退所EntityList);
            return true;
        }
        return false;
    }

    private DbT1004ShisetsuNyutaishoEntity 施設入退所_除外転入通知受理(DbT1004ShisetsuNyutaishoEntity 施設入退所Entity,
            TemParamter temparamter) {
        ShisetsuNyutaisho shisetsuNyutaisho = new ShisetsuNyutaisho(施設入退所Entity);
        ShisetsuNyutaishoBuilder builder = shisetsuNyutaisho.createBuilderForEdit();
        builder.set退所処理年月日(FlexibleDate.getNowDate());
        builder.set退所年月日(nullToEmpty(temparamter.getTmp異動日()));
        return builder.build().toEntity();
    }

    private DbT1002TekiyoJogaishaEntity 適用除外者_除外転入通知受理(UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            DbT1002TekiyoJogaishaEntity 適用除外者台帳Entity,
            TemParamter temparamter,
            JuminIdoRendoShikakuTorokuEntity entity) {
        RString 枝番 = getJogaiEdaNo(entity, 住民異動情報.getShikibetsuCode(), nullToMin(住民異動情報.getTenshutsuKakuteiIdoYMD()).plusDay(1));
        TekiyoJogaisha tekiyoJogaisha = new TekiyoJogaisha(住民異動情報.getShikibetsuCode(),
                nullToMin(住民異動情報.getTenshutsuKakuteiIdoYMD()).plusDay(1),
                枝番);
        TekiyoJogaishaBuilder builder = tekiyoJogaisha.createBuilderForEdit();
        builder.set異動事由コード(temparamter.getLc解除事由());
        builder.set市町村コード(適用除外者台帳Entity.getShichosonCode());
        builder.set適用除外適用事由コード(適用除外者台帳Entity.getTekiyoJogaiTekiyoJiyuCode());
        builder.set適用年月日(適用除外者台帳Entity.getTekiyoYMD());
        builder.set適用届出年月日(nullToEmpty(適用除外者台帳Entity.getTekiyoTodokedeYMD()));
        builder.set適用受付年月日(nullToEmpty(適用除外者台帳Entity.getTekiyoUketsukeYMD()));
        builder.set適用除外解除事由コード(temparamter.getLc解除事由());
        builder.set解除年月日(nullToEmpty(temparamter.getTmp異動日()));
        builder.set解除届出年月日(nullToEmpty(temparamter.getTmp届出日()));
        builder.set解除受付年月日(FlexibleDate.getNowDate());
        builder.set入所通知発行日(nullToEmpty(適用除外者台帳Entity.getNyushoTsuchiHakkoYMD()));
        builder.set退所通知発行日(nullToEmpty(適用除外者台帳Entity.getTaishoTsuchiHakkoYMD()));
        builder.set変更通知発行日(nullToEmpty(適用除外者台帳Entity.getHenkoTsuchiHakkoYMD()));
        builder.set論理削除フラグ(false);
        return builder.build().toEntity();
    }

    private DbT1002TekiyoJogaishaEntity 適用除外者_除外転入通知受理(DbT1002TekiyoJogaishaEntity 適用除外者台帳Entity) {
        TekiyoJogaisha tekiyoJogaisha = new TekiyoJogaisha(適用除外者台帳Entity);
        TekiyoJogaishaBuilder build = tekiyoJogaisha.createBuilderForEdit();
        build.set論理削除フラグ(true);
        return build.build().toEntity();
    }

    private DbT1004ShisetsuNyutaishoEntity 施設入退所_除外転出死亡(DbT1004ShisetsuNyutaishoEntity 施設入退所Entity, TemParamter temparamter) {
        ShisetsuNyutaisho shisetsuNyutaisho = new ShisetsuNyutaisho(施設入退所Entity);
        ShisetsuNyutaishoBuilder builder = shisetsuNyutaisho.createBuilderForEdit();
        builder.set退所処理年月日(FlexibleDate.getNowDate());
        builder.set退所年月日(nullToEmpty(temparamter.getTmp異動日()));
        return builder.build().toEntity();
    }

    private DbT1002TekiyoJogaishaEntity 適用除外者_除外転出死亡(
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            DbT1002TekiyoJogaishaEntity 適用除外者台帳Entity,
            TemParamter temparamter,
            JuminIdoRendoShikakuTorokuEntity entity) {
        RString 枝番 = getJogaiEdaNo(entity, 住民異動情報.getShikibetsuCode(), temparamter.getTmp異動日());
        TekiyoJogaisha tekiyoJogaisha = new TekiyoJogaisha(住民異動情報.getShikibetsuCode(),
                temparamter.getTmp異動日(),
                枝番);
        TekiyoJogaishaBuilder builder = tekiyoJogaisha.createBuilderForEdit();
        builder.set異動事由コード(temparamter.getLc解除事由());
        builder.set市町村コード(適用除外者台帳Entity.getShichosonCode());
        builder.set適用除外適用事由コード(適用除外者台帳Entity.getTekiyoJogaiTekiyoJiyuCode());
        builder.set適用年月日(nullToEmpty(適用除外者台帳Entity.getTekiyoYMD()));
        builder.set適用届出年月日(nullToEmpty(適用除外者台帳Entity.getTekiyoTodokedeYMD()));
        builder.set適用受付年月日(nullToEmpty(適用除外者台帳Entity.getTekiyoUketsukeYMD()));
        builder.set適用除外解除事由コード(temparamter.getLc解除事由());
        builder.set解除年月日(nullToEmpty(temparamter.getTmp異動日()));
        builder.set解除届出年月日(nullToEmpty(temparamter.getTmp届出日()));
        builder.set解除受付年月日(FlexibleDate.getNowDate());
        builder.set入所通知発行日(nullToEmpty(適用除外者台帳Entity.getNyushoTsuchiHakkoYMD()));
        builder.set退所通知発行日(nullToEmpty(適用除外者台帳Entity.getTaishoTsuchiHakkoYMD()));
        builder.set変更通知発行日(nullToEmpty(適用除外者台帳Entity.getHenkoTsuchiHakkoYMD()));
        builder.set論理削除フラグ(false);
        return builder.build().toEntity();
    }

    private FlexibleDate nullToEmpty(FlexibleDate date) {

        if (date == null) {

            return FlexibleDate.EMPTY;
        }
        return date;
    }

    private RString nullToEmpty(RString date) {

        if (date == null || date.isEmpty()) {

            return RString.EMPTY;
        }
        return date;
    }

    /**
     * 同一識別コード、同一異動日のデータにおける最大枝番＋１を取得する。
     *
     * @param entity JuminIdoRendoShikakuTorokuEntity
     * @param 識別コード ShikibetsuCode
     * @param 異動日 FlexibleDate
     * @return 枝番
     */
    public RString getJogaiEdaNo(JuminIdoRendoShikakuTorokuEntity entity,
            ShikibetsuCode 識別コード,
            FlexibleDate 異動日) {
        RString 枝番;
        List<DbT1002TekiyoJogaishaEntity> 適用除外者台帳EntityList = entity.get適用除外者台帳EntityList();
        List<DbT1002TekiyoJogaishaEntity> listEntity = new ArrayList<>();
        for (DbT1002TekiyoJogaishaEntity entity適用除外者台帳 : 適用除外者台帳EntityList) {
            if (識別コード.equals(entity適用除外者台帳.getShikibetsuCode())
                    && nullToMin(異動日).equals(nullToMin(entity適用除外者台帳.getIdoYMD()))) {
                listEntity.add(entity適用除外者台帳);
            }
        }
        if (!listEntity.isEmpty()) {
            Collections.sort(listEntity, new JuminIdoRendoShikakuSoshitsuShiboKyoTu.ComparatorsEdaNoTekiyoJogaisha());
            int edaBan = Integer.parseInt(listEntity.get(0).getEdaNo().toString());
            edaBan = edaBan + 1;
            枝番 = new RString(String.valueOf(String.format("%04d", edaBan)));
        } else {
            枝番 = new RString("0001");
        }
        return 枝番;
    }

    private boolean 適用除外者喪失処理_施設入退所データ(RString 資格喪失事由,
            JuminIdoRendoShikakuTorokuEntity entity,
            TemParamter temparamter,
            List<DbT1002TekiyoJogaishaEntity> 適用除外者台帳EntityList,
            List<DbT1004ShisetsuNyutaishoEntity> 介護保険施設入退所EntityList) {
        DbT1004ShisetsuNyutaishoEntity 施設入退所Entity = 介護保険施設入退所EntityList.get(0);
        DbT1002TekiyoJogaishaEntity 適用除外者台帳Entity = 適用除外者台帳EntityList.get(0);
        if (資格喪失事由.equals(ShikakuSoshitsuJiyu.転出.getコード())
                || 資格喪失事由.equals(ShikakuSoshitsuJiyu.死亡.getコード())) {
            if (施設入退所_資格喪失事由_転出OR死亡(施設入退所Entity, entity, temparamter,
                    資格喪失事由, 適用除外者台帳EntityList, 介護保険施設入退所EntityList)) {
                return true;
            }
        } else if (資格喪失事由.equals(ShikakuSoshitsuJiyu.その他.getコード())
                && temparamter.getLc解除事由().equals(適用除外者台帳Entity.getTekiyoJogaikaijokaijoJiyuCode())
                && nullToMin(temparamter.getLc異動日()).equals(nullToMin(施設入退所Entity.getTaishoYMD()))) {
            戻り値の編集(entity, RString.EMPTY, RString.EMPTY, entity.get被保険者台帳EntityList(),
                    entity.get適用除外者台帳EntityList(), entity.get他市町村住所地特例EntityList(),
                    entity.get介護保険施設入退所EntityList());
            return true;
        }
        return false;
    }

    private static class Comparators implements Comparator<DbT1004ShisetsuNyutaishoEntity>, Serializable {

        @Override
        public int compare(DbT1004ShisetsuNyutaishoEntity o1, DbT1004ShisetsuNyutaishoEntity o2) {
            return o2.getNyushoYMD().compareTo(o1.getNyushoYMD());
        }
    }

    private boolean 施設入退所_資格喪失事由_転出OR死亡(DbT1004ShisetsuNyutaishoEntity 施設入退所Entity,
            JuminIdoRendoShikakuTorokuEntity entity,
            TemParamter temparamter, RString 資格喪失事由,
            List<DbT1002TekiyoJogaishaEntity> 適用除外者台帳EntityList,
            List<DbT1004ShisetsuNyutaishoEntity> 介護保険施設入退所EntityList) {
        FlexibleDate 退所年月日 = 施設入退所Entity.getTaishoYMD();
        if (退所年月日 != null && !退所年月日.isEmpty()) {
            if (!temparamter.getLc異動日().equals(施設入退所Entity.getTaishoYMD())
                    && nullToMin(temparamter.getTmp異動日()).isBefore(nullToMin(施設入退所Entity.getTaishoYMD()))
                    && 資格喪失事由.equals(ShikakuSoshitsuJiyu.転出.getコード())) {
                戻り値の編集(entity, JuminRendoFuseigo.適用除外者_解除日_転出日_不整合.getコード(), RString.EMPTY,
                        entity.get被保険者台帳EntityList(), 適用除外者台帳EntityList,
                        entity.get他市町村住所地特例EntityList(), 介護保険施設入退所EntityList);
                return true;
            }
            if (!temparamter.getLc異動日().equals(施設入退所Entity.getTaishoYMD())
                    && nullToMin(temparamter.getTmp異動日()).isBefore(nullToMin(施設入退所Entity.getTaishoYMD()))
                    && 資格喪失事由.equals(ShikakuSoshitsuJiyu.死亡.getコード())) {
                戻り値の編集(entity, JuminRendoFuseigo.適用除外者_解除日_消除異動日_不整合.getコード(), RString.EMPTY,
                        entity.get被保険者台帳EntityList(), 適用除外者台帳EntityList,
                        entity.get他市町村住所地特例EntityList(), 介護保険施設入退所EntityList);
                return true;
            }
        }
        if ((退所年月日 == null || 退所年月日.isEmpty())
                && nullToMin(temparamter.getTmp異動日()).isBefore(nullToMin(施設入退所Entity.getNyushoYMD()))) {
            if (資格喪失事由.equals(ShikakuSoshitsuJiyu.転出.getコード())) {
                戻り値の編集(entity, JuminRendoFuseigo.適用除外者_解除日_転出日_不整合.getコード(), RString.EMPTY,
                        entity.get被保険者台帳EntityList(), 適用除外者台帳EntityList,
                        entity.get他市町村住所地特例EntityList(), 介護保険施設入退所EntityList);
                return true;
            }
            if (資格喪失事由.equals(ShikakuSoshitsuJiyu.死亡.getコード())) {
                戻り値の編集(entity, JuminRendoFuseigo.適用除外者_解除日_消除異動日_不整合.getコード(), RString.EMPTY,
                        entity.get被保険者台帳EntityList(), 適用除外者台帳EntityList,
                        entity.get他市町村住所地特例EntityList(), 介護保険施設入退所EntityList);
                return true;
            }
        }
        return false;
    }

    private boolean 適用除外者喪失処理_適用除外データ(RString 資格喪失事由,
            StoreConfigParamter pRM,
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            JuminIdoRendoShikakuTorokuEntity entity,
            TemParamter temparamter,
            List<DbT1002TekiyoJogaishaEntity> 適用除外者台帳EntityList,
            List<DbT1004ShisetsuNyutaishoEntity> 介護保険施設入退所EntityList
    ) {
        DbT1002TekiyoJogaishaEntity 適用除外者台帳 = 適用除外者台帳EntityList.get(0);
        DbT1004ShisetsuNyutaishoEntity 施設入退所Entity = 介護保険施設入退所EntityList.get(0);
        if ((資格喪失事由.equals(ShikakuSoshitsuJiyu.転出.getコード())
                || 資格喪失事由.equals(ShikakuSoshitsuJiyu.死亡.getコード()))
                && 資格喪失事由_転出OR死亡(適用除外者台帳, pRM, 住民異動情報, entity, temparamter,
                        資格喪失事由, 適用除外者台帳EntityList, 介護保険施設入退所EntityList)) {
            return true;
        }
        if (資格喪失事由.equals(ShikakuSoshitsuJiyu.その他.getコード())
                && 資格喪失事由_その他(適用除外者台帳, 住民異動情報, entity, pRM,
                        temparamter)) {
            return true;
        }
        FlexibleDate 解除年月日 = 適用除外者台帳.getKaijoYMD();
        FlexibleDate 退所年月日 = 施設入退所Entity.getTaishoYMD();
        if (解除年月日 != null && !解除年月日.isEmpty()
                && 退所年月日 != null && !退所年月日.isEmpty()) {
            if (資格喪失事由.endsWith(ShikakuSoshitsuJiyu.転出.getコード())) {
                戻り値の編集(entity, JuminRendoFuseigo.転出死亡_適用除外者_解除登録_施設入退所情報不整合.getコード(),
                        RString.EMPTY, entity.get被保険者台帳EntityList(),
                        適用除外者台帳EntityList, entity.get他市町村住所地特例EntityList(), 介護保険施設入退所EntityList);
                return true;
            } else if (資格喪失事由.endsWith(ShikakuSoshitsuJiyu.死亡.getコード())) {
                戻り値の編集(entity, JuminRendoFuseigo.転出死亡_適用除外者_入所中_施設入退所情報不整合.getコード(),
                        RString.EMPTY, entity.get被保険者台帳EntityList(),
                        適用除外者台帳EntityList, entity.get他市町村住所地特例EntityList(), 介護保険施設入退所EntityList);
                return true;
            }
        }
        return false;
    }

    private boolean 資格喪失事由_その他(
            DbT1002TekiyoJogaishaEntity 適用除外者台帳,
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            JuminIdoRendoShikakuTorokuEntity entity,
            StoreConfigParamter pRM,
            TemParamter temparamter) {
        if (temparamter.getLc解除事由().equals(適用除外者台帳.getTekiyoJogaikaijokaijoJiyuCode())) {
            FlexibleDate 解除届出年月日 = 適用除外者台帳.getKaijoTodokedeYMD();
            if (解除届出年月日 != null && 解除届出年月日.equals(住民異動情報.getShojoTodokedeYMD())) {
                戻り値の編集(entity, RString.EMPTY, RString.EMPTY, entity.get被保険者台帳EntityList(),
                        entity.get適用除外者台帳EntityList(), entity.get他市町村住所地特例EntityList(),
                        entity.get介護保険施設入退所EntityList());
                return true;
            }
        }
        if (nullToMin(pRM.get介護保険法施行日()).isBeforeOrEquals(nullToMin(temparamter.getLc異動日()))) {
            temparamter.setTmp異動日(temparamter.getLc異動日().plusDay(1));
        } else {
            temparamter.setTmp異動日(temparamter.getLc異動日());
        }
        FlexibleDate 適用届出年月日 = 適用除外者台帳.getTekiyoTodokedeYMD();
        if (適用届出年月日 == null || 適用届出年月日.isEmpty()) {
            temparamter.setTmp届出日(住民異動情報.getShojoTodokedeYMD());
        } else {
            temparamter.setTmp届出日(適用除外者台帳.getKaijoTodokedeYMD());
        }
        return false;
    }

    private boolean 資格喪失事由_転出OR死亡(DbT1002TekiyoJogaishaEntity 適用除外者台帳,
            StoreConfigParamter pRM,
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            JuminIdoRendoShikakuTorokuEntity entity,
            TemParamter temparamter,
            RString 資格喪失事由,
            List<DbT1002TekiyoJogaishaEntity> 適用除外者台帳EntityList,
            List<DbT1004ShisetsuNyutaishoEntity> 介護保険施設入退所EntityList) {
        RString 適用除外解除事由コード = 適用除外者台帳.getTekiyoJogaikaijokaijoJiyuCode();
        if (適用除外解除事由コード != null && !適用除外解除事由コード.isEmpty()) {
            if (nullToMin(pRM.get介護保険法施行日()).isBeforeOrEquals(nullToMin(temparamter.getLc異動日()))) {
                temparamter.setTmp異動日(temparamter.getLc異動日().plusDay(1));
            } else {
                temparamter.setTmp異動日(temparamter.getLc異動日());
            }
            temparamter.setTmp届出日(住民異動情報.getShojoTodokedeYMD());
            if (temparamter.getLc解除事由().equals(適用除外者台帳.getTekiyoJogaikaijokaijoJiyuCode())
                    && temparamter.getTmp異動日().equals(適用除外者台帳.getKaijoYMD())
                    && nullToMin(temparamter.getTmp届出日()).equals(nullToMin(適用除外者台帳.getKaijoTodokedeYMD()))) {
                戻り値の編集(entity, RString.EMPTY, RString.EMPTY, entity.get被保険者台帳EntityList(),
                        entity.get適用除外者台帳EntityList(), entity.get他市町村住所地特例EntityList(),
                        entity.get介護保険施設入退所EntityList());
                return true;
            } else {
                if (nullToMin(temparamter.getTmp異動日()).isBefore(nullToMin(適用除外者台帳.getKaijoYMD()))) {
                    適用除外者喪失処理_適用除外データ_戻り値の編集(資格喪失事由, entity, 適用除外者台帳EntityList, 介護保険施設入退所EntityList);
                    return true;
                }
            }
        }
        return false;
    }

    private void 適用除外者喪失処理_適用除外データ_戻り値の編集(RString 資格喪失事由,
            JuminIdoRendoShikakuTorokuEntity entity,
            List<DbT1002TekiyoJogaishaEntity> 適用除外者台帳EntityList,
            List<DbT1004ShisetsuNyutaishoEntity> 介護保険施設入退所EntityList) {
        if (資格喪失事由.equals(ShikakuSoshitsuJiyu.転出.getコード())) {
            戻り値の編集(entity, JuminRendoFuseigo.適用除外者_解除日_転出日_不整合.getコード(), RString.EMPTY,
                    entity.get被保険者台帳EntityList(), 適用除外者台帳EntityList,
                    entity.get他市町村住所地特例EntityList(), 介護保険施設入退所EntityList);
        } else {
            戻り値の編集(entity, JuminRendoFuseigo.適用除外者_解除日_消除異動日_不整合.getコード(), RString.EMPTY,
                    entity.get被保険者台帳EntityList(), 適用除外者台帳EntityList,
                    entity.get他市町村住所地特例EntityList(), 介護保険施設入退所EntityList);
        }
    }

    private boolean 適用除外者喪失処理_適用除外者の検索(JuminIdoRendoShikakuTorokuEntity entity,
            List<DbT1002TekiyoJogaishaEntity> list適用除外者台帳,
            List<DbT1004ShisetsuNyutaishoEntity> list施設入退所) {
        DbT1002TekiyoJogaishaEntity 適用除外者台帳Entity = null;
        if (entity.get適用除外者台帳EntityList() != null && !entity.get適用除外者台帳EntityList().isEmpty()) {

            適用除外者台帳Entity = entity.get適用除外者台帳EntityList().get(0);
        }
        DbT1004ShisetsuNyutaishoEntity 施設入退所Entity
                = searchShisetsu(entity.get介護保険施設入退所EntityList(), DaichoType.適用除外者.getコード());
        if (適用除外者台帳Entity == null && 施設入退所Entity == null) {
            戻り値の編集(entity, RString.EMPTY, RString.EMPTY,
                    entity.get被保険者台帳EntityList(), entity.get適用除外者台帳EntityList(),
                    entity.get他市町村住所地特例EntityList(), entity.get介護保険施設入退所EntityList());
            return true;
        } else if (適用除外者台帳Entity != null && 施設入退所Entity == null) {
            list適用除外者台帳.add(適用除外者台帳Entity);
            戻り値の編集(entity, JuminRendoFuseigo.転出死亡_適用除外者_解除登録_施設入退所情報不整合.getコード(),
                    RString.EMPTY, entity.get被保険者台帳EntityList(), list適用除外者台帳, entity.get他市町村住所地特例EntityList(), null);
            return true;
        } else if (適用除外者台帳Entity == null && 施設入退所Entity != null) {
            list施設入退所.add(施設入退所Entity);
            戻り値の編集(entity, JuminRendoFuseigo.転出死亡_適用除外者_入所中_施設入退所情報不整合.getコード(),
                    RString.EMPTY, entity.get被保険者台帳EntityList(), null, entity.get他市町村住所地特例EntityList(), list施設入退所);
            return true;
        }
        list適用除外者台帳.add(適用除外者台帳Entity);
        list施設入退所.add(施設入退所Entity);
        return false;
    }

    private FlexibleDate nullToMin(FlexibleDate date) {

        if (date == null || date.isEmpty()) {

            return FlexibleDate.MIN;
        }
        return date;
    }

    private static class ComparatorsEdaNo implements Comparator<DbT1001HihokenshaDaichoEntity>, Serializable {

        @Override
        public int compare(DbT1001HihokenshaDaichoEntity o1, DbT1001HihokenshaDaichoEntity o2) {
            return o2.getEdaNo().compareTo(o1.getEdaNo());
        }
    }

    private static class ComparatorsEdaNoTekiyoJogaisha implements Comparator<DbT1002TekiyoJogaishaEntity>, Serializable {

        @Override
        public int compare(DbT1002TekiyoJogaishaEntity o1, DbT1002TekiyoJogaishaEntity o2) {
            return o2.getEdaNo().compareTo(o1.getEdaNo());
        }
    }
}
