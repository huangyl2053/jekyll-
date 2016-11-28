package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB004001;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiTsuchiShoKyotsuKomokuHenshu;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajohotoroku.DbT2002FukaJohoTempTableEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.fukajohotoroku.IFukaJohoTorokuMapper;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.FukaNokiResearcher;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KanendoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.ur.urc.business.core.shunokamoku.shunokamoku.IShunoKamoku;
import jp.co.ndensan.reams.ur.urc.definition.core.shuno.tsuchishono.TsuchishoNo;
import jp.co.ndensan.reams.ur.urc.definition.core.shunokamoku.shunokamoku.JigyoKubun;
import jp.co.ndensan.reams.ur.urc.definition.core.shunokamoku.shunokamoku.ShunoKamokuShubetsu;
import jp.co.ndensan.reams.ur.urc.entity.db.basic.shuno.chotei.UrT0705ChoteiKyotsuEntity;
import jp.co.ndensan.reams.ur.urc.entity.db.basic.shuno.shunokanri.UrT0700ShunoKanriEntity;
import jp.co.ndensan.reams.ur.urc.service.core.kamoku.shunokamoku.ShunoKamokuFinder;
import jp.co.ndensan.reams.ur.urz.definition.core.code.RyokinShubetsuCodeValue;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.EdabanCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 賦課の情報を一括登録するバッチデータ作成用Processクラスです。
 *
 * @reamsid_L DBB-9040-070 wangxiaodong
 */
public class FukaJohoHenshuProcess extends BatchProcessBase<DbT2002FukaJohoTempTableEntity> {

    private static final RString MAPPERPATH = new RString(
            "jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.fukajohotoroku.IFukaJohoTorokuMapper.");
    private static final RString SELECTALL = new RString(MAPPERPATH + "selectAll");
    private static final RString 収納管理一時テーブルNAME = new RString("UrT0700ShunoKanri_work");
    private static final RString 調定共通一時テーブルNAME = new RString("UrT0705ChoteiKyotsu_work");
    private static final RString 処理名 = new RString("本算定賦課");
    private static final RString 当初処理 = new RString("01");
    private static final RString 非当初処理 = new RString("04");
    private static final RString メソッド_普徴期別金額 = new RString("getFuKibetsuGaku");
    private static final int 特徴期_2 = 2;
    private static final int 特徴期_3 = 3;
    private static final int 特徴期_4 = 4;
    private static final int 特徴期_5 = 5;
    private static final int 特徴期_6 = 6;
    private List<DbT7022ShoriDateKanriEntity> 処理日付情報;
    private IFukaJohoTorokuMapper mapper;
    private List<RString> 全て期;
    private IShunoKamoku 科目_普通徴収;
    private IShunoKamoku 科目_特別徴収;
    private FukaNokiResearcher 賦課納期取得;
    private long 収納ID = 1L;
    private long 調定ID = 1L;

    @BatchWriter
    BatchEntityCreatedTempTableWriter dbT0700ShunoKanriTemp;
    @BatchWriter
    BatchEntityCreatedTempTableWriter dbT0705ChoteiKyotsuTemp;

    @Override
    protected void initialize() {
        mapper = getMapper(IFukaJohoTorokuMapper.class);
        処理日付情報 = mapper.getSyoriDate(処理名);
        ShunoKamokuFinder manager = ShunoKamokuFinder.createInstance();
        科目_普通徴収 = manager.get科目(ShunoKamokuShubetsu.介護保険料_普通徴収);
        科目_特別徴収 = manager.get科目(ShunoKamokuShubetsu.介護保険料_特別徴収);
        賦課納期取得 = FukaNokiResearcher.createInstance();
        全て期 = get全て期();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECTALL);
    }

    @Override
    protected void createWriter() {
        dbT0700ShunoKanriTemp = new BatchEntityCreatedTempTableWriter(収納管理一時テーブルNAME, UrT0700ShunoKanriEntity.class);
        dbT0705ChoteiKyotsuTemp = new BatchEntityCreatedTempTableWriter(調定共通一時テーブルNAME, UrT0705ChoteiKyotsuEntity.class);
    }

    @Override
    protected void process(DbT2002FukaJohoTempTableEntity 賦課情報) {
        if (賦課情報.getFukaNendo().equals(賦課情報.getChoteiNendo())) {
            YMDHMS 処理日時 = get処理日時(処理日付情報, 賦課情報.getFukaNendo());
            YMDHMS 調定日時 = 賦課情報.getChoteiNichiji();
            KitsukiList 月期対応取得_普徴 = new FuchoKiUtil(賦課情報.getFukaNendo()).get期月リスト();
            if (処理日時 == null || 処理日時.isEmpty() || (調定日時 != null && 調定日時.isBefore(処理日時))) {
                save仮算定データ(賦課情報, 月期対応取得_普徴);
            } else {
                save特徴期別(賦課情報);
                save普徴期別金額By最後の期(賦課情報, 月期対応取得_普徴.getLast().get期AsInt());
            }
        } else {
            int 最後の期_過年度 = new KanendoKiUtil(賦課情報.getFukaNendo()).get期月リスト().getLast().get期AsInt();
            save普徴期別金額By最後の期(賦課情報, 最後の期_過年度);
        }
    }

    private void save仮算定データ(DbT2002FukaJohoTempTableEntity 賦課情報, KitsukiList 月期対応取得_普徴) {
        save特徴期別01まで特徴期別03(賦課情報);
        for (Kitsuki 期月 : 月期対応取得_普徴.filtered仮算定期間().toList()) {
            int 期別 = 期月.get期AsInt();
            if (0 < 期別) {
                Decimal 期別金額 = get期別金額By期(賦課情報, 期月.get期());
                if (期別金額 != null) {
                    saveTemp(賦課情報, 科目_普通徴収, 期別, 賦課納期取得.get普徴納期(期別).get納期限(), 期別金額);
                }
            }
        }
    }

    private void save普徴期別金額By最後の期(DbT2002FukaJohoTempTableEntity 賦課情報, int 最後の期) {
        for (RString 期別 : 全て期) {
            int 期 = Integer.parseInt(期別.toString());
            if (期 <= 最後の期) {
                Decimal 期別金額 = get期別金額By期(賦課情報, 期別);
                if (期別金額 != null) {
                    saveTemp(賦課情報, 科目_普通徴収, 期, 賦課納期取得.get普徴納期(期).get納期限(), 期別金額);
                }
            }
        }
    }

    private YMDHMS get処理日時(List<DbT7022ShoriDateKanriEntity> 処理日付情報, FlexibleYear 賦課年度) {
        for (DbT7022ShoriDateKanriEntity shoriDate : 処理日付情報) {
            if (shoriDate.getNendo().equals(賦課年度)) {
                return shoriDate.getKijunTimestamp();
            }
        }
        return null;
    }

    private void save特徴期別01まで特徴期別03(DbT2002FukaJohoTempTableEntity 賦課情報) {
        if (賦課情報.getTkKibetsuGaku01() != null) {
            saveTemp(賦課情報, 科目_特別徴収, 1, 賦課納期取得.get特徴納期(1).get納期限(), 賦課情報.getTkKibetsuGaku01());
        }
        if (賦課情報.getTkKibetsuGaku02() != null) {
            saveTemp(賦課情報, 科目_特別徴収, 特徴期_2, 賦課納期取得.get特徴納期(特徴期_2).get納期限(), 賦課情報.getTkKibetsuGaku02());
        }
        if (賦課情報.getTkKibetsuGaku03() != null) {
            saveTemp(賦課情報, 科目_特別徴収, 特徴期_3, 賦課納期取得.get特徴納期(特徴期_3).get納期限(), 賦課情報.getTkKibetsuGaku03());
        }
    }

    private void save特徴期別(DbT2002FukaJohoTempTableEntity 賦課情報) {
        save特徴期別01まで特徴期別03(賦課情報);
        if (賦課情報.getTkKibetsuGaku04() != null) {
            saveTemp(賦課情報, 科目_特別徴収, 特徴期_4, 賦課納期取得.get特徴納期(特徴期_4).get納期限(), 賦課情報.getTkKibetsuGaku04());
        }
        if (賦課情報.getTkKibetsuGaku05() != null) {
            saveTemp(賦課情報, 科目_特別徴収, 特徴期_5, 賦課納期取得.get特徴納期(特徴期_5).get納期限(), 賦課情報.getTkKibetsuGaku05());
        }
        if (賦課情報.getTkKibetsuGaku06() != null) {
            saveTemp(賦課情報, 科目_特別徴収, 特徴期_6, 賦課納期取得.get特徴納期(特徴期_6).get納期限(), 賦課情報.getTkKibetsuGaku06());
        }
    }

    private Decimal get期別金額By期(DbT2002FukaJohoTempTableEntity 賦課情報, RString 期) {
        Class clazz = 賦課情報.getClass();
        try {
            Method getMethod = clazz.getDeclaredMethod(メソッド_普徴期別金額.concat(期).toString());
            return (Decimal) getMethod.invoke(賦課情報);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(HonSanteiTsuchiShoKyotsuKomokuHenshu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private void saveTemp(DbT2002FukaJohoTempTableEntity 賦課情報, IShunoKamoku 科目, int 期別, RDate 納期限, Decimal 調定額) {
        dbT0700ShunoKanriTemp.insert(get収納管理(科目, 賦課情報, 期別));
        dbT0705ChoteiKyotsuTemp.insert(get調定共通(賦課情報, 納期限, 調定額));
        収納ID = 収納ID + 1;
        調定ID = 調定ID + 1;
    }

    private UrT0700ShunoKanriEntity get収納管理(IShunoKamoku 科目, DbT2002FukaJohoTempTableEntity 賦課情報, int 期別) {
        UrT0700ShunoKanriEntity entity = new UrT0700ShunoKanriEntity();
        entity.setShunoId(収納ID);
        if (科目 == null) {
            entity.setKamokuCode(KamokuCode.EMPTY);
            entity.setKamokuEdabanCode(EdabanCode.EMPTY);
        } else {
            entity.setKamokuCode(科目.getコード());
            entity.setKamokuEdabanCode(科目.get枝番コード());
        }
        entity.setRyokinShubetsuCode(new RyokinShubetsuCodeValue(RString.EMPTY));
        entity.setJigyoKubunCode(JigyoKubun.未使用.getJigyoKubunCd());
        entity.setChoteiNendo(new RYear(賦課情報.getChoteiNendo().toString()));
        entity.setKazeiNendo(new RYear(賦課情報.getFukaNendo().toString()));
        entity.setTsuchishoNo(new TsuchishoNo(new Decimal(賦課情報.getTsuchishoNo().toString())));
        entity.setKibetsu(期別);
        entity.setChoshukenUmu(true);
        entity.setChoteiNo(0);
        entity.setShikibetsuCode(賦課情報.getShikibetsuCode());
        return entity;
    }

    private UrT0705ChoteiKyotsuEntity get調定共通(DbT2002FukaJohoTempTableEntity 賦課情報, RDate 納期限, Decimal 調定額) {
        UrT0705ChoteiKyotsuEntity entity = new UrT0705ChoteiKyotsuEntity();
        entity.setChoteiId(調定ID);
        entity.setRirekiNo(0L);
        entity.setShunoId(収納ID);
        entity.setKaikeiNendo(new RYear(賦課情報.getChoteiNendo().toString()));
        entity.setShoriNendo(RDate.getNowDate().getYear());
        entity.setShoriNo(0);
        entity.setKoseiKaisu(0);
        if (0 == 賦課情報.getRirekiNo()) {
            entity.setChoteiJiyuCode(当初処理);
        } else if (0 < 賦課情報.getRirekiNo()) {
            entity.setChoteiJiyuCode(非当初処理);
        }
        YMDHMS 調定日時 = 賦課情報.getChoteiNichiji();
        if (調定日時 != null && !調定日時.isEmpty()) {
            entity.setChoteiYMD(調定日時.getDate());
        }
        entity.setChoteigaku(調定額);
        entity.setShohizei(Decimal.ZERO);
        entity.setNokigenYMD(納期限);
        entity.setHoteiNokigenToYMD(RDate.getNowDate());
        entity.setFukaShoriJokyo(false);
        return entity;
    }

    private List<RString> get全て期() {
        List<RString> 期 = new ArrayList<>();
        期.add(new RString("01"));
        期.add(new RString("02"));
        期.add(new RString("03"));
        期.add(new RString("04"));
        期.add(new RString("05"));
        期.add(new RString("06"));
        期.add(new RString("07"));
        期.add(new RString("08"));
        期.add(new RString("09"));
        期.add(new RString("10"));
        期.add(new RString("11"));
        期.add(new RString("12"));
        期.add(new RString("13"));
        期.add(new RString("14"));
        return 期;
    }
}
