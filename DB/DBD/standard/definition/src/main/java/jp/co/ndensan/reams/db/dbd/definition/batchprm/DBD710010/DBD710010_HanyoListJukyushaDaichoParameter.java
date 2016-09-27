/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD710010;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.hanyolist.jukyusha2.ChushutsuHohoKubun;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.hanyolist.jukyusha2.SoshitsuKubun;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.AtenaSelectBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 汎用リスト受給者台帳バッチ用のパラメータです。
 *
 * @reamsid_L DBD-1800-020 liwul
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBD710010_HanyoListJukyushaDaichoParameter extends BatchParameterBase {

    private static final String CYUSYUTSUHOHOKUBUN = "cyusyutsuhohokubun";
    private static final String YUKOUDATASAISIN = "yukoudatasaisin";
    private static final String KIZYUNNICHI = "kizyunnichi";
    private static final String HITSUKEHANIFROM = "hitsukehanifrom";
    private static final String HITSUKEHANITO = "hitsukehanito";
    private static final String NINTEIKEKKA_0 = "ninteikekka0";
    private static final String NINTEIKEKKA_1 = "ninteikekka1";
    private static final String NINTEIKEKKA_2 = "ninteikekka2";
    private static final String NINTEIKEKKA_3 = "ninteikekka3";
    private static final String NINTEIKEKKA_4 = "ninteikekka4";
    private static final String NINTEIKEKKA_5 = "ninteikekka5";
    private static final String NINTEIKEKKA_6 = "ninteikekka6";
    private static final String NINTEIKEKKA_7 = "ninteikekka7";
    private static final String NINTEIKEKKA_8 = "ninteikekka8";
    private static final String NINTEIKEKKA_9 = "ninteikekka9";
    private static final String NINTEIKEKKA_10 = "ninteikekka10";
    private static final String SOSHITSUKUBUN = "soshitsukubun";
    private static final String KYUSOCHISHA = "kyusochisha";
    private static final String HIHOKENSYA_1 = "hihokensya1";
    private static final String HIHOKENSYA_2 = "hihokensya2";
    private static final String NINTEISABISU = "ninteiSabisu";
    private static final String KOMOKUMEIFUKA = "komokumeifuka";
    private static final String RENBANFUKA = "renbanfuka";
    private static final String HITSUKESURASYUHENSYU = "hitsukesurasyuhensyu";
    private static final String ATENACYUSYUTSUJYOKEN = "atenacyusyutsujyoken";
    private static final String SYUTSURYOKUJUNPARAMETER = "syutsuryokujunparameter";
    private static final String SYUTSURYOKUKOMOKU = "syutsuryokukomoku";

    @BatchParameter(key = CYUSYUTSUHOHOKUBUN, name = "抽出方法区分")
    private ChushutsuHohoKubun cyusyutsuhohokubun;
    @BatchParameter(key = YUKOUDATASAISIN, name = "有効データ内最新")
    private boolean isYukoudatasaisin;
    @BatchParameter(key = KIZYUNNICHI, name = "基準日")
    private FlexibleDate kizyunnichi;
    @BatchParameter(key = HITSUKEHANIFROM, name = "日付範囲From")
    private FlexibleDate hitsukehanifrom;
    @BatchParameter(key = HITSUKEHANITO, name = "日付範囲To")
    private FlexibleDate hitsukehanito;
    @BatchParameter(key = NINTEIKEKKA_0, name = "認定結果_0")
    private boolean isNinteikekka0;
    @BatchParameter(key = NINTEIKEKKA_1, name = "認定結果_1")
    private boolean isNinteikekka1;
    @BatchParameter(key = NINTEIKEKKA_2, name = "認定結果_2")
    private boolean isNinteikekka2;
    @BatchParameter(key = NINTEIKEKKA_3, name = "認定結果_3")
    private boolean isNinteikekka3;
    @BatchParameter(key = NINTEIKEKKA_4, name = "認定結果_4")
    private boolean isNinteikekka4;
    @BatchParameter(key = NINTEIKEKKA_5, name = "認定結果_5")
    private boolean isNinteikekka5;
    @BatchParameter(key = NINTEIKEKKA_6, name = "認定結果_6")
    private boolean isNinteikekka6;
    @BatchParameter(key = NINTEIKEKKA_7, name = "認定結果_7")
    private boolean isNinteikekka7;
    @BatchParameter(key = NINTEIKEKKA_8, name = "認定結果_8")
    private boolean isNinteikekka8;
    @BatchParameter(key = NINTEIKEKKA_9, name = "認定結果_9")
    private boolean isNinteikekka9;
    @BatchParameter(key = NINTEIKEKKA_10, name = "認定結果_10")
    private boolean isNinteikekka10;
    @BatchParameter(key = SOSHITSUKUBUN, name = "喪失区分")
    private SoshitsuKubun soshitsukubun;
    @BatchParameter(key = KYUSOCHISHA, name = "旧措置者")
    private boolean isKyusochisha;
    @BatchParameter(key = HIHOKENSYA_1, name = "１号被保険者")
    private boolean isHihokensya1;
    @BatchParameter(key = HIHOKENSYA_2, name = "２号被保険者")
    private boolean isHihokensya2;
    @BatchParameter(key = NINTEISABISU, name = "サービス指定者")
    private boolean isNinteiSabisu;
    @BatchParameter(key = KOMOKUMEIFUKA, name = "項目名付加")
    private boolean isCsvkomokumeifuka;
    @BatchParameter(key = RENBANFUKA, name = "連番付加")
    private boolean isCsvrenbanfuka;
    @BatchParameter(key = HITSUKESURASYUHENSYU, name = "日付スラッシュ付加")
    private boolean isCsvhitsukesurasyuhensyu;
    @BatchParameter(key = ATENACYUSYUTSUJYOKEN, name = "宛名抽出条件")
    private AtenaSelectBatchParameter atenacyusyutsujyoken;
    @BatchParameter(key = SYUTSURYOKUJUNPARAMETER, name = "出力順パラメータ")
    private Long syutsuryokujunparameter;
    @BatchParameter(key = SYUTSURYOKUKOMOKU, name = "出力項目")
    private RString syutsuryokukomoku;

}
