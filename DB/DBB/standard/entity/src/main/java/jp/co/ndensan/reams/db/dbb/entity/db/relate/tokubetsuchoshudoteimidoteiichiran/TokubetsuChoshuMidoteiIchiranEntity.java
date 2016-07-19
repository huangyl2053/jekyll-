/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.tokubetsuchoshudoteimidoteiichiran;

import jp.co.ndensan.reams.ue.uex.definition.core.SeibetsuCodeNenkinTokucho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 特別徴収未同定一覧情報（バッチ）のビジネス全件エンティティです。
 *
 * @reamsid_L DBB-1860-050 pengxingyi
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokubetsuChoshuMidoteiIchiranEntity {

    private RString kisoNenkinNo;
    private RString nenkinCode;
    private RString birthDay;
    private SeibetsuCodeNenkinTokucho seibetsu;
    private RString kanaShimei;
    private RString kanjiShimei;
    private RString yubinNo;
    private RString kanjiJusho;
    private RString tokubetsuChoshuGimushaCode;
    private RString fuichiRiyuCode;
    private ShikibetsuCode shikibetsuCode;
    private RString juminShubetsuCode;
}
