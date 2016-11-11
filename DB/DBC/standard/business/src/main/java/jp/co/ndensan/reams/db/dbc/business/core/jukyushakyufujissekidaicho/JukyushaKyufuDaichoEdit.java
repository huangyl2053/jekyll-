/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.jukyushakyufujissekidaicho;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.jukyushajyufujissekidaicho.JukyushaKyufuJissekidaichoReport;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushajyufujissekidaicho.JukyushaKyufuJissekidaichoData;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.KihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.KihonRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.KojinyoTyohyoDataKomoku;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.MeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.ShuukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.TokuteiServiceHiEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.jukyushajyufujissekidaicho.JukyushaKyufuJissekidaichoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 受給者給付実績台帳Editクラスです。
 *
 * @reamsid_L DBC-3080-030 dongyabin
 */
public class JukyushaKyufuDaichoEdit {

    private static final RString 入力識別番号_3411 = new RString("3411");
    private static final RString 入力識別番号_3421 = new RString("3421");
    private static final RString 入力識別番号_7131 = new RString("7131");
    private static final RString 入力識別番号_2131 = new RString("2131");
    private static final RString 頁数_1 = new RString("1");
    private static final int LIST_SIZE = 3;

    /**
     * 受給者給付台帳を出力します。
     *
     * @param entity entity
     * @param jukyushaKyufuDaicho jukyushaKyufuDaicho
     * @param reportSourceWriter reportSourceWriter
     */
    public void report受給者給付台帳(KihonRelateEntity entity,
            JukyushaKyufuJissekidaichoData jukyushaKyufuDaicho,
            ReportSourceWriter<JukyushaKyufuJissekidaichoReportSource> reportSourceWriter) {
        if (入力識別番号_3411.equals(entity.getDbT3017_inputShikibetsuNo())
                || 入力識別番号_3421.equals(entity.getDbT3017_inputShikibetsuNo())) {
            report3411_3421(jukyushaKyufuDaicho, reportSourceWriter);
        }
        if (入力識別番号_7131.equals(entity.getDbT3017_inputShikibetsuNo())
                || 入力識別番号_2131.equals(entity.getDbT3017_inputShikibetsuNo())) {
//            report7131_2131(jukyushaKyufuDaicho, reportSourceWriter);
        }
    }

    private void report3411_3421(JukyushaKyufuJissekidaichoData jukyushaKyufuDaicho,
            ReportSourceWriter<JukyushaKyufuJissekidaichoReportSource> reportSourceWriter) {
        KojinyoTyohyoDataKomoku 個人用帳票データ = new KojinyoTyohyoDataKomoku();
        // TODO ヘッダー1の設定不明です。QA提出待ち
        個人用帳票データ.setヘッダー1(RString.EMPTY);
        個人用帳票データ.setヘッダー2(new RString(" 受付年月日              負担者番号      負担額      支給額      審査年月"));
        個人用帳票データ.setヘッダー3(new RString(" 決定年月日"));
        // TODO ヘッダー1の設定不明です。QA提出待ち
        個人用帳票データ.set明細1(RString.EMPTY);
        個人用帳票データ.set明細3(RString.EMPTY);
        個人用帳票データ.set明細4(RString.EMPTY);
        個人用帳票データ.set明細6(RString.EMPTY);
        jukyushaKyufuDaicho.setヘッダー1(個人用帳票データ.getヘッダー1());
        jukyushaKyufuDaicho.setヘッダー2(個人用帳票データ.getヘッダー2());
        jukyushaKyufuDaicho.setヘッダー3(個人用帳票データ.getヘッダー3());
        jukyushaKyufuDaicho.set明細1(個人用帳票データ.get明細1());
        jukyushaKyufuDaicho.set明細3(個人用帳票データ.get明細3());
        jukyushaKyufuDaicho.set明細4(個人用帳票データ.get明細4());
        jukyushaKyufuDaicho.set明細6(個人用帳票データ.get明細6());
        JukyushaKyufuJissekidaichoReport report = new JukyushaKyufuJissekidaichoReport(jukyushaKyufuDaicho);
        report.writeBy(reportSourceWriter);
    }

    private KojinyoTyohyoDataKomoku report7131_2131(KihonEntity 基本,
            List<MeisaiEntity> 明細List,
            List<ShuukeiEntity> 集計List,
            ReportSourceWriter<JukyushaKyufuJissekidaichoReportSource> reportSourceWriter) {
        KojinyoTyohyoDataKomoku 個人用帳票データ = new KojinyoTyohyoDataKomoku();
        return 個人用帳票データ;
    }

    private KojinyoTyohyoDataKomoku set基本(KihonEntity 基本,
            KojinyoTyohyoDataKomoku 個人用帳票データ) {
        個人用帳票データ.set頁数(頁数_1);
        個人用帳票データ.set被保険者番号(基本.get被保険者番号());
        個人用帳票データ.set実績区分(基本.get給付実績区分コード());
        個人用帳票データ.set被保険者氏名カナ(基本.get被保険者氏名カナ());
        個人用帳票データ.set被保険者氏名(基本.get被保険者氏名());
        個人用帳票データ.set生年月日(基本.get生年月日());
        個人用帳票データ.set性別(基本.get性別コード());
        個人用帳票データ.set要介護度(基本.get要介護度());
        個人用帳票データ.set認定有効期間(基本.get認定有効期間());
        個人用帳票データ.set証記載保険者番号(基本.get証記載保険者番号());
        個人用帳票データ.set老健市町村番号(基本.get老人保険市町村番号());
        個人用帳票データ.set老健受給者番号(基本.get老人保険受給者番号());
        個人用帳票データ.set旧措置入所者特例コード(基本.get旧措置入所者特例コード());
        個人用帳票データ.set警告区分コード(基本.get警告区分コード());
        個人用帳票データ.set審査年月(基本.get審査年月());
        個人用帳票データ.setサービス提供年月(基本.getサービス提供年月());
        個人用帳票データ.set住民コード(基本.get住民コード());
        個人用帳票データ.set世帯コード(基本.get世帯コード());
        個人用帳票データ.set住所コード(基本.get住所コード());
        個人用帳票データ.set住所(基本.get住所());
        個人用帳票データ.set行政区コード(基本.get行政区コード());
        個人用帳票データ.set行政区(基本.get行政区());
        個人用帳票データ.set後期高齢者資格情報_保険者番号(基本.get保険者番号後期());
        個人用帳票データ.set後期高齢者資格情報_被保険者番号(基本.get被保険者番号後期());
        個人用帳票データ.set国保資格情報_保険者番号(基本.get保険者番号国保());
        個人用帳票データ.set国保資格情報_被保険者証番号(基本.get被保険者証番号国保());
        個人用帳票データ.set国保資格情報_個人番号(基本.get整理番号());
        個人用帳票データ.set整理番号(基本.get整理番号());
        個人用帳票データ.setサービス計画作成1(基本.get居住サービス計画作成区分名１());
        個人用帳票データ.setサービス計画作成2(基本.get居住サービス計画作成区分名２());
        個人用帳票データ.set居宅サービス計画事業者(基本.get居住サービス計画事業者番号());
        個人用帳票データ.set居宅サービス計画事業者名1(基本.get居住サービス計画事業者名１());
        個人用帳票データ.set居宅サービス計画事業者名2(基本.get居住サービス計画事業者名２());
        個人用帳票データ.set入所_院_期間(基本.get入所院期間());
        個人用帳票データ.set入所_院_実日数(基本.get入所院実日数());
        個人用帳票データ.set外泊日数(基本.get外泊日数());
        個人用帳票データ.set出力様式(基本.get出力様式());
        個人用帳票データ.set出力様式１(基本.get出力様式１());
        個人用帳票データ.set出力様式２(基本.get出力様式２());
        個人用帳票データ.setサービス事業者(基本.getサービス事業者番号());
        個人用帳票データ.setサービス事業者名(基本.getサービス事業者名());
        個人用帳票データ.set退所_院_の状態(基本.get退所院の状態());
        個人用帳票データ.setサービス期間(基本.getサービス期間());
        個人用帳票データ.set中止理由タイトル(基本.get中止理由タイトル());
        個人用帳票データ.set中止理由(基本.get中止理由コード());
        個人用帳票データ.set保険_給付率(基本.get保険給付率());
        個人用帳票データ.set決定前_ｻｰﾋﾞｽ単位数_保険(基本.get前サービス単位数());
        個人用帳票データ.set決定後_ｻｰﾋﾞｽ単位数_保険(基本.get後サービス単位数());
        個人用帳票データ.set決定前_請求額_保険(基本.get前保険請求額());
        個人用帳票データ.set決定後_請求額_保険(基本.get後保険請求額());
        個人用帳票データ.set決定前_負担額_保険(基本.get前利用者負担額());
        個人用帳票データ.set決定後_負担額_保険(基本.get後利用者負担額());
        個人用帳票データ.set決定前_施設療養費請求額_保険(基本.get前緊急時施設療養費請求額());
        個人用帳票データ.set決定後_施設療養費請求額_保険(基本.get後緊急時施設療養費請求額());
        個人用帳票データ.set基本ヘッダー１(基本.get基本ヘッダー１());
        個人用帳票データ.set基本ヘッダー２(基本.get基本ヘッダー２());
        個人用帳票データ.set決定前_特別療養費請求額_保険(基本.get前特定診療費請求額());
        個人用帳票データ.set決定後_特別療養費請求額_保険(基本.get後特定診療費請求額());
        個人用帳票データ.set基本ヘッダー3(基本.get基本ヘッダー3());
        個人用帳票データ.set基本ヘッダー４(基本.get基本ヘッダー４());
        個人用帳票データ.set決定前_特定入所者介護費等請求額_保険(基本.get前特定入所者介護サービス等等請求額());
        個人用帳票データ.set決定後_特定入所者介護費等請求額_保険(基本.get後特定入所者介護サービス等等請求額());
        個人用帳票データ.set公費負担者_公費１(基本.get公費１負担者番号());
        個人用帳票データ.set公費受給者_公費１(基本.get公費１受給者番号());
        個人用帳票データ.set給付率_公費１(基本.get公費１給付率());
        個人用帳票データ.set決定前_サービス単位数_公費１(基本.get前公費１サービス単位数());
        個人用帳票データ.set決定後_サービス単位数_公費１(基本.get後公費１サービス単位数());
        個人用帳票データ.set決定前_請求額_公費１(基本.get前公費１保険請求額());
        個人用帳票データ.set決定後_請求額_公費１(基本.get後公費１保険請求額());
        個人用帳票データ.set決定前_負担額_公費１(基本.get前公費１利用者負担額());
        個人用帳票データ.set決定後_負担額_公費１(基本.get後公費１利用者負担額());
        個人用帳票データ.set決定前_施設療養費請求額_公費１(基本.get前公費１緊急時施設療養費請求額());
        個人用帳票データ.set決定後_施設療養費請求額_公費１(基本.get後公費１緊急時施設療養費請求額());
        個人用帳票データ.set決定前_特別療養費請求額_公費１(基本.get前公費１特定診療費請求額());
        個人用帳票データ.set決定後_特別療養費請求額_公費１(基本.get後公費１特定診療費請求額());
        個人用帳票データ.set決定前_特定入所者介護費等請求額_公費１(基本.get前公費１特定入所者介護サービス費等請求額());
        個人用帳票データ.set決定後_特定入所者介護費等請求額_公費１(基本.get後公費１特定入所者介護サービス費等請求額());
        個人用帳票データ.set公費負担者_公費２(基本.get公費２負担者番号());
        個人用帳票データ.set公費受給者_公費２(基本.get公費２受給者番号());
        個人用帳票データ.set給付率_公費２(基本.get公費２給付率());
        個人用帳票データ.set決定前_サービス単位数_公費２(基本.get前公費２サービス単位数());
        個人用帳票データ.set決定後_サービス単位数_公費２(基本.get後公費２サービス単位数());
        個人用帳票データ.set決定前_請求額_公費２(基本.get前公費２保険請求額());
        個人用帳票データ.set決定後_請求額_公費２(基本.get後公費２保険請求額());
        個人用帳票データ.set決定前_負担額_公費２(基本.get前公費２利用者負担額());
        個人用帳票データ.set決定後_負担額_公費２(基本.get後公費２利用者負担額());
        個人用帳票データ.set決定前_施設療養費請求額_公費２(基本.get前公費２緊急時施設療養費請求額());
        個人用帳票データ.set決定後_施設療養費請求額_公費２(基本.get後公費２緊急時施設療養費請求額());
        個人用帳票データ.set決定前_特別療養費請求額_公費２(基本.get前公費２特定診療費請求額());
        個人用帳票データ.set決定後_特別療養費請求額_公費２(基本.get後公費２特定診療費請求額());
        個人用帳票データ.set決定前_特定入所者介護費等請求額_公費２(基本.get前公費２特定入所者介護サービス費等請求額());
        個人用帳票データ.set決定後_特定入所者介護費等請求額_公費２(基本.get後公費２特定入所者介護サービス費等請求額());
        個人用帳票データ.set公費負担者_公費３(基本.get公費３負担者番号());
        個人用帳票データ.set公費受給者_公費３(基本.get公費３受給者番号());
        個人用帳票データ.set給付率_公費３(基本.get公費３給付率());
        個人用帳票データ.set決定前_サービス単位数_公費３(基本.get前公費３サービス単位数());
        個人用帳票データ.set決定後_ｻｰﾋﾞｽ単位数_公費３(基本.get後公費３サービス単位数());
        個人用帳票データ.set決定前_請求額_公費３(基本.get前公費３保険請求額());
        個人用帳票データ.set決定後_請求額_公費３(基本.get後公費３保険請求額());
        個人用帳票データ.set決定前_負担額_公費３(基本.get前公費３利用者負担額());
        個人用帳票データ.set決定後_負担額_公費３(基本.get後公費３利用者負担額());
        個人用帳票データ.set決定前_施設療養費請求額_公費３(基本.get前公費３緊急時施設療養費請求額());
        個人用帳票データ.set決定後_施設療養費請求額_公費３(基本.get後公費３緊急時施設療養費請求額());
        個人用帳票データ.set決定前_特別療養費請求額_公費３(基本.get前公費３特定診療費請求額());
        個人用帳票データ.set決定後_特別療養費請求額_公費３(基本.get後公費３特定診療費請求額());
        個人用帳票データ.set決定前_特定入所者介護費等請求額_公費３(基本.get前公費３特定入所者介護サービス費等請求額());
        個人用帳票データ.set決定後_特定入所者介護費等請求額_公費３(基本.get後公費３特定入所者介護サービス費等請求額());
        return 個人用帳票データ;
    }

    private List<KojinyoTyohyoDataKomoku> set明細(KihonEntity 基本,
            List<MeisaiEntity> list明細,
            KojinyoTyohyoDataKomoku 個人用帳票データ) {
        List<KojinyoTyohyoDataKomoku> list明細データ = new ArrayList<>();
        for (int i = 0; i < list明細.size(); i++) {
            MeisaiEntity 明細 = list明細.get(i);
            if (基本.get入力識別番号().equals(明細.get入力識別番号())
                    && 基本.get被保険者番号().equals(明細.get被保険者番号())
                    && 基本.getサービス提供年月().equals(明細.getサービス提供年月())
                    && 基本.get事業所番号().equals(明細.get事業所番号())
                    && 基本.get通し番号().equals(明細.get通し番号())) {
                list明細データ = 明細セット(i, list明細データ, list明細, 明細, 個人用帳票データ);
                if ((i % LIST_SIZE) == 2) {
                    個人用帳票データ.setサービスコードﾞ3(明細.getサービス種類コード().concat(明細.getサービス項目コード()));
                    個人用帳票データ.setサービス内容3(明細.getサービス内容());
                    個人用帳票データ.set決定前_単位数3(明細.get単位数());
                    個人用帳票データ.set決定後_単位数3(明細.get後単位数());
                    個人用帳票データ.set単位数識別3(明細.get単位数識別());
                    個人用帳票データ.set決定前_日の回数3(明細.get日数回数());
                    個人用帳票データ.set決定後_日の回数3(明細.get後日数回数());
                    個人用帳票データ.set決定前_サービス単位数3(明細.getサービス単位数());
                    個人用帳票データ.set決定後_サービス単位数3(明細.get後サービス単位数());
                    個人用帳票データ.set決定前_日の回数3_公費１対象(明細.get公費１対象日数回数());
                    個人用帳票データ.set決定後_日の回数3_公費１対象(明細.get後公費１対象日数回数());
                    個人用帳票データ.set決定前_サービス単位数3_公費１対象(明細.get公費１対象サービス点数());
                    個人用帳票データ.set決定後_サービス単位数3_公費１対象(明細.get後公費１対象サービス点数());
                    個人用帳票データ.set決定前_１日の回数3_公費２対象(明細.get公費２対象日数回数());
                    個人用帳票データ.set決定後_１日の回数3_公費２対象(明細.get後公費２対象日数回数());
                    個人用帳票データ.set決定前_サービス単位数3_公費２対象(明細.get公費２対象サービス点数());
                    個人用帳票データ.set決定後_サービス単位数3_公費２対象(明細.get後公費２対象サービス点数());
                    個人用帳票データ.set決定前_日の回数3_公費３対象(明細.get公費３対象日数回数());
                    個人用帳票データ.set決定後_日の回数3_公費３対象(明細.get後公費３対象日数回数());
                    個人用帳票データ.set決定前_サービス単位数3_公費３対象(明細.get公費３対象サービス点数());
                    個人用帳票データ.set決定後_サービス単位数3_公費３対象(明細.get後公費３対象サービス点数());
                    個人用帳票データ.set摘要3(明細.get摘要());
                    個人用帳票データ.set再審査回数3(明細.get再審査回数());
                    個人用帳票データ.set過誤回数3(明細.get過誤回数());
                    個人用帳票データ.set審査年月3(明細.get審査年月());
                    list明細データ.add(個人用帳票データ);
                }
            }
        }
        return list明細データ;
    }

    private List<KojinyoTyohyoDataKomoku> 明細セット(int i,
            List<KojinyoTyohyoDataKomoku> list明細データ,
            List<MeisaiEntity> list明細,
            MeisaiEntity 明細,
            KojinyoTyohyoDataKomoku 個人用帳票データ) {
        if ((i % LIST_SIZE) == 0) {
            個人用帳票データ.setサービスコード1(明細.getサービス種類コード().concat(明細.getサービス項目コード()));
            個人用帳票データ.setサービス内容1(明細.getサービス内容());
            個人用帳票データ.set決定前_単位数1(明細.get単位数());
            個人用帳票データ.set決定後_単位数1(明細.get後単位数());
            個人用帳票データ.set単位数識別1(明細.get単位数識別());
            個人用帳票データ.set決定前_日の回数1(明細.get日数回数());
            個人用帳票データ.set決定後_日の回数1(明細.get後日数回数());
            個人用帳票データ.set決定前_サービス単位数1(明細.getサービス単位数());
            個人用帳票データ.set決定後_サービス単位数1(明細.get後サービス単位数());
            個人用帳票データ.set決定前_日の回数1_公費１対象(明細.get公費１対象日数回数());
            個人用帳票データ.set決定後_日の回数1_公費１対象(明細.get後公費１対象日数回数());
            個人用帳票データ.set決定前_サービス単位数1_公費１対象(明細.get公費１対象サービス点数());
            個人用帳票データ.set決定後_サービス単位数1_公費１対象(明細.get後公費１対象サービス点数());
            個人用帳票データ.set決定前_１日の回数1_公費２対象(明細.get公費２対象日数回数());
            個人用帳票データ.set決定後_１日の回数1_公費２対象(明細.get後公費２対象日数回数());
            個人用帳票データ.set決定前_サービス単位数1_公費２対象(明細.get公費２対象サービス点数());
            個人用帳票データ.set決定後_サービス単位数1_公費２対象(明細.get後公費２対象サービス点数());
            個人用帳票データ.set決定前_日の回数1_公費３対象(明細.get公費３対象日数回数());
            個人用帳票データ.set決定後_日の回数1_公費３対象(明細.get後公費３対象日数回数());
            個人用帳票データ.set決定前_サービス単位数1_公費３対象(明細.get公費３対象サービス点数());
            個人用帳票データ.set決定後_サービス単位数1_公費３対象(明細.get後公費３対象サービス点数());
            個人用帳票データ.set摘要1(明細.get摘要());
            個人用帳票データ.set再審査回数1(明細.get再審査回数());
            個人用帳票データ.set過誤回数1(明細.get過誤回数());
            個人用帳票データ.set審査年月1(明細.get審査年月());
            if (i == list明細.size() - 1) {
                list明細データ.add(個人用帳票データ);
            }
        }
        if ((i % LIST_SIZE) == 1) {
            個人用帳票データ.setサービスコードﾞ2(明細.getサービス種類コード().concat(明細.getサービス項目コード()));
            個人用帳票データ.setサービス内容2(明細.getサービス内容());
            個人用帳票データ.set決定前_単位数2(明細.get単位数());
            個人用帳票データ.set決定後_単位数2(明細.get後単位数());
            個人用帳票データ.set単位数識別2(明細.get単位数識別());
            個人用帳票データ.set決定前_日の回数2(明細.get日数回数());
            個人用帳票データ.set決定後_日の回数2(明細.get後日数回数());
            個人用帳票データ.set決定前_サービス単位数2(明細.getサービス単位数());
            個人用帳票データ.set決定後_サービス単位数2(明細.get後サービス単位数());
            個人用帳票データ.set決定前_日の回数2_公費１対象(明細.get公費１対象日数回数());
            個人用帳票データ.set決定後_日の回数2_公費１対象(明細.get後公費１対象日数回数());
            個人用帳票データ.set決定前_サービス単位数2_公費１対象(明細.get公費１対象サービス点数());
            個人用帳票データ.set決定後_サービス単位数2_公費１対象(明細.get後公費１対象サービス点数());
            個人用帳票データ.set決定前_１日の回数2_公費２対象(明細.get公費２対象日数回数());
            個人用帳票データ.set決定後_１日の回数2_公費２対象(明細.get後公費２対象日数回数());
            個人用帳票データ.set決定前_サービス単位数2_公費２対象(明細.get公費２対象サービス点数());
            個人用帳票データ.set決定後_サービス単位数2_公費２対象(明細.get後公費２対象サービス点数());
            個人用帳票データ.set決定前_日の回数2_公費３対象(明細.get公費３対象日数回数());
            個人用帳票データ.set決定後_日の回数2_公費３対象(明細.get後公費３対象日数回数());
            個人用帳票データ.set決定前_サービス単位数2_公費３対象(明細.get公費３対象サービス点数());
            個人用帳票データ.set決定後_サービス単位数2_公費３対象(明細.get後公費３対象サービス点数());
            個人用帳票データ.set摘要2(明細.get摘要());
            個人用帳票データ.set再審査回数2(明細.get再審査回数());
            個人用帳票データ.set過誤回数2(明細.get過誤回数());
            個人用帳票データ.set審査年月2(明細.get審査年月());
            if (i == list明細.size() - 1) {
                list明細データ.add(個人用帳票データ);
            }
        }
        return list明細データ;
    }

    private List<KojinyoTyohyoDataKomoku> set入所(
            KihonEntity 基本,
            List<TokuteiServiceHiEntity> list特定,
            KojinyoTyohyoDataKomoku 個人用帳票データ) {
        List<KojinyoTyohyoDataKomoku> list特定データ = new ArrayList<>();
        for (int i = 0; i < list特定.size(); i++) {
            TokuteiServiceHiEntity 特定 = list特定.get(i);
            list特定.get(i).get順次番号();
            int 順次番号 = Integer.parseInt(list特定.get(i).get順次番号().toString());
            List list順次番号 = new ArrayList();
            list順次番号.add(順次番号);
            RString max順次番号 = (RString) Collections.max(list順次番号);
            最大データ(max順次番号, 特定, 個人用帳票データ, list特定データ);
            if (基本.get入力識別番号().equals(特定.get入力識別番号())
                    && 基本.get被保険者番号().equals(特定.get被保険者番号())
                    && 基本.getサービス提供年月().equals(特定.getサービス提供年月().toDateString())
                    && 基本.get事業所番号().equals(特定.get事業所番号())
                    && 基本.get通し番号().equals(特定.get通し番号())) {
                list特定データ = 入所セット(i, 特定, list特定, list特定データ, 個人用帳票データ);
                if ((i % LIST_SIZE) == 2) {
                    個人用帳票データ.set番号3(特定.get順次番号());
                    個人用帳票データ.setサービスコードﾞ3(特定.getサービス種別コード().concat(特定.getサービス項目コード()));
                    個人用帳票データ.setサービス内容3(特定.getサービス内容());
                    個人用帳票データ.set決定前_費用単価3(特定.get費用単価());
                    個人用帳票データ.set決定後_費用単価3(特定.get後費用単価());
                    個人用帳票データ.set負担限度額3(特定.get負担限度額());
                    個人用帳票データ.set決定前_日数3(特定.get日数());
                    個人用帳票データ.set決定後_日数3(特定.get後日数());
                    個人用帳票データ.set決定前_公費１日数3(特定.get公費１日数());
                    個人用帳票データ.set決定後_公費１日数3(特定.get後公費１日数());
                    個人用帳票データ.set決定前_公費２日数3(特定.get公費２日数());
                    個人用帳票データ.set決定後_公費２日数3(特定.get後公費２日数());
                    個人用帳票データ.set決定前_公費３日数3(特定.get公費３日数());
                    個人用帳票データ.set決定後_公費３日数3(特定.get後公費３日数());
                    個人用帳票データ.set決定前_費用額3(特定.get費用額());
                    個人用帳票データ.set決定後_費用額3(特定.get後費用額());
                    個人用帳票データ.set決定前_保険分請求額3(特定.get保険分請求額());
                    個人用帳票データ.set決定後_保険分請求額3(特定.get後保険分請求額());
                    個人用帳票データ.set決定前_公費１負担額3(特定.get公費１負担額明細());
                    個人用帳票データ.set決定後_公費１負担額3(特定.get後公費１負担額明細());
                    個人用帳票データ.set決定前_公費２負担額3(特定.get公費２負担額明細());
                    個人用帳票データ.set決定後_公費２負担額3(特定.get後公費２負担額明細());
                    個人用帳票データ.set決定前_公費３負担額3(特定.get公費３負担額明細());
                    個人用帳票データ.set決定後_公費３負担額3(特定.get後公費３負担額明細());
                    個人用帳票データ.set決定前_利用者負担額3(特定.get利用者負担額());
                    個人用帳票データ.set決定後_利用者負担額3(特定.get後利用者負担額());
                    個人用帳票データ.set再審査回数3(特定.get再審査回数());
                    個人用帳票データ.set過誤回数3(特定.get過誤回数());
                    個人用帳票データ.set審査年月3(特定.get審査年月());
                    list特定データ.add(個人用帳票データ);
                }
            }
        }
        return list特定データ;

    }

    private List<KojinyoTyohyoDataKomoku> 入所セット(int i,
            TokuteiServiceHiEntity 特定,
            List<TokuteiServiceHiEntity> list特定,
            List<KojinyoTyohyoDataKomoku> list特定データ,
            KojinyoTyohyoDataKomoku 個人用帳票データ) {
        if ((i % LIST_SIZE == 0)) {
            個人用帳票データ.set番号1(特定.get順次番号());
            個人用帳票データ.setサービスコードﾞ1(特定.getサービス種別コード().concat(特定.getサービス項目コード()));
            個人用帳票データ.setサービス内容1(特定.getサービス内容());
            個人用帳票データ.set決定前_費用単価1(特定.get費用単価());
            個人用帳票データ.set決定後_費用単価1(特定.get後費用単価());
            個人用帳票データ.set負担限度額1(特定.get負担限度額());
            個人用帳票データ.set決定前_日数1(特定.get日数());
            個人用帳票データ.set決定後_日数1(特定.get後日数());
            個人用帳票データ.set決定前_公費１日数1(特定.get公費１日数());
            個人用帳票データ.set決定後_公費１日数1(特定.get後公費１日数());
            個人用帳票データ.set決定前_公費２日数1(特定.get公費２日数());
            個人用帳票データ.set決定後_公費２日数1(特定.get後公費２日数());
            個人用帳票データ.set決定前_公費３日数1(特定.get公費３日数());
            個人用帳票データ.set決定後_公費３日数1(特定.get後公費３日数());
            個人用帳票データ.set決定前_費用額1(特定.get費用額());
            個人用帳票データ.set決定後_費用額1(特定.get後費用額());
            個人用帳票データ.set決定前_保険分請求額1(特定.get保険分請求額());
            個人用帳票データ.set決定後_保険分請求額1(特定.get後保険分請求額());
            個人用帳票データ.set決定前_公費１負担額1(特定.get公費１負担額明細());
            個人用帳票データ.set決定後_公費１負担額1(特定.get後公費１負担額明細());
            個人用帳票データ.set決定前_公費２負担額1(特定.get公費２負担額明細());
            個人用帳票データ.set決定後_公費２負担額1(特定.get後公費２負担額明細());
            個人用帳票データ.set決定前_公費３負担額1(特定.get公費３負担額明細());
            個人用帳票データ.set決定後_公費３負担額1(特定.get後公費３負担額明細());
            個人用帳票データ.set決定前_利用者負担額1(特定.get利用者負担額());
            個人用帳票データ.set決定後_利用者負担額1(特定.get後利用者負担額());
            個人用帳票データ.set再審査回数1(特定.get再審査回数());
            個人用帳票データ.set過誤回数1(特定.get過誤回数());
            個人用帳票データ.set審査年月1(特定.get審査年月());
            if (i == list特定.size() - 1) {
                list特定データ.add(個人用帳票データ);
            }
        }
        if (i % LIST_SIZE == 1) {
            個人用帳票データ.set番号2(特定.get順次番号());
            個人用帳票データ.setサービスコードﾞ2(特定.getサービス種別コード().concat(特定.getサービス項目コード()));
            個人用帳票データ.setサービス内容2(特定.getサービス内容());
            個人用帳票データ.set決定前_費用単価2(特定.get費用単価());
            個人用帳票データ.set決定後_費用単価2(特定.get後費用単価());
            個人用帳票データ.set負担限度額2(特定.get負担限度額());
            個人用帳票データ.set決定前_日数2(特定.get日数());
            個人用帳票データ.set決定後_日数2(特定.get後日数());
            個人用帳票データ.set決定前_公費１日数2(特定.get公費１日数());
            個人用帳票データ.set決定後_公費１日数2(特定.get後公費１日数());
            個人用帳票データ.set決定前_公費２日数2(特定.get公費２日数());
            個人用帳票データ.set決定後_公費２日数2(特定.get後公費２日数());
            個人用帳票データ.set決定前_公費３日数2(特定.get公費３日数());
            個人用帳票データ.set決定後_公費３日数2(特定.get後公費３日数());
            個人用帳票データ.set決定前_費用額2(特定.get費用額());
            個人用帳票データ.set決定後_費用額2(特定.get後費用額());
            個人用帳票データ.set決定前_保険分請求額2(特定.get保険分請求額());
            個人用帳票データ.set決定後_保険分請求額2(特定.get後保険分請求額());
            個人用帳票データ.set決定前_公費１負担額2(特定.get公費１負担額明細());
            個人用帳票データ.set決定後_公費１負担額2(特定.get後公費１負担額明細());
            個人用帳票データ.set決定前_公費２負担額2(特定.get公費２負担額明細());
            個人用帳票データ.set決定後_公費２負担額2(特定.get後公費２負担額明細());
            個人用帳票データ.set決定前_公費３負担額2(特定.get公費３負担額明細());
            個人用帳票データ.set決定後_公費３負担額2(特定.get後公費３負担額明細());
            個人用帳票データ.set決定前_利用者負担額2(特定.get利用者負担額());
            個人用帳票データ.set決定後_利用者負担額2(特定.get後利用者負担額());
            個人用帳票データ.set再審査回数2(特定.get再審査回数());
            個人用帳票データ.set過誤回数2(特定.get過誤回数());
            個人用帳票データ.set審査年月2(特定.get審査年月());
            if (i == list特定.size() - 1) {
                list特定データ.add(個人用帳票データ);
            }
        }
        return list特定データ;
    }

    private List<KojinyoTyohyoDataKomoku> 最大データ(RString max順次番号,
            TokuteiServiceHiEntity 特定,
            KojinyoTyohyoDataKomoku 個人用帳票データ,
            List<KojinyoTyohyoDataKomoku> list特定データ) {
        if (max順次番号.equals(特定.get順次番号())) {
            個人用帳票データ.set決定前_費用額合計_合計情報(特定.get費用額合計());
            個人用帳票データ.set決定後_費用額合計_合計情報(特定.get後費用額合計());
            個人用帳票データ.set決定前_保険分請求額合計_合計情報(特定.get保険分請求額合計());
            個人用帳票データ.set決定後_保険分請求額合計_合計情報(特定.get後保険分請求額合計());
            個人用帳票データ.set決定前_利用者負担額合計_合計情報(特定.get利用者負担額合計());
            個人用帳票データ.set決定後_利用者負担額合計_合計情報(特定.get後利用者負担額合計());
            個人用帳票データ.set決定前_費用額合計_合計情報公費１(特定.get公費１負担額合計());
            個人用帳票データ.set決定後_費用額合計_合計情報公費１(特定.get後公費１負担額合計());
            個人用帳票データ.set決定前_保険分請求額合計_合計情報公費１(特定.get公費１保険分請求額合計());
            個人用帳票データ.set決定後_保険分請求額合計_合計情報公費１(特定.get後公費１保険分請求額合計());
            個人用帳票データ.set決定前_利用者負担額合計_合計情報公費１(特定.get公費１本人負担月額());
            個人用帳票データ.set決定後_利用者負担額合計_合計情報公費１(特定.get後公費１本人負担月額());
            個人用帳票データ.set決定前_費用額合計_合計情報公費２(特定.get公費２負担額合計());
            個人用帳票データ.set決定後_費用額合計_合計情報公費２(特定.get後公費２負担額合計());
            個人用帳票データ.set決定前_保険分請求額合計_合計情報公費２(特定.get公費２保険分請求額合計());
            個人用帳票データ.set決定後_保険分請求額合計_合計情報公費２(特定.get後公費２保険分請求額合計());
            個人用帳票データ.set決定前_利用者負担額合計_合計情報公費２(特定.get公費２本人負担月額());
            個人用帳票データ.set決定後_利用者負担額合計_合計情報公費２(特定.get後公費２本人負担月額());
            個人用帳票データ.set決定前_費用額合計_合計情報公費３(特定.get公費３負担額合計());
            個人用帳票データ.set決定後_費用額合計_合計情報公費３(特定.get後公費３負担額合計());
            個人用帳票データ.set決定前_保険分請求額合計_合計情報公費３(特定.get公費３保険分請求額合計());
            個人用帳票データ.set決定後_保険分請求額合計_合計情報公費３(特定.get後公費３保険分請求額合計());
            個人用帳票データ.set決定前_利用者負担額合計_合計情報公費３(特定.get公費３本人負担月額());
            個人用帳票データ.set決定後_利用者負担額合計_合計情報公費３(特定.get後公費３本人負担月額());
            list特定データ.add(個人用帳票データ);
        }
        return list特定データ;
    }

    private List<KojinyoTyohyoDataKomoku> set集計(
            ShuukeiEntity 集計,
            KojinyoTyohyoDataKomoku 個人用帳票データ,
            List<KojinyoTyohyoDataKomoku> list特定データ) {
        個人用帳票データ.set集計_ｻｰﾋﾞｽ種類(集計.getサービス種類コード());
        個人用帳票データ.set集計_サービス種類名称1(集計.getサービス種類名称1());
        個人用帳票データ.set集計_サービス種類名称2(集計.getサービス種類名称2());
        個人用帳票データ.set集計_サービス実日数(集計.getサービス実日数());
        個人用帳票データ.set集計_計画単位数(集計.get計画単位数());
        個人用帳票データ.set集計_限度額管理対象単位数(集計.get限度額管理対象単位数());
        個人用帳票データ.set集計_限度額管理対象外単位数(集計.get限度額管理対象外単位数());
        // TODO
        // 個人用帳票データ.set決定後サービス計画日数1(
        //個人用帳票データ.set決定後サービス計画日数2(
        //個人用帳票データ.set短期日数(
        //個人用帳票データ.set決定後サービス実施日数1(
        //個人用帳票データ.set決定後サービス実施日数2(
        //個人用帳票データ.set決定後サービス実施日数3(
        個人用帳票データ.set集計_決定前_単位数合計_保険(集計.get請求点数合計());
        個人用帳票データ.set集計_決定後_単位数合計_保険(集計.get後点数合計());
        個人用帳票データ.set集計_単位数単価_保険(集計.get後請求点数単価());
        個人用帳票データ.set集計_決定前_請求額_保険(集計.get請求額());
        個人用帳票データ.set集計_決定後_請求額_保険(集計.get後保険請求分請求額());
        個人用帳票データ.set集計_負担額_保険(集計.get利用者負担額());
        個人用帳票データ.set集計_決定前_出来高医療費単位数合計_保険(集計.get出来高点数合計());
        個人用帳票データ.set集計_決定後_出来高医療費単位数合計_保険(集計.get後出来高点数合計());
        個人用帳票データ.set集計_決定前_出来高医療費請求額_保険(集計.get出来高請求額());
        個人用帳票データ.set集計_決定後_出来高医療費請求額_保険(集計.get後出来高請求額());
        個人用帳票データ.set集計_出来高医療費負担額_保険(集計.get利用者負担額());
        個人用帳票データ.set集計_決定前_単位数合計_公費１(集計.get公費１点数合計());
        個人用帳票データ.set集計_決定後_単位数合計_公費１(集計.get後公費１点数合計());
        個人用帳票データ.set集計_決定前_請求額_公費１(集計.get公費１請求額());
        個人用帳票データ.set集計_決定後_請求額_公費１(集計.get後公費１請求額());
        //個人用帳票データ.set負担額_公費１(集計.get公費１公費分本人負担額());
        個人用帳票データ.set集計_決定前_出来高医療費単位数合計_公費１(集計.get公費１出来高点数合計());
        個人用帳票データ.set集計_決定後_出来高医療費単位数合計_公費１(集計.get後公費１出来高点数合計());
        個人用帳票データ.set集計_決定前_出来高医療費請求額_公費１(集計.get公費１出来高請求額());
        個人用帳票データ.set集計_決定後_出来高医療費請求額_公費１(集計.get後公費１出来高請求額());
        //個人用帳票データ.set出来高医療費負担額_公費１(集計.get公費１公費分本人負担額());
        個人用帳票データ.set集計_決定前_単位数合計_公費２(集計.get公費２点数合計());
        個人用帳票データ.set集計_決定後_単位数合計_公費２(集計.get後公費２点数合計());
        個人用帳票データ.set集計_決定前_請求額_公費２(集計.get公費２請求額());
        個人用帳票データ.set集計_決定後_請求額_公費２(集計.get後公費２請求額());
        // 個人用帳票データ.set負担額_公費２(集計.get公費２公費分本人負担額());
        個人用帳票データ.set集計_決定前_出来高医療費単位数合計_公費２(集計.get公費２出来高点数合計());
        個人用帳票データ.set集計_決定後_出来高医療費単位数合計_公費２(集計.get後公費２出来高点数合計());
        個人用帳票データ.set集計_決定前_出来高医療費請求額_公費２(集計.get公費２出来高請求額());
        個人用帳票データ.set集計_決定後_出来高医療費請求額_公費２(集計.get後公費２出来高請求額());
        //個人用帳票データ.set出来高医療費負担額_公費２(集計.get公費２公費分本人負担額());
        個人用帳票データ.set集計_決定前_単位数合計_公費３(集計.get公費３点数合計());
        個人用帳票データ.set集計_決定後_単位数合計_公費３(集計.get後公費３点数合計());
        個人用帳票データ.set集計_決定前_請求額_公費３(集計.get公費３請求額());
        個人用帳票データ.set集計_決定後_請求額_公費３(集計.get後公費３請求額());
        // 個人用帳票データ.set負担額_公費３(集計.get公費３公費分本人負担額());
        個人用帳票データ.set集計_決定前_出来高医療費単位数合計_公費３(集計.get公費３出来高点数合計());
        個人用帳票データ.set集計_決定後_出来高医療費単位数合計_公費３(集計.get後公費３出来高点数合計());
        個人用帳票データ.set集計_決定前_出来高医療費請求額_公費３(集計.get公費３出来高請求額());
        個人用帳票データ.set集計_決定後_出来高医療費請求額_公費３(集計.get後公費３出来高請求額());
        //個人用帳票データ.set出来高医療費負担額_公費３(集計.get後公費３());
        個人用帳票データ.set集計_再審査回数(集計.get再審査回数());
        個人用帳票データ.set集計_過誤回数(集計.get過誤回数());
        個人用帳票データ.set集計_審査年月(集計.get審査年月());
        list特定データ.add(個人用帳票データ);
        return list特定データ;
    }

    private RString dateFormat年月日(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return date.wareki().eraType(EraType.ALPHABET).firstYear(FirstYear.GAN_NEN).
                separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString();
    }

    private RString dateFormat年月(FlexibleYearMonth date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return date.wareki().eraType(EraType.ALPHABET).firstYear(FirstYear.GAN_NEN).
                separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString();
    }

    private RString kingakuFormat(int date) {
        return DecimalFormatter.toコンマ区切りRString(new Decimal(date), 0);
    }
}
