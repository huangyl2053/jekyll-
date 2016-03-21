/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.honsanteiidokanendofukakakutei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.KoseiTsukiHantei;
import jp.co.ndensan.reams.db.dbb.business.honsanteiidokanendofukakakutei.KanendoIdoFukaKakutei;
import jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHohoKibetsu;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.honsanteiidokanendofukakakutei.FukaKakuteiParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kanendoidofukakakutei.KanendoIdoFukaKakuteiEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2002FukaDac;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2003KibetsuDac;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.honsanteiidokanendofukakakutei.IFukaKakuteiMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KanendoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.service.core.dbbusinessconfig.DbBusinessConifg;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.UrT0705ChoteiKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.UrT0705ChoteiKyotsuDac;
import jp.co.ndensan.reams.ur.urc.entity.db.basic.shuno.chotei.UrT0706ChoteigakuUchiwakeEntity;
import jp.co.ndensan.reams.ur.urc.entity.db.basic.shuno.chotei.UrT0707ChoteiJokyoEntity;
import jp.co.ndensan.reams.ur.urc.entity.db.basic.shuno.shunokanri.UrT0700ShunoKanriEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 本算定異動（過年度）賦課確定（削除込）用クラスです
 */
public class HonsanteiIdoKanendoFukaKakutei {

    private final MapperProvider mapperProvider;
    DbT7022ShoriDateKanriDac shoriDateKanriDac;
    DbT2002FukaDac fukaDac;
    DbT2003KibetsuDac kibetsuDac;
    UrT0705ChoteiKyotsuDac choteiKyotsuDac;
    private static final RString 連番 = new RString("0001");
    private static final RString 処理枝番 = new RString("0001");
    private static final RString FORMAT = new RString("%04d");
    private static final SubGyomuCode サブ業務コード = new SubGyomuCode("DBB");

    /**
     * HonsanteiIdoKanendoFukaKakutei
     */
    public HonsanteiIdoKanendoFukaKakutei() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        shoriDateKanriDac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
        fukaDac = InstanceProvider.create(DbT2002FukaDac.class);
        choteiKyotsuDac = InstanceProvider.create(UrT0705ChoteiKyotsuDac.class);
        kibetsuDac = InstanceProvider.create(DbT2003KibetsuDac.class);
    }

    /**
     * 異動処理日付取得する
     *
     * @param 調定年度 FlexibleYear
     * @return 処理日付管理entity 取得できない場合、NULLを返す
     */
    public ShoriDateKanri getIdoKijunbi(FlexibleYear 調定年度) {
        DbT7022ShoriDateKanriEntity shoriDateKanri = shoriDateKanriDac.select最新の基準日(調定年度);
        if (shoriDateKanri == null) {
            return null;
        }
        return new ShoriDateKanri(shoriDateKanri);
    }

    /**
     * 確定処理日付取得する
     *
     * @param 調定年度 FlexibleYear
     * @return 処理日付管理entity 取得できない場合、NULLを返す
     */
    public ShoriDateKanri getKakuteiKijunbi(FlexibleYear 調定年度) {
        DbT7022ShoriDateKanriEntity shoriDateKanri = shoriDateKanriDac.select確定の最新の基準日(調定年度);
        if (shoriDateKanri == null) {
            return null;
        }
        return new ShoriDateKanri(shoriDateKanri);
    }

    /**
     * 異動賦課対象取得する
     *
     * @param 調定日時 YMDHMS
     * @return 処理日付管理entity 取得できない場合、サイズがゼロのリストを返す
     */
    public List<KanendoIdoFukaKakutei> getIdoFukaTaisho(YMDHMS 調定日時) {
        List<KanendoIdoFukaKakutei> fukaKakuteiList = new ArrayList<>();
        IFukaKakuteiMapper mapper = mapperProvider.create(IFukaKakuteiMapper.class);
        KoseiTsukiHantei koseiTsukiHantei = new KoseiTsukiHantei();
        Kitsuki kitsuki = koseiTsukiHantei.find更正月(調定日時.getRDateTime().getDate());
        FukaKakuteiParameter parameter = new FukaKakuteiParameter(
                FlexibleYear.EMPTY,
                FlexibleYear.EMPTY,
                TsuchishoNo.EMPTY,
                0,
                kitsuki.get期AsInt(),
                new RString(ChoshuHohoKibetsu.普通徴収.getコード().toString()),
                調定日時);
        List<KanendoIdoFukaKakuteiEntity> fukaList = mapper.select更新後の賦課内容(parameter);

        if (fukaList == null || fukaList.isEmpty()) {
            return new ArrayList<>();
        }
        for (KanendoIdoFukaKakuteiEntity fuka : fukaList) {
            fukaKakuteiList.add(new KanendoIdoFukaKakutei(fuka));
        }
        KanendoKiUtil kanendoKiUtil = new KanendoKiUtil();
        int koseiKi;
        for (KanendoIdoFukaKakutei idofukaKakutei : fukaKakuteiList) {
            if (idofukaKakutei.getFukaKakuteiEntity().get更正月() != null) {
                switch (idofukaKakutei.getFukaKakuteiEntity().get更正月().toString()) {
                    case "01":
                        koseiKi = kanendoKiUtil.get期月リスト().get月の期(Tsuki._1月).get期AsInt();
                        break;
                    case "02":
                        koseiKi = kanendoKiUtil.get期月リスト().get月の期(Tsuki._2月).get期AsInt();
                        break;
                    case "03":
                        koseiKi = kanendoKiUtil.get期月リスト().get月の期(Tsuki._3月).get期AsInt();
                        break;
                    case "04":
                        koseiKi = kanendoKiUtil.get期月リスト().get月の期(Tsuki._4月).get期AsInt();
                        break;
                    case "05":
                        koseiKi = kanendoKiUtil.get期月リスト().get月の期(Tsuki._5月).get期AsInt();
                        break;
                    case "06":
                        koseiKi = kanendoKiUtil.get期月リスト().get月の期(Tsuki._6月).get期AsInt();
                        break;
                    case "07":
                        koseiKi = kanendoKiUtil.get期月リスト().get月の期(Tsuki._7月).get期AsInt();
                        break;
                    case "08":
                        koseiKi = kanendoKiUtil.get期月リスト().get月の期(Tsuki._8月).get期AsInt();
                        break;
                    case "09":
                        koseiKi = kanendoKiUtil.get期月リスト().get月の期(Tsuki._9月).get期AsInt();
                        break;
                    case "10":
                        koseiKi = kanendoKiUtil.get期月リスト().get月の期(Tsuki._10月).get期AsInt();
                        break;
                    case "11":
                        koseiKi = kanendoKiUtil.get期月リスト().get月の期(Tsuki._11月).get期AsInt();
                        break;
                    case "12":
                        koseiKi = kanendoKiUtil.get期月リスト().get月の期(Tsuki._12月).get期AsInt();
                        break;
                    case "14":
                        koseiKi = kanendoKiUtil.get期月リスト().get月の期(Tsuki.翌年度4月).get期AsInt();
                        break;
                    case "15":
                        koseiKi = kanendoKiUtil.get期月リスト().get月の期(Tsuki.翌年度5月).get期AsInt();
                        break;
                    default:
                        koseiKi = 0;
                        break;
                }
                set納付額と納期限(parameter, idofukaKakutei, mapper, koseiKi);
            }
            List<DbT2002FukaEntity> dbtFukaList = fukaDac.select更正前のデータ(idofukaKakutei.getFukaKakuteiEntity().
                    get通知書番号());
            if (dbtFukaList != null && !dbtFukaList.isEmpty()) {
                set更正前項目(dbtFukaList, idofukaKakutei);
            }
        }
        return fukaKakuteiList;
    }

    private void set納付額と納期限(FukaKakuteiParameter parameter,
            KanendoIdoFukaKakutei idofukaKakutei,
            IFukaKakuteiMapper mapper,
            int koseiKi) {
        if (koseiKi != 0) {
            parameter = new FukaKakuteiParameter(
                    idofukaKakutei.getFukaKakuteiEntity().get調定年度(),
                    idofukaKakutei.getFukaKakuteiEntity().get賦課年度(),
                    idofukaKakutei.getFukaKakuteiEntity().get通知書番号(),
                    idofukaKakutei.getFukaKakuteiEntity().get履歴番号(),
                    koseiKi,
                    ChoshuHohoKibetsu.特別徴収.getコード(),
                    YMDHMS.now());
            UrT0705ChoteiKyotsuEntity choteiKyotsuEntity = mapper.select納付額と納期限(parameter);
            if (choteiKyotsuEntity != null) {
                set納付額と納期限(choteiKyotsuEntity, idofukaKakutei);
            }
        }
    }

    private void set納付額と納期限(UrT0705ChoteiKyotsuEntity choteiKyotsuEntity, KanendoIdoFukaKakutei idofukaKakutei) {
        idofukaKakutei.getFukaKakuteiEntity().set調定額(choteiKyotsuEntity.getChoteigaku());
        if (choteiKyotsuEntity.getNokigenYMD() != null) {
            idofukaKakutei.getFukaKakuteiEntity().set納期限(choteiKyotsuEntity.getNokigenYMD());
        }
    }

    private void set更正前項目(List<DbT2002FukaEntity> dbtFukaList, KanendoIdoFukaKakutei idofukaKakutei) {
        DbT2002FukaEntity dbtFukaEntity;
        for (int i = 0; i < dbtFukaList.size() - 1; i++) {
            dbtFukaEntity = dbtFukaList.get(i);
            if (dbtFukaEntity.getChoteiNendo().equals(idofukaKakutei.getFukaKakuteiEntity().get調定年度())
                    && dbtFukaEntity.getFukaNendo().equals(idofukaKakutei.getFukaKakuteiEntity().get賦課年度())
                    && dbtFukaEntity.getTsuchishoNo().equals(idofukaKakutei.getFukaKakuteiEntity().get通知書番号())
                    && dbtFukaEntity.getRirekiNo() == idofukaKakutei.getFukaKakuteiEntity().get履歴番号()) {
                dbtFukaEntity = dbtFukaList.get(i + 1);
                idofukaKakutei.getFukaKakuteiEntity().set更正前調定年度(dbtFukaEntity.getChoteiNendo());
                idofukaKakutei.getFukaKakuteiEntity().set更正前賦課年度(dbtFukaEntity.getFukaNendo());
                if (dbtFukaEntity.getHokenryoDankai1() != null) {
                    idofukaKakutei.getFukaKakuteiEntity().set更正前保険料算定段階１(dbtFukaEntity.getHokenryoDankai1());
                }
                idofukaKakutei.getFukaKakuteiEntity().set更正前算定年額保険料１(dbtFukaEntity.
                        getNengakuHokenryo1());
                if (dbtFukaEntity.getHokenryoDankai2() != null) {
                    idofukaKakutei.getFukaKakuteiEntity().set更正前保険料算定段階２(dbtFukaEntity.
                            getHokenryoDankai2());
                }
                idofukaKakutei.getFukaKakuteiEntity().set更正前算定年額保険料２(dbtFukaEntity.
                        getNengakuHokenryo2());
                idofukaKakutei.getFukaKakuteiEntity().set更正前減免額(dbtFukaEntity.
                        getNengakuHokenryo2());
                idofukaKakutei.getFukaKakuteiEntity().set更正前確定介護保険料(dbtFukaEntity.getKakuteiHokenryo());
            }
        }
    }

    /**
     * 賦課削除する
     *
     * @param fukaKakuteiList List<KanendoIdoFukaKakutei>
     * @param deleteFlag boolean
     */
    @Transaction
    public void deleteFuka(List<KanendoIdoFukaKakutei> fukaKakuteiList, boolean deleteFlag) {
        IFukaKakuteiMapper mapper = mapperProvider.create(IFukaKakuteiMapper.class);
        for (KanendoIdoFukaKakutei fukaKakutei : fukaKakuteiList) {
            FukaKakuteiParameter parameter = new FukaKakuteiParameter(
                    fukaKakutei.getFukaKakuteiEntity().get調定年度(),
                    fukaKakutei.getFukaKakuteiEntity().get賦課年度(),
                    fukaKakutei.getFukaKakuteiEntity().get通知書番号(),
                    fukaKakutei.getFukaKakuteiEntity().get履歴番号(),
                    0,
                    null,
                    null);
            Map<String, Object> deleteParameter = new HashMap<>();
            List<UrT0700ShunoKanriEntity> shunoKanriList = mapper.select収納管理マスタ(parameter);
            if (shunoKanriList != null) {
                for (UrT0700ShunoKanriEntity shunoKanriEntity : shunoKanriList) {
                    deleteParameter.put("shunoId", shunoKanriEntity.getShunoId());
                    mapper.delete収納管理マスタ(deleteParameter);
                }
            }

            List<UrT0707ChoteiJokyoEntity> choteiJokyoList = mapper.select調定状況(parameter);
            if (choteiJokyoList != null) {
                for (UrT0707ChoteiJokyoEntity choteiJokyoEntity : choteiJokyoList) {
                    deleteParameter.put("choteiJokyoId", choteiJokyoEntity.getChoteiJokyoId());
                    mapper.delete調定状況(deleteParameter);
                }
            }

            List<UrT0706ChoteigakuUchiwakeEntity> choteigakuUchiwakeList = mapper.select調定額内訳(parameter);
            if (choteigakuUchiwakeList != null) {
                for (UrT0706ChoteigakuUchiwakeEntity choteigakuUchiwakeEntity : choteigakuUchiwakeList) {
                    deleteParameter.put("choteiId", choteigakuUchiwakeEntity.getChoteiId());
                    mapper.delete調定額内訳(deleteParameter);
                }
            }

            List<UrT0705ChoteiKyotsuEntity> choteiKyotsuList = mapper.select調定共通(parameter);
            if (choteiKyotsuList != null) {
                for (UrT0705ChoteiKyotsuEntity choteiKyotsuEntity : choteiKyotsuList) {
                    choteiKyotsuEntity.setState(EntityDataState.Deleted);
                    choteiKyotsuDac.deletePhysicalBy(choteiKyotsuEntity);
                }
            }

            DbT2002FukaEntity fukaEntity = fukaDac.selectByKey(
                    fukaKakutei.getFukaKakuteiEntity().get調定年度(),
                    fukaKakutei.getFukaKakuteiEntity().get賦課年度(),
                    fukaKakutei.getFukaKakuteiEntity().get通知書番号(),
                    fukaKakutei.getFukaKakuteiEntity().get履歴番号());
            if (fukaEntity != null) {
                fukaEntity.setState(EntityDataState.Deleted);
                fukaDac.delete(fukaEntity);
            }

            List<DbT2003KibetsuEntity> kibetsuList = kibetsuDac.select介護期別(
                    fukaKakutei.getFukaKakuteiEntity().get調定年度(),
                    fukaKakutei.getFukaKakuteiEntity().get賦課年度(),
                    fukaKakutei.getFukaKakuteiEntity().get通知書番号(),
                    fukaKakutei.getFukaKakuteiEntity().get履歴番号());
            if (kibetsuList != null) {
                for (DbT2003KibetsuEntity kibetsuEntity : kibetsuList) {
                    kibetsuEntity.setState(EntityDataState.Deleted);
                    kibetsuDac.delete(kibetsuEntity);
                }
            }
        }
        if (deleteFlag) {
            save処理日付管理(fukaKakuteiList.get(0).getFukaKakuteiEntity().get調定年度());
        }
    }

    /**
     * 賦課確定
     *
     * @param 調定日時 YMDHMS
     */
    @Transaction
    public void confirmFuka(YMDHMS 調定日時) {
        IFukaKakuteiMapper mapper = mapperProvider.create(IFukaKakuteiMapper.class);
        FukaKakuteiParameter parameter = new FukaKakuteiParameter(
                FlexibleYear.EMPTY,
                FlexibleYear.EMPTY,
                TsuchishoNo.EMPTY,
                0,
                0,
                RString.EMPTY,
                調定日時);
        List<UrT0705ChoteiKyotsuEntity> choteiKyotsuList = mapper.select調定共通ForUpdate(parameter);
        if (choteiKyotsuList != null && !choteiKyotsuList.isEmpty()) {
            for (UrT0705ChoteiKyotsuEntity choteiKyotsuEntity : choteiKyotsuList) {
                choteiKyotsuEntity.setFukaShoriJokyo(true);
                choteiKyotsuEntity.setState(EntityDataState.Modified);
                choteiKyotsuDac.update(choteiKyotsuEntity);
            }
        }
        // TODO QA310 調定年度
        save処理日付管理(FlexibleYear.MAX);
    }

    @Transaction
    private void save処理日付管理(FlexibleYear 調定年度) {
        RString choteiNendo = DbBusinessConifg.get(ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(),
                SubGyomuCode.DBB介護賦課);

        DbT7022ShoriDateKanriEntity shoriDateKanriEntity = shoriDateKanriDac.select最大年度内連番(
                new FlexibleYear(choteiNendo.toString()));
        RString 最大年度内連番 = 連番;
        if (shoriDateKanriEntity != null) {
            最大年度内連番 = new RString(String.format(FORMAT.toString(), new Integer(Integer.parseInt(shoriDateKanriEntity.
                    getNendoNaiRenban().toString()) + 1)));
        }
        DbT7022ShoriDateKanriEntity entity = new DbT7022ShoriDateKanriEntity();
        entity.setSubGyomuCode(サブ業務コード);
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        entity.setShichosonCode(導入団体クラス.getLasdecCode_());
        entity.setShoriName(ShoriName.過年度賦課確定.get名称());
        entity.setShoriEdaban(処理枝番);
        entity.setNendo(調定年度);
        entity.setNendoNaiRenban(最大年度内連番);
        entity.setKijunYMD(FlexibleDate.getNowDate());
        entity.setKijunTimestamp(YMDHMS.now());
        entity.setState(EntityDataState.Added);
        shoriDateKanriDac.save(entity);
    }
}
