/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.shuruishikyugendogakumain;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.shuruishikyugendogakumain.ShuruiShikyuGendogakuMainResult;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyugendogaku.KubunShikyuGendogakuYokaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shuruishikyugendogakumain.ShuruiShikyuGendogakuMainListParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7111ServiceShuruiShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shuruishikyugendogakumain.ShuruiShikyuGendogakuMainEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT7111ServiceShuruiShikyuGendoGakuDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.shuruishikyugendogakumain.IShuruiShikyuGendogakuMainMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7130KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7130KaigoServiceShuruiDac;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * DBC4210011_種類支給限度額登録のFinderです。
 *
 * @reamsid_L DBC-3440-010 lihang
 */
public class ShuruiShikyuGendogakuMainFinder {

    private final DbT7111ServiceShuruiShikyuGendoGakuDac 種類支給限度額取得Dac;
    private final DbT7130KaigoServiceShuruiDac 介護サービス種類データ取得Dac;
    private RString 支給限度額要介護状態区分;
    private final RString numone = new RString("1");
    private final RString numtwo = new RString("2");
    private final RString numthree = new RString("3");
    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public ShuruiShikyuGendogakuMainFinder() {
        this.種類支給限度額取得Dac = InstanceProvider.create(DbT7111ServiceShuruiShikyuGendoGakuDac.class);
        this.介護サービス種類データ取得Dac = InstanceProvider.create(DbT7130KaigoServiceShuruiDac.class);
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShuruiShikyuGendogakuMainFinder}のインスタンスを返します。
     *
     * @return HihokenshaDaichoIchiranHyoFinder
     */
    public static ShuruiShikyuGendogakuMainFinder createInstance() {
        return InstanceProvider.create(ShuruiShikyuGendogakuMainFinder.class);
    }

    /**
     * 種類支給限度額取得のメソッドです。
     *
     * @return List<ShuruiShikyuGendogakuMainEntity>
     */
    public List<ShuruiShikyuGendogakuMainResult> get種類支給限度額() {

        List<ShuruiShikyuGendogakuMainResult> resultList
                = new ArrayList<>();
        List<DbT7111ServiceShuruiShikyuGendoGakuEntity> dbT7111list
                = 種類支給限度額取得Dac.select種類支給限度額();
        List<ShuruiShikyuGendogakuMainEntity> list = new ArrayList<>();
        for (DbT7111ServiceShuruiShikyuGendoGakuEntity entity : dbT7111list) {
            支給限度額要介護状態区分 = entity.getYoKaigoJotaiKubun();
            if (KubunShikyuGendogakuYokaigoJotaiKubun.経過介護.getコード().equals(支給限度額要介護状態区分)
                    && getForList(list, entity).equals(numthree)) {
                list.add(new ShuruiShikyuGendogakuMainEntity(entity.getTekiyoKaishiYM(), entity.getTekiyoShuryoYM(),
                        entity.getServiceShuruiCode(), entity.getShikyuGendoTaniSu(),
                        Decimal.ZERO, Decimal.ZERO, Decimal.ZERO, Decimal.ZERO, Decimal.ZERO, Decimal.ZERO, Decimal.ZERO));
            } else if (KubunShikyuGendogakuYokaigoJotaiKubun.要支援1.getコード().equals(支給限度額要介護状態区分)
                    && getForList(list, entity).equals(numthree)) {
                list.add(new ShuruiShikyuGendogakuMainEntity(entity.getTekiyoKaishiYM(), entity.getTekiyoShuryoYM(),
                        entity.getServiceShuruiCode(),
                        Decimal.ZERO, entity.getShikyuGendoTaniSu(), Decimal.ZERO, Decimal.ZERO, Decimal.ZERO,
                        Decimal.ZERO, Decimal.ZERO, Decimal.ZERO));
            } else if (KubunShikyuGendogakuYokaigoJotaiKubun.要支援2.getコード().equals(支給限度額要介護状態区分)
                    && getForList(list, entity).equals(numthree)) {
                list.add(new ShuruiShikyuGendogakuMainEntity(entity.getTekiyoKaishiYM(), entity.getTekiyoShuryoYM(),
                        entity.getServiceShuruiCode(),
                        Decimal.ZERO, Decimal.ZERO, entity.getShikyuGendoTaniSu(), Decimal.ZERO, Decimal.ZERO,
                        Decimal.ZERO, Decimal.ZERO, Decimal.ZERO));
            } else if (KubunShikyuGendogakuYokaigoJotaiKubun.要介護1.getコード().equals(支給限度額要介護状態区分)
                    && getForList(list, entity).equals(numthree)) {
                list.add(new ShuruiShikyuGendogakuMainEntity(entity.getTekiyoKaishiYM(), entity.getTekiyoShuryoYM(),
                        entity.getServiceShuruiCode(),
                        Decimal.ZERO, Decimal.ZERO, Decimal.ZERO, entity.getShikyuGendoTaniSu(), Decimal.ZERO,
                        Decimal.ZERO, Decimal.ZERO, Decimal.ZERO));
            } else if (KubunShikyuGendogakuYokaigoJotaiKubun.要介護2.getコード().equals(支給限度額要介護状態区分)
                    && getForLists(list, entity).equals(numthree)) {
                list.add(new ShuruiShikyuGendogakuMainEntity(entity.getTekiyoKaishiYM(), entity.getTekiyoShuryoYM(),
                        entity.getServiceShuruiCode(),
                        Decimal.ZERO, Decimal.ZERO, Decimal.ZERO, Decimal.ZERO, entity.getShikyuGendoTaniSu(),
                        Decimal.ZERO, Decimal.ZERO, Decimal.ZERO));
            } else if (KubunShikyuGendogakuYokaigoJotaiKubun.要介護3.getコード().equals(支給限度額要介護状態区分)
                    && getForLists(list, entity).equals(numthree)) {
                list.add(new ShuruiShikyuGendogakuMainEntity(entity.getTekiyoKaishiYM(), entity.getTekiyoShuryoYM(),
                        entity.getServiceShuruiCode(),
                        Decimal.ZERO, Decimal.ZERO, Decimal.ZERO, Decimal.ZERO, Decimal.ZERO,
                        entity.getShikyuGendoTaniSu(), Decimal.ZERO, Decimal.ZERO));
            } else if (KubunShikyuGendogakuYokaigoJotaiKubun.要介護4.getコード().equals(支給限度額要介護状態区分)
                    && getForLists(list, entity).equals(numthree)) {
                list.add(new ShuruiShikyuGendogakuMainEntity(entity.getTekiyoKaishiYM(), entity.getTekiyoShuryoYM(),
                        entity.getServiceShuruiCode(),
                        Decimal.ZERO, Decimal.ZERO, Decimal.ZERO, Decimal.ZERO, Decimal.ZERO, Decimal.ZERO,
                        entity.getShikyuGendoTaniSu(), Decimal.ZERO));
            } else if (KubunShikyuGendogakuYokaigoJotaiKubun.要介護5.getコード().equals(支給限度額要介護状態区分)
                    && getForLists(list, entity).equals(numthree)) {
                list.add(new ShuruiShikyuGendogakuMainEntity(entity.getTekiyoKaishiYM(), entity.getTekiyoShuryoYM(),
                        entity.getServiceShuruiCode(),
                        Decimal.ZERO, Decimal.ZERO, Decimal.ZERO, Decimal.ZERO, Decimal.ZERO, Decimal.ZERO,
                        Decimal.ZERO, entity.getShikyuGendoTaniSu()));
            }
        }
        return getResultList(resultList, list);
    }

    private RString getForList(List<ShuruiShikyuGendogakuMainEntity> list,
            DbT7111ServiceShuruiShikyuGendoGakuEntity entity) {
        for (ShuruiShikyuGendogakuMainEntity kuMainEntity : list) {
            if (KubunShikyuGendogakuYokaigoJotaiKubun.経過介護.getコード().equals(entity.getYoKaigoJotaiKubun())
                    && kuMainEntity.get適用開始年月().equals(entity.getTekiyoKaishiYM())
                    && kuMainEntity.getサービス種類コード().equals(entity.getServiceShuruiCode())) {
                if (kuMainEntity.get経過介護支給限度額().equals(Decimal.ZERO)) {
                    kuMainEntity.set経過介護支給限度額(entity.getShikyuGendoTaniSu());
                    return numone;
                }
                return numtwo;
            } else if (KubunShikyuGendogakuYokaigoJotaiKubun.要支援1.getコード().equals(entity.getYoKaigoJotaiKubun())
                    && kuMainEntity.get適用開始年月().equals(entity.getTekiyoKaishiYM())
                    && kuMainEntity.getサービス種類コード().equals(entity.getServiceShuruiCode())) {
                if (kuMainEntity.get要支援１支給限度額().equals(Decimal.ZERO)) {
                    kuMainEntity.set要支援１支給限度額(entity.getShikyuGendoTaniSu());
                    return numone;
                }
                return numtwo;
            } else if (KubunShikyuGendogakuYokaigoJotaiKubun.要支援2.getコード().equals(entity.getYoKaigoJotaiKubun())
                    && kuMainEntity.get適用開始年月().equals(entity.getTekiyoKaishiYM())
                    && kuMainEntity.getサービス種類コード().equals(entity.getServiceShuruiCode())) {
                if (kuMainEntity.get要支援2支給限度額().equals(Decimal.ZERO)) {
                    kuMainEntity.set要支援2支給限度額(entity.getShikyuGendoTaniSu());
                    return numone;
                }
                return numtwo;
            } else if (KubunShikyuGendogakuYokaigoJotaiKubun.要介護1.getコード().equals(entity.getYoKaigoJotaiKubun())
                    && kuMainEntity.get適用開始年月().equals(entity.getTekiyoKaishiYM())
                    && kuMainEntity.getサービス種類コード().equals(entity.getServiceShuruiCode())) {
                if (kuMainEntity.get要介護１支給限度額().equals(Decimal.ZERO)) {
                    kuMainEntity.set要介護１支給限度額(entity.getShikyuGendoTaniSu());
                    return numone;
                }
                return numtwo;
            }
        }
        return numthree;
    }

    private RString getForLists(List<ShuruiShikyuGendogakuMainEntity> list,
            DbT7111ServiceShuruiShikyuGendoGakuEntity entity) {
        for (ShuruiShikyuGendogakuMainEntity kuMainEntity : list) {
            if (KubunShikyuGendogakuYokaigoJotaiKubun.要介護2.getコード().equals(entity.getYoKaigoJotaiKubun())
                    && kuMainEntity.get適用開始年月().equals(entity.getTekiyoKaishiYM())
                    && kuMainEntity.getサービス種類コード().equals(entity.getServiceShuruiCode())) {
                if (kuMainEntity.get要介護２支給限度額().equals(Decimal.ZERO)) {
                    kuMainEntity.set要介護２支給限度額(entity.getShikyuGendoTaniSu());
                    return numone;
                }
                return numtwo;
            } else if (KubunShikyuGendogakuYokaigoJotaiKubun.要介護3.getコード().equals(entity.getYoKaigoJotaiKubun())
                    && kuMainEntity.get適用開始年月().equals(entity.getTekiyoKaishiYM())
                    && kuMainEntity.getサービス種類コード().equals(entity.getServiceShuruiCode())) {
                if (kuMainEntity.get要介護３支給限度額().equals(Decimal.ZERO)) {
                    kuMainEntity.set要介護３支給限度額(entity.getShikyuGendoTaniSu());
                    return numone;
                }
                return numtwo;
            } else if (KubunShikyuGendogakuYokaigoJotaiKubun.要介護4.getコード().equals(entity.getYoKaigoJotaiKubun())
                    && kuMainEntity.get適用開始年月().equals(entity.getTekiyoKaishiYM())
                    && kuMainEntity.getサービス種類コード().equals(entity.getServiceShuruiCode())) {
                if (kuMainEntity.get要介護４支給限度額().equals(Decimal.ZERO)) {
                    kuMainEntity.set要介護４支給限度額(entity.getShikyuGendoTaniSu());
                    return numone;
                }
                return numtwo;
            } else if (KubunShikyuGendogakuYokaigoJotaiKubun.要介護5.getコード().equals(entity.getYoKaigoJotaiKubun())
                    && kuMainEntity.get適用開始年月().equals(entity.getTekiyoKaishiYM())
                    && kuMainEntity.getサービス種類コード().equals(entity.getServiceShuruiCode())) {
                if (kuMainEntity.get要介護５支給限度額().equals(Decimal.ZERO)) {
                    kuMainEntity.set要介護５支給限度額(entity.getShikyuGendoTaniSu());
                    return numone;
                }
                return numtwo;
            }
        }
        return numthree;
    }

    private List<ShuruiShikyuGendogakuMainResult> getResultList(
            List<ShuruiShikyuGendogakuMainResult> resultList, List<ShuruiShikyuGendogakuMainEntity> list) {
        if (list.isEmpty()) {
            return resultList;
        } else {
            for (ShuruiShikyuGendogakuMainEntity entity : list) {
                resultList.add(new ShuruiShikyuGendogakuMainResult(entity));
            }
            return resultList;
        }
    }

    /**
     * 介護サービス種類データ取得のメソッドです。
     *
     * @param サービス種類コード ServiceShuruiCode
     * @param 適用期間From FlexibleYearMonth
     *
     * @return List<ShuruiShikyuGendogakuMainResult>
     */
    public List<ShuruiShikyuGendogakuMainResult> select介護サービス種類データ(ServiceShuruiCode サービス種類コード,
            FlexibleYearMonth 適用期間From) {
        List<ShuruiShikyuGendogakuMainResult> list = new ArrayList<>();
        List<DbT7130KaigoServiceShuruiEntity> entityList = 介護サービス種類データ取得Dac.select介護サービス種類データ(サービス種類コード, 適用期間From);
        for (DbT7130KaigoServiceShuruiEntity entity : entityList) {
            list.add(new ShuruiShikyuGendogakuMainResult(entity));
        }
        return list;
    }

    /**
     * 「追加する」ボタン押下による入力の場合のメソッドです。
     *
     * @param サービス種類コード ServiceShuruiCode
     * @param 適用開始年月 FlexibleYearMonth
     * @param 適用終了年月 FlexibleYearMonth
     * @param 要介護状態区分 RString
     * @param 履歴番号 int
     * @param 支給限度単位数 Decimal
     *
     * @return int
     */
    public int insert追加(ServiceShuruiCode サービス種類コード,
            RString 要介護状態区分,
            FlexibleYearMonth 適用開始年月,
            int 履歴番号,
            FlexibleYearMonth 適用終了年月,
            Decimal 支給限度単位数) {
        DbT7111ServiceShuruiShikyuGendoGakuEntity entity = new DbT7111ServiceShuruiShikyuGendoGakuEntity();
        entity.setServiceShuruiCode(サービス種類コード);
        entity.setYoKaigoJotaiKubun(numone);
        entity.setTekiyoKaishiYM(適用終了年月);
        entity.setRirekiNo(履歴番号);
        entity.getTekiyoShuryoYM();
        entity.setShikyuGendoTaniSu(支給限度単位数);
        return 種類支給限度額取得Dac.save(entity);
    }

    /**
     * pamaでサービス種類支給限度額を取得します。
     *
     * @param サービス種類コード ServiceShuruiCode
     * @param 適用終了年月 FlexibleYearMonth
     * @return List<ShuruiShikyuGendogakuMainResult>
     */
    public List<ShuruiShikyuGendogakuMainResult> selectByPama(
            ServiceShuruiCode サービス種類コード,
            FlexibleYearMonth 適用終了年月) {
        List<DbT7111ServiceShuruiShikyuGendoGakuEntity> list
                = 種類支給限度額取得Dac.selectByPama(サービス種類コード, 適用終了年月);
        List<ShuruiShikyuGendogakuMainResult> resultList
                = new ArrayList<>();
        for (DbT7111ServiceShuruiShikyuGendoGakuEntity entity : list) {
            resultList.add(new ShuruiShikyuGendogakuMainResult(entity));
        }
        return resultList;
    }

    /**
     * 主キーでサービス種類支給限度額を取得します。
     *
     * @param サービス種類コード ServiceShuruiCode
     * @param 要介護状態区分 YoKaigoJotaiKubun
     * @param 適用開始年月 TekiyoKaishuYM
     * @return ShuruiShikyuGendogakuMainResult
     */
    public ShuruiShikyuGendogakuMainResult selectByKey(
            ServiceShuruiCode サービス種類コード,
            RString 要介護状態区分,
            FlexibleYearMonth 適用開始年月) {
        DbT7111ServiceShuruiShikyuGendoGakuEntity entity
                = 種類支給限度額取得Dac.selectByKey(サービス種類コード, 要介護状態区分, 適用開始年月, 1);
        return new ShuruiShikyuGendogakuMainResult(entity);
    }

    /**
     * entityを保存します。
     *
     * @param entity DbT7111ServiceShuruiShikyuGendoGakuEntity
     * @return int
     */
    public int saveEntity(DbT7111ServiceShuruiShikyuGendoGakuEntity entity) {
        return 種類支給限度額取得Dac.save(entity);
    }

    /**
     * entityを保存します。
     *
     * @param サービス種類コード ServiceShuruiCode
     * @param 要介護状態区分 YoKaigoJotaiKubun
     * @param 適用開始年月 TekiyoKaishuYM
     * @param 支給限度単位数 Decimal
     * @return int
     */
    public int saveEntitys(ServiceShuruiCode サービス種類コード,
            RString 要介護状態区分,
            FlexibleYearMonth 適用開始年月,
            Decimal 支給限度単位数) {
        DbT7111ServiceShuruiShikyuGendoGakuEntity entity = new DbT7111ServiceShuruiShikyuGendoGakuEntity();
        entity.setServiceShuruiCode(サービス種類コード);
        entity.setYoKaigoJotaiKubun(要介護状態区分);
        entity.setTekiyoKaishiYM(適用開始年月);
        entity.setShikyuGendoTaniSu(支給限度単位数);
        return 種類支給限度額取得Dac.save(entity);
    }

    /**
     * entityを削除します。
     *
     * @param parameter ShuruiShikyuGendogakuMainListParameter
     */
    public void deleteEntity(ShuruiShikyuGendogakuMainListParameter parameter) {
        IShuruiShikyuGendogakuMainMapper mapper = mapperProvider.create(IShuruiShikyuGendogakuMainMapper.class);
        mapper.deletEntity(parameter);
    }
}
