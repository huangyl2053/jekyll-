/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kaigokyufujuryoininkeiyakutoroku;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受領委任契約承認（不承認）確認書（事業者用）Entityクラスです。
 *
 * @reamsid_L DBC-2130-020 cuilin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigoKyufuJuryoininKeiyakuTorokuJigyoshaEntity {

    private ShikibetsuCode 識別コード;
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
    private RString 電子公印;
    private RString 発行日;
    private RString 認証者役職名;
    private RString 認証者役職名1;
    private RString 認証者役職名2;
    private RString 認証者氏名_公印に掛けない;
    private RString 認証者氏名_公印に掛ける;
    private RString 公印省略;
    private RString 公印文字列;
    private RString タイトル;
    private RString 文書1;
    private RString 被保険者氏名;
    private HihokenshaNo 被保険者番号;
    private RString 受付日;
    private RString 承認区分;
    private RString 承認年月日;
    private RString 不承認理由;
    private RString 給付の種類;
    private AtenaMeisho 事業所名;
    private AtenaMeisho 代表者氏名;
    private YubinNo 事業所郵便番号;
    private AtenaJusho 事業所所在地;
    private TelNo 事業所電話番号;
    private RString 費用額合計;
    private RString 保険対象費用額;
    private RString 利用者負担額;
    private RString 保険給付額;
    private RString 文書2;
    private RString ページ;
}
