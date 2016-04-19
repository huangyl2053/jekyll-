/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.core.hihokenshashochohyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.core.enumeratedtype.config.ConfigKeysHihokenshashoIndicationMethod;
import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT7111ServiceShuruiShikyuGendoGakuDac;
import jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core.ShiharaiHenkoKanriKubun;
import jp.co.ndensan.reams.db.dbu.business.core.hihokenshashochohyo.HihokenshashoChohyoBusiness;
import jp.co.ndensan.reams.db.dbu.definition.core.hihokenshashochohyo.HihokenshashoChohyoParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7060KaigoJigyoshaDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7130KaigoServiceShuruiDac;
import jp.co.ndensan.reams.db.dbx.service.core.dbbusinessconfig.DbBusinessConifg;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.configkeys.ConfigKeysShiharaiHohoHenko;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.GaikokujinSeinengappiHyojihoho;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1005KaigoJogaiTokureiTaishoShisetsuDac;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoHanyoManager;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.INinshoshaManager;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.NinshoshaFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 被保険者証帳票Entity作成です。
 *
 * @reamsid_L DBU-0490-021 zhangzhiming
 */
public class HihokenshashoChohyoFinder {

    private final DbT7130KaigoServiceShuruiDac dbt7130Dac;
    private final DbT7111ServiceShuruiShikyuGendoGakuDac dbt7111Dac;
    private final DbT7060KaigoJigyoshaDac dbt7060Dac;
    private final DbT1005KaigoJogaiTokureiTaishoShisetsuDac dbt1005Dac;
    private static final RString 要介護認定期限切れ_表示有無 = new RString("要介護認定期限切れ_表示有無");
    private static final RString 居宅支援事業者適用切れ_表示有無 = new RString("居宅支援事業者適用切れ_表示有無");
    private static final RString 居宅支援事業者履歴_表示方法 = new RString("居宅支援事業者履歴_表示方法");
    private static final RString 介護保険施設 = new RString("介護保険施設");
    private static final RString 住所地特例対象施設 = new RString("住所地特例対象施設");
    private static final RString 該当データはありません = new RString("該当データはありません");
    private static final RString 枚目3の = new RString("3枚目の");
    private static final RString 下段参照 = new RString("下段参照");
    private static final RString 戸籍上の = new RString("戸籍上の");
    private static final RString 自己作成 = new RString("自己作成");
    private static final RString 単位 = new RString("単位");
    private static final RString 月1あたり = new RString("1月あたり");
    private static final RString 波線 = new RString("～");
    private static final RString 全角スペース = new RString("　");
    private static final RString 読点 = new RString("、");
    private static final RString 郵便番号表示有 = new RString("1");
    private static final RString 氏名カナ表示有 = new RString("1");
    private static final RString 星アイコン = new RString("＊");
    private static final RString 性別1 = new RString("1");
    private static final RString 住民種別コード2 = new RString("2");
    private static final RString 性別2 = new RString("2");
    private static final RString 住民種別コード4 = new RString("4");
    private static final RString 住民種別コード1 = new RString("1");
    private static final RString 住民種別コード3 = new RString("3");
    private static final RString 文字_0 = new RString("0");
    private static final RString 文字_1 = new RString("1");
    private static final RString 文字_2 = new RString("2");
    private static final RString 文字_3 = new RString("3");
    private static final RString 文字_4 = new RString("4");
    private static final RString 文字_5 = new RString("5");
    private static final int 桁数_0 = 0;
    private static final int 桁数_1 = 1;
    private static final int 桁数_2 = 2;
    private static final int 桁数_3 = 3;
    private static final int 桁数_4 = 4;
    private static final int 桁数_5 = 5;
    private static final int 桁数_6 = 6;
    private static final int 桁数_13 = 13;
    private static final int 桁数_150 = 150;
    private static final int 文字数_8 = 8;
    private static final int 文字数_40 = 40;

    /**
     * コンストラクタ。
     *
     */
    public HihokenshashoChohyoFinder() {
        this.dbt7130Dac = InstanceProvider.create(DbT7130KaigoServiceShuruiDac.class);
        this.dbt7111Dac = InstanceProvider.create(DbT7111ServiceShuruiShikyuGendoGakuDac.class);
        this.dbt7060Dac = InstanceProvider.create(DbT7060KaigoJigyoshaDac.class);
        this.dbt1005Dac = InstanceProvider.create(DbT1005KaigoJogaiTokureiTaishoShisetsuDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dbt7130Dac DbT7130KaigoServiceShuruiDac
     * @param dbt7111Dac DbT7111ServiceShuruiShikyuGendoGakuDac
     * @param dbt7060Dac DbT7060KaigoJigyoshaDac
     * @param dbt1005Dac DbT1005KaigoJogaiTokureiTaishoShisetsuDac
     */
    HihokenshashoChohyoFinder(DbT7130KaigoServiceShuruiDac dbt7130Dac, DbT7111ServiceShuruiShikyuGendoGakuDac dbt7111Dac,
            DbT7060KaigoJigyoshaDac dbt7060Dac, DbT1005KaigoJogaiTokureiTaishoShisetsuDac dbt1005Dac) {
        this.dbt7130Dac = dbt7130Dac;
        this.dbt7111Dac = dbt7111Dac;
        this.dbt7060Dac = dbt7060Dac;
        this.dbt1005Dac = dbt1005Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link HihokenshashoChohyoFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link HihokenshashoChohyoFinder}のインスタンス
     */
    public static HihokenshashoChohyoFinder createInstance() {
        return InstanceProvider.create(HihokenshashoChohyoFinder.class);
    }

    /**
     * 被保険者証一括作成バッチより、被保険者証帳票Entityを作成します。
     *
     * @param hihoken 被保険者証用データ
     * @return 被保険者証帳票ソースデータリスト
     */
    public SearchResult<HihokenshashoChohyoBusiness> createHihokenshashoChohyo(List<HihokenshashoChohyoParameter> hihoken) {
        return setHihokenshashoChohyo(hihoken);
    }

    private SearchResult<HihokenshashoChohyoBusiness> setHihokenshashoChohyo(List<HihokenshashoChohyoParameter> hihoken) {
        List<HihokenshashoChohyoBusiness> entity = new ArrayList<>();
        if (hihoken == null || hihoken.isEmpty()) {
            HihokenshashoChohyoBusiness business = new HihokenshashoChohyoBusiness();
            business.setHihojusho(該当データはありません);
            entity.add(business);
            return SearchResult.of(entity, entity.size(), true);
        }
        for (int i = 0; i < hihoken.size(); i++) {
            entity.get(i).setYukokigen1(RString.EMPTY);
            entity.get(i).setYukokigen2(RString.EMPTY);
            if (郵便番号表示有.equals(BusinessConfig.get(ConfigKeysHihokenshashoIndicationMethod.被保険者証表示方法_郵便番号表示有無))) {
                entity.get(i).setHihokenshanno(hihoken.get(i).getHihokenshaNo().getEditedYubinNo());
            }
            RString gyoseiku = hihoken.get(i).getGyoseiku();
            if (!gyoseiku.isNullOrEmpty()) {
                entity.get(i).setGyoseiku1(gyoseiku.substring(桁数_0, 桁数_13));
                if (gyoseiku.length() <= 桁数_13) {
                    entity.get(i).setGyoseiku2(RString.EMPTY);
                } else {
                    entity.get(i).setGyoseiku2(gyoseiku.substring(桁数_13));
                }
            } else {
                entity.get(i).setGyoseiku1(RString.EMPTY);
                entity.get(i).setGyoseiku2(RString.EMPTY);
            }
            //TODO 住所 QA1050 DBA介護資格Configの「被保険者証表示方法_管内住所編集_帳票独自区分」が存在しません
            entity.get(i).setHihojusho(RString.EMPTY);
            if (氏名カナ表示有.equals(BusinessConfig.get(ConfigKeysHihokenshashoIndicationMethod.被保険者証表示方法_氏名カナ表示有無))) {
                entity.get(i).setHihokana(hihoken.get(i).getHihokana());
            }
            entity.get(i).setHihoname(hihoken.get(i).getAtenaShimei());
            setEntity(hihoken.get(i), entity.get(i));
            if (!RString.isNullOrEmpty(hihoken.get(i).getTaishoNoParameter().get(0).getKeikakuJigyoshaNo())) {
                if (dbt7060Dac.select事業者名称(new JigyoshaNo(hihoken.get(i).getTaishoNoParameter()
                        .get(0).getKeikakuJigyoshaNo())).get(0).getJigyoshaName().getColumnValue().length() <= 文字数_40) {
                    entity.get(i).setGyosha1(dbt7060Dac.select事業者名称(new JigyoshaNo(hihoken.get(i).getTaishoNoParameter()
                            .get(0).getKeikakuJigyoshaNo())).get(0).getJigyoshaName().getColumnValue());
                } else {
                    entity.get(i).setItakuGyosha1(dbt7060Dac.select事業者名称(new JigyoshaNo(hihoken.get(i).getTaishoNoParameter()
                            .get(0).getKeikakuJigyoshaNo())).get(0).getJigyoshaName().getColumnValue());
                }
            } else {
                entity.get(i).setGyosha1(自己作成);
            }
            if (!RString.isNullOrEmpty(hihoken.get(i).getTaishoNoParameter().get(1).getKeikakuJigyoshaNo())) {
                if (dbt7060Dac.select事業者名称(new JigyoshaNo(hihoken.get(i).getTaishoNoParameter().get(1).getKeikakuJigyoshaNo()))
                        .get(0).getJigyoshaName().getColumnValue().length() <= 文字数_40) {
                    entity.get(i).setGyosha2(dbt7060Dac.select事業者名称(new JigyoshaNo(hihoken.get(i).getTaishoNoParameter()
                            .get(0).getKeikakuJigyoshaNo())).get(1).getJigyoshaName().getColumnValue());
                } else {
                    entity.get(i).setItakuGyosha2(dbt7060Dac.select事業者名称(new JigyoshaNo(hihoken.get(i).getTaishoNoParameter()
                            .get(0).getKeikakuJigyoshaNo())).get(1).getJigyoshaName().getColumnValue());
                }
            } else {
                entity.get(i).setGyosha1(自己作成);
            }
            if (!RString.isNullOrEmpty(hihoken.get(i).getTaishoNoParameter().get(2).getKeikakuJigyoshaNo())) {
                dbt7060Dac.select事業者名称(new JigyoshaNo(hihoken.get(i).getTaishoNoParameter().get(2).getKeikakuJigyoshaNo()))
                        .get(0).getJigyoshaName();
                if (dbt7060Dac.select事業者名称(new JigyoshaNo(hihoken.get(i).getTaishoNoParameter().get(2).getKeikakuJigyoshaNo()))
                        .get(0).getJigyoshaName().getColumnValue().length() <= 文字数_40) {
                    entity.get(i).setGyosha3(dbt7060Dac.select事業者名称(new JigyoshaNo(hihoken.get(i).getTaishoNoParameter()
                            .get(0).getKeikakuJigyoshaNo())).get(1).getJigyoshaName().getColumnValue());
                } else {
                    entity.get(i).setItakuGyosha3(dbt7060Dac.select事業者名称(new JigyoshaNo(hihoken.get(i).getTaishoNoParameter()
                            .get(2).getKeikakuJigyoshaNo())).get(0).getJigyoshaName().getColumnValue());
                }
            } else {
                entity.get(i).setGyosha1(自己作成);
            }
            entity.get(i).setTodokeYmd1(hihoken.get(i).getTodokedeYMD().get(0).wareki()
                    .eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
            entity.get(i).setTodokeYmd2(hihoken.get(i).getTodokedeYMD().get(1).wareki()
                    .eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
            entity.get(i).setTodokeYmd3(hihoken.get(i).getTodokedeYMD().get(2).wareki()
                    .eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
            entity.get(i).setShisetsuSyu1(hihoken.get(i).getNyushoParameter().get(0).getNyushoShisetsuShurui());
            entity.get(i).setShisetsuSyu2(hihoken.get(i).getNyushoParameter().get(1).getNyushoShisetsuShurui());
            set入退所チェック(entity.get(i), hihoken.get(i));
            entity.get(i).setNyushoymd1(hihoken.get(i).getNyushoParameter().get(0).getNyushoYMD().wareki()
                    .eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
            entity.get(i).setTaiinymd1(hihoken.get(i).getNyushoParameter().get(0).getTaishoYMD().wareki()
                    .eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
            entity.get(i).setNyushoymd2(hihoken.get(i).getNyushoParameter().get(1).getNyushoYMD().wareki()
                    .eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
            entity.get(i).setTaiinymd2(hihoken.get(i).getNyushoParameter().get(1).getTaishoYMD().wareki()
                    .eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
            entity.get(i).setRenban(new RString(String.valueOf(i + 1)).padLeft(文字_0, 桁数_6));
            entity.get(i).setSeiShogai1(枚目3の);
            entity.get(i).setSeiShogai2(下段参照);
            entity.get(i).setKosekiSeibetsu1(戸籍上の);
            set情報制御(entity.get(i), hihoken.get(i));
        }
        return SearchResult.of(entity, entity.size(), true);
    }

    private void set入退所チェック(HihokenshashoChohyoBusiness entity, HihokenshashoChohyoParameter hihoken) {
        if (介護保険施設.equals(hihoken.getNyushoParameter().get(0).getNyushoShisetsuShurui())) {
            entity.setShisetsuname1(dbt7060Dac.select事業者名称(new JigyoshaNo(hihoken.getNyushoParameter().get(0)
                    .getNyushoShisetsuCode())).get(0).getJigyoshaName().getColumnValue());
        }
        if (住所地特例対象施設.equals(hihoken.getNyushoParameter().get(0).getNyushoShisetsuShurui())) {
            entity.setShisetsuname1(dbt1005Dac.select事業者名称(new JigyoshaNo(hihoken.getNyushoParameter().get(0)
                    .getNyushoShisetsuCode())).get(0).getJigyoshaMeisho().getColumnValue());
        }
        if (介護保険施設.equals(hihoken.getNyushoParameter().get(1).getNyushoShisetsuShurui())) {
            entity.setShisetsuname2(dbt7060Dac.select事業者名称(new JigyoshaNo(hihoken.getNyushoParameter().get(0)
                    .getNyushoShisetsuCode())).get(0).getJigyoshaName().getColumnValue());
        }
        if (住所地特例対象施設.equals(hihoken.getNyushoParameter().get(1).getNyushoShisetsuShurui())) {
            entity.setShisetsuname2(dbt1005Dac.select事業者名称(new JigyoshaNo(hihoken.getNyushoParameter().get(0)
                    .getNyushoShisetsuCode())).get(0).getJigyoshaMeisho().getColumnValue());
        }
        if (介護保険施設.equals(hihoken.getNyushoParameter().get(0).getNyushoShisetsuShurui())
                && (文字_1.equals(hihoken.getNyushoParameter().get(0).getNyushoShisetsuCode().substring(桁数_2, 桁数_3))
                || 文字_3.equals(hihoken.getNyushoParameter().get(0).getNyushoShisetsuCode().substring(桁数_2, 桁数_3))
                || 文字_4.equals(hihoken.getNyushoParameter().get(0).getNyushoShisetsuCode().substring(桁数_2, 桁数_3))
                || 文字_5.equals(hihoken.getNyushoParameter().get(0).getNyushoShisetsuCode().substring(桁数_2, 桁数_3)))) {
            entity.setNyushochk1(星アイコン);
            entity.setTaishochk1(星アイコン);
        } else {
            entity.setNyuinchk1(星アイコン);
            entity.setTaiinchk1(星アイコン);
        }
        if (介護保険施設.equals(hihoken.getNyushoParameter().get(1).getNyushoShisetsuShurui())
                && (文字_1.equals(hihoken.getNyushoParameter().get(1).getNyushoShisetsuCode().substring(桁数_2, 桁数_3))
                || 文字_3.equals(hihoken.getNyushoParameter().get(1).getNyushoShisetsuCode().substring(桁数_2, 桁数_3))
                || 文字_4.equals(hihoken.getNyushoParameter().get(1).getNyushoShisetsuCode().substring(桁数_2, 桁数_3))
                || 文字_5.equals(hihoken.getNyushoParameter().get(1).getNyushoShisetsuCode().substring(桁数_2, 桁数_3)))) {
            entity.setNyushochk2(星アイコン);
            entity.setTaishochk2(星アイコン);
        } else {
            entity.setNyuinchk2(星アイコン);
            entity.setTaiinchk2(星アイコン);
        }
    }

    private void set情報制御(HihokenshashoChohyoBusiness entity, HihokenshashoChohyoParameter hihoken) {
        INinshoshaManager ninshoshaManager = NinshoshaFinderFactory.createInstance();
        Ninshosha ninshosha = ninshoshaManager.get帳票認証者(GyomuCode.DB介護保険, NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                FlexibleDate.EMPTY);
        entity.setImageField1(new RString(ninshosha.toString()));
        ChohyoSeigyoHanyoManager 帳票制御汎用Manager = new ChohyoSeigyoHanyoManager();
        ChohyoSeigyoHanyo chohyoSeigyoHanyo = 帳票制御汎用Manager.get帳票制御汎用(SubGyomuCode.DBA介護資格, ReportIdDBA.DBA100001.getReportId(),
                FlexibleDate.getNowDate().getYearMonth().getYear(), 要介護認定期限切れ_表示有無);
        if (文字_0.equals(chohyoSeigyoHanyo.get設定値()) && (hihoken.getKofuYMD()
                .isBefore(hihoken.getNinteiYukoKikanShuryoYMD()) || hihoken.getNinteiYukoKikanShuryoYMD().isEmpty())) {
            entity.setKaigokbn(RString.EMPTY);
            entity.setNinteiymd(RString.EMPTY);
            entity.setYukokikanst(RString.EMPTY);
            entity.setYukokikannamisen(RString.EMPTY);
            entity.setYukokikaned(RString.EMPTY);
            entity.setHomonkikanst(RString.EMPTY);
            entity.setHomonkikaned(RString.EMPTY);
            entity.setHomonkikannamisen(RString.EMPTY);
            entity.setShurui1(RString.EMPTY);
            entity.setShurui2(RString.EMPTY);
            entity.setShurui3(RString.EMPTY);
            entity.setShurui4(RString.EMPTY);
            entity.setShurui5(RString.EMPTY);
            entity.setShurui6(RString.EMPTY);
            entity.setShuruigendo1(RString.EMPTY);
            entity.setShuruigendo2(RString.EMPTY);
            entity.setShuruigendo3(RString.EMPTY);
            entity.setShuruigendo4(RString.EMPTY);
            entity.setShuruigendo5(RString.EMPTY);
            entity.setShuruigendo6(RString.EMPTY);
            entity.setTen1(RString.EMPTY);
            entity.setTen2(RString.EMPTY);
            entity.setTen3(RString.EMPTY);
            entity.setTen4(RString.EMPTY);
            entity.setTen5(RString.EMPTY);
            entity.setTen6(RString.EMPTY);
            entity.setSeigen1(RString.EMPTY);
            entity.setSeigen2(RString.EMPTY);
            entity.setSeigen3(RString.EMPTY);
            entity.setSeigen4(RString.EMPTY);
            entity.setSeigen5(RString.EMPTY);
            entity.setSeigen6(RString.EMPTY);
            entity.setSeigenLong1(RString.EMPTY);
            entity.setSeigenLong2(RString.EMPTY);
            entity.setSeigenLong3(RString.EMPTY);
            entity.setSeigenLong4(RString.EMPTY);
            entity.setSeigenLong5(RString.EMPTY);
            entity.setSeigenLong6(RString.EMPTY);
            entity.setSeigenSt1(RString.EMPTY);
            entity.setSeigenSt2(RString.EMPTY);
            entity.setSeigenSt3(RString.EMPTY);
            entity.setSeigenEd1(RString.EMPTY);
            entity.setSeigenEd2(RString.EMPTY);
            entity.setSeigenEd3(RString.EMPTY);
            entity.setGyosha1(RString.EMPTY);
            entity.setGyosha2(RString.EMPTY);
            entity.setGyosha3(RString.EMPTY);
            entity.setGyosha2(RString.EMPTY);
            entity.setGyosha3(RString.EMPTY);
            entity.setTodokeYmd2(RString.EMPTY);
            entity.setTodokeYmd3(RString.EMPTY);
            entity.setItakuGyosha2(RString.EMPTY);
            entity.setItakuGyosha3(RString.EMPTY);
            entity.setItakuGyosha2Asa(RString.EMPTY);
            entity.setItakuGyosha3Asa(RString.EMPTY);
            entity.setItakuGyosha3Massho(RString.EMPTY);
            entity.setItakuGyosha2Massho(RString.EMPTY);
            entity.setGyosha2Asa(RString.EMPTY);
            entity.setGyosha3Asa(RString.EMPTY);
            entity.setGyosha2Massho(RString.EMPTY);
            entity.setGyosha3Massho(RString.EMPTY);
            entity.setTodokeYmd3Asa(RString.EMPTY);
            entity.setTodokeYmd2Asa(RString.EMPTY);
            entity.setTodokeYmd3Massho(RString.EMPTY);
            entity.setTodokeYmd2Massho(RString.EMPTY);

        }
        ChohyoSeigyoHanyo chohyoSeigyo = 帳票制御汎用Manager.get帳票制御汎用(SubGyomuCode.DBA介護資格, ReportIdDBA.DBA100001.getReportId(),
                FlexibleDate.getNowDate().getYearMonth().getYear(), 居宅支援事業者適用切れ_表示有無);
        if (文字_0.equals(chohyoSeigyoHanyo.get設定値()) && hihoken.getNinteiYukoKikanShuryoYMD()
                .isBeforeOrEquals(hihoken.getKofuYMD()) && 文字_0.equals(chohyoSeigyo.get設定値())) {
            if (hihoken.getKofuYMD().isBefore(hihoken.getTaishoNoParameter().get(0).getTekiyoShuryoYMD())
                    || hihoken.getTaishoNoParameter().get(0).getTekiyoShuryoYMD().isEmpty()) {
                entity.setGyosha1(RString.EMPTY);
                entity.setGyosha2(RString.EMPTY);
                entity.setGyosha3(RString.EMPTY);
                entity.setGyosha2(RString.EMPTY);
                entity.setGyosha3(RString.EMPTY);
                entity.setTodokeYmd2(RString.EMPTY);
                entity.setTodokeYmd3(RString.EMPTY);
                entity.setItakuGyosha2(RString.EMPTY);
                entity.setItakuGyosha3(RString.EMPTY);
                entity.setItakuGyosha2Asa(RString.EMPTY);
                entity.setItakuGyosha3Asa(RString.EMPTY);
                entity.setItakuGyosha3Massho(RString.EMPTY);
                entity.setItakuGyosha2Massho(RString.EMPTY);
                entity.setGyosha2Asa(RString.EMPTY);
                entity.setGyosha3Asa(RString.EMPTY);
                entity.setGyosha2Massho(RString.EMPTY);
                entity.setGyosha3Massho(RString.EMPTY);
                entity.setTodokeYmd3Asa(RString.EMPTY);
                entity.setTodokeYmd2Asa(RString.EMPTY);
                entity.setTodokeYmd3Massho(RString.EMPTY);
                entity.setTodokeYmd2Massho(RString.EMPTY);
            } else {
                chohyoHensu(entity);
            }
        }
        if (文字_0.equals(chohyoSeigyoHanyo.get設定値()) && hihoken.getNinteiYukoKikanShuryoYMD()
                .isBeforeOrEquals(hihoken.getKofuYMD()) && 文字_1.equals(chohyoSeigyo.get設定値())) {
            entity.setTodokeYmd3Asa(RString.EMPTY);
            entity.setTodokeYmd2Asa(RString.EMPTY);
        }
    }

    private void chohyoHensu(HihokenshashoChohyoBusiness entity) {
        ChohyoSeigyoHanyoManager 帳票制御汎用Manager = new ChohyoSeigyoHanyoManager();
        ChohyoSeigyoHanyo chohyoHensu = 帳票制御汎用Manager.get帳票制御汎用(SubGyomuCode.DBA介護資格, ReportIdDBA.DBA100001.getReportId(),
                FlexibleDate.getNowDate().getYearMonth().getYear(), 居宅支援事業者履歴_表示方法);
        if (文字_0.equals(chohyoHensu.get設定値())) {
            entity.setItakuGyosha2Asa(RString.EMPTY);
            entity.setItakuGyosha3Asa(RString.EMPTY);
            entity.setItakuGyosha3Massho(RString.EMPTY);
            entity.setItakuGyosha2Massho(RString.EMPTY);
            entity.setGyosha2Asa(RString.EMPTY);
            entity.setGyosha3Asa(RString.EMPTY);
            entity.setGyosha2Massho(RString.EMPTY);
            entity.setGyosha3Massho(RString.EMPTY);
            entity.setTodokeYmd3Asa(RString.EMPTY);
            entity.setTodokeYmd2Asa(RString.EMPTY);
            entity.setTodokeYmd3Massho(RString.EMPTY);
            entity.setTodokeYmd2Massho(RString.EMPTY);
        }
        if (文字_1.equals(chohyoHensu.get設定値())) {
            entity.setGyosha2(RString.EMPTY);
            entity.setGyosha3(RString.EMPTY);
            entity.setTodokeYmd2(RString.EMPTY);
            entity.setTodokeYmd3(RString.EMPTY);
            entity.setItakuGyosha2(RString.EMPTY);
            entity.setItakuGyosha3(RString.EMPTY);
            entity.setItakuGyosha2Asa(RString.EMPTY);
            entity.setItakuGyosha3Asa(RString.EMPTY);
            entity.setItakuGyosha3Massho(RString.EMPTY);
            entity.setItakuGyosha2Massho(RString.EMPTY);
            entity.setGyosha2Asa(RString.EMPTY);
            entity.setGyosha3Asa(RString.EMPTY);
            entity.setGyosha2Massho(RString.EMPTY);
            entity.setGyosha3Massho(RString.EMPTY);
            entity.setTodokeYmd3Asa(RString.EMPTY);
            entity.setTodokeYmd2Asa(RString.EMPTY);
            entity.setTodokeYmd3Massho(RString.EMPTY);
            entity.setTodokeYmd2Massho(RString.EMPTY);
        }
        if (文字_2.equals(chohyoHensu.get設定値())) {
            entity.setItakuGyosha2Asa(星アイコン);
            entity.setItakuGyosha3Asa(星アイコン);
            entity.setItakuGyosha3Massho(RString.EMPTY);
            entity.setItakuGyosha2Massho(RString.EMPTY);
            entity.setGyosha2Asa(星アイコン);
            entity.setGyosha3Asa(星アイコン);
            entity.setGyosha2Massho(RString.EMPTY);
            entity.setGyosha3Massho(RString.EMPTY);
            entity.setTodokeYmd3Asa(星アイコン);
            entity.setTodokeYmd2Asa(星アイコン);
            entity.setTodokeYmd3Massho(RString.EMPTY);
            entity.setTodokeYmd2Massho(RString.EMPTY);
        }
        if (文字_3.equals(chohyoHensu.get設定値())) {
            entity.setGyosha2(RString.EMPTY);
            entity.setGyosha3(RString.EMPTY);
            entity.setTodokeYmd2(RString.EMPTY);
            entity.setTodokeYmd3(RString.EMPTY);
            entity.setItakuGyosha2(RString.EMPTY);
            entity.setItakuGyosha3(RString.EMPTY);
            entity.setItakuGyosha2Asa(RString.EMPTY);
            entity.setItakuGyosha3Asa(RString.EMPTY);
            entity.setGyosha2Asa(RString.EMPTY);
            entity.setGyosha3Asa(RString.EMPTY);
            entity.setTodokeYmd3Asa(RString.EMPTY);
            entity.setTodokeYmd2Asa(RString.EMPTY);
        }
    }

    private void setEntity(HihokenshashoChohyoParameter hihoken, HihokenshashoChohyoBusiness entity) {
        if (住民種別コード2.equals(hihoken.getJuminShubetsuCode()) || 住民種別コード4.equals(hihoken.getJuminShubetsuCode())) {
            if (BusinessConfig.get(ConfigNameDBU.外国人表示制御_生年月日表示方法).equals(GaikokujinSeinengappiHyojihoho.西暦表示.getコード())) {
                entity.setUmareYyyy(hihoken.getSeinengappiYMD().seireki()
                        .separator(Separator.JAPANESE).fillType(FillType.BLANK).getYear());
                entity.setUmareMm(hihoken.getSeinengappiYMD().seireki()
                        .separator(Separator.JAPANESE).fillType(FillType.BLANK).getMonth());
                entity.setUmareDd(hihoken.getSeinengappiYMD().seireki()
                        .separator(Separator.JAPANESE).fillType(FillType.BLANK).getDay());
                entity.setUmareMeiji1(星アイコン);
                entity.setUmareTaisho1(星アイコン);
                entity.setUmareShowa1(星アイコン);
            }
            if (BusinessConfig.get(ConfigNameDBU.外国人表示制御_生年月日表示方法).equals(GaikokujinSeinengappiHyojihoho.和暦表示.getコード())
                    && !hihoken.isUmareflg()) {
                entity.setUmareG(hihoken.getSeinengappiYMD().wareki().eraType(EraType.KANJI)
                        .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).getEra());
                entity.setUmareYy(hihoken.getSeinengappiYMD().wareki().eraType(EraType.KANJI)
                        .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).getYear());
                entity.setUmareMm(hihoken.getSeinengappiYMD().wareki().eraType(EraType.KANJI)
                        .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).getMonth());
                entity.setUmareDd(hihoken.getSeinengappiYMD().wareki().eraType(EraType.KANJI)
                        .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).getDay());
                entity.setUmareMeiji1(星アイコン);
                entity.setUmareTaisho1(星アイコン);
            }
            if (BusinessConfig.get(ConfigNameDBU.外国人表示制御_生年月日表示方法).equals(GaikokujinSeinengappiHyojihoho.和暦表示.getコード())
                    && hihoken.isUmareflg()) {
                entity.setUmareG(RString.EMPTY);
                entity.setUmareYy(RString.EMPTY);
                entity.setUmareYyyy(RString.EMPTY);
                entity.setUmareMm(RString.EMPTY);
                entity.setUmareDd(RString.EMPTY);
            }
        }
        if (住民種別コード1.equals(hihoken.getJuminShubetsuCode()) || 住民種別コード3.equals(hihoken.getJuminShubetsuCode())) {
            entity.setUmareMeiji1(星アイコン);
            entity.setUmareTaisho1(星アイコン);
            entity.setUmareG(hihoken.getSeinengappiYMD().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).getEra());
            entity.setUmareYy(hihoken.getSeinengappiYMD().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).getYear());
            entity.setUmareMm(hihoken.getSeinengappiYMD().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).getMonth());
            entity.setUmareDd(hihoken.getSeinengappiYMD().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).getDay());
        }
        if (性別1.equals(hihoken.getSeibetsu())) {
            entity.setSeibetsuWoman1(星アイコン);
        }
        if (性別2.equals(hihoken.getSeibetsu())) {
            entity.setSeibetsuMan1(星アイコン);
        }
        entity.setKofuymd(new RString(hihoken.getKofuYMD().toString()));
        entity.setSaikofu1(RString.EMPTY);
        entity.setHokenshano1(hihoken.getShoKisaiHokenshaNo().substring(桁数_0, 桁数_1));
        entity.setHokenshano2(hihoken.getShoKisaiHokenshaNo().substring(桁数_1, 桁数_2));
        entity.setHokenshano3(hihoken.getShoKisaiHokenshaNo().substring(桁数_2, 桁数_3));
        entity.setHokenshano4(hihoken.getShoKisaiHokenshaNo().substring(桁数_3, 桁数_4));
        entity.setHokenshano5(hihoken.getShoKisaiHokenshaNo().substring(桁数_4, 桁数_5));
        entity.setHokenshano6(hihoken.getShoKisaiHokenshaNo().substring(桁数_5));
        entity.setKaigokbn(YokaigoJotaiKubun99.toValue(hihoken.getYokaigoJotaiKubunCode()).get名称());
        entity.setNinteiymd(hihoken.getNinteiYMD().wareki().eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        entity.setYukokikanst(hihoken.getNinteiYukoKikanKaishiYMD().wareki().eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        entity.setYukokikaned(hihoken.getNinteiYukoKikanShuryoYMD().wareki().eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        entity.setHomonkikanst(hihoken.getShikyuGendoKaishiYMD().wareki().eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        entity.setHomonkikaned(hihoken.getShikyuGendoShuryoYMD().wareki().eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        entity.setYukokikannamisen(波線);
        entity.setService0(月1あたり);
        entity.setService(hihoken.getShikyuGendoTanisu());
        entity.setTen0(単位);
        getサービス種類(entity, hihoken);
        RString serviceA = getサービス種類名称(hihoken);
        RString serviceB = getサービス種類略称(hihoken);
        if (serviceA.length() <= 桁数_150) {
            entity.setRyui(serviceA);
        }
        if (serviceA.length() > 桁数_150 && serviceB.length() <= 桁数_150) {
            entity.setRyui(serviceB);
        }
        if (serviceA.length() > 桁数_150 && serviceB.length() > 桁数_150) {
            entity.setRyui(serviceB.substring(桁数_0, 桁数_150));
        }
        entity.setSaikofu2(RString.EMPTY);
        set給付制限(entity, hihoken);
        entity.setSeigenSt1(hihoken.getTaishoNoParameter().get(0).getTekiyoKaishiYMD().wareki()
                .eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        entity.setSeigenEd1(hihoken.getTaishoNoParameter().get(0).getTekiyoShuryoYMD().wareki()
                .eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        entity.setSeigenSt2(hihoken.getTaishoNoParameter().get(1).getTekiyoKaishiYMD().wareki()
                .eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        entity.setSeigenEd2(hihoken.getTaishoNoParameter().get(1).getTekiyoShuryoYMD().wareki()
                .eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        entity.setSeigenSt3(hihoken.getTaishoNoParameter().get(2).getTekiyoKaishiYMD().wareki()
                .eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        entity.setSeigenEd3(hihoken.getTaishoNoParameter().get(2).getTekiyoShuryoYMD().wareki()
                .eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
    }

    private void set給付制限(HihokenshashoChohyoBusiness entity, HihokenshashoChohyoParameter hihoken) {
        if (hihoken.getKanriKubun().equals(ShiharaiHenkoKanriKubun._２号差止.getコード())) {
            if (DbBusinessConifg.get(ConfigKeysShiharaiHohoHenko.支払方法変更_証表示差止_記載文言,
                    RDate.getNowDate(), SubGyomuCode.DBD介護受給).length() <= 文字数_8) {
                entity.setSeigen1(DbBusinessConifg.get(ConfigKeysShiharaiHohoHenko.支払方法変更_証表示差止_記載文言,
                        RDate.getNowDate(), SubGyomuCode.DBD介護受給).substring(桁数_0, 桁数_4));
                entity.setSeigen2(DbBusinessConifg.get(ConfigKeysShiharaiHohoHenko.支払方法変更_証表示差止_記載文言,
                        RDate.getNowDate(), SubGyomuCode.DBD介護受給).substring(桁数_4));
            } else {
                entity.setSeigenLong1(DbBusinessConifg.get(ConfigKeysShiharaiHohoHenko.支払方法変更_証表示差止_記載文言,
                        RDate.getNowDate(), SubGyomuCode.DBD介護受給).substring(桁数_0, 桁数_6));
                entity.setSeigenLong2(DbBusinessConifg.get(ConfigKeysShiharaiHohoHenko.支払方法変更_証表示差止_記載文言,
                        RDate.getNowDate(), SubGyomuCode.DBD介護受給).substring(桁数_6));
            }
        }
        if (hihoken.getKanriKubun().equals(ShiharaiHenkoKanriKubun._１号償還払い化.getコード())) {
            if (DbBusinessConifg.get(ConfigKeysShiharaiHohoHenko.支払方法変更_証表示支払方法_記載文言,
                    RDate.getNowDate(), SubGyomuCode.DBD介護受給).length() <= 文字数_8) {
                entity.setSeigen3(DbBusinessConifg.get(ConfigKeysShiharaiHohoHenko.支払方法変更_証表示支払方法_記載文言,
                        RDate.getNowDate(), SubGyomuCode.DBD介護受給).substring(桁数_0, 桁数_4));
                entity.setSeigen4(DbBusinessConifg.get(ConfigKeysShiharaiHohoHenko.支払方法変更_証表示支払方法_記載文言,
                        RDate.getNowDate(), SubGyomuCode.DBD介護受給).substring(桁数_4));
            } else {
                entity.setSeigenLong3(DbBusinessConifg.get(ConfigKeysShiharaiHohoHenko.支払方法変更_証表示支払方法_記載文言,
                        RDate.getNowDate(), SubGyomuCode.DBD介護受給).substring(桁数_0, 桁数_6));
                entity.setSeigenLong4(DbBusinessConifg.get(ConfigKeysShiharaiHohoHenko.支払方法変更_証表示支払方法_記載文言,
                        RDate.getNowDate(), SubGyomuCode.DBD介護受給).substring(桁数_6));
            }
        }
        if (hihoken.getKanriKubun().equals(ShiharaiHenkoKanriKubun._１号給付額減額.getコード())) {
            if (DbBusinessConifg.get(ConfigKeysShiharaiHohoHenko.支払方法変更_証表示減額_記載文言,
                    RDate.getNowDate(), SubGyomuCode.DBD介護受給).length() <= 文字数_8) {
                entity.setSeigen5(DbBusinessConifg.get(ConfigKeysShiharaiHohoHenko.支払方法変更_証表示減額_記載文言,
                        RDate.getNowDate(), SubGyomuCode.DBD介護受給).substring(桁数_0, 桁数_4));
                entity.setSeigen6(DbBusinessConifg.get(ConfigKeysShiharaiHohoHenko.支払方法変更_証表示減額_記載文言,
                        RDate.getNowDate(), SubGyomuCode.DBD介護受給).substring(桁数_4));
            } else {
                entity.setSeigenLong5(DbBusinessConifg.get(ConfigKeysShiharaiHohoHenko.支払方法変更_証表示減額_記載文言,
                        RDate.getNowDate(), SubGyomuCode.DBD介護受給).substring(桁数_0, 桁数_6));
                entity.setSeigenLong6(DbBusinessConifg.get(ConfigKeysShiharaiHohoHenko.支払方法変更_証表示減額_記載文言,
                        RDate.getNowDate(), SubGyomuCode.DBD介護受給).substring(桁数_6));
            }
        }
    }

    private RString getサービス種類名称(HihokenshashoChohyoParameter hihoken) {
        RStringBuilder builder = new RStringBuilder();
        builder.append(hihoken.getShinsakaiIken());
        builder.append(全角スペース);
        if (!dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui01()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiMeisho().isEmpty()) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui01()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiMeisho());
            builder.append(読点);
        }
        if (!dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui02()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiMeisho().isEmpty()) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui02()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiMeisho());
            builder.append(読点);
        }
        if (!dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui03()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiMeisho().isEmpty()) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui03()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiMeisho());
            builder.append(読点);
        }
        if (!dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui04()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiMeisho().isEmpty()) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui04()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiMeisho());
            builder.append(読点);
        }
        if (!dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui05()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiMeisho().isEmpty()) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui05()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiMeisho());
            builder.append(読点);
        }
        if (!dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui06()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiMeisho().isEmpty()) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui06()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiMeisho());
            builder.append(読点);
        }
        if (!dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui07()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiMeisho().isEmpty()) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui07()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiMeisho());
            builder.append(読点);
        }
        if (!dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui08()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiMeisho().isEmpty()) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui08()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiMeisho());
            builder.append(読点);
        }
        if (!dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui09()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiMeisho().isEmpty()) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui09()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiMeisho());
            builder.append(読点);
        }
        if (!dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui10()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiMeisho().isEmpty()) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui10()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiMeisho());
            builder.append(読点);
        }
        if (!dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui11()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiMeisho().isEmpty()) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui11()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiMeisho());
            builder.append(読点);
        }
        if (!dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui12()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiMeisho().isEmpty()) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui12()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiMeisho());
            builder.append(読点);
        }
        if (!dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui13()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiMeisho().isEmpty()) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui13()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiMeisho());
            builder.append(読点);
        }
        if (!dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui14()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiMeisho().isEmpty()) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui14()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiMeisho());
            builder.append(読点);
        }
        if (!dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui15()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiMeisho().isEmpty()) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui15()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiMeisho());
            builder.append(読点);
        }
        return get種類名称(hihoken, builder).toRString();
    }

    private RStringBuilder get種類名称(HihokenshashoChohyoParameter hihoken, RStringBuilder builder) {
        if (!dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui16()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiMeisho().isEmpty()) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui16()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiMeisho());
            builder.append(読点);
        }
        if (!dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui17()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiMeisho().isEmpty()) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui17()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiMeisho());
            builder.append(読点);
        }
        if (!dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui18()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiMeisho().isEmpty()) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui18()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiMeisho());
            builder.append(読点);
        }
        if (!dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui19()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiMeisho().isEmpty()) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui19()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiMeisho());
            builder.append(読点);
        }
        if (!dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui20()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiMeisho().isEmpty()) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui20()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiMeisho());
            builder.append(読点);
        }
        if (!dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui21()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiMeisho().isEmpty()) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui21()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiMeisho());
            builder.append(読点);
        }
        if (!dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui22()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiMeisho().isEmpty()) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui22()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiMeisho());
            builder.append(読点);
        }
        if (!dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui23()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiMeisho().isEmpty()) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui23()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiMeisho());
            builder.append(読点);
        }
        if (!dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui24()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiMeisho().isEmpty()) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui24()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiMeisho());
            builder.append(読点);
        }
        if (!dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui25()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiMeisho().isEmpty()) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui25()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiMeisho());
            builder.append(読点);
        }
        if (!dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui26()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiMeisho().isEmpty()) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui26()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiMeisho());
            builder.append(読点);
        }
        if (!dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui27()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiMeisho().isEmpty()) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui27()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiMeisho());
            builder.append(読点);
        }
        if (!dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui28()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiMeisho().isEmpty()) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui28()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiMeisho());
            builder.append(読点);
        }
        if (!dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui29()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiMeisho().isEmpty()) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui29()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiMeisho());
            builder.append(読点);
        }
        if (!dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui30()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiMeisho().isEmpty()) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui30()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiMeisho());
        }
        return builder;
    }

    private RString getサービス種類略称(HihokenshashoChohyoParameter hihoken) {
        RStringBuilder builder = new RStringBuilder();
        builder.append(hihoken.getShinsakaiIken());
        builder.append(全角スペース);
        if (dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui01()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiRyakusho() != null) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui01()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiRyakusho());
            builder.append(読点);
        }
        if (dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui02()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiRyakusho() != null) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui02()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiRyakusho());
            builder.append(読点);
        }
        if (dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui03()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiRyakusho() != null) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui03()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiRyakusho());
            builder.append(読点);
        }
        if (dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui04()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiRyakusho() != null) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui04()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiRyakusho());
            builder.append(読点);
        }
        if (dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui05()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiRyakusho() != null) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui05()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiRyakusho());
            builder.append(読点);
        }
        if (dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui06()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiRyakusho() != null) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui06()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiRyakusho());
            builder.append(読点);
        }
        if (dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui07()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiRyakusho() != null) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui07()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiRyakusho());
            builder.append(読点);
        }
        if (dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui08()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiRyakusho() != null) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui08()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiRyakusho());
            builder.append(読点);
        }
        if (dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui09()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiRyakusho() != null) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui09()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiRyakusho());
            builder.append(読点);
        }
        if (dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui10()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiRyakusho() != null) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui10()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiRyakusho());
            builder.append(読点);
        }
        if (dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui11()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiRyakusho() != null) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui11()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiRyakusho());
            builder.append(読点);
        }
        if (dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui12()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiRyakusho() != null) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui12()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiRyakusho());
            builder.append(読点);
        }
        if (dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui13()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiRyakusho() != null) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui13()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiRyakusho());
            builder.append(読点);
        }
        if (dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui14()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiRyakusho() != null) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui14()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiRyakusho());
            builder.append(読点);
        }
        return get種類略称(hihoken, builder).toRString();
    }

    private RStringBuilder get種類略称(HihokenshashoChohyoParameter hihoken, RStringBuilder builder) {
        if (dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui15()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiRyakusho() != null) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui15()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiRyakusho());
            builder.append(読点);
        }
        if (dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui16()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiRyakusho() != null) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui16()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiRyakusho());
            builder.append(読点);
        }
        if (dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui17()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiRyakusho() != null) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui17()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiRyakusho());
            builder.append(読点);
        }
        if (dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui18()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiRyakusho() != null) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui18()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiRyakusho());
            builder.append(読点);
        }
        if (dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui19()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiRyakusho() != null) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui19()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiRyakusho());
            builder.append(読点);
        }
        if (dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui20()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiRyakusho() != null) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui20()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiRyakusho());
            builder.append(読点);
        }
        if (dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui21()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiRyakusho() != null) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui21()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiRyakusho());
            builder.append(読点);
        }
        if (dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui22()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiRyakusho() != null) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui22()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiRyakusho());
            builder.append(読点);
        }
        if (dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui23()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiRyakusho() != null) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui23()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiRyakusho());
            builder.append(読点);
        }
        if (dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui24()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiRyakusho() != null) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui24()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiRyakusho());
            builder.append(読点);
        }
        if (dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui25()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiRyakusho() != null) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui25()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiRyakusho());
            builder.append(読点);
        }
        if (dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui26()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiRyakusho() != null) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui26()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiRyakusho());
            builder.append(読点);
        }
        if (dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui27()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiRyakusho() != null) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui27()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiRyakusho());
            builder.append(読点);
        }
        if (dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui28()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiRyakusho() != null) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui28()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiRyakusho());
            builder.append(読点);
        }
        if (dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui29()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiRyakusho() != null) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui29()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiRyakusho());
            builder.append(読点);
        }
        if (dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui30()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiRyakusho() != null) {
            builder.append(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui30()),
                    hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                    .getServiceShuruiRyakusho());
        }
        return builder;
    }

    private void getサービス種類(HihokenshashoChohyoBusiness entity, HihokenshashoChohyoParameter hihoken) {
        entity.setShurui1(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui01()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiMeisho());
        entity.setShurui2(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui02()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiMeisho());
        entity.setShurui3(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui03()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiMeisho());
        entity.setShurui4(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui04()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiMeisho());
        entity.setShurui5(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui05()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiMeisho());
        entity.setShurui6(dbt7130Dac.select種類名称(new ServiceShuruiCode(hihoken.getShiteiServiceShurui06()),
                hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken.getNinteiYukoKikanShuryoYMD().getYearMonth())
                .getServiceShuruiMeisho());
        if (dbt7111Dac.select支給限度単位数(new ServiceShuruiCode(hihoken
                .getShiteiServiceShurui01()), hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken
                .getNinteiYukoKikanShuryoYMD().getYearMonth()).getShikyuGendoTaniSu() != null) {
            entity.setShuruigendo1(new RString(String.valueOf(dbt7111Dac.select支給限度単位数(new ServiceShuruiCode(hihoken
                    .getShiteiServiceShurui01()), hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken
                    .getNinteiYukoKikanShuryoYMD().getYearMonth()).getShikyuGendoTaniSu())));
            entity.setTen1(単位);
        }
        if (dbt7111Dac.select支給限度単位数(new ServiceShuruiCode(hihoken
                .getShiteiServiceShurui02()), hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken
                .getNinteiYukoKikanShuryoYMD().getYearMonth()).getShikyuGendoTaniSu() != null) {
            entity.setShuruigendo2(new RString(String.valueOf(dbt7111Dac.select支給限度単位数(new ServiceShuruiCode(hihoken
                    .getShiteiServiceShurui02()), hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken
                    .getNinteiYukoKikanShuryoYMD().getYearMonth()).getShikyuGendoTaniSu())));
            entity.setTen2(単位);
        }
        if (dbt7111Dac.select支給限度単位数(new ServiceShuruiCode(hihoken
                .getShiteiServiceShurui03()), hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken
                .getNinteiYukoKikanShuryoYMD().getYearMonth()).getShikyuGendoTaniSu() != null) {
            entity.setShuruigendo3(new RString(String.valueOf(dbt7111Dac.select支給限度単位数(new ServiceShuruiCode(hihoken
                    .getShiteiServiceShurui03()), hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken
                    .getNinteiYukoKikanShuryoYMD().getYearMonth()).getShikyuGendoTaniSu())));
            entity.setTen3(単位);
        }
        if (dbt7111Dac.select支給限度単位数(new ServiceShuruiCode(hihoken
                .getShiteiServiceShurui04()), hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken
                .getNinteiYukoKikanShuryoYMD().getYearMonth()).getShikyuGendoTaniSu() != null) {
            entity.setShuruigendo4(new RString(String.valueOf(dbt7111Dac.select支給限度単位数(new ServiceShuruiCode(hihoken
                    .getShiteiServiceShurui04()), hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken
                    .getNinteiYukoKikanShuryoYMD().getYearMonth()).getShikyuGendoTaniSu())));
            entity.setTen4(単位);
        }
        if (dbt7111Dac.select支給限度単位数(new ServiceShuruiCode(hihoken
                .getShiteiServiceShurui05()), hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken
                .getNinteiYukoKikanShuryoYMD().getYearMonth()).getShikyuGendoTaniSu() != null) {
            entity.setShuruigendo5(new RString(String.valueOf(dbt7111Dac.select支給限度単位数(new ServiceShuruiCode(hihoken
                    .getShiteiServiceShurui05()), hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken
                    .getNinteiYukoKikanShuryoYMD().getYearMonth()).getShikyuGendoTaniSu())));
            entity.setTen5(単位);
        }
        if (dbt7111Dac.select支給限度単位数(new ServiceShuruiCode(hihoken
                .getShiteiServiceShurui06()), hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken
                .getNinteiYukoKikanShuryoYMD().getYearMonth()).getShikyuGendoTaniSu() != null) {
            entity.setShuruigendo6(new RString(String.valueOf(dbt7111Dac.select支給限度単位数(new ServiceShuruiCode(hihoken
                    .getShiteiServiceShurui06()), hihoken.getNinteiYukoKikanKaishiYMD().getYearMonth(), hihoken
                    .getNinteiYukoKikanShuryoYMD().getYearMonth()).getShikyuGendoTaniSu())));
            entity.setTen6(単位);
        }
    }
}
