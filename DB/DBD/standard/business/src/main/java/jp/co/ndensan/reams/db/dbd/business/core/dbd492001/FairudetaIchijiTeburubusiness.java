/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.dbd492001;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001.ichijiteburu.NichijiShinchokuIchijiTeburuEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * DB出力(日次進捗一時デーブル)のデータの編集ビジネスクラスです。
 *
 * @reamsid_L DBD-1510-030 x_xuliang
 */
public class FairudetaIchijiTeburubusiness {

    private int index = 0;

    /**
     * 日次進捗一時リストをセット
     *
     * @param list List<RString>
     * @param entity NichijiShinchokuIchijiTeburuEntity
     */
    public void editFairudeta(List<RString> list, NichijiShinchokuIchijiTeburuEntity entity) {
        edit1to8(list, entity);
        edit9to18(list, entity);
        edit19to30(list, entity);
        edit31to45(list, entity);
        edit46to60(list, entity);
        edit61to73(list, entity);
        edit74to90(list, entity);
        edit91to95(list, entity);
        edit96to110(list, entity);
        edit111to125(list, entity);
        edit126to140(list, entity);
        edit141to155(list, entity);
        edit156to170(list, entity);
        edit171to185(list, entity);
        edit186to200(list, entity);
        edit201to215(list, entity);
        edit216to230(list, entity);
        edit231to245(list, entity);
        edit246to260(list, entity);
        edit261to275(list, entity);
        edit276to290(list, entity);
        edit291to305(list, entity);
        edit306to320(list, entity);
        edit321to328(list, entity);
    }

    private void edit1to8(List<RString> list, NichijiShinchokuIchijiTeburuEntity entity) {
        if (!list.get(index++).isNull()) {
            entity.setKoban(list.get(index - 1));
        } else {
            entity.setKoban(RString.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setSutetasu(list.get(index - 1));
        } else {
            entity.setSutetasu(RString.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setShikibetsukodo(list.get(index - 1));
        } else {
            entity.setShikibetsukodo(RString.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setHokenshabango(list.get(index - 1));
        } else {
            entity.setHokenshabango(RString.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setHihokenjabango(list.get(index - 1));
        } else {
            entity.setHihokenjabango(RString.EMPTY);
        }
        if (!list.get(index++).isNull() && !list.get(index - 1).isEmpty()) {
            entity.setNinteishinseibi(new FlexibleDate(list.get(index - 1)));
        } else {
            entity.setNinteishinseibi(FlexibleDate.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setEdaban(list.get(index - 1));
        } else {
            entity.setEdaban(RString.EMPTY);
        }
        if (!list.get(index++).isNull() && !list.get(index - 1).isEmpty()) {
            entity.setShinseikubunhorei(new Code(list.get(index - 1)));
        } else {
            entity.setShinseikubunhorei(Code.EMPTY);
        }

    }

    private void edit9to18(List<RString> list, NichijiShinchokuIchijiTeburuEntity entity) {
        if (!list.get(index++).isNull() && !list.get(index - 1).isEmpty()) {
            entity.setShinseikubunshinseiji(new Code(list.get(index - 1)));
        } else {
            entity.setShinseikubunshinseiji(Code.EMPTY);
        }
        if (!list.get(index++).isNull() && !list.get(index - 1).isEmpty()) {
            entity.setTorisakubunkodo(new Code(list.get(index - 1)));
        } else {
            entity.setTorisakubunkodo(Code.EMPTY);
        }
        if (!list.get(index++).isNull() && !list.get(index - 1).isEmpty()) {
            entity.setHihokenjakubun(new Code(list.get(index - 1)));
        } else {
            entity.setHihokenjakubun(Code.EMPTY);
        }
        if (!list.get(index++).isNull() && !list.get(index - 1).isEmpty()) {
            entity.setShinseidaikokubun(new Code(list.get(index - 1)));
        } else {
            entity.setShinseidaikokubun(Code.EMPTY);
        }
        if (!list.get(index++).isNull() && !list.get(index - 1).isEmpty()) {
            entity.setSeinengappi(new FlexibleDate(list.get(index - 1)));
        } else {
            entity.setSeinengappi(FlexibleDate.EMPTY);
        }
        if (!list.get(index++).isNull() && !list.get(index - 1).isEmpty()) {
            entity.setNenrei(Integer.parseInt(list.get(index - 1).toString()));
        }
        if (!list.get(index++).isNull() && !list.get(index - 1).isEmpty()) {
            entity.setSeibetsukodo(new Code(list.get(index - 1)));
        } else {
            entity.setSeibetsukodo(Code.EMPTY);
        }
        if (!list.get(index++).isNull() && !list.get(index - 1).isEmpty()) {
            entity.setHihokenjakanashimei(new AtenaKanaMeisho(list.get(index - 1)));
        } else {
            entity.setHihokenjakanashimei(AtenaKanaMeisho.EMPTY);
        }
        if (!list.get(index++).isNull() && !list.get(index - 1).isEmpty()) {
            entity.setHihokenjakanjishimei(new AtenaMeisho(list.get(index - 1)));
        } else {
            entity.setHihokenjakanjishimei(AtenaMeisho.EMPTY);
        }
    }

    private void edit19to30(List<RString> list, NichijiShinchokuIchijiTeburuEntity entity) {
        if (!list.get(index++).isNull()) {
            entity.setYubenbango(list.get(index - 1));
        } else {
            entity.setYubenbango(RString.EMPTY);
        }
        if (!list.get(index++).isNull() && !list.get(index - 1).isEmpty()) {
            entity.setJusho(new AtenaJusho(list.get(index - 1)));
        } else {
            entity.setJusho(AtenaJusho.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setTenwabango(list.get(index - 1));
        } else {
            entity.setTenwabango(RString.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setByoinshisetsutonomeisho(list.get(index - 1));
        } else {
            entity.setByoinshisetsutonomeisho(RString.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setByoinshisetsutonoshozaichi(list.get(index - 1));
        } else {
            entity.setByoinshisetsutonoshozaichi(RString.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setZenkainoninteishinsakaikekka(list.get(index - 1));
        } else {
            entity.setZenkainoninteishinsakaikekka(RString.EMPTY);
        }
        if (!list.get(index++).isNull() && !list.get(index - 1).isEmpty()) {
            entity.setZenkainoninteiyukokigenkaishi(new FlexibleDate(list.get(index - 1)));
        } else {
            entity.setZenkainoninteiyukokigenkaishi(FlexibleDate.EMPTY);
        }
        if (!list.get(index++).isNull() && !list.get(index - 1).isEmpty()) {
            entity.setZenkainoninteiyukokigenshuryo(new FlexibleDate(list.get(index - 1)));
        } else {
            entity.setZenkainoninteiyukokigenshuryo(FlexibleDate.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setShujiiiryokikanbango(list.get(index - 1));
        } else {
            entity.setShujiiiryokikanbango(RString.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setShujiibango(list.get(index - 1));
        } else {
            entity.setShujiibango(RString.EMPTY);
        }
        if (!list.get(index++).isNull() && !list.get(index - 1).isEmpty()) {
            entity.setLkenshoiraibi(new FlexibleDate(list.get(index - 1)));
        } else {
            entity.setLkenshoiraibi(FlexibleDate.EMPTY);
        }
        if (!list.get(index++).isNull() && !list.get(index - 1).isEmpty()) {
            entity.setLkenshonyushubi(new FlexibleDate(list.get(index - 1)));
        } else {
            entity.setLkenshonyushubi(FlexibleDate.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setLkensho_tankikioku(list.get(index - 1));
        } else {
            entity.setLkensho_tankikioku(RString.EMPTY);
        }
    }

    private void edit31to45(List<RString> list, NichijiShinchokuIchijiTeburuEntity entity) {
        if (!list.get(index++).isNull()) {
            entity.setLkensho_ninchinoryoku(list.get(index - 1));
        } else {
            entity.setLkensho_ninchinoryoku(RString.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setLkensho_dentatsunoryoku(list.get(index - 1));
        } else {
            entity.setLkensho_dentatsunoryoku(RString.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setLkensho_shokujikoi(list.get(index - 1));
        } else {
            entity.setLkensho_shokujikoi(RString.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setLkensho_ninshishokoreishajiritsudo(list.get(index - 1));
        } else {
            entity.setLkensho_ninshishokoreishajiritsudo(RString.EMPTY);
        }
        if (!list.get(index++).isNull() && !list.get(index - 1).isEmpty()) {
            entity.setChosairaibi(new FlexibleDate(list.get(index - 1)));
        } else {
            entity.setChosairaibi(FlexibleDate.EMPTY);
        }
        if (!list.get(index++).isNull() && !list.get(index - 1).isEmpty()) {
            entity.setChosajisshibi(new FlexibleDate(list.get(index - 1)));
        } else {
            entity.setChosajisshibi(FlexibleDate.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setShiteikyotakukaigoshienjigyoshatobango(list.get(index - 1));
        } else {
            entity.setShiteikyotakukaigoshienjigyoshatobango(RString.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setLtakukubun(list.get(index - 1));
        } else {
            entity.setLtakukubun(RString.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setNinteichosainbango(list.get(index - 1));
        } else {
            entity.setNinteichosainbango(RString.EMPTY);
        }
        if (!list.get(index++).isNull() && !list.get(index - 1).isEmpty()) {
            entity.setNinteichosainshikakukodo(new Code(list.get(index - 1)));
        } else {
            entity.setNinteichosainshikakukodo(Code.EMPTY);
        }
        if (!list.get(index++).isNull() && !list.get(index - 1).isEmpty()) {
            entity.setLchijihanteibi(new FlexibleDate(list.get(index - 1)));
        } else {
            entity.setLchijihanteibi(FlexibleDate.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setLchijihanteikekka(list.get(index - 1));
        } else {
            entity.setLchijihanteikekka(RString.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setLchijihanteikekka_ninshishokasan(list.get(index - 1));
        } else {
            entity.setLchijihanteikekka_ninshishokasan(RString.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setYokaigoninteitokijunjikan(list.get(index - 1));
        } else {
            entity.setYokaigoninteitokijunjikan(RString.EMPTY);
        }
    }

    private void edit46to60(List<RString> list, NichijiShinchokuIchijiTeburuEntity entity) {
        if (!list.get(index++).isNull()) {
            entity.setYokaigoninteitokijunjikan_shokuji(list.get(index - 1));
        } else {
            entity.setYokaigoninteitokijunjikan_shokuji(RString.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setYokaigoninteitokijunjikan_haisetsu(list.get(index - 1));
        } else {
            entity.setYokaigoninteitokijunjikan_haisetsu(RString.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setYokaigoninteitokijunjikan_ldo(list.get(index - 1));
        } else {
            entity.setYokaigoninteitokijunjikan_ldo(RString.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setYokaigoninteitokijunjikan_seiketsuhoji(list.get(index - 1));
        } else {
            entity.setYokaigoninteitokijunjikan_seiketsuhoji(RString.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setYokaigoninteitokijunjikan_kansetsukea(list.get(index - 1));
        } else {
            entity.setYokaigoninteitokijunjikan_kansetsukea(RString.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setYokaigoninteitokijunjikan_bpsdkanren(list.get(index - 1));
        } else {
            entity.setYokaigoninteitokijunjikan_bpsdkanren(RString.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setYokaigoninteitokijunjikan_kinokunren(list.get(index - 1));
        } else {
            entity.setYokaigoninteitokijunjikan_kinokunren(RString.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setYokaigoninteitokijunjikan_lryokanren(list.get(index - 1));
        } else {
            entity.setYokaigoninteitokijunjikan_lryokanren(RString.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setYokaigoninteitokijunjikan_ninshishokasan(list.get(index - 1));
        } else {
            entity.setYokaigoninteitokijunjikan_ninshishokasan(RString.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setChukanhyokakomokutokuten_dai1gun(list.get(index - 1));
        } else {
            entity.setChukanhyokakomokutokuten_dai1gun(RString.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setChukanhyokakomokutokuten_dai2gun(list.get(index - 1));
        } else {
            entity.setChukanhyokakomokutokuten_dai2gun(RString.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setChukanhyokakomokutokuten_dai3gun(list.get(index - 1));
        } else {
            entity.setChukanhyokakomokutokuten_dai3gun(RString.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setChukanhyokakomokutokuten_dai4gun(list.get(index - 1));
        } else {
            entity.setChukanhyokakomokutokuten_dai4gun(RString.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setChukanhyokakomokutokuten_dai5gun(list.get(index - 1));
        } else {
            entity.setChukanhyokakomokutokuten_dai5gun(RString.EMPTY);
        }
        if (!list.get(index++).isNull() && !list.get(index - 1).isEmpty()) {
            entity.setLchijihanteikeikoku(new Code(list.get(index - 1)));
        } else {
            entity.setLchijihanteikeikoku(Code.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setJotainoanteisei(list.get(index - 1));
        } else {
            entity.setJotainoanteisei(RString.EMPTY);
        }
    }

    private void edit61to73(List<RString> list, NichijiShinchokuIchijiTeburuEntity entity) {
        if (!list.get(index++).isNull()) {
            entity.setNinshishojiritsudoijonogaizensei(list.get(index - 1));
        } else {
            entity.setNinshishojiritsudoijonogaizensei(RString.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setNinchikinokyufukubun(list.get(index - 1));
        } else {
            entity.setNinchikinokyufukubun(RString.EMPTY);
        }
        if (!list.get(index++).isNull() && !list.get(index - 1).isEmpty()) {
            entity.setNinteishinsakaishiryosakuseibi(new FlexibleDate(list.get(index - 1)));
        } else {
            entity.setNinteishinsakaishiryosakuseibi(FlexibleDate.EMPTY);
        }
        if (!list.get(index++).isNull() && !list.get(index - 1).isEmpty()) {
            entity.setNinteishinsakaiyoteibi(new FlexibleDate(list.get(index - 1)));
        } else {
            entity.setNinteishinsakaiyoteibi(FlexibleDate.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setGogitaibango(list.get(index - 1));
        } else {
            entity.setGogitaibango(RString.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setShinsakaishiryobango(list.get(index - 1));
        } else {
            entity.setShinsakaishiryobango(RString.EMPTY);
        }
        if (!list.get(index++).isNull() && !list.get(index - 1).isEmpty()) {
            entity.setNijihanteibi(new FlexibleDate(list.get(index - 1)));
        } else {
            entity.setNijihanteibi(FlexibleDate.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setNijihanteikekka(list.get(index - 1));
        } else {
            entity.setNijihanteikekka(RString.EMPTY);
        }
        if (!list.get(index++).isNull() && !list.get(index - 1).isEmpty()) {
            entity.setNinteiyukokigen_kaishi(new FlexibleDate(list.get(index - 1)));
        } else {
            entity.setNinteiyukokigen_kaishi(FlexibleDate.EMPTY);
        }
        if (!list.get(index++).isNull() && !list.get(index - 1).isEmpty()) {
            entity.setNinteiyukokigen_shuryo(new FlexibleDate(list.get(index - 1)));
        } else {
            entity.setNinteiyukokigen_shuryo(FlexibleDate.EMPTY);
        }
        if (!list.get(index++).isNull() && !list.get(index - 1).isEmpty()) {
            entity.setTokuteishippeikodo(new Code(list.get(index - 1)));
        } else {
            entity.setTokuteishippeikodo(Code.EMPTY);
        }

    }

    private void edit74to90(List<RString> list, NichijiShinchokuIchijiTeburuEntity entity) {
        if (!list.get(index++).isNull()) {
            entity.setYokaigo1nobaainojotaizo(list.get(index - 1));
        } else {
            entity.setYokaigo1nobaainojotaizo(RString.EMPTY);
        }
        if (!list.get(index++).isNull() && !list.get(index - 1).isEmpty()) {
            entity.setGenzainosabisukubunkodo(new Code(list.get(index - 1)));
        } else {
            entity.setGenzainosabisukubunkodo(Code.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setGenzainojokyo(list.get(index - 1));
        } else {
            entity.setGenzainojokyo(RString.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setHomonkaigo_homuherupusabisu(list.get(index - 1));
        } else {
            entity.setHomonkaigo_homuherupusabisu(RString.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setHomonnyuyokukaigo(list.get(index - 1));
        } else {
            entity.setHomonnyuyokukaigo(RString.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setHomonkango(list.get(index - 1));
        } else {
            entity.setHomonkango(RString.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setHomonrihabiriteshon(list.get(index - 1));
        } else {
            entity.setHomonrihabiriteshon(RString.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setKyotakuryoyokanrishido(list.get(index - 1));
        } else {
            entity.setKyotakuryoyokanrishido(RString.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setTsushokaigo_deisabisu(list.get(index - 1));
        } else {
            entity.setTsushokaigo_deisabisu(RString.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setTsushorihabiriteshon(list.get(index - 1));
        } else {
            entity.setTsushorihabiriteshon(RString.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setTankinyushoseikatsukaigo_shotosutei(list.get(index - 1));
        } else {
            entity.setTankinyushoseikatsukaigo_shotosutei(RString.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setTankinyushoryoyokaigo(list.get(index - 1));
        } else {
            entity.setTankinyushoryoyokaigo(RString.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setTokuteishisetsunyukyoshaseikatsukaigo(list.get(index - 1));
        } else {
            entity.setTokuteishisetsunyukyoshaseikatsukaigo(RString.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setFukushiyogutaiyo(list.get(index - 1));
        } else {
            entity.setFukushiyogutaiyo(RString.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setTokuteifukushiyoguhanbai(list.get(index - 1));
        } else {
            entity.setTokuteifukushiyoguhanbai(RString.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setJutakukaishukaigokyufu(list.get(index - 1));
        } else {
            entity.setJutakukaishukaigokyufu(RString.EMPTY);
        }

    }

    private void edit91to95(List<RString> list, NichijiShinchokuIchijiTeburuEntity entity) {
        if (!list.get(index++).isNull()) {
            entity.setYakantaiogatahomonkaigo(list.get(index - 1));
        } else {
            entity.setYakantaiogatahomonkaigo(RString.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setNinchishotaiogatasushokaigo(list.get(index - 1));
        } else {
            entity.setNinchishotaiogatasushokaigo(RString.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setShokibotakinogatakyotakukaigo(list.get(index - 1));
        } else {
            entity.setShokibotakinogatakyotakukaigo(RString.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setNinshishokaigo_gurupuhomu(list.get(index - 1));
        } else {
            entity.setNinshishokaigo_gurupuhomu(RString.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setChiikimitchakugataseikatsukaigo(list.get(index - 1));
        } else {
            entity.setChiikimitchakugataseikatsukaigo(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setMitchakugatarojinkaigo(list.get(index - 1));
        } else {
            entity.setMitchakugatarojinkaigo(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setTeikijunkai_zuijihomonkaigokango(list.get(index - 1));
        } else {
            entity.setTeikijunkai_zuijihomonkaigokango(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setFukugogatasabisu(list.get(index - 1));
        } else {
            entity.setFukugogatasabisu(RString.EMPTY);
        }
    }

    private void edit96to110(List<RString> list, NichijiShinchokuIchijiTeburuEntity entity) {
        if (!list.get(index++).isNull()) {
            entity.setKaigoyobohomonkaigo_homuherupusabisu(list.get(index - 1));
        } else {
            entity.setKaigoyobohomonkaigo_homuherupusabisu(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setKaigoyobohomonnyuyokukaigo(list.get(index - 1));
        } else {
            entity.setKaigoyobohomonnyuyokukaigo(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setKaigoyobohomonkango(list.get(index - 1));
        } else {
            entity.setKaigoyobohomonkango(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setKaigoyobohomonrihabiriteshon(list.get(index - 1));
        } else {
            entity.setKaigoyobohomonrihabiriteshon(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setKaigoyobokyotakuryoyokanrishido(list.get(index - 1));
        } else {
            entity.setKaigoyobokyotakuryoyokanrishido(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setKaigoyobotsushokaigo_deisabisu(list.get(index - 1));
        } else {
            entity.setKaigoyobotsushokaigo_deisabisu(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setKaigoyobotsushorihabiriteshon(list.get(index - 1));
        } else {
            entity.setKaigoyobotsushorihabiriteshon(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setKaigoyobotankiseikatsukaigo(list.get(index - 1));
        } else {
            entity.setKaigoyobotankiseikatsukaigo(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setKaigoyobotankinyushoryoyokaigo(list.get(index - 1));
        } else {
            entity.setKaigoyobotankinyushoryoyokaigo(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setYobotokuteishisetsunyukyoshakaigo(list.get(index - 1));
        } else {
            entity.setYobotokuteishisetsunyukyoshakaigo(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setKaigoyobofukushiyogutaiyo(list.get(index - 1));
        } else {
            entity.setKaigoyobofukushiyogutaiyo(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setTokuteikaigoyobofukushiyoguhanbai(list.get(index - 1));
        } else {
            entity.setTokuteikaigoyobofukushiyoguhanbai(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setJutakukaishu_yobokyufu(list.get(index - 1));
        } else {
            entity.setJutakukaishu_yobokyufu(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setKaigoyoboninchishotaiogatatsushokaigo(list.get(index - 1));
        } else {
            entity.setKaigoyoboninchishotaiogatatsushokaigo(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setKaigoyoboshokibotakinogatakyotakukaigo(list.get(index - 1));
        } else {
            entity.setKaigoyoboshokibotakinogatakyotakukaigo(RString.EMPTY);
        }
    }

    private void edit111to125(List<RString> list, NichijiShinchokuIchijiTeburuEntity entity) {
        if (!list.get(index++).isNull()) {
            entity.setYoboninshishokaigo_gurupuhomu(list.get(index - 1));
        } else {
            entity.setYoboninshishokaigo_gurupuhomu(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setMahi_hidari_joshi01(list.get(index - 1));
        } else {
            entity.setMahi_hidari_joshi01(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setMahi_migi_joshi01(list.get(index - 1));
        } else {
            entity.setMahi_migi_joshi01(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setMahi_hidari_kashi01(list.get(index - 1));
        } else {
            entity.setMahi_hidari_kashi01(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setMahi_migi_kashi01(list.get(index - 1));
        } else {
            entity.setMahi_migi_kashi01(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setMahi_sonohoka01(list.get(index - 1));
        } else {
            entity.setMahi_sonohoka01(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setKoshuku_kenkansetsu01(list.get(index - 1));
        } else {
            entity.setKoshuku_kenkansetsu01(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setKoshuku_kokansetsu01(list.get(index - 1));
        } else {
            entity.setKoshuku_kokansetsu01(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setKoshuku_hizakansetsu01(list.get(index - 1));
        } else {
            entity.setKoshuku_hizakansetsu01(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setKoshuku_sonohoka01(list.get(index - 1));
        } else {
            entity.setKoshuku_sonohoka01(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setNegaeri01(list.get(index - 1));
        } else {
            entity.setNegaeri01(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setOkiagari01(list.get(index - 1));
        } else {
            entity.setOkiagari01(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZaihoji01(list.get(index - 1));
        } else {
            entity.setZaihoji01(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setRyoashidenotagu01(list.get(index - 1));
        } else {
            entity.setRyoashidenotagu01(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setHoko01(list.get(index - 1));
        } else {
            entity.setHoko01(RString.EMPTY);
        }
    }

    private void edit126to140(List<RString> list, NichijiShinchokuIchijiTeburuEntity entity) {
        if (!list.get(index++).isNull()) {
            entity.setTachiagari01(list.get(index - 1));
        } else {
            entity.setTachiagari01(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setKataashidenotagu01(list.get(index - 1));
        } else {
            entity.setKataashidenotagu01(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setAraimi01(list.get(index - 1));
        } else {
            entity.setAraimi01(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setTsumekiri01(list.get(index - 1));
        } else {
            entity.setTsumekiri01(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setShiryoku01(list.get(index - 1));
        } else {
            entity.setShiryoku01(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setChoryoku01(list.get(index - 1));
        } else {
            entity.setChoryoku01(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setLjo02(list.get(index - 1));
        } else {
            entity.setLjo02(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setLdo02(list.get(index - 1));
        } else {
            entity.setLdo02(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setEnge02(list.get(index - 1));
        } else {
            entity.setEnge02(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setShokujisesshu02(list.get(index - 1));
        } else {
            entity.setShokujisesshu02(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setHainyo02(list.get(index - 1));
        } else {
            entity.setHainyo02(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setHaiben02(list.get(index - 1));
        } else {
            entity.setHaiben02(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setKokuseiketsu02(list.get(index - 1));
        } else {
            entity.setKokuseiketsu02(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setSengan02(list.get(index - 1));
        } else {
            entity.setSengan02(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setSeihatsu02(list.get(index - 1));
        } else {
            entity.setSeihatsu02(RString.EMPTY);
        }
    }

    private void edit141to155(List<RString> list, NichijiShinchokuIchijiTeburuEntity entity) {
        if (!list.get(index++).isNull()) {
            entity.setUwaginochakudatsu02(list.get(index - 1));
        } else {
            entity.setUwaginochakudatsu02(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZubontonochakudatsu02(list.get(index - 1));
        } else {
            entity.setZubontonochakudatsu02(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setGaishutsuhindo02(list.get(index - 1));
        } else {
            entity.setGaishutsuhindo02(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setLshinodentatsu03(list.get(index - 1));
        } else {
            entity.setLshinodentatsu03(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setMainichinonikkaorikai03(list.get(index - 1));
        } else {
            entity.setMainichinonikkaorikai03(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setSeinengappioiu03(list.get(index - 1));
        } else {
            entity.setSeinengappioiu03(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setTankikioku03(list.get(index - 1));
        } else {
            entity.setTankikioku03(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setJibunnonamaeoiu03(list.get(index - 1));
        } else {
            entity.setJibunnonamaeoiu03(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setImanokisetsuorikai03(list.get(index - 1));
        } else {
            entity.setImanokisetsuorikai03(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setBashonorikai03(list.get(index - 1));
        } else {
            entity.setBashonorikai03(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setHaikai03(list.get(index - 1));
        } else {
            entity.setHaikai03(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setGaishutsushitemodorenai03(list.get(index - 1));
        } else {
            entity.setGaishutsushitemodorenai03(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setHigaiteki04(list.get(index - 1));
        } else {
            entity.setHigaiteki04(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setSakubanashi04(list.get(index - 1));
        } else {
            entity.setSakubanashi04(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setKanjōgafuantei04(list.get(index - 1));
        } else {
            entity.setKanjōgafuantei04(RString.EMPTY);
        }
    }

    private void edit156to170(List<RString> list, NichijiShinchokuIchijiTeburuEntity entity) {
        if (!list.get(index++).isNull()) {
            entity.setChuyagyakuten04(list.get(index - 1));
        } else {
            entity.setChuyagyakuten04(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setOnajibanashiosuru04(list.get(index - 1));
        } else {
            entity.setOnajibanashiosuru04(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setOgoewodasu04(list.get(index - 1));
        } else {
            entity.setOgoewodasu04(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setKaigoniteiko04(list.get(index - 1));
        } else {
            entity.setKaigoniteiko04(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setOchitsukinashi04(list.get(index - 1));
        } else {
            entity.setOchitsukinashi04(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setIchiridedetagaru04(list.get(index - 1));
        } else {
            entity.setIchiridedetagaru04(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setShushuheki04(list.get(index - 1));
        } else {
            entity.setShushuheki04(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setMonoyairuiokowasu04(list.get(index - 1));
        } else {
            entity.setMonoyairuiokowasu04(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setHidoimonowasure04(list.get(index - 1));
        } else {
            entity.setHidoimonowasure04(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setHitorigotohitoriwarai04(list.get(index - 1));
        } else {
            entity.setHitorigotohitoriwarai04(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setJibungattenikodosuru04(list.get(index - 1));
        } else {
            entity.setJibungattenikodosuru04(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setWagamatomaranai04(list.get(index - 1));
        } else {
            entity.setWagamatomaranai04(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setKusurinonaifuku05(list.get(index - 1));
        } else {
            entity.setKusurinonaifuku05(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setKinsennokanri05(list.get(index - 1));
        } else {
            entity.setKinsennokanri05(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setNichijonoishikettei05(list.get(index - 1));
        } else {
            entity.setNichijonoishikettei05(RString.EMPTY);
        }
    }

    private void edit171to185(List<RString> list, NichijiShinchokuIchijiTeburuEntity entity) {
        if (!list.get(index++).isNull()) {
            entity.setShudanenofutekio05(list.get(index - 1));
        } else {
            entity.setShudanenofutekio05(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setKaimono05(list.get(index - 1));
        } else {
            entity.setKaimono05(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setKantannachori05(list.get(index - 1));
        } else {
            entity.setKantannachori05(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setTentekinokanri(list.get(index - 1));
        } else {
            entity.setTentekinokanri(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setChushinjomyakueiyo(list.get(index - 1));
        } else {
            entity.setChushinjomyakueiyo(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setToseki(list.get(index - 1));
        } else {
            entity.setToseki(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setSutomanoshochi(list.get(index - 1));
        } else {
            entity.setSutomanoshochi(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setSansoryoho(list.get(index - 1));
        } else {
            entity.setSansoryoho(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setResupireta(list.get(index - 1));
        } else {
            entity.setResupireta(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setKikansekkainoshochi(list.get(index - 1));
        } else {
            entity.setKikansekkainoshochi(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setTotsunokango(list.get(index - 1));
        } else {
            entity.setTotsunokango(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setKeikaneiyo(list.get(index - 1));
        } else {
            entity.setKeikaneiyo(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setMonitasokutei(list.get(index - 1));
        } else {
            entity.setMonitasokutei(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setJiyokusounoshochi(list.get(index - 1));
        } else {
            entity.setJiyokusounoshochi(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setKateteru(list.get(index - 1));
        } else {
            entity.setKateteru(RString.EMPTY);
        }
    }

    private void edit186to200(List<RString> list, NichijiShinchokuIchijiTeburuEntity entity) {
        if (!list.get(index++).isNull()) {
            entity.setShogaikoreishajiritsudo(list.get(index - 1));
        } else {
            entity.setShogaikoreishajiritsudo(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setNinshishokoreishajiritsudo(list.get(index - 1));
        } else {
            entity.setNinshishokoreishajiritsudo(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_mahi_hidari_joshi01(list.get(index - 1));
        } else {
            entity.setZenkaikekka_mahi_hidari_joshi01(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_mahi_migi_joshi01(list.get(index - 1));
        } else {
            entity.setZenkaikekka_mahi_migi_joshi01(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_mahi_hidari_kashi01(list.get(index - 1));
        } else {
            entity.setZenkaikekka_mahi_hidari_kashi01(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_mahi_migi_kashi01(list.get(index - 1));
        } else {
            entity.setZenkaikekka_mahi_migi_kashi01(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_mahi_sonohoka01(list.get(index - 1));
        } else {
            entity.setZenkaikekka_mahi_sonohoka01(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_koshuku_kenkansetsu01(list.get(index - 1));
        } else {
            entity.setZenkaikekka_koshuku_kenkansetsu01(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_koshuku_kokansetsu01(list.get(index - 1));
        } else {
            entity.setZenkaikekka_koshuku_kokansetsu01(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_koshuku_hizakansetsu01(list.get(index - 1));
        } else {
            entity.setZenkaikekka_koshuku_hizakansetsu01(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_koshuku_sonohoka01(list.get(index - 1));
        } else {
            entity.setZenkaikekka_koshuku_sonohoka01(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_negaeri01(list.get(index - 1));
        } else {
            entity.setZenkaikekka_negaeri01(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_okiagari01(list.get(index - 1));
        } else {
            entity.setZenkaikekka_okiagari01(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_zaihoji01(list.get(index - 1));
        } else {
            entity.setZenkaikekka_zaihoji01(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_ryoashidenotagu01(list.get(index - 1));
        } else {
            entity.setZenkaikekka_ryoashidenotagu01(RString.EMPTY);
        }
    }

    private void edit201to215(List<RString> list, NichijiShinchokuIchijiTeburuEntity entity) {
        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_hoko01(list.get(index - 1));
        } else {
            entity.setZenkaikekka_hoko01(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_tachiagari01(list.get(index - 1));
        } else {
            entity.setZenkaikekka_tachiagari01(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_kataashidenotagu01(list.get(index - 1));
        } else {
            entity.setZenkaikekka_kataashidenotagu01(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_araimi01(list.get(index - 1));
        } else {
            entity.setZenkaikekka_araimi01(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_tsumekiri01(list.get(index - 1));
        } else {
            entity.setZenkaikekka_tsumekiri01(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_shiryoku01(list.get(index - 1));
        } else {
            entity.setZenkaikekka_shiryoku01(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_choryoku01(list.get(index - 1));
        } else {
            entity.setZenkaikekka_choryoku01(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_ljo02(list.get(index - 1));
        } else {
            entity.setZenkaikekka_ljo02(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_ldo02(list.get(index - 1));
        } else {
            entity.setZenkaikekka_ldo02(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_enge02(list.get(index - 1));
        } else {
            entity.setZenkaikekka_enge02(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_shokujisesshu02(list.get(index - 1));
        } else {
            entity.setZenkaikekka_shokujisesshu02(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_hainyo02(list.get(index - 1));
        } else {
            entity.setZenkaikekka_hainyo02(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_haiben02(list.get(index - 1));
        } else {
            entity.setZenkaikekka_haiben02(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_kokuseiketsu02(list.get(index - 1));
        } else {
            entity.setZenkaikekka_kokuseiketsu02(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_sengan02(list.get(index - 1));
        } else {
            entity.setZenkaikekka_sengan02(RString.EMPTY);
        }
    }

    private void edit216to230(List<RString> list, NichijiShinchokuIchijiTeburuEntity entity) {
        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_seihatsu02(list.get(index - 1));
        } else {
            entity.setZenkaikekka_seihatsu02(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_uwaginochakudatsu02(list.get(index - 1));
        } else {
            entity.setZenkaikekka_uwaginochakudatsu02(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_zubontonochakudatsu02(list.get(index - 1));
        } else {
            entity.setZenkaikekka_zubontonochakudatsu02(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_gaishutsuhindo02(list.get(index - 1));
        } else {
            entity.setZenkaikekka_gaishutsuhindo02(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_lshinodentatsu03(list.get(index - 1));
        } else {
            entity.setZenkaikekka_lshinodentatsu03(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_mainichinonikkaorikai03(list.get(index - 1));
        } else {
            entity.setZenkaikekka_mainichinonikkaorikai03(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_seinengappioiu03(list.get(index - 1));
        } else {
            entity.setZenkaikekka_seinengappioiu03(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_tankikioku03(list.get(index - 1));
        } else {
            entity.setZenkaikekka_tankikioku03(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_jibunnonamaeoiu03(list.get(index - 1));
        } else {
            entity.setZenkaikekka_jibunnonamaeoiu03(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_imanokisetsuorikai03(list.get(index - 1));
        } else {
            entity.setZenkaikekka_imanokisetsuorikai03(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_bashonorikai03(list.get(index - 1));
        } else {
            entity.setZenkaikekka_bashonorikai03(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_haikai03(list.get(index - 1));
        } else {
            entity.setZenkaikekka_haikai03(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_gaishutsushitemodorenai03(list.get(index - 1));
        } else {
            entity.setZenkaikekka_gaishutsushitemodorenai03(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_higaiteki04(list.get(index - 1));
        } else {
            entity.setZenkaikekka_higaiteki04(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_sakubanashi04(list.get(index - 1));
        } else {
            entity.setZenkaikekka_sakubanashi04(RString.EMPTY);
        }
    }

    private void edit231to245(List<RString> list, NichijiShinchokuIchijiTeburuEntity entity) {
        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_kanjōgafuantei04(list.get(index - 1));
        } else {
            entity.setZenkaikekka_kanjōgafuantei04(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_chuyagyakuten04(list.get(index - 1));
        } else {
            entity.setZenkaikekka_chuyagyakuten04(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_onajibanashiosuru04(list.get(index - 1));
        } else {
            entity.setZenkaikekka_onajibanashiosuru04(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_ogoewodasu04(list.get(index - 1));
        } else {
            entity.setZenkaikekka_ogoewodasu04(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_kaigoniteiko04(list.get(index - 1));
        } else {
            entity.setZenkaikekka_kaigoniteiko04(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_ochitsukinashi04(list.get(index - 1));
        } else {
            entity.setZenkaikekka_ochitsukinashi04(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_ichiridedetagaru04(list.get(index - 1));
        } else {
            entity.setZenkaikekka_ichiridedetagaru04(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_shushuheki04(list.get(index - 1));
        } else {
            entity.setZenkaikekka_shushuheki04(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_monoyairuiokowasu04(list.get(index - 1));
        } else {
            entity.setZenkaikekka_monoyairuiokowasu04(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_hidoimonowasure04(list.get(index - 1));
        } else {
            entity.setZenkaikekka_hidoimonowasure04(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_hitorigotohitoriwarai04(list.get(index - 1));
        } else {
            entity.setZenkaikekka_hitorigotohitoriwarai04(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_jibungattenikodosuru04(list.get(index - 1));
        } else {
            entity.setZenkaikekka_jibungattenikodosuru04(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_wagamatomaranai04(list.get(index - 1));
        } else {
            entity.setZenkaikekka_wagamatomaranai04(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_Kusurinonaifuku05(list.get(index - 1));
        } else {
            entity.setZenkaikekka_Kusurinonaifuku05(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_kinsennokanri05(list.get(index - 1));
        } else {
            entity.setZenkaikekka_kinsennokanri05(RString.EMPTY);
        }
    }

    private void edit246to260(List<RString> list, NichijiShinchokuIchijiTeburuEntity entity) {
        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_nichijonoishikettei05(list.get(index - 1));
        } else {
            entity.setZenkaikekka_nichijonoishikettei05(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_shudanenofutekio05(list.get(index - 1));
        } else {
            entity.setZenkaikekka_shudanenofutekio05(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_kaimono05(list.get(index - 1));
        } else {
            entity.setZenkaikekka_kaimono05(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_kantannachori05(list.get(index - 1));
        } else {
            entity.setZenkaikekka_kantannachori05(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_tentekinokanri(list.get(index - 1));
        } else {
            entity.setZenkaikekka_tentekinokanri(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_chushinjomyakueiyo(list.get(index - 1));
        } else {
            entity.setZenkaikekka_chushinjomyakueiyo(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_toseki(list.get(index - 1));
        } else {
            entity.setZenkaikekka_toseki(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_sutomanoshochi(list.get(index - 1));
        } else {
            entity.setZenkaikekka_sutomanoshochi(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_sansoryoho(list.get(index - 1));
        } else {
            entity.setZenkaikekka_sansoryoho(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_resupireta(list.get(index - 1));
        } else {
            entity.setZenkaikekka_resupireta(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_kikansekkainoshochitotsunokango(list.get(index - 1));
        } else {
            entity.setZenkaikekka_kikansekkainoshochitotsunokango(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_totsunokango(list.get(index - 1));
        } else {
            entity.setZenkaikekka_totsunokango(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_keikaneiyo(list.get(index - 1));
        } else {
            entity.setZenkaikekka_keikaneiyo(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_monitasokutei(list.get(index - 1));
        } else {
            entity.setZenkaikekka_monitasokutei(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_jiyokusounoshochi(list.get(index - 1));
        } else {
            entity.setZenkaikekka_jiyokusounoshochi(RString.EMPTY);
        }

    }

    private void edit261to275(List<RString> list, NichijiShinchokuIchijiTeburuEntity entity) {

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_kateteru(list.get(index - 1));
        } else {
            entity.setZenkaikekka_kateteru(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_shogaikoreishajiritsudo(list.get(index - 1));
        } else {
            entity.setZenkaikekka_shogaikoreishajiritsudo(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_ninshishokoreishajiritsudo(list.get(index - 1));
        } else {
            entity.setZenkaikekka_ninshishokoreishajiritsudo(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_ichijihanteikekka(list.get(index - 1));
        } else {
            entity.setZenkaikekka_ichijihanteikekka(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_ichijihanteikekka_ninshishokasan(list.get(index - 1));
        } else {
            entity.setZenkaikekka_ichijihanteikekka_ninshishokasan(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_yokaigojikan(list.get(index - 1));
        } else {
            entity.setZenkaikekka_yokaigojikan(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_yokaigojikan_shokuji(list.get(index - 1));
        } else {
            entity.setZenkaikekka_yokaigojikan_shokuji(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_yokaigojikan_haisetsu(list.get(index - 1));
        } else {
            entity.setZenkaikekka_yokaigojikan_haisetsu(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_yokaigojikan_ldo(list.get(index - 1));
        } else {
            entity.setZenkaikekka_yokaigojikan_ldo(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_yokaigojikan_seiketsuhoji(list.get(index - 1));
        } else {
            entity.setZenkaikekka_yokaigojikan_seiketsuhoji(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_yokaigojikan_kansetsukea(list.get(index - 1));
        } else {
            entity.setZenkaikekka_yokaigojikan_kansetsukea(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_yokaigojikan_kanren(list.get(index - 1));
        } else {
            entity.setZenkaikekka_yokaigojikan_kanren(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_yokaigojikan_kinokunren(list.get(index - 1));
        } else {
            entity.setZenkaikekka_yokaigojikan_kinokunren(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_yokaigojikan_iryokanren(list.get(index - 1));
        } else {
            entity.setZenkaikekka_yokaigojikan_iryokanren(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_yokaigojikan_ninshishokasan(list.get(index - 1));
        } else {
            entity.setZenkaikekka_yokaigojikan_ninshishokasan(RString.EMPTY);
        }
    }

    private void edit276to290(List<RString> list, NichijiShinchokuIchijiTeburuEntity entity) {
        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_chukanhyokakomokutokutendai1_gun(list.get(index - 1));
        } else {
            entity.setZenkaikekka_chukanhyokakomokutokutendai1_gun(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_chukanhyokakomokutokutendai2_gun(list.get(index - 1));
        } else {
            entity.setZenkaikekka_chukanhyokakomokutokutendai2_gun(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_chukanhyokakomokutokutendai3_gun(list.get(index - 1));
        } else {
            entity.setZenkaikekka_chukanhyokakomokutokutendai3_gun(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_chukanhyokakomokutokutendai4_gun(list.get(index - 1));
        } else {
            entity.setZenkaikekka_chukanhyokakomokutokutendai4_gun(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_chukanhyokakomokutokutendai5_gun(list.get(index - 1));
        } else {
            entity.setZenkaikekka_chukanhyokakomokutokutendai5_gun(RString.EMPTY);
        }

        if (!list.get(index++).isNull() && !list.get(index - 1).isEmpty()) {
            entity.setZenkaikekka_kodo(new Code(list.get(index - 1)));
        } else {
            entity.setZenkaikekka_kodo(Code.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_jotainoanteisei(list.get(index - 1));
        } else {
            entity.setZenkaikekka_jotainoanteisei(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_ninshishojiritsudo(list.get(index - 1));
        } else {
            entity.setZenkaikekka_ninshishojiritsudo(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_ninchikinokyufukubun(list.get(index - 1));
        } else {
            entity.setZenkaikekka_ninchikinokyufukubun(RString.EMPTY);
        }

        if (!list.get(index++).isNull() && !list.get(index - 1).isEmpty()) {
            entity.setZenkaikekka_shinseibi(new FlexibleDate(list.get(index - 1)));
        } else {
            entity.setZenkaikekka_shinseibi(FlexibleDate.EMPTY);
        }

        if (!list.get(index++).isNull() && !list.get(index - 1).isEmpty()) {
            entity.setZenkaikekka_nijihanteibi(new FlexibleDate(list.get(index - 1)));
        } else {
            entity.setZenkaikekka_nijihanteibi(FlexibleDate.EMPTY);
        }

        if (!list.get(index++).isNull() && !list.get(index - 1).isEmpty()) {
            entity.setZenkaikekka_genzainosabisukubunkodo(new Code(list.get(index - 1)));
        } else {
            entity.setZenkaikekka_genzainosabisukubunkodo(Code.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_genzainojokyo(list.get(index - 1));
        } else {
            entity.setZenkaikekka_genzainojokyo(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_homonkaigo_homuherupusabisu(list.get(index - 1));
        } else {
            entity.setZenkaikekka_homonkaigo_homuherupusabisu(RString.EMPTY);
        }

    }

    private void edit291to305(List<RString> list, NichijiShinchokuIchijiTeburuEntity entity) {
        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_homonnyuyokukaigo(list.get(index - 1));
        } else {
            entity.setZenkaikekka_homonnyuyokukaigo(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_homonkango(list.get(index - 1));
        } else {
            entity.setZenkaikekka_homonkango(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_homonrihabiriteshon(list.get(index - 1));
        } else {
            entity.setZenkaikekka_homonrihabiriteshon(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_kyotakuryoyokanrishido(list.get(index - 1));
        } else {
            entity.setZenkaikekka_kyotakuryoyokanrishido(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_tsushokaigo_deisabisu(list.get(index - 1));
        } else {
            entity.setZenkaikekka_tsushokaigo_deisabisu(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_tsushorihabiriteshon(list.get(index - 1));
        } else {
            entity.setZenkaikekka_tsushorihabiriteshon(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_tankinyushoseikatsukaigo_shotosutei(list.get(index - 1));
        } else {
            entity.setZenkaikekka_tankinyushoseikatsukaigo_shotosutei(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_tankinyushoryoyokaigo(list.get(index - 1));
        } else {
            entity.setZenkaikekka_tankinyushoryoyokaigo(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_tokuteishisetsunyukyoshaseikatsukaigo(list.get(index - 1));
        } else {
            entity.setZenkaikekka_tokuteishisetsunyukyoshaseikatsukaigo(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_fukushiyogutaiyo(list.get(index - 1));
        } else {
            entity.setZenkaikekka_fukushiyogutaiyo(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_tokuteifukushiyoguhanbai(list.get(index - 1));
        } else {
            entity.setZenkaikekka_tokuteifukushiyoguhanbai(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_jutakukaishukaigokyufu(list.get(index - 1));
        } else {
            entity.setZenkaikekka_jutakukaishukaigokyufu(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_yakantaiogatahomonkaigo(list.get(index - 1));
        } else {
            entity.setZenkaikekka_yakantaiogatahomonkaigo(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_ninchishotaiogatasushokaigo(list.get(index - 1));
        } else {
            entity.setZenkaikekka_ninchishotaiogatasushokaigo(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_shokibotakinogatakyotakukaigo(list.get(index - 1));
        } else {
            entity.setZenkaikekka_shokibotakinogatakyotakukaigo(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_ninshishokaigo_gurupuhomu(list.get(index - 1));
        } else {
            entity.setZenkaikekka_ninshishokaigo_gurupuhomu(RString.EMPTY);
        }
    }

    private void edit306to320(List<RString> list, NichijiShinchokuIchijiTeburuEntity entity) {
        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_chiikimitchakugataseikatsukaigo(list.get(index - 1));
        } else {
            entity.setZenkaikekka_chiikimitchakugataseikatsukaigo(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_mitchakugatarojinkaigo(list.get(index - 1));
        } else {
            entity.setZenkaikekka_mitchakugatarojinkaigo(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_teikijunkai_zuijihomonkaigokango(list.get(index - 1));
        } else {
            entity.setZenkaikekka_teikijunkai_zuijihomonkaigokango(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_fukugogatasabisu(list.get(index - 1));
        } else {
            entity.setZenkaikekka_fukugogatasabisu(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_kaigoyobohomonkaigo_homuherupusabisu(list.get(index - 1));
        } else {
            entity.setZenkaikekka_kaigoyobohomonkaigo_homuherupusabisu(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_kaigoyobohomonnyuyokukaigo(list.get(index - 1));
        } else {
            entity.setZenkaikekka_kaigoyobohomonnyuyokukaigo(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_kaigoyobohomonkango(list.get(index - 1));
        } else {
            entity.setZenkaikekka_kaigoyobohomonkango(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_kaigoyobohomonrihabiriteshon(list.get(index - 1));
        } else {
            entity.setZenkaikekka_kaigoyobohomonrihabiriteshon(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_kaigoyobokyotakuryoyokanrishido(list.get(index - 1));
        } else {
            entity.setZenkaikekka_kaigoyobokyotakuryoyokanrishido(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_kaigoyobotsushokaigo_deisabisu(list.get(index - 1));
        } else {
            entity.setZenkaikekka_kaigoyobotsushokaigo_deisabisu(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_kaigoyobotsushorihabiriteshon(list.get(index - 1));
        } else {
            entity.setZenkaikekka_kaigoyobotsushorihabiriteshon(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_kaigoyobotankiseikatsukaigo(list.get(index - 1));
        } else {
            entity.setZenkaikekka_kaigoyobotankiseikatsukaigo(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_kaigoyobotankinyushoryoyokaigo(list.get(index - 1));
        } else {
            entity.setZenkaikekka_kaigoyobotankinyushoryoyokaigo(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_yobotokuteishisetsunyukyoshakaigo(list.get(index - 1));
        } else {
            entity.setZenkaikekka_yobotokuteishisetsunyukyoshakaigo(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_kaigoyobofukushiyogutaiyo(list.get(index - 1));
        } else {
            entity.setZenkaikekka_kaigoyobofukushiyogutaiyo(RString.EMPTY);
        }
    }

    private void edit321to328(List<RString> list, NichijiShinchokuIchijiTeburuEntity entity) {
        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_tokuteikaigoyobofukushiyoguhanbai(list.get(index - 1));
        } else {
            entity.setZenkaikekka_tokuteikaigoyobofukushiyoguhanbai(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_jutakukaishu_yobokyufu(list.get(index - 1));
        } else {
            entity.setZenkaikekka_jutakukaishu_yobokyufu(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_kaigoyoboninchishotaiogatatsushokaigo(list.get(index - 1));
        } else {
            entity.setZenkaikekka_kaigoyoboninchishotaiogatatsushokaigo(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_kaigoyoboshokibotakinogatakyotakukaigo(list.get(index - 1));
        } else {
            entity.setZenkaikekka_kaigoyoboshokibotakinogatakyotakukaigo(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setZenkaikekka_yoboninshishokaigo_gurupuhomu(list.get(index - 1));
        } else {
            entity.setZenkaikekka_yoboninshishokaigo_gurupuhomu(RString.EMPTY);
        }

        if (!list.get(index++).isNull() && !list.get(index - 1).isEmpty()) {
            entity.setZenkaishikibetsukodo(new Code(list.get(index - 1)));
        } else {
            entity.setZenkaishikibetsukodo(Code.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setNinteishinsakaiikento(list.get(index - 1));
        } else {
            entity.setNinteishinsakaiikento(RString.EMPTY);
        }

        if (!list.get(index++).isNull()) {
            entity.setKomentoto(list.get(index - 1));
        } else {
            entity.setKomentoto(RString.EMPTY);
        }
    }

}
