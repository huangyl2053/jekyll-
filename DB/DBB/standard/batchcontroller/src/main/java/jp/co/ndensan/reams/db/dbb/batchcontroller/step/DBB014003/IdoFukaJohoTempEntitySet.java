/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB014003;

import java.util.List;
import jp.co.ndensan.reams.ca.cax.definition.valueobject.code.ShiharaiHohoCodeValue;
import jp.co.ndensan.reams.ca.cax.definition.valueobject.code.ZennoKubunCodeValue;
import jp.co.ndensan.reams.ca.cax.entity.db.basic.CaT0714SeikyuHohoEntity;
import jp.co.ndensan.reams.ca.cax.entity.db.basic.CaT0752NokumiEntity;
import jp.co.ndensan.reams.ca.cax.entity.db.psm.CaFt703FindNokumiEntity;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fuchokaritsuchishoikkatsuhakko.FuchNokumiParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb014003.FuchoKarisanteiTsuchishoHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2015KeisangoJohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuchokarisanteitsuchishohakko.TmpIdoFukaJohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuchokaritsuchishoikkatsuhakko.FuchoKariTsuchishoIkkatsuHakkoTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuchokaritsuchishoikkatsuhakko.FukaJohoZenendoTmpEntity;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaT0301YokinShubetsuPatternEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaT0302KinyuKikanEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaT0303KinyuKikanShitenEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaT0310KozaEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.TokuteiKozaRelateEntity;
import jp.co.ndensan.reams.ue.uex.definition.core.RenkeiShubetsu;
import jp.co.ndensan.reams.ue.uex.definition.core.SeibetsuCodeNenkinTokucho;
import jp.co.ndensan.reams.ue.uex.definition.core.TokubetsuChoshuGimushaCode;
import jp.co.ndensan.reams.ue.uex.definition.core.TokubetsuChoshuSeidoCode;
import jp.co.ndensan.reams.ue.uex.definition.core.TsuchiNaiyoCode;
import jp.co.ndensan.reams.ue.uex.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity;
import jp.co.ndensan.reams.ur.urc.service.core.shunokamoku.authority.ShunoKamokuAuthority;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 普徴仮算定の更新後データを抽出するクラスです。
 *
 * @reamsid_L DBB-0710-030 yebangqiang
 */
public class IdoFukaJohoTempEntitySet {

    private static final RString LEFT_FORMAT = new RString("'{");
    private static final RString RIGHT_FORMAT = new RString("}'");
    private static final RString MIDDLE_FORMAT = new RString(",");

    /**
     * FuchNokumiParameterを生成するメソッドです。
     *
     * @param processParameter FuchoKarisanteiTsuchishoHakkoProcessParameter
     * @return FuchNokumiParameter
     */
    protected FuchNokumiParameter createReader(FuchoKarisanteiTsuchishoHakkoProcessParameter processParameter) {
        KozaSearchKeyBuilder builder = new KozaSearchKeyBuilder();
        builder.setサブ業務コード(SubGyomuCode.DBB介護賦課);
        builder.set業務コード(GyomuCode.DB介護保険);
        IKozaSearchKey kozaSearchKey = builder.build();
        ShunoKamokuAuthority sut = InstanceProvider.create(ShunoKamokuAuthority.class);
        List<KamokuCode> list = sut.get更新権限科目コード(ControlDataHolder.getUserId());
        RStringBuilder rStringBuilder = new RStringBuilder();
        rStringBuilder.append(LEFT_FORMAT);
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                rStringBuilder.append(list.get(i) == null ? RString.EMPTY : list.get(i).getColumnValue());
                if (i != list.size() - 1) {
                    rStringBuilder.append(MIDDLE_FORMAT);
                }
            }
        }
        rStringBuilder.append(RIGHT_FORMAT);
        RString 科目コード = rStringBuilder.toRString();
        RString 処理日 = new RString(FlexibleDate.getNowDate().toString());
        FuchNokumiParameter myBatisParameter = FuchNokumiParameter.createSelectByKeyParam(
                processParameter.get調定年度(), processParameter.get調定年度().minusYear(1), processParameter.get賦課年度(),
                処理日, kozaSearchKey, list, 科目コード, processParameter.getShikibetsutaishoParam());
        return myBatisParameter;
    }

    /**
     * 異動賦課情報一時entityに転換するメソッドです。
     *
     * @param idoFukaJohoTempEntity FuchoKariTsuchishoIkkatsuHakkoTempEntity
     * @return TmpIdoFukaJohoEntity 異動賦課情報一時entity
     */
    protected TmpIdoFukaJohoEntity toIdoFukaJohoTmpEntity(FuchoKariTsuchishoIkkatsuHakkoTempEntity idoFukaJohoTempEntity) {
        TmpIdoFukaJohoEntity entity = new TmpIdoFukaJohoEntity();
        final DbT2015KeisangoJohoEntity 計算後情報_更正後 = idoFukaJohoTempEntity.get計算後情報_更正後();
        if (計算後情報_更正後 != null) {
            計算後情報_更正後値設定(entity, 計算後情報_更正後);
        }
        final UeT0511NenkinTokuchoKaifuJohoEntity 年金特徴回付情報_更正後 = idoFukaJohoTempEntity.get年金特徴回付情報_更正後();
        if (年金特徴回付情報_更正後 != null) {
            年金特徴回付情報_更正後値設定(entity, 年金特徴回付情報_更正後);
        }
        final UaFt200FindShikibetsuTaishoEntity 宛名識別対象 = idoFukaJohoTempEntity.get宛名識別対象();
        if (宛名識別対象 != null) {
            set宛名の全項目(宛名識別対象, entity);
        }
        final UaFt250FindAtesakiEntity 宛先 = idoFukaJohoTempEntity.get宛先();
        if (宛先 != null) {
            set宛先の全項目(宛先, entity);
        }
        final CaFt703FindNokumiEntity 納組 = idoFukaJohoTempEntity.get納組();
        if (納組 != null) {
            set納組情報の全項目(納組, entity);
        }
        final TokuteiKozaRelateEntity 口座 = idoFukaJohoTempEntity.get特定口座();
        if (口座 != null) {
            set口座情報の全項目(口座, entity);
        }
        entity.setAtesakiDaino_shimeiRiyoKubun(idoFukaJohoTempEntity.get代納人氏名());
        final UaFt250FindAtesakiEntity 宛先代納 = idoFukaJohoTempEntity.get宛先代納();
        if (宛先代納 != null) {
            set宛先代納の全項目(宛先代納, entity);
        }
        return entity;
    }

    /**
     * 異動賦課情報一時entityに賦課値を更新するメソッドです。
     *
     * @param 異動賦課情報一時 TmpIdoFukaJohoEntity
     * @param 介護賦課前年度 FukaJohoZenendoTmpEntity
     */
    protected void update異動賦課情報一時_賦課Entity(TmpIdoFukaJohoEntity 異動賦課情報一時,
            FukaJohoZenendoTmpEntity 介護賦課前年度) {
        異動賦課情報一時.setFuka_choteiNendo(介護賦課前年度.getFuka_ChoteiNendo());
        異動賦課情報一時.setFuka_fukaNendo(介護賦課前年度.getFuka_FukaNendo());
        異動賦課情報一時.setFuka_tsuchishoNo(介護賦課前年度.getFuka_TsuchishoNo());
        異動賦課情報一時.setFuka_rirekiNo(介護賦課前年度.getFuka_RirekiNo());
        異動賦課情報一時.setFuka_hihokenshaNo(介護賦課前年度.getFuka_HihokenshaNo());
        異動賦課情報一時.setFuka_shikibetsuCode(介護賦課前年度.getFuka_ShikibetsuCode());
        異動賦課情報一時.setFuka_setaiCode(介護賦課前年度.getFuka_SetaiCode());
        異動賦課情報一時.setFuka_setaiInsu(介護賦課前年度.getFuka_SetaiInsu());
        異動賦課情報一時.setFuka_shikakuShutokuYMD(介護賦課前年度.getFuka_ShikakuShutokuYMD());
        異動賦課情報一時.setFuka_shikakuShutokuJiyu(介護賦課前年度.getFuka_ShikakuShutokuJiyu());
        異動賦課情報一時.setFuka_shikakuSoshitsuYMD(介護賦課前年度.getFuka_ShikakuSoshitsuYMD());
        異動賦課情報一時.setFuka_shikakuSoshitsuJiyu(介護賦課前年度.getFuka_ShikakuSoshitsuJiyu());
        異動賦課情報一時.setFuka_seihofujoShurui(介護賦課前年度.getFuka_SeihofujoShurui());
        異動賦課情報一時.setFuka_seihoKaishiYMD(介護賦課前年度.getFuka_SeihoKaishiYMD());
        異動賦課情報一時.setFuka_seihoHaishiYMD(介護賦課前年度.getFuka_SeihoHaishiYMD());
        異動賦課情報一時.setFuka_ronenKaishiYMD(介護賦課前年度.getFuka_RonenKaishiYMD());
        異動賦課情報一時.setFuka_ronenHaishiYMD(介護賦課前年度.getFuka_RonenHaishiYMD());
        異動賦課情報一時.setFuka_fukaYMD(介護賦課前年度.getFuka_FukaYMD());
        異動賦課情報一時.setFuka_kazeiKubun(介護賦課前年度.getFuka_KazeiKubun());
        異動賦課情報一時.setFuka_setaikazeiKubun(介護賦課前年度.getFuka_SetaikazeiKubun());
        異動賦課情報一時.setFuka_gokeiShotokuGaku(介護賦課前年度.getFuka_GokeiShotokuGaku());
        異動賦課情報一時.setFuka_nenkinShunyuGaku(介護賦課前年度.getFuka_NenkinShunyuGaku());
        異動賦課情報一時.setFuka_hokenryoDankai(介護賦課前年度.getFuka_HokenryoDankai());
        異動賦課情報一時.setFuka_hokenryoDankai1(介護賦課前年度.getFuka_HokenryoDankai1());
        異動賦課情報一時.setFuka_nengakuHokenryo1(介護賦課前年度.getFuka_NengakuHokenryo1());
        異動賦課情報一時.setFuka_tsukiwariStartYM1(介護賦課前年度.getFuka_TsukiwariStartYM1());
        異動賦課情報一時.setFuka_tsukiwariEndYM1(介護賦課前年度.getFuka_TsukiwariEndYM1());
        異動賦課情報一時.setFuka_hokenryoDankai2(介護賦課前年度.getFuka_HokenryoDankai2());
        異動賦課情報一時.setFuka_nengakuHokenryo2(介護賦課前年度.getFuka_NengakuHokenryo2());
        異動賦課情報一時.setFuka_tsukiwariStartYM2(介護賦課前年度.getFuka_TsukiwariStartYM2());
        異動賦課情報一時.setFuka_tsukiwariEndYM2(介護賦課前年度.getFuka_TsukiwariEndYM2());
        異動賦課情報一時.setFuka_choteiNichiji(介護賦課前年度.getFuka_ChoteiNichiji());
        異動賦課情報一時.setFuka_choteiJiyu1(介護賦課前年度.getFuka_ChoteiJiyu1());
        異動賦課情報一時.setFuka_choteiJiyu2(介護賦課前年度.getFuka_ChoteiJiyu2());
        異動賦課情報一時.setFuka_choteiJiyu3(介護賦課前年度.getFuka_ChoteiJiyu3());
        異動賦課情報一時.setFuka_choteiJiyu4(介護賦課前年度.getFuka_ChoteiJiyu4());
        異動賦課情報一時.setFuka_koseiM(介護賦課前年度.getFuka_KoseiM());
        異動賦課情報一時.setFuka_gemmenMaeHokenryo(介護賦課前年度.getFuka_GemmenMaeHokenryo());
        異動賦課情報一時.setFuka_gemmenGaku(介護賦課前年度.getFuka_GemmenGaku());
        異動賦課情報一時.setFuka_kakuteiHokenryo(介護賦課前年度.getFuka_KakuteiHokenryo());
        異動賦課情報一時.setFuka_hokenryoDankaiKarisanntei(介護賦課前年度.getFuka_HokenryoDankaiKarisanntei());
        異動賦課情報一時.setFuka_choshuHohoRirekiNo(介護賦課前年度.getFuka_ChoshuHohoRirekiNo());
        異動賦課情報一時.setFuka_idoKijunNichiji(介護賦課前年度.getFuka_IdoKijunNichiji());
        異動賦課情報一時.setFuka_kozaKubun(介護賦課前年度.getFuka_KozaKubun());
        異動賦課情報一時.setFuka_kyokaisoKubun(介護賦課前年度.getFuka_KyokaisoKubun());
        異動賦課情報一時.setFuka_shokkenKubun(介護賦課前年度.getFuka_ShokkenKubun());
        異動賦課情報一時.setFuka_fukaShichosonCode(介護賦課前年度.getFuka_FukaShichosonCode());
        異動賦課情報一時.setFuka_tkSaishutsuKampuGaku(介護賦課前年度.getFuka_TkSaishutsuKampuGaku());
        異動賦課情報一時.setFuka_fuSaishutsuKampuGaku(介護賦課前年度.getFuka_FuSaishutsuKampuGaku());
        異動賦課情報一時.setFuka_ki(介護賦課前年度.getFuka_Ki());
        異動賦課情報一時.setFuka_choteigaku(介護賦課前年度.getFuka_Choteigaku());
        異動賦課情報一時.setFuka_choshuHouhou(介護賦課前年度.getFuka_ChoshuHouhou());
        異動賦課情報一時.setFuka_choteiId(介護賦課前年度.getFuka_ChoteiId());
        異動賦課情報一時.setFuka_shunoId(介護賦課前年度.getFuka_ShunoId());
    }

    /**
     * 異動賦課情報一時entityに年金(更正前)値を更新するメソッドです。
     *
     * @param 異動賦課情報一時 TmpIdoFukaJohoEntity
     * @param 年金特徴回付情報_更正前 UeT0511NenkinTokuchoKaifuJohoEntity
     */
    protected void update異動賦課情報一時_年金Entity(TmpIdoFukaJohoEntity 異動賦課情報一時,
            UeT0511NenkinTokuchoKaifuJohoEntity 年金特徴回付情報_更正前) {
        異動賦課情報一時.setUeT0511_gyomuCode(年金特徴回付情報_更正前.getGyomuCode());
        異動賦課情報一時.setUeT0511_shoriNendo(年金特徴回付情報_更正前.getShoriNendo());
        if (年金特徴回付情報_更正前.getTsuchiNaiyoCode() != null) {
            異動賦課情報一時.setUeT0511_tsuchiNaiyoCode(年金特徴回付情報_更正前.getTsuchiNaiyoCode().getColumnValue());
        }
        異動賦課情報一時.setUeT0511_shoriTaishoYM(年金特徴回付情報_更正前.getShoriTaishoYM());
        異動賦課情報一時.setUeT0511_kisoNenkinNo(年金特徴回付情報_更正前.getKisoNenkinNo());
        異動賦課情報一時.setUeT0511_nenkinCode(年金特徴回付情報_更正前.getNenkinCode());
        異動賦課情報一時.setUeT0511_koseiCityCode(年金特徴回付情報_更正前.getKoseiCityCode());
        異動賦課情報一時.setUeT0511_renban(年金特徴回付情報_更正前.getRenban());
        異動賦課情報一時.setUeT0511_shoriTimestamp(年金特徴回付情報_更正前.getShoriTimestamp());
        RenkeiShubetsu renkeiShubetsu = 年金特徴回付情報_更正前.getRenkeiShubetsu();
        if (renkeiShubetsu != null) {
            異動賦課情報一時.setUeT0511_renkeiShubetsu(renkeiShubetsu.getColumnValue());
        }
        異動賦課情報一時.setUeT0511_hosokuTsuki(年金特徴回付情報_更正前.getHosokuTsuki());
        異動賦課情報一時.setUeT0511_tenbikiTsuki(年金特徴回付情報_更正前.getTenbikiTsuki());
        異動賦課情報一時.setUeT0511_shikibetsuCode(年金特徴回付情報_更正前.getShikibetsuCode());
        異動賦課情報一時.setUeT0511_hihokenshaNo(年金特徴回付情報_更正前.getHihokenshaNo());
        異動賦課情報一時.setUeT0511_kokuhoSetaiCode(年金特徴回付情報_更正前.getKokuhoSetaiCode());
        異動賦課情報一時.setUeT0511_dtCityCode(年金特徴回付情報_更正前.getDtCityCode());
        TokubetsuChoshuGimushaCode tokubetsuChoshuGimushaCode = 年金特徴回付情報_更正前.getDtTokubetsuChoshuGimushaCode();
        if (tokubetsuChoshuGimushaCode != null) {
            異動賦課情報一時.setUeT0511_dtTokubetsuChoshuGimushaCode(tokubetsuChoshuGimushaCode.getColumnValue());
        }
        TsuchiNaiyoCode tsuchiNaiyoCode = 年金特徴回付情報_更正前.getDtTsuchiNaiyoCode();
        if (tsuchiNaiyoCode != null) {
            異動賦課情報一時.setUeT0511_dtTsuchiNaiyoCode(tsuchiNaiyoCode.getColumnValue());
        }
        異動賦課情報一時.setUeT0511_dtBaitaiCode(年金特徴回付情報_更正前.getDtBaitaiCode());
        TokubetsuChoshuSeidoCode tokubetsuChoshuSeidoCode = 年金特徴回付情報_更正前.getDtTokubetsuChoshuSeidoCode();
        if (tokubetsuChoshuSeidoCode != null) {
            異動賦課情報一時.setUeT0511_dtTokubetsuChoshuSeidoCode(tokubetsuChoshuSeidoCode.getColumnValue());
        }
        異動賦課情報一時.setUeT0511_dtSakuseiYMD(年金特徴回付情報_更正前.getDtSakuseiYMD());
        異動賦課情報一時.setUeT0511_dtKisoNenkinNo(年金特徴回付情報_更正前.getDtKisoNenkinNo());
        異動賦課情報一時.setUeT0511_dtNenkinCode(年金特徴回付情報_更正前.getDtNenkinCode());
        異動賦課情報一時.setUeT0511_dtYobi1(年金特徴回付情報_更正前.getDtYobi1());
        異動賦課情報一時.setUeT0511_dtBirthDay(年金特徴回付情報_更正前.getDtBirthDay());
        SeibetsuCodeNenkinTokucho seibetsuCodeNenkinTokucho = 年金特徴回付情報_更正前.getDtSeibetsu();
        if (seibetsuCodeNenkinTokucho != null) {
            異動賦課情報一時.setUeT0511_dtSeibetsu(seibetsuCodeNenkinTokucho.getColumnValue());
        }
        異動賦課情報一時.setUeT0511_dtKanaShimei(年金特徴回付情報_更正前.getDtKanaShimei());
        異動賦課情報一時.setUeT0511_dtShiftCode1(年金特徴回付情報_更正前.getDtShiftCode1());
        異動賦課情報一時.setUeT0511_dtKanjiShimei(年金特徴回付情報_更正前.getDtKanjiShimei());
        異動賦課情報一時.setUeT0511_dtShiftCode2(年金特徴回付情報_更正前.getDtShiftCode2());
        異動賦課情報一時.setUeT0511_dtYubinNo(年金特徴回付情報_更正前.getDtYubinNo());
        異動賦課情報一時.setUeT0511_dtKanaJusho(年金特徴回付情報_更正前.getDtKanaJusho());
        異動賦課情報一時.setUeT0511_dtShiftCode3(年金特徴回付情報_更正前.getDtShiftCode3());
        異動賦課情報一時.setUeT0511_dtKanjiJusho(年金特徴回付情報_更正前.getDtKanjiJusho());
        異動賦課情報一時.setUeT0511_dtShiftCode4(年金特徴回付情報_更正前.getDtShiftCode4());
        異動賦課情報一時.setUeT0511_dtKakushuKubun(年金特徴回付情報_更正前.getDtKakushuKubun());
        異動賦課情報一時.setUeT0511_dtShoriKekka(年金特徴回付情報_更正前.getDtShoriKekka());
        異動賦課情報一時.setUeT0511_dtKokiIkanCode(年金特徴回付情報_更正前.getDtKokiIkanCode());
        異動賦課情報一時.setUeT0511_dtKakushuYMD(年金特徴回付情報_更正前.getDtKakushuYMD());
        異動賦課情報一時.setUeT0511_dtKakushuKingaku1(年金特徴回付情報_更正前.getDtKakushuKingaku1());
        異動賦課情報一時.setUeT0511_dtKakushuKingaku2(年金特徴回付情報_更正前.getDtKakushuKingaku2());
        異動賦課情報一時.setUeT0511_dtKakushuKingaku3(年金特徴回付情報_更正前.getDtKakushuKingaku3());
        異動賦課情報一時.setUeT0511_dtYobi2(年金特徴回付情報_更正前.getDtYobi2());
        異動賦課情報一時.setUeT0511_dtKyosaiNenkinshoshoKigoNo(年金特徴回付情報_更正前.getDtKyosaiNenkinshoshoKigoNo());
        異動賦課情報一時.setUeT0511_dtKakushuKingaku4(年金特徴回付情報_更正前.getDtKakushuKingaku4());
        異動賦課情報一時.setUeT0511_dtKakushuKingaku5(年金特徴回付情報_更正前.getDtKakushuKingaku5());
        異動賦課情報一時.setUeT0511_dtKakushuKingaku6(年金特徴回付情報_更正前.getDtKakushuKingaku6());
        異動賦課情報一時.setUeT0511_dtKakushuKingaku7(年金特徴回付情報_更正前.getDtKakushuKingaku7());
        異動賦課情報一時.setUeT0511_dtKakushuKingaku8(年金特徴回付情報_更正前.getDtKakushuKingaku8());
        異動賦課情報一時.setUeT0511_dtTeishiYM(年金特徴回付情報_更正前.getDtTeishiYM());
        異動賦課情報一時.setUeT0511_dtYobi4Juminzei(年金特徴回付情報_更正前.getDtYobi4Juminzei());
        異動賦課情報一時.setUeT0511_dtKojinNo(年金特徴回付情報_更正前.getDtKojinNo());
    }

    /**
     * 異動賦課情報一時entityに計算後情報(更正前)値を更新するメソッドです。
     *
     * @param 異動賦課情報一時 TmpIdoFukaJohoEntity
     * @param 計算後情報_更正前 DbT2015KeisangoJohoEntity
     */
    protected void update異動賦課情報一時Entity(TmpIdoFukaJohoEntity 異動賦課情報一時, DbT2015KeisangoJohoEntity 計算後情報_更正前) {
        異動賦課情報一時.setChoteiNendo(計算後情報_更正前.getChoteiNendo());
        異動賦課情報一時.setFukaNendo(計算後情報_更正前.getFukaNendo());
        異動賦課情報一時.setTsuchishoNo(計算後情報_更正前.getTsuchishoNo());
        異動賦課情報一時.setKoseiZengoKubun(計算後情報_更正前.getKoseiZengoKubun());
        異動賦課情報一時.setSakuseiShoriName(計算後情報_更正前.getSakuseiShoriName());
        異動賦課情報一時.setFukaRirekiNo(計算後情報_更正前.getFukaRirekiNo());
        異動賦課情報一時.setHihokenshaNo(計算後情報_更正前.getHihokenshaNo());
        異動賦課情報一時.setShikibetsuCode(計算後情報_更正前.getShikibetsuCode());
        異動賦課情報一時.setSetaiCode(計算後情報_更正前.getSetaiCode());
        異動賦課情報一時.setSetaiInsu(計算後情報_更正前.getSetaiInsu());
        異動賦課情報一時.setShikakuShutokuYMD(計算後情報_更正前.getShikakuShutokuYMD());
        異動賦課情報一時.setShikakuShutokuJiyu(計算後情報_更正前.getShikakuShutokuJiyu());
        異動賦課情報一時.setShikakuSoshitsuYMD(計算後情報_更正前.getShikakuSoshitsuYMD());
        異動賦課情報一時.setShikakuSoshitsuJiyu(計算後情報_更正前.getShikakuSoshitsuJiyu());
        異動賦課情報一時.setSeihofujoShurui(計算後情報_更正前.getSeihofujoShurui());
        異動賦課情報一時.setSeihoKaishiYMD(計算後情報_更正前.getSeihoKaishiYMD());
        異動賦課情報一時.setSeihoHaishiYMD(計算後情報_更正前.getSeihoHaishiYMD());
        異動賦課情報一時.setRonenKaishiYMD(計算後情報_更正前.getRonenKaishiYMD());
        異動賦課情報一時.setRonenHaishiYMD(計算後情報_更正前.getRonenHaishiYMD());
        異動賦課情報一時.setFukaYMD(計算後情報_更正前.getFukaYMD());
        異動賦課情報一時.setKazeiKubun(計算後情報_更正前.getKazeiKubun());
        異動賦課情報一時.setSetaikazeiKubun(計算後情報_更正前.getSetaikazeiKubun());
        異動賦課情報一時.setGokeiShotokuGaku(計算後情報_更正前.getGokeiShotokuGaku());
        異動賦課情報一時.setNenkinShunyuGaku(計算後情報_更正前.getNenkinShunyuGaku());
        異動賦課情報一時.setHokenryoDankai(計算後情報_更正前.getHokenryoDankai());
        異動賦課情報一時.setHokenryoDankai1(計算後情報_更正前.getHokenryoDankai1());
        異動賦課情報一時.setNengakuHokenryo1(計算後情報_更正前.getNengakuHokenryo1());
        異動賦課情報一時.setTsukiwariStartYM1(計算後情報_更正前.getTsukiwariStartYM1());
        異動賦課情報一時.setTsukiwariEndYM1(計算後情報_更正前.getTsukiwariEndYM1());
        異動賦課情報一時.setHokenryoDankai2(計算後情報_更正前.getHokenryoDankai2());
        異動賦課情報一時.setNengakuHokenryo2(計算後情報_更正前.getNengakuHokenryo2());
        異動賦課情報一時.setTsukiwariStartYM2(計算後情報_更正前.getTsukiwariStartYM2());
        異動賦課情報一時.setTsukiwariEndYM2(計算後情報_更正前.getTsukiwariEndYM2());
        異動賦課情報一時.setChoteiNichiji(計算後情報_更正前.getChoteiNichiji());
        異動賦課情報一時.setChoteiJiyu1(計算後情報_更正前.getChoteiJiyu1());
        異動賦課情報一時.setChoteiJiyu2(計算後情報_更正前.getChoteiJiyu2());
        異動賦課情報一時.setChoteiJiyu3(計算後情報_更正前.getChoteiJiyu3());
        異動賦課情報一時.setChoteiJiyu4(計算後情報_更正前.getChoteiJiyu4());
        異動賦課情報一時.setKoseiM(計算後情報_更正前.getKoseiM());
        異動賦課情報一時.setGemmenMaeHokenryo(計算後情報_更正前.getGemmenMaeHokenryo());
        異動賦課情報一時.setGemmenGaku(計算後情報_更正前.getGemmenGaku());
        異動賦課情報一時.setKakuteiHokenryo(計算後情報_更正前.getKakuteiHokenryo());
        異動賦課情報一時.setHokenryoDankaiKarisanntei(計算後情報_更正前.getHokenryoDankaiKarisanntei());
        異動賦課情報一時.setChoshuHohoRirekiNo(計算後情報_更正前.getChoshuHohoRirekiNo());
        異動賦課情報一時.setIdoKijunNichiji(計算後情報_更正前.getIdoKijunNichiji());
        異動賦課情報一時.setKozaKubun(計算後情報_更正前.getKozaKubun());
        異動賦課情報一時.setKyokaisoKubun(計算後情報_更正前.getKyokaisoKubun());
        異動賦課情報一時.setShokkenKubun(計算後情報_更正前.getShokkenKubun());
        異動賦課情報一時.setFukaShichosonCode(計算後情報_更正前.getFukaShichosonCode());
        異動賦課情報一時.setTkSaishutsuKampuGaku(計算後情報_更正前.getTkSaishutsuKampuGaku());
        異動賦課情報一時.setFuSaishutsuKampuGaku(計算後情報_更正前.getFuSaishutsuKampuGaku());
        異動賦課情報一時.setTkKibetsuGaku01(計算後情報_更正前.getTkKibetsuGaku01());
        異動賦課情報一時.setTkKibetsuGaku02(計算後情報_更正前.getTkKibetsuGaku02());
        異動賦課情報一時.setTkKibetsuGaku03(計算後情報_更正前.getTkKibetsuGaku03());
        異動賦課情報一時.setTkKibetsuGaku04(計算後情報_更正前.getTkKibetsuGaku04());
        異動賦課情報一時.setTkKibetsuGaku05(計算後情報_更正前.getTkKibetsuGaku05());
        異動賦課情報一時.setTkKibetsuGaku06(計算後情報_更正前.getTkKibetsuGaku06());
        異動賦課情報一時.setFuKibetsuGaku01(計算後情報_更正前.getFuKibetsuGaku01());
        異動賦課情報一時.setFuKibetsuGaku02(計算後情報_更正前.getFuKibetsuGaku02());
        異動賦課情報一時.setFuKibetsuGaku03(計算後情報_更正前.getFuKibetsuGaku03());
        異動賦課情報一時.setFuKibetsuGaku04(計算後情報_更正前.getFuKibetsuGaku04());
        異動賦課情報一時.setFuKibetsuGaku05(計算後情報_更正前.getFuKibetsuGaku05());
        異動賦課情報一時.setFuKibetsuGaku06(計算後情報_更正前.getFuKibetsuGaku06());
        異動賦課情報一時.setFuKibetsuGaku07(計算後情報_更正前.getFuKibetsuGaku07());
        異動賦課情報一時.setFuKibetsuGaku08(計算後情報_更正前.getFuKibetsuGaku08());
        異動賦課情報一時.setFuKibetsuGaku09(計算後情報_更正前.getFuKibetsuGaku09());
        異動賦課情報一時.setFuKibetsuGaku10(計算後情報_更正前.getFuKibetsuGaku10());
        異動賦課情報一時.setFuKibetsuGaku11(計算後情報_更正前.getFuKibetsuGaku11());
        異動賦課情報一時.setFuKibetsuGaku12(計算後情報_更正前.getFuKibetsuGaku12());
        異動賦課情報一時.setFuKibetsuGaku13(計算後情報_更正前.getFuKibetsuGaku13());
        異動賦課情報一時.setFuKibetsuGaku14(計算後情報_更正前.getFuKibetsuGaku14());
        異動賦課情報一時.setChoshuHoho4gatsu(計算後情報_更正前.getChoshuHoho4gatsu());
        異動賦課情報一時.setChoshuHoho5gatsu(計算後情報_更正前.getChoshuHoho5gatsu());
        異動賦課情報一時.setChoshuHoho6gatsu(計算後情報_更正前.getChoshuHoho6gatsu());
        異動賦課情報一時.setChoshuHoho7gatsu(計算後情報_更正前.getChoshuHoho7gatsu());
        異動賦課情報一時.setChoshuHoho8gatsu(計算後情報_更正前.getChoshuHoho8gatsu());
        異動賦課情報一時.setChoshuHoho9gatsu(計算後情報_更正前.getChoshuHoho9gatsu());
        異動賦課情報一時.setChoshuHoho10gatsu(計算後情報_更正前.getChoshuHoho10gatsu());
        異動賦課情報一時.setChoshuHoho11gatsu(計算後情報_更正前.getChoshuHoho11gatsu());
        異動賦課情報一時.setChoshuHoho12gatsu(計算後情報_更正前.getChoshuHoho12gatsu());
        異動賦課情報一時.setChoshuHoho1gatsu(計算後情報_更正前.getChoshuHoho1gatsu());
        異動賦課情報一時.setChoshuHoho2gatsu(計算後情報_更正前.getChoshuHoho2gatsu());
        異動賦課情報一時.setChoshuHoho3gatsu(計算後情報_更正前.getChoshuHoho3gatsu());
        異動賦課情報一時.setChoshuHohoYoku4gatsu(計算後情報_更正前.getChoshuHohoYoku4gatsu());
        異動賦課情報一時.setChoshuHohoYoku5gatsu(計算後情報_更正前.getChoshuHohoYoku5gatsu());
        異動賦課情報一時.setChoshuHohoYoku6gatsu(計算後情報_更正前.getChoshuHohoYoku6gatsu());
        異動賦課情報一時.setChoshuHohoYoku7gatsu(計算後情報_更正前.getChoshuHohoYoku7gatsu());
        異動賦課情報一時.setChoshuHohoYoku8gatsu(計算後情報_更正前.getChoshuHohoYoku8gatsu());
        異動賦課情報一時.setChoshuHohoYoku9gatsu(計算後情報_更正前.getChoshuHohoYoku9gatsu());
        異動賦課情報一時.setKariNenkinNo(計算後情報_更正前.getKariNenkinNo());
        異動賦課情報一時.setKariNenkinCode(計算後情報_更正前.getKariNenkinCode());
        異動賦課情報一時.setKariHosokuM(計算後情報_更正前.getKariHosokuM());
        異動賦課情報一時.setHonNenkinNo(計算後情報_更正前.getHonNenkinNo());
        異動賦課情報一時.setHonNenkinCode(計算後情報_更正前.getHonNenkinCode());
        異動賦課情報一時.setHonHosokuM(計算後情報_更正前.getHonHosokuM());
        異動賦課情報一時.setYokunendoKariNenkinNo(計算後情報_更正前.getYokunendoKariNenkinNo());
        異動賦課情報一時.setYokunendoKariNenkinCode(計算後情報_更正前.getYokunendoKariNenkinCode());
        異動賦課情報一時.setYokunendoKariHosokuM(計算後情報_更正前.getYokunendoKariHosokuM());
        異動賦課情報一時.setIraiSohuzumiFlag(計算後情報_更正前.getIraiSohuzumiFlag());
        異動賦課情報一時.setTsuikaIraiSohuzumiFlag(計算後情報_更正前.getTsuikaIraiSohuzumiFlag());
        異動賦課情報一時.setTokuchoTeishiNichiji(計算後情報_更正前.getTokuchoTeishiNichiji());
        異動賦課情報一時.setTokuchoTeishiJiyuCode(計算後情報_更正前.getTokuchoTeishiJiyuCode());
        異動賦課情報一時.setTkShunyuGaku01(計算後情報_更正前.getTkShunyuGaku01());
        異動賦課情報一時.setTkShunyuGaku02(計算後情報_更正前.getTkShunyuGaku02());
        異動賦課情報一時.setTkShunyuGaku03(計算後情報_更正前.getTkShunyuGaku03());
        異動賦課情報一時.setTkShunyuGaku04(計算後情報_更正前.getTkShunyuGaku04());
        異動賦課情報一時.setTkShunyuGaku05(計算後情報_更正前.getTkShunyuGaku05());
        異動賦課情報一時.setTkShunyuGaku06(計算後情報_更正前.getTkShunyuGaku06());
        異動賦課情報一時.setFuShunyuGaku01(計算後情報_更正前.getFuShunyuGaku01());
        異動賦課情報一時.setFuShunyuGaku02(計算後情報_更正前.getFuShunyuGaku02());
        異動賦課情報一時.setFuShunyuGaku03(計算後情報_更正前.getFuShunyuGaku03());
        異動賦課情報一時.setFuShunyuGaku04(計算後情報_更正前.getFuShunyuGaku04());
        異動賦課情報一時.setFuShunyuGaku05(計算後情報_更正前.getFuShunyuGaku05());
        異動賦課情報一時.setFuShunyuGaku06(計算後情報_更正前.getFuShunyuGaku06());
        異動賦課情報一時.setFuShunyuGaku07(計算後情報_更正前.getFuShunyuGaku07());
        異動賦課情報一時.setFuShunyuGaku08(計算後情報_更正前.getFuShunyuGaku08());
        異動賦課情報一時.setFuShunyuGaku09(計算後情報_更正前.getFuShunyuGaku09());
        異動賦課情報一時.setFuShunyuGaku10(計算後情報_更正前.getFuShunyuGaku10());
        異動賦課情報一時.setFuShunyuGaku11(計算後情報_更正前.getFuShunyuGaku11());
        異動賦課情報一時.setFuShunyuGaku12(計算後情報_更正前.getFuShunyuGaku12());
        異動賦課情報一時.setFuShunyuGaku13(計算後情報_更正前.getFuShunyuGaku13());
        異動賦課情報一時.setFuShunyuGaku14(計算後情報_更正前.getFuShunyuGaku14());
    }

    private void set宛名の全項目(UaFt200FindShikibetsuTaishoEntity 宛名, TmpIdoFukaJohoEntity tmpEntity) {

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

    private void set宛名の全項目_部分(UaFt200FindShikibetsuTaishoEntity 宛名, TmpIdoFukaJohoEntity tmpEntity) {
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

    private void set宛先の全項目(UaFt250FindAtesakiEntity 宛先, TmpIdoFukaJohoEntity tmpEntity) {
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

    private void set納組情報の全項目(CaFt703FindNokumiEntity 納組, TmpIdoFukaJohoEntity tmpEntity) {

        CaT0714SeikyuHohoEntity cat0714Entity = 納組.getSeikyuHoho();
        tmpEntity.setCaT0714shikibetsuCode(cat0714Entity.getShikibetsuCode());
        tmpEntity.setCaT0714gyomubetsuPrimaryKey(cat0714Entity.getGyomubetsuPrimaryKey());
        tmpEntity.setCaT0714gyomuKoyuKey(cat0714Entity.getGyomuKoyuKey());
        final ShiharaiHohoCodeValue shiharaiHoho = cat0714Entity.getShiharaiHoho();
        if (shiharaiHoho != null) {
            tmpEntity.setCaT0714shiharaiHoho(shiharaiHoho.value());
        }
        final ZennoKubunCodeValue zennoKubun = cat0714Entity.getZennoKubun();
        if (zennoKubun != null) {
            tmpEntity.setCaT0714zennoKubun(zennoKubun.value());
        }
        tmpEntity.setCaT0714creditKeizokuTorokuKey(cat0714Entity.getCreditKeizokuTorokuKey());
        tmpEntity.setCaT0714kaishiYMD(cat0714Entity.getKaishiYMD());
        tmpEntity.setCaT0714shuryoYMD(cat0714Entity.getShuryoYMD());
        tmpEntity.setCaT0714nokumiShurui(cat0714Entity.getNokumiShurui());
        tmpEntity.setCaT0714nokumiCode(cat0714Entity.getNokumiCode());

        CaT0752NokumiEntity cat0725Entity = 納組.getNokumi();
        tmpEntity.setCaT0752meisho(cat0725Entity.getMeisho());
        tmpEntity.setCaT0752kanaMeisho(cat0725Entity.getKanaMeisho());
        tmpEntity.setCaT0752kensakuyoKanaMeisho(cat0725Entity.getKensakuyoKanaMeisho());
        tmpEntity.setCaT0752daihyoshaShikibetsuCode(cat0725Entity.getDaihyoshaShikibetsuCode());
        tmpEntity.setCaT0752daihyoshaShimei(cat0725Entity.getDaihyoshaShimei());
    }

    private void set口座情報の全項目(TokuteiKozaRelateEntity 特定口座, TmpIdoFukaJohoEntity tmpEntity) {

        UaT0310KozaEntity uat0310Entity = 特定口座.getUaT0310KozaEntity();
        tmpEntity.setUaT0310Koza_kozaId(uat0310Entity.getKozaId());
        tmpEntity.setUaT0310Koza_shikibetsuCode(uat0310Entity.getShikibetsuCode());
        tmpEntity.setUaT0310Koza_gyomubetsuPrimaryKey(uat0310Entity.getGyomubetsuPrimaryKey());
        tmpEntity.setUaT0310Koza_gyomuKoyuKey(uat0310Entity.getGyomuKoyuKey());
        tmpEntity.setUaT0310Koza_yotoKubun(uat0310Entity.getYotoKubun().getColumnValue());
        tmpEntity.setUaT0310Koza_torokuRenban(uat0310Entity.getTorokuRenban());
        tmpEntity.setUaT0310Koza_kaishiYMD(uat0310Entity.getKaishiYMD());
        tmpEntity.setUaT0310Koza_shuryoYMD(uat0310Entity.getShuryoYMD());
        tmpEntity.setUaT0310Koza_kinyuKikanCode(uat0310Entity.getKinyuKikanCode());
        tmpEntity.setUaT0310Koza_kinyuKikanShitenCode(uat0310Entity.getKinyuKikanShitenCode());
        tmpEntity.setUaT0310Koza_yokinShubetsu(uat0310Entity.getYokinShubetsu());
        tmpEntity.setUaT0310Koza_kozaNo(uat0310Entity.getKozaNo());
        tmpEntity.setUaT0310Koza_tsuchoKigo(uat0310Entity.getTsuchoKigo());
        tmpEntity.setUaT0310Koza_tsuchoNo(uat0310Entity.getTsuchoNo());
        tmpEntity.setUaT0310Koza_kozaMeigininShikibetsuCode(uat0310Entity.getKozaMeigininShikibetsuCode());
        tmpEntity.setUaT0310Koza_kozaMeiginin(uat0310Entity.getKozaMeiginin());
        tmpEntity.setUaT0310Koza_kozaMeigininKanji(uat0310Entity.getKozaMeigininKanji());
        tmpEntity.setUaT0310Koza_kensakuyoMeiginin(uat0310Entity.getKensakuyoMeiginin());
        tmpEntity.setUaT0310Koza_kozaHyojiKubun(uat0310Entity.getKozaHyojiKubun());
        tmpEntity.setUaT0310Koza_nayoseKubun(uat0310Entity.getNayoseKubun());
        tmpEntity.setUaT0310Koza_zumitsuHakkoYohi(uat0310Entity.getZumitsuHakkoYohi());
        tmpEntity.setUaT0310Koza_kozaFurikaeKaishiTsuchiHakkozumi(uat0310Entity.getKozaFurikaeKaishiTsuchiHakkozumi());
        tmpEntity.setUaT0310Koza_kozaTorokuNo(uat0310Entity.getKozaTorokuNo());
        tmpEntity.setUaT0310Koza_kozaTorokuKubunCode(uat0310Entity.getKozaTorokuKubunCode().getColumnValue());
        tmpEntity.setUaT0310Koza_kozaKaishiUketsukeYMD(uat0310Entity.getKozaKaishiUketsukeYMD());
        tmpEntity.setUaT0310Koza_kozaShuryoUketsukeYMD(uat0310Entity.getKozaShuryoUketsukeYMD());
        tmpEntity.setUaT0310Koza_kozaTorokuYMD(uat0310Entity.getKozaTorokuYMD());
        tmpEntity.setUaT0310Koza_temban(uat0310Entity.getTemban());

        UaT0302KinyuKikanEntity uat0302Entity = 特定口座.getKinyuKikanEntity();
        tmpEntity.setUaT0302KinyuKikan_kinyuKikanCode(uat0302Entity.getKinyuKikanCode());
        tmpEntity.setUaT0302KinyuKikan_kaishiYMD(uat0302Entity.getKaishiYMD());
        tmpEntity.setUaT0302KinyuKikan_shuryoYMD(uat0302Entity.getShuryoYMD());
        tmpEntity.setUaT0302KinyuKikan_name(uat0302Entity.getName());
        tmpEntity.setUaT0302KinyuKikan_kanaName(uat0302Entity.getKanaName());
        tmpEntity.setUaT0302KinyuKikan_yokinShubetsuPatternCode(uat0302Entity.getYokinShubetsuPatternCode().getColumnValue());
        tmpEntity.setUaT0302KinyuKikan_hyojijun(uat0302Entity.getHyojijun());

        UaT0301YokinShubetsuPatternEntity uat0301Entity = 特定口座.getYokinShubetsuPatternEntity();
        if (uat0301Entity != null) {
            tmpEntity.setUaT0301YokinShubetsuPattern_yokinShubetsuPatternCode(uat0301Entity.getYokinShubetsuPatternCode().getColumnValue());
            tmpEntity.setUaT0301YokinShubetsuPattern_yokinShubetsuCode(uat0301Entity.getYokinShubetsuCode());
            tmpEntity.setUaT0301YokinShubetsuPattern_yokinShubetsuMeisho(uat0301Entity.getYokinShubetsuMeisho());
            tmpEntity.setUaT0301YokinShubetsuPattern_yokinShubetsuRyakusho(uat0301Entity.getYokinShubetsuRyakusho());
        }

        UaT0303KinyuKikanShitenEntity uat0303Entity = 特定口座.getKinyuKikanShitenEntity();
        if (uat0303Entity != null) {
            tmpEntity.setUaT0303KinyuKikanShiten_kinyuKikanCode(uat0303Entity.getKinyuKikanCode());
            tmpEntity.setUaT0303KinyuKikanShiten_kinyuKikanShitenCode(uat0303Entity.getKinyuKikanShitenCode());
            tmpEntity.setUaT0303KinyuKikanShiten_kaishiYMD(uat0303Entity.getKaishiYMD());
            tmpEntity.setUaT0303KinyuKikanShiten_shuryoYMD(uat0303Entity.getShuryoYMD());
            tmpEntity.setUaT0303KinyuKikanShiten_name(uat0303Entity.getName());
            tmpEntity.setUaT0303KinyuKikanShiten_kanaName(uat0303Entity.getKanaName());
            tmpEntity.setUaT0303KinyuKikanShiten_hyojijun(uat0303Entity.getHyojijun());
        }
    }

    private void set宛先代納の全項目(UaFt250FindAtesakiEntity 宛先, TmpIdoFukaJohoEntity tmpEntity) {
        tmpEntity.setAtesakiDaino_shikibetsuCode(宛先.getShikibetsuCode());
        tmpEntity.setAtesakiDaino_atesakiShubetsu(宛先.getAtesakiShubetsu());
        tmpEntity.setAtesakiDaino_gyomubetsuPrimaryKey(宛先.getGyomubetsuPrimaryKey());
        tmpEntity.setAtesakiDaino_gyomuCode(宛先.getGyomuCode());
        tmpEntity.setAtesakiDaino_subGyomuCode(宛先.getSubGyomuCode());
        tmpEntity.setAtesakiDaino_gyomuGroupCode(宛先.getGyomuGroupCode());
        tmpEntity.setAtesakiDaino_gyomuGroupName(宛先.getGyomuGroupName());
        tmpEntity.setAtesakiDaino_subGyomuGroupCode(宛先.getSubGyomuGroupCode());
        tmpEntity.setAtesakiDaino_subGyomuGroupName(宛先.getSubGyomuGroupName());
        tmpEntity.setAtesakiDaino_kamokuCode(宛先.getKamokuCode());
        tmpEntity.setAtesakiDaino_gyomuKoyuKey(宛先.getGyomuKoyuKey());
        tmpEntity.setAtesakiDaino_kannaiKangaiKubun(宛先.getKannaiKangaiKubun());
        tmpEntity.setAtesakiDaino_zenkokuJushoCode(宛先.getZenkokuJushoCode());
        tmpEntity.setAtesakiDaino_choikiCode(宛先.getChoikiCode());
        tmpEntity.setAtesakiDaino_jusho(宛先.getJusho());
        tmpEntity.setAtesakiDaino_yubinNo(宛先.getYubinNo());
        tmpEntity.setAtesakiDaino_banchiCode1(宛先.getBanchiCode1());
        tmpEntity.setAtesakiDaino_banchiCode2(宛先.getBanchiCode2());
        tmpEntity.setAtesakiDaino_banchiCode3(宛先.getBanchiCode3());
        tmpEntity.setAtesakiDaino_banchiCode4(宛先.getBanchiCode4());
        tmpEntity.setAtesakiDaino_banchi(宛先.getBanchi());
        tmpEntity.setAtesakiDaino_katagakiInjiFlag(宛先.getKatagakiInjiFlag());
        tmpEntity.setAtesakiDaino_katagaki(宛先.getKatagaki());
        tmpEntity.setAtesakiDaino_gyoseikuCode(宛先.getGyoseikuCode());
        tmpEntity.setAtesakiDaino_gyoseiku(宛先.getGyoseiku());
        tmpEntity.setAtesakiDaino_chikuCode1(宛先.getChikuCode1());
        tmpEntity.setAtesakiDaino_chiku1(宛先.getChiku1());
        tmpEntity.setAtesakiDaino_chikuCode2(宛先.getChikuCode2());
        tmpEntity.setAtesakiDaino_chiku2(宛先.getChiku2());
        tmpEntity.setAtesakiDaino_chikuCode3(宛先.getChikuCode3());
        tmpEntity.setAtesakiDaino_chiku3(宛先.getChiku3());
        tmpEntity.setAtesakiDaino_juminShubetsuCode(宛先.getJuminShubetsuCode());
        tmpEntity.setAtesakiDaino_juminJotaiCode(宛先.getJuminJotaiCode());
        tmpEntity.setAtesakiDaino_kanjiShimei(宛先.getKanjiShimei());
        tmpEntity.setAtesakiDaino_kanaShimei(宛先.getKanaShimei());
        tmpEntity.setAtesakiDaino_gaikokujinShimei(宛先.getGaikokujinShimei());
        tmpEntity.setAtesakiDaino_gaikokujinHeikimei(宛先.getGaikokujinHeikimei());
        tmpEntity.setAtesakiDaino_gaikokujinKanaShimei(宛先.getGaikokujinKanaShimei());
        tmpEntity.setAtesakiDaino_tsushomei(宛先.getTsushomei());
        tmpEntity.setAtesakiDaino_kanaTsushomei(宛先.getKanaTsushomei());
        tmpEntity.setAtesakiDaino_shimeiRiyoKubun(宛先.getShimeiRiyoKubun());
        tmpEntity.setAtesakiDaino_kyoyushaMeisho(宛先.getKyoyushaMeisho());
        tmpEntity.setAtesakiDaino_kyoyushaKanaMeisho(宛先.getKyoyushaKanaMeisho());
        tmpEntity.setAtesakiDaino_hojinKeitaiCode(宛先.getHojinKeitaiCode());
        tmpEntity.setAtesakiDaino_hojinMeiHenshuKubun(宛先.getHojinMeiHenshuKubun());
        tmpEntity.setAtesakiDaino_hojinKeitaiRyakushoKubun(宛先.getHojinKeitaiRyakushoKubun());
        tmpEntity.setAtesakiDaino_hojinMeisho(宛先.getHojinMeisho());
        tmpEntity.setAtesakiDaino_hojinKanaMeisho(宛先.getHojinKanaMeisho());
        tmpEntity.setAtesakiDaino_hojinShitenMeisho(宛先.getHojinShitenMeisho());
        tmpEntity.setAtesakiDaino_hojinShitenKanaMeisho(宛先.getHojinKanaMeisho());
        tmpEntity.setAtesakiDaino_sofusakiMeisho(宛先.getHojinMeisho());
        tmpEntity.setAtesakiDaino_sofusakiKanaMeisho(宛先.getSofusakiKanaMeisho());
        tmpEntity.setAtesakiDaino_renrakusaki1(宛先.getRenrakusaki1());
        tmpEntity.setAtesakiDaino_renrakusakiKubun1(宛先.getRenrakusakiKubun1());
        tmpEntity.setAtesakiDaino_renrakusaki2(宛先.getRenrakusaki2());
        tmpEntity.setAtesakiDaino_renrakusakiKubun2(宛先.getRenrakusakiKubun2());
        tmpEntity.setAtesakiDaino_renrakusaki3(宛先.getRenrakusaki3());
        tmpEntity.setAtesakiDaino_renrakusakiKubun3(宛先.getRenrakusakiKubun3());
        tmpEntity.setAtesakiDaino_mailAddress(宛先.getMailAddress());
        tmpEntity.setAtesakiDaino_dainoKankeiCode(宛先.getDainoKankeiCode());
        tmpEntity.setAtesakiDaino_biko(宛先.getBiko());
        tmpEntity.setAtesakiDaino_honninJuminShubetsuCode(宛先.getHonninJuminShubetsuCode());
        tmpEntity.setAtesakiDaino_honninJuminJotaiCode(宛先.getHonninJuminJotaiCode());
        tmpEntity.setAtesakiDaino_honninKanjiShimei(宛先.getHonninKanjiShimei());
        tmpEntity.setAtesakiDaino_honninKanaShimei(宛先.getHonninKanaShimei());
        tmpEntity.setAtesakiDaino_honninGaikokujinShimei(宛先.getHonninGaikokujinHeikimei());
        tmpEntity.setAtesakiDaino_honninGaikokujinHeikimei(宛先.getHonninGaikokujinHeikimei());
        tmpEntity.setAtesakiDaino_honninGaikokujinKanaShimei(宛先.getHonninGaikokujinKanaShimei());
        tmpEntity.setAtesakiDaino_honninTsushomei(宛先.getHonninTsushomei());
        tmpEntity.setAtesakiDaino_honninKanaTsushomei(宛先.getHonninKanaTsushomei());
        tmpEntity.setAtesakiDaino_honninShimeiRiyoKubun(宛先.getHonninShimeiRiyoKubun());
        tmpEntity.setAtesakiDaino_honninKyoyushaMeisho(宛先.getHonninKyoyushaMeisho());
        tmpEntity.setAtesakiDaino_honninKyoyushaKanaMeisho(宛先.getHonninKyoyushaKanaMeisho());
        tmpEntity.setAtesakiDaino_honninHojinKeitaiCode(宛先.getHonninHojinKeitaiCode());
        tmpEntity.setAtesakiDaino_honninHojinMeiHenshuKubun(宛先.getHonninHojinMeiHenshuKubun());
        tmpEntity.setAtesakiDaino_honninHojinKeitaiRyakushoKubun(宛先.getHonninHojinKeitaiRyakushoKubun());
        tmpEntity.setAtesakiDaino_honninHojinMeisho(宛先.getHonninHojinMeisho());
        tmpEntity.setAtesakiDaino_honninHojinKanaMeisho(宛先.getHonninHojinKanaMeisho());
        tmpEntity.setAtesakiDaino_honninHojinShitenMeisho(宛先.getHojinShitenMeisho());
        tmpEntity.setAtesakiDaino_honninHojinShitenKanaMeisho(宛先.getHonninHojinKanaMeisho());
        tmpEntity.setAtesakiDaino_honninDaihyoshaShikibetsuCode(宛先.getHonninDaihyoshaShikibetsuCode());
        tmpEntity.setAtesakiDaino_honninDaihyoshaJuminShubetsuCode(宛先.getHonninDaihyoshaJuminShubetsuCode());
        tmpEntity.setAtesakiDaino_honninDaihyoshaShimei(宛先.getHonninDaihyoshaShimei());
        tmpEntity.setAtesakiDaino_honninDaihyoshaKanaShimei(宛先.getHonninDaihyoshaKanaShimei());
        tmpEntity.setAtesakiDaino_honninDaihyoshaNihonjinShimei(宛先.getHonninDaihyoshaNihonjinShimei());
        tmpEntity.setAtesakiDaino_honninDaihyoshaNihonjinKanaShimei(宛先.getHonninDaihyoshaNihonjinKanaShimei());
        tmpEntity.setAtesakiDaino_honninDaihyoshaGaikokujinShimei(宛先.getHonninDaihyoshaGaikokujinShimei());
        tmpEntity.setAtesakiDaino_honninDaihyoshaGaikokujinHeikimei(宛先.getHonninDaihyoshaGaikokujinHeikimei());
        tmpEntity.setAtesakiDaino_honninDaihyoshaGaikokujinKanaShimei(宛先.getHonninDaihyoshaGaikokujinKanaShimei());
        tmpEntity.setAtesakiDaino_honninDaihyoshaTsushomei(宛先.getHonninDaihyoshaTsushomei());
        tmpEntity.setAtesakiDaino_honninDaihyoshaShimeiRiyoKubun(宛先.getHonninDaihyoshaShimeiRiyoKubun());
        tmpEntity.setAtesakiDaino_honninDaihyoshaKanaTsushomei(宛先.getHonninDaihyoshaKanaTsushomei());
        tmpEntity.setAtesakiDaino_setainushiShikibetsuCode(宛先.getSetainushiShikibetsuCode());
        tmpEntity.setAtesakiDaino_setainushiKannaiKangaiKubun(宛先.getSetainushiKannaiKangaiKubun());
        tmpEntity.setAtesakiDaino_setainushiZenkokuJushoCode(宛先.getSetainushiZenkokuJushoCode());
        tmpEntity.setAtesakiDaino_setainushiChoikiCode(宛先.getSetainushiChoikiCode());
        tmpEntity.setAtesakiDaino_setainushiJusho(宛先.getSetainushiJusho());
        tmpEntity.setAtesakiDaino_setainushiYubinNo(宛先.getSetainushiYubinNo());
        tmpEntity.setAtesakiDaino_setainushiBanchiCode1(宛先.getSetainushiBanchiCode1());
        tmpEntity.setAtesakiDaino_setainushiBanchiCode2(宛先.getSetainushiBanchiCode2());
        tmpEntity.setAtesakiDaino_setainushiBanchiCode3(宛先.getSetainushiBanchiCode3());
        tmpEntity.setAtesakiDaino_setainushiBanchiCode4(宛先.getSetainushiBanchiCode4());
        tmpEntity.setAtesakiDaino_setainushiBanchi(宛先.getSetainushiBanchi());
        tmpEntity.setAtesakiDaino_setainushiKatagakiInjiFlag(宛先.getSetainushiKatagakiInjiFlag());
        tmpEntity.setAtesakiDaino_setainushiKatagaki(宛先.getSetainushiKatagaki());
        tmpEntity.setAtesakiDaino_setainushiGyoseikuCode(宛先.getSetainushiGyoseikuCode());
        tmpEntity.setAtesakiDaino_setainushiGyoseikuName(宛先.getSetainushiGyoseikuName());
        tmpEntity.setAtesakiDaino_setainushiJuminShubetsuCode(宛先.getSetainushiJuminJotaiCode());
        tmpEntity.setAtesakiDaino_setainushiJuminJotaiCode(宛先.getSetainushiJuminJotaiCode());
        tmpEntity.setAtesakiDaino_setainushiKanjiShimei(宛先.getSetainushiKanjiShimei());
        tmpEntity.setAtesakiDaino_setainushiKanaShimei(宛先.getSetainushiKanaShimei());
        tmpEntity.setAtesakiDaino_setainushiGaikokujinShimei(宛先.getSetainushiGaikokujinShimei());
        tmpEntity.setAtesakiDaino_setainushiGaikokujinHeikimei(宛先.getSetainushiGaikokujinHeikimei());
        tmpEntity.setAtesakiDaino_setainushiGaikokujinKanaShimei(宛先.getSetainushiGaikokujinKanaShimei());
        tmpEntity.setAtesakiDaino_setainushiTsushomei(宛先.getSetainushiTsushomei());
        tmpEntity.setAtesakiDaino_setainushiKanaTsushomei(宛先.getSetainushiKanaTsushomei());
        tmpEntity.setAtesakiDaino_setainushiShimeiRiyoKubun(宛先.getSetainushiShimeiRiyoKubun());
        tmpEntity.setAtesakiDaino_setainushiRenrakusaki1(宛先.getSetainushiRenrakusaki1());
        tmpEntity.setAtesakiDaino_setainushiRenrakusakiKubun1(宛先.getSetainushiRenrakusakiKubun1());
        tmpEntity.setAtesakiDaino_setainushiRenrakusaki2(宛先.getSetainushiRenrakusaki2());
        tmpEntity.setAtesakiDaino_setainushiRenrakusakiKubun2(宛先.getSetainushiRenrakusakiKubun2());
        tmpEntity.setAtesakiDaino_setainushiRenrakusaki3(宛先.getSetainushiRenrakusaki3());
        tmpEntity.setAtesakiDaino_setainushiRenrakusakiKubun3(宛先.getSetainushiRenrakusakiKubun3());
        tmpEntity.setAtesakiDaino_setainushiMailAddress(宛先.getSetainushiMailAddress());
        tmpEntity.setAtesakiDaino_dainoninShikibetsuCode(宛先.getDainoninShikibetsuCode());
        tmpEntity.setAtesakiDaino_honninSetaiCode(宛先.getHonninSetaiCode());
        tmpEntity.setAtesakiDaino_dainoninSetaiCode(宛先.getDainoninSetaiCode());
    }

    private void 年金特徴回付情報_更正後値設定(TmpIdoFukaJohoEntity entity, final UeT0511NenkinTokuchoKaifuJohoEntity 年金特徴回付情報_更正後) {
        entity.setUeT0511after_gyomuCode(年金特徴回付情報_更正後.getGyomuCode());
        entity.setUeT0511after_shoriNendo(年金特徴回付情報_更正後.getShoriNendo());
        TsuchiNaiyoCode tsuchiNaiyoCode = 年金特徴回付情報_更正後.getTsuchiNaiyoCode();
        if (tsuchiNaiyoCode != null) {
            entity.setUeT0511after_tsuchiNaiyoCode(tsuchiNaiyoCode.getColumnValue());
        }
        entity.setUeT0511after_shoriTaishoYM(年金特徴回付情報_更正後.getShoriTaishoYM());
        entity.setUeT0511after_kisoNenkinNo(年金特徴回付情報_更正後.getKisoNenkinNo());
        entity.setUeT0511after_nenkinCode(年金特徴回付情報_更正後.getNenkinCode());
        entity.setUeT0511after_koseiCityCode(年金特徴回付情報_更正後.getKoseiCityCode());
        entity.setUeT0511after_renban(年金特徴回付情報_更正後.getRenban());
        entity.setUeT0511after_shoriTimestamp(年金特徴回付情報_更正後.getShoriTimestamp());
        RenkeiShubetsu renkeiShubetsu = 年金特徴回付情報_更正後.getRenkeiShubetsu();
        if (renkeiShubetsu != null) {
            entity.setUeT0511after_renkeiShubetsu(renkeiShubetsu.getColumnValue());
        }
        entity.setUeT0511after_hosokuTsuki(年金特徴回付情報_更正後.getHosokuTsuki());
        entity.setUeT0511after_tenbikiTsuki(年金特徴回付情報_更正後.getTenbikiTsuki());
        entity.setUeT0511after_shikibetsuCode(年金特徴回付情報_更正後.getShikibetsuCode());
        entity.setUeT0511after_hihokenshaNo(年金特徴回付情報_更正後.getHihokenshaNo());
        entity.setUeT0511after_kokuhoSetaiCode(年金特徴回付情報_更正後.getKokuhoSetaiCode());
        entity.setUeT0511after_dtCityCode(年金特徴回付情報_更正後.getDtCityCode());
        TokubetsuChoshuGimushaCode tokubetsuChoshuGimushaCode = 年金特徴回付情報_更正後.getDtTokubetsuChoshuGimushaCode();
        if (tokubetsuChoshuGimushaCode != null) {
            entity.setUeT0511after_dtTokubetsuChoshuGimushaCode(tokubetsuChoshuGimushaCode.getColumnValue());
        }
        TsuchiNaiyoCode dTTsuchiNaiyoCode = 年金特徴回付情報_更正後.getDtTsuchiNaiyoCode();
        if (dTTsuchiNaiyoCode != null) {
            entity.setUeT0511after_dtTsuchiNaiyoCode(dTTsuchiNaiyoCode.getColumnValue());
        }
        entity.setUeT0511after_dtBaitaiCode(年金特徴回付情報_更正後.getDtBaitaiCode());
        TokubetsuChoshuSeidoCode tokubetsuChoshuSeidoCode = 年金特徴回付情報_更正後.getDtTokubetsuChoshuSeidoCode();
        if (tokubetsuChoshuSeidoCode != null) {
            entity.setUeT0511after_dtTokubetsuChoshuSeidoCode(tokubetsuChoshuSeidoCode.getColumnValue());
        }
        entity.setUeT0511after_dtSakuseiYMD(年金特徴回付情報_更正後.getDtSakuseiYMD());
        entity.setUeT0511after_dtKisoNenkinNo(年金特徴回付情報_更正後.getDtKisoNenkinNo());
        entity.setUeT0511after_dtNenkinCode(年金特徴回付情報_更正後.getDtNenkinCode());
        entity.setUeT0511after_dtYobi1(年金特徴回付情報_更正後.getDtYobi1());
        entity.setUeT0511after_dtBirthDay(年金特徴回付情報_更正後.getDtBirthDay());
        SeibetsuCodeNenkinTokucho seibetsuCodeNenkinTokucho = 年金特徴回付情報_更正後.getDtSeibetsu();
        if (seibetsuCodeNenkinTokucho != null) {
            entity.setUeT0511after_dtSeibetsu(seibetsuCodeNenkinTokucho.getColumnValue());
        }
        entity.setUeT0511after_dtKanaShimei(年金特徴回付情報_更正後.getDtKanaShimei());
        entity.setUeT0511after_dtShiftCode1(年金特徴回付情報_更正後.getDtShiftCode1());
        entity.setUeT0511after_dtKanjiShimei(年金特徴回付情報_更正後.getDtKanjiShimei());
        entity.setUeT0511after_dtShiftCode2(年金特徴回付情報_更正後.getDtShiftCode2());
        entity.setUeT0511after_dtYubinNo(年金特徴回付情報_更正後.getDtYubinNo());
        entity.setUeT0511after_dtKanaJusho(年金特徴回付情報_更正後.getDtKanaJusho());
        entity.setUeT0511after_dtShiftCode3(年金特徴回付情報_更正後.getDtShiftCode3());
        entity.setUeT0511after_dtKanjiJusho(年金特徴回付情報_更正後.getDtKanjiJusho());
        entity.setUeT0511after_dtShiftCode4(年金特徴回付情報_更正後.getDtShiftCode4());
        entity.setUeT0511after_dtKakushuKubun(年金特徴回付情報_更正後.getDtKakushuKubun());
        entity.setUeT0511after_dtShoriKekka(年金特徴回付情報_更正後.getDtShoriKekka());
        entity.setUeT0511after_dtKokiIkanCode(年金特徴回付情報_更正後.getDtKokiIkanCode());
        entity.setUeT0511after_dtKakushuYMD(年金特徴回付情報_更正後.getDtKakushuYMD());
        entity.setUeT0511after_dtKakushuKingaku1(年金特徴回付情報_更正後.getDtKakushuKingaku1());
        entity.setUeT0511after_dtKakushuKingaku2(年金特徴回付情報_更正後.getDtKakushuKingaku2());
        entity.setUeT0511after_dtKakushuKingaku3(年金特徴回付情報_更正後.getDtKakushuKingaku3());
        entity.setUeT0511after_dtYobi2(年金特徴回付情報_更正後.getDtYobi2());
        entity.setUeT0511after_dtKyosaiNenkinshoshoKigoNo(年金特徴回付情報_更正後.getDtKyosaiNenkinshoshoKigoNo());
        entity.setUeT0511after_dtKakushuKingaku4(年金特徴回付情報_更正後.getDtKakushuKingaku4());
        entity.setUeT0511after_dtKakushuKingaku5(年金特徴回付情報_更正後.getDtKakushuKingaku5());
        entity.setUeT0511after_dtKakushuKingaku6(年金特徴回付情報_更正後.getDtKakushuKingaku6());
        entity.setUeT0511after_dtKakushuKingaku7(年金特徴回付情報_更正後.getDtKakushuKingaku7());
        entity.setUeT0511after_dtKakushuKingaku8(年金特徴回付情報_更正後.getDtKakushuKingaku8());
        entity.setUeT0511after_dtTeishiYM(年金特徴回付情報_更正後.getDtTeishiYM());
        entity.setUeT0511after_dtYobi4Juminzei(年金特徴回付情報_更正後.getDtYobi4Juminzei());
        entity.setUeT0511after_dtKojinNo(年金特徴回付情報_更正後.getDtKojinNo());
        entity.setUeT0511after_kokuhoYoteiSoshitsuKubun(年金特徴回付情報_更正後.getKokuhoYoteiSoshitsuKubun());
    }

    /**
     * 年金特徴回付情報_類型転換メソッドです。
     *
     * @param entity jp.co.ndensan.reams.ue.uex.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity
     * @param 年金特徴回付情報_転換前 UeT0511NenkinTokuchoKaifuJohoEntity
     */
    public void 年金特徴回付情報_類型転換(jp.co.ndensan.reams.ue.uex.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity entity,
            final UeT0511NenkinTokuchoKaifuJohoEntity 年金特徴回付情報_転換前) {
        entity.setGyomuCode(年金特徴回付情報_転換前.getGyomuCode());
        entity.setShoriNendo(年金特徴回付情報_転換前.getShoriNendo());
        if (年金特徴回付情報_転換前.getTsuchiNaiyoCode() != null) {
            entity.setTsuchiNaiyoCode(年金特徴回付情報_転換前.getTsuchiNaiyoCode());
        }
        entity.setShoriTaishoYM(年金特徴回付情報_転換前.getShoriTaishoYM());
        entity.setKisoNenkinNo(年金特徴回付情報_転換前.getKisoNenkinNo());
        entity.setNenkinCode(年金特徴回付情報_転換前.getNenkinCode());
        entity.setKoseiCityCode(年金特徴回付情報_転換前.getKoseiCityCode());
        entity.setRenban(年金特徴回付情報_転換前.getRenban());
        entity.setShoriTimestamp(年金特徴回付情報_転換前.getShoriTimestamp());
        if (年金特徴回付情報_転換前.getRenkeiShubetsu() != null) {
            entity.setRenkeiShubetsu(年金特徴回付情報_転換前.getRenkeiShubetsu());
        }
        entity.setHosokuTsuki(年金特徴回付情報_転換前.getHosokuTsuki());
        entity.setTenbikiTsuki(年金特徴回付情報_転換前.getTenbikiTsuki());
        entity.setShikibetsuCode(年金特徴回付情報_転換前.getShikibetsuCode());
        entity.setHihokenshaNo(年金特徴回付情報_転換前.getHihokenshaNo());
        entity.setKokuhoSetaiCode(年金特徴回付情報_転換前.getKokuhoSetaiCode());
        entity.setDtCityCode(年金特徴回付情報_転換前.getDtCityCode());
        if (年金特徴回付情報_転換前.getDtTokubetsuChoshuGimushaCode() != null) {
            entity.setDtTokubetsuChoshuGimushaCode(年金特徴回付情報_転換前.getDtTokubetsuChoshuGimushaCode());
        }
        if (年金特徴回付情報_転換前.getDtTsuchiNaiyoCode() != null) {
            entity.setDtTsuchiNaiyoCode(年金特徴回付情報_転換前.getDtTsuchiNaiyoCode());
        }
        entity.setDtBaitaiCode(年金特徴回付情報_転換前.getDtBaitaiCode());
        if (年金特徴回付情報_転換前.getDtTokubetsuChoshuSeidoCode() != null) {
            entity.setDtTokubetsuChoshuSeidoCode(年金特徴回付情報_転換前.getDtTokubetsuChoshuSeidoCode());
        }
        entity.setDtSakuseiYMD(年金特徴回付情報_転換前.getDtSakuseiYMD());
        entity.setDtKisoNenkinNo(年金特徴回付情報_転換前.getDtKisoNenkinNo());
        entity.setDtNenkinCode(年金特徴回付情報_転換前.getDtNenkinCode());
        entity.setDtYobi1(年金特徴回付情報_転換前.getDtYobi1());
        entity.setDtBirthDay(年金特徴回付情報_転換前.getDtBirthDay());
        if (年金特徴回付情報_転換前.getDtSeibetsu() != null) {
            entity.setDtSeibetsu(年金特徴回付情報_転換前.getDtSeibetsu());
        }
        entity.setDtKanaShimei(年金特徴回付情報_転換前.getDtKanaShimei());
        entity.setDtShiftCode1(年金特徴回付情報_転換前.getDtShiftCode1());
        entity.setDtKanjiShimei(年金特徴回付情報_転換前.getDtKanjiShimei());
        entity.setDtShiftCode2(年金特徴回付情報_転換前.getDtShiftCode2());
        entity.setDtYubinNo(年金特徴回付情報_転換前.getDtYubinNo());
        entity.setDtKanaJusho(年金特徴回付情報_転換前.getDtKanaJusho());
        entity.setDtShiftCode3(年金特徴回付情報_転換前.getDtShiftCode3());
        entity.setDtKanjiJusho(年金特徴回付情報_転換前.getDtKanjiJusho());
        entity.setDtShiftCode4(年金特徴回付情報_転換前.getDtShiftCode4());
        entity.setDtKakushuKubun(年金特徴回付情報_転換前.getDtKakushuKubun());
        entity.setDtShoriKekka(年金特徴回付情報_転換前.getDtShoriKekka());
        entity.setDtKokiIkanCode(年金特徴回付情報_転換前.getDtKokiIkanCode());
        entity.setDtKakushuYMD(年金特徴回付情報_転換前.getDtKakushuYMD());
        entity.setDtKakushuKingaku1(年金特徴回付情報_転換前.getDtKakushuKingaku1());
        entity.setDtKakushuKingaku2(年金特徴回付情報_転換前.getDtKakushuKingaku2());
        entity.setDtKakushuKingaku3(年金特徴回付情報_転換前.getDtKakushuKingaku3());
        entity.setDtYobi2(年金特徴回付情報_転換前.getDtYobi2());
        entity.setDtKyosaiNenkinshoshoKigoNo(年金特徴回付情報_転換前.getDtKyosaiNenkinshoshoKigoNo());
        entity.setDtKakushuKingaku4(年金特徴回付情報_転換前.getDtKakushuKingaku4());
        entity.setDtKakushuKingaku5(年金特徴回付情報_転換前.getDtKakushuKingaku5());
        entity.setDtKakushuKingaku6(年金特徴回付情報_転換前.getDtKakushuKingaku6());
        entity.setDtKakushuKingaku7(年金特徴回付情報_転換前.getDtKakushuKingaku7());
        entity.setDtKakushuKingaku8(年金特徴回付情報_転換前.getDtKakushuKingaku8());
        entity.setDtTeishiYM(年金特徴回付情報_転換前.getDtTeishiYM());
        entity.setDtYobi4Juminzei(年金特徴回付情報_転換前.getDtYobi4Juminzei());
        entity.setDtKojinNo(年金特徴回付情報_転換前.getDtKojinNo());
        entity.setKokuhoYoteiSoshitsuKubun(年金特徴回付情報_転換前.getKokuhoYoteiSoshitsuKubun());
    }

    private void 計算後情報_更正後値設定(TmpIdoFukaJohoEntity entity, final DbT2015KeisangoJohoEntity 計算後情報_更正後) {
        entity.setDbT2015KeisangoJoho_choteiNendo(計算後情報_更正後.getChoteiNendo());
        entity.setDbT2015KeisangoJoho_fukaNendo(計算後情報_更正後.getFukaNendo());
        entity.setDbT2015KeisangoJoho_tsuchishoNo(計算後情報_更正後.getTsuchishoNo());
        entity.setDbT2015KeisangoJoho_koseiZengoKubun(計算後情報_更正後.getKoseiZengoKubun());
        entity.setDbT2015KeisangoJoho_sakuseiShoriName(計算後情報_更正後.getSakuseiShoriName());
        entity.setDbT2015KeisangoJoho_fukaRirekiNo(計算後情報_更正後.getFukaRirekiNo());
        entity.setDbT2015KeisangoJoho_hihokenshaNo(計算後情報_更正後.getHihokenshaNo());
        entity.setDbT2015KeisangoJoho_shikibetsuCode(計算後情報_更正後.getShikibetsuCode());
        entity.setDbT2015KeisangoJoho_setaiCode(計算後情報_更正後.getSetaiCode());
        entity.setDbT2015KeisangoJoho_setaiInsu(計算後情報_更正後.getSetaiInsu());
        entity.setDbT2015KeisangoJoho_shikakuShutokuYMD(計算後情報_更正後.getShikakuShutokuYMD());
        entity.setDbT2015KeisangoJoho_shikakuShutokuJiyu(計算後情報_更正後.getShikakuShutokuJiyu());
        entity.setDbT2015KeisangoJoho_shikakuSoshitsuYMD(計算後情報_更正後.getShikakuSoshitsuYMD());
        entity.setDbT2015KeisangoJoho_shikakuSoshitsuJiyu(計算後情報_更正後.getShikakuSoshitsuJiyu());
        entity.setDbT2015KeisangoJoho_seihofujoShurui(計算後情報_更正後.getSeihofujoShurui());
        entity.setDbT2015KeisangoJoho_seihoKaishiYMD(計算後情報_更正後.getSeihoKaishiYMD());
        entity.setDbT2015KeisangoJoho_seihoHaishiYMD(計算後情報_更正後.getSeihoHaishiYMD());
        entity.setDbT2015KeisangoJoho_ronenKaishiYMD(計算後情報_更正後.getRonenKaishiYMD());
        entity.setDbT2015KeisangoJoho_ronenHaishiYMD(計算後情報_更正後.getRonenHaishiYMD());
        entity.setDbT2015KeisangoJoho_fukaYMD(計算後情報_更正後.getFukaYMD());
        entity.setDbT2015KeisangoJoho_kazeiKubun(計算後情報_更正後.getKazeiKubun());
        entity.setDbT2015KeisangoJoho_setaikazeiKubun(計算後情報_更正後.getSetaikazeiKubun());
        entity.setDbT2015KeisangoJoho_gokeiShotokuGaku(計算後情報_更正後.getGokeiShotokuGaku());
        entity.setDbT2015KeisangoJoho_nenkinShunyuGaku(計算後情報_更正後.getNenkinShunyuGaku());
        entity.setDbT2015KeisangoJoho_hokenryoDankai(計算後情報_更正後.getHokenryoDankai());
        entity.setDbT2015KeisangoJoho_hokenryoDankai1(計算後情報_更正後.getHokenryoDankai1());
        entity.setDbT2015KeisangoJoho_nengakuHokenryo1(計算後情報_更正後.getNengakuHokenryo1());
        entity.setDbT2015KeisangoJoho_tsukiwariStartYM1(計算後情報_更正後.getTsukiwariStartYM1());
        entity.setDbT2015KeisangoJoho_tsukiwariEndYM1(計算後情報_更正後.getTsukiwariEndYM1());
        entity.setDbT2015KeisangoJoho_hokenryoDankai2(計算後情報_更正後.getHokenryoDankai2());
        entity.setDbT2015KeisangoJoho_nengakuHokenryo2(計算後情報_更正後.getNengakuHokenryo2());
        entity.setDbT2015KeisangoJoho_tsukiwariStartYM2(計算後情報_更正後.getTsukiwariStartYM2());
        entity.setDbT2015KeisangoJoho_tsukiwariEndYM2(計算後情報_更正後.getTsukiwariEndYM2());
        entity.setDbT2015KeisangoJoho_choteiNichiji(計算後情報_更正後.getChoteiNichiji());
        entity.setDbT2015KeisangoJoho_choteiJiyu1(計算後情報_更正後.getChoteiJiyu1());
        entity.setDbT2015KeisangoJoho_choteiJiyu2(計算後情報_更正後.getChoteiJiyu2());
        entity.setDbT2015KeisangoJoho_choteiJiyu3(計算後情報_更正後.getChoteiJiyu3());
        entity.setDbT2015KeisangoJoho_choteiJiyu4(計算後情報_更正後.getChoteiJiyu4());
        entity.setDbT2015KeisangoJoho_koseiM(計算後情報_更正後.getKoseiM());
        entity.setDbT2015KeisangoJoho_gemmenMaeHokenryo(計算後情報_更正後.getGemmenMaeHokenryo());
        entity.setDbT2015KeisangoJoho_gemmenGaku(計算後情報_更正後.getGemmenGaku());
        entity.setDbT2015KeisangoJoho_kakuteiHokenryo(計算後情報_更正後.getKakuteiHokenryo());
        entity.setDbT2015KeisangoJoho_hokenryoDankaiKarisanntei(計算後情報_更正後.getHokenryoDankaiKarisanntei());
        entity.setDbT2015KeisangoJoho_choshuHohoRirekiNo(計算後情報_更正後.getChoshuHohoRirekiNo());
        entity.setDbT2015KeisangoJoho_idoKijunNichiji(計算後情報_更正後.getIdoKijunNichiji());
        entity.setDbT2015KeisangoJoho_kozaKubun(計算後情報_更正後.getKozaKubun());
        entity.setDbT2015KeisangoJoho_kyokaisoKubun(計算後情報_更正後.getKyokaisoKubun());
        entity.setDbT2015KeisangoJoho_shokkenKubun(計算後情報_更正後.getShokkenKubun());
        entity.setDbT2015KeisangoJoho_fukaShichosonCode(計算後情報_更正後.getFukaShichosonCode());
        entity.setDbT2015KeisangoJoho_tkSaishutsuKampuGaku(計算後情報_更正後.getTkSaishutsuKampuGaku());
        entity.setDbT2015KeisangoJoho_fuSaishutsuKampuGaku(計算後情報_更正後.getFuSaishutsuKampuGaku());
        entity.setDbT2015KeisangoJoho_tkKibetsuGaku01(計算後情報_更正後.getTkKibetsuGaku01());
        entity.setDbT2015KeisangoJoho_tkKibetsuGaku02(計算後情報_更正後.getTkKibetsuGaku02());
        entity.setDbT2015KeisangoJoho_tkKibetsuGaku03(計算後情報_更正後.getTkKibetsuGaku03());
        entity.setDbT2015KeisangoJoho_tkKibetsuGaku04(計算後情報_更正後.getTkKibetsuGaku04());
        entity.setDbT2015KeisangoJoho_tkKibetsuGaku05(計算後情報_更正後.getTkKibetsuGaku05());
        entity.setDbT2015KeisangoJoho_tkKibetsuGaku06(計算後情報_更正後.getTkKibetsuGaku06());
        entity.setDbT2015KeisangoJoho_fuKibetsuGaku01(計算後情報_更正後.getFuKibetsuGaku01());
        entity.setDbT2015KeisangoJoho_fuKibetsuGaku02(計算後情報_更正後.getFuKibetsuGaku02());
        entity.setDbT2015KeisangoJoho_fuKibetsuGaku03(計算後情報_更正後.getFuKibetsuGaku03());
        entity.setDbT2015KeisangoJoho_fuKibetsuGaku04(計算後情報_更正後.getFuKibetsuGaku04());
        entity.setDbT2015KeisangoJoho_fuKibetsuGaku05(計算後情報_更正後.getFuKibetsuGaku05());
        entity.setDbT2015KeisangoJoho_fuKibetsuGaku06(計算後情報_更正後.getFuKibetsuGaku06());
        entity.setDbT2015KeisangoJoho_fuKibetsuGaku07(計算後情報_更正後.getFuKibetsuGaku07());
        entity.setDbT2015KeisangoJoho_fuKibetsuGaku08(計算後情報_更正後.getFuKibetsuGaku08());
        entity.setDbT2015KeisangoJoho_fuKibetsuGaku09(計算後情報_更正後.getFuKibetsuGaku09());
        entity.setDbT2015KeisangoJoho_fuKibetsuGaku10(計算後情報_更正後.getFuKibetsuGaku10());
        entity.setDbT2015KeisangoJoho_fuKibetsuGaku11(計算後情報_更正後.getFuKibetsuGaku11());
        entity.setDbT2015KeisangoJoho_fuKibetsuGaku12(計算後情報_更正後.getFuKibetsuGaku12());
        entity.setDbT2015KeisangoJoho_fuKibetsuGaku13(計算後情報_更正後.getFuKibetsuGaku13());
        entity.setDbT2015KeisangoJoho_fuKibetsuGaku14(計算後情報_更正後.getFuKibetsuGaku14());
        entity.setDbT2015KeisangoJoho_choshuHoho4gatsu(計算後情報_更正後.getChoshuHoho4gatsu());
        entity.setDbT2015KeisangoJoho_choshuHoho5gatsu(計算後情報_更正後.getChoshuHoho5gatsu());
        entity.setDbT2015KeisangoJoho_choshuHoho6gatsu(計算後情報_更正後.getChoshuHoho6gatsu());
        entity.setDbT2015KeisangoJoho_choshuHoho7gatsu(計算後情報_更正後.getChoshuHoho7gatsu());
        entity.setDbT2015KeisangoJoho_choshuHoho8gatsu(計算後情報_更正後.getChoshuHoho8gatsu());
        entity.setDbT2015KeisangoJoho_choshuHoho9gatsu(計算後情報_更正後.getChoshuHoho9gatsu());
        entity.setDbT2015KeisangoJoho_choshuHoho10gatsu(計算後情報_更正後.getChoshuHoho10gatsu());
        entity.setDbT2015KeisangoJoho_choshuHoho11gatsu(計算後情報_更正後.getChoshuHoho11gatsu());
        entity.setDbT2015KeisangoJoho_choshuHoho12gatsu(計算後情報_更正後.getChoshuHoho12gatsu());
        entity.setDbT2015KeisangoJoho_choshuHoho1gatsu(計算後情報_更正後.getChoshuHoho1gatsu());
        entity.setDbT2015KeisangoJoho_choshuHoho2gatsu(計算後情報_更正後.getChoshuHoho2gatsu());
        entity.setDbT2015KeisangoJoho_choshuHoho3gatsu(計算後情報_更正後.getChoshuHoho3gatsu());
        entity.setDbT2015KeisangoJoho_choshuHohoYoku4gatsu(計算後情報_更正後.getChoshuHohoYoku4gatsu());
        entity.setDbT2015KeisangoJoho_choshuHohoYoku5gatsu(計算後情報_更正後.getChoshuHohoYoku5gatsu());
        entity.setDbT2015KeisangoJoho_choshuHohoYoku6gatsu(計算後情報_更正後.getChoshuHohoYoku6gatsu());
        entity.setDbT2015KeisangoJoho_choshuHohoYoku7gatsu(計算後情報_更正後.getChoshuHohoYoku7gatsu());
        entity.setDbT2015KeisangoJoho_choshuHohoYoku8gatsu(計算後情報_更正後.getChoshuHohoYoku8gatsu());
        entity.setDbT2015KeisangoJoho_choshuHohoYoku9gatsu(計算後情報_更正後.getChoshuHohoYoku9gatsu());
        entity.setDbT2015KeisangoJoho_kariNenkinNo(計算後情報_更正後.getKariNenkinNo());
        entity.setDbT2015KeisangoJoho_kariNenkinCode(計算後情報_更正後.getKariNenkinCode());
        entity.setDbT2015KeisangoJoho_kariHosokuM(計算後情報_更正後.getKariHosokuM());
        entity.setDbT2015KeisangoJoho_honNenkinNo(計算後情報_更正後.getHonNenkinNo());
        entity.setDbT2015KeisangoJoho_honNenkinCode(計算後情報_更正後.getHonNenkinCode());
        entity.setDbT2015KeisangoJoho_honHosokuM(計算後情報_更正後.getHonHosokuM());
        entity.setDbT2015KeisangoJoho_yokunendoKariNenkinNo(計算後情報_更正後.getYokunendoKariNenkinNo());
        entity.setDbT2015KeisangoJoho_yokunendoKariNenkinCode(計算後情報_更正後.getYokunendoKariNenkinCode());
        entity.setDbT2015KeisangoJoho_yokunendoKariHosokuM(計算後情報_更正後.getYokunendoKariHosokuM());
        entity.setDbT2015KeisangoJoho_iraiSohuzumiFlag(計算後情報_更正後.getIraiSohuzumiFlag());
        entity.setDbT2015KeisangoJoho_tsuikaIraiSohuzumiFlag(計算後情報_更正後.getTsuikaIraiSohuzumiFlag());
        entity.setDbT2015KeisangoJoho_tokuchoTeishiNichiji(計算後情報_更正後.getTokuchoTeishiNichiji());
        entity.setDbT2015KeisangoJoho_tokuchoTeishiJiyuCode(計算後情報_更正後.getTokuchoTeishiJiyuCode());
        entity.setDbT2015KeisangoJoho_tkShunyuGaku01(計算後情報_更正後.getTkShunyuGaku01());
        entity.setDbT2015KeisangoJoho_tkShunyuGaku02(計算後情報_更正後.getTkShunyuGaku02());
        entity.setDbT2015KeisangoJoho_tkShunyuGaku03(計算後情報_更正後.getTkShunyuGaku03());
        entity.setDbT2015KeisangoJoho_tkShunyuGaku04(計算後情報_更正後.getTkShunyuGaku04());
        entity.setDbT2015KeisangoJoho_tkShunyuGaku05(計算後情報_更正後.getTkShunyuGaku05());
        entity.setDbT2015KeisangoJoho_tkShunyuGaku06(計算後情報_更正後.getTkShunyuGaku06());
        entity.setDbT2015KeisangoJoho_fuShunyuGaku01(計算後情報_更正後.getFuShunyuGaku01());
        entity.setDbT2015KeisangoJoho_fuShunyuGaku02(計算後情報_更正後.getFuShunyuGaku02());
        entity.setDbT2015KeisangoJoho_fuShunyuGaku03(計算後情報_更正後.getFuShunyuGaku03());
        entity.setDbT2015KeisangoJoho_fuShunyuGaku04(計算後情報_更正後.getFuShunyuGaku04());
        entity.setDbT2015KeisangoJoho_fuShunyuGaku05(計算後情報_更正後.getFuShunyuGaku05());
        entity.setDbT2015KeisangoJoho_fuShunyuGaku06(計算後情報_更正後.getFuShunyuGaku06());
        entity.setDbT2015KeisangoJoho_fuShunyuGaku07(計算後情報_更正後.getFuShunyuGaku07());
        entity.setDbT2015KeisangoJoho_fuShunyuGaku08(計算後情報_更正後.getFuShunyuGaku08());
        entity.setDbT2015KeisangoJoho_fuShunyuGaku09(計算後情報_更正後.getFuShunyuGaku09());
        entity.setDbT2015KeisangoJoho_fuShunyuGaku10(計算後情報_更正後.getFuShunyuGaku10());
        entity.setDbT2015KeisangoJoho_fuShunyuGaku11(計算後情報_更正後.getFuShunyuGaku11());
        entity.setDbT2015KeisangoJoho_fuShunyuGaku12(計算後情報_更正後.getFuShunyuGaku12());
        entity.setDbT2015KeisangoJoho_fuShunyuGaku13(計算後情報_更正後.getFuShunyuGaku13());
        entity.setDbT2015KeisangoJoho_fuShunyuGaku14(計算後情報_更正後.getFuShunyuGaku14());
    }
}
