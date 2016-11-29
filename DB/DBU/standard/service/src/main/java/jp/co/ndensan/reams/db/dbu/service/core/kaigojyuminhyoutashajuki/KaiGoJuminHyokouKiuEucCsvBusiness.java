/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.core.kaigojyuminhyoutashajuki;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.processprm.kaigojyuminhyokoukiu.KaiGoJuminHyokouKiuProcessParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kaigojuminhyo.KaigoJuminhyoRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kaigojuminhyokobetsujikou.KaigoJuminhyoEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kaigojyuminhyoutashajuki.KaigoJyuminhyouTashajukiDateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 介護住民票個別事項連携情報作成【広域運用】の処理です。
 *
 * @reamsid_L DBU-0550-020 wanghui
 *
 */
public class KaiGoJuminHyokouKiuEucCsvBusiness {

    private List<KaigoJuminhyoEntity> kaigoJuminhyoEntityList = new ArrayList<>();
    private static final RString 日付 = new RString("yyyyMMddHHmmssSSS");

    /**
     * 介護住民票個別事項連携情報作成【広域運用】の処理です。
     *
     * @param entity KaigoJuminhyoRelateEntity
     * @return KaigoJuminhyoEntity
     */
    public KaigoJuminhyoEntity setKaigoJuminhyoEntity(KaigoJuminhyoRelateEntity entity) {
        KaigoJuminhyoEntity kaigoJuminhyoEntity = new KaigoJuminhyoEntity();
        kaigoJuminhyoEntity.setHihokenshaNo(entity.getDbT1001HihokenshaDaichoEntity().getHihokenshaNo());
        kaigoJuminhyoEntity.setIdoYMD(entity.getDbT1001HihokenshaDaichoEntity().getIdoYMD());
        kaigoJuminhyoEntity.setEdaNo(entity.getDbT1001HihokenshaDaichoEntity().getEdaNo());
        kaigoJuminhyoEntity.setIdoJiyuCode(entity.getDbT1001HihokenshaDaichoEntity().getIdoJiyuCode());
        kaigoJuminhyoEntity.setShichosonCode(entity.getDbT1001HihokenshaDaichoEntity().getShichosonCode());
        kaigoJuminhyoEntity.setShikibetsuCode(entity.getDbT1001HihokenshaDaichoEntity().getShikibetsuCode());
        kaigoJuminhyoEntity.setShikakuShutokuJiyuCode(entity.getDbT1001HihokenshaDaichoEntity().getShikakuShutokuJiyuCode());
        kaigoJuminhyoEntity.setShikakuShutokuYMD(entity.getDbT1001HihokenshaDaichoEntity().getShikakuShutokuYMD());
        kaigoJuminhyoEntity.setShikakuShutokuTodokedeYMD(entity.getDbT1001HihokenshaDaichoEntity().getShikakuShutokuTodokedeYMD());
        kaigoJuminhyoEntity.setIchigoShikakuShutokuYMD(entity.getDbT1001HihokenshaDaichoEntity().getIchigoShikakuShutokuYMD());
        kaigoJuminhyoEntity.setHihokennshaKubunCode(entity.getDbT1001HihokenshaDaichoEntity().getHihokennshaKubunCode());
        kaigoJuminhyoEntity.setShikakuSoshitsuJiyuCode(entity.getDbT1001HihokenshaDaichoEntity().getShikakuSoshitsuJiyuCode());
        kaigoJuminhyoEntity.setShikakuSoshitsuYMD(entity.getDbT1001HihokenshaDaichoEntity().getShikakuSoshitsuYMD());
        kaigoJuminhyoEntity.setShikakuSoshitsuTodokedeYMD(entity.getDbT1001HihokenshaDaichoEntity().getShikakuSoshitsuTodokedeYMD());
        kaigoJuminhyoEntity.setShikakuHenkoJiyuCode(entity.getDbT1001HihokenshaDaichoEntity().getShikakuHenkoJiyuCode());
        kaigoJuminhyoEntity.setShikakuHenkoYMD(entity.getDbT1001HihokenshaDaichoEntity().getShikakuHenkoYMD());
        kaigoJuminhyoEntity.setShikakuHenkoTodokedeYMD(entity.getDbT1001HihokenshaDaichoEntity().getShikakuHenkoTodokedeYMD());
        kaigoJuminhyoEntity.setJushochitokureiTekiyoJiyuCode(entity.getDbT1001HihokenshaDaichoEntity().getJushochitokureiTekiyoJiyuCode());
        kaigoJuminhyoEntity.setJushochitokureiTekiyoYMD(entity.getDbT1001HihokenshaDaichoEntity().getJushochitokureiTekiyoYMD());
        kaigoJuminhyoEntity.setJushochitokureiTekiyoTodokedeYMD(entity.getDbT1001HihokenshaDaichoEntity().getJushochitokureiTekiyoTodokedeYMD());
        kaigoJuminhyoEntity.setJushochitokureiKaijoJiyuCode(entity.getDbT1001HihokenshaDaichoEntity().getJushochitokureiKaijoJiyuCode());
        kaigoJuminhyoEntity.setJushochitokureiKaijoYMD(entity.getDbT1001HihokenshaDaichoEntity().getJushochitokureiKaijoYMD());
        kaigoJuminhyoEntity.setJushochitokureiKaijoTodokedeYMD(entity.getDbT1001HihokenshaDaichoEntity().getJushochitokureiKaijoTodokedeYMD());
        kaigoJuminhyoEntity.setJushochiTokureiFlag(entity.getDbT1001HihokenshaDaichoEntity().getJushochiTokureiFlag());
        kaigoJuminhyoEntity.setKoikinaiJushochiTokureiFlag(entity.getDbT1001HihokenshaDaichoEntity().getKoikinaiJushochiTokureiFlag());
        kaigoJuminhyoEntity.setKoikinaiTokureiSochimotoShichosonCode(
                entity.getDbT1001HihokenshaDaichoEntity().getKoikinaiTokureiSochimotoShichosonCode());
        kaigoJuminhyoEntity.setKyuShichosonCode(entity.getDbT1001HihokenshaDaichoEntity().getKyuShichosonCode());
        kaigoJuminhyoEntity.setLogicalDeletedFlag(entity.getDbT1001HihokenshaDaichoEntity().getLogicalDeletedFlag());
        kaigoJuminhyoEntity.setInsertTimestamp(entity.getDbT1001HihokenshaDaichoEntity().getInsertTimestamp());
        kaigoJuminhyoEntity.setLastUpdateTimestamp(entity.getDbT1001HihokenshaDaichoEntity().getLastUpdateTimestamp());
        kaigoJuminhyoEntity.setDbT4001ShichosonCode(entity.getDbT4001JukyushaDaichoEntity().getShichosonCode());
        kaigoJuminhyoEntity.setDbT4001HihokenshaNo(entity.getDbT4001JukyushaDaichoEntity().getHihokenshaNo());
        kaigoJuminhyoEntity.setDbT4001RirekiNo(entity.getDbT4001JukyushaDaichoEntity().getRirekiNo());
        kaigoJuminhyoEntity.setDbT4001Edaban(entity.getDbT4001JukyushaDaichoEntity().getEdaban());
        kaigoJuminhyoEntity.setDbT4001ShinseishoKanriNo(entity.getDbT4001JukyushaDaichoEntity().getShinseishoKanriNo());
        kaigoJuminhyoEntity.setDbT4001ShinseiJokyoKubun(entity.getDbT4001JukyushaDaichoEntity().getShinseiJokyoKubun());
        kaigoJuminhyoEntity.setDbT4001ShishoCode(entity.getDbT4001JukyushaDaichoEntity().getShishoCode());
        kaigoJuminhyoEntity.setDbT4001ChokkinFlag(entity.getDbT4001JukyushaDaichoEntity().getChokkinFlag());
        kaigoJuminhyoEntity.setDbT4001ShikibetsuCode(entity.getDbT4001JukyushaDaichoEntity().getShikibetsuCode());
        kaigoJuminhyoEntity.setDbT4001JukyuShinseiJiyu(entity.getDbT4001JukyushaDaichoEntity().getJukyuShinseiJiyu());
        kaigoJuminhyoEntity.setDbT4001ShinseiRiyu(entity.getDbT4001JukyushaDaichoEntity().getShinseiRiyu());
        kaigoJuminhyoEntity.setDbT4001ShinseishaKankeiCode(entity.getDbT4001JukyushaDaichoEntity().getShinseishaKankeiCode());
        kaigoJuminhyoEntity.setDbT4001HomninKankei(entity.getDbT4001JukyushaDaichoEntity().getHomninKankei());
        kaigoJuminhyoEntity.setDbT4001JukyuShinseiYMD(entity.getDbT4001JukyushaDaichoEntity().getJukyuShinseiYMD());
        kaigoJuminhyoEntity.setDbT4001NigoTokuteiShippeiCode(entity.getDbT4001JukyushaDaichoEntity().getNigoTokuteiShippeiCode());
        kaigoJuminhyoEntity.setDbT4001ShinsakaiIraiYMD(entity.getDbT4001JukyushaDaichoEntity().getShinsakaiIraiYMD());
        kaigoJuminhyoEntity.setDbT4001YokaigoJotaiKubunCode(entity.getDbT4001JukyushaDaichoEntity().getYokaigoJotaiKubunCode());
        kaigoJuminhyoEntity.setDbT4001NinteiYukoKikanKaishiYMD(entity.getDbT4001JukyushaDaichoEntity().getNinteiYukoKikanKaishiYMD());
        kaigoJuminhyoEntity.setDbT4001NinteiYukoKikanShuryoYMD(entity.getDbT4001JukyushaDaichoEntity().getNinteiYukoKikanShuryoYMD());
        kaigoJuminhyoEntity.setDbT4001NinteiYMD(entity.getDbT4001JukyushaDaichoEntity().getNinteiYMD());
        kaigoJuminhyoEntity.setDbT4001ShiteiServiceShurui01(entity.getDbT4001JukyushaDaichoEntity().getShiteiServiceShurui01());
        kaigoJuminhyoEntity.setDbT4001ShiteiServiceShurui02(entity.getDbT4001JukyushaDaichoEntity().getShiteiServiceShurui02());
        kaigoJuminhyoEntity.setDbT4001ShiteiServiceShurui03(entity.getDbT4001JukyushaDaichoEntity().getShiteiServiceShurui03());
        kaigoJuminhyoEntity.setDbT4001ShiteiServiceShurui04(entity.getDbT4001JukyushaDaichoEntity().getShiteiServiceShurui04());
        kaigoJuminhyoEntity.setDbT4001ShiteiServiceShurui05(entity.getDbT4001JukyushaDaichoEntity().getShiteiServiceShurui05());
        kaigoJuminhyoEntity.setDbT4001ShiteiServiceShurui06(entity.getDbT4001JukyushaDaichoEntity().getShiteiServiceShurui06());
        kaigoJuminhyoEntity.setDbT4001ShiteiServiceShurui07(entity.getDbT4001JukyushaDaichoEntity().getShiteiServiceShurui07());
        kaigoJuminhyoEntity.setDbT4001ShiteiServiceShurui08(entity.getDbT4001JukyushaDaichoEntity().getShiteiServiceShurui08());
        kaigoJuminhyoEntity.setDbT4001ShiteiServiceShurui09(entity.getDbT4001JukyushaDaichoEntity().getShiteiServiceShurui09());
        kaigoJuminhyoEntity.setDbT4001ShiteiServiceShurui10(entity.getDbT4001JukyushaDaichoEntity().getShiteiServiceShurui10());
        kaigoJuminhyoEntity.setDbT4001ShiteiServiceShurui11(entity.getDbT4001JukyushaDaichoEntity().getShiteiServiceShurui11());
        kaigoJuminhyoEntity.setDbT4001ShiteiServiceShurui12(entity.getDbT4001JukyushaDaichoEntity().getShiteiServiceShurui12());
        kaigoJuminhyoEntity.setDbT4001ShiteiServiceShurui13(entity.getDbT4001JukyushaDaichoEntity().getShiteiServiceShurui13());
        kaigoJuminhyoEntity.setDbT4001ShiteiServiceShurui14(entity.getDbT4001JukyushaDaichoEntity().getShiteiServiceShurui14());
        kaigoJuminhyoEntity.setDbT4001ShiteiServiceShurui15(entity.getDbT4001JukyushaDaichoEntity().getShiteiServiceShurui15());
        kaigoJuminhyoEntity.setDbT4001ShiteiServiceShurui16(entity.getDbT4001JukyushaDaichoEntity().getShiteiServiceShurui16());
        kaigoJuminhyoEntity.setDbT4001ShiteiServiceShurui17(entity.getDbT4001JukyushaDaichoEntity().getShiteiServiceShurui17());
        kaigoJuminhyoEntity.setDbT4001ShiteiServiceShurui18(entity.getDbT4001JukyushaDaichoEntity().getShiteiServiceShurui18());
        kaigoJuminhyoEntity.setDbT4001ShiteiServiceShurui19(entity.getDbT4001JukyushaDaichoEntity().getShiteiServiceShurui19());
        kaigoJuminhyoEntity.setDbT4001ShiteiServiceShurui20(entity.getDbT4001JukyushaDaichoEntity().getShiteiServiceShurui20());
        kaigoJuminhyoEntity.setDbT4001ShiteiServiceShurui21(entity.getDbT4001JukyushaDaichoEntity().getShiteiServiceShurui21());
        kaigoJuminhyoEntity.setDbT4001ShiteiServiceShurui22(entity.getDbT4001JukyushaDaichoEntity().getShiteiServiceShurui22());
        kaigoJuminhyoEntity.setDbT4001ShiteiServiceShurui23(entity.getDbT4001JukyushaDaichoEntity().getShiteiServiceShurui23());
        kaigoJuminhyoEntity.setDbT4001ShiteiServiceShurui24(entity.getDbT4001JukyushaDaichoEntity().getShiteiServiceShurui24());
        kaigoJuminhyoEntity.setDbT4001ShiteiServiceShurui25(entity.getDbT4001JukyushaDaichoEntity().getShiteiServiceShurui25());
        kaigoJuminhyoEntity.setDbT4001ShiteiServiceShurui26(entity.getDbT4001JukyushaDaichoEntity().getShiteiServiceShurui26());
        kaigoJuminhyoEntity.setDbT4001ShiteiServiceShurui27(entity.getDbT4001JukyushaDaichoEntity().getShiteiServiceShurui27());
        kaigoJuminhyoEntity.setDbT4001ShiteiServiceShurui28(entity.getDbT4001JukyushaDaichoEntity().getShiteiServiceShurui28());
        kaigoJuminhyoEntity.setDbT4001ShiteiServiceShurui29(entity.getDbT4001JukyushaDaichoEntity().getShiteiServiceShurui29());
        kaigoJuminhyoEntity.setDbT4001ShiteiServiceShurui30(entity.getDbT4001JukyushaDaichoEntity().getShiteiServiceShurui30());
        kaigoJuminhyoEntity.setDbT4001SoshitsuYMD(entity.getDbT4001JukyushaDaichoEntity().getSoshitsuYMD());
        kaigoJuminhyoEntity.setDbT4001ChokkinIdoYMD(entity.getDbT4001JukyushaDaichoEntity().getChokkinIdoYMD());
        kaigoJuminhyoEntity.setDbT4001ChokkinIdoJiyuCode(entity.getDbT4001JukyushaDaichoEntity().getChokkinIdoJiyuCode());
        kaigoJuminhyoEntity.setDbT4001YukoMukoKubun(entity.getDbT4001JukyushaDaichoEntity().getYukoMukoKubun());
        kaigoJuminhyoEntity.setDbT4001DataKubun(entity.getDbT4001JukyushaDaichoEntity().getDataKubun());
        kaigoJuminhyoEntity.setDbT4001Remban(entity.getDbT4001JukyushaDaichoEntity().getRemban());
        kaigoJuminhyoEntity.setDbT4001IdoRiyu(entity.getDbT4001JukyushaDaichoEntity().getIdoRiyu());
        kaigoJuminhyoEntity.setDbT4001ShinseishoKubun(entity.getDbT4001JukyushaDaichoEntity().getShinseishoKubun());
        kaigoJuminhyoEntity.setDbT4001SakujoJiyuCode(entity.getDbT4001JukyushaDaichoEntity().getSakujoJiyuCode());
        kaigoJuminhyoEntity.setDbT4001YoshienshaNinteiShinseiFlag(entity.getDbT4001JukyushaDaichoEntity().getYoshienshaNinteiShinseiFlag());
        kaigoJuminhyoEntity.setDbT4001ShikyuGendoTanisu(entity.getDbT4001JukyushaDaichoEntity().getShikyuGendoTanisu());
        kaigoJuminhyoEntity.setDbT4001ShikyuGendoKaishiYMD(entity.getDbT4001JukyushaDaichoEntity().getShikyuGendoKaishiYMD());
        kaigoJuminhyoEntity.setDbT4001ShikyuGendoShuryoYMD(entity.getDbT4001JukyushaDaichoEntity().getShikyuGendoShuryoYMD());
        kaigoJuminhyoEntity.setDbT4001TankiSikyuGendoNissu(entity.getDbT4001JukyushaDaichoEntity().getTankiSikyuGendoNissu());
        kaigoJuminhyoEntity.setDbT4001TankiShikyuGendoKaishiYMD(entity.getDbT4001JukyushaDaichoEntity().getTankiShikyuGendoKaishiYMD());
        kaigoJuminhyoEntity.setDbT4001TankiShikyuGendoShuryoYMD(entity.getDbT4001JukyushaDaichoEntity().getTankiShikyuGendoShuryoYMD());
        kaigoJuminhyoEntity.setDbT4001ToshoNinteiYukoKaishiYMD(entity.getDbT4001JukyushaDaichoEntity().getToshoNinteiYukoKaishiYMD());
        kaigoJuminhyoEntity.setDbT4001ToshoNinteiYukoShuryoYMD(entity.getDbT4001JukyushaDaichoEntity().getToshoNinteiYukoShuryoYMD());
        kaigoJuminhyoEntity.setDbT4001JukyuShikakuShomeishoHakkoYMD1(entity.getDbT4001JukyushaDaichoEntity().getJukyuShikakuShomeishoHakkoYMD1());
        kaigoJuminhyoEntity.setDbT4001JukyuShikakuShomeishoHakkoYMD2(entity.getDbT4001JukyushaDaichoEntity().getJukyuShikakuShomeishoHakkoYMD2());
        kaigoJuminhyoEntity.setDbT4001ShindanMeireishoHakkoYMD(entity.getDbT4001JukyushaDaichoEntity().getShindanMeireishoHakkoYMD());
        kaigoJuminhyoEntity.setDbT4001NigoShinseiJuriTsuchishoHakkoYMD(entity.getDbT4001JukyushaDaichoEntity().getNigoShinseiJuriTsuchishoHakkoYMD());
        kaigoJuminhyoEntity.setDbT4001NinteiKekkaTsuchishoHakkoYMD(entity.getDbT4001JukyushaDaichoEntity().getNinteiKekkaTsuchishoHakkoYMD());
        kaigoJuminhyoEntity.setDbT4001KubunHenkoTsuchishoHakkoYMD(entity.getDbT4001JukyushaDaichoEntity().getKubunHenkoTsuchishoHakkoYMD());
        kaigoJuminhyoEntity.setDbT4001ServiceHenkoTsuchishoHakkoYMD(entity.getDbT4001JukyushaDaichoEntity().getServiceHenkoTsuchishoHakkoYMD());
        kaigoJuminhyoEntity.setDbT4001NinteiKyakkaTsuchishoHakkoYMD(entity.getDbT4001JukyushaDaichoEntity().getNinteiKyakkaTsuchishoHakkoYMD());
        kaigoJuminhyoEntity.setDbT4001NinteiTorikeshiTsuchishoHakkoYMD(entity.getDbT4001JukyushaDaichoEntity().getNinteiTorikeshiTsuchishoHakkoYMD());
        kaigoJuminhyoEntity.setDbT4001ShikakuShutokuMaeShinseiFlag(entity.getDbT4001JukyushaDaichoEntity().getShikakuShutokuMaeShinseiFlag());
        kaigoJuminhyoEntity.setDbT4001KyuSochishaFlag(entity.getDbT4001JukyushaDaichoEntity().getKyuSochishaFlag());
        kaigoJuminhyoEntity.setDbT4001LogicalDeletedFlag(entity.getDbT4001JukyushaDaichoEntity().getLogicalDeletedFlag());
        kaigoJuminhyoEntity.setDbT4001InsertTimestamp(entity.getDbT4001JukyushaDaichoEntity().getInsertTimestamp());
        kaigoJuminhyoEntity.setDbT4001LastUpdateTimestamp(entity.getDbT4001JukyushaDaichoEntity().getLastUpdateTimestamp());
        kaigoJuminhyoEntity.set広域運用_shichosonCode(entity.get広域運用_shichosonCode());
        kaigoJuminhyoEntity.set広域運用_shikibetsuCode(entity.get広域運用_shikibetsuCode());
        return kaigoJuminhyoEntity;
    }

    /**
     * 介護住民票個別事項連携情報作成【広域運用】の処理です。
     *
     * @return kaigoJuminhyoEntityList
     */
    public List<KaigoJuminhyoEntity> getkaigoJuminhyoEntityList() {
        return kaigoJuminhyoEntityList;

    }

    /**
     * 介護住民票個別事項連携情報作成【広域運用】の処理です。
     *
     * @param entity KaigoJuminhyoRelateEntity
     * @return kaigoJuminhyoEntityList
     */
    public List<KaigoJuminhyoEntity> setkaigoJuminhyoEntityList(KaigoJuminhyoRelateEntity entity) {
        kaigoJuminhyoEntityList.add(setKaigoJuminhyoEntity(entity));
        return kaigoJuminhyoEntityList;

    }

    /**
     * 介護住民票個別事項連携情報作成【広域運用】の処理です。
     *
     * @param entity KaigoJuminhyoRelateEntity
     * @return tashaJukiDataEntity
     */
    public KaigoJyuminhyouTashajukiDateEntity get介護住民票個別事項連携情報作成広域運用情報の作成処理(KaigoJuminhyoEntity entity) {
        KaigoJyuminhyouTashajukiDateEntity tashaJukiDataEntity = new KaigoJyuminhyouTashajukiDateEntity();
        tashaJukiDataEntity.set被保険者番号(new HihokenshaNo(entity.getHihokenshaNo().value()));
        tashaJukiDataEntity.set異動日(entity.getIdoYMD());
        tashaJukiDataEntity.set枝番(entity.getEdaNo());
        tashaJukiDataEntity.set異動事由コード(entity.getIdoJiyuCode());
        if (entity.getShichosonCode() == null) {
            tashaJukiDataEntity.set市町村コード(RString.EMPTY);
        } else {
            tashaJukiDataEntity.set市町村コード(new RString(entity.getShichosonCode().toString()));
        }
        tashaJukiDataEntity.set識別コード(entity.getShikibetsuCode());
        tashaJukiDataEntity.set資格取得事由コード(entity.getShikakuShutokuJiyuCode());
        tashaJukiDataEntity.set資格取得年月日(entity.getShikakuShutokuYMD());
        tashaJukiDataEntity.set資格取得届出年月日(entity.getShikakuShutokuTodokedeYMD());
        tashaJukiDataEntity.set第1号資格取得年月日(entity.getIchigoShikakuShutokuYMD());
        tashaJukiDataEntity.set被保険者区分コード(entity.getHihokennshaKubunCode());
        tashaJukiDataEntity.set資格喪失事由コード(entity.getShikakuSoshitsuJiyuCode());
        tashaJukiDataEntity.set資格喪失年月日(entity.getShikakuSoshitsuYMD());
        tashaJukiDataEntity.set資格喪失届出年月日(entity.getShikakuSoshitsuTodokedeYMD());
        tashaJukiDataEntity.set資格変更事由コード(entity.getShikakuHenkoJiyuCode());
        tashaJukiDataEntity.set資格変更年月日(entity.getShikakuHenkoYMD());
        tashaJukiDataEntity.set資格変更届出年月日(entity.getShikakuHenkoTodokedeYMD());
        tashaJukiDataEntity.set住所地特例適用事由コード(entity.getJushochitokureiTekiyoJiyuCode());
        tashaJukiDataEntity.set適用年月日(entity.getJushochitokureiTekiyoYMD());
        tashaJukiDataEntity.set適用届出年月日(entity.getJushochitokureiTekiyoTodokedeYMD());
        tashaJukiDataEntity.set住所地特例解除事由コード(entity.getJushochitokureiKaijoJiyuCode());
        tashaJukiDataEntity.set解除年月日(entity.getJushochitokureiKaijoYMD());
        tashaJukiDataEntity.set解除届出年月日(entity.getJushochitokureiKaijoTodokedeYMD());
        tashaJukiDataEntity.set住所地特例フラグ(entity.getJushochiTokureiFlag());
        tashaJukiDataEntity.set広域内住所地特例フラグ(entity.getKoikinaiJushochiTokureiFlag());
        tashaJukiDataEntity.set広住特措置元市町村コード(entity.getKoikinaiTokureiSochimotoShichosonCode());
        tashaJukiDataEntity.set旧市町村コード(entity.getKyuShichosonCode());
        tashaJukiDataEntity.set論理削除フラグ(entity.isLogicalDeletedFlag());
        if (entity.getInsertTimestamp() == null) {
            tashaJukiDataEntity.set挿入日時(RString.EMPTY);
        } else {
            tashaJukiDataEntity.set挿入日時(entity.getInsertTimestamp().format西暦(日付.toString()));
        }
        if (entity.getLastUpdateTimestamp() == null) {
            tashaJukiDataEntity.set更新日時(RString.EMPTY);
        } else {
            tashaJukiDataEntity.set更新日時(entity.getLastUpdateTimestamp().format西暦(日付.toString()));
        }
        tashaJukiDataEntity.set受給者市町村コード(entity.getDbT4001ShichosonCode());
        tashaJukiDataEntity.set受給者被保険者番号(entity.getDbT4001HihokenshaNo());
        tashaJukiDataEntity.set受給者履歴番号(entity.getDbT4001RirekiNo());
        tashaJukiDataEntity.set受給者枝番(entity.getDbT4001Edaban());
        tashaJukiDataEntity.set受給者申請書管理番号(entity.getDbT4001ShinseishoKanriNo());
        tashaJukiDataEntity.set受給者申請状況区分(entity.getDbT4001ShinseiJokyoKubun());
        tashaJukiDataEntity.set受給者支所コード(entity.getDbT4001ShishoCode());
        tashaJukiDataEntity.set受給者直近フラグ(entity.isDbT4001ChokkinFlag());
        tashaJukiDataEntity.set受給者識別コード(entity.getDbT4001ShikibetsuCode());
        tashaJukiDataEntity.set受給者受給申請事由(entity.getDbT4001JukyuShinseiJiyu());
        tashaJukiDataEntity.set受給者申請理由(entity.getDbT4001ShinseiRiyu());
        tashaJukiDataEntity.set受給者届出者申請者関係コード(entity.getDbT4001ShinseishaKankeiCode());
        tashaJukiDataEntity.set受給者届出者本人との関係(entity.getDbT4001HomninKankei());
        tashaJukiDataEntity.set受給者受給申請年月日(entity.getDbT4001JukyuShinseiYMD());
        tashaJukiDataEntity.set受給者２号特定疾病コード(entity.getDbT4001NigoTokuteiShippeiCode());
        tashaJukiDataEntity.set受給者審査会依頼年月日(entity.getDbT4001ShinsakaiIraiYMD());
        tashaJukiDataEntity.set受給者要介護認定状態区分コード(entity.getDbT4001YokaigoJotaiKubunCode());
        tashaJukiDataEntity.set受給者認定有効期間開始年月日(entity.getDbT4001NinteiYukoKikanKaishiYMD());
        tashaJukiDataEntity.set受給者認定有効期間終了年月日(entity.getDbT4001NinteiYukoKikanShuryoYMD());
        tashaJukiDataEntity.set受給者認定年月日(entity.getDbT4001NinteiYMD());
        tashaJukiDataEntity.set受給者指定サービス種類01(entity.getDbT4001ShiteiServiceShurui01());
        tashaJukiDataEntity.set受給者指定サービス種類02(entity.getDbT4001ShiteiServiceShurui02());
        tashaJukiDataEntity.set受給者指定サービス種類03(entity.getDbT4001ShiteiServiceShurui03());
        tashaJukiDataEntity.set受給者指定サービス種類04(entity.getDbT4001ShiteiServiceShurui04());
        tashaJukiDataEntity.set受給者指定サービス種類05(entity.getDbT4001ShiteiServiceShurui05());
        tashaJukiDataEntity.set受給者指定サービス種類06(entity.getDbT4001ShiteiServiceShurui06());
        tashaJukiDataEntity.set受給者指定サービス種類07(entity.getDbT4001ShiteiServiceShurui07());
        tashaJukiDataEntity.set受給者指定サービス種類08(entity.getDbT4001ShiteiServiceShurui08());
        tashaJukiDataEntity.set受給者指定サービス種類09(entity.getDbT4001ShiteiServiceShurui09());
        tashaJukiDataEntity.set受給者指定サービス種類10(entity.getDbT4001ShiteiServiceShurui10());
        tashaJukiDataEntity.set受給者指定サービス種類11(entity.getDbT4001ShiteiServiceShurui11());
        tashaJukiDataEntity.set受給者指定サービス種類12(entity.getDbT4001ShiteiServiceShurui12());
        tashaJukiDataEntity.set受給者指定サービス種類13(entity.getDbT4001ShiteiServiceShurui13());
        tashaJukiDataEntity.set受給者指定サービス種類14(entity.getDbT4001ShiteiServiceShurui14());
        tashaJukiDataEntity.set受給者指定サービス種類15(entity.getDbT4001ShiteiServiceShurui15());
        tashaJukiDataEntity.set受給者指定サービス種類16(entity.getDbT4001ShiteiServiceShurui16());
        tashaJukiDataEntity.set受給者指定サービス種類17(entity.getDbT4001ShiteiServiceShurui17());
        tashaJukiDataEntity.set受給者指定サービス種類18(entity.getDbT4001ShiteiServiceShurui18());
        tashaJukiDataEntity.set受給者指定サービス種類19(entity.getDbT4001ShiteiServiceShurui19());
        tashaJukiDataEntity.set受給者指定サービス種類20(entity.getDbT4001ShiteiServiceShurui20());
        tashaJukiDataEntity.set受給者指定サービス種類21(entity.getDbT4001ShiteiServiceShurui21());
        tashaJukiDataEntity.set受給者指定サービス種類22(entity.getDbT4001ShiteiServiceShurui22());
        tashaJukiDataEntity.set受給者指定サービス種類23(entity.getDbT4001ShiteiServiceShurui23());
        tashaJukiDataEntity.set受給者指定サービス種類24(entity.getDbT4001ShiteiServiceShurui24());
        tashaJukiDataEntity.set受給者指定サービス種類25(entity.getDbT4001ShiteiServiceShurui25());
        tashaJukiDataEntity.set受給者指定サービス種類26(entity.getDbT4001ShiteiServiceShurui26());
        tashaJukiDataEntity.set受給者指定サービス種類27(entity.getDbT4001ShiteiServiceShurui27());
        tashaJukiDataEntity.set受給者指定サービス種類28(entity.getDbT4001ShiteiServiceShurui28());
        tashaJukiDataEntity.set受給者指定サービス種類29(entity.getDbT4001ShiteiServiceShurui29());
        tashaJukiDataEntity.set受給者指定サービス種類30(entity.getDbT4001ShiteiServiceShurui30());
        tashaJukiDataEntity.set受給者喪失年月日(entity.getDbT4001SoshitsuYMD());
        tashaJukiDataEntity.set受給者直近異動年月日(entity.getDbT4001ChokkinIdoYMD());
        tashaJukiDataEntity.set受給者直近異動事由コード(entity.getDbT4001ChokkinIdoJiyuCode());
        tashaJukiDataEntity.set受給者有効無効区分(entity.getDbT4001YukoMukoKubun());
        tashaJukiDataEntity.set受給者データ区分(entity.getDbT4001DataKubun());
        tashaJukiDataEntity.set受給者同一連番(entity.getDbT4001Remban());
        tashaJukiDataEntity.set受給者異動理由(entity.getDbT4001IdoRiyu());
        tashaJukiDataEntity.set受給者申請書区分(entity.getDbT4001ShinseishoKubun());
        tashaJukiDataEntity.set受給者削除事由コード(entity.getDbT4001SakujoJiyuCode());
        tashaJukiDataEntity.set受給者要支援者認定申請区分(entity.isDbT4001YoshienshaNinteiShinseiFlag());
        tashaJukiDataEntity.set受給者支給限度単位数(entity.getDbT4001ShikyuGendoTanisu());
        tashaJukiDataEntity.set受給者支給限度有効開始年月日(entity.getDbT4001ShikyuGendoKaishiYMD());
        tashaJukiDataEntity.set受給者支給限度有効終了年月日(entity.getDbT4001ShikyuGendoShuryoYMD());
        tashaJukiDataEntity.set受給者短期入所支給限度日数(entity.getDbT4001TankiSikyuGendoNissu());
        tashaJukiDataEntity.set受給者短期入所支給限度開始年月日(entity.getDbT4001TankiShikyuGendoKaishiYMD());
        tashaJukiDataEntity.set受給者短期入所支給限度終了年月日(entity.getDbT4001TankiShikyuGendoShuryoYMD());
        tashaJukiDataEntity.set受給者当初認定有効開始年月日(entity.getDbT4001ToshoNinteiYukoKaishiYMD());
        tashaJukiDataEntity.set受給者当初認定有効終了年月日(entity.getDbT4001ToshoNinteiYukoShuryoYMD());
        tashaJukiDataEntity.set受給者受給資格証明書発行年月日１(entity.getDbT4001JukyuShikakuShomeishoHakkoYMD1());
        tashaJukiDataEntity.set受給者受給資格証明書発行年月日２(entity.getDbT4001JukyuShikakuShomeishoHakkoYMD2());
        tashaJukiDataEntity.set受給者診断命令書発行年月日(entity.getDbT4001ShindanMeireishoHakkoYMD());
        tashaJukiDataEntity.set受給者２号申請受理通知書発行年月日(entity.getDbT4001NigoShinseiJuriTsuchishoHakkoYMD());
        tashaJukiDataEntity.set受給者認定結果通知書発行年月日(entity.getDbT4001NinteiKekkaTsuchishoHakkoYMD());
        tashaJukiDataEntity.set受給者区分変更通知書発行年月日(entity.getDbT4001KubunHenkoTsuchishoHakkoYMD());
        tashaJukiDataEntity.set受給者サービス変更通知書発行年月日(entity.getDbT4001ServiceHenkoTsuchishoHakkoYMD());
        tashaJukiDataEntity.set受給者認定却下通知書発行年月日(entity.getDbT4001NinteiKyakkaTsuchishoHakkoYMD());
        tashaJukiDataEntity.set受給者認定取消通知書発行年月日(entity.getDbT4001NinteiTorikeshiTsuchishoHakkoYMD());
        tashaJukiDataEntity.set受給者資格取得前申請フラグ(entity.isDbT4001ShikakuShutokuMaeShinseiFlag());
        tashaJukiDataEntity.set受給者旧措置者フラグ(entity.isDbT4001KyuSochishaFlag());
        tashaJukiDataEntity.set受給者論理削除フラグ(entity.isDbT4001LogicalDeletedFlag());
        if (entity.getDbT4001InsertTimestamp() == null) {
            tashaJukiDataEntity.set受給者挿入日時(RString.EMPTY);
        } else {
            tashaJukiDataEntity.set受給者挿入日時(entity.getDbT4001InsertTimestamp().format西暦(日付.toString()));
        }
        if (entity.getDbT4001LastUpdateTimestamp() == null) {
            tashaJukiDataEntity.set受給者更新日時(RString.EMPTY);
        } else {
            tashaJukiDataEntity.set受給者更新日時(entity.getDbT4001LastUpdateTimestamp().format西暦(日付.toString()));
        }
        return tashaJukiDataEntity;
    }

    /**
     * 介護住民票個別事項連携情報作成【広域運用】の処理です。
     *
     * @param sakiEncodeKeitai RString
     * @return tashaJukiDataEntity
     */
    public Encode getEncode(RString sakiEncodeKeitai) {
        Encode encode = Encode.SJIS;
        if (new RString("ASCII").equals(sakiEncodeKeitai)) {
            encode = Encode.ASCII;
        } else if (new RString("EBCDIC").equals(sakiEncodeKeitai)) {
            encode = Encode.EBCDIC;
        } else if (new RString("SJIS").equals(sakiEncodeKeitai)) {
            encode = Encode.SJIS;
        } else if (new RString("JIS").equals(sakiEncodeKeitai)) {
            encode = Encode.JIS;
        } else if (new RString("UTF_8").equals(sakiEncodeKeitai)) {
            encode = Encode.UTF_8;
        } else if (new RString("UTF_8withBOM").equals(sakiEncodeKeitai)) {
            encode = Encode.UTF_8withBOM;
        } else if (new RString("UTF_16withBOM").equals(sakiEncodeKeitai)) {
            encode = Encode.UTF_16withBOM;
        } else if (new RString("UTF_16BE_withBOM").equals(sakiEncodeKeitai)) {
            encode = Encode.UTF_16BE_withBOM;
        } else if (new RString("UTF_16LE").equals(sakiEncodeKeitai)) {
            encode = Encode.UTF_16LE;
        } else if (new RString("UTF_16BE").equals(sakiEncodeKeitai)) {
            encode = Encode.UTF_16BE;
        } else if (new RString("UTF_32withBOM").equals(sakiEncodeKeitai)) {
            encode = Encode.UTF_32withBOM;
        } else if (new RString("UTF_32BE_withBOM").equals(sakiEncodeKeitai)) {
            encode = Encode.UTF_32BE_withBOM;
        } else if (new RString("UTF_32LE").equals(sakiEncodeKeitai)) {
            encode = Encode.UTF_32LE;
        }
        return encode;
    }

    /**
     * 介護住民票個別事項連携情報作成【広域運用】の処理です。
     *
     * @param parameter KaiGoJuminHyokouKiuProcessParameter
     * @return dbt7022entity
     */
    public DbT7022ShoriDateKanriEntity set更新(KaiGoJuminHyokouKiuProcessParameter parameter) {
        DbT7022ShoriDateKanriEntity dbt7022entity = new DbT7022ShoriDateKanriEntity();
        dbt7022entity.setKijunTimestamp(new YMDHMS(parameter.getDateTo()));
        dbt7022entity.setTaishoKaishiTimestamp(new YMDHMS(parameter.getDateFrom()));
        dbt7022entity.setTaishoShuryoTimestamp(new YMDHMS(parameter.getDateTo()));
        return dbt7022entity;
    }

    /**
     * 介護住民票個別事項連携情報作成【広域運用】の処理です。
     *
     * @param parameter KaiGoJuminHyokouKiuProcessParameter
     * @return dbt7022entity
     */
    public DbT7022ShoriDateKanriEntity set追加(KaiGoJuminHyokouKiuProcessParameter parameter) {
        DbT7022ShoriDateKanriEntity entity = new DbT7022ShoriDateKanriEntity();
        entity.setSubGyomuCode(SubGyomuCode.DBU介護統計報告);
        entity.setShichosonCode(new LasdecCode(parameter.getShichosonCode()));
        entity.setShoriName(new RString("介護住民票個別事項連携情報作成【広域運用】"));
        entity.setNendo(new FlexibleYear("0000"));
        entity.setNendoNaiRenban(new RString("0000"));
        entity.setShoriEdaban(new RString("0000"));
        日付TO(entity, parameter);
        対象開始日時(entity, parameter);
        対象終了日時(entity, parameter);
        return entity;

    }

    private void 日付TO(DbT7022ShoriDateKanriEntity entity, KaiGoJuminHyokouKiuProcessParameter parameter) {
        RStringBuilder 日時 = new RStringBuilder();
        日時.append(parameter.getDateTo().getDate());
        日時.append(parameter.getDateTo().getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss));
        entity.setKijunTimestamp(new YMDHMS(日時.toString().replace(":", "")));
    }

    private void 対象開始日時(DbT7022ShoriDateKanriEntity entity, KaiGoJuminHyokouKiuProcessParameter parameter) {
        RStringBuilder 日時 = new RStringBuilder();
        日時.append(parameter.getDateFrom().getDate());
        日時.append(parameter.getDateFrom().getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss));
        entity.setTaishoKaishiTimestamp(new YMDHMS(日時.toString().replace(":", "")));
    }

    private void 対象終了日時(DbT7022ShoriDateKanriEntity entity, KaiGoJuminHyokouKiuProcessParameter parameter) {
        RStringBuilder 日時 = new RStringBuilder();
        日時.append(parameter.getDateTo().getDate());
        日時.append(parameter.getDateTo().getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss));
        entity.setTaishoShuryoTimestamp(new YMDHMS(日時.toString().replace(":", "")));
    }
}
