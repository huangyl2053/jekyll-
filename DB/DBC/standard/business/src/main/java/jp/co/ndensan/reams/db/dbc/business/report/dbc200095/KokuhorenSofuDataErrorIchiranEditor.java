/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200095;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc200095.KokuhorenSofuDataErrorIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc200095.KokuhorenSofuDataErrorIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 帳票設計_DBCMNF1001_1_国保連送付データエラーリストBodyEditor
 *
 * @reamsid_L DBC-2720-060 jiangxiaolong
 */
public class KokuhorenSofuDataErrorIchiranEditor
        implements IKokuhorenSofuDataErrorIchiranEditor {

    private final KokuhorenSofuDataErrorIchiranEntity entity;
    private final RString 市町村コード;
    private final RString 市町村名称;
    private static final RString SAKUSEI = new RString("作成");

    /**
     * コンストラクタです
     *
     * @param entity KokuhorenSofuDataErrorIchiranEntity
     * @param 市町村コード RString
     * @param 市町村名称 RString
     */
    public KokuhorenSofuDataErrorIchiranEditor(
            KokuhorenSofuDataErrorIchiranEntity entity, RString 市町村コード, RString 市町村名称) {
        this.entity = entity;
        this.市町村コード = 市町村コード;
        this.市町村名称 = 市町村名称;
    }

    @Override
    public KokuhorenSofuDataErrorIchiranSource edit(
            KokuhorenSofuDataErrorIchiranSource source) {
        if (null == entity) {
            return source;
        }
        editSource(source);
        return source;
    }

    private void editSource(KokuhorenSofuDataErrorIchiranSource source) {
        RDateTime 作成日時 = RDateTime.now();
        RString 作成日 = 作成日時.getDate().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 作成時 = 作成日時.getTime()
                .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).concat(RString.HALF_SPACE).concat(SAKUSEI);
        source.printTimeStamp = 作成日.concat(RString.HALF_SPACE).concat(作成時);
        source.cityCd = this.市町村コード;
        source.cityMei = this.市町村名称;
        source.listList2_1 = getColumnValue(entity.get被保険者番号());
        source.listList2_2 = entity.get氏名カナ();
        source.listList2_3 = entity.get氏名();
        source.listList2_4 = getパターン4(entity.get資格取得日());
        source.listList2_5 = entity.get認定要介護度();
        source.listList2_6 = getパターン4(entity.get認定申請日());
        source.listList2_7 = entity.get居宅事業者番号();
        source.listList2_8 = getパターン4(entity.get特定申請日());
        source.listList2_9 = getパターン4(entity.get特定開始日());
        source.listList2_10 = getパターン4(entity.get特定終了日());
        source.listList2_11 = getパターン4(entity.get社福開始日());
        source.listList2_12 = getパターン4(entity.get社福終了日());
        source.listList2_13 = getパターン4(entity.get償還開始日());
        source.listList3_1 = entity.getエラー情報コード();
        source.listList3_2 = entity.getエラー情報内容();
        source.listList3_3 = getパターン4(entity.get資格喪失日());
        source.listList3_4 = getパターン4(entity.get認定開始日());
        source.listList3_5 = getパターン4(entity.get認定終了日());
        source.listList3_6 = getパターン4(entity.get居宅開始日());
        source.listList3_7 = getパターン4(entity.get利用申請日());
        source.listList3_8 = getパターン4(entity.get利用開始日());
        source.listList3_9 = getパターン4(entity.get利用終了日());
        source.listList3_10 = getパターン4(entity.get標準開始日());
        source.listList3_11 = getパターン4(entity.get標準終了日());
        source.listList3_12 = getパターン4(entity.get引下開始日());
        source.shoriYm = getパターン12(entity.get処理年月());
    }

    private static RString getパターン4(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return date.wareki().eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD)
                .fillType(FillType.BLANK).toDateString();
    }

    private static RString getパターン12(FlexibleYearMonth date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return date.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString();
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }
}
