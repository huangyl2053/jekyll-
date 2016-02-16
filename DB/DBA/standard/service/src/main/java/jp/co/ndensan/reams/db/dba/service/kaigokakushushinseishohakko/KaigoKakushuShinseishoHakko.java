/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.kaigokakushushinseishohakko;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.core.shinseishoshurui.ShinseishoChohyoShurui;
import jp.co.ndensan.reams.db.dba.entity.kaigokakushushinseishohakko.KaigoKakushuShinseishoHakkoEntity;
import jp.co.ndensan.reams.db.dba.service.hihokenshashonadosaikofushinseisho.HihokenshashonadoSaikofuShinseisho;
import jp.co.ndensan.reams.db.dba.service.itakuservicekeikalusakuseiiraitodokedesho.KyotakuServiceKeikakuSakuseiIraiTodokedesho;
import jp.co.ndensan.reams.db.dba.service.kyufugengakumenjyoshinseisho.KyufugakuGengakuMenjoShinseisho;
import jp.co.ndensan.reams.db.dba.service.nofugakushomeishokofushinseisho.KaigoHokenryoNofugakuShomeishoKofuShinseisho;
import jp.co.ndensan.reams.db.dba.service.report.choshuyuyoshinseisho.ChoshuYuyoShinseisho;
import jp.co.ndensan.reams.db.dba.service.report.futangendogakuninteishinseisho.FutanGendogakuNinteiShinseisho;
import jp.co.ndensan.reams.db.dba.service.report.hokenryogenmenchoshuyoyushinseisho.HokenryoGenmenChoshuYoyuShinseisho;
import jp.co.ndensan.reams.db.dba.service.report.jukyushikakushomeishokoufushinseisho.KaigoHokenJukyushikakuShomeishoKofuShinseisho;
import jp.co.ndensan.reams.db.dba.service.report.juryoininharaitoriatsu.JuryoIninbaraiToriatsukaiJigyoshaTorokuShinseisho;
import jp.co.ndensan.reams.db.dba.service.report.jyushochitokureitekiyohenko.JushochiTokureiTekiyoHenkoShuryoTodoke;
import jp.co.ndensan.reams.db.dba.service.report.keidoshafukushiyogutoriatsukaikakuninshinseisho.KeidoshaFukushiyoguToriatsukaiKakuninShinseisho;
import jp.co.ndensan.reams.db.dba.service.report.keidoshafukushiyogutoriatsukaikakuninshinseisho.KeidoshaFukushiyoguToriatsukaiKakuninShinseisho2;
import jp.co.ndensan.reams.db.dba.service.report.kyotakukaigojutakukaishuhijizenshinseisho.KyotakuKaigoJutakuKaishuhiJizenShinseisho;
import jp.co.ndensan.reams.db.dba.service.report.kyufuhikariireshinseisho.KyufuhiKariireShinseisho;
import jp.co.ndensan.reams.db.dba.service.report.kyufuhikashitsukekinshokankigen.KyufuhiKashitsukekinShokankigenEnchoShinseisho;
import jp.co.ndensan.reams.db.dba.service.report.shikakushutokuidososhitsu.ShikakuShutokuIdoSoshitsuTodoke;
import jp.co.ndensan.reams.db.dba.service.report.shoukanbaraijuryoininbaraishinseishochohyo.ShoukanbaraiJuryoIninbaraiShinseishoChohyo;
import jp.co.ndensan.reams.db.dba.service.riyoshafutangakugengakumenjyoshinseisho.RiyoshaFutangakuGengakuMenjyoShinseisho;
import jp.co.ndensan.reams.db.dba.service.shokanharaishikyushinseisho.ShoukanbaraiShikyuShinseishoChohyo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護各種申請書発行のクラスです。
 *
 */
public class KaigoKakushuShinseishoHakko {

    private List<KaigoKakushuShinseishoHakkoEntity> kaigoKakushuShinseishoHakkoEntityList = new ArrayList<>();
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
    //private static final RString DBD800003_種類 = new RString("介護保険利用者負担額減額・免除申請書(旧措置者用）");
    private static final RString DBD800004_種類 = new RString("介護保険特定負担限度額申請書");
    private static final RString DBD800005_種類 = new RString("訪問介護利用者負担額減額申請書");
    private static final RString DBD800006_種類 = new RString("社会福祉法人等利用者負担軽減対象確認申請書");
    private static final RString DBD800007_種類 = new RString("特別地域加算減免・訪問介護等利用者負担減額対象確認申請書");
    private static final RString DBD800008_種類 = new RString("給付額減額免除申請書");
    private static final RString DBD800009_種類 = new RString("支払方法変更（償還払い化）終了申請書");
    private static final RString DBC800001_種類 = new RString("介護保険受領委任払い取扱事業者登録申請書");
    //private static final RString DBC800002_種類 = new RString("介護保険受領委任払い契約申請書(福祉用具）");
    //private static final RString DBC800003_種類 = new RString("介護保険受領委任払い契約申請書(住宅改修）");
    private static final RString DBC800004_種類 = new RString("居宅（介護予防）サービス計画作成依頼（変更）届出書");
    private static final RString DBC800008_種類 = new RString("介護保険居宅介護サービス計画の作成（自己作成）");
    //private static final RString DBC800005_種類 = new RString("福祉用具購入費申請書");
    //private static final RString DBC800006_種類 = new RString("住宅改修費事前支給申請書");
    //private static final RString DBC800007_種類 = new RString("住宅改修費支給申請書");
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
    private static final RString 資格 = new RString("資格");
    private static final RString 賦課 = new RString("賦課");
    private static final RString 認定 = new RString("認定");
    private static final RString 受給 = new RString("受給");
    private static final RString 給付 = new RString("給付");
    private static final RString 実行対象 = new RString("実行対象");

    /**
     * 各種申請書発行画面のパラメータから、各種申請書の帳票を発行する。
     *
     * @param kaigoKakushuShinseishoHakkoEntityList 介護各種申請書発行情報リストEntity
     * @param 識別コード ShikibetsuCode
     * @param 被保険者番号 HihokenshaNo
     */
    public void printKakushuShinseishoHakko(
            List<KaigoKakushuShinseishoHakkoEntity> kaigoKakushuShinseishoHakkoEntityList,
            ShikibetsuCode 識別コード,
            HihokenshaNo 被保険者番号) {
        識別コード = new ShikibetsuCode("000000000022502");
        被保険者番号 = new HihokenshaNo("20160203");
        if (kaigoKakushuShinseishoHakkoEntityList.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.選択されていない.getMessage().replace(実行対象.toString()));
        } else {
            set業務資格の帳票発行(kaigoKakushuShinseishoHakkoEntityList, 識別コード, 被保険者番号);
            set業務賦課の帳票発行(kaigoKakushuShinseishoHakkoEntityList, 識別コード, 被保険者番号);
            set業務受給の帳票発行(kaigoKakushuShinseishoHakkoEntityList, 識別コード, 被保険者番号);
            set業務給付の帳票発行(kaigoKakushuShinseishoHakkoEntityList, 識別コード, 被保険者番号);
        }
    }

    private void set業務資格の帳票発行(
            List<KaigoKakushuShinseishoHakkoEntity> kaigoKakushuShinseishoHakkoEntityList,
            ShikibetsuCode 識別コード,
            HihokenshaNo 被保険者番号) {
        for (KaigoKakushuShinseishoHakkoEntity entity : kaigoKakushuShinseishoHakkoEntityList) {
            if (ShinseishoChohyoShurui.介護保険資格取得_異動_喪失届.getコード().equals(entity.get申請書ID())) {
                ShikakuShutokuIdoSoshitsuTodoke shikakuShutokuIdoSoshitsuTodoke = new ShikakuShutokuIdoSoshitsuTodoke();
                shikakuShutokuIdoSoshitsuTodoke.createKaigoHokenJukyushikakuShomeishoKofuShinseishoChohyo(識別コード, 被保険者番号);
            }
            if (ShinseishoChohyoShurui.介護保険被保険者証等再交付申請書.getコード().equals(entity.get申請書ID())) {
                HihokenshashonadoSaikofuShinseisho hihokenshashonadoSaikofuShinseisho = new HihokenshashonadoSaikofuShinseisho();
                hihokenshashonadoSaikofuShinseisho.createHihokenshashonadoSaikofuShinseishoChohyo(識別コード, 被保険者番号);
            }
            if (ShinseishoChohyoShurui.介護保険被保険者証交付申請書_第2号被保険者.getコード().equals(entity.get申請書ID())) {
                //TODO ビジネス設計_DBAMN12001_介護保険被保険者証交付申請書（第2号被保険者）未実装
            }
            if (ShinseishoChohyoShurui.介護保険住所地特例適用_変更_終了届.getコード().equals(entity.get申請書ID())) {
                JushochiTokureiTekiyoHenkoShuryoTodoke jushochiTokureiTekiyoHenkoShuryoTodoke = new JushochiTokureiTekiyoHenkoShuryoTodoke();
                jushochiTokureiTekiyoHenkoShuryoTodoke.createJushochiTokureiTekiyoHenkoShuryoTodokeChohyo(識別コード, 被保険者番号);
            }
            if (ShinseishoChohyoShurui.介護保険受給資格証明書交付申請書.getコード().equals(entity.get申請書ID())) {
                KaigoHokenJukyushikakuShomeishoKofuShinseisho kaigoHokenJukyushikakuShomeishoKofuShinseisho
                        = new KaigoHokenJukyushikakuShomeishoKofuShinseisho();
                kaigoHokenJukyushikakuShomeishoKofuShinseisho.createKaigoHokenJukyushikakuShomeishoKofuShinseishoChohyo(
                        識別コード, 被保険者番号);
            }
        }
    }

    private void set業務賦課の帳票発行(
            List<KaigoKakushuShinseishoHakkoEntity> kaigoKakushuShinseishoHakkoEntityList,
            ShikibetsuCode 識別コード,
            HihokenshaNo 被保険者番号) {
        for (KaigoKakushuShinseishoHakkoEntity entity : kaigoKakushuShinseishoHakkoEntityList) {
            if (ShinseishoChohyoShurui.介護保険料減免申請書.getコード().equals(entity.get申請書ID())) {
                HokenryoGenmenChoshuYoyuShinseisho hokenryoGenmenChoshuYoyuShinseisho = new HokenryoGenmenChoshuYoyuShinseisho();
                hokenryoGenmenChoshuYoyuShinseisho.createKaigoHokenryoGenmenShinseishoChohyo(識別コード, 被保険者番号);
            }
            if (ShinseishoChohyoShurui.介護保険料徴収猶予申請書.getコード().equals(entity.get申請書ID())) {
                ChoshuYuyoShinseisho choshuYuyoShinseisho = new ChoshuYuyoShinseisho();
                choshuYuyoShinseisho.createChoshuYuyoShinseishoChohyo(識別コード, 被保険者番号);
            }
            if (ShinseishoChohyoShurui.介護保険料納付額証明書交付申請書.getコード().equals(entity.get申請書ID())) {
                KaigoHokenryoNofugakuShomeishoKofuShinseisho kaigoHokenryoNofugakuShomeishoKofuShinseisho
                        = new KaigoHokenryoNofugakuShomeishoKofuShinseisho();
                kaigoHokenryoNofugakuShomeishoKofuShinseisho.createKaigoHokenryoNofugakuShomeishoKofuShinseishoChohyo(識別コード, 被保険者番号);
            }
        }
    }

    private void set業務受給の帳票発行(
            List<KaigoKakushuShinseishoHakkoEntity> kaigoKakushuShinseishoHakkoEntityList,
            ShikibetsuCode 識別コード,
            HihokenshaNo 被保険者番号) {
        for (KaigoKakushuShinseishoHakkoEntity entity : kaigoKakushuShinseishoHakkoEntityList) {
            if (ShinseishoChohyoShurui.介護保険負担限度額認定申請書.getコード().equals(entity.get申請書ID())) {
                FutanGendogakuNinteiShinseisho futanGendogakuNinteiShinseisho = new FutanGendogakuNinteiShinseisho();
                futanGendogakuNinteiShinseisho.createFutanGendogakuNinteiShinseishoChohyo(識別コード, 被保険者番号);
            }
            if (ShinseishoChohyoShurui.介護保険利用者負担額減額_免除申請書.getコード().equals(entity.get申請書ID())) {
                RiyoshaFutangakuGengakuMenjyoShinseisho riyoshaFutangakuGengakuMenjyoShinseisho
                        = RiyoshaFutangakuGengakuMenjyoShinseisho.createInstance();
                riyoshaFutangakuGengakuMenjyoShinseisho.createKaigoHokenRiyoshaFutangakuGengakuMenjyoShinseishoChohyo(識別コード, 被保険者番号);

            }
            if (ShinseishoChohyoShurui.介護保険特定負担限度額申請書.getコード().equals(entity.get申請書ID())) {
                // TODO ビジネス設計_DBAMN12001_介護保険特定負担限度額申請書 未実装
            }
            if (ShinseishoChohyoShurui.訪問介護利用者負担額減額申請書.getコード().equals(entity.get申請書ID())) {
                // TODO ビジネス設計_DBAMN12001_訪問介護利用者負担額減額申請書 未実装
            }
            if (ShinseishoChohyoShurui.社会福祉法人等利用者負担軽減対象確認申請書.getコード().equals(entity.get申請書ID())) {
                // TODO ビジネス設計_DBAMN12001_社会福祉法人等利用者負担軽減対象確認申請書 未実装
            }
            if (ShinseishoChohyoShurui.特別地域加算減免_訪問介護等利用者負担減額対象確認申請書.getコード().equals(entity.get申請書ID())) {
                // TODO ビジネス設計_DBAMN12001_特別地域加算減免・訪問介護等利用者負担減額対象確認申請書 未実装
            }
            if (ShinseishoChohyoShurui.給付額減額免除申請書.getコード().equals(entity.get申請書ID())) {
                KyufugakuGengakuMenjoShinseisho kyufugakuGengakuMenjoShinseisho = new KyufugakuGengakuMenjoShinseisho();
                kyufugakuGengakuMenjoShinseisho.createKyufugakuGengakuMenjoShinseishoChohyo(識別コード, 被保険者番号);
            }
            if (ShinseishoChohyoShurui.支払方法変更_償還払い化_終了申請書.getコード().equals(entity.get申請書ID())) {
                //ShiharaiHenkoShokanbaraikaShoryoShinseishoPrintService ShiharaiHenkoShokanbaraikaShoryoShinseishoPrintService =
                //new ShiharaiHenkoShokanbaraikaShoryoShinseishoPrintService();
                // TODO ビジネス設計_DBAMN12001_支払方法変更（償還払い化）終了申請書 ソース未提交
                // TODO 类名方法名错误，未使用式样的
            }
        }
    }

    private void set業務給付の帳票発行(
            List<KaigoKakushuShinseishoHakkoEntity> kaigoKakushuShinseishoHakkoEntityList,
            ShikibetsuCode 識別コード,
            HihokenshaNo 被保険者番号) {
        for (KaigoKakushuShinseishoHakkoEntity entity : kaigoKakushuShinseishoHakkoEntityList) {
            if (ShinseishoChohyoShurui.介護保険受領委任払い取扱事業者登録申請書.getコード().equals(entity.get申請書ID())) {
                JuryoIninbaraiToriatsukaiJigyoshaTorokuShinseisho juryoIninbaraiToriatsukaiJigyoshaTorokuShinseisho
                        = new JuryoIninbaraiToriatsukaiJigyoshaTorokuShinseisho();
                juryoIninbaraiToriatsukaiJigyoshaTorokuShinseisho.createJuryoIninbaraiToriatsukaiJigyoshaTorokuShinseishoChohyo();
            }
            if (ShinseishoChohyoShurui.居宅_介護予防_サービス計画作成依頼_変更_届出書.getコード().equals(entity.get申請書ID())) {
                KyotakuServiceKeikakuSakuseiIraiTodokedesho kyotakuServiceKeikakuSakuseiIraiTodokedesho
                        = new KyotakuServiceKeikakuSakuseiIraiTodokedesho();
                kyotakuServiceKeikakuSakuseiIraiTodokedesho.createKyotakuServiceKeikakuSakuseiIraiTodokedesho(識別コード, 被保険者番号);
            }
            if (ShinseishoChohyoShurui.介護保険居宅介護サービス計画の作成_自己作成.getコード().equals(entity.get申請書ID())) {
                // TODO 设计书未提供
            }
            if (ShinseishoChohyoShurui.介護保険償還払支給申請書.getコード().equals(entity.get申請書ID())) {
                ShoukanbaraiShikyuShinseishoChohyo shoukanbaraiShikyuShinseishoChohyo = new ShoukanbaraiShikyuShinseishoChohyo();
                shoukanbaraiShikyuShinseishoChohyo.getShoukanbaraiShikyuShinseishoChohyo(識別コード, 被保険者番号);
            }
            if (ShinseishoChohyoShurui.介護保険償還払受領委任払申請書.getコード().equals(entity.get申請書ID())) {
                ShoukanbaraiJuryoIninbaraiShinseishoChohyo shoukanbaraiJuryoIninbaraiShinseishoChohyo
                        = new ShoukanbaraiJuryoIninbaraiShinseishoChohyo();
                shoukanbaraiJuryoIninbaraiShinseishoChohyo.getShoukanbaraiJuryoIninbaraiShinseishoChohyo(識別コード, 被保険者番号);
            }
            if (ShinseishoChohyoShurui.介護保険居宅介護_予防_住宅改修費事前_受領委任払_申請書.getコード().equals(entity.get申請書ID())) {
                KyotakuKaigoJutakuKaishuhiJizenShinseisho kyotakuKaigoJutakuKaishuhiJizenShinseisho
                        = new KyotakuKaigoJutakuKaishuhiJizenShinseisho();
                kyotakuKaigoJutakuKaishuhiJizenShinseisho.createKyotakuKaigoJutakuKaishuhiJizenShinseishoChohyo(識別コード, 被保険者番号);
            }
            if (ShinseishoChohyoShurui.介護保険居宅介護_予防_住宅改修費支給_受領委任払_申請書.getコード().equals(entity.get申請書ID())) {
//                KyotakuJutakuKaishuhiShikyuShinseishoPrintService kyotakuJutakuKaishuhiShikyuShinseishoPrintService
//                        = new KyotakuJutakuKaishuhiShikyuShinseishoPrintService();
//                kyotakuJutakuKaishuhiShikyuShinseishoPrintService.print(識別コード, 被保険者番号);
                // TODO 类名方法名错误，未使用式样的
            }
            if (ShinseishoChohyoShurui.介護保険居宅介護_予防_福祉用具購入費支給_受領委任払_申請書.getコード().equals(entity.get申請書ID())) {
//                KyotakuKaigoFukushiYoguKonyuhiShikyuShinseishoPrintService kyotakuKaigoFukushiYoguKonyuhiShikyuShinseishoPrintService
//                        = new KyotakuKaigoFukushiYoguKonyuhiShikyuShinseishoPrintService();
//                kyotakuKaigoFukushiYoguKonyuhiShikyuShinseishoPrintService.print(識別コード, 被保険者番号);
                // TODO 类名方法名错误，未使用式样的
            }
            if (ShinseishoChohyoShurui.軽度者に対する福祉用具貸与の取り扱いの特例に関する確認申請書.getコード().equals(entity.get申請書ID())) {
                KeidoshaFukushiyoguToriatsukaiKakuninShinseisho keidoshaFukushiyoguToriatsukaiKakuninShinseisho
                        = new KeidoshaFukushiyoguToriatsukaiKakuninShinseisho();
                keidoshaFukushiyoguToriatsukaiKakuninShinseisho.createKeidoshaFukushiyoguToriatsukaiKakuninShinseishoChohyo(
                        識別コード, 被保険者番号);
                KeidoshaFukushiyoguToriatsukaiKakuninShinseisho2 keidoshaFukushiyoguToriatsukaiKakuninShinseisho2
                        = new KeidoshaFukushiyoguToriatsukaiKakuninShinseisho2();
                keidoshaFukushiyoguToriatsukaiKakuninShinseisho2.createKeidoshaFukushiyoguToriatsukaiKakuninShinseishoChohyo2(
                        識別コード, 被保険者番号);
            }
            if (ShinseishoChohyoShurui.介護保険高額介護_予防_サービス費支給_受領委任払_申請書.getコード().equals(entity.get申請書ID())) {
//                KogakuKaigoServicehiShikyuJuryoIninShinseishoPrintService kogakuKaigoServicehiShikyuJuryoIninShinseishoPrintService
//                        = new KogakuKaigoServicehiShikyuJuryoIninShinseishoPrintService();
//                kogakuKaigoServicehiShikyuJuryoIninShinseishoPrintService.print(識別コード, 被保険者番号);
                // TODO 类名方法名错误，未使用式样的
            }
            if (ShinseishoChohyoShurui.高額医療合算介護_介護予防_サービス費支給兼自己負担額証明書交付申請書.getコード().equals(
                    entity.get申請書ID())) {
//                KogakuGassanServiceHiShikyuKenJikoFutangakuShomeishoKofuShinseishoPrintService service
//                        = new KogakuGassanServiceHiShikyuKenJikoFutangakuShomeishoKofuShinseishoPrintService();
//                service.print(識別コード, 被保険者番号);
                // TODO 类名方法名错误，未使用式样的
            }
            if (ShinseishoChohyoShurui.介護保険助成金給付申請書.getコード().equals(entity.get申請書ID())) {
                // TODO ビジネス設計_DBAMN12001_介護保険助成金給付申請書 未実装
            }
            if (ShinseishoChohyoShurui.介護保険給付費借入申請書.getコード().equals(entity.get申請書ID())) {
                KyufuhiKariireShinseisho kyufuhiKariireShinseisho = new KyufuhiKariireShinseisho();
                kyufuhiKariireShinseisho.getKyufuhiKariireShinseishoChohyo(識別コード, 被保険者番号);
            }
            if (ShinseishoChohyoShurui.介護保険給付費貸付金償還期限延長申請書.getコード().equals(entity.get申請書ID())) {
                KyufuhiKashitsukekinShokankigenEnchoShinseisho kyufuhiKashitsukekinShokankigenEnchoShinseisho
                        = new KyufuhiKashitsukekinShokankigenEnchoShinseisho();
                kyufuhiKashitsukekinShokankigenEnchoShinseisho.createKyufuhiKashitsukekinShokankigenEnchoShinseishoChohyo(
                        識別コード, 被保険者番号);
            }
            if (ShinseishoChohyoShurui.第三者行為による被害届_介護保険用.getコード().equals(entity.get申請書ID())) {
                // TODO ビジネス設計_DBAMN12001_第三者行為による被害届（介護保険用） 未実装
            }
        }
    }

    /**
     * Enumクラスから、介護各種申請書発行情報を取得する。
     *
     * @return List<KaigoKakushuShinseishoHakkoEntity> 介護各種申請書一覧Entityリスト
     */
    public List<KaigoKakushuShinseishoHakkoEntity> getKakushuShinseishoHakkoJoho() {
        List<KaigoKakushuShinseishoHakkoEntity> 業務資格情報リスト = get業務資格情報の取得();
        List<KaigoKakushuShinseishoHakkoEntity> 業務賦課情報リスト = get業務賦課情報の取得();
        List<KaigoKakushuShinseishoHakkoEntity> 業務受給情報リスト = get業務受給情報の取得();
        List<KaigoKakushuShinseishoHakkoEntity> 業務給付情報リスト = get業務給付情報の取得();
        for (KaigoKakushuShinseishoHakkoEntity 業務資格情報 : 業務資格情報リスト) {
            kaigoKakushuShinseishoHakkoEntityList.add(業務資格情報);
        }
        for (KaigoKakushuShinseishoHakkoEntity 業務賦課情報 : 業務賦課情報リスト) {
            kaigoKakushuShinseishoHakkoEntityList.add(業務賦課情報);
        }
        for (KaigoKakushuShinseishoHakkoEntity 業務受給情報 : 業務受給情報リスト) {
            kaigoKakushuShinseishoHakkoEntityList.add(業務受給情報);
        }
        for (KaigoKakushuShinseishoHakkoEntity 業務給付情報 : 業務給付情報リスト) {
            kaigoKakushuShinseishoHakkoEntityList.add(業務給付情報);
        }
        return kaigoKakushuShinseishoHakkoEntityList;
    }

    private List<KaigoKakushuShinseishoHakkoEntity> get業務資格情報の取得() {
        if (DBA800001_種類.equals(ShinseishoChohyoShurui.介護保険資格取得_異動_喪失届.get名称())) {
            KaigoKakushuShinseishoHakkoEntity kaigoKakushuShinseishoHakkoEntity = new KaigoKakushuShinseishoHakkoEntity();
            kaigoKakushuShinseishoHakkoEntity.set申請書ID(ShinseishoChohyoShurui.介護保険資格取得_異動_喪失届.getコード());
            kaigoKakushuShinseishoHakkoEntity.set業務(資格);
            kaigoKakushuShinseishoHakkoEntity.set申請書(ShinseishoChohyoShurui.介護保険資格取得_異動_喪失届.get名称());
            kaigoKakushuShinseishoHakkoEntityList.add(kaigoKakushuShinseishoHakkoEntity);
        }
        if (DBA800003_種類.equals(ShinseishoChohyoShurui.介護保険被保険者証等再交付申請書.get名称())) {
            KaigoKakushuShinseishoHakkoEntity kaigoKakushuShinseishoHakkoEntity = new KaigoKakushuShinseishoHakkoEntity();
            kaigoKakushuShinseishoHakkoEntity.set申請書ID(ShinseishoChohyoShurui.介護保険被保険者証等再交付申請書.getコード());
            kaigoKakushuShinseishoHakkoEntity.set業務(資格);
            kaigoKakushuShinseishoHakkoEntity.set申請書(ShinseishoChohyoShurui.介護保険被保険者証等再交付申請書.get名称());
            kaigoKakushuShinseishoHakkoEntityList.add(kaigoKakushuShinseishoHakkoEntity);
        }
        if (DBA800004_種類.equals(ShinseishoChohyoShurui.介護保険被保険者証交付申請書_第2号被保険者.get名称())) {
            KaigoKakushuShinseishoHakkoEntity kaigoKakushuShinseishoHakkoEntity = new KaigoKakushuShinseishoHakkoEntity();
            kaigoKakushuShinseishoHakkoEntity.set申請書ID(ShinseishoChohyoShurui.介護保険被保険者証交付申請書_第2号被保険者.getコード());
            kaigoKakushuShinseishoHakkoEntity.set業務(資格);
            kaigoKakushuShinseishoHakkoEntity.set申請書(ShinseishoChohyoShurui.介護保険被保険者証交付申請書_第2号被保険者.get名称());
            kaigoKakushuShinseishoHakkoEntityList.add(kaigoKakushuShinseishoHakkoEntity);
        }
        if (DBA800002_種類.equals(ShinseishoChohyoShurui.介護保険住所地特例適用_変更_終了届.get名称())) {
            KaigoKakushuShinseishoHakkoEntity kaigoKakushuShinseishoHakkoEntity = new KaigoKakushuShinseishoHakkoEntity();
            kaigoKakushuShinseishoHakkoEntity.set申請書ID(ShinseishoChohyoShurui.介護保険住所地特例適用_変更_終了届.getコード());
            kaigoKakushuShinseishoHakkoEntity.set業務(資格);
            kaigoKakushuShinseishoHakkoEntity.set申請書(ShinseishoChohyoShurui.介護保険住所地特例適用_変更_終了届.get名称());
            kaigoKakushuShinseishoHakkoEntityList.add(kaigoKakushuShinseishoHakkoEntity);
        }
        if (DBD800011_種類.equals(ShinseishoChohyoShurui.介護保険受給資格証明書交付申請書.get名称())) {
            KaigoKakushuShinseishoHakkoEntity kaigoKakushuShinseishoHakkoEntity = new KaigoKakushuShinseishoHakkoEntity();
            kaigoKakushuShinseishoHakkoEntity.set申請書ID(ShinseishoChohyoShurui.介護保険受給資格証明書交付申請書.getコード());
            kaigoKakushuShinseishoHakkoEntity.set業務(資格);
            kaigoKakushuShinseishoHakkoEntity.set申請書(ShinseishoChohyoShurui.介護保険受給資格証明書交付申請書.get名称());
            kaigoKakushuShinseishoHakkoEntityList.add(kaigoKakushuShinseishoHakkoEntity);
        }
        return kaigoKakushuShinseishoHakkoEntityList;
    }

    private List<KaigoKakushuShinseishoHakkoEntity> get業務賦課情報の取得() {
        if (DBB800001_種類.equals(ShinseishoChohyoShurui.介護保険料減免申請書.get名称())) {
            KaigoKakushuShinseishoHakkoEntity kaigoKakushuShinseishoHakkoEntity = new KaigoKakushuShinseishoHakkoEntity();
            kaigoKakushuShinseishoHakkoEntity.set申請書ID(ShinseishoChohyoShurui.介護保険料減免申請書.getコード());
            kaigoKakushuShinseishoHakkoEntity.set業務(賦課);
            kaigoKakushuShinseishoHakkoEntity.set申請書(ShinseishoChohyoShurui.介護保険料減免申請書.get名称());
            kaigoKakushuShinseishoHakkoEntityList.add(kaigoKakushuShinseishoHakkoEntity);
        }
        if (DBB800002_種類.equals(ShinseishoChohyoShurui.介護保険料徴収猶予申請書.get名称())) {
            KaigoKakushuShinseishoHakkoEntity kaigoKakushuShinseishoHakkoEntity = new KaigoKakushuShinseishoHakkoEntity();
            kaigoKakushuShinseishoHakkoEntity.set申請書ID(ShinseishoChohyoShurui.介護保険料徴収猶予申請書.getコード());
            kaigoKakushuShinseishoHakkoEntity.set業務(賦課);
            kaigoKakushuShinseishoHakkoEntity.set申請書(ShinseishoChohyoShurui.介護保険料徴収猶予申請書.get名称());
            kaigoKakushuShinseishoHakkoEntityList.add(kaigoKakushuShinseishoHakkoEntity);
        }
        if (DBB800003_種類.equals(ShinseishoChohyoShurui.介護保険料納付額証明書交付申請書.get名称())) {
            KaigoKakushuShinseishoHakkoEntity kaigoKakushuShinseishoHakkoEntity = new KaigoKakushuShinseishoHakkoEntity();
            kaigoKakushuShinseishoHakkoEntity.set申請書ID(ShinseishoChohyoShurui.介護保険料納付額証明書交付申請書.getコード());
            kaigoKakushuShinseishoHakkoEntity.set業務(賦課);
            kaigoKakushuShinseishoHakkoEntity.set申請書(ShinseishoChohyoShurui.介護保険料納付額証明書交付申請書.get名称());
            kaigoKakushuShinseishoHakkoEntityList.add(kaigoKakushuShinseishoHakkoEntity);
        }
        return kaigoKakushuShinseishoHakkoEntityList;
    }

    private List<KaigoKakushuShinseishoHakkoEntity> get業務受給情報の取得() {
        if (DBD800001_種類.equals(ShinseishoChohyoShurui.介護保険負担限度額認定申請書.get名称())) {
            KaigoKakushuShinseishoHakkoEntity kaigoKakushuShinseishoHakkoEntity = new KaigoKakushuShinseishoHakkoEntity();
            kaigoKakushuShinseishoHakkoEntity.set申請書ID(ShinseishoChohyoShurui.介護保険負担限度額認定申請書.getコード());
            kaigoKakushuShinseishoHakkoEntity.set業務(受給);
            kaigoKakushuShinseishoHakkoEntity.set申請書(ShinseishoChohyoShurui.介護保険負担限度額認定申請書.get名称());
            kaigoKakushuShinseishoHakkoEntityList.add(kaigoKakushuShinseishoHakkoEntity);
        }
        if (DBD800002_種類.equals(ShinseishoChohyoShurui.介護保険利用者負担額減額_免除申請書.get名称())) {
            KaigoKakushuShinseishoHakkoEntity kaigoKakushuShinseishoHakkoEntity = new KaigoKakushuShinseishoHakkoEntity();
            kaigoKakushuShinseishoHakkoEntity.set申請書ID(ShinseishoChohyoShurui.介護保険利用者負担額減額_免除申請書.getコード());
            kaigoKakushuShinseishoHakkoEntity.set業務(受給);
            kaigoKakushuShinseishoHakkoEntity.set申請書(ShinseishoChohyoShurui.介護保険利用者負担額減額_免除申請書.get名称());
            kaigoKakushuShinseishoHakkoEntityList.add(kaigoKakushuShinseishoHakkoEntity);
        }
        if (DBD800004_種類.equals(ShinseishoChohyoShurui.介護保険特定負担限度額申請書.get名称())) {
            KaigoKakushuShinseishoHakkoEntity kaigoKakushuShinseishoHakkoEntity = new KaigoKakushuShinseishoHakkoEntity();
            kaigoKakushuShinseishoHakkoEntity.set申請書ID(ShinseishoChohyoShurui.介護保険特定負担限度額申請書.getコード());
            kaigoKakushuShinseishoHakkoEntity.set業務(受給);
            kaigoKakushuShinseishoHakkoEntity.set申請書(ShinseishoChohyoShurui.介護保険特定負担限度額申請書.get名称());
            kaigoKakushuShinseishoHakkoEntityList.add(kaigoKakushuShinseishoHakkoEntity);
        }
        if (DBD800005_種類.equals(ShinseishoChohyoShurui.訪問介護利用者負担額減額申請書.get名称())) {
            KaigoKakushuShinseishoHakkoEntity kaigoKakushuShinseishoHakkoEntity = new KaigoKakushuShinseishoHakkoEntity();
            kaigoKakushuShinseishoHakkoEntity.set申請書ID(ShinseishoChohyoShurui.訪問介護利用者負担額減額申請書.getコード());
            kaigoKakushuShinseishoHakkoEntity.set業務(受給);
            kaigoKakushuShinseishoHakkoEntity.set申請書(ShinseishoChohyoShurui.訪問介護利用者負担額減額申請書.get名称());
            kaigoKakushuShinseishoHakkoEntityList.add(kaigoKakushuShinseishoHakkoEntity);
        }
        if (DBD800006_種類.equals(ShinseishoChohyoShurui.社会福祉法人等利用者負担軽減対象確認申請書.get名称())) {
            KaigoKakushuShinseishoHakkoEntity kaigoKakushuShinseishoHakkoEntity = new KaigoKakushuShinseishoHakkoEntity();
            kaigoKakushuShinseishoHakkoEntity.set申請書ID(ShinseishoChohyoShurui.社会福祉法人等利用者負担軽減対象確認申請書.getコード());
            kaigoKakushuShinseishoHakkoEntity.set業務(受給);
            kaigoKakushuShinseishoHakkoEntity.set申請書(ShinseishoChohyoShurui.社会福祉法人等利用者負担軽減対象確認申請書.get名称());
            kaigoKakushuShinseishoHakkoEntityList.add(kaigoKakushuShinseishoHakkoEntity);
        }
        if (DBD800007_種類.equals(ShinseishoChohyoShurui.特別地域加算減免_訪問介護等利用者負担減額対象確認申請書.get名称())) {
            KaigoKakushuShinseishoHakkoEntity kaigoKakushuShinseishoHakkoEntity = new KaigoKakushuShinseishoHakkoEntity();
            kaigoKakushuShinseishoHakkoEntity.set申請書ID(
                    ShinseishoChohyoShurui.特別地域加算減免_訪問介護等利用者負担減額対象確認申請書.getコード());
            kaigoKakushuShinseishoHakkoEntity.set業務(受給);
            kaigoKakushuShinseishoHakkoEntity.set申請書(
                    ShinseishoChohyoShurui.特別地域加算減免_訪問介護等利用者負担減額対象確認申請書.get名称());
            kaigoKakushuShinseishoHakkoEntityList.add(kaigoKakushuShinseishoHakkoEntity);
        }
        if (DBD800008_種類.equals(ShinseishoChohyoShurui.給付額減額免除申請書.get名称())) {
            KaigoKakushuShinseishoHakkoEntity kaigoKakushuShinseishoHakkoEntity = new KaigoKakushuShinseishoHakkoEntity();
            kaigoKakushuShinseishoHakkoEntity.set申請書ID(ShinseishoChohyoShurui.給付額減額免除申請書.getコード());
            kaigoKakushuShinseishoHakkoEntity.set業務(受給);
            kaigoKakushuShinseishoHakkoEntity.set申請書(ShinseishoChohyoShurui.給付額減額免除申請書.get名称());
            kaigoKakushuShinseishoHakkoEntityList.add(kaigoKakushuShinseishoHakkoEntity);
        }
        if (DBD800009_種類.equals(ShinseishoChohyoShurui.支払方法変更_償還払い化_終了申請書.get名称())) {
            KaigoKakushuShinseishoHakkoEntity kaigoKakushuShinseishoHakkoEntity = new KaigoKakushuShinseishoHakkoEntity();
            kaigoKakushuShinseishoHakkoEntity.set申請書ID(ShinseishoChohyoShurui.支払方法変更_償還払い化_終了申請書.getコード());
            kaigoKakushuShinseishoHakkoEntity.set業務(受給);
            kaigoKakushuShinseishoHakkoEntity.set申請書(ShinseishoChohyoShurui.支払方法変更_償還払い化_終了申請書.get名称());
            kaigoKakushuShinseishoHakkoEntityList.add(kaigoKakushuShinseishoHakkoEntity);
        }
        return kaigoKakushuShinseishoHakkoEntityList;
    }

    private List<KaigoKakushuShinseishoHakkoEntity> get業務給付情報の取得() {
        if (DBC800001_種類.equals(ShinseishoChohyoShurui.介護保険受領委任払い取扱事業者登録申請書.get名称())) {
            KaigoKakushuShinseishoHakkoEntity kaigoKakushuShinseishoHakkoEntity = new KaigoKakushuShinseishoHakkoEntity();
            kaigoKakushuShinseishoHakkoEntity.set申請書ID(
                    ShinseishoChohyoShurui.介護保険受領委任払い取扱事業者登録申請書.getコード());
            kaigoKakushuShinseishoHakkoEntity.set業務(給付);
            kaigoKakushuShinseishoHakkoEntity.set申請書(
                    ShinseishoChohyoShurui.介護保険受領委任払い取扱事業者登録申請書.get名称());
            kaigoKakushuShinseishoHakkoEntityList.add(kaigoKakushuShinseishoHakkoEntity);
        }
        if (DBC800004_種類.equals(ShinseishoChohyoShurui.居宅_介護予防_サービス計画作成依頼_変更_届出書.get名称())) {
            KaigoKakushuShinseishoHakkoEntity kaigoKakushuShinseishoHakkoEntity = new KaigoKakushuShinseishoHakkoEntity();
            kaigoKakushuShinseishoHakkoEntity.set申請書ID(
                    ShinseishoChohyoShurui.居宅_介護予防_サービス計画作成依頼_変更_届出書.getコード());
            kaigoKakushuShinseishoHakkoEntity.set業務(給付);
            kaigoKakushuShinseishoHakkoEntity.set申請書(
                    ShinseishoChohyoShurui.居宅_介護予防_サービス計画作成依頼_変更_届出書.get名称());
            kaigoKakushuShinseishoHakkoEntityList.add(kaigoKakushuShinseishoHakkoEntity);
        }
        if (DBC800008_種類.equals(ShinseishoChohyoShurui.介護保険居宅介護サービス計画の作成_自己作成.get名称())) {
            KaigoKakushuShinseishoHakkoEntity kaigoKakushuShinseishoHakkoEntity = new KaigoKakushuShinseishoHakkoEntity();
            kaigoKakushuShinseishoHakkoEntity.set申請書ID(
                    ShinseishoChohyoShurui.介護保険居宅介護サービス計画の作成_自己作成.getコード());
            kaigoKakushuShinseishoHakkoEntity.set業務(給付);
            kaigoKakushuShinseishoHakkoEntity.set申請書(
                    ShinseishoChohyoShurui.介護保険居宅介護サービス計画の作成_自己作成.get名称());
            kaigoKakushuShinseishoHakkoEntityList.add(kaigoKakushuShinseishoHakkoEntity);
        }
        if (DBC800009_種類.equals(ShinseishoChohyoShurui.介護保険償還払支給申請書.get名称())) {
            KaigoKakushuShinseishoHakkoEntity kaigoKakushuShinseishoHakkoEntity = new KaigoKakushuShinseishoHakkoEntity();
            kaigoKakushuShinseishoHakkoEntity.set申請書ID(ShinseishoChohyoShurui.介護保険償還払支給申請書.getコード());
            kaigoKakushuShinseishoHakkoEntity.set業務(給付);
            kaigoKakushuShinseishoHakkoEntity.set申請書(ShinseishoChohyoShurui.介護保険償還払支給申請書.get名称());
            kaigoKakushuShinseishoHakkoEntityList.add(kaigoKakushuShinseishoHakkoEntity);
        }
        if (DBC800010_種類.equals(ShinseishoChohyoShurui.介護保険償還払受領委任払申請書.get名称())) {
            KaigoKakushuShinseishoHakkoEntity kaigoKakushuShinseishoHakkoEntity = new KaigoKakushuShinseishoHakkoEntity();
            kaigoKakushuShinseishoHakkoEntity.set申請書ID(ShinseishoChohyoShurui.介護保険償還払受領委任払申請書.getコード());
            kaigoKakushuShinseishoHakkoEntity.set業務(給付);
            kaigoKakushuShinseishoHakkoEntity.set申請書(ShinseishoChohyoShurui.介護保険償還払受領委任払申請書.get名称());
            kaigoKakushuShinseishoHakkoEntityList.add(kaigoKakushuShinseishoHakkoEntity);
        }
        if (DBC800011_種類.equals(ShinseishoChohyoShurui.介護保険居宅介護_予防_住宅改修費事前_受領委任払_申請書.get名称())) {
            KaigoKakushuShinseishoHakkoEntity kaigoKakushuShinseishoHakkoEntity = new KaigoKakushuShinseishoHakkoEntity();
            kaigoKakushuShinseishoHakkoEntity.set申請書ID(
                    ShinseishoChohyoShurui.介護保険居宅介護_予防_住宅改修費事前_受領委任払_申請書.getコード());
            kaigoKakushuShinseishoHakkoEntity.set業務(給付);
            kaigoKakushuShinseishoHakkoEntity.set申請書(
                    ShinseishoChohyoShurui.介護保険居宅介護_予防_住宅改修費事前_受領委任払_申請書.get名称());
            kaigoKakushuShinseishoHakkoEntityList.add(kaigoKakushuShinseishoHakkoEntity);
        }
        if (DBC800012_種類.equals(ShinseishoChohyoShurui.介護保険居宅介護_予防_住宅改修費支給_受領委任払_申請書.get名称())) {
            KaigoKakushuShinseishoHakkoEntity kaigoKakushuShinseishoHakkoEntity = new KaigoKakushuShinseishoHakkoEntity();
            kaigoKakushuShinseishoHakkoEntity.set申請書ID(
                    ShinseishoChohyoShurui.介護保険居宅介護_予防_住宅改修費支給_受領委任払_申請書.getコード());
            kaigoKakushuShinseishoHakkoEntity.set業務(給付);
            kaigoKakushuShinseishoHakkoEntity.set申請書(
                    ShinseishoChohyoShurui.介護保険居宅介護_予防_住宅改修費支給_受領委任払_申請書.get名称());
            kaigoKakushuShinseishoHakkoEntityList.add(kaigoKakushuShinseishoHakkoEntity);
        }
        if (DBC800013_種類.equals(ShinseishoChohyoShurui.介護保険居宅介護_予防_福祉用具購入費支給_受領委任払_申請書.get名称())) {
            KaigoKakushuShinseishoHakkoEntity kaigoKakushuShinseishoHakkoEntity = new KaigoKakushuShinseishoHakkoEntity();
            kaigoKakushuShinseishoHakkoEntity.set申請書ID(
                    ShinseishoChohyoShurui.介護保険居宅介護_予防_福祉用具購入費支給_受領委任払_申請書.getコード());
            kaigoKakushuShinseishoHakkoEntity.set業務(給付);
            kaigoKakushuShinseishoHakkoEntity.set申請書(
                    ShinseishoChohyoShurui.介護保険居宅介護_予防_福祉用具購入費支給_受領委任払_申請書.get名称());
            kaigoKakushuShinseishoHakkoEntityList.add(kaigoKakushuShinseishoHakkoEntity);
        }
        if (DBC800014_種類.equals(ShinseishoChohyoShurui.軽度者に対する福祉用具貸与の取り扱いの特例に関する確認申請書.get名称())) {
            KaigoKakushuShinseishoHakkoEntity kaigoKakushuShinseishoHakkoEntity = new KaigoKakushuShinseishoHakkoEntity();
            kaigoKakushuShinseishoHakkoEntity.set申請書ID(
                    ShinseishoChohyoShurui.軽度者に対する福祉用具貸与の取り扱いの特例に関する確認申請書.getコード());
            kaigoKakushuShinseishoHakkoEntity.set業務(給付);
            kaigoKakushuShinseishoHakkoEntity.set申請書(
                    ShinseishoChohyoShurui.軽度者に対する福祉用具貸与の取り扱いの特例に関する確認申請書.get名称());
            kaigoKakushuShinseishoHakkoEntityList.add(kaigoKakushuShinseishoHakkoEntity);
        }
        if (DBC800015_種類.equals(ShinseishoChohyoShurui.介護保険高額介護_予防_サービス費支給_受領委任払_申請書.get名称())) {
            KaigoKakushuShinseishoHakkoEntity kaigoKakushuShinseishoHakkoEntity = new KaigoKakushuShinseishoHakkoEntity();
            kaigoKakushuShinseishoHakkoEntity.set申請書ID(
                    ShinseishoChohyoShurui.介護保険高額介護_予防_サービス費支給_受領委任払_申請書.getコード());
            kaigoKakushuShinseishoHakkoEntity.set業務(給付);
            kaigoKakushuShinseishoHakkoEntity.set申請書(
                    ShinseishoChohyoShurui.介護保険高額介護_予防_サービス費支給_受領委任払_申請書.get名称());
            kaigoKakushuShinseishoHakkoEntityList.add(kaigoKakushuShinseishoHakkoEntity);
        }
        if (DBC800016_種類.equals(ShinseishoChohyoShurui.高額医療合算介護_介護予防_サービス費支給兼自己負担額証明書交付申請書.get名称())) {
            KaigoKakushuShinseishoHakkoEntity kaigoKakushuShinseishoHakkoEntity = new KaigoKakushuShinseishoHakkoEntity();
            kaigoKakushuShinseishoHakkoEntity.set申請書ID(
                    ShinseishoChohyoShurui.高額医療合算介護_介護予防_サービス費支給兼自己負担額証明書交付申請書.getコード());
            kaigoKakushuShinseishoHakkoEntity.set業務(給付);
            kaigoKakushuShinseishoHakkoEntity.set申請書(
                    ShinseishoChohyoShurui.高額医療合算介護_介護予防_サービス費支給兼自己負担額証明書交付申請書.get名称());
            kaigoKakushuShinseishoHakkoEntityList.add(kaigoKakushuShinseishoHakkoEntity);
        }
        if (DBC800017_種類.equals(ShinseishoChohyoShurui.介護保険助成金給付申請書.get名称())) {
            KaigoKakushuShinseishoHakkoEntity kaigoKakushuShinseishoHakkoEntity = new KaigoKakushuShinseishoHakkoEntity();
            kaigoKakushuShinseishoHakkoEntity.set申請書ID(ShinseishoChohyoShurui.介護保険助成金給付申請書.getコード());
            kaigoKakushuShinseishoHakkoEntity.set業務(給付);
            kaigoKakushuShinseishoHakkoEntity.set申請書(ShinseishoChohyoShurui.介護保険助成金給付申請書.get名称());
            kaigoKakushuShinseishoHakkoEntityList.add(kaigoKakushuShinseishoHakkoEntity);
        }
        if (DBC800018_種類.equals(ShinseishoChohyoShurui.介護保険給付費借入申請書.get名称())) {
            KaigoKakushuShinseishoHakkoEntity kaigoKakushuShinseishoHakkoEntity = new KaigoKakushuShinseishoHakkoEntity();
            kaigoKakushuShinseishoHakkoEntity.set申請書ID(ShinseishoChohyoShurui.介護保険給付費借入申請書.getコード());
            kaigoKakushuShinseishoHakkoEntity.set業務(給付);
            kaigoKakushuShinseishoHakkoEntity.set申請書(ShinseishoChohyoShurui.介護保険給付費借入申請書.get名称());
            kaigoKakushuShinseishoHakkoEntityList.add(kaigoKakushuShinseishoHakkoEntity);
        }
        if (DBC800019_種類.equals(ShinseishoChohyoShurui.介護保険給付費貸付金償還期限延長申請書.get名称())) {
            KaigoKakushuShinseishoHakkoEntity kaigoKakushuShinseishoHakkoEntity = new KaigoKakushuShinseishoHakkoEntity();
            kaigoKakushuShinseishoHakkoEntity.set申請書ID(ShinseishoChohyoShurui.介護保険給付費貸付金償還期限延長申請書.getコード());
            kaigoKakushuShinseishoHakkoEntity.set業務(給付);
            kaigoKakushuShinseishoHakkoEntity.set申請書(ShinseishoChohyoShurui.介護保険給付費貸付金償還期限延長申請書.get名称());
            kaigoKakushuShinseishoHakkoEntityList.add(kaigoKakushuShinseishoHakkoEntity);
        }
        if (DBC800020_種類.equals(ShinseishoChohyoShurui.第三者行為による被害届_介護保険用.get名称())) {
            KaigoKakushuShinseishoHakkoEntity kaigoKakushuShinseishoHakkoEntity = new KaigoKakushuShinseishoHakkoEntity();
            kaigoKakushuShinseishoHakkoEntity.set申請書ID(ShinseishoChohyoShurui.第三者行為による被害届_介護保険用.getコード());
            kaigoKakushuShinseishoHakkoEntity.set業務(給付);
            kaigoKakushuShinseishoHakkoEntity.set申請書(ShinseishoChohyoShurui.第三者行為による被害届_介護保険用.get名称());
            kaigoKakushuShinseishoHakkoEntityList.add(kaigoKakushuShinseishoHakkoEntity);
        }
        return kaigoKakushuShinseishoHakkoEntityList;
    }
}
