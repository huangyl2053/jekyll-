/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kogakugassanshikyuketteitsuchisho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ua.uax.business.core.kinyukikan.KinyuKikan;
import jp.co.ndensan.reams.ua.uax.business.core.kinyukikan.KinyuKikanShiten;
import jp.co.ndensan.reams.ua.uax.business.core.koza.YokinShubetsuPattern;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 高額合算支給決定通知書Entityラクラスです。
 *
 * @reamsid_L DBC-2300-030 xuhao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakugassanShikyuKetteitsuchisho {

    private RString 郵便番号;
    private RString 行政区;
    private RString 住所Text;
    private RString 住所1;
    private RString 住所2;
    private RString 住所3;
    private RString 方書Text;
    private RString 方書1;
    private RString 方書2;
    private RString 方書Small1;
    private RString 方書Small2;
    private RString 代納人区分;
    private RString 氏名Text;
    private RString 氏名1;
    private RString 氏名2;
    private RString 氏名Small1;
    private RString 氏名Small2;
    private RString 氏名samabunText;
    private RString 氏名samabun1;
    private RString 氏名samabun2;
    private RString 氏名samabunSmall1;
    private RString 氏名samabunSmall2;
    private RString 名称付与1;
    private RString 名称付与2;
    private RString 様文1;
    private RString 様文2;
    private RString 括弧Left1;
    private RString 括弧Left2;
    private RString 括弧Right1;
    private RString 括弧Right2;
    private RString カスタマバーコード;
    private RString 文書番号;
    private FlexibleDate 発行日;
    private RString タイトル;
    private RString タイトル21;
    private RString タイトル221;
    private RString タイトル222;
    private RString タイトル231;
    private RString タイトル232;
    private RString タイトル24;
    private RString 文書1;
    private RString 被保険者氏名;
    private HihokenshaNo 被保険者番号;
    private FlexibleDate 対象計算期間開始年月日;
    private FlexibleDate 対象計算期間終了年月日;
    private FlexibleDate 申請年月日;
    private FlexibleDate 決定年月日;
    private Decimal 計算対象期間中の自己負担額合計額;
    private RString 支給額タイトル;
    private Decimal 支給額;
    private Decimal 自己負担総額;
    private RString 支給区分コード;
    private RString 給付の種類;
    private RString 備考;
    private RString 不支給の理由;
    private RString 支給方法区分;
    private RString 支払場所;
    private FlexibleDate 支払期間開始年月日;
    private FlexibleDate 支払期間終了年月日;
    private RString 支払期間開始時間;
    private RString 支払期間終了時間;
    private KinyuKikan 金融機関名称;
    private KinyuKikanShiten 支店名称;
    private KinyuKikanCode 金融機関コード;
    private KinyuKikanShitenCode 支店コード;
    private YokinShubetsuPattern 預金種別;
    private RString 口座番号;
    private AtenaKanaMeisho 口座名義人;
    private FlexibleDate 支払予定日;
    private RString 文書2;
    private RString 文書3;
    private RString 文書4;
    private RString 文書5;
    private RString 文書6;
    private RString 文書7;
    private RString 通知書番号;
    private int 通番;
}
