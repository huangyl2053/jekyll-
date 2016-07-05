/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.kaigohokenryogemmen;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.business.core.basic.ChoshuHoho;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.NendobunFukaGemmenList;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.business.core.gemmen.gemmenjoho.GemmenJoho;
import jp.co.ndensan.reams.db.dbb.business.core.kaigohokenryogemmen.KaigoHokenryoGemmenParam;
import jp.co.ndensan.reams.db.dbb.business.core.kaigohokenryogemmen.NendobunFukaGemmenListResult;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.gemmen.GemmenJohoRelateMapperParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2004GemmenEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.fukajoho.FukaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2001ChoshuHohoDac;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2004GemmenDac;
import jp.co.ndensan.reams.db.dbb.service.core.fuka.FukaManager;
import jp.co.ndensan.reams.db.dbb.service.core.gemmen.gemmenjoho.GemmenJohoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 介護保険料減免
 *
 * @reamsid_L DBB-1660-060 gongliang
 */
public class KaigoHokenryoGemmen {

    private final GemmenJohoManager 減免情報Manager;
    private final DbT2004GemmenDac 介護賦課減免Dac;
    private final DbT2001ChoshuHohoDac 介護徴収方法Dac;
    private static final int 定値_ゼロ = 1;
    private static final int 定値_イチ = 1;
    private static final int 定値_二 = 2;
    private static final RString 定値_イチR = new RString("1");
    private static final RString 区分_0 = new RString("0");
    private static final RString 区分_1 = new RString("1");
    private static final RString 区分_2 = new RString("2");
    private static final RString 区分_3 = new RString("3");
    private static final RString 区分_4 = new RString("4");
    private static final RString D二 = new RString("D2");
    private static final RString Dイチ = new RString("D1");
    private static final RString 画面状況_新規 = new RString("新規申請");
    private static final RString 画面状況_申請中 = new RString("申請中");
    private static final RString 画面状況_決定済 = new RString("決定済");
    private static final RString 調定年度R = new RString("調定年度");
    private static final RString 賦課年度R = new RString("賦課年度");
    private static final RString 減免情報R = new RString("減免情報");
    private static final RString 画面情報PARAM = new RString("減免情報");
    private static final RString 通知書番号R = new RString("通知書番号");

    /**
     * コンストラクタです。
     */
    public KaigoHokenryoGemmen() {
        減免情報Manager = GemmenJohoManager.createInstance();
        介護賦課減免Dac = InstanceProvider.create(DbT2004GemmenDac.class);
        介護徴収方法Dac = InstanceProvider.create(DbT2001ChoshuHohoDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KaigoHokenryoGemmen}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link KaigoHokenryoGemmen}のインスタンス
     */
    public static KaigoHokenryoGemmen createInstance() {
        return InstanceProvider.create(KaigoHokenryoGemmen.class);
    }

    /**
     * 全賦課履歴情報のキー（調定年度、賦課年度、通知書番号）より、介護保険料減免情報を取得する。
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 通知書番号 TsuchishoNo
     * @param 被保険者番号 HihokenshaNo
     * @return 年度分賦課減免リストと徴収方法
     */
    public NendobunFukaGemmenListResult getJokyo(FlexibleYear 調定年度, FlexibleYear 賦課年度, TsuchishoNo 通知書番号, HihokenshaNo 被保険者番号) {
        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage(調定年度R.toString()));
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage(賦課年度R.toString()));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage(通知書番号R.toString()));
        NendobunFukaGemmenListResult result = new NendobunFukaGemmenListResult();
        NendobunFukaGemmenList 年度分賦課減免リスト = new NendobunFukaGemmenList();
        GemmenJohoRelateMapperParameter 減免の情報検索条件
                = GemmenJohoRelateMapperParameter.createSelectListParam(調定年度, 賦課年度, 通知書番号);
        GemmenJoho 減免情報_現年度 = 減免情報Manager.get最新の減免情報(減免の情報検索条件);
        if (減免情報_現年度 != null) {
            年度分賦課減免リスト.set現年度(減免情報_現年度);
            年度分賦課減免リスト.set最新減免の情報(減免情報_現年度);
            年度分賦課減免リスト.set賦課期日(減免情報_現年度.get賦課期日());
        }
        GemmenJohoRelateMapperParameter 減免の情報検索条件1
                = GemmenJohoRelateMapperParameter.createSelectListParam(賦課年度.plusYear(定値_イチ), 賦課年度, 通知書番号);
        GemmenJoho 減免情報_過年度1 = 減免情報Manager.get最新の減免情報(減免の情報検索条件1);
        if (減免情報_過年度1 != null) {
            年度分賦課減免リスト.set過年度1(減免情報_過年度1);
            年度分賦課減免リスト.set最新減免の情報(減免情報_過年度1);
            年度分賦課減免リスト.setHas過年度賦課(true);
            年度分賦課減免リスト.set賦課期日(減免情報_過年度1.get賦課期日());
        }
        GemmenJohoRelateMapperParameter 減免の情報検索条件2
                = GemmenJohoRelateMapperParameter.createSelectListParam(賦課年度.plusYear(定値_二), 賦課年度, 通知書番号);
        GemmenJoho 減免情報_過年度2 = 減免情報Manager.get最新の減免情報(減免の情報検索条件2);
        if (減免情報_過年度2 != null) {
            年度分賦課減免リスト.set過年度2(減免情報_過年度2);
            年度分賦課減免リスト.set最新減免の情報(減免情報_過年度2);
            年度分賦課減免リスト.setHas過年度賦課(true);
            年度分賦課減免リスト.set賦課期日(減免情報_過年度2.get賦課期日());
        }
        result.set年度分賦課減免リスト(年度分賦課減免リスト);
        DbT2001ChoshuHohoEntity 介護徴収方法Entity = 介護徴収方法Dac.select(賦課年度, 被保険者番号);
        if (介護徴収方法Entity != null) {
            ChoshuHoho 徴収方法情報 = new ChoshuHoho(介護徴収方法Entity);
            result.set介護徴収方法(徴収方法情報);
        }
        return result;
    }

    /**
     * ＤＢへ介護賦課、介護賦課減免、介護期別、調定共通（介護継承）データを登録する。
     *
     * @param 減免情報 GemmenJoho
     * @param 画面情報param KaigoHokenryoGemmenParam
     */
    public void saveDBDate(GemmenJoho 減免情報, KaigoHokenryoGemmenParam 画面情報param) {
        requireNonNull(減免情報, UrSystemErrorMessages.値がnull.getReplacedMessage(減免情報R.toString()));
        requireNonNull(画面情報param, UrSystemErrorMessages.値がnull.getReplacedMessage(画面情報PARAM.toString()));
        RString 状況 = 画面情報param.get状況();
        boolean 決定区分 = 画面情報param.is決定区分();
        int 履歴番号 = 減免情報.toEntity().getRirekiNo();
        if (((画面状況_新規.equals(状況) || 画面状況_申請中.equals(状況)) && 決定区分)
                || (画面状況_決定済.equals(状況) && 決定区分)
                || (画面状況_決定済.equals(状況) && !決定区分 && 定値_イチR.equals(減免情報.get減免状態区分()))) {
            設定登録用賦課情報(減免情報, 画面情報param);
            履歴番号 = 履歴番号 + 定値_イチ;
        }
        設定登録用減免情報(履歴番号, 減免情報, 画面情報param);
    }

    private void 設定登録用賦課情報(GemmenJoho 減免情報, KaigoHokenryoGemmenParam 画面情報param) {
        RString 状況 = 画面情報param.get状況();
        boolean 決定区分 = 画面情報param.is決定区分();
        FlexibleDate 取消日 = 画面情報param.get取消日();
        Decimal 減免額 = 画面情報param.get減免額();
        FukaJohoRelateEntity 賦課の情報RelateEntity = 減免情報.get賦課の情報RelateEntity();
        DbT2002FukaEntity 賦課情報_介護賦課 = 賦課の情報RelateEntity.get介護賦課Entity();
        DbT2002FukaEntity 減免介護賦課 = 減免情報.toEntity();
        賦課情報_介護賦課.setRirekiNo(減免介護賦課.getRirekiNo() + 定値_イチ);
        賦課情報_介護賦課.setChoteiNichiji(YMDHMS.now());
        賦課情報_介護賦課.setKoseiM(new RString(YMDHMS.now().getMonthValue()));
        if (取消日 != null && !取消日.isEmpty()) {
            賦課情報_介護賦課.setChoteiJiyu1(D二);
        } else {
            賦課情報_介護賦課.setChoteiJiyu1(Dイチ);
        }
        Decimal 入力減免前介護保険料_年額 = 減免介護賦課.getGemmenMaeHokenryo();
        if ((画面状況_決定済.equals(状況) && 決定区分 && 取消日 != null && !取消日.isEmpty())
                || (画面状況_決定済.equals(状況) && !決定区分 && 定値_イチR.equals(減免情報.get減免状態区分()))) {
            賦課情報_介護賦課.setGemmenGaku(Decimal.ZERO);
            賦課情報_介護賦課.setGemmenMaeHokenryo(入力減免前介護保険料_年額);
        } else {
            賦課情報_介護賦課.setGemmenGaku(減免額);
            Decimal 賦課減免前介護保険料_年額 = 入力減免前介護保険料_年額 != null && 減免額 != null
                    ? 入力減免前介護保険料_年額.subtract(減免額) : null;
            賦課情報_介護賦課.setGemmenMaeHokenryo(賦課減免前介護保険料_年額);
        }
        賦課の情報RelateEntity.set介護賦課Entity(賦課情報_介護賦課);
        FukaManager.createInstance().save賦課(new FukaJoho(賦課の情報RelateEntity));
    }

    private void 設定登録用減免情報(int 履歴番号, GemmenJoho 減免情報, KaigoHokenryoGemmenParam 画面情報param) {
        Decimal 減免額 = 画面情報param.get減免額();
        Decimal 前回減免額 = 画面情報param.get前回減免額();
        RString 減免状態区分 = get区分(区分_1, 画面情報param);
        RString 減免作成区分 = get区分(区分_2, 画面情報param);
        Decimal 決定減免額 = 区分_1.equals(減免状態区分) ? 減免額 : Decimal.ZERO;
        Decimal 取消減免額 = null;
        if (前回減免額 != null && 減免額 != null) {
            Decimal 減免差額 = 前回減免額.subtract(減免額);
            取消減免額 = Decimal.ZERO.compareTo(減免差額) < 定値_ゼロ ? 減免差額 : Decimal.ZERO;
        }
        DbT2002FukaEntity 介護賦課Entity = 減免情報.toEntity();
        FlexibleYear 調定年度 = 介護賦課Entity.getChoteiNendo();
        FlexibleYear 賦課年度 = 介護賦課Entity.getFukaNendo();
        TsuchishoNo 通知書番号 = 介護賦課Entity.getTsuchishoNo();
        DbT2004GemmenEntity del介護賦課減免Entity = 介護賦課減免Dac.selectByKey(調定年度, 賦課年度, 通知書番号, new Decimal(履歴番号));
        if (del介護賦課減免Entity != null) {
            介護賦課減免Dac.delete(del介護賦課減免Entity);
        }
        DbT2004GemmenEntity 介護賦課減免Entity = new DbT2004GemmenEntity();
        介護賦課減免Entity.setChoteiNendo(調定年度);
        介護賦課減免Entity.setFukaNendo(賦課年度);
        介護賦課減免Entity.setTsuchishoNo(通知書番号);
        介護賦課減免Entity.setRirekiNo(new Decimal(履歴番号));
        介護賦課減免Entity.setShinseiYMD(画面情報param.get申請日());
        介護賦課減免Entity.setKetteiYMD(画面情報param.get決定日());
        介護賦課減免Entity.setTorikeshiYMD(画面情報param.get取消日());
        介護賦課減免Entity.setJotaiKubun(減免状態区分);
        介護賦課減免Entity.setSakuseiKubun(減免作成区分);
        介護賦課減免Entity.setShinseiJiyu(画面情報param.get申請事由());
        介護賦課減免Entity.setGemmenJiyuCode(画面情報param.get減免種類コード());
        介護賦課減免Entity.setGemmenJiyu(画面情報param.get減免事由());
        介護賦課減免Entity.setGemmenTorikeshiJiyuCode(画面情報param.get減免取消種類コード());
        介護賦課減免Entity.setGemmenTorikeshiJiyu(画面情報param.get減免取消事由());
        介護賦課減免Entity.setShinseiGemmenGaku(画面情報param.get申請減免額());
        介護賦課減免Entity.setKetteiGemmenGaku(決定減免額);
        介護賦課減免Entity.setTorikeshiGemmenGaku(取消減免額);
        介護賦課減免Entity.setState(EntityDataState.Added);
        介護賦課減免Dac.save(介護賦課減免Entity);
    }

    private RString get区分(RString 減免区分, KaigoHokenryoGemmenParam 画面情報param) {
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

}
