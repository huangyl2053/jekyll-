/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120030;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_TorikomiErrorKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.jukyushakoshinkekka.JukyushaKoshinKekkaReadCsvFileProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.jukyushakoshinkekka.DbWT5331JukyushaJohoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.jukyushakoshinkekka.JukyushaJohoControlCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.jukyushakoshinkekka.JukyushaJohoCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.jukyushakoshinkekka.JukyushaJohoDataCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0002KokuhorenTorikomiErrorTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.FlowEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jukyushakoshinkekka.IJukyushaKoshinKekkaMapper;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kokuhorenkyoutsuu.IKokuhorenKyoutsuuTempTableMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.hokenshainputguide.Hokensha;
import jp.co.ndensan.reams.db.dbz.service.core.hokensha.HokenshaNyuryokuHojoFinder;
import jp.co.ndensan.reams.ur.urz.definition.core.hokenja.HokenjaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchSimpleReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
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
    private IJukyushaKoshinKekkaMapper mapper;
    private IKokuhorenKyoutsuuTempTableMapper 一時mapper;
    private JukyushaJohoCsvEntity entity;
    private JukyushaJohoControlCsvEntity controlCsvEntity;
    private JukyushaJohoDataCsvEntity dataEntity;
    private List<JukyushaJohoDataCsvEntity> dataRecordList;
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

    private OutputParameter<FlowEntity> flowEntity;
    private FlowEntity returnEntity;

    @Override
    protected void initialize() {
        entity = new JukyushaJohoCsvEntity();
        dataRecordList = new ArrayList<>();
        flowEntity = new OutputParameter<>();
        returnEntity = new FlowEntity();
        flowEntity.setValue(returnEntity);
    }
    
    @Override
    protected void process(RString line) {
        List<RString> data = line.split(カンマ.toString());
        if (data != null && !data.isEmpty()) {
            if (レコード種別_コントロール.equals(data.get(INDEX_0))) {
                controlCsvEntity = ListToObjectMappingHelper.toObject(JukyushaJohoControlCsvEntity.class, data);
                コントロールレコードのレコード件数の合計++;
            } else if (レコード種別_データ.equals(data.get(INDEX_0))) {
                dataEntity = ListToObjectMappingHelper.toObject(JukyushaJohoDataCsvEntity.class, data);
                dataRecordList.add(dataEntity);
                明細件数合計++;
            }
        }
    }
    @Override
    protected void beforeExecute() {
        this.mapper = getMapper(IJukyushaKoshinKekkaMapper.class);
        this.一時mapper = getMapper(IKokuhorenKyoutsuuTempTableMapper.class);
        this.一時TBL作成();
        
    }
    @Override
    protected void afterExecute() {
        entity.setControlCsvEntity(controlCsvEntity);
        entity.setListDataEntity(dataRecordList);
        処理対象年月 = controlCsvEntity.getShoriYM();
        受給者情報明細一時TBLに登録(entity);
        returnEntity.setCodeNum(コントロールレコードのレコード件数の合計);
        returnEntity.set明細データ登録件数(明細件数合計);
        returnEntity.setShoriYM(処理対象年月);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchSimpleReader(parameter.getファイルパース());
    }
    
    /**
     * 一時テーブル(受給者情報明細一時、被保険者一時、処理結果リスト一時)作成する。
     */
    public void 一時TBL作成() {
        mapper.create受給者情報明細一時TBL();
        一時mapper.create被保険者一時TBL();
        一時mapper.create処理結果リスト一時TBL();
    }
    
    @Transaction
    private void 受給者情報明細一時TBLに登録(JukyushaJohoCsvEntity csvEntity) {
        HokenshaNyuryokuHojoFinder 保険者名取得 = HokenshaNyuryokuHojoFinder.createInstance();
            JukyushaJohoControlCsvEntity コントロールレコード = csvEntity.getControlCsvEntity();
            for (JukyushaJohoDataCsvEntity 受給者情報 : csvEntity.getListDataEntity()) {
                連番 = 連番 + 1;
                DbWT5331JukyushaJohoTempEntity 受給者一時entity = new DbWT5331JukyushaJohoTempEntity();
                受給者一時entity.set連番(連番);
                受給者一時entity.setみなし要介護区分コード(受給者情報.getMinashiYokaigoKubunCode());
                受給者一時entity.set保険者番号(コントロールレコード.getHokenshaNo());
                受給者一時entity.set交換情報識別番号(受給者情報.getKokanJohoShikibetsuNo());
                受給者一時entity.set異動年月日(受給者情報.getIdoYmd());
                受給者一時entity.set異動区分コード(受給者情報.getIdoKubunCode());
                受給者一時entity.set訂正年月日(受給者情報.getTeiseiYmd());
                受給者一時entity.set訂正区分コード(受給者情報.getTeiseiKubunCode());
                受給者一時entity.set異動事由区分(受給者情報.getIdoJiyuKubun());
                受給者一時entity.set生年月日(受給者情報.getSeinengappiYmd());
                受給者一時entity.set性別コード(受給者情報.getSeibetsuCode());
                受給者一時entity.set資格取得年月日(受給者情報.getShikakuShutokuYmd());
                受給者一時entity.set資格喪失年月日(受給者情報.getShikakuSoshitsuYmd());
                受給者一時entity.set老人保健市町村番号(受給者情報.getRojinHokenShichosonNo());
                受給者一時entity.set老人保健受給者番号(受給者情報.getRojinHokenJukyushaNo());
                受給者一時entity.set広域連合_政令市_保険者番号(受給者情報.getKoikiRengoHokenshaNo());
                受給者一時entity.set申請種別コード(受給者情報.getShinseiShubetsuCode());
                受給者一時entity.set変更申請中区分コード(受給者情報.getHenkoShinseichuKubunCode());
                受給者一時entity.set申請年月日(受給者情報.getShinseiYmd());
                受給者一時entity.set要介護状態区分コード(受給者情報.getYokaigoJotaiKubunCode());
                受給者一時entity.set認定有効期間開始年月日(受給者情報.getNinteiYukokikanFromYmd());
                受給者一時entity.set認定有効期間終了年月日(受給者情報.getNinteiYukokikanToYmd());
                受給者一時entity.set居宅サービス計画作成区分コード(受給者情報.getKyotakuServiceKubunCode());
                受給者一時entity.set居宅介護支援事業所番号(受給者情報.getKyotakuKaigoShienJigyoshoNo());
                受給者一時entity.set居宅サービス計画適用開始年月日(受給者情報.getKyotakuServiceTekiyoFromYmd());
                受給者一時entity.set居宅サービス計画適用終了年月日(受給者情報.getKyotakuServiceTekiyoToYmd());
                受給者一時entity.set訪問通所_支給限度基準額(受給者情報.getHomonShikyugendoKijungaku());
                受給者一時entity.set訪問通所_上限管理適用期間開始年月日(受給者情報.getHomonJogenKanriTekiyoKikanFromYmd());
                受給者一時entity.set訪問通所_上限管理適用期間終了年月日(受給者情報.getHomonJogenKanriTekiyoKikanToYmd());
                受給者一時entity.set短期入所_支給限度基準額(受給者情報.getTankiShikyugendoKijungaku());
                受給者一時entity.set短期入所_上限管理適用期間開始年月日(受給者情報.getTankiJogenKanriTekiyoKikanFromYmd());
                受給者一時entity.set短期入所_上限管理適用期間終了年月日(受給者情報.getTankiJogenKanriTekiyoKikanToYmd());
                受給者一時entity.set公費負担上限額減額の有無(受給者情報.getKohiFutanJogengakuGengakuUmu());
                受給者一時entity.set償還払化開始年月日(受給者情報.getShokanHaraikaFromYmd());
                受給者一時entity.set償還払化終了年月日(受給者情報.getShokanHaraikaToYmd());
                受給者一時entity.set給付率引下げ開始年月日(受給者情報.getKyufuritsuHikisageFromYmd());
                受給者一時entity.set給付率引下げ終了年月日(受給者情報.getKyufuritsuHikisageToYmd());
                受給者一時entity.set減免申請中区分コード(受給者情報.getGenmenShinseichuKubunCode());
                受給者一時entity.set利用者負担区分コード(受給者情報.getRiyoshaFutanKubunCode());
                受給者一時entity.set給付率(受給者情報.getKyufuRitsu());
                受給者一時entity.set利用者負担適用開始年月日(受給者情報.getRiyoshaFutanTekiyoFromYmd());
                受給者一時entity.set利用者負担適用終了年月日(受給者情報.getRiyoshaFutanTekiyoToYmd());
                受給者一時entity.set標準負担区分コード(受給者情報.getHyojunFutanKubunCode());
                受給者一時entity.set負担額(受給者情報.getFutanGaku());
                受給者一時entity.set負担額適用開始年月日(受給者情報.getFutanGakuTekiyoFromYmd());
                受給者一時entity.set負担額適用終了年月日(受給者情報.getFutanGakuTekiyoToYmd());
                受給者一時entity.set特定入所者認定申請中区分コード(受給者情報.getTokuteiNyushoshaNinteiShinseichuKubunCode());
                受給者一時entity.set特定入所者介護サービス区分コード(受給者情報.getTokuteiNyushoshaKaigoServiceKubunCode());
                受給者一時entity.set課税層の特例減額措置対象区分(受給者情報.getKazeisoNoTokureiGengakuSochiTaishoKubun());
                受給者一時entity.set特定入所者食費負担限度額(受給者情報.getTokuteiNyushoshaShokuhiFutanGendoGaku());
                受給者一時entity.set居住費_ユニット型個室_負担限度額(受給者情報.getKyojuhiUnitKoshitsuFutanGendoGaku());
                受給者一時entity.set居住費_ユニット型準個室_負担限度額(受給者情報.getKyojuhiUnitJunkoshitsuFutanGendoGaku());
                受給者一時entity.set居住費_従来型個室_特養等_負担限度額(受給者情報.getKyojuhiTokuyotoFutanGenndoGaku());
                受給者一時entity.set居住費_従来型個室_老健_療養等_負担限度額(受給者情報.getKyojuhiRokenRyoyotoFutanGendoGaku());
                受給者一時entity.set居住費_多床室_負担限度額(受給者情報.getKyojuhiTashoShitsuFutanGendoGaku());
                受給者一時entity.set負担限度額適用開始年月日(受給者情報.getFutanGendoGakuTekiyoFromYmd());
                受給者一時entity.set負担限度額適用終了年月日(受給者情報.getFutanGendoGakuTekiyoToYmd());
                受給者一時entity.set軽減率(受給者情報.getKeigenRitsu());
                受給者一時entity.set軽減率適用開始年月日(受給者情報.getKeigenRitsuTekiyoFromYmd());
                受給者一時entity.set軽減率適用終了年月日(受給者情報.getKeigenRitsuTekiyoToYmd());
                受給者一時entity.set小規模居宅サービス利用有無(受給者情報.getShokiboKyotakuServiceRiyoUmu());
                受給者一時entity.set保険者番号_後期_(受給者情報.getKokiHokenshaNo());
                受給者一時entity.set被保険者番号_後期_(受給者情報.getKokiHihokenshaNo());
                受給者一時entity.set保険者番号_国保_(受給者情報.getKokuhoHokenshaNo());
                受給者一時entity.set被保険者証番号_国保_(受給者情報.getKokuhoHihokenshashoNo());
                受給者一時entity.set宛名番号(受給者情報.getAtenaNo());
                受給者一時entity.set二次予防事業区分コード(受給者情報.getNijiyoboJigyoKubunCode());
                受給者一時entity.set二次予防事業有効期間開始年月日(受給者情報.getNijiyoboJigyoYukokikanFromYmd());
                受給者一時entity.set二次予防事業有効期間終了年月日(受給者情報.getNijiyoboJigyoYukokikanToYmd());
                受給者一時entity.set住所地特例対象者区分コード(受給者情報.getJushochiTokureiTaishoshaKubunCode());
                受給者一時entity.set施設所在保険者番号(受給者情報.getShisetsuShozaiHokenshaNo());
                受給者一時entity.set住所地特例適用開始年月日(受給者情報.getJushochiTokureiTekiyoFromYmd());
                受給者一時entity.set住所地特例適用終了年月日(受給者情報.getJushochiTokureiTekiyoToYmd());
                受給者一時entity.set居住費_新１_負担限度額(受給者情報.getKyojuhi1FutanGendogaku());
                受給者一時entity.set居住費_新２_負担限度額(受給者情報.getKyojuhi2FutanGendogaku());
                受給者一時entity.set居住費_新３_負担限度額(受給者情報.getKyojuhi3FutanGendogaku());
                受給者一時entity.set二割負担適用開始年月日(受給者情報.getNiwariFutanTekiyoFromYmd());
                受給者一時entity.set二割負担適用終了年月日(受給者情報.getNiwariFutanTekiyoToYmd());
                受給者一時entity.set有料老人ホーム等同意書の有無(RString.EMPTY);
                受給者一時entity.set突合結果区分(RString.EMPTY);
                受給者一時entity.set突合情報区分(RString.EMPTY);
                Hokensha hokensha = 保険者名取得.getHokensha(new HokenjaNo(コントロールレコード.getHokenshaNo()));
                if (hokensha != null) {
                    受給者一時entity.set保険者名(hokensha.get保険者名());
                }
                受給者一時entity.set取込年月(処理対象年月);
                this.mapper.受給者情報明細一時TBLに登録(受給者一時entity);
                this.被保険者一時TBLに登録(受給者情報);
                this.処理結果リスト一時に登録();
        }
    }
    
    @Transaction
    private void 被保険者一時TBLに登録(JukyushaJohoDataCsvEntity 受給者情報) {
        DbWT0001HihokenshaTempEntity 被保険者一時entity = new DbWT0001HihokenshaTempEntity();
        被保険者一時entity.set連番(連番);
        被保険者一時entity.set証記載保険者番号(new ShoKisaiHokenshaNo(受給者情報.getShoukizaihokenshashoNo()));
        被保険者一時entity.set被保険者番号(new HihokenshaNo(受給者情報.getHihokenshashoNo()));
        被保険者一時entity.setサービス提供年月末日(受給者情報.getIdoYmd());
        被保険者一時entity.set被保険者カナ氏名(受給者情報.getHihokenshaShimeikana());
        被保険者一時entity.set被保険者氏名(RString.EMPTY);
        被保険者一時entity.set旧市町村コード(LasdecCode.EMPTY);
        被保険者一時entity.set変換被保険者番号(new HihokenshaNo(受給者情報.getHihokenshashoNo()));
        被保険者一時entity.set登録被保険者番号(new HihokenshaNo(受給者情報.getHihokenshashoNo()));
        被保険者一時entity.set市町村コード(LasdecCode.EMPTY);
        被保険者一時entity.set管内管外区分(RString.EMPTY);
        被保険者一時entity.set郵便番号(RString.EMPTY);
        被保険者一時entity.set町域コード(RString.EMPTY);
        被保険者一時entity.set行政区コード(RString.EMPTY);
        被保険者一時entity.set行政区名(RString.EMPTY);
        被保険者一時entity.set住所(RString.EMPTY);
        被保険者一時entity.set番地(RString.EMPTY);
        被保険者一時entity.set方書(RString.EMPTY);
        被保険者一時entity.set宛名カナ名称(RString.EMPTY);
        被保険者一時entity.set宛名名称(RString.EMPTY);
        被保険者一時entity.set氏名50音カナ(RString.EMPTY);
        被保険者一時entity.set識別コード(RString.EMPTY);
        被保険者一時entity.set資格取得日(FlexibleDate.EMPTY);
        被保険者一時entity.set資格取得事由コード(RString.EMPTY);
        被保険者一時entity.set資格喪失日(FlexibleDate.EMPTY);
        被保険者一時entity.set資格喪失事由コード(RString.EMPTY);
        被保険者一時entity.set世帯集約番号(RString.EMPTY);
        this.一時mapper.被保険者一時TBLに登録(被保険者一時entity);
    }
    
    @Transaction
    private void 処理結果リスト一時に登録() {
        DbWT0002KokuhorenTorikomiErrorTempEntity 処理結果リスト一時entity = new DbWT0002KokuhorenTorikomiErrorTempEntity();
        処理結果リスト一時entity.setエラー区分(KokuhorenJoho_TorikomiErrorKubun.取込対象データなし.getコード());
        処理結果リスト一時entity.set証記載保険者番号(ShoKisaiHokenshaNo.EMPTY);
        処理結果リスト一時entity.set被保険者番号(HihokenshaNo.EMPTY);
        処理結果リスト一時entity.setキー1(RString.EMPTY);
        処理結果リスト一時entity.setキー2(RString.EMPTY);
        処理結果リスト一時entity.setキー3(RString.EMPTY);
        処理結果リスト一時entity.setキー4(RString.EMPTY);
        処理結果リスト一時entity.setキー5(RString.EMPTY);
        処理結果リスト一時entity.set被保険者カナ氏名(RString.EMPTY);
        処理結果リスト一時entity.set被保険者氏名(RString.EMPTY);
        処理結果リスト一時entity.set備考(RString.EMPTY);
        this.一時mapper.処理結果リスト一時TBLに登録(処理結果リスト一時entity);
    }
}
