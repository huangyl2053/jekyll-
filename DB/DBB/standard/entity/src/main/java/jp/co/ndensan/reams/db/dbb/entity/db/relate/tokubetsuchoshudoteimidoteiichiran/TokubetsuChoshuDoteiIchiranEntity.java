/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.tokubetsuchoshudoteimidoteiichiran;

import jp.co.ndensan.reams.ue.uex.definition.core.SeibetsuCodeNenkinTokucho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 特別徴収同定一覧情報（バッチ）のビジネス全件エンティティです。
 *
 * @reamsid_L DBB-1860-050 pengxingyi
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokubetsuChoshuDoteiIchiranEntity {

    private RString hihokenshaNo;
    private ShikibetsuCode shikibetsuCode;
    private RString kanjiShimei;
    private RString hosokuTsuki;
    private RString kisoNenkinNo;
    private RString nenkinCode;
    private RString birthDay;
    private SeibetsuCodeNenkinTokucho seibetsu;
    private RString kanjiJusho;
    private RString tokubetsuChoshuGimushaCode;
    private RString kanaShimei;
    private RString yubinNo;
    private SetaiCode setaiCode;
    private GyoseikuCode gyoseikuCode;
    private AtenaKanaMeisho kanaMeisho;
    private RString juminShubetsuCode;

}
