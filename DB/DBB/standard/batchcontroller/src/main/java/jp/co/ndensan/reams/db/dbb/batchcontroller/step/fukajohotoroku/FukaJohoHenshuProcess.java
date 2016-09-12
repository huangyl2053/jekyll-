package jp.co.ndensan.reams.db.dbb.batchcontroller.step.fukajohotoroku;

import jp.co.ndensan.reams.db.dbb.definition.processprm.fukajohotoroku.FukaJohoHenshuProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajohotoroku.DbT2002FukaJohoTempTableEntity;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.FukaNokiResearcher;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.ur.urc.business.core.shunokamoku.shunokamoku.IShunoKamoku;
import jp.co.ndensan.reams.ur.urc.definition.core.shuno.tsuchishono.TsuchishoNo;
import jp.co.ndensan.reams.ur.urc.definition.core.shunokamoku.shunokamoku.JigyoKubun;
import jp.co.ndensan.reams.ur.urc.definition.core.shunokamoku.shunokamoku.ShunoKamokuShubetsu;
import jp.co.ndensan.reams.ur.urc.entity.db.basic.shuno.chotei.UrT0705ChoteiKyotsuEntity;
import jp.co.ndensan.reams.ur.urc.entity.db.basic.shuno.shunokanri.UrT0700ShunoKanriEntity;
import jp.co.ndensan.reams.ur.urc.service.core.kamoku.shunokamoku.ShunoKamokuFinder;
import jp.co.ndensan.reams.ur.urz.definition.core.code.RyokinShubetsuCodeValue;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.EdabanCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
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
    private static final RString 当初処理 = new RString("01");
    private static final RString 非当初処理 = new RString("04");
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
        dbT0700ShunoKanriTemp = new BatchEntityCreatedTempTableWriter(収納管理一時テーブルNAME, UrT0700ShunoKanriEntity.class);
        dbT0705ChoteiKyotsuTemp = new BatchEntityCreatedTempTableWriter(調定共通一時テーブルNAME, UrT0705ChoteiKyotsuEntity.class);
    }

    @Override
    protected void process(DbT2002FukaJohoTempTableEntity 賦課情報) {
        ShunoKamokuFinder manager = ShunoKamokuFinder.createInstance();
        FukaNokiResearcher 賦課納期取得 = FukaNokiResearcher.createInstance();
        save特徴期別(賦課情報, manager, 賦課納期取得);
        save普徴期別(賦課情報, manager, 賦課納期取得);
    }

    private void save特徴期別(DbT2002FukaJohoTempTableEntity 賦課情報,
            ShunoKamokuFinder manager,
            FukaNokiResearcher 賦課納期取得) {
        IShunoKamoku 科目 = manager.get科目(ShunoKamokuShubetsu.介護保険料_特別徴収);
        if (賦課情報.getTkKibetsuGaku01() != null && Decimal.ZERO.compareTo(賦課情報.getTkKibetsuGaku01()) == -1) {
            saveTemp(賦課情報, 科目, 1, 賦課納期取得.get特徴納期(1).get納期限(), 賦課情報.getTkKibetsuGaku01());
        }
        if (賦課情報.getTkKibetsuGaku02() != null && Decimal.ZERO.compareTo(賦課情報.getTkKibetsuGaku02()) == -1) {
            saveTemp(賦課情報, 科目, 特徴期_2, 賦課納期取得.get特徴納期(特徴期_2).get納期限(), 賦課情報.getTkKibetsuGaku02());
        }
        if (賦課情報.getTkKibetsuGaku03() != null && Decimal.ZERO.compareTo(賦課情報.getTkKibetsuGaku03()) == -1) {
            saveTemp(賦課情報, 科目, 特徴期_3, 賦課納期取得.get特徴納期(特徴期_3).get納期限(), 賦課情報.getTkKibetsuGaku03());
        }
        if (賦課情報.getTkKibetsuGaku04() != null && Decimal.ZERO.compareTo(賦課情報.getTkKibetsuGaku04()) == -1) {
            saveTemp(賦課情報, 科目, 特徴期_4, 賦課納期取得.get特徴納期(特徴期_4).get納期限(), 賦課情報.getTkKibetsuGaku04());
        }
        if (賦課情報.getTkKibetsuGaku05() != null && Decimal.ZERO.compareTo(賦課情報.getTkKibetsuGaku05()) == -1) {
            saveTemp(賦課情報, 科目, 特徴期_5, 賦課納期取得.get特徴納期(特徴期_5).get納期限(), 賦課情報.getTkKibetsuGaku05());
        }
        if (賦課情報.getTkKibetsuGaku06() != null && Decimal.ZERO.compareTo(賦課情報.getTkKibetsuGaku06()) == -1) {
            saveTemp(賦課情報, 科目, 特徴期_6, 賦課納期取得.get特徴納期(特徴期_6).get納期限(), 賦課情報.getTkKibetsuGaku06());
        }
    }

    private void save普徴期別(DbT2002FukaJohoTempTableEntity 賦課情報,
            ShunoKamokuFinder manager, FukaNokiResearcher 賦課納期取得) {
        IShunoKamoku 科目 = manager.get科目(ShunoKamokuShubetsu.介護保険料_普通徴収);
        KitsukiList 期月リスト = new FuchoKiUtil().get期月リスト();
        save普徴期別By04期(賦課情報, 科目, 賦課納期取得, 期月リスト);
        save普徴期別By07期(賦課情報, 科目, 賦課納期取得, 期月リスト);
        save普徴期別By10期(賦課情報, 科目, 賦課納期取得, 期月リスト);
        save普徴期別By14期(賦課情報, 科目, 賦課納期取得, 期月リスト);
    }

    private void save普徴期別By04期(DbT2002FukaJohoTempTableEntity 賦課情報,
            IShunoKamoku 科目, FukaNokiResearcher 賦課納期取得, KitsukiList 期月リスト) {
        if (賦課情報.getFuKibetsuGaku01() != null && Decimal.ZERO.compareTo(賦課情報.getFuKibetsuGaku01()) == -1) {
            int 期別 = 期月リスト.get月の期(Tsuki._4月).get期AsInt();
            if (0 < 期別) {
                saveTemp(賦課情報, 科目, 期別, 賦課納期取得.get普徴納期(期別).get納期限(), 賦課情報.getFuKibetsuGaku01());
            }
        }
        if (賦課情報.getFuKibetsuGaku02() != null && Decimal.ZERO.compareTo(賦課情報.getFuKibetsuGaku02()) == -1) {
            int 期別 = 期月リスト.get月の期(Tsuki._5月).get期AsInt();
            if (0 < 期別) {
                saveTemp(賦課情報, 科目, 期別, 賦課納期取得.get普徴納期(期別).get納期限(), 賦課情報.getFuKibetsuGaku02());
            }
        }
        if (賦課情報.getFuKibetsuGaku03() != null && Decimal.ZERO.compareTo(賦課情報.getFuKibetsuGaku03()) == -1) {
            int 期別 = 期月リスト.get月の期(Tsuki._6月).get期AsInt();
            if (0 < 期別) {
                saveTemp(賦課情報, 科目, 期別, 賦課納期取得.get普徴納期(期別).get納期限(), 賦課情報.getFuKibetsuGaku03());
            }
        }
        if (賦課情報.getFuKibetsuGaku04() != null && Decimal.ZERO.compareTo(賦課情報.getFuKibetsuGaku04()) == -1) {
            int 期別 = 期月リスト.get月の期(Tsuki._7月).get期AsInt();
            if (0 < 期別) {
                saveTemp(賦課情報, 科目, 期別, 賦課納期取得.get普徴納期(期別).get納期限(), 賦課情報.getFuKibetsuGaku04());
            }
        }
    }

    private void save普徴期別By07期(DbT2002FukaJohoTempTableEntity 賦課情報,
            IShunoKamoku 科目, FukaNokiResearcher 賦課納期取得, KitsukiList 期月リスト) {
        if (賦課情報.getFuKibetsuGaku05() != null && Decimal.ZERO.compareTo(賦課情報.getFuKibetsuGaku05()) == -1) {
            int 期別 = 期月リスト.get月の期(Tsuki._8月).get期AsInt();
            if (0 < 期別) {
                saveTemp(賦課情報, 科目, 期別, 賦課納期取得.get普徴納期(期別).get納期限(), 賦課情報.getFuKibetsuGaku05());
            }
        }
        if (賦課情報.getFuKibetsuGaku06() != null && Decimal.ZERO.compareTo(賦課情報.getFuKibetsuGaku06()) == -1) {
            int 期別 = 期月リスト.get月の期(Tsuki._9月).get期AsInt();
            if (0 < 期別) {
                saveTemp(賦課情報, 科目, 期別, 賦課納期取得.get普徴納期(期別).get納期限(), 賦課情報.getFuKibetsuGaku06());
            }
        }
        if (賦課情報.getFuKibetsuGaku07() != null && Decimal.ZERO.compareTo(賦課情報.getFuKibetsuGaku07()) == -1) {
            int 期別 = 期月リスト.get月の期(Tsuki._10月).get期AsInt();
            if (0 < 期別) {
                saveTemp(賦課情報, 科目, 期別, 賦課納期取得.get普徴納期(期別).get納期限(), 賦課情報.getFuKibetsuGaku07());
            }
        }
    }

    private void save普徴期別By10期(DbT2002FukaJohoTempTableEntity 賦課情報,
            IShunoKamoku 科目, FukaNokiResearcher 賦課納期取得, KitsukiList 期月リスト) {
        if (賦課情報.getFuKibetsuGaku08() != null && Decimal.ZERO.compareTo(賦課情報.getFuKibetsuGaku08()) == -1) {
            int 期別 = 期月リスト.get月の期(Tsuki._11月).get期AsInt();
            if (0 < 期別) {
                saveTemp(賦課情報, 科目, 期別, 賦課納期取得.get普徴納期(期別).get納期限(), 賦課情報.getFuKibetsuGaku08());
            }
        }
        if (賦課情報.getFuKibetsuGaku09() != null && Decimal.ZERO.compareTo(賦課情報.getFuKibetsuGaku09()) == -1) {
            int 期別 = 期月リスト.get月の期(Tsuki._12月).get期AsInt();
            if (0 < 期別) {
                saveTemp(賦課情報, 科目, 期別, 賦課納期取得.get普徴納期(期別).get納期限(), 賦課情報.getFuKibetsuGaku09());
            }
        }
        if (賦課情報.getFuKibetsuGaku10() != null && Decimal.ZERO.compareTo(賦課情報.getFuKibetsuGaku10()) == -1) {
            int 期別 = 期月リスト.get月の期(Tsuki._1月).get期AsInt();
            if (0 < 期別) {
                saveTemp(賦課情報, 科目, 期別, 賦課納期取得.get普徴納期(期別).get納期限(), 賦課情報.getFuKibetsuGaku10());
            }
        }
    }

    private void save普徴期別By14期(DbT2002FukaJohoTempTableEntity 賦課情報,
            IShunoKamoku 科目, FukaNokiResearcher 賦課納期取得, KitsukiList 期月リスト) {
        if (賦課情報.getFuKibetsuGaku11() != null && Decimal.ZERO.compareTo(賦課情報.getFuKibetsuGaku11()) == -1) {
            int 期別 = 期月リスト.get月の期(Tsuki._2月).get期AsInt();
            if (0 < 期別) {
                saveTemp(賦課情報, 科目, 期別, 賦課納期取得.get普徴納期(期別).get納期限(), 賦課情報.getFuKibetsuGaku11());
            }
        }
        if (賦課情報.getFuKibetsuGaku12() != null && Decimal.ZERO.compareTo(賦課情報.getFuKibetsuGaku12()) == -1) {
            int 期別 = 期月リスト.get月の期(Tsuki._3月).get期AsInt();
            if (0 < 期別) {
                saveTemp(賦課情報, 科目, 期別, 賦課納期取得.get普徴納期(期別).get納期限(), 賦課情報.getFuKibetsuGaku12());
            }
        }
        if (賦課情報.getFuKibetsuGaku13() != null && Decimal.ZERO.compareTo(賦課情報.getFuKibetsuGaku13()) == -1) {
            int 期別 = 期月リスト.get月の期(Tsuki.翌年度4月).get期AsInt();
            if (0 < 期別) {
                saveTemp(賦課情報, 科目, 期別, 賦課納期取得.get普徴納期(期別).get納期限(), 賦課情報.getFuKibetsuGaku13());
            }
        }
        if (賦課情報.getFuKibetsuGaku14() != null && Decimal.ZERO.compareTo(賦課情報.getFuKibetsuGaku14()) == -1) {
            int 期別 = 期月リスト.get月の期(Tsuki.翌年度5月).get期AsInt();
            if (0 < 期別) {
                saveTemp(賦課情報, 科目, 期別, 賦課納期取得.get普徴納期(期別).get納期限(), 賦課情報.getFuKibetsuGaku14());
            }
        }
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
        if (parameter.is当初処理()) {
            entity.setChoteiJiyuCode(当初処理);
        } else {
            entity.setChoteiJiyuCode(非当初処理);
        }
        YMDHMS 調定日時 = 賦課情報.getChoteiNichiji();
        if (調定日時 != null && !調定日時.isEmpty()) {
            entity.setChoteiYMD(調定日時.getDate());
        }
        entity.setChoteigaku(調定額);
        entity.setShohizei(Decimal.ZERO);
        entity.setNokigenYMD(納期限);
        entity.setFukaShoriJokyo(false);
        return entity;
    }
}
