package jp.co.ndensan.reams.db.dbb.batchcontroller.step.fukajohotoroku;

import jp.co.ndensan.reams.db.dbb.definition.processprm.fukajohotoroku.FukaJohoHenshuProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajohotoroku.DbT0700ShunoKanriTempTableEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajohotoroku.DbT0705ChoteiKyotsuTempTableEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajohotoroku.DbT2002FukaJohoTempTableEntity;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.FukaNokiResearcher;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.ur.urc.business.core.shunokamoku.shunokamoku.IShunoKamoku;
import jp.co.ndensan.reams.ur.urc.definition.core.shunokamoku.shunokamoku.ShunoKamokuShubetsu;
import jp.co.ndensan.reams.ur.urc.service.core.shunokamoku.shunokamoku.ShunoKamokuManager;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
    private static final RString 当初処理 = new RString("01");
    private static final RString 非当初処理 = new RString("04");
    private static final Decimal 初期金額 = new Decimal(0);
    private static final int 特徴期_2 = 2;
    private static final int 特徴期_3 = 3;
    private static final int 特徴期_4 = 4;
    private static final int 特徴期_5 = 5;
    private static final int 特徴期_6 = 6;
    private long 収納ID = 1L;
    private long 調定ID = 1L;

    @BatchParameter
    private FukaJohoHenshuProcessParameter parameter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter dbT0700ShunoKanriTemp;
    @BatchWriter
    BatchEntityCreatedTempTableWriter dbT0705ChoteiKyotsuTemp;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECTALL);
    }

    @Override
    protected void createWriter() {
        dbT0700ShunoKanriTemp = new BatchEntityCreatedTempTableWriter(DbT0700ShunoKanriTempTableEntity.TABLE_NAME,
                DbT0700ShunoKanriTempTableEntity.class);
        dbT0705ChoteiKyotsuTemp = new BatchEntityCreatedTempTableWriter(DbT0705ChoteiKyotsuTempTableEntity.TABLE_NAME,
                DbT0705ChoteiKyotsuTempTableEntity.class);
    }

    @Override
    protected void process(DbT2002FukaJohoTempTableEntity 賦課情報) {
        ShunoKamokuManager manager = new ShunoKamokuManager();
        FukaNokiResearcher 賦課納期取得 = FukaNokiResearcher.createInstance();
        save特徴期別(賦課情報, manager, 賦課納期取得);
        save普徴期別(賦課情報, manager, 賦課納期取得);
    }

    private void save特徴期別(DbT2002FukaJohoTempTableEntity 賦課情報,
            ShunoKamokuManager manager,
            FukaNokiResearcher 賦課納期取得) {
        if (賦課情報.getTkKibetsuGaku01() != null && 初期金額.compareTo(賦課情報.getTkKibetsuGaku01()) == -1) {
            saveTemp(賦課情報, manager.get科目(ShunoKamokuShubetsu.介護保険料_特別徴収),
                    1, 賦課納期取得.get特徴納期(1).get納期限(), 賦課情報.getTkKibetsuGaku01());
        }
        if (賦課情報.getTkKibetsuGaku02() != null && 初期金額.compareTo(賦課情報.getTkKibetsuGaku02()) == -1) {
            saveTemp(賦課情報, manager.get科目(ShunoKamokuShubetsu.介護保険料_特別徴収),
                    特徴期_2, 賦課納期取得.get特徴納期(特徴期_2).get納期限(), 賦課情報.getTkKibetsuGaku02());
        }
        if (賦課情報.getTkKibetsuGaku03() != null && 初期金額.compareTo(賦課情報.getTkKibetsuGaku03()) == -1) {
            saveTemp(賦課情報, manager.get科目(ShunoKamokuShubetsu.介護保険料_特別徴収),
                    特徴期_3, 賦課納期取得.get特徴納期(特徴期_3).get納期限(), 賦課情報.getTkKibetsuGaku03());
        }
        if (賦課情報.getTkKibetsuGaku04() != null && 初期金額.compareTo(賦課情報.getTkKibetsuGaku04()) == -1) {
            saveTemp(賦課情報, manager.get科目(ShunoKamokuShubetsu.介護保険料_特別徴収),
                    特徴期_4, 賦課納期取得.get特徴納期(特徴期_4).get納期限(), 賦課情報.getTkKibetsuGaku04());
        }
        if (賦課情報.getTkKibetsuGaku05() != null && 初期金額.compareTo(賦課情報.getTkKibetsuGaku05()) == -1) {
            saveTemp(賦課情報, manager.get科目(ShunoKamokuShubetsu.介護保険料_特別徴収),
                    特徴期_5, 賦課納期取得.get特徴納期(特徴期_5).get納期限(), 賦課情報.getTkKibetsuGaku05());
        }
        if (賦課情報.getTkKibetsuGaku06() != null && 初期金額.compareTo(賦課情報.getTkKibetsuGaku06()) == -1) {
            saveTemp(賦課情報, manager.get科目(ShunoKamokuShubetsu.介護保険料_特別徴収),
                    特徴期_6, 賦課納期取得.get特徴納期(特徴期_6).get納期限(), 賦課情報.getTkKibetsuGaku06());
        }
    }

    private void save普徴期別(DbT2002FukaJohoTempTableEntity 賦課情報,
            ShunoKamokuManager manager,
            FukaNokiResearcher 賦課納期取得) {
        KitsukiList 期月リスト = new FuchoKiUtil().get期月リスト();
        save普徴期別By07期(賦課情報, manager, 賦課納期取得, 期月リスト);
        save普徴期別By14期(賦課情報, manager, 賦課納期取得, 期月リスト);
    }

    private void save普徴期別By07期(DbT2002FukaJohoTempTableEntity 賦課情報,
            ShunoKamokuManager manager,
            FukaNokiResearcher 賦課納期取得,
            KitsukiList 期月リスト) {
        if (賦課情報.getFuKibetsuGaku01() != null && 初期金額.compareTo(賦課情報.getFuKibetsuGaku01()) == -1) {
            saveTemp(賦課情報, manager.get科目(ShunoKamokuShubetsu.介護保険料_普通徴収),
                    期月リスト.get月の期(Tsuki._4月).get期AsInt(),
                    賦課納期取得.get普徴納期(期月リスト.get月の期(Tsuki._4月).get期AsInt()).get納期限(),
                    賦課情報.getFuKibetsuGaku01());
        }
        if (賦課情報.getFuKibetsuGaku02() != null && 初期金額.compareTo(賦課情報.getFuKibetsuGaku02()) == -1) {
            saveTemp(賦課情報, manager.get科目(ShunoKamokuShubetsu.介護保険料_普通徴収),
                    期月リスト.get月の期(Tsuki._5月).get期AsInt(),
                    賦課納期取得.get普徴納期(期月リスト.get月の期(Tsuki._5月).get期AsInt()).get納期限(),
                    賦課情報.getFuKibetsuGaku02());
        }
        if (賦課情報.getFuKibetsuGaku03() != null && 初期金額.compareTo(賦課情報.getFuKibetsuGaku03()) == -1) {
            saveTemp(賦課情報, manager.get科目(ShunoKamokuShubetsu.介護保険料_普通徴収),
                    期月リスト.get月の期(Tsuki._6月).get期AsInt(),
                    賦課納期取得.get普徴納期(期月リスト.get月の期(Tsuki._5月).get期AsInt()).get納期限(),
                    賦課情報.getFuKibetsuGaku03());
        }
        if (賦課情報.getFuKibetsuGaku04() != null && 初期金額.compareTo(賦課情報.getFuKibetsuGaku04()) == -1) {
            saveTemp(賦課情報, manager.get科目(ShunoKamokuShubetsu.介護保険料_普通徴収),
                    期月リスト.get月の期(Tsuki._7月).get期AsInt(),
                    賦課納期取得.get普徴納期(期月リスト.get月の期(Tsuki._7月).get期AsInt()).get納期限(),
                    賦課情報.getFuKibetsuGaku04());
        }
        if (賦課情報.getFuKibetsuGaku05() != null && 初期金額.compareTo(賦課情報.getFuKibetsuGaku05()) == -1) {
            saveTemp(賦課情報, manager.get科目(ShunoKamokuShubetsu.介護保険料_普通徴収),
                    期月リスト.get月の期(Tsuki._8月).get期AsInt(),
                    賦課納期取得.get普徴納期(期月リスト.get月の期(Tsuki._8月).get期AsInt()).get納期限(),
                    賦課情報.getFuKibetsuGaku05());
        }
        if (賦課情報.getFuKibetsuGaku06() != null && 初期金額.compareTo(賦課情報.getFuKibetsuGaku06()) == -1) {
            saveTemp(賦課情報, manager.get科目(ShunoKamokuShubetsu.介護保険料_普通徴収),
                    期月リスト.get月の期(Tsuki._9月).get期AsInt(),
                    賦課納期取得.get普徴納期(期月リスト.get月の期(Tsuki._9月).get期AsInt()).get納期限(),
                    賦課情報.getFuKibetsuGaku06());
        }
        if (賦課情報.getFuKibetsuGaku07() != null && 初期金額.compareTo(賦課情報.getFuKibetsuGaku07()) == -1) {
            saveTemp(賦課情報, manager.get科目(ShunoKamokuShubetsu.介護保険料_普通徴収),
                    期月リスト.get月の期(Tsuki._10月).get期AsInt(),
                    賦課納期取得.get普徴納期(期月リスト.get月の期(Tsuki._10月).get期AsInt()).get納期限(),
                    賦課情報.getFuKibetsuGaku07());
        }
    }

    private void save普徴期別By14期(DbT2002FukaJohoTempTableEntity 賦課情報,
            ShunoKamokuManager manager,
            FukaNokiResearcher 賦課納期取得,
            KitsukiList 期月リスト) {
        if (賦課情報.getFuKibetsuGaku08() != null && 初期金額.compareTo(賦課情報.getFuKibetsuGaku08()) == -1) {
            saveTemp(賦課情報, manager.get科目(ShunoKamokuShubetsu.介護保険料_普通徴収),
                    期月リスト.get月の期(Tsuki._11月).get期AsInt(),
                    賦課納期取得.get普徴納期(期月リスト.get月の期(Tsuki._11月).get期AsInt()).get納期限(),
                    賦課情報.getFuKibetsuGaku08());
        }
        if (賦課情報.getFuKibetsuGaku09() != null && 初期金額.compareTo(賦課情報.getFuKibetsuGaku09()) == -1) {
            saveTemp(賦課情報, manager.get科目(ShunoKamokuShubetsu.介護保険料_普通徴収),
                    期月リスト.get月の期(Tsuki._12月).get期AsInt(),
                    賦課納期取得.get普徴納期(期月リスト.get月の期(Tsuki._12月).get期AsInt()).get納期限(),
                    賦課情報.getFuKibetsuGaku09());
        }
        if (賦課情報.getFuKibetsuGaku10() != null && 初期金額.compareTo(賦課情報.getFuKibetsuGaku10()) == -1) {
            saveTemp(賦課情報, manager.get科目(ShunoKamokuShubetsu.介護保険料_普通徴収),
                    期月リスト.get月の期(Tsuki._1月).get期AsInt(),
                    賦課納期取得.get普徴納期(期月リスト.get月の期(Tsuki._1月).get期AsInt()).get納期限(),
                    賦課情報.getFuKibetsuGaku10());
        }
        if (賦課情報.getFuKibetsuGaku11() != null && 初期金額.compareTo(賦課情報.getFuKibetsuGaku11()) == -1) {
            saveTemp(賦課情報, manager.get科目(ShunoKamokuShubetsu.介護保険料_普通徴収),
                    期月リスト.get月の期(Tsuki._2月).get期AsInt(),
                    賦課納期取得.get普徴納期(期月リスト.get月の期(Tsuki._2月).get期AsInt()).get納期限(),
                    賦課情報.getFuKibetsuGaku11());
        }
        if (賦課情報.getFuKibetsuGaku12() != null && 初期金額.compareTo(賦課情報.getFuKibetsuGaku12()) == -1) {
            saveTemp(賦課情報, manager.get科目(ShunoKamokuShubetsu.介護保険料_普通徴収),
                    期月リスト.get月の期(Tsuki._3月).get期AsInt(),
                    賦課納期取得.get普徴納期(期月リスト.get月の期(Tsuki._3月).get期AsInt()).get納期限(),
                    賦課情報.getFuKibetsuGaku12());
        }
        if (賦課情報.getFuKibetsuGaku13() != null && 初期金額.compareTo(賦課情報.getFuKibetsuGaku13()) == -1) {
            saveTemp(賦課情報, manager.get科目(ShunoKamokuShubetsu.介護保険料_普通徴収),
                    期月リスト.get月の期(Tsuki.翌年度4月).get期AsInt(),
                    賦課納期取得.get普徴納期(期月リスト.get月の期(Tsuki.翌年度4月).get期AsInt()).get納期限(),
                    賦課情報.getFuKibetsuGaku13());
        }
        if (賦課情報.getFuKibetsuGaku14() != null && 初期金額.compareTo(賦課情報.getFuKibetsuGaku14()) == -1) {
            saveTemp(賦課情報, manager.get科目(ShunoKamokuShubetsu.介護保険料_普通徴収),
                    期月リスト.get月の期(Tsuki.翌年度5月).get期AsInt(),
                    賦課納期取得.get普徴納期(期月リスト.get月の期(Tsuki.翌年度5月).get期AsInt()).get納期限(),
                    賦課情報.getFuKibetsuGaku14());
        }
    }

    private void saveTemp(DbT2002FukaJohoTempTableEntity 賦課情報, IShunoKamoku 科目, int 期別, RDate 納期限, Decimal 調定額) {
        dbT0700ShunoKanriTemp.insert(get収納管理(科目, 賦課情報, 期別));
        dbT0705ChoteiKyotsuTemp.insert(get調定共通(賦課情報.getChoteiNendo(), 納期限, 調定額));
        収納ID++;
        調定ID++;
    }

    private DbT0700ShunoKanriTempTableEntity get収納管理(IShunoKamoku 科目, DbT2002FukaJohoTempTableEntity 賦課情報, int 期別) {
        DbT0700ShunoKanriTempTableEntity entity = new DbT0700ShunoKanriTempTableEntity();
        entity.setShunoId(収納ID);
        entity.setKamokuCode(科目.getコード());
        entity.setEdabanCode(科目.get枝番コード());
        entity.setChoteiNendo(賦課情報.getChoteiNendo());
        entity.setKazeiNendo(賦課情報.getFukaNendo());
        entity.setTsuchishoNo(賦課情報.getTsuchishoNo());
        entity.setKibetsu(期別);
        entity.setShikibetsuCode(賦課情報.getShikibetsuCode());
        return entity;
    }

    private DbT0705ChoteiKyotsuTempTableEntity get調定共通(FlexibleYear 会計年度, RDate 納期限, Decimal 調定額) {
        DbT0705ChoteiKyotsuTempTableEntity entity = new DbT0705ChoteiKyotsuTempTableEntity();
        entity.setChoteiId(調定ID);
        entity.setShunoId(収納ID);
        entity.setKaikeiNendo(会計年度);
        entity.setChoteiJiyuCode(parameter.is当初処理() ? 当初処理 : 非当初処理);
        entity.setChoteigaku(調定額);
        entity.setShohizei(初期金額);
        entity.setNokigenYMD(納期限);
        entity.setFukaShoriJokyo(false);
        return entity;
    }
}
