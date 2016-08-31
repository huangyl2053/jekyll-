/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.servicenokanribangourendou;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 決定通知書用のEntityクラスです。
 *
 * @reamsid_L DBC-4760-050 cuilin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyouKetteiTutisyoEntity {

    private RString 郵便番号;
    private RString 行政区;
    private RString 住所１;
    private RString 住所２;
    private RString 住所３;
    private RString 住所;
    private RString 方書１;
    private RString 方書２;
    private RString 方書小1;
    private RString 方書小2;
    private RString 方書;
    private RString 氏名1;
    private RString 氏名2;
    private RString 小氏名1;
    private RString 小氏名2;
    private RString 氏名;
    private RString 名称付与1;
    private RString 名称付与2;
    private RString 代納区分名;
    private RString 様文1;
    private RString 様文2;
    private RString 様文氏名1;
    private RString 様文氏名2;
    private RString 小様文氏名1;
    private RString 小様文氏名2;
    private RString 様文氏名;
    private RString 左括弧1;
    private RString 左括弧2;
    private RString 右括弧1;
    private RString 右括弧2;
    private RString カスタマバーコード;
    private RString 文書番号;
    private RString 作成年月日;
    private RString 電子公印;
    private RString 発行日付;
    private RString 公印文字列;
    private RString 公印書略;
    private RString 認証者公印掛けない;
    private RString 認証者公印掛ける;
    private RString 認証者役職名;
    private RString 認証者役職名1;
    private RString 認証者役職名2;
    private RString ﾀｲﾄﾙ;
    private RString ﾀｲﾄﾙ_2_1_取消し線用;
    private RString ﾀｲﾄﾙ_2_2_1_取消し線用;
    private RString ﾀｲﾄﾙ_2_2_2_取消し線用;
    private RString ﾀｲﾄﾙ_2_3_1_取消し線用;
    private RString ﾀｲﾄﾙ_2_3_2_取消し線用;
    private RString ﾀｲﾄﾙ_2_4_取消し線用;
    private RString ﾀｲﾄﾙ_3_1_取消し線用_調整用;
    private RString ﾀｲﾄﾙ_3_2_1_取消し線用_調整用;
    private RString ﾀｲﾄﾙ_3_2_2_取消し線用_調整用;
    private RString ﾀｲﾄﾙ_3_3_1_取消し線用_調整用;
    private RString ﾀｲﾄﾙ_3_3_2_取消し線用_調整用;
    private RString ﾀｲﾄﾙ_3_4_取消し線用_調整用;
    private RString 被保険者氏名;
    private RString 被保険者番号１;
    private RString 被保険者番号２;
    private RString 被保険者番号３;
    private RString 被保険者番号４;
    private RString 被保険者番号５;
    private RString 被保険者番号６;
    private RString 被保険者番号７;
    private RString 被保険者番号８;
    private RString 被保険者番号９;
    private RString 被保険者番号１０;
    private RString 受付年月日;
    private RString 決定年月日;
    private RString 本人支払額;
    private RString 対象年月;
    private RString 給付の種類１;
    private RString 給付の種類２;
    private RString 給付の種類３;
    private RString 支給;
    private RString 支給金額ﾀｲﾄﾙ;
    private RString 支給金額;
    private RString 理由ﾀｲﾄﾙ;
    private RString 理由１;
    private RString 理由２;
    private RString 理由３;
    private RString 取消１;
    private RString 取消２;
    private RString 持物１;
    private RString 持物２;
    private RString 持物３;
    private RString 支払場所;
    private RString 支払期間開始年月日;
    private RString 支払期間終了年月日;
    private RString 支払期間開始時間;
    private RString 支払期間_２;
    private RString 支払期間終了時間;
    private RString 金融機関名;
    private RString 金融機関支店名;
    private RString 種目ﾀｲﾄﾙ;
    private RString 口座種別;
    private RString 番号ﾀｲﾄﾙ;
    private RString 口座番号;
    private RString 口座名義人;
    private RString 支払予定日;
    private RString 通知文1;
    private RString 文言1;
    private RString 文言2;
    private TsuchishoNo 通知書番号;
    private RString 連番;
    private RString 持ち物1_取り消し用;
    private RString 持ち物2_取り消し用;
    private RString 支払場所_取り消し用;
    private RString 支払期間_取り消し用;
    private RString 通知文2大;
    private RString 通知文3_上小;
    private RString 通知文4_下大;
    private RString 通知文5_上大;
    private RString 通知文6_下小;
}
