/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.dbd492001;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001.ichijiteburu.FairudetaIchijiTeburuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBD;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4003YokaigoNinteiInterfaceEntity;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定インターフェースマスタの編集ビジネスクラスです。
 *
 * @reamsid_L DBD-1510-030 x_xuliang
 */
public class YokaigoninteiIntafesebusiness {

    private static final RString 富士通 = new RString("5");
    private static final RString NEC = new RString("9");
    private static final RString 分離文字 = new RString("|");
    private RString 一次判定内容;
    private static final int ZERO = 0;
    private static final int NUM = 2000;

    /**
     * 要介護認定インターフェースマスタをセット
     *
     * @param f JinbunoQurirumirisutofairuYishiteburuEntity
     * @param entity DbT4003YokaigoNinteiInterfaceEntity
     */
    public void editDbT4003Yokaigo(FairudetaIchijiTeburuEntity f, DbT4003YokaigoNinteiInterfaceEntity entity) {
        entity.setShinseishoKanriNo(new ShinseishoKanriNo(f.getShinseishoKanriNo()));
        entity.setHihokenshaNo(new HihokenshaNo(f.getHihokenjabango()));
        entity.setRirekiNo(new RString("0000"));
        entity.setTorikomiTimestamp(YMDHMS.now());
        entity.setTorikomiKubun(new RString("0"));
        if (f.getShinseikubunshinseiji() != null) {
            entity.setShinseiShubetsuCode(f.getShinseikubunshinseiji().value());
        } else {
            entity.setShinseiShubetsuCode(RString.EMPTY);
        }
        if (f.getTorisakubunkodo() != null) {
            entity.setTorisageKubunCode(f.getTorisakubunkodo().value());
        } else {
            entity.setTorisageKubunCode(RString.EMPTY);
        }
        entity.setShinseiYMD(f.getNinteishinseibi());
        entity.setIryoKikanCode(f.getShujiiiryokikanbango());
        entity.setShujiiCode(f.getShujiibango());
        entity.setIkenshoIraiYMD(f.getLkenshoiraibi());
        entity.setIkenshoToriyoseYMD(f.getLkenshonyushubi());
        entity.setChosaItakuYMD(f.getChosairaibi());
        entity.setChosaShuryoYMD(f.getChosajisshibi());
        entity.setChosaItakusakiCode(new JigyoshaNo(f.getLtakukubun()));
        entity.setChosainCode(f.getNinteichosainbango());
        entity.setIchijiHanteiYMD(f.getLchijihanteibi());
        entity.setIchijiHanteiKekkaCode(f.getLchijihanteikekka());
        entity.setIchijiHanteiKekkaKasanCode(RString.EMPTY);
        entity.setShinsakaiShiryoSakuseiYMD(f.getNinteishinsakaishiryosakuseibi());
        entity.setShinsakaiYoteiYMD(f.getNinteishinsakaiyoteibi());
        if (f.getGogitaibango() != null) {
            entity.setGogitaiNo(Integer.parseInt(f.getGogitaibango().toString()));
        }
        entity.setNijiHanteiYMD(f.getNijihanteibi());
        entity.setNijiHanteiKekkaCode(f.getNijihanteikekka());
        entity.setNinteiYukoKikanStart(f.getNinteiyukokigen_kaishi());
        entity.setNinteiYukoKikanEnd(f.getNinteiyukokigen_shuryo());

        if (f.getGenzainosabisukubunkodo() != null) {
            entity.setServiceHenkoRiyuCode(f.getGenzainosabisukubunkodo().value());
        } else {
            entity.setServiceHenkoRiyuCode(RString.EMPTY);
        }
        if (f.getTokuteishippeikodo() != null) {
            entity.setTokuteiShippeiCode(f.getTokuteishippeikodo().value());
        } else {
            entity.setTokuteiShippeiCode(RString.EMPTY);
        }
        entity.setShogaiKoreiJiritsudo(f.getShogaikoreishajiritsudo());
        entity.setNinchishoKoreiJiritsudo(f.getNinshishokoreishajiritsudo());
        entity.setShinsakaiIken(f.getNinteishinsakaiikento());
        RString 要介護種類 = DbBusinessConfig.get(ConfigNameDBD.要介護ＩＦ_ＩＦ種類, RDate.getNowDate(), SubGyomuCode.DBD介護受給);
        if (富士通.equals(要介護種類)) {
            entity.setVersionNo(new RString("403"));
        } else if (NEC.equals(要介護種類)) {
            entity.setVersionNo(new RString("109"));
        } else {
            entity.setVersionNo(new RString("401"));
        }
        一次判定内容 = RString.EMPTY;
        edit3to15(f);
        edit16to32(f);
        edit33to50(f);
        edit51to65(f);
        edit66to80(f);
        edit81to95(f);
        edit96to110(f);
        edit111to125(f);
        edit126to140(f);
        edit141to155(f);
        edit156to170(f);
        edit171to185(f);
        edit186to200(f);
        edit201to215(f);
        edit216to230(f);
        edit231to245(f);
        edit246to260(f);
        edit261to275(f);
        edit276to290(f);
        edit291to305(f);
        edit306to320(f);
        edit321to328(f);
        if (一次判定内容.length() <= NUM) {
            entity.setIchijiHanteiNaiyo(一次判定内容);
            entity.setIchijiHanteiNaiyo2(RString.EMPTY);
        } else {
            entity.setIchijiHanteiNaiyo(一次判定内容.substring(ZERO, NUM));
            entity.setIchijiHanteiNaiyo2(一次判定内容.substring(NUM));
        }
        entity.setZenTorikomiTimestamp(null);
        entity.setKeshikomiFlag(RString.EMPTY);
        entity.setKeshikomiTimestamp(null);
        entity.setYobiKomoku1(RString.EMPTY);
        entity.setYobiKomoku2(RString.EMPTY);
        entity.setYobiKomoku3(RString.EMPTY);
        entity.setYobiKomoku4(RString.EMPTY);
        entity.setYobiKomoku5(RString.EMPTY);
        entity.setYobiKubun1(RString.EMPTY);
        entity.setYobiKubun2(RString.EMPTY);
        entity.setYobiKubun3(RString.EMPTY);
        entity.setYobiKubun4(RString.EMPTY);
        entity.setYobiKubun5(RString.EMPTY);
        entity.setReserve(RString.EMPTY);
    }

    private void edit3to15(FairudetaIchijiTeburuEntity entity) {
        一次判定内容 = 一次判定内容.concat(entity.getShikibetsukodo() != null ? entity.getShikibetsukodo() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getHokenshabango() != null ? entity.getHokenshabango() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getHihokenjabango() != null ? entity.getHihokenjabango() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getNinteishinseibi() != null ? new RString(entity.getNinteishinseibi().toString()) : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getEdaban() != null
                ? entity.getEdaban() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getShinseikubunhorei() != null ? entity.getShinseikubunhorei().value() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getShinseikubunshinseiji() != null ? entity.getShinseikubunshinseiji().value() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getTorisakubunkodo() != null ? entity.getTorisakubunkodo().value() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getHihokenjakubun() != null ? entity.getHihokenjakubun().value() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getShinseidaikokubun() != null ? entity.getShinseidaikokubun().value() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getSeinengappi() != null ? new RString(entity.getSeinengappi().toString()) : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(new RString(entity.getNenrei()).concat(分離文字));
        一次判定内容 = 一次判定内容.concat(entity.getSeibetsukodo() != null ? entity.getSeibetsukodo().value() : RString.EMPTY).concat(分離文字);
    }

    private void edit16to32(FairudetaIchijiTeburuEntity entity) {
        一次判定内容 = 一次判定内容
                .concat(entity.getHihokenjakanashimei() != null ? entity.getHihokenjakanashimei().value() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getHihokenjakanjishimei() != null ? entity.getHihokenjakanjishimei().value() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getYubenbango() != null ? entity.getYubenbango() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getJusho() != null ? entity.getJusho().value() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getTenwabango() != null ? entity.getTenwabango() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getByoinshisetsutonomeisho() != null ? entity.getByoinshisetsutonomeisho() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getByoinshisetsutonoshozaichi() != null ? entity.getByoinshisetsutonoshozaichi() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkainoninteishinsakaikekka() != null
                ? entity.getZenkainoninteishinsakaikekka() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkainoninteiyukokigenkaishi() != null
                ? new RString(entity.getZenkainoninteiyukokigenkaishi().toString()) : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkainoninteiyukokigenshuryo() != null
                ? new RString(entity.getZenkainoninteiyukokigenshuryo().toString()) : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getShujiiiryokikanbango() != null ? entity.getShujiiiryokikanbango() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getShujiibango() != null ? entity.getShujiibango() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getLkenshoiraibi() != null ? new RString(entity.getLkenshoiraibi().toString()) : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getLkenshonyushubi() != null ? new RString(entity.getLkenshonyushubi().toString()) : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getLkensho_tankikioku() != null ? entity.getLkensho_tankikioku() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getLkensho_ninchinoryoku() != null ? entity.getLkensho_ninchinoryoku() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getLkensho_dentatsunoryoku() != null ? entity.getLkensho_dentatsunoryoku() : RString.EMPTY).concat(分離文字);
    }

    private void edit33to50(FairudetaIchijiTeburuEntity entity) {
        一次判定内容 = 一次判定内容.concat(entity.getLkensho_shokujikoi() != null ? entity.getLkensho_shokujikoi() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getLkensho_ninshishokoreishajiritsudo() != null
                ? entity.getLkensho_ninshishokoreishajiritsudo() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getChosairaibi() != null ? new RString(entity.getChosairaibi().toString()) : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getChosajisshibi() != null ? new RString(entity.getChosajisshibi().toString()) : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getShiteikyotakukaigoshienjigyoshatobango() != null
                ? entity.getShiteikyotakukaigoshienjigyoshatobango() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getLtakukubun() != null ? entity.getLtakukubun() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getNinteichosainbango() != null ? entity.getNinteichosainbango() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getNinteichosainshikakukodo() != null
                ? entity.getNinteichosainshikakukodo().value() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getLchijihanteibi() != null ? new RString(entity.getLchijihanteibi().toString()) : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getLchijihanteikekka() != null ? entity.getLchijihanteikekka() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getLchijihanteikekka_ninshishokasan() != null
                ? entity.getLchijihanteikekka_ninshishokasan() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getYokaigoninteitokijunjikan() != null ? entity.getYokaigoninteitokijunjikan() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getYokaigoninteitokijunjikan_shokuji() != null
                ? entity.getYokaigoninteitokijunjikan_shokuji() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getYokaigoninteitokijunjikan_haisetsu() != null
                ? entity.getYokaigoninteitokijunjikan_haisetsu() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getYokaigoninteitokijunjikan_ldo() != null
                ? entity.getYokaigoninteitokijunjikan_ldo() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getYokaigoninteitokijunjikan_seiketsuhoji() != null
                ? entity.getYokaigoninteitokijunjikan_seiketsuhoji() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getYokaigoninteitokijunjikan_kansetsukea() != null
                ? entity.getYokaigoninteitokijunjikan_kansetsukea() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getYokaigoninteitokijunjikan_bpsdkanren() != null
                ? entity.getYokaigoninteitokijunjikan_bpsdkanren() : RString.EMPTY).concat(分離文字);
    }

    private void edit51to65(FairudetaIchijiTeburuEntity entity) {
        一次判定内容 = 一次判定内容.concat(entity.getYokaigoninteitokijunjikan_kinokunren() != null
                ? entity.getYokaigoninteitokijunjikan_kinokunren() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getYokaigoninteitokijunjikan_lryokanren() != null
                ? entity.getYokaigoninteitokijunjikan_lryokanren() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getYokaigoninteitokijunjikan_ninshishokasan() != null
                ? entity.getYokaigoninteitokijunjikan_ninshishokasan() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getChukanhyokakomokutokuten_dai1gun() != null
                ? entity.getChukanhyokakomokutokuten_dai1gun() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getChukanhyokakomokutokuten_dai2gun() != null
                ? entity.getChukanhyokakomokutokuten_dai2gun() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getChukanhyokakomokutokuten_dai3gun() != null
                ? entity.getChukanhyokakomokutokuten_dai3gun() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getChukanhyokakomokutokuten_dai4gun() != null
                ? entity.getChukanhyokakomokutokuten_dai4gun() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getChukanhyokakomokutokuten_dai5gun() != null
                ? entity.getChukanhyokakomokutokuten_dai5gun() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getLchijihanteikeikoku() != null ? entity.getLchijihanteikeikoku().value() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getJotainoanteisei() != null ? entity.getJotainoanteisei() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getNinshishojiritsudoijonogaizensei() != null
                ? entity.getNinshishojiritsudoijonogaizensei() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getNinchikinokyufukubun() != null ? entity.getNinchikinokyufukubun() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getNinteishinsakaishiryosakuseibi() != null
                ? new RString(entity.getNinteishinsakaishiryosakuseibi().toString()) : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getNinteishinsakaiyoteibi() != null
                ? new RString(entity.getNinteishinsakaiyoteibi().toString()) : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getGogitaibango() != null ? entity.getGogitaibango() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getShinsakaishiryobango() != null ? entity.getShinsakaishiryobango() : RString.EMPTY).concat(分離文字);
    }

    private void edit66to80(FairudetaIchijiTeburuEntity entity) {
        一次判定内容 = 一次判定内容.concat(entity.getShinsakaishiryobango() != null ? entity.getShinsakaishiryobango() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getNijihanteibi() != null ? new RString(entity.getNijihanteibi().toString()) : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getNijihanteikekka() != null ? entity.getNijihanteikekka() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getNinteiyukokigen_kaishi() != null
                ? new RString(entity.getNinteiyukokigen_kaishi().toString()) : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getNinteiyukokigen_shuryo() != null
                ? new RString(entity.getNinteiyukokigen_shuryo().toString()) : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getTokuteishippeikodo() != null ? entity.getTokuteishippeikodo().value() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getYokaigo1nobaainojotaizo() != null ? entity.getYokaigo1nobaainojotaizo() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getGenzainosabisukubunkodo() != null ? entity.getGenzainosabisukubunkodo().value() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getGenzainojokyo() != null ? entity.getGenzainojokyo() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getHomonkaigo_homuherupusabisu() != null ? entity.getHomonkaigo_homuherupusabisu() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getHomonnyuyokukaigo() != null ? entity.getHomonnyuyokukaigo() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getHomonkango() != null ? entity.getHomonkango() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getHomonrihabiriteshon() != null ? entity.getHomonrihabiriteshon() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getKyotakuryoyokanrishido() != null ? entity.getKyotakuryoyokanrishido() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getTsushokaigo_deisabisu() != null ? entity.getTsushokaigo_deisabisu() : RString.EMPTY).concat(分離文字);
    }

    private void edit81to95(FairudetaIchijiTeburuEntity entity) {
        一次判定内容 = 一次判定内容
                .concat(entity.getTsushorihabiriteshon() != null ? entity.getTsushorihabiriteshon() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getTankinyushoseikatsukaigo_shotosutei() != null
                ? entity.getTankinyushoseikatsukaigo_shotosutei() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getTankinyushoryoyokaigo() != null ? entity.getTankinyushoryoyokaigo() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getTokuteishisetsunyukyoshaseikatsukaigo() != null
                ? entity.getTokuteishisetsunyukyoshaseikatsukaigo() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getFukushiyogutaiyo() != null ? entity.getFukushiyogutaiyo() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getTokuteifukushiyoguhanbai() != null ? entity.getTokuteifukushiyoguhanbai() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getJutakukaishukaigokyufu() != null ? entity.getJutakukaishukaigokyufu() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getYakantaiogatahomonkaigo() != null ? entity.getYakantaiogatahomonkaigo() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getNinchishotaiogatasushokaigo() != null ? entity.getNinchishotaiogatasushokaigo() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getShokibotakinogatakyotakukaigo() != null
                ? entity.getShokibotakinogatakyotakukaigo() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getNinshishokaigo_gurupuhomu() != null ? entity.getNinshishokaigo_gurupuhomu() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getChiikimitchakugataseikatsukaigo() != null
                ? entity.getChiikimitchakugataseikatsukaigo() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getMitchakugatarojinkaigo() != null ? entity.getMitchakugatarojinkaigo() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getTeikijunkai_zuijihomonkaigokango() != null
                ? entity.getTeikijunkai_zuijihomonkaigokango() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getFukugogatasabisu() != null ? entity.getFukugogatasabisu() : RString.EMPTY).concat(分離文字);
    }

    private void edit96to110(FairudetaIchijiTeburuEntity entity) {
        一次判定内容 = 一次判定内容.concat(entity.getKaigoyobohomonkaigo_homuherupusabisu() != null
                ? entity.getKaigoyobohomonkaigo_homuherupusabisu() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getKaigoyobohomonnyuyokukaigo() != null ? entity.getKaigoyobohomonnyuyokukaigo() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getKaigoyobohomonkango() != null ? entity.getKaigoyobohomonkango() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getKaigoyobohomonrihabiriteshon() != null
                ? entity.getKaigoyobohomonrihabiriteshon() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getKaigoyobokyotakuryoyokanrishido() != null
                ? entity.getKaigoyobokyotakuryoyokanrishido() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getKaigoyobotsushokaigo_deisabisu() != null
                ? entity.getKaigoyobotsushokaigo_deisabisu() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getKaigoyobotsushorihabiriteshon() != null
                ? entity.getKaigoyobotsushorihabiriteshon() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getKaigoyobotankiseikatsukaigo() != null
                ? entity.getKaigoyobotankiseikatsukaigo() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getKaigoyobotankinyushoryoyokaigo() != null
                ? entity.getKaigoyobotankinyushoryoyokaigo() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getYobotokuteishisetsunyukyoshakaigo() != null
                ? entity.getYobotokuteishisetsunyukyoshakaigo() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getKaigoyobofukushiyogutaiyo() != null
                ? entity.getKaigoyobofukushiyogutaiyo() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getTokuteikaigoyobofukushiyoguhanbai() != null
                ? entity.getTokuteikaigoyobofukushiyoguhanbai() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getJutakukaishu_yobokyufu() != null
                ? entity.getJutakukaishu_yobokyufu() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getKaigoyoboninchishotaiogatatsushokaigo() != null
                ? entity.getKaigoyoboninchishotaiogatatsushokaigo() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getKaigoyoboshokibotakinogatakyotakukaigo() != null
                ? entity.getKaigoyoboshokibotakinogatakyotakukaigo() : RString.EMPTY).concat(分離文字);
    }

    private void edit111to125(FairudetaIchijiTeburuEntity entity) {
        一次判定内容 = 一次判定内容.concat(entity.getYoboninshishokaigo_gurupuhomu() != null
                ? entity.getYoboninshishokaigo_gurupuhomu() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getMahi_hidari_joshi01() != null
                ? entity.getMahi_hidari_joshi01() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getMahi_migi_joshi01() != null
                ? entity.getMahi_migi_joshi01() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getMahi_hidari_kashi01() != null ? entity.getMahi_hidari_kashi01() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getMahi_migi_kashi01() != null ? entity.getMahi_migi_kashi01() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getMahi_sonohoka01() != null ? entity.getMahi_sonohoka01() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getKoshuku_kenkansetsu01() != null ? entity.getKoshuku_kenkansetsu01() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.
                concat(entity.getKoshuku_kokansetsu01() != null ? entity.getKoshuku_kokansetsu01() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getKoshuku_hizakansetsu01() != null ? entity.getKoshuku_hizakansetsu01() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getKoshuku_sonohoka01() != null ? entity.getKoshuku_sonohoka01() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getNegaeri01() != null ? entity.getNegaeri01() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getOkiagari01() != null ? entity.getOkiagari01() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZaihoji01() != null ? entity.getZaihoji01() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getRyoashidenotagu01() != null ? entity.getRyoashidenotagu01() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getHoko01() != null ? entity.getHoko01() : RString.EMPTY).concat(分離文字);
    }

    private void edit126to140(FairudetaIchijiTeburuEntity entity) {
        一次判定内容 = 一次判定内容.concat(entity.getTachiagari01() != null ? entity.getTachiagari01() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getKataashidenotagu01() != null ? entity.getKataashidenotagu01() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getAraimi01() != null ? entity.getAraimi01() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getTsumekiri01() != null ? entity.getTsumekiri01() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getShiryoku01() != null ? entity.getShiryoku01() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getChoryoku01() != null ? entity.getChoryoku01() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getLjo02() != null ? entity.getLjo02() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getLdo02() != null ? entity.getLdo02() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getEnge02() != null ? entity.getEnge02() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getShokujisesshu02() != null ? entity.getShokujisesshu02() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getHainyo02() != null ? entity.getHainyo02() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getHaiben02() != null ? entity.getHaiben02() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getKokuseiketsu02() != null ? entity.getKokuseiketsu02() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getSengan02() != null ? entity.getSengan02() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getSeihatsu02() != null ? entity.getSeihatsu02() : RString.EMPTY).concat(分離文字);
    }

    private void edit141to155(FairudetaIchijiTeburuEntity entity) {
        一次判定内容 = 一次判定内容.concat(entity.getUwaginochakudatsu02() != null ? entity.getUwaginochakudatsu02() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getZubontonochakudatsu02() != null ? entity.getZubontonochakudatsu02() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getGaishutsuhindo02() != null ? entity.getGaishutsuhindo02() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getLshinodentatsu03() != null ? entity.getLshinodentatsu03() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getMainichinonikkaorikai03() != null ? entity.getMainichinonikkaorikai03() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getSeinengappioiu03() != null ? entity.getSeinengappioiu03() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getTankikioku03() != null ? entity.getTankikioku03() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getJibunnonamaeoiu03() != null ? entity.getJibunnonamaeoiu03() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getImanokisetsuorikai03() != null ? entity.getImanokisetsuorikai03() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getHaikai03() != null ? entity.getHaikai03() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getGaishutsushitemodorenai03() != null ? entity.getGaishutsushitemodorenai03() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getHigaiteki04() != null ? entity.getHigaiteki04() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getSakubanashi04() != null ? entity.getSakubanashi04() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getKanjōgafuantei04() != null ? entity.getKanjōgafuantei04() : RString.EMPTY).concat(分離文字);
    }

    private void edit156to170(FairudetaIchijiTeburuEntity entity) {
        一次判定内容 = 一次判定内容.concat(entity.getChuyagyakuten04() != null ? entity.getChuyagyakuten04() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getOnajibanashiosuru04() != null ? entity.getOnajibanashiosuru04() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getOgoewodasu04() != null ? entity.getOgoewodasu04() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getKaigoniteiko04() != null ? entity.getKaigoniteiko04() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getOchitsukinashi04() != null ? entity.getOchitsukinashi04() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getIchiridedetagaru04() != null ? entity.getIchiridedetagaru04() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getShushuheki04() != null ? entity.getShushuheki04() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getMonoyairuiokowasu04() != null ? entity.getMonoyairuiokowasu04() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getHidoimonowasure04() != null ? entity.getHidoimonowasure04() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getHitorigotohitoriwarai04() != null ? entity.getHitorigotohitoriwarai04() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getJibungattenikodosuru04() != null ? entity.getJibungattenikodosuru04() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getWagamatomaranai04() != null ? entity.getWagamatomaranai04() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getKusurinonaifuku05() != null ? entity.getKusurinonaifuku05() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getKinsennokanri05() != null ? entity.getKinsennokanri05() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getNichijonoishikettei05() != null ? entity.getNichijonoishikettei05() : RString.EMPTY).concat(分離文字);
    }

    private void edit171to185(FairudetaIchijiTeburuEntity entity) {
        一次判定内容 = 一次判定内容.concat(entity.getShudanenofutekio05() != null ? entity.getShudanenofutekio05() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getKaimono05() != null ? entity.getKaimono05() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getKantannachori05() != null ? entity.getKantannachori05() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getTentekinokanri() != null ? entity.getTentekinokanri() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getChushinjomyakueiyo() != null ? entity.getChushinjomyakueiyo() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getToseki() != null ? entity.getToseki() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getSutomanoshochi() != null ? entity.getSutomanoshochi() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getSansoryoho() != null ? entity.getSansoryoho() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getResupireta() != null ? entity.getResupireta() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getKikansekkainoshochi() != null ? entity.getKikansekkainoshochi() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getTotsunokango() != null ? entity.getTotsunokango() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getKeikaneiyo() != null ? entity.getKeikaneiyo() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getMonitasokutei() != null ? entity.getMonitasokutei() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getJiyokusounoshochi() != null ? entity.getJiyokusounoshochi() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getKateteru() != null ? entity.getKateteru() : RString.EMPTY).concat(分離文字);
    }

    private void edit186to200(FairudetaIchijiTeburuEntity entity) {
        一次判定内容 = 一次判定内容
                .concat(entity.getShogaikoreishajiritsudo() != null ? entity.getShogaikoreishajiritsudo() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getNinshishokoreishajiritsudo() != null ? entity.getNinshishokoreishajiritsudo() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_mahi_hidari_joshi01() != null
                ? entity.getZenkaikekka_mahi_hidari_joshi01() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_mahi_migi_joshi01() != null
                ? entity.getZenkaikekka_mahi_migi_joshi01() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_mahi_hidari_kashi01() != null
                ? entity.getZenkaikekka_mahi_hidari_kashi01() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_mahi_migi_kashi01() != null
                ? entity.getZenkaikekka_mahi_migi_kashi01() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_mahi_sonohoka01() != null
                ? entity.getZenkaikekka_mahi_sonohoka01() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_koshuku_kenkansetsu01() != null
                ? entity.getZenkaikekka_koshuku_kenkansetsu01() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_koshuku_kokansetsu01() != null
                ? entity.getZenkaikekka_koshuku_kokansetsu01() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_koshuku_hizakansetsu01() != null
                ? entity.getZenkaikekka_koshuku_hizakansetsu01() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_koshuku_sonohoka01() != null
                ? entity.getZenkaikekka_koshuku_sonohoka01() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_negaeri01() != null
                ? entity.getZenkaikekka_negaeri01() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_okiagari01() != null
                ? entity.getZenkaikekka_okiagari01() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_zaihoji01() != null
                ? entity.getZenkaikekka_zaihoji01() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_ryoashidenotagu01() != null
                ? entity.getZenkaikekka_ryoashidenotagu01() : RString.EMPTY).concat(分離文字);
    }

    private void edit201to215(FairudetaIchijiTeburuEntity entity) {
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_hoko01() != null ? entity.getZenkaikekka_hoko01() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getZenkaikekka_tachiagari01() != null ? entity.getZenkaikekka_tachiagari01() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_kataashidenotagu01() != null
                ? entity.getZenkaikekka_kataashidenotagu01() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_araimi01() != null ? entity.getZenkaikekka_araimi01() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getZenkaikekka_tsumekiri01() != null ? entity.getZenkaikekka_tsumekiri01() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getZenkaikekka_shiryoku01() != null ? entity.getZenkaikekka_shiryoku01() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getZenkaikekka_choryoku01() != null ? entity.getZenkaikekka_choryoku01() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_ljo02() != null ? entity.getZenkaikekka_ljo02() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_ldo02() != null ? entity.getZenkaikekka_ldo02() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_enge02() != null ? entity.getZenkaikekka_enge02() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getZenkaikekka_shokujisesshu02() != null ? entity.getZenkaikekka_shokujisesshu02() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_hainyo02() != null ? entity.getZenkaikekka_hainyo02() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_haiben02() != null ? entity.getZenkaikekka_haiben02() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getZenkaikekka_kokuseiketsu02() != null ? entity.getZenkaikekka_kokuseiketsu02() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_sengan02() != null ? entity.getZenkaikekka_sengan02() : RString.EMPTY).concat(分離文字);
    }

    private void edit216to230(FairudetaIchijiTeburuEntity entity) {
        一次判定内容 = 一次判定内容
                .concat(entity.getZenkaikekka_seihatsu02() != null ? entity.getZenkaikekka_seihatsu02() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_uwaginochakudatsu02() != null
                ? entity.getZenkaikekka_uwaginochakudatsu02() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_zubontonochakudatsu02() != null
                ? entity.getZenkaikekka_zubontonochakudatsu02() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_gaishutsuhindo02() != null
                ? entity.getZenkaikekka_gaishutsuhindo02() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_lshinodentatsu03() != null
                ? entity.getZenkaikekka_lshinodentatsu03() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_mainichinonikkaorikai03() != null
                ? entity.getZenkaikekka_mainichinonikkaorikai03() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_seinengappioiu03() != null
                ? entity.getZenkaikekka_seinengappioiu03() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_tankikioku03() != null
                ? entity.getZenkaikekka_tankikioku03() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_jibunnonamaeoiu03() != null
                ? entity.getZenkaikekka_jibunnonamaeoiu03() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_imanokisetsuorikai03() != null
                ? entity.getZenkaikekka_imanokisetsuorikai03() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_bashonorikai03() != null
                ? entity.getZenkaikekka_bashonorikai03() : RString.EMPTY).concat(分離文字);
        一次判定内容.concat(entity.getZenkaikekka_haikai03() != null
                ? entity.getZenkaikekka_haikai03() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_gaishutsushitemodorenai03() != null
                ? entity.getZenkaikekka_gaishutsushitemodorenai03() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_higaiteki04() != null
                ? entity.getZenkaikekka_higaiteki04() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_sakubanashi04() != null
                ? entity.getZenkaikekka_sakubanashi04() : RString.EMPTY).concat(分離文字);
    }

    private void edit231to245(FairudetaIchijiTeburuEntity entity) {
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_kanjōgafuantei04() != null
                ? entity.getZenkaikekka_kanjōgafuantei04() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_chuyagyakuten04() != null
                ? entity.getZenkaikekka_chuyagyakuten04() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_onajibanashiosuru04() != null
                ? entity.getZenkaikekka_onajibanashiosuru04() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_ogoewodasu04() != null
                ? entity.getZenkaikekka_ogoewodasu04() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_kaigoniteiko04() != null
                ? entity.getZenkaikekka_kaigoniteiko04() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_ochitsukinashi04() != null
                ? entity.getZenkaikekka_ochitsukinashi04() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_ichiridedetagaru04() != null
                ? entity.getZenkaikekka_ichiridedetagaru04() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_shushuheki04() != null
                ? entity.getZenkaikekka_shushuheki04() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_monoyairuiokowasu04() != null
                ? entity.getZenkaikekka_monoyairuiokowasu04() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_hidoimonowasure04() != null
                ? entity.getZenkaikekka_hidoimonowasure04() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_hitorigotohitoriwarai04() != null
                ? entity.getZenkaikekka_hitorigotohitoriwarai04() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_jibungattenikodosuru04() != null
                ? entity.getZenkaikekka_jibungattenikodosuru04() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_wagamatomaranai04() != null
                ? entity.getZenkaikekka_wagamatomaranai04() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_Kusurinonaifuku05() != null
                ? entity.getZenkaikekka_Kusurinonaifuku05() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_kinsennokanri05() != null
                ? entity.getZenkaikekka_kinsennokanri05() : RString.EMPTY).concat(分離文字);
    }

    private void edit246to260(FairudetaIchijiTeburuEntity entity) {
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_nichijonoishikettei05() != null
                ? entity.getZenkaikekka_nichijonoishikettei05() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_shudanenofutekio05() != null
                ? entity.getZenkaikekka_shudanenofutekio05() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getZenkaikekka_kaimono05() != null ? entity.getZenkaikekka_kaimono05() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getZenkaikekka_kantannachori05() != null ? entity.getZenkaikekka_kantannachori05() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getZenkaikekka_tentekinokanri() != null ? entity.getZenkaikekka_tentekinokanri() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_chushinjomyakueiyo() != null
                ? entity.getZenkaikekka_chushinjomyakueiyo() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getZenkaikekka_sutomanoshochi() != null ? entity.getZenkaikekka_sutomanoshochi() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getZenkaikekka_sansoryoho() != null ? entity.getZenkaikekka_sansoryoho() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getZenkaikekka_resupireta() != null ? entity.getZenkaikekka_resupireta() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_kikansekkainoshochitotsunokango() != null
                ? entity.getZenkaikekka_kikansekkainoshochitotsunokango() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getZenkaikekka_totsunokango() != null ? entity.getZenkaikekka_totsunokango() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getZenkaikekka_keikaneiyo() != null ? entity.getZenkaikekka_keikaneiyo() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getZenkaikekka_monitasokutei() != null ? entity.getZenkaikekka_monitasokutei() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getZenkaikekka_jiyokusounoshochi() != null ? entity.getZenkaikekka_jiyokusounoshochi() : RString.EMPTY).concat(分離文字);
    }

    private void edit261to275(FairudetaIchijiTeburuEntity entity) {
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_kateteru() != null ? entity.getZenkaikekka_kateteru() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_shogaikoreishajiritsudo() != null
                ? entity.getZenkaikekka_shogaikoreishajiritsudo() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_ninshishokoreishajiritsudo() != null
                ? entity.getZenkaikekka_ninshishokoreishajiritsudo() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_ichijihanteikekka() != null
                ? entity.getZenkaikekka_ichijihanteikekka() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_ichijihanteikekka_ninshishokasan() != null
                ? entity.getZenkaikekka_ichijihanteikekka_ninshishokasan() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getZenkaikekka_yokaigojikan() != null ? entity.getZenkaikekka_yokaigojikan() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_yokaigojikan_shokuji() != null
                ? entity.getZenkaikekka_yokaigojikan_shokuji() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_yokaigojikan_haisetsu() != null
                ? entity.getZenkaikekka_yokaigojikan_haisetsu() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_yokaigojikan_ldo() != null
                ? entity.getZenkaikekka_yokaigojikan_ldo() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_yokaigojikan_seiketsuhoji() != null
                ? entity.getZenkaikekka_yokaigojikan_seiketsuhoji() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_yokaigojikan_kanren() != null
                ? entity.getZenkaikekka_yokaigojikan_kanren() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_yokaigojikan_kinokunren() != null
                ? entity.getZenkaikekka_yokaigojikan_kinokunren() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_yokaigojikan_iryokanren() != null
                ? entity.getZenkaikekka_yokaigojikan_iryokanren() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_yokaigojikan_ninshishokasan() != null
                ? entity.getZenkaikekka_yokaigojikan_ninshishokasan() : RString.EMPTY).concat(分離文字);
    }

    private void edit276to290(FairudetaIchijiTeburuEntity entity) {
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_chukanhyokakomokutokutendai1_gun() != null
                ? entity.getZenkaikekka_chukanhyokakomokutokutendai1_gun() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_chukanhyokakomokutokutendai2_gun() != null
                ? entity.getZenkaikekka_chukanhyokakomokutokutendai2_gun() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_chukanhyokakomokutokutendai3_gun() != null
                ? entity.getZenkaikekka_chukanhyokakomokutokutendai3_gun() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_chukanhyokakomokutokutendai4_gun() != null
                ? entity.getZenkaikekka_chukanhyokakomokutokutendai4_gun() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_chukanhyokakomokutokutendai5_gun() != null
                ? entity.getZenkaikekka_chukanhyokakomokutokutendai5_gun() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_kodo() != null ? entity.getZenkaikekka_kodo().value() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容
                .concat(entity.getZenkaikekka_jotainoanteisei() != null ? entity.getZenkaikekka_jotainoanteisei() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_ninshishojiritsudo() != null
                ? entity.getZenkaikekka_ninshishojiritsudo() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_ninchikinokyufukubun() != null
                ? entity.getZenkaikekka_ninchikinokyufukubun() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_shinseibi() != null
                ? new RString(entity.getZenkaikekka_shinseibi().toString()) : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_nijihanteibi() != null
                ? new RString(entity.getZenkaikekka_nijihanteibi().toString()) : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_genzainosabisukubunkodo() != null
                ? new RString(entity.getZenkaikekka_genzainosabisukubunkodo().toString()) : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_genzainojokyo() != null
                ? new RString(entity.getZenkaikekka_genzainojokyo().toString()) : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_homonkaigo_homuherupusabisu() != null
                ? new RString(entity.getZenkaikekka_homonkaigo_homuherupusabisu().toString()) : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_homonnyuyokukaigo() != null
                ? new RString(entity.getZenkaikekka_homonnyuyokukaigo().toString()) : RString.EMPTY).concat(分離文字);
    }

    private void edit291to305(FairudetaIchijiTeburuEntity entity) {
        一次判定内容 = 一次判定内容
                .concat(entity.getZenkaikekka_homonkango() != null ? entity.getZenkaikekka_homonkango() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_homonrihabiriteshon() != null
                ? new RString(entity.getZenkaikekka_homonrihabiriteshon().toString()) : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_kyotakuryoyokanrishido() != null
                ? new RString(entity.getZenkaikekka_kyotakuryoyokanrishido().toString()) : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_tsushokaigo_deisabisu() != null
                ? new RString(entity.getZenkaikekka_tsushokaigo_deisabisu().toString()) : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_tsushorihabiriteshon() != null
                ? new RString(entity.getZenkaikekka_tsushorihabiriteshon().toString()) : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_tankinyushoseikatsukaigo_shotosutei() != null
                ? new RString(entity.getZenkaikekka_tankinyushoseikatsukaigo_shotosutei().toString()) : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_tankinyushoryoyokaigo() != null
                ? new RString(entity.getZenkaikekka_tankinyushoryoyokaigo().toString()) : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_tokuteishisetsunyukyoshaseikatsukaigo() != null
                ? new RString(entity.getZenkaikekka_tokuteishisetsunyukyoshaseikatsukaigo().toString()) : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_fukushiyogutaiyo() != null
                ? new RString(entity.getZenkaikekka_fukushiyogutaiyo().toString()) : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_tokuteifukushiyoguhanbai() != null
                ? new RString(entity.getZenkaikekka_tokuteifukushiyoguhanbai().toString()) : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_jutakukaishukaigokyufu() != null
                ? new RString(entity.getZenkaikekka_jutakukaishukaigokyufu().toString()) : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_yakantaiogatahomonkaigo() != null
                ? new RString(entity.getZenkaikekka_yakantaiogatahomonkaigo().toString()) : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_ninchishotaiogatasushokaigo() != null
                ? new RString(entity.getZenkaikekka_ninchishotaiogatasushokaigo().toString()) : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_shokibotakinogatakyotakukaigo() != null
                ? new RString(entity.getZenkaikekka_shokibotakinogatakyotakukaigo().toString()) : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_ninshishokaigo_gurupuhomu() != null
                ? new RString(entity.getZenkaikekka_ninshishokaigo_gurupuhomu().toString()) : RString.EMPTY).concat(分離文字);
    }

    private void edit306to320(FairudetaIchijiTeburuEntity entity) {
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_chiikimitchakugataseikatsukaigo() != null
                ? entity.getZenkaikekka_chiikimitchakugataseikatsukaigo() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_mitchakugatarojinkaigo() != null
                ? entity.getZenkaikekka_mitchakugatarojinkaigo() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_teikijunkai_zuijihomonkaigokango() != null
                ? entity.getZenkaikekka_teikijunkai_zuijihomonkaigokango() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_fukugogatasabisu() != null
                ? entity.getZenkaikekka_fukugogatasabisu() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_kaigoyobohomonkaigo_homuherupusabisu() != null
                ? entity.getZenkaikekka_kaigoyobohomonkaigo_homuherupusabisu() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_kaigoyobohomonnyuyokukaigo() != null
                ? entity.getZenkaikekka_kaigoyobohomonnyuyokukaigo() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_kaigoyobohomonkango() != null
                ? entity.getZenkaikekka_kaigoyobohomonkango() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_kaigoyobohomonrihabiriteshon() != null
                ? entity.getZenkaikekka_kaigoyobohomonrihabiriteshon() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_kaigoyobokyotakuryoyokanrishido() != null
                ? entity.getZenkaikekka_kaigoyobokyotakuryoyokanrishido() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_kaigoyobotsushokaigo_deisabisu() != null
                ? entity.getZenkaikekka_kaigoyobotsushokaigo_deisabisu() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_kaigoyobotsushorihabiriteshon() != null
                ? entity.getZenkaikekka_kaigoyobotsushorihabiriteshon() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_kaigoyobotankiseikatsukaigo() != null
                ? entity.getZenkaikekka_kaigoyobotankiseikatsukaigo() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_kaigoyobotankinyushoryoyokaigo() != null
                ? entity.getZenkaikekka_kaigoyobotankinyushoryoyokaigo() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_yobotokuteishisetsunyukyoshakaigo() != null
                ? entity.getZenkaikekka_yobotokuteishisetsunyukyoshakaigo() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_kaigoyobofukushiyogutaiyo() != null
                ? entity.getZenkaikekka_kaigoyobofukushiyogutaiyo() : RString.EMPTY).concat(分離文字);

    }

    private void edit321to328(FairudetaIchijiTeburuEntity entity) {
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_tokuteikaigoyobofukushiyoguhanbai() != null
                ? entity.getZenkaikekka_tokuteikaigoyobofukushiyoguhanbai() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_jutakukaishu_yobokyufu() != null
                ? entity.getZenkaikekka_jutakukaishu_yobokyufu() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_kaigoyoboninchishotaiogatatsushokaigo() != null
                ? entity.getZenkaikekka_kaigoyoboninchishotaiogatatsushokaigo() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_kaigoyoboshokibotakinogatakyotakukaigo() != null
                ? entity.getZenkaikekka_kaigoyoboshokibotakinogatakyotakukaigo() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaikekka_yoboninshishokaigo_gurupuhomu() != null
                ? entity.getZenkaikekka_yoboninshishokaigo_gurupuhomu() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getZenkaishikibetsukodo() != null
                ? entity.getZenkaishikibetsukodo().value() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getNinteishinsakaiikento() != null
                ? entity.getNinteishinsakaiikento() : RString.EMPTY).concat(分離文字);
        一次判定内容 = 一次判定内容.concat(entity.getKomentoto() != null
                ? entity.getKomentoto() : RString.EMPTY);
    }
}
