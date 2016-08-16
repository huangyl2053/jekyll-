/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.kaigofukachoshuyuyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo.chochuyuyo.ChoshuYuyo;
import jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo.choshuyuyojoho.ChoshuYuyoJoho;
import jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo.kibetsuchochuyuyo.KibetsuChoshuYuyo;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.business.core.kaigofukachoshuyuyo.KaigoFukaChoshuYuyoParam;
import jp.co.ndensan.reams.db.dbb.business.core.kaigofukachoshuyuyo.KaigoKibetsuChoshuYuyoParam;
import jp.co.ndensan.reams.db.dbb.business.core.kakushutsuchishosakusei.KakushuTsuchishoParameter;
import jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHohoKibetsu;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.choshuyuyo.ChoshuYuyoJohoRelateMapperParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fukajoho.FukaJohoRelateMapperParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2006ChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2007KibetsuChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.fukajoho.FukaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2006ChoshuYuyoDac;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2007KibetsuChoshuYuyoDac;
import jp.co.ndensan.reams.db.dbb.service.core.choshuyuyo.choshuyuyojoho.ChoshuYuyoJohoManager;
import jp.co.ndensan.reams.db.dbb.service.core.fuka.FukaManager;
import jp.co.ndensan.reams.db.dbb.service.core.fukajoho.fukajoho.FukaJohoManager;
import jp.co.ndensan.reams.db.dbb.service.report.kakushutsuchishosakusei.KakushuTsuchishoSakusei;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 介護保険料徴収猶予
 *
 * @reamsid_L DBB-1680-060 gongliang
 */
public class KaigoFukaChoshuYuyo {

    private final ChoshuYuyoJohoManager 徴収猶予情報Manager;
    private final DbT2006ChoshuYuyoDac 介護賦課徴収猶予Dac;
    private final DbT2007KibetsuChoshuYuyoDac 介護期別徴収猶予Dac;
    private final FukaJohoManager 介護賦課Manager;

    private static final int 定値_イチ = 1;
    private static final RString Dミ = new RString("D3");
    private static final RString Dヨ = new RString("D4");
    private static final RString 区分_0 = new RString("0");
    private static final RString 区分_1 = new RString("1");
    private static final RString 区分_2 = new RString("2");
    private static final RString 区分_3 = new RString("3");
    private static final RString 区分_4 = new RString("4");
    private static final RString 画面状況_新規 = new RString("新規申請");
    private static final RString 画面状況_申請中 = new RString("申請中");
    private static final RString 画面状況_決定済 = new RString("決定済");

    /**
     * コンストラクタです。
     */
    public KaigoFukaChoshuYuyo() {
        this.介護賦課Manager = FukaJohoManager.createInstance();
        this.徴収猶予情報Manager = ChoshuYuyoJohoManager.createInstance();
        this.介護賦課徴収猶予Dac = InstanceProvider.create(DbT2006ChoshuYuyoDac.class);
        this.介護期別徴収猶予Dac = InstanceProvider.create(DbT2007KibetsuChoshuYuyoDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KaigoFukaChoshuYuyo}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link KaigoFukaChoshuYuyo}のインスタンス
     */
    public static KaigoFukaChoshuYuyo createInstance() {
        return InstanceProvider.create(KaigoFukaChoshuYuyo.class);
    }

    /**
     * 介護保険料徴収猶予情報取得する。
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 通知書番号 TsuchishoNo
     * @return 徴収猶予情報
     */
    public ChoshuYuyoJoho getJokyo(FlexibleYear 調定年度, FlexibleYear 賦課年度, TsuchishoNo 通知書番号) {
        ChoshuYuyoJohoRelateMapperParameter parameter = ChoshuYuyoJohoRelateMapperParameter.createSelectByKeyParam(調定年度, 賦課年度, 通知書番号);
        return 徴収猶予情報Manager.select最新の徴収猶予の情報(parameter);
    }

    /**
     * ＤＢへ介護賦課、介護賦課徴収猶予、介護期別徴収猶予、介護期別、調定共通（介護継承）データを登録する。
     *
     * @param 徴収猶予の情報 ChoshuYuyoJoho
     * @param 画面情報param KaigoFukaChoshuYuyoParam
     */
    public void saveDBDate(ChoshuYuyoJoho 徴収猶予の情報, KaigoFukaChoshuYuyoParam 画面情報param) {
        RString 状況 = 画面情報param.get状況();
        boolean 決定区分 = 画面情報param.is決定区分();
        boolean 登録flag = false;
        int 履歴番号 = 徴収猶予の情報.get履歴番号();
        if ((画面状況_申請中.equals(状況) && 決定区分)
                || (画面状況_決定済.equals(状況))) {
            設定登録用賦課情報(徴収猶予の情報, 画面情報param);
            履歴番号 = 履歴番号 + 定値_イチ;
            登録flag = true;
        }
        設定登録用徴収猶予情報(履歴番号, 徴収猶予の情報, 画面情報param, 登録flag);
        設定登録用介護期別徴収猶予(履歴番号, 徴収猶予の情報, 画面情報param, 登録flag);
    }

    private void 設定登録用介護期別徴収猶予(int 履歴番号, ChoshuYuyoJoho 徴収猶予の情報, KaigoFukaChoshuYuyoParam 画面情報param, boolean 登録flag) {
        List<KaigoKibetsuChoshuYuyoParam> 介護期別徴収猶予データList = 画面情報param.get介護期別徴収猶予データ();
        if (介護期別徴収猶予データList == null || 介護期別徴収猶予データList.isEmpty()) {
            return;
        }
        FlexibleYear 調定年度 = 画面情報param.get調定年度();
        FlexibleYear 賦課年度 = 画面情報param.get賦課年度();
        TsuchishoNo 通知書番号 = 画面情報param.get通知書番号();
        DbT2007KibetsuChoshuYuyoEntity 介護期別徴収猶予Entity = new DbT2007KibetsuChoshuYuyoEntity();
        介護期別徴収猶予Entity.setChoteiNendo(調定年度);
        介護期別徴収猶予Entity.setFukaNendo(賦課年度);
        介護期別徴収猶予Entity.setTsuchishoNo(通知書番号);
        介護期別徴収猶予Entity.setRirekiNo(履歴番号);
        介護期別徴収猶予Entity.setChoshuHoho(ChoshuHohoKibetsu.普通徴収.getコード());
        List<ChoshuYuyo> list = 徴収猶予の情報.getChoshuYuyoList();
        ChoshuYuyo del介護賦課徴収猶予 = null;
        if (!登録flag && list != null && !list.isEmpty()) {
            del介護賦課徴収猶予 = 徴収猶予の情報.getChoshuYuyoList().get(0);
        }
        for (KaigoKibetsuChoshuYuyoParam 介護期別徴収猶予データ : 介護期別徴収猶予データList) {
            int 期 = 介護期別徴収猶予データ.get期();
            delete介護期別徴収猶予(期, del介護賦課徴収猶予);
            DbT2007KibetsuChoshuYuyoEntity entity = 介護期別徴収猶予Entity;
            entity.setKi(期);
            entity.setYuyoStartYMD(介護期別徴収猶予データ.get徴収猶予開始日());
            entity.setYuyoEndYMD(介護期別徴収猶予データ.get徴収猶予終了日());
            entity.setState(EntityDataState.Added);
            介護期別徴収猶予Dac.save(entity);
        }

    }

    private void delete介護期別徴収猶予(int 期, ChoshuYuyo del介護賦課徴収猶予) {
        if (del介護賦課徴収猶予 != null
                && del介護賦課徴収猶予.getKibetsuChoshuYuyoList() != null
                && !del介護賦課徴収猶予.getKibetsuChoshuYuyoList().isEmpty()) {
            for (KibetsuChoshuYuyo 期別徴収猶予 : del介護賦課徴収猶予.getKibetsuChoshuYuyoList()) {
                if (期別徴収猶予.get期() == 期 && ChoshuHohoKibetsu.普通徴収.getコード().equals(期別徴収猶予.get徴収方法())) {
                    DbT2007KibetsuChoshuYuyoEntity entity = 期別徴収猶予.toEntity();
                    entity.setState(EntityDataState.Deleted);
                    介護期別徴収猶予Dac.delete(entity);
                    return;
                }
            }
        }
    }

    private void 設定登録用徴収猶予情報(int 履歴番号, ChoshuYuyoJoho 徴収猶予の情報, KaigoFukaChoshuYuyoParam 画面情報param, boolean 登録flag) {
        RString 減免状態区分 = get区分(区分_1, 画面情報param);
        RString 減免作成区分 = get区分(区分_2, 画面情報param);
        FlexibleYear 調定年度 = 画面情報param.get調定年度();
        FlexibleYear 賦課年度 = 画面情報param.get賦課年度();
        TsuchishoNo 通知書番号 = 画面情報param.get通知書番号();
        List<ChoshuYuyo> list = 徴収猶予の情報.getChoshuYuyoList();
        if (!登録flag && list != null && !list.isEmpty()) {
            DbT2006ChoshuYuyoEntity del介護賦課徴収猶予 = list.get(0).toEntity();
            if (del介護賦課徴収猶予 != null) {
                del介護賦課徴収猶予.setState(EntityDataState.Deleted);
                介護賦課徴収猶予Dac.delete(del介護賦課徴収猶予);
            }
        }
        DbT2006ChoshuYuyoEntity 介護賦課徴収猶予Entity = new DbT2006ChoshuYuyoEntity();
        介護賦課徴収猶予Entity.setChoteiNendo(調定年度);
        介護賦課徴収猶予Entity.setFukaNendo(賦課年度);
        介護賦課徴収猶予Entity.setTsuchishoNo(通知書番号);
        介護賦課徴収猶予Entity.setRirekiNo(履歴番号);
        介護賦課徴収猶予Entity.setShinseiYMD(画面情報param.get申請日());
        介護賦課徴収猶予Entity.setKetteiYMD(画面情報param.get決定日());
        介護賦課徴収猶予Entity.setTorikeshiYMD(画面情報param.get取消日());
        介護賦課徴収猶予Entity.setJotaiKubun(減免状態区分);
        介護賦課徴収猶予Entity.setSakuseiKubun(減免作成区分);
        介護賦課徴収猶予Entity.setShinseiJiyu(画面情報param.get申請事由());
        介護賦課徴収猶予Entity.setYuyoJiyuCode(画面情報param.get徴収猶予種類コード());
        介護賦課徴収猶予Entity.setYuyoJiyu(画面情報param.get徴収猶予事由());
        介護賦課徴収猶予Entity.setYuyoTorikeshiJiyuCode(画面情報param.get徴収猶予取消種類コード());
        介護賦課徴収猶予Entity.setYuyoTorikeshiJiyu(画面情報param.get徴収猶予取消事由());
        介護賦課徴収猶予Entity.setState(EntityDataState.Added);
        介護賦課徴収猶予Dac.save(介護賦課徴収猶予Entity);
    }

    private void 設定登録用賦課情報(ChoshuYuyoJoho 徴収猶予の情報, KaigoFukaChoshuYuyoParam 画面情報param) {
        FlexibleDate 取消日 = 画面情報param.get取消日();
        FukaJohoRelateEntity 賦課の情報RelateEntity = 徴収猶予の情報.get賦課の情報RelateEntity();
        DbT2002FukaEntity 賦課情報_介護賦課 = 賦課の情報RelateEntity.get介護賦課Entity();
        賦課情報_介護賦課.setRirekiNo(徴収猶予の情報.get履歴番号() + 定値_イチ);
        賦課情報_介護賦課.setChoteiNichiji(YMDHMS.now());
        賦課情報_介護賦課.setKoseiM(new RString(YMDHMS.now().getMonthValue()));
        if (取消日 != null && !取消日.isEmpty()) {
            賦課情報_介護賦課.setChoteiJiyu1(Dヨ);
        } else {
            賦課情報_介護賦課.setChoteiJiyu1(Dミ);
        }
        賦課の情報RelateEntity.set介護賦課Entity(賦課情報_介護賦課);
        FukaManager.createInstance().save賦課(new FukaJoho(賦課の情報RelateEntity));
    }

    private RString get区分(RString 減免区分, KaigoFukaChoshuYuyoParam 画面情報param) {
        RString 状況 = 画面情報param.get状況();
        boolean 決定区分 = 画面情報param.is決定区分();
        FlexibleDate 取消日 = 画面情報param.get取消日();
        FlexibleDate 決定日 = 画面情報param.get決定日();
        RString 減免状態区分;
        RString 減免作成区分;
        if (画面状況_新規.equals(状況)) {
            if (決定日 == null || 決定日.isEmpty()) {
                減免状態区分 = 区分_0;
                減免作成区分 = 区分_0;
            } else {
                RString 区分 = 決定区分 ? 区分_1 : 区分_2;
                減免状態区分 = 区分;
                減免作成区分 = 区分;
            }
        } else if (画面状況_申請中.equals(状況)) {
            減免状態区分 = get区分_申請中(区分_1, 取消日, 決定日, 決定区分);
            減免作成区分 = get区分_申請中(区分_2, 取消日, 決定日, 決定区分);
        } else {
            if ((取消日 == null || 取消日.isEmpty())) {
                減免状態区分 = 決定区分 ? 区分_1 : 区分_2;
                減免作成区分 = 区分_4;
            } else {
                減免状態区分 = 決定区分 ? 区分_1 : 区分_2;
                減免作成区分 = 区分_3;
            }
        }
        return 区分_1.equals(減免区分) ? 減免状態区分 : 減免作成区分;
    }

    private RString get区分_申請中(RString 減免区分, FlexibleDate 取消日, FlexibleDate 決定日, boolean 決定区分) {
        RString 減免状態区分;
        RString 減免作成区分;
        if ((取消日 == null || 取消日.isEmpty()) && (決定日 == null || 決定日.isEmpty())) {
            減免状態区分 = 区分_0;
            減免作成区分 = 区分_0;
        } else if ((取消日 == null || 取消日.isEmpty()) && (決定日 != null && !決定日.isEmpty())) {
            RString 区分 = 決定区分 ? 区分_1 : 区分_2;
            減免状態区分 = 区分;
            減免作成区分 = 区分;
        } else {
            減免状態区分 = 区分_0;
            減免作成区分 = 区分_3;
        }
        return 区分_1.equals(減免区分) ? 減免状態区分 : 減免作成区分;
    }

    /**
     * 介護保険料徴収猶予情報取得する。
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 通知書番号 TsuchishoNo
     * @return 徴収猶予情報
     */
    public ChoshuYuyoJoho getChoshuYuyoJoho(FlexibleYear 調定年度, FlexibleYear 賦課年度, TsuchishoNo 通知書番号) {
        ChoshuYuyoJohoRelateMapperParameter parameter = ChoshuYuyoJohoRelateMapperParameter.createSelectByKeyParam(調定年度, 賦課年度, 通知書番号);
        return 徴収猶予情報Manager.select徴収猶予の情報_最新(parameter);
    }

    /**
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 通知書番号 TsuchishoNo
     * @return 賦課の情報 FukaJoho
     */
    public FukaJoho getFukaJoho(FlexibleYear 調定年度, FlexibleYear 賦課年度, TsuchishoNo 通知書番号) {
        FukaJohoRelateMapperParameter param = FukaJohoRelateMapperParameter.createSelectListParam(調定年度, 賦課年度, 通知書番号);
        return 介護賦課Manager.select賦課の情報_最新(param);
    }

    /**
     * 通知書発行のメソッドです。
     *
     * @param param parameter
     * @return SourceDataCollection
     */
    public SourceDataCollection publish(KakushuTsuchishoParameter param) {
        SourceDataCollection sourceDataCollection = KakushuTsuchishoSakusei.createInstance().publish(param);
        return sourceDataCollection;
    }
}
