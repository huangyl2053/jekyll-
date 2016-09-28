/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuservicejyuryokakuninsho;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票設計_DBC100031_高額サービス費受領委任契約承認（不承認）確認書 Entityのクラスです。
 *
 * @reamsid_L DBC-1980-040 qinzhen
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuServiceJyuryoKakuninShoEntity {

    private RString 郵便番号;
    private RString 行政区;
    private RString 住所Text;
    private RString 住所1;
    private RString 住所2;
    private RString 住所3;
    private RString 方書1;
    private RString 方書2;
    private RString 方書3;
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
    private RString 通知文１;
    private RString 被保険者氏名フリガナ;
    private RString 受付年月日;
    private RString 承認不承認;
    private RString 電子公印;
    private RString 発行日;
    private RString 認証者役職名;
    private RString 認証者役職名1;
    private RString 認証者役職名2;
    private RString 認証者氏名掛けない;
    private RString 認証者氏名掛ける;
    private RString 公印省略;
    private RString 公印文字列;

    private RString 通知文1;
    private RString 被保険者氏名カナ;
    private RString 被保険者氏名;
    private RString 被保険者番号;
    private RString 受付日;
    private RString 承認年月日;
    private RString 承認区分;
    private RString 不承認理由;
    private RString 事業所名;
    private RString 代表者名;
    private RString 事業所郵便番号;
    private RString 事業所所在地;
    private RString 事業所電話番号;
    private RString 利用者負担上限額;
    private RString 通知文2;

}
