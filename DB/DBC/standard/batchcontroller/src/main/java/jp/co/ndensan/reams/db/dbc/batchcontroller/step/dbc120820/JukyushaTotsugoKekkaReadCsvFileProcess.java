/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120820;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_TorikomiErrorKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.jukyushatotsugokekkain.JukyushaTotsugoKekkaReadCsvFileProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.jukyushatotsugokekka.JukyushaKekkaJohoControlCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.jukyushatotsugokekka.JukyushaKekkaJohoCsvMeisaiEntity;
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
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.io.csv.ListToObjectMappingHelper;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者情報突合結果情報取込・ファイル読込を実行する。
 *
 * @reamsid_L DBC-2760-010 jianglaisheng
 */
public class JukyushaTotsugoKekkaReadCsvFileProcess extends BatchProcessBase<RString> {

    /**
     * returnEntity
     */
    public static final RString PARAMETER_OUT_FLOWENTITY;
    private JukyushaTotsugoKekkaReadCsvFileProcessParameter parameter;
    @BatchWriter
    IBatchTableWriter 被保険者一時tableWriter;
    @BatchWriter
    IBatchTableWriter 処理結果リスト一時tableWriter;
    @BatchWriter
    IBatchTableWriter 受給者情報一時tableWriter;
    private static final RString 被保険者一時_TABLE_NAME = new RString("DbWT0001Hihokensha");
    private static final RString 処理結果リスト一時_TABLE_NAME = new RString("DbWT0002KokuhorenTorikomiError");
    private static final RString 受給者情報一時_TABLE_NAME = new RString("DbWT5331JukyushaJoho");
    private JukyushaKekkaJohoControlCsvEntity controlCsvEntity;
    private JukyushaKekkaJohoCsvMeisaiEntity dataEntity;
    private final RString レコード種別_コントロール = new RString("1");
    private final RString レコード種別_データ = new RString("2");
    private static final RString カンマ = new RString(",");
    private static final Integer INDEX_0 = 0;

    private int 連番;
    private int コントロールレコードのレコード件数の合計 = 0;
    private int 明細件数合計 = 0;
    private FlexibleYearMonth 処理対象年月;

    static {
        PARAMETER_OUT_FLOWENTITY = new RString("flowEntity");
    }

    private OutputParameter<KokuhorenJukyushaFlowEntity> flowEntity;
    private KokuhorenJukyushaFlowEntity returnEntity;

    @Override
    protected void initialize() {
        連番 = parameter.get連番();
        controlCsvEntity = new JukyushaKekkaJohoControlCsvEntity();
        returnEntity = new KokuhorenJukyushaFlowEntity();
        flowEntity = new OutputParameter<>();
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
    protected void beforeExecute() {
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
                controlCsvEntity = ListToObjectMappingHelper.toObject(JukyushaKekkaJohoControlCsvEntity.class, data);
                処理対象年月 = controlCsvEntity.get処理対象年月();
                コントロールレコードのレコード件数の合計++;
            } else if (レコード種別_データ.equals(data.get(INDEX_0))) {
                dataEntity = ListToObjectMappingHelper.toObject(JukyushaKekkaJohoCsvMeisaiEntity.class, data);
                this.受給者情報明細一時TBLに登録();
                this.被保険者一時TBLに登録();
                明細件数合計++;
            }
        }
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
        flowEntity.setValue(returnEntity);
    }

    private void 受給者情報明細一時TBLに登録() {
        HokenshaNyuryokuHojoFinder 保険者名取得 = HokenshaNyuryokuHojoFinder.createInstance();
        連番 = 連番 + 1;
        DbWT5331JukyushaJohoTempEntity 受給者一時entity = new DbWT5331JukyushaJohoTempEntity();
        受給者一時entity.setRenban(連番);
        受給者一時entity.setMinashiYokaigoKubunCode(dataEntity.getMinashiYokaigoKubunCode());
        受給者一時entity.setKokanJohoShikibetsuNo(dataEntity.getKokanJohoShikibetsuNo());
        受給者一時entity.setIdoYmd(dataEntity.getIdoYmd());
        受給者一時entity.setIdoKubunCode(dataEntity.getIdoKubunCode());
        受給者一時entity.setTeiseiYmd(FlexibleDate.EMPTY);
        受給者一時entity.setTeiseiKubunCode(RString.EMPTY);
        受給者一時entity.setIdoJiyuKubun(dataEntity.getIdoJiyuKubun());
        受給者一時entity.setSeinengappiYmd(dataEntity.getSeinengappiYmd());
        受給者一時entity.setSeibetsuCode(dataEntity.getSeibetsuCode());
        受給者一時entity.setShikakuShutokuYmd(dataEntity.getShikakuShutokuYmd());
        受給者一時entity.setShikakuSoshitsuYmd(dataEntity.getShikakuSoshitsuYmd());
        受給者一時entity.setRojinHokenShichosonNo(dataEntity.getRojinHokenShichosonNo());
        受給者一時entity.setRojinHokenJukyushaNo(dataEntity.getRojinHokenJukyushaNo());
        受給者一時entity.setKoikiRengoHokenshaNo(dataEntity.getKoikiRengoHokenshaNo());
        受給者一時entity.setShinseiShubetsuCode(dataEntity.getShinseiShubetsuCode());
        受給者一時entity.setHenkoShinseichuKubunCode(dataEntity.getHenkoShinseichuKubunCode());
        受給者一時entity.setShinseiYmd(dataEntity.getShinseiYmd());
        受給者一時entity.setYokaigoJotaiKubunCode(dataEntity.getYokaigoJotaiKubunCode());
        受給者一時entity.setNinteiYukokikanFromYmd(dataEntity.getNinteiYukokikanFromYmd());
        受給者一時entity.setNinteiYukokikanToYmd(dataEntity.getNinteiYukokikanToYmd());
        受給者一時entity.setKyotakuServiceKubunCode(dataEntity.getKyotakuServiceKubunCode());
        受給者一時entity.setKyotakuKaigoShienJigyoshoNo(dataEntity.getKyotakuKaigoShienJigyoshoNo());
        受給者一時entity.setKyotakuServiceTekiyoFromYmd(dataEntity.getKyotakuServiceTekiyoFromYmd());
        受給者一時entity.setKyotakuServiceTekiyoToYmd(dataEntity.getKyotakuServiceTekiyoToYmd());
        受給者一時entity.setHomonShikyugendoKijungaku(dataEntity.getHomonShikyugendoKijungaku());
        受給者一時entity.setHomonJogenKanriTekiyoKikanFromYmd(dataEntity.getHomonJogenKanriTekiyoKikanFromYmd());
        受給者一時entity.setHomonJogenKanriTekiyoKikanToYmd(dataEntity.getHomonJogenKanriTekiyoKikanToYmd());
        受給者一時entity.setTankiShikyugendoKijungaku(dataEntity.getTankiShikyugendoKijungaku());
        受給者一時entity.setTankiJogenKanriTekiyoKikanFromYmd(dataEntity.getTankiJogenKanriTekiyoKikanFromYmd());
        受給者一時entity.setTankiJogenKanriTekiyoKikanToYmd(dataEntity.getTankiJogenKanriTekiyoKikanToYmd());
        受給者一時entity.setKohiFutanJogengakuGengakuUmu(dataEntity.getKohiFutanJogengakuGengakuUmu());
        受給者一時entity.setShokanHaraikaFromYmd(dataEntity.getShokanHaraikaFromYmd());
        受給者一時entity.setShokanHaraikaToYmd(dataEntity.getShokanHaraikaToYmd());
        受給者一時entity.setKyufuritsuHikisageFromYmd(dataEntity.getKyufuritsuHikisageFromYmd());
        受給者一時entity.setKyufuritsuHikisageToYmd(dataEntity.getKyufuritsuHikisageToYmd());
        受給者一時entity.setGenmenShinseichuKubunCode(dataEntity.getGenmenShinseichuKubunCode());
        受給者一時entity.setRiyoshaFutanKubunCode(dataEntity.getRiyoshaFutanKubunCode());
        受給者一時entity.setKyufuRitsu(dataEntity.getKyufuRitsu());
        受給者一時entity.setRiyoshaFutanTekiyoFromYmd(dataEntity.getRiyoshaFutanTekiyoFromYmd());
        受給者一時entity.setRiyoshaFutanTekiyoToYmd(dataEntity.getRiyoshaFutanTekiyoToYmd());
        受給者一時entity.setHyojunFutanKubunCode(dataEntity.getHyojunFutanKubunCode());
        受給者一時entity.setFutanGaku(dataEntity.getFutanGaku());
        受給者一時entity.setFutanGakuTekiyoFromYmd(dataEntity.getFutanGakuTekiyoFromYmd());
        受給者一時entity.setFutanGakuTekiyoToYmd(dataEntity.getFutanGakuTekiyoToYmd());
        受給者一時entity.setTokuteiNyushoshaNinteiShinseichuKubunCode(dataEntity.getTokuteiNyushoshaNinteiShinseichuKubunCode());
        受給者一時entity.setTokuteiNyushoshaKaigoServiceKubunCode(dataEntity.getTokuteiNyushoshaKaigoServiceKubunCode());
        受給者一時entity.setKazeisoNoTokureiGengakuSochiTaishoKubun(dataEntity.getKazeisoNoTokureiGengakuSochiTaishoKubun());
        受給者一時entity.setTokuteiNyushoshaShokuhiFutanGendoGaku(dataEntity.getTokuteiNyushoshaShokuhiFutanGendoGaku());
        受給者一時entity.setKyojuhiUnitKoshitsuFutanGendoGaku(dataEntity.getKyojuhiUnitKoshitsuFutanGendoGaku());
        受給者一時entity.setKyojuhiUnitJunkoshitsuFutanGendoGaku(dataEntity.getKyojuhiUnitJunkoshitsuFutanGendoGaku());
        受給者一時entity.setKyojuhiTokuyotoFutanGenndoGaku(dataEntity.getKyojuhiTokuyotoFutanGenndoGaku());
        受給者一時entity.setKyojuhiRokenRyoyotoFutanGendoGaku(dataEntity.getKyojuhiRokenRyoyotoFutanGendoGaku());
        受給者一時entity.setKyojuhiTashoShitsuFutanGendoGaku(dataEntity.getKyojuhiTashoShitsuFutanGendoGaku());
        受給者一時entity.setFutanGendoGakuTekiyoFromYmd(dataEntity.getFutanGendoGakuTekiyoFromYmd());
        受給者一時entity.setFutanGendoGakuTekiyoToYmd(dataEntity.getFutanGendoGakuTekiyoToYmd());
        受給者一時entity.setKeigenRitsu(dataEntity.getKeigenRitsu());
        受給者一時entity.setKeigenRitsuTekiyoFromYmd(dataEntity.getKeigenRitsuTekiyoFromYmd());
        受給者一時entity.setKeigenRitsuTekiyoToYmd(dataEntity.getKeigenRitsuTekiyoToYmd());
        受給者一時entity.setShokiboKyotakuServiceRiyoUmu(dataEntity.getShokiboKyotakuServiceRiyoUmu());
        受給者一時entity.setKokiHokenshaNo(dataEntity.getKokiHokenshaNo());
        受給者一時entity.setKokiHihokenshaNo(dataEntity.getKokiHihokenshaNo());
        受給者一時entity.setKokuhoHokenshaNo(dataEntity.getKokuhoHokenshaNo());
        受給者一時entity.setKokuhoHihokenshashoNo(dataEntity.getKokuhoHihokenshashoNo());
        受給者一時entity.setAtenaNo(dataEntity.getAtenaNo());
        受給者一時entity.setNijiyoboJigyoKubunCode(dataEntity.getNijiyoboJigyoKubunCode());
        受給者一時entity.setNijiyoboJigyoYukokikanFromYmd(dataEntity.getNijiyoboJigyoYukokikanFromYmd());
        受給者一時entity.setNijiyoboJigyoYukokikanToYmd(dataEntity.getNijiyoboJigyoYukokikanToYmd());
        受給者一時entity.setJushochiTokureiTaishoshaKubunCode(dataEntity.getJushochiTokureiTaishoshaKubunCode());
        受給者一時entity.setShisetsuShozaiHokenshaNo(dataEntity.getShisetsuShozaiHokenshaNo());
        受給者一時entity.setJushochiTokureiTekiyoFromYmd(dataEntity.getJushochiTokureiTekiyoFromYmd());
        受給者一時entity.setJushochiTokureiTekiyoToYmd(dataEntity.getJushochiTokureiTekiyoToYmd());
        受給者一時entity.setKyojuhi1FutanGendogaku(dataEntity.getKyojuhi1FutanGendogaku());
        受給者一時entity.setKyojuhi2FutanGendogaku(dataEntity.getKyojuhi2FutanGendogaku());
        受給者一時entity.setKyojuhi3FutanGendogaku(dataEntity.getKyojuhi3FutanGendogaku());
        受給者一時entity.setNiwariFutanTekiyoFromYmd(dataEntity.getNiwariFutanTekiyoFromYmd());
        受給者一時entity.setNiwariFutanTekiyoToYmd(dataEntity.getNiwariFutanTekiyoToYmd());
        受給者一時entity.setYuryoRojinHomeDoishoUmu(RString.EMPTY);
        受給者一時entity.setTsugoKekkaKubun(dataEntity.getTsugoKekkaKubun());
        受給者一時entity.setTsugoJohoKubun(dataEntity.getTsugoJohoKubun());
        受給者一時entity.setHokenshaNo(controlCsvEntity.get保険者番号());
        Hokensha hokensha = 保険者名取得.getHokensha(new HokenjaNo(controlCsvEntity.get保険者番号()));
        if (hokensha != null) {
            受給者一時entity.setHokenshaName(hokensha.get保険者名());
        }
        受給者一時entity.setTorikomiYM(処理対象年月);
        受給者情報一時tableWriter.insert(受給者一時entity);
    }

    private void 被保険者一時TBLに登録() {
        DbWT0001HihokenshaIchijiEntity 被保険者一時entity = new DbWT0001HihokenshaIchijiEntity();
        被保険者一時entity.setMeisaiRenban(連番);
        被保険者一時entity.setShoHokenshaNo(new ShoKisaiHokenshaNo(dataEntity.getShoukizaihokenshashoNo()));
        被保険者一時entity.setOrgHihokenshaNo(new HihokenshaNo(dataEntity.getHihokenshashoNo()));
        被保険者一時entity.setServiceTeikyoYmd(dataEntity.getIdoYmd());
        被保険者一時entity.setOrgHihokenshaKanaShimei(dataEntity.getHihokenshaShimeikana());
        被保険者一時entity.setOrgHihokenshaShimei(RString.EMPTY);
        被保険者一時entity.setOldShichosonCode(LasdecCode.EMPTY);
        被保険者一時entity.setHenkanHihokenshaNo(HihokenshaNo.EMPTY);
        被保険者一時entity.setHihokenshaNo(new HihokenshaNo(dataEntity.getHihokenshashoNo()));
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
