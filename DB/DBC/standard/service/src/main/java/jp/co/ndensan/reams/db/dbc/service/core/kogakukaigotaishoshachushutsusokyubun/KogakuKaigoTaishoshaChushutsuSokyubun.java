/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kogakukaigotaishoshachushutsusokyubun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukaigotaishoshachushutsusokyubun.KogakukaigotaishoshachushutsusokyubunParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigotaishoshachushutsusokyubun.HihokenshaNoFukaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigotaishoshachushutsusokyubun.ShiKaKuiDoDeTaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigotaishoshachushutsusokyubun.UaFt001FindEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT2008ShotokuKanriEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojins;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.setai.ISetai;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 高額介護対象者抽出（遡及分）
 *
 * @reamsid_L DBC-5750-050 houtianpeng
 */
public class KogakuKaigoTaishoshaChushutsuSokyubun {

    private final DbT7022ShoriDateKanriDac dbT7022Dac;
    private static final RString 処理枝番 = new RString("0000");
    private static final FlexibleYear 年度 = new FlexibleYear("0000");
    private static final RString 年度内連番 = new RString("0001");
    private static final RString 登録処理枝番 = new RString("00");
    private static final FlexibleYear 登録年度 = new FlexibleYear("0000");
    private static final RString 登録年度内連番 = new RString("0001");
    private final FlexibleYear 所得年度2015 = new FlexibleYear("2015");
    private final FlexibleYear 所得年度2014 = new FlexibleYear("2014");
    private final FlexibleYear 所得年度2013 = new FlexibleYear("2013");
    private static final int ICHI = 1;
    private static final int NI = 2;
    private static final int SAN = 3;
    private static final int YON = 4;
    private static final int GO = 5;
    private static final int ROKU = 6;
    private static final int NANA = 7;
    private static final int HACHI = 8;
    private static final int KU = 9;
    private static final int JYUU = 10;
    private static final RString 処理区分_1 = new RString("1");
    private static final RString H = new RString("H");
    private static final RString 抽出_マスタ_1 = new RString("51");
    private static final RString 日 = new RString("01");

    /**
     * コンストラクタです。
     */
    KogakuKaigoTaishoshaChushutsuSokyubun() {
        dbT7022Dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
    }

    /**
     * コンストラクタです。
     *
     * @param mapperProvider {@link MapperProvider}
     */
    KogakuKaigoTaishoshaChushutsuSokyubun(DbT7022ShoriDateKanriDac dbT7022Dac) {
        this.dbT7022Dac = dbT7022Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KogakuKaigoTaishoshaChushutsuSokyubun}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link KogakuKaigoTaishoshaChushutsuSokyubun}のインスタンス
     */
    public static KogakuKaigoTaishoshaChushutsuSokyubun createInstance() {
        return InstanceProvider.create(KogakuKaigoTaishoshaChushutsuSokyubun.class);
    }

    /**
     * 過去分実績基本抽出１(介護所得管理抽出)。
     *
     * @param 開始年月 FlexibleYearMonth
     * @param 終了年月 FlexibleYearMonth
     * @param 介護所得管理list List<DbT2008ShotokuKanriEntity>
     * @return List<ShiKaKuiDoDeTaEntity>
     */
    @Transaction
    public List<ShiKaKuiDoDeTaEntity> getKakobunJissekiKihon1(
            FlexibleYearMonth 開始年月,
            FlexibleYearMonth 終了年月,
            List<DbT2008ShotokuKanriEntity> 介護所得管理list) {
        List<ShiKaKuiDoDeTaEntity> 基本抽出1List = new ArrayList<>();
        FlexibleYearMonth 判定開始年月 = FlexibleYearMonth.EMPTY;
        FlexibleYearMonth 判定終了年月 = FlexibleYearMonth.EMPTY;
        FlexibleYearMonth 変数開始年月 = FlexibleYearMonth.EMPTY;
        FlexibleYearMonth 変数終了年月 = FlexibleYearMonth.EMPTY;
        for (DbT2008ShotokuKanriEntity entity : 介護所得管理list) {
            if (所得年度2015.isBeforeOrEquals(entity.getShotokuNendo())) {
                判定開始年月 = new FlexibleYearMonth(entity.getShotokuNendo().toDateString().concat(new RString("08")));
                判定終了年月 = new FlexibleYearMonth(entity.getShotokuNendo().plusYear(ICHI).toDateString().concat(new RString("07")));

            } else if (所得年度2014.equals(entity.getShotokuNendo())) {
                判定開始年月 = new FlexibleYearMonth("201407");
                判定終了年月 = new FlexibleYearMonth("201507");
            } else if (entity.getShotokuNendo().isBeforeOrEquals(所得年度2013)) {
                判定開始年月 = new FlexibleYearMonth(entity.getShotokuNendo().toDateString().concat(new RString("07")));
                判定終了年月 = new FlexibleYearMonth(entity.getShotokuNendo().plusYear(ICHI).toDateString().concat(new RString("06")));
            }
            if (終了年月.isBefore(判定開始年月)) {
                continue;
            }
            if (判定開始年月.isBefore(開始年月)) {
                変数開始年月 = 開始年月;
            } else {
                変数開始年月 = 判定開始年月;
            }
            if (判定終了年月.isBefore(終了年月)) {
                変数終了年月 = 判定終了年月;
            } else {
                変数終了年月 = 終了年月;
            }
            for (int i = 0; i <= Integer.valueOf(変数終了年月.getBetweenMonths(変数開始年月)); i++) {
                ShiKaKuiDoDeTaEntity sokyubunEntity = new ShiKaKuiDoDeTaEntity();
                sokyubunEntity.set識別コード(entity.getShikibetsuCode());
                sokyubunEntity.set賦課年度(entity.getShotokuNendo());
                sokyubunEntity.set年月(new FlexibleYearMonth(変数開始年月.toString()).plusMonth(i));
                sokyubunEntity.set年月日(new FlexibleDate(sokyubunEntity.get年月() + "01"));
                if (i == 0) {
                    sokyubunEntity.set抽出_マスタ1(new RString("41"));
                    sokyubunEntity.set抽出_識別コード1(entity.getShikibetsuCode().value());
                }
                基本抽出1List.add(sokyubunEntity);
            }
        }
        return 基本抽出1List;
    }

    /**
     * 過去分実績基本抽出２(宛名データ抽出)。
     *
     * @param 開始年月 開始年月
     * @param 終了年月 終了年月
     * @param listEntity List<UaFt001FindEntity>
     * @return List<ShiKaKuiDoDeTaEntity>
     */
    @Transaction
    public List<ShiKaKuiDoDeTaEntity> getKakobunJissekiKihon2(
            FlexibleYearMonth 開始年月, FlexibleYearMonth 終了年月,
            List<UaFt001FindEntity> listEntity) {
        List<ShiKaKuiDoDeTaEntity> listShiKaKuiDoDeTaEntity = new ArrayList<>();
        for (UaFt001FindEntity entity : listEntity) {
            FlexibleDate 異動年月日 = entity.getIdoYMD();
            FlexibleYearMonth 年月 = 異動年月日.getYearMonth();
            if (entity.getIdoYMD().getDayValue() != 1) {
                異動年月日 = 異動年月日.plusMonth(1);
            }
            if (年月.isBefore(開始年月)) {
                年月 = 開始年月;
            }
            if (終了年月.isBefore(年月)) {
                continue;
            }
            while (年月.isBeforeOrEquals(終了年月)) {
                ShiKaKuiDoDeTaEntity shiKaKuiDoDeTaEntity = new ShiKaKuiDoDeTaEntity();
                shiKaKuiDoDeTaEntity.set識別コード(entity.getShikibetsuCode());
                shiKaKuiDoDeTaEntity.set被保険者番号(HihokenshaNo.EMPTY);
                shiKaKuiDoDeTaEntity.set世帯コード(RString.EMPTY);
                shiKaKuiDoDeTaEntity.set賦課年度(new FlexibleYear(get賦課年度(異動年月日)));
                shiKaKuiDoDeTaEntity.set年月(異動年月日.getYearMonth());
                shiKaKuiDoDeTaEntity.set年月日(new FlexibleDate(異動年月日.getYearMonth().toDateString().concat(日)));
                shiKaKuiDoDeTaEntity.set抽出_マスタ1(抽出_マスタ_1);
                shiKaKuiDoDeTaEntity.set抽出_事由1(entity.getIdoJiyuCode());
                shiKaKuiDoDeTaEntity.set抽出_識別コード1(entity.getShikibetsuCode().value());
                shiKaKuiDoDeTaEntity.set抽出_マスタ2(RString.EMPTY);
                shiKaKuiDoDeTaEntity.set抽出_マスタ3(RString.EMPTY);
                shiKaKuiDoDeTaEntity.set抽出_マスタ4(RString.EMPTY);
                shiKaKuiDoDeTaEntity.set抽出_マスタ5(RString.EMPTY);
                shiKaKuiDoDeTaEntity.set抽出_マスタ6(RString.EMPTY);
                shiKaKuiDoDeTaEntity.set抽出_マスタ7(RString.EMPTY);
                shiKaKuiDoDeTaEntity.set抽出_マスタ8(RString.EMPTY);
                shiKaKuiDoDeTaEntity.set抽出_マスタ9(RString.EMPTY);
                shiKaKuiDoDeTaEntity.set抽出_マスタ10(RString.EMPTY);
                shiKaKuiDoDeTaEntity.set抽出_事由2(RString.EMPTY);
                shiKaKuiDoDeTaEntity.set抽出_事由3(RString.EMPTY);
                shiKaKuiDoDeTaEntity.set抽出_事由4(RString.EMPTY);
                shiKaKuiDoDeTaEntity.set抽出_事由5(RString.EMPTY);
                shiKaKuiDoDeTaEntity.set抽出_事由6(RString.EMPTY);
                shiKaKuiDoDeTaEntity.set抽出_事由7(RString.EMPTY);
                shiKaKuiDoDeTaEntity.set抽出_事由8(RString.EMPTY);
                shiKaKuiDoDeTaEntity.set抽出_事由9(RString.EMPTY);
                shiKaKuiDoDeTaEntity.set抽出_事由10(RString.EMPTY);
                shiKaKuiDoDeTaEntity.set抽出_識別コード2(RString.EMPTY);
                shiKaKuiDoDeTaEntity.set抽出_識別コード3(RString.EMPTY);
                shiKaKuiDoDeTaEntity.set抽出_識別コード4(RString.EMPTY);
                shiKaKuiDoDeTaEntity.set抽出_識別コード5(RString.EMPTY);
                shiKaKuiDoDeTaEntity.set抽出_識別コード6(RString.EMPTY);
                shiKaKuiDoDeTaEntity.set抽出_識別コード7(RString.EMPTY);
                shiKaKuiDoDeTaEntity.set抽出_識別コード8(RString.EMPTY);
                shiKaKuiDoDeTaEntity.set抽出_識別コード9(RString.EMPTY);
                shiKaKuiDoDeTaEntity.set抽出_識別コード10(RString.EMPTY);
                listShiKaKuiDoDeTaEntity.add(shiKaKuiDoDeTaEntity);
                異動年月日 = 異動年月日.plusMonth(1);
            }
        }
        return listShiKaKuiDoDeTaEntity;
    }

    /**
     * 過去分実績基本抽出３(資格異動データ抽出)
     *
     * @param 開始年月 FlexibleYearMonth
     * @param 終了年月 FlexibleYearMonth
     * @param 資格異動データList List<ShiKaKuiDoDeTaEntity>
     * @return 計算対象者ファイル（資格異動）
     */
    @Transaction
    public List<ShiKaKuiDoDeTaEntity> getKakobunJissekiKihon3(
            FlexibleYearMonth 開始年月,
            FlexibleYearMonth 終了年月,
            List<ShiKaKuiDoDeTaEntity> 資格異動データList) {
        List<ShiKaKuiDoDeTaEntity> 資格異動データ = new ArrayList<>();
        ShikibetsuCode 識別コード = ShikibetsuCode.EMPTY;
        for (ShiKaKuiDoDeTaEntity entity : 資格異動データList) {
            if (!識別コード.equals(entity.get識別コード())) {
                資格異動データ.add(entity);
                識別コード = entity.get識別コード();
            }
        }
        List<ShiKaKuiDoDeTaEntity> 計算対象者ファイル_資格異動 = new ArrayList<>();
        FlexibleYearMonth 年月;
        for (ShiKaKuiDoDeTaEntity entity : 資格異動データ) {

            if (終了年月.isBefore(entity.get年月日().getYearMonth())) {
                continue;
            }
            if (entity.get年月日().getYearMonth().isBefore(開始年月)) {

                年月 = 開始年月;
            } else {
                年月 = entity.get年月日().getYearMonth();
            }
            for (int i = 0; i <= 終了年月.getBetweenMonths(年月); i++) {
                ShiKaKuiDoDeTaEntity shiKaKuiDoDeTaEntity = new ShiKaKuiDoDeTaEntity();
                shiKaKuiDoDeTaEntity.set識別コード(entity.get識別コード());
                shiKaKuiDoDeTaEntity.set賦課年度(new FlexibleYear(get賦課年度(entity.get年月日())));
                shiKaKuiDoDeTaEntity.set年月(年月.plusMonth(i));
                if (entity.get年月日().getDayValue() != 1) {

                    shiKaKuiDoDeTaEntity.set年月日(new FlexibleDate(entity.get年月日().getYearMonth().plusMonth(1).toString() + "01"));
                } else {
                    shiKaKuiDoDeTaEntity.set年月日(entity.get年月日());
                }
                if (i == 0) {
                    shiKaKuiDoDeTaEntity.set抽出_マスタ1(entity.get抽出_マスタ());
                    shiKaKuiDoDeTaEntity.set抽出_事由1(entity.get抽出_事由());
                    shiKaKuiDoDeTaEntity.set抽出_識別コード1(entity.get抽出_識別コード());
                }
                計算対象者ファイル_資格異動.add(entity);
            }
        }
        return 計算対象者ファイル_資格異動;
    }

    /**
     * 過去分実績基本抽出４(世帯情報取得)。
     *
     * @param listShiKaKuiDoDeTaEntity List<ShiKaKuiDoDeTaEntity>
     * @return Map<RString, List<ShiKaKuiDoDeTaEntity>>
     */
    @Transaction
    public Map<RString, List<HihokenshaNoFukaEntity>> getKakobunJissekiKihon4(List<HihokenshaNoFukaEntity> listShiKaKuiDoDeTaEntity) {
        List<HihokenshaNoFukaEntity> listUpdate = new ArrayList<>();
        List<HihokenshaNoFukaEntity> listInsert = new ArrayList<>();
        Map<RString, List<HihokenshaNoFukaEntity>> map = new HashMap<>();
        for (HihokenshaNoFukaEntity entity : listShiKaKuiDoDeTaEntity) {
            ISetai iSetai = ShikibetsuTaishoService.getSetaiFinder().findBy識別コード(GyomuCode.DB介護保険, entity.get識別コード(),
                    entity.get年月日());
            if (iSetai != null) {
                IKojins iKojins = iSetai.get世帯員リスト();
                Iterator<IKojin> iter = iKojins.iterator();
                while (iter.hasNext()) {
                    IKojin iKojin = iter.next();
                    if (entity.get識別コード().equals(iKojin.get識別コード())) {
                        entity.set世帯コード(iKojin.get世帯コード().value());
                        listUpdate.add(entity);
                    } else {
                        if (iKojin.is住民()) {
                            HihokenshaNoFukaEntity hihokenshaNoFukaEntity = new HihokenshaNoFukaEntity();
                            hihokenshaNoFukaEntity.set識別コード(iKojin.get識別コード());
                            hihokenshaNoFukaEntity.set被保険者番号(HihokenshaNo.EMPTY);
                            hihokenshaNoFukaEntity.set世帯コード(iKojin.get世帯コード().value());
                            hihokenshaNoFukaEntity.set賦課年度(entity.get賦課年度());
                            hihokenshaNoFukaEntity.set年月(entity.get年月());
                            hihokenshaNoFukaEntity.set年月日(entity.get年月日());
                            hihokenshaNoFukaEntity.set抽出_マスタ1(entity.get抽出_マスタ1());
                            hihokenshaNoFukaEntity.set抽出_事由1(entity.get抽出_事由1());
                            hihokenshaNoFukaEntity.set抽出_識別コード1(entity.get抽出_識別コード1());
                            hihokenshaNoFukaEntity.set抽出_マスタ2(RString.EMPTY);
                            hihokenshaNoFukaEntity.set抽出_マスタ3(RString.EMPTY);
                            hihokenshaNoFukaEntity.set抽出_マスタ4(RString.EMPTY);
                            hihokenshaNoFukaEntity.set抽出_マスタ5(RString.EMPTY);
                            hihokenshaNoFukaEntity.set抽出_マスタ6(RString.EMPTY);
                            hihokenshaNoFukaEntity.set抽出_マスタ7(RString.EMPTY);
                            hihokenshaNoFukaEntity.set抽出_マスタ8(RString.EMPTY);
                            hihokenshaNoFukaEntity.set抽出_マスタ9(RString.EMPTY);
                            hihokenshaNoFukaEntity.set抽出_マスタ10(RString.EMPTY);
                            hihokenshaNoFukaEntity.set抽出_事由2(RString.EMPTY);
                            hihokenshaNoFukaEntity.set抽出_事由3(RString.EMPTY);
                            hihokenshaNoFukaEntity.set抽出_事由4(RString.EMPTY);
                            hihokenshaNoFukaEntity.set抽出_事由5(RString.EMPTY);
                            hihokenshaNoFukaEntity.set抽出_事由6(RString.EMPTY);
                            hihokenshaNoFukaEntity.set抽出_事由7(RString.EMPTY);
                            hihokenshaNoFukaEntity.set抽出_事由8(RString.EMPTY);
                            hihokenshaNoFukaEntity.set抽出_事由9(RString.EMPTY);
                            hihokenshaNoFukaEntity.set抽出_事由10(RString.EMPTY);
                            hihokenshaNoFukaEntity.set抽出_識別コード2(RString.EMPTY);
                            hihokenshaNoFukaEntity.set抽出_識別コード3(RString.EMPTY);
                            hihokenshaNoFukaEntity.set抽出_識別コード4(RString.EMPTY);
                            hihokenshaNoFukaEntity.set抽出_識別コード5(RString.EMPTY);
                            hihokenshaNoFukaEntity.set抽出_識別コード6(RString.EMPTY);
                            hihokenshaNoFukaEntity.set抽出_識別コード7(RString.EMPTY);
                            hihokenshaNoFukaEntity.set抽出_識別コード8(RString.EMPTY);
                            hihokenshaNoFukaEntity.set抽出_識別コード9(RString.EMPTY);
                            hihokenshaNoFukaEntity.set抽出_識別コード10(RString.EMPTY);
                            listInsert.add(hihokenshaNoFukaEntity);
                        }
                    }
                }
            }
        }
        map.put(new RString("更新"), listUpdate);
        map.put(new RString("追加"), listInsert);
        return map;
    }

    /**
     * 過去分実績基本抽出６(レコードの丸めこみ)。
     *
     * @param 処理区分 処理区分
     * @param list List<HihokenshaNoFukaEntity>
     * @return List<HihokenshaNoFukaEntity>
     */
    public List<HihokenshaNoFukaEntity> getKakobunJissekiKihon6(RString 処理区分, List<HihokenshaNoFukaEntity> list) {
        if (処理区分_1.equals(処理区分)) {
            return 処理区分1(list.iterator());
        } else {
            return 処理区分2(list.iterator());
        }
    }

    /**
     * 過去分実績基本抽出７(被保険者番号付加)
     *
     * @param listEntity List<HihokenshaNoFukaEntity>
     * @return List<HihokenshaNoFukaEntity>
     */
    public List<HihokenshaNoFukaEntity> getKakobunJissekiKihon7(List<HihokenshaNoFukaEntity> listEntity) {
        Iterator<HihokenshaNoFukaEntity> iterator = listEntity.iterator();
        while (iterator.hasNext()) {
            HihokenshaNoFukaEntity entity = iterator.next();
            if (entity.get被保険者台帳_被保険者番号() == null
                    || entity.get被保険者台帳_被保険者番号().isEmpty()) {
                iterator.remove();
            } else {
                if (H.equals(entity.get被保険者番号().value().substring(0, 1))) {
                    iterator.remove();
                } else {
                    entity.set被保険者番号(entity.get被保険者台帳_被保険者番号());
                }
            }
        }
        return listEntity;
    }

    /**
     * 対象者一覧表発行処理
     *
     * @param 出力順ID boolean
     * @param 出力フラグ boolean
     */
    public void publishTaishoshaIchiran(
            RString 出力順ID,
            boolean 出力フラグ) {

    }

    /**
     * 処理日付管理マスタ更新
     *
     * @param 抽出期間開始日時 FlexibleDate
     * @param 抽出期間終了日時 FlexibleDate
     * @param 処理日時 FlexibleDate
     */
    @Transaction
    public void koshinShoriDateKanri(RDateTime 抽出期間開始日時, RDateTime 抽出期間終了日時, FlexibleDate 処理日時) {

        LasdecCode 地方公共団体コード = AssociationFinderFactory.createInstance().getAssociation().get地方公共団体コード();
        DbT7022ShoriDateKanriEntity entity = dbT7022Dac.selectByKey(SubGyomuCode.DBC介護給付,
                地方公共団体コード, ShoriName.高額介護対象者抽出_遡及分.get名称(),
                処理枝番, 年度, 年度内連番);
        if (entity != null) {
            if (抽出期間開始日時 != null) {
                entity.setTaishoKaishiYMD(new FlexibleDate(抽出期間開始日時.getDate().toDateString()));
            }
            if (抽出期間終了日時 != null) {
                entity.setTaishoShuryoYMD(new FlexibleDate(抽出期間終了日時.getDate().toDateString()));
            }
            if (処理日時 != null) {
                entity.setKijunYMD(処理日時);
            }
            entity.setState(EntityDataState.Modified);
            dbT7022Dac.save(entity);
        } else {
            DbT7022ShoriDateKanriEntity dateKanriEntity = new DbT7022ShoriDateKanriEntity();
            dateKanriEntity.setSubGyomuCode(SubGyomuCode.DBC介護給付);
            dateKanriEntity.setShichosonCode(地方公共団体コード);
            dateKanriEntity.setShoriName(ShoriName.高額介護対象者抽出_遡及分.get名称());
            dateKanriEntity.setShoriEdaban(登録処理枝番);
            dateKanriEntity.setNendo(登録年度);
            dateKanriEntity.setNendoNaiRenban(登録年度内連番);
            if (抽出期間開始日時 != null) {
                dateKanriEntity.setTaishoKaishiYMD(new FlexibleDate(抽出期間開始日時.getDate().toDateString()));
            }
            if (抽出期間終了日時 != null) {
                dateKanriEntity.setTaishoShuryoYMD(new FlexibleDate(抽出期間終了日時.getDate().toDateString()));
            }
            if (処理日時 != null) {
                dateKanriEntity.setKijunYMD(処理日時);
            }
            dateKanriEntity.setState(EntityDataState.Added);
            dbT7022Dac.save(dateKanriEntity);
        }
    }

    /**
     * 給付実績基本データ抽出します。
     *
     * @param paramter KogakukaigotaishoshachushutsusokyubunParameter
     * @param kyufujisekikihonList List<ShiKaKuiDoDeTaEntity>
     * @return List<ShiKaKuiDoDeTaEntity>
     */
    @Transaction
    public List<ShiKaKuiDoDeTaEntity> getKyufuJisseki(KogakukaigotaishoshachushutsusokyubunParameter paramter,
            List<ShiKaKuiDoDeTaEntity> kyufujisekikihonList) {
        RString 被保険者年月識別区分事業所 = RString.EMPTY;
        Iterator<ShiKaKuiDoDeTaEntity> iterator = kyufujisekikihonList.iterator();
        while (iterator.hasNext()) {
            ShiKaKuiDoDeTaEntity data = iterator.next();
            if (RString.isNullOrEmpty(data.get被保険者年月識別区分事業所())) {
                iterator.remove();
                continue;
            }
            if (被保険者年月識別区分事業所.equals(data.get被保険者年月識別区分事業所())) {
                iterator.remove();
            }
            被保険者年月識別区分事業所 = data.get被保険者年月識別区分事業所();
        }
        return kyufujisekikihonList;
    }

    private RString get賦課年度(FlexibleDate 年月日) {
        RString 判定年度;
        if (年月日.getYearMonth().isBeforeOrEquals(new FlexibleYearMonth("201507"))
                && new FlexibleYearMonth("201407").isBeforeOrEquals(年月日.getYearMonth())) {
            判定年度 = new RString("2014");
        } else if (new FlexibleYearMonth("201507").isBefore((年月日.getYearMonth()))) {
            if (年月日.getMonthValue() >= HACHI) {
                判定年度 = 年月日.getYear().toDateString();
            } else {
                判定年度 = 年月日.minusYear(1).getYear().toDateString();
            }
        } else {
            if (年月日.getMonthValue() <= ROKU) {
                判定年度 = 年月日.minusYear(1).getYear().toDateString();
            } else {
                判定年度 = 年月日.getYear().toDateString();
            }
        }
        return 判定年度;
    }

    private List<HihokenshaNoFukaEntity> 処理区分1(Iterator<HihokenshaNoFukaEntity> iterator計算対象者) {
        ShikibetsuCode 識別コード = ShikibetsuCode.EMPTY;
        FlexibleYearMonth 年月 = FlexibleYearMonth.EMPTY;
        RString 抽出_マスタ1 = RString.EMPTY;
        RString 抽出_事由1 = RString.EMPTY;
        RString 抽出_識別コード1 = RString.EMPTY;
        List<HihokenshaNoFukaEntity> 条件List = new ArrayList<>();
        while (iterator計算対象者.hasNext()) {
            HihokenshaNoFukaEntity entity = iterator計算対象者.next();
            if (識別コード.equals(entity.get識別コード())
                    && 年月.equals(entity.get年月())
                    && 抽出_マスタ1.equals(entity.get抽出_マスタ1())
                    && 抽出_事由1.equals(entity.get抽出_事由1())
                    && 抽出_識別コード1.equals(entity.get抽出_識別コード1())) {
                continue;
            }
            条件List.add(entity);
            識別コード = entity.get識別コード();
            年月 = entity.get年月();
            抽出_マスタ1 = entity.get抽出_マスタ1();
            抽出_事由1 = entity.get抽出_事由1();
            抽出_識別コード1 = entity.get抽出_識別コード1();
        }
        識別コード = ShikibetsuCode.EMPTY;
        年月 = FlexibleYearMonth.EMPTY;
        List<HihokenshaNoFukaEntity> groupList = new ArrayList<>();
        List<HihokenshaNoFukaEntity> dB出力entityList = new ArrayList<>();
        int i = 0;
        Iterator<HihokenshaNoFukaEntity> iterator = 条件List.iterator();
        while (iterator.hasNext()) {
            i++;
            HihokenshaNoFukaEntity entity = iterator.next();
            if (i == 1) {
                groupList.add(entity);
                識別コード = entity.get識別コード();
                年月 = entity.get年月();
                continue;
            }
            if (識別コード.equals(entity.get識別コード()) && 年月.equals(entity.get年月())) {
                groupList.add(entity);
            } else {

                HihokenshaNoFukaEntity hozoNentity = 処理区分1_一組のLoop(groupList);
                groupList.clear();
                groupList.add(entity);
                dB出力entityList.add(hozoNentity);
            }
            識別コード = entity.get識別コード();
            年月 = entity.get年月();
        }
        HihokenshaNoFukaEntity hozoNentity = 処理区分1_一組のLoop(groupList);
        if (!groupList.isEmpty()) {
            dB出力entityList.add(hozoNentity);
        }
        return dB出力entityList;
    }

    private HihokenshaNoFukaEntity 処理区分1_一組のLoop(List<HihokenshaNoFukaEntity> groupList) {
        HihokenshaNoFukaEntity hozoNentity = new HihokenshaNoFukaEntity();
        for (int a = 0; a < groupList.size(); a++) {
            HihokenshaNoFukaEntity groupEntity = groupList.get(a);
            switch (a) {
                case 0:
                    hozoNentity = groupList.get(0);
                    break;
                case ICHI:
                    hozoNentity.set抽出_マスタ2(groupEntity.get抽出_マスタ1());
                    hozoNentity.set抽出_事由2(groupEntity.get抽出_事由1());
                    hozoNentity.set抽出_識別コード2(groupEntity.get抽出_識別コード1());
                    break;
                case NI:
                    hozoNentity.set抽出_マスタ3(groupEntity.get抽出_マスタ1());
                    hozoNentity.set抽出_事由3(groupEntity.get抽出_事由1());
                    hozoNentity.set抽出_識別コード3(groupEntity.get抽出_識別コード1());
                    break;
                case SAN:
                    hozoNentity.set抽出_マスタ4(groupEntity.get抽出_マスタ1());
                    hozoNentity.set抽出_事由4(groupEntity.get抽出_事由1());
                    hozoNentity.set抽出_識別コード4(groupEntity.get抽出_識別コード1());
                    break;
                case YON:
                    hozoNentity.set抽出_マスタ5(groupEntity.get抽出_マスタ1());
                    hozoNentity.set抽出_事由5(groupEntity.get抽出_事由1());
                    hozoNentity.set抽出_識別コード5(groupEntity.get抽出_識別コード1());
                    break;
                case GO:
                    hozoNentity.set抽出_マスタ6(groupEntity.get抽出_マスタ1());
                    hozoNentity.set抽出_事由6(groupEntity.get抽出_事由1());
                    hozoNentity.set抽出_識別コード6(groupEntity.get抽出_識別コード1());
                    break;
                case ROKU:
                    hozoNentity.set抽出_マスタ7(groupEntity.get抽出_マスタ1());
                    hozoNentity.set抽出_事由7(groupEntity.get抽出_事由1());
                    hozoNentity.set抽出_識別コード7(groupEntity.get抽出_識別コード1());
                    break;
                case NANA:
                    hozoNentity.set抽出_マスタ8(groupEntity.get抽出_マスタ1());
                    hozoNentity.set抽出_事由8(groupEntity.get抽出_事由1());
                    hozoNentity.set抽出_識別コード8(groupEntity.get抽出_識別コード1());
                    break;
                case HACHI:
                    hozoNentity.set抽出_マスタ9(groupEntity.get抽出_マスタ1());
                    hozoNentity.set抽出_事由9(groupEntity.get抽出_事由1());
                    hozoNentity.set抽出_識別コード9(groupEntity.get抽出_識別コード1());
                    break;
                case KU:
                    hozoNentity.set抽出_マスタ10(groupEntity.get抽出_マスタ1());
                    hozoNentity.set抽出_事由10(groupEntity.get抽出_事由1());
                    hozoNentity.set抽出_識別コード10(groupEntity.get抽出_識別コード1());
                    break;
                default:
                    break;
            }
        }
        return hozoNentity;
    }

    private List<HihokenshaNoFukaEntity> 処理区分2(Iterator<HihokenshaNoFukaEntity> iterator) {
        List<HihokenshaNoFukaEntity> dB出力entityList = new ArrayList<>();
        List<HihokenshaNoFukaEntity> groupList = new ArrayList<>();
        int i = 0;
        HihokenshaNo 被保険者番号 = HihokenshaNo.EMPTY;
        FlexibleYearMonth 年月 = FlexibleYearMonth.EMPTY;
        while (iterator.hasNext()) {
            i++;
            HihokenshaNoFukaEntity entity = iterator.next();
            if (i == 1) {
                groupList.add(entity);
                被保険者番号 = entity.get被保険者番号();
                年月 = entity.get年月();
                continue;
            }
            if (被保険者番号.equals(entity.get被保険者番号()) && 年月.equals(entity.get年月())) {
                groupList.add(entity);
            } else {
                List<HihokenshaNoFukaEntity> 統合List = new ArrayList<>();
                HihokenshaNoFukaEntity hozoNentity = new HihokenshaNoFukaEntity();
                処理区分2_一組のLoop(hozoNentity, groupList, 統合List);
                HihokenshaNoFukaEntity returnEntity = new HihokenshaNoFukaEntity();
                処理区分2_統合Listの分割(統合List, returnEntity);
                groupList.clear();
                groupList.add(entity);
                dB出力entityList.add(returnEntity);
            }
            被保険者番号 = entity.get被保険者番号();
            年月 = entity.get年月();
        }
        List<HihokenshaNoFukaEntity> 統合List = new ArrayList<>();
        HihokenshaNoFukaEntity hozoNentity = new HihokenshaNoFukaEntity();
        処理区分2_一組のLoop(hozoNentity, groupList, 統合List);
        HihokenshaNoFukaEntity returnEntity = new HihokenshaNoFukaEntity();
        処理区分2_統合Listの分割(統合List, returnEntity);
        if (!groupList.isEmpty()) {
            dB出力entityList.add(returnEntity);
        }
        return dB出力entityList;
    }

    private void 処理区分2_一組のLoop(HihokenshaNoFukaEntity hozoNentity, List<HihokenshaNoFukaEntity> groupList,
            List<HihokenshaNoFukaEntity> 統合List) {
        for (int a = 0; a < groupList.size(); a++) {
            hozoNentity = groupList.get(a);
            for (int v = 0; v < JYUU; v++) {
                HihokenshaNoFukaEntity 統合entity = new HihokenshaNoFukaEntity();
                HihokenshaNoFukaEntity headEntity = groupList.get(0);
                統合entity.set識別コード(headEntity.get識別コード());
                統合entity.set被保険者番号(headEntity.get被保険者番号());
                統合entity.set世帯コード(headEntity.get世帯コード());
                統合entity.set賦課年度(headEntity.get賦課年度());
                統合entity.set年月(headEntity.get年月());
                統合entity.set年月日(headEntity.get年月日());
                switch (v) {
                    case 0:
                        統合entity.set抽出_事由(hozoNentity.get抽出_事由1());
                        統合entity.set抽出_マスタ(hozoNentity.get抽出_マスタ1());
                        統合entity.set抽出_識別コード(hozoNentity.get抽出_識別コード1());
                        break;
                    case ICHI:
                        統合entity.set抽出_事由(hozoNentity.get抽出_事由2());
                        統合entity.set抽出_マスタ(hozoNentity.get抽出_マスタ2());
                        統合entity.set抽出_識別コード(hozoNentity.get抽出_識別コード2());
                        break;
                    case NI:
                        統合entity.set抽出_事由(hozoNentity.get抽出_事由3());
                        統合entity.set抽出_マスタ(hozoNentity.get抽出_マスタ3());
                        統合entity.set抽出_識別コード(hozoNentity.get抽出_識別コード3());
                        break;
                    case SAN:
                        統合entity.set抽出_事由(hozoNentity.get抽出_事由4());
                        統合entity.set抽出_マスタ(hozoNentity.get抽出_マスタ4());
                        統合entity.set抽出_識別コード(hozoNentity.get抽出_識別コード4());
                        break;
                    case YON:
                        統合entity.set抽出_事由(hozoNentity.get抽出_事由5());
                        統合entity.set抽出_マスタ(hozoNentity.get抽出_マスタ5());
                        統合entity.set抽出_識別コード(hozoNentity.get抽出_識別コード5());
                        break;
                    case GO:
                        統合entity.set抽出_事由(hozoNentity.get抽出_事由6());
                        統合entity.set抽出_マスタ(hozoNentity.get抽出_マスタ6());
                        統合entity.set抽出_識別コード(hozoNentity.get抽出_識別コード6());
                        break;
                    case ROKU:
                        統合entity.set抽出_事由(hozoNentity.get抽出_事由7());
                        統合entity.set抽出_マスタ(hozoNentity.get抽出_マスタ7());
                        統合entity.set抽出_識別コード(hozoNentity.get抽出_識別コード7());
                        break;
                    case NANA:
                        統合entity.set抽出_事由(hozoNentity.get抽出_事由8());
                        統合entity.set抽出_マスタ(hozoNentity.get抽出_マスタ8());
                        統合entity.set抽出_識別コード(hozoNentity.get抽出_識別コード8());
                        break;
                    case HACHI:
                        統合entity.set抽出_事由(hozoNentity.get抽出_事由9());
                        統合entity.set抽出_マスタ(hozoNentity.get抽出_マスタ9());
                        統合entity.set抽出_識別コード(hozoNentity.get抽出_識別コード9());
                        break;
                    case KU:
                        統合entity.set抽出_事由(hozoNentity.get抽出_事由10());
                        統合entity.set抽出_マスタ(hozoNentity.get抽出_マスタ10());
                        統合entity.set抽出_識別コード(hozoNentity.get抽出_識別コード10());
                        break;
                    default:
                        break;
                }
                if (!RString.isNullOrEmpty(統合entity.get抽出_マスタ())
                        || !RString.isNullOrEmpty(統合entity.get抽出_事由())
                        || !RString.isNullOrEmpty(統合entity.get抽出_識別コード())) {
                    統合List.add(統合entity);
                }
            }
        }
    }

    private void 処理区分2_統合Listの分割(List<HihokenshaNoFukaEntity> 統合List, HihokenshaNoFukaEntity returnEntity) {
        for (int y = 0; y < 統合List.size(); y++) {
            HihokenshaNoFukaEntity 統合Entity = 統合List.get(y);
            switch (y) {
                case 0:
                    returnEntity.set識別コード(統合Entity.get識別コード());
                    returnEntity.set被保険者番号(統合Entity.get被保険者番号());
                    returnEntity.set世帯コード(統合Entity.get世帯コード());
                    returnEntity.set賦課年度(統合Entity.get賦課年度());
                    returnEntity.set年月(統合Entity.get年月());
                    returnEntity.set年月日(統合Entity.get年月日());
                    returnEntity.set抽出_事由1(統合Entity.get抽出_事由());
                    returnEntity.set抽出_マスタ1(統合Entity.get抽出_マスタ());
                    returnEntity.set抽出_識別コード1(統合Entity.get抽出_識別コード());
                    break;
                case ICHI:
                    returnEntity.set抽出_事由2(統合Entity.get抽出_事由());
                    returnEntity.set抽出_マスタ2(統合Entity.get抽出_マスタ());
                    returnEntity.set抽出_識別コード2(統合Entity.get抽出_識別コード());
                    break;
                case NI:
                    returnEntity.set抽出_事由3(統合Entity.get抽出_事由());
                    returnEntity.set抽出_マスタ3(統合Entity.get抽出_マスタ());
                    returnEntity.set抽出_識別コード3(統合Entity.get抽出_識別コード());
                    break;
                case SAN:
                    returnEntity.set抽出_事由4(統合Entity.get抽出_事由());
                    returnEntity.set抽出_マスタ4(統合Entity.get抽出_マスタ());
                    returnEntity.set抽出_識別コード4(統合Entity.get抽出_識別コード());
                    break;
                case YON:
                    returnEntity.set抽出_事由5(統合Entity.get抽出_事由());
                    returnEntity.set抽出_マスタ5(統合Entity.get抽出_マスタ());
                    returnEntity.set抽出_識別コード5(統合Entity.get抽出_識別コード());
                    break;
                case GO:
                    returnEntity.set抽出_事由6(統合Entity.get抽出_事由());
                    returnEntity.set抽出_マスタ6(統合Entity.get抽出_マスタ());
                    returnEntity.set抽出_識別コード6(統合Entity.get抽出_識別コード());
                    break;
                case ROKU:
                    returnEntity.set抽出_事由7(統合Entity.get抽出_事由());
                    returnEntity.set抽出_マスタ7(統合Entity.get抽出_マスタ());
                    returnEntity.set抽出_識別コード7(統合Entity.get抽出_識別コード());
                    break;
                case NANA:
                    returnEntity.set抽出_事由8(統合Entity.get抽出_事由());
                    returnEntity.set抽出_マスタ8(統合Entity.get抽出_マスタ());
                    returnEntity.set抽出_識別コード8(統合Entity.get抽出_識別コード());
                    break;
                case HACHI:
                    returnEntity.set抽出_事由9(統合Entity.get抽出_事由());
                    returnEntity.set抽出_マスタ9(統合Entity.get抽出_マスタ());
                    returnEntity.set抽出_識別コード9(統合Entity.get抽出_識別コード());
                    break;
                case KU:
                    returnEntity.set抽出_事由10(統合Entity.get抽出_事由());
                    returnEntity.set抽出_マスタ10(統合Entity.get抽出_マスタ());
                    returnEntity.set抽出_識別コード10(統合Entity.get抽出_識別コード());
                    break;
                default:
                    break;
            }
            if (y > KU) {
                break;
            }
        }
    }
}
