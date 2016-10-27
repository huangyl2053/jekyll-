/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuiraijohoichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokubetsuchoshuiraijohoichiran.TokubetsuChoshuIraiJohoIchiranEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.source.tokubetsuchoshuiraijohoichiran.TokubetsuChoshuIraiJohoIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 帳票設計_DBBPR82001_1_特別徴収依頼情報一覧表
 *
 * @reamsid_L DBB-1840-060 chenyadong
 */
public class TokubetsuChoshuIraiJohoIchiranHeaderEditor implements ITokubetsuChoshuIraiJohoIchiranEditor {

    private final TokubetsuChoshuIraiJohoIchiranEntity 帳票出力対象データ;
    private final List<RString> 出力順;
    private final List<RString> 改頁項目;
    private final RDateTime 作成日時;

    private static final int INDEX_1 = 0;
    private static final int INDEX_2 = 1;
    private static final int INDEX_3 = 2;
    private static final int INDEX_4 = 3;
    private static final int INDEX_5 = 4;

    private static final RString SAKUSEI = new RString("作成");

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象データ ShokanFushikyuKetteiInEntity
     * @param 出力順 List<RString>
     * @param 改頁項目 List<RString>
     * @param 作成日時 RDateTime
     */
    protected TokubetsuChoshuIraiJohoIchiranHeaderEditor(
            TokubetsuChoshuIraiJohoIchiranEntity 帳票出力対象データ,
            List<RString> 出力順,
            List<RString> 改頁項目,
            RDateTime 作成日時) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.出力順 = 出力順;
        this.改頁項目 = 改頁項目;
        this.作成日時 = 作成日時;
    }

    @Override
    public TokubetsuChoshuIraiJohoIchiranSource edit(TokubetsuChoshuIraiJohoIchiranSource source) {
        RString 作成日 = 作成日時.getDate().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 作成時 = 作成日時.getTime()
                .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).concat(RString.HALF_SPACE).concat(SAKUSEI);
        source.printTimeStamp = 作成日.concat(RString.HALF_SPACE).concat(作成時);
        source.nenkinHokenshaName = 帳票出力対象データ.get年金保険者名称();
        source.shichosonCode = 帳票出力対象データ.get市町村コード();
        source.shichosonName = 帳票出力対象データ.get市町村名称();
        source.hokenshaNo = 帳票出力対象データ.get保険者番号();
        source.hokenshaName = 帳票出力対象データ.get保険者名称();
        source.shutsuryokujun1 = get並び順(INDEX_1);
        source.shutsuryokujun2 = get並び順(INDEX_2);
        source.shutsuryokujun3 = get並び順(INDEX_3);
        source.shutsuryokujun4 = get並び順(INDEX_4);
        source.shutsuryokujun5 = get並び順(INDEX_5);
        source.kaipage1 = get改頁(INDEX_1);
        source.kaipage2 = get改頁(INDEX_2);
        source.kaipage3 = get改頁(INDEX_3);
        source.kaipage4 = get改頁(INDEX_4);
        source.kaipage5 = get改頁(INDEX_5);

        return source;
    }

    private RString get並び順(int index) {
        return 出力順.size() > index ? 出力順.get(index) : RString.EMPTY;
    }

    private RString get改頁(int index) {
        return 改頁項目.size() > index ? 改頁項目.get(index) : RString.EMPTY;
    }
}
