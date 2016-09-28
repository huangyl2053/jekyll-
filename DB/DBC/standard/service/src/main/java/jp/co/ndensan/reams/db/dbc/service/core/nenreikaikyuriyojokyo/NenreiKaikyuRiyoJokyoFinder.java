/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.nenreikaikyuriyojokyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.nenreikaikyuriyojokyo.SyorikekkatempTblEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.nenreikaikyuriyojokyo.TmpKyufujissekiRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.nenreikaikyuriyojokyo.UpdateParameterEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.nenreikaikyuriyojokyo.INenreikaikyuRiyojokyoMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.AgeCalculator;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.DateOfBirthFactory;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai.住民;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * ビジネス設計_DBC150020_年齢階級別利用状況作成クラスです。
 *
 * @reamsid_L DBC-3470-050 xuyongchao
 */
public class NenreiKaikyuRiyoJokyoFinder {

    private RString 被保険者番号 = RString.EMPTY;
    private FlexibleYearMonth サービス提供年月 = FlexibleYearMonth.EMPTY;
    private RString 要介護状態区分コード = RString.EMPTY;
    private RString サービス分類コード = RString.EMPTY;
    private static final RString 処理名 = new RString("「生年月日算出」");
    private static final RString エラー内容 = new RString("生年月日算出エラー");
    private static final RString 年齢階級1 = new RString("40歳～49歳");
    private static final RString 年齢階級2 = new RString("50歳～59歳");
    private static final RString 年齢階級3 = new RString("60歳～64歳");
    private static final RString 年齢階級4 = new RString("２号計");
    private static final RString 年齢階級5 = new RString("65歳～69歳");
    private static final RString 年齢階級6 = new RString("70歳～74歳");
    private static final RString 年齢階級7 = new RString("75歳～79歳");
    private static final RString 年齢階級8 = new RString("80歳～84歳");
    private static final RString 年齢階級9 = new RString("85歳～89歳");
    private static final RString 年齢階級10 = new RString("90歳～94歳");
    private static final RString 年齢階級11 = new RString("95歳～99歳");
    private static final RString 年齢階級12 = new RString("100歳以上");
    private static final RString 年齢階級13 = new RString("１号計");
    private static final RString 年齢階級14 = new RString("総合計");
    private static final int 桁_0 = 0;
    private static final int 年齢40 = 40;
    private static final int 年齢65 = 65;
    private static final RString RSTRING_ZERO = new RString("0");
    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    NenreiKaikyuRiyoJokyoFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param MapperProvider mapperProvider
     */
    NenreiKaikyuRiyoJokyoFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NenreiKaikyuRiyoJokyoFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link NenreiKaikyuRiyoJokyoFinder}のインスタンス
     */
    public static NenreiKaikyuRiyoJokyoFinder createInstance() {
        return InstanceProvider.create(NenreiKaikyuRiyoJokyoFinder.class);
    }

    /**
     * 出力用一時TBLを更新する。
     *
     */
    @Transaction
    public void updateForOut() {
        INenreikaikyuRiyojokyoMapper mapper = mapperProvider.create(INenreikaikyuRiyojokyoMapper.class);
        List<TmpKyufujissekiRelateEntity> entityList = mapper.getKyufujissekiTemp();
        List<List<UpdateParameterEntity>> updateParEntityList = new ArrayList<>();
        if (!entityList.isEmpty()) {
            updateParEntityList = createntitylist();
            サービス分類コード = entityList.get(0).getServiceSyuruiCode().value();
        }
        for (int i = 0; i < entityList.size(); i++) {
            if (!サービス分類コード.equals(entityList.get(i).getServiceSyuruiCode().value())) {
                updateDB出力出力用一時TBL(updateParEntityList, mapper);
                updateParEntityList = createntitylist();
                サービス分類コード = entityList.get(i).getServiceSyuruiCode().value();
            }
            edit対象レコード(updateParEntityList, entityList.get(i), mapper);
        }
    }

    private List<List<UpdateParameterEntity>> edit対象レコード(List<List<UpdateParameterEntity>> updateParEntityList,
            TmpKyufujissekiRelateEntity レコード, INenreikaikyuRiyojokyoMapper mapper) {

        int count = get対象レコード数(レコード);
        get対象レコード年齢の処理(updateParEntityList, レコード, count, mapper);
        return updateParEntityList;
    }

    private int get対象レコード数(TmpKyufujissekiRelateEntity レコード) {
        int count = 0;
        if (!被保険者番号.equals(レコード.getHiHokenshaNo().value())
                && !サービス提供年月.toString().equals(レコード.getServiceTeikyoYM().toString())
                && !要介護状態区分コード.equals(レコード.getYoKaigoJotaiKubunCode())) {
            被保険者番号 = レコード.getHiHokenshaNo().value();
            サービス提供年月 = レコード.getServiceTeikyoYM();
            要介護状態区分コード = レコード.getYoKaigoJotaiKubunCode();
            count++;
        }
        return count;
    }

    private void get対象レコード年齢の処理(List<List<UpdateParameterEntity>> updateParEntityList, TmpKyufujissekiRelateEntity レコード,
            int count, INenreikaikyuRiyojokyoMapper mapper) {
        AgeCalculator agecounter = new AgeCalculator(DateOfBirthFactory.createInstance(レコード.getUmareYMD()), 住民, FlexibleDate.MAX);
        int age = Integer.valueOf(agecounter.get年齢().toString());
        if (age < 年齢40) {
            SyorikekkatempTblEntity entity = new SyorikekkatempTblEntity();
            entity.setShoriMei(処理名);
            entity.setHiHokenshaNo(レコード.getHiHokenshaNo());
            entity.setServiceTeikyoYM(レコード.getServiceTeikyoYM());
            entity.setHiHokenshaKana(レコード.getMeisho().value());
            entity.setErrorMsg(エラー内容);
            entity.setBikou(new RString(レコード.getUmareYMD().toString()));
            mapper.insert処理結果リスト一時TBL(entity);
        } else if (age < 年齢65) {
            updateCreatEntitylist(updateParEntityList,
                    count,
                    年齢階級4, レコード.getYoKaigoJotaiKubunCode());

        } else if (age >= 年齢65) {
            updateCreatEntitylist(updateParEntityList,
                    count,
                    年齢階級13, レコード.getYoKaigoJotaiKubunCode());
        }
    }

    private List<List<UpdateParameterEntity>> updateCreatEntitylist(List<List<UpdateParameterEntity>> updateParEntityList,
            int count,
            RString 年齢階級,
            RString 要介護状態区分コード
    ) {
        for (List<UpdateParameterEntity> list : updateParEntityList) {
            for (UpdateParameterEntity updateParEntity : list) {
                if (年齢階級.equals(updateParEntity.get区分())
                        && 要介護状態区分コード.equals(updateParEntity.get要介護状態区分コード())) {
                    updateParEntity.setKubun(count);
                }
            }
        }
        return updateParEntityList;
    }

    private List<List<UpdateParameterEntity>> createntitylist() {
        List<RString> nenreiKaikyuList = new ArrayList<>();
        nenreiKaikyuList.add(年齢階級1);
        nenreiKaikyuList.add(年齢階級2);
        nenreiKaikyuList.add(年齢階級3);
        nenreiKaikyuList.add(年齢階級4);
        nenreiKaikyuList.add(年齢階級5);
        nenreiKaikyuList.add(年齢階級6);
        nenreiKaikyuList.add(年齢階級7);
        nenreiKaikyuList.add(年齢階級8);
        nenreiKaikyuList.add(年齢階級9);
        nenreiKaikyuList.add(年齢階級10);
        nenreiKaikyuList.add(年齢階級11);
        nenreiKaikyuList.add(年齢階級12);
        nenreiKaikyuList.add(年齢階級13);
        nenreiKaikyuList.add(年齢階級14);
        List<List<UpdateParameterEntity>> entitylist = new ArrayList<>();
        for (int i = 0; i < nenreiKaikyuList.size(); i++) {
            List<UpdateParameterEntity> 年齢階級List = new ArrayList<>();
            RString 年齢階級 = nenreiKaikyuList.get(i);
            年齢階級List.add(setEntity(年齢階級, new RString("01")));
            年齢階級List.add(setEntity(年齢階級, new RString("12")));
            年齢階級List.add(setEntity(年齢階級, new RString("13")));
            年齢階級List.add(setEntity(年齢階級, new RString("11")));
            年齢階級List.add(setEntity(年齢階級, new RString("21")));
            年齢階級List.add(setEntity(年齢階級, new RString("22")));
            年齢階級List.add(setEntity(年齢階級, new RString("23")));
            年齢階級List.add(setEntity(年齢階級, new RString("24")));
            年齢階級List.add(setEntity(年齢階級, new RString("25")));
            entitylist.add(年齢階級List);
        }
        return entitylist;
    }

    private UpdateParameterEntity setEntity(RString 年齢階級, RString 要介護状態区分コード) {
        UpdateParameterEntity list = new UpdateParameterEntity();
        list.setKubun(桁_0);
        list.setページNo(RSTRING_ZERO);
        list.set区分(年齢階級);
        list.set要介護状態区分コード(要介護状態区分コード);
        return list;
    }

    private void updateDB出力出力用一時TBL(List<List<UpdateParameterEntity>> updateParEntityList, INenreikaikyuRiyojokyoMapper mapper) {
        for (List<UpdateParameterEntity> list : updateParEntityList) {
            for (UpdateParameterEntity updateEntity : list) {
                if (updateEntity.getKubun() > 0) {
                    mapper.update出力用一時TBL(updateEntity);
                }
            }
        }
    }
}
