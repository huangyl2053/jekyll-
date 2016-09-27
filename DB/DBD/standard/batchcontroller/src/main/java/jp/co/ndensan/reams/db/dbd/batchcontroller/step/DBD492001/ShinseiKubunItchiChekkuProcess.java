/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD492001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001.ErrorRecord;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001.HenKouData;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001.ShinseiKubunItchiChekkuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001.ichijiteburu.FairudetaIchijiTeburuEntity;
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
        error.setShikibetsukodo(entity.get識別コード());
        error.setHokenshabango(entity.get保険者番号());
        error.setHihokenjabango(entity.get被保険者番号());
        error.setNinteishinseibi(entity.get認定申請日());
        error.setEdaban(entity.get枝番());
        error.setShinseikubunhorei(entity.get申請区分_法令コード());
        error.setShinseikubunshinseiji(entity.get申請区分_申請時コード());
        error.setTorisakubunkodo(entity.get取下区分コード());
        error.setHihokenjakubun(entity.get被保険者区分コード());
        error.setShinseidaikokubun(entity.get申請代行区分コード());
        error.setSeinengappi(entity.get生年月日());
        error.setNenrei(entity.get年齢());
        error.setSeibetsukodo(entity.get性別コード());
        error.setHihokenjakanashimei(entity.get被保険者ｶﾅ氏名());
        error.setHihokenjakanjishimei(entity.get被保険者漢字氏名());
        error.setYubenbango(entity.get郵便番号());
        error.setJusho(entity.get住所());
        error.setTenwabango(entity.get電話番号());
        error.setByoinshisetsutonomeisho(entity.get病院施設等の名称());
        error.setByoinshisetsutonoshozaichi(entity.get病院施設等の所在地());
        errorRecordList.add(error);
//    } else {
        FairudetaIchijiTeburuEntity fairEntity = createファイルデータ一時テーブル(entity);
        tmpTableWriter.insert(fairEntity);
//    }
    }

    private FairudetaIchijiTeburuEntity createファイルデータ一時テーブル(HenKouData data) {
        FairudetaIchijiTeburuEntity entity = new FairudetaIchijiTeburuEntity();
        entity.setKoban(data.get項番());
        entity.setSutetasu(data.getステータス());
        entity.setShikibetsukodo(data.get識別コード());
        entity.setHokenshabango(data.get保険者番号());
        entity.setHihokenjabango(data.get被保険者番号());
        entity.setNinteishinseibi(data.get認定申請日());
        entity.setEdaban(data.get枝番());
        entity.setShinseikubunhorei(data.get申請区分_法令コード());
        entity.setShinseikubunshinseiji(data.get申請区分_申請時コード());
        entity.setTorisakubunkodo(data.get取下区分コード());
        entity.setHihokenjakubun(data.get被保険者区分コード());
        entity.setShinseidaikokubun(data.get申請代行区分コード());
        entity.setSeinengappi(data.get生年月日());
        entity.setNenrei(data.get年齢());
        entity.setSeibetsukodo(data.get性別コード());
        entity.setHihokenjakanashimei(data.get被保険者ｶﾅ氏名());
        entity.setHihokenjakanjishimei(data.get被保険者漢字氏名());
        entity.setYubenbango(data.get郵便番号());
        entity.setJusho(data.get住所());
        entity.setTenwabango(data.get電話番号());
        entity.setByoinshisetsutonomeisho(data.get病院施設等の名称());
        entity.setByoinshisetsutonoshozaichi(data.get病院施設等の所在地());
        entity.setZenkainoninteishinsakaikekka(data.get前回の認定審査会結果());
        entity.setZenkainoninteiyukokigenkaishi(data.get前回の認定有効期間_開始());
        entity.setZenkainoninteiyukokigenshuryo(data.get前回の認定有効期間_終了());
        entity.setShujiiiryokikanbango(data.get主治医医療機関番号());
        entity.setShujiibango(data.get主治医番号());
        entity.setLkenshoiraibi(data.get意見書依頼日());
        entity.setLkenshonyushubi(data.get意見書入手日());
        entity.setLkensho_tankikioku(data.get意見書_短期記憶());
        entity.setLkensho_ninchinoryoku(data.get意見書_認知能力());
        entity.setLkensho_dentatsunoryoku(data.get意見書_伝達能力());
        entity.setLkensho_shokujikoi(data.get意見書_食事行為());
        entity.setLkensho_ninshishokoreishajiritsudo(data.get意見書_認知症高齢者の日常生活自立度());
        entity.setChosairaibi(data.get調査依頼日());
        entity.setChosajisshibi(data.get調査実施日());
        entity.setShiteikyotakukaigoshienjigyoshatobango(data.get指定居宅介護支援事業者等番号());
        entity.setLtakukubun(data.get委託区分());
        entity.setNinteichosainbango(data.get認定調査員番号());
        entity.setNinteichosainshikakukodo(data.get認定調査員資格コード());
        entity.setLchijihanteibi(data.get一次判定日());
        entity.setLchijihanteikekka(data.get一次判定結果());
        entity.setLchijihanteikekka_ninshishokasan(data.get一次判定結果_認知症加算());
        entity.setYokaigoninteitokijunjikan(data.get要介護認定等基準時間());
        entity.setYokaigoninteitokijunjikan_shokuji(data.get要介護認定等基準時間_食事());
        entity.setYokaigoninteitokijunjikan_haisetsu(data.get要介護認定等基準時間_排泄());
        entity.setYokaigoninteitokijunjikan_ldo(data.get要介護認定等基準時間_移動());
        entity.setYokaigoninteitokijunjikan_seiketsuhoji(data.get要介護認定等基準時間_清潔保持());
        entity.setYokaigoninteitokijunjikan_kansetsukea(data.get要介護認定等基準時間_間接ケア());
        entity.setYokaigoninteitokijunjikan_bpsdkanren(data.get要介護認定等基準時間_BPSD関連());
        entity.setYokaigoninteitokijunjikan_kinokunren(data.get要介護認定等基準時間_機能訓練());
        entity.setYokaigoninteitokijunjikan_lryokanren(data.get要介護認定等基準時間_医療関連());
        entity.setYokaigoninteitokijunjikan_ninshishokasan(data.get要介護認定等基準時間_認知症加算());
        entity.setChukanhyokakomokutokuten_dai1gun(data.get中間評価項目得点第1群());
        entity.setChukanhyokakomokutokuten_dai2gun(data.get中間評価項目得点第2群());
        entity.setChukanhyokakomokutokuten_dai3gun(data.get中間評価項目得点第3群());
        entity.setChukanhyokakomokutokuten_dai4gun(data.get中間評価項目得点第4群());
        entity.setChukanhyokakomokutokuten_dai5gun(data.get中間評価項目得点第5群());
        entity.setLchijihanteikeikoku(data.get一次判定警告_配列コード());
        entity.setJotainoanteisei(data.get状態の安定性());
        entity.setNinshishojiritsudoijonogaizensei(data.get認知症自立度Ⅱ以上の蓋然性());
        entity.setNinchikinokyufukubun(data.get認知機給付区分());
        entity.setNinteishinsakaishiryosakuseibi(data.get認定審査会資料作成日());
        entity.setNinteishinsakaiyoteibi(data.get認定審査会予定日());
        entity.setGogitaibango(data.get合議体番号());
        entity.setShinsakaishiryobango(data.get審査会資料番号());
        entity.setNijihanteibi(data.get二次判定日());
        entity.setNijihanteikekka(data.get二次判定結果());
        entity.setNinteiyukokigen_kaishi(data.get認定有効期間_開始());
        entity.setNinteiyukokigen_shuryo(data.get認定有効期間_終了());
        entity.setTokuteishippeikodo(data.get特定疾病コード());
        entity.setYokaigo1nobaainojotaizo(data.get要介護1の場合の状態像());
        entity.setGenzainosabisukubunkodo(data.get現在のサービス区分コード());
        entity.setGenzainojokyo(data.get現在の状況());
        entity.setHomonkaigo_homuherupusabisu(data.get訪問介護_ホームヘルプサービス());
        entity.setHomonnyuyokukaigo(data.get訪問入浴介護());
        entity.setHomonkango(data.get訪問看護());
        entity.setHomonrihabiriteshon(data.get訪問リハビリテーション());
        entity.setKyotakuryoyokanrishido(data.get居宅療養管理指導());
        entity.setTsushokaigo_deisabisu(data.get通所介護_デイサービス());
        entity.setTsushorihabiriteshon(data.get通所リハビリテーション());
        entity.setTankinyushoseikatsukaigo_shotosutei(data.get短期入所生活介護_ショートステイ());
        entity.setTankinyushoryoyokaigo(data.get短期入所療養介護());
        entity.setTokuteishisetsunyukyoshaseikatsukaigo(data.get特定施設入居者生活介護());
        entity.setFukushiyogutaiyo(data.get福祉用具貸与());
        entity.setTokuteifukushiyoguhanbai(data.get特定福祉用具販売());
        entity.setJutakukaishukaigokyufu(data.get住宅改修_介護給付());
        entity.setYakantaiogatahomonkaigo(data.get夜間対応型訪問介護());
        entity.setNinchishotaiogatasushokaigo(data.get認知症対応型通所介護());
        entity.setShokibotakinogatakyotakukaigo(data.get小規模多機能型居宅介護());
        entity.setNinshishokaigo_gurupuhomu(data.get認知症グループホーム());
        entity.setChiikimitchakugataseikatsukaigo(data.get地域密着型生活介護());
        entity.setMitchakugatarojinkaigo(data.get地域密着型入所者生活介護());
        entity.setTeikijunkai_zuijihomonkaigokango(data.get定期巡回_随時対応型訪問介護看護());
        entity.setFukugogatasabisu(data.get複合型サービス());
        entity.setKaigoyobohomonkaigo_homuherupusabisu(data.get介護予防訪問介護_ホームヘルプサービス());
        entity.setKaigoyobohomonnyuyokukaigo(data.get介護予防訪問入浴介護());
        entity.setKaigoyobohomonkango(data.get介護予防訪問看護());
        entity.setKaigoyobohomonrihabiriteshon(data.get介護予防訪問リハビリテーション());
        entity.setKaigoyobokyotakuryoyokanrishido(data.get介護予防居宅療養管理指導());
        return entity;

    }

    /**
     * createファイルデータ一時テ
     *
     * @param data data
     * @param entity entity
     */
    public void createファイルデータ一時テ(HenKouData data, FairudetaIchijiTeburuEntity entity) {
        entity.setKaigoyobotsushokaigo_deisabisu(data.get介護予防通所介護_デイサービス());
        entity.setKaigoyobotsushorihabiriteshon(data.get介護予防通所リハビリテーション());
        entity.setKaigoyobotankiseikatsukaigo(data.get介護予防短期入所生活介護_ショートステイ());
        entity.setKaigoyobotankinyushoryoyokaigo(data.get介護予防短期入所療養介護());
        entity.setYobotokuteishisetsunyukyoshakaigo(data.get介護予防特定施設入居者生活介護());
        entity.setKaigoyobofukushiyogutaiyo(data.get介護予防福祉用具貸与());
        entity.setTokuteikaigoyobofukushiyoguhanbai(data.get特定介護予防福祉用具販売());
        entity.setJutakukaishu_yobokyufu(data.get住宅改修_予防給付());
        entity.setKaigoyoboninchishotaiogatatsushokaigo(data.get介護予防認知症対応型通所介護());
        entity.setKaigoyoboshokibotakinogatakyotakukaigo(data.get介護予防小規模多機能型居宅介護());
        entity.setYoboninshishokaigo_gurupuhomu(data.get介護予防認知症介護_グループホーム());
        entity.setMahi_hidari_joshi01(data.get麻痺_左上肢());
        entity.setMahi_migi_joshi01(data.get麻痺_右上肢());
        entity.setMahi_hidari_kashi01(data.get麻痺_左下肢());
        entity.setMahi_migi_kashi01(data.get麻痺_右下肢());
        entity.setMahi_sonohoka01(data.get麻痺_その他());
        entity.setKoshuku_kenkansetsu01(data.get拘縮_肩関節());
        entity.setKoshuku_kokansetsu01(data.get拘縮_股関節());
        entity.setKoshuku_hizakansetsu01(data.get拘縮_膝関節());
        entity.setKoshuku_sonohoka01(data.get拘縮_その他());
        entity.setNegaeri01(data.get寝返り());
        entity.setOkiagari01(data.get起き上がり());
        entity.setZaihoji01(data.get座位保持());
        entity.setRyoashidenotagu01(data.get両足での立位());
        entity.setHoko01(data.get歩行());
        entity.setTachiagari01(data.get立ち上がり());
        entity.setKataashidenotagu01(data.get片足での立位());
        entity.setAraimi01(data.get洗身());
        entity.setTsumekiri01(data.getつめ切り());
        entity.setShiryoku01(data.get視力());
        entity.setChoryoku01(data.get聴力());
        entity.setLjo02(data.get移乗());
        entity.setLdo02(data.get移動());
        entity.setEnge02(data.getえん下());
        entity.setShokujisesshu02(data.get食事摂取());
        entity.setHainyo02(data.get排尿());
        entity.setHaiben02(data.get排便());
        entity.setKokuseiketsu02(data.get口腔清潔());
        entity.setSengan02(data.get洗顔());
        entity.setSeihatsu02(data.get整髪());
        entity.setUwaginochakudatsu02(data.get上衣の着脱());
        entity.setZubontonochakudatsu02(data.getズボン等の着脱());
        entity.setGaishutsuhindo02(data.get外出頻度());
        entity.setLshinodentatsu03(data.get意思の伝達());
        entity.setMainichinonikkaorikai03(data.get毎日の日課を理解());
        entity.setSeinengappioiu03(data.get生年月日をいう());
        entity.setTankikioku03(data.get短期記憶());
        entity.setJibunnonamaeoiu03(data.get自分の名前をいう());
        entity.setImanokisetsuorikai03(data.get今の季節を理解());
        entity.setBashonorikai03(data.get場所の理解());
        entity.setHaikai03(data.get徘徊());
        entity.setGaishutsushitemodorenai03(data.get外出して戻れない());
        entity.setHigaiteki04(data.get被害的());
        entity.setSakubanashi04(data.get作話());
        entity.setKanjōgafuantei04(data.get感情が不安定());
        entity.setChuyagyakuten04(data.get昼夜逆転());
        entity.setOnajibanashiosuru04(data.get同じ話をする());
        entity.setOgoewodasu04(data.get大声を出す());
        entity.setKaigoniteiko04(data.get介護に抵抗());
        entity.setOchitsukinashi04(data.get落ち着きなし());
        entity.setIchiridedetagaru04(data.get一人で出たがる());
        entity.setShushuheki04(data.get収集癖());
        entity.setMonoyairuiokowasu04(data.get物や衣類を壊す());
        entity.setHidoimonowasure04(data.getひどい物忘れ());
        entity.setHitorigotohitoriwarai04(data.get独り言_独り笑い());
        entity.setJibungattenikodosuru04(data.get自分勝手に行動する());
        entity.setWagamatomaranai04(data.get話がまとまらない());
        entity.setKusurinonaifuku05(data.get薬の内服());
        entity.setKinsennokanri05(data.get金銭の管理());
        entity.setNichijonoishikettei05(data.get日常の意思決定());
        entity.setShudanenofutekio05(data.get集団への不適応());
        entity.setKaimono05(data.get買い物());
        entity.setKantannachori05(data.get簡単な調理());
        entity.setTentekinokanri(data.get点滴の管理());
        entity.setChushinjomyakueiyo(data.get中心静脈栄養());
        entity.setToseki(data.get透析());
        entity.setSutomanoshochi(data.getストーマの処置());
        entity.setSansoryoho(data.get酸素療法());
        entity.setResupireta(data.getレスピレーター());
        entity.setKikansekkainoshochitotsunokango(data.get気管切開の処置());
        entity.setKeikaneiyo(data.get疼痛の看護());
        entity.setMonitasokutei(data.get経管栄養());
        entity.setJiyokusounoshochi(data.getモニター測定());
        entity.setKateteru(data.getじょくそうの処置());
        entity.setShogaikorei(data.getカテーテル());
        entity.setShajiritsudo(data.get障害高齢者自立度());
        entity.setNinshishokoreishajiritsudo(data.get認知症高齢者自立度());
        entity.setZenkaikekka_mahi_hidari_joshi01(data.get前_01麻痺_左上肢());
        entity.setZenkaikekka_mahi_migi_joshi01(data.get前_01麻痺_右上肢());
        entity.setZenkaikekka_mahi_hidari_kashi01(data.get前_01麻痺_左下肢());
        entity.setZenkaikekka_mahi_migi_kashi01(data.get前_01麻痺_右下肢());
        entity.setZenkaikekka_mahi_sonohoka01(data.get前_01麻痺_その他());
        entity.setZenkaikekka_koshuku_kenkansetsu01(data.get前_01拘縮_肩関節());
        entity.setZenkaikekka_koshuku_kokansetsu01(data.get前_01拘縮_股関節());
        entity.setZenkaikekka_koshuku_hizakansetsu01(data.get前_01拘縮_膝関節());
        entity.setZenkaikekka_koshuku_sonohoka01(data.get前_01拘縮_その他());
        entity.setZenkaikekka_negaeri01(data.get前_01寝返り());
        entity.setZenkaikekka_okiagari01(data.get前_01起き上がり());
        entity.setZenkaikekka_zaihoji01(data.get前_01座位保持());
        entity.setZenkaikekka_ryoashidenotagu01(data.get前_01両足での立位());
    }

    /**
     * createファイルデータ一時
     *
     * @param data data
     * @param entity entity
     */
    public void createファイルデータ一時(HenKouData data, FairudetaIchijiTeburuEntity entity) {
        entity.setZenkaikekka_hoko01(data.get前_01歩行());
        entity.setZenkaikekka_tachiagari01(data.get前_01立ち上がり());
        entity.setZenkaikekka_kataashidenotagu01(data.get前_01片足での立位());
        entity.setZenkaikekka_araimi01(data.get前_01洗身());
        entity.setZenkaikekka_tsumekiri01(data.get前_01つめ切り());
        entity.setZenkaikekka_shiryoku01(data.get前_01視力());
        entity.setZenkaikekka_choryoku01(data.get前_01聴力());
        entity.setZenkaikekka_ljo02(data.get前_02移乗());
        entity.setZenkaikekka_ldo02(data.get前_02移動());
        entity.setZenkaikekka_enge02(data.get前_02えん下());
        entity.setZenkaikekka_shokujisesshu02(data.get前_02食事摂取());
        entity.setZenkaikekka_hainyo02(data.get前_02排尿());
        entity.setZenkaikekka_haiben02(data.get前_02排便());
        entity.setZenkaikekka_kokuseiketsu02(data.get前_02口腔清潔());
        entity.setZenkaikekka_sengan02(data.get前_02洗顔());
        entity.setZenkaikekka_seihatsu02(data.get前_02整髪());
        entity.setZenkaikekka_uwaginochakudatsu02(data.get前_02上衣の着脱());
        entity.setZenkaikekka_zubontonochakudatsu02(data.get前_02ズボン等の着脱());
        entity.setZenkaikekka_gaishutsuhindo02(data.get前_02外出頻度());
        entity.setZenkaikekka_lshinodentatsu03(data.get前_03意思の伝達());
        entity.setZenkaikekka_mainichinonikkaorikai03(data.get前_03毎日の日課を理解());
        entity.setZenkaikekka_seinengappioiu03(data.get前_03生年月日をいう());
        entity.setZenkaikekka_tankikioku03(data.get前_03短期記憶());
        entity.setZenkaikekka_jibunnonamaeoiu03(data.get前_03自分の名前をいう());
        entity.setZenkaikekka_imanokisetsuorikai03(data.get前_03今の季節を理解());
        entity.setZenkaikekka_bashonorikai03(data.get前_03場所の理解());
        entity.setZenkaikekka_haikai03(data.get前_03徘徊());
        entity.setZenkaikekka_gaishutsushitemodorenai03(data.get前_03外出して戻れない());
        entity.setZenkaikekka_higaiteki04(data.get前_04被害的());
        entity.setZenkaikekka_sakubanashi04(data.get前_04作話());
        entity.setZenkaikekka_kanjōgafuantei04(data.get前_04感情が不安定());
        entity.setZenkaikekka_chuyagyakuten04(data.get前_04昼夜逆転());
        entity.setZenkaikekka_onajibanashiosuru04(data.get前_04同じ話をする());
        entity.setZenkaikekka_ogoewodasu04(data.get前_04大声を出す());
        entity.setZenkaikekka_kaigoniteiko04(data.get前_04介護に抵抗());
        entity.setZenkaikekka_ochitsukinashi04(data.get前_04落ち着きなし());
        entity.setZenkaikekka_ichiridedetagaru04(data.get前_04一人で出たがる());
        entity.setZenkaikekka_shushuheki04(data.get前_04収集癖());
        entity.setZenkaikekka_monoyairuiokowasu04(data.get前_04物や衣類を壊す());
        entity.setZenkaikekka_hidoimonowasure04(data.get前_04ひどい物忘れ());
        entity.setZenkaikekka_hitorigotohitoriwarai04(data.get前_04独り言独り笑い());
        entity.setZenkaikekka_jibungattenikodosuru04(data.get前_04自分勝手に行動する());
        entity.setZenkaikekka_wagamatomaranai04(data.get前_04話がまとまらない());
        entity.setZenkaikekka_Kusurinonaifuku05(data.get前_05薬の内服());
        entity.setZenkaikekka_kinsennokanri05(data.get前_05金銭の管理());
        entity.setZenkaikekka_nichijonoishikettei05(data.get前_05日常の意思決定());
        entity.setZenkaikekka_shudanenofutekio05(data.get前_05集団への不適応());
        entity.setZenkaikekka_kaimono05(data.get前_05買い物());
        entity.setZenkaikekka_kantannachori05(data.get前_05簡単な調理());
        entity.setZenkaikekka_tentekinokanri(data.get前_点滴の管理());
        entity.setZenkaikekka_chushinjomyakueiyo(data.get前_中心静脈栄養());
        entity.setZenkaikekka_toseki(data.get前_透析());
        entity.setZenkaikekka_sutomanoshochi(data.get前_ストーマの処置());
        entity.setZenkaikekka_sansoryoho(data.get前_酸素療法());
        entity.setZenkaikekka_resupireta(data.get前_レスピレーター());
        entity.setZenkaikekka_kikansekkainoshochitotsunokango(data.get前_気管切開の処置());
        entity.setZenkaikekka_keikaneiyo(data.get前_疼痛の看護());
        entity.setZenkaikekka_monitasokutei(data.get前_経管栄養());
        entity.setZenkaikekka_jiyokusounoshochi(data.get前_モニター測定());
        entity.setZenkaikekka_kateteru(data.get前_じょくそうの処置());
        entity.setZenkaikekka_shogaikorei(data.get前_カテーテル());
        entity.setZenkaikekka_shajiritsudo(data.get前_障害高齢者自立度());
        entity.setZenkaikekka_ninshishokoreishajiritsudo(data.get前_認知症高齢者自立度());
        entity.setZenkaikekka_ichijihanteikekka(data.get前_一次判定結果());
        entity.setZenkaikekka_ichijihanteikekka_ninshishokasan(data.get前_一次判定結果_認知症加算());
        entity.setZenkaikekka_yokaigojikan(data.get前_要介護認定等基準時間());
        entity.setZenkaikekka_yokaigojikan_shokuji(data.get前_要介護認定等基準時間_食事());
        entity.setZenkaikekka_yokaigojikan_haisetsu(data.get前_要介護認定等基準時間_排泄());
        entity.setZenkaikekka_yokaigojikan_ldo(data.get前_要介護認定等基準時間_移動());
        entity.setZenkaikekka_yokaigojikan_seiketsuhoji(data.get前_要介護認定等基準時間_清潔保持());
        entity.setZenkaikekka_yokaigojikan_kansetsukea(data.get前_要介護認定等基準時間_間接ケア());
        entity.setZenkaikekka_yokaigojikan_kanren(data.get前_要介護認定等基準時間_BPSD関連());
        entity.setZenkaikekka_yokaigojikan_kinokunren(data.get前_要介護認定等基準時間_機能訓練());
        entity.setZenkaikekka_yokaigojikan_iryokanren(data.get前_要介護認定等基準時間_医療関連());
        entity.setZenkaikekka_yokaigojikan_ninshishokasan(data.get前_要介護認定等基準時間_認知症加算());
        entity.setZenkaikekka_chukanhyokakomokutokutendai1_gun(data.get前_中間評価項目得点第1群());
        entity.setZenkaikekka_chukanhyokakomokutokutendai2_gun(data.get前_中間評価項目得点第2群());
        entity.setZenkaikekka_chukanhyokakomokutokutendai3_gun(data.get前_中間評価項目得点第3群());
        entity.setZenkaikekka_chukanhyokakomokutokutendai4_gun(data.get前_中間評価項目得点第4群());
        entity.setZenkaikekka_chukanhyokakomokutokutendai5_gun(data.get前_中間評価項目得点第5群());
        entity.setZenkaikekka_kodo(data.get前_一次判定警告コード());
        entity.setZenkaikekka_jotainoanteisei(data.get前_状態の安定性());
        entity.setZenkaikekka_ninshishojiritsudo(data.get前_認知症自立度Ⅱ以上の蓋然性());
        entity.setZenkaikekka_ninchikinokyufukubun(data.get前_認知機能給付区分());
        entity.setZenkaikekka_shinseibi(data.get前_申請日());
        entity.setZenkaikekka_nijihanteibi(data.get前_二次判定日());
        entity.setZenkaikekka_genzainosabisukubunkodo(data.get前_現在のサービス区分コード());
        entity.setZenkaikekka_genzainojokyo(data.get前_現在の状況());
        entity.setZenkaikekka_homonkaigo_homuherupusabisu(data.get前_訪問介護_ホームヘルプサービス());
        entity.setZenkaikekka_homonnyuyokukaigo(data.get前_訪問入浴介護());
        entity.setZenkaikekka_homonkango(data.get前_訪問看護());
        entity.setZenkaikekka_homonrihabiriteshon(data.get前_訪問リハビリテーション());
        entity.setZenkaikekka_kyotakuryoyokanrishido(data.get前_居宅療養管理指導());
        entity.setZenkaikekka_tsushokaigo_deisabisu(data.get前_通所介護_デイサービス());
        entity.setZenkaikekka_tsushorihabiriteshon(data.get前_通所リハビリテーション());
        entity.setZenkaikekka_tankinyushoseikatsukaigo_shotosutei(data.get前_短期入所生活介護_ショートステイ());
        entity.setZenkaikekka_tankinyushoryoyokaigo(data.get前_短期入所療養介護());
        entity.setZenkaikekka_tokuteishisetsunyukyoshaseikatsukaigo(data.get前_特定施設入居者生活介護());
        entity.setZenkaikekka_fukushiyogutaiyo(data.get前_福祉用具貸与());
        entity.setZenkaikekka_tokuteifukushiyoguhanbai(data.get前_特定福祉用具販売());
        entity.setZenkaikekka_jutakukaishukaigokyufu(data.get前_住宅改修_介護給付());
        entity.setZenkaikekka_yakantaiogatahomonkaigo(data.get前_夜間対応型訪問介護());
        entity.setZenkaikekka_ninchishotaiogatasushokaigo(data.get前_認知症対応型通所介護());
        entity.setZenkaikekka_shokibotakinogatakyotakukaigo(data.get前_小規模多機能型居宅介護());
        entity.setZenkaikekka_ninshishokaigo_gurupuhomu(data.get前_認知症対応型共同生活介護_グループホーム());
        entity.setZenkaikekka_chiikimitchakugataseikatsukaigo(data.get前_地域密着型生活介護());
        entity.setZenkaikekka_mitchakugatarojinkaigo(data.get前_地域密着型入所者生活介護());
        entity.setZenkaikekka_teikijunkai_zuijihomonkaigokango(data.get前_定期巡回随時対応型訪問介護看護());
        entity.setZenkaikekka_fukugogatasabisu(data.get前_複合型サービス());
        entity.setZenkaikekka_kaigoyobohomonkaigo_homuherupusabisu(data.get前_介護予防訪問介護_ホームヘルプサービス());
        entity.setZenkaikekka_kaigoyobohomonnyuyokukaigo(data.get前_介護予防訪問入浴介護());
        entity.setZenkaikekka_kaigoyobohomonkango(data.get前_介護予防訪問看護());
        entity.setZenkaikekka_kaigoyobohomonrihabiriteshon(data.get前_介護予防訪問リハビリテーション());
        entity.setZenkaikekka_kaigoyobokyotakuryoyokanrishido(data.get前_介護予防居宅療養管理指導());
        entity.setZenkaikekka_kaigoyobotsushokaigo_deisabisu(data.get前_介護予防通所介護_デイサービス());
        entity.setZenkaikekka_kaigoyobotsushorihabiriteshon(data.get前_介護予防通所リハビリテーション());
        entity.setZenkaikekka_kaigoyobotankiseikatsukaigo(data.get前_介護予防短期入所生活介護_ショートステイ());
        entity.setZenkaikekka_kaigoyobotankinyushoryoyokaigo(data.get前_介護予防短期入所療養介護());
        entity.setZenkaikekka_yobotokuteishisetsunyukyoshakaigo(data.get前_介護予防特定施設入居者生活介護());
        entity.setZenkaikekka_kaigoyobofukushiyogutaiyo(data.get前_介護予防福祉用具貸与());
        entity.setZenkaikekka_tokuteikaigoyobofukushiyoguhanbai(data.get前_特定介護予防福祉用具販売());
        entity.setZenkaikekka_jutakukaishu_yobokyufu(data.get前_住宅改修_予防給付());
        entity.setZenkaikekka_kaigoyoboninchishotaiogatatsushokaigo(data.get前_介護予防認知症対応型通所介護());
        entity.setZenkaikekka_kaigoyoboshokibotakinogatakyotakukaigo(data.get前_介護予防小規模多機能型居宅介護());
        entity.setZenkaikekka_yoboninshishokaigo_gurupuhomu(data.get前_介護予防認知症生活介護_グループホーム());
        entity.setZenkaishikibetsukodo(data.get前回識別コード());
        entity.setNinteishinsakaiikento(data.get認定審査会意見等());
        entity.setKomentoto(data.getコメント等());
    }
}
