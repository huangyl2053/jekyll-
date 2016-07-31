/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.shotokushokaihyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.core.shotokushokaihyo.JukyuusyaTyuushutuParameter;
import jp.co.ndensan.reams.db.dbb.definition.core.shotokushokaihyo.SaihaqkouTaishoupParameter;
import jp.co.ndensan.reams.db.dbb.definition.core.shotokushokaihyo.ShotokuNendoParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2020ShotokuShokaihyoHakkoRirekiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.saihakkofinder.SaiHakkoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo.FukaKijunSetaiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo.HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo.JukyuusyaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo.KouhoshaTenyuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo.SaihaqkouTaishouTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo.SetaiShotokuTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo.SetaiSudeTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo.ShotokuShoukaiDataTempEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2020ShotokuShokaihyoHakkoRirekiDac;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.shotokushokaihyo.IShotokushokaihyoMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurityjoho.KoseiShichosonJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT2008ShotokuKanriEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV2502KaigoShotokuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT2008ShotokuKanriDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbV2502KaigoShotokuAliveDac;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 所得照会票一括発行（バッチ）のクラス
 *
 * @reamsid_L DBB-1720-050 lijunjun
 */
public class Shotokushokaihyo {

    private final DbV2502KaigoShotokuAliveDac 介護所得Dac;
    private final DbT2020ShotokuShokaihyoHakkoRirekiDac 所得照会票発行履歴Dac;
    private final DbT2008ShotokuKanriDac 介護所得管理Dac;
    private final MapperProvider mapperProvider;
    private static final int 一月 = 1;
    private static final int 三月 = 1;
    private static final int 四月 = 4;
    private static final int 七月 = 7;
    private static final int 八月 = 8;
    private static final int NUM_マイナス = -1;
    private static final int NUM_1 = 1;
    private static final int NUM_2 = 2;
    private static final int NUM_18 = 18;
    private static final int NUM_31 = 31;
    private static final int NUM_39 = 39;
    private static final int NUM_64 = 64;
    private static final RString 住所地特例フラグ = new RString("1");
    private static final RString 管内_1 = new RString("1");
    private static final RString 住特者_2 = new RString("2");
    private static final RString 出力対象_1 = new RString("1");
    private static final RString 出力対象_2 = new RString("2");
    private static final RString 出力対象_3 = new RString("3");
    private static final RString 優先区分 = new RString("0");
    private static final RString 導入形態コード_111 = new RString("111");
    private static final RString 導入形態コード_112 = new RString("112");
    private static final RString 導入形態コード_120 = new RString("120");
    private static final RString 表示する = new RString("1");
    private static final RString 表示しない = new RString("0");
    private static final RString NUM_01 = new RString("01");

    Shotokushokaihyo() {
        介護所得Dac = InstanceProvider.create(DbV2502KaigoShotokuAliveDac.class);
        所得照会票発行履歴Dac = InstanceProvider.create(DbT2020ShotokuShokaihyoHakkoRirekiDac.class);
        介護所得管理Dac = InstanceProvider.create(DbT2008ShotokuKanriDac.class);
        mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link Shotokushokaihyo}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link Shotokushokaihyo}のインスタンス
     */
    public static Shotokushokaihyo createInstance() {
        return InstanceProvider.create(Shotokushokaihyo.class);
    }

    /**
     * 全て出力対象の取得
     *
     * @param 処理年度 RYear
     */
    public void getALL(FlexibleYear 処理年度) {
        if (処理年度 == null) {
            throw new ApplicationException(UrErrorMessages.検索キーの誤り
                    .getMessage().evaluate());
        }
        getIchigoHokenshaAndSetaiin(処理年度);
        getFukaKijyunYokujituSetaiin(処理年度);
        IShotokushokaihyoMapper mapper = mapperProvider.create(IShotokushokaihyoMapper.class);
        List<SetaiSudeTempEntity> 世帯員所得情報 = mapper.select世帯員所得情報_1();
        for (SetaiSudeTempEntity tempEntity : 世帯員所得情報) {
            mapper.insert所得照会票データTemp(tempEntity);
        }
    }

    /**
     * 1号被保険者および賦課基準日時点の世帯員の取得
     *
     * @param 処理年度 FlexibleYear
     */
    public void getIchigoHokenshaAndSetaiin(FlexibleYear 処理年度) {
        if (処理年度 == null) {
            throw new ApplicationException(UrErrorMessages.検索キーの誤り
                    .getMessage().evaluate());
        }
        FlexibleDate 処理年度の４月１日 = new FlexibleDate(処理年度.getYearValue(), 四月, NUM_1);
        FlexibleDate 処理年度plus1の４月１日 = new FlexibleDate(処理年度.getYearValue() + NUM_1, 四月, NUM_1);
        FlexibleDate 処理年度minus64の4月１日 = new FlexibleDate(処理年度.getYearValue() - NUM_64, 四月, NUM_1);
        FlexibleDate システム日付 = FlexibleDate.getNowDate();
        ShotokuNendoParameter param = new ShotokuNendoParameter();
        param.set処理年度_４月１日(処理年度の４月１日);
        param.set処理年度_plus1_４月１日(処理年度plus1の４月１日);
        param.set処理年度_minus64_4月１日(処理年度minus64の4月１日);
        param.setシステム日付(システム日付);
        IShotokushokaihyoMapper mapper = mapperProvider.create(IShotokushokaihyoMapper.class);
        List<HihokenshaDaichoEntity> 被保険者台帳管理リスト = mapper.select被保険者台帳管理(param);
        List<HihokenshaDaichoEntity> 年齢到達予定者リスト = mapper.select年齢到達予定者(param);
        List<ShikibetsuCode> 識別コードリスト = new ArrayList<>();
        for (HihokenshaDaichoEntity 被保険者台帳管理entity : 被保険者台帳管理リスト) {
            識別コードリスト.add(被保険者台帳管理entity.get識別コード());
        }
        for (HihokenshaDaichoEntity 年齢到達予定者entity : 年齢到達予定者リスト) {
            if (!識別コードリスト.contains(年齢到達予定者entity.get識別コード())) {
                被保険者台帳管理リスト.add(年齢到達予定者entity);
            }
        }
        for (HihokenshaDaichoEntity 被保険者台帳管理entity : 被保険者台帳管理リスト) {
            mapper.insert年度内有資格者Temp(被保険者台帳管理entity);
        }
        List<FukaKijunSetaiEntity> 賦課基準日時点の世帯員List = mapper.select賦課基準日時点の世帯員();
        for (FukaKijunSetaiEntity setaiEntity : 賦課基準日時点の世帯員List) {
            mapper.insert世帯員把握入力Temp(setaiEntity.get所得年度());
        }
        List<SetaiShotokuTempEntity> 世帯員所得_年度内有資格者List = mapper.select世帯員所得_年度内有資格者();
        for (SetaiShotokuTempEntity shotokuTempEntity : 世帯員所得_年度内有資格者List) {
            mapper.insert世帯員所得情報Temp1(shotokuTempEntity);
        }
    }

    /**
     * 受給者および世帯員の取得
     *
     * @param 処理年度 FlexibleYear
     */
    public void getFukaKijyunYokujituSetaiin(FlexibleYear 処理年度) {
        if (処理年度 == null) {
            throw new ApplicationException(UrErrorMessages.検索キーの誤り
                    .getMessage().evaluate());
        }
        ShotokuNendoParameter param = new ShotokuNendoParameter();
        FlexibleDate 処理年度_8月１日 = new FlexibleDate(処理年度.getYearValue(), 八月, NUM_1);
        FlexibleDate 処理年度_plus１_７月31日 = new FlexibleDate(処理年度.getYearValue() + NUM_1, 七月, NUM_31);
        param.set処理年度_8月１日(処理年度_8月１日);
        param.set処理年度_plus１_７月３１日(処理年度_plus１_７月31日);
        IShotokushokaihyoMapper mapper = mapperProvider.create(IShotokushokaihyoMapper.class);
        List<JukyuusyaEntity> 受給者抽出リスト = mapper.select受給者抽出(param);
        for (JukyuusyaEntity entity : 受給者抽出リスト) {
            mapper.insert受給者抽出Temp(entity);
        }
        List<FlexibleDate> 基準日時点;
        int count = NUM_マイナス;
        for (JukyuusyaEntity entity : 受給者抽出リスト) {
            count = count + NUM_1;
            基準日時点 = set基準日時点(entity.get認定有効期間開始年月日(), entity.get認定有効期間終了年月日());
            JukyuusyaTyuushutuParameter 世帯員把握Par = new JukyuusyaTyuushutuParameter();
            世帯員把握Par.set被保険者番号(entity.get被保険者番号());
            世帯員把握Par.set識別コード(entity.get識別コード());
            世帯員把握Par.set基準年月日(基準日時点.get(count));
            // 「受給者および世帯員」の１で取得した所得年度 TODO
            世帯員把握Par.set所得年度(処理年度);
            if ((基準日時点.get(count).compareTo(entity.get適用年月日()) == NUM_マイナス) && (entity.get解除年月日().isEmpty()
                    || entity.get解除年月日().compareTo(基準日時点.get(count)) == NUM_1)) {
                世帯員把握Par.set住所地特例フラグ(住所地特例フラグ);
            } else {
                世帯員把握Par.set住所地特例フラグ(RString.EMPTY);
            }
            mapper.insert世帯員把握入力Temp(世帯員把握Par);
        }
        List<SetaiShotokuTempEntity> 世帯員所得_受給者TempList = mapper.select世帯員所得_受給者Temp();
        for (SetaiShotokuTempEntity shotokuTempEntity : 世帯員所得_受給者TempList) {
            mapper.insert世帯員所得情報Temp2(shotokuTempEntity);
        }
    }

    private List<FlexibleDate> set基準日時点(FlexibleDate 認定有効期間開始年月日, FlexibleDate 認定有効期間終了年月日) {
        int 認定有効期間開始月 = 認定有効期間開始年月日.getMonthValue();
        int 認定有効期間終了月 = 認定有効期間終了年月日.getMonthValue();
        List<FlexibleDate> 基準日時点 = new ArrayList<>();
        基準日時点.add(認定有効期間開始年月日);
        for (int i = 認定有効期間開始月 + 1; i <= 認定有効期間終了月; i++) {
            認定有効期間開始年月日 = new FlexibleDate(String.valueOf(認定有効期間開始年月日.getYearValue())
                    .concat(String.valueOf(認定有効期間開始月 + 1)).concat(NUM_01.toString()));
            基準日時点.add(認定有効期間開始年月日);
        }
        return 基準日時点;
    }

    /**
     * 所得照会票を発行する可能性がある住民情報を作成
     *
     * @param 処理年度 FlexibleYear
     * @param 出力対象 RString
     * @param 再発行対象リスト List<SaiHakkoEntity>
     */
    public void getShotokushokaihyoJuminJoho(FlexibleYear 処理年度,
            RString 出力対象, List<SaiHakkoEntity> 再発行対象リスト) {
        if (処理年度 == null || 出力対象 == null || (再発行対象リスト == null || 再発行対象リスト.isEmpty())) {
            throw new ApplicationException(UrErrorMessages.検索キーの誤り
                    .getMessage().evaluate());
        }
        IShotokushokaihyoMapper mapper = mapperProvider.create(IShotokushokaihyoMapper.class);
        ShotokuNendoParameter param = new ShotokuNendoParameter();
        param.set処理年度_1月２日(new FlexibleDate(処理年度.getYearValue(), 一月, NUM_2));
        param.set処理年度_plus１_７月３１日(new FlexibleDate(処理年度.getYearValue() + NUM_1, 七月, NUM_31));
        param.set処理年度_plus１_３月３１日(new FlexibleDate(処理年度.getYearValue() + NUM_1, 三月, NUM_31));
        param.set処理年度_minus18_1月2日(new FlexibleDate(処理年度.getYearValue() - NUM_18, 一月, NUM_2));
        param.set処理年度_minus39_4月１日(new FlexibleDate(処理年度.getYearValue() - NUM_39, 四月, NUM_1));
        List<KouhoshaTenyuEntity> 候補者転入者リスト = mapper.select候補者転入者(param);
        List<KouhoshaTenyuEntity> 候補者住特情報リスト = mapper.select候補者住特情報(param);
        List<ShikibetsuCode> 識別コードリスト = new ArrayList<>();
        for (KouhoshaTenyuEntity 候補者転入者entity : 候補者転入者リスト) {
            識別コードリスト.add(候補者転入者entity.get識別コード());
        }
        for (KouhoshaTenyuEntity 候補者住特情報entity : 候補者住特情報リスト) {
            if (!識別コードリスト.contains(候補者住特情報entity.get識別コード())) {
                候補者転入者リスト.add(候補者住特情報entity);
            }
        }
        for (KouhoshaTenyuEntity entity : 候補者転入者リスト) {
            mapper.insert所得照会候補者Temp(entity);
        }
        List<ShikibetsuCode> 識別コード = mapper.select除外の住民(param);
        if (識別コード != null && !識別コード.isEmpty()) {
            for (int i = 0; i < 識別コード.size(); i++) {
                mapper.delete住民情報(識別コード.get(i));
            }
        }
        List<DbV2502KaigoShotokuEntity> 介護所得リスト = 介護所得Dac.select介護所得(処理年度);
        for (DbV2502KaigoShotokuEntity 介護所得entity : 介護所得リスト) {
            mapper.delete住民情報(介護所得entity.getShikibetsuCode());
        }
//        List<ShotokuJouhouEntity> 所得情報 = mapper.select所得情報(処理年度);
//        for (ShotokuJouhouEntity entity : 所得情報) {
//            mapper.delete住民情報(entity.get識別コード());
//        }
    }

    /**
     * 発行対象判定
     *
     * @param 処理年度 FlexibleYear
     * @param 出力対象 出力対象
     * @param 導入形態コード 導入形態コード
     */
    public void getHakkoTaisyo(FlexibleYear 処理年度,
            RString 出力対象,
            RString 導入形態コード) {
        if (処理年度 == null || 出力対象 == null || 導入形態コード == null) {
            throw new ApplicationException(UrErrorMessages.検索キーの誤り
                    .getMessage().evaluate());
        }
        List<ShotokuShoukaiDataTempEntity> 所得照会票データTempList = new ArrayList<>();
        IShotokushokaihyoMapper mapper = mapperProvider.create(IShotokushokaihyoMapper.class);
        if (出力対象.equals(出力対象_1)) {
            List<SetaiSudeTempEntity> 世帯員所得情報_3 = mapper.select世帯員所得情報_3();
            for (SetaiSudeTempEntity entity : 世帯員所得情報_3) {
                mapper.insert世帯員所得情報Temp3(entity);
                所得照会票データTempList = mapper.select所得照会票データfromTemp3();
            }
        } else if (出力対象.equals(出力対象_2)) {
            所得照会票データTempList = mapper.select所得照会票データfromTemp1();
        } else if (出力対象.equals(出力対象_3)) {
            所得照会票データTempList = mapper.select所得照会票データfromTemp2();
        }
        RDate 処理日付 = RDate.getNowDate();
        for (ShotokuShoukaiDataTempEntity 所得照会票データ : 所得照会票データTempList) {
            mapper.insert所得照会票データ(所得照会票データ);
        }
        editor住所を編集(所得照会票データTempList, 導入形態コード, 処理日付);
    }

    private void editor住所を編集(List<ShotokuShoukaiDataTempEntity> 所得照会票データTempList,
            RString 導入形態コード, RDate 処理日付) throws NullPointerException, IllegalArgumentException {
        for (ShotokuShoukaiDataTempEntity 所得照会票データ : 所得照会票データTempList) {
            if (所得照会票データ.getKouhoshakubun().equals(住特者_2)
                    && 所得照会票データ.getKannaiKangaiKubun().equals(管内_1)) {
                editor被保険者住所(導入形態コード, 処理日付, 所得照会票データ);
            }
            if (所得照会票データ.getKannaiKangaiKubun().equals(管内_1)) {
                IAssociationFinder finder = AssociationFinderFactory.createInstance();
                Association association = finder.getAssociation();
                RString 都道府県名 = association.get都道府県名();
                RString 郡名 = association.get郡名();
                RString 市町村名 = association.get市町村名();
                RString 都道府県名付与有無 = DbBusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_都道府県名付与有無,
                        処理日付, SubGyomuCode.DBU介護統計報告);
                RString 郡名付与有無 = DbBusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_郡名付与有無,
                        処理日付, SubGyomuCode.DBU介護統計報告);
                RString 市町村名付与有無 = DbBusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_市町村名付与有無,
                        処理日付, SubGyomuCode.DBU介護統計報告);
                if (都道府県名付与有無.equals(表示する) && 郡名付与有無.equals(表示する) && 市町村名付与有無.equals(表示する)) {
                    RString 現住所 = 都道府県名.concat(郡名).concat(市町村名).concat(所得照会票データ.getGenjusho());
                    所得照会票データ.setGenjusho(現住所);
                } else if (都道府県名付与有無.equals(表示しない)
                        && 郡名付与有無.equals(表示しない) && 市町村名付与有無.equals(表示しない)) {
                    所得照会票データ.setGenjusho(RString.EMPTY);
                }
            } else if (導入形態コード.equals(導入形態コード_111)) {
                KoseiShichosonJoho 構成市町村情報 = ShichosonSecurityJoho
                        .getKouseiShichosonJoho(所得照会票データ.getGenLasdecCode().getColumnValue());
                RString 都道府県名 = 構成市町村情報.get都道府県名称();
                RString 郡名 = 構成市町村情報.get郡名称();
                RString 現住所 = 都道府県名.concat(郡名).concat(所得照会票データ.getGenjusho());
                所得照会票データ.setGenjusho(現住所);
            }
        }
    }

    private void editor被保険者住所(RString 導入形態コード, RDate 処理日付,
            ShotokuShoukaiDataTempEntity 所得照会票データ)
            throws NullPointerException, IllegalArgumentException {
        if (導入形態コード.equals(導入形態コード_120) || 導入形態コード.equals(導入形態コード_112)) {
            IAssociationFinder finder = AssociationFinderFactory.createInstance();
            Association association = finder.getAssociation();
            RString 都道府県名 = association.get都道府県名();
            RString 郡名 = association.get郡名();
            RString 市町村名 = association.get市町村名();
            RString 都道府県名付与有無 = DbBusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_都道府県名付与有無,
                    処理日付, SubGyomuCode.DBU介護統計報告);
            RString 郡名付与有無 = DbBusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_郡名付与有無,
                    処理日付, SubGyomuCode.DBU介護統計報告);
            RString 市町村名付与有無 = DbBusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_市町村名付与有無,
                    処理日付, SubGyomuCode.DBU介護統計報告);
            if (都道府県名付与有無.equals(表示する) && 郡名付与有無.equals(表示する) && 市町村名付与有無.equals(表示する)) {
                RString 被保険者住所 = 都道府県名.concat(郡名).concat(市町村名).concat(所得照会票データ.getHihokenshajusho().getColumnValue());
                所得照会票データ.setHihokenshajusho(new AtenaJusho(被保険者住所));
            } else if (都道府県名付与有無.equals(表示しない) && 郡名付与有無.equals(表示しない) && 市町村名付与有無.equals(表示しない)) {
                所得照会票データ.setHihokenshajusho(AtenaJusho.EMPTY);
            }
        } else if (導入形態コード.equals(導入形態コード_111)) {
            KoseiShichosonJoho 構成市町村情報 = ShichosonSecurityJoho.getKouseiShichosonJoho(所得照会票データ.getGenLasdecCode().getColumnValue());
            RString 都道府県名 = 構成市町村情報.get都道府県名称();
            RString 郡名 = 構成市町村情報.get郡名称();
            RString 被保険者住所 = 都道府県名.concat(郡名).concat(所得照会票データ.getHihokenshajusho().getColumnValue());
            所得照会票データ.setHihokenshajusho(new AtenaJusho(被保険者住所));
        }
    }

    /**
     * 再発行対象取得
     *
     * @param 処理年度 FlexibleYear
     * @param 出力対象 RString
     * @param 再発行対象リスト List<SaiHakkoEntity>
     */
    public void getSaiHakkoShotokushokaihyo(FlexibleYear 処理年度,
            RString 出力対象, List<SaiHakkoEntity> 再発行対象リスト) {
        if (処理年度 == null || 出力対象 == null || (再発行対象リスト == null || 再発行対象リスト.isEmpty())) {
            throw new ApplicationException(UrErrorMessages.検索キーの誤り
                    .getMessage().evaluate());
        }
        IShotokushokaihyoMapper mapper = mapperProvider.create(IShotokushokaihyoMapper.class);
        getShotokushokaihyoJuminJoho(処理年度, 出力対象, 再発行対象リスト);

        List<RString> 発行ユーザーIDリスト = new ArrayList<>();
        List<YMDHMS> 処理日時リスト = new ArrayList<>();
        YMDHMS 処理日時;
        for (SaiHakkoEntity entity : 再発行対象リスト) {
            RString 発行ユーザーID = entity.getユーザ();
            処理日時 = entity.get処理日時();
            発行ユーザーIDリスト.add(発行ユーザーID);
            処理日時リスト.add(処理日時);
        }
        SaihaqkouTaishoupParameter param = new SaihaqkouTaishoupParameter();
        param.set作成日時(処理日時リスト);
        param.set発行ユーザーID(発行ユーザーIDリスト);
        param.set処理年度(処理年度);
        List<SaihaqkouTaishouTempEntity> 再発行対象List = mapper.select再発行対象者Temp(param);
        for (SaihaqkouTaishouTempEntity 再発行対象entity : 再発行対象List) {
            mapper.insert再発行対象者Temp(再発行対象entity);
        }

        List<ShotokuShoukaiDataTempEntity> 所得照会票データリスト = mapper.select所得照会票データ再発行();
        // TODO 被保険者氏名,被保険者住所,市町村コード
        for (ShotokuShoukaiDataTempEntity 所得照会票データentity : 所得照会票データリスト) {
            mapper.insert所得照会票データ(所得照会票データentity);
        }
    }

    /**
     * 所得照会票発行履歴、および介護所得管理マスタの更新
     *
     * @param 処理年度 FlexibleYear
     * @param 照会年月日 FlexibleDate
     * @param 所得照会票発行一覧リスト List<DbT2020ShotokuShokaihyoHakkoRirekiEntity>
     */
    public void updateShotokushokaihyo(FlexibleYear 処理年度, FlexibleDate 照会年月日,
            List<ShotokuShoukaiDataTempEntity> 所得照会票発行一覧リスト) {
        if (処理年度 == null || 照会年月日 == null
                || (所得照会票発行一覧リスト == null || 所得照会票発行一覧リスト.isEmpty())) {
            throw new ApplicationException(UrErrorMessages.検索キーの誤り
                    .getMessage().evaluate());
        }
        YMDHMS 処理日時 = YMDHMS.now();
        for (ShotokuShoukaiDataTempEntity entity : 所得照会票発行一覧リスト) {
            DbT2020ShotokuShokaihyoHakkoRirekiEntity 所得照会票発行一覧Entity = new DbT2020ShotokuShokaihyoHakkoRirekiEntity();
            所得照会票発行一覧Entity.setShoriNendo(処理年度);
            所得照会票発行一覧Entity.setShikibetsuCode(entity.getShikibetsuCode());
            所得照会票発行一覧Entity.setRirekiNo(set履歴番号(処理年度, entity.getShikibetsuCode()));
            所得照会票発行一覧Entity.setShokaisakiLasdecCode(new LasdecCode(entity.getShokaisakiLasdecCode().getShichosonCode6()));
            所得照会票発行一覧Entity.setSetaiCode(entity.getSetaiCode());
            所得照会票発行一覧Entity.setHakkoReamsLoginId(ControlDataHolder.getUserId());
            所得照会票発行一覧Entity.setHakkoYMD(照会年月日);
            所得照会票発行一覧Entity.setSakuseiTimestamp(YMDHMS.now());
            所得照会票発行一覧Entity.setState(EntityDataState.Added);
            所得照会票発行履歴Dac.save(所得照会票発行一覧Entity);
        }

        for (ShotokuShoukaiDataTempEntity entity : 所得照会票発行一覧リスト) {
            DbT2008ShotokuKanriEntity 介護所得管理Entity = new DbT2008ShotokuKanriEntity();
            介護所得管理Entity.setShotokuNendo(処理年度);
            介護所得管理Entity.setShikibetsuCode(entity.getShikibetsuCode());
            介護所得管理Entity.setRirekiNo(set履歴番号(処理年度, entity.getShikibetsuCode()));
            介護所得管理Entity.setKazeiKubun(new RString(KazeiKubun.所得調査中.toString()));
            介護所得管理Entity.setKazeiKubunGemmenGo(new RString(KazeiKubun.所得調査中.toString()));
            介護所得管理Entity.setGokeiShotokuGaku(Decimal.ZERO);
            介護所得管理Entity.setNenkiniShunyuGaku(Decimal.ZERO);
            介護所得管理Entity.setNenkiniShotokuGaku(Decimal.ZERO);
            介護所得管理Entity.setKazeiShotokuGaku(Decimal.ZERO);
            介護所得管理Entity.setGekihenKanwaKubun(RString.EMPTY);
            介護所得管理Entity.setYusenKubun(優先区分);
            介護所得管理Entity.setShoriTimeStamp(処理日時);
            介護所得管理Entity.setState(EntityDataState.Added);
            介護所得管理Dac.save(介護所得管理Entity);
        }
    }

    private int set履歴番号(FlexibleYear 照会年度, ShikibetsuCode 識別コード) {
        DbT2020ShotokuShokaihyoHakkoRirekiEntity 所得照会票発行履歴entity = 所得照会票発行履歴Dac.select履歴番号(照会年度, 識別コード);
        if (所得照会票発行履歴entity != null) {
            return 所得照会票発行履歴entity.getRirekiNo() + NUM_1;
        } else {
            return NUM_1;
        }
    }
}
