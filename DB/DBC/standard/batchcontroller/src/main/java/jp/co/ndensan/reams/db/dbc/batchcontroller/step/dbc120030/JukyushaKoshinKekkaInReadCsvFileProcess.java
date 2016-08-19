/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120030;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_TorikomiErrorKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.jukyushakoshinkekka.JukyushaKoshinKekkaReadCsvFileProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.jukyushakoshinkekka.JukyushaJohoControlCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.jukyushakoshinkekka.JukyushaJohoDataCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kokuhorenjukyushain.KokuhorenJukyushaFlowEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakoshinkekka.DbWT5331JukyushaJohoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu.DbWT0001HihokenshaIchijiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin.DbWT0002KokuhorenTorikomiErrorEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.hokenshainputguide.Hokensha;
import jp.co.ndensan.reams.db.dbz.service.core.hokensha.HokenshaNyuryokuHojoFinder;
import jp.co.ndensan.reams.ur.urz.definition.core.hokenja.HokenjaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchSimpleReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.io.csv.ListToObjectMappingHelper;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 受給者情報更新結果情報取込のCSVファイル読取
 *
 * @reamsid_L DBC-2730-010 chenjie
 */
public class JukyushaKoshinKekkaInReadCsvFileProcess extends BatchProcessBase<RString> {

    /**
     * CSVファイル取込後の返したエンティティ
     */
    public static final RString PARAMETER_OUT_FLOWENTITY;
    private JukyushaKoshinKekkaReadCsvFileProcessParameter parameter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 被保険者一時tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 処理結果リスト一時tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 受給者情報一時tableWriter;
    private static final RString 被保険者一時_TABLE_NAME = new RString("DbWT0001Hihokensha");
    private static final RString 処理結果リスト一時_TABLE_NAME = new RString("DbWT0002KokuhorenTorikomiError");
    private static final RString 受給者情報一時_TABLE_NAME = new RString("DbWT5331JukyushaJoho");
    private JukyushaJohoControlCsvEntity コントロールレコード;
    private JukyushaJohoDataCsvEntity 受給者情報;
    private final RString レコード種別_コントロール = new RString("1");
    private final RString レコード種別_データ = new RString("2");
    private static final RString カンマ = new RString(",");
    private static final Integer INDEX_0 = 0;

    private int 連番 = 0;
    private int 明細件数合計 = 0;
    private int コントロールレコードのレコード件数の合計 = 0;
    private FlexibleYearMonth 処理対象年月;

    static {
        PARAMETER_OUT_FLOWENTITY = new RString("flowEntity");
    }

    private OutputParameter<KokuhorenJukyushaFlowEntity> flowEntity;
    private KokuhorenJukyushaFlowEntity returnEntity;

    @Override
    protected void initialize() {
        flowEntity = new OutputParameter<>();
        returnEntity = new KokuhorenJukyushaFlowEntity();
        flowEntity.setValue(returnEntity);
        連番 = parameter.get連番();
    }

    @Override
    protected void createWriter() {
        被保険者一時tableWriter
                = new BatchEntityCreatedTempTableWriter(被保険者一時_TABLE_NAME, DbWT0001HihokenshaIchijiEntity.class);
        処理結果リスト一時tableWriter
                = new BatchEntityCreatedTempTableWriter(処理結果リスト一時_TABLE_NAME,
                        DbWT0002KokuhorenTorikomiErrorEntity.class);
        受給者情報一時tableWriter
                = new BatchEntityCreatedTempTableWriter(受給者情報一時_TABLE_NAME, DbWT5331JukyushaJohoTempEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchSimpleReader(parameter.getファイルパース());
    }

    @Override
    protected void process(RString line) {
        List<RString> data = line.split(カンマ.toString());
        if (data != null && !data.isEmpty()) {
            if (レコード種別_コントロール.equals(data.get(INDEX_0))) {
                コントロールレコード = ListToObjectMappingHelper.toObject(JukyushaJohoControlCsvEntity.class, data);
                処理対象年月 = コントロールレコード.getShoriYM();
                コントロールレコードのレコード件数の合計++;
            } else if (レコード種別_データ.equals(data.get(INDEX_0))) {
                受給者情報 = ListToObjectMappingHelper.toObject(JukyushaJohoDataCsvEntity.class, data);
                受給者情報明細一時TBLに登録();
                被保険者一時TBLに登録();
                明細件数合計++;
            }
        }
    }

    @Override
    protected void beforeExecute() {
    }

    @Override
    protected void afterExecute() {
        int 明細データ登録件数合算 = parameter.get明細データ登録件数合算() + 明細件数合計;
        if (parameter.isさいごファイルフラグ() && 0 == 明細データ登録件数合算) {
            処理結果リスト一時に登録();
        }
        returnEntity.setCodeNum(コントロールレコードのレコード件数の合計);
        returnEntity.set明細データ登録件数(明細件数合計);
        returnEntity.setShoriYM(処理対象年月);
        returnEntity.set連番(連番);
    }

    @Transaction
    private void 受給者情報明細一時TBLに登録() {
        HokenshaNyuryokuHojoFinder 保険者名取得 = HokenshaNyuryokuHojoFinder.createInstance();
        連番 = 連番 + 1;
        DbWT5331JukyushaJohoTempEntity 受給者一時entity = new DbWT5331JukyushaJohoTempEntity();
        受給者一時entity.setRenban(連番);
        受給者一時entity.setMinashiYokaigoKubunCode(受給者情報.getMinashiYokaigoKubunCode());
        受給者一時entity.setKokanJohoShikibetsuNo(受給者情報.getKokanJohoShikibetsuNo());
        受給者一時entity.setIdoYmd(受給者情報.getIdoYmd());
        受給者一時entity.setIdoKubunCode(受給者情報.getIdoKubunCode());
        受給者一時entity.setTeiseiYmd(受給者情報.getTeiseiYmd());
        受給者一時entity.setTeiseiKubunCode(受給者情報.getTeiseiKubunCode());
        受給者一時entity.setIdoJiyuKubun(受給者情報.getIdoJiyuKubun());
        受給者一時entity.setSeinengappiYmd(受給者情報.getSeinengappiYmd());
        受給者一時entity.setSeibetsuCode(受給者情報.getSeibetsuCode());
        受給者一時entity.setShikakuShutokuYmd(受給者情報.getShikakuShutokuYmd());
        受給者一時entity.setShikakuSoshitsuYmd(受給者情報.getShikakuSoshitsuYmd());
        受給者一時entity.setRojinHokenShichosonNo(受給者情報.getRojinHokenShichosonNo());
        受給者一時entity.setRojinHokenJukyushaNo(受給者情報.getRojinHokenJukyushaNo());
        受給者一時entity.setKoikiRengoHokenshaNo(受給者情報.getKoikiRengoHokenshaNo());
        受給者一時entity.setShinseiShubetsuCode(受給者情報.getShinseiShubetsuCode());
        受給者一時entity.setHenkoShinseichuKubunCode(受給者情報.getHenkoShinseichuKubunCode());
        受給者一時entity.setShinseiYmd(受給者情報.getShinseiYmd());
        受給者一時entity.setYokaigoJotaiKubunCode(受給者情報.getYokaigoJotaiKubunCode());
        受給者一時entity.setNinteiYukokikanFromYmd(受給者情報.getNinteiYukokikanFromYmd());
        受給者一時entity.setNinteiYukokikanToYmd(受給者情報.getNinteiYukokikanToYmd());
        受給者一時entity.setKyotakuServiceKubunCode(受給者情報.getKyotakuServiceKubunCode());
        受給者一時entity.setKyotakuKaigoShienJigyoshoNo(受給者情報.getKyotakuKaigoShienJigyoshoNo());
        受給者一時entity.setKyotakuServiceTekiyoFromYmd(受給者情報.getKyotakuServiceTekiyoFromYmd());
        受給者一時entity.setKyotakuServiceTekiyoToYmd(受給者情報.getKyotakuServiceTekiyoToYmd());
        受給者一時entity.setHomonShikyugendoKijungaku(受給者情報.getHomonShikyugendoKijungaku());
        受給者一時entity.setHomonJogenKanriTekiyoKikanFromYmd(受給者情報.getHomonJogenKanriTekiyoKikanFromYmd());
        受給者一時entity.setHomonJogenKanriTekiyoKikanToYmd(受給者情報.getHomonJogenKanriTekiyoKikanToYmd());
        受給者一時entity.setTankiShikyugendoKijungaku(受給者情報.getTankiShikyugendoKijungaku());
        受給者一時entity.setTankiJogenKanriTekiyoKikanFromYmd(受給者情報.getTankiJogenKanriTekiyoKikanFromYmd());
        受給者一時entity.setTankiJogenKanriTekiyoKikanToYmd(受給者情報.getTankiJogenKanriTekiyoKikanToYmd());
        受給者一時entity.setKohiFutanJogengakuGengakuUmu(受給者情報.getKohiFutanJogengakuGengakuUmu());
        受給者一時entity.setShokanHaraikaFromYmd(受給者情報.getShokanHaraikaFromYmd());
        受給者一時entity.setShokanHaraikaToYmd(受給者情報.getShokanHaraikaToYmd());
        受給者一時entity.setKyufuritsuHikisageFromYmd(受給者情報.getKyufuritsuHikisageFromYmd());
        受給者一時entity.setKyufuritsuHikisageToYmd(受給者情報.getKyufuritsuHikisageToYmd());
        受給者一時entity.setGenmenShinseichuKubunCode(受給者情報.getGenmenShinseichuKubunCode());
        受給者一時entity.setRiyoshaFutanKubunCode(受給者情報.getRiyoshaFutanKubunCode());
        受給者一時entity.setKyufuRitsu(受給者情報.getKyufuRitsu());
        受給者一時entity.setRiyoshaFutanTekiyoFromYmd(受給者情報.getRiyoshaFutanTekiyoFromYmd());
        受給者一時entity.setRiyoshaFutanTekiyoToYmd(受給者情報.getRiyoshaFutanTekiyoToYmd());
        受給者一時entity.setHyojunFutanKubunCode(受給者情報.getHyojunFutanKubunCode());
        受給者一時entity.setFutanGaku(受給者情報.getFutanGaku());
        受給者一時entity.setFutanGakuTekiyoFromYmd(受給者情報.getFutanGakuTekiyoFromYmd());
        受給者一時entity.setFutanGakuTekiyoToYmd(受給者情報.getFutanGakuTekiyoToYmd());
        受給者一時entity.setTokuteiNyushoshaNinteiShinseichuKubunCode(受給者情報.getTokuteiNyushoshaNinteiShinseichuKubunCode());
        受給者一時entity.setTokuteiNyushoshaKaigoServiceKubunCode(受給者情報.getTokuteiNyushoshaKaigoServiceKubunCode());
        受給者一時entity.setKazeisoNoTokureiGengakuSochiTaishoKubun(受給者情報.getKazeisoNoTokureiGengakuSochiTaishoKubun());
        受給者一時entity.setTokuteiNyushoshaShokuhiFutanGendoGaku(受給者情報.getTokuteiNyushoshaShokuhiFutanGendoGaku());
        受給者一時entity.setKyojuhiUnitKoshitsuFutanGendoGaku(受給者情報.getKyojuhiUnitKoshitsuFutanGendoGaku());
        受給者一時entity.setKyojuhiUnitJunkoshitsuFutanGendoGaku(受給者情報.getKyojuhiUnitJunkoshitsuFutanGendoGaku());
        受給者一時entity.setKyojuhiTokuyotoFutanGenndoGaku(受給者情報.getKyojuhiTokuyotoFutanGenndoGaku());
        受給者一時entity.setKyojuhiRokenRyoyotoFutanGendoGaku(受給者情報.getKyojuhiRokenRyoyotoFutanGendoGaku());
        受給者一時entity.setKyojuhiTashoShitsuFutanGendoGaku(受給者情報.getKyojuhiTashoShitsuFutanGendoGaku());
        受給者一時entity.setFutanGendoGakuTekiyoFromYmd(受給者情報.getFutanGendoGakuTekiyoFromYmd());
        受給者一時entity.setFutanGendoGakuTekiyoToYmd(受給者情報.getFutanGendoGakuTekiyoToYmd());
        受給者一時entity.setKeigenRitsu(受給者情報.getKeigenRitsu());
        受給者一時entity.setKeigenRitsuTekiyoFromYmd(受給者情報.getKeigenRitsuTekiyoFromYmd());
        受給者一時entity.setKeigenRitsuTekiyoToYmd(受給者情報.getKeigenRitsuTekiyoToYmd());
        受給者一時entity.setShokiboKyotakuServiceRiyoUmu(受給者情報.getShokiboKyotakuServiceRiyoUmu());
        受給者一時entity.setKokiHokenshaNo(受給者情報.getKokiHokenshaNo());
        受給者一時entity.setKokiHihokenshaNo(受給者情報.getKokiHihokenshaNo());
        受給者一時entity.setKokuhoHokenshaNo(受給者情報.getKokuhoHokenshaNo());
        受給者一時entity.setKokuhoHihokenshashoNo(受給者情報.getKokuhoHihokenshashoNo());
        受給者一時entity.setAtenaNo(受給者情報.getAtenaNo());
        受給者一時entity.setNijiyoboJigyoKubunCode(受給者情報.getNijiyoboJigyoKubunCode());
        受給者一時entity.setNijiyoboJigyoYukokikanFromYmd(受給者情報.getNijiyoboJigyoYukokikanFromYmd());
        受給者一時entity.setNijiyoboJigyoYukokikanToYmd(受給者情報.getNijiyoboJigyoYukokikanToYmd());
        受給者一時entity.setJushochiTokureiTaishoshaKubunCode(受給者情報.getJushochiTokureiTaishoshaKubunCode());
        受給者一時entity.setShisetsuShozaiHokenshaNo(受給者情報.getShisetsuShozaiHokenshaNo());
        受給者一時entity.setJushochiTokureiTekiyoFromYmd(受給者情報.getJushochiTokureiTekiyoFromYmd());
        受給者一時entity.setJushochiTokureiTekiyoToYmd(受給者情報.getJushochiTokureiTekiyoToYmd());
        受給者一時entity.setKyojuhi1FutanGendogaku(受給者情報.getKyojuhi1FutanGendogaku());
        受給者一時entity.setKyojuhi2FutanGendogaku(受給者情報.getKyojuhi2FutanGendogaku());
        受給者一時entity.setKyojuhi3FutanGendogaku(受給者情報.getKyojuhi3FutanGendogaku());
        受給者一時entity.setNiwariFutanTekiyoFromYmd(受給者情報.getNiwariFutanTekiyoFromYmd());
        受給者一時entity.setNiwariFutanTekiyoToYmd(受給者情報.getNiwariFutanTekiyoToYmd());
        受給者一時entity.setYuryoRojinHomeDoishoUmu(RString.EMPTY);
        受給者一時entity.setTsugoKekkaKubun(RString.EMPTY);
        受給者一時entity.setTsugoJohoKubun(RString.EMPTY);
        受給者一時entity.setHokenshaNo(コントロールレコード.getHokenshaNo());
        Hokensha hokensha = 保険者名取得.getHokensha(new HokenjaNo(コントロールレコード.getHokenshaNo()));
        if (hokensha != null) {
            受給者一時entity.setHokenshaName(hokensha.get保険者名());
        }
        受給者一時entity.setTorikomiYM(処理対象年月);
        受給者情報一時tableWriter.insert(受給者一時entity);
    }

    @Transaction
    private void 被保険者一時TBLに登録() {
        DbWT0001HihokenshaIchijiEntity 被保険者一時entity = new DbWT0001HihokenshaIchijiEntity();
        被保険者一時entity.setMeisaiRenban(連番);
        被保険者一時entity.setShoHokenshaNo(new ShoKisaiHokenshaNo(受給者情報.getShoukizaihokenshashoNo()));
        被保険者一時entity.setOrgHihokenshaNo(new HihokenshaNo(受給者情報.getHihokenshashoNo()));
        被保険者一時entity.setServiceTeikyoYmd(受給者情報.getIdoYmd());
        被保険者一時entity.setOrgHihokenshaKanaShimei(受給者情報.getHihokenshaShimeikana());
        被保険者一時entity.setOrgHihokenshaShimei(RString.EMPTY);
        被保険者一時entity.setOldShichosonCode(LasdecCode.EMPTY);
        被保険者一時entity.setHenkanHihokenshaNo(new HihokenshaNo(受給者情報.getHihokenshashoNo()));
        被保険者一時entity.setHihokenshaNo(new HihokenshaNo(受給者情報.getHihokenshashoNo()));
        被保険者一時entity.setShichosonCode(LasdecCode.EMPTY);
        被保険者一時entity.setKannaiKangaiKubun(RString.EMPTY);
        被保険者一時entity.setYubinNo(RString.EMPTY);
        被保険者一時entity.setChoikiCode(RString.EMPTY);
        被保険者一時entity.setGyoseikuCode(RString.EMPTY);
        被保険者一時entity.setGyoseikuMei(RString.EMPTY);
        被保険者一時entity.setJusho(RString.EMPTY);
        被保険者一時entity.setBanchi(RString.EMPTY);
        被保険者一時entity.setKatagaki(RString.EMPTY);
        被保険者一時entity.setKanaMeisho(RString.EMPTY);
        被保険者一時entity.setMeisho(RString.EMPTY);
        被保険者一時entity.setShimei50onKana(RString.EMPTY);
        被保険者一時entity.setShikibetsuCode(ShikibetsuCode.EMPTY);
        被保険者一時entity.setShikakuShutokuYmd(FlexibleDate.EMPTY);
        被保険者一時entity.setShikakuShutokuJiyuCode(RString.EMPTY);
        被保険者一時entity.setShikakuSoshitsuYmd(FlexibleDate.EMPTY);
        被保険者一時entity.setShikakuSoshitsuJiyuCode(RString.EMPTY);
        被保険者一時entity.setSetaiShuyakuNo(HihokenshaNo.EMPTY);
        被保険者一時tableWriter.insert(被保険者一時entity);
    }

    @Transaction
    private void 処理結果リスト一時に登録() {
        DbWT0002KokuhorenTorikomiErrorEntity 処理結果リスト一時entity = new DbWT0002KokuhorenTorikomiErrorEntity();
        処理結果リスト一時entity.setErrorKubun(KokuhorenJoho_TorikomiErrorKubun.取込対象データなし.getコード());
        処理結果リスト一時entity.setShoHokanehshaNo(ShoKisaiHokenshaNo.EMPTY);
        処理結果リスト一時entity.setHihokenshaNo(HihokenshaNo.EMPTY);
        処理結果リスト一時entity.setKey1(RString.EMPTY);
        処理結果リスト一時entity.setKey2(RString.EMPTY);
        処理結果リスト一時entity.setKey3(RString.EMPTY);
        処理結果リスト一時entity.setKey4(RString.EMPTY);
        処理結果リスト一時entity.setKey5(RString.EMPTY);
        処理結果リスト一時entity.setHihokenshaKanaShimei(RString.EMPTY);
        処理結果リスト一時entity.setHihokenshaShimei(RString.EMPTY);
        処理結果リスト一時entity.setBiko(RString.EMPTY);
        処理結果リスト一時tableWriter.insert(処理結果リスト一時entity);
    }
}
