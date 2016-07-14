/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakushikyufushikyuketteishaichiran;

import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT3058KogakuShikyuShinsaKetteiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufukettei.KogakuKyufuKetteiChohyoDataEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakukyufukettei.KogakuShikyuFushikyuKetteishaIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 高額サービス費支給（不支給）決定者一覧表帳票BodyEditor
 *
 * @reamsid_L DBC-0980-500 surun
 */
public class KogakuShikyuFushikyuKetteishaIchiranBodyEditor implements IKogakuShikyuFushikyuKetteishaIchiranEditor {

    private final KogakuKyufuKetteiChohyoDataEntity 帳票出力対象データ;
    private RString 編集住所;

    private static final int 文字15 = 15;
    private static final int 文字22 = 22;
    private static final int 文字30 = 30;
    private static final int 文字40 = 40;
    private static final RString 支給区分コード_可 = new RString("1");
    private static final RString 支給区分_可 = new RString("可");
    private static final RString 支給区分_不可 = new RString("不可");
    private static final RString 支払方法区分コード_窓口 = new RString("1");
    private static final RString 支払方法区分_窓口 = new RString("窓口");
    private static final RString 支払方法区分_口座 = new RString("口座");

    private static final CodeShubetsu 介護資格喪失事由_被保険者 = new CodeShubetsu("0010");

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象データ KogakuKyufuKetteiChohyoDataEntity
     * @param 編集住所 RString
     */
    public KogakuShikyuFushikyuKetteishaIchiranBodyEditor(KogakuKyufuKetteiChohyoDataEntity 帳票出力対象データ,
            RString 編集住所) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.編集住所 = 編集住所;
    }

    @Override
    public KogakuShikyuFushikyuKetteishaIchiranSource edit(KogakuShikyuFushikyuKetteishaIchiranSource source) {
        DbWT0001HihokenshaTempEntity 被保険者 = 帳票出力対象データ.getHihokenshaTemp();
        DbWT3058KogakuShikyuShinsaKetteiTempEntity 審査決定 = 帳票出力対象データ.getKetteiTemp();
        source.listUpper_1 = 審査決定.getNo();
        if (null != 被保険者.get宛名カナ名称()) {
            source.listUpper_2 = 被保険者.get宛名カナ名称().substringReturnAsPossible(0, 文字40);
        }
        if (null != 審査決定.getサービス提供年月()) {
            source.listUpper_3 = 審査決定.getサービス提供年月().wareki()
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        }
        if (支給区分コード_可.equals(審査決定.get支給区分コード())) {
            source.listUpper_4 = 支給区分_可;
        } else {
            source.listUpper_4 = 支給区分_不可;
        }
        if (null != 審査決定.get利用者負担額()) {
            source.listUpper_5 = DecimalFormatter.toコンマ区切りRString(審査決定.get利用者負担額(), 0);
        }
        if (null != 被保険者.get資格喪失事由コード()) {
            source.listUpper_6 = CodeMaster.getCodeMeisho(介護資格喪失事由_被保険者,
                    new Code(被保険者.get資格喪失事由コード()));
        }
        source.listUpper_7 = 被保険者.get町域コード();
        source.listUpper_8 = 被保険者.get郵便番号();
        編集住所 = 編集住所.substringReturnAsPossible(0, 文字30);
        source.listUpper_9 = 編集住所.substringReturnAsPossible(0, 文字15);
        source.listLower_8 = 編集住所.substringReturnAsPossible(文字15);
        source.listUpper_10 = 被保険者.get行政区名();
        if (null != 被保険者.get登録被保険者番号()) {
            source.listLower_1 = 被保険者.get登録被保険者番号().getColumnValue();
        }
        if (null != 被保険者.get宛名名称()) {
            source.listLower_2 = 被保険者.get宛名名称().substringReturnAsPossible(0, 文字22);
        }
        if (null != 審査決定.get決定年月()) {
            source.listLower_3 = 審査決定.get決定年月().wareki()
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        }
        if (支払方法区分コード_窓口.equals(審査決定.get支払方法区分コード())) {
            source.listLower_4 = 支払方法区分_窓口;
        } else {
            source.listLower_4 = 支払方法区分_口座;
        }
        if (null != 審査決定.get高額支給額()) {
            source.listLower_5 = DecimalFormatter.toコンマ区切りRString(審査決定.get高額支給額(), 0);
        }
        if (null != 被保険者.get資格喪失日()) {
            source.listLower_6 = 被保険者.get資格喪失日().wareki().eraType(EraType.KANJI_RYAKU)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        }
        source.listLower_7 = 被保険者.get行政区コード();
        source.listLower_9 = RString.EMPTY;
        return source;
    }
}
