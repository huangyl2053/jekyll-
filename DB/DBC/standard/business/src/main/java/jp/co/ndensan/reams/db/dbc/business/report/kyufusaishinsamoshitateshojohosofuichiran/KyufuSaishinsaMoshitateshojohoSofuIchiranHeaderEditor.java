/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufusaishinsamoshitateshojohosofuichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsamoshitateshoout.SaishinsaMoshitateIchiranhyoTaisyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kyufusaishinsamoshitateshojohosofuichiran.KyufuSaishinsaMoshitateshojohoSofuIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.lang.Width;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 帳票設計_DBC200047_給付再審査申立書情報送付一覧表 HeaderEditorクラスです。
 *
 * @reamsid_L DBC-2540-040 lijian
 */
public class KyufuSaishinsaMoshitateshojohoSofuIchiranHeaderEditor implements IKyufuSaishinsaMoshitateshojohoSofuIchiranEditor {

    private static final RString 日時作成 = new RString("作成");
    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;
    private final SaishinsaMoshitateIchiranhyoTaisyoEntity 送付一覧表データ;
    private final List<RString> 出力順リスト;
    private final List<RString> 改頁リスト;
    private final FlexibleYearMonth 処理年月;
    private final RDateTime 作成日時;

    /**
     * @param 送付一覧表データ SaishinsaMoshitateIchiranhyoTaisyoEntity
     * @param 出力順リスト List<RString>
     * @param 改頁リスト List<RString>
     * @param 処理年月 FlexibleYearMonth
     * @param 作成日時 RDateTime
     */
    public KyufuSaishinsaMoshitateshojohoSofuIchiranHeaderEditor(
            SaishinsaMoshitateIchiranhyoTaisyoEntity 送付一覧表データ,
            List<RString> 出力順リスト,
            List<RString> 改頁リスト,
            FlexibleYearMonth 処理年月,
            RDateTime 作成日時) {
        this.送付一覧表データ = 送付一覧表データ;
        this.出力順リスト = 出力順リスト;
        this.改頁リスト = 改頁リスト;
        this.処理年月 = 処理年月;
        this.作成日時 = 作成日時;
    }

    @Override
    public KyufuSaishinsaMoshitateshojohoSofuIchiranSource edit(KyufuSaishinsaMoshitateshojohoSofuIchiranSource source) {

        source.printTimeStamp = get印刷日時(作成日時);

        if (処理年月 != null) {
            source.sofuYM = 処理年月.wareki().eraType(EraType.KANJI_RYAKU).
                    firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        if (送付一覧表データ.get再審査申立_保険者番号() != null) {
            source.hokenshaNo = 送付一覧表データ.get再審査申立_保険者番号().value();
        }
        source.hokenshaName = 送付一覧表データ.get再審査申立_保険者名();
        if (送付一覧表データ.get再審査申立_証記載保険者番号() != null) {
            source.shoKisaiHokenshaNo = 送付一覧表データ.get再審査申立_証記載保険者番号().value();
        }
        source.shoKisaiHokenshaName = 送付一覧表データ.get再審査申立_証記載保険者名();

        set並び順(source);
        set改頁(source);

        return source;
    }

    private void set並び順(KyufuSaishinsaMoshitateshojohoSofuIchiranSource source) {
        source.shutsuryokujun1 = get並び順(INDEX_0);
        source.shutsuryokujun2 = get並び順(INDEX_1);
        source.shutsuryokujun3 = get並び順(INDEX_2);
        source.shutsuryokujun4 = get並び順(INDEX_3);
        source.shutsuryokujun5 = get並び順(INDEX_4);
    }

    private void set改頁(KyufuSaishinsaMoshitateshojohoSofuIchiranSource source) {
        source.kaipage1 = get改頁(INDEX_1);
        source.kaipage2 = get改頁(INDEX_2);
        source.kaipage3 = get改頁(INDEX_3);
        source.kaipage4 = get改頁(INDEX_4);
        source.kaipage5 = get改頁(INDEX_5);
    }

    private RString get並び順(int index) {
        return index < 出力順リスト.size() ? 出力順リスト.get(index) : RString.EMPTY;
    }

    private RString get改頁(int index) {
        return index < 改頁リスト.size() ? 改頁リスト.get(index) : RString.EMPTY;
    }

    private RString get印刷日時(RDateTime datetime) {

        RStringBuilder sakuseiYMD = new RStringBuilder();

        sakuseiYMD.append(datetime.getDate().wareki().
                eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.NONE).
                width(Width.HALF).toDateString());
        sakuseiYMD.append(RString.HALF_SPACE);
        sakuseiYMD.append(datetime.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒));
        sakuseiYMD.append(RString.HALF_SPACE);
        sakuseiYMD.append(日時作成);
        return sakuseiYMD.toRString();
    }

}
