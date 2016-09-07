/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.atenasealcreate;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.BanchiCode;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 宛名シール作成Entity。
 *
 * @reamsid_L DBA-1210-030 zhengsongling
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyuNinteiShinseityuIgaiEntity {

    private ShikibetsuCode 識別コード;
    private AtenaKanaMeisho 氏名カナ;
    private RString 市町村コード;
    private AtenaMeisho 氏名;
    private RString wk管内管外区分;
    private YubinNo 郵便番号;
    private AtenaJusho 住所;
    private RString バーコード住所;
    private AtenaBanchi 番地;
    private Katagaki 方書;
    private RString 行政区;
    private RString 管内管外区分;
    private AtenaMeisho 世帯主名称;
    private RString 代納区分名称;
    private BanchiCode 番地ｺｰド;
    private GyoseikuCode 行政区ｺｰド;
    private ChikuCode 地区コード1;
    private ChikuCode 地区コード2;
    private ChikuCode 地区コード3;
    private SetaiCode 世帯ｺｰﾄﾞ;
    private ZenkokuJushoCode 住所ｺｰド;
    private HihokenshaNo 被保険者番号;
    private RString 性別;

}
