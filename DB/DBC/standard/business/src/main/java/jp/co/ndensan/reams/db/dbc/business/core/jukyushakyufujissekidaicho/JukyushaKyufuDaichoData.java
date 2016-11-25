/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.jukyushakyufujissekidaicho;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushajyufujissekidaicho.JukyushaKyufuJissekidaichoData;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.KeikakuHiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.KojinyoTyohyoDataKomoku;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 受給者給付実績台帳のList個人用帳票データ項目定義からList受給者給付台帳帳データ項目定義変更クラスです。
 *
 * @reamsid_L DBC-3080-030 dongyabin
 */
public final class JukyushaKyufuDaichoData {

    private static final int INDEX_5 = 5;
    private static final int INDEX_4 = 4;
    private static final int INDEX_3 = 3;
    private static final RString SPACE_23 = new RString("　　　　　　　　　　　　　　　　　　　　　　　");
    private static final RString SPACE_4 = new RString("　　　　");
    private static final RString SPACE_7 = new RString("　　　　　　　");
    private static final RString SPACE_8 = new RString("　　　　　　　　");
    private static final RString SPACE_12 = new RString("　　　　　　　　　　　　");
    private static final RString SPACE_10 = new RString("　　　　　　　　　　");
    private static final RString SPACE_5 = new RString("　　　　　");
    private static final RString SPACE_6 = new RString("　　　　　　");
    private static final RString SPACE_回 = new RString("回　　　");

    private JukyushaKyufuDaichoData() {
    }

    /**
     * List個人用帳票データ項目定義からList受給者給付台帳帳データ項目定義変更します。
     *
     * @param 帳票データ 帳票データ
     * @param 個人用 個人用データ
     * @param pageCnt pageCnt
     * @param 件数 件数
     * @param 保険者コード 保険者コード
     * @param 保険者名 保険者名
     * @return ist受給者給付台帳帳データ項目
     */
    public static JukyushaKyufuJissekidaichoData set帳票データ(JukyushaKyufuJissekidaichoData 帳票データ,
            KojinyoTyohyoDataKomoku 個人用,
            int pageCnt,
            int 件数,
            RString 保険者コード,
            RString 保険者名) {
        帳票データ.set発行日時(RDate.getNowDate().toDateString());
        帳票データ.setページ数(new RString(pageCnt));
        帳票データ.set保険者コード(保険者コード);
        帳票データ.set保険者名(保険者名);
        帳票データ.set被保険者毎ページ数(new RString(件数));
        帳票データ.set被保険者毎総ページ数(new RString(件数));
        帳票データ.set被保険者番号(個人用.get被保険者番号());
        帳票データ.set実績区分(個人用.get実績区分());
        帳票データ.set被保険者氏名カナ(個人用.get被保険者氏名カナ());
        帳票データ.set被保険者氏名(個人用.get被保険者氏名());
        帳票データ.set生年月日(dateFromat_生年月日(個人用.get生年月日()));
        帳票データ.set性別(個人用.get性別());
        帳票データ.set要介護度(個人用.get要介護度());
        帳票データ.set認定有効期間(個人用.get認定有効期間());
        帳票データ.set証記載保険者番号(個人用.get証記載保険者番号());
        帳票データ.set老健市町村番号(個人用.get老健市町村番号());
        帳票データ.set老健受給者番号(個人用.get老健受給者番号());
        帳票データ.set旧措置特例(個人用.get旧措置入所者特例コード());
        帳票データ.set警告区分(個人用.get警告区分コード());
        帳票データ.set審査年月(dateFromat_生年月日(個人用.get審査年月()));
        帳票データ.setサービス提供年月(dateFromat_生年月日(個人用.getサービス提供年月()));
        帳票データ.set住民コード(個人用.get住民コード());
        帳票データ.set世帯コード(個人用.get世帯コード());
        帳票データ.set住所コード(個人用.get住所コード());
        帳票データ.set住所(個人用.get住所());
        帳票データ.set行政区コード(個人用.get行政区コード());
        帳票データ.set行政区(個人用.get行政区());
        帳票データ.set後期高齢者資格情報_保険者番号(個人用.get後期高齢者資格情報_保険者番号());
        帳票データ.set後期高齢者資格情報_被保険者番号(個人用.get後期高齢者資格情報_被保険者番号());
        帳票データ.set国保資格情報_保険者番号(個人用.get国保資格情報_保険者番号());
        帳票データ.set国保資格情報_被保険者証番号(個人用.get国保資格情報_被保険者証番号());
        帳票データ.set国保資格情報_個人番号(個人用.get国保資格情報_個人番号());
        帳票データ.set整理番号(個人用.get整理番号());
        帳票データ.setサービス計画作成1(個人用.getサービス計画作成1());
        帳票データ.setサービス計画作成2(個人用.getサービス計画作成2());
        帳票データ.set居宅サービス計画事業者(個人用.get居宅サービス計画事業者());
        帳票データ.set居宅サービス計画事業者名1(個人用.get居宅サービス計画事業者名1());
        帳票データ.set居宅サービス計画事業者名2(個人用.get居宅サービス計画事業者名2());
        帳票データ.set入所_院_期間(個人用.get入所_院_期間());
        帳票データ.set入所_院_実日数(個人用.get入所_院_実日数());
        帳票データ.set外泊日数(個人用.get外泊日数());
        帳票データ.set出力様式(個人用.get出力様式());
        帳票データ.set出力様式1(個人用.get出力様式１());
        帳票データ.set出力様式2(個人用.get出力様式２());
        帳票データ.setサービス事業者(個人用.getサービス事業者());
        帳票データ.setサービス事業者名(個人用.getサービス事業者名());
        帳票データ.set退所_院_の状態(個人用.get退所_院_の状態());
        帳票データ.setサービス期間(個人用.getサービス期間());
        帳票データ.set中止理由タイトル(個人用.get中止理由タイトル());
        帳票データ.set中止理由(個人用.get中止理由());
        帳票データ.set保険_給付率(個人用.get保険_給付率());
        帳票データ.set決定前_ｻｰﾋﾞｽ単位数_保険(個人用.get決定前_ｻｰﾋﾞｽ単位数_保険());
        帳票データ.set決定後_ｻｰﾋﾞｽ単位数_保険(個人用.get決定後_ｻｰﾋﾞｽ単位数_保険());
        帳票データ.set決定前_請求額_保険(個人用.get決定前_請求額_保険());
        帳票データ.set決定後_請求額_保険(個人用.get決定後_請求額_保険());
        帳票データ.set決定前_負担額_保険(個人用.get決定前_負担額_保険());
        帳票データ.set決定後_負担額_保険(個人用.get決定後_負担額_保険());
        帳票データ.set決定前_施設療養費請求額_保険(個人用.get決定前_施設療養費請求額_保険());
        帳票データ.set決定後_施設療養費請求額_保険(個人用.get決定後_施設療養費請求額_保険());
        帳票データ.set決定前_特別療養費請求額_保険(個人用.get決定前_特別療養費請求額_保険());
        帳票データ.set決定後_特別療養費請求額_保険(個人用.get決定後_特別療養費請求額_保険());
        帳票データ.set決定前_特定入所者介護費等請求額_保険(個人用.get決定前_特定入所者介護費等請求額_保険());
        帳票データ.set決定後_特定入所者介護費等請求額_保険(個人用.get決定後_特定入所者介護費等請求額_保険());
        帳票データ.set公費負担者_公費1(個人用.get公費負担者_公費１());
        帳票データ.set公費受給者_公費1(個人用.get公費受給者_公費１());
        帳票データ.set給付率_公費1(個人用.get給付率_公費１());
        帳票データ.set決定前_サービス単位数_公費1(個人用.get決定前_サービス単位数_公費１());
        帳票データ.set決定後_サービス単位数_公費1(個人用.get決定後_サービス単位数_公費１());
        帳票データ.set決定前_請求額_公費1(個人用.get決定前_請求額_公費１());
        帳票データ.set決定後_請求額_公費1(個人用.get決定後_請求額_公費１());
        帳票データ.set決定前_負担額_公費1(個人用.get決定前_負担額_公費１());
        帳票データ.set決定後_負担額_公費1(個人用.get決定後_負担額_公費１());
        帳票データ.set決定前_施設療養費請求額_公費1(個人用.get決定前_施設療養費請求額_公費１());
        帳票データ.set決定後_施設療養費請求額_公費1(個人用.get決定後_施設療養費請求額_公費１());
        帳票データ.set決定前_特別療養費請求額_公費1(個人用.get決定前_特別療養費請求額_公費１());
        帳票データ.set決定後_特別療養費請求額_公費1(個人用.get決定後_特別療養費請求額_公費１());
        帳票データ.set決定前_特定入所者介護費等請求額_公費1(個人用.get決定前_特定入所者介護費等請求額_公費１());
        帳票データ.set決定後_特定入所者介護費等請求額_公費1(個人用.get決定後_特定入所者介護費等請求額_公費１());
        帳票データ.set公費負担者_公費2(個人用.get公費負担者_公費２());
        帳票データ.set公費受給者_公費2(個人用.get公費受給者_公費２());
        帳票データ.set給付率_公費2(個人用.get給付率_公費２());
        帳票データ.set決定前_サービス単位数_公費2(個人用.get決定前_サービス単位数_公費２());
        帳票データ.set決定後_サービス単位数_公費2(個人用.get決定後_サービス単位数_公費２());
        帳票データ.set決定前_請求額_公費2(個人用.get決定前_請求額_公費２());
        帳票データ.set決定後_請求額_公費2(個人用.get決定後_請求額_公費２());
        帳票データ.set決定前_負担額_公費2(個人用.get決定前_負担額_公費２());
        帳票データ.set決定後_負担額_公費2(個人用.get決定後_負担額_公費２());
        帳票データ.set決定前_施設療養費請求額_公費2(個人用.get決定前_施設療養費請求額_公費２());
        帳票データ.set決定後_施設療養費請求額_公費2(個人用.get決定後_施設療養費請求額_公費２());
        帳票データ.set決定前_特別療養費請求額_公費2(個人用.get決定前_特別療養費請求額_公費２());
        帳票データ.set決定後_特別療養費請求額_公費2(個人用.get決定後_特別療養費請求額_公費２());
        帳票データ.set決定前_特定入所者介護費等請求額_公費2(個人用.get決定前_特定入所者介護費等請求額_公費２());
        帳票データ.set決定後_特定入所者介護費等請求額_公費2(個人用.get決定後_特定入所者介護費等請求額_公費２());
        帳票データ.set公費負担者_公費3(個人用.get公費負担者_公費３());
        帳票データ.set公費受給者_公費3(個人用.get公費受給者_公費３());
        帳票データ.set給付率_公費3(個人用.get給付率_公費３());
        帳票データ.set決定前_サービス単位数_公費3(個人用.get決定前_サービス単位数_公費３());
        帳票データ.set決定後_ｻｰﾋﾞｽ単位数_公費3(個人用.get決定後_ｻｰﾋﾞｽ単位数_公費３());
        帳票データ.set決定前_請求額_公費3(個人用.get決定前_請求額_公費３());
        帳票データ.set決定後_請求額_公費3(個人用.get決定後_請求額_公費３());
        帳票データ.set決定前_負担額_公費3(個人用.get決定前_負担額_公費３());
        帳票データ.set決定後_負担額_公費3(個人用.get決定後_負担額_公費３());
        帳票データ.set決定前_施設療養費請求額_公費3(個人用.get決定前_施設療養費請求額_公費３());
        帳票データ.set決定後_施設療養費請求額_公費3(個人用.get決定後_施設療養費請求額_公費３());
        帳票データ.set決定前_特別療養費請求額_公費3(個人用.get決定前_特別療養費請求額_公費３());
        帳票データ.set決定後_特別療養費請求額_公費3(個人用.get決定後_特別療養費請求額_公費３());
        帳票データ.set決定前_特定入所者介護費等請求額_公費3(個人用.get決定前_特定入所者介護費等請求額_公費３());
        帳票データ.set決定後_特定入所者介護費等請求額_公費3(個人用.get決定後_特定入所者介護費等請求額_公費３());
        帳票データ.setサービスコード1(個人用.getサービスコード1());
        帳票データ.setサービス内容1(個人用.getサービス内容1());
        帳票データ.set決定前_単位数1(decToRString(個人用.get決定前_単位数1()));
        帳票データ.set決定後_単位数1(decToRString(個人用.get決定後_単位数1()));
        帳票データ.set単位数識別1(個人用.get単位数識別1());
        帳票データ.set決定前_日の回数1(new RString(個人用.get決定前_日の回数1()));
        帳票データ.set決定後_日の回数1(new RString(個人用.get決定後_日の回数1()));
        帳票データ.set決定前_サービス単位数1(decToRString(個人用.get決定前_サービス単位数1()));
        帳票データ.set決定後_サービス単位数1(decToRString(個人用.get決定後_サービス単位数1()));
        帳票データ.set決定前_日の回数1_公費1対象(new RString(個人用.get決定前_日の回数1_公費１対象()));
        帳票データ.set決定後_日の回数1_公費1対象(new RString(個人用.get決定後_日の回数1_公費１対象()));
        帳票データ.set決定前_サービス単位数1_公費1対象(decToRString(個人用.get決定前_サービス単位数1_公費１対象()));
        帳票データ = set帳票データ2(帳票データ, 個人用);
        帳票データ = set帳票データ3(帳票データ, 個人用);
        帳票データ.set決定後_サービス単位数1_公費1対象(decToRString(個人用.get決定後_サービス単位数1_公費１対象()));
        帳票データ.set決定前_1日の回数1_公費2対象(new RString(個人用.get決定前_１日の回数1_公費２対象()));
        帳票データ.set市町村コード(個人用.get市町村コード());
        帳票データ.set入力識別番号(個人用.get入力識別番号());
        帳票データ.set事業所番号(個人用.get事業所番号());
        return 帳票データ;
    }

    private static JukyushaKyufuJissekidaichoData set帳票データ2(JukyushaKyufuJissekidaichoData 帳票データ,
            KojinyoTyohyoDataKomoku 個人用) {
        帳票データ.set決定後_1日の回数1_公費2対象(new RString(個人用.get決定後_１日の回数1_公費２対象()));
        帳票データ.set決定前_サービス単位数1_公費2対象(decToRString(個人用.get決定前_サービス単位数1_公費２対象()));
        帳票データ.set決定後_サービス単位数1_公費2対象(decToRString(個人用.get決定後_サービス単位数1_公費２対象()));
        帳票データ.set決定前_日の回数1_公費3対象(new RString(個人用.get決定前_日の回数1_公費３対象()));
        帳票データ.set決定後_日の回数1_公費3対象(new RString(個人用.get決定後_日の回数1_公費３対象()));
        帳票データ.set決定前_サービス単位数1_公費3対象(decToRString(個人用.get決定前_サービス単位数1_公費３対象()));
        帳票データ.set決定後_サービス単位数1_公費3対象(decToRString(個人用.get決定後_サービス単位数1_公費３対象()));
        帳票データ.set摘要1(個人用.get摘要1());
        帳票データ.set再審査回数1_d(new RString(個人用.get再審査回数1()));
        帳票データ.set過誤回数1_d(new RString(個人用.get過誤回数1()));
        帳票データ.set審査年月1_d(dateFormat年月(個人用.get審査年月1()));
        帳票データ.setサービスコードﾞ2_d(個人用.getサービスコード2());
        帳票データ.setサービス内容2_d(個人用.getサービス内容2());
        帳票データ.set決定前_単位数2(decToRString(個人用.get決定前_単位数2()));
        帳票データ.set決定後_単位数2(decToRString(個人用.get決定後_単位数2()));
        帳票データ.set単位数識別2(個人用.get単位数識別2());
        帳票データ.set決定前_日の回数2(new RString(個人用.get決定前_日の回数2()));
        帳票データ.set決定後_日の回数2(new RString(個人用.get決定後_日の回数2()));
        帳票データ.set決定前_サービス単位数2(decToRString(個人用.get決定前_サービス単位数2()));
        帳票データ.set決定後_サービス単位数2(decToRString(個人用.get決定後_サービス単位数2()));
        帳票データ.set決定前_日の回数2_公費1対象(new RString(個人用.get決定前_日の回数2_公費１対象()));
        帳票データ.set決定後_日の回数2_公費1対象(new RString(個人用.get決定後_日の回数2_公費１対象()));
        帳票データ.set決定前_サービス単位数2_公費1対象(decToRString(個人用.get決定前_サービス単位数2_公費１対象()));
        帳票データ.set決定後_サービス単位数2_公費1対象(decToRString(個人用.get決定後_サービス単位数2_公費１対象()));
        帳票データ.set決定前_日の回数2_公費2対象(new RString(個人用.get決定前_１日の回数2_公費２対象()));
        帳票データ.set決定後_日の回数2_公費2対象(new RString(個人用.get決定後_１日の回数2_公費２対象()));
        帳票データ.set決定前_サービス単位数2_公費2対象(decToRString(個人用.get決定前_サービス単位数2_公費２対象()));
        帳票データ.set決定後_サービス単位数2_公費2対象(decToRString(個人用.get決定後_サービス単位数2_公費２対象()));
        帳票データ.set決定前_日の回数2_公費3対象(new RString(個人用.get決定前_日の回数2_公費３対象()));
        帳票データ.set決定後_日の回数2_公費3対象(new RString(個人用.get決定後_日の回数2_公費３対象()));
        帳票データ.set決定前_サービス単位数2_公費3対象(decToRString(個人用.get決定前_サービス単位数2_公費３対象()));
        帳票データ.set決定後_サービス単位数2_公費3対象(decToRString(個人用.get決定後_サービス単位数2_公費３対象()));
        帳票データ.set摘要2(個人用.get摘要2());
        帳票データ.set再審査回数2_d(new RString(個人用.get再審査回数2()));
        帳票データ.set過誤回数2_d(new RString(個人用.get過誤回数2()));
        帳票データ.set審査年月2_d(dateFormat年月(個人用.get審査年月2()));
        帳票データ.setサービスコードﾞ3_d(個人用.getサービスコード3());
        帳票データ.setサービス内容3_d(個人用.getサービス内容3());
        帳票データ.set決定前_単位数3(decToRString(個人用.get決定前_単位数3()));
        帳票データ.set決定後_単位数3(decToRString(個人用.get決定後_単位数3()));
        帳票データ.set単位数識別3(個人用.get単位数識別3());
        帳票データ.set決定前_日の回数3(new RString(個人用.get決定前_日の回数3()));
        帳票データ.set決定後_日の回数3(new RString(個人用.get決定後_日の回数3()));
        帳票データ.set決定前_サービス単位数3(decToRString(個人用.get決定前_サービス単位数3()));
        帳票データ.set決定後_サービス単位数3(decToRString(個人用.get決定後_サービス単位数3()));
        帳票データ.set決定前_日の回数3_公費1対象(new RString(個人用.get決定前_日の回数3_公費１対象()));
        帳票データ.set決定後_日の回数3_公費1対象(new RString(個人用.get決定後_日の回数3_公費１対象()));
        帳票データ.set決定前_サービス単位数3_公費1対象(decToRString(個人用.get決定前_サービス単位数3_公費１対象()));
        帳票データ.set決定後_サービス単位数3_公費1対象(decToRString(個人用.get決定後_サービス単位数3_公費１対象()));
        帳票データ.set決定前_日の回数3_公費2対象(new RString(個人用.get決定前_１日の回数3_公費２対象()));
        帳票データ.set決定後_日の回数3_公費2対象(new RString(個人用.get決定後_１日の回数3_公費２対象()));
        帳票データ.set決定前_サービス単位数3_公費2対象(decToRString(個人用.get決定前_サービス単位数3_公費２対象()));
        帳票データ.set決定後_サービス単位数3_公費2対象(decToRString(個人用.get決定後_サービス単位数3_公費２対象()));
        帳票データ.set決定前_日の回数3_公費3対象(new RString(個人用.get決定前_日の回数3_公費３対象()));
        帳票データ.set決定後_日の回数3_公費3対象(new RString(個人用.get決定後_日の回数3_公費３対象()));
        帳票データ.set決定前_サービス単位数3_公費3対象(decToRString(個人用.get決定前_サービス単位数3_公費３対象()));
        帳票データ.set決定後_サービス単位数3_公費3対象(decToRString(個人用.get決定後_サービス単位数3_公費３対象()));
        帳票データ.set摘要3(個人用.get摘要3());
        帳票データ.set再審査回数3_d(new RString(個人用.get再審査回数3()));
        帳票データ.set過誤回数3_d(new RString(個人用.get過誤回数3()));
        帳票データ.set審査年月3_d(dateFormat年月(個人用.get審査年月3()));
        帳票データ.set番号1(個人用.get番号1());
        帳票データ.setサービスコードﾞ1(個人用.getサービスコードﾞ1());
        帳票データ.setサービス内容1(個人用.getサービス内容1());
        帳票データ.set決定前_費用単価1(decToRString(個人用.get決定前_費用単価1()));
        帳票データ.set決定後_費用単価1(decToRString(個人用.get決定後_費用単価1()));
        帳票データ.set負担限度額1(decToRString(個人用.get負担限度額1()));
        帳票データ.set決定前_日数1(new RString(個人用.get決定前_日数1()));
        帳票データ.set決定後_日数1(new RString(個人用.get決定後_日数1()));
        帳票データ.set決定前_公費1日数1(new RString(個人用.get決定前_公費１日数1()));
        帳票データ.set決定後_公費1日数1(new RString(個人用.get決定後_公費１日数1()));
        帳票データ.set決定前_公費2日数1(new RString(個人用.get決定前_公費２日数1()));
        帳票データ.set決定後_公費2日数1(new RString(個人用.get決定後_公費２日数1()));
        帳票データ.set決定前_公費3日数1(new RString(個人用.get決定前_公費３日数1()));
        帳票データ.set決定後_公費3日数1(new RString(個人用.get決定後_公費３日数1()));
        帳票データ.set決定前_費用額1(decToRString(個人用.get決定前_費用額1()));
        帳票データ.set決定後_費用額1(decToRString(個人用.get決定後_費用額1()));
        帳票データ.set決定前_保険分請求額1(decToRString(個人用.get決定前_保険分請求額1()));
        帳票データ.set決定後_保険分請求額1(decToRString(個人用.get決定後_保険分請求額1()));
        帳票データ.set決定前_公費1負担額1(decToRString(個人用.get決定前_公費１負担額1()));
        帳票データ.set決定後_公費1負担額1(decToRString(個人用.get決定後_公費１負担額1()));
        帳票データ.set決定前_公費2負担額1(decToRString(個人用.get決定前_公費２負担額1()));
        帳票データ.set決定後_公費2負担額1(decToRString(個人用.get決定後_公費２負担額1()));
        帳票データ.set決定前_公費3負担額1(decToRString(個人用.get決定前_公費３負担額1()));
        帳票データ.set決定後_公費3負担額1(decToRString(個人用.get決定後_公費３負担額1()));
        帳票データ.set決定前_利用者負担額1(decToRString(個人用.get決定前_利用者負担額1()));
        帳票データ.set決定後_利用者負担額1(decToRString(個人用.get決定後_利用者負担額1()));
        帳票データ.set再審査回数1_k(個人用.get特定_再審査回数1());
        帳票データ.set過誤回数1_k(個人用.get特定_過誤回数1());
        帳票データ.set審査年月1_k(個人用.get特定_審査年月1());
        帳票データ.set番号2(個人用.get番号2());
        帳票データ.setサービスコードﾞ2_k(個人用.getサービスコードﾞ2());
        帳票データ.setサービス内容2_k(個人用.get特定_サービス内容2());
        帳票データ.set決定前_費用単価2(decToRString(個人用.get決定前_費用単価2()));
        帳票データ.set決定後_費用単価2(decToRString(個人用.get決定後_費用単価2()));
        帳票データ.set負担限度額2(decToRString(個人用.get負担限度額2()));
        帳票データ.set決定前_日数2(new RString(個人用.get決定前_日数2()));
        帳票データ.set決定後_日数2(new RString(個人用.get決定後_日数2()));
        帳票データ.set決定前_公費1日数2(new RString(個人用.get決定前_公費１日数2()));
        帳票データ.set決定後_公費1日数2(new RString(個人用.get決定後_公費１日数2()));
        帳票データ.set決定前_公費2日数2(new RString(個人用.get決定前_公費２日数2()));
        帳票データ.set決定後_公費2日数2(new RString(個人用.get決定後_公費２日数2()));
        帳票データ.set決定前_公費3日数2(new RString(個人用.get決定前_公費３日数2()));
        帳票データ.set決定後_公費3日数2(new RString(個人用.get決定後_公費３日数2()));
        帳票データ.set決定前_費用額2(decToRString(個人用.get決定前_費用額2()));
        帳票データ.set決定後_費用額2(decToRString(個人用.get決定後_費用額2()));
        帳票データ.set決定前_保険分請求額2(decToRString(個人用.get決定前_保険分請求額2()));
        帳票データ.set決定後_保険分請求額2(decToRString(個人用.get決定後_保険分請求額2()));
        帳票データ.set決定前_公費1負担額2(decToRString(個人用.get決定前_公費１負担額2()));
        帳票データ.set決定後_公費1負担額2(decToRString(個人用.get決定後_公費１負担額2()));
        帳票データ.set決定前_公費2負担額2(decToRString(個人用.get決定前_公費２負担額2()));
        帳票データ.set決定後_公費2負担額2(decToRString(個人用.get決定後_公費２負担額2()));
        帳票データ.set決定前_公費3負担額2(decToRString(個人用.get決定前_公費３負担額2()));
        帳票データ.set決定後_公費3負担額2(decToRString(個人用.get決定後_公費３負担額2()));
        帳票データ.set決定前_利用者負担額2(decToRString(個人用.get決定前_利用者負担額2()));
        帳票データ.set決定後_利用者負担額2(decToRString(個人用.get決定後_利用者負担額2()));
        帳票データ.set再審査回数2_k(個人用.get特定_再審査回数2());
        帳票データ.set過誤回数2_k(個人用.get特定_過誤回数2());
        帳票データ.set審査年月2_k(個人用.get特定_審査年月2());
        帳票データ.set番号3(個人用.get番号3());
        帳票データ.setサービスコードﾞ3_k(個人用.getサービスコードﾞ3());
        帳票データ.setサービス内容3_k(個人用.get特定_サービス内容3());
        帳票データ.set決定前_費用単価3(decToRString(個人用.get決定前_費用単価3()));
        帳票データ.set決定後_費用単価3(decToRString(個人用.get決定後_費用単価3()));
        帳票データ.set負担限度額3(decToRString(個人用.get負担限度額3()));
        帳票データ.set決定前_日数3(new RString(個人用.get決定前_日数3()));
        帳票データ.set決定後_日数3(new RString(個人用.get決定後_日数3()));
        帳票データ.set決定前_公費1日数3(new RString(個人用.get決定前_公費１日数3()));
        帳票データ.set決定後_公費1日数3(new RString(個人用.get決定後_公費１日数3()));
        帳票データ.set決定前_公費2日数3(new RString(個人用.get決定前_公費２日数3()));
        帳票データ.set決定後_公費2日数3(new RString(個人用.get決定後_公費２日数3()));
        帳票データ.set決定前_公費3日数3(new RString(個人用.get決定前_公費３日数3()));
        帳票データ.set決定後_公費3日数3(new RString(個人用.get決定後_公費３日数3()));
        帳票データ.set決定前_費用額3(decToRString(個人用.get決定前_費用額3()));
        帳票データ.set決定後_費用額3(decToRString(個人用.get決定後_費用額3()));
        帳票データ.set決定前_保険分請求額3(decToRString(個人用.get決定前_保険分請求額3()));
        帳票データ.set決定後_保険分請求額3(decToRString(個人用.get決定後_保険分請求額3()));
        帳票データ.set決定前_公費1負担額3(decToRString(個人用.get決定前_公費１負担額3()));
        帳票データ.set決定後_公費1負担額3(decToRString(個人用.get決定後_公費１負担額3()));
        帳票データ.set決定前_公費2負担額3(decToRString(個人用.get決定前_公費２負担額3()));
        帳票データ.set決定後_公費2負担額3(decToRString(個人用.get決定後_公費２負担額3()));
        帳票データ.set決定前_公費3負担額3(decToRString(個人用.get決定前_公費３負担額3()));
        帳票データ.set決定後_公費3負担額3(decToRString(個人用.get決定後_公費３負担額3()));
        帳票データ.set決定前_利用者負担額3(decToRString(個人用.get決定前_利用者負担額3()));
        帳票データ.set決定後_利用者負担額3(decToRString(個人用.get決定後_利用者負担額3()));
        帳票データ.set再審査回数3_k(個人用.get特定_再審査回数3());
        帳票データ.set過誤回数3_k(個人用.get特定_過誤回数3());
        return 帳票データ;
    }

    private static JukyushaKyufuJissekidaichoData set帳票データ3(JukyushaKyufuJissekidaichoData 帳票データ,
            KojinyoTyohyoDataKomoku 個人用) {
        帳票データ.set審査年月3_k(個人用.get特定_審査年月3());
        帳票データ.set決定前_費用額合計_合計情報(decToRString(個人用.get決定前_費用額合計_合計情報()));
        帳票データ.set決定後_費用額合計_合計情報(decToRString(個人用.get決定後_費用額合計_合計情報()));
        帳票データ.set決定前_保険分請求額合計_合計情報(decToRString(個人用.get決定前_保険分請求額合計_合計情報()));
        帳票データ.set決定後_保険分請求額合計_合計情報(decToRString(個人用.get決定後_保険分請求額合計_合計情報()));
        帳票データ.set決定前_利用者負担額合計_合計情報(decToRString(個人用.get決定前_利用者負担額合計_合計情報()));
        帳票データ.set決定後_利用者負担額合計_合計情報(decToRString(個人用.get決定後_利用者負担額合計_合計情報()));
        帳票データ.set決定前_費用額合計_合計情報(decToRString(個人用.get決定前_費用額合計_合計情報()));
        帳票データ.set決定後_費用額合計_合計情報(decToRString(個人用.get決定後_費用額合計_合計情報()));
        帳票データ.set決定前_費用額合計_合計情報公費1(decToRString(個人用.get決定前_費用額合計_合計情報公費１()));
        帳票データ.set決定後_費用額合計_合計情報公費1(decToRString(個人用.get決定後_費用額合計_合計情報公費１()));
        帳票データ.set決定前_保険分請求額合計_合計情報公費1(decToRString(個人用.get決定前_保険分請求額合計_合計情報公費１()));
        帳票データ.set決定後_保険分請求額合計_合計情報公費1(decToRString(個人用.get決定後_保険分請求額合計_合計情報公費１()));
        帳票データ.set決定前_利用者負担額合計_合計情報公費1(decToRString(個人用.get決定前_利用者負担額合計_合計情報公費１()));
        帳票データ.set決定後_利用者負担額合計_合計情報公費1(decToRString(個人用.get決定後_利用者負担額合計_合計情報公費１()));
        帳票データ.set決定前_費用額合計_合計情報公費2(decToRString(個人用.get決定前_費用額合計_合計情報公費２()));
        帳票データ.set決定後_費用額合計_合計情報公費2(decToRString(個人用.get決定後_費用額合計_合計情報公費２()));
        帳票データ.set決定前_保険分請求額合計_合計情報公費2(decToRString(個人用.get決定前_保険分請求額合計_合計情報公費２()));
        帳票データ.set決定後_保険分請求額合計_合計情報公費2(decToRString(個人用.get決定後_保険分請求額合計_合計情報公費２()));
        帳票データ.set決定前_利用者負担額合計_合計情報公費2(decToRString(個人用.get決定前_利用者負担額合計_合計情報公費２()));
        帳票データ.set決定後_利用者負担額合計_合計情報公費2(decToRString(個人用.get決定後_利用者負担額合計_合計情報公費２()));
        帳票データ.set決定前_費用額合計_合計情報公費3(decToRString(個人用.get決定前_費用額合計_合計情報公費３()));
        帳票データ.set決定後_費用額合計_合計情報公費3(decToRString(個人用.get決定後_費用額合計_合計情報公費３()));
        帳票データ.set決定前_保険分請求額合計_合計情報公費3(decToRString(個人用.get決定前_保険分請求額合計_合計情報公費３()));
        帳票データ.set決定後_保険分請求額合計_合計情報公費3(decToRString(個人用.get決定後_保険分請求額合計_合計情報公費３()));
        帳票データ.set決定前_利用者負担額合計_合計情報公費3(decToRString(個人用.get決定前_利用者負担額合計_合計情報公費３()));
        帳票データ.set決定後_利用者負担額合計_合計情報公費3(decToRString(個人用.get決定後_利用者負担額合計_合計情報公費３()));
        帳票データ.setｻｰﾋﾞｽ種類(個人用.get集計_ｻｰﾋﾞｽ種類());
        帳票データ.setサービス種類名称1(個人用.get集計_サービス種類名称1());
        帳票データ.setサービス種類名称2(個人用.get集計_サービス種類名称2());
        帳票データ.setサービス実日数(new RString(個人用.get集計_サービス実日数()));
        帳票データ.set計画単位数(decToRString(個人用.get集計_計画単位数()));
        帳票データ.set限度額管理対象単位数(decToRString(個人用.get集計_限度額管理対象単位数()));
        帳票データ.set限度額管理対象外単位数(decToRString(個人用.get集計_限度額管理対象外単位数()));
        帳票データ.set決定後サービス計画日数1(個人用.get集計_決定後サービス計画日数1());
        帳票データ.set決定後サービス計画日数2(個人用.get集計_決定後サービス計画日数2());
        帳票データ.set短期日数(個人用.get集計_短期日数());
        帳票データ.set決定後サービス実施日数1(個人用.get集計_決定後サービス実施日数1());
        帳票データ.set決定後サービス実施日数2(個人用.get集計_決定後サービス実施日数2());
        帳票データ.set決定後サービス実施日数3(個人用.get集計_決定後サービス実施日数3());
        帳票データ.set決定前_単位数合計_保険(decToRString(個人用.get集計_決定前_単位数合計_保険()));
        帳票データ.set決定後_単位数合計_保険(decToRString(個人用.get集計_決定後_単位数合計_保険()));
        帳票データ.set単位数単価_保険(decToRString(個人用.get集計_単位数単価_保険()));
        帳票データ.set決定前_請求額_保険(decToRString(個人用.get集計_決定前_請求額_保険()));
        帳票データ.set決定後_請求額_保険(decToRString(個人用.get集計_決定後_請求額_保険()));
        帳票データ.set負担額_保険(decToRString(個人用.get集計_負担額_保険()));
        帳票データ.set決定前_出来高医療費単位数合計_保険(decToRString(個人用.get集計_決定前_出来高医療費単位数合計_保険()));
        帳票データ.set決定後_出来高医療費単位数合計_保険(decToRString(個人用.get集計_決定後_出来高医療費単位数合計_保険()));
        帳票データ.set決定前_出来高医療費請求額_保険(decToRString(個人用.get集計_決定前_出来高医療費請求額_保険()));
        帳票データ.set決定後_出来高医療費請求額_保険(decToRString(個人用.get集計_決定後_出来高医療費請求額_保険()));
        帳票データ.set出来高医療費負担額_保険(decToRString(個人用.get集計_出来高医療費負担額_保険()));
        帳票データ.set決定前_単位数合計_公費1(decToRString(個人用.get集計_決定前_単位数合計_公費１()));
        帳票データ.set決定後_単位数合計_公費1(decToRString(個人用.get集計_決定後_単位数合計_公費１()));
        帳票データ.set決定前_請求額_公費1(decToRString(個人用.get集計_決定前_請求額_公費１()));
        帳票データ.set決定後_請求額_公費1(decToRString(個人用.get集計_決定後_請求額_公費１()));
        帳票データ.set負担額_公費1(decToRString(個人用.get集計_負担額_公費１()));
        帳票データ.set決定前_出来高医療費単位数合計_公費1(decToRString(個人用.get集計_決定前_出来高医療費単位数合計_公費１()));
        帳票データ.set決定後_出来高医療費単位数合計_公費1(decToRString(個人用.get集計_決定後_出来高医療費単位数合計_公費１()));
        帳票データ.set決定前_出来高医療費請求額_公費1(decToRString(個人用.get集計_決定前_出来高医療費請求額_公費１()));
        帳票データ.set決定後_出来高医療費請求額_公費1(decToRString(個人用.get集計_決定後_出来高医療費請求額_公費１()));
        帳票データ.set出来高医療費負担額_公費1(decToRString(個人用.get集計_出来高医療費負担額_公費１()));
        帳票データ.set決定前_単位数合計_公費2(decToRString(個人用.get集計_決定前_単位数合計_公費２()));
        帳票データ.set決定後_単位数合計_公費2(decToRString(個人用.get集計_決定後_単位数合計_公費２()));
        帳票データ.set決定前_請求額_公費2(decToRString(個人用.get集計_決定前_請求額_公費２()));
        帳票データ.set決定後_請求額_公費2(decToRString(個人用.get集計_決定後_請求額_公費２()));
        帳票データ.set負担額_公費2(decToRString(個人用.get集計_負担額_公費２()));
        帳票データ.set決定前_出来高医療費単位数合計_公費2(decToRString(個人用.get集計_決定前_出来高医療費単位数合計_公費２()));
        帳票データ.set決定後_出来高医療費単位数合計_公費2(decToRString(個人用.get集計_決定後_出来高医療費単位数合計_公費２()));
        帳票データ.set決定前_出来高医療費請求額_公費2(decToRString(個人用.get集計_決定前_出来高医療費請求額_公費２()));
        帳票データ.set決定後_出来高医療費請求額_公費2(decToRString(個人用.get集計_決定後_出来高医療費請求額_公費２()));
        帳票データ.set出来高医療費負担額_公費2(decToRString(個人用.get集計_出来高医療費負担額_公費２()));
        帳票データ.set決定前_単位数合計_公費3(decToRString(個人用.get集計_決定前_単位数合計_公費３()));
        帳票データ.set決定後_単位数合計_公費3(decToRString(個人用.get集計_決定後_単位数合計_公費３()));
        帳票データ.set決定前_請求額_公費3(decToRString(個人用.get集計_決定前_請求額_公費３()));
        帳票データ.set決定後_請求額_公費3(decToRString(個人用.get集計_決定後_請求額_公費３()));
        帳票データ.set負担額_公費3(decToRString(個人用.get集計_負担額_公費３()));
        帳票データ.set決定前_出来高医療費単位数合計_公費3(decToRString(個人用.get集計_決定前_出来高医療費単位数合計_公費３()));
        帳票データ.set決定後_出来高医療費単位数合計_公費3(decToRString(個人用.get集計_決定後_出来高医療費単位数合計_公費３()));
        帳票データ.set決定前_出来高医療費請求額_公費3(decToRString(個人用.get集計_決定前_出来高医療費請求額_公費３()));
        帳票データ.set決定後_出来高医療費請求額_公費3(decToRString(個人用.get集計_決定後_出来高医療費請求額_公費３()));
        帳票データ.set出来高医療費負担額_公費3(decToRString(個人用.get集計_出来高医療費負担額_公費３()));
        帳票データ.set再審査回数(new RString(個人用.get集計_再審査回数()));
        帳票データ.set過誤回数(new RString(個人用.get集計_過誤回数()));
        帳票データ.set審査年月(dateFormat年月(個人用.get集計_審査年月()));
        帳票データ.setヘッダー1(個人用.getヘッダー1());
        帳票データ.setヘッダー2(個人用.getヘッダー2());
        帳票データ.setヘッダー3(個人用.getヘッダー3());
        帳票データ.setヘッダー4(個人用.getヘッダー4());
        帳票データ.setヘッダー5(個人用.getヘッダー5());
        帳票データ.setヘッダー6(個人用.getヘッダー6());
        帳票データ.set明細1(個人用.get明細1());
        帳票データ.set明細2(個人用.get明細2());
        帳票データ.set明細3(個人用.get明細3());
        帳票データ.set明細4(個人用.get明細4());
        帳票データ.set明細5(個人用.get明細5());
        帳票データ.set明細6(個人用.get明細6());
        帳票データ.set明細7(個人用.get明細7());
        帳票データ.set明細8(個人用.get明細8());
        帳票データ.set明細9(個人用.get明細9());
        帳票データ.set明細10(個人用.get明細10());
        帳票データ.set明細11(個人用.get明細11());
        帳票データ.set明細12(個人用.get明細12());
        帳票データ.set明細13(個人用.get明細13());
        帳票データ.set明細14(個人用.get明細14());
        帳票データ.set明細15(個人用.get明細15());
        帳票データ.set明細16(個人用.get明細16());
        帳票データ.set明細17(個人用.get明細17());
        帳票データ.set明細18(個人用.get明細18());
        帳票データ.set明細19(個人用.get明細19());
        帳票データ.set明細20(個人用.get明細20());
        帳票データ.set明細21(個人用.get明細21());
        帳票データ.set適用1(個人用.get適用1());
        帳票データ.set適用2(個人用.get適用2());
        帳票データ.set適用3(個人用.get適用3());
        帳票データ.set適用4(個人用.get適用4());
        帳票データ.set適用5(個人用.get適用5());
        帳票データ.set適用6(個人用.get適用6());
        帳票データ.set適用7(個人用.get適用7());
        帳票データ.set適用8(個人用.get適用8());
        帳票データ.set適用9(個人用.get適用9());
        帳票データ.set適用10(個人用.get適用10());
        帳票データ.set適用11(個人用.get適用11());
        帳票データ.set適用12(個人用.get適用12());
        帳票データ.set適用13(個人用.get適用13());
        帳票データ.set適用14(個人用.get適用14());
        帳票データ.set適用15(個人用.get適用15());
        帳票データ.set適用16(個人用.get適用16());
        帳票データ.set適用17(個人用.get適用17());
        帳票データ.set適用18(個人用.get適用18());
        帳票データ.set適用19(個人用.get適用19());
        帳票データ.set適用20(個人用.get適用20());
        帳票データ.set適用21(個人用.get適用21());
        return 帳票データ;
    }

    /**
     * 計画費明細を設定します。
     *
     * @param 計画費List 計画費List
     * @param list特定データ list特定データ
     * @param 個人用帳票データ 個人用帳票データ
     * @return 個人用帳票データ
     */
    public static List<KojinyoTyohyoDataKomoku> set計画費明細(List<KeikakuHiEntity> 計画費List,
            List<KojinyoTyohyoDataKomoku> list特定データ,
            KojinyoTyohyoDataKomoku 個人用帳票データ) {
        for (int i = 0; i < 計画費List.size(); i++) {
            KeikakuHiEntity 計画費 = 計画費List.get(i);
            個人用帳票データ.setヘッダー1(計画費.get略称());
            個人用帳票データ.setヘッダー2(new RString("指定／基準事業所区分     単位数単価          届出年月日       担当介護支援専門員番号"));
            RString サービス名称 = RString.EMPTY;
            if (!RString.isNullOrEmpty(計画費.getサービス名称())) {
                サービス名称 = 計画費.getサービス名称();
            }
            if ((i % INDEX_5) == 0) {
                個人用帳票データ.set明細2(計画費.get事業所番号().concat(SPACE_10).concat(decToRString(計画費.get単位数単価()))
                        .concat(dateFromat_生年月日(計画費.get居宅サービス計画作成依頼届出年月日())).concat(SPACE_7)
                        .concat(計画費.get担当介護支援専門員番号()));
                個人用帳票データ.set明細4(new RString("明細行番号　　　　　　決定前　　単位数　　　　回数　"
                        + "　　　回数　　　　ｻｰﾋﾞｽ単位数合計　　　　請求金額"));
                個人用帳票データ.set明細5(new RString("サービスコード　　決定後　　単位数　　　　"
                        + "回数　　　　ｻｰﾋﾞｽ単位数　　　　ｻｰﾋﾞｽ単位数合計　　　　請求金額"));
                個人用帳票データ.set明細6(new RString("サービス名称　　　　　　　　　　　　　　　　　　　　"
                        + "摘要　　　　　　　　　　　　　　　　　　再審査回数　　"
                        + "過誤回数　　審査年月"));
                個人用帳票データ.set明細7(計画費.get明細行番号().concat(SPACE_23)
                        .concat(kingakuFormat(計画費.get単位数().intValue())).concat(SPACE_4)
                        .concat(new RString(計画費.get回数())).concat("回").concat(SPACE_8)
                        .concat(kingakuFormat(計画費.getサービス単位数().intValue())).concat(SPACE_12)
                        .concat(kingakuFormat(計画費.getサービス単位数合計().intValue())).concat(SPACE_5)
                        .concat(kingakuFormat(計画費.get請求金額().intValue())));
                個人用帳票データ.set明細8(計画費.get明細行番号().concat(SPACE_23)
                        .concat(kingakuFormat(計画費.get単位数().intValue())).concat(SPACE_4)
                        .concat(new RString(計画費.get回数())).concat("回").concat(SPACE_8)
                        .concat(kingakuFormat(計画費.getサービス単位数().intValue())).concat(SPACE_12)
                        .concat(kingakuFormat(計画費.getサービス単位数合計().intValue())).concat(SPACE_5)
                        .concat(kingakuFormat(計画費.get請求金額().intValue())));
                個人用帳票データ.set明細8(RString.EMPTY);
                個人用帳票データ.set明細9(サービス名称.concat("　　")
                        .concat(計画費.get摘要()).concat(SPACE_8)
                        .concat(new RString(計画費.get再審査回数())).concat("回").concat(SPACE_6)
                        .concat(new RString(計画費.get過誤回数())).concat(SPACE_回)
                        .concat(dateFormat年月(計画費.get審査年月())));
                if (i == (計画費List.size() - 1)) {
                    list特定データ.add(個人用帳票データ);
                }
            }
            if ((i % INDEX_5) == 1) {
                個人用帳票データ.set明細10(計画費.get明細行番号().concat(SPACE_23)
                        .concat(kingakuFormat(計画費.get単位数単価().intValue())).concat(SPACE_4)
                        .concat(new RString(計画費.get回数())).concat("回").concat(SPACE_8)
                        .concat(kingakuFormat(計画費.getサービス単位数().intValue())).concat(SPACE_12)
                        .concat(kingakuFormat(計画費.getサービス単位数合計().intValue())).concat(SPACE_5)
                        .concat(kingakuFormat(計画費.get請求金額().intValue())));
                個人用帳票データ.set明細11(計画費.get明細行番号().concat(SPACE_23)
                        .concat(kingakuFormat(計画費.get単位数().intValue())).concat(SPACE_4)
                        .concat(new RString(計画費.get回数())).concat("回").concat(SPACE_8)
                        .concat(kingakuFormat(計画費.getサービス単位数().intValue())).concat(SPACE_12)
                        .concat(kingakuFormat(計画費.getサービス単位数合計().intValue())).concat(SPACE_5)
                        .concat(kingakuFormat(計画費.get請求金額().intValue())));
                個人用帳票データ.set明細12(サービス名称.concat("　　")
                        .concat(計画費.get摘要()).concat(SPACE_8)
                        .concat(new RString(計画費.get再審査回数())).concat("回").concat(SPACE_6)
                        .concat(new RString(計画費.get過誤回数())).concat(SPACE_回)
                        .concat(dateFormat年月(計画費.get審査年月())));
                if (i == (計画費List.size() - 1)) {
                    list特定データ.add(個人用帳票データ);
                }
            }
            if ((i % INDEX_5) == 2) {
                個人用帳票データ.set明細13(計画費.get明細行番号().concat(SPACE_23)
                        .concat(kingakuFormat(計画費.get単位数単価().intValue())).concat(SPACE_4)
                        .concat(new RString(計画費.get回数())).concat("回").concat(SPACE_8)
                        .concat(kingakuFormat(計画費.getサービス単位数().intValue())).concat(SPACE_12)
                        .concat(kingakuFormat(計画費.getサービス単位数合計().intValue())).concat(SPACE_5)
                        .concat(kingakuFormat(計画費.get請求金額().intValue())));
                個人用帳票データ.set明細14(計画費.get明細行番号().concat(SPACE_23)
                        .concat(kingakuFormat(計画費.get単位数().intValue())).concat(SPACE_4)
                        .concat(new RString(計画費.get回数())).concat("回").concat(SPACE_8)
                        .concat(kingakuFormat(計画費.getサービス単位数().intValue())).concat(SPACE_12)
                        .concat(kingakuFormat(計画費.getサービス単位数合計().intValue())).concat(SPACE_5)
                        .concat(kingakuFormat(計画費.get請求金額().intValue())));
                個人用帳票データ.set明細15(計画費.getサービス名称().concat("　　")
                        .concat(計画費.get摘要()).concat(SPACE_8)
                        .concat(new RString(計画費.get再審査回数())).concat("回").concat(SPACE_6)
                        .concat(new RString(計画費.get過誤回数())).concat(SPACE_回)
                        .concat(dateFormat年月(計画費.get審査年月())));
                if (i == (計画費List.size() - 1)) {
                    list特定データ.add(個人用帳票データ);
                }
            }
            if ((i % INDEX_5) == INDEX_3) {
                個人用帳票データ.set明細13(計画費.get明細行番号().concat(SPACE_23)
                        .concat(kingakuFormat(計画費.get単位数単価().intValue())).concat(SPACE_4)
                        .concat(new RString(計画費.get回数())).concat("回").concat(SPACE_8)
                        .concat(kingakuFormat(計画費.getサービス単位数().intValue())).concat(SPACE_12)
                        .concat(kingakuFormat(計画費.getサービス単位数合計().intValue())).concat(SPACE_5)
                        .concat(kingakuFormat(計画費.get請求金額().intValue())));
                個人用帳票データ.set明細14(計画費.get明細行番号().concat(SPACE_23)
                        .concat(kingakuFormat(計画費.get単位数().intValue())).concat(SPACE_4)
                        .concat(new RString(計画費.get回数())).concat("回").concat(SPACE_8)
                        .concat(kingakuFormat(計画費.getサービス単位数().intValue())).concat(SPACE_12)
                        .concat(kingakuFormat(計画費.getサービス単位数合計().intValue())).concat(SPACE_5)
                        .concat(kingakuFormat(計画費.get請求金額().intValue())));
                個人用帳票データ.set明細15(計画費.getサービス名称().concat("　　")
                        .concat(計画費.get摘要()).concat(SPACE_8)
                        .concat(new RString(計画費.get再審査回数())).concat("回").concat(SPACE_6)
                        .concat(new RString(計画費.get過誤回数())).concat(SPACE_回)
                        .concat(dateFormat年月(計画費.get審査年月())));
                if (i == (計画費List.size() - 1)) {
                    list特定データ.add(個人用帳票データ);
                }
            }
            if ((i % INDEX_5) == INDEX_4) {
                個人用帳票データ.set明細16(計画費.get明細行番号().concat(SPACE_23)
                        .concat(kingakuFormat(計画費.get単位数単価().intValue())).concat(SPACE_4)
                        .concat(new RString(計画費.get回数())).concat("回").concat(SPACE_8)
                        .concat(kingakuFormat(計画費.getサービス単位数().intValue())).concat(SPACE_12)
                        .concat(kingakuFormat(計画費.getサービス単位数合計().intValue())).concat(SPACE_5)
                        .concat(kingakuFormat(計画費.get請求金額().intValue())));
                個人用帳票データ.set明細17(計画費.get明細行番号().concat(SPACE_23)
                        .concat(kingakuFormat(計画費.get単位数().intValue())).concat(SPACE_4)
                        .concat(new RString(計画費.get回数())).concat("回").concat(SPACE_8)
                        .concat(kingakuFormat(計画費.getサービス単位数().intValue())).concat(SPACE_12)
                        .concat(kingakuFormat(計画費.getサービス単位数合計().intValue())).concat(SPACE_5)
                        .concat(kingakuFormat(計画費.get請求金額().intValue())));
                個人用帳票データ.set明細18(計画費.getサービス名称().concat("　　").concat(計画費.get摘要()).concat(SPACE_8)
                        .concat(new RString(計画費.get再審査回数())).concat("回").concat(SPACE_6)
                        .concat(new RString(計画費.get過誤回数())).concat(SPACE_回)
                        .concat(dateFormat年月(計画費.get審査年月())));
                if (i == (計画費List.size() - 1)) {
                    list特定データ.add(個人用帳票データ);
                }
            }
            if ((i % INDEX_5) == INDEX_4) {
                個人用帳票データ.set明細19(計画費.get明細行番号().concat(SPACE_23)
                        .concat(kingakuFormat(計画費.get単位数単価().intValue())).concat(SPACE_4)
                        .concat(new RString(計画費.get回数())).concat("回").concat(SPACE_8)
                        .concat(kingakuFormat(計画費.getサービス単位数().intValue())).concat(SPACE_12)
                        .concat(kingakuFormat(計画費.getサービス単位数合計().intValue())).concat(SPACE_5)
                        .concat(kingakuFormat(計画費.get請求金額().intValue())));
                個人用帳票データ.set明細20(計画費.get明細行番号().concat(SPACE_23).concat(kingakuFormat(計画費.get単位数().intValue())).concat(SPACE_4)
                        .concat(new RString(計画費.get回数())).concat("回").concat(SPACE_8)
                        .concat(kingakuFormat(計画費.getサービス単位数().intValue())).concat(SPACE_12)
                        .concat(kingakuFormat(計画費.getサービス単位数合計().intValue())).concat(SPACE_5)
                        .concat(kingakuFormat(計画費.get請求金額().intValue())));
                個人用帳票データ.set明細21(計画費.getサービス名称().concat("　　").concat(計画費.get摘要()).concat(SPACE_8)
                        .concat(new RString(計画費.get再審査回数())).concat("回").concat(SPACE_6)
                        .concat(new RString(計画費.get過誤回数())).concat(SPACE_回)
                        .concat(dateFormat年月(計画費.get審査年月())));
                list特定データ.add(個人用帳票データ);
            }
        }
        return list特定データ;
    }

    private static RString decToRString(Decimal data) {
        if (data == null) {
            return new RString("0");
        }
        return new RString(data.intValue());
    }

    private static RString dateFormat年月(FlexibleYearMonth date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return date.wareki().eraType(EraType.ALPHABET).firstYear(FirstYear.GAN_NEN).
                separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString();
    }

    private static RString dateFromat_生年月日(RString 生年月日) {
        if (RString.isNullOrEmpty(生年月日)) {
            return RString.EMPTY;
        }
        RDate date = new RDate(生年月日.toString());
        return date.wareki().eraType(EraType.ALPHABET).firstYear(FirstYear.GAN_NEN).
                separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString();
    }

    private static RString dateFromat_生年月日(FlexibleDate 生年月日) {
        if (生年月日 == null) {
            return RString.EMPTY;
        }
        return 生年月日.wareki().eraType(EraType.ALPHABET).firstYear(FirstYear.GAN_NEN).
                separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString();
    }

    private static RString kingakuFormat(int date) {
        return DecimalFormatter.toコンマ区切りRString(new Decimal(date), 0);
    }

    /**
     * 帳票分類ID「DBC100055_JukyushaKyufuJissekidaicho」受給者給付実績台帳出力順設定可能項目です。
     */
    public enum ShutsuryokujunEnum implements IReportItems {

        /**
         * 町域コード
         */
        町域コード(new RString("0002"), new RString("jushoCd"), new RString("住所コード")),
        /**
         * 行政区コード
         */
        行政区コード(new RString("0004"), new RString("gyoseikuCd"), new RString("行政区コード")),
        /**
         * 世帯コード
         */
        世帯コード(new RString("0008"), new RString("setaiCd"), new RString("世帯コード")),
        /**
         * 氏名５０音カナ
         */
        氏名５０音カナ(new RString("0010"), new RString("hihoNameKana"), new RString("被保険者氏名カナ")),
        /**
         * 市町村コード
         */
        市町村コード(new RString("0016"), new RString("shichousonCode"), new RString("市町村コード")),
        /**
         * 被保険者番号
         */
        被保険者番号(new RString("0104"), new RString("hihoNo"), new RString("被保険者番号")),
        /**
         * サービス年月
         */
        サービス年月(new RString("0301"), new RString("serviceYm"), new RString("サービス提供年月")),
        /**
         * 審査年月
         */
        審査年月(new RString("0402"), new RString("shinsaYmKihon"), new RString("審査年月")),
        /**
         * 指定事業者番号
         */
        指定事業者番号(new RString("0303"), new RString("jigyoshoNo_No"), new RString("事業所番号")),
        /**
         * 現物償還の別
         */
        現物償還の別(new RString("0306"), new RString("jissekiKbnMei"), new RString("実績区分")),
        /**
         * 様式番号
         */
        様式番号(new RString("0315"), new RString("inputShikibetsuNo"), new RString("入力識別番号")),
        /**
         * 要介護度
         */
        要介護度(new RString("0403"), new RString("youKaigoKbnMei"), new RString("要介護度"));

        private final RString 項目ID;
        private final RString フォームフィールド名;
        private final RString myBatis項目名;

        private ShutsuryokujunEnum(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
            this.項目ID = 項目ID;
            this.フォームフィールド名 = フォームフィールド名;
            this.myBatis項目名 = myBatis項目名;
        }

        @Override
        public RString get項目ID() {
            return 項目ID;
        }

        @Override
        public RString getフォームフィールド名() {
            return フォームフィールド名;
        }

        @Override
        public RString getMyBatis項目名() {
            return myBatis項目名;
        }
    }

}
