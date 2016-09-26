/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD492001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.DBD492001.ErrorRecord;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.DBD492001.HenKouData;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.DBD492001.ShinseiKubunItchiChekkuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.DBD492001.ichijiteburu.FairudetaIchijiTeburuEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriterBuilders;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 申請区分一致チェック_process処理クラスです。
 *
 * @reamsid_L DBD-1510-020 x_xuliang
 */
public class ShinseiKubunItchiChekkuProcess extends BatchProcessBase<ShinseiKubunItchiChekkuEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate."
            + "yokaigoninteikekkarenkeidetatorikomi.IShinseiKubunItchiChekkuMapper.get申請区分一致");

    private List<ErrorRecord> errorRecordList;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter tmpTableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH);
    }

    @Override
    protected void createWriter() {
        tmpTableWriter = BatchEntityCreatedTempTableWriterBuilders.createBuilder(FairudetaIchijiTeburuEntity.class)
                .tempTableName(FairudetaIchijiTeburuEntity.TABLE_NAME)
                .build();
    }

    @Override
    protected void initialize() {
        errorRecordList = new ArrayList<>();
    }

    @Override
    protected void process(ShinseiKubunItchiChekkuEntity t) {
        ErrorRecord error = new ErrorRecord();
        HenKouData entity = new HenKouData();
//TODO        if (!t.getNinteiShinseiShinseijiKubunCode().equals(読み込んだレコードの申請区分(申請時)コード)) {
        error.setShikibetsukodo(entity.getShikibetsukodo());
        error.setHokenshabango(entity.getHokenshabango());
        error.setHihokenjabango(entity.getHihokenjabango());
        error.setNinteishinseibi(entity.getNinteishinseibi());
        error.setEdaban(entity.getEdaban());
        error.setShinseikubunhorei(entity.getShinseikubunhorei());
        error.setShinseikubunshinseiji(entity.getShinseikubunshinseiji());
        error.setTorisakubunkodo(entity.getTorisakubunkodo());
        error.setHihokenjakubun(entity.getHihokenjakubun());
        error.setShinseidaikokubun(entity.getShinseidaikokubun());
        error.setSeinengappi(entity.getSeinengappi());
        error.setNenrei(entity.getNenrei());
        error.setSeibetsukodo(entity.getSeibetsukodo());
        error.setHihokenjakanashimei(entity.getHihokenjakanashimei());
        error.setHihokenjakanjishimei(entity.getHihokenjakanjishimei());
        error.setYubenbango(entity.getYubenbango());
        error.setJusho(entity.getJusho());
        error.setTenwabango(entity.getTenwabango());
        error.setByoinshisetsutonomeisho(entity.getByoinshisetsutonomeisho());
        error.setByoinshisetsutonoshozaichi(entity.getByoinshisetsutonoshozaichi());
        errorRecordList.add(error);
//    } else {
        FairudetaIchijiTeburuEntity fairEntity = createファイルデータ一時テーブル(entity);
        tmpTableWriter.insert(fairEntity);
//    }
    }

    private FairudetaIchijiTeburuEntity createファイルデータ一時テーブル(HenKouData data) {
        FairudetaIchijiTeburuEntity entity = new FairudetaIchijiTeburuEntity();
        entity.setKoban(data.getKoban());
        entity.setSutetasu(data.getSutetasu());
        entity.setShikibetsukodo(data.getShikibetsukodo());
        entity.setHokenshabango(data.getHokenshabango());
        entity.setHihokenjabango(data.getHihokenjabango());
        entity.setNinteishinseibi(data.getNinteishinseibi());
        entity.setEdaban(data.getEdaban());
        entity.setShinseikubunhorei(data.getShinseikubunhorei());
        entity.setShinseikubunshinseiji(data.getShinseikubunshinseiji());
        entity.setTorisakubunkodo(data.getTorisakubunkodo());
        entity.setHihokenjakubun(data.getHihokenjakubun());
        entity.setShinseidaikokubun(data.getShinseidaikokubun());
        entity.setSeinengappi(data.getSeinengappi());
        entity.setNenrei(data.getNenrei());
        entity.setSeibetsukodo(data.getSeibetsukodo());
        entity.setHihokenjakanashimei(data.getHihokenjakanashimei());
        entity.setHihokenjakanjishimei(data.getHihokenjakanjishimei());
        entity.setYubenbango(data.getYubenbango());
        entity.setJusho(data.getJusho());
        entity.setTenwabango(data.getTenwabango());
        entity.setByoinshisetsutonomeisho(data.getByoinshisetsutonomeisho());
        entity.setByoinshisetsutonoshozaichi(data.getByoinshisetsutonoshozaichi());
        entity.setZenkainoninteishinsakaikekka(data.getZenkainoninteishinsakaikekka());
        entity.setZenkainoninteiyukokigenkaishi(data.getZenkainoninteiyukokigenkaishi());
        entity.setZenkainoninteiyukokigenshuryo(data.getZenkainoninteiyukokigenshuryo());
        entity.setShujiiiryokikanbango(data.getShujiiiryokikanbango());
        entity.setShujiibango(data.getShujiibango());
        entity.setLkenshoiraibi(data.getLkenshoiraibi());
        entity.setLkenshonyushubi(data.getLkenshonyushubi());
        entity.setLkensho_tankikioku(data.getLkensho_tankikioku());
        entity.setLkensho_ninchinoryoku(data.getLkensho_ninchinoryoku());
        entity.setLkensho_dentatsunoryoku(data.getLkensho_dentatsunoryoku());
        entity.setLkensho_shokujikoi(data.getLkensho_shokujikoi());
        entity.setLkensho_ninshishokoreishajiritsudo(data.getLkensho_ninshishokoreishajiritsudo());
        entity.setChosairaibi(data.getChosairaibi());
        entity.setChosajisshibi(data.getChosajisshibi());
        entity.setShiteikyotakukaigoshienjigyoshatobango(data.getShiteikyotakukaigoshienjigyoshatobango());
        entity.setLtakukubun(data.getLtakukubun());
        entity.setNinteichosainbango(data.getNinteichosainbango());
        entity.setNinteichosainshikakukodo(data.getNinteichosainshikakukodo());
        entity.setLchijihanteibi(data.getLchijihanteibi());
        entity.setLchijihanteikekka(data.getLchijihanteikekka());
        entity.setLchijihanteikekka_ninshishokasan(data.getLchijihanteikekka_ninshishokasan());
        entity.setYokaigoninteitokijunjikan(data.getYokaigoninteitokijunjikan());
        entity.setYokaigoninteitokijunjikan_shokuji(data.getYokaigoninteitokijunjikan_shokuji());
        entity.setYokaigoninteitokijunjikan_haisetsu(data.getYokaigoninteitokijunjikan_haisetsu());
        entity.setYokaigoninteitokijunjikan_ldo(data.getYokaigoninteitokijunjikan_ldo());
        entity.setYokaigoninteitokijunjikan_seiketsuhoji(data.getYokaigoninteitokijunjikan_seiketsuhoji());
        entity.setYokaigoninteitokijunjikan_kansetsukea(data.getYokaigoninteitokijunjikan_kansetsukea());
        entity.setYokaigoninteitokijunjikan_bpsdkanren(data.getYokaigoninteitokijunjikan_bpsdkanren());
        entity.setYokaigoninteitokijunjikan_kinokunren(data.getYokaigoninteitokijunjikan_kinokunren());
        entity.setYokaigoninteitokijunjikan_lryokanren(data.getYokaigoninteitokijunjikan_lryokanren());
        entity.setYokaigoninteitokijunjikan_ninshishokasan(data.getYokaigoninteitokijunjikan_ninshishokasan());
        entity.setChukanhyokakomokutokuten_dai1gun(data.getChukanhyokakomokutokuten_dai1gun());
        entity.setChukanhyokakomokutokuten_dai2gun(data.getChukanhyokakomokutokuten_dai2gun());
        entity.setChukanhyokakomokutokuten_dai3gun(data.getChukanhyokakomokutokuten_dai3gun());
        entity.setChukanhyokakomokutokuten_dai4gun(data.getChukanhyokakomokutokuten_dai4gun());
        entity.setChukanhyokakomokutokuten_dai5gun(data.getChukanhyokakomokutokuten_dai5gun());
        entity.setLchijihanteikeikoku(data.getLchijihanteikeikoku());
        entity.setJotainoanteisei(data.getJotainoanteisei());
        entity.setNinshishojiritsudoijonogaizensei(data.getNinshishojiritsudoijonogaizensei());
        entity.setNinchikinokyufukubun(data.getNinchikinokyufukubun());
        entity.setNinteishinsakaishiryosakuseibi(data.getNinteishinsakaishiryosakuseibi());
        entity.setNinteishinsakaiyoteibi(data.getNinteishinsakaiyoteibi());
        entity.setGogitaibango(data.getGogitaibango());
        entity.setShinsakaishiryobango(data.getShinsakaishiryobango());
        entity.setNijihanteibi(data.getNijihanteibi());
        entity.setNijihanteikekka(data.getNijihanteikekka());
        entity.setNinteiyukokigen_kaishi(data.getNinteiyukokigen_kaishi());
        entity.setNinteiyukokigen_shuryo(data.getNinteiyukokigen_shuryo());
        entity.setTokuteishippeikodo(data.getTokuteishippeikodo());
        entity.setYokaigo1nobaainojotaizo(data.getYokaigo1nobaainojotaizo());
        entity.setGenzainosabisukubunkodo(data.getGenzainosabisukubunkodo());
        entity.setGenzainojokyo(data.getGenzainojokyo());
        entity.setHomonkaigo_homuherupusabisu(data.getHomonkaigo_homuherupusabisu());
        entity.setHomonnyuyokukaigo(data.getHomonnyuyokukaigo());
        entity.setHomonkango(data.getHomonkango());
        entity.setHomonrihabiriteshon(data.getHomonrihabiriteshon());
        entity.setKyotakuryoyokanrishido(data.getKyotakuryoyokanrishido());
        entity.setTsushokaigo_deisabisu(data.getTsushokaigo_deisabisu());
        entity.setTsushorihabiriteshon(data.getTsushorihabiriteshon());
        entity.setTankinyushoseikatsukaigo_shotosutei(data.getTankinyushoseikatsukaigo_shotosutei());
        entity.setTankinyushoryoyokaigo(data.getTankinyushoryoyokaigo());
        entity.setTokuteishisetsunyukyoshaseikatsukaigo(data.getTokuteishisetsunyukyoshaseikatsukaigo());
        entity.setFukushiyogutaiyo(data.getFukushiyogutaiyo());
        entity.setTokuteifukushiyoguhanbai(data.getTokuteifukushiyoguhanbai());
        entity.setJutakukaishukaigokyufu(data.getJutakukaishukaigokyufu());
        entity.setYakantaiogatahomonkaigo(data.getYakantaiogatahomonkaigo());
        entity.setNinchishotaiogatasushokaigo(data.getNinchishotaiogatasushokaigo());
        entity.setShokibotakinogatakyotakukaigo(data.getShokibotakinogatakyotakukaigo());
        entity.setNinshishokaigo_gurupuhomu(data.getNinshishokaigo_gurupuhomu());
        entity.setChiikimitchakugataseikatsukaigo(data.getChiikimitchakugataseikatsukaigo());
        entity.setMitchakugatarojinkaigo(data.getMitchakugatarojinkaigo());
        entity.setTeikijunkai_zuijihomonkaigokango(data.getTeikijunkai_zuijihomonkaigokango());
        entity.setFukugogatasabisu(data.getFukugogatasabisu());
        entity.setKaigoyobohomonkaigo_homuherupusabisu(data.getKaigoyobohomonkaigo_homuherupusabisu());
        entity.setKaigoyobohomonnyuyokukaigo(data.getKaigoyobohomonnyuyokukaigo());
        entity.setKaigoyobohomonkango(data.getKaigoyobohomonkango());
        entity.setKaigoyobohomonrihabiriteshon(data.getKaigoyobohomonrihabiriteshon());
        entity.setKaigoyobokyotakuryoyokanrishido(data.getKaigoyobokyotakuryoyokanrishido());
        entity.setKaigoyobotsushokaigo_deisabisu(data.getKaigoyobotsushokaigo_deisabisu());
        entity.setKaigoyobotsushorihabiriteshon(data.getKaigoyobotsushorihabiriteshon());
        entity.setKaigoyobotankiseikatsukaigo(data.getKaigoyobotankiseikatsukaigo());
        entity.setKaigoyobotankinyushoryoyokaigo(data.getKaigoyobotankinyushoryoyokaigo());
        entity.setYobotokuteishisetsunyukyoshakaigo(data.getYobotokuteishisetsunyukyoshakaigo());
        entity.setKaigoyobofukushiyogutaiyo(data.getKaigoyobofukushiyogutaiyo());
        entity.setTokuteikaigoyobofukushiyoguhanbai(data.getTokuteikaigoyobofukushiyoguhanbai());
        entity.setJutakukaishu_yobokyufu(data.getJutakukaishu_yobokyufu());
        entity.setKaigoyoboninchishotaiogatatsushokaigo(data.getKaigoyoboninchishotaiogatatsushokaigo());
        entity.setKaigoyoboshokibotakinogatakyotakukaigo(data.getKaigoyoboshokibotakinogatakyotakukaigo());
        entity.setYoboninshishokaigo_gurupuhomu(data.getYoboninshishokaigo_gurupuhomu());
        entity.setMahi_hidari_joshi01(data.getMahi_hidari_joshi01());
        entity.setMahi_migi_joshi01(data.getMahi_migi_joshi01());
        entity.setMahi_hidari_kashi01(data.getMahi_hidari_kashi01());
        entity.setMahi_migi_kashi01(data.getMahi_migi_kashi01());
        entity.setMahi_sonohoka01(data.getMahi_sonohoka01());
        entity.setKoshuku_kenkansetsu01(data.getKoshuku_kenkansetsu01());
        entity.setKoshuku_kokansetsu01(data.getKoshuku_kokansetsu01());
        entity.setKoshuku_hizakansetsu01(data.getKoshuku_hizakansetsu01());
        entity.setKoshuku_sonohoka01(data.getKoshuku_sonohoka01());
        entity.setNegaeri01(data.getNegaeri01());
        entity.setOkiagari01(data.getOkiagari01());
        entity.setZaihoji01(data.getZaihoji01());
        entity.setRyoashidenotagu01(data.getRyoashidenotagu01());
        entity.setHoko01(data.getHoko01());
        entity.setTachiagari01(data.getTachiagari01());
        entity.setKataashidenotagu01(data.getKataashidenotagu01());
        entity.setAraimi01(data.getAraimi01());
        entity.setTsumekiri01(data.getTsumekiri01());
        entity.setShiryoku01(data.getShiryoku01());
        entity.setChoryoku01(data.getChoryoku01());
        entity.setLjo02(data.getLjo02());
        entity.setLdo02(data.getLdo02());
        entity.setEnge02(data.getEnge02());
        entity.setShokujisesshu02(data.getShokujisesshu02());
        entity.setHainyo02(data.getHainyo02());
        entity.setHaiben02(data.getHaiben02());
        entity.setKokuseiketsu02(data.getKokuseiketsu02());
        entity.setSengan02(data.getSengan02());
        entity.setSeihatsu02(data.getSeihatsu02());
        entity.setUwaginochakudatsu02(data.getUwaginochakudatsu02());
        entity.setZubontonochakudatsu02(data.getZubontonochakudatsu02());
        entity.setGaishutsuhindo02(data.getGaishutsuhindo02());
        entity.setLshinodentatsu03(data.getLshinodentatsu03());
        entity.setMainichinonikkaorikai03(data.getMainichinonikkaorikai03());
        entity.setSeinengappioiu03(data.getSeinengappioiu03());
        entity.setTankikioku03(data.getTankikioku03());
        entity.setJibunnonamaeoiu03(data.getJibunnonamaeoiu03());
        entity.setImanokisetsuorikai03(data.getImanokisetsuorikai03());
        entity.setBashonorikai03(data.getBashonorikai03());
        entity.setHaikai03(data.getHaikai03());
        entity.setGaishutsushitemodorenai03(data.getGaishutsushitemodorenai03());
        entity.setHigaiteki04(data.getHigaiteki04());
        entity.setSakubanashi04(data.getSakubanashi04());
        entity.setKanjōgafuantei04(data.getKanjōgafuantei04());
        entity.setChuyagyakuten04(data.getChuyagyakuten04());
        entity.setOnajibanashiosuru04(data.getOnajibanashiosuru04());
        entity.setOgoewodasu04(data.getOgoewodasu04());
        entity.setKaigoniteiko04(data.getKaigoniteiko04());
        entity.setOchitsukinashi04(data.getOchitsukinashi04());
        entity.setIchiridedetagaru04(data.getIchiridedetagaru04());
        entity.setShushuheki04(data.getShushuheki04());
        entity.setMonoyairuiokowasu04(data.getMonoyairuiokowasu04());
        entity.setHidoimonowasure04(data.getHidoimonowasure04());
        entity.setHitorigotohitoriwarai04(data.getHitorigotohitoriwarai04());
        entity.setJibungattenikodosuru04(data.getJibungattenikodosuru04());
        entity.setWagamatomaranai04(data.getWagamatomaranai04());
        entity.setKusurinonaifuku05(data.getKusurinonaifuku05());
        entity.setKinsennokanri05(data.getKinsennokanri05());
        entity.setNichijonoishikettei05(data.getNichijonoishikettei05());
        entity.setShudanenofutekio05(data.getShudanenofutekio05());
        entity.setKaimono05(data.getKaimono05());
        entity.setKantannachori05(data.getKantannachori05());
        entity.setTentekinokanri(data.getTentekinokanri());
        entity.setChushinjomyakueiyo(data.getChushinjomyakueiyo());
        entity.setToseki(data.getToseki());
        entity.setSutomanoshochi(data.getSutomanoshochi());
        entity.setSansoryoho(data.getSansoryoho());
        entity.setResupireta(data.getResupireta());
        entity.setKikansekkainoshochitotsunokango(data.getKikansekkainoshochitotsunokango());
        entity.setKeikaneiyo(data.getKeikaneiyo());
        entity.setMonitasokutei(data.getMonitasokutei());
        entity.setJiyokusounoshochi(data.getJiyokusounoshochi());
        entity.setKateteru(data.getKateteru());
        entity.setShogaikorei(data.getShogaikorei());
        entity.setShajiritsudo(data.getShajiritsudo());
        entity.setNinshishokoreishajiritsudo(data.getNinshishokoreishajiritsudo());
        entity.setZenkaikekka_mahi_hidari_joshi01(data.getZenkaikekka_mahi_hidari_joshi01());
        entity.setZenkaikekka_mahi_migi_joshi01(data.getZenkaikekka_mahi_migi_joshi01());
        entity.setZenkaikekka_mahi_hidari_kashi01(data.getZenkaikekka_mahi_hidari_kashi01());
        entity.setZenkaikekka_mahi_migi_kashi01(data.getZenkaikekka_mahi_migi_kashi01());
        entity.setZenkaikekka_mahi_sonohoka01(data.getZenkaikekka_mahi_sonohoka01());
        entity.setZenkaikekka_koshuku_kenkansetsu01(data.getZenkaikekka_koshuku_kenkansetsu01());
        entity.setZenkaikekka_koshuku_kokansetsu01(data.getZenkaikekka_koshuku_kokansetsu01());
        entity.setZenkaikekka_koshuku_hizakansetsu01(data.getZenkaikekka_koshuku_hizakansetsu01());
        entity.setZenkaikekka_koshuku_sonohoka01(data.getZenkaikekka_koshuku_sonohoka01());
        entity.setZenkaikekka_negaeri01(data.getZenkaikekka_negaeri01());
        entity.setZenkaikekka_okiagari01(data.getZenkaikekka_okiagari01());
        entity.setZenkaikekka_zaihoji01(data.getZenkaikekka_zaihoji01());
        entity.setZenkaikekka_ryoashidenotagu01(data.getZenkaikekka_ryoashidenotagu01());
        entity.setZenkaikekka_hoko01(data.getZenkaikekka_hoko01());
        entity.setZenkaikekka_tachiagari01(data.getZenkaikekka_tachiagari01());
        entity.setZenkaikekka_kataashidenotagu01(data.getZenkaikekka_kataashidenotagu01());
        entity.setZenkaikekka_araimi01(data.getZenkaikekka_araimi01());
        entity.setZenkaikekka_tsumekiri01(data.getZenkaikekka_tsumekiri01());
        entity.setZenkaikekka_shiryoku01(data.getZenkaikekka_shiryoku01());
        entity.setZenkaikekka_choryoku01(data.getZenkaikekka_choryoku01());
        entity.setZenkaikekka_ljo02(data.getZenkaikekka_ljo02());
        entity.setZenkaikekka_ldo02(data.getZenkaikekka_ldo02());
        entity.setZenkaikekka_enge02(data.getZenkaikekka_enge02());
        entity.setZenkaikekka_shokujisesshu02(data.getZenkaikekka_shokujisesshu02());
        entity.setZenkaikekka_hainyo02(data.getZenkaikekka_hainyo02());
        entity.setZenkaikekka_haiben02(data.getZenkaikekka_haiben02());
        entity.setZenkaikekka_kokuseiketsu02(data.getZenkaikekka_kokuseiketsu02());
        entity.setZenkaikekka_sengan02(data.getZenkaikekka_sengan02());
        entity.setZenkaikekka_seihatsu02(data.getZenkaikekka_seihatsu02());
        entity.setZenkaikekka_uwaginochakudatsu02(data.getZenkaikekka_uwaginochakudatsu02());
        entity.setZenkaikekka_zubontonochakudatsu02(data.getZenkaikekka_zubontonochakudatsu02());
        entity.setZenkaikekka_gaishutsuhindo02(data.getZenkaikekka_gaishutsuhindo02());
        entity.setZenkaikekka_lshinodentatsu03(data.getZenkaikekka_lshinodentatsu03());
        entity.setZenkaikekka_mainichinonikkaorikai03(data.getZenkaikekka_mainichinonikkaorikai03());
        entity.setZenkaikekka_seinengappioiu03(data.getZenkaikekka_seinengappioiu03());
        entity.setZenkaikekka_tankikioku03(data.getZenkaikekka_tankikioku03());
        entity.setZenkaikekka_jibunnonamaeoiu03(data.getZenkaikekka_jibunnonamaeoiu03());
        entity.setZenkaikekka_imanokisetsuorikai03(data.getZenkaikekka_imanokisetsuorikai03());
        entity.setZenkaikekka_bashonorikai03(data.getZenkaikekka_bashonorikai03());
        entity.setZenkaikekka_haikai03(data.getZenkaikekka_haikai03());
        entity.setZenkaikekka_gaishutsushitemodorenai03(data.getZenkaikekka_gaishutsushitemodorenai03());
        entity.setZenkaikekka_higaiteki04(data.getZenkaikekka_higaiteki04());
        entity.setZenkaikekka_sakubanashi04(data.getZenkaikekka_sakubanashi04());
        entity.setZenkaikekka_kanjōgafuantei04(data.getZenkaikekka_kanjōgafuantei04());
        entity.setZenkaikekka_chuyagyakuten04(data.getZenkaikekka_chuyagyakuten04());
        entity.setZenkaikekka_onajibanashiosuru04(data.getZenkaikekka_onajibanashiosuru04());
        entity.setZenkaikekka_ogoewodasu04(data.getZenkaikekka_ogoewodasu04());
        entity.setZenkaikekka_kaigoniteiko04(data.getZenkaikekka_kaigoniteiko04());
        entity.setZenkaikekka_ochitsukinashi04(data.getZenkaikekka_ochitsukinashi04());
        entity.setZenkaikekka_ichiridedetagaru04(data.getZenkaikekka_ichiridedetagaru04());
        entity.setZenkaikekka_shushuheki04(data.getZenkaikekka_shushuheki04());
        entity.setZenkaikekka_monoyairuiokowasu04(data.getZenkaikekka_monoyairuiokowasu04());
        entity.setZenkaikekka_hidoimonowasure04(data.getZenkaikekka_hidoimonowasure04());
        entity.setZenkaikekka_hitorigotohitoriwarai04(data.getZenkaikekka_hitorigotohitoriwarai04());
        entity.setZenkaikekka_jibungattenikodosuru04(data.getZenkaikekka_jibungattenikodosuru04());
        entity.setZenkaikekka_wagamatomaranai04(data.getZenkaikekka_wagamatomaranai04());
        entity.setZenkaikekka_Kusurinonaifuku05(data.getZenkaikekka_Kusurinonaifuku05());
        entity.setZenkaikekka_kinsennokanri05(data.getZenkaikekka_kinsennokanri05());
        entity.setZenkaikekka_nichijonoishikettei05(data.getZenkaikekka_nichijonoishikettei05());
        entity.setZenkaikekka_shudanenofutekio05(data.getZenkaikekka_shudanenofutekio05());
        entity.setZenkaikekka_kaimono05(data.getZenkaikekka_kaimono05());
        entity.setZenkaikekka_kantannachori05(data.getZenkaikekka_kantannachori05());
        entity.setZenkaikekka_tentekinokanri(data.getZenkaikekka_tentekinokanri());
        entity.setZenkaikekka_chushinjomyakueiyo(data.getZenkaikekka_chushinjomyakueiyo());
        entity.setZenkaikekka_toseki(data.getZenkaikekka_toseki());
        entity.setZenkaikekka_sutomanoshochi(data.getZenkaikekka_sutomanoshochi());
        entity.setZenkaikekka_sansoryoho(data.getZenkaikekka_sansoryoho());
        entity.setZenkaikekka_resupireta(data.getZenkaikekka_resupireta());
        entity.setZenkaikekka_kikansekkainoshochitotsunokango(data.getZenkaikekka_kikansekkainoshochitotsunokango());
        entity.setZenkaikekka_keikaneiyo(data.getZenkaikekka_keikaneiyo());
        entity.setZenkaikekka_monitasokutei(data.getZenkaikekka_monitasokutei());
        entity.setZenkaikekka_jiyokusounoshochi(data.getZenkaikekka_jiyokusounoshochi());
        entity.setZenkaikekka_kateteru(data.getZenkaikekka_kateteru());
        entity.setZenkaikekka_shogaikorei(data.getZenkaikekka_shogaikorei());
        entity.setZenkaikekka_shajiritsudo(data.getZenkaikekka_shajiritsudo());
        entity.setZenkaikekka_ninshishokoreishajiritsudo(data.getZenkaikekka_ninshishokoreishajiritsudo());
        entity.setZenkaikekka_ichijihanteikekka(data.getZenkaikekka_ichijihanteikekka());
        entity.setZenkaikekka_ichijihanteikekka_ninshishokasan(data.getZenkaikekka_ichijihanteikekka_ninshishokasan());
        entity.setZenkaikekka_yokaigojikan(data.getZenkaikekka_yokaigojikan());
        entity.setZenkaikekka_yokaigojikan_shokuji(data.getZenkaikekka_yokaigojikan_shokuji());
        entity.setZenkaikekka_yokaigojikan_haisetsu(data.getZenkaikekka_yokaigojikan_haisetsu());
        entity.setZenkaikekka_yokaigojikan_ldo(data.getZenkaikekka_yokaigojikan_ldo());
        entity.setZenkaikekka_yokaigojikan_seiketsuhoji(data.getZenkaikekka_yokaigojikan_seiketsuhoji());
        entity.setZenkaikekka_yokaigojikan_kansetsukea(data.getZenkaikekka_yokaigojikan_kansetsukea());
        entity.setZenkaikekka_yokaigojikan_kanren(data.getZenkaikekka_yokaigojikan_kanren());
        entity.setZenkaikekka_yokaigojikan_kinokunren(data.getZenkaikekka_yokaigojikan_kinokunren());
        entity.setZenkaikekka_yokaigojikan_iryokanren(data.getZenkaikekka_yokaigojikan_iryokanren());
        entity.setZenkaikekka_yokaigojikan_ninshishokasan(data.getZenkaikekka_yokaigojikan_ninshishokasan());
        entity.setZenkaikekka_chukanhyokakomokutokutendai1_gun(data.getZenkaikekka_chukanhyokakomokutokutendai1_gun());
        entity.setZenkaikekka_chukanhyokakomokutokutendai2_gun(data.getZenkaikekka_chukanhyokakomokutokutendai2_gun());
        entity.setZenkaikekka_chukanhyokakomokutokutendai3_gun(data.getZenkaikekka_chukanhyokakomokutokutendai3_gun());
        entity.setZenkaikekka_chukanhyokakomokutokutendai4_gun(data.getZenkaikekka_chukanhyokakomokutokutendai4_gun());
        entity.setZenkaikekka_chukanhyokakomokutokutendai5_gun(data.getZenkaikekka_chukanhyokakomokutokutendai5_gun());
        entity.setZenkaikekka_kodo(data.getZenkaikekka_kodo());
        entity.setZenkaikekka_jotainoanteisei(data.getZenkaikekka_jotainoanteisei());
        entity.setZenkaikekka_ninshishojiritsudo(data.getZenkaikekka_ninshishojiritsudo());
        entity.setZenkaikekka_ninchikinokyufukubun(data.getZenkaikekka_ninchikinokyufukubun());
        entity.setZenkaikekka_shinseibi(data.getZenkaikekka_shinseibi());
        entity.setZenkaikekka_nijihanteibi(data.getZenkaikekka_nijihanteibi());
        entity.setZenkaikekka_genzainosabisukubunkodo(data.getZenkaikekka_genzainosabisukubunkodo());
        entity.setZenkaikekka_genzainojokyo(data.getZenkaikekka_genzainojokyo());
        entity.setZenkaikekka_homonkaigo_homuherupusabisu(data.getZenkaikekka_homonkaigo_homuherupusabisu());
        entity.setZenkaikekka_homonnyuyokukaigo(data.getZenkaikekka_homonnyuyokukaigo());
        entity.setZenkaikekka_homonkango(data.getZenkaikekka_homonkango());
        entity.setZenkaikekka_homonrihabiriteshon(data.getZenkaikekka_homonrihabiriteshon());
        entity.setZenkaikekka_kyotakuryoyokanrishido(data.getZenkaikekka_kyotakuryoyokanrishido());
        entity.setZenkaikekka_tsushokaigo_deisabisu(data.getZenkaikekka_tsushokaigo_deisabisu());
        entity.setZenkaikekka_tsushorihabiriteshon(data.getZenkaikekka_tsushorihabiriteshon());
        entity.setZenkaikekka_tankinyushoseikatsukaigo_shotosutei(data.getZenkaikekka_tankinyushoseikatsukaigo_shotosutei());
        entity.setZenkaikekka_tankinyushoryoyokaigo(data.getZenkaikekka_tankinyushoryoyokaigo());
        entity.setZenkaikekka_tokuteishisetsunyukyoshaseikatsukaigo(data.getZenkaikekka_tokuteishisetsunyukyoshaseikatsukaigo());
        entity.setZenkaikekka_fukushiyogutaiyo(data.getZenkaikekka_fukushiyogutaiyo());
        entity.setZenkaikekka_tokuteifukushiyoguhanbai(data.getZenkaikekka_tokuteifukushiyoguhanbai());
        entity.setZenkaikekka_jutakukaishukaigokyufu(data.getZenkaikekka_jutakukaishukaigokyufu());
        entity.setZenkaikekka_yakantaiogatahomonkaigo(data.getZenkaikekka_yakantaiogatahomonkaigo());
        entity.setZenkaikekka_ninchishotaiogatasushokaigo(data.getZenkaikekka_ninchishotaiogatasushokaigo());
        entity.setZenkaikekka_shokibotakinogatakyotakukaigo(data.getZenkaikekka_shokibotakinogatakyotakukaigo());
        entity.setZenkaikekka_ninshishokaigo_gurupuhomu(data.getZenkaikekka_ninshishokaigo_gurupuhomu());
        entity.setZenkaikekka_chiikimitchakugataseikatsukaigo(data.getZenkaikekka_chiikimitchakugataseikatsukaigo());
        entity.setZenkaikekka_mitchakugatarojinkaigo(data.getZenkaikekka_mitchakugatarojinkaigo());
        entity.setZenkaikekka_teikijunkai_zuijihomonkaigokango(data.getZenkaikekka_teikijunkai_zuijihomonkaigokango());
        entity.setZenkaikekka_fukugogatasabisu(data.getZenkaikekka_fukugogatasabisu());
        entity.setZenkaikekka_kaigoyobohomonkaigo_homuherupusabisu(data.getZenkaikekka_kaigoyobohomonkaigo_homuherupusabisu());
        entity.setZenkaikekka_kaigoyobohomonnyuyokukaigo(data.getZenkaikekka_kaigoyobohomonnyuyokukaigo());
        entity.setZenkaikekka_kaigoyobohomonkango(data.getZenkaikekka_kaigoyobohomonkango());
        entity.setZenkaikekka_kaigoyobohomonrihabiriteshon(data.getZenkaikekka_kaigoyobohomonrihabiriteshon());
        entity.setZenkaikekka_kaigoyobokyotakuryoyokanrishido(data.getZenkaikekka_kaigoyobokyotakuryoyokanrishido());
        entity.setZenkaikekka_kaigoyobotsushokaigo_deisabisu(data.getZenkaikekka_kaigoyobotsushokaigo_deisabisu());
        entity.setZenkaikekka_kaigoyobotsushorihabiriteshon(data.getZenkaikekka_kaigoyobotsushorihabiriteshon());
        entity.setZenkaikekka_kaigoyobotankiseikatsukaigo(data.getZenkaikekka_kaigoyobotankiseikatsukaigo());
        entity.setZenkaikekka_kaigoyobotankinyushoryoyokaigo(data.getZenkaikekka_kaigoyobotankinyushoryoyokaigo());
        entity.setZenkaikekka_yobotokuteishisetsunyukyoshakaigo(data.getZenkaikekka_yobotokuteishisetsunyukyoshakaigo());
        entity.setZenkaikekka_kaigoyobofukushiyogutaiyo(data.getZenkaikekka_kaigoyobofukushiyogutaiyo());
        entity.setZenkaikekka_tokuteikaigoyobofukushiyoguhanbai(data.getZenkaikekka_tokuteikaigoyobofukushiyoguhanbai());
        entity.setZenkaikekka_jutakukaishu_yobokyufu(data.getZenkaikekka_jutakukaishu_yobokyufu());
        entity.setZenkaikekka_kaigoyoboninchishotaiogatatsushokaigo(data.getZenkaikekka_kaigoyoboninchishotaiogatatsushokaigo());
        entity.setZenkaikekka_kaigoyoboshokibotakinogatakyotakukaigo(data.getZenkaikekka_kaigoyoboshokibotakinogatakyotakukaigo());
        entity.setZenkaikekka_yoboninshishokaigo_gurupuhomu(data.getZenkaikekka_yoboninshishokaigo_gurupuhomu());
        entity.setZenkaishikibetsukodo(data.getZenkaishikibetsukodo());
        entity.setNinteishinsakaiikento(data.getNinteishinsakaiikento());
        entity.setKomentoto(data.getKomentoto());
        return entity;

    }
}
