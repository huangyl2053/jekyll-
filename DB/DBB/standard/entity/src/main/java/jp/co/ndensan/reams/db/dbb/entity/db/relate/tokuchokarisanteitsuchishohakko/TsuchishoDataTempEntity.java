/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteitsuchishohakko;

import jp.co.ndensan.reams.ca.cax.entity.db.psm.CaFt703FindNokumiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.fukajoho.FukaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.keisangojoho.DbTKeisangoJohoTempTableEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.ue.uex.definition.core.RenkeiShubetsu;
import jp.co.ndensan.reams.ue.uex.definition.core.TokubetsuChoshuGimushaCode;
import jp.co.ndensan.reams.ue.uex.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import lombok.Getter;
import lombok.Setter;

/**
 * 仮算定のデータのエンティティクラスです。
 *
 * @reamsid_L DBB-0790-030 chenaoqi
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TsuchishoDataTempEntity extends DbTableEntityBase<TsuchishoDataTempEntity> implements IDbAccessable {

    private DbTKeisangoJohoTempTableEntity 計算後情報;
    private UaFt200FindShikibetsuTaishoEntity 宛名;
    private UaFt250FindAtesakiEntity 宛先;
    private CaFt703FindNokumiEntity 納組;
    private UeT0511NenkinTokuchoKaifuJohoEntity 対象者_追加含む情報;
    private FukaJohoRelateEntity 前年度賦課情報;
    private RString 被保険者区分;
    private Decimal 前年度特徴期別金額01;
    private Decimal 前年度特徴期別金額02;
    private Decimal 前年度特徴期別金額03;
    private Decimal 前年度特徴期別金額04;
    private Decimal 前年度特徴期別金額05;
    private Decimal 前年度特徴期別金額06;
    private static final Long ZERO = 0L;

    /**
     * 一時テーブルエンティティKarisanteiIkkatsuHakkoTempEntityを生成します。
     *
     * @return KarisanteiIkkatsuHakkoTempEntity
     */
    public KarisanteiIkkatsuHakkoTempEntity toKarisanteiIkkatsuHakkoTempEntity() {
        KarisanteiIkkatsuHakkoTempEntity entity = new KarisanteiIkkatsuHakkoTempEntity();
        if (計算後情報 != null) {
            set更正後_計算後情報の全項目(entity);
        }
        if (宛名 != null) {
            set宛名の全項目(entity);
        }
        if (宛先 != null) {
            set宛先の全項目(entity);
        }
        if (納組 != null) {
            set納組の全項目(entity);
        }
        if (対象者_追加含む情報 != null) {
            set対象者_追加含む情報の全項目(entity);
        }
        return entity;

    }

    private void set納組の全項目(KarisanteiIkkatsuHakkoTempEntity entity) {
        if (納組.getSeikyuHoho() != null) {
            entity.setCaT0714SeikyuHoho_insertDantaiCd(納組.getSeikyuHoho().getInsertDantaiCd());
            entity.setCaT0714SeikyuHoho_isDeleted(納組.getSeikyuHoho().getIsDeleted());
            entity.setCaT0714SeikyuHoho_shikibetsuCode(納組.getSeikyuHoho().getShikibetsuCode());
            entity.setCaT0714SeikyuHoho_gyomubetsuPrimaryKey(納組.getSeikyuHoho().getGyomubetsuPrimaryKey());
            entity.setCaT0714SeikyuHoho_gyomuKoyuKey(納組.getSeikyuHoho().getGyomuKoyuKey());
            entity.setCaT0714SeikyuHoho_shiharaiHoho(納組.getSeikyuHoho().getShiharaiHoho());
            //entity.setCaT0714SeikyuHoho_zennoKubun(納組.getSeikyuHoho().getZennoKubun());
            entity.setCaT0714SeikyuHoho_creditKeizokuTorokuKey(納組.getSeikyuHoho().getCreditKeizokuTorokuKey());
            entity.setCaT0714SeikyuHoho_kaishiYMD(納組.getSeikyuHoho().getKaishiYMD());
            entity.setCaT0714SeikyuHoho_shuryoYMD(納組.getSeikyuHoho().getShuryoYMD());
            entity.setCaT0714SeikyuHoho_nokumiShurui(納組.getSeikyuHoho().getNokumiShurui());
            entity.setCaT0714SeikyuHoho_nokumiCode(納組.getSeikyuHoho().getNokumiCode());
            Long creditKeiyakushaId = 納組.getSeikyuHoho().getCreditKeiyakushaId();
            entity.setCaT0714SeikyuHoho_creditKeiyakushaId(creditKeiyakushaId != null ? creditKeiyakushaId : ZERO);
            Long kozaId = 納組.getSeikyuHoho().getKozaId();
            entity.setCaT0714SeikyuHoho_kozaId(kozaId != null ? kozaId : ZERO);
        }
        if (納組.getNokumi() != null) {
            entity.setCaT0752Nokumi_insertDantaiCd(納組.getNokumi().getInsertDantaiCd());
            entity.setCaT0752Nokumi_isDeleted(納組.getNokumi().getIsDeleted());
            entity.setCaT0752Nokumi_nokumiShurui(納組.getNokumi().getNokumiShurui());
            entity.setCaT0752Nokumi_nokumiCode(納組.getNokumi().getNokumiCode());
            entity.setCaT0752Nokumi_meisho(納組.getNokumi().getMeisho());
            entity.setCaT0752Nokumi_kanaMeisho(納組.getNokumi().getKanaMeisho());
            entity.setCaT0752Nokumi_kensakuyoKanaMeisho(納組.getNokumi().getKensakuyoKanaMeisho());
            entity.setCaT0752Nokumi_daihyoshaShikibetsuCode(納組.getNokumi().getDaihyoshaShikibetsuCode());
            entity.setCaT0752Nokumi_daihyoshaShimei(納組.getNokumi().getDaihyoshaShimei());
        }

    }

    private void set宛先の全項目(KarisanteiIkkatsuHakkoTempEntity entity) {
        entity.setAtesaki_shikibetsuCode(宛先.getShikibetsuCode());
        entity.setAtesaki_atesakiShubetsu(宛先.getAtesakiShubetsu());
        entity.setAtesaki_gyomubetsuPrimaryKey(宛先.getGyomubetsuPrimaryKey());
        entity.setAtesaki_gyomuCode(宛先.getGyomuCode());
        entity.setAtesaki_subGyomuCode(宛先.getSubGyomuCode());
        entity.setAtesaki_gyomuGroupCode(宛先.getGyomuGroupCode());
        entity.setAtesaki_gyomuGroupName(宛先.getGyomuGroupName());
        entity.setAtesaki_subGyomuGroupCode(宛先.getSubGyomuGroupCode());
        entity.setAtesaki_subGyomuGroupName(宛先.getSubGyomuGroupName());
        entity.setAtesaki_kamokuCode(宛先.getKamokuCode());
        entity.setAtesaki_gyomuKoyuKey(宛先.getGyomuKoyuKey());
        entity.setAtesaki_kannaiKangaiKubun(宛先.getKannaiKangaiKubun());
        entity.setAtesaki_zenkokuJushoCode(宛先.getZenkokuJushoCode());
        entity.setAtesaki_choikiCode(宛先.getChoikiCode());
        entity.setAtesaki_jusho(宛先.getJusho());
        entity.setAtesaki_yubinNo(宛先.getYubinNo());
        entity.setAtesaki_banchiCode1(宛先.getBanchiCode1());
        entity.setAtesaki_banchiCode2(宛先.getBanchiCode2());
        entity.setAtesaki_banchiCode3(宛先.getBanchiCode3());
        entity.setAtesaki_banchiCode4(宛先.getBanchiCode4());
        entity.setAtesaki_banchi(宛先.getBanchi());
        entity.setAtesaki_katagakiInjiFlag(宛先.getKatagakiInjiFlag());
        entity.setAtesaki_katagaki(宛先.getKatagaki());
        entity.setAtesaki_gyoseikuCode(宛先.getGyoseikuCode());
        entity.setAtesaki_gyoseiku(宛先.getGyoseiku());
        entity.setAtesaki_chikuCode1(宛先.getChikuCode1());
        entity.setAtesaki_chiku1(宛先.getChiku1());
        entity.setAtesaki_chikuCode2(宛先.getChikuCode2());
        entity.setAtesaki_chiku2(宛先.getChiku2());
        entity.setAtesaki_chikuCode3(宛先.getChikuCode3());
        entity.setAtesaki_chiku3(宛先.getChiku3());
        entity.setAtesaki_juminShubetsuCode(宛先.getJuminShubetsuCode());
        entity.setAtesaki_juminJotaiCode(宛先.getJuminJotaiCode());
        entity.setAtesaki_kanjiShimei(宛先.getKanjiShimei());
        entity.setAtesaki_kanaShimei(宛先.getKanaShimei());
        entity.setAtesaki_gaikokujinShimei(宛先.getGaikokujinShimei());
        entity.setAtesaki_gaikokujinHeikimei(宛先.getGaikokujinHeikimei());
        entity.setAtesaki_gaikokujinKanaShimei(宛先.getGaikokujinKanaShimei());
        entity.setAtesaki_tsushomei(宛先.getTsushomei());
        entity.setAtesaki_kanaTsushomei(宛先.getKanaTsushomei());
        entity.setAtesaki_shimeiRiyoKubun(宛先.getShimeiRiyoKubun());
        entity.setAtesaki_kyoyushaMeisho(宛先.getKyoyushaMeisho());
        entity.setAtesaki_kyoyushaKanaMeisho(宛先.getKyoyushaKanaMeisho());
        entity.setAtesaki_hojinKeitaiCode(宛先.getHojinKeitaiCode());
        entity.setAtesaki_hojinMeiHenshuKubun(宛先.getHojinMeiHenshuKubun());
        entity.setAtesaki_hojinKeitaiRyakushoKubun(宛先.getHojinKeitaiRyakushoKubun());
        entity.setAtesaki_hojinMeisho(宛先.getHojinMeisho());
        entity.setAtesaki_hojinKanaMeisho(宛先.getHojinKanaMeisho());
        entity.setAtesaki_hojinShitenMeisho(宛先.getHojinShitenMeisho());
        entity.setAtesaki_hojinShitenKanaMeisho(宛先.getHojinKanaMeisho());
        entity.setAtesaki_sofusakiMeisho(宛先.getHojinMeisho());
        entity.setAtesaki_sofusakiKanaMeisho(宛先.getSofusakiKanaMeisho());
        entity.setAtesaki_renrakusaki1(宛先.getRenrakusaki1());
        entity.setAtesaki_renrakusakiKubun1(宛先.getRenrakusakiKubun1());
        entity.setAtesaki_renrakusaki2(宛先.getRenrakusaki2());
        entity.setAtesaki_renrakusakiKubun2(宛先.getRenrakusakiKubun2());
        entity.setAtesaki_renrakusaki3(宛先.getRenrakusaki3());
        entity.setAtesaki_renrakusakiKubun3(宛先.getRenrakusakiKubun3());
        entity.setAtesaki_mailAddress(宛先.getMailAddress());
        entity.setAtesaki_dainoKankeiCode(宛先.getDainoKankeiCode());
        entity.setAtesaki_biko(宛先.getBiko());
        entity.setAtesaki_honninJuminShubetsuCode(宛先.getHonninJuminShubetsuCode());
        entity.setAtesaki_honninJuminJotaiCode(宛先.getHonninJuminJotaiCode());
        entity.setAtesaki_honninKanjiShimei(宛先.getHonninKanjiShimei());
        entity.setAtesaki_honninKanaShimei(宛先.getHonninKanaShimei());
        entity.setAtesaki_honninGaikokujinShimei(宛先.getHonninGaikokujinHeikimei());
        entity.setAtesaki_honninGaikokujinHeikimei(宛先.getHonninGaikokujinHeikimei());
        entity.setAtesaki_honninGaikokujinKanaShimei(宛先.getHonninGaikokujinKanaShimei());
        entity.setAtesaki_honninTsushomei(宛先.getHonninTsushomei());
        entity.setAtesaki_honninKanaTsushomei(宛先.getHonninKanaTsushomei());
        entity.setAtesaki_honninShimeiRiyoKubun(宛先.getHonninShimeiRiyoKubun());
        entity.setAtesaki_honninKyoyushaMeisho(宛先.getHonninKyoyushaMeisho());
        entity.setAtesaki_honninKyoyushaKanaMeisho(宛先.getHonninKyoyushaKanaMeisho());
        entity.setAtesaki_honninHojinKeitaiCode(宛先.getHonninHojinKeitaiCode());
        entity.setAtesaki_honninHojinMeiHenshuKubun(宛先.getHonninHojinMeiHenshuKubun());
        entity.setAtesaki_honninHojinKeitaiRyakushoKubun(宛先.getHonninHojinKeitaiRyakushoKubun());
        entity.setAtesaki_honninHojinMeisho(宛先.getHonninHojinMeisho());
        entity.setAtesaki_honninHojinKanaMeisho(宛先.getHonninHojinKanaMeisho());
        entity.setAtesaki_honninHojinShitenMeisho(宛先.getHojinShitenMeisho());
        entity.setAtesaki_honninHojinShitenKanaMeisho(宛先.getHonninHojinKanaMeisho());
        entity.setAtesaki_honninDaihyoshaShikibetsuCode(宛先.getHonninDaihyoshaShikibetsuCode());
        entity.setAtesaki_honninDaihyoshaJuminShubetsuCode(宛先.getHonninDaihyoshaJuminShubetsuCode());
        entity.setAtesaki_honninDaihyoshaShimei(宛先.getHonninDaihyoshaShimei());
        entity.setAtesaki_honninDaihyoshaKanaShimei(宛先.getHonninDaihyoshaKanaShimei());
        entity.setAtesaki_honninDaihyoshaNihonjinShimei(宛先.getHonninDaihyoshaNihonjinShimei());
        entity.setAtesaki_honninDaihyoshaNihonjinKanaShimei(宛先.getHonninDaihyoshaNihonjinKanaShimei());
        entity.setAtesaki_honninDaihyoshaGaikokujinShimei(宛先.getHonninDaihyoshaGaikokujinShimei());
        entity.setAtesaki_honninDaihyoshaGaikokujinHeikimei(宛先.getHonninDaihyoshaGaikokujinHeikimei());
        entity.setAtesaki_honninDaihyoshaGaikokujinKanaShimei(宛先.getHonninDaihyoshaGaikokujinKanaShimei());
        entity.setAtesaki_honninDaihyoshaTsushomei(宛先.getHonninDaihyoshaTsushomei());
        entity.setAtesaki_honninDaihyoshaShimeiRiyoKubun(宛先.getHonninDaihyoshaShimeiRiyoKubun());
        entity.setAtesaki_honninDaihyoshaKanaTsushomei(宛先.getHonninDaihyoshaKanaTsushomei());
        entity.setAtesaki_setainushiShikibetsuCode(宛先.getSetainushiShikibetsuCode());
        entity.setAtesaki_setainushiKannaiKangaiKubun(宛先.getSetainushiKannaiKangaiKubun());
        entity.setAtesaki_setainushiZenkokuJushoCode(宛先.getSetainushiZenkokuJushoCode());
        entity.setAtesaki_setainushiChoikiCode(宛先.getSetainushiChoikiCode());
        entity.setAtesaki_setainushiJusho(宛先.getSetainushiJusho());
        entity.setAtesaki_setainushiYubinNo(宛先.getSetainushiYubinNo());
        entity.setAtesaki_setainushiBanchiCode1(宛先.getSetainushiBanchiCode1());
        entity.setAtesaki_setainushiBanchiCode2(宛先.getSetainushiBanchiCode2());
        entity.setAtesaki_setainushiBanchiCode3(宛先.getSetainushiBanchiCode3());
        entity.setAtesaki_setainushiBanchiCode4(宛先.getSetainushiBanchiCode4());
        entity.setAtesaki_setainushiBanchi(宛先.getSetainushiBanchi());
        entity.setAtesaki_setainushiKatagakiInjiFlag(宛先.getSetainushiKatagakiInjiFlag());
        entity.setAtesaki_setainushiKatagaki(宛先.getSetainushiKatagaki());
        entity.setAtesaki_setainushiGyoseikuCode(宛先.getSetainushiGyoseikuCode());
        entity.setAtesaki_setainushiGyoseikuName(宛先.getSetainushiGyoseikuName());
        entity.setAtesaki_setainushiChikuCode1(宛先.getSetainushiChikuCode1());
        entity.setAtesaki_setainushiChiku1(宛先.getSetainushiChiku1());
        entity.setAtesaki_setainushiChikuCode2(宛先.getSetainushiChikuCode2());
        entity.setAtesaki_setainushiChiku2(宛先.getSetainushiChiku2());
        entity.setAtesaki_setainushiChikuCode3(宛先.getSetainushiChikuCode3());
        entity.setAtesaki_setainushiChiku3(宛先.getSetainushiChiku3());
        entity.setAtesaki_setainushiJuminShubetsuCode(宛先.getSetainushiJuminJotaiCode());
        entity.setAtesaki_setainushiJuminJotaiCode(宛先.getSetainushiJuminJotaiCode());
        entity.setAtesaki_setainushiKanjiShimei(宛先.getSetainushiKanjiShimei());
        entity.setAtesaki_setainushiKanaShimei(宛先.getSetainushiKanaShimei());
        entity.setAtesaki_setainushiGaikokujinShimei(宛先.getSetainushiGaikokujinShimei());
        entity.setAtesaki_setainushiGaikokujinHeikimei(宛先.getSetainushiGaikokujinHeikimei());
        entity.setAtesaki_setainushiGaikokujinKanaShimei(宛先.getSetainushiGaikokujinKanaShimei());
        entity.setAtesaki_setainushiTsushomei(宛先.getSetainushiTsushomei());
        entity.setAtesaki_setainushiKanaTsushomei(宛先.getSetainushiKanaTsushomei());
        entity.setAtesaki_setainushiShimeiRiyoKubun(宛先.getSetainushiShimeiRiyoKubun());
        entity.setAtesaki_setainushiRenrakusaki1(宛先.getSetainushiRenrakusaki1());
        entity.setAtesaki_setainushiRenrakusakiKubun1(宛先.getSetainushiRenrakusakiKubun1());
        entity.setAtesaki_setainushiRenrakusaki2(宛先.getSetainushiRenrakusaki2());
        entity.setAtesaki_setainushiRenrakusakiKubun2(宛先.getSetainushiRenrakusakiKubun2());
        entity.setAtesaki_setainushiRenrakusaki3(宛先.getSetainushiRenrakusaki3());
        entity.setAtesaki_setainushiRenrakusakiKubun3(宛先.getSetainushiRenrakusakiKubun3());
        entity.setAtesaki_setainushiMailAddress(宛先.getSetainushiMailAddress());
        entity.setAtesaki_dainoninShikibetsuCode(宛先.getDainoninShikibetsuCode());
    }

    private void set宛名の全項目(KarisanteiIkkatsuHakkoTempEntity entity) {

        entity.setAtena_shikibetsuCode(宛名.getShikibetsuCode());
        entity.setAtena_genLasdecCode(宛名.getGenLasdecCode());
        entity.setAtena_kyuLasdecCode(宛名.getKyuLasdecCode());
        entity.setAtena_kyuLasdecCodeRenban(宛名.getKyuLasdecCodeRenban());
        entity.setAtena_gyomuCode(宛名.getGyomuCode());
        entity.setAtena_rirekiNo(宛名.getRirekiNo());
        entity.setAtena_currentFlag(宛名.getCurrentFlag());
        entity.setAtena_juminShubetsuCode(宛名.getJuminShubetsuCode());
        entity.setAtena_kojinNo(宛名.getKojinNo());
        entity.setAtena_hojinNo(宛名.getHojinNo());
        entity.setAtena_shoriYMD(宛名.getShoriYMD());
        entity.setAtena_idoJiyuCode(宛名.getIdoJiyuCode());
        entity.setAtena_idoYMD(宛名.getIdoYMD());
        entity.setAtena_todokedeJiyuCode(宛名.getTodokedeJiyuCode());
        entity.setAtena_todokedeYMD(宛名.getTodokedeYMD());
        entity.setAtena_idoRiyuCode(宛名.getIdoRiyuCode());
        entity.setAtena_meisho(宛名.getMeisho());
        entity.setAtena_kanaMeisho(宛名.getKanaMeisho());
        entity.setAtena_kannaiKangaiKubun(宛名.getKannaiKangaiKubun());
        entity.setAtena_yubinNo(宛名.getYubinNo());
        entity.setAtena_choikiCode(宛名.getChoikiCode());
        entity.setAtena_zenkokuJushoCode(宛名.getZenkokuJushoCode());
        entity.setAtena_jusho(宛名.getJusho());
        entity.setAtena_banchiCode1(宛名.getBanchiCode1());
        entity.setAtena_banchiCode2(宛名.getBanchiCode2());
        entity.setAtena_banchiCode3(宛名.getBanchiCode3());
        entity.setAtena_banchiCode4(宛名.getBanchiCode4());
        entity.setAtena_banchi(宛名.getBanchi());
        entity.setAtena_katagaki(宛名.getKatagaki());
        entity.setAtena_katagakiInjiFlag(宛名.getKatagakiInjiFlag());
        entity.setAtena_gyoseikuCode(宛名.getGyoseikuCode());
        entity.setAtena_gyoseikuName(宛名.getGyoseikuName());
        entity.setAtena_chikuCode1(宛名.getChikuCode1());
        entity.setAtena_chikuName1(宛名.getChikuName1());
        entity.setAtena_chikuCode2(宛名.getChikuCode2());
        entity.setAtena_chikuName2(宛名.getChikuName2());
        entity.setAtena_chikuCode3(宛名.getChikuCode3());
        entity.setAtena_chikuName3(宛名.getChikuName3());
        entity.setAtena_shogakkokuCode(宛名.getShogakkokuCode());
        entity.setAtena_shogakkokuName(宛名.getShogakkokuName());
        entity.setAtena_chugakkokuCode(宛名.getChugakkokuCode());
        entity.setAtena_chugakkokuName(宛名.getChugakkokuName());
        entity.setAtena_tohyokuCode(宛名.getTohyokuCode());
        entity.setAtena_tohyokuName(宛名.getTohyokuName());
        entity.setAtena_juminJotaiCode(宛名.getJuminJotaiCode());
        entity.setAtena_setaiCode(宛名.getSetaiCode());
        entity.setAtena_seinengappiYMD(宛名.getSeinengappiYMD());
        entity.setAtena_seinengappiFushoKubun(宛名.getSeinengappiFushoKubun());
        entity.setAtena_seibetsuCode(宛名.getSeibetsuCode());
        entity.setAtena_tsuzukigaraCode(宛名.getTsuzukigaraCode());
        entity.setAtena_tsuzukigara(宛名.getTsuzukigara());
        entity.setAtena_kazokuNo(宛名.getKazokuNo());
        entity.setAtena_juminhyoHyojijun(宛名.getJuminhyoHyojijun());
        entity.setAtena_kikaYMD(宛名.getKikaYMD());
        entity.setAtena_kanjiShimei(宛名.getKanjiShimei());
        entity.setAtena_kanaShimei(宛名.getKanaShimei());
        entity.setAtena_honsekiZenkokuJushoCode(宛名.getHonsekiZenkokuJushoCode());
        entity.setAtena_honsekiChoikiCode(宛名.getHonsekiChoikiCode());
        entity.setAtena_honsekiJusho(宛名.getHonsekiJusho());
        entity.setAtena_honsekiBanchi(宛名.getHonsekiBanchi());
        entity.setAtena_hittosha(宛名.getHittosha());
        entity.setAtena_gaikokujinShimei(宛名.getGaikokujinShimei());
        entity.setAtena_gaikokujinHeikimei(宛名.getGaikokujinHeikimei());
        entity.setAtena_gaikokujinKanaShimei(宛名.getGaikokujinKanaShimei());
        entity.setAtena_tsushomei(宛名.getTsushomei());
        entity.setAtena_shimeiRiyoKubun(宛名.getShimeiRiyoKubun());
        entity.setAtena_kanaTsushomei(宛名.getKanaTsushomei());
        entity.setAtena_katakanaHyoki(宛名.getKatakanaHyoki());
        entity.setAtena_kokusekiChiikiCode(宛名.getKokusekiChiikiCode());
        entity.setAtena_zairyuShikakuCode(宛名.getZairyuShikakuCode());
        entity.setAtena_zairyuKikanCode(宛名.getZairyuKikanCode());
        entity.setAtena_zairyuKikantoManryoYMD(宛名.getZairyuKikantoManryoYMD());
        entity.setAtena_zairyuCardtoNo(宛名.getZairyuCardtoNo());
        entity.setAtena_zairyuCardtoYukoYMD(宛名.getZairyuCardtoYukoYMD());
        entity.setAtena_dai30Jono45niKiteisuruKubun(宛名.getDai30Jono45niKiteisuruKubun());
        entity.setAtena_setainushiShikibetsuCode(宛名.getSetainushiShikibetsuCode());
        entity.setAtena_setainushiMei(宛名.getSetainushiMei());
        entity.setAtena_hojinKeitaiCode(宛名.getHojinKeitaiCode());
        entity.setAtena_hojinKeitaiMeisho(宛名.getHojinKeitaiMeisho());
        entity.setAtena_hojinKeitaiRyakusho(宛名.getHojinKeitaiRyakusho());
        entity.setAtena_hojinMeishoHenshuKubun(宛名.getHojinMeishoHenshuKubun());
        entity.setAtena_hojinKeitaiRyakushoKubun(宛名.getHojinKeitaiRyakushoKubun());
        entity.setAtena_hojinMeisho(宛名.getHojinMeisho());
        entity.setAtena_hojinKanaMeisho(宛名.getHojinKanaMeisho());
        entity.setAtena_hojinShitenMeisho(宛名.getHojinShitenMeisho());
        entity.setAtena_hojinShitenKanaMeisho(宛名.getHojinShitenKanaMeisho());
        entity.setAtena_daihyoshaShikibetsuCode(宛名.getDaihyoshaShikibetsuCode());
        entity.setAtena_daihyoshaJuminShubetsu(宛名.getDaihyoshaJuminShubetsu());
        entity.setAtena_daihyoshaShimei(宛名.getDaihyoshaShimei());
        entity.setAtena_daihyoshaKanaShimei(宛名.getDaihyoshaKanaShimei());
        entity.setAtena_daihyoshaNihonjinShimei(宛名.getDaihyoshaNihonjinShimei());
        entity.setAtena_daihyoshaNihonjinKanaShimei(宛名.getDaihyoshaNihonjinKanaShimei());
        entity.setAtena_daihyoshaGaikokujinShimei(宛名.getDaihyoshaGaikokujinHeikimei());
        entity.setAtena_daihyoshaGaikokujinHeikimei(宛名.getDaihyoshaGaikokujinHeikimei());
        entity.setAtena_daihyoshaGaikokujinKanaShimei(宛名.getDaihyoshaGaikokujinKanaShimei());
        entity.setAtena_daihyoshaTsushomei(宛名.getDaihyoshaTsushomei());
        entity.setAtena_daihyoshaShimeiRiyoKubun(宛名.getDaihyoshaShimeiRiyoKubun());
        entity.setAtena_daihyoshaKanaTsushomei(宛名.getDaihyoshaKanaTsushomei());
        entity.setAtena_daihyoshaKannaiKangaiKubun(宛名.getDaihyoshaKannaiKangaiKubun());
        entity.setAtena_daihyoshaYubinNo(宛名.getDaihyoshaYubinNo());
        entity.setAtena_daihyoshaChoikiCode(宛名.getDaihyoshaChoikiCode());
        entity.setAtena_daihyoshaZenkokuJushoCode(宛名.getDaihyoshaZenkokuJushoCode());
        entity.setAtena_daihyoshaJusho(宛名.getDaihyoshaJusho());
        entity.setAtena_daihyoshaBanchiCode1(宛名.getDaihyoshaBanchiCode1());
        entity.setAtena_daihyoshaBanchiCode2(宛名.getDaihyoshaBanchiCode2());
        entity.setAtena_daihyoshaBanchiCode3(宛名.getDaihyoshaBanchiCode3());
        entity.setAtena_daihyoshaBanchiCode4(宛名.getDaihyoshaBanchiCode4());
        entity.setAtena_daihyoshaBanchi(宛名.getDaihyoshaBanchi());
        entity.setAtena_daihyoshaKatagaki(宛名.getDaihyoshaKatagaki());
        entity.setAtena_ninkachiendantaiTorokuShikakuKubun(宛名.getNinkachiendantaiTorokuShikakuKubun());
        entity.setAtena_ninkachiendantaiNinkaYMD(宛名.getNinkachiendantaiNinkaYMD());
        entity.setAtena_kojinHojinKBN(宛名.getKojinHojinKBN());
        entity.setAtena_kyoyushaMeisho(宛名.getKyoyushaMeisho());
        entity.setAtena_kyoyushaKanaMeisho(宛名.getKyoyushaKanaMeisho());
        entity.setAtena_torokuJiyuCode(宛名.getTorokuJiyuCode());
        entity.setAtena_torokuIdoYMD(宛名.getTorokuIdoYMD());
        entity.setAtena_torokuTodokedeYMD(宛名.getTorokuTodokedeYMD());
        entity.setAtena_juteiJiyuCode(宛名.getJuteiJiyuCode());
        entity.setAtena_juteiIdoYMD(宛名.getJuteiIdoYMD());
        entity.setAtena_juteiTodokedeYMD(宛名.getJuteiTodokedeYMD());
        entity.setAtena_shojoJiyuCode(宛名.getShojoJiyuCode());
        entity.setAtena_shojoIdoYMD(宛名.getShojoIdoYMD());
        entity.setAtena_shojoTodokedeYMD(宛名.getShojoTodokedeYMD());
        entity.setAtena_jutonaiYubinNo(宛名.getJutonaiYubinNo());
        entity.setAtena_jutonaiChoikiCode(宛名.getJutonaiChoikiCode());
        entity.setAtena_jutonaiJusho(宛名.getJutonaiJusho());
        entity.setAtena_jutonaiBanchiCode1(宛名.getJutonaiBanchiCode1());
        entity.setAtena_jutonaiBanchiCode2(宛名.getJutonaiBanchiCode2());
        entity.setAtena_jutonaiBanchiCode3(宛名.getJutonaiBanchiCode3());
        entity.setAtena_jutonaiBanchiCode4(宛名.getJutonaiBanchiCode4());
        entity.setAtena_jutonaiBanchi(宛名.getJutonaiBanchi());
        entity.setAtena_jutonaiKatagaki(宛名.getJutonaiKatagaki());
        entity.setAtena_jutonaiKatagakiInjiFlag(宛名.getJutonaiKatagakiInjiFlag());
        entity.setAtena_tennyumaeYubinNo(宛名.getTennyumaeYubinNo());
        entity.setAtena_tennyumaeZenkokuJushoCode(宛名.getTennyumaeZenkokuJushoCode());
        entity.setAtena_tennyumaeJusho(宛名.getTennyumaeJusho());
        entity.setAtena_tennyumaeBanchi(宛名.getTennyumaeBanchi());
        set宛名の全項目_２(entity);
    }

    private void set宛名の全項目_２(KarisanteiIkkatsuHakkoTempEntity entity) {
        entity.setAtena_tennyumaeKatagaki(宛名.getTennyumaeKatagaki());
        entity.setAtena_tennyumaeSetainushimei(宛名.getTennyumaeSetainushimei());
        entity.setAtena_tennyumaeKyusei(宛名.getTennyumaeKyusei());
        entity.setAtena_saishuJutochiYubinNo(宛名.getSaishuJutochiYubinNo());
        entity.setAtena_saishuJutochiZenkokuJushoCode(宛名.getSaishuJutochiZenkokuJushoCode());
        entity.setAtena_saishuJutochiJusho(宛名.getSaishuJutochiJusho());
        entity.setAtena_saishuJutochiBanchi(宛名.getSaishuJutochiBanchi());
        entity.setAtena_saishuJutochiKatagaki(宛名.getSaishuJutochiKatagaki());
        entity.setAtena_saishuJutochiSetainushimei(宛名.getSaishuJutochiSetainushimei());
        entity.setAtena_tenshutsuYoteiIdoYMD(宛名.getTenshutsuYoteiIdoYMD());
        entity.setAtena_tenshutsuYoteiYubinNo(宛名.getTenshutsuKakuteiYubinNo());
        entity.setAtena_tenshutsuYoteiZenkokuJushoCode(宛名.getTenshutsuYoteiZenkokuJushoCode());
        entity.setAtena_tenshutsuYoteiJusho(宛名.getTenshutsuYoteiJusho());
        entity.setAtena_tenshutsuYoteiBanchi(宛名.getTenshutsuYoteiBanchi());
        entity.setAtena_tenshutsuYoteiKatagaki(宛名.getTenshutsuKakuteiKatagaki());
        entity.setAtena_tenshutsuYoteiSetainushimei(宛名.getTenshutsuYoteiSetainushimei());
        entity.setAtena_tenshutsuKakuteiIdoYMD(宛名.getTenshutsuKakuteiIdoYMD());
        entity.setAtena_tenshutsuKakuteiTsuchiYMD(宛名.getTenshutsuKakuteiTsuchiYMD());
        entity.setAtena_tenshutsuKakuteiYubinNo(宛名.getTenshutsuKakuteiYubinNo());
        entity.setAtena_tenshutsuKakuteiZenkokuJushoCode(宛名.getTenshutsuKakuteiZenkokuJushoCode());
        entity.setAtena_tenshutsuKakuteiJusho(宛名.getTenshutsuKakuteiJusho());
        entity.setAtena_tenshutsuKakuteiBanchi(宛名.getTenshutsuKakuteiBanchi());
        entity.setAtena_tenshutsuKakuteiKatagaki(宛名.getTenshutsuKakuteiKatagaki());
        entity.setAtena_tenshutsuKakuteiSetainushimei(宛名.getTenshutsuKakuteiSetainushimei());
        entity.setAtena_juminhyoUtsushiHakkoSeigyoKubun(宛名.getJuminhyoUtsushiHakkoSeigyoKubun());
        entity.setAtena_renrakusaki1(宛名.getRenrakusaki1());
        entity.setAtena_kensakuRenrakusaki1(宛名.getKensakuRenrakusaki1());
        entity.setAtena_renrakusakiKubun1(宛名.getRenrakusakiKubun1());
        entity.setAtena_renrakusaki2(宛名.getRenrakusaki2());
        entity.setAtena_kensakuRenrakusaki2(宛名.getKensakuRenrakusaki2());
        entity.setAtena_renrakusakiKubun2(宛名.getRenrakusakiKubun2());
        entity.setAtena_renrakusaki3(宛名.getRenrakusaki3());
        entity.setAtena_kensakuRenrakusaki3(宛名.getKensakuRenrakusaki3());
        entity.setAtena_renrakusakiKubun3(宛名.getRenrakusakiKubun3());
        entity.setAtena_mailAddress(宛名.getMailAddress());
        entity.setAtena_biko(宛名.getBiko());
        entity.setAtena_kanaName(宛名.getKanaName());
        entity.setAtena_gaikokujinKanaName(宛名.getGaikokujinKanaName());
        entity.setAtena_kanaTsushoName(宛名.getKanaTsushoName());
        entity.setAtena_jutogaiKanriUpdateCount(宛名.getJutogaiKanriUpdateCount());
        entity.setAtena_jutogaiKanriTorokuNo(宛名.getJutogaiGaikokujinTorokuNo());
        entity.setAtena_jutogaiKojinKihonUpdateCount(宛名.getJutogaiKojinKihonUpdateCount());
        entity.setAtena_jutogaiKojinKihonTorokuNo(宛名.getJutogaiKojinKihonTorokuNo());
        entity.setAtena_jutogaiNihonjinUpdateCount(宛名.getJutogaiNihonjinUpdateCount());
        entity.setAtena_jutogaiNihonjinTorokuNo(宛名.getJutogaiNihonjinTorokuNo());
        entity.setAtena_jutogaiGaikokujinUpdateCount(宛名.getJutogaiKojinKihonUpdateCount());
        entity.setAtena_jutogaiGaikokujinTorokuNo(宛名.getJutogaiKojinKihonTorokuNo());
        entity.setAtena_hojinUpdateCount(宛名.getHojinUpdateCount());
        entity.setAtena_hojinTorokuNo(宛名.getHojinTorokuNo());
        entity.setAtena_kyoyushaUpdateCount(宛名.getKyoyushaUpdateCount());
        entity.setAtena_kyoyushaTorokuNo(宛名.getKyoyushaTorokuNo());
        entity.setAtena_shimeiSearchTorokuNo(宛名.getShimeiSearchTorokuNo());
        entity.setAtena_yusenShimeiUpdateCount(宛名.getYusenShimeiUpdateCount());
        entity.setAtena_yusenShimeiTimestamp(宛名.getYusenShimeiTimestamp());
    }

    private void set更正後_計算後情報の全項目(KarisanteiIkkatsuHakkoTempEntity entity) {
        entity.setDbT2015KeisangoJoho_insertDantaiCd(計算後情報.getInsertDantaiCd());
        entity.setDbT2015KeisangoJoho_insertTimestamp(計算後情報.getInsertTimestamp());
        entity.setDbT2015KeisangoJoho_insertReamsLoginId(計算後情報.getInsertReamsLoginId());
        entity.setDbT2015KeisangoJoho_insertContextId(計算後情報.getInsertContextId());
        entity.setDbT2015KeisangoJoho_isDeleted(計算後情報.isDeleted());
        entity.setDbT2015KeisangoJoho_updateCount(計算後情報.getUpdateCount());
        entity.setDbT2015KeisangoJoho_lastUpdateTimestamp(計算後情報.getLastUpdateTimestamp());
        entity.setDbT2015KeisangoJoho_lastUpdateReamsLoginId(計算後情報.getLastUpdateReamsLoginId());
        entity.setDbT2015KeisangoJoho_choteiNendo(計算後情報.getChoteiNendo());
        entity.setDbT2015KeisangoJoho_fukaNendo(計算後情報.getFukaNendo());
        entity.setDbT2015KeisangoJoho_tsuchishoNo(計算後情報.getTsuchishoNo());
        entity.setDbT2015KeisangoJoho_koseiZengoKubun(計算後情報.getKoseiZengoKubun());
        entity.setDbT2015KeisangoJoho_sakuseiShoriName(計算後情報.getSakuseiShoriName());
        entity.setDbT2015KeisangoJoho_fukaRirekiNo(計算後情報.getFukaRirekiNo());
        entity.setDbT2015KeisangoJoho_hihokenshaNo(計算後情報.getHihokenshaNo());
        entity.setDbT2015KeisangoJoho_shikibetsuCode(計算後情報.getShikibetsuCode());
        entity.setDbT2015KeisangoJoho_setaiCode(計算後情報.getSetaiCode());
        entity.setDbT2015KeisangoJoho_setaiInsu(計算後情報.getSetaiInsu());
        entity.setDbT2015KeisangoJoho_shikakuShutokuYMD(計算後情報.getShikakuShutokuYMD());
        entity.setDbT2015KeisangoJoho_shikakuShutokuJiyu(計算後情報.getShikakuShutokuJiyu());
        entity.setDbT2015KeisangoJoho_shikakuSoshitsuYMD(計算後情報.getShikakuSoshitsuYMD());
        entity.setDbT2015KeisangoJoho_shikakuSoshitsuJiyu(計算後情報.getShikakuSoshitsuJiyu());
        entity.setDbT2015KeisangoJoho_seihofujoShurui(計算後情報.getSeihofujoShurui());
        entity.setDbT2015KeisangoJoho_seihoKaishiYMD(計算後情報.getSeihoKaishiYMD());
        entity.setDbT2015KeisangoJoho_seihoHaishiYMD(計算後情報.getSeihoHaishiYMD());
        entity.setDbT2015KeisangoJoho_ronenKaishiYMD(計算後情報.getRonenKaishiYMD());
        entity.setDbT2015KeisangoJoho_ronenHaishiYMD(計算後情報.getRonenHaishiYMD());
        entity.setDbT2015KeisangoJoho_fukaYMD(計算後情報.getFukaYMD());
        entity.setDbT2015KeisangoJoho_kazeiKubun(計算後情報.getKazeiKubun());
        entity.setDbT2015KeisangoJoho_setaikazeiKubun(計算後情報.getSetaikazeiKubun());
        entity.setDbT2015KeisangoJoho_gokeiShotokuGaku(計算後情報.getGokeiShotokuGaku());
        entity.setDbT2015KeisangoJoho_nenkinShunyuGaku(計算後情報.getNenkinShunyuGaku());
        entity.setDbT2015KeisangoJoho_hokenryoDankai(計算後情報.getHokenryoDankai());
        entity.setDbT2015KeisangoJoho_hokenryoDankai1(計算後情報.getHokenryoDankai1());
        entity.setDbT2015KeisangoJoho_nengakuHokenryo1(計算後情報.getNengakuHokenryo1());
        entity.setDbT2015KeisangoJoho_tsukiwariStartYM1(計算後情報.getTsukiwariStartYM1());
        entity.setDbT2015KeisangoJoho_tsukiwariEndYM1(計算後情報.getTsukiwariEndYM1());
        entity.setDbT2015KeisangoJoho_hokenryoDankai2(計算後情報.getHokenryoDankai2());
        entity.setDbT2015KeisangoJoho_nengakuHokenryo2(計算後情報.getNengakuHokenryo2());
        entity.setDbT2015KeisangoJoho_tsukiwariStartYM2(計算後情報.getTsukiwariStartYM1());
        entity.setDbT2015KeisangoJoho_tsukiwariEndYM2(計算後情報.getTsukiwariEndYM2());
        entity.setDbT2015KeisangoJoho_choteiNichiji(計算後情報.getChoteiNichiji());
        entity.setDbT2015KeisangoJoho_choteiJiyu1(計算後情報.getChoteiJiyu1());
        entity.setDbT2015KeisangoJoho_choteiJiyu2(計算後情報.getChoteiJiyu2());
        entity.setDbT2015KeisangoJoho_choteiJiyu3(計算後情報.getChoteiJiyu3());
        entity.setDbT2015KeisangoJoho_choteiJiyu4(計算後情報.getChoteiJiyu4());
        entity.setDbT2015KeisangoJoho_koseiM(計算後情報.getKoseiM());
        entity.setDbT2015KeisangoJoho_gemmenMaeHokenryo(計算後情報.getGemmenMaeHokenryo());
        entity.setDbT2015KeisangoJoho_gemmenGaku(計算後情報.getGemmenGaku());
        entity.setDbT2015KeisangoJoho_kakuteiHokenryo(計算後情報.getKakuteiHokenryo());
        entity.setDbT2015KeisangoJoho_hokenryoDankaiKarisanntei(計算後情報.getHokenryoDankaiKarisanntei());
        entity.setDbT2015KeisangoJoho_choshuHohoRirekiNo(計算後情報.getChoshuHohoRirekiNo());
        entity.setDbT2015KeisangoJoho_idoKijunNichiji(計算後情報.getIdoKijunNichiji());
        entity.setDbT2015KeisangoJoho_kozaKubun(計算後情報.getKozaKubun());
        entity.setDbT2015KeisangoJoho_kyokaisoKubun(計算後情報.getKyokaisoKubun());
        entity.setDbT2015KeisangoJoho_shokkenKubun(計算後情報.getShokkenKubun());
        entity.setDbT2015KeisangoJoho_fukaShichosonCode(計算後情報.getFukaShichosonCode());
        entity.setDbT2015KeisangoJoho_tkSaishutsuKampuGaku(計算後情報.getTkSaishutsuKampuGaku());
        entity.setDbT2015KeisangoJoho_fuSaishutsuKampuGaku(計算後情報.getFuSaishutsuKampuGaku());
        entity.setDbT2015KeisangoJoho_tkKibetsuGaku01(計算後情報.getTkKibetsuGaku01());
        entity.setDbT2015KeisangoJoho_tkKibetsuGaku02(計算後情報.getTkKibetsuGaku02());
        entity.setDbT2015KeisangoJoho_tkKibetsuGaku03(計算後情報.getTkKibetsuGaku03());
        entity.setDbT2015KeisangoJoho_tkKibetsuGaku04(計算後情報.getTkKibetsuGaku04());
        entity.setDbT2015KeisangoJoho_tkKibetsuGaku05(計算後情報.getTkKibetsuGaku05());
        entity.setDbT2015KeisangoJoho_tkKibetsuGaku06(計算後情報.getTkKibetsuGaku06());
        entity.setDbT2015KeisangoJoho_fuKibetsuGaku01(計算後情報.getFuKibetsuGaku01());
        entity.setDbT2015KeisangoJoho_fuKibetsuGaku02(計算後情報.getFuKibetsuGaku02());
        entity.setDbT2015KeisangoJoho_fuKibetsuGaku03(計算後情報.getFuKibetsuGaku03());
        entity.setDbT2015KeisangoJoho_fuKibetsuGaku04(計算後情報.getFuKibetsuGaku04());
        entity.setDbT2015KeisangoJoho_fuKibetsuGaku05(計算後情報.getFuKibetsuGaku05());
        entity.setDbT2015KeisangoJoho_fuKibetsuGaku06(計算後情報.getFuKibetsuGaku06());
        entity.setDbT2015KeisangoJoho_fuKibetsuGaku07(計算後情報.getFuKibetsuGaku07());
        entity.setDbT2015KeisangoJoho_fuKibetsuGaku08(計算後情報.getFuKibetsuGaku08());
        entity.setDbT2015KeisangoJoho_fuKibetsuGaku09(計算後情報.getFuKibetsuGaku09());
        entity.setDbT2015KeisangoJoho_fuKibetsuGaku10(計算後情報.getFuKibetsuGaku10());
        entity.setDbT2015KeisangoJoho_fuKibetsuGaku11(計算後情報.getFuKibetsuGaku11());
        entity.setDbT2015KeisangoJoho_fuKibetsuGaku12(計算後情報.getFuKibetsuGaku12());
        entity.setDbT2015KeisangoJoho_fuKibetsuGaku13(計算後情報.getFuKibetsuGaku13());
        entity.setDbT2015KeisangoJoho_fuKibetsuGaku14(計算後情報.getFuKibetsuGaku14());
        entity.setDbT2015KeisangoJoho_choshuHoho1gatsu(計算後情報.getChoshuHoho1gatsu());
        entity.setDbT2015KeisangoJoho_choshuHoho2gatsu(計算後情報.getChoshuHoho2gatsu());
        entity.setDbT2015KeisangoJoho_choshuHoho3gatsu(計算後情報.getChoshuHoho3gatsu());
        entity.setDbT2015KeisangoJoho_choshuHoho4gatsu(計算後情報.getChoshuHoho4gatsu());
        entity.setDbT2015KeisangoJoho_choshuHoho5gatsu(計算後情報.getChoshuHoho5gatsu());
        entity.setDbT2015KeisangoJoho_choshuHoho6gatsu(計算後情報.getChoshuHoho6gatsu());
        entity.setDbT2015KeisangoJoho_choshuHoho7gatsu(計算後情報.getChoshuHoho7gatsu());
        entity.setDbT2015KeisangoJoho_choshuHoho8gatsu(計算後情報.getChoshuHoho8gatsu());
        entity.setDbT2015KeisangoJoho_choshuHoho9gatsu(計算後情報.getChoshuHoho9gatsu());
        entity.setDbT2015KeisangoJoho_choshuHoho10gatsu(計算後情報.getChoshuHoho10gatsu());
        entity.setDbT2015KeisangoJoho_choshuHoho11gatsu(計算後情報.getChoshuHoho11gatsu());
        entity.setDbT2015KeisangoJoho_choshuHoho12gatsu(計算後情報.getChoshuHoho12gatsu());
        entity.setDbT2015KeisangoJoho_choshuHohoYoku4gatsu(計算後情報.getChoshuHohoYoku4gatsu());
        entity.setDbT2015KeisangoJoho_choshuHohoYoku5gatsu(計算後情報.getChoshuHohoYoku5gatsu());
        entity.setDbT2015KeisangoJoho_choshuHohoYoku6gatsu(計算後情報.getChoshuHohoYoku6gatsu());
        entity.setDbT2015KeisangoJoho_choshuHohoYoku7gatsu(計算後情報.getChoshuHohoYoku7gatsu());
        entity.setDbT2015KeisangoJoho_choshuHohoYoku8gatsu(計算後情報.getChoshuHohoYoku8gatsu());
        entity.setDbT2015KeisangoJoho_choshuHohoYoku9gatsu(計算後情報.getChoshuHohoYoku9gatsu());
        entity.setDbT2015KeisangoJoho_kariNenkinNo(計算後情報.getKariNenkinNo());
        entity.setDbT2015KeisangoJoho_kariNenkinCode(計算後情報.getKariNenkinCode());
        entity.setDbT2015KeisangoJoho_kariHosokuM(計算後情報.getKariHosokuM());
        entity.setDbT2015KeisangoJoho_honNenkinNo(計算後情報.getHonNenkinNo());
        entity.setDbT2015KeisangoJoho_honNenkinCode(計算後情報.getHonNenkinCode());
        entity.setDbT2015KeisangoJoho_honHosokuM(計算後情報.getHonHosokuM());
        entity.setDbT2015KeisangoJoho_yokunendoKariNenkinNo(計算後情報.getYokunendoKariNenkinNo());
        entity.setDbT2015KeisangoJoho_yokunendoKariNenkinCode(計算後情報.getYokunendoKariNenkinCode());
        entity.setDbT2015KeisangoJoho_yokunendoKariHosokuM(計算後情報.getYokunendoKariHosokuM());
        entity.setDbT2015KeisangoJoho_iraiSohuzumiFlag(計算後情報.isIraiSohuzumiFlag());
        entity.setDbT2015KeisangoJoho_tsuikaIraiSohuzumiFlag(計算後情報.isTsuikaIraiSohuzumiFlag());
        entity.setDbT2015KeisangoJoho_tokuchoTeishiNichiji(計算後情報.getTokuchoTeishiNichiji());
        entity.setDbT2015KeisangoJoho_tokuchoTeishiJiyuCode(計算後情報.getTokuchoTeishiJiyuCode());
        entity.setDbT2015KeisangoJoho_tkShunyuGaku01(計算後情報.getTkKibetsuGaku01());
        entity.setDbT2015KeisangoJoho_tkShunyuGaku02(計算後情報.getTkKibetsuGaku02());
        entity.setDbT2015KeisangoJoho_tkShunyuGaku03(計算後情報.getTkKibetsuGaku03());
        entity.setDbT2015KeisangoJoho_tkShunyuGaku04(計算後情報.getTkKibetsuGaku04());
        entity.setDbT2015KeisangoJoho_tkShunyuGaku05(計算後情報.getTkKibetsuGaku05());
        entity.setDbT2015KeisangoJoho_tkShunyuGaku06(計算後情報.getTkKibetsuGaku06());
        entity.setDbT2015KeisangoJoho_fuShunyuGaku01(計算後情報.getFuShunyuGaku01());
        entity.setDbT2015KeisangoJoho_fuShunyuGaku02(計算後情報.getFuShunyuGaku02());
        entity.setDbT2015KeisangoJoho_fuShunyuGaku03(計算後情報.getFuShunyuGaku03());
        entity.setDbT2015KeisangoJoho_fuShunyuGaku04(計算後情報.getFuShunyuGaku04());
        entity.setDbT2015KeisangoJoho_fuShunyuGaku05(計算後情報.getFuShunyuGaku05());
        entity.setDbT2015KeisangoJoho_fuShunyuGaku06(計算後情報.getFuShunyuGaku06());
        entity.setDbT2015KeisangoJoho_fuShunyuGaku07(計算後情報.getFuShunyuGaku07());
        entity.setDbT2015KeisangoJoho_fuShunyuGaku08(計算後情報.getFuShunyuGaku08());
        entity.setDbT2015KeisangoJoho_fuShunyuGaku09(計算後情報.getFuShunyuGaku09());
        entity.setDbT2015KeisangoJoho_fuShunyuGaku10(計算後情報.getFuShunyuGaku10());
        entity.setDbT2015KeisangoJoho_fuShunyuGaku11(計算後情報.getFuShunyuGaku11());
        entity.setDbT2015KeisangoJoho_fuShunyuGaku12(計算後情報.getFuShunyuGaku12());
        entity.setDbT2015KeisangoJoho_fuShunyuGaku13(計算後情報.getFuShunyuGaku13());
        entity.setDbT2015KeisangoJoho_fuShunyuGaku14(計算後情報.getFuShunyuGaku14());
    }

    private void set対象者_追加含む情報の全項目(KarisanteiIkkatsuHakkoTempEntity entity) {
        entity.setNenkinTokuchoKaifuJoho_insertDantaiCd(対象者_追加含む情報.getInsertDantaiCd());
        entity.setNenkinTokuchoKaifuJoho_gyomuCode(対象者_追加含む情報.getGyomuCode());
        entity.setNenkinTokuchoKaifuJoho_shoriNendo(対象者_追加含む情報.getShoriNendo());
        entity.setNenkinTokuchoKaifuJoho_tsuchiNaiyoCode(対象者_追加含む情報.getTsuchiNaiyoCode());
        entity.setNenkinTokuchoKaifuJoho_shoriTaishoYM(対象者_追加含む情報.getShoriTaishoYM());
        entity.setNenkinTokuchoKaifuJoho_kisoNenkinNo(対象者_追加含む情報.getKisoNenkinNo());
        entity.setNenkinTokuchoKaifuJoho_nenkinCode(対象者_追加含む情報.getNenkinCode());
        entity.setNenkinTokuchoKaifuJoho_koseiCityCode(対象者_追加含む情報.getKoseiCityCode());
        entity.setNenkinTokuchoKaifuJoho_renban(対象者_追加含む情報.getRenban());
        entity.setNenkinTokuchoKaifuJoho_shoriTimestamp(対象者_追加含む情報.getShoriTimestamp());
        RenkeiShubetsu renkeiShubetsu = 対象者_追加含む情報.getRenkeiShubetsu();
        entity.setNenkinTokuchoKaifuJoho_renkeiShubetsu(renkeiShubetsu != null ? renkeiShubetsu.getColumnValue() : RString.EMPTY);
        entity.setNenkinTokuchoKaifuJoho_hosokuTsuki(対象者_追加含む情報.getHosokuTsuki());
        entity.setNenkinTokuchoKaifuJoho_tenbikiTsuki(対象者_追加含む情報.getTenbikiTsuki());
        entity.setNenkinTokuchoKaifuJoho_shikibetsuCode(対象者_追加含む情報.getShikibetsuCode());
        entity.setNenkinTokuchoKaifuJoho_hihokenshaNo(対象者_追加含む情報.getHihokenshaNo());
        entity.setNenkinTokuchoKaifuJoho_kokuhoSetaiCode(対象者_追加含む情報.getKokuhoSetaiCode());
        entity.setNenkinTokuchoKaifuJoho_dtCityCode(対象者_追加含む情報.getDtCityCode());
        TokubetsuChoshuGimushaCode dtTokubetsuChoshuGimushaCode = 対象者_追加含む情報.getDtTokubetsuChoshuGimushaCode();
        entity.setNenkinTokuchoKaifuJoho_dtTokubetsuChoshuGimushaCode(dtTokubetsuChoshuGimushaCode != null
                ? dtTokubetsuChoshuGimushaCode.toRString() : RString.EMPTY);
        entity.setNenkinTokuchoKaifuJoho_dtTsuchiNaiyoCode(対象者_追加含む情報.getDtTsuchiNaiyoCode());
        entity.setNenkinTokuchoKaifuJoho_dtBaitaiCode(対象者_追加含む情報.getDtBaitaiCode());
        entity.setNenkinTokuchoKaifuJoho_dtTokubetsuChoshuSeidoCode(対象者_追加含む情報.getDtTokubetsuChoshuSeidoCode());
        entity.setNenkinTokuchoKaifuJoho_dtSakuseiYMD(対象者_追加含む情報.getDtSakuseiYMD());
        entity.setNenkinTokuchoKaifuJoho_dtKisoNenkinNo(対象者_追加含む情報.getDtKisoNenkinNo());
        entity.setNenkinTokuchoKaifuJoho_dtNenkinCode(対象者_追加含む情報.getDtNenkinCode());
        entity.setNenkinTokuchoKaifuJoho_dtYobi1(対象者_追加含む情報.getDtYobi1());
        entity.setNenkinTokuchoKaifuJoho_dtBirthDay(対象者_追加含む情報.getDtBirthDay());
        entity.setNenkinTokuchoKaifuJoho_dtSeibetsu(対象者_追加含む情報.getDtSeibetsu());
        entity.setNenkinTokuchoKaifuJoho_dtKanaShimei(対象者_追加含む情報.getDtKanaShimei());
        entity.setNenkinTokuchoKaifuJoho_dtShiftCode1(対象者_追加含む情報.getDtShiftCode1());
        entity.setNenkinTokuchoKaifuJoho_dtKanjiShimei(対象者_追加含む情報.getDtKanjiShimei());
        entity.setNenkinTokuchoKaifuJoho_dtShiftCode2(対象者_追加含む情報.getDtShiftCode2());
        entity.setNenkinTokuchoKaifuJoho_dtYubinNo(対象者_追加含む情報.getDtYubinNo());
        entity.setNenkinTokuchoKaifuJoho_dtKanaJusho(対象者_追加含む情報.getDtKanaJusho());
        entity.setNenkinTokuchoKaifuJoho_dtShiftCode3(対象者_追加含む情報.getDtShiftCode3());
        entity.setNenkinTokuchoKaifuJoho_dtKanjiJusho(対象者_追加含む情報.getDtKanjiJusho());
        entity.setNenkinTokuchoKaifuJoho_dtShiftCode4(対象者_追加含む情報.getDtShiftCode4());
        entity.setNenkinTokuchoKaifuJoho_dtKakushuKubun(対象者_追加含む情報.getDtKakushuKubun());
        entity.setNenkinTokuchoKaifuJoho_dtShoriKekka(対象者_追加含む情報.getDtShoriKekka());
        entity.setNenkinTokuchoKaifuJoho_dtKokiIkanCode(対象者_追加含む情報.getDtKokiIkanCode());
        entity.setNenkinTokuchoKaifuJoho_dtKakushuYMD(対象者_追加含む情報.getDtKakushuYMD());
        entity.setNenkinTokuchoKaifuJoho_dtKakushuKingaku1(対象者_追加含む情報.getDtKakushuKingaku1());
        entity.setNenkinTokuchoKaifuJoho_dtKakushuKingaku2(対象者_追加含む情報.getDtKakushuKingaku2());
        entity.setNenkinTokuchoKaifuJoho_dtKakushuKingaku3(対象者_追加含む情報.getDtKakushuKingaku3());
        entity.setNenkinTokuchoKaifuJoho_dtYobi2(対象者_追加含む情報.getDtYobi2());
        entity.setNenkinTokuchoKaifuJoho_dtKyosaiNenkinshoshoKigoNo(対象者_追加含む情報.getDtKyosaiNenkinshoshoKigoNo());
        entity.setNenkinTokuchoKaifuJoho_dtKakushuKingaku4(対象者_追加含む情報.getDtKakushuKingaku4());
        entity.setNenkinTokuchoKaifuJoho_dtKakushuKingaku5(対象者_追加含む情報.getDtKakushuKingaku5());
        entity.setNenkinTokuchoKaifuJoho_dtKakushuKingaku6(対象者_追加含む情報.getDtKakushuKingaku6());
        entity.setNenkinTokuchoKaifuJoho_dtKakushuKingaku7(対象者_追加含む情報.getDtKakushuKingaku7());
        entity.setNenkinTokuchoKaifuJoho_dtKakushuKingaku8(対象者_追加含む情報.getDtKakushuKingaku8());
        entity.setNenkinTokuchoKaifuJoho_dtTeishiYM(対象者_追加含む情報.getDtTeishiYM());
        entity.setNenkinTokuchoKaifuJoho_dtYobi4Juminzei(対象者_追加含む情報.getDtYobi4Juminzei());
        entity.setNenkinTokuchoKaifuJoho_dtKojinNo(対象者_追加含む情報.getDtKojinNo());

    }
}
