/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.shokanbaraishikyukettei;

import jp.co.ndensan.reams.db.dbc.definition.core.shiharaihoho.ShiharaiHohoKubun;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin.DbWT3036ShokanHanteiKekkaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin.ShokanShikyuKetteiChohyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.shokanbaraishikyuketteishaichiran.ShokanbaraiShikyuKetteishaIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 償還払支給決定者一覧表帳票BodyEditor
 *
 * @reamsid_L DBC-0980-480 sunhui
 */
public class ShokanbaraiShikyuKetteishaIchiranBodyEditor implements IShokanbaraiShikyuKetteishaIchiranEditor {

    private final ShokanShikyuKetteiChohyoEntity 帳票出力対象データ;
    private RString 編集住所;

    private static final int 文字20 = 20;

    private static final RString コロン = new RString("：");
    private static final RString アスタリスク = new RString("*");
    private static final RString 更新DB有無_有 = new RString("1");

    private static final CodeShubetsu 介護資格喪失事由_被保険者 = new CodeShubetsu("0010");

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象データ ShokanShikyuKetteiChohyoEntity
     * @param 編集住所 RString
     */
    public ShokanbaraiShikyuKetteishaIchiranBodyEditor(ShokanShikyuKetteiChohyoEntity 帳票出力対象データ,
            RString 編集住所) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.編集住所 = 編集住所;
    }

    @Override
    public ShokanbaraiShikyuKetteishaIchiranSource edit(ShokanbaraiShikyuKetteishaIchiranSource source) {
        DbWT0001HihokenshaTempEntity 被保険者 = 帳票出力対象データ.get被保険者();
        DbWT3036ShokanHanteiKekkaTempEntity 判定結果 = 帳票出力対象データ.get判定結果();
        source.listUpper_1 = 判定結果.getNo();
        if (null != 被保険者.get登録被保険者番号()) {
            source.listUpper_2 = 被保険者.get登録被保険者番号().getColumnValue();
        }
        source.listUpper_3 = 被保険者.get宛名名称();
        if (null != 判定結果.get事業所番号()) {
            source.listUpper_4 = 判定結果.get事業所番号().getColumnValue();
        }
        source.listUpper_5 = 判定結果.get事業所名();
        if (null != 判定結果.getサービス提供年月()) {
            source.listUpper_6 = 判定結果.getサービス提供年月().wareki()
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        }
        source.listUpper_7 = doカンマ編集(判定結果.get単位数_金額());
        source.listUpper_8 = doカンマ編集(判定結果.get支払金額());
        if (null != 被保険者.get資格喪失事由コード()) {
            source.listUpper_9 = CodeMaster.getCodeMeisho(介護資格喪失事由_被保険者,
                    new Code(被保険者.get資格喪失事由コード()));
        }
        source.listUpper_10 = 判定結果.get備考1();
        source.listLower_1 = 判定結果.get整理番号();
        source.listLower_2 = 被保険者.get町域コード();
        if (null != 編集住所) {
            source.listLower_3 = 編集住所.substringReturnAsPossible(0, 文字20);
        }
        source.listLower_4 = 被保険者.get行政区コード();
        source.listLower_5 = 被保険者.get行政区名();
        RString サービス種類コード = RString.EMPTY;
        if (null != 判定結果.getサービス種類コード()) {
            サービス種類コード = 判定結果.getサービス種類コード().getColumnValue();
        }
        RString サービス種類名 = (null == 判定結果.getサービス種類名()) ? RString.EMPTY : 判定結果.getサービス種類名();
        source.listLower_6 = サービス種類コード.concat(コロン).concat(サービス種類名);
        source.listLower_7 = doカンマ編集(判定結果.get増減単位数());
        RString 支払方法区分コード = 判定結果.get支払方法区分コード();
        if (!RString.isNullOrEmpty(支払方法区分コード)) {
            ShiharaiHohoKubun 支払方法区分 = ShiharaiHohoKubun.toValue(支払方法区分コード);
            source.listLower_8 = 支払方法区分コード.concat(コロン).concat(支払方法区分.get名称());
        }
        if (null != 被保険者.get資格喪失日()) {
            source.listLower_9 = 被保険者.get資格喪失日().wareki().eraType(EraType.KANJI_RYAKU)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        }
        if (更新DB有無_有.equals(判定結果.get更新DB有無())) {
            source.listDBKoshinUmu_1 = アスタリスク;
        } else {
            source.listDBKoshinUmu_1 = RString.EMPTY;
        }
        return source;
    }

    private RString doカンマ編集(Decimal number) {
        if (null == number) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(number, 0);
    }

}
