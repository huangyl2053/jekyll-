/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.core.kaigokakushushinseishohakko;

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
import jp.co.ndensan.reams.db.dba.service.report.keidoshafukushiyogutoriatsukaikakuninshinseisho.KeidoshaFukushiyoguToriatsukaiKakuninShinseisho2;
import jp.co.ndensan.reams.db.dba.service.report.kogakugassanservice.KogakuGassanServiceHiShikyuKenJikoFutangakuShomeishoKofuShinseisho;
import jp.co.ndensan.reams.db.dba.service.report.kyotakuJutakukaishuhi.KyotakuJutakuKaishuhiShikyuShinseisho;
import jp.co.ndensan.reams.db.dba.service.report.kyotakukaigofukushi.KyotakuKaigoFukushiYoguKonyuhiShikyuShinseisho;
import jp.co.ndensan.reams.db.dba.service.report.kyotakukaigojutakukaishuhijizenshinseisho.KyotakuKaigoJutakuKaishuhiJizenShinseisho;
import jp.co.ndensan.reams.db.dba.service.report.kyufuhikariireshinseisho.KyufuhiKariireShinseisho;
import jp.co.ndensan.reams.db.dba.service.report.kyufuhikashitsukekinshokankigen.KyufuhiKashitsukekinShokankigenEnchoShinseisho;
import jp.co.ndensan.reams.db.dba.service.report.shiharaihohohenkoshuryoshinseisho.ShiharaiHohoHenkoShuryoShinseisho;
import jp.co.ndensan.reams.db.dba.service.report.shikakushutokuidososhitsu.ShikakuShutokuIdoSoshitsuTodoke;
import jp.co.ndensan.reams.db.dba.service.report.shoukanbaraijuryoininbaraishinseishochohyo.ShoukanbaraiJuryoIninbaraiShinseishoChohyo;
import jp.co.ndensan.reams.db.dba.service.report.yokaigoninteikubunhenkoshinseisho.YokaigoNinteikubunHenkoShinseisho;
import jp.co.ndensan.reams.db.dbc.service.report.daisanshakoiniyoruhigaitodokechohyo.DaisanshaKoiniyoruHigaitodokeChohyo;
import jp.co.ndensan.reams.db.dbc.service.report.kogakukaigoservicehi.KogakuKaigoServicehiShikyuJuryoIninShinseisho;
import jp.co.ndensan.reams.db.dbd.service.report.futangendogakuninteishinseisho.FutanGendogakuNinteiShinseisho;
import jp.co.ndensan.reams.db.dbd.service.report.riyoshafutangakugengakumenjyoshinseisho.RiyoshaFutangakuGengakuMenjyoShinseisho;
import jp.co.ndensan.reams.db.dbd.service.report.shakaifukushihojinfutan.ShakaiFukushiHojinFutanKeigenTaishoKakuninShinseisho;
import jp.co.ndensan.reams.db.dbd.service.report.tokubetsuchiikikasanhomonkaigo.TokubetsuChiikiKasanHomonKaigoFutanGengakuKakunin;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kaigokakushushinseishohakko.KaigoKakushuShinseishoHakkoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.RLogger;

/**
 * 介護各種申請書発行のクラスです。
 *
 * @reamsid_L DBA-0540-010 lijia
 *
 */
public class KaigoKakushuShinseishoHakko {

    private final List<KaigoKakushuShinseishoHakkoEntity> entityList = new ArrayList<>();
    private static final RString DBA800001_種類 = new RString("介護保険資格取得・異動・喪失届");
    private static final RString DBA800003_種類 = new RString("介護保険被保険者証等再交付申請書");
    private static final RString DBA800004_種類 = new RString("介護保険被保険者証交付申請書（第2号被保険者）");
    private static final RString DBA800002_種類 = new RString("介護保険住所地特例適用・変更・終了届");
    private static final RString DBD800011_種類 = new RString("介護保険受給資格証明書交付申請書");
    private static final RString DBB800001_種類 = new RString("介護保険料減免申請書");
    private static final RString DBB800002_種類 = new RString("介護保険料徴収猶予申請書");
    private static final RString DBB800003_種類 = new RString("介護保険料納付額証明書交付申請書");
    private static final RString DBD800001_種類 = new RString("介護保険負担限度額認定申請書");
    private static final RString DBD800002_種類 = new RString("介護保険利用者負担額減額・免除申請書");
    private static final RString DBD800004_種類 = new RString("介護保険特定負担限度額申請書");
    private static final RString DBD800005_種類 = new RString("訪問介護利用者負担額減額申請書");
    private static final RString DBD800006_種類 = new RString("社会福祉法人等利用者負担軽減対象確認申請書");
    private static final RString DBD800007_種類 = new RString("特別地域加算減免・訪問介護等利用者負担減額対象確認申請書");
    private static final RString DBD800008_種類 = new RString("給付額減額免除申請書");
    private static final RString DBD800009_種類 = new RString("支払方法変更（償還払い化）終了申請書");
    private static final RString DBC800001_種類 = new RString("介護保険受領委任払い取扱事業者登録申請書");
    private static final RString DBC800004_種類 = new RString("居宅（介護予防）サービス計画作成依頼（変更）届出書");
    private static final RString DBC800009_種類 = new RString("介護保険償還払支給申請書");
    private static final RString DBC800010_種類 = new RString("介護保険償還払受領委任払申請書");
    private static final RString DBC800011_種類 = new RString("介護保険居宅介護（予防）住宅改修費事前（受領委任払）申請書");
    private static final RString DBC800012_種類 = new RString("介護保険居宅介護（予防）住宅改修費支給（受領委任払）申請書");
    private static final RString DBC800013_種類 = new RString("介護保険居宅介護（予防）福祉用具購入費支給（受領委任払）申請書");
    private static final RString DBC800014_種類 = new RString("軽度者に対する福祉用具貸与の取り扱いの特例に関する確認申請書");
    private static final RString DBC800015_種類 = new RString("介護保険高額介護（予防）サービス費支給（受領委任払）申請書");
    private static final RString DBC800016_種類 = new RString("高額医療合算介護（介護予防）サービス費支給兼自己負担額証明書交付申請書");
    private static final RString DBC800017_種類 = new RString("介護保険助成金給付申請書");
    private static final RString DBC800018_種類 = new RString("介護保険給付費借入申請書");
    private static final RString DBC800019_種類 = new RString("介護保険給付費貸付金償還期限延長申請書");
    private static final RString DBC800020_種類 = new RString("第三者行為による被害届（介護保険用）");
    private static final RString DBD501002_種類 = new RString("要介護認定区分変更申請書");
    private static final RString DBC800002_種類 = new RString("介護保険受領委任払い契約申請書");
    private static final RString 資格 = new RString("資格");
    private static final RString 賦課 = new RString("賦課");
    private static final RString 認定 = new RString("認定");
    private static final RString 受給 = new RString("受給");
    private static final RString 給付 = new RString("給付");

    /**
     * 各種申請書発行画面のパラメータから、各種申請書の帳票を発行する。
     *
     * @param entityList 介護各種申請書発行情報リストEntity
     * @param 識別コード ShikibetsuCode
     * @param 被保険者番号 HihokenshaNo
     * @param 住宅福祉出力区分 RString
     */
    public void printKakushuShinseishoHakko(
            List<KaigoKakushuShinseishoHakkoEntity> entityList,
            ShikibetsuCode 識別コード,
            HihokenshaNo 被保険者番号, RString 住宅福祉出力区分) {
        if (entityList.isEmpty()) {
            RLogger.error(new RString("実行対象が選択されていません。"));
        } else {
            set業務資格の帳票発行(entityList, 識別コード, 被保険者番号);
            set業務賦課の帳票発行(entityList, 識別コード, 被保険者番号);
            set業務認定の帳票発行(entityList, 識別コード, 被保険者番号);
            set業務受給の帳票発行(entityList, 識別コード, 被保険者番号);
            set業務給付の帳票発行(entityList, 識別コード, 被保険者番号, 住宅福祉出力区分);
        }
    }

    private void set業務資格の帳票発行(
            List<KaigoKakushuShinseishoHakkoEntity> entityList,
            ShikibetsuCode 識別コード,
            HihokenshaNo 被保険者番号) {
        for (KaigoKakushuShinseishoHakkoEntity entity : entityList) {
            if (ShinseishoChohyoShurui.介護保険資格取得_異動_喪失届.getコード().equals(entity.get申請書ID())) {
                ShikakuShutokuIdoSoshitsuTodoke shikakuShutoku = new ShikakuShutokuIdoSoshitsuTodoke();
                shikakuShutoku.createShikakuShutokuIdoSoshitsuTodokeChohyo(識別コード, 被保険者番号);
            }
            if (ShinseishoChohyoShurui.介護保険被保険者証等再交付申請書.getコード().equals(entity.get申請書ID())) {
                HihokenshashonadoSaikofuShinseisho hihokenshashonado = new HihokenshashonadoSaikofuShinseisho();
                hihokenshashonado.createHihokenshashonadoSaikofuShinseishoChohyo(識別コード, 被保険者番号);
            }
            if (ShinseishoChohyoShurui.介護保険被保険者証交付申請書_第2号被保険者.getコード().equals(entity.get申請書ID())) {
                DainigoHihokenshashoKofuShinseisho dainigoHihokenshasho = new DainigoHihokenshashoKofuShinseisho();
                dainigoHihokenshasho.createDainigoHihokenshashoKofuShinseishoChohyo(識別コード, 被保険者番号);
            }
            if (ShinseishoChohyoShurui.介護保険住所地特例適用_変更_終了届.getコード().equals(entity.get申請書ID())) {
                JushochiTokureiTekiyoHenkoShuryoTodoke jushochiTokurei = new JushochiTokureiTekiyoHenkoShuryoTodoke();
                jushochiTokurei.createJushochiTokureiTekiyoHenkoShuryoTodokeChohyo(識別コード, 被保険者番号);
            }
            if (ShinseishoChohyoShurui.介護保険受給資格証明書交付申請書.getコード().equals(entity.get申請書ID())) {
                KaigoHokenJukyushikakuShomeishoKofuShinseisho kaigoHokenJukyushikaku
                        = new KaigoHokenJukyushikakuShomeishoKofuShinseisho();
                kaigoHokenJukyushikaku.createKaigoHokenJukyushikakuShomeishoKofuShinseishoChohyo(
                        識別コード, 被保険者番号);
            }
        }
    }

    private void set業務賦課の帳票発行(
            List<KaigoKakushuShinseishoHakkoEntity> entityList,
            ShikibetsuCode 識別コード,
            HihokenshaNo 被保険者番号) {
        for (KaigoKakushuShinseishoHakkoEntity entity : entityList) {
            if (ShinseishoChohyoShurui.介護保険料減免申請書.getコード().equals(entity.get申請書ID())) {
                KaigoHokenryoGenmenShinseisho hokenryoGenmenChoshuYoyu = new KaigoHokenryoGenmenShinseisho();
                hokenryoGenmenChoshuYoyu.createKaigoHokenryoGenmenShinseishoChohyo(識別コード, 被保険者番号);
            }
            if (ShinseishoChohyoShurui.介護保険料徴収猶予申請書.getコード().equals(entity.get申請書ID())) {
                ChoshuYuyoShinseisho choshuYuyoShinseisho = new ChoshuYuyoShinseisho();
                choshuYuyoShinseisho.createChoshuYuyoShinseishoChohyo(識別コード, 被保険者番号);
            }
            if (ShinseishoChohyoShurui.介護保険料納付額証明書交付申請書.getコード().equals(entity.get申請書ID())) {
                KaigoHokenryoNofugakuShomeishoKofuShinseisho kaigoHokenryoNofugaku
                        = new KaigoHokenryoNofugakuShomeishoKofuShinseisho();
                kaigoHokenryoNofugaku.createKaigoHokenryoNofugakuShomeishoKofuShinseishoChohyo(識別コード, 被保険者番号);
            }
        }
    }

    private void set業務認定の帳票発行(
            List<KaigoKakushuShinseishoHakkoEntity> entityList,
            ShikibetsuCode 識別コード,
            HihokenshaNo 被保険者番号) {
        for (KaigoKakushuShinseishoHakkoEntity entity : entityList) {
            if (ShinseishoChohyoShurui.要介護認定区分変更申請書.getコード().equals(entity.get申請書ID())) {
                YokaigoNinteikubunHenkoShinseisho yokaigoNinteikubunHenko = new YokaigoNinteikubunHenkoShinseisho();
                yokaigoNinteikubunHenko.createYokaigoNinteikubunHenkoShinseishoChohyo(識別コード, 被保険者番号);
            }
        }
    }

    private void set業務受給の帳票発行(
            List<KaigoKakushuShinseishoHakkoEntity> entityList,
            ShikibetsuCode 識別コード,
            HihokenshaNo 被保険者番号) {
        for (KaigoKakushuShinseishoHakkoEntity entity : entityList) {
            if (ShinseishoChohyoShurui.介護保険負担限度額認定申請書.getコード().equals(entity.get申請書ID())) {
                FutanGendogakuNinteiShinseisho futanGendogakuNintei = new FutanGendogakuNinteiShinseisho();
                futanGendogakuNintei.createFutanGendogakuNinteiShinseishoChohyo(識別コード, 被保険者番号);
            }
            if (ShinseishoChohyoShurui.介護保険利用者負担額減額_免除申請書.getコード().equals(entity.get申請書ID())) {
                RiyoshaFutangakuGengakuMenjyoShinseisho riyoshaFutangakuGengakuMenjyo
                        = RiyoshaFutangakuGengakuMenjyoShinseisho.createInstance();
                riyoshaFutangakuGengakuMenjyo.createKaigoHokenRiyoshaFutangakuGengakuMenjyoShinseishoChohyo(識別コード, 被保険者番号);
            }
            if (ShinseishoChohyoShurui.介護保険特定負担限度額申請書.getコード().equals(entity.get申請書ID())) {
                TokuteifutanGendogakuShinseisho tokuteifutanGendogaku = TokuteifutanGendogakuShinseisho.createInstance();
                tokuteifutanGendogaku.createTokuteifutanGendogakuShinseishoChohyo(識別コード, 被保険者番号);
            }
            if (ShinseishoChohyoShurui.訪問介護利用者負担額減額申請書.getコード().equals(entity.get申請書ID())) {
                HomonkaigoRiyoushaFutangakuGengakuShinseisho homonkaigoRiyousha
                        = new HomonkaigoRiyoushaFutangakuGengakuShinseisho();
                homonkaigoRiyousha.createHomonkaigoRiyoushaFutangakuGengakuShinseishoChohyo(識別コード, 被保険者番号);
            }
            if (ShinseishoChohyoShurui.社会福祉法人等利用者負担軽減対象確認申請書.getコード().equals(entity.get申請書ID())) {
                ShakaiFukushiHojinFutanKeigenTaishoKakuninShinseisho shakaiFukushiHojin
                        = ShakaiFukushiHojinFutanKeigenTaishoKakuninShinseisho.createInstance();
                shakaiFukushiHojin
                        .createShakaiFukushiHojinFutanKeigenTaishoKakuninShinseishoChohyo(被保険者番号, 識別コード);
            }
            if (ShinseishoChohyoShurui.特別地域加算減免_訪問介護等利用者負担減額対象確認申請書.getコード().equals(entity.get申請書ID())) {
                TokubetsuChiikiKasanHomonKaigoFutanGengakuKakunin tokubetsuChiiki
                        = TokubetsuChiikiKasanHomonKaigoFutanGengakuKakunin.createInstance();
                tokubetsuChiiki
                        .createTokubetsuChiikiKasanHomonKaigoFutanGengakuKakuninChohyo(識別コード, 被保険者番号);
            }
            if (ShinseishoChohyoShurui.給付額減額免除申請書.getコード().equals(entity.get申請書ID())) {
                KyufugakuGengakuMenjoShinseisho kyufugakuGengakuMenjo = new KyufugakuGengakuMenjoShinseisho();
                kyufugakuGengakuMenjo.createKyufugakuGengakuMenjoShinseishoChohyo(識別コード, 被保険者番号);
            }
            if (ShinseishoChohyoShurui.支払方法変更_償還払い化_終了申請書.getコード().equals(entity.get申請書ID())) {
                ShiharaiHohoHenkoShuryoShinseisho shiharaiHohoHenkoShuryo
                        = new ShiharaiHohoHenkoShuryoShinseisho();
                shiharaiHohoHenkoShuryo.createShiharaiHohoHenkoShuryoShinseishoChohyo(被保険者番号, 識別コード);
            }
        }
    }

    private void set業務給付の帳票発行(
            List<KaigoKakushuShinseishoHakkoEntity> entityList,
            ShikibetsuCode 識別コード,
            HihokenshaNo 被保険者番号,
            RString 住宅福祉出力区分) {
        for (KaigoKakushuShinseishoHakkoEntity entity : entityList) {
            if (ShinseishoChohyoShurui.介護保険受領委任払い取扱事業者登録申請書.getコード().equals(entity.get申請書ID())) {
                JuryoIninbaraiToriatsukaiJigyoshaTorokuShinseisho juryoIninbaraiToriatsukai
                        = new JuryoIninbaraiToriatsukaiJigyoshaTorokuShinseisho();
                juryoIninbaraiToriatsukai.createJuryoIninbaraiToriatsukaiJigyoshaTorokuShinseishoChohyo();
            }
            if (ShinseishoChohyoShurui.介護保険受領委任払い契約申請書.getコード().equals(entity.get申請書ID())) {
                JuryoIninbaraiKeiyakuShinseisho juryoIninbaraiKeiyaku = new JuryoIninbaraiKeiyakuShinseisho();
                juryoIninbaraiKeiyaku.createJuryoIninbaraiKeiyakuShinseishoChohyo(住宅福祉出力区分);
            }
            if (ShinseishoChohyoShurui.居宅_介護予防_サービス計画作成依頼_変更_届出書.getコード().equals(entity.get申請書ID())) {
                KyotakuServiceKeikakuSakuseiIraiTodokedesho kyotakuServiceKeikaku
                        = new KyotakuServiceKeikakuSakuseiIraiTodokedesho();
                kyotakuServiceKeikaku.createKyotakuServiceKeikakuSakuseiIraiTodokedesho(識別コード, 被保険者番号);
            }
            if (ShinseishoChohyoShurui.介護保険償還払支給申請書.getコード().equals(entity.get申請書ID())) {
                ShoukanbaraiShikyuShinseishoChohyo shoukanbaraiShikyu = new ShoukanbaraiShikyuShinseishoChohyo();
                shoukanbaraiShikyu.getShoukanbaraiShikyuShinseishoChohyo(識別コード, 被保険者番号);
            }
            if (ShinseishoChohyoShurui.介護保険償還払受領委任払申請書.getコード().equals(entity.get申請書ID())) {
                ShoukanbaraiJuryoIninbaraiShinseishoChohyo shoukanbaraiJuryo
                        = new ShoukanbaraiJuryoIninbaraiShinseishoChohyo();
                shoukanbaraiJuryo.getShoukanbaraiJuryoIninbaraiShinseishoChohyo(識別コード, 被保険者番号);
            }
            if (ShinseishoChohyoShurui.介護保険居宅介護_予防_住宅改修費事前_受領委任払_申請書.getコード().equals(entity.get申請書ID())) {
                KyotakuKaigoJutakuKaishuhiJizenShinseisho kyotakuKaigoJutaku
                        = new KyotakuKaigoJutakuKaishuhiJizenShinseisho();
                kyotakuKaigoJutaku.createKyotakuKaigoJutakuKaishuhiJizenShinseishoChohyo(識別コード, 被保険者番号);
            }
            if (ShinseishoChohyoShurui.介護保険居宅介護_予防_住宅改修費支給_受領委任払_申請書.getコード().equals(entity.get申請書ID())) {
                KyotakuJutakuKaishuhiShikyuShinseisho kyotakuJutaku
                        = new KyotakuJutakuKaishuhiShikyuShinseisho();
                kyotakuJutaku.getKyotakuJutakuKaishuhiShikyuShinseishoChohyo(識別コード, 被保険者番号);
            }
            if (ShinseishoChohyoShurui.介護保険居宅介護_予防_福祉用具購入費支給_受領委任払_申請書.getコード().equals(entity.get申請書ID())) {
                KyotakuKaigoFukushiYoguKonyuhiShikyuShinseisho kyotakuKaigo
                        = new KyotakuKaigoFukushiYoguKonyuhiShikyuShinseisho();
                kyotakuKaigo.createKyotakuKaigoFukushiYoguKonyuhiShikyuShinseishoChohyo(識別コード, 被保険者番号);
            }
            if (ShinseishoChohyoShurui.軽度者に対する福祉用具貸与の取り扱いの特例に関する確認申請書.getコード().equals(entity.get申請書ID())) {
                KeidoshaFukushiyoguToriatsukaiKakuninShinseisho keidoshaFukushiyogu
                        = new KeidoshaFukushiyoguToriatsukaiKakuninShinseisho();
                keidoshaFukushiyogu.createKeidoshaFukushiyoguToriatsukaiKakuninShinseishoChohyo(
                        識別コード, 被保険者番号);
                KeidoshaFukushiyoguToriatsukaiKakuninShinseisho2 keidoshaFukushiyogu2
                        = new KeidoshaFukushiyoguToriatsukaiKakuninShinseisho2();
                keidoshaFukushiyogu2.createKeidoshaFukushiyoguToriatsukaiKakuninShinseishoChohyo2(
                        識別コード, 被保険者番号);
            }
            if (ShinseishoChohyoShurui.介護保険高額介護_予防_サービス費支給_受領委任払_申請書.getコード().equals(entity.get申請書ID())) {
                KogakuKaigoServicehiShikyuJuryoIninShinseisho kogakuKaigoServicehi
                        = new KogakuKaigoServicehiShikyuJuryoIninShinseisho();
                kogakuKaigoServicehi
                        .createKogakuKaigoServicehiShikyuJuryoIninShinseishoChohyo(識別コード, 被保険者番号);
            }
            if (ShinseishoChohyoShurui.高額医療合算介護_介護予防_サービス費支給兼自己負担額証明書交付申請書.getコード().equals(
                    entity.get申請書ID())) {
                KogakuGassanServiceHiShikyuKenJikoFutangakuShomeishoKofuShinseisho service
                        = new KogakuGassanServiceHiShikyuKenJikoFutangakuShomeishoKofuShinseisho();
                service.createKogakuGassanServiceHiShikyuKenJikoFutangakuShomeishoKofuShinseishoChohyo(識別コード, 被保険者番号);
            }
            if (ShinseishoChohyoShurui.介護保険助成金給付申請書.getコード().equals(entity.get申請書ID())) {
                JoseikinKyufuShinseisho joseikinKyufuShinseisho = new JoseikinKyufuShinseisho();
                joseikinKyufuShinseisho.createJoseikinKyufuShinseishoChohyo(識別コード, 被保険者番号);
            }
            if (ShinseishoChohyoShurui.介護保険給付費借入申請書.getコード().equals(entity.get申請書ID())) {
                KyufuhiKariireShinseisho kyufuhiKariireShinseisho = new KyufuhiKariireShinseisho();
                kyufuhiKariireShinseisho.getKyufuhiKariireShinseishoChohyo(識別コード, 被保険者番号);
            }
            if (ShinseishoChohyoShurui.介護保険給付費貸付金償還期限延長申請書.getコード().equals(entity.get申請書ID())) {
                KyufuhiKashitsukekinShokankigenEnchoShinseisho kyufuhiKashitsukekin
                        = new KyufuhiKashitsukekinShokankigenEnchoShinseisho();
                kyufuhiKashitsukekin.createKyufuhiKashitsukekinShokankigenEnchoShinseishoChohyo(
                        識別コード, 被保険者番号);
            }
            if (ShinseishoChohyoShurui.第三者行為による被害届_介護保険用.getコード().equals(entity.get申請書ID())) {
                DaisanshaKoiniyoruHigaitodokeChohyo daisanshaKoiniyoru = DaisanshaKoiniyoruHigaitodokeChohyo.createInstance();
                daisanshaKoiniyoru.createDaisanshaKoiniyoruHigaitodokeChohyo(識別コード, 被保険者番号);
            }
        }
    }

    /**
     * Enumクラスから、介護各種申請書発行情報を取得する。
     *
     * @return List<KaigoKakushuShinseishoHakkoEntity> 介護各種申請書一覧Entityリスト
     */
    public List<KaigoKakushuShinseishoHakkoEntity> getKakushuShinseishoHakkoJoho() {

        get業務資格情報の取得();
        get業務賦課情報の取得();
        get業務認定情報の取得();
        get業務受給情報の取得();
        get業務給付情報の取得();
        return entityList;
    }

    private List<KaigoKakushuShinseishoHakkoEntity> get業務資格情報の取得() {
        if (DBA800001_種類.equals(ShinseishoChohyoShurui.介護保険資格取得_異動_喪失届.get名称())) {
            KaigoKakushuShinseishoHakkoEntity entity = new KaigoKakushuShinseishoHakkoEntity();
            entity.set申請書ID(ShinseishoChohyoShurui.介護保険資格取得_異動_喪失届.getコード());
            entity.set業務(資格);
            entity.set申請書(ShinseishoChohyoShurui.介護保険資格取得_異動_喪失届.get名称());
            entityList.add(entity);
        }
        if (DBA800003_種類.equals(ShinseishoChohyoShurui.介護保険被保険者証等再交付申請書.get名称())) {
            KaigoKakushuShinseishoHakkoEntity entity = new KaigoKakushuShinseishoHakkoEntity();
            entity.set申請書ID(ShinseishoChohyoShurui.介護保険被保険者証等再交付申請書.getコード());
            entity.set業務(資格);
            entity.set申請書(ShinseishoChohyoShurui.介護保険被保険者証等再交付申請書.get名称());
            entityList.add(entity);
        }
        if (DBA800004_種類.equals(ShinseishoChohyoShurui.介護保険被保険者証交付申請書_第2号被保険者.get名称())) {
            KaigoKakushuShinseishoHakkoEntity entity = new KaigoKakushuShinseishoHakkoEntity();
            entity.set申請書ID(ShinseishoChohyoShurui.介護保険被保険者証交付申請書_第2号被保険者.getコード());
            entity.set業務(資格);
            entity.set申請書(ShinseishoChohyoShurui.介護保険被保険者証交付申請書_第2号被保険者.get名称());
            entityList.add(entity);
        }
        if (DBA800002_種類.equals(ShinseishoChohyoShurui.介護保険住所地特例適用_変更_終了届.get名称())) {
            KaigoKakushuShinseishoHakkoEntity entity = new KaigoKakushuShinseishoHakkoEntity();
            entity.set申請書ID(ShinseishoChohyoShurui.介護保険住所地特例適用_変更_終了届.getコード());
            entity.set業務(資格);
            entity.set申請書(ShinseishoChohyoShurui.介護保険住所地特例適用_変更_終了届.get名称());
            entityList.add(entity);
        }
        if (DBD800011_種類.equals(ShinseishoChohyoShurui.介護保険受給資格証明書交付申請書.get名称())) {
            KaigoKakushuShinseishoHakkoEntity entity = new KaigoKakushuShinseishoHakkoEntity();
            entity.set申請書ID(ShinseishoChohyoShurui.介護保険受給資格証明書交付申請書.getコード());
            entity.set業務(資格);
            entity.set申請書(ShinseishoChohyoShurui.介護保険受給資格証明書交付申請書.get名称());
            entityList.add(entity);
        }
        return entityList;
    }

    private List<KaigoKakushuShinseishoHakkoEntity> get業務賦課情報の取得() {
        if (DBB800001_種類.equals(ShinseishoChohyoShurui.介護保険料減免申請書.get名称())) {
            KaigoKakushuShinseishoHakkoEntity entity = new KaigoKakushuShinseishoHakkoEntity();
            entity.set申請書ID(ShinseishoChohyoShurui.介護保険料減免申請書.getコード());
            entity.set業務(賦課);
            entity.set申請書(ShinseishoChohyoShurui.介護保険料減免申請書.get名称());
            entityList.add(entity);
        }
        if (DBB800002_種類.equals(ShinseishoChohyoShurui.介護保険料徴収猶予申請書.get名称())) {
            KaigoKakushuShinseishoHakkoEntity entity = new KaigoKakushuShinseishoHakkoEntity();
            entity.set申請書ID(ShinseishoChohyoShurui.介護保険料徴収猶予申請書.getコード());
            entity.set業務(賦課);
            entity.set申請書(ShinseishoChohyoShurui.介護保険料徴収猶予申請書.get名称());
            entityList.add(entity);
        }
        if (DBB800003_種類.equals(ShinseishoChohyoShurui.介護保険料納付額証明書交付申請書.get名称())) {
            KaigoKakushuShinseishoHakkoEntity entity = new KaigoKakushuShinseishoHakkoEntity();
            entity.set申請書ID(ShinseishoChohyoShurui.介護保険料納付額証明書交付申請書.getコード());
            entity.set業務(賦課);
            entity.set申請書(ShinseishoChohyoShurui.介護保険料納付額証明書交付申請書.get名称());
            entityList.add(entity);
        }
        return entityList;
    }

    private List<KaigoKakushuShinseishoHakkoEntity> get業務認定情報の取得() {
        if (DBD501002_種類.equals(ShinseishoChohyoShurui.要介護認定区分変更申請書.get名称())) {
            KaigoKakushuShinseishoHakkoEntity entity = new KaigoKakushuShinseishoHakkoEntity();
            entity.set申請書ID(ShinseishoChohyoShurui.要介護認定区分変更申請書.getコード());
            entity.set業務(認定);
            entity.set申請書(ShinseishoChohyoShurui.要介護認定区分変更申請書.get名称());
            entityList.add(entity);
        }
        return entityList;
    }

    private List<KaigoKakushuShinseishoHakkoEntity> get業務受給情報の取得() {
        if (DBD800001_種類.equals(ShinseishoChohyoShurui.介護保険負担限度額認定申請書.get名称())) {
            KaigoKakushuShinseishoHakkoEntity entity = new KaigoKakushuShinseishoHakkoEntity();
            entity.set申請書ID(ShinseishoChohyoShurui.介護保険負担限度額認定申請書.getコード());
            entity.set業務(受給);
            entity.set申請書(ShinseishoChohyoShurui.介護保険負担限度額認定申請書.get名称());
            entityList.add(entity);
        }
        if (DBD800002_種類.equals(ShinseishoChohyoShurui.介護保険利用者負担額減額_免除申請書.get名称())) {
            KaigoKakushuShinseishoHakkoEntity entity = new KaigoKakushuShinseishoHakkoEntity();
            entity.set申請書ID(ShinseishoChohyoShurui.介護保険利用者負担額減額_免除申請書.getコード());
            entity.set業務(受給);
            entity.set申請書(ShinseishoChohyoShurui.介護保険利用者負担額減額_免除申請書.get名称());
            entityList.add(entity);
        }
        if (DBD800004_種類.equals(ShinseishoChohyoShurui.介護保険特定負担限度額申請書.get名称())) {
            KaigoKakushuShinseishoHakkoEntity entity = new KaigoKakushuShinseishoHakkoEntity();
            entity.set申請書ID(ShinseishoChohyoShurui.介護保険特定負担限度額申請書.getコード());
            entity.set業務(受給);
            entity.set申請書(ShinseishoChohyoShurui.介護保険特定負担限度額申請書.get名称());
            entityList.add(entity);
        }
        if (DBD800005_種類.equals(ShinseishoChohyoShurui.訪問介護利用者負担額減額申請書.get名称())) {
            KaigoKakushuShinseishoHakkoEntity entity = new KaigoKakushuShinseishoHakkoEntity();
            entity.set申請書ID(ShinseishoChohyoShurui.訪問介護利用者負担額減額申請書.getコード());
            entity.set業務(受給);
            entity.set申請書(ShinseishoChohyoShurui.訪問介護利用者負担額減額申請書.get名称());
            entityList.add(entity);
        }
        if (DBD800006_種類.equals(ShinseishoChohyoShurui.社会福祉法人等利用者負担軽減対象確認申請書.get名称())) {
            KaigoKakushuShinseishoHakkoEntity entity = new KaigoKakushuShinseishoHakkoEntity();
            entity.set申請書ID(ShinseishoChohyoShurui.社会福祉法人等利用者負担軽減対象確認申請書.getコード());
            entity.set業務(受給);
            entity.set申請書(ShinseishoChohyoShurui.社会福祉法人等利用者負担軽減対象確認申請書.get名称());
            entityList.add(entity);
        }
        if (DBD800007_種類.equals(ShinseishoChohyoShurui.特別地域加算減免_訪問介護等利用者負担減額対象確認申請書.get名称())) {
            KaigoKakushuShinseishoHakkoEntity entity = new KaigoKakushuShinseishoHakkoEntity();
            entity.set申請書ID(
                    ShinseishoChohyoShurui.特別地域加算減免_訪問介護等利用者負担減額対象確認申請書.getコード());
            entity.set業務(受給);
            entity.set申請書(
                    ShinseishoChohyoShurui.特別地域加算減免_訪問介護等利用者負担減額対象確認申請書.get名称());
            entityList.add(entity);
        }
        if (DBD800008_種類.equals(ShinseishoChohyoShurui.給付額減額免除申請書.get名称())) {
            KaigoKakushuShinseishoHakkoEntity entity = new KaigoKakushuShinseishoHakkoEntity();
            entity.set申請書ID(ShinseishoChohyoShurui.給付額減額免除申請書.getコード());
            entity.set業務(受給);
            entity.set申請書(ShinseishoChohyoShurui.給付額減額免除申請書.get名称());
            entityList.add(entity);
        }
        if (DBD800009_種類.equals(ShinseishoChohyoShurui.支払方法変更_償還払い化_終了申請書.get名称())) {
            KaigoKakushuShinseishoHakkoEntity entity = new KaigoKakushuShinseishoHakkoEntity();
            entity.set申請書ID(ShinseishoChohyoShurui.支払方法変更_償還払い化_終了申請書.getコード());
            entity.set業務(受給);
            entity.set申請書(ShinseishoChohyoShurui.支払方法変更_償還払い化_終了申請書.get名称());
            entityList.add(entity);
        }
        return entityList;
    }

    private List<KaigoKakushuShinseishoHakkoEntity> get業務給付情報の取得() {
        if (DBC800001_種類.equals(ShinseishoChohyoShurui.介護保険受領委任払い取扱事業者登録申請書.get名称())) {
            KaigoKakushuShinseishoHakkoEntity entity = new KaigoKakushuShinseishoHakkoEntity();
            entity.set申請書ID(
                    ShinseishoChohyoShurui.介護保険受領委任払い取扱事業者登録申請書.getコード());
            entity.set業務(給付);
            entity.set申請書(
                    ShinseishoChohyoShurui.介護保険受領委任払い取扱事業者登録申請書.get名称());
            entityList.add(entity);
        }
        if (DBC800002_種類.equals(ShinseishoChohyoShurui.介護保険受領委任払い契約申請書.get名称())) {
            KaigoKakushuShinseishoHakkoEntity entity = new KaigoKakushuShinseishoHakkoEntity();
            entity.set申請書ID(
                    ShinseishoChohyoShurui.介護保険受領委任払い契約申請書.getコード());
            entity.set業務(給付);
            entity.set申請書(
                    ShinseishoChohyoShurui.介護保険受領委任払い契約申請書.get名称());
            entityList.add(entity);
        }
        if (DBC800004_種類.equals(ShinseishoChohyoShurui.居宅_介護予防_サービス計画作成依頼_変更_届出書.get名称())) {
            KaigoKakushuShinseishoHakkoEntity entity = new KaigoKakushuShinseishoHakkoEntity();
            entity.set申請書ID(
                    ShinseishoChohyoShurui.居宅_介護予防_サービス計画作成依頼_変更_届出書.getコード());
            entity.set業務(給付);
            entity.set申請書(
                    ShinseishoChohyoShurui.居宅_介護予防_サービス計画作成依頼_変更_届出書.get名称());
            entityList.add(entity);
        }
        if (DBC800009_種類.equals(ShinseishoChohyoShurui.介護保険償還払支給申請書.get名称())) {
            KaigoKakushuShinseishoHakkoEntity entity = new KaigoKakushuShinseishoHakkoEntity();
            entity.set申請書ID(ShinseishoChohyoShurui.介護保険償還払支給申請書.getコード());
            entity.set業務(給付);
            entity.set申請書(ShinseishoChohyoShurui.介護保険償還払支給申請書.get名称());
            entityList.add(entity);
        }
        if (DBC800010_種類.equals(ShinseishoChohyoShurui.介護保険償還払受領委任払申請書.get名称())) {
            KaigoKakushuShinseishoHakkoEntity entity = new KaigoKakushuShinseishoHakkoEntity();
            entity.set申請書ID(ShinseishoChohyoShurui.介護保険償還払受領委任払申請書.getコード());
            entity.set業務(給付);
            entity.set申請書(ShinseishoChohyoShurui.介護保険償還払受領委任払申請書.get名称());
            entityList.add(entity);
        }
        if (DBC800011_種類.equals(ShinseishoChohyoShurui.介護保険居宅介護_予防_住宅改修費事前_受領委任払_申請書.get名称())) {
            KaigoKakushuShinseishoHakkoEntity entity = new KaigoKakushuShinseishoHakkoEntity();
            entity.set申請書ID(
                    ShinseishoChohyoShurui.介護保険居宅介護_予防_住宅改修費事前_受領委任払_申請書.getコード());
            entity.set業務(給付);
            entity.set申請書(
                    ShinseishoChohyoShurui.介護保険居宅介護_予防_住宅改修費事前_受領委任払_申請書.get名称());
            entityList.add(entity);
        }
        if (DBC800012_種類.equals(ShinseishoChohyoShurui.介護保険居宅介護_予防_住宅改修費支給_受領委任払_申請書.get名称())) {
            KaigoKakushuShinseishoHakkoEntity entity = new KaigoKakushuShinseishoHakkoEntity();
            entity.set申請書ID(
                    ShinseishoChohyoShurui.介護保険居宅介護_予防_住宅改修費支給_受領委任払_申請書.getコード());
            entity.set業務(給付);
            entity.set申請書(
                    ShinseishoChohyoShurui.介護保険居宅介護_予防_住宅改修費支給_受領委任払_申請書.get名称());
            entityList.add(entity);
        }
        if (DBC800013_種類.equals(ShinseishoChohyoShurui.介護保険居宅介護_予防_福祉用具購入費支給_受領委任払_申請書.get名称())) {
            KaigoKakushuShinseishoHakkoEntity entity = new KaigoKakushuShinseishoHakkoEntity();
            entity.set申請書ID(
                    ShinseishoChohyoShurui.介護保険居宅介護_予防_福祉用具購入費支給_受領委任払_申請書.getコード());
            entity.set業務(給付);
            entity.set申請書(
                    ShinseishoChohyoShurui.介護保険居宅介護_予防_福祉用具購入費支給_受領委任払_申請書.get名称());
            entityList.add(entity);
        }
        if (DBC800014_種類.equals(ShinseishoChohyoShurui.軽度者に対する福祉用具貸与の取り扱いの特例に関する確認申請書.get名称())) {
            KaigoKakushuShinseishoHakkoEntity entity = new KaigoKakushuShinseishoHakkoEntity();
            entity.set申請書ID(
                    ShinseishoChohyoShurui.軽度者に対する福祉用具貸与の取り扱いの特例に関する確認申請書.getコード());
            entity.set業務(給付);
            entity.set申請書(
                    ShinseishoChohyoShurui.軽度者に対する福祉用具貸与の取り扱いの特例に関する確認申請書.get名称());
            entityList.add(entity);
        }
        if (DBC800015_種類.equals(ShinseishoChohyoShurui.介護保険高額介護_予防_サービス費支給_受領委任払_申請書.get名称())) {
            KaigoKakushuShinseishoHakkoEntity entity = new KaigoKakushuShinseishoHakkoEntity();
            entity.set申請書ID(
                    ShinseishoChohyoShurui.介護保険高額介護_予防_サービス費支給_受領委任払_申請書.getコード());
            entity.set業務(給付);
            entity.set申請書(
                    ShinseishoChohyoShurui.介護保険高額介護_予防_サービス費支給_受領委任払_申請書.get名称());
            entityList.add(entity);
        }
        if (DBC800016_種類.equals(ShinseishoChohyoShurui.高額医療合算介護_介護予防_サービス費支給兼自己負担額証明書交付申請書.get名称())) {
            KaigoKakushuShinseishoHakkoEntity entity = new KaigoKakushuShinseishoHakkoEntity();
            entity.set申請書ID(
                    ShinseishoChohyoShurui.高額医療合算介護_介護予防_サービス費支給兼自己負担額証明書交付申請書.getコード());
            entity.set業務(給付);
            entity.set申請書(
                    ShinseishoChohyoShurui.高額医療合算介護_介護予防_サービス費支給兼自己負担額証明書交付申請書.get名称());
            entityList.add(entity);
        }
        if (DBC800017_種類.equals(ShinseishoChohyoShurui.介護保険助成金給付申請書.get名称())) {
            KaigoKakushuShinseishoHakkoEntity entity = new KaigoKakushuShinseishoHakkoEntity();
            entity.set申請書ID(ShinseishoChohyoShurui.介護保険助成金給付申請書.getコード());
            entity.set業務(給付);
            entity.set申請書(ShinseishoChohyoShurui.介護保険助成金給付申請書.get名称());
            entityList.add(entity);
        }
        if (DBC800018_種類.equals(ShinseishoChohyoShurui.介護保険給付費借入申請書.get名称())) {
            KaigoKakushuShinseishoHakkoEntity entity = new KaigoKakushuShinseishoHakkoEntity();
            entity.set申請書ID(ShinseishoChohyoShurui.介護保険給付費借入申請書.getコード());
            entity.set業務(給付);
            entity.set申請書(ShinseishoChohyoShurui.介護保険給付費借入申請書.get名称());
            entityList.add(entity);
        }
        if (DBC800019_種類.equals(ShinseishoChohyoShurui.介護保険給付費貸付金償還期限延長申請書.get名称())) {
            KaigoKakushuShinseishoHakkoEntity entity = new KaigoKakushuShinseishoHakkoEntity();
            entity.set申請書ID(ShinseishoChohyoShurui.介護保険給付費貸付金償還期限延長申請書.getコード());
            entity.set業務(給付);
            entity.set申請書(ShinseishoChohyoShurui.介護保険給付費貸付金償還期限延長申請書.get名称());
            entityList.add(entity);
        }
        if (DBC800020_種類.equals(ShinseishoChohyoShurui.第三者行為による被害届_介護保険用.get名称())) {
            KaigoKakushuShinseishoHakkoEntity entity = new KaigoKakushuShinseishoHakkoEntity();
            entity.set申請書ID(ShinseishoChohyoShurui.第三者行為による被害届_介護保険用.getコード());
            entity.set業務(給付);
            entity.set申請書(ShinseishoChohyoShurui.第三者行為による被害届_介護保険用.get名称());
            entityList.add(entity);
        }
        return entityList;
    }
}
