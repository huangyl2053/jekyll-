/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.dbd519001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd519001.MakeNinteiShinseiJohoFileProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd519001.MakeNinteiShinseiJohoFileCsvDensanEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd519001.temp.KouikiyoukaigoNinteishinseiJouhouTempEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.EucFileOutputJokenhyoItem;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;

/**
 * 申請情報IFファイル作成_business処理クラスです。
 *
 * @reamsid_L DBD-1480-020 liuyl
 */
public class MakeNinteiShinseiJohoFileManager {

    private static final RString 連携データ種類 = new RString("【連携データ種類】");
    private static final RString 証記載保険者番号 = new RString("【証記載保険者番号】");
    private static final RString 市町村コード = new RString("【市町村コード】");
    private static final RString 被保険者番号 = new RString("【被保険者番号】");
    private static final RString 抽出開始日時 = new RString("【抽出開始日時】");
    private static final RString 抽出終了日時 = new RString("【抽出終了日時】");

    /**
     * 申請情報IFファイル作成。
     *
     * @param entity KouikiyoukaigoNinteishinseiJouhouTempEntity
     * @return MakeNinteiShinseiJohoFileCsvDensanEntity
     */
    public MakeNinteiShinseiJohoFileCsvDensanEntity createMakeNinteiShinseiJohoFileCsvDensanEntity(
            KouikiyoukaigoNinteishinseiJouhouTempEntity entity) {
        MakeNinteiShinseiJohoFileCsvDensanEntity csvEntity = new MakeNinteiShinseiJohoFileCsvDensanEntity();
        csvEntity.setAge(entity.getAge());
        csvEntity.setByouinShisetsutouMeishou(entity.getByouinShisetsutouMeishou());
        csvEntity.setByouinShisetsutoujuusho(entity.getByouinShisetsutoujuusho());
        csvEntity.setChousaiCode(entity.getChousaiCode());
        csvEntity.setHihokenshaKubunCodeo(entity.getHihokenshaKubunCodeo());
        csvEntity.setHihokenshaNo(entity.getHihokenshaNo());
        csvEntity.setHokenshaNo(entity.getHokenshaNo());
        csvEntity.setHonninKankei(entity.getHonninKankei());
        csvEntity.setHonninKinkyuurenrakuJosho1(entity.getHonninKinkyuurenrakuJosho1());
        csvEntity.setHonninKinkyuurenrakuJosho2(entity.getHonninKinkyuurenrakuJosho2());
        csvEntity.setHonninKinkyuurenrakuMeishou1(entity.getHonninKinkyuurenrakuMeishou1());
        csvEntity.setHonninKinkyuurenrakuMeishou2(entity.getHonninKinkyuurenrakuMeishou2());
        csvEntity.setHonninKinkyuurenrakuNo1(entity.getHonninKinkyuurenrakuNo1());
        csvEntity.setHonninKinkyuurenrakuNo2(entity.getHonninKinkyuurenrakuNo2());
        csvEntity.setHonninRenrakusaki1(entity.getHonninRenrakusaki1());
        csvEntity.setHonninRenrakusaki2(entity.getHonninRenrakusaki2());
        csvEntity.setIkenshoDentatsuNouryoku(entity.getIkenshoDentatsuNouryoku());
        csvEntity.setIkenshoIraiYMD(entity.getIkenshoIraiYMD());
        csvEntity.setIkenshoNinchinouryoku(entity.getIkenshoNinchinouryoku());
        csvEntity.setIkenshoNyuushuYMD(entity.getIkenshoNyuushuYMD());
        csvEntity.setIkenshoShokuji(entity.getIkenshoShokuji());
        csvEntity.setIkenshoTankikioku(entity.getIkenshoTankikioku());
        csvEntity.setJuusho(entity.getJuusho());
        csvEntity.setKinouCode(entity.getKinouCode());
        csvEntity.setKomento(entity.getKomento());
        csvEntity.setNinchiShouKoureishaDo(entity.getNinchiShouKoureishaDo());
        csvEntity.setNinteiShinseiYMD(entity.getNinteiShinseiYMD());
        csvEntity.setNyuushoJigyoushoCode(entity.getNyuushoJigyoushoCode());
        csvEntity.setNyuushoShisetsuYoubinNo(entity.getNyuushoShisetsuYoubinNo());
        csvEntity.setNyuushoShisetsukana(entity.getNyuushoShisetsukana());
        csvEntity.setNyuushoShisetsutelNo(entity.getNyuushoShisetsutelNo());
        csvEntity.setSeibetsu(entity.getSeibetsu());
        csvEntity.setSeinengappiYMD(entity.getSeinengappiYMD());
        csvEntity.setShichousonCode(entity.getShichousonCode());
        csvEntity.setShikensharuNo(entity.getShikensharuNo());
        csvEntity.setShikibetsuCode(entity.getShikibetsuCode());
        csvEntity.setShimei(entity.getShimei());
        csvEntity.setShimeiKana(entity.getShimeiKana());
        csvEntity.setShinseiDaikouKubunCode(entity.getShinseiDaikouKubunCode());
        csvEntity.setShinseiJigyoushaKana(entity.getShinseiJigyoushaKana());
        csvEntity.setShinseiJigyoushaName(entity.getShinseiJigyoushaName());
        csvEntity.setShinseiKubunHoureiCode(entity.getShinseiKubunHoureiCode());
        csvEntity.setShinseiKubunShinseijiCode(entity.getShinseiKubunShinseijiCode());
        csvEntity.setShinseishaJosho(entity.getShinseishaJosho());
        csvEntity.setShinseishaKankeiCode(entity.getShinseishaKankeiCode());
        csvEntity.setShinseishaRenrakusaki(entity.getShinseishaRenrakusaki());
        csvEntity.setShinseishaShimei(entity.getShinseishaShimei());
        csvEntity.setShinseishaShimeiKana(entity.getShinseishaShimeiKana());
        csvEntity.setShinseishaYoubinNo(entity.getShinseishaYoubinNo());
        csvEntity.setShuKiHojoKoumoku(entity.getShuKiHojoKoumoku());
        csvEntity.setShujiiIryoukikanCode(entity.getShujiiIryoukikanCode());
        csvEntity.setShujiiNo(entity.getShujiiNo());
        csvEntity.setTokuteiShippeiCode(entity.getTokuteiShippeiCode());
        csvEntity.setTorisageKubunCode(entity.getTorisageKubunCode());
        csvEntity.setYuubinNo(entity.getYuubinNo());
        csvEntity.setZaihoji(entity.getZaihoji());
        setCsvDensanEntity(csvEntity, entity);
        return csvEntity;
    }

    private void setCsvDensanEntity(MakeNinteiShinseiJohoFileCsvDensanEntity csvEntity, KouikiyoukaigoNinteishinseiJouhouTempEntity entity) {
        csvEntity.setZenkaiKekkaBPSDkanren(entity.getZenkaiKekkaBPSDkanren());
        csvEntity.setZenkaiKekkaBashonoRikai(entity.getZenkaiKekkaBashonoRikai());
        csvEntity.setZenkaiKekkaChiikimitchakukeikaigoroujin(entity.getZenkaiKekkaChiikimitchakukeikaigoroujin());
        csvEntity.setZenkaiKekkaChouryoku(entity.getZenkaiKekkaChouryoku());
        csvEntity.setZenkaiKekkaChuukanHyouka1(entity.getZenkaiKekkaChuukanHyouka1());
        csvEntity.setZenkaiKekkaChuukanHyouka2(entity.getZenkaiKekkaChuukanHyouka2());
        csvEntity.setZenkaiKekkaChuukanHyouka3(entity.getZenkaiKekkaChuukanHyouka3());
        csvEntity.setZenkaiKekkaChuukanHyouka4(entity.getZenkaiKekkaChuukanHyouka4());
        csvEntity.setZenkaiKekkaChuukanHyouka5(entity.getZenkaiKekkaChuukanHyouka5());
        csvEntity.setZenkaiKekkaChuushinJoumyakuEiyou(entity.getZenkaiKekkaChuushinJoumyakuEiyou());
        csvEntity.setZenkaiKekkaChuuyagyakuten(entity.getZenkaiKekkaChuuyagyakuten());
        csvEntity.setZenkaiKekkaEnKa(entity.getZenkaiKekkaEnKa());
        csvEntity.setZenkaiKekkaFukugougatasabisu(entity.getZenkaiKekkaFukugougatasabisu());
        csvEntity.setZenkaiKekkaFukushiYouguTaiyo(entity.getZenkaiKekkaFukushiYouguTaiyo());
        csvEntity.setZenkaiKekkaGaishutsushiteMotorenai(entity.getZenkaiKekkaGaishutsushiteMotorenai());
        csvEntity.setZenkaiKekkaGenzainoJoukyou(entity.getZenkaiKekkaGenzainoJoukyou());
        csvEntity.setZenkaiKekkaGenzainosabisuKubunCode(entity.getZenkaiKekkaGenzainosabisuKubunCode());
        csvEntity.setZenkaiKekkaHaiben(entity.getZenkaiKekkaHaiben());
        csvEntity.setZenkaiKekkaHeKanEiyou(entity.getZenkaiKekkaHeKanEiyou());
        csvEntity.setZenkaiKekkaHidoimonowasure(entity.getZenkaiKekkaHidoimonowasure());
        csvEntity.setZenkaiKekkaHigaiteki(entity.getZenkaiKekkaHigaiteki());
        csvEntity.setZenkaiKekkaHitorideDetagaru(entity.getZenkaiKekkaHitorideDetagaru());
        csvEntity.setZenkaiKekkaHitorigotoHitoriwarai(entity.getZenkaiKekkaHitorigotoHitoriwarai());
        csvEntity.setZenkaiKekkaHokou(entity.getZenkaiKekkaHokou());
        csvEntity.setZenkaiKekkaHomuherupusabisu(entity.getZenkaiKekkaHomuherupusabisu());
        csvEntity.setZenkaiKekkaHoumonNyuuyokuKaigo(entity.getZenkaiKekkaHoumonkaigohomuherupusabisu());
        csvEntity.setZenkaiKekkaHoumonkaigohomuherupusabisu(entity.getZenkaiKekkaHoumonkaigohomuherupusabisu());
        csvEntity.setZenkaiKekkaHoumonkaigokango(entity.getZenkaiKekkaHoumonkaigokango());
        csvEntity.setZenkaiKekkaHoumonkango(entity.getZenkaiKekkaHoumonkango());
        csvEntity.setZenkaiKekkaHoumonrihabiriteshon(entity.getZenkaiKekkaHoumonrihabiriteshon());
        csvEntity.setZenkaiKekkaIchijiHanteiKeikokuCode(entity.getZenkaiKekkaIchijiHanteiKeikokuCode());
        csvEntity.setZenkaiKekkaIchijiHanteikekka(entity.getZenkaiKekkaIchijiHanteikekka());
        csvEntity.setZenkaiKekkaIdou(entity.getZenkaiKekkaIdou());
        csvEntity.setZenkaiKekkaIjou(entity.getZenkaiKekkaIjou());
        csvEntity.setZenkaiKekkaImanoKisetsuwoRikai(entity.getZenkaiKekkaImanoKisetsuwoRikai());
        csvEntity.setZenkaiKekkaIryoukanren(entity.getZenkaiKekkaIryoukanren());
        csvEntity.setZenkaiKekkaIshinoDentatsu(entity.getZenkaiKekkaIshinoDentatsu());
        csvEntity.setZenkaiKekkaJibunkatteniKoudousuru(entity.getZenkaiKekkaJibunkatteniKoudousuru());
        csvEntity.setZenkaiKekkaJibunnoNamaewoiu(entity.getZenkaiKekkaJibunnoNamaewoiu());
        csvEntity.setZenkaiKekkaJokusounoShochi(entity.getZenkaiKekkaJokusounoShochi());
        csvEntity.setZenkaiKekkaJoujinoHaikai(entity.getZenkaiKekkaJoujinoHaikai());
        csvEntity.setZenkaiKekkaJoutaiKubun(entity.getZenkaiKekkaJoutaiKubun());
        csvEntity.setZenkaiKekkaJoutainoAnteisei(entity.getZenkaiKekkaJoutainoAnteisei());
        csvEntity.setZenkaiKekkaJuutakuKaishuu(entity.getZenkaiKekkaJuutakuKaishuu());
        csvEntity.setZenkaiKekkaJuutakuKaishuukaigoKyuufu(entity.getZenkaiKekkaJuutakuKaishuukaigoKyuufu());
        csvEntity.setZenkaiKekkaKaigoRyouyoukanriShidou(entity.getZenkaiKekkaKaigoRyouyoukanriShidou());
        csvEntity.setZenkaiKekkaKaigoYobouFukushiYouguTaiyo(entity.getZenkaiKekkaKaigoYobouFukushiYouguTaiyo());
        csvEntity.setZenkaiKekkaKaigoYobouHoumonNyuuyokukaigo(entity.getZenkaiKekkaKaigoYobouHoumonNyuuyokukaigo());
        csvEntity.setZenkaiKekkaKaigoYobouHoumonkango(entity.getZenkaiKekkaKaigoYobouHoumonkango());
        csvEntity.setZenkaiKekkaKaigoYobouHoumonrihabiriteshon(entity.getZenkaiKekkaKaigoYobouHoumonrihabiriteshon());
        csvEntity.setZenkaiKekkaKaigoYobouTokuteishisetsu(entity.getZenkaiKekkaKaigoYobouTokuteishisetsu());
        csvEntity.setZenkaiKekkaKaigoYobouTsuushoKaigodeisabisu(entity.getZenkaiKekkaKaigoYobouTsuushoKaigodeisabisu());
        csvEntity.setZenkaiKekkaKaigoYobouTsuushorihabiriteshon(entity.getZenkaiKekkaKaigoYobouTsuushorihabiriteshon());
        csvEntity.setZenkaiKekkaKaigoyobouTankiNyuushosei(entity.getZenkaiKekkaKaigoyobouTankiNyuushosei());
        csvEntity.setZenkaiKekkaKaigoniTeikou(entity.getZenkaiKekkaKaigoniTeikou());
        csvEntity.setZenkaiKekkaKaigoshotosutei(entity.getZenkaiKekkaKaigoshotosutei());
        csvEntity.setZenkaiKekkaKaimono(entity.getZenkaiKekkaKaimono());
        csvEntity.setZenkaiKekkaKanjougaFuantei(entity.getZenkaiKekkaKanjougaFuantei());
        csvEntity.setZenkaiKekkaKansetsukea(entity.getZenkaiKekkaKansetsukea());
        csvEntity.setZenkaiKekkaKantannaChouri(entity.getZenkaiKekkaKantannaChouri());
        csvEntity.setZenkaiKekkaKataashiDeNoRitsui(entity.getZenkaiKekkaKataashiDeNoRitsui());
        csvEntity.setZenkaiKekkaKateteru(entity.getZenkaiKekkaKateteru());
        csvEntity.setZenkaiKekkaKijunJikan(entity.getZenkaiKekkaKijunJikan());
        csvEntity.setZenkaiKekkaKijunJikanHaisetsu(entity.getZenkaiKekkaKijunJikanHaisetsu());
        csvEntity.setZenkaiKekkaKijunJikanIdou(entity.getZenkaiKekkaKijunJikanIdou());
        csvEntity.setZenkaiKekkaKijunJikanSeiketsuhoji(entity.getZenkaiKekkaKijunJikanSeiketsuhoji());
        csvEntity.setZenkaiKekkaKijunJikanShokuji(entity.getZenkaiKekkaKijunJikanShokuji());
        csvEntity.setZenkaiKekkaKikanSekkainoShochi(entity.getZenkaiKekkaKikanSekkainoShochi());
        csvEntity.setZenkaiKekkaKinoukunren(entity.getZenkaiKekkaKinoukunren());
        csvEntity.setZenkaiKekkaKinsennoKanri(entity.getZenkaiKekkaKinsennoKanri());
        csvEntity.setZenkaiKekkaKoushukuKatakansetsu(entity.getZenkaiKekkaKoushukuKatakansetsu());
        csvEntity.setZenkaiKekkaKoushukuKokansetsu(entity.getZenkaiKekkaKoushukuKokansetsu());
        csvEntity.setZenkaiKekkaKoushukuSonoTa(entity.getZenkaiKekkaKoushukuSonoTa());
        csvEntity.setZenkaiKekkaKyotakuRyouyouKanrishidou(entity.getZenkaiKekkaKyotakuRyouyouKanrishidou());
        csvEntity.setZenkaiKekkaKyotakukaigo(entity.getZenkaiKekkaKyotakukaigo());
        csvEntity.setZenkaiKekkaKyoudouseikatsuKaigo(entity.getZenkaiKekkaKyoudouseikatsuKaigo());
        csvEntity.setZenkaiKekkaMainichinoNikkawoRikai(entity.getZenkaiKekkaMainichinoNikkawoRikai());
        csvEntity.setZenkaiKekkaMonitaSokutei(entity.getZenkaiKekkaMonitaSokutei());
        csvEntity.setZenkaiKekkaMonoyaIruiwoKowasu(entity.getZenkaiKekkaMonoyaIruiwoKowasu());
        csvEntity.setZenkaiKekkaNegaeri(entity.getZenkaiKekkaNegaeri());
        csvEntity.setZenkaiKekkaNichijounoIshikettei(entity.getZenkaiKekkaNichijounoIshikettei());
        csvEntity.setZenkaiKekkaNijiHanteiYMD(entity.getZenkaiKekkaNijiHanteiYMD());
        csvEntity.setZenkaiKekkaNinKunchiShouKazan(entity.getZenkaiKekkaNinKunchiShouKazan());
        csvEntity.setZenkaiKekkaNinchiShouJiritsudo2(entity.getZenkaiKekkaNinchiShouJiritsudo2());
        csvEntity.setZenkaiKekkaNinchiShouKoureishaJiritsudo(entity.getZenkaiKekkaNinchiShouKoureishaJiritsudo());
        csvEntity.setZenkaiKekkaNinchiShoutaiougata(entity.getZenkaiKekkaNinchiShoutaiougata());
        csvEntity.setZenkaiKekkaNinchishouTaiougataTsuushoKaigo(entity.getZenkaiKekkaNinchishouTaiougataTsuushoKaigo());
        csvEntity.setZenkaiKekkaNinchishoukazan(entity.getZenkaiKekkaNinchishoukazan());
        csvEntity.setZenkaiKekkaNyuukyoshaSeikatsukaigo(entity.getZenkaiKekkaNyuukyoshaSeikatsukaigo());
        csvEntity.setZenkaiKekkaOchitsukinashi(entity.getZenkaiKekkaOchitsukinashi());
        csvEntity.setZenkaiKekkaOkiagari(entity.getZenkaiKekkaOkiagari());
        csvEntity.setZenkaiKekkaOnnajiwawosuru(entity.getZenkaiKekkaOnnajiwawosuru());
        csvEntity.setZenkaiKekkaRyouashideNoritsui(entity.getZenkaiKekkaRyouashideNoritsui());
        csvEntity.setZenkaiKekkaRyouyouKaigo(entity.getZenkaiKekkaRyouyouKaigo());
        csvEntity.setZenkaiKekkaSakuwa(entity.getZenkaiKekkaSakuwa());
        csvEntity.setZenkaiKekkaSansoRyouhou(entity.getZenkaiKekkaSansoRyouhou());
        csvEntity.setZenkaiKekkaSeihatsu(entity.getZenkaiKekkaSeihatsu());
        csvEntity.setZenkaiKekkaSeikatsukaigo(entity.getZenkaiKekkaSeikatsukaigo());
        csvEntity.setZenkaiKekkaSeinengappiwoiu(entity.getZenkaiKekkaSeinengappiwoiu());
        csvEntity.setZenkaiKekkaSenShin(entity.getZenkaiKekkaSenShin());
        csvEntity.setZenkaiKekkaSengan(entity.getZenkaiKekkaSengan());
        csvEntity.setZenkaiKekkaShinseiYMD(entity.getZenkaiKekkaShinseiYMD());
        csvEntity.setZenkaiKekkaShiryoku(entity.getZenkaiKekkaShiryoku());
        csvEntity.setZenkaiKekkaShokuHainyou(entity.getZenkaiKekkaShokuHainyou());
        csvEntity.setZenkaiKekkaShokujiSesshu(entity.getZenkaiKekkaShokujiSesshu());
        csvEntity.setZenkaiKekkaShougaiKoureishaJiritsudo(entity.getZenkaiKekkaShougaiKoureishaJiritsudo());
        csvEntity.setZenkaiKekkaShoukiboTakinouKeiKyotakuKaigo(entity.getZenkaiKekkaShoukiboTakinouKeiKyotakuKaigo());
        csvEntity.setZenkaiKekkaShuudanhenoFutekiou(entity.getZenkaiKekkaShuudanhenoFutekiou());
        csvEntity.setZenkaiKekkaShuushuuheki(entity.getZenkaiKekkaShuushuuheki());
        csvEntity.setZenkaiKekkaSotodehindo(entity.getZenkaiKekkaSotodehindo());
        csvEntity.setZenkaiKekkaSutomanoShochi(entity.getZenkaiKekkaSutomanoShochi());
        csvEntity.setZenkaiKekkaTachiagari(entity.getZenkaiKekkaTachiagari());
        csvEntity.setZenkaiKekkaTaiseiwodasu(entity.getZenkaiKekkaTaiseiwodasu());
        csvEntity.setZenkaiKekkaTankikioku(entity.getZenkaiKekkaTankikioku());
        csvEntity.setZenkaiKekkaTentekiKanri(entity.getZenkaiKekkaTentekiKanri());
        csvEntity.setZenkaiKekkaTokuteiFukushiYouguHambai(entity.getZenkaiKekkaTokuteiFukushiYouguHambai());
        csvEntity.setZenkaiKekkaTokuteiKaigoYobouFukushi(entity.getZenkaiKekkaTokuteiKaigoYobouFukushi());
        csvEntity.setZenkaiKekkaTouseki(entity.getZenkaiKekkaTouseki());
        csvEntity.setZenkaiKekkaToutsuunoKango(entity.getZenkaiKekkaToutsuunoKango());
        csvEntity.setZenkaiKekkaTsuMeKiri(entity.getZenkaiKekkaTsuMeKiri());
        csvEntity.setZenkaiKekkaTsuushoKaigo(entity.getZenkaiKekkaTsuushoKaigo());
        csvEntity.setZenkaiKekkaTsuushoKaigodeisabisu(entity.getZenkaiKekkaTsuushoKaigodeisabisu());
        csvEntity.setZenkaiKekkaTsuushorihabiriteshon(entity.getZenkaiKekkaTsuushorihabiriteshon());
        csvEntity.setZenkaiKekkaWagamatomaranai(entity.getZenkaiKekkaWagamatomaranai());
        csvEntity.setZenkaiKekkaYakanTaiougataHoumonkaigo(entity.getZenkaiKekkaYakanTaiougataHoumonkaigo());
        csvEntity.setZenkaiKekkaYakunoNaifuku(entity.getZenkaiKekkaYakunoNaifuku());
        csvEntity.setZenkaiKekkaZuBontounoChakudatsu(entity.getZenkaiKekkaZuBontounoChakudatsu());
        csvEntity.setZenkaiKekkajouinoChakudatsu(entity.getZenkaiKekkajouinoChakudatsu());
        csvEntity.setZenkaiKekkakoukuuSeiketsu(entity.getZenkaiKekkakoukuuSeiketsu());
        csvEntity.setZenkaiKekkanyuushoRyouyoukaigo(entity.getZenkaiKekkanyuushoRyouyoukaigo());
        csvEntity.setZenkaiKekkaresupireta(entity.getZenkaiKekkaresupireta());
        csvEntity.setZenkaiNinteiYuukoukaishikikan(entity.getZenkaiNinteiYuukoukaishikikan());
        csvEntity.setZenkaiNinteiYuukoushuuryoukikan(entity.getZenkaiNinteiYuukoushuuryoukikan());
        csvEntity.setZenkaiShikibetsuCode(entity.getZenkaiShikibetsuCode());
        csvEntity.setZenkaiShinsakaiKekka(entity.getZenkaiShinsakaiKekka());
        csvEntity.setZenkaikekkaMahiSonoTa(entity.getZenkaikekkaMahiSonoTa());
        csvEntity.setZenkaikekkaMahiyuuJoushi(entity.getZenkaikekkaMahiyuuJoushi());
        csvEntity.setZenkaikekkaMahiyuuKashi(entity.getZenkaikekkaMahiyuuKashi());
        csvEntity.setZenkaikekkaMahizaJoushi(entity.getZenkaikekkaMahizaJoushi());
        csvEntity.setZenkaikekkaMahizaKashi(entity.getZenkaikekkaMahizaKashi());
    }

    /**
     * バッチ出力条件リストの出力。
     *
     * @param parameter MakeNinteiShinseiJohoFileProcessParameter
     * @param 地方公共団体 Association
     * @return EucFileOutputJokenhyoItem
     */
    public EucFileOutputJokenhyoItem バッチ出力条件リストの出力(MakeNinteiShinseiJohoFileProcessParameter parameter, Association 地方公共団体) {
        RString ファイル名 = new RString("要介護認定申請連携データ送信ファイル");
        RString 導入団体コード = 地方公共団体.getLasdecCode_().getColumnValue();
        RString 市町村名 = 地方公共団体.get市町村名();
        RString ジョブ番号 = new RString(String.valueOf(JobContextHolder.getJobId()));
        RString ァイル名 = parameter.get連携ファイル名();
        List<RString> 出力条件 = new ArrayList<>();
        出力条件.add(連携データ種類.concat(parameter.get連携データ種類()));
        if (parameter.get証記載保険者番号() != null) {
            出力条件.add(証記載保険者番号.concat(parameter.get証記載保険者番号()));
        } else {
            出力条件.add(証記載保険者番号.concat(RString.HALF_SPACE));
        }
        if (parameter.get市町村コード() != null) {
            出力条件.add(市町村コード.concat(parameter.get市町村コード().value()));
        } else {
            出力条件.add(市町村コード.concat(RString.HALF_SPACE));
        }
        出力条件.add(被保険者番号.concat(parameter.get被保険者番号().value()));
        if (parameter.get抽出開始日時() != null) {
            出力条件.add(抽出開始日時.concat(parameter.get抽出開始日時().toString()));
        } else {
            出力条件.add(抽出開始日時.concat(RString.HALF_SPACE));
        }
        if (parameter.get抽出終了日時() != null) {
            出力条件.add(抽出終了日時.concat(parameter.get抽出終了日時().toString()));
        } else {
            出力条件.add(抽出終了日時.concat(RString.HALF_SPACE));
        }
        EucFileOutputJokenhyoItem item = new EucFileOutputJokenhyoItem(
                ファイル名,
                導入団体コード,
                市町村名,
                ジョブ番号,
                ァイル名,
                RString.EMPTY,
                RString.EMPTY,
                出力条件);
        return item;
    }

    /**
     * アクセスログを出力。
     *
     * @param entity KouikiyoukaigoNinteishinseiJouhouTempEntity
     * @return PersonalData
     */
    public PersonalData toPersonalData(KouikiyoukaigoNinteishinseiJouhouTempEntity entity) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(new RString("0003")), new RString("被保険者番号"),
                entity.getHihokenshaNo());
        return PersonalData.of(ShikibetsuCode.EMPTY, expandedInfo);
    }
}
