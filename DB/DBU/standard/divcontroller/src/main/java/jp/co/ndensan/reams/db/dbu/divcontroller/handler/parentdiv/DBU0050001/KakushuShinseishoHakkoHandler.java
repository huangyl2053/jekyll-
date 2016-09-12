/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0050001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.core.shinseishoshurui.ShinseishoChohyoShurui;
import jp.co.ndensan.reams.db.dba.service.core.hihokenshashokoufushinseisho.DainigoHihokenshashoKofuShinseisho;
import jp.co.ndensan.reams.db.dba.service.core.hihokenshashonadosaikofushinseisho.HihokenshashonadoSaikofuShinseisho;
import jp.co.ndensan.reams.db.dba.service.core.itakuservicekeikalusakuseiiraitodokedesho.KyotakuServiceKeikakuSakuseiIraiTodokedesho;
import jp.co.ndensan.reams.db.dba.service.core.joseikinkyufushinseisho.JoseikinKyufuShinseisho;
import jp.co.ndensan.reams.db.dba.service.core.kyufugengakumenjyoshinseisho.KyufugakuGengakuMenjoShinseisho;
import jp.co.ndensan.reams.db.dba.service.core.nofugakushomeishokofushinseisho.KaigoHokenryoNofugakuShomeishoKofuShinseisho;
import jp.co.ndensan.reams.db.dba.service.core.shokanharaishikyushinseisho.ShoukanbaraiShikyuShinseishoChohyo;
import jp.co.ndensan.reams.db.dba.service.core.tokuteifutangendogakushinseishojoho.TokuteifutanGendogakuShinseisho;
import jp.co.ndensan.reams.db.dba.service.report.choshuyuyoshinseisho.ChoshuYuyoShinseisho;
import jp.co.ndensan.reams.db.dba.service.report.hokenryogenmenchoshuyoyushinseisho.KaigoHokenryoGenmenShinseisho;
import jp.co.ndensan.reams.db.dba.service.report.homonkaigoriyoushafutangakugengakushinseisho.HomonkaigoRiyoushaFutangakuGengakuShinseisho;
import jp.co.ndensan.reams.db.dba.service.report.jukyushikakushomeishokoufushinseisho.KaigoHokenJukyushikakuShomeishoKofuShinseisho;
import jp.co.ndensan.reams.db.dba.service.report.juryoininharaikeiyakushinseisho.JuryoIninbaraiKeiyakuShinseisho;
import jp.co.ndensan.reams.db.dba.service.report.juryoininharaitoriatsu.JuryoIninbaraiToriatsukaiJigyoshaTorokuShinseisho;
import jp.co.ndensan.reams.db.dba.service.report.jyushochitokureitekiyohenko.JushochiTokureiTekiyoHenkoShuryoTodoke;
import jp.co.ndensan.reams.db.dba.service.report.keidoshafukushiyogutoriatsukaikakuninshinseisho.KeidoshaFukushiyoguToriatsukaiKakuninShinseisho;
import jp.co.ndensan.reams.db.dba.service.report.kogakugassanservice.KogakuGassanServiceHiShikyuKenJikoFutangakuShomeishoKofuShinseisho;
import jp.co.ndensan.reams.db.dba.service.report.kyotakuJutakukaishuhi.KyotakuJutakuKaishuhiShikyuShinseisho;
import jp.co.ndensan.reams.db.dba.service.report.kyotakukaigofukushi.KyotakuKaigoFukushiYoguKonyuhiShikyuShinseisho;
import jp.co.ndensan.reams.db.dba.service.report.kyotakukaigojutakukaishuhijizenshinseisho.KyotakuKaigoJutakuKaishuhiJizenShinseisho;
import jp.co.ndensan.reams.db.dba.service.report.kyufuhikariireshinseisho.KyufuhiKariireShinseisho;
import jp.co.ndensan.reams.db.dba.service.report.kyufuhikashitsukekinshokankigen.KyufuhiKashitsukekinShokankigenEnchoShinseisho;
import jp.co.ndensan.reams.db.dba.service.report.shiharaihohohenkoshuryoshinseisho.ShiharaiHohoHenkoShuryoShinseisho;
import jp.co.ndensan.reams.db.dba.service.report.shikakushutokuidososhitsu.ShikakuShutokuIdoSoshitsuTodoke;
import jp.co.ndensan.reams.db.dba.service.report.shoukanbaraijuryoininbaraishinseishochohyo.ShoukanbaraiJuryoIninbaraiShinseishoChohyo;
import jp.co.ndensan.reams.db.dbc.service.report.daisanshakoiniyoruhigaitodokechohyo.DaisanshaKoiniyoruHigaitodokeChohyo;
import jp.co.ndensan.reams.db.dbc.service.report.kogakukaigoservicehi.KogakuKaigoServicehiShikyuJuryoIninShinseisho;
import jp.co.ndensan.reams.db.dbd.service.report.futangendogakuninteishinseisho.FutanGendogakuNinteiShinseisho;
import jp.co.ndensan.reams.db.dbd.service.report.riyoshafutangakugengakumenjyoshinseisho.RiyoshaFutangakuGengakuMenjyoShinseisho;
import jp.co.ndensan.reams.db.dbd.service.report.shakaifukushihojinfutan.ShakaiFukushiHojinFutanKeigenTaishoKakuninShinseisho;
import jp.co.ndensan.reams.db.dbd.service.report.tokubetsuchiikikasanhomonkaigo.TokubetsuChiikiKasanHomonKaigoFutanGengakuKakunin;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050001.KakushuShinseishoHakkoDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050001.dgKakushushinsei_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;

/**
 * 各種申請書の発行処理です。
 *
 * @reamsid_L DBA-0540-680 dongyabin
 */
public class KakushuShinseishoHakkoHandler {

    private static final RString 資格 = new RString("資格");
    private static final RString 賦課 = new RString("賦課");
    private static final RString 認定 = new RString("認定");
    private static final RString 受給 = new RString("受給");
    private static final RString 給付 = new RString("給付");
    private static final int 申請書帳票種類 = 3;
    private final KakushuShinseishoHakkoDiv div;
    private final TaishoshaKey data;

    /**
     * コンストラクタです。
     *
     * @param div 各種申請書Div
     * @param data 資格対象者
     */
    public KakushuShinseishoHakkoHandler(KakushuShinseishoHakkoDiv div,
            TaishoshaKey data) {
        this.div = div;
        this.data = data;
    }

    /**
     * 各種申請書発行の初期化処理です。
     */
    public void onLoad() {
        ShikibetsuCode 識別コード = data.get識別コード();
        div.getShikakuKihonJoho().getCcdKaigoAtenaInfo().initialize(識別コード);
        div.getShikakuKihonJoho().getCcdKaigoShikakuKihon().initialize(識別コード);
        List<dgKakushushinsei_Row> dateSource = new ArrayList<>();
        for (ShinseishoChohyoShurui 申請書帳票 : ShinseishoChohyoShurui.values()) {
            dgKakushushinsei_Row row = new dgKakushushinsei_Row(Boolean.FALSE, get業務名称(申請書帳票
                    .getコード()), 申請書帳票.get名称());
            dateSource.add(row);
        }
        CommonButtonHolder.setVisibleByCommonButtonFieldName(new RString("btnReportPublish"), false);
        div.getKakushushinseiIchiran().getDgKakushushinsei().setDataSource(dateSource);
    }

    /**
     * 各種申請書発行の帳票発行処理です。
     *
     * @return ResponseData<SourceDataCollection>
     */
    public SourceDataCollection click_帳票発行() {
        SourceDataCollection sourceData = new SourceDataCollection();
        sourceData = reportPublish(sourceData);
        return sourceData;
    }

    private SourceDataCollection reportPublish(SourceDataCollection sourceData) {
        ShikibetsuCode 識別コード = data.get識別コード();
        HihokenshaNo 被保険者番号 = data.get被保険者番号();
        List<dgKakushushinsei_Row> rowList = div.getKakushushinseiIchiran().getDgKakushushinsei().getDataSource();
        for (dgKakushushinsei_Row row : rowList) {
            if (row.getSentaku().booleanValue()) {
                if (ShinseishoChohyoShurui.介護保険資格取得_異動_喪失届.get名称().equals(row.getShinseisho())) {
                    ShikakuShutokuIdoSoshitsuTodoke todoke = new ShikakuShutokuIdoSoshitsuTodoke();
                    sourceData = todoke.createShikakuShutokuIdoSoshitsuTodokeChohyo(識別コード, 被保険者番号);
                }
                if (ShinseishoChohyoShurui.介護保険被保険者証等再交付申請書.get名称().equals(row.getShinseisho())) {
                    HihokenshashonadoSaikofuShinseisho todoke = new HihokenshashonadoSaikofuShinseisho();
                    sourceData = todoke.createHihokenshashonadoSaikofuShinseishoChohyo(識別コード, 被保険者番号);
                }
                if (ShinseishoChohyoShurui.介護保険被保険者証交付申請書_第2号被保険者.get名称().equals(row.getShinseisho())) {
                    DainigoHihokenshashoKofuShinseisho todoke = new DainigoHihokenshashoKofuShinseisho();
                    sourceData = todoke.createDainigoHihokenshashoKofuShinseishoChohyo(識別コード, 被保険者番号);
                }
                if (ShinseishoChohyoShurui.介護保険住所地特例適用_変更_終了届.get名称().equals(row.getShinseisho())) {
                    JushochiTokureiTekiyoHenkoShuryoTodoke todoke = new JushochiTokureiTekiyoHenkoShuryoTodoke();
                    sourceData = todoke.createJushochiTokureiTekiyoHenkoShuryoTodokeChohyo(識別コード, 被保険者番号);
                }
                if (ShinseishoChohyoShurui.介護保険受給資格証明書交付申請書.get名称().equals(row.getShinseisho())) {
                    KaigoHokenJukyushikakuShomeishoKofuShinseisho todoke = new KaigoHokenJukyushikakuShomeishoKofuShinseisho();
                    sourceData = todoke.createKaigoHokenJukyushikakuShomeishoKofuShinseishoChohyo(識別コード, 被保険者番号);
                }
                if (ShinseishoChohyoShurui.介護保険料減免申請書.get名称().equals(row.getShinseisho())) {
                    KaigoHokenryoGenmenShinseisho todoke = new KaigoHokenryoGenmenShinseisho();
                    sourceData = todoke.createKaigoHokenryoGenmenShinseishoChohyo(識別コード, 被保険者番号);
                }
                if (ShinseishoChohyoShurui.介護保険料徴収猶予申請書.get名称().equals(row.getShinseisho())) {
                    ChoshuYuyoShinseisho todoke = new ChoshuYuyoShinseisho();
                    sourceData = todoke.createChoshuYuyoShinseishoChohyo(識別コード, 被保険者番号);
                }
                if (ShinseishoChohyoShurui.介護保険料納付額証明書交付申請書.get名称().equals(row.getShinseisho())) {
                    KaigoHokenryoNofugakuShomeishoKofuShinseisho todoke = new KaigoHokenryoNofugakuShomeishoKofuShinseisho();
                    sourceData = todoke.createKaigoHokenryoNofugakuShomeishoKofuShinseishoChohyo(識別コード, 被保険者番号);
                }
                if (ShinseishoChohyoShurui.介護保険負担限度額認定申請書.get名称().equals(row.getShinseisho())) {
                    FutanGendogakuNinteiShinseisho todoke = new FutanGendogakuNinteiShinseisho();
                    sourceData = todoke.createFutanGendogakuNinteiShinseishoChohyo(識別コード, 被保険者番号);
                }
                if (ShinseishoChohyoShurui.介護保険利用者負担額減額_免除申請書.get名称().equals(row.getShinseisho())) {
                    sourceData = RiyoshaFutangakuGengakuMenjyoShinseisho.createInstance()
                            .createKaigoHokenRiyoshaFutangakuGengakuMenjyoShinseishoChohyo(識別コード, 被保険者番号);
                }
                if (ShinseishoChohyoShurui.介護保険利用者負担額減額_免除申請書_旧措置者用.get名称().equals(row.getShinseisho())) {
                    sourceData = RiyoshaFutangakuGengakuMenjyoShinseisho.createInstance()
                            .createKaigoHokenRiyoshaFutangakuGengakuMenjyoShinseishoChohyo(識別コード, 被保険者番号);
                }
                if (ShinseishoChohyoShurui.介護保険特定負担限度額申請書.get名称().equals(row.getShinseisho())) {
                    TokuteifutanGendogakuShinseisho todoke = TokuteifutanGendogakuShinseisho.createInstance();
                    sourceData = todoke.createTokuteifutanGendogakuShinseishoChohyo(識別コード, 被保険者番号);
                }
                if (ShinseishoChohyoShurui.訪問介護利用者負担額減額申請書.get名称().equals(row.getShinseisho())) {
                    HomonkaigoRiyoushaFutangakuGengakuShinseisho todoke = new HomonkaigoRiyoushaFutangakuGengakuShinseisho();
                    sourceData = todoke.createHomonkaigoRiyoushaFutangakuGengakuShinseishoChohyo(識別コード, 被保険者番号);
                }
                if (ShinseishoChohyoShurui.社会福祉法人等利用者負担軽減対象確認申請書.get名称().equals(row.getShinseisho())) {
                    ShakaiFukushiHojinFutanKeigenTaishoKakuninShinseisho todoke = ShakaiFukushiHojinFutanKeigenTaishoKakuninShinseisho
                            .createInstance();
                    sourceData = todoke.createShakaiFukushiHojinFutanKeigenTaishoKakuninShinseishoChohyo(被保険者番号, 識別コード);
                }
                if (ShinseishoChohyoShurui.特別地域加算減免_訪問介護等利用者負担減額対象確認申請書.get名称().equals(row.getShinseisho())) {
                    TokubetsuChiikiKasanHomonKaigoFutanGengakuKakunin todoke = TokubetsuChiikiKasanHomonKaigoFutanGengakuKakunin.createInstance();
                    sourceData = todoke.createTokubetsuChiikiKasanHomonKaigoFutanGengakuKakuninChohyo(識別コード, 被保険者番号);
                }
                if (ShinseishoChohyoShurui.給付額減額免除申請書.get名称().equals(row.getShinseisho())) {
                    KyufugakuGengakuMenjoShinseisho todoke = new KyufugakuGengakuMenjoShinseisho();
                    sourceData = todoke.createKyufugakuGengakuMenjoShinseishoChohyo(識別コード, 被保険者番号);
                }
                sourceData = reportPublish_bak(sourceData, row);
            }
        }
        return sourceData;
    }

    private SourceDataCollection reportPublish_bak(SourceDataCollection sourceData, dgKakushushinsei_Row row) {
        ShikibetsuCode 識別コード = data.get識別コード();
        HihokenshaNo 被保険者番号 = data.get被保険者番号();
        if (ShinseishoChohyoShurui.支払方法変更_償還払い化_終了申請書.get名称().equals(row.getShinseisho())) {
            ShiharaiHohoHenkoShuryoShinseisho todoke = new ShiharaiHohoHenkoShuryoShinseisho();
            sourceData = todoke.createShiharaiHohoHenkoShuryoShinseishoChohyo(被保険者番号, 識別コード);
        }
        if (ShinseishoChohyoShurui.介護保険受領委任払い取扱事業者登録申請書.get名称().equals(row.getShinseisho())) {
            JuryoIninbaraiToriatsukaiJigyoshaTorokuShinseisho todoke = new JuryoIninbaraiToriatsukaiJigyoshaTorokuShinseisho();
            sourceData = todoke.createJuryoIninbaraiToriatsukaiJigyoshaTorokuShinseishoChohyo();
        }
        if (ShinseishoChohyoShurui.介護保険受領委任払い契約申請書_福祉用具.get名称().equals(row.getShinseisho())) {
            JuryoIninbaraiKeiyakuShinseisho todoke = new JuryoIninbaraiKeiyakuShinseisho();
            sourceData = todoke.createJuryoIninbaraiKeiyakuShinseishoChohyo(new RString("2"));
        }
        if (ShinseishoChohyoShurui.介護保険受領委任払い契約申請書_住宅改修.get名称().equals(row.getShinseisho())) {
            JuryoIninbaraiKeiyakuShinseisho todoke = new JuryoIninbaraiKeiyakuShinseisho();
            sourceData = todoke.createJuryoIninbaraiKeiyakuShinseishoChohyo(new RString("1"));
        }
        if (ShinseishoChohyoShurui.居宅_介護予防_サービス計画作成依頼_変更_届出書.get名称().equals(row.getShinseisho())) {
            KyotakuServiceKeikakuSakuseiIraiTodokedesho todoke = new KyotakuServiceKeikakuSakuseiIraiTodokedesho();
            sourceData = todoke.createKyotakuServiceKeikakuSakuseiIraiTodokedesho(識別コード, 被保険者番号);
        }
        if (ShinseishoChohyoShurui.介護保険償還払支給申請書.get名称().equals(row.getShinseisho())) {
            ShoukanbaraiShikyuShinseishoChohyo todoke = new ShoukanbaraiShikyuShinseishoChohyo();
            sourceData = todoke.getShoukanbaraiShikyuShinseishoChohyo(識別コード, 被保険者番号);
        }
        if (ShinseishoChohyoShurui.介護保険償還払受領委任払申請書.get名称().equals(row.getShinseisho())) {
            ShoukanbaraiJuryoIninbaraiShinseishoChohyo todoke = new ShoukanbaraiJuryoIninbaraiShinseishoChohyo();
            sourceData = todoke.getShoukanbaraiJuryoIninbaraiShinseishoChohyo(識別コード, 被保険者番号);
        }
        if (ShinseishoChohyoShurui.介護保険居宅介護_予防_住宅改修費事前_受領委任払_申請書.get名称().equals(row.getShinseisho())) {
            KyotakuKaigoJutakuKaishuhiJizenShinseisho todoke = new KyotakuKaigoJutakuKaishuhiJizenShinseisho();
            sourceData = todoke.createKyotakuKaigoJutakuKaishuhiJizenShinseishoChohyo(識別コード, 被保険者番号);
        }
        if (ShinseishoChohyoShurui.介護保険居宅介護_予防_住宅改修費支給_受領委任払_申請書.get名称().equals(row.getShinseisho())) {
            KyotakuJutakuKaishuhiShikyuShinseisho todoke = new KyotakuJutakuKaishuhiShikyuShinseisho();
            sourceData = todoke.getKyotakuJutakuKaishuhiShikyuShinseishoChohyo(識別コード, 被保険者番号);
        }
        if (ShinseishoChohyoShurui.介護保険居宅介護_予防_福祉用具購入費支給_受領委任払_申請書.get名称().equals(row.getShinseisho())) {
            KyotakuKaigoFukushiYoguKonyuhiShikyuShinseisho todoke = new KyotakuKaigoFukushiYoguKonyuhiShikyuShinseisho();
            sourceData = todoke.createKyotakuKaigoFukushiYoguKonyuhiShikyuShinseishoChohyo(識別コード, 被保険者番号);
        }
        if (ShinseishoChohyoShurui.軽度者に対する福祉用具貸与の取り扱いの特例に関する確認申請書.get名称().equals(row.getShinseisho())) {
            KeidoshaFukushiyoguToriatsukaiKakuninShinseisho todoke = new KeidoshaFukushiyoguToriatsukaiKakuninShinseisho();
            sourceData = todoke.createKeidoshaFukushiyoguToriatsukaiKakuninShinseishoChohyo(識別コード, 被保険者番号);
        }
        if (ShinseishoChohyoShurui.介護保険高額介護_予防_サービス費支給_受領委任払_申請書.get名称().equals(row.getShinseisho())) {
            KogakuKaigoServicehiShikyuJuryoIninShinseisho todoke = new KogakuKaigoServicehiShikyuJuryoIninShinseisho();
            sourceData = todoke.createKogakuKaigoServicehiShikyuJuryoIninShinseishoChohyo(識別コード, 被保険者番号);
        }
        if (ShinseishoChohyoShurui.高額医療合算介護_介護予防_サービス費支給兼自己負担額証明書交付申請書.get名称().equals(row.getShinseisho())) {
            KogakuGassanServiceHiShikyuKenJikoFutangakuShomeishoKofuShinseisho todoke
                    = new KogakuGassanServiceHiShikyuKenJikoFutangakuShomeishoKofuShinseisho();
            sourceData = todoke.createKogakuGassanServiceHiShikyuKenJikoFutangakuShomeishoKofuShinseishoChohyo(識別コード, 被保険者番号);
        }
        if (ShinseishoChohyoShurui.介護保険助成金給付申請書.get名称().equals(row.getShinseisho())) {
            JoseikinKyufuShinseisho todoke = new JoseikinKyufuShinseisho();
            sourceData = todoke.createJoseikinKyufuShinseishoChohyo(識別コード, 被保険者番号);
        }
        if (ShinseishoChohyoShurui.介護保険給付費借入申請書.get名称().equals(row.getShinseisho())) {
            KyufuhiKariireShinseisho todoke = new KyufuhiKariireShinseisho();
            sourceData = todoke.getKyufuhiKariireShinseishoChohyo(識別コード, 被保険者番号);
        }
        if (ShinseishoChohyoShurui.介護保険給付費貸付金償還期限延長申請書.get名称().equals(row.getShinseisho())) {
            sourceData = KyufuhiKashitsukekinShokankigenEnchoShinseisho.createInstance().
                    createKyufuhiKashitsukekinShokankigenEnchoShinseishoChohyo(識別コード, 被保険者番号);
        }
        if (ShinseishoChohyoShurui.第三者行為による被害届_介護保険用.get名称().equals(row.getShinseisho())) {
            DaisanshaKoiniyoruHigaitodokeChohyo todoke = DaisanshaKoiniyoruHigaitodokeChohyo.createInstance();
            sourceData = todoke.createDaisanshaKoiniyoruHigaitodokeChohyo(識別コード, 被保険者番号);
        }
        return sourceData;
    }

    private RString get業務名称(RString 申請書帳票種類コード) {
        RString 業務コード = 申請書帳票種類コード.substring(2, 申請書帳票種類);
        RString 業務名称;
        if (new RString("A").equals(業務コード)) {
            業務名称 = 資格;
        } else if (new RString("B").equals(業務コード)) {
            業務名称 = 賦課;
        } else if (new RString("C").equals(業務コード)) {
            業務名称 = 給付;
        } else if (new RString("D").equals(業務コード)) {
            業務名称 = 受給;
        } else {
            業務名称 = 認定;
        }
        return 業務名称;
    }

}
