/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.honnsanteifuka;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_IdoKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.honnsanteifuka.HonnsanteiFukaMybatisParamter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3116KijunShunyugakuTekiyoKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.honnsanteifuka.IdouChuukannKihonSofuTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.honnsanteifuka.IdouChuukannKooGakuTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.honnsanteifuka.IdouChuukannShouKannTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.honnsanteifuka.IdouSofuListTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.honnsanteifuka.JukyushaDaichoRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.honnsanteifuka.KyodoShoriKihonSofuTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.honnsanteifuka.KyodoShoriKooGakuTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.honnsanteifuka.KyodoShoriShouKannTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.honnsanteifuka.ShotaiinHaakuIttokiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.setaiyin.SetaiYinEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3116KijunShunyugakuTekiyoKanriDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.honnsanteifuka.IHonnSanteiFukaMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbc.service.report.jukyushaidorenrakuhyooutcsv.JukyushaIdoRenrakuhyoOutCSV;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7055GappeiJohoEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7055GappeiJohoDac;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1006KyokaisoGaitoshaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1006KyokaisoGaitoshaDac;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 共同処理用受給者異動連絡票情報編集のビジネスです。
 *
 * @reamsid_L DBC-2770-050 zhangzhiming
 */
public class HonnSanteiFukaManager {

    private final MapperProvider mapperProvider;
    private final IHonnSanteiFukaMapper mapper;
    private final DbT7055GappeiJohoDac 合併情報Dac;
    private final DbT1006KyokaisoGaitoshaDac dbT1006Dac;
    private final DbT3116KijunShunyugakuTekiyoKanriDac dbT3116Dac;
    private static final RString 区分_0 = new RString("0");
    private static final RString 区分_1 = new RString("1");
    private static final RString 区分_2 = new RString("2");
    private static final RString 区分_3 = new RString("3");
    private static final RString 区分_4 = new RString("4");
    private static final RString 区分_8 = new RString("8");
    private static final RString 区分_9 = new RString("9");
    private static final RString 区分_01 = new RString("01");
    private static final RString 区分_04 = new RString("04");
    private static final RString 区分_99 = new RString("99");
    private static final Decimal 算定基準額_44400 = new Decimal(44400);
    private static final Decimal 算定基準額_37200 = new Decimal(37200);
    private static final Decimal 算定基準額_1450000 = new Decimal(1450000);
    private static final int 月分_6 = 6;
    private static final int 月分_7 = 7;
    private static final int 月分_8 = 8;
    private static final int 収入額 = 800000;
    private static final Decimal 上限額_2 = new Decimal(15000);
    private static final Decimal 上限額_1 = new Decimal(24600);
    private static final FlexibleDate 異動年月日 = new FlexibleDate("20150501");
    private static final RString 証記載保険者番号 = new RString("証記載保険者番号");
    private static final RString 被保険者氏名 = new RString("被保険者氏名");
    private static final RString 郵便番号 = new RString("郵便番号");
    private static final RString 住所カナ = new RString("住所カナ");
    private static final RString 住所 = new RString("住所");
    private static final RString 電話番号 = new RString("電話番号");
    private static final RString 被保険者番号 = new RString("被保険者番号");
    private static final RString 保険給付支払一時差止開始年月日 = new RString("保険給付支払一時差止開始年月日");
    private static final RString 保険給付支払一時差止終了年月日 = new RString("保険給付支払一時差止終了年月日");
    private static final RString 保険給付支払一時差止区分コード = new RString("保険給付支払一時差止区分コード");
    private static final RString 保険給付支払一時差止金額 = new RString("保険給付支払一時差止金額");
    private static final RString 世帯集約番号 = new RString("世帯集約番号");
    private static final RString 世帯所得区分コード = new RString("世帯所得区分コード");
    private static final RString 所得区分コード = new RString("所得区分コード");
    private static final RString 老齢福祉年金受給有フラグ = new RString("老齢福祉年金受給有フラグ");
    private static final RString 利用者負担第２段階有フラグ = new RString("利用者負担第２段階有フラグ");

    /**
     * 共同処理用受給者異動連絡票情報編集のコンストラクタ。
     *
     */
    public HonnSanteiFukaManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.mapper = mapperProvider.create(IHonnSanteiFukaMapper.class);
        this.合併情報Dac = InstanceProvider.create(DbT7055GappeiJohoDac.class);
        this.dbT1006Dac = InstanceProvider.create(DbT1006KyokaisoGaitoshaDac.class);
        this.dbT3116Dac = InstanceProvider.create(DbT3116KijunShunyugakuTekiyoKanriDac.class);
    }

    /**
     * 共同処理用受給者異動連絡票情報編集のコンストラクタ。
     *
     * @return HonnSanteiFukaManager
     */
    public static HonnSanteiFukaManager createInstance() {
        return InstanceProvider.create(HonnSanteiFukaManager.class);
    }

    /**
     * 受給者台帳情報の情報編集。
     *
     * @param 処理対象年月 処理対象年月
     * @param 合併区分 合併区分
     * @return 異動日毎データ抽出
     */
    public List<IdouChuukannKihonSofuTempEntity> set異動中間基本送付(RString 処理対象年月, RString 合併区分) {
        List<IdouChuukannKihonSofuTempEntity> kihonSofuTempEntity = new ArrayList<>();
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        HonnsanteiFukaMybatisParamter sqlParam
                = HonnsanteiFukaMybatisParamter.createParam(処理対象年月,
                        new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()));
        List<JukyushaDaichoRelateEntity> 受給者台帳情報リスト = mapper.select受給者台帳情報(sqlParam);
        List<DbT1001HihokenshaDaichoEntity> 被保険者台帳情報リスト = mapper.select被保険者台帳情報(sqlParam);
        List<JukyushaDaichoRelateEntity> 受給者台帳情報List = get受給者台帳情報リスト(受給者台帳情報リスト);
        List<DbT1001HihokenshaDaichoEntity> 被保険者台帳情報List = get被保険者台帳情報リスト(被保険者台帳情報リスト);
        int 連番 = 1;
        kihonSofuTempEntity.addAll(set最古の異動情報作成(被保険者台帳情報リスト, 受給者台帳情報List, 連番, 処理対象年月));
        List<FlexibleYearMonth> 異動日リスト = new ArrayList<>();
        for (IdouChuukannKihonSofuTempEntity kihonEntity : kihonSofuTempEntity) {
            異動日リスト.add(kihonEntity.get異動年月日().getYearMonth());
        }
        if (!異動日リスト.contains(new FlexibleYearMonth(処理対象年月).minusMonth(1))) {
            kihonSofuTempEntity.addAll(set最新の異動情報作成(被保険者台帳情報List, 受給者台帳情報リスト, 連番, 処理対象年月));
        }
        if (区分_1.equals(合併区分)) {
            kihonSofuTempEntity.addAll(set合併異動情報作成(被保険者台帳情報List, 受給者台帳情報リスト, 連番, 異動日リスト, 処理対象年月));
        }
        return kihonSofuTempEntity;
    }

    private List<IdouChuukannKihonSofuTempEntity> set合併異動情報作成(List<DbT1001HihokenshaDaichoEntity> 被保険者台帳情報List,
            List<JukyushaDaichoRelateEntity> 受給者台帳情報List, int 連番, List<FlexibleYearMonth> 異動日リスト, RString 処理対象年月) {
        List<IdouChuukannKihonSofuTempEntity> kihonSofuTempEntity = new ArrayList<>();
        List<DbT7055GappeiJohoEntity> 合併情報リスト = 合併情報Dac.selectGappeiYMD();
        List<DbT1001HihokenshaDaichoEntity> 合併被保険者台帳リスト = new ArrayList<>();
        List<JukyushaDaichoRelateEntity> 合併受給者台帳リスト = new ArrayList<>();
        for (DbT7055GappeiJohoEntity 合併情報 : 合併情報リスト) {
            if (!異動日リスト.contains(合併情報.getGappeiYMD().getYearMonth())) {
                for (DbT1001HihokenshaDaichoEntity 被保険者台帳情報 : 被保険者台帳情報List) {
                    List<DbT1001HihokenshaDaichoEntity> 被保険者台帳 = new ArrayList<>();
                    if (被保険者台帳情報.getIdoYMD().isBefore(合併情報.getGappeiYMD())) {
                        被保険者台帳.add(被保険者台帳情報);
                    }
                    Collections.sort(被保険者台帳, new Comparator<DbT1001HihokenshaDaichoEntity>() {
                        @Override
                        public int compare(DbT1001HihokenshaDaichoEntity entity1, DbT1001HihokenshaDaichoEntity entity2) {
                            FlexibleDate str1 = entity1.getIdoYMD();
                            FlexibleDate str2 = entity2.getIdoYMD();
                            return str2.compareTo(str1);
                        }
                    });
                    if (get合併被保険者台帳(合併情報, 被保険者台帳) != null) {
                        合併被保険者台帳リスト.add(get合併被保険者台帳(合併情報, 被保険者台帳));
                    }
                }
                if (get受給者台帳合併情報作成(合併情報, 受給者台帳情報List) != null) {
                    合併受給者台帳リスト.add(get受給者台帳合併情報作成(合併情報, 受給者台帳情報List));
                }
                for (DbT1001HihokenshaDaichoEntity 合併被保険者台帳 : 合併被保険者台帳リスト) {
                    for (JukyushaDaichoRelateEntity 合併受給者台帳 : 合併受給者台帳リスト) {
                        if (合併被保険者台帳.getHihokenshaNo().equals(合併受給者台帳.get受給者台帳Entity().getHihokenshaNo())) {
                            kihonSofuTempEntity.add(set合併異動情報(合併受給者台帳, 合併被保険者台帳, 連番,
                                    処理対象年月, 合併情報.getGappeiYMD().getYearMonth()));
                        }
                    }
                }
            }
        }
        return kihonSofuTempEntity;
    }

    private DbT1001HihokenshaDaichoEntity get合併被保険者台帳(DbT7055GappeiJohoEntity 合併情報,
            List<DbT1001HihokenshaDaichoEntity> 被保険者台帳) {
        if (!被保険者台帳.isEmpty()) {
            FlexibleDate 資格取得年月日 = 被保険者台帳.get(0).getShikakuShutokuYMD();
            FlexibleDate 資格喪失年月日 = 被保険者台帳.get(0).getShikakuSoshitsuYMD();
            if (資格取得年月日 == null || 資格取得年月日.isEmpty()) {
                資格取得年月日 = FlexibleDate.MIN;
            }
            if (資格喪失年月日 != null && !資格喪失年月日.isEmpty()
                    && 資格取得年月日.isBefore(合併情報.getGappeiYMD())
                    && 合併情報.getGappeiYMD().isBeforeOrEquals(資格喪失年月日)
                    && 合併情報.getShichosonCode().equals(被保険者台帳.get(0).getShichosonCode())) {
                return 被保険者台帳.get(0);
            } else if ((資格喪失年月日 == null || 資格喪失年月日.isEmpty()) && 資格取得年月日.isBefore(合併情報.getGappeiYMD())
                    && 合併情報.getShichosonCode().equals(被保険者台帳.get(0).getShichosonCode())) {
                return 被保険者台帳.get(0);
            }
        }
        return null;
    }

    private JukyushaDaichoRelateEntity get受給者台帳合併情報作成(DbT7055GappeiJohoEntity 合併情報,
            List<JukyushaDaichoRelateEntity> 受給者台帳情報List) {
        for (JukyushaDaichoRelateEntity 受給者台帳情報 : 受給者台帳情報List) {
            FlexibleDate 認定開始日 = 受給者台帳情報.get受給者台帳Entity().getNinteiYukoKikanKaishiYMD();
            FlexibleDate 認定終了日 = 受給者台帳情報.get受給者台帳Entity().getNinteiYukoKikanShuryoYMD();
            if (認定開始日 == null || 認定開始日.isEmpty()) {
                認定開始日 = FlexibleDate.MIN;
            }
            if (認定終了日 != null && !認定終了日.isEmpty() && 認定開始日.isBefore(合併情報.getGappeiYMD())
                    && 合併情報.getGappeiYMD().isBeforeOrEquals(認定終了日)) {
                return 受給者台帳情報;
            } else if ((認定終了日 == null || 認定終了日.isEmpty()) && 認定開始日.isBefore(合併情報.getGappeiYMD())) {
                return 受給者台帳情報;
            }
        }
        return null;
    }

    private IdouChuukannKihonSofuTempEntity set合併異動情報(JukyushaDaichoRelateEntity 被保険者番号,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, int 連番, RString 処理対象年月, FlexibleYearMonth 異動年月日) {
        IdouChuukannKihonSofuTempEntity chuukannKihon = setKihonSofuEntity(被保険者番号, 被保険者台帳, 連番, 処理対象年月);
        RStringBuilder 月初 = new RStringBuilder();
        月初.append(異動年月日);
        月初.append(区分_01);
        chuukannKihon.set異動年月日(new FlexibleDate(月初.toRString()));
        chuukannKihon.set異動区分コード(区分_1);
        chuukannKihon.set受給者異動事由(区分_04);
        return chuukannKihon;
    }

    private List<IdouChuukannKihonSofuTempEntity> set最古の異動情報作成(List<DbT1001HihokenshaDaichoEntity> 被保険者台帳情報リスト,
            List<JukyushaDaichoRelateEntity> 被保険者番号リスト, int 連番, RString 処理対象年月) {
        List<IdouChuukannKihonSofuTempEntity> kihonSofuTempEntity = new ArrayList<>();
        for (JukyushaDaichoRelateEntity 被保険者番号Entity : 被保険者番号リスト) {
            for (DbT1001HihokenshaDaichoEntity 被保険者台帳 : 被保険者台帳情報リスト) {
                if (被保険者番号Entity.get受給者台帳Entity().getHihokenshaNo().equals(被保険者台帳.getHihokenshaNo())) {
                    FlexibleDate 資格取得年月日 = 被保険者台帳.getShikakuShutokuYMD();
                    FlexibleDate 資格喪失年月日 = 被保険者台帳.getShikakuSoshitsuYMD();
                    FlexibleDate 認定有効期間開始年月日 = 被保険者番号Entity.get受給者台帳Entity().getNinteiYukoKikanKaishiYMD();
                    if (資格取得年月日 == null || 資格取得年月日.isEmpty()) {
                        資格取得年月日 = FlexibleDate.MIN;
                    }
                    if (認定有効期間開始年月日 == null || 認定有効期間開始年月日.isEmpty()) {
                        continue;
                    } else if (資格喪失年月日 != null && !資格喪失年月日.isEmpty()
                            && 資格取得年月日.isBeforeOrEquals(認定有効期間開始年月日)
                            && !資格喪失年月日.isBefore(認定有効期間開始年月日)) {
                        kihonSofuTempEntity.add(set古異動情報(被保険者番号Entity, 被保険者台帳, 連番, 処理対象年月));
                    } else if ((資格喪失年月日 == null || 資格喪失年月日.isEmpty())
                            && 資格取得年月日.isBeforeOrEquals(認定有効期間開始年月日)) {
                        kihonSofuTempEntity.add(set古異動情報(被保険者番号Entity, 被保険者台帳, 連番, 処理対象年月));
                    }
                    連番 = 連番 + 1;
                }
            }
        }
        return kihonSofuTempEntity;
    }

    private List<IdouChuukannKihonSofuTempEntity> set最新の異動情報作成(List<DbT1001HihokenshaDaichoEntity> 異動情報リスト,
            List<JukyushaDaichoRelateEntity> 受給者台帳情報リスト, int 連番, RString 処理対象年月) {
        List<IdouChuukannKihonSofuTempEntity> kihonSofuTempEntity = new ArrayList<>();
        for (DbT1001HihokenshaDaichoEntity 異動情報 : 異動情報リスト) {
            FlexibleDate 資格喪失年月日 = 異動情報.getShikakuSoshitsuYMD();
            FlexibleYearMonth 資格取得年月日 = FlexibleYearMonth.MIN;
            FlexibleDate 取得年月日 = 異動情報.getShikakuShutokuYMD();
            FlexibleYearMonth 対象年月 = new FlexibleYearMonth(処理対象年月);
            if (取得年月日 != null && !取得年月日.isEmpty()) {
                資格取得年月日 = 取得年月日.getYearMonth();
            }
            if (資格喪失年月日 != null && !資格喪失年月日.isEmpty() && 資格取得年月日.isBefore(対象年月)
                    && 対象年月.isBeforeOrEquals(資格喪失年月日.getYearMonth())) {
                for (JukyushaDaichoRelateEntity 受給者台帳情報 : 受給者台帳情報リスト) {
                    if (異動情報.getHihokenshaNo().equals(受給者台帳情報.get受給者台帳Entity().getHihokenshaNo())) {
                        kihonSofuTempEntity.add(set新異動情報(受給者台帳情報, 異動情報, 連番, 処理対象年月));
                    }
                }
            } else if ((資格喪失年月日 == null || 資格喪失年月日.isEmpty()) && 資格取得年月日.isBefore(対象年月)) {
                for (JukyushaDaichoRelateEntity 受給者台帳情報 : 受給者台帳情報リスト) {
                    if (異動情報.getHihokenshaNo().equals(受給者台帳情報.get受給者台帳Entity().getHihokenshaNo())) {
                        kihonSofuTempEntity.add(set新異動情報(受給者台帳情報, 異動情報, 連番, 処理対象年月));
                    }
                }
            }
        }
        return kihonSofuTempEntity;
    }

    private IdouChuukannKihonSofuTempEntity set新異動情報(JukyushaDaichoRelateEntity 被保険者番号,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, int 連番, RString 処理対象年月) {
        IdouChuukannKihonSofuTempEntity chuukannKihon = setKihonSofuEntity(被保険者番号, 被保険者台帳, 連番, 処理対象年月);
        FlexibleYearMonth 異動年月 = new FlexibleYearMonth(処理対象年月);
        RStringBuilder 月初 = new RStringBuilder();
        月初.append(異動年月.minusMonth(1));
        月初.append(区分_01);
        chuukannKihon.set異動年月日(new FlexibleDate(月初.toRString()));
        chuukannKihon.set異動区分コード(区分_2);
        chuukannKihon.set受給者異動事由(区分_99);
        return chuukannKihon;
    }

    private IdouChuukannKihonSofuTempEntity set古異動情報(JukyushaDaichoRelateEntity 被保険者番号,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, int 連番, RString 処理対象年月) {
        IdouChuukannKihonSofuTempEntity chuukannKihon = setKihonSofuEntity(被保険者番号, 被保険者台帳, 連番, 処理対象年月);
        FlexibleDate 認定有効期間開始年月日 = 被保険者番号.get受給者台帳Entity().getNinteiYukoKikanKaishiYMD();
        if (認定有効期間開始年月日 != null && !認定有効期間開始年月日.isEmpty()) {
            RStringBuilder 月初 = new RStringBuilder();
            月初.append(認定有効期間開始年月日.getYearMonth());
            月初.append(区分_01);
            chuukannKihon.set異動年月日(new FlexibleDate(月初.toRString()));
        }
        chuukannKihon.set異動区分コード(区分_1);
        chuukannKihon.set受給者異動事由(区分_01);
        return chuukannKihon;
    }

    private IdouChuukannKihonSofuTempEntity setKihonSofuEntity(JukyushaDaichoRelateEntity 被保険者番号,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, int 連番, RString 処理対象年月) {
        IdouChuukannKihonSofuTempEntity chuukannKihon = new IdouChuukannKihonSofuTempEntity();
        chuukannKihon.set証記載保険者番号(ShoKisaiHokenshaNo.EMPTY);
        chuukannKihon.set被保険者番号(被保険者番号.get受給者台帳Entity().getHihokenshaNo());
        chuukannKihon.set履歴番号(連番);
        AtenaMeisho 保険者氏名 = 被保険者番号.get宛名Entity().getMeisho();
        if (保険者氏名 != null) {
            chuukannKihon.set被保険者氏名(保険者氏名.value());
        }
        chuukannKihon.set郵便番号(被保険者番号.get宛名Entity().getYubinNo());
        RStringBuilder 住所の編集 = new RStringBuilder();
        AtenaJusho 住所地 = 被保険者番号.get宛名Entity().getJusho();
        AtenaBanchi 番地 = 被保険者番号.get宛名Entity().getBanchi();
        Katagaki 方書 = 被保険者番号.get宛名Entity().getKatagaki();
        if (住所地 != null) {
            住所の編集.append(住所地);
        }
        if (番地 != null) {
            住所の編集.append(番地);
        }
        if (方書 != null) {
            住所の編集.append(new RString("△"));
            住所の編集.append(方書);
        }
        chuukannKihon.set住所(住所の編集.toRString());
        chuukannKihon.set電話番号(被保険者番号.get宛名Entity().getRenrakusaki1());
        chuukannKihon.set送付年月(new FlexibleYearMonth(処理対象年月));
        chuukannKihon.set市町村コード(被保険者台帳.getShichosonCode());
        chuukannKihon.set資格取得年月日(被保険者台帳.getShikakuShutokuYMD());
        chuukannKihon.set資格喪失年月日(被保険者台帳.getShikakuSoshitsuYMD());
        chuukannKihon.set認定有効期間開始年月日(被保険者番号.get受給者台帳Entity().getNinteiYukoKikanKaishiYMD());
        chuukannKihon.set認定有効期間終了年月日(被保険者番号.get受給者台帳Entity().getNinteiYukoKikanShuryoYMD());
        chuukannKihon.set論理削除フラグ(false);
        chuukannKihon.set住所地特例フラグ(被保険者台帳.getJushochiTokureiFlag());
        chuukannKihon.set住所カナ(RString.EMPTY);
        chuukannKihon.set訂正区分コード(RString.EMPTY);
        chuukannKihon.set訂正年月日(FlexibleDate.EMPTY);
        return chuukannKihon;
    }

    /**
     * 証記載保険者番号と市町村名の情報編集。
     *
     * @return 証記載保険者番号と市町村名
     */
    public List<RString> get証記載保険者番号と市町村名() {
        RString 証記載番号 = RString.EMPTY;
        RString 市町村名 = RString.EMPTY;
        List<RString> 証記載保険者番号と市町村名 = new ArrayList<>();
        ShichosonSecurityJoho 構成市町村情報取得 = ShichosonSecurityJohoFinder.createInstance().getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (構成市町村情報取得 != null && 構成市町村情報取得.get導入形態コード().is単一()) {
            証記載番号 = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
            市町村名 = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者名称, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        }
        if (構成市町村情報取得 != null && 構成市町村情報取得.get導入形態コード().is広域()) {
            DbT7051KoseiShichosonMasterEntity 構成市町村Entity = mapper.select構成市町村情報();
            if (構成市町村Entity != null) {
                証記載番号 = 構成市町村Entity.getShoKisaiHokenshaNo().value();
                市町村名 = 構成市町村Entity.getShichosonMeisho();
            }
        }
        証記載保険者番号と市町村名.add(証記載番号);
        証記載保険者番号と市町村名.add(市町村名);
        return 証記載保険者番号と市町村名;
    }

    private List<JukyushaDaichoRelateEntity> get受給者台帳情報リスト(List<JukyushaDaichoRelateEntity> 受給者台帳情報リスト) {
        Map<RString, List<JukyushaDaichoRelateEntity>> data_map = new HashMap<>();
        for (JukyushaDaichoRelateEntity entity : 受給者台帳情報リスト) {
            if (data_map.containsKey(entity.get受給者台帳Entity().getHihokenshaNo().value())) {
                List<JukyushaDaichoRelateEntity> map = data_map.get(entity.get受給者台帳Entity().getHihokenshaNo().value());
                map.add(entity);
            } else {
                List<JukyushaDaichoRelateEntity> map = new ArrayList<>();
                map.add(entity);
                data_map.put(entity.get受給者台帳Entity().getHihokenshaNo().value(), map);
            }
        }
        List<JukyushaDaichoRelateEntity> 受給者台帳リスト = new ArrayList<>();
        for (List<JukyushaDaichoRelateEntity> keys : data_map.values()) {
            受給者台帳リスト.add(keys.get(0));
        }
        return 受給者台帳リスト;
    }

    private List<DbT1001HihokenshaDaichoEntity> get被保険者台帳情報リスト(List<DbT1001HihokenshaDaichoEntity> 被保険者台帳情報リスト) {
        Map<RString, List<DbT1001HihokenshaDaichoEntity>> data_map1 = new HashMap<>();
        for (DbT1001HihokenshaDaichoEntity entity : 被保険者台帳情報リスト) {
            if (data_map1.containsKey(entity.getHihokenshaNo().value())) {
                List<DbT1001HihokenshaDaichoEntity> map = data_map1.get(entity.getHihokenshaNo().value());
                map.add(entity);
            } else {
                List<DbT1001HihokenshaDaichoEntity> map = new ArrayList<>();
                map.add(entity);
                data_map1.put(entity.getHihokenshaNo().value(), map);
            }
        }
        List<DbT1001HihokenshaDaichoEntity> 異動情報リスト = new ArrayList<>();
        for (List<DbT1001HihokenshaDaichoEntity> keys : data_map1.values()) {
            異動情報リスト.add(keys.get(0));
        }
        return 異動情報リスト;
    }

    /**
     * 償還受給者台帳情報の情報編集。
     *
     * @param 処理対象年月 処理対象年月
     * @param 合併区分 合併区分
     * @return 異動日毎データ抽出
     */
    public List<IdouChuukannShouKannTempEntity> set異動中間償還送付(RString 処理対象年月, RString 合併区分) {
        List<IdouChuukannShouKannTempEntity> shouKannTempEntity = new ArrayList<>();
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        HonnsanteiFukaMybatisParamter sqlParam
                = HonnsanteiFukaMybatisParamter.createParam(処理対象年月,
                        new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()));
        List<JukyushaDaichoRelateEntity> 受給者台帳情報リスト = mapper.select受給者台帳情報(sqlParam);
        List<DbT1001HihokenshaDaichoEntity> 被保険者台帳情報リスト = mapper.select被保険者台帳情報(sqlParam);
        List<JukyushaDaichoRelateEntity> 受給者台帳情報List = get受給者台帳情報リスト(受給者台帳情報リスト);
        List<DbT1001HihokenshaDaichoEntity> 被保険者台帳情報List = get被保険者台帳情報リスト(被保険者台帳情報リスト);
        int 連番 = 1;
        shouKannTempEntity.addAll(set最古の償還異動情報作成(被保険者台帳情報リスト, 受給者台帳情報List, 連番, 処理対象年月));
        List<FlexibleYearMonth> 異動日リスト = new ArrayList<>();
        for (IdouChuukannShouKannTempEntity kihonEntity : shouKannTempEntity) {
            異動日リスト.add(kihonEntity.get異動年月日().getYearMonth());
        }
        if (!異動日リスト.contains(new FlexibleYearMonth(処理対象年月).minusMonth(1))) {
            shouKannTempEntity.addAll(set最新の償還異動情報作成(被保険者台帳情報List, 受給者台帳情報リスト, 連番, 処理対象年月));
        }
        if (区分_1.equals(合併区分)) {
            shouKannTempEntity.addAll(set償還合併異動情報作成(被保険者台帳情報List, 受給者台帳情報リスト, 連番, 異動日リスト, 処理対象年月));
        }
        return shouKannTempEntity;
    }

    private List<IdouChuukannShouKannTempEntity> set最古の償還異動情報作成(List<DbT1001HihokenshaDaichoEntity> 被保険者台帳情報リスト,
            List<JukyushaDaichoRelateEntity> 被保険者番号リスト, int 連番, RString 処理対象年月) {
        List<IdouChuukannShouKannTempEntity> shouKannTempEntity = new ArrayList<>();
        for (JukyushaDaichoRelateEntity 被保険者番号Entity : 被保険者番号リスト) {
            for (DbT1001HihokenshaDaichoEntity 被保険者台帳 : 被保険者台帳情報リスト) {
                if (被保険者番号Entity.get受給者台帳Entity().getHihokenshaNo().equals(被保険者台帳.getHihokenshaNo())) {
                    FlexibleDate 資格取得年月日 = 被保険者台帳.getShikakuShutokuYMD();
                    FlexibleDate 資格喪失年月日 = 被保険者台帳.getShikakuSoshitsuYMD();
                    FlexibleDate 認定有効期間開始年月日 = 被保険者番号Entity.get受給者台帳Entity().getNinteiYukoKikanKaishiYMD();
                    if (資格取得年月日 == null || 資格取得年月日.isEmpty()) {
                        資格取得年月日 = FlexibleDate.MIN;
                    }
                    if (認定有効期間開始年月日 == null || 認定有効期間開始年月日.isEmpty()) {
                        continue;
                    } else if (資格喪失年月日 != null && !資格喪失年月日.isEmpty()
                            && 資格取得年月日.isBeforeOrEquals(認定有効期間開始年月日)
                            && !資格喪失年月日.isBefore(認定有効期間開始年月日)) {
                        shouKannTempEntity.add(set償還古異動情報(被保険者番号Entity, 被保険者台帳, 連番, 処理対象年月));
                    } else if ((資格喪失年月日 == null || 資格喪失年月日.isEmpty())
                            && 資格取得年月日.isBeforeOrEquals(認定有効期間開始年月日)) {
                        shouKannTempEntity.add(set償還古異動情報(被保険者番号Entity, 被保険者台帳, 連番, 処理対象年月));
                    }
                    連番 = 連番 + 1;
                }
            }
        }
        return shouKannTempEntity;
    }

    private List<IdouChuukannShouKannTempEntity> set最新の償還異動情報作成(List<DbT1001HihokenshaDaichoEntity> 異動情報リスト,
            List<JukyushaDaichoRelateEntity> 受給者台帳情報リスト, int 連番, RString 処理対象年月) {
        List<IdouChuukannShouKannTempEntity> shouKannTempEntity = new ArrayList<>();
        for (DbT1001HihokenshaDaichoEntity 異動情報 : 異動情報リスト) {
            FlexibleDate 資格喪失年月日 = 異動情報.getShikakuSoshitsuYMD();
            FlexibleYearMonth 資格取得年月日 = FlexibleYearMonth.MIN;
            FlexibleDate 取得年月日 = 異動情報.getShikakuShutokuYMD();
            FlexibleYearMonth 対象年月 = new FlexibleYearMonth(処理対象年月);
            if (取得年月日 != null && !取得年月日.isEmpty()) {
                資格取得年月日 = 取得年月日.getYearMonth();
            }
            if (資格喪失年月日 != null && !資格喪失年月日.isEmpty() && 資格取得年月日.isBefore(対象年月)
                    && 対象年月.isBeforeOrEquals(資格喪失年月日.getYearMonth())) {
                for (JukyushaDaichoRelateEntity 受給者台帳情報 : 受給者台帳情報リスト) {
                    if (異動情報.getHihokenshaNo().equals(受給者台帳情報.get受給者台帳Entity().getHihokenshaNo())) {
                        shouKannTempEntity.add(set償還新異動情報(受給者台帳情報, 異動情報, 連番, 処理対象年月));
                    }
                }
            } else if ((資格喪失年月日 == null || 資格喪失年月日.isEmpty()) && 資格取得年月日.isBefore(対象年月)) {
                for (JukyushaDaichoRelateEntity 受給者台帳情報 : 受給者台帳情報リスト) {
                    if (異動情報.getHihokenshaNo().equals(受給者台帳情報.get受給者台帳Entity().getHihokenshaNo())) {
                        shouKannTempEntity.add(set償還新異動情報(受給者台帳情報, 異動情報, 連番, 処理対象年月));
                    }
                }
            }
        }
        return shouKannTempEntity;
    }

    private List<IdouChuukannShouKannTempEntity> set償還合併異動情報作成(List<DbT1001HihokenshaDaichoEntity> 被保険者台帳情報List,
            List<JukyushaDaichoRelateEntity> 受給者台帳情報List, int 連番, List<FlexibleYearMonth> 異動日リスト, RString 処理対象年月) {
        List<IdouChuukannShouKannTempEntity> shouKannTempEntity = new ArrayList<>();
        List<DbT7055GappeiJohoEntity> 合併情報リスト = 合併情報Dac.selectGappeiYMD();
        List<DbT1001HihokenshaDaichoEntity> 合併被保険者台帳リスト = new ArrayList<>();
        List<JukyushaDaichoRelateEntity> 合併受給者台帳リスト = new ArrayList<>();
        for (DbT7055GappeiJohoEntity 合併情報 : 合併情報リスト) {
            if (!異動日リスト.contains(合併情報.getGappeiYMD().getYearMonth())) {
                for (DbT1001HihokenshaDaichoEntity 被保険者台帳情報 : 被保険者台帳情報List) {
                    List<DbT1001HihokenshaDaichoEntity> 被保険者台帳 = new ArrayList<>();
                    if (被保険者台帳情報.getIdoYMD().isBefore(合併情報.getGappeiYMD())) {
                        被保険者台帳.add(被保険者台帳情報);
                    }
                    Collections.sort(被保険者台帳, new Comparator<DbT1001HihokenshaDaichoEntity>() {
                        @Override
                        public int compare(DbT1001HihokenshaDaichoEntity entity1, DbT1001HihokenshaDaichoEntity entity2) {
                            FlexibleDate str1 = entity1.getIdoYMD();
                            FlexibleDate str2 = entity2.getIdoYMD();
                            return str2.compareTo(str1);
                        }
                    });
                    if (get合併被保険者台帳(合併情報, 被保険者台帳) != null) {
                        合併被保険者台帳リスト.add(get合併被保険者台帳(合併情報, 被保険者台帳));
                    }
                }
                if (get受給者台帳合併情報作成(合併情報, 受給者台帳情報List) != null) {
                    合併受給者台帳リスト.add(get受給者台帳合併情報作成(合併情報, 受給者台帳情報List));
                }
                for (DbT1001HihokenshaDaichoEntity 合併被保険者台帳 : 合併被保険者台帳リスト) {
                    for (JukyushaDaichoRelateEntity 合併受給者台帳 : 合併受給者台帳リスト) {
                        if (合併被保険者台帳.getHihokenshaNo().equals(合併受給者台帳.get受給者台帳Entity().getHihokenshaNo())) {
                            shouKannTempEntity.add(set償還合併異動情報(合併受給者台帳, 合併被保険者台帳, 連番,
                                    処理対象年月, 合併情報.getGappeiYMD().getYearMonth()));
                        }
                    }
                }
            }
        }
        return shouKannTempEntity;
    }

    private IdouChuukannShouKannTempEntity set償還古異動情報(JukyushaDaichoRelateEntity 被保険者番号,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, int 連番, RString 処理対象年月) {
        IdouChuukannShouKannTempEntity chuukannKihon = setShouKannEntity(被保険者番号, 被保険者台帳, 連番, 処理対象年月);
        FlexibleDate 認定有効期間開始年月日 = 被保険者番号.get受給者台帳Entity().getNinteiYukoKikanKaishiYMD();
        if (認定有効期間開始年月日 != null && !認定有効期間開始年月日.isEmpty()) {
            RStringBuilder 月初 = new RStringBuilder();
            月初.append(認定有効期間開始年月日.getYearMonth());
            月初.append(区分_01);
            chuukannKihon.set異動年月日(new FlexibleDate(月初.toRString()));
        }
        chuukannKihon.set異動区分コード(区分_1);
        chuukannKihon.set受給者異動事由(区分_01);
        return chuukannKihon;
    }

    private IdouChuukannShouKannTempEntity setShouKannEntity(JukyushaDaichoRelateEntity 被保険者番号,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, int 連番, RString 処理対象年月) {
        IdouChuukannShouKannTempEntity chuukannKihon = new IdouChuukannShouKannTempEntity();
        chuukannKihon.set証記載保険者番号(ShoKisaiHokenshaNo.EMPTY);
        chuukannKihon.set被保険者番号(被保険者番号.get受給者台帳Entity().getHihokenshaNo());
        chuukannKihon.set履歴番号(連番);
        AtenaMeisho 保険者氏名 = 被保険者番号.get宛名Entity().getMeisho();
        if (保険者氏名 != null) {
            chuukannKihon.set被保険者氏名(保険者氏名.value());
        }
        chuukannKihon.set送付年月(new FlexibleYearMonth(処理対象年月));
        chuukannKihon.set市町村コード(被保険者台帳.getShichosonCode());
        chuukannKihon.set資格取得年月日(被保険者台帳.getShikakuShutokuYMD());
        chuukannKihon.set資格喪失年月日(被保険者台帳.getShikakuSoshitsuYMD());
        chuukannKihon.set差止決定年月日(被保険者番号.get受給者台帳Entity().getNinteiYukoKikanKaishiYMD());
        chuukannKihon.set差止解除年月日(被保険者番号.get受給者台帳Entity().getNinteiYukoKikanShuryoYMD());
        chuukannKihon.set論理削除フラグ(false);
        chuukannKihon.set保険給付支払一時差止開始年月日(FlexibleDate.EMPTY);
        chuukannKihon.set保険給付支払一時差止終了年月日(FlexibleDate.EMPTY);
        chuukannKihon.set保険給付支払一時差止区分コード(RString.EMPTY);
        chuukannKihon.set保険給付支払一時差止金額(Decimal.ZERO);
        chuukannKihon.set訂正区分コード(RString.EMPTY);
        chuukannKihon.set訂正年月日(FlexibleDate.EMPTY);
        return chuukannKihon;
    }

    private IdouChuukannShouKannTempEntity set償還新異動情報(JukyushaDaichoRelateEntity 被保険者番号,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, int 連番, RString 処理対象年月) {
        IdouChuukannShouKannTempEntity chuukannKihon = setShouKannEntity(被保険者番号, 被保険者台帳, 連番, 処理対象年月);
        FlexibleYearMonth 異動年月 = new FlexibleYearMonth(処理対象年月);
        RStringBuilder 月初 = new RStringBuilder();
        月初.append(異動年月.minusMonth(1));
        月初.append(区分_01);
        chuukannKihon.set異動年月日(new FlexibleDate(月初.toRString()));
        chuukannKihon.set異動区分コード(区分_2);
        chuukannKihon.set受給者異動事由(区分_99);
        return chuukannKihon;
    }

    private IdouChuukannShouKannTempEntity set償還合併異動情報(JukyushaDaichoRelateEntity 被保険者番号,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, int 連番, RString 処理対象年月, FlexibleYearMonth 異動年月日) {
        IdouChuukannShouKannTempEntity chuukannKihon = setShouKannEntity(被保険者番号, 被保険者台帳, 連番, 処理対象年月);
        RStringBuilder 月初 = new RStringBuilder();
        月初.append(異動年月日);
        月初.append(区分_01);
        chuukannKihon.set異動年月日(new FlexibleDate(月初.toRString()));
        chuukannKihon.set異動区分コード(区分_1);
        chuukannKihon.set受給者異動事由(区分_04);
        return chuukannKihon;
    }

    /**
     * 高額受給者台帳情報の情報編集。
     *
     * @param 処理対象年月 処理対象年月
     * @param 合併区分 合併区分
     * @return 異動日毎データ抽出
     */
    public List<IdouChuukannKooGakuTempEntity> set異動中間高額送付(RString 処理対象年月, RString 合併区分) {
        List<IdouChuukannKooGakuTempEntity> kooGakuTempEntity = new ArrayList<>();
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        HonnsanteiFukaMybatisParamter sqlParam
                = HonnsanteiFukaMybatisParamter.createParam(処理対象年月,
                        new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()));
        List<JukyushaDaichoRelateEntity> 受給者台帳情報リスト = mapper.select受給者台帳情報(sqlParam);
        List<DbT1001HihokenshaDaichoEntity> 被保険者台帳情報リスト = mapper.select被保険者台帳情報(sqlParam);
        List<JukyushaDaichoRelateEntity> 受給者台帳情報List = get受給者台帳情報リスト(受給者台帳情報リスト);
        List<DbT1001HihokenshaDaichoEntity> 被保険者台帳情報List = get被保険者台帳情報リスト(被保険者台帳情報リスト);
        int 連番 = 1;
        kooGakuTempEntity.addAll(set最古の高額異動情報作成(被保険者台帳情報リスト, 受給者台帳情報List, 連番, 処理対象年月));
        List<FlexibleYearMonth> 異動日リスト = new ArrayList<>();
        for (IdouChuukannKooGakuTempEntity kihonEntity : kooGakuTempEntity) {
            異動日リスト.add(kihonEntity.get異動年月日().getYearMonth());
        }
        if (!異動日リスト.contains(new FlexibleYearMonth(処理対象年月).minusMonth(1))) {
            kooGakuTempEntity.addAll(set最新の高額異動情報作成(被保険者台帳情報List, 受給者台帳情報リスト, 連番, 処理対象年月));
        }
        if (区分_1.equals(合併区分)) {
            kooGakuTempEntity.addAll(set高額合併異動情報作成(被保険者台帳情報List, 受給者台帳情報リスト, 連番, 異動日リスト, 処理対象年月));
        }
        return kooGakuTempEntity;
    }

    private List<IdouChuukannKooGakuTempEntity> set最古の高額異動情報作成(List<DbT1001HihokenshaDaichoEntity> 被保険者台帳情報リスト,
            List<JukyushaDaichoRelateEntity> 被保険者番号リスト, int 連番, RString 処理対象年月) {
        List<IdouChuukannKooGakuTempEntity> kooGakuTempEntity = new ArrayList<>();
        for (JukyushaDaichoRelateEntity 被保険者番号Entity : 被保険者番号リスト) {
            for (DbT1001HihokenshaDaichoEntity 被保険者台帳 : 被保険者台帳情報リスト) {
                if (被保険者番号Entity.get受給者台帳Entity().getHihokenshaNo().equals(被保険者台帳.getHihokenshaNo())) {
                    FlexibleDate 資格取得年月日 = 被保険者台帳.getShikakuShutokuYMD();
                    FlexibleDate 資格喪失年月日 = 被保険者台帳.getShikakuSoshitsuYMD();
                    FlexibleDate 認定有効期間開始年月日 = 被保険者番号Entity.get受給者台帳Entity().getNinteiYukoKikanKaishiYMD();
                    if (資格取得年月日 == null || 資格取得年月日.isEmpty()) {
                        資格取得年月日 = FlexibleDate.MIN;
                    }
                    if (認定有効期間開始年月日 == null || 認定有効期間開始年月日.isEmpty()) {
                        continue;
                    } else if (資格喪失年月日 != null && !資格喪失年月日.isEmpty()
                            && 資格取得年月日.isBeforeOrEquals(認定有効期間開始年月日)
                            && !資格喪失年月日.isBefore(認定有効期間開始年月日)) {
                        kooGakuTempEntity.add(set高額古異動情報(被保険者番号Entity, 被保険者台帳, 連番, 処理対象年月));
                    } else if ((資格喪失年月日 == null || 資格喪失年月日.isEmpty())
                            && 資格取得年月日.isBeforeOrEquals(認定有効期間開始年月日)) {
                        kooGakuTempEntity.add(set高額古異動情報(被保険者番号Entity, 被保険者台帳, 連番, 処理対象年月));
                    }
                    連番 = 連番 + 1;
                }
            }
        }
        return kooGakuTempEntity;
    }

    private List<IdouChuukannKooGakuTempEntity> set最新の高額異動情報作成(List<DbT1001HihokenshaDaichoEntity> 異動情報リスト,
            List<JukyushaDaichoRelateEntity> 受給者台帳情報リスト, int 連番, RString 処理対象年月) {
        List<IdouChuukannKooGakuTempEntity> kooGakuTempEntity = new ArrayList<>();
        for (DbT1001HihokenshaDaichoEntity 異動情報 : 異動情報リスト) {
            FlexibleDate 資格喪失年月日 = 異動情報.getShikakuSoshitsuYMD();
            FlexibleYearMonth 資格取得年月日 = FlexibleYearMonth.MIN;
            FlexibleYearMonth 対象年月 = new FlexibleYearMonth(処理対象年月);
            FlexibleDate 取得年月日 = 異動情報.getShikakuShutokuYMD();
            if (取得年月日 != null && !取得年月日.isEmpty()) {
                資格取得年月日 = 取得年月日.getYearMonth();
            }
            if (資格喪失年月日 != null && !資格喪失年月日.isEmpty() && 資格取得年月日.isBefore(対象年月)
                    && 対象年月.isBeforeOrEquals(資格喪失年月日.getYearMonth())) {
                for (JukyushaDaichoRelateEntity 受給者台帳情報 : 受給者台帳情報リスト) {
                    if (異動情報.getHihokenshaNo().equals(受給者台帳情報.get受給者台帳Entity().getHihokenshaNo())) {
                        kooGakuTempEntity.add(set高額新異動情報(受給者台帳情報, 異動情報, 連番, 処理対象年月));
                    }
                }
            } else if ((資格喪失年月日 == null || 資格喪失年月日.isEmpty()) && 資格取得年月日.isBefore(対象年月)) {
                for (JukyushaDaichoRelateEntity 受給者台帳情報 : 受給者台帳情報リスト) {
                    if (異動情報.getHihokenshaNo().equals(受給者台帳情報.get受給者台帳Entity().getHihokenshaNo())) {
                        kooGakuTempEntity.add(set高額新異動情報(受給者台帳情報, 異動情報, 連番, 処理対象年月));
                    }
                }
            }
        }
        return kooGakuTempEntity;
    }

    private List<IdouChuukannKooGakuTempEntity> set高額合併異動情報作成(List<DbT1001HihokenshaDaichoEntity> 被保険者台帳情報List,
            List<JukyushaDaichoRelateEntity> 受給者台帳情報List, int 連番, List<FlexibleYearMonth> 異動日リスト, RString 処理対象年月) {
        List<IdouChuukannKooGakuTempEntity> kooGakuTempEntity = new ArrayList<>();
        List<DbT7055GappeiJohoEntity> 合併情報リスト = 合併情報Dac.selectGappeiYMD();
        List<DbT1001HihokenshaDaichoEntity> 合併被保険者台帳リスト = new ArrayList<>();
        List<JukyushaDaichoRelateEntity> 合併受給者台帳リスト = new ArrayList<>();
        for (DbT7055GappeiJohoEntity 合併情報 : 合併情報リスト) {
            if (!異動日リスト.contains(合併情報.getGappeiYMD().getYearMonth())) {
                for (DbT1001HihokenshaDaichoEntity 被保険者台帳情報 : 被保険者台帳情報List) {
                    List<DbT1001HihokenshaDaichoEntity> 被保険者台帳 = new ArrayList<>();
                    if (被保険者台帳情報.getIdoYMD().isBefore(合併情報.getGappeiYMD())) {
                        被保険者台帳.add(被保険者台帳情報);
                    }
                    Collections.sort(被保険者台帳, new Comparator<DbT1001HihokenshaDaichoEntity>() {
                        @Override
                        public int compare(DbT1001HihokenshaDaichoEntity entity1, DbT1001HihokenshaDaichoEntity entity2) {
                            FlexibleDate str1 = entity1.getIdoYMD();
                            FlexibleDate str2 = entity2.getIdoYMD();
                            return str2.compareTo(str1);
                        }
                    });
                    if (get合併被保険者台帳(合併情報, 被保険者台帳) != null) {
                        合併被保険者台帳リスト.add(get合併被保険者台帳(合併情報, 被保険者台帳));
                    }
                }
                if (get受給者台帳合併情報作成(合併情報, 受給者台帳情報List) != null) {
                    合併受給者台帳リスト.add(get受給者台帳合併情報作成(合併情報, 受給者台帳情報List));
                }
                for (DbT1001HihokenshaDaichoEntity 合併被保険者台帳 : 合併被保険者台帳リスト) {
                    for (JukyushaDaichoRelateEntity 合併受給者台帳 : 合併受給者台帳リスト) {
                        if (合併被保険者台帳.getHihokenshaNo().equals(合併受給者台帳.get受給者台帳Entity().getHihokenshaNo())) {
                            kooGakuTempEntity.add(set高額合併異動情報(合併受給者台帳, 合併被保険者台帳, 連番,
                                    処理対象年月, 合併情報.getGappeiYMD().getYearMonth()));
                        }
                    }
                }
            }
        }
        return kooGakuTempEntity;
    }

    private IdouChuukannKooGakuTempEntity set高額新異動情報(JukyushaDaichoRelateEntity 被保険者番号,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, int 連番, RString 処理対象年月) {
        FlexibleYearMonth 異動年月 = new FlexibleYearMonth(処理対象年月);
        RStringBuilder 月初 = new RStringBuilder();
        月初.append(異動年月.minusMonth(1));
        月初.append(区分_01);
        IdouChuukannKooGakuTempEntity chuukannKihon = setKooGakuEntity(被保険者番号, 被保険者台帳, 連番,
                処理対象年月, new FlexibleDate(月初.toRString()));
        chuukannKihon.set異動年月日(new FlexibleDate(月初.toRString()));
        chuukannKihon.set異動区分コード(区分_2);
        chuukannKihon.set受給者異動事由(区分_99);
        return chuukannKihon;
    }

    private IdouChuukannKooGakuTempEntity set高額古異動情報(JukyushaDaichoRelateEntity 被保険者番号,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, int 連番, RString 処理対象年月) {
        FlexibleDate 認定有効期間開始年月日 = 被保険者番号.get受給者台帳Entity().getNinteiYukoKikanKaishiYMD();
        RStringBuilder 月初 = new RStringBuilder();
        if (認定有効期間開始年月日 != null && !認定有効期間開始年月日.isEmpty()) {
            月初.append(認定有効期間開始年月日.getYearMonth());
            月初.append(区分_01);
        }
        IdouChuukannKooGakuTempEntity chuukannKihon = setKooGakuEntity(被保険者番号, 被保険者台帳, 連番,
                処理対象年月, new FlexibleDate(月初.toRString()));
        chuukannKihon.set異動年月日(new FlexibleDate(月初.toRString()));
        chuukannKihon.set異動区分コード(区分_1);
        chuukannKihon.set受給者異動事由(区分_01);
        return chuukannKihon;
    }

    private IdouChuukannKooGakuTempEntity set高額合併異動情報(JukyushaDaichoRelateEntity 被保険者番号,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, int 連番, RString 処理対象年月, FlexibleYearMonth 異動年月日) {
        RStringBuilder 月初 = new RStringBuilder();
        月初.append(異動年月日);
        月初.append(区分_01);
        IdouChuukannKooGakuTempEntity chuukannKihon = setKooGakuEntity(被保険者番号, 被保険者台帳, 連番,
                処理対象年月, new FlexibleDate(月初.toRString()));
        chuukannKihon.set異動年月日(new FlexibleDate(月初.toRString()));
        chuukannKihon.set異動区分コード(区分_1);
        chuukannKihon.set受給者異動事由(区分_04);
        return chuukannKihon;
    }

    private IdouChuukannKooGakuTempEntity setKooGakuEntity(JukyushaDaichoRelateEntity 被保険者番号,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, int 連番, RString 処理対象年月, FlexibleDate 異動年月日) {
        IdouChuukannKooGakuTempEntity chuukannKihon = new IdouChuukannKooGakuTempEntity();
        chuukannKihon.set証記載保険者番号(ShoKisaiHokenshaNo.EMPTY);
        chuukannKihon.set被保険者番号(被保険者番号.get受給者台帳Entity().getHihokenshaNo());
        chuukannKihon.set履歴番号(連番);
        AtenaMeisho 保険者氏名 = 被保険者番号.get宛名Entity().getMeisho();
        if (保険者氏名 != null) {
            chuukannKihon.set被保険者氏名(保険者氏名.value());
        }
        chuukannKihon.set訂正区分コード(RString.EMPTY);
        chuukannKihon.set訂正年月日(FlexibleDate.EMPTY);
        chuukannKihon.set送付年月(new FlexibleYearMonth(処理対象年月));
        chuukannKihon.set市町村コード(被保険者台帳.getShichosonCode());
        chuukannKihon.set資格取得年月日(被保険者台帳.getShikakuShutokuYMD());
        chuukannKihon.set資格喪失年月日(被保険者台帳.getShikakuSoshitsuYMD());
        chuukannKihon.set認定有効期間開始年月日(被保険者番号.get受給者台帳Entity().getNinteiYukoKikanKaishiYMD());
        chuukannKihon.set認定有効期間終了年月日(被保険者番号.get受給者台帳Entity().getNinteiYukoKikanShuryoYMD());
        chuukannKihon.set論理削除フラグ(false);
        FlexibleDate 資格取得日 = 被保険者台帳.getShikakuShutokuYMD();
        if (資格取得日 != null && !資格取得日.isEmpty() && 異動年月日.getYearMonth().equals(資格取得日.getYearMonth())) {
            chuukannKihon.set基準年月日(被保険者台帳.getShikakuShutokuYMD());
        } else {
            chuukannKihon.set基準年月日(異動年月日);
        }
        if (new FlexibleYear(new RString("2015")).isBeforeOrEquals(chuukannKihon.get基準年月日().getYear())) {
            if (月分_8 <= chuukannKihon.get基準年月日().getMonthValue()) {
                chuukannKihon.set世帯把握用所得年度(chuukannKihon.get基準年月日().getNendo());
            } else {
                chuukannKihon.set世帯把握用所得年度(chuukannKihon.get基準年月日().minusYear(1).getNendo());
            }
        } else if (new FlexibleYear(new RString("2006")).isBeforeOrEquals(chuukannKihon.get基準年月日().getYear())) {
            if (月分_7 <= chuukannKihon.get基準年月日().getMonthValue()) {
                chuukannKihon.set世帯把握用所得年度(chuukannKihon.get基準年月日().getNendo());
            } else {
                chuukannKihon.set世帯把握用所得年度(chuukannKihon.get基準年月日().minusYear(1).getNendo());
            }
        } else {
            if (月分_6 <= chuukannKihon.get基準年月日().getMonthValue()) {
                chuukannKihon.set世帯把握用所得年度(chuukannKihon.get基準年月日().getNendo());
            } else {
                chuukannKihon.set世帯把握用所得年度(chuukannKihon.get基準年月日().minusYear(1).getNendo());
            }
        }
        return chuukannKihon;
    }

    /**
     * 高額選別情報の情報編集。
     *
     * @param chuukannKihon 異動中間高額
     * @param 世帯員所得情報 世帯員所得情報
     * @param entityData 世帯員所得情報リスト
     * @param 処理対象年月 処理対象年月
     */
    public void set高額選別情報(IdouChuukannKooGakuTempEntity chuukannKihon,
            SetaiYinEntity 世帯員所得情報, List<SetaiYinEntity> entityData, RString 処理対象年月) {
        boolean 世帯課税区分フラグ = false;
        boolean 激変緩和区分フラグ = false;
        for (SetaiYinEntity entity : entityData) {
            if (区分_1.equals(entity.getShotaikazeikubun())) {
                世帯課税区分フラグ = true;
            }
            if (区分_1.equals(entity.getGekihenkanwasoti())) {
                激変緩和区分フラグ = true;
            }
        }
        RStringBuilder builder = new RStringBuilder();
        if (RString.isNullOrEmpty(世帯員所得情報.getShotaishotokukubunCode())) {
            builder.append(区分_8);
            builder.append(chuukannKihon.get被保険者番号().value().substring(1));
            chuukannKihon.set世帯集約番号(new HihokenshaNo(builder.toRString()));
            chuukannKihon.set世帯所得区分コード(区分_2);
            chuukannKihon.set所得区分コード(区分_2);
            chuukannKihon.set老齢福祉年金受給有フラグ(false);
            chuukannKihon.set利用者負担第２段階有フラグ(false);
            chuukannKihon.set激変緩和境界層区分(区分_0);
        } else {
            if (区分_1.equals(世帯員所得情報.getJuushotitokureigaitou())) {
                builder.append(区分_9);
                builder.append(chuukannKihon.get被保険者番号().value().substring(1));
                chuukannKihon.set世帯集約番号(new HihokenshaNo(builder.toRString()));
            } else {
                chuukannKihon.set世帯集約番号(new HihokenshaNo(世帯員所得情報.getSetaiCode().value()));
            }
            if (区分_1.equals(世帯員所得情報.getShoubokubun())) {
                chuukannKihon.set世帯所得区分コード(区分_3);
                chuukannKihon.set所得区分コード(区分_3);
            } else if (!区分_1.equals(世帯員所得情報.getShoubokubun()) && 世帯課税区分フラグ) {
                chuukannKihon.set世帯所得区分コード(区分_1);
            } else {
                chuukannKihon.set世帯所得区分コード(区分_2);
            }
            if (new FlexibleDate("20150801").isBeforeOrEquals(世帯員所得情報.getJukyuYMD()) && 区分_1.equals(世帯員所得情報.getShotokukubunCode())) {
                chuukannKihon.set世帯所得区分コード(set世帯所得区分コード(世帯員所得情報, chuukannKihon, 処理対象年月));
            }
            if (!区分_1.equals(世帯員所得情報.getShoubokubun()) && 区分_1.equals(世帯員所得情報.getHonninnkubun())) {
                chuukannKihon.set所得区分コード(世帯員所得情報.getHonninkazeikubnn());
            } else if (!区分_1.equals(世帯員所得情報.getShoubokubun()) && new FlexibleDate("20150801").isBeforeOrEquals(世帯員所得情報.getJukyuYMD())
                    && 区分_1.equals(世帯員所得情報.getShotokukubunCode())) {
                chuukannKihon.set所得区分コード(世帯員所得情報.getHonninkazeikubnn());
            }
            set高額情報設定(chuukannKihon, 世帯員所得情報);
        }
        if (RString.isNullOrEmpty(世帯員所得情報.getShotaishotokukubunCode())
                && !区分_3.equals(chuukannKihon.get世帯所得区分コード())) {
            set再度設定(chuukannKihon, 世帯員所得情報, 世帯課税区分フラグ, 激変緩和区分フラグ);
        }
    }

    private RString set世帯所得区分コード(SetaiYinEntity 世帯員所得情報,
            IdouChuukannKooGakuTempEntity chuukannKihon, RString 処理対象年月) {
        RStringBuilder builder = new RStringBuilder();
        if (区分_1.equals(世帯員所得情報.getJuushotitokureigaitou())) {
            builder.append(new RString("90000"));
        }
        builder.append(世帯員所得情報.getShotaiCode());
        builder.append(世帯員所得情報.getShotokuNendo());
        List<DbT3116KijunShunyugakuTekiyoKanriEntity> 基準収入額適用管理 = dbT3116Dac.selectAll();
        Collections.sort(基準収入額適用管理, new Comparator<DbT3116KijunShunyugakuTekiyoKanriEntity>() {
            @Override
            public int compare(DbT3116KijunShunyugakuTekiyoKanriEntity entity1, DbT3116KijunShunyugakuTekiyoKanriEntity entity2) {
                FlexibleYearMonth str1 = entity1.getTekiyoKaishiYMD();
                FlexibleYearMonth str2 = entity2.getTekiyoKaishiYMD();
                if (str2 == null || str2.isEmpty()) {
                    str2 = FlexibleYearMonth.MIN;
                }
                if (str1 == null || str1.isEmpty()) {
                    str1 = FlexibleYearMonth.MIN;
                }
                return str2.compareTo(str1);
            }
        });

        Map<RString, List<DbT3116KijunShunyugakuTekiyoKanriEntity>> data_map = new HashMap<>();
        for (DbT3116KijunShunyugakuTekiyoKanriEntity entity : 基準収入額適用管理) {
            if (!new Decimal(0).equals(entity.getSanteiKijungaku())) {
                if (data_map.containsKey(entity.getSetaiCode().value().concat(entity.getNendo().toDateString()))) {
                    List<DbT3116KijunShunyugakuTekiyoKanriEntity> map = data_map.get(entity.getSetaiCode().value()
                            .concat(entity.getNendo().toDateString()));
                    map.add(entity);
                } else {
                    List<DbT3116KijunShunyugakuTekiyoKanriEntity> map = new ArrayList<>();
                    map.add(entity);
                    data_map.put(entity.getSetaiCode().value().concat(entity.getNendo().toDateString()), map);
                }
            }
        }
        List<DbT3116KijunShunyugakuTekiyoKanriEntity> 基準収入額リスト = new ArrayList<>();
        for (List<DbT3116KijunShunyugakuTekiyoKanriEntity> keys : data_map.values()) {
            基準収入額リスト.add(keys.get(0));
        }
        for (DbT3116KijunShunyugakuTekiyoKanriEntity entity : 基準収入額リスト) {
            if (builder.toRString().equals(entity.getSetaiCode().value().concat(entity.getNendo().toDateString()))) {
                if (算定基準額_44400.equals(entity.getSanteiKijungaku())) {
                    return 区分_4;
                } else if (算定基準額_37200.equals(entity.getSanteiKijungaku())) {
                    return 区分_1;
                } else {
                    return get世帯員の人数(entity, chuukannKihon, 処理対象年月);
                }
            }
        }
        return RString.EMPTY;
    }

    private RString get世帯員の人数(DbT3116KijunShunyugakuTekiyoKanriEntity 基準収入額情報,
            IdouChuukannKooGakuTempEntity chuukannKihon, RString 処理対象年月) {
        List<SetaiYinEntity> 世帯員所得情報 = mapper.select世帯員所得情報();
        List<DbT1001HihokenshaDaichoEntity> 被保険者台帳情報 = mapper
                .select被保険者台帳情報(HonnsanteiFukaMybatisParamter.createSofuDataParam(処理対象年月, RString.EMPTY));
        int ren = 0;
        for (SetaiYinEntity entity : 世帯員所得情報) {
            for (DbT1001HihokenshaDaichoEntity dbt1001 : 被保険者台帳情報) {
                if (entity.getHihokenshaNo().equals(dbt1001.getHihokenshaNo())
                        && (区分_1.equals(dbt1001.getHihokennshaKubunCode()) || 区分_3.equals(dbt1001.getHihokennshaKubunCode()))
                        && entity.getHihokenshaNo().equals(chuukannKihon.get被保険者番号())
                        && chuukannKihon.get資格取得年月日().isBeforeOrEquals(entity.getJukyuYMD())
                        && entity.getJukyuYMD().isBefore(chuukannKihon.get資格喪失年月日())
                        && 算定基準額_1450000.compareTo(基準収入額情報.getSanteiKijungaku()) < 0) {
                    ren = ren + 1;
                }
            }
        }
        if (ren == 0) {
            return 区分_1;
        } else if (2 <= ren) {
            return 区分_4;
        } else {
            return RString.EMPTY;
        }
    }

    private void set高額情報設定(IdouChuukannKooGakuTempEntity chuukannKihon, SetaiYinEntity 世帯員所得情報) {
        if (区分_1.equals(世帯員所得情報.getRoureifukusikubun())) {
            chuukannKihon.set老齢福祉年金受給有フラグ(true);
        } else {
            chuukannKihon.set老齢福祉年金受給有フラグ(false);
        }
        if (区分_1.equals(世帯員所得情報.getRoureifukusikubun()) && 区分_2.equals(chuukannKihon.get世帯所得区分コード())
                && ((0 < 世帯員所得情報.getGoukeishotokukingaku()
                && (世帯員所得情報.getGoukeishotokukingaku() + 世帯員所得情報.getNenkinnshuunyuugaku()) <= 収入額)
                || (世帯員所得情報.getNenkinnshotokugaku() <= 0 && 世帯員所得情報.getNenkinnshuunyuugaku() <= 収入額))) {
            chuukannKihon.set利用者負担第２段階有フラグ(true);
        } else {
            chuukannKihon.set利用者負担第２段階有フラグ(false);
        }
        List<DbT1006KyokaisoGaitoshaEntity> dbt1006Entity = dbT1006Dac.selectAll();
        if (dbt1006Entity == null || dbt1006Entity.isEmpty()) {
            chuukannKihon.set激変緩和境界層区分(区分_0);
        } else {
            for (DbT1006KyokaisoGaitoshaEntity entity : dbt1006Entity) {
                if (entity.getHihokenshaNo().equals(世帯員所得情報.getHihokenshaNo())
                        && entity.getTekiyoKaishiYMD().isBeforeOrEquals(世帯員所得情報.getJukyuYMD())
                        && 世帯員所得情報.getJukyuYMD().isBeforeOrEquals(entity.getTekiyoShuryoYMD())
                        && entity.getKogakuServicehiJogengakuGengakugoJogengaku() == 上限額_2) {
                    chuukannKihon.set激変緩和境界層区分(区分_2);
                } else if (entity.getHihokenshaNo().equals(世帯員所得情報.getHihokenshaNo())
                        && entity.getTekiyoKaishiYMD().isBeforeOrEquals(世帯員所得情報.getJukyuYMD())
                        && 世帯員所得情報.getJukyuYMD().isBeforeOrEquals(entity.getTekiyoShuryoYMD())
                        && entity.getKogakuServicehiJogengakuGengakugoJogengaku() == 上限額_1) {
                    chuukannKihon.set激変緩和境界層区分(区分_1);
                }
            }
        }
    }

    private void set再度設定(IdouChuukannKooGakuTempEntity chuukannKihon, SetaiYinEntity 世帯員所得情報,
            boolean 世帯課税区分フラグ, boolean 激変緩和区分フラグ) {
        if (区分_2.equals(chuukannKihon.get激変緩和境界層区分())) {
            chuukannKihon.set世帯所得区分コード(区分_3);
            chuukannKihon.set所得区分コード(区分_3);
            chuukannKihon.set老齢福祉年金受給有フラグ(false);
            chuukannKihon.set利用者負担第２段階有フラグ(false);
        }
        if (区分_1.equals(chuukannKihon.get激変緩和境界層区分())) {
            chuukannKihon.set世帯所得区分コード(区分_2);
            chuukannKihon.set所得区分コード(区分_2);
            if ((0 < 世帯員所得情報.getGoukeishotokukingaku()
                    && (世帯員所得情報.getGoukeishotokukingaku() + 世帯員所得情報.getNenkinnshuunyuugaku()) <= 収入額)
                    || (世帯員所得情報.getGoukeishotokukingaku() <= 0 && 世帯員所得情報.getNenkinnshuunyuugaku() <= 収入額)) {
                chuukannKihon.set利用者負担第２段階有フラグ(true);
            } else if ((0 < 世帯員所得情報.getGoukeishotokukingaku()
                    && 収入額 < (世帯員所得情報.getGoukeishotokukingaku() + 世帯員所得情報.getNenkinnshuunyuugaku()))
                    || (世帯員所得情報.getGoukeishotokukingaku() <= 0
                    && 収入額 < 世帯員所得情報.getNenkinnshuunyuugaku())) {
                chuukannKihon.set利用者負担第２段階有フラグ(false);
            }
        }
        if (区分_0.equals(chuukannKihon.get激変緩和境界層区分())
                && new FlexibleYear(DbBusinessConfig.get(ConfigNameDBU.平１８激変緩和期間_適用開始年度,
                                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告)).isBeforeOrEquals(世帯員所得情報.getShotokuNendo())
                && 世帯員所得情報.getShotokuNendo().isBeforeOrEquals(new FlexibleYear(DbBusinessConfig.
                                get(ConfigNameDBU.平１８激変緩和期間_適用終了年度, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告)))
                && 世帯課税区分フラグ) {
            if (激変緩和区分フラグ) {
                chuukannKihon.set利用者負担第２段階有フラグ(false);
            } else {
                if ((世帯員所得情報.getGoukeishotokukingaku() + 世帯員所得情報.getNenkinnshuunyuugaku()) <= 収入額
                        || 世帯員所得情報.getNenkinnshuunyuugaku() <= 収入額) {
                    chuukannKihon.set利用者負担第２段階有フラグ(true);
                } else {
                    chuukannKihon.set利用者負担第２段階有フラグ(false);
                }
            }
        }
    }

    /**
     * 世帯員把握情報の情報編集。
     *
     * @param 異動中間高額送付情報 異動中間高額送付情報
     * @param 処理対象年月 処理対象年月
     * @return 世帯員把握情報
     */
    public List<ShotaiinHaakuIttokiTempEntity> set世帯員把握情報(List<IdouChuukannKooGakuTempEntity> 異動中間高額送付情報,
            RString 処理対象年月) {
        List<ShotaiinHaakuIttokiTempEntity> shotaiinTempEntity = new ArrayList<>();
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        HonnsanteiFukaMybatisParamter sqlParam
                = HonnsanteiFukaMybatisParamter.createParam(処理対象年月,
                        new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()));
        List<DbT1001HihokenshaDaichoEntity> 被保険者台帳情報リスト = mapper.select被保険者台帳情報(sqlParam);
        for (IdouChuukannKooGakuTempEntity 異動中間高額送付 : 異動中間高額送付情報) {
            for (DbT1001HihokenshaDaichoEntity 被保険者台帳情報 : 被保険者台帳情報リスト) {
                if (被保険者台帳情報.getHihokenshaNo().equals(異動中間高額送付.get被保険者番号())) {
                    ShotaiinHaakuIttokiTempEntity entity = new ShotaiinHaakuIttokiTempEntity();
                    entity.set被保険者番号(被保険者台帳情報.getHihokenshaNo());
                    entity.set識別コード(被保険者台帳情報.getShikibetsuCode());
                    entity.set住所地特例該当(被保険者台帳情報.getJushochiTokureiFlag());
                    entity.set基準年月日(異動中間高額送付.get基準年月日());
                    entity.set所得年度(異動中間高額送付.get世帯把握用所得年度());
                    shotaiinTempEntity.add(entity);
                }
            }
        }
        return shotaiinTempEntity;
    }

    /**
     * 異動基本送付対象リスト情報です。
     *
     * @return 送付対象リスト
     */
    public List<IdouSofuListTempEntity> set基本送付対象リスト() {
        List<KyodoShoriKihonSofuTempEntity> 共同処理用受給者異動基本送付 = mapper.select共同処理用受給者異動基本送付();
        List<IdouChuukannKihonSofuTempEntity> 異動中間基本送付 = mapper.select異動中間基本送付();
        List<IdouSofuListTempEntity> 送付対象リスト = new ArrayList<>();
        Map<RString, List<KyodoShoriKihonSofuTempEntity>> data_map1 = new HashMap<>();
        for (KyodoShoriKihonSofuTempEntity entity : 共同処理用受給者異動基本送付) {
            if (data_map1.containsKey(entity.get被保険者番号().value())) {
                List<KyodoShoriKihonSofuTempEntity> map = data_map1.get(entity.get被保険者番号().value());
                map.add(entity);
            } else {
                List<KyodoShoriKihonSofuTempEntity> map = new ArrayList<>();
                map.add(entity);
                data_map1.put(entity.get被保険者番号().value(), map);
            }
        }
        List<KyodoShoriKihonSofuTempEntity> リスト = new ArrayList<>();
        for (List<KyodoShoriKihonSofuTempEntity> keys : data_map1.values()) {
            リスト.add(keys.get(0));
        }
        Map<RString, List<IdouChuukannKihonSofuTempEntity>> data_map2 = new HashMap<>();
        for (IdouChuukannKihonSofuTempEntity entity : 異動中間基本送付) {
            if (data_map2.containsKey(entity.get被保険者番号().value())) {
                List<IdouChuukannKihonSofuTempEntity> map2 = data_map2.get(entity.get被保険者番号().value());
                map2.add(entity);
            } else {
                List<IdouChuukannKihonSofuTempEntity> map2 = new ArrayList<>();
                map2.add(entity);
                data_map2.put(entity.get被保険者番号().value(), map2);
            }
        }
        List<IdouChuukannKihonSofuTempEntity> リスト2 = new ArrayList<>();
        for (List<IdouChuukannKihonSofuTempEntity> keys : data_map2.values()) {
            リスト2.add(keys.get(0));
        }
        for (IdouChuukannKihonSofuTempEntity list2 : リスト2) {
            for (KyodoShoriKihonSofuTempEntity list : リスト) {
                if (list2.get被保険者番号().equals(list.get被保険者番号())) {
                    if (!list2.get証記載保険者番号().equals(list.get証記載保険者番号()) || !list2.get被保険者氏名().equals(list.get被保険者氏名())
                            || !list2.get郵便番号().equals(list.get郵便番号()) || !list2.get住所().equals(list.get住所())
                            || !list2.get住所カナ().equals(list.get住所カナ()) || !list2.get電話番号().equals(list.get電話番号())) {
                        IdouSofuListTempEntity entity = new IdouSofuListTempEntity();
                        entity.set被保険者番号(list2.get被保険者番号().value());
                        entity.set氏名(list2.get被保険者氏名());
                        entity.set区分(JukyushaIF_IdoKubunCode.toValue(list2.get異動区分コード()).get名称());
                        entity.set異動年月日(list2.get異動年月日());
                        entity.set要介護度(RString.EMPTY);
                        entity.set開始認定日(list2.get認定有効期間開始年月日());
                        entity.set終了認定日(list2.get認定有効期間終了年月日());
                        entity.set変更項目(get変更項目(list, list2));
                        送付対象リスト.add(entity);
                    }
                } else if (異動年月日.isBeforeOrEquals(list2.get異動年月日())) {
                    IdouSofuListTempEntity entity = new IdouSofuListTempEntity();
                    entity.set被保険者番号(list2.get被保険者番号().value());
                    entity.set氏名(list2.get被保険者氏名());
                    entity.set区分(JukyushaIF_IdoKubunCode.toValue(list2.get異動区分コード()).get名称());
                    entity.set異動年月日(list2.get異動年月日());
                    entity.set要介護度(RString.EMPTY);
                    entity.set開始認定日(list2.get認定有効期間開始年月日());
                    entity.set終了認定日(list2.get認定有効期間終了年月日());
                    entity.set変更項目(get変更項目(list, list2));
                    送付対象リスト.add(entity);
                }
            }
        }
        return 送付対象リスト;
    }

    private RString get変更項目(KyodoShoriKihonSofuTempEntity 共同処理用受給者異動基本送付,
            IdouChuukannKihonSofuTempEntity 異動中間基本送付) {
        RStringBuilder builder = new RStringBuilder();
        if (!共同処理用受給者異動基本送付.get証記載保険者番号().equals(異動中間基本送付.get証記載保険者番号())) {
            builder.append(証記載保険者番号);
        }
        if (!異動中間基本送付.get被保険者氏名().equals(共同処理用受給者異動基本送付.get被保険者氏名())) {
            builder.append(被保険者氏名);
        }
        if (!異動中間基本送付.get郵便番号().equals(共同処理用受給者異動基本送付.get郵便番号())) {
            builder.append(郵便番号);
        }
        if (!異動中間基本送付.get住所().equals(共同処理用受給者異動基本送付.get住所())) {
            builder.append(住所);
        }
        if (!異動中間基本送付.get住所カナ().equals(共同処理用受給者異動基本送付.get住所カナ())) {
            builder.append(住所カナ);
        }
        if (!異動中間基本送付.get電話番号().equals(共同処理用受給者異動基本送付.get電話番号())) {
            builder.append(電話番号);
        }
        return builder.toRString();
    }

    /**
     * 異動基本送付対象リスト出力用情報です。
     *
     */
    public void get基本送付出力用() {
        List<KyodoShoriKihonSofuTempEntity> 共同処理用受給者異動基本送付 = mapper.select共同処理用受給者異動基本送付();
        List<IdouChuukannKihonSofuTempEntity> 異動中間基本送付 = mapper.select異動中間基本送付();
        List<KyodoShoriKihonSofuTempEntity> 送付対象リスト = new ArrayList<>();
        Map<RString, List<KyodoShoriKihonSofuTempEntity>> data_map1 = new HashMap<>();
        for (KyodoShoriKihonSofuTempEntity entity : 共同処理用受給者異動基本送付) {
            if (data_map1.containsKey(entity.get被保険者番号().value())) {
                List<KyodoShoriKihonSofuTempEntity> map = data_map1.get(entity.get被保険者番号().value());
                map.add(entity);
            } else {
                List<KyodoShoriKihonSofuTempEntity> map = new ArrayList<>();
                map.add(entity);
                data_map1.put(entity.get被保険者番号().value(), map);
            }
        }
        List<KyodoShoriKihonSofuTempEntity> リスト = new ArrayList<>();
        for (List<KyodoShoriKihonSofuTempEntity> keys : data_map1.values()) {
            リスト.add(keys.get(0));
        }
        Map<RString, List<IdouChuukannKihonSofuTempEntity>> data_map2 = new HashMap<>();
        for (IdouChuukannKihonSofuTempEntity entity : 異動中間基本送付) {
            if (data_map2.containsKey(entity.get被保険者番号().value())) {
                List<IdouChuukannKihonSofuTempEntity> map2 = data_map2.get(entity.get被保険者番号().value());
                map2.add(entity);
            } else {
                List<IdouChuukannKihonSofuTempEntity> map2 = new ArrayList<>();
                map2.add(entity);
                data_map2.put(entity.get被保険者番号().value(), map2);
            }
        }
        List<IdouChuukannKihonSofuTempEntity> リスト2 = new ArrayList<>();
        for (List<IdouChuukannKihonSofuTempEntity> keys : data_map2.values()) {
            リスト2.add(keys.get(0));
        }
        for (IdouChuukannKihonSofuTempEntity list2 : リスト2) {
            for (KyodoShoriKihonSofuTempEntity list : リスト) {
                if (!list2.get被保険者番号().equals(list.get被保険者番号()) && 異動年月日.isBeforeOrEquals(list2.get異動年月日())) {
                    KyodoShoriKihonSofuTempEntity entity = new KyodoShoriKihonSofuTempEntity();
                    entity.set被保険者番号(list2.get被保険者番号());
                    entity.set被保険者氏名(list2.get被保険者氏名());
                    entity.set異動区分コード(JukyushaIF_IdoKubunCode.toValue(list2.get異動区分コード()).get名称());
                    entity.set異動年月日(list2.get異動年月日());
                    entity.set受給者異動事由(list2.get受給者異動事由());
                    entity.set証記載保険者番号(list2.get証記載保険者番号());
                    entity.set郵便番号(list2.get郵便番号());
                    entity.set住所カナ(list2.get住所カナ());
                    entity.set住所(list2.get住所());
                    entity.set電話番号(list2.get電話番号());
                    entity.set帳票出力順序コード(list2.get帳票出力順序コード());
                    送付対象リスト.add(entity);
                }
            }
        }
        JukyushaIdoRenrakuhyoOutCSV.createInstance().csvの出力(送付対象リスト,
                new ArrayList<KyodoShoriShouKannTempEntity>(), new ArrayList<KyodoShoriKooGakuTempEntity>());
    }

    /**
     * 異動償還送付対象リスト情報です。
     *
     * @return 送付対象リスト
     */
    public List<IdouSofuListTempEntity> set償還送付対象リスト() {
        List<KyodoShoriShouKannTempEntity> 共同処理用受給者異動償還送付 = mapper.select共同処理用受給者異動償還送付();
        List<IdouChuukannShouKannTempEntity> 異動中間償還送付 = mapper.select異動中間償還送付();
        List<IdouSofuListTempEntity> 送付対象リスト = new ArrayList<>();
        Map<RString, List<KyodoShoriShouKannTempEntity>> data_map1 = new HashMap<>();
        for (KyodoShoriShouKannTempEntity entity : 共同処理用受給者異動償還送付) {
            if (data_map1.containsKey(entity.get被保険者番号().value())) {
                List<KyodoShoriShouKannTempEntity> map = data_map1.get(entity.get被保険者番号().value());
                map.add(entity);
            } else {
                List<KyodoShoriShouKannTempEntity> map = new ArrayList<>();
                map.add(entity);
                data_map1.put(entity.get被保険者番号().value(), map);
            }
        }
        List<KyodoShoriShouKannTempEntity> リスト = new ArrayList<>();
        for (List<KyodoShoriShouKannTempEntity> keys : data_map1.values()) {
            リスト.add(keys.get(0));
        }
        Map<RString, List<IdouChuukannShouKannTempEntity>> data_map2 = new HashMap<>();
        for (IdouChuukannShouKannTempEntity entity : 異動中間償還送付) {
            if (data_map2.containsKey(entity.get被保険者番号().value())) {
                List<IdouChuukannShouKannTempEntity> map2 = data_map2.get(entity.get被保険者番号().value());
                map2.add(entity);
            } else {
                List<IdouChuukannShouKannTempEntity> map2 = new ArrayList<>();
                map2.add(entity);
                data_map2.put(entity.get被保険者番号().value(), map2);
            }
        }
        List<IdouChuukannShouKannTempEntity> リスト2 = new ArrayList<>();
        for (List<IdouChuukannShouKannTempEntity> keys : data_map2.values()) {
            リスト2.add(keys.get(0));
        }
        for (IdouChuukannShouKannTempEntity list2 : リスト2) {
            for (KyodoShoriShouKannTempEntity list : リスト) {
                if (list2.get被保険者番号().equals(list.get被保険者番号())) {
                    if (!list2.get証記載保険者番号().equals(list.get証記載保険者番号())
                            || !list2.get保険給付支払一時差止終了年月日().equals(list.get保険給付支払一時差止終了年月日())
                            || list2.get保険給付支払一時差止金額() != list.get保険給付支払一時差止金額()
                            || !list2.get保険給付支払一時差止区分コード().equals(list.get保険給付支払一時差止区分コード())
                            || !list2.get保険給付支払一時差止開始年月日().equals(list.get保険給付支払一時差止開始年月日())) {
                        IdouSofuListTempEntity entity = new IdouSofuListTempEntity();
                        entity.set被保険者番号(list2.get被保険者番号().value());
                        entity.set氏名(list2.get被保険者氏名());
                        entity.set区分(JukyushaIF_IdoKubunCode.toValue(list2.get異動区分コード()).get名称());
                        entity.set異動年月日(list2.get異動年月日());
                        entity.set要介護度(RString.EMPTY);
                        entity.set開始認定日(list2.get保険給付支払一時差止開始年月日());
                        entity.set終了認定日(list2.get保険給付支払一時差止終了年月日());
                        entity.set変更項目(get償還変更項目(list, list2));
                        送付対象リスト.add(entity);
                    }
                } else if (list2.get被保険者番号() != null && 異動年月日.isBeforeOrEquals(list2.get異動年月日())) {
                    IdouSofuListTempEntity entity = new IdouSofuListTempEntity();
                    entity.set被保険者番号(list2.get被保険者番号().value());
                    entity.set氏名(list2.get被保険者氏名());
                    entity.set区分(JukyushaIF_IdoKubunCode.toValue(list2.get異動区分コード()).get名称());
                    entity.set異動年月日(list2.get異動年月日());
                    entity.set要介護度(RString.EMPTY);
                    entity.set開始認定日(list2.get保険給付支払一時差止開始年月日());
                    entity.set終了認定日(list2.get保険給付支払一時差止終了年月日());
                    entity.set変更項目(get償還変更項目(list, list2));
                    送付対象リスト.add(entity);
                }
            }
        }
        return 送付対象リスト;
    }

    /**
     * 異動中間償還送付対象リスト出力用情報です。
     *
     */
    public void get償還送付出力用() {
        List<KyodoShoriShouKannTempEntity> 共同処理用受給者異動償還送付 = mapper.select共同処理用受給者異動償還送付();
        List<IdouChuukannShouKannTempEntity> 異動中間償還送付 = mapper.select異動中間償還送付();
        List<KyodoShoriShouKannTempEntity> 送付対象リスト = new ArrayList<>();
        Map<RString, List<KyodoShoriShouKannTempEntity>> data_map1 = new HashMap<>();
        for (KyodoShoriShouKannTempEntity entity : 共同処理用受給者異動償還送付) {
            if (data_map1.containsKey(entity.get被保険者番号().value())) {
                List<KyodoShoriShouKannTempEntity> map = data_map1.get(entity.get被保険者番号().value());
                map.add(entity);
            } else {
                List<KyodoShoriShouKannTempEntity> map = new ArrayList<>();
                map.add(entity);
                data_map1.put(entity.get被保険者番号().value(), map);
            }
        }
        List<KyodoShoriShouKannTempEntity> リスト = new ArrayList<>();
        for (List<KyodoShoriShouKannTempEntity> keys : data_map1.values()) {
            リスト.add(keys.get(0));
        }
        Map<RString, List<IdouChuukannShouKannTempEntity>> data_map2 = new HashMap<>();
        for (IdouChuukannShouKannTempEntity entity : 異動中間償還送付) {
            if (data_map2.containsKey(entity.get被保険者番号().value())) {
                List<IdouChuukannShouKannTempEntity> map2 = data_map2.get(entity.get被保険者番号().value());
                map2.add(entity);
            } else {
                List<IdouChuukannShouKannTempEntity> map2 = new ArrayList<>();
                map2.add(entity);
                data_map2.put(entity.get被保険者番号().value(), map2);
            }
        }
        List<IdouChuukannShouKannTempEntity> リスト2 = new ArrayList<>();
        for (List<IdouChuukannShouKannTempEntity> keys : data_map2.values()) {
            リスト2.add(keys.get(0));
        }
        for (IdouChuukannShouKannTempEntity list2 : リスト2) {
            for (KyodoShoriShouKannTempEntity list : リスト) {
                if (!list2.get被保険者番号().equals(list.get被保険者番号()) && 異動年月日.isBeforeOrEquals(list2.get異動年月日())) {
                    KyodoShoriShouKannTempEntity entity = new KyodoShoriShouKannTempEntity();
                    entity.set異動年月日(list2.get異動年月日());
                    entity.set異動区分コード(JukyushaIF_IdoKubunCode.toValue(list2.get異動区分コード()).get名称());
                    entity.set受給者異動事由(list2.get受給者異動事由());
                    entity.set証記載保険者番号(list2.get証記載保険者番号());
                    entity.set被保険者番号(list2.get被保険者番号());
                    entity.set保険給付支払一時差止開始年月日(list2.get保険給付支払一時差止開始年月日());
                    entity.set保険給付支払一時差止終了年月日(list2.get保険給付支払一時差止終了年月日());
                    entity.set保険給付支払一時差止区分コード(list2.get保険給付支払一時差止区分コード());
                    entity.set保険給付支払一時差止金額(list2.get保険給付支払一時差止金額());
                    送付対象リスト.add(entity);
                }
            }
        }
        JukyushaIdoRenrakuhyoOutCSV.createInstance().csvの出力(new ArrayList<KyodoShoriKihonSofuTempEntity>(),
                送付対象リスト, new ArrayList<KyodoShoriKooGakuTempEntity>());
    }

    private RString get償還変更項目(KyodoShoriShouKannTempEntity 共同処理用受給者異動償還送付,
            IdouChuukannShouKannTempEntity 異動中間償還送付一時) {
        RStringBuilder builder = new RStringBuilder();
        if (!異動中間償還送付一時.get証記載保険者番号().equals(共同処理用受給者異動償還送付.get証記載保険者番号())) {
            builder.append(証記載保険者番号);
        }
        if (!異動中間償還送付一時.get被保険者番号().equals(共同処理用受給者異動償還送付.get被保険者番号())) {
            builder.append(被保険者番号);
        }
        if (!異動中間償還送付一時.get保険給付支払一時差止開始年月日().equals(共同処理用受給者異動償還送付.get保険給付支払一時差止開始年月日())) {
            builder.append(保険給付支払一時差止開始年月日);
        }
        if (!異動中間償還送付一時.get保険給付支払一時差止終了年月日().equals(共同処理用受給者異動償還送付.get保険給付支払一時差止終了年月日())) {
            builder.append(保険給付支払一時差止終了年月日);
        }
        if (!異動中間償還送付一時.get保険給付支払一時差止区分コード().equals(共同処理用受給者異動償還送付.get保険給付支払一時差止区分コード())) {
            builder.append(保険給付支払一時差止区分コード);
        }
        if (!異動中間償還送付一時.get保険給付支払一時差止金額().equals(共同処理用受給者異動償還送付.get保険給付支払一時差止金額())) {
            builder.append(保険給付支払一時差止金額);
        }
        return builder.toRString();
    }

    /**
     * 異動高額送付対象リスト情報です。
     *
     * @return 送付対象リスト
     */
    public List<IdouSofuListTempEntity> set高額送付対象リスト() {
        List<KyodoShoriKooGakuTempEntity> 共同処理用受給者異動高額送付 = mapper.select共同処理用受給者異動高額送付();
        List<IdouChuukannKooGakuTempEntity> 異動中間高額送付 = mapper.select異動中間高額送付();
        List<IdouSofuListTempEntity> 送付対象リスト = new ArrayList<>();
        Map<RString, List<KyodoShoriKooGakuTempEntity>> data_map1 = new HashMap<>();
        for (KyodoShoriKooGakuTempEntity entity : 共同処理用受給者異動高額送付) {
            if (data_map1.containsKey(entity.get被保険者番号().value())) {
                List<KyodoShoriKooGakuTempEntity> map = data_map1.get(entity.get被保険者番号().value());
                map.add(entity);
            } else {
                List<KyodoShoriKooGakuTempEntity> map = new ArrayList<>();
                map.add(entity);
                data_map1.put(entity.get被保険者番号().value(), map);
            }
        }
        List<KyodoShoriKooGakuTempEntity> リスト = new ArrayList<>();
        for (List<KyodoShoriKooGakuTempEntity> keys : data_map1.values()) {
            リスト.add(keys.get(0));
        }
        Map<RString, List<IdouChuukannKooGakuTempEntity>> data_map2 = new HashMap<>();
        for (IdouChuukannKooGakuTempEntity entity : 異動中間高額送付) {
            if (data_map2.containsKey(entity.get被保険者番号().value())) {
                List<IdouChuukannKooGakuTempEntity> map2 = data_map2.get(entity.get被保険者番号().value());
                map2.add(entity);
            } else {
                List<IdouChuukannKooGakuTempEntity> map2 = new ArrayList<>();
                map2.add(entity);
                data_map2.put(entity.get被保険者番号().value(), map2);
            }
        }
        List<IdouChuukannKooGakuTempEntity> リスト2 = new ArrayList<>();
        for (List<IdouChuukannKooGakuTempEntity> keys : data_map2.values()) {
            リスト2.add(keys.get(0));
        }
        for (IdouChuukannKooGakuTempEntity list2 : リスト2) {
            for (KyodoShoriKooGakuTempEntity list : リスト) {
                if (list2.get被保険者番号().equals(list.get被保険者番号())) {
                    if (!list2.get証記載保険者番号().equals(list.get証記載保険者番号()) || !list2.get世帯集約番号().equals(list.get世帯集約番号())
                            || !list2.get所得区分コード().equals(list.get所得区分コード())
                            || list2.is老齢福祉年金受給有フラグ() != list.is老齢福祉年金受給有フラグ()
                            || !list2.get世帯所得区分コード().equals(list.get世帯所得区分コード())
                            || list2.is利用者負担第２段階有フラグ() != list.is利用者負担第２段階有フラグ()) {
                        IdouSofuListTempEntity entity = new IdouSofuListTempEntity();
                        entity.set被保険者番号(list2.get被保険者番号().value());
                        entity.set氏名(list2.get被保険者氏名());
                        entity.set区分(JukyushaIF_IdoKubunCode.toValue(list2.get異動区分コード()).get名称());
                        entity.set異動年月日(list2.get異動年月日());
                        entity.set要介護度(RString.EMPTY);
                        entity.set開始認定日(list2.get認定有効期間開始年月日());
                        entity.set終了認定日(list2.get認定有効期間終了年月日());
                        entity.set変更項目(get高額変更項目(list, list2));
                        送付対象リスト.add(entity);
                    }
                } else if (list2.get被保険者番号() != null && 異動年月日.isBeforeOrEquals(list2.get異動年月日())) {
                    IdouSofuListTempEntity entity = new IdouSofuListTempEntity();
                    entity.set被保険者番号(list2.get被保険者番号().value());
                    entity.set氏名(list2.get被保険者氏名());
                    entity.set区分(JukyushaIF_IdoKubunCode.toValue(list2.get異動区分コード()).get名称());
                    entity.set異動年月日(list2.get異動年月日());
                    entity.set要介護度(RString.EMPTY);
                    entity.set開始認定日(list2.get認定有効期間開始年月日());
                    entity.set終了認定日(list2.get認定有効期間終了年月日());
                    entity.set変更項目(get高額変更項目(list, list2));
                    送付対象リスト.add(entity);
                }
            }
        }
        return 送付対象リスト;
    }

    /**
     * 異動中間高額送付対象リスト出力用情報です。
     *
     */
    public void get高額送付出力用() {
        List<KyodoShoriKooGakuTempEntity> 共同処理用受給者異動高額送付 = mapper.select共同処理用受給者異動高額送付();
        List<IdouChuukannKooGakuTempEntity> 異動中間高額送付 = mapper.select異動中間高額送付();
        List<KyodoShoriKooGakuTempEntity> 送付対象リスト = new ArrayList<>();
        Map<RString, List<KyodoShoriKooGakuTempEntity>> data_map1 = new HashMap<>();
        for (KyodoShoriKooGakuTempEntity entity : 共同処理用受給者異動高額送付) {
            if (data_map1.containsKey(entity.get被保険者番号().value())) {
                List<KyodoShoriKooGakuTempEntity> map = data_map1.get(entity.get被保険者番号().value());
                map.add(entity);
            } else {
                List<KyodoShoriKooGakuTempEntity> map = new ArrayList<>();
                map.add(entity);
                data_map1.put(entity.get被保険者番号().value(), map);
            }
        }
        List<KyodoShoriKooGakuTempEntity> リスト = new ArrayList<>();
        for (List<KyodoShoriKooGakuTempEntity> keys : data_map1.values()) {
            リスト.add(keys.get(0));
        }
        Map<RString, List<IdouChuukannKooGakuTempEntity>> data_map2 = new HashMap<>();
        for (IdouChuukannKooGakuTempEntity entity : 異動中間高額送付) {
            if (data_map2.containsKey(entity.get被保険者番号().value())) {
                List<IdouChuukannKooGakuTempEntity> map2 = data_map2.get(entity.get被保険者番号().value());
                map2.add(entity);
            } else {
                List<IdouChuukannKooGakuTempEntity> map2 = new ArrayList<>();
                map2.add(entity);
                data_map2.put(entity.get被保険者番号().value(), map2);
            }
        }
        List<IdouChuukannKooGakuTempEntity> リスト2 = new ArrayList<>();
        for (List<IdouChuukannKooGakuTempEntity> keys : data_map2.values()) {
            リスト2.add(keys.get(0));
        }
        for (IdouChuukannKooGakuTempEntity list2 : リスト2) {
            for (KyodoShoriKooGakuTempEntity list : リスト) {
                if (!list2.get被保険者番号().equals(list.get被保険者番号()) && 異動年月日.isBeforeOrEquals(list2.get異動年月日())) {
                    KyodoShoriKooGakuTempEntity entity = new KyodoShoriKooGakuTempEntity();
                    entity.set異動年月日(list2.get異動年月日());
                    entity.set異動区分コード(JukyushaIF_IdoKubunCode.toValue(list2.get異動区分コード()).get名称());
                    entity.set受給者異動事由(list2.get受給者異動事由());
                    entity.set証記載保険者番号(list2.get証記載保険者番号());
                    entity.set被保険者番号(list2.get被保険者番号());
                    entity.set世帯集約番号(list2.get世帯集約番号());
                    entity.set世帯所得区分コード(list2.get世帯所得区分コード());
                    entity.set所得区分コード(list2.get所得区分コード());
                    entity.set老齢福祉年金受給有フラグ(list2.is老齢福祉年金受給有フラグ());
                    entity.set利用者負担第２段階有フラグ(list2.is利用者負担第２段階有フラグ());
                    entity.set支給申請書出力有フラグ(list2.is支給申請書出力有フラグ());
                    送付対象リスト.add(entity);
                }
            }
        }
        JukyushaIdoRenrakuhyoOutCSV.createInstance().csvの出力(new ArrayList<KyodoShoriKihonSofuTempEntity>(),
                new ArrayList<KyodoShoriShouKannTempEntity>(), 送付対象リスト);
    }

    private RString get高額変更項目(KyodoShoriKooGakuTempEntity 共同処理用受給者異動高額送付,
            IdouChuukannKooGakuTempEntity 異動中間高額送付一時) {
        RStringBuilder builder = new RStringBuilder();
        if (!共同処理用受給者異動高額送付.get証記載保険者番号().equals(異動中間高額送付一時.get証記載保険者番号())) {
            builder.append(証記載保険者番号);
        }
        if (!異動中間高額送付一時.get世帯集約番号().equals(共同処理用受給者異動高額送付.get世帯集約番号())) {
            builder.append(世帯集約番号);
        }
        if (!異動中間高額送付一時.get世帯所得区分コード().equals(共同処理用受給者異動高額送付.get世帯所得区分コード())) {
            builder.append(世帯所得区分コード);
        }
        if (!異動中間高額送付一時.get所得区分コード().equals(共同処理用受給者異動高額送付.get所得区分コード())) {
            builder.append(所得区分コード);
        }
        if (異動中間高額送付一時.is老齢福祉年金受給有フラグ() != 共同処理用受給者異動高額送付.is老齢福祉年金受給有フラグ()) {
            builder.append(老齢福祉年金受給有フラグ);
        }
        if (異動中間高額送付一時.is利用者負担第２段階有フラグ() != 共同処理用受給者異動高額送付.is利用者負担第２段階有フラグ()) {
            builder.append(利用者負担第２段階有フラグ);
        }
        return builder.toRString();
    }
}
