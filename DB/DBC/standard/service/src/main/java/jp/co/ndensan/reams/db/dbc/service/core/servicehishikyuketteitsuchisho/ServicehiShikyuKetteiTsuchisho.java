/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.servicehishikyuketteitsuchisho;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicehishikyuketteitsuchisho.KetteiTsuchishoInfoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicehishikyuketteitsuchisho.KetteiTsuchishoInfoTempResultEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 高額サービス費支給決定通知書作成（バッチ）のクラスです。
 *
 * @reamsid_L DBC-2000-130 xicongwang
 */
public class ServicehiShikyuKetteiTsuchisho {

    /**
     * {@link InstanceProvider#create}にて生成した{@link ServicehiShikyuKetteiTsuchisho}のインスタンスを返します。
     *
     * @return ServicehiShikyuKetteiTsuchisho
     */
    public static ServicehiShikyuKetteiTsuchisho createInstance() {
        return InstanceProvider.create(ServicehiShikyuKetteiTsuchisho.class);
    }

    /**
     * 決定通知書情報取得するメソッドです。
     *
     * @param entity KetteiTsuchishoInfoTempResultEntity
     * @return KetteiTsuchishoInfoTempEntity 決定通知書情報
     */
    public KetteiTsuchishoInfoTempEntity to決定通知書情報(KetteiTsuchishoInfoTempResultEntity entity) {

        KetteiTsuchishoInfoTempEntity tmpEntity = new KetteiTsuchishoInfoTempEntity();
        tmpEntity.setHihokenshaNo(entity.get被保険者番号());
        tmpEntity.setServiceTeikyoYM(entity.getサービス提供年月());
        tmpEntity.setRirekiNo(entity.get履歴番号());
        tmpEntity.setShoKisaiHokenshaNo(entity.get証記載保険者番号());
        tmpEntity.setUketsukeYMD(entity.get受付年月日());
        tmpEntity.setShiharaiHohoKubunCode(entity.get支払方法区分コード());
        tmpEntity.setShiharaiBasho(entity.get支払場所());
        tmpEntity.setShiharaiKaishiYMD(entity.get支払期間開始年月日());
        tmpEntity.setShiharaiShuryoYMD(entity.get支払期間終了年月日());
        tmpEntity.setShiharaiKaishiTime(entity.get支払窓口開始時間());
        tmpEntity.setShiharaiShuryoTime(entity.get支払窓口終了期間());
        tmpEntity.setKetteiYMD(entity.get決定年月日());
        tmpEntity.setTsuchishoNo(entity.get決定通知No());
        tmpEntity.setFushikyuRiyu(entity.get不支給理由());
        tmpEntity.setShikyuKubunCode(entity.get支給結果());
        tmpEntity.setShikyuKingaku(entity.get支払金額());

        //TODO 高額介護サービス費支給判定結果．支払金額内訳・利用者分(存在しない)
        tmpEntity.setShikyuKingakuCode(entity.get支払金額内訳_利用者分());

        tmpEntity.setShinsaHohoKubun(entity.get審査方法区分());
        tmpEntity.setHonninShiharaiGaku(entity.get本人支払額());
        tmpEntity.setJidoShokanTaishoFlag(entity.is自動償還対象フラグ());
        tmpEntity.setShinsaShikyuKubunCode(entity.get支給区分コード());
        tmpEntity.setKogakuShikyuGaku(entity.get高額支給額());
        tmpEntity.setKinyuKikanCode(entity.get金融機関コード());

        //TODO 設定?
        tmpEntity.setKikan_name(entity.get金融機関名称());

        tmpEntity.setKinyuKikanShitenCode(entity.get支店コード());

        //TODO 設定?
        tmpEntity.setKikanShiten_name(entity.get支店名称());

        tmpEntity.setYokinShubetsu(entity.get預金種別());

        //TODO 設定?
        tmpEntity.setYokinShubetsuRyakusho(entity.get預金種別名称());

        tmpEntity.setKozaNo(entity.get口座番号());
        tmpEntity.setKozaMeigininShikibetsuCode(entity.get口座名義人漢字());
        tmpEntity.setShuryoYMD(entity.get口座終了年月日());
        tmpEntity.setTsuchoNo(entity.get通帳番号());
        tmpEntity.setShikakuSoshitsuYMD(entity.get資格喪失年月日());
        tmpEntity.setShikibetsuCode(entity.get識別コード());
        tmpEntity.setShikakuSoshitsuJiyuCode(entity.get資格喪失事由コード());
        tmpEntity.setYokaigoJotaiKubunCode(entity.get要介護認定状態区分コード());
        tmpEntity.setNinteiYukoKikanKaishiYMD(entity.get認定有効期間開始年月日());
        tmpEntity.setNinteiYukoKikanShuryoYMD(entity.get認定有効期間終了年月日());

        if (entity.get宛名() != null) {
            set宛名の全項目(entity.get宛名(), tmpEntity);
        }
        if (entity.get宛先() != null) {
            set宛先の全項目(entity.get宛先(), tmpEntity);
        }

        return tmpEntity;
    }

    private void set宛名の全項目(UaFt200FindShikibetsuTaishoEntity 宛名, KetteiTsuchishoInfoTempEntity tmpEntity) {

        tmpEntity.setShikibetsuTaisho_shikibetsuCode(宛名.getShikibetsuCode());
        tmpEntity.setShikibetsuTaisho_genLasdecCode(宛名.getGenLasdecCode());
        tmpEntity.setShikibetsuTaisho_kyuLasdecCode(宛名.getKyuLasdecCode());
        tmpEntity.setShikibetsuTaisho_kyuLasdecCodeRenban(宛名.getKyuLasdecCodeRenban());
        tmpEntity.setShikibetsuTaisho_gyomuCode(宛名.getGyomuCode());
        tmpEntity.setShikibetsuTaisho_rirekiNo(宛名.getRirekiNo());
        tmpEntity.setShikibetsuTaisho_currentFlag(宛名.getCurrentFlag());
        tmpEntity.setShikibetsuTaisho_juminShubetsuCode(宛名.getJuminShubetsuCode());
        tmpEntity.setShikibetsuTaisho_kojinNo(宛名.getKojinNo());
        tmpEntity.setShikibetsuTaisho_hojinNo(宛名.getHojinNo());
        tmpEntity.setShikibetsuTaisho_shoriYMD(宛名.getShoriYMD());
        tmpEntity.setShikibetsuTaisho_idoJiyuCode(宛名.getIdoJiyuCode());
        tmpEntity.setShikibetsuTaisho_idoYMD(宛名.getIdoYMD());
        tmpEntity.setShikibetsuTaisho_todokedeJiyuCode(宛名.getTodokedeJiyuCode());
        tmpEntity.setShikibetsuTaisho_todokedeYMD(宛名.getTodokedeYMD());
        tmpEntity.setShikibetsuTaisho_idoRiyuCode(宛名.getIdoRiyuCode());
        tmpEntity.setShikibetsuTaisho_meisho(宛名.getMeisho());
        tmpEntity.setShikibetsuTaisho_kanaMeisho(宛名.getKanaMeisho());
        tmpEntity.setShikibetsuTaisho_kannaiKangaiKubun(宛名.getKannaiKangaiKubun());
        tmpEntity.setShikibetsuTaisho_yubinNo(宛名.getYubinNo());
        tmpEntity.setShikibetsuTaisho_choikiCode(宛名.getChoikiCode());
        tmpEntity.setShikibetsuTaisho_zenkokuJushoCode(宛名.getZenkokuJushoCode());
        tmpEntity.setShikibetsuTaisho_jusho(宛名.getJusho());
        tmpEntity.setShikibetsuTaisho_banchiCode1(宛名.getBanchiCode1());
        tmpEntity.setShikibetsuTaisho_banchiCode2(宛名.getBanchiCode2());
        tmpEntity.setShikibetsuTaisho_banchiCode3(宛名.getBanchiCode3());
        tmpEntity.setShikibetsuTaisho_banchiCode4(宛名.getBanchiCode4());
        tmpEntity.setShikibetsuTaisho_banchi(宛名.getBanchi());
        tmpEntity.setShikibetsuTaisho_katagaki(宛名.getKatagaki());
        tmpEntity.setShikibetsuTaisho_katagakiInjiFlag(宛名.getKatagakiInjiFlag());
        tmpEntity.setShikibetsuTaisho_gyoseikuCode(宛名.getGyoseikuCode());
        tmpEntity.setShikibetsuTaisho_gyoseikuName(宛名.getGyoseikuName());
        tmpEntity.setShikibetsuTaisho_chikuCode1(宛名.getChikuCode1());
        tmpEntity.setShikibetsuTaisho_chikuName1(宛名.getChikuName1());
        tmpEntity.setShikibetsuTaisho_chikuCode2(宛名.getChikuCode2());
        tmpEntity.setShikibetsuTaisho_chikuName2(宛名.getChikuName2());
        tmpEntity.setShikibetsuTaisho_chikuCode3(宛名.getChikuCode3());
        tmpEntity.setShikibetsuTaisho_chikuName3(宛名.getChikuName3());
        tmpEntity.setShikibetsuTaisho_shogakkokuCode(宛名.getShogakkokuCode());
        tmpEntity.setShikibetsuTaisho_shogakkokuName(宛名.getShogakkokuName());
        tmpEntity.setShikibetsuTaisho_chugakkokuCode(宛名.getChugakkokuCode());
        tmpEntity.setShikibetsuTaisho_chugakkokuName(宛名.getChugakkokuName());
        tmpEntity.setShikibetsuTaisho_tohyokuCode(宛名.getTohyokuCode());
        tmpEntity.setShikibetsuTaisho_tohyokuName(宛名.getTohyokuName());
        tmpEntity.setShikibetsuTaisho_juminJotaiCode(宛名.getJuminJotaiCode());
        tmpEntity.setShikibetsuTaisho_setaiCode(宛名.getSetaiCode());
        tmpEntity.setShikibetsuTaisho_seinengappiYMD(宛名.getSeinengappiYMD());
        tmpEntity.setShikibetsuTaisho_seinengappiFushoKubun(宛名.getSeinengappiFushoKubun());
        tmpEntity.setShikibetsuTaisho_seibetsuCode(宛名.getSeibetsuCode());
        tmpEntity.setShikibetsuTaisho_tsuzukigaraCode(宛名.getTsuzukigaraCode());
        tmpEntity.setShikibetsuTaisho_tsuzukigara(宛名.getTsuzukigara());
        tmpEntity.setShikibetsuTaisho_kazokuNo(宛名.getKazokuNo());
        tmpEntity.setShikibetsuTaisho_juminhyoHyojijun(宛名.getJuminhyoHyojijun());
        tmpEntity.setShikibetsuTaisho_kikaYMD(宛名.getKikaYMD());
        tmpEntity.setShikibetsuTaisho_kanjiShimei(宛名.getKanjiShimei());
        tmpEntity.setShikibetsuTaisho_kanaShimei(宛名.getKanaShimei());
        tmpEntity.setShikibetsuTaisho_honsekiZenkokuJushoCode(宛名.getHonsekiZenkokuJushoCode());
        tmpEntity.setShikibetsuTaisho_honsekiChoikiCode(宛名.getHonsekiChoikiCode());
        tmpEntity.setShikibetsuTaisho_honsekiJusho(宛名.getHonsekiJusho());
        tmpEntity.setShikibetsuTaisho_honsekiBanchi(宛名.getHonsekiBanchi());
        tmpEntity.setShikibetsuTaisho_hittosha(宛名.getHittosha());
        tmpEntity.setShikibetsuTaisho_gaikokujinShimei(宛名.getGaikokujinShimei());
        tmpEntity.setShikibetsuTaisho_gaikokujinHeikimei(宛名.getGaikokujinHeikimei());
        tmpEntity.setShikibetsuTaisho_gaikokujinKanaShimei(宛名.getGaikokujinKanaShimei());
        tmpEntity.setShikibetsuTaisho_tsushomei(宛名.getTsushomei());
        tmpEntity.setShikibetsuTaisho_shimeiRiyoKubun(宛名.getShimeiRiyoKubun());
        tmpEntity.setShikibetsuTaisho_kanaTsushomei(宛名.getKanaTsushomei());
        tmpEntity.setShikibetsuTaisho_katakanaHyoki(宛名.getKatakanaHyoki());
        tmpEntity.setShikibetsuTaisho_kokusekiChiikiCode(宛名.getKokusekiChiikiCode());
        tmpEntity.setShikibetsuTaisho_zairyuShikakuCode(宛名.getZairyuShikakuCode());
        tmpEntity.setShikibetsuTaisho_zairyuKikanCode(宛名.getZairyuKikanCode());
        tmpEntity.setShikibetsuTaisho_zairyuKikantoManryoYMD(宛名.getZairyuKikantoManryoYMD());
        tmpEntity.setShikibetsuTaisho_zairyuCardtoNo(宛名.getZairyuCardtoNo());
        tmpEntity.setShikibetsuTaisho_zairyuCardtoYukoYMD(宛名.getZairyuCardtoYukoYMD());
        tmpEntity.setShikibetsuTaisho_dai30Jono45niKiteisuruKubun(宛名.getDai30Jono45niKiteisuruKubun());
        tmpEntity.setShikibetsuTaisho_setainushiShikibetsuCode(宛名.getSetainushiShikibetsuCode());
        tmpEntity.setShikibetsuTaisho_setainushiMei(宛名.getSetainushiMei());
        tmpEntity.setShikibetsuTaisho_hojinKeitaiCode(宛名.getHojinKeitaiCode());
        tmpEntity.setShikibetsuTaisho_hojinKeitaiMeisho(宛名.getHojinKeitaiMeisho());
        tmpEntity.setShikibetsuTaisho_hojinKeitaiRyakusho(宛名.getHojinKeitaiRyakusho());
        tmpEntity.setShikibetsuTaisho_hojinMeishoHenshuKubun(宛名.getHojinMeishoHenshuKubun());
        tmpEntity.setShikibetsuTaisho_hojinKeitaiRyakushoKubun(宛名.getHojinKeitaiRyakushoKubun());
        tmpEntity.setShikibetsuTaisho_hojinMeisho(宛名.getHojinMeisho());
        tmpEntity.setShikibetsuTaisho_hojinKanaMeisho(宛名.getHojinKanaMeisho());
        tmpEntity.setShikibetsuTaisho_hojinShitenMeisho(宛名.getHojinShitenMeisho());
        tmpEntity.setShikibetsuTaisho_hojinShitenKanaMeisho(宛名.getHojinShitenKanaMeisho());
        tmpEntity.setShikibetsuTaisho_daihyoshaShikibetsuCode(宛名.getDaihyoshaShikibetsuCode());
        tmpEntity.setShikibetsuTaisho_daihyoshaJuminShubetsu(宛名.getDaihyoshaJuminShubetsu());
        tmpEntity.setShikibetsuTaisho_daihyoshaShimei(宛名.getDaihyoshaShimei());
        tmpEntity.setShikibetsuTaisho_daihyoshaKanaShimei(宛名.getDaihyoshaKanaShimei());
        tmpEntity.setShikibetsuTaisho_daihyoshaNihonjinShimei(宛名.getDaihyoshaNihonjinShimei());
        tmpEntity.setShikibetsuTaisho_daihyoshaNihonjinKanaShimei(宛名.getDaihyoshaNihonjinKanaShimei());
        tmpEntity.setShikibetsuTaisho_daihyoshaGaikokujinShimei(宛名.getDaihyoshaGaikokujinHeikimei());
        tmpEntity.setShikibetsuTaisho_daihyoshaGaikokujinHeikimei(宛名.getDaihyoshaGaikokujinHeikimei());
        tmpEntity.setShikibetsuTaisho_daihyoshaGaikokujinKanaShimei(宛名.getDaihyoshaGaikokujinKanaShimei());
        tmpEntity.setShikibetsuTaisho_daihyoshaTsushomei(宛名.getDaihyoshaTsushomei());
        tmpEntity.setShikibetsuTaisho_daihyoshaShimeiRiyoKubun(宛名.getDaihyoshaShimeiRiyoKubun());
        tmpEntity.setShikibetsuTaisho_daihyoshaKanaTsushomei(宛名.getDaihyoshaKanaTsushomei());
        tmpEntity.setShikibetsuTaisho_daihyoshaKannaiKangaiKubun(宛名.getDaihyoshaKannaiKangaiKubun());
        tmpEntity.setShikibetsuTaisho_daihyoshaYubinNo(宛名.getDaihyoshaYubinNo());
        tmpEntity.setShikibetsuTaisho_daihyoshaChoikiCode(宛名.getDaihyoshaChoikiCode());
        tmpEntity.setShikibetsuTaisho_daihyoshaZenkokuJushoCode(宛名.getDaihyoshaZenkokuJushoCode());
        tmpEntity.setShikibetsuTaisho_daihyoshaJusho(宛名.getDaihyoshaJusho());
        tmpEntity.setShikibetsuTaisho_daihyoshaBanchiCode1(宛名.getDaihyoshaBanchiCode1());
        tmpEntity.setShikibetsuTaisho_daihyoshaBanchiCode2(宛名.getDaihyoshaBanchiCode2());
        tmpEntity.setShikibetsuTaisho_daihyoshaBanchiCode3(宛名.getDaihyoshaBanchiCode3());
        tmpEntity.setShikibetsuTaisho_daihyoshaBanchiCode4(宛名.getDaihyoshaBanchiCode4());
        tmpEntity.setShikibetsuTaisho_daihyoshaBanchi(宛名.getDaihyoshaBanchi());
        tmpEntity.setShikibetsuTaisho_daihyoshaKatagaki(宛名.getDaihyoshaKatagaki());
        tmpEntity.setShikibetsuTaisho_ninkachiendantaiTorokuShikakuKubun(宛名.getNinkachiendantaiTorokuShikakuKubun());
        tmpEntity.setShikibetsuTaisho_ninkachiendantaiNinkaYMD(宛名.getNinkachiendantaiNinkaYMD());
        tmpEntity.setShikibetsuTaisho_kojinHojinKBN(宛名.getKojinHojinKBN());
        tmpEntity.setShikibetsuTaisho_kyoyushaMeisho(宛名.getKyoyushaMeisho());
        tmpEntity.setShikibetsuTaisho_kyoyushaKanaMeisho(宛名.getKyoyushaKanaMeisho());
        tmpEntity.setShikibetsuTaisho_torokuJiyuCode(宛名.getTorokuJiyuCode());
        tmpEntity.setShikibetsuTaisho_torokuIdoYMD(宛名.getTorokuIdoYMD());
        tmpEntity.setShikibetsuTaisho_torokuTodokedeYMD(宛名.getTorokuTodokedeYMD());
        tmpEntity.setShikibetsuTaisho_juteiJiyuCode(宛名.getJuteiJiyuCode());
        tmpEntity.setShikibetsuTaisho_juteiIdoYMD(宛名.getJuteiIdoYMD());
        tmpEntity.setShikibetsuTaisho_juteiTodokedeYMD(宛名.getJuteiTodokedeYMD());
        tmpEntity.setShikibetsuTaisho_shojoJiyuCode(宛名.getShojoJiyuCode());
        tmpEntity.setShikibetsuTaisho_shojoIdoYMD(宛名.getShojoIdoYMD());
        tmpEntity.setShikibetsuTaisho_shojoTodokedeYMD(宛名.getShojoTodokedeYMD());
        tmpEntity.setShikibetsuTaisho_jutonaiYubinNo(宛名.getJutonaiYubinNo());
        tmpEntity.setShikibetsuTaisho_jutonaiChoikiCode(宛名.getJutonaiChoikiCode());
        tmpEntity.setShikibetsuTaisho_jutonaiJusho(宛名.getJutonaiJusho());
        tmpEntity.setShikibetsuTaisho_jutonaiBanchiCode1(宛名.getJutonaiBanchiCode1());
        tmpEntity.setShikibetsuTaisho_jutonaiBanchiCode2(宛名.getJutonaiBanchiCode2());
        tmpEntity.setShikibetsuTaisho_jutonaiBanchiCode3(宛名.getJutonaiBanchiCode3());
        tmpEntity.setShikibetsuTaisho_jutonaiBanchiCode4(宛名.getJutonaiBanchiCode4());
        tmpEntity.setShikibetsuTaisho_jutonaiBanchi(宛名.getJutonaiBanchi());
        tmpEntity.setShikibetsuTaisho_jutonaiKatagaki(宛名.getJutonaiKatagaki());
        tmpEntity.setShikibetsuTaisho_jutonaiKatagakiInjiFlag(宛名.getJutonaiKatagakiInjiFlag());
        tmpEntity.setShikibetsuTaisho_tennyumaeYubinNo(宛名.getTennyumaeYubinNo());
        tmpEntity.setShikibetsuTaisho_tennyumaeZenkokuJushoCode(宛名.getTennyumaeZenkokuJushoCode());
        tmpEntity.setShikibetsuTaisho_tennyumaeJusho(宛名.getTennyumaeJusho());
        tmpEntity.setShikibetsuTaisho_tennyumaeBanchi(宛名.getTennyumaeBanchi());
        set宛名の全項目_部分(宛名, tmpEntity);
    }

    private void set宛名の全項目_部分(UaFt200FindShikibetsuTaishoEntity 宛名, KetteiTsuchishoInfoTempEntity tmpEntity) {
        tmpEntity.setShikibetsuTaisho_tennyumaeKatagaki(宛名.getTennyumaeKatagaki());
        tmpEntity.setShikibetsuTaisho_tennyumaeSetainushimei(宛名.getTennyumaeSetainushimei());
        tmpEntity.setShikibetsuTaisho_tennyumaeKyusei(宛名.getTennyumaeKyusei());
        tmpEntity.setShikibetsuTaisho_saishuJutochiYubinNo(宛名.getSaishuJutochiYubinNo());
        tmpEntity.setShikibetsuTaisho_saishuJutochiZenkokuJushoCode(宛名.getSaishuJutochiZenkokuJushoCode());
        tmpEntity.setShikibetsuTaisho_saishuJutochiJusho(宛名.getSaishuJutochiJusho());
        tmpEntity.setShikibetsuTaisho_saishuJutochiBanchi(宛名.getSaishuJutochiBanchi());
        tmpEntity.setShikibetsuTaisho_saishuJutochiKatagaki(宛名.getSaishuJutochiKatagaki());
        tmpEntity.setShikibetsuTaisho_saishuJutochiSetainushimei(宛名.getSaishuJutochiSetainushimei());
        tmpEntity.setShikibetsuTaisho_tenshutsuYoteiIdoYMD(宛名.getTenshutsuYoteiIdoYMD());
        tmpEntity.setShikibetsuTaisho_tenshutsuYoteiYubinNo(宛名.getTenshutsuKakuteiYubinNo());
        tmpEntity.setShikibetsuTaisho_tenshutsuYoteiZenkokuJushoCode(宛名.getTenshutsuYoteiZenkokuJushoCode());
        tmpEntity.setShikibetsuTaisho_tenshutsuYoteiJusho(宛名.getTenshutsuYoteiJusho());
        tmpEntity.setShikibetsuTaisho_tenshutsuYoteiBanchi(宛名.getTenshutsuYoteiBanchi());
        tmpEntity.setShikibetsuTaisho_tenshutsuYoteiKatagaki(宛名.getTenshutsuKakuteiKatagaki());
        tmpEntity.setShikibetsuTaisho_tenshutsuYoteiSetainushimei(宛名.getTenshutsuYoteiSetainushimei());
        tmpEntity.setShikibetsuTaisho_tenshutsuKakuteiIdoYMD(宛名.getTenshutsuKakuteiIdoYMD());
        tmpEntity.setShikibetsuTaisho_tenshutsuKakuteiTsuchiYMD(宛名.getTenshutsuKakuteiTsuchiYMD());
        tmpEntity.setShikibetsuTaisho_tenshutsuKakuteiYubinNo(宛名.getTenshutsuKakuteiYubinNo());
        tmpEntity.setShikibetsuTaisho_tenshutsuKakuteiZenkokuJushoCode(宛名.getTenshutsuKakuteiZenkokuJushoCode());
        tmpEntity.setShikibetsuTaisho_tenshutsuKakuteiJusho(宛名.getTenshutsuKakuteiJusho());
        tmpEntity.setShikibetsuTaisho_tenshutsuKakuteiBanchi(宛名.getTenshutsuKakuteiBanchi());
        tmpEntity.setShikibetsuTaisho_tenshutsuKakuteiKatagaki(宛名.getTenshutsuKakuteiKatagaki());
        tmpEntity.setShikibetsuTaisho_tenshutsuKakuteiSetainushimei(宛名.getTenshutsuKakuteiSetainushimei());
        tmpEntity.setShikibetsuTaisho_juminhyoUtsushiHakkoSeigyoKubun(宛名.getJuminhyoUtsushiHakkoSeigyoKubun());
        tmpEntity.setShikibetsuTaisho_renrakusaki1(宛名.getRenrakusaki1());
        tmpEntity.setShikibetsuTaisho_kensakuRenrakusaki1(宛名.getKensakuRenrakusaki1());
        tmpEntity.setShikibetsuTaisho_renrakusakiKubun1(宛名.getRenrakusakiKubun1());
        tmpEntity.setShikibetsuTaisho_renrakusaki2(宛名.getRenrakusaki2());
        tmpEntity.setShikibetsuTaisho_kensakuRenrakusaki2(宛名.getKensakuRenrakusaki2());
        tmpEntity.setShikibetsuTaisho_renrakusakiKubun2(宛名.getRenrakusakiKubun2());
        tmpEntity.setShikibetsuTaisho_renrakusaki3(宛名.getRenrakusaki3());
        tmpEntity.setShikibetsuTaisho_kensakuRenrakusaki3(宛名.getKensakuRenrakusaki3());
        tmpEntity.setShikibetsuTaisho_renrakusakiKubun3(宛名.getRenrakusakiKubun3());
        tmpEntity.setShikibetsuTaisho_mailAddress(宛名.getMailAddress());
        tmpEntity.setShikibetsuTaisho_biko(宛名.getBiko());
        tmpEntity.setShikibetsuTaisho_kanaName(宛名.getKanaName());
        tmpEntity.setShikibetsuTaisho_gaikokujinKanaName(宛名.getGaikokujinKanaName());
        tmpEntity.setShikibetsuTaisho_kanaTsushoName(宛名.getKanaTsushoName());
        tmpEntity.setShikibetsuTaisho_jutogaiKanriUpdateCount(宛名.getJutogaiKanriUpdateCount());
        tmpEntity.setShikibetsuTaisho_jutogaiKanriTorokuNo(宛名.getJutogaiGaikokujinTorokuNo());
        tmpEntity.setShikibetsuTaisho_jutogaiKojinKihonUpdateCount(宛名.getJutogaiKojinKihonUpdateCount());
        tmpEntity.setShikibetsuTaisho_jutogaiKojinKihonTorokuNo(宛名.getJutogaiKojinKihonTorokuNo());
        tmpEntity.setShikibetsuTaisho_jutogaiNihonjinUpdateCount(宛名.getJutogaiNihonjinUpdateCount());
        tmpEntity.setShikibetsuTaisho_jutogaiNihonjinTorokuNo(宛名.getJutogaiNihonjinTorokuNo());
        tmpEntity.setShikibetsuTaisho_jutogaiGaikokujinUpdateCount(宛名.getJutogaiKojinKihonUpdateCount());
        tmpEntity.setShikibetsuTaisho_jutogaiGaikokujinTorokuNo(宛名.getJutogaiKojinKihonTorokuNo());
        tmpEntity.setShikibetsuTaisho_hojinUpdateCount(宛名.getHojinUpdateCount());
        tmpEntity.setShikibetsuTaisho_hojinTorokuNo(宛名.getHojinTorokuNo());
        tmpEntity.setShikibetsuTaisho_kyoyushaUpdateCount(宛名.getKyoyushaUpdateCount());
        tmpEntity.setShikibetsuTaisho_kyoyushaTorokuNo(宛名.getKyoyushaTorokuNo());
        tmpEntity.setShikibetsuTaisho_shimeiSearchTorokuNo(宛名.getShimeiSearchTorokuNo());
        tmpEntity.setShikibetsuTaisho_yusenShimeiUpdateCount(宛名.getYusenShimeiUpdateCount());
        tmpEntity.setShikibetsuTaisho_yusenShimeiTimestamp(宛名.getYusenShimeiTimestamp());
    }

    private void set宛先の全項目(UaFt250FindAtesakiEntity 宛先, KetteiTsuchishoInfoTempEntity tmpEntity) {
        tmpEntity.setAtesaki_shikibetsuCode(宛先.getShikibetsuCode());
        tmpEntity.setAtesaki_atesakiShubetsu(宛先.getAtesakiShubetsu());
        tmpEntity.setAtesaki_gyomubetsuPrimaryKey(宛先.getGyomubetsuPrimaryKey());
        tmpEntity.setAtesaki_gyomuCode(宛先.getGyomuCode());
        tmpEntity.setAtesaki_subGyomuCode(宛先.getSubGyomuCode());
        tmpEntity.setAtesaki_gyomuGroupCode(宛先.getGyomuGroupCode());
        tmpEntity.setAtesaki_gyomuGroupName(宛先.getGyomuGroupName());
        tmpEntity.setAtesaki_subGyomuGroupCode(宛先.getSubGyomuGroupCode());
        tmpEntity.setAtesaki_subGyomuGroupName(宛先.getSubGyomuGroupName());
        tmpEntity.setAtesaki_kamokuCode(宛先.getKamokuCode());
        tmpEntity.setAtesaki_gyomuKoyuKey(宛先.getGyomuKoyuKey());
        tmpEntity.setAtesaki_kannaiKangaiKubun(宛先.getKannaiKangaiKubun());
        tmpEntity.setAtesaki_zenkokuJushoCode(宛先.getZenkokuJushoCode());
        tmpEntity.setAtesaki_choikiCode(宛先.getChoikiCode());
        tmpEntity.setAtesaki_jusho(宛先.getJusho());
        tmpEntity.setAtesaki_yubinNo(宛先.getYubinNo());
        tmpEntity.setAtesaki_banchiCode1(宛先.getBanchiCode1());
        tmpEntity.setAtesaki_banchiCode2(宛先.getBanchiCode2());
        tmpEntity.setAtesaki_banchiCode3(宛先.getBanchiCode3());
        tmpEntity.setAtesaki_banchiCode4(宛先.getBanchiCode4());
        tmpEntity.setAtesaki_banchi(宛先.getBanchi());
        tmpEntity.setAtesaki_katagakiInjiFlag(宛先.getKatagakiInjiFlag());
        tmpEntity.setAtesaki_katagaki(宛先.getKatagaki());
        tmpEntity.setAtesaki_gyoseikuCode(宛先.getGyoseikuCode());
        tmpEntity.setAtesaki_gyoseiku(宛先.getGyoseiku());
        tmpEntity.setAtesaki_chikuCode1(宛先.getChikuCode1());
        tmpEntity.setAtesaki_chiku1(宛先.getChiku1());
        tmpEntity.setAtesaki_chikuCode2(宛先.getChikuCode2());
        tmpEntity.setAtesaki_chiku2(宛先.getChiku2());
        tmpEntity.setAtesaki_chikuCode3(宛先.getChikuCode3());
        tmpEntity.setAtesaki_chiku3(宛先.getChiku3());
        tmpEntity.setAtesaki_juminShubetsuCode(宛先.getJuminShubetsuCode());
        tmpEntity.setAtesaki_juminJotaiCode(宛先.getJuminJotaiCode());
        tmpEntity.setAtesaki_kanjiShimei(宛先.getKanjiShimei());
        tmpEntity.setAtesaki_kanaShimei(宛先.getKanaShimei());
        tmpEntity.setAtesaki_gaikokujinShimei(宛先.getGaikokujinShimei());
        tmpEntity.setAtesaki_gaikokujinHeikimei(宛先.getGaikokujinHeikimei());
        tmpEntity.setAtesaki_gaikokujinKanaShimei(宛先.getGaikokujinKanaShimei());
        tmpEntity.setAtesaki_tsushomei(宛先.getTsushomei());
        tmpEntity.setAtesaki_kanaTsushomei(宛先.getKanaTsushomei());
        tmpEntity.setAtesaki_shimeiRiyoKubun(宛先.getShimeiRiyoKubun());
        tmpEntity.setAtesaki_kyoyushaMeisho(宛先.getKyoyushaMeisho());
        tmpEntity.setAtesaki_kyoyushaKanaMeisho(宛先.getKyoyushaKanaMeisho());
        tmpEntity.setAtesaki_hojinKeitaiCode(宛先.getHojinKeitaiCode());
        tmpEntity.setAtesaki_hojinMeiHenshuKubun(宛先.getHojinMeiHenshuKubun());
        tmpEntity.setAtesaki_hojinKeitaiRyakushoKubun(宛先.getHojinKeitaiRyakushoKubun());
        tmpEntity.setAtesaki_hojinMeisho(宛先.getHojinMeisho());
        tmpEntity.setAtesaki_hojinKanaMeisho(宛先.getHojinKanaMeisho());
        tmpEntity.setAtesaki_hojinShitenMeisho(宛先.getHojinShitenMeisho());
        tmpEntity.setAtesaki_hojinShitenKanaMeisho(宛先.getHojinKanaMeisho());
        tmpEntity.setAtesaki_sofusakiMeisho(宛先.getHojinMeisho());
        tmpEntity.setAtesaki_sofusakiKanaMeisho(宛先.getSofusakiKanaMeisho());
        tmpEntity.setAtesaki_renrakusaki1(宛先.getRenrakusaki1());
        tmpEntity.setAtesaki_renrakusakiKubun1(宛先.getRenrakusakiKubun1());
        tmpEntity.setAtesaki_renrakusaki2(宛先.getRenrakusaki2());
        tmpEntity.setAtesaki_renrakusakiKubun2(宛先.getRenrakusakiKubun2());
        tmpEntity.setAtesaki_renrakusaki3(宛先.getRenrakusaki3());
        tmpEntity.setAtesaki_renrakusakiKubun3(宛先.getRenrakusakiKubun3());
        tmpEntity.setAtesaki_mailAddress(宛先.getMailAddress());
        tmpEntity.setAtesaki_dainoKankeiCode(宛先.getDainoKankeiCode());
        tmpEntity.setAtesaki_biko(宛先.getBiko());
        tmpEntity.setAtesaki_honninJuminShubetsuCode(宛先.getHonninJuminShubetsuCode());
        tmpEntity.setAtesaki_honninJuminJotaiCode(宛先.getHonninJuminJotaiCode());
        tmpEntity.setAtesaki_honninKanjiShimei(宛先.getHonninKanjiShimei());
        tmpEntity.setAtesaki_honninKanaShimei(宛先.getHonninKanaShimei());
        tmpEntity.setAtesaki_honninGaikokujinShimei(宛先.getHonninGaikokujinHeikimei());
        tmpEntity.setAtesaki_honninGaikokujinHeikimei(宛先.getHonninGaikokujinHeikimei());
        tmpEntity.setAtesaki_honninGaikokujinKanaShimei(宛先.getHonninGaikokujinKanaShimei());
        tmpEntity.setAtesaki_honninTsushomei(宛先.getHonninTsushomei());
        tmpEntity.setAtesaki_honninKanaTsushomei(宛先.getHonninKanaTsushomei());
        tmpEntity.setAtesaki_honninShimeiRiyoKubun(宛先.getHonninShimeiRiyoKubun());
        tmpEntity.setAtesaki_honninKyoyushaMeisho(宛先.getHonninKyoyushaMeisho());
        tmpEntity.setAtesaki_honninKyoyushaKanaMeisho(宛先.getHonninKyoyushaKanaMeisho());
        tmpEntity.setAtesaki_honninHojinKeitaiCode(宛先.getHonninHojinKeitaiCode());
        tmpEntity.setAtesaki_honninHojinMeiHenshuKubun(宛先.getHonninHojinMeiHenshuKubun());
        tmpEntity.setAtesaki_honninHojinKeitaiRyakushoKubun(宛先.getHonninHojinKeitaiRyakushoKubun());
        tmpEntity.setAtesaki_honninHojinMeisho(宛先.getHonninHojinMeisho());
        tmpEntity.setAtesaki_honninHojinKanaMeisho(宛先.getHonninHojinKanaMeisho());
        tmpEntity.setAtesaki_honninHojinShitenMeisho(宛先.getHojinShitenMeisho());
        tmpEntity.setAtesaki_honninHojinShitenKanaMeisho(宛先.getHonninHojinKanaMeisho());
        tmpEntity.setAtesaki_honninDaihyoshaShikibetsuCode(宛先.getHonninDaihyoshaShikibetsuCode());
        tmpEntity.setAtesaki_honninDaihyoshaJuminShubetsuCode(宛先.getHonninDaihyoshaJuminShubetsuCode());
        tmpEntity.setAtesaki_honninDaihyoshaShimei(宛先.getHonninDaihyoshaShimei());
        tmpEntity.setAtesaki_honninDaihyoshaKanaShimei(宛先.getHonninDaihyoshaKanaShimei());
        tmpEntity.setAtesaki_honninDaihyoshaNihonjinShimei(宛先.getHonninDaihyoshaNihonjinShimei());
        tmpEntity.setAtesaki_honninDaihyoshaNihonjinKanaShimei(宛先.getHonninDaihyoshaNihonjinKanaShimei());
        tmpEntity.setAtesaki_honninDaihyoshaGaikokujinShimei(宛先.getHonninDaihyoshaGaikokujinShimei());
        tmpEntity.setAtesaki_honninDaihyoshaGaikokujinHeikimei(宛先.getHonninDaihyoshaGaikokujinHeikimei());
        tmpEntity.setAtesaki_honninDaihyoshaGaikokujinKanaShimei(宛先.getHonninDaihyoshaGaikokujinKanaShimei());
        tmpEntity.setAtesaki_honninDaihyoshaTsushomei(宛先.getHonninDaihyoshaTsushomei());
        tmpEntity.setAtesaki_honninDaihyoshaShimeiRiyoKubun(宛先.getHonninDaihyoshaShimeiRiyoKubun());
        tmpEntity.setAtesaki_honninDaihyoshaKanaTsushomei(宛先.getHonninDaihyoshaKanaTsushomei());
        tmpEntity.setAtesaki_setainushiShikibetsuCode(宛先.getSetainushiShikibetsuCode());
        tmpEntity.setAtesaki_setainushiKannaiKangaiKubun(宛先.getSetainushiKannaiKangaiKubun());
        tmpEntity.setAtesaki_setainushiZenkokuJushoCode(宛先.getSetainushiZenkokuJushoCode());
        tmpEntity.setAtesaki_setainushiChoikiCode(宛先.getSetainushiChoikiCode());
        tmpEntity.setAtesaki_setainushiJusho(宛先.getSetainushiJusho());
        tmpEntity.setAtesaki_setainushiYubinNo(宛先.getSetainushiYubinNo());
        tmpEntity.setAtesaki_setainushiBanchiCode1(宛先.getSetainushiBanchiCode1());
        tmpEntity.setAtesaki_setainushiBanchiCode2(宛先.getSetainushiBanchiCode2());
        tmpEntity.setAtesaki_setainushiBanchiCode3(宛先.getSetainushiBanchiCode3());
        tmpEntity.setAtesaki_setainushiBanchiCode4(宛先.getSetainushiBanchiCode4());
        tmpEntity.setAtesaki_setainushiBanchi(宛先.getSetainushiBanchi());
        tmpEntity.setAtesaki_setainushiKatagakiInjiFlag(宛先.getSetainushiKatagakiInjiFlag());
        tmpEntity.setAtesaki_setainushiKatagaki(宛先.getSetainushiKatagaki());
        tmpEntity.setAtesaki_setainushiGyoseikuCode(宛先.getSetainushiGyoseikuCode());
        tmpEntity.setAtesaki_setainushiGyoseikuName(宛先.getSetainushiGyoseikuName());
        tmpEntity.setAtesaki_setainushiChikuCode1(宛先.getSetainushiChikuCode1());
        tmpEntity.setAtesaki_setainushiChiku1(宛先.getSetainushiChiku1());
        tmpEntity.setAtesaki_setainushiChikuCode2(宛先.getSetainushiChikuCode2());
        tmpEntity.setAtesaki_setainushiChiku2(宛先.getSetainushiChiku2());
        tmpEntity.setAtesaki_setainushiChikuCode3(宛先.getSetainushiChikuCode3());
        tmpEntity.setAtesaki_setainushiChiku3(宛先.getSetainushiChiku3());
        tmpEntity.setAtesaki_setainushiJuminShubetsuCode(宛先.getSetainushiJuminJotaiCode());
        tmpEntity.setAtesaki_setainushiJuminJotaiCode(宛先.getSetainushiJuminJotaiCode());
        tmpEntity.setAtesaki_setainushiKanjiShimei(宛先.getSetainushiKanjiShimei());
        tmpEntity.setAtesaki_setainushiKanaShimei(宛先.getSetainushiKanaShimei());
        tmpEntity.setAtesaki_setainushiGaikokujinShimei(宛先.getSetainushiGaikokujinShimei());
        tmpEntity.setAtesaki_setainushiGaikokujinHeikimei(宛先.getSetainushiGaikokujinHeikimei());
        tmpEntity.setAtesaki_setainushiGaikokujinKanaShimei(宛先.getSetainushiGaikokujinKanaShimei());
        tmpEntity.setAtesaki_setainushiTsushomei(宛先.getSetainushiTsushomei());
        tmpEntity.setAtesaki_setainushiKanaTsushomei(宛先.getSetainushiKanaTsushomei());
        tmpEntity.setAtesaki_setainushiShimeiRiyoKubun(宛先.getSetainushiShimeiRiyoKubun());
        tmpEntity.setAtesaki_setainushiRenrakusaki1(宛先.getSetainushiRenrakusaki1());
        tmpEntity.setAtesaki_setainushiRenrakusakiKubun1(宛先.getSetainushiRenrakusakiKubun1());
        tmpEntity.setAtesaki_setainushiRenrakusaki2(宛先.getSetainushiRenrakusaki2());
        tmpEntity.setAtesaki_setainushiRenrakusakiKubun2(宛先.getSetainushiRenrakusakiKubun2());
        tmpEntity.setAtesaki_setainushiRenrakusaki3(宛先.getSetainushiRenrakusaki3());
        tmpEntity.setAtesaki_setainushiRenrakusakiKubun3(宛先.getSetainushiRenrakusakiKubun3());
        tmpEntity.setAtesaki_setainushiMailAddress(宛先.getSetainushiMailAddress());
        tmpEntity.setAtesaki_dainoninShikibetsuCode(宛先.getDainoninShikibetsuCode());
        tmpEntity.setAtesaki_honninSetaiCode(宛先.getHonninSetaiCode());
        tmpEntity.setAtesaki_dainoninSetaiCode(宛先.getDainoninSetaiCode());
    }
}
