/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.juminidorendoshikakutoroku;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dba.business.core.fuseigolist.FuseigoListHenshu;
import jp.co.ndensan.reams.db.dba.entity.db.relate.juminidorendoshikakutoroku.JuminIdoRendoShikakuTorokuEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.juminidorendotennyu.JuminIdoRendoTennyuEntity;
import jp.co.ndensan.reams.db.dba.entity.euc.juminidorendoshikakutoroku.FuseigoListCsvEntity;
import jp.co.ndensan.reams.db.dba.service.core.juminidorendoshikakusoshitsu.JuminIdoRendoShikakuSoshitsu;
import jp.co.ndensan.reams.db.dba.service.core.juminidorendotennyu.JuminIdoRendoTennyuManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbV1001HihokenshaDaichoAliveDac;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1002TekiyoJogaishaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1003TashichosonJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1010TennyushutsuHoryuTaishoshaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1011TenshutsuHoryuTaishoshaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1002TekiyoJogaishaDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1003TashichosonJushochiTokureiDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1004ShisetsuNyutaishoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1009ShikakuShutokuJogaishaDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1010TennyushutsuHoryuTaishoshaDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1011TenshutsuHoryuTaishoshaDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7023RendoHoryuTokuteiJushoDac;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.AgeCalculator;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.DateOfBirthFactory;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.IDateOfBirth;
import jp.co.ndensan.reams.ua.uax.business.core.idoruiseki.ShikibetsuTaishoIdoJoho;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.business.core.zenkokujusho.ZenkokuJushoItem;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.service.core.zenkokujusho.ZenkokuJushoFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.BanchiCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 住民異動連動資格登録（制御処理）取得Businessクラスです。
 *
 * @reamsid_L DBA-1410-011 yaodongsheng
 */
public class JuminIdoRendoShikakuToroku {

    private static final RString 処理区分 = new RString("処理区分");
    private static final RString 転入保留作成事由 = new RString("転入保留作成事由コード");
    private static final RString 転出保留作成事由 = new RString("転出保留作成事由コード");
    private static final RString 転入 = new RString("10");
    private static final RString 転出 = new RString("20");
    private static final RString 死亡 = new RString("21");
    private static final RString 転居 = new RString("30");
    private static final RString 転入通知受理 = new RString("45");
    private static final RString 被保険者区分2号 = new RString("2");
    private static final RString 不整合0310 = new RString("0310");
    private static final RString 処理対象外 = new RString("9");
    private static final RString 処理対象 = new RString("0");
    private static final RString 市町村サーバ無し = new RString("2");
    private static final RString 処理なし = new RString("0");
    private static final RString 処理区分_転入通知受理 = new RString("1");
    private static final RString 広域内転入 = new RString("1");
    private static final RString 広域外転入 = new RString("2");
    private static final RString 広域内転出 = new RString("1");
    private static final RString 広域外転出 = new RString("2");
    private static final RString 転入保留作成事由_特定住所への転入 = new RString("0006");
    private static final RString 転入保留作成事由_広域内転入 = new RString("0001");
    private static final RString 自動 = new RString("1");
    private static final int LENGTH4 = 4;
    private static final int LENGTH5 = 5;
    private final DbV1001HihokenshaDaichoAliveDac dbv1001dac;
    private final DbT1001HihokenshaDaichoDac dbt1001dac;
    private final DbT1010TennyushutsuHoryuTaishoshaDac dbt1010dac;
    private final DbT1009ShikakuShutokuJogaishaDac dbt1009dac;
    private final DbT1011TenshutsuHoryuTaishoshaDac dbt1011dac;
    private final DbT7023RendoHoryuTokuteiJushoDac dbt7023dac;
    private final DbT1003TashichosonJushochiTokureiDac dbt1003dac;
    private final DbT1002TekiyoJogaishaDac dbt1002dac;
    private final DbT1004ShisetsuNyutaishoDac dbt1004dac;

    /**
     * コンストラクタです。
     */
    public JuminIdoRendoShikakuToroku() {
        this.dbv1001dac = InstanceProvider.create(DbV1001HihokenshaDaichoAliveDac.class);
        this.dbt1001dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
        this.dbt1010dac = InstanceProvider.create(DbT1010TennyushutsuHoryuTaishoshaDac.class);
        this.dbt1009dac = InstanceProvider.create(DbT1009ShikakuShutokuJogaishaDac.class);
        this.dbt1011dac = InstanceProvider.create(DbT1011TenshutsuHoryuTaishoshaDac.class);
        this.dbt7023dac = InstanceProvider.create(DbT7023RendoHoryuTokuteiJushoDac.class);
        this.dbt1003dac = InstanceProvider.create(DbT1003TashichosonJushochiTokureiDac.class);
        this.dbt1002dac = InstanceProvider.create(DbT1002TekiyoJogaishaDac.class);
        this.dbt1004dac = InstanceProvider.create(DbT1004ShisetsuNyutaishoDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param dbv1001dac dbv1001dac
     * @param dbt1001dac dbt1001dac
     * @param dbt1010dac dbt1010dac
     * @param dbt1009dac dbt1009dac
     * @param dbt1011dac dbt1011dac
     * @param dbt7023dac dbt7023dac
     * @param dbt1003dac dbt1003dac
     * @param dbt1002dac dbt1002dac
     * @param dbt1004dac dbt1004dac
     */
    JuminIdoRendoShikakuToroku(
            DbV1001HihokenshaDaichoAliveDac dbv1001dac,
            DbT1001HihokenshaDaichoDac dbt1001dac,
            DbT1010TennyushutsuHoryuTaishoshaDac dbt1010dac,
            DbT1009ShikakuShutokuJogaishaDac dbt1009dac,
            DbT1011TenshutsuHoryuTaishoshaDac dbt1011dac,
            DbT7023RendoHoryuTokuteiJushoDac dbt7023dac,
            DbT1003TashichosonJushochiTokureiDac dbt1003dac,
            DbT1002TekiyoJogaishaDac dbt1002dac,
            DbT1004ShisetsuNyutaishoDac dbt1004dac
    ) {
        this.dbv1001dac = dbv1001dac;
        this.dbt1001dac = dbt1001dac;
        this.dbt1010dac = dbt1010dac;
        this.dbt1009dac = dbt1009dac;
        this.dbt1011dac = dbt1011dac;
        this.dbt7023dac = dbt7023dac;
        this.dbt1003dac = dbt1003dac;
        this.dbt1002dac = dbt1002dac;
        this.dbt1004dac = dbt1004dac;
    }

    /**
     * 住民異動連動共通です。
     *
     * @param 住民異動情報 住民異動情報
     * @param csvWriter csvWriter
     */
    public void juminIdoRendoKyotsu(UaFt200FindShikibetsuTaishoEntity 住民異動情報, CsvWriter<FuseigoListCsvEntity> csvWriter) {
        requireNonNull(住民異動情報);
        RString 介護保険施行日 = DbBusinessConfig.get(ConfigNameDBU.介護保険法情報_介護保険施行日, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        RString 広域システム構成 = DbBusinessConfig.get(ConfigNameDBU.保険者情報_広域システム構成, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        RString 自動資格異動連動区分 = DbBusinessConfig.get(ConfigNameDBU.広域保険者運用設定_広域内転入異動_自動資格異動連動区分,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        RString 第１号被保険者到達基準年齢 = DbBusinessConfig.get(ConfigNameDBU.年齢到達基準_第１号被保険者到達基準年齢,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        RString 第２号被保険者到達基準年齢 = DbBusinessConfig.get(ConfigNameDBU.年齢到達基準_第２号被保険者到達基準年齢,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        RString 異動事由コード = 住民異動情報.getIdoJiyuCode();
        JuminIdoRendoShikakuTorokuEntity tennyuEntity = new JuminIdoRendoShikakuTorokuEntity();
        if (isShoriTaisho(住民異動情報)) {
            List<DbV1001HihokenshaDaichoEntity> dbv1001EntityList = dbv1001dac
                    .selectBy識別コード(住民異動情報.getShikibetsuCode());
            DbV1001HihokenshaDaichoEntity dbv1001Entity = null;
            if (!dbv1001EntityList.isEmpty()) {
                dbv1001Entity = dbv1001EntityList.get(0);
            }
            if (転入.equals(異動事由コード)) {
                tennyuEntity = tennyu(住民異動情報, dbv1001Entity,
                        介護保険施行日, 第２号被保険者到達基準年齢, 広域システム構成, 自動資格異動連動区分);
            } else if (転出.equals(異動事由コード) || 死亡.equals(異動事由コード) || 転入通知受理.equals(異動事由コード)) {
                tennyuEntity = sonotaIdo(住民異動情報, dbv1001Entity, 介護保険施行日, 広域システム構成);
            } else if (転居.equals(異動事由コード)) {
                tennyuEntity = tenkyo(住民異動情報, dbv1001Entity, 介護保険施行日, 第１号被保険者到達基準年齢);
            }
            if (!RString.isNullOrEmpty(tennyuEntity.get不整合コード())) {
                csvWriter.writeLine(new FuseigoListHenshu().setEucCsvEntity(tennyuEntity.get不整合コード(), dbv1001Entity, 住民異動情報));
                AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, toPersonalData(dbv1001Entity, 住民異動情報));
            }
            set被保険者台帳(tennyuEntity);
            RString 転入保留作成事由コード = tennyuEntity.get転入保留作成事由コード();
            if (!RString.isNullOrEmpty(転入保留作成事由コード)) {
                set転入保留対象者(住民異動情報, 転入保留作成事由コード);
            }
            RString 転出保留作成事由コード = tennyuEntity.get転出保留作成事由コード();
            if (!RString.isNullOrEmpty(転出保留作成事由コード)) {
                set転出保留対象者(住民異動情報, 転出保留作成事由コード);
            }
            set適用除外者(tennyuEntity);
            set他市町村住所地特例(tennyuEntity);
            set介護保険施設入退所(tennyuEntity);
        }
    }

    private void set介護保険施設入退所(JuminIdoRendoShikakuTorokuEntity tennyuEntity) {
        if (tennyuEntity.get介護保険施設入退所EntityList() != null) {
            for (DbT1004ShisetsuNyutaishoEntity dbt1004Entity : tennyuEntity.get介護保険施設入退所EntityList()) {
                dbt1004Entity.setRirekiNo(getMaxRirekiNo(dbt1004dac.get最大履歴番号(dbt1004Entity.getShikibetsuCode()).getRirekiNo()));
                dbt1004Entity.setState(EntityDataState.Added);
                dbt1004dac.save(dbt1004Entity);
            }
        }
    }

    private void set他市町村住所地特例(JuminIdoRendoShikakuTorokuEntity tennyuEntity) {
        if (tennyuEntity.get他市町村住所地特例EntityList() != null) {
            for (DbT1003TashichosonJushochiTokureiEntity dbt1003Entity : tennyuEntity.get他市町村住所地特例EntityList()) {
                dbt1003Entity.setEdaNo(getMaxRenban(dbt1003dac.get最大枝番(dbt1003Entity.getShikibetsuCode(), dbt1003Entity.getIdoYMD()).getEdaNo()));
                dbt1003Entity.setState(EntityDataState.Added);
                dbt1003dac.save(dbt1003Entity);
            }
        }
    }

    private void set適用除外者(JuminIdoRendoShikakuTorokuEntity tennyuEntity) {
        if (tennyuEntity.get適用除外者台帳EntityList() != null) {
            for (DbT1002TekiyoJogaishaEntity tekiyojogai : tennyuEntity.get適用除外者台帳EntityList()) {
                tekiyojogai.setEdaNo(getMaxRenban(
                        dbt1002dac.selectMaxEdaNoByKey(tekiyojogai.getShikibetsuCode(), tekiyojogai.getIdoYMD()).getEdaNo()));
                tekiyojogai.setState(EntityDataState.Added);
                dbt1002dac.save(tekiyojogai);
            }
        }
    }

    private void set被保険者台帳(JuminIdoRendoShikakuTorokuEntity tennyuEntity) {
        if (tennyuEntity.get被保険者台帳EntityList() != null) {
            for (DbT1001HihokenshaDaichoEntity entity : tennyuEntity.get被保険者台帳EntityList()) {
                entity.setEdaNo(getMaxRenban(dbt1001dac.selectMaxEdaNoByKey(entity.getHihokenshaNo(), entity.getIdoYMD()).getEdaNo()));
                entity.setState(EntityDataState.Added);
                dbt1001dac.save(entity);
            }
        }
    }

    private void set転入保留対象者(UaFt200FindShikibetsuTaishoEntity 住民異動情報, RString 転入保留作成事由コード) {
        DbT1010TennyushutsuHoryuTaishoshaEntity dbt1010Entity = new DbT1010TennyushutsuHoryuTaishoshaEntity();
        ShikibetsuCode shikibetsuCode = 住民異動情報.getShikibetsuCode();
        if (shikibetsuCode != null) {
            dbt1010Entity.setShikibetsuCode(shikibetsuCode);
        }
        DbT1010TennyushutsuHoryuTaishoshaEntity entity = dbt1010dac.get転入保留対象者の履歴番号Max(住民異動情報.getShikibetsuCode());
        dbt1010Entity.setRirekiNo(getMaxRirekiNo(entity.getRirekiNo()));
        LasdecCode 現全国地方公共団体コード = 住民異動情報.getGenLasdecCode();
        if (現全国地方公共団体コード != null) {
            dbt1010Entity.setShichosonCode(現全国地方公共団体コード);
        }
        dbt1010Entity.setSakuseiJiyuCode(転入保留作成事由コード);
        dbt1010Entity.setSetaiCode(住民異動情報.getSetaiCode());
        dbt1010Entity.setJuminShubetsuCode(住民異動情報.getJuminShubetsuCode());
        dbt1010Entity.setJuminJotaiCode(住民異動情報.getJuminJotaiCode());
        RString 住民種別コード = 住民異動情報.getJuminShubetsuCode();
        if (JuminShubetsu.日本人.getCode().equals(住民種別コード) || JuminShubetsu.住登外個人_日本人.getCode().equals(住民種別コード)) {
            AtenaMeisho 漢字氏名 = 住民異動情報.getKanjiShimei();
            if (漢字氏名 != null) {
                dbt1010Entity.setAtenaShimei(漢字氏名);
            }
            AtenaKanaMeisho カナ氏名 = 住民異動情報.getKanaShimei();
            if (カナ氏名 != null) {
                dbt1010Entity.setAtenaKanaShimei(カナ氏名);
            }
        } else if (JuminShubetsu.外国人.getCode().equals(住民種別コード) || JuminShubetsu.住登外個人_外国人.getCode().equals(住民種別コード)) {
            AtenaMeisho 外国人氏名 = 住民異動情報.getGaikokujinShimei();
            if (外国人氏名 != null) {
                dbt1010Entity.setAtenaShimei(外国人氏名);
            }
            AtenaKanaMeisho 外国人カナ氏名 = 住民異動情報.getGaikokujinKanaShimei();
            if (外国人カナ氏名 != null) {
                dbt1010Entity.setAtenaKanaShimei(外国人カナ氏名);
            }
        }
        dbt1010Entity.setSeinengappiYMD(住民異動情報.getSeinengappiYMD());
        dbt1010Entity.setSeibetsuCode(住民異動情報.getSeibetsuCode());
        dbt1010Entity.setIdoJiyuCode(住民異動情報.getIdoJiyuCode());
        dbt1010Entity.setTorokuIdoYMD(住民異動情報.getTorokuIdoYMD());
        dbt1010Entity.setTorokuTodokedeYMD(住民異動情報.getTorokuTodokedeYMD());
        dbt1010Entity.setShojoIdoYMD(住民異動情報.getShojoIdoYMD());
        dbt1010Entity.setShojoIdoTodokedeYMD(住民異動情報.getShojoTodokedeYMD());
        dbt1010Entity.setTenshutsuYoteiIdoYMD(住民異動情報.getTenshutsuYoteiIdoYMD());
        dbt1010Entity.setTenshutsuKakuteiIdoYMD(住民異動情報.getTenshutsuKakuteiIdoYMD());
        dbt1010Entity.setTenshutsuKakuteiIdoTsuchiYMD(住民異動情報.getTenshutsuKakuteiTsuchiYMD());
        ZenkokuJushoCode 全国地方公共団体コード = 住民異動情報.getZenkokuJushoCode();
        if (全国地方公共団体コード != null) {
            dbt1010Entity.setZenkokuJushoCode(全国地方公共団体コード.value());
        }
        dbt1010Entity.setJusho(住民異動情報.getJusho());
        dbt1010Entity.setBanchi(住民異動情報.getBanchi());
        dbt1010Entity.setKatagaki(住民異動情報.getKatagaki());
        dbt1010Entity.setMaeJushoZenkokuJushoCode(住民異動情報.getTennyumaeZenkokuJushoCode());
        dbt1010Entity.setMaeJushoJusho(住民異動情報.getTennyumaeJusho());
        dbt1010Entity.setMaeJushoBanchi(住民異動情報.getTennyumaeBanchi());
        dbt1010Entity.setMaeJushoKatagaki(住民異動情報.getTennyumaeKatagaki());
        dbt1010Entity.setState(EntityDataState.Added);
        dbt1010dac.save(dbt1010Entity);
    }

    private void set転出保留対象者(UaFt200FindShikibetsuTaishoEntity 住民異動情報, RString 転出保留作成事由コード) {
        DbT1011TenshutsuHoryuTaishoshaEntity dbt1011Entity = new DbT1011TenshutsuHoryuTaishoshaEntity();
        dbt1011Entity.setShikibetsuCode(住民異動情報.getShikibetsuCode());
        dbt1011Entity.setShikibetsuCode(住民異動情報.getShikibetsuCode());
        DbT1011TenshutsuHoryuTaishoshaEntity entity = dbt1011dac.get転出保留対象者の履歴番号Max(住民異動情報.getShikibetsuCode());
        dbt1011Entity.setRirekiNo(getMaxRirekiNo(entity.getRirekiNo()));
        dbt1011Entity.setShichosonCode(住民異動情報.getGenLasdecCode());
        dbt1011Entity.setSakuseiJiyuCode(転出保留作成事由コード);
        dbt1011Entity.setSetaiCode(住民異動情報.getSetaiCode());
        dbt1011Entity.setJuminShubetsuCode(住民異動情報.getJuminShubetsuCode());
        dbt1011Entity.setJuminJotaiCode(住民異動情報.getJuminJotaiCode());
        RString 住民種別コード = 住民異動情報.getJuminShubetsuCode();
        if (JuminShubetsu.日本人.getCode().equals(住民種別コード) || JuminShubetsu.住登外個人_日本人.getCode().equals(住民種別コード)) {
            AtenaMeisho 漢字氏名 = 住民異動情報.getKanjiShimei();
            if (漢字氏名 != null) {
                dbt1011Entity.setAtenaShimei(漢字氏名);
            }
            AtenaKanaMeisho カナ氏名 = 住民異動情報.getKanaShimei();
            if (カナ氏名 != null) {
                dbt1011Entity.setAtenaKanaShimei(カナ氏名);
            }
        } else if (JuminShubetsu.外国人.getCode().equals(住民種別コード) || JuminShubetsu.住登外個人_外国人.getCode().equals(住民種別コード)) {
            AtenaMeisho 外国人氏名 = 住民異動情報.getGaikokujinShimei();
            if (外国人氏名 != null) {
                dbt1011Entity.setAtenaShimei(外国人氏名);
            }
            AtenaKanaMeisho 外国人カナ氏名 = 住民異動情報.getGaikokujinKanaShimei();
            if (外国人カナ氏名 != null) {
                dbt1011Entity.setAtenaKanaShimei(外国人カナ氏名);
            }
        }
        dbt1011Entity.setSeinengappiYMD(住民異動情報.getSeinengappiYMD());
        dbt1011Entity.setSeibetsuCode(住民異動情報.getSeibetsuCode());
        dbt1011Entity.setIdoJiyuCode(住民異動情報.getIdoJiyuCode());
        dbt1011Entity.setTorokuIdoYMD(住民異動情報.getTorokuIdoYMD());
        dbt1011Entity.setTorokuTodokedeYMD(住民異動情報.getTorokuTodokedeYMD());
        dbt1011Entity.setShojoIdoYMD(住民異動情報.getShojoIdoYMD());
        dbt1011Entity.setShojoTodokedeYMD(住民異動情報.getShojoTodokedeYMD());
        dbt1011Entity.setTenshutsuYoteiIdoYMD(住民異動情報.getTenshutsuYoteiIdoYMD());
        dbt1011Entity.setTenshutsuKakuteiIdoYMD(住民異動情報.getTenshutsuKakuteiIdoYMD());
        dbt1011Entity.setTenshutsuKakuteiTsuchiYMD(住民異動情報.getTenshutsuKakuteiTsuchiYMD());
        ZenkokuJushoCode 全国地方公共団体コード = 住民異動情報.getZenkokuJushoCode();
        if (全国地方公共団体コード != null) {
            dbt1011Entity.setZenkokuJushoCode(全国地方公共団体コード.value());
        }
        dbt1011Entity.setJusho(住民異動情報.getJusho());
        dbt1011Entity.setBanchi(住民異動情報.getBanchi());
        dbt1011Entity.setKatagaki(住民異動情報.getKatagaki());
        dbt1011Entity.setTenshutsuYoteiZenkokuJushoCode(住民異動情報.getTenshutsuYoteiZenkokuJushoCode());
        dbt1011Entity.setTenshutsuYoteiJusho(住民異動情報.getTenshutsuYoteiJusho());
        dbt1011Entity.setTenshutsuYoteiBanchi(住民異動情報.getTenshutsuYoteiBanchi());
        dbt1011Entity.setTenshutsuYoteiKatagaki(住民異動情報.getTenshutsuYoteiKatagaki());
        dbt1011Entity.setTenshutsuKakuteiZenkokuJushoCode(住民異動情報.getTenshutsuKakuteiZenkokuJushoCode());
        dbt1011Entity.setTenshutsuKakuteiJusho(住民異動情報.getTenshutsuKakuteiJusho());
        dbt1011Entity.setTenshutsuKakuteiBanchi(住民異動情報.getTenshutsuKakuteiBanchi());
        dbt1011Entity.setTenshutsuKakuteiKatagaki(住民異動情報.getTenshutsuKakuteiKatagaki());
        dbt1011Entity.setState(EntityDataState.Added);
        dbt1011dac.save(dbt1011Entity);
    }

    private boolean isShoriTaisho(UaFt200FindShikibetsuTaishoEntity 住民異動情報) {
        requireNonNull(住民異動情報);
        ShikibetsuCode 識別コード = 住民異動情報.getShikibetsuCode();
        if (転入.equals(住民異動情報.getIdoJiyuCode())) {
            return dbt1010dac.selectBy識別コード(識別コード).isEmpty()
                    && dbt1009dac.selectBy識別コード(識別コード).isEmpty();
        } else if (転出.equals(住民異動情報.getIdoJiyuCode())) {
            return dbt1011dac.selectBy識別コード(識別コード).isEmpty();
        } else if (転居.equals(住民異動情報.getIdoJiyuCode())) {
            List<DbV1001HihokenshaDaichoEntity> dbv1001EntityList = dbv1001dac.selectBy識別コード(識別コード);
            if (dbv1001EntityList.isEmpty()) {
                return false;
            }
            DbV1001HihokenshaDaichoEntity entity = dbv1001EntityList.get(0);
            FlexibleDate 異動YMD = 住民異動情報.getIdoYMD();
            if (entity.getShikakuShutokuYMD() == null || entity.getShikakuShutokuYMD().isEmpty()
                    || (異動YMD != null && 異動YMD.isBefore(entity.getShikakuShutokuYMD()))) {
                return false;
            }
            if (entity.getShikakuSoshitsuYMD() != null && !entity.getShikakuSoshitsuYMD().isEmpty()
                    && entity.getShikakuSoshitsuYMD().isBeforeOrEquals(異動YMD)) {
                return false;
            }
        }
        return true;
    }

    private JuminIdoRendoShikakuTorokuEntity tennyu(
            UaFt200FindShikibetsuTaishoEntity 住民異動情報, DbV1001HihokenshaDaichoEntity 被保険者台帳, RString 介護保険施行日,
            RString 第２号被保険者到達基準年齢, RString 広域システム構成, RString 自動資格異動連動区分) {
        requireNonNull(住民異動情報);
        requireNonNull(被保険者台帳);
        requireNonNull(介護保険施行日);
        requireNonNull(第２号被保険者到達基準年齢);
        requireNonNull(広域システム構成);
        requireNonNull(自動資格異動連動区分);
        JuminIdoRendoShikakuTorokuEntity entity = new JuminIdoRendoShikakuTorokuEntity();
        FlexibleDate torokuIdoYMD = 住民異動情報.getTorokuIdoYMD();
        FlexibleDate torokuTodokedeYMD = 住民異動情報.getTorokuTodokedeYMD();
        if ((torokuIdoYMD == null || torokuIdoYMD.isEmpty())
                && (torokuTodokedeYMD == null || torokuTodokedeYMD.isEmpty())) {
            entity.set不整合コード(不整合0310);
            return entity;
        }
        FlexibleDate seinengappiYMD = 住民異動情報.getSeinengappiYMD();
        RString juminJotaiCode = 住民異動情報.getJuminJotaiCode();
        FlexibleDate shojoIdoYMD = 住民異動情報.getShojoIdoYMD();
        if (has不整合コード(torokuIdoYMD, seinengappiYMD, shojoIdoYMD, juminJotaiCode,
                介護保険施行日, 第２号被保険者到達基準年齢)) {
            entity.set不整合コード(RString.EMPTY);
            return entity;
        }
        if (介護保険施行日 != null && !介護保険施行日.isEmpty() && torokuIdoYMD != null
                && !torokuIdoYMD.isEmpty() && torokuIdoYMD.isBefore(new FlexibleDate(介護保険施行日))) {
            住民異動情報.setTorokuIdoYMD(new FlexibleDate(介護保険施行日));
        }
        entity = checkTekiyoJogaisha(住民異動情報);
        if (処理対象外.equals(entity.get処理区分())) {
            return entity;
        }
        entity = checkTaTokureisha(住民異動情報);
        if (処理対象外.equals(entity.get処理区分())) {
            return entity;
        }
        Map<String, RString> 転入処理区分 = getTennyuShoriKubun(住民異動情報, 広域システム構成, 自動資格異動連動区分);
        if (処理なし.equals(転入処理区分.get(処理区分.toString()))) {
            entity.set不整合コード(RString.EMPTY);
            entity.set転入保留作成事由コード(転入処理区分.get(転入保留作成事由.toString()));
            return entity;
        } else if (広域内転入.equals(転入処理区分.get(処理区分.toString()))) {
            JuminIdoRendoTennyuEntity idorendoTennyuEntity = new JuminIdoRendoTennyuManager().execute広域内転入(住民異動情報);
            entity.set不整合コード(idorendoTennyuEntity.getデータ不整合理由());
            entity.set転入保留作成事由コード(idorendoTennyuEntity.get作成事由());
            entity.set被保険者台帳EntityList(idorendoTennyuEntity.get被保険者台帳list());
        } else if (広域外転入.equals(転入処理区分.get(処理区分.toString()))) {
            JuminIdoRendoTennyuEntity idorendoTennyuEntity = new JuminIdoRendoTennyuManager().execute転入処理(住民異動情報, 被保険者台帳);
            entity.set不整合コード(idorendoTennyuEntity.getデータ不整合理由());
            entity.set転入保留作成事由コード(idorendoTennyuEntity.get作成事由());
            entity.set被保険者台帳EntityList(idorendoTennyuEntity.get被保険者台帳list());
        }
        return entity;
    }

    private boolean has不整合コード(FlexibleDate torokuIdoYMD, FlexibleDate seinengappiYMD, FlexibleDate shojoIdoYMD,
            RString juminJotaiCode, RString 介護保険施行日, RString 第２号被保険者到達基準年齢) {
        return torokuIdoYMD != null && !torokuIdoYMD.isEmpty() && seinengappiYMD != null && !seinengappiYMD.isEmpty()
                && juminJotaiCode != null && shojoIdoYMD != null && !shojoIdoYMD.isEmpty() && 介護保険施行日 != null
                && Integer.valueOf(getNenrei(torokuIdoYMD, seinengappiYMD, juminJotaiCode, shojoIdoYMD,
                                介護保険施行日).toString()) < (Integer.valueOf(第２号被保険者到達基準年齢.toString()));
    }

    private Map<String, RString> getTennyuShoriKubun(UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            RString 広域システム構成, RString 自動資格異動連動区分) {
        requireNonNull(住民異動情報);
        requireNonNull(広域システム構成);
        requireNonNull(自動資格異動連動区分);
        Map<String, RString> map = new HashMap<>();
        map.put(処理区分.toString(), RString.EMPTY);
        map.put(転入保留作成事由.toString(), RString.EMPTY);
        if (市町村サーバ無し.equals(広域システム構成)) {
            ZenkokuJushoCode zenkokuJushoCode = 住民異動情報.getTennyumaeZenkokuJushoCode();
            if (自動.equals(自動資格異動連動区分) && zenkokuJushoCode != null) {
                set自動資格異動連動区分(getShichosonCode(zenkokuJushoCode), map);
            } else {
                map.put(処理区分.toString(), 処理なし);
                set非自動資格異動連動区分(住民異動情報, map);
            }
        } else {
            map.put(処理区分.toString(), 広域外転入);
        }
        return map;
    }

    private void set自動資格異動連動区分(LasdecCode 市町村コード, Map<String, RString> map) {
        if (市町村コード == null || 市町村コード.isEmpty()) {
            map.put(処理区分.toString(), 広域外転入);
        } else {
            if (!KoikiShichosonJohoFinder.createInstance().shichosonCodeYoriShichosonJoho(市町村コード).records().isEmpty()) {
                map.put(処理区分.toString(), 広域内転入);
            } else {
                map.put(処理区分.toString(), 広域外転入);
            }
        }
    }

    private void set非自動資格異動連動区分(UaFt200FindShikibetsuTaishoEntity 住民異動情報, Map<String, RString> map) {
        LasdecCode genLasdecCode = 住民異動情報.getGenLasdecCode();
        ChoikiCode choikiCode = 住民異動情報.getChoikiCode();
        BanchiCode banchiCode1 = 住民異動情報.getBanchiCode1();
        BanchiCode banchiCode2 = 住民異動情報.getBanchiCode2();
        BanchiCode banchiCode3 = 住民異動情報.getBanchiCode3();
        if (genLasdecCode != null && choikiCode != null && banchiCode1 != null && banchiCode2 != null
                && banchiCode3 != null && isRendoHoryuTokuteiJusho(genLasdecCode, choikiCode, banchiCode1, banchiCode2, banchiCode3)) {
            map.put(転入保留作成事由.toString(), 転入保留作成事由_特定住所への転入);
        } else {
            map.put(転入保留作成事由.toString(), 転入保留作成事由_広域内転入);
        }
    }

    /**
     * 連動保留特定住所判定です。
     *
     * @param 現全国地方公共団体コード 市町村コード
     * @param 町域コード 住所コード
     * @param 番地コード1 番地コード１
     * @param 番地コード2 番地コード2
     * @param 番地コード3 番地コード3
     * @return 判定結果
     */
    public boolean isRendoHoryuTokuteiJusho(LasdecCode 現全国地方公共団体コード, ChoikiCode 町域コード,
            BanchiCode 番地コード1, BanchiCode 番地コード2, BanchiCode 番地コード3) {
        requireNonNull(現全国地方公共団体コード);
        requireNonNull(町域コード);
        requireNonNull(番地コード1);
        requireNonNull(番地コード2);
        requireNonNull(番地コード3);
        return !dbt7023dac.select連動保留特定住所マスタ(現全国地方公共団体コード,
                町域コード, 番地コード1, 番地コード2, 番地コード3).isEmpty();
    }

    private RString getNenrei(FlexibleDate 登録異動年月日,
            FlexibleDate 生年月日,
            RString 住民状態コード,
            FlexibleDate 消除異動年月日,
            RString 介護保険施行日) {
        requireNonNull(登録異動年月日);
        requireNonNull(生年月日);
        requireNonNull(住民状態コード);
        requireNonNull(消除異動年月日);
        requireNonNull(介護保険施行日);
        FlexibleDate システム日付 = FlexibleDate.getNowDate();
        FlexibleDate 介保施行日 = new FlexibleDate(介護保険施行日);
        FlexibleDate 基準日;
        if (登録異動年月日.isBefore(介保施行日)) {
            if (システム日付.isBeforeOrEquals(介保施行日)) {
                基準日 = 介保施行日;
            } else {
                基準日 = システム日付;
            }
        } else {
            if (システム日付.isBeforeOrEquals(登録異動年月日)) {
                基準日 = 登録異動年月日;
            } else {
                基準日 = システム日付;
            }
        }
        IDateOfBirth dateofbirth = DateOfBirthFactory.createInstance(生年月日);
        AgeCalculator agecalculator = new AgeCalculator(dateofbirth, JuminJotai.toValue(住民状態コード),
                消除異動年月日, 基準日);
        return agecalculator.get年齢();

    }

    private JuminIdoRendoShikakuTorokuEntity checkTekiyoJogaisha(UaFt200FindShikibetsuTaishoEntity 住民異動情報) {
        requireNonNull(住民異動情報);
        JuminIdoRendoShikakuTorokuEntity entity = new JuminIdoRendoShikakuTorokuEntity();
        entity.set不整合コード(RString.EMPTY);
        entity.set処理区分(RString.EMPTY);
        if (!dbt1002dac.select適用除外者チェック1(
                住民異動情報.getTorokuIdoYMD(), 住民異動情報.getShikibetsuCode()).isEmpty()) {
            entity.set処理区分(処理対象外);
            return entity;
        }
        if (!dbt1002dac.select適用除外者チェック2(
                住民異動情報.getTorokuIdoYMD(), 住民異動情報.getShikibetsuCode()).isEmpty()) {
            entity.set不整合コード(new RString("0034"));
            entity.set処理区分(処理対象外);
            return entity;
        }
        entity.set処理区分(処理対象);
        return entity;
    }

    private JuminIdoRendoShikakuTorokuEntity checkTaTokureisha(UaFt200FindShikibetsuTaishoEntity 住民異動情報) {
        requireNonNull(住民異動情報);
        JuminIdoRendoShikakuTorokuEntity entity = new JuminIdoRendoShikakuTorokuEntity();
        entity.set不整合コード(RString.EMPTY);
        entity.set処理区分(RString.EMPTY);
        if (!dbt1003dac.select他特例者チェック1(
                住民異動情報.getTorokuIdoYMD(), 住民異動情報.getShikibetsuCode()).isEmpty()) {
            entity.set処理区分(処理対象外);
            return entity;
        }
        if (!dbt1003dac.select他特例者チェック2(
                住民異動情報.getTorokuIdoYMD(), 住民異動情報.getShikibetsuCode()).isEmpty()) {
            entity.set不整合コード(new RString("0034"));
            entity.set処理区分(処理対象外);
            return entity;
        }
        entity.set処理区分(処理対象);
        return entity;
    }

    private JuminIdoRendoShikakuTorokuEntity sonotaIdo(UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            DbV1001HihokenshaDaichoEntity 被保険者台帳, RString 介護保険施行日, RString 広域システム構成) {
        requireNonNull(住民異動情報);
        requireNonNull(被保険者台帳);
        requireNonNull(介護保険施行日);
        requireNonNull(広域システム構成);
        JuminIdoRendoShikakuTorokuEntity entity = new JuminIdoRendoShikakuTorokuEntity();
        if (!dbt1010dac.selectBy識別コード(住民異動情報.getShikibetsuCode()).isEmpty()) {
            RString idoJiyuCode = 住民異動情報.getIdoJiyuCode();
            idoJiyuCodeHandan(entity, idoJiyuCode);
            return entity;
        }
        RString 不整合コード = getSonota不整合コード(住民異動情報);
        if (!不整合コード.isEmpty()) {
            entity.set不整合コード(不整合コード);
            return entity;
        }
        return setTennyuEntity(住民異動情報, 介護保険施行日, 広域システム構成, 被保険者台帳);
    }

    private RString getSonota不整合コード(UaFt200FindShikibetsuTaishoEntity 住民異動情報) {
        FlexibleDate tenshutsuYoteiIdoYMD = 住民異動情報.getTenshutsuYoteiIdoYMD();
        FlexibleDate shojoTodokedeYMD = 住民異動情報.getShojoTodokedeYMD();
        FlexibleDate shojoIdoYMD = 住民異動情報.getShojoIdoYMD();
        FlexibleDate tenshutsuKakuteiIdoYMD = 住民異動情報.getTenshutsuKakuteiIdoYMD();
        if (転出.equals(住民異動情報.getIdoJiyuCode())
                && (tenshutsuYoteiIdoYMD == null || tenshutsuYoteiIdoYMD.isEmpty())
                && (shojoTodokedeYMD == null || shojoTodokedeYMD.isEmpty())) {
            return new RString("0311");
        }
        if (死亡.equals(住民異動情報.getIdoJiyuCode()) && (shojoIdoYMD == null || shojoIdoYMD.isEmpty())
                && (shojoTodokedeYMD == null || shojoTodokedeYMD.isEmpty())) {
            return new RString("0312");
        }
        if (転入通知受理.equals(住民異動情報.getIdoJiyuCode())
                && (tenshutsuKakuteiIdoYMD == null || tenshutsuKakuteiIdoYMD.isEmpty())
                && (shojoTodokedeYMD == null || shojoTodokedeYMD.isEmpty())) {
            return new RString("0313");
        }
        return RString.EMPTY;
    }

    private void idoJiyuCodeHandan(JuminIdoRendoShikakuTorokuEntity entity, RString idoJiyuCode) {
        if (転出.equals(idoJiyuCode)) {
            entity.set不整合コード(new RString("0031"));
        } else if (死亡.equals(idoJiyuCode)) {
            entity.set不整合コード(new RString("0032"));
        } else if (転入通知受理.equals(idoJiyuCode)) {
            entity.set不整合コード(new RString("0033"));
        }
    }

    private JuminIdoRendoShikakuTorokuEntity setTennyuEntity(UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            RString 介護保険施行日, RString 広域システム構成, DbV1001HihokenshaDaichoEntity 被保険者台帳) {
        JuminIdoRendoShikakuTorokuEntity entity = new JuminIdoRendoShikakuTorokuEntity();
        set住民異動情報(住民異動情報, 介護保険施行日);
        JuminIdoRendoShikakuSoshitsu juminIdoRendoShikakuSoshitsu = new JuminIdoRendoShikakuSoshitsu();
        if (転出.equals(住民異動情報.getIdoJiyuCode())) {
            Map<String, RString> map = getTenshutsuShoriKubun(住民異動情報, 広域システム構成);
            if (広域内転出.equals(map.get(処理区分.toString())) || 広域外転出.equals(map.get(処理区分.toString()))) {
                entity = juminIdoRendoShikakuSoshitsu.getTenshutsu(住民異動情報, 被保険者台帳);
                map.get(処理区分.toString());
            }
        } else if (死亡.equals(住民異動情報.getIdoJiyuCode())) {
            FlexibleDate shojoTodokedeYMD = 住民異動情報.getShojoTodokedeYMD();
            FlexibleDate shojoIdoYMD = 住民異動情報.getShojoIdoYMD();
            if (shojoTodokedeYMD != null && !shojoTodokedeYMD.isEmpty() && (shojoIdoYMD == null || shojoIdoYMD.isEmpty())) {
                住民異動情報.setShojoIdoYMD(住民異動情報.getShojoTodokedeYMD());
            } else if (shojoIdoYMD != null && !shojoIdoYMD.isEmpty() && (shojoTodokedeYMD == null || shojoTodokedeYMD.isEmpty())) {
                住民異動情報.setShojoTodokedeYMD(住民異動情報.getShojoIdoYMD());
            }
            entity = juminIdoRendoShikakuSoshitsu.getShiBo(住民異動情報, 被保険者台帳);
        } else if (転入通知受理.equals(住民異動情報.getIdoJiyuCode())
                && 処理区分_転入通知受理.equals(getTennyuTsuchiJuriShoriKubun(住民異動情報, 広域システム構成))) {
            住民異動情報.setShojoTodokedeYMD(住民異動情報.getShojoIdoYMD());
            entity = juminIdoRendoShikakuSoshitsu.getTennyuTsuchiJuri(住民異動情報, 被保険者台帳);
        }
        return entity;
    }

    private void set住民異動情報(UaFt200FindShikibetsuTaishoEntity 住民異動情報, RString 介護保険施行日) {
        FlexibleDate 介保施行日 = new FlexibleDate(介護保険施行日);
        FlexibleDate torokuIdoYMD = 住民異動情報.getTorokuIdoYMD();
        FlexibleDate shojoIdoYMD = 住民異動情報.getShojoIdoYMD();
        FlexibleDate tenshutsuYoteiIdoYMD = 住民異動情報.getTenshutsuYoteiIdoYMD();
        FlexibleDate tenshutsuKakuteiIdoYMD = 住民異動情報.getTenshutsuKakuteiIdoYMD();
        if (torokuIdoYMD != null && !torokuIdoYMD.isEmpty() && torokuIdoYMD.isBefore(介保施行日)) {
            住民異動情報.setTorokuIdoYMD(new FlexibleDate(介護保険施行日));
        }
        if (shojoIdoYMD != null && !shojoIdoYMD.isEmpty() && shojoIdoYMD.isBefore(介保施行日)) {
            住民異動情報.setShojoIdoYMD(new FlexibleDate(介護保険施行日));
        }
        if (tenshutsuYoteiIdoYMD != null && !tenshutsuYoteiIdoYMD.isEmpty()
                && tenshutsuYoteiIdoYMD.isBefore(介保施行日)) {
            住民異動情報.setTenshutsuYoteiIdoYMD(new FlexibleDate(介護保険施行日));
        }
        if (tenshutsuKakuteiIdoYMD != null && !tenshutsuKakuteiIdoYMD.isEmpty()
                && tenshutsuKakuteiIdoYMD.isBefore(介保施行日)) {
            住民異動情報.setTenshutsuKakuteiIdoYMD(new FlexibleDate(介護保険施行日));
        }
    }

    private Map<String, RString> getTenshutsuShoriKubun(UaFt200FindShikibetsuTaishoEntity 住民異動情報, RString 広域システム構成) {
        requireNonNull(住民異動情報);
        requireNonNull(広域システム構成);
        if (住民異動情報 == null || 広域システム構成 == null) {
            throw new NullPointerException();
        }
        Map<String, RString> map = new HashMap<>();
        map.put(処理区分.toString(), RString.EMPTY);
        map.put(転出保留作成事由.toString(), RString.EMPTY);
        if (市町村サーバ無し.equals(広域システム構成)) {
            住民異動情報.getTenshutsuYoteiZenkokuJushoCode();
            ZenkokuJushoCode tenshutsuYoteiZenkokuJushoCode = 住民異動情報.getTenshutsuYoteiZenkokuJushoCode();
            LasdecCode 市町村コード = LasdecCode.EMPTY;
            if (tenshutsuYoteiZenkokuJushoCode != null) {
                市町村コード = getShichosonCode(tenshutsuYoteiZenkokuJushoCode);
            }
            if (市町村コード == null || 市町村コード.isEmpty()) {
                map.put(処理区分.toString(), 広域外転出);
            } else {
                if (!KoikiShichosonJohoFinder.createInstance().shichosonCodeYoriShichosonJoho(市町村コード).records().isEmpty()) {
                    map.put(処理区分.toString(), 広域内転出);
                } else {
                    map.put(処理区分.toString(), 広域外転出);
                }
            }
        } else {
            map.put(処理区分.toString(), 広域外転出);
        }
        return map;
    }

    private RString getTennyuTsuchiJuriShoriKubun(UaFt200FindShikibetsuTaishoEntity 住民異動情報, RString 広域システム構成) {
        requireNonNull(住民異動情報);
        requireNonNull(広域システム構成);
        ZenkokuJushoCode tenshutsuYoteiZenkokuJushoCode = 住民異動情報.getTenshutsuKakuteiZenkokuJushoCode();
        if (市町村サーバ無し.equals(広域システム構成) && !KoikiShichosonJohoFinder.createInstance().shichosonCodeYoriShichosonJoho(
                getShichosonCode(tenshutsuYoteiZenkokuJushoCode)).records().isEmpty()) {
            return 処理なし;
        }
        return 処理区分_転入通知受理;
    }

    private RString getNenreiIdoJiyu(UaFt200FindShikibetsuTaishoEntity 住民異動情報, RString 介護保険施行日) {
        requireNonNull(住民異動情報);
        requireNonNull(介護保険施行日);
        RString 異動事由コード = 住民異動情報.getIdoJiyuCode();
        FlexibleDate 基準日 = FlexibleDate.EMPTY;
        if (転出.equals(異動事由コード)) {
            FlexibleDate tenshutsuYoteiIdoYMD = 住民異動情報.getTenshutsuYoteiIdoYMD();
            if (tenshutsuYoteiIdoYMD != null && !tenshutsuYoteiIdoYMD.isEmpty()) {
                基準日 = tenshutsuYoteiIdoYMD.plusDay(1);
            }
        } else if (死亡.equals(異動事由コード)) {
            FlexibleDate shojoIdoYMD = 住民異動情報.getShojoIdoYMD();
            if (shojoIdoYMD != null && !shojoIdoYMD.isEmpty()) {
                基準日 = shojoIdoYMD.plusDay(1);
            }
        } else if (転入通知受理.equals(異動事由コード)) {
            基準日 = 住民異動情報.getTenshutsuKakuteiIdoYMD();
        } else if (転居.equals(異動事由コード)) {
            基準日 = 住民異動情報.getIdoYMD();
        }
        FlexibleDate 介保施行日 = new FlexibleDate(介護保険施行日);
        if (基準日 != null && 基準日.isBefore(介保施行日)) {
            基準日 = 介保施行日;
        }
        IDateOfBirth dateofbirth = DateOfBirthFactory.createInstance(住民異動情報.getSeinengappiYMD());
        AgeCalculator agecalculator = new AgeCalculator(dateofbirth, JuminJotai.toValue(住民異動情報.getJuminJotaiCode()),
                住民異動情報.getShojoIdoYMD(), 基準日);
        return agecalculator.get年齢();
    }

    private JuminIdoRendoShikakuTorokuEntity tenkyo(
            UaFt200FindShikibetsuTaishoEntity 住民異動情報, DbV1001HihokenshaDaichoEntity 被保険者台帳, RString 介護保険施行日,
            RString 第１号被保険者到達基準年齢) {
        requireNonNull(住民異動情報);
        requireNonNull(被保険者台帳);
        requireNonNull(介護保険施行日);
        requireNonNull(第１号被保険者到達基準年齢);
        JuminIdoRendoShikakuTorokuEntity tennyuEntity = new JuminIdoRendoShikakuTorokuEntity();
        List<DbT1001HihokenshaDaichoEntity> 被保険者台帳EntityList = new ArrayList<>();
        FlexibleDate 異動YMD = 住民異動情報.getIdoYMD();
        FlexibleDate 届出YMD = 住民異動情報.getTodokedeYMD();
        if ((異動YMD == null || 異動YMD.isEmpty()) && (届出YMD == null || 届出YMD.isEmpty())) {
            tennyuEntity.set不整合コード(new RString("0401"));
            return tennyuEntity;
        }
        if (異動YMD == null || 異動YMD.isEmpty()) {
            住民異動情報.setIdoYMD(届出YMD);
        }
        if (届出YMD == null || 届出YMD.isEmpty()) {
            住民異動情報.setTodokedeYMD(異動YMD);
        }
        RString 不整合コード = getTenkyo不整合コード(住民異動情報, 被保険者台帳);
        if (!不整合コード.isEmpty()) {
            tennyuEntity.set不整合コード(不整合コード);
            return tennyuEntity;
        }
        RString 年齢 = getNenreiIdoJiyu(住民異動情報, 介護保険施行日);
        int nenrei = Integer.valueOf(年齢.toString());
        jp.co.ndensan.reams.db.dba.business.core.juminidorendoshikakutoroku.JuminIdoRendoShikakuToroku 資格変更
                = new jp.co.ndensan.reams.db.dba.business.core.juminidorendoshikakutoroku.JuminIdoRendoShikakuToroku();
        if (被保険者区分2号.equals(被保険者台帳.getHihokennshaKubunCode())
                && nenrei >= Integer.valueOf(第１号被保険者到達基準年齢.toString())) {
            IDateOfBirth dateofbirth = DateOfBirthFactory.createInstance(住民異動情報.getSeinengappiYMD());
            AgeCalculator agecalculator = new AgeCalculator(dateofbirth, JuminJotai.toValue(住民異動情報.getJuminJotaiCode()),
                    住民異動情報.getShojoIdoYMD());
            if (agecalculator.get年齢到達日(Integer.valueOf(第１号被保険者到達基準年齢.toString())).isBeforeOrEquals(住民異動情報.getIdoYMD())) {
                被保険者台帳EntityList.add(setDbt1001(資格変更.totatsu1go(住民異動情報, 被保険者台帳)));
                被保険者台帳EntityList.add(setDbt1001(資格変更.tenkyo(住民異動情報, 被保険者台帳)));
            } else {
                被保険者台帳EntityList.add(setDbt1001(資格変更.tenkyo(住民異動情報, 被保険者台帳)));
                被保険者台帳EntityList.add(setDbt1001(資格変更.totatsu1go(住民異動情報, 被保険者台帳)));
            }
        } else {
            被保険者台帳EntityList.add(setDbt1001(資格変更.tenkyo(住民異動情報, 被保険者台帳)));
        }
        tennyuEntity.set被保険者台帳EntityList(被保険者台帳EntityList);
        tennyuEntity.set不整合コード(RString.EMPTY);
        return tennyuEntity;
    }

    private RString getTenkyo不整合コード(UaFt200FindShikibetsuTaishoEntity 住民異動情報, DbV1001HihokenshaDaichoEntity 被保険者台帳) {
        FlexibleDate 資格喪失日 = 被保険者台帳.getShikakuSoshitsuYMD();
        FlexibleDate 資格取得日 = 被保険者台帳.getShikakuShutokuYMD();
        FlexibleDate idoYMD = 住民異動情報.getIdoYMD();
        if (資格喪失日 != null && !資格喪失日.isEmpty() && idoYMD != null && 資格取得日.isBeforeOrEquals(idoYMD) && idoYMD.isBefore(資格喪失日)) {
            return new RString("0402");
        }
        return RString.EMPTY;
    }

    private LasdecCode getShichosonCode(ZenkokuJushoCode 全国住所コード) {
        requireNonNull(全国住所コード);
        if (全国住所コード.value().length() < LENGTH5) {
            return LasdecCode.EMPTY;
        }
        ZenkokuJushoItem 全国住所 = ZenkokuJushoFinderFactory.createInstance().get全国住所By全国住所コード(全国住所コード);
        if (全国住所 == null) {
            return LasdecCode.EMPTY;
        }
        return 全国住所.get地方公共団体コード();
    }

    private PersonalData toPersonalData(DbV1001HihokenshaDaichoEntity dbv1001Entity, UaFt200FindShikibetsuTaishoEntity 住民異動情報) {
        RString 被保険者番号 = RString.EMPTY;
        if (dbv1001Entity != null && dbv1001Entity.getHihokenshaNo() != null) {
            被保険者番号 = dbv1001Entity.getHihokenshaNo().value();
        }
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(new RString("0003")), new RString("被保険者番号"),
                被保険者番号);
        return PersonalData.of(住民異動情報.getShikibetsuCode() == null ? ShikibetsuCode.EMPTY : 住民異動情報.getShikibetsuCode(), expandedInfo);
    }

    private RString getMaxRenban(RString renban) {
        if (RString.isNullOrEmpty(renban)) {
            return new RString("0001");
        }
        return new RString(Integer.valueOf(renban.toString()) + 1).padZeroToLeft(LENGTH4);
    }

    private int getMaxRirekiNo(int rirekiNo) {
        if (rirekiNo == 0) {
            return 1;
        } else {
            return ++rirekiNo;
        }
    }

    private DbT1001HihokenshaDaichoEntity setDbt1001(DbV1001HihokenshaDaichoEntity entity) {
        DbT1001HihokenshaDaichoEntity dbT1001Entity = new DbT1001HihokenshaDaichoEntity();
        dbT1001Entity.setHihokenshaNo(entity.getHihokenshaNo());
        dbT1001Entity.setIdoYMD(entity.getIdoYMD());
        dbT1001Entity.setEdaNo(entity.getEdaNo());
        dbT1001Entity.setIdoJiyuCode(entity.getIdoJiyuCode());
        dbT1001Entity.setShichosonCode(entity.getShichosonCode());
        dbT1001Entity.setShikibetsuCode(entity.getShikibetsuCode());
        dbT1001Entity.setShikakuShutokuJiyuCode(entity.getShikakuShutokuJiyuCode());
        dbT1001Entity.setShikakuShutokuYMD(entity.getShikakuShutokuYMD());
        dbT1001Entity.setShikakuShutokuTodokedeYMD(entity.getShikakuShutokuTodokedeYMD());
        dbT1001Entity.setIchigoShikakuShutokuYMD(entity.getIchigoShikakuShutokuYMD());
        dbT1001Entity.setHihokennshaKubunCode(entity.getHihokennshaKubunCode());
        dbT1001Entity.setShikakuSoshitsuJiyuCode(entity.getShikakuSoshitsuJiyuCode());
        dbT1001Entity.setShikakuSoshitsuYMD(entity.getShikakuSoshitsuYMD());
        dbT1001Entity.setShikakuSoshitsuTodokedeYMD(entity.getShikakuSoshitsuTodokedeYMD());
        dbT1001Entity.setShikakuHenkoJiyuCode(entity.getShikakuHenkoJiyuCode());
        dbT1001Entity.setShikakuHenkoYMD(entity.getShikakuHenkoYMD());
        dbT1001Entity.setShikakuHenkoTodokedeYMD(entity.getShikakuHenkoTodokedeYMD());
        dbT1001Entity.setJushochitokureiTekiyoJiyuCode(entity.getJushochitokureiTekiyoJiyuCode());
        dbT1001Entity.setJushochitokureiTekiyoYMD(entity.getJushochitokureiTekiyoYMD());
        dbT1001Entity.setJushochitokureiTekiyoTodokedeYMD(entity.getJushochitokureiTekiyoTodokedeYMD());
        dbT1001Entity.setJushochitokureiKaijoJiyuCode(entity.getJushochitokureiKaijoJiyuCode());
        dbT1001Entity.setJushochitokureiKaijoYMD(entity.getJushochitokureiKaijoYMD());
        dbT1001Entity.setJushochitokureiKaijoTodokedeYMD(entity.getJushochitokureiKaijoTodokedeYMD());
        dbT1001Entity.setJushochiTokureiFlag(entity.getJushochiTokureiFlag());
        dbT1001Entity.setKoikinaiJushochiTokureiFlag(entity.getKoikinaiJushochiTokureiFlag());
        dbT1001Entity.setKoikinaiTokureiSochimotoShichosonCode(entity.getKoikinaiTokureiSochimotoShichosonCode());
        dbT1001Entity.setKyuShichosonCode(entity.getKyuShichosonCode());
        dbT1001Entity.setLogicalDeletedFlag(entity.getLogicalDeletedFlag());
        return dbT1001Entity;
    }

    /**
     * 住民異動情報です。
     *
     * @param 宛名識別対象 ShikibetsuTaishoIdoJoho
     * @param csvWriter CsvWriter<FuseigoListCsvEntity>
     */
    public void to住民異動情報(ShikibetsuTaishoIdoJoho 宛名識別対象, CsvWriter<FuseigoListCsvEntity> csvWriter) {
        UaFt200FindShikibetsuTaishoEntity 住民異動情報 = new UaFt200FindShikibetsuTaishoEntity();
        住民異動情報.setShikibetsuCode(宛名識別対象.get識別コード());
        住民異動情報.setGenLasdecCode(宛名識別対象.get現地方公共団体コード());
        住民異動情報.setKyuLasdecCode(宛名識別対象.get旧地方公共団体コード());
        住民異動情報.setKyuLasdecCodeRenban(宛名識別対象.get旧地方公共団体コード連番());
        住民異動情報.setGyomuCode(宛名識別対象.get業務コード());
        住民異動情報.setRirekiNo(宛名識別対象.get履歴番号());
        住民異動情報.setCurrentFlag(宛名識別対象.is最新());
        住民異動情報.setJuminShubetsuCode(宛名識別対象.get住民種別コード());
        住民異動情報.setKojinNo(宛名識別対象.get個人番号());
        住民異動情報.setShoriYMD(宛名識別対象.get処理年月日());
        住民異動情報.setIdoJiyuCode(宛名識別対象.get異動事由コード());
        住民異動情報.setIdoYMD(宛名識別対象.get異動年月日());
        住民異動情報.setTodokedeJiyuCode(宛名識別対象.get届出事由コード());
        住民異動情報.setTodokedeYMD(宛名識別対象.get届出年月日());
        住民異動情報.setIdoRiyuCode(宛名識別対象.get異動理由コード().value());
        住民異動情報.setKannaiKangaiKubun(宛名識別対象.get管内管外区分());
        住民異動情報.setYubinNo(宛名識別対象.get郵便番号());
        住民異動情報.setChoikiCode(宛名識別対象.get町域コード());
        住民異動情報.setZenkokuJushoCode(宛名識別対象.get全国住所コード());
        住民異動情報.setJusho(宛名識別対象.get住所());
        住民異動情報.setBanchiCode1(宛名識別対象.get番地コード１());
        住民異動情報.setBanchiCode2(宛名識別対象.get番地コード２());
        住民異動情報.setBanchiCode3(宛名識別対象.get番地コード３());
        住民異動情報.setBanchiCode4(宛名識別対象.get番地コード４());
        住民異動情報.setBanchi(宛名識別対象.get番地());
        住民異動情報.setKatagaki(宛名識別対象.get方書());
        住民異動情報.setKatagakiInjiFlag(宛名識別対象.is方書印字());
        住民異動情報.setGyoseikuCode(宛名識別対象.get行政区コード());
        住民異動情報.setGyoseikuName(宛名識別対象.get行政区());
        住民異動情報.setChikuCode1(宛名識別対象.get地区の分類コード１());
        住民異動情報.setChikuCode2(宛名識別対象.get地区の分類コード２());
        住民異動情報.setChikuCode3(宛名識別対象.get地区の分類コード３());
        住民異動情報.setChikuName1(宛名識別対象.get地区の分類１());
        住民異動情報.setChikuName2(宛名識別対象.get地区の分類２());
        住民異動情報.setChikuName3(宛名識別対象.get地区の分類３());
        住民異動情報.setShogakkokuCode(宛名識別対象.get小学校区コード());
        住民異動情報.setShogakkokuName(宛名識別対象.get小学校区());
        住民異動情報.setChugakkokuCode(宛名識別対象.get中学校区コード());
        住民異動情報.setChugakkokuName(宛名識別対象.get中学校区());
        住民異動情報.setTohyokuCode(宛名識別対象.get投票区コード());
        住民異動情報.setTohyokuName(宛名識別対象.get投票区());
        住民異動情報.setJuminJotaiCode(宛名識別対象.get住民状態コード());
        住民異動情報.setSetaiCode(宛名識別対象.get世帯コード());
        住民異動情報.setSeinengappiYMD(宛名識別対象.get生年月日());
        住民異動情報.setSeinengappiFushoKubun(宛名識別対象.get生年月日不詳区分());
        住民異動情報.setSeibetsuCode(宛名識別対象.get性別コード());
        住民異動情報.setTsuzukigaraCode(宛名識別対象.get続柄コード());
        住民異動情報.setTsuzukigara(宛名識別対象.get続柄());
        住民異動情報.setKazokuNo(宛名識別対象.get家族番号());
        住民異動情報.setJuminhyoHyojijun(宛名識別対象.get住民票表示順());
        住民異動情報.setKikaYMD(宛名識別対象.get帰化年月日());
        住民異動情報.setKanjiShimei(宛名識別対象.get漢字氏名());
        住民異動情報.setKanaShimei(宛名識別対象.getカナ氏名());
        住民異動情報.setJuminhyoCode(宛名識別対象.get住民票コード());
        住民異動情報.setHonsekiZenkokuJushoCode(宛名識別対象.get本籍全国住所コード());
        住民異動情報.setHonsekiJusho(宛名識別対象.get本籍住所());
        住民異動情報.setHonsekiBanchi(宛名識別対象.get本籍番地());
        住民異動情報.setHittosha(宛名識別対象.get筆頭者());
        住民異動情報.setGaikokujinShimei(宛名識別対象.get外国人氏名());
        住民異動情報.setGaikokujinHeikimei(宛名識別対象.get外国人併記名());
        住民異動情報.setGaikokujinKanaShimei(宛名識別対象.get外国人カナ氏名());
        住民異動情報.setTsushomei(宛名識別対象.get通称名());
        住民異動情報.setShimeiRiyoKubun(宛名識別対象.get氏名利用区分());
        住民異動情報.setKanaTsushomei(宛名識別対象.getカナ通称名());
        住民異動情報.setKatakanaHyoki(宛名識別対象.getカタカナ表記());
        住民異動情報.setKokusekiChiikiCode(宛名識別対象.get国籍地域コード() == null ? Code.EMPTY : 宛名識別対象.get国籍地域コード().value());
        住民異動情報.setZairyuShikakuCode(宛名識別対象.get在留資格コード() == null ? Code.EMPTY : 宛名識別対象.get在留資格コード().value());
        住民異動情報.setZairyuKikanCode(宛名識別対象.get在留期間コード());
        住民異動情報.setZairyuKikantoManryoYMD(宛名識別対象.get在留期間等満了年月日());
        住民異動情報.setZairyuCardtoNo(宛名識別対象.get在留カード等番号());
        住民異動情報.setZairyuCardtoYukoYMD(宛名識別対象.get在留カード等有効年月日());
        住民異動情報.setDai30Jono45niKiteisuruKubun(宛名識別対象.get第30条の45に規定する区分());
        住民異動情報.setSetainushiShikibetsuCode(宛名識別対象.get世帯主識別コード());
        住民異動情報.setSetainushiMei(宛名識別対象.get世帯主名());
        住民異動情報.setKojinHojinKBN(宛名識別対象.get個人法人区分());
        住民異動情報.setTorokuJiyuCode(宛名識別対象.get登録事由コード());
        住民異動情報.setTorokuIdoYMD(宛名識別対象.get登録異動年月日());
        住民異動情報.setTorokuTodokedeYMD(宛名識別対象.get登録届出年月日());
        住民異動情報.setJuteiJiyuCode(宛名識別対象.get住定事由コード());
        住民異動情報.setJuteiTodokedeYMD(宛名識別対象.get住定届出年月日());
        住民異動情報.setShojoJiyuCode(宛名識別対象.get消除事由コード());
        住民異動情報.setShojoIdoYMD(宛名識別対象.get消除異動年月日());
        住民異動情報.setShojoTodokedeYMD(宛名識別対象.get消除届出年月日());
        住民異動情報.setAimaiShojobiMongon(宛名識別対象.getあいまい消除日文言());
        住民異動情報.setTennyumaeYubinNo(宛名識別対象.get転入前郵便番号());
        住民異動情報.setTennyumaeZenkokuJushoCode(宛名識別対象.get転入前全国住所コード());
        住民異動情報.setTennyumaeJusho(宛名識別対象.get転入前住所());
        住民異動情報.setTennyumaeBanchi(宛名識別対象.get転入前番地());
        住民異動情報.setTennyumaeKatagaki(宛名識別対象.get転入前方書());
        住民異動情報.setTennyumaeSetainushimei(宛名識別対象.get転入前世帯主名());
        住民異動情報.setTennyumaeKyusei(宛名識別対象.get転入前旧姓() == null ? AtenaMeisho.EMPTY : new AtenaMeisho(宛名識別対象.get転入前旧姓()));
        住民異動情報.setSaishuJutochiYubinNo(宛名識別対象.get最終住登地郵便番号());
        住民異動情報.setSaishuJutochiZenkokuJushoCode(宛名識別対象.get最終住登地全国住所コード());
        住民異動情報.setSaishuJutochiJusho(宛名識別対象.get最終住登地住所());
        住民異動情報.setSaishuJutochiBanchi(宛名識別対象.get最終住登地番地());
        住民異動情報.setSaishuJutochiKatagaki(宛名識別対象.get最終住登地方書());
        住民異動情報.setSaishuJutochiSetainushimei(宛名識別対象.get最終住登地世帯主名());
        住民異動情報.setTenshutsuYoteiIdoYMD(宛名識別対象.get転出予定異動年月日());
        住民異動情報.setTenshutsuYoteiYubinNo(宛名識別対象.get転出予定郵便番号());
        住民異動情報.setTenshutsuYoteiZenkokuJushoCode(宛名識別対象.get転出予定全国住所コード());
        住民異動情報.setTenshutsuYoteiJusho(宛名識別対象.get転出予定住所());
        住民異動情報.setTenshutsuYoteiBanchi(宛名識別対象.get転出予定番地());
        住民異動情報.setTenshutsuYoteiKatagaki(宛名識別対象.get転出予定方書());
        住民異動情報.setTenshutsuYoteiSetainushimei(宛名識別対象.get転出予定世帯主名());
        住民異動情報.setTenshutsuKakuteiIdoYMD(宛名識別対象.get転出確定異動年月日());
        住民異動情報.setTenshutsuKakuteiTsuchiYMD(宛名識別対象.get転出確定通知年月日());
        住民異動情報.setTenshutsuKakuteiYubinNo(宛名識別対象.get転出確定郵便番号());
        住民異動情報.setTenshutsuKakuteiZenkokuJushoCode(宛名識別対象.get転出確定全国住所コード());
        住民異動情報.setTenshutsuKakuteiJusho(宛名識別対象.get転出確定住所());
        住民異動情報.setTenshutsuKakuteiBanchi(宛名識別対象.get転出確定番地());
        住民異動情報.setTenshutsuKakuteiKatagaki(宛名識別対象.get転出確定方書());
        住民異動情報.setTenshutsuKakuteiSetainushimei(宛名識別対象.get転出確定世帯主名());
        住民異動情報.setJuminhyoUtsushiHakkoSeigyoKubun(宛名識別対象.has住民票写し発行制御());
        住民異動情報.setRenrakusaki1(宛名識別対象.get連絡先１());
        住民異動情報.setRenrakusaki2(宛名識別対象.get連絡先２());
        住民異動情報.setRenrakusaki3(宛名識別対象.get連絡先３());
        住民異動情報.setKensakuRenrakusaki1(宛名識別対象.get検索連絡先１());
        住民異動情報.setKensakuRenrakusaki2(宛名識別対象.get検索連絡先２());
        住民異動情報.setKensakuRenrakusaki3(宛名識別対象.get検索連絡先３());
        住民異動情報.setRenrakusakiKubun1(宛名識別対象.get連絡先区分１() == null ? Code.EMPTY : 宛名識別対象.get連絡先区分１().value());
        住民異動情報.setRenrakusakiKubun2(宛名識別対象.get連絡先区分２() == null ? Code.EMPTY : 宛名識別対象.get連絡先区分２().value());
        住民異動情報.setRenrakusakiKubun3(宛名識別対象.get連絡先区分３() == null ? Code.EMPTY : 宛名識別対象.get連絡先区分３().value());
        住民異動情報.setMailAddress(宛名識別対象.getメールアドレス());
        住民異動情報.setBiko(宛名識別対象.get備考());
        juminIdoRendoKyotsu(住民異動情報, csvWriter);
    }
}
