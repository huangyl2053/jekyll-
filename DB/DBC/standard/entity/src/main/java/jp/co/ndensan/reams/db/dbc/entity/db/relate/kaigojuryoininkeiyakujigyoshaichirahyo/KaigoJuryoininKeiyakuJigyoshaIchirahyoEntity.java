/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kaigojuryoininkeiyakujigyoshaichirahyo;

import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 受領委任契約事業者一覧表Entity
 *
 * @reamsid_L DBC-2110-050 liuxiaoyu
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigoJuryoininKeiyakuJigyoshaIchirahyoEntity {

    private RString 事業者番号;
    private AtenaKanaMeisho 事業者名称カナ;
    private YubinNo 所在地郵便番号;
    private AtenaJusho 所在地上段;
    private FlexibleDate 契約開始日;
    private RString 振込先金融機関;
    private RString 振込先口座番号;
    private AtenaMeisho 事業者名称;
    private AtenaJusho 所在地下段;
    private RString 契約種別;
    private RString 振込先支店名;
    private AtenaMeisho 振込先名義人名;

}
