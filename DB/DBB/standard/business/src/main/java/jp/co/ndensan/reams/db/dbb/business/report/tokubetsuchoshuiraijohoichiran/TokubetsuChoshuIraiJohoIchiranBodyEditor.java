/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuiraijohoichiran;

import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokubetsuchoshuiraijohoichiran.TokubetsuChoshuIraiJohoIchiranEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.source.tokubetsuchoshuiraijohoichiran.TokubetsuChoshuIraiJohoIchiranSource;
import jp.co.ndensan.reams.db.dbz.business.util.DateConverter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 帳票設計_DBBPR82001_1_特別徴収依頼情報一覧表
 *
 * @reamsid_L DBB-1840-060 chenyadongf
 */
public class TokubetsuChoshuIraiJohoIchiranBodyEditor implements ITokubetsuChoshuIraiJohoIchiranEditor {

    private final TokubetsuChoshuIraiJohoIchiranEntity 帳票出力対象データ;

    /**
     * コンストラクタです
     *
     *
     * @param 帳票出力対象データ ShokanFushikyuKetteiInEntity
     */
    protected TokubetsuChoshuIraiJohoIchiranBodyEditor(
            TokubetsuChoshuIraiJohoIchiranEntity 帳票出力対象データ) {
        this.帳票出力対象データ = 帳票出力対象データ;

    }

    @Override
    public TokubetsuChoshuIraiJohoIchiranSource edit(TokubetsuChoshuIraiJohoIchiranSource source) {
        if (!RString.isNullOrEmpty(帳票出力対象データ.get表示コード名称1())) {
            source.hyojicodeName1 = 帳票出力対象データ.get表示コード名称1();
        }
        if (!RString.isNullOrEmpty(帳票出力対象データ.get表示コード名称2())) {
            source.hyojicodeName2 = 帳票出力対象データ.get表示コード名称2();
        }
        if (!RString.isNullOrEmpty(帳票出力対象データ.get表示コード名称3())) {
            source.hyojicodeName3 = 帳票出力対象データ.get表示コード名称3();
        }
        if (!RString.isNullOrEmpty(帳票出力対象データ.get被保険者番号())) {
            source.listUpper_1 = 帳票出力対象データ.get被保険者番号();
        }
        if (!RString.isNullOrEmpty(帳票出力対象データ.get年金番号())) {
            source.listUpper_2 = 帳票出力対象データ.get年金番号();
        }
        if (!RString.isNullOrEmpty(帳票出力対象データ.getカナ氏名())) {
            source.listUpper_3 = 帳票出力対象データ.getカナ氏名();
        }
        if (!RString.isNullOrEmpty(帳票出力対象データ.get生年月日())) {
            source.listUpper_4 = DateConverter.toWarekiHalf_Zero(new RDate(帳票出力対象データ.get生年月日().toString()));
        }
        if (!RString.isNullOrEmpty(帳票出力対象データ.get行政区コード())) {
            source.listUpper_5 = 帳票出力対象データ.get行政区コード();
        }
        if (!RString.isNullOrEmpty(帳票出力対象データ.get表示コード1())) {
            source.listUpper_6 = 帳票出力対象データ.get表示コード1();
        }
        if (!RString.isNullOrEmpty(帳票出力対象データ.get表示コード2())) {
            source.listUpper_7 = 帳票出力対象データ.get表示コード2();
        }
        if (!RString.isNullOrEmpty(帳票出力対象データ.get表示コード3())) {
            source.listUpper_8 = 帳票出力対象データ.get表示コード3();
        }
        set金額(source);
        if (!RString.isNullOrEmpty(帳票出力対象データ.get識別コード())) {
            source.listLower_1 = 帳票出力対象データ.get識別コード();
        }
        if (!RString.isNullOrEmpty(帳票出力対象データ.get年金コード())) {
            source.listLower_2 = 帳票出力対象データ.get年金コード();
        }
        if (!RString.isNullOrEmpty(帳票出力対象データ.get漢字氏名())) {
            source.listLower_3 = 帳票出力対象データ.get漢字氏名();
        }
        if (!RString.isNullOrEmpty(帳票出力対象データ.get性別())) {
            source.listLower_4 = 帳票出力対象データ.get性別();
        }
        if (!RString.isNullOrEmpty(帳票出力対象データ.get郵便番号())) {
            source.listLower_5 = 帳票出力対象データ.get郵便番号();
        }
        if (!RString.isNullOrEmpty(帳票出力対象データ.get住所())) {
            source.listLower_6 = 帳票出力対象データ.get住所();
        }
        return source;
    }

    private void set金額(TokubetsuChoshuIraiJohoIchiranSource source) {
        if (!RString.isNullOrEmpty(帳票出力対象データ.get金額1())) {
            source.listUpper_9 = DecimalFormatter.toコンマ区切りRString(new Decimal(帳票出力対象データ.get金額1().
                    toString()), 0);
        }
        if (!RString.isNullOrEmpty(帳票出力対象データ.get金額2())) {
            source.listUpper_10 = DecimalFormatter.toコンマ区切りRString(new Decimal(帳票出力対象データ.get金額2().
                    toString()), 0);
        }
        if (!RString.isNullOrEmpty(帳票出力対象データ.get金額3())) {
            source.listUpper_11 = DecimalFormatter.toコンマ区切りRString(new Decimal(帳票出力対象データ.get金額3().
                    toString()), 0);
        }
    }
}
