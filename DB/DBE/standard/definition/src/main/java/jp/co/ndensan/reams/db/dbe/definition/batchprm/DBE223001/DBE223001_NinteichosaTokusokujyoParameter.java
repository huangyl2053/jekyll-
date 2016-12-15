/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE223001;

import jp.co.ndensan.reams.db.dbe.definition.core.ninteichosatokusokujohakko.NinteiChosaTokusokujoHakkoTempData;
import jp.co.ndensan.reams.db.dbe.definition.processprm.ninteichosatokusokujyo.NinteiChosaTokusokuTaishoshaIchiranhyoProcessParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.ninteichosatokusokujyo.NinteiChosaTokusokujoProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 認定調査督促状発行のバッチパラメータクラスです。
 *
 * @reamsid_L DBE-0030-040 xuyue
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class DBE223001_NinteichosaTokusokujyoParameter extends BatchParameterBase {

    private RString temp_保険者コード;
    private RString temp_保険者名称;
    private RString temp_認定調査委託先コード;
    private RString temp_認定調査員コード;
    private FlexibleDate temp_基準日;
    private Decimal temp_認定調査督促期限日数;
    private RString temp_要介護認定調査督促状;
    private RString temp_認定調査督促対象者一覧表;
    private RString temp_CSV出力;
    private RString temp_印刷済対象者;
    private RString temp_発行履歴;
    private int temp_督促方法;
    private RString temp_督促メモ;
    private FlexibleDate temp_督促日;
    private FlexibleDate temp_印刷期間開始日;
    private FlexibleDate temp_印刷期間終了日;

    /**
     * 画面からのパラメータを作成します。
     *
     * @param tempData 画面データ
     */
    public void toDBE223001Parameter(NinteiChosaTokusokujoHakkoTempData tempData) {
        this.temp_保険者コード = tempData.getTemp_保険者コード();
        this.temp_保険者名称 = tempData.getTemp_保険者名称();
        this.temp_認定調査委託先コード = tempData.getTemp_認定調査委託先コード();
        this.temp_認定調査員コード = tempData.getTemp_認定調査員コード();
        this.temp_基準日 = tempData.getTemp_基準日();
        this.temp_認定調査督促期限日数 = tempData.getTemp_認定調査督促期限日数();
        this.temp_要介護認定調査督促状 = tempData.getTemp_要介護認定調査督促状();
        this.temp_認定調査督促対象者一覧表 = tempData.getTemp_認定調査督促対象者一覧表();
        this.temp_CSV出力 = tempData.getTemp_CSV出力();
        this.temp_印刷済対象者 = tempData.getTemp_印刷済対象者();
        this.temp_発行履歴 = tempData.getTemp_発行履歴();
        this.temp_督促方法 = tempData.getTemp_督促方法();
        this.temp_督促メモ = tempData.getTemp_督促メモ();
        this.temp_督促日 = tempData.getTemp_督促日();
        this.temp_印刷期間開始日 = tempData.getTemp_印刷期間開始日();
        this.temp_印刷期間終了日 = tempData.getTemp_印刷期間終了日();
    }

    /**
     * 要介護認定調査督促状作成のパラメータを作成します。
     *
     * @return 要介護認定調査督促状作成のパラメータ
     */
    public NinteiChosaTokusokujoProcessParameter toNinteiChosaTokusokujoProcessParameter() {
        NinteiChosaTokusokujoProcessParameter param = new NinteiChosaTokusokujoProcessParameter();
        param.setTemp_保険者コード(this.temp_保険者コード);
        param.setTemp_認定調査委託先コード(this.temp_認定調査委託先コード);
        param.setTemp_認定調査員コード(this.temp_認定調査員コード);
        param.setTemp_基準日(this.temp_基準日);
        param.setTemp_認定調査督促期限日数(this.temp_認定調査督促期限日数);
        param.setTemp_印刷済対象者(this.temp_印刷済対象者);
        param.setTemp_督促日(this.temp_督促日);
        param.setTemp_督促方法(new RString(this.temp_督促方法));
        param.setTemp_督促メモ(this.temp_督促メモ);

        return param;
    }

    /**
     * 認定調査督促対象者一覧表作成のパラメータを作成します。
     *
     * @return 認定調査督促対象者一覧表作成のパラメータ
     */
    public NinteiChosaTokusokuTaishoshaIchiranhyoProcessParameter toNinteiChosaTokusokuTaishoshaIchiranhyoProcessParameter() {
        NinteiChosaTokusokuTaishoshaIchiranhyoProcessParameter param = new NinteiChosaTokusokuTaishoshaIchiranhyoProcessParameter();
        param.setTemp_保険者コード(this.temp_保険者コード);
        param.setTemp_保険者名称(this.temp_保険者名称);
        param.setTemp_認定調査委託先コード(this.temp_認定調査委託先コード);
        param.setTemp_認定調査員コード(this.temp_認定調査員コード);
        param.setTemp_基準日(this.temp_基準日);
        param.setTemp_認定調査督促期限日数(this.temp_認定調査督促期限日数);
        param.setTemp_印刷済対象者(this.temp_印刷済対象者);
        param.setTemp_印刷期間開始日(this.temp_印刷期間開始日);
        param.setTemp_印刷期間終了日(this.temp_印刷期間終了日);
        param.setCsv出力_選択された(new RString("1").equals(this.temp_CSV出力));

        return param;
    }
}
