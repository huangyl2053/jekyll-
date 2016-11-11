/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufusaishinsamoshitateshojohosofuichiran;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsamoshitateshoout.SaishinsaMoshitateIchiranhyoTaisyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kyufusaishinsamoshitateshojohosofuichiran.KyufuSaishinsaMoshitateshojohoSofuIchiranSource;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBCCodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 帳票設計_DBC200047_給付再審査申立書情報送付一覧表 BodyEditorクラスです。
 *
 * @reamsid_L DBC-2540-040 lijian
 */
public class KyufuSaishinsaMoshitateshojohoSofuIchiranBodyEditor implements IKyufuSaishinsaMoshitateshojohoSofuIchiranEditor {

    private final SaishinsaMoshitateIchiranhyoTaisyoEntity 送付一覧表データ;
    private static final RString 合計件数タイトル = new RString("合計件数");
    private static final RString 件数 = new RString("件");
    private static final RString 被保険者番号 = new RString("被保険者番号");
    private static final int NUM_ZERO = 0;
    private static final int NUM_TWO = 2;
    private static final int LENGTH_ZERO = 0;
    private static final int LENGTH_TWENTY = 20;
    private static final int LENGTH_FORTY = 40;
    private static final int LENGTH_FOURTEEN = 14;
    private static final int LENGTH_TWENTYEIGHT = 28;
    private final int 連番;
    private final boolean 合計フラグ;
    private final Decimal 合計件数;

    /**
     * @param 送付一覧表データ SaishinsaMoshitateIchiranhyoTaisyoEntity
     * @param 連番 int
     * @param 合計フラグ boolean
     * @param 合計件数 Decimal
     */
    public KyufuSaishinsaMoshitateshojohoSofuIchiranBodyEditor(
            SaishinsaMoshitateIchiranhyoTaisyoEntity 送付一覧表データ,
            int 連番,
            boolean 合計フラグ,
            Decimal 合計件数) {

        this.送付一覧表データ = 送付一覧表データ;
        this.連番 = 連番;
        this.合計フラグ = 合計フラグ;
        this.合計件数 = 合計件数;
    }

    @Override
    public KyufuSaishinsaMoshitateshojohoSofuIchiranSource edit(KyufuSaishinsaMoshitateshojohoSofuIchiranSource source) {

        if (送付一覧表データ.get被保険者_識別コード() != null) {
            source.shikibetsuCode = 送付一覧表データ.get被保険者_識別コード().value();
        }

        source.listUpper_1 = new RString(連番);
        if (送付一覧表データ.get再審査申立_事業所番号() != null) {
            source.listUpper_2 = 送付一覧表データ.get再審査申立_事業所番号().value();
        }

        RString 事業者名 = 送付一覧表データ.get再審査申立_事業者名();

        if (事業者名.length() <= LENGTH_TWENTY) {
            source.listUpper_3 = 事業者名;
            source.listLower_1 = RString.EMPTY;
        } else if (LENGTH_TWENTY < 事業者名.length() && 事業者名.length() <= LENGTH_FORTY) {
            source.listUpper_3 = 事業者名.substring(LENGTH_ZERO, LENGTH_TWENTY);
            source.listLower_1 = 事業者名.substring(LENGTH_TWENTY, 事業者名.length());
        } else {
            source.listUpper_3 = 事業者名.substring(LENGTH_ZERO, LENGTH_TWENTY);
            source.listLower_1 = 事業者名.substring(LENGTH_TWENTY, LENGTH_FORTY);
        }

        RString サービス名称 = 送付一覧表データ.get再審査申立_サービス名称();

        if (サービス名称.length() <= LENGTH_FOURTEEN) {
            source.listUpper_8 = サービス名称;
            source.listLower_3 = RString.EMPTY;
        } else if (LENGTH_FOURTEEN < サービス名称.length() && サービス名称.length() <= LENGTH_TWENTYEIGHT) {
            source.listUpper_8 = サービス名称.substring(LENGTH_ZERO, LENGTH_FOURTEEN);
            source.listLower_3 = サービス名称.substring(LENGTH_FOURTEEN, サービス名称.length());
        } else {
            source.listUpper_8 = サービス名称.substring(LENGTH_ZERO, LENGTH_FOURTEEN);
            source.listLower_3 = サービス名称.substring(LENGTH_FOURTEEN, LENGTH_TWENTYEIGHT);
        }

        if (送付一覧表データ.get再審査申立_被保険者番号() != null) {
            source.listUpper_4 = 送付一覧表データ.get再審査申立_被保険者番号().value();
            source.expandedInformation = new ExpandedInformation(new Code("0003"), 被保険者番号,
                    source.listUpper_4);
        }
        source.listUpper_5 = 送付一覧表データ.get被保険者_宛名カナ名称();
        source.listUpper_6 = 送付一覧表データ.get再審査申立_サービス提供年月().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();

        ServiceShuruiCode サービス種類コード = 送付一覧表データ.get再審査申立_サービス種類コード();
        ServiceKomokuCode サービス項目コード = 送付一覧表データ.get再審査申立_サービス項目コード();
        source.listUpper_7 = new RString(new StringBuilder(サービス種類コード == null ? RString.EMPTY : サービス種類コード.value())
                .append(サービス項目コード == null ? RString.EMPTY : サービス項目コード.value()).toString());

        source.listUpper_9 = get年月日(送付一覧表データ.get再審査申立_申立年月日());
        source.listUpper_10 = doカンマ編集(new Decimal(送付一覧表データ.get再審査申立_申立単位数()));
        RString 申立事由コード = 送付一覧表データ.get再審査申立_申立事由コード();
        source.listUpper_11 = 申立事由コード;
        if (申立事由コード != null) {
            source.listUpper_12 = CodeMaster.getCodeMeisho(SubGyomuCode.DBC介護給付,
                    DBCCodeShubetsu.再審査申立事由コード_上２桁_申立対象項目コード.getコード(),
                    new Code(申立事由コード.substringEmptyOnError(NUM_ZERO, NUM_TWO)));

            source.listLower_4 = CodeMaster.getCodeMeisho(SubGyomuCode.DBC介護給付,
                    DBCCodeShubetsu.再審査申立事由コード_下２桁_申立理由番号.getコード(),
                    new Code(申立事由コード.substringEmptyOnError(申立事由コード.length() - NUM_TWO, 申立事由コード.length())));
        }

        source.listLower_2 = 送付一覧表データ.get被保険者_宛名名称();

        if (合計フラグ) {
            source.gokeiKensuTitle = 合計件数タイトル;
            source.gokeiKensu = doカンマ編集(合計件数).concat(件数);
        }

        return source;
    }

    private RString get年月日(FlexibleDate date) {
        if (date != null) {
            return date.wareki().eraType(EraType.KANJI_RYAKU)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        }
        return RString.EMPTY;
    }

    private RString doカンマ編集(Decimal decimal) {
        if (null != decimal) {
            return DecimalFormatter.toコンマ区切りRString(decimal, 0);
        }
        return RString.EMPTY;
    }

}
