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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * ビジネス設計_DBC150020_年齢階級別利用状況作成クラスです。
 *
 * @reamsid_L DBC-3470-050 xuyongchao
 */
public class NenreiKaikyuRiyoJokyoFinder {

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
    private static final RString 値01 = new RString("01");
    private static final RString 値11 = new RString("11");
    private static final RString 値12 = new RString("12");
    private static final RString 値13 = new RString("13");
    private static final RString 値21 = new RString("21");
    private static final RString 値22 = new RString("22");
    private static final RString 値23 = new RString("23");
    private static final RString 値24 = new RString("24");
    private static final RString 値25 = new RString("25");
    private static final int 年齢40 = 40;
    private static final int 年齢50 = 50;
    private static final int 年齢60 = 60;
    private static final int 年齢65 = 65;
    private static final int 年齢70 = 70;
    private static final int 年齢75 = 75;
    private static final int 年齢80 = 80;
    private static final int 年齢85 = 85;
    private static final int 年齢90 = 90;
    private static final int 年齢95 = 95;
    private static final int 年齢100 = 100;
    private static final RString RSTRING_01 = new RString("01");
    private static final RString RSTRING_02 = new RString("02");
    private static final RString RSTRING_03 = new RString("03");
    private static final RString RSTRING_04 = new RString("04");
    private static final RString RSTRING_05 = new RString("05");
    private static final RString RSTRING_06 = new RString("06");
    private static final RString RSTRING_07 = new RString("07");
    private static final RString RSTRING_11 = new RString("11");
    private static final RString RSTRING_12 = new RString("12");
    private static final RString RSTRING_13 = new RString("13");
    private static final RString RSTRING_14 = new RString("14");
    private static final RString RSTRING_15 = new RString("15");
    private static final RString RSTRING_16 = new RString("16");
    private static final RString RSTRING_17 = new RString("17");
    private static final RString RSTRING_18 = new RString("18");
    private static final RString RSTRING_19 = new RString("19");
    private static final RString RSTRING_20 = new RString("20");
    private static final RString RSTRING_21 = new RString("21");
    private static final RString RSTRING_23 = new RString("23");
    private static final RString RSTRING_24 = new RString("24");
    private static final RString RSTRING_25 = new RString("25");
    private static final RString RSTRING_26 = new RString("26");
    private static final RString RSTRING_27 = new RString("27");
    private static final RString RSTRING_28 = new RString("28");
    private static final RString RSTRING_29 = new RString("29");
    private static final RString RSTRING_30 = new RString("30");
    private static final RString RSTRING_31 = new RString("31");
    private static final RString RSTRING_32 = new RString("32");
    private static final RString RSTRING_33 = new RString("33");
    private static final RString RSTRING_34 = new RString("34");
    private static final RString RSTRING_35 = new RString("35");
    private static final RString RSTRING_36 = new RString("36");
    private static final RString RSTRING_40 = new RString("40");
    private static final RString RSTRING_41 = new RString("41");
    private static final RString RSTRING_42 = new RString("42");
    private static final RString RSTRING_43 = new RString("43");
    private static final RString RSTRING_51 = new RString("51");
    private static final RString RSTRING_52 = new RString("52");
    private static final int 定数2 = 2;
    private static final int 定数3 = 3;
    private static final RString サービス項目コード_1 = new RString("1");
    private static final RString サービス項目コード_2 = new RString("1");
    private final MapperProvider mapperProvider;
    private RString 集計番号 = RString.EMPTY;

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
     * 出力用一時TBLを更新です。
     *
     */
    @Transaction
    public void updateForOut() {
        INenreikaikyuRiyojokyoMapper mapper = mapperProvider.create(INenreikaikyuRiyojokyoMapper.class);
        List<TmpKyufujissekiRelateEntity> entityList = mapper.getKyufujissekiTemp();
        List<List<UpdateParameterEntity>> updateParEntityList = new ArrayList<>();
        if (!entityList.isEmpty()) {
            updateParEntityList = createntitylist();
            集計番号 = entityList.get(0).getShuukeibangou();
        }
        for (int i = 0; i < entityList.size(); i++) {
            if (!集計番号.equals(entityList.get(i).getShuukeibangou())) {
                updateDB出力出力用一時TBL(updateParEntityList, mapper);
                updateParEntityList = createntitylist();
                集計番号 = entityList.get(i).getShuukeibangou();
            }
            edit対象レコード(updateParEntityList, entityList.get(i), mapper);
        }
    }

    private List<List<UpdateParameterEntity>> edit対象レコード(List<List<UpdateParameterEntity>> updateParEntityList,
            TmpKyufujissekiRelateEntity レコード, INenreikaikyuRiyojokyoMapper mapper) {
        get年齢階級区分(updateParEntityList, レコード, mapper);
        return updateParEntityList;
    }

    private void get年齢階級区分(List<List<UpdateParameterEntity>> updateParEntityList, TmpKyufujissekiRelateEntity レコード,
            INenreikaikyuRiyojokyoMapper mapper) {
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
        }
        if (age >= 年齢40 && age < 年齢50) {
            updateCreatEntitylist(updateParEntityList,
                    年齢階級1, レコード.getYoKaigoJotaiKubunCode(), レコード.getShuukeibangou(), レコード.getServiceKomokuCode());
            updateCreatEntitylist(updateParEntityList,
                    年齢階級4, レコード.getYoKaigoJotaiKubunCode(), レコード.getShuukeibangou(), レコード.getServiceKomokuCode());
            updateCreatEntitylist(updateParEntityList,
                    年齢階級14, レコード.getYoKaigoJotaiKubunCode(), レコード.getShuukeibangou(), レコード.getServiceKomokuCode());
        }
        if (age >= 年齢50 && age < 年齢60) {
            updateCreatEntitylist(updateParEntityList,
                    年齢階級2, レコード.getYoKaigoJotaiKubunCode(), レコード.getShuukeibangou(), レコード.getServiceKomokuCode());
            updateCreatEntitylist(updateParEntityList,
                    年齢階級4, レコード.getYoKaigoJotaiKubunCode(), レコード.getShuukeibangou(), レコード.getServiceKomokuCode());
            updateCreatEntitylist(updateParEntityList,
                    年齢階級14, レコード.getYoKaigoJotaiKubunCode(), レコード.getShuukeibangou(), レコード.getServiceKomokuCode());
        }
        if (age >= 年齢60 && age < 年齢65) {
            updateCreatEntitylist(updateParEntityList,
                    年齢階級3, レコード.getYoKaigoJotaiKubunCode(), レコード.getShuukeibangou(), レコード.getServiceKomokuCode());
            updateCreatEntitylist(updateParEntityList,
                    年齢階級4, レコード.getYoKaigoJotaiKubunCode(), レコード.getShuukeibangou(), レコード.getServiceKomokuCode());
            updateCreatEntitylist(updateParEntityList,
                    年齢階級14, レコード.getYoKaigoJotaiKubunCode(), レコード.getShuukeibangou(), レコード.getServiceKomokuCode());
        }
        if (age >= 年齢65 && age < 年齢70) {
            updateCreatEntitylist(updateParEntityList,
                    年齢階級5, レコード.getYoKaigoJotaiKubunCode(), レコード.getShuukeibangou(), レコード.getServiceKomokuCode());
            updateCreatEntitylist(updateParEntityList,
                    年齢階級13, レコード.getYoKaigoJotaiKubunCode(), レコード.getShuukeibangou(), レコード.getServiceKomokuCode());
            updateCreatEntitylist(updateParEntityList,
                    年齢階級14, レコード.getYoKaigoJotaiKubunCode(), レコード.getShuukeibangou(), レコード.getServiceKomokuCode());
        }
        if (age >= 年齢70 && age < 年齢75) {
            updateCreatEntitylist(updateParEntityList,
                    年齢階級6, レコード.getYoKaigoJotaiKubunCode(), レコード.getShuukeibangou(), レコード.getServiceKomokuCode());
            updateCreatEntitylist(updateParEntityList,
                    年齢階級13, レコード.getYoKaigoJotaiKubunCode(), レコード.getShuukeibangou(), レコード.getServiceKomokuCode());
            updateCreatEntitylist(updateParEntityList,
                    年齢階級14, レコード.getYoKaigoJotaiKubunCode(), レコード.getShuukeibangou(), レコード.getServiceKomokuCode());
        }
        if (age >= 年齢75 && age < 年齢80) {
            updateCreatEntitylist(updateParEntityList,
                    年齢階級7, レコード.getYoKaigoJotaiKubunCode(), レコード.getShuukeibangou(), レコード.getServiceKomokuCode());
            updateCreatEntitylist(updateParEntityList,
                    年齢階級13, レコード.getYoKaigoJotaiKubunCode(), レコード.getShuukeibangou(), レコード.getServiceKomokuCode());
            updateCreatEntitylist(updateParEntityList,
                    年齢階級14, レコード.getYoKaigoJotaiKubunCode(), レコード.getShuukeibangou(), レコード.getServiceKomokuCode());
        }
        get年齢階級区分1(updateParEntityList, レコード, age);
    }

    private void get年齢階級区分1(List<List<UpdateParameterEntity>> updateParEntityList, TmpKyufujissekiRelateEntity レコード,
            int age) {
        if (age >= 年齢80 && age < 年齢85) {
            updateCreatEntitylist(updateParEntityList,
                    年齢階級8, レコード.getYoKaigoJotaiKubunCode(), レコード.getShuukeibangou(), レコード.getServiceKomokuCode());
            updateCreatEntitylist(updateParEntityList,
                    年齢階級13, レコード.getYoKaigoJotaiKubunCode(), レコード.getShuukeibangou(), レコード.getServiceKomokuCode());
            updateCreatEntitylist(updateParEntityList,
                    年齢階級14, レコード.getYoKaigoJotaiKubunCode(), レコード.getShuukeibangou(), レコード.getServiceKomokuCode());
        }
        if (age >= 年齢85 && age < 年齢90) {
            updateCreatEntitylist(updateParEntityList,
                    年齢階級9, レコード.getYoKaigoJotaiKubunCode(), レコード.getShuukeibangou(), レコード.getServiceKomokuCode());
            updateCreatEntitylist(updateParEntityList,
                    年齢階級13, レコード.getYoKaigoJotaiKubunCode(), レコード.getShuukeibangou(), レコード.getServiceKomokuCode());
            updateCreatEntitylist(updateParEntityList,
                    年齢階級14, レコード.getYoKaigoJotaiKubunCode(), レコード.getShuukeibangou(), レコード.getServiceKomokuCode());
        }
        if (age >= 年齢90 && age < 年齢95) {
            updateCreatEntitylist(updateParEntityList,
                    年齢階級10, レコード.getYoKaigoJotaiKubunCode(), レコード.getShuukeibangou(), レコード.getServiceKomokuCode());
            updateCreatEntitylist(updateParEntityList,
                    年齢階級13, レコード.getYoKaigoJotaiKubunCode(), レコード.getShuukeibangou(), レコード.getServiceKomokuCode());
            updateCreatEntitylist(updateParEntityList,
                    年齢階級14, レコード.getYoKaigoJotaiKubunCode(), レコード.getShuukeibangou(), レコード.getServiceKomokuCode());
        }
        if (age >= 年齢95 && age < 年齢100) {
            updateCreatEntitylist(updateParEntityList,
                    年齢階級11, レコード.getYoKaigoJotaiKubunCode(), レコード.getShuukeibangou(), レコード.getServiceKomokuCode());
            updateCreatEntitylist(updateParEntityList,
                    年齢階級13, レコード.getYoKaigoJotaiKubunCode(), レコード.getShuukeibangou(), レコード.getServiceKomokuCode());
            updateCreatEntitylist(updateParEntityList,
                    年齢階級14, レコード.getYoKaigoJotaiKubunCode(), レコード.getShuukeibangou(), レコード.getServiceKomokuCode());
        }
        if (age >= 年齢100) {
            updateCreatEntitylist(updateParEntityList,
                    年齢階級12, レコード.getYoKaigoJotaiKubunCode(), レコード.getShuukeibangou(), レコード.getServiceKomokuCode());
            updateCreatEntitylist(updateParEntityList,
                    年齢階級13, レコード.getYoKaigoJotaiKubunCode(), レコード.getShuukeibangou(), レコード.getServiceKomokuCode());
            updateCreatEntitylist(updateParEntityList,
                    年齢階級14, レコード.getYoKaigoJotaiKubunCode(), レコード.getShuukeibangou(), レコード.getServiceKomokuCode());
        }
    }

    private List<List<UpdateParameterEntity>> updateCreatEntitylist(List<List<UpdateParameterEntity>> updateParEntityList,
            RString 年齢階級,
            RString 要介護状態区分コード,
            RString 集計番号,
            RString サービス項目コード
    ) {
        for (List<UpdateParameterEntity> list : updateParEntityList) {
            for (UpdateParameterEntity updateParEntity : list) {
                if (年齢階級.equals(updateParEntity.get区分())
                        && 要介護状態区分コード.equals(updateParEntity.get要介護状態区分コード())) {
                    updateParEntity.set集計番号(集計番号);
                    updateParEntity.setサービス項目コード(サービス項目コード);
                    updateParEntity.setKubun(updateParEntity.getKubun() + 1);
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
        list.setKubun(0);
        list.set区分(年齢階級);
        list.set要介護状態区分コード(要介護状態区分コード);
        list.set集計番号(RString.EMPTY);
        list.setサービス項目コード(RString.EMPTY);
        return list;
    }

    private void updateDB出力出力用一時TBL(List<List<UpdateParameterEntity>> updateParEntityList, INenreikaikyuRiyojokyoMapper mapper) {
        for (List<UpdateParameterEntity> list : updateParEntityList) {
            for (UpdateParameterEntity updateEntity : list) {
                if (updateEntity.getKubun() > 0) {
                    updateDB出力出力用一時TBL1(updateEntity, mapper);
                    if (値21.equals(updateEntity.get要介護状態区分コード())) {
                        updateEntity.setHiGaitouflag(false);
                        updateEntity.setYoSien1flag(false);
                        updateEntity.setYoSien2flag(false);
                        updateEntity.setKeikatekiYoSienflag(false);
                        updateEntity.setYouKaigo1flag(true);
                        updateEntity.setYouKaigo2flag(false);
                        updateEntity.setYouKaigo3flag(false);
                        updateEntity.setYouKaigo4flag(false);
                        updateEntity.setYouKaigo5flag(false);
                        mapper.update出力用一時TBL(updateEntity);
                        setUpdate総合計(updateEntity, mapper);
                        setUpdate(updateEntity, mapper);
                    }
                    if (値22.equals(updateEntity.get要介護状態区分コード())) {
                        updateEntity.setHiGaitouflag(false);
                        updateEntity.setYoSien1flag(false);
                        updateEntity.setYoSien2flag(false);
                        updateEntity.setKeikatekiYoSienflag(false);
                        updateEntity.setYouKaigo1flag(false);
                        updateEntity.setYouKaigo2flag(true);
                        updateEntity.setYouKaigo3flag(false);
                        updateEntity.setYouKaigo4flag(false);
                        updateEntity.setYouKaigo5flag(false);
                        mapper.update出力用一時TBL(updateEntity);
                        setUpdate総合計(updateEntity, mapper);
                        setUpdate(updateEntity, mapper);
                    }
                    if (値23.equals(updateEntity.get要介護状態区分コード())) {
                        updateEntity.setHiGaitouflag(false);
                        updateEntity.setYoSien1flag(false);
                        updateEntity.setYoSien2flag(false);
                        updateEntity.setKeikatekiYoSienflag(false);
                        updateEntity.setYouKaigo1flag(false);
                        updateEntity.setYouKaigo2flag(false);
                        updateEntity.setYouKaigo3flag(true);
                        updateEntity.setYouKaigo4flag(false);
                        updateEntity.setYouKaigo5flag(false);
                        mapper.update出力用一時TBL(updateEntity);
                        setUpdate総合計(updateEntity, mapper);
                        setUpdate(updateEntity, mapper);
                    }
                    if (値24.equals(updateEntity.get要介護状態区分コード())) {
                        updateEntity.setHiGaitouflag(false);
                        updateEntity.setYoSien1flag(false);
                        updateEntity.setYoSien2flag(false);
                        updateEntity.setKeikatekiYoSienflag(false);
                        updateEntity.setYouKaigo1flag(false);
                        updateEntity.setYouKaigo2flag(false);
                        updateEntity.setYouKaigo3flag(false);
                        updateEntity.setYouKaigo4flag(true);
                        updateEntity.setYouKaigo5flag(false);
                        mapper.update出力用一時TBL(updateEntity);
                        setUpdate総合計(updateEntity, mapper);
                        setUpdate(updateEntity, mapper);
                    }
                    if (値25.equals(updateEntity.get要介護状態区分コード())) {
                        updateEntity.setHiGaitouflag(false);
                        updateEntity.setYoSien1flag(false);
                        updateEntity.setYoSien2flag(false);
                        updateEntity.setKeikatekiYoSienflag(false);
                        updateEntity.setYouKaigo1flag(false);
                        updateEntity.setYouKaigo2flag(false);
                        updateEntity.setYouKaigo3flag(false);
                        updateEntity.setYouKaigo4flag(false);
                        updateEntity.setYouKaigo5flag(true);
                        mapper.update出力用一時TBL(updateEntity);
                        setUpdate総合計(updateEntity, mapper);
                        setUpdate(updateEntity, mapper);
                    }
                }
            }
        }
    }

    private void updateDB出力出力用一時TBL1(UpdateParameterEntity updateEntity, INenreikaikyuRiyojokyoMapper mapper) {
        if (値01.equals(updateEntity.get要介護状態区分コード())) {
            updateEntity.setHiGaitouflag(true);
            updateEntity.setYoSien1flag(false);
            updateEntity.setYoSien2flag(false);
            updateEntity.setKeikatekiYoSienflag(false);
            updateEntity.setYouKaigo1flag(false);
            updateEntity.setYouKaigo2flag(false);
            updateEntity.setYouKaigo3flag(false);
            updateEntity.setYouKaigo4flag(false);
            updateEntity.setYouKaigo5flag(false);
            mapper.update出力用一時TBL(updateEntity);
            setUpdate総合計(updateEntity, mapper);
            setUpdate(updateEntity, mapper);
        }
        if (値11.equals(updateEntity.get要介護状態区分コード())) {
            updateEntity.setHiGaitouflag(false);
            updateEntity.setYoSien1flag(false);
            updateEntity.setYoSien2flag(false);
            updateEntity.setKeikatekiYoSienflag(true);
            updateEntity.setYouKaigo1flag(false);
            updateEntity.setYouKaigo2flag(false);
            updateEntity.setYouKaigo3flag(false);
            updateEntity.setYouKaigo4flag(false);
            updateEntity.setYouKaigo5flag(false);
            mapper.update出力用一時TBL(updateEntity);
            setUpdate総合計(updateEntity, mapper);
            setUpdate(updateEntity, mapper);
        }
        if (値12.equals(updateEntity.get要介護状態区分コード())) {
            updateEntity.setHiGaitouflag(false);
            updateEntity.setYoSien1flag(true);
            updateEntity.setYoSien2flag(false);
            updateEntity.setKeikatekiYoSienflag(false);
            updateEntity.setYouKaigo1flag(false);
            updateEntity.setYouKaigo2flag(false);
            updateEntity.setYouKaigo3flag(false);
            updateEntity.setYouKaigo4flag(false);
            updateEntity.setYouKaigo5flag(false);
            mapper.update出力用一時TBL(updateEntity);
            setUpdate総合計(updateEntity, mapper);
            setUpdate(updateEntity, mapper);
        }
        if (値13.equals(updateEntity.get要介護状態区分コード())) {
            updateEntity.setHiGaitouflag(false);
            updateEntity.setYoSien1flag(false);
            updateEntity.setYoSien2flag(true);
            updateEntity.setKeikatekiYoSienflag(false);
            updateEntity.setYouKaigo1flag(false);
            updateEntity.setYouKaigo2flag(false);
            updateEntity.setYouKaigo3flag(false);
            updateEntity.setYouKaigo4flag(false);
            updateEntity.setYouKaigo5flag(false);
            mapper.update出力用一時TBL(updateEntity);
            setUpdate総合計(updateEntity, mapper);
            setUpdate(updateEntity, mapper);
        }
    }

    private void setUpdate総合計(UpdateParameterEntity updateEntity, INenreikaikyuRiyojokyoMapper mapper) {
        if (!updateEntity.get集計番号().equals(RSTRING_43)) {
            mapper.update出力用一時TBL(update総合計(updateEntity));
        }
    }

    private UpdateParameterEntity update総合計(UpdateParameterEntity updateEntity) {
        UpdateParameterEntity newEntity = new UpdateParameterEntity();
        newEntity.set区分(updateEntity.get区分());
        newEntity.set要介護状態区分コード(updateEntity.get要介護状態区分コード());
        newEntity.set集計番号(RSTRING_07);
        newEntity.setHiGaitouflag(updateEntity.isHiGaitouflag());
        newEntity.setYoSien1flag(updateEntity.isYoSien1flag());
        newEntity.setYoSien2flag(updateEntity.isYoSien2flag());
        newEntity.setKeikatekiYoSienflag(updateEntity.isKeikatekiYoSienflag());
        newEntity.setYouKaigo1flag(updateEntity.isYouKaigo1flag());
        newEntity.setYouKaigo2flag(updateEntity.isYouKaigo2flag());
        newEntity.setYouKaigo3flag(updateEntity.isYouKaigo3flag());
        newEntity.setYouKaigo4flag(updateEntity.isYouKaigo4flag());
        newEntity.setYouKaigo5flag(updateEntity.isYouKaigo5flag());
        return newEntity;
    }

    private void setUpdate(UpdateParameterEntity updateEntity, INenreikaikyuRiyojokyoMapper mapper) {
        setUpdate1(updateEntity, mapper);
        setUpdate3(updateEntity, mapper);
        if (updateEntity.get集計番号().equals(RSTRING_18) || updateEntity.get集計番号().equals(RSTRING_19)
                || updateEntity.get集計番号().equals(RSTRING_20) || updateEntity.get集計番号().equals(RSTRING_36)
                || updateEntity.get集計番号().equals(RSTRING_40) || updateEntity.get集計番号().equals(RSTRING_41)
                || updateEntity.get集計番号().equals(RSTRING_42)) {
            if (サービス項目コード_1.equals(updateEntity.getサービス項目コード().substring(定数2, 定数3))) {
                update(updateEntity, RSTRING_51, mapper);
            } else if (サービス項目コード_2.equals(updateEntity.getサービス項目コード().substring(定数2, 定数3))) {
                update(updateEntity, RSTRING_52, mapper);
            }
        }
    }

    private void setUpdate3(UpdateParameterEntity updateEntity, INenreikaikyuRiyojokyoMapper mapper) {
        if (updateEntity.get集計番号().equals(RSTRING_40) || updateEntity.get集計番号().equals(RSTRING_41)
                || updateEntity.get集計番号().equals(RSTRING_42)) {
            update(updateEntity, RSTRING_05, mapper);
        }
        if (updateEntity.get集計番号().equals(RSTRING_24) || updateEntity.get集計番号().equals(RSTRING_25)
                || updateEntity.get集計番号().equals(RSTRING_26) || updateEntity.get集計番号().equals(RSTRING_27)
                || updateEntity.get集計番号().equals(RSTRING_28) || updateEntity.get集計番号().equals(RSTRING_29)
                || updateEntity.get集計番号().equals(RSTRING_30) || updateEntity.get集計番号().equals(RSTRING_31)
                || updateEntity.get集計番号().equals(RSTRING_32) || updateEntity.get集計番号().equals(RSTRING_33)
                || updateEntity.get集計番号().equals(RSTRING_34) || updateEntity.get集計番号().equals(RSTRING_35)
                || updateEntity.get集計番号().equals(RSTRING_36)) {
            update(updateEntity, RSTRING_06, mapper);
        }
    }

    private void setUpdate1(UpdateParameterEntity updateEntity, INenreikaikyuRiyojokyoMapper mapper) {
        if (updateEntity.get集計番号().equals(RSTRING_11) || updateEntity.get集計番号().equals(RSTRING_12)
                || updateEntity.get集計番号().equals(RSTRING_13) || updateEntity.get集計番号().equals(RSTRING_14)
                || updateEntity.get集計番号().equals(RSTRING_14) || updateEntity.get集計番号().equals(RSTRING_15)
                || updateEntity.get集計番号().equals(RSTRING_16) || updateEntity.get集計番号().equals(RSTRING_17)) {
            update(updateEntity, RSTRING_01, mapper);
        }
        if (updateEntity.get集計番号().equals(RSTRING_18) || updateEntity.get集計番号().equals(RSTRING_19)
                || updateEntity.get集計番号().equals(RSTRING_20)) {
            update(updateEntity, RSTRING_02, mapper);
        }
        setUpdate2(updateEntity, mapper);
    }

    private void setUpdate2(UpdateParameterEntity updateEntity, INenreikaikyuRiyojokyoMapper mapper) {
        if (updateEntity.get集計番号().equals(RSTRING_11) || updateEntity.get集計番号().equals(RSTRING_12)
                || updateEntity.get集計番号().equals(RSTRING_13) || updateEntity.get集計番号().equals(RSTRING_14)
                || updateEntity.get集計番号().equals(RSTRING_14) || updateEntity.get集計番号().equals(RSTRING_15)
                || updateEntity.get集計番号().equals(RSTRING_16) || updateEntity.get集計番号().equals(RSTRING_17)
                || updateEntity.get集計番号().equals(RSTRING_18) || updateEntity.get集計番号().equals(RSTRING_19)
                || updateEntity.get集計番号().equals(RSTRING_20) || updateEntity.get集計番号().equals(RSTRING_21)) {
            update(updateEntity, RSTRING_03, mapper);
        }
        setUpdate4(updateEntity, mapper);
    }

    private void setUpdate4(UpdateParameterEntity updateEntity, INenreikaikyuRiyojokyoMapper mapper) {
        if (updateEntity.get集計番号().equals(RSTRING_11) || updateEntity.get集計番号().equals(RSTRING_12)
                || updateEntity.get集計番号().equals(RSTRING_13) || updateEntity.get集計番号().equals(RSTRING_14)
                || updateEntity.get集計番号().equals(RSTRING_14) || updateEntity.get集計番号().equals(RSTRING_15)
                || updateEntity.get集計番号().equals(RSTRING_16) || updateEntity.get集計番号().equals(RSTRING_17)
                || updateEntity.get集計番号().equals(RSTRING_18) || updateEntity.get集計番号().equals(RSTRING_19)
                || updateEntity.get集計番号().equals(RSTRING_20) || updateEntity.get集計番号().equals(RSTRING_21)
                || updateEntity.get集計番号().equals(RSTRING_21) || updateEntity.get集計番号().equals(RSTRING_23)) {
            update(updateEntity, RSTRING_04, mapper);
        }
    }

    private void update(UpdateParameterEntity updateEntity, RString 集計番号, INenreikaikyuRiyojokyoMapper mapper) {
        UpdateParameterEntity newEntity = new UpdateParameterEntity();
        newEntity.set区分(updateEntity.get区分());
        newEntity.set要介護状態区分コード(updateEntity.get要介護状態区分コード());
        newEntity.set集計番号(集計番号);
        newEntity.setHiGaitouflag(updateEntity.isHiGaitouflag());
        newEntity.setYoSien1flag(updateEntity.isYoSien1flag());
        newEntity.setYoSien2flag(updateEntity.isYoSien2flag());
        newEntity.setKeikatekiYoSienflag(updateEntity.isKeikatekiYoSienflag());
        newEntity.setYouKaigo1flag(updateEntity.isYouKaigo1flag());
        newEntity.setYouKaigo2flag(updateEntity.isYouKaigo2flag());
        newEntity.setYouKaigo3flag(updateEntity.isYouKaigo3flag());
        newEntity.setYouKaigo4flag(updateEntity.isYouKaigo4flag());
        newEntity.setYouKaigo5flag(updateEntity.isYouKaigo5flag());
        mapper.update出力用一時TBL(newEntity);
    }
}
