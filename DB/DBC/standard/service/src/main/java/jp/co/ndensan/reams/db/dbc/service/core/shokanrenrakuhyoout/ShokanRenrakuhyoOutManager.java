/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.shokanrenrakuhyoout;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc110050.ShokanRenrakuhyoOutMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050.DbWT2111ShokanShinseiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050.DbWT2112ShokanMeisaiTempEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc110050.IShokanRenrakuhyoOutMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 償還連絡票情報作成の共通処理クラスです。
 *
 * @reamsid_L DBC-2570-030 wangxue
 */
public class ShokanRenrakuhyoOutManager {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    ShokanRenrakuhyoOutManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した
     *
     * @return ShokanRenrakuhyoOutManager
     */
    public static ShokanRenrakuhyoOutManager createInstance() {
        return InstanceProvider.create(ShokanRenrakuhyoOutManager.class);
    }

    /**
     * 被保険者一時情報を設定する。
     *
     * @param tempEntity DbWT2112ShokanMeisaiTempEntity
     * @param entity DbWT1001HihokenshaTempEntity
     */
    public void set被保険者一時情報(DbWT2112ShokanMeisaiTempEntity tempEntity, DbWT1001HihokenshaTempEntity entity) {
        tempEntity.setExRenban(entity.getExRenban());
        tempEntity.setExHokenshaNo(entity.getExHokenshaNo());
        tempEntity.setExHokenshaName(entity.getExHokenshaName());
        tempEntity.setExShoHokenshaNo(entity.getExShoHokenshaNo());
        tempEntity.setExHihokenshaNo(entity.getExHihokenshaNo());
        tempEntity.setExServiceTeikyoYm(entity.getExServiceTeikyoYm());
        tempEntity.setHenkanFlag(entity.isHenkanFlag());
        tempEntity.setOldShichosonCode(entity.getOldShichosonCode());
        tempEntity.setSofuHihokenshaNo(entity.getSofuHihokenshaNo());
        tempEntity.setShichosonCode(entity.getShichosonCode());
        tempEntity.setKannaiKangaiKubun(entity.getKannaiKangaiKubun());
        tempEntity.setYubinNo(entity.getYubinNo());
        tempEntity.setChoikiCode(entity.getChoikiCode());
        tempEntity.setGyoseikuCode(entity.getGyoseikuCode());
        tempEntity.setGyoseikuMei(entity.getGyoseikuMei());
        tempEntity.setJusho(entity.getJusho());
        tempEntity.setBanchi(entity.getBanchi());
        tempEntity.setKatagaki(entity.getKatagaki());
        tempEntity.setKanaMeisho(entity.getKanaMeisho());
        tempEntity.setMeisho(entity.getMeisho());
        tempEntity.setShimei50onKana(entity.getShimei50onKana());
        tempEntity.setShikibetsuCode(entity.getShikibetsuCode());
        tempEntity.setShikakuShutokuYmd(entity.getShikakuShutokuYmd());
        tempEntity.setShikakuShutokuJiyuCode(entity.getShikakuShutokuJiyuCode());
        tempEntity.setShikakuSoshitsuYmd(entity.getShikakuSoshitsuYmd());
        tempEntity.setShikakuSoshitsuJiyuCode(entity.getShikakuSoshitsuJiyuCode());
        tempEntity.setSetaiShuyakuNo(entity.getSetaiShuyakuNo());
        tempEntity.setSeinenYmd(entity.getSeinenYmd());
        tempEntity.setSeibetsuCode(entity.getSeibetsuCode());
        tempEntity.setShichosonKanyuYmd(entity.getShichosonKanyuYmd());
        tempEntity.setShichosonDattaiYmd(entity.getShichosonDattaiYmd());
    }

    /**
     * 償還払支給申請一時情報を設定する。
     *
     * @param tempEntity DbWT2112ShokanMeisaiTempEntity
     * @param entity DbWT2111ShokanShinseiTempEntity
     */
    public void set償還払支給申請一時情報(DbWT2112ShokanMeisaiTempEntity tempEntity, DbWT2111ShokanShinseiTempEntity entity) {
        tempEntity.setDbwt2111_renban(entity.getRenban());
        tempEntity.setDbwt2111_hiHokenshaNo(entity.getHiHokenshaNo());
        tempEntity.setDbwt2111_serviceTeikyoYM(entity.getServiceTeikyoYM());
        tempEntity.setDbwt2111_seiriNo(entity.getSeiriNo());
        tempEntity.setDbwt2111_jizenSeiriNo(entity.getJizenSeiriNo());
        tempEntity.setDbwt2111_jizenServiceTeikyoYM(entity.getJizenServiceTeikyoYM());
        tempEntity.setDbwt2111_riyoshaFutangaku(entity.getRiyoshaFutangaku());
        tempEntity.setShoKisaiHokenshaNo(entity.getShoKisaiHokenshaNo());
        tempEntity.setUketsukeYMD(entity.getUketsukeYMD());
        tempEntity.setShinseiYMD(entity.getShinseiYMD());
        tempEntity.setShinseiRiyu(entity.getShinseiRiyu());
        tempEntity.setShinseishaKubun(entity.getShinseishaKubun());
        tempEntity.setShinseishaNameKanji(entity.getShinseishaNameKanji());
        tempEntity.setShinseishaNameKana(entity.getShinseishaNameKana());
        tempEntity.setShinseishaYubinNo(entity.getShinseishaYubinNo());
        tempEntity.setShinseishaAddress(entity.getShinseishaAddress());
        tempEntity.setShinseishaTelNo(entity.getShinseishaTelNo());
        tempEntity.setShinseiJigyoshaNo(entity.getShinseiJigyoshaNo());
        tempEntity.setRiyushoSakuseiYMD(entity.getRiyushoSakuseiYMD());
        tempEntity.setRiyushoSakuseishaName(entity.getRiyushoSakuseishaName());
        tempEntity.setRiyushoSakuseishaKanaName(entity.getRiyushoSakuseishaKanaName());
        tempEntity.setRiyushoSakuseiJigyoshaNo(entity.getRiyushoSakuseiJigyoshaNo());
        tempEntity.setShiharaiKingakuTotal(entity.getShiharaiKingakuTotal());
        tempEntity.setHokenTaishoHiyogaku(entity.getHokenTaishoHiyogaku());
        tempEntity.setHokenKyufugaku(entity.getHokenKyufugaku());
        tempEntity.setShikyuShinseiShinsaKubun(entity.getShikyuShinseiShinsaKubun());
        tempEntity.setShinsaHohoKubun(entity.getShinsaHohoKubun());
        tempEntity.setSofuKubun(entity.getSofuKubun());
        tempEntity.setSofuYM(entity.getSofuYM());
        tempEntity.setKokuhorenSaisofuFlag(entity.isKokuhorenSaisofuFlag());
        tempEntity.setShiharaiHohoKubunCode(entity.getShiharaiHohoKubunCode());
        tempEntity.setShiharaiBasho(entity.getShiharaiBasho());
        tempEntity.setShiharaiKaishiYMD(entity.getShiharaiKaishiYMD());
        tempEntity.setShiharaiShuryoYMD(entity.getShiharaiShuryoYMD());
        tempEntity.setShiharaiKaishiTime(entity.getShiharaiKaishiTime());
        tempEntity.setShiharaiShuryoTime(entity.getShiharaiShuryoTime());
        tempEntity.setKozaID(entity.getKozaID());
        tempEntity.setJuryoininKeiyakuNo(entity.getJuryoininKeiyakuNo());
        tempEntity.setJutakuShoyusha(entity.getJutakuShoyusha());
        tempEntity.setHihokenshaKankei(entity.getHihokenshaKankei());
        tempEntity.setYokaigo3DankaiHenko(entity.isYokaigo3DankaiHenko());
        tempEntity.setJutakuJushoHenko(entity.isJutakuJushoHenko());
        tempEntity.setShinsaYMD(entity.getShinsaYMD());
        tempEntity.setShinsaKekka(entity.getShinsaKekka());
        tempEntity.setKaishuShinseiKubun(entity.getKaishuShinseiKubun());
        tempEntity.setKaishuShinseiTorikeshijiyuCode(entity.getKaishuShinseiTorikeshijiyuCode());
        tempEntity.setRyoshuYMD(entity.getRyoshuYMD());
        tempEntity.setSofuJogaiFlag(entity.isSofuJogaiFlag());
        tempEntity.setHokenshaNo(entity.getHokenshaNo());
        tempEntity.setHokenshaName(entity.getHokenshaName());
        tempEntity.setJukyushaDaichoFlag(entity.isJukyushaDaichoFlag());
        tempEntity.setKyuSochishaFlag(entity.isKyuSochishaFlag());
        tempEntity.setYokaigoJotaiKubunCode(entity.getYokaigoJotaiKubunCode());
        tempEntity.setNinteiYukoKikanKaishiYMD(entity.getNinteiYukoKikanKaishiYMD());
        tempEntity.setNinteiYukoKikanShuryoYMD(entity.getNinteiYukoKikanShuryoYMD());
    }

    /**
     * 送付ファイルのレコード件数を取得する。
     *
     * @param parameter ShokanRenrakuhyoOutMybatisParameter
     * @return レコード件数
     */
    public int getレコード件数(ShokanRenrakuhyoOutMybatisParameter parameter) {
        IShokanRenrakuhyoOutMapper mapper = mapperProvider.create(IShokanRenrakuhyoOutMapper.class);
        return mapper.get送付ファイルのレコード件数(parameter);
    }

}
